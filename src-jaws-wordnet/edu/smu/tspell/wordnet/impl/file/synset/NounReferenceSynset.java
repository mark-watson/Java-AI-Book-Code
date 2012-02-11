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
package edu.smu.tspell.wordnet.impl.file.synset;

import edu.smu.tspell.wordnet.AdjectiveSynset;
import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;

import edu.smu.tspell.wordnet.impl.file.ReferenceSynset;
import edu.smu.tspell.wordnet.impl.file.RelationshipPointers;
import edu.smu.tspell.wordnet.impl.file.RelationshipType;
import edu.smu.tspell.wordnet.impl.file.RetrievalException;
import edu.smu.tspell.wordnet.impl.file.SenseKey;

/**
 * Reference implementation of a noun synset.
 * 
 * @author Brett Spell
 */
public class NounReferenceSynset extends ReferenceSynset
		implements NounSynset
{

	/**
	 * Constructor that accepts noun synset properties.
	 * 
	 * @param  definition Short description / definition of the meaning.
	 * @param  examples Examples of how the synset is used.
	 * @param  senseKeys Keys of word senses associated with this synset.
	 * @param  pointers Pointers to unresolved relationships.
	 * @param  lexFile Lexical file that contains the synset.
	 * @param  offset Byte offset into the data file where synset is defined.
	 */
	public NounReferenceSynset(String definition, String[] examples,
			SenseKey[] senseKeys, RelationshipPointers pointers,
			int lexFile, int offset)
	{
		super(SynsetType.NOUN, definition, examples, senseKeys,
				pointers, lexFile, offset);
	}

	/**
	 * Returns the direct hypernyms (superordinate types), if any, of this type.
	 * <br><p>
	 * For example, the hypernym of "tent" is "shelter".
	 * 
	 * @return The direct hypernyms of this synset.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public NounSynset[] getHypernyms() throws RetrievalException
	{
		return (NounSynset[])(getNounSynsets(RelationshipType.HYPERNYM));
	}

	/**
	 * Returns the instance hypernyms of this synset. An instance hyponym is
	 * a specific instance of something and the instance hypernym represents
	 * the reflexive type. For example, the instance hypernym of "Mississippi
	 * River" is "river".
	 *  
	 * @return Instance hypernyms of this synset.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public NounSynset[] getInstanceHypernyms() throws RetrievalException
	{
		return getNounSynsets(RelationshipType.INSTANCE_HYPERNYM);
	}

	/**
	 * Returns the direct hyponyms (subordinate type), if any, of this type.
	 * <br><p>
	 * For example, a hyponym of "shelter" is "tent". 
	 * 
	 * @return The direct hyponyms of this synset.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public NounSynset[] getHyponyms() throws RetrievalException
	{
		return getNounSynsets(RelationshipType.HYPONYM);
	}

	/**
	 * Returns the instance hyponyms of a synset, where instance hyponyms
	 * represent specific (usually real-world) instances of something.
	 * <br><p>
	 * For example, instance hyponyms of "river" included "Mississippi River",
	 * "Amazon River", etc.
	 * 
	 * @return Instance hyponyms of this synset.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public NounSynset[] getInstanceHyponyms() throws RetrievalException
	{
		return getNounSynsets(RelationshipType.INSTANCE_HYPONYM);
	}

	/**
	 * Returns the "wholes" that this synset represents a part of.
	 * <br><p>
	 * For example, the member holonym of "Saturn" is "solar system".
	 * 
	 * @return Member holonyms of this synset.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public NounSynset[] getMemberHolonyms() throws RetrievalException
	{
		return getNounSynsets(RelationshipType.MEMBER_HOLONYM);
	}

	/**
	 * Returns the things that are made of the substance this synset
	 * represents.
	 * <br><p>
	 * For example, a substance holonym of "paper" is "page".
	 * 
	 * @return Things that are made of the substance this synset represents.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public NounSynset[] getSubstanceHolonyms() throws RetrievalException
	{
		return getNounSynsets(RelationshipType.SUBSTANCE_HOLONYM);
	}

	/**
	 * Returns the holonyms (whole that includes this part) of this type.
	 * <br><p>
	 * For example, a part holonym of "fuselage" is "airplane".
	 * 
	 * @return The (possibly empty) list of holonyms for this synset.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public NounSynset[] getPartHolonyms() throws RetrievalException
	{
		return getNounSynsets(RelationshipType.PART_HOLONYM);
	}

	/**
	 * Returns the member meronyms of this synset, where member meronyms are
	 * the parts that make up the whole. For example, member meronyms of
	 * "Roman Alphabet" are "A", "B", "C", etc.
	 * 
	 * @return Member parts that make up the whole represented by this synset.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public NounSynset[] getMemberMeronyms() throws RetrievalException
	{
		return getNounSynsets(RelationshipType.MEMBER_MERONYM);
	}

	/**
	 * Returns the meronyms (inherited parts) of this type.
	 * <br><p>
	 * For example, part meronyms for "airplane" include "wing" and "fuselage".
	 * 
	 * @return The (possibly empty) list of meronyms for this synset.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public NounSynset[] getPartMeronyms() throws RetrievalException
	{
		return getNounSynsets(RelationshipType.PART_MERONYM);
	}

	/**
	 * Returns substances that make up the thing represented by this synset.
	 * <br><p>
	 * For example, a substance meronym of "chocolate" is "cocoa".
	 * 
	 * @return Substances that compose the thing represented by this synset.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public NounSynset[] getSubstanceMeronyms() throws RetrievalException
	{
		return getNounSynsets(RelationshipType.SUBSTANCE_MERONYM);
	}

	/**
	 * Returns adjectives that describes states associated with this noun
	 * synset's concept.
	 * <br><p>
	 * For example, attributes of "seriousness" include "serious" and
	 * "frivolous".
	 * 
	 * @return Adjectives that describe states associated with this noun.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public AdjectiveSynset[] getAttributes() throws RetrievalException
	{
		return getAdjectiveSynsets(RelationshipType.ATTRIBUTE);
	}

	/**
	 * Returns the synsets that represents terms associated with this topic.
	 * <br><p>
	 * For example, topic members ("domain term categories") of "medicine"
	 * include "acute" and "chronic".
	 * 
	 * @return Synsets that represent concepts that are part of this topic.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public Synset[] getTopicMembers() throws RetrievalException
	{
		return getSynsets(RelationshipType.MEMBER_OF_DOMAIN_TOPIC);
	}

	/**
	 * Returns synsets that represent terms associated with this region.
	 * <br><p>
	 * For example, a region member of "Germany" is "Oktoberfest".
	 * 
	 * @return All synsets that are associated with this region.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public Synset[] getRegionMembers() throws RetrievalException
	{
		return getSynsets(RelationshipType.MEMBER_OF_DOMAIN_REGION);
	}

	/**
	 * Returns synsets that represent an example of the usage identified
	 * by this synset.
	 * <br><p>
	 * For example, a usage member of "euphemism" is "deceased".
	 * 
	 * @return Synsets representing examples of this usage.
	 * @throws RetrievalException An error occurred retrieving data.
	 */
	public Synset[] getUsageMembers() throws RetrievalException
	{
		return getSynsets(RelationshipType.MEMBER_OF_DOMAIN_USAGE);
	}

}