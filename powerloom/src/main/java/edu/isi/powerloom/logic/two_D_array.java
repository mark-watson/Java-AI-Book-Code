//  -*- Mode: Java -*-
//
// two_D_array.java

/*
 +---------------------------- BEGIN LICENSE BLOCK ---------------------------+
 |                                                                            |
 | Version: MPL 1.1/GPL 2.0/LGPL 2.1                                          |
 |                                                                            |
 | The contents of this file are subject to the Mozilla Public License        |
 | Version 1.1 (the "License"); you may not use this file except in           |
 | compliance with the License. You may obtain a copy of the License at       |
 | http://www.mozilla.org/MPL/                                                |
 |                                                                            |
 | Software distributed under the License is distributed on an "AS IS" basis, |
 | WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License   |
 | for the specific language governing rights and limitations under the       |
 | License.                                                                   |
 |                                                                            |
 | The Original Code is the PowerLoom KR&R System.                            |
 |                                                                            |
 | The Initial Developer of the Original Code is                              |
 | UNIVERSITY OF SOUTHERN CALIFORNIA, INFORMATION SCIENCES INSTITUTE          |
 | 4676 Admiralty Way, Marina Del Rey, California 90292, U.S.A.               |
 |                                                                            |
 | Portions created by the Initial Developer are Copyright (C) 1997-2017      |
 | the Initial Developer. All Rights Reserved.                                |
 |                                                                            |
 | Contributor(s):                                                            |
 |                                                                            |
 | Alternatively, the contents of this file may be used under the terms of    |
 | either the GNU General Public License Version 2 or later (the "GPL"), or   |
 | the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),   |
 | in which case the provisions of the GPL or the LGPL are applicable instead |
 | of those above. If you wish to allow use of your version of this file only |
 | under the terms of either the GPL or the LGPL, and not to allow others to  |
 | use your version of this file under the terms of the MPL, indicate your    |
 | decision by deleting the provisions above and replace them with the notice |
 | and other provisions required by the GPL or the LGPL. If you do not delete |
 | the provisions above, a recipient may use your version of this file under  |
 | the terms of any one of the MPL, the GPL or the LGPL.                      |
 |                                                                            |
 +----------------------------- END LICENSE BLOCK ----------------------------+
*/

package edu.isi.powerloom.logic;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.stella.*;

/** Two-dimensional arrays with elements of type OBJECT.
 * @author Stella Java Translator
 */
public class two_D_array extends MultiDimensionalArray {
    public int nofRows;
    public int nofColumns;
    public edu.isi.stella.Stella_Object[] theArray;

  public static two_D_array new2_D_array(int nofRows, int nofColumns) {
    { two_D_array self = null;

      self = new two_D_array();
      self.nofRows = nofRows;
      self.nofColumns = nofColumns;
      self.theArray = null;
      two_D_array.initialize2_D_array(self);
      return (self);
    }
  }

  /** Print the array <code>self</code> to <code>stream</code>.
   * @param stream
   */
  public void printArray(edu.isi.stella.javalib.NativeOutputStream stream) {
    { two_D_array self = this;

      { int nofRows = self.nofRows;
        int nofColumns = self.nofColumns;
        int limit = 9;

        stream.print("|i|[");
        { int row = Stella.NULL_INTEGER;
          int iter000 = 0;
          int upperBound000 = nofRows - 1;

          loop000 : for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
            row = iter000;
            stream.print("[");
            { int column = Stella.NULL_INTEGER;
              int iter001 = 0;
              int upperBound001 = nofColumns - 1;

              loop001 : for (;iter001 <= upperBound001; iter001 = iter001 + 1) {
                column = iter001;
                stream.print((self.theArray)[((row * self.nofColumns) + column)]);
                if (column > limit) {
                  stream.print(" ...]");
                  break loop001;
                }
                else if (column < (nofColumns - 1)) {
                  stream.print(" ");
                }
                else {
                  stream.print("]");
                }
              }
            }
            if (row > limit) {
              stream.print(" ...]");
              break loop000;
            }
            else if (row < (nofRows - 1)) {
              stream.print(" ");
            }
            else {
              stream.print("]");
            }
          }
        }
      }
    }
  }

  /** Fill the two-dimensional array <code>self</code> in row-major-order
   * from <code>values</code>.  Missing values will retain their old values, extraneous values
   * will be ignored.
   * @param values
   */
  public void fillArray(Cons values) {
    { two_D_array self = this;

      { edu.isi.stella.Stella_Object[] nativearray = self.theArray;

        { int i = Stella.NULL_INTEGER;
          int iter000 = 0;
          int upperBound000 = (self.nofRows * self.nofColumns) - 1;
          Stella_Object value = null;
          Cons iter001 = values;

          for (;(iter000 <= upperBound000) &&
                    (!(iter001 == Stella.NIL)); iter000 = iter000 + 1, iter001 = iter001.rest) {
            i = iter000;
            value = iter001.value;
            nativearray[i] = value;
          }
        }
      }
    }
  }

  /** Set the element of <code>array</code> at position [<code>row</code>, <code>column</code>]
   * to <code>value</code> and return the result.
   * @param value
   * @param row
   * @param column
   * @return Stella_Object
   */
  public Stella_Object two_D_elementSetter(Stella_Object value, int row, int column) {
    { two_D_array array = this;

      return ((array.theArray)[((row * array.nofColumns) + column)] = value);
    }
  }

  /** Return the element of <code>array</code> at position [<code>row</code>, <code>column</code>].
   * @param row
   * @param column
   * @return Stella_Object
   */
  public Stella_Object two_D_element(int row, int column) {
    { two_D_array array = this;

      return ((array.theArray)[((row * array.nofColumns) + column)]);
    }
  }

  public static void initialize2_D_array(two_D_array self) {
    { Vector vector = Vector.newVector(self.nofRows * self.nofColumns);

      self.theArray = vector.theArray;
      vector.theArray = null;
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { two_D_array self = this;

      self.printArray(stream);
    }
  }

  public static Stella_Object access2_D_arraySlotValue(two_D_array self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_NOF_ROWS) {
      if (setvalueP) {
        self.nofRows = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.nofRows);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_NOF_COLUMNS) {
      if (setvalueP) {
        self.nofColumns = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.nofColumns);
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + slotname + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    return (value);
  }

  public Surrogate primaryType() {
    { two_D_array self = this;

      return (Logic.SGT_LOGIC_2_D_ARRAY);
    }
  }

}

