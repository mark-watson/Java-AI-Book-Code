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
 * A word finder Java source files, which searches text for sequences of 
 * letters formated as Java comments.
 *
 * @author Anthony Roy  (ajr@antroy.co.uk)
 */
public class JavaWordFinder extends AbstractWordFinder {

  //~ Instance/static variables ...............................................

  private boolean inComment;

  //~ Constructors ............................................................

  /**
   * Creates a new JavaWordFinder object.
   *
   * @param inText the String to search
   */
  public JavaWordFinder(String inText) {
    super(inText);
  }

  /**
   * Creates a new JavaWordFinder object.
   */
  public JavaWordFinder() {
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

    int current = sentenceIterator.current();
    setSentenceIterator(currentWord);

    int i = currentWord.getEnd();
    boolean finished = false;
    boolean started = false;

    search:
        while (i < text.length() && !finished) {

          i = ignore(i, '@');
          i = ignore(i, "<code>", "</code>");
          i = ignore(i, "<CODE>", "</CODE>");
          i = ignore(i, '<', '>');

          if (i >= text.length()) break search;

          char currentLetter = text.charAt(i);
          if (inComment) {
            //Reset on new line.
            if (currentLetter == '\n') {
              inComment = false;
              i++;
              continue search;
            } else if (!isWordChar(i)) {
              i++;
              continue search;
            }
            //Find words.
            while (i < text.length() - 1) {
              if (!started && isWordChar(i)) {
                nextWord.setStart(i);
                started = true;
              } else if (started && !isWordChar(i)) {
                nextWord.setText(text.substring(nextWord.getStart(), i));
                finished = true;
                break search;
              }

              currentLetter = text.charAt(++i);
            }
          } else if (currentLetter == '*') {
            inComment = true;
            i++;
          } else {
            i++;
          }
        }

    if (!started) {
      nextWord = null;
    } else if (!finished) {
      nextWord.setText(text.substring(nextWord.getStart(), i));
    }

    return currentWord;
  }

  /**
   * Initializes this word finder
   */

  protected void init() {
//    sentenceIterator = BreakIterator.getSentenceInstance();
//    sentenceIterator.setText(text);
    super.init();
    inComment = false;
  }
}
