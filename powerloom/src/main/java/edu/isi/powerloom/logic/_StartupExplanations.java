//  -*- Mode: Java -*-
//
// _StartupExplanations.java

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

public class _StartupExplanations {
  static void helpStartupExplanations1() {
    {
      Logic.KWD_ASCII = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ASCII", null, 2)));
      Logic.KWD_BRIEF = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("BRIEF", null, 2)));
      Logic.KWD_CUTOFF = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CUTOFF", null, 2)));
      Logic.KWD_INFERENCE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INFERENCE", null, 2)));
      Logic.KWD_HTML = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("HTML", null, 2)));
      Logic.SYM_LOGIC_EXPLANATION_VOCABULARY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EXPLANATION-VOCABULARY", null, 0)));
      Logic.KWD_UNKNOWN_RULE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("UNKNOWN-RULE", null, 2)));
      Logic.KWD_FOLLOWS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FOLLOWS", null, 2)));
      Logic.KWD_HOLDS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("HOLDS", null, 2)));
      Logic.KWD_DEFINITION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFINITION", null, 2)));
      Logic.KWD_FAILED = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FAILED", null, 2)));
      Logic.KWD_NOT_ASSERTED = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NOT-ASSERTED", null, 2)));
      Logic.KWD_NO_RULES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NO-RULES", null, 2)));
      Logic.SGT_LOGIC_EXPLANATION_INFO = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("EXPLANATION-INFO", null, 1)));
      Logic.SYM_STELLA_LABEL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LABEL", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_EXPLAINEDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EXPLAINED?", null, 0)));
      Logic.SYM_LOGIC_EXPLANATION_MAPPING = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EXPLANATION-MAPPING", null, 0)));
      Logic.KWD_XML = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("XML", null, 2)));
      Logic.KWD_CYC_NL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CYC-NL", null, 2)));
      Logic.KWD_KIF_ONTOSAURUS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("KIF-ONTOSAURUS", null, 2)));
      Logic.KWD_JAVA_GUI_HTML = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA-GUI-HTML", null, 2)));
      Logic.SGT_LOGIC_ALTERNATIVE_BINDINGS_SET = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("ALTERNATIVE-BINDINGS-SET", null, 1)));
      Logic.KWD_DIGIT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DIGIT", null, 2)));
      Logic.KWD_VERBOSE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("VERBOSE", null, 2)));
      Logic.KWD_DEPTH = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DEPTH", null, 2)));
      Logic.SYM_LOGIC_STARTUP_EXPLANATIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-EXPLANATIONS", null, 0)));
    }
  }

  static void helpStartupExplanations2() {
    {
      Logic.$EXPLANATION_FORMAT$.setDefaultValue(Logic.KWD_ASCII);
      Logic.$EXPLANATION_STYLE$.setDefaultValue(Logic.KWD_BRIEF);
      Logic.$EXPLANATION_AUDIENCE$.setDefaultValue(Logic.KWD_TECHNICAL);
      Logic.$EXPLANATION_VOCABULARY$.setDefaultValue(null);
      Logic.$EXPLANATION_VOCABULARIES$ = KeyValueList.newKeyValueList();
      Logic.$CURRENTJUSTIFICATION$.setDefaultValue(null);
      Logic.$MOST_RECENT_EXPLANATION_MAPPING$.setDefaultValue(null);
    }
  }

  static void helpStartupExplanations3() {
    {
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("EXPLAIN-EXCEPTION", "(DEFCLASS EXPLAIN-EXCEPTION (LOGIC-EXCEPTION))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ExplainException", "newExplainException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("EXPLAIN-NO-QUERY-EXCEPTION", "(DEFCLASS EXPLAIN-NO-QUERY-EXCEPTION (EXPLAIN-EXCEPTION))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ExplainNoQueryException", "newExplainNoQueryException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("EXPLAIN-NO-SOLUTION-EXCEPTION", "(DEFCLASS EXPLAIN-NO-SOLUTION-EXCEPTION (EXPLAIN-EXCEPTION))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ExplainNoSolutionException", "newExplainNoSolutionException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("EXPLAIN-NO-MORE-SOLUTIONS-EXCEPTION", "(DEFCLASS EXPLAIN-NO-MORE-SOLUTIONS-EXCEPTION (EXPLAIN-EXCEPTION))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ExplainNoMoreSolutionsException", "newExplainNoMoreSolutionsException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("EXPLAIN-NOT-ENABLED-EXCEPTION", "(DEFCLASS EXPLAIN-NOT-ENABLED-EXCEPTION (EXPLAIN-EXCEPTION))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ExplainNotEnabledException", "newExplainNotEnabledException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("EXPLAIN-NO-SUCH-LABEL-EXCEPTION", "(DEFCLASS EXPLAIN-NO-SUCH-LABEL-EXCEPTION (EXPLAIN-EXCEPTION))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ExplainNoSuchLabelException", "newExplainNoSuchLabelException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("EXPLAIN-QUERY-TRUE-EXCEPTION", "(DEFCLASS EXPLAIN-QUERY-TRUE-EXCEPTION (EXPLAIN-EXCEPTION))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ExplainQueryTrueException", "newExplainQueryTrueException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE EXPLANATION-VOCABULARY (HASH-TABLE OF KEYWORD (CONS OF CONS)))");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("EXPLANATION-INFO", "(DEFCLASS EXPLANATION-INFO (STANDARD-OBJECT) :SLOTS ((LABEL :TYPE STRING) (DEPTH :TYPE INTEGER) (EXPLAINED? :TYPE BOOLEAN)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ExplanationInfo", "newExplanationInfo", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.ExplanationInfo", "accessExplanationInfoSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ExplanationInfo"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE EXPLANATION-MAPPING (KEY-VALUE-LIST OF JUSTIFICATION EXPLANATION-INFO))");
    }
  }

  public static void startupExplanations() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupExplanations.helpStartupExplanations1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          _StartupExplanations.helpStartupExplanations2();
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          _StartupExplanations.helpStartupExplanations3();
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("EXPLANATION-TRUTH-MARKER", "(DEFUN (EXPLANATION-TRUTH-MARKER STRING) ((JUSTIFICATION JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "explanationTruthMarker", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
          Stella.defineFunctionObject("DEFINE-EXPLANATION-PHRASE", "(DEFUN DEFINE-EXPLANATION-PHRASE ((PHRASEKEY KEYWORD) (AUDIENCE KEYWORD) (PHRASE STRING) |&REST| (MODIFIERS KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "defineExplanationPhrase", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("LOOKUP-EXPLANATION-PHRASE", "(DEFUN (LOOKUP-EXPLANATION-PHRASE STRING) ((PHRASEKEY KEYWORD) (MODIFIERS (CONS OF KEYWORD)) (AUDIENCE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "lookupExplanationPhrase", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("REGISTER-JUSTIFICATION", "(DEFUN (REGISTER-JUSTIFICATION EXPLANATION-INFO) ((SELF JUSTIFICATION) (MAPPING EXPLANATION-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "registerJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
          Stella.defineFunctionObject("GET-EXPLANATION-INFO", "(DEFUN (GET-EXPLANATION-INFO EXPLANATION-INFO) ((SELF JUSTIFICATION) (MAPPING EXPLANATION-MAPPING) (CREATE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "getExplanationInfo", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.stella.KeyValueList"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("EXPLANATION-INFO", "(DEFUN (EXPLANATION-INFO EXPLANATION-INFO) ((SELF JUSTIFICATION) (MAPPING EXPLANATION-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "explanationInfo", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
          Stella.defineFunctionObject("LOOKUP-JUSTIFICATION", "(DEFUN (LOOKUP-JUSTIFICATION JUSTIFICATION) ((MAPPING EXPLANATION-MAPPING) (LABEL STRING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "lookupJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.KeyValueList"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("RESET-MAPPING-FOR-SUBEXPLANATION", "(DEFUN RESET-MAPPING-FOR-SUBEXPLANATION ((MAPPING EXPLANATION-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "resetMappingForSubexplanation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
          Stella.defineFunctionObject("PRINT-EXPLANATION", "(DEFUN (PRINT-EXPLANATION EXPLANATION-MAPPING) ((SELF JUSTIFICATION) (STREAM OUTPUT-STREAM) (MAPPING EXPLANATION-MAPPING) (MAXDEPTH INTEGER) (AUDIENCE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "printExplanation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.KeyValueList"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("PRINT-EXPLANATION-SUPPORT", "(DEFUN PRINT-EXPLANATION-SUPPORT ((SELF JUSTIFICATION) (STREAM OUTPUT-STREAM) (MAPPING EXPLANATION-MAPPING) (MAXDEPTH INTEGER) (UNEXPLAINED (LIST OF JUSTIFICATION))))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "printExplanationSupport", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.KeyValueList"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("PRINT-ONE-EXPLANATION", "(DEFUN PRINT-ONE-EXPLANATION ((SELF JUSTIFICATION) (STREAM OUTPUT-STREAM) (MAPPING EXPLANATION-MAPPING) (MAXDEPTH INTEGER) (UNEXPLAINED (LIST OF JUSTIFICATION))))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "printOneExplanation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.KeyValueList"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("PRINTING-JUSTIFICATION?", "(DEFUN (PRINTING-JUSTIFICATION? BOOLEAN) () :GLOBALLY-INLINE? TRUE (RETURN (DEFINED? *CURRENTJUSTIFICATION*)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printingJustificationP", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("PRINT-JUSTIFICATION-PROPOSITION-FOR-FORMAT", "(DEFUN PRINT-JUSTIFICATION-PROPOSITION-FOR-FORMAT ((SELF JUSTIFICATION) (STREAM OUTPUT-STREAM) (INDENT INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "printJustificationPropositionForFormat", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.stella.OutputStream"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("PRINT-JUSTIFICATION-PROPOSITION", "(DEFUN PRINT-JUSTIFICATION-PROPOSITION ((SELF JUSTIFICATION) (STREAM OUTPUT-STREAM) (INDENT INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "printJustificationProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.stella.OutputStream"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("PRINT-EXPLANATION-LABEL", "(DEFUN PRINT-EXPLANATION-LABEL ((STREAM OUTPUT-STREAM) (LABEL STRING) (HEAD? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printExplanationLabel", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("java.lang.String"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("PRINT-EXPLANATION-HEADER", "(DEFUN PRINT-EXPLANATION-HEADER ((SELF JUSTIFICATION) (STREAM OUTPUT-STREAM) (MAPPING EXPLANATION-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "printExplanationHeader", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
          Stella.defineFunctionObject("PRINT-EXPLANATION-TEXT", "(DEFUN PRINT-EXPLANATION-TEXT ((SELF JUSTIFICATION) (STREAM OUTPUT-STREAM) (MAPPING EXPLANATION-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "printExplanationText", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
          Stella.defineFunctionObject("MARK-AS-EXPLICIT-ASSERTION?", "(DEFUN (MARK-AS-EXPLICIT-ASSERTION? BOOLEAN) ((SELF JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "markAsExplicitAssertionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
          Stella.defineFunctionObject("MARK-AS-FAILED-GOAL?", "(DEFUN (MARK-AS-FAILED-GOAL? BOOLEAN) ((SELF JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "markAsFailedGoalP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
          Stella.defineFunctionObject("MARK-AS-CUTOFF-GOAL?", "(DEFUN (MARK-AS-CUTOFF-GOAL? BOOLEAN) ((SELF JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "markAsCutoffGoalP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
          Stella.defineFunctionObject("PARTIALLY-FOLLOWS?", "(DEFUN (PARTIALLY-FOLLOWS? BOOLEAN) ((SELF JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "partiallyFollowsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
          Stella.defineFunctionObject("MAKE-RULE-ORIGIN-EXPLANATION-PHRASE", "(DEFUN (MAKE-RULE-ORIGIN-EXPLANATION-PHRASE STRING) ((SELF JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "makeRuleOriginExplanationPhrase", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
          Stella.defineFunctionObject("GET-EXPLANATION-SUBSTITUTION", "(DEFUN (GET-EXPLANATION-SUBSTITUTION ENTITY-MAPPING) ((SELF JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "getExplanationSubstitution", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
          Stella.defineFunctionObject("PRINT-ONE-VARIABLE-SUBSTITUTION", "(DEFUN PRINT-ONE-VARIABLE-SUBSTITUTION ((STREAM OUTPUT-STREAM) (VAR OBJECT) (VALUE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printOneVariableSubstitution", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("PRINT-EXPLANATION-SUBSTITUTION", "(DEFUN PRINT-EXPLANATION-SUBSTITUTION ((SELF JUSTIFICATION) (STREAM OUTPUT-STREAM) (MAPPING EXPLANATION-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "printExplanationSubstitution", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
          Stella.defineFunctionObject("PRINT-EXPLANATION-ANTECEDENTS", "(DEFUN PRINT-EXPLANATION-ANTECEDENTS ((SELF JUSTIFICATION) (STREAM OUTPUT-STREAM) (MAPPING EXPLANATION-MAPPING) (MAXDEPTH INTEGER) (UNEXPLAINED (LIST OF JUSTIFICATION))))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "printExplanationAntecedents", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.KeyValueList"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("VISIBLE-JUSTIFICATION", "(DEFUN (VISIBLE-JUSTIFICATION JUSTIFICATION) ((SELF JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "visibleJustification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
          Stella.defineFunctionObject("VISIBLE-ANTECEDENTS", "(DEFUN (VISIBLE-ANTECEDENTS (LIST OF JUSTIFICATION)) ((SELF JUSTIFICATION)))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "visibleAntecedents", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification")}), null);
          Stella.defineFunctionObject("COLLECT-VISIBLE-ANTECEDENTS", "(DEFUN COLLECT-VISIBLE-ANTECEDENTS ((SELF JUSTIFICATION) (VISIBLEANTECEDENTS (LIST OF JUSTIFICATION))))", Native.find_java_method("edu.isi.powerloom.logic.Justification", "collectVisibleAntecedents", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Justification"), Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("WHY", "(DEFUN WHY (|&REST| (ARGS OBJECT)) :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Print an explanation for the result of the most recent query.\nWithout any arguments, `why' prints an explanation of the top level\nquery proposition down to a maximum depth of 3.  `(why all)' prints\nan explanation to unlimited depth.  Alternatively, a particular depth\ncan be specified, for example, `(why 5)' explains down to a depth of 5.\nA proof step that was not explained explicitly (e.g., due to a depth\ncutoff) can be explained by supplying the label of the step as the\nfirst argument to `why', for example, `(why 1.2.3 5)' prints an explanation\nstarting at 1.2.3 down to a depth of 5 (which is counted relative to the\ndepth of the starting point).  The keywords `brief' and `verbose' can be\nused to select a particular explanation style.  In brief mode, explicitly\nasserted propositions are not further explained and indicated with a\n`!' assertion marker.  Additionally, relatively uninteresting proof steps\nsuch as AND-introductions are skipped.  This explanation style option is\nsticky and will affect future calls to `why' until it gets changed again.\nThe various options can be combined in any way, for example,\n`(why 1.2.3 brief 3)' explains starting from step 1.2.3 down to a depth\nof 3 in brief explanation mode.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "why", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "whyEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("EXPLAIN-WHY", "(DEFUN EXPLAIN-WHY ((LABEL STRING) (STYLE KEYWORD) (MAXDEPTH INTEGER) (STREAM OUTPUT-STREAM)) :PUBLIC? TRUE :DOCUMENTATION \"Programmer's interface to WHY function.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "explainWhy", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Keyword"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("EXPLAIN-PROPOSITION", "(DEFUN EXPLAIN-PROPOSITION ((PROP PROPOSITION) (STYLE KEYWORD) (MAXDEPTH INTEGER) (STREAM OUTPUT-STREAM)) :PUBLIC? TRUE :DOCUMENTATION \"Print an explanation for `prop' if there is one.  This will only happen\nfor forward-chained propositions.\")", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "explainProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Keyword"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("GET-WHY-JUSTIFICATION", "(DEFUN (GET-WHY-JUSTIFICATION JUSTIFICATION) ((LABEL STRING)) :PUBLIC? TRUE :DOCUMENTATION \"Returns the current WHY justification.  May also throw one of the\nfollowing subtypes of EXPLAIN-EXCEPTION:\n   EXPLAIN-NO-QUERY-EXCEPTION\n   EXPLAIN-NO-SOLUTION-EXCEPTION\n   EXPLAIN-NO-MORE-SOLUTIONS-EXCEPTION\n   EXPLAIN-NOT-ENABLED-EXCEPTION\n   EXPLAIN-NO-SUCH-LABEL-EXCEPTION\n   EXPLAIN-QUERY-TRUE-EXCEPTION\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getWhyJustification", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("COMMAND-OPTION-EQL?", "(DEFUN (COMMAND-OPTION-EQL? BOOLEAN) ((ARG OBJECT) (OPTION STRING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "commandOptionEqlP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("PARSE-WHY-ARGUMENTS", "(DEFUN (PARSE-WHY-ARGUMENTS STRING KEYWORD INTEGER BOOLEAN) ((ARGS (CONS OF OBJECT))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "parseWhyArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("[Ljava.lang.Object;")}), null);
          Stella.defineFunctionObject("STARTUP-EXPLANATIONS", "(DEFUN STARTUP-EXPLANATIONS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupExplanations", "startupExplanations", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_EXPLANATIONS);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupExplanations"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *EXPLANATION-FORMAT* KEYWORD :ASCII :DOCUMENTATION \"Keyword to control the explanation format.\nValid values are :ASCII, :HTML and :XML\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *EXPLANATION-STYLE* KEYWORD :BRIEF :DOCUMENTATION \"Keywords that controls how detailed explanations will be.\nValid values are :VERBOSE and :BRIEF.\" :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *EXPLANATION-AUDIENCE* KEYWORD :TECHNICAL :DOCUMENTATION \"Keywords that controls the language for justifications.\nValid values are :TECHNICAL and :LAY\" :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *DEFAULT-EXPLANATION-DEPTH* INTEGER 3 :DOCUMENTATION \"Maximal explanation depth used if not otherwise specified.\" :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *EXPLANATION-TAB-STRING* STRING \"    \")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *MAX-INLINE-LABEL-LENGTH* INTEGER 10 :DOCUMENTATION \"Maximum length of a label string for which the following\nproposition will be printed on the same line.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *EXPLANATION-ASSERTION-MARKER* STRING \"!\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *EXPLANATION-FAILURE-MARKER* STRING \"?\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *EXPLANATION-CUTOFF-MARKER* STRING \"x\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *EXPLANATION-INFERENCE-MARKER* STRING \" \")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *EXPLANATION-VOCABULARY* EXPLANATION-VOCABULARY NULL :DOCUMENTATION \"The currently active vocabulary lookup table\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *EXPLANATION-VOCABULARIES* (KEY-VALUE-LIST OF KEYWORD EXPLANATION-VOCABULARY) (NEW KEY-VALUE-LIST) :DOCUMENTATION \"List of vocabularies with keyword keys\")");
          Logic.defineExplanationPhrase(Logic.KWD_UNKNOWN_RULE, Logic.KWD_TECHNICAL, "because of an inference PowerLoom can't explain yet", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_FOLLOWS, Logic.KWD_TECHNICAL, "follows", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_FOLLOWS, Logic.KWD_LAY, "is true", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_FOLLOWS, Logic.KWD_TECHNICAL, "is partially true", Cons.cons(Logic.KWD_PARTIAL, Stella.NIL));
          Logic.defineExplanationPhrase(Logic.KWD_FOLLOWS, Logic.KWD_LAY, "is true to some part", Cons.cons(Logic.KWD_PARTIAL, Stella.NIL));
          Logic.defineExplanationPhrase(Logic.KWD_HOLDS, Logic.KWD_TECHNICAL, "holds", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_HOLDS, Logic.KWD_LAY, "is true", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_DEFINITION, Logic.KWD_TECHNICAL, "by the definition of", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_DEFINITION, Logic.KWD_LAY, "by the definition of", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_FAILED, Logic.KWD_TECHNICAL, "failed", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_FAILED, Logic.KWD_LAY, "could not be proven", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_INCONSISTENT, Logic.KWD_TECHNICAL, "is inconsistent", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_INCONSISTENT, Logic.KWD_LAY, "has a contradiction", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_CLASH, Logic.KWD_TECHNICAL, "because it and its negation were inferred", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_CLASH, Logic.KWD_LAY, "because opposite conclusions were reached", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_NOT_ASSERTED, Logic.KWD_TECHNICAL, "is not asserted", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_NOT_ASSERTED, Logic.KWD_LAY, "is not asserted to be true", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_NO_RULES, Logic.KWD_TECHNICAL, "no potential inference leading to the proposition could be found", Stella.NIL);
          Logic.defineExplanationPhrase(Logic.KWD_NO_RULES, Logic.KWD_LAY, "no rules for proving the proposition could be found", Stella.NIL);
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *CURRENTJUSTIFICATION* JUSTIFICATION NULL)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *MOST-RECENT-EXPLANATION-MAPPING* EXPLANATION-MAPPING NULL)");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
