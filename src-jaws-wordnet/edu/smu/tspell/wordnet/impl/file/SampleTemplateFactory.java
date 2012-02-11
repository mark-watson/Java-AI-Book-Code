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
 * Maintains a collection of templates associated with synsets. These
 * templates are used to provide examples of how words are used and in what
 * context(s) their use is appropriate.
 * <br><p>
 * As of WordNet 3.0, templates are available only for verb synsets.
 * 
 * @author Brett Spell
 * @see    <a href="http://wordnet.princeton.edu/man/wndb.5WN#sect6">Format
 *         of WordNet database files ("Verb Example Sentences")</a>
 */
public class SampleTemplateFactory extends SampleSentenceData
{

	/**
	 * Substitution text that's read from the database file.
	 */
	private final static String ORIGINAL_SUBSTITUTION_TEXT = "%s";

	/**
	 * Substitution text that's used in the template text that's cached.
	 */
	private final static String REPLACEMENT_SUBSTITUTION_TEXT = "{0}";

	/**
	 * Singleton instance of this class.
	 */
	private static SampleTemplateFactory instance;

	/**
	 * Returns a reference to the singleton instance of this class.
	 * 
	 * @return Reference to the singleton instance of this class.
	 */
	public static synchronized SampleTemplateFactory getInstance()
	{
		if (instance == null)
		{
			instance = new SampleTemplateFactory();
		}
		return instance;
	}

	/**
	 * This constructor ensures that instances of this class can't be
	 * constructed by other classes.
	 */
	private SampleTemplateFactory()
	{
	}

	/**
	 * Returns the sentence template associated with a particular synset type
	 * and key value.
	 * 
	 * @param  type Synset type for which to return the sentence template.
	 * @param  key Key value of the sentence to be returned.
	 * @return Sentence template associated with the specified type and key.
	 * 
	 * @throws RetrievalException An error occurred reading the frame text file.
	 */
	public String getSample(SynsetType type, String key)
			throws RetrievalException
	{
		return (String)(super.getValue(type, new Integer(key)));
	}

	/**
	 * Adds an entry to the map after replacing any instances of "%s" with
	 * {0} to facilitate message formatting. 
	 * 
	 * @param  map Map into which to put the entry.
	 * @param  key Key to use when storing the entry.
	 * @param  value Value to store in the map.
	 */
	protected void putKeyValuePair(Map map, String key, String value)
	{
		StringBuffer buffer = new StringBuffer(value);
		int index = buffer.indexOf(ORIGINAL_SUBSTITUTION_TEXT);
		while (index != -1)
		{
			buffer.replace(index, index + ORIGINAL_SUBSTITUTION_TEXT.length(),
					REPLACEMENT_SUBSTITUTION_TEXT);
			index = buffer.indexOf(ORIGINAL_SUBSTITUTION_TEXT);
		}
		map.put(new Integer(key), buffer.toString());
	}

}