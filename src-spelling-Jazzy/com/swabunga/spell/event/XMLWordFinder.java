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
//:folding=indent:
package com.swabunga.spell.event;


/**
 * A word finder for XML or HTML documents, which searches text for sequences
 * of letters, but ignores the text inside any tags.
 *
 * @author Anthony Roy  (ajr@antroy.co.uk)
 */
public class XMLWordFinder extends AbstractWordFinder {

  //~ Instance/static variables ...............................................

  //~ Constructors ............................................................

  /**
   * Creates a new DefaultWordFinder object.
   *
   * @param inText the text to search.
   */
  public XMLWordFinder(String inText) {
    super(inText);
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

    if (currentWord == null)
      throw new WordNotFoundException("No more words found.");

    currentWord.copy(nextWord);

    setSentenceIterator(currentWord);

    int i = currentWord.getEnd();
    boolean finished = false;
    boolean started = false;

    search:      /* Find words. */
    while (i < text.length() && !finished) {
      if (!started && isWordChar(i)) {
        nextWord.setStart(i++);
        started = true;
        continue search;
      } else if (started) {
        if (isWordChar(i)) {
          i++;
          continue search;
        } else {
          nextWord.setText(text.substring(nextWord.getStart(), i));
          finished = true;
          break search;
        }
      }

      //Ignore things inside tags.
      int i2 = ignore(i, '<', '>');
      i = (i2 == i ? i + 1 : i2);
    }

    if (!started) {
      nextWord = null;
    } else if (!finished) {
      nextWord.setText(text.substring(nextWord.getStart(), i));
    }

    return currentWord;
  }
}
