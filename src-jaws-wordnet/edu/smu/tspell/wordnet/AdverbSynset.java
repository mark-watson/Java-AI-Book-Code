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
 * Represents a synset that corresponds to an adverb meaning.
 * 
 * @author Brett Spell
 */
public interface AdverbSynset extends Synset
{

	/**
	 * Returns the pertainyms (adjectives from which this adverb was derived),
	 * if any, associated with a word form in this synset.
	 * <br><p>
	 * For example, a pertainym of "genuinely" is "genuine".
	 * 
	 * @param  wordForm Word form for which to return pertainyms.
	 * @return The pertainyms of this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public WordSense[] getPertainyms(String wordForm) throws WordNetException;

	/**
	 * Identifies the topics with which this synset is associated.
	 * 
	 * @return Topics / subjects associated with this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getTopics() throws WordNetException;

	/**
	 * Identifies the regions with which this synset is associated.
	 * 
	 * @return Regions associated with this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getRegions() throws WordNetException;

	/**
	 * Identifies the usage types associated with this synset.
	 * 
	 * @return Usage types associated with this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getUsages() throws WordNetException;

}