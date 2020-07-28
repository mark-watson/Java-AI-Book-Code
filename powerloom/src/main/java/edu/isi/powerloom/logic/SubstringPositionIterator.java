//  -*- Mode: Java -*-
//
// SubstringPositionIterator.java

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

public class SubstringPositionIterator extends Iterator {
    public String superString;
    public String subString;
    public int start;
    public int subLength;

  public static SubstringPositionIterator newSubstringPositionIterator(String superString, String subString) {
    { SubstringPositionIterator self = null;

      self = new SubstringPositionIterator();
      self.superString = superString;
      self.subString = subString;
      self.firstIterationP = true;
      self.value = null;
      self.subLength = (self.subString).length();
      self.start = 0;
      return (self);
    }
  }

  public int length() {
    { SubstringPositionIterator it = this;

      { int count = 0;
        String renamed_Super = it.superString;
        String sub = it.subString;
        int p1 = Native.stringSearch(renamed_Super, sub, 0);

        while (p1 != Stella.NULL_INTEGER) {
          count = count + 1;
          p1 = Native.stringSearch(renamed_Super, sub, p1 + 1);
        }
        return (count);
      }
    }
  }

  public boolean nextP() {
    { SubstringPositionIterator it = this;

      { int p1 = Native.stringSearch(it.superString, it.subString, it.start);

        if (p1 != Stella.NULL_INTEGER) {
          {
            it.value = Cons.cons(IntegerWrapper.wrapInteger(p1), Cons.cons(IntegerWrapper.wrapInteger(p1 + it.subLength), Stella.NIL));
            it.start = p1 + 1;
            return (true);
          }
        }
        else {
          {
            it.value = null;
            return (false);
          }
        }
      }
    }
  }

  public static Stella_Object accessSubstringPositionIteratorSlotValue(SubstringPositionIterator self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_SUPER_STRING) {
      if (setvalueP) {
        self.superString = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.superString);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_SUB_STRING) {
      if (setvalueP) {
        self.subString = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.subString);
      }
    }
    else if (slotname == Logic.SYM_STELLA_START) {
      if (setvalueP) {
        self.start = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.start);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_SUB_LENGTH) {
      if (setvalueP) {
        self.subLength = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.subLength);
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
    { SubstringPositionIterator self = this;

      return (Logic.SGT_LOGIC_SUBSTRING_POSITION_ITERATOR);
    }
  }

}

