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

import com.swabunga.util.StringUtility;

import java.io.*;
import java.util.HashMap;
import java.util.Vector;

/**
 * A Generic implementation of a transformator takes an 
 * <a href="http://aspell.net/man-html/Phonetic-Code.html">
 * aspell phonetics file</a> and constructs some sort of transformation 
 * table using the inner class TransformationRule.
 * </p>
 * Basically, each transformation rule represent a line in the phonetic file.
 * One line contains two groups of characters separated by white space(s).
 * The first group is the <em>match expression</em>. 
 * The <em>match expression</em> describe letters to associate with a syllable.
 * The second group is the <em>replacement expression</em> giving the phonetic 
 * equivalent of the <em>match expression</em>.
 *
 * @see SpellDictionaryASpell SpellDictionaryASpell for information on getting
 * phonetic files for aspell.
 *
 * @author Robert Gustavsson (robert@lindesign.se)
 */
public class GenericTransformator implements Transformator {


  /**
   * This replace list is used if no phonetic file is supplied or it doesn't
   * contain the alphabet.
   */
  private static final char[] defaultEnglishAlphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

  /**
   * The alphabet start marker.
   * @see GenericTransformator#KEYWORD_ALPHBET KEYWORD_ALPHBET
   */
  public static final char ALPHABET_START = '[';
  /**
   * The alphabet end marker.
   * @see GenericTransformator#KEYWORD_ALPHBET KEYWORD_ALPHBET
   */
  public static final char ALPHABET_END = ']';
  /**
   * Phonetic file keyword indicating that a different alphabet is used 
   * for this language. The keyword must be followed an
   * {@link GenericTransformator#ALPHABET_START ALPHABET_START} marker, 
   * a list of characters defining the alphabet and a
   * {@link GenericTransformator#ALPHABET_END ALPHABET_END} marker.
   */
  public static final String KEYWORD_ALPHBET = "alphabet";
  /**
   * Phonetic file lines starting with the keywords are skipped. 
   * The key words are: version, followup, collapse_result.
   * Comments, starting with '#', are also skipped to the end of line.
   */
  public static final String[] IGNORED_KEYWORDS = {"version", "followup", "collapse_result"};

  /**
   * Start a group of characters which can be appended to the match expression
   * of the phonetic file.
   */
  public static final char STARTMULTI = '(';
  /**
   * End a group of characters which can be appended to the match expression
   * of the phonetic file.
   */
  public static final char ENDMULTI = ')';
  /**
   * During phonetic transformation of a word each numeric character is
   * replaced by this DIGITCODE.
   */
  public static final String DIGITCODE = "0";
  /**
   * Phonetic file character code indicating that the replace expression
   * is empty.
   */
  public static final String REPLACEVOID = "_";

  private Object[] ruleArray = null;
  private char[] alphabetString = defaultEnglishAlphabet;

  /**
   * Construct a transformation table from the phonetic file
   * @param phonetic the phonetic file as specified in aspell
   * @throws java.io.IOException indicates a problem while reading
   * the phonetic file
   */
  public GenericTransformator(File phonetic) throws IOException {
    buildRules(new BufferedReader(new FileReader(phonetic)));
    alphabetString = washAlphabetIntoReplaceList(getReplaceList());

  }

  /**
   * Construct a transformation table from the phonetic file
   * @param phonetic the phonetic file as specified in aspell
   * @param encoding the character set required
   * @throws java.io.IOException indicates a problem while reading
   * the phonetic file
   */
  public GenericTransformator(File phonetic, String encoding) throws IOException {
    buildRules(new BufferedReader(new InputStreamReader(new FileInputStream(phonetic), encoding)));
    alphabetString = washAlphabetIntoReplaceList(getReplaceList());
  }

  /**
   * Construct a transformation table from the phonetic file
   * @param phonetic the phonetic file as specified in aspell. The file is
   * supplied as a reader.
   * @throws java.io.IOException indicates a problem while reading
   * the phonetic information
   */
  public GenericTransformator(Reader phonetic) throws IOException {
    buildRules(new BufferedReader(phonetic));
    alphabetString = washAlphabetIntoReplaceList(getReplaceList());
  }

