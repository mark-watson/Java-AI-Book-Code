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
package edu.smu.tspell.wordnet;

/**
 * Uses a combination of a word form and synset to uniquely identify the
 * sense of a word. This is primarily used to represent lexical relationships
 * (that is, relationships that exist between specific word forms within
 * synsets).
 * 
 * @author Brett Spell
 */
public class WordSense
{

	/**
	 * Word form associated with this sense.
	 */
	private String wordForm;

	/**
	 * Synset that contains the word form.
	 */
	private Synset synset;

	/**
	 * Constructor that accepts a synset and word form.
	 * 
	 * @param  wordForm Word form associated with this sense.
	 * @param  synset Synset associated with this sense.
	 */
	public WordSense(String wordForm, Synset synset)
	{
		this.wordForm = wordForm;
		this.synset = synset;
	}

	/**
	 * Returns the word form associated with this sense.
	 * 
	 * @return Word form associated with this sense.
	 */
	public String getWordForm()
	{
		return wordForm;
	}

	/**
	 * Returns the synset associated with this sense.
	 * 
	 * @return Synset associated with this sense.
	 */
	public Synset getSynset()
	{
		return synset;
	}

	/**
	 * Returns a hash code for the object.
	 * 
	 * @return Returns the numeric code associated with this instance.
	 */
	public int hashCode()
	{
		return wordForm.hashCode();
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
		if ((o != null) && (o instanceof WordSense))
		{
			WordSense target = (WordSense)o;
			isEqual = ((this.getWordForm().equals(target.getWordForm())) &&
					(getSynset().equals(target.getSynset())));
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
		return "'" + getWordForm() + "' in " + getSynset().toString();
	}

}