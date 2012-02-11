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

import java.util.HashMap;
import java.util.Map;

/**
 * Maintains a mapping between word forms and the positions that it can
 * occupy. Currently these are only used for adjectives.
 * 
 * @author Brett Spell
 */
public class WordPositions
{

	/**
	 * Stores mappings between word forms and their specified positions.
	 */
	private Map wordMap = new HashMap();

	/**
	 * No-argument constructor.
	 */
	public WordPositions()
	{
	}

	/**
	 * Sets the position for a word.
	 * 
	 * @param  wordForm Word form for which to specify the position.
	 * @param  position Position in which the word form must occur.
	 */
	public void setPosition(String wordForm, String position)
	{
		wordMap.put(wordForm, position);
	}

	/**
	 * Returns the required position, if any, that the specified adjective
	 * must occupy relative to a noun it modifies.
	 * 
	 * @param  wordForm Word form for which to return the required syntactic
	 *         position (if one exists).
	 * @return Syntactic position that the specified word form must occupy
	 *         or <code>null</code> if there is no requirement on the
	 *         position in which it must occur.
	 */
	public String getRequiredPosition(String wordForm)
	{
		return (String)(wordMap.get(wordForm));
	}

}