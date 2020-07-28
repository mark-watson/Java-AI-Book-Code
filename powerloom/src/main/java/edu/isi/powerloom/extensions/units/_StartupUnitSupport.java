//  -*- Mode: Java -*-
//
// _StartupUnitSupport.java

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

package edu.isi.powerloom.extensions.units;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.powerloom.logic.*;
import edu.isi.stella.*;
import edu.isi.stella.utilities.*;

public class _StartupUnitSupport {
  public static void startupUnitSupport() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/UNIT-SUPPORT", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Units.SGT_UNIT_SUPPORT_DIM_NUMBER_LOGIC_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DIM-NUMBER-LOGIC-WRAPPER", null, 1)));
          Units.SYM_STELLA_WRAPPER_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WRAPPER-VALUE", Stella.getStellaModule("/STELLA", true), 0)));
          Units.SGT_UNIT_KB_UNITS = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("UNITS", Stella.getStellaModule("/UNIT-KB", true), 1)));
          Units.SGT_TIMEPOINT_SUPPORT_DATE_TIME_LOGIC_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DATE-TIME-LOGIC-WRAPPER", Stella.getStellaModule("/TIMEPOINT-SUPPORT", true), 1)));
          Units.SGT_STELLA_CALENDAR_DATE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CALENDAR-DATE", Stella.getStellaModule("/STELLA", true), 1)));
          Units.SGT_STELLA_TIME_DURATION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TIME-DURATION", Stella.getStellaModule("/STELLA", true), 1)));
          Units.SGT_LOGIC_PATTERN_VARIABLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PATTERN-VARIABLE", Stella.getStellaModule("/LOGIC", true), 1)));
          Units.SGT_LOGIC_SKOLEM = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SKOLEM", Stella.getStellaModule("/LOGIC", true), 1)));
          Units.SGT_STELLA_CS_VALUE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CS-VALUE", Stella.getStellaModule("/STELLA", true), 1)));
          Units.KWD_FINAL_SUCCESS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FINAL-SUCCESS", null, 2)));
          Units.KWD_TERMINAL_FAILURE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TERMINAL-FAILURE", null, 2)));
          Units.KWD_FAILURE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FAILURE", null, 2)));
          Units.SYM_STELLA_ITERATOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ITERATOR", Stella.getStellaModule("/STELLA", true), 0)));
          Units.KWD_CONTINUING_SUCCESS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTINUING-SUCCESS", null, 2)));
          Units.SGT_STELLA_INTEGER_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INTEGER-WRAPPER", Stella.getStellaModule("/STELLA", true), 1)));
          Units.SGT_UNIT_KB_NUMERATOR_MEASURES = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("NUMERATOR-MEASURES", Stella.getStellaModule("/UNIT-KB", true), 1)));
          Units.SGT_UNIT_KB_DENOMINATOR_MEASURES = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DENOMINATOR-MEASURES", Stella.getStellaModule("/UNIT-KB", true), 1)));
          Units.SGT_LOGIC_LOGIC_OBJECT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("LOGIC-OBJECT", Stella.getStellaModule("/LOGIC", true), 1)));
          Units.SGT_STELLA_NUMBER_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("NUMBER-WRAPPER", Stella.getStellaModule("/STELLA", true), 1)));
          Units.SYM_UNIT_SUPPORT_STARTUP_UNIT_SUPPORT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-UNIT-SUPPORT", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Units.$DIM_NUMBER_HASH_TABLE$ = StellaHashTable.newStellaHashTable();
          Units.$MEASURE_INSTANCE_TABLE$ = HashTable.newHashTable();
          Units.$INSTANCE_MEASURE_TABLE$ = HashTable.newHashTable();
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("DIM-NUMBER-LOGIC-WRAPPER", "(DEFCLASS DIM-NUMBER-LOGIC-WRAPPER (QUANTITY-LOGIC-WRAPPER) :PUBLIC-SLOTS ((WRAPPER-VALUE :TYPE DIM-NUMBER :REQUIRED? TRUE)) :PRINT-FORM (IF *PRINTREADABLY?* (PRINT-NATIVE-STREAM STREAM (WRAPPER-VALUE SELF)) (PRINT-NATIVE-STREAM STREAM \"|uw|\" (WRAPPER-VALUE SELF))))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper", "newDimNumberLogicWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.DimNumber")});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper", "accessDimNumberLogicWrapperSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineMethodObject("(DEFMETHOD (GENERATE-SPECIALIZED-TERM OBJECT) ((SELF DIM-NUMBER-LOGIC-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper", "generateSpecializedTerm", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (HASH-CODE INTEGER) ((SELF DIM-NUMBER-LOGIC-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper", "hashCode_", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (OBJECT-EQL? BOOLEAN) ((SELF DIM-NUMBER-LOGIC-WRAPPER) (X OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper", "objectEqlP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("WRAP-DIM-NUMBER", "(DEFUN (WRAP-DIM-NUMBER DIM-NUMBER-LOGIC-WRAPPER) ((VALUE DIM-NUMBER)) :PUBLIC? TRUE :DOCUMENTATION \"Return an interned LOGIC-WRAPPER for `value'.  This assures us\nthat all logic-wrapped DIM-NUMBERs are the same object.\")", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "wrapDimNumber", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.DimNumber")}), null);
          Stella.defineMethodObject("(DEFMETHOD (GET-UNIT STRING) ((SELF DIM-NUMBER-LOGIC-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper", "getUnit", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (GET-BASE-UNIT STRING) ((SELF DIM-NUMBER-LOGIC-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper", "getBaseUnit", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (GET-MAGNITUDE FLOAT) ((SELF DIM-NUMBER-LOGIC-WRAPPER) (UNITS STRING)))", Native.find_java_method("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper", "getMagnitude", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("HELP-GET-DIM-NUMBER", "(DEFUN (HELP-GET-DIM-NUMBER DIM-NUMBER-LOGIC-WRAPPER) ((ITEM OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "helpGetDimNumber", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("HELP-GET-UNIT-VALUE", "(DEFUN (HELP-GET-UNIT-VALUE DIM-NUMBER-LOGIC-WRAPPER) ((MAGNITUDE OBJECT) (UNITS OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "helpGetUnitValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("UNITS-EVALUATOR", "(DEFUN UNITS-EVALUATOR ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "unitsEvaluator", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("UNITS-SPECIALIST", "(DEFUN (UNITS-SPECIALIST KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "unitsSpecialist", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("U-PLUS-CONSTRAINT", "(DEFUN (U-PLUS-CONSTRAINT OBJECT) ((MISSING-ARGUMENT INTEGER-WRAPPER) (X1 DIM-NUMBER-LOGIC-WRAPPER) (X2 DIM-NUMBER-LOGIC-WRAPPER) (X3 DIM-NUMBER-LOGIC-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "uPlusConstraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper")}), null);
          Stella.defineFunctionObject("U-MINUS-CONSTRAINT", "(DEFUN (U-MINUS-CONSTRAINT OBJECT) ((MISSING-ARGUMENT INTEGER-WRAPPER) (X1 DIM-NUMBER-LOGIC-WRAPPER) (X2 DIM-NUMBER-LOGIC-WRAPPER) (X3 DIM-NUMBER-LOGIC-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "uMinusConstraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper")}), null);
          Stella.defineFunctionObject("U-TIMES-CONSTRAINT", "(DEFUN (U-TIMES-CONSTRAINT OBJECT) ((MISSING-ARGUMENT INTEGER-WRAPPER) (X1 DIM-NUMBER-LOGIC-WRAPPER) (X2 DIM-NUMBER-LOGIC-WRAPPER) (X3 DIM-NUMBER-LOGIC-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "uTimesConstraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper")}), null);
          Stella.defineFunctionObject("U-DIVIDE-CONSTRAINT", "(DEFUN (U-DIVIDE-CONSTRAINT OBJECT) ((MISSING-ARGUMENT INTEGER-WRAPPER) (X1 DIM-NUMBER-LOGIC-WRAPPER) (X2 DIM-NUMBER-LOGIC-WRAPPER) (X3 DIM-NUMBER-LOGIC-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "uDivideConstraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper"), Native.find_java_class("edu.isi.powerloom.extensions.units.DimNumberLogicWrapper")}), null);
          Stella.defineFunctionObject("U-ABS-SPECIALIST", "(DEFUN (U-ABS-SPECIALIST KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "uAbsSpecialist", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("U-SIGNUM-SPECIALIST", "(DEFUN (U-SIGNUM-SPECIALIST KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "uSignumSpecialist", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("MINIMUM-OF-UNITS-SPECIALIST", "(DEFUN (MINIMUM-OF-UNITS-SPECIALIST KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "minimumOfUnitsSpecialist", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("MAXIMUM-OF-UNITS-SPECIALIST", "(DEFUN (MAXIMUM-OF-UNITS-SPECIALIST KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "maximumOfUnitsSpecialist", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("SUM-OF-UNITS-SPECIALIST", "(DEFUN (SUM-OF-UNITS-SPECIALIST KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "sumOfUnitsSpecialist", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("U-VALUE-MEASURE-SPECIALIST", "(DEFUN (U-VALUE-MEASURE-SPECIALIST KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "uValueMeasureSpecialist", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("ARGUMENT-MATCHES-LIST-HELPER?", "(DEFUN (ARGUMENT-MATCHES-LIST-HELPER? BOOLEAN) ((ARGUMENT OBJECT) (THE-LIST LIST)))", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "argumentMatchesListHelperP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("INTEGER-TO-MEASURES-HELPER", "(DEFUN (INTEGER-TO-MEASURES-HELPER KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD) (CODE INTEGER)))", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "integerToMeasuresHelper", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("U-BASE-MEASURES-SPECIALIST", "(DEFUN (U-BASE-MEASURES-SPECIALIST KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "uBaseMeasuresSpecialist", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("GET-OBJECT-PID", "(DEFUN (GET-OBJECT-PID RATIO) ((OBJ OBJECT)))", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "getObjectPid", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("COMENSURATE-UNITS-SPECIALIST", "(DEFUN (COMENSURATE-UNITS-SPECIALIST KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "comensurateUnitsSpecialist", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("INITIALIZE-MEASURE-CONCEPTS", "(DEFUN INITIALIZE-MEASURE-CONCEPTS ())", Native.find_java_method("edu.isi.powerloom.extensions.units.Units", "initializeMeasureConcepts", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("STARTUP-UNIT-SUPPORT", "(DEFUN STARTUP-UNIT-SUPPORT () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.extensions.units._StartupUnitSupport", "startupUnitSupport", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Units.SYM_UNIT_SUPPORT_STARTUP_UNIT_SUPPORT);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, edu.isi.powerloom.extensions.Extensions.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupUnitSupport"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("UNIT-SUPPORT")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *DIM-NUMBER-HASH-TABLE* (STELLA-HASH-TABLE OF DIM-NUMBER DIM-NUMBER-LOGIC-WRAPPER) (NEW STELLA-HASH-TABLE) :DOCUMENTATION \"Table for interning dim number logic wrappers\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *MEASURE-INSTANCE-TABLE* (HASH-TABLE OF MEASURE LOGIC-OBJECT) (NEW HASH-TABLE) :DOCUMENTATION \"Mapping table from measure objects to their PowerLoom representation.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *INSTANCE-MEASURE-TABLE* (HASH-TABLE OF LOGIC-OBJECT MEASURE) (NEW HASH-TABLE) :DOCUMENTATION \"Mapping table from PowerLoom representations of measures to measure objects\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
