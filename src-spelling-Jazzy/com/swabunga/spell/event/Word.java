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
 * Offers basic methods to manipulate a text string representing a word.
 */
public class Word {

  //~ Instance/static variables ...............................................

  private int end;
  private int start;
  private String text;

  //~ Constructors ............................................................

  /**
   * Creates a new Word object.
   *
   * @param text the String representing the word.
   * @param start the start index of the word.
   */
  public Word(String text, int start) {
    this.text = text;
    this.start = start;
    setEnd();
  }

  /**
   * Creates a new Word object by cloning an existing Word object.
   *
   * @param w the word object to clone.
   */
  public Word(Word w) {
    this.copy(w);
  }

  //~ Methods .................................................................

  /**
   * Evaluate the end of word position.
   * @return the end index of the word.
   */
  public int getEnd() {

    return end;
  }

  /**
   * Set the start index of the word.
   *
   * @param s the start index.
   */
  public void setStart(int s) {
    start = s;
    setEnd();
  }

  /**
   * Evaluate the start of word position.
   * @return the start index.
   */
  public int getStart() {

    return start;
  }

  /**
   * Set the text to a new string value.
   *
   * @param s the new text
   */
  public void setText(String s) {
    text = s;
    setEnd();
  }

  /**
   * Supply the text string representing the word
   * @return the String representing the word.
   */
  public String getText() {

    return text;
  }

  /**
   * Sets the value of this Word to be a copy of another.
   *
   * @param w the Word to copy.
   */
  public void copy(Word w) {
    text = w.toString();
    start = w.getStart();
    setEnd();
  }

  /**
   * Evaluate the length of the word.
   * @return the length of the word.
   */
  public int length() {

    return text.length();
  }

  /**
   * Supply the text representing the word.
   * @return the text representing the word.
   */
  public String toString() {

    return text;
  }

  /**
   * Set the end index of the word.
   *
   */
  private void setEnd() {
    end = start + text.length();
  }
}
