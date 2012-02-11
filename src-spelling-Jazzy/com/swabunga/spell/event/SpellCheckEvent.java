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

import java.util.List;

/**
 * This event is fired off by the SpellChecker and is passed to the
 * registered SpellCheckListeners
 * <p/>
 * As far as I know, we will only require one implementation of the SpellCheckEvent
 * (BasicSpellCheckEvent) but I have defined this interface just in case. The
 * BasicSpellCheckEvent implementation is currently package private.
 *
 * @author Jason Height (jheight@chariot.net.au)
 */
public interface SpellCheckEvent {
  /** Field indicating that the incorrect word should be ignored*/
  public static final short IGNORE = 0;
  /** Field indicating that the incorrect word should be ignored forever*/
  public static final short IGNOREALL = 1;
  /** Field indicating that the incorrect word should be replaced*/
  public static final short REPLACE = 2;
  /** Field indicating that the incorrect word should be replaced always*/
  public static final short REPLACEALL = 3;
  /** Field indicating that the incorrect word should be added to the dictionary*/
  public static final short ADDTODICT = 4;
  /** Field indicating that the spell checking should be terminated*/
  public static final short CANCEL = 5;
  /** Initial case for the action */
  public static final short INITIAL = -1;

  /** Returns the list of suggested Word objects
   * @return A list of words phonetically close to the misspelt word
   */
  public List getSuggestions();

  /** Returns the currently misspelt word
   * @return The text misspelt
   */
  public String getInvalidWord();

  /** Returns the context in which the misspelt word is used
   * @return The text containing the context
   */
  public String getWordContext();

  /** Returns the start position of the misspelt word in the context
   * @return The position of the word
   */
  public int getWordContextPosition();

  /** Returns the action type the user has to handle
   * @return The type of action the event is carrying
   */
  public short getAction();

  /** Returns the text to replace
   * @return the text of the word to replace
   */
  public String getReplaceWord();

  /** Set the action to replace the currently misspelt word with the new word
   *  @param newWord The word to replace the currently misspelt word
   *  @param replaceAll If set to true, the SpellChecker will replace all
   *  further occurrences of the misspelt word without firing a SpellCheckEvent.
   */
  public void replaceWord(String newWord, boolean replaceAll);

  /** Set the action it ignore the currently misspelt word.
   *  @param ignoreAll If set to true, the SpellChecker will replace all
   *  further occurrences of the misspelt word without firing a SpellCheckEvent.
   */
  public void ignoreWord(boolean ignoreAll);

  /** Set the action to add a new word into the dictionary. This will also replace the
   *  currently misspelt word.
   *@param newWord The new word to add
   */
  public void addToDictionary(String newWord);

  /** Set the action to terminate processing of the spell checker.
   */
  public void cancel();
}