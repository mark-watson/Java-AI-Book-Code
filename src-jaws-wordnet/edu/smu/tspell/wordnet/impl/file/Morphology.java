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
 * Provides morphology processing for lemma to be passed to WordNet.
 * 
 * @author Brett Spell
 */
public class Morphology
{

	/**
	 * Singleton instance of this class.
	 */
	private static Morphology instance;

	/**
	 * Returns a reference to the singleton instance of this class.
	 * 
	 * @return Reference to the singleton instance of this class.
	 */
	public static synchronized Morphology getInstance()
	{
		if (instance == null)
		{
			instance = new Morphology();
		}
		return instance;
	}

	/**
	 * This constructor ensures that instances of this class can't be
	 * constructed by other classes.
	 */
	private Morphology()
	{
	}

	/**
	 * Returns lemma representing word forms that <u>might</u> be present
	 * in WordNet. For example, if "geese" is passed to this method (along
	 * with a parameter that indicates that noun forms should be returned),
	 * it will return the base form of "goose" which is located in WordNet
	 * ("geese", at least as of this writing, is not). It first tries to
	 * return the base forms corresponding to entries in the appropriate
	 * exception file but if none are found it attempts to apply the
	 * applicable detachment rules and returns any derivative word forms.
	 * <br><p>
	 * Note that this method naively applies the WordNet morphology rules
	 * to the word form specified, specifically by using the contents of
	 * the appropriate exception file(s) and by applying the rules of
	 * detachment, if any, that exist for the synset type. No attempt is
	 * made to ensure that the values returned are stored in WordNet or
	 * that they even represent valid words, which is why they're referred
	 * to as base form "candidates". That is, they may or may not represent
	 * a correct / valid base form and even a legitimate base form may not
	 * be present in WordNet. For example, passing "superheroes" to this
	 * method will cause it to return "superhero" (again assuming that noun
	 * base forms are to be returned) but at least as of WordNet 3.0 there
	 * is no entry for the word form "superhero" stored in the database.
	 * <br><p>
	 * In addition to returning valid words that aren't stored in the
	 * database this method can also return candidates that aren't valid
	 * words at all. For example, requesting the candidate verb forms for
	 * "sing" will result in the method returning "se" and "s" because two
	 * of the detachment rules for verbs are that a suffix of "ing" should
	 * be replaced with "e" and "" (the empty string).
	 * 
	 * @param  inflection Possible irregular inflection for which to return
	 *         root words candidates.
	 * @param  type Syntactic type for which to perform the lookup.
	 * @return Root word(s) from which the inflection is derived.
	 * @see    <a href="http://wordnet.princeton.edu/man/wndb.5WN#sect5">
	 *         Format of WordNet database files ("Exception List File Format")
	 *         </a>
	 * @see    <a href="http://wordnet.princeton.edu/man/morphy.7WN">
	 *         WordNet morphological processing</a>
	 */
	public String[] getBaseFormCandidates(String inflection,
			SynsetType type)
	{
		InflectionData inflections = InflectionData.getInstance();
		String[] exceptions = inflections.getBaseForms(inflection, type);
		DetachmentRules rules = DetachmentRules.getInstance();
		String[] detachments = rules.getCandidateForms(inflection, type);
		String[] candidates =
				new String[exceptions.length + detachments.length];
		System.arraycopy(exceptions, 0, candidates, 0, exceptions.length);
		System.arraycopy(detachments, 0,
				candidates, exceptions.length, detachments.length);
		return candidates;
	}

}