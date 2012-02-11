/*

  Java API for WordNet Searching 1.0
  Copyright (c) 2007 by Brett Spell.

  This software is being provided to you, the LICENSEE, by under the following
  license.  By obtaining, using and/or copying this software, you agree that
  you have read, understood, and will comply with these terms and conditions:
   
  Permission to use, copy, modify and distribute this software and its
  documentation for any purpose and without fee or royalty is hereby granted,
  provided that you agree to comply with the following copyright notice and
  statements, including the disclaimer, and that the same appear on ALL copies
  of the software, database and documentation, including modifications that you
  make for internal use or for distribution.

  THIS SOFTWARE AND DATABASE IS PROVIDED "AS IS" WITHOUT REPRESENTATIONS OR
  WARRANTIES, EXPRESS OR IMPLIED.  BY WAY OF EXAMPLE, BUT NOT LIMITATION,  
  LICENSOR MAKES NO REPRESENTATIONS OR WARRANTIES OF MERCHANTABILITY OR FITNESS
  FOR ANY PARTICULAR PURPOSE OR THAT THE USE OF THE LICENSED SOFTWARE OR
  DOCUMENTATION WILL NOT INFRINGE ANY THIRD PARTY PATENTS, COPYRIGHTS,
  TRADEMARKS OR OTHER RIGHTS.

 */
package edu.smu.tspell.wordnet.impl.file;

import edu.smu.tspell.wordnet.AdjectiveSynset;
import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.VerbSynset;
import edu.smu.tspell.wordnet.WordNetException;
import edu.smu.tspell.wordnet.WordSense;

import edu.smu.tspell.wordnet.impl.AbstractSynset;

/**
 * A synset implementation that supports the concept of unresolved semantic
 * and lexical relationships to other synsets. An "unresolved" relationship
 * is one for which we have identifying information for the related synset(s)
 * but have not yet converted that information into an actual reference to
 * another synset object. Conversely, a "resolved" relationship is one for
 * which the identifying information has been converted into an object
 * reference to another synset. This approach allows us to load synset
 * information without immediately loading / creating the synsets to which
 * that original one has relationships defined. In other words, we can perform
 * lazy instantiation of the related synsets only when / if a request is made
 * to access them.
 * <br><p>
 * Note that the unresolved / resolved state for a given relationship is a
 * one-way conversion. In on other words, once an unresolved relationship is
 * converted to a resolved object reference, the original relationship
 * information is assumed to no longer be needed and is dropped. As a result,
 * it's not practical (and probably isn't ever necessary) to convert a
 * resolved object reference back to an unresolved relationship. 
 * 
 * @author Brett Spell
 */
public abstract class ReferenceSynset extends AbstractSynset
{

	/**
	 * Keys of the word senses associated with this synset.
	 */
	private SenseKey[] senseKeys;

	/**
	 * Tag count associated with each word sense.
	 */
	private int[] tagCounts;

	/**
	 * Encapsulates the unresolved relationships between this synset and
	 * others.
	 */
	private RelationshipPointers pointers;

	/**
	 * Number of the lexical file associated with this synset.
	 */
	private int lexicalFileNumber;

	/**
	 * Offset into the appropriate data file where this synset is defined.
	 */
	private int offset;

	/**
	 * Encapsulates the resolved relationships between this synset and others.
	 */
	private RelationshipReferences references = new RelationshipReferences();

