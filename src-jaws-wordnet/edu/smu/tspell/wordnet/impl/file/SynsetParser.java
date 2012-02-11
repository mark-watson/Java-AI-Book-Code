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
import java.util.StringTokenizer;

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;

import edu.smu.tspell.wordnet.impl.ExampleSentences;

import edu.smu.tspell.wordnet.impl.file.synset.*;

/**
 * Creates synset objects by parsing a line of data from a WordNet data file.
 * 
 * @author Brett Spell
 * @see    <a href="http://wordnet.princeton.edu/man/wndb.5WN#sect3">Format of
 *         WordNet database files ("Data File Format").</a>
 */
public class SynsetParser
{

	/**
	 * Separates fields within a line.
	 */
	private final static String FIELD_DELIMITER = " ";

	/**
	 * Identifies the start of the gloss within a line.
	 */
	private final static String FRAME_TERMINATOR = "|";

	/**
	 * Appears at the beginning of each frame entry.
	 */
	private final static String FRAME_HEADER = "+";

	/**
	 * Separates elements of the gloss (definition and example sentences).
	 */
	private final static String GLOSS_DELIMITERS = "; ";

	/**
	 * Identifies a gloss element as a definition or example sentence.
	 */
	private final static String DOUBLE_QUOTE = "\"";;

	/**
	 * Indicates the start of a syntactic marker for adjective words.
	 */
	private final static String MARKER_START = "(";

	/**
	 * Indicates the end of a syntactic marker for adjective words.
	 */
	private final static String MARKER_END = ")";

	/**
	 * Used for parsing hexadecimal (base-16) number text.
	 */
	private final static int HEX = 16;

	/**
	 * No-argument constructor.
	 */
	public SynsetParser()
	{
		super();
	}

