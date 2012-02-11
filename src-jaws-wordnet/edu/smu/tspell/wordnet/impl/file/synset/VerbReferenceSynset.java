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

import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.VerbSynset;
import edu.smu.tspell.wordnet.WordNetException;
import edu.smu.tspell.wordnet.WordSense;

import edu.smu.tspell.wordnet.impl.ExampleSentences;

import edu.smu.tspell.wordnet.impl.file.ReferenceSynset;
import edu.smu.tspell.wordnet.impl.file.RelationshipPointers;
import edu.smu.tspell.wordnet.impl.file.RelationshipType;
import edu.smu.tspell.wordnet.impl.file.RetrievalException;
import edu.smu.tspell.wordnet.impl.file.SenseKey;

/**
 * Reference implementation of a verb synset.
 * 
 * @author Brett Spell
 */
public class VerbReferenceSynset extends ReferenceSynset implements VerbSynset
{

	/**
	 * Provides examples of the context in which one or more of the verbs
	 * associated with this synset can be used.
	 */
	private ExampleSentences examples;

	/**
	 * Constructor that accepts verb synset properties.
	 * 
	 * @param  definition Short description / definition of the meaning.
	 * @param  examples Examples of how the synset is used.
	 * @param  senseKeys Keys of word senses associated with this synset.
	 * @param  pointers Pointers to unresolved relationships.
	 * @param  frames Sentence frames associated with this verb.
	 * @param  lexFile Lexical file that contains the synset.
	 * @param  offset Byte offset into the data file where synset is defined.
	 */
	public VerbReferenceSynset(String definition, String[] examples,
			SenseKey[] senseKeys, RelationshipPointers pointers,
			ExampleSentences frames, int lexFile, int offset)
	{
		super(SynsetType.VERB, definition, examples, senseKeys,
				pointers, lexFile, offset);
		this.examples = frames;
	}

	/**
	 * Returns the direct hypernyms (superordinates type) of this type.
	 * <br><p>
	 * For example, to "verbalize" is a hypernym of "shout".
	 * <br><p>
	 * Note: In most cases there is exactly one hypernym, but WordNet does
	 * contain verb synsets with more than one (e.g., "warm up").
	 * 
	 * @return The direct hypernyms of this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public VerbSynset[] getHypernyms() throws RetrievalException
	{
		return getVerbSynsets(RelationshipType.HYPERNYM);
	}

	/**
	 * Returns the direct hyponyms (subordinate types / troponyms)
	 * of this type.
	 * <br><p>
	 * For example, a troponym / hyponym / subordinate type of "verbalize"
	 * is "shout".
	 * 
	 * @return The list of direct hyponyms of this synset.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public VerbSynset[] getTroponyms() throws RetrievalException
	{
		return getVerbSynsets(RelationshipType.HYPONYM);
	}

	/**
	 * Returns this verb synset's entailments, which are things that this
	 * verb implies.
	 * <br><p>
	 * For example, "snore" entails "sleep".
	 * 
	 * @return Entailments associated with this synset.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public VerbSynset[] getEntailments() throws RetrievalException
	{
		return getVerbSynsets(RelationshipType.ENTAILMENT);
	}

	/**
	 * Returns the outcomes of this verb synset's action, that is things
	 * that this verb can "cause".
	 * <br><p>
	 * For example, "remind" is a cause of "remember".
	 * 
	 * @return Things that this verb synset can cause.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public VerbSynset[] getOutcomes() throws RetrievalException
	{
		return getVerbSynsets(RelationshipType.CAUSE);
	}

	/**
	 * Returns the word senses representing cases where this verb is used
	 * as part of a verb phrase ("phrasal verb").
	 * <br><p>
	 * For example, "breathe" is found in the phrases "breathe in" and
	 * "breathe out".
	 * 
	 * @param  wordForm Word form for which to return antonyms.
	 * @return Senses related to the specified word form.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public WordSense[] getPhrases(String wordForm) throws RetrievalException
	{
		return getReferences(RelationshipType.ALSO_SEE, wordForm);
	}

	/**
	 * Returns a set of verb senses that have similar meaning.
	 * <br><p>
	 * For example, "talk" and "write" belong to the same verb group.
	 * 
	 * @return Senses that have a similar meaning.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public VerbSynset[] getVerbGroup() throws RetrievalException
	{
		return getVerbSynsets(RelationshipType.VERB_GROUP);
	}

	/**
	 * Returns the sentence frames (if any) associated with this verb meaning.
	 * Sentence frames are examples of how the verb can be used / applied, and
	 * all the frames returned by this method apply to all word forms in the
	 * synset.
	 * 
	 * @return Sentence frames associated with all word forms in this synset.
	 */
	public String[] getSentenceFrames()
	{
		return examples.getCommonFrames();
	}

	/**
	 * Returns the sentence forms (if any) that are specific to a particular
	 * word form within this synset, where sentence frames are examples of
	 * how the word form can be used / applied.
	 * 
	 * @param  wordForm Word form for which to return sentence frames.
	 * @return Sentence frames that are specific to the specified word form.
	 */
	public String[] getSentenceFrames(String wordForm)
	{
		return examples.getFrames(wordForm);
	}

	/**
	 * Returns example sentences (if any) that are specific to a particular
	 * word form within this synset, where templates are examples of how the
	 * word form can be used / applied.
	 * 
	 * @param  wordForm Word form for which to return sentence templates.
	 * @return Sentence templates that are specific to the word form.
	 * @see    <a href="http://wordnet.princeton.edu/man/wndb.5WN#sect6">
	 *         Format of WordNet database files ("Verb Example Sentences")</a>
	 */
	public String[] getSentenceTemplates(String wordForm)
	{
		return examples.getFormattedTemplates(wordForm);
	}

}