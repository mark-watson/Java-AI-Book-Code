//  -*- Mode: Java -*-
//
// BooleanWrapper.java

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

/** Objectified version of the BOOLEAN data type.  The NULL
 * value can be used for a 3-valued semantics (see THREE-VALUED-BOOLEAN).
 * @author Stella Java Translator
 */
public class BooleanWrapper extends LiteralWrapper {
    public boolean wrapperValue;

  /** Return a literal object whose value is the BOOLEAN 'value'.
   * @param value
   * @return BooleanWrapper
   */
  public static BooleanWrapper wrapBoolean(boolean value) {
    return ((value ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
  }

  public static BooleanWrapper newBooleanWrapper(boolean wrapperValue) {
    { BooleanWrapper self = null;

      self = new BooleanWrapper();
      self.wrapperValue = wrapperValue;
      return (self);
    }
  }

  public void javaOutputLiteral() {
    { BooleanWrapper renamed_Boolean = this;

      if (renamed_Boolean.wrapperValue) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("true");
      }
      else {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("false");
      }
    }
  }

  public void cppOutputLiteral() {
    { BooleanWrapper renamed_Boolean = this;

      if (renamed_Boolean.wrapperValue) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("TRUE");
      }
      else {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("FALSE");
      }
    }
  }

  public boolean objectEqlP(Stella_Object y) {
    { BooleanWrapper x = this;

      return ((x == y) ||
          ((y != null) &&
           (((y.primaryType() == Stella.SGT_STELLA_BOOLEAN_WRAPPER) ||
          Stella_Object.isaP(y, Stella.SGT_STELLA_BOOLEAN_WRAPPER)) &&
            (x.wrapperValue == ((BooleanWrapper)(y)).wrapperValue))));
    }
  }

  public static boolean coerceWrappedBooleanToBoolean(BooleanWrapper wrapper) {
    if (wrapper == null) {
      {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Coercing an undefined BOOLEAN-WRAPPER to FALSE.  Explicitly guard");
        Stella.STANDARD_WARNING.nativeStream.println(" with `defined?' or use `unwrap-boolean' to avoid this warning.");
      }
;
    }
    return (wrapper == Stella.TRUE_WRAPPER);
  }

  /** Unwrap <code>wrapper</code> and return its values as a regular BOOLEAN.
   * Map NULL onto FALSE.
   * @param wrapper
   * @return boolean
   */
  public static boolean unwrapBoolean(BooleanWrapper wrapper) {
    return (wrapper == Stella.TRUE_WRAPPER);
  }

  public int hashCode_() {
    { BooleanWrapper self = this;

      return ((self.wrapperValue ? 7333705 : 1891526));
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { BooleanWrapper self = this;

      {
        if (!(((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue())) {
          stream.print("|L|");
        }
        if (self.wrapperValue) {
          stream.print(Stella.SYM_STELLA_TRUE);
        }
        else {
          stream.print(Stella.SYM_STELLA_FALSE);
        }
      }
    }
  }

  public static Stella_Object accessBooleanWrapperSlotValue(BooleanWrapper self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_WRAPPER_VALUE) {
      if (setvalueP) {
        self.wrapperValue = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.wrapperValue ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
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
    { BooleanWrapper self = this;

      return (Stella.SGT_STELLA_BOOLEAN_WRAPPER);
    }
  }

}

