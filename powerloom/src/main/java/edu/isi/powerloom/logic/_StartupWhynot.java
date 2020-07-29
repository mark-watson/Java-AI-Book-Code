//  -*- Mode: Java -*-
//
// _StartupWhynot.java

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

public class _StartupWhynot {
  static void helpStartupWhynot1() {
    {
      Logic.SYM_LOGIC_UNKNOWN_GOAL_CUTOFF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UNKNOWN-GOAL-CUTOFF", null, 0)));
      Logic.SGT_LOGIC_WHYNOT_DEEP_PARTIAL_MATCH = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("WHYNOT-DEEP-PARTIAL-MATCH", null, 1)));
      Logic.SGT_LOGIC_M_WHYNOT_PARTIAL_MATCHdNUMBER_OF_FAILED_SUBGOALS_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("M-WHYNOT-PARTIAL-MATCH.NUMBER-OF-FAILED-SUBGOALS-MEMO-TABLE-000", null, 1)));
      Logic.SYM_LOGIC_REAL_ALLOTTED_CLOCK_TICKS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("REAL-ALLOTTED-CLOCK-TICKS", null, 0)));
      Logic.SGT_STELLA_CONS_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONS-ITERATOR", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_LOGIC_WHYNOT_PROOF_CLASS = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("WHYNOT-PROOF-CLASS", null, 1)));
      Logic.SYM_LOGIC_REPRESENTATIVE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("REPRESENTATIVE", null, 0)));
      Logic.SYM_LOGIC_DEVIATING_PATTERN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEVIATING-PATTERN", null, 0)));
      Logic.SYM_LOGIC_DEVIATING_VARIABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEVIATING-VARIABLE", null, 0)));
      Logic.SYM_LOGIC_DEVIATING_INSTANCES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEVIATING-INSTANCES", null, 0)));
      Logic.SYM_LOGIC_THE_VARIABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("THE-VARIABLE", null, 0)));
      Logic.KWD_WHYNOT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("WHYNOT", null, 2)));
      Logic.KWD_JUSTIFICATIONS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("JUSTIFICATIONS", null, 2)));
      Logic.SYM_LOGIC_STARTUP_WHYNOT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-WHYNOT", null, 0)));
    }
  }

  public static void startupWhynot() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupWhynot.helpStartupWhynot1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Logic.$MAX_WHYNOT_PROOF_CLASS_DEVIATIONS$.setDefaultValue(new Integer(1));
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("WHYNOT-PARTIAL-MATCH", "(DEFCLASS WHYNOT-PARTIAL-MATCH (INCREMENTAL-PARTIAL-MATCH) :DOCUMENTATION \"Variant of :BASIC partial match strategy to support WHYNOT queries.\" :SLOTS ((UNKNOWN-GOAL-CUTOFF :TYPE INTEGER :INITIALLY NULL)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.WhynotPartialMatch", "newWhynotPartialMatch", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.WhynotPartialMatch", "accessWhynotPartialMatchSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.WhynotPartialMatch"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("WHYNOT-DEEP-PARTIAL-MATCH", "(DEFCLASS WHYNOT-DEEP-PARTIAL-MATCH (WHYNOT-PARTIAL-MATCH) :DOCUMENTATION \"Variant of WhyNot partial match geared towards deep proofs.\")");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.WhynotDeepPartialMatch", "newWhynotDeepPartialMatch", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("WHYNOT-PROOF-CLASS", "(DEFCLASS WHYNOT-PROOF-CLASS (SET) :DOCUMENTATION \"Set of equivalent WhyNot proofs that differ in at most one\nvariable binding all on the same `deviating-variable'.\" :PARAMETERS ((ANY-VALUE :TYPE JUSTIFICATION)) :SLOTS ((REPRESENTATIVE :TYPE JUSTIFICATION) (DEVIATING-PATTERN :TYPE JUSTIFICATION) (DEVIATING-VARIABLE :TYPE PATTERN-VARIABLE) (DEVIATING-INSTANCES :TYPE LIST :INITIALLY (NEW LIST))))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.WhynotProofClass", "newWhynotProofClass", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.WhynotProofClass", "accessWhynotProofClassSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.WhynotProofClass"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("ALTERNATIVE-BINDINGS-SET", "(DEFCLASS ALTERNATIVE-BINDINGS-SET (THING) :DOCUMENTATION \"Represents a set of alternative bindings collected for the pattern\nvariable `(the-variable self)'.\" :SLOTS ((THE-VARIABLE :TYPE PATTERN-VARIABLE) (BINDINGS :TYPE SET :INITIALLY (NEW SET)) (SURROGATE-VALUE-INVERSE :INITIALLY @ALTERNATIVE-BINDINGS-SET)) :PRINT-FORM (PRINT-STREAM STREAM (STRING-DOWNCASE (GET-SKOLEM-PRINT-NAME (THE-VARIABLE SELF)))))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.AlternativeBindingsSet", "newAlternativeBindingsSet", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.AlternativeBindingsSet", "accessAlternativeBindingsSetSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.AlternativeBindingsSet"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("WHYNOT-PARTIAL-MATCH-MODE?", "(DEFUN (WHYNOT-PARTIAL-MATCH-MODE? BOOLEAN) () :GLOBALLY-INLINE? TRUE (RETURN (AND (PARTIAL-MATCH-MODE?) (ISA? (PARTIAL-MATCH-STRATEGY *QUERYITERATOR*) @WHYNOT-PARTIAL-MATCH))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "whynotPartialMatchModeP", new java.lang.Class [] {}), null);
          Stella.defineMethodObject("(DEFMETHOD (CREATE-PARTIAL-MATCH-FRAME WHYNOT-PARTIAL-MATCH) ((SELF WHYNOT-PARTIAL-MATCH) (FRAME CONTROL-FRAME) (KIND KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.WhynotPartialMatch", "createPartialMatchFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (CREATE-PARTIAL-MATCH-FRAME WHYNOT-DEEP-PARTIAL-MATCH) ((SELF WHYNOT-DEEP-PARTIAL-MATCH) (FRAME CONTROL-FRAME) (KIND KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.WhynotDeepPartialMatch", "createPartialMatchFrame", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD SET-DYNAMIC-CUTOFF ((SELF WHYNOT-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.WhynotPartialMatch", "setDynamicCutoff", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (COMPUTE-UNKNOWN-GOAL-CUTOFF INTEGER) ((SELF WHYNOT-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.WhynotPartialMatch", "computeUnknownGoalCutoff", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (NUMBER-OF-FAILED-SUBGOALS INTEGER) ((SELF WHYNOT-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.WhynotPartialMatch", "numberOfFailedSubgoals", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("COMPUTE-NUMBER-OF-FAILED-SUBGOALS", "(DEFUN (COMPUTE-NUMBER-OF-FAILED-SUBGOALS INTEGER) ((PROOF JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "computeNumberOfFailedSubgoals", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
          Stella.defineMethodObject("(DEFMETHOD (CUTOFF-PARTIAL-MATCH? BOOLEAN) ((SELF WHYNOT-PARTIAL-MATCH) (TRACE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.WhynotPartialMatch", "cutoffPartialMatchP", new java.lang.Class [] {java.lang.Boolean.TYPE}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("AUXILIARY-EQUIVALENCE-PROPOSITION?", "(DEFUN (AUXILIARY-EQUIVALENCE-PROPOSITION? BOOLEAN) ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "auxiliaryEquivalencePropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineMethodObject("(DEFMETHOD (PROPOSITION-WEIGHT FLOAT) ((SELF WHYNOT-PARTIAL-MATCH) (PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.WhynotPartialMatch", "propositionWeight", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), ((java.lang.reflect.Method)(null)));
          Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT CONTROL-FRAME REAL-ALLOTTED-CLOCK-TICKS :TYPE INTEGER :ALLOCATION :DYNAMIC)");
          Stella.defineMethodObject("(DEFMETHOD (CONTINUE-PARTIAL-AND-PROOF KEYWORD) ((SELF WHYNOT-PARTIAL-MATCH) (FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.WhynotPartialMatch", "continuePartialAndProof", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("NUMBER-OF-REMAINING-ANTECEDENTS", "(DEFUN (NUMBER-OF-REMAINING-ANTECEDENTS INTEGER) ((ITERATOR ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "numberOfRemainingAntecedents", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Iterator")}), null);
          Stella.defineMethodObject("(DEFMETHOD (CHAINING-DEPTH-DEGRADATION FLOAT) ((SELF WHYNOT-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.WhynotPartialMatch", "chainingDepthDegradation", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (CHAINING-DEPTH-DEGRADATION FLOAT) ((SELF WHYNOT-DEEP-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.WhynotDeepPartialMatch", "chainingDepthDegradation", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (CONTINUE-PARTIAL-ANTECEDENTS-PROOF KEYWORD) ((SELF WHYNOT-PARTIAL-MATCH) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.WhynotPartialMatch", "continuePartialAntecedentsProof", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (MAX-UNCONSTRAINED-FANOUT FLOAT) ((SELF WHYNOT-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.WhynotPartialMatch", "maxUnconstrainedFanout", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (MAX-UNCONSTRAINED-FANOUT FLOAT) ((SELF WHYNOT-DEEP-PARTIAL-MATCH)))", Native.find_java_method("edu.isi.powerloom.logic.WhynotDeepPartialMatch", "maxUnconstrainedFanout", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (SKIP-AND-CLAUSE? BOOLEAN) ((SELF WHYNOT-PARTIAL-MATCH) (FRAME CONTROL-FRAME) (FORBIDDENVARS (CONS OF PATTERN-VARIABLE))))", Native.find_java_method("edu.isi.powerloom.logic.WhynotPartialMatch", "skipAndClauseP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Cons")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD INITIALIZE-PARTIAL-MATCH-STRATEGY ((SELF WHYNOT-PARTIAL-MATCH) (QUERY QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.WhynotPartialMatch", "initializePartialMatchStrategy", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator")}), ((java.lang.reflect.Method)(null)));
          Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT CONTROL-FRAME ALL-JUSTIFICATIONS :TYPE (LIST OF JUSTIFICATION) :ALLOCATION :DYNAMIC)");
          Stella.defineMethodObject("(DEFMETHOD (COMPUTE-PARTIAL-TRUTH FLOAT) ((SELF WHYNOT-PARTIAL-MATCH) (QUERY QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.WhynotPartialMatch", "computePartialTruth", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator")}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("BETTER-WHYNOT-PROOF?", "(DEFUN (BETTER-WHYNOT-PROOF? BOOLEAN) ((PROOF1 JUSTIFICATION) (PROOF2 JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "betterWhynotProofP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
          Stella.defineFunctionObject("COMPUTE-PROOF-DEVIATION", "(DEFUN (COMPUTE-PROOF-DEVIATION INTEGER) ((PROOF1 JUSTIFICATION) (PROOF2 JUSTIFICATION) (MAXDEVIATIONS INTEGER) (DEVIATIONS (KEY-VALUE-LIST OF JUSTIFICATION JUSTIFICATION))))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "computeProofDeviation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.powerloom.logic.Justification"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
          Stella.defineFunctionObject("INSERT-WHYNOT-PROOF-TO-CLASS?", "(DEFUN (INSERT-WHYNOT-PROOF-TO-CLASS? BOOLEAN) ((CLASS WHYNOT-PROOF-CLASS) (PROOF JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.WhynotProofClass", "insertWhynotProofToClassP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.WhynotProofClass"), Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
          Stella.defineFunctionObject("INSERT-WHYNOT-PROOF", "(DEFUN (INSERT-WHYNOT-PROOF WHYNOT-PROOF-CLASS) ((CLASSES (LIST OF WHYNOT-PROOF-CLASS)) (PROOF JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "insertWhynotProof", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
          Stella.defineFunctionObject("BETTER-WHYNOT-PROOF-CLASS?", "(DEFUN (BETTER-WHYNOT-PROOF-CLASS? BOOLEAN) ((CLASS1 WHYNOT-PROOF-CLASS) (CLASS2 WHYNOT-PROOF-CLASS)))", Native.find_java_method("edu.isi.powerloom.logic.WhynotProofClass", "betterWhynotProofClassP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.WhynotProofClass"), Native.find_java_class("edu.isi.powerloom.logic.WhynotProofClass")}), null);
          Stella.defineFunctionObject("ALTERNATIVE-BINDINGS-SET?", "(DEFUN (ALTERNATIVE-BINDINGS-SET? BOOLEAN) ((THING OBJECT)) :GLOBALLY-INLINE? TRUE (RETURN (AND (DEFINED? THING) (ISA? THING @ALTERNATIVE-BINDINGS-SET))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "alternativeBindingsSetP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("ALTERNATIVE-BINDINGS", "(DEFUN (ALTERNATIVE-BINDINGS SET) ((BINDINGSSET ALTERNATIVE-BINDINGS-SET)) :GLOBALLY-INLINE? TRUE (RETURN (BINDINGS BINDINGSSET)))", Native.find_java_method("edu.isi.powerloom.logic.AlternativeBindingsSet", "alternativeBindings", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.AlternativeBindingsSet")}), null);
          Stella.defineFunctionObject("POST-PROCESS-WHYNOT-PROOF-CLASSES", "(DEFUN POST-PROCESS-WHYNOT-PROOF-CLASSES ((CLASSES (LIST OF WHYNOT-PROOF-CLASS))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "postProcessWhynotProofClasses", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("CUTOFF-SIMILAR-WHYNOT-PROOFS", "(DEFUN CUTOFF-SIMILAR-WHYNOT-PROOFS ((QUERY QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "cutoffSimilarWhynotProofs", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator")}), null);
          Stella.defineMethodObject("(DEFMETHOD (RETRIEVE-PARTIAL-SOLUTIONS QUERY-ITERATOR) ((SELF WHYNOT-PARTIAL-MATCH) (QUERY QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.WhynotPartialMatch", "retrievePartialSolutions", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator")}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("RETRIEVAL-PROOF-SOLUTION", "(DEFUN (RETRIEVAL-PROOF-SOLUTION CONS) ((PROOF JUSTIFICATION) (QUERY QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "retrievalProofSolution", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.powerloom.logic.QueryIterator")}), null);
          Stella.defineFunctionObject("COLLECT-FAILED-GOALS", "(DEFUN COLLECT-FAILED-GOALS ((PROOF JUSTIFICATION) (FAILURES (LIST OF JUSTIFICATION))))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "collectFailedGoals", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("DERIVE-JUSTIFIED-PARTIAL-QUERY", "(DEFUN (DERIVE-JUSTIFIED-PARTIAL-QUERY QUERY-ITERATOR) ((QUERY QUERY-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "deriveJustifiedPartialQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator")}), null);
          Stella.defineFunctionObject("WHYNOT", "(DEFUN WHYNOT (|&REST| (ARGS OBJECT)) :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "whynot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "whynotEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("EXPLAIN-WHYNOT", "(DEFUN EXPLAIN-WHYNOT ((LABEL STRING) (STYLE KEYWORD) (MAXDEPTH INTEGER) (SUMMARY? BOOLEAN) (STREAM OUTPUT-STREAM)) :DOCUMENTATION \"Programmer's interface to the WHYNOT function.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "explainWhynot", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Keyword"), java.lang.Integer.TYPE, java.lang.Boolean.TYPE, Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("PRINT-WHYNOT-JUSTIFICATION", "(DEFUN PRINT-WHYNOT-JUSTIFICATION ((JUSTIFICATION JUSTIFICATION) (STREAM OUTPUT-STREAM) (MAXDEPTH INTEGER) (STYLE KEYWORD) (SUMMARY? BOOLEAN)) :DOCUMENTATION \"Print a WHYNOT `justification' to `stream' according to\n`maxDepth' and `style'.  Print a summary only if `summary?' is TRUE.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Justification", "printWhynotJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.stella.OutputStream"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.Keyword"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("GET-WHYNOT-JUSTIFICATIONS", "(DEFUN (GET-WHYNOT-JUSTIFICATIONS (LIST OF JUSTIFICATION)) ((QUERY QUERY-ITERATOR) (LABEL STRING) (MAPPING EXPLANATION-MAPPING)) :DOCUMENTATION \"Programmer's interface to WHYNOT function.  Derive\njustifications why `query' failed, or, if `label' was supplied as non-NULL,\nlookup its justification relative to `mapping' and return the result.\")", Native.find_java_method("edu.isi.powerloom.logic.QueryIterator", "getWhynotJustifications", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QueryIterator"), Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
          Stella.defineFunctionObject("STARTUP-WHYNOT", "(DEFUN STARTUP-WHYNOT () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupWhynot", "startupWhynot", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_WHYNOT);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupWhynot"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *MIN-CLOCK-TICKS-PER-WHYNOT-ANTECEDENT* INTEGER 5)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *MAX-WHYNOT-PROOF-CLASS-DEVIATIONS* INTEGER 1)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *SIMILAR-WHYNOT-PROOF-CUTOFF* INTEGER 3)");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
