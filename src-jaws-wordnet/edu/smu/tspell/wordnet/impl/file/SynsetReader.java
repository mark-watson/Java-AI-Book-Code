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

import edu.smu.tspell.wordnet.impl.RandomAccessReader;

import java.io.File;
import java.io.IOException;

import java.lang.ref.WeakReference;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Reads synset information from a data file (e.g., <code>data.noun</code>)
 * using a pointer. The pointer identifies the file from which to read and
 * the location within the file to begin reading and this class reads and
 * returns a line of text beginning at the specified location.
 * <br><p>
 * Note that when an instance of this class is created it opens a data file
 * and leaves it open until the instance is reclaimed by the garbage
 * collector. That provides better performance than opening the file each
 * time a read is needed.
 * <br><p>
 * An instance of this class is created for each distinct data file that's
 * read, which means that a multi-threaded application could theoretically
 * be reading from more than one data file simultaneously.
 *  
 * @author Brett Spell
 */
public class SynsetReader extends RandomAccessReader
{

	/**
	 * Maps synset types to file names.
	 */
	private final static ResourceBundle FILE_NAMES = ResourceBundle.getBundle(
			SynsetReader.class.getName());

	/**
	 * Contains references to the instances of this file that have already
	 * been created.
	 */
	private final static Map READER_MAP = new HashMap();

	/**
	 * Returns an instance of this file that can be used to read from the
	 * data file associated with a specific syntactic category.
	 * <br><p>
	 * Instances of this class are cached internally using weak references,
	 * which means that when an instance is no longer strongly accessible it
	 * becomes eligible for garbage collection. When it is finally garbage
	 * collected, the data file it was used to read from will be closed.
	 * 
	 * @param  type Synset type for which to perform reads.
	 * @return Instance of this class that can be used to read synsets.
	 */
	public synchronized static SynsetReader getInstance(SynsetType type)
	{
		SynsetReader instance = null;
		WeakReference ref = (WeakReference)(READER_MAP.get(type));
		//  If we already created an instance for this type, try to use it
		if (ref != null)
		{
			//  May return null if the referent object was garbage collected
			instance = (SynsetReader)(ref.get());
		}
		//  If we don't have an existing instance, we'll need to create one
		if (instance == null)
		{
			try
			{
				instance = new SynsetReader(getFile(type));
				//  Cache it at least temporarily
				ref = new WeakReference(instance);
				READER_MAP.put(type, ref);
			}
			catch (IOException ioe)
			{
				throw new RetrievalException(
						"Error accessing file: " + ioe.getMessage(), ioe);
			}
		}
		return instance;
	}

	/**
	 * Returns a {@link File} object that represents a WordNet data file.
	 * 
	 * @param  type Synset type for which to return a file.
	 * @return File that can be used to read synsets of the specified category.
	 */
	private static File getFile(SynsetType type)
	{
		String key = Integer.toString(type.getCode());
		String file = FILE_NAMES.getString(key);
		String dir = System.getProperty(PropertyNames.DATABASE_DIRECTORY, ".");
		return new File(dir, file);
	}

	/**
	 * Constructor that accepts a file and which ensures that instances of
	 * this class aren't created externally.
	 * 
	 * @param  file File from which this instance will read synsets.
	 * @throws IOException An error occurred opening the data file.
	 */
	private SynsetReader(File file) throws IOException
	{
		super(file);
	}

	/**
	 * Reads and returns a single line of data from the appropriate file.
	 * 
	 * @param  pointer Identifies the location from which to read the synset.
	 * @return Text that represents a line of data from the data file.
	 * @throws IOException An error occurred reading the synset data.
	 */
	public synchronized String readData(SynsetPointer pointer)
			throws IOException
	{
		seek(pointer.getOffset());
		return readToNextEndOfLine();
	}

}