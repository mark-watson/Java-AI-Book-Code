//  -*- Mode: Java -*-
//
// _StartupQuery.java

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

public class _StartupQuery {
  static void helpStartupQuery1() {
    {
      Logic.SGT_LOGIC_INFERENCE_LEVEL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INFERENCE-LEVEL", null, 1)));
      Logic.SYM_STELLA_KEYWORD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("KEYWORD", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SGT_LOGIC_NORMAL_INFERENCE_LEVEL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("NORMAL-INFERENCE-LEVEL", null, 1)));
      Logic.SGT_LOGIC_BACKTRACKING_INFERENCE_LEVEL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("BACKTRACKING-INFERENCE-LEVEL", null, 1)));
      Logic.SGT_LOGIC_SUBSUMPTION_INFERENCE_LEVEL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SUBSUMPTION-INFERENCE-LEVEL", null, 1)));
      Logic.SGT_LOGIC_SHALLOW_INFERENCE_LEVEL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SHALLOW-INFERENCE-LEVEL", null, 1)));
      Logic.SGT_LOGIC_ASSERTION_INFERENCE_LEVEL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("ASSERTION-INFERENCE-LEVEL", null, 1)));
      Logic.SGT_LOGIC_REFUTATION_INFERENCE_LEVEL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("REFUTATION-INFERENCE-LEVEL", null, 1)));
      Logic.KWD_NORMAL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NORMAL", null, 2)));
      Logic.KWD_BACKTRACKING = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("BACKTRACKING", null, 2)));
      Logic.KWD_SUBSUMPTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SUBSUMPTION", null, 2)));
      Logic.KWD_ASSERTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ASSERTION", null, 2)));
      Logic.KWD_REFUTATION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("REFUTATION", null, 2)));
      Logic.SYM_LOGIC_INFERENCE_LEVEL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INFERENCE-LEVEL", null, 0)));
      Logic.KWD_LOOKUP = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LOOKUP", null, 2)));
      Logic.KWD_DUPLICATE_GOALS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DUPLICATE-GOALS", null, 2)));
      Logic.KWD_TRACE_SUBGOALS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TRACE-SUBGOALS", null, 2)));
      Logic.KWD_STRATEGIES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("STRATEGIES", null, 2)));
      Logic.SYM_LOGIC_COST_ESTIMATE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COST-ESTIMATE", null, 0)));
      Logic.SGT_LOGIC_QUERY_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY-ITERATOR", null, 1)));
      Logic.SYM_LOGIC_RESIDUE_GOALS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RESIDUE-GOALS", null, 0)));
      Logic.SYM_LOGIC_BEST_GOAL_SEQUENCE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BEST-GOAL-SEQUENCE", null, 0)));
      Logic.SYM_LOGIC_EXHAUSTEDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EXHAUSTED?", null, 0)));
      Logic.SYM_STELLA_OPTIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OPTIONS", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_SOLUTIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SOLUTIONS", null, 0)));
      Logic.SYM_LOGIC_QUERY_CONTEXT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY-CONTEXT", null, 0)));
      Logic.SYM_LOGIC_BASE_CONTROL_FRAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BASE-CONTROL-FRAME", null, 0)));
      Logic.SYM_LOGIC_CURRENT_CONTROL_FRAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CURRENT-CONTROL-FRAME", null, 0)));
      Logic.SYM_LOGIC_CURRENT_PATTERN_RECORD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CURRENT-PATTERN-RECORD", null, 0)));
      Logic.SYM_LOGIC_CURRENT_PARALLEL_THREAD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CURRENT-PARALLEL-THREAD", null, 0)));
      Logic.SYM_LOGIC_CONTROL_FRAME_PRIORITY_QUEUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTROL-FRAME-PRIORITY-QUEUE", null, 0)));
      Logic.SYM_LOGIC_AUGMENTED_GOAL_CACHEp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("AUGMENTED-GOAL-CACHE?", null, 0)));
      Logic.SYM_LOGIC_ACTIVE_GOAL_CACHES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ACTIVE-GOAL-CACHES", null, 0)));
      Logic.SYM_LOGIC_TRIGGERED_DEPTH_CUTOFFp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TRIGGERED-DEPTH-CUTOFF?", null, 0)));
      Logic.SYM_LOGIC_FAILED_TO_FIND_DUPLICATE_SUBGOALp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FAILED-TO-FIND-DUPLICATE-SUBGOAL?", null, 0)));
      Logic.SYM_LOGIC_FOUND_AT_LEAST_ONE_SOLUTIONp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FOUND-AT-LEAST-ONE-SOLUTION?", null, 0)));
      Logic.SYM_LOGIC_PARTIAL_MATCH_STRATEGY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PARTIAL-MATCH-STRATEGY", null, 0)));
      Logic.SYM_LOGIC_MAXIMUM_DEPTH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MAXIMUM-DEPTH", null, 0)));
      Logic.SYM_LOGIC_ALLOTTED_TIME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ALLOTTED-TIME", null, 0)));
      Logic.SYM_LOGIC_TIMEOUTp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEOUT?", null, 0)));
      Logic.SYM_LOGIC_DEPTH_CUTOFFSp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEPTH-CUTOFFS?", null, 0)));
      Logic.SYM_LOGIC_NEGATED_QUERY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NEGATED-QUERY", null, 0)));
      Logic.SYM_LOGIC_LATEST_PARTIAL_SCORE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LATEST-PARTIAL-SCORE", null, 0)));
      Logic.SYM_LOGIC_AUXILIARY_QUERY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("AUXILIARY-QUERY", null, 0)));
      Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LATEST-POSITIVE-SCORE", null, 0)));
      Logic.SYM_LOGIC_GOAL_BINDINGS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("GOAL-BINDINGS", null, 0)));
      Logic.SGT_LOGIC_CONTROL_FRAME = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTROL-FRAME", null, 1)));
      Logic.SYM_LOGIC_REVERSE_POLARITYp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("REVERSE-POLARITY?", null, 0)));
      Logic.SYM_LOGIC_PATTERN_RECORD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PATTERN-RECORD", null, 0)));
      Logic.SYM_LOGIC_INHERITED_PATTERN_RECORD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INHERITED-PATTERN-RECORD", null, 0)));
      Logic.SYM_LOGIC_CHOICE_POINT_UNBINDING_OFFSET = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CHOICE-POINT-UNBINDING-OFFSET", null, 0)));
      Logic.SYM_LOGIC_CURRENT_STRATEGY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CURRENT-STRATEGY", null, 0)));
      Logic.SYM_LOGIC_NEXT_STRATEGIES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NEXT-STRATEGIES", null, 0)));
      Logic.SYM_LOGIC_JUSTIFICATIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JUSTIFICATIONS", null, 0)));
      Logic.SYM_LOGIC_CACHED_GOAL_RESULTp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CACHED-GOAL-RESULT?", null, 0)));
      Logic.SYM_LOGIC_DONT_CACHE_GOAL_FAILUREp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DONT-CACHE-GOAL-FAILURE?", null, 0)));
      Logic.SGT_LOGIC_PARALLEL_THREAD = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PARALLEL-THREAD", null, 1)));
      Logic.SYM_LOGIC_TOP_CONTROL_FRAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TOP-CONTROL-FRAME", null, 0)));
      Logic.SYM_LOGIC_HYPOTHETICAL_WORLD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("HYPOTHETICAL-WORLD", null, 0)));
      Logic.SYM_LOGIC_VARIABLE_BINDINGS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-BINDINGS", null, 0)));
    }
  }

  static void helpStartupQuery2() {
    {
      Logic.SYM_LOGIC_UNBINDING_STACK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UNBINDING-STACK", null, 0)));
      Logic.SYM_LOGIC_TOP_UNBINDING_STACK_OFFSET = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TOP-UNBINDING-STACK-OFFSET", null, 0)));
      Logic.SYM_LOGIC_PRIORITY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PRIORITY", null, 0)));
      Logic.SYM_LOGIC_STATUS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STATUS", null, 0)));
      Logic.SGT_LOGIC_PARALLEL_CONTROL_FRAME = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PARALLEL-CONTROL-FRAME", null, 1)));
      Logic.SYM_LOGIC_CHILD_THREADS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CHILD-THREADS", null, 0)));
      Logic.SYM_LOGIC_UNBOUND_VARIABLESp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UNBOUND-VARIABLES?", null, 0)));
      Logic.SYM_LOGIC_CURRENT_CHILD_THREAD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CURRENT-CHILD-THREAD", null, 0)));
      Logic.SYM_LOGIC_SAVED_PARENT_CONTEXT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SAVED-PARENT-CONTEXT", null, 0)));
      Logic.SYM_LOGIC_SAVED_PARENT_PARALLEL_THREAD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SAVED-PARENT-PARALLEL-THREAD", null, 0)));
      Logic.SGT_LOGIC_CONTROL_FRAME_PRIORITY_QUEUE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTROL-FRAME-PRIORITY-QUEUE", null, 1)));
      Logic.SYM_LOGIC_QUEUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("QUEUE", null, 0)));
      Logic.KWD_UPCLASSIFY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("UPCLASSIFY", null, 2)));
      Logic.KWD_DOWNCLASSIFY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DOWNCLASSIFY", null, 2)));
      Logic.KWD_PARTIAL_MATCH = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PARTIAL-MATCH", null, 2)));
      Logic.SGT_LOGIC_PROOF_ADJUNCT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PROOF-ADJUNCT", null, 1)));
      Logic.SGT_LOGIC_PATTERN_RECORD = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PATTERN-RECORD", null, 1)));
      Logic.SYM_LOGIC_CONTROL_FRAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTROL-FRAME", null, 0)));
      Logic.SYM_LOGIC_EXTERNAL_ARGUMENTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EXTERNAL-ARGUMENTS", null, 0)));
      Logic.SYM_STELLA_BOOLEAN_VECTOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BOOLEAN-VECTOR", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_OPTIMAL_PATTERN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OPTIMAL-PATTERN", null, 0)));
      Logic.SYM_LOGIC_COLLECTION_LIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COLLECTION-LIST", null, 0)));
      Logic.SGT_LOGIC_BOOLEAN_VECTOR_INDEX_NODE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("BOOLEAN-VECTOR-INDEX-NODE", null, 1)));
      Logic.SYM_LOGIC_TRUE_LINK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TRUE-LINK", null, 0)));
      Logic.SYM_LOGIC_FALSE_LINK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FALSE-LINK", null, 0)));
      Logic.SYM_LOGIC_THE_VECTOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("THE-VECTOR", null, 0)));
      Logic.KWD_CONTAINED_BY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTAINED-BY", null, 2)));
      Logic.KWD_PARENT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PARENT", null, 2)));
      Logic.SYM_LOGIC_CACHED_BINDINGS_ITERATOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CACHED-BINDINGS-ITERATOR", null, 0)));
      Logic.KWD_POPPED = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("POPPED", null, 2)));
      Logic.KWD_LOCAL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LOCAL", null, 2)));
      Logic.KWD_QUERY_STACKS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY-STACKS", null, 2)));
      Logic.KWD_NONE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NONE", null, 2)));
      Logic.KWD_SHALLOW_DISJOINT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SHALLOW-DISJOINT", null, 2)));
      Logic.KWD_DISJOINT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DISJOINT", null, 2)));
      Logic.KWD_FLAT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FLAT", null, 2)));
      Logic.KWD_ATOMIC_GOAL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ATOMIC-GOAL", null, 2)));
      Logic.KWD_ITERATIVE_FORALL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ITERATIVE-FORALL", null, 2)));
      Logic.KWD_STATE_MACHINE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("STATE-MACHINE", null, 2)));
      Logic.KWD_PARALLEL_STRATEGIES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PARALLEL-STRATEGIES", null, 2)));
      Logic.KWD_STRATEGY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("STRATEGY", null, 2)));
      Logic.KWD_SPECIALIST = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SPECIALIST", null, 2)));
      Logic.SYM_LOGIC_ANTECEDENTS_RULE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ANTECEDENTS-RULE", null, 0)));
      Logic.KWD_FULL_SUBQUERY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FULL-SUBQUERY", null, 2)));
      Logic.KWD_ANTECEDENTS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ANTECEDENTS", null, 2)));
      Logic.SYM_STELLA_ITERATOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ITERATOR", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.KWD_FAILURE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FAILURE", null, 2)));
      Logic.KWD_FINAL_SUCCESS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FINAL-SUCCESS", null, 2)));
      Logic.SGT_LOGIC_NN_PARTIAL_MATCH = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("NN-PARTIAL-MATCH", null, 1)));
      Logic.SYM_LOGIC_MATCH_SCORE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MATCH-SCORE", null, 0)));
      Logic.SYM_LOGIC_BACK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BACK", null, 0)));
      Logic.SYM_LOGIC_GOAL_CACHE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("GOAL-CACHE", null, 0)));
      Logic.SYM_LOGIC_DEBUG_FRAME_ID_INTERNAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEBUG-FRAME-ID-INTERNAL", null, 0)));
      Logic.KWD_MOVE_DOWN = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MOVE-DOWN", null, 2)));
      Logic.KWD_CONTINUING_SUCCESS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTINUING-SUCCESS", null, 2)));
      Logic.KWD_MOVE_IN_PLACE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MOVE-IN-PLACE", null, 2)));
      Logic.KWD_TIMEOUT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEOUT", null, 2)));
      Logic.KWD_SCAN_CACHED_BINDINGS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SCAN-CACHED-BINDINGS", null, 2)));
      Logic.KWD_CLUSTERED_CONJUNCTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CLUSTERED-CONJUNCTION", null, 2)));
      Logic.KWD_DISJUNCTIVE_IMPLICATION_INTRODUCTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DISJUNCTIVE-IMPLICATION-INTRODUCTION", null, 2)));
    }
  }

  static void helpStartupQuery3() {
    {
      Logic.KWD_DUPLICATE_GOALS_WITH_CACHING = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DUPLICATE-GOALS-WITH-CACHING", null, 2)));
      Logic.KWD_MANUFACTURE_SKOLEM = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MANUFACTURE-SKOLEM", null, 2)));
      Logic.SYM_LOGIC_CACHED_SINGLE_VALUEDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CACHED-SINGLE-VALUED?", null, 0)));
      Logic.KWD_FAILED_OVERLAY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FAILED-OVERLAY", null, 2)));
      Logic.SGT_PL_KERNEL_KB_PARTITION_MEMBERSHIP = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PARTITION-MEMBERSHIP", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_DISJOINT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DISJOINT", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SYM_LOGIC_pD1 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?D1", null, 0)));
      Logic.SYM_LOGIC_pD2 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?D2", null, 0)));
      Logic.SYM_LOGIC_DISJOINT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DISJOINT", null, 0)));
      Logic.SYM_LOGIC_F_DISJOINT_TERMSp_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("F-DISJOINT-TERMS?-QUERY-000", null, 0)));
      Logic.SGT_LOGIC_F_DISJOINT_TERMSp_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-DISJOINT-TERMS?-MEMO-TABLE-000", null, 1)));
      Logic.SYM_LOGIC_F_DISJOINT_TERMSp_QUERY_001 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("F-DISJOINT-TERMS?-QUERY-001", null, 0)));
      Logic.SYM_PL_KERNEL_KB_CLASS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS", Stella.getStellaModule("/PL-KERNEL-KB", true), 0)));
      Logic.SYM_LOGIC_REFUTATION_DISJOINT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("REFUTATION-DISJOINT", null, 0)));
      Logic.SYM_LOGIC_F_EXPENSIVE_DISJOINT_TERMSp_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("F-EXPENSIVE-DISJOINT-TERMS?-QUERY-000", null, 0)));
      Logic.SGT_PL_KERNEL_KB_COLLECTIONOF = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("COLLECTIONOF", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_LOGIC_DESCRIPTION_EXTENSION_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DESCRIPTION-EXTENSION-ITERATOR", null, 1)));
      Logic.SYM_LOGIC_ROOT_DESCRIPTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ROOT-DESCRIPTION", null, 0)));
      Logic.SYM_LOGIC_SUBCOLLECTIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SUBCOLLECTIONS", null, 0)));
      Logic.SYM_LOGIC_EXTENSION_ITERATOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EXTENSION-ITERATOR", null, 0)));
      Logic.SYM_LOGIC_REFERENCE_PROPOSITION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("REFERENCE-PROPOSITION", null, 0)));
      Logic.SYM_LOGIC_ALREADY_GENERATED_LIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ALREADY-GENERATED-LIST", null, 0)));
      Logic.SYM_LOGIC_ALREADY_GENERATED_TABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ALREADY-GENERATED-TABLE", null, 0)));
      Logic.SYM_LOGIC_REMOVING_DUPLICATESp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("REMOVING-DUPLICATES?", null, 0)));
      Logic.KWD_GOAL_CACHES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("GOAL-CACHES", null, 2)));
      Logic.KWD_GOAL_CUTOFFS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("GOAL-CUTOFFS", null, 2)));
      Logic.KWD_DEPTH_VIOLATION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DEPTH-VIOLATION", null, 2)));
      Logic.KWD_DEPTH_CUTOFF = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DEPTH-CUTOFF", null, 2)));
      Logic.KWD_TECHNICAL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TECHNICAL", null, 2)));
      Logic.KWD_LAY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LAY", null, 2)));
      Logic.SGT_LOGIC_QUERY_SOLUTION_TABLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY-SOLUTION-TABLE", null, 1)));
      Logic.SYM_STELLA_THE_MAP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("THE-MAP", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_FIRST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FIRST", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_LAST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LAST", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SGT_LOGIC_QUERY_SOLUTION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY-SOLUTION", null, 1)));
      Logic.SYM_LOGIC_BINDINGS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BINDINGS", null, 0)));
      Logic.SYM_LOGIC_BEST_JUSTIFICATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BEST-JUSTIFICATION", null, 0)));
      Logic.SYM_LOGIC_ALL_JUSTIFICATIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ALL-JUSTIFICATIONS", null, 0)));
      Logic.SYM_STELLA_NEXT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NEXT", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SGT_LOGIC_QUERY_SOLUTION_TABLE_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY-SOLUTION-TABLE-ITERATOR", null, 1)));
      Logic.SYM_STELLA_THE_TABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("THE-TABLE", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_CURSOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CURSOR", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_DEBUG_ID = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEBUG-ID", null, 0)));
      Logic.KWD_FORMAT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FORMAT", null, 2)));
      Logic.KWD_OUTPUT_FILE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("OUTPUT-FILE", null, 2)));
      Logic.KWD_IF_EXISTS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("IF-EXISTS", null, 2)));
      Logic.KWD_SUPERSEDE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SUPERSEDE", null, 2)));
      Logic.KWD_APPEND = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("APPEND", null, 2)));
      Logic.KWD_VERTICAL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("VERTICAL", null, 2)));
      Logic.KWD_LIST = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LIST", null, 2)));
      Logic.KWD_TSV = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TSV", null, 2)));
      Logic.KWD_HORIZONTAL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("HORIZONTAL", null, 2)));
      Logic.KWD_TRACE_SOLUTIONS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TRACE-SOLUTIONS", null, 2)));
      Logic.SYM_LOGIC_ATOMIC_SINGLETONSp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ATOMIC-SINGLETONS?", null, 0)));
      Logic.SYM_PL_KERNEL_KB_pMATCH_SCORE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?MATCH-SCORE", Stella.getStellaModule("/PL-KERNEL-KB", true), 0)));
      Logic.KWD_DONT_OPTIMIZEp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DONT-OPTIMIZE?", null, 2)));
      Logic.SYM_LOGIC_INITIAL_BINDINGS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INITIAL-BINDINGS", null, 0)));
      Logic.KWD_ITERATIVE_DEEPENINGp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ITERATIVE-DEEPENING?", null, 2)));
      Logic.SYM_LOGIC_ITERATIVE_DEEPENINGp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ITERATIVE-DEEPENING?", null, 0)));
      Logic.KWD_MATCH_MODE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MATCH-MODE", null, 2)));
    }
  }

  static void helpStartupQuery4() {
    {
      Logic.KWD_DEFERRED_OPTIONS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFERRED-OPTIONS", null, 2)));
      Logic.KWD_FOUR_VALUEDp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FOUR-VALUED?", null, 2)));
      Logic.KWD_HOW_MANY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("HOW-MANY", null, 2)));
      Logic.KWD_SORT_BY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SORT-BY", null, 2)));
      Logic.KWD_SCORE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SCORE", null, 2)));
      Logic.KWD_CHECK_VARIABLESp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CHECK-VARIABLES?", null, 2)));
      Logic.KWD_MOVEOUT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MOVEOUT", null, 2)));
      Logic.KWD_MAXIMUM_DEPTH = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MAXIMUM-DEPTH", null, 2)));
      Logic.KWD_THREE_VALUEDp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("THREE-VALUED?", null, 2)));
      Logic.KWD_ATOMIC_SINGLETONSp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ATOMIC-SINGLETONS?", null, 2)));
      Logic.KWD_ALL_PROOFSp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ALL-PROOFS?", null, 2)));
      Logic.KWD_VALUES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("VALUES", null, 2)));
      Logic.KWD_VALUES_DESCENDING = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("VALUES-DESCENDING", null, 2)));
      Logic.KWD_VALUES_ASCENDING = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("VALUES-ASCENDING", null, 2)));
      Logic.KWD_READABLE_VALUESp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("READABLE-VALUES?", null, 2)));
      Logic.KWD_MINIMUM_SCORE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MINIMUM-SCORE", null, 2)));
      Logic.KWD_MAXIMIZE_SCOREp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MAXIMIZE-SCORE?", null, 2)));
      Logic.KWD_MAXIMUM_UNKNOWNS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MAXIMUM-UNKNOWNS", null, 2)));
      Logic.SGT_STELLA_PROPERTY_LIST = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PROPERTY-LIST", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.KWD_HIGH = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("HIGH", null, 2)));
      Logic.KWD_DYNAMIC = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DYNAMIC", null, 2)));
      Logic.KWD_DYNAMIC_WITH_CLUSTERING = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DYNAMIC-WITH-CLUSTERING", null, 2)));
      Logic.SGT_PL_KERNEL_KB_CONCEPT_PROTOTYPE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONCEPT-PROTOTYPE", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SYM_LOGIC_pC = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?C", null, 0)));
      Logic.SYM_LOGIC_pP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?P", null, 0)));
      Logic.SYM_PL_KERNEL_KB_CONCEPT_PROTOTYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CONCEPT-PROTOTYPE", Stella.getStellaModule("/PL-KERNEL-KB", true), 0)));
      Logic.SYM_LOGIC_F_GET_PROTOTYPE_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("F-GET-PROTOTYPE-QUERY-000", null, 0)));
      Logic.SGT_STELLA_VECTOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("VECTOR", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.KWD_UPDATE_FROM_QUERY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("UPDATE-FROM-QUERY", null, 2)));
      Logic.KWD_ASSERT_FROM_QUERY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ASSERT-FROM-QUERY", null, 2)));
      Logic.KWD_RECORD_JUSTIFICATIONSp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("RECORD-JUSTIFICATIONS?", null, 2)));
      Logic.SYM_LOGIC_STARTUP_QUERY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-QUERY", null, 0)));
    }
  }

  static void helpStartupQuery5() {
    {
      { NormalInferenceLevel self031 = NormalInferenceLevel.newNormalInferenceLevel();

        self031.keyword = Logic.KWD_NORMAL;
        Logic.NORMAL_INFERENCE = self031;
      }
      { BacktrackingInferenceLevel self032 = BacktrackingInferenceLevel.newBacktrackingInferenceLevel();

        self032.keyword = Logic.KWD_BACKTRACKING;
        Logic.BACKTRACKING_INFERENCE = self032;
      }
      { SubsumptionInferenceLevel self033 = SubsumptionInferenceLevel.newSubsumptionInferenceLevel();

        self033.keyword = Logic.KWD_SUBSUMPTION;
        Logic.SUBSUMPTION_INFERENCE = self033;
      }
      { ShallowInferenceLevel self034 = ShallowInferenceLevel.newShallowInferenceLevel();

        self034.keyword = Logic.KWD_SHALLOW;
        Logic.SHALLOW_INFERENCE = self034;
      }
      { AssertionInferenceLevel self035 = AssertionInferenceLevel.newAssertionInferenceLevel();

        self035.keyword = Logic.KWD_ASSERTION;
        Logic.ASSERTION_INFERENCE = self035;
      }
      { RefutationInferenceLevel self036 = RefutationInferenceLevel.newRefutationInferenceLevel();

        self036.keyword = Logic.KWD_REFUTATION;
        Logic.REFUTATION_INFERENCE = self036;
      }
      Logic.$INFERENCELEVEL$.setDefaultValue(Logic.NORMAL_INFERENCE);
      Logic.$DONTUSEDEFAULTKNOWLEDGEp$.setDefaultValue(new Boolean(false));
      Logic.$MAXIMUM_BACKTRACKING_DEPTH$ = Logic.$DEFAULT_MAXIMUM_DEPTH$;
      Logic.$TYPE_CHECK_STRATEGY$.setDefaultValue(Logic.KWD_LOOKUP);
      Logic.$DUPLICATE_SUBGOAL_STRATEGY$ = Logic.KWD_DUPLICATE_GOALS;
      Logic.$DUPLICATE_GOAL_SEARCH_DEPTH$ = Stella.NULL_INTEGER;
      Logic.$DUPLICATE_RULE_SEARCH_DEPTH$ = Stella.NULL_INTEGER;
      Logic.$GENERATE_ALL_PROOFSp$.setDefaultValue(new Boolean(false));
      Logic.$QUERYITERATOR$.setDefaultValue(null);
      { PropertyList self037 = PropertyList.newPropertyList();

        self037.thePlist = Cons.list$(Cons.cons(Logic.KWD_UPCLASSIFY, Cons.cons(CharacterWrapper.wrapCharacter('u'), Cons.cons(Cons.list$(Cons.cons(Logic.KWD_DOWNCLASSIFY, Cons.cons(CharacterWrapper.wrapCharacter('d'), Cons.cons(Cons.list$(Cons.cons(Logic.KWD_PROPAGATE, Cons.cons(CharacterWrapper.wrapCharacter('f'), Cons.cons(Cons.list$(Cons.cons(Logic.KWD_PARTIAL_MATCH, Cons.cons(CharacterWrapper.wrapCharacter('p'), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Stella.NIL)))), Stella.NIL))));
        Logic.$THINKING_DOT_TABLE$ = self037;
      }
      { BooleanVectorIndexNode self038 = BooleanVectorIndexNode.newBooleanVectorIndexNode();

        self038.theVector = BooleanVector.newBooleanVector(0);
        Logic.$BOOLEAN_VECTOR_INDEX$ = self038;
      }
      Logic.$PRINTINFRAME$.setDefaultValue(null);
      Logic.$TRACED_GOALS$ = HashSet.newHashSet();
      Logic.$REVERSEPOLARITYp$.setDefaultValue(new Boolean(false));
      Logic.$INLINE_QUERY_CACHE$ = KeyValueMap.newKeyValueMap();
    }
  }

  static void helpStartupQuery6() {
    {
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("INFERENCE-LEVEL", "(DEFCLASS INFERENCE-LEVEL (STANDARD-OBJECT) :SLOTS ((KEYWORD :TYPE KEYWORD)) :DOCUMENTATION \"This class hierarchy is used to choose the\nlevel of inference applied when dispatching queries (canned\nor ad hoc).\")");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.InferenceLevel", "newInferenceLevel", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.InferenceLevel", "accessInferenceLevelSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.InferenceLevel"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("NORMAL-INFERENCE-LEVEL", "(DEFCLASS NORMAL-INFERENCE-LEVEL (INFERENCE-LEVEL) :DOCUMENTATION \"The normal inference level employs all proof strategies\nexcept disjunctive implication introduction and refutation.\")");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.NormalInferenceLevel", "newNormalInferenceLevel", new java.lang.Class [] {});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("BACKTRACKING-INFERENCE-LEVEL", "(DEFCLASS BACKTRACKING-INFERENCE-LEVEL (NORMAL-INFERENCE-LEVEL) :DOCUMENTATION \"Specifies subsumption level inference plus backtracking.\")");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.BacktrackingInferenceLevel", "newBacktrackingInferenceLevel", new java.lang.Class [] {});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("SUBSUMPTION-INFERENCE-LEVEL", "(DEFCLASS SUBSUMPTION-INFERENCE-LEVEL (BACKTRACKING-INFERENCE-LEVEL) :DOCUMENTATION \"Specifies lookup augmented with cached\nsubsumption links and equality reasoning.\")");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.SubsumptionInferenceLevel", "newSubsumptionInferenceLevel", new java.lang.Class [] {});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("SHALLOW-INFERENCE-LEVEL", "(DEFCLASS SHALLOW-INFERENCE-LEVEL (SUBSUMPTION-INFERENCE-LEVEL) :DOCUMENTATION \"Specifies lookup of assertions plus simple frame computations.\")");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ShallowInferenceLevel", "newShallowInferenceLevel", new java.lang.Class [] {});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("ASSERTION-INFERENCE-LEVEL", "(DEFCLASS ASSERTION-INFERENCE-LEVEL (SUBSUMPTION-INFERENCE-LEVEL) :DOCUMENTATION \"Specifies lookup of assertions only.\")");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.AssertionInferenceLevel", "newAssertionInferenceLevel", new java.lang.Class [] {});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("REFUTATION-INFERENCE-LEVEL", "(DEFCLASS REFUTATION-INFERENCE-LEVEL (NORMAL-INFERENCE-LEVEL) :DOCUMENTATION \"Normal inference augmented by refutation proof strategy.\")");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.RefutationInferenceLevel", "newRefutationInferenceLevel", new java.lang.Class [] {});
      }
      Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE COST-ESTIMATE FLOAT \"Type used by the query optimizer to compute estimates of the cost of\nexecuting a query.\")");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("QUERY-ITERATOR", "(DEFCLASS QUERY-ITERATOR (ITERATOR DYNAMIC-SLOTS-MIXIN) :PUBLIC? TRUE :DOCUMENTATION \"A query iterator points to a query environment\nrepresenting the initial or intermediate state of a query.  The iterator's\n'value' is a vector representing a satisfying set bindings of the query's\noutput variables.  Each call to the iterator writes a new set of bindings\ninto the vector.\" :PARAMETERS ((ANY-VALUE :TYPE QUERY-SOLUTION)) :PUBLIC-SLOTS ((EXTERNAL-VARIABLES :TYPE VARIABLES-VECTOR) (INITIAL-BINDINGS :TYPE ARGUMENTS-VECTOR :ALLOCATION :DYNAMIC :DOCUMENTATION \"Supports cached queries; conceivably, this could be static.\") (EXHAUSTED? :TYPE BOOLEAN) (AUXILIARY-QUERY :TYPE QUERY-ITERATOR :ALLOCATION :DYNAMIC) (NEGATED-QUERY :RENAMES AUXILIARY-QUERY) (OPTIONS :TYPE PROPERTY-LIST :INITIALLY (NEW PROPERTY-LIST)) (SOLUTIONS :TYPE QUERY-SOLUTION-TABLE :INITIALLY (NEW QUERY-SOLUTION-TABLE) :DOCUMENTATION \"Each element holds a solution record with a\nvector of bindings of the free external variables of the query plus all\nthe appropriate truth-value and justification support.\") (ATOMIC-SINGLETONS? :TYPE BOOLEAN :ALLOCATION :DYNAMIC :DOCUMENTATION \"If TRUE, then singleton result tuples are\nconsified (and printed) as atoms instead of singleton lists.\") (QUERY-CONTEXT :TYPE CONTEXT) (BASE-CONTROL-FRAME :TYPE CONTROL-FRAME) (CURRENT-CONTROL-FRAME :TYPE CONTROL-FRAME) (CURRENT-PATTERN-RECORD :TYPE PATTERN-RECORD) (CURRENT-PARALLEL-THREAD :TYPE PARALLEL-THREAD) (CONTROL-FRAME-PRIORITY-QUEUE :TYPE CONTROL-FRAME-PRIORITY-QUEUE) (AUGMENTED-GOAL-CACHE? :TYPE BOOLEAN) (ACTIVE-GOAL-CACHES :TYPE (LIST OF GOAL-CACHE) :ALLOCATION :EMBEDDED) (TRIGGERED-DEPTH-CUTOFF? :TYPE BOOLEAN) (FAILED-TO-FIND-DUPLICATE-SUBGOAL? :TYPE BOOLEAN) (FOUND-AT-LEAST-ONE-SOLUTION? :TYPE BOOLEAN) (TIMESTAMP :TYPE TIMESTAMP) (PARTIAL-MATCH-STRATEGY :TYPE PARTIAL-MATCH-FRAME) (LATEST-POSITIVE-SCORE :TYPE PARTIAL-MATCH-SCORE :ALLOCATION :DYNAMIC) (LATEST-PARTIAL-SCORE :TYPE PARTIAL-MATCH-SCORE :RENAMES LATEST-POSITIVE-SCORE) (OPTIMIZER-GOAL-RECORDS :TYPE (EXTENSIBLE-VECTOR OF GOAL-RECORD) :ALLOCATION :DYNAMIC) (RESIDUE-GOALS :TYPE (LIST OF PROPOSITION) :ALLOCATION :DYNAMIC) (BEST-GOAL-SEQUENCE :TYPE (LIST OF PROPOSITION) :ALLOCATION :DYNAMIC) (BEST-COST :TYPE COST-ESTIMATE :ALLOCATION :DYNAMIC) (INFERENCE-LEVEL :TYPE INFERENCE-LEVEL) (ITERATIVE-DEEPENING? :TYPE BOOLEAN :ALLOCATION :DYNAMIC) (CURRENT-DEPTH-CUTOFF :TYPE INTEGER) (MAXIMUM-DEPTH :TYPE INTEGER) (ALLOTTED-TIME :TYPE FLOAT :DOCUMENTATION \"If defined, timeout after that many seconds.\") (ALLOTTED-CLOCK-TICKS :TYPE INTEGER :DOCUMENTATION \"If defined, timeout after that many :DOWN moves.\") (CURRENT-CLOCK-TICKS :TYPE INTEGER :INITIALLY 0) (TIMEOUT? :TYPE BOOLEAN :DOCUMENTATION \"Set to TRUE if query times out.\") (DEPTH-CUTOFFS? :TYPE BOOLEAN :DOCUMENTATION \"Set to TRUE if one or more depth cutoffs occurred.\")) :PRINT-FORM (PRINT-QUERY-ITERATOR SELF STREAM))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "newQueryIterator", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "accessQueryIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE GOAL-BINDINGS (CONS OF OBJECT))");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CONTROL-FRAME", "(DEFCLASS CONTROL-FRAME (STANDARD-OBJECT DYNAMIC-SLOTS-MIXIN) :PUBLIC? TRUE :PUBLIC-SLOTS ((STATE :TYPE KEYWORD) (PROPOSITION :TYPE PROPOSITION) (DESCRIPTION :TYPE DESCRIPTION :ALLOCATION :DYNAMIC) (TRUTH-VALUE :TYPE TRUTH-VALUE) (REVERSE-POLARITY? :TYPE BOOLEAN) (STARTING-CLOCK-TICKS :TYPE INTEGER :DOCUMENTATION \"Clock ticks at last :DOWN move.\") (ALLOTTED-CLOCK-TICKS :TYPE INTEGER :DOCUMENTATION \"Total clock ticks allotted to prove this goal.\") (UP :TYPE CONTROL-FRAME) (DOWN :TYPE CONTROL-FRAME) (BACK :TYPE CONTROL-FRAME :ALLOCATION :DYNAMIC) (RESULT :TYPE CONTROL-FRAME) (ARGUMENTS :TYPE (VECTOR OF CONTROL-FRAME) :ALLOCATION :DYNAMIC) (ARGUMENT-CURSOR :TYPE INTEGER :INITIALLY 0) (PATTERN-RECORD :TYPE PATTERN-RECORD) (INHERITED-PATTERN-RECORD :TYPE PATTERN-RECORD) (CHOICE-POINT-UNBINDING-OFFSET :TYPE INTEGER) (CURRENT-STRATEGY :TYPE KEYWORD) (NEXT-STRATEGIES :TYPE (CONS OF KEYWORD) :INITIALLY NIL) (ITERATOR :TYPE ITERATOR :ALLOCATION :DYNAMIC) (ANTECEDENTS-RULE :TYPE PROPOSITION :ALLOCATION :DYNAMIC) (PROOF-ADJUNCT :TYPE PROOF-ADJUNCT :ALLOCATION :DYNAMIC) (PARTIAL-MATCH-FRAME :TYPE PARTIAL-MATCH-FRAME) (JUSTIFICATIONS :TYPE LIST :ALLOCATION :EMBEDDED) (JUSTIFICATION :TYPE JUSTIFICATION :ALLOCATION :DYNAMIC) (CACHED-SINGLE-VALUED? :TYPE BOOLEAN :ALLOCATION :DYNAMIC) (GOAL-BINDINGS :TYPE GOAL-BINDINGS) (CACHED-GOAL-RESULT? :TYPE BOOLEAN) (DONT-CACHE-GOAL-FAILURE? :TYPE BOOLEAN) (GOAL-CACHE :TYPE GOAL-CACHE :ALLOCATION :DYNAMIC) (CACHED-BINDINGS-ITERATOR :TYPE (ITERATOR OF GOAL-BINDINGS) :ALLOCATION :DYNAMIC)) :PUBLIC-METHODS ((HOLDS-BY-DEFAULT? ((SELF CONTROL-FRAME)) :TYPE BOOLEAN :GLOBALLY-INLINE? TRUE (RETURN (DEFAULT-TRUTH-VALUE? (TRUTH-VALUE SELF))))) :PRINT-FORM (PRINT-CONTROL-FRAME SELF STREAM))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "newControlFrame", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "accessControlFrameSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("PARALLEL-THREAD", "(DEFCLASS PARALLEL-THREAD (STANDARD-OBJECT) :SLOTS ((TOP-CONTROL-FRAME :TYPE CONTROL-FRAME) (HYPOTHETICAL-WORLD :TYPE WORLD) (VARIABLE-BINDINGS :TYPE (VECTOR OF OBJECT)) (UNBINDING-STACK :TYPE INTEGER-VECTOR) (TOP-UNBINDING-STACK-OFFSET :TYPE INTEGER) (PRIORITY :TYPE INTEGER) (STATUS :TYPE KEYWORD)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ParallelThread", "newParallelThread", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.ParallelThread", "accessParallelThreadSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ParallelThread"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("PARALLEL-CONTROL-FRAME", "(DEFCLASS PARALLEL-CONTROL-FRAME (CONTROL-FRAME) :SLOTS ((CHILD-THREADS :TYPE (LIST OF PARALLEL-THREAD) :ALLOCATION :EMBEDDED) (UNBOUND-VARIABLES? :TYPE BOOLEAN) (CURRENT-CHILD-THREAD :TYPE PARALLEL-THREAD) (SAVED-PARENT-CONTEXT :TYPE CONTEXT) (SAVED-PARENT-PARALLEL-THREAD :TYPE PARALLEL-THREAD)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ParallelControlFrame", "newParallelControlFrame", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.ParallelControlFrame", "accessParallelControlFrameSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ParallelControlFrame"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CONTROL-FRAME-PRIORITY-QUEUE", "(DEFCLASS CONTROL-FRAME-PRIORITY-QUEUE (STANDARD-OBJECT) :SLOTS ((QUEUE :TYPE (LIST OF PARALLEL-CONTROL-FRAME))))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ControlFramePriorityQueue", "newControlFramePriorityQueue", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.ControlFramePriorityQueue", "accessControlFramePriorityQueueSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFramePriorityQueue"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("PROOF-ADJUNCT", "(DEFCLASS PROOF-ADJUNCT (STANDARD-OBJECT) :DOCUMENTATION \"Subclasses of 'PROOF-ADJUNCT' provide for specialized\nslots (specialized for a particular strategy) to hold a record of\nan ongoing proof thread.\")");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ProofAdjunct", "newProofAdjunct", new java.lang.Class [] {});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("PATTERN-RECORD", "(DEFCLASS PATTERN-RECORD (STANDARD-OBJECT) :DOCUMENTATION \"A pattern record records bookkeeping data used during\nthe processing of a description.\" :SLOTS ((CONTROL-FRAME :TYPE CONTROL-FRAME) (VARIABLE-BINDINGS :TYPE (VECTOR OF OBJECT)) (UNBINDING-STACK :TYPE INTEGER-VECTOR) (TOP-UNBINDING-STACK-OFFSET :TYPE INTEGER) (DESCRIPTION :TYPE DESCRIPTION) (EXTERNAL-ARGUMENTS :TYPE ARGUMENTS-VECTOR) (BOOLEAN-VECTOR :TYPE BOOLEAN-VECTOR) (OPTIMAL-PATTERN :TYPE DESCRIPTION) (COLLECTION-LIST :TYPE LIST)) :TERMINATOR TERMINATE-PATTERN-RECORD?)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.PatternRecord", "newPatternRecord", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.PatternRecord", "accessPatternRecordSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternRecord"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("BOOLEAN-VECTOR-INDEX-NODE", "(DEFCLASS BOOLEAN-VECTOR-INDEX-NODE (STANDARD-OBJECT) :SLOTS ((TRUE-LINK :TYPE BOOLEAN-VECTOR-INDEX-NODE) (FALSE-LINK :TYPE BOOLEAN-VECTOR-INDEX-NODE) (THE-VECTOR :TYPE BOOLEAN-VECTOR)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.BooleanVectorIndexNode", "newBooleanVectorIndexNode", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.BooleanVectorIndexNode", "accessBooleanVectorIndexNodeSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.BooleanVectorIndexNode"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("DESCRIPTION-EXTENSION-ITERATOR", "(DEFCLASS DESCRIPTION-EXTENSION-ITERATOR (ITERATOR) :DOCUMENTATION \"Iterates over the extension of a description and\nits subdescriptions, returning those propositions that are currently true.\" :PARAMETERS ((ANY-VALUE :TYPE PROPOSITION)) :SLOTS ((ROOT-DESCRIPTION :TYPE NAMED-DESCRIPTION) (SUBCOLLECTIONS :TYPE (CONS OF CONS) :INITIALLY NULL) (EXTENSION-ITERATOR :TYPE (ITERATOR OF PROPOSITION)) (REFERENCE-PROPOSITION :TYPE PROPOSITION) (ALREADY-GENERATED-LIST :TYPE LIST :INITIALLY (NEW LIST)) (ALREADY-GENERATED-TABLE :TYPE HASH-TABLE) (REMOVING-DUPLICATES? :TYPE BOOLEAN) (TRUTH-VALUE :TYPE TRUTH-VALUE)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.DescriptionExtensionIterator", "newDescriptionExtensionIterator", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.DescriptionExtensionIterator", "accessDescriptionExtensionIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.DescriptionExtensionIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("QUERY-SOLUTION-TABLE", "(DEFCLASS QUERY-SOLUTION-TABLE (DICTIONARY) :DOCUMENTATION \"Special key/value map for query solutions indexed by output\nvariable binding vectors that also preserves the order of solution generation.\" :PARAMETERS ((ANY-KEY :TYPE ARGUMENTS-VECTOR) (ANY-VALUE :TYPE QUERY-SOLUTION)) :SLOTS ((THE-MAP :TYPE (KEY-VALUE-MAP OF (LIKE (ANY-KEY SELF)) (LIKE (ANY-VALUE SELF))) :INITIALLY (NEW KEY-VALUE-MAP :EQUAL-TEST? TRUE)) (QUERY :TYPE QUERY-ITERATOR) (FIRST :TYPE QUERY-SOLUTION) (LAST :TYPE QUERY-SOLUTION)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.QuerySolutionTable", "newQuerySolutionTable", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.QuerySolutionTable", "accessQuerySolutionTableSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QuerySolutionTable"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("QUERY-SOLUTION", "(DEFCLASS QUERY-SOLUTION (STANDARD-OBJECT) :SLOTS ((BINDINGS :TYPE ARGUMENTS-VECTOR) (TRUTH-VALUE :TYPE TRUTH-VALUE) (MATCH-SCORE :TYPE PARTIAL-MATCH-SCORE) (JUSTIFICATION :TYPE JUSTIFICATION) (BEST-JUSTIFICATION :TYPE JUSTIFICATION :RENAMES JUSTIFICATION) (ALL-JUSTIFICATIONS :TYPE (LIST OF JUSTIFICATION) :DOCUMENTATION \"All recorded justifications for\nthis solution in case we have multiple ones from a partial match operation.\") (NEXT :TYPE QUERY-SOLUTION)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.QuerySolution", "newQuerySolution", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.QuerySolution", "accessQuerySolutionSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QuerySolution"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("QUERY-SOLUTION-TABLE-ITERATOR", "(DEFCLASS QUERY-SOLUTION-TABLE-ITERATOR (DICTIONARY-ITERATOR) :SLOTS ((THE-TABLE :TYPE QUERY-SOLUTION-TABLE) (CURSOR :TYPE QUERY-SOLUTION)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.QuerySolutionTableIterator", "newQuerySolutionTableIterator", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.QuerySolutionTableIterator", "accessQuerySolutionTableIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QuerySolutionTableIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
    }
  }

  static void helpStartupQuery7() {
    {
      Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT MODULE INFERENCE-LEVEL :TYPE INFERENCE-LEVEL :DOCUMENTATION \"The default inference level used for inferences in a module.\" :ALLOCATION :DYNAMIC)");
      Stella.defineFunctionObject("CURRENT-INFERENCE-LEVEL", "(DEFUN (CURRENT-INFERENCE-LEVEL NORMAL-INFERENCE-LEVEL) () :DOCUMENTATION \"Return the current inference level that is active in the\ncurrent query, the current module, or, otherwise, globally.\" :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "currentInferenceLevel", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("GET-INFERENCE-LEVEL", "(DEFUN (GET-INFERENCE-LEVEL INFERENCE-LEVEL) ((LEVELKEYWORD KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getInferenceLevel", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("SET-INFERENCE-LEVEL", "(DEFUN (SET-INFERENCE-LEVEL KEYWORD) ((LEVEL NAME) (MODULE NAME)) :DOCUMENTATION \"Set the inference level of `module' to the level specified\nby 'levelKeyword'.  If `module' is NULL, set the level globally.\" :COMMAND? TRUE :PUBLIC? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setInferenceLevel", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CALL-SET-INFERENCE-LEVEL", "(DEFUN (CALL-SET-INFERENCE-LEVEL KEYWORD) ((LEVELKEYWORD KEYWORD) (MODULE MODULE)) :DOCUMENTATION \"Set the inference level of `module' to the level specified\nby 'levelKeyword'.  If `module' is NULL and we are inside a query, set the\nlevel of the current query iterator.  Otherwise, set the level globally.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "callSetInferenceLevel", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("USING-DEFAULT-KNOWLEDGE?", "(DEFUN (USING-DEFAULT-KNOWLEDGE? BOOLEAN) () :GLOBALLY-INLINE? TRUE (RETURN (NOT *DONTUSEDEFAULTKNOWLEDGE?*)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "usingDefaultKnowledgeP", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("TRACE-SUBGOALS", "(DEFUN TRACE-SUBGOALS ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "traceSubgoals", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("UNTRACE-SUBGOALS", "(DEFUN UNTRACE-SUBGOALS ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "untraceSubgoals", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("TRACE-RULES", "(DEFUN TRACE-RULES ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "traceRules", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("UNTRACE-RULES", "(DEFUN UNTRACE-RULES ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "untraceRules", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("TOGGLE-TRACE-SUBGOALS", "(DEFUN (TOGGLE-TRACE-SUBGOALS STRING) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "toggleTraceSubgoals", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("TOGGLE-TRACE-RULES", "(DEFUN (TOGGLE-TRACE-RULES STRING) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "toggleTraceRules", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("EMIT-THINKING-DOT", "(DEFUN EMIT-THINKING-DOT ((KINDOFTHINKING KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "emitThinkingDot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("CREATE-BOOLEAN-VECTOR-INDEX-NODE", "(DEFUN (CREATE-BOOLEAN-VECTOR-INDEX-NODE BOOLEAN-VECTOR-INDEX-NODE) ((PARENTNODE BOOLEAN-VECTOR-INDEX-NODE) (LASTVALUE BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.BooleanVectorIndexNode", "createBooleanVectorIndexNode", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.BooleanVectorIndexNode"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ARGUMENTS-VECTOR-TO-BOOLEAN-VECTOR", "(DEFUN (ARGUMENTS-VECTOR-TO-BOOLEAN-VECTOR BOOLEAN-VECTOR) ((ARGUMENTSVECTOR ARGUMENTS-VECTOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "argumentsVectorToBooleanVector", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("ZERO-ONE-LIST-TO-BOOLEAN-VECTOR", "(DEFUN (ZERO-ONE-LIST-TO-BOOLEAN-VECTOR BOOLEAN-VECTOR) ((ZEROONELIST (LIST OF INTEGER-WRAPPER))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "zeroOneListToBooleanVector", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("POP-CONTROL-FRAME", "(DEFUN POP-CONTROL-FRAME ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "popControlFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("POP-FRAMES-UP-TO", "(DEFUN POP-FRAMES-UP-TO ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "popFramesUpTo", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("POP-DOWN-FRAME", "(DEFUN POP-DOWN-FRAME ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "popDownFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("ACTIVATE-PATTERN-RECORD", "(DEFUN ACTIVATE-PATTERN-RECORD ((PATTERNRECORD PATTERN-RECORD) (VARIABLECOUNT INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.PatternRecord", "activatePatternRecord", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternRecord"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("RESET-CURRENT-PATTERN-RECORD", "(DEFUN RESET-CURRENT-PATTERN-RECORD ((FRAME CONTROL-FRAME) (LOCALORPARENT KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "resetCurrentPatternRecord", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("PRINT-ENVIRONMENT-STACKS", "(DEFUN PRINT-ENVIRONMENT-STACKS ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printEnvironmentStacks", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("SET-PATTERN-VARIABLE-BINDING", "(DEFUN SET-PATTERN-VARIABLE-BINDING ((VARIABLE PATTERN-VARIABLE) (VALUE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "setPatternVariableBinding", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CHANGE-PATTERN-VARIABLE-BINDING", "(DEFUN CHANGE-PATTERN-VARIABLE-BINDING ((VARIABLE PATTERN-VARIABLE) (NEWVALUE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "changePatternVariableBinding", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("UNBIND-VARIABLES-BEGINNING-AT", "(DEFUN UNBIND-VARIABLES-BEGINNING-AT ((PATTERNRECORD PATTERN-RECORD) (UBSTACKOFFSET INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.PatternRecord", "unbindVariablesBeginningAt", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternRecord"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("CREATE-CHOICE-POINT", "(DEFUN CREATE-CHOICE-POINT ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "createChoicePoint", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("UNWIND-TO-CHOICE-POINT", "(DEFUN UNWIND-TO-CHOICE-POINT ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "unwindToChoicePoint", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("NEW-BINDINGS-SINCE-LAST-CHOICE-POINT?", "(DEFUN (NEW-BINDINGS-SINCE-LAST-CHOICE-POINT? BOOLEAN) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "newBindingsSinceLastChoicePointP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("BOUND-TO", "(DEFUN (BOUND-TO OBJECT) ((SELF PATTERN-VARIABLE)) :GLOBALLY-INLINE? TRUE :PUBLIC? TRUE (RETURN (NTH (VARIABLE-BINDINGS (CURRENT-PATTERN-RECORD *QUERYITERATOR*)) (BOUND-TO-OFFSET SELF))))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "boundTo", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable")}), null);
      Stella.defineFunctionObject("SAFE-BOUND-TO", "(DEFUN (SAFE-BOUND-TO OBJECT) ((SELF PATTERN-VARIABLE)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "safeBoundTo", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable")}), null);
      Stella.defineFunctionObject("BOUND-TO-IN-FRAME", "(DEFUN (BOUND-TO-IN-FRAME OBJECT) ((SELF PATTERN-VARIABLE) (FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "boundToInFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("BOUND-TO-IN-RECORD", "(DEFUN (BOUND-TO-IN-RECORD OBJECT) ((SELF PATTERN-VARIABLE) (RECORD PATTERN-RECORD)) :GLOBALLY-INLINE? TRUE :PUBLIC? TRUE (RETURN (NTH (VARIABLE-BINDINGS RECORD) (BOUND-TO-OFFSET SELF))))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "boundToInRecord", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), Native.find_java_class("edu.isi.powerloom.logic.PatternRecord")}), null);
      Stella.defineFunctionObject("CONTAINS-OPERATOR?", "(DEFUN (CONTAINS-OPERATOR? BOOLEAN) ((PROPOSITION PROPOSITION) (OPERATOR SURROGATE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "containsOperatorP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("ARGUMENT-BOUND-TO", "(DEFUN (ARGUMENT-BOUND-TO OBJECT) ((SELF OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "argumentBoundTo", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SAFE-ARGUMENT-BOUND-TO", "(DEFUN (SAFE-ARGUMENT-BOUND-TO OBJECT) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "safeArgumentBoundTo", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("HELP-UNIFY-ATTRIBUTES?", "(DEFUN (HELP-UNIFY-ATTRIBUTES? BOOLEAN) ((VALUE1 OBJECT) (VALUE2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "helpUnifyAttributesP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("FAILS-UNIFICATION-TYPE-CHECK?", "(DEFUN (FAILS-UNIFICATION-TYPE-CHECK? BOOLEAN) ((V1 PATTERN-VARIABLE) (I2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "failsUnificationTypeCheckP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("FAILS-ANTECEDENT-TYPE-CHECK?", "(DEFUN (FAILS-ANTECEDENT-TYPE-CHECK? BOOLEAN) ((V1 PATTERN-VARIABLE) (I2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "failsAntecedentTypeCheckP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("HELP-BIND-VARIABLE-TO-VALUE?", "(DEFUN (HELP-BIND-VARIABLE-TO-VALUE? BOOLEAN) ((VARIABLE PATTERN-VARIABLE) (VALUE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "helpBindVariableToValueP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("BIND-VARIABLE-TO-VALUE?", "(DEFUN (BIND-VARIABLE-TO-VALUE? BOOLEAN) ((VARIABLE PATTERN-VARIABLE) (VALUE OBJECT) (AUTOCLEANUP? BOOLEAN)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "bindVariableToValueP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("BIND-ARGUMENT-TO-VALUE?", "(DEFUN (BIND-ARGUMENT-TO-VALUE? BOOLEAN) ((ARGUMENT OBJECT) (VALUE OBJECT) (AUTOCLEANUP? BOOLEAN)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "bindArgumentToValueP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("BIND-VECTOR-OF-ARGUMENTS-TO-VALUES?", "(DEFUN (BIND-VECTOR-OF-ARGUMENTS-TO-VALUES? BOOLEAN) ((ARGUMENTS ARGUMENTS-VECTOR) (VALUES CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "bindVectorOfArgumentsToValuesP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("PRINT-CONTROL-FRAME-STACK", "(DEFUN PRINT-CONTROL-FRAME-STACK ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "printControlFrameStack", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("PCS", "(DEFUN PCS ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "pcs", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("VARIABLE-FROM-UNBINDING-OFFSET", "(DEFUN (VARIABLE-FROM-UNBINDING-OFFSET PATTERN-VARIABLE) ((DESCRIPTION DESCRIPTION) (UBOFFSET INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "variableFromUnbindingOffset", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("PRINT-ONE-VARIABLE-BINDING", "(DEFUN PRINT-ONE-VARIABLE-BINDING ((VARIABLE PATTERN-VARIABLE)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "printOneVariableBinding", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable")}), null);
      Stella.defineFunctionObject("PRINT-VARIABLE-BINDINGS", "(DEFUN PRINT-VARIABLE-BINDINGS ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "printVariableBindings", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("PRINT-RULE-IN-GOAL-TREE", "(DEFUN PRINT-RULE-IN-GOAL-TREE ((FRAME CONTROL-FRAME) (IMPLIESPROP PROPOSITION) (DEPTH INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "printRuleInGoalTree", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("PRINT-GOAL-IN-GOAL-TREE", "(DEFUN PRINT-GOAL-IN-GOAL-TREE ((FRAME CONTROL-FRAME) (DEPTH INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "printGoalInGoalTree", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("COMPUTE-FRAME-DEPTH", "(DEFUN (COMPUTE-FRAME-DEPTH INTEGER) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "computeFrameDepth", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("PRINT-VERTICAL-BARS", "(DEFUN PRINT-VERTICAL-BARS ((DEPTH INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printVerticalBars", new java.lang.Class [] {java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("UNWIND-TO-CHOICE-POINTS-BELOW-FRAME", "(DEFUN UNWIND-TO-CHOICE-POINTS-BELOW-FRAME ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "unwindToChoicePointsBelowFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("TRACE-GOAL", "(DEFUN TRACE-GOAL ((NAME NAME)) :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "traceGoal", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("UNTRACE-GOAL", "(DEFUN UNTRACE-GOAL ((NAME NAME)) :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "untraceGoal", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CLEAR-TRACED-GOALS", "(DEFUN CLEAR-TRACED-GOALS () :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "clearTracedGoals", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("RESTRICTED-GOAL-TRACING?", "(DEFUN (RESTRICTED-GOAL-TRACING? BOOLEAN) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "restrictedGoalTracingP", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("TRACE-THIS-GOAL?", "(DEFUN (TRACE-THIS-GOAL? BOOLEAN) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "traceThisGoalP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("TRACE-GOAL-TREE", "(DEFUN TRACE-GOAL-TREE ((FRAME CONTROL-FRAME) (DEPTH INTEGER) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "traceGoalTree", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("TRACE-GOAL-STACK", "(DEFUN TRACE-GOAL-STACK ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "traceGoalStack", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("OLD-INTERPRET-AND-SCORES", "(DEFUN (OLD-INTERPRET-AND-SCORES KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "oldInterpretAndScores", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
    }
  }

  static void helpStartupQuery8() {
    {
      Stella.defineMethodObject("(DEFMETHOD (CONTINUE-PARTIAL-AND-PROOF KEYWORD) ((SELF CONTROL-FRAME) (FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continuePartialAndProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("INTERPRET-ITERATIVE-FORALL-SCORES", "(DEFUN (INTERPRET-ITERATIVE-FORALL-SCORES KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "interpretIterativeForallScores", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("OLD-INTERPRET-OR-SCORES", "(DEFUN (OLD-INTERPRET-OR-SCORES KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "oldInterpretOrScores", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineMethodObject("(DEFMETHOD (CONTINUE-PARTIAL-OR-PROOF KEYWORD) ((SELF CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continuePartialOrProof", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("OLD-INTERPRET-FAIL-SCORE", "(DEFUN (OLD-INTERPRET-FAIL-SCORE KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "oldInterpretFailScore", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineMethodObject("(DEFMETHOD (CONTINUE-PARTIAL-NOT-PROOF KEYWORD) ((SELF CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continuePartialNotProof", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("OLD-INTERPRET-GOAL-SCORES", "(DEFUN (OLD-INTERPRET-GOAL-SCORES KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "oldInterpretGoalScores", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("ATTACH-SUPPORT", "(DEFUN ATTACH-SUPPORT ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "attachSupport", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineMethodObject("(DEFMETHOD (CONTINUE-PARTIAL-STRATEGIES-PROOFS KEYWORD) ((SELF CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continuePartialStrategiesProofs", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("OPERATIVE-PATTERN-RECORD", "(DEFUN (OPERATIVE-PATTERN-RECORD PATTERN-RECORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "operativePatternRecord", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("CREATE-DOWN-FRAME", "(DEFUN (CREATE-DOWN-FRAME CONTROL-FRAME) ((UPFRAME CONTROL-FRAME) (DOWNPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "createDownFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("SET-FRAME-TRUTH-VALUE", "(DEFUN (SET-FRAME-TRUTH-VALUE TRUTH-VALUE) ((FRAME CONTROL-FRAME) (TRUTHVALUE TRUTH-VALUE)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "setFrameTruthValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.powerloom.logic.TruthValue")}), null);
      Stella.defineFunctionObject("PROPAGATE-FRAME-TRUTH-VALUE", "(DEFUN (PROPAGATE-FRAME-TRUTH-VALUE TRUTH-VALUE) ((SOURCE CONTROL-FRAME) (TARGET CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "propagateFrameTruthValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT CONTROL-FRAME DEBUG-FRAME-ID-INTERNAL :TYPE INTEGER :ALLOCATION :DYNAMIC)");
      Stella.defineFunctionObject("DEBUG-FRAME-ID", "(DEFUN (DEBUG-FRAME-ID INTEGER) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "debugFrameId", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("COPY-FRAME-STATE", "(DEFUN COPY-FRAME-STATE ((FROMFRAME CONTROL-FRAME) (TOFRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "copyFrameState", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("PARALLELIZE-CONTROL-FRAME", "(DEFUN (PARALLELIZE-CONTROL-FRAME PARALLEL-CONTROL-FRAME) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "parallelizeControlFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("ENTER-PARALLEL-THREAD", "(DEFUN ENTER-PARALLEL-THREAD ((PFRAME PARALLEL-CONTROL-FRAME) (CHILDTHREAD PARALLEL-THREAD)))", Native.find_java_method("edu.isi.powerloom.logic.ParallelControlFrame", "enterParallelThread", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ParallelControlFrame"), Native.find_java_class("edu.isi.powerloom.logic.ParallelThread")}), null);
      Stella.defineFunctionObject("EXIT-PARALLEL-THREAD", "(DEFUN EXIT-PARALLEL-THREAD ((PFRAME PARALLEL-CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ParallelControlFrame", "exitParallelThread", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ParallelControlFrame")}), null);
      Stella.defineFunctionObject("ENTER-HYPOTHETICAL-WORLD", "(DEFUN (ENTER-HYPOTHETICAL-WORLD WORLD) ((PFRAME PARALLEL-CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ParallelControlFrame", "enterHypotheticalWorld", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ParallelControlFrame")}), null);
      Stella.defineFunctionObject("PARTIAL-MATCH-MODE?", "(DEFUN (PARTIAL-MATCH-MODE? BOOLEAN) () :GLOBALLY-INLINE? TRUE (RETURN (AND (DEFINED? *QUERYITERATOR*) (DEFINED? (PARTIAL-MATCH-STRATEGY *QUERYITERATOR*)))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "partialMatchModeP", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("EXECUTE-BACKWARD-CHAINING-PROOF?", "(DEFUN (EXECUTE-BACKWARD-CHAINING-PROOF? BOOLEAN) ((QUERY QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "executeBackwardChainingProofP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator")}), null);
      Stella.defineFunctionObject("EVALUATE-NEXT-MOVE", "(DEFUN (EVALUATE-NEXT-MOVE KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD) (CLOCKTICKS INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "evaluateNextMove", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword"), java.lang.Integer.TYPE}), null);
      Stella.defineMethodObject("(DEFMETHOD (CLUSTERED-CONJUNCTION? BOOLEAN) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "clusteredConjunctionP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("CONTINUE-AND-PROOF", "(DEFUN (CONTINUE-AND-PROOF KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continueAndProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("CONTINUE-OR-PROOF", "(DEFUN (CONTINUE-OR-PROOF KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continueOrProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("CONTINUE-NOT-PROOF", "(DEFUN (CONTINUE-NOT-PROOF KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continueNotProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("OVERLAY-WITH-FAIL-FRAME", "(DEFUN (OVERLAY-WITH-FAIL-FRAME KEYWORD) ((FRAME CONTROL-FRAME) (PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "overlayWithFailFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("OVERLAY-WITH-STRATEGY-FRAME", "(DEFUN (OVERLAY-WITH-STRATEGY-FRAME KEYWORD) ((FRAME CONTROL-FRAME) (STRATEGY KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "overlayWithStrategyFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("CHECK-FOR-DUPLICATE-GOAL?", "(DEFUN (CHECK-FOR-DUPLICATE-GOAL? BOOLEAN) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "checkForDuplicateGoalP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("INITIATE-ATOMIC-GOAL-PROOFS", "(DEFUN (INITIATE-ATOMIC-GOAL-PROOFS KEYWORD) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "initiateAtomicGoalProofs", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("ALL-ARGUMENTS-BOUND?", "(DEFUN (ALL-ARGUMENTS-BOUND? BOOLEAN) ((GOAL PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "allArgumentsBoundP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("ALL-KEY-ARGUMENTS-BOUND?", "(DEFUN (ALL-KEY-ARGUMENTS-BOUND? BOOLEAN) ((GOAL PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "allKeyArgumentsBoundP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("CREATE-PATTERN-RECORD", "(DEFUN (CREATE-PATTERN-RECORD PATTERN-RECORD) ((FRAME CONTROL-FRAME) (DESCRIPTION DESCRIPTION) (EXTERNALARGUMENTS ARGUMENTS-VECTOR)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "createPatternRecord", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("TERMINATE-PATTERN-RECORD?", "(DEFUN (TERMINATE-PATTERN-RECORD? BOOLEAN) ((SELF PATTERN-RECORD)))", Native.find_java_method("edu.isi.powerloom.logic.PatternRecord", "terminatePatternRecordP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternRecord")}), null);
      Stella.defineFunctionObject("COPY-PATTERN-ARGUMENTS", "(DEFUN (COPY-PATTERN-ARGUMENTS ARGUMENTS-VECTOR) ((ARGUMENTS OBJECT-VECTOR) (DESCRIPTION DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "copyPatternArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("COMPUTE-EXTERNAL-BINDINGS", "(DEFUN (COMPUTE-EXTERNAL-BINDINGS CONS) ((EXTERNALARGUMENTS ARGUMENTS-VECTOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "computeExternalBindings", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("INSTANTIATE-EXTERNAL-BINDINGS", "(DEFUN (INSTANTIATE-EXTERNAL-BINDINGS OBJECT) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "instantiateExternalBindings", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("INSTANTIATE-EXTERNAL-VARIABLES", "(DEFUN (INSTANTIATE-EXTERNAL-VARIABLES DESCRIPTION) ((SELF DESCRIPTION) (BINDINGS ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "instantiateExternalVariables", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("CHECK-FOR-SINGLE-VALUED-GOAL?", "(DEFUN (CHECK-FOR-SINGLE-VALUED-GOAL? BOOLEAN) ((PATTERN DESCRIPTION) (IOBINDINGS CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "checkForSingleValuedGoalP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("OVERLAY-WITH-PATTERN-FRAME?", "(DEFUN (OVERLAY-WITH-PATTERN-FRAME? BOOLEAN) ((FRAME CONTROL-FRAME) (DESCRIPTION DESCRIPTION) (IOARGUMENTS ARGUMENTS-VECTOR)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "overlayWithPatternFrameP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("TRANSFER-PATTERN-QUERY-BINDINGS?", "(DEFUN (TRANSFER-PATTERN-QUERY-BINDINGS? BOOLEAN) ((FRAME CONTROL-FRAME) (FUTUREBINDINGS? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "transferPatternQueryBindingsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("COLLECT-PATTERN-QUERY-BINDINGS", "(DEFUN COLLECT-PATTERN-QUERY-BINDINGS ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "collectPatternQueryBindings", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("GET-RULE-OF-ANTECEDENT-FRAME", "(DEFUN (GET-RULE-OF-ANTECEDENT-FRAME PROPOSITION) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "getRuleOfAntecedentFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("CONTINUE-PATTERN-PROOF", "(DEFUN (CONTINUE-PATTERN-PROOF KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "continuePatternProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("DISJOINT-CLASSES?", "(DEFUN (DISJOINT-CLASSES? BOOLEAN) ((DESC1 NAMED-DESCRIPTION) (DESC2 NAMED-DESCRIPTION)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "disjointClassesP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("DISJOINT-TERMS?", "(DEFUN (DISJOINT-TERMS? BOOLEAN) ((D1 DESCRIPTION) (D2 DESCRIPTION)) :DOCUMENTATION \"Return TRUE if 'd1' and 'd2' belong to disjoint partitions.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Description", "disjointTermsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("EXPENSIVE-DISJOINT-TERMS?", "(DEFUN (EXPENSIVE-DISJOINT-TERMS? BOOLEAN) ((D1 DESCRIPTION) (D2 DESCRIPTION)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Description", "expensiveDisjointTermsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("COLLECTIONOF-PROPOSITION?", "(DEFUN (COLLECTIONOF-PROPOSITION? BOOLEAN) ((DEFININGPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "collectionofPropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("MEMBER-OF-COLLECTION?", "(DEFUN (MEMBER-OF-COLLECTION? BOOLEAN) ((MEMBER OBJECT) (COLLECTION OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "memberOfCollectionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("ASSERTED-COLLECTION-MEMBERS", "(DEFUN (ASSERTED-COLLECTION-MEMBERS LIST) ((SELF OBJECT) (DIRECT? BOOLEAN)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "assertedCollectionMembers", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ALL-TRUE-EXTENSION-MEMBERS", "(DEFUN (ALL-TRUE-EXTENSION-MEMBERS DESCRIPTION-EXTENSION-ITERATOR) ((SELF NAMED-DESCRIPTION) (SPECIALIZE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "allTrueExtensionMembers", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ALL-MATCHING-EXTENSION-MEMBERS", "(DEFUN (ALL-MATCHING-EXTENSION-MEMBERS (ITERATOR OF PROPOSITION)) ((SELF PROPOSITION) (SPECIALIZE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "allMatchingExtensionMembers", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), java.lang.Boolean.TYPE}), null);
      Stella.defineMethodObject("(DEFMETHOD (NEXT? BOOLEAN) ((SELF DESCRIPTION-EXTENSION-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.DescriptionExtensionIterator", "nextP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("HELP-FIND-DUPLICATED-GOAL", "(DEFUN (HELP-FIND-DUPLICATED-GOAL CONTROL-FRAME CONTROL-FRAME INTEGER) ((GOALFRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "helpFindDuplicatedGoal", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("FIND-DUPLICATED-GOAL", "(DEFUN (FIND-DUPLICATED-GOAL CONTROL-FRAME CONTROL-FRAME INTEGER) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "findDuplicatedGoal", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("HANDLE-DEPTH-VIOLATION", "(DEFUN (HANDLE-DEPTH-VIOLATION CONTROL-FRAME INTEGER) ((FRAME CONTROL-FRAME) (DEPTH INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "handleDepthViolation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), java.lang.Integer.TYPE, Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("HANDLE-TIMEOUT", "(DEFUN (HANDLE-TIMEOUT CONTROL-FRAME INTEGER) ((FRAME CONTROL-FRAME) (DEPTH INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "handleTimeout", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), java.lang.Integer.TYPE, Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineMethodObject("(DEFMETHOD (LOOKUP (LIKE (ANY-VALUE SELF))) ((SELF QUERY-SOLUTION-TABLE) (KEY (LIKE (ANY-KEY SELF)))) :DOCUMENTATION \"Lookup the solution identified by `key' in `self' and\nreturn its value, or NULL if no such solution exists.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.QuerySolutionTable", "lookup", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD INSERT-AT ((SELF QUERY-SOLUTION-TABLE) (KEY (LIKE (ANY-KEY SELF))) (VALUE (LIKE (ANY-VALUE SELF)))) :DOCUMENTATION \"Insert `value' identified by `key' into `self'.  If a solution\nwith that key already exists, destructively modify it with the slot values of\n`value'.  This is necessary to preserve the order of solutions in `self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.QuerySolutionTable", "insertAt", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.powerloom.logic.QuerySolution")}), ((java.lang.reflect.Method)(null)));
    }
  }

  static void helpStartupQuery9() {
    {
      Stella.defineMethodObject("(DEFMETHOD (DELETED? BOOLEAN) ((SELF QUERY-SOLUTION)))", Native.find_java_method("edu.isi.powerloom.logic.QuerySolution", "deletedP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (DELETED?-SETTER BOOLEAN) ((SELF QUERY-SOLUTION) (VALUE BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.QuerySolution", "deletedPSetter", new java.lang.Class [] {java.lang.Boolean.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD REMOVE-AT ((SELF QUERY-SOLUTION-TABLE) (KEY (LIKE (ANY-KEY SELF)))) :DOCUMENTATION \"Remove the solution identified by `key' from `self'.\nTo preserve the solution ordering chain, the solution is marked as deleted\nand will be completely removed upon the next iteration through `self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.QuerySolutionTable", "removeAt", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (POP (LIKE (ANY-VALUE SELF))) ((SELF QUERY-SOLUTION-TABLE)) :DOCUMENTATION \"Remove and return the first solution of `self' or NULL\nif the table is empty.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.QuerySolutionTable", "pop", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (LENGTH INTEGER) ((SELF QUERY-SOLUTION-TABLE)) :DOCUMENTATION \"Return the number of entries in `self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.QuerySolutionTable", "length", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (EMPTY? BOOLEAN) ((SELF QUERY-SOLUTION-TABLE)) :DOCUMENTATION \"Return TRUE if `self' has zero entries.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.QuerySolutionTable", "emptyP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (NON-EMPTY? BOOLEAN) ((SELF QUERY-SOLUTION-TABLE)) :DOCUMENTATION \"Return TRUE if `self' has at least 1 entry.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.QuerySolutionTable", "nonEmptyP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (NTH (LIKE (ANY-VALUE SELF))) ((SELF QUERY-SOLUTION-TABLE) (POSITION INTEGER)) :DOCUMENTATION \"Return the nth solution in `self', or NULL if it is empty.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.QuerySolutionTable", "nth", new java.lang.Class [] {java.lang.Integer.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD CLEAR ((SELF QUERY-SOLUTION-TABLE)))", Native.find_java_method("edu.isi.powerloom.logic.QuerySolutionTable", "clear", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CONSIFY CONS) ((SELF QUERY-SOLUTION-TABLE)) :DOCUMENTATION \"Collect all solutions of `self' into a cons list and return the result.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.QuerySolutionTable", "consify", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (SORT (LIKE SELF)) ((SELF QUERY-SOLUTION-TABLE) (PREDICATE FUNCTION-CODE)) :DOCUMENTATION \"Perform a stable, destructive sort of `self' according to\n`predicate', and return the result.  If `predicate' has a '<' semantics, the\nresult will be in ascending order.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.QuerySolutionTable", "sort", new java.lang.Class [] {Native.find_java_class("java.lang.reflect.Method")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("QUERY-SOLUTION-LESS-THAN?", "(DEFUN (QUERY-SOLUTION-LESS-THAN? BOOLEAN) ((X QUERY-SOLUTION) (Y QUERY-SOLUTION)))", Native.find_java_method("edu.isi.powerloom.logic.QuerySolution", "querySolutionLessThanP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QuerySolution"), Native.find_java_class("edu.isi.powerloom.logic.QuerySolution")}), null);
      Stella.defineFunctionObject("QUERY-SOLUTION-GREATER-THAN?", "(DEFUN (QUERY-SOLUTION-GREATER-THAN? BOOLEAN) ((X QUERY-SOLUTION) (Y QUERY-SOLUTION)))", Native.find_java_method("edu.isi.powerloom.logic.QuerySolution", "querySolutionGreaterThanP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QuerySolution"), Native.find_java_class("edu.isi.powerloom.logic.QuerySolution")}), null);
      Stella.defineMethodObject("(DEFMETHOD (ALLOCATE-ITERATOR (DICTIONARY-ITERATOR OF (LIKE (ANY-KEY SELF)) (LIKE (ANY-VALUE SELF)))) ((SELF QUERY-SOLUTION-TABLE)))", Native.find_java_method("edu.isi.powerloom.logic.QuerySolutionTable", "allocateIterator", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (NEXT? BOOLEAN) ((SELF QUERY-SOLUTION-TABLE-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.QuerySolutionTableIterator", "nextP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("PRINT-CONTROL-FRAME", "(DEFUN PRINT-CONTROL-FRAME ((SELF CONTROL-FRAME) (STREAM NATIVE-OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "printControlFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), null);
      Stella.defineFunctionObject("PRINT-GOAL-STACK", "(DEFUN PRINT-GOAL-STACK ((FRAME CONTROL-FRAME) (VERBOSE? BOOLEAN)) :DOCUMENTATION \"Print stack of goals.  Assumes that query has been interrupted\nwith a full stack of control frames.\")", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "printGoalStack", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("PGS", "(DEFUN PGS ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "pgs", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("VPGS", "(DEFUN VPGS ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "vpgs", new java.lang.Class [] {}), null);
      Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT QUERY-ITERATOR DEBUG-ID :TYPE STRING :ALLOCATION :DYNAMIC)");
      Stella.defineMethodObject("(DEFMETHOD DEBUG-ID-SETTER ((SELF QUERY-ITERATOR) (ID STRING)) :DOCUMENTATION \"Set the debug ID of `self' to `id'.  If `id' is NULL, simply\nuse the current ID counter and increment it appropriately.\")", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "debugIdSetter", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("PRINT-QUERY-ITERATOR", "(DEFUN PRINT-QUERY-ITERATOR ((SELF QUERY-ITERATOR) (STREAM NATIVE-OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "printQueryIterator", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator"), Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), null);
      Stella.defineFunctionObject("PRINT-QUERY-ITERATOR-ORNATELY", "(DEFUN PRINT-QUERY-ITERATOR-ORNATELY ((SELF QUERY-ITERATOR) (STREAM NATIVE-OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "printQueryIteratorOrnately", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator"), Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), null);
      Stella.defineFunctionObject("PRINT-QUERY-ITERATOR-SOLUTION-ORNATELY", "(DEFUN PRINT-QUERY-ITERATOR-SOLUTION-ORNATELY ((SELF QUERY-ITERATOR) (SOLUTION QUERY-SOLUTION) (SOLUTIONNUMBER INTEGER) (STREAM NATIVE-OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "printQueryIteratorSolutionOrnately", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator"), Native.find_java_class("edu.isi.powerloom.logic.QuerySolution"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), null);
      Stella.defineFunctionObject("TRACE-SOLUTION", "(DEFUN TRACE-SOLUTION ((SELF QUERY-ITERATOR) (SOLUTION QUERY-SOLUTION) (SOLUTIONNUMBER INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "traceSolution", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator"), Native.find_java_class("edu.isi.powerloom.logic.QuerySolution"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("PRINT-QUERY-ITERATOR-READABLY", "(DEFUN PRINT-QUERY-ITERATOR-READABLY ((SELF QUERY-ITERATOR) (STREAM NATIVE-OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "printQueryIteratorReadably", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator"), Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), null);
      Stella.defineFunctionObject("PRINT-QUERY-ITERATOR-TAB-SEPARATED", "(DEFUN PRINT-QUERY-ITERATOR-TAB-SEPARATED ((SELF QUERY-ITERATOR) (STREAM NATIVE-OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "printQueryIteratorTabSeparated", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator"), Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), null);
      Stella.defineFunctionObject("PARSE-QUERY-ITERATOR-STRING-TEMPLATE", "(DEFUN (PARSE-QUERY-ITERATOR-STRING-TEMPLATE CONS) ((SELF QUERY-ITERATOR) (TEMPLATE STRING)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "parseQueryIteratorStringTemplate", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("PRINT-QUERY-ITERATOR-VIA-TEMPLATE", "(DEFUN PRINT-QUERY-ITERATOR-VIA-TEMPLATE ((SELF QUERY-ITERATOR) (STREAM NATIVE-OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "printQueryIteratorViaTemplate", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator"), Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), null);
      Stella.defineFunctionObject("ALLOCATE-QUERY-ITERATOR", "(DEFUN (ALLOCATE-QUERY-ITERATOR QUERY-ITERATOR) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allocateQueryIterator", new java.lang.Class [] {}), null);
      Stella.defineMethodObject("(DEFMETHOD FREE ((SELF QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "free", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("FREE-QUERY-ITERATOR", "(DEFUN FREE-QUERY-ITERATOR ((SELF QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "freeQueryIterator", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator")}), null);
      Stella.defineFunctionObject("ALLOCATE-COLLECTION-VARIABLES", "(DEFUN (ALLOCATE-COLLECTION-VARIABLES VARIABLES-VECTOR) ((FRAME CONTROL-FRAME) (DESCRIPTION DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "allocateCollectionVariables", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("CREATE-QUERY-ITERATOR", "(DEFUN (CREATE-QUERY-ITERATOR QUERY-ITERATOR) ((DESCRIPTION DESCRIPTION) (OUTSIDEBINDINGS VECTOR)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "createQueryIterator", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("INITIALIZE-QUERY-ITERATOR", "(DEFUN (INITIALIZE-QUERY-ITERATOR QUERY-ITERATOR) ((QUERYITERATOR QUERY-ITERATOR) (DESCRIPTION DESCRIPTION) (OUTSIDEBINDINGS VECTOR)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "initializeQueryIterator", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator"), Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineMethodObject("(DEFMETHOD (QUERY-PROPOSITION PROPOSITION) ((SELF QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "queryProposition", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (QUERY-DESCRIPTION DESCRIPTION) ((SELF QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "queryDescription", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (QUERY-IS-TRUE-FALSE? BOOLEAN) ((SELF QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "queryIsTrueFalseP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (QUERY-IS-PARTIAL? BOOLEAN) ((SELF QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "queryIsPartialP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (QUERY-SUCCEEDED? BOOLEAN) ((SELF QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "querySucceededP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (NEXT? BOOLEAN) ((SELF QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "nextP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("TRY-TO-DEFEAT-LAST-ANSWER?", "(DEFUN (TRY-TO-DEFEAT-LAST-ANSWER? BOOLEAN JUSTIFICATION) ((SELF QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "tryToDefeatLastAnswerP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineMethodObject("(DEFMETHOD RESET ((SELF QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "reset", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("STANDARDIZE-QUERY-TREE", "(DEFUN (STANDARDIZE-QUERY-TREE CONS) ((IOVARIABLES OBJECT) (QUERYBODY OBJECT) (EXTERNALVARIABLES CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "standardizeQueryTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("MAKE-QUERY", "(DEFUN (MAKE-QUERY QUERY-ITERATOR) ((IOVARIABLES OBJECT) (QUERYTREE OBJECT) (EXTERNALBINDINGS CONS) (OPTIONS OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "makeQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("PARSE-QUERY-AND-OPTIONS", "(DEFUN (PARSE-QUERY-AND-OPTIONS OBJECT OBJECT PROPERTY-LIST) ((|QUERY&OPTIONS| CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "parseQueryAndOptions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("PROCESS-QUERY-OPTIONS", "(DEFUN PROCESS-QUERY-OPTIONS ((QUERY QUERY-ITERATOR) (OPTIONS OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "processQueryOptions", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("LOOKUP-QUERY-OPTION", "(DEFUN (LOOKUP-QUERY-OPTION OBJECT) ((QUERYOROPTIONS OBJECT) (KEY KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "lookupQueryOption", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("LOOKUP-QUERY-OPTION-WITH-DEFAULT", "(DEFUN (LOOKUP-QUERY-OPTION-WITH-DEFAULT OBJECT) ((QUERYOROPTIONS OBJECT) (KEY KEYWORD) (DEFAULT OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "lookupQueryOptionWithDefault", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("TEST-QUERY-OPTION?", "(DEFUN (TEST-QUERY-OPTION? BOOLEAN) ((QUERYOROPTIONS OBJECT) (KEY KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "testQueryOptionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("TEST-QUERY-OPTION-VALUE?", "(DEFUN (TEST-QUERY-OPTION-VALUE? BOOLEAN) ((QUERYOROPTIONS OBJECT) (KEY KEYWORD) (VALUE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "testQueryOptionValueP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("LOOKUP-DEFERRED-QUERY-OPTION", "(DEFUN (LOOKUP-DEFERRED-QUERY-OPTION OBJECT) ((QUERYOROPTIONS OBJECT) (KEY KEYWORD) (COERCETOTYPE TYPE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "lookupDeferredQueryOption", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("LOOKUP-HOW-MANY-SOLUTIONS", "(DEFUN (LOOKUP-HOW-MANY-SOLUTIONS INTEGER) ((QUERYOROPTIONS OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "lookupHowManySolutions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("RUN-YES-OR-NO-QUERY?", "(DEFUN (RUN-YES-OR-NO-QUERY? THREE-VALUED-BOOLEAN) ((QUERY QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "runYesOrNoQueryP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator")}), null);
      Stella.defineFunctionObject("COERCE-TO-TREE", "(DEFUN (COERCE-TO-TREE OBJECT) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "coerceToTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CREATE-ASK-QUERY", "(DEFUN (CREATE-ASK-QUERY QUERY-ITERATOR) ((QUERY OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createAskQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CALL-ASK", "(DEFUN (CALL-ASK TRUTH-VALUE) ((QUERY OBJECT)) :DOCUMENTATION \"Callable version of `ask' (which see).  Accepts queries\nspecified by a query iterator, or specified as a CONS-list of arguments as they\nwould be supplied to `ask'.  Raises LOGIC-EXCEPTIONs in case of illegal\nqueries and logical expressions.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "callAsk", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("ASK", "(DEFUN (ASK TRUTH-VALUE) (|&REST| (|PROPOSITION&OPTIONS| PARSE-TREE)) :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Perform inference to determine whether the proposition specified in\n`proposition&options' is true.  Return the truth-value found.  `ask'\nwill spend most of its effort to determine whether the proposition\nis true and only a little effort via shallow inference strategies to\ndetermine whether it is false.  To find out whether a proposition is\nfalse with full inference effort `ask' its negation.\n\nKIF example: `(ask (happy Fred))' will return TRUE if Fred was indeed\nfound to be happy.  Note, that for this query to run, the logic\nconstant `Fred' and the relation `happy' must already be defined (see\n`assert').  Use `(set/unset-feature goal-trace)' to en/disable goal\ntracing of the inference engine.\n\nThe `ask' command supports the following options: `:TIMEOUT' is an\ninteger or floating point time limit, specified in seconds.  For\nexample, the command `(ask (nervous Fred) :timeout 2.0)' will cease\ninference after two seconds if a proof has not been found by then.\nIf the `:DONT-OPTIMIZE?' is given as TRUE, it tells PowerLoom to\nnot optimize the order of clauses in the query before evaluating it.\nThis is useful for cases where a specific evaluation order of the\nclauses is required (or the optimizer doesn't do the right thing).\nIf `:THREE-VALUED?' is given as TRUE, PowerLoom will try to prove\nthe negation of the query with full effort in case the given query\nreturned UNKNOWN.  By default, PowerLoom uses full effort to prove\nthe query as stated and only a little opportunistic effort to see\nwhether it is actually false.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "ask", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "askEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("RETRIEVE-BINDINGS", "(DEFUN (RETRIEVE-BINDINGS QUERY-ITERATOR) ((QUERY OBJECT) (NOFBINDINGS INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "retrieveBindings", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("CREATE-RETRIEVE-QUERY", "(DEFUN (CREATE-RETRIEVE-QUERY QUERY-ITERATOR) ((QUERY OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createRetrieveQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
    }
  }

  static void helpStartupQuery10() {
    {
      Stella.defineFunctionObject("CALL-RETRIEVE", "(DEFUN (CALL-RETRIEVE QUERY-ITERATOR) ((QUERY OBJECT)) :DOCUMENTATION \"Callable version of `retrieve' (which see).  Accepts queries\nspecified by a query iterator, or specified as a CONS-list of arguments as they\nwould be supplied to `retrieve'.  Raises LOGIC-EXCEPTIONs in case of illegal\nqueries and logical expressions.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "callRetrieve", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("RETRIEVE", "(DEFUN (RETRIEVE QUERY-ITERATOR) (|&REST| (QUERY PARSE-TREE)) :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Retrieve elements of a relation (tuples) that satisfy a proposition.\nThe accepted syntax is:\n	 \n  (retrieve [<integer> | all]\n            [[{<vardecl> | (<vardecl>+)}]\n             <proposition>\n             [<option-keyword> <option-value>]])\n	\nThe variables and proposition are similar to an `exists' sentence or\n`kappa' term without the explicit quantifier.  If variables are declared,\nthey must match the free variables referenced by <proposition>.  Otherwise,\nthe free variables referenced in <proposition> will be used as the query\nvariables.  If <proposition> is omitted, the most recently asked query\nwill be continued.\n\nA solution is a set of bindings for the listed variables for which\n<proposition> is true.  The optional first argument controls how many\nsolutions should be generated before control is returned.  The keyword\n`all' indicates that all solutions should be generated.  By default,\n`retrieve' returns after it has found one new solution or if it cannot\nfind any more solutions.\n\n`retrieve' returns an iterator which saves all the necessary state of\na query and stores all generated solutions.  When used interactively,\nthe returned iterator will print out with the set of solutions collected\nso far.  Calling `retrieve' without any arguments (or only with the first\nargument) will generate one (or more) solutions to the most recently\nasked query.\n\n`retrieve' supports the following options:\n  :TIMEOUT Time limit on query effort in seconds.\n  :MAXIMUM-DEPTH Inference depth cutoff in goal depth.\n  :INFERENCE-LEVEL Level of inference to use.  The values in order of effort\n     and power are ASSERTION, SHALLOW, SUBSUMPTION, BACKTRACKING, NORMAL\n     and REFUTATION. Default is NORMAL.\n  :FOUR-VALUED? Will attempt to disprove values and find conflicts.\n  :ITERATIVE-DEEPENING? Controls whether the search strategy will use\n     depth-first or breadth-first search.\n  :DONT-OPTIMIZE? Option to disable re-arrangement of clauses by the query\n     optimizer.  If TRUE, then use the order of clauses as given in the query.\n  :SORT-BY one of SCORE, VALUES, VALUES-DESCENDING, VALUES-ASCENDING.  \n     SCORE is only meaningful for partial match mode.  The value sorting\n     is done by values in order in the tuple.  Default is ascending.\n  :MATCH-MODE Allows choice of matching mode.  One of STRICT, INCREMENTAL, \n     NEURAL-NETWORK, or other plug-in partial-match mode.\n     The default is STRICT.\n  :MINIMUM-SCORE The minimum score to return.  Only useful in partial match\n    mode.\n  :MAXIMUM-UNKNOWNS The maximum number of unknown values to allow.  Only useful\n    for whynot matching.\n\nKIF examples:\n	 \n  (retrieve (happy ?x))\n	\nwill try to find one happy entity and store it in the returned \nquery iterator.\n	 \n  (retrieve 10 (happy ?x))\n	\nwill try to find 10 happy entities.\n	 \n  (retrieve 10)\n	\nwill try to find the next 10 happy entities..\n	 \n  (retrieve all (happy ?x))\n	\nwill find all happy entities.\n	 \n  (retrieve all (?x Person) (happy ?x))\n	\nwill to find all happy people.  Here we used the optional retrieve variable\nsyntax to restrict the acceptable solutions.  The above is equivalent to\nthe following query:\n	 \n  (retrieve all (and (Person ?x) (happy ?x)))\n	\nSimilarly,\n	 \n  (retrieve all (?x Person))\n  (retrieve all (Person ?x))\n  (retrieve all ?x (Person ?x))\n	\nwill find all people.  Note that in the first case we only specify a query\nvariable and its type but omit the logic sentence which defaults to TRUE.  This\nsomewhat impoverished looking query can be paraphrased as \\\"retrieve all ?x of\ntype Person such that TRUE.\\\"\n	 \n  (retrieve ?x (or (happy ?x) (parent-of Fred ?x)))\n	\nwill try to find a person that is happy or has Fred as a parent.\n	 \n  (retrieve (?y ?x) (parent-of ?x ?y))\n	\nwill try to find the one pair of parent/child and return it in the order\nof child/parent.\n	 \n  (retrieve all (?x Person)\n         " + "   (exists (?y Person) (parent-of ?x ?y)))\n	\nwill generate the set of all parents.  Note, that for these queries to run,\nthe class `Person', the relations `happy' and `parent-of', and the logic\nconstant `Fred' must already be defined (see `assert').\n\nUse `(set/unset-feature trace-subgoals)' to en/disable goal tracing of the\ninference engine.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "retrieve", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "retrieveEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineMethodObject("(DEFMETHOD (CONSIFY-CURRENT-SOLUTIONS CONS) ((SELF QUERY-ITERATOR)) :DOCUMENTATION \"Collect the current solutions of `self' into a cons list\nof result tuples.  If `:SINGLETONS? TRUE', collect a list of atoms rather than a\nlist of lists for tuples of arity=1.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "consifyCurrentSolutions", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CONSIFY CONS) ((SELF QUERY-ITERATOR)) :DOCUMENTATION \"Generate all solutions for the query self, and collect them into a cons list\nof result tuples.  If `:SINGLETONS? TRUE', collect a list of atoms rather than a\nlist of lists for tuples of arity=1.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "consify", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("CONSIFY-QUERY", "(DEFUN (CONSIFY-QUERY CONS) ((SELF QUERY-ITERATOR)) :GLOBALLY-INLINE? TRUE (RETURN (CONSIFY SELF)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "consifyQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator")}), null);
      Stella.defineMethodObject("(DEFMETHOD (LISTIFY LIST) ((SELF QUERY-ITERATOR)) :DOCUMENTATION \"Just like `QUERY-ITERATOR.consify' but return a LIST instead.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "listify", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("CLEAR-INLINE-QUERY-CACHES", "(DEFUN CLEAR-INLINE-QUERY-CACHES ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "clearInlineQueryCaches", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("FIND-CACHED-QUERY", "(DEFUN (FIND-CACHED-QUERY QUERY-ITERATOR) ((QUERYID SYMBOL)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "findCachedQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("FREE-CACHED-QUERY", "(DEFUN FREE-CACHED-QUERY ((QUERY QUERY-ITERATOR) (QUERYID SYMBOL)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "freeCachedQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("MAKE-CACHED-QUERY", "(DEFUN (MAKE-CACHED-QUERY QUERY-ITERATOR) ((VARIABLES CONS) (QUERYBODY CONS) (INPUTBINDINGS CONS) (OPTIONS OBJECT) (CACHEID SYMBOL)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "makeCachedQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("APPLY-CACHED-RETRIEVE", "(DEFUN (APPLY-CACHED-RETRIEVE CONS CONS CONS) ((VARIABLES CONS) (QUERYBODY CONS) (INPUTBINDINGS CONS) (OPTIONS OBJECT) (CACHEID SYMBOL)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "applyCachedRetrieve", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("APPLY-CACHED-ASK", "(DEFUN (APPLY-CACHED-ASK BOOLEAN TRUTH-VALUE) ((INPUTVARIABLES CONS) (QUERYBODY CONS) (INPUTBINDINGS CONS) (OPTIONS OBJECT) (CACHEID SYMBOL)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "applyCachedAsk", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("GET-PROTOTYPE", "(DEFUN (GET-PROTOTYPE LOGIC-OBJECT) ((DESCRIPTION DESCRIPTION)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Description", "getPrototype", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("UNARY-DESCRIPTION-SPECIALIZES-DESCRIPTION?", "(DEFUN (UNARY-DESCRIPTION-SPECIALIZES-DESCRIPTION? TRUTH-VALUE) ((SUB DESCRIPTION) (SUPER DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "unaryDescriptionSpecializesDescriptionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("DESCRIPTION-SPECIALIZES-DESCRIPTION?", "(DEFUN (DESCRIPTION-SPECIALIZES-DESCRIPTION? TRUTH-VALUE) ((SUB DESCRIPTION) (SUPER DESCRIPTION)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Description", "descriptionSpecializesDescriptionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("VECTOR-SATISFIES-DESCRIPTION?", "(DEFUN (VECTOR-SATISFIES-DESCRIPTION? TRUTH-VALUE) ((VECTOR VECTOR) (DESCRIPTION DESCRIPTION)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "vectorSatisfiesDescriptionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("INSTANCE-SATISFIES-DESCRIPTION?", "(DEFUN (INSTANCE-SATISFIES-DESCRIPTION? TRUTH-VALUE) ((INSTANCE OBJECT) (DESCRIPTION DESCRIPTION)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "instanceSatisfiesDescriptionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("COERCE-TO-DESCRIPTION", "(DEFUN (COERCE-TO-DESCRIPTION DESCRIPTION) ((SELF OBJECT) (ORIGINAL OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "coerceToDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SPECIALIZES?", "(DEFUN (SPECIALIZES? TRUTH-VALUE) ((SUBOBJECT OBJECT) (SUPEROBJECT OBJECT)) :DOCUMENTATION \"Try to prove if the description associated with `subObject'\nspecializes the description for `superObject' and return the result truth\nvalue of the query.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "specializesP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("COERCE-TO-INSTANCE", "(DEFUN (COERCE-TO-INSTANCE LOGIC-OBJECT) ((SELF OBJECT) (ORIGINAL OBJECT)) :DOCUMENTATION \"Return the logic instance referred to by 'self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "coerceToInstance", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("COERCE-TO-INSTANCE-OR-LITERAL", "(DEFUN (COERCE-TO-INSTANCE-OR-LITERAL OBJECT) ((SELF OBJECT) (ORIGINAL OBJECT)) :DOCUMENTATION \"Return the logic instance referred to by `self', or `self' if it is a\nliteral (e.g., string or number) that can't be coerced.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "coerceToInstanceOrLiteral", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("COERCE-TO-VECTOR", "(DEFUN (COERCE-TO-VECTOR VECTOR) ((SELF OBJECT)) :DOCUMENTATION \"Return a vector containing the elements in `self'.\nCoerce each element of `self' to be a logic object or literal.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "coerceToVector", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SATISFIES?", "(DEFUN (SATISFIES? TRUTH-VALUE) ((INSTANCEORTUPLE OBJECT) (RELATIONREF OBJECT)) :DOCUMENTATION \"Try to prove whether `instanceOrTuple' satisfies the\ndefinition of the relation `relationRef' and return the result truth value\nof the query.  `instanceOrTuple' can be a single object, the name or surrogate\nof an object, or a collection (a list or vector) of objects.  `relationRef'\ncan be a relation, description, surrogate or relation name.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "satisfiesP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("APPLY-KAPPA?", "(DEFUN (APPLY-KAPPA? BOOLEAN) ((DESCRIPTION DESCRIPTION) (VECTOR VECTOR)) :PUBLIC? TRUE :DOCUMENTATION \"Apply (inherit) the description 'description'\nto members of the vector 'vector'.  Return TRUE if no clash was detected.\nConstraint propagation happens only if it is enabled prior to calling\n'apply-kappa?'.\")", Native.find_java_method("edu.isi.powerloom.logic.Description", "applyKappaP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("UPDATE-PROPOSITIONS-FROM-QUERY", "(DEFUN (UPDATE-PROPOSITIONS-FROM-QUERY (CONS OF PROPOSITION)) ((QUERY QUERY-ITERATOR) (DESCRIPTION DESCRIPTION) (MODULE MODULE) (UPDATEMODE KEYWORD) (RECORDJUSTIFICATIONS? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "updatePropositionsFromQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator"), Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.stella.Keyword"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("GET-QUERY-ITERATOR-FROM-COMMAND", "(DEFUN (GET-QUERY-ITERATOR-FROM-COMMAND QUERY-ITERATOR) ((QUERY CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getQueryIteratorFromCommand", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("ASSERT-FROM-QUERY", "(DEFUN (ASSERT-FROM-QUERY (CONS OF PROPOSITION)) ((QUERY CONS) |&REST| (OPTIONS OBJECT)) :DOCUMENTATION \"Evaluate `query', instantiate the query proposition for each generated\nsolution and assert the resulting propositions.  The accepted syntax\nis as follows:\n	 \n (assert-from-query <query-command>\n                    [:relation <relation-name>]\n                    [:pattern <description-term>]\n                    [:module <module-name>]\n                    [:record-justifications? TRUE|FALSE])\n	\n<query-command> has to be a strict or partial retrieval command. If a\n:relation option is supplied, <relation-name> is used as the relation\nof the resulting propositions.  In this case the bindings of each\nsolution will become arguments to the specified relation in the order\nof `query's output variables (the arities have to match).  The\n:pattern option is a generalization of this mechanism that specifies\nan arbitrary proposition pattern to be instantiated by the query's\nsolution.  In this case <description-term> has to be a SETOFALL or\nKAPPA expression whose IO-variables will be bound in sequence to the\nbindings of a query solution to generate the resulting proposition.\nFinally, if a :module option is specified, the assertions will be\ngenerated in that module.  Note that for this to work the relations\nreferenced in the query proposition or pattern have to be visible in\nthe module.  Also, instances will not be copied to the target module,\ntherefore, the resulting propositions might reference external\nout-of-module objects in case they are not visible there.  If\n:record-justifications? is TRUE, justifications will be recorded\nfor the query and the resulting justifications will be linked to\nthe asserted propositions.  Here are some examples:\n	 \n (assert-from-query (retrieve all (foo ?x ?y)))\n (assert-from-query (retrieve all (?y ?x)\n                             (exists ?z\n                               (and (foo ?x ?z)\n                                    (foo ?z ?y))))\n                    :relation bar :module other)\n (assert-from-query\n   (retrieve all (and (relation ?x) (symmetric ?x)))\n   :pattern (kappa (?pred)\n              (forall (?x ?y)\n                (=> (holds ?pred ?x ?y)\n                    (holds ?pred ?y ?x))))))\n	\n\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "assertFromQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "assertFromQueryEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("RETRACT-FROM-QUERY", "(DEFUN (RETRACT-FROM-QUERY (CONS OF PROPOSITION)) ((QUERY CONS) |&REST| (OPTIONS OBJECT)) :DOCUMENTATION \"Evaluate `query' which has to be a strict or partial retrieval\ncommand, instantiate the query proposition for each generated solution\nand retract the resulting propositions.  See `assert-from-query' for\navailable command options.\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "retractFromQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "retractFromQueryEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("DISPLAY-SETTINGS", "(DEFUN (DISPLAY-SETTINGS STRING) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "displaySettings", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("STARTUP-QUERY", "(DEFUN STARTUP-QUERY () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupQuery", "startupQuery", new java.lang.Class [] {}), null);
      { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_QUERY);

        KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupQuery"), Stella.NULL_STRING_WRAPPER);
      }
    }
  }

  public static void startupQuery() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupQuery.helpStartupQuery1();
          _StartupQuery.helpStartupQuery2();
          _StartupQuery.helpStartupQuery3();
          _StartupQuery.helpStartupQuery4();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          _StartupQuery.helpStartupQuery5();
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          _StartupQuery.helpStartupQuery6();
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupQuery.helpStartupQuery7();
          _StartupQuery.helpStartupQuery8();
          _StartupQuery.helpStartupQuery9();
          _StartupQuery.helpStartupQuery10();
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL NORMAL-INFERENCE NORMAL-INFERENCE-LEVEL (NEW NORMAL-INFERENCE-LEVEL :KEYWORD :NORMAL))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL BACKTRACKING-INFERENCE BACKTRACKING-INFERENCE-LEVEL (NEW BACKTRACKING-INFERENCE-LEVEL :KEYWORD :BACKTRACKING))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL SUBSUMPTION-INFERENCE SUBSUMPTION-INFERENCE-LEVEL (NEW SUBSUMPTION-INFERENCE-LEVEL :KEYWORD :SUBSUMPTION))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL SHALLOW-INFERENCE SHALLOW-INFERENCE-LEVEL (NEW SHALLOW-INFERENCE-LEVEL :KEYWORD :SHALLOW))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL ASSERTION-INFERENCE ASSERTION-INFERENCE-LEVEL (NEW ASSERTION-INFERENCE-LEVEL :KEYWORD :ASSERTION))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL REFUTATION-INFERENCE REFUTATION-INFERENCE-LEVEL (NEW REFUTATION-INFERENCE-LEVEL :KEYWORD :REFUTATION))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *INFERENCELEVEL* NORMAL-INFERENCE-LEVEL NORMAL-INFERENCE :DOCUMENTATION \"Specifies the level/depth of inference applied\nduring a query.  Possible values are:\n  :ASSERTION -- database lookup with no inheritance;\n  :SHALLOW -- includes database lookup, computed predicates and specialists;\n  :SUBSUMPTION -- shallow plus cached subsumption links and equality reasoning;\n  :BACKTRACKING -- all of the above plus backtracking over rules;\n  :NORMAL -- all of the above plus universal introduction;\n  :REFUTATION -- all of the above plus disjunctive implication introduction and refutation.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *DONTUSEDEFAULTKNOWLEDGE?* BOOLEAN FALSE :DOCUMENTATION \"Controls whether queries use default knowledge or not.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *MAXIMUM-BACKTRACKING-DEPTH* INTEGER *DEFAULT-MAXIMUM-DEPTH* :DOCUMENTATION \"Value for the maximum depth allowable during\nbacktrack search.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *TYPE-CHECK-STRATEGY* KEYWORD :LOOKUP :DOCUMENTATION \"Determines whether there is a slow but thorough type test\nwhen variables are bound, a fast but very shallow one, or none.  Values\nare :NONE, :LOOKUP, :DISJOINT.  The default is :LOOKUP.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *DUPLICATE-SUBGOAL-STRATEGY* KEYWORD :DUPLICATE-GOALS :DOCUMENTATION \"Determines what kind of duplicate subgoal test to use.  Choices\nare :DUPLICATE-RULES, :DUPLICATE-GOALS, and :DUPLICATE-GOALS-WITH-CACHING.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *DUPLICATE-GOAL-SEARCH-DEPTH* INTEGER NULL :DOCUMENTATION \"Sets the maximum number of frames search looking for\na duplicate subgoal.  Default value is infinite.  Possibly this should\nbe replaced by a function that increases with depth of search.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *DUPLICATE-RULE-SEARCH-DEPTH* INTEGER NULL :DOCUMENTATION \"Set limit on number of frames searched looking for\na duplicate rule.  Default value is infinite.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *GLOBALLY-CLOSED-COLLECTIONS?* BOOLEAN FALSE :DOCUMENTATION \"If TRUE, all collections are assumed to be closed.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *GENERATE-ALL-PROOFS?* BOOLEAN FALSE :DOCUMENTATION \"If TRUE, the backchainer follows all lines of proof\nfor each goal, rather than switching to a new goal once the first proof\nof a goal is achieved.  The partial matcher sets this variable to\nTRUE to force generation of proofs having possibly different\nweights.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *QUERYITERATOR* QUERY-ITERATOR NULL :DOCUMENTATION \"Points to the query iterator for the currently executing query.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *DEFAULT-MAXIMUM-DEPTH* INTEGER 25 :DOCUMENTATION \"Possibly a good value for the maximum backtracking depth.\nMore testing is needed.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *INITIAL-BACKTRACKING-DEPTH* INTEGER 5 :DOCUMENTATION \"Value of the initial depth used during an interative\ndeepening search.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *ITERATIVE-DEEPENING-MODE?* BOOLEAN FALSE :DOCUMENTATION \"Default setting.  If TRUE, queries are evaluated\nusing iterative deepening from depth '*initial-backtracking-depth*'\nto depth '*maximum-backtracking-depth*'.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *EMIT-THINKING-DOTS?* BOOLEAN TRUE :DOCUMENTATION \"When TRUE, various kinds of characters are\nemitted to STANDARD-OUTPUT while PowerLoom is 'thinking'.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *THINKING-DOT-COUNTER* INTEGER 0 :DOCUMENTATION \"Used to determine when to generate linefeeds\nafter forty-or-so thinking dots.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *THINKING-DOT-TABLE* (PROPERTY-LIST OF KEYWORD CHARACTER-WRAPPER) (NEW PROPERTY-LIST :THE-PLIST (BQUOTE (:UPCLASSIFY |&| (WRAP-LITERAL #\\u) :DOWNCLASSIFY |&| (WRAP-LITERAL #\\d) :PROPAGATE |&| (WRAP-LITERAL #\\f) :PARTIAL-MATCH |&| (WRAP-LITERAL #\\p)))) :DOCUMENTATION \"Maps kind of thinking keywords to characters.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *BOOLEAN-VECTOR-INDEX* BOOLEAN-VECTOR-INDEX-NODE (NEW BOOLEAN-VECTOR-INDEX-NODE :THE-VECTOR (NEW BOOLEAN-VECTOR :ARRAY-SIZE 0)) :DOCUMENTATION \"Points to the head of a discrimination tree of containing\nall boolean vectors.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *PRINTINFRAME* CONTROL-FRAME NULL :DOCUMENTATION \"If set, controls diagnostic printing by making\nvariable bindings appear relative to the frame '*printInFrame*'.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *TRACED-GOALS* (HASH-SET OF NAMED-DESCRIPTION NAMED-DESCRIPTION) (NEW HASH-SET))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CONTROL-FRAME-ID-COUNTER* INTEGER -1 :DOCUMENTATION \"Generates unique IDs for control frames.  Used only for debugging.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *REVERSEPOLARITY?* BOOLEAN FALSE :PUBLIC? TRUE :DOCUMENTATION \"Signals atomic proposition provers that polarity is negative.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *TRACE-DISJOINTNESS-SUBGOALS?* BOOLEAN FALSE :DOCUMENTATION \"If true and goal tracing is on, subgoals of disjointness\nqueries will also be traced.\" :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *DUPLICATEINSTANCESCACHECROSSOVERPOINT* INTEGER 20 :DOCUMENTATION \"Point where a cache of generated instances in a \ndescription extension iterator is switched from a list to a hash table\")");
          Logic.defineExplanationPhrase(Logic.KWD_DEPTH_CUTOFF, Logic.KWD_TECHNICAL, "because of an inference depth cutoff", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_DEPTH_CUTOFF, Logic.KWD_LAY, "because the maximum inference search depth was exceeded", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_TIMEOUT, Logic.KWD_TECHNICAL, "because of an inference timeout", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_TIMEOUT, Logic.KWD_LAY, "because the allotted inference CPU time was exceeded", Stella.NIL);
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *QUERY-ITERATOR-DEBUG-ID-COUNTER* INTEGER 0)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *MOST-RECENT-QUERY* QUERY-ITERATOR NULL)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *INLINE-QUERY-CACHE* (KEY-VALUE-MAP OF SYMBOL (LIST OF QUERY-ITERATOR)) (NEW KEY-VALUE-MAP) :DOCUMENTATION \"Caches queries used in-line by code, so that they don't have to\nbe reparsed and reoptimized each time they are invoked.\" :THREAD-LOCAL? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *MAX-CACHED-QUERIES-PER-ID* INTEGER 10)");
          Logic.defineExplanationPhrase(Logic.KWD_ASSERT_FROM_QUERY, Logic.KWD_TECHNICAL, "because it was asserted from a query", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_ASSERT_FROM_QUERY, Logic.KWD_LAY, "because it was asserted from a query", Stella.NIL);
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
