//  -*- Mode: Java -*-
//
// LongIntegerWrapper.java

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

public class LongIntegerWrapper extends NumberWrapper {
    public long wrapperValue;

  public static LongIntegerWrapper newLongIntegerWrapper(long wrapperValue) {
    { LongIntegerWrapper self = null;

      self = new LongIntegerWrapper();
      self.wrapperValue = wrapperValue;
      return (self);
    }
  }

  public void javaOutputLiteral() {
    { LongIntegerWrapper renamed_Int = this;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(renamed_Int.wrapperValue + "l");
    }
  }

  public void cppOutputLiteral() {
    { LongIntegerWrapper renamed_Int = this;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(renamed_Int.wrapperValue + "l");
    }
  }

  public double numberWrapperToFloat() {
    { LongIntegerWrapper self = this;

      return (((double)(self.wrapperValue)));
    }
  }

  public boolean objectEqlP(Stella_Object y) {
    { LongIntegerWrapper x = this;

      return ((y != null) &&
          (((y.primaryType() == Stella.SGT_STELLA_LONG_INTEGER_WRAPPER) ||
          Stella_Object.isaP(y, Stella.SGT_STELLA_LONG_INTEGER_WRAPPER)) &&
           (x.wrapperValue == ((LongIntegerWrapper)(y)).wrapperValue)));
    }
  }

  public Stella_Object copyWrappedLiteral() {
    { LongIntegerWrapper self = this;

      return (Stella.wrapLongInteger(self.wrapperValue));
    }
  }

  /** Unwrap <code>wrapper</code> and return the result.
   * Return NULL if <code>wrapper</code> is NULL.
   * @param wrapper
   * @return long
   */
  public static long unwrapLongInteger(LongIntegerWrapper wrapper) {
    if (wrapper == null) {
      return (Stella.NULL_LONG_INTEGER);
    }
    else {
      return (wrapper.wrapperValue);
    }
  }

  public static boolean wrappedLongIntegerLessThanP(LongIntegerWrapper x, LongIntegerWrapper y) {
    return (x.wrapperValue < y.wrapperValue);
  }

  public int hashCode_() {
    { LongIntegerWrapper self = this;

      return (((int)(((((self.wrapperValue) ^ (((self.wrapperValue) >> 32)))) & (((long)(Stella.MOST_POSITIVE_INTEGER)))))));
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { LongIntegerWrapper self = this;

      { long value = self.wrapperValue;

        if (value == Stella.NULL_LONG_INTEGER) {
          if (((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue()) {
            stream.print(Stella.SYM_STELLA_NULL_LONG_INTEGER);
          }
          else {
            stream.print("|L|NULL-LONG-INTEGER");
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

  public static Stella_Object accessLongIntegerWrapperSlotValue(LongIntegerWrapper self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_WRAPPER_VALUE) {
      if (setvalueP) {
        self.wrapperValue = ((LongIntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = Stella.wrapLongInteger(self.wrapperValue);
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
    { LongIntegerWrapper self = this;

      return (Stella.SGT_STELLA_LONG_INTEGER_WRAPPER);
    }
  }

}

