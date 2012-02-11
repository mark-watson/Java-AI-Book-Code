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

import java.util.List;

/**
 * An interface for all dictionary implementations. It defines the most basic
 * operations on a dictionary: adding words, checking if a word is correct, and getting a list
 * of suggestions for misspelled words.
 */
public interface SpellDictionary {

  /**
   * Add a word permanently to the dictionary.
   * @param word The word to add to the dictionary
   */
  public void addWord(String word);

  /**
   * Evaluates if the word is correctly spelled against the dictionary.
   * @param word The word to verify if it's spelling is OK.
   * @return Indicates if the word is present in the dictionary.
   */
  public boolean isCorrect(String word);

  /**
   * Returns a list of Word objects that are the suggestions to any word.
   * If the word is correctly spelled, then this method
   * could return just that one word, or it could still return a list
   * of words with similar spellings.
   * <br/>
   * Each suggested word has a score, which is an integer
   * that represents how different the suggested word is from the sourceWord.
   * If the words are the exactly the same, then the score is 0.
   * You can get the dictionary to only return the most similar words by setting
   * an appropriately low threshold value.
   * If you set the threshold value too low, you may get no suggestions for a given word.
   * <p>
   * This method is only needed to provide backward compatibility. 
   * @see #getSuggestions(String, int, int[][])
   * 
   * @param sourceWord the string that we want to get a list of spelling suggestions for
   * @param scoreThreshold Any words that have score less than this number are returned.
   * @return List a List of suggested words
   * @see com.swabunga.spell.engine.Word
   * 
   */
  public List getSuggestions(String sourceWord, int scoreThreshold);

  /**
   * Returns a list of Word objects that are the suggestions to any word.
   * If the word is correctly spelled, then this method
   * could return just that one word, or it could still return a list
   * of words with similar spellings.
   * <br/>
   * Each suggested word has a score, which is an integer
   * that represents how different the suggested word is from the sourceWord.
   * If the words are the exactly the same, then the score is 0.
   * You can get the dictionary to only return the most similar words by setting
   * an appropriately low threshold value.
   * If you set the threshold value too low, you may get no suggestions for a given word.
   * <p>
   * @param sourceWord the string that we want to get a list of spelling suggestions for
   * @param scoreThreshold Any words that have score less than this number are returned.
   * @param Two dimensional int array used to calculate edit distance. Allocating 
   * this memory outside of the function will greatly improve efficiency.   
   * @return List a List of suggested words
   * @see com.swabunga.spell.engine.Word
   */
  public List getSuggestions(String sourceWord, int scoreThreshold , int[][] matrix);

}
