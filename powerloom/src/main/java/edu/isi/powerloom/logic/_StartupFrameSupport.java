//  -*- Mode: Java -*-
//
// _StartupFrameSupport.java

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

public class _StartupFrameSupport {
  static void helpStartupFrameSupport1() {
    {
      Logic.SGT_PL_KERNEL_KB_SCALAR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SCALAR", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_LOGIC_F_ALL_TAXONOMIC_TYPES_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-ALL-TAXONOMIC-TYPES-MEMO-TABLE-000", null, 1)));
      Logic.SGT_LOGIC_F_ALL_TYPES_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-ALL-TYPES-MEMO-TABLE-000", null, 1)));
      Logic.SGT_LOGIC_F_ALL_EQUIVALENT_RELATIONS_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-ALL-EQUIVALENT-RELATIONS-MEMO-TABLE-000", null, 1)));
      Logic.SGT_LOGIC_F_ALL_SUPERRELATIONS_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-ALL-SUPERRELATIONS-MEMO-TABLE-000", null, 1)));
      Logic.SGT_LOGIC_F_ALL_SUBRELATIONS_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-ALL-SUBRELATIONS-MEMO-TABLE-000", null, 1)));
      Logic.SGT_LOGIC_F_ALL_DIRECT_SUPERRELATIONS_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-ALL-DIRECT-SUPERRELATIONS-MEMO-TABLE-000", null, 1)));
      Logic.SGT_LOGIC_F_ALL_DIRECT_SUBRELATIONS_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-ALL-DIRECT-SUBRELATIONS-MEMO-TABLE-000", null, 1)));
      Logic.SGT_PL_KERNEL_KB_RANGE_MIN_CARDINALITY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("RANGE-MIN-CARDINALITY", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_RANGE_MAX_CARDINALITY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("RANGE-MAX-CARDINALITY", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_RANGE_TYPE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("RANGE-TYPE", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SYM_LOGIC_pCONCEPT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?CONCEPT", null, 0)));
      Logic.SYM_LOGIC_pINSTANCE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?INSTANCE", null, 0)));
      Logic.SYM_LOGIC_M_NORMAL_INFERENCE_LEVELdLEVELLIZED_TEST_TYPE_ON_INSTANCEp_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("M-NORMAL-INFERENCE-LEVEL.LEVELLIZED-TEST-TYPE-ON-INSTANCE?-QUERY-000", null, 0)));
      Logic.SYM_LOGIC_M_NORMAL_INFERENCE_LEVELdLEVELLIZED_ALL_CLASS_INSTANCES_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("M-NORMAL-INFERENCE-LEVEL.LEVELLIZED-ALL-CLASS-INSTANCES-QUERY-000", null, 0)));
      Logic.SYM_LOGIC_pRELATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?RELATION", null, 0)));
      Logic.SYM_LOGIC_M_NORMAL_INFERENCE_LEVELdLEVELLIZED_ALL_RELATION_VALUES_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("M-NORMAL-INFERENCE-LEVEL.LEVELLIZED-ALL-RELATION-VALUES-QUERY-000", null, 0)));
      Logic.SYM_LOGIC_M_NORMAL_INFERENCE_LEVELdLEVELLIZED_ALL_RELATION_VALUES_QUERY_001 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("M-NORMAL-INFERENCE-LEVEL.LEVELLIZED-ALL-RELATION-VALUES-QUERY-001", null, 0)));
      Logic.SYM_LOGIC_pZ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?Z", null, 0)));
      Logic.SYM_LOGIC_M_NORMAL_INFERENCE_LEVELdLEVELLIZED_ALL_RELATION_VALUES_QUERY_002 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("M-NORMAL-INFERENCE-LEVEL.LEVELLIZED-ALL-RELATION-VALUES-QUERY-002", null, 0)));
      Logic.SYM_LOGIC_pW = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?W", null, 0)));
      Logic.SYM_LOGIC_M_NORMAL_INFERENCE_LEVELdLEVELLIZED_ALL_RELATION_VALUES_QUERY_003 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("M-NORMAL-INFERENCE-LEVEL.LEVELLIZED-ALL-RELATION-VALUES-QUERY-003", null, 0)));
      Logic.SYM_LOGIC_ALL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ALL", null, 0)));
      Logic.SYM_LOGIC_M_NORMAL_INFERENCE_LEVELdLEVELLIZED_TEST_RELATION_ON_ARGUMENTSp_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("M-NORMAL-INFERENCE-LEVEL.LEVELLIZED-TEST-RELATION-ON-ARGUMENTS?-QUERY-000", null, 0)));
      Logic.SYM_LOGIC_M_NORMAL_INFERENCE_LEVELdLEVELLIZED_TEST_RELATION_ON_ARGUMENTSp_QUERY_001 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("M-NORMAL-INFERENCE-LEVEL.LEVELLIZED-TEST-RELATION-ON-ARGUMENTS?-QUERY-001", null, 0)));
      Logic.SYM_LOGIC_M_NORMAL_INFERENCE_LEVELdLEVELLIZED_TEST_RELATION_ON_ARGUMENTSp_QUERY_002 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("M-NORMAL-INFERENCE-LEVEL.LEVELLIZED-TEST-RELATION-ON-ARGUMENTS?-QUERY-002", null, 0)));
      Logic.SYM_LOGIC_M_NORMAL_INFERENCE_LEVELdLEVELLIZED_TEST_RELATION_ON_ARGUMENTSp_QUERY_003 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("M-NORMAL-INFERENCE-LEVEL.LEVELLIZED-TEST-RELATION-ON-ARGUMENTS?-QUERY-003", null, 0)));
      Logic.SYM_LOGIC_pOBJECT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?OBJECT", null, 0)));
      Logic.SYM_LOGIC_pN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?N", null, 0)));
      Logic.SYM_LOGIC_RANGE_MIN_CARDINALITY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RANGE-MIN-CARDINALITY", null, 0)));
      Logic.SYM_LOGIC_M_NORMAL_INFERENCE_LEVELdLEVELLIZED_GET_SLOT_MINIMUM_CARDINALITY_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("M-NORMAL-INFERENCE-LEVEL.LEVELLIZED-GET-SLOT-MINIMUM-CARDINALITY-QUERY-000", null, 0)));
      Logic.SYM_LOGIC_RANGE_MAX_CARDINALITY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RANGE-MAX-CARDINALITY", null, 0)));
      Logic.SYM_LOGIC_M_NORMAL_INFERENCE_LEVELdLEVELLIZED_GET_SLOT_MAXIMUM_CARDINALITY_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("M-NORMAL-INFERENCE-LEVEL.LEVELLIZED-GET-SLOT-MAXIMUM-CARDINALITY-QUERY-000", null, 0)));
      Logic.SYM_LOGIC_pTYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?TYPE", null, 0)));
      Logic.SYM_LOGIC_RANGE_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RANGE-TYPE", null, 0)));
      Logic.SYM_LOGIC_BOUND_VARIABLES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BOUND-VARIABLES", null, 0)));
      Logic.SYM_LOGIC_M_NORMAL_INFERENCE_LEVELdLEVELLIZED_ALL_SLOT_VALUE_TYPES_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("M-NORMAL-INFERENCE-LEVEL.LEVELLIZED-ALL-SLOT-VALUE-TYPES-QUERY-000", null, 0)));
      Logic.SYM_LOGIC_STARTUP_FRAME_SUPPORT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-FRAME-SUPPORT", null, 0)));
    }
  }

  static void helpStartupFrameSupport2() {
    {
      Stella.defineFunctionObject("COERCE-TO-INSTANCE-IN-MODULE", "(DEFUN (COERCE-TO-INSTANCE-IN-MODULE OBJECT) ((SELF OBJECT) (MODULE MODULE) (LOCAL? BOOLEAN) (ORIGINAL OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "coerceToInstanceInModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE, Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("GET-INSTANCE", "(DEFUN (GET-INSTANCE OBJECT) ((INSTANCEREF OBJECT)) :DOCUMENTATION \"Return the nearest instance with name 'instanceRef'\nvisible from the current module.  'instanceRef' can be a string, symbol,\nor surrogate.  If 'instanceRef' is a surrogate, the search originates\nin the module the surrogate was interned in.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getInstance", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("FIND-INSTANCE", "(DEFUN (FIND-INSTANCE OBJECT) ((INSTANCEREF OBJECT)) :DOCUMENTATION \"Return the nearest instance with name 'instanceRef'\nvisible from the current module.  'instanceRef' can be a string, symbol,\nor surrogate.  If 'instanceRef' is a surrogate, the search originates\nin the module the surrogate was interned in.\" :COMMAND? TRUE :PUBLIC? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "findInstance", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("GET-SELF-OR-PROTOTYPE", "(DEFUN (GET-SELF-OR-PROTOTYPE LOGIC-OBJECT) ((INSTANCEREF OBJECT)) :DOCUMENTATION \"Used to convert a computation to reference so-called\n'template' slots rather than 'own' slots:  If 'instanceRef' denotes a class,\nreturn a prototype of that class.  Otherwise, return 'instanceRef'.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getSelfOrPrototype", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("GET-CLASS", "(DEFUN (GET-CLASS LOGIC-OBJECT) ((INSTANCEREF OBJECT)) :DOCUMENTATION \"Return the nearest class with name 'instanceRef'\nvisible from the current module.  'instanceRef' can be a string, symbol,\nor surrogate.  If 'instanceRef' is a surrogate, the search originates\nin the module the surrogate was interned in.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getClass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("GET-RELATION", "(DEFUN (GET-RELATION LOGIC-OBJECT) ((INSTANCEREF OBJECT)) :DOCUMENTATION \"Return the nearest relation with name 'instanceRef'\nvisible from the current module.  'instanceRef' can be a string, symbol,\nor surrogate.  If 'instanceRef' is a surrogate, the search originates\nin the module the surrogate was interned in.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getRelation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("GET-MODULE", "(DEFUN (GET-MODULE MODULE) ((MODULEREF OBJECT)) :DOCUMENTATION \"Return a module named 'moduleRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("COLLECTION?", "(DEFUN (COLLECTION? BOOLEAN) ((OBJECTREF OBJECT)) :DOCUMENTATION \"Return TRUE if 'objectRef' denotes a relation or a class.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "collectionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CLASS?", "(DEFUN (CLASS? BOOLEAN) ((OBJECTREF OBJECT)) :DOCUMENTATION \"Return TRUE if 'objectRef' denotes a class.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "classP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("RELATION?", "(DEFUN (RELATION? BOOLEAN) ((OBJECTREF OBJECT)) :DOCUMENTATION \"Return TRUE if 'objectRef' denotes a relation or a class.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "relationP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("FUNCTION?", "(DEFUN (FUNCTION? BOOLEAN) ((RELATIONREF OBJECT)) :DOCUMENTATION \"Return TRUE if 'relationRef' references a function.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "functionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CONSTANT?", "(DEFUN (CONSTANT? BOOLEAN) ((OBJECTREF OBJECT)) :DOCUMENTATION \"Return TRUE if `objectRef' denotes a literal or scalar.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "constantP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("RELATION-NAME", "(DEFUN (RELATION-NAME STRING) ((SELF NAMED-DESCRIPTION)) :DOCUMENTATION \"Given a relation object, return it's name.\")", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "relationName", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("TERMIFY", "(DEFUN (TERMIFY OBJECT) ((SELF OBJECT)) :DOCUMENTATION \"Convert 'self' into an equivalent PowerLoom object\nthat can be passed as an argument wherever an instance is expected.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "termify", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("RELATION-ARITY-OK?", "(DEFUN (RELATION-ARITY-OK? BOOLEAN) ((RELATIONREF SURROGATE) (ARITY INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "relationArityOkP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("FILTER-OUT-UNNAMED-DESCRIPTIONS", "(DEFUN (FILTER-OUT-UNNAMED-DESCRIPTIONS (CONS OF NAMED-DESCRIPTION)) ((DESCRIPTIONS (CONS OF LOGIC-OBJECT))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "filterOutUnnamedDescriptions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("ALL-ASSERTED-TYPES", "(DEFUN (ALL-ASSERTED-TYPES (CONS OF NAMED-DESCRIPTION)) ((SELF OBJECT)) :DOCUMENTATION \"Return a set of all of the types that are\nasserted to be satisfied by 'self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allAssertedTypes", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("ALL-TAXONOMIC-TYPES", "(DEFUN (ALL-TAXONOMIC-TYPES (CONS OF NAMED-DESCRIPTION)) ((SELF OBJECT)) :DOCUMENTATION \"Return a set of all of the types that are\nsatisfied by 'self', using only assertions and upward\ntaxonomic reasoning.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allTaxonomicTypes", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("ALL-TYPES", "(DEFUN (ALL-TYPES (CONS OF NAMED-DESCRIPTION)) ((SELF OBJECT)) :DOCUMENTATION \"Return a set of all of the types that are\nsatisfied by 'self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allTypes", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("HELP-ALL-TYPES", "(DEFUN (HELP-ALL-TYPES (CONS OF NAMED-DESCRIPTION)) ((SELF OBJECT) (DO-SUBTYPES? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "helpAllTypes", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("HELP-ALL-SUBTYPES", "(DEFUN HELP-ALL-SUBTYPES ((SUPER DESCRIPTION) (SELF OBJECT) (TYPES LIST)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "helpAllSubtypes", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("ALL-DIRECT-TYPES", "(DEFUN (ALL-DIRECT-TYPES (CONS OF LOGIC-OBJECT)) ((SELF OBJECT)) :DOCUMENTATION \"Return a set of most specific types that are\nsatisfied by 'self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allDirectTypes", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("TEST-TYPE-ON-INSTANCE?", "(DEFUN (TEST-TYPE-ON-INSTANCE? BOOLEAN) ((SELF OBJECT) (TYPE SURROGATE)) :DOCUMENTATION \"Return TRUE if 'self' satisfies 'type'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "testTypeOnInstanceP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineMethodObject("(DEFMETHOD (LEVELLIZED-TEST-TYPE-ON-INSTANCE? BOOLEAN) ((LEVEL SUBSUMPTION-INFERENCE-LEVEL) (SELF OBJECT) (TYPE SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.SubsumptionInferenceLevel", "levellizedTestTypeOnInstanceP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (LEVELLIZED-TEST-TYPE-ON-INSTANCE? BOOLEAN) ((LEVEL SHALLOW-INFERENCE-LEVEL) (SELF OBJECT) (TYPE SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.ShallowInferenceLevel", "levellizedTestTypeOnInstanceP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("ALL-EQUIVALENT-RELATIONS", "(DEFUN (ALL-EQUIVALENT-RELATIONS (CONS OF NAMED-DESCRIPTION)) ((RELATION NAMED-DESCRIPTION) (REFLEXIVE? BOOLEAN)) :DOCUMENTATION \"Return a list of all relations equivalent to 'relation'.\nIf 'reflexive?', include 'relation' in the list.\")", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "allEquivalentRelations", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("REMOVE-EQUIVALENT-RELATIONS", "(DEFUN (REMOVE-EQUIVALENT-RELATIONS (LIKE SELF)) ((RELATIONSLIST (CONS OF LOGIC-OBJECT)) (RELATION NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "removeEquivalentRelations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("HELP-MEMOIZE-ALL-SUPERRELATIONS", "(DEFUN (HELP-MEMOIZE-ALL-SUPERRELATIONS (CONS OF NAMED-DESCRIPTION)) ((RELATION NAMED-DESCRIPTION) (REMOVEEQUIVALENTS? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "helpMemoizeAllSuperrelations", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ALL-SUPERRELATIONS", "(DEFUN (ALL-SUPERRELATIONS (CONS OF NAMED-DESCRIPTION)) ((RELATION NAMED-DESCRIPTION) (REMOVEEQUIVALENTS? BOOLEAN)) :DOCUMENTATION \"Return a set of all relations that subsume relation.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "allSuperrelations", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("HELP-MEMOIZE-ALL-SUBRELATIONS", "(DEFUN (HELP-MEMOIZE-ALL-SUBRELATIONS (CONS OF NAMED-DESCRIPTION)) ((RELATION NAMED-DESCRIPTION) (REMOVEEQUIVALENTS? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "helpMemoizeAllSubrelations", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ALL-SUBRELATIONS", "(DEFUN (ALL-SUBRELATIONS (CONS OF NAMED-DESCRIPTION)) ((RELATION NAMED-DESCRIPTION) (REMOVEEQUIVALENTS? BOOLEAN)) :DOCUMENTATION \"Return a set of all (named) relations that specialize\nrelation.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "allSubrelations", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ALL-DIRECT-SUPERRELATIONS", "(DEFUN (ALL-DIRECT-SUPERRELATIONS (CONS OF NAMED-DESCRIPTION)) ((RELATION NAMED-DESCRIPTION) (REMOVEEQUIVALENTS? BOOLEAN)) :DOCUMENTATION \"Return a set of relations that immediately subsume\n'relation'.  If 'removeEquivalents?' (recommended), don't include any\nrelations equivalent to 'relation'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "allDirectSuperrelations", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ALL-DIRECT-SUBRELATIONS", "(DEFUN (ALL-DIRECT-SUBRELATIONS (CONS OF NAMED-DESCRIPTION)) ((RELATION NAMED-DESCRIPTION) (REMOVEEQUIVALENTS? BOOLEAN)) :DOCUMENTATION \"Return a set of relations that immediately specialize\n'relation'.  If 'removeEquivalents?' (recommended), don't include any\nrelations equivalent to 'relation'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "allDirectSubrelations", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("TEST-SUBRELATION?", "(DEFUN (TEST-SUBRELATION? BOOLEAN) ((SUBRELATION SURROGATE) (SUPERRELATION SURROGATE)) :DOCUMENTATION \"Return TRUE if 'subrelation' specializes 'superrelation'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "testSubrelationP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("ALL-CLASS-INSTANCES", "(DEFUN (ALL-CLASS-INSTANCES CONS) ((TYPE SURROGATE)) :DOCUMENTATION \"Return a set of instances that belong to the class 'type'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allClassInstances", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineMethodObject("(DEFMETHOD (LEVELLIZED-ALL-CLASS-INSTANCES CONS) ((LEVEL SUBSUMPTION-INFERENCE-LEVEL) (TYPE SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.SubsumptionInferenceLevel", "levellizedAllClassInstances", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (LEVELLIZED-ALL-CLASS-INSTANCES CONS) ((LEVEL ASSERTION-INFERENCE-LEVEL) (TYPE SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.AssertionInferenceLevel", "levellizedAllClassInstances", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("ALL-RELATION-VALUES", "(DEFUN (ALL-RELATION-VALUES CONS) ((RELATION SURROGATE) (NMINUSONEARGUMENTS CONS)) :DOCUMENTATION \"Return a set of values that satisfy the relation\n'relation' (a surrogate) applied to 'nMinusOneArguments' plus that last value.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allRelationValues", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineMethodObject("(DEFMETHOD (LEVELLIZED-ALL-RELATION-VALUES CONS) ((LEVEL SUBSUMPTION-INFERENCE-LEVEL) (RELATION SURROGATE) (NMINUSONEARGUMENTS CONS)))", Native.find_java_method("edu.isi.powerloom.logic.SubsumptionInferenceLevel", "levellizedAllRelationValues", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Cons")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("TEST-RELATION-ON-ARGUMENTS?", "(DEFUN (TEST-RELATION-ON-ARGUMENTS? BOOLEAN) ((RELATION SURROGATE) (ARGUMENTS CONS)) :DOCUMENTATION \"Return TRUE if 'relation' (a surrogate) is TRUE when\napplied to 'arguments'.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "testRelationOnArgumentsP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineMethodObject("(DEFMETHOD (LEVELLIZED-TEST-RELATION-ON-ARGUMENTS? BOOLEAN) ((LEVEL SUBSUMPTION-INFERENCE-LEVEL) (RELATION SURROGATE) (ARGUMENTS CONS)))", Native.find_java_method("edu.isi.powerloom.logic.SubsumptionInferenceLevel", "levellizedTestRelationOnArgumentsP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Cons")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("ALL-SLOT-VALUES", "(DEFUN (ALL-SLOT-VALUES CONS) ((SELF LOGIC-OBJECT) (RELATION SURROGATE)) :DOCUMENTATION \"Return a set of values for the slot 'relation' (a surrogate)\napplied to 'self' (an object).\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "allSlotValues", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("GET-SLOT-VALUE", "(DEFUN (GET-SLOT-VALUE OBJECT) ((SELF LOGIC-OBJECT) (RELATION SURROGATE)) :DOCUMENTATION \"Return a single value for the slot 'relation' (a surrogate)\napplied to 'self' (an object).\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "getSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("TEST-SLOT-VALUE?", "(DEFUN (TEST-SLOT-VALUE? BOOLEAN) ((SELF LOGIC-OBJECT) (RELATION SURROGATE) (FILLER OBJECT)) :DOCUMENTATION \"Return TRUE if the proposition '(<relation> <self> <filler>)'\nis true.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "testSlotValueP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("GET-SLOT-MINIMUM-CARDINALITY", "(DEFUN (GET-SLOT-MINIMUM-CARDINALITY INTEGER) ((SELF LOGIC-OBJECT) (RELATION SURROGATE)) :DOCUMENTATION \"Return a minimum value for the number of fillers of relation\n'relation' (a surrogate) applied to the instance 'self' (an object).\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "getSlotMinimumCardinality", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineMethodObject("(DEFMETHOD (LEVELLIZED-GET-SLOT-MINIMUM-CARDINALITY INTEGER) ((LEVEL SHALLOW-INFERENCE-LEVEL) (SELF LOGIC-OBJECT) (RELATION SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.ShallowInferenceLevel", "levellizedGetSlotMinimumCardinality", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (LEVELLIZED-GET-SLOT-MINIMUM-CARDINALITY INTEGER) ((LEVEL SUBSUMPTION-INFERENCE-LEVEL) (SELF LOGIC-OBJECT) (RELATION SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.SubsumptionInferenceLevel", "levellizedGetSlotMinimumCardinality", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("TEST-CLOSED-SLOT?", "(DEFUN (TEST-CLOSED-SLOT? BOOLEAN) ((RELATION SURROGATE)) :DOCUMENTATION \"Return TRUE if 'relation' (a surrogate) is asserted to \nbe closed or if the current module closes all relations.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "testClosedSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("TEST-FUNCTION-SLOT?", "(DEFUN (TEST-FUNCTION-SLOT? BOOLEAN) ((RELATION SURROGATE)) :DOCUMENTATION \"Return TRUE if 'relation' (a surrogate) is a function.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "testFunctionSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("GET-SLOT-MAXIMUM-CARDINALITY", "(DEFUN (GET-SLOT-MAXIMUM-CARDINALITY INTEGER) ((SELF LOGIC-OBJECT) (RELATION SURROGATE)) :DOCUMENTATION \"Return a maximum value for the number of fillers of relation\n'relation' (a surrogate) applied to the instance 'self' (an object).\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "getSlotMaximumCardinality", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineMethodObject("(DEFMETHOD (LEVELLIZED-GET-SLOT-MAXIMUM-CARDINALITY INTEGER) ((LEVEL SHALLOW-INFERENCE-LEVEL) (SELF LOGIC-OBJECT) (RELATION SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.ShallowInferenceLevel", "levellizedGetSlotMaximumCardinality", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (LEVELLIZED-GET-SLOT-MAXIMUM-CARDINALITY INTEGER) ((LEVEL SUBSUMPTION-INFERENCE-LEVEL) (SELF LOGIC-OBJECT) (RELATION SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.SubsumptionInferenceLevel", "levellizedGetSlotMaximumCardinality", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("GET-SLOT-VALUE-TYPE", "(DEFUN (GET-SLOT-VALUE-TYPE NAMED-DESCRIPTION) ((SELF LOGIC-OBJECT) (RELATION SURROGATE)) :DOCUMENTATION \"Return a most specific type for fillers of the slot 'relation'\n(a surrogate) applied to 'self'. If there is more than one, pick one.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "getSlotValueType", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("ALL-SLOT-VALUE-TYPES", "(DEFUN (ALL-SLOT-VALUE-TYPES (CONS OF NAMED-DESCRIPTION)) ((SELF LOGIC-OBJECT) (RELATION SURROGATE)) :DOCUMENTATION \"Return a set of the most specific types for fillers\nof the slot 'relation' applied to 'self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "allSlotValueTypes", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineMethodObject("(DEFMETHOD (LEVELLIZED-ALL-SLOT-VALUE-TYPES (CONS OF NAMED-DESCRIPTION)) ((LEVEL SHALLOW-INFERENCE-LEVEL) (SELF LOGIC-OBJECT) (RELATION SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.ShallowInferenceLevel", "levellizedAllSlotValueTypes", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (LEVELLIZED-ALL-SLOT-VALUE-TYPES (CONS OF NAMED-DESCRIPTION)) ((LEVEL SUBSUMPTION-INFERENCE-LEVEL) (SELF LOGIC-OBJECT) (RELATION SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.SubsumptionInferenceLevel", "levellizedAllSlotValueTypes", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (LEVELLIZED-TEST-TYPE-ON-INSTANCE? BOOLEAN) ((LEVEL NORMAL-INFERENCE-LEVEL) (SELF OBJECT) (TYPE SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.NormalInferenceLevel", "levellizedTestTypeOnInstanceP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (LEVELLIZED-ALL-CLASS-INSTANCES CONS) ((LEVEL NORMAL-INFERENCE-LEVEL) (TYPE SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.NormalInferenceLevel", "levellizedAllClassInstances", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (LEVELLIZED-ALL-RELATION-VALUES CONS) ((LEVEL NORMAL-INFERENCE-LEVEL) (RELATION SURROGATE) (NMINUSONEARGUMENTS CONS)))", Native.find_java_method("edu.isi.powerloom.logic.NormalInferenceLevel", "levellizedAllRelationValues", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Cons")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (LEVELLIZED-TEST-RELATION-ON-ARGUMENTS? BOOLEAN) ((LEVEL NORMAL-INFERENCE-LEVEL) (RELATION SURROGATE) (ARGUMENTS CONS)))", Native.find_java_method("edu.isi.powerloom.logic.NormalInferenceLevel", "levellizedTestRelationOnArgumentsP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Cons")}), ((java.lang.reflect.Method)(null)));
    }
  }

  public static void startupFrameSupport() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupFrameSupport.helpStartupFrameSupport1();
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupFrameSupport.helpStartupFrameSupport2();
          Stella.defineMethodObject("(DEFMETHOD (LEVELLIZED-GET-SLOT-MINIMUM-CARDINALITY INTEGER) ((LEVEL NORMAL-INFERENCE-LEVEL) (SELF LOGIC-OBJECT) (RELATION SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.NormalInferenceLevel", "levellizedGetSlotMinimumCardinality", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (LEVELLIZED-GET-SLOT-MAXIMUM-CARDINALITY INTEGER) ((LEVEL NORMAL-INFERENCE-LEVEL) (SELF LOGIC-OBJECT) (RELATION SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.NormalInferenceLevel", "levellizedGetSlotMaximumCardinality", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (LEVELLIZED-ALL-SLOT-VALUE-TYPES (CONS OF NAMED-DESCRIPTION)) ((LEVEL NORMAL-INFERENCE-LEVEL) (SELF LOGIC-OBJECT) (RELATION SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.NormalInferenceLevel", "levellizedAllSlotValueTypes", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate")}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("STARTUP-FRAME-SUPPORT", "(DEFUN STARTUP-FRAME-SUPPORT () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupFrameSupport", "startupFrameSupport", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_FRAME_SUPPORT);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupFrameSupport"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *LEVELLIZED-BACKCHAINING-ENABLED?* BOOLEAN FALSE :DOCUMENTATION \"KLUDGE: until we know how to handle recursive subgoals\nacross recursive query invocations, this allows us to disable chaining.\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
