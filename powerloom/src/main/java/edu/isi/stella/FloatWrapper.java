//  -*- Mode: Java -*-
//
// FloatWrapper.java

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
| The Original Code is the STELLA Programming Language.                      |
|                                                                            |
| The Initial Developer of the Original Code is                              |
| UNIVERSITY OF SOUTHERN CALIFORNIA, INFORMATION SCIENCES INSTITUTE          |
| 4676 Admiralty Way, Marina Del Rey, California 90292, U.S.A.               |
|                                                                            |
| Portions created by the Initial Developer are Copyright (C) 1996-2017      |
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
+---------------------------- END LICENSE BLOCK -----------------------------+
*/

package edu.isi.stella;

import edu.isi.stella.javalib.*;

public class FloatWrapper extends NumberWrapper {
    public double wrapperValue;

  /** Return a literal object whose value is the FLOAT 'value'.
   * @param value
   * @return FloatWrapper
   */
  public static FloatWrapper wrapFloat(double value) {
    if (value == Stella.NULL_FLOAT) {
      return (Stella.NULL_FLOAT_WRAPPER);
    }
    else {
      return (FloatWrapper.newFloatWrapper(value));
    }
  }

  public static FloatWrapper newFloatWrapper(double wrapperValue) {
    { FloatWrapper self = null;

      self = new FloatWrapper();
      self.wrapperValue = wrapperValue;
      return (self);
    }
  }

  public void javaOutputLiteral() {
    { FloatWrapper renamed_Float = this;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(renamed_Float.wrapperValue);
    }
  }

  public void cppOutputLiteral() {
    { FloatWrapper renamed_Float = this;

      { String value = Native.floatToString(renamed_Float.wrapperValue);
        boolean integervalueP = true;

        { char ch = Stella.NULL_CHARACTER;
          String vector000 = value;
          int index000 = 0;
          int length000 = vector000.length();

          loop000 : for (;index000 < length000; index000 = index000 + 1) {
            ch = vector000.charAt(index000);
            if (Native.string_memberP(".eE", ch)) {
              integervalueP = false;
              break loop000;
            }
          }
        }
        if (integervalueP) {
          value = value + ".0";
        }
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(value);
      }
    }
  }

  public Stella_Object clTranslateAtomicTree() {
    { FloatWrapper tree = this;

      { String floatString = Native.stringify(tree);

        if (Native.string_memberP(floatString, 'e')) {
          floatString = Native.string_substitute(floatString, 'd', 'e');
        }
        else if (Native.string_memberP(floatString, 'E')) {
          floatString = Native.string_substitute(floatString, 'd', 'E');
        }
        else {
          floatString = floatString + "d0";
        }
        return (VerbatimStringWrapper.newVerbatimStringWrapper(floatString));
      }
    }
  }

  public double numberWrapperToFloat() {
    { FloatWrapper self = this;

      return (self.wrapperValue);
    }
  }

  public boolean objectEqlP(Stella_Object y) {
    { FloatWrapper x = this;

      return ((y != null) &&
          (((y.primaryType() == Stella.SGT_STELLA_FLOAT_WRAPPER) ||
          Stella_Object.isaP(y, Stella.SGT_STELLA_FLOAT_WRAPPER)) &&
           (x.wrapperValue == ((FloatWrapper)(y)).wrapperValue)));
    }
  }

  public Stella_Object copyWrappedLiteral() {
    { FloatWrapper self = this;

      return (FloatWrapper.wrapFloat(self.wrapperValue));
    }
  }

  /** Unwrap <code>wrapper</code> and return the result.
   * Return NULL if <code>wrapper</code> is NULL.
   * @param wrapper
   * @return double
   */
  public static double unwrapFloat(FloatWrapper wrapper) {
    if (wrapper == null) {
      return (Stella.NULL_FLOAT);
    }
    else {
      return (wrapper.wrapperValue);
    }
  }

  public static boolean wrappedFloatLessThanP(FloatWrapper x, FloatWrapper y) {
    return (x.wrapperValue < y.wrapperValue);
  }

  public int hashCode_() {
    { FloatWrapper self = this;

      return ((int)(Double.doubleToLongBits((self.wrapperValue))^(Double.doubleToLongBits((self.wrapperValue))>>>32)));
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { FloatWrapper self = this;

      { double value = self.wrapperValue;

        if (value == Stella.NULL_FLOAT) {
          if (((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue()) {
            stream.print(Stella.SYM_STELLA_NULL_FLOAT);
          }
          else {
            stream.print("|L|NULL-FLOAT");
          }
        }
        else {
          if (((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue()) {
            stream.print(value);
          }
          else {
            stream.print("|L|" + value);
          }
        }
      }
    }
  }

  public static Stella_Object accessFloatWrapperSlotValue(FloatWrapper self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_WRAPPER_VALUE) {
      if (setvalueP) {
        self.wrapperValue = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.wrapperValue);
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
    { FloatWrapper self = this;

      return (Stella.SGT_STELLA_FLOAT_WRAPPER);
    }
  }

}

