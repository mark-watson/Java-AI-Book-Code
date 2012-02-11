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
 * Defines the relationship types supported by WordNet and the text used
 * to represent them within the synset definitions.
 * 
 * @author Brett Spell
 *
 */
public class RelationshipType
{

	/**
	 * Relevant types: noun, verb, adjective, adverb.
	 */
	public final static RelationshipType
			ANTONYM = new RelationshipType("!");

	/**
	 * Relevant types: noun, verb.
	 */
	public final static RelationshipType
			HYPONYM = new RelationshipType("~");

	/**
	 * Relevant types: noun, verb.
	 */
	public final static RelationshipType
			HYPERNYM = new RelationshipType("@");

	/**
	 * Relevant types: noun.
	 */
	public final static RelationshipType
			INSTANCE_HYPONYM = new RelationshipType("~i");

	/**
	 * Relevant types: noun.
	 */
	public final static RelationshipType
			INSTANCE_HYPERNYM = new RelationshipType("@i");

	/**
	 * Relevant types: noun.
	 */
	public final static RelationshipType
			PART_HOLONYM = new RelationshipType("#p");

	/**
	 * Relevant types: noun.
	 */
	public final static RelationshipType
			MEMBER_HOLONYM = new RelationshipType("#m");

	/**
	 * Relevant types: noun.
	 */
	public final static RelationshipType
			SUBSTANCE_HOLONYM = new RelationshipType("#s");

	/**
	 * Relevant types: noun.
	 */
	public final static RelationshipType
			MEMBER_MERONYM = new RelationshipType("%m");

	/**
	 * Relevant types: noun.
	 */
	public final static RelationshipType
			SUBSTANCE_MERONYM = new RelationshipType("%s");

	/**
	 * Relevant types: noun.
	 */
	public final static RelationshipType
			PART_MERONYM = new RelationshipType("%p");

	/**
	 * Relevant types: noun, adjective.
	 */
	public final static RelationshipType
			ATTRIBUTE = new RelationshipType("=");

	/**
	 * Relevant types:  noun, verb.
	 */
	public final static RelationshipType
			RELATED_FORM = new RelationshipType("+");

	/**
	 * Relevant types: noun, verb, adjective, adverb.
	 */
	public final static RelationshipType
			DOMAIN_TOPIC = new RelationshipType(";c");

	/**
	 * Relevant types: noun.
	 */
	public final static RelationshipType
			MEMBER_OF_DOMAIN_TOPIC = new RelationshipType("-c");

	/**
	 * Relevant types: noun, verb, adjective, adverb.
	 */
	public final static RelationshipType
			DOMAIN_REGION = new RelationshipType(";r");

	/**
	 * Relevant types: noun.
	 */
	public final static RelationshipType
			MEMBER_OF_DOMAIN_REGION = new RelationshipType("-r");

	/**
	 * Relevant types: noun, verb, adjective, adverb.
	 */
	public final static RelationshipType
			DOMAIN_USAGE = new RelationshipType(";u");

	/**
	 * Relevant types: noun.
	 */
	public final static RelationshipType
			MEMBER_OF_DOMAIN_USAGE = new RelationshipType("-u");

	/**
	 * Relevant types: verb.
	 */
	public final static RelationshipType
			ENTAILMENT = new RelationshipType("*");

	/**
	 * Relevant types: verb.
	 */
	public final static RelationshipType
			CAUSE = new RelationshipType(">");

	/**
	 * Relevant types: verb, adjective.
	 */
	public final static RelationshipType
			ALSO_SEE = new RelationshipType("^");

	/**
	 * Relevant types: verb.
	 */
	public final static RelationshipType
			VERB_GROUP = new RelationshipType("$");

	/**
	 * Relevant types: adjective.
	 */
	public final static RelationshipType
			SIMILAR = new RelationshipType("&");

	/**
	 * Relevant types: adjective.
	 */
	public final static RelationshipType
			PARTICIPLE = new RelationshipType("<");

	/**
	 * Relevant types: adjective.
	 */
	public final static RelationshipType
			PERTAINYM = new RelationshipType("\\");

	/**
	 * Array containing all types.
	 */
	public final static RelationshipType[] ALL_TYPES = new RelationshipType[]
	{
			ANTONYM,
			HYPERNYM,
			INSTANCE_HYPERNYM,
			HYPONYM,
			INSTANCE_HYPONYM,
			MEMBER_HOLONYM,
			SUBSTANCE_HOLONYM,
			PART_HOLONYM,
			MEMBER_MERONYM,
			SUBSTANCE_MERONYM,
			PART_MERONYM,
			ATTRIBUTE,
			RELATED_FORM,
			DOMAIN_TOPIC,
			MEMBER_OF_DOMAIN_TOPIC,
			DOMAIN_REGION,
			MEMBER_OF_DOMAIN_REGION,
			DOMAIN_USAGE,
			MEMBER_OF_DOMAIN_USAGE,
			ENTAILMENT,
			CAUSE,
			ALSO_SEE,
			VERB_GROUP,
			SIMILAR,
			PARTICIPLE,
			PERTAINYM
	};

	/**
	 * Symbol used to represent the relationship type in the synset file.
	 */
	private String symbol;

	/**
	 * Returns the relationship type that corresponds to a symbol.
	 * 
	 * @param  symbol Symbol for which to return the relationship type.
	 * @return Relationship type associated with the specified symbol or
	 *         <code>null</code> if the symbol does not correspond with a
	 *         valid relationship type.
	 */
	public static RelationshipType getRelationshipType(String symbol)
	{
		RelationshipType match = null;
		for (int i = 0; i < ALL_TYPES.length; i++)
		{
			if (symbol.equals(ALL_TYPES[i].getSymbol()))
			{
				match = ALL_TYPES[i];
				break;
			}
		}
		return match;
	}

	/**
	 * Constructor that accepts a symbol.
	 * 
	 * @param  symbol Used to represent the relationship type.
	 */
	private RelationshipType(String symbol)
	{
		this.symbol = symbol;
	}

	/**
	 * Returns a reference to the symbol used to represent this type.
	 * 
	 * @return Symbol used to represent this type.
	 */
	public String getSymbol()
	{
		return symbol;
	}

	/**
	 * Returns a hash code for the object.
	 * 
	 * @return Returns the numeric code associated with this instance.
	 */
	public int hashCode()
	{
		return symbol.hashCode();
	}

	/**
	 * Indicates whether some object is "equal to" this one.
	 * 
	 * @param  o The reference object with which to compare.
	 * @return <code>true</code> if this object is "equal to" the reference
	 *         one; <code>false</code> otherwise.
	 */
	public boolean equals(Object o)
	{
		boolean isEqual = false;
		if ((o != null) && (o instanceof RelationshipType))
		{
			RelationshipType target = (RelationshipType)o;
			isEqual = (this.symbol.equals(target.getSymbol()));
		}
		return isEqual;
	}

	/**
	 * Returns a string representation of this object.
	 * 
	 * @return String representation of this object.
	 */
	public String toString()
	{
		return getSymbol();
	}

}