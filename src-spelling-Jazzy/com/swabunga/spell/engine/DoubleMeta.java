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
 * A phonetic encoding algorithm that takes an English word and computes a phonetic version of it. This
 * allows for phonetic matches in a spell checker. This class is a port of the C++ DoubleMetaphone() class,
 * which was intended to return two possible phonetic translations for certain words, although the Java version
 * only seems to be concerned with one, making the "double" part erroneous.
 * <br>
 * source code for the original C++ can be found
 * here: <a href="http://aspell.sourceforge.net/metaphone/"/>http://aspell.sourceforge.net/metaphone/</a>
 * DoubleMetaphone does some processing, such as uppercasing, on the input string first to normalize it. Then, to
 * create the key, the function traverses the input string in a while loop, sending successive characters into a giant
 * switch statement. Before determining the appropriate pronunciation, the algorithm considers the context
 * surrounding each character within the input string.
 * <p>
 * Things that were changed:
 *   <br/>The alternate flag could be set to true but was never checked so why bother with it. REMOVED
 *   <br/>Why was this class serializable?
 *   <br/>The primary, in, length and last variables could be initialized and local to the
 *   process method and references passed around the appropriate methods. As such there are
 *   no class variables and this class becomes firstly threadsafe and secondly could be static final.
 *   <br/>The function call SlavoGermaic was called repeatedly in the process function, it is now only called once.
 *
 */
public class DoubleMeta implements Transformator {

  /**
   * The replace list is used in the getSuggestions method.
   * All of the letters in the misspelled word are replaced with the characters from
   * this list to try and generate more suggestions, which implies l*n tries,
   * if l is the size of the string, and n is the size of this list.
   *
   * In addition to that, each of these letters is added to the misspelled word.
   */
  private static char[] replaceList = {'A', 'B', 'X', 'S', 'K', 'J', 'T', 'F', 'H', 'L', 'M', 'N', 'P', 'R', '0'};


