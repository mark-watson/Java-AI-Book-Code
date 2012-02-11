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
 * Represents a line / entry from the <code>sense.index</code> file.
 *
 * @author Brett Spell
 * @see <a href="http://wordnet.princeton.edu/man/senseidx.5WN">Format of
 *      the sense index file.</a>
 */
public class SenseIndexEntry implements Comparable
{

	/**
	 * Text that separates fields in a sense index entry.
	 */
	private final static String FIELD_DELIMITER = " ";

	/**
	 * Uniquely identifies a word sense within WordNet.
	 */
	private SenseKey senseKey;

	/**
	 * Offset in bytes within the data file where the synset definition is
	 * located.
	 */
	private int synsetOffset;

	/**
	 * Uniquely identifies a word sense within a lexical category.
	 */
	private int senseNumber;

	/**
	 * Number of times the sense is tagged in semantic concordance texts.
	 * <br>
	 * Note: This is the "frequency" count that's set for many (but not all)
	 * of the synsets.
	 */
	private int tagCount;

	/**
	 * Constructor that accepts various properties that are part of this class.
	 *
	 * @param  senseKey Uniquely identifies a word sense within WordNet.
	 * @param  synsetOffset Offset to the associated synset.
	 * @param  senseNumber Uniquely identifies a sense for a part of speech.
	 * @param  tagCount Number of senses ranked according to frequency.
	 */
	public SenseIndexEntry(
			SenseKey senseKey, int synsetOffset, int senseNumber, int tagCount)
	{
		this.senseKey = senseKey;
		this.synsetOffset = synsetOffset;
		this.senseNumber = senseNumber;
		this.tagCount = tagCount;
	}

	/**
	 * Returns the synset pointer associated with this index entry.
	 *
	 * @return Array containing the synset pointer associated with this entry.
	 */
	public SynsetPointer getSynsetPointer()
	{
		return new SynsetPointer(senseKey.getType(), synsetOffset);
	}

	/**
	 * Returns the sense key associated with this entry.
	 *
	 * @return Sense key associated with this index entry.
	 */
	public SenseKey getSenseKey()
	{
		return senseKey;
	}

	/**
	 * Returns the offset into the data file where the corresponding synset
	 * is located.
	 *
	 * @return Offset in bytes into the data file where the synset is located.
	 */
	public int getSynsetOffset()
	{
		return synsetOffset;
	}

	/**
	 * Returns the value that uniquely identifies a word sense within the
	 * context of a synset type / part of speech.
	 *
	 * @return Value that uniquely identifies a word sense within a category.
	 */
	public int getSenseNumber()
	{
		return senseNumber;
	}

	/**
	 * Number of senses ranked according to frequency.
	 * <br><p>
	 * Note: This is the "frequency" count that's set for many (but not all)
	 * of the synsets.
	 *
	 * @return Number of senses ranked according to frequency.
	 */
	public int getTagCount()
	{
		return tagCount;
	}

	/**
	 * Compares this object to another one to determine their relative order.
	 *
	 * @param  o The reference object with which to compare.
	 * @return A negative, zero, or positive value if this object is less
	 *         than, equal to, or greater than the reference object,
	 *         respectively.
	 */
	public int compareTo(Object o)
	{
		int relativeValue = 1;
		if (o != null)
		{
			SenseIndexEntry target = (SenseIndexEntry)o;
			//  Sort by synset type (noun, verb, adjective, adverb)
			relativeValue = senseKey.getType().compareTo(
					target.getSenseKey().getType());
			if (relativeValue == 0)
			{
				//  Sort in descending order by tag count
				relativeValue = (target.getTagCount() - this.getTagCount());
				if (relativeValue == 0)
				{
					//  Sort in ascending order by sense number
					relativeValue = this.getSenseNumber() -
							target.getSenseNumber();
					if (relativeValue == 0)
					{
						relativeValue = getSenseKey().compareTo(
								target.getSenseKey());
					}
				}
			}
		}
		return relativeValue;
	}

	/**
	 * Returns a string representation of this object.
	 * 
	 * @return String representation of this object.
	 */
	public String toString()
	{
		return senseKey.toString() + FIELD_DELIMITER +
				pad(getSynsetOffset(), 8) + FIELD_DELIMITER +
				getSenseNumber() + FIELD_DELIMITER + getTagCount();
	}

	/**
	 * Returns a text representation of the specified numeric value padded
	 * with leading zeroes if necessary so that it is at least the specified
	 * number of digits in length.
	 * 
	 * @param  value Numeric value to pad.
	 * @param  digits Minimum number of digits for the returned text.
	 * @return Numeric value padded with leading zeroes.
	 */
	private String pad(int value, int digits)
	{
		StringBuffer buffer = new StringBuffer(Integer.toString(value));
		while (buffer.length() < digits)
		{
			buffer.insert(0, '0');
		}
		return buffer.toString();
	}

}