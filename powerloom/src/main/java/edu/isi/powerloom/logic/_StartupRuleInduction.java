//  -*- Mode: Java -*-
//
// _StartupRuleInduction.java

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

public class _StartupRuleInduction {
  static void helpStartupRuleInduction1() {
    {
      Logic.KWD_TOP_DOWN = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TOP-DOWN", null, 2)));
      Logic.SGT_LOGIC_DECISION_TREE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DECISION-TREE", null, 1)));
      Logic.SYM_LOGIC_FEATURE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FEATURE", null, 0)));
      Logic.SYM_LOGIC_FEATURE_INDEX = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FEATURE-INDEX", null, 0)));
      Logic.SYM_LOGIC_TRUE_BRANCH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TRUE-BRANCH", null, 0)));
      Logic.SYM_LOGIC_FALSE_BRANCH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FALSE-BRANCH", null, 0)));
      Logic.KWD_BOTTOM_UP = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("BOTTOM-UP", null, 2)));
      Logic.SYM_STELLA_l = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("<", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.KWD_DECISION_TREE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DECISION-TREE", null, 2)));
      Logic.SYM_LOGIC_USER_THING = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("USER-THING", null, 0)));
      Logic.SYM_LOGIC_STARTUP_RULE_INDUCTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-RULE-INDUCTION", null, 0)));
    }
  }

  static void helpStartupRuleInduction2() {
    {
      Stella.defineFunctionObject("SET-SIGNATURE-STRATEGY", "(DEFUN SET-SIGNATURE-STRATEGY ((K KEYWORD)) :COMMAND? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setSignatureStrategy", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("SET-SIGNATURE-RULES", "(DEFUN SET-SIGNATURE-RULES ((B BOOLEAN)) :COMMAND? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setSignatureRules", new java.lang.Class [] {java.lang.Boolean.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "setSignatureRulesEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("SET-RULE-INDUCTION-STRATEGY", "(DEFUN SET-RULE-INDUCTION-STRATEGY ((K KEYWORD)) :COMMAND? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setRuleInductionStrategy", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("SET-RECURSIVE-DECISION-NODES", "(DEFUN SET-RECURSIVE-DECISION-NODES ((B BOOLEAN)) :COMMAND? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setRecursiveDecisionNodes", new java.lang.Class [] {java.lang.Boolean.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "setRecursiveDecisionNodesEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("INDUCE-INFERENCE-RULES", "(DEFUN INDUCE-INFERENCE-RULES ((RELATION-NAME SYMBOL) (CLASS-NAME SYMBOL)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "induceInferenceRules", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("MODULAR-INDUCE-INFERENCE-RULES", "(DEFUN MODULAR-INDUCE-INFERENCE-RULES ((RELATION-NAME SYMBOL) (CLASS-NAME SYMBOL) (MODULES (LIST OF MODULE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "modularInduceInferenceRules", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("BOTTOM-UP-RULE-INDUCTION", "(DEFUN BOTTOM-UP-RULE-INDUCTION ((EXAMPLES (LIST OF TRAINING-EXAMPLE)) (SIMPLIFY-RULE? BOOLEAN)) :COMMAND? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "bottomUpRuleInduction", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), java.lang.Boolean.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "bottomUpRuleInductionEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("LEARN-ONE-RULE-BOTTOM-UP", "(DEFUN (LEARN-ONE-RULE-BOTTOM-UP (CONS OF CONS)) ((POSITIVE (LIST OF TRAINING-EXAMPLE)) (NEGATIVE (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "learnOneRuleBottomUp", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("CONTAINS-OUTPUT-VARIABLE?", "(DEFUN (CONTAINS-OUTPUT-VARIABLE? BOOLEAN) ((CLAUSE CONS) (OUTPUT-VARIABLES (CONS OF SYMBOL))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "containsOutputVariableP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("SIMPLIFY-ANTECEDENT", "(DEFUN (SIMPLIFY-ANTECEDENT (CONS OF CONS)) ((ANTECEDENT (CONS OF CONS)) (OUTPUT-VARIABLES (CONS OF SYMBOL)) (POSITIVE (LIST OF TRAINING-EXAMPLE)) (NEGATIVE (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "simplifyAntecedent", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("LEAST-GENERAL-GENERALIZATION", "(DEFUN (LEAST-GENERAL-GENERALIZATION CONS) ((CLAUSE1 (CONS OF CONS)) (CLAUSE2 (CONS OF CONS))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "leastGeneralGeneralization", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("GENERALIZE-INEQUALITY", "(DEFUN (GENERALIZE-INEQUALITY CONS) ((PROBE CONS) (MATCH CONS) (BINDINGS (LIST OF CONS))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "generalizeInequality", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("BOTH-NUMBERS?", "(DEFUN (BOTH-NUMBERS? BOOLEAN) ((T1 OBJECT) (T2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "bothNumbersP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("EITHER-NUMBERS?", "(DEFUN (EITHER-NUMBERS? BOOLEAN) ((T1 OBJECT) (T2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "eitherNumbersP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("REMOVE-REDUNDANT-CLAUSES", "(DEFUN (REMOVE-REDUNDANT-CLAUSES (CONS OF CONS)) ((CLAUSES (CONS OF CONS))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "removeRedundantClauses", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("LOOKUP-VARIABLE-IN-BINDINGS", "(DEFUN (LOOKUP-VARIABLE-IN-BINDINGS OBJECT) ((OBJ1 OBJECT) (OBJ2 OBJECT) (BINDINGS (LIST OF CONS))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "lookupVariableInBindings", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("LEARN-ONE-RULE-BOTTOM-UP-FROM-SIGNATURES", "(DEFUN (LEARN-ONE-RULE-BOTTOM-UP-FROM-SIGNATURES (CONS OF CONS)) ((POSITIVE (LIST OF TRAINING-EXAMPLE)) (NEGATIVE (LIST OF TRAINING-EXAMPLE)) (COVERED (LIST OF TRAINING-EXAMPLE)) (CONS-PROPS (VECTOR OF CONS))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "learnOneRuleBottomUpFromSignatures", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("INTERSECT-SIGNATURES", "(DEFUN (INTERSECT-SIGNATURES (LIST OF INTEGER-WRAPPER)) ((SIG1 VECTOR) (SIG2 VECTOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "intersectSignatures", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("REMOVE-SIGNATURE-COVERED-EXAMPLES", "(DEFUN (REMOVE-SIGNATURE-COVERED-EXAMPLES (LIST OF TRAINING-EXAMPLE)) ((INDICES (LIST OF INTEGER-WRAPPER)) (EXAMPLES (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "removeSignatureCoveredExamples", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("NUM-SIGNATURE-INDICES-COVERED", "(DEFUN (NUM-SIGNATURE-INDICES-COVERED INTEGER) ((INDICES (LIST OF INTEGER-WRAPPER)) (EXAMPLES (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "numSignatureIndicesCovered", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("SIGNATURE-INDICES-COVER-ANY-EXAMPLE?", "(DEFUN (SIGNATURE-INDICES-COVER-ANY-EXAMPLE? BOOLEAN) ((INDICES (LIST OF INTEGER-WRAPPER)) (EXAMPLES (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "signatureIndicesCoverAnyExampleP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("SIGNATURE-INDICES-COVER-EXAMPLE?", "(DEFUN (SIGNATURE-INDICES-COVER-EXAMPLE? BOOLEAN) ((INDICES (LIST OF INTEGER-WRAPPER)) (EXAMPLE TRAINING-EXAMPLE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "signatureIndicesCoverExampleP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.powerloom.logic.TrainingExample")}), null);
      Stella.defineFunctionObject("TOP-DOWN-RULE-INDUCTION", "(DEFUN TOP-DOWN-RULE-INDUCTION ((EXAMPLES (LIST OF TRAINING-EXAMPLE))) :COMMAND? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "topDownRuleInduction", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("BUILD-ANTECEDENT-FROM-RULE-INDEX", "(DEFUN (BUILD-ANTECEDENT-FROM-RULE-INDEX (CONS OF CONS)) ((PROPS (VECTOR OF CONS)) (RULE-INDEX (LIST OF INTEGER-WRAPPER))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildAntecedentFromRuleIndex", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("LEARN-ONE-RULE-TOP-DOWN-FROM-SIGNATURES", "(DEFUN (LEARN-ONE-RULE-TOP-DOWN-FROM-SIGNATURES (CONS OF CONS)) ((POSITIVE (LIST OF TRAINING-EXAMPLE)) (NEGATIVE (LIST OF TRAINING-EXAMPLE)) (COVERED_POS (LIST OF TRAINING-EXAMPLE)) (CONS-PROPS (VECTOR OF CONS))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "learnOneRuleTopDownFromSignatures", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("UPDATE-EXAMPLE-MATCHES", "(DEFUN UPDATE-EXAMPLE-MATCHES ((EXAMPLES (LIST OF TRAINING-EXAMPLE)) (INDEX INTEGER) (MATCH-VALUE INTEGER-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "updateExampleMatches", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.IntegerWrapper")}), null);
      Stella.defineFunctionObject("UPDATE-COVERED-EXAMPLES", "(DEFUN UPDATE-COVERED-EXAMPLES ((FEATURE_INDEX INTEGER) (COVERED_POS (LIST OF TRAINING-EXAMPLE)) (COVERED_NEG (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "updateCoveredExamples", new java.lang.Class [] {java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("COUNT-EXAMPLE-MATCHES", "(DEFUN (COUNT-EXAMPLE-MATCHES INTEGER) ((EXAMPLES (LIST OF TRAINING-EXAMPLE)) (INDEX INTEGER) (MATCH-VALUE INTEGER-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "countExampleMatches", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.IntegerWrapper")}), null);
      Stella.defineFunctionObject("FOIL-GAIN", "(DEFUN (FOIL-GAIN FLOAT) ((FEATURE-INDEX INTEGER) (UTILITY FLOAT) (COVERED-POS (LIST OF TRAINING-EXAMPLE)) (COVERED-NEG (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "foilGain", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Double.TYPE, Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("FOIL-UTILITY", "(DEFUN (FOIL-UTILITY FLOAT) ((P INTEGER) (N INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "foilUtility", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("LEARN-ONE-RULE-TOP-DOWN", "(DEFUN (LEARN-ONE-RULE-TOP-DOWN (CONS OF CONS)) ((PROPOSITIONS (VECTOR OF CONS)) (POSITIVE (LIST OF TRAINING-EXAMPLE)) (NEGATIVE (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "learnOneRuleTopDown", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("SPECIALIZE-RULE", "(DEFUN (SPECIALIZE-RULE (CONS OF CONS)) ((RULE (CONS OF CONS)) (PROPOSITIONS (VECTOR OF CONS)) (POSITIVE (LIST OF TRAINING-EXAMPLE)) (NEGATIVE (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "specializeRule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("REMOVE-EXCLUDED-EXAMPLES", "(DEFUN REMOVE-EXCLUDED-EXAMPLES ((RULE (CONS OF CONS)) (COVERED-POS (LIST OF TRAINING-EXAMPLE)) (COVERED-NEG (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "removeExcludedExamples", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("QUERY-FOIL-GAIN", "(DEFUN (QUERY-FOIL-GAIN FLOAT) ((RULE (CONS OF CONS)) (UTILITY FLOAT) (COVERED-POS (LIST OF TRAINING-EXAMPLE)) (COVERED-NEG (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "queryFoilGain", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Double.TYPE, Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("QUERY-AND-UPDATE-COVERED-EXAMPLES", "(DEFUN QUERY-AND-UPDATE-COVERED-EXAMPLES ((RULE (CONS OF CONS)) (UNCOVERED (LIST OF TRAINING-EXAMPLE)) (COVERED (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "queryAndUpdateCoveredExamples", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("REMOVE-COVERED-EXAMPLES", "(DEFUN REMOVE-COVERED-EXAMPLES ((RULE (CONS OF CONS)) (UNCOVERED (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "removeCoveredExamples", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("NUM-EXAMPLES-COVERED", "(DEFUN (NUM-EXAMPLES-COVERED INTEGER) ((RULE (CONS OF CONS)) (EXAMPLES (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "numExamplesCovered", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("GET-COVERED-EXAMPLES", "(DEFUN (GET-COVERED-EXAMPLES (LIST OF TRAINING-EXAMPLE)) ((RULE (CONS OF CONS)) (UNCOVERED (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getCoveredExamples", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("RULE-COVERS-ANY-EXAMPLE?", "(DEFUN (RULE-COVERS-ANY-EXAMPLE? BOOLEAN) ((RULE (CONS OF CONS)) (EXAMPLES (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "ruleCoversAnyExampleP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("RULE-COVERS-EXAMPLE?", "(DEFUN (RULE-COVERS-EXAMPLE? BOOLEAN) ((REVERSE-RULE (CONS OF CONS)) (EXAMPLE TRAINING-EXAMPLE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "ruleCoversExampleP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.powerloom.logic.TrainingExample")}), null);
      Stella.defineFunctionObject("LINK-VARIABLES-IN-INDUCED-RULE", "(DEFUN (LINK-VARIABLES-IN-INDUCED-RULE (LIST OF (CONS OF CONS))) ((RULE (CONS OF CONS)) (EXAMPLES (LIST OF TRAINING-EXAMPLE)) (CONS-PROPS (VECTOR OF CONS))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "linkVariablesInInducedRule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("EVALUATE-RULE-INDUCTION", "(DEFUN (EVALUATE-RULE-INDUCTION (VECTOR OF FLOAT-WRAPPER)) ((RELATION-NAME SYMBOL) (CLASS-NAME SYMBOL) (NUM-TRIALS INTEGER) (CURVE-SPLITS INTEGER)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "evaluateRuleInduction", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol"), java.lang.Integer.TYPE, java.lang.Integer.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "evaluateRuleInductionEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("TRAIN-AND-TEST-RULE-INDUCTION", "(DEFUN (TRAIN-AND-TEST-RULE-INDUCTION FLOAT) ((TRAIN-SET (LIST OF TRAINING-EXAMPLE)) (TEST-SET (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "trainAndTestRuleInduction", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("INDUCE-DECISION-RULES", "(DEFUN INDUCE-DECISION-RULES ((RELATION-NAME SYMBOL) (CLASS-NAME SYMBOL)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "induceDecisionRules", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("MODULAR-INDUCE-DECISION-RULES", "(DEFUN MODULAR-INDUCE-DECISION-RULES ((RELATION-NAME SYMBOL) (CLASS-NAME SYMBOL) (MODULES (LIST OF MODULE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "modularInduceDecisionRules", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("ASK-DECISION-TREE", "(DEFUN (ASK-DECISION-TREE BOOLEAN) ((TREE DECISION-TREE) (QUERY CONS)))", Native.find_java_method("edu.isi.powerloom.logic.DecisionTree", "askDecisionTree", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.DecisionTree"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("TRAVERSE-DECISION-TREE", "(DEFUN (TRAVERSE-DECISION-TREE BOOLEAN) ((TREE DECISION-TREE) (FEATURES (VECTOR OF INTEGER-WRAPPER))))", Native.find_java_method("edu.isi.powerloom.logic.DecisionTree", "traverseDecisionTree", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.DecisionTree"), Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("INDUCE-DECISION-TREE", "(DEFUN (INDUCE-DECISION-TREE DECISION-TREE) ((EXAMPLES (LIST OF TRAINING-EXAMPLE))) :COMMAND? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "induceDecisionTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("ADD-PROPOSITIONS-TO-DECISION-TREE", "(DEFUN ADD-PROPOSITIONS-TO-DECISION-TREE ((TREE DECISION-TREE) (TABLE (HASH-TABLE OF SYMBOL PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.DecisionTree", "addPropositionsToDecisionTree", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.DecisionTree"), Native.find_java_class("edu.isi.stella.HashTable")}), null);
      Stella.defineFunctionObject("BUILD-DECISION-TREE", "(DEFUN (BUILD-DECISION-TREE OBJECT) ((EXAMPLES (LIST OF TRAINING-EXAMPLE)) (FEATURES (LIST OF SYMBOL)) (FEATURE-STACK (CONS OF SYMBOL))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildDecisionTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("EXPECTED-ENTROPY", "(DEFUN (EXPECTED-ENTROPY FLOAT) ((FEATURE-INDEX INTEGER) (EXAMPLES (LIST OF TRAINING-EXAMPLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "expectedEntropy", new java.lang.Class [] {java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("ENTROPY", "(DEFUN (ENTROPY FLOAT) ((P INTEGER) (N INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "entropy", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("PRINT-DECISION-TREE", "(DEFUN PRINT-DECISION-TREE ((TREE DECISION-TREE) (STREAM NATIVE-OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.DecisionTree", "printDecisionTree", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.DecisionTree"), Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), null);
      Stella.defineFunctionObject("HELP-PRINT-DECISION-TREE", "(DEFUN HELP-PRINT-DECISION-TREE ((TREE DECISION-TREE) (LEVEL INTEGER) (STREAM NATIVE-OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.DecisionTree", "helpPrintDecisionTree", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.DecisionTree"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), null);
      Stella.defineFunctionObject("GET-RULES-FROM-TREE", "(DEFUN (GET-RULES-FROM-TREE (LIST OF CONS)) ((QUERY CONS) (TREE DECISION-TREE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getRulesFromTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.powerloom.logic.DecisionTree")}), null);
      Stella.defineFunctionObject("BUILD-RULES-FROM-TREE", "(DEFUN (BUILD-RULES-FROM-TREE (LIST OF CONS)) ((TREE DECISION-TREE) (PROPS (LIST OF PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.DecisionTree", "buildRulesFromTree", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.DecisionTree"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("EXTRACT-PATHS-FROM-TREE", "(DEFUN EXTRACT-PATHS-FROM-TREE ((TREE DECISION-TREE) (ANTECEDENT-STACK (CONS OF CONS)) (ANTECEDENT (LIST OF CONS))))", Native.find_java_method("edu.isi.powerloom.logic.DecisionTree", "extractPathsFromTree", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.DecisionTree"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("SORT-EXAMPLES-BY-TREE", "(DEFUN SORT-EXAMPLES-BY-TREE ((TREE DECISION-TREE) (EXAMPLES (LIST OF TRAINING-EXAMPLE)) (SORTED-EXAMPLES (LIST OF (LIST OF TRAINING-EXAMPLE)))))", Native.find_java_method("edu.isi.powerloom.logic.DecisionTree", "sortExamplesByTree", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.DecisionTree"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("ASSERT-INDUCED-RULES", "(DEFUN ASSERT-INDUCED-RULES () :COMMAND? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "assertInducedRules", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("SET-CANDIDATE-CLAUSES", "(DEFUN SET-CANDIDATE-CLAUSES ((CLASS-NAME SYMBOL)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setCandidateClauses", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
    }
  }

  public static void startupRuleInduction() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupRuleInduction.helpStartupRuleInduction1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Logic.$RULE_INDUCTION_STRATEGY$ = Logic.KWD_TOP_DOWN;
          Logic.$SIGNATURE_STRATEGY$ = Logic.KWD_TOP_DOWN;
          Logic.$BOTTOM_UP_VARIABLE_COUNTER$.setDefaultValue(new Integer(-1));
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("DECISION-TREE", "(DEFCLASS DECISION-TREE (STANDARD-OBJECT) :SLOTS ((FEATURE :TYPE SYMBOL) (FEATURE-INDEX :TYPE INTEGER) (PROPOSITION :TYPE PROPOSITION) (TRUTH-VALUE :TYPE BOOLEAN) (CONCEPT :TYPE SYMBOL) (TRUE-BRANCH :TYPE DECISION-TREE) (FALSE-BRANCH :TYPE DECISION-TREE)) :PRINT-FORM (PRINT-DECISION-TREE SELF STREAM))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.DecisionTree", "newDecisionTree", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.DecisionTree", "accessDecisionTreeSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.DecisionTree"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupRuleInduction.helpStartupRuleInduction2();
          Stella.defineFunctionObject("GET-VARIABLES-FROM-PROPOSITION-LIST", "(DEFUN (GET-VARIABLES-FROM-PROPOSITION-LIST (LIST OF SYMBOL)) ((PROPS (LIST OF PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getVariablesFromPropositionList", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("GET-VARIABLES-FROM-CONS-PROPOSITIONS", "(DEFUN (GET-VARIABLES-FROM-CONS-PROPOSITIONS (LIST OF SYMBOL)) ((PROPS (CONS OF CONS))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getVariablesFromConsPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("HELP-GET-VARIABLES-FROM-CONS-PROPOSITIONS", "(DEFUN (HELP-GET-VARIABLES-FROM-CONS-PROPOSITIONS (LIST OF SYMBOL)) ((ELE PARSE-TREE) (THE-LIST (LIST OF SYMBOL))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "helpGetVariablesFromConsPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("GET-PROPOSITIONS-FROM-DECISION-TREE", "(DEFUN (GET-PROPOSITIONS-FROM-DECISION-TREE (LIST OF PROPOSITION)) ((TREE DECISION-TREE)))", Native.find_java_method("edu.isi.powerloom.logic.DecisionTree", "getPropositionsFromDecisionTree", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.DecisionTree")}), null);
          Stella.defineFunctionObject("STARTUP-RULE-INDUCTION", "(DEFUN STARTUP-RULE-INDUCTION () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupRuleInduction", "startupRuleInduction", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_RULE_INDUCTION);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupRuleInduction"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *RULE-INDUCTION-STRATEGY* KEYWORD :TOP-DOWN)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *SIGNATURE-STRATEGY* KEYWORD :TOP-DOWN)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *ENABLE-USER-THING* BOOLEAN TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *OPTIMIZE-INDUCED-QUERIES* BOOLEAN TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *SIMPLIFY-RULE-ANTECEDENT?* BOOLEAN FALSE :DOCUMENTATION \"Flag to control whether we try to simplify the rule antecedent.\nThis should be set to FALSE if we expect the user to edit the rule and\nTRUE if we want to have final rules as general as possible.\" :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *TRACE-ID3* BOOLEAN FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *TRACE-FOIL* BOOLEAN FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *INDUCE-RULES-FROM-SIGNATURES* BOOLEAN TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *NUM-LGGS* INTEGER 2000)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *ENFORCE-LINKED-VARIABLES* BOOLEAN FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *LOG-INDUCED-RULES* BOOLEAN FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *ALLOW-RECURSIVE-DECISION-NODES* BOOLEAN TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *LOG-DECISION-RULE-CONSTRUCTION* BOOLEAN FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL LOG_2 FLOAT 0.6931472)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *INDUCED-DECISION-RULES* (LIST OF CONS) NULL)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *INDUCED-RULE-COUNTER* INTEGER 0)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CANDIDATE-CLAUSES* (VECTOR OF CONS) NULL)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *BOTTOM-UP-VARIABLE-COUNTER* INTEGER -1)");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
