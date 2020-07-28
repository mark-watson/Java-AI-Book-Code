//  -*- Mode: Java -*-
//
// _StartupBacklinks.java

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

public class _StartupBacklinks {
  static void helpStartupBacklinks1() {
    {
      Logic.KWD_DEPENDENTS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DEPENDENTS", null, 2)));
      Logic.SYM_LOGIC_DEPENDENT_PROPOSITIONS_INDEX = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEPENDENT-PROPOSITIONS-INDEX", null, 0)));
      Logic.KWD_RELATION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION", null, 2)));
      Logic.KWD_DEBUGGING = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DEBUGGING", null, 2)));
      Logic.SYM_LOGIC_HYPOTHESIZED_INSTANCEp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("HYPOTHESIZED-INSTANCE?", null, 0)));
      Logic.SGT_STELLA_STRING = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("STRING", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_LOGIC_BACKLINKS_MIXIN = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("BACKLINKS-MIXIN", null, 1)));
      Logic.SYM_LOGIC_SUBSUMPTION_LINKp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SUBSUMPTION-LINK?", null, 0)));
      Logic.KWD_RULES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("RULES", null, 2)));
      Logic.SGT_LOGIC_F_SELECT_RELATION_PROPOSITIONS_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-SELECT-RELATION-PROPOSITIONS-MEMO-TABLE-000", null, 1)));
      Logic.SGT_LOGIC_F_SELECT_RELATION_PROPOSITIONS_MEMO_TABLE_001 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-SELECT-RELATION-PROPOSITIONS-MEMO-TABLE-001", null, 1)));
      Logic.SGT_LOGIC_F_SELECT_RELATION_PROPOSITIONS_MEMO_TABLE_002 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-SELECT-RELATION-PROPOSITIONS-MEMO-TABLE-002", null, 1)));
      Logic.KWD_EVALUATEp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("EVALUATE?", null, 2)));
      Logic.SYM_LOGIC_STARTUP_BACKLINKS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-BACKLINKS", null, 0)));
    }
  }

  static void helpStartupBacklinks2() {
    {
      Stella.defineFunctionObject("TYPE-HAS-BACKLINKS?", "(DEFUN (TYPE-HAS-BACKLINKS? BOOLEAN) ((TYPE TYPE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "typeHasBacklinksP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT THING DEPENDENT-PROPOSITIONS-INDEX :TYPE BACKLINKS-INDEX :DOCUMENTATION \"Enables instances of 'THING' to have backindexes to \npropositions, making them first class logic objects.\" :PUBLIC? TRUE :ALLOCATION :DYNAMIC)");
      Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT PROPOSITION DEPENDENT-PROPOSITIONS-INDEX :TYPE BACKLINKS-INDEX :DOCUMENTATION \"Enables instances of 'PROPOSITION' to have (standard)\nbackindexes to propositions (as well as their own special ones), making them\nfirst class logic objects.\" :PUBLIC? TRUE :ALLOCATION :DYNAMIC)");
      Stella.defineFunctionObject("CREATE-BACKLINKS-INDEX", "(DEFUN (CREATE-BACKLINKS-INDEX BACKLINKS-INDEX) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createBacklinksIndex", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("GET-BACKLINKS-INDEX", "(DEFUN (GET-BACKLINKS-INDEX BACKLINKS-INDEX) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getBacklinksIndex", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("ADD-DEPENDENT-PROPOSITION-TO-SPECIALIZED-INDEX", "(DEFUN ADD-DEPENDENT-PROPOSITION-TO-SPECIALIZED-INDEX ((INDEX BACKLINKS-INDEX) (PROPOSITION PROPOSITION) (ARGUMENT OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.BacklinksIndex", "addDependentPropositionToSpecializedIndex", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.BacklinksIndex"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("HELP-ADD-DEPENDENT-PROPOSITION", "(DEFUN HELP-ADD-DEPENDENT-PROPOSITION ((INDEX BACKLINKS-INDEX) (PROPOSITION PROPOSITION) (ARGUMENT OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.BacklinksIndex", "helpAddDependentProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.BacklinksIndex"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("ADD-DEPENDENT-PROPOSITION-LINK", "(DEFUN ADD-DEPENDENT-PROPOSITION-LINK ((SELF OBJECT) (PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "addDependentPropositionLink", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("REMOVE-DEPENDENT-PROPOSITION-LINK", "(DEFUN REMOVE-DEPENDENT-PROPOSITION-LINK ((SELF OBJECT) (PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "removeDependentPropositionLink", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("HELP-REMOVE-DEPENDENT-PROPOSITION", "(DEFUN HELP-REMOVE-DEPENDENT-PROPOSITION ((INDEX BACKLINKS-INDEX) (PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.BacklinksIndex", "helpRemoveDependentProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.BacklinksIndex"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("REMOVE-ALL-DEPENDENT-PROPOSITION-LINKS", "(DEFUN REMOVE-ALL-DEPENDENT-PROPOSITION-LINKS ((SELF LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "removeAllDependentPropositionLinks", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineMethodObject("(DEFMETHOD (REMOVE-DELETED-MEMBERS (LIKE SELF)) ((SELF BACKLINKS-INDEX)))", Native.find_java_method("edu.isi.powerloom.logic.BacklinksIndex", "removeDeletedMembers", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("REWRAP-ARGUMENT", "(DEFUN (REWRAP-ARGUMENT OBJECT) ((ARGUMENT OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "rewrapArgument", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("INDEX-ITH-DOMAIN?", "(DEFUN (INDEX-ITH-DOMAIN? BOOLEAN) ((DESCRIPTION NAMED-DESCRIPTION) (I INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "indexIthDomainP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("REWRAP-ITH-ARGUMENT?", "(DEFUN (REWRAP-ITH-ARGUMENT? BOOLEAN) ((ARGUMENT OBJECT) (PROPOSITION PROPOSITION) (I INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "rewrapIthArgumentP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("REWRAP-PROPOSITION-ARGUMENTS", "(DEFUN REWRAP-PROPOSITION-ARGUMENTS ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "rewrapPropositionArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("HELP-UNFILTERED-DEPENDENT-PROPOSITIONS", "(DEFUN (HELP-UNFILTERED-DEPENDENT-PROPOSITIONS PROPOSITIONS-INDEX) ((SELF OBJECT) (RELATION SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "helpUnfilteredDependentPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("UNFILTERED-DEPENDENT-PROPOSITIONS", "(DEFUN (UNFILTERED-DEPENDENT-PROPOSITIONS PROPOSITIONS-INDEX) ((SELF OBJECT) (RELATION SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "unfilteredDependentPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("ALL-SPECIALIZING-DEPENDENT-PROPOSITIONS-NEXT?", "(DEFUN (ALL-SPECIALIZING-DEPENDENT-PROPOSITIONS-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allSpecializingDependentPropositionsNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("ALL-SPECIALIZING-DEPENDENT-PROPOSITIONS", "(DEFUN (ALL-SPECIALIZING-DEPENDENT-PROPOSITIONS (ITERATOR OF PROPOSITION)) ((SELF OBJECT) (RELATIONREF SURROGATE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allSpecializingDependentPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("UNFILTERED-DEPENDENT-ISA-PROPOSITIONS", "(DEFUN (UNFILTERED-DEPENDENT-ISA-PROPOSITIONS PROPOSITIONS-INDEX) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "unfilteredDependentIsaPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("UNFILTERED-DEPENDENT-IMPLIES-PROPOSITIONS", "(DEFUN (UNFILTERED-DEPENDENT-IMPLIES-PROPOSITIONS PROPOSITIONS-INDEX) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "unfilteredDependentImpliesPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("INHERITS-TRUTH-FROM-MASTER?", "(DEFUN (INHERITS-TRUTH-FROM-MASTER? BOOLEAN) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "inheritsTruthFromMasterP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("APPLICABLE-RULES-OF-DESCRIPTION", "(DEFUN (APPLICABLE-RULES-OF-DESCRIPTION (CONS OF PROPOSITION)) ((SELF LOGIC-OBJECT) (DIRECTION KEYWORD) (TRUERULESONLY? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "applicableRulesOfDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Keyword"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("MAKE-SELECTION-PATTERN", "(DEFUN (MAKE-SELECTION-PATTERN SELECTION-PATTERN) ((KIND KEYWORD) (OPTIONS CONS) (ARGUMENTS CONS)) :GLOBALLY-INLINE? TRUE (RETURN (CONS KIND (CONS (CHOOSE (NULL? OPTIONS) NIL OPTIONS) ARGUMENTS))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "makeSelectionPattern", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("PATTERN-KIND", "(DEFUN (PATTERN-KIND KEYWORD) ((PATTERN SELECTION-PATTERN)) :GLOBALLY-INLINE? TRUE (RETURN (FIRST PATTERN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "patternKind", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("PATTERN-OPTIONS", "(DEFUN (PATTERN-OPTIONS CONS) ((PATTERN SELECTION-PATTERN)) :GLOBALLY-INLINE? TRUE (RETURN (SECOND PATTERN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "patternOptions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("PATTERN-ARGUMENTS", "(DEFUN (PATTERN-ARGUMENTS CONS) ((PATTERN SELECTION-PATTERN)) :GLOBALLY-INLINE? TRUE (RETURN (REST (REST PATTERN))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "patternArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("MAKE-DEPENDENT-PROPOSITIONS-PATTERN", "(DEFUN (MAKE-DEPENDENT-PROPOSITIONS-PATTERN SELECTION-PATTERN) ((ARGUMENT OBJECT)) :GLOBALLY-INLINE? TRUE (RETURN (MAKE-SELECTION-PATTERN :DEPENDENTS NIL (CONS ARGUMENT NIL))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "makeDependentPropositionsPattern", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("MAKE-ISA-PATTERN", "(DEFUN (MAKE-ISA-PATTERN SELECTION-PATTERN) ((ARGUMENT OBJECT)) :GLOBALLY-INLINE? TRUE (RETURN (MAKE-SELECTION-PATTERN :ISA NIL (CONS ARGUMENT NIL))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "makeIsaPattern", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("MAKE-RELATION-EXTENSION-PATTERN", "(DEFUN (MAKE-RELATION-EXTENSION-PATTERN SELECTION-PATTERN) ((RELATION SURROGATE)) :GLOBALLY-INLINE? TRUE (RETURN (MAKE-SELECTION-PATTERN :RELATION NIL (CONS RELATION NIL))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "makeRelationExtensionPattern", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("MAKE-RELATION-PATTERN", "(DEFUN (MAKE-RELATION-PATTERN SELECTION-PATTERN) ((RELATION SURROGATE) (ARGUMENT OBJECT)) :GLOBALLY-INLINE? TRUE (RETURN (MAKE-SELECTION-PATTERN :RELATION NIL (CONS RELATION (CONS ARGUMENT NIL)))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "makeRelationPattern", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("MAKE-RELATION-PATTERN-1", "(DEFUN (MAKE-RELATION-PATTERN-1 CONS) ((RELATION SURROGATE) (ARGUMENT OBJECT)) :GLOBALLY-INLINE? TRUE (RETURN (MAKE-RELATION-PATTERN-2 RELATION ARGUMENT NULL)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "makeRelationPattern1", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("MAKE-RELATION-PATTERN-2", "(DEFUN (MAKE-RELATION-PATTERN-2 SELECTION-PATTERN) ((RELATION SURROGATE) (ARGUMENT1 OBJECT) (ARGUMENT2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "makeRelationPattern2", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("MAKE-RELATION-PATTERN-3", "(DEFUN (MAKE-RELATION-PATTERN-3 SELECTION-PATTERN) ((RELATION SURROGATE) (ARGUMENT1 OBJECT) (ARGUMENT2 OBJECT) (ARGUMENT3 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "makeRelationPattern3", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("MAKE-RELATION-PATTERN-4", "(DEFUN (MAKE-RELATION-PATTERN-4 SELECTION-PATTERN) ((RELATION SURROGATE) (ARGUMENT1 OBJECT) (ARGUMENT2 OBJECT) (ARGUMENT3 OBJECT) (ARGUMENT4 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "makeRelationPattern4", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("MAKE-RELATION-PATTERN-N", "(DEFUN (MAKE-RELATION-PATTERN-N SELECTION-PATTERN) ((RELATION SURROGATE) |&REST| (ARGUMENTS OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "makeRelationPatternN", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("MAKE-RULES-PATTERN", "(DEFUN (MAKE-RULES-PATTERN SELECTION-PATTERN) ((POSRELATION OBJECT) (NEGRELATION OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "makeRulesPattern", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("FIND-SELECTION-KEY-WITH-EQUIVALENTS", "(DEFUN (FIND-SELECTION-KEY-WITH-EQUIVALENTS OBJECT) ((PATTERN SELECTION-PATTERN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "findSelectionKeyWithEquivalents", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("SELECT-PROPOSITIONS", "(DEFUN (SELECT-PROPOSITIONS PROPOSITIONS-INDEX) ((PATTERN SELECTION-PATTERN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "selectPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("SELECT-ISA-PROPOSITIONS", "(DEFUN (SELECT-ISA-PROPOSITIONS PROPOSITIONS-INDEX) ((PATTERN SELECTION-PATTERN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "selectIsaPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("HELP-SELECT-RELATION-PROPOSITIONS", "(DEFUN (HELP-SELECT-RELATION-PROPOSITIONS PROPOSITIONS-INDEX) ((PATTERN SELECTION-PATTERN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "helpSelectRelationPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("SELECT-RELATION-PROPOSITIONS", "(DEFUN (SELECT-RELATION-PROPOSITIONS PROPOSITIONS-INDEX) ((PATTERN SELECTION-PATTERN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "selectRelationPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("SELECT-RULE-PROPOSITIONS", "(DEFUN (SELECT-RULE-PROPOSITIONS PROPOSITIONS-INDEX) ((PATTERN SELECTION-PATTERN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "selectRulePropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("EVALUATE-SELECTION-PATTERN", "(DEFUN (EVALUATE-SELECTION-PATTERN TRUTH-VALUE) ((PATTERN SELECTION-PATTERN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "evaluateSelectionPattern", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("EVALUATION-SELECTION-PATTERN?", "(DEFUN (EVALUATION-SELECTION-PATTERN? BOOLEAN) ((PATTERN SELECTION-PATTERN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "evaluationSelectionPatternP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("ARGUMENT-DISCOURAGES-BACKLINKS?", "(DEFUN (ARGUMENT-DISCOURAGES-BACKLINKS? BOOLEAN) ((SELF OBJECT)) :GLOBALLY-INLINE? TRUE (RETURN FALSE))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "argumentDiscouragesBacklinksP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SURROGATIFY-DISCOURAGED-ARGUMENTS", "(DEFUN SURROGATIFY-DISCOURAGED-ARGUMENTS ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "surrogatifyDiscouragedArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("COUNT-BACKLINKS-ON-RELATION", "(DEFUN (COUNT-BACKLINKS-ON-RELATION INTEGER) ((SELF OBJECT) (KIND KEYWORD) (RELATION SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "countBacklinksOnRelation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("SELECT-ARGUMENT-WITH-BACKLINKS", "(DEFUN (SELECT-ARGUMENT-WITH-BACKLINKS OBJECT BOOLEAN) ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "selectArgumentWithBacklinks", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("INSTANCE-HAS-BACKLINKS?", "(DEFUN (INSTANCE-HAS-BACKLINKS? BOOLEAN) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "instanceHasBacklinksP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SELECT-INSTANCE-WITH-BACKLINKS", "(DEFUN (SELECT-INSTANCE-WITH-BACKLINKS OBJECT) ((INSTANCES CONS) (RELATION SURROGATE)) :INLINE INSTANCE-HAS-BACKLINKS?)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "selectInstanceWithBacklinks", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("FIND-SIMILAR-PROPOSITIONS", "(DEFUN (FIND-SIMILAR-PROPOSITIONS PROPOSITIONS-INDEX) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "findSimilarPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("FIND-MATCHING-CONCEIVED-PROPOSITION", "(DEFUN (FIND-MATCHING-CONCEIVED-PROPOSITION PROPOSITION) ((GOAL PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "findMatchingConceivedProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("TRANSFER-PROPOSITIONS-AND-BACKLINKS", "(DEFUN TRANSFER-PROPOSITIONS-AND-BACKLINKS ((FROM OBJECT) (TO OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "transferPropositionsAndBacklinks", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("TRANSFER-PROPOSITIONS-EXCEPT-FOR", "(DEFUN TRANSFER-PROPOSITIONS-EXCEPT-FOR ((FROM OBJECT) (TO OBJECT) (EXCEPTPROPOSITIONS (LIST OF PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "transferPropositionsExceptFor", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("TRANSFER-DESCRIPTION-EXTENSION", "(DEFUN TRANSFER-DESCRIPTION-EXTENSION ((FROM NAMED-DESCRIPTION) (TO NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "transferDescriptionExtension", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("GET-DESCRIPTION-EXTENSION", "(DEFUN (GET-DESCRIPTION-EXTENSION PROPOSITIONS-INDEX) ((DESCRIPTION NAMED-DESCRIPTION) (UPDATE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "getDescriptionExtension", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CLEANUP-DESCRIPTION-EXTENSION", "(DEFUN CLEANUP-DESCRIPTION-EXTENSION ((DESCRIPTION NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "cleanupDescriptionExtension", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("CLEANUP-ALL-DESCRIPTION-EXTENSIONS", "(DEFUN CLEANUP-ALL-DESCRIPTION-EXTENSIONS ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "cleanupAllDescriptionExtensions", new java.lang.Class [] {}), null);
    }
  }

  public static void startupBacklinks() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupBacklinks.helpStartupBacklinks1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Logic.$INTEGER_LOGIC_WRAPPER_TABLE$ = IntegerHashTable.newIntegerHashTable();
          Logic.$FLOAT_LOGIC_WRAPPER_TABLE$ = FloatHashTable.newFloatHashTable();
          Logic.$STRING_LOGIC_WRAPPER_TABLE$ = StringHashTable.newStringHashTable();
          Logic.$SUPPRESSINSERTIONINTOCLASSEXTENSIONp$.setDefaultValue(new Boolean(false));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupBacklinks.helpStartupBacklinks2();
          Stella.defineFunctionObject("UPDATE-DESCRIPTION-EXTENSION", "(DEFUN UPDATE-DESCRIPTION-EXTENSION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "updateDescriptionExtension", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("ALL-EXTENSION-MEMBERS", "(DEFUN (ALL-EXTENSION-MEMBERS ITERATOR) ((DESCRIPTION NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "allExtensionMembers", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
          Stella.defineFunctionObject("COLLECTION-IMPLIES-COLLECTION?", "(DEFUN (COLLECTION-IMPLIES-COLLECTION? BOOLEAN) ((SUBCOLLECTION LOGIC-OBJECT) (SUPERCOLLECTION LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "collectionImpliesCollectionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
          Stella.defineFunctionObject("RELATION-IMPLIES-RELATION?", "(DEFUN (RELATION-IMPLIES-RELATION? BOOLEAN) ((SUBREL NAMED-DESCRIPTION) (SUPERREL NAMED-DESCRIPTION)) :GLOBALLY-INLINE? TRUE (RETURN (COLLECTION-IMPLIES-COLLECTION? SUBREL SUPERREL)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "relationImpliesRelationP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
          Stella.defineFunctionObject("DESCRIPTION-IMPLIES-DESCRIPTION?", "(DEFUN (DESCRIPTION-IMPLIES-DESCRIPTION? BOOLEAN) ((SUBDESC DESCRIPTION) (SUPERDESC DESCRIPTION)) :GLOBALLY-INLINE? TRUE (RETURN (COLLECTION-IMPLIES-COLLECTION? SUBDESC SUPERDESC)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "descriptionImpliesDescriptionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
          Stella.defineFunctionObject("RELATIONREF-SPECIALIZES-RELATIONREF?", "(DEFUN (RELATIONREF-SPECIALIZES-RELATIONREF? BOOLEAN) ((RELATIONREF1 SURROGATE) (RELATIONREF2 SURROGATE)) :INLINE SURROGATE-TO-DESCRIPTION)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "relationrefSpecializesRelationrefP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("STARTUP-BACKLINKS", "(DEFUN STARTUP-BACKLINKS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupBacklinks", "startupBacklinks", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_BACKLINKS);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupBacklinks"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *SPECIALIZED-BACKLINKS-CROSSOVER-POINT* INTEGER 10 :DOCUMENTATION \"When 'dependent-propositions-list' gets this long in a\nbacklinks index, then we create a hash table index and other\nspecialized indices.\")");
          Stella.$WRAPPED_TYPE_TABLE$ = Stella.$WRAPPED_TYPE_TABLE$.concatenate(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Logic.SGT_LOGIC_INTEGER_LOGIC_WRAPPER, Cons.cons(Logic.SGT_STELLA_INTEGER, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Logic.SGT_LOGIC_FLOAT_LOGIC_WRAPPER, Cons.cons(Logic.SGT_STELLA_FLOAT, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Logic.SGT_LOGIC_STRING_LOGIC_WRAPPER, Cons.cons(Logic.SGT_STELLA_STRING, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL);
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *INTEGER-LOGIC-WRAPPER-TABLE* INTEGER-HASH-TABLE (NEW INTEGER-HASH-TABLE))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *FLOAT-LOGIC-WRAPPER-TABLE* FLOAT-HASH-TABLE (NEW FLOAT-HASH-TABLE))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *STRING-LOGIC-WRAPPER-TABLE* STRING-HASH-TABLE (NEW STRING-HASH-TABLE))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *BACKLINK-ALL-PROPOSITION-ARGUMENTS?* BOOLEAN FALSE :DOCUMENTATION \"If TRUE, wrap all literal proposition arguments\nso that they can all support backlink indices.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *SUPPRESSINSERTIONINTOCLASSEXTENSION?* BOOLEAN FALSE :DOCUMENTATION \"Used when creating a skolem (e.g., a prototype) that\nisn't visible in the corresponding class extension.\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
