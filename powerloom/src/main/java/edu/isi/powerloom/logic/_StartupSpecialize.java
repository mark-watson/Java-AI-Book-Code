//  -*- Mode: Java -*-
//
// _StartupSpecialize.java

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

public class _StartupSpecialize {
  static void helpStartupSpecialize1() {
    {
      Logic.SGT_LOGIC_ABSTRACT_PROPOSITIONS_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("ABSTRACT-PROPOSITIONS-ITERATOR", null, 1)));
      Logic.SYM_LOGIC_PROPOSITION_CURSOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PROPOSITION-CURSOR", null, 0)));
      Logic.SYM_LOGIC_EQUIVALENTS_STACK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EQUIVALENTS-STACK", null, 0)));
      Logic.SGT_LOGIC_TRUE_PROPOSITIONS_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TRUE-PROPOSITIONS-ITERATOR", null, 1)));
      Logic.SGT_LOGIC_SPECIALIZING_PROPOSITIONS_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SPECIALIZING-PROPOSITIONS-ITERATOR", null, 1)));
      Logic.SYM_LOGIC_SPECIALIZING_RELATIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SPECIALIZING-RELATIONS", null, 0)));
      Logic.SGT_LOGIC_F_TEST_PROPERTYp_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-TEST-PROPERTY?-MEMO-TABLE-000", null, 1)));
      Logic.SGT_PL_KERNEL_KB_COLLECTION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("COLLECTION", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_LOGIC_F_TEST_ISAp_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-TEST-ISA?-MEMO-TABLE-000", null, 1)));
      Logic.SGT_LOGIC_F_TEST_ISAp_MEMO_TABLE_001 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-TEST-ISA?-MEMO-TABLE-001", null, 1)));
      Logic.SGT_LOGIC_F_ACCESS_BINARY_VALUE_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-ACCESS-BINARY-VALUE-MEMO-TABLE-000", null, 1)));
      Logic.SGT_LOGIC_TRANSITIVE_CLOSURE_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TRANSITIVE-CLOSURE-ITERATOR", null, 1)));
      Logic.SYM_LOGIC_ALLOCATE_ADJACENCY_ITERATOR_FUNCTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ALLOCATE-ADJACENCY-ITERATOR-FUNCTION", null, 0)));
      Logic.SYM_LOGIC_FILTERp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FILTER?", null, 0)));
      Logic.SYM_LOGIC_ADJACENCY_ITERATOR_STACK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ADJACENCY-ITERATOR-STACK", null, 0)));
      Logic.SYM_LOGIC_BEEN_THERE_LIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BEEN-THERE-LIST", null, 0)));
      Logic.SGT_LOGIC_SUPPORTED_CLOSURE_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SUPPORTED-CLOSURE-ITERATOR", null, 1)));
      Logic.SGT_LOGIC_DIRECTLY_LINKED_OBJECTS_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DIRECTLY-LINKED-OBJECTS-ITERATOR", null, 1)));
      Logic.SYM_LOGIC_INVERSEp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INVERSE?", null, 0)));
      Logic.SYM_LOGIC_ROOT_TRUTH_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ROOT-TRUTH-VALUE", null, 0)));
      Logic.SGT_LOGIC_F_ALL_SUPERCOLLECTIONS_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-ALL-SUPERCOLLECTIONS-MEMO-TABLE-000", null, 1)));
      Logic.SGT_LOGIC_F_ALL_SUPPORTED_NAMED_SUBCOLLECTIONS_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-ALL-SUPPORTED-NAMED-SUBCOLLECTIONS-MEMO-TABLE-000", null, 1)));
      Logic.SGT_STELLA_NUMBER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("NUMBER", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_LOGIC_CLASHING_PROPOSITIONS_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASHING-PROPOSITIONS-ITERATOR", null, 1)));
      Logic.SYM_STELLA_TAXONOMY_NODE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TAXONOMY-NODE", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_STARTUP_SPECIALIZE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-SPECIALIZE", null, 0)));
    }
  }

  static void helpStartupSpecialize2() {
    {
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("ABSTRACT-PROPOSITIONS-ITERATOR", "(DEFCLASS ABSTRACT-PROPOSITIONS-ITERATOR (ITERATOR) :DOCUMENTATION \"Iterator class that can generate sets of propositions matching\nits `selection-pattern'.\" :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :SLOTS ((SELECTION-PATTERN :TYPE SELECTION-PATTERN) (PROPOSITION-CURSOR :TYPE (ITERATOR OF PROPOSITION)) (EQUIVALENTS-STACK :TYPE CONS :INITIALLY NULL)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.AbstractPropositionsIterator", "newAbstractPropositionsIterator", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.AbstractPropositionsIterator", "accessAbstractPropositionsIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.AbstractPropositionsIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("TRUE-PROPOSITIONS-ITERATOR", "(DEFCLASS TRUE-PROPOSITIONS-ITERATOR (ABSTRACT-PROPOSITIONS-ITERATOR) :DOCUMENTATION \"Iterator class that can generate sets of true propositions\nmatching its `selection-pattern'.\" :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :SLOTS ((TRUTH-VALUE :TYPE TRUTH-VALUE :DOCUMENTATION \"Truth-value of the most recently generated proposition (or\nprojected argument thereof).  This truth value is not necessarily the strictest\nand might have involved defaults.\")))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.TruePropositionsIterator", "newTruePropositionsIterator", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.TruePropositionsIterator", "accessTruePropositionsIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruePropositionsIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("SPECIALIZING-PROPOSITIONS-ITERATOR", "(DEFCLASS SPECIALIZING-PROPOSITIONS-ITERATOR (TRUE-PROPOSITIONS-ITERATOR) :DOCUMENTATION \"Iterator class that can generate sets of true propositions\nmatching its `selection-pattern' or a more specific pattern that substitutes\none of the relations in `specializing-relations'.\" :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :SLOTS ((SPECIALIZING-RELATIONS :TYPE (CONS OF CONS) :INITIALLY NULL)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.SpecializingPropositionsIterator", "newSpecializingPropositionsIterator", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.SpecializingPropositionsIterator", "accessSpecializingPropositionsIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.SpecializingPropositionsIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("TRANSITIVE-CLOSURE-ITERATOR", "(DEFCLASS TRANSITIVE-CLOSURE-ITERATOR (ITERATOR) :DOCUMENTATION \"Iterator that visits all nodes reachable using an\nembedded adjacency function.\" :SLOTS ((ALLOCATE-ADJACENCY-ITERATOR-FUNCTION :TYPE FUNCTION-CODE) (FILTER? :TYPE FUNCTION-CODE) (ADJACENCY-ITERATOR-STACK :TYPE (CONS OF ITERATOR) :INITIALLY NIL) (BEEN-THERE-LIST :TYPE CONS)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.TransitiveClosureIterator", "newTransitiveClosureIterator", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.TransitiveClosureIterator", "accessTransitiveClosureIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TransitiveClosureIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("SUPPORTED-CLOSURE-ITERATOR", "(DEFCLASS SUPPORTED-CLOSURE-ITERATOR (TRANSITIVE-CLOSURE-ITERATOR) :DOCUMENTATION \"Iterator that visits all objects reachable via true link propositions\ngenerated by an embedded link proposition iterator.  Each new object reached\nis represented as an `(<object> <truth-value>)' pair, where <truth-value> is\nthe cumulative truth value of the links followed from the start to reach it.\nThe embedded `allocate-adjacency-iterator-function' needs to be able to take\nan `(<object> <truth-value>)' pair as an argument which is different than the\nrequirement for TRANSITIVE-CLOSURE-ITERATOR's.\" :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :SLOTS ((ADJACENCY-ITERATOR-STACK :TYPE (CONS OF TRUE-PROPOSITIONS-ITERATOR))))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.SupportedClosureIterator", "newSupportedClosureIterator", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.SupportedClosureIterator", "accessSupportedClosureIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.SupportedClosureIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("DIRECTLY-LINKED-OBJECTS-ITERATOR", "(DEFCLASS DIRECTLY-LINKED-OBJECTS-ITERATOR (TRUE-PROPOSITIONS-ITERATOR) :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :SLOTS ((INVERSE? :TYPE BOOLEAN) (ROOT-TRUTH-VALUE :TYPE TRUTH-VALUE :INITIALLY TRUE-TRUTH-VALUE)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.DirectlyLinkedObjectsIterator", "newDirectlyLinkedObjectsIterator", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.DirectlyLinkedObjectsIterator", "accessDirectlyLinkedObjectsIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.DirectlyLinkedObjectsIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CLASHING-PROPOSITIONS-ITERATOR", "(DEFCLASS CLASHING-PROPOSITIONS-ITERATOR (TRUE-PROPOSITIONS-ITERATOR) :PARAMETERS ((ANY-VALUE :TYPE PROPOSITION)) :SLOTS ((REFERENCE-PROPOSITION :TYPE PROPOSITION)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ClashingPropositionsIterator", "newClashingPropositionsIterator", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.ClashingPropositionsIterator", "accessClashingPropositionsIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ClashingPropositionsIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
    }
  }

  static void helpStartupSpecialize3() {
    {
      Stella.defineFunctionObject("PROPOSITIONS-ITERATOR-TRUTH-VALUE", "(DEFUN (PROPOSITIONS-ITERATOR-TRUTH-VALUE TRUTH-VALUE) ((SELF (ITERATOR OF PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "propositionsIteratorTruthValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Iterator")}), null);
      Stella.defineFunctionObject("NEXT-EQUIVALENT-SELECTION-PATTERN", "(DEFUN (NEXT-EQUIVALENT-SELECTION-PATTERN CONS) ((SELF ABSTRACT-PROPOSITIONS-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.AbstractPropositionsIterator", "nextEquivalentSelectionPattern", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.AbstractPropositionsIterator")}), null);
      Stella.defineFunctionObject("PROPOSITION-TRUTH-VALUE", "(DEFUN (PROPOSITION-TRUTH-VALUE TRUTH-VALUE) ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "propositionTruthValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("TRUE-PROPOSITION?", "(DEFUN (TRUE-PROPOSITION? BOOLEAN) ((PROPOSITION PROPOSITION)) :GLOBALLY-INLINE? TRUE :PUBLIC? TRUE (RETURN (AND (NOT (DELETED? PROPOSITION)) (CHOOSE *REVERSEPOLARITY?* (FALSE? PROPOSITION) (OR (TRUE? PROPOSITION) (FUNCTION-WITH-DEFINED-VALUE? PROPOSITION))))))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "truePropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("TRUE-PROPOSITIONS-ITERATOR.NEXT?", "(DEFUN (TRUE-PROPOSITIONS-ITERATOR.NEXT? BOOLEAN) ((SELF TRUE-PROPOSITIONS-ITERATOR)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.TruePropositionsIterator", "truePropositionsIteratorDnextP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruePropositionsIterator")}), null);
      Stella.defineMethodObject("(DEFMETHOD (NEXT? BOOLEAN) ((SELF TRUE-PROPOSITIONS-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.TruePropositionsIterator", "nextP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("SPECIALIZING-PROPOSITIONS-ITERATOR.NEXT?", "(DEFUN (SPECIALIZING-PROPOSITIONS-ITERATOR.NEXT? BOOLEAN) ((SELF SPECIALIZING-PROPOSITIONS-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.SpecializingPropositionsIterator", "specializingPropositionsIteratorDnextP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.SpecializingPropositionsIterator")}), null);
      Stella.defineMethodObject("(DEFMETHOD (NEXT? BOOLEAN) ((SELF SPECIALIZING-PROPOSITIONS-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.SpecializingPropositionsIterator", "nextP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("EMPTY-PROPOSITIONS-INDEX?", "(DEFUN (EMPTY-PROPOSITIONS-INDEX? BOOLEAN) ((INDEX PROPOSITIONS-INDEX) (PRIMARYKEY OBJECT) (SPECIALIZE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.SequenceIndex", "emptyPropositionsIndexP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.SequenceIndex"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ALL-TRUE-DEPENDENT-PROPOSITIONS", "(DEFUN (ALL-TRUE-DEPENDENT-PROPOSITIONS (ITERATOR OF PROPOSITION)) ((SELF OBJECT) (RELATION SURROGATE) (SPECIALIZE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allTrueDependentPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ALL-TRUE-DEPENDENT-ISA-PROPOSITIONS", "(DEFUN (ALL-TRUE-DEPENDENT-ISA-PROPOSITIONS (ITERATOR OF PROPOSITION)) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allTrueDependentIsaPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("ARGUMENTS-UNIFY-WITH-ARGUMENTS?", "(DEFUN (ARGUMENTS-UNIFY-WITH-ARGUMENTS? BOOLEAN) ((SUBPROPOSITION PROPOSITION) (REFERENCEPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "argumentsUnifyWithArgumentsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("ARGUMENTS-EQUAL-ARGUMENTS?", "(DEFUN (ARGUMENTS-EQUAL-ARGUMENTS? BOOLEAN) ((SUBPROPOSITION PROPOSITION) (REFERENCEPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "argumentsEqualArgumentsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("ARGUMENTS-MATCH-ARGUMENTS?", "(DEFUN (ARGUMENTS-MATCH-ARGUMENTS? BOOLEAN) ((SUBPROPOSITION PROPOSITION) (REFERENCEPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "argumentsMatchArgumentsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("PREFIX-ARGUMENTS-EQUAL-ARGUMENTS?", "(DEFUN (PREFIX-ARGUMENTS-EQUAL-ARGUMENTS? BOOLEAN) ((SUBPROPOSITION PROPOSITION) (REFERENCEPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "prefixArgumentsEqualArgumentsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("ALL-MATCHING-PROPOSITIONS", "(DEFUN (ALL-MATCHING-PROPOSITIONS (ITERATOR OF PROPOSITION)) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "allMatchingPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("ALL-PROPOSITIONS-MATCHING-ARGUMENTS", "(DEFUN (ALL-PROPOSITIONS-MATCHING-ARGUMENTS (CONS OF PROPOSITION)) ((ARGUMENTS CONS) (RELATION SURROGATE) (SPECIALIZE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allPropositionsMatchingArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Surrogate"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ALL-DEFINING-PROPOSITIONS", "(DEFUN (ALL-DEFINING-PROPOSITIONS (CONS OF PROPOSITION)) ((OUTPUTARGUMENT OBJECT) (RELATION SURROGATE) (SPECIALIZE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allDefiningPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("HELP-MEMOIZE-TEST-PROPERTY?", "(DEFUN (HELP-MEMOIZE-TEST-PROPERTY? BOOLEAN) ((SELF OBJECT) (RELATION SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "helpMemoizeTestPropertyP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("TEST-PROPERTY?", "(DEFUN (TEST-PROPERTY? BOOLEAN) ((SELF OBJECT) (RELATION SURROGATE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "testPropertyP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("HELP-MEMOIZE-TEST-ISA?", "(DEFUN (HELP-MEMOIZE-TEST-ISA? BOOLEAN) ((MEMBER OBJECT) (TYPE SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "helpMemoizeTestIsaP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("TEST-ISA?", "(DEFUN (TEST-ISA? BOOLEAN) ((MEMBER OBJECT) (TYPE SURROGATE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "testIsaP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("HELP-MEMOIZE-ACCESS-BINARY-VALUE", "(DEFUN (HELP-MEMOIZE-ACCESS-BINARY-VALUE OBJECT) ((SELF OBJECT) (RELATION SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "helpMemoizeAccessBinaryValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("ACCESS-BINARY-VALUE", "(DEFUN (ACCESS-BINARY-VALUE OBJECT) ((SELF OBJECT) (RELATION SURROGATE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "accessBinaryValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("TEST-COLLECTIONOF-MEMBER-OF?", "(DEFUN (TEST-COLLECTIONOF-MEMBER-OF? BOOLEAN) ((MEMBER OBJECT) (TYPE SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "testCollectionofMemberOfP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("TRANSITIVE-CLOSURE-ITERATOR.NEXT?", "(DEFUN (TRANSITIVE-CLOSURE-ITERATOR.NEXT? BOOLEAN) ((SELF TRANSITIVE-CLOSURE-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.TransitiveClosureIterator", "transitiveClosureIteratorDnextP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TransitiveClosureIterator")}), null);
      Stella.defineMethodObject("(DEFMETHOD (NEXT? BOOLEAN) ((SELF TRANSITIVE-CLOSURE-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.TransitiveClosureIterator", "nextP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("ALLOCATE-TRANSITIVE-CLOSURE-ITERATOR", "(DEFUN (ALLOCATE-TRANSITIVE-CLOSURE-ITERATOR ITERATOR) ((STARTNODE OBJECT) (ALLOCATEADJACENCYITERATOR FUNCTION-CODE) (FILTERFUNCTION FUNCTION-CODE)) :DOCUMENTATION \"Return an iterator that generates the transitive\nclosure of applying iterators generated by 'allocateAdjacencyIterator'\nto 'startNode'.  If 'filterFunction' is non-null, that function is applied\nas a filter to each node generated (nodes filtered out still generate\ndescendants, but they don't get returned).\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allocateTransitiveClosureIterator", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("java.lang.reflect.Method"), Native.find_java_class("java.lang.reflect.Method")}), null);
      Stella.defineFunctionObject("ALLOCATE-SUPPORTED-CLOSURE-ITERATOR", "(DEFUN (ALLOCATE-SUPPORTED-CLOSURE-ITERATOR SUPPORTED-CLOSURE-ITERATOR) ((STARTNODE CONS) (ALLOCATEADJACENCYITERATOR FUNCTION-CODE) (FILTERFUNCTION FUNCTION-CODE)) :DOCUMENTATION \"Similar to `allocate-transitive-closure-iterator' (which see),\nbut return a SUPPORTED-CLOSURE-ITERATOR instead.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allocateSupportedClosureIterator", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("java.lang.reflect.Method"), Native.find_java_class("java.lang.reflect.Method")}), null);
      Stella.defineMethodObject("(DEFMETHOD (NEXT? BOOLEAN) ((SELF SUPPORTED-CLOSURE-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.SupportedClosureIterator", "nextP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (NEXT? BOOLEAN) ((SELF DIRECTLY-LINKED-OBJECTS-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.DirectlyLinkedObjectsIterator", "nextP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("ALL-DIRECTLY-LINKED-OBJECTS", "(DEFUN (ALL-DIRECTLY-LINKED-OBJECTS ITERATOR) ((SELF OBJECT) (RELATION SURROGATE) (INVERSE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allDirectlyLinkedObjects", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ALL-DIRECT-SUPERCOLLECTIONS", "(DEFUN (ALL-DIRECT-SUPERCOLLECTIONS (ITERATOR OF LOGIC-OBJECT)) ((SELF LOGIC-OBJECT) (PERFORMFILTERING? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "allDirectSupercollections", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ALL-DIRECT-SUPERCOLLECTIONS-WITH-EQUIVALENTS", "(DEFUN (ALL-DIRECT-SUPERCOLLECTIONS-WITH-EQUIVALENTS (ITERATOR OF LOGIC-OBJECT)) ((SELF LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "allDirectSupercollectionsWithEquivalents", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("ALL-DIRECT-SUBCOLLECTIONS", "(DEFUN (ALL-DIRECT-SUBCOLLECTIONS (ITERATOR OF LOGIC-OBJECT)) ((SELF LOGIC-OBJECT) (PERFORMFILTERING? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "allDirectSubcollections", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ALL-DIRECT-SUBCOLLECTIONS-WITH-EQUIVALENTS", "(DEFUN (ALL-DIRECT-SUBCOLLECTIONS-WITH-EQUIVALENTS (ITERATOR OF LOGIC-OBJECT)) ((SELF LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "allDirectSubcollectionsWithEquivalents", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("ALL-SUPERCOLLECTIONS", "(DEFUN (ALL-SUPERCOLLECTIONS (ITERATOR OF LOGIC-OBJECT)) ((SELF LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "allSupercollections", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("ALL-SUBCOLLECTIONS", "(DEFUN (ALL-SUBCOLLECTIONS (ITERATOR OF LOGIC-OBJECT)) ((SELF LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "allSubcollections", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("ALL-ISA-COLLECTIONS", "(DEFUN (ALL-ISA-COLLECTIONS (CONS OF LOGIC-OBJECT)) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allIsaCollections", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("ALL-SUPPORTED-NAMED-SUBCOLLECTIONS", "(DEFUN (ALL-SUPPORTED-NAMED-SUBCOLLECTIONS (CONS OF CONS)) ((SELF LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "allSupportedNamedSubcollections", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("ALL-DIRECTLY-LINKED-SUBCOLLECTIONS", "(DEFUN (ALL-DIRECTLY-LINKED-SUBCOLLECTIONS TRUE-PROPOSITIONS-ITERATOR) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allDirectlyLinkedSubcollections", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("HELP-ALL-SUPPORTED-NAMED-SUBCOLLECTIONS", "(DEFUN (HELP-ALL-SUPPORTED-NAMED-SUBCOLLECTIONS (CONS OF CONS)) ((SELF LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "helpAllSupportedNamedSubcollections", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("VALUE-CLASHES-WITH-SKOLEM?", "(DEFUN (VALUE-CLASHES-WITH-SKOLEM? BOOLEAN) ((SKOLEM SKOLEM) (VALUE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "valueClashesWithSkolemP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CLASHES-WITH-FUNCTION-PROPOSITION?", "(DEFUN (CLASHES-WITH-FUNCTION-PROPOSITION? BOOLEAN) ((NEXTPROPOSITION PROPOSITION) (REFERENCEPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "clashesWithFunctionPropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineMethodObject("(DEFMETHOD (NEXT? BOOLEAN) ((SELF CLASHING-PROPOSITIONS-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.ClashingPropositionsIterator", "nextP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("ALL-CLASHING-PROPOSITIONS", "(DEFUN (ALL-CLASHING-PROPOSITIONS (ITERATOR OF PROPOSITION)) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "allClashingPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("RELATIONS-WITH-DESCRIPTIONS", "(DEFUN (RELATIONS-WITH-DESCRIPTIONS (LIST OF RELATION)) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "relationsWithDescriptions", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("BUILD-SUBSUMPTION-TAXONOMY-GRAPH", "(DEFUN BUILD-SUBSUMPTION-TAXONOMY-GRAPH ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildSubsumptionTaxonomyGraph", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("CLEAR-IMPLICATION-SUBSUMPTION-GRAPH", "(DEFUN CLEAR-IMPLICATION-SUBSUMPTION-GRAPH ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "clearImplicationSubsumptionGraph", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("INITIALIZE-IMPLICATION-SUBSUMPTION-GRAPH", "(DEFUN INITIALIZE-IMPLICATION-SUBSUMPTION-GRAPH ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "initializeImplicationSubsumptionGraph", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("FIND-DESCRIPTION-IMPLICATION-SUBSUMPTION-NODE", "(DEFUN (FIND-DESCRIPTION-IMPLICATION-SUBSUMPTION-NODE TAXONOMY-NODE) ((DESCRIPTION DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "findDescriptionImplicationSubsumptionNode", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("CREATE-DESCRIPTION-IMPLICATION-SUBSUMPTION-NODE", "(DEFUN (CREATE-DESCRIPTION-IMPLICATION-SUBSUMPTION-NODE TAXONOMY-NODE) ((DESCRIPTION DESCRIPTION) (PARENTNODE TAXONOMY-NODE)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "createDescriptionImplicationSubsumptionNode", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
      Stella.defineFunctionObject("FIND-OR-CREATE-DESCRIPTION-IMPLICATION-SUBSUMPTION-NODE", "(DEFUN (FIND-OR-CREATE-DESCRIPTION-IMPLICATION-SUBSUMPTION-NODE TAXONOMY-NODE) ((DESCRIPTION DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "findOrCreateDescriptionImplicationSubsumptionNode", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("CREATE-DESCRIPTION-FOR-STELLA-RELATION-AND-ANCESTORS", "(DEFUN (CREATE-DESCRIPTION-FOR-STELLA-RELATION-AND-ANCESTORS DESCRIPTION) ((SELF RELATION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createDescriptionForStellaRelationAndAncestors", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Relation")}), null);
      Stella.defineFunctionObject("ADD-TAXONOMY-IMPLIES-SUBSUMES-LINK", "(DEFUN ADD-TAXONOMY-IMPLIES-SUBSUMES-LINK ((TAILDESCRIPTION DESCRIPTION) (HEADDESCRIPTION DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "addTaxonomyImpliesSubsumesLink", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("DROP-TAXONOMY-IMPLIES-SUBSUMES-LINK", "(DEFUN DROP-TAXONOMY-IMPLIES-SUBSUMES-LINK ((TAILDESCRIPTION DESCRIPTION) (HEADDESCRIPTION DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "dropTaxonomyImpliesSubsumesLink", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("TAXONOMY-IMPLIES-OR-IS-SUBSUMED?", "(DEFUN (TAXONOMY-IMPLIES-OR-IS-SUBSUMED? BOOLEAN) ((PREMISE RELATION) (CONCLUSION RELATION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "taxonomyImpliesOrIsSubsumedP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Relation"), Native.find_java_class("edu.isi.stella.Relation")}), null);
      Stella.defineFunctionObject("STARTUP-SPECIALIZE", "(DEFUN STARTUP-SPECIALIZE () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupSpecialize", "startupSpecialize", new java.lang.Class [] {}), null);
      { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_SPECIALIZE);

        KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupSpecialize"), Stella.NULL_STRING_WRAPPER);
      }
    }
  }

  public static void startupSpecialize() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupSpecialize.helpStartupSpecialize1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Logic.EMPTY_PROPOSITIONS_ITERATOR = TruePropositionsIterator.newTruePropositionsIterator();
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          _StartupSpecialize.helpStartupSpecialize2();
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupSpecialize.helpStartupSpecialize3();
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT EMPTY-PROPOSITIONS-ITERATOR (ITERATOR OF PROPOSITION) (NEW TRUE-PROPOSITIONS-ITERATOR) :DOCUMENTATION \"This iterator returns no values whenever its called.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *IMPLICATION-SUBSUMPTION-GRAPH* TAXONOMY-GRAPH NULL)");
          Logic.initializeImplicationSubsumptionGraph();
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