	/**
	 * Creates and returns a synset implementation based upon the data
	 * contained within a line from a WordNet database data file.
	 * <br><p>
	 * Note that some of the numeric values parsed here are hexadeximal
	 * (not decimal), at least in the WordNet 3.0 database files.
	 * 
	 * @param  data Line of data to convert into a synset.
	 * @return Newly created synset that represents the data parsed.
	 * @throws ParseException An error occurred parsing the data.
	 * @see    <a href="http://wordnet.princeton.edu/man/wndb.5WN#sect3">
	 *         Format of WordNet database files ("Data File Format").</a>
	 */
	public Synset createSynset(String data)
	{
		char typeCode;
		String wordForm;
		int markerStart, markerEnd;
		String position;
		int lexicalID;
		SenseKey[] senseKeys;
		String[] keyText;
		String[] templates;

		RelationshipType relationship;
		int targetOffset;
		SynsetType type;
		String sourceTarget;
		int sourceWord, targetWord;
		SynsetPointer pointer;
		WordSensePointer sensePointer;
		String nextToken;
		String frameText;
		Synset synset;

		StringTokenizer tokenizer = new StringTokenizer(data, FIELD_DELIMITER);
		//  Synset offset (e.g., "06550953"); not used.
		int offset = Integer.parseInt(tokenizer.nextToken());
		//  Lexical file number (e.g, "10"); also not used.
		int lexicalFile = Integer.parseInt(tokenizer.nextToken());
		//  Synset type (e.g., "n").
		char synsetTypeCode = tokenizer.nextToken().charAt(0);
		//  Convert the category type code and create a synset instance
		SynsetType synsetType = SynsetTypeConverter.getType(synsetTypeCode);
		//  Word form count (e.g., "2").
		int wordCount = Integer.parseInt(tokenizer.nextToken(), HEX);
		senseKeys = new SenseKey[wordCount];
		SampleIndexFactory indexFactory = SampleIndexFactory.getInstance();
		SampleTemplateFactory templateFactory =
				SampleTemplateFactory.getInstance();
		ExampleSentences sentences = new ExampleSentences();

		WordPositions positions = null;
		for (int i = 0; i < wordCount; i++)
		{
			//  Word form (e.g., "WordNet").
			wordForm = TextTranslator.translateToExternalFormat(
					tokenizer.nextToken());
			markerStart = wordForm.indexOf(MARKER_START);
			if (markerStart != -1)
			{
				markerEnd = wordForm.indexOf(MARKER_END, markerStart);
				if (markerEnd == -1)
				{
					throw new ParseException("Marker start embedded in form " +
							"'" + wordForm + "' but no marker end text found.");
				}
				position = wordForm.substring(markerStart + 1, markerEnd);
				wordForm = wordForm.substring(0, markerStart);
				if (positions == null)
				{
					positions = new WordPositions();
				}
				positions.setPosition(wordForm, position);
			}
			//  Lexical ID (e.g., "0")
			lexicalID = Integer.parseInt(tokenizer.nextToken(), HEX);
			senseKeys[i] = new SenseKey(wordForm, synsetType, lexicalFile,
					lexicalID);
			keyText = indexFactory.getSampleKeys(senseKeys[i]);
			templates = new String[keyText.length];
			for (int j = 0; j < keyText.length; j++)
			{
				templates[j] = templateFactory.getSample(
						synsetType, keyText[j]);
			}
			sentences.setTemplates(senseKeys[i].getLemma(), templates);
		}

		//  Pointer count
		int pointerCount = Integer.parseInt(tokenizer.nextToken());
		RelationshipPointers pointers = new RelationshipPointers();
		for (int i = 0; i < pointerCount; i++)
		{
			//  Pointer symbol (e.g., "@i").
			relationship = RelationshipType.getRelationshipType(
					tokenizer.nextToken());
			//  Synset offset (e.g., "06550617").
			targetOffset = Integer.parseInt(tokenizer.nextToken());
			//  Part of speech / synset type
			typeCode = tokenizer.nextToken().charAt(0);
			type = SynsetTypeConverter.getType(typeCode);
			//  Source / target words
			sourceTarget = tokenizer.nextToken();
			sourceWord = Integer.parseInt(sourceTarget.substring(0, 2), HEX);
			targetWord = Integer.parseInt(sourceTarget.substring(2, 4), HEX);
			//  If source and target are both zero, add a semantic relationship
			if ((sourceWord == 0) && (targetWord == 0))
			{
				pointer = new SynsetPointer(type, targetOffset);
				pointers.addSemanticRelationship(relationship, pointer);
			}
			//  Otherwise it must be a lexical relationship
			else
			{
				wordForm = senseKeys[sourceWord - 1].getLemma();
				sensePointer = new WordSensePointer(
						type, targetOffset, targetWord);
				pointers.addLexicalRelationship(
						wordForm, relationship, sensePointer);
			}
		}

		nextToken = tokenizer.nextToken();
		//  If we didn't get the frame terminator, there must be frame numbers
		if (!(nextToken.equals(FRAME_TERMINATOR)))
		{
			int frameCount = Integer.parseInt(nextToken);
			SampleFrameFactory factory = SampleFrameFactory.getInstance();
			//  Loop through the list of frame entries
			for (int i = 0; i < frameCount; i++)
			{
				//  Get the header character ("+")
				nextToken = tokenizer.nextToken();
				if (!(nextToken.equals(FRAME_HEADER)))
				{
					throw new ParseException("Expected frame header " +
							"text '" + FRAME_HEADER + "' but found '" +
							nextToken + "' instead: " + data);
				}
				//  Get the frame number and resolve it to frame text
				nextToken = tokenizer.nextToken();
				frameText = factory.getSample(synsetType, nextToken);
				//  Get index of word that frame is associated with
				sourceWord = Integer.parseInt(tokenizer.nextToken(), HEX);
				//  If word number is zero, frame is for the entire synset
				if (sourceWord == 0)
				{
					sentences.addCommonFrame(frameText);
				}
				//  Frame applies only to a particular word
				else
				{
					wordForm = senseKeys[sourceWord - 1].getLemma();
					sentences.addFrame(frameText, wordForm);
				}
			}
			//  We should be finished with frames now; get the frame terminator
			nextToken = tokenizer.nextToken();
		}
		if (!(nextToken.equals(FRAME_TERMINATOR)))
		{
			throw new ParseException("Expected frame terminator text '" +
					FRAME_TERMINATOR + "' but found '" + nextToken +
					"' instead: " + data);
		}

		//  Now process the gloss
		String delimiterText =
				FIELD_DELIMITER + FRAME_TERMINATOR + FIELD_DELIMITER;
		int index = data.indexOf(delimiterText);
		String glossText =
				data.substring(index + delimiterText.length());
		GlossContent gloss = parseGloss(glossText);
		String definition = gloss.getDefinition();
		String[] examples = gloss.getExamples();

		//  Convert the category type code and create a synset instance
		switch (synsetTypeCode)
		{
			case SynsetTypeConverter.NOUN_CODE:
				synset = new NounReferenceSynset(definition, examples,
						senseKeys, pointers, lexicalFile, offset);
				break;
			case SynsetTypeConverter.VERB_CODE:
				synset = new VerbReferenceSynset(definition, examples,
						senseKeys, pointers, sentences, lexicalFile, offset);
				break;
			case SynsetTypeConverter.ADJECTIVE_CODE:
				synset = new AdjectiveReferenceSynset(definition, examples,
						senseKeys, pointers, lexicalFile, offset, positions);
				break;
			case SynsetTypeConverter.ADVERB_CODE:
				synset = new AdverbReferenceSynset(definition, examples,
						senseKeys, pointers, lexicalFile, offset);
				break;
			case SynsetTypeConverter.ADJECTIVE_SATELLITE_CODE:
				synset = new AdjectiveSatelliteReferenceSynset(definition,
						examples, senseKeys, pointers, lexicalFile, offset,
						positions);
				break;
			default:
				throw new ParseException("The synset type code '" +
						synsetTypeCode + "' is invalid");
		}
		return synset;
	}

