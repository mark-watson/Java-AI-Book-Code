//  -*- Mode: Java -*-
//
// TokenizerTable.java

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

public class TokenizerTable extends StandardObject {
    public String transitions;
    public Vector uniqueStateNames;
    public Vector stateNames;
    public Vector legalEofStates;

  public static TokenizerTable newTokenizerTable() {
    { TokenizerTable self = null;

      self = new TokenizerTable();
      self.legalEofStates = null;
      self.stateNames = null;
      self.uniqueStateNames = null;
      self.transitions = null;
      return (self);
    }
  }

  public static String stringifyTokenizerTable(TokenizerTable table) {
    { OutputStringStream result = OutputStringStream.newOutputStringStream();
      int acode = (int) 'A';
      String transitions = table.transitions;
      StringBuffer encodedtransitions = edu.isi.stella.javalib.Native.makeMutableString((2 * Stella.$MAX_TOKENIZER_STATES$ * Stella.$MAX_TOKENIZER_CHARACTERS$), Stella.NULL_CHARACTER);
      int j = -1;
      Vector uniquestatenames = table.uniqueStateNames;
      Vector statenames = table.stateNames;
      Vector eofstates = table.legalEofStates;
      String separator = "|";

      result.nativeStream.print((2 * Stella.$MAX_TOKENIZER_STATES$ * Stella.$MAX_TOKENIZER_CHARACTERS$) + separator);
      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = (Stella.$MAX_TOKENIZER_STATES$ * Stella.$MAX_TOKENIZER_CHARACTERS$) - 1;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          edu.isi.stella.javalib.Native.mutableString_nthSetter(encodedtransitions, ((char) ((((int) (transitions.charAt(i))) & 15) + acode)), (j = j + 1));
          edu.isi.stella.javalib.Native.mutableString_nthSetter(encodedtransitions, ((char) ((((int) (transitions.charAt(i))) >> 4) + acode)), (j = j + 1));
        }
      }
      result.nativeStream.print(encodedtransitions.toString() + separator);
      result.nativeStream.print(uniquestatenames.length() + separator);
      { GeneralizedSymbol state = null;
        Vector vector000 = uniquestatenames;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          state = ((GeneralizedSymbol)((vector000.theArray)[index000]));
          result.nativeStream.print(state.symbolName + separator);
        }
      }
      result.nativeStream.print(statenames.length() + separator);
      { GeneralizedSymbol state = null;
        Vector vector001 = statenames;
        int index001 = 0;
        int length001 = vector001.length();

        for (;index001 < length001; index001 = index001 + 1) {
          state = ((GeneralizedSymbol)((vector001.theArray)[index001]));
          result.nativeStream.print(state.symbolName + separator);
        }
      }
      result.nativeStream.print(eofstates.length() + separator);
      { BooleanWrapper state = null;
        Vector vector002 = eofstates;
        int index002 = 0;
        int length002 = vector002.length();

        for (;index002 < length002; index002 = index002 + 1) {
          state = ((BooleanWrapper)((vector002.theArray)[index002]));
          result.nativeStream.print(((BooleanWrapper.coerceWrappedBooleanToBoolean(state) ? "T" : "F")));
        }
      }
      result.nativeStream.print(separator);
      return (result.theStringReader());
    }
  }

  public static Stella_Object accessTokenizerTableSlotValue(TokenizerTable self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_TRANSITIONS) {
      if (setvalueP) {
        self.transitions = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.transitions);
      }
    }
    else if (slotname == Stella.SYM_STELLA_UNIQUE_STATE_NAMES) {
      if (setvalueP) {
        self.uniqueStateNames = ((Vector)(value));
      }
      else {
        value = self.uniqueStateNames;
      }
    }
    else if (slotname == Stella.SYM_STELLA_STATE_NAMES) {
      if (setvalueP) {
        self.stateNames = ((Vector)(value));
      }
      else {
        value = self.stateNames;
      }
    }
    else if (slotname == Stella.SYM_STELLA_LEGAL_EOF_STATES) {
      if (setvalueP) {
        self.legalEofStates = ((Vector)(value));
      }
      else {
        value = self.legalEofStates;
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
    { TokenizerTable self = this;

      return (Stella.SGT_STELLA_TOKENIZER_TABLE);
    }
  }

}

