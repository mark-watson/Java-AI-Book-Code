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
import edu.smu.tspell.wordnet.AdjectiveSatelliteSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetException;

import edu.smu.tspell.wordnet.impl.file.RelationshipPointers;
import edu.smu.tspell.wordnet.impl.file.RetrievalException;
import edu.smu.tspell.wordnet.impl.file.SenseIndexEntry;
import edu.smu.tspell.wordnet.impl.file.SenseIndexReader;
import edu.smu.tspell.wordnet.impl.file.SenseKey;
import edu.smu.tspell.wordnet.impl.file.SynsetFactory;
import edu.smu.tspell.wordnet.impl.file.WordPositions;

/**
 * Reference implementation of an adjective synset.
 * 
 * @author Brett Spell
 */
public class AdjectiveSatelliteReferenceSynset extends AdjectiveReferenceSynset
		implements AdjectiveSatelliteSynset
{

	/**
	 * Used to save a reference to the head synset for adjective satellites.
	 * This will be <code>null</code> if this synset is not an adjective
	 * satellite or if the head synset has never be retrieved.
	 */
	private AdjectiveSynset headSynset;

	/**
	 * Constructor that accepts adjective satellite synset properties.
	 * 
	 * @param  definition Short description / definition of the meaning.
	 * @param  examples Examples of how the synset is used.
	 * @param  senseKeys Keys of word senses associated with this synset.
	 * @param  pointers Pointers to unresolved relationships.
	 * @param  lexFile Lexical file that contains the synset.
	 * @param  offset Byte offset into the data file where synset is defined.
	 * @param  positions Positions that the words in this synset can occupy.
	 */
	public AdjectiveSatelliteReferenceSynset(String definition,
			String[] examples, SenseKey[] senseKeys,
			RelationshipPointers pointers, int lexFile, int offset,
			WordPositions positions)
	{
		super(SynsetType.ADJECTIVE_SATELLITE, definition, examples, senseKeys,
				pointers, lexFile, offset, positions);
	}

	/**
	 * Returns a reference to the head synset.
	 * 
	 * @return Reference to the head synset.
	 * @throws WordNetException An error occurred retrieving data.
	 */
	public synchronized AdjectiveSynset getHeadSynset() throws WordNetException
	{
		if (headSynset == null)
		{
			headSynset = retrieveHeadSynset();
		}
		return headSynset;
	}

	/**
	 * Reads and returns the head synset for an adjective satellite.
	 * <br><p>
	 * Note that this will require at least two index reads in addition
	 * to (possibly) reading the synset itself. That's because when we
	 * construct the sense keys for a synset we don't have the full sense
	 * key for each word forms. Instead, we construct a partial key that
	 * omits any head word information, which means that when / if we want
	 * to get to the head word we have to look in the index file and
	 * retrieve the full key from our partial key. Once that's done we
	 * can then construct a (full) key for the head synset, use it to
	 * look up the index entry for the head synset, and then retrieve the
	 * synset itself.
	 * 
	 * @return Head synset associated with this adjective satellite.
	 */
	private AdjectiveSynset retrieveHeadSynset()
	{
		Synset synset = null;
		// All our word senses should point to the head; just use the first one
		SenseKey senseKey = getSenseKey(0);
		//  Get head synset information from the sense index file
		SenseIndexEntry indexEntry = getIndexEntry(senseKey);
		if (indexEntry != null)
		{
			//  Now get the sense key of the head synset
			SenseKey headKey = indexEntry.getSenseKey().getHeadWord();
			if (headKey != null)
			{
				//  Read head word entry from the sense index file
				SenseIndexReader reader = SenseIndexReader.getInstance();
				indexEntry = reader.getEntry(headKey.getFullSenseKeyText());
				if (indexEntry != null)
				{
					SynsetFactory factory = SynsetFactory.getInstance();
					synset = factory.getSynset(indexEntry.getSynsetPointer());
				}
				else
				{
					throw new RetrievalException("Unable to locate head word " +
							"entry for " + headKey + " referenced by " + this);
				}
			}
		}
		return (AdjectiveSynset)(synset);
	}

}