//  -*- Mode: Java -*-
//
// _StartupPartialMatch.java

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

public class _StartupPartialMatch {
  static void helpStartupPartialMatch1() {
    {
      Logic.KWD_BASIC = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("BASIC", null, 2)));
      Logic.KWD_MAX = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MAX", null, 2)));
      Logic.SYM_LOGIC_CHILD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CHILD", null, 0)));
      Logic.SYM_LOGIC_NEGATIVE_SCORE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NEGATIVE-SCORE", null, 0)));
      Logic.SYM_LOGIC_DYNAMIC_CUTOFF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DYNAMIC-CUTOFF", null, 0)));
      Logic.SYM_LOGIC_ARGUMENT_WEIGHTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ARGUMENT-WEIGHTS", null, 0)));
      Logic.SYM_LOGIC_UNBOUND_VARS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UNBOUND-VARS", null, 0)));
      Logic.KWD_CONTROL_FRAME = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTROL-FRAME", null, 2)));
      Logic.KWD_KIND = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("KIND", null, 2)));
      Logic.SGT_LOGIC_INCREMENTAL_PARTIAL_MATCH = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INCREMENTAL-PARTIAL-MATCH", null, 1)));
      Logic.SYM_LOGIC_ACCUMULATED_SCORE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ACCUMULATED-SCORE", null, 0)));
      Logic.SYM_LOGIC_ACCUMULATED_WEIGHT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ACCUMULATED-WEIGHT", null, 0)));
      Logic.SYM_LOGIC_TOTAL_WEIGHT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TOTAL-WEIGHT", null, 0)));
      Logic.SYM_LOGIC_MAXIMUM_SCORE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MAXIMUM-SCORE", null, 0)));
      Logic.KWD_SKIPPED_CONJUNCT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SKIPPED-CONJUNCT", null, 2)));
      Logic.KWD_NOISY_OR = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NOISY-OR", null, 2)));
      Logic.SYM_LOGIC_INFERENCE_CUTOFF_REASON = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INFERENCE-CUTOFF-REASON", null, 0)));
      Logic.SYM_LOGIC_RULES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RULES", null, 0)));
      Logic.SYM_STELLA_ARITY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ARITY", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.KWD_INCREMENTAL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INCREMENTAL", null, 2)));
      Logic.KWD_NN = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NN", null, 2)));
      Logic.KWD_NEURAL_NETWORK = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NEURAL-NETWORK", null, 2)));
      Logic.SGT_PL_KERNEL_KB_NULL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SYM_LOGIC_STARTUP_PARTIAL_MATCH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-PARTIAL-MATCH", null, 0)));
    }
  }

  static void helpStartupPartialMatch2() {
    {
      Stella.defineFunctionObject("SET-PARTIAL-MATCH-MODE", "(DEFUN SET-PARTIAL-MATCH-MODE ((K KEYWORD)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setPartialMatchMode", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("SET-RULE-COMBINATION", "(DEFUN SET-RULE-COMBINATION ((K KEYWORD)) :COMMAND? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setRuleCombination", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("SET-GREEDY-NETWORK-PRUNING", "(DEFUN SET-GREEDY-NETWORK-PRUNING ((B BOOLEAN)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setGreedyNetworkPruning", new java.lang.Class [] {java.lang.Boolean.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "setGreedyNetworkPruningEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("SET-MAXIMUM-SCORE-CUTOFF", "(DEFUN SET-MAXIMUM-SCORE-CUTOFF ((C FLOAT)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setMaximumScoreCutoff", new java.lang.Class [] {java.lang.Double.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "setMaximumScoreCutoffEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("SET-MINIMUM-SCORE-CUTOFF", "(DEFUN SET-MINIMUM-SCORE-CUTOFF ((C FLOAT)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setMinimumScoreCutoff", new java.lang.Class [] {java.lang.Double.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "setMinimumScoreCutoffEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("LINK-TO-PARENT-PARTIAL-MATCH-FRAME", "(DEFUN LINK-TO-PARENT-PARTIAL-MATCH-FRAME ((SELF PARTIAL-MATCH-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "linkToParentPartialMatchFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PartialMatchFrame")}), null);
      Stella.defineMethodObject("(DEFMETHOD (CREATE-PARTIAL-MATCH-FRAME PARTIAL-MATCH-FRAME) ((SELF PARTIAL-MATCH-FRAME) (FRAME CONTROL-FRAME) (KIND KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "createPartialMatchFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COMPUTE-DYNAMIC-CUTOFF PARTIAL-MATCH-SCORE) ((SELF PARTIAL-MATCH-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "computeDynamicCutoff", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD SET-DYNAMIC-CUTOFF ((SELF PARTIAL-MATCH-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "setDynamicCutoff", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CUTOFF-PARTIAL-MATCH? BOOLEAN) ((SELF PARTIAL-MATCH-FRAME) (TRACE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "cutoffPartialMatchP", new java.lang.Class [] {java.lang.Boolean.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (PROPOSITION-WEIGHT FLOAT) ((SELF PARTIAL-MATCH-FRAME) (PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "propositionWeight", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD CLEAR-FRAME-PARTIAL-TRUTH ((SELF PARTIAL-MATCH-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "clearFramePartialTruth", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (DEFINED-FRAME-PARTIAL-TRUTH? BOOLEAN) ((SELF CONTROL-FRAME)) :GLOBALLY-INLINE? TRUE (RETURN (AND (DEFINED? (PARTIAL-MATCH-FRAME SELF)) (DEFINED-FRAME-PARTIAL-TRUTH? (PARTIAL-MATCH-FRAME SELF)))))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "definedFramePartialTruthP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (DEFINED-FRAME-PARTIAL-TRUTH? BOOLEAN) ((SELF PARTIAL-MATCH-FRAME)) :GLOBALLY-INLINE? TRUE (RETURN (OR (DEFINED? (POSITIVE-SCORE SELF)) (DEFINED? (NEGATIVE-SCORE SELF)))))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "definedFramePartialTruthP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD SET-FRAME-PARTIAL-TRUTH ((SELF PARTIAL-MATCH-FRAME) (TRUTHVALUE TRUTH-VALUE) (POSSCORE PARTIAL-MATCH-SCORE) (NEGSCORE PARTIAL-MATCH-SCORE) (IGNOREPOLARITY? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "setFramePartialTruth", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruthValue"), java.lang.Double.TYPE, java.lang.Double.TYPE, java.lang.Boolean.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD PROPAGATE-FRAME-PARTIAL-TRUTH ((SOURCE PARTIAL-MATCH-FRAME) (TARGET CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "propagateFramePartialTruth", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD TRACE-FRAME-PARTIAL-TRUTH ((SELF PARTIAL-MATCH-FRAME) (LASTMOVE KEYWORD) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "traceFramePartialTruth", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.OutputStream")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD SET-CACHE-PARTIAL-TRUTH ((SELF CONTROL-FRAME) (CACHE ATOMIC-GOAL-CACHE)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "setCachePartialTruth", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.AtomicGoalCache")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD SET-CACHE-PARTIAL-TRUTH ((SELF PARTIAL-MATCH-FRAME) (CACHE ATOMIC-GOAL-CACHE)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "setCachePartialTruth", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.AtomicGoalCache")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD SET-JUSTIFICATION-PARTIAL-TRUTH ((SELF CONTROL-FRAME) (JUSTIFICATION JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "setJustificationPartialTruth", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD SET-JUSTIFICATION-PARTIAL-TRUTH ((SELF PARTIAL-MATCH-FRAME) (JUSTIFICATION JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "setJustificationPartialTruth", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (ALLOW-UNBOUND-VARIABLES? BOOLEAN) ((SELF PARTIAL-MATCH-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "allowUnboundVariablesP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COMPUTE-AND-SCORE PARTIAL-MATCH-SCORE) ((SELF PARTIAL-MATCH-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "computeAndScore", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CONTINUE-PARTIAL-AND-PROOF KEYWORD) ((SELF PARTIAL-MATCH-FRAME) (FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "continuePartialAndProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COMPUTE-OR-SCORE PARTIAL-MATCH-SCORE) ((SELF PARTIAL-MATCH-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "computeOrScore", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CONTINUE-PARTIAL-OR-PROOF KEYWORD) ((SELF PARTIAL-MATCH-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "continuePartialOrProof", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COMPUTE-NOT-SCORE PARTIAL-MATCH-SCORE) ((SELF PARTIAL-MATCH-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "computeNotScore", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CONTINUE-PARTIAL-NOT-PROOF KEYWORD) ((SELF PARTIAL-MATCH-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "continuePartialNotProof", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CONTINUE-PARTIAL-FAIL-PROOF KEYWORD) ((SELF PARTIAL-MATCH-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "continuePartialFailProof", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COMPUTE-GOAL-SCORE PARTIAL-MATCH-SCORE) ((SELF PARTIAL-MATCH-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "computeGoalScore", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CONTINUE-PARTIAL-STRATEGIES-PROOFS KEYWORD) ((SELF PARTIAL-MATCH-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "continuePartialStrategiesProofs", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CONTINUE-PARTIAL-ANTECEDENTS-PROOF KEYWORD) ((SELF PARTIAL-MATCH-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "continuePartialAntecedentsProof", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD SET-BASE-PARTIAL-MATCH-TRUTH ((SELF PARTIAL-MATCH-FRAME) (PROP PROPOSITION) (TRUTH KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "setBasePartialMatchTruth", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD RECORD-PARTIAL-MATCH-SCORE ((SELF PARTIAL-MATCH-FRAME) (SCORE PARTIAL-MATCH-SCORE) (WEIGHT FLOAT)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "recordPartialMatchScore", new java.lang.Class [] {java.lang.Double.TYPE, java.lang.Double.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD POP-PARTIAL-MATCH-SCORE ((SELF PARTIAL-MATCH-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "popPartialMatchScore", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (EARLY-PARTIAL-MATCH-AND-FAILURE? BOOLEAN) ((SELF PARTIAL-MATCH-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "earlyPartialMatchAndFailureP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (EARLY-PARTIAL-MATCH-OR-SUCCESS? BOOLEAN) ((SELF PARTIAL-MATCH-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "earlyPartialMatchOrSuccessP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("INITIALIZE-INCREMENTAL-PARTIAL-MATCH", "(DEFUN INITIALIZE-INCREMENTAL-PARTIAL-MATCH ((SELF INCREMENTAL-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "initializeIncrementalPartialMatch", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.IncrementalPartialMatch")}), null);
      Stella.defineMethodObject("(DEFMETHOD (CREATE-PARTIAL-MATCH-FRAME PARTIAL-MATCH-FRAME) ((SELF INCREMENTAL-PARTIAL-MATCH) (FRAME CONTROL-FRAME) (KIND KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "createPartialMatchFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COMPUTE-DYNAMIC-CUTOFF PARTIAL-MATCH-SCORE) ((SELF INCREMENTAL-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "computeDynamicCutoff", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD CLEAR-FRAME-PARTIAL-TRUTH ((SELF INCREMENTAL-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "clearFramePartialTruth", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (PROPOSITION-WEIGHT FLOAT) ((SELF INCREMENTAL-PARTIAL-MATCH) (PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "propositionWeight", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD PUSH-AND-PARTIAL-MATCH-SCORE ((SELF INCREMENTAL-PARTIAL-MATCH) (SCORE PARTIAL-MATCH-SCORE) (WEIGHT FLOAT)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "pushAndPartialMatchScore", new java.lang.Class [] {java.lang.Double.TYPE, java.lang.Double.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD POP-AND-PARTIAL-MATCH-SCORE ((SELF INCREMENTAL-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "popAndPartialMatchScore", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COMPUTE-AND-SCORE PARTIAL-MATCH-SCORE) ((SELF INCREMENTAL-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "computeAndScore", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (SKIP-AND-CLAUSE? BOOLEAN) ((SELF INCREMENTAL-PARTIAL-MATCH) (FRAME CONTROL-FRAME) (FORBIDDENVARS (CONS OF PATTERN-VARIABLE))))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "skipAndClauseP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Cons")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CONTINUE-PARTIAL-AND-PROOF KEYWORD) ((SELF INCREMENTAL-PARTIAL-MATCH) (FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "continuePartialAndProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD PUSH-OR-PARTIAL-MATCH-SCORE ((SELF INCREMENTAL-PARTIAL-MATCH) (SCORE PARTIAL-MATCH-SCORE) (WEIGHT FLOAT)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "pushOrPartialMatchScore", new java.lang.Class [] {java.lang.Double.TYPE, java.lang.Double.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD POP-OR-PARTIAL-MATCH-SCORE ((SELF INCREMENTAL-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "popOrPartialMatchScore", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COMPUTE-OR-SCORE PARTIAL-MATCH-SCORE) ((SELF INCREMENTAL-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "computeOrScore", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CONTINUE-PARTIAL-OR-PROOF KEYWORD) ((SELF INCREMENTAL-PARTIAL-MATCH) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "continuePartialOrProof", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COMPUTE-NOT-SCORE PARTIAL-MATCH-SCORE) ((SELF INCREMENTAL-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "computeNotScore", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CONTINUE-PARTIAL-NOT-PROOF KEYWORD) ((SELF INCREMENTAL-PARTIAL-MATCH) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "continuePartialNotProof", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COMPUTE-GOAL-SCORE PARTIAL-MATCH-SCORE) ((SELF INCREMENTAL-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "computeGoalScore", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CONTINUE-PARTIAL-STRATEGIES-PROOFS KEYWORD) ((SELF INCREMENTAL-PARTIAL-MATCH) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "continuePartialStrategiesProofs", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CONTINUE-PARTIAL-ANTECEDENTS-PROOF KEYWORD) ((SELF INCREMENTAL-PARTIAL-MATCH) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "continuePartialAntecedentsProof", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CONTINUE-PARTIAL-FAIL-PROOF KEYWORD) ((SELF INCREMENTAL-PARTIAL-MATCH) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "continuePartialFailProof", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD INITIALIZE-NN-PARTIAL-MATCH ((SELF NN-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.NnPartialMatch", "initializeNnPartialMatch", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CREATE-PARTIAL-MATCH-FRAME PARTIAL-MATCH-FRAME) ((SELF NN-PARTIAL-MATCH) (FRAME CONTROL-FRAME) (KIND KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.NnPartialMatch", "createPartialMatchFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COMPUTE-DYNAMIC-CUTOFF PARTIAL-MATCH-SCORE) ((SELF NN-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.NnPartialMatch", "computeDynamicCutoff", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
    }
  }

  static void helpStartupPartialMatch3() {
    {
      Stella.defineMethodObject("(DEFMETHOD (PROPOSITION-WEIGHT FLOAT) ((SELF NN-PARTIAL-MATCH) (PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.NnPartialMatch", "propositionWeight", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD SET-BASE-PARTIAL-MATCH-TRUTH ((SELF NN-PARTIAL-MATCH) (PROP PROPOSITION) (TRUTH KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.NnPartialMatch", "setBasePartialMatchTruth", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD SET-CACHE-PARTIAL-TRUTH ((SELF NN-PARTIAL-MATCH) (CACHE ATOMIC-GOAL-CACHE)))", Native.find_java_method("edu.isi.powerloom.logic.NnPartialMatch", "setCachePartialTruth", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.AtomicGoalCache")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD SET-JUSTIFICATION-PARTIAL-TRUTH ((SELF NN-PARTIAL-MATCH) (JUSTIFICATION JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.NnPartialMatch", "setJustificationPartialTruth", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD RECORD-PARTIAL-MATCH-SCORE ((SELF NN-PARTIAL-MATCH) (SCORE PARTIAL-MATCH-SCORE) (WEIGHT FLOAT)))", Native.find_java_method("edu.isi.powerloom.logic.NnPartialMatch", "recordPartialMatchScore", new java.lang.Class [] {java.lang.Double.TYPE, java.lang.Double.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD POP-PARTIAL-MATCH-SCORE ((SELF NN-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.NnPartialMatch", "popPartialMatchScore", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COMPUTE-AND-SCORE PARTIAL-MATCH-SCORE) ((SELF NN-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.NnPartialMatch", "computeAndScore", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COMPUTE-OR-SCORE PARTIAL-MATCH-SCORE) ((SELF NN-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.NnPartialMatch", "computeOrScore", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COMPUTE-NOT-SCORE PARTIAL-MATCH-SCORE) ((SELF NN-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.NnPartialMatch", "computeNotScore", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COMPUTE-GOAL-SCORE PARTIAL-MATCH-SCORE) ((SELF NN-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.NnPartialMatch", "computeGoalScore", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("PROBABILISTIC-SUM-N", "(DEFUN (PROBABILISTIC-SUM-N FLOAT) ((FORM (CONS OF FLOAT-WRAPPER))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "probabilisticSumN", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("PROBABILISTIC-SUM", "(DEFUN (PROBABILISTIC-SUM FLOAT) ((X FLOAT) (Y FLOAT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "probabilisticSum", new java.lang.Class [] {java.lang.Double.TYPE, java.lang.Double.TYPE}), null);
      Stella.defineMethodObject("(DEFMETHOD (EARLY-PARTIAL-MATCH-AND-FAILURE? BOOLEAN) ((SELF NN-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.NnPartialMatch", "earlyPartialMatchAndFailureP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (EARLY-PARTIAL-MATCH-OR-SUCCESS? BOOLEAN) ((SELF NN-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.NnPartialMatch", "earlyPartialMatchOrSuccessP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("PRUNE-NN-SEARCH?", "(DEFUN (PRUNE-NN-SEARCH? BOOLEAN) ((SELF NN-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.NnPartialMatch", "pruneNnSearchP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NnPartialMatch")}), null);
      Stella.defineFunctionObject("MAKE-PARTIAL-MATCH-FRAME", "(DEFUN (MAKE-PARTIAL-MATCH-FRAME PARTIAL-MATCH-FRAME) ((QUERY QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "makePartialMatchFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator")}), null);
      Stella.defineFunctionObject("INITIALIZE-PARTIAL-QUERY", "(DEFUN INITIALIZE-PARTIAL-QUERY ((QUERY QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "initializePartialQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator")}), null);
      Stella.defineMethodObject("(DEFMETHOD INITIALIZE-PARTIAL-MATCH-STRATEGY ((SELF PARTIAL-MATCH-FRAME) (QUERY QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "initializePartialMatchStrategy", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("CREATE-AND-LINK-PARTIAL-MATCH-FRAME", "(DEFUN CREATE-AND-LINK-PARTIAL-MATCH-FRAME ((FRAME CONTROL-FRAME) (KIND KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "createAndLinkPartialMatchFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("GET-UNBOUND-VARIABLES", "(DEFUN (GET-UNBOUND-VARIABLES CONS) ((PROP PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "getUnboundVariables", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("ALL-VARIABLES-UNBOUND?", "(DEFUN (ALL-VARIABLES-UNBOUND? BOOLEAN) ((PROP PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "allVariablesUnboundP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("UNBOUND-VARIABLES-IN-FRAME?", "(DEFUN (UNBOUND-VARIABLES-IN-FRAME? BOOLEAN) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "unboundVariablesInFrameP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("RECORD-LATEST-PARTIAL-MATCH-SCORE", "(DEFUN RECORD-LATEST-PARTIAL-MATCH-SCORE ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "recordLatestPartialMatchScore", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("COMPUTE-PARTIAL-MATCH-AND-FAILURE?", "(DEFUN (COMPUTE-PARTIAL-MATCH-AND-FAILURE? BOOLEAN) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "computePartialMatchAndFailureP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("COMPUTE-PARTIAL-MATCH-OR-SUCCESS?", "(DEFUN (COMPUTE-PARTIAL-MATCH-OR-SUCCESS? BOOLEAN) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "computePartialMatchOrSuccessP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("COMPUTE-PARTIAL-MATCH-SCORE?", "(DEFUN (COMPUTE-PARTIAL-MATCH-SCORE? BOOLEAN) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "computePartialMatchScoreP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("RETRIEVE-PARTIAL", "(DEFUN (RETRIEVE-PARTIAL QUERY-ITERATOR) (|&REST| (TREE PARSE-TREE)) :DOCUMENTATION \"Partial-match version of `retrieve' (which see) that generates scored\npartial solutions based on the current partial match strategy.  By supplying\n`BEST' instead of `ALL', or by adding the option `:SORT-BY :SCORE', the generated\nsolutions will be sorted so that solutions with higher scores come first.\nUse the `:MATCH-MODE' option to override the global default setting established\nby `set-partial-match-mode', e.g., use `:MATCH-MODE :NN' to use the neural\nnet partial match mode.  The `:MINIMUM-SCORE' option can be used to only\nretrieve solutions that have at least the specified minimum match score.\nBy default, `retrieve-partial' does not maximize the match scores of its returned\nbindings.  To only get maximal scores use `:MAXIMIZE-SCORE? TRUE' (this is not\nyet implemented - you can use `ask-partial' to maximize scores for individual\nsolutions by hand).\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "retrievePartial", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "retrievePartialEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("CALL-RETRIEVE-PARTIAL", "(DEFUN (CALL-RETRIEVE-PARTIAL QUERY-ITERATOR) ((QUERY OBJECT)) :DOCUMENTATION \"Callable version of `retrieve-partial' (which see).  Accepts queries\nspecified by a query iterator, or specified as a CONS-list of arguments as they\nwould be supplied to `retrieve-partial'.  Raises LOGIC-EXCEPTIONs in case of\nillegal queries and logical expressions.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "callRetrievePartial", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineMethodObject("(DEFMETHOD (RETRIEVE-PARTIAL-SOLUTIONS QUERY-ITERATOR) ((SELF PARTIAL-MATCH-FRAME) (QUERY QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "retrievePartialSolutions", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (RETRIEVE-PARTIAL-SOLUTIONS QUERY-ITERATOR) ((SELF INCREMENTAL-PARTIAL-MATCH) (QUERY QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "retrievePartialSolutions", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("SORT-SOLUTIONS-BY-SCORE", "(DEFUN SORT-SOLUTIONS-BY-SCORE ((QUERY QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "sortSolutionsByScore", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator")}), null);
      Stella.defineFunctionObject("SOLUTION-SCORE-GREATER-THAN?", "(DEFUN (SOLUTION-SCORE-GREATER-THAN? BOOLEAN) ((S1 QUERY-SOLUTION) (S2 QUERY-SOLUTION)))", Native.find_java_method("edu.isi.powerloom.logic.QuerySolution", "solutionScoreGreaterThanP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QuerySolution"), Native.find_java_class("edu.isi.powerloom.logic.QuerySolution")}), null);
      Stella.defineFunctionObject("ASK-PARTIAL", "(DEFUN (ASK-PARTIAL FLOAT) (|&REST| (|PROPOSITION&OPTIONS| PARSE-TREE)) :DOCUMENTATION \"Similar to `ask' (which see), but return the highest partial match score\nfor the supplied proposition instead of a truth value.  If the option\n:MAXIMIZE-SCORE? is set to FALSE, return after the first partial match score\nhas been generated.\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "askPartial", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "askPartialEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("RETURN-PARTIAL-TRUTH", "(DEFUN (RETURN-PARTIAL-TRUTH FLOAT) ((QUERY QUERY-ITERATOR) (TOP? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "returnPartialTruth", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CALL-ASK-PARTIAL", "(DEFUN (CALL-ASK-PARTIAL FLOAT) ((QUERY OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "callAskPartial", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineMethodObject("(DEFMETHOD (COMPUTE-PARTIAL-TRUTH FLOAT) ((SELF PARTIAL-MATCH-FRAME) (QUERY QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "computePartialTruth", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COMPUTE-PARTIAL-TRUTH FLOAT) ((SELF INCREMENTAL-PARTIAL-MATCH) (QUERY QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "computePartialTruth", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COMPUTE-PARTIAL-TRUTH FLOAT) ((SELF NN-PARTIAL-MATCH) (QUERY QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.NnPartialMatch", "computePartialTruth", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("NULL-INSTANCE?", "(DEFUN (NULL-INSTANCE? BOOLEAN) ((X OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "nullInstanceP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("GET-NULL-INSTANCE", "(DEFUN (GET-NULL-INSTANCE LOGIC-OBJECT) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getNullInstance", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("NULL-INSTANCE-PROPOSITIONS-EXIST?", "(DEFUN (NULL-INSTANCE-PROPOSITIONS-EXIST? BOOLEAN) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "nullInstancePropositionsExistP", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("ALL-MATCHING-PARTIAL-PROPOSITIONS", "(DEFUN (ALL-MATCHING-PARTIAL-PROPOSITIONS (ITERATOR OF PROPOSITION)) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "allMatchingPartialPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("PARTIAL-ARGUMENTS-UNIFY-WITH-ARGUMENTS?", "(DEFUN (PARTIAL-ARGUMENTS-UNIFY-WITH-ARGUMENTS? BOOLEAN) ((SUBPROPOSITION PROPOSITION) (REFERENCEPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "partialArgumentsUnifyWithArgumentsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("TRY-SCAN-PARTIAL-PROPOSITIONS-PROOF", "(DEFUN (TRY-SCAN-PARTIAL-PROPOSITIONS-PROOF KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "tryScanPartialPropositionsProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("STARTUP-PARTIAL-MATCH", "(DEFUN STARTUP-PARTIAL-MATCH () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupPartialMatch", "startupPartialMatch", new java.lang.Class [] {}), null);
      { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_PARTIAL_MATCH);

        KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupPartialMatch"), Stella.NULL_STRING_WRAPPER);
      }
    }
  }

  public static void startupPartialMatch() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupPartialMatch.helpStartupPartialMatch1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Logic.$PARTIAL_MATCH_MODE$ = Logic.KWD_BASIC;
          Logic.$RULE_COMBINATION$ = Logic.KWD_MAX;
          Logic.$PLANABLE_PREDICATES$ = Stella.NIL;
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("PARTIAL-MATCH-FRAME", "(DEFCLASS PARTIAL-MATCH-FRAME (STANDARD-OBJECT) :DOCUMENTATION \"Abstract class acting as placeholder for system and\nuser-defined partial match implementations.\" :ABSTRACT? TRUE :SLOTS ((KIND :TYPE KEYWORD :REQUIRED? TRUE) (CONTROL-FRAME :TYPE CONTROL-FRAME :REQUIRED? TRUE) (PARENT :TYPE PARTIAL-MATCH-FRAME) (CHILD :TYPE PARTIAL-MATCH-FRAME) (POSITIVE-SCORE :TYPE PARTIAL-MATCH-SCORE :INITIALLY NULL) (NEGATIVE-SCORE :TYPE PARTIAL-MATCH-SCORE :INITIALLY NULL) (DYNAMIC-CUTOFF :TYPE FLOAT) (ARGUMENT-SCORES :TYPE (CONS OF FLOAT-WRAPPER) :INITIALLY NIL) (ARGUMENT-WEIGHTS :TYPE (CONS OF FLOAT-WRAPPER) :INITIALLY NIL) (UNBOUND-VARS :TYPE CONS :INITIALLY NIL) (SUCCESS? :TYPE BOOLEAN :INITIALLY FALSE)))");

            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.PartialMatchFrame", "accessPartialMatchFrameSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PartialMatchFrame"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("INCREMENTAL-PARTIAL-MATCH", "(DEFCLASS INCREMENTAL-PARTIAL-MATCH (PARTIAL-MATCH-FRAME) :SLOTS ((PARENT :TYPE INCREMENTAL-PARTIAL-MATCH) (CHILD :TYPE INCREMENTAL-PARTIAL-MATCH) (ACCUMULATED-SCORE :TYPE PARTIAL-MATCH-SCORE :INITIALLY 0.0) (ACCUMULATED-WEIGHT :TYPE FLOAT :INITIALLY 0.0) (TOTAL-WEIGHT :TYPE FLOAT) (MAXIMUM-SCORE :TYPE PARTIAL-MATCH-SCORE :INITIALLY 0.0)) :INITIALIZER INITIALIZE-INCREMENTAL-PARTIAL-MATCH)");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "newIncrementalPartialMatch", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.IncrementalPartialMatch", "accessIncrementalPartialMatchSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.IncrementalPartialMatch"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("NN-PARTIAL-MATCH", "(DEFCLASS NN-PARTIAL-MATCH (PARTIAL-MATCH-FRAME) :SLOTS ((PARENT :TYPE NN-PARTIAL-MATCH) (CHILD :TYPE NN-PARTIAL-MATCH) (ACCUMULATED-SCORE :TYPE PARTIAL-MATCH-SCORE :INITIALLY 0.0) (MAXIMUM-SCORE :TYPE PARTIAL-MATCH-SCORE :INITIALLY 0.0) (RULES :TYPE (CONS OF PROPOSITION) :INITIALLY NIL) (ARITY :TYPE INTEGER)) :INITIALIZER INITIALIZE-NN-PARTIAL-MATCH)");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.NnPartialMatch", "newNnPartialMatch", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.NnPartialMatch", "accessNnPartialMatchSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NnPartialMatch"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupPartialMatch.helpStartupPartialMatch2();
          _StartupPartialMatch.helpStartupPartialMatch3();
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *PARTIAL-MATCH-MODE* KEYWORD :BASIC)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *GREEDY-NETWORK-PRUNING* BOOLEAN TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *RULE-COMBINATION* KEYWORD :MAX)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *PLANNING-MODE* BOOLEAN FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *PLANABLE-PREDICATES* CONS NIL)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *FAIL-UNBOUND-CLAUSES?* BOOLEAN FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *MINIMUM-SCORE-CUTOFF* PARTIAL-MATCH-SCORE 0.0 :DOCUMENTATION \"Positive scores below *minimum-score-cutoff* get trimmed\nto 0.0 during partial match operations.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *MAXIMUM-SCORE-CUTOFF* PARTIAL-MATCH-SCORE 0.0 :DOCUMENTATION \"Positive scores above *maximum-score-cutoff* get trimmed\nto 1.0 during partial match operations.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *AND-MISSED-A-BINDING* BOOLEAN FALSE)");
          { Object old$Module$001 = Stella.$MODULE$.get();
            Object old$Context$001 = Stella.$CONTEXT$.get();

            try {
              Native.setSpecial(Stella.$MODULE$, Logic.$PL_KERNEL_MODULE$);
              Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
              Logic.createLogicInstance(Logic.SGT_PL_KERNEL_KB_NULL, null);

            } finally {
              Stella.$CONTEXT$.set(old$Context$001);
              Stella.$MODULE$.set(old$Module$001);
            }
          }
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
