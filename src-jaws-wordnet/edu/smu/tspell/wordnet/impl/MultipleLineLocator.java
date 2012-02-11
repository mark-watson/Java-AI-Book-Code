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
package edu.smu.tspell.wordnet.impl;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

/**
 * Retrieves one or more lines from a sorted file that begin with some text.
 * 
 * @author Brett Spell
 */
public abstract class MultipleLineLocator extends LineLocator {

	/**
	 * Constructor that accepts a file name from which to read.
	 * 
	 * @param  parent Parent path name string of the file to read.
	 * @param  child Child path name string of the file to read.
	 * @throws IOException The specified file does not exist.
	 */
	public MultipleLineLocator(String parent, String child) throws IOException
	{
		super(new File(parent, child));
	}

	/**
	 * Returns all lines in the file that begin with the specified prefix.
	 * This is done by allowing the superclass to locate one of the matching
	 * lines (assuming that at least one exists). Since the superclass doesn't
	 * specify which line it will return in the case where there are multiple
	 * matches, we'll then read the lines that follow and precede the match
	 * that's returned to ensure that we get all of those lines that begin
	 * with the specified prefix.
	 * <br><p>
	 * Note that the lines will be returned in the same order in which they
	 * occur in the file.
	 * 
	 * @param  prefix Prefix to use when searching the file.
	 * @return All lines from the file that begin with the specified text.
	 *         This array will be empty (not <code>null</code>) if no matches
	 *         are found.
	 * @throws IOException An error occurred reading the file.
	 */
	protected String[] getLines(String prefix) throws IOException
	{
		return getLines(prefix, prefix);
	}

	/**
	 * Returns all lines that begin with text that is greater than or equal to
	 * the specified prefix text and is less than or equal to the specified
	 * suffix text. In other words, it returns all lines that begin with text
	 * that is "between" the first and last values, inclusive.
	 * 
	 * @param  first Text that defines the lower bound of lines to return.
	 * @param  last Text that defines the upper bound of lines to return.
	 * @return Lines that begin with text less than or equal to the upper
	 *         bound (prefix) text and is greater than or equalt ot he upper
	 *         bound (suffix) text.
	 * @throws IOException An error occurred reading the file.
	 */
	protected synchronized String[] getLines(String first, String last)
			throws IOException
	{
		//  Create a list for storing the results
		ArrayList lineList = new ArrayList();
		//  Get a matching line
		String line = getLine(first);
		//  If there was one, there may be others
		if (line != null)
		{
			lineList.add(line);
			//  Remember where the match started so we can go back later
			long start = getFilePointer() - line.length() - 2;
			//  Read following lines and add those that also match our prefix
			line = readToNextEndOfLine();
			while ((line.compareTo(last) <= 0) || (line.startsWith(last)))
			{
				lineList.add(line);
				line = readToNextEndOfLine();
			}
			//  We should read prior lines if we're not at start of the file
			if (start > 0)
			{
				//  Read prior lines and add those that also match our prefix
				line = readToPriorEndOfLine(start);
				while (line.compareTo(first) >= 0)
				{
					lineList.add(0, line);
					start -= (line.length() + 1);
					if (start < 0)
					{
						break;
					}
					line = readToPriorEndOfLine(start);
				}
			}
		}
		//  Return the matchine lines to the caller
		String[] lineArray = new String[lineList.size()];
		lineList.toArray(lineArray);
		return lineArray;
	}

}