//  -*- Mode: Java -*-
//
// SubsumptionInferenceLevel.java

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

/** Specifies lookup augmented with cached
 * subsumption links and equality reasoning.
 * @author Stella Java Translator
 */
public class SubsumptionInferenceLevel extends BacktrackingInferenceLevel {
  public static SubsumptionInferenceLevel newSubsumptionInferenceLevel() {
    { SubsumptionInferenceLevel self = null;

      self = new SubsumptionInferenceLevel();
      self.keyword = null;
      return (self);
    }
  }

  public Cons levellizedAllSlotValueTypes(LogicObject self, Surrogate relation) {
    { SubsumptionInferenceLevel level = this;

      { Cons valuetypes = Logic.SHALLOW_INFERENCE.levellizedAllSlotValueTypes(self, relation);

        { NamedDescription superrelation = null;
          Cons iter000 = NamedDescription.allSuperrelations(Logic.getDescription(relation), false);

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            superrelation = ((NamedDescription)(iter000.value));
            { Stella_Object supertype = null;
              Cons iter001 = Logic.allRelationValues(Logic.SGT_PL_KERNEL_KB_RANGE_TYPE, Cons.consList(Cons.cons(superrelation, Cons.cons(self, Stella.NIL))));

              for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                supertype = iter001.value;
                if (!valuetypes.memberP(supertype)) {
                  valuetypes = Cons.cons(supertype, valuetypes);
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
    { SubsumptionInferenceLevel level = this;

      { int maxcardinality = Logic.SHALLOW_INFERENCE.levellizedGetSlotMaximumCardinality(self, relation);

        { NamedDescription superdescription = null;
          Cons iter000 = NamedDescription.allSuperrelations(Logic.getDescription(relation), false);

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            superdescription = ((NamedDescription)(iter000.value));
            { Stella_Object supermaxcardinality = Logic.allRelationValues(Logic.SGT_PL_KERNEL_KB_RANGE_MAX_CARDINALITY, Cons.consList(Cons.cons(superdescription, Cons.cons(self, Stella.NIL)))).value;

              if (supermaxcardinality != null) {
                if (maxcardinality != Stella.NULL_INTEGER) {
                  maxcardinality = Stella.integer_min(maxcardinality, ((IntegerWrapper)(supermaxcardinality)).wrapperValue);
                }
                else {
                  maxcardinality = ((IntegerWrapper)(supermaxcardinality)).wrapperValue;
                }
              }
            }
          }
        }
        return (maxcardinality);
      }
    }
  }

  public int levellizedGetSlotMinimumCardinality(LogicObject self, Surrogate relation) {
    { SubsumptionInferenceLevel level = this;

      { int mincardinality = Logic.SHALLOW_INFERENCE.levellizedGetSlotMinimumCardinality(self, relation);

        { NamedDescription subdescription = null;
          Cons iter000 = NamedDescription.allSubrelations(Logic.getDescription(relation), false);

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            subdescription = ((NamedDescription)(iter000.value));
            { Stella_Object submincardinality = Logic.allRelationValues(Logic.SGT_PL_KERNEL_KB_RANGE_MIN_CARDINALITY, Cons.consList(Cons.cons(subdescription, Cons.cons(self, Stella.NIL)))).value;

              if (submincardinality != null) {
                mincardinality = Stella.integer_max(mincardinality, ((IntegerWrapper)(submincardinality)).wrapperValue);
              }
            }
          }
        }
        return (mincardinality);
      }
    }
  }

  public boolean levellizedTestRelationOnArgumentsP(Surrogate relation, Cons arguments) {
    { SubsumptionInferenceLevel level = this;

      { boolean foundP000 = false;

        { ConsIterator p = Logic.allPropositionsMatchingArguments(arguments, relation, level == Logic.SUBSUMPTION_INFERENCE).allocateIterator();

          loop000 : while (p.nextP()) {
            foundP000 = true;
            break loop000;
          }
        }
        { boolean value000 = foundP000;

          return (value000);
        }
      }
    }
  }

  public Cons levellizedAllRelationValues(Surrogate relation, Cons nminusonearguments) {
    { SubsumptionInferenceLevel level = this;

      { Cons values = Stella.NIL;

        { Proposition p = null;
          Cons iter000 = Logic.allPropositionsMatchingArguments(nminusonearguments, relation, level == Logic.SUBSUMPTION_INFERENCE);

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            p = ((Proposition)(iter000.value));
            { Stella_Object value000 = Logic.valueOf((p.arguments.theArray)[(p.arguments.length() - 1)]);

              values = (values.memberP(value000) ? values : Cons.cons(value000, values));
            }
          }
        }
        return (values);
      }
    }
  }

  public Cons levellizedAllClassInstances(Surrogate type) {
    { SubsumptionInferenceLevel level = this;

      { Cons members = Stella.NIL;

        { Stella_Object m = null;
          Cons iter000 = Logic.assertedCollectionMembers(Logic.getDescription(type), false).theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            m = iter000.value;
            members = Cons.cons(m, members);
          }
        }
        return (members);
      }
    }
  }

  public boolean levellizedTestTypeOnInstanceP(Stella_Object self, Surrogate type) {
    { SubsumptionInferenceLevel level = this;

      { boolean foundP000 = false;

        { Proposition p = null;
          Iterator iter000 = Logic.allTrueDependentPropositions(self, type, true);

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
    { SubsumptionInferenceLevel self = this;

      return (Logic.SGT_LOGIC_SUBSUMPTION_INFERENCE_LEVEL);
    }
  }

}

