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
import java.util.StringTokenizer;

/**
 * Maintains a mapping of word senses to sentence template keys. These are
 * used to provide sample templates for a given word form.
 * 
 * @author Brett Spell
 */
public class SampleIndexFactory extends SampleSentenceData
{

	/**
	 * Text that separates the individual index key values.
	 */
	private final static String KEY_DELIMITER = ",";

	/**
	 * Singleton instance of this class.
	 */
	private static SampleIndexFactory instance;

	/**
	 * Returns a reference to the singleton instance of this class.
	 * 
	 * @return Reference to the singleton instance of this class.
	 */
	public synchronized static SampleIndexFactory getInstance()
	{
		if (instance == null)
		{
			instance = new SampleIndexFactory();
		}
		return instance;
	}

	/**
	 * This constructor ensures that instances of this class can't be
	 * constructed by other classes.
	 */
	private SampleIndexFactory() throws RetrievalException
	{
		super();
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
		//  The key text is a sense key; parse it and create a partial key
		SenseKeyParser parser = new SenseKeyParser();
		SenseKey senseKey = parser.parse(key);
//		PartialSenseKey partialKey = new PartialSenseKey(senseKey.getLemma(),
//				senseKey.getLexicalFileNumber(), senseKey.getLexicalID());
		//  Now parse the value text; it's a list of template ID number
		StringTokenizer tokenizer = new StringTokenizer(value, KEY_DELIMITER);
		String[] sampleKeys = new String[tokenizer.countTokens()];
		for (int i = 0; i < sampleKeys.length; i++)
		{
			sampleKeys[i] = tokenizer.nextToken();
		}
		//  Store data in the map; key=partial sense key, value=string array
		map.put(senseKey, sampleKeys);
	}

	/**
	 * Get the template keys for a sense key.
	 * 
	 * @param  senseKey Word sense for which to return the ID numbers.
	 * @return Template identifiers that correspond to the specified word sense.
	 */
	public synchronized String[] getSampleKeys(SenseKey senseKey)
	{
		String[] keys =
				(String[])(super.getValue(senseKey.getType(), senseKey));
		return (keys != null ? keys : new String[0]);
	}

}