//  -*- Mode: Java -*-
//
// _StartupDynamicSlots.java

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

public class _StartupDynamicSlots {
  public static void startupDynamicSlots() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Stella.SYM_STELLA_DYNAMIC_SLOT_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DYNAMIC-SLOT-VALUE", null, 0)));
          Stella.SYM_STELLA_STARTUP_DYNAMIC_SLOTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-DYNAMIC-SLOTS", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("DYNAMIC-SLOT-VALUE", "(DEFUN (DYNAMIC-SLOT-VALUE OBJECT) ((DYNAMICSLOTS KEY-VALUE-LIST) (SLOTNAME SYMBOL) (NULLVALUE OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.KeyValueList", "dynamicSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.KeyValueList"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SET-DYNAMIC-SLOT-VALUE", "(DEFUN (SET-DYNAMIC-SLOT-VALUE OBJECT) ((DYNAMICSLOTS KEY-VALUE-LIST) (SLOTNAME SYMBOL) (VALUE OBJECT) (NULLWRAPPER WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.KeyValueList", "setDynamicSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.KeyValueList"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Wrapper")}), null);
          Stella.defineFunctionObject("STANDARD-DYNAMIC-SLOT-ACCESS?", "(DEFUN (STANDARD-DYNAMIC-SLOT-ACCESS? BOOLEAN) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "standardDynamicSlotAccessP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
          Stella.defineFunctionObject("YIELD-DOWN-CAST-TREE", "(DEFUN (YIELD-DOWN-CAST-TREE CONS) ((TREE CONS) (RETURNTYPE TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.Cons", "yieldDownCastTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.StandardObject")}), null);
          Stella.defineFunctionObject("YIELD-STANDARD-DYNAMIC-SLOT-VALUE-TREE", "(DEFUN (YIELD-STANDARD-DYNAMIC-SLOT-VALUE-TREE CONS) ((SLOT STORAGE-SLOT) (OBJECTREF OBJECT) (RETURNTYPE TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldStandardDynamicSlotValueTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.StandardObject")}), null);
          Stella.defineFunctionObject("YIELD-STANDARD-DYNAMIC-SLOT-VALUE-SETTER-TREE", "(DEFUN (YIELD-STANDARD-DYNAMIC-SLOT-VALUE-SETTER-TREE CONS) ((SLOT STORAGE-SLOT) (OBJECTREF OBJECT) (VALUEREF OBJECT) (RETURNTYPE TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldStandardDynamicSlotValueSetterTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.StandardObject")}), null);
          Stella.defineFunctionObject("STARTUP-DYNAMIC-SLOTS", "(DEFUN STARTUP-DYNAMIC-SLOTS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupDynamicSlots", "startupDynamicSlots", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_DYNAMIC_SLOTS);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupDynamicSlots"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
