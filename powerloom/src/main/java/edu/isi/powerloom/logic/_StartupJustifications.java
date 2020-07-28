//  -*- Mode: Java -*-
//
// _StartupJustifications.java

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

public class _StartupJustifications {
  static void helpStartupJustifications1() {
    {
      Logic.SGT_LOGIC_JUSTIFICATION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("JUSTIFICATION", null, 1)));
      Logic.SYM_LOGIC_INFERENCE_RULE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INFERENCE-RULE", null, 0)));
      Logic.SYM_LOGIC_ANTECEDENTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ANTECEDENTS", null, 0)));
      Logic.SYM_LOGIC_SUBSTITUTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SUBSTITUTION", null, 0)));
      Logic.KWD_PRIMITIVE_STRATEGY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PRIMITIVE-STRATEGY", null, 2)));
      Logic.SGT_LOGIC_PRIMITIVE_STRATEGY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PRIMITIVE-STRATEGY", null, 1)));
      Logic.SYM_LOGIC_STRATEGY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STRATEGY", null, 0)));
      Logic.KWD_COMPUTED_PREDICATE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("COMPUTED-PREDICATE", null, 2)));
      Logic.KWD_SUBSUMPTION_REASONING = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SUBSUMPTION-REASONING", null, 2)));
      Logic.KWD_AND_INTRODUCTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("AND-INTRODUCTION", null, 2)));
      Logic.KWD_MODUS_TOLLENS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MODUS-TOLLENS", null, 2)));
      Logic.KWD_MODUS_PONENS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MODUS-PONENS", null, 2)));
      Logic.KWD_AMPLIFICATION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("AMPLIFICATION", null, 2)));
      Logic.KWD_PARTIAL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PARTIAL", null, 2)));
      Logic.KWD_REVERSE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("REVERSE", null, 2)));
      Logic.KWD_OR_INTRODUCTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("OR-INTRODUCTION", null, 2)));
      Logic.KWD_DISPROOF = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DISPROOF", null, 2)));
      Logic.KWD_FAIL_INTRODUCTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FAIL-INTRODUCTION", null, 2)));
      Logic.KWD_NEGATED_FAIL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NEGATED-FAIL", null, 2)));
      Logic.KWD_CLOSED_NOT_INTRODUCTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CLOSED-NOT-INTRODUCTION", null, 2)));
      Logic.KWD_EXISTENTIAL_INTRODUCTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("EXISTENTIAL-INTRODUCTION", null, 2)));
      Logic.KWD_RAW = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("RAW", null, 2)));
      Logic.KWD_INFERENCE_RULE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INFERENCE-RULE", null, 2)));
      Logic.KWD_TRUTH_VALUE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TRUTH-VALUE", null, 2)));
      Logic.KWD_POSITIVE_SCORE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("POSITIVE-SCORE", null, 2)));
      Logic.KWD_SUBSTITUTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SUBSTITUTION", null, 2)));
      Logic.SGT_LOGIC_FORWARD_GOAL_RECORD = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FORWARD-GOAL-RECORD", null, 1)));
      Logic.SYM_LOGIC_FORWARD_RULE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FORWARD-RULE", null, 0)));
      Logic.SYM_LOGIC_FORWARD_CHAINING_GOALS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FORWARD-CHAINING-GOALS", null, 0)));
      Logic.SGT_LOGIC_FORWARD_JUSTIFICATION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FORWARD-JUSTIFICATION", null, 1)));
      Logic.SYM_LOGIC_FORWARD_JUSTIFICATIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FORWARD-JUSTIFICATIONS", null, 0)));
      Logic.KWD_FORWARD_INFERENCE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FORWARD-INFERENCE", null, 2)));
      Logic.SGT_LOGIC_CLASH_JUSTIFICATION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASH-JUSTIFICATION", null, 1)));
      Logic.SYM_LOGIC_DIRECTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DIRECTION", null, 0)));
      Logic.KWD_CLASH = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASH", null, 2)));
      Logic.SYM_LOGIC_STARTUP_JUSTIFICATIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-JUSTIFICATIONS", null, 0)));
    }
  }

  static void helpStartupJustifications2() {
    {
      Stella.defineFunctionObject("JUSTIFICATION-ARGUMENT-BOUND-TO", "(DEFUN (JUSTIFICATION-ARGUMENT-BOUND-TO OBJECT) ((ARGUMENT OBJECT) (JUSTIFICATION JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "justificationArgumentBoundTo", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
      Stella.defineFunctionObject("JUSTIFICATION-EQL?", "(DEFUN (JUSTIFICATION-EQL? BOOLEAN) ((JUST1 JUSTIFICATION) (JUST2 JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "justificationEqlP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
      Stella.defineFunctionObject("JUSTIFICATION-PROPOSITIONS-EQL?", "(DEFUN (JUSTIFICATION-PROPOSITIONS-EQL? BOOLEAN) ((PROPOSITION1 PROPOSITION) (JUST1 JUSTIFICATION) (PROPOSITION2 PROPOSITION) (JUST2 JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "justificationPropositionsEqlP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
      Stella.defineMethodObject("(DEFMETHOD (COPY (LIKE SELF)) ((SELF JUSTIFICATION)) :DOCUMENTATION \"Return a copy of the proof starting at `self'.  Allocates\nall new justification objects, but structure-shares other information such\nas propositions and substitutions.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Justification", "copy", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (SHALLOW-COPY (LIKE SELF)) ((SELF JUSTIFICATION)) :DOCUMENTATION \"Similar to `copy' but does not copy antecedent justifications.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Justification", "shallowCopy", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("RECORD-JUSTIFICATIONS?", "(DEFUN (RECORD-JUSTIFICATIONS? BOOLEAN) () :DOCUMENTATION \"Return TRUE if every query records justifications to enable\nthe explanation of concluded results.\" :GLOBALLY-INLINE? TRUE (RETURN *RECORD-JUSTIFICATIONS?*))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "recordJustificationsP", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("RECORD-GOAL-JUSTIFICATION", "(DEFUN RECORD-GOAL-JUSTIFICATION ((GOAL CONTROL-FRAME) (JUSTIFICATION JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "recordGoalJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
      Stella.defineFunctionObject("RECORD-PRIMITIVE-JUSTIFICATION", "(DEFUN RECORD-PRIMITIVE-JUSTIFICATION ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "recordPrimitiveJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("RECORD-PATTERN-JUSTIFICATION", "(DEFUN RECORD-PATTERN-JUSTIFICATION ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "recordPatternJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("BACKLINK-TO-PATTERN-JUSTIFICATION", "(DEFUN BACKLINK-TO-PATTERN-JUSTIFICATION ((JUSTIFICATION JUSTIFICATION) (PATTERN JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "backlinkToPatternJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
      Stella.defineFunctionObject("RECORD-MODUS-PONENS-JUSTIFICATION", "(DEFUN RECORD-MODUS-PONENS-JUSTIFICATION ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "recordModusPonensJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("RECORD-AND-INTRODUCTION-JUSTIFICATION", "(DEFUN RECORD-AND-INTRODUCTION-JUSTIFICATION ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "recordAndIntroductionJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("RECORD-OR-INTRODUCTION-JUSTIFICATION", "(DEFUN RECORD-OR-INTRODUCTION-JUSTIFICATION ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "recordOrIntroductionJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("RECORD-DISPROOF-JUSTIFICATION", "(DEFUN RECORD-DISPROOF-JUSTIFICATION ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "recordDisproofJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("RECORD-FAIL-JUSTIFICATION", "(DEFUN RECORD-FAIL-JUSTIFICATION ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "recordFailJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("RECORD-NEGATED-FAIL-JUSTIFICATION", "(DEFUN RECORD-NEGATED-FAIL-JUSTIFICATION ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "recordNegatedFailJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("RECORD-CLOSED-NOT-JUSTIFICATION", "(DEFUN RECORD-CLOSED-NOT-JUSTIFICATION ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "recordClosedNotJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("RECORD-EXISTENTIAL-INTRODUCTION-JUSTIFICATION", "(DEFUN RECORD-EXISTENTIAL-INTRODUCTION-JUSTIFICATION ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.ControlFrame", "recordExistentialIntroductionJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("FAILED-GOAL-JUSTIFICATION?", "(DEFUN (FAILED-GOAL-JUSTIFICATION? BOOLEAN) ((SELF JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "failedGoalJustificationP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
      Stella.defineFunctionObject("CUTOFF-GOAL-JUSTIFICATION?", "(DEFUN (CUTOFF-GOAL-JUSTIFICATION? BOOLEAN) ((SELF JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "cutoffGoalJustificationP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
      Stella.defineMethodObject("(DEFMETHOD (CONSIFY CONS) ((SELF JUSTIFICATION)) :DOCUMENTATION \"Return a CONS tree representation of the proof `self'.\nEach proof step is represented as a CONS tree of the form\n  (<proposition> (<key> <value>...) <antecedent>...)\nwhere each <antecedent> is a CONS tree representing a subproof.  The\nconsification follows the original proof structure literally, i.e., no\nuninteresting nodes such as patterns or AND-introductions are suppressed.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Justification", "consify", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("CONSIFY-JUSTIFICATION", "(DEFUN (CONSIFY-JUSTIFICATION CONS) ((SELF JUSTIFICATION) (STYLE KEYWORD)) :DOCUMENTATION \"Return a CONS tree representation of the proof `self'.\nEach proof step is represented as a CONS tree of the form\n  (<proposition> (<key> <value>...) <antecedent>...)\nwhere each <antecedent> is a CONS tree representing a subproof.\n`style' indicates what nodes in the proof tree should be suppressed.\n:RAW preserves the original structure literally, :VERBOSE keeps AND-\nintroductions but suppresses all auxiliary (non-logical) nodes such as\npattern nodes, and :BRIEF additionally suppresses AND-introduction nodes.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Justification", "consifyJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("GET-QUERY-JUSTIFICATIONS", "(DEFUN (GET-QUERY-JUSTIFICATIONS (LIST OF JUSTIFICATION)) ((QUERY QUERY-ITERATOR) (SOLUTIONINDEX INTEGER) (MAXJUSTIFICATIONS INTEGER) (CREATE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "getQueryJustifications", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator"), java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("DERIVE-QUERY-JUSTIFICATIONS", "(DEFUN (DERIVE-QUERY-JUSTIFICATIONS (LIST OF JUSTIFICATION)) ((QUERY QUERY-ITERATOR) (OPTIONS OBJECT) (SOLUTIONINDEX INTEGER) (MAXJUSTIFICATIONS INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "deriveQueryJustifications", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Integer.TYPE, java.lang.Integer.TYPE}), null);
      Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT PROPOSITION FORWARD-CHAINING-GOALS :TYPE (LIST OF FORWARD-GOAL-RECORD) :ALLOCATION :DYNAMIC)");
      Stella.defineMethodObject("(DEFMETHOD (DELETED? BOOLEAN) ((SELF FORWARD-GOAL-RECORD)))", Native.find_java_method("edu.isi.powerloom.logic.ForwardGoalRecord", "deletedP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (DELETED?-SETTER BOOLEAN) ((SELF FORWARD-GOAL-RECORD) (VALUE BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.ForwardGoalRecord", "deletedPSetter", new java.lang.Class [] {java.lang.Boolean.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("RECORD-FORWARD-GOAL", "(DEFUN RECORD-FORWARD-GOAL ((FORWARDRULE PROPOSITION) (ARGUMENTS ARGUMENTS-VECTOR) (CONSEQUENTPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "recordForwardGoal", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("PREDICATION?", "(DEFUN (PREDICATION? BOOLEAN) ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "predicationP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("ASSERTED-AS-TRUE?", "(DEFUN (ASSERTED-AS-TRUE? BOOLEAN) ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "assertedAsTrueP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("ELABORATION-RULE?", "(DEFUN (ELABORATION-RULE? BOOLEAN) ((CONSEQUENTPROPOSITION PROPOSITION) (FORWARDRULE PROPOSITION) (ARGUMENTS ARGUMENTS-VECTOR)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "elaborationRuleP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("GET-FORWARD-GOALS", "(DEFUN (GET-FORWARD-GOALS (LIST OF FORWARD-GOAL-RECORD)) ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "getForwardGoals", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT PROPOSITION FORWARD-JUSTIFICATIONS :TYPE (LIST OF JUSTIFICATION) :ALLOCATION :DYNAMIC)");
      Stella.defineFunctionObject("HAS-FORWARD-JUSTIFICATIONS?", "(DEFUN (HAS-FORWARD-JUSTIFICATIONS? BOOLEAN) ((PROPOSITION PROPOSITION)) :DOCUMENTATION \"Return TRUE if `proposition' has any forward justifications.\" :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (NON-EMPTY? (FORWARD-JUSTIFICATIONS PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "hasForwardJustificationsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("GET-FORWARD-JUSTIFICATIONS", "(DEFUN (GET-FORWARD-JUSTIFICATIONS (LIST OF JUSTIFICATION)) ((PROPOSITION PROPOSITION)) :DOCUMENTATION \"Return `proposition's forward justifications.\" :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (FORWARD-JUSTIFICATIONS PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "getForwardJustifications", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("ADD-FORWARD-JUSTIFICATIONS", "(DEFUN ADD-FORWARD-JUSTIFICATIONS ((PROPOSITION PROPOSITION) (JUSTIFICATION JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "addForwardJustifications", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
      Stella.defineFunctionObject("GET-RULE-IO-VARIABLES", "(DEFUN (GET-RULE-IO-VARIABLES VARIABLES-VECTOR) ((RULE PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "getRuleIoVariables", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("CREATE-FORWARD-JUSTIFICATION", "(DEFUN (CREATE-FORWARD-JUSTIFICATION FORWARD-JUSTIFICATION) ((ANTECEDENTS (CONS OF PROPOSITION)) (FORWARDRULE PROPOSITION) (ARGUMENTS ARGUMENTS-VECTOR) (CONSEQUENTPROPOSITION PROPOSITION) (BC-JUSTIFICATION JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createForwardJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
      Stella.defineFunctionObject("GET-FORWARD-ANTECEDENT-JUSTIFICATION", "(DEFUN (GET-FORWARD-ANTECEDENT-JUSTIFICATION JUSTIFICATION) ((ANTECEDENT PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "getForwardAntecedentJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("RECORD-FORWARD-JUSTIFICATION", "(DEFUN RECORD-FORWARD-JUSTIFICATION ((ANTECEDENTS (CONS OF PROPOSITION)) (FORWARDRULE PROPOSITION) (ARGUMENTS ARGUMENTS-VECTOR) (CONSEQUENTPROPOSITION PROPOSITION) (BC-JUSTIFICATION JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "recordForwardJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
      Stella.defineFunctionObject("CREATE-SUBSET-JUSTIFICATION", "(DEFUN (CREATE-SUBSET-JUSTIFICATION JUSTIFICATION) ((MAIN-PROPOSITION PROPOSITION) (MATCHING-PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "createSubsetJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("CREATE-CLASH-JUSTIFICATION", "(DEFUN (CREATE-CLASH-JUSTIFICATION CLASH-JUSTIFICATION) ((PROP PROPOSITION) (ANTECEDENTS (CONS OF JUSTIFICATION)) (DIRECTION KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "createClashJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("STARTUP-JUSTIFICATIONS", "(DEFUN STARTUP-JUSTIFICATIONS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupJustifications", "startupJustifications", new java.lang.Class [] {}), null);
      { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_JUSTIFICATIONS);

        KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupJustifications"), Stella.NULL_STRING_WRAPPER);
      }
    }
  }

  public static void startupJustifications() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupJustifications.helpStartupJustifications1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Logic.$RECORD_JUSTIFICATIONSp$.setDefaultValue(new Boolean(false));
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("JUSTIFICATION", "(DEFCLASS JUSTIFICATION (STANDARD-OBJECT) :SLOTS ((INFERENCE-RULE :TYPE KEYWORD :DOCUMENTATION \"Keyword describing the inference rule used to conclude the\nproposition of this justification.\") (PROPOSITION :TYPE PROPOSITION :DOCUMENTATION \"The proposition supported by this justification.\") (ANTECEDENTS :TYPE (CONS OF JUSTIFICATION) :INITIALLY NIL :DOCUMENTATION \"Antecedents justifications of this justification.\") (SUBSTITUTION :TYPE (ENTITY-MAPPING OF PATTERN-VARIABLE OBJECT) :DOCUMENTATION \"List of variable bindings recorded for this justification.\") (REVERSE-POLARITY? :TYPE BOOLEAN :DOCUMENTATION \"True if proposition was derived in reverse polarity.\") (TRUTH-VALUE :TYPE TRUTH-VALUE :DOCUMENTATION \"Truth value of the derived proposition.\") (POSITIVE-SCORE :TYPE PARTIAL-MATCH-SCORE :DOCUMENTATION \"Positive partial match score of the derived proposition.\") (NEGATIVE-SCORE :TYPE PARTIAL-MATCH-SCORE :DOCUMENTATION \"Negative partial match score of the derived proposition.\")) :METHODS ((INFERENCE-STRATEGY ((SELF JUSTIFICATION)) :TYPE KEYWORD (RETURN NULL)) (INFERENCE-DIRECTION ((SELF JUSTIFICATION)) :TYPE KEYWORD (RETURN :BACKWARD))))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.Justification", "newJustification", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.Justification", "accessJustificationSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("PRIMITIVE-STRATEGY", "(DEFCLASS PRIMITIVE-STRATEGY (JUSTIFICATION) :SLOTS ((INFERENCE-RULE :TYPE KEYWORD :INITIALLY :PRIMITIVE-STRATEGY) (STRATEGY :TYPE KEYWORD)) :METHODS ((INFERENCE-STRATEGY ((SELF PRIMITIVE-STRATEGY)) :TYPE KEYWORD (RETURN (STRATEGY SELF)))))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.PrimitiveStrategy", "newPrimitiveStrategy", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.PrimitiveStrategy", "accessPrimitiveStrategySlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PrimitiveStrategy"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("FORWARD-GOAL-RECORD", "(DEFCLASS FORWARD-GOAL-RECORD (STANDARD-OBJECT) :SLOTS ((FORWARD-GOAL :TYPE PROPOSITION) (FORWARD-RULE :TYPE PROPOSITION)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ForwardGoalRecord", "newForwardGoalRecord", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.ForwardGoalRecord", "accessForwardGoalRecordSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ForwardGoalRecord"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("FORWARD-JUSTIFICATION", "(DEFCLASS FORWARD-JUSTIFICATION (JUSTIFICATION) :METHODS ((INFERENCE-DIRECTION ((SELF FORWARD-JUSTIFICATION)) :TYPE KEYWORD (RETURN :FORWARD))))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ForwardJustification", "newForwardJustification", new java.lang.Class [] {});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CLASH-JUSTIFICATION", "(DEFCLASS CLASH-JUSTIFICATION (JUSTIFICATION) :SLOTS ((DIRECTION :TYPE KEYWORD :INITIALLY :FORWARD :DOCUMENTATION \"The inference direction for this inference.\")) :METHODS ((INFERENCE-DIRECTION ((SELF CLASH-JUSTIFICATION)) :TYPE KEYWORD (RETURN (DIRECTION SELF)))))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ClashJustification", "newClashJustification", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.ClashJustification", "accessClashJustificationSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ClashJustification"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupJustifications.helpStartupJustifications2();
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *RECORD-JUSTIFICATIONS?* BOOLEAN FALSE :DOCUMENTATION \"If TRUE every query records justifications to enable\nthe explanation of concluded results.\")");
          Logic.defineExplanationPhrase(Logic.KWD_SCAN_COLLECTION, Logic.KWD_TECHNICAL, "by explicit assertion", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_SCAN_PROPOSITIONS, Logic.KWD_TECHNICAL, "by explicit assertion", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_LOOKUP_ASSERTIONS, Logic.KWD_TECHNICAL, "by explicit assertion", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_SCAN_COLLECTION, Logic.KWD_LAY, "because the system was told this fact", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_SCAN_PROPOSITIONS, Logic.KWD_LAY, "because the system was told this fact", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_LOOKUP_ASSERTIONS, Logic.KWD_LAY, "because the system was told this fact", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_SPECIALIST, Logic.KWD_TECHNICAL, "because it was proven by an inference specialist", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_SPECIALIST, Logic.KWD_LAY, "because of a specialized reasoning procedure", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_COMPUTED_PREDICATE, Logic.KWD_TECHNICAL, "because of a computation", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_COMPUTED_PREDICATE, Logic.KWD_LAY, "because of a computation", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_GOAL_COMPLEMENT, Logic.KWD_TECHNICAL, "because its argument was proven false", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_GOAL_COMPLEMENT, Logic.KWD_LAY, "because its argument is false", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_EQUIVALENCE, Logic.KWD_TECHNICAL, "from equivalence", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_EQUIVALENCE, Logic.KWD_LAY, "because its arguments are equivalent", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_SUBSUMPTION_TEST, Logic.KWD_TECHNICAL, "because of a successful subsumption test", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_SUBSUMPTION_TEST, Logic.KWD_LAY, "because of a successful subsumption test", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_SUBSUMPTION_REASONING, Logic.KWD_TECHNICAL, "because a subsumed relation is true", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_SUBSUMPTION_REASONING, Logic.KWD_LAY, "because of it is true of a relation that is a subset of the one we want", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_FAILURE, Logic.KWD_TECHNICAL, "could not be proven", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_FAILURE, Logic.KWD_LAY, "could not be proven", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_MODUS_PONENS, Logic.KWD_TECHNICAL, "by Modus Ponens", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_MODUS_PONENS, Logic.KWD_LAY, "because an if-then rule applies", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_MODUS_TOLLENS, Logic.KWD_TECHNICAL, "by Modus Tollens", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_MODUS_TOLLENS, Logic.KWD_TECHNICAL, "(p => q, ~q |= ~p)", Cons.cons(Logic.KWD_AMPLIFICATION, Stella.NIL));
          Logic.defineExplanationPhrase(Logic.KWD_MODUS_TOLLENS, Logic.KWD_LAY, "because an if-then rule was used backwards", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_MODUS_TOLLENS, Logic.KWD_LAY, "(if P then Q with Q false allows us to conclude P)", Cons.cons(Logic.KWD_AMPLIFICATION, Stella.NIL));
          Logic.defineExplanationPhrase(Logic.KWD_AND_INTRODUCTION, Logic.KWD_TECHNICAL, "by And-Introduction", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_AND_INTRODUCTION, Logic.KWD_LAY, "because all parts of an AND expression were true", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_AND_INTRODUCTION, Logic.KWD_LAY, "because parts of an AND expression were true", Cons.cons(Logic.KWD_PARTIAL, Stella.NIL));
          Logic.defineExplanationPhrase(Logic.KWD_AND_INTRODUCTION, Logic.KWD_TECHNICAL, "by Not-Or-Introduction", Cons.cons(Logic.KWD_REVERSE, Stella.NIL));
          Logic.defineExplanationPhrase(Logic.KWD_AND_INTRODUCTION, Logic.KWD_LAY, "because all parts of an OR expression were false", Cons.cons(Logic.KWD_REVERSE, Stella.NIL));
          Logic.defineExplanationPhrase(Logic.KWD_AND_INTRODUCTION, Logic.KWD_TECHNICAL, "(~p, ~q |= ~(p v q))", Cons.cons(Logic.KWD_REVERSE, Cons.cons(Logic.KWD_AMPLIFICATION, Stella.NIL)));
          Logic.defineExplanationPhrase(Logic.KWD_AND_INTRODUCTION, Logic.KWD_LAY, "(therefore the OR is also false)", Cons.cons(Logic.KWD_REVERSE, Cons.cons(Logic.KWD_AMPLIFICATION, Stella.NIL)));
          Logic.defineExplanationPhrase(Logic.KWD_OR_INTRODUCTION, Logic.KWD_TECHNICAL, "by Or-Introduction", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_OR_INTRODUCTION, Logic.KWD_LAY, "because at least one part of an OR expression was true", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_OR_INTRODUCTION, Logic.KWD_TECHNICAL, "by Not-And-Introduction", Cons.cons(Logic.KWD_REVERSE, Stella.NIL));
          Logic.defineExplanationPhrase(Logic.KWD_OR_INTRODUCTION, Logic.KWD_LAY, "because at least one part of an AND expression was false", Cons.cons(Logic.KWD_REVERSE, Stella.NIL));
          Logic.defineExplanationPhrase(Logic.KWD_OR_INTRODUCTION, Logic.KWD_TECHNICAL, "(~p |= ~(p & q))", Cons.cons(Logic.KWD_REVERSE, Cons.cons(Logic.KWD_AMPLIFICATION, Stella.NIL)));
          Logic.defineExplanationPhrase(Logic.KWD_OR_INTRODUCTION, Logic.KWD_LAY, "(therefore the AND is also false)", Cons.cons(Logic.KWD_REVERSE, Cons.cons(Logic.KWD_AMPLIFICATION, Stella.NIL)));
          Logic.defineExplanationPhrase(Logic.KWD_DISPROOF, Logic.KWD_TECHNICAL, "by disproof", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_DISPROOF, Logic.KWD_LAY, "by proving the negation", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_DISPROOF, Logic.KWD_TECHNICAL, "by Double-Negation-Introduction", Cons.cons(Logic.KWD_REVERSE, Stella.NIL));
          Logic.defineExplanationPhrase(Logic.KWD_DISPROOF, Logic.KWD_LAY, "by negating a negation", Cons.cons(Logic.KWD_REVERSE, Stella.NIL));
          Logic.defineExplanationPhrase(Logic.KWD_FAIL_INTRODUCTION, Logic.KWD_TECHNICAL, "because the argument proposition was not derivable", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_FAIL_INTRODUCTION, Logic.KWD_LAY, "because the argument proposition could not be proven", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_NEGATED_FAIL, Logic.KWD_TECHNICAL, "because the argument proposition was derived and the fail is has negative polarity", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_NEGATED_FAIL, Logic.KWD_LAY, "because the argument proposition could be proven and we are trying to disprove the fail", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_CLOSED_NOT_INTRODUCTION, Logic.KWD_TECHNICAL, "because the argument proposition was not derivable and it uses closed-world semantics", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_CLOSED_NOT_INTRODUCTION, Logic.KWD_LAY, "because the argument proposition could not be proven and it is a closed-world proposition", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_EXISTENTIAL_INTRODUCTION, Logic.KWD_TECHNICAL, "by Existential Introduction", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_EXISTENTIAL_INTRODUCTION, Logic.KWD_LAY, "because it was true for at least one case", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_FORWARD_INFERENCE, Logic.KWD_TECHNICAL, "by Forward Inference", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_FORWARD_INFERENCE, Logic.KWD_LAY, "by forward rule reasoning", Stella.NIL);
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
