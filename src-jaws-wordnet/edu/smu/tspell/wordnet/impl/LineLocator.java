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

/**
 * Finds a single line within a sorted text file. A binary search algorithm
 * is used and is designed to maximize the amount of "forwarding" reading of
 * bytes from the file in order to further improve performance.
 * <br><p>
 * Note that this class is designed for repetitive high-performance reading
 * of the file and for that reason doesn't open and close the file for each
 * retrieval. Instead, the file is opened when an instance of this class is
 * created and will not be closed until that instance is being finalized by
 * the garbage collector.
 * 
 * @author Brett Spell
 */
public class LineLocator extends RandomAccessReader {

	/**
	 * Constructs an instance of this class, specifying the file that is to
	 * be read.
	 * 
	 * @param  file File that is to be read.
	 * @throws IOException An error occurred during initialization.
	 */
	protected LineLocator(File file) throws IOException
	{
		super(file);
	}

	/**
	 * Returns a line that begins with the specified text, using a binary
	 * search algorithm to find that line if it exists. If multiple lines
	 * with the prefix are stored in the file this method will return one
	 * of them although which one will be returned is undefined. However,
	 * this method does make it easier to retrieve the surrounding lines
	 * because it ensures that the file pointer value corresponds to the
	 * byte just past the end of the line that's returned (if any). For
	 * example, suppose that a file contains the following lines:<br>
	 * <br><p>
	 * bravo<br>
	 * compute<br>
	 * computer<br>
	 * delta<br>
	 * <br><p>
	 * If this method is passed a value of "compute", it will return either
	 * the second or third line. If it returns the second line, the file
	 * pointer after this method executes will point to the third ("computer")
	 * line; on the other hand, if it returns the third line the file pointer
	 * would point to the last ("delta") line shown above. Because the file
	 * pointer location is predictable it's trivial to retrieve the lines that
	 * follow and precede the one returned. If, on the other hand, no matching
	 * line is found, the value of the file pointer at exit time is undefined.
	 * <br><p>
	 * Note also that this method is designed to maximum reading "forward"
	 * through the file instead of backwards because forward reading tends to
	 * be slightly faster.
	 * 
	 * @param  prefix String that should occur at the beginning of a line.
	 * @return A line from the file that begins with the specified string or
	 *         <code>null</code> if no such line exists.
	 * @throws IOException An error occurred reading the file.
	 */
	protected synchronized String getLine(String prefix) throws IOException
	{
		long midpoint;
		String rightHalf;
		String leftHalf;
		String currentLine;
		int comparison;

		String match = null;
		long lower = 0;
		long upper = getFileSize();
		long range = (upper - lower);
		long seekTarget = getFilePointer();
		//  Loop while we still have a part of the file to search
		while (range > 0)
		{
			//  Jump to the location in the middle of our search range
			midpoint = lower + (range / 2);
			seek(midpoint);
			//  If we're not at the beginning of the file, read the "next" line.
			if (midpoint > 0)
			{
				//  Get text that may be a fragment / portion of a line
				rightHalf = readToNextEndOfLine();
				//  Get what we KNOW will be a full line
				currentLine = readToNextEndOfLine();
				//  If we read part of the last line, there isn't one after it
				if (currentLine.length() == 0)
				{
					leftHalf = readToPriorEndOfLine(midpoint);
					currentLine = leftHalf + rightHalf;
					seek(getFileSize());
				}
			}
			//  We're at the very beginning of the file; it's a complete line
			else
			{
				currentLine = readToNextEndOfLine();
				rightHalf = "";
			}
			//  We have a line we can compare with our search target
			if (currentLine.length() > 0)
			{
				//  If it matches, we're done
				if (currentLine.startsWith(prefix))
				{
					match = currentLine;
					seekTarget = getFilePointer();
					break;
				}
				//  No match; see if it's less than or greater than
				else
				{
					comparison = prefix.compareTo(currentLine);
					//  If less than, shift lower bound
					if (comparison > 0)
					{
						lower = getFilePointer();
					}
					//  It's greater than what we're looking for
					else
					{
						//  Get remainder of partial line and compare it
						leftHalf = readToPriorEndOfLine(midpoint);
						currentLine = leftHalf + rightHalf;
						//  If the line we landed on is a match we're done
						if (currentLine.startsWith(prefix))
						{
							match = currentLine;
							seekTarget = getFilePointer() + match.length() + 1;
							break;
						}
						//  No match; see if it's less than or greater than
						comparison = prefix.compareTo(currentLine);
						//  If less than, shift lower bound
						if (comparison < 0)
						{
							upper = getFilePointer();
						}
						//  If we got here the line doesn't exist in the file
						else
						{
							break;
						}
					}
				}
			}
			//  If we got here, the line doesn't exist in the file
			else
			{
				break;
			}
			//  Adjust the range
			range = upper - lower;
		}
		//  If we have a match, make sure to point past the end of the line
		if (match != null)
		{
			seek(seekTarget);
		}
		return match;
	}

	/**
	 * Reads backwards from the specified file location to the beginning of
	 * the file or to the prior line delimiter text (whichever is encountered
	 * first) and returns the text that was read.
	 * 
	 * @param  position Byte position within the file from which to begin
	 *         reading.
	 * @return Text that was read from the file. Note that although the bytes
	 *         are read in reverse order, they will be returned by this method
	 *         in their "normal" order. In other words, even though reading
	 *         "hello" backwards will result in the "o" being read first, the
	 *         text will be returned with the "h" as the first character, "e"
	 *         as the second, etc.
	 * @throws IOException An error occurred reading the file.
	 * @see    #readToNextEndOfLine()
	 */
	protected synchronized String readToPriorEndOfLine(long position)
			throws IOException
	{
		char priorChar;

		StringBuffer buffer = new StringBuffer();
		while (position > 0)
		{
			seek(--position);
			priorChar = readNextCharacter();
			if (priorChar != LINE_SEPARATOR)
			{
				buffer.insert(0, priorChar);
			}
			else
			{
				break;
			}
		}
		return buffer.toString();
	}

}