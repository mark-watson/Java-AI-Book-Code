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
 * Represents a synset that corresponds to an adjective meaning.
 * <br><p>
 * This interface includes the definition of position constants used to
 * indicate the valid position(s) where a given word form within the synset
 * may occur within a sentence.
 * 
 * @author Brett Spell
 * @see    <a href="http://wordnet.princeton.edu/5papers.pdf">Five Papers on
 *         WordNet ("Adjectives in WordNet")</a>
 */
public interface AdjectiveSynset extends Synset
{

	/**
	 * Predicate position.
	 */
	public final static String PREDICATE_POSITION = "p";

	/**
	 * Prenominal position.
	 */
	public final static String PRENOMINAL_POSITION = "a";

	/**
	 * Immediately postnominal position.
	 */
	public final static String IMMEDIATELY_POSTNOMINAL_POSITION = "ip";

	/**
	 * Returns the position that the specified adjective word form must
	 * occupy relative to a nount it modifies.
	 * 
	 * @param  wordForm Word form for which to return the required position.
	 * @return Position at which the word must occur or <code>null</code> if
	 *         there is no restriction on its position. If a restriction does
	 *         exist, the value will correspond to the one the restriction
	 *         constants, specifically
	 *         {@link AdjectiveSynset#PREDICATE_POSITION},
	 *         {@link AdjectiveSynset#PRENOMINAL_POSITION}, or
	 *         {@link AdjectiveSynset#IMMEDIATELY_POSTNOMINAL_POSITION}.
	 */
	public String getRequiredPosition(String wordForm);

	/**
	 * Returns the synsets, if any, with similar meaning.
	 * <br><p>
	 * For example, "abridged" is similar to "shortened".
	 * 
	 * @return The synsets representing meanings similar to this one.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public AdjectiveSynset[] getSimilar() throws WordNetException;

	/**
	 * The verb from which the adjective was derived if one exists.
	 * <br><p>
	 * 
	 * 
	 * @param  wordForm Word form for which to return the verb participle.
	 * @return Verb participle (the root verb from which the specified word
	 *         form was derived.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public WordSense getParticiple(String wordForm) throws WordNetException;

	/**
	 * Returns the pertainyms (words from which a word in this synset was
	 * derived) associated with a word form in this synset.
	 * <br><p>
	 * For example, a pertainym of "academic" is "academia".
	 * 
	 * @param  wordForm Word form for which to return pertainyms.
	 * @return The pertainyms of this synset or <code>null</code>.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public WordSense[] getPertainyms(String wordForm) throws WordNetException;

	/**
	 * Returns the synsets of which this adjective concept is an attribute.
	 * <br><p>
	 * For example, "accurate" is an attribute of "truth".
	 * 
	 * @return Synsets of which this adjective concept is an attribute.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getAttributes() throws WordNetException;

	/**
	 * Returns the synsets representing related ("see also") concepts.
	 * <br><p>
	 * For example, "aggressive" is related to "hostile".
	 * 
	 * @return Synsets representing concepts related to this one.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public AdjectiveSynset[] getRelated() throws WordNetException;

	/**
	 * Identifies the topics with which this synset is associated.
	 * <br><p>
	 * For example, "acidic" is within the domain of "chemistry".
	 * 
	 * @return Topics / subjects associated with this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getTopics() throws WordNetException;

	/**
	 * Identifies the regions with which this synset is associated.
	 * <br><p>
	 * For example, "al dente" is within the domain of "Italy".
	 * 
	 * @return Regions associated with this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getRegions() throws WordNetException;

	/**
	 * Identifies the usage types associated with this synset.
	 * <br><p>
	 * For example, "hot under the collar" is a "colloquialism".
	 * 
	 * @return Usage types associated with this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getUsages() throws WordNetException;

}