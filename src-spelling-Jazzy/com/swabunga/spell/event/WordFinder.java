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
 * <p>An interface for objects which take a String as input, and iterates through
 * the words in the string.
 * </P>
 *
 * <P>
 * When the object is instantiated, and before the first call to <CODE>next()</CODE> is made,
 * the following methods should throw a <CODE>WordNotFoundException</CODE>:<br>
 * <CODE>current()</CODE>,
 *  <CODE>startsSentence()</CODE> and <CODE>replace()</CODE>.
 * </P>
 *
 * <P>A call to <CODE>next()</CODE> when <CODE>hasMoreWords()</CODE> returns false
 * should throw a <CODE>WordNotFoundException</CODE>.</P>
 * @author Jason Height (jheight@chariot.net.au)
 */

public interface WordFinder {

  //~ Methods .................................................................

  /**
   * This method returns the text through which the WordFinder is iterating.
   * The text may have been modified through calls to replace().
   *
   * @return the (possibly modified) text being searched.
   */
  public String getText();

  /**
   * This method resets the text through which the WordFinder iterates.
   * It must also re-initialize the WordFinder.
   *
   * @param newText the new text to search.
   */
  public void setText(String newText);

  /**
   * This method should return the  Word object representing the current word
   * in the iteration.
   * This method should not affect the state of the  WordFinder object.
   *
   * @return the current Word object.
   * @throws WordNotFoundException current word has not yet been set.
   */
  public Word current();

  /**
   * Tests the finder to see if any more words are available.
   *
   * @return true if more words are available.
   */
  public boolean hasNext();

  /**
   * This method should return the  Word object representing the next word
   * in the iteration (the first word if next() has not yet been called.)
   *
   * @return the next Word in the iteration.
   * @throws WordNotFoundException search string contains no more words.
   */
  public Word next();

  /**
   * This method should replace the current Word object with a Word object
   * representing the String newWord.
   *
   * @param newWord the word to replace the current word with.
   * @throws WordNotFoundException current word has not yet been set.
   */
  public void replace(String newWord);

  /**
   * Indicates if the current word starts a new sentence.
   * @return true if the current word starts a new sentence.
   * @throws WordNotFoundException current word has not yet been set.
   */
  public boolean startsSentence();

  // public void setText();
}
