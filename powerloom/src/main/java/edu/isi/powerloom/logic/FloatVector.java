//  -*- Mode: Java -*-
//
// FloatVector.java

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

public class FloatVector extends AbstractCollection {
    public int arraySize;
    public edu.isi.stella.Stella_Object[] theArray;

  public static FloatVector newFloatVector(int arraySize) {
    { FloatVector self = null;

      self = new FloatVector();
      self.arraySize = arraySize;
      self.theArray = null;
      FloatVector.initializeFloatVector(self);
      return (self);
    }
  }

  public boolean memberP(double renamed_Object) {
    { FloatVector self = this;

      { edu.isi.stella.Stella_Object[] array = self.theArray;

        { int i = Stella.NULL_INTEGER;
          int iter000 = 0;
          int upperBound000 = self.arraySize - 1;

          for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
            i = iter000;
            if (((FloatWrapper)(((FloatWrapper)(array[i])))).wrapperValue == renamed_Object) {
              return (true);
            }
          }
        }
        return (false);
      }
    }
  }

  public int length() {
    { FloatVector self = this;

      return (self.arraySize);
    }
  }

  public double nthSetter(double value, int position) {
    { FloatVector self = this;

      return (((FloatWrapper)(((FloatWrapper)((self.theArray)[position])))).wrapperValue = value);
    }
  }

  public double nth(int position) {
    { FloatVector self = this;

      return (((FloatWrapper)(((FloatWrapper)((self.theArray)[position])))).wrapperValue);
    }
  }

  /** Return TRUE if 'self' has length &gt; 0.
   * @return boolean
   */
  public boolean nonEmptyP() {
    { FloatVector self = this;

      return (self.arraySize > 0);
    }
  }

  /** Return TRUE if 'self' has length 0.
   * @return boolean
   */
  public boolean emptyP() {
    { FloatVector self = this;

      return (self.arraySize == 0);
    }
  }

  public void printVector(edu.isi.stella.javalib.NativeOutputStream stream) {
    { FloatVector self = this;

      if (self.arraySize == 0) {
        stream.print("|i|[]");
      }
      else {
        { int i = 0;
          int limit = 9;

          stream.print("|i|[");
          { double element = Stella.NULL_FLOAT;
            FloatVector vector000 = self;
            int index000 = 0;
            int length000 = vector000.arraySize;

            loop000 : for (;index000 < length000; index000 = index000 + 1) {
              element = ((FloatWrapper)(((FloatWrapper)((vector000.theArray)[index000])))).wrapperValue;
              stream.print(element);
              i = i + 1;
              if (i > limit) {
                break loop000;
              }
              if (i < self.arraySize) {
                stream.print(" ");
              }
            }
          }
          if ((i <= limit) ||
              (i == self.arraySize)) {
            stream.print("]");
          }
          else {
            stream.print(" ...]");
          }
        }
      }
    }
  }

  public static void initializeFloatVector(FloatVector self) {
    { Vector vector = Vector.newVector(self.arraySize);

      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = vector.length() - 1;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          (vector.theArray)[i] = (FloatWrapper.newFloatWrapper(Stella.NULL_FLOAT));
        }
      }
      self.theArray = ((edu.isi.stella.Stella_Object[])(vector.theArray));
      vector.theArray = null;
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { FloatVector self = this;

      self.printVector(stream);
    }
  }

  public static Stella_Object accessFloatVectorSlotValue(FloatVector self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_STELLA_ARRAY_SIZE) {
      if (setvalueP) {
        self.arraySize = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.arraySize);
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
    { FloatVector self = this;

      return (Logic.SGT_LOGIC_FLOAT_VECTOR);
    }
  }

}

