//  -*- Mode: Java -*-
//
// _StartupLogicMacros.java

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

public class _StartupLogicMacros {
  static void helpStartupLogicMacros1() {
    {
      Surrogate.internSurrogateInModule("PROPOSITION.IF", Stella.$STELLA_MODULE$, true);
      Logic.SYM_STELLA_LET = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LET", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_NEW = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NEW", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_OUTPUT_STRING_STREAM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OUTPUT-STRING-STREAM", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_SPECIAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SPECIAL", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_$PRINTREADABLYp$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("*PRINTREADABLY?*", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_TRUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TRUE", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_PRINT_STREAM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PRINT-STREAM", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_EOL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EOL", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_HELP_SIGNAL_PROPOSITION_ERROR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("HELP-SIGNAL-PROPOSITION-ERROR", null, 0)));
      Logic.KWD_ERROR = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ERROR", null, 2)));
      Logic.SYM_STELLA_SIGNAL_EXCEPTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SIGNAL-EXCEPTION", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_PARSING_ERROR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PARSING-ERROR", null, 0)));
      Logic.KWD_MESSAGE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MESSAGE", null, 2)));
      Logic.SYM_STELLA_THE_STRING = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("THE-STRING", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_PROPOSITION_ERROR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PROPOSITION-ERROR", null, 0)));
      Logic.SYM_STELLA_STANDARD_WARNING = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STANDARD-WARNING", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.KWD_WARNING = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("WARNING", null, 2)));
      Logic.SYM_STELLA_DEFUN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFUN", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_STRING = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STRING", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_PRINT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PRINT", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_RETURN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RETURN", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_PROGN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PROGN", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_SETF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SETF", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_TRUTH_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TRUTH-VALUE", null, 0)));
      Logic.SYM_LOGIC_FRAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FRAME", null, 0)));
      Logic.SYM_STELLA_NULL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_JUSTIFICATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JUSTIFICATION", null, 0)));
      Logic.SYM_STELLA_WHEN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WHEN", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_DEFINEDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFINED?", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_PARTIAL_MATCH_FRAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PARTIAL-MATCH-FRAME", null, 0)));
      Logic.SYM_LOGIC_CLEAR_FRAME_PARTIAL_TRUTH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLEAR-FRAME-PARTIAL-TRUTH", null, 0)));
      Logic.SYM_STELLA_SETQ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SETQ", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_LASTMOVE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LASTMOVE", null, 0)));
      Logic.KWD_DOWN = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DOWN", null, 2)));
      Logic.SYM_STELLA_COND = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COND", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_CHECKFORMOVEOUTp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CHECKFORMOVEOUT?", null, 0)));
      Logic.SYM_LOGIC_PARENT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PARENT", null, 0)));
      Logic.SYM_LOGIC_UP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UP", null, 0)));
      Logic.SYM_LOGIC_STARTTICKS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTTICKS", null, 0)));
      Logic.SYM_LOGIC_STARTING_CLOCK_TICKS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTING-CLOCK-TICKS", null, 0)));
      Logic.SYM_LOGIC_AVAILABLETICKS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("AVAILABLETICKS", null, 0)));
      Logic.SYM_STELLA__ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("-", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_ALLOTTED_CLOCK_TICKS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ALLOTTED-CLOCK-TICKS", null, 0)));
      Logic.SYM_LOGIC_CLOCKTICKS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLOCKTICKS", null, 0)));
      Logic.SYM_STELLA___ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("--", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_CURRENT_CLOCK_TICKS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CURRENT-CLOCK-TICKS", null, 0)));
      Logic.SYM_LOGIC_QUERY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY", null, 0)));
      Logic.SYM_STELLA_ii = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("++", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_le = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("<=", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_POP_FRAMES_UP_TO = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("POP-FRAMES-UP-TO", null, 0)));
      Logic.SYM_STELLA_MV_SETQ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MV-SETQ", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_DEPTH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEPTH", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_HANDLE_TIMEOUT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("HANDLE-TIMEOUT", null, 0)));
      Logic.KWD_UP_FAIL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("UP-FAIL", null, 2)));
      Logic.SYM_STELLA_1i = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("1+", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_OTHERWISE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OTHERWISE", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_UPFRAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UPFRAME", null, 0)));
      Logic.SYM_LOGIC_DOWNFRAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DOWNFRAME", null, 0)));
      Logic.SYM_LOGIC_DOWN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DOWN", null, 0)));
    }
  }

  static void helpStartupLogicMacros2() {
    {
      Logic.SYM_STELLA_AND = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("AND", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_NULLp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL?", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_1_ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("1-", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_PROPOSITION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PROPOSITION", null, 0)));
      Logic.SYM_LOGIC_ARGUMENT_BOUND_TO = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ARGUMENT-BOUND-TO", null, 0)));
      Logic.SYM_STELLA_NTH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NTH", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_ARGUMENTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ARGUMENTS", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_ARGUMENT_CURSOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ARGUMENT-CURSOR", null, 0)));
      Logic.SYM_LOGIC_CREATE_DOWN_FRAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CREATE-DOWN-FRAME", null, 0)));
      Logic.SYM_STELLA_g = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule(">", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_CURRENT_DEPTH_CUTOFF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CURRENT-DEPTH-CUTOFF", null, 0)));
      Logic.SYM_STELLA_EQLp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EQL?", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_STATE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STATE", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.KWD_PATTERN = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PATTERN", null, 2)));
      Logic.SYM_LOGIC_HANDLE_DEPTH_VIOLATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("HANDLE-DEPTH-VIOLATION", null, 0)));
      Logic.SYM_STELLA_NOT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NOT", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_FAIL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FAIL", null, 0)));
      Logic.KWD_UP_TRUE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("UP-TRUE", null, 2)));
      Logic.SYM_STELLA_FALSE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FALSE", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_RESULT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RESULT", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_IF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IF", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_CACHE_QUERY_RESULTSp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CACHE-QUERY-RESULTS?", null, 0)));
      Logic.SYM_LOGIC_CACHE_GOAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CACHE-GOAL", null, 0)));
      Logic.SYM_LOGIC_UPDATE_GOAL_CACHE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UPDATE-GOAL-CACHE", null, 0)));
      Logic.SYM_LOGIC_SUCCESSp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SUCCESS?", null, 0)));
      Logic.SYM_STELLA_BREAK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BREAK", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_KEEP_FRAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("KEEP-FRAME", null, 0)));
      Logic.SYM_LOGIC_POP_DOWN_FRAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("POP-DOWN-FRAME", null, 0)));
      Logic.SYM_LOGIC_APPLY_CACHED_RETRIEVE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("APPLY-CACHED-RETRIEVE", null, 0)));
      Logic.SYM_STELLA_BQUOTE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BQUOTE", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_CONS_LIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CONS-LIST", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_QUOTE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("QUOTE", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_APPLY_CACHED_ASK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("APPLY-CACHED-ASK", null, 0)));
      Logic.SYM_STELLA_$CONTEXT$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("*CONTEXT*", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_GET_INFERENCE_CACHE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("GET-INFERENCE-CACHE", null, 0)));
      Logic.SYM_STELLA_$MODULE$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("*MODULE*", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.KWD_META = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("META", null, 2)));
      Logic.SYM_LOGIC_$CLASSIFICATIONSESSION$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("*CLASSIFICATIONSESSION*", null, 0)));
      Logic.SYM_LOGIC_GET_CLASSIFICATION_SESSION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("GET-CLASSIFICATION-SESSION", null, 0)));
      Logic.SYM_LOGIC_CLASSIFICATION_WORLD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASSIFICATION-WORLD", null, 0)));
      Logic.SYM_STELLA_OBJECT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OBJECT", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_MISSING_ARGUMENT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MISSING-ARGUMENT", null, 0)));
      Logic.SYM_STELLA_INTEGER_WRAPPER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INTEGER-WRAPPER", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_CASE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CASE", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_WRAPPER_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WRAPPER-VALUE", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_BOOLEAN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BOOLEAN", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_X = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("X", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_NUMBER_WRAPPER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NUMBER-WRAPPER", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_Y = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("Y", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.KWD_PUBLICp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PUBLIC?", null, 2)));
      Logic.SYM_STELLA_TYPECASE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TYPECASE", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_FLOAT_WRAPPER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FLOAT-WRAPPER", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_CAST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CAST", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_FLOAT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FLOAT", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_FLOATRESULT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FLOATRESULT", null, 0)));
      Logic.SYM_STELLA_WRAP_LITERAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WRAP-LITERAL", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_SAFE_CAST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SAFE-CAST", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_INTEGER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INTEGER", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_MODULE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_CONTEXT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTEXT", Stella.getStellaModule("/STELLA", true), 0)));
    }
  }

  public static void startupLogicMacros() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupLogicMacros.helpStartupLogicMacros1();
          _StartupLogicMacros.helpStartupLogicMacros2();
          Logic.SYM_STELLA_WITH_PROCESS_LOCK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WITH-PROCESS-LOCK", Stella.getStellaModule("/STELLA", true), 0)));
          Logic.SYM_LOGIC_$POWERLOOM_LOCK$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("*POWERLOOM-LOCK*", null, 0)));
          Logic.SYM_STELLA_IGNORE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IGNORE", Stella.getStellaModule("/STELLA", true), 0)));
          Logic.SYM_LOGIC_$CYC_KLUDGES_ENABLEDp$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("*CYC-KLUDGES-ENABLED?*", null, 0)));
          Logic.SYM_LOGIC_STARTUP_LOGIC_MACROS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-LOGIC-MACROS", null, 0)));
          Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-STARTUP-CLASSNAME", Stella.getStellaModule("/STELLA", true), 0)));
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Logic.$SUPPRESSNONLOGICOBJECTWARNINGp$.setDefaultValue(new Boolean(true));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("SIGNAL-PARSING-ERROR", "(DEFUN SIGNAL-PARSING-ERROR (|&BODY| (MESSAGE CONS)) :TYPE OBJECT :MACRO? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "signalParsingError", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("SIGNAL-PROPOSITION-ERROR", "(DEFUN SIGNAL-PROPOSITION-ERROR (|&BODY| (MESSAGE CONS)) :TYPE OBJECT :MACRO? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "signalPropositionError", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("SIGNAL-PROPOSITION-WARNING", "(DEFUN SIGNAL-PROPOSITION-WARNING (|&BODY| (MESSAGE CONS)) :TYPE OBJECT :MACRO? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "signalPropositionWarning", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("DEF-DISPLAY-GLOBALS", "(DEFUN DEF-DISPLAY-GLOBALS ((DISPLAYFUNCTIONNAME SYMBOL) (GLOBALVARIABLENAMES (CONS OF SYMBOL))) :TYPE OBJECT :MACRO? TRUE :LISP-MACRO? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "defDisplayGlobals", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("MOVE-IN-PLACE", "(DEFUN MOVE-IN-PLACE () :TYPE OBJECT :MACRO? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "moveInPlace", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("MOVE-DOWN", "(DEFUN MOVE-DOWN () :TYPE OBJECT :MACRO? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "moveDown", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("MOVE-UP", "(DEFUN MOVE-UP ((SUCCESS? SYMBOL) (KEEPFRAME? SYMBOL)) :TYPE OBJECT :MACRO? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "moveUp", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("APPLY-RETRIEVE", "(DEFUN APPLY-RETRIEVE (|&BODY| (BODY CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Execute a query composed of io-variables `variables'\nand body `queryBody'.  Before executing, bind variables to `inputBindings'\n(in sequence). If one variable is left unbound, returns a cons list of\nbindings of that variable.  If two or more are unbound, returns\na cons list of cons lists of bindings.  Setting the option :singletons?\nto FALSE always returns a list of lists.  Example call:\n  `(apply-retrieve variables queryBody inputBindings)'\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "applyRetrieve", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("APPLY-ASK", "(DEFUN APPLY-ASK (|&BODY| (BODY CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Execute a yes/no query composed of input-variables\n`inputVariables' and body `queryBody'.  Before executing, bind variables\nto `inputBindings' (in sequence).\n  `(apply-ask inputVariables queryBody inputBindings)'\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "applyAsk", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("WITHIN-META-CACHE", "(DEFUN WITHIN-META-CACHE (|&BODY| (BODY CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Execute `body' within the meta cache of the current module.\nSet appropriate special variables.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "withinMetaCache", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("WITHIN-CLASSIFICATION-SESSION", "(DEFUN WITHIN-CLASSIFICATION-SESSION ((DESCRIPTIONORINSTANCE KEYWORD) |&BODY| (BODY CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Used during classification.  Execute `body' within the indicated\nclassification session and inference world.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "withinClassificationSession", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("DEFINE-COMPUTED-CONSTRAINT", "(DEFUN DEFINE-COMPUTED-CONSTRAINT ((NAME SYMBOL) (VAR-LIST CONS) (CONSTRAINT-TEST CONS) |&BODY| (POSITION-COMPUTATIONS CONS)) :TYPE OBJECT :MACRO? TRUE :PUBLIC? TRUE :DOCUMENTATION \"Defines `name' to be a constraint computation which uses\n`constraint-test' to determine if a fully bound set of variables\nsatisfies the constraint.  The forms in `position-computations'\nare used to compute the value for each of the positions. All such\ncomputations must set the variable `value' to be the result\ncomputed for the missing position.  Setting `value' to `null' for\nany such computation means that that particular argument cannot\nbe computed from the others.  The input variables in `var-list'\nwill be bound to the N arguments to the constraint.\n  The generated function will return a Stella Object and take as \ninputs the values of the N arguments to the constraint.  A value\nof `null' means that the value is not available.  If all\narguments are not `null', then the return value will be a Stella\nwrapped boolean indicating whether the constraint is satisified\nor not.\n  If more than one input value is `null', then this constraint\ncode will not be called.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "defineComputedConstraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("DEFINE-ARITHMETIC-TEST-ON-WRAPPERS", "(DEFUN DEFINE-ARITHMETIC-TEST-ON-WRAPPERS ((NAME SYMBOL) (TEST-NAME SYMBOL)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Defines `name' as an arithmetic comparision operation using the\ntest `test-name'.  It will take two wrapped number parameters and\nreturn a `boolean'.  The code will use the appropriate test for\nthe specific subtype of wrapped number actually passed in.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "defineArithmeticTestOnWrappers", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("DEFINE-ARITHMETIC-OPERATION-ON-WRAPPERS", "(DEFUN DEFINE-ARITHMETIC-OPERATION-ON-WRAPPERS ((NAME SYMBOL) (OPERATION-NAME SYMBOL)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Defines `name' as an arithmetic comparision operation using the\ntest `test-name'.  It will take two wrapped number parameters and\nreturn a wrapped number.  The code will use the appropriate test\nfor the specific subtype of wrapped number actually passed in,\nand return the appropriate subtype of wrapped number based on the\nnormal arithmetic contagion rules.\n  \nFor example, if both input parameters are wrapped integers then\nthe output will be a wrapped integer.  If the inputs are a\nwrapped integer and a wrapped float then the output will be a\nwrapped float, etc.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "defineArithmeticOperationOnWrappers", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("WITH-LOGIC-ENVIRONMENT", "(DEFUN WITH-LOGIC-ENVIRONMENT ((MODULEFORM OBJECT) (ENVIRONMENT OBJECT) |&BODY| (BODY CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Execute `body' within the module resulting from `moduleForm'.\n`*module*' is an acceptable `moduleForm'.  It will locally rebind \n`*module*' and `*context*' and shield the outer bindings from changes.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "withLogicEnvironment", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("WHEN-CYC-KLUDGES-ENABLED", "(DEFUN WHEN-CYC-KLUDGES-ENABLED (|&BODY| (BODY CONS)) :TYPE OBJECT :MACRO? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "whenCycKludgesEnabled", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("STARTUP-LOGIC-MACROS", "(DEFUN STARTUP-LOGIC-MACROS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupLogicMacros", "startupLogicMacros", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_LOGIC_MACROS);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupLogicMacros"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *SUPPRESSNONLOGICOBJECTWARNING?* BOOLEAN TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CYC-KLUDGES-ENABLED?* BOOLEAN FALSE)");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
