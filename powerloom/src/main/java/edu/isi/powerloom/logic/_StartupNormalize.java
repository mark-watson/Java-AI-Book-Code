//  -*- Mode: Java -*-
//
// _StartupNormalize.java

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

public class _StartupNormalize {
  public static void startupNormalize() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Logic.SGT_PL_KERNEL_KB_CUT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CUT", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
          Logic.SGT_PL_KERNEL_KB_BOUND_VARIABLES = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("BOUND-VARIABLES", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
          Logic.SGT_PL_KERNEL_KB_FORK = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FORK", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
          Logic.SGT_PL_KERNEL_KB_QUERY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
          Logic.SYM_LOGIC_NEURAL_NETWORK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NEURAL-NETWORK", null, 0)));
          Logic.SGT_PL_KERNEL_KB_ARITY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("ARITY", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
          Logic.SGT_PL_KERNEL_KB_CLASS = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
          Logic.SYM_LOGIC_DONT_OPTIMIZEp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DONT-OPTIMIZE?", null, 0)));
          Logic.KWD_TAIL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TAIL", null, 2)));
          Logic.SGT_LOGIC_NOT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("NOT", null, 1)));
          Logic.SGT_LOGIC_FORALL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FORALL", null, 1)));
          Logic.SGT_LOGIC_EXISTS = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("EXISTS", null, 1)));
          Logic.SGT_LOGIC_OR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("OR", null, 1)));
          Logic.SGT_LOGIC_AND = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("AND", null, 1)));
          Logic.SYM_LOGIC_STARTUP_NORMALIZE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-NORMALIZE", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("SEARCH-CONTROL-PROPOSITION?", "(DEFUN (SEARCH-CONTROL-PROPOSITION? BOOLEAN) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "searchControlPropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("DUPLICATE-AND-OR-ARGUMENTS?", "(DEFUN (DUPLICATE-AND-OR-ARGUMENTS? BOOLEAN) ((PROP1 PROPOSITION) (PROP2 PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "duplicateAndOrArgumentsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("COLLECT-FLAT-CONJUNCTS", "(DEFUN COLLECT-FLAT-CONJUNCTS ((SELF PROPOSITION) (FLATCONJUNCTS (LIST OF PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "collectFlatConjuncts", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("OVERLAY-WITH-CONSTANT-PROPOSITION", "(DEFUN OVERLAY-WITH-CONSTANT-PROPOSITION ((SELF PROPOSITION) (CONSTANTPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "overlayWithConstantProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("CONJOIN-PROPOSITIONS", "(DEFUN (CONJOIN-PROPOSITIONS PROPOSITION) ((CONJUNCTS (CONS OF PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "conjoinPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CONJOIN-TWO-PROPOSITIONS", "(DEFUN (CONJOIN-TWO-PROPOSITIONS PROPOSITION) ((PROP1 PROPOSITION) (PROP2 PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "conjoinTwoPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("COLLECT-FLAT-DISJUNCTS", "(DEFUN COLLECT-FLAT-DISJUNCTS ((SELF PROPOSITION) (FLATDISJUNCTS (LIST OF PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "collectFlatDisjuncts", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("DISJOIN-PROPOSITIONS", "(DEFUN (DISJOIN-PROPOSITIONS PROPOSITION) ((DISJUNCTS (CONS OF PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "disjoinPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("RENAME-LOGIC-VARIABLE-APART", "(DEFUN (RENAME-LOGIC-VARIABLE-APART PATTERN-VARIABLE) ((VARIABLE PATTERN-VARIABLE) (DESTRUCTIVE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "renameLogicVariableApart", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("OVERLAY-PROPOSITION", "(DEFUN OVERLAY-PROPOSITION ((SELF PROPOSITION) (OVERLAYINGPROP PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "overlayProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("NORMALIZE-EXISTS-PROPOSITION", "(DEFUN NORMALIZE-EXISTS-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "normalizeExistsProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("MIGRATE-CONSEQUENT-GOALS-TO-ANTECEDENT?", "(DEFUN (MIGRATE-CONSEQUENT-GOALS-TO-ANTECEDENT? BOOLEAN) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "migrateConsequentGoalsToAntecedentP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("FLATTEN-NESTED-FORALL-PROPOSITION", "(DEFUN FLATTEN-NESTED-FORALL-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "flattenNestedForallProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("NORMALIZE-FORALL-PROPOSITION", "(DEFUN NORMALIZE-FORALL-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "normalizeForallProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("NORMALIZE-NOT-PROPOSITION", "(DEFUN NORMALIZE-NOT-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "normalizeNotProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("NORMALIZE-AND-PROPOSITION", "(DEFUN NORMALIZE-AND-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "normalizeAndProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("NORMALIZE-OR-PROPOSITION", "(DEFUN NORMALIZE-OR-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "normalizeOrProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("HELP-NORMALIZE-PREDICATE-PROPOSITION", "(DEFUN HELP-NORMALIZE-PREDICATE-PROPOSITION ((SELF PROPOSITION) (RELATIONREF SURROGATE) (PREDICATEARGUMENTS VECTOR)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "helpNormalizePredicateProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Vector")}), null);
          Stella.defineFunctionObject("NORMALIZE-HOLDS-PROPOSITION", "(DEFUN NORMALIZE-HOLDS-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "normalizeHoldsProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("NORMALIZE-PREDICATE-PROPOSITION", "(DEFUN NORMALIZE-PREDICATE-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "normalizePredicateProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("NORMALIZE-FUNCTION-PROPOSITION", "(DEFUN NORMALIZE-FUNCTION-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "normalizeFunctionProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("COMPUTE-RELATION-TERM-SURROGATE", "(DEFUN (COMPUTE-RELATION-TERM-SURROGATE SURROGATE) ((SKOLEM SKOLEM) (PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "computeRelationTermSurrogate", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("EVALUATE-RELATION-TERM", "(DEFUN (EVALUATE-RELATION-TERM SURROGATE) ((RELATIONTERM OBJECT) (PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "evaluateRelationTerm", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("NORMALIZE-VALUE-FUNCTION", "(DEFUN (NORMALIZE-VALUE-FUNCTION PROPOSITION) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "normalizeValueFunction", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("NORMALIZE-EQUIVALENT-PROPOSITION", "(DEFUN NORMALIZE-EQUIVALENT-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "normalizeEquivalentProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("SHALLOW-COPY-PROPOSITION", "(DEFUN (SHALLOW-COPY-PROPOSITION PROPOSITION) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "shallowCopyProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("NORMALIZE-PROPOSITION", "(DEFUN NORMALIZE-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "normalizeProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("NORMALIZE-TOP-LEVEL-PROPOSITION", "(DEFUN NORMALIZE-TOP-LEVEL-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "normalizeTopLevelProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("NORMALIZE-DESCRIPTIVE-PROPOSITION", "(DEFUN NORMALIZE-DESCRIPTIVE-PROPOSITION ((SELF PROPOSITION) (IOVARIABLES VARIABLES-VECTOR) (KIND KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "normalizeDescriptiveProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("INVERT-ATOMIC-PROPOSITION", "(DEFUN INVERT-ATOMIC-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "invertAtomicProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("INVERT-EXISTS-PROPOSITION", "(DEFUN INVERT-EXISTS-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "invertExistsProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("INVERT-FORALL-PROPOSITION", "(DEFUN INVERT-FORALL-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "invertForallProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("EXTRACT-PROPOSITION", "(DEFUN (EXTRACT-PROPOSITION PROPOSITION) ((SELF DESCRIPTION) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "extractProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
          Stella.defineFunctionObject("INVERT-IMPLIES-PROPOSITION", "(DEFUN INVERT-IMPLIES-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "invertImpliesProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("INVERT-PROPOSITION", "(DEFUN (INVERT-PROPOSITION PROPOSITION) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "invertProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("SAFELY-INVERT-PROPOSITION", "(DEFUN (SAFELY-INVERT-PROPOSITION PROPOSITION) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "safelyInvertProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("STARTUP-NORMALIZE", "(DEFUN STARTUP-NORMALIZE () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupNormalize", "startupNormalize", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_NORMALIZE);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupNormalize"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
