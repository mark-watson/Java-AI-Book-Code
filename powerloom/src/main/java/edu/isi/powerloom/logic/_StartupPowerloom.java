//  -*- Mode: Java -*-
//
// _StartupPowerloom.java

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
 | The Original Code is the PowerLoom KR&R System.                            |
 |                                                                            |
 | The Initial Developer of the Original Code is                              |
 | UNIVERSITY OF SOUTHERN CALIFORNIA, INFORMATION SCIENCES INSTITUTE          |
 | 4676 Admiralty Way, Marina Del Rey, California 90292, U.S.A.               |
 |                                                                            |
 | Portions created by the Initial Developer are Copyright (C) 1997-2017      |
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
 +----------------------------- END LICENSE BLOCK ----------------------------+
*/

package edu.isi.powerloom.logic;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.stella.*;

public class _StartupPowerloom {
  public static void startupPowerloom() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Logic.KWD_LOG_LEVELS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LOG-LEVELS", null, 2)));
          Logic.KWD_PREFIX = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PREFIX", null, 2)));
          Logic.KWD_MAX_WIDTH = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MAX-WIDTH", null, 2)));
          Logic.SYM_LOGIC_STARTUP_POWERLOOM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-POWERLOOM", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Logic.$POWERLOOM_VERSION_STRING$ = "PowerLoom " + Native.integerToString(((long)(Logic.$POWERLOOM_MAJOR_VERSION_NUMBER$))) + "." + Native.integerToString(((long)(Logic.$POWERLOOM_MINOR_VERSION_NUMBER$))) + "." + Native.integerToString(((long)(Logic.$POWERLOOM_PATCH_LEVEL$))) + Logic.$POWERLOOM_RELEASE_STATE$;
          Logic.$POWERLOOM_EXECUTION_MODE$ = Logic.KWD_RELEASE;
          Logic.$POWERLOOM_LOCK$ = Stella.makeProcessLock();
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("PL-LOG", "(DEFUN PL-LOG ((LOGLEVEL KEYWORD) |&REST| (MESSAGE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "plLog", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("POWERLOOM-INFORMATION", "(DEFUN (POWERLOOM-INFORMATION STRING) () :DOCUMENTATION \"Returns information about the current PowerLoom implementation.\nUseful when reporting problems.\" :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "powerloomInformation", new java.lang.Class [] {}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "powerloomInformationEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("POWERLOOM-COPYRIGHT-HEADER", "(DEFUN (POWERLOOM-COPYRIGHT-HEADER STRING) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "powerloomCopyrightHeader", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("COPYRIGHT", "(DEFUN COPYRIGHT () :COMMAND? TRUE :PUBLIC? TRUE :DOCUMENTATION \"Print detailed PowerLoom copyright information.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "copyright", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("COPYRIGHT-YEARS", "(DEFUN (COPYRIGHT-YEARS STRING) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "copyrightYears", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("POWERLOOM", "(DEFUN POWERLOOM () :DOCUMENTATION \"Run the PowerLoom listener.  Read logic commands from the\nstandard input, evaluate them, and print their results.  Exit if the user\nentered `bye', `exit', `halt', `quit', or `stop'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "powerloom", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("STARTUP-POWERLOOM", "(DEFUN STARTUP-POWERLOOM () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupPowerloom", "startupPowerloom", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_POWERLOOM);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupPowerloom"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *POWERLOOM-MAJOR-VERSION-NUMBER* INTEGER 4)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *POWERLOOM-MINOR-VERSION-NUMBER* INTEGER 0)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *POWERLOOM-RELEASE-STATE* STRING \"\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *POWERLOOM-PATCH-LEVEL* INTEGER 10)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *POWERLOOM-VERSION-STRING* STRING (CONCATENATE \"PowerLoom \" (INTEGER-TO-STRING *POWERLOOM-MAJOR-VERSION-NUMBER*) \".\" (INTEGER-TO-STRING *POWERLOOM-MINOR-VERSION-NUMBER*) \".\" (INTEGER-TO-STRING *POWERLOOM-PATCH-LEVEL*) *POWERLOOM-RELEASE-STATE*))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *POWERLOOM-EXECUTION-MODE* KEYWORD :RELEASE :DOCUMENTATION \"Either :development, :debugging or :release (so far) which controls\nwhether certain internal error and warning messages are surfaced to the user.\")");
          Stella.setLoggingParameters("PowerLoom", Cons.cons(Logic.KWD_LOG_LEVELS, Cons.cons(Stella.getQuotedTree("((:NONE :LOW :MEDIUM :HIGH) \"/LOGIC\")", "/LOGIC"), Cons.cons(Logic.KWD_LEVEL, Cons.cons(((Logic.$POWERLOOM_EXECUTION_MODE$ == Logic.KWD_DEVELOPMENT) ? Logic.KWD_MEDIUM : Logic.KWD_LOW), Cons.cons(Logic.KWD_PREFIX, Cons.cons(StringWrapper.wrapString("PL"), Cons.cons(Logic.KWD_MAX_WIDTH, Cons.cons(IntegerWrapper.wrapInteger(250), Stella.NIL)))))))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *POWERLOOM-LOCK* PROCESS-LOCK-OBJECT (MAKE-PROCESS-LOCK) :PUBLIC? TRUE :DOCUMENTATION \"Lock object for synchronizing safe multi-process access to PowerLoom\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
