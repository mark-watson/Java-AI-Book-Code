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

import java.util.Comparator;

/**
 * The Word object holds information for one suggested spelling.
 * It contains both the suggested word string and the distance cost, which represents how different the suggested
 * word is from the misspelling.
 *  <p>This class is now immutable.
 *  </p>
 */
public class Word implements Comparator {
  private String word;
  private int score;

  /**
   * Constructs a new Word.
   * @param word The text of a word.
   * @param score The word's distance cost
   */
  public Word(String word, int score) {
    this.word = word;
    this.score = score;
  }

  /**
   * Constructs a new Word.
   */
  public Word() {
    this.word = "";
    this.score = 0;
  }

  /**
   * Compares two words, mostly for the purpose of sorting words.
   * @param o1 the first word
   * @param o2 the second word
   * @return -1 if the first word is more similar to the misspelled word
   * <br>1 if the second word is more similar to the misspelled word
   * <br>0 if both words are equally similar
   *
   */
  public int compare(Object o1, Object o2) {
    if (((Word) o1).getCost() < ((Word) o2).getCost()) return -1;
    if (((Word) o1).getCost() == ((Word) o2).getCost()) return 0;
    return 1;
  }

  /**
   * Indicates if this word is equal to another one.
   * @param o The other word to compare
   * @return The indication of equality
   */
  public boolean equals(Object o) {
    if (o instanceof Word)  // added by bd
      return(((Word)o).getWord().equals(getWord()));
    return false;
  }
  
  /**
   * gets suggested spelling
   * @return the actual text of the suggest spelling
   */
  public String getWord() {
    return word;
  }

  /**
   * sets suggested spelling
   * @param word The text to set for suggestd spelling
   */
  public void setWord(String word) {
    this.word = word;
  }

  /**
   * A cost measures how close a match this word was to the original word
   * @return 0 if an exact match. Higher numbers are worse matches.
   * @see EditDistance
   */
  public int getCost() {
    return score;
  }

  /**
   * returns the suggested spelling
   * @return The word's text 
   */
  public String toString() {
    return word;
  }
}

