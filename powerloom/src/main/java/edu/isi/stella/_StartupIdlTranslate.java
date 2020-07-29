//  -*- Mode: Java -*-
//
// _StartupIdlTranslate.java

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

public class _StartupIdlTranslate {
  public static void startupIdlTranslate() {
    if (Stella.currentStartupTimePhaseP(1)) {
      Module.defineModuleFromStringifiedSource("/IDL-THEORY", "(:CASE-SENSITIVE? TRUE :USES () :LISP-PACKAGE \"IDL\")");
      Module.defineModuleFromStringifiedSource("/IDL-THEORY/IDL-USER-THEORY", "(:CASE-SENSITIVE? TRUE :USES () :LISP-PACKAGE \"IDL-USER\")");
    }
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Stella.SYM_STELLA_IDL_TYPEDEF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IDL_TYPEDEF", null, 0)));
          Stella.SYM_STELLA_IDL_IDENT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IDL_IDENT", null, 0)));
          Stella.SYM_STELLA_IDL_LITERAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IDL_LITERAL", null, 0)));
          Stella.SYM_STELLA_STARTUP_IDL_TRANSLATE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-IDL-TRANSLATE", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Stella.$IDL_CHARACTER_SUBSTITUTION_TABLE$ = Stella.idlCreateCharacterSubstitutionTable();
          Stella.$IDL_RESERVED_WORD_TABLE$ = Stella.idlCreateReservedWordTable();
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("IDL-TRANSLATE-A-TREE", "(DEFUN (IDL-TRANSLATE-A-TREE OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "idlTranslateATree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("IDL-TRANSLATE-UNIT", "(DEFUN (IDL-TRANSLATE-UNIT CONS) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "idlTranslateUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
          Stella.defineFunctionObject("IDL-TRANSLATE-DEFTYPE-UNIT", "(DEFUN (IDL-TRANSLATE-DEFTYPE-UNIT CONS) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "idlTranslateDeftypeUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
          Stella.defineFunctionObject("IDL-TRANSLATE-NULL", "(DEFUN (IDL-TRANSLATE-NULL CONS) ())", Native.find_java_method("edu.isi.stella.Stella", "idlTranslateNull", new java.lang.Class [] {}), null);
          Stella.defineMethodObject("(DEFMETHOD (IDL-TRANSLATE-ATOMIC-TREE CONS) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "idlTranslateAtomicTree", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (IDL-TRANSLATE-ATOMIC-TREE CONS) ((TREE SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "idlTranslateAtomicTree", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("IDL-TRANSLATE-TYPE-SPEC", "(DEFUN (IDL-TRANSLATE-TYPE-SPEC STRING-WRAPPER) ((TYPESPEC TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.StandardObject", "idlTranslateTypeSpec", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject")}), null);
          Stella.defineFunctionObject("IDL-TRANSLATE-CLASS-NAME", "(DEFUN (IDL-TRANSLATE-CLASS-NAME STRING-WRAPPER) ((NAMESYMBOL GENERALIZED-SYMBOL)))", Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "idlTranslateClassName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol")}), null);
          Stella.defineFunctionObject("IDL-CREATE-CHARACTER-SUBSTITUTION-TABLE", "(DEFUN (IDL-CREATE-CHARACTER-SUBSTITUTION-TABLE STRING) ())", Native.find_java_method("edu.isi.stella.Stella", "idlCreateCharacterSubstitutionTable", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("IDL-SUBSTITUTE-FORBIDDEN-CHARACTERS", "(DEFUN (IDL-SUBSTITUTE-FORBIDDEN-CHARACTERS STRING) ((NAME STRING) (CASECONVENTION KEYWORD)))", Native.find_java_method("edu.isi.stella.Stella", "idlSubstituteForbiddenCharacters", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("IDL-CHANGE-CASE", "(DEFUN (IDL-CHANGE-CASE STRING) ((SYMBOL GENERALIZED-SYMBOL) (CASECONVENTION KEYWORD)))", Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "idlChangeCase", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("IDL-YIELD-RENAMED-RESERVED-WORD", "(DEFUN (IDL-YIELD-RENAMED-RESERVED-WORD STRING-WRAPPER) ((WORD SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "idlYieldRenamedReservedWord", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("IDL-CREATE-RESERVED-WORD-TABLE", "(DEFUN (IDL-CREATE-RESERVED-WORD-TABLE STRING-HASH-TABLE) ())", Native.find_java_method("edu.isi.stella.Stella", "idlCreateReservedWordTable", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("IDL-LOOKUP-RESERVED-WORD-TABLE", "(DEFUN (IDL-LOOKUP-RESERVED-WORD-TABLE STRING-WRAPPER) ((WORD SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "idlLookupReservedWordTable", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("IDL-TRANSLATE-NAME", "(DEFUN (IDL-TRANSLATE-NAME STRING-WRAPPER) ((NAMESYMBOL SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "idlTranslateName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("IDL-TRANSLATE-SYMBOL-CONSTANT-NAME", "(DEFUN (IDL-TRANSLATE-SYMBOL-CONSTANT-NAME STRING-WRAPPER) ((SYMBOL GENERALIZED-SYMBOL)))", Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "idlTranslateSymbolConstantName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol")}), null);
          Stella.defineFunctionObject("IDL-TRANSLATE-SYMBOL-CONSTANT-ID", "(DEFUN (IDL-TRANSLATE-SYMBOL-CONSTANT-ID STRING-WRAPPER) ((SYMBOL GENERALIZED-SYMBOL)))", Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "idlTranslateSymbolConstantId", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol")}), null);
          Stella.defineFunctionObject("IDL-TRANSLATE-SYMBOL-NAME", "(DEFUN (IDL-TRANSLATE-SYMBOL-NAME STRING-WRAPPER) ((SYMBOL SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "idlTranslateSymbolName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("IDL-TRANSLATE-SYMBOL-ID", "(DEFUN (IDL-TRANSLATE-SYMBOL-ID STRING-WRAPPER) ((SYMBOL SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "idlTranslateSymbolId", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("IDL-TRANSLATE-SURROGATE-NAME", "(DEFUN (IDL-TRANSLATE-SURROGATE-NAME STRING-WRAPPER) ((SURROGATE SURROGATE)))", Native.find_java_method("edu.isi.stella.Surrogate", "idlTranslateSurrogateName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("IDL-TRANSLATE-SURROGATE-ID", "(DEFUN (IDL-TRANSLATE-SURROGATE-ID STRING-WRAPPER) ((SURROGATE SURROGATE)))", Native.find_java_method("edu.isi.stella.Surrogate", "idlTranslateSurrogateId", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("IDL-TRANSLATE-KEYWORD-NAME", "(DEFUN (IDL-TRANSLATE-KEYWORD-NAME STRING-WRAPPER) ((KEYWORD KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "idlTranslateKeywordName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("IDL-TRANSLATE-KEYWORD-ID", "(DEFUN (IDL-TRANSLATE-KEYWORD-ID STRING-WRAPPER) ((KEYWORD KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "idlTranslateKeywordId", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("IDL-TRANSLATE-CLASS-PARAMETER-NAME", "(DEFUN (IDL-TRANSLATE-CLASS-PARAMETER-NAME STRING-WRAPPER) ((NAMESYMBOL SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "idlTranslateClassParameterName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("IDL-CREATE-OVERLOADED-FUNCTION-NAME", "(DEFUN (IDL-CREATE-OVERLOADED-FUNCTION-NAME SYMBOL) ((FUNCTIONNAME SYMBOL) (CLASSTYPE TYPE)))", Native.find_java_method("edu.isi.stella.Symbol", "idlCreateOverloadedFunctionName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("IDL-METHOD-OBJECT-IS-OVERLOADED-FUNCTION?", "(DEFUN (IDL-METHOD-OBJECT-IS-OVERLOADED-FUNCTION? BOOLEAN) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "idlMethodObjectIsOverloadedFunctionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("IDL-TRANSLATE-FUNCTION-NAME", "(DEFUN (IDL-TRANSLATE-FUNCTION-NAME STRING-WRAPPER) ((FUNCTION METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "idlTranslateFunctionName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("IDL-TRANSLATE-METHOD-PARAMETER", "(DEFUN (IDL-TRANSLATE-METHOD-PARAMETER OBJECT) ((NAME SYMBOL) (TYPE TYPE-SPEC) (DIRECTION SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "idlTranslateMethodParameter", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("IDL-TRANSLATE-METHOD-PARAMETERS", "(DEFUN (IDL-TRANSLATE-METHOD-PARAMETERS CONS) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "idlTranslateMethodParameters", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("IDL-TRANSLATE-CONSTRUCTOR-NAME", "(DEFUN (IDL-TRANSLATE-CONSTRUCTOR-NAME STRING-WRAPPER) ((CONSTRUCTOR METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "idlTranslateConstructorName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("STARTUP-IDL-TRANSLATE", "(DEFUN STARTUP-IDL-TRANSLATE () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupIdlTranslate", "startupIdlTranslate", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_IDL_TRANSLATE);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupIdlTranslate"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *IDL-CHARACTER-SUBSTITUTION-TABLE* STRING (IDL-CREATE-CHARACTER-SUBSTITUTION-TABLE))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *IDL-RESERVED-WORD-TABLE* (STRING-HASH-TABLE OF STRING STRING-WRAPPER) (IDL-CREATE-RESERVED-WORD-TABLE))");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
