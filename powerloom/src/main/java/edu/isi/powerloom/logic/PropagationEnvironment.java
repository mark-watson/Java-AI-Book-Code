//  -*- Mode: Java -*-
//
// PropagationEnvironment.java

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

public class PropagationEnvironment extends StandardObject {
    public List evaluationQueue;
    public KeyValueMap evaluationStates;
    public List forwardChainingQueue;
    public HashSet forwardChainingSet;
    public List deferredDefaultPropositions;
    public HashSet elaboratedObjects;

  public static PropagationEnvironment newPropagationEnvironment() {
    { PropagationEnvironment self = null;

      self = new PropagationEnvironment();
      self.elaboratedObjects = HashSet.newHashSet();
      self.deferredDefaultPropositions = List.list(Stella.NIL);
      self.forwardChainingSet = HashSet.newHashSet();
      self.forwardChainingQueue = List.list(Stella.NIL);
      self.evaluationStates = KeyValueMap.newKeyValueMap();
      self.evaluationQueue = List.list(Stella.NIL);
      return (self);
    }
  }

  public void executePropagationQueues() {
    { PropagationEnvironment self = this;

      { Object old$InhibitobjectfinalizationP$000 = Logic.$INHIBITOBJECTFINALIZATIONp$.get();

        try {
          Native.setBooleanSpecial(Logic.$INHIBITOBJECTFINALIZATIONp$, true);
          for (;;) {
            { List queue = self.evaluationQueue;

              if (queue.nonEmptyP()) {
                self.evaluationQueue = List.newList();
                { Proposition p = null;
                  Cons iter000 = queue.theConsList;

                  for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                    p = ((Proposition)(iter000.value));
                    Proposition.evaluateProposition(p);
                  }
                }
              }
            }
            { List queue = self.forwardChainingQueue;
              Description description = null;

              if (queue.nonEmptyP()) {
                self.forwardChainingQueue = List.newList();
                { Proposition proposition = null;
                  Cons iter001 = queue.theConsList;

                  for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                    proposition = ((Proposition)(iter001.value));
                    {
                    }
                    description = Logic.getDescription(((Surrogate)(proposition.operator)));
                    if ((description != null) &&
                        Proposition.falseP(proposition)) {
                      description = Description.getInferableComplementDescription(description);
                    }
                    if (description != null) {
                      Description.applyForwardRulesToVector(description, proposition.arguments, proposition);
                    }
                  }
                }
              }
            }
            if (self.evaluationQueue.emptyP() &&
                self.forwardChainingQueue.emptyP()) {
              return;
            }
          }

        } finally {
          Logic.$INHIBITOBJECTFINALIZATIONp$.set(old$InhibitobjectfinalizationP$000);
        }
      }
    }
  }

  public PropagationEnvironment copy() {
    { PropagationEnvironment self = this;

      { PropagationEnvironment copy = PropagationEnvironment.newPropagationEnvironment();

        copy.evaluationQueue = self.evaluationQueue.copy();
        { Proposition prop = null;
          Keyword state = null;
          DictionaryIterator iter000 = ((DictionaryIterator)(self.evaluationStates.allocateIterator()));

          while (iter000.nextP()) {
            prop = ((Proposition)(iter000.key));
            state = ((Keyword)(iter000.value));
            copy.evaluationStates.insertAt(prop, state);
          }
        }
        copy.forwardChainingQueue = self.forwardChainingQueue.copy();
        { Proposition prop = null;
          DictionaryIterator iter001 = ((DictionaryIterator)(self.forwardChainingSet.allocateIterator()));

          while (iter001.nextP()) {
            prop = ((Proposition)(iter001.value));
            copy.forwardChainingSet.insert(prop);
          }
        }
        copy.deferredDefaultPropositions = self.deferredDefaultPropositions.copy();
        { Stella_Object obj = null;
          DictionaryIterator iter002 = ((DictionaryIterator)(self.elaboratedObjects.allocateIterator()));

          while (iter002.nextP()) {
            obj = iter002.value;
            copy.elaboratedObjects.insert(obj);
          }
        }
        return (copy);
      }
    }
  }

  public void clearPropagationQueues() {
    { PropagationEnvironment self = this;

      self.evaluationQueue.clear();
      self.forwardChainingQueue.clear();
    }
  }

  public void deferDefaultProposition(Proposition proposition) {
    { PropagationEnvironment self = this;

      self.deferredDefaultPropositions.insert(proposition);
    }
  }

  public static void printPropagationEnvironmentStats(PropagationEnvironment self) {
    if (self == null) {
      self = Logic.getPropagationEnvironment(((Context)(Stella.$CONTEXT$.get())));
    }
    Stella.STANDARD_OUTPUT.nativeStream.println("Propagation environment stats:");
    Stella.STANDARD_OUTPUT.nativeStream.println("  " + self.evaluationQueue.length() + " propositions in evaluation-queue");
    Stella.STANDARD_OUTPUT.nativeStream.println("  " + self.forwardChainingSet.length() + " propositions in forward-chaining-queue");
    Stella.STANDARD_OUTPUT.nativeStream.println("  " + self.elaboratedObjects.length() + " objects elaborated");
  }

  public static Stella_Object accessPropagationEnvironmentSlotValue(PropagationEnvironment self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_EVALUATION_QUEUE) {
      if (setvalueP) {
        self.evaluationQueue = ((List)(value));
      }
      else {
        value = self.evaluationQueue;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_EVALUATION_STATES) {
      if (setvalueP) {
        self.evaluationStates = ((KeyValueMap)(value));
      }
      else {
        value = self.evaluationStates;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_FORWARD_CHAINING_QUEUE) {
      if (setvalueP) {
        self.forwardChainingQueue = ((List)(value));
      }
      else {
        value = self.forwardChainingQueue;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_FORWARD_CHAINING_SET) {
      if (setvalueP) {
        self.forwardChainingSet = ((HashSet)(value));
      }
      else {
        value = self.forwardChainingSet;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_DEFERRED_DEFAULT_PROPOSITIONS) {
      if (setvalueP) {
        self.deferredDefaultPropositions = ((List)(value));
      }
      else {
        value = self.deferredDefaultPropositions;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_ELABORATED_OBJECTS) {
      if (setvalueP) {
        self.elaboratedObjects = ((HashSet)(value));
      }
      else {
        value = self.elaboratedObjects;
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
    { PropagationEnvironment self = this;

      return (Logic.SGT_LOGIC_PROPAGATION_ENVIRONMENT);
    }
  }

}

