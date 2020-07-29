//  -*- Mode: Java -*-
//
// ShallowInferenceLevel.java

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

/** Specifies lookup of assertions plus simple frame computations.
 * @author Stella Java Translator
 */
public class ShallowInferenceLevel extends SubsumptionInferenceLevel {
  public static ShallowInferenceLevel newShallowInferenceLevel() {
    { ShallowInferenceLevel self = null;

      self = new ShallowInferenceLevel();
      self.keyword = null;
      return (self);
    }
  }

  public Cons levellizedAllSlotValueTypes(LogicObject self, Surrogate relation) {
    { ShallowInferenceLevel level = this;

      { NamedDescription description = Logic.getDescription(relation);
        Cons valuetypes = Logic.allRelationValues(Logic.SGT_PL_KERNEL_KB_RANGE_TYPE, Cons.consList(Cons.cons(description, Cons.cons(self, Stella.NIL))));

        if (Logic.testClosedSlotP(relation) ||
            Logic.testFunctionSlotP(relation)) {
          { Cons fillers = LogicObject.allSlotValues(self, relation);
            Cons possibletypes = Stella.NIL;

            { Stella_Object f = null;
              Cons iter000 = fillers;

              for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                f = iter000.value;
                { NamedDescription d = null;
                  Cons iter001 = Logic.allAssertedTypes(f);

                  for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                    d = ((NamedDescription)(iter001.value));
                    if (!possibletypes.memberP(d)) {
                      possibletypes = Cons.cons(d, possibletypes);
                    }
                  }
                }
              }
            }
            { LogicObject d = null;
              Cons iter002 = possibletypes;

              for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                d = ((LogicObject)(iter002.value));
                { boolean testValue000 = false;

                  testValue000 = !valuetypes.memberP(d);
                  if (testValue000) {
                    { boolean alwaysP000 = true;

                      { Stella_Object f = null;
                        Cons iter003 = fillers;

                        loop003 : for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
                          f = iter003.value;
                          if (!Logic.testTypeOnInstanceP(f, d.surrogateValueInverse)) {
                            alwaysP000 = false;
                            break loop003;
                          }
                        }
                      }
                      testValue000 = alwaysP000;
                    }
                  }
                  if (testValue000) {
                    valuetypes = Cons.cons(d, valuetypes);
                  }
                }
              }
            }
          }
        }
        return (Logic.filterOutUnnamedDescriptions(valuetypes));
      }
    }
  }

  public int levellizedGetSlotMaximumCardinality(LogicObject self, Surrogate relation) {
    { ShallowInferenceLevel level = this;

      { NamedDescription description = Logic.getDescription(relation);
        Stella_Object maxcardinality = Logic.allRelationValues(Logic.SGT_PL_KERNEL_KB_RANGE_MAX_CARDINALITY, Cons.consList(Cons.cons(description, Cons.cons(self, Stella.NIL)))).value;
        int fillercount = Stella.NULL_INTEGER;

        if (Logic.testClosedSlotP(relation)) {
          fillercount = LogicObject.allSlotValues(self, relation).length();
        }
        else if (Logic.testFunctionSlotP(relation)) {
          fillercount = 1;
        }
        if (maxcardinality == null) {
          return (fillercount);
        }
        else if (fillercount == Stella.NULL_INTEGER) {
          return (((IntegerWrapper)(maxcardinality)).wrapperValue);
        }
        else {
          return (Stella.integer_min(fillercount, ((IntegerWrapper)(maxcardinality)).wrapperValue));
        }
      }
    }
  }

  public int levellizedGetSlotMinimumCardinality(LogicObject self, Surrogate relation) {
    { ShallowInferenceLevel level = this;

      { NamedDescription description = Logic.getDescription(relation);
        Stella_Object mincardinality = Logic.allRelationValues(Logic.SGT_PL_KERNEL_KB_RANGE_MIN_CARDINALITY, Cons.consList(Cons.cons(description, Cons.cons(self, Stella.NIL)))).value;
        int fillercount = LogicObject.allSlotValues(self, relation).length();

        if (mincardinality == null) {
          mincardinality = IntegerWrapper.wrapInteger(0);
        }
        return (Stella.integer_max(fillercount, ((IntegerWrapper)(mincardinality)).wrapperValue));
      }
    }
  }

  public boolean levellizedTestTypeOnInstanceP(Stella_Object self, Surrogate type) {
    { ShallowInferenceLevel level = this;

      { boolean foundP000 = false;

        { Proposition p = null;
          Iterator iter000 = Logic.allTrueDependentPropositions(self, type, false);

          loop000 : while (iter000.nextP()) {
            p = ((Proposition)(iter000.value));
            if (p.kind == Logic.KWD_ISA) {
              foundP000 = true;
              break loop000;
            }
          }
        }
        { boolean value000 = foundP000;

          return (value000);
        }
      }
    }
  }

  public Surrogate primaryType() {
    { ShallowInferenceLevel self = this;

      return (Logic.SGT_LOGIC_SHALLOW_INFERENCE_LEVEL);
    }
  }

}

