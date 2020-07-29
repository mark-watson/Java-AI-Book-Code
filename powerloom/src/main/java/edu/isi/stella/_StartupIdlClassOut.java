//  -*- Mode: Java -*-
//
// _StartupIdlClassOut.java

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

public class _StartupIdlClassOut {
  public static void startupIdlClassOut() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Stella.SYM_STELLA_IDL_INTERFACE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IDL_INTERFACE", null, 0)));
          Stella.SYM_STELLA_sIDL_THEORYsinterface = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("/IDL-THEORY/interface", null, 0)));
          Stella.SYM_STELLA_sIDL_THEORYsstruct = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("/IDL-THEORY/struct", null, 0)));
          Stella.SYM_STELLA_sIDL_THEORYsenum = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("/IDL-THEORY/enum", null, 0)));
          Stella.SYM_STELLA_sIDL_THEORYstypedef = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("/IDL-THEORY/typedef", null, 0)));
          Stella.SYM_STELLA_IDL_STRUCT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IDL_STRUCT", null, 0)));
          Stella.SYM_STELLA_IDL_ENUM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IDL_ENUM", null, 0)));
          Stella.SYM_STELLA_IDL_DECLARATIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IDL_DECLARATIONS", null, 0)));
          Stella.SYM_STELLA_IDL_SIGNATURES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IDL_SIGNATURES", null, 0)));
          Stella.SYM_STELLA_STARTUP_IDL_CLASS_OUT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-IDL-CLASS-OUT", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("IDL-YIELD-INITIAL-NULL-VALUE", "(DEFUN (IDL-YIELD-INITIAL-NULL-VALUE CONS) ())", Native.find_java_method("edu.isi.stella.Stella", "idlYieldInitialNullValue", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("IDL-YIELD-ATTRIBUTE-TREE", "(DEFUN (IDL-YIELD-ATTRIBUTE-TREE CONS) ((SLOT STORAGE-SLOT) (CLASS CLASS)))", Native.find_java_method("edu.isi.stella.StorageSlot", "idlYieldAttributeTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("IDL-YIELD-PARAMETERIZED-ATTRIBUTE-TREE", "(DEFUN (IDL-YIELD-PARAMETERIZED-ATTRIBUTE-TREE CONS) ((SLOT STORAGE-SLOT) (CLASS CLASS)))", Native.find_java_method("edu.isi.stella.StorageSlot", "idlYieldParameterizedAttributeTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("IDL-YIELD-STATIC-MEMBER-ALLOCATION-TREE", "(DEFUN (IDL-YIELD-STATIC-MEMBER-ALLOCATION-TREE CONS) ((SLOT STORAGE-SLOT) (CLASS CLASS)))", Native.find_java_method("edu.isi.stella.StorageSlot", "idlYieldStaticMemberAllocationTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("IDL-YIELD-OPERATION-SIGNATURE-TREE", "(DEFUN (IDL-YIELD-OPERATION-SIGNATURE-TREE CONS) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "idlYieldOperationSignatureTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("IDL-YIELD-CONSTRUCTOR-SIGNATURE-TREE", "(DEFUN (IDL-YIELD-CONSTRUCTOR-SIGNATURE-TREE CONS) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "idlYieldConstructorSignatureTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("ILLEGAL-IDL-METHOD?", "(DEFUN (ILLEGAL-IDL-METHOD? BOOLEAN) ((METHODSLOT METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "illegalIdlMethodP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("IDL-GET-PARAMETERIZED-ATTRIBUTE-DEFINITIONS", "(DEFUN (IDL-GET-PARAMETERIZED-ATTRIBUTE-DEFINITIONS CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "idlGetParameterizedAttributeDefinitions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("IDL-GET-ATTRIBUTE-DEFINITIONS", "(DEFUN (IDL-GET-ATTRIBUTE-DEFINITIONS CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "idlGetAttributeDefinitions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("IDL-GET-STATIC-VARIABLE-DEFINITIONS", "(DEFUN (IDL-GET-STATIC-VARIABLE-DEFINITIONS CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "idlGetStaticVariableDefinitions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("IDL-CONSTRUCTOR?", "(DEFUN (IDL-CONSTRUCTOR? BOOLEAN) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "idlConstructorP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("IDL-GET-CONSTRUCTOR-DEFINITIONS", "(DEFUN (IDL-GET-CONSTRUCTOR-DEFINITIONS CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "idlGetConstructorDefinitions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("IDL-GET-OPERATION-DEFINITIONS", "(DEFUN (IDL-GET-OPERATION-DEFINITIONS CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "idlGetOperationDefinitions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("IDL-CLASS-CATEGORY", "(DEFUN (IDL-CLASS-CATEGORY SYMBOL) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "idlClassCategory", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("IDL-TRANSLATE-DEFINE-NATIVE-CLASS-UNIT", "(DEFUN (IDL-TRANSLATE-DEFINE-NATIVE-CLASS-UNIT CONS) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "idlTranslateDefineNativeClassUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
          Stella.defineFunctionObject("STARTUP-IDL-CLASS-OUT", "(DEFUN STARTUP-IDL-CLASS-OUT () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupIdlClassOut", "startupIdlClassOut", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_IDL_CLASS_OUT);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupIdlClassOut"), Stella.NULL_STRING_WRAPPER);
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
