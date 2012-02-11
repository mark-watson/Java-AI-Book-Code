/*
Jazzy - a Java library for Spell Checking
Copyright (C) 2001 Mindaugas Idzelis
Full text of license can be found in LICENSE.txt

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
*/
package com.swabunga.spell.event;

/**
 * <p>An interface for objects which take a text-based media as input, and iterate through
 * the words in the text stored in that media. Examples of such media could be Strings,
 * Documents, Files, TextComponents etc.
 * </P>
 *
 * <P>
 * When the object is instantiated, and before the first call to <CODE>next()</CODE> is made,
 * the following methods should throw a <CODE>WordNotFoundException</CODE>:<br>
 * <CODE>getCurrentWordEnd()</CODE>, <CODE>getCurrentWordPosition()</CODE>,
 *  <CODE>isNewSentence()</CODE> and <CODE>replaceWord()</CODE>.
 * </P>
 *
 * <P>A call to <CODE>next()</CODE> when <CODE>hasMoreWords()</CODE> returns false
 * should throw a <CODE>WordNotFoundException</CODE>.</P>
 * @author Jason Height (jheight@chariot.net.au)
 */
public interface WordTokenizer {

  //~ Methods .................................................................

  /**
   * Returns the context text that is being tokenized (should include any
   * changes that have been made).
   * @return the text being searched.
   */
  public String getContext();

  /**
   * Returns the number of word tokens that have been processed thus far
   * @return the number of words found so far.
   */
  public int getCurrentWordCount();

  /**
   * Returns an index representing the end location of the current word in the text.
   * @return index of the end of the current word in the text.
   * @throws WordNotFoundException current word has not yet been set.
   */
  public int getCurrentWordEnd();

  /**
   * Returns an index representing the start location of the current word in the text.
   * @return index of the start of the current word in the text.
   * @throws WordNotFoundException current word has not yet been set.
   */
  public int getCurrentWordPosition();

  /**
   * Returns true if the current word is at the start of a sentence
   * @return true if the current word starts a sentence.
   * @throws WordNotFoundException current word has not yet been set.
   */
  public boolean isNewSentence();

  /**
   * Indicates if there are more words left
   * @return true if more words can be found in the text.
   */
  public boolean hasMoreWords();

  /**
   * This returns the next word in the iteration. Note that any implementation should return
   * the current word, and then replace the current word with the next word found in the
   * input text (if one exists).
   * @return the next word in the iteration.
   * @throws WordNotFoundException search string contains no more words.
   */
  public String nextWord();

  /**
   * Replaces the current word token
   *
   * <p/>
   * When a word is replaced care should be taken that the WordTokenizer
   * repositions itself such that the words that were added aren't rechecked.
   * Of course this is not mandatory, maybe there is a case when an
   * application doesn't need to do this.
   * <p/>
   * @param newWord the string which should replace the current word.
   * @throws WordNotFoundException current word has not yet been set.
   */
  public void replaceWord(String newWord);
}