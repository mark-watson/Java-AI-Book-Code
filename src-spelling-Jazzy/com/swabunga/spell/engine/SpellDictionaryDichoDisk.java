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
import java.util.*;

/**
 * Another implementation of <code>SpellDictionary</code> that doesn't cache any words in memory. Avoids the huge
 * footprint of <code>SpellDictionaryHashMap</code> at the cost of relatively minor latency. A future version
 * of this class that implements some caching strategies might be a good idea in the future, if there's any
 * demand for it.
 *
 * This implementation requires a special dictionary file, with "code*word" lines sorted by code.
 * It's using a dichotomy algorithm to search for words in the dictionary
 *
 * @author Damien Guillaume
 * @version 0.1
 */
public class SpellDictionaryDichoDisk extends SpellDictionaryASpell {

  /** Holds the dictionary file for reading*/
  private RandomAccessFile dictFile = null;

  /** dictionary and phonetic file encoding */
  private String encoding = null;

  /**
   * Dictionary convenience Constructor.
   * @param wordList The file containing the words list for the dictionary
   * @throws java.io.FileNotFoundException indicates problems locating the
   * words list file on the system
   * @throws java.io.IOException indicates problems reading the words list
   * file
   */
  public SpellDictionaryDichoDisk(File wordList)
    throws FileNotFoundException, IOException {
    super((File) null);
    dictFile = new RandomAccessFile(wordList, "r");
  }

  /**
   * Dictionary convenience Constructor.
   * @param wordList The file containing the words list for the dictionary
   * @param encoding Uses the character set encoding specified
   * @throws java.io.FileNotFoundException indicates problems locating the
   * words list file on the system
   * @throws java.io.IOException indicates problems reading the words list
   * file
   */
  public SpellDictionaryDichoDisk(File wordList, String encoding)
    throws FileNotFoundException, IOException {
    super((File) null);
    this.encoding = encoding;
    dictFile = new RandomAccessFile(wordList, "r");
  }

  /**
  * Dictionary constructor that uses an aspell phonetic file to
  * build the transformation table.
  * @param wordList The file containing the words list for the dictionary
  * @param phonetic The file to use for phonetic transformation of the 
  * wordlist.
  * @throws java.io.FileNotFoundException indicates problems locating the
  * file on the system
  * @throws java.io.IOException indicates problems reading the words list
  * file
  */
  public SpellDictionaryDichoDisk(File wordList, File phonetic)
    throws FileNotFoundException, IOException {
    super(phonetic);
    dictFile = new RandomAccessFile(wordList, "r");
  }
  
  /**
  * Dictionary constructor that uses an aspell phonetic file to
  * build the transformation table.
  * @param wordList The file containing the words list for the dictionary
  * @param phonetic The file to use for phonetic transformation of the 
  * wordlist.
  * @param encoding Uses the character set encoding specified
  * @throws java.io.FileNotFoundException indicates problems locating the
  * file on the system
  * @throws java.io.IOException indicates problems reading the words list
  * file
  */
  public SpellDictionaryDichoDisk(File wordList, File phonetic, String encoding)
    throws FileNotFoundException, IOException {
    super(phonetic, encoding);
    this.encoding = encoding;
    dictFile = new RandomAccessFile(wordList, "r");
  }
  
  /**
   * Add a word permanently to the dictionary (and the dictionary file).
   * <i>not implemented !</i>
   * @param word The word to add.
   */
  public void addWord(String word) {
    System.err.println("error: addWord is not implemented for SpellDictionaryDichoDisk");
  }

  /**
    * Search the dictionary file for the words corresponding to the code
    * within positions p1 - p2
    */
   private LinkedList dichoFind(String code, long p1, long p2) throws IOException {
     //System.out.println("dichoFind("+code+","+p1+","+p2+")");
     long pm = (p1 + p2) / 2;
    dictFile.seek(pm);
    String l;
    if (encoding == null)
      l = dictFile.readLine();
    else
      l = dictReadLine();
    pm = dictFile.getFilePointer();
    if (encoding == null)
      l = dictFile.readLine();
    else
      l = dictReadLine();
    long pm2 = dictFile.getFilePointer();
    if (pm2 >= p2)
      return(seqFind(code, p1, p2));
    int istar = l.indexOf('*');
    if (istar == -1)
      throw new IOException("bad format: no * !");
    String testcode = l.substring(0, istar);
    int comp = code.compareTo(testcode);
    if (comp < 0)
      return(dichoFind(code, p1, pm-1));
    else if (comp > 0)
      return(dichoFind(code, pm2, p2));
    else {
      LinkedList l1 = dichoFind(code, p1, pm-1);
      LinkedList l2 = dichoFind(code, pm2, p2);
      String word = l.substring(istar+1);
      l1.add(word);
      l1.addAll(l2);
      return(l1);
    }
   }
   
   private LinkedList seqFind(String code, long p1, long p2) throws IOException {
     //System.out.println("seqFind("+code+","+p1+","+p2+")");
     LinkedList list = new LinkedList();
    dictFile.seek(p1);
    while (dictFile.getFilePointer() < p2) {
      String l;
      if (encoding == null)
        l = dictFile.readLine();
      else
        l = dictReadLine();
      int istar = l.indexOf('*');
      if (istar == -1)
        throw new IOException("bad format: no * !");
      String testcode = l.substring(0, istar);
      if (testcode.equals(code)) {
        String word = l.substring(istar+1);
        list.add(word);
      }
    }
    return(list);
   }
   
   /**
     * Read a line of dictFile with a specific encoding
     */
   private String dictReadLine() throws IOException {
     int max = 255;
     byte b=0;
    byte[] buf = new byte[max];
    int i=0;
     try {
       for (; b != '\n' && b != '\r' && i<max-1; i++) {
        b = dictFile.readByte();
         buf[i] = b;
      }
    } catch (EOFException ex) {
    }
    if (i == 0)
      return("");
    String s = new String(buf, 0, i-1, encoding);
    return(s);
   }
   
  /**
   * Returns a list of strings (words) for the code.
   * @param code The phonetic code common to the list of words
   * @return A list of words having the same phonetic code
   */
  public List getWords(String code) {
     //System.out.println("getWords("+code+")");
    LinkedList list;
    try {
      list = dichoFind(code, 0, dictFile.length()-1);
      //System.out.println(list);
    } catch (IOException ex) {
      System.err.println("IOException: " + ex.getMessage());
      list = new LinkedList();
    }
    return list;
  }

}