	/**
	 * Constructor that accepts the basic synset properties.
	 * 
	 * @param  type Type of synset this instance represents.
	 * @param  definition Short description / definition of the meaning.
	 * @param  examples Examples of how the synset is used.
	 * @param  senseKeys Keys of word senses associated with this synset.
	 * @param  pointers Unresolved relationships.
	 * @param  lexicalFile Number of the lexical file containing synset.
	 * @param  offset Byte offset into the data file where synset is defined.
	 */
	protected ReferenceSynset(SynsetType type, String definition,
			String[] examples, SenseKey[] senseKeys,
			RelationshipPointers pointers, int lexicalFile, int offset)
	{
		super(type, definition, examples);
		this.senseKeys = senseKeys;
		this.pointers = pointers;
		this.lexicalFileNumber = lexicalFile;
		this.offset = offset;

		this.tagCounts = new int[senseKeys.length];
		for (int i = 0; i < tagCounts.length; i++)
		{
			tagCounts[i] = -1;
		}
	}

	/**
	 * Retrieve the word forms.
	 * 
	 * @return Array of synonymous words and phrases.
	 */
	public String[] getWordForms()
	{
		String[] wordForms = new String[senseKeys.length];
		for (int i = 0; i < wordForms.length; i++)
		{
			wordForms[i] = senseKeys[i].getLemma();
		}
		return wordForms;
	}

	/**
	 * Returns a number that's intended to provide an approximation of how
	 * frequently the specified word form is used to represent this meaning
	 * relative to how often it's used to represent other meanings.
	 * 
	 * @param  wordForm Word form for which to return the tag count.
	 * @return Number that's used to indicate an approximate frequency of use.
	 * @throws WordNetException The specified word form is not part of this
	 *         synset.
	 * @see    <a href="http://wordnet.princeton.edu/man/cntlist.5WN">Format
	 *         of <i>cntlist</i> File.</a>
	 */
	public synchronized int getTagCount(String wordForm) throws WordNetException
	{
		int index = getWordIndex(
				TextTranslator.translateToExternalFormat(wordForm));
		if (index < 0)
		{
			throw new WordNetException("Attempted to get the tag count for '" +
					wordForm + "' from a synset that does not contain it.");
		}
		if (tagCounts[index] < 0)
		{
			SenseIndexEntry entry = getIndexEntry(senseKeys[index]);
			tagCounts[index] = entry.getTagCount();
		}
		return tagCounts[index];
	}

	/**
	 * Returns the index of the word form that matches the one specified.
	 * 
	 * @param  wordForm Word form for which to return the index.
	 * @return Index of the specified word form in this synset's word list or
	 *         -1 if the word form does not appear in this synset.
	 */
	private int getWordIndex(String wordForm)
	{
		int index = -1;
		for (int i = 0; i < senseKeys.length; i++)
		{
			if (wordForm.equalsIgnoreCase(senseKeys[i].getLemma()))
			{
				index = i;
				break;
			}
		}
		return index;
	}

	/**
	 * Identifies the lexicographer file containing the synset.
	 * 
	 * @return Lexicographer file number.
	 */
	public int getLexicalFileNumber()
	{
		return lexicalFileNumber;
	}

	/**
	 * Returns the byte position within the appropriate data file where this
	 * synset is defined.
	 * 
	 * @return Byte offset of this synset within the appropriate data file.
	 */
	public int getOffset()
	{
		return offset;
	}

