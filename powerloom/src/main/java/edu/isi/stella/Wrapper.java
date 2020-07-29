//  -*- Mode: Java -*-
//
// Wrapper.java

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

public abstract class Wrapper extends Stella_Object {
  public Stella_Object walkAtomicTree(Object [] MV_returnarray) {
    { Wrapper self = this;

      { Stella_Object _return_temp = self;

        MV_returnarray[0] = Wrapper.wrapperValueType(self);
        return (_return_temp);
      }
    }
  }

  /** Return the type of the value stored in the wrapper <code>self</code>.
   * @param self
   * @return Surrogate
   */
  public static Surrogate wrapperValueType(Wrapper self) {
    { Surrogate wrappertype = self.primaryType();
      Surrogate valuetype = Surrogate.wrappedTypeToType(wrappertype);

      if (valuetype == wrappertype) {
        throw ((StellaException)(StellaException.newStellaException("Missing *wrapped-type-table* entry").fillInStackTrace()));
      }
      else {
        return (valuetype);
      }
    }
  }

  public boolean terminateWrapperP() {
    { Wrapper self = this;

      if ((self == Stella.NULL_LONG_INTEGER_WRAPPER) ||
          ((self == Stella.NULL_FLOAT_WRAPPER) ||
           ((self == Stella.NULL_STRING_WRAPPER) ||
            ((self == Stella.NULL_MUTABLE_STRING_WRAPPER) ||
             ((self == Stella.NULL_CHARACTER_WRAPPER) ||
              ((self == Stella.NULL_FUNCTION_CODE_WRAPPER) ||
               (self == Stella.NULL_METHOD_CODE_WRAPPER))))))) {
        return (false);
      }
      else {
        return (true);
      }
    }
  }

  public int hashCode_() {
    { Wrapper self = this;

      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("WRAPPER.hash-code: Don't know how to hash on `" + self + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  /** Return true if <code>x</code> and <code>y</code> are literal wrappers whose
   * literals are considered <code>eqlP</code>.
   * @param y
   * @return boolean
   */
  public boolean objectEqualP(Stella_Object y) {
    { Wrapper x = this;

      return (x.objectEqlP(y));
    }
  }

}

