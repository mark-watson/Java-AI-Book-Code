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

import edu.smu.tspell.wordnet.impl.MultipleLineLocator;

import java.io.IOException;

import java.lang.ref.WeakReference;

/**
 * Locates entries in the <code>index.sense</code> file.
 * 
 * @author Brett Spell
 */
public class SenseIndexReader extends MultipleLineLocator
{

	/**
	 * Name of the sense index file.
	 */
	private final static String SENSE_INDEX_FILE = "index.sense";

	/**
	 * Text that indicates the end of the lemma / word form at the beginning
	 * of each line in the index file.
	 */
	private final static String LEMMA_TERMINATOR = "%";

	/**
	 * Reference to the singleton instance of this class.
	 */
	private static WeakReference reference;

	/**
	 * Used to parse lines read from the sense index file.
	 */
	private SenseIndexParser parser = new SenseIndexParser();

	/**
	 * Returns a reference to the singleton instance of this class.
	 * 
	 * @return Singleton instance of this class.
	 * @throws RetrievalException An error occurred opening the index file.
	 */
	public synchronized static SenseIndexReader getInstance()
			throws RetrievalException
	{
		SenseIndexReader instance = null;
		//  See if there's one we can get to through the weak reference
		if (reference != null)
		{
			instance = (SenseIndexReader)(reference.get());
		}
		//  It was either garbage collected or never created in the first place
		if (instance == null)
		{
			//  Create a new one and create a weak reference to it
			try
			{
				instance = new SenseIndexReader();
				reference = new WeakReference(instance);
			}
			catch (IOException ioe)
			{
				throw new RetrievalException(
						"Error opening index file: " + ioe.getMessage(), ioe);
			}
		}
		return instance;
	}

	/**
	 * This constructor ensures that instances of this class can't be
	 * constructed by other classes.
	 */
	private SenseIndexReader() throws IOException
	{
		super(System.getProperty(PropertyNames.DATABASE_DIRECTORY, "."),
				SENSE_INDEX_FILE);
	}

	/**
	 * Returns the entry that contains the specified prefix. This should be
	 * used when it's expected that there will be exactly one (or no) matching
	 * entry and this method will throw an exception if it doesn't find exactly
	 * one matching occurrence.
	 * 
	 * @param  prefix Prefix of the line to return.
	 * @return Entry from the sense index file that contains the prefix.
	 * @throws RetrievalException An error occurred reading the index file or
	 *         more than one entry was found that matched the specified prefix.
	 */
	public SenseIndexEntry getEntry(String prefix) throws RetrievalException
	{
		SenseIndexEntry[] entries = getAllEntries(prefix);
		if (entries.length != 1)
		{
			throw new RetrievalException("Expected to find exactly one line " +
					"that begins with '" + prefix + "' but found + " +
					entries.length);
		}
		return entries[0];
	}

	/**
	 * Given a word form, returns all entries from the index file that begin
	 * with the specified lemma text.
	 * <br><p>
	 * Note that before comparing the specified text to lines of the index
	 * file, the lemma text will be converted to the appropriate format to
	 * ensure that only lines in the file with that lemma are returned. In
	 * other words, the specified text will be converted to all lower case
	 * characters and appended with the lemma terminator ("%") character
	 * before searching the index file for matching lines.
	 * <br><p>
	 * The method also allows the caller to specify a type code that will
	 * (if specified) result in only entries of the specified synset type
	 * being returned.
	 * 
	 * @param  lemma Lemma for which to return index file lines.
	 * @return All entries that begin with the specified lemma.
	 * @throws RetrievalException An error occurred reading the index file.
	 */
	public SenseIndexEntry[] getLemmaEntries(String lemma)
			throws RetrievalException
	{
		return getAllEntries(TextTranslator.translateToDatabaseFormat(lemma) +
				LEMMA_TERMINATOR);
	}

	/**
	 * Given a word form, returns all entries from the index file that begin
	 * with the specified text. No modifications or additions are made to the
	 * specified prefix before it is compared with the index file lines, so
	 * only those that match it exactly will be returned.
	 * 
	 * @param  prefix Prefix for which to return index file lines.
	 * @return All entries that begin with the specified text.
	 * @throws RetrievalException An error occurred reading the index file.
	 */
	public SenseIndexEntry[] getAllEntries(String prefix)
			throws RetrievalException
	{
		SenseIndexEntry[] entries;
		try
		{
			//  Get all index file lines associated with the word form
			String[] lines = super.getLines(prefix);
			entries = new SenseIndexEntry[lines.length];
			for (int i = 0; i < entries.length; i++)
			{
				entries[i] = parser.parse(lines[i]);
			}
		}
		catch (IOException ioe)
		{
			throw new RetrievalException(
					"Error reading index file: " + ioe.getMessage(), ioe);
		}
		return entries;
	}

}