	/**
	 * Returns the antonyms (words with the opposite meaning), if any,
	 * associated with a word form in this synset.
	 * <br><p>
	 * For example, an antonym of "inhale" is "exhale".
	 * 
	 * @param  wordForm Word form for which to return antonyms.
	 * @return The antonyms of this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public WordSense[] getAntonyms(String wordForm) throws WordNetException
	{
		return getReferences(RelationshipType.ANTONYM, wordForm);
	}

	/**
	 * Returns word forms that derivationally related to the one specified.
	 * <br><p>
	 * For example, a derivationally related form of "meter" is "metrical".
	 * 
	 * @param  wordForm Word form for which to return derivationally related
	 *         senses.
	 * @return Derivationally related word senses.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public WordSense[] getDerivationallyRelatedForms(String wordForm)
			throws RetrievalException
	{
		return getReferences(RelationshipType.RELATED_FORM, wordForm);
	}

	/**
	 * Returns the set of synsets that have the specified type of
	 * relationship to this synset.
	 * 
	 * @param  type Type of relationship for which to return synsets.
	 * @return Synsets that have the specified relationship type.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	protected synchronized Synset[] getSynsets(RelationshipType type)
			throws WordNetException
	{
		Synset[] synsets = (Synset[])(getReferences(type));
		if (synsets == null)
		{
			synsets = resolvePointers(type);
		}
		return synsets;
	}

	/**
	 * Returns the set of noun synsets that have the specified type of
	 * relationship to this synset.
	 * 
	 * @param  type Type of relationship for which to return noun synsets.
	 * @return Noun synsets that have the specified relationship type.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	protected synchronized NounSynset[] getNounSynsets(RelationshipType type)
			throws WordNetException
	{
		NounSynset[] nounSynsets = (NounSynset[])(getReferences(type));
		if (nounSynsets == null)
		{
			Synset[] synsets = resolvePointers(type);
			nounSynsets = new NounSynset[synsets.length];
			System.arraycopy(synsets, 0, nounSynsets, 0, synsets.length);
			putReferences(type, nounSynsets);
		}
		return nounSynsets;
	}

	/**
	 * Returns the set of verb synsets that have the specified type of
	 * relationship to this synset.
	 * 
	 * @param  type Type of relationship for which to return verb synsets.
	 * @return Verb synsets that have the specified relationship type.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	protected synchronized VerbSynset[] getVerbSynsets(RelationshipType type)
			throws WordNetException
	{
		VerbSynset[] verbSynsets = (VerbSynset[])(getReferences(type));
		if (verbSynsets == null)
		{
			Synset[] synsets = resolvePointers(type);
			verbSynsets = new VerbSynset[synsets.length];
			System.arraycopy(synsets, 0, verbSynsets, 0, synsets.length);
			putReferences(type, verbSynsets);
		}
		return verbSynsets;
	}

	/**
	 * Returns the set of adjective synsets that have the specified type of
	 * relationship to this synset.
	 * 
	 * @param  type Type of relationship for which to return adjective synsets.
	 * @return Adjective synsets that have the specified relationship type.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	protected synchronized AdjectiveSynset[] getAdjectiveSynsets(
			RelationshipType type) throws WordNetException
	{
		AdjectiveSynset[] nounSynsets =
				(AdjectiveSynset[])(getReferences(type));
		if (nounSynsets == null)
		{
			Synset[] synsets = resolvePointers(type);
			nounSynsets = new AdjectiveSynset[synsets.length];
			System.arraycopy(synsets, 0, nounSynsets, 0, synsets.length);
			putReferences(type, nounSynsets);
		}
		return nounSynsets;
	}

	/**
	 * Returns resolved references to synsets that have a semantic relationship
	 * of the specified type.
	 * 
	 * @param  type Type of relationship for which to return synsets.
	 * @return Synsets that have the specified semantic relationship.
	 */
	private Synset[] getReferences(RelationshipType type)
	{
		return references.getSemanticRelationships(type);
	}

	/**
	 * Stores the list of synsets that have a specific type of semantic
	 * relationship.
	 * 
	 * @param  type Type of relationship for which to store synset references.
	 * @param  synsets Synsets that have the specified relationship type.
	 */
	private void putReferences(RelationshipType type, Synset[] synsets)
	{
		references.putSemanticRelationships(type, synsets);
	}