	/**
	 * Parses gloss text and returns the content found there.
	 * 
	 * @param  glossText Gloss text to parse.
	 * @return Content of the gloss.
	 */
	private GlossContent parseGloss(String glossText)
	{
		int quoteIndex;
		int textEnd;
		String example;

		String definition = null;
		ArrayList exampleList = new ArrayList();
		StringBuffer buffer = new StringBuffer(glossText.trim());
		//  Do we have a gloss at all?
		if (buffer.length() > 0)
		{
			//  Does it start with a definition?
			if (!(DOUBLE_QUOTE.equals(buffer.substring(0, 1))))
			{
				//  Find out where the definition ends
				quoteIndex = buffer.indexOf(DOUBLE_QUOTE);
				if (quoteIndex == -1)
				{
					quoteIndex = buffer.length();
				}
				//  Strip any delimiter characters from the end
				textEnd = quoteIndex - 1;
				while ((textEnd >= 0) && (GLOSS_DELIMITERS.indexOf(
						buffer.charAt(textEnd)) != -1))
				{
					textEnd--;
				}
				//  Get the definition text
				definition = buffer.substring(0, textEnd + 1);
				//  Delete everything prior to the start of the first example
				buffer.delete(0, quoteIndex);
			}
			//  Loop through the example sentences
			while (buffer.length() > 0)
			{
				//  Find where the current example sentence ends
				quoteIndex = buffer.indexOf(DOUBLE_QUOTE, 1);
				if (quoteIndex == -1)
				{
					quoteIndex = buffer.length() - 1;
				}
				example = buffer.substring(0, quoteIndex + 1);
				//  Add it to the list
				if (example.length() > 0)
				{
					exampleList.add(buffer.substring(0, quoteIndex + 1));
				}
				buffer.delete(0, quoteIndex + 1);
				//  Trim any delimiter characters from the front
				while ((buffer.length() > 0) &&
						(GLOSS_DELIMITERS.indexOf(buffer.charAt(0)) != -1))
				{
					buffer.delete(0, 1);
				}
			}
		}
		//  Return the data we collected
		String[] exampleArray = new String[exampleList.size()];
		exampleList.toArray(exampleArray);
		return new GlossContent(definition, exampleArray);
	}

	/**
	 * Encapsulates the content of a synset gloss.
	 * 
	 * @author Brett Spell
	 *
	 */
	private static class GlossContent
	{

		/**
		 * Short definition of the meaning.
		 */
		private String definition;

		/**
		 * Example sentences.
		 */
		private String[] examples;

		/**
		 * Constructor that accepts a definition and array of example sentences.
		 * 
		 * @param  definition Short definition of the synset's meaning.
		 * @param  examples Example sentences showing usage of the word forms.
		 */
		public GlossContent(String definition, String[] examples)
		{
			this.definition = definition;
			this.examples = examples;
		}

		/**
		 * Returns a definition of the synset.
		 * 
		 * @return Synset definition.
		 */
		public String getDefinition()
		{
			return definition;
		}

		/**
		 * Returns sentences showing examples of usage of the synset's word
		 * forms.
		 * 
		 * @return Usage examples for the synset.
		 */
		public String[] getExamples()
		{
			return examples;
		}

	}

}