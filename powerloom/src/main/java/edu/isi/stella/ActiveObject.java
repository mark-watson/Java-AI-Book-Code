//  -*- Mode: Java -*-
//
// ActiveObject.java

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

/** Active objects call class and slot triggers in response
 * to instance creation/destruction and slot updates.  They include internal
 * storage slots needed for class extensions, dynamic storage, and home context.
 * @author Stella Java Translator
 */
public abstract class ActiveObject extends ContextSensitiveObject {
    public KeyValueList dynamicSlots;

  public static void classExtensionDestructorDemon(ActiveObject self, Stella_Class renamed_Class) {
    { ClassExtension extension = renamed_Class.extension();

      if (extension != null) {
        extension.remove(self);
      }
    }
  }

  public static void classExtensionConstructorDemon(ActiveObject self, Stella_Class renamed_Class) {
    { ClassExtension extension = renamed_Class.extension();

      if (extension != null) {
        extension.insert(self);
      }
    }
  }

  /** Remove all pointers between <code>self</code> and other objects,
   * and then deallocate the storage for self.
   */
  public void free() {
    { ActiveObject self = this;

      Stella_Object.unmake(self);
    }
  }

  public boolean deletedPSetter(boolean value) {
    { ActiveObject self = this;

      KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_DELETED_OBJECTp, (value ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), null);
      return (value);
    }
  }

  public boolean deletedP() {
    { ActiveObject self = this;

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

  public static Stella_Object accessActiveObjectSlotValue(ActiveObject self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (true) {
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
    { ActiveObject self = this;

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

}

