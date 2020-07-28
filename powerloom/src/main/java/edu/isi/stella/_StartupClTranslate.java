//  -*- Mode: Java -*-
//
// _StartupClTranslate.java

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

public class _StartupClTranslate {
  static void helpStartupClTranslate1() {
    {
      Stella.SYM_STELLA_xe = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("!=", null, 0)));
      Stella.KWD_CONTINUE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTINUE", null, 2)));
      Stella.SYM_STELLA_rrVALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("%%VALUE", null, 0)));
      Stella.SYM_STELLA_rrREST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("%%REST", null, 0)));
      Stella.SYM_STELLA_CLSYS_SVAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLSYS-SVAL", null, 0)));
      Stella.SYM_STELLA_NTH_SETTER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NTH-SETTER", null, 0)));
      Stella.SYM_STELLA_NORMAL_CALL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NORMAL-CALL", null, 0)));
      Stella.SYM_STELLA_NON_OBJECT_METHOD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NON-OBJECT-METHOD", null, 0)));
      Stella.SYM_STELLA_OBJECT_METHOD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OBJECT-METHOD", null, 0)));
      Stella.SYM_STELLA_CLSYS_CALL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLSYS-CALL", null, 0)));
      Stella.SGT_STELLA_NATIVE_VECTOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("NATIVE-VECTOR", null, 1)));
      Stella.SYM_STELLA_ARGUMENT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ARGUMENT", null, 0)));
      Stella.SYM_STELLA_NULL_ARRAYp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL-ARRAY?", null, 0)));
      Stella.SYM_STELLA_$CONDITION_MESSAGE_KEYWORD$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("*CONDITION-MESSAGE-KEYWORD*", null, 0)));
      Stella.SYM_STELLA_REPLACE_SUBSTRINGS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("REPLACE-SUBSTRINGS", null, 0)));
      Stella.SYM_STELLA_CLSYS_MAKE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLSYS-MAKE", null, 0)));
      Stella.KWD_INITIAL_ELEMENT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INITIAL-ELEMENT", null, 2)));
      Stella.SYM_STELLA_rrPRINT_STREAM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("%%PRINT-STREAM", null, 0)));
      Stella.SYM_STELLA_CLSYS_METHOD_CODE_CALL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLSYS-METHOD-CODE-CALL", null, 0)));
      Stella.SYM_STELLA_MACRO = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MACRO", null, 0)));
      Stella.SYM_STELLA_CLSYS_SELF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLSYS-SELF", null, 0)));
      Stella.SYM_STELLA_CLSYS_DUMMY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLSYS-DUMMY", null, 0)));
      Stella.SYM_STELLA_rrDEFCONSMETHOD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("%%DEFCONSMETHOD", null, 0)));
      Stella.SYM_STELLA_rrDEFINTEGERMETHOD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("%%DEFINTEGERMETHOD", null, 0)));
      Stella.SYM_STELLA_$CLSYS_SELF$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("*CLSYS-SELF*", null, 0)));
      Stella.KWD_VOID = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("VOID", null, 2)));
      Stella.KWD_INITFORM = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INITFORM", null, 2)));
      Stella.KWD_ACCESSOR = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ACCESSOR", null, 2)));
      Stella.SYM_STELLA_CLSYS_ROOT_OBJECT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLSYS-ROOT-OBJECT", null, 0)));
      Stella.SYM_STELLA_CLSYS_ROOT_STRUCT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLSYS-ROOT-STRUCT", null, 0)));
      Stella.KWD_CONC_NAME = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONC-NAME", null, 2)));
      Stella.KWD_CONSTRUCTOR = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONSTRUCTOR", null, 2)));
      Stella.KWD_COPIER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("COPIER", null, 2)));
      Stella.KWD_PREDICATE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PREDICATE", null, 2)));
      Stella.SYM_STELLA_ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("", null, 0)));
      Stella.KWD_INCLUDE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INCLUDE", null, 2)));
      Stella.SYM_STELLA_STARTUP_CL_TRANSLATE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-CL-TRANSLATE", null, 0)));
    }
  }

  static void helpStartupClTranslate2() {
    {
      Stella.defineFunctionObject("DESTRUCTURE-CALL-TREE", "(DEFUN (DESTRUCTURE-CALL-TREE SYMBOL TYPE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "destructureCallTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("USE-CL-CONSES?", "(DEFUN (USE-CL-CONSES? BOOLEAN) () :GLOBALLY-INLINE? TRUE (RETURN (ENABLED-STELLA-FEATURE? :USE-COMMON-LISP-CONSES)))", Native.find_java_method("edu.isi.stella.Stella", "useClConsesP", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("USE-DEFCONSMETHOD?", "(DEFUN (USE-DEFCONSMETHOD? BOOLEAN) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "useDefconsmethodP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("USE-CL-STRUCTS?", "(DEFUN (USE-CL-STRUCTS? BOOLEAN) () :GLOBALLY-INLINE? TRUE (RETURN (ENABLED-STELLA-FEATURE? :USE-COMMON-LISP-STRUCTS)))", Native.find_java_method("edu.isi.stella.Stella", "useClStructsP", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("USE-VECTOR-STRUCTS?", "(DEFUN (USE-VECTOR-STRUCTS? BOOLEAN) () :GLOBALLY-INLINE? TRUE (RETURN (ENABLED-STELLA-FEATURE? :USE-COMMON-LISP-VECTOR-STRUCTS)))", Native.find_java_method("edu.isi.stella.Stella", "useVectorStructsP", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-LIST-OF-TREES", "(DEFUN (CL-TRANSLATE-LIST-OF-TREES CONS) ((TREES CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateListOfTrees", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-VOID-SYS", "(DEFUN (CL-TRANSLATE-VOID-SYS CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateVoidSys", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-TYPED-SYS", "(DEFUN (CL-TRANSLATE-TYPED-SYS OBJECT) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateTypedSys", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-BAD-SYS", "(DEFUN (CL-TRANSLATE-BAD-SYS OBJECT) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateBadSys", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-A-TREE", "(DEFUN (CL-TRANSLATE-A-TREE OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "clTranslateATree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("HELP-CL-TRANSLATE-A-TREE", "(DEFUN (HELP-CL-TRANSLATE-A-TREE OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "helpClTranslateATree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineMethodObject("(DEFMETHOD (CL-TRANSLATE-ATOMIC-TREE OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "clTranslateAtomicTree", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CL-TRANSLATE-ATOMIC-TREE OBJECT) ((TREE FLOAT-WRAPPER)))", Native.find_java_method("edu.isi.stella.FloatWrapper", "clTranslateAtomicTree", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CL-TRANSLATE-ATOMIC-TREE OBJECT) ((TREE SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "clTranslateAtomicTree", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CL-TRANSLATE-ATOMIC-TREE OBJECT) ((TREE KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "clTranslateAtomicTree", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CL-TRANSLATE-ATOMIC-TREE OBJECT) ((TREE SURROGATE)))", Native.find_java_method("edu.isi.stella.Surrogate", "clTranslateAtomicTree", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("CL-TRANSLATE-GLOBAL-SYMBOL", "(DEFUN (CL-TRANSLATE-GLOBAL-SYMBOL OBJECT) ((SYMBOL SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "clTranslateGlobalSymbol", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("YIELD-READABLE-SYMBOL-NAME", "(DEFUN (YIELD-READABLE-SYMBOL-NAME STRING) ((SYMBOLMODULE MODULE) (SYMBOLNAME STRING) (LOCAL? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Module", "yieldReadableSymbolName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("java.lang.String"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("YIELD-GLOBAL-LISP-SYMBOL", "(DEFUN (YIELD-GLOBAL-LISP-SYMBOL OBJECT) ((SYMBOLMODULE MODULE) (SYMBOLNAME STRING)))", Native.find_java_method("edu.isi.stella.Module", "yieldGlobalLispSymbol", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-LOCAL-SYMBOL", "(DEFUN (CL-TRANSLATE-LOCAL-SYMBOL OBJECT) ((SYMBOL SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "clTranslateLocalSymbol", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-SETQ-TREE", "(DEFUN (CL-TRANSLATE-SETQ-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateSetqTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("YIELD-STRUCT-SLOT-ACCESSOR-NAME", "(DEFUN (YIELD-STRUCT-SLOT-ACCESSOR-NAME OBJECT) ((CLASSTYPE TYPE) (SLOTNAME SYMBOL)))", Native.find_java_method("edu.isi.stella.Surrogate", "yieldStructSlotAccessorName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("YIELD-CLOS-SLOT-ACCESSOR-NAME", "(DEFUN (YIELD-CLOS-SLOT-ACCESSOR-NAME OBJECT) ((SLOTNAME SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "yieldClosSlotAccessorName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("YIELD-SLOT-VALUE-READER-TREE", "(DEFUN (YIELD-SLOT-VALUE-READER-TREE CONS) ((SLOTNAME SYMBOL) (OBJECTREF OBJECT) (OBJECTTYPE TYPE)))", Native.find_java_method("edu.isi.stella.Symbol", "yieldSlotValueReaderTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("YIELD-SLOT-VALUE-WRITER-TREE", "(DEFUN (YIELD-SLOT-VALUE-WRITER-TREE CONS) ((SLOTNAME SYMBOL) (OBJECTREF OBJECT) (OBJECTTYPE TYPE) (VALUEREF OBJECT)))", Native.find_java_method("edu.isi.stella.Symbol", "yieldSlotValueWriterTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("TRUE-SLOT-NAME", "(DEFUN (TRUE-SLOT-NAME SYMBOL) ((SLOTNAME SYMBOL) (TYPE TYPE)))", Native.find_java_method("edu.isi.stella.Symbol", "trueSlotName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-FIXED-SLOT-VALUE-TREE", "(DEFUN (CL-TRANSLATE-FIXED-SLOT-VALUE-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateFixedSlotValueTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-FIXED-SLOT-VALUE-SETTER-TREE", "(DEFUN (CL-TRANSLATE-FIXED-SLOT-VALUE-SETTER-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateFixedSlotValueSetterTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-CALL-METHOD-TREE", "(DEFUN (CL-TRANSLATE-CALL-METHOD-TREE OBJECT) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateCallMethodTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("METHOD-CALL-TYPE-FOR-VECTOR-STRUCTS", "(DEFUN (METHOD-CALL-TYPE-FOR-VECTOR-STRUCTS SYMBOL) ((SLOTNAME SYMBOL) (OWNER TYPE) (FUNCTION? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Symbol", "methodCallTypeForVectorStructs", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Surrogate"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-NORMAL-CALL-METHOD-TREE", "(DEFUN (CL-TRANSLATE-NORMAL-CALL-METHOD-TREE CONS) ((OPERATOR SYMBOL) (OWNER TYPE) (ARGUMENTS CONS)))", Native.find_java_method("edu.isi.stella.Symbol", "clTranslateNormalCallMethodTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-NTH-TREE", "(DEFUN (CL-TRANSLATE-NTH-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateNthTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-AREF-TREE", "(DEFUN (CL-TRANSLATE-AREF-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateArefTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-ARGUMENT-LIST-TREE", "(DEFUN (CL-TRANSLATE-ARGUMENT-LIST-TREE OBJECT) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateArgumentListTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("DUPLICATE-CURSOR-VARIABLE?", "(DEFUN (DUPLICATE-CURSOR-VARIABLE? BOOLEAN) ((VARIABLE SYMBOL) (ITERATORBINDINGS CONS)))", Native.find_java_method("edu.isi.stella.Symbol", "duplicateCursorVariableP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-FOREACH-TREE", "(DEFUN (CL-TRANSLATE-FOREACH-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateForeachTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("MAYBE-WRAP-WITH-CONTINUE-LABEL", "(DEFUN (MAYBE-WRAP-WITH-CONTINUE-LABEL CONS) ((TRANSLATEDLOOPBODY CONS)))", Native.find_java_method("edu.isi.stella.Cons", "maybeWrapWithContinueLabel", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-LET-TREE", "(DEFUN (CL-TRANSLATE-LET-TREE CONS) ((TREE CONS) (SPECIAL? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateLetTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-SPECIAL-TREE", "(DEFUN (CL-TRANSLATE-SPECIAL-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateSpecialTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-STARTUP-TIME-PROGN-TREE", "(DEFUN (CL-TRANSLATE-STARTUP-TIME-PROGN-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateStartupTimePrognTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-UNWIND-PROTECT-TREE", "(DEFUN (CL-TRANSLATE-UNWIND-PROTECT-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateUnwindProtectTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-SIGNAL-TREE", "(DEFUN (CL-TRANSLATE-SIGNAL-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateSignalTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-HANDLER-CASE-TREE", "(DEFUN (CL-TRANSLATE-HANDLER-CASE-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateHandlerCaseTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-HANDLE-EXCEPTION-TREE", "(DEFUN (CL-TRANSLATE-HANDLE-EXCEPTION-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateHandleExceptionTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CAST", "(DEFUN (CAST OBJECT) ((VALUE OBJECT) (TYPE TYPE)) :DOCUMENTATION \"Perform a run-time type check, and then return `value'.\")", Native.find_java_method("edu.isi.stella.Stella_Object", "cast", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("COERCE-NUMERIC-CONSTANT", "(DEFUN (COERCE-NUMERIC-CONSTANT NUMBER-WRAPPER) ((CONSTANT NUMBER-WRAPPER) (TYPE TYPE)))", Native.find_java_method("edu.isi.stella.NumberWrapper", "coerceNumericConstant", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-CAST-TREE", "(DEFUN (CL-TRANSLATE-CAST-TREE OBJECT) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateCastTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-RETURN-TREE", "(DEFUN (CL-TRANSLATE-RETURN-TREE OBJECT) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateReturnTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-BOOLEAN-TEST", "(DEFUN (CL-TRANSLATE-BOOLEAN-TEST OBJECT) ((TREE OBJECT) (INVERT? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Stella_Object", "clTranslateBooleanTest", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-PLAIN-BOOLEAN-TEST", "(DEFUN (CL-TRANSLATE-PLAIN-BOOLEAN-TEST OBJECT) ((TREE OBJECT) (INVERT? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Stella_Object", "clTranslatePlainBooleanTest", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-WHILE-TREE", "(DEFUN (CL-TRANSLATE-WHILE-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateWhileTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-CONDITIONAL-TREE", "(DEFUN (CL-TRANSLATE-CONDITIONAL-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateConditionalTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-COND-TREE", "(DEFUN (CL-TRANSLATE-COND-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateCondTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-CASE-TREE", "(DEFUN (CL-TRANSLATE-CASE-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateCaseTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-BOOLEAN-TREE", "(DEFUN (CL-TRANSLATE-BOOLEAN-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateBooleanTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-CLASS-NAME", "(DEFUN (CL-TRANSLATE-CLASS-NAME OBJECT) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "clTranslateClassName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-STRUCT-CONSTRUCTOR-NAME", "(DEFUN (YIELD-STRUCT-CONSTRUCTOR-NAME OBJECT) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldStructConstructorName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-MAKE-TREE", "(DEFUN (CL-TRANSLATE-MAKE-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateMakeTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-NEW-TREE", "(DEFUN (CL-TRANSLATE-NEW-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateNewTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-NEW-ARRAY-TREE", "(DEFUN (CL-TRANSLATE-NEW-ARRAY-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateNewArrayTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
    }
  }

  public static void startupClTranslate() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupClTranslate.helpStartupClTranslate1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Stella.$CL_TRUE_STRING_WRAPPER$ = VerbatimStringWrapper.newVerbatimStringWrapper("CL:T");
          Stella.$CL_FALSE_STRING_WRAPPER$ = VerbatimStringWrapper.newVerbatimStringWrapper("CL:NIL");
          Stella.$NEEDEXPLICITRETURNp$.setDefaultValue(new Boolean(false));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupClTranslate.helpStartupClTranslate2();
          Stella.defineFunctionObject("CL-TRANSLATE-OPERATOR-TREE", "(DEFUN (CL-TRANSLATE-OPERATOR-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateOperatorTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("YIELD-FORMAT-ARGUMENTS", "(DEFUN (YIELD-FORMAT-ARGUMENTS CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "yieldFormatArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("YIELD-PRINT-TREE", "(DEFUN (YIELD-PRINT-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "yieldPrintTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CL-TRANSLATE-PRINT-STREAM-TREE", "(DEFUN (CL-TRANSLATE-PRINT-STREAM-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslatePrintStreamTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CL-TRANSLATE-CALL-FUNCTION-CODE-TREE", "(DEFUN (CL-TRANSLATE-CALL-FUNCTION-CODE-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateCallFunctionCodeTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CL-TRANSLATE-INLINE-CALL-TREE", "(DEFUN (CL-TRANSLATE-INLINE-CALL-TREE OBJECT) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateInlineCallTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CL-TRANSLATE-VERBATIM-BODY-SYMBOLS", "(DEFUN (CL-TRANSLATE-VERBATIM-BODY-SYMBOLS OBJECT) ((BODY OBJECT) (PARAMETERS (LIST OF SYMBOL))))", Native.find_java_method("edu.isi.stella.Stella_Object", "clTranslateVerbatimBodySymbols", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("CL-TRANSLATE-THE-CODE-TREE", "(DEFUN (CL-TRANSLATE-THE-CODE-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateTheCodeTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CL-TRANSLATE-VERBATIM-TREE", "(DEFUN (CL-TRANSLATE-VERBATIM-TREE OBJECT) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateVerbatimTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CL-TRANSLATE-INLINE-TREE", "(DEFUN (CL-TRANSLATE-INLINE-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "clTranslateInlineTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("GENERATE-CL-TYPE-DECLARATIONS?", "(DEFUN (GENERATE-CL-TYPE-DECLARATIONS? BOOLEAN) ())", Native.find_java_method("edu.isi.stella.Stella", "generateClTypeDeclarationsP", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("LOOKUP-CL-TYPE-FROM-STELLA-TYPE", "(DEFUN (LOOKUP-CL-TYPE-FROM-STELLA-TYPE OBJECT) ((TYPE TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.StandardObject", "lookupClTypeFromStellaType", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject")}), null);
          Stella.defineFunctionObject("CL-YIELD-TYPED-EXPRESSION-TREE", "(DEFUN (CL-YIELD-TYPED-EXPRESSION-TREE OBJECT) ((TREE OBJECT) (TYPE TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.Stella_Object", "clYieldTypedExpressionTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.StandardObject")}), null);
          Stella.defineFunctionObject("CL-YIELD-METHOD-PARAMETER-TYPE-DECLARATION-TREES", "(DEFUN (CL-YIELD-METHOD-PARAMETER-TYPE-DECLARATION-TREES CONS) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "clYieldMethodParameterTypeDeclarationTrees", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("CL-YIELD-LET-VARIABLE-TYPE-DECLARATION-TREES", "(DEFUN (CL-YIELD-LET-VARIABLE-TYPE-DECLARATION-TREES CONS) ((BINDINGSTREE (CONS OF CONS))))", Native.find_java_method("edu.isi.stella.Cons", "clYieldLetVariableTypeDeclarationTrees", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CL-YIELD-GLOBAL-VARIABLE-TYPE-DECLARATION-TREE", "(DEFUN (CL-YIELD-GLOBAL-VARIABLE-TYPE-DECLARATION-TREE CONS) ((GLOBAL GLOBAL-VARIABLE)))", Native.find_java_method("edu.isi.stella.GlobalVariable", "clYieldGlobalVariableTypeDeclarationTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GlobalVariable")}), null);
          Stella.defineFunctionObject("CL-YIELD-METHOD-ARGLIST-TYPE-DECLARATIONS", "(DEFUN (CL-YIELD-METHOD-ARGLIST-TYPE-DECLARATIONS CONS) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "clYieldMethodArglistTypeDeclarations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("CL-YIELD-METHOD-RETURN-TYPE-DECLARATION", "(DEFUN (CL-YIELD-METHOD-RETURN-TYPE-DECLARATION OBJECT) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "clYieldMethodReturnTypeDeclaration", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("CL-YIELD-METHOD-TYPE-DECLARATION-TREE", "(DEFUN (CL-YIELD-METHOD-TYPE-DECLARATION-TREE CONS) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "clYieldMethodTypeDeclarationTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("CL-YIELD-DECLARE-TREE", "(DEFUN (CL-YIELD-DECLARE-TREE CONS) ((DECLARATIONS (CONS OF CONS)) (INCLUDE-TYPE-CHECKS? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Cons", "clYieldDeclareTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("CL-CONDITIONALIZE-TYPE-DECLARATION-TREE", "(DEFUN (CL-CONDITIONALIZE-TYPE-DECLARATION-TREE OBJECT) ((DECLARATION OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "clConditionalizeTypeDeclarationTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CL-TRANSLATE-UNIT", "(DEFUN (CL-TRANSLATE-UNIT OBJECT) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "clTranslateUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
          Stella.defineFunctionObject("CL-TRANSLATE-METHOD-PARAMETERS", "(DEFUN (CL-TRANSLATE-METHOD-PARAMETERS CONS) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "clTranslateMethodParameters", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("CL-METHOD-DEFINITION-OPERATOR", "(DEFUN (CL-METHOD-DEFINITION-OPERATOR SYMBOL) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "clMethodDefinitionOperator", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("CL-TRANSLATE-DEFINE-METHOD-UNIT", "(DEFUN (CL-TRANSLATE-DEFINE-METHOD-UNIT CONS) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "clTranslateDefineMethodUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
          Stella.defineFunctionObject("YIELD-CLOS-SLOT-TYPE-TREE", "(DEFUN (YIELD-CLOS-SLOT-TYPE-TREE CONS) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldClosSlotTypeTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
          Stella.defineFunctionObject("YIELD-CLOS-SLOT-TREE", "(DEFUN (YIELD-CLOS-SLOT-TREE CONS) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldClosSlotTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
          Stella.defineFunctionObject("YIELD-CLOS-CLASS-TREE", "(DEFUN (YIELD-CLOS-CLASS-TREE CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldClosClassTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("COMPUTE-CL-STRUCT-SLOTS", "(DEFUN (COMPUTE-CL-STRUCT-SLOTS (LIST OF STORAGE-SLOT)) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "computeClStructSlots", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("CL-STRUCT-SLOTS", "(DEFUN (CL-STRUCT-SLOTS (LIST OF STORAGE-SLOT)) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "clStructSlots", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("CL-STRUCT-SLOT-OFFSET", "(DEFUN (CL-STRUCT-SLOT-OFFSET INTEGER) ((SLOTNAME SYMBOL) (CLASSTYPE TYPE)))", Native.find_java_method("edu.isi.stella.Symbol", "clStructSlotOffset", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("YIELD-STRUCT-SLOT-TREE", "(DEFUN (YIELD-STRUCT-SLOT-TREE CONS) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldStructSlotTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
          Stella.defineFunctionObject("YIELD-STRUCT-SLOT-TREES", "(DEFUN (YIELD-STRUCT-SLOT-TREES CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldStructSlotTrees", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("YIELD-STRUCT-TREE", "(DEFUN (YIELD-STRUCT-TREE CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldStructTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("YIELD-VECTOR-STRUCT-NAME", "(DEFUN (YIELD-VECTOR-STRUCT-NAME OBJECT) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldVectorStructName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("YIELD-VECTOR-STRUCT-TREE", "(DEFUN (YIELD-VECTOR-STRUCT-TREE CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldVectorStructTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("YIELD-CONDITION-TREE", "(DEFUN (YIELD-CONDITION-TREE CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldConditionTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("CL-ALWAYS-TRANSLATE-TO-CLOS-CLASS?", "(DEFUN (CL-ALWAYS-TRANSLATE-TO-CLOS-CLASS? BOOLEAN) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "clAlwaysTranslateToClosClassP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("CL-TRANSLATE-DEFINE-NATIVE-CLASS-UNIT", "(DEFUN (CL-TRANSLATE-DEFINE-NATIVE-CLASS-UNIT CONS) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "clTranslateDefineNativeClassUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
          Stella.defineFunctionObject("CL-TRANSLATE-DEFINE-GLOBAL-VARIABLE-UNIT", "(DEFUN (CL-TRANSLATE-DEFINE-GLOBAL-VARIABLE-UNIT CONS) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "clTranslateDefineGlobalVariableUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
          Stella.defineFunctionObject("CL-TRANSLATE-DEFPRINT-UNIT", "(DEFUN (CL-TRANSLATE-DEFPRINT-UNIT CONS) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "clTranslateDefprintUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
          Stella.defineFunctionObject("STARTUP-CL-TRANSLATE", "(DEFUN STARTUP-CL-TRANSLATE () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupClTranslate", "startupClTranslate", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_CL_TRANSLATE);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupClTranslate"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CL-TRUE-STRING-WRAPPER* VERBATIM-STRING-WRAPPER (NEW VERBATIM-STRING-WRAPPER :WRAPPER-VALUE \"CL:T\"))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CL-FALSE-STRING-WRAPPER* VERBATIM-STRING-WRAPPER (NEW VERBATIM-STRING-WRAPPER :WRAPPER-VALUE \"CL:NIL\"))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CL-OPERATOR-TABLE* KEY-VALUE-LIST NULL :DOCUMENTATION \"Mapping from STELLA operators to Common-Lisp operators.\")");
          Stella.$CL_OPERATOR_TABLE$ = ((KeyValueList)(AbstractDictionary.dictionary(Stella.SGT_STELLA_KEY_VALUE_LIST, Cons.cons(Stella.SYM_STELLA_i, Cons.cons(Stella.internCommonLispSymbol("+"), Cons.cons(Stella.SYM_STELLA__, Cons.cons(Stella.internCommonLispSymbol("-"), Cons.cons(Stella.SYM_STELLA_$, Cons.cons(Stella.internCommonLispSymbol("*"), Cons.cons(Stella.SYM_STELLA_s, Cons.cons(Stella.internCommonLispSymbol("/"), Cons.cons(Stella.SYM_STELLA_EQp, Cons.cons(Stella.internCommonLispSymbol("EQL"), Cons.cons(Stella.SYM_STELLA_l, Cons.cons(Stella.internCommonLispSymbol("<"), Cons.cons(Stella.SYM_STELLA_le, Cons.cons(Stella.internCommonLispSymbol("<="), Cons.cons(Stella.SYM_STELLA_ge, Cons.cons(Stella.internCommonLispSymbol(">="), Cons.cons(Stella.SYM_STELLA_g, Cons.cons(Stella.internCommonLispSymbol(">"), Cons.cons(Stella.SYM_STELLA_e, Cons.cons(Stella.internCommonLispSymbol("="), Cons.cons(Stella.SYM_STELLA_xe, Cons.cons(Stella.internCommonLispSymbol("/="), Stella.NIL)))))))))))))))))))))))));
          { boolean usestructsP = false;
            boolean usevectorstructsP = false;
            boolean useclconsesP = false;

            if (usestructsP) {
              Stella.setStellaFeature(Cons.cons(Stella.KWD_USE_COMMON_LISP_STRUCTS, Stella.NIL));
            }
            if (usevectorstructsP) {
              Stella.setStellaFeature(Cons.cons(Stella.KWD_USE_COMMON_LISP_VECTOR_STRUCTS, Stella.NIL));
            }
            if (useclconsesP) {
              Stella.setStellaFeature(Cons.cons(Stella.KWD_USE_COMMON_LISP_CONSES, Stella.NIL));
            }
          }
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *NEEDEXPLICITRETURN?* BOOLEAN FALSE)");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
