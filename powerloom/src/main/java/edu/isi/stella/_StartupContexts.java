//  -*- Mode: Java -*-
//
// _StartupContexts.java

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

public class _StartupContexts {
  public static void startupContexts() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Stella.SYM_STELLA_STARTUP_CONTEXTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-CONTEXTS", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("CS-VALUE?", "(DEFUN (CS-VALUE? BOOLEAN) ((SELF OBJECT)) :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (AND (DEFINED? SELF) (EQL? (PRIMARY-TYPE SELF) @CS-VALUE))))", Native.find_java_method("edu.isi.stella.Stella_Object", "csValueP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SUBCONTEXT?", "(DEFUN (SUBCONTEXT? BOOLEAN) ((SUBCONTEXT CONTEXT) (SUPERCONTEXT CONTEXT)) :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (OR (EQL? SUBCONTEXT SUPERCONTEXT) (MEMB? (ALL-SUPER-CONTEXTS SUBCONTEXT) SUPERCONTEXT))))", Native.find_java_method("edu.isi.stella.Context", "subcontextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context"), Native.find_java_class("edu.isi.stella.Context")}), null);
          Stella.defineFunctionObject("DISCARDED-CONTEXT?", "(DEFUN (DISCARDED-CONTEXT? BOOLEAN) ((CONTEXT CONTEXT)) :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (ODD? (CONTEXT-NUMBER CONTEXT))))", Native.find_java_method("edu.isi.stella.Context", "discardedContextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context")}), null);
          Stella.defineMethodObject("(DEFMETHOD (DELETED? BOOLEAN) ((CONTEXT CONTEXT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Context", "deletedP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("HELP-FIND-CONTEXT-BY-NUMBER", "(DEFUN (HELP-FIND-CONTEXT-BY-NUMBER CONTEXT) ((NUMBER INTEGER) (SIBLINGS (LIST OF CONTEXT))))", Native.find_java_method("edu.isi.stella.Stella", "helpFindContextByNumber", new java.lang.Class [] {java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("FIND-CONTEXT-BY-NUMBER", "(DEFUN (FIND-CONTEXT-BY-NUMBER CONTEXT) ((CONTEXTNUMBER INTEGER)))", Native.find_java_method("edu.isi.stella.Stella", "findContextByNumber", new java.lang.Class [] {java.lang.Integer.TYPE}), null);
          Stella.defineMethodObject("(DEFMETHOD (GET-STELLA-CONTEXT-SLOWLY CONTEXT) ((SELF STRING)))", Native.find_java_method("edu.isi.stella.Stella", "string_getStellaContextSlowly", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (GET-STELLA-CONTEXT-SLOWLY CONTEXT) ((SELF INTEGER)))", Native.find_java_method("edu.isi.stella.Stella", "integer_getStellaContextSlowly", new java.lang.Class [] {java.lang.Integer.TYPE}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (GET-STELLA-CONTEXT-SLOWLY CONTEXT) ((SELF SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "getStellaContextSlowly", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("CHANGE-CONTEXT-SLOWLY", "(DEFUN (CHANGE-CONTEXT-SLOWLY CONTEXT) ((SELF CONTEXT)))", Native.find_java_method("edu.isi.stella.Context", "changeContextSlowly", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context")}), null);
          Stella.defineFunctionObject("CC", "(DEFUN (CC CONTEXT) (|&REST| (NAME NAME)) :COMMAND? TRUE :PUBLIC? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Change the current context to the one named `name'.  Return the\nvalue of the new current context.  If no `name' is supplied, return\nthe pre-existing value of the current context.  `cc' is a no-op if the\ncontext reference cannot be successfully evaluated.\")", Native.find_java_method("edu.isi.stella.Stella", "cc", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.stella.Cons", "ccEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("CCC", "(DEFUN (CCC CONTEXT) (|&REST| (NAME NAME)) :COMMAND? TRUE :PUBLIC? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Change the current context to the one named `name'.  Return the\nvalue of the new current context.  If no `name' is supplied, return\nthe pre-existing value of the current context.  `cc' is a no-op if the\ncontext reference cannot be successfully evaluated.\nIn CommonLisp, if the new context is case sensitive, then change\nthe readtable case to the value of CL-USER::*STELLA-CASE-SENSITIVE-READ-MODE*\n[default = :INVERT], otherwise to :UPCASE.\")", Native.find_java_method("edu.isi.stella.Stella", "ccc", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.stella.Cons", "cccEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("PRINT-CONTEXT", "(DEFUN PRINT-CONTEXT ((SELF CONTEXT) (STREAM NATIVE-OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.Context", "printContext", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context"), Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), null);
          Stella.defineFunctionObject("HELP-PRINT-CONTEXT-TREE", "(DEFUN HELP-PRINT-CONTEXT-TREE ((LIST (LIST OF CONTEXT)) (LEVEL INTEGER)))", Native.find_java_method("edu.isi.stella.List", "helpPrintContextTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("PRINT-CONTEXT-TREE", "(DEFUN PRINT-CONTEXT-TREE ((ROOT CONTEXT)))", Native.find_java_method("edu.isi.stella.Context", "printContextTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context")}), null);
          Stella.defineFunctionObject("ACCESS-IN-CONTEXT", "(DEFUN (ACCESS-IN-CONTEXT OBJECT) ((VALUE OBJECT) (HOMECONTEXT CONTEXT) (DONTINHERIT? BOOLEAN)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "accessInContext", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Context"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("HELP-INSERT-A-CS-VALUE", "(DEFUN HELP-INSERT-A-CS-VALUE ((KVCONS KV-CONS) (NEWVALUE OBJECT) (TARGET CONTEXT) (OVERWRITE? BOOLEAN)))", Native.find_java_method("edu.isi.stella.KvCons", "helpInsertACsValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.KvCons"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Context"), java.lang.Boolean.TYPE}), null);
          Stella.defineMethodObject("(DEFMETHOD INSERT-AT ((SELF CS-VALUE) (CONTEXT CONTEXT) (NEWVALUE OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.CsValue", "insertAt", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context"), Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("UPDATE-IN-CONTEXT", "(DEFUN (UPDATE-IN-CONTEXT OBJECT) ((OLDVALUE OBJECT) (NEWVALUE OBJECT) (HOMECONTEXT CONTEXT) (COPYTOCHILDREN? BOOLEAN)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "updateInContext", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Context"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("COPY-CURRENT-VALUE-TO-CHILDREN", "(DEFUN COPY-CURRENT-VALUE-TO-CHILDREN ((CSVALUE CS-VALUE) (HOMECONTEXT CONTEXT) (PARENTVALUE OBJECT)))", Native.find_java_method("edu.isi.stella.CsValue", "copyCurrentValueToChildren", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.CsValue"), Native.find_java_class("edu.isi.stella.Context"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("STARTUP-CONTEXTS", "(DEFUN STARTUP-CONTEXTS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupContexts", "startupContexts", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_CONTEXTS);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupContexts"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *UNLINK-DISCARDED-CONTEXTS-ON-READ?* BOOLEAN TRUE :DOCUMENTATION \"Eliminate pointers to discarded contexts while\naccessing a CS-VALUE context table.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *UNLINK-DISCARDED-CONTEXTS-ON-WRITE?* BOOLEAN TRUE :DOCUMENTATION \"Eliminate pointers to discarded contexts while\ninserting into a CS-VALUE context table.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CONTEXT-BACKTRACKING-MODE* BOOLEAN FALSE :DOCUMENTATION \"If true, indicates that contexts are being allocated\nand deallocated in depth-first fashion, and that deallocation of\nCS-VALUE entries is taken care of during context destruction.\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