	/**
	 * Converts unresolved pointers of a particular type to resolved
	 * references to the corresponding synsets.
	 * <br><p>
	 * Note that on successful completion of this method that the pointers
	 * that were resolved will be removed. This is done to reduce memory
	 * usage since the pointers are presumed to no longer be needed given
	 * that their sole purpose was to provide eventual access to their
	 * corresponding synsets.
	 * 
	 * @param  type Type of relationships to resolve and return.
	 * @return Synsets that were referenced by pointers or <code>null</code>
	 *         if no pointers existed for the specified type.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	private Synset[] resolvePointers(RelationshipType type)
			throws WordNetException
	{
		Synset[] synsets = null;
		SynsetPointer[] pointers = getPointers(type);
		if (pointers != null)
		{
			SynsetFactory factory = SynsetFactory.getInstance();
			synsets = new Synset[pointers.length];
			for (int i = 0; i < synsets.length; i++)
			{
				synsets[i] = factory.getSynset(pointers[i]);
			}
			clearPointers(type);
		}
		return synsets;
	}

	/**
	 * Returns all unresolved synset pointers for a particular relationship
	 * type.
	 * 
	 * @param  type Type of relationship for which to return pointers.
	 * @return Pointers to synsets which have the specified relationship but
	 *         for which the references have not yet been resolved.
	 */
	private SynsetPointer[] getPointers(RelationshipType type)
	{
		return pointers.getSemanticRelationships(type);
	}

	/**
	 * Removes all unresolved semantic relationships of the specified type.
	 * 
	 * @param  type Type of relationship for which to remove pointers.
	 */
	private void clearPointers(RelationshipType type)
	{
		pointers.removeAllSemanticRelationships(type);
	}

	/**
	 * Identifies the topics with which this synset is associated.
	 * <br><p>
	 * For example, "acidic" is within the domain of "chemistry".
	 * 
	 * @return Topics / subjects associated with this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getTopics() throws WordNetException
	{
		return getNounSynsets(RelationshipType.DOMAIN_TOPIC);
	}

	/**
	 * Identifies the regions with which this synset is associated.
	 * <br><p>
	 * For example, "al dente" is within the domain of "Italy".
	 * 
	 * @return Region associated with this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getRegions() throws WordNetException
	{
		return getNounSynsets(RelationshipType.DOMAIN_REGION);
	}

	/**
	 * Identifies the usage types associated with this synset.
	 * <br><p>
	 * For example, "boom box" is a "colloquialism".
	 * 
	 * @return Usage types associated with this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getUsages() throws WordNetException
	{
		return getNounSynsets(RelationshipType.DOMAIN_USAGE);
	}

	/**
	 * Returns either zero or one word sense for a particular relationship
	 * type and word form. This is used when there can't be more than one
	 * relationship of a particular type for a given word form and this code
	 * validates that cardinality, throwing an exception if it is violated.
	 * 
	 * @param  type Relationship type for which to return a word sense.
	 * @param  wordForm Word form for which to return the word sense.
	 * @return Word sense for the specified word form of the indicated type or
	 *         <code>null</code> if no such relationship exists.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	protected WordSense getSingletonSense(
			RelationshipType type, String wordForm) throws WordNetException
	{
		WordSense sense;
		WordSense[] references =
				getReferences(RelationshipType.PARTICIPLE, wordForm);
		switch (references.length)
		{
			//  Zero is ok; it means that there isn't one
			case 0:
				sense = null;
				break;
			//  One is also ok; save a reference to it
			case 1:
				sense = references[0];
				break;
			//  More than one is invalid
			default:
				throw new WordNetException(
						"Can't resolve to a exactly one reference of type " +
						type + ": " + this);
		}
		return sense;
	}

	/**
	 * Returns the lexical relationships for a particular word form.
	 * <br><p>
	 * Note that the relationships are left as pointers until they're
	 * actually retrieved for the first time, at which point they'll be
	 * resolved.
	 * 
	 * @param  type Type of relationships to return.
	 * @param  wordForm Word form for which to return lexical relationships.
	 * @return Lexical relationships of a single type for the specified word
	 *         form.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	protected synchronized WordSense[] getReferences(
			RelationshipType type, String wordForm) throws WordNetException
	{
		Synset synset;
		String[] wordForms;

		wordForm = TextTranslator.translateToExternalFormat(wordForm);
		//  Get relationship we already resolved
		WordSense[] senses = references.getLexicalRelationships(wordForm, type);
		//  If we haven't resolved them, do it now
		if (senses == null)
		{
			//  Get the lexical relationship pointers
			WordSensePointer[] sensePtrs = pointers.getLexicalRelationships(
					wordForm, type);
			//  Create a new array for the relationships
			senses = new WordSense[sensePtrs.length];
			SynsetFactory factory = SynsetFactory.getInstance();
			//  Loop through the pointers and resolve each one
			for (int i = 0; i < senses.length; i++)
			{
				//  Get (and possibly create) the synset
				synset = factory.getSynset(sensePtrs[i]);
				//  Now get the word form in the target synset
				wordForms = synset.getWordForms();
				senses[i] = new WordSense(
						wordForms[sensePtrs[i].getWordNumber() - 1], synset);
			}
			references.putLexicalRelationships(
					wordForm, type, senses);
		}
		return senses;
	}

	/**
	 * Returns the sense key that corresponds to the word at the specified
	 * index.
	 * 
	 * @param  wordIndex Index of the word form for which to return the sense
	 *         key.
	 * @return Sense key associated with the word at the specified index.
	 */
	protected SenseKey getSenseKey(int wordIndex)
	{
		return senseKeys[wordIndex];
	}

