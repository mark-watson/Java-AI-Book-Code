//  -*- Mode: Java -*-
//
// _StartupMoreDemons.java

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

public class _StartupMoreDemons {
  public static void startupMoreDemons() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Stella.SYM_STELLA_STARTUP_MORE_DEMONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-MORE-DEMONS", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("INVERSE-SLOT-DEMON", "(DEFUN INVERSE-SLOT-DEMON ((SELF STANDARD-OBJECT) (SLOT STORAGE-SLOT) (OLDVALUE STANDARD-OBJECT) (NEWVALUE STANDARD-OBJECT)))", Native.find_java_method("edu.isi.stella.StandardObject", "inverseSlotDemon", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("edu.isi.stella.StandardObject")}), null);
          Stella.defineFunctionObject("ATTACH-INVERSE-SLOT-DEMON", "(DEFUN ATTACH-INVERSE-SLOT-DEMON ((SLOT SLOT)))", Native.find_java_method("edu.isi.stella.Slot", "attachInverseSlotDemon", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), null);
          Stella.defineFunctionObject("CLASS-EXTENSION-CONSTRUCTOR-DEMON", "(DEFUN CLASS-EXTENSION-CONSTRUCTOR-DEMON ((SELF ACTIVE-OBJECT) (CLASS CLASS)))", Native.find_java_method("edu.isi.stella.ActiveObject", "classExtensionConstructorDemon", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.ActiveObject"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("CLASS-EXTENSION-DESTRUCTOR-DEMON", "(DEFUN CLASS-EXTENSION-DESTRUCTOR-DEMON ((SELF ACTIVE-OBJECT) (CLASS CLASS)))", Native.find_java_method("edu.isi.stella.ActiveObject", "classExtensionDestructorDemon", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.ActiveObject"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("STARTUP-MORE-DEMONS", "(DEFUN STARTUP-MORE-DEMONS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupMoreDemons", "startupMoreDemons", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_MORE_DEMONS);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupMoreDemons"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
          Stella.defineDemon("inverse-slot-demon", Cons.cons(Stella.KWD_CODE, Cons.cons(FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.StandardObject", "inverseSlotDemon", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("edu.isi.stella.StandardObject")})), Stella.NIL)));
          Stella.defineDemon("class-extension-constructor-demon", Cons.cons(Stella.KWD_DOCUMENTATION, Cons.cons(StringWrapper.wrapString("Demon that inserts the instance 'self' into the extension of\nthe class 'class'."), Cons.cons(Stella.KWD_CREATE, Cons.cons(Stella.KWD_ALL, Cons.cons(Stella.KWD_CODE, Cons.cons(FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.ActiveObject", "classExtensionConstructorDemon", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.ActiveObject"), Native.find_java_class("edu.isi.stella.Stella_Class")})), Stella.NIL)))))));
          Stella.defineDemon("class-extension-destructor-demon", Cons.cons(Stella.KWD_DOCUMENTATION, Cons.cons(StringWrapper.wrapString("Demon that removes the instance 'self' from the extension of\nthe class 'class'.  Removal removes the instance forever.  Deletion without\nremoval can be achieved in constant time by setting 'deleted?' on 'self'."), Cons.cons(Stella.KWD_DESTROY, Cons.cons(Stella.KWD_ALL, Cons.cons(Stella.KWD_CODE, Cons.cons(FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.ActiveObject", "classExtensionDestructorDemon", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.ActiveObject"), Native.find_java_class("edu.isi.stella.Stella_Class")})), Stella.NIL)))))));
          { Demon createdemon = Stella.lookupDemon("class-extension-constructor-demon");
            Demon destroydemon = Stella.lookupDemon("class-extension-destructor-demon");

            Demon.activateDemon(createdemon);
            Demon.activateDemon(destroydemon);
          }
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
