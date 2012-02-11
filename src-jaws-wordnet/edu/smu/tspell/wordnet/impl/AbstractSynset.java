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

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;

/**
 * An abstract Synset implementation. This provides encapsulation of some
 * of the basic properties of a synset, specifically a type / part of speech,
 * a definition, and example sentences.
 * 
 * @author Brett Spell
 */
public abstract class AbstractSynset implements Synset
{

	/**
	 * Identifies the type (e.g., noun, verb, adjective, etc.) of this
	 * synset.
	 */
	private SynsetType type;

	/**
	 * A short description / definition for this concept.
	 */
	private String definition;

	/**
	 * Example sentences showing how the word form is used (optional).
	 */
	private String[] examples;

	/**
	 * Constructor that accepts the basic synset properties.
	 * 
	 * @param  type Type of synset this instance represents.
	 * @param  definition Short description / definition of the meaning.
	 * @param  examples Examples of how the synset is used.
	 */
	protected AbstractSynset(SynsetType type, String definition,
			String[] examples)
	{
		this.type = type;
		this.definition = definition;
		this.examples = examples;
	}

	/**
	 * Retrieve the type of synset this object represents.
	 * 
	 * @return Type of synset this object represents.
	 */
	public SynsetType getType()
	{
		return type;
	}

	/**
	 * Retrieve a short description / definition of this concept.
	 * 
	 * @return Description / definition of what this synset represents.
	 */
	public String getDefinition()
	{
		return definition;
	}

	/**
	 * Retrieve sentences showing examples of how this synset is used.
	 * 
	 * @return Example sentences.
	 */
	public String[] getUsageExamples()
	{
		return examples;
	}

}