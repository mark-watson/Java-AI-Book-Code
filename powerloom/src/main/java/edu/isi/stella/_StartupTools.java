//  -*- Mode: Java -*-
//
// _StartupTools.java

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

public class _StartupTools {
  public static void startupTools() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Stella.SYM_STELLA_STARTUP_TOOLS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-TOOLS", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("OUTLINE-DEPTH-EXCEEDED?", "(DEFUN (OUTLINE-DEPTH-EXCEEDED? BOOLEAN) ((CURRENT-DEPTH INTEGER) (DEPTH-LIMIT INTEGER)) :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE :DOCUMENTATION \"Helper function that returns `true' if `current-depth' exceeds `depth-limit'.\nThis functions uses the convention that a `null' or negative value of\n`depth-limit' means the depth is unlimited.  In those cases it always\nreturns false.\" (RETURN (AND (DEFINED? DEPTH-LIMIT) (>= DEPTH-LIMIT 0) (>= CURRENT-DEPTH DEPTH-LIMIT))))", Native.find_java_method("edu.isi.stella.Stella", "outlineDepthExceededP", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("INDENT-OUTLINE", "(DEFUN INDENT-OUTLINE ((CURRENT-DEPTH INTEGER) (STREAM OUTPUT-STREAM)) :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE :DOCUMENTATION \"Helper function that indents outline printings for level\n`current-depth' on `stream' using the value of the global\nvariable `*OUTLINE-INDENT-STRING*'\" (FOREACH I IN (INTERVAL 1 CURRENT-DEPTH) DO (IGNORE I) (PRINT-STREAM STREAM *OUTLINE-INDENT-STRING*)))", Native.find_java_method("edu.isi.stella.Stella", "indentOutline", new java.lang.Class [] {java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("PRINT-OUTLINE", "(DEFUN PRINT-OUTLINE ((THING OBJECT) (STREAM OUTPUT-STREAM) (DEPTH INTEGER) (NAMED? BOOLEAN)) :PUBLIC? TRUE :COMMAND? TRUE :DOCUMENTATION \"Print an outline of `thing' and its subparts on `stream'.\nIf `depth' is non-negative, only `depth' levels will be printed.\nIf `named?' is `TRUE', then only named entities will be printed.\n\nThis function is intended to be used on things like modules, contexts,\nconcepts, etc. that have hierarchical structure.  If `thing' doesn't\nhave a hierarchical structure, it will just be printed.\")", Native.find_java_method("edu.isi.stella.Stella_Object", "printOutline", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.OutputStream"), java.lang.Integer.TYPE, java.lang.Boolean.TYPE}), Native.find_java_method("edu.isi.stella.Cons", "printOutlineEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineMethodObject("(DEFMETHOD HELP-PRINT-OUTLINE ((TOP OBJECT) (STREAM OUTPUT-STREAM) (CURRENT-DEPTH INTEGER) (DEPTH INTEGER) (NAMED? BOOLEAN)) :PUBLIC? TRUE :DOCUMENTATION \"Helper method for `print-outline'\")", Native.find_java_method("edu.isi.stella.Stella_Object", "helpPrintOutline", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Boolean.TYPE}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD HELP-PRINT-OUTLINE ((TOP CONTEXT) (STREAM OUTPUT-STREAM) (CURRENT-DEPTH INTEGER) (DEPTH INTEGER) (NAMED? BOOLEAN)) :PUBLIC? TRUE :DOCUMENTATION \"Helper method for `print-outline'\")", Native.find_java_method("edu.isi.stella.Context", "helpPrintOutline", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Boolean.TYPE}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD HELP-PRINT-OUTLINE ((TOP MODULE) (STREAM OUTPUT-STREAM) (CURRENT-DEPTH INTEGER) (DEPTH INTEGER) (NAMED? BOOLEAN)) :PUBLIC? TRUE :DOCUMENTATION \"Helper method for `print-outline'\")", Native.find_java_method("edu.isi.stella.Module", "helpPrintOutline", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Boolean.TYPE}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD HELP-PRINT-OUTLINE ((TOP CLASS) (STREAM OUTPUT-STREAM) (CURRENT-DEPTH INTEGER) (DEPTH INTEGER) (NAMED? BOOLEAN)) :PUBLIC? TRUE :DOCUMENTATION \"Helper method for `print-outline'\")", Native.find_java_method("edu.isi.stella.Stella_Class", "helpPrintOutline", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Boolean.TYPE}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD HELP-PRINT-OUTLINE ((TOP SLOT) (STREAM OUTPUT-STREAM) (CURRENT-DEPTH INTEGER) (DEPTH INTEGER) (NAMED? BOOLEAN)) :PUBLIC? TRUE :DOCUMENTATION \"Helper method for `print-outline'\")", Native.find_java_method("edu.isi.stella.Slot", "helpPrintOutline", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Boolean.TYPE}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("STARTUP-TOOLS", "(DEFUN STARTUP-TOOLS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupTools", "startupTools", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_TOOLS);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupTools"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *OUTLINE-INDENT-STRING* STRING \"| \" :DOCUMENTATION \"String used in the PRINT-OUTLINE for each level of outline\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
