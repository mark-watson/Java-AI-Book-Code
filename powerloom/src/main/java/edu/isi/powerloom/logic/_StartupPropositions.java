//  -*- Mode: Java -*-
//
// _StartupPropositions.java

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

public class _StartupPropositions {
  static void helpStartupPropositions1() {
    {
      Logic.SYM_LOGIC_PROPOSITIONS_INDEX = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PROPOSITIONS-INDEX", null, 0)));
      Logic.SYM_LOGIC_INSTANCES_INDEX = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INSTANCES-INDEX", null, 0)));
      Logic.SGT_LOGIC_BACKLINKS_INDEX = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("BACKLINKS-INDEX", null, 1)));
      Logic.SYM_LOGIC_DEPENDENT_PROPOSITIONS_LIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEPENDENT-PROPOSITIONS-LIST", null, 0)));
      Logic.SYM_LOGIC_DEPENDENT_ISA_PROPOSITIONS_LIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEPENDENT-ISA-PROPOSITIONS-LIST", null, 0)));
      Logic.SYM_LOGIC_PREDICATE_PROPOSITIONS_TABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PREDICATE-PROPOSITIONS-TABLE", null, 0)));
      Logic.SGT_LOGIC_LOGIC_OBJECT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("LOGIC-OBJECT", null, 1)));
      Logic.SYM_STELLA_BADp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BAD?", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_HOME_CONTEXT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("HOME-CONTEXT", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_VARIABLE_VALUE_INVERSE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-VALUE-INVERSE", null, 0)));
      Logic.SYM_STELLA_SURROGATE_VALUE_INVERSE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SURROGATE-VALUE-INVERSE", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_OBJECT_STRINGIFIED_SOURCE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OBJECT-STRINGIFIED-SOURCE", null, 0)));
      Logic.SYM_LOGIC_OBJECT_ORIGINATED_PROPOSITIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OBJECT-ORIGINATED-PROPOSITIONS", null, 0)));
      Logic.SGT_STELLA_CS_VALUE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CS-VALUE", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SYM_STELLA_DELETED_OBJECTp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DELETED-OBJECT?", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SGT_LOGIC_LOGIC_THING = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("LOGIC-THING", null, 1)));
      Logic.SGT_LOGIC_PATTERN_VARIABLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PATTERN-VARIABLE", null, 1)));
      Logic.SGT_LOGIC_SKOLEM = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SKOLEM", null, 1)));
      Logic.SYM_LOGIC_SKOLEM_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SKOLEM-TYPE", null, 0)));
      Logic.SYM_LOGIC_SKOLEM_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SKOLEM-NAME", null, 0)));
      Logic.SYM_LOGIC_VARIABLE_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-VALUE", null, 0)));
      Logic.SYM_LOGIC_DEFINING_PROPOSITION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFINING-PROPOSITION", null, 0)));
      Logic.SYM_LOGIC_BOUND_TO_OFFSET = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BOUND-TO-OFFSET", null, 0)));
      Logic.SYM_STELLA_VARIABLE_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-NAME", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_OBJECT_VECTOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OBJECT-VECTOR", null, 0)));
      Logic.SYM_LOGIC_ARGUMENTS_VECTOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ARGUMENTS-VECTOR", null, 0)));
      Logic.SYM_LOGIC_VARIABLES_VECTOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLES-VECTOR", null, 0)));
      Logic.SGT_LOGIC_FORWARD_CHAINING_INDEX = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FORWARD-CHAINING-INDEX", null, 1)));
      Logic.SYM_LOGIC_FORWARD_GOAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FORWARD-GOAL", null, 0)));
      Logic.SYM_LOGIC_MASTER_RULE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MASTER-RULE", null, 0)));
      Logic.SYM_LOGIC_IO_VARIABLES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IO-VARIABLES", null, 0)));
      Logic.SYM_LOGIC_QUERY_BODY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY-BODY", null, 0)));
      Logic.SYM_LOGIC_INPUT_BINDINGS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INPUT-BINDINGS", null, 0)));
      Logic.SYM_LOGIC_CACHE_ID = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CACHE-ID", null, 0)));
      Logic.SYM_LOGIC_CONSEQUENT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CONSEQUENT", null, 0)));
      Logic.SGT_LOGIC_DESCRIPTION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DESCRIPTION", null, 1)));
      Logic.SYM_LOGIC_FORWARD_CHAINING_INDICES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FORWARD-CHAINING-INDICES", null, 0)));
      Logic.SYM_LOGIC_DEFERRED_CONTRAPOSITIVESp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFERRED-CONTRAPOSITIVES?", null, 0)));
      Logic.SYM_LOGIC_INTERNAL_VARIABLES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INTERNAL-VARIABLES", null, 0)));
      Logic.SYM_LOGIC_QUERY_PATTERNS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY-PATTERNS", null, 0)));
      Logic.SYM_LOGIC_RELATIVE_COMPLEMENT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATIVE-COMPLEMENT", null, 0)));
      Logic.SYM_LOGIC_COMPLEMENT_DESCRIPTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COMPLEMENT-DESCRIPTION", null, 0)));
      Logic.SGT_LOGIC_NAMED_DESCRIPTION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("NAMED-DESCRIPTION", null, 1)));
      Logic.SYM_LOGIC_NATIVE_RELATION_BACK_POINTER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NATIVE-RELATION-BACK-POINTER", null, 0)));
      Logic.SYM_LOGIC_IO_VARIABLE_NAMES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IO-VARIABLE-NAMES", null, 0)));
      Logic.SYM_LOGIC_IO_VARIABLE_TYPES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IO-VARIABLE-TYPES", null, 0)));
      Logic.SYM_STELLA_EXTENSION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EXTENSION", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_PARTIAL_MATCH_SCORE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PARTIAL-MATCH-SCORE", null, 0)));
      Logic.SYM_LOGIC_SET_OF_SUPPORT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SET-OF-SUPPORT", null, 0)));
      Logic.SYM_LOGIC_TIMESTAMP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMESTAMP", null, 0)));
      Logic.KWD_UNKNOWN = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("UNKNOWN", null, 2)));
      Logic.SGT_LOGIC_TRUTH_VALUE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TRUTH-VALUE", null, 1)));
      Logic.SYM_LOGIC_POLARITY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("POLARITY", null, 0)));
      Logic.SYM_LOGIC_STRENGTH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STRENGTH", null, 0)));
      Logic.SYM_LOGIC_POSITIVE_SCORE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("POSITIVE-SCORE", null, 0)));
      Logic.SGT_LOGIC_PARTIAL_SUPPORT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PARTIAL-SUPPORT", null, 1)));
      Logic.SYM_LOGIC_FACT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FACT", null, 0)));
      Logic.SYM_LOGIC_AXIOM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("AXIOM", null, 0)));
      Logic.SYM_LOGIC_SCORE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SCORE", null, 0)));
      Logic.SYM_LOGIC_ID = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ID", null, 0)));
    }
  }

  static void helpStartupPropositions2() {
    {
      Logic.SYM_LOGIC_ARGUMENT_SCORES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ARGUMENT-SCORES", null, 0)));
      Logic.SGT_LOGIC_PROPOSITION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PROPOSITION", null, 1)));
      Logic.SYM_LOGIC_VARIABLE_TYPEp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-TYPE?", null, 0)));
      Logic.SYM_LOGIC_SATELLITE_PROPOSITIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SATELLITE-PROPOSITIONS", null, 0)));
      Logic.SYM_LOGIC_UNFASTENEDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UNFASTENED?", null, 0)));
      Logic.SYM_LOGIC_WEIGHT_DELTA = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WEIGHT-DELTA", null, 0)));
      Logic.SYM_LOGIC_SUPPORT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SUPPORT", null, 0)));
      Logic.SYM_LOGIC_KIND = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("KIND", null, 0)));
      Logic.SYM_STELLA_OPERATOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OPERATOR", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_RELATIONREF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATIONREF", null, 0)));
      Logic.SYM_LOGIC_DEPENDENT_PROPOSITIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEPENDENT-PROPOSITIONS", null, 0)));
      Logic.SYM_LOGIC_PROPOSITION_ORIGINATED_PROPOSITIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PROPOSITION-ORIGINATED-PROPOSITIONS", null, 0)));
      Logic.SYM_LOGIC_PROPOSITION_STRINGIFIED_SOURCE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PROPOSITION-STRINGIFIED-SOURCE", null, 0)));
      Logic.SGT_LOGIC_QUANTITY_LOGIC_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("QUANTITY-LOGIC-WRAPPER", null, 1)));
      Logic.SYM_LOGIC_FUNCTION_TERM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FUNCTION-TERM", null, 0)));
      Logic.SGT_LOGIC_INTEGER_LOGIC_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INTEGER-LOGIC-WRAPPER", null, 1)));
      Logic.SGT_LOGIC_FLOAT_LOGIC_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FLOAT-LOGIC-WRAPPER", null, 1)));
      Logic.SGT_LOGIC_STRING_LOGIC_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("STRING-LOGIC-WRAPPER", null, 1)));
      Logic.SYM_LOGIC_ENTITY_MAPPING = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ENTITY-MAPPING", null, 0)));
      Logic.KWD_AND = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("AND", null, 2)));
      Logic.SGT_PL_KERNEL_KB_AND = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("AND", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.KWD_OR = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("OR", null, 2)));
      Logic.SGT_PL_KERNEL_KB_OR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("OR", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.KWD_NOT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NOT", null, 2)));
      Logic.SGT_PL_KERNEL_KB_NOT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("NOT", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.KWD_FORALL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FORALL", null, 2)));
      Logic.SGT_PL_KERNEL_KB_FORALL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FORALL", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.KWD_EXISTS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("EXISTS", null, 2)));
      Logic.SGT_PL_KERNEL_KB_EXISTS = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("EXISTS", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.KWD_EQUIVALENT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("EQUIVALENT", null, 2)));
      Logic.SGT_PL_KERNEL_KB_EQUIVALENT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("EQUIVALENT", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.KWD_FAIL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FAIL", null, 2)));
      Logic.SGT_PL_KERNEL_KB_FAIL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FAIL", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.KWD_COLLECT_INTO = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("COLLECT-INTO", null, 2)));
      Logic.SGT_PL_KERNEL_KB_COLLECT_INTO = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("COLLECT-INTO", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.KWD_IMPLIES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("IMPLIES", null, 2)));
      Logic.SGT_PL_KERNEL_KB_SUBSET_OF = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SUBSET-OF", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SYM_STELLA_FUNCTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FUNCTION", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_PREDICATE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PREDICATE", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_DESCRIPTIVEp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DESCRIPTIVE?", null, 0)));
      Logic.SYM_STELLA_CODE_ONLYp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CODE-ONLY?", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SGT_LOGIC_EXCEPTION_RECORD = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("EXCEPTION-RECORD", null, 1)));
      Logic.SYM_LOGIC_LOCALLY_CONCEIVED_PROPOSITIONS_INTERNAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LOCALLY-CONCEIVED-PROPOSITIONS-INTERNAL", null, 0)));
      Logic.KWD_CONTEXT_PROPOSITIONS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTEXT-PROPOSITIONS", null, 2)));
      Logic.SYM_LOGIC_LOCALLY_CONCEIVED_INSTANCES_INTERNAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LOCALLY-CONCEIVED-INSTANCES-INTERNAL", null, 0)));
      Logic.KWD_CONTEXT_INSTANCES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTEXT-INSTANCES", null, 2)));
      Logic.KWD_UPDATE_PROPOSITION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("UPDATE-PROPOSITION", null, 2)));
      Logic.KWD_EXECUTE_QUERY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("EXECUTE-QUERY", null, 2)));
      Logic.SYM_LOGIC_BOTTOM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BOTTOM", null, 0)));
      Logic.SGT_STELLA_LITERAL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("LITERAL", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_LOGIC_F_LOGICAL_SUBTYPE_OF_LITERALp_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-LOGICAL-SUBTYPE-OF-LITERAL?-MEMO-TABLE-000", null, 1)));
      Logic.SGT_STELLA_CLASS = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_STELLA_LITERAL_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("LITERAL-WRAPPER", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_STELLA_BOOLEAN = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("BOOLEAN", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_STELLA_BOOLEAN_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("BOOLEAN-WRAPPER", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_PL_KERNEL_KB_VARIABLE_ARITY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-ARITY", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_STELLA_COLLECTION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("COLLECTION", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_PL_KERNEL_KB_RELATION_COMPUTATION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION-COMPUTATION", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_STELLA_THING = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("THING", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.KWD_EXTENSIONAL_ASSERTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("EXTENSIONAL-ASSERTION", null, 2)));
    }
  }

  static void helpStartupPropositions3() {
    {
      Logic.KWD_DESCRIPTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DESCRIPTION", null, 2)));
      Logic.KWD_DEVELOPMENT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DEVELOPMENT", null, 2)));
      Logic.KWD_RETRACT_TRUE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("RETRACT-TRUE", null, 2)));
      Logic.SGT_PL_KERNEL_KB_UPDATE_PROPOSITION_DEMON = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("UPDATE-PROPOSITION-DEMON", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.KWD_FUNCTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FUNCTION", null, 2)));
      Logic.KWD_ISA = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ISA", null, 2)));
      Logic.SGT_PL_KERNEL_KB_GOES_TRUE_DEMON = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("GOES-TRUE-DEMON", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.KWD_PREDICATE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PREDICATE", null, 2)));
      Logic.SGT_PL_KERNEL_KB_GOES_FALSE_DEMON = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("GOES-FALSE-DEMON", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_GOES_UNKNOWN_DEMON = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("GOES-UNKNOWN-DEMON", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SYM_LOGIC_MASTER_PROPOSITION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MASTER-PROPOSITION", null, 0)));
      Logic.KWD_ASSERT_TRUE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ASSERT-TRUE", null, 2)));
      Logic.KWD_PRESUME_TRUE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PRESUME-TRUE", null, 2)));
      Logic.KWD_ASSERT_FALSE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ASSERT-FALSE", null, 2)));
      Logic.KWD_PRESUME_FALSE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PRESUME-FALSE", null, 2)));
      Logic.KWD_RETRACT_FALSE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("RETRACT-FALSE", null, 2)));
      Logic.KWD_ASSERT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ASSERT", null, 2)));
      Logic.KWD_RETRACT_INCONSISTENT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("RETRACT-INCONSISTENT", null, 2)));
      Logic.KWD_RETRACT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("RETRACT", null, 2)));
      Logic.KWD_CONCEIVE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONCEIVE", null, 2)));
      Logic.SGT_PL_KERNEL_KB_HIDDEN_RELATION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("HIDDEN-RELATION", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_LOGIC_HIDDEN_INSTANCE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("HIDDEN-INSTANCE", null, 1)));
      Logic.KWD_MODULE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE", null, 2)));
      Logic.KWD_LOCALp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LOCAL?", null, 2)));
      Logic.KWD_KB_UPDATE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("KB-UPDATE", null, 2)));
      Logic.KWD_META_KB_UPDATE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("META-KB-UPDATE", null, 2)));
      Logic.SGT_STELLA_STORAGE_SLOT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("STORAGE-SLOT", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_STELLA_SURROGATE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SURROGATE", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_STELLA_RELATION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SYM_LOGIC_DESCRIPTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DESCRIPTION", null, 0)));
      Logic.SYM_LOGIC_EQUIVALENT_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EQUIVALENT-VALUE", null, 0)));
      Logic.KWD_TRUE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TRUE", null, 2)));
      Logic.KWD_STRICT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("STRICT", null, 2)));
      Logic.KWD_FALSE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FALSE", null, 2)));
      Logic.KWD_INCONSISTENT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INCONSISTENT", null, 2)));
      Logic.KWD_LOOKUP_ASSERTIONS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LOOKUP-ASSERTIONS", null, 2)));
      Logic.SYM_LOGIC_META_INFERENCE_CACHE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("META-INFERENCE-CACHE", null, 0)));
      Logic.SYM_LOGIC_TRUTH_MAINTAINED_INFERENCE_CACHE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TRUTH-MAINTAINED-INFERENCE-CACHE", null, 0)));
      Logic.SYM_LOGIC_CLASH_EXCEPTIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASH-EXCEPTIONS", null, 0)));
      Logic.SGT_PL_KERNEL_KB_INCOHERENT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INCOHERENT", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SYM_LOGIC_IOTAp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IOTA?", null, 0)));
      Logic.SGT_PL_KERNEL_KB_CONCEPT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONCEPT", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_RELATION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_STELLA_SET = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SET", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_PL_KERNEL_KB_SET = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SET", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_STELLA_SLOT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_PL_KERNEL_KB_FUNCTION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FUNCTION", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_INTERVAL_CACHE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INTERVAL-CACHE", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_ge = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule(">=", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SYM_LOGIC_CONFLICTING_DEFAULT_VALUES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CONFLICTING-DEFAULT-VALUES", null, 0)));
      Logic.KWD_CONSTANT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONSTANT", null, 2)));
      Logic.SGT_STELLA_TRUE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TRUE", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_STELLA_FALSE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FALSE", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SYM_LOGIC_CREATE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CREATE", null, 0)));
      Logic.KWD_INTENSIONAL_ASSERTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INTENSIONAL-ASSERTION", null, 2)));
      Logic.SYM_STELLA_p = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_CLASS_EXTENSION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-EXTENSION", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_TRANSFER_LOGIC_INFORMATION_FROM_RELATION_HOOK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TRANSFER-LOGIC-INFORMATION-FROM-RELATION-HOOK", null, 0)));
      Logic.SYM_LOGIC_SUBRELATION_LINKp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SUBRELATION-LINK?", null, 0)));
      Logic.SGT_PL_KERNEL_KB_HOLDS = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("HOLDS", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
    }
  }

  static void helpStartupPropositions4() {
    {
      Logic.SGT_PL_KERNEL_KB_MEMBER_OF = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("MEMBER-OF", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.KWD_DISABLED = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DISABLED", null, 2)));
      Logic.SYM_LOGIC_ANNOTATIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ANNOTATIONS", null, 0)));
      Logic.SGT_STELLA_STRING_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("STRING-WRAPPER", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SYM_LOGIC_CONSTANT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CONSTANT", null, 0)));
      Logic.SGT_STELLA_SYMBOL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SYMBOL", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SYM_PL_KERNEL_KB_MEMBER_OF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MEMBER-OF", Stella.getStellaModule("/PL-KERNEL-KB", true), 0)));
      Logic.SYM_LOGIC_IMPLIES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IMPLIES", null, 0)));
      Logic.SYM_PL_KERNEL_KB_SUBSET_OF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SUBSET-OF", Stella.getStellaModule("/PL-KERNEL-KB", true), 0)));
      Logic.SYM_STELLA_COLLECT_INTO = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COLLECT-INTO", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SGT_STELLA_GENERALIZED_SYMBOL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("GENERALIZED-SYMBOL", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SYM_LOGIC_FORWARD_ONLYp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FORWARD-ONLY?", null, 0)));
      Logic.SYM_LOGIC_BACKWARD_ONLYp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BACKWARD-ONLY?", null, 0)));
      Logic.KWD_WEIGHT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("WEIGHT", null, 2)));
      Logic.SYM_LOGIC_WEIGHT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WEIGHT", null, 0)));
      Logic.SYM_LOGIC_EQUIVALENT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EQUIVALENT", null, 0)));
      Logic.SGT_STELLA_TABLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TABLE", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_PL_KERNEL_KB_POLYMORPHIC = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("POLYMORPHIC", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_VALUE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("VALUE", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_QUANTITY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("QUANTITY", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_DATE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DATE", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_STELLA_FLOAT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FLOAT", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_STELLA_INTEGER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INTEGER", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.KWD_AUTOMATICALLY_FIX_TYPE_VIOLATIONS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("AUTOMATICALLY-FIX-TYPE-VIOLATIONS", null, 2)));
      Logic.KWD_POST_TYPE_VIOLATIONS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("POST-TYPE-VIOLATIONS", null, 2)));
      Logic.KWD_IGNORE_TYPE_VIOLATIONS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("IGNORE-TYPE-VIOLATIONS", null, 2)));
      Logic.KWD_REPORT_TYPE_VIOLATIONS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("REPORT-TYPE-VIOLATIONS", null, 2)));
      Logic.KWD_SIGNAL_TYPE_VIOLATIONS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SIGNAL-TYPE-VIOLATIONS", null, 2)));
      Logic.SYM_LOGIC_ASSERTED_BY_TYPE_CHECKERp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ASSERTED-BY-TYPE-CHECKER?", null, 0)));
      Logic.SGT_LOGIC_CHECK_TYPES_RECORD = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CHECK-TYPES-RECORD", null, 1)));
      Logic.SYM_LOGIC_PARENT_PROPOSITION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PARENT-PROPOSITION", null, 0)));
      Logic.SYM_LOGIC_PARENT_DESCRIPTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PARENT-DESCRIPTION", null, 0)));
      Logic.KWD_MEDIUM = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MEDIUM", null, 2)));
      Logic.KWD_REALISTIC = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("REALISTIC", null, 2)));
      Logic.SGT_PL_KERNEL_KB_SETOF = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SETOF", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_TOTAL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TOTAL", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_LISTOF = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("LISTOF", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_LIST = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("LIST", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SYM_PL_KERNEL_KB_SETOF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SETOF", Stella.getStellaModule("/PL-KERNEL-KB", true), 0)));
      Logic.SYM_PL_KERNEL_KB_LISTOF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LISTOF", Stella.getStellaModule("/PL-KERNEL-KB", true), 0)));
      Logic.SYM_LOGIC_BAGOF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BAGOF", null, 0)));
      Logic.SYM_STELLA_ASSERT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ASSERT", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.KWD_CPP = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP", null, 2)));
      Logic.KWD_DELETED = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DELETED", null, 2)));
      Logic.SYM_LOGIC_INTRODUCE_MODULE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INTRODUCE-MODULE", null, 0)));
      Logic.SGT_STELLA_KEY_VALUE_LIST = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("KEY-VALUE-LIST", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SYM_LOGIC_CLEAR_LOGIC_MODULE_HOOK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLEAR-LOGIC-MODULE-HOOK", null, 0)));
      Logic.SYM_LOGIC_MONOTONICp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MONOTONIC?", null, 0)));
      Logic.SGT_STELLA_WORLD = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("WORLD", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SYM_LOGIC_DESTROY_LOGIC_CONTEXT_HOOK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DESTROY-LOGIC-CONTEXT-HOOK", null, 0)));
      Logic.SYM_STELLA_CLEARABLEp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLEARABLE?", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_PROTECT_SURROGATESp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PROTECT-SURROGATES?", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.KWD_PREORDER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PREORDER", null, 2)));
      Logic.SGT_STELLA_MUTABLE_STRING_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("MUTABLE-STRING-WRAPPER", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_STELLA_CONTEXT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTEXT", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_LOGIC_COMPUTED_PROCEDURE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("COMPUTED-PROCEDURE", null, 1)));
      Logic.SGT_STELLA_NUMBER_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("NUMBER-WRAPPER", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SYM_LOGIC_STARTUP_PROPOSITIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-PROPOSITIONS", null, 0)));
    }
  }

  static void helpStartupPropositions5() {
    {
      Logic.ZERO_VARIABLES_VECTOR = Vector.newVector(0);
      { PropertyList self004 = PropertyList.newPropertyList();

        self004.thePlist = Cons.list$(Cons.cons(Logic.KWD_AND, Cons.cons(Logic.SGT_PL_KERNEL_KB_AND, Cons.cons(Logic.KWD_OR, Cons.cons(Logic.SGT_PL_KERNEL_KB_OR, Cons.cons(Logic.KWD_NOT, Cons.cons(Logic.SGT_PL_KERNEL_KB_NOT, Cons.cons(Logic.KWD_FORALL, Cons.cons(Logic.SGT_PL_KERNEL_KB_FORALL, Cons.cons(Logic.KWD_EXISTS, Cons.cons(Logic.SGT_PL_KERNEL_KB_EXISTS, Cons.cons(Logic.KWD_EQUIVALENT, Cons.cons(Logic.SGT_PL_KERNEL_KB_EQUIVALENT, Cons.cons(Logic.KWD_FAIL, Cons.cons(Logic.SGT_PL_KERNEL_KB_FAIL, Cons.cons(Logic.KWD_COLLECT_INTO, Cons.cons(Logic.SGT_PL_KERNEL_KB_COLLECT_INTO, Cons.cons(Logic.KWD_IMPLIES, Cons.cons(Logic.SGT_PL_KERNEL_KB_SUBSET_OF, Cons.cons(Stella.NIL, Stella.NIL))))))))))))))))))));
        Logic.$OPERATOR_NAME_TO_SURROGATE_TABLE$ = self004;
      }
      Logic.$LOGIC_MODULE$ = Stella.getStellaModule("LOGIC", true);
      Logic.$PL_KERNEL_MODULE$ = Stella.getStellaModule("PL-KERNEL", true);
      Logic.$LAST_KB_ACTION$ = Logic.KWD_UPDATE_PROPOSITION;
      Logic.$EVALUATIONMODE$.setDefaultValue(Logic.KWD_EXTENSIONAL_ASSERTION);
      Logic.$CLIPPINGENABLEDp$.setDefaultValue(new Boolean(true));
      Logic.$NATURALDEDUCTIONMODEp$.setDefaultValue(new Boolean(true));
      Logic.$COMPUTEDQUERYp$.setDefaultValue(new Boolean(false));
      Logic.$VARIABLEIDCOUNTER$.setDefaultValue(new Integer(0));
      Logic.$FREESKOLEMS$.setDefaultValue(null);
      { TruthValue self005 = TruthValue.newTruthValue();

        self005.polarity = Logic.KWD_TRUE;
        self005.strength = Logic.KWD_STRICT;
        self005.positiveScore = 1.0;
        Logic.TRUE_TRUTH_VALUE = self005;
      }
      { TruthValue self006 = TruthValue.newTruthValue();

        self006.polarity = Logic.KWD_FALSE;
        self006.strength = Logic.KWD_STRICT;
        self006.positiveScore = -1.0;
        Logic.FALSE_TRUTH_VALUE = self006;
      }
      { TruthValue self007 = TruthValue.newTruthValue();

        self007.polarity = Logic.KWD_TRUE;
        self007.strength = Logic.KWD_DEFAULT;
        self007.positiveScore = 0.8;
        Logic.DEFAULT_TRUE_TRUTH_VALUE = self007;
      }
      { TruthValue self008 = TruthValue.newTruthValue();

        self008.polarity = Logic.KWD_FALSE;
        self008.strength = Logic.KWD_DEFAULT;
        self008.positiveScore = -0.8;
        Logic.DEFAULT_FALSE_TRUTH_VALUE = self008;
      }
      { TruthValue self009 = TruthValue.newTruthValue();

        self009.polarity = Logic.KWD_UNKNOWN;
        Logic.UNKNOWN_TRUTH_VALUE = self009;
      }
      { TruthValue self010 = TruthValue.newTruthValue();

        self010.polarity = Logic.KWD_INCONSISTENT;
        self010.strength = Logic.KWD_STRICT;
        Logic.INCONSISTENT_TRUTH_VALUE = self010;
      }
      Logic.$SUPPRESSUNTYPEDTYPEERRORp$.setDefaultValue(new Boolean(false));
      { Proposition self011 = Proposition.newProposition();

        self011.kind = Logic.KWD_CONSTANT;
        self011.operator = Logic.SGT_STELLA_TRUE;
        self011.arguments = Vector.newVector(0);
        { Proposition object013 = self011;
          TruthValue value014 = Logic.TRUE_TRUTH_VALUE;
          Stella_Object oldValue015 = object013.truthValue;
          Stella_Object newValue016 = Stella_Object.updateInContext(oldValue015, value014, object013.homeContext, false);

          if (!((oldValue015 != null) &&
              (oldValue015.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
            object013.truthValue = newValue016;
          }
        }
        self011.homeContext = Logic.$PL_KERNEL_MODULE$;
        Logic.TRUE_PROPOSITION = self011;
      }
      { Proposition self017 = Proposition.newProposition();

        self017.kind = Logic.KWD_CONSTANT;
        self017.operator = Logic.SGT_STELLA_FALSE;
        self017.arguments = Vector.newVector(0);
        { Proposition object019 = self017;
          TruthValue value020 = Logic.FALSE_TRUTH_VALUE;
          Stella_Object oldValue021 = object019.truthValue;
          Stella_Object newValue022 = Stella_Object.updateInContext(oldValue021, value020, object019.homeContext, false);

          if (!((oldValue021 != null) &&
              (oldValue021.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
            object019.truthValue = newValue022;
          }
        }
        self017.homeContext = Logic.$PL_KERNEL_MODULE$;
        Logic.FALSE_PROPOSITION = self017;
      }
      Logic.ANONYMOUS_VARIABLE_NAME = Logic.SYM_STELLA_p;
      Logic.$MISSING_KEY_VALUE_LIST$ = KeyValueList.newKeyValueList();
      Logic.$AUTOMATICINSTANCETABLE$.setDefaultValue(Logic.$MISSING_KEY_VALUE_LIST$);
      Logic.$DEFAULTCREATIONTYPE$.setDefaultValue(null);
      Logic.$STRUCTURED_OBJECTS_INDEX$ = KeyValueMap.newKeyValueMap();
      Logic.$DONT_CHECK_FOR_DUPLICATE_PROPOSITIONSp$.setDefaultValue(new Boolean(false));
      Logic.$VISITEDUNFASTENEDDEFININGPROPOSITIONS$.setDefaultValue(null);
      Logic.$TYPE_CHECK_POLICY$ = Logic.KWD_AUTOMATICALLY_FIX_TYPE_VIOLATIONS;
      Logic.$TYPECHECKMODE$.setDefaultValue(Logic.KWD_POST_TYPE_VIOLATIONS);
      Logic.$CHECK_TYPES_AGENDA$ = VectorSequence.newVectorSequence(4);
      Logic.$DEFERRED_TERMS_TO_UNLINK$.setDefaultValue(null);
    }
  }

  static void helpStartupPropositions6() {
    {
      Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE PROPOSITIONS-INDEX (SEQUENCE-INDEX OF PROPOSITION))");
      Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE INSTANCES-INDEX (SEQUENCE-INDEX OF LOGIC-OBJECT))");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("BACKLINKS-INDEX", "(DEFCLASS BACKLINKS-INDEX (STANDARD-OBJECT) :DOCUMENTATION \"Contains several types of indices pointing at dependent propositions.\" :SLOTS ((DEPENDENT-PROPOSITIONS-LIST :TYPE PROPOSITIONS-INDEX) (DEPENDENT-ISA-PROPOSITIONS-LIST :TYPE PROPOSITIONS-INDEX) (PREDICATE-PROPOSITIONS-TABLE :TYPE (HASH-TABLE OF SURROGATE PROPOSITIONS-INDEX))))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.BacklinksIndex", "newBacklinksIndex", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.BacklinksIndex", "accessBacklinksIndexSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.BacklinksIndex"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      Stella.defineClassFromStringifiedSource("BACKLINKS-MIXIN", "(DEFCLASS BACKLINKS-MIXIN () :DOCUMENTATION \"Inherited by objects that point back at propositions that reference\nthem.\" :SLOTS ((DEPENDENT-PROPOSITIONS-INDEX :TYPE BACKLINKS-INDEX)) :MIXIN? TRUE)");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("LOGIC-OBJECT", "(DEFCLASS LOGIC-OBJECT (CONTEXT-SENSITIVE-OBJECT DYNAMIC-SLOTS-MIXIN BACKLINKS-MIXIN) :DOCUMENTATION \"Object with propositions, and possibly a variable value.\" :PUBLIC-SLOTS ((HOME-CONTEXT :INITIALLY *MODULE*) (VARIABLE-VALUE-INVERSE :TYPE (CONS OF LOGIC-OBJECT) :DEFAULT NIL :CONTEXT-SENSITIVE? TRUE) (EQUIVALENT-VALUE :TYPE DESCRIPTION :CONTEXT-SENSITIVE? TRUE :ALLOCATION :DYNAMIC) (SURROGATE-VALUE-INVERSE :TYPE SURROGATE) (UNDECLARED? :TYPE BOOLEAN :ALLOCATION :DYNAMIC) (HYPOTHESIZED-INSTANCE? :TYPE BOOLEAN :ALLOCATION :DYNAMIC) (OBJECT-STRINGIFIED-SOURCE :TYPE STRING :ALLOCATION :DYNAMIC :READER STRINGIFIED-SOURCE :WRITER STRINGIFIED-SOURCE-SETTER) (OBJECT-ORIGINATED-PROPOSITIONS :TYPE (LIST OF PROPOSITION) :DEFAULT NIL-LIST :ALLOCATION :DYNAMIC :READER ORIGINATED-PROPOSITIONS :WRITER ORIGINATED-PROPOSITIONS-SETTER :DOCUMENTATION \"List of propositions generated by the definition of\nthis object.\")) :PRINT-FORM (PRINT-TOP-LEVEL-OBJECT SELF STREAM) :INITIALIZER LOG-LOGIC-OBJECT)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "newLogicObject", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "accessLogicObjectSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("LOGIC-THING", "(DEFCLASS LOGIC-THING (THING) :DOCUMENTATION \"A subclass of THING so we can add methods to it in\nthe PowerLoom LOGIC module.\")");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.LogicThing", "newLogicThing", new java.lang.Class [] {});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("SKOLEM", "(DEFCLASS SKOLEM (LOGIC-OBJECT) :DOCUMENTATION \"Object whose identity and type are not fixed at creation time.\nPotentially unifiable with any other object.\" :PUBLIC-SLOTS ((SKOLEM-TYPE :TYPE TYPE) (SKOLEM-NAME :TYPE SYMBOL) (VARIABLE-VALUE :TYPE OBJECT :CONTEXT-SENSITIVE? TRUE) (DEFINING-PROPOSITION :TYPE PROPOSITION)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.Skolem", "newSkolem", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.Skolem", "accessSkolemSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("PATTERN-VARIABLE", "(DEFCLASS PATTERN-VARIABLE (SKOLEM) :DOCUMENTATION \"A variable in a logical expression.\" :SLOTS ((BOUND-TO-OFFSET :TYPE INTEGER) (ORIGINAL-SKOLEM-NAME :TYPE SYMBOL :ALLOCATION :DYNAMIC) (VARIABLE-NAME :RENAMES SKOLEM-NAME)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "newPatternVariable", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "accessPatternVariableSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE OBJECT-VECTOR (VECTOR OF OBJECT))");
      Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE ARGUMENTS-VECTOR OBJECT-VECTOR)");
      Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE VARIABLES-VECTOR (VECTOR OF PATTERN-VARIABLE))");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("FORWARD-CHAINING-INDEX", "(DEFCLASS FORWARD-CHAINING-INDEX (STANDARD-OBJECT) :SLOTS ((FORWARD-GOAL :TYPE PROPOSITION) (MASTER-RULE :TYPE PROPOSITION) (IO-VARIABLES :TYPE CONS) (QUERY-BODY :TYPE CONS) (INPUT-BINDINGS :TYPE CONS) (CACHE-ID :TYPE SYMBOL) (CONSEQUENT :TYPE DESCRIPTION)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ForwardChainingIndex", "newForwardChainingIndex", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.ForwardChainingIndex", "accessForwardChainingIndexSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ForwardChainingIndex"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("DESCRIPTION", "(DEFCLASS DESCRIPTION (LOGIC-OBJECT) :PUBLIC-SLOTS ((PROPOSITION :TYPE PROPOSITION) (IO-VARIABLES :TYPE VARIABLES-VECTOR) (INTERNAL-VARIABLES :TYPE VARIABLES-VECTOR :INITIALLY ZERO-VARIABLES-VECTOR :DOCUMENTATION \"The set of internally quantified variables besides the\ndescriptions's IO variables.  This set includes any top-level implicit\nexistential variables plus any variables introduced by some nested quantifier.\nIMPORTANT: therefore, a description's internal variables are not necessarily\nequivalent to its top-level implicit existential variables.\") (EXTERNAL-VARIABLES :TYPE VARIABLES-VECTOR :ALLOCATION :DYNAMIC) (QUERY-PATTERNS :TYPE (KEY-VALUE-LIST OF BOOLEAN-VECTOR DESCRIPTION)) (COMPLEMENT-DESCRIPTION :TYPE DESCRIPTION :ALLOCATION :DYNAMIC) (RELATIVE-COMPLEMENT :RENAMES COMPLEMENT-DESCRIPTION) (TAXONOMY-NODE :TYPE TAXONOMY-NODE :ALLOCATION :DYNAMIC) (IOTA? :TYPE BOOLEAN :ALLOCATION :DYNAMIC) (DONT-OPTIMIZE? :TYPE BOOLEAN :ALLOCATION :DYNAMIC) (FORWARD-CHAINING-INDICES :TYPE (LIST OF FORWARD-CHAINING-INDEX) :ALLOCATION :DYNAMIC) (RULES-WITH-DEFERRED-SATELLITES :TYPE PROPOSITIONS-INDEX :ALLOCATION :DYNAMIC) (DEFERRED-CONTRAPOSITIVES? :TYPE BOOLEAN-WRAPPER :ALLOCATION :DYNAMIC :DEFAULT FALSE)) :METHODS ((NATIVE-RELATION ((SELF DESCRIPTION)) :TYPE RELATION (RETURN NULL))))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.Description", "newDescription", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.Description", "accessDescriptionSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("NAMED-DESCRIPTION", "(DEFCLASS NAMED-DESCRIPTION (DESCRIPTION) :PUBLIC-SLOTS ((IO-VARIABLE-NAMES :TYPE (LIST OF SYMBOL)) (IO-VARIABLE-TYPES :TYPE (LIST OF TYPE)) (EXTENSION :TYPE PROPOSITIONS-INDEX) (OBJECT-STRINGIFIED-SOURCE :ALLOCATION :INSTANCE) (OBJECT-ORIGINATED-PROPOSITIONS :TYPE (LIST OF PROPOSITION) :DEFAULT NIL-LIST :ALLOCATION :INSTANCE :DOCUMENTATION \"List of propositions generated by the definition of\nthis description.\") (NATIVE-RELATION-BACK-POINTER :TYPE RELATION :ALLOCATION :DYNAMIC) (CHECK-FOR-CACHED-GOALS? :TYPE BOOLEAN :ALLOCATION :DYNAMIC) (INVERSE-DESCRIPTION :TYPE NAMED-DESCRIPTION :ALLOCATION :DYNAMIC)) :METHODS ((NATIVE-RELATION ((SELF NAMED-DESCRIPTION)) :TYPE RELATION (RETURN (NATIVE-RELATION-BACK-POINTER SELF))) (NATIVE-RELATION-SETTER ((SELF NAMED-DESCRIPTION) (VALUE RELATION)) (SETF (NATIVE-RELATION-BACK-POINTER SELF) VALUE))))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "newNamedDescription", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "accessNamedDescriptionSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE PARTIAL-MATCH-SCORE FLOAT)");
      Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE SET-OF-SUPPORT LIST)");
      Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE TIMESTAMP INTEGER)");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("TRUTH-VALUE", "(DEFCLASS TRUTH-VALUE (LOGIC-OBJECT) :PUBLIC-SLOTS ((POLARITY :TYPE KEYWORD :INITIALLY :UNKNOWN :DOCUMENTATION \"One of :TRUE, :FALSE, :UNKNOWN or :INCONSISTENT.\") (STRENGTH :TYPE KEYWORD :INITIALLY NULL :DOCUMENTATION \"Either NULL, :STRICT or :DEFAULT.\") (POSITIVE-SCORE :TYPE PARTIAL-MATCH-SCORE :INITIALLY 0.0)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.TruthValue", "newTruthValue", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.TruthValue", "accessTruthValueSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruthValue"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("PARTIAL-SUPPORT", "(DEFCLASS PARTIAL-SUPPORT (STANDARD-OBJECT) :PUBLIC-SLOTS ((FACT :TYPE PROPOSITION) (AXIOM :TYPE PROPOSITION) (SCORE :TYPE FLOAT) (ID :TYPE INTEGER) (ARGUMENT-SCORES :TYPE (CONS OF FLOAT-WRAPPER))))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.PartialSupport", "newPartialSupport", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.PartialSupport", "accessPartialSupportSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PartialSupport"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("PROPOSITION", "(DEFCLASS PROPOSITION (CONTEXT-SENSITIVE-OBJECT DYNAMIC-SLOTS-MIXIN BACKLINKS-MIXIN) :DOCUMENTATION \"\" :PUBLIC-SLOTS ((HOME-CONTEXT :INITIALLY *MODULE*) (KIND :TYPE KEYWORD) (TRUTH-VALUE :TYPE TRUTH-VALUE :CONTEXT-SENSITIVE? TRUE) (ARGUMENTS :TYPE VECTOR) (OPERATOR :TYPE GENERALIZED-SYMBOL) (RELATIONREF :TYPE SURROGATE :RENAMES OPERATOR) (DEPENDENT-PROPOSITIONS :TYPE (NON-PAGING-INDEX OF PROPOSITION) :INITIALLY NIL-NON-PAGING-INDEX) (SURROGATE-VALUE-INVERSE :TYPE SURROGATE :ALLOCATION :DYNAMIC) (IO-VARIABLES :TYPE VARIABLES-VECTOR :ALLOCATION :DYNAMIC) (VARIABLE-TYPE? :TYPE BOOLEAN-WRAPPER :ALLOCATION :DYNAMIC :DEFAULT FALSE) (ASSERTED-BY-TYPE-CHECKER? :TYPE BOOLEAN :ALLOCATION :DYNAMIC) (DESCRIPTIVE? :TYPE BOOLEAN :ALLOCATION :DYNAMIC) (SUBRELATION-LINK? :TYPE BOOLEAN :ALLOCATION :DYNAMIC) (SUBSUMPTION-LINK? :TYPE BOOLEAN :ALLOCATION :DYNAMIC) (SATELLITE-PROPOSITIONS :TYPE (LIST OF PROPOSITION) :ALLOCATION :DYNAMIC) (MASTER-PROPOSITION :TYPE PROPOSITION :ALLOCATION :DYNAMIC) (PROPOSITION-ORIGINATED-PROPOSITIONS :TYPE (LIST OF PROPOSITION) :DEFAULT NIL-LIST :ALLOCATION :DYNAMIC :READER ORIGINATED-PROPOSITIONS :WRITER ORIGINATED-PROPOSITIONS-SETTER :DOCUMENTATION \"List of propositions generated by the definition of\nthis proposition.\") (DONT-OPTIMIZE? :TYPE BOOLEAN :ALLOCATION :DYNAMIC :OPTION-KEYWORD :DONT-OPTIMIZE?) (FORWARD-ONLY? :TYPE BOOLEAN :ALLOCATION :DYNAMIC :OPTION-KEYWORD :FORWARD-ONLY? :OPTION-HANDLER FORWARD-BACKWARD-OPTION-HANDLER) (BACKWARD-ONLY? :TYPE BOOLEAN :ALLOCATION :DYNAMIC :OPTION-KEYWORD :BACKWARD-ONLY? :OPTION-HANDLER FORWARD-BACKWARD-OPTION-HANDLER) (PROPOSITION-STRINGIFIED-SOURCE :TYPE STRING :ALLOCATION :DYNAMIC :READER STRINGIFIED-SOURCE :WRITER STRINGIFIED-SOURCE-SETTER) (UNFASTENED? :TYPE BOOLEAN-WRAPPER :ALLOCATION :DYNAMIC :DEFAULT FALSE) (ANNOTATIONS :TYPE (PROPERTY-LIST OF KEYWORD OBJECT) :ALLOCATION :DYNAMIC) (WEIGHT :TYPE FLOAT :ALLOCATION :DYNAMIC) (NEURAL-NETWORK :TYPE PROPOSITION-NEURAL-NETWORK :ALLOCATION :DYNAMIC) (WEIGHT-DELTA :TYPE FLOAT :DEFAULT 0.0 :ALLOCATION :DYNAMIC) (MATCH-SCORE :TYPE FLOAT :ALLOCATION :DYNAMIC) (SUPPORT :TYPE (CONS OF PARTIAL-SUPPORT) :ALLOCATION :DYNAMIC)) :PRINT-FORM (PRINT-TOP-LEVEL-OBJECT SELF STREAM))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.Proposition", "newProposition", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.Proposition", "accessPropositionSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("QUANTITY-LOGIC-WRAPPER", "(DEFCLASS QUANTITY-LOGIC-WRAPPER (LOGIC-THING) :PUBLIC? TRUE :PUBLIC-SLOTS ((WRAPPER-VALUE :TYPE QUANTITY :REQUIRED? TRUE) (FUNCTION-TERM :TYPE CONS)) :PRINT-FORM (IF *PRINTREADABLY?* (PRINT-NATIVE-STREAM STREAM (WRAPPER-VALUE SELF)) (PRINT-NATIVE-STREAM STREAM \"|Q|\" (WRAPPER-VALUE SELF))))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.QuantityLogicWrapper", "newQuantityLogicWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Quantity")});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.QuantityLogicWrapper", "accessQuantityLogicWrapperSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QuantityLogicWrapper"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("INTEGER-LOGIC-WRAPPER", "(DEFCLASS INTEGER-LOGIC-WRAPPER (INTEGER-WRAPPER BACKLINKS-MIXIN) :PRINT-FORM (IF *PRINTREADABLY?* (PRINT-NATIVE-STREAM STREAM (WRAPPER-VALUE SELF)) (PRINT-NATIVE-STREAM STREAM \"|W|\" (WRAPPER-VALUE SELF))))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.IntegerLogicWrapper", "newIntegerLogicWrapper", new java.lang.Class [] {java.lang.Integer.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("FLOAT-LOGIC-WRAPPER", "(DEFCLASS FLOAT-LOGIC-WRAPPER (FLOAT-WRAPPER BACKLINKS-MIXIN) :PRINT-FORM (IF *PRINTREADABLY?* (PRINT-NATIVE-STREAM STREAM (WRAPPER-VALUE SELF)) (PRINT-NATIVE-STREAM STREAM \"|W|\" (WRAPPER-VALUE SELF))))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.FloatLogicWrapper", "newFloatLogicWrapper", new java.lang.Class [] {java.lang.Double.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("STRING-LOGIC-WRAPPER", "(DEFCLASS STRING-LOGIC-WRAPPER (STRING-WRAPPER BACKLINKS-MIXIN) :PRINT-FORM (LET ((VALUE (WRAPPER-VALUE SELF))) (IF *PRINTREADABLY?* (PRINT-STRING-READABLY VALUE STREAM) (IF (DEFINED? VALUE) (PRINT-NATIVE-STREAM STREAM \"|W|\" #\\\" VALUE #\\\") (PRINT-NATIVE-STREAM STREAM \"|W|\" \"NULL-STRING\")))))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.StringLogicWrapper", "newStringLogicWrapper", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE ENTITY-MAPPING (KEY-VALUE-MAP OF OBJECT OBJECT) :DOCUMENTATION \"Used to keep track of copied or substituted variables\nand propositions within 'copy-description', etc.  This needs to be a\nsubtype of DICTIONARY.  KEY-VALUE-LIST is a good choice for most cases,\nhowever, for very high-arity relations and descriptions we do get bad performance\nduring copying and equivalence checking and KEY-VALUE-MAP (though more\nheavy-weight) would be the better option.\")");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("LOGIC-EXCEPTION", "(DEFCLASS LOGIC-EXCEPTION (STELLA-EXCEPTION))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.LogicException", "newLogicException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("PROPOSITION-ERROR", "(DEFCLASS PROPOSITION-ERROR (LOGIC-EXCEPTION))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.PropositionError", "newPropositionError", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("PARSING-ERROR", "(DEFCLASS PARSING-ERROR (LOGIC-EXCEPTION))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ParsingError", "newParsingError", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CLASH", "(DEFCLASS CLASH (LOGIC-EXCEPTION) :PUBLIC-SLOTS ((PROPOSITION :TYPE PROPOSITION :DOCUMENTATION \"The main proposition involved in the clash\") (CONTEXT :TYPE CONTEXT :DOCUMENTATION \"The context in which the clash occurred\")))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.Clash", "newClash", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("TRUTH-VALUE-CLASH", "(DEFCLASS TRUTH-VALUE-CLASH (CLASH))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.TruthValueClash", "newTruthValueClash", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("INTERVAL-CLASH", "(DEFCLASS INTERVAL-CLASH (CLASH) :PUBLIC-SLOTS ((INTERVAL-MEMBER :TYPE LOGIC-OBJECT :DOCUMENTATION \"The owner of the interval cache that is unsatisfiable.\") (LOWER-BOUND :TYPE OBJECT) (UPPER-BOUND :TYPE OBJECT) (STRICT-LOWER-BOUND? :TYPE BOOLEAN) (STRICT-UPPER-BOUND? :TYPE BOOLEAN)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.IntervalClash", "newIntervalClash", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("VARIABLE-VALUE-CLASH", "(DEFCLASS VARIABLE-VALUE-CLASH (CLASH) :PUBLIC-SLOTS ((SKOLEM :TYPE SKOLEM :DOCUMENTATION \"Skolem which is getting multiple values.\") (VALUE1 :TYPE OBJECT :DOCUMENTATION \"First value in value clash\") (VALUE2 :TYPE OBJECT :DOCUMENTATION \"Second value in value clash\")))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.VariableValueClash", "newVariableValueClash", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("UNIFICATION-CLASH", "(DEFCLASS UNIFICATION-CLASH (CLASH) :PUBLIC-SLOTS ((VALUE1 :TYPE OBJECT :DOCUMENTATION \"First value in unification clash\") (VALUE2 :TYPE OBJECT :DOCUMENTATION \"Second value in unification clash\")))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.UnificationClash", "newUnificationClash", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("FAIL-EXCEPTION", "(DEFCLASS FAIL-EXCEPTION (LOGIC-EXCEPTION))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.FailException", "newFailException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("QUERY-THREAD-LIMIT-VIOLATION", "(DEFCLASS QUERY-THREAD-LIMIT-VIOLATION (LOGIC-EXCEPTION))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.QueryThreadLimitViolation", "newQueryThreadLimitViolation", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("EXCEPTION-RECORD", "(DEFCLASS EXCEPTION-RECORD (STANDARD-OBJECT) :SLOTS ((EXCEPTION :TYPE STELLA-EXCEPTION) (CONTEXT :TYPE CONTEXT) (MODULE :TYPE MODULE)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ExceptionRecord", "newExceptionRecord", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.ExceptionRecord", "accessExceptionRecordSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ExceptionRecord"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("OBJECT-ALREADY-EXISTS-EXCEPTION", "(DEFCLASS OBJECT-ALREADY-EXISTS-EXCEPTION (STELLA-EXCEPTION) :PUBLIC? TRUE :PUBLIC-SLOTS ((EXISTING-OBJECT :TYPE OBJECT)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ObjectAlreadyExistsException", "newObjectAlreadyExistsException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CHECK-TYPES-RECORD", "(DEFCLASS CHECK-TYPES-RECORD (STANDARD-OBJECT) :SLOTS ((PROPOSITION :TYPE PROPOSITION) (PARENT-PROPOSITION :TYPE OBJECT) (PARENT-DESCRIPTION :TYPE DESCRIPTION) (MODULE :TYPE MODULE)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.CheckTypesRecord", "newCheckTypesRecord", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.CheckTypesRecord", "accessCheckTypesRecordSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.CheckTypesRecord"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
    }
  }

  static void helpStartupPropositions7() {
    {
      Stella.defineFunctionObject("LOG-LOGIC-OBJECT", "(DEFUN LOG-LOGIC-OBJECT ((SELF LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "logLogicObject", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineMethodObject("(DEFMETHOD (DELETED? BOOLEAN) ((SELF FORWARD-CHAINING-INDEX)))", Native.find_java_method("edu.isi.powerloom.logic.ForwardChainingIndex", "deletedP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("STRINGIFIED-SOURCE", "(DEFUN (STRINGIFIED-SOURCE STRING) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "stringifiedSource", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("STRINGIFIED-SOURCE-SETTER", "(DEFUN (STRINGIFIED-SOURCE-SETTER STRING) ((SELF OBJECT) (VALUE STRING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "stringifiedSourceSetter", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("ORIGINATED-PROPOSITIONS", "(DEFUN (ORIGINATED-PROPOSITIONS (LIST OF PROPOSITION)) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "originatedPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("ORIGINATED-PROPOSITIONS-SETTER", "(DEFUN (ORIGINATED-PROPOSITIONS-SETTER (LIST OF PROPOSITION)) ((SELF OBJECT) (VALUE (LIST OF PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "originatedPropositionsSetter", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("CREATE-PROPOSITION", "(DEFUN (CREATE-PROPOSITION PROPOSITION) ((KIND SYMBOL) (ARGUMENTCOUNT INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("ENFORCE-CODE-ONLY", "(DEFUN ENFORCE-CODE-ONLY ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "enforceCodeOnly", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("GET-PROPOSITION-BASE-OPERATOR", "(DEFUN (GET-PROPOSITION-BASE-OPERATOR SURROGATE) ((PROP PROPOSITION)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "getPropositionBaseOperator", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT CONTEXT MONOTONIC? :TYPE BOOLEAN :PUBLIC? TRUE :ALLOCATION :DYNAMIC)");
      Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT WORLD TRUTH-MAINTAINED? :TYPE BOOLEAN :PUBLIC? TRUE :ALLOCATION :DYNAMIC)");
      Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT WORLD UP-TO-DATE-INFERENCES? :TYPE BOOLEAN :PUBLIC? TRUE :ALLOCATION :DYNAMIC)");
      Stella.defineFunctionObject("LOGIC-MODULE?", "(DEFUN (LOGIC-MODULE? BOOLEAN) ((SELF MODULE)) :DOCUMENTATION \"Return TRUE if 'self' is a logic module, implying\nthat relations defined within it define a knowledge base.  A module\nis a logic module iff it inherits the module 'PL-KERNEL'.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "logicModuleP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT MODULE LOCALLY-CONCEIVED-PROPOSITIONS-INTERNAL :TYPE PROPOSITIONS-INDEX :ALLOCATION :DYNAMIC)");
      Stella.defineFunctionObject("LOCALLY-CONCEIVED-PROPOSITIONS", "(DEFUN (LOCALLY-CONCEIVED-PROPOSITIONS PROPOSITIONS-INDEX) ((SELF MODULE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "locallyConceivedPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("LOCALLY-CONCEIVED-PROPOSITIONS-SETTER", "(DEFUN LOCALLY-CONCEIVED-PROPOSITIONS-SETTER ((SELF MODULE) (VALUE PROPOSITIONS-INDEX)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "locallyConceivedPropositionsSetter", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.powerloom.logic.SequenceIndex")}), null);
      Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT CONTEXT LOCALLY-CONCEIVED-INSTANCES-INTERNAL :TYPE INSTANCES-INDEX :ALLOCATION :DYNAMIC)");
      Stella.defineFunctionObject("LOCALLY-CONCEIVED-INSTANCES", "(DEFUN (LOCALLY-CONCEIVED-INSTANCES INSTANCES-INDEX) ((SELF CONTEXT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "locallyConceivedInstances", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context")}), null);
      Stella.defineFunctionObject("LOCALLY-CONCEIVED-INSTANCES-SETTER", "(DEFUN LOCALLY-CONCEIVED-INSTANCES-SETTER ((SELF CONTEXT) (VALUE INSTANCES-INDEX)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "locallyConceivedInstancesSetter", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context"), Native.find_java_class("edu.isi.powerloom.logic.SequenceIndex")}), null);
      Stella.defineFunctionObject("INCREMENT-NOW-TIMESTAMP", "(DEFUN INCREMENT-NOW-TIMESTAMP ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "incrementNowTimestamp", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("GET-NOW-TIMESTAMP", "(DEFUN (GET-NOW-TIMESTAMP TIMESTAMP) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getNowTimestamp", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("UPDATE-NOW-TIMESTAMP", "(DEFUN UPDATE-NOW-TIMESTAMP ((KBACTION KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "updateNowTimestamp", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("BOTTOM?", "(DEFUN (BOTTOM? BOOLEAN) ((SELF OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"Return TRUE if 'self' is the undefined individual BOTTOM.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "bottomP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SUBRELATION-OF?", "(DEFUN (SUBRELATION-OF? BOOLEAN) ((DESC1 NAMED-DESCRIPTION) (DESC2 NAMED-DESCRIPTION)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "subrelationOfP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("LOGICAL-SUBTYPE-OF?", "(DEFUN (LOGICAL-SUBTYPE-OF? BOOLEAN) ((TYPE1 SURROGATE) (TYPE2 SURROGATE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "logicalSubtypeOfP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("LOGICAL-SUBTYPE-OF-LITERAL?", "(DEFUN (LOGICAL-SUBTYPE-OF-LITERAL? BOOLEAN) ((TYPE SURROGATE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "logicalSubtypeOfLiteralP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("LITERAL-TYPE?", "(DEFUN (LITERAL-TYPE? BOOLEAN) ((TYPE SURROGATE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "literalTypeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("BOOLEAN-TYPE?", "(DEFUN (BOOLEAN-TYPE? BOOLEAN) ((SELF TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "booleanTypeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("PROPOSITION-TYPE?", "(DEFUN (PROPOSITION-TYPE? BOOLEAN) ((SELF TYPE)) :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (EQL? SELF @PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "propositionTypeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("CLASS-DESCRIPTION?", "(DEFUN (CLASS-DESCRIPTION? BOOLEAN) ((SELF NAMED-DESCRIPTION)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "classDescriptionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("FUNCTION-DESCRIPTION?", "(DEFUN (FUNCTION-DESCRIPTION? BOOLEAN) ((SELF NAMED-DESCRIPTION)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "functionDescriptionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("VARIABLE-ARITY?", "(DEFUN (VARIABLE-ARITY? BOOLEAN) ((SELF DESCRIPTION)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Description", "variableArityP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineMethodObject("(DEFMETHOD (ARITY INTEGER) ((SELF NAMED-DESCRIPTION)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "arity", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (ARITY INTEGER) ((SELF DESCRIPTION)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Description", "arity", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("MONADIC?", "(DEFUN (MONADIC? BOOLEAN) ((SELF OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "monadicP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("COMPUTED-RELATION?", "(DEFUN (COMPUTED-RELATION? BOOLEAN) ((DESCRIPTION NAMED-DESCRIPTION)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "computedRelationP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("LAST-ARGUMENT", "(DEFUN (LAST-ARGUMENT OBJECT) ((PROPOSITION PROPOSITION)) :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (NTH (ARGUMENTS PROPOSITION) (1- (LENGTH (ARGUMENTS PROPOSITION))))))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "lastArgument", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("OBJECT-SURROGATE", "(DEFUN (OBJECT-SURROGATE SURROGATE) ((SELF OBJECT)) :DOCUMENTATION \"Return the surrogate naming the object `self', which\nmay be a Stella class that is used in PowerLoom as well as\na more normal powerloom object.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "objectSurrogate", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("OBJECT-SURROGATE-SETTER", "(DEFUN (OBJECT-SURROGATE-SETTER SURROGATE) ((SELF OBJECT) (NAME SURROGATE)) :DOCUMENTATION \"Return the name of the logic object `self' to `name'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "objectSurrogateSetter", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("OBJECT-NAME", "(DEFUN (OBJECT-NAME SYMBOL) ((SELF OBJECT)) :DOCUMENTATION \"Return the name symbol for the logic object `self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "objectName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("OBJECT-NAME-STRING", "(DEFUN (OBJECT-NAME-STRING STRING) ((SELF OBJECT)) :DOCUMENTATION \"Return the name string for the logic object `self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "objectNameString", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("OBJECT-STRING-NAME", "(DEFUN (OBJECT-STRING-NAME STRING) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "objectStringName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("DESCRIPTION-MODE?", "(DEFUN (DESCRIPTION-MODE? BOOLEAN) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "descriptionModeP", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("NATURAL-DEDUCTION-MODE?", "(DEFUN (NATURAL-DEDUCTION-MODE? BOOLEAN) () :DOCUMENTATION \"True if normalization is governed by natural\ndeduction semantics.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "naturalDeductionModeP", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("CONTEXT-DEPENDENT-SEARCH-MODE?", "(DEFUN (CONTEXT-DEPENDENT-SEARCH-MODE? BOOLEAN) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "contextDependentSearchModeP", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("LOG-NEWLY-CONCEIVED-PROPOSITION", "(DEFUN LOG-NEWLY-CONCEIVED-PROPOSITION ((SELF MODULE) (PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "logNewlyConceivedProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("CLIP-OR-CLASH-WITH-OLD-PREDICATE-VALUE", "(DEFUN CLIP-OR-CLASH-WITH-OLD-PREDICATE-VALUE ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "clipOrClashWithOldPredicateValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("RUN-UPDATE-EQUIVALENCE-PROPOSITION-DEMON", "(DEFUN RUN-UPDATE-EQUIVALENCE-PROPOSITION-DEMON ((PROPOSITION PROPOSITION) (UPDATEMODE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "runUpdateEquivalencePropositionDemon", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("HELP-RUN-UPDATE-PROPOSITION-DEMON", "(DEFUN HELP-RUN-UPDATE-PROPOSITION-DEMON ((PROPOSITION PROPOSITION) (UPDATEMODE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "helpRunUpdatePropositionDemon", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("RUN-UPDATE-PROPOSITION-DEMON", "(DEFUN RUN-UPDATE-PROPOSITION-DEMON ((PROPOSITION PROPOSITION) (UPDATEMODE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "runUpdatePropositionDemon", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("RUN-TRUTH-CHANGE-DEMON", "(DEFUN RUN-TRUTH-CHANGE-DEMON ((PROPOSITION PROPOSITION) (TRUTHCHANGERELATION SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "runTruthChangeDemon", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("RUN-GOES-TRUE-DEMONS", "(DEFUN RUN-GOES-TRUE-DEMONS ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "runGoesTrueDemons", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("RUN-GOES-FALSE-DEMONS", "(DEFUN RUN-GOES-FALSE-DEMONS ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "runGoesFalseDemons", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("RUN-GOES-UNKNOWN-DEMONS", "(DEFUN RUN-GOES-UNKNOWN-DEMONS ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "runGoesUnknownDemons", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("UPDATE-LINKS-AND-TIMESTAMPS", "(DEFUN UPDATE-LINKS-AND-TIMESTAMPS ((PROPOSITION PROPOSITION) (UPDATEMODE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "updateLinksAndTimestamps", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("ASSIGN-TRUTH-VALUE", "(DEFUN ASSIGN-TRUTH-VALUE ((SELF PROPOSITION) (TRUTHVALUE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "assignTruthValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("DEASSIGN-TRUTH-VALUE", "(DEFUN DEASSIGN-TRUTH-VALUE ((SELF PROPOSITION) (UPDATEMODE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "deassignTruthValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("UPDATE-PROPOSITION-TRUTH-VALUE", "(DEFUN UPDATE-PROPOSITION-TRUTH-VALUE ((SELF PROPOSITION) (UPDATEMODE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "updatePropositionTruthValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("ASSIGN-PROPOSITION-WEIGHT", "(DEFUN ASSIGN-PROPOSITION-WEIGHT ((SELF PROPOSITION) (WEIGHT PARTIAL-MATCH-SCORE)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "assignPropositionWeight", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), java.lang.Double.TYPE}), null);
      Stella.defineFunctionObject("TICKLE-CONTEXT", "(DEFUN (TICKLE-CONTEXT CONTEXT) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "tickleContext", new java.lang.Class [] {}), null);
    }
  }

  static void helpStartupPropositions8() {
    {
      Stella.defineFunctionObject("TICKLE-INSTANCES", "(DEFUN (TICKLE-INSTANCES CONTEXT) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "tickleInstances", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("LIST-INCONSISTENT-PROPOSITIONS", "(DEFUN (LIST-INCONSISTENT-PROPOSITIONS (CONS OF PROPOSITION)) (|&REST| (OPTIONS OBJECT)) :DOCUMENTATION \"Return a list of all currently known inconsistent proposition in the module defined\nby the :module option (which defaults to the current module).  If `:local?' is specified\nas TRUE only look in the specified module but not any modules it inherits.  Note, that\nthis simply reports propositions that have been assigned an inconsistent truth value so\nfar (e.g., in clash exceptions), it will not try to detect any new or all inconsistencies\nin a module.\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "listInconsistentPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "listInconsistentPropositionsEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("REACT-TO-SKOLEM-VALUE-UPDATE", "(DEFUN REACT-TO-SKOLEM-VALUE-UPDATE ((SKOLEM SKOLEM) (OLDVALUE OBJECT) (NEWVALUE OBJECT) (TOPLEVELUPDATE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "reactToSkolemValueUpdate", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("NATIVE-SLOT-PROPOSITION?", "(DEFUN (NATIVE-SLOT-PROPOSITION? BOOLEAN) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "nativeSlotPropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("UPDATE-NATIVE-SLOT-PROPOSITION", "(DEFUN (UPDATE-NATIVE-SLOT-PROPOSITION (CONS OF PROPOSITION)) ((PROPOSITION PROPOSITION) (UPDATEMODE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "updateNativeSlotProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("ASSIGN-NATIVE-SLOT-VALUE", "(DEFUN ASSIGN-NATIVE-SLOT-VALUE ((PROP PROPOSITION) (SELF THING) (SLOT STORAGE-SLOT) (VALUE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "assignNativeSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Thing"), Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CLEAR-NATIVE-SLOT-VALUE", "(DEFUN CLEAR-NATIVE-SLOT-VALUE ((OBJECT THING) (SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "clearNativeSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Thing"), Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("DROP-NATIVE-SLOT-VALUE", "(DEFUN DROP-NATIVE-SLOT-VALUE ((SELF THING) (SLOT STORAGE-SLOT) (VALUE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "dropNativeSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Thing"), Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("LOOKUP-SLOTREF-ON-INSTANCE", "(DEFUN (LOOKUP-SLOTREF-ON-INSTANCE SURROGATE) ((TERM OBJECT) (SLOTNAME SYMBOL)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "lookupSlotrefOnInstance", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("UNBOUND?", "(DEFUN (UNBOUND? BOOLEAN) ((SKOLEM SKOLEM)) :GLOBALLY-INLINE? TRUE :PUBLIC? TRUE (RETURN (NULL? (VARIABLE-VALUE SKOLEM))))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "unboundP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem")}), null);
      Stella.defineFunctionObject("VALUE-OF", "(DEFUN (VALUE-OF OBJECT) ((SELF OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "valueOf", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SURROGATE.VALUE-OF", "(DEFUN (SURROGATE.VALUE-OF OBJECT) ((SELF SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "surrogateDvalueOf", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("RELATION.VALUE-OF", "(DEFUN (RELATION.VALUE-OF DESCRIPTION) ((SELF RELATION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "relationDvalueOf", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Relation")}), null);
      Stella.defineFunctionObject("EQUIVALENT-VALUE-OF", "(DEFUN (EQUIVALENT-VALUE-OF OBJECT) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "equivalentValueOf", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("GROUND-VALUE-OF", "(DEFUN (GROUND-VALUE-OF OBJECT) ((SELF OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "groundValueOf", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SKOLEM?", "(DEFUN (SKOLEM? BOOLEAN) ((SELF OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "skolemP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("VARIABLE?", "(DEFUN (VARIABLE? BOOLEAN) ((SELF OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "variableP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("NATIVE-VALUE?", "(DEFUN (NATIVE-VALUE? BOOLEAN) ((SELF OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "nativeValueP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("NATIVE-VALUE-OF", "(DEFUN (NATIVE-VALUE-OF OBJECT) ((SELF OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "nativeValueOf", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("INNERMOST-VARIABLE-OF", "(DEFUN (INNERMOST-VARIABLE-OF PATTERN-VARIABLE) ((SELF PATTERN-VARIABLE)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "innermostVariableOf", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable")}), null);
      Stella.defineFunctionObject("INNERMOST-OF", "(DEFUN (INNERMOST-OF OBJECT) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "innermostOf", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("YIELD-ANONYMOUS-SKOLEM-NAME", "(DEFUN (YIELD-ANONYMOUS-SKOLEM-NAME SYMBOL) ((VARIABLE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "yieldAnonymousSkolemName", new java.lang.Class [] {java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("HELP-CREATE-SKOLEM", "(DEFUN (HELP-CREATE-SKOLEM SKOLEM) ((SELF SKOLEM) (TYPE TYPE) (NAME SYMBOL) (ASSERTISA? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "helpCreateSkolem", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Symbol"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CREATE-SKOLEM", "(DEFUN (CREATE-SKOLEM SKOLEM) ((TYPE TYPE) (NAME SYMBOL)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createSkolem", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("CREATE-VARIABLE", "(DEFUN (CREATE-VARIABLE PATTERN-VARIABLE) ((TYPE TYPE) (NAME SYMBOL) (ASSERTISA? BOOLEAN)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createVariable", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Symbol"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CREATE-VARIABLE-OR-SKOLEM", "(DEFUN (CREATE-VARIABLE-OR-SKOLEM SKOLEM) ((TYPE TYPE) (NAME SYMBOL)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createVariableOrSkolem", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineMethodObject("(DEFMETHOD (OBJECT-EQUAL? BOOLEAN) ((SELF SKOLEM) (OTHER OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "objectEqualP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("TRUE?", "(DEFUN (TRUE? BOOLEAN) ((SELF PROPOSITION)) :DOCUMENTATION \"Return true if `self' is true (or default-true if we are\nconsidering default assertions).\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "trueP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("FALSE?", "(DEFUN (FALSE? BOOLEAN) ((SELF PROPOSITION)) :DOCUMENTATION \"Return true if `self' is false (or default-false if we are\nconsidering default assertions).\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "falseP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("UNKNOWN?", "(DEFUN (UNKNOWN? BOOLEAN) ((SELF PROPOSITION)) :DOCUMENTATION \"Return true if the truth of `self' is unknown.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "unknownP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("INCONSISTENT?", "(DEFUN (INCONSISTENT? BOOLEAN) ((SELF PROPOSITION)) :DOCUMENTATION \"Return true if `self' is inconsistent (true and false).\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "inconsistentP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("DEFAULT-TRUE?", "(DEFUN (DEFAULT-TRUE? BOOLEAN) ((SELF PROPOSITION)) :DOCUMENTATION \"Return true if `self' is default true.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "defaultTrueP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("DEFAULT-FALSE?", "(DEFUN (DEFAULT-FALSE? BOOLEAN) ((SELF PROPOSITION)) :DOCUMENTATION \"Return true if `self' is default false.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "defaultFalseP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("DEFAULTIFY-TRUTH-VALUE", "(DEFUN (DEFAULTIFY-TRUTH-VALUE TRUTH-VALUE) ((TRUE? BOOLEAN) (BYDEFAULT? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "defaultifyTruthValue", new java.lang.Class [] {java.lang.Boolean.TYPE, java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CONJOIN-TRUTH-VALUES", "(DEFUN (CONJOIN-TRUTH-VALUES TRUTH-VALUE) ((TV1 TRUTH-VALUE) (TV2 TRUTH-VALUE)) :DOCUMENTATION \"Return the logical conjunction of truth values `tv1' and `tv2'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.TruthValue", "conjoinTruthValues", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruthValue"), Native.find_java_class("edu.isi.powerloom.logic.TruthValue")}), null);
      Stella.defineFunctionObject("DISJOIN-TRUTH-VALUES", "(DEFUN (DISJOIN-TRUTH-VALUES TRUTH-VALUE) ((TV1 TRUTH-VALUE) (TV2 TRUTH-VALUE)) :DOCUMENTATION \"Return the logical disjunction of truth values `tv1' and `tv2'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.TruthValue", "disjoinTruthValues", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruthValue"), Native.find_java_class("edu.isi.powerloom.logic.TruthValue")}), null);
      Stella.defineFunctionObject("INVERT-TRUTH-VALUE", "(DEFUN (INVERT-TRUTH-VALUE TRUTH-VALUE) ((SELF TRUTH-VALUE)) :DOCUMENTATION \"Return the logical negation of `self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.TruthValue", "invertTruthValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruthValue")}), null);
      Stella.defineFunctionObject("STRONGER-TRUTH-VALUE?", "(DEFUN (STRONGER-TRUTH-VALUE? BOOLEAN) ((TV1 TRUTH-VALUE) (TV2 TRUTH-VALUE)) :DOCUMENTATION \"Compare the two truth values and return `true' if `tv1' is strictly\nstronger than `tv2'.  Stronger uses the following partial order:\n  INCONSISTENT > STRICT > DEFAULT > UNKNOWN.\nTruth values at the same level are equal in strength.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.TruthValue", "strongerTruthValueP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruthValue"), Native.find_java_class("edu.isi.powerloom.logic.TruthValue")}), null);
      Stella.defineFunctionObject("MERGE-TRUTH-VALUES", "(DEFUN (MERGE-TRUTH-VALUES TRUTH-VALUE) ((TV1 TRUTH-VALUE) (TV2 TRUTH-VALUE)) :DOCUMENTATION \"Merge two truth values that are describing the \\\"same\\\" logical\nproposition.  This handles subordination of default to strict values, \nknown over unknown and potential inconsistent values.\n\nIn particular, this can be used to check for negated values by asking for\nthe truth of a proposition and its negation, inverting the negation and then\nusing merge to come up with an answer.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.TruthValue", "mergeTruthValues", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruthValue"), Native.find_java_class("edu.isi.powerloom.logic.TruthValue")}), null);
      Stella.defineFunctionObject("WEAKEN-TRUTH-VALUE", "(DEFUN (WEAKEN-TRUTH-VALUE TRUTH-VALUE) ((TV1 TRUTH-VALUE) (TV2 TRUTH-VALUE)) :DOCUMENTATION \"If `tv2' has lesser strength than `tv1', adapt the strength of `tv1' (not\nits value!) and return the result.  Otherwise, return `tv1' unmodified.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.TruthValue", "weakenTruthValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruthValue"), Native.find_java_class("edu.isi.powerloom.logic.TruthValue")}), null);
      Stella.defineFunctionObject("STRENGTHEN-TRUTH-VALUE", "(DEFUN (STRENGTHEN-TRUTH-VALUE TRUTH-VALUE) ((TV1 TRUTH-VALUE) (TV2 TRUTH-VALUE)) :DOCUMENTATION \"If `tv2' has greater strength than `tv1', adapt the strength of `tv1' (not\nits value!) and return the result.  Otherwise, return `tv1' unmodified.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.TruthValue", "strengthenTruthValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruthValue"), Native.find_java_class("edu.isi.powerloom.logic.TruthValue")}), null);
      Stella.defineFunctionObject("TRUE-TRUTH-VALUE?", "(DEFUN (TRUE-TRUTH-VALUE? BOOLEAN) ((SELF TRUTH-VALUE)) :DOCUMENTATION \"Return TRUE if `self' represents some form of truth.\" :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (OR (EQL? SELF TRUE-TRUTH-VALUE) (EQL? SELF DEFAULT-TRUE-TRUTH-VALUE))))", Native.find_java_method("edu.isi.powerloom.logic.TruthValue", "trueTruthValueP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruthValue")}), null);
      Stella.defineFunctionObject("FALSE-TRUTH-VALUE?", "(DEFUN (FALSE-TRUTH-VALUE? BOOLEAN) ((SELF TRUTH-VALUE)) :DOCUMENTATION \"Return TRUE if `self' represents some form of falsehood.\" :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (OR (EQL? SELF FALSE-TRUTH-VALUE) (EQL? SELF DEFAULT-FALSE-TRUTH-VALUE))))", Native.find_java_method("edu.isi.powerloom.logic.TruthValue", "falseTruthValueP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruthValue")}), null);
      Stella.defineFunctionObject("STRICT-TRUTH-VALUE?", "(DEFUN (STRICT-TRUTH-VALUE? BOOLEAN) ((SELF TRUTH-VALUE)) :DOCUMENTATION \"Return TRUE if `self' is a strict truth value.\" :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (OR (EQL? SELF TRUE-TRUTH-VALUE) (EQL? SELF FALSE-TRUTH-VALUE))))", Native.find_java_method("edu.isi.powerloom.logic.TruthValue", "strictTruthValueP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruthValue")}), null);
      Stella.defineFunctionObject("DEFAULT-TRUTH-VALUE?", "(DEFUN (DEFAULT-TRUTH-VALUE? BOOLEAN) ((SELF TRUTH-VALUE)) :DOCUMENTATION \"Return TRUE if `self' is a default truth value.\" :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (OR (EQL? SELF DEFAULT-TRUE-TRUTH-VALUE) (EQL? SELF DEFAULT-FALSE-TRUTH-VALUE))))", Native.find_java_method("edu.isi.powerloom.logic.TruthValue", "defaultTruthValueP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruthValue")}), null);
      Stella.defineFunctionObject("UNKNOWN-TRUTH-VALUE?", "(DEFUN (UNKNOWN-TRUTH-VALUE? BOOLEAN) ((SELF TRUTH-VALUE)) :DOCUMENTATION \"Return TRUE if `self' represents UNKNOWN.\" :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (OR (EQL? SELF UNKNOWN-TRUTH-VALUE) (NULL? SELF))))", Native.find_java_method("edu.isi.powerloom.logic.TruthValue", "unknownTruthValueP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruthValue")}), null);
      Stella.defineFunctionObject("KNOWN-TRUTH-VALUE?", "(DEFUN (KNOWN-TRUTH-VALUE? BOOLEAN) ((SELF TRUTH-VALUE)) :DOCUMENTATION \"Return TRUE if `self' is a known truth value, that is\neither TRUE or FALSE, but not UNKNOWN, INCONSISTENT, etc.\")", Native.find_java_method("edu.isi.powerloom.logic.TruthValue", "knownTruthValueP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruthValue")}), null);
      Stella.defineFunctionObject("INCONSISTENT-TRUTH-VALUE?", "(DEFUN (INCONSISTENT-TRUTH-VALUE? BOOLEAN) ((SELF TRUTH-VALUE)) :DOCUMENTATION \"Return TRUE if `self' represents INCONSISTENT.\" :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (EQL? SELF INCONSISTENT-TRUTH-VALUE)))", Native.find_java_method("edu.isi.powerloom.logic.TruthValue", "inconsistentTruthValueP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruthValue")}), null);
      Stella.defineFunctionObject("TRUTH-VALUE-TO-STRING", "(DEFUN (TRUTH-VALUE-TO-STRING STRING) ((SELF TRUTH-VALUE) (ABBREVIATE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.TruthValue", "truthValueToString", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruthValue"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("PRINT-TRUTH-VALUE", "(DEFUN PRINT-TRUTH-VALUE ((SELF TRUTH-VALUE) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.TruthValue", "printTruthValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TruthValue"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineFunctionObject("SIGNAL-UNIFICATION-CLASH", "(DEFUN SIGNAL-UNIFICATION-CLASH ((PROP PROPOSITION) (TERM1 OBJECT) (TERM2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "signalUnificationClash", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SIGNAL-VARIABLE-VALUE-CLASH", "(DEFUN SIGNAL-VARIABLE-VALUE-CLASH ((PROP PROPOSITION) (SKOLEM SKOLEM) (VALUE1 OBJECT) (VALUE2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "signalVariableValueClash", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Skolem"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SIGNAL-TRUTH-VALUE-CLASH", "(DEFUN SIGNAL-TRUTH-VALUE-CLASH ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "signalTruthValueClash", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT PROPOSITION CLASH-EXCEPTIONS :TYPE (CONS OF EXCEPTION-RECORD) :DEFAULT NIL :DOCUMENTATION \"Stores a set of clash exception records that occurred for a\nparticular 'inchoherent' proposition.\" :ALLOCATION :DYNAMIC)");
      Stella.defineFunctionObject("GET-VISIBLE-CLASH-EXCEPTIONS", "(DEFUN (GET-VISIBLE-CLASH-EXCEPTIONS (CONS OF EXCEPTION-RECORD)) ((INCOHERENTPROP PROPOSITION)) :DOCUMENTATION \"Return the set of clash exceptions for 'incoherentProp' that are visible from the\ncurrent context.  These are recorded most-recent first in order of occurrance.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "getVisibleClashExceptions", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("HANDLE-CLASH-EXCEPTION", "(DEFUN HANDLE-CLASH-EXCEPTION ((CLASHEXCEPTION CLASH)))", Native.find_java_method("edu.isi.powerloom.logic.Clash", "handleClashException", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Clash")}), null);
      Stella.defineFunctionObject("LOGICAL-TYPE", "(DEFUN (LOGICAL-TYPE TYPE) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "logicalType", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SAFE-LOGICAL-TYPE", "(DEFUN (SAFE-LOGICAL-TYPE TYPE) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "safeLogicalType", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CLASS-LOGICAL-TYPE", "(DEFUN (CLASS-LOGICAL-TYPE TYPE) ((SELF CLASS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "classLogicalType", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("UNIFY-TYPES", "(DEFUN UNIFY-TYPES ((PROP PROPOSITION) (TERM1 SKOLEM) (TERM2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "unifyTypes", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Skolem"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
    }
  }

  static void helpStartupPropositions9() {
    {
      Stella.defineFunctionObject("UNIFY-SKOLEM-AND-VALUE", "(DEFUN UNIFY-SKOLEM-AND-VALUE ((SKOLEM SKOLEM) (VALUE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "unifySkolemAndValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("BIND-SKOLEM-TO-VALUE", "(DEFUN BIND-SKOLEM-TO-VALUE ((FROMSKOLEM SKOLEM) (TOVALUE OBJECT) (TOPLEVELUPDATE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "bindSkolemToValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("UNBIND-SKOLEM-VALUE", "(DEFUN UNBIND-SKOLEM-VALUE ((SKOLEM SKOLEM) (TOPLEVELUPDATE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "unbindSkolemValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("HAS-EQUIVALENT-VALUES?", "(DEFUN (HAS-EQUIVALENT-VALUES? BOOLEAN) ((TERM OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "hasEquivalentValuesP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("GET-EQUIVALENT-VALUES", "(DEFUN (GET-EQUIVALENT-VALUES CONS) ((TERM OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getEquivalentValues", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CONSTRAIN-AS-SUBSET", "(DEFUN CONSTRAIN-AS-SUBSET ((PROP PROPOSITION) (SET1 COLLECTION) (SET2 COLLECTION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "constrainAsSubset", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Collection"), Native.find_java_class("edu.isi.stella.Collection")}), null);
      Stella.defineFunctionObject("EQUATE-COLLECTIONS", "(DEFUN EQUATE-COLLECTIONS ((PROP PROPOSITION) (COL1 COLLECTION) (COL2 COLLECTION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "equateCollections", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Collection"), Native.find_java_class("edu.isi.stella.Collection")}), null);
      Stella.defineFunctionObject("LOGIC-COLLECTION?", "(DEFUN (LOGIC-COLLECTION? BOOLEAN) ((TERM OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "logicCollectionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("EQUATE-VALUES", "(DEFUN EQUATE-VALUES ((PROP PROPOSITION) (TERM1 OBJECT) (TERM2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "equateValues", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT SKOLEM CONFLICTING-DEFAULT-VALUES :TYPE (CONS OF PROPOSITION) :DEFAULT NIL :ALLOCATION :DYNAMIC)");
      Stella.defineFunctionObject("UNEQUATE-CONFLICTING-DEFAULT-VALUES?", "(DEFUN (UNEQUATE-CONFLICTING-DEFAULT-VALUES? BOOLEAN) ((NEWEQUATINGPROP PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "unequateConflictingDefaultValuesP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("UNEQUATE-VALUES?", "(DEFUN (UNEQUATE-VALUES? BOOLEAN) ((TERM1 OBJECT) (TERM2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "unequateValuesP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("BIND-TO-EQUIVALENT-VALUE", "(DEFUN BIND-TO-EQUIVALENT-VALUE ((FROM LOGIC-OBJECT) (TO DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "bindToEquivalentValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("UNBIND-EQUIVALENT-VALUE", "(DEFUN UNBIND-EQUIVALENT-VALUE ((SELF LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "unbindEquivalentValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("UNLINK-EQUIVALENT-VALUE", "(DEFUN UNLINK-EQUIVALENT-VALUE ((SELF LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "unlinkEquivalentValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("EQUIVALENT-COLLECTION-PRIORITY", "(DEFUN (EQUIVALENT-COLLECTION-PRIORITY INTEGER) ((SELF LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "equivalentCollectionPriority", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("EQUIVALENCE-COLLECTIONS", "(DEFUN EQUIVALENCE-COLLECTIONS ((COLLECTION1 LOGIC-OBJECT) (COLLECTION2 LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "equivalenceCollections", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("REVISE-EQUIVALENCES", "(DEFUN REVISE-EQUIVALENCES ((PROPOSITION PROPOSITION) (GOESTRUE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "reviseEquivalences", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("FIND-EQUATING-PROPOSITION", "(DEFUN (FIND-EQUATING-PROPOSITION PROPOSITION) ((DIRECTOBJECT OBJECT) (INDIRECTOBJECT LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "findEquatingProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("CONSTANT-PROPOSITION?", "(DEFUN (CONSTANT-PROPOSITION? BOOLEAN) ((SELF PROPOSITION)) :DOCUMENTATION \"Return true if `self' is a constant such as TRUE or FALSE.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "constantPropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("EVALUATE-TERM", "(DEFUN (EVALUATE-TERM OBJECT) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "evaluateTerm", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("EVALUATE-LITERAL-WRAPPER-TERM", "(DEFUN (EVALUATE-LITERAL-WRAPPER-TERM OBJECT) ((SELF LITERAL-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "evaluateLiteralWrapperTerm", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.LiteralWrapper")}), null);
      Stella.defineFunctionObject("EVALUATE-SURROGATE-TERM", "(DEFUN (EVALUATE-SURROGATE-TERM OBJECT) ((SELF SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "evaluateSurrogateTerm", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("EVALUATE-LOGIC-OBJECT-TERM", "(DEFUN (EVALUATE-LOGIC-OBJECT-TERM OBJECT) ((SELF LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "evaluateLogicObjectTerm", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("ANONYMOUS-VARIABLE?", "(DEFUN (ANONYMOUS-VARIABLE? BOOLEAN) ((SELF SKOLEM)))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "anonymousVariableP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem")}), null);
      Stella.defineFunctionObject("EVALUATE-SYMBOL-TERM", "(DEFUN (EVALUATE-SYMBOL-TERM OBJECT) ((SELF SYMBOL)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "evaluateSymbolTerm", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("EVALUATE-AUTOMATIC-INSTANCE", "(DEFUN (EVALUATE-AUTOMATIC-INSTANCE OBJECT) ((NAME SYMBOL)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "evaluateAutomaticInstance", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("SIGNAL-UNDEFINED-TERM", "(DEFUN SIGNAL-UNDEFINED-TERM ((TERM OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "signalUndefinedTerm", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SIGNAL-UNTYPED-TERM", "(DEFUN SIGNAL-UNTYPED-TERM ((TERM OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "signalUntypedTerm", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("EVALUATE-CREATE-TERM", "(DEFUN (EVALUATE-CREATE-TERM OBJECT) ((TERM CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "evaluateCreateTerm", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CREATE", "(DEFUN (CREATE OBJECT) ((NAME GENERALIZED-SYMBOL) |&REST| (TYPE GENERALIZED-SYMBOL)) :DOCUMENTATION \"Create a logic object with name 'name' and return it.\nIf `type' is also supplied, assert that the object belongs to that type.\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "create", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol"), Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "createEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("UPDATE-SKOLEM-TYPE", "(DEFUN UPDATE-SKOLEM-TYPE ((SELF SKOLEM) (TYPE TYPE)))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "updateSkolemType", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("UPDATE-SKOLEM-TYPE-FROM-ISA-ASSERTIONS", "(DEFUN UPDATE-SKOLEM-TYPE-FROM-ISA-ASSERTIONS ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "updateSkolemTypeFromIsaAssertions", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("DESCRIPTION-EXTENSION<", "(DEFUN (DESCRIPTION-EXTENSION< BOOLEAN) ((DESC1 DESCRIPTION) (DESC2 DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "descriptionExtensionL", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("PRINT-EXTENSION-SIZES", "(DEFUN PRINT-EXTENSION-SIZES ((MODULE MODULE) (SIZECUTOFF INTEGER)) :DOCUMENTATION \"Print the extension sizes of concepts visible in `module'.\nIf `module' is NULL the current module is used.  Do not report extensions\nwith size less than `sizeCutoff' (default is 10).\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printExtensionSizes", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("TRANSFER-LOGIC-INFORMATION-FROM-RELATION-HOOK", "(DEFUN TRANSFER-LOGIC-INFORMATION-FROM-RELATION-HOOK ((RELATIONSLIST (LIST OF RELATION))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "transferLogicInformationFromRelationHook", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("RETRACT-RELATION-AXIOMS", "(DEFUN RETRACT-RELATION-AXIOMS ((OLDRELATION NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "retractRelationAxioms", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("ASSERT-DESCRIPTION-IMPLIES-DESCRIPTION", "(DEFUN (ASSERT-DESCRIPTION-IMPLIES-DESCRIPTION PROPOSITION) ((SUB DESCRIPTION) (SUPER DESCRIPTION) (DONTUPDATE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "assertDescriptionImpliesDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.powerloom.logic.Description"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ASSERT-IMPLIES-LINK-BETWEEN-RELATIONS", "(DEFUN (ASSERT-IMPLIES-LINK-BETWEEN-RELATIONS PROPOSITION) ((SUB NAMED-DESCRIPTION) (SUPER NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "assertImpliesLinkBetweenRelations", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("FINALIZE-SUPERRELATION-LINKS", "(DEFUN FINALIZE-SUPERRELATION-LINKS ((SELF RELATION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "finalizeSuperrelationLinks", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Relation")}), null);
      Stella.defineFunctionObject("UPDATE-ISA-PROPOSITION", "(DEFUN (UPDATE-ISA-PROPOSITION PROPOSITION) ((SELF OBJECT) (TYPE TYPE) (UPDATEMODE KEYWORD)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "updateIsaProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("ASSERT-ISA-PROPOSITION", "(DEFUN (ASSERT-ISA-PROPOSITION PROPOSITION) ((SELF OBJECT) (TYPE TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "assertIsaProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("RETRACT-ISA-PROPOSITION", "(DEFUN (RETRACT-ISA-PROPOSITION PROPOSITION) ((SELF OBJECT) (TYPE TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "retractIsaProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("UPDATE-PROPERTY", "(DEFUN (UPDATE-PROPERTY PROPOSITION) ((SELF LOGIC-OBJECT) (SURROGATE SURROGATE) (UPDATEMODE KEYWORD)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "updateProperty", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("ASSERT-PROPERTY", "(DEFUN (ASSERT-PROPERTY PROPOSITION) ((INSTANCE LOGIC-OBJECT) (PROPERTY SURROGATE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "assertProperty", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("RETRACT-PROPERTY", "(DEFUN (RETRACT-PROPERTY PROPOSITION) ((INSTANCE LOGIC-OBJECT) (PROPERTY SURROGATE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "retractProperty", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("UPDATE-TUPLE", "(DEFUN (UPDATE-TUPLE PROPOSITION) ((RELATION SURROGATE) (ARGUMENTS (CONS OF OBJECT)) (UPDATEMODE KEYWORD)) :DOCUMENTATION \"Assert or retract a proposition that applies 'relation' to 'arguments'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "updateTuple", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("ASSERT-TUPLE", "(DEFUN (ASSERT-TUPLE PROPOSITION) ((RELATION SURROGATE) (ARGUMENTS (CONS OF OBJECT))) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "assertTuple", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("UPDATE-BINARY-VALUE", "(DEFUN (UPDATE-BINARY-VALUE PROPOSITION) ((RELATION SURROGATE) (SELF OBJECT) (VALUE OBJECT) (UPDATEMODE KEYWORD)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "updateBinaryValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("ASSERT-BINARY-VALUE", "(DEFUN (ASSERT-BINARY-VALUE PROPOSITION) ((RELATION SURROGATE) (SELF OBJECT) (VALUE OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "assertBinaryValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("RETRACT-BINARY-VALUE", "(DEFUN (RETRACT-BINARY-VALUE PROPOSITION) ((RELATION SURROGATE) (SELF OBJECT) (VALUE OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "retractBinaryValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("ASSERT-MEMBER-OF-PROPOSITION", "(DEFUN (ASSERT-MEMBER-OF-PROPOSITION PROPOSITION) ((SELF OBJECT) (COLLECTION OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "assertMemberOfProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("HELP-CREATE-LOGIC-INSTANCE", "(DEFUN (HELP-CREATE-LOGIC-INSTANCE OBJECT) ((NAME SURROGATE) (TYPE SURROGATE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "helpCreateLogicInstance", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("CREATE-LOGIC-INSTANCE", "(DEFUN (CREATE-LOGIC-INSTANCE OBJECT) ((NAME SURROGATE) (TYPE SURROGATE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createLogicInstance", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("CLEANUP-STRUCTURED-OBJECTS-INDEX", "(DEFUN CLEANUP-STRUCTURED-OBJECTS-INDEX ((CLEARMODULE MODULE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "cleanupStructuredObjectsIndex", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("PROPOSITION-HASH-INDEX", "(DEFUN (PROPOSITION-HASH-INDEX INTEGER) ((SELF PROPOSITION) (MAPPING ENTITY-MAPPING) (DEREFSURROGATES? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "propositionHashIndex", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueMap"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("LOOKUP-MATCHING-PROPOSITION-IN-BUCKET", "(DEFUN (LOOKUP-MATCHING-PROPOSITION-IN-BUCKET PROPOSITION) ((BUCKET LIST) (SELF PROPOSITION) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "lookupMatchingPropositionInBucket", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("FIND-DUPLICATE-COMPLEX-PROPOSITION", "(DEFUN (FIND-DUPLICATE-COMPLEX-PROPOSITION PROPOSITION) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "findDuplicateComplexProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("FIND-DUPLICATE-PROPOSITION", "(DEFUN (FIND-DUPLICATE-PROPOSITION PROPOSITION) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "findDuplicateProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("FIND-MATCHING-NON-DESCRIPTIVE-PROPOSITION", "(DEFUN (FIND-MATCHING-NON-DESCRIPTIVE-PROPOSITION PROPOSITION) ((SELF PROPOSITION) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "findMatchingNonDescriptiveProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
    }
  }

  static void helpStartupPropositions10() {
    {
      Stella.defineFunctionObject("FASTEN-DOWN-ONE-PROPOSITION", "(DEFUN (FASTEN-DOWN-ONE-PROPOSITION PROPOSITION) ((SELF PROPOSITION) (DONTCHECKFORDUPLICATES? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "fastenDownOneProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("HELP-FASTEN-DOWN-PROPOSITIONS", "(DEFUN (HELP-FASTEN-DOWN-PROPOSITIONS PROPOSITION) ((SELF PROPOSITION) (DONTCHECKFORDUPLICATES? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "helpFastenDownPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("RECURSIVELY-FASTEN-DOWN-PROPOSITIONS", "(DEFUN (RECURSIVELY-FASTEN-DOWN-PROPOSITIONS PROPOSITION) ((SELF PROPOSITION) (DONTCHECKFORDUPLICATES? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "recursivelyFastenDownPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("UNFASTEN-PROPOSITION", "(DEFUN UNFASTEN-PROPOSITION ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "unfastenProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("INSTANTIATE-UNDEFINED-SURROGATES", "(DEFUN INSTANTIATE-UNDEFINED-SURROGATES ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "instantiateUndefinedSurrogates", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("BUILD-TOP-LEVEL-PROPOSITION", "(DEFUN (BUILD-TOP-LEVEL-PROPOSITION PROPOSITION) ((TREE OBJECT) (TRUEASSERTION? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildTopLevelProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("BUILD-PROPOSITION", "(DEFUN (BUILD-PROPOSITION OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SURROGATE.BUILD-PROPOSITION", "(DEFUN (SURROGATE.BUILD-PROPOSITION PROPOSITION) ((SELF SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "surrogateDbuildProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("SYMBOL.BUILD-PROPOSITION", "(DEFUN (SYMBOL.BUILD-PROPOSITION OBJECT) ((SYMBOL SYMBOL)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "symbolDbuildProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("CONS.BUILD-PROPOSITION", "(DEFUN (CONS.BUILD-PROPOSITION PROPOSITION) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "consDbuildProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("VERIFY-NUMBER-OF-PROPOSITION-ARGUMENTS", "(DEFUN VERIFY-NUMBER-OF-PROPOSITION-ARGUMENTS ((TREE CONS) (CORRECTNUMBER INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "verifyNumberOfPropositionArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Integer.TYPE}), null);
      Stella.defineMethodObject("(DEFMETHOD (DESCRIPTION-SURROGATE TYPE) ((SELF DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "descriptionSurrogate", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("BUILD-ISA-PROPOSITION", "(DEFUN (BUILD-ISA-PROPOSITION PROPOSITION) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildIsaProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("BUILD-MEMBER-OF-PROPOSITION", "(DEFUN (BUILD-MEMBER-OF-PROPOSITION PROPOSITION) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildMemberOfProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("MEMBER-OF-PROPOSITION?", "(DEFUN (MEMBER-OF-PROPOSITION? BOOLEAN) ((PROPOSITION PROPOSITION)) :GLOBALLY-INLINE? TRUE (RETURN (EQL? (OPERATOR PROPOSITION) /PL-KERNEL-KB/@MEMBER-OF)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "memberOfPropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("SUBSET-OF-PROPOSITION?", "(DEFUN (SUBSET-OF-PROPOSITION? BOOLEAN) ((PROPOSITION PROPOSITION)) :GLOBALLY-INLINE? TRUE (RETURN (EQL? (OPERATOR PROPOSITION) /PL-KERNEL-KB/@SUBSET-OF)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "subsetOfPropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("SIMPLE-SUBRELATION-PROPOSITION?", "(DEFUN (SIMPLE-SUBRELATION-PROPOSITION? BOOLEAN) ((PROPOSITION PROPOSITION)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "simpleSubrelationPropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("EXTRACT-ANNOTATION", "(DEFUN (EXTRACT-ANNOTATION OBJECT OBJECT) ((TREE OBJECT) (OPTION KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "extractAnnotation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("LOOKUP-ANNOTATION", "(DEFUN (LOOKUP-ANNOTATION OBJECT) ((PROPOSITION PROPOSITION) (KEY KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "lookupAnnotation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("INSERT-ANNOTATION", "(DEFUN INSERT-ANNOTATION ((PROPOSITION PROPOSITION) (KEY KEYWORD) (VALUE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "insertAnnotation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("REMOVE-ANNOTATION", "(DEFUN REMOVE-ANNOTATION ((PROPOSITION PROPOSITION) (KEY KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "removeAnnotation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("BUILD-ANNOTATED-PROPOSITION", "(DEFUN (BUILD-ANNOTATED-PROPOSITION PROPOSITION) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildAnnotatedProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("FINALIZE-PROPOSITION-ANNOTATIONS", "(DEFUN FINALIZE-PROPOSITION-ANNOTATIONS ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "finalizePropositionAnnotations", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("CLEAR-PROPOSITION-ANNOTATIONS", "(DEFUN CLEAR-PROPOSITION-ANNOTATIONS ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "clearPropositionAnnotations", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("FORWARD-BACKWARD-OPTION-HANDLER", "(DEFUN FORWARD-BACKWARD-OPTION-HANDLER ((SELF PROPOSITION) (SLOT STORAGE-SLOT) (TREE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "forwardBackwardOptionHandler", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("FUNCTION-INDUCED-EXISTS?", "(DEFUN (FUNCTION-INDUCED-EXISTS? BOOLEAN) ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "functionInducedExistsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("PREDICATE-OF-FUNCTION-INDUCED-EXISTS", "(DEFUN (PREDICATE-OF-FUNCTION-INDUCED-EXISTS PROPOSITION) ((EXISTSPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "predicateOfFunctionInducedExists", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("EMBED-NEGATION-WITHIN-FUNCTION-INDUCED-EXISTS", "(DEFUN (EMBED-NEGATION-WITHIN-FUNCTION-INDUCED-EXISTS PROPOSITION) ((EXISTSPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "embedNegationWithinFunctionInducedExists", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("BUILD-AND-OR-NOT-PROPOSITION", "(DEFUN (BUILD-AND-OR-NOT-PROPOSITION PROPOSITION) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildAndOrNotProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CONCEIVE-INVERTED-PROPOSITION", "(DEFUN (CONCEIVE-INVERTED-PROPOSITION PROPOSITION) ((PROP PROPOSITION)) :DOCUMENTATION \"Return the simplest inversion of `prop', trying to reuse existing\nnegations or negated arguments of `prop' if possible.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "conceiveInvertedProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("FUNCTIONAL-TERM?", "(DEFUN (FUNCTIONAL-TERM? BOOLEAN) ((TERM OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "functionalTermP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CLIP-VALUE?", "(DEFUN (CLIP-VALUE? BOOLEAN) ((TERM1 OBJECT) (TERM2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "clipValueP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CREATE-EQUIVALENCE-PROPOSITION", "(DEFUN (CREATE-EQUIVALENCE-PROPOSITION PROPOSITION) ((TERM1 OBJECT) (TERM2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createEquivalenceProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("BUILD-EQUIVALENCE-PROPOSITION", "(DEFUN (BUILD-EQUIVALENCE-PROPOSITION PROPOSITION) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildEquivalenceProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("BUILD-CONJUNCTION-OF-EQUALITY-PROPOSITIONS", "(DEFUN (BUILD-CONJUNCTION-OF-EQUALITY-PROPOSITIONS PROPOSITION) ((REMAININGTERMS CONS) (EQUIVALENCES (CONS OF PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildConjunctionOfEqualityPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("BUILD-FAIL-PROPOSITION", "(DEFUN (BUILD-FAIL-PROPOSITION PROPOSITION) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildFailProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("BUILD-COLLECT-INTO-PROPOSITION", "(DEFUN (BUILD-COLLECT-INTO-PROPOSITION PROPOSITION) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildCollectIntoProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("HOLDS-OPERATOR?", "(DEFUN (HOLDS-OPERATOR? BOOLEAN) ((OPERATOR OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "holdsOperatorP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("VERIFY-EVALUABLE-OPERATOR", "(DEFUN VERIFY-EVALUABLE-OPERATOR ((OPERATOR OBJECT) (KIND KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "verifyEvaluableOperator", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("BUILD-HOLDS-PROPOSITION", "(DEFUN (BUILD-HOLDS-PROPOSITION PROPOSITION) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildHoldsProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("MOST-GENERAL-EQUIVALENT-SLOTREF", "(DEFUN (MOST-GENERAL-EQUIVALENT-SLOTREF SURROGATE) ((SURROGATE SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "mostGeneralEquivalentSlotref", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("POLYMORPHIC-RELATION?", "(DEFUN (POLYMORPHIC-RELATION? BOOLEAN) ((SELF RELATION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "polymorphicRelationP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Relation")}), null);
      Stella.defineFunctionObject("NON-POLYMORPHIC-PREDICATE?", "(DEFUN (NON-POLYMORPHIC-PREDICATE? BOOLEAN) ((SELF LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "nonPolymorphicPredicateP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("EVALUATE-PREDICATE", "(DEFUN (EVALUATE-PREDICATE LOGIC-OBJECT) ((NAME GENERALIZED-SYMBOL) (FIRSTARGUMENT OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "evaluatePredicate", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("*AUTO-COERCE-PROPOSITIONAL-ARGUMENTS?*-SETTER", "(DEFUN (*AUTO-COERCE-PROPOSITIONAL-ARGUMENTS?*-SETTER BOOLEAN) ((VALUE BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "$AutoCoercePropositionalArgumentsP$Setter", new java.lang.Class [] {java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("PROPOSITIONAL-ARGUMENT?", "(DEFUN (PROPOSITIONAL-ARGUMENT? BOOLEAN) ((ARGUMENT OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "propositionalArgumentP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("EVALUATE-TYPED-ARGUMENT", "(DEFUN (EVALUATE-TYPED-ARGUMENT OBJECT) ((ARGUMENT OBJECT) (TYPE SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "evaluateTypedArgument", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("EVALUATE-PROPOSITION-TERM", "(DEFUN (EVALUATE-PROPOSITION-TERM OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "evaluatePropositionTerm", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("EVALUATE-PREDICATE-AND-FIRST-ARGUMENT", "(DEFUN (EVALUATE-PREDICATE-AND-FIRST-ARGUMENT LOGIC-OBJECT OBJECT) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "evaluatePredicateAndFirstArgument", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("EVALUATE-FIRST-ARGUMENT", "(DEFUN (EVALUATE-FIRST-ARGUMENT OBJECT) ((ARGUMENT OBJECT) (RELATIONNAME SYMBOL)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "evaluateFirstArgument", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("EVALUATE-REMAINING-ARGUMENTS", "(DEFUN (EVALUATE-REMAINING-ARGUMENTS CONS) ((PREDICATEVALUE LOGIC-OBJECT) (ARGUMENTS CONS)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "evaluateRemainingArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CLASS-OPERATOR?", "(DEFUN (CLASS-OPERATOR? BOOLEAN) ((OPERATOR GENERALIZED-SYMBOL)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "classOperatorP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol")}), null);
      Stella.defineFunctionObject("BUILD-PREDICATE-PROPOSITION", "(DEFUN (BUILD-PREDICATE-PROPOSITION PROPOSITION) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildPredicateProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CHECK-STRICT-TYPE?", "(DEFUN (CHECK-STRICT-TYPE? BOOLEAN) ((SELF OBJECT) (TYPE SURROGATE) (SHALLOW? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "checkStrictTypeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CHECK-TYPE?", "(DEFUN (CHECK-TYPE? BOOLEAN) ((SELF OBJECT) (TYPE SURROGATE) (SHALLOW? BOOLEAN)) :GLOBALLY-INLINE? TRUE (RETURN (OR (PARTIAL-MATCH-MODE?) (CHECK-STRICT-TYPE? SELF TYPE SHALLOW?))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "checkTypeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CHECK-COERCED-TYPE?", "(DEFUN (CHECK-COERCED-TYPE? BOOLEAN OBJECT) ((SELF OBJECT) (TYPE SURROGATE) (SHALLOW? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "checkCoercedTypeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate"), java.lang.Boolean.TYPE, Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("COERCE-INCOMPATIBLE-VALUE", "(DEFUN (COERCE-INCOMPATIBLE-VALUE OBJECT) ((VALUE OBJECT) (TYPE SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "coerceIncompatibleValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("COERCE-QUANTITY", "(DEFUN (COERCE-QUANTITY OBJECT) ((VALUE OBJECT) (QUANTITYTYPEREF SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "coerceQuantity", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("COERCE-DATE", "(DEFUN (COERCE-DATE OBJECT) ((VALUE OBJECT) (DATETYPEREF SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "coerceDate", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("VERIFY-ONE-ARGUMENT-TYPE", "(DEFUN VERIFY-ONE-ARGUMENT-TYPE ((ARG OBJECT) (TYPE SURROGATE) (PROPOSITION PROPOSITION) (DESCRIPTION NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "verifyOneArgumentType", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
    }
  }

  static void helpStartupPropositions11() {
    {
      Stella.defineFunctionObject("VERIFY-ARGUMENT-TYPES-AND-COUNT", "(DEFUN VERIFY-ARGUMENT-TYPES-AND-COUNT ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "verifyArgumentTypesAndCount", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("HANDLE-ARGUMENT-TYPE-VIOLATION", "(DEFUN HANDLE-ARGUMENT-TYPE-VIOLATION ((PROPOSITION PROPOSITION) (ARG OBJECT) (REQUIREDTYPE SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "handleArgumentTypeViolation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("HANDLE-ARITY-VIOLATION", "(DEFUN HANDLE-ARITY-VIOLATION ((PROPOSITION PROPOSITION) (REQUIREDARITY INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "handleArityViolation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("POST-TO-CHECK-TYPES-AGENDA", "(DEFUN POST-TO-CHECK-TYPES-AGENDA ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "postToCheckTypesAgenda", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("PROCESS-CHECK-TYPES-AGENDA", "(DEFUN PROCESS-CHECK-TYPES-AGENDA ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "processCheckTypesAgenda", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("PROCESS-DEFINITIONS", "(DEFUN PROCESS-DEFINITIONS () :PUBLIC? TRUE :COMMAND? TRUE :DOCUMENTATION \"Finish processing all definitions and assertions that have\nbeen evaluated/loaded since that last call to 'process-definitions'.\nPowerLoom defers complete processing of definitions to make it easier\nto support cyclic definitions.  Following finalization of definitions,\nthis call performs semantic validation of any assertions evaluated since\nthe last call to 'process-definitions'.  PowerLoom calls this function\ninternally before each query; the primary reason to call it explicitly\nis to force the production of any diagnostic information that results from\nthe processing and validation.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "processDefinitions", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("BUILD-EXISTS-PROPOSITION", "(DEFUN (BUILD-EXISTS-PROPOSITION PROPOSITION) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildExistsProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("TOP-LEVEL-EXISTS-PROPOSITION?", "(DEFUN (TOP-LEVEL-EXISTS-PROPOSITION? BOOLEAN) ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "topLevelExistsPropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("COLLECT-SKOLEMIZED-EXISTS-VARIABLES", "(DEFUN (COLLECT-SKOLEMIZED-EXISTS-VARIABLES (VECTOR OF SKOLEM)) ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "collectSkolemizedExistsVariables", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("HELP-COLLECT-SKOLEMIZED-EXISTS-VARIABLES?", "(DEFUN (HELP-COLLECT-SKOLEMIZED-EXISTS-VARIABLES? BOOLEAN) ((PROPOSITION PROPOSITION) (RESULT (LIST OF SKOLEM))))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "helpCollectSkolemizedExistsVariablesP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("BUILD-FORALL-PROPOSITION", "(DEFUN (BUILD-FORALL-PROPOSITION PROPOSITION) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildForallProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("VERIFY-FORALL-PROPOSITIONS", "(DEFUN VERIFY-FORALL-PROPOSITIONS ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "verifyForallPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("MAYBE-SUBSTITUTE-SURROGATE-ARGUMENT", "(DEFUN (MAYBE-SUBSTITUTE-SURROGATE-ARGUMENT OBJECT) ((ARG1 OBJECT) (ARG2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "maybeSubstituteSurrogateArgument", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CREATE-IMPLIES-PROPOSITION", "(DEFUN (CREATE-IMPLIES-PROPOSITION PROPOSITION) ((TAIL OBJECT) (HEAD OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createImpliesProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("BUILD-IMPLIES-PROPOSITION", "(DEFUN (BUILD-IMPLIES-PROPOSITION PROPOSITION) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildImpliesProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("FIND-DUPLICATE-FUNCTION-PROPOSITION", "(DEFUN (FIND-DUPLICATE-FUNCTION-PROPOSITION PROPOSITION) ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "findDuplicateFunctionProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("UNWRAP-WRAPPED-TYPE", "(DEFUN (UNWRAP-WRAPPED-TYPE TYPE) ((TYPE TYPE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "unwrapWrappedType", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("BEGIN-CREATING-FUNCTION-PROPOSITION", "(DEFUN (BEGIN-CREATING-FUNCTION-PROPOSITION PROPOSITION) ((SURROGATE GENERALIZED-SYMBOL) (INPUTARGUMENTS CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "beginCreatingFunctionProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("FINISH-CREATING-FUNCTION-PROPOSITION", "(DEFUN (FINISH-CREATING-FUNCTION-PROPOSITION PROPOSITION) ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "finishCreatingFunctionProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("FIND-OR-CREATE-FUNCTION-PROPOSITION", "(DEFUN (FIND-OR-CREATE-FUNCTION-PROPOSITION PROPOSITION) ((PREDICATE GENERALIZED-SYMBOL) (INPUTARGUMENTS CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "findOrCreateFunctionProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CREATE-FUNCTION-PROPOSITION", "(DEFUN (CREATE-FUNCTION-PROPOSITION PROPOSITION) ((PREDICATE GENERALIZED-SYMBOL) (INPUTARGUMENTS CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createFunctionProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("EVALUATE-FUNCTION-TERM", "(DEFUN (EVALUATE-FUNCTION-TERM OBJECT) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "evaluateFunctionTerm", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("EXTENSIONAL-INDIVIDUAL?", "(DEFUN (EXTENSIONAL-INDIVIDUAL? BOOLEAN) ((INDIVIDUAL OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "extensionalIndividualP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("FUNCTION-WITH-DEFINED-VALUE?", "(DEFUN (FUNCTION-WITH-DEFINED-VALUE? BOOLEAN) ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "functionWithDefinedValueP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("NORMALIZE-SETOF-ARGUMENTS", "(DEFUN (NORMALIZE-SETOF-ARGUMENTS CONS) ((ARGS CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "normalizeSetofArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CREATE-ENUMERATED-SET", "(DEFUN (CREATE-ENUMERATED-SET SKOLEM) ((SET LIST)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createEnumeratedSet", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("CREATE-LOGICAL-LIST", "(DEFUN (CREATE-LOGICAL-LIST SKOLEM) ((LIST LIST)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createLogicalList", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("LOGICAL-COLLECTION?", "(DEFUN (LOGICAL-COLLECTION? BOOLEAN) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "logicalCollectionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("FUNCTION-OUTPUT-SKOLEM?", "(DEFUN (FUNCTION-OUTPUT-SKOLEM? BOOLEAN) ((SELF OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "functionOutputSkolemP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SKOLEM-DEFINED-BY-OPERATOR?", "(DEFUN (SKOLEM-DEFINED-BY-OPERATOR? BOOLEAN) ((SELF OBJECT) (OPERATOR SURROGATE)) :GLOBALLY-INLINE? TRUE (TYPECASE SELF (SKOLEM (LET ((DEFININGPROPOSITION (DEFINING-PROPOSITION SELF))) (RETURN (AND (DEFINED? DEFININGPROPOSITION) (EQL? (OPERATOR DEFININGPROPOSITION) OPERATOR))))) (OTHERWISE (RETURN FALSE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "skolemDefinedByOperatorP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("GET-SKOLEM-AND-VALUE-TERMS", "(DEFUN (GET-SKOLEM-AND-VALUE-TERMS SKOLEM OBJECT) ((PROPOSITION PROPOSITION)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "getSkolemAndValueTerms", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("ENUMERATED-SET?", "(DEFUN (ENUMERATED-SET? BOOLEAN) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "enumeratedSetP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("ENUMERATED-LIST?", "(DEFUN (ENUMERATED-LIST? BOOLEAN) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "enumeratedListP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CANONICALIZE-PROPOSITION-TREE", "(DEFUN (CANONICALIZE-PROPOSITION-TREE OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "canonicalizePropositionTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("UPDATE-EQUIVALENCE-PROPOSITION", "(DEFUN (UPDATE-EQUIVALENCE-PROPOSITION PROPOSITION) ((PROPOSITION PROPOSITION) (UPDATEMODE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "updateEquivalenceProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("SKOLEMIZE-EXISTS-PROPOSITION", "(DEFUN (SKOLEMIZE-EXISTS-PROPOSITION PROPOSITION) ((EXISTSPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "skolemizeExistsProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("HELP-UPDATE-TOP-LEVEL-PROPOSITION", "(DEFUN (HELP-UPDATE-TOP-LEVEL-PROPOSITION (CONS OF PROPOSITION)) ((PROPOSITION PROPOSITION) (UPDATEMODE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "helpUpdateTopLevelProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("INVERT-UPDATE-MODE", "(DEFUN (INVERT-UPDATE-MODE KEYWORD) ((UPDATEMODE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "invertUpdateMode", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("DEFAULTIFY-UPDATE-MODE", "(DEFUN (DEFAULTIFY-UPDATE-MODE KEYWORD) ((UPDATEMODE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "defaultifyUpdateMode", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("UPDATE-TOP-LEVEL-PROPOSITION", "(DEFUN (UPDATE-TOP-LEVEL-PROPOSITION (CONS OF PROPOSITION)) ((TREE OBJECT) (UPDATEMODE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "updateTopLevelProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("STANDARDIZE-PROPOSITION-TREE", "(DEFUN (STANDARDIZE-PROPOSITION-TREE OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "standardizePropositionTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("UPDATE-PROPOSITION", "(DEFUN (UPDATE-PROPOSITION (CONS OF PROPOSITION)) ((TREE OBJECT) (UPDATEMODE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "updateProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("BUILD-TOP-LEVEL-TERM", "(DEFUN (BUILD-TOP-LEVEL-TERM OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildTopLevelTerm", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CONCEIVE-TERM", "(DEFUN (CONCEIVE-TERM OBJECT) ((TREE OBJECT)) :DOCUMENTATION \"`tree' is a term expression (a string or an s-expression),\nor is a class reference (a symbol or surrogate).  Return a (possibly \nnewly-conceived) term representing the internalized representation of that term.\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? TRUE :LISP-MACRO? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "conceiveTerm", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CONCEIVE-SENTENCE", "(DEFUN (CONCEIVE-SENTENCE OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "conceiveSentence", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CONCEIVE-FORMULA", "(DEFUN (CONCEIVE-FORMULA OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "conceiveFormula", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SMART-UPDATE-PROPOSITION", "(DEFUN (SMART-UPDATE-PROPOSITION OBJECT) ((TREE OBJECT) (UPDATEMODE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "smartUpdateProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("ASSERT", "(DEFUN (ASSERT OBJECT) ((PROPOSITION PARSE-TREE)) :DOCUMENTATION \"Assert the truth of `proposition'.  Return the asserted proposition object.\nKIF example:  \\\"(assert (happy Fred))\\\" asserts that Fred is indeed happy.\nNote that for this assertion to succeed, the relation `happy' must already\nbe defined.  If the constant `Fred' has not yet been created, it is\nautomatically created as a side-effect of calling `assert'.\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "renamed_Assert", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("PRESUME", "(DEFUN (PRESUME OBJECT) ((PROPOSITION PARSE-TREE)) :DOCUMENTATION \"Presume the default truth of `proposition'.  Return the presumed\nproposition object.  KIF example:  \\\"(presume (happy Fred))\\\" states that Fred\nis most probably happy.  Note, that for this to succeed, the relation\n`happy' must already be defined (see `assert').\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "presume", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("RETRACT", "(DEFUN (RETRACT OBJECT) ((PROPOSITION PARSE-TREE)) :DOCUMENTATION \"Retract the truth of `proposition'.  Return the retracted proposition\nobject.  KIF example:  \\\"(retract (happy Fred))\\\" retracts that Fred is\nhappy.  Note that for this assertion to succeed, the relation `happy' must already\nbe defined.  If the constant `Fred' has not yet been created, it is\nautomatically created as a side-effect of calling `retract'.\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "retract", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("DENY", "(DEFUN (DENY OBJECT) ((PROPOSITION PARSE-TREE)) :DOCUMENTATION \"Assert the falsity of `proposition'.  Return the asserted proposition\nobject.  KIF example:  \\\"(deny (happy Fred))\\\" asserts that Fred is not happy,\nwhich could have been done equivalently by \\\"(assert (not (happy Fred)))\\\".\nNote, that for this to succeed, the relation `happy' must already be defined\n(see `assert').\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "deny", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CONCEIVE", "(DEFUN (CONCEIVE OBJECT) ((FORMULA PARSE-TREE)) :DOCUMENTATION \"Guess whether 'formula' represents a term or a sentence/proposition.\nIf we are not sure, assume its a proposition.\nIf its, a term, return its internal representation.  If a proposition,\nconstruct a proposition for 'formula' without asserting its truth value.\nReturn the conceived proposition object.  KIF example: \\\"(conceive (happy Fred))\\\"\nbuilds the proposition expressing that Fred is happy without explictly asserting\nor denying it.  Note, that for this to succeed, the relation `happy' must already\nbe defined (see `assert').  If the logic constant `Fred' has not yet been\ncreated, it is automatically created as a side-effect of calling `conceive'.\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "conceive", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("UNASSERT", "(DEFUN (UNASSERT OBJECT) ((PROPOSITION PARSE-TREE)) :DOCUMENTATION \"Retract the truth, falsity or inconsistency of `proposition'.  This is a\nmore general version of `retract' that also handles falsity.  For example, if\nwe assert the proposition \\\"(not (sad Fred))\\\", and then execute the statement\n\\\"(unassert (sad Fred))\\\", the truth value of the proposition \\\"(sad Fred)\\\"\nwill be set to UNKNOWN.  If we had called `retract' in place of `unassert',\nthe proposition \\\"(sad Fred)\\\" would remain set to FALSE.   Note that for this\nunassertion to succeed, the logic constant `Fred' and the relation `sad' must\nalready be defined.\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "unassert", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("UNASSERT-PROPOSITION", "(DEFUN UNASSERT-PROPOSITION ((SELF PROPOSITION)) :DOCUMENTATION \"Retract the truth, falsity or inconsistency of the proposition `self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "unassertProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineMethodObject("(DEFMETHOD (DELETED? BOOLEAN) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "deletedP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (DELETED?-SETTER BOOLEAN) ((SELF PROPOSITION) (VALUE BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "deletedPSetter", new java.lang.Class [] {java.lang.Boolean.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("DELETED-PROPOSITION?", "(DEFUN (DELETED-PROPOSITION? BOOLEAN) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "deletedPropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("DESTROY-PROPOSITION", "(DEFUN (DESTROY-PROPOSITION PROPOSITION) ((PROPOSITION PROPOSITION)) :DOCUMENTATION \"Retract and destroy the proposition 'proposition'.\nRecursively destroy all propositions that reference 'proposition'.\nAlso, destroy all satellite propositions of 'proposition'.\")", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "destroyProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("DESTROY-REDUNDANT-PROPOSITION", "(DEFUN DESTROY-REDUNDANT-PROPOSITION ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "destroyRedundantProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("DESTROY-LOGIC-INSTANCE", "(DEFUN DESTROY-LOGIC-INSTANCE ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "destroyLogicInstance", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
    }
  }

  static void helpStartupPropositions12() {
    {
      Stella.defineFunctionObject("DESTROY-TERM", "(DEFUN DESTROY-TERM ((SELF LOGIC-OBJECT)) :DOCUMENTATION \"Destroy all propositions that reference 'self',\nand mark it as 'deleted?', thereby making it invisible within class\nextensions.  Unlink descriptions from native relations.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "destroyTerm", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("DESTROY-INSTANCE", "(DEFUN DESTROY-INSTANCE ((SELF OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"Destroy all propositions that reference 'self',\nand mark it as 'deleted?', thereby making it invisible within class\nextensions.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "destroyInstance", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("DESTROY-OBJECT", "(DEFUN DESTROY-OBJECT ((SELF OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"Destroy `self' which can be a term or a proposition.  Destroy all\npropositions that reference 'self' and mark it as 'deleted?' (thereby\nmaking it invisible within class extensions).\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "destroyObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("DESTROY", "(DEFUN (DESTROY OBJECT) ((OBJECTSPEC PARSE-TREE)) :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Find an object or proposition as specified by `objectSpec', and destroy all\npropositions and indices that reference it.  `objectSpec' must be a name or\na parse tree that evaluates to a proposition.  Return the deleted object, or\nNULL if no matching object was found.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "destroy", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("RELATION-IN-MODULE?", "(DEFUN (RELATION-IN-MODULE? BOOLEAN) ((SELF NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "relationInModuleP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("INTRODUCE-MODULE", "(DEFUN INTRODUCE-MODULE ((MODULE MODULE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "introduceModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("CLEAR-LOGIC-MODULE-HOOK", "(DEFUN CLEAR-LOGIC-MODULE-HOOK ((MODULE MODULE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "clearLogicModuleHook", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("CLEAR-INSTANCES", "(DEFUN CLEAR-INSTANCES (|&REST| (NAME NAME)) :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Destroy all instances belonging to module `name' or any of its children.\nLeave meta-objects, e.g., concepts and relations, alone.\nIf no `name' is supplied, the current module will be cleared after\nconfirming with the user.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "clearInstances", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "clearInstancesEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("DO-CLEAR-INSTANCES", "(DEFUN DO-CLEAR-INSTANCES ((MODULE MODULE)) :DOCUMENTATION \"Function version of `clear-instances' that evaluates its argument.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "doClearInstances", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("DESTROY-LOGIC-CONTEXT-HOOK", "(DEFUN DESTROY-LOGIC-CONTEXT-HOOK ((SELF CONTEXT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "destroyLogicContextHook", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context")}), null);
      Stella.defineFunctionObject("CLEAR-CACHES", "(DEFUN CLEAR-CACHES () :DOCUMENTATION \"Clear all query and memoization caches.\" :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "clearCaches", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("RESET-POWERLOOM", "(DEFUN RESET-POWERLOOM () :DOCUMENTATION \"Reset PowerLoom to its initial state.\nCAUTION: This will destroy all loaded knowledge bases and might break other\nloaded STELLA systems if they do reference PowerLoom symbols in their code.\" :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "resetPowerloom", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("CONS-LESS-THAN?", "(DEFUN (CONS-LESS-THAN? BOOLEAN) ((O1 CONS) (O2 CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "consLessThanP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("STRING-TERM-LESS?", "(DEFUN (STRING-TERM-LESS? BOOLEAN) ((S1 STRING) (S2 STRING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "stringTermLessP", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("SAFE-STRING-TERM-LESS?", "(DEFUN (SAFE-STRING-TERM-LESS? BOOLEAN) ((S1 STRING) (S2 STRING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "safeStringTermLessP", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("SAFE-QUANTITY-LESS?", "(DEFUN (SAFE-QUANTITY-LESS? BOOLEAN) ((Q1 QUANTITY) (O2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "safeQuantityLessP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Quantity"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SAFE-QUANTITY-GREATER-EQUAL?", "(DEFUN (SAFE-QUANTITY-GREATER-EQUAL? BOOLEAN) ((Q1 QUANTITY) (O2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "safeQuantityGreaterEqualP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Quantity"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("OBJECT-NAME-LESS-THAN?", "(DEFUN (OBJECT-NAME-LESS-THAN? BOOLEAN) ((O1 LOGIC-OBJECT) (O2 LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "objectNameLessThanP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("MODULE-NAME-LESS-THAN?", "(DEFUN (MODULE-NAME-LESS-THAN? BOOLEAN) ((M1 CONTEXT) (M2 CONTEXT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "moduleNameLessThanP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context"), Native.find_java_class("edu.isi.stella.Context")}), null);
      Stella.defineFunctionObject("PROPOSITION-LESS-THAN?", "(DEFUN (PROPOSITION-LESS-THAN? BOOLEAN) ((P1 PROPOSITION) (P2 PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "propositionLessThanP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("PROPOSITION-HEAD-SORT-STRING", "(DEFUN (PROPOSITION-HEAD-SORT-STRING STRING) ((P PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "propositionHeadSortString", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("OBJECT-SORT-STRING", "(DEFUN (OBJECT-SORT-STRING STRING) ((O OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "objectSortString", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("LOGIC-FORM-LESS?", "(DEFUN (LOGIC-FORM-LESS? BOOLEAN) ((O1 OBJECT) (O2 OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"A sorting predicate for objects `o1' and `o2' that can appear in logical\nforms.  Performs a combined numeric and lexocographic sort that accounts\nfor lists, collections and propositions.  Numbers precede all other values,\n`null' follows all other values.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "logicFormLessP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("STARTUP-PROPOSITIONS", "(DEFUN STARTUP-PROPOSITIONS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupPropositions", "startupPropositions", new java.lang.Class [] {}), null);
      { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_PROPOSITIONS);

        KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupPropositions"), Stella.NULL_STRING_WRAPPER);
      }
    }
  }

  public static void startupPropositions() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupPropositions.helpStartupPropositions1();
          _StartupPropositions.helpStartupPropositions2();
          _StartupPropositions.helpStartupPropositions3();
          _StartupPropositions.helpStartupPropositions4();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          _StartupPropositions.helpStartupPropositions5();
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          _StartupPropositions.helpStartupPropositions6();
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupPropositions.helpStartupPropositions7();
          _StartupPropositions.helpStartupPropositions8();
          _StartupPropositions.helpStartupPropositions9();
          _StartupPropositions.helpStartupPropositions10();
          _StartupPropositions.helpStartupPropositions11();
          _StartupPropositions.helpStartupPropositions12();
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT ZERO-VARIABLES-VECTOR VARIABLES-VECTOR (NEW VARIABLES-VECTOR :ARRAY-SIZE 0) :DOCUMENTATION \"Save space by structure-sharing zero-length variable vectors.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *PARTIAL-SUPPORT-COUNTER* INTEGER 0)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *OPERATOR-NAME-TO-SURROGATE-TABLE* (PROPERTY-LIST OF KEYWORD SURROGATE) (NEW PROPERTY-LIST :THE-PLIST (BQUOTE (:AND /PL-KERNEL-KB/@AND :OR /PL-KERNEL-KB/@OR :NOT /PL-KERNEL-KB/@NOT :FORALL /PL-KERNEL-KB/@FORALL :EXISTS /PL-KERNEL-KB/@EXISTS :EQUIVALENT /PL-KERNEL-KB/@EQUIVALENT :FAIL /PL-KERNEL-KB/@FAIL :COLLECT-INTO /PL-KERNEL-KB/@COLLECT-INTO :IMPLIES /PL-KERNEL-KB/@SUBSET-OF))) :DOCUMENTATION \"Maps names of KIF operators to relational surrogates.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *LOGIC-MODULE* MODULE (GET-STELLA-MODULE \"LOGIC\" TRUE) :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *PL-KERNEL-MODULE* MODULE (GET-STELLA-MODULE \"PL-KERNEL\" TRUE) :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *NOW-TIMESTAMP* TIMESTAMP 0 :DOCUMENTATION \"The NOW time stamp is incremented whenever a series\nof one or more updates is followed by a query.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *LAST-KB-ACTION* KEYWORD :UPDATE-PROPOSITION :DOCUMENTATION \"Records whether the last KB access was a query or\nan update.  Used to determine when to increment the NOW time stamp\ncounter.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL BOTTOM LOGIC-OBJECT NULL :PUBLIC? TRUE :DOCUMENTATION \"The undefined individual.  Denotes the non-existence of\nan individual in whatever slot it occupies.\")");
          Logic.BOTTOM = Logic.createSkolem(null, Logic.SYM_LOGIC_BOTTOM);
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *EVALUATIONMODE* KEYWORD :EXTENSIONAL-ASSERTION :DOCUMENTATION \"Indicates the context for evaluating a proposition.  One\nof :DESCRIPTION, :INTENSIONAL-ASSERTION, or :EXTENSIONAL-ASSERTION.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *CLIPPINGENABLED?* BOOLEAN TRUE :DOCUMENTATION \"When enabled, slot-value assertions can be retracted\nby later conflicting assertions.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *NATURALDEDUCTIONMODE?* BOOLEAN TRUE :DOCUMENTATION \"When enabled, blocks normalizations that significantly\nchange the behavior of inference rules.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CONTEXT-DEPENDENT-SEARCH-MODE?* BOOLEAN FALSE :DOCUMENTATION \"Signals that we are performing search across multiple\ncontexts.  Used to disable retraction from collections, since that increases\nthe overhead of the context mechanism.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *COMPUTEDQUERY?* BOOLEAN FALSE :DOCUMENTATION \"Used to signal 'ground-value-of' that it can\ncall 'bound-to' safely.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *SKOLEM-ID-COUNTER* INTEGER 0)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *VARIABLEIDCOUNTER* INTEGER 0)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *FREESKOLEMS* CONS NULL :DOCUMENTATION \"Cons-list of top-level existentially-quantified skolems.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT TRUE-TRUTH-VALUE TRUTH-VALUE (NEW TRUTH-VALUE :POLARITY :TRUE :STRENGTH :STRICT :POSITIVE-SCORE 1.0) :DOCUMENTATION \"Value representing TRUE.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT FALSE-TRUTH-VALUE TRUTH-VALUE (NEW TRUTH-VALUE :POLARITY :FALSE :STRENGTH :STRICT :POSITIVE-SCORE -1.0) :DOCUMENTATION \"Value representing FALSE.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT DEFAULT-TRUE-TRUTH-VALUE TRUTH-VALUE (NEW TRUTH-VALUE :POLARITY :TRUE :STRENGTH :DEFAULT :POSITIVE-SCORE 0.8) :DOCUMENTATION \"Value representing DEFAULT-TRUE.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT DEFAULT-FALSE-TRUTH-VALUE TRUTH-VALUE (NEW TRUTH-VALUE :POLARITY :FALSE :STRENGTH :DEFAULT :POSITIVE-SCORE -0.8) :DOCUMENTATION \"Value representing DEFAULT-FALSE.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT UNKNOWN-TRUTH-VALUE TRUTH-VALUE (NEW TRUTH-VALUE :POLARITY :UNKNOWN) :DOCUMENTATION \"Value representing UNKNOWN.  Needed for those cases\nwhere we need a non-NULL truth value to represents UNKNOWN.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT INCONSISTENT-TRUTH-VALUE TRUTH-VALUE (NEW TRUTH-VALUE :POLARITY :INCONSISTENT :STRENGTH :STRICT) :DOCUMENTATION \"Value representing a contradiction.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *SUPPRESSUNTYPEDTYPEERROR?* BOOLEAN FALSE :DOCUMENTATION \"Used by 'safe-logical-type' to ask for a type\nwithout signalling an error if none exists.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *EQUIVALENCE-COLLECTIONS?* BOOLEAN TRUE :DOCUMENTATION \"Experiment with equality reasoning on collections.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT TRUE-PROPOSITION PROPOSITION (NEW PROPOSITION :KIND :CONSTANT :OPERATOR @TRUE :ARGUMENTS (NEW ARGUMENTS-VECTOR :ARRAY-SIZE 0) :TRUTH-VALUE TRUE-TRUTH-VALUE :HOME-CONTEXT *PL-KERNEL-MODULE*))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT FALSE-PROPOSITION PROPOSITION (NEW PROPOSITION :KIND :CONSTANT :OPERATOR @FALSE :ARGUMENTS (NEW ARGUMENTS-VECTOR :ARRAY-SIZE 0) :TRUTH-VALUE FALSE-TRUTH-VALUE :HOME-CONTEXT *PL-KERNEL-MODULE*))");
          Logic.SGT_STELLA_TRUE.surrogateValue = Logic.TRUE_PROPOSITION;
          Logic.SGT_STELLA_FALSE.surrogateValue = Logic.FALSE_PROPOSITION;
          Proposition.findDuplicateProposition(Logic.TRUE_PROPOSITION);
          Proposition.findDuplicateProposition(Logic.FALSE_PROPOSITION);
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT ANONYMOUS-VARIABLE-NAME SYMBOL (QUOTE ?) :DOCUMENTATION \"Variables with name 'ANONYMOUS-VARIABLE-NAME' are considered\nanonymous, and are not assumed to be identical to any other variable also named\n'ANONYMOUS-VARIABLE-NAME'.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *MISSING-KEY-VALUE-LIST* KEY-VALUE-LIST (NEW KEY-VALUE-LIST) :DOCUMENTATION \"Represents a key-value list that should never be used.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *AUTOMATICINSTANCETABLE* (KEY-VALUE-LIST OF SYMBOL LOGIC-OBJECT) *MISSING-KEY-VALUE-LIST* :DOCUMENTATION \"Used by 'evaluate-automatic-instance' to\nrecord current bindings of automatic instance symbols.\")");
          HookList.addHook(Stella.$REDEFINE_RELATION_HOOKS$, Logic.SYM_LOGIC_TRANSFER_LOGIC_INFORMATION_FROM_RELATION_HOOK);
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *DEFAULTCREATIONTYPE* SURROGATE NULL)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *STRUCTURED-OBJECTS-INDEX* (KEY-VALUE-MAP OF INTEGER-WRAPPER (LIST OF CONTEXT-SENSITIVE-OBJECT)) (NEW KEY-VALUE-MAP) :DOCUMENTATION \"Contains a table of propositions and descriptions, indexed by a\nstructure hash code which might be shared by different objects.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *DONT-CHECK-FOR-DUPLICATE-PROPOSITIONS?* BOOLEAN FALSE :DOCUMENTATION \"If TRUE never check for the existence of duplicate\npropositions when building a new proposition.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *VISITEDUNFASTENEDDEFININGPROPOSITIONS* LIST NULL :DOCUMENTATION \"Used by 'recursively-fasten-down-propositions'.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *AUTO-COERCE-PROPOSITIONAL-ARGUMENTS?* BOOLEAN FALSE :DOCUMENTATION \"If TRUE, automatically coerce propositional arguments of a\nproposition, even if the corresponding argument type of the hosting relation\ndoesn't indicate that.\" :DEMON-PROPERTY \"powerloom.autoCoercePropositionalArguments\" :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *TYPE-CHECK-POLICY* KEYWORD :AUTOMATICALLY-FIX-TYPE-VIOLATIONS :DOCUMENTATION \"Three policies are implemented:\n   :AUTOMATICALLY-FIX-TYPE-VIOLATIONS asserts missing types to fix type\n       violations (default),\n   :REPORT-TYPE-VIOLATIONS complains about missing or incorrect types,\n   :SIGNAL-TYPE-VIOLATIONS throws exception for missing or incorrect types, and\n   :IGNORE-TYPE-VIOLATIONS which disables all type checking.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *TYPECHECKMODE* KEYWORD :POST-TYPE-VIOLATIONS :DOCUMENTATION \"Controls the behavior of the type-checking\nroutines in the event that a type-check fails.  Options are:\n  :POST-TYPE-VIOLATIONS              push offending proposition onto queue,\n  :REPORT-TYPE-VIOLATIONS            print occasions of failed type checks,\n  :SIGNAL-TYPE-VIOLATIONS            throw exception for failed type checks,\n  :AUTOMATICALLY-FIX-TYPE-VIOLATIONS assert missing types on propositions, and\n  :IGNORE-TYPE-VIOLATIONS            don't perform any type checking at all.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CHECK-TYPES-AGENDA* (VECTOR-SEQUENCE OF CHECK-TYPES-RECORD) (NEW VECTOR-SEQUENCE :ARRAY-SIZE 4) :DOCUMENTATION \"List of propositions that have failed a type check,\nbut might pass once finalization is complete.\")");
          Symbol.registerNativeName(Logic.SYM_STELLA_ASSERT, Logic.KWD_CPP, Logic.KWD_FUNCTION);
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *DEFERRED-TERMS-TO-UNLINK* HASH-SET NULL)");
          HookList.addHook(Stella.$DEFINE_MODULE_HOOKS$, Logic.SYM_LOGIC_INTRODUCE_MODULE);
          HookList.addHook(Stella.$CLEAR_MODULE_HOOKS$, Logic.SYM_LOGIC_CLEAR_LOGIC_MODULE_HOOK);
          HookList.addHook(Stella.$DESTROY_CONTEXT_HOOKS$, Logic.SYM_LOGIC_DESTROY_LOGIC_CONTEXT_HOOK);
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
