//  -*- Mode: Java -*-
//
// _StartupLiterals.java

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

public class _StartupLiterals {
  static void helpStartupLiterals1() {
    {
      Stella.SGT_STELLA_BOOLEAN = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("BOOLEAN", null, 1)));
      Stella.KWD_NULL_WRAPPER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL-WRAPPER", null, 2)));
      Stella.SYM_STELLA_FALSE_WRAPPER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FALSE-WRAPPER", null, 0)));
      Stella.SGT_STELLA_INTEGER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INTEGER", null, 1)));
      Stella.SYM_STELLA_NULL_INTEGER_WRAPPER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL-INTEGER-WRAPPER", null, 0)));
      Stella.SGT_STELLA_LONG_INTEGER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("LONG-INTEGER", null, 1)));
      Stella.SYM_STELLA_NULL_LONG_INTEGER_WRAPPER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL-LONG-INTEGER-WRAPPER", null, 0)));
      Stella.SGT_STELLA_FLOAT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FLOAT", null, 1)));
      Stella.SYM_STELLA_NULL_FLOAT_WRAPPER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL-FLOAT-WRAPPER", null, 0)));
      Stella.SGT_STELLA_STRING = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("STRING", null, 1)));
      Stella.SYM_STELLA_NULL_STRING_WRAPPER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL-STRING-WRAPPER", null, 0)));
      Stella.SGT_STELLA_MUTABLE_STRING = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("MUTABLE-STRING", null, 1)));
      Stella.SYM_STELLA_NULL_MUTABLE_STRING_WRAPPER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL-MUTABLE-STRING-WRAPPER", null, 0)));
      Stella.SGT_STELLA_CHARACTER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CHARACTER", null, 1)));
      Stella.SYM_STELLA_NULL_CHARACTER_WRAPPER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL-CHARACTER-WRAPPER", null, 0)));
      Stella.SGT_STELLA_FUNCTION_CODE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FUNCTION-CODE", null, 1)));
      Stella.SYM_STELLA_NULL_FUNCTION_CODE_WRAPPER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL-FUNCTION-CODE-WRAPPER", null, 0)));
      Stella.SGT_STELLA_METHOD_CODE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-CODE", null, 1)));
      Stella.SYM_STELLA_NULL_METHOD_CODE_WRAPPER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL-METHOD-CODE-WRAPPER", null, 0)));
      Stella.SYM_STELLA_TRUE_WRAPPER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TRUE-WRAPPER", null, 0)));
      Stella.SYM_STELLA_WRAP_BOOLEAN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WRAP-BOOLEAN", null, 0)));
      Stella.SYM_STELLA_COERCE_WRAPPED_BOOLEAN_TO_BOOLEAN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COERCE-WRAPPED-BOOLEAN-TO-BOOLEAN", null, 0)));
      Stella.KWD_WRAP_FUNCTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("WRAP-FUNCTION", null, 2)));
      Stella.SYM_STELLA_WRAP_INTEGER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WRAP-INTEGER", null, 0)));
      Stella.SYM_STELLA_WRAP_LONG_INTEGER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WRAP-LONG-INTEGER", null, 0)));
      Stella.SYM_STELLA_WRAP_FLOAT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WRAP-FLOAT", null, 0)));
      Stella.SYM_STELLA_WRAP_STRING = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WRAP-STRING", null, 0)));
      Stella.SYM_STELLA_WRAP_CHARACTER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WRAP-CHARACTER", null, 0)));
      Stella.SYM_STELLA_WRAP_FUNCTION_CODE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WRAP-FUNCTION-CODE", null, 0)));
      Stella.SYM_STELLA_WRAP_METHOD_CODE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WRAP-METHOD-CODE", null, 0)));
      Stella.SYM_STELLA_NIL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NIL", null, 0)));
      Stella.SYM_STELLA_CONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CONS", null, 0)));
      Stella.SYM_STELLA_WRAP_LITERAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WRAP-LITERAL", null, 0)));
      Stella.SYM_STELLA_GET_KWD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("GET-KWD", null, 0)));
      Stella.SYM_STELLA_TYPED_SYS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TYPED-SYS", null, 0)));
      Stella.SYM_STELLA_GET_SGT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("GET-SGT", null, 0)));
      Stella.SYM_STELLA_INTERN_COMMON_LISP_SYMBOL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INTERN-COMMON-LISP-SYMBOL", null, 0)));
      Stella.SYM_STELLA_GET_SYM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("GET-SYM", null, 0)));
      Stella.SYM_STELLA_LIST$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LIST*", null, 0)));
      Stella.SYM_STELLA_a = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("&", null, 0)));
      Stella.SYM_STELLA_aa = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("&&", null, 0)));
      Stella.KWD_OTHER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("OTHER", null, 2)));
      Stella.KWD_SYMBOL_QUALIFIER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SYMBOL-QUALIFIER", null, 2)));
      Stella.KWD_ESCAPE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ESCAPE", null, 2)));
      Stella.KWD_DELIMITER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DELIMITER", null, 2)));
      Stella.SYM_STELLA_STARTUP_LITERALS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-LITERALS", null, 0)));
    }
  }

  static void helpStartupLiterals2() {
    {
      Stella.$LITERAL_TYPE_INFO_TABLE$ = HashTable.newHashTable();
      Stella.$LITERAL_TYPES$ = List.newList();
      Surrogate.setLiteralTypeInfo(Stella.SGT_STELLA_BOOLEAN, Stella.KWD_NULL_WRAPPER, Stella.SYM_STELLA_FALSE_WRAPPER);
      Surrogate.setLiteralTypeInfo(Stella.SGT_STELLA_INTEGER, Stella.KWD_NULL_WRAPPER, Stella.SYM_STELLA_NULL_INTEGER_WRAPPER);
      Surrogate.setLiteralTypeInfo(Stella.SGT_STELLA_LONG_INTEGER, Stella.KWD_NULL_WRAPPER, Stella.SYM_STELLA_NULL_LONG_INTEGER_WRAPPER);
      Surrogate.setLiteralTypeInfo(Stella.SGT_STELLA_FLOAT, Stella.KWD_NULL_WRAPPER, Stella.SYM_STELLA_NULL_FLOAT_WRAPPER);
      Surrogate.setLiteralTypeInfo(Stella.SGT_STELLA_STRING, Stella.KWD_NULL_WRAPPER, Stella.SYM_STELLA_NULL_STRING_WRAPPER);
      Surrogate.setLiteralTypeInfo(Stella.SGT_STELLA_MUTABLE_STRING, Stella.KWD_NULL_WRAPPER, Stella.SYM_STELLA_NULL_MUTABLE_STRING_WRAPPER);
      Surrogate.setLiteralTypeInfo(Stella.SGT_STELLA_CHARACTER, Stella.KWD_NULL_WRAPPER, Stella.SYM_STELLA_NULL_CHARACTER_WRAPPER);
      Surrogate.setLiteralTypeInfo(Stella.SGT_STELLA_FUNCTION_CODE, Stella.KWD_NULL_WRAPPER, Stella.SYM_STELLA_NULL_FUNCTION_CODE_WRAPPER);
      Surrogate.setLiteralTypeInfo(Stella.SGT_STELLA_METHOD_CODE, Stella.KWD_NULL_WRAPPER, Stella.SYM_STELLA_NULL_METHOD_CODE_WRAPPER);
      Surrogate.setLiteralTypeInfo(Stella.SGT_STELLA_BOOLEAN, Stella.KWD_WRAP_FUNCTION, Stella.SYM_STELLA_WRAP_BOOLEAN);
      Surrogate.setLiteralTypeInfo(Stella.SGT_STELLA_INTEGER, Stella.KWD_WRAP_FUNCTION, Stella.SYM_STELLA_WRAP_INTEGER);
      Surrogate.setLiteralTypeInfo(Stella.SGT_STELLA_LONG_INTEGER, Stella.KWD_WRAP_FUNCTION, Stella.SYM_STELLA_WRAP_LONG_INTEGER);
      Surrogate.setLiteralTypeInfo(Stella.SGT_STELLA_FLOAT, Stella.KWD_WRAP_FUNCTION, Stella.SYM_STELLA_WRAP_FLOAT);
      Surrogate.setLiteralTypeInfo(Stella.SGT_STELLA_STRING, Stella.KWD_WRAP_FUNCTION, Stella.SYM_STELLA_WRAP_STRING);
      Surrogate.setLiteralTypeInfo(Stella.SGT_STELLA_CHARACTER, Stella.KWD_WRAP_FUNCTION, Stella.SYM_STELLA_WRAP_CHARACTER);
      Surrogate.setLiteralTypeInfo(Stella.SGT_STELLA_FUNCTION_CODE, Stella.KWD_WRAP_FUNCTION, Stella.SYM_STELLA_WRAP_FUNCTION_CODE);
      Surrogate.setLiteralTypeInfo(Stella.SGT_STELLA_METHOD_CODE, Stella.KWD_WRAP_FUNCTION, Stella.SYM_STELLA_WRAP_METHOD_CODE);
      Stella.$CHARACTER_TYPE_TABLE$ = Stella.createCharacterTypeTable();
      Stella.$CHARACTER_UPCASE_TABLE$ = Stella.initializeCharacterUpcaseTable();
      Stella.$CHARACTER_DOWNCASE_TABLE$ = Stella.initializeCharacterDowncaseTable();
    }
  }

  static void helpStartupLiterals3() {
    {
      Stella.defineMethodObject("(DEFMETHOD (TERMINATE-WRAPPER? BOOLEAN) ((SELF WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Wrapper", "terminateWrapperP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (TERMINATE-WRAPPER? BOOLEAN) ((SELF INTEGER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.IntegerWrapper", "terminateWrapperP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("LOOKUP-LITERAL-TYPE-INFO", "(DEFUN (LOOKUP-LITERAL-TYPE-INFO OBJECT) ((TYPE TYPE) (KEY KEYWORD)))", Native.find_java_method("edu.isi.stella.Surrogate", "lookupLiteralTypeInfo", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("SET-LITERAL-TYPE-INFO", "(DEFUN SET-LITERAL-TYPE-INFO ((TYPE TYPE) (KEY KEYWORD) (VALUE OBJECT)))", Native.find_java_method("edu.isi.stella.Surrogate", "setLiteralTypeInfo", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("WRAP-INTEGER", "(DEFUN (WRAP-INTEGER INTEGER-WRAPPER) ((VALUE INTEGER)) :DOCUMENTATION \"Return a literal object whose value is the INTEGER 'value'.\" :PUBLIC? TRUE :CONSTRUCTOR? TRUE)", Native.find_java_method("edu.isi.stella.IntegerWrapper", "wrapInteger", new java.lang.Class [] {java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("UNWRAP-INTEGER", "(DEFUN (UNWRAP-INTEGER INTEGER) ((WRAPPER INTEGER-WRAPPER)) :DOCUMENTATION \"Unwrap `wrapper' and return the result.\nReturn NULL if `wrapper' is NULL.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.IntegerWrapper", "unwrapInteger", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper")}), null);
      Stella.defineFunctionObject("WRAP-LONG-INTEGER", "(DEFUN (WRAP-LONG-INTEGER LONG-INTEGER-WRAPPER) ((VALUE LONG-INTEGER)) :DOCUMENTATION \"Return a literal object whose value is the LONG-INTEGER 'value'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "wrapLongInteger", new java.lang.Class [] {java.lang.Long.TYPE}), null);
      Stella.defineFunctionObject("UNWRAP-LONG-INTEGER", "(DEFUN (UNWRAP-LONG-INTEGER LONG-INTEGER) ((WRAPPER LONG-INTEGER-WRAPPER)) :DOCUMENTATION \"Unwrap `wrapper' and return the result.\nReturn NULL if `wrapper' is NULL.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.LongIntegerWrapper", "unwrapLongInteger", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.LongIntegerWrapper")}), null);
      Stella.defineFunctionObject("WRAP-INTEGER-VALUE", "(DEFUN (WRAP-INTEGER-VALUE NUMBER-WRAPPER) ((VALUE LONG-INTEGER)) :DOCUMENTATION \"Return a literal object whose value is 'value'.  Choose a regular integer\nwrapper unless `value' is too large and needs to be stored in a long wrapper.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "wrapIntegerValue", new java.lang.Class [] {java.lang.Long.TYPE}), null);
      Stella.defineFunctionObject("WRAP-FLOAT", "(DEFUN (WRAP-FLOAT FLOAT-WRAPPER) ((VALUE FLOAT)) :DOCUMENTATION \"Return a literal object whose value is the FLOAT 'value'.\" :PUBLIC? TRUE :CONSTRUCTOR? TRUE)", Native.find_java_method("edu.isi.stella.FloatWrapper", "wrapFloat", new java.lang.Class [] {java.lang.Double.TYPE}), null);
      Stella.defineFunctionObject("UNWRAP-FLOAT", "(DEFUN (UNWRAP-FLOAT FLOAT) ((WRAPPER FLOAT-WRAPPER)) :DOCUMENTATION \"Unwrap `wrapper' and return the result.\nReturn NULL if `wrapper' is NULL.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.FloatWrapper", "unwrapFloat", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.FloatWrapper")}), null);
      Stella.defineFunctionObject("WRAP-STRING", "(DEFUN (WRAP-STRING STRING-WRAPPER) ((VALUE STRING)) :DOCUMENTATION \"Return a literal object whose value is the STRING 'value'.\" :PUBLIC? TRUE :CONSTRUCTOR? TRUE)", Native.find_java_method("edu.isi.stella.StringWrapper", "wrapString", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("UNWRAP-STRING", "(DEFUN (UNWRAP-STRING STRING) ((WRAPPER STRING-WRAPPER)) :DOCUMENTATION \"Unwrap `wrapper' and return the result.\nReturn NULL if `wrapper' is NULL.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.StringWrapper", "unwrapString", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper")}), null);
      Stella.defineFunctionObject("WRAP-MUTABLE-STRING", "(DEFUN (WRAP-MUTABLE-STRING MUTABLE-STRING-WRAPPER) ((VALUE MUTABLE-STRING)) :DOCUMENTATION \"Return a literal object whose value is the MUTABLE-STRING 'value'.\" :PUBLIC? TRUE :CONSTRUCTOR? TRUE)", Native.find_java_method("edu.isi.stella.MutableStringWrapper", "wrapMutableString", new java.lang.Class [] {Native.find_java_class("java.lang.StringBuffer")}), null);
      Stella.defineFunctionObject("UNWRAP-MUTABLE-STRING", "(DEFUN (UNWRAP-MUTABLE-STRING MUTABLE-STRING) ((WRAPPER MUTABLE-STRING-WRAPPER)) :DOCUMENTATION \"Unwrap `wrapper' and return the result.\nReturn NULL if `wrapper' is NULL.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.MutableStringWrapper", "unwrapMutableString", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MutableStringWrapper")}), null);
      Stella.defineFunctionObject("WRAP-CHARACTER", "(DEFUN (WRAP-CHARACTER CHARACTER-WRAPPER) ((VALUE CHARACTER)) :DOCUMENTATION \"Return a literal object whose value is the CHARACTER 'value'.\" :PUBLIC? TRUE :CONSTRUCTOR? TRUE)", Native.find_java_method("edu.isi.stella.CharacterWrapper", "wrapCharacter", new java.lang.Class [] {java.lang.Character.TYPE}), null);
      Stella.defineFunctionObject("UNWRAP-CHARACTER", "(DEFUN (UNWRAP-CHARACTER CHARACTER) ((WRAPPER CHARACTER-WRAPPER)) :DOCUMENTATION \"Unwrap `wrapper' and return the result.\nReturn NULL if `wrapper' is NULL.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.CharacterWrapper", "unwrapCharacter", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.CharacterWrapper")}), null);
      Stella.defineFunctionObject("WRAP-FUNCTION-CODE", "(DEFUN (WRAP-FUNCTION-CODE FUNCTION-CODE-WRAPPER) ((VALUE FUNCTION-CODE)) :DOCUMENTATION \"Return a literal object whose value is the FUNCTION-CODE 'value'.\" :PUBLIC? TRUE :CONSTRUCTOR? TRUE)", Native.find_java_method("edu.isi.stella.FunctionCodeWrapper", "wrapFunctionCode", new java.lang.Class [] {Native.find_java_class("java.lang.reflect.Method")}), null);
      Stella.defineFunctionObject("UNWRAP-FUNCTION-CODE", "(DEFUN (UNWRAP-FUNCTION-CODE FUNCTION-CODE) ((WRAPPER FUNCTION-CODE-WRAPPER)) :DOCUMENTATION \"Unwrap `wrapper' and return the result.\nReturn NULL if `wrapper' is NULL.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.FunctionCodeWrapper", "unwrapFunctionCode", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.FunctionCodeWrapper")}), null);
      Stella.defineFunctionObject("WRAP-METHOD-CODE", "(DEFUN (WRAP-METHOD-CODE METHOD-CODE-WRAPPER) ((VALUE METHOD-CODE)) :DOCUMENTATION \"Return a literal object whose value is the METHOD-CODE 'value'.\" :PUBLIC? TRUE :CONSTRUCTOR? TRUE)", Native.find_java_method("edu.isi.stella.MethodCodeWrapper", "wrapMethodCode", new java.lang.Class [] {Native.find_java_class("java.lang.reflect.Method")}), null);
      Stella.defineFunctionObject("UNWRAP-METHOD-CODE", "(DEFUN (UNWRAP-METHOD-CODE METHOD-CODE) ((WRAPPER METHOD-CODE-WRAPPER)) :DOCUMENTATION \"Unwrap `wrapper' and return the result.\nReturn NULL if `wrapper' is NULL.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.MethodCodeWrapper", "unwrapMethodCode", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodCodeWrapper")}), null);
      Stella.defineFunctionObject("WRAP-BOOLEAN", "(DEFUN (WRAP-BOOLEAN BOOLEAN-WRAPPER) ((VALUE BOOLEAN)) :DOCUMENTATION \"Return a literal object whose value is the BOOLEAN 'value'.\" :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE :CONSTRUCTOR? TRUE (RETURN (CHOOSE VALUE TRUE-WRAPPER FALSE-WRAPPER)))", Native.find_java_method("edu.isi.stella.BooleanWrapper", "wrapBoolean", new java.lang.Class [] {java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("UNWRAP-BOOLEAN", "(DEFUN (UNWRAP-BOOLEAN BOOLEAN) ((WRAPPER BOOLEAN-WRAPPER)) :DOCUMENTATION \"Unwrap `wrapper' and return its values as a regular BOOLEAN.\nMap NULL onto FALSE.\" :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (EQ? WRAPPER TRUE-WRAPPER)))", Native.find_java_method("edu.isi.stella.BooleanWrapper", "unwrapBoolean", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.BooleanWrapper")}), null);
      Stella.defineFunctionObject("COERCE-WRAPPED-BOOLEAN-TO-BOOLEAN", "(DEFUN (COERCE-WRAPPED-BOOLEAN-TO-BOOLEAN BOOLEAN) ((WRAPPER BOOLEAN-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.BooleanWrapper", "coerceWrappedBooleanToBoolean", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.BooleanWrapper")}), null);
      Stella.defineFunctionObject("INLINE-WRAP-BOOLEAN", "(DEFUN INLINE-WRAP-BOOLEAN ((EXPRESSION OBJECT)) :TYPE OBJECT :MACRO? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "inlineWrapBoolean", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("INLINE-UNWRAP-BOOLEAN", "(DEFUN INLINE-UNWRAP-BOOLEAN ((EXPRESSION OBJECT)) :TYPE OBJECT :MACRO? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "inlineUnwrapBoolean", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineMethodObject("(DEFMETHOD (WRAP-LITERAL INTEGER-WRAPPER) ((VALUE INTEGER)) :GLOBALLY-INLINE? TRUE :PUBLIC? TRUE (RETURN (WRAP-INTEGER VALUE)))", Native.find_java_method("edu.isi.stella.Stella", "integer_wrapLiteral", new java.lang.Class [] {java.lang.Integer.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (WRAP-LITERAL LONG-INTEGER-WRAPPER) ((VALUE LONG-INTEGER)) :GLOBALLY-INLINE? TRUE :PUBLIC? TRUE (RETURN (WRAP-LONG-INTEGER VALUE)))", Native.find_java_method("edu.isi.stella.Stella", "longInteger_wrapLiteral", new java.lang.Class [] {java.lang.Long.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (WRAP-LITERAL FLOAT-WRAPPER) ((VALUE FLOAT)) :GLOBALLY-INLINE? TRUE :PUBLIC? TRUE (RETURN (WRAP-FLOAT VALUE)))", Native.find_java_method("edu.isi.stella.Stella", "float_wrapLiteral", new java.lang.Class [] {java.lang.Double.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (WRAP-LITERAL MUTABLE-STRING-WRAPPER) ((VALUE MUTABLE-STRING)) :GLOBALLY-INLINE? TRUE :PUBLIC? TRUE (RETURN (WRAP-MUTABLE-STRING VALUE)))", Native.find_java_method("edu.isi.stella.Stella", "mutableString_wrapLiteral", new java.lang.Class [] {Native.find_java_class("java.lang.StringBuffer")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (WRAP-LITERAL STRING-WRAPPER) ((VALUE STRING)) :GLOBALLY-INLINE? TRUE :PUBLIC? TRUE (RETURN (WRAP-STRING VALUE)))", Native.find_java_method("edu.isi.stella.Stella", "string_wrapLiteral", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (WRAP-LITERAL CHARACTER-WRAPPER) ((VALUE CHARACTER)) :GLOBALLY-INLINE? TRUE :PUBLIC? TRUE (RETURN (WRAP-CHARACTER VALUE)))", Native.find_java_method("edu.isi.stella.Stella", "character_wrapLiteral", new java.lang.Class [] {java.lang.Character.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (WRAP-LITERAL FUNCTION-CODE-WRAPPER) ((VALUE FUNCTION-CODE)) :GLOBALLY-INLINE? TRUE :PUBLIC? TRUE (RETURN (WRAP-FUNCTION-CODE VALUE)))", Native.find_java_method("edu.isi.stella.Stella", "functionCode_wrapLiteral", new java.lang.Class [] {Native.find_java_class("java.lang.reflect.Method")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (WRAP-LITERAL METHOD-CODE-WRAPPER) ((VALUE METHOD-CODE)) :GLOBALLY-INLINE? TRUE :PUBLIC? TRUE (RETURN (WRAP-METHOD-CODE VALUE)))", Native.find_java_method("edu.isi.stella.Stella", "methodCode_wrapLiteral", new java.lang.Class [] {Native.find_java_class("java.lang.reflect.Method")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COPY-WRAPPED-LITERAL OBJECT) ((SELF STANDARD-OBJECT)))", Native.find_java_method("edu.isi.stella.StandardObject", "copyWrappedLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COPY-WRAPPED-LITERAL OBJECT) ((SELF LITERAL-WRAPPER)))", Native.find_java_method("edu.isi.stella.LiteralWrapper", "copyWrappedLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COPY-WRAPPED-LITERAL OBJECT) ((SELF INTEGER-WRAPPER)))", Native.find_java_method("edu.isi.stella.IntegerWrapper", "copyWrappedLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COPY-WRAPPED-LITERAL OBJECT) ((SELF LONG-INTEGER-WRAPPER)))", Native.find_java_method("edu.isi.stella.LongIntegerWrapper", "copyWrappedLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COPY-WRAPPED-LITERAL OBJECT) ((SELF FLOAT-WRAPPER)))", Native.find_java_method("edu.isi.stella.FloatWrapper", "copyWrappedLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COPY-WRAPPED-LITERAL OBJECT) ((SELF STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.StringWrapper", "copyWrappedLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COPY-WRAPPED-LITERAL OBJECT) ((SELF MUTABLE-STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.MutableStringWrapper", "copyWrappedLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COPY-WRAPPED-LITERAL OBJECT) ((SELF CHARACTER-WRAPPER)))", Native.find_java_method("edu.isi.stella.CharacterWrapper", "copyWrappedLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COPY-WRAPPED-LITERAL OBJECT) ((SELF FUNCTION-CODE-WRAPPER)))", Native.find_java_method("edu.isi.stella.FunctionCodeWrapper", "copyWrappedLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COPY-WRAPPED-LITERAL OBJECT) ((SELF METHOD-CODE-WRAPPER)))", Native.find_java_method("edu.isi.stella.MethodCodeWrapper", "copyWrappedLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (OBJECT-EQL? BOOLEAN) ((X OBJECT) (Y OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "objectEqlP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (OBJECT-EQL? BOOLEAN) ((X STANDARD-OBJECT) (Y OBJECT)))", Native.find_java_method("edu.isi.stella.StandardObject", "objectEqlP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (OBJECT-EQL? BOOLEAN) ((X INTEGER-WRAPPER) (Y OBJECT)))", Native.find_java_method("edu.isi.stella.IntegerWrapper", "objectEqlP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (OBJECT-EQL? BOOLEAN) ((X LONG-INTEGER-WRAPPER) (Y OBJECT)))", Native.find_java_method("edu.isi.stella.LongIntegerWrapper", "objectEqlP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (OBJECT-EQL? BOOLEAN) ((X FLOAT-WRAPPER) (Y OBJECT)))", Native.find_java_method("edu.isi.stella.FloatWrapper", "objectEqlP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (OBJECT-EQL? BOOLEAN) ((X BOOLEAN-WRAPPER) (Y OBJECT)))", Native.find_java_method("edu.isi.stella.BooleanWrapper", "objectEqlP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (OBJECT-EQL? BOOLEAN) ((X STRING-WRAPPER) (Y OBJECT)))", Native.find_java_method("edu.isi.stella.StringWrapper", "objectEqlP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (OBJECT-EQL? BOOLEAN) ((X MUTABLE-STRING-WRAPPER) (Y OBJECT)))", Native.find_java_method("edu.isi.stella.MutableStringWrapper", "objectEqlP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (OBJECT-EQL? BOOLEAN) ((X CHARACTER-WRAPPER) (Y OBJECT)))", Native.find_java_method("edu.isi.stella.CharacterWrapper", "objectEqlP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("EQL-TO-BOOLEAN?", "(DEFUN (EQL-TO-BOOLEAN? BOOLEAN) ((Y OBJECT) (X BOOLEAN)))", Native.find_java_method("edu.isi.stella.Stella_Object", "eqlToBooleanP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("EQL-TO-INTEGER?", "(DEFUN (EQL-TO-INTEGER? BOOLEAN) ((Y OBJECT) (X INTEGER)))", Native.find_java_method("edu.isi.stella.Stella_Object", "eqlToIntegerP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("EQL-TO-LONG-INTEGER?", "(DEFUN (EQL-TO-LONG-INTEGER? BOOLEAN) ((Y OBJECT) (X LONG-INTEGER)))", Native.find_java_method("edu.isi.stella.Stella_Object", "eqlToLongIntegerP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Long.TYPE}), null);
      Stella.defineFunctionObject("EQL-TO-FLOAT?", "(DEFUN (EQL-TO-FLOAT? BOOLEAN) ((Y OBJECT) (X FLOAT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "eqlToFloatP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Double.TYPE}), null);
      Stella.defineFunctionObject("EQL-TO-STRING?", "(DEFUN (EQL-TO-STRING? BOOLEAN) ((Y OBJECT) (X STRING)))", Native.find_java_method("edu.isi.stella.Stella_Object", "eqlToStringP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("EQL-TO-CHARACTER?", "(DEFUN (EQL-TO-CHARACTER? BOOLEAN) ((Y OBJECT) (X CHARACTER)))", Native.find_java_method("edu.isi.stella.Stella_Object", "eqlToCharacterP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Character.TYPE}), null);
      Stella.defineFunctionObject("HELP-BQUOTIFY", "(DEFUN (HELP-BQUOTIFY OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "helpBquotify", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
    }
  }

  public static void startupLiterals() {
    if (Stella.currentStartupTimePhaseP(0)) {
      Stella.ZERO_WRAPPER = IntegerWrapper.newIntegerWrapper(0);
      Stella.ONE_WRAPPER = IntegerWrapper.newIntegerWrapper(1);
      Stella.FALSE_WRAPPER = BooleanWrapper.newBooleanWrapper(false);
      Stella.TRUE_WRAPPER = BooleanWrapper.newBooleanWrapper(true);
      Stella.NULL_INTEGER_WRAPPER = IntegerWrapper.newIntegerWrapper(Stella.NULL_INTEGER);
      Stella.NULL_LONG_INTEGER_WRAPPER = LongIntegerWrapper.newLongIntegerWrapper(Stella.NULL_LONG_INTEGER);
      Stella.NULL_FLOAT_WRAPPER = FloatWrapper.newFloatWrapper(Stella.NULL_FLOAT);
      Stella.NULL_STRING_WRAPPER = StringWrapper.newStringWrapper(null);
      Stella.NULL_MUTABLE_STRING_WRAPPER = MutableStringWrapper.newMutableStringWrapper(null);
      Stella.NULL_CHARACTER_WRAPPER = CharacterWrapper.newCharacterWrapper(Stella.NULL_CHARACTER);
      Stella.NULL_FUNCTION_CODE_WRAPPER = FunctionCodeWrapper.newFunctionCodeWrapper(null);
      Stella.NULL_METHOD_CODE_WRAPPER = MethodCodeWrapper.newMethodCodeWrapper(((java.lang.reflect.Method)(null)));
    }
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupLiterals.helpStartupLiterals1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          _StartupLiterals.helpStartupLiterals2();
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupLiterals.helpStartupLiterals3();
          Stella.defineFunctionObject("BQUOTIFY", "(DEFUN (BQUOTIFY OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "bquotify", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("EXPAND-BQUOTE-TREE", "(DEFUN (EXPAND-BQUOTE-TREE OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "expandBquoteTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SIMPLIFY-BQUOTE-TREE", "(DEFUN (SIMPLIFY-BQUOTE-TREE OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "simplifyBquoteTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineMethodObject("(DEFMETHOD (PERMANENTIFY OBJECT) ((SELF OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "permanentify", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (PERMANENTIFY SYMBOL) ((SELF SYMBOL)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Symbol", "permanentify", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (PERMANENTIFY SYMBOL) ((SELF TRANSIENT-SYMBOL)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.TransientSymbol", "permanentify", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (PERMANENTIFY LITERAL-WRAPPER) ((SELF LITERAL-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.LiteralWrapper", "permanentify", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("PERMANENT-COPY", "(DEFUN (PERMANENT-COPY OBJECT) ((TREE OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "permanentCopy", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineMethodObject("(DEFMETHOD (SOFT-PERMANENTIFY SYMBOL) ((SYMBOL SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "softPermanentify", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (SOFT-PERMANENTIFY SYMBOL) ((SYMBOL TRANSIENT-SYMBOL)))", Native.find_java_method("edu.isi.stella.TransientSymbol", "softPermanentify", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("PRINT-CHARACTER", "(DEFUN PRINT-CHARACTER ((CHAR CHARACTER) (STREAM NATIVE-OUTPUT-STREAM)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "printCharacter", new java.lang.Class [] {java.lang.Character.TYPE, Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), null);
          Stella.defineFunctionObject("CREATE-CHARACTER-TYPE-TABLE", "(DEFUN (CREATE-CHARACTER-TYPE-TABLE (ARRAY (256) OF KEYWORD)) ())", Native.find_java_method("edu.isi.stella.Stella", "createCharacterTypeTable", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("DIGIT-CHARACTER?", "(DEFUN (DIGIT-CHARACTER? BOOLEAN) ((CH CHARACTER)) :DOCUMENTATION \"Return TRUE if `ch' represents a digit.\" :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (EQL? (AREF *CHARACTER-TYPE-TABLE* (CHARACTER-CODE CH)) :DIGIT)))", Native.find_java_method("edu.isi.stella.Stella", "digitCharacterP", new java.lang.Class [] {java.lang.Character.TYPE}), null);
          Stella.defineFunctionObject("LETTER-CHARACTER?", "(DEFUN (LETTER-CHARACTER? BOOLEAN) ((CH CHARACTER)) :DOCUMENTATION \"Return TRUE if `ch' represents a letter.\" :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (EQL? (AREF *CHARACTER-TYPE-TABLE* (CHARACTER-CODE CH)) :LETTER)))", Native.find_java_method("edu.isi.stella.Stella", "letterCharacterP", new java.lang.Class [] {java.lang.Character.TYPE}), null);
          Stella.defineFunctionObject("UPPER-CASE-CHARACTER?", "(DEFUN (UPPER-CASE-CHARACTER? BOOLEAN) ((CH CHARACTER)) :PUBLIC? TRUE :DOCUMENTATION \"Return TRUE if `ch' represents an upper-case character.\")", Native.find_java_method("edu.isi.stella.Stella", "upperCaseCharacterP", new java.lang.Class [] {java.lang.Character.TYPE}), null);
          Stella.defineFunctionObject("LOWER-CASE-CHARACTER?", "(DEFUN (LOWER-CASE-CHARACTER? BOOLEAN) ((CH CHARACTER)) :PUBLIC? TRUE :DOCUMENTATION \"Return TRUE if `ch' represents a lower-case character.\")", Native.find_java_method("edu.isi.stella.Stella", "lowerCaseCharacterP", new java.lang.Class [] {java.lang.Character.TYPE}), null);
          Stella.defineFunctionObject("WHITE-SPACE-CHARACTER?", "(DEFUN (WHITE-SPACE-CHARACTER? BOOLEAN) ((CH CHARACTER)) :DOCUMENTATION \"Return TRUE if `ch' is a white space character.\" :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (EQL? (AREF *CHARACTER-TYPE-TABLE* (CHARACTER-CODE CH)) :WHITE-SPACE)))", Native.find_java_method("edu.isi.stella.Stella", "whiteSpaceCharacterP", new java.lang.Class [] {java.lang.Character.TYPE}), null);
          Stella.defineFunctionObject("ALL-UPPER-CASE-STRING?", "(DEFUN (ALL-UPPER-CASE-STRING? BOOLEAN) ((S STRING)) :DOCUMENTATION \"Return TRUE if all letters in `s' are upper case.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "allUpperCaseStringP", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("ALL-LOWER-CASE-STRING?", "(DEFUN (ALL-LOWER-CASE-STRING? BOOLEAN) ((S STRING)) :DOCUMENTATION \"Return TRUE if all letters in `s' are lower case.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "allLowerCaseStringP", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("INITIALIZE-CHARACTER-UPCASE-TABLE", "(DEFUN (INITIALIZE-CHARACTER-UPCASE-TABLE STRING) ())", Native.find_java_method("edu.isi.stella.Stella", "initializeCharacterUpcaseTable", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("INITIALIZE-CHARACTER-DOWNCASE-TABLE", "(DEFUN (INITIALIZE-CHARACTER-DOWNCASE-TABLE STRING) ())", Native.find_java_method("edu.isi.stella.Stella", "initializeCharacterDowncaseTable", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("UPCASE-CHARACTER", "(DEFUN (UPCASE-CHARACTER CHARACTER) ((CHAR CHARACTER)) :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE :DOCUMENTATION \"If `char' is lowercase, return its uppercase version,\notherwise, return 'char' unmodified.\" (RETURN (NTH *CHARACTER-UPCASE-TABLE* (CHARACTER-CODE CHAR))))", Native.find_java_method("edu.isi.stella.Stella", "upcaseCharacter", new java.lang.Class [] {java.lang.Character.TYPE}), null);
          Stella.defineFunctionObject("DOWNCASE-CHARACTER", "(DEFUN (DOWNCASE-CHARACTER CHARACTER) ((CHAR CHARACTER)) :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE :DOCUMENTATION \"If `char' is uppercase, return its lowercase version,\notherwise, return 'char' unmodified.\" (RETURN (NTH *CHARACTER-DOWNCASE-TABLE* (CHARACTER-CODE CHAR))))", Native.find_java_method("edu.isi.stella.Stella", "downcaseCharacter", new java.lang.Class [] {java.lang.Character.TYPE}), null);
          Stella.defineFunctionObject("PRINT-STRING-READABLY", "(DEFUN PRINT-STRING-READABLY ((STRING STRING) (STREAM NATIVE-OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.Stella", "printStringReadably", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), null);
          Stella.defineFunctionObject("STRING-TO-MUTABLE-STRING", "(DEFUN (STRING-TO-MUTABLE-STRING MUTABLE-STRING) ((S STRING)) :DOCUMENTATION \"Copy `s' into a mutable string with the same content.\nIn Lisp and C++ this simply copies `s'.\" :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (VERBATIM :COMMON-LISP (CL:COPY-SEQ S) :CPP \"strcpy(new (GC) char[strlen(s)+1], s)\" :JAVA \"new StringBuffer(s)\")))", Native.find_java_method("edu.isi.stella.Stella", "stringToMutableString", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("MUTABLE-STRING-TO-STRING", "(DEFUN (MUTABLE-STRING-TO-STRING STRING) ((S MUTABLE-STRING)) :DOCUMENTATION \"Convert `s' into a regular string with the same content.\nIn Lisp and C++ this is a no-op.\" :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (VERBATIM :COMMON-LISP S :CPP \"s\" :JAVA \"s.toString()\")))", Native.find_java_method("edu.isi.stella.Stella", "mutableStringToString", new java.lang.Class [] {Native.find_java_class("java.lang.StringBuffer")}), null);
          Stella.defineMethodObject("(DEFMETHOD (NUMBER-WRAPPER-TO-FLOAT FLOAT) ((SELF OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "numberWrapperToFloat", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (NUMBER-WRAPPER-TO-FLOAT FLOAT) ((SELF INTEGER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.IntegerWrapper", "numberWrapperToFloat", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (NUMBER-WRAPPER-TO-FLOAT FLOAT) ((SELF LONG-INTEGER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.LongIntegerWrapper", "numberWrapperToFloat", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (NUMBER-WRAPPER-TO-FLOAT FLOAT) ((SELF FLOAT-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.FloatWrapper", "numberWrapperToFloat", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("STARTUP-LITERALS", "(DEFUN STARTUP-LITERALS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupLiterals", "startupLiterals", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_LITERALS);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupLiterals"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL ZERO-WRAPPER INTEGER-WRAPPER NULL :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL ONE-WRAPPER INTEGER-WRAPPER NULL :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL TRUE-WRAPPER BOOLEAN-WRAPPER NULL :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL FALSE-WRAPPER BOOLEAN-WRAPPER NULL :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL NULL-INTEGER-WRAPPER INTEGER-WRAPPER NULL :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL NULL-LONG-INTEGER-WRAPPER LONG-INTEGER-WRAPPER NULL :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL NULL-FLOAT-WRAPPER FLOAT-WRAPPER NULL :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL NULL-STRING-WRAPPER STRING-WRAPPER NULL :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL NULL-MUTABLE-STRING-WRAPPER MUTABLE-STRING-WRAPPER NULL :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL NULL-CHARACTER-WRAPPER CHARACTER-WRAPPER NULL :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL NULL-FUNCTION-CODE-WRAPPER FUNCTION-CODE-WRAPPER NULL :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL NULL-METHOD-CODE-WRAPPER METHOD-CODE-WRAPPER NULL :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *LITERAL-TYPE-INFO-TABLE* (HASH-TABLE OF TYPE (KEY-VALUE-LIST OF KEYWORD OBJECT)) (NEW HASH-TABLE) :DOCUMENTATION \"Table that holds a variety of information about literal\ntypes, e.g., the name of their null-wrapper, wrap-function, etc.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *LITERAL-TYPES* (LIST OF TYPE) (NEW LIST) :DOCUMENTATION \"List of literal types stored in '*literal-type-info-table*'.\nMaintained for iteration purposes.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CHARACTER-TYPE-TABLE* (ARRAY (256) OF KEYWORD) (CREATE-CHARACTER-TYPE-TABLE) :DOCUMENTATION \"Table of character types.  Entry 'i' represents the type\nof the character whose 'char-code' equals 'i'.  Each character is classified \nby one of the following keywords: :DIGIT, :LETTER, :SYMBOL-CONSTITUENT, \n:SYMBOL-QUALIFIER, :ESCAPE, :DELIMITER, :WHITE-SPACE, or :OTHER.\" :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CHARACTER-UPCASE-TABLE* STRING (INITIALIZE-CHARACTER-UPCASE-TABLE))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CHARACTER-DOWNCASE-TABLE* STRING (INITIALIZE-CHARACTER-DOWNCASE-TABLE))");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
