//  -*- Mode: Java -*-
//
// _StartupJavaTranslate.java

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

public class _StartupJavaTranslate {
  static void helpStartupJavaTranslate1() {
    {
      Stella.SYM_STELLA_JAVA_GLOBAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_GLOBAL", null, 0)));
      Stella.SYM_STELLA_JAVA_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_TYPE", null, 0)));
      Stella.SYM_STELLA_JAVA_MAKE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_MAKE", null, 0)));
      Stella.SYM_STELLA_JAVA_IDENT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_IDENT", null, 0)));
      Stella.SYM_STELLA_JAVA_ACTUALS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_ACTUALS", null, 0)));
      Stella.SYM_STELLA_JAVA_STATEMENTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_STATEMENTS", null, 0)));
      Stella.SYM_STELLA_JAVA_BLOCK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_BLOCK", null, 0)));
      Stella.SYM_STELLA_JAVA_COMMENT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_COMMENT", null, 0)));
      Stella.SYM_STELLA_JAVA_FUNCTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_FUNCTION", null, 0)));
      Stella.SYM_STELLA_JAVA_METHOD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_METHOD", null, 0)));
      Stella.SGT_STELLA_THIRY_TWO_BIT_VECTOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("THIRY-TWO-BIT-VECTOR", null, 1)));
      Stella.SGT_STELLA_DOUBLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DOUBLE", null, 1)));
      Stella.SYM_STELLA_ABSTRACT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ABSTRACT", null, 0)));
      Stella.SYM_STELLA_BYTE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BYTE", null, 0)));
      Stella.SYM_STELLA_EXTENDS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EXTENDS", null, 0)));
      Stella.SYM_STELLA_FINAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FINAL", null, 0)));
      Stella.SYM_STELLA_FINALLY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FINALLY", null, 0)));
      Stella.SYM_STELLA_IMPLEMENTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IMPLEMENTS", null, 0)));
      Stella.SYM_STELLA_IMPORT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IMPORT", null, 0)));
      Stella.SYM_STELLA_INSTANCEOF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INSTANCEOF", null, 0)));
      Stella.SYM_STELLA_INTERFACE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INTERFACE", null, 0)));
      Stella.SYM_STELLA_NATIVE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NATIVE", null, 0)));
      Stella.SYM_STELLA_PACKAGE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PACKAGE", null, 0)));
      Stella.SYM_STELLA_SUPER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SUPER", null, 0)));
      Stella.SYM_STELLA_SYNCHRONIZED = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SYNCHRONIZED", null, 0)));
      Stella.SYM_STELLA_THROWS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("THROWS", null, 0)));
      Stella.SYM_STELLA_TRANSIENT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TRANSIENT", null, 0)));
      Stella.SYM_STELLA_JAVA_METHOD_CALL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_METHOD_CALL", null, 0)));
      Stella.SYM_STELLA_JAVA_UNWIND_PROTECT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_UNWIND_PROTECT", null, 0)));
      Stella.SYM_STELLA_JAVA_VERBATIM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_VERBATIM", null, 0)));
      Stella.SYM_STELLA_JAVA_SIGNAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_SIGNAL", null, 0)));
      Stella.SYM_STELLA_FILL_IN_STACK_TRACE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FILL-IN-STACK-TRACE", null, 0)));
      Stella.SYM_STELLA_JAVA_HANDLER_CASE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_HANDLER_CASE", null, 0)));
      Stella.SYM_STELLA_JAVA_CATCH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_CATCH", null, 0)));
      Stella.SYM_STELLA_JAVA_FUNCTION_CALL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_FUNCTION_CALL", null, 0)));
      Stella.SYM_STELLA_JAVA_ASSIGN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_ASSIGN", null, 0)));
      Stella.SYM_STELLA_JAVA_SLOT_VALUE_SETTER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_SLOT_VALUE_SETTER", null, 0)));
      Stella.SYM_STELLA_JAVA_SLOT_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_SLOT_VALUE", null, 0)));
      Stella.SYM_STELLA_JAVA_PROGN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_PROGN", null, 0)));
      Stella.SYM_STELLA_JAVA_WITH_PROCESS_LOCK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_WITH_PROCESS_LOCK", null, 0)));
      Stella.SYM_STELLA_JAVA_NAMED_STATEMENT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_NAMED_STATEMENT", null, 0)));
      Stella.SYM_STELLA_JAVA_LOOP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_LOOP", null, 0)));
      Stella.SYM_STELLA_JAVA_FOREACH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_FOREACH", null, 0)));
      Stella.SYM_STELLA_JAVA_CAST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_CAST", null, 0)));
      Stella.SYM_STELLA_JAVA_AREF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_AREF", null, 0)));
      Stella.SYM_STELLA_MV_returnarray = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MV_returnarray", null, 0)));
      Stella.SYM_STELLA_JAVA_RETURN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_RETURN", null, 0)));
      Stella.SYM_STELLA_JAVA_BREAK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_BREAK", null, 0)));
      Stella.SYM_STELLA_JAVA_CONTINUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_CONTINUE", null, 0)));
      Stella.SYM_STELLA_JAVA_IF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_IF", null, 0)));
      Stella.SYM_STELLA_JAVA_CASE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_CASE", null, 0)));
      Stella.SYM_STELLA_JAVA_COND = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_COND", null, 0)));
      Stella.SYM_STELLA_JAVA_WHILE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_WHILE", null, 0)));
      Stella.SYM_STELLA_JAVA_WHEN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_WHEN", null, 0)));
      Stella.SYM_STELLA_JAVA_UNLESS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_UNLESS", null, 0)));
      Stella.SYM_STELLA_JAVA_MAKE_ARRAY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_MAKE_ARRAY", null, 0)));
      Stella.SGT_STELLA_NATIVE_OBJECT_POINTER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("NATIVE-OBJECT-POINTER", null, 1)));
      Stella.SYM_STELLA_caller_MV_returnarray = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("caller_MV_returnarray", null, 0)));
      Stella.SYM_STELLA_JAVA_FUNCTION_SIGNATURE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_FUNCTION_SIGNATURE", null, 0)));
      Stella.SYM_STELLA_JAVA_FUNCALL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_FUNCALL", null, 0)));
    }
  }

  static void helpStartupJavaTranslate2() {
    {
      Stella.SYM_STELLA_JAVA_METHOD_CODE_CALL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_METHOD_CODE_CALL", null, 0)));
      Stella.SGT_STELLA_THIRTY_TWO_BIT_VECTOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("THIRTY-TWO-BIT-VECTOR", null, 1)));
      Stella.SGT_STELLA_TICKTOCK = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TICKTOCK", null, 1)));
      Stella.SGT_STELLA_NATIVE_DATE_TIME = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("NATIVE-DATE-TIME", null, 1)));
      Stella.SYM_STELLA_JAVA_ANONYMOUS_ARRAY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_ANONYMOUS_ARRAY", null, 0)));
      Stella.SYM_STELLA_JAVA_PRINT_STREAM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_PRINT_STREAM", null, 0)));
      Stella.SYM_STELLA_JAVA_STANDARD_ERROR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_STANDARD_ERROR", null, 0)));
      Stella.SYM_STELLA_JAVA_STANDARD_OUT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_STANDARD_OUT", null, 0)));
      Stella.SYM_STELLA_JAVA_LITERAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_LITERAL", null, 0)));
      Stella.SYM_STELLA_JAVA_PRINT_NATIVE_STREAM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_PRINT_NATIVE_STREAM", null, 0)));
      Stella.SYM_STELLA_JAVA_EOL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_EOL", null, 0)));
      Stella.SYM_STELLA_JAVA_SYMBOL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_SYMBOL", null, 0)));
      Stella.SYM_STELLA_JAVA_UNARY_OP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_UNARY_OP", null, 0)));
      Stella.SYM_STELLA_JAVA_BINARY_OP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_BINARY_OP", null, 0)));
      Stella.SYM_STELLA_JAVA_TERNARY_OP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_TERNARY_OP", null, 0)));
      Stella.SYM_STELLA_STARTUP_JAVA_TRANSLATE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-JAVA-TRANSLATE", null, 0)));
    }
  }

  static void helpStartupJavaTranslate3() {
    {
      Stella.$JAVA_TRUE_STRING_WRAPPER$ = StringWrapper.wrapString("true");
      Stella.$JAVA_FALSE_STRING_WRAPPER$ = StringWrapper.wrapString("false");
      Stella.$VARARGSTATEMENTS$.setDefaultValue(Stella.NIL);
      Stella.$VARARGDECLS$.setDefaultValue(Stella.NIL);
      Stella.$CURRENTVARARGINDEX$.setDefaultValue(new Integer(1));
      Stella.$JAVA_OPERATOR_TABLE$ = ((KeyValueList)(AbstractDictionary.dictionary(Stella.SGT_STELLA_KEY_VALUE_LIST, Cons.cons(Stella.SYM_STELLA_ii, Cons.cons(Cons.cons(StringWrapper.wrapString("++"), Stella.NIL), Cons.cons(Stella.SYM_STELLA___, Cons.cons(Cons.cons(StringWrapper.wrapString("--"), Stella.NIL), Cons.cons(Stella.SYM_STELLA_i, Cons.cons(Cons.cons(StringWrapper.wrapString("+"), Stella.NIL), Cons.cons(Stella.SYM_STELLA__, Cons.cons(Cons.cons(StringWrapper.wrapString("-"), Stella.NIL), Cons.cons(Stella.SYM_STELLA_$, Cons.cons(Cons.cons(StringWrapper.wrapString("*"), Stella.NIL), Cons.cons(Stella.SYM_STELLA_s, Cons.cons(Cons.cons(StringWrapper.wrapString("/"), Stella.NIL), Cons.cons(Stella.SYM_STELLA_EQp, Cons.cons(Cons.cons(StringWrapper.wrapString("=="), Stella.NIL), Cons.cons(Stella.SYM_STELLA_g, Cons.cons(Cons.cons(StringWrapper.wrapString(">"), Stella.NIL), Cons.cons(Stella.SYM_STELLA_ge, Cons.cons(Cons.cons(StringWrapper.wrapString(">="), Stella.NIL), Cons.cons(Stella.SYM_STELLA_eg, Cons.cons(Cons.cons(StringWrapper.wrapString(">="), Stella.NIL), Cons.cons(Stella.SYM_STELLA_l, Cons.cons(Cons.cons(StringWrapper.wrapString("<"), Stella.NIL), Cons.cons(Stella.SYM_STELLA_el, Cons.cons(Cons.cons(StringWrapper.wrapString("<="), Stella.NIL), Cons.cons(Stella.SYM_STELLA_le, Cons.cons(Cons.cons(StringWrapper.wrapString("<="), Stella.NIL), Cons.cons(Stella.SYM_STELLA_AND, Cons.cons(Cons.cons(StringWrapper.wrapString("&&"), Stella.NIL), Cons.cons(Stella.SYM_STELLA_OR, Cons.cons(Cons.cons(StringWrapper.wrapString("||"), Stella.NIL), Cons.cons(Stella.SYM_STELLA_NOT, Cons.cons(Cons.cons(StringWrapper.wrapString("!"), Stella.NIL), Cons.cons(Stella.SYM_STELLA_CHOOSE, Cons.cons(Cons.cons(StringWrapper.wrapString("?"), Cons.cons(StringWrapper.wrapString(":"), Stella.NIL)), Stella.NIL)))))))))))))))))))))))))))))))))))));
      Stella.$JAVA_CHARACTER_SUBSTITUTION_TABLE$ = Stella.javaCreateCharacterSubstitutionTable();
      Stella.$JAVA_RESERVED_WORD_TABLE$ = Stella.javaCreateReservedWordTable();
      Stella.$JAVA_LOOP_NAME$.setDefaultValue(null);
      Stella.$JAVA_LOOP_NAME_USEDp$.setDefaultValue(new Boolean(false));
      Stella.$JAVA_PRIMITIVE_ARRAY_TYPE_NAMES$ = ((KeyValueList)(AbstractDictionary.dictionary(Stella.SGT_STELLA_KEY_VALUE_LIST, Cons.cons(StringWrapper.wrapString("byte"), Cons.cons(StringWrapper.wrapString("B"), Cons.cons(StringWrapper.wrapString("char"), Cons.cons(StringWrapper.wrapString("C"), Cons.cons(StringWrapper.wrapString("double"), Cons.cons(StringWrapper.wrapString("D"), Cons.cons(StringWrapper.wrapString("float"), Cons.cons(StringWrapper.wrapString("F"), Cons.cons(StringWrapper.wrapString("int"), Cons.cons(StringWrapper.wrapString("I"), Cons.cons(StringWrapper.wrapString("long"), Cons.cons(StringWrapper.wrapString("J"), Cons.cons(StringWrapper.wrapString("short"), Cons.cons(StringWrapper.wrapString("S"), Cons.cons(StringWrapper.wrapString("boolean"), Cons.cons(StringWrapper.wrapString("Z"), Stella.NIL)))))))))))))))))));
    }
  }

  static void helpStartupJavaTranslate4() {
    {
      Stella.defineFunctionObject("JAVA-YIELD-FLOTSAM-CLASS-NAME", "(DEFUN (JAVA-YIELD-FLOTSAM-CLASS-NAME STRING) ((MOD MODULE)))", Native.find_java_method("edu.isi.stella.Module", "javaYieldFlotsamClassName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("JAVA-YIELD-NATIVE-CLASS-NAME", "(DEFUN (JAVA-YIELD-NATIVE-CLASS-NAME STRING) ())", Native.find_java_method("edu.isi.stella.Stella", "javaYieldNativeClassName", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("JAVA-YIELD-SPECIAL-VARIABLE-CLASS-NAME", "(DEFUN (JAVA-YIELD-SPECIAL-VARIABLE-CLASS-NAME STRING) ())", Native.find_java_method("edu.isi.stella.Stella", "javaYieldSpecialVariableClassName", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("JAVA-YIELD-FULL-NATIVE-CLASS-NAME", "(DEFUN (JAVA-YIELD-FULL-NATIVE-CLASS-NAME STRING) ())", Native.find_java_method("edu.isi.stella.Stella", "javaYieldFullNativeClassName", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-UNIT", "(DEFUN (JAVA-TRANSLATE-UNIT CONS) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "javaTranslateUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-DEFINE-GLOBAL-VARIABLE-UNIT", "(DEFUN (JAVA-TRANSLATE-DEFINE-GLOBAL-VARIABLE-UNIT CONS) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "javaTranslateDefineGlobalVariableUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
      Stella.defineFunctionObject("WRAP-METHOD-BODY-WITH-JAVA-AUXILIARY-DECLARATIONS", "(DEFUN (WRAP-METHOD-BODY-WITH-JAVA-AUXILIARY-DECLARATIONS CONS) ((METHODBODY CONS) (DECLARATIONS CONS)))", Native.find_java_method("edu.isi.stella.Cons", "wrapMethodBodyWithJavaAuxiliaryDeclarations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-SYNCHRONIZED-METHOD?", "(DEFUN (JAVA-SYNCHRONIZED-METHOD? BOOLEAN) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "javaSynchronizedMethodP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-METHOD-SIGNATURE", "(DEFUN (JAVA-TRANSLATE-METHOD-SIGNATURE CONS) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "javaTranslateMethodSignature", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-DEFINE-METHOD-UNIT", "(DEFUN (JAVA-TRANSLATE-DEFINE-METHOD-UNIT CONS) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "javaTranslateDefineMethodUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-DEFPRINT-UNIT", "(DEFUN (JAVA-TRANSLATE-DEFPRINT-UNIT CONS) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "javaTranslateDefprintUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-LIST-OF-TREES", "(DEFUN (JAVA-TRANSLATE-LIST-OF-TREES CONS) ((TREES CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateListOfTrees", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-A-TREE", "(DEFUN (JAVA-TRANSLATE-A-TREE OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "javaTranslateATree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("JAVA-LOOKUP-OPERATOR-TABLE", "(DEFUN (JAVA-LOOKUP-OPERATOR-TABLE CONS) ((OPERATOR SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "javaLookupOperatorTable", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("JAVA-CREATE-CHARACTER-SUBSTITUTION-TABLE", "(DEFUN (JAVA-CREATE-CHARACTER-SUBSTITUTION-TABLE STRING) ())", Native.find_java_method("edu.isi.stella.Stella", "javaCreateCharacterSubstitutionTable", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("JAVA-SUBSTITUTE-FORBIDDEN-CHARACTERS", "(DEFUN (JAVA-SUBSTITUTE-FORBIDDEN-CHARACTERS STRING) ((NAME STRING) (CASECONVENTION KEYWORD)))", Native.find_java_method("edu.isi.stella.Stella", "javaSubstituteForbiddenCharacters", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("JAVA-CHANGE-CASE", "(DEFUN (JAVA-CHANGE-CASE STRING) ((SYMBOL GENERALIZED-SYMBOL) (CASECONVENTION KEYWORD)))", Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "javaChangeCase", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("JAVA-LITERAL?", "(DEFUN (JAVA-LITERAL? BOOLEAN) ((TYPESPEC TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.StandardObject", "javaLiteralP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("JAVA-NATIVE-LITERAL-WRAPPER-NAMES", "(DEFUN (JAVA-NATIVE-LITERAL-WRAPPER-NAMES STRING-WRAPPER STRING-WRAPPER) ((TYPESPEC TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.StandardObject", "javaNativeLiteralWrapperNames", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("JAVA-SPECIAL-SETTER-NAME", "(DEFUN (JAVA-SPECIAL-SETTER-NAME STRING-WRAPPER) ((TYPESPEC TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.StandardObject", "javaSpecialSetterName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("JAVA-YIELD-FLOTSAM-TYPE-NAME", "(DEFUN (JAVA-YIELD-FLOTSAM-TYPE-NAME STRING) ((FLOTSAM-CLASS-NAME STRING)))", Native.find_java_method("edu.isi.stella.Stella", "javaYieldFlotsamTypeName", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-SYMBOL-CONSTANT-NAME", "(DEFUN (JAVA-TRANSLATE-SYMBOL-CONSTANT-NAME STRING-WRAPPER) ((SYMBOL GENERALIZED-SYMBOL)))", Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "javaTranslateSymbolConstantName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-SYMBOL-CONSTANT-ID", "(DEFUN (JAVA-TRANSLATE-SYMBOL-CONSTANT-ID STRING-WRAPPER) ((SYMBOL GENERALIZED-SYMBOL)))", Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "javaTranslateSymbolConstantId", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-SYMBOL-NAME", "(DEFUN (JAVA-TRANSLATE-SYMBOL-NAME STRING-WRAPPER) ((SYMBOL SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "javaTranslateSymbolName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-SYMBOL-ID", "(DEFUN (JAVA-TRANSLATE-SYMBOL-ID STRING-WRAPPER) ((SYMBOL SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "javaTranslateSymbolId", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-SURROGATE-NAME", "(DEFUN (JAVA-TRANSLATE-SURROGATE-NAME STRING-WRAPPER) ((SURROGATE SURROGATE)))", Native.find_java_method("edu.isi.stella.Surrogate", "javaTranslateSurrogateName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-SURROGATE-ID", "(DEFUN (JAVA-TRANSLATE-SURROGATE-ID STRING-WRAPPER) ((SURROGATE SURROGATE)))", Native.find_java_method("edu.isi.stella.Surrogate", "javaTranslateSurrogateId", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-KEYWORD-NAME", "(DEFUN (JAVA-TRANSLATE-KEYWORD-NAME STRING-WRAPPER) ((KEYWORD KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "javaTranslateKeywordName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-KEYWORD-ID", "(DEFUN (JAVA-TRANSLATE-KEYWORD-ID STRING-WRAPPER) ((KEYWORD KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "javaTranslateKeywordId", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-CLASS-NAMESTRING", "(DEFUN (JAVA-TRANSLATE-CLASS-NAMESTRING STRING-WRAPPER) ((NAMESTRING STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.StringWrapper", "javaTranslateClassNamestring", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-CLASS-NAME", "(DEFUN (JAVA-TRANSLATE-CLASS-NAME STRING-WRAPPER) ((NAMESYMBOL GENERALIZED-SYMBOL)))", Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "javaTranslateClassName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol")}), null);
      Stella.defineFunctionObject("IN-CURRENT-JAVA-PACKAGE?", "(DEFUN (IN-CURRENT-JAVA-PACKAGE? BOOLEAN) ((MODULE MODULE)))", Native.find_java_method("edu.isi.stella.Module", "inCurrentJavaPackageP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("INHERITED-CLASS-NAME-CONFLICTS?", "(DEFUN (INHERITED-CLASS-NAME-CONFLICTS? BOOLEAN) ((STELLA-CLASS-NAME STRING)))", Native.find_java_method("edu.isi.stella.Stella", "inheritedClassNameConflictsP", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("CLASS-NAME-CONFLICTS-WITH-SLOT-NAME?", "(DEFUN (CLASS-NAME-CONFLICTS-WITH-SLOT-NAME? BOOLEAN) ((DEFINING-CLASS CLASS) (JAVA-CLASS-NAME STRING)))", Native.find_java_method("edu.isi.stella.Stella_Class", "classNameConflictsWithSlotNameP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("OMIT-JAVA-PACKAGE-PREFIX?", "(DEFUN (OMIT-JAVA-PACKAGE-PREFIX? BOOLEAN) ((MODULE MODULE) (STELLA-CLASS-NAME STRING)))", Native.find_java_method("edu.isi.stella.Module", "omitJavaPackagePrefixP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-TYPE-SPEC", "(DEFUN (JAVA-TRANSLATE-TYPE-SPEC STRING-WRAPPER) ((TYPE-SPEC TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.StandardObject", "javaTranslateTypeSpec", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-TYPE-SPEC-FOR-FUNCTION", "(DEFUN (JAVA-TRANSLATE-TYPE-SPEC-FOR-FUNCTION STRING-WRAPPER) ((TYPE-SPEC TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.StandardObject", "javaTranslateTypeSpecForFunction", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-TYPE-SPEC-HELPER", "(DEFUN (JAVA-TRANSLATE-TYPE-SPEC-HELPER STRING-WRAPPER) ((TYPE-SPEC TYPE-SPEC) (FUNCTION? BOOLEAN)))", Native.find_java_method("edu.isi.stella.StandardObject", "javaTranslateTypeSpecHelper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-ARRAY-TYPE", "(DEFUN (JAVA-TRANSLATE-ARRAY-TYPE STRING-WRAPPER) ((ARRAYTYPE PARAMETRIC-TYPE-SPECIFIER)))", Native.find_java_method("edu.isi.stella.ParametricTypeSpecifier", "javaTranslateArrayType", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.ParametricTypeSpecifier")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-ARRAY-OF-TYPE-SPEC", "(DEFUN (JAVA-TRANSLATE-ARRAY-OF-TYPE-SPEC STRING-WRAPPER) ((TYPESPEC TYPE-SPEC) (FULLYQUALIFIED? BOOLEAN)))", Native.find_java_method("edu.isi.stella.StandardObject", "javaTranslateArrayOfTypeSpec", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("JAVA-YIELD-RENAMED-RESERVED-WORD", "(DEFUN (JAVA-YIELD-RENAMED-RESERVED-WORD STRING-WRAPPER) ((WORD SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "javaYieldRenamedReservedWord", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("JAVA-CREATE-RESERVED-WORD-TABLE", "(DEFUN (JAVA-CREATE-RESERVED-WORD-TABLE STRING-HASH-TABLE) ())", Native.find_java_method("edu.isi.stella.Stella", "javaCreateReservedWordTable", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("JAVA-LOOKUP-RESERVED-WORD-TABLE", "(DEFUN (JAVA-LOOKUP-RESERVED-WORD-TABLE STRING) ((WORD STRING)))", Native.find_java_method("edu.isi.stella.Stella", "javaLookupReservedWordTable", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-NAMESTRING", "(DEFUN (JAVA-TRANSLATE-NAMESTRING STRING) ((NAMESTRING STRING)))", Native.find_java_method("edu.isi.stella.Stella", "javaTranslateNamestring", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-NAME", "(DEFUN (JAVA-TRANSLATE-NAME STRING-WRAPPER) ((NAMESYMBOL SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "javaTranslateName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-SPECIAL-TREE", "(DEFUN (JAVA-TRANSLATE-SPECIAL-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateSpecialTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-VERBATIM-TREE", "(DEFUN (JAVA-TRANSLATE-VERBATIM-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateVerbatimTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-INLINE-CALL-TREE", "(DEFUN (JAVA-TRANSLATE-INLINE-CALL-TREE OBJECT) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateInlineCallTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-UNWIND-PROTECT", "(DEFUN (JAVA-TRANSLATE-UNWIND-PROTECT CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateUnwindProtect", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-SIGNAL", "(DEFUN (JAVA-TRANSLATE-SIGNAL CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateSignal", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-HANDLER-CASE", "(DEFUN (JAVA-TRANSLATE-HANDLER-CASE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateHandlerCase", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-HANDLE-EXCEPTION", "(DEFUN (JAVA-TRANSLATE-HANDLE-EXCEPTION CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateHandleException", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-VOID-SYS", "(DEFUN (JAVA-TRANSLATE-VOID-SYS CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateVoidSys", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-TYPED-SYS", "(DEFUN (JAVA-TRANSLATE-TYPED-SYS CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateTypedSys", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-BAD-SYS", "(DEFUN (JAVA-TRANSLATE-BAD-SYS OBJECT) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateBadSys", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-SETQ-TREE", "(DEFUN (JAVA-TRANSLATE-SETQ-TREE OBJECT) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateSetqTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-SYS-SET-DEFAULT", "(DEFUN (JAVA-TRANSLATE-SYS-SET-DEFAULT OBJECT) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateSysSetDefault", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-SYS-SLOT-VALUE-SETTER", "(DEFUN (JAVA-TRANSLATE-SYS-SLOT-VALUE-SETTER CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateSysSlotValueSetter", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-SYS-SLOT-VALUE", "(DEFUN (JAVA-TRANSLATE-SYS-SLOT-VALUE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateSysSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-PROGN", "(DEFUN (JAVA-TRANSLATE-PROGN CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateProgn", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
    }
  }

  static void helpStartupJavaTranslate5() {
    {
      Stella.defineFunctionObject("JAVA-TRANSLATE-WITH-PROCESS-LOCK", "(DEFUN (JAVA-TRANSLATE-WITH-PROCESS-LOCK CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateWithProcessLock", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-LOOP", "(DEFUN (JAVA-TRANSLATE-LOOP CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateLoop", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-FOREACH-TREE", "(DEFUN (JAVA-TRANSLATE-FOREACH-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateForeachTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-LET-TREE", "(DEFUN (JAVA-TRANSLATE-LET-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateLetTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-CAST", "(DEFUN (JAVA-TRANSLATE-CAST CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateCast", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-RETURN-TREE", "(DEFUN (JAVA-TRANSLATE-RETURN-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateReturnTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-BREAK", "(DEFUN (JAVA-TRANSLATE-BREAK CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateBreak", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-CONTINUE", "(DEFUN (JAVA-TRANSLATE-CONTINUE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateContinue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-IF-TREE", "(DEFUN (JAVA-TRANSLATE-IF-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateIfTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-SYMBOL-CASE?", "(DEFUN (JAVA-SYMBOL-CASE? BOOLEAN) ((KEYFORM OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "javaSymbolCaseP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("JAVA-YIELD-SYMBOL-ID-FORM", "(DEFUN (JAVA-YIELD-SYMBOL-ID-FORM CONS) ((SYMBOLID INTEGER)))", Native.find_java_method("edu.isi.stella.Stella", "javaYieldSymbolIdForm", new java.lang.Class [] {java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-CONDITION", "(DEFUN (JAVA-TRANSLATE-CONDITION CONS) ((CONDITION CONS) (SYMBOLCASEP BOOLEAN)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateCondition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-CASE-TREE", "(DEFUN (JAVA-TRANSLATE-CASE-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateCaseTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-COND-TREE", "(DEFUN (JAVA-TRANSLATE-COND-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateCondTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-WHILE", "(DEFUN (JAVA-TRANSLATE-WHILE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateWhile", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-CHOOSE-TREE", "(DEFUN (JAVA-TRANSLATE-CHOOSE-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateChooseTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-WHEN-TREE", "(DEFUN (JAVA-TRANSLATE-WHEN-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateWhenTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-UNLESS-TREE", "(DEFUN (JAVA-TRANSLATE-UNLESS-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateUnlessTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-MAKE-TREE", "(DEFUN (JAVA-TRANSLATE-MAKE-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateMakeTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-SYS-NEW", "(DEFUN (JAVA-TRANSLATE-SYS-NEW CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateSysNew", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-NEW-ARRAY", "(DEFUN (JAVA-TRANSLATE-NEW-ARRAY CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateNewArray", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-MV-SETQ", "(DEFUN (JAVA-TRANSLATE-MV-SETQ CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateMvSetq", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-MV-FUNCTION-CALL", "(DEFUN (JAVA-TRANSLATE-MV-FUNCTION-CALL CONS) ((FUNCTIONCALL CONS) (MVVECTORNAME SYMBOL)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateMvFunctionCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-CODE-SIGNATURE", "(DEFUN (JAVA-TRANSLATE-CODE-SIGNATURE CONS) ((SIGNATURE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateCodeSignature", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-WITH-NATIVE-WRAPPER", "(DEFUN (JAVA-TRANSLATE-WITH-NATIVE-WRAPPER CONS) ((TREE OBJECT) (TYPE TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.Stella_Object", "javaTranslateWithNativeWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-ACTUAL-PARAMETERS-WITH-NATIVE-WRAPPERS", "(DEFUN (JAVA-TRANSLATE-ACTUAL-PARAMETERS-WITH-NATIVE-WRAPPERS CONS) ((TREES CONS) (PARAMETERTYPES (CONS OF TYPE-SPEC))))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateActualParametersWithNativeWrappers", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-WRAP-WITH-NATIVE-VALUE-EXTRACTION", "(DEFUN (JAVA-WRAP-WITH-NATIVE-VALUE-EXTRACTION CONS) ((TREE CONS) (PRIMARYRETURNTYPE TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.Cons", "javaWrapWithNativeValueExtraction", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-OBJECT-TO-RETURN-TYPE", "(DEFUN (JAVA-TRANSLATE-OBJECT-TO-RETURN-TYPE CONS) ((TREE CONS) (RETURNTYPE TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateObjectToReturnType", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-CALL-FUNCTION-CODE", "(DEFUN (JAVA-TRANSLATE-CALL-FUNCTION-CODE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateCallFunctionCode", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-CALL-METHOD-CODE", "(DEFUN (JAVA-TRANSLATE-CALL-METHOD-CODE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateCallMethodCode", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-PACKAGE-PREFIX", "(DEFUN (JAVA-PACKAGE-PREFIX STRING) ((MODULE MODULE) (SEPARATOR STRING)))", Native.find_java_method("edu.isi.stella.Module", "javaPackagePrefix", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("JAVA-YIELD-FULLY-QUALIFIED-TYPE-NAME", "(DEFUN (JAVA-YIELD-FULLY-QUALIFIED-TYPE-NAME STRING-WRAPPER) ((TYPESPEC TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.StandardObject", "javaYieldFullyQualifiedTypeName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("JAVA-YIELD-TRANSLATED-CLASS-AND-FUNCTION-NAMES", "(DEFUN (JAVA-YIELD-TRANSLATED-CLASS-AND-FUNCTION-NAMES STRING-WRAPPER STRING-WRAPPER) ((F FUNCTION)))", Native.find_java_method("edu.isi.stella.MethodSlot", "javaYieldTranslatedClassAndFunctionNames", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("JAVA-YIELD-TRANSLATED-CLASS-AND-METHOD-NAMES", "(DEFUN (JAVA-YIELD-TRANSLATED-CLASS-AND-METHOD-NAMES STRING STRING) ((OWNER TYPE-SPEC) (F FUNCTION)))", Native.find_java_method("edu.isi.stella.StandardObject", "javaYieldTranslatedClassAndMethodNames", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("edu.isi.stella.MethodSlot"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-CLASS-OBJECT-LOOKUP", "(DEFUN (JAVA-TRANSLATE-CLASS-OBJECT-LOOKUP CONS) ((CLASSNAME STRING)))", Native.find_java_method("edu.isi.stella.Stella", "javaTranslateClassObjectLookup", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("JAVA-YIELD-CLASS-OBJECT-ARRAY-EXPRESSION", "(DEFUN (JAVA-YIELD-CLASS-OBJECT-ARRAY-EXPRESSION CONS) ((TYPESPEC TYPE-SPEC) (NDIMENSIONS INTEGER)))", Native.find_java_method("edu.isi.stella.StandardObject", "javaYieldClassObjectArrayExpression", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("JAVA-YIELD-CLASS-OBJECT-EXPRESSION", "(DEFUN (JAVA-YIELD-CLASS-OBJECT-EXPRESSION CONS) ((TYPESPEC TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.StandardObject", "javaYieldClassObjectExpression", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("YIELD-CLASS-OBJECT-LOOKUP-NAME-FOR-NATIVE-TYPE", "(DEFUN (YIELD-CLASS-OBJECT-LOOKUP-NAME-FOR-NATIVE-TYPE STRING) ((NATIVETYPE STRING)))", Native.find_java_method("edu.isi.stella.Stella", "yieldClassObjectLookupNameForNativeType", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-PARAM-TYPE-SPECIFICATIONS", "(DEFUN (JAVA-TRANSLATE-PARAM-TYPE-SPECIFICATIONS CONS) ((FN METHOD-SLOT) (OWNER TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.MethodSlot", "javaTranslateParamTypeSpecifications", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot"), Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-THE-CODE", "(DEFUN (JAVA-TRANSLATE-THE-CODE OBJECT) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateTheCode", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-FUNCTION-NAME", "(DEFUN (JAVA-TRANSLATE-FUNCTION-NAME STRING-WRAPPER) ((FUNCTION METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "javaTranslateFunctionName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-IGNORE-TREE", "(DEFUN (JAVA-TRANSLATE-IGNORE-TREE OBJECT) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateIgnoreTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-STREAM-IS-STANDARD-OUTPUT?", "(DEFUN (JAVA-STREAM-IS-STANDARD-OUTPUT? BOOLEAN) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "javaStreamIsStandardOutputP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-PRINT-STREAM", "(DEFUN (JAVA-TRANSLATE-PRINT-STREAM CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslatePrintStream", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-PRINT-NATIVE-STREAM", "(DEFUN (JAVA-TRANSLATE-PRINT-NATIVE-STREAM CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslatePrintNativeStream", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-NULL", "(DEFUN (JAVA-TRANSLATE-NULL CONS) ())", Native.find_java_method("edu.isi.stella.Stella", "javaTranslateNull", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-EOL", "(DEFUN (JAVA-TRANSLATE-EOL CONS) ())", Native.find_java_method("edu.isi.stella.Stella", "javaTranslateEol", new java.lang.Class [] {}), null);
      Stella.defineMethodObject("(DEFMETHOD (JAVA-TRANSLATE-ATOMIC-TREE CONS) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "javaTranslateAtomicTree", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("JAVA-PREPEND-GLOBAL-CLASS-NAME", "(DEFUN (JAVA-PREPEND-GLOBAL-CLASS-NAME STRING) ((NAMESTRING STRING) (MODULE MODULE)))", Native.find_java_method("edu.isi.stella.Stella", "javaPrependGlobalClassName", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-GLOBAL-NAME", "(DEFUN (JAVA-TRANSLATE-GLOBAL-NAME STRING-WRAPPER) ((NAMESYMBOL SYMBOL) (DEFINITION? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Symbol", "javaTranslateGlobalName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-GENERAL-SYMBOL", "(DEFUN (JAVA-TRANSLATE-GENERAL-SYMBOL CONS) ((TREE SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "javaTranslateGeneralSymbol", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineMethodObject("(DEFMETHOD (JAVA-TRANSLATE-ATOMIC-TREE CONS) ((TREE SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "javaTranslateAtomicTree", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("JAVA-TRANSLATE-METHOD-PARAMETER", "(DEFUN (JAVA-TRANSLATE-METHOD-PARAMETER OBJECT) ((NAME SYMBOL) (TYPE TYPE-SPEC) (METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.Symbol", "javaTranslateMethodParameter", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-RETURN-PARAMETER", "(DEFUN (JAVA-TRANSLATE-RETURN-PARAMETER CONS) ())", Native.find_java_method("edu.isi.stella.Stella", "javaTranslateReturnParameter", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("JAVA-TRANSLATE-METHOD-PARAMETERS", "(DEFUN (JAVA-TRANSLATE-METHOD-PARAMETERS CONS) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "javaTranslateMethodParameters", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("ZERO-ARGUMENT-FUNCTION?", "(DEFUN (ZERO-ARGUMENT-FUNCTION? BOOLEAN) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "zeroArgumentFunctionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("JAVA-METHOD-OBJECT-DEFINED-ON-NATIVE-TYPE?", "(DEFUN (JAVA-METHOD-OBJECT-DEFINED-ON-NATIVE-TYPE? BOOLEAN) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "javaMethodObjectDefinedOnNativeTypeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("JAVA-METHOD-OBJECT-IS-OVERLOADED-FUNCTION?", "(DEFUN (JAVA-METHOD-OBJECT-IS-OVERLOADED-FUNCTION? BOOLEAN) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "javaMethodObjectIsOverloadedFunctionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("JAVA-METHOD-OBJECT-IS-FUNCTION?", "(DEFUN (JAVA-METHOD-OBJECT-IS-FUNCTION? BOOLEAN) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "javaMethodObjectIsFunctionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("JAVA-FUNCTION-IN-DIFFERENT-MODULE?", "(DEFUN (JAVA-FUNCTION-IN-DIFFERENT-MODULE? BOOLEAN) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "javaFunctionInDifferentModuleP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
    }
  }

  public static void startupJavaTranslate() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupJavaTranslate.helpStartupJavaTranslate1();
          _StartupJavaTranslate.helpStartupJavaTranslate2();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          _StartupJavaTranslate.helpStartupJavaTranslate3();
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupJavaTranslate.helpStartupJavaTranslate4();
          _StartupJavaTranslate.helpStartupJavaTranslate5();
          Stella.defineFunctionObject("JAVA-CREATE-OVERLOADED-FUNCTION-NAME", "(DEFUN (JAVA-CREATE-OVERLOADED-FUNCTION-NAME SYMBOL) ((FUNCTIONNAME SYMBOL) (CLASSTYPE TYPE)))", Native.find_java_method("edu.isi.stella.Symbol", "javaCreateOverloadedFunctionName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineMethodObject("(DEFMETHOD (JAVA-TRANSLATE-METHOD-NAME STRING-WRAPPER) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "javaTranslateMethodName", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("JAVA-DELETE-QUOTED-NULL-STATEMENTS", "(DEFUN (JAVA-DELETE-QUOTED-NULL-STATEMENTS CONS) ((TREES CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaDeleteQuotedNullStatements", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-WRAP-METHOD-BODY-WITH-VARARG-DECLARATIONS", "(DEFUN (JAVA-WRAP-METHOD-BODY-WITH-VARARG-DECLARATIONS CONS) ((METHODBODY CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaWrapMethodBodyWithVarargDeclarations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-WRAP-METHOD-BODY-WITH-VARARG-VALUE-SETUP", "(DEFUN (JAVA-WRAP-METHOD-BODY-WITH-VARARG-VALUE-SETUP CONS) ((METHODBODY CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaWrapMethodBodyWithVarargValueSetup", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-TRANSLATE-VARIABLE-LENGTH-ARG-NAME", "(DEFUN (JAVA-TRANSLATE-VARIABLE-LENGTH-ARG-NAME STRING-WRAPPER) ((NAMESYMBOL SYMBOL) (PARAMETERNUMBER INTEGER)))", Native.find_java_method("edu.isi.stella.Symbol", "javaTranslateVariableLengthArgName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("JAVA-TRANSLATE-VARIABLE-LENGTH-ACTUALS", "(DEFUN (JAVA-TRANSLATE-VARIABLE-LENGTH-ACTUALS CONS) ((ACTUALS CONS) (UNUSED-METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateVariableLengthActuals", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("JAVA-TRANSLATE-ACTUAL-PARAMETERS", "(DEFUN (JAVA-TRANSLATE-ACTUAL-PARAMETERS CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateActualParameters", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-YIELD-CLASS-NAME-FOR-FUNCTION", "(DEFUN (JAVA-YIELD-CLASS-NAME-FOR-FUNCTION STRING) ((FUNCTION METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "javaYieldClassNameForFunction", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("JAVA-TRANSLATE-FUNCTION-CALL", "(DEFUN (JAVA-TRANSLATE-FUNCTION-CALL CONS) ((TREE CONS) (METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateFunctionCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("JAVA-TRANSLATE-DEFINED-OR-NULL", "(DEFUN (JAVA-TRANSLATE-DEFINED-OR-NULL CONS) ((CLASSTYPE TYPE) (OBJECT OBJECT) (NULL? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Surrogate", "javaTranslateDefinedOrNull", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("JAVA-TRANSLATE-METHOD-CALL", "(DEFUN (JAVA-TRANSLATE-METHOD-CALL CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateMethodCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-TRANSLATE-NORMAL-METHOD-CALL", "(DEFUN (JAVA-TRANSLATE-NORMAL-METHOD-CALL CONS) ((METHODNAME SYMBOL) (CLASSTYPE TYPE) (ALLARGS CONS)))", Native.find_java_method("edu.isi.stella.Symbol", "javaTranslateNormalMethodCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-TRANSLATE-OPERATOR-TREE", "(DEFUN (JAVA-TRANSLATE-OPERATOR-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateOperatorTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-TRANSLATE-OPERATOR-CALL", "(DEFUN (JAVA-TRANSLATE-OPERATOR-CALL CONS) ((OPERATORNAMES CONS) (ARGUMENTS CONS) (ARITY INTEGER)))", Native.find_java_method("edu.isi.stella.Cons", "javaTranslateOperatorCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("JAVA-TRANSLATE-AREF-METHOD-CALL", "(DEFUN (JAVA-TRANSLATE-AREF-METHOD-CALL CONS) ((OPERATOR SYMBOL) (OWNER TYPE) (ARGUMENTS CONS)))", Native.find_java_method("edu.isi.stella.Symbol", "javaTranslateArefMethodCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-TRANSLATE-NTH-METHOD-CALL", "(DEFUN (JAVA-TRANSLATE-NTH-METHOD-CALL CONS) ((OPERATOR SYMBOL) (OWNER TYPE) (ARGUMENTS CONS)))", Native.find_java_method("edu.isi.stella.Symbol", "javaTranslateNthMethodCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("STARTUP-JAVA-TRANSLATE", "(DEFUN STARTUP-JAVA-TRANSLATE () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupJavaTranslate", "startupJavaTranslate", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_JAVA_TRANSLATE);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupJavaTranslate"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *JAVA-TRUE-STRING-WRAPPER* STRING-WRAPPER (WRAP-LITERAL \"true\") :PUBLIC? FALSE :DOCUMENTATION \"Wrapped true string, used to reduce consing.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *JAVA-FALSE-STRING-WRAPPER* STRING-WRAPPER (WRAP-LITERAL \"false\") :PUBLIC? FALSE :DOCUMENTATION \"Wrapped false string, used to reduce consing.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *VARARGSTATEMENTS* (CONS OF CONS) NIL :DOCUMENTATION \"A list of new vectors generated for variable-length argument \n             lists\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *VARARGDECLS* (CONS OF CONS) NIL :DOCUMENTATION \"A list of vector-pushes generated for variable-length argument \n             lists\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *CURRENTVARARGINDEX* INTEGER 1 :DOCUMENTATION \"The current index of the variable length arguments\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *JAVA-OPERATOR-TABLE* KEY-VALUE-LIST (DICTIONARY @KEY-VALUE-LIST (QUOTE ++) (CONS (WRAP-LITERAL \"++\") NIL) (QUOTE --) (CONS (WRAP-LITERAL \"--\") NIL) (QUOTE +) (CONS (WRAP-LITERAL \"+\") NIL) (QUOTE -) (CONS (WRAP-LITERAL \"-\") NIL) (QUOTE *) (CONS (WRAP-LITERAL \"*\") NIL) (QUOTE /) (CONS (WRAP-LITERAL \"/\") NIL) (QUOTE EQ?) (CONS (WRAP-LITERAL \"==\") NIL) (QUOTE >) (CONS (WRAP-LITERAL \">\") NIL) (QUOTE >=) (CONS (WRAP-LITERAL \">=\") NIL) (QUOTE =>) (CONS (WRAP-LITERAL \">=\") NIL) (QUOTE <) (CONS (WRAP-LITERAL \"<\") NIL) (QUOTE =<) (CONS (WRAP-LITERAL \"<=\") NIL) (QUOTE <=) (CONS (WRAP-LITERAL \"<=\") NIL) (QUOTE AND) (CONS (WRAP-LITERAL \"&&\") NIL) (QUOTE OR) (CONS (WRAP-LITERAL \"||\") NIL) (QUOTE NOT) (CONS (WRAP-LITERAL \"!\") NIL) (QUOTE CHOOSE) (CONS (WRAP-LITERAL \"?\") (CONS (WRAP-LITERAL \":\") NIL))) :DOCUMENTATION \"Mapping from STELLA operators to Java operators\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *JAVA-CHARACTER-SUBSTITUTION-TABLE* STRING (JAVA-CREATE-CHARACTER-SUBSTITUTION-TABLE))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *JAVA-RESERVED-WORD-TABLE* (STRING-HASH-TABLE OF STRING STRING-WRAPPER) (JAVA-CREATE-RESERVED-WORD-TABLE))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *JAVA-LOOP-NAME* SYMBOL NULL)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *JAVA-LOOP-NAME-USED?* BOOLEAN FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *JAVA-PRIMITIVE-ARRAY-TYPE-NAMES* KEY-VALUE-LIST (DICTIONARY @KEY-VALUE-LIST \"byte\" \"B\" \"char\" \"C\" \"double\" \"D\" \"float\" \"F\" \"int\" \"I\" \"long\" \"J\" \"short\" \"S\" \"boolean\" \"Z\"))");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
