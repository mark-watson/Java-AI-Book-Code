//  -*- Mode: Java -*-
//
// LogicThing.java

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

/** A subclass of THING so we can add methods to it in
 * the PowerLoom LOGIC module.
 * @author Stella Java Translator
 */
public class LogicThing extends Thing {
  public static LogicThing newLogicThing() {
    { LogicThing self = null;

      self = new LogicThing();
      self.dynamicSlots = KeyValueList.newKeyValueList();
      self.surrogateValueInverse = null;
      return (self);
    }
  }

  /** Method to generate a specialized term for <code>self</code>.  This is designed
   * to allow for extension of the term generation code to cover other
   * types of objects for the logic.  This particular method will signal
   * an error unless there is a surrogate-value-inverse link set.
   * @return Stella_Object
   */
  public Stella_Object generateSpecializedTerm() {
    { LogicThing self = this;

      if (self.surrogateValueInverse != null) {
        return (self.surrogateValueInverse);
      }
      else {
        throw ((TermGenerationException)(TermGenerationException.newTermGenerationException(self, "DON'T KNOW HOW TO GENERATE EXPRESSION FOR THE THING: " + Native.stringify(self)).fillInStackTrace()));
      }
    }
  }

  public static Stella_Object accessLogicThingSlotValue(LogicThing self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (true) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, slotname, value, null);
      }
      else {
        value = self.dynamicSlots.lookup(slotname);
      }
    }
    return (value);
  }

  public Surrogate primaryType() {
    { LogicThing self = this;

      return (Logic.SGT_LOGIC_LOGIC_THING);
    }
  }

}

