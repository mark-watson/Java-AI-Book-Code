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

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * The SpellDictionary class holds the instance of the dictionary.
 * <p>
 * This class is thread safe. Derived classes should ensure that this preserved.
 * </p>
 * <p>
 * There are many open source dictionary files. For just a few see:
 * http://wordlist.sourceforge.net/
 * </p>
 * <p>
 * This dictionary class reads words one per line. Make sure that your word list
 * is formatted in this way (most are).
 * </p>
 */
public class GenericSpellDictionary extends SpellDictionaryASpell {

//tech_monkey: the alphabet / replace list stuff has been moved into the Transformator classes,
//since they are so closely tied to how the phonetic transformations are done.
//    /**
//     * This replace list is used if no phonetic file is supplied or it doesn't
//     * contain the alphabet.
//     */
//    protected static final char[] englishAlphabet =


  /** A field indicating the initial hash map capacity (16KB) for the main
   *  dictionary hash map. Interested to see what the performance of a
   *  smaller initial capacity is like.
   */
  private final static int INITIAL_CAPACITY = 16 * 1024;

  /**
   * The hashmap that contains the word dictionary. The map is hashed on the doublemeta
   * code. The map entry contains a LinkedList of words that have the same double meta code.
   */
  protected HashMap mainDictionary = new HashMap(INITIAL_CAPACITY);

  /** Holds the dictionary file for appending*/
  private File dictFile = null;


  /**
   * Dictionary constructor that uses the DoubleMeta class with the
   * English alphabet.
   * @param wordList The file containing dictionary as a words list.
   * @throws java.io.FileNotFoundException when the words list file could not 
   * be located on the system.
   * @throws java.io.IOException when problems occurs while reading the words 
   * list file
   */
  public GenericSpellDictionary(File wordList) throws FileNotFoundException, IOException {
    this(wordList, (File) null);
  }

  /**
   * Dictionary constructor that uses an aspell phonetic file to
   * build the transformation table.
   * If phonetic is null, then DoubleMeta is used with the English alphabet
   * @param wordList The file containing dictionary as a words list.
   * @param phonetic The file containing the phonetic transformation 
   * information.
   * @throws java.io.FileNotFoundException when the words list or phonetic 
   * file could not be located on the system
   * @throws java.io.IOException when problems occurs while reading the 
   * words list or phonetic file
   */
  public GenericSpellDictionary(File wordList, File phonetic) throws FileNotFoundException, IOException {

    super(phonetic);
    dictFile = wordList;
    createDictionary(new BufferedReader(new FileReader(wordList)));
  }


  /**
   * Add a word permanently to the dictionary (and the dictionary file).
   * <p>This needs to be made thread safe (synchronized)</p>
   * @param word The word to add to the dictionary
   */
  public void addWord(String word) {
    putWord(word);
    if (dictFile == null)
      return;
    try {
      FileWriter w = new FileWriter(dictFile.toString(), true);
      // Open with append.
      w.write(word);
      w.write("\n");
      w.close();
    } catch (IOException ex) {
      System.out.println("Error writing to dictionary file");
    }
  }

  /**
   * Constructs the dictionary from a word list file.
   * <p>
   * Each word in the reader should be on a separate line.
   * <p>
   * This is a very slow function. On my machine it takes quite a while to
   * load the data in. I suspect that we could speed this up quite allot.
   */
  protected void createDictionary(BufferedReader in) throws IOException {
    String line = "";
    while (line != null) {
      line = in.readLine();
      if (line != null) {
        line = new String(line.toCharArray());
        putWord(line);
      }
    }
  }

  /**
   * Allocates a word in the dictionary
   */
  protected void putWord(String word) {
    String code = getCode(word);
    LinkedList list = (LinkedList) mainDictionary.get(code);
    if (list != null) {
      list.add(word);
    } else {
      list = new LinkedList();
      list.add(word);
      mainDictionary.put(code, list);
    }
  }

  /**
   * Returns a list of strings (words) for the code.
   * @param code The phonetic code we want to find words for
   * @return the list of words having the same phonetic code
   */
  public List getWords(String code) {
    //Check the main dictionary.
    List mainDictResult = (List) mainDictionary.get(code);
    if (mainDictResult == null)
      return new Vector();
    return mainDictResult;
  }

  /**
   * Returns true if the word is correctly spelled against the current word list.
   * @param word The word to checked in the dictionary
   * @return indication if the word is in the dictionary
   */
  public boolean isCorrect(String word) {
    List possible = getWords(getCode(word));
    if (possible.contains(word))
      return true;
    //JMH should we always try the lowercase version. If I dont then capitalised
    //words are always returned as incorrect.
    else if (possible.contains(word.toLowerCase()))
      return true;
    return false;
  }
}
