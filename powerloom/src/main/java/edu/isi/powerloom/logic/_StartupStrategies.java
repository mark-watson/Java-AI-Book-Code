//  -*- Mode: Java -*-
//
// _StartupStrategies.java

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

public class _StartupStrategies {
  static void helpStartupStrategies1() {
    {
      Logic.KWD_TERMINAL_FAILURE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TERMINAL-FAILURE", null, 2)));
      Logic.SYM_LOGIC_PROOF_ADJUNCT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PROOF-ADJUNCT", null, 0)));
      Logic.KWD_SELECT_PARALLEL_THREAD = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SELECT-PARALLEL-THREAD", null, 2)));
      Logic.KWD_TIME_OUT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TIME-OUT", null, 2)));
      Logic.KWD_CONDITIONAL_ANTECEDENT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONDITIONAL-ANTECEDENT", null, 2)));
      Logic.KWD_DUMMY_JUSTIFICATION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DUMMY-JUSTIFICATION", null, 2)));
      Logic.KWD_LOOKUP_GOAL_CACHES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LOOKUP-GOAL-CACHES", null, 2)));
      Logic.KWD_SCAN_PROPOSITIONS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SCAN-PROPOSITIONS", null, 2)));
      Logic.KWD_SCAN_PARTIAL_PROPOSITIONS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SCAN-PARTIAL-PROPOSITIONS", null, 2)));
      Logic.KWD_SCAN_COLLECTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SCAN-COLLECTION", null, 2)));
      Logic.KWD_SHALLOW_DISPROOF = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SHALLOW-DISPROOF", null, 2)));
      Logic.KWD_SCAN_FOR_VALUE_CLASH = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SCAN-FOR-VALUE-CLASH", null, 2)));
      Logic.KWD_ALL_SUBGOAL_STRATEGIES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ALL-SUBGOAL-STRATEGIES", null, 2)));
      Logic.KWD_GOAL_COMPLEMENT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("GOAL-COMPLEMENT", null, 2)));
      Logic.KWD_FORWARD_GOALS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FORWARD-GOALS", null, 2)));
      Logic.KWD_EQUIVALENCE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("EQUIVALENCE", null, 2)));
      Logic.KWD_UNIVERSAL_INTRODUCTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("UNIVERSAL-INTRODUCTION", null, 2)));
      Logic.KWD_SUBSUMPTION_TEST = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SUBSUMPTION-TEST", null, 2)));
      Logic.KWD_DEBUG = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DEBUG", null, 2)));
      Logic.SGT_LOGIC_WHYNOT_PARTIAL_MATCH = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("WHYNOT-PARTIAL-MATCH", null, 1)));
      Logic.KWD_DUPLICATE_ = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DUPLICATE-", null, 2)));
      Logic.KWD_FORWARD_RULE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FORWARD-RULE", null, 2)));
      Logic.SGT_LOGIC_CONDITIONAL_ANTECEDENT_PROOF_ADJUNCT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONDITIONAL-ANTECEDENT-PROOF-ADJUNCT", null, 1)));
      Logic.SYM_LOGIC_PROVABLE_RULE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PROVABLE-RULE", null, 0)));
      Logic.SYM_STELLA_PHASE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PHASE", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.KWD_ORIGINAL_GOAL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ORIGINAL-GOAL", null, 2)));
      Logic.SYM_LOGIC_CONTAINED_BY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTAINED-BY", null, 0)));
      Logic.SGT_LOGIC_CLUSTERED_CONJUNCTION_PROOF_ADJUNCT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CLUSTERED-CONJUNCTION-PROOF-ADJUNCT", null, 1)));
      Logic.SYM_LOGIC_CLUSTER_FRAMES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLUSTER-FRAMES", null, 0)));
      Logic.KWD_CONSTANT_PROPOSITION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONSTANT-PROPOSITION", null, 2)));
      Logic.SYM_LOGIC_STARTUP_STRATEGIES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-STRATEGIES", null, 0)));
    }
  }

  static void helpStartupStrategies2() {
    {
      Stella.defineFunctionObject("CONTINUE-STRATEGIES-PROOFS", "(DEFUN (CONTINUE-STRATEGIES-PROOFS KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continueStrategiesProofs", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("CLEAR-STRATEGY-SLOTS", "(DEFUN CLEAR-STRATEGY-SLOTS ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "clearStrategySlots", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("SELECT-NEXT-STRATEGY", "(DEFUN (SELECT-NEXT-STRATEGY CONTROL-FRAME) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "selectNextStrategy", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("RECORD-BASE-PARTIAL-MATCH-TRUTH", "(DEFUN RECORD-BASE-PARTIAL-MATCH-TRUTH ((FRAME CONTROL-FRAME) (RESULT KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "recordBasePartialMatchTruth", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("CONTINUE-CURRENT-OR-NEXT-STRATEGY", "(DEFUN (CONTINUE-CURRENT-OR-NEXT-STRATEGY KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continueCurrentOrNextStrategy", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("RESUME-PROOF-STRATEGY-AFTER-SUBGOAL", "(DEFUN (RESUME-PROOF-STRATEGY-AFTER-SUBGOAL KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "resumeProofStrategyAfterSubgoal", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("FILTER-OUT-STRATEGY?", "(DEFUN (FILTER-OUT-STRATEGY? BOOLEAN) ((STRATEGY KEYWORD) (FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "filterOutStrategyP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("EXECUTE-PROOF-STRATEGY", "(DEFUN (EXECUTE-PROOF-STRATEGY KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "executeProofStrategy", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("CONTINUE-PARALLEL-STRATEGIES-PROOFS", "(DEFUN (CONTINUE-PARALLEL-STRATEGIES-PROOFS KEYWORD) ((PFRAME PARALLEL-CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ParallelControlFrame", "continueParallelStrategiesProofs", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ParallelControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("PARALLEL-STRATEGY?", "(DEFUN (PARALLEL-STRATEGY? BOOLEAN) ((STRATEGY KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "parallelStrategyP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("SELECT-NEXT-CHILD-THREAD", "(DEFUN (SELECT-NEXT-CHILD-THREAD PARALLEL-THREAD) ((PFRAME PARALLEL-CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ParallelControlFrame", "selectNextChildThread", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ParallelControlFrame")}), null);
      Stella.defineFunctionObject("CREATE-CHILD-THREAD", "(DEFUN (CREATE-CHILD-THREAD PARALLEL-THREAD) ((PFRAME PARALLEL-CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ParallelControlFrame", "createChildThread", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ParallelControlFrame")}), null);
      Stella.defineFunctionObject("TRY-PARALLEL-THREAD-PROOF", "(DEFUN (TRY-PARALLEL-THREAD-PROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "tryParallelThreadProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("PUSH-NEXT-STRATEGY", "(DEFUN PUSH-NEXT-STRATEGY ((FRAME CONTROL-FRAME) (STRATEGY KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "pushNextStrategy", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("CREATE-SUBGOAL-FRAME", "(DEFUN (CREATE-SUBGOAL-FRAME CONTROL-FRAME) ((UPFRAME CONTROL-FRAME) (GOAL PROPOSITION) (STRATEGY KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "createSubgoalFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("SPECIALIST-APPLICABLE?", "(DEFUN (SPECIALIST-APPLICABLE? BOOLEAN) ((DESCRIPTION NAMED-DESCRIPTION) (PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "specialistApplicableP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("CONTINUE-SPECIALIST-PROOF", "(DEFUN (CONTINUE-SPECIALIST-PROOF KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continueSpecialistProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("LOOKUP-CACHED-PROOF", "(DEFUN (LOOKUP-CACHED-PROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "lookupCachedProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("SCAN-CACHED-GOALS", "(DEFUN (SCAN-CACHED-GOALS KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "scanCachedGoals", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("FINISH-CACHED-GOAL-PROCESSING", "(DEFUN (FINISH-CACHED-GOAL-PROCESSING KEYWORD) ((CACHEDGOAL ATOMIC-GOAL-CACHE) (FRAME CONTROL-FRAME) (SUCCESSORFAILURE KEYWORD) (CONTINUING? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.AtomicGoalCache", "finishCachedGoalProcessing", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.AtomicGoalCache"), Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("TRY-GOAL-CACHES-PROOF", "(DEFUN (TRY-GOAL-CACHES-PROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "tryGoalCachesProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("TRY-LOOKUP-GROUND-ASSERTIONS-PROOF", "(DEFUN (TRY-LOOKUP-GROUND-ASSERTIONS-PROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "tryLookupGroundAssertionsProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("TRY-SCAN-PROPOSITIONS-PROOF", "(DEFUN (TRY-SCAN-PROPOSITIONS-PROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "tryScanPropositionsProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("HAS-SHALLOW-DISPROOF?", "(DEFUN (HAS-SHALLOW-DISPROOF? BOOLEAN) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "hasShallowDisproofP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("TRY-SHALLOW-DISPROOF", "(DEFUN (TRY-SHALLOW-DISPROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "tryShallowDisproof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("TRY-SCAN-FOR-VALUE-CLASH-PROOF", "(DEFUN (TRY-SCAN-FOR-VALUE-CLASH-PROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "tryScanForValueClashProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("TRY-MANUFACTURE-SKOLEM-PROOF", "(DEFUN (TRY-MANUFACTURE-SKOLEM-PROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "tryManufactureSkolemProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("EXTRACT-SUBGOAL-OF-FRAME", "(DEFUN (EXTRACT-SUBGOAL-OF-FRAME PROPOSITION) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "extractSubgoalOfFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("EXTRACT-SUBGOAL-DESCRIPTION-OF-FRAME", "(DEFUN (EXTRACT-SUBGOAL-DESCRIPTION-OF-FRAME DESCRIPTION) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "extractSubgoalDescriptionOfFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("FIND-EXTERNAL-ARGUMENTS-FOR-SUBGOAL", "(DEFUN (FIND-EXTERNAL-ARGUMENTS-FOR-SUBGOAL ARGUMENTS-VECTOR) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "findExternalArgumentsForSubgoal", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("TRY-SUBGOAL-STRATEGIES-PROOF", "(DEFUN (TRY-SUBGOAL-STRATEGIES-PROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "trySubgoalStrategiesProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("ESTABLISH-GOAL-CACHE", "(DEFUN ESTABLISH-GOAL-CACHE ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "establishGoalCache", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("CHECK-FOR-DUPLICATE-RULE?", "(DEFUN (CHECK-FOR-DUPLICATE-RULE? BOOLEAN) ((FRAME CONTROL-FRAME) (IMPLIESPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "checkForDuplicateRuleP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("CONTINUE-ANTECEDENTS-PROOF", "(DEFUN (CONTINUE-ANTECEDENTS-PROOF KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continueAntecedentsProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("ALLOCATE-ANTECEDENTS-ITERATOR", "(DEFUN (ALLOCATE-ANTECEDENTS-ITERATOR (ITERATOR OF PROPOSITION)) ((GOALDESCRIPTION DESCRIPTION) (EXTERNALARGUMENTS ARGUMENTS-VECTOR) (REVERSEPOLARITY? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "allocateAntecedentsIterator", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.Vector"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("OPTIMIZE-ORDER-OF-APPLICABLE-RULES", "(DEFUN (OPTIMIZE-ORDER-OF-APPLICABLE-RULES (CONS OF PROPOSITION)) ((RULES (CONS OF PROPOSITION)) (TAIL? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "optimizeOrderOfApplicableRules", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("TRY-GOAL-COMPLEMENT-PROOF", "(DEFUN (TRY-GOAL-COMPLEMENT-PROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "tryGoalComplementProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("TRY-FORWARD-GOALS-PROOF", "(DEFUN (TRY-FORWARD-GOALS-PROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "tryForwardGoalsProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("CREATE-CONDITIONAL-ANTECEDENT-SUBFRAME", "(DEFUN (CREATE-CONDITIONAL-ANTECEDENT-SUBFRAME CONTROL-FRAME) ((FRAME CONTROL-FRAME) (GOAL PROPOSITION) (PROVABLERULE PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "createConditionalAntecedentSubframe", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("CONTINUE-CONDITIONAL-ANTECEDENT-PROOF", "(DEFUN (CONTINUE-CONDITIONAL-ANTECEDENT-PROOF KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continueConditionalAntecedentProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("TRY-FULL-SUBQUERY-PROOF", "(DEFUN (TRY-FULL-SUBQUERY-PROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "tryFullSubqueryProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("EXTRACT-COLLECTION-ARGUMENT", "(DEFUN (EXTRACT-COLLECTION-ARGUMENT DESCRIPTION) ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "extractCollectionArgument", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("TRY-ISA-PROPOSITION-PROOF", "(DEFUN (TRY-ISA-PROPOSITION-PROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "tryIsaPropositionProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("TRY-SCAN-COLLECTION-PROOF", "(DEFUN (TRY-SCAN-COLLECTION-PROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "tryScanCollectionProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("INFERABLE-DESCRIPTION?", "(DEFUN (INFERABLE-DESCRIPTION? BOOLEAN) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "inferableDescriptionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("TRY-IMPLIES-PROOF", "(DEFUN (TRY-IMPLIES-PROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "tryImpliesProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("TRY-SIMPLE-CONTAINED-BY-PROOF", "(DEFUN (TRY-SIMPLE-CONTAINED-BY-PROOF KEYWORD) ((SUBCOLLECTION OBJECT) (SUPERCOLLECTION OBJECT) (REVERSEPOLARITY? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "trySimpleContainedByProof", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("TRY-CONTAINED-BY-PROOF", "(DEFUN (TRY-CONTAINED-BY-PROOF KEYWORD) ((UPFRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "tryContainedByProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("CREATE-CONTAINED-BY-ARGUMENT", "(DEFUN (CREATE-CONTAINED-BY-ARGUMENT PROPOSITION) ((COLLECTION OBJECT) (BRIDGEARGS LIST)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createContainedByArgument", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("CONTINUE-CONTAINED-BY-PROOF", "(DEFUN (CONTINUE-CONTAINED-BY-PROOF KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continueContainedByProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("TRY-SUBSUMPTION-TEST", "(DEFUN (TRY-SUBSUMPTION-TEST KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "trySubsumptionTest", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("TRY-EQUIVALENCE-PROOF", "(DEFUN (TRY-EQUIVALENCE-PROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "tryEquivalenceProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("CONTINUE-CLUSTERED-CONJUNCTION-PROOF", "(DEFUN (CONTINUE-CLUSTERED-CONJUNCTION-PROOF KEYWORD) ((ANDFRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continueClusteredConjunctionProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("PUSH-MONOTONIC-WORLD", "(DEFUN (PUSH-MONOTONIC-WORLD WORLD) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "pushMonotonicWorld", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("TRY-DISJUNCTIVE-IMPLICATION-PROOF", "(DEFUN (TRY-DISJUNCTIVE-IMPLICATION-PROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "tryDisjunctiveImplicationProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("RESUME-DISJUNCTIVE-IMPLICATION-PROOF", "(DEFUN (RESUME-DISJUNCTIVE-IMPLICATION-PROOF KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "resumeDisjunctiveImplicationProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("CREATE-ANONYMOUS-INSTANCE", "(DEFUN (CREATE-ANONYMOUS-INSTANCE LOGIC-OBJECT) ((PREFIX STRING) (SKOLEM? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createAnonymousInstance", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CREATE-HYPOTHESIZED-INSTANCE", "(DEFUN (CREATE-HYPOTHESIZED-INSTANCE LOGIC-OBJECT) ((PREFIX STRING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createHypothesizedInstance", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("TRY-UNIVERSAL-INTRODUCTION-PROOF", "(DEFUN (TRY-UNIVERSAL-INTRODUCTION-PROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "tryUniversalIntroductionProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("TRY-REFUTATION-PROOF", "(DEFUN (TRY-REFUTATION-PROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "tryRefutationProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
    }
  }

  public static void startupStrategies() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupStrategies.helpStartupStrategies1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Logic.$PARALLEL_STRATEGIES$ = List.list(Cons.cons(Logic.KWD_DISJUNCTIVE_IMPLICATION_INTRODUCTION, Cons.cons(Logic.KWD_UNIVERSAL_INTRODUCTION, Cons.cons(Logic.KWD_REFUTATION, Stella.NIL))));
          Logic.$PL_ANONYMOUS_MODULE$ = Stella.getStellaModule("PL-ANONYMOUS", true);
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CONDITIONAL-ANTECEDENT-PROOF-ADJUNCT", "(DEFCLASS CONDITIONAL-ANTECEDENT-PROOF-ADJUNCT (PROOF-ADJUNCT) :SLOTS ((PROVABLE-RULE :TYPE PROPOSITION) (GOAL :TYPE PROPOSITION) (PHASE :TYPE KEYWORD :INITIALLY :FORWARD-RULE)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ConditionalAntecedentProofAdjunct", "newConditionalAntecedentProofAdjunct", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.ConditionalAntecedentProofAdjunct", "accessConditionalAntecedentProofAdjunctSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ConditionalAntecedentProofAdjunct"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CLUSTERED-CONJUNCTION-PROOF-ADJUNCT", "(DEFCLASS CLUSTERED-CONJUNCTION-PROOF-ADJUNCT (PROOF-ADJUNCT) :SLOTS ((CLUSTER-FRAMES :TYPE (VECTOR OF CONTROL-FRAME))))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ClusteredConjunctionProofAdjunct", "newClusteredConjunctionProofAdjunct", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.ClusteredConjunctionProofAdjunct", "accessClusteredConjunctionProofAdjunctSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ClusteredConjunctionProofAdjunct"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupStrategies.helpStartupStrategies2();
          Stella.defineFunctionObject("CONTINUE-FORALL-PROOF", "(DEFUN (CONTINUE-FORALL-PROOF KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continueForallProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("CONTINUE-EXISTS-PROOF", "(DEFUN (CONTINUE-EXISTS-PROOF KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continueExistsProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("CONTINUE-CONSTANT-PROOF", "(DEFUN (CONTINUE-CONSTANT-PROOF KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continueConstantProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT CONTROL-FRAME INFERENCE-CUTOFF-REASON :TYPE KEYWORD :ALLOCATION :DYNAMIC)");
          Stella.defineFunctionObject("REGISTER-INFERENCE-CUTOFF", "(DEFUN REGISTER-INFERENCE-CUTOFF ((FRAME CONTROL-FRAME) (REASON KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "registerInferenceCutoff", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("CONTINUE-FAIL-PROOF", "(DEFUN (CONTINUE-FAIL-PROOF KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continueFailProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineMethodObject("(DEFMETHOD (CONTINUE-PARTIAL-FAIL-PROOF KEYWORD) ((SELF CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continuePartialFailProof", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("STARTUP-STRATEGIES", "(DEFUN STARTUP-STRATEGIES () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupStrategies", "startupStrategies", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_STRATEGIES);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupStrategies"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *PARALLEL-STRATEGIES* (LIST OF KEYWORD) (LIST :DISJUNCTIVE-IMPLICATION-INTRODUCTION :UNIVERSAL-INTRODUCTION :REFUTATION) :DOCUMENTATION \"List of strategies (keywords) that fork a parallel\ncontrol stack before executing.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *FAILED-GOAL-CUTOFFS* INTEGER 0)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *SUCCEEDED-GOAL-CUTOFFS* INTEGER 0)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *PL-ANONYMOUS-MODULE* MODULE (GET-STELLA-MODULE \"PL-ANONYMOUS\" TRUE))");
          Logic.defineExplanationPhrase(Logic.KWD_CONSTANT_PROPOSITION, Logic.KWD_TECHNICAL, "trivially", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_CONSTANT_PROPOSITION, Logic.KWD_LAY, "trivially", Stella.NIL);
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
