//  -*- Mode: Java -*-
//
// _StartupJavaClassOut.java

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

public class _StartupJavaClassOut {
  public static void startupJavaClassOut() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Stella.SYM_STELLA_JAVA_EXCEPTION_CLASS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_EXCEPTION_CLASS", null, 0)));
          Stella.SYM_STELLA_JAVA_CLASS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_CLASS", null, 0)));
          Stella.SYM_STELLA_JAVA_DECLARATIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_DECLARATIONS", null, 0)));
          Stella.SYM_STELLA_STARTUP_JAVA_CLASS_OUT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-JAVA-CLASS-OUT", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("JAVA-YIELD-INSTANCE-VAR-TREE", "(DEFUN (JAVA-YIELD-INSTANCE-VAR-TREE CONS) ((SLOT STORAGE-SLOT) (CLASS CLASS)))", Native.find_java_method("edu.isi.stella.StorageSlot", "javaYieldInstanceVarTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("JAVA-GET-INSTANCE-VARIABLE-DEFINITIONS", "(DEFUN (JAVA-GET-INSTANCE-VARIABLE-DEFINITIONS CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "javaGetInstanceVariableDefinitions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("JAVA-GET-CONSTRUCTOR-AND-METHOD-DEFINITIONS", "(DEFUN (JAVA-GET-CONSTRUCTOR-AND-METHOD-DEFINITIONS CONS CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "javaGetConstructorAndMethodDefinitions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("[Ljava.lang.Object;")}), null);
          Stella.defineFunctionObject("JAVA-TRANSLATE-DEFINE-NATIVE-CLASS-UNIT", "(DEFUN (JAVA-TRANSLATE-DEFINE-NATIVE-CLASS-UNIT CONS) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "javaTranslateDefineNativeClassUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
          Stella.defineFunctionObject("JAVA-TRANSLATE-DEFINE-NATIVE-CLASS", "(DEFUN (JAVA-TRANSLATE-DEFINE-NATIVE-CLASS CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "javaTranslateDefineNativeClass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("STARTUP-JAVA-CLASS-OUT", "(DEFUN STARTUP-JAVA-CLASS-OUT () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupJavaClassOut", "startupJavaClassOut", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_JAVA_CLASS_OUT);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupJavaClassOut"), Stella.NULL_STRING_WRAPPER);
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
