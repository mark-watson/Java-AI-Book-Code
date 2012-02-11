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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Caches data related to sample sentences, loading and caching the data
 * file content only when it's accessed.
 * 
 * @author Brett Spell
 */
public abstract class SampleSentenceData
{

	/**
	 * Character that separates the key value from the sample sentence.
	 */
	private final static char KEY_TERMINATOR = ' ';

	/**
	 * Map that aggregates data by synset type and by key value. For each
	 * entry in this map the key is an instance of {@link SynsetType} and the
	 * corresponding value is a {@link Map}.
	 */
	private Map typeMaps = new HashMap();

	/**
	 * Maps synset types to their corresponding file names.
	 */
	private ResourceBundle bundle;

	/**
	 * No-argument constructor.
	 */
	protected SampleSentenceData()
	{
	}

	/**
	 * Returns a value from the submap that's associated with a particular
	 * synset type.
	 * 
	 * @param  type Type of synset for which to retrieve a value.
	 * @param  key Key associated with the value to return.
	 * @return Value that was stored or <code>null</code> if the data does
	 *         not exist.
	 */
	protected Object getValue(SynsetType type, Object key)
	{
		Map subMap = getSubMap(type);
		return (subMap != null ? subMap.get(key) : null);
	}

	/**
	 * Returns a map containing the data for a particular synset type.
	 * 
	 * @param  type Synset type for which to to return a sentence map.
	 * @return Map containing key / value pairs or <code>null</code> if there
	 *         values available for the specified synset type.
	 * @throws RetrievalException An error occurred reading the data.
	 */
	private synchronized Map getSubMap(SynsetType type)
			throws RetrievalException
	{
		Map subMap;
		if (!typeMaps.containsKey(type))
		{
			subMap = loadData(type);
			typeMaps.put(type, subMap);
		}
		else
		{
			subMap = (Map)(typeMaps.get(type));
		}
		return subMap;
	}

	/**
	 * Attempts to load the data for a particular synset type.
	 * 
	 * @param  type Synset type for which to load data.
	 * @return Map containing key / value pairs or <code>null</code> if there
	 *         values available for the specified synset type.
	 * @throws RetrievalException An error occurred reading the frame text file.
	 */
	private Map loadData(SynsetType type) throws RetrievalException
	{
		Map subMap = null;
		String fileName = getFileName(type);
		if (fileName != null)
		{
			try
			{
				subMap = createMap(fileName);
			}
			catch (IOException ioe)
			{
				throw new RetrievalException("Error reading file " + fileName +
						": " + ioe.getMessage(), ioe);
			}
		}
		return subMap;
	}

	/**
	 * Returns the name of the file containing data for a particular synset
	 * type.
	 * 
	 * @param  type Synset type for which to return the file name.
	 * @return Name of the file containing data for the synset type or
	 *         <code>null</code> if there is no data file for the type.
	 */
	private String getFileName(SynsetType type)
	{
		String fileName;
		ResourceBundle bundle = getBundle();
		try
		{
			fileName = bundle.getString(Integer.toString(type.getCode()));
		}
		catch (MissingResourceException mre)
		{
			fileName = null;
		}
		return fileName;
	}

	/**
	 * Returns a reference to the resource bundle that maps synset types to
	 * the names of files containing the data.
	 * 
	 * @return Resource bundle containing the type / file name mappings.
	 */
	private ResourceBundle getBundle()
	{
		if (bundle == null)
		{
			bundle = ResourceBundle.getBundle(getResourceBundleName());
		}
		return bundle;
	}

	/**
	 * Returns the name of the resource bundle that contains the synset type /
	 * data file name mappings.
	 * 
	 * @return Name of the resource bundle file that contains mappings.
	 */
	protected String getResourceBundleName()
	{
		return getClass().getName();
	}

	/**
	 * Reads a data file and returns a map that encapsulates the file's
	 * content.
	 * 
	 * @param  fileName Name of the file from which to read key / value pairs.
	 * @return Map that encapsulates the data read.
	 * @throws IOException An error occurred reading the file.
	 */
	private Map createMap(String fileName) throws IOException
	{
		int index;
		String key;
		String value;

		//  Create a map to hold the results
		Map keySentences = new HashMap();
		//  Open the file and start reading it
		File file = new File(System.getProperty(
				PropertyNames.DATABASE_DIRECTORY, "."), fileName);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		//  Loop until there are no more lines to read
		while (line != null)
		{
			//  Find out where the key ends
			index = line.indexOf(KEY_TERMINATOR);
			//  Get the key and value
			key = line.substring(0, index);
			value = line.substring(index + 1).trim();
			//  Add them to the cache and read the next line
			putKeyValuePair(keySentences, key, value);
			line = reader.readLine();
		}
		reader.close();
		return keySentences;
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
		map.put(key, value);
	}

}