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
package edu.smu.tspell.wordnet;

import edu.smu.tspell.wordnet.WordNetException;

/**
 * Represents a synset that corresponds to a verb meaning.
 * <br><p>
 * One characteristic unique to verb synsets is the inclusion of two types
 * of examples sentences that illustrate how the verbs are used.
 * <br><p>
 * The first type of example sentence is referred to as a "frame" and is
 * represented by a short, generic example of how the verb is used with
 * hyphens (dashes) representing a verb form and text in all capital letters
 * representing an unsupplied portion of text that would be present to
 * form a proper sentence. For example: <i>Somebody ---- whether INFINITIVE</i>
 * <br><p>
 * The other type of example sentence is referred to as a "template" and is
 * represented by a more real-world example with a printf()-compatible
 * substitution field ("%s") within the portion of the text where the verb
 * is inserted. For example: <i>The men %s the chairs.</i>
 * <br><p>
 * Aside from the nature of the sentences, the primary difference between
 * frames and templates is that templates are normally displayed with the
 * verb appearing in the substitution field, so for example if the verb is
 * "fix", the example template would be returned as <i>The men fix the
 * chairs.</i>.
 * 
 * @author Brett Spell
 * @see    <a href="http://wordnet.princeton.edu/5papers.pdf">Five Papers on
 *         WordNet ("English Verbs as a Semantic Net")</a>
 */
public interface VerbSynset extends Synset
{

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
	public VerbSynset[] getHypernyms() throws WordNetException;

	/**
	 * Returns the direct troponyms (hyponyms / subordinate types)
	 * of this type.
	 * <br><p>
	 * For example, "shout" is a troponym / hyponym / subordinate type of
	 * "verbalize".
	 * 
	 * @return The list of direct hyponyms of this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public VerbSynset[] getTroponyms() throws WordNetException;

	/**
	 * Returns this verb synset's entailments, which are things that this
	 * verb implies.
	 * <br><p>
	 * For example, "snore" implies "sleep".
	 * 
	 * @return Entailments associated with this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public VerbSynset[] getEntailments() throws WordNetException;

	/**
	 * Returns the outcomes of this verb synset's action, that is things
	 * that this verb can "cause".
	 * <br><p>
	 * For example, "remind" is a cause of "remember".
	 * 
	 * @return Things that this verb synset can cause.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public VerbSynset[] getOutcomes() throws WordNetException;

	/**
	 * Returns the word senses representing cases where this verb is used
	 * as part of a verb phrase ("phrasal verb").
	 * <br><p>
	 * For example, "breathe" is found in the phrases "breathe in" and
	 * "breathe out".
	 * 
	 * @param  wordForm Word form for which to return antonyms.
	 * @return Senses related to the specified word form.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public WordSense[] getPhrases(String wordForm) throws WordNetException;

	/**
	 * Returns a set of verb senses that have similar meaning.
	 * <br><p>
	 * For example, "talk" and "write" belong to the same verb group.
	 * 
	 * @return Senses that have a similar meaning.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public VerbSynset[] getVerbGroup() throws WordNetException;

	/**
	 * Identifies the topics with which this synset is associated.
	 * <br><p>
	 * For example, "bandage" is within the domain of "medicine".
	 * 
	 * @return Topics / subjects associated with this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getTopics() throws WordNetException;

	/**
	 * Identifies the regions with which this synset is associated.
	 * <br><p>
	 * For example, "judder" is a term associated with "Great Britain".
	 * 
	 * @return Regions associated with this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getRegions() throws WordNetException;

	/**
	 * Identifies the usage types associated with this synset.
	 * <br><p>
	 * For example, "play hooky" is a "slang" term.
	 * 
	 * @return Usage types associated with this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getUsages() throws WordNetException;

	/**
	 * Returns the sentence frames (if any) associated with this verb meaning.
	 * Sentence frames are examples of how the verb can be used / applied, and
	 * all the frames returned by this method apply to all word forms in the
	 * synset.
	 * 
	 * @return Sentence frames associated with all word forms in this synset.
	 * @see    <a href="http://wordnet.princeton.edu/man/wninput.5WN#sect4">
	 *         Format of Lexicographer Files ("Verb Frames")</a>
	 */
	public String[] getSentenceFrames();

	/**
	 * Returns the sentence frames (if any) that are specific to a particular
	 * word form within this synset, where sentence frames are examples of
	 * how the word form can be used / applied.
	 * 
	 * @param  wordForm Word form for which to return sentence frames.
	 * @return Sentence frames that are specific to the word form.
	 * @see    <a href="http://wordnet.princeton.edu/man/wninput.5WN#sect4">
	 *         Format of Lexicographer Files ("Verb Frames")</a>
	 */
	public String[] getSentenceFrames(String wordForm);

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
	public String[] getSentenceTemplates(String wordForm);

}