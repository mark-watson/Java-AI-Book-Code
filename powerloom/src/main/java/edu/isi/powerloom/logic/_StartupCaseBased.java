//  -*- Mode: Java -*-
//
// _StartupCaseBased.java

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

public class _StartupCaseBased {
  static void helpStartupCaseBased1() {
    {
      Logic.KWD_WEIGHTED_VOTE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("WEIGHTED-VOTE", null, 2)));
      Logic.SYM_LOGIC_CASE_MATCH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CASE-MATCH", null, 0)));
      Logic.SYM_PL_KERNEL_KB_CASE_MATCH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CASE-MATCH", Stella.getStellaModule("/PL-KERNEL-KB", true), 0)));
      Logic.KWD_WEIGHTED_AVERAGE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("WEIGHTED-AVERAGE", null, 2)));
      Logic.SGT_STELLA_FLOAT_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FLOAT-WRAPPER", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_STELLA_INTEGER_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INTEGER-WRAPPER", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.KWD_AVERAGE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("AVERAGE", null, 2)));
      Logic.SYM_LOGIC_OBJECT_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OBJECT-NAME", null, 0)));
      Logic.SYM_STELLA_SECOND = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SECOND", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_CASES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CASES", null, 0)));
      Logic.SYM_LOGIC_SOFT_EQ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SOFT-EQ", null, 0)));
      Logic.SYM_LOGIC_STARTUP_CASE_BASED = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-CASE-BASED", null, 0)));
    }
  }

  static void helpStartupCaseBased2() {
    {
      Logic.$CASE_SOLUTION_COMBINATION$ = Logic.KWD_WEIGHTED_VOTE;
      Logic.$CASE_RULE_NAMES$ = List.newList();
      Logic.$VISITED_INSTANCES$ = List.newList();
      Logic.$VISITED_PROPOSITIONS$ = List.newList();
      Logic.$CASE_ANTECEDENT_TABLE$ = StringHashTable.newStringHashTable();
      Logic.$CASE_TYPES_TABLE$ = StringHashTable.newStringHashTable();
      Logic.$CASE_NAME_TABLE$ = HashTable.newHashTable();
    }
  }

  static void helpStartupCaseBased3() {
    {
      Stella.defineFunctionObject("SET-NUM-NEIGHBORS", "(DEFUN SET-NUM-NEIGHBORS ((D INTEGER)) :COMMAND? TRUE :PUBLIC? TRUE :DOCUMENTATION \"Sets the number of nearest neighbors to predict from.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setNumNeighbors", new java.lang.Class [] {java.lang.Integer.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "setNumNeighborsEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("SET-CASE-SOLUTION-COMBINATION", "(DEFUN SET-CASE-SOLUTION-COMBINATION ((K KEYWORD)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setCaseSolutionCombination", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("SET-NUM-TRAINING-PER-CASE", "(DEFUN SET-NUM-TRAINING-PER-CASE ((D INTEGER)) :COMMAND? TRUE :PUBLIC? TRUE :DOCUMENTATION \"Sets the number of training examples for each case in the training set.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setNumTrainingPerCase", new java.lang.Class [] {java.lang.Integer.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "setNumTrainingPerCaseEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("CLEAR-CASES", "(DEFUN CLEAR-CASES () :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "clearCases", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("ADD-ALL-CLASS-INSTANCES-TO-CASE-RULE", "(DEFUN ADD-ALL-CLASS-INSTANCES-TO-CASE-RULE ((KIND SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "addAllClassInstancesToCaseRule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("FINALIZE-CASES", "(DEFUN FINALIZE-CASES ((KIND SYMBOL)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "finalizeCases", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("BUILD-CASE-RULE", "(DEFUN BUILD-CASE-RULE ((KIND SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildCaseRule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("ADD-CASE", "(DEFUN ADD-CASE ((INST SYMBOL) (KIND SYMBOL)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "addCase", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("BUILD-CASE-FROM-INSTANCE", "(DEFUN BUILD-CASE-FROM-INSTANCE ((INST LOGIC-OBJECT) (KIND SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "buildCaseFromInstance", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("CREATE-CASE-INSTANCE-VECTOR", "(DEFUN (CREATE-CASE-INSTANCE-VECTOR VECTOR) ((CLASS SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createCaseInstanceVector", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("MATCH-INSTANCES", "(DEFUN (MATCH-INSTANCES FLOAT-WRAPPER) ((X LOGIC-OBJECT) (Y LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "matchInstances", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("CREATE-CASE-VALUE-VECTOR", "(DEFUN (CREATE-CASE-VALUE-VECTOR VECTOR) ((INSTANCES (LIST OF LOGIC-OBJECT)) (SLOT SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createCaseValueVector", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("GUESS", "(DEFUN (GUESS OBJECT) ((INST-NAME SYMBOL) (SLOT-NAME SYMBOL)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "guess", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("GENERATE-CASE-BASED-ANSWER", "(DEFUN (GENERATE-CASE-BASED-ANSWER OBJECT) ((PROBE LOGIC-OBJECT) (SLOT SURROGATE) (CASES LIST)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "generateCaseBasedAnswer", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("COMBINE-CASE-ANSWERS", "(DEFUN (COMBINE-CASE-ANSWERS OBJECT) ((CLOSEST (VECTOR OF INTEGER-WRAPPER)) (SCORES (VECTOR OF FLOAT-WRAPPER)) (SLOTS (VECTOR OF OBJECT))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "combineCaseAnswers", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("TRAIN-CASE-MATCHER", "(DEFUN TRAIN-CASE-MATCHER ((CLASS-NAME SYMBOL) (SLOT-NAME SYMBOL) (CYCLES INTEGER)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "trainCaseMatcher", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol"), java.lang.Integer.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "trainCaseMatcherEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("GENERATE-CASE-RULE-WO-SLOT", "(DEFUN GENERATE-CASE-RULE-WO-SLOT ((CASES (VECTOR OF LOGIC-OBJECT)) (CLASS-NAME SYMBOL) (SLOT-NAME SYMBOL)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "generateCaseRuleWoSlot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("TRAIN-AND-TEST-CASE-MATCHER", "(DEFUN (TRAIN-AND-TEST-CASE-MATCHER FLOAT) ((CLASS-NAME SYMBOL) (SLOT-NAME SYMBOL) (NUM-TRAIN INTEGER) (NUM-TEST INTEGER) (CYCLES INTEGER)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "trainAndTestCaseMatcher", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol"), java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Integer.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "trainAndTestCaseMatcherEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("TEST-CASE-BASED-REASONER", "(DEFUN (TEST-CASE-BASED-REASONER FLOAT) ((CLASS-NAME SYMBOL) (SLOT-NAME SYMBOL) (NUM-TRAIN INTEGER) (NUM-TEST INTEGER)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "testCaseBasedReasoner", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol"), java.lang.Integer.TYPE, java.lang.Integer.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "testCaseBasedReasonerEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("TEST-CASE-MATCHER", "(DEFUN (TEST-CASE-MATCHER FLOAT) ((CLASS-NAME SYMBOL) (SLOT-NAME SYMBOL)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "testCaseMatcher", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "testCaseMatcherEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("GENERATE-CASE-TRAINING-EXAMPLES", "(DEFUN (GENERATE-CASE-TRAINING-EXAMPLES INTEGER) ((INSTANCES (VECTOR OF LOGIC-OBJECT)) (SLOT SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "generateCaseTrainingExamples", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("NORMALIZE-NUMBERS", "(DEFUN NORMALIZE-NUMBERS ((VECT (VECTOR OF FLOAT-WRAPPER))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "normalizeNumbers", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("CLEAR-SLOT-FROM-CLASS", "(DEFUN CLEAR-SLOT-FROM-CLASS ((CLASS-NAME SYMBOL) (SLOT-NAME SYMBOL)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "clearSlotFromClass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("LOGIC-SYMBOL", "(DEFUN (LOGIC-SYMBOL OBJECT) ((OBJ OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "logicSymbol", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CALCULATE-CASE-MATCH", "(DEFUN (CALCULATE-CASE-MATCH FLOAT) ((X OBJECT) (Y OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "calculateCaseMatch", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("GET-MOST-SPECIFIC-CLASSES", "(DEFUN (GET-MOST-SPECIFIC-CLASSES CONS) ((INSTANCE LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "getMostSpecificClasses", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("FIND-UNIQUE-VARIABLE-NAMES", "(DEFUN (FIND-UNIQUE-VARIABLE-NAMES LIST) ((TREE CONS) (NAMES (LIST OF SYMBOL))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "findUniqueVariableNames", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("VARIABLIZE-CONS-PROPOSITIONS", "(DEFUN (VARIABLIZE-CONS-PROPOSITIONS (LIST OF CONS)) ((ANTECEDENT (LIST OF CONS))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "variablizeConsPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("VARIABLIZE-INSTANCES", "(DEFUN (VARIABLIZE-INSTANCES (LIST OF CONS)) ((FORM (LIST OF CONS)) (INSTANCES (LIST OF OBJECT))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "variablizeInstances", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("STRING-ARGUMENT?", "(DEFUN (STRING-ARGUMENT? BOOLEAN) ((CLAUSE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "stringArgumentP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("FILTER-ANTECEDENT", "(DEFUN FILTER-ANTECEDENT ((ANTECEDENT (LIST OF CONS)) (RULE-NAME STRING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "filterAntecedent", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("FIND-MATCHING-CASE-VARS", "(DEFUN (FIND-MATCHING-CASE-VARS CONS) ((CLAUSE CONS) (ANTECEDENT (LIST OF CONS)) (GENERATED-VARIABLES LIST)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "findMatchingCaseVars", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("PARAMETERS-ALIGNED?", "(DEFUN (PARAMETERS-ALIGNED? BOOLEAN) ((CLAUSE1 CONS) (CLAUSE2 CONS) (VARS LIST)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "parametersAlignedP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("VARIABLE-ARG?", "(DEFUN (VARIABLE-ARG? BOOLEAN) ((ARG OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "variableArgP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("BUILD-VARIABLE-CONSTRAINTS", "(DEFUN (BUILD-VARIABLE-CONSTRAINTS CONS) ((INSTANCES (LIST OF SYMBOL))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildVariableConstraints", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("BUILD-TYPE-DEFS", "(DEFUN (BUILD-TYPE-DEFS (LIST OF SYMBOL)) ((INSTANCES (LIST OF SYMBOL))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildTypeDefs", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("SET-PRINT-CASE-DISTANCES", "(DEFUN SET-PRINT-CASE-DISTANCES ((B BOOLEAN)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setPrintCaseDistances", new java.lang.Class [] {java.lang.Boolean.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "setPrintCaseDistancesEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("GET-NEAREST-NEIGHBORS", "(DEFUN (GET-NEAREST-NEIGHBORS (LIST OF TRAINING-EXAMPLE)) ((PROBE TRAINING-EXAMPLE) (CASES (LIST OF TRAINING-EXAMPLE)) (K INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.TrainingExample", "getNearestNeighbors", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TrainingExample"), Native.find_java_class("edu.isi.stella.List"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("EUCLIDEAN-DISTANCE", "(DEFUN (EUCLIDEAN-DISTANCE FLOAT) ((VEC1 (VECTOR OF FLOAT-WRAPPER)) (VEC2 (VECTOR OF FLOAT-WRAPPER))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "euclideanDistance", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("HAMMING-DISTANCE", "(DEFUN (HAMMING-DISTANCE INTEGER) ((VEC1 (VECTOR OF INTEGER-WRAPPER)) (VEC2 (VECTOR OF INTEGER-WRAPPER))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "hammingDistance", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("INTERN-LOGIC-SYMBOL", "(DEFUN (INTERN-LOGIC-SYMBOL SYMBOL) ((NAME STRING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "internLogicSymbol", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("STARTUP-CASE-BASED", "(DEFUN STARTUP-CASE-BASED () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupCaseBased", "startupCaseBased", new java.lang.Class [] {}), null);
      { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_CASE_BASED);

        KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupCaseBased"), Stella.NULL_STRING_WRAPPER);
      }
    }
  }

  public static void startupCaseBased() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupCaseBased.helpStartupCaseBased1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          _StartupCaseBased.helpStartupCaseBased2();
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupCaseBased.helpStartupCaseBased3();
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *LOG-MATCH-RULES* BOOLEAN FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *LOG-ANTECEDENT-CONSTRUCTION* BOOLEAN FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *NUM-NEIGHBORS* INTEGER 3)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CASE-SOLUTION-COMBINATION* KEYWORD :WEIGHTED-VOTE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CASE-RULE-NAMES* (LIST OF SYMBOL) (NEW (LIST OF SYMBOL)))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *NUM-CASES* INTEGER 0)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *NUM-TRAINING-PER-CASE* INTEGER 12)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CASE-VARIABLE-COUNTER* INTEGER 0)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *BASE-COUNTER* INTEGER 0)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *VISITED-INSTANCES* (LIST OF SYMBOL) (NEW (LIST OF SYMBOL)))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *ONLY-VARIABLIZE-VISITED-INSTANCES* BOOLEAN FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *VISITED-PROPOSITIONS* (LIST OF PROPOSITION) (NEW (LIST OF PROPOSITION)))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *SEEN-INSTANCES* (LIST OF SYMBOL) NULL)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *DELETED-CASE-VARIABLES* (LIST OF SYMBOL) NULL)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *SYMBOL-VARIABLE-HASH-TABLE* (HASH-TABLE OF SYMBOL SYMBOL) NULL)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CASE-ANTECEDENT-TABLE* (STRING-HASH-TABLE OF STRING (LIST OF CONS)) (NEW (STRING-HASH-TABLE OF STRING (LIST OF CONS))))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CASE-TYPES-TABLE* (STRING-HASH-TABLE OF STRING (LIST OF SYMBOL)) (NEW (STRING-HASH-TABLE OF STRING (LIST OF SYMBOL))))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CASE-NAME-TABLE* (HASH-TABLE OF SYMBOL (LIST OF SYMBOL)) (NEW (HASH-TABLE OF SYMBOL (LIST OF SYMBOL))))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *PRINT-CASE-DISTANCES* BOOLEAN FALSE)");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
