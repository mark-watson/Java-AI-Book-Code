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

/**
 * Performs conversion operations on text.
 * 
 * @author Brett Spell
 */
public class TextTranslator
{

	/**
	 * Word separator.
	 */
	private final static String SPACE = " ";

	/**
	 * Separates the words within a word form.
	 */
	private final static String UNDERSCORE = "_";

	/**
	 * Translates the specified text from the external format (spaces
	 * instead of underscore character) into the internal format.
	 *  
	 * @param  lemma Unmodified lemma / word form text.
	 * @return Text converted to the "internal" format.
	 */
	public static String translateToExternalFormat(String lemma)
	{
		int index;

		StringBuffer buffer = new StringBuffer(lemma);
		index = buffer.indexOf(UNDERSCORE);
		while (index != -1)
		{
			buffer.replace(index, index + 1, SPACE);
			index = buffer.indexOf(UNDERSCORE);
		}
		return buffer.toString();
	}

	/**
	 * Translates the specified text into the database format (with
	 * underscores in place of spaces).
	 *  
	 * @param  lemma Unmodified lemma / word form text.
	 * @return Text converted to the database format.
	 */
	public static String translateToDatabaseFormat(String lemma)
	{
		int index;

		StringBuffer buffer = new StringBuffer(lemma.toLowerCase());
		index = buffer.indexOf(SPACE);
		while (index != -1)
		{
			buffer.replace(index, index + 1, UNDERSCORE);
			index = buffer.indexOf(SPACE);
		}
		return buffer.toString();
	}

}