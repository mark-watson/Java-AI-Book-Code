//  -*- Mode: Java -*-
//
// Relation.java

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

public abstract class Relation extends MappableObject {
    public boolean abstractP;

  /** Return <code>true</code> if <code>self</code> is not public.
   * @return boolean
   */
  public boolean privateP() {
    { Relation self = this;

      return (!self.publicP());
    }
  }

  /** Return <code>true</code> if <code>self</code> is not a defined relation.
   * @return boolean
   */
  public boolean primitiveP() {
    { Relation self = this;

      return (true);
    }
  }

  public static Stella_Object accessRelationSlotValue(Relation self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_ABSTRACTp) {
      if (setvalueP) {
        self.abstractP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.abstractP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_PROPERTIES) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_PROPERTIES, ((List)(value)), null);
      }
      else {
        value = self.properties();
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

  public List properties() {
    { Relation self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_PROPERTIES, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public Iterator slots() {
    { Relation self = this;

      return (null);
    }
  }

  public List allSupers() {
    { Relation self = this;

      return (null);
    }
  }

  public List directSupers() {
    { Relation self = this;

      return (null);
    }
  }

  public boolean publicP() {
    { Relation self = this;

      return (false);
    }
  }

  public int arity() {
    { Relation self = this;

      return (Stella.NULL_INTEGER);
    }
  }

  public Module homeModule() {
    { Relation self = this;

      return (null);
    }
  }

  public String name() {
    { Relation self = this;

      return (null);
    }
  }

}

