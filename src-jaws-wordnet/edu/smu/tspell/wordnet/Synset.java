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

/**
 * A collection of one or more words and phrases ("collocations") collectively
 * referred to as "word forms" that can all share the same meaning.
 * The qualification that each one <u>can</u> share the same meaning as the
 * other word forms in the synset refers to the fact that many word forms can
 * have multiple meanings, a characteristic known as "polysemy." That is,
 * a single word can have very different meanings in different contexts and
 * it's even possible for a single word to be used as different parts of
 * speech (noun, verb, etc.) For example, "fly" can refer to an insect (noun)
 * or the act of moving through the air (a verb).
 * <br><p>
 * In addition to the word form(s) associated with it, a synset typically
 * also includes a collection of relationships based upon characteristics
 * such as antonymy (opposites, such as "up" and "down"), hyponomy / hypernymy
 * (subtype / supertype, e.g. "computer" is a subtype of "machine"), etc.
 * The specific relationships applicable to a synset depend upon the part of
 * speech associated with the concept the synset represents. In addition, two
 * different types of relationships are defined, specifically semantic and
 * lexical. A semantic relationship is one that exists between two synsets
 * and that is assumed to apply to all word forms within the synsets. In
 * contrast, a lexical relationship exists between two specific word forms
 * within two separate synsets.
 * <br><p>
 * A synset also includes a short definition and usually provides one or
 * more examples of how the word forms in the synset are used.
 * 
 * @author Brett Spell
 * @see    <a href="http://wordnet.princeton.edu/5papers.pdf">Five Papers on
 *         WordNet ("Introduction to WordNet: An On-Line Lexical Database")</a>
 */
public interface Synset
{

	/**
	 * Retrieve the type of synset this object represents.
	 * 
	 * @return Type of synset this object represents.
	 */
	public SynsetType getType();

	/**
	 * Retrieve the word forms.
	 * 
	 * @return Array of synonymous words and phrases.
	 */
	public String[] getWordForms();

	/**
	 * Returns the antonyms (words with the opposite meaning), if any,
	 * associated with a word form in this synset.
	 * <br><p>
	 * For example, "left" is an antonym of "right" (and vice-versa).
	 * 
	 * @param  wordForm Word form for which to return antonyms.
	 * @return The antonyms of the specified word sense.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public WordSense[] getAntonyms(String wordForm) throws WordNetException;

	/**
	 * Returns word forms that derivationally related to the one specified.
	 * <br><p>
	 * For example, a derivationally related form of "meter" is "metrical".
	 * 
	 * @param  wordForm Word form for which to return derivationally related
	 *         senses.
	 * @return Derivationally related word senses.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public WordSense[] getDerivationallyRelatedForms(String wordForm)
			throws WordNetException;

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
	public int getTagCount(String wordForm);

	/**
	 * Retrieve a short description / definition of this concept.
	 * 
	 * @return Description / definition of what this synset represents.
	 */
	public String getDefinition();

	/**
	 * Retrieve sentences showing examples of how this synset is used.
	 * 
	 * @return Example sentences if any are defined for the synset. If none
	 *         are defined then a zero-length array is returned.
	 */
	public String[] getUsageExamples();

}