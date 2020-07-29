//  -*- Mode: Java -*-
//
// _StartupMachineLearning.java

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

public class _StartupMachineLearning {
  static void helpStartupMachineLearning1() {
    {
      Logic.SGT_LOGIC_TRAINING_EXAMPLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TRAINING-EXAMPLE", null, 1)));
      Logic.SYM_LOGIC_CONCEPT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CONCEPT", null, 0)));
      Logic.SYM_STELLA_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NAME", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_INPUT_FEATURES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INPUT-FEATURES", null, 0)));
      Logic.SYM_LOGIC_INPUT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INPUT", null, 0)));
      Logic.SYM_LOGIC_FACTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FACTS", null, 0)));
      Logic.SYM_LOGIC_NN_HIDDEN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NN-HIDDEN", null, 0)));
      Logic.SYM_LOGIC_OUTPUT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OUTPUT", null, 0)));
      Logic.SYM_LOGIC_TEMP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TEMP", null, 0)));
      Logic.SYM_LOGIC_CACHED_SOLUTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CACHED-SOLUTION", null, 0)));
      Logic.SYM_LOGIC_DEFRELATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFRELATION", null, 0)));
      Logic.SYM_STELLA_THING = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("THING", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_DEFRULE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFRULE", null, 0)));
      Logic.SYM_LOGIC_pY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?Y", null, 0)));
      Logic.SYM_STELLA_ge = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule(">=", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_el = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("=<", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.KWD_IN = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("IN", null, 2)));
      Logic.SYM_LOGIC_STARTUP_MACHINE_LEARNING = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-MACHINE-LEARNING", null, 0)));
    }
  }

  public static void startupMachineLearning() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupMachineLearning.helpStartupMachineLearning1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Logic.$TRAINING_EXAMPLES$ = List.newList();
          Logic.$TESTING_EXAMPLES$ = List.newList();
          Logic.$TABOO_OPERATORS$ = List.newList();
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("TRAINING-EXAMPLE", "(DEFCLASS TRAINING-EXAMPLE (STANDARD-OBJECT) :DOCUMENTATION \"A single example of a proposition paired with the score\n  that should be returned and the module it should be evaluated in.\" :SLOTS ((QUERY :TYPE CONS) (CONCEPT :TYPE SYMBOL) (NAME :TYPE SYMBOL) (SCORE :TYPE PARTIAL-MATCH-SCORE) (MODULE :TYPE MODULE) (INPUT-FEATURES :TYPE LIST) (INPUT :TYPE VECTOR) (FACTS :TYPE (CONS OF CONS)) (NN-HIDDEN :TYPE (VECTOR OF FLOAT-WRAPPER)) (OUTPUT :TYPE OBJECT) (TEMP :TYPE FLOAT) (CACHED-SOLUTION :TYPE OBJECT) (TIMESTAMP :TYPE TIMESTAMP)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.TrainingExample", "newTrainingExample", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.TrainingExample", "accessTrainingExampleSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TrainingExample"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("SET-CLOSED-WORLD-TRAINING-EXAMPLES", "(DEFUN SET-CLOSED-WORLD-TRAINING-EXAMPLES ((B BOOLEAN)) :COMMAND? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setClosedWorldTrainingExamples", new java.lang.Class [] {java.lang.Boolean.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "setClosedWorldTrainingExamplesEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("PRINT-TRAINING-EXAMPLE", "(DEFUN PRINT-TRAINING-EXAMPLE ((EXAMPLE TRAINING-EXAMPLE)))", Native.find_java_method("edu.isi.powerloom.logic.TrainingExample", "printTrainingExample", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TrainingExample")}), null);
          Stella.defineFunctionObject("ADD-TRAINING-EXAMPLE", "(DEFUN ADD-TRAINING-EXAMPLE ((FORM CONS) (SCORE PARTIAL-MATCH-SCORE)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :PUBLIC? TRUE :DOCUMENTATION \"Add a query and score pair to the master list of \n  training examples\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "addTrainingExample", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Double.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "addTrainingExampleEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("ADD-TRAINING-EXAMPLE-IN-MODULE", "(DEFUN ADD-TRAINING-EXAMPLE-IN-MODULE ((FORM CONS) (SCORE PARTIAL-MATCH-SCORE) (MODULE SYMBOL)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "addTrainingExampleInModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Double.TYPE, Native.find_java_class("edu.isi.stella.Symbol")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "addTrainingExampleInModuleEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("ADD-TESTING-EXAMPLE", "(DEFUN ADD-TESTING-EXAMPLE ((FORM CONS) (SCORE PARTIAL-MATCH-SCORE)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :PUBLIC? TRUE :DOCUMENTATION \"Add a query and score pair to the master list of \n  testing examples\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "addTestingExample", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Double.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "addTestingExampleEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("CLEAR-TRAINING-EXAMPLES", "(DEFUN CLEAR-TRAINING-EXAMPLES () :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "clearTrainingExamples", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("SHUFFLE-LIST", "(DEFUN SHUFFLE-LIST ((CARDS LIST)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "shuffleList", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("SHUFFLE-VECTOR", "(DEFUN SHUFFLE-VECTOR ((CARDS VECTOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "shuffleVector", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector")}), null);
          Stella.defineFunctionObject("SAVE-TRAINING-EXAMPLES", "(DEFUN SAVE-TRAINING-EXAMPLES () :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "saveTrainingExamples", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("CREATE-PROPOSITIONAL-TRAINING-EXAMPLES", "(DEFUN (CREATE-PROPOSITIONAL-TRAINING-EXAMPLES INTEGER) ((EXAMPLES (LIST OF TRAINING-EXAMPLE)) (NAME-FILE OUTPUT-FILE-STREAM) (DATA-FILE OUTPUT-FILE-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createPropositionalTrainingExamples", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.OutputFileStream"), Native.find_java_class("edu.isi.stella.OutputFileStream")}), null);
          Stella.defineFunctionObject("FILL-IN-EXAMPLE-OUTPUTS", "(DEFUN FILL-IN-EXAMPLE-OUTPUTS ((EXAMPLES (LIST OF TRAINING-EXAMPLE)) (SLOT-NAME SYMBOL)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "fillInExampleOutputs", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("DETECT-NOISE-IN-TRAINING-EXAMPLES", "(DEFUN DETECT-NOISE-IN-TRAINING-EXAMPLES ((EXAMPLES (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "detectNoiseInTrainingExamples", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("GET-CLASSIFICATION-RELATIONS", "(DEFUN (GET-CLASSIFICATION-RELATIONS (LIST OF PROPOSITION)) ((CONS-QUERY CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getClassificationRelations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CREATE-INPUT-SIGNATURE", "(DEFUN (CREATE-INPUT-SIGNATURE (VECTOR OF INTEGER-WRAPPER)) ((CONS-QUERY CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createInputSignature", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("GENERATE-CLASSIFICATION-RULE", "(DEFUN GENERATE-CLASSIFICATION-RULE ((INSTANCES (VECTOR OF LOGIC-OBJECT)) (CONCEPT-NAME SYMBOL) (CLASS-NAME SYMBOL) (BUILD-RULE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "generateClassificationRule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("BUILD-CLASSIFICATION-RULE", "(DEFUN BUILD-CLASSIFICATION-RULE ((KIND SYMBOL) (CLASS-NAME SYMBOL)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildClassificationRule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("OLD-GENERATE-CLASSIFICATION-TRAINING-EXAMPLES", "(DEFUN (OLD-GENERATE-CLASSIFICATION-TRAINING-EXAMPLES INTEGER) ((INSTANCES (VECTOR OF LOGIC-OBJECT)) (CONCEPT SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "oldGenerateClassificationTrainingExamples", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("TEST-DOMAIN-THEORY", "(DEFUN TEST-DOMAIN-THEORY ((RELATION-NAME SYMBOL) (CLASS-NAME SYMBOL)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "testDomainTheory", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("TEST-THEORY-OVER-EXAMPLES", "(DEFUN (TEST-THEORY-OVER-EXAMPLES FLOAT) ((EXAMPLES (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "testTheoryOverExamples", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("GENERATE-TRAINING-EXAMPLES", "(DEFUN (GENERATE-TRAINING-EXAMPLES INTEGER) ((INSTANCES (VECTOR OF LOGIC-OBJECT)) (CONCEPT SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "generateTrainingExamples", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("GENERATE-CLASSIFICATION-TRAINING-EXAMPLES", "(DEFUN (GENERATE-CLASSIFICATION-TRAINING-EXAMPLES INTEGER) ((INSTANCES (VECTOR OF LOGIC-OBJECT)) (CONCEPT SURROGATE) (CREATE-SIGNATURE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "generateClassificationTrainingExamples", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.Surrogate"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("GENERATE-REGRESSION-RULE-WO-SLOT", "(DEFUN GENERATE-REGRESSION-RULE-WO-SLOT ((CASES (VECTOR OF LOGIC-OBJECT)) (SLOT-NAME SYMBOL) (CLASS-NAME SYMBOL) (REALLY-BUILD-RULE BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "generateRegressionRuleWoSlot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("GENERATE-REGRESSION-TRAINING-EXAMPLES", "(DEFUN (GENERATE-REGRESSION-TRAINING-EXAMPLES INTEGER) ((INSTANCES (VECTOR OF LOGIC-OBJECT)) (SLOT SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "generateRegressionTrainingExamples", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("APPROXIMATE", "(DEFUN (APPROXIMATE FLOAT) ((INST-NAME SYMBOL) (SLOT-NAME SYMBOL)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "approximate", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "approximateEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("GENERATE-SLOT-APPROXIMATION", "(DEFUN (GENERATE-SLOT-APPROXIMATION FLOAT) ((INST-NAME SYMBOL) (SLOT SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "generateSlotApproximation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("FLOAT-FUNCTION?", "(DEFUN (FLOAT-FUNCTION? BOOLEAN) ((RELATION SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "floatFunctionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("SET-STRUCTURE-DEPTH", "(DEFUN SET-STRUCTURE-DEPTH ((D INTEGER)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setStructureDepth", new java.lang.Class [] {java.lang.Integer.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "setStructureDepthEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("ADD-TABOO-OPERATORS", "(DEFUN ADD-TABOO-OPERATORS ((S SYMBOL)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "addTabooOperators", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("GET-ASSERTION-STRUCTURE", "(DEFUN (GET-ASSERTION-STRUCTURE (LIST OF CONS)) ((INST SYMBOL) (DEPTH INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getAssertionStructure", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("HELP-GET-ASSERTION-STRUCTURE", "(DEFUN (HELP-GET-ASSERTION-STRUCTURE (LIST OF CONS)) ((INST SYMBOL) (DEPTH INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "helpGetAssertionStructure", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("COLLECT-FACTS-IN-EXAMPLES", "(DEFUN COLLECT-FACTS-IN-EXAMPLES ((EXAMPLES (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "collectFactsInExamples", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("OLD-RECURSIVE-BUILD-ANTECEDENT", "(DEFUN (OLD-RECURSIVE-BUILD-ANTECEDENT CONS) ((INST SYMBOL) (DEPTH INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "oldRecursiveBuildAntecedent", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("GET-ARGUMENT-BINDING", "(DEFUN (GET-ARGUMENT-BINDING OBJECT) ((ARG OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getArgumentBinding", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CONSIFY-ARGUMENT", "(DEFUN (CONSIFY-ARGUMENT OBJECT) ((ARG OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "consifyArgument", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("PROPOSITION-TO-CONS", "(DEFUN (PROPOSITION-TO-CONS CONS) ((PROP PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "propositionToCons", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("THINGIFY-UNTYPED-INSTANCES", "(DEFUN THINGIFY-UNTYPED-INSTANCES () :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "thingifyUntypedInstances", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("STARTUP-MACHINE-LEARNING", "(DEFUN STARTUP-MACHINE-LEARNING () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupMachineLearning", "startupMachineLearning", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_MACHINE_LEARNING);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupMachineLearning"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *TRAINING-EXAMPLES* (LIST OF TRAINING-EXAMPLE) (NEW LIST))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *TESTING-EXAMPLES* (LIST OF TRAINING-EXAMPLE) (NEW LIST))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CLOSED-WORLD-TRAINING-EXAMPLES* BOOLEAN TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *MAX-STRUCTURE-DEPTH* INTEGER 3)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *DROP-FUNCTION-VALUES?* BOOLEAN TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *TABOO-OPERATORS* (LIST OF SURROGATE) (NEW (LIST OF SURROGATE)))");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
