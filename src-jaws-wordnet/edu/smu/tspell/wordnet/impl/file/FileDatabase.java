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

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;
import edu.smu.tspell.wordnet.WordNetException;

/**
 * Reference implementation of a file-based Java API for WordNet.
 * <br><p>
 * This is essentially a facade that delegates the requests to the appropriate
 * implementation classes.
 * 
 * @author Brett Spell
 */
public class FileDatabase extends WordNetDatabase
{

	/**
	 * No-argument constructor.
	 */
	public FileDatabase()
	{
	}

	/**
	 * Returns the synsets that contain a word form matching the specified
	 * text and optionally also those synsets containing one of that word
	 * form's variants. The caller can request that variants be retrieved
	 * by specifying that WordNet's morphology rules should be applied when
	 * determining which synsets to return. For example, if the caller
	 * requests that noun synsets be returned that contain the word form
	 * "masses" and the caller also requests that morphological processing
	 * be used, this method will return all noun synsets that contain
	 * <i>either</i> "masses" or "mass". That's due to the fact that one of
	 * WordNet's morphology rules, specifically a detachment rule, produces
	 * "mass" as a candidate form of "masses" as a result of stripping the
	 * "es" suffix.
	 * 
	 * @param  wordForm Text representing a word or collocation (phrase).
	 * @param  type Type of synsets (e.g., noun) to return; if this
	 *         argument is <code>null</code>, all synsets will be returned
	 *         that contain the specified word form.
	 * @param  useMorphology When <code>true</code>, indicates that this
	 *         method should return synsets that contain any morphological
	 *         variation of the specified word form; conversely, a value of
	 *         <code>false</code> returns in only synsets being returned that
	 *         contain the word for exactly as it is specified. In other words,
	 *         specifying <code>false</code> indicates that an exact-match-only
	 *         approach should be used to determine which synsets to return.
	 * @return Synsets that contain the specified word form.
	 *         If the category argument is specified, only synsets of that
	 *         type will be returned, otherwise all synsets containing the
	 *         form are returned.
	 * @throws WordNetException An error occurred retrieving the data.
	 */
	public Synset[] getSynsets(String wordForm, SynsetType type,
			boolean useMorphology) throws WordNetException
	{
		SynsetType[] typeArray = (type != null ?
				new SynsetType[] {type} : SynsetType.ALL_TYPES);
		WordFormLookup factory = WordFormLookup.getInstance();
		return factory.getSynsets(wordForm, typeArray, useMorphology);
	}

	/**
	 * Returns lemma representing word forms that <u>might</u> be present
	 * in WordNet. For example, if "geese" is passed to this method (along
	 * with a parameter that indicates that noun forms should be returned),
	 * it will return the base form of "goose".
	 * 
	 * @param  inflection Irregular inflection for which to return root words.
	 * @param  type Syntactic type for which to perform the lookup.
	 * @return Root word(s) from which the inflection is derived.
	 * @see    Morphology
	 */
	public String[] getBaseFormCandidates(String inflection, SynsetType type)
	{
		Morphology morphology = Morphology.getInstance();
		return morphology.getBaseFormCandidates(inflection, type);
	}

}