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
package edu.smu.tspell.wordnet.impl;

import java.text.MessageFormat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Encapsulates example sentences applicable to a synset and / or word sense.
 * 
 * @author Brett Spell
 */
public class ExampleSentences
{

	/**
	 * Used as the word form "key" for frames associated with all word forms
	 * in the synset. In other words, this lets us treat the common frames
	 * essentially the same as those associated with a particular word form.
	 */
	private final static String SYNSET_KEY = "*";

	/**
	 * Mapping of word forms to their associated frames. For each entry in
	 * this map, the key is a string representing a word form (or the entire
	 * synset) and the corresponding value is a {@link List} containing the
	 * appropriate frames.
	 * 
	 * @see    <a href="http://wordnet.princeton.edu/man/wninput.5WN#sect4">
	 *         Format of Lexicographer Files ("Verb Frames")</a>
	 */
	private Map wordFrames = new HashMap();

	/**
	 * Mapping of word forms to their associated templates. For each entry in
	 * the map, the key is a string representing a word form and the
	 * corresponding value is an array of strings representing templates that
	 * are associated with the word form.
	 * 
	 */
	private Map senseTemplates = new HashMap();

	/**
	 * No-argument constructor.
	 */
	public ExampleSentences()
	{
	}

	/**
	 * Adds to this collection a frame that's common to all word forms in the
	 * synset.
	 * 
	 * @param  frameText Sentence frame that's applicable to all word forms in
	 *         the synset.
	 */
	public void addCommonFrame(String frameText)
	{
		addFrame(frameText, SYNSET_KEY);
	}

	/**
	 * Adds to this collection a frame that's applicable to a specific word
	 * form within the synset.
	 * 
	 * @param  frameText Sentence frame that's applicable to the word form.
	 * @param  wordForm Word form associated with the sentence frame.
	 */
	public void addFrame(String frameText, String wordForm)
	{
		List frameList = (List)(wordFrames.get(wordForm));
		if (frameList == null)
		{
			frameList = new ArrayList();
			wordFrames.put(wordForm, frameList);
		}
		frameList.add(frameText);
	}

	/**
	 * Saves the list of templates that apply to a particular word form.
	 * 
	 * @param  wordForm Word form for which to set the sentence templates.
	 * @param  templates Templates associated with the specified word form.
	 */
	public void setTemplates(String wordForm, String[] templates)
	{
		senseTemplates.put(wordForm, templates);
	}

	/**
	 * Returns the templates associated with a word form (if any) with the
	 * specified word form substituted into the appropriate place within the
	 * templates.
	 * 
	 * @param  wordForm Word form for which to return sentence templates.
	 * @return Sentence templates associated with the specified word form.
	 */
	public String[] getFormattedTemplates(String wordForm)
	{
		Object[] arguments = new Object[] {wordForm};
		String[] templates = (String[])(senseTemplates.get(wordForm));
		for (int i = 0; i < templates.length; i++)
		{
			templates[i] = MessageFormat.format(templates[i], arguments);
		}
		return templates;
	}

	/**
	 * Returns the sentence frames that are common to all word forms in the
	 * synset.
	 * 
	 * @return Sentence frames applicable to all word forms in the synset.
	 */
	public String[] getCommonFrames()
	{
		return getFrames(SYNSET_KEY);
	}

	/**
	 * Returns the sentence frames that are associated with a particular word
	 * form.
	 * 
	 * @param  wordForm Word form for which to return sentence frames.
	 * @return Sentence frames associated with the word form.
	 */
	public String[] getFrames(String wordForm)
	{
		String[] frames = null;
		List frameList = (List)(wordFrames.get(wordForm));
		if (frameList != null)
		{
			frames = new String[frameList.size()];
			frameList.toArray(frames);
		}
		return (frames != null ? frames : new String[0]);
	}

}