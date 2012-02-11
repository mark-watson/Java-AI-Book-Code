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
 * Uniquely identifies a word sense within the WordNet database.
 * 
 * @author Brett Spell
 */
public class SenseKey implements Comparable
{

	/**
	 * Character that indicates the end of the lemma text.
	 */
	public final static String LEMMA_TERMINATOR = "%";

	/**
	 * Character that delimits fields within sense key text.
	 */
	public final static String FIELD_DELIMITER = ":";

	/**
	 * Word form associated with this sense.
	 */
	private String lemma;

	/**
	 * Synset type of this sense.
	 */
	private SynsetType type;

	/**
	 * Lexicographer file containing the synset.
	 */
	private int lexicalFileNumber;

	/**
	 * Lexical identifier associated with this sense.
	 */
	private int lexicalID;

	/**
	 * Identifies the head word of an adjective satellite synset's head synset.
	 */
	private SenseKey headWord;

	/**
	 * Constructor that accepts a lemma, category, lexical file number, and
	 * head word.
	 * 
	 * @param  lemma Word form / lemma associated with this sense.
	 * @param  type Synset type of this sense.
	 * @param  lexicalFileNumber Number of lexical file in which sense defined.
	 * @param  lexicalID Uniquely identifies a sense within a lexical file.
	 * @param  headWord Key of head word of an adjective satellite synset.
	 */
	public SenseKey(String lemma, SynsetType type, int lexicalFileNumber,
			int lexicalID, SenseKey headWord)
	{
		this.lemma = lemma;
		this.type = type;
		this.lexicalFileNumber = lexicalFileNumber;
		this.lexicalID = lexicalID;
		this.headWord = headWord;
	}

	/**
	 * Constructor that accepts a lemma, category, lexical file number, and
	 * head word.
	 * 
	 * @param  lemma Word form / lemma associated with this sense.
	 * @param  type Synset type of this sense.
	 * @param  lexicalFileNumber Number of lexical file in which sense defined.
	 * @param  lexicalID Uniquely identifies a sense within a lexical file.
	 */
	public SenseKey(String lemma, SynsetType type, int lexicalFileNumber,
			int lexicalID)
	{
		this(lemma, type, lexicalFileNumber, lexicalID, null);
	}

	/**
	 * Returns the lemma associated with this sense.
	 * 
	 * @return Word form associated with this sense.
	 */
	public String getLemma()
	{
		return lemma;
	}

	/**
	 * Returns the synset type for this sense.
	 * 
	 * @return Synset type for this sense.
	 */
	public SynsetType getType()
	{
		return type;
	}

	/**
	 * Identifies the lexicographer file containing the synset.
	 * 
	 * @return Lexicographer file.
	 */
	public int getLexicalFileNumber()
	{
		return lexicalFileNumber;
	}

	/**
	 * Returns the lexical identifier associated with this sense.
	 * 
	 * @return Lexical identifier associated with this sense.
	 */
	public int getLexicalID()
	{
		return lexicalID;
	}

	/**
	 * Returns the key of the head word of adjective satellite synset.
	 * 
	 * @return Sense key of head word of adjective satellite synset's.
	 */
	public SenseKey getHeadWord()
	{
		return headWord;
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
			SenseKey target = (SenseKey)o;
			relativeValue = getType().compareTo(target.getType());
			if (relativeValue == 0)
			{
				relativeValue = getLemma().compareTo(target.getLemma());
				if (relativeValue == 0)
				{
					relativeValue = (getLexicalID() - target.getLexicalID());
					if (relativeValue == 0)
					{
						relativeValue = (getLexicalFileNumber() -
								target.getLexicalFileNumber());
					}
				}
			}
		}
		return relativeValue;
	}

	/**
	 * Returns a hash code for the object.
	 * 
	 * @return Returns the numeric code associated with this instance.
	 */
	public int hashCode()
	{
		return lemma.hashCode();
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
		if ((o != null) && (o instanceof SenseKey))
		{
			SenseKey target = (SenseKey)o;
			isEqual = (
					(getType().equals(target.getType())) &&
					(getLemma().equals(target.getLemma())) &&
					(getLexicalFileNumber() == target.getLexicalFileNumber()) &&
					(getLexicalID() == target.getLexicalID()));
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
		return getFullSenseKeyText();
	}

	/**
	 * Returns the sense key without included the head word portion. This
	 * version can be used to uniquely identify any word sense in the index
	 * file even if the key was constructed without the head word.
	 * 
	 * @return Sense key text minus the last two fields (and the delimiter
	 *         that separates them) that identify the head word.
	 */
	public String getPartialSenseKeyText()
	{
		String fullText = getFullSenseKeyText();
		int index = fullText.lastIndexOf(FIELD_DELIMITER);
		index = fullText.lastIndexOf(FIELD_DELIMITER, index - 1);
		return fullText.substring(0, index + 1);
	}

	/**
	 * Returns the full sense key text as it appears in the index file.
	 * 
	 * @return Full text representation of this key.
	 */
	public String getFullSenseKeyText()
	{
		return TextTranslator.translateToDatabaseFormat(getLemma()) +
				LEMMA_TERMINATOR + getLexicalSense();
	}

	/**
	 * Returns the lexical sense portion of this key.
	 * 
	 * @return Text representation of lexical sense.
	 */
	private String getLexicalSense()
	{
		return type.getCode() + FIELD_DELIMITER +
				pad(getLexicalFileNumber(), 2) + FIELD_DELIMITER +
				pad(getLexicalID(), 2) + FIELD_DELIMITER +
				(headWord != null ? headWord.getLemma() : "") + FIELD_DELIMITER+
				(headWord != null ? pad(headWord.getLexicalID(), 2) : "");
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