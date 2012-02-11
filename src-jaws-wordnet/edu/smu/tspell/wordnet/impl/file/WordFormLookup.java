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
import edu.smu.tspell.wordnet.WordNetException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

/**
 * This is the main class that's used to perform lookups based upon a word
 * form.
 * <br><p>
 * A cache is maintained that allows for fast retrieval of synsets for words
 * on which a retrieval has already been performed. Specifically the caching
 * is done with a weak hash map using the word form as the key, which means
 * that as long as the caller maintains a strong reference to the string the
 * corresponding synsets will contain to be quickly accessible via the cache.
 * However, when no more (strong) references exist to the word form, its data
 * becomes eligible for garbage collection and may not be available as quickly
 * upon subsequent calls to this class. In that case the data will still be
 * returned, but it will be necessary to again read it from the database
 * instead of from the cache.
 *
 * @author Brett Spell
 * @see <a href="http://java.sun.com/developer/technicalArticles/ALT/RefObj/">
 *      Reference Objects and Garbage Collection</a>
 */
public class WordFormLookup
{

	/**
	 * Default number of synsets to cache.
	 */
	private final static int DEFAULT_CACHE_SIZE = 500;

	/**
	 * Number of word forms that will be cached.
	 */
	private static int cacheSize = DEFAULT_CACHE_SIZE;

	/**
	 * Singleton instance of this class.
	 */
	private static WordFormLookup instance;

	/**
	 * Map in which the retrieved data is cached.
	 */
	private Map wordCategories = new WeakHashMap();

	/**
	 * Maintains "strong" references to the word forms to ensure that they
	 * don't get garbage collected.
	 */
	private LeastRecentlyUsedCache cache =
			new LeastRecentlyUsedCache(cacheSize);

	/**
	 * Static initializer that updates the cache size if one was specified.
	 */
	static
	{
		String propertyName = PropertyNames.WORD_CACHE_SIZE;
		String propertyValue = System.getProperty(propertyName);
		if (propertyValue != null)
		{
			try
			{
				cacheSize = Integer.parseInt(propertyValue);
			}
			catch (NumberFormatException nfe)
			{
				System.err.println("'" + propertyValue + "' is an invalid " +
						"value for " + propertyName + " and will be ignored.");
			}
		}
	}

	/**
	 * Returns a reference to the singleton instance of this class.
	 *
	 * @return Singleton instance of this class.
	 */
	public synchronized static WordFormLookup getInstance()
	{
		if (instance == null)
		{
			instance = new WordFormLookup();
		}
		return instance;
	}

	/**
	 * This constructor ensures that instances of this class can't be
	 * constructed by other classes.
	 */
	private WordFormLookup()
	{
	}

