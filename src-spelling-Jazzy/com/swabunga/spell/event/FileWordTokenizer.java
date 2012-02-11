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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * This class tokenizes a input file.
 *
 * <p>
 * Any takers to do this efficiently?? doesn't need to replace any words to
 * start with. I need this to get an idea of how quick the spell checker is.
 * </p>
 */
public class FileWordTokenizer extends AbstractWordTokenizer {

  //~ Instance/static variables ...............................................

//  private File inFile;

  //~ Constructors ............................................................

  /**
   * Creates a new FileWordTokenizer object.
   *
   * @param inputFile the file to work upon
   */
  public FileWordTokenizer(File inputFile) {
    super(stringValue(inputFile));
  }

  /**
   * Creates a new FileWordTokenizer object and associate a WordFinder to it's
   * processing.
   *
   * @param inputFile the file to word upon.
   * @param finder the specialize processing for words.
   */
  public FileWordTokenizer(File inputFile, WordFinder finder) {
    super(finder);
    finder.setText(stringValue(inputFile));
  }
  //~ Methods .................................................................

  /**
   * Replaces the current word token
   *
   * @param s the new string
   * @throws WordNotFoundException current word not yet set.
   */
  public void replaceWord(String s) {
  }

  private static String stringValue(File inFile) {
    File stringFile = inFile;
    StringBuffer out = new StringBuffer("");

    try{
      BufferedReader in = new BufferedReader(new FileReader(inFile));
      char[] c = new char[100];
      int count;
      while ((count = in.read(c, 0, c.length)) != -1){
         out.append(c,0,count);
      }
      in.close();
    } catch(IOException e){
      System.err.println("File input error trying to open " + inFile.toString() + " : " + e);
    }
    return out.toString();
  }
}