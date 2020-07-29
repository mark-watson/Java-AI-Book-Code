//  -*- Mode: Java -*-
//
// PartialSupport.java

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

public class PartialSupport extends StandardObject {
    public Proposition fact;
    public Proposition axiom;
    public double score;
    public int id;
    public Cons argumentScores;

  public static PartialSupport newPartialSupport() {
    { PartialSupport self = null;

      self = new PartialSupport();
      self.argumentScores = null;
      self.id = Stella.NULL_INTEGER;
      self.score = Stella.NULL_FLOAT;
      self.axiom = null;
      self.fact = null;
      return (self);
    }
  }

  public static Stella_Object accessPartialSupportSlotValue(PartialSupport self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_FACT) {
      if (setvalueP) {
        self.fact = ((Proposition)(value));
      }
      else {
        value = self.fact;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_AXIOM) {
      if (setvalueP) {
        self.axiom = ((Proposition)(value));
      }
      else {
        value = self.axiom;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_SCORE) {
      if (setvalueP) {
        self.score = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.score);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_ID) {
      if (setvalueP) {
        self.id = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.id);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_ARGUMENT_SCORES) {
      if (setvalueP) {
        self.argumentScores = ((Cons)(value));
      }
      else {
        value = self.argumentScores;
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
    { PartialSupport self = this;

      return (Logic.SGT_LOGIC_PARTIAL_SUPPORT);
    }
  }

}

