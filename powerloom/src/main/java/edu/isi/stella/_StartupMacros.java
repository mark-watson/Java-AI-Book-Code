//  -*- Mode: Java -*-
//
// _StartupMacros.java

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

public class _StartupMacros {
  public static void startupMacros() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Stella.SYM_STELLA_MEMBERp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MEMBER?", null, 0)));
          Stella.SYM_STELLA_FIRST_DEFINED = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FIRST-DEFINED", null, 0)));
          Stella.SYM_STELLA_$TRANSIENTOBJECTSp$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("*TRANSIENTOBJECTS?*", null, 0)));
          Stella.SYM_STELLA_$CONTEXT$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("*CONTEXT*", null, 0)));
          Stella.SYM_STELLA_SAFETY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SAFETY", null, 0)));
          Stella.SYM_STELLA_WORLD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WORLD", null, 0)));
          Stella.SYM_STELLA_$MODULE$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("*MODULE*", null, 0)));
          Stella.SYM_STELLA_$CURRENTSYSTEMDEFINITION$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("*CURRENTSYSTEMDEFINITION*", null, 0)));
          Stella.SYM_STELLA_GET_SYSTEM_DEFINITION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("GET-SYSTEM-DEFINITION", null, 0)));
          Stella.SYM_STELLA_$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("*CURRENTSYSTEMDEFINITIONSUBDIRECTORY*", null, 0)));
          Stella.SYM_STELLA_ONLY_IF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ONLY-IF", null, 0)));
          Stella.SYM_STELLA_WARN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WARN", null, 0)));
          Stella.KWD_STARTUP_SYSTEMp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-SYSTEM?", null, 2)));
          Stella.SYM_STELLA_IF_STELLA_FEATURE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IF-STELLA-FEATURE", null, 0)));
          Stella.SYM_STELLA_INTEGER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INTEGER", null, 0)));
          Stella.SYM_STELLA_ARRAY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ARRAY", null, 0)));
          Stella.SYM_STELLA_rrARGS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("%%ARGS", null, 0)));
          Stella.KWD_INITIAL_CONTENTS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INITIAL-CONTENTS", null, 2)));
          Stella.SYM_STELLA_STARTUP_MACROS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-MACROS", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("PUSHQ", "(DEFUN PUSHQ ((VARIABLE SYMBOL) (VALUE OBJECT)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Push 'value' onto the cons list 'variable'.\")", Native.find_java_method("edu.isi.stella.Symbol", "pushq", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("POPQ", "(DEFUN POPQ ((VARIABLE SYMBOL)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Pops a value from the cons list 'variable'.\")", Native.find_java_method("edu.isi.stella.Symbol", "popq", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("PUSHF", "(DEFUN PUSHF ((PLACE CONS) (VALUE OBJECT)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Push 'value' onto the cons list 'place'.\")", Native.find_java_method("edu.isi.stella.Cons", "pushf", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("PUSHQ-NEW", "(DEFUN PUSHQ-NEW ((VARIABLE SYMBOL) (VALUE OBJECT)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Push `value' onto the cons list `variable', unless `value'\nis already a member of the list.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Symbol", "pushqNew", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("++", "(DEFUN ++ ((PLACE OBJECT) |&BODY| (INCREMENT CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Increment the value of `place' and return the result.\n`place' can be either a variable name or a slot reference.  Increment by\nthe optional `increment' (which can be a float) or 1 otherwise.\")", Native.find_java_method("edu.isi.stella.Stella_Object", "stella_Increment", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("--", "(DEFUN -- ((PLACE OBJECT) |&BODY| (DECREMENT CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Decrement the value of `place' and return the result.\n`place' can be either a variable name or a slot reference.  Decrement by\nthe optional `decrement' (which can be a float) or 1 otherwise.\")", Native.find_java_method("edu.isi.stella.Stella_Object", "_", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("1+", "(DEFUN 1+ ((EXPRESSION OBJECT)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Add 1 to 'expression' and return the result.\")", Native.find_java_method("edu.isi.stella.Stella_Object", "oneI", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("1-", "(DEFUN 1- ((EXPRESSION OBJECT)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Subtract 1 from 'expression' and return the result.\")", Native.find_java_method("edu.isi.stella.Stella_Object", "one", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SETQ?", "(DEFUN SETQ? ((VARIABLE SYMBOL) (EXPRESSION CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Assign 'variable' the result of evaluating 'expression', \nand return TRUE if 'expression' is not NULL else return FALSE.\")", Native.find_java_method("edu.isi.stella.Symbol", "setqP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("FIRST-DEFINED", "(DEFUN FIRST-DEFINED (|&BODY| (FORMS CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Return the result of the first form in `forms' whose value is defined\nor NULL otherwise.\")", Native.find_java_method("edu.isi.stella.Cons", "firstDefined", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("ALL-DEFINED?", "(DEFUN ALL-DEFINED? (|&BODY| (FORMS CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Evaluate each of the forms in 'forms', and\nreturn TRUE if none of them are NULL.\")", Native.find_java_method("edu.isi.stella.Cons", "allDefinedP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("EITHER", "(DEFUN EITHER ((VALUE1 OBJECT) (VALUE2 OBJECT)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"If 'value1' is defined, return that, else return 'value2'.\")", Native.find_java_method("edu.isi.stella.Stella_Object", "either", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("COLLECT", "(DEFUN COLLECT (|&BODY| (BODY CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Use a VRLET to collect values.  Input can have one of\nthe following forms:\n	 \n  (collect <var> in <expression> [where <test> <var>])\n  (collect <collect-expression>\n           foreach <var> in <expression>\n           {as ...}*\n           [where <test> <var>]\n           [do ...])\n	\nThe second form really accepts an arbitrary `foreach' expression following\nthe `foreach' keyword.\")", Native.find_java_method("edu.isi.stella.Cons", "collect", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("WITH-PERMANENT-OBJECTS", "(DEFUN WITH-PERMANENT-OBJECTS (|&BODY| (BODY CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Allocate 'permanent' (as opposed to 'transient')\nobjects within the scope of this declaration.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Cons", "withPermanentObjects", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("WITH-TRANSIENT-OBJECTS", "(DEFUN WITH-TRANSIENT-OBJECTS (|&BODY| (BODY CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Allocate 'transient' (as opposed to 'permanent')\nobjects within the scope of this declaration.\nCAUTION: The default assumption is the allocation of permanent objects.\nThe scope of `with-transient-objects' should be as small as possible, and\nthe user has to make sure that code that wasn't explicitly written to\naccount for transient objects will continue to work correctly.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Cons", "withTransientObjects", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("IGNORE", "(DEFUN IGNORE (|&BODY| (VARIABLES CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Ignore unused 'variables' with NoOp 'setq' statements.\")", Native.find_java_method("edu.isi.stella.Cons", "ignore", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("ONLY-IF", "(DEFUN ONLY-IF ((TEST OBJECT) (EXPRESSION OBJECT)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"If 'test' is TRUE, return the result of evaluating \n'expression'.\")", Native.find_java_method("edu.isi.stella.Stella_Object", "onlyIf", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("PHASE-TO-INTEGER", "(DEFUN PHASE-TO-INTEGER ((STARTUPTIMEPHASE KEYWORD)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Expands into the integer representing 'startupTimePhase'.\")", Native.find_java_method("edu.isi.stella.Keyword", "phaseToInteger", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("IF-OUTPUT-LANGUAGE", "(DEFUN IF-OUTPUT-LANGUAGE ((LANGUAGE KEYWORD) (THENFORM OBJECT) (ELSEFORM OBJECT)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Expand to 'thenForm' if the current translator output\nlanguage equals 'language'.  Otherwise, expand to 'elseForm'.  This can\nbe used to conditionally translate Stella code.\")", Native.find_java_method("edu.isi.stella.Keyword", "ifOutputLanguage", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("IF-STELLA-FEATURE", "(DEFUN IF-STELLA-FEATURE ((FEATURE KEYWORD) (THENFORM OBJECT) (ELSEFORM OBJECT)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Expand to 'thenForm' if 'feature' is a currently enabled\nSTELLA environment feature.  Otherwise, expand to 'elseForm'.  This can\nbe used to conditionally translate Stella code.\")", Native.find_java_method("edu.isi.stella.Keyword", "ifStellaFeature", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("WITHIN-WORLD", "(DEFUN WITHIN-WORLD ((WORLDFORM OBJECT) |&BODY| (BODY CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Execute `body' within the world resulting from `worldForm'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "withinWorld", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("WITHIN-CONTEXT", "(DEFUN WITHIN-CONTEXT ((CONTEXTFORM OBJECT) |&BODY| (BODY CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Execute `body' within the context resulting from `contextForm'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "withinContext", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("WITHIN-MODULE", "(DEFUN WITHIN-MODULE ((MODULEFORM OBJECT) |&BODY| (BODY CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Execute `body' within the module resulting from `moduleForm'.\n`*module*' is an acceptable `moduleForm'.  It will locally rebind \n`*module*' and `*context*' and shield the outer bindings from changes.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "withinModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject(" |COERCE-&REST-TO-CONS|", "(DEFUN |COERCE-&REST-TO-CONS| ((RESTVARIABLE SYMBOL)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Coerce the argument list variable `restVariable' into a CONS\nlist containing all its elements (uses argument list iteration to do so).  If\n`restVariable' already is a CONS due to argument listification, this is a no-op.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Symbol", "coerceARestToCons", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("WITH-SYSTEM-DEFINITION", "(DEFUN WITH-SYSTEM-DEFINITION ((SYSTEMNAMEEXPRESSION OBJECT) |&BODY| (BODY CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Set *currentSystemDefinition* to the system definition named `system'.\nSet *currentSystemDefinitionSubdirectory* to match. Execute `body' within\nthat scope.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "withSystemDefinition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("DEFMAIN", "(DEFUN DEFMAIN ((VARLIST CONS) |&BODY| (BODY CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Defines a function called MAIN which will have the appropriate\nsignature for the target translation language.  The signature will be:\n  C++:   public static int main (int v1, char** v2) {<body>}\n  Java:  public static void main (String [] v2) {<body>}\n  Lisp:  (defun main (&rest args) <body>)\nThe argument `varList' must have two symbols, which will be the names for the\nINTEGER argument count and an array of STRINGs with the argument values.  It\ncan also be empty to indicate that no command line arguments will be handled.\nThe startup function for the containing system will automatically be called\nbefore `body' is executed unless the option :STARTUP-SYSTEM? was supplied as\nFALSE.  There can only be one DEFMAIN per module.\" :PUBLIC? TRUE :LISP-MACRO? TRUE)", Native.find_java_method("edu.isi.stella.Cons", "defmain", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("STARTUP-MACROS", "(DEFUN STARTUP-MACROS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupMacros", "startupMacros", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_MACROS);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupMacros"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
          Symbol.registerNativeName(Stella.SYM_STELLA___, Stella.KWD_JAVA, Stella.KWD_FUNCTION);
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
