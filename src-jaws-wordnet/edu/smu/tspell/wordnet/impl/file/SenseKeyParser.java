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

import java.util.StringTokenizer;

import edu.smu.tspell.wordnet.SynsetType;

/**
 * Parses text representing a sense key and returns an object that
 * encapsulates the key data.
 * 
 * @author Brett Spell
 * @see    SenseKey
 */
public class SenseKeyParser
{

	/**
	 * No-argument constructor.
	 */
	public SenseKeyParser()
	{
        super();
	}

	/**
	 * Parses text representing a sense key and returns an object that
	 * encapsulates the key data.
	 * 
	 * @param  keyText Text representing a sense key.
	 * @return An object that encapsulates the sense key data.
	 */
	public SenseKey parse(String keyText)
	{
		int index = keyText.indexOf(SenseKey.LEMMA_TERMINATOR);
		//  Lemma (e.g., "eager")
		String lemma = TextTranslator.translateToExternalFormat(
				keyText.substring(0, index));
		//  Lexical sense (e.g., "5:00:00:enthusiastic:00")
		String lexicalSense = keyText.substring(index + 1);
		StringTokenizer tokenizer =
				new StringTokenizer(lexicalSense, SenseKey.FIELD_DELIMITER);
		//  Synset type (e.g., "5")
		int synsetType = Integer.parseInt(tokenizer.nextToken());
		SynsetType type = SynsetTypeConverter.getType(synsetType);
		//  Lexical file number (e.g., "00")
		int lexFileNum = Integer.parseInt(tokenizer.nextToken());
		//  Lexical ID that combines with lemma to identify a sense
		int lexID = Integer.parseInt(tokenizer.nextToken());
		//  Head word for adjective satellite synset (e.g., "enthusiastic")
		String headLemma =
				(tokenizer.hasMoreTokens() ? tokenizer.nextToken() : null);
		//  Get the lexical ID of the head word (if there is one)
		int headID = (tokenizer.hasMoreTokens() ?
				Integer.parseInt(tokenizer.nextToken()) : -1);
		//  Create a sense key for the head synset (if there is one)
		SenseKey headKey = (headLemma != null ? new SenseKey(headLemma,
				SynsetType.ADJECTIVE, lexFileNum, headID) : null);
		//  Construct and return the key
		return new SenseKey(lemma, type, lexFileNum, lexID, headKey);
	}

}