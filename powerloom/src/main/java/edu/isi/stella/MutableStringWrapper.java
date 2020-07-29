//  -*- Mode: Java -*-
//
// MutableStringWrapper.java

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

public class MutableStringWrapper extends LiteralWrapper {
    public StringBuffer wrapperValue;

  /** Return a literal object whose value is the MUTABLE-STRING 'value'.
   * @param value
   * @return MutableStringWrapper
   */
  public static MutableStringWrapper wrapMutableString(StringBuffer value) {
    if (value == null) {
      return (Stella.NULL_MUTABLE_STRING_WRAPPER);
    }
    else {
      return (MutableStringWrapper.newMutableStringWrapper(value));
    }
  }

  public static MutableStringWrapper newMutableStringWrapper(StringBuffer wrapperValue) {
    { MutableStringWrapper self = null;

      self = new MutableStringWrapper();
      self.wrapperValue = wrapperValue;
      return (self);
    }
  }

  public void idlOutputLiteral() {
    { MutableStringWrapper string = this;

      Stella.string_idlOutputLiteral((string.wrapperValue).toString());
    }
  }

  public void javaOutputLiteral() {
    { MutableStringWrapper string = this;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("new StringBuffer(");
      Stella.string_javaOutputLiteral((string.wrapperValue).toString());
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
    }
  }

  public void cppOutputLiteral() {
    { MutableStringWrapper string = this;

      Stella.string_cppOutputLiteral((string.wrapperValue).toString());
    }
  }

  public boolean objectEqlP(Stella_Object y) {
    { MutableStringWrapper x = this;

      return (x == y);
    }
  }

  public Stella_Object copyWrappedLiteral() {
    { MutableStringWrapper self = this;

      return (MutableStringWrapper.wrapMutableString(self.wrapperValue));
    }
  }

  /** Unwrap <code>wrapper</code> and return the result.
   * Return NULL if <code>wrapper</code> is NULL.
   * @param wrapper
   * @return StringBuffer
   */
  public static StringBuffer unwrapMutableString(MutableStringWrapper wrapper) {
    if (wrapper == null) {
      return (null);
    }
    else {
      return (wrapper.wrapperValue);
    }
  }

  public static boolean wrappedMutableStringLessThanP(MutableStringWrapper x, MutableStringWrapper y) {
    return (Stella.stringL((x.wrapperValue).toString(), (y.wrapperValue).toString()));
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { MutableStringWrapper self = this;

      { StringBuffer value = self.wrapperValue;

        if (value == null) {
          if (((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue()) {
            stream.print(Stella.SYM_STELLA_NULL_MUTABLE_STRING);
          }
          else {
            stream.print("|L|NULL-MUTABLE-STRING");
          }
        }
        else {
          if (((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue()) {
            Stella.printStringReadably(value.toString(), stream);
          }
          else {
            stream.print("|L|\"" + value.toString() + "\"");
          }
        }
      }
    }
  }

  public Surrogate primaryType() {
    { MutableStringWrapper self = this;

      return (Stella.SGT_STELLA_MUTABLE_STRING_WRAPPER);
    }
  }

}

