//  -*- Mode: Java -*-
//
// DescriptionExtensionIterator.java

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

/** Iterates over the extension of a description and
 * its subdescriptions, returning those propositions that are currently true.
 * @author Stella Java Translator
 */
public class DescriptionExtensionIterator extends Iterator {
    public NamedDescription rootDescription;
    public Cons subcollections;
    public Iterator extensionIterator;
    public Proposition referenceProposition;
    public List alreadyGeneratedList;
    public HashTable alreadyGeneratedTable;
    public boolean removingDuplicatesP;
    public TruthValue truthValue;

  public static DescriptionExtensionIterator newDescriptionExtensionIterator() {
    { DescriptionExtensionIterator self = null;

      self = new DescriptionExtensionIterator();
      self.firstIterationP = true;
      self.value = null;
      self.truthValue = null;
      self.removingDuplicatesP = false;
      self.alreadyGeneratedTable = null;
      self.alreadyGeneratedList = List.newList();
      self.referenceProposition = null;
      self.extensionIterator = null;
      self.subcollections = null;
      self.rootDescription = null;
      return (self);
    }
  }

  public boolean nextP() {
    { DescriptionExtensionIterator self = this;

      { boolean withinqueryP = ((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null;
        PatternRecord patternrecord = (withinqueryP ? ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord : ((PatternRecord)(null)));
        int ubstackoffset = (withinqueryP ? (patternrecord.topUnbindingStackOffset + 1) : ((int)(Stella.NULL_INTEGER)));

        loop000 : for (;;) {
          loop001 : for (;;) {
            if (!self.extensionIterator.nextP()) {
              break loop001;
            }
            { Proposition value = ((Proposition)(self.extensionIterator.value));

              if (!(((!value.deletedP()) &&
                  ((((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue() ? Proposition.falseP(value) : (Proposition.trueP(value) ||
                  Proposition.functionWithDefinedValueP(value))))) &&
                  ((self.referenceProposition == null) ||
                   Proposition.argumentsMatchArgumentsP(value, self.referenceProposition)))) {
                continue loop001;
              }
              self.value = value;
              self.truthValue = Proposition.propositionTruthValue(value);
              if ((self.subcollections != null) &&
                  (!(self.subcollections == Stella.NIL))) {
                self.truthValue = TruthValue.conjoinTruthValues(self.truthValue, ((TruthValue)(((Cons)(self.subcollections.value)).rest.value)));
              }
              if (!self.removingDuplicatesP) {
                return (true);
              }
              { Stella_Object instance = (value.arguments.theArray)[0];

                if ((self.alreadyGeneratedTable == null) &&
                    (self.alreadyGeneratedList.length() >= Logic.$DUPLICATEINSTANCESCACHECROSSOVERPOINT$)) {
                  { HashTable hashtable = HashTable.newHashTable();

                    { Stella_Object m = null;
                      Cons iter000 = self.alreadyGeneratedList.theConsList;

                      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                        m = iter000.value;
                        hashtable.insertAt(m, m);
                      }
                    }
                    self.alreadyGeneratedTable = hashtable;
                  }
                }
                if (self.alreadyGeneratedTable != null) {
                  if (!(self.alreadyGeneratedTable.lookup(instance) != null)) {
                    self.alreadyGeneratedTable.insertAt(instance, instance);
                    return (true);
                  }
                }
                else {
                  if (!self.alreadyGeneratedList.memberP(instance)) {
                    self.alreadyGeneratedList.push(instance);
                    return (true);
                  }
                }
                if (withinqueryP) {
                  PatternRecord.unbindVariablesBeginningAt(patternrecord, ubstackoffset);
                }
              }
            }
          }
          { Cons subcollections = self.subcollections;
            NamedDescription subcollection = null;

            if (subcollections == null) {
              subcollections = LogicObject.allSupportedNamedSubcollections(self.rootDescription);
            }
            else {
              subcollections = subcollections.rest;
            }
            loop003 : while (!(subcollections == Stella.NIL)) {
              subcollection = ((NamedDescription)(((Cons)(subcollections.value)).value));
              if (!NamedDescription.getDescriptionExtension(subcollection, true).emptyP()) {
                break loop003;
              }
              else {
                subcollections = subcollections.rest;
              }
            }
            if (subcollection == null) {
              break loop000;
            }
            self.extensionIterator = NamedDescription.allExtensionMembers(subcollection);
            self.subcollections = subcollections;
          }
        }
        return (false);
      }
    }
  }

  public static Stella_Object accessDescriptionExtensionIteratorSlotValue(DescriptionExtensionIterator self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_ROOT_DESCRIPTION) {
      if (setvalueP) {
        self.rootDescription = ((NamedDescription)(value));
      }
      else {
        value = self.rootDescription;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_SUBCOLLECTIONS) {
      if (setvalueP) {
        self.subcollections = ((Cons)(value));
      }
      else {
        value = self.subcollections;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_EXTENSION_ITERATOR) {
      if (setvalueP) {
        self.extensionIterator = ((Iterator)(value));
      }
      else {
        value = self.extensionIterator;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_REFERENCE_PROPOSITION) {
      if (setvalueP) {
        self.referenceProposition = ((Proposition)(value));
      }
      else {
        value = self.referenceProposition;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_ALREADY_GENERATED_LIST) {
      if (setvalueP) {
        self.alreadyGeneratedList = ((List)(value));
      }
      else {
        value = self.alreadyGeneratedList;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_ALREADY_GENERATED_TABLE) {
      if (setvalueP) {
        self.alreadyGeneratedTable = ((HashTable)(value));
      }
      else {
        value = self.alreadyGeneratedTable;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_REMOVING_DUPLICATESp) {
      if (setvalueP) {
        self.removingDuplicatesP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.removingDuplicatesP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_TRUTH_VALUE) {
      if (setvalueP) {
        self.truthValue = ((TruthValue)(value));
      }
      else {
        value = self.truthValue;
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
    { DescriptionExtensionIterator self = this;

      return (Logic.SGT_LOGIC_DESCRIPTION_EXTENSION_ITERATOR);
    }
  }

}

