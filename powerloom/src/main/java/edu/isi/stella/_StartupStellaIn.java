//  -*- Mode: Java -*-
//
// _StartupStellaIn.java

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

public class _StartupStellaIn {
  public static void startupStellaIn() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Stella.KWD_PUBLIC_SLOTS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PUBLIC-SLOTS", null, 2)));
          Stella.KWD_SLOTS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOTS", null, 2)));
          Stella.KWD_PUBLIC_METHODS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PUBLIC-METHODS", null, 2)));
          Stella.KWD_METHODS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("METHODS", null, 2)));
          Stella.SYM_STELLA_SETTER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SETTER", null, 0)));
          Stella.KWD_SETTERp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SETTER?", null, 2)));
          Stella.SYM_STELLA_DEFAULT_OPTION_HANDLER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFAULT-OPTION-HANDLER", null, 0)));
          Stella.SYM_STELLA_STARTUP_STELLA_IN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-STELLA-IN", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Stella.$UNSUPPORTED_EXTERNAL_SLOT_OPTIONS$ = List.list(Cons.cons(Stella.KWD_ALLOCATION, Cons.cons(Stella.KWD_INITIALLY, Cons.cons(Stella.KWD_CONTEXT_SENSITIVEp, Cons.cons(Stella.KWD_HARDWIREDp, Stella.NIL)))));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("PERMANENTIFY-FORM", "(DEFUN (PERMANENTIFY-FORM OBJECT) ((FORM OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "permanentifyForm", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("TRANSIENTIFY-FORM", "(DEFUN (TRANSIENTIFY-FORM OBJECT) ((FORM OBJECT)) :GLOBALLY-INLINE? TRUE :PUBLIC? TRUE (RETURN (COPY-CONS-TREE FORM)))", Native.find_java_method("edu.isi.stella.Stella_Object", "transientifyForm", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("STRINGIFY-IN-MODULE", "(DEFUN (STRINGIFY-IN-MODULE STRING) ((TREE OBJECT) (MODULE MODULE)) :DOCUMENTATION \"Stringify a parse `tree' relative to `module', or\n`*module*' if no module is specified.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "stringifyInModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Module")}), null);
          Stella.defineFunctionObject("UNSTRINGIFY-IN-MODULE", "(DEFUN (UNSTRINGIFY-IN-MODULE OBJECT) ((STRING STRING) (MODULE MODULE)) :DOCUMENTATION \"Unstringify relative to `module', or `*MODULE*' if no\nmodule is specified.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "unstringifyInModule", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Module")}), null);
          Stella.defineFunctionObject("UNSTRINGIFY-STELLA-SOURCE", "(DEFUN (UNSTRINGIFY-STELLA-SOURCE OBJECT) ((SOURCE STRING) (MODULE MODULE)) :DOCUMENTATION \"Unstringify a STELLA `source' string relative to `module',\nor `*MODULE*' if no module is specified.  This function allocates transient\nobjects as opposed to `unstringify-in-module' or the regular `unstringify'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "unstringifyStellaSource", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Module")}), null);
          Stella.defineFunctionObject("COLLECT-FEATURE-LIST", "(DEFUN (COLLECT-FEATURE-LIST (LIST OF GENERALIZED-SYMBOL)) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "collectFeatureList", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("COLLECT-KEY-VALUE-LIST", "(DEFUN (COLLECT-KEY-VALUE-LIST (KEY-VALUE-LIST OF GENERALIZED-SYMBOL OBJECT)) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "collectKeyValueList", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("DEFINE-INLINE-METHOD", "(DEFUN (DEFINE-INLINE-METHOD METHOD-SLOT) ((NAME SYMBOL) (PARAMETERSANDBODY CONS)))", Native.find_java_method("edu.isi.stella.Symbol", "defineInlineMethod", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("HELP-DEFINE-CLASS-FROM-PARSE-TREE", "(DEFUN (HELP-DEFINE-CLASS-FROM-PARSE-TREE CLASS) ((PARSETREE CONS) (STRINGIFIEDSOURCE STRING)))", Native.find_java_method("edu.isi.stella.Cons", "helpDefineClassFromParseTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("DEFINE-STORAGE-SLOT-FROM-PARSE-TREE", "(DEFUN (DEFINE-STORAGE-SLOT-FROM-PARSE-TREE STORAGE-SLOT) ((SLOTDEF CONS) (OWNER TYPE)))", Native.find_java_method("edu.isi.stella.Cons", "defineStorageSlotFromParseTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("RECORD-SLOT-HOME-MODULE", "(DEFUN (RECORD-SLOT-HOME-MODULE MODULE) ((SELF SLOT)))", Native.find_java_method("edu.isi.stella.Slot", "recordSlotHomeModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), null);
          Stella.defineFunctionObject("EXPLICITLY-QUALIFIED-NAME?", "(DEFUN (EXPLICITLY-QUALIFIED-NAME? BOOLEAN) ((NAME GENERALIZED-SYMBOL) (DEFINITIONMODULE MODULE)))", Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "explicitlyQualifiedNameP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol"), Native.find_java_class("edu.isi.stella.Module")}), null);
          Stella.defineFunctionObject("GET-IDENTICAL-CLASS", "(DEFUN (GET-IDENTICAL-CLASS CLASS) ((CLASSNAME STRING) (STRINGIFIEDSOURCE STRING)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "getIdenticalClass", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("DEFINE-CLASS-FROM-PARSE-TREE", "(DEFUN (DEFINE-CLASS-FROM-PARSE-TREE CLASS) ((PARSETREE CONS)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Cons", "defineClassFromParseTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("DEFINE-CLASS-FROM-STRINGIFIED-SOURCE", "(DEFUN (DEFINE-CLASS-FROM-STRINGIFIED-SOURCE CLASS) ((CLASSNAME STRING) (STRINGIFIEDSOURCE STRING)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "defineClassFromStringifiedSource", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("EXTRACT-OPTIONS", "(DEFUN (EXTRACT-OPTIONS CONS) ((TREE CONS) (OPTIONSTABLE KEY-VALUE-LIST)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Cons", "extractOptions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
          Stella.defineFunctionObject("DESTRUCTURE-DEFMETHOD-TREE", "(DEFUN (DESTRUCTURE-DEFMETHOD-TREE OBJECT CONS CONS) ((METHOD-TREE CONS) (OPTIONS-TABLE KEY-VALUE-LIST)) :PUBLIC? TRUE :DOCUMENTATION \"Return three parse trees representing the name,\nparameters, and code body of the parse tree `method-tree'.  Fill\n`options-table' with a dictionary of method options.\nStorage note:  Options are treated specially because the other return\nvalues are subtrees of `method-tree', while `options-table' is a newly-created\ncons tree.  Note also, the parameter and body trees are destructively\nremoved from `method-tree'.\")", Native.find_java_method("edu.isi.stella.Cons", "destructureDefmethodTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.KeyValueList"), Native.find_java_class("[Ljava.lang.Object;")}), null);
          Stella.defineFunctionObject("YIELD-SETTER-METHOD-NAME", "(DEFUN (YIELD-SETTER-METHOD-NAME SYMBOL) ((METHODNAME SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "yieldSetterMethodName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("DESTRUCTURE-METHOD-NAME-TREE", "(DEFUN (DESTRUCTURE-METHOD-NAME-TREE SYMBOL CONS) ((NAMETREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "destructureMethodNameTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("[Ljava.lang.Object;")}), null);
          Stella.defineFunctionObject("IN-PLACE-NORMALIZE-METHOD-OPTIONS", "(DEFUN IN-PLACE-NORMALIZE-METHOD-OPTIONS ((METHODOPTIONS KEYWORD-KEY-VALUE-LIST) (METHODNAME SYMBOL)))", Native.find_java_method("edu.isi.stella.KeywordKeyValueList", "inPlaceNormalizeMethodOptions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.KeywordKeyValueList"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("GET-FUNCTION-WITH-IDENTICAL-SIGNATURE", "(DEFUN (GET-FUNCTION-WITH-IDENTICAL-SIGNATURE METHOD-SLOT) ((NAME SYMBOL) (STRINGIFIEDSOURCE STRING)))", Native.find_java_method("edu.isi.stella.Symbol", "getFunctionWithIdenticalSignature", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("GET-METHOD-WITH-IDENTICAL-SIGNATURE", "(DEFUN (GET-METHOD-WITH-IDENTICAL-SIGNATURE METHOD-SLOT) ((NAME SYMBOL) (PARAMETERSTREE CONS) (STRINGIFIEDSOURCE STRING)))", Native.find_java_method("edu.isi.stella.Symbol", "getMethodWithIdenticalSignature", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("HELP-DEFINE-METHOD-FROM-PARSE-TREE", "(DEFUN (HELP-DEFINE-METHOD-FROM-PARSE-TREE METHOD-SLOT BOOLEAN) ((INPUTTREE CONS) (STRINGIFIEDSOURCE STRING)))", Native.find_java_method("edu.isi.stella.Cons", "helpDefineMethodFromParseTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("java.lang.String"), Native.find_java_class("[Ljava.lang.Object;")}), null);
          Stella.defineFunctionObject("DEFINE-METHOD-FROM-PARSE-TREE", "(DEFUN (DEFINE-METHOD-FROM-PARSE-TREE METHOD-SLOT) ((PARSETREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "defineMethodFromParseTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("STRINGIFY-METHOD-SIGNATURE", "(DEFUN (STRINGIFY-METHOD-SIGNATURE STRING) ((PARSETREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "stringifyMethodSignature", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("STRINGIFY-METHOD-BODY?", "(DEFUN (STRINGIFY-METHOD-BODY? BOOLEAN) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "stringifyMethodBodyP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("DEFINE-METHOD-FROM-STRINGIFIED-SOURCE", "(DEFUN (DEFINE-METHOD-FROM-STRINGIFIED-SOURCE METHOD-SLOT) ((METHODNAME STRING) (CLASSNAME STRING) (STRINGIFIEDSOURCE STRING)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "defineMethodFromStringifiedSource", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("DEFINE-METHOD-OBJECT", "(DEFUN DEFINE-METHOD-OBJECT ((DEFINITION STRING) (CODE METHOD-CODE) (WRAPPERCODE METHOD-CODE)))", Native.find_java_method("edu.isi.stella.Stella", "defineMethodObject", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.reflect.Method"), Native.find_java_class("java.lang.reflect.Method")}), null);
          Stella.defineFunctionObject("DEFINE-EXTERNAL-SLOT-FROM-PARSE-TREE", "(DEFUN (DEFINE-EXTERNAL-SLOT-FROM-PARSE-TREE STORAGE-SLOT) ((PARSETREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "defineExternalSlotFromParseTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("DEFINE-EXTERNAL-SLOT-FROM-STRINGIFIED-SOURCE", "(DEFUN (DEFINE-EXTERNAL-SLOT-FROM-STRINGIFIED-SOURCE STORAGE-SLOT) ((STRINGIFIEDSOURCE STRING)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "defineExternalSlotFromStringifiedSource", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("LOOKUP-SLOT-FROM-OPTION-KEYWORD", "(DEFUN (LOOKUP-SLOT-FROM-OPTION-KEYWORD STORAGE-SLOT) ((OWNER TYPE) (KEYWORD KEYWORD)))", Native.find_java_method("edu.isi.stella.Surrogate", "lookupSlotFromOptionKeyword", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("LOOKUP-OPTION-HANDLER", "(DEFUN (LOOKUP-OPTION-HANDLER METHOD-SLOT) ((SLOT STORAGE-SLOT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.StorageSlot", "lookupOptionHandler", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
          Stella.defineFunctionObject("RUN-OPTION-HANDLER?", "(DEFUN (RUN-OPTION-HANDLER? BOOLEAN) ((OBJECT OBJECT) (OPTION KEYWORD) (VALUETREE OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "runOptionHandlerP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("DEFAULT-OPTION-HANDLER", "(DEFUN DEFAULT-OPTION-HANDLER ((SELF OBJECT) (SLOT STORAGE-SLOT) (TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "defaultOptionHandler", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("STARTUP-STELLA-IN", "(DEFUN STARTUP-STELLA-IN () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupStellaIn", "startupStellaIn", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_STELLA_IN);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupStellaIn"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *REDEFINE-IDENTICAL-CLASSES?* BOOLEAN FALSE :DOCUMENTATION \"If `true', always redefine classes, even if an\n                  identical class exists\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *UNSUPPORTED-EXTERNAL-SLOT-OPTIONS* (LIST OF KEYWORD) (LIST :ALLOCATION :INITIALLY :CONTEXT-SENSITIVE? :HARDWIRED?))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *DEFAULT-OPTION-HANDLER* METHOD-SLOT NULL)");
          Stella.$DEFAULT_OPTION_HANDLER$ = Symbol.lookupFunction(Stella.SYM_STELLA_DEFAULT_OPTION_HANDLER);
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
