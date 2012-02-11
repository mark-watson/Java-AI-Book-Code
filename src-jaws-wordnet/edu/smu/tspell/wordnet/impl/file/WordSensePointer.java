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

import edu.smu.tspell.wordnet.SynsetType;

/**
 * Points to a particular word form within a synset.
 *  
 * @author Brett Spell
 */
public class WordSensePointer extends SynsetPointer
{

	/**
	 * Identifies a particular word form within a synset.
	 * <br><p>
	 * Note that this index is 1-based, not 0-based; in other words,
	 * the first word in a synset has a word number of 1, the second
	 * one a number of 2, etc.
	 */
	private int wordNumber;

	/**
	 * Constructor that accepts a synset type, file position and word number.
	 * 
	 * @param  type Synset type associated with this pointer.
	 * @param  offset Position within the file where synset definition begins.
	 * @param  wordNumber Index of the relevant word within the synset.
	 */
	public WordSensePointer(SynsetType type, int offset, int wordNumber)
	{
		super(type, offset);
		this.wordNumber = wordNumber;
	}

	/**
	 * Returns the index of the word within the target synset.
	 * <br><p>
	 * Note that this index is 1-based, not 0-based; in other words,
	 * the first word in a synset has a word number of 1, the second
	 * one a number of 2, etc.
	 * 
	 * @return Number that identifies a particular word form within a synset.
	 */
	public int getWordNumber()
	{
		return wordNumber;
	}

}