  /**
   * Goes through an alphabet and makes sure that only one of those letters
   * that are coded equally will be in the replace list.
   * In other words, it removes any letters in the alphabet
   * that are redundant phonetically.
   *
   * This is done to improve speed in the getSuggestion method.
   *
   * @param alphabet The complete alphabet to wash.
   * @return The washed alphabet to be used as replace list.
   */
  private char[] washAlphabetIntoReplaceList(char[] alphabet) {

    HashMap letters = new HashMap(alphabet.length);

    for (int i = 0; i < alphabet.length; i++) {
      String tmp = String.valueOf(alphabet[i]);
      String code = transform(tmp);
      if (!letters.containsKey(code)) {
        letters.put(code, new Character(alphabet[i]));
      }
    }

    Object[] tmpCharacters = letters.values().toArray();
    char[] washedArray = new char[tmpCharacters.length];

    for (int i = 0; i < tmpCharacters.length; i++) {
      washedArray[i] = ((Character) tmpCharacters[i]).charValue();
    }

    return washedArray;
  }


  /**
   * Takes out all single character replacements and put them in a char array.
   * This array can later be used for adding or changing letters in getSuggestion().
   * @return char[] An array of chars with replacements characters
   */
  public char[] getCodeReplaceList() {
    char[] replacements;
    TransformationRule rule;
    Vector tmp = new Vector();

    if (ruleArray == null)
      return null;
    for (int i = 0; i < ruleArray.length; i++) {
      rule = (TransformationRule) ruleArray[i];
      if (rule.getReplaceExp().length() == 1)
        tmp.addElement(rule.getReplaceExp());
    }
    replacements = new char[tmp.size()];
    for (int i = 0; i < tmp.size(); i++) {
      replacements[i] = ((String) tmp.elementAt(i)).charAt(0);
    }
    return replacements;
  }

  /**
   * Builds up an char array with the chars in the alphabet of the language as it was read from the
   * alphabet tag in the phonetic file.
   * @return char[] An array of chars representing the alphabet or null if no alphabet was available.
   */
  public char[] getReplaceList() {
    return alphabetString;
  }

  /**
   * Builds the phonetic code of the word.
   * @param word the word to transform
   * @return the phonetic transformation of the word
   */
  public String transform(String word) {

    if (ruleArray == null)
      return null;

    TransformationRule rule;
    StringBuffer str = new StringBuffer(word.toUpperCase());
    int strLength = str.length();
    int startPos = 0, add = 1;

    while (startPos < strLength) {

      add = 1;
      if (Character.isDigit(str.charAt(startPos))) {
        StringUtility.replace(str, startPos, startPos + DIGITCODE.length(), DIGITCODE);
        startPos += add;
        continue;
      }

      for (int i = 0; i < ruleArray.length; i++) {
        //System.out.println("Testing rule#:"+i);
        rule = (TransformationRule) ruleArray[i];
        if (rule.startsWithExp() && startPos > 0)
          continue;
        if (startPos + rule.lengthOfMatch() > strLength) {
          continue;
        }
        if (rule.isMatching(str, startPos)) {
          String replaceExp = rule.getReplaceExp();

          add = replaceExp.length();
          StringUtility.replace(str, startPos, startPos + rule.getTakeOut(), replaceExp);
          strLength -= rule.getTakeOut();
          strLength += add;
          //System.out.println("Replacing with rule#:"+i+" add="+add);
          break;
        }
      }
      startPos += add;
    }
    //System.out.println(word);
    //System.out.println(str.toString());
    return str.toString();
  }

  // Used to build up the transformastion table.
  private void buildRules(BufferedReader in) throws IOException {
    String read = null;
    Vector ruleList = new Vector();
    while ((read = in.readLine()) != null) {
      buildRule(realTrimmer(read), ruleList);
    }
    ruleArray = new TransformationRule[ruleList.size()];
    ruleList.copyInto(ruleArray);
  }

