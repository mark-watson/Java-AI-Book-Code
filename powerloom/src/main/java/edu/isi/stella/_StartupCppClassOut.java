//  -*- Mode: Java -*-
//
// _StartupCppClassOut.java

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

public class _StartupCppClassOut {
  public static void startupCppClassOut() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Stella.SYM_STELLA_GC = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("GC", null, 0)));
          Stella.SYM_STELLA_CPP_CLASS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_CLASS", null, 0)));
          Stella.SYM_STELLA_CPP_DECLARATIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_DECLARATIONS", null, 0)));
          Stella.KWD_PUBLIC = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PUBLIC", null, 2)));
          Stella.SYM_STELLA_CPP_SIGNATURES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_SIGNATURES", null, 0)));
          Stella.SYM_STELLA_CPP_DEFINITIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_DEFINITIONS", null, 0)));
          Stella.SYM_STELLA_STARTUP_CPP_CLASS_OUT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-CPP-CLASS-OUT", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("CPP-YIELD-INITIAL-NULL-VALUE", "(DEFUN (CPP-YIELD-INITIAL-NULL-VALUE CONS) ())", Native.find_java_method("edu.isi.stella.Stella", "cppYieldInitialNullValue", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("CPP-YIELD-MEMBER-VAR-TREE", "(DEFUN (CPP-YIELD-MEMBER-VAR-TREE CONS) ((SLOT STORAGE-SLOT) (CLASS CLASS)))", Native.find_java_method("edu.isi.stella.StorageSlot", "cppYieldMemberVarTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("CPP-YIELD-PARAMETERIZED-MEMBER-VAR-TREE", "(DEFUN (CPP-YIELD-PARAMETERIZED-MEMBER-VAR-TREE CONS) ((SLOT STORAGE-SLOT) (CLASS CLASS)))", Native.find_java_method("edu.isi.stella.StorageSlot", "cppYieldParameterizedMemberVarTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("CPP-YIELD-STATIC-MEMBER-ALLOCATION-TREE", "(DEFUN (CPP-YIELD-STATIC-MEMBER-ALLOCATION-TREE CONS) ((SLOT STORAGE-SLOT) (CLASS CLASS)))", Native.find_java_method("edu.isi.stella.StorageSlot", "cppYieldStaticMemberAllocationTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("CPP-YIELD-MEMBER-FUNC-SIGNATURE-TREE", "(DEFUN (CPP-YIELD-MEMBER-FUNC-SIGNATURE-TREE CONS) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "cppYieldMemberFuncSignatureTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("CPP-YIELD-CONSTRUCTOR-SIGNATURE-TREE", "(DEFUN (CPP-YIELD-CONSTRUCTOR-SIGNATURE-TREE CONS) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "cppYieldConstructorSignatureTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("CPP-YIELD-EXCEPTION-CONSTRUCTOR-DEFINITION", "(DEFUN (CPP-YIELD-EXCEPTION-CONSTRUCTOR-DEFINITION CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "cppYieldExceptionConstructorDefinition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("SLOT-HAS-CLASS-PARAMETER-TYPE?", "(DEFUN (SLOT-HAS-CLASS-PARAMETER-TYPE? BOOLEAN) ((SLOT STORAGE-SLOT) (CLASS CLASS)))", Native.find_java_method("edu.isi.stella.StorageSlot", "slotHasClassParameterTypeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("GET-SLOT-CLASS-PARAMETER-NAME", "(DEFUN (GET-SLOT-CLASS-PARAMETER-NAME SYMBOL) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "getSlotClassParameterName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
          Stella.defineFunctionObject("CPP-NATIVE-METHOD?", "(DEFUN (CPP-NATIVE-METHOD? BOOLEAN) ((METHODSLOT METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "cppNativeMethodP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("CPP-GET-PARAMETERIZED-MEMBER-VARIABLE-DEFINITIONS", "(DEFUN (CPP-GET-PARAMETERIZED-MEMBER-VARIABLE-DEFINITIONS CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "cppGetParameterizedMemberVariableDefinitions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("CPP-GET-MEMBER-VARIABLE-DEFINITIONS", "(DEFUN (CPP-GET-MEMBER-VARIABLE-DEFINITIONS CONS CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "cppGetMemberVariableDefinitions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("[Ljava.lang.Object;")}), null);
          Stella.defineFunctionObject("CPP-GET-STATIC-VARIABLE-DEFINITIONS", "(DEFUN (CPP-GET-STATIC-VARIABLE-DEFINITIONS CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "cppGetStaticVariableDefinitions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("CPP-GET-CONSTRUCTOR-DEFINITIONS", "(DEFUN (CPP-GET-CONSTRUCTOR-DEFINITIONS CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "cppGetConstructorDefinitions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("CPP-GET-METHOD-DEFINITIONS", "(DEFUN (CPP-GET-METHOD-DEFINITIONS CONS CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "cppGetMethodDefinitions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("[Ljava.lang.Object;")}), null);
          Stella.defineFunctionObject("MARK-RENAMING-SLOTS", "(DEFUN (MARK-RENAMING-SLOTS VOID) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "markRenamingSlots", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("CPP-CLASS-HAS-ONLY-NATIVE-PARENTS?", "(DEFUN (CPP-CLASS-HAS-ONLY-NATIVE-PARENTS? BOOLEAN) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "cppClassHasOnlyNativeParentsP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-DEFINE-NATIVE-CLASS-UNIT", "(DEFUN (CPP-TRANSLATE-DEFINE-NATIVE-CLASS-UNIT CONS) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "cppTranslateDefineNativeClassUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
          Stella.defineFunctionObject("STARTUP-CPP-CLASS-OUT", "(DEFUN STARTUP-CPP-CLASS-OUT () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupCppClassOut", "startupCppClassOut", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_CPP_CLASS_OUT);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupCppClassOut"), Stella.NULL_STRING_WRAPPER);
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
