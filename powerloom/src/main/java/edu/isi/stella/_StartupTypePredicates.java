//  -*- Mode: Java -*-
//
// _StartupTypePredicates.java

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

public class _StartupTypePredicates {
  public static void startupTypePredicates() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Stella.SGT_STELLA_UNKNOWN = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("UNKNOWN", null, 1)));
          Stella.SGT_STELLA_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("WRAPPER", null, 1)));
          Stella.SYM_STELLA_STARTUP_TYPE_PREDICATES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-TYPE-PREDICATES", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("SAFE-PRIMARY-TYPE", "(DEFUN (SAFE-PRIMARY-TYPE TYPE) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "safePrimaryType", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("BOOTSTRAP-ISA?", "(DEFUN (BOOTSTRAP-ISA? BOOLEAN) ((X OBJECT) (TYPE TYPE)))", Native.find_java_method("edu.isi.stella.Stella_Object", "bootstrapIsaP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("BOOTSTRAP-SUBTYPE-OF?", "(DEFUN (BOOTSTRAP-SUBTYPE-OF? BOOLEAN) ((SUBTYPE TYPE) (SUPERTYPE TYPE)))", Native.find_java_method("edu.isi.stella.Surrogate", "bootstrapSubtypeOfP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("BOOLEAN?", "(DEFUN (BOOLEAN? BOOLEAN) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "booleanP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF-BOOLEAN?", "(DEFUN (SUBTYPE-OF-BOOLEAN? BOOLEAN) ((TYPE TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfBooleanP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("INTEGER?", "(DEFUN (INTEGER? BOOLEAN) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "integerP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF-INTEGER?", "(DEFUN (SUBTYPE-OF-INTEGER? BOOLEAN) ((TYPE TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfIntegerP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("LONG-INTEGER?", "(DEFUN (LONG-INTEGER? BOOLEAN) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "longIntegerP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF-LONG-INTEGER?", "(DEFUN (SUBTYPE-OF-LONG-INTEGER? BOOLEAN) ((TYPE TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfLongIntegerP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("FLOAT?", "(DEFUN (FLOAT? BOOLEAN) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "floatP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF-FLOAT?", "(DEFUN (SUBTYPE-OF-FLOAT? BOOLEAN) ((TYPE TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfFloatP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("STRING?", "(DEFUN (STRING? BOOLEAN) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "stringP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF-STRING?", "(DEFUN (SUBTYPE-OF-STRING? BOOLEAN) ((TYPE TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfStringP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("VERBATIM-STRING?", "(DEFUN (VERBATIM-STRING? BOOLEAN) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "verbatimStringP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF-VERBATIM-STRING?", "(DEFUN (SUBTYPE-OF-VERBATIM-STRING? BOOLEAN) ((TYPE TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfVerbatimStringP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("CHARACTER?", "(DEFUN (CHARACTER? BOOLEAN) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "characterP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF-CHARACTER?", "(DEFUN (SUBTYPE-OF-CHARACTER? BOOLEAN) ((TYPE TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfCharacterP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("WRAPPER?", "(DEFUN (WRAPPER? BOOLEAN) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "wrapperP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF-WRAPPER?", "(DEFUN (SUBTYPE-OF-WRAPPER? BOOLEAN) ((TYPE TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfWrapperP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("SURROGATE?", "(DEFUN (SURROGATE? BOOLEAN) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "surrogateP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF-SURROGATE?", "(DEFUN (SUBTYPE-OF-SURROGATE? BOOLEAN) ((TYPE TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfSurrogateP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("TYPE?", "(DEFUN (TYPE? BOOLEAN) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "typeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF-TYPE?", "(DEFUN (SUBTYPE-OF-TYPE? BOOLEAN) ((TYPE TYPE)) :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (SUBTYPE-OF-SURROGATE? TYPE)))", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfTypeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("SYMBOL?", "(DEFUN (SYMBOL? BOOLEAN) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "symbolP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF-SYMBOL?", "(DEFUN (SUBTYPE-OF-SYMBOL? BOOLEAN) ((TYPE TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfSymbolP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("TRANSIENT-SYMBOL?", "(DEFUN (TRANSIENT-SYMBOL? BOOLEAN) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "transientSymbolP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF-TRANSIENT-SYMBOL?", "(DEFUN (SUBTYPE-OF-TRANSIENT-SYMBOL? BOOLEAN) ((TYPE TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfTransientSymbolP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("KEYWORD?", "(DEFUN (KEYWORD? BOOLEAN) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "keywordP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF-KEYWORD?", "(DEFUN (SUBTYPE-OF-KEYWORD? BOOLEAN) ((TYPE TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfKeywordP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("CONS?", "(DEFUN (CONS? BOOLEAN) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "consP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF-CONS?", "(DEFUN (SUBTYPE-OF-CONS? BOOLEAN) ((TYPE TYPE)) :GLOBALLY-INLINE? TRUE :PUBLIC? TRUE (RETURN (EQL? TYPE @CONS)))", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfConsP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("STELLA-CLASS?", "(DEFUN (STELLA-CLASS? BOOLEAN) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "stellaClassP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF-CLASS?", "(DEFUN (SUBTYPE-OF-CLASS? BOOLEAN) ((TYPE TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfClassP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("STORAGE-SLOT?", "(DEFUN (STORAGE-SLOT? BOOLEAN) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "storageSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF-STORAGE-SLOT?", "(DEFUN (SUBTYPE-OF-STORAGE-SLOT? BOOLEAN) ((TYPE TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfStorageSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("METHOD-SLOT?", "(DEFUN (METHOD-SLOT? BOOLEAN) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "methodSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF-METHOD-SLOT?", "(DEFUN (SUBTYPE-OF-METHOD-SLOT? BOOLEAN) ((TYPE TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfMethodSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("ANCHORED-TYPE-SPECIFIER?", "(DEFUN (ANCHORED-TYPE-SPECIFIER? BOOLEAN) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "anchoredTypeSpecifierP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF-ANCHORED-TYPE-SPECIFIER?", "(DEFUN (SUBTYPE-OF-ANCHORED-TYPE-SPECIFIER? BOOLEAN) ((TYPE TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfAnchoredTypeSpecifierP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("PARAMETRIC-TYPE-SPECIFIER?", "(DEFUN (PARAMETRIC-TYPE-SPECIFIER? BOOLEAN) ((X OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "parametricTypeSpecifierP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF-PARAMETRIC-TYPE-SPECIFIER?", "(DEFUN (SUBTYPE-OF-PARAMETRIC-TYPE-SPECIFIER? BOOLEAN) ((TYPE TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfParametricTypeSpecifierP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineMethodObject("(DEFMETHOD (STANDARD-OBJECT? BOOLEAN) ((SELF OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "standardObjectP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (STANDARD-OBJECT? BOOLEAN) ((SELF STANDARD-OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.StandardObject", "standardObjectP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("STARTUP-TYPE-PREDICATES", "(DEFUN STARTUP-TYPE-PREDICATES () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupTypePredicates", "startupTypePredicates", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_TYPE_PREDICATES);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupTypePredicates"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CLASS-HIERARCHY-BOOTED?* BOOLEAN FALSE)");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