	/**
	 * Returns the entry from the sense index file that corresponds to a
	 * word sense in this synset.
	 * <br><p>
	 * Because we don't have the full sense key when we build the entries
	 * in this synset (we only have what's in the pos.data file for the
	 * synset), we'll need to check this synset's offset / pointer value
	 * with each one that's stored in the index entries. That's necessary
	 * because there can be multiple index entries that vary only by their
	 * head word information, and since we don't have the head word
	 * information we'll need to make sure that the index entry is associated
	 * with this synset by comparing offset values.
	 * 
	 * @param  senseKey Sense key for which to return the sense index entry.
	 * @return Index entry for this synset's word sense.
	 */
	protected SenseIndexEntry getIndexEntry(SenseKey senseKey)
	{
		SenseIndexEntry match = null;

		SenseIndexReader reader = SenseIndexReader.getInstance();
		SenseIndexEntry[] entries = reader.getAllEntries(
				senseKey.getPartialSenseKeyText());
		for (int i = 0; i < entries.length; i++)
		{
			if (entries[i].getSynsetOffset() == this.getOffset())
			{
				match = entries[i];
				break;
			}
		}
		return match;
	}

	/**
	 * Returns a hash code for the object.
	 * 
	 * @return Returns the numeric code associated with this instance.
	 */
	public int hashCode()
	{
		return getOffset();
	}

	/**
	 * Indicates whether some object is "equal to" this one.
	 * 
	 * @param  o The reference object with which to compare.
	 * @return <code>true</code> if this object is "equal to" the reference
	 *         one; <code>false</code> otherwise.
	 */
	public boolean equals(Object o)
	{
		boolean isEqual = false;
		if (o != null)
		{
			ReferenceSynset target = (ReferenceSynset)o;
			isEqual = ((this.getType().equals(target.getType())) &&
					(this.getOffset() == target.getOffset()));
		}
		return isEqual;
	}

	/**
	 * Returns a string representation of this object.
	 * 
	 * @return String representation of this object.
	 */
	public String toString()
	{
		String[] typeNames =
				{"Noun", "Verb", "Adjective", "Adverb", "AdjectiveSatellite"};
		StringBuffer buffer = new StringBuffer(
				typeNames[getType().getCode() - 1] + "@" + getOffset() + "[");
		String[] wordForms = getWordForms();
		for (int i = 0; i < wordForms.length; i++)
		{
			buffer.append((i > 0 ? "," : "") + wordForms[i]);
		}
		buffer.append("] - ");
		buffer.append(getDefinition());
		return buffer.toString();
	}

}