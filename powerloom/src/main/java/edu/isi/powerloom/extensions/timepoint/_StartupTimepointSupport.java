//  -*- Mode: Java -*-
//
// _StartupTimepointSupport.java

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

package edu.isi.powerloom.extensions.timepoint;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.powerloom.logic.*;
import edu.isi.stella.*;
import edu.isi.stella.utilities.*;

public class _StartupTimepointSupport {
  public static void startupTimepointSupport() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/TIMEPOINT-SUPPORT", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Timepoint.SGT_TIMEPOINT_KB_TIMEPOINT_OF = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-OF", Stella.getStellaModule("/TIMEPOINT-KB", true), 1)));
          Timepoint.SGT_TIMEPOINT_KB_DURATION_OF = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DURATION-OF", Stella.getStellaModule("/TIMEPOINT-KB", true), 1)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_OF$_COMPUTATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-OF*-COMPUTATION", null, 0)));
          Timepoint.KWD_MONDAY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MONDAY", null, 2)));
          Timepoint.SGT_TIMEPOINT_KB_MONDAY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("MONDAY", Stella.getStellaModule("/TIMEPOINT-KB", true), 1)));
          Timepoint.KWD_TUESDAY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TUESDAY", null, 2)));
          Timepoint.SGT_TIMEPOINT_KB_TUESDAY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TUESDAY", Stella.getStellaModule("/TIMEPOINT-KB", true), 1)));
          Timepoint.KWD_WEDNESDAY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("WEDNESDAY", null, 2)));
          Timepoint.SGT_TIMEPOINT_KB_WEDNESDAY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("WEDNESDAY", Stella.getStellaModule("/TIMEPOINT-KB", true), 1)));
          Timepoint.KWD_THURSDAY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("THURSDAY", null, 2)));
          Timepoint.SGT_TIMEPOINT_KB_THURSDAY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("THURSDAY", Stella.getStellaModule("/TIMEPOINT-KB", true), 1)));
          Timepoint.KWD_FRIDAY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FRIDAY", null, 2)));
          Timepoint.SGT_TIMEPOINT_KB_FRIDAY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FRIDAY", Stella.getStellaModule("/TIMEPOINT-KB", true), 1)));
          Timepoint.KWD_SATURDAY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SATURDAY", null, 2)));
          Timepoint.SGT_TIMEPOINT_KB_SATURDAY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SATURDAY", Stella.getStellaModule("/TIMEPOINT-KB", true), 1)));
          Timepoint.KWD_SUNDAY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SUNDAY", null, 2)));
          Timepoint.SGT_TIMEPOINT_KB_SUNDAY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SUNDAY", Stella.getStellaModule("/TIMEPOINT-KB", true), 1)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_STARTUP_TIMEPOINT_SUPPORT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-TIMEPOINT-SUPPORT", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Timepoint.$DATE_TIME_HASH_TABLE$ = StellaHashTable.newStellaHashTable();
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("DATE-TIME-LOGIC-WRAPPER", "(DEFCLASS DATE-TIME-LOGIC-WRAPPER (QUANTITY-LOGIC-WRAPPER) :PUBLIC-SLOTS ((WRAPPER-VALUE :TYPE DATE-TIME-OBJECT :REQUIRED? TRUE)) :PRINT-FORM (IF *PRINTREADABLY?* (PRINT-NATIVE-STREAM STREAM (WRAPPER-VALUE SELF)) (PRINT-NATIVE-STREAM STREAM \"|tw|\" (WRAPPER-VALUE SELF))))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper", "newDateTimeLogicWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.DateTimeObject")});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper", "accessDateTimeLogicWrapperSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineMethodObject("(DEFMETHOD (GENERATE-SPECIALIZED-TERM OBJECT) ((SELF DATE-TIME-LOGIC-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper", "generateSpecializedTerm", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (HASH-CODE INTEGER) ((SELF DATE-TIME-LOGIC-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper", "hashCode_", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (OBJECT-EQL? BOOLEAN) ((SELF DATE-TIME-LOGIC-WRAPPER) (X OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper", "objectEqlP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("WRAP-DATE-TIME", "(DEFUN (WRAP-DATE-TIME DATE-TIME-LOGIC-WRAPPER) ((VALUE DATE-TIME-OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"Return an interned LOGIC-WRAPPER for `value'.  This assures us\nthat all logic-wrapped DATE-TIME-OBJECTs are the same object.\")", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.Timepoint", "wrapDateTime", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.DateTimeObject")}), null);
          Stella.defineFunctionObject("HELP-GET-CALENDAR-TIME", "(DEFUN (HELP-GET-CALENDAR-TIME DATE-TIME-LOGIC-WRAPPER) ((ITEM OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.Timepoint", "helpGetCalendarTime", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("HELP-GET-TIME-DURATION", "(DEFUN (HELP-GET-TIME-DURATION DATE-TIME-LOGIC-WRAPPER) ((ITEM OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.Timepoint", "helpGetTimeDuration", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("HELP-GET-TIME-OBJECT", "(DEFUN (HELP-GET-TIME-OBJECT DATE-TIME-LOGIC-WRAPPER) ((ITEM OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.Timepoint", "helpGetTimeObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("HELP-GET-INTEGER", "(DEFUN (HELP-GET-INTEGER INTEGER) ((OBJ OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.Timepoint", "helpGetInteger", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("HELP-GET-FLOAT", "(DEFUN (HELP-GET-FLOAT FLOAT) ((OBJ OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.Timepoint", "helpGetFloat", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("HELP-GET-TIMEZONE", "(DEFUN (HELP-GET-TIMEZONE FLOAT) ((OBJ OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.Timepoint", "helpGetTimezone", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("IS-CURRENT-TIME-SPEC?", "(DEFUN (IS-CURRENT-TIME-SPEC? BOOLEAN) ((SPEC OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.Timepoint", "isCurrentTimeSpecP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CAN-BIND-ALL?", "(DEFUN (CAN-BIND-ALL? BOOLEAN) ((PL-OBJECTS CONS) (VALUES CONS)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.Timepoint", "canBindAllP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("TIMEPOINT-OF-CONSTRAINT", "(DEFUN (TIMEPOINT-OF-CONSTRAINT OBJECT) ((MISSING-ARGUMENT INTEGER-WRAPPER) (X1 STRING-WRAPPER) (X2 DATE-TIME-LOGIC-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.Timepoint", "timepointOfConstraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.stella.StringWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper")}), null);
          Stella.defineFunctionObject("TIMEPOINT-OF*-COMPUTATION", "(DEFUN (TIMEPOINT-OF*-COMPUTATION DATE-TIME-LOGIC-WRAPPER) ((YY INTEGER-WRAPPER) (MM INTEGER-WRAPPER) (DD INTEGER-WRAPPER) (HR INTEGER-WRAPPER) (MIN INTEGER-WRAPPER) (SEC NUMBER-WRAPPER) (TZ OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.Timepoint", "timepointOf$Computation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("TIMEPOINT-OF*-EVALUATOR", "(DEFUN TIMEPOINT-OF*-EVALUATOR ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.Timepoint", "timepointOf$Evaluator", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("TIMEPOINT-OF*-SPECIALIST", "(DEFUN (TIMEPOINT-OF*-SPECIALIST KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.Timepoint", "timepointOf$Specialist", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("DURATION-OF-CONSTRAINT", "(DEFUN (DURATION-OF-CONSTRAINT OBJECT) ((MISSING-ARGUMENT INTEGER-WRAPPER) (X1 STRING-WRAPPER) (X2 DATE-TIME-LOGIC-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.Timepoint", "durationOfConstraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.stella.StringWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper")}), null);
          Stella.defineFunctionObject("TIME-MINUS-CONSTRAINT", "(DEFUN (TIME-MINUS-CONSTRAINT OBJECT) ((MISSING-ARGUMENT INTEGER-WRAPPER) (X1 DATE-TIME-LOGIC-WRAPPER) (X2 DATE-TIME-LOGIC-WRAPPER) (X3 DATE-TIME-LOGIC-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.Timepoint", "timeMinusConstraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper")}), null);
          Stella.defineFunctionObject("TIME-PLUS-CONSTRAINT", "(DEFUN (TIME-PLUS-CONSTRAINT OBJECT) ((MISSING-ARGUMENT INTEGER-WRAPPER) (X1 DATE-TIME-LOGIC-WRAPPER) (X2 DATE-TIME-LOGIC-WRAPPER) (X3 DATE-TIME-LOGIC-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.Timepoint", "timePlusConstraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper")}), null);
          Stella.defineFunctionObject("DOW-KEYWORD-TO-INSTANCE", "(DEFUN (DOW-KEYWORD-TO-INSTANCE LOGIC-OBJECT) ((DOW KEYWORD)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.Timepoint", "dowKeywordToInstance", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("TIMEPOINT-YEAR-COMPUTATION", "(DEFUN (TIMEPOINT-YEAR-COMPUTATION INTEGER-WRAPPER) ((TIMEPOINT DATE-TIME-LOGIC-WRAPPER) (TIMEZONE OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper", "timepointYearComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("TIMEPOINT-MONTH-COMPUTATION", "(DEFUN (TIMEPOINT-MONTH-COMPUTATION INTEGER-WRAPPER) ((TIMEPOINT DATE-TIME-LOGIC-WRAPPER) (TIMEZONE OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper", "timepointMonthComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("TIMEPOINT-DAY-COMPUTATION", "(DEFUN (TIMEPOINT-DAY-COMPUTATION INTEGER-WRAPPER) ((TIMEPOINT DATE-TIME-LOGIC-WRAPPER) (TIMEZONE OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper", "timepointDayComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("TIMEPOINT-DAY-OF-WEEK-COMPUTATION", "(DEFUN (TIMEPOINT-DAY-OF-WEEK-COMPUTATION LOGIC-OBJECT) ((TIMEPOINT DATE-TIME-LOGIC-WRAPPER) (TIMEZONE OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper", "timepointDayOfWeekComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("TIMEPOINT-HOUR-COMPUTATION", "(DEFUN (TIMEPOINT-HOUR-COMPUTATION INTEGER-WRAPPER) ((TIMEPOINT DATE-TIME-LOGIC-WRAPPER) (TIMEZONE OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper", "timepointHourComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("TIMEPOINT-MINUTE-COMPUTATION", "(DEFUN (TIMEPOINT-MINUTE-COMPUTATION INTEGER-WRAPPER) ((TIMEPOINT DATE-TIME-LOGIC-WRAPPER) (TIMEZONE OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper", "timepointMinuteComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("TIMEPOINT-SECOND-COMPUTATION", "(DEFUN (TIMEPOINT-SECOND-COMPUTATION NUMBER-WRAPPER) ((TIMEPOINT DATE-TIME-LOGIC-WRAPPER) (TIMEZONE OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper", "timepointSecondComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("TIMEPOINT-DATE-COMPUTATION", "(DEFUN (TIMEPOINT-DATE-COMPUTATION STRING-WRAPPER) ((TIMEPOINT DATE-TIME-LOGIC-WRAPPER) (TIMEZONE OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper", "timepointDateComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("TIMEPOINT-TIME-COMPUTATION", "(DEFUN (TIMEPOINT-TIME-COMPUTATION STRING-WRAPPER) ((TIMEPOINT DATE-TIME-LOGIC-WRAPPER) (TIMEZONE OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper", "timepointTimeComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("FORMAT-TIMEPOINT-COMPUTATION", "(DEFUN (FORMAT-TIMEPOINT-COMPUTATION STRING-WRAPPER) ((TIMEPOINT DATE-TIME-LOGIC-WRAPPER) (TIMEZONE OBJECT) (CONTROL STRING-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper", "formatTimepointComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.StringWrapper")}), null);
          Stella.defineFunctionObject("STARTUP-TIMEPOINT-SUPPORT", "(DEFUN STARTUP-TIMEPOINT-SUPPORT () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.extensions.timepoint._StartupTimepointSupport", "startupTimepointSupport", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Timepoint.SYM_TIMEPOINT_SUPPORT_STARTUP_TIMEPOINT_SUPPORT);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, edu.isi.powerloom.extensions.Extensions.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupTimepointSupport"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("TIMEPOINT-SUPPORT")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *DATE-TIME-HASH-TABLE* (STELLA-HASH-TABLE OF DATE-TIME-OBJECT DATE-TIME-LOGIC-WRAPPER) (NEW STELLA-HASH-TABLE) :DOCUMENTATION \"Table for interning date-time logic wrappers\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
