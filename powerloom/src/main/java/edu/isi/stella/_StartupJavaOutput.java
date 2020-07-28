//  -*- Mode: Java -*-
//
// _StartupJavaOutput.java

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

public class _StartupJavaOutput {
  static void helpStartupJavaOutput1() {
    {
      Stella.SYM_STELLA_JAVA_THROW = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_THROW", null, 0)));
      Stella.SYM_STELLA_JAVA_ARRAY_INITIALIZER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_ARRAY_INITIALIZER", null, 0)));
      Stella.SYM_STELLA_JAVA_FUNCTION_POINTER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_FUNCTION_POINTER", null, 0)));
      Stella.SYM_STELLA_JAVA_METHOD_POINTER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_METHOD_POINTER", null, 0)));
      Stella.SYM_STELLA_JAVA_METHOD_SETTER_CALL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_METHOD_SETTER_CALL", null, 0)));
      Stella.SYM_STELLA_JAVA_NEW = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA_NEW", null, 0)));
      Stella.SYM_STELLA_STARTUP_JAVA_OUTPUT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-JAVA-OUTPUT", null, 0)));
    }
  }

  static void helpStartupJavaOutput2() {
    {
      Stella.defineFunctionObject("JAVA-STELLA-PACKAGE", "(DEFUN (JAVA-STELLA-PACKAGE STRING) ())", Native.find_java_method("edu.isi.stella.Stella", "javaStellaPackage", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-PARSE-TREE", "(DEFUN JAVA-OUTPUT-PARSE-TREE ((CONSTREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputParseTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-BUMP-INDENT", "(DEFUN JAVA-BUMP-INDENT ())", Native.find_java_method("edu.isi.stella.Stella", "javaBumpIndent", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("JAVA-UNBUMP-INDENT", "(DEFUN JAVA-UNBUMP-INDENT ())", Native.find_java_method("edu.isi.stella.Stella", "javaUnbumpIndent", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("JAVA-INDENT", "(DEFUN JAVA-INDENT ())", Native.find_java_method("edu.isi.stella.Stella", "javaIndent", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-STATEMENT", "(DEFUN JAVA-OUTPUT-STATEMENT ((STATEMENT OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "javaOutputStatement", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("JAVA-MAYBE-OUTPUT-STATEMENT-WITH-PARENTHESES", "(DEFUN JAVA-MAYBE-OUTPUT-STATEMENT-WITH-PARENTHESES ((STATEMENT OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "javaMaybeOutputStatementWithParentheses", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-IDENTIFIER", "(DEFUN JAVA-OUTPUT-IDENTIFIER ((IDENTIFIER STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.StringWrapper", "javaOutputIdentifier", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper")}), null);
      Stella.defineMethodObject("(DEFMETHOD JAVA-OUTPUT-LITERAL ((OBJECT OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "javaOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD JAVA-OUTPUT-LITERAL ((STRING STRING)))", Native.find_java_method("edu.isi.stella.Stella", "string_javaOutputLiteral", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD JAVA-OUTPUT-LITERAL ((STRING STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.StringWrapper", "javaOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD JAVA-OUTPUT-LITERAL ((STRING MUTABLE-STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.MutableStringWrapper", "javaOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD JAVA-OUTPUT-LITERAL ((CHARACTER CHARACTER-WRAPPER)))", Native.find_java_method("edu.isi.stella.CharacterWrapper", "javaOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD JAVA-OUTPUT-LITERAL ((INT INTEGER-WRAPPER)))", Native.find_java_method("edu.isi.stella.IntegerWrapper", "javaOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD JAVA-OUTPUT-LITERAL ((INT LONG-INTEGER-WRAPPER)))", Native.find_java_method("edu.isi.stella.LongIntegerWrapper", "javaOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD JAVA-OUTPUT-LITERAL ((FLOAT FLOAT-WRAPPER)))", Native.find_java_method("edu.isi.stella.FloatWrapper", "javaOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD JAVA-OUTPUT-LITERAL ((BOOLEAN BOOLEAN-WRAPPER)))", Native.find_java_method("edu.isi.stella.BooleanWrapper", "javaOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("JAVA-OUTPUT-MAKE-ARRAY", "(DEFUN JAVA-OUTPUT-MAKE-ARRAY ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputMakeArray", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-ARRAY", "(DEFUN JAVA-OUTPUT-ARRAY ((ARRAYELEMENTS CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputArray", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-ANONYMOUS-ARRAY", "(DEFUN JAVA-OUTPUT-ANONYMOUS-ARRAY ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputAnonymousArray", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-AREF", "(DEFUN JAVA-OUTPUT-AREF ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputAref", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-SLOT-VALUE", "(DEFUN JAVA-OUTPUT-SLOT-VALUE ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-SLOT-VALUE-SETTER", "(DEFUN JAVA-OUTPUT-SLOT-VALUE-SETTER ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputSlotValueSetter", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-IMPLEMENTS-INTERFACES", "(DEFUN JAVA-OUTPUT-IMPLEMENTS-INTERFACES ((INTERFACELIST (CONS OF STRING-WRAPPER))))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputImplementsInterfaces", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-CLASS", "(DEFUN JAVA-OUTPUT-CLASS ((CLASSDEF CONS) (EXCEPTIONCLASS? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputClass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-CLASS-DECLARATION", "(DEFUN JAVA-OUTPUT-CLASS-DECLARATION ((CLASSDEF CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputClassDeclaration", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-CLASS-VARIABLE-DEFINITIONS", "(DEFUN JAVA-OUTPUT-CLASS-VARIABLE-DEFINITIONS ((VARIABLETRANSLATIONS CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputClassVariableDefinitions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-CLASS-CONSTRUCTORS", "(DEFUN JAVA-OUTPUT-CLASS-CONSTRUCTORS ((CONSTRUCTORS (CONS OF TRANSLATION-UNIT)) (CLASSNAME STRING) (EXCEPTIONCLASS? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputClassConstructors", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("java.lang.String"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-CLASS-METHODS", "(DEFUN JAVA-OUTPUT-CLASS-METHODS ((METHODS (CONS OF TRANSLATION-UNIT))))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputClassMethods", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-EXCEPTION-CONSTRUCTOR", "(DEFUN JAVA-OUTPUT-EXCEPTION-CONSTRUCTOR ((EXCEPTIONNAME STRING)))", Native.find_java_method("edu.isi.stella.Stella", "javaOutputExceptionConstructor", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-NAMED-STATEMENT", "(DEFUN JAVA-OUTPUT-NAMED-STATEMENT ((NAMEDSTATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputNamedStatement", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-FORMAL-PARAMETERS", "(DEFUN JAVA-OUTPUT-FORMAL-PARAMETERS ((PARAMETERS (CONS OF CONS))))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputFormalParameters", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-METHOD-SIGNATURE", "(DEFUN JAVA-OUTPUT-METHOD-SIGNATURE ((METHOD CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputMethodSignature", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-SEPARATE-COMMENT-FROM-BODY", "(DEFUN (JAVA-SEPARATE-COMMENT-FROM-BODY CONS CONS) ((BODY CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaSeparateCommentFromBody", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-METHOD", "(DEFUN JAVA-OUTPUT-METHOD ((METHOD CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputMethod", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineMethodObject("(DEFMETHOD JAVA-OUTPUT-LITERAL ((CONS CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD JAVA-OUTPUT-LITERAL ((TREE QUOTED-EXPRESSION)))", Native.find_java_method("edu.isi.stella.QuotedExpression", "javaOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD JAVA-OUTPUT-LITERAL ((SYMBOL SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "javaOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD JAVA-OUTPUT-LITERAL ((SURROGATE SURROGATE)))", Native.find_java_method("edu.isi.stella.Surrogate", "javaOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD JAVA-OUTPUT-LITERAL ((KEYWORD KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "javaOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("JAVA-OUTPUT-TYPE-EXPRESSION", "(DEFUN JAVA-OUTPUT-TYPE-EXPRESSION ((TYPEEXPRESSION (CONS OF STRING-WRAPPER))))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputTypeExpression", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-SEMICOLON?", "(DEFUN (JAVA-OUTPUT-SEMICOLON? BOOLEAN) ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputSemicolonP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-INDENT-STATEMENT?", "(DEFUN (JAVA-INDENT-STATEMENT? BOOLEAN) ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaIndentStatementP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-ILLEGAL-STATEMENT?", "(DEFUN (JAVA-ILLEGAL-STATEMENT? BOOLEAN) ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaIllegalStatementP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-STATEMENTS", "(DEFUN JAVA-OUTPUT-STATEMENTS ((STATEMENTLIST CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputStatements", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-DECLARATIONS", "(DEFUN JAVA-OUTPUT-DECLARATIONS ((DECLARATIONS (CONS OF CONS))))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputDeclarations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-HEURISTICALLY-TRANSLATE-NAME", "(DEFUN (JAVA-HEURISTICALLY-TRANSLATE-NAME STRING) ((STELLA-NAME STRING) (CASE-CONVERTED-NAME-LIST (CONS OF STRING-WRAPPER))))", Native.find_java_method("edu.isi.stella.Stella", "javaHeuristicallyTranslateName", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-COMMENT-STRING", "(DEFUN JAVA-OUTPUT-COMMENT-STRING ((COMMENT STRING) (COMMENT-START STRING) (COMMENT-CONTINUATION STRING) (COMMENT-END STRING) (JAVADOC-COMMENT? BOOLEAN) (CASE-CONVERTED-NAME-LIST (CONS OF STRING-WRAPPER))))", Native.find_java_method("edu.isi.stella.Stella", "javaOutputCommentString", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), java.lang.Boolean.TYPE, Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-COMMENT", "(DEFUN JAVA-OUTPUT-COMMENT ((TREE STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.StringWrapper", "javaOutputComment", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-JAVADOC-COMMENT", "(DEFUN JAVA-OUTPUT-JAVADOC-COMMENT ((TREE STRING-WRAPPER) (PARAMETER-NAMES-AND-TYPES (CONS OF (CONS OF STRING-WRAPPER))) (RETURN-VALUE STRING-WRAPPER) (AUTHOR STRING) (VERSION STRING)))", Native.find_java_method("edu.isi.stella.StringWrapper", "javaOutputJavadocComment", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.StringWrapper"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("FIXUP-DOCUMENTATION-STRING-QUOTING", "(DEFUN (FIXUP-DOCUMENTATION-STRING-QUOTING STRING) ((DOCUMENTATION STRING)))", Native.find_java_method("edu.isi.stella.Stella", "fixupDocumentationStringQuoting", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-VERBATIM", "(DEFUN JAVA-OUTPUT-VERBATIM ((VERBATIMSTATEMENT STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.StringWrapper", "javaOutputVerbatim", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-MAKE", "(DEFUN JAVA-OUTPUT-MAKE ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputMake", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-CAST", "(DEFUN JAVA-OUTPUT-CAST ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputCast", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-PROGN", "(DEFUN JAVA-OUTPUT-PROGN ((PROGN CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputProgn", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-BLOCK", "(DEFUN JAVA-OUTPUT-BLOCK ((BLOCK CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputBlock", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-WITH-PROCESS-LOCK", "(DEFUN JAVA-OUTPUT-WITH-PROCESS-LOCK ((SYNCH CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputWithProcessLock", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-RETURN", "(DEFUN JAVA-OUTPUT-RETURN ((RETURNSTATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputReturn", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-THROW", "(DEFUN JAVA-OUTPUT-THROW ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputThrow", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("JAVA-OUTPUT-CATCH", "(DEFUN JAVA-OUTPUT-CATCH ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputCatch", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
    }
  }

  public static void startupJavaOutput() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupJavaOutput.helpStartupJavaOutput1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Stella.$JAVA_INDENT_CHARS$.setDefaultValue(new Integer(0));
          Stella.$JAVA_STELLA_PACKAGE_MAPPING$ = KeyValueList.newKeyValueList();
          Stella.$JAVA_SEMICOLON_STATEMENTS$ = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_ASSIGN, Cons.cons(Stella.SYM_STELLA_JAVA_UNARY_OP, Cons.cons(Stella.SYM_STELLA_JAVA_BINARY_OP, Cons.cons(Stella.SYM_STELLA_JAVA_TERNARY_OP, Cons.cons(Stella.SYM_STELLA_JAVA_CAST, Cons.cons(Stella.SYM_STELLA_JAVA_FUNCALL, Cons.cons(Stella.SYM_STELLA_JAVA_FUNCTION_CALL, Cons.cons(Stella.SYM_STELLA_JAVA_FUNCTION_POINTER, Cons.cons(Stella.SYM_STELLA_JAVA_MAKE, Cons.cons(Stella.SYM_STELLA_JAVA_METHOD_CALL, Cons.cons(Stella.SYM_STELLA_JAVA_METHOD_CODE_CALL, Cons.cons(Stella.SYM_STELLA_JAVA_METHOD_POINTER, Cons.cons(Stella.SYM_STELLA_JAVA_METHOD_SETTER_CALL, Cons.cons(Stella.SYM_STELLA_JAVA_NEW, Cons.cons(Stella.SYM_STELLA_JAVA_PRINT_NATIVE_STREAM, Cons.cons(Stella.SYM_STELLA_JAVA_PRINT_STREAM, Cons.cons(Stella.SYM_STELLA_JAVA_RETURN, Cons.cons(Stella.SYM_STELLA_JAVA_SIGNAL, Cons.cons(Stella.SYM_STELLA_JAVA_SLOT_VALUE_SETTER, Cons.cons(Stella.SYM_STELLA_JAVA_THROW, Cons.cons(Stella.SYM_STELLA_JAVA_VERBATIM, Cons.cons(Stella.NIL, Stella.NIL)))))))))))))))))))))));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupJavaOutput.helpStartupJavaOutput2();
          Stella.defineFunctionObject("JAVA-OUTPUT-UNWIND-PROTECT", "(DEFUN JAVA-OUTPUT-UNWIND-PROTECT ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputUnwindProtect", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-HANDLER-CASE", "(DEFUN JAVA-OUTPUT-HANDLER-CASE ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputHandlerCase", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-SIGNAL", "(DEFUN JAVA-OUTPUT-SIGNAL ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputSignal", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-GLOBAL-DEFINITION", "(DEFUN JAVA-OUTPUT-GLOBAL-DEFINITION ((GLOBAL CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputGlobalDefinition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-ACTUALS-AS-CONS-EXPRESSION", "(DEFUN JAVA-OUTPUT-ACTUALS-AS-CONS-EXPRESSION ((ARGLIST CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputActualsAsConsExpression", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-FUNCALL", "(DEFUN JAVA-OUTPUT-FUNCALL ((FUNCALL CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputFuncall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-METHOD-CODE-CALL", "(DEFUN JAVA-OUTPUT-METHOD-CODE-CALL ((METHODCALL CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputMethodCodeCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-BREAK", "(DEFUN JAVA-OUTPUT-BREAK ((TAG CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputBreak", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-CONTINUE", "(DEFUN JAVA-OUTPUT-CONTINUE ((TAG CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputContinue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-STATEMENT-RETURNS?", "(DEFUN (JAVA-STATEMENT-RETURNS? BOOLEAN) ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaStatementReturnsP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-LAST-STATEMENT-RETURNS?", "(DEFUN (JAVA-LAST-STATEMENT-RETURNS? BOOLEAN) ((STATEMENTS CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaLastStatementReturnsP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-CASE", "(DEFUN JAVA-OUTPUT-CASE ((CASE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputCase", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-COND", "(DEFUN JAVA-OUTPUT-COND ((COND CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputCond", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-PROGN?", "(DEFUN (JAVA-PROGN? BOOLEAN) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "javaPrognP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("JAVA-BLOCK?", "(DEFUN (JAVA-BLOCK? BOOLEAN) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "javaBlockP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-IF", "(DEFUN JAVA-OUTPUT-IF ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputIf", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-WHEN", "(DEFUN JAVA-OUTPUT-WHEN ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputWhen", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-UNLESS", "(DEFUN JAVA-OUTPUT-UNLESS ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputUnless", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-ASSIGNMENT", "(DEFUN JAVA-OUTPUT-ASSIGNMENT ((ASSIGNMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputAssignment", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-LOOP", "(DEFUN JAVA-OUTPUT-LOOP ((LOOP CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputLoop", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-WHILE", "(DEFUN JAVA-OUTPUT-WHILE ((LOOP CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputWhile", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-FOREACH", "(DEFUN JAVA-OUTPUT-FOREACH ((LOOP CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputForeach", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-END-OF-LINE-TOKEN?", "(DEFUN (JAVA-END-OF-LINE-TOKEN? BOOLEAN) ((TOKEN OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "javaEndOfLineTokenP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-PRINT-STREAM", "(DEFUN JAVA-OUTPUT-PRINT-STREAM ((EXPS CONS) (NATIVESTREAM? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputPrintStream", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("JAVA-LITERAL-STRING?", "(DEFUN (JAVA-LITERAL-STRING? BOOLEAN) ((ITEM CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaLiteralStringP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-REVERSE-AND-CONSOLIDATE-STRINGS", "(DEFUN (JAVA-REVERSE-AND-CONSOLIDATE-STRINGS CONS) ((ITEMS (CONS OF CONS))))", Native.find_java_method("edu.isi.stella.Cons", "javaReverseAndConsolidateStrings", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-HELP-OUTPUT-PRINT-STREAM", "(DEFUN JAVA-HELP-OUTPUT-PRINT-STREAM ((STREAM OBJECT) (EXPS CONS) (NATIVESTREAM? BOOLEAN) (ENDOFLINE? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Stella_Object", "javaHelpOutputPrintStream", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE, java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("JAVA-INDENTABLE-BINARY-OPERATOR?", "(DEFUN (JAVA-INDENTABLE-BINARY-OPERATOR? BOOLEAN) ((OPERATOR STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.StringWrapper", "javaIndentableBinaryOperatorP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper")}), null);
          Stella.defineFunctionObject("JAVA-COMMUTATIVE-BINARY-OPERATOR?", "(DEFUN (JAVA-COMMUTATIVE-BINARY-OPERATOR? BOOLEAN) ((OPERATOR STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.StringWrapper", "javaCommutativeBinaryOperatorP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper")}), null);
          Stella.defineFunctionObject("JAVA-BINARY-OPERATOR?", "(DEFUN (JAVA-BINARY-OPERATOR? BOOLEAN) ((STATEMENT OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "javaBinaryOperatorP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("JAVA-OPERATOR?", "(DEFUN (JAVA-OPERATOR? BOOLEAN) ((STATEMENT OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "javaOperatorP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-UNARY-OPERATOR", "(DEFUN JAVA-OUTPUT-UNARY-OPERATOR ((EXPRESSION CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputUnaryOperator", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-NESTED-OPERATOR-NEEDS-PARENTHESES?", "(DEFUN (JAVA-NESTED-OPERATOR-NEEDS-PARENTHESES? BOOLEAN) ((OP STRING-WRAPPER) (NESTED OBJECT)))", Native.find_java_method("edu.isi.stella.StringWrapper", "javaNestedOperatorNeedsParenthesesP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("JAVA-HELP-OUTPUT-BINARY-OPERATOR", "(DEFUN JAVA-HELP-OUTPUT-BINARY-OPERATOR ((EXPRESSION CONS) (NESTLEVEL INTEGER)))", Native.find_java_method("edu.isi.stella.Cons", "javaHelpOutputBinaryOperator", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-BINARY-OPERATOR", "(DEFUN JAVA-OUTPUT-BINARY-OPERATOR ((EXPRESSION CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputBinaryOperator", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-TERNARY-OPERATOR", "(DEFUN JAVA-OUTPUT-TERNARY-OPERATOR ((EXPRESSION CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputTernaryOperator", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-METHOD-CALL", "(DEFUN JAVA-OUTPUT-METHOD-CALL ((METHODCALL CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputMethodCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-FUNCTION-CALL", "(DEFUN JAVA-OUTPUT-FUNCTION-CALL ((FUNCTIONCALL CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputFunctionCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-ACTUAL-PARAMETERS", "(DEFUN JAVA-OUTPUT-ACTUAL-PARAMETERS ((PARAMETERS CONS)))", Native.find_java_method("edu.isi.stella.Cons", "javaOutputActualParameters", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("STARTUP-JAVA-OUTPUT", "(DEFUN STARTUP-JAVA-OUTPUT () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupJavaOutput", "startupJavaOutput", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_JAVA_OUTPUT);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupJavaOutput"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *JAVA-INDENT-CHARS* INTEGER 0)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *JAVA-STELLA-PACKAGE-MAPPING* (KEY-VALUE-LIST OF STRING-WRAPPER STRING-WRAPPER) (NEW (KEY-VALUE-LIST OF STRING-WRAPPER STRING-WRAPPER)))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *JAVA-SEMICOLON-STATEMENTS* (CONS OF SYMBOL) (BQUOTE (JAVA_ASSIGN JAVA_UNARY_OP JAVA_BINARY_OP JAVA_TERNARY_OP JAVA_CAST JAVA_FUNCALL JAVA_FUNCTION_CALL JAVA_FUNCTION_POINTER JAVA_MAKE JAVA_METHOD_CALL JAVA_METHOD_CODE_CALL JAVA_METHOD_POINTER JAVA_METHOD_SETTER_CALL JAVA_NEW JAVA_PRINT_NATIVE_STREAM JAVA_PRINT_STREAM JAVA_RETURN JAVA_SIGNAL JAVA_SLOT_VALUE_SETTER JAVA_THROW JAVA_VERBATIM)))");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
