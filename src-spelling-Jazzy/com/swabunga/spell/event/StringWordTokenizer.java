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
 * This class tokenizes a input string.
 *
 * <p>
 * It also allows for the string to be altered by calls to replaceWord(). The result after the spell
 * checking is completed is available to the call to getContext.
 * </p>
 *
 * @author Jason Height (jheight@chariot.net.au)
 * @author Anthony Roy  (ajr@antroy.co.uk)
 */
public class StringWordTokenizer extends AbstractWordTokenizer {

  //~ Constructors ............................................................

  /**
   * Creates a new StringWordTokenizer object.
   *
   * @param s the string to tokenize.
   */
  public StringWordTokenizer(String s) {
    super(s);
  }

  /**
   * Creates a new StringWordTokenizer object.
   *
   * @param wf the custom WordFinder to use in tokenizing. Note
   * that the string to tokenize will be encapsulated within the WordFinder.
   */
  public StringWordTokenizer(WordFinder wf) {
    super(wf);
  }

  /**
   * Creates a new StringWordTokenizer object.
   * @param s the string to work on
   * @param finder the custom WordFinder to use in tokenizing. Note
   * that the string to tokenize will be encapsulated within the WordFinder.
   */
  public StringWordTokenizer(String s, WordFinder finder) {
    super(finder);
    finder.setText(s);
  }

  
  //~ Methods .................................................................

  /**
   *
   * @deprecated use getContext() instead as per the WordTokenizer
   * interface specification.
   * @return the final text.
   */
  public String getFinalText() {

    return getContext();
  }

  /**
   * Replace the current word in the iteration with the String s.
   *
   * @param s the String to replace the current word.
   * @throws WordNotFoundException current word not yet set.
   */
  public void replaceWord(String s) {
    finder.replace(s);
  }
}