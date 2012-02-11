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

import java.util.Map;

import edu.smu.tspell.wordnet.SynsetType;

/**
 * Maintains a collection of generic sentence frames that are associated with
 * synsets. These "frames" are used to provide examples of how words are used
 * and in what context(s) their use is appropriate.
 * <br><p>
 * As of WordNet 3.0, templates are available only for verb synsets.
 * 
 * @author Brett Spell
 * @see    <a href="http://wordnet.princeton.edu/man/wninput.5WN#sect4">Format
 *         of Lexicographer Files ("Verb Frames")</a>
 */
public class SampleFrameFactory extends SampleSentenceData
{

	/**
	 * Singleton instance of this class.
	 */
	private static SampleFrameFactory instance;

	/**
	 * Returns a reference to the singleton instance of this class.
	 * 
	 * @return Reference to the singleton instance of this class.
	 */
	public static synchronized SampleFrameFactory getInstance()
	{
		if (instance == null)
		{
			instance = new SampleFrameFactory();
		}
		return instance;
	}

	/**
	 * This constructor ensures that instances of this class can't be
	 * constructed by other classes.
	 */
	private SampleFrameFactory()
	{
	}

	/**
	 * Adds an entry to the map.
	 * 
	 * @param  map Map into which to put the entry.
	 * @param  key Key to use when storing the entry.
	 * @param  value Value to store in the map.
	 */
	protected void putKeyValuePair(Map map, String key, String value)
	{
		map.put(new Integer(key), value);
	}

	/**
	 * Returns the sentence frame associated with a particular synset type
	 * and key value.
	 * 
	 * @param  type Synset type for which to return the sample sentence.
	 * @param  key Key value of the sentence to be returned.
	 * @return Sample sentence associated with the specified type and key.
	 * 
	 * @throws RetrievalException An error occurred reading the frame text file.
	 */
	public String getSample(SynsetType type, String key)
			throws RetrievalException
	{
		return (String)(super.getValue(type, new Integer(key)));
	}

}