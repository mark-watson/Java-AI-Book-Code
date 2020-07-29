//  -*- Mode: Java -*-
//
// WhynotProofClass.java

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

/** Set of equivalent WhyNot proofs that differ in at most one
 * variable binding all on the same <code>deviatingVariable</code>.
 * @author Stella Java Translator
 */
public class WhynotProofClass extends Set {
    public Justification representative;
    public Justification deviatingPattern;
    public PatternVariable deviatingVariable;
    public List deviatingInstances;

  public static WhynotProofClass newWhynotProofClass() {
    { WhynotProofClass self = null;

      self = new WhynotProofClass();
      self.theConsList = Stella.NIL;
      self.deviatingInstances = List.newList();
      self.deviatingVariable = null;
      self.deviatingPattern = null;
      self.representative = null;
      return (self);
    }
  }

  public static boolean betterWhynotProofClassP(WhynotProofClass class1, WhynotProofClass class2) {
    return (Justification.betterWhynotProofP(class1.representative, class2.representative));
  }

  public static boolean insertWhynotProofToClassP(WhynotProofClass renamed_Class, Justification proof) {
    if (renamed_Class.emptyP()) {
      renamed_Class.theConsList = Cons.cons(proof, renamed_Class.theConsList);
      renamed_Class.representative = proof;
      return (true);
    }
    { KeyValueList deviations = KeyValueList.newKeyValueList();
      int founddeviations = Justification.computeProofDeviation(proof, renamed_Class.representative, ((Integer)(Logic.$MAX_WHYNOT_PROOF_CLASS_DEVIATIONS$.get())).intValue(), deviations);

      if (founddeviations != Stella.NULL_INTEGER) {
        { Justification newdev = null;
          Justification repdev = null;
          KvCons iter000 = deviations.theKvList;

          for (;iter000 != null; iter000 = iter000.rest) {
            newdev = ((Justification)(iter000.key));
            repdev = ((Justification)(iter000.value));
            if (founddeviations == 0) {
              return (true);
            }
            if (renamed_Class.deviatingPattern == null) {
              renamed_Class.deviatingPattern = repdev;
            }
            { PatternVariable newvar = null;
              Stella_Object newvalue = null;
              DictionaryIterator iter001 = ((DictionaryIterator)(newdev.substitution.allocateIterator()));
              PatternVariable repvar = null;
              Stella_Object repvalue = null;
              DictionaryIterator iter002 = ((DictionaryIterator)(renamed_Class.deviatingPattern.substitution.allocateIterator()));

              while (iter001.nextP() &&
                  iter002.nextP()) {
                newvar = ((PatternVariable)(iter001.key));
                newvalue = iter001.value;
                repvar = ((PatternVariable)(iter002.key));
                repvalue = iter002.value;
                if (!Stella_Object.eqlP(newvalue, repvalue)) {
                  repvar = repvar;
                  if (renamed_Class.deviatingVariable == null) {
                    renamed_Class.deviatingVariable = newvar;
                    renamed_Class.deviatingInstances.insert(repvalue);
                  }
                  else if (!(newvar == renamed_Class.deviatingVariable)) {
                    return (false);
                  }
                  else if (renamed_Class.deviatingInstances.memberP(newvalue)) {
                    return (true);
                  }
                  renamed_Class.deviatingInstances.insert(newvalue);
                }
              }
            }
            renamed_Class.theConsList = Cons.cons(proof, renamed_Class.theConsList);
            return (true);
          }
        }
      }
      return (false);
    }
  }

  public static Stella_Object accessWhynotProofClassSlotValue(WhynotProofClass self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_REPRESENTATIVE) {
      if (setvalueP) {
        self.representative = ((Justification)(value));
      }
      else {
        value = self.representative;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_DEVIATING_PATTERN) {
      if (setvalueP) {
        self.deviatingPattern = ((Justification)(value));
      }
      else {
        value = self.deviatingPattern;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_DEVIATING_VARIABLE) {
      if (setvalueP) {
        self.deviatingVariable = ((PatternVariable)(value));
      }
      else {
        value = self.deviatingVariable;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_DEVIATING_INSTANCES) {
      if (setvalueP) {
        self.deviatingInstances = ((List)(value));
      }
      else {
        value = self.deviatingInstances;
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
    { WhynotProofClass self = this;

      return (Logic.SGT_LOGIC_WHYNOT_PROOF_CLASS);
    }
  }

}

