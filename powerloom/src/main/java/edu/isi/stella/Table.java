//  -*- Mode: Java -*-
//
// Table.java

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
| The Original Code is the STELLA Programming Language.                      |
|                                                                            |
| The Initial Developer of the Original Code is                              |
| UNIVERSITY OF SOUTHERN CALIFORNIA, INFORMATION SCIENCES INSTITUTE          |
| 4676 Admiralty Way, Marina Del Rey, California 90292, U.S.A.               |
|                                                                            |
| Portions created by the Initial Developer are Copyright (C) 1996-2017      |
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
+---------------------------- END LICENSE BLOCK -----------------------------+
*/

package edu.isi.stella;

import edu.isi.stella.javalib.*;

public class Table extends Slot {
    public List tupleDomains;

  public static Table newTable() {
    { Table self = null;

      self = new Table();
      self.dynamicSlots = KeyValueList.newKeyValueList();
      self.abstractP = false;
      self.slotDirectEquivalent = null;
      self.slotMarkedP = false;
      self.slotExternalP = false;
      self.slotRenamedP = false;
      self.slotPublicP = true;
      self.slotSlotref = null;
      self.slotBaseType = null;
      self.slotOwner = null;
      self.slotName = null;
      self.tupleDomains = null;
      return (self);
    }
  }

  public int arity() {
    { Table self = this;

      if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_VARIABLE_ARITY_TABLEp, Stella.FALSE_WRAPPER))).wrapperValue) {
        return (Stella.NULL_INTEGER);
      }
      else {
        return (self.tupleDomains.length());
      }
    }
  }

  public int methodArgumentCount() {
    { Table self = this;

      return (self.tupleDomains.length() - 1);
    }
  }

  public boolean conformingSignaturesP(Slot superslot) {
    { Table self = this;

      if (StandardObject.conformingTypeSpecP(self.slotBaseType, superslot.type()) &&
          (StandardObject.conformingTypeSpecP(((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null))), ((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(superslot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null)))) &&
           (self.methodArgumentCount() == superslot.methodArgumentCount()))) {
        if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(superslot), Stella.SGT_STELLA_TABLE)) {
          { Table superslot000 = ((Table)(superslot));

            { boolean alwaysP000 = true;

              { StandardObject ts1 = null;
                Cons iter000 = self.tupleDomains.rest();
                StandardObject ts2 = null;
                Cons iter001 = superslot000.tupleDomains.rest();

                loop000 : for (;(!(iter000 == Stella.NIL)) &&
                          (!(iter001 == Stella.NIL)); iter000 = iter000.rest, iter001 = iter001.rest) {
                  ts1 = ((StandardObject)(iter000.value));
                  ts2 = ((StandardObject)(iter001.value));
                  if (!StandardObject.conformingTypeSpecP(ts2, ts1)) {
                    alwaysP000 = false;
                    break loop000;
                  }
                }
              }
              { boolean value000 = alwaysP000;

                return (value000);
              }
            }
          }
        }
        else {
        }
      }
      return (false);
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { Table self = this;

      stream.print("|T|" + self.slotName.symbolName);
    }
  }

  public static Stella_Object accessTableSlotValue(Table self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_TUPLE_DOMAINS) {
      if (setvalueP) {
        self.tupleDomains = ((List)(value));
      }
      else {
        value = self.tupleDomains;
      }
    }
    else {
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
    { Table self = this;

      return (Stella.SGT_STELLA_TABLE);
    }
  }

}

