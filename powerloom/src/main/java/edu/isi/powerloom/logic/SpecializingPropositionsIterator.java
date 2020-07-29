//  -*- Mode: Java -*-
//
// SpecializingPropositionsIterator.java

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

/** Iterator class that can generate sets of true propositions
 * matching its <code>selectionPattern</code> or a more specific pattern that substitutes
 * one of the relations in <code>specializingRelations</code>.
 * @author Stella Java Translator
 */
public class SpecializingPropositionsIterator extends TruePropositionsIterator {
    public Cons specializingRelations;

  public static SpecializingPropositionsIterator newSpecializingPropositionsIterator() {
    { SpecializingPropositionsIterator self = null;

      self = new SpecializingPropositionsIterator();
      self.firstIterationP = true;
      self.value = null;
      self.equivalentsStack = null;
      self.propositionCursor = null;
      self.selectionPattern = null;
      self.truthValue = null;
      self.specializingRelations = null;
      return (self);
    }
  }

  public boolean nextP() {
    { SpecializingPropositionsIterator self = this;

      return (SpecializingPropositionsIterator.specializingPropositionsIteratorDnextP(self));
    }
  }

  public static boolean specializingPropositionsIteratorDnextP(SpecializingPropositionsIterator self) {
    { Cons specializingrelations = self.specializingRelations;

      for (;;) {
        if (TruePropositionsIterator.truePropositionsIteratorDnextP(self)) {
          if ((specializingrelations != null) &&
              (!(specializingrelations == Stella.NIL))) {
            self.truthValue = TruthValue.conjoinTruthValues(self.truthValue, ((TruthValue)(((Cons)(specializingrelations.value)).rest.value)));
          }
          self.specializingRelations = specializingrelations;
          return (true);
        }
        if (specializingrelations == null) {
          if (((Keyword)(self.selectionPattern.value)) == Logic.KWD_RELATION) {
            { NamedDescription relationdescription = Logic.surrogateToDescription(((Surrogate)(self.selectionPattern.rest.rest.value)));

              if (relationdescription != null) {
                specializingrelations = LogicObject.allSupportedNamedSubcollections(relationdescription);
              }
              else {
                specializingrelations = Stella.NIL;
              }
            }
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("Illegal selection pattern in `" + self + "'");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }
        else {
          specializingrelations = specializingrelations.rest;
        }
        if (specializingrelations == Stella.NIL) {
          self.value = null;
          return (false);
        }
        self.selectionPattern = Cons.copyConsList(self.selectionPattern);
        self.selectionPattern.rest.rest.firstSetter(((NamedDescription)(((Cons)(specializingrelations.value)).value)).surrogateValueInverse);
        self.propositionCursor = Logic.selectPropositions(self.selectionPattern).allocateIterator();
        self.equivalentsStack = null;
      }
    }
  }

  public static Stella_Object accessSpecializingPropositionsIteratorSlotValue(SpecializingPropositionsIterator self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_SPECIALIZING_RELATIONS) {
      if (setvalueP) {
        self.specializingRelations = ((Cons)(value));
      }
      else {
        value = self.specializingRelations;
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
    { SpecializingPropositionsIterator self = this;

      return (Logic.SGT_LOGIC_SPECIALIZING_PROPOSITIONS_ITERATOR);
    }
  }

}

