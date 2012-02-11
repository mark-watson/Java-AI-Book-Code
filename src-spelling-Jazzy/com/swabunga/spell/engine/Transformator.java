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
package com.swabunga.spell.engine;

/**
 * An interface for all Transformators - which take a dictionary word and converts into its
 * phonetic hash. These phonetic hashes are useful for determining what other words are
 * similar to it, and then list those words as suggestions.
 *
 * @author Robert Gustavsson (robert@lindesign.se)
 */
public interface Transformator {

  /**
   * Take the given word, and return the best phonetic hash for it.
   * @param word the word to transform
   * @return the phonetic transformation of the word
   */
  public String transform(String word);

  /**
   * gets the list of characters that should be swapped in to the misspelled word
   * in order to try to find more suggestions.
   * In general, this list represents all of the unique phonetic characters
   * for this Transformator.
   * <p/>
   * The replace list is used in the getSuggestions method.
   * All of the letters in the misspelled word are replaced with the characters from
   * this list to try and generate more suggestions, which implies l*n tries,
   * if l is the size of the string, and n is the size of this list.
   * <p/>
   * In addition to that, each of these letters is added to the misspelled word.
   * <p/>
   * @return char[] misspelled words should try replacing with these characters to get more suggestions
   */
  public char[] getReplaceList();
}
