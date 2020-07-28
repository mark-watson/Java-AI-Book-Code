//  -*- Mode: Java -*-
//
// _StartupCppOutput.java

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

public class _StartupCppOutput {
  static void helpStartupCppOutput1() {
    {
      Stella.SYM_STELLA_$CURRENT_STREAM$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("*CURRENT-STREAM*", null, 0)));
      Stella.SYM_STELLA_NEWLINE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NEWLINE", null, 0)));
      Stella.SYM_STELLA_CPP_NULL_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_NULL_VALUE", null, 0)));
      Stella.SYM_STELLA_ASSIGN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ASSIGN", null, 0)));
      Stella.SYM_STELLA_SCOLON = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SCOLON", null, 0)));
      Stella.SYM_STELLA_LPAREN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LPAREN", null, 0)));
      Stella.SYM_STELLA_RPAREN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RPAREN", null, 0)));
      Stella.SYM_STELLA_CPP_NEW = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_NEW", null, 0)));
      Stella.SYM_STELLA_CPP_THROW = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_THROW", null, 0)));
      Stella.KWD_PRIVATE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PRIVATE", null, 2)));
      Stella.KWD_PROTECTED = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PROTECTED", null, 2)));
      Stella.SYM_STELLA_STARTUP_CPP_OUTPUT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-CPP-OUTPUT", null, 0)));
    }
  }

  static void helpStartupCppOutput2() {
    {
      Stella.defineFunctionObject("CPP-OUTPUT-TO-STRING", "(DEFUN CPP-OUTPUT-TO-STRING ((STATEMENT CONS)) :TYPE OBJECT :MACRO? TRUE)", Native.find_java_method("edu.isi.stella.Cons", "cppOutputToString", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-PARSE-TREE", "(DEFUN CPP-OUTPUT-PARSE-TREE ((CONSTREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputParseTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-FLATTEN-STATEMENTS", "(DEFUN (CPP-FLATTEN-STATEMENTS CONS) ((STATEMENTS CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppFlattenStatements", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-PROGNIFY-STATEMENT", "(DEFUN (CPP-PROGNIFY-STATEMENT CONS) ((STATEMENT OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "cppPrognifyStatement", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CPP-STATEMENT-TO-LIST", "(DEFUN (CPP-STATEMENT-TO-LIST CONS) ((STATEMENT OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "cppStatementToList", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-STATEMENT", "(DEFUN CPP-OUTPUT-STATEMENT ((STATEMENT OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "cppOutputStatement", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-VERBATIM", "(DEFUN CPP-OUTPUT-VERBATIM ((VERBATIMSTATEMENT STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.StringWrapper", "cppOutputVerbatim", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-COMMENT", "(DEFUN CPP-OUTPUT-COMMENT ((TREE STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.StringWrapper", "cppOutputComment", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-DEREFERENCE", "(DEFUN CPP-OUTPUT-DEREFERENCE ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputDereference", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-ARRAY-REFERENCE", "(DEFUN CPP-OUTPUT-ARRAY-REFERENCE ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputArrayReference", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-CAST", "(DEFUN CPP-OUTPUT-CAST ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputCast", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-SIGNAL", "(DEFUN CPP-OUTPUT-SIGNAL ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputSignal", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-HANDLER-CASE", "(DEFUN CPP-OUTPUT-HANDLER-CASE ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputHandlerCase", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-CATCH", "(DEFUN CPP-OUTPUT-CATCH ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputCatch", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-UNWIND-PROTECT", "(DEFUN CPP-OUTPUT-UNWIND-PROTECT ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputUnwindProtect", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-GLOBAL-DECLARATION", "(DEFUN CPP-OUTPUT-GLOBAL-DECLARATION ((GLOBAL CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputGlobalDeclaration", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-VARIABLE-DEFINITION", "(DEFUN CPP-OUTPUT-VARIABLE-DEFINITION ((VARIABLE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputVariableDefinition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-FUNCALL-FUNCTION-SIGNATURE", "(DEFUN CPP-OUTPUT-FUNCALL-FUNCTION-SIGNATURE ((SIGNATURE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputFuncallFunctionSignature", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-METHOD-CODE-CALL-SIGNATURE", "(DEFUN CPP-OUTPUT-METHOD-CODE-CALL-SIGNATURE ((SIGNATURE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputMethodCodeCallSignature", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-FUNCALL", "(DEFUN CPP-OUTPUT-FUNCALL ((FUNCALL CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputFuncall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-METHOD-CODE-CALL", "(DEFUN CPP-OUTPUT-METHOD-CODE-CALL ((METHODCALL CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputMethodCodeCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-BREAK", "(DEFUN CPP-OUTPUT-BREAK ())", Native.find_java_method("edu.isi.stella.Stella", "cppOutputBreak", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-CONTINUE", "(DEFUN CPP-OUTPUT-CONTINUE ())", Native.find_java_method("edu.isi.stella.Stella", "cppOutputContinue", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("CPP-LAST-STATEMENT-IS-RETURN?", "(DEFUN (CPP-LAST-STATEMENT-IS-RETURN? BOOLEAN) ((STATEMENTS CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppLastStatementIsReturnP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-CASE", "(DEFUN CPP-OUTPUT-CASE ((CASE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputCase", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-COND", "(DEFUN CPP-OUTPUT-COND ((COND CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputCond", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-PROGN?", "(DEFUN (CPP-PROGN? BOOLEAN) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "cppPrognP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CPP-BLOCK?", "(DEFUN (CPP-BLOCK? BOOLEAN) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "cppBlockP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-IF", "(DEFUN CPP-OUTPUT-IF ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputIf", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-WHEN", "(DEFUN CPP-OUTPUT-WHEN ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputWhen", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-UNLESS", "(DEFUN CPP-OUTPUT-UNLESS ((TREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputUnless", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-ASSIGNMENT", "(DEFUN CPP-OUTPUT-ASSIGNMENT ((ASSIGNMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputAssignment", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-LOOP", "(DEFUN CPP-OUTPUT-LOOP ((LOOP CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputLoop", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-WHILE", "(DEFUN CPP-OUTPUT-WHILE ((LOOP CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputWhile", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-FOREACH", "(DEFUN CPP-OUTPUT-FOREACH ((LOOP CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputForeach", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-FUNCTION-POINTER", "(DEFUN CPP-OUTPUT-FUNCTION-POINTER ((FUNCTIONNAME STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.StringWrapper", "cppOutputFunctionPointer", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-METHOD-POINTER", "(DEFUN CPP-OUTPUT-METHOD-POINTER ((METHODNAME STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.StringWrapper", "cppOutputMethodPointer", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-SLOT-VALUE", "(DEFUN CPP-OUTPUT-SLOT-VALUE ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-REFERENCED-SLOT-VALUE", "(DEFUN CPP-OUTPUT-REFERENCED-SLOT-VALUE ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputReferencedSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-SLOT-VALUE-SETTER", "(DEFUN CPP-OUTPUT-SLOT-VALUE-SETTER ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputSlotValueSetter", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-MAKE", "(DEFUN CPP-OUTPUT-MAKE ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputMake", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CPP-BUMP-INDENT", "(DEFUN CPP-BUMP-INDENT ())", Native.find_java_method("edu.isi.stella.Stella", "cppBumpIndent", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("CPP-UNBUMP-INDENT", "(DEFUN CPP-UNBUMP-INDENT ())", Native.find_java_method("edu.isi.stella.Stella", "cppUnbumpIndent", new java.lang.Class [] {}), null);
      Stella.defineMethodObject("(DEFMETHOD CPP-OUTPUT-LITERAL ((OBJECT OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "cppOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD CPP-OUTPUT-LITERAL ((CHARACTER CHARACTER-WRAPPER)))", Native.find_java_method("edu.isi.stella.CharacterWrapper", "cppOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD CPP-OUTPUT-LITERAL ((INT INTEGER-WRAPPER)))", Native.find_java_method("edu.isi.stella.IntegerWrapper", "cppOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD CPP-OUTPUT-LITERAL ((INT LONG-INTEGER-WRAPPER)))", Native.find_java_method("edu.isi.stella.LongIntegerWrapper", "cppOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD CPP-OUTPUT-LITERAL ((FLOAT FLOAT-WRAPPER)))", Native.find_java_method("edu.isi.stella.FloatWrapper", "cppOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD CPP-OUTPUT-LITERAL ((BOOLEAN BOOLEAN-WRAPPER)))", Native.find_java_method("edu.isi.stella.BooleanWrapper", "cppOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD CPP-OUTPUT-LITERAL ((CONS CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("REPLACE-CHARACTER-WITH-SUBSTRING", "(DEFUN (REPLACE-CHARACTER-WITH-SUBSTRING STRING) ((STRING STRING) (NEW STRING) (CHARACTER CHARACTER)) :GLOBALLY-INLINE? TRUE (RETURN (REPLACE-SUBSTRINGS STRING NEW CHARACTER)))", Native.find_java_method("edu.isi.stella.Stella", "replaceCharacterWithSubstring", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), java.lang.Character.TYPE}), null);
      Stella.defineMethodObject("(DEFMETHOD CPP-OUTPUT-LITERAL ((STRING STRING)))", Native.find_java_method("edu.isi.stella.Stella", "string_cppOutputLiteral", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD CPP-OUTPUT-LITERAL ((STRING STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.StringWrapper", "cppOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD CPP-OUTPUT-LITERAL ((STRING MUTABLE-STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.MutableStringWrapper", "cppOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD CPP-OUTPUT-LITERAL ((TREE QUOTED-EXPRESSION)))", Native.find_java_method("edu.isi.stella.QuotedExpression", "cppOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD CPP-OUTPUT-LITERAL ((SYMBOL SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "cppOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD CPP-OUTPUT-LITERAL ((SURROGATE SURROGATE)))", Native.find_java_method("edu.isi.stella.Surrogate", "cppOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD CPP-OUTPUT-LITERAL ((KEYWORD KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "cppOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("CPP-OUTPUT-IDENTIFIER", "(DEFUN CPP-OUTPUT-IDENTIFIER ((IDENTIFIER STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.StringWrapper", "cppOutputIdentifier", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper")}), null);
      Stella.defineFunctionObject("CPP-OUTPUT-ATOMIC-EXPRESSION", "(DEFUN CPP-OUTPUT-ATOMIC-EXPRESSION ((ATOM OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "cppOutputAtomicExpression", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
    }
  }

  public static void startupCppOutput() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupCppOutput.helpStartupCppOutput1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Stella.$CPP_INDENT_CHARS$.setDefaultValue(new Integer(0));
          Stella.$OUTPUTTINGDEFPRINTp$.setDefaultValue(new Boolean(false));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupCppOutput.helpStartupCppOutput2();
          Stella.defineFunctionObject("CPP-INDENT", "(DEFUN CPP-INDENT ())", Native.find_java_method("edu.isi.stella.Stella", "cppIndent", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-SEMICOLON?", "(DEFUN (CPP-OUTPUT-SEMICOLON? BOOLEAN) ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputSemicolonP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-INDENT-STATEMENT?", "(DEFUN (CPP-INDENT-STATEMENT? BOOLEAN) ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppIndentStatementP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("ILLEGAL-CPP-STATEMENT?", "(DEFUN (ILLEGAL-CPP-STATEMENT? BOOLEAN) ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "illegalCppStatementP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-STATEMENTS", "(DEFUN CPP-OUTPUT-STATEMENTS ((STATEMENTLIST CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputStatements", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-MAYBE-OUTPUT-STATEMENT-WITH-PARENTHESES", "(DEFUN CPP-MAYBE-OUTPUT-STATEMENT-WITH-PARENTHESES ((STATEMENT OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "cppMaybeOutputStatementWithParentheses", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-STREAM-PRINT-ITEMS", "(DEFUN CPP-OUTPUT-STREAM-PRINT-ITEMS ((ITEMS CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputStreamPrintItems", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-PRINT-STREAM", "(DEFUN CPP-OUTPUT-PRINT-STREAM ((EXPS CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputPrintStream", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-PRINT-NATIVE-STREAM", "(DEFUN CPP-OUTPUT-PRINT-NATIVE-STREAM ((EXPS CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputPrintNativeStream", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-INDENTABLE-BINARY-OPERATOR?", "(DEFUN (CPP-INDENTABLE-BINARY-OPERATOR? BOOLEAN) ((OPERATOR STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.StringWrapper", "cppIndentableBinaryOperatorP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper")}), null);
          Stella.defineFunctionObject("CPP-COMMUTATIVE-BINARY-OPERATOR?", "(DEFUN (CPP-COMMUTATIVE-BINARY-OPERATOR? BOOLEAN) ((OPERATOR STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.StringWrapper", "cppCommutativeBinaryOperatorP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper")}), null);
          Stella.defineFunctionObject("CPP-BINARY-OPERATOR?", "(DEFUN (CPP-BINARY-OPERATOR? BOOLEAN) ((STATEMENT OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "cppBinaryOperatorP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CPP-OPERATOR?", "(DEFUN (CPP-OPERATOR? BOOLEAN) ((STATEMENT OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "cppOperatorP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CPP-ASSIGNMENT?", "(DEFUN (CPP-ASSIGNMENT? BOOLEAN) ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppAssignmentP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-UNARY-OPERATOR", "(DEFUN CPP-OUTPUT-UNARY-OPERATOR ((EXPRESSION CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputUnaryOperator", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-NESTED-OPERATOR-NEEDS-PARENTHESES?", "(DEFUN (CPP-NESTED-OPERATOR-NEEDS-PARENTHESES? BOOLEAN) ((OP STRING-WRAPPER) (NESTED OBJECT)))", Native.find_java_method("edu.isi.stella.StringWrapper", "cppNestedOperatorNeedsParenthesesP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CPP-HELP-OUTPUT-BINARY-OPERATOR", "(DEFUN CPP-HELP-OUTPUT-BINARY-OPERATOR ((EXPRESSION CONS) (NESTLEVEL INTEGER)))", Native.find_java_method("edu.isi.stella.Cons", "cppHelpOutputBinaryOperator", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-BINARY-OPERATOR", "(DEFUN CPP-OUTPUT-BINARY-OPERATOR ((EXPRESSION CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputBinaryOperator", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-TERNARY-OPERATOR", "(DEFUN CPP-OUTPUT-TERNARY-OPERATOR ((EXPRESSION CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputTernaryOperator", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-STATEMENT-LINE", "(DEFUN CPP-OUTPUT-STATEMENT-LINE ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputStatementLine", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-RETURN", "(DEFUN CPP-OUTPUT-RETURN ((RETURNSTATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputReturn", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-TYPE-EXPRESSION", "(DEFUN CPP-OUTPUT-TYPE-EXPRESSION ((TYPEEXPRESSION (CONS OF STRING-WRAPPER))))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputTypeExpression", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-TYPED-ENTITY", "(DEFUN CPP-OUTPUT-TYPED-ENTITY ((TYPE OBJECT) (ENTITY OBJECT) (INITIALVALUE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "cppOutputTypedEntity", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-DECLARATIONS", "(DEFUN CPP-OUTPUT-DECLARATIONS ((ACCESSCONTROLMODE KEYWORD) (DECLARATIONS (CONS OF CONS))))", Native.find_java_method("edu.isi.stella.Keyword", "cppOutputDeclarations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-SIGNATURE", "(DEFUN CPP-OUTPUT-SIGNATURE ((SIGNATURE CONS) (OUTPUTMETHODCLASS? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputSignature", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-SIGNATURES", "(DEFUN CPP-OUTPUT-SIGNATURES ((ACCESSCONTROLMODE KEYWORD) (SIGNATURES CONS)))", Native.find_java_method("edu.isi.stella.Keyword", "cppOutputSignatures", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-DEFINITIONS", "(DEFUN CPP-OUTPUT-DEFINITIONS ((ACCESSCONTROLMODE KEYWORD) (DEFINITIONS CONS)))", Native.find_java_method("edu.isi.stella.Keyword", "cppOutputDefinitions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-PROGN", "(DEFUN CPP-OUTPUT-PROGN ((PROGN CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputProgn", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-BLOCK", "(DEFUN CPP-OUTPUT-BLOCK ((BLOCK CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputBlock", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-WITH-PROCESS-LOCK", "(DEFUN CPP-OUTPUT-WITH-PROCESS-LOCK ((SYNCH CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputWithProcessLock", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-STATIC-MEMBER-VARS", "(DEFUN CPP-OUTPUT-STATIC-MEMBER-VARS ((CLASS STRING-WRAPPER) (DECLARATIONS (CONS OF CONS))))", Native.find_java_method("edu.isi.stella.StringWrapper", "cppOutputStaticMemberVars", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-DERIVED-CLASSES", "(DEFUN CPP-OUTPUT-DERIVED-CLASSES ((CLASSLIST CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputDerivedClasses", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-TEMPLATE-PARAMETERS", "(DEFUN CPP-OUTPUT-TEMPLATE-PARAMETERS ((PARAMETERS CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputTemplateParameters", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-TEMPLATE-CLASSES?", "(DEFUN (CPP-OUTPUT-TEMPLATE-CLASSES? BOOLEAN) ())", Native.find_java_method("edu.isi.stella.Stella", "cppOutputTemplateClassesP", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-CLASS", "(DEFUN CPP-OUTPUT-CLASS ((CLASSDEF CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputClass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-FORMAL-PARAMETERS", "(DEFUN CPP-OUTPUT-FORMAL-PARAMETERS ((PARAMETERS (CONS OF CONS))))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputFormalParameters", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-ARGUMENT-IS-STREAM?", "(DEFUN (CPP-ARGUMENT-IS-STREAM? BOOLEAN) ((ARG OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "cppArgumentIsStreamP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-ONE-ACTUAL-PARAMETER", "(DEFUN CPP-OUTPUT-ONE-ACTUAL-PARAMETER ((PARAMETER OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "cppOutputOneActualParameter", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-ACTUAL-PARAMETERS", "(DEFUN CPP-OUTPUT-ACTUAL-PARAMETERS ((PARAMETERS CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputActualParameters", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-METHOD-SETTER-CALL", "(DEFUN CPP-OUTPUT-METHOD-SETTER-CALL ((METHODSETTERCALL CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputMethodSetterCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-METHOD-CALL", "(DEFUN CPP-OUTPUT-METHOD-CALL ((METHODCALL CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputMethodCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-REFERENCED-METHOD-CALL", "(DEFUN CPP-OUTPUT-REFERENCED-METHOD-CALL ((METHODCALL CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputReferencedMethodCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-FUNCTION-CALL", "(DEFUN CPP-OUTPUT-FUNCTION-CALL ((FUNCTIONCALL CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputFunctionCall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-DEFPRINT-SIGNATURE", "(DEFUN CPP-OUTPUT-DEFPRINT-SIGNATURE ((DEFPRINT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputDefprintSignature", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-DEFPRINT", "(DEFUN CPP-OUTPUT-DEFPRINT ((DEFPRINT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputDefprint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-FUNCTION-SIGNATURE", "(DEFUN CPP-OUTPUT-FUNCTION-SIGNATURE ((FUNCTION CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputFunctionSignature", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-FUNCTION", "(DEFUN CPP-OUTPUT-FUNCTION ((FUNCTION CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputFunction", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-EXTERN-C", "(DEFUN CPP-OUTPUT-EXTERN-C ((STATEMENT CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputExternC", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("STARTUP-CPP-OUTPUT", "(DEFUN STARTUP-CPP-OUTPUT () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupCppOutput", "startupCppOutput", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_CPP_OUTPUT);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupCppOutput"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *CPP-INDENT-CHARS* INTEGER 0)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *OUTPUTTINGDEFPRINT?* BOOLEAN FALSE :DOCUMENTATION \"`true' when outputting a defprint, used to \n            conditionally dereference streams in print-native-stream \n            statements.  Also used to take the address of streams\n            when passed to functions inside of a defprint\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CPP-MAX-STRING-LITERAL-LENGTH* INTEGER 1024 :DOCUMENTATION \"C++ string literals longer than this are broken\ninto multiple pieces to avoid problems with certain MS compilers.\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