	/**
	 * Returns only the synsets of the specified types (e.g., noun) that
	 * contain a word form matching the specified text and / or possibly
	 * synsets that contain one of that word form's variants. The caller
	 * can request that variants be by specifying that WordNet's morphology
	 * rules should be applied when determining which synsets to return. For
	 * example, if the caller requests that noun synsets be returned that
	 * contain the word form "masses" and the caller also requests that
	 * morphological processing be used, this method will return all noun
	 * synsets that contain <i>either</i> "masses" or "mass". That's due to
	 * the fact that one of WordNet's morphology rules, specifically a
	 * detachment rule, produces "mass" as a candidate form of "masses" as
	 * a result of stripping the "es" suffix.
	 * 
	 * @param  wordForm Text representing a word or collocation (phrase).
	 * @param  types Types of synsets (e.g., noun) to return.
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
	public synchronized Synset[] getSynsets(
			String wordForm, SynsetType[] types, boolean useMorphology)
			throws WordNetException
	{
		Synset[] synsetArray;
		String[] candidates;

		//  Create the list that will hold the results
		List synsetList = new ArrayList();
		//  Loop through the synset types
		for (int i = 0; i < types.length; i++)
		{
			//  Get all synsets for the current type
			synsetArray = getSynsets(wordForm, types[i]);
			for (int j = 0; j < synsetArray.length; j++)
			{
				//  Add (non-duplicate) synsets to the list
				if (!synsetList.contains(synsetArray[j]))
				{
					synsetList.add(synsetArray[j]);
				}
			}
			//  Does caller also want synsets containing base form candidates?
			if (useMorphology)
			{
				//  Find possible base forms and loop through each one
				candidates = getBaseFormCandidates(wordForm, types[i]);
				for (int j = 0; j < candidates.length; j++)
				{
					//  Get synsets for the candidate and loop through them
					synsetArray = getSynsets(candidates[j], types[i]);
					for (int k = 0; k < synsetArray.length; k++)
					{
						//  Add (non-duplicate) synsets to the list
						if (!synsetList.contains(synsetArray[k]))
						{
							synsetList.add(synsetArray[k]);
						}
					}
				}
			}
		}
		//  Convert the list to an array and return it
		synsetArray = new Synset[synsetList.size()];
		synsetList.toArray(synsetArray);
		return synsetArray;
	}

	/**
	 * Returns the synsets of a particular type (e.g., noun) that contain a
	 * specific word form.
	 * <br><p>
	 * This method first tries to retrieve the synsets from the cache but if
	 * they are not found there will attempt to read them from the database.
	 *
	 * @param  wordForm Word form for which to return containing synsets.
	 * @param  type Type of synsets to be returned.
	 * @return Synsets of a single type that contain the specified word form.
	 * @throws WordNetException An error occurred retrieving the synsets.
	 */
	private Synset[] getSynsets(String wordForm, SynsetType type)
	{
		int count;

		//  Create a list to hold the synsets we'll return
		List synsetList = new ArrayList();
		//  Get the map that contains a List per synset type
		Map subMap = (Map)(wordCategories.get(wordForm));
		//  If there isn't already one, load them now
		if (subMap == null)
		{
			subMap = loadSynsets(wordForm);
			wordCategories.put(wordForm, subMap);
			cache.put(wordForm, wordForm);
		}
		//  Get the synsets for this type
		List typeList = (List)(subMap.get(type));
		//  If there are some, add them to the list
		if (typeList != null)
		{
			//  Find out how many there are
			count = typeList.size();
			//  Loop through list of synsets
			for (int j = 0; j < count; j++)
			{
				//  Add each one to the list if it isn't already there
				if (!synsetList.contains(typeList.get(j)))
				{
					synsetList.add(typeList.get(j));
				}
			}
		}
		//  Convert the list to an array and return it
		Synset[] synsetArray = new Synset[synsetList.size()];
		synsetList.toArray(synsetArray);
		return synsetArray;
	}

	/**
	 * Loads from the database all synsets from the database that contain a
	 * particular word form.
	 *
	 * @param  wordForm Word form for which to return synsets.
	 * @return Newly created map containing the synset entries for the word.
	 */
	private Map loadSynsets(String wordForm) throws WordNetException
	{
		Synset synset;
		SynsetType type;
		List categoryList;

		//  Create a new entry for the word form in the map
		Map subMap = new TreeMap();
		//  Read lines from the sense index that correspond to the word form
		SenseIndexReader reader = SenseIndexReader.getInstance();
		SenseIndexEntry[] indexEntries = reader.getLemmaEntries(wordForm);
		Arrays.sort(indexEntries);

		SynsetFactory factory = SynsetFactory.getInstance();
		//  Loop through the list of index entries
		for (int i = 0; i < indexEntries.length; i++)
		{
			synset = factory.getSynset(indexEntries[i].getSynsetPointer());
			type = synset.getType();
			//  Also add the new synset to our cache
			categoryList = (List)(subMap.get(type));
			//  If this is the first one, create a new list and store it
			if (categoryList == null)
			{
				categoryList = new ArrayList();
				subMap.put(type, categoryList);
			}
			//  Add current synset to the list for its type
			categoryList.add(synset);
		}
		return subMap;
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
	private String[] getBaseFormCandidates(String inflection, SynsetType type)
	{
		Morphology morphology = Morphology.getInstance();
		return morphology.getBaseFormCandidates(inflection, type);
	}

}