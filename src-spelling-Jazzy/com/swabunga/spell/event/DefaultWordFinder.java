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
 * A basic word finder, which searches text for sequences of letters.
 * 
 * @author Anthony Roy  (ajr@antroy.co.uk)
 */
public class DefaultWordFinder extends AbstractWordFinder {

  //~ Instance/static variables ...............................................

  //~ Constructors ............................................................

  /**
   * Creates a new DefaultWordFinder object.
   * 
   * @param inText the String to search
   */
  public DefaultWordFinder(String inText) {
    super(inText);
  }

  /**
   * Creates a new DefaultWordFinder object.
   */
  public DefaultWordFinder() {
    super();
  }

  //~ Methods .................................................................

  /**
   * This method scans the text from the end of the last word,  and returns a
   * new Word object corresponding to the next word.
   * 
   * @return the next word.
   * @throws WordNotFoundException search string contains no more words.
   */
  public Word next() {
    if (nextWord == null) {
      throw new WordNotFoundException("No more words found.");
    }
    currentWord.copy(nextWord);
    setSentenceIterator(currentWord);

    int i = currentWord.getEnd();
    boolean finished = false;

    while (i < text.length() && !finished) {
      if (isWordChar(i)) {
        nextWord.setStart(i);
        int end = getNextWordEnd(text, i);
        nextWord.setText(text.substring(i, end));
        finished = true;
      }
      i++;
    }
    if (!finished)
      nextWord = null;

    return currentWord;
  }

  /**
   * Returns the position in the string <em>after</em> the end of the next word.
   * Note that this return value should not be used as an index into the string
   * without checking first that it is in range, since it is possible for the
   * value <code>text.length()</code> to be returned by this method.
   */
  private int getNextWordEnd(String text, int startPos) {
    // If we're dealing with a possible 'internet word' we need to provide
    // some special handling
    if (SpellChecker.isINETWord(text.substring(startPos))) {
      for (int i = startPos; i < text.length(); i++) {
        char ch = text.charAt(i);
        if (Character.isLetterOrDigit(ch))
          continue;

        if (ch == '\r' || ch == '\n')
          return i;
        // Chop off any characters that might be enclosing the 'internet word'. eg ',",),]
        if (Character.isSpaceChar(ch))
          if (i > 0 && Character.isLetterOrDigit(text.charAt(i - 1)))
            return i;
          else
            return i - 1;
      }
      return text.length();
    } else {
      for (int i = startPos; i < text.length(); i++) {
        if (!isWordChar(i))
          return i;
      }
      return text.length();
    }
  }
}
