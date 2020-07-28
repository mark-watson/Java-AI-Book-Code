//  -*- Mode: Java -*-
//
// _StartupIdlOutput.java

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

public class _StartupIdlOutput {
  public static void startupIdlOutput() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Stella.SYM_STELLA_IDL_COMMENT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IDL_COMMENT", null, 0)));
          Stella.SYM_STELLA_IDL_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IDL_TYPE", null, 0)));
          Stella.SYM_STELLA_IDL_VAR_ARGS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IDL_VAR_ARGS", null, 0)));
          Stella.SYM_STELLA_STARTUP_IDL_OUTPUT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-IDL-OUTPUT", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Stella.$IDL_INDENT_CHARS$.setDefaultValue(new Integer(0));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("IDL-OUTPUT-PARSE-TREE", "(DEFUN IDL-OUTPUT-PARSE-TREE ((CONSTREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "idlOutputParseTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("IDL-OUTPUT-STATEMENT", "(DEFUN IDL-OUTPUT-STATEMENT ((STATEMENT OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "idlOutputStatement", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("IDL-INDENT", "(DEFUN IDL-INDENT ())", Native.find_java_method("edu.isi.stella.Stella", "idlIndent", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("IDL-BUMP-INDENT", "(DEFUN IDL-BUMP-INDENT ())", Native.find_java_method("edu.isi.stella.Stella", "idlBumpIndent", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("IDL-UNBUMP-INDENT", "(DEFUN IDL-UNBUMP-INDENT ())", Native.find_java_method("edu.isi.stella.Stella", "idlUnbumpIndent", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("IDL-OUTPUT-TYPEDEF", "(DEFUN IDL-OUTPUT-TYPEDEF ((TYPEDEF CONS)))", Native.find_java_method("edu.isi.stella.Cons", "idlOutputTypedef", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("IDL-OUTPUT-ENUMERANDS", "(DEFUN IDL-OUTPUT-ENUMERANDS ((ENUMERANDS (CONS OF CONS))))", Native.find_java_method("edu.isi.stella.Cons", "idlOutputEnumerands", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("IDL-OUTPUT-ENUM", "(DEFUN IDL-OUTPUT-ENUM ((ENUM CONS)))", Native.find_java_method("edu.isi.stella.Cons", "idlOutputEnum", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("IDL-OUTPUT-TYPE-EXPRESSION", "(DEFUN IDL-OUTPUT-TYPE-EXPRESSION ((TYPEEXPRESSION (CONS OF STRING-WRAPPER))))", Native.find_java_method("edu.isi.stella.Cons", "idlOutputTypeExpression", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineMethodObject("(DEFMETHOD IDL-OUTPUT-LITERAL ((OBJECT OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "idlOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD IDL-OUTPUT-LITERAL ((STRING STRING)))", Native.find_java_method("edu.isi.stella.Stella", "string_idlOutputLiteral", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD IDL-OUTPUT-LITERAL ((STRING STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.StringWrapper", "idlOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD IDL-OUTPUT-LITERAL ((STRING MUTABLE-STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.MutableStringWrapper", "idlOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD IDL-OUTPUT-LITERAL ((TREE QUOTED-EXPRESSION)))", Native.find_java_method("edu.isi.stella.QuotedExpression", "idlOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD IDL-OUTPUT-LITERAL ((SYMBOL SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "idlOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD IDL-OUTPUT-LITERAL ((SURROGATE SURROGATE)))", Native.find_java_method("edu.isi.stella.Surrogate", "idlOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD IDL-OUTPUT-LITERAL ((KEYWORD KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "idlOutputLiteral", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("IDL-OUTPUT-ATOMIC-EXPRESSION", "(DEFUN IDL-OUTPUT-ATOMIC-EXPRESSION ((ATOM OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "idlOutputAtomicExpression", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("IDL-OUTPUT-COMMENT", "(DEFUN IDL-OUTPUT-COMMENT ((TREE STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.StringWrapper", "idlOutputComment", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper")}), null);
          Stella.defineFunctionObject("IDL-OUTPUT-IDENTIFIER", "(DEFUN IDL-OUTPUT-IDENTIFIER ((IDENTIFIER STRING-WRAPPER)))", Native.find_java_method("edu.isi.stella.StringWrapper", "idlOutputIdentifier", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper")}), null);
          Stella.defineFunctionObject("IDL-OUTPUT-DERIVED-CLASSES", "(DEFUN IDL-OUTPUT-DERIVED-CLASSES ((CLASS-LIST (CONS OF STRING-WRAPPER))))", Native.find_java_method("edu.isi.stella.Cons", "idlOutputDerivedClasses", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("IDL-OUTPUT-TEMPLATE-PARAMETERS", "(DEFUN IDL-OUTPUT-TEMPLATE-PARAMETERS ((PARAMETERS (CONS OF STRING-WRAPPER))))", Native.find_java_method("edu.isi.stella.Cons", "idlOutputTemplateParameters", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("IDL-OUTPUT-TEMPLATE-CLASSES?", "(DEFUN (IDL-OUTPUT-TEMPLATE-CLASSES? BOOLEAN) ())", Native.find_java_method("edu.isi.stella.Stella", "idlOutputTemplateClassesP", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("IDL-OUTPUT-INTERFACE", "(DEFUN IDL-OUTPUT-INTERFACE ((CLASSDEF CONS)))", Native.find_java_method("edu.isi.stella.Cons", "idlOutputInterface", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("IDL-OUTPUT-STRUCT", "(DEFUN IDL-OUTPUT-STRUCT ((CLASSDEF CONS)))", Native.find_java_method("edu.isi.stella.Cons", "idlOutputStruct", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("IDL-OUTPUT-ONE-FORMAL-PARAMETER", "(DEFUN IDL-OUTPUT-ONE-FORMAL-PARAMETER ((PARAMETER (CONS OF STRING-WRAPPER))))", Native.find_java_method("edu.isi.stella.Cons", "idlOutputOneFormalParameter", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("IDL-OUTPUT-FORMAL-PARAMETERS", "(DEFUN IDL-OUTPUT-FORMAL-PARAMETERS ((PARAMETERS (CONS OF CONS))))", Native.find_java_method("edu.isi.stella.Cons", "idlOutputFormalParameters", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("IDL-OUTPUT-FUNCTION-SIGNATURE", "(DEFUN IDL-OUTPUT-FUNCTION-SIGNATURE ((FUNCTION CONS)))", Native.find_java_method("edu.isi.stella.Cons", "idlOutputFunctionSignature", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("IDL-OUTPUT-DECLARATIONS", "(DEFUN IDL-OUTPUT-DECLARATIONS ((DECLARATIONS (CONS OF CONS))))", Native.find_java_method("edu.isi.stella.Cons", "idlOutputDeclarations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("IDL-OUTPUT-SIGNATURE", "(DEFUN IDL-OUTPUT-SIGNATURE ((SIGNATURE CONS) (OUTPUTMETHODCLASS? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Cons", "idlOutputSignature", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("IDL-OUTPUT-SIGNATURES", "(DEFUN IDL-OUTPUT-SIGNATURES ((SIGNATURES CONS)))", Native.find_java_method("edu.isi.stella.Cons", "idlOutputSignatures", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("STARTUP-IDL-OUTPUT", "(DEFUN STARTUP-IDL-OUTPUT () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupIdlOutput", "startupIdlOutput", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_IDL_OUTPUT);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupIdlOutput"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *IDL-INDENT-CHARS* INTEGER 0)");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
