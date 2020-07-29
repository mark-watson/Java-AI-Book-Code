//  -*- Mode: Java -*-
//
// MappableObject.java

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

/** The class MAPPABLE-OBJECT enables the definition of projections
 * from a Stella class, slot, global variable, etc. onto a corresponding native
 * entity.
 * @author Stella Java Translator
 */
public abstract class MappableObject extends StandardObject {
    public KeyValueList dynamicSlots;

  public static void demonPropertyHandler(MappableObject demon, StorageSlot slot, Stella_Object property) {
    Stella_Object.defaultOptionHandler(demon, slot, property);
    Stella.$REGISTERED_PROPERTY_DEMONS$.insertAt(StringWrapper.wrapString(Stella_Object.coerceToString(property)), demon);
  }

  public boolean deletedPSetter(boolean value) {
    { MappableObject self = this;

      KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_DELETED_OBJECTp, (value ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), null);
      return (value);
    }
  }

  public boolean deletedP() {
    { MappableObject self = this;

      { BooleanWrapper deletedP = ((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_DELETED_OBJECTp, null)));

        if (deletedP != null) {
          return (BooleanWrapper.coerceWrappedBooleanToBoolean(deletedP));
        }
        else {
          return (false);
        }
      }
    }
  }

  public static Stella_Object accessMappableObjectSlotValue(MappableObject self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_PROJECTS_ONTO) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_PROJECTS_ONTO, ((List)(value)), null);
      }
      else {
        value = self.projectsOnto();
      }
    }
    else if (slotname == Stella.SYM_STELLA_PROJECTED_FROM) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_PROJECTED_FROM, ((List)(value)), null);
      }
      else {
        value = self.projectedFrom();
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

  public BooleanWrapper badP() {
    { MappableObject self = this;

      { BooleanWrapper answer = ((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_BADp, null)));

        if (answer == null) {
          return (Stella.FALSE_WRAPPER);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public List projectedFrom() {
    { MappableObject self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_PROJECTED_FROM, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public List projectsOnto() {
    { MappableObject self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_PROJECTS_ONTO, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

}