  // Here is where the real work of reading the phonetics file is done.
  private void buildRule(String str, Vector ruleList) {
    if (str.length() < 1)
      return;
    for (int i = 0; i < IGNORED_KEYWORDS.length; i++) {
      if (str.startsWith(IGNORED_KEYWORDS[i]))
        return;
    }

    // A different alphabet is used for this language, will be read into
    // the alphabetString variable.
    if (str.startsWith(KEYWORD_ALPHBET)) {
      int start = str.indexOf(ALPHABET_START);
      int end = str.lastIndexOf(ALPHABET_END);
      if (end != -1 && start != -1) {
        alphabetString = str.substring(++start, end).toCharArray();
      }
      return;
    }

    // str contains two groups of characters separated by white space(s).
    // The fisrt group is the "match expression". The second group is the 
    // "replacement expression" giving the phonetic equivalent of the 
    // "match expression".
    TransformationRule rule = null;
    StringBuffer matchExp = new StringBuffer();
    StringBuffer replaceExp = new StringBuffer();
    boolean start = false,
        end = false;
    int takeOutPart = 0,
        matchLength = 0;
    boolean match = true,
        inMulti = false;
    for (int i = 0; i < str.length(); i++) {
      if (Character.isWhitespace(str.charAt(i))) {
        match = false;
      } else {
        if (match) {
          if (!isReservedChar(str.charAt(i))) {
            matchExp.append(str.charAt(i));
            if (!inMulti) {
              takeOutPart++;
              matchLength++;
            }
            if (str.charAt(i) == STARTMULTI || str.charAt(i) == ENDMULTI)
              inMulti = !inMulti;
          }
          if (str.charAt(i) == '-')
            takeOutPart--;
          if (str.charAt(i) == '^')
            start = true;
          if (str.charAt(i) == '$')
            end = true;
        } else {
          replaceExp.append(str.charAt(i));
        }
      }
    }
    if (replaceExp.toString().equals(REPLACEVOID)) {
      replaceExp = new StringBuffer("");
      //System.out.println("Changing _ to \"\" for "+matchExp.toString());
    }
    rule = new TransformationRule(matchExp.toString(), replaceExp.toString(), takeOutPart, matchLength, start, end);
    //System.out.println(rule.toString());
    ruleList.addElement(rule);
  }

  // Chars with special meaning to aspell. Not everyone is implemented here.
  private boolean isReservedChar(char ch) {
    if (ch == '<' || ch == '>' || ch == '^' || ch == '$' || ch == '-' || Character.isDigit(ch))
      return true;
    return false;
  }

  // Trims off everything we don't care about.
  private String realTrimmer(String row) {
    int pos = row.indexOf('#');
    if (pos != -1) {
      row = row.substring(0, pos);
    }
    return row.trim();
  }

  // Inner Classes
  /*
  * Holds the match string and the replace string and all the rule attributes.
  * Is responsible for indicating matches.
  */
  private class TransformationRule {

    private String replace;
    private char[] match;
    // takeOut=number of chars to replace;
    // matchLength=length of matching string counting multies as one.
    private int takeOut, matchLength;
    private boolean start, end;

    // Construktor
    public TransformationRule(String match, String replace, int takeout, int matchLength, boolean start, boolean end) {
      this.match = match.toCharArray();
      this.replace = replace;
      this.takeOut = takeout;
      this.matchLength = matchLength;
      this.start = start;
      this.end = end;
    }

    /*
    * Returns true if word from pos and forward matches the match string.
    * Precondition: wordPos+matchLength<word.length()
    */
    public boolean isMatching(StringBuffer word, int wordPos) {
      boolean matching = true, inMulti = false, multiMatch = false;
      char matchCh;

      for (int matchPos = 0; matchPos < match.length; matchPos++) {
        matchCh = match[matchPos];
        if (matchCh == STARTMULTI || matchCh == ENDMULTI) {
          inMulti = !inMulti;
          if (!inMulti)
            matching = matching & multiMatch;
          else
            multiMatch = false;
        } else {
          if (matchCh != word.charAt(wordPos)) {
            if (inMulti)
              multiMatch = multiMatch | false;
            else
              matching = false;
          } else {
            if (inMulti)
              multiMatch = multiMatch | true;
            else
              matching = true;
          }
          if (!inMulti)
            wordPos++;
          if (!matching)
            break;
        }
      }
      if (end && wordPos != word.length())
        matching = false;
      return matching;
    }

    public String getReplaceExp() {
      return replace;
    }

    public int getTakeOut() {
      return takeOut;
    }

    public boolean startsWithExp() {
      return start;
    }

    public int lengthOfMatch() {
      return matchLength;
    }

    // Just for debugging purposes.
    public String toString() {
      return "Match:" + String.valueOf(match) + " Replace:" + replace + " TakeOut:" + takeOut + " MatchLength:" + matchLength + " Start:" + start + " End:" + end;
    }

  }
}
