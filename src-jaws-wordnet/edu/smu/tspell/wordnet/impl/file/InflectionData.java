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

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Provides access to morphology exception data. These represent "irregular
 * inflections" and their corresponding root word(s), such as "geese" which
 * is an inflected form of the root word "goose". This is useful because in
 * some cases (as in "geese") the inflected form is not stored in WordNet but
 * the root form is available.
 * <br><p>
 * An obvious potential use of this information is to obtain "fallback"
 * words that might be used in the case where an initial attempt failed to
 * find information. For example, if an application tries to retrieve
 * synsets for "geese" but doesn't find any, it could then query the
 * morphology of the failed word which in this case would return "goose"
 * as the root and then perform a second lookup, this time using "goose".
 * <br><p>
 * Note that the <a href="http://wordnet.princeton.edu/man/wndb.5WN#sect5">
 * WordNet documentation</a> indicates that this morphology information is
 * machine-generated and contains words are not actually stored in the
 * WordNet database.
 * 
 * @author Brett Spell
 */
public class InflectionData
{

	/**
	 * Character that separates words in an exception file.
	 */
	private final static String WORD_DELIMITER = " ";

	/**
	 * Maps type codes (e.g., 1, 2, etc.) to their corresponding exception
	 * file names.
	 */
	private final static ResourceBundle TYPE_FILES = ResourceBundle.getBundle(
			InflectionData.class.getName());

	/**
	 * Singleton instance of this class.
	 */
	private static InflectionData instance;

	/**
	 * Maps words to their inflected form(s). For each entry in this map,
	 * they key is a word form string and the corresponding value is a map
	 * containing base forms for the word. Within a submap the key for
	 * each entry is a synset type and the corresponding value is an array
	 * of strings representing the base forms for that type.
	 */
	private Map inflectionMaps = new HashMap();

	/**
	 * Returns a reference to the singleton instance of this class.
	 * 
	 * @return Reference to the singleton instance of this class.
	 */
	public synchronized static InflectionData getInstance()
	{
		if (instance == null)
		{
			instance = new InflectionData();
		}
		return instance;
	}

	/**
	 * This constructor ensures that instances of this class can't be
	 * constructed by other classes.
	 * 
	 * @throws RetrievalException An error occurred reading the exception data.
	 */
	private InflectionData() throws RetrievalException
	{
		super();
		loadExceptions();
	}

	/**
	 * Reads and caches the data from the exception files.
	 * 
	 * @throws RetrievalException An error occurred reading the exception data.
	 */
	private void loadExceptions() throws RetrievalException
	{
		String keyText;
		int typeNumber;
		String fileName;
		SynsetType type;

		Enumeration keys = TYPE_FILES.getKeys();
		while (keys.hasMoreElements())
		{
			keyText = (String)(keys.nextElement());
			typeNumber = Integer.parseInt(keyText);
			fileName = TYPE_FILES.getString(keyText);
			type = SynsetTypeConverter.getType(typeNumber);
			try
			{
				loadExceptions(fileName, type);
			}
			catch (IOException ioe)
			{
				throw new RetrievalException(
						"Error reading exceptions from file " + fileName +
						": " + ioe.getMessage(), ioe);
			}
		}
	}

	/**
	 * Reads the exceptions from a single file that correspond to the
	 * exceptions for a particular synset type.
	 * 
	 * @param  fileName Name of the file to read.
	 * @param  type Syntactic type associated with the file.
	 * @throws RetrievalException An error occurred reading the exception data.
	 */
	private void loadExceptions(String fileName, SynsetType type)
			throws IOException
	{
		StringTokenizer tokenizer;
		String inflection;
		String[] baseForms;

		String dir = System.getProperty(PropertyNames.DATABASE_DIRECTORY, ".");
		File file = new File(dir, fileName);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		//  Loop through all lines in the file
		while (line != null)
		{
			//  Parse the inflected word
			tokenizer = new StringTokenizer(line, WORD_DELIMITER);
			inflection = TextTranslator.translateToExternalFormat(
					tokenizer.nextToken());
			//  Get the inflected word's base forms
			baseForms = new String[tokenizer.countTokens()];
			for (int i = 0; i < baseForms.length; i++)
			{
				baseForms[i] = TextTranslator.translateToExternalFormat(
								tokenizer.nextToken());
			}
			//  Add an entry to the list for this word
			putMorphology(inflection, baseForms, type);
			//  Try to get another line
			line = reader.readLine();
		}
		reader.close();
	}

	/**
	 * Adds an entry to the cache for the specified inflected word form and
	 * its corresponding base forms.
	 * 
	 * @param  inflection Inflected word form to store in the cache.
	 * @param  baseForms Inflected word's base forms.
	 * @param  type Synset type associated with this word and its base forms.
	 */
	private void putMorphology(String inflection, String[] baseForms,
			SynsetType type)
	{
		Map subMap = getSubMap(inflection, true);
		subMap.put(type, baseForms);
	}

	/**
	 * Retrieves the base forms for an inflected word in a particular
	 * syntactic category.
	 * 
	 * @param  wordForm Inflected word for which to retrieve base forms.
	 * @param  type Type for which to retrieve base forms.
	 * @return Base forms of the inflected word within the context of the
	 *         specified syntactic category (may be empty).
	 */
	public String[] getBaseForms(String wordForm, SynsetType type)
	{
		String[] baseForms = null;
		Map subMap = getSubMap(wordForm, false);
		if (subMap != null)
		{
			baseForms = (String[])(subMap.get(type));
		}
		return (baseForms != null ? baseForms : new String[0]);
	}

	/**
	 * Returns the map that contains information about a particular inflected
	 * word.
	 * 
	 * @param  inflection Inflected word for which to return a map.
	 * @param  shouldCreate When <code>true</code>, indicates that a new
	 *         map should be created for the word if one doesn't already
	 *         exist.
	 * @return Submap for the specified word if one existed or if none
	 *         existed and the caller indicated that one should be created.
	 *         Otherwise returns <code>null</code>.
	 */
	private Map getSubMap(String inflection, boolean shouldCreate)
	{
		String wordForm = inflection.toLowerCase();
		Map subMap = (Map)(inflectionMaps.get(wordForm));
		if ((subMap == null) && (shouldCreate))
		{
			subMap = new TreeMap();
			inflectionMaps.put(wordForm, subMap);
		}
		return subMap;
	}

}