  private static final String[] myList = {"GN", "KN", "PN", "WR", "PS", ""};
  private static final String[] list1 = {"ACH", ""};
  private static final String[] list2 = {"BACHER", "MACHER", ""};
  private static final String[] list3 = {"CAESAR", ""};
  private static final String[] list4 = {"CHIA", ""};
  private static final String[] list5 = {"CH", ""};
  private static final String[] list6 = {"CHAE", ""};
  private static final String[] list7 = {"HARAC", "HARIS", ""};
  private static final String[] list8 = {"HOR", "HYM", "HIA", "HEM", ""};
  private static final String[] list9 = {"CHORE", ""};
  private static final String[] list10 = {"VAN ", "VON ", ""};
  private static final String[] list11 = {"SCH", ""};
  private static final String[] list12 = {"ORCHES", "ARCHIT", "ORCHID", ""};
  private static final String[] list13 = {"T", "S", ""};
  private static final String[] list14 = {"A", "O", "U", "E", ""};
  private static final String[] list15 = {"L", "R", "N", "M", "B", "H", "F", "V", "W", " ", ""};
  private static final String[] list16 = {"MC", ""};
  private static final String[] list17 = {"CZ", ""};
  private static final String[] list18 = {"WICZ", ""};
  private static final String[] list19 = {"CIA", ""};
  private static final String[] list20 = {"CC", ""};
  private static final String[] list21 = {"I", "E", "H", ""};
  private static final String[] list22 = {"HU", ""};
  private static final String[] list23 = {"UCCEE", "UCCES", ""};
  private static final String[] list24 = {"CK", "CG", "CQ", ""};
  private static final String[] list25 = {"CI", "CE", "CY", ""};
// DMV: used by the orininal code which returned two phonetic code, but not the current code
//    private static final String[] list26 = {
//        "CIO", "CIE", "CIA", ""
//    };
  private static final String[] list27 = {" C", " Q", " G", ""};
  private static final String[] list28 = {"C", "K", "Q", ""};
  private static final String[] list29 = {"CE", "CI", ""};
  private static final String[] list30 = {"DG", ""};
  private static final String[] list31 = {"I", "E", "Y", ""};
  private static final String[] list32 = {"DT", "DD", ""};
  private static final String[] list33 = {"B", "H", "D", ""};
  private static final String[] list34 = {"B", "H", "D", ""};
  private static final String[] list35 = {"B", "H", ""};
  private static final String[] list36 = {"C", "G", "L", "R", "T", ""};
  private static final String[] list37 = {"EY", ""};
  private static final String[] list38 = {"LI", ""};
  private static final String[] list39 = {"ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER", ""};
  private static final String[] list40 = {"ER", ""};
  private static final String[] list41 = {"DANGER", "RANGER", "MANGER", ""};
  private static final String[] list42 = {"E", "I", ""};
  private static final String[] list43 = {"RGY", "OGY", ""};
  private static final String[] list44 = {"E", "I", "Y", ""};
  private static final String[] list45 = {"AGGI", "OGGI", ""};
  private static final String[] list46 = {"VAN ", "VON ", ""};
  private static final String[] list47 = {"SCH", ""};
  private static final String[] list48 = {"ET", ""};

//  DMV: used by the orininal code which returned two phonetic code, but not the current code
//    private static final String[] list49 = {
//        "IER ", ""
//    };
  private static final String[] list50 = {"JOSE", ""};
  private static final String[] list51 = {"SAN ", ""};
  private static final String[] list52 = {"SAN ", ""};
  private static final String[] list53 = {"JOSE", ""};
  private static final String[] list54 = {"L", "T", "K", "S", "N", "M", "B", "Z", ""};
  private static final String[] list55 = {"S", "K", "L", ""};
  private static final String[] list56 = {"ILLO", "ILLA", "ALLE", ""};
  private static final String[] list57 = {"AS", "OS", ""};
  private static final String[] list58 = {"A", "O", ""};
  private static final String[] list59 = {"ALLE", ""};
  private static final String[] list60 = {"UMB", ""};
  private static final String[] list61 = {"ER", ""};
  private static final String[] list62 = {"P", "B", ""};
  private static final String[] list63 = {"IE", ""};
  private static final String[] list64 = {"ME", "MA", ""};
  private static final String[] list65 = {"ISL", "YSL", ""};
  private static final String[] list66 = {"SUGAR", ""};
  private static final String[] list67 = {"SH", ""};
  private static final String[] list68 = {"HEIM", "HOEK", "HOLM", "HOLZ", ""};
  private static final String[] list69 = {"SIO", "SIA", ""};
  private static final String[] list70 = {"SIAN", ""};
  private static final String[] list71 = {"M", "N", "L", "W", ""};
  private static final String[] list72 = {"Z", ""};
  private static final String[] list73 = {"Z", ""};
  private static final String[] list74 = {"SC", ""};
  private static final String[] list75 = {"OO", "ER", "EN", "UY", "ED", "EM", ""};
  private static final String[] list76 = {"ER", "EN", ""};
  private static final String[] list77 = {"I", "E", "Y", ""};
  private static final String[] list78 = {"AI", "OI", ""};
  private static final String[] list79 = {"S", "Z", ""};
  private static final String[] list80 = {"TION", ""};
  private static final String[] list81 = {"TIA", "TCH", ""};
  private static final String[] list82 = {"TH", ""};
  private static final String[] list83 = {"TTH", ""};
  private static final String[] list84 = {"OM", "AM", ""};
  private static final String[] list85 = {"VAN ", "VON ", ""};
  private static final String[] list86 = {"SCH", ""};
  private static final String[] list87 = {"T", "D", ""};
  private static final String[] list88 = {"WR", ""};
  private static final String[] list89 = {"WH", ""};
  private static final String[] list90 = {"EWSKI", "EWSKY", "OWSKI", "OWSKY", ""};
  private static final String[] list91 = {"SCH", ""};
  private static final String[] list92 = {"WICZ", "WITZ", ""};
  private static final String[] list93 = {"IAU", "EAU", ""};
  private static final String[] list94 = {"AU", "OU", ""};
  private static final String[] list95 = {"C", "X", ""};

//  DMV: used by the orininal code which returned two phonetic code, but not the current code
//    private static final String[] list96 = {
//        "ZO", "ZI", "ZA", ""
//    };

  /**
   * put your documentation comment here
   * @return
   */
  private final static boolean SlavoGermanic(String in) {
    if ((in.indexOf("W") > -1) || (in.indexOf("K") > -1) || (in.indexOf("CZ") > -1) || (in.indexOf("WITZ") > -1))
      return true;
    return false;
  }

