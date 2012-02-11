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
package edu.smu.tspell.wordnet.impl.file.synset;

import edu.smu.tspell.wordnet.AdjectiveSynset;
import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordSense;

import edu.smu.tspell.wordnet.impl.file.ReferenceSynset;
import edu.smu.tspell.wordnet.impl.file.RelationshipPointers;
import edu.smu.tspell.wordnet.impl.file.RelationshipType;
import edu.smu.tspell.wordnet.impl.file.RetrievalException;
import edu.smu.tspell.wordnet.impl.file.SenseKey;
import edu.smu.tspell.wordnet.impl.file.WordPositions;

/**
 * Reference implementation of an adjective synset.
 * 
 * @author Brett Spell
 */
public class AdjectiveReferenceSynset extends ReferenceSynset
		implements AdjectiveSynset
{

	/**
	 * Used to store information about what position a word form must occupy.
	 * This may be <code>null</code> if there is no word position information
	 * for this synset.
	 * 
	 * @see <a href="http://wordnet.princeton.edu/man/wninput.5WN.html#sect6">
	 *      Format of Lexicographer Files ("Word Syntax")</a> and
	 *      <a href="http://wordnet.princeton.edu/man/wninput.5WN.html#sect10">
	 *      Format of Lexicographer Files ("Special Adjective Syntax")</a>.
	 */
	private WordPositions wordPositions;

	/**
	 * Constructor that accepts adjective synset properties.
	 * 
	 * @param  definition Short description / definition of the meaning.
	 * @param  examples Examples of how the synset is used.
	 * @param  senseKeys Keys of word senses associated with this synset.
	 * @param  pointers Pointers to unresolved relationships.
	 * @param  lexFile Lexical file that contains the synset.
	 * @param  offset Byte offset into the data file where synset is defined.
	 * @param  positions Positions that the words in this synset can occupy.
	 */
	public AdjectiveReferenceSynset(String definition, String[] examples,
			SenseKey[] senseKeys, RelationshipPointers pointers,
			int lexFile, int offset, WordPositions positions)
	{
		this(SynsetType.ADJECTIVE, definition, examples, senseKeys, pointers,
			lexFile, offset, positions);
	}

	/**
	 * Constructor that accepts the basic synset properties and that is used
	 * to construct instances of adjective and adjective satellite synsets.
	 * 
	 * @param  definition Short description / definition of the meaning.
	 * @param  examples Examples of how the synset is used.
	 * @param  senseKeys Keys of word senses associated with this synset.
	 * @param  pointers Pointers to unresolved relationships.
	 * @param  lexFile Lexical file that contains the synset.
	 * @param  offset Byte offset into the data file where synset is defined.
	 * @param  positions Positions that the words in this synset can occupy.
	 */
	AdjectiveReferenceSynset(SynsetType type, String definition,
			String[] examples, SenseKey[] senseKeys,
			RelationshipPointers pointers, int lexFile, int offset,
			WordPositions positions)
	{
		super(type, definition, examples, senseKeys, pointers, lexFile, offset);
		this.wordPositions = positions;
	}

	/**
	 * Returns the synsets, if any, with similar meaning.
	 * <br><p>
	 * For example, "abridged" is similar to "shortened".
	 * 
	 * @return The synsets representing meanings similar to this one.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public AdjectiveSynset[] getSimilar() throws RetrievalException
	{
		return getAdjectiveSynsets(RelationshipType.SIMILAR);
	}

	/**
	 * The verb from which the adjective was derived if one exists.
	 * <br><p>
	 * For example, the participle of "beaten" is "beat".
	 * 
	 * @param  wordForm Word form for which to return the verb participle.
	 * @return Verb participle (the root verb from which the specified word
	 *         form was derived.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public WordSense getParticiple(String wordForm) throws RetrievalException
	{
		return getSingletonSense(RelationshipType.PARTICIPLE, wordForm);
	}

	/**
	 * Returns the pertainyms (words from which a word in this synset was
	 * derived), if any, associated with a word form in this synset.
	 * <br><p>
	 * For example, a pertainym of "academic" is "academia".
	 * 
	 * @param  wordForm Word form for which to return pertainyms.
	 * @return The pertainyms of this synset or <code>null</code>.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public WordSense[] getPertainyms(String wordForm) throws RetrievalException
	{
		return getReferences(RelationshipType.PERTAINYM, wordForm);
	}

	/**
	 * Returns the synsets of which this adjective concept is an attribute.
	 * <br><p>
	 * For example, "accurate" is an attribute of "truth".
	 * 
	 * @return Synsets of which this adjective concept is an attribute.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public NounSynset[] getAttributes() throws RetrievalException
	{
		return getNounSynsets(RelationshipType.ATTRIBUTE);
	}

	/**
	 * Returns the synsets representing related ("see also") concepts.
	 * <br><p>
	 * For example, "aggressive" is related to "hostile".
	 * 
	 * @return Synsets representing concepts related to this one.
	 * @throws RetrievalException An error occurred retrieving data.
	 * @deprecated Use {@link #getRelatedConcepts()}.
	 */
	public AdjectiveSynset[] getRelated() throws RetrievalException
	{
		return getRelatedConcepts();
	}

	/**
	 * Returns the synsets representing related ("see also") concepts.
	 * <br><p>
	 * For example, "aggressive" is related to "hostile".
	 * 
	 * @return Synsets representing concepts related to this one.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public AdjectiveSynset[] getRelatedConcepts() throws RetrievalException
	{
		return getAdjectiveSynsets(RelationshipType.ALSO_SEE);
	}

	/**
	 * Returns the position that the specified adjective word form must
	 * occupy relative to a nount it modifies.
	 * 
	 * @param  wordForm Word form for which to return the required position.
	 * @return Position at which the word must occur or <code>null</code> if
	 *         there is no restriction on its position.
	 * @see    AdjectiveSynset
	 */
	public String getRequiredPosition(String wordForm)
	{
		return wordPositions.getRequiredPosition(wordForm);
	}

}