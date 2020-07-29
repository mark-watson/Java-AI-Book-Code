//  -*- Mode: Java -*-
//
// AtomicGoalCacheIterator.java

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

public class AtomicGoalCacheIterator extends Iterator {
    public ControlFrame goal;
    public AtomicGoalCache cacheList;

  public static AtomicGoalCacheIterator newAtomicGoalCacheIterator() {
    { AtomicGoalCacheIterator self = null;

      self = new AtomicGoalCacheIterator();
      self.firstIterationP = true;
      self.value = null;
      self.cacheList = null;
      self.goal = null;
      return (self);
    }
  }

  public boolean nextP() {
    { AtomicGoalCacheIterator self = this;

      { ControlFrame goal = self.goal;
        AtomicGoalCache cachelist = self.cacheList;

        if ((cachelist != null) &&
            (!(goal.proposition.operator == cachelist.proposition.operator))) {
          self.cacheList = null;
          return (false);
        }
        while ((cachelist != null) &&
            ((!AtomicGoalCache.cacheMatchesGoalP(cachelist, goal, true, Logic.KWD_CACHE_INSTANTIATES_GOAL)) ||
             (((!(!((Boolean)(Logic.$DONTUSEDEFAULTKNOWLEDGEp$.get())).booleanValue())) &&
            ((goal.truthValue == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
             (goal.truthValue == Logic.DEFAULT_FALSE_TRUTH_VALUE))) ||
              (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue() &&
               (cachelist.justification == null))))) {
          cachelist = cachelist.next;
        }
        if (cachelist != null) {
          self.value = cachelist;
          self.cacheList = cachelist.next;
          return (true);
        }
        else {
          return (false);
        }
      }
    }
  }

  public static Stella_Object accessAtomicGoalCacheIteratorSlotValue(AtomicGoalCacheIterator self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_GOAL) {
      if (setvalueP) {
        self.goal = ((ControlFrame)(value));
      }
      else {
        value = self.goal;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_CACHE_LIST) {
      if (setvalueP) {
        self.cacheList = ((AtomicGoalCache)(value));
      }
      else {
        value = self.cacheList;
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
    { AtomicGoalCacheIterator self = this;

      return (Logic.SGT_LOGIC_ATOMIC_GOAL_CACHE_ITERATOR);
    }
  }

}

