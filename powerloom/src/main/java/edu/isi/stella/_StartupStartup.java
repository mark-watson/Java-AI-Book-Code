//  -*- Mode: Java -*-
//
// _StartupStartup.java

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

public class _StartupStartup {
  public static void startupStartup() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Stella.KWD_QUOTED_CONSTANTS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("QUOTED-CONSTANTS", null, 2)));
          Stella.SYM_STELLA_STARTUP_STARTUP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-STARTUP", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Stella.$STELLA_VERSION_STRING$ = Stella.stellaVersionString();
          Stella.$STARTUP_TIME_PHASES$ = ((List)(List.list(Cons.cons(Stella.KWD_EARLY_INITS, Cons.cons(Stella.KWD_MODULES, Cons.cons(Stella.KWD_SYMBOLS, Cons.cons(Stella.KWD_QUOTED_CONSTANTS, Cons.cons(Stella.KWD_GLOBALS, Cons.cons(Stella.KWD_CLASSES, Cons.cons(Stella.KWD_FINALIZE_CLASSES, Cons.cons(Stella.KWD_METHODS, Cons.cons(Stella.KWD_FINALIZE_METHODS, Cons.cons(Stella.KWD_FINAL, Stella.NIL)))))))))))));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("STELLA-VERSION-STRING", "(DEFUN (STELLA-VERSION-STRING STRING) () :DOCUMENTATION \"Return a string identifying the current version of STELLA.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "stellaVersionString", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("STELLA-INFORMATION", "(DEFUN (STELLA-INFORMATION STRING) () :DOCUMENTATION \"Returns information about the current Stella implementation.\nUseful when reporting problems.\" :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "stellaInformation", new java.lang.Class [] {}), Native.find_java_method("edu.isi.stella.Cons", "stellaInformationEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("CURRENT-STARTUP-TIME-PHASE?", "(DEFUN (CURRENT-STARTUP-TIME-PHASE? BOOLEAN) ((PHASE INTEGER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "currentStartupTimePhaseP", new java.lang.Class [] {java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("ENCODE-STARTUP-TIME-PHASE", "(DEFUN (ENCODE-STARTUP-TIME-PHASE INTEGER) ((PHASE KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "encodeStartupTimePhase", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("STARTUP-KERNEL", "(DEFUN STARTUP-KERNEL ((VERBOSE? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Stella", "startupKernel", new java.lang.Class [] {java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("STARTUP-CPP-TRANSLATOR", "(DEFUN STARTUP-CPP-TRANSLATOR ())", Native.find_java_method("edu.isi.stella.Stella", "startupCppTranslator", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("STARTUP-JAVA-TRANSLATOR", "(DEFUN STARTUP-JAVA-TRANSLATOR ())", Native.find_java_method("edu.isi.stella.Stella", "startupJavaTranslator", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("STARTUP-IDL-TRANSLATOR", "(DEFUN STARTUP-IDL-TRANSLATOR ())", Native.find_java_method("edu.isi.stella.Stella", "startupIdlTranslator", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("STARTUP", "(DEFUN STARTUP ((VERBOSE? BOOLEAN)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "startup", new java.lang.Class [] {java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("INTERPRET-COMMAND-LINE-ARGUMENTS", "(DEFUN INTERPRET-COMMAND-LINE-ARGUMENTS ((COUNT INTEGER) (ARGUMENTS (ARRAY () OF STRING))) :DOCUMENTATION \"Old name for `process-command-line-arguments' (which see).\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "interpretCommandLineArguments", new java.lang.Class [] {java.lang.Integer.TYPE, Native.find_java_class("[Ljava.lang.String;")}), null);
          Stella.defineFunctionObject("CONSIFY-COMMAND-LINE-ARGUMENTS", "(DEFUN (CONSIFY-COMMAND-LINE-ARGUMENTS (CONS OF STRING-WRAPPER)) ((COUNT INTEGER) (ARGUMENTS (ARRAY () OF STRING))) :DOCUMENTATION \"Convert `count' command line `arguments' into a CONS list.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "consifyCommandLineArguments", new java.lang.Class [] {java.lang.Integer.TYPE, Native.find_java_class("[Ljava.lang.String;")}), null);
          Stella.defineFunctionObject("MAIN", "(DEFUN MAIN ((ARGUMENTS (ARRAY () OF STRING))) :PUBLIC? TRUE)", null, null);
          Stella.defineFunctionObject("STARTUP-STARTUP", "(DEFUN STARTUP-STARTUP () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupStartup", "startupStartup", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_STARTUP);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupStartup"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *STELLA-MAJOR-VERSION-NUMBER* INTEGER 3 :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *STELLA-MINOR-VERSION-NUMBER* INTEGER 5 :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *STELLA-RELEASE-STATE* STRING \"\" :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *STELLA-PATCH-LEVEL* INTEGER 35 :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *STELLA-VERSION-STRING* STRING (STELLA-VERSION-STRING) :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *STARTUP-TIME-PHASES* (LIST OF KEYWORD) (CAST (LIST :EARLY-INITS :MODULES :SYMBOLS :QUOTED-CONSTANTS :GLOBALS :CLASSES :FINALIZE-CLASSES :METHODS :FINALIZE-METHODS :FINAL) (LIST OF KEYWORD)) :DOCUMENTATION \"List of phases that can be legally used as an optional\nphase argument to a `startup-time-progn' form.  The corresponding code\nwill be executed during the execution of a startup-time-code function only\nif the position of the keyword in the list corresponds to the current value of\n`*STARTUP-TIME-PHASE*', or if phasing of startup-time code is disabled.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *STARTUP-TIME-PHASE* INTEGER 999 :PUBLIC? TRUE :DOCUMENTATION \"The current phase during 'phased startup'.\nThe value has to correspond to the position of one of the keywords\nin `*STARTUP-TIME-PHASES*'.  999 means no phasing at all.\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
