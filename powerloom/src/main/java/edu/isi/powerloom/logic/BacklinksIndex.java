//  -*- Mode: Java -*-
//
// BacklinksIndex.java

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

/** Contains several types of indices pointing at dependent propositions.
 * @author Stella Java Translator
 */
public class BacklinksIndex extends StandardObject {
    public SequenceIndex dependentPropositionsList;
    public SequenceIndex dependentIsaPropositionsList;
    public HashTable predicatePropositionsTable;

  public static BacklinksIndex newBacklinksIndex() {
    { BacklinksIndex self = null;

      self = new BacklinksIndex();
      self.predicatePropositionsTable = null;
      self.dependentIsaPropositionsList = null;
      self.dependentPropositionsList = null;
      return (self);
    }
  }

  public BacklinksIndex removeDeletedMembers() {
    { BacklinksIndex self = this;

      if (self.dependentPropositionsList != null) {
        self.dependentPropositionsList.removeDeletedMembers();
      }
      if (self.dependentIsaPropositionsList != null) {
        self.dependentIsaPropositionsList.removeDeletedMembers();
      }
      { HashTable table = self.predicatePropositionsTable;
        StellaHashTable hashtable = ((StellaHashTable)(((table != null) ? table.theStellaHashTable : ((StellaHashTable)(null)))));

        if (hashtable != null) {
          { Stella_Object key = null;
            SequenceIndex index = null;
            StellaHashTableIterator iter000 = ((StellaHashTableIterator)(hashtable.allocateIterator()));

            while (iter000.nextP()) {
              key = iter000.key;
              index = ((SequenceIndex)(iter000.value));
              key = key;
              index.removeDeletedMembers();
            }
          }
        }
        return (self);
      }
    }
  }

  public static void helpRemoveDependentProposition(BacklinksIndex index, Proposition proposition) {
    { SequenceIndex list = index.dependentPropositionsList;
      HashTable table = index.predicatePropositionsTable;

      if (list != null) {
        list.remove(proposition);
      }
      if (table != null) {
        if (proposition.kind == Logic.KWD_ISA) {
          list = index.dependentIsaPropositionsList;
          if (list != null) {
            list.remove(proposition);
          }
        }
        else {
          list = ((SequenceIndex)(table.lookup(((Surrogate)(proposition.operator)))));
          if (list != null) {
            list.remove(proposition);
          }
        }
      }
    }
  }

  public static void helpAddDependentProposition(BacklinksIndex index, Proposition proposition, Stella_Object argument) {
    { SequenceIndex alldependentpropositions = index.dependentPropositionsList;
      HashTable table = index.predicatePropositionsTable;

      if (alldependentpropositions.first() == proposition) {
        return;
      }
      if (table == null) {
        if (SequenceIndex.sequenceIndexDestimatedLength(alldependentpropositions) < Logic.$SPECIALIZED_BACKLINKS_CROSSOVER_POINT$) {
          alldependentpropositions.insert(proposition);
          return;
        }
      }
      BacklinksIndex.addDependentPropositionToSpecializedIndex(index, proposition, argument);
      alldependentpropositions.insert(proposition);
    }
  }

  public static void addDependentPropositionToSpecializedIndex(BacklinksIndex index, Proposition proposition, Stella_Object argument) {
    { HashTable table = index.predicatePropositionsTable;

      if (table == null) {
        table = HashTable.newHashTable();
        index.predicatePropositionsTable = table;
        { Proposition prop = null;
          Iterator iter000 = index.dependentPropositionsList.allocateIterator();

          while (iter000.nextP()) {
            prop = ((Proposition)(iter000.value));
            BacklinksIndex.addDependentPropositionToSpecializedIndex(index, prop, argument);
          }
        }
      }
      if (proposition.kind == Logic.KWD_ISA) {
        if (index.dependentIsaPropositionsList == null) {
          index.dependentIsaPropositionsList = Logic.createSequenceIndex(((Module)(Stella.$MODULE$.get())), Cons.cons(Logic.KWD_ISA, Cons.cons(((Stella.NIL == null) ? Stella.NIL : Stella.NIL), Cons.cons(argument, Stella.NIL))));
        }
        index.dependentIsaPropositionsList.insert(proposition);
      }
      else {
        { Surrogate surrogate = ((Surrogate)(proposition.operator));
          SequenceIndex bucket = null;

          bucket = ((SequenceIndex)(table.lookup(surrogate)));
          if (bucket == null) {
            bucket = Logic.createSequenceIndex(((Module)(Stella.$MODULE$.get())), Cons.cons(Logic.KWD_RELATION, Cons.cons(((Stella.NIL == null) ? Stella.NIL : Stella.NIL), Cons.cons(surrogate, Cons.cons(argument, Stella.NIL)))));
            table.insertAt(surrogate, bucket);
          }
          bucket.insert(proposition);
        }
      }
    }
  }

  public static Stella_Object accessBacklinksIndexSlotValue(BacklinksIndex self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_DEPENDENT_PROPOSITIONS_LIST) {
      if (setvalueP) {
        self.dependentPropositionsList = ((SequenceIndex)(value));
      }
      else {
        value = self.dependentPropositionsList;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_DEPENDENT_ISA_PROPOSITIONS_LIST) {
      if (setvalueP) {
        self.dependentIsaPropositionsList = ((SequenceIndex)(value));
      }
      else {
        value = self.dependentIsaPropositionsList;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_PREDICATE_PROPOSITIONS_TABLE) {
      if (setvalueP) {
        self.predicatePropositionsTable = ((HashTable)(value));
      }
      else {
        value = self.predicatePropositionsTable;
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
    { BacklinksIndex self = this;

      return (Logic.SGT_LOGIC_BACKLINKS_INDEX);
    }
  }

}

