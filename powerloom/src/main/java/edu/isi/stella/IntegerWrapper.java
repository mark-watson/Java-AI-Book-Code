//  -*- Mode: Java -*-
//
// IntegerWrapper.java

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

public class IntegerWrapper extends NumberWrapper {
    public int wrapperValue;

  /** Return a literal object whose value is the INTEGER 'value'.
   * @param value
   * @return IntegerWrapper
   */
  public static IntegerWrapper wrapInteger(int value) {
    if (value == Stella.NULL_INTEGER) {
      return (Stella.NULL_INTEGER_WRAPPER);
    }
    else {
      switch (value) {
        case 0: 
          return (Stella.ZERO_WRAPPER);
        case 1: 
          return (Stella.ONE_WRAPPER);
        default:
          return (IntegerWrapper.newIntegerWrapper(value));
      }
    }
  }

  public static IntegerWrapper newIntegerWrapper(int wrapperValue) {
    { IntegerWrapper self = null;

      self = new IntegerWrapper();
      self.wrapperValue = wrapperValue;
      return (self);
    }
  }

  public void javaOutputLiteral() {
    { IntegerWrapper renamed_Int = this;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(renamed_Int.wrapperValue);
    }
  }

  public void cppOutputLiteral() {
    { IntegerWrapper renamed_Int = this;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(renamed_Int.wrapperValue);
    }
  }

  public double numberWrapperToFloat() {
    { IntegerWrapper self = this;

      return (((double)(self.wrapperValue)));
    }
  }

  public boolean objectEqlP(Stella_Object y) {
    { IntegerWrapper x = this;

      return ((y != null) &&
          (((y.primaryType() == Stella.SGT_STELLA_INTEGER_WRAPPER) ||
          Stella_Object.isaP(y, Stella.SGT_STELLA_INTEGER_WRAPPER)) &&
           (x.wrapperValue == ((IntegerWrapper)(y)).wrapperValue)));
    }
  }

  public Stella_Object copyWrappedLiteral() {
    { IntegerWrapper self = this;

      return (IntegerWrapper.wrapInteger(self.wrapperValue));
    }
  }

  /** Unwrap <code>wrapper</code> and return the result.
   * Return NULL if <code>wrapper</code> is NULL.
   * @param wrapper
   * @return int
   */
  public static int unwrapInteger(IntegerWrapper wrapper) {
    if (wrapper == null) {
      return (Stella.NULL_INTEGER);
    }
    else {
      return (wrapper.wrapperValue);
    }
  }

  public boolean terminateWrapperP() {
    { IntegerWrapper self = this;

      if ((self == Stella.ZERO_WRAPPER) ||
          ((self == Stella.ONE_WRAPPER) ||
           (self == Stella.NULL_INTEGER_WRAPPER))) {
        return (false);
      }
      else {
        return (true);
      }
    }
  }

  public static boolean wrappedIntegerLessThanP(IntegerWrapper x, IntegerWrapper y) {
    return (x.wrapperValue < y.wrapperValue);
  }

  public int hashCode_() {
    { IntegerWrapper self = this;

      return (self.wrapperValue);
    }
  }

  /** Signal warning message, placing non-string arguments in quotes.
   * @param level
   * @param test
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object safety(IntegerWrapper level, Stella_Object test, Cons body) {
    if (level.wrapperValue > ((Integer)(Stella.$SAFETY$.get())).intValue()) {
      return (null);
    }
    body = Cons.formatMessageArguments(body, false);
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NOT, Cons.cons(test, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(Stella.KWD_ERROR, Cons.cons(StringWrapper.wrapString("Safety violation: "), Cons.cons(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))));
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { IntegerWrapper self = this;

      { int value = self.wrapperValue;

        if (value == Stella.NULL_INTEGER) {
          if (((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue()) {
            stream.print(Stella.SYM_STELLA_NULL_INTEGER);
          }
          else {
            stream.print("|L|NULL-INTEGER");
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

  public static Stella_Object accessIntegerWrapperSlotValue(IntegerWrapper self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_WRAPPER_VALUE) {
      if (setvalueP) {
        self.wrapperValue = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.wrapperValue);
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
    { IntegerWrapper self = this;

      return (Stella.SGT_STELLA_INTEGER_WRAPPER);
    }
  }

}

