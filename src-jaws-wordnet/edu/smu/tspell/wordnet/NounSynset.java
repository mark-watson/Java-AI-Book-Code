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

import edu.smu.tspell.wordnet.WordNetException;

/**
 * Represents a synset that corresponds to a noun meaning.
 * 
 * @author Brett Spell
 * @see    <a href="http://wordnet.princeton.edu/5papers.pdf">Five Papers on
 *         WordNet ("Nouns in WordNet: A Lexical Inheritance System")</a>
 */
public interface NounSynset extends Synset
{

	/**
	 * Returns the direct hypernyms (superordinate types), if any, of this type.
	 * <br><p>
	 * For example, the hypernym of "tent" is "shelter".
	 * 
	 * @return The direct hypernyms of this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getHypernyms() throws WordNetException;

	/**
	 * Returns the instance hypernyms of this synset. An instance hyponym is
	 * a specific instance of something and the instance hypernym represents
	 * the reflexive type.
	 * <br><p>
	 * For example, the instance hypernym of "Mississippi River" is "river".
	 *  
	 * @return Instance hypernyms of this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getInstanceHypernyms() throws WordNetException;

	/**
	 * Returns the direct hyponyms (subordinate type), if any, of this type.
	 * <br><p>
	 * For example, a hyponym of "shelter" is "tent". 
	 * 
	 * @return The direct hyponyms of this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getHyponyms() throws WordNetException;

	/**
	 * Returns the instance hyponyms of a synset, where instance hyponyms
	 * represent specific (usually real-world) instances of something.
	 * <br><p>
	 * For example, instance hyponyms of "river" included "Mississippi River",
	 * "Amazon River", etc.
	 * 
	 * @return Instance hyponyms of this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getInstanceHyponyms() throws WordNetException;

	/**
	 * Returns the "wholes" that this synset represents a part of. For example,
	 * the member holonym of "Saturn" is "solar system".
	 * 
	 * @return Member holonyms of this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getMemberHolonyms() throws WordNetException;

	/**
	 * Returns the things that are made of the substance this synset
	 * represents. For example, a substance holonym of "paper" is "page".
	 * 
	 * @return Things that are made of the substance this synset represents.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getSubstanceHolonyms() throws WordNetException;

	/**
	 * Returns the holonyms (whole that includes this part) of this type.
	 * <br><p>
	 * For example, a part holonym of "fuselage" is "airplane".
	 * 
	 * @return The (possibly empty) list of holonyms for this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getPartHolonyms() throws WordNetException;

	/**
	 * Returns the member meronyms of this synset, where member meronyms are
	 * the parts that make up the whole.
	 * <br><p>
	 * For example, member meronyms of "Roman Alphabet" are "A", "B", "C", etc.
	 * 
	 * @return Member parts that make up the whole represented by this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getMemberMeronyms() throws WordNetException;

	/**
	 * Returns the meronyms (inherited parts) of this type.
	 * <br><p>
	 * For example, part meronyms for "airplane" include "wing" and "fuselage".
	 * 
	 * @return The (possibly empty) list of meronyms for this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getPartMeronyms() throws WordNetException;

	/**
	 * Returns substances that make up the thing represented by this synset.
	 * <br><p>
	 * For example, a substance meronym of "chocolate" is "cocoa".
	 * 
	 * @return Substances that compose the thing represented by this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getSubstanceMeronyms() throws WordNetException;

	/**
	 * Returns adjectives that describes states associated with this noun
	 * synset's concept.
	 * <br><p>
	 * For example, attributes of "seriousness" include "serious" and
	 * "frivolous".
	 * 
	 * @return Adjectives that describe states associated with this noun.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public AdjectiveSynset[] getAttributes() throws WordNetException;

	/**
	 * Returns the synsets that represents terms associated with this topic.
	 * <br><p>
	 * For example, topic members ("domain term categories") of "medicine"
	 * include "acute" and "chronic".
	 * 
	 * @return Synsets that represent concepts that are part of this topic.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public Synset[] getTopicMembers() throws WordNetException;

	/**
	 * Returns synsets that represent terms associated with this region.
	 * <br><p>
	 * For example, a region member of "Germany" is "Oktoberfest".
	 * 
	 * @return All synsets that are associated with this region.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public Synset[] getRegionMembers() throws WordNetException;

	/**
	 * Returns synsets that represent an example of the usage identified
	 * by this synset.
	 * <br><p>
	 * For example, a usage member of "euphemism" is "deceased".
	 * 
	 * @return Synsets representing examples of this usage.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public Synset[] getUsageMembers() throws WordNetException;

	/**
	 * Identifies the topics with which this synset is associated.
	 * <br><p>
	 * For example, the topic associated with "periodic table" is "chemistry".
	 * 
	 * @return Topics / subjects associated with this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getTopics() throws WordNetException;

	/**
	 * Identifies the regions with which this synset is associated.
	 * <br><p>
	 * For example, the region associated with "sushi" is "Japan".
	 * 
	 * @return Regions associated with this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getRegions() throws WordNetException;

	/**
	 * Identifies the usage types associated with this synset.
	 * <br><p>
	 * For example, the usage associated with "stuff" is "slang".
	 * 
	 * @return Usage types associated with this synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public NounSynset[] getUsages() throws WordNetException;

}