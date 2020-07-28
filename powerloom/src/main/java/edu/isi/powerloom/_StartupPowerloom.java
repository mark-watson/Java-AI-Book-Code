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

package edu.isi.powerloom;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.stella.*;
import edu.isi.powerloom.logic.*;
import edu.isi.powerloom.*;
import edu.isi.powerloom.extensions.*;
import edu.isi.stella.utilities.*;

public class _StartupPowerloom {
  public static void startupPowerloom() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/POWERLOOM-CODE", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          PowerLoom.KWD_KEY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("KEY", null, 2)));
          PowerLoom.KWD_DOCUMENTATION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DOCUMENTATION", null, 2)));
          PowerLoom.KWD_N_ARGUMENTS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("N-ARGUMENTS", null, 2)));
          PowerLoom.KWD_HANDLER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("HANDLER", null, 2)));
          PowerLoom.SYM_POWERLOOM_CODE_LOAD_ALL_EXTENSIONS_OPTION_HANDLER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LOAD-ALL-EXTENSIONS-OPTION-HANDLER", null, 0)));
          PowerLoom.KWD_ERROR_ACTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ERROR-ACTION", null, 2)));
          PowerLoom.KWD_ERROR = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ERROR", null, 2)));
          PowerLoom.SYM_POWERLOOM_CODE_START_POWERLOOM_GUI_OPTION_HANDLER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("START-POWERLOOM-GUI-OPTION-HANDLER", null, 0)));
          PowerLoom.KWD_WARN = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("WARN", null, 2)));
          PowerLoom.KWD_KEY2 = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("KEY2", null, 2)));
          PowerLoom.KWD_PROPERTY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PROPERTY", null, 2)));
          PowerLoom.KWD_VALUE_TYPE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("VALUE-TYPE", null, 2)));
          PowerLoom.SGT_STELLA_BOOLEAN = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("BOOLEAN", Stella.getStellaModule("/STELLA", true), 1)));
          PowerLoom.KWD_DEFAULT_VALUE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFAULT-VALUE", null, 2)));
          PowerLoom.KWD_KEY3 = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("KEY3", null, 2)));
          PowerLoom.SYM_STELLA_EVAL_OPTION_HANDLER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EVAL-OPTION-HANDLER", Stella.getStellaModule("/STELLA", true), 0)));
          PowerLoom.SYM_POWERLOOM_CODE_STARTUP_POWERLOOM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-POWERLOOM", null, 0)));
          PowerLoom.SYM_STELLA_METHOD_STARTUP_CLASSNAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-STARTUP-CLASSNAME", Stella.getStellaModule("/STELLA", true), 0)));
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          PowerLoom.$POWERLOOM_EXTENSION_SYSTEMS$ = Cons.consList(Cons.cons(StringWrapper.wrapString("SDBC"), Cons.cons(StringWrapper.wrapString("RDBMS"), Stella.NIL)));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("LOAD-ALL-EXTENSION-SYSTEMS", "(DEFUN LOAD-ALL-EXTENSION-SYSTEMS () :DOCUMENTATION \"Load and initialize all installed extension systems.\" :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.powerloom.PowerLoom", "loadAllExtensionSystems", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("LOAD-ALL-EXTENSIONS-OPTION-HANDLER", "(DEFUN LOAD-ALL-EXTENSIONS-OPTION-HANDLER ((OPTION CMD-LINE-OPTION) (VALUE OBJECT)) :DOCUMENTATION \"Load and initialize all installed extension systems.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.PowerLoom", "loadAllExtensionsOptionHandler", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.CmdLineOption"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("START-POWERLOOM-GUI-OPTION-HANDLER", "(DEFUN START-POWERLOOM-GUI-OPTION-HANDLER ((OPTION CMD-LINE-OPTION) (VALUE OBJECT)) :DOCUMENTATION \"Start the PowerLoom GUI.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.PowerLoom", "startPowerloomGuiOptionHandler", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.CmdLineOption"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("MAIN", "(DEFUN MAIN ((ARGUMENTS (ARRAY () OF STRING))) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.PowerLoom", "main", new java.lang.Class [] {Native.find_java_class("[Ljava.lang.String;")}), null);
          Stella.defineFunctionObject("STARTUP-POWERLOOM", "(DEFUN STARTUP-POWERLOOM () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom._StartupPowerloom", "startupPowerloom", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(PowerLoom.SYM_POWERLOOM_CODE_STARTUP_POWERLOOM);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, PowerLoom.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupPowerloom"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("POWERLOOM-CODE")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *POWERLOOM-EXTENSION-SYSTEMS* (CONS OF STRING-WRAPPER) (CONS-LIST \"SDBC\" \"RDBMS\") :DOCUMENTATION \"List of extension systems that can be loaded\ndynamically (not yet in C++).\" :PUBLIC? TRUE)");
          Stella.registerCmdLineOption(Cons.cons(PowerLoom.KWD_KEY, Cons.cons(StringWrapper.wrapString("--load-all-extensions"), Cons.cons(PowerLoom.KWD_DOCUMENTATION, Cons.cons(StringWrapper.wrapString("\n  Load all available PowerLoom extension systems."), Cons.cons(PowerLoom.KWD_N_ARGUMENTS, Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(PowerLoom.KWD_HANDLER, Cons.cons(PowerLoom.SYM_POWERLOOM_CODE_LOAD_ALL_EXTENSIONS_OPTION_HANDLER, Cons.cons(PowerLoom.KWD_ERROR_ACTION, Cons.cons(PowerLoom.KWD_ERROR, Stella.NIL)))))))))));
          Stella.registerCmdLineOption(Cons.cons(PowerLoom.KWD_KEY, Cons.cons(StringWrapper.wrapString("--gui"), Cons.cons(PowerLoom.KWD_DOCUMENTATION, Cons.cons(StringWrapper.wrapString("\n  Launch the PowerLoom GUI in addition to the read/eval/print loop."), Cons.cons(PowerLoom.KWD_N_ARGUMENTS, Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(PowerLoom.KWD_HANDLER, Cons.cons(PowerLoom.SYM_POWERLOOM_CODE_START_POWERLOOM_GUI_OPTION_HANDLER, Cons.cons(PowerLoom.KWD_ERROR_ACTION, Cons.cons(PowerLoom.KWD_WARN, Stella.NIL)))))))))));
          Stella.registerCmdLineOption(Cons.cons(PowerLoom.KWD_KEY, Cons.cons(StringWrapper.wrapString("-i"), Cons.cons(PowerLoom.KWD_KEY2, Cons.cons(StringWrapper.wrapString("--interactive"), Cons.cons(PowerLoom.KWD_DOCUMENTATION, Cons.cons(StringWrapper.wrapString("\n  Launch an interactive read/eval/print loop after all startup code and\n  command line arguments have been processed."), Cons.cons(PowerLoom.KWD_N_ARGUMENTS, Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(PowerLoom.KWD_PROPERTY, Cons.cons(StringWrapper.wrapString("powerloom.runInteractively"), Cons.cons(PowerLoom.KWD_VALUE_TYPE, Cons.cons(PowerLoom.SGT_STELLA_BOOLEAN, Cons.cons(PowerLoom.KWD_DEFAULT_VALUE, Cons.cons(Stella.TRUE_WRAPPER, Stella.NIL)))))))))))))));
          Stella.registerCmdLineOption(Cons.cons(PowerLoom.KWD_KEY, Cons.cons(StringWrapper.wrapString("--batch"), Cons.cons(PowerLoom.KWD_DOCUMENTATION, Cons.cons(StringWrapper.wrapString("\n  Do not start an interactive read/eval/print loop.  Just evaluate all\n  command line arguments and main function code and then exit."), Cons.cons(PowerLoom.KWD_N_ARGUMENTS, Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(PowerLoom.KWD_PROPERTY, Cons.cons(StringWrapper.wrapString("powerloom.runInteractively"), Cons.cons(PowerLoom.KWD_VALUE_TYPE, Cons.cons(PowerLoom.SGT_STELLA_BOOLEAN, Cons.cons(PowerLoom.KWD_DEFAULT_VALUE, Cons.cons(Stella.FALSE_WRAPPER, Stella.NIL)))))))))))));
          Stella.registerCmdLineOption(Cons.cons(PowerLoom.KWD_KEY, Cons.cons(StringWrapper.wrapString("-e"), Cons.cons(PowerLoom.KWD_KEY2, Cons.cons(StringWrapper.wrapString("--eval"), Cons.cons(PowerLoom.KWD_KEY3, Cons.cons(StringWrapper.wrapString("-eval"), Cons.cons(PowerLoom.KWD_DOCUMENTATION, Cons.cons(StringWrapper.wrapString("<s-expression>\n  Evaluate the STELLA <s-expression> in the PL-USER module."), Cons.cons(PowerLoom.KWD_N_ARGUMENTS, Cons.cons(IntegerWrapper.wrapInteger(1), Cons.cons(PowerLoom.KWD_HANDLER, Cons.cons(PowerLoom.SYM_STELLA_EVAL_OPTION_HANDLER, Cons.cons(PowerLoom.KWD_ERROR_ACTION, Cons.cons(PowerLoom.KWD_WARN, Stella.NIL)))))))))))))));
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
