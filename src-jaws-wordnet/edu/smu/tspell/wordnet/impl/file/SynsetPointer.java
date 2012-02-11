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
 * Defines the location where a synset definition can be found.
 * 
 * @author Brett Spell
 */
public class SynsetPointer
{

	/**
	 * Identifies the synset category, also known as the part of speech that
	 * the synset is associated with.
	 */
	private SynsetType type;

	/**
	 * Position within the data file where the synset definition begins.
	 */
	private int offset;

	/**
	 * Constructor that accepts a synset type and file position.
	 * 
	 * @param  type Part of speech associated with this synset.
	 * @param  offset Position within the file where synset definition begins.
	 */
	public SynsetPointer(SynsetType type, int offset)
	{
		this.type = type;
		this.offset = offset;
	}

	/**
	 * Returns the type of synset this pointer is associated with.
	 * 
	 * @return Type of synset associated with this pointer.
	 */
	public SynsetType getType()
	{
		return type;
	}

	/**
	 * Returns the byte position within the appropriate <code>data</code>
	 * file where the synset definition begins.
	 * 
	 * @return Position within the appropriate data file that the synset
	 *         definition begins.
	 */
	public int getOffset()
	{
		return offset;
	}

	/**
	 * Returns a hash code for the object.
	 * 
	 * @return Returns the file position associated with this instance.
	 */
	public int hashCode()
	{
		return offset;
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
		if ((o != null) && (o instanceof SynsetPointer))
		{
			SynsetPointer reference = (SynsetPointer)o;
			isEqual = ((this.getOffset() == reference.getOffset()) &&
					(this.getType().equals(reference.getType())));
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
		return getType().toString() + "@" + getOffset();
	}

}