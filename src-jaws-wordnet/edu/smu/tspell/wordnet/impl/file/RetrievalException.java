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

import edu.smu.tspell.wordnet.WordNetException;

/**
 * Generated when a problem occurs retrieving data from the WordNet database.
 * 
 * @author Brett Spell
 */
public class RetrievalException extends WordNetException
{

	/**
	 * Accepts a message and the original exception.
	 * 
	 * @param  message Describes the nature of the problem.
	 * @param  cause Exception that was generated when retrieving data.
	 */
	public RetrievalException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * Accepts a message.
	 * 
	 * @param  message Describes the nature of the problem.
	 */
	public RetrievalException(String message)
	{
		this(message, null);
	}

}