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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.WordSense;

/**
 * Encapsulates a collection of relationships for a synset to other synsets.
 * 
 * @author Brett Spell
 */
public class RelationshipReferences
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
	public RelationshipReferences()
	{
	}

	/**
	 * Saves a reference to the list of synsets associated with the specified
	 * relationship type.
	 * 
	 * @param  type Type of relationship for which to save synset references.
	 * @param  synsets Synsets that have a relationship of the specified type.
	 */
	public void putSemanticRelationships(
			RelationshipType type, Synset[] synsets)
	{
		Map subMap = getSubMap(type, true);
		subMap.put(SYNSET_KEY, synsets);
	}

	/**
	 * Returns the semantic relationships of a particular type.
	 * 
	 * @param  type Type of relationships to be returned.
	 * @return Synsets which have the specified semantic relationship type,
	 *         if any, or <code>null</code> if none exist.
	 */
	public Synset[] getSemanticRelationships(RelationshipType type)
	{
		Map subMap = getSubMap(type, false);
		return (subMap != null ? (Synset[])(subMap.get(SYNSET_KEY)) : null);
	}

	/**
	 * Stores the lexical relationships of a particular relationship type.
	 * 
	 * @param  wordForm Word form for which to store lexical relationships.
	 * @param  type Relationship type associated with the senses.
	 * @param  senses Word senses that have the specified relationship type.
	 */
	public void putLexicalRelationships(
			String wordForm, RelationshipType type, WordSense[] senses)
	{
		Map subMap = getSubMap(wordForm, true);
		subMap.put(type, senses);
	}

	/**
	 * Returns the lexical relationships of a particular type.
	 * 
	 * @param  wordForm Word form for which to return relationships.
	 * @param  type Type of relationships to be returned.
	 * @return Word senses that have the specified lexical relationship type,
	 *         if any, or <code>null</code> if none exist.
	 */
	public WordSense[] getLexicalRelationships(
			String wordForm, RelationshipType type)
	{
		Map subMap = getSubMap(wordForm, false);
		return (subMap != null ? (WordSense[])(subMap.get(type)) : null);
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