  /**
   * put your documentation comment here
   * @param main
   */
  private final static void MetaphAdd(StringBuffer primary, String main) {
    if (main != null) {
      primary.append(main);
    }
  }

  private final static void MetaphAdd(StringBuffer primary, char main) {
    primary.append(main);
  }

  /**
   * put your documentation comment here
   * @param at
   * @return
   */
  private final static boolean isVowel(String in, int at, int length) {
    if ((at < 0) || (at >= length))
      return false;
    char it = in.charAt(at);
    if ((it == 'A') || (it == 'E') || (it == 'I') || (it == 'O') || (it == 'U') || (it == 'Y'))
      return true;
    return false;
  }

  /**
   * put your documentation comment here
   * @param string
   * @param start
   * @param length
   * @param list
   * @return
   */
  private final static boolean stringAt(String string, int start, int length, String[] list) {
    if ((start < 0) || (start >= string.length()) || list.length == 0)
      return false;
    String substr = string.substring(start, start + length);
    for (int i = 0; i < list.length; i++) {
      if (list[i].equals(substr))
        return true;
    }
    return false;
  }

  /**
   * Take the given word, and return the best phonetic hash for it.
   * Vowels are minimized as much as possible, and consenants
   * that have similiar sounds are converted to the same consenant
   * for example, 'v' and 'f' are both converted to 'f'
   * @param word the texte to transform
   * @return the result of the phonetic transformation
   */
  public final String transform(String word) {
    StringBuffer primary = new StringBuffer(word.length() + 5);
    String in = word.toUpperCase() + "     ";
    int current = 0;
    int length = in.length();
    if (length < 1)
      return "";
    int last = length - 1;
    boolean isSlavoGermaic = SlavoGermanic(in);
    if (stringAt(in, 0, 2, myList))
      current += 1;
    if (in.charAt(0) == 'X') {
      MetaphAdd(primary, 'S');
      current += 1;
    }
    while (current < length) {
      switch (in.charAt(current)) {
        case 'A':
        case 'E':
        case 'I':
        case 'O':
        case 'U':
        case 'Y':
          if (current == 0)
            MetaphAdd(primary, 'A');
          current += 1;
          break;
        case 'B':
          MetaphAdd(primary, 'P');
          if (in.charAt(current + 1) == 'B')
            current += 2;
          else
            current += 1;
          break;
        case '\u00C7':
          MetaphAdd(primary, 'S');
          current += 1;
          break;
        case 'C':
          if ((current > 1) && !isVowel(in, current - 2, length) && stringAt(in, (current - 1), 3, list1) && (in.charAt(current + 2) != 'I') && (in.charAt(current + 2) != 'E') || stringAt(in, (current - 2), 6, list2)) {
            MetaphAdd(primary, 'K');
            current += 2;
            break;
          }
          if ((current == 0) && stringAt(in, current, 6, list3)) {
            MetaphAdd(primary, 'S');
            current += 2;
            break;
          }
          if (stringAt(in, current, 4, list4)) {
            MetaphAdd(primary, 'K');
            current += 2;
            break;
          }
          if (stringAt(in, current, 2, list5)) {
            if ((current > 0) && stringAt(in, current, 4, list6)) {
              MetaphAdd(primary, 'K');
              current += 2;
              break;
            }
            if ((current == 0) && stringAt(in, (current + 1), 5, list7) || stringAt(in, current + 1, 3, list8) && !stringAt(in, 0, 5, list9)) {
              MetaphAdd(primary, 'K');
              current += 2;
              break;
            }
            if (stringAt(in, 0, 4, list10) || stringAt(in, 0, 3, list11) || stringAt(in, current - 2, 6, list12) || stringAt(in, current + 2, 1, list13) || (stringAt(in, current - 1, 1, list14) || (current == 0)) && stringAt(in, current + 2, 1, list15)) {
              MetaphAdd(primary, 'K');
            } else {
              if (current > 0) {
                if (stringAt(in, 0, 2, list16))
                  MetaphAdd(primary, 'K');
                else
                  MetaphAdd(primary, 'X');
              } else {
                MetaphAdd(primary, 'X');
              }
            }
            current += 2;
            break;
          }
          if (stringAt(in, current, 2, list17) && !stringAt(in, current, 4, list18)) {
            MetaphAdd(primary, 'S');
            current += 2;
            break;
          }
          if (stringAt(in, current, 2, list19)) {
            MetaphAdd(primary, 'X');
            current += 2;
            break;
          }
          if (stringAt(in, current, 2, list20) && !((current == 1) && in.charAt(0) == 'M')) {
            if (stringAt(in, current + 2, 1, list21) && !stringAt(in, current + 2, 2, list22)) {
              if (((current == 1) && (in.charAt(current - 1) == 'A')) || stringAt(in, (current - 1), 5, list23))
                MetaphAdd(primary, "KS");
              else
                MetaphAdd(primary, 'X');
              current += 3;
              break;
            } else {
              MetaphAdd(primary, 'K');
              current += 2;
              break;
            }
          }
          if (stringAt(in, current, 2, list24)) {
            MetaphAdd(primary, 'K');
            current += 2;
            break;
          } else if (stringAt(in, current, 2, list25)) {
            MetaphAdd(primary, 'S');
            current += 2;
            break;
          }

          MetaphAdd(primary, 'K');
          if (stringAt(in, current + 1, 2, list27))
            current += 3;
          else if (stringAt(in, current + 1, 1, list28) && !stringAt(in, current + 1, 2, list29))
            current += 2;
          else
            current += 1;
          break;
        case 'D':
          if (stringAt(in, current, 2, list30)) {
            if (stringAt(in, current + 2, 1, list31)) {
              MetaphAdd(primary, 'J');
              current += 3;
              break;
            } else {
              MetaphAdd(primary, "TK");
              current += 2;
              break;
            }
          }
          MetaphAdd(primary, 'T');
          if (stringAt(in, current, 2, list32)) {
            current += 2;
          } else {
            current += 1;
          }
          break;
        case 'F':
          if (in.charAt(current + 1) == 'F')
            current += 2;
          else
            current += 1;
          MetaphAdd(primary, 'F');
          break;
        case 'G':
          if (in.charAt(current + 1) == 'H') {
            if ((current > 0) && !isVowel(in, current - 1, length)) {
              MetaphAdd(primary, 'K');
              current += 2;
              break;
            }
            if (current < 3) {
              if (current == 0) {
                if (in.charAt(current + 2) == 'I')
                  MetaphAdd(primary, 'J');
                else
                  MetaphAdd(primary, 'K');
                current += 2;
                break;
              }
            }
            if ((current > 1) && stringAt(in, current - 2, 1, list33) || ((current > 2) && stringAt(in, current - 3, 1, list34)) || ((current > 3) && stringAt(in, current - 4, 1, list35))) {
              current += 2;
              break;
            } else {
              if ((current > 2) && (in.charAt(current - 1) == 'U') && stringAt(in, current - 3, 1, list36)) {
                MetaphAdd(primary, 'F');
              } else {
                if ((current > 0) && (in.charAt(current - 1) != 'I'))
                  MetaphAdd(primary, 'K');
              }
              current += 2;
              break;
            }
          }
          if (in.charAt(current + 1) == 'N') {
            if ((current == 1) && isVowel(in, 0, length) && !isSlavoGermaic) {
              MetaphAdd(primary, "KN");
            } else {
              if (!stringAt(in, current + 2, 2, list37) && (in.charAt(current + 1) != 'Y') && !isSlavoGermaic) {
                MetaphAdd(primary, "N");
              } else {
                MetaphAdd(primary, "KN");
              }
            }
            current += 2;
            break;
          }
          if (stringAt(in, current + 1, 2, list38) && !isSlavoGermaic) {
            MetaphAdd(primary, "KL");
            current += 2;
            break;
          }
          if ((current == 0) && ((in.charAt(current + 1) == 'Y') || stringAt(in, current + 1, 2, list39))) {
            MetaphAdd(primary, 'K');
            current += 2;
            break;
          }
          if ((stringAt(in, current + 1, 2, list40) || (in.charAt(current + 1) == 'Y')) && !stringAt(in, 0, 6, list41) && !stringAt(in, current - 1, 1, list42) && !stringAt(in, current - 1, 3, list43)) {
            MetaphAdd(primary, 'K');
            current += 2;
            break;
          }
          if (stringAt(in, current + 1, 1, list44) || stringAt(in, current - 1, 4, list45)) {
            if (stringAt(in, 0, 4, list46) || stringAt(in, 0, 3, list47) || stringAt(in, current + 1, 2, list48)) {
              MetaphAdd(primary, 'K');
            } else {
              MetaphAdd(primary, 'J');
            }
            current += 2;
            break;
          }
          if (in.charAt(current + 1) == 'G')
            current += 2;
          else
            current += 1;
          MetaphAdd(primary, 'K');
          break;
        case 'H':
          if (((current == 0) || isVowel(in, current - 1, length)) && isVowel(in, current + 1, length)) {
            MetaphAdd(primary, 'H');
            current += 2;
          } else {
            current += 1;
          }
          break;
        case 'J':
          if (stringAt(in, current, 4, list50) || stringAt(in, 0, 4, list51)) {
            if ((current == 0) && (in.charAt(current + 4) == ' ') || stringAt(in, 0, 4, list52)) {
              MetaphAdd(primary, 'H');
            } else {
              MetaphAdd(primary, 'J');
            }
            current += 1;
            break;
          }
          if ((current == 0) && !stringAt(in, current, 4, list53)) {
            MetaphAdd(primary, 'J');
          } else {
            if (isVowel(in, current - 1, length) && !isSlavoGermaic && ((in.charAt(current + 1) == 'A') || in.charAt(current + 1) == 'O')) {
              MetaphAdd(primary, 'J');
            } else {
              if (current == last) {
                MetaphAdd(primary, 'J');
              } else {
                if (!stringAt(in, current + 1, 1, list54) && !stringAt(in, current - 1, 1, list55)) {
                  MetaphAdd(primary, 'J');
                }
              }
            }
          }
          if (in.charAt(current + 1) == 'J')
            current += 2;
          else
            current += 1;
          break;
        case 'K':
          if (in.charAt(current + 1) == 'K')
            current += 2;
          else
            current += 1;
          MetaphAdd(primary, 'K');
          break;
        case 'L':
          if (in.charAt(current + 1) == 'L') {
            if (((current == (length - 3)) && stringAt(in, current - 1, 4, list56)) || ((stringAt(in, last - 1, 2, list57) || stringAt(in, last, 1, list58)) && stringAt(in, current - 1, 4, list59))) {
              MetaphAdd(primary, 'L');
              current += 2;
              break;
            }
            current += 2;
          } else
            current += 1;
          MetaphAdd(primary, 'L');
          break;
        case 'M':
          if ((stringAt(in, current - 1, 3, list60) && (((current + 1) == last) || stringAt(in, current + 2, 2, list61))) || (in.charAt(current + 1) == 'M'))
            current += 2;
          else
            current += 1;
          MetaphAdd(primary, 'M');
          break;
        case 'N':
          if (in.charAt(current + 1) == 'N')
            current += 2;
          else
            current += 1;
          MetaphAdd(primary, 'N');
          break;
        case '\u00D1':
          current += 1;
          MetaphAdd(primary, 'N');
          break;
        case 'P':
          if (in.charAt(current + 1) == 'N') {
            MetaphAdd(primary, 'F');
            current += 2;
            break;
          }
          if (stringAt(in, current + 1, 1, list62))
            current += 2;
          else
            current += 1;
          MetaphAdd(primary, 'P');
          break;
        case 'Q':
          if (in.charAt(current + 1) == 'Q')
            current += 2;
          else
            current += 1;
          MetaphAdd(primary, 'K');
          break;
        case 'R':
          if ((current == last) && !isSlavoGermaic && stringAt(in, current - 2, 2, list63) && !stringAt(in, current - 4, 2, list64)) {
//            MetaphAdd(primary, "");
          } else
            MetaphAdd(primary, 'R');
          if (in.charAt(current + 1) == 'R')
            current += 2;
          else
            current += 1;
          break;
        case 'S':
          if (stringAt(in, current - 1, 3, list65)) {
            current += 1;
            break;
          }
          if ((current == 0) && stringAt(in, current, 5, list66)) {
            MetaphAdd(primary, 'X');
            current += 1;
            break;
          }
          if (stringAt(in, current, 2, list67)) {
            if (stringAt(in, current + 1, 4, list68))
              MetaphAdd(primary, 'S');
            else
              MetaphAdd(primary, 'X');
            current += 2;
            break;
          }
          if (stringAt(in, current, 3, list69) || stringAt(in, current, 4, list70)) {
            MetaphAdd(primary, 'S');
            current += 3;
            break;
          }
          if (((current == 0) && stringAt(in, current + 1, 1, list71)) || stringAt(in, current + 1, 1, list72)) {
            MetaphAdd(primary, 'S');
            if (stringAt(in, current + 1, 1, list73))
              current += 2;
            else
              current += 1;
            break;
          }
          if (stringAt(in, current, 2, list74)) {
            if (in.charAt(current + 2) == 'H')
              if (stringAt(in, current + 3, 2, list75)) {
                if (stringAt(in, current + 3, 2, list76)) {
                  MetaphAdd(primary, "X");
                } else {
                  MetaphAdd(primary, "SK");
                }
                current += 3;
                break;
              } else {
                MetaphAdd(primary, 'X');
                current += 3;
                break;
              }
            if (stringAt(in, current + 2, 1, list77)) {
              MetaphAdd(primary, 'S');
              current += 3;
              break;
            }
            MetaphAdd(primary, "SK");
            current += 3;
            break;
          }
          if ((current == last) && stringAt(in, current - 2, 2, list78)) {
            //MetaphAdd(primary, "");
          } else
            MetaphAdd(primary, 'S');
          if (stringAt(in, current + 1, 1, list79))
            current += 2;
          else
            current += 1;
          break;
        case 'T':
          if (stringAt(in, current, 4, list80)) {
            MetaphAdd(primary, 'X');
            current += 3;
            break;
          }
          if (stringAt(in, current, 3, list81)) {
            MetaphAdd(primary, 'X');
            current += 3;
            break;
          }
          if (stringAt(in, current, 2, list82) || stringAt(in, current, 3, list83)) {
            if (stringAt(in, (current + 2), 2, list84) || stringAt(in, 0, 4, list85) || stringAt(in, 0, 3, list86)) {
              MetaphAdd(primary, 'T');
            } else {
              MetaphAdd(primary, '0');
            }
            current += 2;
            break;
          }
          if (stringAt(in, current + 1, 1, list87)) {
            current += 2;
          } else
            current += 1;
          MetaphAdd(primary, 'T');
          break;
        case 'V':
          if (in.charAt(current + 1) == 'V')
            current += 2;
          else
            current += 1;
          MetaphAdd(primary, 'F');
          break;
        case 'W':
          if (stringAt(in, current, 2, list88)) {
            MetaphAdd(primary, 'R');
            current += 2;
            break;
          }
          if ((current == 0) && (isVowel(in, current + 1, length) || stringAt(in, current, 2, list89))) {
            MetaphAdd(primary, 'A');
          }
          if (((current == last) && isVowel(in, current - 1, length)) || stringAt(in, current - 1, 5, list90) || stringAt(in, 0, 3, list91)) {
            MetaphAdd(primary, 'F');
            current += 1;
            break;
          }
          if (stringAt(in, current, 4, list92)) {
            MetaphAdd(primary, "TS");
            current += 4;
            break;
          }
          current += 1;
          break;
        case 'X':
          if (!((current == last) && (stringAt(in, current - 3, 3, list93) || stringAt(in, current - 2, 2, list94))))
            MetaphAdd(primary, "KS");
          if (stringAt(in, current + 1, 1, list95))
            current += 2;
          else
            current += 1;
          break;
        case 'Z':
          if (in.charAt(current + 1) == 'H') {
            MetaphAdd(primary, 'J');
            current += 2;
            break;
          } else {
            MetaphAdd(primary, 'S');
          }
          if (in.charAt(current + 1) == 'Z')
            current += 2;
          else
            current += 1;
          break;
        default:
          current += 1;
      }
    }
    return primary.toString();
  }

  /**
   * @see com.swabunga.spell.engine.Transformator#getReplaceList()
   */
  public char[] getReplaceList() {
    return replaceList;
  }
}



