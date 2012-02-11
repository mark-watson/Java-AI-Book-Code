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

/**
 * Converts values from database files into the corresponding synset
 * type.
 * 
 * @author Brett Spell
 */
public class SynsetTypeConverter
{

	/**
	 * Code used to represent noun synsets
	 */
	public final static char NOUN_CODE                = 'n';

	/**
	 * Code used to represent verb synsets
	 */
	public final static char VERB_CODE                = 'v';

	/**
	 * Code used to represent adjective synsets
	 */
	public final static char ADJECTIVE_CODE           = 'a';

	/**
	 * Code used to represent adverb synsets
	 */
	public final static char ADVERB_CODE              = 'r';

	/**
	 * Code used to represent adjective satellite synsets
	 */
	public final static char ADJECTIVE_SATELLITE_CODE = 's';

	/**
	 * Returns the synset type that corresponds to a particular numeric code.
	 * 
	 * @param  typeNumber Numeric code for which to return the type.
	 * @return Synset type matching the specified numeric code.
	 */
	public static SynsetType getType(int typeNumber)
	{
		SynsetType type = null;
		SynsetType[] types = SynsetType.ALL_TYPES;

		for (int i = 0; i < types.length; i++)
		{
			if (typeNumber == types[i].getCode())
			{
				type = types[i];
			}
		}
		return type;
	}

	/**
	 * Returns the syntactic category associated with a part of speech code.
	 * 
	 * @param  partOfSpeechCode Code identifying the part of speech for which
	 *         to return the syntactic category.
	 * @return Type associated with the specified part of speech.
	 */
	public static SynsetType getType(char partOfSpeechCode)
	{
		SynsetType type = null;

		switch (partOfSpeechCode)
		{
			case NOUN_CODE:
				type = SynsetType.NOUN;
				break;
			case VERB_CODE:
				type = SynsetType.VERB;
				break;
			case ADJECTIVE_CODE:
				type = SynsetType.ADJECTIVE;
				break;
			case ADVERB_CODE:
				type = SynsetType.ADVERB;
				break;
			case ADJECTIVE_SATELLITE_CODE:
				type = SynsetType.ADJECTIVE_SATELLITE;
				break;
			default:
				throw new IllegalArgumentException(
						"'" + partOfSpeechCode + "' is an invalid code.");
		}
		return type;
	}

}