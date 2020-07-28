//  -*- Mode: Java -*-
//
// _StartupCppTranslate.java

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

public class _StartupCppTranslate {
  static void helpStartupCppTranslate1() {
    {
      Stella.SYM_STELLA_eg = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("=>", null, 0)));
      Stella.SYM_STELLA_el = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("=<", null, 0)));
      Stella.SYM_STELLA_ASM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ASM", null, 0)));
      Stella.SYM_STELLA_ASSERT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ASSERT", null, 0)));
      Stella.SYM_STELLA_AUTO = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("AUTO", null, 0)));
      Stella.SYM_STELLA_CATCH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CATCH", null, 0)));
      Stella.SYM_STELLA_CHAR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CHAR", null, 0)));
      Stella.SYM_STELLA_CONST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CONST", null, 0)));
      Stella.SYM_STELLA_DEFAULT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFAULT", null, 0)));
      Stella.SYM_STELLA_DELETE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DELETE", null, 0)));
      Stella.SYM_STELLA_DOUBLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DOUBLE", null, 0)));
      Stella.SYM_STELLA_ELSE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ELSE", null, 0)));
      Stella.SYM_STELLA_ENUM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ENUM", null, 0)));
      Stella.SYM_STELLA_EXTERN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EXTERN", null, 0)));
      Stella.SYM_STELLA_FLOAT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FLOAT", null, 0)));
      Stella.SYM_STELLA_FOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FOR", null, 0)));
      Stella.SYM_STELLA_FRIEND = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FRIEND", null, 0)));
      Stella.SYM_STELLA_GOTO = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("GOTO", null, 0)));
      Stella.SYM_STELLA_INT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INT", null, 0)));
      Stella.SYM_STELLA_LONG = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LONG", null, 0)));
      Stella.SYM_STELLA_NAMESPACE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NAMESPACE", null, 0)));
      Stella.SYM_STELLA_OPERATOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OPERATOR", null, 0)));
      Stella.SYM_STELLA_PRIVATE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PRIVATE", null, 0)));
      Stella.SYM_STELLA_PROTECTED = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PROTECTED", null, 0)));
      Stella.SYM_STELLA_PUBLIC = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PUBLIC", null, 0)));
      Stella.SYM_STELLA_REGISTER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("REGISTER", null, 0)));
      Stella.SYM_STELLA_SHORT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SHORT", null, 0)));
      Stella.SYM_STELLA_SIGNED = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SIGNED", null, 0)));
      Stella.SYM_STELLA_SIZEOF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SIZEOF", null, 0)));
      Stella.SYM_STELLA_STATIC = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STATIC", null, 0)));
      Stella.SYM_STELLA_STRUCT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STRUCT", null, 0)));
      Stella.SYM_STELLA_SWITCH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SWITCH", null, 0)));
      Stella.SYM_STELLA_TEMPLATE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TEMPLATE", null, 0)));
      Stella.SYM_STELLA_THROW = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("THROW", null, 0)));
      Stella.SYM_STELLA_TRY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TRY", null, 0)));
      Stella.SYM_STELLA_TYPEDEF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TYPEDEF", null, 0)));
      Stella.SYM_STELLA_TYPEID = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TYPEID", null, 0)));
      Stella.SYM_STELLA_UNION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UNION", null, 0)));
      Stella.SYM_STELLA_UNSIGNED = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UNSIGNED", null, 0)));
      Stella.SYM_STELLA_VIRTUAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VIRTUAL", null, 0)));
      Stella.SYM_STELLA_VOID = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VOID", null, 0)));
      Stella.SYM_STELLA_VOLATILE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VOLATILE", null, 0)));
      Stella.SYM_STELLA_TYPENAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TYPENAME", null, 0)));
      Stella.SYM_STELLA_SYS_REFERENCED_SLOT_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SYS-REFERENCED-SLOT-VALUE", null, 0)));
      Stella.SYM_STELLA_SYS_REFERENCED_CALL_METHOD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SYS-REFERENCED-CALL-METHOD", null, 0)));
      Stella.SYM_STELLA_SYS_POINTER_TO_FUNCTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SYS-POINTER-TO-FUNCTION", null, 0)));
      Stella.SYM_STELLA_CPP_VERBATIM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_VERBATIM", null, 0)));
      Stella.SYM_STELLA_CPP_FUNCTION_CALL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_FUNCTION_CALL", null, 0)));
      Stella.SYM_STELLA_CPP_IDENT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_IDENT", null, 0)));
      Stella.SYM_STELLA_CPP_ACTUALS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_ACTUALS", null, 0)));
      Stella.SYM_STELLA_CPP_BLOCK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_BLOCK", null, 0)));
      Stella.SYM_STELLA_CPP_STATEMENTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_STATEMENTS", null, 0)));
      Stella.SYM_STELLA_CPP_COMMENT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_COMMENT", null, 0)));
      Stella.SYM_STELLA_CPP_PRINT_NATIVE_STREAM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_PRINT_NATIVE_STREAM", null, 0)));
      Stella.SYM_STELLA_CPP_RETURN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_RETURN", null, 0)));
      Stella.SYM_STELLA_CPP_SIGNAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_SIGNAL", null, 0)));
      Stella.SYM_STELLA_CPP_DEREFERENCE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_DEREFERENCE", null, 0)));
      Stella.SYM_STELLA_CPP_HANDLER_CASE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_HANDLER_CASE", null, 0)));
      Stella.SYM_STELLA_CPP_CATCH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_CATCH", null, 0)));
      Stella.SYM_STELLA_CPP_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_TYPE", null, 0)));
    }
  }

  static void helpStartupCppTranslate2() {
    {
      Stella.SYM_STELLA_CPP_LOCAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_LOCAL", null, 0)));
      Stella.SYM_STELLA_CPP_UNWIND_PROTECT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_UNWIND_PROTECT", null, 0)));
      Stella.SYM_STELLA_CPP_CAST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_CAST", null, 0)));
      Stella.SYM_STELLA_CPP_ASSIGN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_ASSIGN", null, 0)));
      Stella.SYM_STELLA_CPP_SPECIAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_SPECIAL", null, 0)));
      Stella.SYM_STELLA_CPP_GLOBAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_GLOBAL", null, 0)));
      Stella.SYM_STELLA_CPP_CASE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_CASE", null, 0)));
      Stella.SYM_STELLA_CPP_PROGN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_PROGN", null, 0)));
      Stella.SYM_STELLA_CPP_COND = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_COND", null, 0)));
      Stella.SYM_STELLA_CPP_LOOP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_LOOP", null, 0)));
      Stella.SYM_STELLA_CPP_WHILE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_WHILE", null, 0)));
      Stella.SYM_STELLA_CPP_WITH_PROCESS_LOCK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_WITH_PROCESS_LOCK", null, 0)));
      Stella.SYM_STELLA_CPP_BREAK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_BREAK", null, 0)));
      Stella.SYM_STELLA_CPP_CONTINUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_CONTINUE", null, 0)));
      Stella.SYM_STELLA_CPP_IF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_IF", null, 0)));
      Stella.SYM_STELLA_CPP_WHEN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_WHEN", null, 0)));
      Stella.SYM_STELLA_CPP_UNLESS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_UNLESS", null, 0)));
      Stella.SYM_STELLA_CPP_FOREACH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_FOREACH", null, 0)));
      Stella.SYM_STELLA_VA_START = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VA_START", null, 0)));
      Stella.SYM_STELLA_VA_END = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VA_END", null, 0)));
      Stella.SYM_STELLA_CPP_BINARY_OP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_BINARY_OP", null, 0)));
      Stella.SYM_STELLA_CPP_UNARY_OP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_UNARY_OP", null, 0)));
      Stella.SYM_STELLA_CPP_LITERAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_LITERAL", null, 0)));
      Stella.SYM_STELLA_VA_ARG = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VA_ARG", null, 0)));
      Stella.SYM_STELLA_CPP_FUNCTION_POINTER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_FUNCTION_POINTER", null, 0)));
      Stella.SYM_STELLA_CPP_METHOD_POINTER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_METHOD_POINTER", null, 0)));
      Stella.SGT_STELLA_BYTE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("BYTE", null, 1)));
      Stella.SGT_STELLA_OCTET = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("OCTET", null, 1)));
      Stella.SYM_STELLA_CPP_ARRAY_REFERENCE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_ARRAY_REFERENCE", null, 0)));
      Stella.SYM_STELLA_CPP_REFERENCED_SLOT_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_REFERENCED_SLOT_VALUE", null, 0)));
      Stella.SYM_STELLA_CPP_SLOT_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_SLOT_VALUE", null, 0)));
      Stella.SYM_STELLA_CPP_SLOT_VALUE_SETTER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_SLOT_VALUE_SETTER", null, 0)));
      Stella.SYM_STELLA_CPP_MAKE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_MAKE", null, 0)));
      Stella.SYM_STELLA_CPP_STARTUP_TIME_PROGN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_STARTUP_TIME_PROGN", null, 0)));
      Stella.SYM_STELLA_CPP_PRINT_STREAM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_PRINT_STREAM", null, 0)));
      Stella.SYM_STELLA_CPP_STANDARD_ERROR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_STANDARD_ERROR", null, 0)));
      Stella.SYM_STELLA_CPP_STANDARD_OUT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_STANDARD_OUT", null, 0)));
      Stella.SYM_STELLA_CPP_SYMBOL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_SYMBOL", null, 0)));
      Stella.KWD_LOWERCASE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LOWERCASE", null, 2)));
      Stella.KWD_CAPITALIZED = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CAPITALIZED", null, 2)));
      Stella.SGT_STELLA_F_CPP_CHANGE_CASE_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-CPP-CHANGE-CASE-MEMO-TABLE-000", null, 1)));
      Stella.KWD_NEVER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NEVER", null, 2)));
      Stella.SYM_STELLA__RETURN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("_RETURN", null, 0)));
      Stella.SYM_STELLA_CPP_VAR_ARGS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_VAR_ARGS", null, 0)));
      Stella.SYM_STELLA_THIS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("THIS", null, 0)));
      Stella.SYM_STELLA_CPP_METHOD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_METHOD", null, 0)));
      Stella.SYM_STELLA_CPP_EXTERN_C = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_EXTERN_C", null, 0)));
      Stella.SYM_STELLA_CPP_METHOD_SETTER_CALL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_METHOD_SETTER_CALL", null, 0)));
      Stella.SYM_STELLA_CPP_REFERENCED_METHOD_CALL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_REFERENCED_METHOD_CALL", null, 0)));
      Stella.SYM_STELLA_CPP_METHOD_CALL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_METHOD_CALL", null, 0)));
      Stella.SYM_STELLA_CPP_FUNCTION_SIGNATURE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_FUNCTION_SIGNATURE", null, 0)));
      Stella.SYM_STELLA_CPP_METHOD_SIGNATURE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_METHOD_SIGNATURE", null, 0)));
      Stella.SYM_STELLA_CPP_FUNCALL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_FUNCALL", null, 0)));
      Stella.SYM_STELLA_CPP_METHOD_CODE_CALL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_METHOD_CODE_CALL", null, 0)));
      Stella.SYM_STELLA_DUMMY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DUMMY", null, 0)));
      Stella.SYM_STELLA_CPP_TERNARY_OP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_TERNARY_OP", null, 0)));
      Stella.SYM_STELLA_STARTUP_CPP_TRANSLATE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-CPP-TRANSLATE", null, 0)));
    }
  }

  static void helpStartupCppTranslate3() {
    {
      Stella.$CPP_TRUE_STRING_WRAPPER$ = StringWrapper.wrapString("TRUE");
      Stella.$CPP_FALSE_STRING_WRAPPER$ = StringWrapper.wrapString("FALSE");
      Stella.$DUMMYDECLARATIONS$.setDefaultValue(null);
      Stella.$CURRENTDUMMYINDEX$.setDefaultValue(new Integer(Stella.NULL_INTEGER));
      Stella.$OPERATOR_TABLE$ = ((KeyValueList)(AbstractDictionary.dictionary(Stella.SGT_STELLA_KEY_VALUE_LIST, Cons.cons(Stella.SYM_STELLA_ii, Cons.cons(Cons.cons(StringWrapper.wrapString("++"), Stella.NIL), Cons.cons(Stella.SYM_STELLA___, Cons.cons(Cons.cons(StringWrapper.wrapString("--"), Stella.NIL), Cons.cons(Stella.SYM_STELLA_i, Cons.cons(Cons.cons(StringWrapper.wrapString("+"), Stella.NIL), Cons.cons(Stella.SYM_STELLA__, Cons.cons(Cons.cons(StringWrapper.wrapString("-"), Stella.NIL), Cons.cons(Stella.SYM_STELLA_$, Cons.cons(Cons.cons(StringWrapper.wrapString("*"), Stella.NIL), Cons.cons(Stella.SYM_STELLA_s, Cons.cons(Cons.cons(StringWrapper.wrapString("/"), Stella.NIL), Cons.cons(Stella.SYM_STELLA_EQp, Cons.cons(Cons.cons(StringWrapper.wrapString("=="), Stella.NIL), Cons.cons(Stella.SYM_STELLA_xe, Cons.cons(Cons.cons(StringWrapper.wrapString("!="), Stella.NIL), Cons.cons(Stella.SYM_STELLA_g, Cons.cons(Cons.cons(StringWrapper.wrapString(">"), Stella.NIL), Cons.cons(Stella.SYM_STELLA_ge, Cons.cons(Cons.cons(StringWrapper.wrapString(">="), Stella.NIL), Cons.cons(Stella.SYM_STELLA_eg, Cons.cons(Cons.cons(StringWrapper.wrapString(">="), Stella.NIL), Cons.cons(Stella.SYM_STELLA_l, Cons.cons(Cons.cons(StringWrapper.wrapString("<"), Stella.NIL), Cons.cons(Stella.SYM_STELLA_el, Cons.cons(Cons.cons(StringWrapper.wrapString("<="), Stella.NIL), Cons.cons(Stella.SYM_STELLA_le, Cons.cons(Cons.cons(StringWrapper.wrapString("<="), Stella.NIL), Cons.cons(Stella.SYM_STELLA_AND, Cons.cons(Cons.cons(StringWrapper.wrapString("&&"), Stella.NIL), Cons.cons(Stella.SYM_STELLA_OR, Cons.cons(Cons.cons(StringWrapper.wrapString("||"), Stella.NIL), Cons.cons(Stella.SYM_STELLA_NOT, Cons.cons(Cons.cons(StringWrapper.wrapString("!"), Stella.NIL), Cons.cons(Stella.SYM_STELLA_CHOOSE, Cons.cons(Cons.cons(StringWrapper.wrapString("?"), Cons.cons(StringWrapper.wrapString(":"), Stella.NIL)), Stella.NIL)))))))))))))))))))))))))))))))))))))));
      Stella.$CPP_RESERVED_WORD_TABLE$ = Stella.cppCreateReservedWordTable();
      Stella.$CPP_CURRENT_UNIT_MODULE$.setDefaultValue(null);
      Stella.$CPP_CHARACTER_SUBSTITUTION_TABLE$ = Stella.cppCreateCharacterSubstitutionTable();
      Stella.$CPP_NAME_QUALIFICATION_MODE$.setDefaultValue(Stella.KWD_CLEVER);
    }
  }

  static void helpStartupCppTranslate4() {
    {
      Stella.defineFunctionObject("OVERLOADED-FUNCTION-NAME-MODULE", "(DEFUN (OVERLOADED-FUNCTION-NAME-MODULE MODULE) ((FUNCTION-NAME SYMBOL) (CLASS-TYPE TYPE)))", Native.find_java_method("edu.isi.stella.Symbol", "overloadedFunctionNameModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("CPP-USE-GARBAGE-COLLECTOR?", "(DEFUN (CPP-USE-GARBAGE-COLLECTOR? BOOLEAN) ())", Native.find_java_method("edu.isi.stella.Stella", "cppUseGarbageCollectorP", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("CPP-LOOKUP-OPERATOR-TABLE", "(DEFUN (CPP-LOOKUP-OPERATOR-TABLE CONS) ((OPERATOR SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "cppLookupOperatorTable", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("CPP-YIELD-RENAMED-RESERVED-WORD", "(DEFUN (CPP-YIELD-RENAMED-RESERVED-WORD STRING-WRAPPER) ((WORD SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "cppYieldRenamedReservedWord", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("CPP-CREATE-RESERVED-WORD-TABLE", "(DEFUN (CPP-CREATE-RESERVED-WORD-TABLE STRING-HASH-TABLE) ())", Native.find_java_method("edu.isi.stella.Stella", "cppCreateReservedWordTable", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("CPP-LOOKUP-RESERVED-WORD-TABLE", "(DEFUN (CPP-LOOKUP-RESERVED-WORD-TABLE STRING-WRAPPER) ((WORD SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "cppLookupReservedWordTable", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-UNIT", "(DEFUN (CPP-TRANSLATE-UNIT CONS) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "cppTranslateUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-LIST-OF-TREES", "(DEFUN (CPP-TRANSLATE-LIST-OF-TREES CONS) ((TREES CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateListOfTrees", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-A-TREE", "(DEFUN (CPP-TRANSLATE-A-TREE OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "cppTranslateATree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-VERBATIM-TREE", "(DEFUN (CPP-TRANSLATE-VERBATIM-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateVerbatimTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-SPECIAL-TREE", "(DEFUN (CPP-TRANSLATE-SPECIAL-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateSpecialTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-INLINE-TREE", "(DEFUN (CPP-TRANSLATE-INLINE-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateInlineTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("TOKENIZE-VERBATIM-METHOD-BODY", "(DEFUN (TOKENIZE-VERBATIM-METHOD-BODY CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "tokenizeVerbatimMethodBody", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-INLINE-CALL-TREE", "(DEFUN (CPP-TRANSLATE-INLINE-CALL-TREE OBJECT) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateInlineCallTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-PRINT-NATIVE-STREAM", "(DEFUN (CPP-TRANSLATE-PRINT-NATIVE-STREAM CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslatePrintNativeStream", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-DEFPRINT-UNIT", "(DEFUN (CPP-TRANSLATE-DEFPRINT-UNIT CONS) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "cppTranslateDefprintUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-SIGNAL", "(DEFUN (CPP-TRANSLATE-SIGNAL CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateSignal", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-HANDLER-CASE", "(DEFUN (CPP-TRANSLATE-HANDLER-CASE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateHandlerCase", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-HANDLE-EXCEPTION", "(DEFUN (CPP-TRANSLATE-HANDLE-EXCEPTION CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateHandleException", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-UNWIND-PROTECT", "(DEFUN (CPP-TRANSLATE-UNWIND-PROTECT CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateUnwindProtect", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-CAST", "(DEFUN (CPP-TRANSLATE-CAST CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateCast", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-MV-SETQ", "(DEFUN (CPP-TRANSLATE-MV-SETQ CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateMvSetq", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-MV-FUNCTION-CALL", "(DEFUN (CPP-TRANSLATE-MV-FUNCTION-CALL CONS) ((FUNCTIONCALL CONS) (VARIABLES CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateMvFunctionCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-DEFINE-GLOBAL-VARIABLE-UNIT", "(DEFUN (CPP-TRANSLATE-DEFINE-GLOBAL-VARIABLE-UNIT CONS) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "cppTranslateDefineGlobalVariableUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
      Stella.defineFunctionObject("SYMBOL-CASE?", "(DEFUN (SYMBOL-CASE? BOOLEAN) ((KEYFORM OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "symbolCaseP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CPP-YIELD-SYMBOL-ID-FORM", "(DEFUN (CPP-YIELD-SYMBOL-ID-FORM CONS) ((SYMBOLID INTEGER)))", Native.find_java_method("edu.isi.stella.Stella", "cppYieldSymbolIdForm", new java.lang.Class [] {java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-CONDITION", "(DEFUN (CPP-TRANSLATE-CONDITION CONS) ((CONDITION CONS) (SYMBOLCASEP BOOLEAN)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateCondition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-CASE-TREE", "(DEFUN (CPP-TRANSLATE-CASE-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateCaseTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-COND-TREE", "(DEFUN (CPP-TRANSLATE-COND-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateCondTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-LOOP", "(DEFUN (CPP-TRANSLATE-LOOP CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateLoop", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-WHILE", "(DEFUN (CPP-TRANSLATE-WHILE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateWhile", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-PROGN", "(DEFUN (CPP-TRANSLATE-PROGN CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateProgn", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-WITH-PROCESS-LOCK", "(DEFUN (CPP-TRANSLATE-WITH-PROCESS-LOCK CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateWithProcessLock", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-BREAK", "(DEFUN (CPP-TRANSLATE-BREAK CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateBreak", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-CONTINUE", "(DEFUN (CPP-TRANSLATE-CONTINUE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateContinue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-IF-TREE", "(DEFUN (CPP-TRANSLATE-IF-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateIfTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-CHOOSE-TREE", "(DEFUN (CPP-TRANSLATE-CHOOSE-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateChooseTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-WHEN-TREE", "(DEFUN (CPP-TRANSLATE-WHEN-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateWhenTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-UNLESS-TREE", "(DEFUN (CPP-TRANSLATE-UNLESS-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateUnlessTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-FOREACH-TREE", "(DEFUN (CPP-TRANSLATE-FOREACH-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateForeachTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-YIELD-VA-START-TREE", "(DEFUN (CPP-YIELD-VA-START-TREE CONS) ((ITERATORVAR SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "cppYieldVaStartTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("CPP-YIELD-VA-END-TREE", "(DEFUN (CPP-YIELD-VA-END-TREE CONS) ((ITERATORVAR SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "cppYieldVaEndTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("CPP-YIELD-VA-ITERATOR-HELPER-VARIABLE", "(DEFUN (CPP-YIELD-VA-ITERATOR-HELPER-VARIABLE SYMBOL) ((ITERATORVAR SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "cppYieldVaIteratorHelperVariable", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("CPP-YIELD-VA-ITERATOR-DECLARATIONS", "(DEFUN (CPP-YIELD-VA-ITERATOR-DECLARATIONS CONS) ((ITERATORVAR SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "cppYieldVaIteratorDeclarations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-ARGUMENT-LIST-TREE", "(DEFUN (CPP-TRANSLATE-ARGUMENT-LIST-TREE CONS) ((OPERATOR SYMBOL) (OWNER TYPE) (ARGUMENT OBJECT)))", Native.find_java_method("edu.isi.stella.Symbol", "cppTranslateArgumentListTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-THE-CODE", "(DEFUN (CPP-TRANSLATE-THE-CODE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateTheCode", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-SYS-POINTER-TO-FUNCTION", "(DEFUN (CPP-TRANSLATE-SYS-POINTER-TO-FUNCTION CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateSysPointerToFunction", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-SYS-NEW", "(DEFUN (CPP-TRANSLATE-SYS-NEW CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateSysNew", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-NON-POINTER-TYPE?", "(DEFUN (CPP-NON-POINTER-TYPE? BOOLEAN) ((TYPESPEC TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.StandardObject", "cppNonPointerTypeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("CPP-TYPE-WITHOUT-INTERIOR-POINTERS?", "(DEFUN (CPP-TYPE-WITHOUT-INTERIOR-POINTERS? BOOLEAN) ((TYPESPEC TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.StandardObject", "cppTypeWithoutInteriorPointersP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-NEW-ARRAY", "(DEFUN (CPP-TRANSLATE-NEW-ARRAY CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateNewArray", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-VOID-SYS", "(DEFUN (CPP-TRANSLATE-VOID-SYS CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateVoidSys", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-TYPED-SYS", "(DEFUN (CPP-TRANSLATE-TYPED-SYS CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateTypedSys", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-BAD-SYS", "(DEFUN (CPP-TRANSLATE-BAD-SYS OBJECT) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateBadSys", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-SYS-REFERENCED-SLOT-VALUE", "(DEFUN (CPP-TRANSLATE-SYS-REFERENCED-SLOT-VALUE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateSysReferencedSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-SYS-SLOT-VALUE", "(DEFUN (CPP-TRANSLATE-SYS-SLOT-VALUE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateSysSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-SYS-SLOT-VALUE-SETTER", "(DEFUN (CPP-TRANSLATE-SYS-SLOT-VALUE-SETTER CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateSysSlotValueSetter", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-MAKE-TREE", "(DEFUN (CPP-TRANSLATE-MAKE-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateMakeTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-STARTUP-TIME-PROGN", "(DEFUN (CPP-TRANSLATE-STARTUP-TIME-PROGN CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateStartupTimeProgn", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-STREAM-IS-STANDARD-OUTPUT?", "(DEFUN (CPP-STREAM-IS-STANDARD-OUTPUT? BOOLEAN) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "cppStreamIsStandardOutputP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
    }
  }

  static void helpStartupCppTranslate5() {
    {
      Stella.defineFunctionObject("CPP-TRANSLATE-PRINT-STREAM", "(DEFUN (CPP-TRANSLATE-PRINT-STREAM CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslatePrintStream", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-SETQ-TREE", "(DEFUN (CPP-TRANSLATE-SETQ-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateSetqTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-SYS-SET-DEFAULT", "(DEFUN (CPP-TRANSLATE-SYS-SET-DEFAULT OBJECT) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateSysSetDefault", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-NULL", "(DEFUN (CPP-TRANSLATE-NULL CONS) ())", Native.find_java_method("edu.isi.stella.Stella", "cppTranslateNull", new java.lang.Class [] {}), null);
      Stella.defineMethodObject("(DEFMETHOD (CPP-TRANSLATE-ATOMIC-TREE CONS) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "cppTranslateAtomicTree", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CPP-TRANSLATE-ATOMIC-TREE CONS) ((TREE KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "cppTranslateAtomicTree", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CPP-TRANSLATE-ATOMIC-TREE CONS) ((TREE SURROGATE)))", Native.find_java_method("edu.isi.stella.Surrogate", "cppTranslateAtomicTree", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CPP-TRANSLATE-ATOMIC-TREE CONS) ((TREE SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "cppTranslateAtomicTree", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CPP-TRANSLATE-ATOMIC-TREE CONS) ((TREE QUOTED-EXPRESSION)))", Native.find_java_method("edu.isi.stella.QuotedExpression", "cppTranslateAtomicTree", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("CPP-TRANSLATE-LET-TREE", "(DEFUN (CPP-TRANSLATE-LET-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateLetTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-TYPE-SPEC", "(DEFUN (CPP-TRANSLATE-TYPE-SPEC STRING-WRAPPER) ((TYPESPEC TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.StandardObject", "cppTranslateTypeSpec", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-AND-POINTERIZE-TYPE-SPEC", "(DEFUN (CPP-TRANSLATE-AND-POINTERIZE-TYPE-SPEC STRING-WRAPPER) ((TYPESPEC TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.StandardObject", "cppTranslateAndPointerizeTypeSpec", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-AND-REFERENCIZE-TYPE-SPEC", "(DEFUN (CPP-TRANSLATE-AND-REFERENCIZE-TYPE-SPEC STRING-WRAPPER) ((TYPESPEC TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.StandardObject", "cppTranslateAndReferencizeTypeSpec", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-ARRAY-TYPE", "(DEFUN (CPP-TRANSLATE-ARRAY-TYPE STRING-WRAPPER) ((ARRAYTYPE PARAMETRIC-TYPE-SPECIFIER)))", Native.find_java_method("edu.isi.stella.ParametricTypeSpecifier", "cppTranslateArrayType", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.ParametricTypeSpecifier")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATED-ARRAY-TYPE?", "(DEFUN (CPP-TRANSLATED-ARRAY-TYPE? BOOLEAN) ((TRANSLATEDTYPE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "cppTranslatedArrayTypeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CPP-GENERATE-ARRAY-TYPED-ENTITY", "(DEFUN (CPP-GENERATE-ARRAY-TYPED-ENTITY STRING) ((ENTITY STRING) (TRANSLATEDARRAYTYPE STRING)))", Native.find_java_method("edu.isi.stella.Stella", "cppGenerateArrayTypedEntity", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("CPP-NATIVE-POINTER-TYPE?", "(DEFUN (CPP-NATIVE-POINTER-TYPE? BOOLEAN) ((NATIVETYPE STRING)))", Native.find_java_method("edu.isi.stella.Stella", "cppNativePointerTypeP", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("CPP-UNPOINTERIZE-NATIVE-TYPE", "(DEFUN (CPP-UNPOINTERIZE-NATIVE-TYPE STRING) ((NATIVETYPE STRING)))", Native.find_java_method("edu.isi.stella.Stella", "cppUnpointerizeNativeType", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("CPP-CREATE-CHARACTER-SUBSTITUTION-TABLE", "(DEFUN (CPP-CREATE-CHARACTER-SUBSTITUTION-TABLE STRING) ())", Native.find_java_method("edu.isi.stella.Stella", "cppCreateCharacterSubstitutionTable", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("REPLACE-FIRST-CHARACTER-WITH-STRING", "(DEFUN (REPLACE-FIRST-CHARACTER-WITH-STRING STRING) ((STRING STRING) (NEWPREFIX STRING)))", Native.find_java_method("edu.isi.stella.Stella", "replaceFirstCharacterWithString", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("CPP-SUBSTITUTE-FORBIDDEN-CHARACTERS", "(DEFUN (CPP-SUBSTITUTE-FORBIDDEN-CHARACTERS STRING) ((NAME STRING) (CASECONVENTION KEYWORD)))", Native.find_java_method("edu.isi.stella.Stella", "cppSubstituteForbiddenCharacters", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("CPP-CHANGE-CASE", "(DEFUN (CPP-CHANGE-CASE STRING) ((SYMBOL GENERALIZED-SYMBOL) (CASECONVENTION KEYWORD)))", Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "cppChangeCase", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("HELP-CPP-CHANGE-CASE", "(DEFUN (HELP-CPP-CHANGE-CASE STRING) ((SYMBOL GENERALIZED-SYMBOL) (CASECONVENTION KEYWORD)))", Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "helpCppChangeCase", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("CPP-YIELD-NAMESPACE-PREFIX-FROM-MODULE", "(DEFUN (CPP-YIELD-NAMESPACE-PREFIX-FROM-MODULE STRING) ((MODULE MODULE)))", Native.find_java_method("edu.isi.stella.Module", "cppYieldNamespacePrefixFromModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("CPP-YIELD-NAMESPACE-PREFIX", "(DEFUN (CPP-YIELD-NAMESPACE-PREFIX STRING) ((SYMBOL GENERALIZED-SYMBOL)))", Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "cppYieldNamespacePrefix", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol")}), null);
      Stella.defineFunctionObject("CPP-NAME-QUALIFICATION-MODE", "(DEFUN (CPP-NAME-QUALIFICATION-MODE KEYWORD) () :GLOBALLY-INLINE? TRUE (RETURN *CPP-NAME-QUALIFICATION-MODE*))", Native.find_java_method("edu.isi.stella.Stella", "cppNameQualificationMode", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("CPP-QUALIFY-NAME?", "(DEFUN (CPP-QUALIFY-NAME? BOOLEAN) ((NAMESYMBOL GENERALIZED-SYMBOL)))", Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "cppQualifyNameP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol")}), null);
      Stella.defineFunctionObject("CPP-YIELD-QUALIFIED-NAME", "(DEFUN (CPP-YIELD-QUALIFIED-NAME STRING) ((TRANSLATEDNAME STRING) (SOURCESYMBOL GENERALIZED-SYMBOL)))", Native.find_java_method("edu.isi.stella.Stella", "cppYieldQualifiedName", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.GeneralizedSymbol")}), null);
      Stella.defineFunctionObject("CPP-FIXUP-NAME-SYMBOL", "(DEFUN (CPP-FIXUP-NAME-SYMBOL SYMBOL) ((NAMESYMBOL SYMBOL) (HOMEMODULE MODULE)))", Native.find_java_method("edu.isi.stella.Symbol", "cppFixupNameSymbol", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-NAME", "(DEFUN (CPP-TRANSLATE-NAME STRING-WRAPPER) ((NAMESYMBOL SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "cppTranslateName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-GLOBAL-NAME", "(DEFUN (CPP-TRANSLATE-GLOBAL-NAME STRING-WRAPPER) ((NAMESYMBOL SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "cppTranslateGlobalName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-CLASS-PARAMETER-NAME", "(DEFUN (CPP-TRANSLATE-CLASS-PARAMETER-NAME STRING-WRAPPER) ((NAMESYMBOL SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "cppTranslateClassParameterName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-RETURN-PARAMETER-NAME", "(DEFUN (CPP-TRANSLATE-RETURN-PARAMETER-NAME STRING-WRAPPER) ((NAMESYMBOL SYMBOL) (PARAMETERNUMBER INTEGER)))", Native.find_java_method("edu.isi.stella.Symbol", "cppTranslateReturnParameterName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-SYMBOL-CONSTANT-NAME", "(DEFUN (CPP-TRANSLATE-SYMBOL-CONSTANT-NAME STRING-WRAPPER) ((SYMBOL GENERALIZED-SYMBOL)))", Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "cppTranslateSymbolConstantName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-SYMBOL-CONSTANT-ID", "(DEFUN (CPP-TRANSLATE-SYMBOL-CONSTANT-ID STRING-WRAPPER) ((SYMBOL GENERALIZED-SYMBOL)))", Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "cppTranslateSymbolConstantId", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-SYMBOL-NAME", "(DEFUN (CPP-TRANSLATE-SYMBOL-NAME STRING-WRAPPER) ((SYMBOL SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "cppTranslateSymbolName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-SYMBOL-ID", "(DEFUN (CPP-TRANSLATE-SYMBOL-ID STRING-WRAPPER) ((SYMBOL SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "cppTranslateSymbolId", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-SURROGATE-NAME", "(DEFUN (CPP-TRANSLATE-SURROGATE-NAME STRING-WRAPPER) ((SURROGATE SURROGATE)))", Native.find_java_method("edu.isi.stella.Surrogate", "cppTranslateSurrogateName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-SURROGATE-ID", "(DEFUN (CPP-TRANSLATE-SURROGATE-ID STRING-WRAPPER) ((SURROGATE SURROGATE)))", Native.find_java_method("edu.isi.stella.Surrogate", "cppTranslateSurrogateId", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-KEYWORD-NAME", "(DEFUN (CPP-TRANSLATE-KEYWORD-NAME STRING-WRAPPER) ((KEYWORD KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "cppTranslateKeywordName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-KEYWORD-ID", "(DEFUN (CPP-TRANSLATE-KEYWORD-ID STRING-WRAPPER) ((KEYWORD KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "cppTranslateKeywordId", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-CLASS-TYPENAME", "(DEFUN (CPP-TRANSLATE-CLASS-TYPENAME STRING-WRAPPER) ((NAMESYMBOL GENERALIZED-SYMBOL)))", Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "cppTranslateClassTypename", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-CLASS-NAME", "(DEFUN (CPP-TRANSLATE-CLASS-NAME STRING-WRAPPER) ((NAMESYMBOL GENERALIZED-SYMBOL)))", Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "cppTranslateClassName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol")}), null);
      Stella.defineFunctionObject("CPP-REFERENCE-TYPE?", "(DEFUN (CPP-REFERENCE-TYPE? BOOLEAN) ((TYPESPEC TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.StandardObject", "cppReferenceTypeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("CPP-REFERENCIZE-TYPE", "(DEFUN (CPP-REFERENCIZE-TYPE STRING-WRAPPER) ((TYPESPEC TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.StandardObject", "cppReferencizeType", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-FUNCTION-PARAMETER", "(DEFUN (CPP-TRANSLATE-FUNCTION-PARAMETER OBJECT) ((NAME SYMBOL) (TYPE TYPE-SPEC) (METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.Symbol", "cppTranslateFunctionParameter", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-RETURN-PARAMETER", "(DEFUN (CPP-TRANSLATE-RETURN-PARAMETER CONS) ((PARAMETERNUMBER INTEGER) (PARAMETERTYPE TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.Stella", "cppTranslateReturnParameter", new java.lang.Class [] {java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-FUNCTION-PARAMETERS", "(DEFUN (CPP-TRANSLATE-FUNCTION-PARAMETERS CONS) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "cppTranslateFunctionParameters", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("SLOT-READER-FROM-NAME?", "(DEFUN (SLOT-READER-FROM-NAME? BOOLEAN) ((METHODNAME SYMBOL) (METHODOWNER TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.Symbol", "slotReaderFromNameP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("SLOT-READER?", "(DEFUN (SLOT-READER? BOOLEAN) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "slotReaderP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-CONSTRUCTOR-NAME", "(DEFUN (CPP-TRANSLATE-CONSTRUCTOR-NAME STRING-WRAPPER) ((CONSTRUCTOR METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "cppTranslateConstructorName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-FUNCTION-NAME-FROM-NAME", "(DEFUN (CPP-TRANSLATE-FUNCTION-NAME-FROM-NAME STRING-WRAPPER) ((FUNCTIONNAME SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "cppTranslateFunctionNameFromName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-FUNCTION-NAME", "(DEFUN (CPP-TRANSLATE-FUNCTION-NAME STRING-WRAPPER) ((FUNCTION METHOD-SLOT) (QUALIFY? BOOLEAN)))", Native.find_java_method("edu.isi.stella.MethodSlot", "cppTranslateFunctionName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-METHOD-NAME-FROM-NAME", "(DEFUN (CPP-TRANSLATE-METHOD-NAME-FROM-NAME STRING-WRAPPER) ((METHODNAME SYMBOL) (METHODOWNER TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.Symbol", "cppTranslateMethodNameFromName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-METHOD-NAME", "(DEFUN (CPP-TRANSLATE-METHOD-NAME STRING-WRAPPER) ((METHOD METHOD-SLOT) (QUALIFY? BOOLEAN)))", Native.find_java_method("edu.isi.stella.MethodSlot", "cppTranslateMethodName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("DELETE-QUOTED-NULL-STATEMENTS", "(DEFUN (DELETE-QUOTED-NULL-STATEMENTS CONS) ((TREES CONS)))", Native.find_java_method("edu.isi.stella.Cons", "deleteQuotedNullStatements", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-METHOD-OBJECT-IS-FUNCTION?", "(DEFUN (CPP-METHOD-OBJECT-IS-FUNCTION? BOOLEAN) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "cppMethodObjectIsFunctionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("CPP-METHOD-OBJECT-IS-OVERLOADED-FUNCTION?", "(DEFUN (CPP-METHOD-OBJECT-IS-OVERLOADED-FUNCTION? BOOLEAN) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "cppMethodObjectIsOverloadedFunctionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("WRAP-METHOD-BODY-WITH-CPP-AUXILIARY-DECLARATIONS", "(DEFUN (WRAP-METHOD-BODY-WITH-CPP-AUXILIARY-DECLARATIONS CONS) ((METHODBODY CONS) (DECLARATIONS CONS)))", Native.find_java_method("edu.isi.stella.Cons", "wrapMethodBodyWithCppAuxiliaryDeclarations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-TRANSLATE-DEFINE-METHOD-UNIT", "(DEFUN (CPP-TRANSLATE-DEFINE-METHOD-UNIT CONS) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "cppTranslateDefineMethodUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
    }
  }

  public static void startupCppTranslate() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupCppTranslate.helpStartupCppTranslate1();
          _StartupCppTranslate.helpStartupCppTranslate2();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          _StartupCppTranslate.helpStartupCppTranslate3();
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupCppTranslate.helpStartupCppTranslate4();
          _StartupCppTranslate.helpStartupCppTranslate5();
          Stella.defineFunctionObject("CPP-TRANSLATE-RETURN-TREE", "(DEFUN (CPP-TRANSLATE-RETURN-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateReturnTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-ACTUAL-PARAMETERS", "(DEFUN (CPP-TRANSLATE-ACTUAL-PARAMETERS CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateActualParameters", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-VARIABLE-LENGTH-ACTUALS", "(DEFUN (CPP-TRANSLATE-VARIABLE-LENGTH-ACTUALS CONS) ((ACTUALS CONS) (METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateVariableLengthActuals", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-CALL-METHOD-SETTER", "(DEFUN (CPP-TRANSLATE-CALL-METHOD-SETTER CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateCallMethodSetter", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-CREATE-OVERLOADED-FUNCTION-NAME", "(DEFUN (CPP-CREATE-OVERLOADED-FUNCTION-NAME SYMBOL) ((FUNCTIONNAME SYMBOL) (CLASSTYPE TYPE)))", Native.find_java_method("edu.isi.stella.Symbol", "cppCreateOverloadedFunctionName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-METHOD-CALL", "(DEFUN (CPP-TRANSLATE-METHOD-CALL CONS) ((TREE CONS) (REFERENCED? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateMethodCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-NORMAL-METHOD-CALL", "(DEFUN (CPP-TRANSLATE-NORMAL-METHOD-CALL CONS) ((METHODNAME SYMBOL) (OWNER TYPE) (ARGUMENTS CONS) (REFERENCED? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Symbol", "cppTranslateNormalMethodCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-DEFINED?-METHOD-CALL", "(DEFUN (CPP-TRANSLATE-DEFINED?-METHOD-CALL CONS) ((ARGUMENTTYPE TYPE) (ARGUMENT OBJECT) (NULL? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Surrogate", "cppTranslateDefinedPMethodCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-NTH-METHOD-CALL", "(DEFUN (CPP-TRANSLATE-NTH-METHOD-CALL CONS) ((OPERATOR SYMBOL) (OWNER TYPE) (ARGUMENTS CONS)))", Native.find_java_method("edu.isi.stella.Symbol", "cppTranslateNthMethodCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-AREF-METHOD-CALL", "(DEFUN (CPP-TRANSLATE-AREF-METHOD-CALL CONS) ((OPERATOR SYMBOL) (OWNER TYPE) (ARGUMENTS CONS)))", Native.find_java_method("edu.isi.stella.Symbol", "cppTranslateArefMethodCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-CODE-SIGNATURE", "(DEFUN (CPP-TRANSLATE-CODE-SIGNATURE CONS) ((SIGNATURE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateCodeSignature", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-METHOD-CODE-SIGNATURE", "(DEFUN (CPP-TRANSLATE-METHOD-CODE-SIGNATURE CONS) ((SIGNATURE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateMethodCodeSignature", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-CALL-FUNCTION-CODE", "(DEFUN (CPP-TRANSLATE-CALL-FUNCTION-CODE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateCallFunctionCode", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-CALL-METHOD-CODE", "(DEFUN (CPP-TRANSLATE-CALL-METHOD-CODE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateCallMethodCode", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("GET-LAST-N-ELEMENTS", "(DEFUN (GET-LAST-N-ELEMENTS CONS) ((LIST CONS) (N INTEGER)))", Native.find_java_method("edu.isi.stella.Cons", "getLastNElements", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("CPP-YIELD-UNUSED-DUMMY-ARGS", "(DEFUN (CPP-YIELD-UNUSED-DUMMY-ARGS CONS) ((METHOD METHOD-SLOT) (ARGS CONS)))", Native.find_java_method("edu.isi.stella.MethodSlot", "cppYieldUnusedDummyArgs", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-FUNCTION-CALL", "(DEFUN (CPP-TRANSLATE-FUNCTION-CALL CONS) ((TREE CONS) (METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateFunctionCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-OPERATOR-TREE", "(DEFUN (CPP-TRANSLATE-OPERATOR-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateOperatorTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-OPERATOR-CALL", "(DEFUN (CPP-TRANSLATE-OPERATOR-CALL CONS) ((OPERATORNAMES CONS) (ARGUMENTS CONS) (ARITY INTEGER)))", Native.find_java_method("edu.isi.stella.Cons", "cppTranslateOperatorCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-HARDCODED-SYMBOL-REFERENCE", "(DEFUN (CPP-TRANSLATE-HARDCODED-SYMBOL-REFERENCE CONS) ((OPERATOR SYMBOL) (OFFSET INTEGER)))", Native.find_java_method("edu.isi.stella.Symbol", "cppTranslateHardcodedSymbolReference", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("STARTUP-CPP-TRANSLATE", "(DEFUN STARTUP-CPP-TRANSLATE () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupCppTranslate", "startupCppTranslate", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_CPP_TRANSLATE);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupCppTranslate"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CPP-TRUE-STRING-WRAPPER* STRING-WRAPPER (WRAP-LITERAL \"TRUE\") :PUBLIC? FALSE :DOCUMENTATION \"Wrapped TRUE string, used to reduce consing.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CPP-FALSE-STRING-WRAPPER* STRING-WRAPPER (WRAP-LITERAL \"FALSE\") :PUBLIC? FALSE :DOCUMENTATION \"Wrapped FALSE string, used to reduce consing.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *DUMMYDECLARATIONS* CONS NULL :DOCUMENTATION \"Temporary List of declarations for unused return parameters\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *CURRENTDUMMYINDEX* INTEGER NULL-INTEGER :DOCUMENTATION \"Current index of dummy parameter for unused return value\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *OPERATOR-TABLE* KEY-VALUE-LIST (DICTIONARY @KEY-VALUE-LIST (QUOTE ++) (CONS (WRAP-LITERAL \"++\") NIL) (QUOTE --) (CONS (WRAP-LITERAL \"--\") NIL) (QUOTE +) (CONS (WRAP-LITERAL \"+\") NIL) (QUOTE -) (CONS (WRAP-LITERAL \"-\") NIL) (QUOTE *) (CONS (WRAP-LITERAL \"*\") NIL) (QUOTE /) (CONS (WRAP-LITERAL \"/\") NIL) (QUOTE EQ?) (CONS (WRAP-LITERAL \"==\") NIL) (QUOTE !=) (CONS (WRAP-LITERAL \"!=\") NIL) (QUOTE >) (CONS (WRAP-LITERAL \">\") NIL) (QUOTE >=) (CONS (WRAP-LITERAL \">=\") NIL) (QUOTE =>) (CONS (WRAP-LITERAL \">=\") NIL) (QUOTE <) (CONS (WRAP-LITERAL \"<\") NIL) (QUOTE =<) (CONS (WRAP-LITERAL \"<=\") NIL) (QUOTE <=) (CONS (WRAP-LITERAL \"<=\") NIL) (QUOTE AND) (CONS (WRAP-LITERAL \"&&\") NIL) (QUOTE OR) (CONS (WRAP-LITERAL \"||\") NIL) (QUOTE NOT) (CONS (WRAP-LITERAL \"!\") NIL) (QUOTE CHOOSE) (CONS (WRAP-LITERAL \"?\") (CONS (WRAP-LITERAL \":\") NIL))) :DOCUMENTATION \"Mapping from STELLA operators to C++ operators\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CPP-RESERVED-WORD-TABLE* (STRING-HASH-TABLE OF STRING STRING-WRAPPER) (CPP-CREATE-RESERVED-WORD-TABLE))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *CPP-CURRENT-UNIT-MODULE* MODULE NULL :DOCUMENTATION \"Home module of the currently translated unit.  Needed for\nproper name translation for units whose home module is different than the\nfile module (occurs in some PowerLoom files - I thought we had outlawed that).\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CPP-CHARACTER-SUBSTITUTION-TABLE* STRING (CPP-CREATE-CHARACTER-SUBSTITUTION-TABLE))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *CPP-NAME-QUALIFICATION-MODE* KEYWORD :CLEVER)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CPP-NAMESPACE-SEPARATOR* STRING \"::\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
