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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Encapsulates the rules of detachment used by WordNet.
 * 
 * @author Brett Spell
 */
public class DetachmentRules
{

	/**
	 * Rules of detachment that apply to nouns.
	 */
	private final static RuleOfDetachment[] NOUN_RULES_OF_DETACHMENT =
			new RuleOfDetachment[]
	{
			new RuleOfDetachment("s", ""),
			new RuleOfDetachment("ses", "s"),
			new RuleOfDetachment("xes", "x"),
			new RuleOfDetachment("zes", "z"),
			new RuleOfDetachment("ches", "ch"),
			new RuleOfDetachment("shes", "sh"),
			new RuleOfDetachment("men", "man"),
			new RuleOfDetachment("ies", "y")
	};

	/**
	 * Rules of detachment that apply to verbs.
	 */
	private final static RuleOfDetachment[] VERB_RULES_OF_DETACHMENT =
		new RuleOfDetachment[]
	{
		new RuleOfDetachment("s", ""),
		new RuleOfDetachment("ies", "y"),
		new RuleOfDetachment("es", "e"),
		new RuleOfDetachment("es", ""),
		new RuleOfDetachment("ed", "e"),
		new RuleOfDetachment("ed", ""),
		new RuleOfDetachment("ing", "e"),
		new RuleOfDetachment("ing", "")
	};

	/**
	 * Rules of detachment that apply to adjectives.
	 */
	private final static RuleOfDetachment[] ADJECTIVE_RULES_OF_DETACHMENT =
		new RuleOfDetachment[]
	{
		new RuleOfDetachment("er", ""),
		new RuleOfDetachment("est", ""),
		new RuleOfDetachment("er", ""),
		new RuleOfDetachment("er", "")
	};

	/**
	 * Rules of detachment that apply to adverbs (none).
	 */
	private final static RuleOfDetachment[] ADVERB_RULES_OF_DETACHMENT =
		new RuleOfDetachment[]
	{
	};

	/**
	 * Maps synset categories to their corresponding detachment rules. For
	 * each entry in this map the key is an instance of {@link SynsetType}
	 * and the corresponding value is a {@link RuleOfDetachment} array.
	 */
	private final static Map CATEGORY_RULES = new HashMap();

	/**
	 * Singleton instance of this class.
	 */
	private static DetachmentRules instance;

	/**
	 * Static initializer that populates the type / rules map.
	 */
	static {
		CATEGORY_RULES.put(SynsetType.NOUN, NOUN_RULES_OF_DETACHMENT);
		CATEGORY_RULES.put(SynsetType.VERB, VERB_RULES_OF_DETACHMENT);
		CATEGORY_RULES.put(SynsetType.ADJECTIVE, ADJECTIVE_RULES_OF_DETACHMENT);
		CATEGORY_RULES.put(SynsetType.ADVERB, ADVERB_RULES_OF_DETACHMENT);
		CATEGORY_RULES.put(SynsetType.ADJECTIVE_SATELLITE,
				ADJECTIVE_RULES_OF_DETACHMENT);
	}

	/**
	 * Returns a reference to the singleton instance of this class.
	 * 
	 * @return Reference to the singleton instance of this class.
	 */
	public synchronized static DetachmentRules getInstance()
	{
		if (instance == null)
		{
			instance = new DetachmentRules();
		}
		return instance;
	}

	/**
	 * This constructor ensures that instances of this class can't be
	 * constructed by other classes.
	 */
	private DetachmentRules()
	{
		super();
	}

	/**
	 * Returns "candidate" root forms of a possibly inflected word form.
	 * In other words, given a word form that may be inflected (e.g., the
	 * plural "airplanes") and that isn't found in that form in WordNet,
	 * this method returns potential variations (e.g., "airplane") that
	 * might be successfully retrieved instead.
	 * 
	 * @param  inflection Possibly inflected word form for which to return
	 *         root candidates.
	 * @param  type Type of synset for which to apply the morphology rules.
	 * @return Variations on the specified word form that may represent a
	 *         valid root.
	 */
	public String[] getCandidateForms(String inflection, SynsetType type)
	{
		String suffix;
		String candidate;

		ArrayList candidateList = new ArrayList();
		//  Get the rules of detachment for the specified synset type
		RuleOfDetachment[] rules = getRulesOfDetachment(type);
		//  Loop through the rules and try to apply each one
		for (int i = 0; i < rules.length; i++)
		{
			suffix = rules[i].getSuffix();
			//  We have a new candidate if it ends with current rule's suffix
			if (inflection.endsWith(suffix))
			{
				//  Derive the candidate and add it to our list
				candidate = inflection.substring(0,
						inflection.length() - suffix.length()) +
						rules[i].getEnding();
				candidateList.add(candidate);
			}
		}
		//  Return the list of candidates in an array
		String[] candidateArray = new String[candidateList.size()];
		candidateList.toArray(candidateArray);
		return candidateArray;
	}

	/**
	 * Returns the rules of detachment for a particular synset type.
	 * 
	 * @param  type Synset type for which to return rules of detachment.
	 * @return Rules of detachment for the specified type of synset.
	 */
	private RuleOfDetachment[] getRulesOfDetachment(SynsetType type)
	{
		RuleOfDetachment[] rules =
				(RuleOfDetachment[])(CATEGORY_RULES.get(type));
		return (rules != null ? rules : new RuleOfDetachment[0]);
	}

	/**
	 * Encapsulates a rule of detachment.
	 * 
	 * @author Brett Spell
	 */
	private static class RuleOfDetachment
	{

		/**
		 * The suffix that can be replaced with some other text.
		 */
		private String suffix;

		/**
		 * The text with which to replace the suffix.
		 */
		private String ending;

		/**
		 * Constructor that accepts a suffix and replacement ending.
		 * 
		 * @param  suffix Suffix that can be replaced.
		 * @param  ending Replacement text for the suffix.
		 */
		public RuleOfDetachment(String suffix, String ending)
		{
			this.suffix = suffix;
			this.ending = ending;
		}

		/**
		 * Returns the suffix that can be replaced with some other text.
		 * 
		 * @return Suffix that can be replaced with some other text.
		 */
		public String getSuffix()
		{
			return suffix;
		}

		/**
		 * Returns the text with which to replace the suffix.
		 * 
		 * @return Text with which to replace the suffix.
		 */
		public String getEnding()
		{
			return ending;
		}

	}

}