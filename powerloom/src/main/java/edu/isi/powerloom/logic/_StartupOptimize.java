//  -*- Mode: Java -*-
//
// _StartupOptimize.java

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

public class _StartupOptimize {
  static void helpStartupOptimize1() {
    {
      Logic.SGT_LOGIC_GOAL_RECORD = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("GOAL-RECORD", null, 1)));
      Logic.SYM_LOGIC_GENERATOR_GOALS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("GENERATOR-GOALS", null, 0)));
      Logic.SYM_LOGIC_OTHER_GOALS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OTHER-GOALS", null, 0)));
      Logic.SYM_LOGIC_PERMUTATION_TABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PERMUTATION-TABLE", null, 0)));
      Logic.SGT_PL_KERNEL_KB_COMPUTED = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("COMPUTED", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_ABSTRACT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("ABSTRACT", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SYM_LOGIC_OPTIMIZER_GOAL_RECORDS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OPTIMIZER-GOAL-RECORDS", null, 0)));
      Logic.SYM_LOGIC_UNIQUENESSVECTORS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UNIQUENESSVECTORS", null, 0)));
      Logic.SYM_LOGIC_INVERSE_DESCRIPTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INVERSE-DESCRIPTION", null, 0)));
      Logic.SYM_LOGIC_INDEXING_VECTOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INDEXING-VECTOR", null, 0)));
      Logic.SGT_PL_KERNEL_KB_OBSERVED_CARDINALITY_OF = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("OBSERVED-CARDINALITY-OF", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.KWD_OPTIMIZER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("OPTIMIZER", null, 2)));
      Logic.SYM_LOGIC_BEST_COST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BEST-COST", null, 0)));
      Logic.KWD_STATIC_WITH_CLUSTERING = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("STATIC-WITH-CLUSTERING", null, 2)));
      Logic.KWD_BOUND = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("BOUND", null, 2)));
      Logic.SGT_LOGIC_F_DYNAMICALLY_ESTIMATE_INFERENCE_COST_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-DYNAMICALLY-ESTIMATE-INFERENCE-COST-MEMO-TABLE-000", null, 1)));
      Logic.SGT_PL_KERNEL_KB_INSTANCE_OF = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INSTANCE-OF", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.KWD_CREATED_SKOLEMS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CREATED-SKOLEMS", null, 2)));
      Logic.SGT_LOGIC_F_FILTER_IMPLIED_SKOLEM_PROPOSITIONS_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-FILTER-IMPLIED-SKOLEM-PROPOSITIONS-MEMO-TABLE-000", null, 1)));
      Logic.SYM_LOGIC_STRUCTURAL_FUNCTION_EVALUATION_ORDER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STRUCTURAL-FUNCTION-EVALUATION-ORDER", null, 0)));
      Logic.SYM_LOGIC_STARTUP_OPTIMIZE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-OPTIMIZE", null, 0)));
    }
  }

  static void helpStartupOptimize2() {
    {
      Logic.$DISTRIBUTEDOPENGOALp$.setDefaultValue(new Boolean(false));
      Logic.V_0_0 = Logic.zeroOneListToBooleanVector(List.list(Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(IntegerWrapper.wrapInteger(0), Stella.NIL))));
      Logic.V_1_0 = Logic.zeroOneListToBooleanVector(List.list(Cons.cons(IntegerWrapper.wrapInteger(1), Cons.cons(IntegerWrapper.wrapInteger(0), Stella.NIL))));
      Logic.V_0_1 = Logic.zeroOneListToBooleanVector(List.list(Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(IntegerWrapper.wrapInteger(1), Stella.NIL))));
      Logic.V_1_1 = Logic.zeroOneListToBooleanVector(List.list(Cons.cons(IntegerWrapper.wrapInteger(1), Cons.cons(IntegerWrapper.wrapInteger(1), Stella.NIL))));
      Logic.V_1_0_AND_V_0_1 = List.list(Cons.cons(Logic.V_1_0, Cons.cons(Logic.V_0_1, Stella.NIL)));
      Logic.V_1_0_SINGLETON = List.list(Cons.cons(Logic.V_1_0, Stella.NIL));
      Logic.V_0_1_SINGLETON = List.list(Cons.cons(Logic.V_0_1, Stella.NIL));
      Logic.$OPTIMALGOALORDERINGRECURSIONS$.setDefaultValue(new Integer(Stella.NULL_INTEGER));
      Logic.$BOUNDTOOFFSETCOUNTER$.setDefaultValue(new Integer(Stella.NULL_INTEGER));
      Logic.$QUERY_OPTIMIZATION_STRATEGY$ = Logic.KWD_DYNAMIC;
      Logic.$POSTOPTIMIZATIONp$.setDefaultValue(new Boolean(false));
    }
  }

  static void helpStartupOptimize3() {
    {
      Stella.defineFunctionObject("VARIABLE-BOUND?", "(DEFUN (VARIABLE-BOUND? BOOLEAN) ((VARIABLE PATTERN-VARIABLE)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "variableBoundP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable")}), null);
      Stella.defineFunctionObject("ARGUMENT-BOUND?", "(DEFUN (ARGUMENT-BOUND? BOOLEAN) ((ARGUMENT OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "argumentBoundP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("QUANTIFIED-ARGUMENT-BOUND?", "(DEFUN (QUANTIFIED-ARGUMENT-BOUND? BOOLEAN) ((ARGUMENT OBJECT) (QUANTIFIEDVARS LIST)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "quantifiedArgumentBoundP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("UNBOUND-VARIABLE?", "(DEFUN (UNBOUND-VARIABLE? BOOLEAN) ((ARGUMENT OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "unboundVariableP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("HAS-DISJUNCTION?", "(DEFUN (HAS-DISJUNCTION? BOOLEAN) ((GOAL PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "hasDisjunctionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("MODAL-GOAL?", "(DEFUN (MODAL-GOAL? BOOLEAN) ((GOAL PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "modalGoalP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("HAS-INVERSIONS?", "(DEFUN (HAS-INVERSIONS? BOOLEAN) ((GOAL PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "hasInversionsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("COMPUTED-TERM?", "(DEFUN (COMPUTED-TERM? BOOLEAN) ((SELF DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "computedTermP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("COMPUTED-CONSTRAINT?", "(DEFUN (COMPUTED-CONSTRAINT? BOOLEAN) ((SELF DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "computedConstraintP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("COMPUTED-PREDICATE?", "(DEFUN (COMPUTED-PREDICATE? BOOLEAN) ((GOAL PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "computedPredicateP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("SIMULATE-CREATE-CHOICE-POINT", "(DEFUN (SIMULATE-CREATE-CHOICE-POINT INTEGER) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "simulateCreateChoicePoint", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("RELATION-SUPPORTS-EXTENSION?", "(DEFUN (RELATION-SUPPORTS-EXTENSION? BOOLEAN) ((SELF NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "relationSupportsExtensionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("GENERATOR-COLLECTION?", "(DEFUN (GENERATOR-COLLECTION? BOOLEAN) ((COLLECTION OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "generatorCollectionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("INITIALIZE-OPTIMIZER-GOAL-RECORDS", "(DEFUN INITIALIZE-OPTIMIZER-GOAL-RECORDS ((SIZE INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "initializeOptimizerGoalRecords", new java.lang.Class [] {java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("GOAL-RECORD", "(DEFUN (GOAL-RECORD GOAL-RECORD) ((VARIABLE PATTERN-VARIABLE)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "goalRecord", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable")}), null);
      Stella.defineFunctionObject("HELP-DISTRIBUTE-GOAL", "(DEFUN HELP-DISTRIBUTE-GOAL ((ARGUMENT OBJECT) (PARENTGOAL PROPOSITION) (GENERATOR? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "helpDistributeGoal", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("DISTRIBUTE-OPEN-GOAL", "(DEFUN DISTRIBUTE-OPEN-GOAL ((GOAL PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "distributeOpenGoal", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT NAMED-DESCRIPTION UNIQUENESSVECTORS :TYPE (LIST OF BOOLEAN-VECTOR) :DOCUMENTATION \"Caches a list of vectors representing keys\nfor the slot/relation.\" :ALLOCATION :DYNAMIC)");
      Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT NAMED-DESCRIPTION INDEXING-VECTOR :TYPE BOOLEAN-VECTOR :DOCUMENTATION \"Caches a vector indicating which arguments\nof a slot/relation have backlinks to referencing propositions.\" :ALLOCATION :DYNAMIC)");
      Stella.defineFunctionObject("GET-BINARY-UNIQUENESS-VECTORS", "(DEFUN (GET-BINARY-UNIQUENESS-VECTORS (LIST OF BOOLEAN-VECTOR)) ((SELF NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "getBinaryUniquenessVectors", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("GET-UNIQUENESS-VECTORS", "(DEFUN (GET-UNIQUENESS-VECTORS (LIST OF BOOLEAN-VECTOR)) ((SELF NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "getUniquenessVectors", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("GET-BINARY-INDEXING-VECTOR", "(DEFUN (GET-BINARY-INDEXING-VECTOR BOOLEAN-VECTOR) ((SELF NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "getBinaryIndexingVector", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("GET-INDEXING-VECTOR", "(DEFUN (GET-INDEXING-VECTOR BOOLEAN-VECTOR) ((SELF NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "getIndexingVector", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("UPDATE-OBSERVED-CARDINALITY", "(DEFUN UPDATE-OBSERVED-CARDINALITY ((SELF NAMED-DESCRIPTION) (CARDINALITY INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "updateObservedCardinality", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("ACCESS-OBSERVED-CARDINALITY", "(DEFUN (ACCESS-OBSERVED-CARDINALITY INTEGER) ((SELF DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "accessObservedCardinality", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("ESTIMATE-CARDINALITY-OF-EXTENSION", "(DEFUN (ESTIMATE-CARDINALITY-OF-EXTENSION COST-ESTIMATE) ((DESCRIPTION NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "estimateCardinalityOfExtension", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("ESTIMATE-MEMBER-OF-GOAL-FANOUT", "(DEFUN (ESTIMATE-MEMBER-OF-GOAL-FANOUT COST-ESTIMATE) ((GOAL PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "estimateMemberOfGoalFanout", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("ESTIMATE-PREDICATE-GOAL-FANOUT", "(DEFUN (ESTIMATE-PREDICATE-GOAL-FANOUT COST-ESTIMATE) ((GOAL PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "estimatePredicateGoalFanout", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("ESTIMATE-GOAL-COST", "(DEFUN (ESTIMATE-GOAL-COST COST-ESTIMATE) ((GOAL PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "estimateGoalCost", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("ESTIMATE-GOAL-FANOUT", "(DEFUN (ESTIMATE-GOAL-FANOUT COST-ESTIMATE) ((GOAL PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "estimateGoalFanout", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("CHEAPEST-GENERATOR-GOAL", "(DEFUN (CHEAPEST-GENERATOR-GOAL PROPOSITION COST-ESTIMATE COST-ESTIMATE) ((VARIABLE PATTERN-VARIABLE)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "cheapestGeneratorGoal", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("PROPAGATE-SINGLE-VALUED-CONSTRAINTS", "(DEFUN PROPAGATE-SINGLE-VALUED-CONSTRAINTS ((GOAL PROPOSITION) (GOALSEQUENCE (LIST OF PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "propagateSingleValuedConstraints", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("COLLECT-CLOSED-GOALS", "(DEFUN COLLECT-CLOSED-GOALS ((GOALS (LIST OF PROPOSITION)) (GOALSEQUENCE (LIST OF PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "collectClosedGoals", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("SIMULATE-BIND-VARIABLE-AND-PROPAGATE-CONSTRAINTS", "(DEFUN SIMULATE-BIND-VARIABLE-AND-PROPAGATE-CONSTRAINTS ((VARIABLE PATTERN-VARIABLE) (GOALSEQUENCE (LIST OF PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "simulateBindVariableAndPropagateConstraints", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("BIND-ALL-VARIABLES-IN-GENERATOR-GOAL", "(DEFUN BIND-ALL-VARIABLES-IN-GENERATOR-GOAL ((GOAL PROPOSITION) (GOALSEQUENCE (LIST OF PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "bindAllVariablesInGeneratorGoal", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("COMPUTE-OPTIMAL-OPEN-GOAL-ORDERING", "(DEFUN COMPUTE-OPTIMAL-OPEN-GOAL-ORDERING ((OPTIMIZERVARIABLES (LIST OF PATTERN-VARIABLE)) (NUMBEROFOPENGOALS INTEGER) (GOALSEQUENCE (LIST OF PROPOSITION)) (PRIORCOST COST-ESTIMATE) (PRIORFANOUT COST-ESTIMATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "computeOptimalOpenGoalOrdering", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.List"), java.lang.Double.TYPE, java.lang.Double.TYPE}), null);
      Stella.defineFunctionObject("COMPUTE-GREEDY-OPEN-GOAL-ORDERING", "(DEFUN COMPUTE-GREEDY-OPEN-GOAL-ORDERING ((OPTIMIZERVARIABLES (LIST OF PATTERN-VARIABLE)) (NUMBEROFOPENGOALS INTEGER) (GOALSEQUENCE (LIST OF PROPOSITION)) (PRIORCOST COST-ESTIMATE) (PRIORFANOUT COST-ESTIMATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "computeGreedyOpenGoalOrdering", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.List"), java.lang.Double.TYPE, java.lang.Double.TYPE}), null);
      Stella.defineFunctionObject("COMPUTE-BACKUP-OPEN-GOAL-ORDERING", "(DEFUN COMPUTE-BACKUP-OPEN-GOAL-ORDERING ((GOALSEQUENCE (LIST OF PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "computeBackupOpenGoalOrdering", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("COLLECT-UNBOUND-GOAL-VARIABLES", "(DEFUN COLLECT-UNBOUND-GOAL-VARIABLES ((GOAL PROPOSITION) (UNBOUNDVARIABLES (LIST OF PATTERN-VARIABLE))))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "collectUnboundGoalVariables", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("EXTRACT-OPEN-GOAL-CLUSTERS", "(DEFUN EXTRACT-OPEN-GOAL-CLUSTERS ((OPENGOALS (LIST OF PROPOSITION)) (OPENGOALCLUSTERS (LIST OF (LIST OF PROPOSITION)))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "extractOpenGoalClusters", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("COLLECT-OPTIMIZER-VARIABLES", "(DEFUN COLLECT-OPTIMIZER-VARIABLES ((PROPOSITION PROPOSITION) (COLLECTION LIST)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "collectOptimizerVariables", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("BIGGER-CONJUNCTION?", "(DEFUN (BIGGER-CONJUNCTION? BOOLEAN) ((PROP1 PROPOSITION) (PROP2 PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "biggerConjunctionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("COMPUTE-OPEN-GOAL-ORDERING", "(DEFUN COMPUTE-OPEN-GOAL-ORDERING ((ANDPROPOSITION PROPOSITION) (OPENGOALS (LIST OF PROPOSITION)) (GOALSEQUENCE (LIST OF PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "computeOpenGoalOrdering", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("OPTIMIZE-ORDERING-OF-CONJUNCTS", "(DEFUN OPTIMIZE-ORDERING-OF-CONJUNCTS ((ANDPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "optimizeOrderingOfConjuncts", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("REORDER-GOALS", "(DEFUN REORDER-GOALS ((ANDPROPOSITION PROPOSITION) (INITIALLYCLOSEDGOALS (LIST OF PROPOSITION)) (GOALSEQUENCE (LIST OF PROPOSITION)) (RESIDUEGOALS (LIST OF PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "reorderGoals", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("SIMULATE-BIND-VARIABLE-TO-VALUE", "(DEFUN SIMULATE-BIND-VARIABLE-TO-VALUE ((FORMULA OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "simulateBindVariableToValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("WARN-OF-UNBOUND-VARIABLE-ARGUMENT", "(DEFUN WARN-OF-UNBOUND-VARIABLE-ARGUMENT ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "warnOfUnboundVariableArgument", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("SIMULATE-GOAL-EVALUATION", "(DEFUN SIMULATE-GOAL-EVALUATION ((GOAL PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "simulateGoalEvaluation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("SIMULATE-AND-OPTIMIZE-ARGUMENT", "(DEFUN SIMULATE-AND-OPTIMIZE-ARGUMENT ((FORMULA OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "simulateAndOptimizeArgument", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SIMULATE-AND-OPTIMIZE-QUERY", "(DEFUN SIMULATE-AND-OPTIMIZE-QUERY ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "simulateAndOptimizeQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("INITIALIZE-OPTIMIZER-MEMORY", "(DEFUN INITIALIZE-OPTIMIZER-MEMORY ((STACKSIZE INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "initializeOptimizerMemory", new java.lang.Class [] {java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("OPTIMIZE-QUERY", "(DEFUN OPTIMIZE-QUERY ((DESCRIPTION DESCRIPTION) (BOOLEANVECTOR BOOLEAN-VECTOR) (PARENTFRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "optimizeQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.BooleanVector"), Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("USE-DYNAMIC-QUERY-OPTIMIZATION?", "(DEFUN (USE-DYNAMIC-QUERY-OPTIMIZATION? BOOLEAN) () :GLOBALLY-INLINE? TRUE (RETURN (AND (OR (EQL? *QUERY-OPTIMIZATION-STRATEGY* :DYNAMIC) (EQL? *QUERY-OPTIMIZATION-STRATEGY* :DYNAMIC-WITH-CLUSTERING)))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "useDynamicQueryOptimizationP", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("DYNAMICALLY-OPTIMIZE-PROPOSITION?", "(DEFUN (DYNAMICALLY-OPTIMIZE-PROPOSITION? BOOLEAN) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "dynamicallyOptimizePropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("USE-STATIC-QUERY-OPTIMIZATION?", "(DEFUN (USE-STATIC-QUERY-OPTIMIZATION? BOOLEAN) () :GLOBALLY-INLINE? TRUE (RETURN (AND (NOT (EQL? *QUERY-OPTIMIZATION-STRATEGY* :NONE)) (NOT (USE-DYNAMIC-QUERY-OPTIMIZATION?)))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "useStaticQueryOptimizationP", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("STATICALLY-OPTIMIZE-PROPOSITION?", "(DEFUN (STATICALLY-OPTIMIZE-PROPOSITION? BOOLEAN) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "staticallyOptimizePropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("TRY-TO-CLUSTER-CONJUNCTIONS?", "(DEFUN (TRY-TO-CLUSTER-CONJUNCTIONS? BOOLEAN) () :GLOBALLY-INLINE? TRUE (RETURN (OR (EQL? *QUERY-OPTIMIZATION-STRATEGY* :STATIC-WITH-CLUSTERING))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "tryToClusterConjunctionsP", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("SELECT-OPTIMAL-QUERY-PATTERN", "(DEFUN (SELECT-OPTIMAL-QUERY-PATTERN DESCRIPTION) ((DESCRIPTION DESCRIPTION) (BOOLEANVECTOR BOOLEAN-VECTOR) (PARENTFRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "selectOptimalQueryPattern", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.BooleanVector"), Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("DYNAMICALLY-ESTIMATE-INFERENCE-COST", "(DEFUN (DYNAMICALLY-ESTIMATE-INFERENCE-COST COST-ESTIMATE) ((SELF NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "dynamicallyEstimateInferenceCost", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("DYNAMICALLY-ESTIMATE-GOAL-COST", "(DEFUN (DYNAMICALLY-ESTIMATE-GOAL-COST COST-ESTIMATE) ((GOAL PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "dynamicallyEstimateGoalCost", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
    }
  }

  static void helpStartupOptimize4() {
    {
      Stella.defineFunctionObject("DYNAMICALLY-ESTIMATE-GOAL-FANOUT", "(DEFUN (DYNAMICALLY-ESTIMATE-GOAL-FANOUT COST-ESTIMATE) ((GOAL PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "dynamicallyEstimateGoalFanout", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("DYNAMICALLY-ESTIMATE-PREDICATE-GOAL-FANOUT", "(DEFUN (DYNAMICALLY-ESTIMATE-PREDICATE-GOAL-FANOUT COST-ESTIMATE) ((GOAL PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "dynamicallyEstimatePredicateGoalFanout", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("DYNAMICALLY-ESTIMATE-INSTANCE-OF-GOAL-FANOUT", "(DEFUN (DYNAMICALLY-ESTIMATE-INSTANCE-OF-GOAL-FANOUT COST-ESTIMATE) ((GOAL PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "dynamicallyEstimateInstanceOfGoalFanout", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("DYNAMICALLY-ESTIMATE-EXTENSION-SIZE", "(DEFUN (DYNAMICALLY-ESTIMATE-EXTENSION-SIZE COST-ESTIMATE) ((DESCRIPTION NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "dynamicallyEstimateExtensionSize", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("COUNT-BOUND-ARGUMENTS", "(DEFUN (COUNT-BOUND-ARGUMENTS INTEGER) ((GOAL PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "countBoundArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("DYNAMICALLY-ESTIMATE-UNBOUND-VARIABLE-PENALTY", "(DEFUN (DYNAMICALLY-ESTIMATE-UNBOUND-VARIABLE-PENALTY COST-ESTIMATE) ((GOAL PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "dynamicallyEstimateUnboundVariablePenalty", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("DYNAMICALLY-REOPTIMIZE-ARGUMENTS", "(DEFUN DYNAMICALLY-REOPTIMIZE-ARGUMENTS ((ARGUMENTS (VECTOR OF PROPOSITION)) (CURSOR INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "dynamicallyReoptimizeArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("SIMPLIFY-DESCRIPTION", "(DEFUN SIMPLIFY-DESCRIPTION ((DESCRIPTION DESCRIPTION) (POSTOPTIMIZATION? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "simplifyDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("COPY-LIST-TO-ARGUMENTS-VECTOR", "(DEFUN (COPY-LIST-TO-ARGUMENTS-VECTOR ARGUMENTS-VECTOR) ((ARGUMENTS LIST)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "copyListToArgumentsVector", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("CONJUNCT-CANCELS-ISA-PROPOSITION?", "(DEFUN (CONJUNCT-CANCELS-ISA-PROPOSITION? BOOLEAN) ((ISACONJUNCT PROPOSITION) (OTHERCONJUNCT PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "conjunctCancelsIsaPropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("SIMPLIFY-CONJUNCTION", "(DEFUN SIMPLIFY-CONJUNCTION ((ANDPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "simplifyConjunction", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("SIMPLIFY-PROPOSITION", "(DEFUN SIMPLIFY-PROPOSITION ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "simplifyProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("COPY-DESCRIPTION", "(DEFUN (COPY-DESCRIPTION DESCRIPTION) ((SELF DESCRIPTION) (PARENTMAPPING ENTITY-MAPPING) (ADDBACKLINKS? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "copyDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.KeyValueMap"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("COPY-VARIABLE", "(DEFUN (COPY-VARIABLE PATTERN-VARIABLE) ((SELF PATTERN-VARIABLE) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "copyVariable", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("COPY-VARIABLES-VECTOR", "(DEFUN (COPY-VARIABLES-VECTOR VARIABLES-VECTOR) ((SELF VARIABLES-VECTOR) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "copyVariablesVector", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("COPY-PROPOSITION", "(DEFUN (COPY-PROPOSITION PROPOSITION) ((SELF PROPOSITION) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "copyProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("COPY-PROPOSITION-ARGUMENT", "(DEFUN (COPY-PROPOSITION-ARGUMENT OBJECT) ((SELF OBJECT) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "copyPropositionArgument", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("MAPPED-VALUE-OF", "(DEFUN (MAPPED-VALUE-OF OBJECT) ((SELF OBJECT) (MAPPING ENTITY-MAPPING) (CREATESKOLEM? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "mappedValueOf", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.KeyValueMap"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("SINGLE-VALUED-PREDICATE?", "(DEFUN (SINGLE-VALUED-PREDICATE? BOOLEAN) ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "singleValuedPredicateP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("BINARY-PROPOSITION?", "(DEFUN (BINARY-PROPOSITION? BOOLEAN) ((PROPOSITION PROPOSITION)) :GLOBALLY-INLINE? TRUE (RETURN (EQL? (LENGTH (ARGUMENTS PROPOSITION)) 2)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "binaryPropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("INHERIT-EQUIVALENT-PROPOSITION", "(DEFUN (INHERIT-EQUIVALENT-PROPOSITION PROPOSITION) ((SKOLEM SKOLEM) (VALUE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "inheritEquivalentProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("INHERIT-FUNCTION-PROPOSITION", "(DEFUN (INHERIT-FUNCTION-PROPOSITION PROPOSITION) ((SELF PROPOSITION) (MAPPING ENTITY-MAPPING) (CREATESKOLEM? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "inheritFunctionProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueMap"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("EQUAL-UP-TO-SKOLEM-IDENTITY?", "(DEFUN (EQUAL-UP-TO-SKOLEM-IDENTITY? BOOLEAN) ((INHERITEDARG OBJECT) (BASEARG OBJECT) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "equalUpToSkolemIdentityP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("OLD-FIND-SIMILAR-PROPOSITION", "(DEFUN (OLD-FIND-SIMILAR-PROPOSITION PROPOSITION) ((PROPOSITION PROPOSITION) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "oldFindSimilarProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("NEW-FIND-SIMILAR-PROPOSITION", "(DEFUN (NEW-FIND-SIMILAR-PROPOSITION PROPOSITION) ((PROPOSITION PROPOSITION) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "newFindSimilarProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("FIND-SIMILAR-PROPOSITION", "(DEFUN (FIND-SIMILAR-PROPOSITION PROPOSITION) ((PROPOSITION PROPOSITION) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "findSimilarProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("INHERIT-PROPOSITION-ARGUMENT", "(DEFUN (INHERIT-PROPOSITION-ARGUMENT OBJECT) ((ARGUMENT OBJECT) (PARENT PROPOSITION) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "inheritPropositionArgument", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("ERADICATE-HOLDS-PROPOSITION", "(DEFUN (ERADICATE-HOLDS-PROPOSITION PROPOSITION) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "eradicateHoldsProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("INHERIT-PROPOSITION", "(DEFUN (INHERIT-PROPOSITION PROPOSITION) ((SELF PROPOSITION) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "inheritProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("CREATE-SKOLEM-FOR-UNMAPPED-VARIABLE", "(DEFUN (CREATE-SKOLEM-FOR-UNMAPPED-VARIABLE SKOLEM) ((VARIABLE PATTERN-VARIABLE) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "createSkolemForUnmappedVariable", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("INHERIT-AS-TOP-LEVEL-PROPOSITION", "(DEFUN (INHERIT-AS-TOP-LEVEL-PROPOSITION (CONS OF PROPOSITION)) ((PROPOSITION PROPOSITION) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "inheritAsTopLevelProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("PROPOSITION-REFERENCES-TERMS?", "(DEFUN (PROPOSITION-REFERENCES-TERMS? BOOLEAN) ((SELF PROPOSITION) (TERMS HASH-SET)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "propositionReferencesTermsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.HashSet")}), null);
      Stella.defineFunctionObject("CREATE-SKOLEM-PROPOSITIONS-QUERY", "(DEFUN (CREATE-SKOLEM-PROPOSITIONS-QUERY CONS) ((INHERITEDPROPS (CONS OF PROPOSITION)) (DESCRIPTION DESCRIPTION) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createSkolemPropositionsQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("FILTER-IMPLIED-SKOLEM-PROPOSITIONS", "(DEFUN (FILTER-IMPLIED-SKOLEM-PROPOSITIONS (CONS OF PROPOSITION)) ((INHERITEDPROPS (CONS OF PROPOSITION)) (DESCRIPTION DESCRIPTION) (ARGUMENTS VECTOR) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "filterImpliedSkolemPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("MAP-AND-ENQUEUE-VARIABLE?", "(DEFUN (MAP-AND-ENQUEUE-VARIABLE? BOOLEAN) ((VARIABLE OBJECT) (LOCALVALUE OBJECT) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "mapAndEnqueueVariableP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("COLLECT-STRUCTURAL-FUNCTIONS", "(DEFUN COLLECT-STRUCTURAL-FUNCTIONS ((PROPOSITION PROPOSITION) (STRUCTURALFUNCTIONS (LIST OF PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "collectStructuralFunctions", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("COMPUTE-STRUCTURAL-FUNCTION-EVALUATION-ORDER", "(DEFUN (COMPUTE-STRUCTURAL-FUNCTION-EVALUATION-ORDER (LIST OF PROPOSITION)) ((SELF DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "computeStructuralFunctionEvaluationOrder", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT DESCRIPTION STRUCTURAL-FUNCTION-EVALUATION-ORDER :TYPE (LIST OF PROPOSITION) :ALLOCATION :DYNAMIC)");
      Stella.defineFunctionObject("GET-STRUCTURAL-FUNCTION-EVALUATION-ORDER", "(DEFUN (GET-STRUCTURAL-FUNCTION-EVALUATION-ORDER (LIST OF PROPOSITION)) ((SELF DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "getStructuralFunctionEvaluationOrder", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("MAP-FUNCTIONAL-VALUE?", "(DEFUN (MAP-FUNCTIONAL-VALUE? BOOLEAN) ((PROPOSITION PROPOSITION) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "mapFunctionalValueP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("INHERIT-DESCRIPTION-PROPOSITIONS", "(DEFUN (INHERIT-DESCRIPTION-PROPOSITIONS (CONS OF PROPOSITION) ENTITY-MAPPING) ((ARGUMENTS VECTOR) (DESCRIPTION DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "inheritDescriptionPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("INHERIT-UNNAMED-DESCRIPTION", "(DEFUN INHERIT-UNNAMED-DESCRIPTION ((SELF OBJECT) (DESCRIPTION DESCRIPTION) (DEFAULTTRUE? BOOLEAN)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "inheritUnnamedDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.powerloom.logic.Description"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("VECTOR.INHERIT-UNNAMED-DESCRIPTION", "(DEFUN VECTOR.INHERIT-UNNAMED-DESCRIPTION ((ARGUMENTS VECTOR) (DESCRIPTION DESCRIPTION) (DEFAULTTRUE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "vectorDinheritUnnamedDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.powerloom.logic.Description"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("LOGIC-OBJECT.INHERIT-UNNAMED-DESCRIPTION", "(DEFUN LOGIC-OBJECT.INHERIT-UNNAMED-DESCRIPTION ((INSTANCE LOGIC-OBJECT) (DESCRIPTION DESCRIPTION) (DEFAULTTRUE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "logicObjectDinheritUnnamedDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.powerloom.logic.Description"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("INHERIT-DESCRIPTION", "(DEFUN INHERIT-DESCRIPTION ((ARGUMENTS VECTOR) (DESCRIPTION DESCRIPTION) (DEFAULTTRUE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "inheritDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.powerloom.logic.Description"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("STARTUP-OPTIMIZE", "(DEFUN STARTUP-OPTIMIZE () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupOptimize", "startupOptimize", new java.lang.Class [] {}), null);
      { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_OPTIMIZE);

        KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupOptimize"), Stella.NULL_STRING_WRAPPER);
      }
    }
  }

  public static void startupOptimize() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupOptimize.helpStartupOptimize1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          _StartupOptimize.helpStartupOptimize2();
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("GOAL-RECORD", "(DEFCLASS GOAL-RECORD (STANDARD-OBJECT) :SLOTS ((GENERATOR-GOALS :TYPE (LIST OF PROPOSITION) :ALLOCATION :EMBEDDED) (OTHER-GOALS :TYPE (LIST OF PROPOSITION) :ALLOCATION :EMBEDDED)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.GoalRecord", "newGoalRecord", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.GoalRecord", "accessGoalRecordSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.GoalRecord"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupOptimize.helpStartupOptimize3();
          _StartupOptimize.helpStartupOptimize4();
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *DISTRIBUTEDOPENGOAL?* BOOLEAN FALSE :DOCUMENTATION \"Used by 'distribute-open-goal' to signal that\na goal was distributed by 'help-distribute-goal'.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT V-0-0 BOOLEAN-VECTOR (ZERO-ONE-LIST-TO-BOOLEAN-VECTOR (LIST 0 0)))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT V-1-0 BOOLEAN-VECTOR (ZERO-ONE-LIST-TO-BOOLEAN-VECTOR (LIST 1 0)))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT V-0-1 BOOLEAN-VECTOR (ZERO-ONE-LIST-TO-BOOLEAN-VECTOR (LIST 0 1)))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT V-1-1 BOOLEAN-VECTOR (ZERO-ONE-LIST-TO-BOOLEAN-VECTOR (LIST 1 1)))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT V-1-0-AND-V-0-1 (LIST OF BOOLEAN-VECTOR) (LIST V-1-0 V-0-1))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT V-1-0-SINGLETON (LIST OF BOOLEAN-VECTOR) (LIST V-1-0))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT V-0-1-SINGLETON (LIST OF BOOLEAN-VECTOR) (LIST V-0-1))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT ESTIMATED-SLOT-VALUE-COLLECTION-SIZE COST-ESTIMATE 4.0 :DOCUMENTATION \"Estimate of the average size of a collection\nrepresenting the fillers of a slot.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT ESTIMATED-NUMBER-OF-PREDICATE-BINDINGS COST-ESTIMATE 6.0 :DOCUMENTATION \"Very crude estimate of the number of stored propositions\nthat will match a predicate at least one of whose arguments are bound.\nChosen to be larger than ESTIMATED-SLOT-VALUE-COLLECTION-SIZE.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT ESTIMATED-SIZE-OF-CLASS-EXTENSION COST-ESTIMATE 11.0 :DOCUMENTATION \"Must be greater than ESTIMATED-NUMBER-OF-PREDICATE-BINDINGS\nto force the optimizer to prefer predicates containing at least\none bound variable.  Also greater than ESTIMATED-SIZE-OF-PREDICATE-EXTENSION,\nfor no particularly valid reason.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT ESTIMATED-CARDINALITY-OF-DESCRIPTION COST-ESTIMATE 20.0 :DOCUMENTATION \"Indefensible estimate of the number instances\ngenerable by an arbitrary unnamed description.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT ESTIMATED-CARDINALITY-OF-MEMBER-OF COST-ESTIMATE 30.0 :DOCUMENTATION \"Even more indefensible estimate of the number instances\ngenerable by a 'member-of' predicate.  CAUTION: Must be set\nless than 'ESTIMATED-CARDINALITY-OF-SUBSET-OF'.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT ESTIMATED-CARDINALITY-OF-SUBSET-OF COST-ESTIMATE 40.0 :DOCUMENTATION \"Egregiously indefensible estimate of the number instances\ngenerable by a 'subset-of' predicate.  Set high because 'subset-of'\ncan't generate all defined supersets or subsets, causing potential\nincompleteness.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT INFERABLE-PENALTY-COST COST-ESTIMATE 7.0 :DOCUMENTATION \"Amount of penalty for using inferable relations as goals.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT SUBSET-OF-PENALTY-COST COST-ESTIMATE 20.0 :DOCUMENTATION \"Amount of penalty for using 'subset-of' as a goal.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *OPTIMALGOALORDERINGRECURSIONS* INTEGER NULL)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *OPTIMAL-GOAL-ORDERING-CUTOFF* INTEGER 100)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *QUERYOPTIMIZERCONTROLFRAME* CONTROL-FRAME :DOCUMENTATION \"Keeps track of last control frame allocated by\nthe query optimizer.  Used by recursive invocations of the optimizer.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *BOUNDTOOFFSETCOUNTER* INTEGER NULL :DOCUMENTATION \"Enables 'select-optimal-query-pattern' to tell\n'copy-variables-vector' that it should initialize the 'bound-to-offset'\nslot of each variable in the copy operation.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *QUERY-OPTIMIZATION-STRATEGY* KEYWORD :DYNAMIC :DOCUMENTATION \"Keyword indicating what clause reordering strategy should\nbe used for conjunctive queries.  Legal values are :STATIC which performs\noptimization once for each conjunctive pattern by simulating a query,\n:STATIC-WITH-CLUSTERING which additionally tries to cluster conjunction into\nindependent clusters, :DYNAMIC which performs simple greedy optimization\ndynamically during a query, :DYNAMIC-WITH-CLUSTERING which also looks\nfor clusters (not yet implemented), and :NONE to indicate no optimization\nshould be performed.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *POSTOPTIMIZATION?* BOOLEAN FALSE :DOCUMENTATION \"Used by 'simplify-description' to permit application\nof order-dependent optimizations.\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
