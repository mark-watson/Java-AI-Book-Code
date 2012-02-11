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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Encapsulates relationship pointers for a synset and its words. These
 * may be used, for example, when a synset is first read from disk to
 * represent the synset's relationships to other synsets without loading /
 * instantiating those synsets. In other words, by maintaining a list of
 * pointers, we can load related synsets only when they're actually needed.
 * 
 * @author Brett Spell
 * @see <a href="http://wordnet.princeton.edu/man/wninput.5WN#sect3">Format
 *      of Lexicographer Files ("Pointers")</a>
 */
public class RelationshipPointers
{

	/**
	 * The "key" value used to represent semantic relationships. This allows
	 * us to treat semantic and lexical relationships essentially the same
	 * way, where the key value for semantic relationships is the constant
	 * defined here and the key value for each lexical relationship is the
	 * word form associated with the relationship.
	 */
	private final static String SYNSET_KEY = "*";

	/**
	 * Maintains information about lexical and semantic relationships. For
	 * each entry in the map, the key is either a word form (for lexical
	 * relationships) or an arbitrarily selected string that's used to
	 * represent synset / semantic relationships.
	 * 
	 * @see #SYNSET_KEY
	 */
	private Map sourceMaps = new HashMap();

	/**
	 * No-argument constructor.
	 */
	public RelationshipPointers()
	{
	}

	/**
	 * Adds a semantic relationship.
	 * 
	 * @param  type Type of relationship to add.
	 * @param  pointer Pointer to the associated synset.
	 */
	public void addSemanticRelationship(
			RelationshipType type, SynsetPointer pointer)
	{
		add(SYNSET_KEY, type, pointer);
	}

	/**
	 * Adds a lexical relationship.
	 * 
	 * @param  wordForm Source word for which to add a relationship.
	 * @param  type Type of relationship to add.
	 * @param  pointer Pointer to the associated synset.
	 */
	public void addLexicalRelationship(String wordForm, RelationshipType type,
			WordSensePointer pointer)
	{
		add(wordForm, type, pointer);
	}

	/**
	 * Adds a (semantic or lexical) relationship value.
	 * 
	 * @param  key Key value to use for storing the relationship.
	 * @param  type Type of relationship to add.
	 * @param  value Value to store for the relationship.
	 */
	private void add(Object key, RelationshipType type,
			Object value)
	{
		Map subMap = getSubMap(key, true);
		List list = (List)(subMap.get(type));
		if (list == null)
		{
			list = new ArrayList();
			subMap.put(type, list);
		}
		list.add(value);
	}

	/**
	 * Returns the semantic relationships of a particular type.
	 * 
	 * @param  type Type of relationships to be returned.
	 * @return Relationships of the specified type, if any. If none exist, a
	 *         zero-length array is returned.
	 */
	public SynsetPointer[] getSemanticRelationships(RelationshipType type)
	{
		SynsetPointer[] pointers = null;
		Map subMap = getSubMap(SYNSET_KEY, false);
		if (subMap != null)
		{
			List list = (List)(subMap.get(type));
			if (list != null)
			{
				pointers = new SynsetPointer[list.size()];
				list.toArray(pointers);
			}
		}
		return (pointers != null ? pointers : new SynsetPointer[0]);
	}

	/**
	 * Returns the lexical relationships of a particular type.
	 * 
	 * @param  wordForm Word form for which to return relationships.
	 * @param  type Type of relationships to be returned.
	 * @return Relationships of the specified type, if any. If none exist, a
	 *         zero-length array is returned.
	 */
	public WordSensePointer[] getLexicalRelationships(
			String wordForm, RelationshipType type)
	{
		WordSensePointer[] pointers = null;
		Map subMap = getSubMap(wordForm, false);
		if (subMap != null)
		{
			List list = (List)(subMap.get(type));
			if (list != null)
			{
				pointers = new WordSensePointer[list.size()];
				list.toArray(pointers);
			}
		}
		return (pointers != null ? pointers : new WordSensePointer[0]);
	}

	/**
	 * Removes all semantic relationships of a particular type.
	 * 
	 * @param  type Type for which to remove all semantic relationships.
	 * @return <code>true</code> if semantic relationships of the specified
	 *         type existed and were removed, <code>false</code> otherwise.
	 */
	public boolean removeAllSemanticRelationships(RelationshipType type)
	{
		return removeAll(SYNSET_KEY, type);
	}

	/**
	 * Removes all lexical relationships of a particular type for a word form.
	 * 
	 * @param  wordForm Word form for which to remove all lexical relationships.
	 * @param  type Type of relationships to be removed.
	 * @return <code>true</code> if lexical relationships of the specified
	 *         type existed and were removed, <code>false</code> otherwise.
	 */
	public boolean removeAllLexicalRelationships(
			String wordForm, RelationshipType type)
	{
		return removeAll(wordForm, type);
	}

	/**
	 * Removes all relationships of the specified type for a particular key.
	 * 
	 * @param  sourceKey Key for which to remove relationships.
	 * @param  type Relationship type for which to remove all values.
	 * @return <code>true</code> if values of the specified type existed
	 *         and were removed, <code>false</code> otherwise.
	 */
	private boolean removeAll(Object key, RelationshipType type)
	{
		boolean removed = false;
		Map subMap = getSubMap(key, false);
		if (subMap != null)
		{
			removed = (subMap.remove(key) != null);
		}
		return removed;
	}

	/**
	 * Returns a map containing relationships associated with a particular
	 * key, possibly creating the map if one doesn't already exist. For
	 * each entry in the map, the key is a relationship type and the value
	 * a {@link List} containing all relationships of that type.
	 * 
	 * @param  sourceKey Key for which to return a relationship map.
	 * @param  shouldCreate <code>true</code> indicates that the map should
	 *         be created if one doesn't already exist. If this parameter is
	 *         set to <code>false</code> and no map already exists, the
	 *         method will return <code>null</code>.
	 * @return Reference to a previously created map if one already existed,
	 *         to a newly created map if none existed and the caller
	 *         indicated that one should be created, or <code>null</code> if
	 *         no map exists and the caller indicated that a new one should
	 *         not be created when one doesn't already exist.
	 */
	private Map getSubMap(Object sourceKey, boolean shouldCreate)
	{
		Map subMap = (Map)(sourceMaps.get(sourceKey));
		if ((subMap == null) && (shouldCreate))
		{
			subMap = new HashMap();
			sourceMaps.put(sourceKey, subMap);
		}
		return subMap;
	}

}