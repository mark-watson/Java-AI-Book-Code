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

/**
 * Parses a line from the <code>index.sense</code> file.
 * 
 * @author Brett Spell
 */
public class SenseIndexParser
{

	/**
	 * Delimiter used to separate major fields within a line.
	 */
	private final static String FIELD_DELIMITER = " ";

	/**
	 * No-argument constructor.
	 */
	public SenseIndexParser()
	{
        super();
	}

	/**
	 * Parses a line from the sense index file and returns an object that
	 * encapsulates the data found there.
	 * 
	 * @param  data Raw data from the sense index file.
	 * @return Representation of the entry in the index file.
	 */
	public SenseIndexEntry parse(String data)
	{
		StringTokenizer tokenizer = new StringTokenizer(data, FIELD_DELIMITER);
		//  Sense key (e.g., "eager%5:00:00:enthusiastic:00")
		String senseKeyText = tokenizer.nextToken();
		SenseKeyParser keyParser = new SenseKeyParser();
		SenseKey senseKey = keyParser.parse(senseKeyText);
		//  Synset offset (e.g., "00925000")
		int synsetOffset = Integer.parseInt(tokenizer.nextToken());
		//  Word sense number for part of speech (e.g., 2)
		int senseNumber = Integer.parseInt(tokenizer.nextToken());
		//  Tag count: number of times sense is tagged in semantic concordance
		int tagCount = Integer.parseInt(tokenizer.nextToken());

		return new SenseIndexEntry(
				senseKey, synsetOffset, senseNumber, tagCount);
	}

}