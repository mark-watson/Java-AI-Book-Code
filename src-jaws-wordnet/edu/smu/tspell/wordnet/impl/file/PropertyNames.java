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
 * Names of system properties used by the application.
 * 
 * @author Brett Spell
 */
public class PropertyNames
{

	/**
	 * No-argument constructor.
	 */
	private PropertyNames()
	{
	}

	/**
	 * Identifies the location of the database directory.
	 */
	public final static String DATABASE_DIRECTORY = "wordnet.database.dir";

	/**
	 * Size of the "strong" reference cache of synsets.
	 */
	public final static String SYNSET_CACHE_SIZE = "wordnet.cache.synsets";

	/**
	 * Size of the "strong" reference cache of word forms.
	 */
	public final static String WORD_CACHE_SIZE = "wordnet.cache.words";

}