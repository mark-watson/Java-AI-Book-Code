//  -*- Mode: Java -*-
//
// Stella.java

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
| The Original Code is the STELLA Programming Language.                      |
|                                                                            |
| The Initial Developer of the Original Code is                              |
| UNIVERSITY OF SOUTHERN CALIFORNIA, INFORMATION SCIENCES INSTITUTE          |
| 4676 Admiralty Way, Marina Del Rey, California 90292, U.S.A.               |
|                                                                            |
| Portions created by the Initial Developer are Copyright (C) 1996-2017      |
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
+---------------------------- END LICENSE BLOCK -----------------------------+
*/

package edu.isi.stella;

import edu.isi.stella.javalib.*;

public class Stella {
  public static Symbol SYM_STELLA_TYPE_SPEC = null;

  public static boolean $HARDWIRED_TRANSIENTp_ON_TRANSIENT_MIXIN$ = false;

  public static Symbol SYM_STELLA_REFERENCE_COUNT = null;

  public static Symbol SYM_STELLA_BADp = null;

  public static Symbol SYM_STELLA_DELETED_OBJECTp = null;

  public static Symbol SYM_STELLA_FIRST_ITERATIONp = null;

  public static Symbol SYM_STELLA_OBJECT_ITERATOR = null;

  public static Surrogate SGT_STELLA_CONS_ITERATOR = null;

  public static Symbol SYM_STELLA_CONS_ITERATOR_CURSOR = null;

  public static Surrogate SGT_STELLA_LIST_ITERATOR = null;

  public static Symbol SYM_STELLA_LIST_ITERATOR_CURSOR = null;

  public static Symbol SYM_STELLA_LIST_ITERATOR_COLLECTION = null;

  public static Surrogate SGT_STELLA_DESTRUCTIVE_LIST_ITERATOR = null;

  public static Symbol SYM_STELLA_THE_CONS_LIST = null;

  public static Surrogate SGT_STELLA_ALL_PURPOSE_ITERATOR = null;

  public static Symbol SYM_STELLA_KEY = null;

  public static Symbol SYM_STELLA_ITERATOR_NEXT_CODE = null;

  public static Symbol SYM_STELLA_ITERATOR_FILTER_CODE = null;

  public static Symbol SYM_STELLA_ITERATOR_EMPTY_CODE = null;

  public static Symbol SYM_STELLA_ITERATOR_NESTED_ITERATOR = null;

  public static Symbol SYM_STELLA_ITERATOR_CONS_LIST = null;

  public static Symbol SYM_STELLA_ITERATOR_OBJECT = null;

  public static Symbol SYM_STELLA_ITERATOR_SECOND_OBJECT = null;

  public static Symbol SYM_STELLA_ITERATOR_INTEGER = null;

  public static Symbol SYM_STELLA_ITERATOR_SECOND_INTEGER = null;

  public static Surrogate SGT_STELLA_TYPES_TO_CLASSES_ITERATOR = null;

  public static Symbol SYM_STELLA_ITERATOR_CURSOR = null;

  public static Symbol SYM_STELLA_OBJECT_DICTIONARY_ITERATOR = null;

  public static Surrogate SGT_STELLA_PROPERTY_LIST_ITERATOR = null;

  public static Symbol SYM_STELLA_PLIST_ITERATOR_CURSOR = null;

  public static Symbol SYM_STELLA_PLIST_ITERATOR_COLLECTION = null;

  public static Surrogate SGT_STELLA_KV_LIST_ITERATOR = null;

  public static Symbol SYM_STELLA_THE_KV_LIST = null;

  public static Symbol SYM_STELLA_KV_LIST_ITERATOR_CURSOR = null;

  public static Surrogate SGT_STELLA_INTEGER_INTERVAL_ITERATOR = null;

  public static Symbol SYM_STELLA_INTERVAL_CURSOR = null;

  public static Symbol SYM_STELLA_LOWER_BOUND = null;

  public static Symbol SYM_STELLA_UPPER_BOUND = null;

  public static Surrogate SGT_STELLA_REVERSE_INTEGER_INTERVAL_ITERATOR = null;

  public static Surrogate SGT_STELLA_STRING_ITERATOR = null;

  public static Symbol SYM_STELLA_THE_STRING = null;

  public static Symbol SYM_STELLA_CURSOR = null;

  public static Symbol SYM_STELLA_END = null;

  public static Symbol SYM_STELLA_OBJECT_COLLECTION = null;

  public static Symbol SYM_STELLA_OBJECT_SEQUENCE = null;

  public static Surrogate SGT_STELLA_LIST = null;

  public static Surrogate SGT_STELLA_SET = null;

  public static Surrogate SGT_STELLA_CLASS_EXTENSION = null;

  public static Surrogate SGT_STELLA_CONS = null;

  public static Symbol SYM_STELLA_VALUE = null;

  public static Symbol SYM_STELLA_REST = null;

  public static Symbol SYM_STELLA_OBJECT_TO_OBJECT_DICTIONARY = null;

  public static Surrogate SGT_STELLA_PROPERTY_LIST = null;

  public static Symbol SYM_STELLA_THE_PLIST = null;

  public static Surrogate SGT_STELLA_KV_CONS = null;

  public static Surrogate SGT_STELLA_KEY_VALUE_LIST = null;

  public static Surrogate SGT_STELLA_RECYCLE_LIST = null;

  public static Symbol SYM_STELLA_RECYCLE_LIST_OF = null;

  public static Symbol SYM_STELLA_RECYCLED_ITEMS = null;

  public static Symbol SYM_STELLA_LIST_OF_RECYCLED_ITEMS = null;

  public static Symbol SYM_STELLA_ALL_ITEMS = null;

  public static Symbol SYM_STELLA_UNUSED_ITEMS = null;

  public static Symbol SYM_STELLA_CURRENT_LENGTH = null;

  public static Symbol SYM_STELLA_ITEM_SIZE = null;

  public static Symbol SYM_STELLA_THE_STELLA_HASH_TABLE = null;

  public static Surrogate SGT_STELLA_HASH_TABLE = null;

  public static Symbol SYM_STELLA_OBJECT_TO_OBJECT_HASH_TABLE = null;

  public static Surrogate SGT_STELLA_INTEGER_HASH_TABLE = null;

  public static Surrogate SGT_STELLA_FLOAT_HASH_TABLE = null;

  public static Surrogate SGT_STELLA_STRING_HASH_TABLE = null;

  public static Surrogate SGT_STELLA_STRING_TO_INTEGER_HASH_TABLE = null;

  public static Surrogate SGT_STELLA_VECTOR = null;

  public static Symbol SYM_STELLA_ARRAY_SIZE = null;

  public static Surrogate SGT_STELLA_EXTENSIBLE_VECTOR = null;

  public static Surrogate SGT_STELLA_EXTENSIBLE_SYMBOL_ARRAY = null;

  public static Symbol SYM_STELLA_TOP_SYMBOL_OFFSET = null;

  public static Symbol SYM_STELLA_POTENTIAL_FREE_SYMBOL_OFFSET = null;

  public static Surrogate SGT_STELLA_VECTOR_SEQUENCE = null;

  public static Symbol SYM_STELLA_SEQUENCE_LENGTH = null;

  public static Surrogate SGT_STELLA_CUSTOM_VECTOR_SEQUENCE = null;

  public static Symbol SYM_STELLA_RESIZE_FACTOR = null;

  public static Surrogate SGT_STELLA_BOOLEAN_VECTOR = null;

  public static Surrogate SGT_STELLA_INTEGER_VECTOR = null;

  public static Surrogate SGT_STELLA_ACTIVE_LIST = null;

  public static Surrogate SGT_STELLA_ACTIVE_SET = null;

  public static Surrogate SGT_STELLA_DEMON = null;

  public static Symbol SYM_STELLA_DEMON_NAME = null;

  public static Symbol SYM_STELLA_DEMON_ACTION = null;

  public static Symbol SYM_STELLA_DEMON_CLASS_REFS = null;

  public static Symbol SYM_STELLA_DEMON_SLOT_REFS = null;

  public static Symbol SYM_STELLA_DEMON_CODE = null;

  public static Symbol SYM_STELLA_DEMON_METHOD = null;

  public static Symbol SYM_STELLA_DEMON_DOCUMENTATION = null;

  public static Symbol SYM_STELLA_DEMON_GUARDp = null;

  public static Symbol SYM_STELLA_DEMON_ALLp = null;

  public static Symbol SYM_STELLA_DEMON_INHERITp = null;

  public static Surrogate SGT_STELLA_KEYWORD_KEY_VALUE_LIST = null;

  public static Symbol SYM_STELLA_SYMBOL_NAME = null;

  public static Symbol SYM_STELLA_SYMBOL_ID = null;

  public static Symbol SYM_STELLA_INTERNED_IN = null;

  public static Surrogate SGT_STELLA_SYMBOL = null;

  public static Symbol SYM_STELLA_SYMBOL_SLOT_OFFSET = null;

  public static Symbol SYM_STELLA_SYMBOL_VALUE_AND_PLIST = null;

  public static Surrogate SGT_STELLA_SURROGATE = null;

  public static Symbol SYM_STELLA_SURROGATE_VALUE = null;

  public static Symbol SYM_STELLA_SURROGATE_NAME = null;

  public static Symbol SYM_STELLA_TYPE_CLASS = null;

  public static Symbol SYM_STELLA_TYPE_NAME = null;

  public static Symbol SYM_STELLA_SLOTREF_SLOT = null;

  public static Symbol SYM_STELLA_TYPE = null;

  public static Symbol SYM_STELLA_SLOTREF = null;

  public static Surrogate SGT_STELLA_KEYWORD = null;

  public static Symbol SYM_STELLA_KEYWORD_NAME = null;

  public static Surrogate SGT_STELLA_TRANSIENT_SYMBOL = null;

  public static Symbol SYM_STELLA_PROJECTS_ONTO = null;

  public static Symbol SYM_STELLA_PROJECTED_FROM = null;

  public static Symbol SYM_STELLA_PROPERTIES = null;

  public static Symbol SYM_STELLA_ABSTRACTp = null;

  public static Surrogate SGT_STELLA_CLASS = null;

  public static Symbol SYM_STELLA_STORED_ACTIVEp = null;

  public static Surrogate SGT_STELLA_ACTIVE_OBJECT = null;

  public static Symbol SYM_STELLA_CLASS_CREATOR = null;

  public static Symbol SYM_STELLA_CLASS_INITIALIZER = null;

  public static Symbol SYM_STELLA_CLASS_TERMINATOR = null;

  public static Symbol SYM_STELLA_CLASS_DESTRUCTOR = null;

  public static Symbol SYM_STELLA_CLASS_PARAMETERS = null;

  public static Symbol SYM_STELLA_CLASS_INITIAL_VALUE = null;

  public static Symbol SYM_STELLA_CLASS_EXTENSION = null;

  public static Symbol SYM_STELLA_CLASS_CL_NATIVE_TYPE = null;

  public static Symbol SYM_STELLA_CLASS_CPP_NATIVE_TYPE = null;

  public static Symbol SYM_STELLA_CLASS_JAVA_NATIVE_TYPE = null;

  public static int $HARDWIRED_CLASS_ARITY_ON_CLASS$ = Stella.NULL_INTEGER;

  public static Symbol SYM_STELLA_CLASS_CL_STRUCT_SLOTS = null;

  public static Symbol SYM_STELLA_CLASS_RECYCLE_METHOD = null;

  public static Keyword KWD_NONE = null;

  public static Symbol SYM_STELLA_CLASS_REQUIRED_SLOT_NAMES = null;

  public static Symbol SYM_STELLA_CLASS_GUARD_CONSTRUCTOR_DEMONS = null;

  public static Symbol SYM_STELLA_CLASS_CONSTRUCTOR_DEMONS = null;

  public static Symbol SYM_STELLA_CLASS_GUARD_DESTRUCTOR_DEMONS = null;

  public static Symbol SYM_STELLA_CLASS_DESTRUCTOR_DEMONS = null;

  public static Symbol SYM_STELLA_CLASS_KEY = null;

  public static Symbol SYM_STELLA_CLASS_SYNONYMS = null;

  public static Symbol SYM_STELLA_CL_STRUCTp = null;

  public static Symbol SYM_STELLA_MIXINp = null;

  public static Symbol SYM_STELLA_CLASS_TYPE = null;

  public static Symbol SYM_STELLA_CLASS_ARITY = null;

  public static Symbol SYM_STELLA_CLASS_DIRECT_SUPERS = null;

  public static Symbol SYM_STELLA_CLASS_DIRECT_SUBS = null;

  public static Symbol SYM_STELLA_CLASS_ALL_SUPER_CLASSES = null;

  public static Symbol SYM_STELLA_CLASS_ALL_SLOTS = null;

  public static Symbol SYM_STELLA_CLASS_LOCAL_SLOTS = null;

  public static Symbol SYM_STELLA_CLASS_SLOT_AND_METHOD_CACHE = null;

  public static Symbol SYM_STELLA_CLASS_ABSTRACTp = null;

  public static Symbol SYM_STELLA_CLASS_MIXINp = null;

  public static Symbol SYM_STELLA_CLASS_COLLECTIONp = null;

  public static Symbol SYM_STELLA_CLASS_CL_STRUCTp = null;

  public static Symbol SYM_STELLA_CLASS_PUBLICp = null;

  public static Symbol SYM_STELLA_CLASS_FINALIZEDp = null;

  public static Symbol SYM_STELLA_CLASS_SLOTS_FINALIZEDp = null;

  public static Symbol SYM_STELLA_CLASS_STRINGIFIED_SOURCE = null;

  public static Symbol SYM_STELLA_CLASS_CONSTRUCTOR_CODE = null;

  public static Symbol SYM_STELLA_CLASS_SLOT_ACCESSOR_CODE = null;

  public static Symbol SYM_STELLA_CLASS_MARKEDp = null;

  public static Symbol SYM_STELLA_CLASS_TAXONOMY_NODE = null;

  public static Symbol SYM_STELLA_CLASS_DOCUMENTATION = null;

  public static Symbol SYM_STELLA_CLASS_PRINT_FORM = null;

  public static Symbol SYM_STELLA_DOCUMENTATION = null;

  public static Symbol SYM_STELLA_PRINT_FORM = null;

  public static Symbol SYM_STELLA_SLOT_DIRECT_EQUIVALENT = null;

  public static Symbol SYM_STELLA_SLOT_TYPE_SPECIFIER = null;

  public static Symbol SYM_STELLA_SLOT_HOME_MODULE = null;

  public static Symbol SYM_STELLA_SLOT_RENAMES = null;

  public static Surrogate SGT_STELLA_COLLECTION = null;

  public static Symbol SYM_STELLA_SLOT_CLOSURE_ASSUMPTION = null;

  public static Symbol SYM_STELLA_SLOT_DIRECT_SUPERS = null;

  public static Symbol SYM_STELLA_SLOT_DIRECT_SUBS = null;

  public static Symbol SYM_STELLA_SLOT_NAME = null;

  public static Symbol SYM_STELLA_SLOT_OWNER = null;

  public static Symbol SYM_STELLA_SLOT_BASE_TYPE = null;

  public static Symbol SYM_STELLA_SLOT_SLOTREF = null;

  public static Symbol SYM_STELLA_SLOT_PUBLICp = null;

  public static Symbol SYM_STELLA_SLOT_RENAMEDp = null;

  public static Symbol SYM_STELLA_SLOT_EXTERNALp = null;

  public static Symbol SYM_STELLA_SLOT_MARKEDp = null;

  public static Symbol SYM_STELLA_SLOT_DOCUMENTATION = null;

  public static Surrogate SGT_STELLA_STORAGE_SLOT = null;

  public static Symbol SYM_STELLA_SLOT_ALLOCATION = null;

  public static Keyword KWD_INSTANCE = null;

  public static Symbol SYM_STELLA_SLOT_DEFAULT_EXPRESSION = null;

  public static Symbol SYM_STELLA_SLOT_READER = null;

  public static Symbol SYM_STELLA_SLOT_WRITER = null;

  public static Symbol SYM_STELLA_SLOT_GUARD_DEMONS = null;

  public static Symbol SYM_STELLA_SLOT_DEMONS = null;

  public static Symbol SYM_STELLA_SLOT_REQUIREDp = null;

  public static Symbol SYM_STELLA_SLOT_COMPONENTp = null;

  public static Symbol SYM_STELLA_SLOT_READ_ONLYp = null;

  public static Symbol SYM_STELLA_SLOT_HARDWIREDp = null;

  public static Symbol SYM_STELLA_SLOT_CONTEXT_SENSITIVEp = null;

  public static Surrogate SGT_STELLA_METHOD_SLOT = null;

  public static Symbol SYM_STELLA_METHOD_PARAMETER_DIRECTIONS = null;

  public static Symbol SYM_STELLA_METHOD_INLINED_FUNCTIONS = null;

  public static Symbol SYM_STELLA_METHOD_EVALUATE_ARGUMENTSp = null;

  public static Symbol SYM_STELLA_METHOD_SETTERp = null;

  public static Symbol SYM_STELLA_METHOD_PARAMETER_NAMES = null;

  public static Symbol SYM_STELLA_METHOD_PARAMETER_TYPE_SPECIFIERS = null;

  public static Symbol SYM_STELLA_METHOD_RETURN_TYPE_SPECIFIERS = null;

  public static Symbol SYM_STELLA_METHOD_STRINGIFIED_SOURCE = null;

  public static Symbol SYM_STELLA_METHOD_CODE = null;

  public static Symbol SYM_STELLA_FUNCTION_CODE = null;

  public static Symbol SYM_STELLA_METHOD_FUNCTIONp = null;

  public static Symbol SYM_STELLA_METHOD_DOCUMENTATION = null;

  public static Symbol SYM_STELLA_METHOD_AUXILIARYp = null;

  public static Symbol SYM_STELLA_METHOD_STORAGE_SLOT = null;

  public static Symbol SYM_STELLA_SLOT_AUXILIARYp = null;

  public static Symbol SYM_STELLA_STORAGE_SLOT = null;

  public static Symbol SYM_STELLA_FUNCTION = null;

  public static Surrogate SGT_STELLA_PARAMETRIC_TYPE_SPECIFIER = null;

  public static Symbol SYM_STELLA_SPECIFIER_BASE_TYPE = null;

  public static Symbol SYM_STELLA_SPECIFIER_PARAMETER_TYPES = null;

  public static Symbol SYM_STELLA_SPECIFIER_DIMENSIONS = null;

  public static Surrogate SGT_STELLA_ANCHORED_TYPE_SPECIFIER = null;

  public static Symbol SYM_STELLA_SPECIFIER_PARAMETER_NAME = null;

  public static Surrogate SGT_STELLA_TABLE = null;

  public static Symbol SYM_STELLA_TUPLE_DOMAINS = null;

  public static Surrogate SGT_STELLA_GLOBAL_VARIABLE = null;

  public static Symbol SYM_STELLA_VARIABLE_HOME_MODULE = null;

  public static Symbol SYM_STELLA_VARIABLE_NAME = null;

  public static Symbol SYM_STELLA_VARIABLE_TYPE = null;

  public static Symbol SYM_STELLA_VARIABLE_SPECIALp = null;

  public static Symbol SYM_STELLA_VARIABLE_CONSTANTp = null;

  public static Symbol SYM_STELLA_VARIABLE_PUBLICp = null;

  public static Symbol SYM_STELLA_VARIABLE_AUXILIARYp = null;

  public static Symbol SYM_STELLA_VARIABLE_GET_VALUE_CODE = null;

  public static Symbol SYM_STELLA_VARIABLE_SET_VALUE_CODE = null;

  public static Symbol SYM_STELLA_VARIABLE_VALUE_STACK = null;

  public static Symbol SYM_STELLA_VARIABLE_DOCUMENTATION = null;

  public static Symbol SYM_STELLA_VARIABLE_STRINGIFIED_SOURCE = null;

  public static Surrogate SGT_STELLA_QUOTED_EXPRESSION = null;

  public static Symbol SYM_STELLA_QUOTATION_TABLE_OFFSET = null;

  public static Symbol SYM_STELLA_SURROGATE_VALUE_INVERSE = null;

  public static Surrogate SGT_STELLA_MODULE = null;

  public static Surrogate SGT_STELLA_WORLD = null;

  public static Symbol SYM_STELLA_WORLD_NAME = null;

  public static Symbol SYM_STELLA_CHILD_CONTEXTS = null;

  public static Symbol SYM_STELLA_BASE_MODULE = null;

  public static Symbol SYM_STELLA_ALL_SUPER_CONTEXTS = null;

  public static Symbol SYM_STELLA_CONTEXT_NUMBER = null;

  public static Symbol SYM_STELLA_MODULE_LISP_PACKAGE = null;

  public static Symbol SYM_STELLA_MODULE_CPP_PACKAGE = null;

  public static Symbol SYM_STELLA_SHADOWED_SURROGATES = null;

  public static Symbol SYM_STELLA_JAVA_PACKAGE = null;

  public static Symbol SYM_STELLA_CLEARABLEp = null;

  public static Symbol SYM_STELLA_PROTECT_SURROGATESp = null;

  public static Symbol SYM_STELLA_PARENT_MODULES = null;

  public static Symbol SYM_STELLA_NICKNAMES = null;

  public static Symbol SYM_STELLA_USES = null;

  public static Symbol SYM_STELLA_USED_BY = null;

  public static Symbol SYM_STELLA_REQUIRES = null;

  public static Symbol SYM_STELLA_CASE_SENSITIVEp = null;

  public static Symbol SYM_STELLA_MODULE_FULL_NAME = null;

  public static Symbol SYM_STELLA_MODULE_NAME = null;

  public static Symbol SYM_STELLA_MODULE_STRINGIFIED_SOURCE = null;

  public static Symbol SYM_STELLA_STRINGIFIED_OPTIONS = null;

  public static Symbol SYM_STELLA_CARDINAL_MODULE = null;

  public static Symbol SYM_STELLA_SYMBOL_OFFSET_TABLE = null;

  public static Symbol SYM_STELLA_SURROGATE_OFFSET_TABLE = null;

  public static Symbol SYM_STELLA_STRICT_INFERENCE_CACHE = null;

  public static Symbol SYM_STELLA_DEFAULT_INFERENCE_CACHE = null;

  public static Symbol SYM_STELLA_PROTOTYPE_INFERENCE_CACHE = null;

  public static Symbol SYM_STELLA_PARENT_CONTEXT = null;

  public static Surrogate SGT_STELLA_CS_VALUE = null;

  public static Surrogate SGT_STELLA_INTERVAL = null;

  public static Surrogate SGT_STELLA_TAXONOMY_NODE = null;

  public static Symbol SYM_STELLA_NATIVE_OBJECT = null;

  public static Symbol SYM_STELLA_LABEL = null;

  public static Symbol SYM_STELLA_INTERVALS = null;

  public static Symbol SYM_STELLA_INITIAL_INTERVAL = null;

  public static Symbol SYM_STELLA_FIRST_INTERVAL_LOWER_BOUND = null;

  public static Symbol SYM_STELLA_FIRST_INTERVAL_UPPER_BOUND = null;

  public static Symbol SYM_STELLA_PARENTS = null;

  public static Symbol SYM_STELLA_CHILDREN = null;

  public static Symbol SYM_STELLA_TOTAL_ANCESTORS = null;

  public static Symbol SYM_STELLA_TREE_CHILDREN = null;

  public static Symbol SYM_STELLA_MARKER = null;

  public static Surrogate SGT_STELLA_TAXONOMY_GRAPH = null;

  public static Symbol SYM_STELLA_RENUMBER_IF_OUT_OF_NUMBERSp = null;

  public static Symbol SYM_STELLA_RENUMBER_RATIO = null;

  public static Symbol SYM_STELLA_INCREMENTAL_MODEp = null;

  public static Symbol SYM_STELLA_LARGEST_POSTORDER_NUMBER = null;

  public static Symbol SYM_STELLA_NUMBER_OF_NODES = null;

  public static Symbol SYM_STELLA_NUMBER_OF_FOREIGN_INTERVAL_NODES = null;

  public static Symbol SYM_STELLA_ROOTS = null;

  public static Symbol SYM_STELLA_BROKEN_LINKS = null;

  public static Symbol SYM_STELLA_ADDED_LINKS = null;

  public static Symbol SYM_STELLA_REMOVED_LINKS = null;

  public static Symbol SYM_STELLA_FILE_NAME = null;

  public static Surrogate SGT_STELLA_INTEGER_WRAPPER = null;

  public static Symbol SYM_STELLA_WRAPPER_VALUE = null;

  public static Symbol SYM_STELLA_NULL_INTEGER = null;

  public static Surrogate SGT_STELLA_LONG_INTEGER_WRAPPER = null;

  public static Symbol SYM_STELLA_NULL_LONG_INTEGER = null;

  public static Surrogate SGT_STELLA_FLOAT_WRAPPER = null;

  public static Symbol SYM_STELLA_NULL_FLOAT = null;

  public static Surrogate SGT_STELLA_STRING_WRAPPER = null;

  public static Symbol SYM_STELLA_NULL_STRING = null;

  public static Surrogate SGT_STELLA_MUTABLE_STRING_WRAPPER = null;

  public static Symbol SYM_STELLA_NULL_MUTABLE_STRING = null;

  public static Surrogate SGT_STELLA_CHARACTER_WRAPPER = null;

  public static Symbol SYM_STELLA_NULL_CHARACTER = null;

  public static Surrogate SGT_STELLA_BOOLEAN_WRAPPER = null;

  public static Symbol SYM_STELLA_TRUE = null;

  public static Symbol SYM_STELLA_FALSE = null;

  public static Surrogate SGT_STELLA_FUNCTION_CODE_WRAPPER = null;

  public static Surrogate SGT_STELLA_METHOD_CODE_WRAPPER = null;

  public static Surrogate SGT_STELLA_VERBATIM_STRING_WRAPPER = null;

  public static Symbol SYM_STELLA_THREE_VALUED_BOOLEAN = null;

  public static Surrogate SGT_STELLA_SYSTEM_DEFINITION = null;

  public static Symbol SYM_STELLA_NAME = null;

  public static Symbol SYM_STELLA_DIRECTORY = null;

  public static Symbol SYM_STELLA_FILES = null;

  public static Symbol SYM_STELLA_LISP_ONLY_FILES = null;

  public static Symbol SYM_STELLA_CPP_ONLY_FILES = null;

  public static Symbol SYM_STELLA_JAVA_ONLY_FILES = null;

  public static Symbol SYM_STELLA_DATA_FILES = null;

  public static Symbol SYM_STELLA_PREPROCESSED_FILES = null;

  public static Symbol SYM_STELLA_REQUIRED_SYSTEMS = null;

  public static Symbol SYM_STELLA_LOADEDp = null;

  public static Symbol SYM_STELLA_UP_TO_DATEp = null;

  public static Symbol SYM_STELLA_SOURCE_ROOT_DIRECTORY = null;

  public static Symbol SYM_STELLA_NATIVE_ROOT_DIRECTORY = null;

  public static Symbol SYM_STELLA_BINARY_ROOT_DIRECTORY = null;

  public static Symbol SYM_STELLA_BANNER = null;

  public static Symbol SYM_STELLA_COPYRIGHT_HEADER = null;

  public static Symbol SYM_STELLA_PRODUCTION_SETTINGS = null;

  public static Symbol SYM_STELLA_DEVELOPMENT_SETTINGS = null;

  public static Symbol SYM_STELLA_FINALIZATION_FUNCTION = null;

  public static Symbol SYM_STELLA_STATE = null;

  public static Surrogate SGT_STELLA_OUTPUT_STREAM = null;

  public static Keyword KWD_LINE = null;

  public static Surrogate SGT_STELLA_INPUT_STREAM = null;

  public static Symbol SYM_STELLA_ECHO_STREAM = null;

  public static Symbol SYM_STELLA_TOKENIZER_STATE = null;

  public static Symbol SYM_STELLA_BUFFERING_SCHEME = null;

  public static Keyword KWD_CREATE = null;

  public static Keyword KWD_SUPERSEDE = null;

  public static Surrogate SGT_STELLA_OUTPUT_FILE_STREAM = null;

  public static Symbol SYM_STELLA_FILENAME = null;

  public static Symbol SYM_STELLA_IF_EXISTS_ACTION = null;

  public static Symbol SYM_STELLA_IF_NOT_EXISTS_ACTION = null;

  public static Symbol SYM_STELLA_FILE_OUTPUT_STREAM = null;

  public static Keyword KWD_BLOCK = null;

  public static Keyword KWD_ERROR = null;

  public static Surrogate SGT_STELLA_INPUT_FILE_STREAM = null;

  public static Symbol SYM_STELLA_FILE_INPUT_STREAM = null;

  public static Surrogate SGT_STELLA_OUTPUT_STRING_STREAM = null;

  public static Symbol SYM_STELLA_STRING_OUTPUT_STREAM = null;

  public static Surrogate SGT_STELLA_INPUT_STRING_STREAM = null;

  public static Symbol SYM_STELLA_STRING_INPUT_STREAM = null;

  public static Symbol SYM_STELLA_STARTUP_HIERARCHY = null;

  public static Symbol SYM_STELLA_METHOD_STARTUP_CLASSNAME = null;

  /** Generates a newline character when passed to a stream.
   */
  public static Symbol EOL = null;

  public static Symbol SYM_STELLA_EOL = null;

  /** A string constant containing the character sequence
   * necessary to generate a newline.
   */
  public static String EOL_STRING = "\n";

  /** For STELLA we always assume an 8-bit transparent mapping from bytes to STRING characters
   * such as ISO-8859-1 (ISO-LATIN-1), since that's what C++ natively supports.  For Java and some Lisps, we have
   * to do some extra work to enforce this encoding when creating streams.  This is just a first iteration towards
   * this handling this, for example, in Lisp we'd also have to configure compile and load streams to properly encode
   * string constants that contain non-ASCII characters.
   */
  public static java.nio.charset.Charset STELLA_CHARSET = java.nio.charset.Charset.forName("ISO-8859-1");

  /** Denotes the standard input stream for the host language.
   */
  public static InputStream STANDARD_INPUT = null;

  /** Denotes the standard output stream for the host language.
   */
  public static OutputStream STANDARD_OUTPUT = Stella.makeEarlyOutputStream(edu.isi.stella.javalib.NativeOutputStream.create(java.lang.System.out));

  /** Denotes the standard warning stream for the host language.
   */
  public static OutputStream STANDARD_WARNING = Stella.makeEarlyOutputStream(edu.isi.stella.javalib.NativeOutputStream.create(java.lang.System.err));

  /** Denotes the standard error stream for the host language.
   */
  public static OutputStream STANDARD_ERROR = Stella.makeEarlyOutputStream(edu.isi.stella.javalib.NativeOutputStream.create(java.lang.System.err));

  /** If <code>true</code> all passes of a translation will always be performed
   * regardless of whether any errors were encountered.  Otherwise, translation
   * ends with the first pass that encountered an error.
   */
  public final static StellaSpecialVariable $IGNORETRANSLATIONERRORSp$ = new StellaSpecialVariable();

  /** Holds a string containing the single quote character.
   */
  public static StringWrapper SINGLE_QUOTE_STRING = null;

  /** Holds a string containing the single backquote character.
   */
  public static StringWrapper SINGLE_BQUOTE_STRING = null;

  public static Symbol SYM_STELLA_PRINT_STREAM = null;

  public static Symbol SYM_STELLA_STANDARD_OUTPUT = null;

  public static Symbol SYM_STELLA_FOREACH = null;

  public static Symbol SYM_STELLA_I = null;

  public static Symbol SYM_STELLA_IN = null;

  public static Symbol SYM_STELLA_INTERVAL = null;

  public static Symbol SYM_STELLA_DO = null;

  public static Symbol SYM_STELLA_IGNORE = null;

  public static Keyword KWD_COMMON_LISP = null;

  public static Keyword KWD_WARN = null;

  public static Symbol SYM_STELLA_STANDARD_WARNING = null;

  public static Symbol SYM_STELLA_NULL = null;

  public static Symbol SYM_STELLA_STELLA_EXCEPTION = null;

  public static Symbol SYM_STELLA_SIGNAL_EXCEPTION = null;

  public static Symbol SYM_STELLA_NEW = null;

  public static Keyword KWD_MESSAGE = null;

  public static Symbol SYM_STELLA_LET = null;

  public static Symbol SYM_STELLA_OUTPUT_STRING_STREAM = null;

  public static Symbol SYM_STELLA_SIGNAL = null;

  public static Keyword KWD_JAVA = null;

  public static Symbol SYM_STELLA_ERROR_MESSAGE_ = null;

  public static Symbol SYM_STELLA_VERBATIM = null;

  public static Keyword KWD_CONTINUABLE_ERROR = null;

  public static Symbol SYM_STELLA_READ_EXCEPTION = null;

  public static Symbol SYM_STELLA_DE_UGLIFY_PARSE_TREE = null;

  public static Symbol SYM_STELLA_SPECIAL = null;

  public static Symbol SYM_STELLA_$PRINTREADABLYp$ = null;

  public static Symbol SYM_STELLA_SIGNAL_TRANSLATION_ERROR = null;

  public static Symbol SYM_STELLA_UNLESS = null;

  public static Symbol SYM_STELLA_SUPPRESS_WARNINGSp = null;

  public static Symbol SYM_STELLA_PRINT_ERROR_CONTEXT = null;

  public static Symbol SYM_STELLA_STANDARD_ERROR = null;

  public static Symbol SYM_STELLA_SIGNAL_TRANSLATION_NOTE = null;

  public static Symbol SYM_STELLA_SIGNAL_TRANSLATION_WARNING = null;

  public static Symbol SYM_STELLA_WHEN = null;

  public static Symbol SYM_STELLA_NOT = null;

  public static Symbol SYM_STELLA_$EVALUATIONTREE$ = null;

  public static Symbol SYM_STELLA_DEFINEDp = null;

  public static Symbol SYM_STELLA_$EVALUATIONPARENTTREE$ = null;

  public static Symbol SYM_STELLA_EVALUATION_EXCEPTION = null;

  public static Surrogate SGT_STELLA_LITERAL_WRAPPER = null;

  public static Symbol SYM_STELLA_STRINGIFY = null;

  public static Symbol SYM_STELLA_VRLET = null;

  public static Symbol SYM_STELLA_STRING = null;

  public static Symbol SYM_STELLA_SETQ = null;

  public static Symbol SYM_STELLA_CONCATENATE = null;

  public static Keyword KWD_CLOSED = null;

  /** List of file streams that are currently open.
   */
  public static List $OPEN_FILE_STREAMS$ = null;

  public static Keyword KWD_IF_EXISTS = null;

  public static Keyword KWD_IF_EXISTS_ACTION = null;

  public static Keyword KWD_IF_NOT_EXISTS = null;

  public static Keyword KWD_IF_NOT_EXISTS_ACTION = null;

  public static Keyword KWD_ABORT = null;

  public static Keyword KWD_PROBE = null;

  public static Keyword KWD_APPEND = null;

  public static Keyword KWD_OPEN = null;

  public static Symbol SYM_STELLA_UNWIND_PROTECT = null;

  public static Symbol SYM_STELLA_PROGN = null;

  public static Symbol SYM_STELLA_OPEN_INPUT_FILE = null;

  public static Symbol SYM_STELLA_FREE = null;

  public static Symbol SYM_STELLA_OPEN_OUTPUT_FILE = null;

  public static Symbol SYM_STELLA_INPUT_STREAM = null;

  public static Symbol SYM_STELLA_OUTPUT_STREAM = null;

  public static Symbol SYM_STELLA_MV_SETQ = null;

  public static Symbol SYM_STELLA_OPEN_NETWORK_STREAM = null;

  public static String $HTML_QUOTED_CHARACTERS$ = "><&\"";

  public static Surrogate SGT_STELLA_OBJECT = null;

  public static Symbol SYM_STELLA_SUBSEQUENCE = null;

  public static Symbol SYM_STELLA_POSITION = null;

  public static Keyword KWD_LETTER = null;

  public static Keyword KWD_DIGIT = null;

  public static KeyValueList $HTML_ESCAPE_TABLE$ = null;

  public static Symbol SYM_STELLA_THE_STREAM = null;

  public static Surrogate SGT_STELLA_S_EXPRESSION_ITERATOR = null;

  public static Surrogate SGT_STELLA_LINE_ITERATOR = null;

  public static Surrogate SGT_STELLA_NATIVE_LINE_ITERATOR = null;

  public static Surrogate SGT_STELLA_CHARACTER_ITERATOR = null;

  public static KeyValueList $LOGGING_REGISTRY$ = null;

  public static double $LOGGING_LOCAL_TIME_ZONE$ = Stella.NULL_FLOAT;

  public static Keyword KWD_LEVEL = null;

  public static Keyword KWD_LOG_LEVELS = null;

  /** The number of spaces to print before the content of a log message.
   */
  public static int $LOG_INDENT_LEVEL$ = 0;

  public static Keyword KWD_STREAM = null;

  public static Keyword KWD_PREFIX = null;

  public static Keyword KWD_MAX_WIDTH = null;

  public static Surrogate SGT_STELLA_GENERALIZED_SYMBOL = null;

  public static Surrogate SGT_STELLA_FILE_OUTPUT_STREAM = null;

  public static Symbol SYM_STELLA_STARTUP_STREAMS = null;

  /** Spacing between postorder numbers for nodes.  Allows limited
   * incremental insertions without having to renumber the whole graph.
   */
  public static int $NUMBERING_INTERVAL$ = 100;

  /** Dummy label used for marking a node
   */
  public final static int MARKER_LABEL = -99;

  /** Label used for marking deleted nodes
   */
  public final static int DELETED_LABEL = -99;

  public final static StellaSpecialVariable $TAXONOMY_POSTORDER_NUMBER$ = new StellaSpecialVariable();

  public static Symbol SYM_STELLA_STARTUP_TAXONOMIES = null;

  /** A float approximation of the mathematical constant pi.
   */
  public final static double PI = java.lang.Math.PI;

  public final static int NULL_INTEGER = Integer.MIN_VALUE;

  public final static short NULL_SHORT_INTEGER = Short.MIN_VALUE;

  public final static long NULL_LONG_INTEGER = Long.MIN_VALUE;

  public final static short NULL_UNSIGNED_SHORT_INTEGER = Short.MIN_VALUE;

  public final static long NULL_UNSIGNED_LONG_INTEGER = Long.MIN_VALUE;

  public final static double NULL_FLOAT = Double.NEGATIVE_INFINITY; /* IEEE Infinity */;

  public final static float NULL_SINGLE_FLOAT = Float.NEGATIVE_INFINITY; /* IEEE Infinity */;

  public final static double NULL_DOUBLE_FLOAT = Double.NEGATIVE_INFINITY; /* IEEE Infinity */;

  public final static char NULL_CHARACTER = Character.MIN_VALUE;

  public final static byte NULL_BYTE = -128;

  public final static byte NULL_OCTET = -128;

  public final static int MOST_POSITIVE_INTEGER = Integer.MAX_VALUE;

  public static int MOST_NEGATIVE_INTEGER = Stella.NULL_INTEGER;

  public final static long MOST_POSITIVE_LONG_INTEGER = Long.MAX_VALUE;

  public static long MOST_NEGATIVE_LONG_INTEGER = Stella.NULL_LONG_INTEGER;

  public final static double MOST_POSITIVE_FLOAT = Double.MAX_VALUE;

  public final static double MOST_NEGATIVE_FLOAT = 0 - Stella.MOST_POSITIVE_FLOAT;

  public final static double LEAST_POSITIVE_FLOAT = Double.MIN_VALUE;

  public static double LEAST_NEGATIVE_FLOAT = Stella.NULL_FLOAT;

  /** 1 / (log 2) Reciprocal of the Log base e of 2.
   * Used for log 2 conversions.
   */
  public static double RECIPROCAL_NL2 = Stella.NULL_FLOAT;

  /** 1 / (log 10) Reciprocal of the Log base e of 10.
   * Used for log 10 conversions.
   */
  public static double RECIPROCAL_NL10 = Stella.NULL_FLOAT;

  public static Symbol SYM_STELLA_FLOOR = null;

  public static Keyword KWD_CPP = null;

  public static Keyword KWD_FUNCTION = null;

  public static Symbol SYM_STELLA_ROUND = null;

  public static Symbol SYM_STELLA_FMOD = null;

  public static Symbol SYM_STELLA_RANDOM = null;

  public static Symbol SYM_STELLA_SQRT = null;

  public static Symbol SYM_STELLA_COS = null;

  public static Symbol SYM_STELLA_SIN = null;

  public static Symbol SYM_STELLA_TAN = null;

  public static Symbol SYM_STELLA_ACOS = null;

  public static Symbol SYM_STELLA_ASIN = null;

  public static Symbol SYM_STELLA_ATAN = null;

  public static Symbol SYM_STELLA_ATAN2 = null;

  public static Symbol SYM_STELLA_EXP = null;

  public static Symbol SYM_STELLA_LOG = null;

  public static Symbol SYM_STELLA_MIN = null;

  public static Symbol SYM_STELLA_MAX = null;

  public final static StellaSpecialVariable $TRANSIENTOBJECTSp$ = new StellaSpecialVariable();

  public static Keyword KWD_WHITE_SPACE = null;

  public static Keyword KWD_ASCII_CASE_SENSITIVE = null;

  public static Keyword KWD_ASCII_CASE_INSENSITIVE = null;

  public static Keyword KWD_ASCII_CASE_NORMALIZED = null;

  public static Keyword KWD_UPCASE = null;

  public static Keyword KWD_DOWNCASE = null;

  public static Keyword KWD_CAPITALIZE = null;

  public static Keyword KWD_PRESERVE = null;

  public static Keyword KWD_LEFT = null;

  public static Keyword KWD_RIGHT = null;

  public static Keyword KWD_CENTER = null;

  public static Symbol SYM_STELLA_HASH_CODE = null;

  /** A table of 256 N-bit random numbers that can be used to
   * hash sequences of bytes.  Each bit-column in the table has an approximately
   * even number of 0's and 1's.
   */
  public static int[] $HASH_BYTE_RANDOM_TABLE$ = null;

  /** The most significant bit of a regular integer (FIXNUM
   * in Common-Lisp).  In C++ and Java this corresponds to the sign bit, in
   * Lisp this corresponds to the left-most bit of <code>CLCmost_positive_fixnum</code>.
   */
  public final static int $INTEGER_MSB_MASK$ = 0x80000000;

  /** Mask that covers all the unsigned bits of an integer.
   */
  public final static int $INTEGER_UNSIGNED_BITS_MASK$ = Stella.MOST_POSITIVE_INTEGER;

  /** The sign bit of a long integer.
   */
  public final static long $LONG_INTEGER_MSB_MASK$ = Stella.NULL_LONG_INTEGER;

  /** Mask that covers all the unsigned bits of a long integer.
   */
  public final static long $LONG_INTEGER_UNSIGNED_BITS_MASK$ = Stella.MOST_POSITIVE_LONG_INTEGER;

  /** List of prime numbers approximately growing by a factor of 2
   * that are suitable to be used as hash table sizes.  This is in string
   * format to enable processing by Lisps with different fixnum sizes.
   */
  public static Vector $HASH_TABLE_SIZE_PRIME_STRINGS$ = null;

  /** List of prime numbers approximately growing by a factor of 2
   * that are suitable to be used as hash table sizes.
   */
  public static Vector $HASH_TABLE_SIZE_PRIMES$ = null;

  public static Keyword KWD_UNIX = null;

  public static Keyword KWD_MAC = null;

  public static Keyword KWD_WINDOWS = null;

  /** The number of bits in a long integer.
   */
  public static int LONG_INTEGER_BIT_WIDTH = Stella.NULL_INTEGER;

  public static Keyword KWD_TYPE_4 = null;

  public static Keyword KWD_RANDOM = null;

  public static Symbol SYM_STELLA_SLEEP = null;

  /** Process lock object for bootstrap use.
   */
  public static Object $BOOTSTRAP_LOCK$ = new java.lang.Object();

  public static Symbol SYM_STELLA_STARTUP_PRIMAL = null;

  public static boolean $CLASS_HIERARCHY_BOOTEDp$ = false;

  public static Surrogate SGT_STELLA_UNKNOWN = null;

  public static Surrogate SGT_STELLA_WRAPPER = null;

  public static Symbol SYM_STELLA_STARTUP_TYPE_PREDICATES = null;

  public static Cons NIL = null;

  /** Point where we switch from using a quadratic remove
   * duplicates algorithm to a linear one using a hash table.  For
   * an unoptimized Common Lisp, 20 is a good crossover point.
   */
  public static int $REMOVE_DUPLICATES_CROSSOVER_POINT$ = 20;

  public final static StellaSpecialVariable $SORT_TUPLE_COMPARE_PREDICATE$ = new StellaSpecialVariable();

  public final static StellaSpecialVariable $SORT_TUPLE_COMPARE_INDEX$ = new StellaSpecialVariable();

  public final static StellaSpecialVariable $SORT_OBJECTS_COMPARE_SLOT$ = new StellaSpecialVariable();

  public static Symbol SYM_STELLA_p = null;

  /** If <code>true</code> conses will be pretty printed.
   */
  public final static StellaSpecialVariable $PRINTPRETTYp$ = new StellaSpecialVariable();

  /** If <code>true</code> conses will be printed as readable Stella code.
   */
  public final static StellaSpecialVariable $PRINTREADABLYp$ = new StellaSpecialVariable();

  /** If non-NULL list-like data structures will print at most
   * that many elements.
   */
  public final static StellaSpecialVariable $PRINTLENGTH$ = new StellaSpecialVariable();

  /** Generates an elipsis '...' when found in a
   * pretty-printed parse tree.
   */
  public static Symbol ELIPSIS = null;

  public static Symbol SYM_STELLA_ddd = null;

  /** When <code>true</code> pretty-print Stella and translated code.
   * Since (Lisp) pretty-printing is somewhat slow, turning this off speeds up
   * file translation, but it also makes translated output very unreadable.
   */
  public final static StellaSpecialVariable $PRINTPRETTYCODEp$ = new StellaSpecialVariable();

  public final static StellaSpecialVariable $DEPTHEXCEEDEDp$ = new StellaSpecialVariable();

  public static int $DEPTHCUTOFF$ = 33;

  public static Symbol SYM_STELLA_STARTUP_CONSES = null;

  public static List NIL_LIST = null;

  public static Surrogate SGT_STELLA_STELLA_HASH_TABLE = null;

  public static Surrogate SGT_STELLA_KEY_VALUE_MAP = null;

  public static Symbol SYM_STELLA_STARTUP_LISTS = null;

  public static Symbol SYM_STELLA_VECTOR = null;

  public static Surrogate SGT_STELLA_HEAP = null;

  public static Symbol SYM_STELLA_PREDICATE = null;

  public static Symbol SYM_STELLA_FILL_POINTER = null;

  public static boolean $USE_STELLA_HASH_TABLESp$ = false;

  public static Symbol SYM_STELLA_SIZE = null;

  public static Symbol SYM_STELLA_INITIAL_SIZE = null;

  public static Symbol SYM_STELLA_FREE_ELEMENTS = null;

  public static Symbol SYM_STELLA_EQUAL_TESTp = null;

  public static double $STELLA_HASH_TABLE_AVG_BUCKET_LENGTH$ = 1.0;

  public static Surrogate SGT_STELLA_STELLA_HASH_TABLE_ITERATOR = null;

  public static Symbol SYM_STELLA_BUCKET_INDEX = null;

  public static Symbol SYM_STELLA_BUCKET_CURSOR = null;

  /** Point where we switch from using a KV-CONS table
   * representation to a STELLA hash table to preserve O(1) access.
   */
  public static int $KEY_VALUE_MAP_CROSSOVER_POINT$ = Stella.NULL_INTEGER;

  public static Symbol SYM_STELLA_THE_MAP = null;

  public static Symbol SYM_STELLA_CROSSOVER_POINT = null;

  public static Surrogate SGT_STELLA_HASH_SET = null;

  public static Surrogate SGT_STELLA_1D_ARRAY = null;

  public static Symbol SYM_STELLA_OBJECT_ARRAY = null;

  public static Surrogate SGT_STELLA_1D_FLOAT_ARRAY = null;

  public static Symbol SYM_STELLA_FLOAT_ARRAY = null;

  public static Surrogate SGT_STELLA_2D_ARRAY = null;

  public static Surrogate SGT_STELLA_2D_FLOAT_ARRAY = null;

  public static Symbol SYM_STELLA_STARTUP_COLLECTIONS = null;

  public static Surrogate SGT_STELLA_CROSS_PRODUCT_ITERATOR = null;

  public static Symbol SYM_STELLA_DOMAINS = null;

  public static Symbol SYM_STELLA_CURSORS = null;

  public static Symbol SYM_STELLA_STARTUP_ITERATORS = null;

  public static ExtensibleSymbolArray $SYMBOL_ARRAY$ = null;

  public static ExtensibleSymbolArray $SURROGATE_ARRAY$ = null;

  public static ExtensibleSymbolArray $KEYWORD_ARRAY$ = null;

  public static StringToIntegerHashTable $KEYWORD_OFFSET_TABLE$ = null;

  public static ExtensibleSymbolArray $FIXED_SYMBOL_ARRAY$ = null;

  public static ExtensibleSymbolArray $FIXED_SURROGATE_ARRAY$ = null;

  public static ExtensibleSymbolArray $FIXED_KEYWORD_ARRAY$ = null;

  public static StringHashTable $TRANSIENT_SYMBOL_LOOKUP_TABLE$ = null;

  public static StringHashTable $COMMON_LISP_SYMBOL_LOOKUP_TABLE$ = null;

  public final static int SYMBOL_SYM = 0;

  public final static int SURROGATE_SYM = 1;

  public final static int KEYWORD_SYM = 2;

  /** Pointer to the top-most module ROOT-MODULE.
   */
  public static Module $ROOT_MODULE$ = null;

  /** Pointer to the module STELLA containing definitions of 
   * STELLA classes and methods.
   */
  public static Module $STELLA_MODULE$ = null;

  /** Pointer to the module COMMON-LISP containing Common
   * Lisp symbols (and maybe other things).
   */
  public static Module $COMMON_LISP_MODULE$ = null;

  /** Pointer to the module ALTERNATE-STELLA containing
   * definitions of STELLA classes and methods generated during the
   * translation of STELLA files.
   */
  public static Module $ALTERNATE_STELLA_MODULE$ = null;

  /** Points to the current context (either a module or a
   * world).  Set by calls to <code>changeWorld</code> and <code>changeModule</code>.
   */
  public final static StellaSpecialVariable $CONTEXT$ = new StellaSpecialVariable();

  /** Points to the current module.  Set by calls to
   * <code>changeContext</code> and <code>changeModule</code>.
   */
  public final static StellaSpecialVariable $MODULE$ = new StellaSpecialVariable();

  /** Character used to prefix the name of a surrogate.
   */
  public final static char SURROGATE_PREFIX_CHARACTER = '@';

  /** Character used to concatenate a module name
   * to a symbol or surrogate name to form a qualified name.
   */
  public final static char MODULE_SEPARATOR_CHARACTER = '/';

  /** String containing character used to concatenate a module name
   * to a symbol or surrogate name to form a qualified name.
   */
  public final static String MODULE_SEPARATOR_STRING = "/";

  /** Contains the number of the last-created
   * context (all 'live' contexts are even-numbered).
   */
  public static int $CONTEXT_NUMBER_COUNTER$ = -2;

  public static Symbol SYM_STELLA_CODE_ONLYp = null;

  /** Incremented once for each gensym call.
   */
  public static int $GENSYM_COUNTER$ = 0;

  /** Defines the separator character for gensyms,
   * and the fill digits.
   */
  public static String $GENSYM_MASK$ = "-000";

  public static Keyword KWD_SYMBOL = null;

  public static Keyword KWD_SURROGATE = null;

  public static Keyword KWD_KEYWORD = null;

  public static Keyword KWD_SYMBOL_CONSTITUENT = null;

  public static String $SYMBOL_ESCAPE_CODE_TABLE$ = null;

  public static String $CASE_SENSITIVE_SYMBOL_ESCAPE_CODE_TABLE$ = null;

  public static Keyword KWD_ESCAPED = null;

  public static Keyword KWD_UNESCAPED = null;

  public static Keyword KWD_COMPLEX_ESCAPED = null;

  public static Symbol SYM_STELLA_STARTUP_SYMBOLS = null;

  public static IntegerWrapper ZERO_WRAPPER = null;

  public static IntegerWrapper ONE_WRAPPER = null;

  public static BooleanWrapper TRUE_WRAPPER = null;

  public static BooleanWrapper FALSE_WRAPPER = null;

  public static IntegerWrapper NULL_INTEGER_WRAPPER = null;

  public static LongIntegerWrapper NULL_LONG_INTEGER_WRAPPER = null;

  public static FloatWrapper NULL_FLOAT_WRAPPER = null;

  public static StringWrapper NULL_STRING_WRAPPER = null;

  public static MutableStringWrapper NULL_MUTABLE_STRING_WRAPPER = null;

  public static CharacterWrapper NULL_CHARACTER_WRAPPER = null;

  public static FunctionCodeWrapper NULL_FUNCTION_CODE_WRAPPER = null;

  public static MethodCodeWrapper NULL_METHOD_CODE_WRAPPER = null;

  /** Table that holds a variety of information about literal
   * types, e.g., the name of their null-wrapper, wrap-function, etc.
   */
  public static HashTable $LITERAL_TYPE_INFO_TABLE$ = null;

  /** List of literal types stored in '*literal-type-info-table*'.
   * Maintained for iteration purposes.
   */
  public static List $LITERAL_TYPES$ = null;

  public static Surrogate SGT_STELLA_BOOLEAN = null;

  public static Keyword KWD_NULL_WRAPPER = null;

  public static Symbol SYM_STELLA_FALSE_WRAPPER = null;

  public static Surrogate SGT_STELLA_INTEGER = null;

  public static Symbol SYM_STELLA_NULL_INTEGER_WRAPPER = null;

  public static Surrogate SGT_STELLA_LONG_INTEGER = null;

  public static Symbol SYM_STELLA_NULL_LONG_INTEGER_WRAPPER = null;

  public static Surrogate SGT_STELLA_FLOAT = null;

  public static Symbol SYM_STELLA_NULL_FLOAT_WRAPPER = null;

  public static Surrogate SGT_STELLA_STRING = null;

  public static Symbol SYM_STELLA_NULL_STRING_WRAPPER = null;

  public static Surrogate SGT_STELLA_MUTABLE_STRING = null;

  public static Symbol SYM_STELLA_NULL_MUTABLE_STRING_WRAPPER = null;

  public static Surrogate SGT_STELLA_CHARACTER = null;

  public static Symbol SYM_STELLA_NULL_CHARACTER_WRAPPER = null;

  public static Surrogate SGT_STELLA_FUNCTION_CODE = null;

  public static Symbol SYM_STELLA_NULL_FUNCTION_CODE_WRAPPER = null;

  public static Surrogate SGT_STELLA_METHOD_CODE = null;

  public static Symbol SYM_STELLA_NULL_METHOD_CODE_WRAPPER = null;

  public static Symbol SYM_STELLA_TRUE_WRAPPER = null;

  public static Symbol SYM_STELLA_WRAP_BOOLEAN = null;

  public static Symbol SYM_STELLA_COERCE_WRAPPED_BOOLEAN_TO_BOOLEAN = null;

  public static Keyword KWD_WRAP_FUNCTION = null;

  public static Symbol SYM_STELLA_WRAP_INTEGER = null;

  public static Symbol SYM_STELLA_WRAP_LONG_INTEGER = null;

  public static Symbol SYM_STELLA_WRAP_FLOAT = null;

  public static Symbol SYM_STELLA_WRAP_STRING = null;

  public static Symbol SYM_STELLA_WRAP_CHARACTER = null;

  public static Symbol SYM_STELLA_WRAP_FUNCTION_CODE = null;

  public static Symbol SYM_STELLA_WRAP_METHOD_CODE = null;

  public static Symbol SYM_STELLA_NIL = null;

  public static Symbol SYM_STELLA_CONS = null;

  public static Symbol SYM_STELLA_WRAP_LITERAL = null;

  public static Symbol SYM_STELLA_GET_KWD = null;

  public static Symbol SYM_STELLA_TYPED_SYS = null;

  public static Symbol SYM_STELLA_GET_SGT = null;

  public static Symbol SYM_STELLA_INTERN_COMMON_LISP_SYMBOL = null;

  public static Symbol SYM_STELLA_GET_SYM = null;

  public static Symbol SYM_STELLA_LIST$ = null;

  public static Symbol SYM_STELLA_a = null;

  public static Symbol SYM_STELLA_aa = null;

  public static Keyword KWD_OTHER = null;

  public static Keyword KWD_SYMBOL_QUALIFIER = null;

  public static Keyword KWD_ESCAPE = null;

  public static Keyword KWD_DELIMITER = null;

  /** Table of character types.  Entry 'i' represents the type
   * of the character whose 'char-code' equals 'i'.  Each character is classified 
   * by one of the following keywords: :DIGIT, :LETTER, :SYMBOL-CONSTITUENT, 
   * :SYMBOL-QUALIFIER, :ESCAPE, :DELIMITER, :WHITE-SPACE, or :OTHER.
   */
  public static Keyword[] $CHARACTER_TYPE_TABLE$ = null;

  public static String $CHARACTER_UPCASE_TABLE$ = null;

  public static String $CHARACTER_DOWNCASE_TABLE$ = null;

  public static Symbol SYM_STELLA_STARTUP_LITERALS = null;

  /** If set, warn about each redefinition.
   */
  public final static StellaSpecialVariable $WARNIFREDEFINEp$ = new StellaSpecialVariable();

  public static Keyword KWD_PUBLICp = null;

  public static Keyword KWD_PARAMETERS = null;

  public static Keyword KWD_REQUIREDp = null;

  public static Keyword KWD_COMPONENTp = null;

  public static Keyword KWD_READ_ONLYp = null;

  public static Keyword KWD_ACTIVEp = null;

  public static Keyword KWD_CONTEXT_SENSITIVEp = null;

  public static Keyword KWD_HARDWIREDp = null;

  public static Keyword KWD_ABSTRACTp = null;

  public static Keyword KWD_ALLOCATION = null;

  public static Keyword KWD_CLASS = null;

  public static Keyword KWD_INITIALLY = null;

  public static Symbol SYM_STELLA_SLOT_INITIAL_VALUE = null;

  public static Keyword KWD_DEFAULT = null;

  public static Keyword KWD_READER = null;

  public static Keyword KWD_WRITER = null;

  public static Keyword KWD_INVERSE = null;

  public static Symbol SYM_STELLA_SLOT_INVERSE = null;

  public static Keyword KWD_RENAMES = null;

  public static Keyword KWD_DOCUMENTATION = null;

  public static Keyword KWD_PROPERTIES = null;

  public static Keyword KWD_META_ATTRIBUTES = null;

  public static Symbol SYM_STELLA_META_ATTRIBUTES = null;

  public static Keyword KWD_OPTION_KEYWORD = null;

  public static Symbol SYM_STELLA_SLOT_OPTION_KEYWORD = null;

  public static Keyword KWD_OPTION_HANDLER = null;

  public static Symbol SYM_STELLA_SLOT_OPTION_HANDLER = null;

  public static Keyword KWD_BIT = null;

  public static Keyword KWD_CL_NATIVE_TYPE = null;

  public static Keyword KWD_CPP_NATIVE_TYPE = null;

  public static Keyword KWD_IDL_NATIVE_TYPE = null;

  public static Symbol SYM_STELLA_CLASS_IDL_NATIVE_TYPE = null;

  public static Keyword KWD_JAVA_NATIVE_TYPE = null;

  public static Keyword KWD_CL_STRUCTp = null;

  public static Keyword KWD_MIXINp = null;

  public static Keyword KWD_RECYCLE_METHOD = null;

  public static Keyword KWD_EXTENSION = null;

  public static Symbol SYM_STELLA_CLASS_EXTENSION_NAME = null;

  public static Keyword KWD_CREATOR = null;

  public static Keyword KWD_INITIALIZER = null;

  public static Keyword KWD_TERMINATOR = null;

  public static Keyword KWD_DESTRUCTOR = null;

  public static Keyword KWD_INITIAL_VALUE = null;

  public static Keyword KWD_PRINT_FORM = null;

  public static Keyword KWD_EQUALITY_TEST = null;

  public static Keyword KWD_KEY = null;

  public static Keyword KWD_SYNONYMS = null;

  public static Keyword KWD_CHILDREN = null;

  /** List of classes whose class or slot inheritance is
   * currently unfinalized.
   */
  public static List $UNFINALIZED_CLASSES$ = null;

  /** Set to <code>true</code> by <code>rememberUnfinalizedClass</code>; set
   * to <code>false</code> by <code>cleanupUnfinalizedClasses</code>.  Minimizes the time that
   * <code>finalizeClasses</code> spends searching for classes to finalize.
   */
  public static boolean $NEWLY_UNFINALIZED_CLASSESp$ = false;

  /** List of classes defined with a :children option
   * which still have some of their children references unresolved.
   */
  public static List $CLASSES_WITH_UNRESOLVED_CHILDREN_REFERENCES$ = null;

  public static Surrogate SGT_STELLA_STANDARD_OBJECT = null;

  public static Symbol SYM_STELLA_PRIMARY_TYPE = null;

  public static Symbol SYM_STELLA_SELF = null;

  public static Keyword KWD_TYPE = null;

  public static Keyword KWD_AUXILIARYp = null;

  public static Symbol SYM_STELLA_RETURN = null;

  public static Surrogate SGT_STELLA_SET_MIXIN = null;

  public static Symbol SYM_STELLA_INVERSE = null;

  public static Keyword KWD_DYNAMIC = null;

  public static Surrogate SGT_STELLA_DYNAMIC_SLOTS_MIXIN = null;

  public static Surrogate SGT_STELLA_CONTEXT_SENSITIVE_OBJECT = null;

  public static Surrogate SGT_STELLA_CONTEXT_SENSITIVE_MIXIN = null;

  public static Surrogate SGT_STELLA_VOID = null;

  public static int $SYMBOL_SLOT_OFFSET_COUNTER$ = 0;

  public static int $SLOT_CACHE_SIZE$ = 20;

  public static Symbol SYM_STELLA_METHOD_MACROp = null;

  public static Surrogate SGT_STELLA_ALL_CLASS_SLOTS_ITERATOR = null;

  public static TaxonomyGraph $CLASS_TAXONOMY_GRAPH$ = null;

  public static Symbol SYM_STELLA_ANY = null;

  public static Surrogate SGT_STELLA_ANY = null;

  public static Surrogate SGT_STELLA_SLOT = null;

  public static Symbol SYM_STELLA_STARTUP_CLASSES = null;

  public static Symbol SYM_STELLA_LIKE = null;

  public static Symbol SYM_STELLA_UNKNOWN = null;

  public static Symbol SYM_STELLA_OF = null;

  public static Surrogate SGT_STELLA_ARRAY = null;

  public static Symbol SYM_STELLA_OUT = null;

  public static Symbol SYM_STELLA_INOUT = null;

  public static Symbol SYM_STELLA_ARGUMENT_LIST = null;

  public static Symbol SYM_STELLA_aREST = null;

  public static Symbol SYM_STELLA_METHOD_VARIABLE_ARGUMENTSp = null;

  public static Symbol SYM_STELLA_aBODY = null;

  public static Symbol SYM_STELLA_METHOD_BODY_ARGUMENTp = null;

  public static Keyword KWD_RETURN_TYPES = null;

  public static Keyword KWD_NATIVEp = null;

  public static Symbol SYM_STELLA_METHOD_NATIVEp = null;

  public static Keyword KWD_CONSTRUCTORp = null;

  public static Symbol SYM_STELLA_METHOD_CONSTRUCTORp = null;

  public static Keyword KWD_GLOBALLY_INLINEp = null;

  public static Symbol SYM_STELLA_METHOD_GLOBALLY_INLINEp = null;

  public static Keyword KWD_INLINE = null;

  public static Keyword KWD_RETURNS = null;

  public static Keyword KWD_STORAGE_SLOT = null;

  public static Keyword KWD_INHERITS_THROUGH = null;

  public static Symbol SYM_STELLA_METHOD_INHERITS_THROUGH = null;

  public static Keyword KWD_COMMANDp = null;

  public static Symbol SYM_STELLA_METHOD_COMMANDp = null;

  public static Keyword KWD_LISP_MACROp = null;

  public static Symbol SYM_STELLA_METHOD_LISP_MACROp = null;

  public static Keyword KWD_EVALUATE_ARGUMENTSp = null;

  /** Maximum size for a string constant in the target language.
   */
  public static int $MAXIMUM_STRING_CONSTANT_SIZE$ = 4000;

  public static Symbol SYM_STELLA_DEFINE_FUNCTION_OBJECT = null;

  public static Symbol SYM_STELLA_THE_CODE = null;

  public static Symbol SYM_STELLA_DEFINE_METHOD_OBJECT = null;

  public static Keyword KWD_METHOD = null;

  public static Symbol SYM_STELLA_SUPER_CLASSES = null;

  public static Symbol SYM_STELLA_EQUIVALENT_SLOT = null;

  public static Symbol SYM_STELLA_SLOT_VALUE = null;

  public static Symbol SYM_STELLA_LOOP = null;

  public static Symbol SYM_STELLA_IF = null;

  public static Symbol SYM_STELLA_FIRST = null;

  public static Symbol SYM_STELLA_VARIABLE_ARITY_TABLEp = null;

  /** Lookup table for functions.
   */
  public static HashTable $FUNCTION_LOOKUP_TABLE$ = null;

  public static Symbol SYM_STELLA_EVALUATOR_WRAPPER_CODE = null;

  /** Lookup table for global variables.
   */
  public static HashTable $GLOBAL_VARIABLE_LOOKUP_TABLE$ = null;

  public static Symbol SYM_STELLA_VARIABLE_TYPE_SPECIFIER = null;

  public static Symbol SYM_STELLA_DEFSPECIAL = null;

  public static Symbol SYM_STELLA_DEFCONSTANT = null;

  public static Keyword KWD_UNBOUND_SPECIAL_VARIABLE = null;

  public static Symbol SYM_STELLA_STARTUP_METHODS = null;

  public static Surrogate SGT_STELLA_LITERAL = null;

  public static Surrogate SGT_STELLA_SECOND_CLASS_OBJECT = null;

  public static Symbol SYM_STELLA_DEFINE_CLASS_FROM_STRINGIFIED_SOURCE = null;

  public static Keyword KWD_IDL = null;

  public static Keyword KWD_CPP_STANDALONE = null;

  public static Surrogate SGT_STELLA_NON_OBJECT = null;

  public static Surrogate SGT_STELLA_NATIVE_EXCEPTION = null;

  public static Symbol SYM_STELLA_NEXT_SWEEP_LIST_OBJECT = null;

  public static Keyword KWD_FREE_LIST = null;

  public static Keyword KWD_FREE_AND_SWEEP_LIST = null;

  public static Keyword KWD_SWEEP_LIST = null;

  public static Keyword KWD_USE_COMMON_LISP_STRUCTS = null;

  public static Keyword KWD_USE_COMMON_LISP_VECTOR_STRUCTS = null;

  public static Symbol SYM_STELLA_DEFGLOBAL = null;

  public static Symbol SYM_STELLA_RECYCLE_LIST = null;

  public static Symbol SYM_STELLA_CREATE_RECYCLE_LIST = null;

  public static Symbol SYM_STELLA_MAKE = null;

  public static Symbol SYM_STELLA_DYNAMIC_SLOTS = null;

  public static Symbol SYM_STELLA_CLEAR = null;

  public static Keyword KWD_FORCE_NULL_VALUE = null;

  public static Keyword KWD_NULL_VALUE_ONLY = null;

  public static Symbol SYM_STELLA_AND = null;

  public static Symbol SYM_STELLA_$RECYCLING_ENABLEDp$ = null;

  public static Symbol SYM_STELLA_COND = null;

  public static Symbol SYM_STELLA___ = null;

  public static Symbol SYM_STELLA_OTHERWISE = null;

  public static Symbol SYM_STELLA_POP = null;

  public static Symbol SYM_STELLA_SETF = null;

  public static Symbol SYM_STELLA_ii = null;

  public static Symbol SYM_STELLA_e = null;

  public static Symbol SYM_STELLA_$RECYCLE_LISTS_MAINTENANCE_TIMER$ = null;

  public static Symbol SYM_STELLA_MAINTAIN_RECYCLE_LISTS = null;

  public static Keyword KWD_INITIAL_VALUE_ONLY = null;

  public static Keyword KWD_ANY_INITIAL_VALUE = null;

  public static Symbol SYM_STELLA_RUN_CONSTRUCTOR_DEMONS = null;

  public static Symbol SYM_STELLA_DEFUN = null;

  public static Symbol SYM_STELLA_MESSAGE = null;

  public static Symbol SYM_STELLA_DEFMETHOD = null;

  public static Symbol SYM_STELLA_PUSH = null;

  public static Symbol SYM_STELLA_SWEEP = null;

  public static Symbol SYM_STELLA_UNUSED = null;

  public static Symbol SYM_STELLA_WHILE = null;

  public static Symbol SYM_STELLA_EQLp = null;

  public static Symbol SYM_STELLA_UNMAKE = null;

  /** If <code>TRUE</code> calls to <code>renamed_New</code> or <code>free</code> on classes with :recycle-method;
   * specifications will actually operate on recycle lists.  Otherwise, all
   * recycle list operations will be no-ops.
   */
  public final static StellaSpecialVariable $RECYCLING_ENABLEDp$ = new StellaSpecialVariable();

  public static List $ALL_RECYCLE_LISTS$ = null;

  /** Maximum number of bytes to be occupied by recycle lists.
   */
  public static int $MAX_RECYCLE_LIST_BYTES$ = 3000000;

  /** Total number of recycle list extensions after which a
   * size maintenance operation is performed to ensure that
   * the <code>$MAX_RECYCLE_LIST_BYTES$</code> limit is still met.
   */
  public static int $RECYCLE_LISTS_MAINTENANCE_INTERVAL$ = 5000;

  public static int $RECYCLE_LISTS_MAINTENANCE_TIMER$ = Stella.NULL_INTEGER;

  public static Surrogate SGT_STELLA_TRANSIENT_MIXIN = null;

  /** During recycle list debugging holds all items that live in
   * some free list.  Depending on program behavior, this table can get quite large!
   */
  public static HashTable $CURRENTLY_RECYCLED_ITEMS$ = null;

  public static boolean $TRANSLATE_WITH_RECYCLE_LIST_DEBUGGINGp$ = false;

  public static Symbol SYM_STELLA_RECYCLE_LIST_DEBUGGING_ENABLEDp = null;

  public static Symbol SYM_STELLA_REGISTER_RECYCLED_ITEM = null;

  public static Symbol SYM_STELLA_UNREGISTER_RECYCLED_ITEM = null;

  public static Symbol SYM_STELLA_INLINE_WRAP_BOOLEAN = null;

  public static Symbol SYM_STELLA_ANSWER = null;

  public static Symbol SYM_STELLA_NULLp = null;

  public static Symbol SYM_STELLA_ERROR = null;

  public static Symbol SYM_STELLA_CAST = null;

  public static Symbol SYM_STELLA_SETVALUEp = null;

  public static Symbol SYM_STELLA_SLOTNAME = null;

  public static Symbol SYM_STELLA_QUOTE = null;

  public static Symbol SYM_STELLA_CASE = null;

  public static Symbol SYM_STELLA_SET_DYNAMIC_SLOT_VALUE = null;

  public static Symbol SYM_STELLA_LOOKUP = null;

  public static Symbol SYM_STELLA_OBJECT = null;

  public static Symbol SYM_STELLA_SYMBOL = null;

  public static Symbol SYM_STELLA_BOOLEAN = null;

  public static Symbol SYM_STELLA_TYPECASE = null;

  public static Symbol SYM_STELLA_EQp = null;

  public static Symbol SYM_STELLA_OTHER = null;

  public static Symbol SYM_STELLA_EQUAL = null;

  public static Symbol SYM_STELLA_STARTUP_DEFCLASS = null;

  public static Keyword KWD_MONDAY = null;

  public static Keyword KWD_TUESDAY = null;

  public static Keyword KWD_WEDNESDAY = null;

  public static Keyword KWD_THURSDAY = null;

  public static Keyword KWD_FRIDAY = null;

  public static Keyword KWD_SATURDAY = null;

  public static Keyword KWD_SUNDAY = null;

  public static Keyword KWD_NEW_MOON = null;

  public static Keyword KWD_FIRST_QUARTER = null;

  public static Keyword KWD_FULL_MOON = null;

  public static Keyword KWD_LAST_QUARTER = null;

  static int MILLIS_PER_DAY = Stella.NULL_INTEGER;

  static int MILLIS_PER_HOUR = Stella.NULL_INTEGER;

  /** A vector of month names for printing dates
   */
  public static Vector $MONTH_NAME_VECTOR$ = null;

  /** A vector of month abbreviations for printing dates
   */
  public static Vector $MONTH_ABBREVIATION_VECTOR$ = null;

  public static Surrogate SGT_STELLA_DECODED_DATE_TIME = null;

  public static Symbol SYM_STELLA_DATE_TIME_MILLIS = null;

  public static Symbol SYM_STELLA_DATE_TIME_SECOND = null;

  public static Symbol SYM_STELLA_DATE_TIME_MINUTE = null;

  public static Symbol SYM_STELLA_DATE_TIME_HOUR = null;

  public static Symbol SYM_STELLA_DATE_TIME_DAY = null;

  public static Symbol SYM_STELLA_DATE_TIME_MONTH = null;

  public static Symbol SYM_STELLA_DATE_TIME_YEAR = null;

  public static Symbol SYM_STELLA_DATE_TIME_ZONE = null;

  public static Symbol SYM_STELLA_DATE_TIME_DOW = null;

  public static Surrogate SGT_STELLA_DECODED_TIME_DURATION = null;

  public static Symbol SYM_STELLA_DURATION_MILLIS = null;

  public static Symbol SYM_STELLA_DURATION_SECONDS = null;

  public static Symbol SYM_STELLA_DURATION_MINUTES = null;

  public static Symbol SYM_STELLA_DURATION_HOURS = null;

  public static Symbol SYM_STELLA_DURATION_DAYS = null;

  public static Surrogate SGT_STELLA_CALENDAR_DATE = null;

  public static Symbol SYM_STELLA_MODIFIED_JULIAN_DAY = null;

  public static Symbol SYM_STELLA_TIME_MILLIS = null;

  public static Surrogate SGT_STELLA_TIME_DURATION = null;

  public static Symbol SYM_STELLA_DAYS = null;

  public static Symbol SYM_STELLA_MILLIS = null;

  public static DecodedDateTime $DEFAULT_DECODED_DATE_TIME$ = null;

  public static DecodedDateTime $NULL_DECODED_DATE_TIME$ = null;

  public static Surrogate SGT_STELLA_NUMBER_WRAPPER = null;

  public static Symbol SYM_STELLA_INCOMPATIBLE_QUANTITY_EXCEPTION = null;

  public static Symbol SYM_STELLA_T1 = null;

  public static Symbol SYM_STELLA_T2 = null;

  public static Symbol SYM_STELLA_CALENDAR_DATE = null;

  public static Symbol SYM_STELLA_TIME_DURATION = null;

  /** Handler functions indexed by the character code of their control character.
   */
  public static Vector $FORMAT_DATE_HANDLERS$ = null;

  public static Symbol SYM_STELLA_STARTUP_DATE_TIME = null;

  public static Cons WHITESPACE_CHARS = null;

  public static Cons TIME_DIVIDERS = null;

  public static Cons DATE_DIVIDERS = null;

  public static Cons DATE_TIME_DIVIDERS = null;

  /** If TRUE, an error will be signalled if parse-date-time is unable
   *    to determine the time/date format of the string.
   */
  public final static StellaSpecialVariable $ERROR_ON_MISMATCH$ = new StellaSpecialVariable();

  public static Symbol SYM_STELLA_ITEM = null;

  public static Symbol SYM_STELLA_INSERT_AT = null;

  public static Symbol SYM_STELLA_SECOND = null;

  public final static StellaSpecialVariable $WEEKDAY_STRINGS$ = new StellaSpecialVariable();

  public final static StellaSpecialVariable $MONTH_STRINGS$ = new StellaSpecialVariable();

  public final static StellaSpecialVariable $ZONE_STRINGS$ = new StellaSpecialVariable();

  public final static StellaSpecialVariable $ERA_STRINGS$ = new StellaSpecialVariable();

  public final static StellaSpecialVariable $SPECIAL_STRINGS$ = new StellaSpecialVariable();

  public final static StellaSpecialVariable $SPECIAL_SYMBOLS$ = new StellaSpecialVariable();

  public static Symbol SYM_STELLA_YESTERDAY = null;

  public static Symbol SYM_STELLA_TODAY = null;

  public static Symbol SYM_STELLA_TOMORROW = null;

  public static Symbol SYM_STELLA_NOW = null;

  public static Symbol SYM_STELLA_BCE = null;

  public static Symbol SYM_STELLA_CE = null;

  public final static StellaSpecialVariable $DATE_TIME_PATTERNS$ = new StellaSpecialVariable();

  public static Symbol SYM_STELLA_YEAR = null;

  public static Symbol SYM_STELLA_DATE_DIVIDER = null;

  public static Symbol SYM_STELLA_MONTH = null;

  public static Symbol SYM_STELLA_DAY = null;

  public static Symbol SYM_STELLA_NOON_MIDN = null;

  public static Symbol SYM_STELLA_WEEKDAY = null;

  public static Symbol SYM_STELLA_DATE_TIME_DIVIDER = null;

  public static Symbol SYM_STELLA_HOUR = null;

  public static Symbol SYM_STELLA_TIME_DIVIDER = null;

  public static Symbol SYM_STELLA_MINUTE = null;

  public static Symbol SYM_STELLA_SECONDP = null;

  public static Symbol SYM_STELLA_AM_PM = null;

  public static Symbol SYM_STELLA_ZONE = null;

  public static Symbol SYM_STELLA_ZONE_MINUTE = null;

  public static Symbol SYM_STELLA_AM = null;

  public static Symbol SYM_STELLA_PM = null;

  public static Symbol SYM_STELLA_NOON = null;

  public static Symbol SYM_STELLA_MIDN = null;

  public static Symbol SYM_STELLA_ERA = null;

  public static Symbol SYM_STELLA_STARTUP_DATE_TIME_PARSER = null;

  /** If <code>true</code>, always redefine classes, even if an
   *                   identical class exists
   */
  public static boolean $REDEFINE_IDENTICAL_CLASSESp$ = false;

  public static Keyword KWD_PUBLIC_SLOTS = null;

  public static Keyword KWD_SLOTS = null;

  public static Keyword KWD_PUBLIC_METHODS = null;

  public static Keyword KWD_METHODS = null;

  public static Symbol SYM_STELLA_SETTER = null;

  public static Keyword KWD_SETTERp = null;

  public static List $UNSUPPORTED_EXTERNAL_SLOT_OPTIONS$ = null;

  public static MethodSlot $DEFAULT_OPTION_HANDLER$ = null;

  public static Symbol SYM_STELLA_DEFAULT_OPTION_HANDLER = null;

  public static Symbol SYM_STELLA_STARTUP_STELLA_IN = null;

  public static Symbol SYM_STELLA_AS = null;

  public static Symbol SYM_STELLA_COMMA = null;

  public static Symbol SYM_STELLA_COLLECT = null;

  public static Symbol SYM_STELLA_PREFIX_FOREACH = null;

  public static Symbol SYM_STELLA_X = null;

  public static Symbol SYM_STELLA_WHERE = null;

  public static Symbol SYM_STELLA_INTO = null;

  public static Symbol SYM_STELLA_COLLECT_INTO = null;

  public static Symbol SYM_STELLA_EXISTS = null;

  public static Symbol SYM_STELLA_FORALL = null;

  public static Symbol SYM_STELLA_SOME = null;

  public static Surrogate SGT_STELLA_INTEGER_INTERVAL = null;

  public static Surrogate SGT_STELLA_ABSTRACT_ITERATOR = null;

  public static Symbol SYM_STELLA_ALLOCATE_ITERATOR = null;

  public static Surrogate SGT_STELLA_ARGUMENT_LIST = null;

  public static Surrogate SGT_STELLA_SEQUENCE_MIXIN = null;

  public static Symbol SYM_STELLA_THE_ARRAY = null;

  public static Symbol SYM_STELLA_NILp = null;

  public static Symbol SYM_STELLA_NEXTp = null;

  public static Symbol SYM_STELLA_ANY_VALUE = null;

  public static Symbol SYM_STELLA_ANY_KEY = null;

  public static boolean $AGGRESSIVELY_OPTIMIZE_INTERVAL_FOREACHp$ = false;

  public static Symbol SYM_STELLA_le = null;

  public static Symbol SYM_STELLA_OR = null;

  public static Symbol SYM_STELLA_1_ = null;

  public static Symbol SYM_STELLA__ = null;

  public static Symbol SYM_STELLA_l = null;

  public static Symbol SYM_STELLA_LENGTH = null;

  public static Symbol SYM_STELLA_NTH = null;

  public static Surrogate SGT_STELLA_ARGUMENT_LIST_ITERATOR = null;

  public static Symbol SYM_STELLA_SYS_CALL_METHOD = null;

  public static Symbol SYM_STELLA_ON = null;

  public static Symbol SYM_STELLA_EMPTYp = null;

  public static Symbol SYM_STELLA_ADD_CONS_TO_END_OF_CONS_LIST = null;

  public static Symbol SYM_STELLA_CONSp = null;

  public static Symbol SYM_STELLA_SYS_FOREACH = null;

  public static Symbol SYM_STELLA_BREAK = null;

  public static Symbol SYM_STELLA_ALWAYS = null;

  public static Symbol SYM_STELLA_STARTUP_FOREACH = null;

  /** List of available STELLA features.
   */
  public static List $AVAILABLE_STELLA_FEATURES$ = null;

  public static Keyword KWD_WARN_ABOUT_UNDEFINED_METHODS = null;

  public static Keyword KWD_WARN_ABOUT_MISSING_METHODS = null;

  public static Keyword KWD_SUPPRESS_WARNINGS = null;

  public static Keyword KWD_USE_HARDCODED_SYMBOLS = null;

  public static Keyword KWD_USE_COMMON_LISP_CONSES = null;

  public static Keyword KWD_USE_CPP_GARBAGE_COLLECTOR = null;

  public static Keyword KWD_MINIMIZE_JAVA_PREFIXES = null;

  public static Keyword KWD_TRANSLATE_WITH_COPYRIGHT_HEADER = null;

  public static Keyword KWD_SUPPORT_UNEXEC = null;

  /** List of currently enabled STELLA features.
   */
  public final static StellaSpecialVariable $CURRENT_STELLA_FEATURES$ = new StellaSpecialVariable();

  /** List of STELLA features enabled by default and after resetting them
   * with <code>resetStellaFeatures</code>.
   */
  public static List $DEFAULT_STELLA_FEATURES$ = null;

  public static List $TRACED_KEYWORDS$ = null;

  public static Symbol SYM_STELLA_MEMBp = null;

  public static Symbol SYM_STELLA_$TRACED_KEYWORDS$ = null;

  public static Symbol SYM_STELLA_PRINT = null;

  public static Symbol SYM_STELLA_FLUSH_OUTPUT = null;

  /** Integer between 0 and 3.  Higher levels call more
   * safety checks.
   */
  public final static StellaSpecialVariable $SAFETY$ = new StellaSpecialVariable();

  /** Integer between 0 and 3.  Higher levels generate more
   * code to aid debugging.
   */
  public final static StellaSpecialVariable $DEBUGLEVEL$ = new StellaSpecialVariable();

  /** Integer between 0 and 3.  Higher levels optimize for
   * greater execution speed.
   */
  public final static StellaSpecialVariable $OPTIMIZESPEEDLEVEL$ = new StellaSpecialVariable();

  /** Integer between 0 and 3.  Higher levels optimize for
   * less code size and memory consumption.
   */
  public final static StellaSpecialVariable $OPTIMIZESPACELEVEL$ = new StellaSpecialVariable();

  public static Surrogate SGT_STELLA_F_GET_QUOTED_TREE_MEMO_TABLE_000 = null;

  public static Surrogate SGT_STELLA_TRANSLATION_UNIT = null;

  public static Symbol SYM_STELLA_TU_HOME_MODULE = null;

  public static Symbol SYM_STELLA_THE_OBJECT = null;

  public static Symbol SYM_STELLA_CATEGORY = null;

  public static Symbol SYM_STELLA_ANNOTATION = null;

  public static Symbol SYM_STELLA_AUXILIARYp = null;

  public static Symbol SYM_STELLA_CODE_REGISTER = null;

  public static Symbol SYM_STELLA_TRANSLATION = null;

  public static Symbol SYM_STELLA_REFERENCED_GLOBALS = null;

  public static Symbol SYM_STELLA_CLASS = null;

  public static Symbol SYM_STELLA_METHOD = null;

  public static Symbol SYM_STELLA_GLOBAL_VARIABLE = null;

  /** List of objects representing partially walked
   * top-level definitions and auxiliary code.
   */
  public final static StellaSpecialVariable $TRANSLATIONUNITS$ = new StellaSpecialVariable();

  /** The translation unit currently operated on.
   */
  public final static StellaSpecialVariable $CURRENTTRANSLATIONUNIT$ = new StellaSpecialVariable();

  /** Indicates the current translation phase which is one of
   * :DEFINE, :FINALIZE, :WALK, or :TRANSLATE.
   */
  public final static StellaSpecialVariable $TRANSLATIONPHASE$ = new StellaSpecialVariable();

  /** The higher the level, the more progress annotations are
   * generated during the translation of Stella declarations.
   */
  public final static StellaSpecialVariable $TRANSLATIONVERBOSITYLEVEL$ = new StellaSpecialVariable();

  public final static StellaSpecialVariable $USEHARDCODEDSYMBOLSp$ = new StellaSpecialVariable();

  /** Specifies the current translator output language; either
   * :common-lisp, :idl, :java, :cpp, or :cpp-standalone.  The initial value
   * points to the native implementation language of this STELLA instance.
   */
  public final static StellaSpecialVariable $TRANSLATOROUTPUTLANGUAGE$ = new StellaSpecialVariable();

  public static Symbol SYM_STELLA_DEFCLASS = null;

  public static Symbol SYM_STELLA_DEFSLOT = null;

  public static Symbol SYM_STELLA_DEFOPERATOR = null;

  public static Symbol SYM_STELLA_DEFTYPE = null;

  public static Symbol SYM_STELLA_DEFMODULE = null;

  public static Symbol SYM_STELLA_DEFMACRO = null;

  public static Symbol SYM_STELLA_STARTUP_TIME_PROGN = null;

  public static Symbol SYM_STELLA_MODULE = null;

  public static Symbol SYM_STELLA_PRINT_METHOD = null;

  public static Symbol SYM_STELLA_SLOT = null;

  public static Keyword KWD_JAVA_STANDALONE = null;

  public static Keyword KWD_DEFINE = null;

  public static Keyword KWD_FINALIZE = null;

  public static Keyword KWD_WALK = null;

  public static Keyword KWD_TRANSLATE = null;

  /** Table mapping local variable names their declared types
   * (declared explicitly or implicitly).
   */
  public final static StellaSpecialVariable $LOCALVARIABLETYPETABLE$ = new StellaSpecialVariable();

  /** Contains the method or function being walked, or else <code>null</code>.
   */
  public final static StellaSpecialVariable $METHODBEINGWALKED$ = new StellaSpecialVariable();

  /** Indicates that one or more return statements have been found
   * during the walk of the current method.
   */
  public final static StellaSpecialVariable $FOUNDRETURNp$ = new StellaSpecialVariable();

  /** Bound to the target type for an expression currently walked.
   * Used instead of an extra argument to <code>walkATree</code>, since only a few types
   * of expressions need to know about their expected type (e.g., FUNCALL).
   */
  public final static StellaSpecialVariable $TARGETTYPE$ = new StellaSpecialVariable();

  /** Table that maps each prefix of a function-local gensym
   * to its own gensym counter and/or to related gensyms.
   */
  public final static StellaSpecialVariable $LOCALGENSYMTABLE$ = new StellaSpecialVariable();

  public final static StellaSpecialVariable $TRANSLATIONERRORS$ = new StellaSpecialVariable();

  public final static StellaSpecialVariable $TRANSLATIONWARNINGS$ = new StellaSpecialVariable();

  public final static StellaSpecialVariable $TRANSLATIONNOTES$ = new StellaSpecialVariable();

  public static Surrogate SGT_STELLA_TYPE_SPEC = null;

  /** The current log file to which function calls should be logged.
   * A non-NULL value indicates that function call logging is enabled.
   */
  public static OutputStream $FUNCTION_CALL_LOG_STREAM$ = null;

  /** Translation switch which indicates that methods should
   * be instrumented to log their calls to a file.
   */
  public static boolean $LOG_FUNCTION_CALLSp$ = false;

  public static Symbol SYM_STELLA_LOG_FUNCTION_CALL = null;

  public static Symbol SYM_STELLA_START_FUNCTION_CALL_LOGGING = null;

  public static Symbol SYM_STELLA_STOP_FUNCTION_CALL_LOGGING = null;

  public static Symbol SYM_STELLA_SET_CALL_LOG_BREAK_POINT = null;

  public static Symbol SYM_STELLA_BREAK_PROGRAM = null;

  public static Symbol SYM_STELLA_TERMINATE_PROGRAM = null;

  public static Symbol SYM_STELLA_PO = null;

  public static Symbol SYM_STELLA_g = null;

  public static Symbol SYM_STELLA_ge = null;

  public static Surrogate SGT_STELLA_LISP_CODE = null;

  public static Surrogate SGT_STELLA_NATIVE_OUTPUT_STREAM = null;

  public static Symbol SYM_STELLA_INLINE = null;

  public static int $LOG_BREAK_POINT_COUNTER$ = Stella.NULL_INTEGER;

  public static Surrogate SGT_STELLA_UNINITIALIZED = null;

  public static Keyword KWD_SECOND_CLASS = null;

  public static Keyword KWD_ALIAS = null;

  public static Symbol SYM_STELLA_ILLEGAL_EXPRESSION_FLAGGED_BY_THE_TRANSLATOR = null;

  public static Symbol SYM_STELLA_BAD_SYS = null;

  /** Table of pairs used by <code>wrapperValueType</code> and
   * <code>typeToWrappedType</code>.
   */
  public static Cons $WRAPPED_TYPE_TABLE$ = null;

  public static Surrogate SGT_STELLA_NUMBER = null;

  /** Table of triples used by <code>lookupCoersionMethod</code> to
   * locate a coersion method.
   */
  public static Cons $COERSION_TABLE$ = null;

  public static Symbol SYM_STELLA_INTEGER_TO_BOOLEAN_WRAPPER = null;

  public static Symbol SYM_STELLA_INTEGER_TO_BOOLEAN = null;

  public static Symbol SYM_STELLA_MUTABLE_STRING_TO_STRING = null;

  public static Symbol SYM_STELLA_STRING_TO_MUTABLE_STRING = null;

  public static Symbol SYM_STELLA_INTERN_SYMBOL = null;

  public static Symbol SYM_STELLA_CHARACTER_TO_STRING = null;

  public static Symbol SYM_STELLA_INLINE_UNWRAP_BOOLEAN = null;

  public static Symbol SYM_STELLA_NUMBER_WRAPPER_TO_FLOAT = null;

  public static Surrogate SGT_STELLA_NATIVE_INPUT_STREAM = null;

  public static Symbol SYM_STELLA_NATIVE_STREAM = null;

  public static Symbol SYM_STELLA_lXg = null;

  public static Surrogate SGT_STELLA_SINGLE_FLOAT = null;

  public static Symbol SYM_STELLA_IDENTITY = null;

  public static Surrogate SGT_STELLA_DOUBLE_FLOAT = null;

  public static Surrogate SGT_STELLA_SHORT_INTEGER = null;

  public static Surrogate SGT_STELLA_UNSIGNED_SHORT_INTEGER = null;

  public static Surrogate SGT_STELLA_UNSIGNED_LONG_INTEGER = null;

  public static Symbol SYM_STELLA_SYS_CALL_FUNCTION = null;

  public static Symbol SYM_STELLA_SYS_INLINE_CALL = null;

  public static Symbol SYM_STELLA_SAFE_CAST = null;

  public static Symbol SYM_STELLA_VOID_SYS = null;

  public static Symbol SYM_STELLA_SYS_SET_DEFAULT = null;

  public static Symbol SYM_STELLA_SLOT_VALUE_SETTER = null;

  public static Symbol SYM_STELLA_AREF = null;

  public static Symbol SYM_STELLA_AREF_SETTER = null;

  public static Symbol SYM_STELLA_WITH_PROCESS_LOCK = null;

  public static Symbol SYM_STELLA_VALUES = null;

  public static Symbol SYM_STELLA_SYS_SPECIAL = null;

  public static Symbol SYM_STELLA_MV_BIND = null;

  public static Symbol SYM_STELLA_CONTINUE = null;

  public static Symbol SYM_STELLA_SETOF = null;

  public static Symbol SYM_STELLA_SET_OF = null;

  public static Symbol SYM_STELLA_SELECT = null;

  public static Symbol SYM_STELLA_CHOOSE = null;

  public static Symbol SYM_STELLA_i = null;

  public static Symbol SYM_STELLA_$ = null;

  public static Symbol SYM_STELLA_s = null;

  public static Symbol SYM_STELLA_BQUOTE = null;

  public static Symbol SYM_STELLA_PRINT_NATIVE_STREAM = null;

  public static Symbol SYM_STELLA_ALLOCATE = null;

  public static Symbol SYM_STELLA_LOCAL_NEW = null;

  public static Symbol SYM_STELLA_FUNCALL = null;

  public static Symbol SYM_STELLA_SYS_CALL_FUNCTION_CODE = null;

  public static Symbol SYM_STELLA_SYS_CALL_METHOD_CODE = null;

  public static Symbol SYM_STELLA_EXCEPTION_CASE = null;

  public static Symbol SYM_STELLA_SYS_UNWIND_PROTECT = null;

  public static Symbol SYM_STELLA_SYS_SLOT_VALUE = null;

  public static Symbol SYM_STELLA_SYS_SLOT_VALUE_SETTER = null;

  public static Symbol SYM_STELLA_SYS_CALL_METHOD_SETTER = null;

  public static Symbol SYM_STELLA_SYS_NEW = null;

  public static HashTable $SYMBOL_REGISTRY$ = null;

  public static List $SYMBOL_SET$ = null;

  /** Name of file that is currently being translated.
   * A NULL value indicates an incremental translation.
   */
  public final static StellaSpecialVariable $CURRENTFILE$ = new StellaSpecialVariable();

  public static Keyword KWD_SYMBOLS = null;

  public static Symbol SYM_STELLA_INTERN_RIGID_SYMBOL_WRT_MODULE = null;

  public static Symbol SYM_STELLA_GET_STELLA_MODULE = null;

  public static Symbol SYM_STELLA_INTERN_SYMBOL_AT = null;

  public static Symbol SYM_STELLA_INTERN_SURROGATE_AT = null;

  public static Symbol SYM_STELLA_INTERN_KEYWORD_AT = null;

  public static Keyword KWD_INLINE_ARGUMENT = null;

  public static Keyword KWD_PLACE_WHERE_VRLET_WAS = null;

  public static Keyword KWD_PLACE_WHERE_LAST_EXPRESSION_WAS = null;

  public static Symbol SYM_STELLA_IT = null;

  public static Symbol SYM_STELLA_WRAPPEDVALUE = null;

  public static Symbol SYM_STELLA_DYNAMICSLOTS = null;

  public static Symbol SYM_STELLA_NEWVALUE = null;

  public static Symbol SYM_STELLA_FOUNDMATCHINGENTRYp = null;

  public static Symbol SYM_STELLA_KV_CONS = null;

  public static Symbol SYM_STELLA_OLDVALUE = null;

  public static Keyword KWD_DONT_INHERITp = null;

  public static Symbol SYM_STELLA_ACCESS_IN_CONTEXT = null;

  public static Symbol SYM_STELLA_HOME_CONTEXT = null;

  public static Keyword KWD_COPY_TO_CHILDRENp = null;

  public static Symbol SYM_STELLA_UPDATE_IN_CONTEXT = null;

  public static Symbol SYM_STELLA_CS_VALUEp = null;

  public static Symbol SYM_STELLA_VARIABLE_DECLARATION = null;

  public static Symbol SYM_STELLA_ILLEGAL_VARIABLE = null;

  /** Stack mirroring the current state of bound specials
   * with their associated old-value variables.
   */
  public final static StellaSpecialVariable $SPECIALVARIABLESTACK$ = new StellaSpecialVariable();

  /** <code>true</code> if using specials is enabled and legal.
   */
  public final static StellaSpecialVariable $SPECIALSENABLEDp$ = new StellaSpecialVariable();

  /** Number of specials bound at the most recent entry
   * to a LOOP/WHILE/FOREACH construct.
   */
  public final static StellaSpecialVariable $NOFSPECIALSATLOOPENTRY$ = new StellaSpecialVariable();

  public static Keyword KWD_UNBIND_WITH_DESTRUCTORS = null;

  public static Keyword KWD_UNWIND_PROTECT = null;

  public static Symbol SYM_STELLA_GENERALIZED_SYMBOL = null;

  /** Table of specialized type predicates for various types.
   * These predicates have to be used instead of <code>isaP</code>, since they also work
   * during bootstrap when only some class objects are defined.
   */
  public static Cons $TYPE_PREDICATE_TABLE$ = null;

  public static Symbol SYM_STELLA_BOOLEANp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OF_BOOLEANp = null;

  public static Symbol SYM_STELLA_INTEGERp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OF_INTEGERp = null;

  public static Symbol SYM_STELLA_LONG_INTEGERp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OF_LONG_INTEGERp = null;

  public static Symbol SYM_STELLA_FLOATp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OF_FLOATp = null;

  public static Symbol SYM_STELLA_STRINGp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OF_STRINGp = null;

  public static Symbol SYM_STELLA_CHARACTERp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OF_CHARACTERp = null;

  public static Symbol SYM_STELLA_WRAPPERp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OF_WRAPPERp = null;

  public static Symbol SYM_STELLA_VERBATIM_STRINGp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OF_VERBATIM_STRINGp = null;

  public static Symbol SYM_STELLA_SURROGATEp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OF_SURROGATEp = null;

  public static Surrogate SGT_STELLA_TYPE = null;

  public static Symbol SYM_STELLA_TYPEp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OF_TYPEp = null;

  public static Symbol SYM_STELLA_SYMBOLp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OF_SYMBOLp = null;

  public static Symbol SYM_STELLA_TRANSIENT_SYMBOLp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OF_TRANSIENT_SYMBOLp = null;

  public static Symbol SYM_STELLA_KEYWORDp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OF_KEYWORDp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OF_CONSp = null;

  public static Symbol SYM_STELLA_STELLA_CLASSp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OF_CLASSp = null;

  public static Symbol SYM_STELLA_STORAGE_SLOTp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OF_STORAGE_SLOTp = null;

  public static Symbol SYM_STELLA_METHOD_SLOTp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OF_METHOD_SLOTp = null;

  public static Symbol SYM_STELLA_ANCHORED_TYPE_SPECIFIERp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OF_ANCHORED_TYPE_SPECIFIERp = null;

  public static Symbol SYM_STELLA_PARAMETRIC_TYPE_SPECIFIERp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OF_PARAMETRIC_TYPE_SPECIFIERp = null;

  public static Symbol SYM_STELLA_ISAp = null;

  public static Symbol SYM_STELLA_SUBTYPE_OFp = null;

  public static Symbol SYM_STELLA_STRING_EQLp = null;

  public static Symbol SYM_STELLA_SAFE_PRIMARY_TYPE = null;

  public static Surrogate SGT_STELLA_PROCESS_LOCK_OBJECT = null;

  public static Symbol SYM_STELLA_EQL_TO_BOOLEANp = null;

  public static Symbol SYM_STELLA_EQL_TO_INTEGERp = null;

  public static Symbol SYM_STELLA_EQL_TO_LONG_INTEGERp = null;

  public static Symbol SYM_STELLA_EQL_TO_FLOATp = null;

  public static Symbol SYM_STELLA_EQL_TO_STRINGp = null;

  public static List $NUMERIC_TYPE_HIERARCHY$ = null;

  public static Symbol SYM_STELLA_GET_QUOTED_TREE = null;

  public static Symbol SYM_STELLA_CONS_LIST = null;

  public static Symbol SYM_STELLA_COPY_CONS_TREE = null;

  public static Symbol SYM_STELLA_CACHED_INLINABLE_METHOD_BODY = null;

  public final static StellaSpecialVariable $INLININGMETHODCALLp$ = new StellaSpecialVariable();

  public static Keyword KWD_INLINE_REFERENCES = null;

  public static Symbol SYM_STELLA_INLINE_CALL = null;

  public static Symbol SYM_STELLA_FORWARD_DECLARATIONp = null;

  public static Symbol SYM_STELLA_MAIN = null;

  public static Keyword KWD_EMBEDDED = null;

  public static Symbol SYM_STELLA_CLASS_AUXILIARY_METHODS = null;

  public static Symbol SYM_STELLA_AUXILIARY_METHOD_REASON = null;

  /** A keyword describing how mixin classes are handled in
   * single-inheritance target languages.  The legal values are
   * :FIRST-CLASS-WITH-METHOD, which means that variables of a mixin type
   * are legal and that slot access on a mixin type is facilitated by
   * inherited-down accessor methods and a catch-all method on OBJECT,
   * :FIRST-CLASS-WITH-TYPECASE which is similar but replaces the catch-all
   * method with a function using a TYPECASE, and :SECOND-CLASS, which
   * means that variables of a mixin type are illegal and no additional
   * accessors and catch-all methods are needed.
   */
  public static Keyword $MIXIN_IMPLEMENTATION_STYLE$ = null;

  public static Keyword KWD_FIRST_CLASS_WITH_TYPECASE = null;

  public static Symbol SYM_STELLA_PRINT_OBJECT = null;

  public static Symbol SYM_STELLA_STREAM = null;

  public static Symbol SYM_STELLA_NATIVE_OUTPUT_STREAM = null;

  public static Keyword KWD_CLASSES = null;

  public static Keyword KWD_FINALIZE_CLASSES = null;

  public static Symbol SYM_STELLA_FINALIZE_CLASSES = null;

  public static Keyword KWD_FINALIZE_METHODS = null;

  public static Symbol SYM_STELLA_FINALIZE_SLOTS = null;

  public static Symbol SYM_STELLA_CLEANUP_UNFINALIZED_CLASSES = null;

  public static Symbol SYM_STELLA_DEFINE_EXTERNAL_SLOT_FROM_STRINGIFIED_SOURCE = null;

  public static Keyword KWD_MACROp = null;

  public static Keyword KWD_GLOBALS = null;

  public static Symbol SYM_STELLA_DEFINE_STELLA_GLOBAL_VARIABLE_FROM_STRINGIFIED_SOURCE = null;

  public static Symbol SYM_STELLA_DEFINE_STELLA_TYPE_FROM_STRINGIFIED_SOURCE = null;

  public static Keyword KWD_FINAL = null;

  /** The maximum number of startup units that can be combined
   * into a single startup function (this avoids the construction of huge startup
   * functions that would cause too much stress for some wimpy compilers).
   */
  public static int $MAX_NUMBER_OF_STARTUP_UNITS$ = 60;

  public static Symbol SYM_STELLA_CURRENT_STARTUP_TIME_PHASEp = null;

  public static Keyword KWD_MODULES = null;

  public static Symbol SYM_STELLA_WITHIN_MODULE = null;

  public static Symbol SYM_STELLA_$STELLA_MODULE$ = null;

  public static Symbol SYM_STELLA_$STARTUP_TIME_PHASE$ = null;

  public static Symbol SYM_STELLA_LOOKUP_FUNCTION = null;

  public static Symbol SYM_STELLA_$BOOTSTRAP_LOCK$ = null;

  public static Surrogate SGT_STELLA_STELLA_ROOT_EXCEPTION = null;

  public static Symbol SYM_STELLA_SYS_SIGNAL = null;

  public static Symbol SYM_STELLA_SYS_HANDLER_CASE = null;

  public static Symbol SYM_STELLA_SYS_HANDLE_EXCEPTION = null;

  public static Keyword KWD_OTHERWISE = null;

  public static Symbol SYM_STELLA_INITIAL_ELEMENT = null;

  public static Surrogate SGT_STELLA_CODE = null;

  public static Surrogate SGT_STELLA_COMPOUND_TYPE_SPECIFIER = null;

  public static HashTable $NATIVE_NAME_TABLE$ = null;

  public static Symbol SYM_STELLA_EXPRESSION = null;

  public static Symbol SYM_STELLA_$IGNORETRANSLATIONERRORSp$ = null;

  public static Symbol SYM_STELLA_CL_INCREMENTALLY_TRANSLATE = null;

  public static Symbol SYM_STELLA_REGISTER_NATIVE_NAME = null;

  public static Symbol SYM_STELLA_METHOD_C_CALLABLEp = null;

  public static Symbol SYM_STELLA_METHOD_C_NAMESPACE_PREFIX = null;

  public static Symbol SYM_STELLA_$C_API_RESULT_BUFFER$ = null;

  public static Symbol SYM_STELLA_NATIVE_OBJECT_POINTER = null;

  public static Symbol SYM_STELLA_METHOD_THROWS_EXCEPTIONSp = null;

  public static Symbol SYM_STELLA_NATIVE_EXCEPTION = null;

  public static Symbol SYM_STELLA_E = null;

  public static Symbol SYM_STELLA_CALL_GLOBAL_EXCEPTION_HANDLER = null;

  public static Keyword KWD_C_CALLABLEp = null;

  /** Handler to handle exceptions caught within a c-callable function that throws exceptions.
   * If non-NULL the handler will be called with two string arguments: message and context.
   * This is intended primarily for language environments that can't directly catch native
   * exceptions (e.g., if we are in C or Python).
   */
  public static java.lang.reflect.Method $GLOBAL_EXCEPTION_HANDLER$ = null;

  /** Result buffer used to support temporary protection of garbage-collectable
   * objects when a C API function is called from a non-C environment (such as Python).
   */
  static Object $C_API_RESULT_BUFFER$ = null;

  public static Symbol SYM_STELLA_NTH_REST = null;

  public static Symbol SYM_STELLA_ARGUMENTS = null;

  public static Symbol SYM_STELLA_RESULT = null;

  public final static StellaSpecialVariable $EVALUATIONTREE$ = new StellaSpecialVariable();

  public final static StellaSpecialVariable $EVALUATIONPARENTTREE$ = new StellaSpecialVariable();

  public static Symbol SYM_STELLA_APPEND = null;

  public static Symbol SYM_STELLA_STARTUP_WALK = null;

  public static VerbatimStringWrapper $CL_TRUE_STRING_WRAPPER$ = null;

  public static VerbatimStringWrapper $CL_FALSE_STRING_WRAPPER$ = null;

  /** Mapping from STELLA operators to Common-Lisp operators.
   */
  public static KeyValueList $CL_OPERATOR_TABLE$ = null;

  public static Symbol SYM_STELLA_xe = null;

  public final static StellaSpecialVariable $NEEDEXPLICITRETURNp$ = new StellaSpecialVariable();

  public static Keyword KWD_CONTINUE = null;

  public static Symbol SYM_STELLA_rrVALUE = null;

  public static Symbol SYM_STELLA_rrREST = null;

  public static Symbol SYM_STELLA_CLSYS_SVAL = null;

  public static Symbol SYM_STELLA_NTH_SETTER = null;

  public static Symbol SYM_STELLA_NORMAL_CALL = null;

  public static Symbol SYM_STELLA_NON_OBJECT_METHOD = null;

  public static Symbol SYM_STELLA_OBJECT_METHOD = null;

  public static Symbol SYM_STELLA_CLSYS_CALL = null;

  public static Surrogate SGT_STELLA_NATIVE_VECTOR = null;

  public static Symbol SYM_STELLA_ARGUMENT = null;

  public static Symbol SYM_STELLA_NULL_ARRAYp = null;

  public static Symbol SYM_STELLA_$CONDITION_MESSAGE_KEYWORD$ = null;

  public static Symbol SYM_STELLA_REPLACE_SUBSTRINGS = null;

  public static Symbol SYM_STELLA_CLSYS_MAKE = null;

  public static Keyword KWD_INITIAL_ELEMENT = null;

  public static Symbol SYM_STELLA_rrPRINT_STREAM = null;

  public static Symbol SYM_STELLA_CLSYS_METHOD_CODE_CALL = null;

  public static Symbol SYM_STELLA_MACRO = null;

  public static Symbol SYM_STELLA_CLSYS_SELF = null;

  public static Symbol SYM_STELLA_CLSYS_DUMMY = null;

  public static Symbol SYM_STELLA_rrDEFCONSMETHOD = null;

  public static Symbol SYM_STELLA_rrDEFINTEGERMETHOD = null;

  public static Symbol SYM_STELLA_$CLSYS_SELF$ = null;

  public static Keyword KWD_VOID = null;

  public static Keyword KWD_INITFORM = null;

  public static Keyword KWD_ACCESSOR = null;

  public static Symbol SYM_STELLA_CLSYS_ROOT_OBJECT = null;

  public static Symbol SYM_STELLA_CLSYS_ROOT_STRUCT = null;

  public static Keyword KWD_CONC_NAME = null;

  public static Keyword KWD_CONSTRUCTOR = null;

  public static Keyword KWD_COPIER = null;

  public static Keyword KWD_PREDICATE = null;

  public static Symbol SYM_STELLA_ = null;

  public static Keyword KWD_INCLUDE = null;

  public static Symbol SYM_STELLA_STARTUP_CL_TRANSLATE = null;

  public static Keyword KWD_LISP = null;

  public static Keyword KWD_STELLA = null;

  public static Keyword KWD_TWO_PASSp = null;

  public static Keyword KWD_FORCE_TRANSLATIONp = null;

  public static Keyword KWD_PRODUCTION_SETTINGSp = null;

  public static Keyword KWD_LISP_BINARY = null;

  public static Symbol SYM_STELLA_STARTUP_CL_TRANSLATE_FILE = null;

  public static Symbol SYM_STELLA_DYNAMIC_SLOT_VALUE = null;

  public static Symbol SYM_STELLA_STARTUP_DYNAMIC_SLOTS = null;

  public static Symbol SYM_STELLA_STARTUP_DYNAMIC_LITERAL_SLOTS = null;

  /** Controls actions reflexive transitive closure of
   *    subcontexts when a context is revised.
   *    Values are ':destroy' -- destroy subcontexts;
   *    ':clear' -- clear contents of subcontexts;
   *    ':preserve' -- don't disturb subcontexts.
   */
  public static Keyword $SUBCONTEXT_REVISION_POLICY$ = null;

  public static Keyword KWD_CLEAR = null;

  public static Surrogate SGT_STELLA_F_GET_STELLA_MODULE_MEMO_TABLE_000 = null;

  /** Holds list of symbols representing surrogates
   * to be shadowed during module finalization.
   */
  public final static StellaSpecialVariable $SHADOWEDSURROGATES$ = new StellaSpecialVariable();

  public static Keyword KWD_MODULE_UPDATE = null;

  public static Keyword KWD_INCLUDES = null;

  public static Keyword KWD_USES = null;

  public static Keyword KWD_SHADOW = null;

  public static Keyword KWD_CASE_SENSITIVEp = null;

  public static Keyword KWD_APIp = null;

  public static Symbol SYM_STELLA_APIp = null;

  public static Keyword KWD_LISP_PACKAGE = null;

  public static Keyword KWD_CPP_PACKAGE = null;

  public static Keyword KWD_JAVA_PACKAGE = null;

  public static Keyword KWD_JAVA_CATCHALL_CLASS = null;

  public static Symbol SYM_STELLA_JAVA_FLOTSAM_CLASS = null;

  public static Keyword KWD_NICKNAME = null;

  public static Keyword KWD_CLEARABLEp = null;

  public static Keyword KWD_PROTECT_SURROGATESp = null;

  public static Keyword KWD_CODE_ONLYp = null;

  public static Keyword KWD_NAMESPACEp = null;

  public static Symbol SYM_STELLA_NAMESPACEp = null;

  public static Keyword KWD_REQUIRES = null;

  public static Keyword KWD_DESTROY = null;

  public static Keyword KWD_PREORDER = null;

  /** HOOK-LIST called by 'define-module', applied to a
   * 'module' argument.
   */
  public static HookList $DEFINE_MODULE_HOOKS$ = null;

  /** List of non-structural options for Module definitions.
   * Used in testing for module changes and in updating non-structurally changed
   * modules.
   */
  static Cons $MODULE_NON_STRUCTURAL_OPTIONS$ = null;

  public static Keyword KWD_TOPDOWN = null;

  public static Symbol SYM_STELLA_DEFINE_MODULE_FROM_STRINGIFIED_SOURCE = null;

  public static Keyword KWD_POSTORDER = null;

  public static Keyword KWD_INORDER = null;

  public static Surrogate SGT_STELLA_F_VISIBLE_MODULES_MEMO_TABLE_000 = null;

  public static Symbol SYM_STELLA_STARTUP_MODULES = null;

  /** Eliminate pointers to discarded contexts while
   * accessing a CS-VALUE context table.
   */
  public static boolean $UNLINK_DISCARDED_CONTEXTS_ON_READp$ = true;

  /** Eliminate pointers to discarded contexts while
   * inserting into a CS-VALUE context table.
   */
  public static boolean $UNLINK_DISCARDED_CONTEXTS_ON_WRITEp$ = true;

  /** If true, indicates that contexts are being allocated
   * and deallocated in depth-first fashion, and that deallocation of
   * CS-VALUE entries is taken care of during context destruction.
   */
  public static boolean $CONTEXT_BACKTRACKING_MODE$ = false;

  public static Symbol SYM_STELLA_STARTUP_CONTEXTS = null;

  public static Surrogate SGT_STELLA_TOKENIZER_TABLE = null;

  public static Symbol SYM_STELLA_TRANSITIONS = null;

  public static Symbol SYM_STELLA_UNIQUE_STATE_NAMES = null;

  public static Symbol SYM_STELLA_STATE_NAMES = null;

  public static Symbol SYM_STELLA_LEGAL_EOF_STATES = null;

  public static int $MAX_TOKENIZER_STATES$ = 64;

  public static int $MAX_TOKENIZER_CHARACTERS$ = 256;

  public static Symbol SYM_STELLA_CHARACTER_SET = null;

  public static Keyword KWD_START = null;

  public static Keyword KWD_EOF = null;

  public static int $TOKENIZER_INITIAL_BUFFER_SIZE$ = 2048;

  public static Keyword KWD_CHARACTER = null;

  public static Surrogate SGT_STELLA_TOKENIZER_TOKEN = null;

  public static Symbol SYM_STELLA_CONTENT = null;

  public static Symbol SYM_STELLA_NEXT = null;

  public static Surrogate SGT_STELLA_TOKENIZER_STREAM_STATE = null;

  public static Symbol SYM_STELLA_BUFFER_SIZE = null;

  public static Symbol SYM_STELLA_TABLE = null;

  public static Symbol SYM_STELLA_STATE_DICTIONARY = null;

  public static Symbol SYM_STELLA_TOKEN_LIST = null;

  public final static StellaSpecialVariable $WITHTOKENIZERINPUTTYPE$ = new StellaSpecialVariable();

  public static Symbol SYM_STELLA_TOK_TABLE_ = null;

  public static Symbol SYM_STELLA_TOK_TRANSITIONS_ = null;

  public static Symbol SYM_STELLA_TOK_STATENAMES_ = null;

  public static Symbol SYM_STELLA_TOK_TOKENSTART_ = null;

  public static Symbol SYM_STELLA_TOK_ENDOFTOKENSp_ = null;

  public static Symbol SYM_STELLA_TOK_STREAMSTATE_ = null;

  public static Symbol SYM_STELLA_TOKENIZER_STREAM_STATE = null;

  public static Symbol SYM_STELLA_TOK_BUFFER_ = null;

  public static Symbol SYM_STELLA_STRING_TO_TOKENIZER_BYTE_ARRAY = null;

  public static Symbol SYM_STELLA_TOK_STATE_ = null;

  public static Symbol SYM_STELLA_TOK_NEXTSTATE_ = null;

  public static Symbol SYM_STELLA_TOK_CURSOR_ = null;

  public static Symbol SYM_STELLA_TOK_SIZE_ = null;

  public static Symbol SYM_STELLA_TOK_END_ = null;

  public static Symbol SYM_STELLA_TOK_INPUTSTREAM_ = null;

  public static Symbol SYM_STELLA_TOK_ECHOSTREAM_ = null;

  public static Symbol SYM_STELLA_BUFFER = null;

  public static Symbol SYM_STELLA_GET_SAVED_STATE = null;

  public static Symbol SYM_STELLA_TOK_CHECKPOINT_ = null;

  public static Symbol SYM_STELLA_END_OF_TOKENSp = null;

  public static Symbol SYM_STELLA_GET_TOKEN_TEXT = null;

  public static Symbol SYM_STELLA_GET_TOKEN_TEXT_INTERNAL = null;

  public static Symbol SYM_STELLA_GET_TOKEN_TYPE = null;

  public static boolean $TRACE_GET_NEXT_TOKENp$ = false;

  public static Symbol SYM_STELLA_GET_NEXT_TOKEN = null;

  public static Symbol SYM_STELLA_SAVE_TOKENIZER_STREAM_STATE = null;

  public static Symbol SYM_STELLA_CHARACTER_CODE = null;

  public static Symbol SYM_STELLA_BYTE_ARRAY_NTH = null;

  public static Symbol SYM_STELLA_IF_OUTPUT_LANGUAGE = null;

  public static Symbol SYM_STELLA_LOGOR = null;

  public static Symbol SYM_STELLA_SHIFT_LEFT = null;

  public static Symbol SYM_STELLA_LOGAND = null;

  public static Symbol SYM_STELLA_READ_INTO_TOKENIZER_BUFFER = null;

  public static Symbol SYM_STELLA_MOD = null;

  public static Surrogate SGT_STELLA_STREAM_TOKENIZER = null;

  public static Cons $STELLA_TOKENIZER_TABLE_DEFINITION$ = null;

  public static Keyword KWD_ATOM = null;

  public static Keyword KWD_OPEN_PAREN = null;

  public static Keyword KWD_CLOSE_PAREN = null;

  public static Keyword KWD_OPEN_STRING = null;

  public static Keyword KWD_STRING = null;

  public static Keyword KWD_SINGLE_QUOTE = null;

  public static Keyword KWD_BACK_QUOTE = null;

  public static Keyword KWD_COMMA = null;

  public static Symbol SYM_STELLA_x = null;

  public static Keyword KWD_COMMENT = null;

  public static Keyword KWD_HASH = null;

  public static Keyword KWD_PAREN_COMMENT = null;

  public static Keyword KWD_PAREN_COMMENT_ESCAPE = null;

  public static Keyword KWD_PAREN_COMMENT_BAR = null;

  public static Keyword KWD_ANY = null;

  public static Keyword KWD_COMMA_SPLICE = null;

  public static Keyword KWD_SYMBOL_OR_SIGNED_NUMBER = null;

  public static Keyword KWD_SYMBOL_OR_NUMBER = null;

  public static Keyword KWD_INTEGER = null;

  public static Keyword KWD_SYMBOL_OR_CL_SYMBOL = null;

  public static Keyword KWD_OPEN_FULLY_ESCAPED_SYMBOL = null;

  public static Keyword KWD_FULLY_ESCAPED_SYMBOL = null;

  public static Keyword KWD_ESCAPED_SYMBOL_ESCAPE = null;

  public static Keyword KWD_QUALIFIED_NAME = null;

  public static Keyword KWD_OPEN_KEYWORD = null;

  public static Keyword KWD_OPEN_SURROGATE = null;

  public static Keyword KWD_CLOSE_STRING = null;

  public static Keyword KWD_STRING_ESCAPE = null;

  public static Keyword KWD_ESCAPED_STRING = null;

  public static Keyword KWD_CHARACTER_CONSTANT = null;

  public static Keyword KWD_SYMBOL_OR_MANTISSA = null;

  public static Keyword KWD_SYMBOL_OR_MANTISSA2 = null;

  public static Keyword KWD_FLOAT = null;

  public static Keyword KWD_SYMBOL_OR_EXPONENT_DELIMITER = null;

  public static Keyword KWD_SYMBOL_OR_EXPONENT = null;

  public static Keyword KWD_SYMBOL_OR_EXPONENT2 = null;

  public static Keyword KWD_SYMBOL_OR_CL_SYMBOL2 = null;

  public static Keyword KWD_SYMBOL_OR_CL_SYMBOL3 = null;

  public static Keyword KWD_CL_SYMBOL = null;

  public static Keyword KWD_ESCAPED_SYMBOL = null;

  public static Keyword KWD_CLOSE_FULLY_ESCAPED_NAME = null;

  public static Keyword KWD_FULLY_ESCAPED_SYMBOL_ESCAPE = null;

  public static Keyword KWD_FULLY_ESCAPED_KEYWORD = null;

  public static Keyword KWD_ESCAPED_KEYWORD_ESCAPE = null;

  public static Keyword KWD_ESCAPED_KEYWORD = null;

  public static Keyword KWD_FULLY_ESCAPED_KEYWORD_ESCAPE = null;

  public static Keyword KWD_FULLY_ESCAPED_SURROGATE = null;

  public static Keyword KWD_ESCAPED_SURROGATE_ESCAPE = null;

  public static Keyword KWD_ESCAPED_SURROGATE = null;

  public static Keyword KWD_FULLY_ESCAPED_SURROGATE_ESCAPE = null;

  public static Keyword KWD_QUALIFIED_SURROGATE = null;

  public static Keyword KWD_QUALIFIED_ESCAPED_SYMBOL_ESCAPE = null;

  public static Keyword KWD_QUALIFIED_FULLY_ESCAPED_SYMBOL = null;

  public static Keyword KWD_QUALIFIED_SYMBOL = null;

  public static Keyword KWD_QUALIFIED_ESCAPED_SURROGATE_ESCAPE = null;

  public static Keyword KWD_QUALIFIED_FULLY_ESCAPED_SURROGATE = null;

  public static Keyword KWD_QUALIFIED_ESCAPED_SYMBOL = null;

  public static Keyword KWD_QUALIFIED_ESCAPED_SURROGATE = null;

  public static Keyword KWD_QUALIFIED_FULLY_ESCAPED_SYMBOL_ESCAPE = null;

  public static Keyword KWD_QUALIFIED_FULLY_ESCAPED_SURROGATE_ESCAPE = null;

  public static TokenizerTable $STELLA_TOKENIZER_TABLE$ = null;

  public static Vector $STELLA_LOGICAL_STATE_NAMES$ = null;

  public static PropertyList $STELLA_LOGICAL_STATE_NAMES_TABLE$ = null;

  public static Keyword KWD_CLOSE_BALANCED_QUOTE = null;

  public static Symbol SYM_STELLA_WITH_TOKENIZER = null;

  public static Symbol SYM_STELLA_$STELLA_TOKENIZER_TABLE$ = null;

  public static Symbol SYM_STELLA_TOK_STELLALOGICALSTATENAMES_ = null;

  public static Symbol SYM_STELLA_$STELLA_LOGICAL_STATE_NAMES$ = null;

  public static Symbol SYM_STELLA_TOK_STELLALOGICALSTATENAME_ = null;

  public static Symbol SYM_STELLA_KEYWORD = null;

  public static Symbol SYM_STELLA_GET_QUALIFIED_SYMBOL_SEPARATOR_POSITION_INTERNAL = null;

  public static Keyword KWD_FULLY_ESCAPED = null;

  public static Symbol SYM_STELLA_GET_TOKEN_INTEGER = null;

  public static Symbol SYM_STELLA_GET_TOKEN_INTEGER_INTERNAL = null;

  public static int $GET_TOKEN_INTEGER_CHECKPOINT$ = Stella.NULL_INTEGER;

  public static Symbol SYM_STELLA_GET_TOKEN_LONG_INTEGER = null;

  public static Symbol SYM_STELLA_GET_TOKEN_LONG_INTEGER_INTERNAL = null;

  public static long $GET_TOKEN_LONG_INTEGER_CHECKPOINT$ = Stella.NULL_LONG_INTEGER;

  public static Symbol SYM_STELLA_GET_TOKEN_FLOAT = null;

  public static Symbol SYM_STELLA_GET_TOKEN_FLOAT_INTERNAL = null;

  public static Surrogate SGT_STELLA_STELLA_TOKEN = null;

  public static Symbol SYM_STELLA_LOGICAL_TOKEN_TYPE = null;

  public static Symbol SYM_STELLA_ESCAPE_MODE = null;

  public static Keyword KWD_FULL = null;

  public static Keyword KWD_PARTIAL = null;

  public static Keyword KWD_TEXT = null;

  public static Keyword KWD_PUNCTUATION = null;

  public static Keyword KWD_QUOTE = null;

  public static Surrogate SGT_STELLA_F_TOKENIZE_STRING_MEMO_TABLE_000 = null;

  public static int $STELLA_TOKENIZER_WHITE_SPACE_STATE$ = Stella.NULL_INTEGER;

  static Cons $READ_LINE_TOKENIZER_TABLE_DEFINITION$ = null;

  public static Keyword KWD_INITIAL_LINEFEED = null;

  public static Keyword KWD_INITIAL_RETURN = null;

  public static Keyword KWD_LINEFEED = null;

  public static Keyword KWD_RETURN = null;

  static Cons $READ_LINE2_TOKENIZER_TABLE_DEFINITION$ = null;

  public static Keyword KWD_RETURN_LINEFEED = null;

  static TokenizerTable $READ_LINE_TOKENIZER_TABLE$ = null;

  static TokenizerTable $READ_LINE2_TOKENIZER_TABLE$ = null;

  public static Keyword KWD_LF = null;

  public static Keyword KWD_CRLF = null;

  public static Keyword KWD_CR = null;

  /** Controls the behavior of interactive queries.  The default is :ASK
   * which asks the user.  Other options are :YES, :NO, :YES-VERBOSE, :NO-VERBOSE.  These
   * return the answer indicated, with the verbose versions printing the message and answer.
   */
  public final static StellaSpecialVariable $USER_QUERY_ACTION$ = new StellaSpecialVariable();

  public static Keyword KWD_ASK = null;

  public static Keyword KWD_YES = null;

  public static Keyword KWD_NO = null;

  public static Keyword KWD_YES_VERBOSE = null;

  public static Keyword KWD_NO_VERBOSE = null;

  public static Symbol SYM_STELLA_STARTUP_READ = null;

  public final static String $XML_URN$ = "http://www.w3.org/XML/1998/namespaces";

  public final static String $HTML_V4_0_URN$ = "http://www.w3.org/TR/REC-html40";

  public static Surrogate SGT_STELLA_XML_OBJECT = null;

  public static Symbol SYM_STELLA_SURFACE_FORM = null;

  public static Surrogate SGT_STELLA_XML_ELEMENT = null;

  public static Symbol SYM_STELLA_NAMESPACE_NAME = null;

  public static Symbol SYM_STELLA_NAMESPACE_URI = null;

  public static Symbol SYM_STELLA_ELEMENT_DICTIONARY = null;

  public static Surrogate SGT_STELLA_XML_LOCAL_ATTRIBUTE = null;

  public static Symbol SYM_STELLA_PARENT_ELEMENT = null;

  public static Surrogate SGT_STELLA_XML_GLOBAL_ATTRIBUTE = null;

  public static Surrogate SGT_STELLA_XML_PROCESSING_INSTRUCTION = null;

  public static Symbol SYM_STELLA_DATA = null;

  public static Surrogate SGT_STELLA_XML_DECLARATION = null;

  public static Surrogate SGT_STELLA_XML_DOCTYPE_DECLARATION = null;

  public static Surrogate SGT_STELLA_XML_SPECIAL = null;

  public static Surrogate SGT_STELLA_XML_COMMENT = null;

  public static Surrogate SGT_STELLA_XML_DOCTYPE = null;

  public static Symbol SYM_STELLA_ENTITY_TABLE = null;

  public static Symbol SYM_STELLA_PARAMETER_ENTITY_TABLE = null;

  /** Hash Table for interning XML elements that don't appear in any namespace.
   */
  public static StringHashTable $XML_ELEMENT_NULL_NAMESPACE_TABLE$ = null;

  /** Hash Table mapping URI's (for namespaces) to a Hash Table
   * for interning XML elements.
   */
  public static StringHashTable $XML_ELEMENT_HASH_TABLE$ = null;

  /** Hash Table mapping URI's (for namespaces) to a Hash Table
   * for interning XML global attributes.
   */
  public static StringHashTable $XML_GLOBAL_ATTRIBUTE_HASH_TABLE$ = null;

  public static KeyValueList $XML_BASE_ENTITY_TABLE$ = null;

  public static Cons $XML_TOKENIZER_TABLE_DEFINITION$ = null;

  public static Keyword KWD_SKIP_WHITESPACE = null;

  public static Keyword KWD_OPEN_TAG = null;

  public static Keyword KWD_CONTENT = null;

  public static Keyword KWD_START_TAG_END = null;

  public static Keyword KWD_OPEN_END_TAG = null;

  public static Keyword KWD_OPEN_PI_TAG = null;

  public static Keyword KWD_OPEN_DECLARATION_TAG = null;

  public static Keyword KWD_START_TAG = null;

  public static Keyword KWD_OPEN_EMPTY_TAG_END = null;

  public static Keyword KWD_SKIP_TO_ATTRIBUTE_NAME = null;

  public static Keyword KWD_START_PI_TAG = null;

  public static Keyword KWD_OPEN_PI_TAG_END = null;

  public static Keyword KWD_PI_TAG_DATA = null;

  public static Keyword KWD_PI_TAG_DATA_OR_END = null;

  public static Keyword KWD_EMPTY_TAG_END = null;

  public static Keyword KWD_END_TAG_END = null;

  public static Keyword KWD_END_TAG = null;

  public static Keyword KWD_ATTRIBUTE_NAME = null;

  public static Keyword KWD_SKIP_TO_ATTRIBUTE_VALUE = null;

  public static Keyword KWD_SINGLE_QUOTED_ATTRIBUTE_VALUE = null;

  public static Keyword KWD_DOUBLE_QUOTED_ATTRIBUTE_VALUE = null;

  public static Keyword KWD_UNQUOTED_ATTRIBUTE_VALUE = null;

  public static Keyword KWD_QUOTED_ATTRIBUTE_VALUE = null;

  public static Keyword KWD_START_TAG_OR_COMMENT = null;

  public static Keyword KWD_OPEN_SPECIAL_TAG = null;

  public static Keyword KWD_START_DECLARATION_TAG = null;

  public static Keyword KWD_DECLARATION_WHITESPACE = null;

  public static Keyword KWD_DECLARATION_TAG_MARKUP_DATA_START = null;

  public static Keyword KWD_SINGLE_QUOTED_DECLARATION_TAG_DATA = null;

  public static Keyword KWD_DOUBLE_QUOTED_DECLARATION_TAG_DATA = null;

  public static Keyword KWD_DECLARATION_TAG_DATA = null;

  public static Keyword KWD_QUOTED_DECLARATION_TAG_DATA = null;

  public static Keyword KWD_DECLARATION_TAG_MARKUP_DATA = null;

  public static Keyword KWD_START_SPECIAL_TAG = null;

  public static Keyword KWD_SPECIAL_TAG_DATA = null;

  public static Keyword KWD_SPECIAL_TAG_DATA_OR_END = null;

  public static Keyword KWD_SPECIAL_TAG_DATA_OR_END2 = null;

  public static Keyword KWD_DATA_TAG_END = null;

  public static Keyword KWD_COMMENT_BODY = null;

  public static Keyword KWD_END_COMMENT_OR_COMMENT = null;

  public static Keyword KWD_END_COMMENT_OR_COMMENT2 = null;

  public static TokenizerTable $XML_TOKENIZER_TABLE$ = null;

  /** If true, all whitespace between tags (newlines, trailing WP, etc.)
   * will be preserved.  This is a kludge to allow us to read certain <code>illegal</code> XML files
   * where this whitespace is significant but not appropriately encoded.
   */
  public final static StellaSpecialVariable $XML_PRESERVE_ALL_WHITESPACEp$ = new StellaSpecialVariable();

  public static TokenizerTable $XML_WHITESPACE_PRESERVING_TOKENIZER_TABLE$ = null;

  public static Keyword KWD_ATTRIBUTE_VALUE = null;

  public static Surrogate SGT_STELLA_XML_EXPRESSION_ITERATOR = null;

  public static Symbol SYM_STELLA_REGION_TAG = null;

  public static Symbol SYM_STELLA_REGION_MATCH_FUNCTION = null;

  public static Symbol SYM_STELLA_DOCTYPE = null;

  public static Symbol SYM_STELLA_DOCTYPE_ITERATORp = null;

  public static Surrogate SGT_STELLA_XML_ATTRIBUTE = null;

  public static Symbol SYM_STELLA_XML_ELEMENT_MATCHp = null;

  public static Symbol SYM_STELLA_XML_ELEMENT = null;

  public static Symbol SYM_STELLA_STARTUP_XML = null;

  public static Symbol SYM_STELLA_MEMBERp = null;

  public static Symbol SYM_STELLA_FIRST_DEFINED = null;

  public static Symbol SYM_STELLA_$TRANSIENTOBJECTSp$ = null;

  public static Symbol SYM_STELLA_$CONTEXT$ = null;

  public static Symbol SYM_STELLA_SAFETY = null;

  public static Symbol SYM_STELLA_WORLD = null;

  public static Symbol SYM_STELLA_$MODULE$ = null;

  public static Symbol SYM_STELLA_$CURRENTSYSTEMDEFINITION$ = null;

  public static Symbol SYM_STELLA_GET_SYSTEM_DEFINITION = null;

  public static Symbol SYM_STELLA_$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$ = null;

  public static Symbol SYM_STELLA_ONLY_IF = null;

  public static Symbol SYM_STELLA_WARN = null;

  public static Keyword KWD_STARTUP_SYSTEMp = null;

  public static Symbol SYM_STELLA_IF_STELLA_FEATURE = null;

  public static Symbol SYM_STELLA_INTEGER = null;

  public static Symbol SYM_STELLA_ARRAY = null;

  public static Symbol SYM_STELLA_rrARGS = null;

  public static Keyword KWD_INITIAL_CONTENTS = null;

  public static Symbol SYM_STELLA_STARTUP_MACROS = null;

  public static Surrogate SGT_STELLA_MEMOIZATION_TABLE = null;

  public static Symbol SYM_STELLA_HASH_TABLE = null;

  public static Symbol SYM_STELLA_TABLE_NAME = null;

  public static Symbol SYM_STELLA_CURRENT_TIMESTAMP = null;

  public static Symbol SYM_STELLA_TIMESTAMPS = null;

  /** Holds all currently active memoization tables for timestamp
   * maintenance and clearance purposes.
   */
  public static List $ALL_MEMOIZATION_TABLES$ = null;

  public static boolean $MEMOIZATION_ENABLEDp$ = false;

  /** Used by memoization to indicate that a NULL value
   * was cached.  Needed to distinguish between an undefined value and a
   * cached NULL.
   */
  public static Symbol MEMOIZED_NULL_VALUE = null;

  public static int $TOTAL_MEMOIZATION_LOOKUPS$ = 0;

  public static int $FAILED_MEMOIZATION_LOOKUPS$ = 0;

  public static Surrogate SGT_STELLA_MRU_MEMOIZATION_TABLE = null;

  public static Symbol SYM_STELLA_MRU_BUCKETS_VECTOR = null;

  public static Symbol SYM_STELLA_LRU_BUCKETS_VECTOR = null;

  public static Symbol SYM_STELLA_MRU_TIMESTAMP = null;

  public static Symbol SYM_STELLA_LRU_TIMESTAMP = null;

  public static Symbol SYM_STELLA_NOF_BUCKETS = null;

  public static Symbol SYM_STELLA_FREE_ENTRIES = null;

  public static Symbol SYM_STELLA_MAX_ENTRIES = null;

  public static Keyword KWD_MAX_VALUES = null;

  public static Keyword KWD_TIMESTAMPS = null;

  public static Keyword KWD_NAME = null;

  public static Symbol SYM_STELLA_LOOKUP_MEMOIZED_VALUE = null;

  public static Symbol SYM_STELLA_LOOKUP_MEMOIZED_VALUEN = null;

  public static Symbol SYM_STELLA_LOOKUP_MRU_MEMOIZED_VALUE = null;

  public static Symbol SYM_STELLA_LOOKUP_MRU_MEMOIZED_VALUEN = null;

  public static Symbol SYM_STELLA_MEMOIZED_NULL_VALUE = null;

  public static Symbol SYM_STELLA_MEMOIZATION_TABLE = null;

  public static Symbol SYM_STELLA_$MEMOIZATION_ENABLEDp$ = null;

  public static Symbol SYM_STELLA_INITIALIZE_MEMOIZATION_TABLE = null;

  public static Surrogate SGT_STELLA_MEMOIZABLE_ITERATOR = null;

  public static Symbol SYM_STELLA_BASE_ITERATOR = null;

  public static Symbol SYM_STELLA_ITERATOR_AND_VALUES = null;

  public static Symbol SYM_STELLA_STARTUP_MEMOIZE = null;

  /** Table containing all active and inactive demons, indexed
   * on their names.
   */
  public static StringHashTable $DEMONS_TABLE$ = null;

  /** These demons trigger every time an active instance is created.
   */
  public static List $CONSTRUCTOR_DEMONS$ = null;

  /** These demons trigger every time an active instance is destroyed.
   */
  public static List $DESTRUCTOR_DEMONS$ = null;

  /** These demons trigger every time a slot value is modified.
   */
  public static List $ALL_SLOTS_DEMONS$ = null;

  /** These demons trigger every time a slot value is modified, and
   * cancel slot update when they return <code>false</code>.
   */
  public static List $ALL_SLOTS_GUARD_DEMONS$ = null;

  public static Keyword KWD_MODIFY = null;

  public static Keyword KWD_ALL = null;

  public static Keyword KWD_SLOT = null;

  public static Keyword KWD_CODE = null;

  public static Keyword KWD_GUARDp = null;

  public static Keyword KWD_INHERITEDp = null;

  public static Keyword KWD_ACTIVATEp = null;

  public static Symbol SYM_STELLA_DEFINE_DEMON = null;

  public static Symbol SYM_STELLA_OWNER_INSTANCE = null;

  public static Symbol SYM_STELLA_ACTIVE_SLOT = null;

  public static Symbol SYM_STELLA_GET_SLOT = null;

  public static Symbol SYM_STELLA_CANT_OVERWRITE_ACTIVE_COLLECTION_SLOT = null;

  public static Symbol SYM_STELLA_CHECK_FOR_SLOT_DEMONSp = null;

  public static Symbol SYM_STELLA_WRAPPEDOLDVALUE = null;

  public static Symbol SYM_STELLA_WRAPPEDNEWVALUE = null;

  public static Symbol SYM_STELLA_RUN_SLOT_GUARD_DEMONSp = null;

  public static Symbol SYM_STELLA_RUN_SLOT_DEMONS = null;

  public static Surrogate SGT_STELLA_HOOK_LIST = null;

  public static Symbol SYM_STELLA_SIGNATURE = null;

  /** HOOK-LIST called by <code>inModule</code>, applied to a
   * <code>module</code> argument.
   */
  public static HookList $CHANGE_MODULE_HOOKS$ = null;

  /** HOOK-LIST called by <code>clearModule</code>, applied to a
   * <code>module</code> argument.
   */
  public static HookList $CLEAR_MODULE_HOOKS$ = null;

  /** HOOK-LIST called by <code>clearModule</code>, applied to a
   * <code>module</code> argument.
   */
  public static HookList $DESTROY_CONTEXT_HOOKS$ = null;

  /** HOOK-LIST is called by <code>undefineOldClass</code>.  Each
   * hook function is passed a LIST of two RELATION objects; the first is the
   * old relation object and the second is the new (redefined) relation object.
   * The hook functions are expected to copy/transfer information from the
   * old relation to the new relation so that it won't be lost.
   */
  public static HookList $REDEFINE_RELATION_HOOKS$ = null;

  /** HOOK-LIST is called by <code>finalizeOneClass</code>
   * and <code>finalizeLocalSlot</code>, applied to a RELATION argument.
   */
  public static HookList $FINALIZE_RELATION_HOOKS$ = null;

  /** HOOK-LIST called by <code>createNativeClass</code>, applied to
   * a STELLA class.  Return value of TRUE blocks creation.
   */
  public static HookList $BLOCK_NATIVE_CLASS_CREATION_HOOKS$ = null;

  /** HOOK-LIST of cleanup functions to be called upon exit from
   * the STELLA application or any point where such cleanup is required.  The
   * functions on this list should be highly tolerant of their invocation environment
   * and not assume any special state; that is, they should be no-ops if no special
   * cleanup is required.
   */
  public static HookList $STELLA_EXIT_HOOKS$ = null;

  public static Symbol SYM_STELLA_STARTUP_DEMONS = null;

  public static Symbol SYM_STELLA_STARTUP_MORE_DEMONS = null;

  public static Keyword KWD_CLEVER = null;

  public static Keyword KWD_TITLECASE = null;

  public static Keyword KWD_BREAK_ON_CAP = null;

  public static Keyword KWD_BREAK_ON_NUMBER = null;

  public static Keyword KWD_BREAK_ON_SEPARATORS = null;

  public static Keyword KWD_REMOVE_PREFIX = null;

  public static Keyword KWD_REMOVE_SUFFIX = null;

  public static Keyword KWD_ADD_PREFIX = null;

  public static Keyword KWD_ADD_SUFFIX = null;

  public static Keyword KWD_CASE = null;

  public static Keyword KWD_SEPARATOR = null;

  public static Keyword KWD_SUFFIX = null;

  public static Keyword KWD_TRANSLATION_TABLE = null;

  public static Keyword KWD_USE_ACRONYM_HEURISTICSp = null;

  public static Keyword KWD_ALLCAPS = null;

  public static Keyword KWD_TITLECASEX = null;

  public static Symbol SYM_STELLA_STARTUP_NAME_UTILITY = null;

  /** If <code>true</code>, record object signatures into a persistent table.
   */
  public static boolean $RECORD_SIGNATURESp$ = false;

  /** If <code>true</code>, the walker will try to find previously recorded
   * signatures for referenced but undefined functions, methods, etc.
   */
  public static boolean $WALK_WITH_RECORDED_SIGNATURESp$ = false;

  /** If <code>true</code>, <code>safeLookupSlot</code> and <code>lookupFunction</code> will
   * try to retrieve a previously recorded signature if normal lookup fails.
   */
  public final static StellaSpecialVariable $USERECORDEDSIGNATURESp$ = new StellaSpecialVariable();

  public final static StellaSpecialVariable $ROOTSOURCEDIRECTORY$ = new StellaSpecialVariable();

  public final static StellaSpecialVariable $ROOTNATIVEDIRECTORY$ = new StellaSpecialVariable();

  public final static StellaSpecialVariable $ROOTBINARYDIRECTORY$ = new StellaSpecialVariable();

  /** Points to the directory containing the SYSTEMS file.
   */
  public final static StellaSpecialVariable $SYSTEMDEFINITIONSDIRECTORY$ = new StellaSpecialVariable();

  /** Points to the current system.
   */
  public final static StellaSpecialVariable $CURRENTSYSTEMDEFINITION$ = new StellaSpecialVariable();

  /** Points to a path from the root directory down
   * to a local directory containing sources, natives, or binaries.
   */
  public final static StellaSpecialVariable $CURRENTSYSTEMDEFINITIONSUBDIRECTORY$ = new StellaSpecialVariable();

  /** The operating system we are running on.  Currently,
   * either :UNIX, :WINDOWS, or :MAC.  Note that on the Mac OS X, the
   * OS can be either :UNIX or :MAC, depending on which file naming 
   * conventions are being observed by the software.
   */
  public static Keyword $OS$ = null;

  public final static char TYPE_SEPARATOR = '.';

  public final static char LOGICAL_DIRECTORY_SEPARATOR = ';';

  public final static char LOGICAL_HOST_SEPARATOR = ':';

  public static StringHashTable $LOGICAL_HOST_TABLE$ = null;

  public static Keyword KWD_ROOT_DIRECTORY = null;

  public static Keyword KWD_LISP_TRANSLATIONS = null;

  /** Used by <code>selectFileExtension</code>.
   */
  public static Cons $TYPE_TO_FILE_EXTENSION_TABLE$ = null;

  public static Keyword KWD_KB = null;

  public static Keyword KWD_CPP_CODE = null;

  public static Keyword KWD_CPP_HEADER = null;

  public static Keyword KWD_C_CODE = null;

  public static Keyword KWD_C_HEADER = null;

  public static Keyword KWD_DIRECTORY = null;

  public static String $LISP_SPLITTER_PATH$ = "lisp";

  public static String $JAVA_SPLITTER_PATH$ = "java";

  public static String $CPP_SPLITTER_PATH$ = "cpp";

  /** When TRUE, overrides normal truncation of file names.
   */
  public final static StellaSpecialVariable $DONTTRUNCATEFILENAMESp$ = new StellaSpecialVariable();

  public static Symbol SYM_STELLA_SYSTEM_UNITS_ALIST = null;

  public static Keyword KWD_LANGUAGE = null;

  public static Keyword KWD_ACTION = null;

  public static Keyword KWD_TRANSLATE_SYSTEM = null;

  public static Keyword KWD_DEVELOPMENT_SETTINGSp = null;

  public static Symbol SYM_STELLA_STARTUP_TRANSLATE_FILE = null;

  public static Cons $FILE_LOAD_PATH$ = null;

  /** File extensions to append by default when a
   * file is looked up by <code>findFileInLoadPath</code>.
   */
  public static Cons $STELLA_FILE_EXTENSIONS$ = null;

  public static Keyword KWD_TRUE = null;

  public static Keyword KWD_FALSE = null;

  public static Surrogate SGT_STELLA_IDENTITY = null;

  public static Symbol SYM_STELLA_IN_MODULE = null;

  public static Symbol SYM_STELLA_DEFSYSTEM = null;

  /** A list of all defined systems.
   */
  public static List $SYSTEMDEFINITIONS$ = null;

  public static Keyword KWD_FILES = null;

  public static Keyword KWD_REQUIRED_SYSTEMS = null;

  public static Keyword KWD_LOAD_SYSTEM = null;

  public static Keyword KWD_MAKE_SYSTEM = null;

  public static Keyword KWD_LISP_ONLY_FILES = null;

  public static Keyword KWD_CPP_ONLY_FILES = null;

  public static Keyword KWD_JAVA_ONLY_FILES = null;

  public static Keyword KWD_DATA_FILES = null;

  public static Keyword KWD_PREPROCESSED_FILES = null;

  public static Keyword KWD_CARDINAL_MODULE = null;

  public static Keyword KWD_ROOT_SOURCE_DIRECTORY = null;

  public static Keyword KWD_ROOT_NATIVE_DIRECTORY = null;

  public static Keyword KWD_ROOT_BINARY_DIRECTORY = null;

  public static Keyword KWD_BANNER = null;

  public static Keyword KWD_COPYRIGHT_HEADER = null;

  public static Keyword KWD_PRODUCTION_SETTINGS = null;

  public static Keyword KWD_DEVELOPMENT_SETTINGS = null;

  public static Keyword KWD_FINALIZATION_FUNCTION = null;

  /** Holds the action and options of the current system action
   * such as :make-system, :load-system or :translate-system.  This is used to
   * perform the appropriate actions on required systems in <code>defineSystem</code>.
   */
  public final static StellaSpecialVariable $CURRENT_SYSTEM_ACTION$ = new StellaSpecialVariable();

  public static Keyword KWD_FORCE_RECOMPILATIONp = null;

  public static Keyword KWD_LOAD_SYSTEMp = null;

  public static Keyword KWD_STARTUPp = null;

  public static Symbol SYM_STELLA_SYSTEM_STARTED_UPp = null;

  public static Keyword KWD_EARLY_INITS = null;

  public static Symbol SYM_STELLA_STARTUP = null;

  public static Symbol SYM_STELLA_PHASE = null;

  public static Symbol SYM_STELLA_PHASE_TO_INTEGER = null;

  public static Keyword KWD_SET = null;

  public static Keyword KWD_ADD = null;

  public static Symbol SYM_STELLA_CONFIGURATION_TABLE = null;

  public static KeyValueList $SYSTEM_CONFIGURATION_TABLE$ = null;

  public static Keyword KWD_REMOVE = null;

  /** The :root-directory portion of the PL logical host.  This variable
   * is primarily defined to allow us to dynamically change this via a configuration demon.
   */
  public static String $PL_ROOT_DIRECTORY$ = null;

  public static KeyValueMap $REGISTERED_PROPERTY_DEMONS$ = null;

  public static Symbol SYM_STELLA_TEST_PROPERTY_DEMON = null;

  public static Surrogate SGT_STELLA_CMD_LINE_OPTION = null;

  public static Symbol SYM_STELLA_KEYS = null;

  public static Symbol SYM_STELLA_VALUE_TYPE = null;

  public static Symbol SYM_STELLA_MULTI_VALUEDp = null;

  public static Symbol SYM_STELLA_N_ARGUMENTS = null;

  public static Symbol SYM_STELLA_DEFAULT_VALUE = null;

  public static Symbol SYM_STELLA_CONFIGURATION_PROPERTY = null;

  public static Symbol SYM_STELLA_HANDLER = null;

  public static Symbol SYM_STELLA_ERROR_ACTION = null;

  public static KeyValueMap $REGISTERED_COMMAND_LINE_OPTIONS$ = null;

  public static Keyword KWD_KEY2 = null;

  public static Keyword KWD_KEY3 = null;

  public static Keyword KWD_KEYS = null;

  public static Keyword KWD_VALUE_TYPE = null;

  public static Keyword KWD_MULTI_VALUEDp = null;

  public static Keyword KWD_N_ARGUMENTS = null;

  public static Keyword KWD_DEFAULT_VALUE = null;

  public static Keyword KWD_PROPERTY = null;

  public static Keyword KWD_HANDLER = null;

  public static Keyword KWD_ERROR_ACTION = null;

  public static Cons $UNPROCESSED_COMMAND_LINE_ARGUMENTS$ = null;

  public static Keyword KWD_IGNORE = null;

  public static Symbol SYM_STELLA_EVAL_OPTION_HANDLER = null;

  public static Symbol SYM_STELLA_EVAL_IN_MODULE_OPTION_HANDLER = null;

  public static Symbol SYM_STELLA_LOAD_PATH_OPTION_HANDLER = null;

  public static Symbol SYM_STELLA_CONFIG_FILE_OPTION_HANDLER = null;

  public static Symbol SYM_STELLA_LOAD_FILE_OPTION_HANDLER = null;

  public static Symbol SYM_STELLA_DEFINE_PROPERTY_OPTION_HANDLER = null;

  /** Documentation to be printed at the beginning of command line help.
   */
  public static String $COMMAND_LINE_HELP_HEADER$ = "";

  /** Documentation to be printed at the end of command line help.
   */
  public static String $COMMAND_LINE_HELP_TRAILER$ = "";

  public static Symbol SYM_STELLA_HELP_OPTION_HANDLER = null;

  public static Symbol SYM_STELLA_STARTUP_SYSTEMS = null;

  /** Table of functions (keyed by type of object returned) that can
   * be called to search for an object identified by a string.
   */
  public static KeyValueList $STRING_TO_OBJECT_FUNCTIONS$ = null;

  /** List of functions that can be called to search for
   * an object identified by an integer.
   */
  public static List $INTEGER_TO_OBJECT_FUNCTIONS$ = null;

  public static Surrogate SGT_STELLA_CONTEXT = null;

  /** Specifies the print mode for <code>describe</code> when no second
   * argument is given.
   */
  public static Keyword $DEFAULT_DESCRIBE_MODE$ = null;

  public static Keyword KWD_VERBOSE = null;

  /** Lists longer than the cutoff are truncated during
   * pretty printing.
   */
  public static int $PRETTY_PRINT_LIST_CUTOFF$ = 5;

  public static Surrogate SGT_STELLA_ITERATOR = null;

  /** List of slots containing storage-slot options
   */
  public final static StellaSpecialVariable $SLOTOPTIONSLOTS$ = new StellaSpecialVariable();

  /** List of slots containing class options
   */
  public final static StellaSpecialVariable $CLASSOPTIONSLOTS$ = new StellaSpecialVariable();

  /** Plist of unstringifed class options
   */
  public final static StellaSpecialVariable $CLASSUNSTRINGIFIEDOPTIONS$ = new StellaSpecialVariable();

  public static Surrogate SGT_STELLA_RELATION = null;

  public static Keyword KWD_SOURCE = null;

  public static Keyword KWD_TERSE = null;

  public static Keyword KWD_OWNER = null;

  public static Keyword KWD_SHADOWS = null;

  public static Symbol SYM_STELLA_gg_INFERRED_SLOTS = null;

  public static Keyword KWD_USED_BY = null;

  public static Symbol SYM_STELLA_STARTUP_DESCRIBE = null;

  public final static StellaSpecialVariable $CURRENT_STREAM$ = new StellaSpecialVariable();

  public static String $CPP_TRANSLATED_FILE_SUFFIX$ = "";

  public static Symbol SYM_STELLA_AUXILIARY_VARIABLE = null;

  public static Symbol SYM_STELLA_CPP_FUNCTION = null;

  public static Symbol SYM_STELLA_CPP_DEFPRINT = null;

  public static Keyword KWD_UPPERCASE = null;

  public static String $MAKEFILE_TEMPLATE_VARIABLE_PREFIX$ = "#$";

  public static Symbol SYM_STELLA_STARTUP_CPP_TRANSLATE_FILE = null;

  /** Wrapped TRUE string, used to reduce consing.
   */
  static StringWrapper $CPP_TRUE_STRING_WRAPPER$ = null;

  /** Wrapped FALSE string, used to reduce consing.
   */
  static StringWrapper $CPP_FALSE_STRING_WRAPPER$ = null;

  /** Temporary List of declarations for unused return parameters
   */
  public final static StellaSpecialVariable $DUMMYDECLARATIONS$ = new StellaSpecialVariable();

  /** Current index of dummy parameter for unused return value
   */
  public final static StellaSpecialVariable $CURRENTDUMMYINDEX$ = new StellaSpecialVariable();

  /** Mapping from STELLA operators to C++ operators
   */
  public static KeyValueList $OPERATOR_TABLE$ = null;

  public static Symbol SYM_STELLA_eg = null;

  public static Symbol SYM_STELLA_el = null;

  public static Symbol SYM_STELLA_ASM = null;

  public static Symbol SYM_STELLA_ASSERT = null;

  public static Symbol SYM_STELLA_AUTO = null;

  public static Symbol SYM_STELLA_CATCH = null;

  public static Symbol SYM_STELLA_CHAR = null;

  public static Symbol SYM_STELLA_CONST = null;

  public static Symbol SYM_STELLA_DEFAULT = null;

  public static Symbol SYM_STELLA_DELETE = null;

  public static Symbol SYM_STELLA_DOUBLE = null;

  public static Symbol SYM_STELLA_ELSE = null;

  public static Symbol SYM_STELLA_ENUM = null;

  public static Symbol SYM_STELLA_EXTERN = null;

  public static Symbol SYM_STELLA_FLOAT = null;

  public static Symbol SYM_STELLA_FOR = null;

  public static Symbol SYM_STELLA_FRIEND = null;

  public static Symbol SYM_STELLA_GOTO = null;

  public static Symbol SYM_STELLA_INT = null;

  public static Symbol SYM_STELLA_LONG = null;

  public static Symbol SYM_STELLA_NAMESPACE = null;

  public static Symbol SYM_STELLA_OPERATOR = null;

  public static Symbol SYM_STELLA_PRIVATE = null;

  public static Symbol SYM_STELLA_PROTECTED = null;

  public static Symbol SYM_STELLA_PUBLIC = null;

  public static Symbol SYM_STELLA_REGISTER = null;

  public static Symbol SYM_STELLA_SHORT = null;

  public static Symbol SYM_STELLA_SIGNED = null;

  public static Symbol SYM_STELLA_SIZEOF = null;

  public static Symbol SYM_STELLA_STATIC = null;

  public static Symbol SYM_STELLA_STRUCT = null;

  public static Symbol SYM_STELLA_SWITCH = null;

  public static Symbol SYM_STELLA_TEMPLATE = null;

  public static Symbol SYM_STELLA_THROW = null;

  public static Symbol SYM_STELLA_TRY = null;

  public static Symbol SYM_STELLA_TYPEDEF = null;

  public static Symbol SYM_STELLA_TYPEID = null;

  public static Symbol SYM_STELLA_UNION = null;

  public static Symbol SYM_STELLA_UNSIGNED = null;

  public static Symbol SYM_STELLA_VIRTUAL = null;

  public static Symbol SYM_STELLA_VOID = null;

  public static Symbol SYM_STELLA_VOLATILE = null;

  public static Symbol SYM_STELLA_TYPENAME = null;

  public static StringHashTable $CPP_RESERVED_WORD_TABLE$ = null;

  /** Home module of the currently translated unit.  Needed for
   * proper name translation for units whose home module is different than the
   * file module (occurs in some PowerLoom files - I thought we had outlawed that).
   */
  public final static StellaSpecialVariable $CPP_CURRENT_UNIT_MODULE$ = new StellaSpecialVariable();

  public static Symbol SYM_STELLA_SYS_REFERENCED_SLOT_VALUE = null;

  public static Symbol SYM_STELLA_SYS_REFERENCED_CALL_METHOD = null;

  public static Symbol SYM_STELLA_SYS_POINTER_TO_FUNCTION = null;

  public static Symbol SYM_STELLA_CPP_VERBATIM = null;

  public static Symbol SYM_STELLA_CPP_FUNCTION_CALL = null;

  public static Symbol SYM_STELLA_CPP_IDENT = null;

  public static Symbol SYM_STELLA_CPP_ACTUALS = null;

  public static Symbol SYM_STELLA_CPP_BLOCK = null;

  public static Symbol SYM_STELLA_CPP_STATEMENTS = null;

  public static Symbol SYM_STELLA_CPP_COMMENT = null;

  public static Symbol SYM_STELLA_CPP_PRINT_NATIVE_STREAM = null;

  public static Symbol SYM_STELLA_CPP_RETURN = null;

  public static Symbol SYM_STELLA_CPP_SIGNAL = null;

  public static Symbol SYM_STELLA_CPP_DEREFERENCE = null;

  public static Symbol SYM_STELLA_CPP_HANDLER_CASE = null;

  public static Symbol SYM_STELLA_CPP_CATCH = null;

  public static Symbol SYM_STELLA_CPP_TYPE = null;

  public static Symbol SYM_STELLA_CPP_LOCAL = null;

  public static Symbol SYM_STELLA_CPP_UNWIND_PROTECT = null;

  public static Symbol SYM_STELLA_CPP_CAST = null;

  public static Symbol SYM_STELLA_CPP_ASSIGN = null;

  public static Symbol SYM_STELLA_CPP_SPECIAL = null;

  public static Symbol SYM_STELLA_CPP_GLOBAL = null;

  public static Symbol SYM_STELLA_CPP_CASE = null;

  public static Symbol SYM_STELLA_CPP_PROGN = null;

  public static Symbol SYM_STELLA_CPP_COND = null;

  public static Symbol SYM_STELLA_CPP_LOOP = null;

  public static Symbol SYM_STELLA_CPP_WHILE = null;

  public static Symbol SYM_STELLA_CPP_WITH_PROCESS_LOCK = null;

  public static Symbol SYM_STELLA_CPP_BREAK = null;

  public static Symbol SYM_STELLA_CPP_CONTINUE = null;

  public static Symbol SYM_STELLA_CPP_IF = null;

  public static Symbol SYM_STELLA_CPP_WHEN = null;

  public static Symbol SYM_STELLA_CPP_UNLESS = null;

  public static Symbol SYM_STELLA_CPP_FOREACH = null;

  public static Symbol SYM_STELLA_VA_START = null;

  public static Symbol SYM_STELLA_VA_END = null;

  public static Symbol SYM_STELLA_CPP_BINARY_OP = null;

  public static Symbol SYM_STELLA_CPP_UNARY_OP = null;

  public static Symbol SYM_STELLA_CPP_LITERAL = null;

  public static Symbol SYM_STELLA_VA_ARG = null;

  public static Symbol SYM_STELLA_CPP_FUNCTION_POINTER = null;

  public static Symbol SYM_STELLA_CPP_METHOD_POINTER = null;

  public static Surrogate SGT_STELLA_BYTE = null;

  public static Surrogate SGT_STELLA_OCTET = null;

  public static Symbol SYM_STELLA_CPP_ARRAY_REFERENCE = null;

  public static Symbol SYM_STELLA_CPP_REFERENCED_SLOT_VALUE = null;

  public static Symbol SYM_STELLA_CPP_SLOT_VALUE = null;

  public static Symbol SYM_STELLA_CPP_SLOT_VALUE_SETTER = null;

  public static Symbol SYM_STELLA_CPP_MAKE = null;

  public static Symbol SYM_STELLA_CPP_STARTUP_TIME_PROGN = null;

  public static Symbol SYM_STELLA_CPP_PRINT_STREAM = null;

  public static Symbol SYM_STELLA_CPP_STANDARD_ERROR = null;

  public static Symbol SYM_STELLA_CPP_STANDARD_OUT = null;

  public static Symbol SYM_STELLA_CPP_SYMBOL = null;

  public static String $CPP_CHARACTER_SUBSTITUTION_TABLE$ = null;

  public static Keyword KWD_LOWERCASE = null;

  public static Keyword KWD_CAPITALIZED = null;

  public static Surrogate SGT_STELLA_F_CPP_CHANGE_CASE_MEMO_TABLE_000 = null;

  public final static StellaSpecialVariable $CPP_NAME_QUALIFICATION_MODE$ = new StellaSpecialVariable();

  public static Keyword KWD_NEVER = null;

  public static String $CPP_NAMESPACE_SEPARATOR$ = "::";

  public static Symbol SYM_STELLA__RETURN = null;

  public static Symbol SYM_STELLA_CPP_VAR_ARGS = null;

  public static Symbol SYM_STELLA_THIS = null;

  public static Symbol SYM_STELLA_CPP_METHOD = null;

  public static Symbol SYM_STELLA_CPP_EXTERN_C = null;

  public static Symbol SYM_STELLA_CPP_METHOD_SETTER_CALL = null;

  public static Symbol SYM_STELLA_CPP_REFERENCED_METHOD_CALL = null;

  public static Symbol SYM_STELLA_CPP_METHOD_CALL = null;

  public static Symbol SYM_STELLA_CPP_FUNCTION_SIGNATURE = null;

  public static Symbol SYM_STELLA_CPP_METHOD_SIGNATURE = null;

  public static Symbol SYM_STELLA_CPP_FUNCALL = null;

  public static Symbol SYM_STELLA_CPP_METHOD_CODE_CALL = null;

  public static Symbol SYM_STELLA_DUMMY = null;

  public static Symbol SYM_STELLA_CPP_TERNARY_OP = null;

  public static Symbol SYM_STELLA_STARTUP_CPP_TRANSLATE = null;

  public static Symbol SYM_STELLA_GC = null;

  public static Symbol SYM_STELLA_CPP_CLASS = null;

  public static Symbol SYM_STELLA_CPP_DECLARATIONS = null;

  public static Keyword KWD_PUBLIC = null;

  public static Symbol SYM_STELLA_CPP_SIGNATURES = null;

  public static Symbol SYM_STELLA_CPP_DEFINITIONS = null;

  public static Symbol SYM_STELLA_STARTUP_CPP_CLASS_OUT = null;

  public final static StellaSpecialVariable $CPP_INDENT_CHARS$ = new StellaSpecialVariable();

  /** <code>true</code> when outputting a defprint, used to 
   *             conditionally dereference streams in print-native-stream 
   *             statements.  Also used to take the address of streams
   *             when passed to functions inside of a defprint
   */
  public final static StellaSpecialVariable $OUTPUTTINGDEFPRINTp$ = new StellaSpecialVariable();

  public static Symbol SYM_STELLA_$CURRENT_STREAM$ = null;

  /** C++ string literals longer than this are broken
   * into multiple pieces to avoid problems with certain MS compilers.
   */
  public static int $CPP_MAX_STRING_LITERAL_LENGTH$ = 1024;

  public static Symbol SYM_STELLA_NEWLINE = null;

  public static Symbol SYM_STELLA_CPP_NULL_VALUE = null;

  public static Symbol SYM_STELLA_ASSIGN = null;

  public static Symbol SYM_STELLA_SCOLON = null;

  public static Symbol SYM_STELLA_LPAREN = null;

  public static Symbol SYM_STELLA_RPAREN = null;

  public static Symbol SYM_STELLA_CPP_NEW = null;

  public static Symbol SYM_STELLA_CPP_THROW = null;

  public static Keyword KWD_PRIVATE = null;

  public static Keyword KWD_PROTECTED = null;

  public static Symbol SYM_STELLA_STARTUP_CPP_OUTPUT = null;

  /** Holds the current Stella class being output in Java
   */
  final static StellaSpecialVariable $CURRENT_JAVA_OUTPUT_CLASS$ = new StellaSpecialVariable();

  public static Symbol SYM_STELLA_STARTUP_JAVA_TRANSLATE_FILE = null;

  /** Wrapped true string, used to reduce consing.
   */
  static StringWrapper $JAVA_TRUE_STRING_WRAPPER$ = null;

  /** Wrapped false string, used to reduce consing.
   */
  static StringWrapper $JAVA_FALSE_STRING_WRAPPER$ = null;

  public static Symbol SYM_STELLA_JAVA_GLOBAL = null;

  public static Symbol SYM_STELLA_JAVA_TYPE = null;

  public static Symbol SYM_STELLA_JAVA_MAKE = null;

  public static Symbol SYM_STELLA_JAVA_IDENT = null;

  public static Symbol SYM_STELLA_JAVA_ACTUALS = null;

  public static Symbol SYM_STELLA_JAVA_STATEMENTS = null;

  public static Symbol SYM_STELLA_JAVA_BLOCK = null;

  public static Symbol SYM_STELLA_JAVA_COMMENT = null;

  public static Symbol SYM_STELLA_JAVA_FUNCTION = null;

  public static Symbol SYM_STELLA_JAVA_METHOD = null;

  /** A list of new vectors generated for variable-length argument 
   *              lists
   */
  public final static StellaSpecialVariable $VARARGSTATEMENTS$ = new StellaSpecialVariable();

  /** A list of vector-pushes generated for variable-length argument 
   *              lists
   */
  public final static StellaSpecialVariable $VARARGDECLS$ = new StellaSpecialVariable();

  /** The current index of the variable length arguments
   */
  public final static StellaSpecialVariable $CURRENTVARARGINDEX$ = new StellaSpecialVariable();

  /** Mapping from STELLA operators to Java operators
   */
  public static KeyValueList $JAVA_OPERATOR_TABLE$ = null;

  public static String $JAVA_CHARACTER_SUBSTITUTION_TABLE$ = null;

  public static Surrogate SGT_STELLA_THIRY_TWO_BIT_VECTOR = null;

  public static Surrogate SGT_STELLA_DOUBLE = null;

  public static Symbol SYM_STELLA_ABSTRACT = null;

  public static Symbol SYM_STELLA_BYTE = null;

  public static Symbol SYM_STELLA_EXTENDS = null;

  public static Symbol SYM_STELLA_FINAL = null;

  public static Symbol SYM_STELLA_FINALLY = null;

  public static Symbol SYM_STELLA_IMPLEMENTS = null;

  public static Symbol SYM_STELLA_IMPORT = null;

  public static Symbol SYM_STELLA_INSTANCEOF = null;

  public static Symbol SYM_STELLA_INTERFACE = null;

  public static Symbol SYM_STELLA_NATIVE = null;

  public static Symbol SYM_STELLA_PACKAGE = null;

  public static Symbol SYM_STELLA_SUPER = null;

  public static Symbol SYM_STELLA_SYNCHRONIZED = null;

  public static Symbol SYM_STELLA_THROWS = null;

  public static Symbol SYM_STELLA_TRANSIENT = null;

  public static StringHashTable $JAVA_RESERVED_WORD_TABLE$ = null;

  public static Symbol SYM_STELLA_JAVA_METHOD_CALL = null;

  public static Symbol SYM_STELLA_JAVA_UNWIND_PROTECT = null;

  public static Symbol SYM_STELLA_JAVA_VERBATIM = null;

  public static Symbol SYM_STELLA_JAVA_SIGNAL = null;

  public static Symbol SYM_STELLA_FILL_IN_STACK_TRACE = null;

  public static Symbol SYM_STELLA_JAVA_HANDLER_CASE = null;

  public static Symbol SYM_STELLA_JAVA_CATCH = null;

  public static Symbol SYM_STELLA_JAVA_FUNCTION_CALL = null;

  public static Symbol SYM_STELLA_JAVA_ASSIGN = null;

  public static Symbol SYM_STELLA_JAVA_SLOT_VALUE_SETTER = null;

  public static Symbol SYM_STELLA_JAVA_SLOT_VALUE = null;

  public static Symbol SYM_STELLA_JAVA_PROGN = null;

  public static Symbol SYM_STELLA_JAVA_WITH_PROCESS_LOCK = null;

  public final static StellaSpecialVariable $JAVA_LOOP_NAME$ = new StellaSpecialVariable();

  public final static StellaSpecialVariable $JAVA_LOOP_NAME_USEDp$ = new StellaSpecialVariable();

  public static Symbol SYM_STELLA_JAVA_NAMED_STATEMENT = null;

  public static Symbol SYM_STELLA_JAVA_LOOP = null;

  public static Symbol SYM_STELLA_JAVA_FOREACH = null;

  public static Symbol SYM_STELLA_JAVA_CAST = null;

  public static Symbol SYM_STELLA_JAVA_AREF = null;

  public static Symbol SYM_STELLA_MV_returnarray = null;

  public static Symbol SYM_STELLA_JAVA_RETURN = null;

  public static Symbol SYM_STELLA_JAVA_BREAK = null;

  public static Symbol SYM_STELLA_JAVA_CONTINUE = null;

  public static Symbol SYM_STELLA_JAVA_IF = null;

  public static Symbol SYM_STELLA_JAVA_CASE = null;

  public static Symbol SYM_STELLA_JAVA_COND = null;

  public static Symbol SYM_STELLA_JAVA_WHILE = null;

  public static Symbol SYM_STELLA_JAVA_WHEN = null;

  public static Symbol SYM_STELLA_JAVA_UNLESS = null;

  public static Symbol SYM_STELLA_JAVA_MAKE_ARRAY = null;

  public static Surrogate SGT_STELLA_NATIVE_OBJECT_POINTER = null;

  public static Symbol SYM_STELLA_caller_MV_returnarray = null;

  public static Symbol SYM_STELLA_JAVA_FUNCTION_SIGNATURE = null;

  public static Symbol SYM_STELLA_JAVA_FUNCALL = null;

  public static Symbol SYM_STELLA_JAVA_METHOD_CODE_CALL = null;

  public static Surrogate SGT_STELLA_THIRTY_TWO_BIT_VECTOR = null;

  public static Surrogate SGT_STELLA_TICKTOCK = null;

  public static Surrogate SGT_STELLA_NATIVE_DATE_TIME = null;

  public static KeyValueList $JAVA_PRIMITIVE_ARRAY_TYPE_NAMES$ = null;

  public static Symbol SYM_STELLA_JAVA_ANONYMOUS_ARRAY = null;

  public static Symbol SYM_STELLA_JAVA_PRINT_STREAM = null;

  public static Symbol SYM_STELLA_JAVA_STANDARD_ERROR = null;

  public static Symbol SYM_STELLA_JAVA_STANDARD_OUT = null;

  public static Symbol SYM_STELLA_JAVA_LITERAL = null;

  public static Symbol SYM_STELLA_JAVA_PRINT_NATIVE_STREAM = null;

  public static Symbol SYM_STELLA_JAVA_EOL = null;

  public static Symbol SYM_STELLA_JAVA_SYMBOL = null;

  public static Symbol SYM_STELLA_JAVA_UNARY_OP = null;

  public static Symbol SYM_STELLA_JAVA_BINARY_OP = null;

  public static Symbol SYM_STELLA_JAVA_TERNARY_OP = null;

  public static Symbol SYM_STELLA_STARTUP_JAVA_TRANSLATE = null;

  public static Symbol SYM_STELLA_JAVA_EXCEPTION_CLASS = null;

  public static Symbol SYM_STELLA_JAVA_CLASS = null;

  public static Symbol SYM_STELLA_JAVA_DECLARATIONS = null;

  public static Symbol SYM_STELLA_STARTUP_JAVA_CLASS_OUT = null;

  public final static StellaSpecialVariable $JAVA_INDENT_CHARS$ = new StellaSpecialVariable();

  public static KeyValueList $JAVA_STELLA_PACKAGE_MAPPING$ = null;

  public static Symbol SYM_STELLA_JAVA_THROW = null;

  public static Symbol SYM_STELLA_JAVA_ARRAY_INITIALIZER = null;

  public static Cons $JAVA_SEMICOLON_STATEMENTS$ = null;

  public static Symbol SYM_STELLA_JAVA_FUNCTION_POINTER = null;

  public static Symbol SYM_STELLA_JAVA_METHOD_POINTER = null;

  public static Symbol SYM_STELLA_JAVA_METHOD_SETTER_CALL = null;

  public static Symbol SYM_STELLA_JAVA_NEW = null;

  public static Symbol SYM_STELLA_STARTUP_JAVA_OUTPUT = null;

  public static Symbol SYM_STELLA_IDL_TYPEDEF = null;

  public static Symbol SYM_STELLA_IDL_IDENT = null;

  public static Symbol SYM_STELLA_IDL_LITERAL = null;

  public static String $IDL_CHARACTER_SUBSTITUTION_TABLE$ = null;

  public static StringHashTable $IDL_RESERVED_WORD_TABLE$ = null;

  public static Symbol SYM_STELLA_STARTUP_IDL_TRANSLATE = null;

  public static Symbol SYM_STELLA_IDL_INTERFACE = null;

  public static Symbol SYM_STELLA_sIDL_THEORYsinterface = null;

  public static Symbol SYM_STELLA_sIDL_THEORYsstruct = null;

  public static Symbol SYM_STELLA_sIDL_THEORYsenum = null;

  public static Symbol SYM_STELLA_sIDL_THEORYstypedef = null;

  public static Symbol SYM_STELLA_IDL_STRUCT = null;

  public static Symbol SYM_STELLA_IDL_ENUM = null;

  public static Symbol SYM_STELLA_IDL_DECLARATIONS = null;

  public static Symbol SYM_STELLA_IDL_SIGNATURES = null;

  public static Symbol SYM_STELLA_STARTUP_IDL_CLASS_OUT = null;

  public static String $IDL_TRANSLATED_FILE_SUFFIX$ = "";

  public static Symbol SYM_STELLA_STARTUP_IDL_TRANSLATE_FILE = null;

  public final static StellaSpecialVariable $IDL_INDENT_CHARS$ = new StellaSpecialVariable();

  public static Symbol SYM_STELLA_IDL_COMMENT = null;

  public static Symbol SYM_STELLA_IDL_TYPE = null;

  public static Symbol SYM_STELLA_IDL_VAR_ARGS = null;

  public static Symbol SYM_STELLA_STARTUP_IDL_OUTPUT = null;

  /** String used in the PRINT-OUTLINE for each level of outline
   */
  public static String $OUTLINE_INDENT_STRING$ = "| ";

  public static Symbol SYM_STELLA_STARTUP_TOOLS = null;

  public static int $STELLA_MAJOR_VERSION_NUMBER$ = 3;

  public static int $STELLA_MINOR_VERSION_NUMBER$ = 5;

  public static String $STELLA_RELEASE_STATE$ = "";

  public static int $STELLA_PATCH_LEVEL$ = 35;

  public static String $STELLA_VERSION_STRING$ = null;

  /** List of phases that can be legally used as an optional
   * phase argument to a <code>startupTimeProgn</code> form.  The corresponding code
   * will be executed during the execution of a startup-time-code function only
   * if the position of the keyword in the list corresponds to the current value of
   * <code>$STARTUP_TIME_PHASE$</code>, or if phasing of startup-time code is disabled.
   */
  public static List $STARTUP_TIME_PHASES$ = null;

  public static Keyword KWD_QUOTED_CONSTANTS = null;

  /** The current phase during 'phased startup'.
   * The value has to correspond to the position of one of the keywords
   * in <code>$STARTUP_TIME_PHASES$</code>.  999 means no phasing at all.
   */
  public static int $STARTUP_TIME_PHASE$ = 999;

  public static Symbol SYM_STELLA_STARTUP_STARTUP = null;

  public static Symbol SYM_STELLA_STARTUP_STELLA_SYSTEM = null;

  public static OutputStream makeEarlyOutputStream(edu.isi.stella.javalib.NativeOutputStream nativestream) {
    { OutputStream stream = OutputStream.newOutputStream();

      stream.nativeStream = nativestream;
      return (stream);
    }
  }

  /** Ensures that <code>filename</code> exists.  If not, an exception of
   * type <code>NO_SUCH_FILE_EXCEPTION</code> is thrown with <code>context</code> supplying
   * context for the error message.
   * @param filename
   * @param context
   */
  public static void ensureFileExists(String filename, String context) {
    if (!(Stella.probeFileP(filename))) {
      { NoSuchFileException self000 = NoSuchFileException.newNoSuchFileException(context + ": file " + filename + " does not exist");

        self000.filename = filename;
        { NoSuchFileException ex = self000;

          throw ((NoSuchFileException)(ex.fillInStackTrace()));
        }
      }
    }
  }

  /** Ensures that <code>filename</code> does not exist.  If it does,
   * an exception of type <code>FILE_ALREADY_EXISTS_EXCEPTION</code> is thrown
   * with <code>context</code> supplying context for the error message.
   * @param filename
   * @param context
   */
  public static void ensureFileDoesNotExist(String filename, String context) {
    if (Stella.probeFileP(filename)) {
      { FileAlreadyExistsException self000 = FileAlreadyExistsException.newFileAlreadyExistsException(context + ": file " + filename + " already exists");

        self000.filename = filename;
        { FileAlreadyExistsException ex = self000;

          throw ((FileAlreadyExistsException)(ex.fillInStackTrace()));
        }
      }
    }
  }

  /** Open file <code>filename</code> for output and return the resulting output stream.
   * By default the file will be created or overwritten if it already exists.
   * If <code>CIF_EXISTS</code> (or <code>CIF_EXISTS_ACTION</code>) is one of the <code>options</code> its value
   * specifies what to do in case the file already exists.  If the value is
   * <code>CSUPERSEDE</code> the pre-existing file will be overwritten.  If the value is
   * <code>CAPPEND</code> the preexisting file will be appended to (if the file did not
   * yet exist the file will simply be created).  If the value is <code>CERROR</code> then
   * an error will be signaled.  If it is <code>CABORT</code> or <code>CPROBE</code> the opening operation
   * will be aborted and NULL will be returned.
   * <p>
   * If <code>CIF_NOT_EXISTS</code> (or <code>CIF_NOT_EXISTS_ACTION</code>) is one of the <code>options</code> its
   * value specifies what to do in case the file does not already exist.  If the
   * value is <code>CCREATE</code>, the file will simply be created.  If the value is
   * <code>CERROR</code> then an error will be signaled.  If it is <code>CABORT</code> or <code>CPROBE</code> the
   * opening operation will be aborted and NULL will be returned.
   * @param filename
   * @param options
   * @return OutputFileStream
   */
  public static OutputFileStream openOutputFile(String filename, Cons options) {
    { OutputFileStream stream = OutputFileStream.newOutputFileStream(null);
      PropertyList theoptions = Stella_Object.vetOptions(options, Cons.list$(Cons.cons(Stella.KWD_IF_EXISTS, Cons.cons(Stella.KWD_IF_EXISTS_ACTION, Cons.cons(Stella.KWD_IF_NOT_EXISTS, Cons.cons(Stella.KWD_IF_NOT_EXISTS_ACTION, Cons.cons(Stella.NIL, Stella.NIL)))))));

      { Stella_Object temp000 = theoptions.lookup(Stella.KWD_IF_EXISTS);

        { Keyword chooseValue000 = null;

          if (temp000 != null) {
            chooseValue000 = ((Keyword)(temp000));
          }
          else {
            { Stella_Object temp001 = theoptions.lookup(Stella.KWD_IF_EXISTS_ACTION);

              chooseValue000 = ((temp001 != null) ? ((Keyword)(temp001)) : Stella.KWD_SUPERSEDE);
            }
          }
          stream.ifExistsAction = chooseValue000;
        }
      }
      { Stella_Object temp002 = theoptions.lookup(Stella.KWD_IF_NOT_EXISTS);

        { Keyword chooseValue001 = null;

          if (temp002 != null) {
            chooseValue001 = ((Keyword)(temp002));
          }
          else {
            { Stella_Object temp003 = theoptions.lookup(Stella.KWD_IF_NOT_EXISTS_ACTION);

              chooseValue001 = ((temp003 != null) ? ((Keyword)(temp003)) : Stella.KWD_CREATE);
            }
          }
          stream.ifNotExistsAction = chooseValue001;
        }
      }
      stream.filename = filename;
      OutputFileStream.initializeFileOutputStream(stream);
      if (stream.nativeStream == null) {
        Stream.closeStream(stream);
        stream = null;
      }
      return (stream);
    }
  }

  /** Open file <code>filename</code> for input and return the resulting input stream.
   * By default signal an error if the file does not exist.  The only legal
   * option so far is <code>CIF_NOT_EXISTS</code> (or <code>CIF_NOT_EXISTS_ACTION</code>) which
   * specifies what to do in case the file does not exist.  If its value is
   * <code>CERROR</code> then an error will be signaled.  If it is <code>CABORT</code> or <code>CPROBE</code>
   * the opening operation will be aborted and NULL will be returned.
   * @param filename
   * @param options
   * @return InputFileStream
   */
  public static InputFileStream openInputFile(String filename, Cons options) {
    { InputFileStream stream = InputFileStream.newInputFileStream(null);
      PropertyList theoptions = Stella_Object.vetOptions(options, Cons.list$(Cons.cons(Stella.KWD_IF_NOT_EXISTS, Cons.cons(Stella.KWD_IF_NOT_EXISTS_ACTION, Cons.cons(Stella.NIL, Stella.NIL)))));

      { Stella_Object temp000 = theoptions.lookup(Stella.KWD_IF_NOT_EXISTS);

        { Keyword chooseValue000 = null;

          if (temp000 != null) {
            chooseValue000 = ((Keyword)(temp000));
          }
          else {
            { Stella_Object temp001 = theoptions.lookup(Stella.KWD_IF_NOT_EXISTS_ACTION);

              chooseValue000 = ((temp001 != null) ? ((Keyword)(temp001)) : Stella.KWD_ERROR);
            }
          }
          stream.ifNotExistsAction = chooseValue000;
        }
      }
      stream.filename = filename;
      InputFileStream.initializeFileInputStream(stream);
      if (stream.nativeStream == null) {
        Stream.closeStream(stream);
        stream = null;
      }
      return (stream);
    }
  }

  /** Close all currently open file streams.  Use for emergencies or for cleanup.
   */
  public static void closeAllFiles() {
    { List openstreams = Stella.$OPEN_FILE_STREAMS$.copy();

      { Stream stream = null;
        Cons iter000 = openstreams.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          stream = ((Stream)(iter000.value));
          Stream.closeStream(stream);
        }
      }
      openstreams.free();
    }
  }

  /** Open a TCP/IP network stream to <code>host</code> at <code>port</code> and return the result
   * as an input/output stream pair.
   * @param host
   * @param port
   * @param MV_returnarray
   * @return InputStream
   */
  public static InputStream openNetworkStream(String host, int port, Object [] MV_returnarray) {
    { edu.isi.stella.javalib.NativeInputStream in = null;
      edu.isi.stella.javalib.NativeOutputStream out = null;

      try {
        java.net.Socket s = new java.net.Socket(host, port);
        in = edu.isi.stella.javalib.NativeInputStream.create(s.getInputStream());
        out = edu.isi.stella.javalib.NativeOutputStream.create(s.getOutputStream());
      } catch (java.net.UnknownHostException uhe) {
        throw (InputOutputException) InputOutputException.newInputOutputException("Unknown host: " + host).fillInStackTrace();
      } catch (java.io.IOException ioe) {
        throw (InputOutputException) InputOutputException.newInputOutputException(ioe.getMessage()).fillInStackTrace();
      }
;
      { InputStream self000 = InputStream.newInputStream();

        self000.nativeStream = in;
        self000.state = Stella.KWD_OPEN;
        self000.bufferingScheme = Stella.KWD_BLOCK;
        { InputStream value000 = self000;

          { OutputStream self001 = OutputStream.newOutputStream();

            self001.nativeStream = out;
            self001.state = Stella.KWD_OPEN;
            { OutputStream value001 = self001;

              { InputStream _return_temp = value000;

                MV_returnarray[0] = value001;
                return (_return_temp);
              }
            }
          }
        }
      }
    }
  }

  public static long nativeFileInputStreamPosition(edu.isi.stella.javalib.NativeInputStream nstream) {
    return (((NativeFileInputStream)nstream).position());
  }

  public static long nativeFileInputStreamPositionSetter(edu.isi.stella.javalib.NativeInputStream nstream, long newpos) {
    ((NativeFileInputStream)nstream).position(newpos);
    return (newpos);
  }

  public static long nativeFileOutputStreamPosition(edu.isi.stella.javalib.NativeOutputStream nstream) {
    return (((NativeFileOutputStream)nstream).position());
  }

  public static long nativeFileOutputStreamPositionSetter(edu.isi.stella.javalib.NativeOutputStream nstream, long newpos) {
    ((NativeFileOutputStream)nstream).position(newpos);
    return (newpos);
  }

  public static boolean htmlCharacterNeedsQuotingP(char ch) {
    return (Native.string_memberP(Stella.$HTML_QUOTED_CHARACTERS$, ch));
  }

  public static void writeHtmlCharacterQuotingSpecialCharacters(edu.isi.stella.javalib.NativeOutputStream stream, char ch) {
    switch (ch) {
      case '>': 
        stream.print("&gt;");
      break;
      case '<': 
        stream.print("&lt;");
      break;
      case '&': 
        stream.print("&amp;");
      break;
      case '"': 
        stream.print("&quot;");
      break;
      case '\n': 
      case '\r': 
        stream.print("&#" + (int) ch + ";");
      break;
      default:
        stream.print(ch);
      break;
    }
    return;
  }

  public static void writeHtmlQuotingSpecialCharacters(edu.isi.stella.javalib.NativeOutputStream stream, String input) {
    { char ch = Stella.NULL_CHARACTER;
      String vector000 = input;
      int index000 = 0;
      int length000 = vector000.length();

      for (;index000 < length000; index000 = index000 + 1) {
        ch = vector000.charAt(index000);
        Stella.writeHtmlCharacterQuotingSpecialCharacters(stream, ch);
      }
    }
    return;
  }

  /** Writes a string and replaces unallowed URL characters according to RFC 2396
   * with %-format URL escape sequences.
   * @param stream
   * @param input
   */
  public static void writeHtmlEscapingUrlSpecialCharacters(edu.isi.stella.javalib.NativeOutputStream stream, String input) {
    { char ch = Stella.NULL_CHARACTER;
      String vector000 = input;
      int index000 = 0;
      int length000 = vector000.length();

      for (;index000 < length000; index000 = index000 + 1) {
        ch = vector000.charAt(index000);
        if ((Stella.$CHARACTER_TYPE_TABLE$[(int) ch] == Stella.KWD_LETTER) ||
            (Stella.$CHARACTER_TYPE_TABLE$[(int) ch] == Stella.KWD_DIGIT)) {
          stream.print(ch);
        }
        else {
          switch (ch) {
            case '-': 
            case '_': 
            case '.': 
            case '~': 
              stream.print(ch);
            break;
            default:
              { int code = (int) ch;

                if (code < 16) {
                  stream.print("%0" + Native.integerToHexString(((long)(code))));
                }
                else {
                  stream.print("%" + Native.integerToHexString(((long)(code))));
                }
              }
            break;
          }
        }
      }
    }
    return;
  }

  /** Convert the base-16 hex character <code>c</code> into a base-10 number.
   * @param c
   * @return int
   */
  public static int hexCharacterValue(char c) {
    { int code = (int) c;

      if (code < 65) {
        return (code - 48);
      }
      else if (code < 97) {
        return (code - 55);
      }
      else {
        return (code - 87);
      }
    }
  }

  /** Takes a string and replaces %-format URL escape sequences with their real
   * character equivalent according to RFC 2396.
   * @param input
   * @return String
   */
  public static String unescapeUrlString(String input) {
    if (Native.string_position(input, '%', 0) == Stella.NULL_INTEGER) {
      return (input);
    }
    else {
      { StringBuffer result = Stella.makeRawMutableString(input.length());
        int iOut = 0;
        int iIn = 0;
        char charSave = Stella.NULL_CHARACTER;
        int charValue = 0;
        int escapeValue = 0;
        int iMax = input.length();

        while (iIn < iMax) {
          if (input.charAt(iIn) == '%') {
            {
              iIn = iIn + 1;
              if (iIn < iMax) {
                {
                  charSave = input.charAt(iIn);
                  charValue = Stella.hexCharacterValue(charSave);
                  iIn = iIn + 1;
                  if ((charValue != Stella.NULL_INTEGER) &&
                      (iIn < iMax)) {
                    {
                      escapeValue = 16 * charValue;
                      charValue = Stella.hexCharacterValue(input.charAt(iIn));
                      if (charValue != Stella.NULL_INTEGER) {
                        {
                          edu.isi.stella.javalib.Native.mutableString_nthSetter(result, ((char) (escapeValue + charValue)), iOut);
                        }
                      }
                      else {
                        {
                          edu.isi.stella.javalib.Native.mutableString_nthSetter(result, '%', iOut);
                          edu.isi.stella.javalib.Native.mutableString_nthSetter(result, charSave, (iOut = iOut + 1));
                          edu.isi.stella.javalib.Native.mutableString_nthSetter(result, (input.charAt(iIn)), (iOut = iOut + 1));
                        }
                      }
                    }
                  }
                  else {
                    {
                      edu.isi.stella.javalib.Native.mutableString_nthSetter(result, '%', iOut);
                      edu.isi.stella.javalib.Native.mutableString_nthSetter(result, charSave, (iOut = iOut + 1));
                    }
                  }
                  iOut = iOut + 1;
                  iIn = iIn + 1;
                }
              }
              else {
                {
                  edu.isi.stella.javalib.Native.mutableString_nthSetter(result, '%', iOut);
                  iOut = iOut + 1;
                }
              }
            }
          }
          else {
            {
              edu.isi.stella.javalib.Native.mutableString_nthSetter(result, (input.charAt(iIn)), iOut);
              iOut = iOut + 1;
              iIn = iIn + 1;
            }
          }
        }
        return (Native.mutableString_subsequence(result, 0, iOut));
      }
    }
  }

  /** Replaces HTML escape sequences such as &amp;amp; with their
   * associated characters.
   * @param input
   * @return String
   */
  public static String unescapeHtmlString(String input) {
    { int incursor = 0;
      int outcursor = 0;
      int escapestart = Native.string_position(input, '&', incursor);
      int escapeend = -1;
      int inputlength = -1;
      StringBuffer output = null;
      CharacterWrapper character = null;

      loop000 : for (;;) {
        if (escapestart == Stella.NULL_INTEGER) {
          if (output == null) {
            return (input);
          }
          else {
            break loop000;
          }
        }
        escapeend = Native.string_position(input, ';', escapestart);
        if (escapeend == Stella.NULL_INTEGER) {
          if (output == null) {
            return (input);
          }
          else {
            break loop000;
          }
        }
        character = ((CharacterWrapper)(Stella.$HTML_ESCAPE_TABLE$.lookup(StringWrapper.wrapString(Native.string_subsequence(input, escapestart + 1, escapeend)))));
        if (character == null) {
          escapestart = Native.string_position(input, '&', escapeend);
          continue loop000;
        }
        if (output == null) {
          inputlength = input.length();
          output = Stella.makeRawMutableString(inputlength);
        }
        while (incursor < escapestart) {
          edu.isi.stella.javalib.Native.mutableString_nthSetter(output, (input.charAt(incursor)), outcursor);
          incursor = incursor + 1;
          outcursor = outcursor + 1;
        }
        edu.isi.stella.javalib.Native.mutableString_nthSetter(output, (character.wrapperValue), outcursor);
        outcursor = outcursor + 1;
        incursor = escapeend + 1;
        escapestart = Native.string_position(input, '&', escapeend);
      }
      while (incursor < inputlength) {
        edu.isi.stella.javalib.Native.mutableString_nthSetter(output, (input.charAt(incursor)), outcursor);
        incursor = incursor + 1;
        outcursor = outcursor + 1;
      }
      return (Native.string_subsequence(output.toString(), 0, outcursor));
    }
  }

  /** Lookup logging <code>parameter</code> for <code>module</code>.  Use <code>renamed_Default</code> if no
   * value is defined.
   * @param module
   * @param parameter
   * @param renamed_Default
   * @return Stella_Object
   */
  public static Stella_Object lookupLoggingParameter(String module, Keyword parameter, Stella_Object renamed_Default) {
    { Stella_Object value = null;

      { StringWrapper mod = null;
        PropertyList props = null;
        KvCons iter000 = Stella.$LOGGING_REGISTRY$.theKvList;

        loop000 : for (;iter000 != null; iter000 = iter000.rest) {
          mod = ((StringWrapper)(iter000.key));
          props = ((PropertyList)(iter000.value));
          if (Stella.stringEqualP(module, mod.wrapperValue)) {
            { Stella_Object temp000 = props.lookup(parameter);

              value = ((temp000 != null) ? temp000 : renamed_Default);
            }
            break loop000;
          }
        }
      }
      return (value);
    }
  }

  /** Set logging parameters for <code>module</code>.  The supported parameters are:
   *   :LOG-LEVELS - a cons list of legal levels in ascending log level order;
   *                 for example, (:NONE :LOW :MEDIUM :HIGH) or (0 1 2 3).
   *   :LEVEL      - the current log level for <code>module</code>
   *   :STREAM     - the stream or file to log to (defaults to STANDARD-OUTPUT)
   *   :PREFIX     - the prefix to use to identify the module (defaults to <code>module</code>)
   *   :MAX-WIDTH  - logging output lines will be kept to approximately this width
   *                 (defaults to 10000, minimum width of about 30 is used to
   *                 print line header information).
   * @param module
   * @param paramsAvalues
   */
  public static void setLoggingParameters(String module, Cons paramsAvalues) {
    { PropertyList options = Stella_Object.vetOptions(paramsAvalues, Stella.getQuotedTree("((:LOG-LEVELS :LEVEL :STREAM :PREFIX :MAX-WIDTH) \"/STELLA\")", "/STELLA"));
      PropertyList loginfo = null;

      { StringWrapper mod = null;
        PropertyList props = null;
        KvCons iter000 = Stella.$LOGGING_REGISTRY$.theKvList;

        for (;iter000 != null; iter000 = iter000.rest) {
          mod = ((StringWrapper)(iter000.key));
          props = ((PropertyList)(iter000.value));
          if (Stella.stringEqualP(module, mod.wrapperValue)) {
            loginfo = props;
          }
        }
      }
      if (loginfo == null) {
        loginfo = PropertyList.newPropertyList();
        Stella.$LOGGING_REGISTRY$.insertAt(StringWrapper.wrapString(module), loginfo);
      }
      { Stella_Object key = null;
        Stella_Object value = null;
        Cons iter001 = options.thePlist;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest.rest) {
          key = iter001.value;
          value = iter001.rest.value;
          loginfo.insertAt(key, value);
        }
      }
    }
  }

  /** Set the log-level for <code>module</code> to <code>level</code>.  This is a
   * convenience function for this common operation.
   * @param module
   * @param level
   */
  public static void setLogLevel(String module, Stella_Object level) {
    Stella.setLoggingParameters(module, Cons.cons(Stella.KWD_LEVEL, Cons.cons(level, Stella.NIL)));
  }

  /** Increase the indentation level for subsequent log messages.
   */
  public static void bumpLogIndent() {
    Stella.$LOG_INDENT_LEVEL$ = Stella.$LOG_INDENT_LEVEL$ + 2;
  }

  /** Decrease the indentation level for subsequent log messages.
   */
  public static void unbumpLogIndent() {
    Stella.$LOG_INDENT_LEVEL$ = Stella.$LOG_INDENT_LEVEL$ - 2;
  }

  /** Return a valid log stream for <code>module</code>.
   * @param module
   * @return OutputStream
   */
  public static OutputStream getLogStream(String module) {
    { Stella_Object streamspec = Stella.lookupLoggingParameter(module, Stella.KWD_STREAM, Stella.STANDARD_OUTPUT);

      { Surrogate testValue000 = Stella_Object.safePrimaryType(streamspec);

        if (Surrogate.subtypeOfStringP(testValue000)) {
          { StringWrapper streamspec000 = ((StringWrapper)(streamspec));

            return (Stella.openOutputFile(streamspec000.wrapperValue, Cons.cons(Stella.KWD_IF_EXISTS, Cons.cons(Stella.KWD_APPEND, Cons.cons(Stella.KWD_IF_NOT_EXISTS, Cons.cons(Stella.KWD_CREATE, Stella.NIL))))));
          }
        }
        else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_OUTPUT_STREAM)) {
          { OutputStream streamspec000 = ((OutputStream)(streamspec));

            return (streamspec000);
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  /** Log all elements of <code>message</code> to <code>module</code>s log stream if
   * <code>loglevel</code> is the same or lower than the <code>module</code>s log level.  Interprets <code>EOL</code>
   * or :EOL to print a line terminator.
   * @param module
   * @param loglevel
   * @param message
   */
  public static void logMessage(String module, Stella_Object loglevel, Cons message) {
    if (Stella_Object.logLevelLE(loglevel, module)) {
      { OutputStream log = Stella.getLogStream(module);
        String moduleprefix = ((StringWrapper)(Stella.lookupLoggingParameter(module, Stella.KWD_PREFIX, StringWrapper.wrapString(module)))).wrapperValue;
        int maxroom = ((IntegerWrapper)(Stella.lookupLoggingParameter(module, Stella.KWD_MAX_WIDTH, IntegerWrapper.wrapInteger(10000)))).wrapperValue;
        int room = maxroom;
        String eltstring = null;

        try {
          log.nativeStream.print("[" + CalendarDate.makeCurrentDateTime().calendarDateToString(Stella.$LOGGING_LOCAL_TIME_ZONE$, false, false) + ((Stella.stringEqlP(moduleprefix, "") ? "" : " ")) + moduleprefix + "] ");
          { int i = Stella.NULL_INTEGER;
            int iter000 = 1;
            int upperBound000 = Stella.$LOG_INDENT_LEVEL$;
            boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

            for (;unboundedP000 ||
                      (iter000 <= upperBound000); iter000 = iter000 + 1) {
              i = iter000;
              i = i;
              log.nativeStream.print(" ");
            }
          }
          room = room - (27 + moduleprefix.length() + Stella.$LOG_INDENT_LEVEL$);
          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              { Stella_Object elt = null;
                Cons iter001 = message;

                loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                  elt = iter001.value;
                  { Surrogate testValue000 = Stella_Object.safePrimaryType(elt);

                    if (Surrogate.subtypeOfStringP(testValue000)) {
                      { StringWrapper elt000 = ((StringWrapper)(elt));

                        eltstring = elt000.wrapperValue;
                      }
                    }
                    else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_GENERALIZED_SYMBOL)) {
                      { GeneralizedSymbol elt000 = ((GeneralizedSymbol)(elt));

                        if (Stella.stringEqlP(elt000.symbolName, "EOL")) {
                          log.nativeStream.println();
                          room = maxroom;
                          continue loop001;
                        }
                        else {
                          eltstring = Native.stringify(elt000);
                        }
                      }
                    }
                    else {
                      eltstring = Native.stringify(elt);
                    }
                  }
                  if (room < eltstring.length()) {
                    log.nativeStream.print(Native.string_subsequence(eltstring, 0, room) + "...");
                  }
                  else {
                    log.nativeStream.print(eltstring);
                  }
                }
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
          log.nativeStream.println();
          OutputStream.flushOutput(log);

        } finally {
        }
        if (Stella_Object.isaP(log, Stella.SGT_STELLA_FILE_OUTPUT_STREAM)) {
          Stream.closeStream(log);
        }
      }
    }
  }

  /** Log all elements of <code>message</code> to <code>module</code>s log stream if
   * <code>loglevel</code> is the same or lower than the <code>module</code>s log level.  Interprets <code>EOL</code>
   * or :EOL to print a line terminator.
   * @param module
   * @param loglevel
   * @param message
   */
  public static void logmsg(String module, Stella_Object loglevel, Cons message) {
    Stella.logMessage(module, loglevel, message);
  }

  public static String lispNullArraySymbolString(int rank) {
    switch (rank) {
      case 1: 
        return ("STELLA::NULL-1D-ARRAY");
      case 2: 
        return ("STELLA::NULL-2D-ARRAY");
      case 3: 
        return ("STELLA::NULL-3D-ARRAY");
      case 4: 
        return ("STELLA::NULL-4D-ARRAY");
      case 5: 
        return ("STELLA::NULL-5D-ARRAY");
      default:
        return ("STELLA::NULL");
    }
  }

  public static void printNumericConstants() {
    {
      Stella.STANDARD_OUTPUT.nativeStream.println("MOST-POSITIVE-INTEGER:             " + Stella.MOST_POSITIVE_INTEGER);
      Stella.STANDARD_OUTPUT.nativeStream.println("MOST-NEGATIVE-INTEGER:            " + Stella.MOST_NEGATIVE_INTEGER);
      Stella.STANDARD_OUTPUT.nativeStream.println("NULL-INTEGER:                     " + Stella.NULL_INTEGER);
      Stella.STANDARD_OUTPUT.nativeStream.println("MOST-POSITIVE-LONG-INTEGER:        " + Stella.MOST_POSITIVE_LONG_INTEGER);
      Stella.STANDARD_OUTPUT.nativeStream.println("MOST-NEGATIVE-LONG-INTEGER:       " + Stella.MOST_NEGATIVE_LONG_INTEGER);
      Stella.STANDARD_OUTPUT.nativeStream.println("NULL-LONG-INTEGER:                " + Stella.NULL_LONG_INTEGER);
      Stella.STANDARD_OUTPUT.nativeStream.println("MOST-POSITIVE-FLOAT:               " + Stella.MOST_POSITIVE_FLOAT);
      Stella.STANDARD_OUTPUT.nativeStream.println("MOST-NEGATIVE-FLOAT:              " + Stella.MOST_NEGATIVE_FLOAT);
      Stella.STANDARD_OUTPUT.nativeStream.println("LEAST-POSITIVE-FLOAT:              " + Stella.LEAST_POSITIVE_FLOAT);
      Stella.STANDARD_OUTPUT.nativeStream.println("LEAST-NEGATIVE-FLOAT:             " + Stella.LEAST_NEGATIVE_FLOAT);
      Stella.STANDARD_OUTPUT.nativeStream.println("NULL-FLOAT:                       " + Stella.NULL_FLOAT);
      Stella.STANDARD_OUTPUT.nativeStream.println("*INTEGER-MSB-MASK*:                " + Stella.$INTEGER_MSB_MASK$);
      Stella.STANDARD_OUTPUT.nativeStream.println("*INTEGER-UNSIGNED-BITS-MASK*:      " + Stella.$INTEGER_UNSIGNED_BITS_MASK$);
      Stella.STANDARD_OUTPUT.nativeStream.println("*LONG-INTEGER-MSB-MASK*:           " + Stella.$LONG_INTEGER_MSB_MASK$);
      Stella.STANDARD_OUTPUT.nativeStream.println("*LONG-INTEGER-UNSIGNED-BITS-MASK*: " + Stella.$LONG_INTEGER_UNSIGNED_BITS_MASK$);
      Stella.STANDARD_OUTPUT.nativeStream.println("LONG-INTEGER-BIT-WIDTH:            " + Stella.LONG_INTEGER_BIT_WIDTH);
      Stella.STANDARD_OUTPUT.nativeStream.println("il(MOST-POSITIVE-INTEGER):         " + Stella.integerLength(((long)(Stella.MOST_POSITIVE_INTEGER))));
      Stella.STANDARD_OUTPUT.nativeStream.println("il(MOST-POSITIVE-LONG-INTEGER):    " + Stella.integerLength(Stella.MOST_POSITIVE_LONG_INTEGER));
      Stella.STANDARD_OUTPUT.nativeStream.println("il(MOST-NEGATIVE-INTEGER):         " + Stella.integerLength(((long)(Stella.MOST_NEGATIVE_INTEGER))));
      Stella.STANDARD_OUTPUT.nativeStream.println("il(MOST-NEGATIVE-LONG-INTEGER):    " + Stella.integerLength(Stella.MOST_NEGATIVE_LONG_INTEGER));
    }
;
  }

  /** Return true if <code>x</code> is 0.
   * @param x
   * @return boolean
   */
  public static boolean integer_zeroP(int x) {
    return ((x == 0));
  }

  /** Return true if <code>x</code> is 0.
   * @param x
   * @return boolean
   */
  public static boolean longInteger_zeroP(long x) {
    return ((x == 0));
  }

  /** Return true if <code>x</code> is greater than 0.
   * @param x
   * @return boolean
   */
  public static boolean integer_plusP(int x) {
    return ((x > 0));
  }

  /** Return true if <code>x</code> is greater than 0.
   * @param x
   * @return boolean
   */
  public static boolean longInteger_plusP(long x) {
    return ((x > 0));
  }

  /** Return true if <code>x</code> is an even number.
   * @param x
   * @return boolean
   */
  public static boolean integer_evenP(int x) {
    return (((x % 2) == 0));
  }

  /** Return true if <code>x</code> is an even number.
   * @param x
   * @return boolean
   */
  public static boolean longInteger_evenP(long x) {
    return (((x % 2) == 0));
  }

  /** Return true if <code>x</code> is an odd number.
   * @param x
   * @return boolean
   */
  public static boolean integer_oddP(int x) {
    return (((x % 2) == 1));
  }

  /** Return true if <code>x</code> is an odd number.
   * @param x
   * @return boolean
   */
  public static boolean longInteger_oddP(long x) {
    return (((x % 2) == 1));
  }

  /** Return the integer quotient from dividing <code>x</code> by <code>y</code>.
   * @param x
   * @param y
   * @return int
   */
  public static int integer_div(int x, int y) {
    return ((x / y));
  }

  /** Return the integer quotient from dividing <code>x</code> by <code>y</code>.
   * @param x
   * @param y
   * @return long
   */
  public static long longInteger_div(long x, long y) {
    return ((x / y));
  }

  /** Return the remainder from dividing <code>x</code> by <code>y</code>.  The
   * sign of the result is always the same as the sign of <code>x</code>.  This has slightly
   * different behavior than the <code>mod</code> function, and has less overhead in C++ and
   * Java, which don't have direct support for a true modulus function.
   * @param x
   * @param y
   * @return int
   */
  public static int integer_rem(int x, int y) {
    return ((x % y));
  }

  /** Return the remainder from dividing <code>x</code> by <code>y</code>.  The
   * sign of the result is always the same as the sign of <code>x</code>.  This has slightly
   * different behavior than the <code>mod</code> function, and has less overhead in C++ and
   * Java, which don't have direct support for a true modulus function.
   * @param x
   * @param y
   * @return long
   */
  public static long longInteger_rem(long x, long y) {
    return ((x % y));
  }

  /** Return the floating point remainder from dividing <code>x</code> by <code>y</code>.  The
   * sign of the result is always the same as the sign of <code>x</code>.  This has slightly
   * different behavior than the <code>mod</code> function, and has less overhead in C++ and
   * Java, which don't have direct support for a true modulus function.
   * @param x
   * @param y
   * @return double
   */
  public static double frem(double x, double y) {
    return ((x % y));
  }

  /** True modulus.  Return the result of <code>x</code> mod <code>modulo</code>.
   * Note: In C++ and Java, <code>mod</code> has more overhead than the similar
   * function <code>rem</code>.  The  answers returned by <code>mod</code> and <code>rem</code> are only
   * different when the signs of <code>x</code> and <code>modulo</code> are different.
   * @param x
   * @param modulus
   * @return int
   */
  public static int integer_mod(int x, int modulus) {
    { int remainder = (x % modulus);

      if (remainder > 0) {
        if (modulus < 0) {
          remainder = modulus + remainder;
        }
      }
      else if (remainder < 0) {
        if (modulus > 0) {
          remainder = modulus + remainder;
        }
      }
      return (remainder);
    }
  }

  /** True modulus.  Return the result of <code>x</code> mod <code>modulo</code>.
   * Note: In C++ and Java, <code>mod</code> has more overhead than the similar
   * function <code>rem</code>.  The  answers returned by <code>mod</code> and <code>rem</code> are only
   * different when the signs of <code>x</code> and <code>modulo</code> are different.
   * @param x
   * @param modulus
   * @return long
   */
  public static long longInteger_mod(long x, long modulus) {
    { long remainder = (x % modulus);

      if (remainder > 0) {
        if (modulus < 0) {
          remainder = modulus + remainder;
        }
      }
      else if (remainder < 0) {
        if (modulus > 0) {
          remainder = modulus + remainder;
        }
      }
      return (remainder);
    }
  }

  /** True modulus for floats.  Return the result of <code>x</code> mod <code>modulo</code>.
   * Note: In C++ and Java, <code>mod</code> has more overhead than the similar
   * function <code>rem</code>.  The  answers returned by <code>mod</code> and <code>rem</code> are only
   * different when the signs of <code>x</code> and <code>modulo</code> are different.
   * @param x
   * @param modulus
   * @return double
   */
  public static double fmod(double x, double modulus) {
    { double remainder = (x % modulus);

      if (remainder > 0.0) {
        if (modulus < 0.0) {
          remainder = modulus + remainder;
        }
      }
      else if (remainder < 0.0) {
        if (modulus > 0.0) {
          remainder = modulus + remainder;
        }
      }
      return (remainder);
    }
  }

  /** Return the greatest common divisor of <code>x</code> and <code>y</code>.
   * @param x
   * @param y
   * @return long
   */
  public static long gcd(long x, long y) {
    if (x < 0) {
      x = 0 - x;
    }
    if (y < 0) {
      y = 0 - y;
    }
    { long temp = 0l;

      while (!(y == 0)) {
        temp = (x % y);
        x = y;
        y = temp;
      }
      return (x);
    }
  }

  /** Return <code>true</code> if <code>x</code> can be represented by a regular integer.
   * @param x
   * @return boolean
   */
  public static boolean regularIntegerValuedP(long x) {
    return ((x >= Stella.NULL_INTEGER) &&
        (x <= Stella.MOST_POSITIVE_INTEGER));
  }

  /** Returns <code>true</code> if <code>x</code> is the floating point representation of an integer.
   * @param x
   * @return boolean
   */
  public static boolean integerValuedP(double x) {
    return (x == Math.floor(x));
  }

  /** Returns a cons of <code>x</code> in a base-60 form.  That means
   * the first value will be the integer part of <code>x</code>, the next value
   * the iteger value of the fraction part of <code>x</code> times 60 and the
   * third value the fraction part of <code>x</code> time 3600.  If <code>allIntegersP</code>
   * is <code>true</code>, then the last value will be rounded to an integer.
   * This can be used to convert from decimal degree values to Degree-Minute-Second
   * or from decimal hours to Hour-Minute-Second format.
   * @param x
   * @param allIntegersP
   * @return Cons
   */
  public static Cons floatToBase60(double x, boolean allIntegersP) {
    { int degree = Native.floor(x);
      int minute = Native.floor((x - degree) * 60.0);
      double fsecond = ((x * 3600.0) - (degree * 3600.0)) - (minute * 60.0);

      if (allIntegersP) {
        return (Cons.consList(Cons.cons(IntegerWrapper.wrapInteger(degree), Cons.cons(IntegerWrapper.wrapInteger(minute), Cons.cons(IntegerWrapper.wrapInteger(Native.round(fsecond)), Stella.NIL)))));
      }
      else {
        return (Cons.consList(Cons.cons(IntegerWrapper.wrapInteger(degree), Cons.cons(IntegerWrapper.wrapInteger(minute), Cons.cons(FloatWrapper.wrapFloat(fsecond), Stella.NIL)))));
      }
    }
  }

  /** Generate a random integer in the interval [0..n-1].
   * The random number generator is seeded based on the current time every
   * time STELLA starts up; however, your mileage may vary depending on
   * the native language implementation.
   * @param n
   * @return int
   */
  public static int random(int n) {
    { int rnum = Native.RNG.nextInt(n);

      return (rnum);
    }
  }

  /** Seeds the random number generator based on the current time.
   */
  public static void seedRandomNumberGenerator() {
    Native.RNG = new java.util.Random(System.currentTimeMillis() ^ System.nanoTime());
  }

  /** Return the square root of <code>n</code>.
   * @param n
   * @return double
   */
  public static double sqrt(double n) {
    return (Math.sqrt(n));
  }

  /** Return the cosine of <code>n</code> radians.
   * @param n
   * @return double
   */
  public static double cos(double n) {
    return (Math.cos(n));
  }

  /** Return the sine of <code>n</code> radians.
   * @param n
   * @return double
   */
  public static double sin(double n) {
    return (Math.sin(n));
  }

  /** Return the tangent of <code>n</code> radians.
   * @param n
   * @return double
   */
  public static double tan(double n) {
    return (Math.tan(n));
  }

  /** Return the arccosine of <code>n</code> in radians.
   * @param n
   * @return double
   */
  public static double acos(double n) {
    return (Math.acos(n));
  }

  /** Return the arcsine of <code>n</code> in radians.
   * @param n
   * @return double
   */
  public static double asin(double n) {
    return (Math.asin(n));
  }

  /** Return the arc tangent of <code>n</code> in radians.
   * @param n
   * @return double
   */
  public static double atan(double n) {
    return (Math.atan(n));
  }

  /** Return the arc tangent of <code>x</code> / <code>y</code> in radians.
   * @param x
   * @param y
   * @return double
   */
  public static double atan2(double x, double y) {
    return (Math.atan2(x,y));
  }

  /** Return the natural logarithm (base e) of <code>n</code>.
   * @param n
   * @return double
   */
  public static double log(double n) {
    return (Math.log(n));
  }

  /** Return the logarithm (base 2) of <code>n</code>.
   * @param n
   * @return double
   */
  public static double log2(double n) {
    return (Math.log(n) * Stella.RECIPROCAL_NL2);
  }

  /** Return the logarithm (base 10) of <code>n</code>.
   * @param n
   * @return double
   */
  public static double log10(double n) {
    return (Math.log(n) * Stella.RECIPROCAL_NL10);
  }

  /** Return the e to the power <code>n</code>.
   * @param n
   * @return double
   */
  public static double exp(double n) {
    return (Math.exp(n));
  }

  /** Return <code>x</code> ^ <code>y</code>.
   * @param x
   * @param y
   * @return double
   */
  public static double expt(double x, double y) {
    return (Math.pow(x,y));
  }

  /** Return the minimum of <code>x</code> and <code>y</code>.  If either is NULL, return the other.
   * @param x
   * @param y
   * @return int
   */
  public static int integer_min(int x, int y) {
    return (((x > y) ? (((y == Stella.NULL_INTEGER) ? x : y)) : (((x == Stella.NULL_INTEGER) ? y : x))));
  }

  /** Return the minimum of <code>x</code> and <code>y</code>.  If either is NULL, return the other.
   * @param x
   * @param y
   * @return long
   */
  public static long longInteger_min(long x, long y) {
    return (((x > y) ? (((y == Stella.NULL_LONG_INTEGER) ? x : y)) : (((x == Stella.NULL_LONG_INTEGER) ? y : x))));
  }

  /** Return the minimum of <code>x</code> and <code>y</code>.  If either is NULL, return the other.
   * @param x
   * @param y
   * @return double
   */
  public static double float_min(double x, double y) {
    return (((x > y) ? (((y == Stella.NULL_FLOAT) ? x : y)) : (((x == Stella.NULL_FLOAT) ? y : x))));
  }

  /** Return the maximum of <code>x</code> and <code>y</code>.  If either is NULL, return the other.
   * @param x
   * @param y
   * @return int
   */
  public static int integer_max(int x, int y) {
    return (((x > y) ? x : y));
  }

  /** Return the maximum of <code>x</code> and <code>y</code>.  If either is NULL, return the other.
   * @param x
   * @param y
   * @return long
   */
  public static long longInteger_max(long x, long y) {
    return (((x > y) ? x : y));
  }

  /** Return the maximum of <code>x</code> and <code>y</code>.  If either is NULL, return the other.
   * @param x
   * @param y
   * @return double
   */
  public static double float_max(double x, double y) {
    return (((x > y) ? x : y));
  }

  /** Return the absolute value of <code>x</code>.
   * @param x
   * @return int
   */
  public static int integer_abs(int x) {
    return (((x < 0) ? (0 - x) : x));
  }

  /** Return the absolute value of <code>x</code>.
   * @param x
   * @return long
   */
  public static long longInteger_abs(long x) {
    return (((x < 0) ? (0 - x) : x));
  }

  /** Return the absolute value of <code>x</code>.
   * @param x
   * @return double
   */
  public static double float_abs(double x) {
    return (((x < 0.0) ? (0.0 - x) : x));
  }

  /** Return the 8-bit ASCII code of <code>ch</code> as an integer.
   * @param ch
   * @return int
   */
  public static int characterCode(char ch) {
    return ((int) ch);
  }

  /** Return the character encoded by <code>code</code> (0 &lt;= <code>code</code> &lt;= 255).
   * @param code
   * @return char
   */
  public static char codeCharacter(int code) {
    return ((char) code);
  }

  /** If <code>ch</code> is lowercase, return its uppercase version,
   * otherwise, return 'ch' unmodified.
   * @param ch
   * @return char
   */
  public static char characterDowncase(char ch) {
    return (Stella.$CHARACTER_DOWNCASE_TABLE$.charAt(((int) ch)));
  }

  /** If <code>ch</code> is uppercase, return its lowercase version,
   * otherwise, return 'ch' unmodified.  If only the first character of
   * a sequence of characters is to be capitalized, <code>characterCapitalize</code>
   * should be used instead.
   * @param ch
   * @return char
   */
  public static char characterUpcase(char ch) {
    return (Stella.$CHARACTER_UPCASE_TABLE$.charAt(((int) ch)));
  }

  /** Return the capitalized character for <code>ch</code>.  This is generally the same
   * as the uppercase character, except for obscure non-English characters in Java.  It should
   * be used if only the first character of a sequence of characters is to be capitalized.
   * @param ch
   * @return char
   */
  public static char characterCapitalize(char ch) {
    return (Character.toTitleCase(ch));
  }

  /** Return true if <code>x</code> and <code>y</code> are equal strings or are both undefined.  This
   * test is substituted automatically by the STELLA translator if <code>eqlP</code> is applied
   * to strings.
   * @param x
   * @param y
   * @return boolean
   */
  public static boolean stringEqlP(String x, String y) {
    if (x == null) {
      return (y == null);
    }
    else {
      return ((y != null) &&
          x.equals(y));
    }
  }

  /** Return true if <code>x</code> and <code>y</code> are equal strings ignoring character case or
   * are both undefined.
   * @param x
   * @param y
   * @return boolean
   */
  public static boolean stringEqualP(String x, String y) {
    if (x == null) {
      return (y == null);
    }
    else {
      return ((y != null) &&
          x.equalsIgnoreCase(y));
    }
  }

  /** Compare <code>x</code> and <code>y</code> lexicographically, and return -1, 0, 
   * or 1, depending on whether <code>x</code> is less than, equal, or greater than <code>y</code>.
   * If <code>caseSensitiveP</code> is true, then case does matter for the comparison
   * @param x
   * @param y
   * @param caseSensitiveP
   * @return int
   */
  public static int stringCompare(String x, String y, boolean caseSensitiveP) {
    if (caseSensitiveP) {
      return (x.compareTo(y));
    }
    else {
      return (x.compareToIgnoreCase(y));
    }
  }

  /** Return true if <code>x</code> is the empty string &quot;&quot;
   * @param x
   * @return boolean
   */
  public static boolean string_emptyP(String x) {
    return (Stella.stringEqlP(x, ""));
  }

  /** Return true if <code>x</code> is not the empty string &quot;&quot;
   * @param x
   * @return boolean
   */
  public static boolean string_nonEmptyP(String x) {
    return (!Stella.stringEqlP(x, ""));
  }

  /** Return true if <code>string</code> is either NULL, empty, or only
   * contains white space characters.
   * @param string
   * @return boolean
   */
  public static boolean blankStringP(String string) {
    { boolean testValue000 = false;

      if (string == null) {
        testValue000 = true;
      }
      else {
        if (Stella.stringEqlP(string, "")) {
          testValue000 = true;
        }
        else {
          { boolean alwaysP000 = true;

            { char renamed_Char = Stella.NULL_CHARACTER;
              String vector000 = string;
              int index000 = 0;
              int length000 = vector000.length();

              loop000 : for (;index000 < length000; index000 = index000 + 1) {
                renamed_Char = vector000.charAt(index000);
                if (!(Stella.$CHARACTER_TYPE_TABLE$[(int) renamed_Char] == Stella.KWD_WHITE_SPACE)) {
                  alwaysP000 = false;
                  break loop000;
                }
              }
            }
            testValue000 = alwaysP000;
          }
        }
      }
      { boolean value000 = testValue000;

        return (value000);
      }
    }
  }

  /** Return true if <code>x</code> is lexicographically &lt; <code>y</code>, considering case.
   * @param x
   * @param y
   * @return boolean
   */
  public static boolean stringL(String x, String y) {
    return (Stella.stringCompare(x, y, true) < 0);
  }

  /** Return true if <code>x</code> is lexicographically &lt;= <code>y</code>, considering case.
   * @param x
   * @param y
   * @return boolean
   */
  public static boolean stringLE(String x, String y) {
    return (Stella.stringCompare(x, y, true) <= 0);
  }

  /** Return true if <code>x</code> is lexicographically &gt;= <code>y</code>, considering case.
   * @param x
   * @param y
   * @return boolean
   */
  public static boolean stringGE(String x, String y) {
    return (Stella.stringCompare(x, y, true) >= 0);
  }

  /** Return true if <code>x</code> is lexicographically &gt; <code>y</code>, considering case.
   * @param x
   * @param y
   * @return boolean
   */
  public static boolean stringG(String x, String y) {
    return (Stella.stringCompare(x, y, true) > 0);
  }

  /** Return true if <code>x</code> is lexicographically &lt; <code>y</code>, ignoring case.
   * @param x
   * @param y
   * @return boolean
   */
  public static boolean stringLessP(String x, String y) {
    return (Stella.stringCompare(x, y, false) < 0);
  }

  /** Return true if <code>x</code> is lexicographically &lt;= <code>y</code>, ignoring case.
   * @param x
   * @param y
   * @return boolean
   */
  public static boolean stringLessEqualP(String x, String y) {
    return (Stella.stringCompare(x, y, false) <= 0);
  }

  /** Return true if <code>x</code> is lexicographically &gt;= <code>y</code>, ignoring case.
   * @param x
   * @param y
   * @return boolean
   */
  public static boolean stringGreaterEqualP(String x, String y) {
    return (Stella.stringCompare(x, y, false) >= 0);
  }

  /** Return true if <code>x</code> is lexicographically &gt; <code>y</code>, ignoring case.
   * @param x
   * @param y
   * @return boolean
   */
  public static boolean stringGreaterP(String x, String y) {
    return (Stella.stringCompare(x, y, false) > 0);
  }

  /** Compare <code>x</code> and <code>y</code> and return -1, 0, or 1, depending on whether
   * <code>x</code> is less than, equal, or greater than <code>y</code> relative to the :ascii-case-normalized
   * collation.  In this collation <code>a_L_A_L_b</code> which gives strings that only differ in case a
   * definite order while otherwise behaving identically to :ascii-case-insensitive.  This is
   * similar to using a Java Collator for Locale.US with strength set to TERTIARY (which see).
   * @param x
   * @param y
   * @return int
   */
  public static int stringCompareCaseNormalized(String x, String y) {
    { int xlength = x.length();
      int ylength = y.length();
      char xch = Stella.NULL_CHARACTER;
      char ych = Stella.NULL_CHARACTER;

      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = Stella.integer_min(xlength, ylength) - 1;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          xch = x.charAt(i);
          ych = y.charAt(i);
          if (!(xch == ych)) {
            { char xchdown = Stella.$CHARACTER_DOWNCASE_TABLE$.charAt(((int) xch));
              char ychdown = Stella.$CHARACTER_DOWNCASE_TABLE$.charAt(((int) ych));

              if (xchdown == ychdown) {
                if ((int) xch < (int) ych) {
                  return (1);
                }
                else {
                  return (-1);
                }
              }
              else {
                if ((int) xchdown < (int) ychdown) {
                  return (-1);
                }
                else {
                  return (1);
                }
              }
            }
          }
        }
      }
      if (xlength == ylength) {
        return (0);
      }
      else if (xlength < ylength) {
        return (-1);
      }
      else {
        return (1);
      }
    }
  }

  /** Compare <code>x</code> and <code>y</code> and return -1, 0, or 1, depending on whether
   * <code>x</code> is less than, equal, or greater than <code>y</code> relative to <code>collation</code>.  Currently
   * supported values for <code>collation</code> are :ascii-case-sensitive, :ascii-case-insensitive
   * :ascii-case-normalized.  The first two correspond to <code>stringCompare</code> called with
   * the appropriate third argument.  :ascii-case-normalized calls the function
   * <code>stringCompareCaseNormalized</code> (which see).
   * @param x
   * @param y
   * @param collation
   * @return int
   */
  public static int compareStrings(String x, String y, Keyword collation) {
    if (collation == Stella.KWD_ASCII_CASE_SENSITIVE) {
      return (Stella.stringCompare(x, y, true));
    }
    else if (collation == Stella.KWD_ASCII_CASE_INSENSITIVE) {
      return (Stella.stringCompare(x, y, false));
    }
    else if (collation == Stella.KWD_ASCII_CASE_NORMALIZED) {
      return (Stella.stringCompareCaseNormalized(x, y));
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("compare-strings: unsupported collation: `" + collation + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  /** Variant of <code>compareStrings</code> that also tolerates NULL values.
   * NULL sorts after everything else in any collation.
   * @param x
   * @param y
   * @param collation
   * @return int
   */
  public static int safeCompareStrings(String x, String y, Keyword collation) {
    if (x == null) {
      if (y == null) {
        return (0);
      }
      else {
        return (1);
      }
    }
    else if (y == null) {
      return (-1);
    }
    else {
      return (Stella.compareStrings(x, y, collation));
    }
  }

  /** Return a new mutable string filled with <code>size</code> <code>initchar</code>s.
   * @param size
   * @param initchar
   * @return StringBuffer
   */
  public static StringBuffer makeMutableString(int size, char initchar) {
    return (edu.isi.stella.javalib.Native.makeMutableString(size, initchar));
  }

  /** Return a new uninitialized mutable string of <code>size</code>.
   * @param size
   * @return StringBuffer
   */
  public static StringBuffer makeRawMutableString(int size) {
    { StringBuffer s = null;

      s = new StringBuffer(size); s.setLength(size);
      return (s);
    }
  }

  /** Return a new string representing the concatenation
   * of <code>string1</code>, <code>string2</code>, and <code>otherstrings</code>.  The two mandatory parameters
   * allow us to optimize the common binary case by not relying on the somewhat
   * less efficient variable arguments mechanism.
   * @param string1
   * @param string2
   * @param otherstrings
   * @return String
   */
  public static String string_concatenate(String string1, String string2, Cons otherstrings) {
    if (otherstrings.length() == 0) {
      return (Native.stringConcatenate(string1, string2));
    }
    { StringBuffer result = null;
      int length = string1.length() + string2.length();
      int index = 0;

      { String string = null;
        Cons iter000 = otherstrings;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          string = ((StringWrapper)(iter000.value)).wrapperValue;
          length = length + string.length();
        }
      }
      result = Stella.makeRawMutableString(length);
      { char ch = Stella.NULL_CHARACTER;
        String vector000 = string1;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          ch = vector000.charAt(index000);
          edu.isi.stella.javalib.Native.mutableString_nthSetter(result, ch, index);
          index = index + 1;
        }
      }
      { char ch = Stella.NULL_CHARACTER;
        String vector001 = string2;
        int index001 = 0;
        int length001 = vector001.length();

        for (;index001 < length001; index001 = index001 + 1) {
          ch = vector001.charAt(index001);
          edu.isi.stella.javalib.Native.mutableString_nthSetter(result, ch, index);
          index = index + 1;
        }
      }
      { String string = null;
        Cons iter001 = otherstrings;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          string = ((StringWrapper)(iter001.value)).wrapperValue;
          { char ch = Stella.NULL_CHARACTER;
            String vector002 = string;
            int index002 = 0;
            int length002 = vector002.length();

            for (;index002 < length002; index002 = index002 + 1) {
              ch = vector002.charAt(index002);
              edu.isi.stella.javalib.Native.mutableString_nthSetter(result, ch, index);
              index = index + 1;
            }
          }
        }
      }
      return (result.toString());
    }
  }

  static StringBuffer helpSubstituteCharacters(StringBuffer self, String newChars, String oldChars) {
    { int pos = Stella.NULL_INTEGER;

      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = self.length() - 1;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          pos = Native.string_position(oldChars, self.charAt(i), 0);
          if (pos != Stella.NULL_INTEGER) {
            edu.isi.stella.javalib.Native.mutableString_nthSetter(self, (newChars.charAt(pos)), i);
          }
        }
      }
      return (self);
    }
  }

  /** Substitute all occurences of of a member of <code>oldChars</code> with the 
   * corresponding member of <code>newChars</code> in the string <code>self</code>.  IMPORTANT:  The return
   * value should be used instead of relying on destructive substitution, since the
   * substitution will not be destructive in all translated languages.
   * @param self
   * @param newChars
   * @param oldChars
   * @return StringBuffer
   */
  public static StringBuffer mutableString_substituteCharacters(StringBuffer self, String newChars, String oldChars) {
    return (Stella.helpSubstituteCharacters(self, newChars, oldChars));
  }

  /** Substitute all occurences of of a member of <code>oldChars</code> with the 
   * corresponding member of <code>newChars</code> in the string <code>self</code>.  Returns a new string.
   * @param self
   * @param newChars
   * @param oldChars
   * @return String
   */
  public static String string_substituteCharacters(String self, String newChars, String oldChars) {
    return ((Stella.helpSubstituteCharacters(new StringBuffer(self), newChars, oldChars)).toString());
  }

  /** Replace all occurrences of <code>old</code> in <code>string</code> with <code>renamed_New</code>.
   * @param string
   * @param renamed_New
   * @param old
   * @return String
   */
  public static String replaceSubstrings(String string, String renamed_New, String old) {
    { int stringlength = string.length();
      int oldlength = old.length();
      int newlength = renamed_New.length();
      int nofoccurrences = 0;
      int oldstart = 0;
      int cursor = 0;
      int resultcursor = 0;
      StringBuffer result = null;

      while ((oldstart = Native.stringSearch(string, old, cursor)) != Stella.NULL_INTEGER) {
        nofoccurrences = nofoccurrences + 1;
        cursor = oldstart + oldlength;
      }
      if (nofoccurrences == 0) {
        return (string);
      }
      result = Stella.makeRawMutableString(stringlength + (nofoccurrences * (newlength - oldlength)));
      cursor = 0;
      while ((oldstart = Native.stringSearch(string, old, cursor)) != Stella.NULL_INTEGER) {
        { int i = Stella.NULL_INTEGER;
          int iter000 = cursor;
          int upperBound000 = oldstart - 1;

          for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
            i = iter000;
            edu.isi.stella.javalib.Native.mutableString_nthSetter(result, (string.charAt(i)), resultcursor);
            resultcursor = resultcursor + 1;
          }
        }
        { char renamed_Char = Stella.NULL_CHARACTER;
          String vector000 = renamed_New;
          int index000 = 0;
          int length000 = vector000.length();

          for (;index000 < length000; index000 = index000 + 1) {
            renamed_Char = vector000.charAt(index000);
            edu.isi.stella.javalib.Native.mutableString_nthSetter(result, renamed_Char, resultcursor);
            resultcursor = resultcursor + 1;
          }
        }
        cursor = oldstart + oldlength;
      }
      { int i = Stella.NULL_INTEGER;
        int iter001 = cursor;
        int upperBound001 = stringlength - 1;

        for (;iter001 <= upperBound001; iter001 = iter001 + 1) {
          i = iter001;
          edu.isi.stella.javalib.Native.mutableString_nthSetter(result, (string.charAt(i)), resultcursor);
          resultcursor = resultcursor + 1;
        }
      }
      return (result.toString());
    }
  }

  /** For each occurrence of a &lt;var&gt; string from <code>varsAvalues</code> in <code>template</code> replace it
   * with its corresponding &lt;value&gt; string.  Replacement is done in sequence which
   * means (part of) a value might be replaced further with a later &lt;var&gt; and &lt;value&gt;.
   * @param template
   * @param varsAvalues
   * @return String
   */
  public static String instantiateStringTemplate(String template, Cons varsAvalues) {
    { String var = null;

      { String item = null;
        Cons iter000 = varsAvalues;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          item = ((StringWrapper)(iter000.value)).wrapperValue;
          if (var != null) {
            template = Stella.replaceSubstrings(template, item, var);
            var = null;
          }
          else {
            var = item;
          }
        }
      }
      return (template);
    }
  }

  /** Inserts characters from <code>source</code> begining at <code>start</code> and
   * ending at <code>end</code> into <code>target</code> starting at <code>targetIndex</code>.  If <code>end</code> is <code>null</code>,
   * then the entire length of the string is used. The copy of characters is affected
   * by the <code>caseConversion</code> keyword which should be one of
   *    :UPCASE :DOWNCASE :CAPITALIZE :PRESERVE.
   * <p>
   * The final value of target-index is returned.
   * @param source
   * @param start
   * @param end
   * @param target
   * @param targetIndex
   * @param caseConversion
   * @return int
   */
  public static int insertString(String source, int start, int end, StringBuffer target, int targetIndex, Keyword caseConversion) {
    if (end == Stella.NULL_INTEGER) {
      end = source.length() - 1;
    }
    if (end < start) {
      return (targetIndex);
    }
    if (caseConversion == Stella.KWD_UPCASE) {
      { int j = Stella.NULL_INTEGER;
        int iter000 = start;
        int upperBound000 = end;
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

        for (;unboundedP000 ||
                  (iter000 <= upperBound000); iter000 = iter000 + 1) {
          j = iter000;
          edu.isi.stella.javalib.Native.mutableString_nthSetter(target, (Stella.$CHARACTER_UPCASE_TABLE$.charAt(((int) (source.charAt(j))))), targetIndex);
          targetIndex = targetIndex + 1;
        }
      }
    }
    else if (caseConversion == Stella.KWD_DOWNCASE) {
      { int j = Stella.NULL_INTEGER;
        int iter001 = start;
        int upperBound001 = end;
        boolean unboundedP001 = upperBound001 == Stella.NULL_INTEGER;

        for (;unboundedP001 ||
                  (iter001 <= upperBound001); iter001 = iter001 + 1) {
          j = iter001;
          edu.isi.stella.javalib.Native.mutableString_nthSetter(target, (Stella.$CHARACTER_DOWNCASE_TABLE$.charAt(((int) (source.charAt(j))))), targetIndex);
          targetIndex = targetIndex + 1;
        }
      }
    }
    else if (caseConversion == Stella.KWD_CAPITALIZE) {
      edu.isi.stella.javalib.Native.mutableString_nthSetter(target, (Stella.$CHARACTER_UPCASE_TABLE$.charAt(((int) (source.charAt(start))))), targetIndex);
      targetIndex = targetIndex + 1;
      { int j = Stella.NULL_INTEGER;
        int iter002 = start + 1;
        int upperBound002 = end;
        boolean unboundedP002 = upperBound002 == Stella.NULL_INTEGER;

        for (;unboundedP002 ||
                  (iter002 <= upperBound002); iter002 = iter002 + 1) {
          j = iter002;
          edu.isi.stella.javalib.Native.mutableString_nthSetter(target, (Stella.$CHARACTER_DOWNCASE_TABLE$.charAt(((int) (source.charAt(j))))), targetIndex);
          targetIndex = targetIndex + 1;
        }
      }
    }
    else if (caseConversion == Stella.KWD_PRESERVE) {
      { int j = Stella.NULL_INTEGER;
        int iter003 = start;
        int upperBound003 = end;
        boolean unboundedP003 = upperBound003 == Stella.NULL_INTEGER;

        for (;unboundedP003 ||
                  (iter003 <= upperBound003); iter003 = iter003 + 1) {
          j = iter003;
          edu.isi.stella.javalib.Native.mutableString_nthSetter(target, (source.charAt(j)), targetIndex);
          targetIndex = targetIndex + 1;
        }
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + caseConversion + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    return (targetIndex);
  }

  /** Remove any leading and trailing white space from <code>string</code>
   * and return a copy of the trimmed substring (which might be empty if we had
   * all white space).  If no white space was removed, <code>string</code> is returned
   * unmodified and uncopied.
   * @param string
   * @return String
   */
  public static String stringTrim(String string) {
    { int start = 0;
      int last = string.length() - 1;
      int end = last;

      while ((start <= end) &&
          (Stella.$CHARACTER_TYPE_TABLE$[(int) (string.charAt(start))] == Stella.KWD_WHITE_SPACE)) {
        start = start + 1;
      }
      while ((end > start) &&
          (Stella.$CHARACTER_TYPE_TABLE$[(int) (string.charAt(end))] == Stella.KWD_WHITE_SPACE)) {
        end = end - 1;
      }
      if ((start > 0) ||
          (end < last)) {
        return (Native.string_subsequence(string, start, end + 1));
      }
      else {
        return (string);
      }
    }
  }

  /** Convert <code>i</code> to its string representation and return the result.
   * This is a convenience function that expects regular integers as opposed to longs
   * which is useful in contexts where we do automatic unwrapping based on the target.
   * @param i
   * @return String
   */
  public static String intToString(int i) {
    return (Native.integerToString(((long)(i))));
  }

  /** Convert <code>c</code> into a one-element string and return the result.
   * @param c
   * @return String
   */
  public static String characterToString(char c) {
    return (Native.makeString(1, c));
  }

  /** STELLA version of <code>integerToStringInBase</code> which is faster than
   * the C++ version we have but slower than the native Java version.
   * @param integer
   * @param base
   * @return String
   */
  public static String stellaIntegerToStringInBase(long integer, int base) {
    if (!((base >= 2) &&
        (base <= 36))) {
      System.err.print("Safety violation: integer-to-string-in-base: illegal base: `" + base + "'");
    }
    if (integer == 0) {
      return ("0");
    }
    { int offset = ((integer < 0) ? 1 : 0);

      if (offset == 1) {
        integer = 0 - integer;
      }
      { int integerbits = Stella.integerLength(integer);
        int basebits = Stella.integerLength(((long)(base)));
        int bufferlength = offset + (integerbits / (basebits - 1)) + 1;
        StringBuffer buffer = Stella.makeRawMutableString(bufferlength);
        int index = bufferlength;
        String table = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        long remainder = 0l;
        int digit = 0;
        int base1 = base - 1;

        if ((base & base1) == 0) {
          basebits = basebits - 1;
          while (integer > 0) {
            index = index - 1;
            digit = ((int)((integer & (((long)(base1))))));
            integer = (integer >> basebits);
            edu.isi.stella.javalib.Native.mutableString_nthSetter(buffer, (table.charAt(digit)), index);
          }
        }
        else {
          while (integer > 0) {
            index = index - 1;
            remainder = (integer / (((long)(base))));
            digit = ((int)(integer - (remainder * base)));
            integer = remainder;
            edu.isi.stella.javalib.Native.mutableString_nthSetter(buffer, (table.charAt(digit)), index);
          }
        }
        if (offset == 1) {
          index = index - 1;
          edu.isi.stella.javalib.Native.mutableString_nthSetter(buffer, '-', index);
        }
        if (index == 0) {
          return (buffer.toString());
        }
        else {
          return (Native.mutableString_subsequence(buffer, index, bufferlength));
        }
      }
    }
  }

  /** Convert a <code>string</code> representation of an integer into an integer.
   * This is a convenience function that ensures a regular integer return value.  If
   * <code>string</code> represents a long integer, the behavior is undefined.  Use <code>parseInteger</code>
   * if the syntax of <code>string</code> needs to be checked for errors.
   * @param string
   * @return int
   */
  public static int stringToInt(String string) {
    return (((int)(Native.stringToInteger(string))));
  }

  /** Formats <code>input</code> to be (at least) <code>length</code> long, using <code>padchar</code> to
   * fill if necessary.  <code>align</code> must be one of :LEFT, :RIGHT, :CENTER and will control
   * how <code>input</code> will be justified in the resulting string.  If <code>truncateP</code> is true, then
   * then an overlength string will be truncated, using the opposite of <code>align</code> to pick
   * the truncation direction.
   * @param input
   * @param length
   * @param padchar
   * @param align
   * @param truncateP
   * @return String
   */
  public static String formatWithPadding(String input, int length, char padchar, Keyword align, boolean truncateP) {
    { int len = input.length();

      if (len == length) {
        return (input);
      }
      else if (len > length) {
        if (truncateP) {
          if (align == Stella.KWD_LEFT) {
            return (Native.string_subsequence(input, len - length, len));
          }
          else if (align == Stella.KWD_RIGHT) {
            return (Native.string_subsequence(input, 0, len - length));
          }
          else if (align == Stella.KWD_CENTER) {
            { int left = ((int)((len - length) / 2.0));

              return (Native.string_subsequence(input, left, left + length));
            }
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + align + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }
        else {
          return (input);
        }
      }
      else {
        if (align == Stella.KWD_LEFT) {
          return (input + Native.makeString(length - len, padchar));
        }
        else if (align == Stella.KWD_RIGHT) {
          return (Native.makeString(length - len, padchar) + input);
        }
        else if (align == Stella.KWD_CENTER) {
          { int left = ((int)((length - len) / 2.0));

            return (Native.makeString(left, padchar) + input + Native.makeString((length - len) - left, padchar));
          }
        }
        else {
          { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

            stream001.nativeStream.print("`" + align + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  /** Returns a string representing <code>value</code> of at least length
   * 'size', padded if necessary with 0 characters.
   * @param value
   * @param size
   * @return String
   */
  public static String zeroPadInteger(int value, int size) {
    return (((value < 0) ? ("-" + Stella.formatWithPadding(Native.integerToString(((long)(0 - value))), size - 1, '0', Stella.KWD_RIGHT, false)) : Stella.formatWithPadding(Native.integerToString(((long)(value))), size, '0', Stella.KWD_RIGHT, false)));
  }

  static String zeroPadString(String input, int size) {
    return (Stella.formatWithPadding(input, size, '0', Stella.KWD_RIGHT, false));
  }

  /** Return the first character of <code>self</code>.
   * @param self
   * @return char
   */
  public static char string_first(String self) {
    return (self.charAt(0));
  }

  /** Return the first character of <code>self</code> (settable via <code>setf</code>).
   * @param self
   * @return char
   */
  public static char mutableString_first(StringBuffer self) {
    return (self.charAt(0));
  }

  /** Set the first character of <code>self</code> to <code>ch</code> and return <code>ch</code>.
   * @param self
   * @param ch
   * @return char
   */
  public static char mutableString_firstSetter(StringBuffer self, char ch) {
    return (edu.isi.stella.javalib.Native.mutableString_nthSetter(self, ch, 0));
  }

  /** Return the second character of <code>self</code>.
   * @param self
   * @return char
   */
  public static char string_second(String self) {
    return (self.charAt(1));
  }

  /** Return the second character of <code>self</code> (settable via <code>setf</code>).
   * @param self
   * @return char
   */
  public static char mutableString_second(StringBuffer self) {
    return (self.charAt(1));
  }

  /** Set the second character of <code>self</code> to <code>ch</code> and return <code>ch</code>.
   * @param self
   * @param ch
   * @return char
   */
  public static char mutableString_secondSetter(StringBuffer self, char ch) {
    return (edu.isi.stella.javalib.Native.mutableString_nthSetter(self, ch, 1));
  }

  /** Return the third character of <code>self</code>.
   * @param self
   * @return char
   */
  public static char string_third(String self) {
    return (self.charAt(2));
  }

  /** Return the third character of <code>self</code> (settable via <code>setf</code>).
   * @param self
   * @return char
   */
  public static char mutableString_third(StringBuffer self) {
    return (self.charAt(2));
  }

  /** Set the third character of <code>self</code> to <code>ch</code> and return <code>ch</code>.
   * @param self
   * @param ch
   * @return char
   */
  public static char mutableString_thirdSetter(StringBuffer self, char ch) {
    return (edu.isi.stella.javalib.Native.mutableString_nthSetter(self, ch, 2));
  }

  /** Return the fourth character of <code>self</code>.
   * @param self
   * @return char
   */
  public static char string_fourth(String self) {
    return (self.charAt(3));
  }

  /** Return the fourth character of <code>self</code> (settable via <code>setf</code>).
   * @param self
   * @return char
   */
  public static char mutableString_fourth(StringBuffer self) {
    return (self.charAt(3));
  }

  /** Set the fourth character of <code>self</code> to <code>ch</code> and return <code>ch</code>.
   * @param self
   * @param ch
   * @return char
   */
  public static char mutableString_fourthSetter(StringBuffer self, char ch) {
    return (edu.isi.stella.javalib.Native.mutableString_nthSetter(self, ch, 3));
  }

  /** Return the fifth character of <code>self</code>.
   * @param self
   * @return char
   */
  public static char string_fifth(String self) {
    return (self.charAt(4));
  }

  /** Return the fifth character of <code>self</code> (settable via <code>setf</code>).
   * @param self
   * @return char
   */
  public static char mutableString_fifth(StringBuffer self) {
    return (self.charAt(4));
  }

  /** Set the fifth character of <code>self</code> to <code>ch</code> and return <code>ch</code>.
   * @param self
   * @param ch
   * @return char
   */
  public static char mutableString_fifthSetter(StringBuffer self, char ch) {
    return (edu.isi.stella.javalib.Native.mutableString_nthSetter(self, ch, 4));
  }

  /** Return the character in <code>self</code> at <code>position</code>.
   * @param self
   * @param position
   * @return char
   */
  public static char string_nth(String self, int position) {
    return (self.charAt(position));
  }

  /** Return the character in <code>self</code> at <code>position</code>.
   * @param self
   * @param position
   * @return char
   */
  public static char mutableString_nth(StringBuffer self, int position) {
    return (self.charAt(position));
  }

  /** Set the character in <code>self</code> at <code>position</code> to <code>ch</code>.
   * @param self
   * @param ch
   * @param position
   * @return char
   */
  public static char mutableString_nthSetter(StringBuffer self, char ch, int position) {
    return (edu.isi.stella.javalib.Native.mutableString_nthSetter(self, ch, position));
  }

  /** Return the length of the string <code>self</code>.
   * @param self
   * @return int
   */
  public static int string_length(String self) {
    return (self.length());
  }

  /** Return the length of the string <code>self</code>.
   * @param self
   * @return int
   */
  public static int mutableString_length(StringBuffer self) {
    return (self.length());
  }

  /** Return start position of the left-most occurrence of
   * <code>substring</code> in <code>string</code>, beginning from <code>start</code>.  Return NULL if it is not
   * a substring.  The comparison ignores differences in letter case.
   * @param string
   * @param substring
   * @param start
   * @return int
   */
  public static int stringSearchIgnoreCase(String string, String substring, int start) {
    if (start == Stella.NULL_INTEGER) {
      start = 0;
    }
    return (Native.stringSearch(Native.stringDowncase(string), Native.stringDowncase(substring), start));
  }

  /** Return TRUE if <code>string</code> starts with <code>prefix</code> starting from
   * <code>start</code> (which defaults to 0 if it is supplied as NULL).
   * @param string
   * @param prefix
   * @param start
   * @return boolean
   */
  public static boolean startsWithP(String string, String prefix, int start) {
    if (start == Stella.NULL_INTEGER) {
      start = 0;
    }
    { int prefixlength = prefix.length();

      if ((start + prefixlength) > string.length()) {
        return (false);
      }
      else {
        { boolean alwaysP000 = true;

          { int i = Stella.NULL_INTEGER;
            int iter000 = 0;
            int upperBound000 = prefixlength - 1;
            int j = Stella.NULL_INTEGER;
            int iter001 = start;

            loop000 : for (;iter000 <= upperBound000; iter000 = iter000 + 1, iter001 = iter001 + 1) {
              i = iter000;
              j = iter001;
              if (!(prefix.charAt(i) == string.charAt(j))) {
                alwaysP000 = false;
                break loop000;
              }
            }
          }
          { boolean value000 = alwaysP000;

            return (value000);
          }
        }
      }
    }
  }

  /** Return TRUE if the substring of <code>string</code> ending at <code>end</code>
   * ends with <code>suffix</code>.  If <code>end</code> is NULL it defaults to the length of <code>string</code>.
   * @param string
   * @param suffix
   * @param end
   * @return boolean
   */
  public static boolean endsWithP(String string, String suffix, int end) {
    if (end == Stella.NULL_INTEGER) {
      end = string.length();
    }
    { int suffixlength = suffix.length();
      int start = end - suffixlength;

      if (start < 0) {
        return (false);
      }
      else {
        { boolean alwaysP000 = true;

          { int i = Stella.NULL_INTEGER;
            int iter000 = 0;
            int upperBound000 = suffixlength - 1;
            int j = Stella.NULL_INTEGER;
            int iter001 = start;

            loop000 : for (;iter000 <= upperBound000; iter000 = iter000 + 1, iter001 = iter001 + 1) {
              i = iter000;
              j = iter001;
              if (!(suffix.charAt(i) == string.charAt(j))) {
                alwaysP000 = false;
                break loop000;
              }
            }
          }
          { boolean value000 = alwaysP000;

            return (value000);
          }
        }
      }
    }
  }

  /** Helping function for <code>findMatchingPrefix</code> that requires <code>end1</code> and <code>end2</code>
   * to be properly set up.
   * @param string1
   * @param start1
   * @param end1
   * @param string2
   * @param start2
   * @param end2
   * @return int
   */
  static int helpFindMatchingPrefixLength(String string1, int start1, int end1, String string2, int start2, int end2) {
    { int i1 = start1;
      int i2 = start2;

      while ((i1 < end1) &&
          ((i2 < end2) &&
           (string1.charAt(i1) == string2.charAt(i2)))) {
        i1 = i1 + 1;
        i2 = i2 + 1;
      }
      return (i1 - start1);
    }
  }

  /** Finds the length of the matching prefix strings of <code>string1</code> and
   * <code>string2</code>, starting at position <code>start1</code> and <code>start2</code> respectively.
   * The search will end when <code>end1</code> or <code>end2</code> is reached.  If either <code>end1</code>
   * or <code>end2</code> is null, then they will be set to the length of their respective
   * strings.
   * @param string1
   * @param start1
   * @param end1
   * @param string2
   * @param start2
   * @param end2
   * @return int
   */
  public static int findMatchingPrefixLength(String string1, int start1, int end1, String string2, int start2, int end2) {
    if (end1 == Stella.NULL_INTEGER) {
      end1 = string1.length();
    }
    if (end2 == Stella.NULL_INTEGER) {
      end2 = string2.length();
    }
    return (Stella.helpFindMatchingPrefixLength(string1, start1, end1, string2, start2, end2));
  }

  /** Finds the first position in each of <code>string1</code> and <code>string2</code> where
   * they mismatch, starting at position <code>start1</code> and <code>start2</code> respectively.
   * The search will end when <code>end1</code> or <code>end2</code> is reached.  If either <code>end1</code>
   * or <code>end2</code> is null, then they will be set to the length of their respective
   * strings.  If there is no mismatch, then <code>null</code> values are returned.
   * @param string1
   * @param start1
   * @param end1
   * @param string2
   * @param start2
   * @param end2
   * @param MV_returnarray
   * @return int
   */
  public static int findMismatch(String string1, int start1, int end1, String string2, int start2, int end2, Object [] MV_returnarray) {
    if (end1 == Stella.NULL_INTEGER) {
      end1 = string1.length();
    }
    if (end2 == Stella.NULL_INTEGER) {
      end2 = string2.length();
    }
    { int len = Stella.helpFindMatchingPrefixLength(string1, start1, end1, string2, start2, end2);

      start1 = start1 + len;
      start2 = start2 + len;
      if ((start1 == end1) &&
          (start2 == end2)) {
        { int _return_temp = Stella.NULL_INTEGER;

          MV_returnarray[0] = IntegerWrapper.wrapInteger(Stella.NULL_INTEGER);
          return (_return_temp);
        }
      }
      else {
        { int _return_temp = start1;

          MV_returnarray[0] = IntegerWrapper.wrapInteger(start2);
          return (_return_temp);
        }
      }
    }
  }

  /** Helper for <code>nonMatchingPosition</code> that requires <code>end</code> to not be <code>null</code>.
   * @param source
   * @param start
   * @param end
   * @param match
   * @return int
   */
  static int nonMatchingPositionHelper(String source, int start, int end, String match) {
    while ((start < end) &&
        Native.string_memberP(match, source.charAt(start))) {
      start = start + 1;
    }
    return (start);
  }

  /** Returns the index into <code>source</code>, starting from <code>start</code>, of the first
   * character that is not included in <code>match</code>.
   * @param source
   * @param start
   * @param match
   * @return int
   */
  public static int nonMatchingPosition(String source, int start, String match) {
    return (Stella.nonMatchingPositionHelper(source, start, source.length(), match));
  }

  /** Helper for <code>advancePastWhitespace</code> that requires <code>end</code> to be properly set.
   * @param source
   * @param start
   * @param end
   * @return int
   */
  static int helpAdvancePastWhitespace(String source, int start, int end) {
    while ((start < end) &&
        (Stella.$CHARACTER_TYPE_TABLE$[(int) (source.charAt(start))] == Stella.KWD_WHITE_SPACE)) {
      start = start + 1;
    }
    return (start);
  }

  /** Returns the first index into <code>source</code>, starting from <code>start</code>, of
   * the first character that is not white space.
   * @param source
   * @param start
   * @return int
   */
  public static int advancePastWhitespace(String source, int start) {
    return (Stella.helpAdvancePastWhitespace(source, start, source.length()));
  }

  /** Return <code>true</code> if the strings <code>s1</code> and <code>s2</code> are the same
   * except for the amounts of whitespace separating words.  Leading or
   * trailing whitespace is also not considered.
   * @param s1
   * @param s2
   * @return boolean
   */
  public static boolean eqlExceptInWhitespaceP(String s1, String s2) {
    if (s1 == null) {
      return (s2 == null);
    }
    else if (s2 == null) {
      return (false);
    }
    else if (Stella.stringEqlP(s1, s2)) {
      return (true);
    }
    { int len1 = s1.length();
      int len2 = s2.length();
      int i1 = 0;
      int i2 = 0;

      while ((i1 < len1) &&
          (i2 < len2)) {
        if (Stella.$CHARACTER_TYPE_TABLE$[(int) (s1.charAt(i1))] == Stella.KWD_WHITE_SPACE) {
          if (Stella.$CHARACTER_TYPE_TABLE$[(int) (s2.charAt(i2))] == Stella.KWD_WHITE_SPACE) {
            {
              while ((i1 < len1) &&
                  (Stella.$CHARACTER_TYPE_TABLE$[(int) (s1.charAt(i1))] == Stella.KWD_WHITE_SPACE)) {
                i1 = i1 + 1;
              }
              while ((i2 < len2) &&
                  (Stella.$CHARACTER_TYPE_TABLE$[(int) (s2.charAt(i2))] == Stella.KWD_WHITE_SPACE)) {
                i2 = i2 + 1;
              }
            }
          }
          else {
            return (false);
          }
        }
        else if (s1.charAt(i1) == s2.charAt(i2)) {
          i1 = i1 + 1;
          i2 = i2 + 1;
        }
        else {
          return (false);
        }
      }
      while ((i1 < len1) &&
          (Stella.$CHARACTER_TYPE_TABLE$[(int) (s1.charAt(i1))] == Stella.KWD_WHITE_SPACE)) {
        i1 = i1 + 1;
      }
      while ((i2 < len2) &&
          (Stella.$CHARACTER_TYPE_TABLE$[(int) (s2.charAt(i2))] == Stella.KWD_WHITE_SPACE)) {
        i2 = i2 + 1;
      }
      return ((i1 == len1) &&
          (i2 == len2));
    }
  }

  /** Split <code>input</code> into separate strings based on the <code>separator</code> character.
   * @param input
   * @param separator
   * @return Cons
   */
  public static Cons splitString(String input, char separator) {
    { int length = input.length();
      int start = 0;
      int end = 0;
      Cons strings = Stella.NIL;

      loop000 : for (;;) {
        end = Native.string_position(input, separator, start);
        strings = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(input, start, end)), strings);
        if ((end != Stella.NULL_INTEGER) &&
            (end < (length - 1))) {
          start = end + 1;
        }
        else {
          break loop000;
        }
      }
      return (strings.reverse());
    }
  }

  /** Read a STELLA expression from <code>string</code> and return the result.
   * This is identical to <code>readSExpressionFromString</code>.
   * @param string
   * @return Stella_Object
   */
  public static Stella_Object unstringify(String string) {
    return (Stella.readSExpressionFromString(string));
  }

  /** Map the hash code <code>code</code> onto a bucket index for a hash table
   * of <code>size</code> (i.e., onto the interval [0..size-1].  This is just like <code>rem</code> for
   * positive hash codes but also works for negative hash codes by mapping those
   * onto a positive number first.  Note, that the sign conversion mapping is not
   * equivalent to calling the <code>abs</code> function (it simply masks the sign bit for
   * speed) and therefore really only makes sense for hash codes.
   * @param code
   * @param size
   * @return int
   */
  public static int hashmod(int code, int size) {
    return (((code & 0x7FFFFFFF) % size));
  }

  /** Rotate <code>arg</code> to the right by 1 position.  This means shift <code>arg</code> to the right
   * by one and feed in <code>arg</code>s bit zero from the left.  In Lisp the result will stay
   * in positive FIXNUM range.  In C++ and Java this might return a negative
   * value which might be equal to NULL-INTEGER.  Important: to make this inlinable,
   * it must be called with an atom (i.e., constant or variable) as its argument.
   * This function is primarily useful for hashing sequences of items where the hash
   * code should take the sequential order of elements into account (e.g., lists).
   * @param arg
   * @return int
   */
  public static int rotateHashCode(int arg) {
    return ((((arg & 1) == 0) ? (arg >>> 1) : (((arg >> 1)) | Stella.$INTEGER_MSB_MASK$)));
  }

  public static int string_hashCode_(String self) {
    return (self.hashCode());
  }

  public static int integer_hashCode_(int self) {
    return (self);
  }

  public static int longInteger_hashCode_(long self) {
    return (((int)((((self ^ ((self >> 32)))) & (((long)(Stella.MOST_POSITIVE_INTEGER)))))));
  }

  public static int float_hashCode_(double self) {
    return ((int)(Double.doubleToLongBits(self)^(Double.doubleToLongBits(self)>>>32)));
  }

  public static int character_hashCode_(char self) {
    return (((Stella.$HASH_BYTE_RANDOM_TABLE$[(int) self]) ^ 15119378));
  }

  /** Generate a hash-code for <code>string</code> and return it.
   * Two strings that are equal but not eq will generate the same code.
   * The hash-code is based on <code>seedcode</code> which usually will be 0.  However,
   * <code>seedcode</code> can also be used to supply the result of a previous hash
   * operation to achieve hashing on sequences of strings without actually
   * having to concatenate them.
   * @param string
   * @param seedcode
   * @return int
   */
  public static int hashString(String string, int seedcode) {
    { int code = seedcode;
      int cursor = string.length();

      if (cursor == 0) {
        return (4303803);
      }
      else {
        cursor = cursor - 1;
      }
      loop000 : for (;;) {
        code = (code ^ (Stella.$HASH_BYTE_RANDOM_TABLE$[(int) (string.charAt(cursor))]));
        if (cursor == 0) {
          break loop000;
        }
        else {
          cursor = cursor - 1;
        }
        code = (((code & 1) == 0) ? (code >>> 1) : (((code >> 1)) | Stella.$INTEGER_MSB_MASK$));
      }
      return (code);
    }
  }

  /** Return a hash table prime of at least <code>minsize</code>.
   * @param minsize
   * @return int
   */
  public static int pickHashTableSizePrime(int minsize) {
    { IntegerWrapper prime = null;
      Vector vector000 = Stella.$HASH_TABLE_SIZE_PRIMES$;
      int index000 = 0;
      int length000 = vector000.length();

      for (;index000 < length000; index000 = index000 + 1) {
        prime = ((IntegerWrapper)((vector000.theArray)[index000]));
        if (prime.wrapperValue >= minsize) {
          return (prime.wrapperValue);
        }
      }
    }
    throw ((StellaException)(StellaException.newStellaException("pick-hash-table-size-prime: minimum size is too large").fillInStackTrace()));
  }

  /** Return the element in <code>self</code> at <code>position</code>.
   * @param self
   * @param position
   * @return Stella_Object
   */
  public static Stella_Object nativeVector_nth(edu.isi.stella.Stella_Object[] self, int position) {
    return (self[position]);
  }

  /** Set the element in <code>self</code> at <code>position</code> to <code>value</code>.
   * @param self
   * @param value
   * @param position
   * @return Stella_Object
   */
  public static Stella_Object nativeVector_nthSetter(edu.isi.stella.Stella_Object[] self, Stella_Object value, int position) {
    return (self[position] = value);
  }

  /** Return true if file <code>filename</code> exists and is a directory.
   * Note that this does not necessarily mean that the directory can also be read.
   * This does not handle any necessary pathname translations or error conditions.
   * @param filename
   * @return boolean
   */
  public static boolean nativeProbeDirectoryP(String filename) {
    { boolean result = false;

      result = (new java.io.File(filename)).isDirectory();
      return (result);
    }
  }

  /** Return true if file <code>filename</code> exists.  Note that this does
   * not necessarily mean that the file can also be read.
   * IMPORTANT Java idiosyncrasy: if file <code>fooSbar</code> exists and is not a directory,
   * Java will also say <code>fooSbarS</code> exists, which is different behavior than in Lisp
   * and C++.  For this reason, make sure to always use <code>probeDirectoryP</code> to test
   * whether a directory exists.
   * @param filename
   * @return boolean
   */
  public static boolean probeFileP(String filename) {
    return (Native.nativeProbeFileP(Stella.translateLogicalPathname(filename)));
  }

  /** Return true if file <code>filename</code> exists and is a directory.
   * Note that this does not necessarily mean that the directory can also be read.
   * @param filename
   * @return boolean
   */
  public static boolean probeDirectoryP(String filename) {
    return (Stella.nativeProbeDirectoryP(Stella.translateLogicalPathname(filename)));
  }

  /** Return the time at which file <code>filename</code> was last modified or
   * NULL if that cannot be determined.
   * @param filename
   * @return CalendarDate
   */
  public static CalendarDate fileWriteDate(String filename) {
    { String truefile = Stella.translateLogicalPathname(filename);

      if (!(Native.nativeProbeFileP(truefile))) {
        Stella.ensureFileExists(filename, "file-write-date");
      }
      return (Native.nativeFileWriteDate(truefile));
    }
  }

  /** Return the length of file <code>filename</code> in bytes or NULL if that
   * cannot be determined.
   * @param filename
   * @return long
   */
  public static long fileLength(String filename) {
    { String truefile = Stella.translateLogicalPathname(filename);

      if (!(Native.nativeProbeFileP(truefile))) {
        Stella.ensureFileExists(filename, "file-length");
      }
      return (Native.nativeFileLength(truefile));
    }
  }

  /** Delete the file <code>filename</code>.
   * @param filename
   */
  public static void deleteFile(String filename) {
    { String truefile = Stella.translateLogicalPathname(filename);

      if (!(Native.nativeProbeFileP(truefile))) {
        Stella.ensureFileExists(filename, "delete-file");
      }
      Native.nativeDeleteFile(truefile);
    }
  }

  /** Rename the file <code>fromfile</code> to <code>tofile</code>.
   * @param fromfile
   * @param tofile
   */
  public static void renameFile(String fromfile, String tofile) {
    { String truefrom = Stella.translateLogicalPathname(fromfile);
      String trueto = Stella.translateLogicalPathname(tofile);

      if (!(Native.nativeProbeFileP(truefrom))) {
        Stella.ensureFileExists(fromfile, "rename-file");
      }
      if (Native.nativeProbeFileP(trueto)) {
        Stella.ensureFileDoesNotExist(tofile, "rename-file");
      }
      Native.nativeRenameFile(truefrom, trueto);
    }
  }

  /** Copy file <code>fromfile</code> to file <code>tofile</code>, clobbering
   * any data already in <code>tofile</code>.
   * @param fromfile
   * @param tofile
   */
  public static void copyFile(String fromfile, String tofile) {
    Stella.ensureFileExists(fromfile, "copy-file");
    { InputFileStream from = null;

      try {
        from = Stella.openInputFile(fromfile, Stella.NIL);
        { OutputFileStream to = null;

          try {
            to = Stella.openOutputFile(tofile, Stella.NIL);
            InputStream.copyStreamToStream(from, to);

          } finally {
            if (to != null) {
              to.free();
            }
          }
        }

      } finally {
        if (from != null) {
          from.free();
        }
      }
    }
  }

  /** Return a suitable directory for temporary files.
   * Uses the value of <code>stellaDtempDirectory</code> if defined; otherwise, it
   * will use a suitable OS-specific default.  The returned directory will
   * end in a separator for immediate concatenation with a physical filename.
   * @return String
   */
  public static String getTempDirectory() {
    { Stella_Object dir = Stella_Object.getProperty(StringWrapper.wrapString("stella.tempDirectory"), Stella.NIL);

      if (dir == null) {
        { Keyword testValue000 = Stella.operatingSystem();

          if ((testValue000 == Stella.KWD_UNIX) ||
              (testValue000 == Stella.KWD_MAC)) {
            dir = StringWrapper.wrapString("/tmp/");
          }
          else if (testValue000 == Stella.KWD_WINDOWS) {
            dir = StringWrapper.wrapString("C:\\WINDOWS\\TEMP\\");
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }
      }
      else {
        dir = StringWrapper.wrapString(Stella.fileNameAsDirectory(((StringWrapper)(dir)).wrapperValue));
      }
      return (((StringWrapper)(dir)).wrapperValue);
    }
  }

  /** Return a file name of the form <code>LprefixGNNNNNNLsuffixG</code>
   * which is guaranteed to not refer to any existing file.  A null <code>prefix</code>
   * defaults to <code>tmpfile</code>, a null <code>suffix</code> defaults to the empty string.
   * The number portion NNNNNN will correpond to a random number between 0
   * and 999999.  If no qualifying filename can be found after 100 attempts,
   * NULL will be returned.  Note that it is possible due to multi-threading
   * or processing that the generated filename becomes used by another thread
   * or OS process.  If necessary, this case can be handled by the caller.
   * @param prefix
   * @param suffix
   * @return String
   */
  public static String makeTemporaryFileName(String prefix, String suffix) {
    if (prefix == null) {
      prefix = "tmpfile";
    }
    if (suffix == null) {
      suffix = "";
    }
    { int i = Stella.NULL_INTEGER;
      int iter000 = 0;
      int upperBound000 = 100;

      for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
        i = iter000;
        i = i;
        { String uniquifier = Stella.formatWithPadding(Native.integerToString(((long)(Stella.random(1000000)))), 6, '0', Stella.KWD_RIGHT, false);
          String tempfilename = prefix + uniquifier + suffix;

          if (!Stella.probeFileP(tempfilename)) {
            return (tempfilename);
          }
        }
      }
    }
    return (null);
  }

  /** Variant of <code>makeTemporaryFileName</code> that actually
   * allocates the file to prevent other processes from using that name.
   * This is still not fully thread safe - for that we would need a file lock -
   * but maybe a bit better in avoiding collisions.
   * @param prefix
   * @param suffix
   * @return String
   */
  public static String makeTemporaryFile(String prefix, String suffix) {
    { int i = Stella.NULL_INTEGER;
      int iter000 = 0;
      int upperBound000 = 100;

      for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
        i = iter000;
        i = i;
        try {
          { String tempfilename = Stella.makeTemporaryFileName(prefix, suffix);

            { OutputFileStream temp = null;

              try {
                temp = Stella.openOutputFile(tempfilename, Cons.cons(Stella.KWD_IF_EXISTS, Cons.cons(Stella.KWD_ERROR, Stella.NIL)));
                Stream.closeStream(temp);

              } finally {
                if (temp != null) {
                  temp.free();
                }
              }
            }
            return (tempfilename);
          }
        } catch (java.lang.Exception e000) {
        }
      }
    }
    return (null);
  }

  public static Cons clListDirectoryFiles(String directory) {
    { Cons files = null;
      String dirsep = Stella.directorySeparatorString();
      boolean checkduplicatesP = false;
      String normfile = null;
      Cons normalizedfiles = Stella.NIL;

      if (files == null) {
        checkduplicatesP = true;
      }
      files = Stella.NIL;
      if (checkduplicatesP) {
        normalizedfiles = normalizedfiles.removeDuplicatesEqual();
      }
      { StringWrapper file = null;
        Cons iter000 = files;
        Cons collect000 = null;

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          file = ((StringWrapper)(iter000.value));
          normfile = file.wrapperValue;
          if (Stella.endsWithP(normfile, dirsep, Stella.NULL_INTEGER)) {
            normfile = Native.string_subsequence(normfile, 0, normfile.length() - dirsep.length());
          }
          normfile = Stella.fileNameWithoutDirectory(normfile);
          if (Stella.stringEqlP(normfile, ".") ||
              Stella.stringEqlP(normfile, "..")) {
            continue loop000;
          }
          if (collect000 == null) {
            {
              collect000 = Cons.cons(StringWrapper.wrapString(normfile), Stella.NIL);
              if (normalizedfiles == Stella.NIL) {
                normalizedfiles = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(normalizedfiles, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(StringWrapper.wrapString(normfile), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (normalizedfiles);
    }
  }

  public static Cons cppListDirectoryFiles(String directory) {
    { Cons files = Stella.NIL;

      if (files == null) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("list-directory-files: error reading `" + directory + "'");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      return (files);
    }
  }

  public static Cons javaListDirectoryFiles(String directory) {
    { Cons files = Stella.NIL;

        java.io.File[] dirfiles = new java.io.File(directory).listFiles();
         String filename = null;
         String dirsep = Stella.directorySeparatorString();
         for (int i = dirfiles.length-1; i >= 0; i--) {
             filename = dirfiles[i].getName();
             files = Cons.cons(StringWrapper.wrapString(filename), files);
         }
;
      return (files);
    }
  }

  /** Return all the files and sub-directories in <code>directory</code> sorted by name.
   * Each returned file is a bare file name without a <code>directory</code> component.  If a file is
   * a directory, it will look just like a plain file.  This means consumers might have to
   * explicitly test whether a file is a directory depending on what they do. Excludes . and ..
   * directories.  Handles logical pathnames but resulting files will always use physical pathname
   * syntax.  This is mostly consistent across native languages, but some differences still exist -
   * e.g., Lisp will convert . or .. into absolute pathnames.
   * @param directory
   * @return Cons
   */
  public static Cons listDirectoryFiles(String directory) {
    directory = Stella.translateLogicalPathname(Stella.fileNameAsDirectory(directory));
    Stella.ensureFileExists(directory, "list-directory-files");
    { Cons files = Stella.javaListDirectoryFiles(directory);

      return (files.sort(null));
    }
  }

  /** Just like <code>listDirectoryFiles</code> (which see) but also recurses into
   * subdirectories.  Files at the top level of <code>directory</code> will be bare file names without
   * a <code>directory</code> component.  Files in subdirectories will be prefixed with the relative
   * subdirectory path starting right below <code>directory</code>.  The sort order is lexicographic
   * within directories which results in a depth-first presentation order of files.
   * @param directory
   * @return Cons
   */
  public static Cons listDirectoryFilesRecursively(String directory) {
    directory = Stella.translateLogicalPathname(Stella.fileNameAsDirectory(directory));
    Stella.ensureFileExists(directory, "list-directory-files");
    { Cons files = Stella.NIL;

      { StringWrapper file = null;
        Cons iter000 = Stella.listDirectoryFiles(directory);

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          file = ((StringWrapper)(iter000.value));
          if (Stella.probeDirectoryP(directory + file.wrapperValue)) {
            file = StringWrapper.wrapString(Stella.fileNameAsDirectory(file.wrapperValue));
            { StringWrapper subfile = null;
              Cons iter001 = Stella.listDirectoryFilesRecursively(directory + file.wrapperValue);

              for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                subfile = ((StringWrapper)(iter001.value));
                files = Cons.cons(StringWrapper.wrapString(StringWrapper.unwrapString(file) + subfile.wrapperValue), files);
              }
            }
          }
          else {
            files = Cons.cons(file, files);
          }
        }
      }
      return (files.reverse());
    }
  }

  public static int integer_lognot(int arg) {
    return ((~ arg));
  }

  public static long longInteger_lognot(long arg) {
    return ((~ arg));
  }

  public static int integer_logand(int arg1, int arg2) {
    return ((arg1 & arg2));
  }

  public static long longInteger_logand(long arg1, long arg2) {
    return ((arg1 & arg2));
  }

  public static int integer_logor(int arg1, int arg2) {
    return ((arg1 | arg2));
  }

  public static long longInteger_logor(long arg1, long arg2) {
    return ((arg1 | arg2));
  }

  public static int integer_logxor(int arg1, int arg2) {
    return ((arg1 ^ arg2));
  }

  public static long longInteger_logxor(long arg1, long arg2) {
    return ((arg1 ^ arg2));
  }

  /** Return the 1-based position of the left-most bit in <code>x</code>.
   * If <code>x</code> is negative, we only count the value bits, not the sign.
   * @param x
   * @return int
   */
  public static int integerLength(long x) {
    if (x < 0) {
      x = -1 - x;
    }
    if (x == 0) {
      return (0);
    }
    { int bot = 0;
      int top = Stella.LONG_INTEGER_BIT_WIDTH - 1;
      int split = 0;
      long rem = 0l;

      for (;;) {
        split = ((bot + top) >> 1);
        rem = (x >> split);
        if (rem == 1) {
          return (split + 1);
        }
        if (rem == 0) {
          top = split - 1;
        }
        else {
          bot = split + 1;
        }
      }
    }
  }

  /** Return the 1-based position of the left-most non-zero digit
   * in the base-10 representation of <code>x</code>.  If <code>x</code> is negative, we only consider
   * its absolute value, not the sign.  This effectively computes the minimum number
   * of base-10 digits to represent <code>x</code>, with the exception of x=0.
   * @param x
   * @return int
   */
  public static int integerLength10(long x) {
    if (x < 0) {
      x = ((x < 0) ? (0 - x) : x);
    }
    { int len = 0;
      int comp = 1;

      loop000 : for (;;) {
        if (x >= 1000000000l) {
          x = (x / 1000000000l);
          len = len + 9;
        }
        else if (x >= 10000) {
          x = (x / (10000l));
          len = len + 4;
        }
        else if (x >= 100) {
          x = (x / (100l));
          len = len + 2;
        }
        else {
          break loop000;
        }
      }
      while (comp <= x) {
        comp = comp * 10;
        len = len + 1;
      }
      return (len);
    }
  }

  public static int integer_shiftLeft(int arg, int count) {
    return ((arg << count));
  }

  public static long longInteger_shiftLeft(long arg, int count) {
    return ((arg << count));
  }

  /** Shift <code>arg</code> to the right by <code>count</code> positions and
   * 0-extend from the left if <code>arg</code> is positive or 1-extend if it is
   * negative.  This is an arithmetic shift that preserve the sign of <code>arg</code>
   * and is equivalent to dividing <code>arg</code> by 2** <code>count</code>.
   * @param arg
   * @param count
   * @return int
   */
  public static int integer_shiftRight(int arg, int count) {
    return ((arg >> count));
  }

  /** Shift <code>arg</code> to the right by <code>count</code> positions and
   * 0-extend from the left if <code>arg</code> is positive or 1-extend if it is
   * negative.  This is an arithmetic shift that preserve the sign of <code>arg</code>
   * and is equivalent to dividing <code>arg</code> by 2** <code>count</code>.
   * @param arg
   * @param count
   * @return long
   */
  public static long longInteger_shiftRight(long arg, int count) {
    return ((arg >> count));
  }

  /** Shift <code>arg</code> to the right by 1 position and 0-extend
   * from the left.  This does not preserve the sign of <code>arg</code> and shifts
   * the sign-bit just like a regular bit.  In Common-Lisp we can't do that
   * directly and need to do some extra masking.
   * @param arg
   * @return int
   */
  public static int integer_unsignedShiftRightBy1(int arg) {
    return ((arg >>> 1));
  }

  /** Shift <code>arg</code> to the right by 1 position and 0-extend
   * from the left.  This does not preserve the sign of <code>arg</code> and shifts
   * the sign-bit just like a regular bit.  In Common-Lisp we can't do that
   * directly and need to do some extra masking.
   * @param arg
   * @return long
   */
  public static long longInteger_unsignedShiftRightBy1(long arg) {
    return ((arg >>> 1));
  }

  /** Generates a random UUID (Type 4), according to the guidelines
   * of IETF RFC 4122 (see http://www.ietf.org/rfc/rfc4122.txt )
   * <p>
   * Take 16 random bytes (octets), put them all behind each other, for the description
   * the numbering starts with byte 1 (most significant, first) to byte 16 
   *    (least significant, last). Then put in the version and variant.
   * To put in the version, take the 7th byte and perform an and operation using 0x0f,
   *    followed by an or operation with 0x40. 
   * To put in the variant, take the 9th byte and perform an and operation using 0x3f,
   *    followed by an or operation with 0x80.
   * To make the string representation, take the hexadecimal presentation of bytes 1-4
   *    (without 0x in front of it) let them follow by a -, then take bytes 5 and 6, - 
   * bytes 7 and 8, - bytes 9 and 10, - then followed by bytes 11-16.
   * @return String
   */
  public static String generateRandomUuid() {
    return (Stella.zeroPadString(Native.integerToHexString(((long)(Stella.random(65536)))), 4) + Stella.zeroPadString(Native.integerToHexString(((long)(Stella.random(65536)))), 4) + "-" + Stella.zeroPadString(Native.integerToHexString(((long)(Stella.random(65536)))), 4) + "-" + Native.integerToHexString(((long)(16384 + Stella.random(4096)))) + "-" + Native.integerToHexString(((long)(32768 + Stella.random(16384)))) + "-" + Stella.zeroPadString(Native.integerToHexString(((long)(Stella.random(16777216)))), 6) + Stella.zeroPadString(Native.integerToHexString(((long)(Stella.random(16777216)))), 6));
  }

  /** Return true if the executable code is a Common Lisp application.
   * @return boolean
   */
  public static boolean runningAsLispP() {
    { boolean resultP = false;

      return (resultP);
    }
  }

  /** Returns the keyword for the language the current implementation is running in.
   * @return Keyword
   */
  public static Keyword runningInLanguage() {
    return (Stella.internKeyword("JAVA"));
  }

  /** Returns an information string about the current running system environment.
   * @return String
   */
  public static String runningSystemInformation() {
    { String info = "";

            StringBuffer infoBuffer = new StringBuffer();
      String[] infoKeys = new String [] {"java.vendor", "java.version", "os.arch", "os.name", "os.version"};
      for (int i = 0; i < infoKeys.length; i++) {
	infoBuffer.append(System.getProperty("line.separator"));
	try {
	  infoBuffer.append(infoKeys[i]);
	  infoBuffer.append(" = ");
	  infoBuffer.append(System.getProperty(infoKeys[i]));
	    } catch (SecurityException se) {
	  infoBuffer.append("??");
	}
      }
      info = infoBuffer.toString()
;
      return (info);
    }
  }

  /** The program will sleep for the indicated number of seconds.
   * Fractional values are allowed, but the results are implementation dependent:
   * Common Lisp uses the fractions natively, Java with a resolution of 0.001,
   * and C++ can only use integral values.
   * @param seconds
   */
  public static void sleep(double seconds) {
    try {
      Thread.sleep((long)(seconds * 1000.0));
    } catch (InterruptedException e) {
    }
;
  }

  /** Accesses the error message of the exception <code>e</code>.
   * @param e
   * @return String
   */
  public static String exceptionMessage(java.lang.Exception e) {
    return (e.getMessage());
  }

  /** Prints system dependent information about the context of the specified
   * exception <code>e</code>.  For example, in Java it prints a stack trace.  In Lisp, it is vendor dependent.
   * @param e
   * @param stream
   */
  public static void printExceptionContext(java.lang.Exception e, OutputStream stream) {
    { edu.isi.stella.javalib.NativeOutputStream s = stream.nativeStream;

      e.printStackTrace(s);;
    }
  }

  /** Print the exception context of <code>e</code> to a string and return the result.
   * @param e
   * @return String
   */
  public static String exceptionContext(java.lang.Exception e) {
    { OutputStringStream out = OutputStringStream.newOutputStringStream();

      Stella.printExceptionContext(e, out);
      return (out.theStringReader());
    }
  }

  public static Object makeProcessLock() {
    return (new java.lang.Object());
  }

  /** Return a set containing <code>values</code>, in order.
   * @param values
   * @return Set
   */
  public static Set set(Cons values) {
    { Set set = Set.newSet();

      { Stella_Object v = null;
        Cons iter000 = values;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          v = iter000.value;
          if (!set.memberP(v)) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(v, Stella.NIL);
                if (set.theConsList == Stella.NIL) {
                  set.theConsList = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(set.theConsList, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(v, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      return (set);
    }
  }

  /** Return a vector containing <code>values</code>, in order.
   * @param values
   * @return Vector
   */
  public static Vector vector(Cons values) {
    { Vector vector = Vector.newVector(values.length());

      { Stella_Object v = null;
        Cons iter000 = values;
        int i = Stella.NULL_INTEGER;
        int iter001 = 0;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
          v = iter000.value;
          i = iter001;
          (vector.theArray)[i] = v;
        }
      }
      return (vector);
    }
  }

  public static void heapSortNativeVector(edu.isi.stella.Stella_Object[] vector, int size, java.lang.reflect.Method predicate) {
    Stella.heapSortHeapify(vector, size, predicate);
    { int end = size - 1;
      Stella_Object aux = null;

      while (end > 0) {
        aux = vector[0];
        vector[0] = (vector[end]);
        vector[end] = aux;
        end = end - 1;
        Stella.heapSortSiftDown(vector, 0, end, predicate);
      }
    }
  }

  public static void heapSortHeapify(edu.isi.stella.Stella_Object[] vector, int size, java.lang.reflect.Method predicate) {
    { int start = (size >> 1) - 1;

      while (start >= 0) {
        Stella.heapSortSiftDown(vector, start, size - 1, predicate);
        start = start - 1;
      }
    }
  }

  public static void heapSortSiftDown(edu.isi.stella.Stella_Object[] vector, int start, int end, java.lang.reflect.Method predicate) {
    { int root = start;
      int child = 0;
      Stella_Object aux = null;

      loop000 : for (;;) {
        child = (root << 1) + 1;
        if (child > end) {
          break loop000;
        }
        if ((child < end) &&
            ((Boolean)(edu.isi.stella.javalib.Native.funcall(predicate, null, new java.lang.Object [] {vector[child], vector[(child + 1)]}))).booleanValue()) {
          child = child + 1;
        }
        if (((Boolean)(edu.isi.stella.javalib.Native.funcall(predicate, null, new java.lang.Object [] {vector[root], vector[child]}))).booleanValue()) {
          aux = vector[root];
          vector[root] = (vector[child]);
          vector[child] = aux;
          root = child;
        }
        else {
          return;
        }
      }
    }
  }

  public static Stella_Object quickSortPickSplitElement(edu.isi.stella.Stella_Object[] vector, int start, int end, java.lang.reflect.Method predicate) {
    { Stella_Object splitelement = vector[start];
      int middle = ((start + end) >> 1);

      end = end - 1;
      if (((Boolean)(edu.isi.stella.javalib.Native.funcall(predicate, null, new java.lang.Object [] {splitelement, vector[middle]}))).booleanValue()) {
        if (((Boolean)(edu.isi.stella.javalib.Native.funcall(predicate, null, new java.lang.Object [] {vector[middle], vector[end]}))).booleanValue()) {
          splitelement = vector[middle];
          vector[middle] = (vector[start]);
        }
        else if (((Boolean)(edu.isi.stella.javalib.Native.funcall(predicate, null, new java.lang.Object [] {splitelement, vector[end]}))).booleanValue()) {
          splitelement = vector[end];
          vector[end] = (vector[start]);
        }
        else {
        }
      }
      else {
        if (((Boolean)(edu.isi.stella.javalib.Native.funcall(predicate, null, new java.lang.Object [] {splitelement, vector[end]}))).booleanValue()) {
        }
        else if (((Boolean)(edu.isi.stella.javalib.Native.funcall(predicate, null, new java.lang.Object [] {vector[middle], vector[end]}))).booleanValue()) {
          splitelement = vector[end];
          vector[end] = (vector[start]);
        }
        else {
          splitelement = vector[middle];
          vector[middle] = (vector[start]);
        }
      }
      return (splitelement);
    }
  }

  public static void quickSortNativeVector(edu.isi.stella.Stella_Object[] vector, int start, int end, java.lang.reflect.Method predicate) {
    for (;;) {
      { int length = end - start;
        Stella_Object splitelement = null;
        Stella_Object element = null;
        int lowcursor = start;
        int highcursor = end;

        if (length <= 1) {
          return;
        }
        else if (length >= 10) {
          splitelement = Stella.quickSortPickSplitElement(vector, start, end, predicate);
        }
        else {
          splitelement = vector[start];
        }
        while (lowcursor < highcursor) {
          loop002 : while (lowcursor < highcursor) {
            highcursor = highcursor - 1;
            element = vector[highcursor];
            if (((Boolean)(edu.isi.stella.javalib.Native.funcall(predicate, null, new java.lang.Object [] {element, splitelement}))).booleanValue()) {
              vector[lowcursor] = element;
              break loop002;
            }
          }
          loop003 : while (lowcursor < highcursor) {
            lowcursor = lowcursor + 1;
            element = vector[lowcursor];
            if (((Boolean)(edu.isi.stella.javalib.Native.funcall(predicate, null, new java.lang.Object [] {splitelement, element}))).booleanValue()) {
              vector[highcursor] = element;
              break loop003;
            }
          }
        }
        vector[highcursor] = splitelement;
        if (((start + end) >> 1) < highcursor) {
          Stella.quickSortNativeVector(vector, highcursor + 1, end, predicate);
          end = highcursor;
        }
        else {
          Stella.quickSortNativeVector(vector, start, highcursor, predicate);
          start = highcursor + 1;
        }
      }
    }
  }

  public static void heapSiftUp(edu.isi.stella.Stella_Object[] heap, int start, int end, Stella_Object value, java.lang.reflect.Method predicate) {
    { int parent = Stella.NULL_INTEGER;
      int child = end;

      heap[end] = value;
      loop000 : while (child > start) {
        if ((child & 1) == 0) {
          parent = ((child - 2) >> 1);
        }
        else {
          parent = ((child - 1) >> 1);
        }
        if (((Boolean)(edu.isi.stella.javalib.Native.funcall(predicate, null, new java.lang.Object [] {value, heap[parent]}))).booleanValue()) {
          heap[child] = (heap[parent]);
          heap[parent] = value;
          child = parent;
        }
        else {
          break loop000;
        }
      }
    }
  }

  public static void heapSiftDown(edu.isi.stella.Stella_Object[] heap, int start, int end, Stella_Object value, java.lang.reflect.Method predicate) {
    { int parent = start;
      int child = Stella.NULL_INTEGER;
      Stella_Object leftchild = null;
      Stella_Object rightchild = null;

      heap[start] = value;
      end = end - 1;
      loop000 : for (;;) {
        child = (parent << 1) + 1;
        if (child > end) {
          break loop000;
        }
        else if (child == end) {
          if (!(((Boolean)(edu.isi.stella.javalib.Native.funcall(predicate, null, new java.lang.Object [] {heap[child], value}))).booleanValue())) {
            break loop000;
          }
        }
        else {
          leftchild = heap[child];
          rightchild = heap[(child + 1)];
          if (((Boolean)(edu.isi.stella.javalib.Native.funcall(predicate, null, new java.lang.Object [] {leftchild, value}))).booleanValue()) {
            if (((Boolean)(edu.isi.stella.javalib.Native.funcall(predicate, null, new java.lang.Object [] {rightchild, value}))).booleanValue() &&
                ((Boolean)(edu.isi.stella.javalib.Native.funcall(predicate, null, new java.lang.Object [] {rightchild, leftchild}))).booleanValue()) {
              child = child + 1;
            }
          }
          else if (((Boolean)(edu.isi.stella.javalib.Native.funcall(predicate, null, new java.lang.Object [] {rightchild, value}))).booleanValue()) {
            child = child + 1;
          }
          else {
            break loop000;
          }
        }
        heap[parent] = (heap[child]);
        heap[child] = value;
        parent = child;
      }
    }
  }

  /** Return an <code>eqlP</code> HASH-SET containing <code>values</code>.
   * @param values
   * @return HashSet
   */
  public static HashSet hashSet(Cons values) {
    { HashSet set = HashSet.newHashSet();

      { Stella_Object v = null;
        Cons iter000 = values;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          v = iter000.value;
          set.insertAt(v, v);
        }
      }
      return (set);
    }
  }

  public static IntegerIntervalIterator interval(int lowerbound, int upperbound) {
    return (IntegerIntervalIterator.newIntegerIntervalIterator(lowerbound, upperbound));
  }

  /** Create a reverse interval object.
   * @param lowerbound
   * @param upperbound
   * @return ReverseIntegerIntervalIterator
   */
  public static ReverseIntegerIntervalIterator reverseInterval(int lowerbound, int upperbound) {
    return (ReverseIntegerIntervalIterator.newReverseIntegerIntervalIterator(lowerbound, upperbound));
  }

  public static StringIterator string_allocateIterator(String self) {
    { StringIterator self000 = StringIterator.newStringIterator();

      self000.theString = self;
      { StringIterator iterator = self000;

        iterator.cursor = 0;
        iterator.end = self.length();
        return (iterator);
      }
    }
  }

  public static Iterator allocateAllMetaObjectsIterator(int arraysize, java.lang.reflect.Method nextcode, Module module, boolean localP) {
    { AllPurposeIterator iterator = AllPurposeIterator.newAllPurposeIterator();
      Cons moduleslist = Stella.NIL;

      iterator.iteratorInteger = 0;
      iterator.iteratorSecondInteger = arraysize;
      if (module != null) {
        if (localP) {
          moduleslist = Cons.cons(module, moduleslist);
        }
        else {
          { Module mod = null;
            Cons iter000 = Module.visibleModules(module);
            Cons collect000 = null;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              mod = ((Module)(iter000.value));
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(mod, Stella.NIL);
                  if (moduleslist == Stella.NIL) {
                    moduleslist = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(moduleslist, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(mod, Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
        }
      }
      iterator.iteratorConsList = moduleslist;
      iterator.iteratorNextCode = nextcode;
      return (iterator);
    }
  }

  public static ExtensibleSymbolArray selectSymbolArray(int kindofsym) {
    switch (kindofsym) {
      case 0: 
        return (Stella.$SYMBOL_ARRAY$);
      case 1: 
        return (Stella.$SURROGATE_ARRAY$);
      case 2: 
        return (Stella.$KEYWORD_ARRAY$);
      default:
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + kindofsym + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
    }
  }

  public static Cons yieldVisibleRigidSymbolsWrtModule(String name, Module module, int kindofsym) {
    { Cons listofsymbols = Stella.NIL;
      GeneralizedSymbol symbol = null;

      { Module visiblemodule = null;
        Cons iter000 = Module.visibleModules(module);

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          visiblemodule = ((Module)(iter000.value));
          { 
            symbol = GeneralizedSymbol.lookupRigidSymbolLocally(name, visiblemodule, kindofsym);
            if (symbol != null) {
              listofsymbols = Cons.cons(symbol, listofsymbols);
            }
          }
        }
      }
      return (listofsymbols.reverse());
    }
  }

  public static Iterator visibleRigidSymbolsWrtModule(String name, Module module, int kindofsym) {
    return (Stella.yieldVisibleRigidSymbolsWrtModule(name, module, kindofsym).allocateDestructiveListIterator());
  }

  public static int lookupRigidSymbolOffsetWrtModule(String name, Module module, int kindofsym) {
    { StringToIntegerHashTable offsettable = Module.selectSymbolOffsetTable(module, kindofsym);
      int offset = offsettable.lookup(name);

      if (offset != Stella.NULL_INTEGER) {
        return (offset);
      }
      { Module renamed_Super = null;
        Cons iter000 = Module.visibleModules(module).rest;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          renamed_Super = ((Module)(iter000.value));
          offset = Module.selectSymbolOffsetTable(renamed_Super, kindofsym).lookup(name);
          if (offset != Stella.NULL_INTEGER) {
            return (offset);
          }
        }
      }
      return (Stella.NULL_INTEGER);
    }
  }

  public static GeneralizedSymbol lookupRigidSymbolWrtModule(String name, Module module, int kindofsym) {
    { int offset = Stella.lookupRigidSymbolOffsetWrtModule(name, module, kindofsym);

      if (offset != Stella.NULL_INTEGER) {
        switch (kindofsym) {
          case 0: 
            return (Symbol.getSymFromOffset(offset));
          case 1: 
            return (Surrogate.getSgtFromOffset(offset));
          case 2: 
            return (Keyword.getKwdFromOffset(offset));
          default:
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + kindofsym + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
        }
      }
      else {
        return (null);
      }
    }
  }

  /** Return the list of symbols with <code>name</code> visible from <code>module</code>.
   * More specific symbols (relative to the module precedence order defined by
   * <code>visibleModules</code>) come earlier in the list.  If <code>module</code> is <code>null</code>, start
   * from <code>$MODULE$</code> instead.  If <code>enforceShadowingP</code> is true, do not return any
   * symbols that are shadowed due to some :SHADOW declaration.
   * @param name
   * @param module
   * @param enforceshadowingP
   * @return Cons
   */
  public static Cons lookupVisibleSymbolsInModule(String name, Module module, boolean enforceshadowingP) {
    { Cons visiblesymbols = Stella.yieldVisibleRigidSymbolsWrtModule(name, module, Stella.SYMBOL_SYM);

      if (enforceshadowingP &&
          (!(visiblesymbols.rest == Stella.NIL))) {
        return (((Cons)(Cons.removeShadowedSymbols(visiblesymbols))));
      }
      else {
        return (((Cons)(visiblesymbols)));
      }
    }
  }

  /** Return the list of surrogates with <code>name</code> visible from <code>module</code>.
   * More specific surrogates (relative to the module precedence order defined by
   * <code>visibleModules</code>) come earlier in the list.  If <code>module</code> is <code>null</code>, start
   * from <code>$MODULE$</code> instead.  If <code>enforceShadowingP</code> is true, do not return any
   * surrogates that are shadowed due to some :SHADOW declaration.
   * @param name
   * @param module
   * @param enforceshadowingP
   * @return Cons
   */
  public static Cons lookupVisibleSurrogatesInModule(String name, Module module, boolean enforceshadowingP) {
    { Cons visiblesurrogates = Stella.yieldVisibleRigidSymbolsWrtModule(name, module, Stella.SURROGATE_SYM);

      if (enforceshadowingP &&
          (!(visiblesurrogates.rest == Stella.NIL))) {
        return (((Cons)(Cons.removeShadowedSymbols(visiblesurrogates))));
      }
      else {
        return (((Cons)(visiblesurrogates)));
      }
    }
  }

  /** Return a newly-created or existing keyword with name
   * <code>name</code>.  Storage note: a COPY of <code>name</code> is stored in the keyword
   * @param name
   * @return Keyword
   */
  public static Keyword internKeyword(String name) {
    return (((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule(Native.stringUpcase(name), ((Module)(Stella.$MODULE$.get())), Stella.KEYWORD_SYM))));
  }

  /** Interns a symbol, or keyword with
   * <code>name</code> and symbol-id <code>offset</code>.
   * If a symbol with that ID already existed, an error is signaled.  This
   * function is used to recreate the symbol table in a way where symbol IDs
   * which got hardwired into translated code will refer to the correct objects.
   * @param name
   * @param offset
   * @param kindofsym
   * @return GeneralizedSymbol
   */
  public static GeneralizedSymbol internBootstrapSymbolAt(String name, int offset, int kindofsym) {
    { ExtensibleSymbolArray symbolarray = null;
      GeneralizedSymbol symbol = null;

      switch (kindofsym) {
        case 0: 
          symbol = Symbol.lookupSymbol(name);
        break;
        case 1: 
          symbol = Surrogate.lookupSurrogate(name);
        break;
        case 2: 
          symbol = Keyword.lookupKeyword(name);
        break;
        default:
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + kindofsym + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
      }
      if (symbol != null) {
        if (!(symbol.symbolId == offset)) {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: intern-bootstrap-symbol-at: `" + symbol + "' is already interned at offset `" + symbol.symbolId + "'");
        }
        return (symbol);
      }
      symbolarray = Stella.selectSymbolArray(kindofsym);
      if (ExtensibleSymbolArray.legalSymbolArrayOffsetP(symbolarray, offset) &&
          (GeneralizedSymbol.getGeneralizedSymbolFromOffset(symbolarray, offset) != null)) {
        symbol = GeneralizedSymbol.getGeneralizedSymbolFromOffset(symbolarray, offset);
        Stella.STANDARD_WARNING.nativeStream.println("Warning: intern-bootstrap-symbol-at: `" + symbol + "' is already interned at offset `" + offset + "'");
        return (symbol);
      }
      { ExtensibleSymbolArray array = Stella.selectSymbolArray(kindofsym);

        return (GeneralizedSymbol.helpInternGeneralizedSymbol(name, kindofsym, array, offset, ((Module)(Stella.$MODULE$.get()))));
      }
    }
  }

  public static Symbol internSymbolAt(String name, int offset) {
    return (((Symbol)(Stella.internBootstrapSymbolAt(name, offset, Stella.SYMBOL_SYM))));
  }

  public static Surrogate internSurrogateAt(String name, int offset) {
    return (((Surrogate)(Stella.internBootstrapSymbolAt(name, offset, Stella.SURROGATE_SYM))));
  }

  public static Keyword internKeywordAt(String name, int offset) {
    return (((Keyword)(Stella.internBootstrapSymbolAt(name, offset, Stella.KEYWORD_SYM))));
  }

  public static void initializeKernelModules() {
    Stella.$ROOT_MODULE$ = Module.newModule();
    Module.initializeKernelModule(Stella.$ROOT_MODULE$, "ROOT-MODULE", "/", null);
    Stella.$STELLA_MODULE$ = Module.newModule();
    Module.initializeKernelModule(Stella.$STELLA_MODULE$, "STELLA", "/STELLA", Stella.$ROOT_MODULE$);
    Stella.$COMMON_LISP_MODULE$ = Module.newModule();
    Module.initializeKernelModule(Stella.$COMMON_LISP_MODULE$, "COMMON-LISP", "/COMMON-LISP", Stella.$ROOT_MODULE$);
    KeyValueList.setDynamicSlotValue(Stella.$COMMON_LISP_MODULE$.dynamicSlots, Stella.SYM_STELLA_MODULE_LISP_PACKAGE, StringWrapper.wrapString("CL"), Stella.NULL_STRING_WRAPPER);
    Stella.$ROOT_MODULE$.cardinalModule = Stella.$STELLA_MODULE$;
    Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
    Stella.$MODULE$.setDefaultValue(Stella.$STELLA_MODULE$);
    Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
    Stella.$CONTEXT$.setDefaultValue(Stella.$MODULE$.get());
  }

  public static void initializeSymbolsAndKernelModules() {
    Stella.$FIXED_SYMBOL_ARRAY$ = ExtensibleSymbolArray.newExtensibleSymbolArray(100);
    Stella.$FIXED_SURROGATE_ARRAY$ = ExtensibleSymbolArray.newExtensibleSymbolArray(100);
    Stella.$FIXED_KEYWORD_ARRAY$ = ExtensibleSymbolArray.newExtensibleSymbolArray(100);
    Stella.$KEYWORD_OFFSET_TABLE$ = StringToIntegerHashTable.newStringToIntegerHashTable();
    Stella.$SYMBOL_ARRAY$ = Stella.$FIXED_SYMBOL_ARRAY$;
    Stella.$SURROGATE_ARRAY$ = Stella.$FIXED_SURROGATE_ARRAY$;
    Stella.$KEYWORD_ARRAY$ = Stella.$FIXED_KEYWORD_ARRAY$;
    Stella.initializeKernelModules();
  }

  public static Symbol lookupTransientSymbol(String name) {
    if (Stella.$TRANSIENT_SYMBOL_LOOKUP_TABLE$ != null) {
      return (((Symbol)(Stella.$TRANSIENT_SYMBOL_LOOKUP_TABLE$.lookup(name))));
    }
    else {
      {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Looking for a transient symbol when the parsing tables have\nnot been initialized.");
        return (null);
      }
    }
  }

  public static Symbol internTransientSymbol(String name) {
    { Symbol symbol = Symbol.lookupSymbolInModule(name, ((Module)(Stella.$MODULE$.get())), false);

      if (symbol != null) {
        return (symbol);
      }
      symbol = Stella.lookupTransientSymbol(name);
      if (symbol != null) {
        return (symbol);
      }
      symbol = TransientSymbol.newTransientSymbol(name);
      symbol.homeContext = null;
      Stella.$TRANSIENT_SYMBOL_LOOKUP_TABLE$.insertAt(name, symbol);
      return (symbol);
    }
  }

  public static void freeTransientSymbols() {
    Stella.$TRANSIENT_SYMBOL_LOOKUP_TABLE$.initializeHashTable();
  }

  public static Symbol internCommonLispSymbol(String name) {
    { Symbol symbol = ((Symbol)(Stella.lookupRigidSymbolWrtModule(name, Stella.$COMMON_LISP_MODULE$, Stella.SYMBOL_SYM)));

      if (symbol != null) {
        return (symbol);
      }
      name = Native.stringUpcase(name);
      symbol = ((Symbol)(Stella.lookupRigidSymbolWrtModule(name, Stella.$COMMON_LISP_MODULE$, Stella.SYMBOL_SYM)));
      if (symbol != null) {
        return (symbol);
      }
      symbol = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule(name, Stella.$COMMON_LISP_MODULE$, Stella.SYMBOL_SYM)));
      return (symbol);
    }
  }

  /** Create indices for recording transient symbols and
   * Common Lisp symbols while parsing.
   */
  public static void initializeParsingTables() {
    Stella.$TRANSIENT_SYMBOL_LOOKUP_TABLE$ = StringHashTable.newStringHashTable();
    Stella.$COMMON_LISP_SYMBOL_LOOKUP_TABLE$ = StringHashTable.newStringHashTable();
  }

  public static String yieldGensymName(String prefix, int counter) {
    { String suffix = Native.integerToString(((long)(counter)));
      int maskend = 4 - suffix.length();

      if (maskend < 1) {
        maskend = 1;
      }
      return (prefix + Native.string_subsequence(Stella.$GENSYM_MASK$, 0, maskend) + suffix);
    }
  }

  public static String yieldUniqueGensymName(String prefix, Module module) {
    { String gensymName = Stella.yieldGensymName(prefix, Stella.$GENSYM_COUNTER$ = Stella.$GENSYM_COUNTER$ + 1);

      while (Symbol.lookupSymbolInModule(gensymName, module, false) != null) {
        gensymName = Stella.yieldGensymName(prefix, Stella.$GENSYM_COUNTER$ = Stella.$GENSYM_COUNTER$ + 1);
      }
      return (gensymName);
    }
  }

  /** Return a transient symbol with a name beginning with
   * <code>prefix</code> and ending with a globally gensym'd integer.
   * @param prefix
   * @return Symbol
   */
  public static Symbol gensym(String prefix) {
    return (Stella.internTransientSymbol(Stella.yieldUniqueGensymName(prefix, ((Module)(Stella.$MODULE$.get())))));
  }

  /** Return a surrogate with the name 'self' visible
   * in the current module.  Very tricky: The logic is designed to avoid
   * returning an inherited surrogate that has no value.  In that case,
   * a new local surrogate is created that shadows the inherited surrogate.
   * @param self
   * @return Surrogate
   */
  public static Surrogate stringToSurrogate(String self) {
    { Surrogate surrogate = Surrogate.internSurrogateInModule(self, ((Module)(Stella.$MODULE$.get())), false);

      if ((surrogate.homeContext == ((Module)(Stella.$MODULE$.get()))) ||
          (surrogate.surrogateValue != null)) {
        return (surrogate);
      }
      return (Surrogate.internSurrogateInModule(self, ((Module)(Stella.$MODULE$.get())), true));
    }
  }

  /** Converts 'self' into a surrogate.
   * @param self
   * @return Surrogate
   */
  public static Surrogate string_surrogatify(String self) {
    return (Surrogate.internSurrogate(self));
  }

  public static Keyword string_keywordify(String self) {
    return (Stella.internKeyword(self));
  }

  /** Return TRUE if name is prefixed by 'SURROGATE-PREFIX-CHARACTER'.
   * @param name
   * @return boolean
   */
  public static boolean surrogateNameP(String name) {
    return ((name.length() > 0) &&
        (name.charAt(0) == Stella.SURROGATE_PREFIX_CHARACTER));
  }

  /** Return TRUE if name is prefixed by ':'.
   * @param name
   * @return boolean
   */
  public static boolean keywordNameP(String name) {
    return ((name.length() > 0) &&
        (name.charAt(0) == ':'));
  }

  /** Parse <code>name</code> which is assumed to be the printed
   * representation of a STELLA symbol, surrogate or keyword, intern
   * it into the current or specified module and return the result.
   * This is identical to calling <code>unstringify</code> on <code>name</code> but 10-15
   * times faster.
   * @param name
   * @return GeneralizedSymbol
   */
  public static GeneralizedSymbol internStellaName(String name) {
    { Module module = ((Module)(Stella.$MODULE$.get()));

      { String barename = null;
        String modulename = null;
        Keyword kind = null;

        { Object [] caller_MV_returnarray = new Object[2];

          barename = Stella.parseStellaName(name, true, caller_MV_returnarray);
          modulename = ((String)(((StringWrapper)(caller_MV_returnarray[0])).wrapperValue));
          kind = ((Keyword)(caller_MV_returnarray[1]));
        }
        if (modulename != null) {
          module = Stella.getStellaModule(modulename, true);
        }
        if (kind == Stella.KWD_SYMBOL) {
          if (((Boolean)(Stella.$TRANSIENTOBJECTSp$.get())).booleanValue() &&
              (modulename == null)) {
            return (Stella.internTransientSymbol(barename));
          }
          else {
            return (Symbol.internSymbolInModule(barename, module, false));
          }
        }
        else if (kind == Stella.KWD_SURROGATE) {
          return (Surrogate.internSurrogateInModule(barename, module, false));
        }
        else if (kind == Stella.KWD_KEYWORD) {
          return (GeneralizedSymbol.internRigidSymbolWrtModule(barename, null, Stella.KEYWORD_SYM));
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + kind + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  public static String computeFullName(String name, Module module) {
    if (module == null) {
      return (name);
    }
    else if (Stella.stringEqlP(name, "")) {
      { String pathname = "";

        while (module != null) {
          pathname = Stella.MODULE_SEPARATOR_STRING + module.moduleName + pathname;
          module = ((Module)(module.parentModules.first()));
        }
        return (pathname);
      }
    }
    else {
      { String modulefullname = module.moduleFullName;

        if (modulefullname == null) {
          modulefullname = Stella.computeFullName("", module);
        }
        return (modulefullname + Stella.MODULE_SEPARATOR_STRING + name);
      }
    }
  }

  public static boolean symbolConstituentCharacterP(char character) {
    { Keyword testValue000 = Stella.$CHARACTER_TYPE_TABLE$[(int) character];

      if ((testValue000 == Stella.KWD_LETTER) ||
          ((testValue000 == Stella.KWD_DIGIT) ||
           (testValue000 == Stella.KWD_SYMBOL_CONSTITUENT))) {
        return (true);
      }
      else {
        return (false);
      }
    }
  }

  public static String initializeSymbolEscapeCodeTable(boolean casesensitiveP) {
    { StringBuffer buffer = edu.isi.stella.javalib.Native.makeMutableString(256, Stella.NULL_CHARACTER);

      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = 255;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          { Keyword testValue000 = Stella.$CHARACTER_TYPE_TABLE$[i];

            if (testValue000 == Stella.KWD_DIGIT) {
              edu.isi.stella.javalib.Native.mutableString_nthSetter(buffer, ((char) 1), i);
            }
            else if ((testValue000 == Stella.KWD_LETTER) ||
                (testValue000 == Stella.KWD_SYMBOL_CONSTITUENT)) {
              if ((!casesensitiveP) &&
                  Stella.lowerCaseCharacterP((char) i)) {
                edu.isi.stella.javalib.Native.mutableString_nthSetter(buffer, ((char) 2), i);
              }
              else {
                edu.isi.stella.javalib.Native.mutableString_nthSetter(buffer, ((char) 0), i);
              }
            }
            else {
              edu.isi.stella.javalib.Native.mutableString_nthSetter(buffer, ((char) 2), i);
            }
          }
        }
      }
      { char ch = Stella.NULL_CHARACTER;
        String vector000 = ".+-";
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          ch = vector000.charAt(index000);
          edu.isi.stella.javalib.Native.mutableString_nthSetter(buffer, ((char) 1), ((int) ch));
        }
      }
      edu.isi.stella.javalib.Native.mutableString_nthSetter(buffer, ((char) 3), ((int) '\\'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(buffer, ((char) 3), ((int) '|'));
      return (buffer.toString());
    }
  }

  public static Keyword computeSymbolEscapeCode(String name, boolean casesensitiveP) {
    { String table = (casesensitiveP ? Stella.$CASE_SENSITIVE_SYMBOL_ESCAPE_CODE_TABLE$ : Stella.$SYMBOL_ESCAPE_CODE_TABLE$);
      int escapecode = 0;
      int maxescapecode = 0;
      boolean firstcharP = true;
      boolean couldbenumberP = true;

      { char ch = Stella.NULL_CHARACTER;
        String vector000 = name;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          ch = vector000.charAt(index000);
          escapecode = (int) (table.charAt(((int) ch)));
          if (escapecode == 0) {
            if (couldbenumberP &&
                ((!(ch == 'E')) &&
                 (!(ch == 'e')))) {
              couldbenumberP = false;
            }
          }
          else if (firstcharP) {
            maxescapecode = escapecode;
            couldbenumberP = escapecode == 1;
          }
          else {
            if ((escapecode > 1) &&
                (escapecode > maxescapecode)) {
              maxescapecode = escapecode;
            }
          }
          firstcharP = false;
        }
      }
      if (firstcharP) {
        return (Stella.KWD_ESCAPED);
      }
      else {
        switch (maxescapecode) {
          case 0: 
            return (Stella.KWD_UNESCAPED);
          case 1: 
            if (couldbenumberP) {
              { TokenizerTable tok_table_ = Stella.$STELLA_TOKENIZER_TABLE$;
                String tok_transitions_ = tok_table_.transitions;
                edu.isi.stella.Stella_Object[] tok_statenames_ = tok_table_.stateNames.theArray;
                int tok_tokenstart_ = -1;
                boolean tok_endoftokensP_ = false;
                TokenizerStreamState tok_streamstate_ = null;
                char[] tok_buffer_ = name.toCharArray();
                int tok_state_ = 1;
                int tok_nextstate_ = tok_state_;
                int tok_cursor_ = 0;
                int tok_size_ = name.length();
                int tok_end_ = tok_size_;

                {
                  tok_statenames_ = tok_statenames_;
                  tok_endoftokensP_ = tok_endoftokensP_;
                }
                tok_streamstate_ = tok_streamstate_;
                { edu.isi.stella.Stella_Object[] tok_stellalogicalstatenames_ = Stella.$STELLA_LOGICAL_STATE_NAMES$.theArray;
                  Keyword tok_stellalogicalstatename_ = null;

                  {
                    {
                      tok_tokenstart_ = -1;
                      loop001 : for (;;) {
                        if (tok_cursor_ == tok_end_) {
                          if (tok_nextstate_ == -1) {
                            tok_endoftokensP_ = true;
                          }
                          else if (BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)((tok_table_.legalEofStates.theArray)[tok_state_])))) {
                            tok_nextstate_ = -1;
                            if (tok_tokenstart_ == -1) {
                              tok_endoftokensP_ = true;
                            }
                          }
                          else {
                            tok_state_ = 0;
                            tok_nextstate_ = -1;
                          }
                          break loop001;
                        }
                        tok_nextstate_ = (int) (tok_buffer_[tok_cursor_]);
                        tok_nextstate_ = (int) (tok_transitions_.charAt(((((tok_state_ << 8)) | tok_nextstate_))));
                        if ((tok_nextstate_ & 128) == 0) {
                          tok_state_ = tok_nextstate_;
                          tok_cursor_ = tok_cursor_ + 1;
                        }
                        else if (tok_tokenstart_ == -1) {
                          if ((tok_nextstate_ & 64) == 0) {
                            tok_tokenstart_ = tok_cursor_;
                          }
                          tok_state_ = (tok_nextstate_ & 63);
                          tok_cursor_ = tok_cursor_ + 1;
                        }
                        else {
                          break loop001;
                        }
                      }
                      if (tok_streamstate_ != null) {
                        tok_streamstate_.cursor = tok_cursor_;
                        tok_streamstate_.table = tok_table_;
                        tok_streamstate_.state = tok_state_;
                      }
                    }
                    tok_stellalogicalstatename_ = ((Keyword)(tok_stellalogicalstatenames_[tok_state_]));
                  }
                  if (tok_stellalogicalstatename_ == Stella.KWD_SYMBOL) {
                    couldbenumberP = false;
                  }
                }
              }
            }
            if (couldbenumberP) {
              return (Stella.KWD_ESCAPED);
            }
            else {
              return (Stella.KWD_UNESCAPED);
            }
          case 2: 
            if ((name.charAt(0) == '/') &&
                Stella.stringEqlP(name, "/")) {
              return (Stella.KWD_UNESCAPED);
            }
            else {
              return (Stella.KWD_ESCAPED);
            }
          case 3: 
            return (Stella.KWD_COMPLEX_ESCAPED);
          default:
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + maxescapecode + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
        }
      }
    }
  }

  public static void printSymbolNameReadably(String name, edu.isi.stella.javalib.NativeOutputStream stream, boolean casesensitiveP) {
    { Keyword testValue000 = Stella.computeSymbolEscapeCode(name, casesensitiveP);

      if (testValue000 == Stella.KWD_UNESCAPED) {
        stream.print(name);
      }
      else if (testValue000 == Stella.KWD_ESCAPED) {
        stream.print("|" + name + "|");
      }
      else if (testValue000 == Stella.KWD_COMPLEX_ESCAPED) {
        stream.print("|");
        { char ch = Stella.NULL_CHARACTER;
          String vector000 = name;
          int index000 = 0;
          int length000 = vector000.length();

          for (;index000 < length000; index000 = index000 + 1) {
            ch = vector000.charAt(index000);
            if ((ch == '\\') ||
                (ch == '|')) {
              stream.print("\\");
            }
            stream.print(ch);
          }
        }
        stream.print("|");
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static String readableSymbolName(String name, boolean casesensitiveP) {
    { Keyword testValue000 = Stella.computeSymbolEscapeCode(name, casesensitiveP);

      if (testValue000 == Stella.KWD_UNESCAPED) {
        return (name);
      }
      else if (testValue000 == Stella.KWD_ESCAPED) {
        return ("|" + name + "|");
      }
      else if (testValue000 == Stella.KWD_COMPLEX_ESCAPED) {
        { OutputStringStream s = OutputStringStream.newOutputStringStream();

          Stella.printSymbolNameReadably(name, s.nativeStream, casesensitiveP);
          return (s.theStringReader());
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  /** Return a literal object whose value is the LONG-INTEGER 'value'.
   * @param value
   * @return LongIntegerWrapper
   */
  public static LongIntegerWrapper wrapLongInteger(long value) {
    if (value == Stella.NULL_LONG_INTEGER) {
      return (Stella.NULL_LONG_INTEGER_WRAPPER);
    }
    else {
      return (LongIntegerWrapper.newLongIntegerWrapper(value));
    }
  }

  /** Return a literal object whose value is 'value'.  Choose a regular integer
   * wrapper unless <code>value</code> is too large and needs to be stored in a long wrapper.
   * @param value
   * @return NumberWrapper
   */
  public static NumberWrapper wrapIntegerValue(long value) {
    if ((value >= Stella.NULL_INTEGER) &&
        (value <= Stella.MOST_POSITIVE_INTEGER)) {
      { IntegerWrapper intwrapper = new IntegerWrapper();

        intwrapper.wrapperValue = ((int)(value));
        return (intwrapper);
      }
    }
    else {
      { LongIntegerWrapper longwrapper = new LongIntegerWrapper();

        longwrapper.wrapperValue = value;
        return (longwrapper);
      }
    }
  }

  public static IntegerWrapper integer_wrapLiteral(int value) {
    return (IntegerWrapper.wrapInteger(value));
  }

  public static LongIntegerWrapper longInteger_wrapLiteral(long value) {
    return (Stella.wrapLongInteger(value));
  }

  public static FloatWrapper float_wrapLiteral(double value) {
    return (FloatWrapper.wrapFloat(value));
  }

  public static MutableStringWrapper mutableString_wrapLiteral(StringBuffer value) {
    return (MutableStringWrapper.wrapMutableString(value));
  }

  public static StringWrapper string_wrapLiteral(String value) {
    return (StringWrapper.wrapString(value));
  }

  public static CharacterWrapper character_wrapLiteral(char value) {
    return (CharacterWrapper.wrapCharacter(value));
  }

  public static FunctionCodeWrapper functionCode_wrapLiteral(java.lang.reflect.Method value) {
    return (FunctionCodeWrapper.wrapFunctionCode(value));
  }

  public static MethodCodeWrapper methodCode_wrapLiteral(java.lang.reflect.Method value) {
    return (MethodCodeWrapper.wrapMethodCode(value));
  }

  public static void printCharacter(char renamed_Char, edu.isi.stella.javalib.NativeOutputStream stream) {
    stream.print("#\\");
    switch (renamed_Char) {
      case '\n': 
        stream.print("Linefeed");
      break;
      case '\b': 
        stream.print("Backspace");
      break;
      case '\t': 
        stream.print("Tab");
      break;
      case '\r': 
        stream.print("Return");
      break;
      case '\f': 
        stream.print("Page");
      break;
      default:
        stream.print(renamed_Char);
      break;
    }
  }

  public static Keyword[] createCharacterTypeTable() {
    { Keyword[] table = new Keyword[256];

      { int code = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = 255;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          code = iter000;
          table[code] = Stella.KWD_OTHER;
        }
      }
      { int code = Stella.NULL_INTEGER;
        int iter001 = (int) '0';
        int upperBound001 = (int) '9';
        boolean unboundedP000 = upperBound001 == Stella.NULL_INTEGER;

        for (;unboundedP000 ||
                  (iter001 <= upperBound001); iter001 = iter001 + 1) {
          code = iter001;
          table[code] = Stella.KWD_DIGIT;
        }
      }
      { int code = Stella.NULL_INTEGER;
        int iter002 = (int) 'A';
        int upperBound002 = (int) 'Z';
        boolean unboundedP001 = upperBound002 == Stella.NULL_INTEGER;

        for (;unboundedP001 ||
                  (iter002 <= upperBound002); iter002 = iter002 + 1) {
          code = iter002;
          table[code] = Stella.KWD_LETTER;
        }
      }
      { int code = Stella.NULL_INTEGER;
        int iter003 = (int) 'a';
        int upperBound003 = (int) 'z';
        boolean unboundedP002 = upperBound003 == Stella.NULL_INTEGER;

        for (;unboundedP002 ||
                  (iter003 <= upperBound003); iter003 = iter003 + 1) {
          code = iter003;
          table[code] = Stella.KWD_LETTER;
        }
      }
      table[(int) '!'] = Stella.KWD_SYMBOL_CONSTITUENT;
      table[(int) '$'] = Stella.KWD_SYMBOL_CONSTITUENT;
      table[(int) '%'] = Stella.KWD_SYMBOL_CONSTITUENT;
      table[(int) '<'] = Stella.KWD_SYMBOL_CONSTITUENT;
      table[(int) '>'] = Stella.KWD_SYMBOL_CONSTITUENT;
      table[(int) '='] = Stella.KWD_SYMBOL_CONSTITUENT;
      table[(int) '?'] = Stella.KWD_SYMBOL_CONSTITUENT;
      table[(int) '['] = Stella.KWD_SYMBOL_CONSTITUENT;
      table[(int) ']'] = Stella.KWD_SYMBOL_CONSTITUENT;
      table[(int) '^'] = Stella.KWD_SYMBOL_CONSTITUENT;
      table[(int) '_'] = Stella.KWD_SYMBOL_CONSTITUENT;
      table[(int) '{'] = Stella.KWD_SYMBOL_CONSTITUENT;
      table[(int) '}'] = Stella.KWD_SYMBOL_CONSTITUENT;
      table[(int) '~'] = Stella.KWD_SYMBOL_CONSTITUENT;
      table[(int) '*'] = Stella.KWD_SYMBOL_CONSTITUENT;
      table[(int) '.'] = Stella.KWD_SYMBOL_CONSTITUENT;
      table[(int) '+'] = Stella.KWD_SYMBOL_CONSTITUENT;
      table[(int) '-'] = Stella.KWD_SYMBOL_CONSTITUENT;
      table[(int) ':'] = Stella.KWD_SYMBOL_QUALIFIER;
      table[(int) '/'] = Stella.KWD_SYMBOL_QUALIFIER;
      table[(int) '@'] = Stella.KWD_SYMBOL_QUALIFIER;
      table[(int) '\\'] = Stella.KWD_ESCAPE;
      table[(int) '('] = Stella.KWD_DELIMITER;
      table[(int) ')'] = Stella.KWD_DELIMITER;
      table[(int) '"'] = Stella.KWD_DELIMITER;
      table[(int) '|'] = Stella.KWD_DELIMITER;
      table[(int) '\''] = Stella.KWD_DELIMITER;
      table[(int) '`'] = Stella.KWD_DELIMITER;
      table[(int) ','] = Stella.KWD_DELIMITER;
      table[(int) ' '] = Stella.KWD_WHITE_SPACE;
      table[(int) '\t'] = Stella.KWD_WHITE_SPACE;
      table[(int) '\n'] = Stella.KWD_WHITE_SPACE;
      table[(int) '\r'] = Stella.KWD_WHITE_SPACE;
      table[(int) '\n'] = Stella.KWD_WHITE_SPACE;
      table[(int) '\f'] = Stella.KWD_WHITE_SPACE;
      return (table);
    }
  }

  /** Return TRUE if <code>ch</code> represents a digit.
   * @param ch
   * @return boolean
   */
  public static boolean digitCharacterP(char ch) {
    return (Stella.$CHARACTER_TYPE_TABLE$[(int) ch] == Stella.KWD_DIGIT);
  }

  /** Return TRUE if <code>ch</code> represents a letter.
   * @param ch
   * @return boolean
   */
  public static boolean letterCharacterP(char ch) {
    return (Stella.$CHARACTER_TYPE_TABLE$[(int) ch] == Stella.KWD_LETTER);
  }

  /** Return TRUE if <code>ch</code> represents an upper-case character.
   * @param ch
   * @return boolean
   */
  public static boolean upperCaseCharacterP(char ch) {
    { int charcode = (int) ch;

      return ((charcode >= (int) 'A') &&
          (charcode <= (int) 'Z'));
    }
  }

  /** Return TRUE if <code>ch</code> represents a lower-case character.
   * @param ch
   * @return boolean
   */
  public static boolean lowerCaseCharacterP(char ch) {
    { int charcode = (int) ch;

      return ((charcode >= (int) 'a') &&
          (charcode <= (int) 'z'));
    }
  }

  /** Return TRUE if <code>ch</code> is a white space character.
   * @param ch
   * @return boolean
   */
  public static boolean whiteSpaceCharacterP(char ch) {
    return (Stella.$CHARACTER_TYPE_TABLE$[(int) ch] == Stella.KWD_WHITE_SPACE);
  }

  /** Return TRUE if all letters in <code>s</code> are upper case.
   * @param s
   * @return boolean
   */
  public static boolean allUpperCaseStringP(String s) {
    { int code = 0;
      int codea = (int) 'a';
      int codez = (int) 'z';

      { char ch = Stella.NULL_CHARACTER;
        String vector000 = s;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          ch = vector000.charAt(index000);
          code = (int) ch;
          if ((code >= codea) &&
              (code <= codez)) {
            return (false);
          }
        }
      }
      return (true);
    }
  }

  /** Return TRUE if all letters in <code>s</code> are lower case.
   * @param s
   * @return boolean
   */
  public static boolean allLowerCaseStringP(String s) {
    { int code = 0;
      int codea = (int) 'A';
      int codez = (int) 'Z';

      { char ch = Stella.NULL_CHARACTER;
        String vector000 = s;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          ch = vector000.charAt(index000);
          code = (int) ch;
          if ((code <= codez) &&
              (code >= codea)) {
            return (false);
          }
        }
      }
      return (true);
    }
  }

  public static String initializeCharacterUpcaseTable() {
    { StringBuffer buffer = edu.isi.stella.javalib.Native.makeMutableString(256, Stella.NULL_CHARACTER);

      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = 255;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          edu.isi.stella.javalib.Native.mutableString_nthSetter(buffer, ((char) i), i);
          if ((i >= (int) 'a') &&
              (i <= (int) 'z')) {
            edu.isi.stella.javalib.Native.mutableString_nthSetter(buffer, ((char) ((int) 'A' + (i - (int) 'a'))), i);
          }
        }
      }
      return (buffer.toString());
    }
  }

  public static String initializeCharacterDowncaseTable() {
    { StringBuffer buffer = edu.isi.stella.javalib.Native.makeMutableString(256, Stella.NULL_CHARACTER);

      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = 255;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          edu.isi.stella.javalib.Native.mutableString_nthSetter(buffer, ((char) i), i);
          if ((i >= (int) 'A') &&
              (i <= (int) 'Z')) {
            edu.isi.stella.javalib.Native.mutableString_nthSetter(buffer, ((char) ((int) 'a' + (i - (int) 'A'))), i);
          }
        }
      }
      return (buffer.toString());
    }
  }

  /** If <code>renamed_Char</code> is lowercase, return its uppercase version,
   * otherwise, return 'char' unmodified.
   * @param renamed_Char
   * @return char
   */
  public static char upcaseCharacter(char renamed_Char) {
    return (Stella.$CHARACTER_UPCASE_TABLE$.charAt(((int) renamed_Char)));
  }

  /** If <code>renamed_Char</code> is uppercase, return its lowercase version,
   * otherwise, return 'char' unmodified.
   * @param renamed_Char
   * @return char
   */
  public static char downcaseCharacter(char renamed_Char) {
    return (Stella.$CHARACTER_DOWNCASE_TABLE$.charAt(((int) renamed_Char)));
  }

  public static void printStringReadably(String string, edu.isi.stella.javalib.NativeOutputStream stream) {
    if (string == null) {
      stream.print(Stella.SYM_STELLA_NULL_STRING);
    }
    else {
      {
        stream.print("\"");
        { int i = Stella.NULL_INTEGER;
          int iter000 = 0;
          int upperBound000 = string.length() - 1;

          for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
            i = iter000;
            { char renamed_Char = string.charAt(i);

              if ((renamed_Char == '"') ||
                  (renamed_Char == '\\')) {
                stream.print("\\" + renamed_Char);
              }
              else {
                stream.print(renamed_Char);
              }
            }
          }
        }
        stream.print("\"");
      }
    }
  }

  /** Copy <code>s</code> into a mutable string with the same content.
   * In Lisp and C++ this simply copies <code>s</code>.
   * @param s
   * @return StringBuffer
   */
  public static StringBuffer stringToMutableString(String s) {
    return (new StringBuffer(s));
  }

  /** Convert <code>s</code> into a regular string with the same content.
   * In Lisp and C++ this is a no-op.
   * @param s
   * @return String
   */
  public static String mutableStringToString(StringBuffer s) {
    return (s.toString());
  }

  /** Return a class with name <code>name</code>.  Scan all
   * visible surrogates looking for one that has a class defined for it.
   * @param name
   * @return Stella_Class
   */
  public static Stella_Class string_lookupClass(String name) {
    { Stella_Class renamed_Class = null;
      Surrogate surrogate = null;

      { Module module = null;
        Cons iter000 = Module.visibleModules(((Module)(Stella.$MODULE$.get())));

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          module = ((Module)(iter000.value));
          { boolean testValue000 = false;

            { 
              surrogate = ((Surrogate)(GeneralizedSymbol.lookupRigidSymbolLocally(name, module, Stella.SURROGATE_SYM)));
              testValue000 = surrogate != null;
            }
            if (testValue000) {
              { 
                renamed_Class = ((Stella_Class)(surrogate.surrogateValue));
                testValue000 = renamed_Class != null;
              }
              if (testValue000) {
                testValue000 = Stella_Object.isaP(renamed_Class, Stella.SGT_STELLA_CLASS);
              }
            }
            if (testValue000) {
              return (renamed_Class);
            }
          }
        }
      }
      return (null);
    }
  }

  /** Return a class with name <code>className</code>.  If none exists, break
   * if <code>errorP</code>, else return <code>null</code>.
   * @param className
   * @param errorP
   * @return Stella_Class
   */
  public static Stella_Class string_getStellaClass(String className, boolean errorP) {
    { Surrogate type = Surrogate.lookupSurrogate(className);

      if (type != null) {
        return (type.getStellaClass(errorP));
      }
      if (errorP) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Class ``" + className + "'' does not exist.");
          { String error_message_ = stream000.theStringReader();

            Native.continuableError(error_message_);
          }
        }
      }
      return (null);
    }
  }

  public static Symbol shadowSymbol(String name) {
    return (((Symbol)(GeneralizedSymbol.internRigidSymbolLocally(name, ((Module)(Stella.$MODULE$.get())), Stella.SYMBOL_SYM))));
  }

  public static Surrogate shadowSurrogate(String name) {
    Stella.shadowSymbol(name);
    return (((Surrogate)(GeneralizedSymbol.internRigidSymbolLocally(name, ((Module)(Stella.$MODULE$.get())), Stella.SURROGATE_SYM))));
  }

  /** Finalize all currently unfinalized classes.
   */
  public static void finalizeClasses() {
    if (!Stella.$NEWLY_UNFINALIZED_CLASSESp$) {
      return;
    }
    { boolean hierarchymighthavechangedP = false;

      Stella.$UNFINALIZED_CLASSES$.removeDeletedMembers();
      Stella.resolveChildrenReferences();
      { Stella_Class renamed_Class = null;
        Cons iter000 = Stella.$UNFINALIZED_CLASSES$.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          renamed_Class = ((Stella_Class)(iter000.value));
          if ((!renamed_Class.classFinalizedP) &&
              (!BooleanWrapper.coerceWrappedBooleanToBoolean(renamed_Class.badP()))) {
            Stella_Class.finalizeClass(renamed_Class);
            hierarchymighthavechangedP = true;
          }
        }
      }
      if (hierarchymighthavechangedP) {
        TaxonomyGraph.finalizeTaxonomyGraph(Stella.$CLASS_TAXONOMY_GRAPH$);
      }
    }
  }

  public static void resolveChildrenReferences() {
    if (Stella.$CLASSES_WITH_UNRESOLVED_CHILDREN_REFERENCES$.emptyP() ||
        Stella.$UNFINALIZED_CLASSES$.emptyP()) {
      return;
    }
    { Cons unresolvableclasses = Stella.NIL;

      Stella.$CLASSES_WITH_UNRESOLVED_CHILDREN_REFERENCES$.removeDeletedMembers();
      { Stella_Class renamed_Class = null;
        Cons iter000 = Stella.$CLASSES_WITH_UNRESOLVED_CHILDREN_REFERENCES$.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          renamed_Class = ((Stella_Class)(iter000.value));
          Stella_Class.addDirectSubsBackLinks(renamed_Class);
          { boolean foundP000 = false;

            { Surrogate sub = null;
              Cons iter001 = renamed_Class.classDirectSubs.theConsList;

              loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                sub = ((Surrogate)(iter001.value));
                if (!(Surrogate.typeToClass(sub) != null)) {
                  foundP000 = true;
                  break loop001;
                }
              }
            }
            if (foundP000) {
              unresolvableclasses = Cons.cons(renamed_Class, unresolvableclasses);
            }
          }
        }
      }
      Stella.$CLASSES_WITH_UNRESOLVED_CHILDREN_REFERENCES$.clear();
      Stella.$CLASSES_WITH_UNRESOLVED_CHILDREN_REFERENCES$.theConsList = unresolvableclasses;
    }
  }

  /** Finalize all currently unfinalized slots.
   */
  public static void finalizeSlots() {
    if (!Stella.$NEWLY_UNFINALIZED_CLASSESp$) {
      return;
    }
    { Stella_Class renamed_Class = null;
      Cons iter000 = Stella.$UNFINALIZED_CLASSES$.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        renamed_Class = ((Stella_Class)(iter000.value));
        if (renamed_Class.classFinalizedP &&
            ((!renamed_Class.classSlotsFinalizedP) &&
             (!BooleanWrapper.coerceWrappedBooleanToBoolean(renamed_Class.badP())))) {
          Stella_Class.finalizeClassSlots(renamed_Class);
        }
      }
    }
  }

  /** Remove all finalized classes from <code>$UNFINALIZED_CLASSES$</code>,
   * and set <code>$NEWLY_UNFINALIZED_CLASSESP$</code> to <code>false</code>.
   */
  public static void cleanupUnfinalizedClasses() {
    { Cons unfinalizedclasses = Stella.NIL;

      { Stella_Class renamed_Class = null;
        Cons iter000 = Stella.$UNFINALIZED_CLASSES$.theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          renamed_Class = ((Stella_Class)(iter000.value));
          if ((!renamed_Class.classFinalizedP) ||
              (!renamed_Class.classSlotsFinalizedP)) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(renamed_Class, Stella.NIL);
                if (unfinalizedclasses == Stella.NIL) {
                  unfinalizedclasses = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(unfinalizedclasses, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(renamed_Class, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      Stella.$UNFINALIZED_CLASSES$.clear();
      Stella.$UNFINALIZED_CLASSES$.theConsList = unfinalizedclasses;
      Stella.$NEWLY_UNFINALIZED_CLASSESp$ = false;
    }
  }

  /** Finalize all currently unfinalized classes and slots.
   */
  public static void finalizeClassesAndSlots() {
    Stella.finalizeClasses();
    Stella.finalizeSlots();
    Stella.cleanupUnfinalizedClasses();
  }

  /** Reset all slot caches to have size <code>size</code>.
   * @param size
   */
  public static void resizeSlotCaches(int size) {
    Stella.$SLOT_CACHE_SIZE$ = size;
    { Stella_Class c = null;
      Iterator iter000 = Module.allClasses(null, false);

      while (iter000.nextP()) {
        c = ((Stella_Class)(iter000.value));
        c.classSlotAndMethodCache = Vector.newVector(size);
        { Slot s = null;
          Cons iter001 = c.localSlots().theConsList;

          for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
            s = ((Slot)(iter001.value));
            s.slotName.symbolSlotOffset = 0;
          }
        }
      }
    }
  }

  public static void repairSlots() {
    { Stella_Class top = ((Stella_Class)(Stella.SGT_STELLA_OBJECT.surrogateValue));

      Stella_Class.unfinalizeClassSlots(top);
      Stella.finalizeClassesAndSlots();
    }
  }

  public static void disconnectClasses() {
    { Surrogate surrogate = null;
      Iterator iter000 = Module.allSurrogates(((Module)(Stella.$MODULE$.get())), false);

      while (iter000.nextP()) {
        surrogate = ((Surrogate)(iter000.value));
        if ((surrogate.surrogateValue != null) &&
            Stella_Object.stellaClassP(surrogate.surrogateValue)) {
          surrogate.surrogateValue = null;
        }
      }
    }
  }

  /** Print all unbound surrogates visible from the module named by the first
   * argument (a symbol or string).  Look at all modules if no module name or
   * <code>null</code> was supplied.  If the second argument is <code>true</code>, only consider
   * surrogates interned in the specified module.
   * @param args
   */
  public static void printUnboundSurrogates(Cons args) {
    { Cons arglist = args;
      String name = Stella_Object.nameToString(arglist.value);
      Module module = ((name != null) ? Stella.getStellaModule(name, true) : ((Module)(null)));
      boolean localP = false;

      if (arglist.rest.value == Stella.SYM_STELLA_TRUE) {
        localP = true;
      }
      { Surrogate surrogate = null;
        Iterator iter000 = Module.unboundSurrogates(module, localP);

        while (iter000.nextP()) {
          surrogate = ((Surrogate)(iter000.value));
          Stella.STANDARD_OUTPUT.nativeStream.println(surrogate.toString());
        }
      }
    }
  }

  public static void createClassTaxonomy() {
    { TaxonomyGraph graph = Stella.$CLASS_TAXONOMY_GRAPH$;

      if (graph == null) {
        graph = TaxonomyGraph.newTaxonomyGraph();
      }
      else {
        TaxonomyGraph.initializeTaxonomyGraph(graph);
      }
      { Stella_Class renamed_Class = null;
        Iterator iter000 = Module.allClasses(null, false);

        while (iter000.nextP()) {
          renamed_Class = ((Stella_Class)(iter000.value));
          renamed_Class.classTaxonomyNode = TaxonomyGraph.createTaxonomyNode(graph, renamed_Class.classTaxonomyNode, renamed_Class, renamed_Class.classDirectSupers.emptyP());
        }
      }
      { Stella_Class renamed_Class = null;
        Iterator iter001 = Module.allClasses(null, false);

        while (iter001.nextP()) {
          renamed_Class = ((Stella_Class)(iter001.value));
          { Surrogate sub = null;
            Cons iter002 = renamed_Class.classDirectSubs.theConsList;

            for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
              sub = ((Surrogate)(iter002.value));
              if (((Stella_Class)(sub.surrogateValue)) != null) {
                TaxonomyGraph.linkTaxonomyNodes(graph, renamed_Class.classTaxonomyNode, ((Stella_Class)(sub.surrogateValue)).classTaxonomyNode);
              }
            }
          }
        }
      }
      TaxonomyGraph.finalizeTaxonomyGraph(graph);
      Stella.$CLASS_TAXONOMY_GRAPH$ = graph;
    }
  }

  public static Surrogate internSlotref(String classname, String slotname) {
    return (Surrogate.internSurrogate(classname + "." + slotname));
  }

  /** Apply <code>code</code> to <code>arguments</code>, returning a value of type OBJECT.
   * Currently limited to at most 10 <code>arguments</code>.
   * @param code
   * @param arguments
   * @return Stella_Object
   */
  public static Stella_Object apply(java.lang.reflect.Method code, Cons arguments) {
    if (arguments == Stella.NIL) {
      return (((Stella_Object)(edu.isi.stella.javalib.Native.funcall(code, null, new java.lang.Object [] {}))));
    }
    else {
      { Stella_Object arg1 = arguments.value;

        arguments = arguments.rest;
        if (arguments == Stella.NIL) {
          return (((Stella_Object)(edu.isi.stella.javalib.Native.funcall(code, null, new java.lang.Object [] {arg1}))));
        }
        { Stella_Object arg2 = arguments.value;

          arguments = arguments.rest;
          if (arguments == Stella.NIL) {
            return (((Stella_Object)(edu.isi.stella.javalib.Native.funcall(code, null, new java.lang.Object [] {arg1, arg2}))));
          }
          { Stella_Object arg3 = arguments.value;

            arguments = arguments.rest;
            if (arguments == Stella.NIL) {
              return (((Stella_Object)(edu.isi.stella.javalib.Native.funcall(code, null, new java.lang.Object [] {arg1, arg2, arg3}))));
            }
            { Stella_Object arg4 = arguments.value;

              arguments = arguments.rest;
              if (arguments == Stella.NIL) {
                return (((Stella_Object)(edu.isi.stella.javalib.Native.funcall(code, null, new java.lang.Object [] {arg1, arg2, arg3, arg4}))));
              }
              { Stella_Object arg5 = arguments.value;

                arguments = arguments.rest;
                if (arguments == Stella.NIL) {
                  return (((Stella_Object)(edu.isi.stella.javalib.Native.funcall(code, null, new java.lang.Object [] {arg1, arg2, arg3, arg4, arg5}))));
                }
                { Stella_Object arg6 = arguments.value;

                  arguments = arguments.rest;
                  if (arguments == Stella.NIL) {
                    return (((Stella_Object)(edu.isi.stella.javalib.Native.funcall(code, null, new java.lang.Object [] {arg1, arg2, arg3, arg4, arg5, arg6}))));
                  }
                  { Stella_Object arg7 = arguments.value;

                    arguments = arguments.rest;
                    if (arguments == Stella.NIL) {
                      return (((Stella_Object)(edu.isi.stella.javalib.Native.funcall(code, null, new java.lang.Object [] {arg1, arg2, arg3, arg4, arg5, arg6, arg7}))));
                    }
                    { Stella_Object arg8 = arguments.value;

                      arguments = arguments.rest;
                      if (arguments == Stella.NIL) {
                        return (((Stella_Object)(edu.isi.stella.javalib.Native.funcall(code, null, new java.lang.Object [] {arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8}))));
                      }
                      { Stella_Object arg9 = arguments.value;

                        arguments = arguments.rest;
                        if (arguments == Stella.NIL) {
                          return (((Stella_Object)(edu.isi.stella.javalib.Native.funcall(code, null, new java.lang.Object [] {arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9}))));
                        }
                        { Stella_Object arg10 = arguments.value;

                          arguments = arguments.rest;
                          if (arguments == Stella.NIL) {
                            return (((Stella_Object)(edu.isi.stella.javalib.Native.funcall(code, null, new java.lang.Object [] {arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10}))));
                          }
                          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                            stream000.nativeStream.print("Too many function arguments in `apply'.Maximum is 10.");
                            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  /** Apply <code>code</code> to <code>arguments</code>, returning a value of type
   * OBJECT.
   * @param code
   * @param arguments
   * @return Stella_Object
   */
  public static Stella_Object applyMethod(java.lang.reflect.Method code, Cons arguments) {
    switch (arguments.length()) {
      case 0: 
        throw ((StellaException)(StellaException.newStellaException("Can't call method code on 0 arguments.").fillInStackTrace()));
      case 1: 
        return (((Stella_Object)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{}))));
      case 2: 
        return (((Stella_Object)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value}))));
      case 3: 
        return (((Stella_Object)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value, arguments.nth(2)}))));
      case 4: 
        return (((Stella_Object)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value, arguments.nth(2), arguments.nth(3)}))));
      case 5: 
        return (((Stella_Object)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value, arguments.nth(2), arguments.nth(3), arguments.nth(4)}))));
      default:
        throw ((StellaException)(StellaException.newStellaException("Too many function arguments in `apply'.  Max is 5.").fillInStackTrace()));
    }
  }

  /** Apply <code>code</code> to <code>arguments</code>, returning a value of type
   * INTEGER.
   * @param code
   * @param arguments
   * @return int
   */
  public static int applyIntegerMethod(java.lang.reflect.Method code, Cons arguments) {
    switch (arguments.length()) {
      case 0: 
        throw ((StellaException)(StellaException.newStellaException("Can't call method code on 0 arguments.").fillInStackTrace()));
      case 1: 
        return (((Integer)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{}))).intValue());
      case 2: 
        return (((Integer)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value}))).intValue());
      case 3: 
        return (((Integer)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value, arguments.nth(2)}))).intValue());
      case 4: 
        return (((Integer)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value, arguments.nth(2), arguments.nth(3)}))).intValue());
      case 5: 
        return (((Integer)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value, arguments.nth(2), arguments.nth(3), arguments.nth(4)}))).intValue());
      default:
        throw ((StellaException)(StellaException.newStellaException("Too many function arguments in `apply'.  Max is 5.").fillInStackTrace()));
    }
  }

  /** Apply <code>code</code> to <code>arguments</code>, returning a value of type
   * LONG-INTEGER.
   * @param code
   * @param arguments
   * @return long
   */
  public static long applyLongIntegerMethod(java.lang.reflect.Method code, Cons arguments) {
    switch (arguments.length()) {
      case 0: 
        throw ((StellaException)(StellaException.newStellaException("Can't call method code on 0 arguments.").fillInStackTrace()));
      case 1: 
        return (((Long)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{}))).longValue());
      case 2: 
        return (((Long)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value}))).longValue());
      case 3: 
        return (((Long)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value, arguments.nth(2)}))).longValue());
      case 4: 
        return (((Long)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value, arguments.nth(2), arguments.nth(3)}))).longValue());
      case 5: 
        return (((Long)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value, arguments.nth(2), arguments.nth(3), arguments.nth(4)}))).longValue());
      default:
        throw ((StellaException)(StellaException.newStellaException("Too many function arguments in `apply'.  Max is 5.").fillInStackTrace()));
    }
  }

  /** Apply <code>code</code> to <code>arguments</code>, returning a value of type
   * STRING.
   * @param code
   * @param arguments
   * @return String
   */
  public static String applyStringMethod(java.lang.reflect.Method code, Cons arguments) {
    switch (arguments.length()) {
      case 0: 
        throw ((StellaException)(StellaException.newStellaException("Can't call method code on 0 arguments.").fillInStackTrace()));
      case 1: 
        return (((String)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{}))));
      case 2: 
        return (((String)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value}))));
      case 3: 
        return (((String)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value, arguments.nth(2)}))));
      case 4: 
        return (((String)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value, arguments.nth(2), arguments.nth(3)}))));
      case 5: 
        return (((String)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value, arguments.nth(2), arguments.nth(3), arguments.nth(4)}))));
      default:
        throw ((StellaException)(StellaException.newStellaException("Too many function arguments in `apply'.  Max is 5.").fillInStackTrace()));
    }
  }

  /** Apply <code>code</code> to <code>arguments</code>, returning a value of type
   * BOOLEAN.
   * @param code
   * @param arguments
   * @return boolean
   */
  public static boolean applyBooleanMethod(java.lang.reflect.Method code, Cons arguments) {
    switch (arguments.length()) {
      case 0: 
        throw ((StellaException)(StellaException.newStellaException("Can't call method code on 0 arguments.").fillInStackTrace()));
      case 1: 
        return (((Boolean)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{}))).booleanValue());
      case 2: 
        return (((Boolean)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value}))).booleanValue());
      case 3: 
        return (((Boolean)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value, arguments.nth(2)}))).booleanValue());
      case 4: 
        return (((Boolean)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value, arguments.nth(2), arguments.nth(3)}))).booleanValue());
      case 5: 
        return (((Boolean)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value, arguments.nth(2), arguments.nth(3), arguments.nth(4)}))).booleanValue());
      default:
        throw ((StellaException)(StellaException.newStellaException("Too many function arguments in `apply'.  Max is 5.").fillInStackTrace()));
    }
  }

  /** Apply <code>code</code> to <code>arguments</code>, returning a value of type
   * FLOAT.
   * @param code
   * @param arguments
   * @return double
   */
  public static double applyFloatMethod(java.lang.reflect.Method code, Cons arguments) {
    switch (arguments.length()) {
      case 0: 
        throw ((StellaException)(StellaException.newStellaException("Can't call method code on 0 arguments.").fillInStackTrace()));
      case 1: 
        return (((Double)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{}))).doubleValue());
      case 2: 
        return (((Double)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value}))).doubleValue());
      case 3: 
        return (((Double)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value, arguments.nth(2)}))).doubleValue());
      case 4: 
        return (((Double)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value, arguments.nth(2), arguments.nth(3)}))).doubleValue());
      case 5: 
        return (((Double)(edu.isi.stella.javalib.Native.funcall(code, arguments.value, new java.lang.Object []{arguments.rest.value, arguments.nth(2), arguments.nth(3), arguments.nth(4)}))).doubleValue());
      default:
        throw ((StellaException)(StellaException.newStellaException("Too many function arguments in `apply'.  Max is 5.").fillInStackTrace()));
    }
  }

  public static Stella_Object yieldStringConstantTree(String string) {
    { int length = string.length();
      Cons chunks = Stella.NIL;
      int start = 0;
      Stella_Object stringtree = null;

      if (length <= Stella.$MAXIMUM_STRING_CONSTANT_SIZE$) {
        return (StringWrapper.wrapString(string));
      }
      while ((start + Stella.$MAXIMUM_STRING_CONSTANT_SIZE$) < length) {
        chunks = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(string, start, start + Stella.$MAXIMUM_STRING_CONSTANT_SIZE$)), chunks);
        start = start + Stella.$MAXIMUM_STRING_CONSTANT_SIZE$;
      }
      if (start < length) {
        chunks = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(string, start, length)), chunks);
      }
      stringtree = chunks.value;
      { Stella_Object chunk = null;
        Cons iter000 = chunks.rest;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          chunk = iter000.value;
          stringtree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CONCATENATE, Cons.cons(chunk, Cons.cons(Cons.cons(stringtree, Stella.NIL), Stella.NIL))));
        }
      }
      return (stringtree);
    }
  }

  /** Return a function with name 'name' visible from the current module.
   * Scan all visible symbols looking for one that has a function defined for it.
   * @param name
   * @return MethodSlot
   */
  public static MethodSlot lookupFunctionByName(String name) {
    { MethodSlot function = null;
      Symbol symbol = null;

      { Module module = null;
        Cons iter000 = Module.visibleModules(((Module)(Stella.$MODULE$.get())));

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          module = ((Module)(iter000.value));
          { boolean testValue000 = false;

            { 
              symbol = Symbol.lookupSymbolInModule(name, module, true);
              testValue000 = symbol != null;
            }
            if (testValue000) {
              { 
                function = Symbol.lookupFunction(symbol);
                testValue000 = function != null;
              }
            }
            if (testValue000) {
              return (function);
            }
          }
        }
      }
      return (null);
    }
  }

  public static void defineFunctionObject(String name, String definition, java.lang.reflect.Method code, java.lang.reflect.Method wrappercode) {
    if (name == null) {
      { MethodSlot function = Stella.defineMethodFromStringifiedSource(null, null, definition);

        if (function != null) {
          if (code != null) {
            function.functionCode = code;
          }
          if (wrappercode != null) {
            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_EVALUATOR_WRAPPER_CODE, FunctionCodeWrapper.wrapFunctionCode(wrappercode), Stella.NULL_FUNCTION_CODE_WRAPPER);
          }
          Stella.$FUNCTION_LOOKUP_TABLE$.insertAt(function.slotName, function);
        }
      }
    }
    else {
      { Stella_Object namesymbol = ((name.charAt(0) == ' ') ? Stella.readSExpressionFromString(name) : Symbol.internSymbolInModule(name, null, false));
        StandardObject oldfunction = ((StandardObject)(Stella.$FUNCTION_LOOKUP_TABLE$.lookup(((Symbol)(namesymbol)))));
        Vector record = Vector.newVector(((wrappercode != null) ? 5 : 4));

        if ((oldfunction != null) &&
            (oldfunction.primaryType() == Stella.SGT_STELLA_VECTOR)) {
          oldfunction = null;
        }
        (record.theArray)[0] = (StringWrapper.wrapString(definition));
        (record.theArray)[1] = oldfunction;
        (record.theArray)[2] = (StringWrapper.wrapString(((Module)(Stella.$MODULE$.get())).moduleFullName));
        if (code != null) {
          (record.theArray)[3] = (FunctionCodeWrapper.wrapFunctionCode(code));
        }
        if (wrappercode != null) {
          (record.theArray)[4] = (FunctionCodeWrapper.wrapFunctionCode(wrappercode));
        }
        Stella.$FUNCTION_LOOKUP_TABLE$.insertAt(((Symbol)(namesymbol)), record);
      }
    }
  }

  /** Return a global variable with name 'self'.
   * @param self
   * @return GlobalVariable
   */
  public static GlobalVariable string_lookupGlobalVariable(String self) {
    { Symbol symbol = Symbol.lookupSymbol(self);

      if (symbol != null) {
        return (symbol.lookupGlobalVariable());
      }
      else {
        return (null);
      }
    }
  }

  public static void defineStellaGlobalVariableFromStringifiedSource(String stringifiedsource) {
    Cons.defineStellaGlobalVariableFromParseTree(((Cons)(Stella.unstringifyStellaSource(stringifiedsource, null))), stringifiedsource, new Object[1]);
  }

  public static void defineStellaTypeFromStringifiedSource(String stringifiedsource) {
    Cons.defineStellaTypeFromParseTree(((Cons)(Stella.unstringifyStellaSource(stringifiedsource, null))));
  }

  /** Reset all currently active recycle lists to their empty state.
   */
  public static void clearRecycleLists() {
    Stella.$RECYCLE_LISTS_MAINTENANCE_TIMER$ = Stella.$RECYCLE_LISTS_MAINTENANCE_INTERVAL$;
    { RecycleList list = null;
      Cons iter000 = Stella.$ALL_RECYCLE_LISTS$.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        list = ((RecycleList)(iter000.value));
        RecycleList.clearRecycleList(list);
      }
    }
  }

  /** Print the current state of all recycle lists.
   */
  public static void printRecycleLists() {
    Stella.STANDARD_OUTPUT.nativeStream.println("Approximate space occupied by recycle lists: " + (Stella.totalRecycleListsSize() * 4) + " bytes");
    { RecycleList list = null;
      Cons iter000 = Stella.$ALL_RECYCLE_LISTS$.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        list = ((RecycleList)(iter000.value));
        Stella.STANDARD_OUTPUT.nativeStream.println(list.toString());
      }
    }
  }

  public static void maintainRecycleLists() {
    if (Stella.$CURRENTLY_RECYCLED_ITEMS$ != null) {
      return;
    }
    { int totalsize = Stella.totalRecycleListsSize();
      int maxsize = Native.floor(Stella.$MAX_RECYCLE_LIST_BYTES$ / 4.0);
      int listsize = Stella.NULL_INTEGER;
      boolean classredefinitionP = false;

      Stella.$RECYCLE_LISTS_MAINTENANCE_TIMER$ = Stella.$RECYCLE_LISTS_MAINTENANCE_INTERVAL$;
      { RecycleList list = null;
        Cons iter000 = Stella.$ALL_RECYCLE_LISTS$.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          list = ((RecycleList)(iter000.value));
          if ((((Stella_Class)(list.recycleListOf.surrogateValue)) != null) &&
              (!Stella_Class.decidedToRecycleP(((Stella_Class)(list.recycleListOf.surrogateValue))))) {
            classredefinitionP = true;
            RecycleList.clearRecycleList(list);
            list.deletedPSetter(true);
          }
        }
      }
      if (classredefinitionP) {
        Stella.$ALL_RECYCLE_LISTS$.removeDeletedMembers();
      }
      if (totalsize > maxsize) {
        Stella.$ALL_RECYCLE_LISTS$.sort(Native.find_java_method("edu.isi.stella.RecycleList", "recycleListSizeL", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.RecycleList"), Native.find_java_class("edu.isi.stella.RecycleList")}));
        Stella.$ALL_RECYCLE_LISTS$.reverse();
        while (totalsize > maxsize) {
          { RecycleList list = null;
            Cons iter001 = Stella.$ALL_RECYCLE_LISTS$.theConsList;

            loop002 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              list = ((RecycleList)(iter001.value));
              if (totalsize <= maxsize) {
                break loop002;
              }
              listsize = list.itemSize * list.currentLength;
              if (listsize > 0) {
                totalsize = totalsize - listsize;
              }
              else {
                continue loop002;
              }
              RecycleList.reduceRecycleListSize(list, 0.5);
              totalsize = totalsize + (list.itemSize * list.currentLength);
            }
          }
        }
      }
    }
  }

  public static int totalRecycleListsSize() {
    { int size = 0;

      { RecycleList list = null;
        Cons iter000 = Stella.$ALL_RECYCLE_LISTS$.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          list = ((RecycleList)(iter000.value));
          size = size + (list.itemSize * list.currentLength);
        }
      }
      return (size);
    }
  }

  public static void sweepTransients() {
    { RecycleList recyclelist = null;
      Cons iter000 = Stella.$ALL_RECYCLE_LISTS$.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        recyclelist = ((RecycleList)(iter000.value));
        if ((recyclelist.allItems != null) &&
            Stella_Object.isaP(recyclelist.allItems, Stella.SGT_STELLA_TRANSIENT_MIXIN)) {
          recyclelist.allItems.sweep();
        }
      }
    }
    Stella.freeTransientSymbols();
  }

  public static List makeNonRecycledList() {
    { List list = new List();

      list.theConsList = Stella.NIL;
      return (list);
    }
  }

  public static void startRecycleListDebugging() {
    Stella.$CURRENTLY_RECYCLED_ITEMS$ = null;
    Stella.clearRecycleLists();
    Stella.$CURRENTLY_RECYCLED_ITEMS$ = HashTable.newHashTable();
  }

  public static void stopRecycleListDebugging() {
    Stella.$CURRENTLY_RECYCLED_ITEMS$ = null;
  }

  public static boolean recycleListDebuggingEnabledP() {
    return (Stella.$CURRENTLY_RECYCLED_ITEMS$ != null);
  }

  public static boolean translateWithRecycleListDebuggingP() {
    return (Stella.$TRANSLATE_WITH_RECYCLE_LIST_DEBUGGINGp$);
  }

  public static Cons yieldRegisterRecycledItemTrees() {
    if (Stella.$TRANSLATE_WITH_RECYCLE_LIST_DEBUGGINGp$) {
      return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.cons(Stella.SYM_STELLA_RECYCLE_LIST_DEBUGGING_ENABLEDp, Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_REGISTER_RECYCLED_ITEM, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL));
    }
    else {
      return (Stella.NIL);
    }
  }

  public static Cons yieldUnregisterRecycledItemTrees() {
    if (Stella.$TRANSLATE_WITH_RECYCLE_LIST_DEBUGGINGp$) {
      return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.cons(Stella.SYM_STELLA_RECYCLE_LIST_DEBUGGING_ENABLEDp, Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNREGISTER_RECYCLED_ITEM, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL));
    }
    else {
      return (Stella.NIL);
    }
  }

  /** Returns the Julian day that starts at noon on yyyy-mm-dd.
   * <code>yyyy</code> is the year.  <code>mm</code> is the month.  <code>dd</code> is the day of month.
   * Negative years are B.C.  Remember there is no year zero.
   * @param yyyy
   * @param mm
   * @param dd
   * @return int
   */
  public static int computeJulianDay(int yyyy, int mm, int dd) {
    { int jul = 0;
      int ja = 0;
      int jy = 0;
      int jm = 0;

      if (yyyy == 0) {
        throw ((StellaException)(StellaException.newStellaException("There is no year zero.").fillInStackTrace()));
      }
      if (mm > 12) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Month `" + mm + "' must be <= 12");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      if (mm < 0) {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("Month `" + mm + "' must be > zero.");
          throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
      if (dd > 31) {
        { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

          stream002.nativeStream.print("Day `" + dd + "' must be <= 31");
          throw ((StellaException)(StellaException.newStellaException(stream002.theStringReader()).fillInStackTrace()));
        }
      }
      if (dd < 0) {
        { OutputStringStream stream003 = OutputStringStream.newOutputStringStream();

          stream003.nativeStream.print("Day `" + dd + "' must be > zero.");
          throw ((StellaException)(StellaException.newStellaException(stream003.theStringReader()).fillInStackTrace()));
        }
      }
      if (yyyy < 0) {
        yyyy = yyyy + 1;
      }
      if (mm > 2) {
        {
          jy = yyyy;
          jm = mm + 1;
        }
      }
      else {
        {
          jy = yyyy - 1;
          jm = mm + 13;
        }
      }
      jul = Native.floor(365.25 * jy) + Native.floor(30.6001 * jm) + dd + 1720995;
      if ((dd + (31 * (mm + (12 * yyyy)))) >= (15 + (31 * (10 + (12 * 1582))))) {
        ja = ((int)(0.01 * jy));
        jul = jul + (2 - ja) + ((int)(0.25 * ja));
      }
      return (jul);
    }
  }

  /** Returns the modified Julian day during which <code>julianDay</code>starts at noon.
   * @param julianDay
   * @return int
   */
  public static int julianDayToModifiedJulianDay(int julianDay) {
    return (julianDay - 2400000);
  }

  /** Returns the modified Julian day during which <code>julianDay</code>starts at noon.
   * @param modifiedJulianDay
   * @return int
   */
  public static int modifiedJulianDayToJulianDay(int modifiedJulianDay) {
    return (modifiedJulianDay + 2400000);
  }

  /** Returns the day of the week for julian-day
   * @param julianDay
   * @return Keyword
   */
  public static Keyword computeDayOfWeekJulian(int julianDay) {
    switch ((julianDay % 7)) {
      case 0: 
        return (Stella.KWD_MONDAY);
      case 1: 
        return (Stella.KWD_TUESDAY);
      case 2: 
        return (Stella.KWD_WEDNESDAY);
      case 3: 
        return (Stella.KWD_THURSDAY);
      case 4: 
        return (Stella.KWD_FRIDAY);
      case 5: 
        return (Stella.KWD_SATURDAY);
      case 6: 
        return (Stella.KWD_SUNDAY);
      default:
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + (julianDay % 7) + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
    }
  }

  /** Returns the day of the week for yyyy-mm-dd.
   * @param yyyy
   * @param mm
   * @param dd
   * @return Keyword
   */
  public static Keyword computeDayOfWeek(int yyyy, int mm, int dd) {
    return (Stella.computeDayOfWeekJulian(Stella.computeJulianDay(yyyy, mm, dd)));
  }

  /** Returns the Julian Day and fraction of day of the Nth occurence
   * since January 1, 1900 of moon PHASE.  PHASE is one of :NEW-MOON, :FIRST-QUARTER,
   * :FULL-MOON, :LAST-QUARTER
   * @param n
   * @param phase
   * @param MV_returnarray
   * @return int
   */
  public static int computeNextMoonPhase(int n, Keyword phase, Object [] MV_returnarray) {
    { int i = 0;
      double am = 0.0;
      double as = 0.0;
      double c = 0.0;
      double x = 0.0;
      double x2 = 0.0;
      double extra = 0.0;
      double rad = Stella.PI / 180.0;
      int julianDay = 0;

      if (phase == Stella.KWD_NEW_MOON) {
        c = ((double)(n));
        julianDay = 0;
      }
      else if (phase == Stella.KWD_FIRST_QUARTER) {
        c = n + 0.25;
        julianDay = 7;
      }
      else if (phase == Stella.KWD_FULL_MOON) {
        c = n + 0.5;
        julianDay = 14;
      }
      else if (phase == Stella.KWD_LAST_QUARTER) {
        c = n + 0.75;
        julianDay = 21;
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + phase + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      x = c / 1236.85;
      x2 = x * x;
      as = 359.2242 + (29.105356 * c);
      am = 306.0253 + (385.816918 * c) + (0.01073 * x2);
      julianDay = 2415020 + (28 * n) + julianDay;
      extra = 0.75933 + (1.53058868 * c) + ((1.178e-4 - (1.55e-7 * x)) * x2);
      if ((phase == Stella.KWD_NEW_MOON) ||
          (phase == Stella.KWD_FULL_MOON)) {
        extra = extra + (((0.1734 - (3.93e-4 * x)) * Math.sin((as * rad))) - (0.4068 * Math.sin((am * rad))));
      }
      else if ((phase == Stella.KWD_FIRST_QUARTER) ||
          (phase == Stella.KWD_LAST_QUARTER)) {
        extra = extra + (((0.1721 - (4.0e-4 * x)) * Math.sin((as * rad))) - (0.628 * Math.sin((am * rad))));
      }
      else {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("`" + phase + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
      i = ((extra >= 0.0) ? Native.floor(extra) : Native.ceiling(extra - 1.0));
      { int _return_temp = julianDay + i;

        MV_returnarray[0] = FloatWrapper.wrapFloat(extra - i);
        return (_return_temp);
      }
    }
  }

  /** Returns the YEAR, MONTH, DAY, DAY-OF-WEEK on which the given
   * <code>julianDay</code> begins at noon.
   * @param julianDay
   * @param MV_returnarray
   * @return int
   */
  public static int computeCalendarDate(int julianDay, Object [] MV_returnarray) {
    { int ja = julianDay;
      int jalpha = 0;
      int jb = 0;
      int jc = 0;
      int jd = 0;
      int je = 0;
      int igreg = 2299161;
      int yyyy = 0;
      int mm = 0;
      int dd = 0;

      if (julianDay >= igreg) {
        jalpha = ((int)(((julianDay - 1867216) - 0.25) / 36524.25));
        ja = julianDay + 1 + jalpha + ((int)(-0.25 * jalpha));
      }
      jb = ja + 1524;
      jc = ((int)(6680.0 + (((jb - 2439870) - 122.1) / 365.25)));
      jd = ((int)((365 * jc) + (0.25 * jc)));
      je = ((int)((jb - jd) / 30.6001));
      dd = (jb - jd) - ((int)(30.6001 * je));
      mm = je - 1;
      if (mm > 12) {
        mm = mm - 12;
      }
      yyyy = jc - 4715;
      if (mm > 2) {
        yyyy = yyyy - 1;
      }
      if (yyyy <= 0) {
        yyyy = yyyy - 1;
      }
      { int _return_temp = yyyy;

        MV_returnarray[0] = IntegerWrapper.wrapInteger(mm);
        MV_returnarray[1] = IntegerWrapper.wrapInteger(dd);
        MV_returnarray[2] = Stella.computeDayOfWeekJulian(julianDay);
        return (_return_temp);
      }
    }
  }

  /** Returns the current time in UTC as multiple values of
   * year month day day-of-week hour minute second millisecond.  Currently
   * millisecond will always be zero (even in Java where it is technically available).
   * @param MV_returnarray
   * @return int
   */
  public static int getCurrentDateTime(Object [] MV_returnarray) {
    { int year = 0;
      int month = 0;
      int day = 0;
      int hour = 0;
      int minute = 0;
      int second = 0;
      int millisecond = 0;

      java.util.Calendar gc = new java.util.GregorianCalendar(java.util.TimeZone.getTimeZone("UTC"));
      year = gc.get(java.util.Calendar.YEAR);
      month = gc.get(java.util.Calendar.MONTH) + 1 - java.util.Calendar.JANUARY;
      day = gc.get(java.util.Calendar.DAY_OF_MONTH);
      hour = gc.get(java.util.Calendar.HOUR_OF_DAY);
      minute = gc.get(java.util.Calendar.MINUTE);
      second = gc.get(java.util.Calendar.SECOND);
;
      { int _return_temp = year;

        MV_returnarray[0] = IntegerWrapper.wrapInteger(month);
        MV_returnarray[1] = IntegerWrapper.wrapInteger(day);
        MV_returnarray[2] = Stella.computeDayOfWeek(year, month, day);
        MV_returnarray[3] = IntegerWrapper.wrapInteger(hour);
        MV_returnarray[4] = IntegerWrapper.wrapInteger(minute);
        MV_returnarray[5] = IntegerWrapper.wrapInteger(second);
        MV_returnarray[6] = IntegerWrapper.wrapInteger(millisecond);
        return (_return_temp);
      }
    }
  }

  /** Returns the current time zone offset from UTC as a float,
   * considering the effects of daylight savings time.
   * @return double
   */
  public static double getLocalTimeZone() {
    { double offset = 0.0;

      java.util.Calendar gc = java.util.Calendar.getInstance();
    offset = (gc.get(java.util.Calendar.ZONE_OFFSET) + 
              gc.get(java.util.Calendar.DST_OFFSET)) / (1000.0 * 60.0 * 60.0);
;
      return (offset);
    }
  }

  /** Returns the standard time zone offset from UTC as a float,
   * without considering the effects of daylight savings time.
   * @return double
   */
  public static double getLocalStandardTimeZone() {
    { double offset = 0.0;

      java.util.Calendar gc = java.util.Calendar.getInstance();
    offset = gc.get(java.util.Calendar.ZONE_OFFSET) / (1000.0 * 60.0 * 60.0);
;
      return (offset);
    }
  }

  /** Returns the time zone offset from UTC (as a float)
   * that is applicable to the given date.  Assumes that the date is one
   * that is valid for the underlying programming language.  If not, then
   * returns 0.0
   * @param year
   * @param month
   * @param day
   * @param hour
   * @param minute
   * @param second
   * @return double
   */
  public static double getLocalTimeZoneForDate(int year, int month, int day, int hour, int minute, int second) {
    { double offset = 0.0;

      java.util.Calendar gc;
    if (year > 0) {
      gc = new java.util.GregorianCalendar (year,month-1,day,hour,minute,second);
    } else {
      gc = new java.util.GregorianCalendar (-year,month-1,day,hour,minute,second);
      gc.set(java.util.Calendar.ERA, java.util.GregorianCalendar.BC);
    }
    offset = (gc.get(java.util.Calendar.ZONE_OFFSET) + 
              gc.get(java.util.Calendar.DST_OFFSET)) / (1000.0 * 60.0 * 60.0);
;
      return (offset);
    }
  }

  /** Format <code>zone</code> as an hh:mm or hhmm string depending on <code>includeColonP</code>
   * @param timezone
   * @param includeColonP
   * @return String
   */
  static String timeZoneFormat60(double timezone, boolean includeColonP) {
    { String sign = "+";
      int hours = 0;

      if (timezone < 0) {
        sign = "-";
        timezone = 0 - timezone;
      }
      hours = Native.round(timezone);
      return (sign + Stella.formatWithPadding(Native.integerToString(((long)(hours))), 2, '0', Stella.KWD_RIGHT, false) + ((includeColonP ? ":" : "")) + Stella.formatWithPadding(Native.integerToString(((long)(Native.round((timezone - hours) * 60.0)))), 2, '0', Stella.KWD_RIGHT, false));
    }
  }

  /** Returns multiple values of hours, minutes, seconds, milliseconds for
   * <code>time</code> specified in milliseconds.
   * @param time
   * @param MV_returnarray
   * @return int
   */
  public static int decodeTimeInMillis(int time, Object [] MV_returnarray) {
    { int millis = (time % 1000);
      int secs = (((time / 1000)) % 60);
      int mins = (((time / 60000)) % 60);
      int hours = (time / Stella.MILLIS_PER_HOUR);

      { int _return_temp = hours;

        MV_returnarray[0] = IntegerWrapper.wrapInteger(mins);
        MV_returnarray[1] = IntegerWrapper.wrapInteger(secs);
        MV_returnarray[2] = IntegerWrapper.wrapInteger(millis);
        return (_return_temp);
      }
    }
  }

  public static void formatDatePrintString(String string, char flag, int start, int end, OutputStream stream) {
    if (end < 0) {
      end = string.length();
    }
    end = end - 1;
    switch (flag) {
      case '^': 
        { int i = Stella.NULL_INTEGER;
          int iter000 = start;
          int upperBound000 = end;
          boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

          for (;unboundedP000 ||
                    (iter000 <= upperBound000); iter000 = iter000 + 1) {
            i = iter000;
            stream.nativeStream.print(Stella.$CHARACTER_UPCASE_TABLE$.charAt(((int) (string.charAt(i)))));
          }
        }
      break;
      case ',': 
        { int i = Stella.NULL_INTEGER;
          int iter001 = start;
          int upperBound001 = end;
          boolean unboundedP001 = upperBound001 == Stella.NULL_INTEGER;

          for (;unboundedP001 ||
                    (iter001 <= upperBound001); iter001 = iter001 + 1) {
            i = iter001;
            stream.nativeStream.print(Stella.$CHARACTER_DOWNCASE_TABLE$.charAt(((int) (string.charAt(i)))));
          }
        }
      break;
      default:
        stream.nativeStream.print(Stella.$CHARACTER_UPCASE_TABLE$.charAt(((int) (string.charAt(start)))));
        { int i = Stella.NULL_INTEGER;
          int iter002 = start + 1;
          int upperBound002 = end;
          boolean unboundedP002 = upperBound002 == Stella.NULL_INTEGER;

          for (;unboundedP002 ||
                    (iter002 <= upperBound002); iter002 = iter002 + 1) {
            i = iter002;
            stream.nativeStream.print(Stella.$CHARACTER_DOWNCASE_TABLE$.charAt(((int) (string.charAt(i)))));
          }
        }
      break;
    }
  }

  public static void formatDatePrintTwoDigitNumber(int number, char flag, OutputStream stream) {
    if (number <= 9) {
      switch (flag) {
        case '_': 
          stream.nativeStream.print(" ");
        break;
        case '0': 
        case ' ': 
          stream.nativeStream.print("0");
        break;
        default:
        break;
      }
    }
    stream.nativeStream.print(number);
  }

  public static Cons matchSubstring(String substring, boolean parsingTimeP) {
    { String teststring = Native.stringDowncase(substring);
      Stella_Object testValue = null;

      if ((!parsingTimeP) &&
          ((substring.length() == 1) &&
           BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(testValue = Stella_Object.dateTimeDivider(CharacterWrapper.wrapCharacter(substring.charAt(0)))))))) {
        return (Cons.consList(Cons.cons(Stella.SYM_STELLA_DATE_TIME_DIVIDER, Cons.cons(testValue, Stella.NIL))));
      }
      if (((IntegerWrapper)(testValue = Stella_Object.month(StringWrapper.wrapString(teststring)))) != null) {
        return (Cons.consList(Cons.cons(Stella.SYM_STELLA_MONTH, Cons.cons(testValue, Stella.NIL))));
      }
      if (((Keyword)(testValue = Stella_Object.weekday(StringWrapper.wrapString(teststring)))) != null) {
        return (Cons.consList(Cons.cons(Stella.SYM_STELLA_WEEKDAY, Cons.cons(testValue, Stella.NIL))));
      }
      if (((Symbol)(testValue = Stella_Object.amPm(StringWrapper.wrapString(teststring)))) != null) {
        return (Cons.consList(Cons.cons(Stella.SYM_STELLA_AM_PM, Cons.cons(testValue, Stella.NIL))));
      }
      if (((Symbol)(testValue = Stella_Object.noonMidn(StringWrapper.wrapString(teststring)))) != null) {
        return (Cons.consList(Cons.cons(Stella.SYM_STELLA_NOON_MIDN, Cons.cons(testValue, Stella.NIL))));
      }
      if (((FloatWrapper)(testValue = Stella_Object.zone(StringWrapper.wrapString(teststring)))) != null) {
        return (Cons.consList(Cons.cons(Stella.SYM_STELLA_ZONE, Cons.cons(testValue, Stella.NIL))));
      }
      if (((Symbol)(testValue = Stella_Object.specialp(StringWrapper.wrapString(teststring)))) != null) {
        return (Cons.consList(Cons.cons(Stella.SYM_STELLA_SPECIAL, Cons.cons(testValue, Stella.NIL))));
      }
      if (((Boolean)(Stella.$ERROR_ON_MISMATCH$.get())).booleanValue()) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("\"~A\" is not a recognized word or abbreviation.`" + substring + "'");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      else {
        return (Stella.NIL);
      }
    }
  }

  public static int digitValue(char renamed_Char) {
    return ((int) renamed_Char - (int) '0');
  }

  public static Cons decomposeDateTimeString(String string, int start, int end) {
    { int stringIndex = start;
      boolean nextNegativeP = false;
      boolean parsingTimeP = false;
      Cons partsList = Stella.NIL;
      char nextChar = Stella.NULL_CHARACTER;
      char prevChar = Stella.NULL_CHARACTER;

      if (end == Stella.NULL_INTEGER) {
        end = string.length();
      }
      while (stringIndex < end) {
        nextChar = string.charAt(stringIndex);
        prevChar = ((stringIndex == start) ? Stella.NULL_CHARACTER : string.charAt((stringIndex - 1)));
        if (Stella.$CHARACTER_TYPE_TABLE$[(int) nextChar] == Stella.KWD_LETTER) {
          parsingTimeP = false;
          { int scanIndex = Stella.NULL_INTEGER;
            int iter000 = stringIndex + 1;

            loop001 : for (;true; iter000 = iter000 + 1) {
              scanIndex = iter000;
              if ((scanIndex == end) ||
                  (!(Stella.$CHARACTER_TYPE_TABLE$[(int) (string.charAt(scanIndex))] == Stella.KWD_LETTER))) {
                { Cons matchSymbol = Stella.matchSubstring(Native.string_subsequence(string, stringIndex, scanIndex), parsingTimeP);

                  if (matchSymbol == Stella.NIL) {
                    return (Stella.NIL);
                  }
                  else {
                    partsList = Cons.cons(matchSymbol, partsList);
                  }
                }
                stringIndex = scanIndex;
                break loop001;
              }
            }
          }
        }
        else if (Stella.$CHARACTER_TYPE_TABLE$[(int) nextChar] == Stella.KWD_DIGIT) {
          { int numericValue = Stella.digitValue(nextChar);
            int fractionalValue = 0;
            double fractionalDivisor = 1.0;
            boolean inFractionP = false;

            { int scanIndex = Stella.NULL_INTEGER;
              int iter001 = stringIndex + 1;

              loop002 : for (;true; iter001 = iter001 + 1) {
                scanIndex = iter001;
                if ((scanIndex == end) ||
                    (!((Stella.$CHARACTER_TYPE_TABLE$[(int) (string.charAt(scanIndex))] == Stella.KWD_DIGIT) ||
                    ((!inFractionP) &&
                     (string.charAt(scanIndex) == '.'))))) {
                  if (nextNegativeP) {
                    nextNegativeP = false;
                    numericValue = 0 - numericValue;
                    fractionalValue = 0 - fractionalValue;
                  }
                  if (inFractionP) {
                    partsList = Cons.cons(FloatWrapper.wrapFloat(numericValue + (fractionalValue / fractionalDivisor)), partsList);
                  }
                  else {
                    partsList = Cons.cons(IntegerWrapper.wrapInteger(numericValue), partsList);
                  }
                  stringIndex = scanIndex;
                  break loop002;
                }
                if (inFractionP) {
                  fractionalValue = (fractionalValue * 10) + Stella.digitValue(string.charAt(scanIndex));
                  fractionalDivisor = fractionalDivisor * 10.0;
                }
                else if (string.charAt(scanIndex) == '.') {
                  inFractionP = true;
                }
                else {
                  numericValue = (numericValue * 10) + Stella.digitValue(string.charAt(scanIndex));
                }
              }
            }
          }
        }
        else if ((nextChar == '-') &&
            ((prevChar == Stella.NULL_CHARACTER) ||
             (Stella.WHITESPACE_CHARS.memberP(CharacterWrapper.wrapCharacter(prevChar)) ||
              (Stella.DATE_DIVIDERS.memberP(CharacterWrapper.wrapCharacter(prevChar)) ||
               (parsingTimeP &&
                (Stella.$CHARACTER_TYPE_TABLE$[(int) prevChar] == Stella.KWD_DIGIT)))))) {
          nextNegativeP = true;
          stringIndex = stringIndex + 1;
        }
        else if (Stella.TIME_DIVIDERS.memberP(CharacterWrapper.wrapCharacter(nextChar))) {
          partsList = Cons.cons(Cons.consList(Cons.cons(Stella.SYM_STELLA_TIME_DIVIDER, Cons.cons(CharacterWrapper.wrapCharacter(nextChar), Stella.NIL))), partsList);
          parsingTimeP = true;
          stringIndex = stringIndex + 1;
        }
        else if (Stella.DATE_DIVIDERS.memberP(CharacterWrapper.wrapCharacter(nextChar))) {
          partsList = Cons.cons(Cons.consList(Cons.cons(Stella.SYM_STELLA_DATE_DIVIDER, Cons.cons(CharacterWrapper.wrapCharacter(nextChar), Stella.NIL))), partsList);
          parsingTimeP = false;
          stringIndex = stringIndex + 1;
        }
        else if (Stella.DATE_TIME_DIVIDERS.memberP(CharacterWrapper.wrapCharacter(nextChar))) {
          partsList = Cons.cons(Cons.consList(Cons.cons(Stella.SYM_STELLA_DATE_TIME_DIVIDER, Cons.cons(CharacterWrapper.wrapCharacter(nextChar), Stella.NIL))), partsList);
          parsingTimeP = true;
          stringIndex = stringIndex + 1;
        }
        else if (Stella.WHITESPACE_CHARS.memberP(CharacterWrapper.wrapCharacter(nextChar))) {
          parsingTimeP = false;
          stringIndex = stringIndex + 1;
        }
        else if (nextChar == '+') {
          partsList = Cons.cons(Cons.consList(Cons.cons(Stella.SYM_STELLA_DATE_DIVIDER, Cons.cons(CharacterWrapper.wrapCharacter(nextChar), Stella.NIL))), partsList);
          stringIndex = stringIndex + 1;
        }
        else if (nextChar == '(') {
          while ((!(stringIndex == end)) &&
              (!(string.charAt(stringIndex) == ')'))) {
            parsingTimeP = false;
            stringIndex = stringIndex + 1;
          }
        }
        else {
          if (((Boolean)(Stella.$ERROR_ON_MISMATCH$.get())).booleanValue()) {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print(">>> Bogus character at position `" + stringIndex + "' in \"`" + string + "'\"");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
          else {
            return (Stella.NIL);
          }
        }
      }
      return (partsList.reverse());
    }
  }

  public static Cons matchDateTimePatterns(String dateTimeString, int start, int end, boolean errorOnMismatchP) {
    { Object old$ErrorOnMismatch$000 = Stella.$ERROR_ON_MISMATCH$.get();

      try {
        Native.setBooleanSpecial(Stella.$ERROR_ON_MISMATCH$, errorOnMismatchP);
        { Cons stringParts = Stella.decomposeDateTimeString(dateTimeString, start, end);
          int partsLength = stringParts.length();
          Cons stringForm = Stella.NIL;

          { Stella_Object pattern = null;
            Cons iter000 = ((Cons)(Stella.$DATE_TIME_PATTERNS$.get()));

            loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              pattern = iter000.value;
              stringForm = Cons.matchPattern(((Cons)(pattern)), stringParts, partsLength);
              if (!(stringForm == Stella.NIL)) {
                break loop000;
              }
            }
          }
          if (stringForm == Stella.NIL) {
            if (errorOnMismatchP) {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("\"`" + dateTimeString + "'\" is not a recognized time/date format.");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
            else {
              return (null);
            }
          }
          else {
            return (stringForm);
          }
        }

      } finally {
        Stella.$ERROR_ON_MISMATCH$.set(old$ErrorOnMismatch$000);
      }
    }
  }

  /** Unstringify relative to <code>module</code>, or <code>$MODULE$</code> if no
   * module is specified.
   * @param string
   * @param module
   * @return Stella_Object
   */
  public static Stella_Object unstringifyInModule(String string, Module module) {
    if (module == null) {
      module = ((Module)(Stella.$MODULE$.get()));
    }
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, module);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        return (Stella.readSExpressionFromString(string));

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

  /** Unstringify a STELLA <code>source</code> string relative to <code>module</code>,
   * or <code>$MODULE$</code> if no module is specified.  This function allocates transient
   * objects as opposed to <code>unstringifyInModule</code> or the regular <code>unstringify</code>.
   * @param source
   * @param module
   * @return Stella_Object
   */
  public static Stella_Object unstringifyStellaSource(String source, Module module) {
    { Stella_Object result = null;

      { Object old$TransientobjectsP$000 = Stella.$TRANSIENTOBJECTSp$.get();

        try {
          Native.setBooleanSpecial(Stella.$TRANSIENTOBJECTSp$, true);
          result = Stella.unstringifyInModule(source, module);

        } finally {
          Stella.$TRANSIENTOBJECTSp$.set(old$TransientobjectsP$000);
        }
      }
      return (result);
    }
  }

  public static Stella_Class getIdenticalClass(String classname, String stringifiedsource) {
    { Surrogate surrogate = Surrogate.lookupSurrogate(classname);
      Stella_Object oldvalue = ((surrogate != null) ? surrogate.surrogateValue : ((Stella_Object)(null)));

      if (oldvalue != null) {
        if (Surrogate.subtypeOfClassP(Stella_Object.safePrimaryType(oldvalue))) {
          { Stella_Class oldvalue000 = ((Stella_Class)(oldvalue));

            if ((oldvalue000.classStringifiedSource != null) &&
                (Stella.stringEqlP(oldvalue000.classStringifiedSource, stringifiedsource) &&
                 (((Module)(surrogate.homeContext)) == ((Module)(Stella.$MODULE$.get()))))) {
              return (oldvalue000);
            }
          }
        }
        else {
        }
      }
      return (null);
    }
  }

  public static Stella_Class defineClassFromStringifiedSource(String classname, String stringifiedsource) {
    { Stella_Class oldclass = Stella.getIdenticalClass(classname, stringifiedsource);
      Stella_Class newclass = null;

      if ((oldclass != null) &&
          (!Stella.$REDEFINE_IDENTICAL_CLASSESp$)) {
        return (oldclass);
      }
      newclass = Cons.helpDefineClassFromParseTree(((Cons)(Stella.unstringifyStellaSource(stringifiedsource, null))), stringifiedsource);
      return (newclass);
    }
  }

  public static MethodSlot defineMethodFromStringifiedSource(String methodname, String classname, String stringifiedsource) {
    {
      methodname = methodname;
      classname = classname;
    }
    { MethodSlot method = null;
      boolean identicalmethodP = false;

      { Object [] caller_MV_returnarray = new Object[1];

        method = Cons.helpDefineMethodFromParseTree(((Cons)(Stella.unstringifyStellaSource(stringifiedsource, null))), stringifiedsource, caller_MV_returnarray);
        identicalmethodP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[0])).wrapperValue));
      }
      if (!(identicalmethodP ||
          ((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_SLOT_AUXILIARYp, Stella.FALSE_WRAPPER))).wrapperValue)) {
        MethodSlot.attachMethodSlotToOwner(method);
      }
      return (method);
    }
  }

  public static void defineMethodObject(String definition, java.lang.reflect.Method code, java.lang.reflect.Method wrappercode) {
    wrappercode = wrappercode;
    { MethodSlot method = Stella.defineMethodFromStringifiedSource(null, null, definition);

      if (method != null) {
        if (code != null) {
          method.methodCode = code;
        }
      }
    }
  }

  public static StorageSlot defineExternalSlotFromStringifiedSource(String stringifiedsource) {
    return (Cons.defineExternalSlotFromParseTree(((Cons)(Stella.readSExpressionFromString(stringifiedsource)))));
  }

  /** Print the list of enabled and disabled STELLA features.
   */
  public static void printStellaFeatures() {
    Stella.STANDARD_OUTPUT.nativeStream.println("Enabled STELLA features:");
    { Keyword feature = null;
      Cons iter000 = ((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        feature = ((Keyword)(iter000.value));
        Stella.STANDARD_OUTPUT.nativeStream.println("  :" + Native.stringDowncase(feature.symbolName));
      }
    }
    {
      Stella.STANDARD_OUTPUT.nativeStream.println();
      Stella.STANDARD_OUTPUT.nativeStream.println("Disabled STELLA features:");
    }
;
    { Keyword feature = null;
      Cons iter001 = Stella.$AVAILABLE_STELLA_FEATURES$.theConsList;

      for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
        feature = ((Keyword)(iter001.value));
        if (!((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).memberP(feature)) {
          Stella.STANDARD_OUTPUT.nativeStream.println("  :" + Native.stringDowncase(feature.symbolName));
        }
      }
    }
  }

  /** Enable all listed STELLA <code>features</code>.
   * @param features
   */
  public static void setStellaFeature(Cons features) {
    { Keyword f = null;
      Cons iter000 = features;

      loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        f = ((Keyword)(iter000.value));
        if (f == Stella.KWD_WARN_ABOUT_UNDEFINED_METHODS) {
        }
        else if (f == Stella.KWD_WARN_ABOUT_MISSING_METHODS) {
        }
        else if (f == Stella.KWD_SUPPRESS_WARNINGS) {
        }
        else if (f == Stella.KWD_USE_HARDCODED_SYMBOLS) {
        }
        else if (f == Stella.KWD_USE_COMMON_LISP_STRUCTS) {
          ((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).remove(Stella.KWD_USE_COMMON_LISP_VECTOR_STRUCTS);
        }
        else if (f == Stella.KWD_USE_COMMON_LISP_CONSES) {
        }
        else if (f == Stella.KWD_USE_CPP_GARBAGE_COLLECTOR) {
        }
        else if (f == Stella.KWD_MINIMIZE_JAVA_PREFIXES) {
        }
        else if (f == Stella.KWD_TRANSLATE_WITH_COPYRIGHT_HEADER) {
        }
        else if (f == Stella.KWD_SUPPORT_UNEXEC) {
        }
        else {
          if (Stella.$AVAILABLE_STELLA_FEATURES$.memberP(f)) {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("STELLA feature `" + f + "' is valid but not yet implemented");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
          else {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Invalid STELLA feature: `" + f + "'");
          }
          continue loop000;
        }
        ((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).insertNew(f);
      }
    }
  }

  /** Disable all listed STELLA <code>features</code>.
   * @param features
   */
  public static void unsetStellaFeature(Cons features) {
    { Keyword f = null;
      Cons iter000 = features;

      loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        f = ((Keyword)(iter000.value));
        if (f == Stella.KWD_WARN_ABOUT_UNDEFINED_METHODS) {
        }
        else if (f == Stella.KWD_WARN_ABOUT_MISSING_METHODS) {
        }
        else if (f == Stella.KWD_SUPPRESS_WARNINGS) {
        }
        else if (f == Stella.KWD_USE_HARDCODED_SYMBOLS) {
        }
        else if (f == Stella.KWD_USE_COMMON_LISP_STRUCTS) {
        }
        else if (f == Stella.KWD_USE_COMMON_LISP_CONSES) {
        }
        else if (f == Stella.KWD_USE_CPP_GARBAGE_COLLECTOR) {
        }
        else if (f == Stella.KWD_MINIMIZE_JAVA_PREFIXES) {
        }
        else if (f == Stella.KWD_TRANSLATE_WITH_COPYRIGHT_HEADER) {
        }
        else if (f == Stella.KWD_SUPPORT_UNEXEC) {
        }
        else {
          if (Stella.$AVAILABLE_STELLA_FEATURES$.memberP(f)) {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("STELLA feature `" + f + "' is valid but not yet implemented");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
          else {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Invalid STELLA feature: `" + f + "'");
          }
          continue loop000;
        }
        ((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).remove(f);
      }
    }
  }

  /** Reset STELLA features to their default settings.
   */
  public static void resetStellaFeatures() {
    { Keyword f = null;
      Cons iter000 = ((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        f = ((Keyword)(iter000.value));
        if (!Stella.$DEFAULT_STELLA_FEATURES$.memberP(f)) {
          Stella.unsetStellaFeature(Cons.cons(f, Stella.NIL));
        }
      }
    }
    { Keyword f = null;
      Cons iter001 = Stella.$DEFAULT_STELLA_FEATURES$.theConsList;

      for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
        f = ((Keyword)(iter001.value));
        if (!((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).memberP(f)) {
          Stella.setStellaFeature(Cons.cons(f, Stella.NIL));
        }
      }
    }
  }

  /** Enable trace messages identified by any of the listed <code>keywords</code>.  After
   * calling (<code>addTrace</code> &lt;keyword&gt;) code guarded by (<code>traceIf</code> &lt;keyword&gt; ...)
   * will be executed when it is encountered.
   * @param keywords
   * @return List
   */
  public static List addTrace(Cons keywords) {
    if (Stella.$TRACED_KEYWORDS$ == null) {
      Stella.$TRACED_KEYWORDS$ = List.list(Stella.NIL);
    }
    { GeneralizedSymbol k = null;
      Cons iter000 = keywords;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        k = ((GeneralizedSymbol)(iter000.value));
        Stella.$TRACED_KEYWORDS$.insertNew(Stella.string_keywordify(k.symbolName));
      }
    }
    return (Stella.$TRACED_KEYWORDS$);
  }

  /** Disable trace messages identified by any of the listed <code>keywords</code>.  After
   * calling (<code>dropTrace</code> &lt;keyword&gt;) code guarded by (<code>traceIf</code> &lt;keyword&gt; ...)
   * will not be executed when it is encountered.
   * @param keywords
   * @return List
   */
  public static List dropTrace(Cons keywords) {
    if (Stella.$TRACED_KEYWORDS$ != null) {
      { GeneralizedSymbol k = null;
        Cons iter000 = keywords;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          k = ((GeneralizedSymbol)(iter000.value));
          Stella.$TRACED_KEYWORDS$.remove(Stella.string_keywordify(k.symbolName));
        }
      }
      if (Stella.$TRACED_KEYWORDS$.emptyP()) {
        Stella.$TRACED_KEYWORDS$ = null;
      }
    }
    return (Stella.$TRACED_KEYWORDS$);
  }

  /** Disable all tracing previously enabled with <code>addTrace</code>.
   */
  public static void clearTrace() {
    Stella.$TRACED_KEYWORDS$.clear();
  }

  /** Set optimization levels for the qualities <code>safety</code>, <code>debug</code>,
   * <code>speed</code>, and <code>space</code>.
   * @param safety
   * @param debug
   * @param speed
   * @param space
   */
  public static void setOptimizationLevels(int safety, int debug, int speed, int space) {
    if ((safety != Stella.NULL_INTEGER) &&
        ((safety >= 0) &&
         (safety <= 3))) {
      Native.setIntSpecial(Stella.$SAFETY$, safety);
    }
    if ((debug != Stella.NULL_INTEGER) &&
        ((debug >= 0) &&
         (debug <= 3))) {
      Native.setIntSpecial(Stella.$DEBUGLEVEL$, debug);
    }
    if ((speed != Stella.NULL_INTEGER) &&
        ((speed >= 0) &&
         (speed <= 3))) {
      Native.setIntSpecial(Stella.$OPTIMIZESPEEDLEVEL$, speed);
    }
    if ((space != Stella.NULL_INTEGER) &&
        ((space >= 0) &&
         (space <= 3))) {
      Native.setIntSpecial(Stella.$OPTIMIZESPACELEVEL$, space);
    }
  }

  public static boolean preserveTailMergeOptimizabilityP() {
    return ((((Integer)(Stella.$OPTIMIZESPEEDLEVEL$.get())).intValue() >= 3) &&
        (((Integer)(Stella.$DEBUGLEVEL$.get())).intValue() <= 0));
  }

  public static boolean methodCallInliningEnabledP() {
    return ((((Integer)(Stella.$OPTIMIZESPEEDLEVEL$.get())).intValue() >= 3) &&
        (((Integer)(Stella.$DEBUGLEVEL$.get())).intValue() <= 1));
  }

  public static boolean optimizeBooleanTestsP() {
    return ((((Integer)(Stella.$OPTIMIZESPEEDLEVEL$.get())).intValue() >= 2) &&
        (((Integer)(Stella.$DEBUGLEVEL$.get())).intValue() <= 2));
  }

  public static boolean checkForIllegalReturnP() {
    return ((((Integer)(Stella.$SAFETY$.get())).intValue() >= 3) &&
        ((!(((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA)) &&
         (!Stella.preserveTailMergeOptimizabilityP())));
  }

  public static boolean supportUnexecP() {
    return (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_SUPPORT_UNEXEC) &&
        Stella.translateToCppP());
  }

  /** Return the quoted tree with name <code>treeName</code>.
   * @param treeName
   * @param modulename
   * @return Cons
   */
  public static Cons getQuotedTree(String treeName, String modulename) {
    { MemoizationTable memoTable000 = null;
      Cons memoizedEntry000 = null;
      Stella_Object memoizedValue000 = null;

      if (Stella.$MEMOIZATION_ENABLEDp$) {
        memoTable000 = ((MemoizationTable)(Stella.SGT_STELLA_F_GET_QUOTED_TREE_MEMO_TABLE_000.surrogateValue));
        if (memoTable000 == null) {
          Surrogate.initializeMemoizationTable(Stella.SGT_STELLA_F_GET_QUOTED_TREE_MEMO_TABLE_000, "(:MAX-VALUES 200 :TIMESTAMPS (:MODULE-UPDATE))");
          memoTable000 = ((MemoizationTable)(Stella.SGT_STELLA_F_GET_QUOTED_TREE_MEMO_TABLE_000.surrogateValue));
        }
        memoizedEntry000 = MruMemoizationTable.lookupMruMemoizedValue(((MruMemoizationTable)(memoTable000)), StringWrapper.wrapString(treeName), Stella.MEMOIZED_NULL_VALUE, null, null, 0);
        memoizedValue000 = memoizedEntry000.value;
      }
      if (memoizedValue000 != null) {
        if (memoizedValue000 == Stella.MEMOIZED_NULL_VALUE) {
          memoizedValue000 = null;
        }
      }
      else {
        memoizedValue000 = Stella_Object.permanentifyForm(((Cons)(Stella.unstringifyInModule(treeName, Stella.getStellaModule(modulename, true)))).value);
        if (Stella.$MEMOIZATION_ENABLEDp$) {
          memoizedEntry000.value = ((memoizedValue000 == null) ? Stella.MEMOIZED_NULL_VALUE : memoizedValue000);
        }
      }
      { Stella_Object value000 = ((Stella_Object)(memoizedValue000));

        return (((Cons)(value000)));
      }
    }
  }

  public static boolean useHardcodedSymbolsP() {
    return (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).memberP(Stella.KWD_USE_HARDCODED_SYMBOLS) ||
        ((Boolean)(Stella.$USEHARDCODEDSYMBOLSp$.get())).booleanValue());
  }

  public static Keyword translatorOutputLanguage() {
    return (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())));
  }

  public static String translatorOutputLanguageName() {
    if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
      return ("Common Lisp");
    }
    else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) {
      return ("C++");
    }
    else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) {
      return ("Java");
    }
    else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE) {
      return ("standalone-C++");
    }
    else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_IDL) {
      return ("IDL");
    }
    else {
      return (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())).symbolName);
    }
  }

  /** Return <code>true</code> if current output language is Common-Lisp.
   * @return boolean
   */
  public static boolean translateToCommonLispP() {
    return (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP);
  }

  /** Return <code>true</code> if current output language is C++
   * @return boolean
   */
  public static boolean translateToCppP() {
    return (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP);
  }

  /** Return <code>true</code> if current output language is Java
   * @return boolean
   */
  public static boolean translateToJavaP() {
    return (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA);
  }

  public static boolean translateToSingleInheritanceLanguageP() {
    if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) ||
        ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ||
         (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA))) {
      return (true);
    }
    else {
      return (false);
    }
  }

  /** Switch between Common Lisp and C++ as output languages.
   * @return Keyword
   */
  public static Keyword toggleOutputLanguage() {
    if (Stella.translateToCommonLispP()) {
      Native.setSpecial(Stella.$TRANSLATOROUTPUTLANGUAGE$, Stella.KWD_CPP);
      return (Stella.KWD_CPP);
    }
    else if (Stella.translateToCppP()) {
      Native.setSpecial(Stella.$TRANSLATOROUTPUTLANGUAGE$, Stella.KWD_JAVA);
      return (Stella.KWD_JAVA);
    }
    else {
      Native.setSpecial(Stella.$TRANSLATOROUTPUTLANGUAGE$, Stella.KWD_COMMON_LISP);
      return (Stella.KWD_COMMON_LISP);
    }
  }

  public static boolean useBootstrapTranslatorP() {
    return (false);
  }

  public static Keyword toggleTranslators() {
    return (null);
  }

  public static void walkAllPhaseOneUnits() {
    { List phaseoneunits = ((List)(Stella.$TRANSLATIONUNITS$.get()));

      Native.setSpecial(Stella.$TRANSLATIONUNITS$, List.newList());
      { TranslationUnit unit = null;
        Cons iter000 = phaseoneunits.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          unit = ((TranslationUnit)(iter000.value));
          if ((((Integer)(Stella.$TRANSLATIONVERBOSITYLEVEL$.get())).intValue() >= 2) &&
              (unit.annotation != null)) {
            Stella.STANDARD_OUTPUT.nativeStream.println("Walking `" + unit.annotation + "'");
          }
          TranslationUnit.walkPhaseOneUnit(unit);
        }
      }
      Stella.createFinalizationUnits();
      Stella.createStartupFunctionUnits();
      phaseoneunits.clear();
      ((List)(Stella.$TRANSLATIONUNITS$.get())).reverse();
    }
  }

  public static void translateAllUnits() {
    { TranslationUnit unit = null;
      Cons iter000 = ((List)(Stella.$TRANSLATIONUNITS$.get())).theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        unit = ((TranslationUnit)(iter000.value));
        { Object old$Currenttranslationunit$000 = Stella.$CURRENTTRANSLATIONUNIT$.get();

          try {
            Native.setSpecial(Stella.$CURRENTTRANSLATIONUNIT$, unit);
            if ((((Integer)(Stella.$TRANSLATIONVERBOSITYLEVEL$.get())).intValue() >= 2) &&
                (unit.annotation != null)) {
              Stella.STANDARD_OUTPUT.nativeStream.println("Translating `" + unit.annotation + "'");
            }
            if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
              unit.translation = TranslationUnit.clTranslateUnit(unit);
            }
            else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_IDL) {
              unit.translation = TranslationUnit.idlTranslateUnit(unit);
            }
            else if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) ||
                (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA_STANDALONE)) {
              if (unit.translation == null) {
                unit.translation = TranslationUnit.javaTranslateUnit(unit);
              }
            }
            else if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ||
                (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE)) {
              unit.translation = TranslationUnit.cppTranslateUnit(unit);
            }
            else {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("`" + ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }

          } finally {
            Stella.$CURRENTTRANSLATIONUNIT$.set(old$Currenttranslationunit$000);
          }
        }
      }
    }
  }

  public static Cons combineTranslatedTrees() {
    { Cons otree = Stella.NIL;

      if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) ||
          ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ||
           ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE) ||
            (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_IDL)))) {
        { TranslationUnit unit = null;
          Cons iter000 = ((List)(Stella.$TRANSLATIONUNITS$.get())).theConsList;
          Cons collect000 = null;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            unit = ((TranslationUnit)(iter000.value));
            if (collect000 == null) {
              {
                collect000 = Cons.cons(unit.translation, Stella.NIL);
                if (otree == Stella.NIL) {
                  otree = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(otree, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(unit.translation, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      else if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) ||
          (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA_STANDALONE)) {
        { TranslationUnit unit = null;
          Cons iter001 = ((List)(Stella.$TRANSLATIONUNITS$.get())).theConsList;
          Cons collect001 = null;

          for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
            unit = ((TranslationUnit)(iter001.value));
            if (!TranslationUnit.unitIncludedInOtherUnitsP(unit)) {
              if (collect001 == null) {
                {
                  collect001 = Cons.cons(unit.translation, Stella.NIL);
                  if (otree == Stella.NIL) {
                    otree = collect001;
                  }
                  else {
                    Cons.addConsToEndOfConsList(otree, collect001);
                  }
                }
              }
              else {
                {
                  collect001.rest = Cons.cons(unit.translation, Stella.NIL);
                  collect001 = collect001.rest;
                }
              }
            }
          }
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
        otree = Cons.cons(Stella.internCommonLispSymbol("PROGN"), otree.concatenate(Stella.NIL, Stella.NIL));
      }
      else if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ||
          ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE) ||
           ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) ||
            (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_IDL)))) {
      }
      else {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("`" + ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
      return (otree);
    }
  }

  public static void resetTranslationErrors() {
    Native.setIntSpecial(Stella.$TRANSLATIONERRORS$, 0);
    Native.setIntSpecial(Stella.$TRANSLATIONWARNINGS$, 0);
    Native.setIntSpecial(Stella.$TRANSLATIONNOTES$, 0);
  }

  public static void signalTranslationError() {
    Native.setIntSpecial(Stella.$TRANSLATIONERRORS$, ((Integer)(Stella.$TRANSLATIONERRORS$.get())).intValue() + 1);
  }

  public static void signalTranslationWarning() {
    Native.setIntSpecial(Stella.$TRANSLATIONWARNINGS$, ((Integer)(Stella.$TRANSLATIONWARNINGS$.get())).intValue() + 1);
  }

  public static void signalTranslationNote() {
    Native.setIntSpecial(Stella.$TRANSLATIONNOTES$, ((Integer)(Stella.$TRANSLATIONNOTES$.get())).intValue() + 1);
  }

  public static boolean ignoreTranslationErrorsP() {
    return (((Boolean)(Stella.$IGNORETRANSLATIONERRORSp$.get())).booleanValue());
  }

  public static boolean translationErrorsP() {
    return ((((Integer)(Stella.$TRANSLATIONERRORS$.get())).intValue() > 0) &&
        (!Stella.ignoreTranslationErrorsP()));
  }

  public static void summarizeTranslationErrors() {
    if (((Integer)(Stella.$TRANSLATIONERRORS$.get())).intValue() > 0) {
      Stella.STANDARD_OUTPUT.nativeStream.print(((Integer)(Stella.$TRANSLATIONERRORS$.get())).intValue() + " error");
      if (((Integer)(Stella.$TRANSLATIONERRORS$.get())).intValue() > 1) {
        Stella.STANDARD_OUTPUT.nativeStream.print("s");
      }
    }
    if (((Integer)(Stella.$TRANSLATIONWARNINGS$.get())).intValue() > 0) {
      if (((Integer)(Stella.$TRANSLATIONERRORS$.get())).intValue() > 0) {
        Stella.STANDARD_OUTPUT.nativeStream.print(", ");
      }
      Stella.STANDARD_OUTPUT.nativeStream.print(((Integer)(Stella.$TRANSLATIONWARNINGS$.get())).intValue() + " warning");
      if (((Integer)(Stella.$TRANSLATIONWARNINGS$.get())).intValue() > 1) {
        Stella.STANDARD_OUTPUT.nativeStream.print("s");
      }
    }
    if (((Integer)(Stella.$TRANSLATIONNOTES$.get())).intValue() > 0) {
      if ((((Integer)(Stella.$TRANSLATIONERRORS$.get())).intValue() > 0) ||
          (((Integer)(Stella.$TRANSLATIONWARNINGS$.get())).intValue() > 0)) {
        Stella.STANDARD_OUTPUT.nativeStream.print(", ");
      }
      Stella.STANDARD_OUTPUT.nativeStream.print(((Integer)(Stella.$TRANSLATIONNOTES$.get())).intValue() + " note");
      if (((Integer)(Stella.$TRANSLATIONNOTES$.get())).intValue() > 1) {
        Stella.STANDARD_OUTPUT.nativeStream.print("s");
      }
    }
    if ((((Integer)(Stella.$TRANSLATIONERRORS$.get())).intValue() > 0) ||
        ((((Integer)(Stella.$TRANSLATIONWARNINGS$.get())).intValue() > 0) ||
         (((Integer)(Stella.$TRANSLATIONNOTES$.get())).intValue() > 0))) {
      Stella.STANDARD_OUTPUT.nativeStream.println(".");
    }
  }

  public static void printErrorContext(String prefix, OutputStream stream) {
    stream.nativeStream.print(prefix + "While ");
    if (((Keyword)(Stella.$TRANSLATIONPHASE$.get())) != null) {
      if (((Keyword)(Stella.$TRANSLATIONPHASE$.get())) == Stella.KWD_DEFINE) {
        stream.nativeStream.print("defining ");
      }
      else if (((Keyword)(Stella.$TRANSLATIONPHASE$.get())) == Stella.KWD_FINALIZE) {
        stream.nativeStream.print("finalizing ");
      }
      else if (((Keyword)(Stella.$TRANSLATIONPHASE$.get())) == Stella.KWD_WALK) {
        stream.nativeStream.print("walking ");
      }
      else if (((Keyword)(Stella.$TRANSLATIONPHASE$.get())) == Stella.KWD_TRANSLATE) {
        stream.nativeStream.print("translating ");
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + ((Keyword)(Stella.$TRANSLATIONPHASE$.get())) + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
    else {
      stream.nativeStream.print("processing ");
    }
    if (((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())) != null) {
      { Stella_Object renamed_Object = ((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())).theObject;
        Symbol category = ((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())).category;

        if (category == Stella.SYM_STELLA_CLASS) {
          stream.nativeStream.print("class ");
          if (Surrogate.subtypeOfClassP(Stella_Object.safePrimaryType(renamed_Object))) {
            { Stella_Class object000 = ((Stella_Class)(renamed_Object));

              stream.nativeStream.print(object000.name());
            }
          }
          else {
            stream.nativeStream.print(renamed_Object);
          }
        }
        else if (category == Stella.SYM_STELLA_SLOT) {
          stream.nativeStream.print("external slot ");
          { Surrogate testValue000 = Stella_Object.safePrimaryType(renamed_Object);

            if (testValue000 == Stella.SGT_STELLA_CONS) {
              { Cons object000 = ((Cons)(renamed_Object));

                stream.nativeStream.print(object000.rest.value + "." + object000.rest.rest.value);
              }
            }
            else if (Surrogate.subtypeOfStorageSlotP(testValue000)) {
              { StorageSlot object000 = ((StorageSlot)(renamed_Object));

                stream.nativeStream.print(object000.slotOwner + "." + object000.slotName.symbolName);
              }
            }
            else {
              { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                stream001.nativeStream.print("`" + testValue000 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
        else if ((category == Stella.SYM_STELLA_METHOD) ||
            (category == Stella.SYM_STELLA_PRINT_METHOD)) {
          { Surrogate testValue001 = Stella_Object.safePrimaryType(renamed_Object);

            if (Surrogate.subtypeOfMethodSlotP(testValue001)) {
              { MethodSlot object000 = ((MethodSlot)(renamed_Object));

                if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(object000.dynamicSlots, Stella.SYM_STELLA_METHOD_MACROp, Stella.FALSE_WRAPPER))).wrapperValue) {
                  stream.nativeStream.print("macro " + object000.slotName);
                }
                else if (object000.methodFunctionP) {
                  stream.nativeStream.print("function " + object000.slotName);
                }
                else {
                  stream.nativeStream.print("method " + object000.slotOwner + "." + object000.slotName.symbolName);
                }
              }
            }
            else if (testValue001 == Stella.SGT_STELLA_CONS) {
              { Cons object000 = ((Cons)(renamed_Object));

                { GeneralizedSymbol testValue002 = ((GeneralizedSymbol)(object000.value));

                  if (testValue002 == Stella.SYM_STELLA_DEFMETHOD) {
                    stream.nativeStream.print("method ");
                  }
                  else if (testValue002 == Stella.SYM_STELLA_DEFUN) {
                    stream.nativeStream.print("function ");
                  }
                  else {
                  }
                }
                stream.nativeStream.print(((Stella_Object.consP(object000.rest.value) ? ((Cons)(object000.rest.value)).value : object000.rest.value)));
              }
            }
            else {
              { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                stream002.nativeStream.print("`" + testValue001 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream002.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
        else if (category == Stella.SYM_STELLA_GLOBAL_VARIABLE) {
          { Surrogate testValue003 = Stella_Object.safePrimaryType(renamed_Object);

            if (Surrogate.subtypeOfP(testValue003, Stella.SGT_STELLA_GLOBAL_VARIABLE)) {
              { GlobalVariable object000 = ((GlobalVariable)(renamed_Object));

                if (object000.variableConstantP) {
                  stream.nativeStream.print("constant ");
                }
                else {
                  if (object000.variableSpecialP) {
                    stream.nativeStream.print("special variable ");
                  }
                  else {
                    stream.nativeStream.print("global variable ");
                  }
                }
                stream.nativeStream.print(object000.variableName);
              }
            }
            else if (testValue003 == Stella.SGT_STELLA_CONS) {
              { Cons object000 = ((Cons)(renamed_Object));

                stream.nativeStream.print(object000.value + " " + object000.rest.value);
              }
            }
            else {
              { OutputStringStream stream003 = OutputStringStream.newOutputStringStream();

                stream003.nativeStream.print("`" + testValue003 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream003.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
        else if (category == Stella.SYM_STELLA_TYPE) {
          stream.nativeStream.print("type ");
          { Surrogate testValue004 = Stella_Object.safePrimaryType(renamed_Object);

            if (testValue004 == Stella.SGT_STELLA_CONS) {
              { Cons object000 = ((Cons)(renamed_Object));

                stream.nativeStream.print(object000.rest.value);
              }
            }
            else if (Surrogate.subtypeOfP(testValue004, Stella.SGT_STELLA_TYPE_SPEC)) {
              { StandardObject object000 = ((StandardObject)(renamed_Object));

                stream.nativeStream.print(StandardObject.yieldTypeSpecTree(object000));
              }
            }
            else {
              { OutputStringStream stream004 = OutputStringStream.newOutputStringStream();

                stream004.nativeStream.print("`" + testValue004 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream004.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
        else if (category == Stella.SYM_STELLA_MODULE) {
          stream.nativeStream.print("module ");
          { Surrogate testValue005 = Stella_Object.safePrimaryType(renamed_Object);

            if (Surrogate.subtypeOfP(testValue005, Stella.SGT_STELLA_MODULE)) {
              { Module object000 = ((Module)(renamed_Object));

                stream.nativeStream.print(object000.moduleName);
              }
            }
            else if (testValue005 == Stella.SGT_STELLA_CONS) {
              { Cons object000 = ((Cons)(renamed_Object));

                stream.nativeStream.print(object000.rest.value);
              }
            }
            else {
              { OutputStringStream stream005 = OutputStringStream.newOutputStringStream();

                stream005.nativeStream.print("`" + testValue005 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream005.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
        else {
          stream.nativeStream.print(category);
        }
      }
    }
    else {
      stream.nativeStream.print("top-level statement");
    }
    stream.nativeStream.print(":");
  }

  public static void logFunctionCall(String name) {
    if (!(Stella.$FUNCTION_CALL_LOG_STREAM$ == null)) {
      Stella.$FUNCTION_CALL_LOG_STREAM$.nativeStream.println(name);
    }
    if (Stella.$LOG_BREAK_POINT_COUNTER$ != Stella.NULL_INTEGER) {
      Stella.$LOG_BREAK_POINT_COUNTER$ = Stella.$LOG_BREAK_POINT_COUNTER$ - 1;
      if (Stella.$LOG_BREAK_POINT_COUNTER$ == 0) {
        Stella.$LOG_BREAK_POINT_COUNTER$ = Stella.NULL_INTEGER;
        Stella.breakProgram("Call log break point");
      }
    }
  }

  /** Start function call logging to <code>filename</code>.
   * @param filename
   */
  public static void startFunctionCallLogging(String filename) {
    { OutputStream currentlogstream = Stella.$FUNCTION_CALL_LOG_STREAM$;

      Stella.$FUNCTION_CALL_LOG_STREAM$ = null;
      if (currentlogstream != null) {
        currentlogstream.free();
      }
      Stella.$FUNCTION_CALL_LOG_STREAM$ = OutputFileStream.newOutputFileStream(filename);
    }
  }

  /** Stop function call logging and close the current log file.
   */
  public static void stopFunctionCallLogging() {
    { OutputStream currentlogstream = Stella.$FUNCTION_CALL_LOG_STREAM$;

      Stella.$FUNCTION_CALL_LOG_STREAM$ = null;
      if (currentlogstream != null) {
        currentlogstream.free();
      }
    }
  }

  /** Set a call log break point to <code>count</code>.  Execution will be
   * interrupted right at the entry of the <code>count</code>th logged function call.
   * @param count
   */
  public static void setCallLogBreakPoint(int count) {
    Stella.$LOG_BREAK_POINT_COUNTER$ = count;
  }

  /** Interrupt the program and print <code>message</code>.  Continue after
   * confirmation with the user.
   * @param message
   */
  public static void breakProgram(String message) {
    {
      {
        Stella.STANDARD_OUTPUT.nativeStream.println("Program break: " + message);
        Stella.STANDARD_OUTPUT.nativeStream.println();
      }
;
      if (!Stella.yesOrNoP("Continue?")) {
        Stella.terminateProgram();
      }
    }
  }

  /** Terminate and exit the program with normal exit code.
   */
  public static void terminateProgram() {
    java.lang.System.exit(0);;
  }

  public static void popVariableBinding() {
    { KvCons kvlist = ((KeyValueList)(Stella.$LOCALVARIABLETYPETABLE$.get())).theKvList;

      ((KeyValueList)(Stella.$LOCALVARIABLETYPETABLE$.get())).theKvList = kvlist.rest;
      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(kvlist.value), Stella.SGT_STELLA_KEY_VALUE_LIST)) {
        kvlist.value.free();
      }
      else {
      }
      KvCons.freeKvCons(kvlist);
    }
  }

  public static Symbol localGensym(String prefix) {
    if (((KeyValueList)(Stella.$LOCALGENSYMTABLE$.get())) == null) {
      return (Stella.gensym(prefix));
    }
    { IntegerWrapper prefixcounter = ((IntegerWrapper)(((KeyValueList)(Stella.$LOCALGENSYMTABLE$.get())).lookup(StringWrapper.wrapString(prefix))));

      if (prefixcounter == null) {
        prefixcounter = IntegerWrapper.wrapInteger(0);
      }
      else {
        prefixcounter = IntegerWrapper.wrapInteger(prefixcounter.wrapperValue + 1);
      }
      ((KeyValueList)(Stella.$LOCALGENSYMTABLE$.get())).insertAt(StringWrapper.wrapString(prefix), prefixcounter);
      return (Stella.internTransientSymbol(Stella.yieldGensymName(prefix, prefixcounter.wrapperValue)));
    }
  }

  public static Symbol methodGensym(String prefix) {
    { MethodSlot method = ((MethodSlot)(Stella.$METHODBEINGWALKED$.get()));
      boolean localP = false;

      if (method != null) {
        if (method.methodFunctionP) {
          prefix = "F-" + method.slotName.symbolName + "-" + prefix;
        }
        else {
          prefix = "M-" + method.slotOwner.symbolName + "." + method.slotName.symbolName + "-" + prefix;
        }
        localP = true;
      }
      if (localP) {
        return (Stella.localGensym(prefix));
      }
      else {
        return (Stella.gensym(prefix));
      }
    }
  }

  public static boolean renameShadowingLocalVariablesP() {
    return (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA);
  }

  public static boolean suppressWarningsP() {
    return (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).memberP(Stella.KWD_SUPPRESS_WARNINGS));
  }

  public static Cons yieldIllegalStatementTree() {
    { Object old$Localvariabletypetable$000 = Stella.$LOCALVARIABLETYPETABLE$.get();

      try {
        Native.setSpecial(Stella.$LOCALVARIABLETYPETABLE$, KeyValueList.newKeyValueList());
        return (((Cons)(Stella_Object.walkWithoutTypeTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_ERROR, Cons.cons(StringWrapper.wrapString("Attempt to execute illegal statement flagged by the translator"), Cons.cons(Stella.SYM_STELLA_EOL, Cons.cons(StringWrapper.wrapString("    but not yet fixed."), Cons.cons(Stella.NIL, Stella.NIL))))))))));

      } finally {
        Stella.$LOCALVARIABLETYPETABLE$.set(old$Localvariabletypetable$000);
      }
    }
  }

  public static Stella_Object yieldIllegalExpressionTree() {
    return (Stella.SYM_STELLA_ILLEGAL_EXPRESSION_FLAGGED_BY_THE_TRANSLATOR);
  }

  public static boolean nativeClassMethodInliningP() {
    if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
      return (false);
    }
    else if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) ||
        ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ||
         ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE) ||
          (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_IDL)))) {
      return (true);
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static boolean translatingCodeP() {
    return ((((Keyword)(Stella.$TRANSLATIONPHASE$.get())) == Stella.KWD_WALK) ||
        (((Keyword)(Stella.$TRANSLATIONPHASE$.get())) == Stella.KWD_TRANSLATE));
  }

  public static boolean walkingExpressionP() {
    return (!(((StandardObject)(Stella.$TARGETTYPE$.get())) == Stella.SGT_STELLA_VOID));
  }

  public static boolean needIdenticalMethodSignaturesP() {
    if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ||
        ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE) ||
         (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA))) {
      return (true);
    }
    else {
      return (false);
    }
  }

  public static boolean incrementalTranslationP() {
    return (((String)(Stella.$CURRENTFILE$.get())) == null);
  }

  public static void clearSymbolRegistry() {
    { GeneralizedSymbol symbol = null;
      Cons iter000 = Stella.$SYMBOL_SET$.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        symbol = ((GeneralizedSymbol)(iter000.value));
        Stella.$SYMBOL_REGISTRY$.removeAt(symbol);
      }
    }
    Stella.$SYMBOL_SET$.clear();
  }

  public static Cons yieldHardcodedInternRegisteredSymbolsTree() {
    { Cons interntrees = Cons.list$(Cons.cons(Stella.SYM_STELLA_STARTUP_TIME_PROGN, Cons.cons(Stella.KWD_SYMBOLS, Cons.cons(Stella.NIL, Stella.NIL))));

      { GeneralizedSymbol symbol = null;
        Cons iter000 = Stella.$SYMBOL_SET$.theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          symbol = ((GeneralizedSymbol)(iter000.value));
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Cons.cons((Stella_Object.symbolP(symbol) ? Stella.SYM_STELLA_INTERN_SYMBOL_AT : ((Stella_Object.surrogateP(symbol) ? Stella.SYM_STELLA_INTERN_SURROGATE_AT : Stella.SYM_STELLA_INTERN_KEYWORD_AT))), Cons.cons(StringWrapper.wrapString(symbol.symbolName), Cons.cons(IntegerWrapper.wrapInteger(symbol.symbolId), Stella.NIL))), Stella.NIL);
              if (interntrees == Stella.NIL) {
                interntrees = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(interntrees, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Cons.cons((Stella_Object.symbolP(symbol) ? Stella.SYM_STELLA_INTERN_SYMBOL_AT : ((Stella_Object.surrogateP(symbol) ? Stella.SYM_STELLA_INTERN_SURROGATE_AT : Stella.SYM_STELLA_INTERN_KEYWORD_AT))), Cons.cons(StringWrapper.wrapString(symbol.symbolName), Cons.cons(IntegerWrapper.wrapInteger(symbol.symbolId), Stella.NIL))), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (interntrees);
    }
  }

  public static Keyword specialImplementationStyle() {
    if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
      return (Stella.KWD_COMMON_LISP);
    }
    else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) {
      return (Stella.KWD_UNBIND_WITH_DESTRUCTORS);
    }
    else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) {
      return (Stella.KWD_COMMON_LISP);
    }
    else {
      return (Stella.KWD_UNWIND_PROTECT);
    }
  }

  public static void popSpecial() {
    { KvCons kvlist = ((KeyValueList)(Stella.$SPECIALVARIABLESTACK$.get())).theKvList;

      ((KeyValueList)(Stella.$SPECIALVARIABLESTACK$.get())).theKvList = kvlist.rest;
      KvCons.freeKvCons(kvlist);
    }
  }

  public static boolean needToUnbindSpecialsP() {
    return (((Boolean)(Stella.$SPECIALSENABLEDp$.get())).booleanValue() &&
        ((((KeyValueList)(Stella.$SPECIALVARIABLESTACK$.get())).length() > 0) &&
         (!Stella.getQuotedTree("((:COMMON-LISP :UNBIND-WITH-DESTRUCTORS) \"/STELLA\")", "/STELLA").memberP(Stella.specialImplementationStyle()))));
  }

  public static Cons yieldSpecialUnbindTree(int nofbindings) {
    { Cons otree = Stella.NIL;

      if (Stella.specialImplementationStyle() == Stella.KWD_UNWIND_PROTECT) {
        { Symbol variable = null;
          Symbol oldvaluevariable = null;
          KvCons iter000 = ((KeyValueList)(Stella.$SPECIALVARIABLESTACK$.get())).theKvList;

          for (;iter000 != null; iter000 = iter000.rest) {
            variable = ((Symbol)(iter000.key));
            oldvaluevariable = ((Symbol)(iter000.value));
            if ((nofbindings = nofbindings - 1) >= 0) {
              { Cons value000 = null;

                { Cons tree = null;
                  Cons iter001 = otree;

                  loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                    tree = ((Cons)(iter001.value));
                    if (tree.rest.value == variable) {
                      value000 = tree;
                      break loop001;
                    }
                  }
                }
                otree = otree.remove(value000);
              }
              otree = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(variable, Cons.cons(Cons.cons(oldvaluevariable, Stella.NIL), Stella.NIL)))), otree);
            }
          }
        }
        return (((Cons)(Cons.prognify(otree.reverse()))));
      }
      else {
        return (null);
      }
    }
  }

  public static Cons yieldReturnSpecialUnbindTree() {
    return (Stella.yieldSpecialUnbindTree(((KeyValueList)(Stella.$SPECIALVARIABLESTACK$.get())).length()));
  }

  public static Cons yieldLoopExitSpecialUnbindTree() {
    return (Stella.yieldSpecialUnbindTree(((KeyValueList)(Stella.$SPECIALVARIABLESTACK$.get())).length() - ((Integer)(Stella.$NOFSPECIALSATLOOPENTRY$.get())).intValue()));
  }

  public static boolean warnAboutUndefinedMethodsP() {
    return (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).memberP(Stella.KWD_WARN_ABOUT_UNDEFINED_METHODS));
  }

  public static boolean warnAboutMissingMethodsP() {
    return ((!(((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP)) ||
        ((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).memberP(Stella.KWD_WARN_ABOUT_MISSING_METHODS));
  }

  public static boolean mixinTypeVariablesAllowedP() {
    return ((!Stella.translateToSingleInheritanceLanguageP()) ||
        (!(Stella.$MIXIN_IMPLEMENTATION_STYLE$ == Stella.KWD_SECOND_CLASS)));
  }

  public static boolean createNativeMixinSlotAccessorsP() {
    return (Stella.translateToSingleInheritanceLanguageP() &&
        ((!Stella.translateToSingleInheritanceLanguageP()) ||
         (!(Stella.$MIXIN_IMPLEMENTATION_STYLE$ == Stella.KWD_SECOND_CLASS))));
  }

  public static void createFinalizationUnits() {
    Cons.walkAuxiliaryTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_STARTUP_TIME_PROGN, Cons.cons(Stella.KWD_FINALIZE_CLASSES, Cons.cons(Cons.cons(Stella.SYM_STELLA_FINALIZE_CLASSES, Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL))))));
    Cons.walkAuxiliaryTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_STARTUP_TIME_PROGN, Cons.cons(Stella.KWD_FINALIZE_METHODS, Cons.cons(Cons.cons(Stella.SYM_STELLA_FINALIZE_SLOTS, Stella.NIL), Cons.cons(Cons.cons(Stella.SYM_STELLA_CLEANUP_UNFINALIZED_CLASSES, Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL)))))));
  }

  public static Symbol yieldStartupFunctionName(String file) {
    file = ((file == null) ? ((String)(Stella.$CURRENTFILE$.get())) : file);
    if (Stella.systemStartupFileP(file)) {
      return (SystemDefinition.systemStartupFunctionSymbol(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get()))));
    }
    else {
      return (Symbol.internSymbolInModule("STARTUP-" + Native.stringUpcase(Stella.fileBaseName(file)), ((Module)(Stella.$MODULE$.get())), true));
    }
  }

  public static void createStartupFunctionUnits() {
    { Symbol startupfnname = (Stella.incrementalTranslationP() ? ((Symbol)(null)) : Stella.yieldStartupFunctionName(((String)(Stella.$CURRENTFILE$.get()))));
      Cons tree = null;
      MethodSlot method = null;

      if (Stella.dontGenerateStartupCodeP()) {
        Stella.removeAllStartupTimePrognUnits();
      }
      else if (startupfnname != null) {
        tree = Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFUN, Cons.cons(startupfnname, Cons.cons(Cons.list$(Cons.cons(Stella.NIL, Cons.cons(Stella.KWD_PUBLICp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL)))))), Stella.NIL))));
        method = Cons.defineMethodFromParseTree(tree);
        KeyValueList.setDynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_FORWARD_DECLARATIONp, Stella.FALSE_WRAPPER, Stella.FALSE_WRAPPER);
        KeyValueList.setDynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString(Symbol.yieldStartupFunctionClassname(startupfnname)), Stella.NULL_STRING_WRAPPER);
        tree = Cons.list$(Cons.cons(Stella.SYM_STELLA_STARTUP_TIME_PROGN, Cons.cons(Stella.KWD_METHODS, Cons.cons(MethodSlot.yieldDefineStellaMethodObject(method, method, null), Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_FUNCTION, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LOOKUP_FUNCTION, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_QUOTE, Cons.cons(startupfnname, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, Cons.cons(Stella.SYM_STELLA_FUNCTION, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(StringWrapper.wrapString(((StringWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, Stella.NULL_STRING_WRAPPER))).wrapperValue), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Stella.NIL)))));
        Cons.walkAuxiliaryTree(tree);
        if (Stella.systemStartupFileP(((String)(Stella.$CURRENTFILE$.get())))) {
          tree = Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFUN, Cons.cons(startupfnname, Cons.cons(Cons.list$(Cons.cons(Stella.NIL, Cons.cons(Stella.KWD_PUBLICp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Stella.KWD_AUXILIARYp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WITH_PROCESS_LOCK, Cons.cons(Stella.SYM_STELLA_$BOOTSTRAP_LOCK$, Cons.cons(Symbol.combineStartupFunctionUnits(startupfnname).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))))), Stella.NIL))));
        }
        else {
          tree = Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFUN, Cons.cons(startupfnname, Cons.cons(Cons.list$(Cons.cons(Stella.NIL, Cons.cons(Stella.KWD_PUBLICp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Stella.KWD_AUXILIARYp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Symbol.combineStartupFunctionUnits(startupfnname).concatenate(Stella.NIL, Stella.NIL), Stella.NIL))))))), Stella.NIL))));
        }
        KeyValueList.setDynamicSlotValue(((MethodSlot)(Cons.helpWalkAuxiliaryTree(tree, true).theObject)).dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString(Symbol.yieldStartupFunctionClassname(startupfnname)), Stella.NULL_STRING_WRAPPER);
      }
      else {
        tree = Cons.cons(Stella.SYM_STELLA_STARTUP_TIME_PROGN, Symbol.combineStartupFunctionUnits(startupfnname).concatenate(Stella.NIL, Stella.NIL));
        Cons.walkAuxiliaryTree(tree);
        tree = Cons.cons(Stella.SYM_STELLA_PROGN, ((Cons)(((TranslationUnit)(((List)(Stella.$TRANSLATIONUNITS$.get())).first())).theObject)));
        ((TranslationUnit)(((List)(Stella.$TRANSLATIONUNITS$.get())).first())).theObject = tree;
      }
    }
  }

  public static boolean dontGenerateStartupCodeP() {
    return (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE);
  }

  public static void removeAllStartupTimePrognUnits() {
    { TranslationUnit placeholderunit = null;

      { ListIterator it = ((ListIterator)(((List)(Stella.$TRANSLATIONUNITS$.get())).allocateIterator()));

        while (it.nextP()) {
          if (((TranslationUnit)(it.value)).category == Stella.SYM_STELLA_STARTUP_TIME_PROGN) {
            { TranslationUnit unit = ((TranslationUnit)(it.value));

              if (placeholderunit == null) {
                placeholderunit = unit;
              }
              else {
                TranslationUnit.clearTranslationUnit(unit);
              }
              it.valueSetter(placeholderunit);
            }
          }
        }
      }
      ((List)(Stella.$TRANSLATIONUNITS$.get())).remove(placeholderunit);
      TranslationUnit.clearTranslationUnit(placeholderunit);
    }
  }

  public static Surrogate getCurrentSelfType() {
    { MethodSlot method = ((MethodSlot)(Stella.$METHODBEINGWALKED$.get()));
      Surrogate owner = Stella.SGT_STELLA_UNKNOWN;

      if (method != null) {
        owner = method.owner();
        if (owner == null) {
          if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_METHOD_CONSTRUCTORp, Stella.FALSE_WRAPPER))).wrapperValue) {
            owner = method.slotBaseType;
          }
          else {
            owner = Stella.SGT_STELLA_UNKNOWN;
          }
        }
      }
      return (owner);
    }
  }

  public static java.lang.reflect.Method getGlobalExceptionHandler() {
    return (Stella.$GLOBAL_EXCEPTION_HANDLER$);
  }

  public static void setGlobalExceptionHandler(java.lang.reflect.Method handler) {
    Stella.$GLOBAL_EXCEPTION_HANDLER$ = handler;
  }

  public static void callGlobalExceptionHandler(java.lang.Exception e) {
    { java.lang.reflect.Method handler = Stella.getGlobalExceptionHandler();

      if (handler != null) {
        edu.isi.stella.javalib.Native.funcall(handler, null, new java.lang.Object [] {Stella.exceptionMessage(e), Stella.exceptionContext(e)});
      }
      else {
        throw ((java.lang.RuntimeException)(((java.lang.RuntimeException)(e)).fillInStackTrace()));
      }
    }
  }

  /** Protect <code>renamed_Object</code> from garbage collection.  Returns a handle that can later
   * be passed to <code>gcReleaseObject</code> to release <code>renamed_Object</code> from garbage collection protection.
   * @param renamed_Object
   * @return Object
   */
  public static Object gcProtectObject(Object renamed_Object) {
    return (renamed_Object);
  }

  /** Release the object pointed to by <code>handle</code> from garbage collection protection
   * and return the protected object.  This frees <code>handle</code> but does not necessarily mean that the
   * object will be garbage collected, it just can be again, once all references to it disappear.
   * @param handle
   * @return Object
   */
  public static Object gcReleaseObject(Object handle) {
    return (handle);
  }

  /** Evaluate the expression represented by <code>expression</code> and return the result.
   * This is equivalent to '(evaluate (unstringify expression))'.
   * @param expression
   * @return Stella_Object
   */
  public static Stella_Object evaluateString(String expression) {
    return (Stella_Object.evaluate(Stella.readSExpressionFromString(expression)));
  }

  public static boolean useClConsesP() {
    return (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_CONSES));
  }

  public static boolean useClStructsP() {
    return (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_STRUCTS));
  }

  public static boolean useVectorStructsP() {
    return (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_VECTOR_STRUCTS));
  }

  public static boolean generateClTypeDeclarationsP() {
    return (Stella.methodCallInliningEnabledP());
  }

  public static void clOutputAllUnitsToFile(String sourcefile) {
    { String outputfile = Stella.makeFileName(sourcefile, Stella.KWD_LISP, false);
      OutputFileStream outputstream = OutputFileStream.newOutputFileStream(outputfile);
      edu.isi.stella.javalib.NativeOutputStream nativeoutputstream = outputstream.nativeStream;

      if (((Integer)(Stella.$TRANSLATIONVERBOSITYLEVEL$.get())).intValue() >= 1) {
        Stella.STANDARD_OUTPUT.nativeStream.println("Writing `" + outputfile + "'...");
      }
      OutputStream.outputFileHeader(outputstream, outputfile);
      {
        nativeoutputstream.println(";;; Auxiliary variables:");
        nativeoutputstream.println();
      }
;
      { TranslationUnit unit = null;
        Cons iter000 = ((List)(Stella.$TRANSLATIONUNITS$.get())).theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          unit = ((TranslationUnit)(iter000.value));
          if (TranslationUnit.auxiliaryVariableUnitP(unit)) {
            TranslationUnit.clOutputOneUnit(unit, nativeoutputstream);
          }
        }
      }
      Stella.clOutputForwardDeclarations(nativeoutputstream);
      if (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_STRUCTS) &&
          (!((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_VECTOR_STRUCTS))) {
        { TranslationUnit unit = null;
          Cons iter001 = ((List)(Stella.$TRANSLATIONUNITS$.get())).theConsList;

          for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
            unit = ((TranslationUnit)(iter001.value));
            if (unit.category == Stella.SYM_STELLA_CLASS) {
              TranslationUnit.clOutputOneUnit(unit, nativeoutputstream);
            }
          }
        }
      }
      { TranslationUnit unit = null;
        Cons iter002 = ((List)(Stella.$TRANSLATIONUNITS$.get())).theConsList;

        for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
          unit = ((TranslationUnit)(iter002.value));
          if (!TranslationUnit.auxiliaryVariableUnitP(unit)) {
            TranslationUnit.clOutputOneUnit(unit, nativeoutputstream);
          }
        }
      }
      outputstream.free();
    }
  }

  public static void clOutputForwardDeclarations(edu.isi.stella.javalib.NativeOutputStream stream) {
    { List definedvariables = List.newList();
      List forwardreferencedvariables = List.newList();

      { TranslationUnit unit = null;
        Cons iter000 = ((List)(Stella.$TRANSLATIONUNITS$.get())).theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          unit = ((TranslationUnit)(iter000.value));
          if (TranslationUnit.auxiliaryVariableUnitP(unit)) {
            definedvariables.push(unit.theObject);
          }
        }
      }
      { TranslationUnit unit = null;
        Cons iter001 = ((List)(Stella.$TRANSLATIONUNITS$.get())).theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          unit = ((TranslationUnit)(iter001.value));
          if (!TranslationUnit.auxiliaryVariableUnitP(unit)) {
            if (unit.category == Stella.SYM_STELLA_GLOBAL_VARIABLE) {
              definedvariables.push(unit.theObject);
            }
            { GlobalVariable variable = null;
              Cons iter002 = unit.referencedGlobals.theConsList;

              for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                variable = ((GlobalVariable)(iter002.value));
                if ((!definedvariables.memberP(variable)) &&
                    (!forwardreferencedvariables.memberP(variable))) {
                  forwardreferencedvariables.push(variable);
                }
              }
            }
          }
        }
      }
      { ListIterator it = ((ListIterator)(forwardreferencedvariables.allocateIterator()));

        while (it.nextP()) {
          it.valueSetter(((GlobalVariable)(it.value)).variableName);
        }
      }
      if (forwardreferencedvariables.nonEmptyP()) {
        {
          stream.println();
          stream.println(";;; Forward declarations:");
          stream.println();
        }
;
        Stella_Object.printStellaDefinition(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("DECLAIM"), Cons.cons(Cons.cons(Stella.internCommonLispSymbol("SPECIAL"), Cons.clTranslateListOfTrees(forwardreferencedvariables.theConsList).concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))), stream);
      }
      definedvariables.free();
      forwardreferencedvariables.free();
    }
  }

  /** Translate a Stella <code>file</code> to Common-Lisp.  If
   * <code>relativeP</code>, concatenate root directory to <code>file</code>.
   * @param file
   * @param relativeP
   */
  public static void clTranslateFile(String file, boolean relativeP) {
    if (relativeP) {
      file = Stella.makeFileName(file, Stella.KWD_STELLA, true);
    }
    Stella.translateFile(file, Stella.KWD_COMMON_LISP, false);
  }

  public static String clYieldStructClassFileName(String systemname) {
    return (Native.stringDowncase(systemname) + "-system-structs");
  }

  /** Translate a Stella system named <code>systemName</code> to Common Lisp.
   * @param systemName
   */
  public static void clTranslateSystem(String systemName) {
    Stella.translateSystem(systemName, Cons.cons(Stella.KWD_COMMON_LISP, Cons.cons(Stella.KWD_TWO_PASSp, Cons.cons(Stella.TRUE_WRAPPER, Cons.cons(Stella.KWD_FORCE_TRANSLATIONp, Cons.cons(Stella.TRUE_WRAPPER, Cons.cons(Stella.KWD_PRODUCTION_SETTINGSp, Cons.cons(Stella.TRUE_WRAPPER, Stella.NIL))))))));
  }

  public static void clTranslateStella(boolean productionsettingsP) {
    Stella.translateSystem("stella", Cons.cons(Stella.KWD_COMMON_LISP, Cons.cons(Stella.KWD_FORCE_TRANSLATIONp, Cons.cons(Stella.TRUE_WRAPPER, Cons.cons(Stella.KWD_PRODUCTION_SETTINGSp, Cons.cons((productionsettingsP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.NIL))))));
  }

  public static void clRetranslateStella(boolean productionsettingsP) {
    Stella.translateSystem("stella", Cons.cons(Stella.KWD_COMMON_LISP, Cons.cons(Stella.KWD_TWO_PASSp, Cons.cons(Stella.TRUE_WRAPPER, Cons.cons(Stella.KWD_FORCE_TRANSLATIONp, Cons.cons(Stella.TRUE_WRAPPER, Cons.cons(Stella.KWD_PRODUCTION_SETTINGSp, Cons.cons((productionsettingsP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.NIL))))))));
  }

  public static Context computeContextOrModuleFromPathname(String pathname, boolean moduleP, boolean symbolnameP, Object [] MV_returnarray) {
    { Module context = ((pathname.charAt(0) == Stella.MODULE_SEPARATOR_CHARACTER) ? Stella.$ROOT_MODULE$ : ((Module)(null)));
      int componentend = ((context != null) ? 0 : -1);
      int componentstart = Stella.NULL_INTEGER;
      int lastcharpos = pathname.length() - 1;

      loop000 : while (componentend < lastcharpos) {
        componentstart = componentend + 1;
        componentend = componentstart;
        { int i = Stella.NULL_INTEGER;
          int iter000 = componentstart;
          int upperBound000 = lastcharpos;
          boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

          loop001 : for (;unboundedP000 ||
                    (iter000 <= upperBound000); iter000 = iter000 + 1) {
            i = iter000;
            if (!(pathname.charAt(i) == Stella.MODULE_SEPARATOR_CHARACTER)) {
              componentend = componentend + 1;
            }
            else {
              break loop001;
            }
          }
        }
        if (symbolnameP &&
            (componentend > lastcharpos)) {
          { Context _return_temp = ((context != null) ? context : ((moduleP ? ((Module)(Stella.$MODULE$.get())) : ((Context)(Stella.$CONTEXT$.get())))));

            MV_returnarray[0] = IntegerWrapper.wrapInteger(componentstart);
            return (_return_temp);
          }
        }
        if (context == null) {
          { String startstring = Native.string_subsequence(pathname, componentstart, componentend);

            context = ((Module)(Stella.string_getStellaContextSlowly(startstring)));
          }
        }
        else {
          { Context value000 = null;

            { Context child = null;
              Cons iter001 = context.childContexts.theConsList;

              loop002 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                child = ((Context)(iter001.value));
                { boolean testValue000 = false;

                  testValue000 = (!moduleP) ||
                      Stella_Object.isaP(child, Stella.SGT_STELLA_MODULE);
                  if (testValue000) {
                    if (Stella.componentMatchP((moduleP ? ((Module)(child)).moduleName : ((Context)(child)).contextName()), pathname, componentstart, componentend)) {
                      testValue000 = true;
                    }
                    else {
                      {
                        testValue000 = moduleP;
                        if (testValue000) {
                          testValue000 = ((Module)(child)).nicknames != null;
                          if (testValue000) {
                            { boolean foundP000 = false;

                              { StringWrapper nickname = null;
                                Cons iter002 = ((Module)(child)).nicknames.theConsList;

                                loop003 : for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                                  nickname = ((StringWrapper)(iter002.value));
                                  if (Stella.componentMatchP(nickname.wrapperValue, pathname, componentstart, componentend)) {
                                    foundP000 = true;
                                    break loop003;
                                  }
                                }
                              }
                              testValue000 = foundP000;
                            }
                          }
                        }
                      }
                    }
                  }
                  if (testValue000) {
                    value000 = child;
                    break loop002;
                  }
                }
              }
            }
            context = ((Module)(value000));
          }
        }
        if (context == null) {
          break loop000;
        }
      }
      if (context == null) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("No context with name `" + pathname + "'");
          throw ((NoSuchContextException)(NoSuchContextException.newNoSuchContextException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      else {
        { Context _return_temp = context;

          MV_returnarray[0] = IntegerWrapper.wrapInteger(Stella.NULL_INTEGER);
          return (_return_temp);
        }
      }
    }
  }

  public static boolean componentMatchP(String component, String string, int start, int end) {
    { boolean testValue000 = false;

      testValue000 = component != null;
      if (testValue000) {
        testValue000 = component.length() == (end - start);
        if (testValue000) {
          { boolean alwaysP000 = true;

            { char renamed_Char = Stella.NULL_CHARACTER;
              String vector000 = component;
              int index000 = 0;
              int length000 = vector000.length();
              int i = Stella.NULL_INTEGER;
              int iter000 = start;

              loop000 : for (;index000 < length000; index000 = index000 + 1, iter000 = iter000 + 1) {
                renamed_Char = vector000.charAt(index000);
                i = iter000;
                if (!(renamed_Char == string.charAt(i))) {
                  alwaysP000 = false;
                  break loop000;
                }
              }
            }
            testValue000 = alwaysP000;
          }
        }
      }
      { boolean value000 = testValue000;

        return (value000);
      }
    }
  }

  /** Compute the module indicated by the STELLA name
   * <code>name</code> and return it.  Return the bare symbol name as the second
   * value.  <code>name</code> does not necessarily have to be qualified in which
   * case the current module is returned.  <code>name</code> is assumed to be the
   * printed representation of a STELLA symbol, surrogate or keyword.
   * @param name
   * @param MV_returnarray
   * @return Module
   */
  public static Module computeModuleAndBareName(String name, Object [] MV_returnarray) {
    { Module module = ((Module)(Stella.$MODULE$.get()));

      { String barename = null;
        String modulename = null;
        Keyword kind = null;

        { Object [] caller_MV_returnarray = new Object[2];

          barename = Stella.parseStellaName(name, false, caller_MV_returnarray);
          modulename = ((String)(((StringWrapper)(caller_MV_returnarray[0])).wrapperValue));
          kind = ((Keyword)(caller_MV_returnarray[1]));
        }
        if (modulename != null) {
          module = Stella.getStellaModule(modulename, true);
        }
        if (kind == Stella.KWD_SYMBOL) {
          { Module _return_temp = module;

            MV_returnarray[0] = StringWrapper.wrapString(barename);
            return (_return_temp);
          }
        }
        else if (kind == Stella.KWD_SURROGATE) {
          { Module _return_temp = module;

            MV_returnarray[0] = StringWrapper.wrapString("@" + barename);
            return (_return_temp);
          }
        }
        else if (kind == Stella.KWD_KEYWORD) {
          { Module _return_temp = module;

            MV_returnarray[0] = StringWrapper.wrapString(":" + barename);
            return (_return_temp);
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + kind + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  public static Context helpGetStellaContextOrModule(String pathname, boolean moduleP) {
    if (Stella.qualifiedStellaNameP(pathname)) {
      return (Stella.computeContextOrModuleFromPathname(pathname, moduleP, false, new Object[1]));
    }
    else {
      return (Stella.string_getStellaContextSlowly(pathname));
    }
  }

  /** Return the context located at <code>pathname</code>, or <code>null</code>
   * if no such context exists.  If <code>errorP</code> is <code>true</code>, throw an exception
   * if no context is found, otherwise silently return <code>null</code>.
   * @param pathname
   * @param errorP
   * @return Context
   */
  public static Context getStellaContext(String pathname, boolean errorP) {
    if (errorP) {
      return (Stella.helpGetStellaContextOrModule(pathname, false));
    }
    else {
      try {
        return (Stella.helpGetStellaContextOrModule(pathname, false));
      } catch (NoSuchContextException e000) {
        return (null);
      }
    }
  }

  /** Return the module located at <code>pathname</code>, or <code>null</code>
   * if no such module exists.  The search looks at ancestors and top-most
   *  (cardinal) modules.  If <code>errorP</code> is <code>true</code>, throw an exception if no
   *  module is found.
   * @param pathname
   * @param errorP
   * @return Module
   */
  public static Module getStellaModule(String pathname, boolean errorP) {
    { StringWrapper wrappedpathname = new StringWrapper();
      Module module = null;

      wrappedpathname.wrapperValue = pathname;
      { MemoizationTable memoTable000 = null;
        Cons memoizedEntry000 = null;
        Stella_Object memoizedValue000 = null;

        if (Stella.$MEMOIZATION_ENABLEDp$) {
          memoTable000 = ((MemoizationTable)(Stella.SGT_STELLA_F_GET_STELLA_MODULE_MEMO_TABLE_000.surrogateValue));
          if (memoTable000 == null) {
            Surrogate.initializeMemoizationTable(Stella.SGT_STELLA_F_GET_STELLA_MODULE_MEMO_TABLE_000, "(:MAX-VALUES 100 :TIMESTAMPS (:MODULE-UPDATE))");
            memoTable000 = ((MemoizationTable)(Stella.SGT_STELLA_F_GET_STELLA_MODULE_MEMO_TABLE_000.surrogateValue));
          }
          memoizedEntry000 = MruMemoizationTable.lookupMruMemoizedValue(((MruMemoizationTable)(memoTable000)), wrappedpathname, Stella.MEMOIZED_NULL_VALUE, null, null, 0);
          memoizedValue000 = memoizedEntry000.value;
        }
        if (memoizedValue000 != null) {
          if (memoizedValue000 == Stella.MEMOIZED_NULL_VALUE) {
            memoizedValue000 = null;
          }
        }
        else {
          memoizedValue000 = Stella.helpGetStellaModule(pathname, false);
          if (Stella.$MEMOIZATION_ENABLEDp$) {
            memoizedEntry000.value = ((memoizedValue000 == null) ? Stella.MEMOIZED_NULL_VALUE : memoizedValue000);
          }
        }
        module = ((Module)(memoizedValue000));
      }
      if ((module == null) &&
          errorP) {
        Stella.helpGetStellaModule(pathname, true);
      }
      return (module);
    }
  }

  /** Return the module located at <code>pathname</code>, or <code>null</code>
   * if no such module exists.  The search looks at ancestors and top-most
   *  (cardinal) modules.  If <code>errorP</code> is <code>true</code>, throw an exception if no
   *  module is found.
   * @param pathname
   * @param errorP
   * @return Module
   */
  public static Module helpGetStellaModule(String pathname, boolean errorP) {
    if (Stella.stringEqlP(pathname, ((Module)(Stella.$MODULE$.get())).moduleFullName)) {
      return (((Module)(Stella.$MODULE$.get())));
    }
    { Context context = null;

      if (errorP) {
        context = Stella.helpGetStellaContextOrModule(pathname, true);
      }
      else {
        try {
          context = Stella.helpGetStellaContextOrModule(pathname, true);
        } catch (NoSuchContextException e000) {
          return (null);
        }
      }
      if (Stella_Object.isaP(context, Stella.SGT_STELLA_MODULE)) {
        return (((Module)(context)));
      }
      else if (errorP) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Context `" + context + "' is not a MODULE!");
          throw ((NoSuchContextException)(NoSuchContextException.newNoSuchContextException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      else {
        return (null);
      }
    }
  }

  /** Return a module located at <code>pathname</code> if one exists,
   *   otherwise create one
   * @param pathname
   * @return Module
   */
  public static Module findOrCreateModule(String pathname) {
    { Module module = Stella.getStellaModule(pathname, false);

      if (!(module != null)) {
        module = Module.defineModule(pathname, Stella.NIL);
      }
      return (module);
    }
  }

  /** Change the current context to be the context named
   * 'contextName'.
   * @param contextname
   * @return Context
   */
  public static Context string_changeContext(String contextname) {
    { Context context = Stella.getStellaContext(contextname, true);

      if (context == null) {
        return (((Context)(Stella.$CONTEXT$.get())));
      }
      else {
        return (Context.changeCurrentContext(context));
      }
    }
  }

  /** Change the current module to be the module named
   * 'moduleName'.
   * @param modulename
   * @return Module
   */
  public static Module string_changeModule(String modulename) {
    { Module module = Stella.getStellaModule(modulename, true);

      if (module == null) {
        return (((Module)(Stella.$MODULE$.get())));
      }
      else {
        return (Module.changeCurrentModule(module));
      }
    }
  }

  /** Destroy the context 'self', and recursively destroy
   * all contexts that inherit 'self'.
   * @param self
   */
  public static void string_destroyContext(String self) {
    { Context context = Stella.getStellaContext(self, true);

      if (!(context == null)) {
        context.destroyContext();
      }
    }
  }

  /** Spawn a new world that is a child of the current context,
   * and change the current context to the new world.
   * @return World
   */
  public static World pushWorld() {
    return (((World)(Native.setSpecial(Stella.$CONTEXT$, Context.createWorld(((Context)(Stella.$CONTEXT$.get())), null)))));
  }

  /** Destroy the current world and change the current
   * context to be its parent.  Return the current context. Nothing happens
   * if there is no current world.
   * @return Context
   */
  public static Context popWorld() {
    if (!(((Context)(Stella.$CONTEXT$.get())) == ((Module)(Stella.$MODULE$.get())))) {
      { World world = ((World)(((Context)(Stella.$CONTEXT$.get()))));

        Native.setSpecial(Stella.$CONTEXT$, world.parentContext);
        World.destroyWorld(world);
      }
    }
    return (((Context)(Stella.$CONTEXT$.get())));
  }

  /** Return an iterator that generates all contexts.
   * @return Iterator
   */
  public static Iterator allContexts() {
    { AllPurposeIterator iterator = Context.allSubcontexts(Stella.$ROOT_MODULE$, Stella.KWD_PREORDER);

      iterator.iteratorConsList = Cons.cons(Stella.$ROOT_MODULE$, Stella.NIL);
      return (iterator);
    }
  }

  /** Return an iterator that generates all modules.
   * @return Iterator
   */
  public static Iterator allModules() {
    { Iterator contextsiterator = Stella.allContexts();
      AllPurposeIterator iterator = AllPurposeIterator.newAllPurposeIterator();

      iterator.firstIterationP = true;
      iterator.iteratorNestedIterator = contextsiterator;
      iterator.iteratorNextCode = Native.find_java_method("edu.isi.stella.AllPurposeIterator", "filteredNestedIteratorNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
      iterator.iteratorFilterCode = Native.find_java_method("edu.isi.stella.Stella_Object", "filterModuleP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
      return (iterator);
    }
  }

  /** Returns a cons of all modules defined in PowerLoom.  If <code>kbOnlyP</code>
   * is <code>true</code>, then any modules which are code only or just namespaces are not returned.
   * @param kbOnlyP
   * @return Cons
   */
  public static Cons listModules(boolean kbOnlyP) {
    if (kbOnlyP) {
      { Cons value000 = Stella.NIL;

        { Module m = null;
          Iterator iter000 = Stella.allModules();
          Cons collect000 = null;

          while (iter000.nextP()) {
            m = ((Module)(iter000.value));
            if ((!((BooleanWrapper)(KeyValueList.dynamicSlotValue(m.dynamicSlots, Stella.SYM_STELLA_CODE_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue) &&
                (!((BooleanWrapper)(KeyValueList.dynamicSlotValue(m.dynamicSlots, Stella.SYM_STELLA_NAMESPACEp, Stella.FALSE_WRAPPER))).wrapperValue)) {
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(m, Stella.NIL);
                  if (value000 == Stella.NIL) {
                    value000 = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(value000, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(m, Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
        }
        { Cons value001 = value000;

          return (value001);
        }
      }
    }
    else {
      { Cons value002 = Stella.NIL;

        { Module m = null;
          Iterator iter001 = Stella.allModules();
          Cons collect001 = null;

          while (iter001.nextP()) {
            m = ((Module)(iter001.value));
            if (collect001 == null) {
              {
                collect001 = Cons.cons(m, Stella.NIL);
                if (value002 == Stella.NIL) {
                  value002 = collect001;
                }
                else {
                  Cons.addConsToEndOfConsList(value002, collect001);
                }
              }
            }
            else {
              {
                collect001.rest = Cons.cons(m, Stella.NIL);
                collect001 = collect001.rest;
              }
            }
          }
        }
        { Cons value003 = value002;

          return (value003);
        }
      }
    }
  }

  /** Destroy all objects belonging to module <code>name</code> or any of its children.
   * If no <code>name</code> is supplied, the current module will be cleared after
   * confirming with the user.  Important modules such as STELLA are protected
   * against accidental clearing.
   * @param name
   */
  public static void callClearModule(Cons name) {
    { Cons arglist = name;
      Module module = Stella_Object.coerceToModule(arglist.value, true);

      if (module != null) {
        if ((!(arglist == Stella.NIL)) ||
            Stella.yOrNP("Really clear module " + module.moduleFullName + "? ")) {
          Context.clearContext(module);
        }
      }
    }
  }

  /** Destroy all objects belonging to module <code>name</code> or any of its children.
   * If no <code>name</code> is supplied, the current module will be cleared after
   * confirming with the user.  Important modules such as STELLA are protected
   * against accidental clearing.
   * @param name
   */
  public static void clearModule(Cons name) {
    if (name.length() == 0) {
      Stella.callClearModule(Stella.NIL);
    }
    else {
      Stella.callClearModule(Cons.cons(name.value, Stella.NIL));
    }
  }

  public static Context helpFindContextByNumber(int number, List siblings) {
    { Context c = null;
      Cons iter000 = siblings.theConsList;

      loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        c = ((Context)(iter000.value));
        if (c.contextNumber == number) {
          return (c);
        }
        else if (c.contextNumber < number) {
          return (Stella.helpFindContextByNumber(number, c.childContexts));
        }
        else {
          continue loop000;
        }
      }
    }
    { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

      stream000.nativeStream.print("Couldn't find context with number `" + number + "'");
      throw ((NoSuchContextException)(NoSuchContextException.newNoSuchContextException(stream000.theStringReader()).fillInStackTrace()));
    }
  }

  public static Context findContextByNumber(int contextnumber) {
    return (Stella.helpFindContextByNumber(contextnumber, Stella.$ROOT_MODULE$.childContexts));
  }

  public static Context string_getStellaContextSlowly(String self) {
    { Context context = null;

      { Context cxt = null;
        Cons iter000 = Stella.$ROOT_MODULE$.childContexts.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          cxt = ((Context)(iter000.value));
          if (Stella.stringEqlP(cxt.contextName(), self)) {
            return (cxt);
          }
        }
      }
      { Context cxt = null;
        Iterator iter001 = Stella.allContexts();

        while (iter001.nextP()) {
          cxt = ((Context)(iter001.value));
          if (Stella.stringEqlP(cxt.contextName(), self) ||
              (Stella_Object.isaP(cxt, Stella.SGT_STELLA_MODULE) &&
               ((((Module)(cxt)).nicknames != null) &&
                ((Module)(cxt)).nicknames.memberP(StringWrapper.wrapString(self))))) {
            if (context != null) {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("More than one context has the name or nickname `" + self + "': `" + context + "' and `" + cxt + "'");
                throw ((NoSuchContextException)(NoSuchContextException.newNoSuchContextException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
            context = cxt;
          }
        }
      }
      if (context != null) {
        return (context);
      }
      else {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("No context with name or nickname `" + self + "'");
          throw ((NoSuchContextException)(NoSuchContextException.newNoSuchContextException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static Context integer_getStellaContextSlowly(int self) {
    return (Stella.findContextByNumber(self));
  }

  /** Change the current context to the one named <code>name</code>.  Return the
   * value of the new current context.  If no <code>name</code> is supplied, return
   * the pre-existing value of the current context.  <code>cc</code> is a no-op if the
   * context reference cannot be successfully evaluated.
   * @param name
   * @return Context
   */
  public static Context cc(Cons name) {
    { Context context = ((Context)(Stella.$CONTEXT$.get()));
      Stella_Object namespec = name.value;

      if (namespec != null) {
        { Surrogate testValue000 = Stella_Object.safePrimaryType(namespec);

          if (Surrogate.subtypeOfIntegerP(testValue000)) {
            { IntegerWrapper namespec000 = ((IntegerWrapper)(namespec));

              context = Stella.integer_getStellaContextSlowly(((int)(namespec000.wrapperValue)));
            }
          }
          else if (Surrogate.subtypeOfLongIntegerP(testValue000)) {
            { LongIntegerWrapper namespec000 = ((LongIntegerWrapper)(namespec));

              context = Stella.integer_getStellaContextSlowly(((int)(namespec000.wrapperValue)));
            }
          }
          else {
            { String contextname = Stella_Object.coerceToModuleName(namespec, true);

              if (contextname != null) {
                context = Stella.getStellaContext(contextname, true);
              }
            }
          }
        }
      }
      return (Context.changeContextSlowly(context));
    }
  }

  /** Change the current context to the one named <code>name</code>.  Return the
   * value of the new current context.  If no <code>name</code> is supplied, return
   * the pre-existing value of the current context.  <code>cc</code> is a no-op if the
   * context reference cannot be successfully evaluated.
   * In CommonLisp, if the new context is case sensitive, then change
   * the readtable case to the value of CL-USER::*STELLA-CASE-SENSITIVE-READ-MODE*
   * [default = :INVERT], otherwise to :UPCASE.
   * @param name
   * @return Context
   */
  public static Context ccc(Cons name) {
    { Context context = ((Context)(Stella.$CONTEXT$.get()));
      Stella_Object namespec = name.value;
      boolean casesensitiveP = context.baseModule.caseSensitiveP;

      if (namespec != null) {
        { Surrogate testValue000 = Stella_Object.safePrimaryType(namespec);

          if (Surrogate.subtypeOfIntegerP(testValue000)) {
            { IntegerWrapper namespec000 = ((IntegerWrapper)(namespec));

              context = Stella.integer_getStellaContextSlowly(((int)(namespec000.wrapperValue)));
            }
          }
          else if (Surrogate.subtypeOfLongIntegerP(testValue000)) {
            { LongIntegerWrapper namespec000 = ((LongIntegerWrapper)(namespec));

              context = Stella.integer_getStellaContextSlowly(((int)(namespec000.wrapperValue)));
            }
          }
          else {
            { String contextname = Stella_Object.coerceToModuleName(namespec, true);

              if (contextname != null) {
                context = Stella.getStellaContext(contextname, true);
                casesensitiveP = context.baseModule.caseSensitiveP;
              }
            }
          }
        }
      }
      return (Context.changeContextSlowly(context));
    }
  }

  public static TokenizerTable unstringifyTokenizerTable(String table) {
    { TokenizerTable result = TokenizerTable.newTokenizerTable();
      int acode = (int) 'A';
      String line = null;
      int count = 0;
      StringBuffer transitions = null;
      char separator = '|';
      int start = 0;
      int end = 0;

      end = Native.string_position(table, separator, start);
      line = Native.string_subsequence(table, start, end);
      start = end + 1;
      count = ((int)(Native.stringToInteger(line)));
      end = Native.string_position(table, separator, start);
      line = Native.string_subsequence(table, start, end);
      start = end + 1;
      transitions = edu.isi.stella.javalib.Native.makeMutableString((((int)(count / 2.0))), Stella.NULL_CHARACTER);
      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = ((int)((count / 2.0) - 1));

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          edu.isi.stella.javalib.Native.mutableString_nthSetter(transitions, ((char) ((((int) (line.charAt((2 * i))) - acode) | ((((int) (line.charAt(((2 * i) + 1))) - acode) << 4))))), i);
        }
      }
      result.transitions = transitions.toString();
      end = Native.string_position(table, separator, start);
      line = Native.string_subsequence(table, start, end);
      start = end + 1;
      count = ((int)(Native.stringToInteger(line)));
      result.uniqueStateNames = Vector.newVector(count);
      { int i = Stella.NULL_INTEGER;
        int iter001 = 0;
        int upperBound001 = count - 1;

        for (;iter001 <= upperBound001; iter001 = iter001 + 1) {
          i = iter001;
          end = Native.string_position(table, separator, start);
          line = Native.string_subsequence(table, start, end);
          start = end + 1;
          (result.uniqueStateNames.theArray)[i] = (Stella.internKeyword(line));
        }
      }
      end = Native.string_position(table, separator, start);
      line = Native.string_subsequence(table, start, end);
      start = end + 1;
      count = ((int)(Native.stringToInteger(line)));
      result.stateNames = Vector.newVector(count);
      { int i = Stella.NULL_INTEGER;
        int iter002 = 0;
        int upperBound002 = count - 1;

        for (;iter002 <= upperBound002; iter002 = iter002 + 1) {
          i = iter002;
          end = Native.string_position(table, separator, start);
          line = Native.string_subsequence(table, start, end);
          start = end + 1;
          (result.stateNames.theArray)[i] = (Stella.internKeyword(line));
        }
      }
      end = Native.string_position(table, separator, start);
      line = Native.string_subsequence(table, start, end);
      start = end + 1;
      count = ((int)(Native.stringToInteger(line)));
      end = Native.string_position(table, separator, start);
      line = Native.string_subsequence(table, start, end);
      start = end + 1;
      result.legalEofStates = Vector.newVector(count);
      { int i = Stella.NULL_INTEGER;
        int iter003 = 0;
        int upperBound003 = count - 1;

        for (;iter003 <= upperBound003; iter003 = iter003 + 1) {
          i = iter003;
          switch (line.charAt(i)) {
            case 'T': 
              (result.legalEofStates.theArray)[i] = Stella.TRUE_WRAPPER;
            break;
            case 'F': 
              (result.legalEofStates.theArray)[i] = Stella.FALSE_WRAPPER;
            break;
            default:
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("`" + line.charAt(i) + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
          }
        }
      }
      return (result);
    }
  }

  public static char[] makeTokenizerByteArray(int size) {
    return (new char[size]);
  }

  public static char[] stringToTokenizerByteArray(String string) {
    return (string.toCharArray());
  }

  public static String tokenizerByteArrayToString(char[] bytes) {
    return (new String(bytes));
  }

  public static char tokenizerByteArray_byteArrayNth(char[] buffer, int position) {
    return (buffer[position]);
  }

  public static char tokenizerByteArray_byteArrayNthSetter(char[] buffer, char ch, int position) {
    return (buffer[position] = ch);
  }

  public static int nativeByteArrayReadSequence(char[] buffer, edu.isi.stella.javalib.NativeInputStream stream, int start, int end) {
    { int n = 0;

      try {n = stream.getReader().read(buffer, start, end - start); if (n < 0) n = 0;}
         catch (java.io.IOException e) {n = 0;}
;
      return (n + start);
    }
  }

  public static int tokenizerByteArrayReadSequence(char[] buffer, InputStream stream, int start, int end) {
    { TokenizerStreamState state = stream.tokenizerState;
      int cursor = state.cursor;
      int internalEnd = state.end;
      int internalSize = state.bufferSize;
      OutputStream echostream = stream.echoStream;

      if (cursor == internalEnd) {
        if (InputStream.readIntoTokenizerBuffer(stream, state, -1)) {
          return (0);
        }
        cursor = state.cursor;
        internalEnd = state.end;
        if (cursor == internalSize) {
          cursor = 0;
        }
      }
      { int readSize = Stella.integer_min(end - start, internalEnd - cursor);
        int originalStart = start;
        char[] internalBuffer = state.buffer;

        { int i = Stella.NULL_INTEGER;
          int iter000 = 1;
          int upperBound000 = readSize;
          boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

          for (;unboundedP000 ||
                    (iter000 <= upperBound000); iter000 = iter000 + 1) {
            i = iter000;
            i = i;
            buffer[start] = (internalBuffer[cursor]);
            start = start + 1;
            cursor = cursor + 1;
          }
        }
        if (echostream != null) {
          Stella.byteArrayWriteSequence(buffer, echostream.nativeStream, originalStart, end);
        }
        state.cursor = cursor;
        return (readSize);
      }
    }
  }

  /** Read from <code>stream</code> filling <code>buffer</code> between <code>start</code> and <code>end</code> (depending
   * on how many characters are available).
   * Return the actual end pointer to the input read into <code>buffer</code>.  EOF is
   * indicated by the return value being equal to start.
   * @param buffer
   * @param stream
   * @param start
   * @param end
   * @return int
   */
  public static int byteArrayReadSequence(char[] buffer, InputStream stream, int start, int end) {
    if (stream.tokenizerState != null) {
      return (Stella.tokenizerByteArrayReadSequence(buffer, stream, start, end));
    }
    else {
      return (Stella.nativeByteArrayReadSequence(buffer, stream.nativeStream, start, end));
    }
  }

  public static void nativeByteArrayWriteSequence(char[] buffer, edu.isi.stella.javalib.NativeOutputStream stream, int start, int end) {
    try {stream.getWriter().write(buffer, start, end - start);}
         catch (java.lang.Exception e) {}
;
  }

  /** Write from <code>buffer</code> to <code>stream</code>, using data in the buffer starting at position
   * <code>start</code> stopping just before <code>end</code>.
   * @param buffer
   * @param stream
   * @param start
   * @param end
   */
  public static void byteArrayWriteSequence(char[] buffer, edu.isi.stella.javalib.NativeOutputStream stream, int start, int end) {
    Stella.nativeByteArrayWriteSequence(buffer, stream, start, end);
  }

  public static void unreadCharacterFromTokenizerBuffer(char renamed_Char, InputStream stream) {
    { TokenizerStreamState state = stream.tokenizerState;
      int cursor = state.cursor;

      if (cursor == 0) {
        cursor = state.bufferSize - 1;
      }
      else {
        cursor = cursor - 1;
      }
      if (!(renamed_Char == (state.buffer)[cursor])) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Unread character `" + renamed_Char + "' does not match last character read");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      state.cursor = cursor;
    }
  }

  public static boolean withTokenizerStringInputP() {
    return (((Surrogate)(Stella.$WITHTOKENIZERINPUTTYPE$.get())) == Stella.SGT_STELLA_STRING);
  }

  public static boolean insideWithTokenizerP() {
    return (((Surrogate)(Stella.$WITHTOKENIZERINPUTTYPE$.get())) != null);
  }

  public static Stella_Object endOfTokensP() {
    if (!Stella.insideWithTokenizerP()) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Encountered `end-of-tokens?' outside of `with-tokenizer' macro..");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      return (Cons.cons(Stella.SYM_STELLA_END_OF_TOKENSp, Stella.NIL));
    }
    return (Stella.SYM_STELLA_TOK_ENDOFTOKENSp_);
  }

  public static String getTokenTextInternal(char[] buffer, int start, int end, int size, boolean upcaseP) {
    if (start >= size) {
      start = start - size;
    }
    else if (start < 0) {
      start = size + start;
    }
    if (end > size) {
      end = end - size;
    }
    else if (end < 0) {
      end = size + end;
    }
    { int length = end - start;
      StringBuffer result = null;
      int cursor = 0;
      int auxend = end;

      if (length < 0) {
        length = length + size;
        auxend = size;
      }
      result = Stella.makeRawMutableString(length);
      if (upcaseP) {
        loop000 : for (;;) {
          while (start < auxend) {
            edu.isi.stella.javalib.Native.mutableString_nthSetter(result, (Stella.$CHARACTER_UPCASE_TABLE$.charAt(((int) (buffer[start])))), cursor);
            cursor = cursor + 1;
            start = start + 1;
          }
          if (auxend == end) {
            break loop000;
          }
          start = 0;
          auxend = end;
        }
      }
      else {
        loop002 : for (;;) {
          while (start < auxend) {
            edu.isi.stella.javalib.Native.mutableString_nthSetter(result, (buffer[start]), cursor);
            cursor = cursor + 1;
            start = start + 1;
          }
          if (auxend == end) {
            break loop002;
          }
          start = 0;
          auxend = end;
        }
      }
      return (result.toString());
    }
  }

  public static Stella_Object getTokenType() {
    if (!Stella.insideWithTokenizerP()) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Encountered `get-token-type' outside of `with-tokenizer' macro..");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      return (Cons.cons(Stella.SYM_STELLA_GET_TOKEN_TYPE, Stella.NIL));
    }
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_NTH, Cons.cons(Stella.SYM_STELLA_TOK_STATENAMES_, Cons.cons(Stella.SYM_STELLA_TOK_STATE_, Cons.cons(Stella.NIL, Stella.NIL))))));
  }

  public static Stella_Object saveTokenizerStreamState() {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(Stella.SYM_STELLA_TOK_STREAMSTATE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CURSOR, Cons.cons(Stella.SYM_STELLA_TOK_STREAMSTATE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TABLE, Cons.cons(Stella.SYM_STELLA_TOK_STREAMSTATE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_TOK_TABLE_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_STATE, Cons.cons(Stella.SYM_STELLA_TOK_STREAMSTATE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_TOK_STATE_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))))));
  }

  public static String unescapeTokenString(String token, char escapechar, boolean upcaseP) {
    { int nofescapes = 0;
      int cursor = 0;
      int cursor2 = 0;
      int size = token.length();
      StringBuffer result = null;
      boolean escapeP = false;

      while (cursor < size) {
        if (token.charAt(cursor) == escapechar) {
          nofescapes = nofescapes + 1;
          cursor = cursor + 1;
        }
        cursor = cursor + 1;
      }
      if (nofescapes == 0) {
        return (token);
      }
      result = Stella.makeRawMutableString(size - nofescapes);
      cursor = 0;
      while (cursor < size) {
        if ((token.charAt(cursor) == escapechar) &&
            (!escapeP)) {
          escapeP = true;
        }
        else if (upcaseP &&
            (!escapeP)) {
          edu.isi.stella.javalib.Native.mutableString_nthSetter(result, (Stella.$CHARACTER_UPCASE_TABLE$.charAt(((int) (token.charAt(cursor))))), cursor2);
          cursor2 = cursor2 + 1;
        }
        else {
          edu.isi.stella.javalib.Native.mutableString_nthSetter(result, (token.charAt(cursor)), cursor2);
          escapeP = false;
          cursor2 = cursor2 + 1;
        }
        cursor = cursor + 1;
      }
      return (result.toString());
    }
  }

  public static Stella_Object getStellaTokenType() {
    return (Stella.SYM_STELLA_TOK_STELLALOGICALSTATENAME_);
  }

  public static int getQualifiedSymbolSeparatorPositionInternal(char[] buffer, int tokenstart, int tokenend, int size, Keyword escapemode) {
    { int cursor = tokenend - 1;
      int separatorposition = 0;
      int nofescapes = 0;
      boolean fullyescapedP = escapemode == Stella.KWD_FULLY_ESCAPED;
      char targetchar = (fullyescapedP ? '|' : Stella.MODULE_SEPARATOR_CHARACTER);

      for (;;) {
        while (cursor >= 0) {
          if (buffer[cursor] == targetchar) {
            separatorposition = cursor;
            cursor = cursor - 1;
            if (cursor < 0) {
              cursor = size - 1;
            }
            nofescapes = 0;
            loop002 : for (;;) {
              while ((cursor >= 0) &&
                  (buffer[cursor] == '\\')) {
                nofescapes = nofescapes + 1;
                cursor = cursor - 1;
              }
              if ((cursor < 0) &&
                  (buffer[0] == '\\')) {
                cursor = size - 1;
              }
              else {
                break loop002;
              }
            }
            if (((nofescapes % 2) == 0)) {
              if (fullyescapedP) {
                separatorposition = separatorposition - 1;
                if (separatorposition < 0) {
                  separatorposition = separatorposition + size;
                }
                if (!(buffer[separatorposition] == Stella.MODULE_SEPARATOR_CHARACTER)) {
                  separatorposition = separatorposition - 1;
                }
              }
              separatorposition = separatorposition - tokenstart;
              if (separatorposition < 0) {
                return (separatorposition + size);
              }
              else {
                return (separatorposition);
              }
            }
          }
          else {
            cursor = cursor - 1;
          }
        }
        cursor = size - 1;
      }
    }
  }

  /** User-level macro to access the most recently parsed token as an integer.
   * This assumes correct signed integer syntax and only checks for overflows.
   * @return Stella_Object
   */
  public static Stella_Object getTokenInteger() {
    if (!Stella.insideWithTokenizerP()) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Encountered `get-token-integer' outside of `with-tokenizer' macro..");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      return (Cons.cons(Stella.SYM_STELLA_GET_TOKEN_INTEGER, Stella.NIL));
    }
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_GET_TOKEN_INTEGER_INTERNAL, Cons.cons(Stella.SYM_STELLA_TOK_BUFFER_, Cons.cons(Stella.SYM_STELLA_TOK_TOKENSTART_, Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(Stella.SYM_STELLA_TOK_SIZE_, Cons.cons(Stella.NIL, Stella.NIL))))))));
  }

  public static int getTokenIntegerInternal(char[] buffer, int start, int end, int size) {
    { long result = Stella.getTokenLongIntegerInternal(buffer, start, end, size);

      if ((result > Stella.MOST_POSITIVE_INTEGER) ||
          (result < Stella.MOST_NEGATIVE_INTEGER)) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("get-token-integer: integer overflow: `" + result + "'");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      return (((int)(result)));
    }
  }

  /** User-level macro to access the most recently parsed token as a long integer.
   * This assumes correct signed long-integer syntax and only checks for overflows.
   * @return Stella_Object
   */
  public static Stella_Object getTokenLongInteger() {
    if (!Stella.insideWithTokenizerP()) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Encountered `get-token-long-integer' outside of `with-tokenizer' macro..");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      return (Cons.cons(Stella.SYM_STELLA_GET_TOKEN_LONG_INTEGER, Stella.NIL));
    }
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_GET_TOKEN_LONG_INTEGER_INTERNAL, Cons.cons(Stella.SYM_STELLA_TOK_BUFFER_, Cons.cons(Stella.SYM_STELLA_TOK_TOKENSTART_, Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(Stella.SYM_STELLA_TOK_SIZE_, Cons.cons(Stella.NIL, Stella.NIL))))))));
  }

  public static long getTokenLongIntegerInternal(char[] buffer, int start, int end, int size) {
    { int length = end - start;
      int auxend = end;
      long result = 0l;
      boolean negativeP = false;
      int digit = 0;

      if (length < 0) {
        length = length + size;
        auxend = size;
      }
      switch (buffer[start]) {
        case '+': 
          start = start + 1;
        break;
        case '-': 
          start = start + 1;
          negativeP = true;
        break;
        default:
        break;
      }
      loop000 : for (;;) {
        while (start < auxend) {
          digit = (int) (buffer[start]) - (int) '0';
          if ((result >= Stella.$GET_TOKEN_LONG_INTEGER_CHECKPOINT$) &&
              (((Stella.MOST_POSITIVE_LONG_INTEGER - digit) / (10l)) < result)) {
            throw ((StellaException)(StellaException.newStellaException("get-token-long-integer: long-integer overflow").fillInStackTrace()));
          }
          result = (result * 10) + digit;
          start = start + 1;
        }
        if (auxend == end) {
          break loop000;
        }
        start = 0;
        auxend = end;
      }
      if (negativeP) {
        return (0 - result);
      }
      else {
        return (result);
      }
    }
  }

  /** User-level macro to access the most recently parsed token as a float.
   * This assumes correct signed float syntax and only checks for overflows.
   * The main benefit for this is that it doesn't generate strings and wrappers.
   * Float parsing and conversion is generally hairy and we are probably not
   * covering all special cases here; but we are fast :-)
   * @return Stella_Object
   */
  public static Stella_Object getTokenFloat() {
    if (!Stella.insideWithTokenizerP()) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Encountered `get-token-float' outside of `with-tokenizer' macro..");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      return (Cons.cons(Stella.SYM_STELLA_GET_TOKEN_FLOAT, Stella.NIL));
    }
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_GET_TOKEN_FLOAT_INTERNAL, Cons.cons(Stella.SYM_STELLA_TOK_BUFFER_, Cons.cons(Stella.SYM_STELLA_TOK_TOKENSTART_, Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(Stella.SYM_STELLA_TOK_SIZE_, Cons.cons(Stella.NIL, Stella.NIL))))))));
  }

  public static double getTokenFloatInternal(char[] buffer, int start, int end, int size) {
    { int length = end - start;
      int auxend = end;
      long mantissa = 0l;
      int exponent = 0;
      double mantissasign = 1.0;
      double exponentsign = 1.0;
      boolean exponentP = false;
      boolean decimalsP = false;
      int decimals = 0;
      char ch = Stella.NULL_CHARACTER;
      int digit = 0;
      double result = 0.0;

      if (length < 0) {
        length = length + size;
        auxend = size;
      }
      loop000 : for (;;) {
        while (start < auxend) {
          ch = buffer[start];
          switch (ch) {
            case '-': 
              if (exponentP) {
                exponentsign = -1.0;
              }
              else {
                mantissasign = -1.0;
              }
            break;
            case '+': 
            break;
            case '.': 
              decimalsP = true;
            break;
            case 'e': 
            case 'E': 
              exponentP = true;
            break;
            default:
              digit = (int) ch - (int) '0';
              if (exponentP) {
                exponent = (exponent * 10) + digit;
              }
              else {
                if (decimalsP) {
                  decimals = decimals + 1;
                }
                mantissa = (mantissa * 10) + digit;
              }
            break;
          }
          start = start + 1;
        }
        if (auxend == end) {
          break loop000;
        }
        start = 0;
        auxend = end;
      }
      result = ((double)(mantissa));
      exponent = ((int)((exponent * exponentsign) - decimals));
      if (!(exponent == 0)) {
        result = result * Math.pow((10.0),(((double)(exponent))));
      }
      return (result * mantissasign);
    }
  }

  /** Parse the printed representation <code>name</code> of a STELLA symbol, surrogate or
   * keyword and return its symbol name, module name and type (which is either
   * :SYMBOL, :SURROGATE or :KEYWORD).  <code>name</code> can be qualified and must use the
   * exact same syntax and escape characters that would be used if it were to be
   * read by <code>readSExpressionFromString</code> (or <code>unstringify</code>).  If
   * <code>enableCaseConversionP</code> is TRUE, the returned symbol name will be upcased if
   * the current module is case-insensitive; otherwise, it will be returned as is.
   * Raises a read exception if <code>name</code> does not represent a symbol.
   * This function is available primarily for efficiency, since it is about
   * 10-15 times faster than <code>unstringify</code>.
   * @param name
   * @param enablecaseconversionP
   * @param MV_returnarray
   * @return String
   */
  public static String parseStellaName(String name, boolean enablecaseconversionP, Object [] MV_returnarray) {
    { String symbolname = null;
      String modulename = null;
      Keyword symboltype = null;
      int separatorpos = 0;
      boolean upcaseP = enablecaseconversionP &&
          (!((Module)(Stella.$MODULE$.get())).caseSensitiveP);

      { TokenizerTable tok_table_ = Stella.$STELLA_TOKENIZER_TABLE$;
        String tok_transitions_ = tok_table_.transitions;
        edu.isi.stella.Stella_Object[] tok_statenames_ = tok_table_.stateNames.theArray;
        int tok_tokenstart_ = -1;
        boolean tok_endoftokensP_ = false;
        TokenizerStreamState tok_streamstate_ = null;
        char[] tok_buffer_ = name.toCharArray();
        int tok_state_ = 1;
        int tok_nextstate_ = tok_state_;
        int tok_cursor_ = 0;
        int tok_size_ = name.length();
        int tok_end_ = tok_size_;

        {
          tok_statenames_ = tok_statenames_;
          tok_endoftokensP_ = tok_endoftokensP_;
        }
        tok_streamstate_ = tok_streamstate_;
        { edu.isi.stella.Stella_Object[] tok_stellalogicalstatenames_ = Stella.$STELLA_LOGICAL_STATE_NAMES$.theArray;
          Keyword tok_stellalogicalstatename_ = null;

          {
            {
              tok_tokenstart_ = -1;
              loop000 : for (;;) {
                if (tok_cursor_ == tok_end_) {
                  if (tok_nextstate_ == -1) {
                    tok_endoftokensP_ = true;
                  }
                  else if (BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)((tok_table_.legalEofStates.theArray)[tok_state_])))) {
                    tok_nextstate_ = -1;
                    if (tok_tokenstart_ == -1) {
                      tok_endoftokensP_ = true;
                    }
                  }
                  else {
                    tok_state_ = 0;
                    tok_nextstate_ = -1;
                  }
                  break loop000;
                }
                tok_nextstate_ = (int) (tok_buffer_[tok_cursor_]);
                tok_nextstate_ = (int) (tok_transitions_.charAt(((((tok_state_ << 8)) | tok_nextstate_))));
                if ((tok_nextstate_ & 128) == 0) {
                  tok_state_ = tok_nextstate_;
                  tok_cursor_ = tok_cursor_ + 1;
                }
                else if (tok_tokenstart_ == -1) {
                  if ((tok_nextstate_ & 64) == 0) {
                    tok_tokenstart_ = tok_cursor_;
                  }
                  tok_state_ = (tok_nextstate_ & 63);
                  tok_cursor_ = tok_cursor_ + 1;
                }
                else {
                  break loop000;
                }
              }
            }
            tok_stellalogicalstatename_ = ((Keyword)(tok_stellalogicalstatenames_[tok_state_]));
          }
          if (tok_endoftokensP_) {
            { String _return_temp = null;

              MV_returnarray[0] = StringWrapper.wrapString(null);
              MV_returnarray[1] = null;
              return (_return_temp);
            }
          }
          if (tok_stellalogicalstatename_ == Stella.KWD_SYMBOL) {
            { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tok_statenames_[tok_state_]));

              if (testValue000 == Stella.KWD_SYMBOL) {
                symbolname = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, upcaseP);
              }
              else if (testValue000 == Stella.KWD_QUALIFIED_SYMBOL) {
                separatorpos = Stella.getQualifiedSymbolSeparatorPositionInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, Stella.KWD_NONE);
                symbolname = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + separatorpos + 1, tok_cursor_, tok_size_, upcaseP);
                modulename = ((separatorpos == 0) ? "ROOT-MODULE" : Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, ((separatorpos < 0) ? (tok_cursor_ + separatorpos) : (tok_tokenstart_ + separatorpos)), tok_size_, true));
              }
              else if (testValue000 == Stella.KWD_FULLY_ESCAPED_SYMBOL) {
                symbolname = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + 1, tok_cursor_, tok_size_, false), '\\', false);
              }
              else if (testValue000 == Stella.KWD_QUALIFIED_FULLY_ESCAPED_SYMBOL) {
                separatorpos = Stella.getQualifiedSymbolSeparatorPositionInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, Stella.KWD_FULLY_ESCAPED);
                symbolname = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + separatorpos + 2, tok_cursor_, tok_size_, false), '\\', false);
                modulename = ((separatorpos == 0) ? "ROOT-MODULE" : Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, ((separatorpos < 0) ? (tok_cursor_ + separatorpos) : (tok_tokenstart_ + separatorpos)), tok_size_, true));
              }
              else if (testValue000 == Stella.KWD_ESCAPED_SYMBOL) {
                symbolname = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false), '\\', upcaseP);
              }
              else if (testValue000 == Stella.KWD_QUALIFIED_ESCAPED_SYMBOL) {
                separatorpos = Stella.getQualifiedSymbolSeparatorPositionInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, Stella.KWD_ESCAPED);
                symbolname = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + separatorpos + 1, tok_cursor_, tok_size_, false), '\\', upcaseP);
                modulename = ((separatorpos == 0) ? "ROOT-MODULE" : Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, ((separatorpos < 0) ? (tok_cursor_ + separatorpos) : (tok_tokenstart_ + separatorpos)), tok_size_, true));
              }
              else if (testValue000 == Stella.KWD_CL_SYMBOL) {
                symbolname = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + 3, tok_cursor_, tok_size_, true);
                modulename = "/COMMON-LISP";
              }
              else {
                { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                  stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
                  throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                }
              }
            }
          }
          else if (tok_stellalogicalstatename_ == Stella.KWD_SURROGATE) {
            { GeneralizedSymbol testValue001 = ((GeneralizedSymbol)(tok_statenames_[tok_state_]));

              if (testValue001 == Stella.KWD_SURROGATE) {
                symbolname = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + 1, tok_cursor_, tok_size_, upcaseP);
              }
              else if (testValue001 == Stella.KWD_QUALIFIED_SURROGATE) {
                separatorpos = Stella.getQualifiedSymbolSeparatorPositionInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, Stella.KWD_NONE);
                symbolname = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + separatorpos + 2, tok_cursor_, tok_size_, upcaseP);
                modulename = ((separatorpos == 0) ? "ROOT-MODULE" : Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, ((separatorpos < 0) ? (tok_cursor_ + separatorpos) : (tok_tokenstart_ + separatorpos)), tok_size_, true));
              }
              else if (testValue001 == Stella.KWD_FULLY_ESCAPED_SURROGATE) {
                symbolname = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + 2, tok_cursor_, tok_size_, false), '\\', false);
              }
              else if (testValue001 == Stella.KWD_QUALIFIED_FULLY_ESCAPED_SURROGATE) {
                separatorpos = Stella.getQualifiedSymbolSeparatorPositionInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, Stella.KWD_FULLY_ESCAPED);
                symbolname = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + separatorpos + 3, tok_cursor_, tok_size_, false), '\\', false);
                modulename = ((separatorpos == 0) ? "ROOT-MODULE" : Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, ((separatorpos < 0) ? (tok_cursor_ + separatorpos) : (tok_tokenstart_ + separatorpos)), tok_size_, true));
              }
              else if (testValue001 == Stella.KWD_ESCAPED_SURROGATE) {
                symbolname = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + 1, tok_cursor_, tok_size_, false), '\\', upcaseP);
              }
              else if (testValue001 == Stella.KWD_QUALIFIED_ESCAPED_SURROGATE) {
                separatorpos = Stella.getQualifiedSymbolSeparatorPositionInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, Stella.KWD_ESCAPED);
                symbolname = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + separatorpos + 2, tok_cursor_, tok_size_, false), '\\', upcaseP);
                modulename = ((separatorpos == 0) ? "ROOT-MODULE" : Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, ((separatorpos < 0) ? (tok_cursor_ + separatorpos) : (tok_tokenstart_ + separatorpos)), tok_size_, true));
              }
              else {
                { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                  stream001.nativeStream.print("`" + testValue001 + "' is not a valid case option");
                  throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
                }
              }
            }
          }
          else if (tok_stellalogicalstatename_ == Stella.KWD_KEYWORD) {
            { GeneralizedSymbol testValue002 = ((GeneralizedSymbol)(tok_statenames_[tok_state_]));

              if (testValue002 == Stella.KWD_KEYWORD) {
                symbolname = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + 1, tok_cursor_, tok_size_, true);
              }
              else if (testValue002 == Stella.KWD_FULLY_ESCAPED_KEYWORD) {
                symbolname = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + 2, tok_cursor_, tok_size_, false), '\\', false);
              }
              else if (testValue002 == Stella.KWD_ESCAPED_KEYWORD) {
                symbolname = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + 1, tok_cursor_, tok_size_, false), '\\', true);
              }
              else {
                { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                  stream002.nativeStream.print("`" + testValue002 + "' is not a valid case option");
                  throw ((StellaException)(StellaException.newStellaException(stream002.theStringReader()).fillInStackTrace()));
                }
              }
            }
          }
          else if (tok_stellalogicalstatename_ == Stella.KWD_QUALIFIED_NAME) {
            { String token = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, true);
              int length = token.length();

              if ((length >= 1) &&
                  ((token.charAt((length - 1)) == '/') &&
                   ((length == 1) ||
                    (token.charAt((length - 2)) == '/')))) {
                symbolname = "/";
                tok_stellalogicalstatename_ = Stella.KWD_SYMBOL;
                if (length > 1) {
                  modulename = Native.string_subsequence(token, 0, length - 2);
                }
              }
              else {
                { OutputStringStream stream003 = OutputStringStream.newOutputStringStream();

                  stream003.nativeStream.print("Illegal symbol syntax: `" + Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false) + "' in state `" + ((GeneralizedSymbol)(tok_statenames_[tok_state_])) + "'");
                  throw ((ReadException)(ReadException.newReadException(stream003.theStringReader()).fillInStackTrace()));
                }
              }
            }
          }
          else if (tok_stellalogicalstatename_ == Stella.KWD_ERROR) {
            { OutputStringStream stream004 = OutputStringStream.newOutputStringStream();

              stream004.nativeStream.print("Illegal read syntax: `" + Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false) + "'");
              throw ((ReadException)(ReadException.newReadException(stream004.theStringReader()).fillInStackTrace()));
            }
          }
          else {
            { OutputStringStream stream005 = OutputStringStream.newOutputStringStream();

              stream005.nativeStream.print("Illegal symbol syntax: `" + Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false) + "' in state `" + ((GeneralizedSymbol)(tok_statenames_[tok_state_])) + "'");
              throw ((ReadException)(ReadException.newReadException(stream005.theStringReader()).fillInStackTrace()));
            }
          }
          symboltype = tok_stellalogicalstatename_;
          {
            {
              tok_tokenstart_ = -1;
              loop001 : for (;;) {
                if (tok_cursor_ == tok_end_) {
                  if (tok_nextstate_ == -1) {
                    tok_endoftokensP_ = true;
                  }
                  else if (BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)((tok_table_.legalEofStates.theArray)[tok_state_])))) {
                    tok_nextstate_ = -1;
                    if (tok_tokenstart_ == -1) {
                      tok_endoftokensP_ = true;
                    }
                  }
                  else {
                    tok_state_ = 0;
                    tok_nextstate_ = -1;
                  }
                  break loop001;
                }
                tok_nextstate_ = (int) (tok_buffer_[tok_cursor_]);
                tok_nextstate_ = (int) (tok_transitions_.charAt(((((tok_state_ << 8)) | tok_nextstate_))));
                if ((tok_nextstate_ & 128) == 0) {
                  tok_state_ = tok_nextstate_;
                  tok_cursor_ = tok_cursor_ + 1;
                }
                else if (tok_tokenstart_ == -1) {
                  if ((tok_nextstate_ & 64) == 0) {
                    tok_tokenstart_ = tok_cursor_;
                  }
                  tok_state_ = (tok_nextstate_ & 63);
                  tok_cursor_ = tok_cursor_ + 1;
                }
                else {
                  break loop001;
                }
              }
            }
            tok_stellalogicalstatename_ = ((Keyword)(tok_stellalogicalstatenames_[tok_state_]));
          }
          if (tok_endoftokensP_ ||
              (((GeneralizedSymbol)(tok_statenames_[tok_state_])) == Stella.KWD_CLOSE_FULLY_ESCAPED_NAME)) {
            { String _return_temp = symbolname;

              MV_returnarray[0] = StringWrapper.wrapString(modulename);
              MV_returnarray[1] = symboltype;
              return (_return_temp);
            }
          }
          else {
            { OutputStringStream stream006 = OutputStringStream.newOutputStringStream();

              stream006.nativeStream.print("Garbage found after `" + name + "'");
              throw ((ReadException)(ReadException.newReadException(stream006.theStringReader()).fillInStackTrace()));
            }
          }
        }
      }
    }
  }

  /** Return TRUE if <code>name</code> is a symbol or surrogate qualified with a module
   * pathname or a module pathname ending with a <code>S</code>.  Assumes that <code>name</code>
   * is the printed representation of a STELLA symbol (potentially containing
   * escape characters).
   * @param name
   * @return boolean
   */
  public static boolean qualifiedStellaNameP(String name) {
    { TokenizerTable tok_table_ = Stella.$STELLA_TOKENIZER_TABLE$;
      String tok_transitions_ = tok_table_.transitions;
      edu.isi.stella.Stella_Object[] tok_statenames_ = tok_table_.stateNames.theArray;
      int tok_tokenstart_ = -1;
      boolean tok_endoftokensP_ = false;
      TokenizerStreamState tok_streamstate_ = null;
      char[] tok_buffer_ = name.toCharArray();
      int tok_state_ = 1;
      int tok_nextstate_ = tok_state_;
      int tok_cursor_ = 0;
      int tok_size_ = name.length();
      int tok_end_ = tok_size_;

      {
        tok_statenames_ = tok_statenames_;
        tok_endoftokensP_ = tok_endoftokensP_;
      }
      tok_streamstate_ = tok_streamstate_;
      { edu.isi.stella.Stella_Object[] tok_stellalogicalstatenames_ = Stella.$STELLA_LOGICAL_STATE_NAMES$.theArray;
        Keyword tok_stellalogicalstatename_ = null;

        {
          {
            tok_tokenstart_ = -1;
            loop000 : for (;;) {
              if (tok_cursor_ == tok_end_) {
                if (tok_nextstate_ == -1) {
                  tok_endoftokensP_ = true;
                }
                else if (BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)((tok_table_.legalEofStates.theArray)[tok_state_])))) {
                  tok_nextstate_ = -1;
                  if (tok_tokenstart_ == -1) {
                    tok_endoftokensP_ = true;
                  }
                }
                else {
                  tok_state_ = 0;
                  tok_nextstate_ = -1;
                }
                break loop000;
              }
              tok_nextstate_ = (int) (tok_buffer_[tok_cursor_]);
              tok_nextstate_ = (int) (tok_transitions_.charAt(((((tok_state_ << 8)) | tok_nextstate_))));
              if ((tok_nextstate_ & 128) == 0) {
                tok_state_ = tok_nextstate_;
                tok_cursor_ = tok_cursor_ + 1;
              }
              else if (tok_tokenstart_ == -1) {
                if ((tok_nextstate_ & 64) == 0) {
                  tok_tokenstart_ = tok_cursor_;
                }
                tok_state_ = (tok_nextstate_ & 63);
                tok_cursor_ = tok_cursor_ + 1;
              }
              else {
                break loop000;
              }
            }
          }
          tok_stellalogicalstatename_ = ((Keyword)(tok_stellalogicalstatenames_[tok_state_]));
        }
        if (tok_endoftokensP_) {
          return (false);
        }
        { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tok_statenames_[tok_state_]));

          if ((testValue000 == Stella.KWD_QUALIFIED_SYMBOL) ||
              ((testValue000 == Stella.KWD_QUALIFIED_FULLY_ESCAPED_SYMBOL) ||
               ((testValue000 == Stella.KWD_QUALIFIED_ESCAPED_SYMBOL) ||
                ((testValue000 == Stella.KWD_QUALIFIED_SURROGATE) ||
                 ((testValue000 == Stella.KWD_QUALIFIED_FULLY_ESCAPED_SURROGATE) ||
                  (testValue000 == Stella.KWD_QUALIFIED_ESCAPED_SURROGATE)))))) {
            return (true);
          }
          else if (testValue000 == Stella.KWD_QUALIFIED_NAME) {
            return (!Stella.stringEqlP(name, "/"));
          }
          else {
            return (false);
          }
        }
      }
    }
  }

  /** Convert an integer <code>value</code> string into an integer.  Leading and trailing
   * whitespace is allowed.  Raise an error if we have illegal number syntax which makes it
   * preferable over the naive C++ stringToInteger conversion function which just returns 0.
   * @param value
   * @return int
   */
  public static int parseInteger(String value) {
    { TokenizerTable tok_table_ = Stella.$STELLA_TOKENIZER_TABLE$;
      String tok_transitions_ = tok_table_.transitions;
      edu.isi.stella.Stella_Object[] tok_statenames_ = tok_table_.stateNames.theArray;
      int tok_tokenstart_ = -1;
      boolean tok_endoftokensP_ = false;
      TokenizerStreamState tok_streamstate_ = null;
      char[] tok_buffer_ = value.toCharArray();
      int tok_state_ = 1;
      int tok_nextstate_ = tok_state_;
      int tok_cursor_ = 0;
      int tok_size_ = value.length();
      int tok_end_ = tok_size_;

      {
        tok_statenames_ = tok_statenames_;
        tok_endoftokensP_ = tok_endoftokensP_;
      }
      tok_streamstate_ = tok_streamstate_;
      { edu.isi.stella.Stella_Object[] tok_stellalogicalstatenames_ = Stella.$STELLA_LOGICAL_STATE_NAMES$.theArray;
        Keyword tok_stellalogicalstatename_ = null;

        {
          {
            tok_tokenstart_ = -1;
            loop000 : for (;;) {
              if (tok_cursor_ == tok_end_) {
                if (tok_nextstate_ == -1) {
                  tok_endoftokensP_ = true;
                }
                else if (BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)((tok_table_.legalEofStates.theArray)[tok_state_])))) {
                  tok_nextstate_ = -1;
                  if (tok_tokenstart_ == -1) {
                    tok_endoftokensP_ = true;
                  }
                }
                else {
                  tok_state_ = 0;
                  tok_nextstate_ = -1;
                }
                break loop000;
              }
              tok_nextstate_ = (int) (tok_buffer_[tok_cursor_]);
              tok_nextstate_ = (int) (tok_transitions_.charAt(((((tok_state_ << 8)) | tok_nextstate_))));
              if ((tok_nextstate_ & 128) == 0) {
                tok_state_ = tok_nextstate_;
                tok_cursor_ = tok_cursor_ + 1;
              }
              else if (tok_tokenstart_ == -1) {
                if ((tok_nextstate_ & 64) == 0) {
                  tok_tokenstart_ = tok_cursor_;
                }
                tok_state_ = (tok_nextstate_ & 63);
                tok_cursor_ = tok_cursor_ + 1;
              }
              else {
                break loop000;
              }
            }
          }
          tok_stellalogicalstatename_ = ((Keyword)(tok_stellalogicalstatenames_[tok_state_]));
        }
        if (tok_endoftokensP_) {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("There is no integer in this string: `" + value + "'");
            throw ((ReadException)(ReadException.newReadException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
        if (tok_stellalogicalstatename_ == Stella.KWD_INTEGER) {
          return (Stella.getTokenIntegerInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_));
        }
        else {
          { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

            stream001.nativeStream.print("Illegal integer syntax: `" + value + "'");
            throw ((ReadException)(ReadException.newReadException(stream001.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  /** Convert a long integer <code>value</code> string into a long integer.  Leading and
   * trailing whitespace is allowed.  Raise an error if we have illegal number syntax which makes it
   * preferable over the naive C++ stringToInteger conversion function which just returns 0.
   * @param value
   * @return long
   */
  public static long parseLongInteger(String value) {
    { TokenizerTable tok_table_ = Stella.$STELLA_TOKENIZER_TABLE$;
      String tok_transitions_ = tok_table_.transitions;
      edu.isi.stella.Stella_Object[] tok_statenames_ = tok_table_.stateNames.theArray;
      int tok_tokenstart_ = -1;
      boolean tok_endoftokensP_ = false;
      TokenizerStreamState tok_streamstate_ = null;
      char[] tok_buffer_ = value.toCharArray();
      int tok_state_ = 1;
      int tok_nextstate_ = tok_state_;
      int tok_cursor_ = 0;
      int tok_size_ = value.length();
      int tok_end_ = tok_size_;

      {
        tok_statenames_ = tok_statenames_;
        tok_endoftokensP_ = tok_endoftokensP_;
      }
      tok_streamstate_ = tok_streamstate_;
      { edu.isi.stella.Stella_Object[] tok_stellalogicalstatenames_ = Stella.$STELLA_LOGICAL_STATE_NAMES$.theArray;
        Keyword tok_stellalogicalstatename_ = null;

        {
          {
            tok_tokenstart_ = -1;
            loop000 : for (;;) {
              if (tok_cursor_ == tok_end_) {
                if (tok_nextstate_ == -1) {
                  tok_endoftokensP_ = true;
                }
                else if (BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)((tok_table_.legalEofStates.theArray)[tok_state_])))) {
                  tok_nextstate_ = -1;
                  if (tok_tokenstart_ == -1) {
                    tok_endoftokensP_ = true;
                  }
                }
                else {
                  tok_state_ = 0;
                  tok_nextstate_ = -1;
                }
                break loop000;
              }
              tok_nextstate_ = (int) (tok_buffer_[tok_cursor_]);
              tok_nextstate_ = (int) (tok_transitions_.charAt(((((tok_state_ << 8)) | tok_nextstate_))));
              if ((tok_nextstate_ & 128) == 0) {
                tok_state_ = tok_nextstate_;
                tok_cursor_ = tok_cursor_ + 1;
              }
              else if (tok_tokenstart_ == -1) {
                if ((tok_nextstate_ & 64) == 0) {
                  tok_tokenstart_ = tok_cursor_;
                }
                tok_state_ = (tok_nextstate_ & 63);
                tok_cursor_ = tok_cursor_ + 1;
              }
              else {
                break loop000;
              }
            }
          }
          tok_stellalogicalstatename_ = ((Keyword)(tok_stellalogicalstatenames_[tok_state_]));
        }
        if (tok_endoftokensP_) {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("There is no integer in this string: `" + value + "'");
            throw ((ReadException)(ReadException.newReadException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
        if (tok_stellalogicalstatename_ == Stella.KWD_INTEGER) {
          return (Stella.getTokenLongIntegerInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_));
        }
        else {
          { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

            stream001.nativeStream.print("Illegal integer syntax: `" + value + "'");
            throw ((ReadException)(ReadException.newReadException(stream001.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  /** Convert a float <code>value</code> string into a float.  Leading and trailing
   * whitespace is allowed.  Raise an error if we have illegal number syntax which makes it
   * preferable over the naive C++ stringToFloat conversion function which just returns 0.
   * @param value
   * @return double
   */
  public static double parseFloat(String value) {
    { TokenizerTable tok_table_ = Stella.$STELLA_TOKENIZER_TABLE$;
      String tok_transitions_ = tok_table_.transitions;
      edu.isi.stella.Stella_Object[] tok_statenames_ = tok_table_.stateNames.theArray;
      int tok_tokenstart_ = -1;
      boolean tok_endoftokensP_ = false;
      TokenizerStreamState tok_streamstate_ = null;
      char[] tok_buffer_ = value.toCharArray();
      int tok_state_ = 1;
      int tok_nextstate_ = tok_state_;
      int tok_cursor_ = 0;
      int tok_size_ = value.length();
      int tok_end_ = tok_size_;

      {
        tok_statenames_ = tok_statenames_;
        tok_endoftokensP_ = tok_endoftokensP_;
      }
      tok_streamstate_ = tok_streamstate_;
      { edu.isi.stella.Stella_Object[] tok_stellalogicalstatenames_ = Stella.$STELLA_LOGICAL_STATE_NAMES$.theArray;
        Keyword tok_stellalogicalstatename_ = null;

        {
          {
            tok_tokenstart_ = -1;
            loop000 : for (;;) {
              if (tok_cursor_ == tok_end_) {
                if (tok_nextstate_ == -1) {
                  tok_endoftokensP_ = true;
                }
                else if (BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)((tok_table_.legalEofStates.theArray)[tok_state_])))) {
                  tok_nextstate_ = -1;
                  if (tok_tokenstart_ == -1) {
                    tok_endoftokensP_ = true;
                  }
                }
                else {
                  tok_state_ = 0;
                  tok_nextstate_ = -1;
                }
                break loop000;
              }
              tok_nextstate_ = (int) (tok_buffer_[tok_cursor_]);
              tok_nextstate_ = (int) (tok_transitions_.charAt(((((tok_state_ << 8)) | tok_nextstate_))));
              if ((tok_nextstate_ & 128) == 0) {
                tok_state_ = tok_nextstate_;
                tok_cursor_ = tok_cursor_ + 1;
              }
              else if (tok_tokenstart_ == -1) {
                if ((tok_nextstate_ & 64) == 0) {
                  tok_tokenstart_ = tok_cursor_;
                }
                tok_state_ = (tok_nextstate_ & 63);
                tok_cursor_ = tok_cursor_ + 1;
              }
              else {
                break loop000;
              }
            }
          }
          tok_stellalogicalstatename_ = ((Keyword)(tok_stellalogicalstatenames_[tok_state_]));
        }
        if (tok_endoftokensP_) {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("There is no float in this string: `" + value + "'");
            throw ((ReadException)(ReadException.newReadException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
        if ((tok_stellalogicalstatename_ == Stella.KWD_INTEGER) ||
            (tok_stellalogicalstatename_ == Stella.KWD_FLOAT)) {
          return (Stella.getTokenFloatInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_));
        }
        else {
          { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

            stream001.nativeStream.print("Illegal float syntax: `" + value + "'");
            throw ((ReadException)(ReadException.newReadException(stream001.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  public static char stringToCharacter(String name) {
    { char renamed_Char = name.charAt(0);

      if (name.length() > 1) {
        if (Stella.stringEqlP(name, "SPACE")) {
          renamed_Char = ' ';
        }
        else if (Stella.stringEqlP(name, "LINEFEED")) {
          renamed_Char = '\n';
        }
        else if (Stella.stringEqlP(name, "NEWLINE")) {
          renamed_Char = '\n';
        }
        else if (Stella.stringEqlP(name, "BACKSPACE")) {
          renamed_Char = '\b';
        }
        else if (Stella.stringEqlP(name, "TAB")) {
          renamed_Char = '\t';
        }
        else if (Stella.stringEqlP(name, "RETURN")) {
          renamed_Char = '\r';
        }
        else if (Stella.stringEqlP(name, "PAGE")) {
          renamed_Char = '\f';
        }
        else if (Stella.stringEqlP(name, "NULL")) {
          renamed_Char = ' ';
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("Illegal character constant: `" + ("#\\" + name) + "'");
            throw ((ReadException)(ReadException.newReadException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      return (renamed_Char);
    }
  }

  public static Vector createTokenizeStringTable(String punctuationchars, String quotechars, String escapechars) {
    { Vector chartypetable = Vector.newVector(256);

      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = chartypetable.length() - 1;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          if (Stella.$CHARACTER_TYPE_TABLE$[(int) ((char) i)] == Stella.KWD_WHITE_SPACE) {
            (chartypetable.theArray)[i] = Stella.KWD_WHITE_SPACE;
          }
          else {
            (chartypetable.theArray)[i] = Stella.KWD_TEXT;
          }
        }
      }
      { char ch = Stella.NULL_CHARACTER;
        String vector000 = punctuationchars;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          ch = vector000.charAt(index000);
          (chartypetable.theArray)[((int) ch)] = Stella.KWD_PUNCTUATION;
        }
      }
      { char ch = Stella.NULL_CHARACTER;
        String vector001 = quotechars;
        int index001 = 0;
        int length001 = vector001.length();

        for (;index001 < length001; index001 = index001 + 1) {
          ch = vector001.charAt(index001);
          (chartypetable.theArray)[((int) ch)] = Stella.KWD_QUOTE;
        }
      }
      { char ch = Stella.NULL_CHARACTER;
        String vector002 = escapechars;
        int index002 = 0;
        int length002 = vector002.length();

        for (;index002 < length002; index002 = index002 + 1) {
          ch = vector002.charAt(index002);
          (chartypetable.theArray)[((int) ch)] = Stella.KWD_ESCAPE;
        }
      }
      return (chartypetable);
    }
  }

  /** Simple tokenizer that is somewhere between Java's StringTokenizer
   * and StreamTokenizer in functionality.  It doens't specially support number
   * tokens nor comment strings/sequences even though this could be added at
   * the expense of some extra complexity.
   * Returns a list of (&lt;token-string&gt; &lt;token-type&gt;) pairs, where the token
   * type is one of :TEXT, :PUNCTUATION or :QUOTE, i.e., all white space
   * is ignored and escape characters are handled and removed.  For example:
   * 	 
   *   (tokenize-string &quot;for(i='fo^'o'; i&gt;0; i++)&quot; &quot;()=&lt;&gt;+-;&quot; &quot;'&quot; &quot;^&quot;)
   *   =&gt;
   *   ((&quot;for&quot; :TEXT) (&quot;(&quot; :PUNCTUATION) (&quot;i&quot; :TEXT)
   *    (&quot;=&quot; :PUNCTUATION) (&quot;'&quot; :QUOTE) (&quot;fo'o&quot; :TEXT)
   *    (&quot;'&quot; :QUOTE) (&quot;;&quot; :PUNCTUATION) (&quot;i&quot; :TEXT)
   *    (&quot;&gt;&quot; :PUNCTUATION) (&quot;0&quot; :TEXT) (&quot;;&quot; :PUNCTUATION)
   *    (&quot;i&quot; :TEXT) (&quot;++)&quot; :PUNCTUATION))
   * 	
   * NOTE: this aggregates multiple punctuation characters that immediately
   * follow each other into a single token which is (generally) useful to pickup
   * multi-character operators such as ++, &gt;=, etc.  It's still easy to pick them
   * apart in a post-processing step if necessary (e.g., for the <code>II_</code> case above),
   * so we leave this for now as a feature.
   * @param string
   * @param punctuationchars
   * @param quotechars
   * @param escapechars
   * @return Cons
   */
  public static Cons tokenizeString(String string, String punctuationchars, String quotechars, String escapechars) {
    { MemoizationTable memoTable000 = null;
      Cons memoizedEntry000 = null;
      Stella_Object memoizedValue000 = null;

      if (Stella.$MEMOIZATION_ENABLEDp$) {
        memoTable000 = ((MemoizationTable)(Stella.SGT_STELLA_F_TOKENIZE_STRING_MEMO_TABLE_000.surrogateValue));
        if (memoTable000 == null) {
          Surrogate.initializeMemoizationTable(Stella.SGT_STELLA_F_TOKENIZE_STRING_MEMO_TABLE_000, "(:MAX-VALUES 10)");
          memoTable000 = ((MemoizationTable)(Stella.SGT_STELLA_F_TOKENIZE_STRING_MEMO_TABLE_000.surrogateValue));
        }
        memoizedEntry000 = MruMemoizationTable.lookupMruMemoizedValue(((MruMemoizationTable)(memoTable000)), StringWrapper.wrapString(punctuationchars), StringWrapper.wrapString(quotechars), StringWrapper.wrapString(escapechars), Stella.MEMOIZED_NULL_VALUE, 0);
        memoizedValue000 = memoizedEntry000.value;
      }
      if (memoizedValue000 != null) {
        if (memoizedValue000 == Stella.MEMOIZED_NULL_VALUE) {
          memoizedValue000 = null;
        }
      }
      else {
        memoizedValue000 = Stella.createTokenizeStringTable(punctuationchars, quotechars, escapechars);
        if (Stella.$MEMOIZATION_ENABLEDp$) {
          memoizedEntry000.value = ((memoizedValue000 == null) ? Stella.MEMOIZED_NULL_VALUE : memoizedValue000);
        }
      }
      { Vector chartypetable = ((Vector)(memoizedValue000));
        int i = 0;
        char ch = Stella.NULL_CHARACTER;
        int start = 0;
        int end = string.length();
        Keyword state = Stella.KWD_TEXT;
        Keyword newstate = Stella.KWD_TEXT;
        boolean quotedtokenP = false;
        char quotechar = Stella.NULL_CHARACTER;
        boolean endoftokenP = false;
        Cons escapepositions = Stella.NIL;
        String token = null;
        Cons result = Stella.NIL;

        loop000 : for (;;) {
          endoftokenP = false;
          if (i < end) {
            ch = string.charAt(i);
            newstate = ((Keyword)((chartypetable.theArray)[((int) ch)]));
            if (newstate == Stella.KWD_TEXT) {
              if ((state == Stella.KWD_PUNCTUATION) ||
                  ((state == Stella.KWD_WHITE_SPACE) ||
                   (state == Stella.KWD_QUOTE))) {
                endoftokenP = true;
              }
              else {
              }
            }
            else if (newstate == Stella.KWD_ESCAPE) {
              if ((state == Stella.KWD_PUNCTUATION) ||
                  ((state == Stella.KWD_WHITE_SPACE) ||
                   (state == Stella.KWD_QUOTE))) {
                endoftokenP = true;
              }
              else {
              }
              escapepositions = Cons.cons(IntegerWrapper.wrapInteger(i), escapepositions);
              i = i + 2;
              continue loop000;
            }
            else if (newstate == Stella.KWD_QUOTE) {
              if (quotedtokenP &&
                  (ch == quotechar)) {
                endoftokenP = true;
                quotedtokenP = false;
              }
              else if (quotedtokenP) {
                newstate = Stella.KWD_TEXT;
              }
              else {
                endoftokenP = true;
                quotedtokenP = true;
                quotechar = ch;
              }
            }
            else if (newstate == Stella.KWD_PUNCTUATION) {
              if (state == Stella.KWD_TEXT) {
                if (quotedtokenP) {
                  newstate = Stella.KWD_TEXT;
                }
                else {
                  endoftokenP = true;
                }
              }
              else if ((state == Stella.KWD_WHITE_SPACE) ||
                  (state == Stella.KWD_QUOTE)) {
                endoftokenP = true;
              }
              else {
              }
            }
            else if (newstate == Stella.KWD_WHITE_SPACE) {
              if (state == Stella.KWD_TEXT) {
                if (quotedtokenP) {
                  newstate = Stella.KWD_TEXT;
                }
                else {
                  endoftokenP = true;
                }
              }
              else if ((state == Stella.KWD_PUNCTUATION) ||
                  (state == Stella.KWD_QUOTE)) {
                endoftokenP = true;
              }
              else {
              }
            }
            else {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("`" + newstate + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
          }
          if ((endoftokenP &&
              (i > 0)) ||
              (i >= end)) {
            if (!(state == Stella.KWD_WHITE_SPACE)) {
              if (!(escapepositions == Stella.NIL)) {
                { Cons parts = Stella.NIL;
                  int s = start;

                  { IntegerWrapper e = null;
                    Cons iter000 = escapepositions.reverse();

                    for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                      e = ((IntegerWrapper)(iter000.value));
                      parts = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(string, s, e.wrapperValue)), parts);
                      s = e.wrapperValue + 1;
                    }
                  }
                  parts = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(string, Stella.integer_min(s, end), Stella.integer_min(i, end))), parts);
                  parts = parts.reverse();
                  token = Native.stringConcatenate(((StringWrapper)(parts.value)).wrapperValue, ((StringWrapper)(parts.rest.value)).wrapperValue);
                  { StringWrapper part = null;
                    Cons iter001 = parts.rest.rest;

                    for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                      part = ((StringWrapper)(iter001.value));
                      token = Native.stringConcatenate(token, part.wrapperValue);
                    }
                  }
                }
                escapepositions = Stella.NIL;
              }
              else {
                token = Native.string_subsequence(string, start, i);
              }
              result = Cons.cons(Cons.cons(StringWrapper.wrapString(token), Cons.cons(state, Stella.NIL)), result);
            }
            if (i >= end) {
              break loop000;
            }
            start = i;
          }
          state = newstate;
          i = i + 1;
        }
        return (result.reverse());
      }
    }
  }

  /** Read one STELLA s-expression from <code>string</code> and
   * return the result.
   * @param string
   * @return Stella_Object
   */
  public static Stella_Object readSExpressionFromString(String string) {
    return (InputStream.readSExpression(Stella.makeTokenizerStringStream(string), new Object[1]));
  }

  public static InputStringStream makeTokenizerStringStream(String string) {
    { InputStringStream stream = InputStringStream.newInputStringStream(string);
      TokenizerStreamState state = new TokenizerStreamState();
      int length = string.length() + 1;

      state.buffer = new char[length];
      state.bufferSize = length;
      state.cursor = length;
      state.end = length;
      state.state = 1;
      state.table = null;
      state.stateDictionary = null;
      state.tokenList = StellaToken.newStellaToken();
      stream.tokenizerState = state;
      return (stream);
    }
  }

  /** Unread <code>ch</code> from <code>inputstream</code>.  Signal an error if <code>ch</code>
   * was not the last character read.
   * @param ch
   * @param inputstream
   */
  public static void unreadCharacter(char ch, InputStream inputstream) {
    if (inputstream.tokenizerState != null) {
      Stella.unreadCharacterFromTokenizerBuffer(ch, inputstream);
    }
    else {
      { edu.isi.stella.javalib.NativeInputStream stream = inputstream.nativeStream;

        Native.unreadCharacter(ch, stream);
      }
    }
  }

  /** Read a line of input from STANDARD-INPUT and return <code>true</code>
   * if the input was <code>yes</code> or <code>false</code> if the input was <code>no</code>.  Loop until either
   * <code>yes</code> or <code>no</code> was entered.  If 'message' is non-<code>null</code> prompt with it before
   * the input is read.  See also special variable <code>$USER_QUERY_ACTION$</code>.
   * @param message
   * @return boolean
   */
  public static boolean yesOrNoP(String message) {
    if (((Keyword)(Stella.$USER_QUERY_ACTION$.get())) == Stella.KWD_YES) {
      return (true);
    }
    else if (((Keyword)(Stella.$USER_QUERY_ACTION$.get())) == Stella.KWD_NO) {
      return (false);
    }
    else if (((Keyword)(Stella.$USER_QUERY_ACTION$.get())) == Stella.KWD_YES_VERBOSE) {
      Stella.STANDARD_OUTPUT.nativeStream.println(message + " [Auto => YES]");
      return (true);
    }
    else if (((Keyword)(Stella.$USER_QUERY_ACTION$.get())) == Stella.KWD_NO_VERBOSE) {
      Stella.STANDARD_OUTPUT.nativeStream.println(message + " [Auto => NO]");
      return (false);
    }
    else if (((Keyword)(Stella.$USER_QUERY_ACTION$.get())) == Stella.KWD_ASK) {
      { String input = null;
        int start = 0;

        for (;;) {
          if (message != null) {
            Stella.STANDARD_OUTPUT.nativeStream.print(message);
          }
          input = InputStream.readLine(Stella.STANDARD_INPUT);
          start = 0;
          { char ch = Stella.NULL_CHARACTER;
            String vector000 = input;
            int index000 = 0;
            int length000 = vector000.length();

            loop001 : for (;index000 < length000; index000 = index000 + 1) {
              ch = vector000.charAt(index000);
              if (Stella.$CHARACTER_TYPE_TABLE$[(int) ch] == Stella.KWD_WHITE_SPACE) {
                start = start + 1;
              }
              else {
                break loop001;
              }
            }
          }
          if (input.length() > start) {
            input = Native.string_subsequence(input, start, Stella.NULL_INTEGER);
            if (Stella.stringEqualP(input, "yes")) {
              return (true);
            }
            if (Stella.stringEqualP(input, "no")) {
              return (false);
            }
            Stella.STANDARD_OUTPUT.nativeStream.println("Type `yes' for yes or `no' for no.");
          }
        }
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + ((Keyword)(Stella.$USER_QUERY_ACTION$.get())) + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  /** Read a line of input from STANDARD-INPUT and return <code>true</code>
   * if the input was <code>y</code> or <code>false</code> if the input was <code>n</code>.  Loop until either
   * <code>y</code> or <code>n</code> was entered.  If 'message' is non-<code>null</code> prompt with it before
   * the input is read.  See also special variable <code>$USER_QUERY_ACTION$</code>.
   * @param message
   * @return boolean
   */
  public static boolean yOrNP(String message) {
    if (((Keyword)(Stella.$USER_QUERY_ACTION$.get())) == Stella.KWD_YES) {
      return (true);
    }
    else if (((Keyword)(Stella.$USER_QUERY_ACTION$.get())) == Stella.KWD_NO) {
      return (false);
    }
    else if (((Keyword)(Stella.$USER_QUERY_ACTION$.get())) == Stella.KWD_YES_VERBOSE) {
      Stella.STANDARD_OUTPUT.nativeStream.println(message + " [Auto => Y]");
      return (true);
    }
    else if (((Keyword)(Stella.$USER_QUERY_ACTION$.get())) == Stella.KWD_NO_VERBOSE) {
      Stella.STANDARD_OUTPUT.nativeStream.println(message + " [Auto => N]");
      return (false);
    }
    else if (((Keyword)(Stella.$USER_QUERY_ACTION$.get())) == Stella.KWD_ASK) {
      { String input = null;
        int start = 0;

        for (;;) {
          if (message != null) {
            Stella.STANDARD_OUTPUT.nativeStream.print(message);
          }
          input = InputStream.readLine(Stella.STANDARD_INPUT);
          start = 0;
          { char ch = Stella.NULL_CHARACTER;
            String vector000 = input;
            int index000 = 0;
            int length000 = vector000.length();

            loop001 : for (;index000 < length000; index000 = index000 + 1) {
              ch = vector000.charAt(index000);
              if (Stella.$CHARACTER_TYPE_TABLE$[(int) ch] == Stella.KWD_WHITE_SPACE) {
                start = start + 1;
              }
              else {
                break loop001;
              }
            }
          }
          if (input.length() > start) {
            switch (input.charAt(start)) {
              case 'y': 
              case 'Y': 
                return (true);
              case 'n': 
              case 'N': 
                return (false);
              default:
              break;
            }
          }
          Stella.STANDARD_OUTPUT.nativeStream.println("Type `y' for yes or `n' for no.");
        }
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + ((Keyword)(Stella.$USER_QUERY_ACTION$.get())) + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  /** Read the content of <code>file</code> and return it as a string.
   * @param file
   * @return String
   */
  public static String fileToString(String file) {
    { InputFileStream in = null;

      try {
        in = Stella.openInputFile(file, Stella.NIL);
        return (in.streamToString());

      } finally {
        if (in != null) {
          in.free();
        }
      }
    }
  }

  /** Resets Hashtables used for interning XML elements and global
   * attribute objects.  This will allow garbage collection of no-longer used
   * objects, but will also mean that newly parsed xml elements and global attributes
   * will not be eq? to already existing ones with the same name.
   */
  public static void resetXmlHashTables() {
    Stella.$XML_ELEMENT_NULL_NAMESPACE_TABLE$ = StringHashTable.newStringHashTable();
    Stella.$XML_ELEMENT_HASH_TABLE$ = StringHashTable.newStringHashTable();
    Stella.$XML_GLOBAL_ATTRIBUTE_HASH_TABLE$ = StringHashTable.newStringHashTable();
  }

  public static KvCons makeNamespaceTable() {
    return (KvCons.kvCons(StringWrapper.wrapString("xml"), StringWrapper.wrapString(Stella.$XML_URN$), null));
  }

  public static Cons makeXmlCdataForm(String theData) {
    { XmlSpecial self000 = XmlSpecial.newXmlSpecial();

      self000.name = "CDATA";
      self000.surfaceForm = "CDATA";
      { XmlSpecial tag = self000;

        return (Cons.cons(tag, Cons.cons(Cons.cons(StringWrapper.wrapString(theData), Stella.NIL), Stella.NIL)));
      }
    }
  }

  public static XmlAttribute makeXmlnsAttribute(String name) {
    { int colonPosition = Native.string_position(name, ':', 0);

      if (colonPosition == Stella.NULL_INTEGER) {
        { XmlGlobalAttribute self000 = XmlGlobalAttribute.newXmlGlobalAttribute();

          self000.name = "";
          self000.namespaceName = "xmlns";
          self000.surfaceForm = name;
          { XmlGlobalAttribute value000 = self000;

            return (value000);
          }
        }
      }
      else {
        { XmlGlobalAttribute self001 = XmlGlobalAttribute.newXmlGlobalAttribute();

          self001.name = Native.string_subsequence(name, colonPosition + 1, Stella.NULL_INTEGER);
          self001.namespaceName = "xmlns";
          self001.surfaceForm = name;
          { XmlGlobalAttribute value001 = self001;

            return (value001);
          }
        }
      }
    }
  }

  public static XmlElement makeXmlElementInternal(String name, String namespaceName, String namespace, String surfaceForm) {
    { StringHashTable nsHashTable = null;
      XmlElement element = null;

      if (namespace != null) {
        nsHashTable = ((StringHashTable)(Stella.$XML_ELEMENT_HASH_TABLE$.lookup(namespace)));
        if (nsHashTable == null) {
          nsHashTable = StringHashTable.newStringHashTable();
          Stella.$XML_ELEMENT_HASH_TABLE$.insertAt(namespace, nsHashTable);
        }
      }
      else {
        nsHashTable = Stella.$XML_ELEMENT_NULL_NAMESPACE_TABLE$;
      }
      element = ((XmlElement)(nsHashTable.lookup(name)));
      if (element == null) {
        { XmlElement self001 = XmlElement.newXmlElement();

          self001.name = name;
          self001.namespaceName = namespaceName;
          self001.namespaceUri = namespace;
          self001.surfaceForm = surfaceForm;
          self001.elementDictionary = KeyValueList.newKeyValueList();
          element = self001;
        }
        nsHashTable.insertAt(name, element);
      }
      return (element);
    }
  }

  /** Creates and interns an XML element object <code>name</code> using <code>namespaceName</code>
   * to refer to  <code>namespace</code>.  If <code>namespace</code> is <code>null</code>, then the element will
   * be interned in the null namespace.   <code>namespace</code> must otherwise be a URI.
   * @param name
   * @param namespaceName
   * @param namespace
   * @return XmlElement
   */
  public static XmlElement makeXmlElement(String name, String namespaceName, String namespace) {
    if ((namespaceName == null) ||
        Stella.stringEqlP(namespaceName, "")) {
      return (Stella.makeXmlElementInternal(name, "", namespace, name));
    }
    else {
      return (Stella.makeXmlElementInternal(name, namespaceName, namespace, namespaceName + ":" + name));
    }
  }

  public static XmlElement makeXmlElementRespectingNamespace(String name, KvCons namespaceTable) {
    { int colonPosition = Native.string_position(name, ':', 0);
      String nsPart = "";
      String rawName = "";
      String namespaceUri = null;

      if (colonPosition == Stella.NULL_INTEGER) {
        rawName = name;
      }
      else {
        {
          nsPart = Native.string_subsequence(name, 0, colonPosition);
          rawName = Native.string_subsequence(name, colonPosition + 1, Stella.NULL_INTEGER);
        }
      }
      namespaceUri = StringWrapper.unwrapString(((StringWrapper)(namespaceTable.lookup(StringWrapper.wrapString(nsPart)))));
      if ((namespaceUri == null) &&
          (!Stella.stringEqlP(nsPart, ""))) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Undefined Namespace for Element: `" + nsPart + "'");
          throw ((BadArgumentException)(BadArgumentException.newBadArgumentException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      return (Stella.makeXmlElementInternal(rawName, nsPart, namespaceUri, name));
    }
  }

  public static XmlGlobalAttribute makeXmlGlobalAttributeInternal(String name, String namespaceName, String namespaceUri, String surfaceForm) {
    if ((namespaceUri == null) ||
        ((namespaceName == null) ||
         (Stella.stringEqlP(namespaceUri, "") ||
          Stella.stringEqlP(namespaceName, "")))) {
      throw ((BadArgumentException)(BadArgumentException.newBadArgumentException("namespace-name and namespace must be specified").fillInStackTrace()));
    }
    { StringHashTable nsHashTable = ((StringHashTable)(Stella.$XML_GLOBAL_ATTRIBUTE_HASH_TABLE$.lookup(namespaceUri)));
      XmlAttribute attribute = null;

      if (nsHashTable == null) {
        nsHashTable = StringHashTable.newStringHashTable();
        Stella.$XML_GLOBAL_ATTRIBUTE_HASH_TABLE$.insertAt(namespaceUri, nsHashTable);
      }
      attribute = ((XmlAttribute)(nsHashTable.lookup(name)));
      if (attribute == null) {
        { XmlGlobalAttribute self002 = XmlGlobalAttribute.newXmlGlobalAttribute();

          self002.name = name;
          self002.namespaceName = namespaceName;
          self002.namespaceUri = namespaceUri;
          self002.surfaceForm = surfaceForm;
          attribute = self002;
        }
        nsHashTable.insertAt(name, attribute);
      }
      return (((XmlGlobalAttribute)(attribute)));
    }
  }

  /** Creates and interns an XML global attribute object with <code>name</code> using 
   * <code>namespaceName</code> to refer to  <code>namespace</code>.  <code>namespace</code>must be a URI.
   * @param name
   * @param namespaceName
   * @param namespace
   * @return XmlGlobalAttribute
   */
  public static XmlGlobalAttribute makeXmlGlobalAttribute(String name, String namespaceName, String namespace) {
    return (Stella.makeXmlGlobalAttributeInternal(name, namespaceName, namespace, name + ":" + namespaceName));
  }

  public static XmlGlobalAttribute makeXmlGlobalAttributeRespectingNamespace(String name, String namespaceName, String surfaceForm, KvCons namespaceTable) {
    { StringWrapper namespaceUri = ((StringWrapper)(namespaceTable.lookup(StringWrapper.wrapString(namespaceName))));

      if (namespaceUri == null) {
        throw ((BadArgumentException)(BadArgumentException.newBadArgumentException("Undefined Namespace for Attribute!").fillInStackTrace()));
      }
      return (Stella.makeXmlGlobalAttributeInternal(name, namespaceName, namespaceUri.wrapperValue, surfaceForm));
    }
  }

  /** Make an XML-LOCAL-ATTRIBUTE named <code>name</code> associated with <code>element</code>
   * @param name
   * @param element
   * @return XmlLocalAttribute
   */
  public static XmlLocalAttribute makeXmlLocalAttribute(String name, XmlElement element) {
    { KeyValueList dictionary = element.elementDictionary;
      XmlAttribute attribute = ((XmlAttribute)(dictionary.lookup(StringWrapper.wrapString(name))));

      if (attribute == null) {
        { XmlLocalAttribute self000 = XmlLocalAttribute.newXmlLocalAttribute();

          self000.name = name;
          self000.parentElement = element;
          self000.surfaceForm = name;
          attribute = self000;
        }
        element.elementDictionary.insertAt(StringWrapper.wrapString(name), attribute);
      }
      return (((XmlLocalAttribute)(attribute)));
    }
  }

  public static XmlAttribute makeXmlAttributeRespectingNamespace(String name, XmlElement element, KvCons namespaceTable) {
    { int colonPosition = Native.string_position(name, ':', 0);

      if (colonPosition == Stella.NULL_INTEGER) {
        return (Stella.makeXmlLocalAttribute(name, element));
      }
      else {
        return (Stella.makeXmlGlobalAttributeRespectingNamespace(Native.string_subsequence(name, colonPosition + 1, Stella.NULL_INTEGER), Native.string_subsequence(name, 0, colonPosition), name, namespaceTable));
      }
    }
  }

  public static boolean xmlnsAttributeNameP(String name) {
    { int colonPosition = Native.string_position(name, ':', 0);

      if (colonPosition == Stella.NULL_INTEGER) {
        return (Stella.stringEqlP(name, "xmlns"));
      }
      else {
        return (Stella.stringEqlP(Native.string_subsequence(name, 0, colonPosition), "xmlns"));
      }
    }
  }

  public static String extractXmlnsName(String keyname) {
    { int colonPosition = Native.string_position(keyname, ':', 0);

      if (colonPosition == Stella.NULL_INTEGER) {
        return ("");
      }
      else {
        return (Native.string_subsequence(keyname, colonPosition + 1, Stella.NULL_INTEGER));
      }
    }
  }

  public static void addXmlReference(String name, String substitution, KeyValueList table) {
    table.insertAt(StringWrapper.wrapString(name), StringWrapper.wrapString(substitution));
  }

  public static KeyValueList makeXmlEntityTable() {
    { KeyValueList table = KeyValueList.newKeyValueList();

      Stella.addXmlReference("lt", "&#60;", table);
      Stella.addXmlReference("gt", "&#62;", table);
      Stella.addXmlReference("amp", "&#38;", table);
      Stella.addXmlReference("apos", "&#39;", table);
      Stella.addXmlReference("quot", "&#34;", table);
      Stella.addXmlReference("nbsp", "&#160;", table);
      return (table);
    }
  }

  public static String decodeXmlCharRef(String digits) {
    { int n = 0;
      int end = digits.length() - 2;

      if (digits.charAt(2) == 'x') {
        { int i = Stella.NULL_INTEGER;
          int iter000 = 3;
          int upperBound000 = end;
          boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

          for (;unboundedP000 ||
                    (iter000 <= upperBound000); iter000 = iter000 + 1) {
            i = iter000;
            n = (n * 16) + Stella.hexCharacterValue(digits.charAt(i));
          }
        }
      }
      else {
        { int i = Stella.NULL_INTEGER;
          int iter001 = 2;
          int upperBound001 = end;
          boolean unboundedP001 = upperBound001 == Stella.NULL_INTEGER;

          for (;unboundedP001 ||
                    (iter001 <= upperBound001); iter001 = iter001 + 1) {
            i = iter001;
            n = (n * 10) + Stella.digitValue(digits.charAt(i));
          }
        }
      }
      return (Native.makeString(1, (char) n));
    }
  }

  static boolean internalDtdDefinitionP(String definition) {
    return ((definition.charAt(0) == '[') &&
        (definition.charAt((definition.length() - 1)) == ']'));
  }

  public static int findReferenceStart(String input, int start, int end) {
    if (end == Stella.NULL_INTEGER) {
      end = input.length() - 1;
    }
    { int i = Stella.NULL_INTEGER;
      int iter000 = start;
      int upperBound000 = end;
      boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

      for (;unboundedP000 ||
                (iter000 <= upperBound000); iter000 = iter000 + 1) {
        i = iter000;
        if ((input.charAt(i) == '&') ||
            (input.charAt(i) == '%')) {
          return (i);
        }
      }
    }
    return (Stella.NULL_INTEGER);
  }

  public static TokenizerTable getXmlWhitespacePreservingTokenizerTable() {
    if (Stella.$XML_WHITESPACE_PRESERVING_TOKENIZER_TABLE$ == null) {
      { Cons tokenizerdefinition = ((Cons)(Stella_Object.copyConsTree(Stella.$XML_TOKENIZER_TABLE_DEFINITION$)));

        tokenizerdefinition.secondSetter(Cons.list$(Cons.cons(Stella.KWD_SKIP_WHITESPACE, Cons.cons(Stella.SYM_STELLA_x, Cons.cons(StringWrapper.wrapString("<"), Cons.cons(Stella.KWD_OPEN_TAG, Cons.cons(Stella.KWD_EOF, Cons.cons(Stella.KWD_EOF, Cons.cons(Stella.SYM_STELLA_$, Cons.cons(Stella.KWD_OTHERWISE, Cons.cons(Stella.KWD_CONTENT, Cons.cons(Stella.NIL, Stella.NIL))))))))))));
        Stella.$XML_WHITESPACE_PRESERVING_TOKENIZER_TABLE$ = Cons.parseTokenizerDefinition(tokenizerdefinition);
      }
    }
    return (Stella.$XML_WHITESPACE_PRESERVING_TOKENIZER_TABLE$);
  }

  public static TokenizerTable getXmlTokenizerTable() {
    if (((Boolean)(Stella.$XML_PRESERVE_ALL_WHITESPACEp$.get())).booleanValue()) {
      return (Stella.getXmlWhitespacePreservingTokenizerTable());
    }
    else {
      return (Stella.$XML_TOKENIZER_TABLE$);
    }
  }

  /** Read all of the top-level XML expressions from <code>filename</code> and
   * return them in a list.
   * @param filename
   * @return Cons
   */
  public static Cons readXmlExpressions(String filename) {
    { InputFileStream in = null;

      try {
        in = Stella.openInputFile(filename, Stella.NIL);
        { Cons value000 = Stella.NIL;

          { Stella_Object item = null;
            XmlExpressionIterator iter000 = InputStream.xmlExpressions(in, null);
            Cons collect000 = null;

            while (iter000.nextP()) {
              item = iter000.value;
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(item, Stella.NIL);
                  if (value000 == Stella.NIL) {
                    value000 = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(value000, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(item, Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
          { Cons value001 = value000;

            return (value001);
          }
        }

      } finally {
        if (in != null) {
          in.free();
        }
      }
    }
  }

  /** Enable memoization and use of memoized expression results.
   */
  public static void enableMemoization() {
    Stella.$MEMOIZATION_ENABLEDp$ = true;
  }

  /** Enable memoization and use of memoized expression results.
   */
  public static void disableMemoization() {
    Stella.$MEMOIZATION_ENABLEDp$ = false;
  }

  public static void clearAllMemoizationTables() {
    { MemoizationTable table = null;
      Cons iter000 = Stella.$ALL_MEMOIZATION_TABLES$.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        table = ((MemoizationTable)(iter000.value));
        table.tableName.surrogateValue = null;
      }
    }
    Stella.$ALL_MEMOIZATION_TABLES$.clear();
  }

  /** Return the demon named <code>name</code>.
   * @param name
   * @return Demon
   */
  public static Demon lookupDemon(String name) {
    return (((Demon)(Stella.$DEMONS_TABLE$.lookup(name))));
  }

  /** Define a class or slot demon.  Options are :create,
   * :destroy, :class, :slot, :guard?, :code, :method, :inherit?, and :documentation.
   * @param name
   * @param options
   * @return Demon
   */
  public static Demon defineDemon(String name, Cons options) {
    { Demon demon = Demon.newDemon();
      PropertyList plist = PropertyList.newPropertyList();
      Cons conslist = Stella.NIL;
      Demon olddemon = null;
      boolean activateP = false;

      { Stella_Object item = null;
        Cons iter000 = options;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          item = iter000.value;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(item, Stella.NIL);
              if (conslist == Stella.NIL) {
                conslist = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(conslist, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(item, Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      plist.thePlist = conslist;
      demon.demonName = name;
      activateP = plist.removeAt(Stella.KWD_ACTIVATEp) == Stella.TRUE_WRAPPER;
      if (Demon.incorporateDemonOptionsP(demon, plist)) {
        { 
          olddemon = Stella.lookupDemon(name);
          if (olddemon != null) {
            Demon.deactivateDemon(olddemon);
            olddemon.free();
          }
        }
        Stella.$DEMONS_TABLE$.insertAt(demon.demonName, demon);
        if (activateP) {
          Demon.activateDemon(demon);
        }
        return (demon);
      }
      demon.free();
      return (null);
    }
  }

  /** Keyword options:
   *   :break-on-cap    one of  :YES :NO :CLEVER         default is :CLEVER
   *   :break-on-number one of  :YES :NO :CLEVER         default is :CLEVER
   *   :break-on-separators string                       default is &quot;-_ &quot;
   *   :remove-prefix   string
   *   :remove-suffix   string
   *   
   *   :case            one of  :UPCASE :TitleCase :titleCaseX :downcase :Capitalize :preserve
   *                                                      default is :TitleCase
   *   :separator       string                            default is &quot;&quot;
   *   :add-prefix      string
   *   :add-suffix      string
   * <p>
   *   MAKE-MATCHING-NAME returns a matching name (a string) for the input name (a string).
   * A matching name is constructed by breaking the input into 'words' and then applying
   * appropriate transforms.  The arguments are used as follows:
   *   <code>original</code>         is the input name.  It is a string.
   *   :break-on-cap    is a keyword controlling whether changes in capitalization is used
   *                    to indicate word boundaries.  If :YES, then all capitalization
   *                    changes delineate words.  If :CLEVER, then unbroken runs of
   *                    capitalized letters are treated as acronyms and remain grouped.
   *                    If :NO or NULL, there is no breaking of words based on capitalization.
   *   :break-on-number is a flag controlling whether encountering a number indicates
   *                    a word boundary.  If :YES, then each run of numbers is treated as
   * 		   a word separate from surrounding words.  If :CLEVER, then an 
   * 		   attempt is made to recognize ordinal numbers (ie, 101st) and
   * 		   treat them as separate words.  If :NO or NULL, there is no breaking
   *                    of words when numbers are encountered.
   *   :break-on-separators   A string of characters which constitute word delimiters in
   *                          the input word.  This is used to determine how to break
   *                    the name into individual words.  Defaults are space, '-' and '_'.
   *   :remove-prefix   Specifies a prefix or suffix that is stripped from the input
   *   :remove-suffix   name before any other processing.  This allows the removal of
   *                    any naming convention dictated prefixes or suffixes.
   *   :add-prefix      Specifies a prefix or suffix that is added to the output name
   *   :add-suffix      after all other processing.  This allows the addition of any
   *                    naming convention dictated prefixes or suffixes.
   *   :case            The case of the resulting name.  This is applied to the name 
   *                    before adding prefixes or suffixes.  The two title case options 
   *                    differ only in how the first word of the name is treated.
   *                    :TitleCase capitalizes the first letter of the first word and
   *                        also the first letter of all other words.
   *                    :TitleCaseX does not capitalizes the first letter of the first
   * 		       word but capitalizes the first letter of all subsequent words.
   * 		   :preserve results in no change in case.
   *   :separator       This is a string specifying the word separator to use in the
   *                    returned name.  An empty string (the default) means that the
   *                    resulting words are concatenated without any separation.  This
   *                    normally only makes sense when using one of the title case values
   *                    for the case keyword.
   * @param original
   * @param options
   * @return String
   */
  public static String makeMatchingName(String original, Cons options) {
    { PropertyList self000 = PropertyList.newPropertyList();

      self000.thePlist = options;
      { PropertyList plist = self000;
        Keyword breakoncap = Stella.KWD_CLEVER;
        Keyword breakonnumber = Stella.KWD_CLEVER;
        String breakonseparators = "-_ ";
        String removeprefix = "";
        String removesuffix = "";
        String addprefix = "";
        String addsuffix = "";
        Keyword outputcase = Stella.KWD_TITLECASE;
        String outputseparator = "";

        Stella_Object.vetOptions(plist, Stella.getQuotedTree("((:BREAK-ON-CAP :BREAK-ON-NUMBER :BREAK-ON-SEPARATORS :REMOVE-PREFIX :REMOVE-SUFFIX :ADD-PREFIX :ADD-SUFFIX :CASE :SEPARATOR) \"/STELLA\")", "/STELLA"));
        { Stella_Object key = null;
          Stella_Object value = null;
          Cons iter000 = plist.thePlist;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
            key = iter000.value;
            value = iter000.rest.value;
            { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(key));

              if (testValue000 == Stella.KWD_BREAK_ON_CAP) {
                if (value != null) {
                  breakoncap = ((Keyword)(value));
                }
                else {
                  breakoncap = Stella.KWD_NO;
                }
              }
              else if (testValue000 == Stella.KWD_BREAK_ON_NUMBER) {
                if (value != null) {
                  breakonnumber = ((Keyword)(value));
                }
                else {
                  breakonnumber = Stella.KWD_NO;
                }
              }
              else if (testValue000 == Stella.KWD_BREAK_ON_SEPARATORS) {
                breakonseparators = ((StringWrapper)(value)).wrapperValue;
              }
              else if (testValue000 == Stella.KWD_REMOVE_PREFIX) {
                removeprefix = ((StringWrapper)(value)).wrapperValue;
              }
              else if (testValue000 == Stella.KWD_REMOVE_SUFFIX) {
                removesuffix = ((StringWrapper)(value)).wrapperValue;
              }
              else if (testValue000 == Stella.KWD_ADD_PREFIX) {
                addprefix = ((StringWrapper)(value)).wrapperValue;
              }
              else if (testValue000 == Stella.KWD_ADD_SUFFIX) {
                addsuffix = ((StringWrapper)(value)).wrapperValue;
              }
              else if (testValue000 == Stella.KWD_CASE) {
                outputcase = ((Keyword)(value));
              }
              else if (testValue000 == Stella.KWD_SEPARATOR) {
                outputseparator = ((StringWrapper)(value)).wrapperValue;
              }
              else {
                { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                  stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
                  throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                }
              }
            }
          }
        }
        return (Stella.makeMatchingNameFull(original, breakoncap, breakonnumber, breakonseparators, removeprefix, removesuffix, addprefix, addsuffix, outputcase, outputseparator));
      }
    }
  }

  /** Keyword options:
   *   :break-on-cap    one of  :YES :NO :CLEVER         default is :CLEVER
   *   :break-on-number one of  :YES :NO :CLEVER         default is :CLEVER
   *   :break-on-separators string                       default is &quot;-_ &quot;
   * <p>
   *   DECOMPOSE-NAMESTRING returns a cons of STRING-WRAPPERS that are the decomposition of the
   * input STRING.  The arguments are used as follows:
   *   <code>namestring</code>       is the input string.
   *   :break-on-cap    is a keyword controlling whether changes in capitalization is used
   *                    to indicate word boundaries.  If :YES, then all capitalization
   *                    changes delineate words.  If :CLEVER, then unbroken runs of
   *                    capitalized letters are treated as acronyms and remain grouped.
   *                    If :NO or NULL, there is no breaking of words based on capitalization.
   *   :break-on-number is a flag controlling whether encountering a number indicates
   *                    a word boundary.  If :YES, then each run of numbers is treated as
   * 		   a word separate from surrounding words.  If :CLEVER, then an 
   * 		   attempt is made to recognize ordinal numbers (ie, 101st) and
   * 		   treat them as separate words.  If :NO or NULL, there is no breaking
   *                    of words when numbers are encountered.
   *   :break-on-separators   A string of characters which constitute word delimiters in
   *                          the input word.  This is used to determine how to break
   *                    the name into individual words.  Defaults are space, '-' and '_'.
   * @param namestring
   * @param options
   * @return Cons
   */
  public static Cons decomposeNamestring(String namestring, Cons options) {
    { PropertyList self000 = PropertyList.newPropertyList();

      self000.thePlist = options;
      { PropertyList plist = self000;
        Keyword breakoncap = Stella.KWD_CLEVER;
        Keyword breakonnumber = Stella.KWD_CLEVER;
        String breakonseparators = "-_ ";

        Stella_Object.vetOptions(plist, Stella.getQuotedTree("((:BREAK-ON-CAP :BREAK-ON-NUMBER :BREAK-ON-SEPARATORS) \"/STELLA\")", "/STELLA"));
        { Stella_Object key = null;
          Stella_Object value = null;
          Cons iter000 = plist.thePlist;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
            key = iter000.value;
            value = iter000.rest.value;
            { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(key));

              if (testValue000 == Stella.KWD_BREAK_ON_CAP) {
                if (value != null) {
                  breakoncap = ((Keyword)(value));
                }
                else {
                  breakoncap = Stella.KWD_NO;
                }
              }
              else if (testValue000 == Stella.KWD_BREAK_ON_NUMBER) {
                if (value != null) {
                  breakonnumber = ((Keyword)(value));
                }
                else {
                  breakonnumber = Stella.KWD_NO;
                }
              }
              else if (testValue000 == Stella.KWD_BREAK_ON_SEPARATORS) {
                breakonseparators = ((StringWrapper)(value)).wrapperValue;
              }
              else {
                { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                  stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
                  throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                }
              }
            }
          }
        }
        return (Stella.decomposeNamestringFull(namestring, breakoncap, breakonnumber, breakonseparators));
      }
    }
  }

  /** Non-keyword version of <code>makeMatchingName</code>, which will probably be
   * easier to use when called from non-Lisp languages.
   * @param originalname
   * @param breakoncap
   * @param breakonnumber
   * @param breakonseparators
   * @param removeprefix
   * @param removesuffix
   * @param addprefix
   * @param addsuffix
   * @param outputcase
   * @param outputseparator
   * @return String
   */
  public static String makeMatchingNameFull(String originalname, Keyword breakoncap, Keyword breakonnumber, String breakonseparators, String removeprefix, String removesuffix, String addprefix, String addsuffix, Keyword outputcase, String outputseparator) {
    { int prefixlength = removeprefix.length();
      int suffixlength = removesuffix.length();
      String resultString = originalname;
      int resultLength = 0;

      if ((prefixlength > 0) &&
          ((prefixlength <= originalname.length()) &&
           Stella.stringEqlP(removeprefix, Native.string_subsequence(originalname, 0, prefixlength)))) {
        resultString = Native.string_subsequence(originalname, prefixlength, Stella.NULL_INTEGER);
      }
      resultLength = resultString.length();
      if ((suffixlength > 0) &&
          ((suffixlength <= resultLength) &&
           Stella.stringEqlP(removesuffix, Native.string_subsequence(resultString, resultLength - suffixlength, resultLength)))) {
        resultString = Native.string_subsequence(resultString, 0, resultLength - suffixlength);
      }
      if (Stella.stringEqlP(resultString, "")) {
        resultString = originalname;
      }
      resultString = Cons.composeNamestringFull(Stella.decomposeNamestringFull(resultString, breakoncap, breakonnumber, breakonseparators), addprefix, addsuffix, outputcase, outputseparator, null, false);
      if (Stella.stringEqlP(resultString, "")) {
        return (originalname);
      }
      else {
        return (resultString);
      }
    }
  }

  /** Non-keyword version of <code>decomposeNamestring</code>, which will probably be
   * easier to use when called from non-Lisp languages.
   * @param namestring
   * @param breakOnCap
   * @param breakOnNumber
   * @param breakOnSeparators
   * @return Cons
   */
  public static Cons decomposeNamestringFull(String namestring, Keyword breakOnCap, Keyword breakOnNumber, String breakOnSeparators) {
    { int len = namestring.length();
      Cons result = Stella.NIL;
      int lag = 0;
      int lead = 0;
      boolean incaprunP = false;
      boolean innumberP = false;

      { char c = Stella.NULL_CHARACTER;
        String vector000 = namestring;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          c = vector000.charAt(index000);
          { boolean foundP000 = false;

            { char sep = Stella.NULL_CHARACTER;
              String vector001 = breakOnSeparators;
              int index001 = 0;
              int length001 = vector001.length();

              loop001 : for (;index001 < length001; index001 = index001 + 1) {
                sep = vector001.charAt(index001);
                if (sep == c) {
                  foundP000 = true;
                  break loop001;
                }
              }
            }
            if (foundP000) {
              {
                result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(namestring, lag, lead)), result);
                lag = lead + 1;
                innumberP = false;
                incaprunP = false;
              }
            }
            else {
              if (lag > lead) {
                {
                }
              }
              else {
                if (Stella.$CHARACTER_TYPE_TABLE$[(int) c] == Stella.KWD_DIGIT) {
                  {
                    if ((!innumberP) &&
                        (!(breakOnNumber == Stella.KWD_NO))) {
                      if (!(lead == lag)) {
                        result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(namestring, lag, lead)), result);
                        lag = lead;
                      }
                    }
                    else {
                    }
                    incaprunP = false;
                    innumberP = true;
                  }
                }
                else {
                  if (Stella.lowerCaseCharacterP(c)) {
                    {
                      if (innumberP &&
                          (!(breakOnNumber == Stella.KWD_NO))) {
                        if (lead == lag) {
                        }
                        else if (!(breakOnNumber == Stella.KWD_CLEVER)) {
                          result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(namestring, lag, lead)), result);
                          lag = lead;
                        }
                        else if ((lead < (len - 1)) &&
                            Stella.ordinalNumberStringP(Native.string_subsequence(namestring, lag, lead + 2))) {
                          result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(namestring, lag, lead + 2)), result);
                          lag = lead + 2;
                        }
                        else {
                          result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(namestring, lag, lead)), result);
                          lag = lead;
                        }
                      }
                      if (lag > lead) {
                      }
                      else if (breakOnCap == Stella.KWD_NO) {
                      }
                      else if (!(breakOnCap == Stella.KWD_CLEVER)) {
                      }
                      else if (incaprunP) {
                        if (!(lead == (lag + 1))) {
                          result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(namestring, lag, lead - 1)), result);
                          lag = lead - 1;
                        }
                      }
                      innumberP = false;
                      incaprunP = false;
                    }
                  }
                  else {
                    if (Stella.upperCaseCharacterP(c)) {
                      if (innumberP &&
                          (!(breakOnNumber == Stella.KWD_NO))) {
                        if (lead == lag) {
                        }
                        else if (!(breakOnNumber == Stella.KWD_CLEVER)) {
                          result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(namestring, lag, lead)), result);
                          lag = lead;
                        }
                        else if ((lead < (len - 1)) &&
                            Stella.ordinalNumberStringP(Native.string_subsequence(namestring, lag, lead + 2))) {
                          result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(namestring, lag, lead + 2)), result);
                          lag = lead + 2;
                        }
                        else {
                          result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(namestring, lag, lead)), result);
                          lag = lead;
                        }
                      }
                      if (lag > lead) {
                      }
                      else if (breakOnCap == Stella.KWD_NO) {
                      }
                      else if (!(breakOnCap == Stella.KWD_CLEVER)) {
                        if (!(lead == lag)) {
                          result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(namestring, lag, lead)), result);
                          lag = lead;
                        }
                      }
                      else if (incaprunP) {
                      }
                      else {
                        if (!(lead == lag)) {
                          result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(namestring, lag, lead)), result);
                          lag = lead;
                        }
                        incaprunP = true;
                      }
                      innumberP = false;
                    }
                  }
                }
              }
            }
          }
          lead = lead + 1;
        }
      }
      if (!(lead < lag)) {
        result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(namestring, lag, Stella.NULL_INTEGER)), result);
      }
      return (result.reverse());
    }
  }

  public static boolean suffixMatchesP(String teststring, String suffix) {
    { int stringlength = teststring.length();
      int suffixlength = suffix.length();

      return ((suffixlength <= stringlength) &&
          Stella.stringEqlP(suffix, Native.string_subsequence(teststring, stringlength - suffixlength, Stella.NULL_INTEGER)));
    }
  }

  public static boolean ordinalNumberStringP(String teststring) {
    { int len = teststring.length();
      boolean teenP = (len > 3) &&
          ('1' == teststring.charAt((len - 4)));
      String suffix = "th";

      if (len < 3) {
        return (false);
      }
      { char c = Stella.NULL_CHARACTER;
        String vector000 = teststring;
        int index000 = 0;
        int length000 = vector000.length();
        int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = len - 3;

        for (;(index000 < length000) &&
                  (iter000 <= upperBound000); index000 = index000 + 1, iter000 = iter000 + 1) {
          c = vector000.charAt(index000);
          i = iter000;
          i = i;
          if (!(Stella.$CHARACTER_TYPE_TABLE$[(int) c] == Stella.KWD_DIGIT)) {
            return (false);
          }
        }
      }
      if (!(teenP)) {
        switch (teststring.charAt((len - 3))) {
          case '1': 
            suffix = "st";
          break;
          case '2': 
            suffix = "nd";
          break;
          case '3': 
            suffix = "rd";
          break;
          default:
          break;
        }
      }
      return (Stella.suffixMatchesP(teststring, suffix));
    }
  }

  public static boolean heuristicAcronymP(String itemstring) {
    { boolean letterfoundP = false;
      boolean numberfoundP = false;

      { char c = Stella.NULL_CHARACTER;
        String vector000 = itemstring;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          c = vector000.charAt(index000);
          if (Stella.$CHARACTER_TYPE_TABLE$[(int) c] == Stella.KWD_DIGIT) {
            numberfoundP = true;
          }
          else if (Stella.lowerCaseCharacterP(c) ||
              Stella.upperCaseCharacterP(c)) {
            letterfoundP = true;
          }
          else if (Stella.getQuotedTree("((#\\. #\\- #\\/) \"/STELLA\")", "/STELLA").memberP(CharacterWrapper.wrapCharacter(c))) {
            numberfoundP = true;
          }
          else {
            return (false);
          }
        }
      }
      return (numberfoundP &&
          (letterfoundP &&
           (!Stella.ordinalNumberStringP(itemstring))));
    }
  }

  public static String rootSourceDirectory() {
    return (Stella.translateLogicalPathname(((String)(Stella.$ROOTSOURCEDIRECTORY$.get()))));
  }

  public static String rootNativeDirectory() {
    return (Stella.translateLogicalPathname(((String)(Stella.$ROOTNATIVEDIRECTORY$.get()))));
  }

  public static String rootBinaryDirectory() {
    return (Stella.translateLogicalPathname(((String)(Stella.$ROOTBINARYDIRECTORY$.get()))));
  }

  public static String systemDefinitionsDirectory() {
    if (((String)(Stella.$SYSTEMDEFINITIONSDIRECTORY$.get())) != null) {
      return (Stella.translateLogicalPathname(((String)(Stella.$SYSTEMDEFINITIONSDIRECTORY$.get()))));
    }
    else {
      return (Stella.rootSourceDirectory() + "systems");
    }
  }

  public static void translateAndOutputUnitsToFile(String file, String targetlanguage) {
    Native.setSpecial(Stella.$TRANSLATIONPHASE$, Stella.KWD_TRANSLATE);
    if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) {
    }
    else {
      if (((Integer)(Stella.$TRANSLATIONVERBOSITYLEVEL$.get())).intValue() >= 1) {
        Stella.STANDARD_OUTPUT.nativeStream.println("Translating `" + file + "' to `" + targetlanguage + "'...");
      }
      Stella.translateAllUnits();
    }
    Stella.outputAllUnitsToFile(file);
  }

  public static void operateOnFile(String file, Keyword operation) {
    { String targetlanguage = ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())).symbolName;
      Module currentmodule = ((Module)(Stella.$MODULE$.get()));
      Context currentcontext = ((Context)(Stella.$CONTEXT$.get()));
      boolean seeninmoduleP = false;
      boolean skipP = false;

      file = Stella.translateLogicalPathname(file);
      if (operation == null) {
        operation = Stella.KWD_TRANSLATE;
      }
      { Object old$Translationphase$000 = Stella.$TRANSLATIONPHASE$.get();
        Object old$Translationerrors$000 = Stella.$TRANSLATIONERRORS$.get();
        Object old$Translationwarnings$000 = Stella.$TRANSLATIONWARNINGS$.get();
        Object old$Translationnotes$000 = Stella.$TRANSLATIONNOTES$.get();
        Object old$Currentfile$000 = Stella.$CURRENTFILE$.get();
        Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$TRANSLATIONPHASE$, null);
          Native.setIntSpecial(Stella.$TRANSLATIONERRORS$, 0);
          Native.setIntSpecial(Stella.$TRANSLATIONWARNINGS$, 0);
          Native.setIntSpecial(Stella.$TRANSLATIONNOTES$, 0);
          Native.setSpecial(Stella.$CURRENTFILE$, Stella.fileBaseName(file));
          Native.setSpecial(Stella.$MODULE$, currentmodule);
          Native.setSpecial(Stella.$CONTEXT$, currentcontext);
          if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
            targetlanguage = "Common Lisp";
          }
          else if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ||
              (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE)) {
            targetlanguage = "C++";
          }
          else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_IDL) {
            targetlanguage = "IDL";
          }
          else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) {
            targetlanguage = "Java";
          }
          else {
          }
          if (((Integer)(Stella.$TRANSLATIONVERBOSITYLEVEL$.get())).intValue() >= 1) {
            Stella.STANDARD_OUTPUT.nativeStream.println("Processing `" + file + "':");
            Stella.STANDARD_OUTPUT.nativeStream.println("*** Pass 1, generating objects...");
          }
          { Object old$TransientobjectsP$000 = Stella.$TRANSIENTOBJECTSp$.get();

            try {
              Native.setBooleanSpecial(Stella.$TRANSIENTOBJECTSp$, true);
              { Stella_Object tree = null;
                SExpressionIterator iter000 = InputStream.sExpressions(InputFileStream.newInputFileStream(file));

                while (iter000.nextP()) {
                  tree = iter000.value;
                  { Object old$TransientobjectsP$001 = Stella.$TRANSIENTOBJECTSp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$TRANSIENTOBJECTSp$, false);
                      if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
                        { Cons tree000 = ((Cons)(tree));

                          { Object [] caller_MV_returnarray = new Object[1];

                            skipP = Cons.handleInModuleTree(tree000, seeninmoduleP, true, caller_MV_returnarray);
                            seeninmoduleP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[0])).wrapperValue));
                          }
                          if (!(skipP)) {
                            { Object old$Translationphase$001 = Stella.$TRANSLATIONPHASE$.get();

                              try {
                                Native.setSpecial(Stella.$TRANSLATIONPHASE$, Stella.KWD_DEFINE);
                                Cons.walkTopLevelTree(tree000, true);

                              } finally {
                                Stella.$TRANSLATIONPHASE$.set(old$Translationphase$001);
                              }
                            }
                          }
                        }
                      }
                      else {
                      }

                    } finally {
                      Stella.$TRANSIENTOBJECTSp$.set(old$TransientobjectsP$001);
                    }
                  }
                }
              }

            } finally {
              Stella.$TRANSIENTOBJECTSp$.set(old$TransientobjectsP$000);
            }
          }
          ((List)(Stella.$TRANSLATIONUNITS$.get())).reverse();
          if (!(operation == Stella.KWD_DEFINE)) {
            if (((Integer)(Stella.$TRANSLATIONVERBOSITYLEVEL$.get())).intValue() >= 1) {
              Stella.STANDARD_OUTPUT.nativeStream.println("*** Pass 2, finalizing objects...");
            }
            Native.setSpecial(Stella.$TRANSLATIONPHASE$, Stella.KWD_FINALIZE);
            Stella.finalizeClassesAndSlots();
            if (!(operation == Stella.KWD_FINALIZE)) {
              if (((Integer)(Stella.$TRANSLATIONVERBOSITYLEVEL$.get())).intValue() >= 1) {
                Stella.STANDARD_OUTPUT.nativeStream.println("*** Pass 3, walking objects...");
              }
              Native.setSpecial(Stella.$TRANSLATIONPHASE$, Stella.KWD_WALK);
              if (!(Stella.useHardcodedSymbolsP() ||
                  (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA))) {
                Stella.clearSymbolRegistry();
              }
              { Object old$UserecordedsignaturesP$000 = Stella.$USERECORDEDSIGNATURESp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$USERECORDEDSIGNATURESp$, Stella.$WALK_WITH_RECORDED_SIGNATURESp$);
                  Stella.walkAllPhaseOneUnits();

                } finally {
                  Stella.$USERECORDEDSIGNATURESp$.set(old$UserecordedsignaturesP$000);
                }
              }
              if (!(operation == Stella.KWD_WALK)) {
                Stella.translateAndOutputUnitsToFile(file, targetlanguage);
              }
              if (Stella.$RECORD_SIGNATURESp$) {
                Stella.STANDARD_OUTPUT.nativeStream.println("Recording object signatures...");
                Stella.recordSignaturesOfAllUnits(file);
              }
            }
          }
          Stella.summarizeTranslationErrors();

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
          Stella.$CURRENTFILE$.set(old$Currentfile$000);
          Stella.$TRANSLATIONNOTES$.set(old$Translationnotes$000);
          Stella.$TRANSLATIONWARNINGS$.set(old$Translationwarnings$000);
          Stella.$TRANSLATIONERRORS$.set(old$Translationerrors$000);
          Stella.$TRANSLATIONPHASE$.set(old$Translationphase$000);
        }
      }
    }
  }

  public static void cleanUpTranslationUnitsSpecial() {
    { TranslationUnit unit = null;
      Cons iter000 = ((List)(Stella.$TRANSLATIONUNITS$.get())).theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        unit = ((TranslationUnit)(iter000.value));
        unit.free();
      }
    }
    ((List)(Stella.$TRANSLATIONUNITS$.get())).clear();
    Stella.sweepTransients();
  }

  public static void translateFile(String file, Keyword outputlanguage, boolean aspartofsystemP) {
    { Keyword mode = Stella.KWD_TRANSLATE;

      { Object old$JavaIndentChars$000 = Stella.$JAVA_INDENT_CHARS$.get();
        Object old$IdlIndentChars$000 = Stella.$IDL_INDENT_CHARS$.get();
        Object old$CppIndentChars$000 = Stella.$CPP_INDENT_CHARS$.get();

        try {
          Native.setIntSpecial(Stella.$JAVA_INDENT_CHARS$, 0);
          Native.setIntSpecial(Stella.$IDL_INDENT_CHARS$, 0);
          Native.setIntSpecial(Stella.$CPP_INDENT_CHARS$, 0);
          if (outputlanguage == Stella.KWD_JAVA) {
            if (aspartofsystemP) {
              mode = Stella.KWD_WALK;
            }
          }
          else {
          }
          if (aspartofsystemP) {
            Stella.operateOnFile(file, mode);
          }
          else {
            { Object old$Translatoroutputlanguage$000 = Stella.$TRANSLATOROUTPUTLANGUAGE$.get();
              Object old$Translationunits$000 = Stella.$TRANSLATIONUNITS$.get();

              try {
                Native.setSpecial(Stella.$TRANSLATOROUTPUTLANGUAGE$, ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())));
                Native.setSpecial(Stella.$TRANSLATIONUNITS$, List.newList());
                Keyword.setTranslatorOutputLanguage(outputlanguage);
                Stella.operateOnFile(file, mode);
                if (outputlanguage == Stella.KWD_CPP_STANDALONE) {
                }
                else {
                  Stella.cleanUpTranslationUnitsSpecial();
                }

              } finally {
                Stella.$TRANSLATIONUNITS$.set(old$Translationunits$000);
                Stella.$TRANSLATOROUTPUTLANGUAGE$.set(old$Translatoroutputlanguage$000);
              }
            }
          }

        } finally {
          Stella.$CPP_INDENT_CHARS$.set(old$CppIndentChars$000);
          Stella.$IDL_INDENT_CHARS$.set(old$IdlIndentChars$000);
          Stella.$JAVA_INDENT_CHARS$.set(old$JavaIndentChars$000);
        }
      }
    }
  }

  public static void outputAllUnitsToFile(String sourcefile) {
    if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
      Stella.clOutputAllUnitsToFile(sourcefile);
    }
    else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) {
      { Object old$JavaIndentChars$000 = Stella.$JAVA_INDENT_CHARS$.get();

        try {
          Native.setIntSpecial(Stella.$JAVA_INDENT_CHARS$, 0);
          Stella.javaOutputAllUnitsToFile();

        } finally {
          Stella.$JAVA_INDENT_CHARS$.set(old$JavaIndentChars$000);
        }
      }
    }
    else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_IDL) {
      { Object old$IdlIndentChars$000 = Stella.$IDL_INDENT_CHARS$.get();

        try {
          Native.setIntSpecial(Stella.$IDL_INDENT_CHARS$, 0);
          Stella.idlOutputAllUnitsToFile(sourcefile);

        } finally {
          Stella.$IDL_INDENT_CHARS$.set(old$IdlIndentChars$000);
        }
      }
    }
    else if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ||
        (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE)) {
      { Object old$CppIndentChars$000 = Stella.$CPP_INDENT_CHARS$.get();

        try {
          Native.setIntSpecial(Stella.$CPP_INDENT_CHARS$, 0);
          Stella.cppOutputAllUnitsToFile(sourcefile);

        } finally {
          Stella.$CPP_INDENT_CHARS$.set(old$CppIndentChars$000);
        }
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static void recordSignaturesOfAllUnits(String sourcefile) {
    sourcefile = sourcefile;
  }

  public static boolean translateWithCopyrightHeaderP() {
    return (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_TRANSLATE_WITH_COPYRIGHT_HEADER));
  }

  public static Keyword operatingSystem() {
    if (Stella.probeFileP("C:\\AUTOEXEC.BAT") ||
        (Stella.probeFileP("C:\\IO.SYS") ||
         (Stella.probeFileP("C:\\BOOT.INI") ||
          Stella.startsWithP(System.getProperty("os.name").toLowerCase(), "win", 0)))) {
      return (Stella.KWD_WINDOWS);
    }
    else if (Stella.probeFileP("/usr") ||
        Stella.probeFileP("/etc")) {
      return (Stella.KWD_UNIX);
    }
    else {
      return (Stella.KWD_MAC);
    }
  }

  public static char directorySeparator() {
    { char separator = '?';

      separator = java.io.File.separatorChar;;
      return (separator);
    }
  }

  public static String directorySeparatorString() {
    return (Native.makeString(1, Stella.directorySeparator()));
  }

  public static char directorySeparatorForFile(String file) {
    if (Stella.logicalPathnameP(file)) {
      return (Stella.LOGICAL_DIRECTORY_SEPARATOR);
    }
    else {
      return (Stella.directorySeparator());
    }
  }

  /** Return the directory component of <code>file</code> including the final
   * directory separator or the empty string if <code>file</code> does not include a directory.
   * Note that for purposes of this function, a logical host is considered part of
   * the directory portion of <code>file</code>
   * @param file
   * @return String
   */
  public static String fileNameDirectory(String file) {
    { int start = 0;
      int length = file.length();
      char separator = Stella.directorySeparatorForFile(file);

      if (Stella.logicalPathnameP(file)) {
        start = Native.string_position(file, Stella.LOGICAL_HOST_SEPARATOR, 0) + 1;
      }
      while ((start < length) &&
          (Native.string_position(file, separator, start) != Stella.NULL_INTEGER)) {
        start = Native.string_position(file, separator, start) + 1;
      }
      return (Native.string_subsequence(file, 0, start));
    }
  }

  /** Return <code>directory</code> as a file name, i.e., without a terminating
   * directory separator.
   * @param directory
   * @return String
   */
  public static String directoryFileName(String directory) {
    { char separator = Stella.directorySeparatorForFile(directory);
      int last = directory.length() - 1;

      if ((last >= 0) &&
          (directory.charAt(last) == separator)) {
        return (Native.string_subsequence(directory, 0, last));
      }
      else {
        return (directory);
      }
    }
  }

  /** Return <code>file</code> interpreted as a directory, i.e., with a
   * terminating directory separator.  If <code>file</code> is the empty string simply
   * return the empty string, i.e., interpret it as the current directory instead
   * of the root directory.
   * @param file
   * @return String
   */
  public static String fileNameAsDirectory(String file) {
    { char separator = Stella.directorySeparatorForFile(file);
      int last = file.length() - 1;

      if ((last < 0) ||
          (file.charAt(last) == separator)) {
        return (file);
      }
      else {
        return (file + Native.makeString(1, separator));
      }
    }
  }

  /** Return the <code>level</code>-th parent directory component of <code>directory</code>
   * including the final directory separator, or the empty string if <code>directory</code> does
   * not have that many parents.
   * @param directory
   * @param level
   * @return String
   */
  public static String directoryParentDirectory(String directory, int level) {
    { int i = Stella.NULL_INTEGER;
      int iter000 = 1;
      int upperBound000 = level;
      boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

      for (;unboundedP000 ||
                (iter000 <= upperBound000); iter000 = iter000 + 1) {
        i = iter000;
        i = i;
        directory = Stella.fileNameDirectory(Stella.directoryFileName(directory));
      }
    }
    return (directory);
  }

  /** Return the file name portion of <code>file</code> by removing any
   * physical device components.  This is just like <code>logicalPathnameWithoutHost</code>
   * but only looks for one-character device strings as used in Windows.
   * @param file
   * @return String
   */
  public static String fileNameWithoutDevice(String file) {
    { char separator = ':';

      if ((file.length() >= 2) &&
          ((file.charAt(1) == separator) &&
           (Stella.$CHARACTER_TYPE_TABLE$[(int) (file.charAt(0))] == Stella.KWD_LETTER))) {
        return (Native.string_subsequence(file, 2, Stella.NULL_INTEGER));
      }
      else {
        return (file);
      }
    }
  }

  /** Return the file name portion of <code>file</code> by removing any
   * directory and logical host components.
   * @param file
   * @return String
   */
  public static String fileNameWithoutDirectory(String file) {
    { int start = 0;
      char separator = Stella.directorySeparatorForFile(file);

      if (separator == Stella.LOGICAL_HOST_SEPARATOR) {
        file = Stella.logicalPathnameWithoutHost(file);
      }
      else {
        file = Stella.fileNameWithoutDevice(file);
      }
      while (Native.string_position(file, separator, start) != Stella.NULL_INTEGER) {
        start = Native.string_position(file, separator, start) + 1;
      }
      return (Native.string_subsequence(file, start, Stella.NULL_INTEGER));
    }
  }

  /** Remove <code>file</code>s extension (or type) if there is any and
   * return the result.
   * @param file
   * @return String
   */
  public static String fileNameWithoutExtension(String file) {
    { int start = 0;
      int end = Stella.NULL_INTEGER;

      while (Native.string_position(file, Stella.TYPE_SEPARATOR, start) != Stella.NULL_INTEGER) {
        end = Native.string_position(file, Stella.TYPE_SEPARATOR, start);
        start = end + 1;
      }
      return (Native.string_subsequence(file, 0, end));
    }
  }

  /** Return <code>file</code>s extension (or type) if it has any including
   * the separator character.
   * @param file
   * @return String
   */
  public static String fileExtension(String file) {
    { int start = 0;
      int end = Stella.NULL_INTEGER;

      while (Native.string_position(file, Stella.TYPE_SEPARATOR, start) != Stella.NULL_INTEGER) {
        end = Native.string_position(file, Stella.TYPE_SEPARATOR, start);
        start = end + 1;
      }
      if (end == Stella.NULL_INTEGER) {
        return (null);
      }
      else if (Native.string_position(file, Stella.directorySeparatorForFile(file), end) != Stella.NULL_INTEGER) {
        return (null);
      }
      else {
        return (Native.string_subsequence(file, end, Stella.NULL_INTEGER));
      }
    }
  }

  /** Remove <code>file</code>s directory (including logical host) and
   * extension components and return the result.
   * @param file
   * @return String
   */
  public static String fileBaseName(String file) {
    return (Stella.fileNameWithoutExtension(Stella.fileNameWithoutDirectory(file)));
  }

  /** Define <code>property</code> with <code>value</code> for the logical host <code>host</code>.
   * As a side-effect, this also defines <code>host</code> as a logical host (both
   * <code>property</code> and <code>value</code> can be supplied as NULL).  If :ROOT-DIRECTORY
   * is specified, all pathnames with <code>host</code> are assumed to be relative to
   * that directory (even if they are absolute) and will be rerooted upon
   * translation.  :ROOT-DIRECTORY can be a logical or physical pathname.
   * If :LISP-TRANSLATIONS is specified, those will be used verbatimely as
   * the value of <code>_CLClogical_pathname_translations_host_</code> if we are
   * running in Lisp, which allows us to depend on the native
   * <code>CLCtranslate_logical_pathname</code> for more complex translation operations.
   * @param host
   * @param property
   * @param value
   */
  public static void defineLogicalHostProperty(String host, Keyword property, Stella_Object value) {
    host = Native.stringUpcase(host);
    { KeyValueList properties = ((KeyValueList)(Stella.$LOGICAL_HOST_TABLE$.lookup(host)));

      if (properties == null) {
        properties = KeyValueList.newKeyValueList();
        Stella.$LOGICAL_HOST_TABLE$.insertAt(host, properties);
      }
      if (property != null) {
        if (property == Stella.KWD_ROOT_DIRECTORY) {
          properties.insertAt(property, null);
          if (value != null) {
            properties.insertAt(property, StringWrapper.wrapString(Stella.translateLogicalPathname(Stella.fileNameAsDirectory(((StringWrapper)(value)).wrapperValue))));
          }
        }
        else if (property == Stella.KWD_LISP_TRANSLATIONS) {
          properties.insertAt(property, value);
        }
        else {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: Illegal host property: `" + property + "'");
        }
      }
    }
  }

  public static Stella_Object lookupLogicalHostProperty(String host, Keyword property) {
    host = Native.stringUpcase(host);
    { KeyValueList properties = ((KeyValueList)(Stella.$LOGICAL_HOST_TABLE$.lookup(host)));

      if (properties == null) {
        return (null);
      }
      else {
        return (properties.lookup(property));
      }
    }
  }

  public static boolean logicalHostP(String host) {
    return (((KeyValueList)(Stella.$LOGICAL_HOST_TABLE$.lookup(Native.stringUpcase(host)))) != null);
  }

  public static boolean logicalPathnameP(String pathname) {
    { String host = Stella.getLogicalHostName(pathname);

      return ((host != null) &&
          Stella.logicalHostP(host));
    }
  }

  public static boolean absolutePathnameP(String pathname) {
    { char separator = Stella.directorySeparator();

      if (Stella.logicalPathnameP(pathname)) {
        separator = Stella.LOGICAL_DIRECTORY_SEPARATOR;
        pathname = Stella.logicalPathnameWithoutHost(pathname);
      }
      else {
        pathname = Stella.fileNameWithoutDevice(pathname);
      }
      return ((pathname.length() > 0) &&
          (pathname.charAt(0) == separator));
    }
  }

  public static String getLogicalHostName(String pathname) {
    { int separatorpos = Native.string_position(pathname, Stella.LOGICAL_HOST_SEPARATOR, 0);

      if ((separatorpos != Stella.NULL_INTEGER) &&
          (separatorpos >= 1)) {
        return (Native.string_subsequence(pathname, 0, separatorpos));
      }
      else {
        return (null);
      }
    }
  }

  public static String logicalPathnameWithoutHost(String pathname) {
    { String hostname = Stella.getLogicalHostName(pathname);

      if (hostname == null) {
        return (pathname);
      }
      else {
        return (Native.string_subsequence(pathname, hostname.length() + 1, Stella.NULL_INTEGER));
      }
    }
  }

  public static String translateLogicalPathname(String pathname) {
    if (!(Stella.logicalPathnameP(pathname))) {
      return (pathname);
    }
    { String host = Stella.getLogicalHostName(pathname);
      String translatedpathname = pathname;

      translatedpathname = Native.string_substitute(Stella.logicalPathnameWithoutHost(pathname), Stella.directorySeparator(), Stella.LOGICAL_DIRECTORY_SEPARATOR);
      { StringWrapper rootdirectory = ((StringWrapper)(Stella.lookupLogicalHostProperty(host, Stella.KWD_ROOT_DIRECTORY)));

        if (rootdirectory != null) {
          if (Stella.absolutePathnameP(translatedpathname)) {
            translatedpathname = Native.string_subsequence(translatedpathname, 1, Stella.NULL_INTEGER);
          }
          translatedpathname = rootdirectory.wrapperValue + translatedpathname;
        }
      }
      return (translatedpathname);
    }
  }

  public static String unlogicalizePathname(String pathname) {
    return (Stella.translateLogicalPathname(pathname));
  }

  /** Parse <code>basefile</code>, supply any missing components from
   * <code>defaults</code> if supplied and return the result.
   * @param basefile
   * @param defaults
   * @return String
   */
  public static String mergeFileNames(String basefile, String defaults) {
    { char baseseparator = Stella.directorySeparatorForFile(basefile);
      String basehost = Stella.getLogicalHostName(basefile);
      String basedirectory = Stella.logicalPathnameWithoutHost(Stella.fileNameDirectory(basefile));
      String basename = Stella.fileBaseName(basefile);
      String baseextension = Stella.fileExtension(basefile);
      char defaultsseparator = Stella.directorySeparatorForFile(defaults);
      boolean mergedP = false;
      OutputStringStream result = null;

      if ((!(baseseparator == defaultsseparator)) &&
          (Native.string_memberP(basefile, baseseparator) &&
           Native.string_memberP(defaults, defaultsseparator))) {
        throw ((StellaException)(StellaException.newStellaException("merge-file-names: base file and defaults use different syntax").fillInStackTrace()));
      }
      if (basehost == null) {
        basehost = Stella.getLogicalHostName(defaults);
        mergedP = mergedP ||
            (basehost != null);
      }
      if (Stella.stringEqlP(basedirectory, "")) {
        basedirectory = Stella.logicalPathnameWithoutHost(Stella.fileNameDirectory(defaults));
        mergedP = mergedP ||
            (!Stella.stringEqlP(basedirectory, ""));
      }
      if (basename == null) {
        basename = Stella.fileBaseName(defaults);
        mergedP = mergedP ||
            (basename != null);
      }
      if (baseextension == null) {
        baseextension = Stella.fileExtension(defaults);
        mergedP = mergedP ||
            (baseextension != null);
      }
      if (!mergedP) {
        return (basefile);
      }
      result = OutputStringStream.newOutputStringStream();
      if (basehost != null) {
        result.nativeStream.print(basehost + Stella.LOGICAL_HOST_SEPARATOR);
      }
      result.nativeStream.print(basedirectory);
      if (basename != null) {
        result.nativeStream.print(basename);
      }
      if (baseextension != null) {
        result.nativeStream.print(baseextension);
      }
      return (result.theStringReader());
    }
  }

  public static Keyword classifyFileExtension(String file) {
    { String extension = Stella.fileExtension(file);

      if (extension == null) {
        return (Stella.KWD_NONE);
      }
      { Cons entry = null;
        Cons iter000 = Stella.$TYPE_TO_FILE_EXTENSION_TABLE$;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          entry = ((Cons)(iter000.value));
          if (Stella_Object.eqlToStringP(entry.rest.value, extension)) {
            return (((Keyword)(entry.value)));
          }
        }
      }
      if (Stella.runningAsLispP()) {
        if (Stella.stringEqlP(Keyword.computeCommonLispFileExtension(Stella.KWD_LISP), extension)) {
          return (Stella.KWD_LISP);
        }
        if (Stella.stringEqlP(Keyword.computeCommonLispFileExtension(Stella.KWD_LISP_BINARY), extension)) {
          return (Stella.KWD_LISP_BINARY);
        }
      }
      if (Stella.stringEqlP(Keyword.defaultCommonLispFileExtension(Stella.KWD_LISP), extension)) {
        return (Stella.KWD_LISP);
      }
      if (Stella.stringEqlP(Keyword.defaultCommonLispFileExtension(Stella.KWD_LISP_BINARY), extension)) {
        return (Stella.KWD_LISP_BINARY);
      }
      return (Stella.KWD_OTHER);
    }
  }

  public static String rootDirectoryPrefix(String file) {
    { String extension = Stella.fileExtension(file);

      if (Stella.stringEqlP(extension, ".ste")) {
        return (Stella.rootSourceDirectory());
      }
      else if (Stella.stringEqlP(extension, ".lisp") ||
          (Stella.stringEqlP(extension, ".java") ||
           (Stella.stringEqlP(extension, ".cc") ||
            Stella.stringEqlP(extension, ".hh")))) {
        return (Stella.rootNativeDirectory());
      }
      else {
        return (Stella.rootNativeDirectory());
      }
    }
  }

  public static String makeFileName(String filepath, Keyword type, boolean relativeP) {
    { String extension = Keyword.selectFileExtension(type);
      String rootpath = "";
      String splitterpath = "";
      String subdirectory = "";

      if (relativeP) {
        rootpath = Keyword.selectRootDirectory(type);
        splitterpath = Keyword.selectSplitterPath(type);
        if (!(type == Stella.KWD_OTHER)) {
          filepath = Stella.fileNameWithoutExtension(filepath);
        }
        if ((type == Stella.KWD_JAVA) ||
            (((type == Stella.KWD_OTHER) ||
            (type == Stella.KWD_NONE)) &&
             (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA))) {
          subdirectory = Module.javaPackagePrefix(((Module)(Stella.$MODULE$.get())), Stella.directorySeparatorString());
        }
        else {
          if (!Stella.stringEqlP(((String)(Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.get())), "")) {
            subdirectory = ((String)(Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.get())) + Stella.directorySeparatorString();
          }
        }
      }
      else {
        { String rootprefix = Stella.rootDirectoryPrefix(filepath);

          if (!(type == Stella.KWD_OTHER)) {
            filepath = Stella.fileNameWithoutExtension(filepath);
          }
          if (!Stella.getQuotedTree("((:STELLA :KB) \"/STELLA\")", "/STELLA").memberP(type)) {
            { String relativepath = Stella.relativizeFileName(filepath, rootprefix);

              if (!Stella.stringEqlP(filepath, relativepath)) {
                rootpath = Keyword.selectRootDirectory(type);
                splitterpath = Keyword.selectSplitterPath(type);
                filepath = relativepath;
              }
            }
          }
        }
      }
      return (rootpath + splitterpath + subdirectory + filepath + extension);
    }
  }

  public static String relativizeFileName(String file, String rootpath) {
    { boolean absoluteP = Native.stringSearch(file, rootpath, 0) == 0;

      if (absoluteP) {
        return (Native.string_subsequence(file, rootpath.length(), Stella.NULL_INTEGER));
      }
      else {
        return (file);
      }
    }
  }

  public static String helpImplodePathname(String filename) {
    { String extension = Stella.fileExtension(filename);

      if (extension == null) {
        return (Stella.maybeTruncateFilename(filename));
      }
      else {
        return (Stella.maybeTruncateFilename(Stella.fileBaseName(filename)) + extension);
      }
    }
  }

  public static String maybeTruncateFilename(String barefilename) {
    if (((Boolean)(Stella.$DONTTRUNCATEFILENAMESp$.get())).booleanValue()) {
      return (barefilename);
    }
    { int maximumlength = 999;

      if (Stella.$OS$ == Stella.KWD_MAC) {
        maximumlength = 31 - 5;
      }
      else {
      }
      if (barefilename.length() > maximumlength) {
        { String originalfilename = barefilename;

          barefilename = Native.string_subsequence(barefilename, 0, maximumlength - 1);
          {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Truncating name of file.");
            Stella.STANDARD_WARNING.nativeStream.println("   Original: `" + originalfilename + "'    Truncated: `" + barefilename + "'");
            Stella.STANDARD_WARNING.nativeStream.println();
          }
;
        }
      }
      return (barefilename);
    }
  }

  public static String rerootFileName(String file, String fromroot, String toroot) {
    { boolean absoluteP = Native.stringSearch(file, fromroot, 0) == 0;

      if (absoluteP) {
        if (Stella.stringEqlP(fromroot, toroot)) {
          return (file);
        }
        else {
          return (toroot + Native.string_subsequence(file, fromroot.length(), Stella.NULL_INTEGER));
        }
      }
      else {
        return (toroot + file);
      }
    }
  }

  public static BooleanWrapper fileYoungerThanP(String file1, String file2) {
    if ((!Stella.probeFileP(file1)) ||
        (!Stella.probeFileP(file2))) {
      return (null);
    }
    else {
      { CalendarDate file1Date = Stella.fileWriteDate(file1);
        CalendarDate file2Date = Stella.fileWriteDate(file2);

        if ((file1Date == null) ||
            (file2Date == null)) {
          return (null);
        }
        else {
          return ((file1Date.greaterEqualP(file2Date) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
        }
      }
    }
  }

  public static boolean systemNeedsTranslationP(String systemname, Keyword language) {
    { Object old$Currentsystemdefinition$000 = Stella.$CURRENTSYSTEMDEFINITION$.get();
      Object old$Currentsystemdefinitionsubdirectory$000 = Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.get();

      try {
        Native.setSpecial(Stella.$CURRENTSYSTEMDEFINITION$, Stella.getSystemDefinition(systemname));
        Native.setSpecial(Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$, ((((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null) ? ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).directory : null));
        if (((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null) {
          {
            { boolean foundP000 = false;

              { StringWrapper file = null;
                Cons iter000 = SystemDefinition.systemDefinitionSourceFiles(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())));

                loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  file = ((StringWrapper)(iter000.value));
                  if (Stella_Object.stellaNeedToTranslateP(file, language)) {
                    foundP000 = true;
                    break loop000;
                  }
                }
              }
              if (foundP000) {
                return (true);
              }
            }
            { String startupFile = SystemDefinition.systemStartupFileName(null);

              if (!(Stella.probeFileP(Stella.makeFileName(startupFile, Stella.KWD_STELLA, true)))) {
                return (true);
              }
              return (Stella_Object.stellaNeedToTranslateP(StringWrapper.wrapString(startupFile), language));
            }
          }
        }
        else {
          {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't find a system named `" + systemname + "'");
            Stella.STANDARD_WARNING.nativeStream.println();
          }
;
        }

      } finally {
        Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.set(old$Currentsystemdefinitionsubdirectory$000);
        Stella.$CURRENTSYSTEMDEFINITION$.set(old$Currentsystemdefinition$000);
      }
    }
    return (false);
  }

  /** Translate all of the STELLA source files in system <code>systemname</code> into
   * <code>language</code> (the optional first argument).  The following keyword/value
   * <code>options</code> are recognized:
   * <p>
   * <code>Clanguage</code>: can be used as an alternative to the optional language argument.
   * If not specified, the language of the running implementation is assumed.
   * <p>
   * <code>CtwoPassP</code> (default false): if true, all files will be scanned twice, once
   * to load the signatures of objects defined in them, and once to actually
   * translate the definitions.
   * <p>
   * <code>CforceTranslationP</code> (default false): if true, files will be translated
   * whether or not their translations are up-to-date.
   * <p>
   * <code>CdevelopmentSettingsP</code> (default false): if true translation will favor
   * safe, readable and debuggable code over efficiency (according to the value
   * of <code>CdevelopmentSettings</code> on the system definition).  If false, efficiency
   * will be favored instead (according to the value of <code>CproductionSettings</code>
   * on the system definition).
   * <p>
   * <code>CproductionSettingsP</code> (default true): inverse to <code>CdevelopmentSettingsP</code>.
   * @param systemname
   * @param languageAoptions
   * @return boolean
   */
  public static boolean translateSystem(String systemname, Cons languageAoptions) {
    { Cons options = languageAoptions;
      Keyword language = (Stella.getQuotedTree("((:COMMON-LISP :CPP :JAVA) \"/STELLA\")", "/STELLA").memberP(options.value) ? ((Keyword)(options.value)) : Stella.runningInLanguage());
      PropertyList plist = Stella_Object.vetOptions(((options.value == language) ? options.rest : options), Stella.getQuotedTree("((:TWO-PASS? :FORCE-TRANSLATION? :PRODUCTION-SETTINGS? :DEVELOPMENT-SETTINGS? :LANGUAGE :ACTION) \"/STELLA\")", "/STELLA"));
      boolean twopassP = false;
      boolean forcetranslationP = false;
      boolean productionmodeP = true;

      language = ((Keyword)(plist.lookupWithDefault(Stella.KWD_LANGUAGE, language)));
      plist.insertAt(Stella.KWD_LANGUAGE, language);
      plist.insertAt(Stella.KWD_ACTION, plist.lookupWithDefault(Stella.KWD_ACTION, Stella.KWD_TRANSLATE_SYSTEM));
      { Stella_Object key = null;
        Stella_Object value = null;
        Cons iter000 = plist.thePlist;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
          key = iter000.value;
          value = iter000.rest.value;
          { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(key));

            if (testValue000 == Stella.KWD_TWO_PASSp) {
              twopassP = Stella_Object.eqlP(value, Stella.TRUE_WRAPPER);
            }
            else if (testValue000 == Stella.KWD_FORCE_TRANSLATIONp) {
              forcetranslationP = Stella_Object.eqlP(value, Stella.TRUE_WRAPPER);
            }
            else if (testValue000 == Stella.KWD_PRODUCTION_SETTINGSp) {
              productionmodeP = Stella_Object.eqlP(value, Stella.TRUE_WRAPPER);
            }
            else if (testValue000 == Stella.KWD_DEVELOPMENT_SETTINGSp) {
              productionmodeP = !Stella_Object.eqlP(value, Stella.TRUE_WRAPPER);
            }
            else {
            }
          }
        }
      }
      { Object old$Translatoroutputlanguage$000 = Stella.$TRANSLATOROUTPUTLANGUAGE$.get();
        Object old$Translationphase$000 = Stella.$TRANSLATIONPHASE$.get();
        Object old$Safety$000 = Stella.$SAFETY$.get();
        Object old$RecyclingEnabledP$000 = Stella.$RECYCLING_ENABLEDp$.get();
        Object old$CurrentStellaFeatures$000 = Stella.$CURRENT_STELLA_FEATURES$.get();
        Object old$CurrentSystemAction$000 = Stella.$CURRENT_SYSTEM_ACTION$.get();

        try {
          Native.setSpecial(Stella.$TRANSLATOROUTPUTLANGUAGE$, ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())));
          Native.setSpecial(Stella.$TRANSLATIONPHASE$, null);
          Native.setIntSpecial(Stella.$SAFETY$, ((Integer)(Stella.$SAFETY$.get())).intValue());
          Native.setBooleanSpecial(Stella.$RECYCLING_ENABLEDp$, !(language == Stella.KWD_JAVA));
          Native.setSpecial(Stella.$CURRENT_STELLA_FEATURES$, ((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).copy());
          Native.setSpecial(Stella.$CURRENT_SYSTEM_ACTION$, plist.copy());
          if (!Stella.systemLoadedOrStartedUpP(systemname)) {
            twopassP = true;
          }
          Stella.$GENSYM_COUNTER$ = -1;
          Stella.setStellaFeature(Cons.cons(Stella.KWD_TRANSLATE_WITH_COPYRIGHT_HEADER, Cons.cons(Stella.KWD_WARN_ABOUT_MISSING_METHODS, Cons.cons(Stella.KWD_WARN_ABOUT_UNDEFINED_METHODS, Stella.NIL))));
          Stella.unsetStellaFeature(Cons.cons(Stella.KWD_USE_HARDCODED_SYMBOLS, Stella.NIL));
          Keyword.setTranslatorOutputLanguage(language);
          { Object old$Currentsystemdefinition$000 = Stella.$CURRENTSYSTEMDEFINITION$.get();
            Object old$Currentsystemdefinitionsubdirectory$000 = Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.get();

            try {
              Native.setSpecial(Stella.$CURRENTSYSTEMDEFINITION$, Stella.getSystemDefinition(systemname));
              Native.setSpecial(Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$, ((((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null) ? ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).directory : null));
              if (((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null) {
                {
                  SystemDefinition.computeOptimizationLevels(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())), productionmodeP);
                  { Cons files = Cons.filesPlusSystemStartup(SystemDefinition.systemDefinitionSourceFiles(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get()))));
                    boolean translatedsomethingP = false;

                    if (forcetranslationP ||
                        Stella.systemNeedsTranslationP(systemname, language)) {
                      SystemDefinition.createSystemStartupFile(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())));
                      translatedsomethingP = Cons.helpTranslateSystem(files, twopassP, forcetranslationP);
                    }
                    Keyword.transferNativeSystemFiles(language);
                    Keyword.transferDataFiles(language);
                    return (translatedsomethingP);
                  }
                }
              }
              else {
                {
                  Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't find a system named `" + systemname + "'");
                  Stella.STANDARD_WARNING.nativeStream.println();
                }
;
              }

            } finally {
              Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.set(old$Currentsystemdefinitionsubdirectory$000);
              Stella.$CURRENTSYSTEMDEFINITION$.set(old$Currentsystemdefinition$000);
            }
          }
          return (false);

        } finally {
          Stella.$CURRENT_SYSTEM_ACTION$.set(old$CurrentSystemAction$000);
          Stella.$CURRENT_STELLA_FEATURES$.set(old$CurrentStellaFeatures$000);
          Stella.$RECYCLING_ENABLEDp$.set(old$RecyclingEnabledP$000);
          Stella.$SAFETY$.set(old$Safety$000);
          Stella.$TRANSLATIONPHASE$.set(old$Translationphase$000);
          Stella.$TRANSLATOROUTPUTLANGUAGE$.set(old$Translatoroutputlanguage$000);
        }
      }
    }
  }

  public static Cons parseDirectoryPath(String path) {
    { char separator = '|';
      int length = path.length();
      int start = 0;
      int end = 0;
      Cons parsedpath = Stella.NIL;

      loop000 : for (;;) {
        end = Native.string_position(path, separator, start);
        parsedpath = Cons.cons(StringWrapper.wrapString(Stella.fileNameAsDirectory(Native.string_subsequence(path, start, end))), parsedpath);
        if ((end != Stella.NULL_INTEGER) &&
            (end < (length - 1))) {
          start = end + 1;
        }
        else {
          break loop000;
        }
      }
      return (parsedpath.reverse());
    }
  }

  /** Set the STELLA load path to the |-separated
   * directories listed in <code>path</code>.  Return the resulting load path.
   * @param path
   * @return Cons
   */
  public static Cons setLoadPath(String path) {
    Stella.$FILE_LOAD_PATH$ = Stella.parseDirectoryPath(path);
    return (Stella.$FILE_LOAD_PATH$);
  }

  /** Return the current STELLA load path.
   * @return Cons
   */
  public static Cons getLoadPath() {
    return (Stella.$FILE_LOAD_PATH$);
  }

  /** Add the directories listed in the |-separated
   * <code>path</code> to the front of the STELLA load path.  Return the
   * resulting load path.
   * @param path
   * @return Cons
   */
  public static Cons pushLoadPath(String path) {
    Stella.$FILE_LOAD_PATH$ = Stella.parseDirectoryPath(path).concatenate(Stella.$FILE_LOAD_PATH$, Stella.NIL);
    return (Stella.$FILE_LOAD_PATH$);
  }

  /** Remove the first element from the STELLA load path
   * and return the removed element.
   * @return String
   */
  public static String popLoadPath() {
    { StringWrapper head000 = ((StringWrapper)(Stella.$FILE_LOAD_PATH$.value));

      Stella.$FILE_LOAD_PATH$ = Stella.$FILE_LOAD_PATH$.rest;
      { StringWrapper value000 = head000;

        return (value000.wrapperValue);
      }
    }
  }

  /** Append the directories listed in the |-separated
   * <code>path</code> to the end of the STELLA load path.  Return the resulting
   * load path.
   * @param path
   * @return Cons
   */
  public static Cons addLoadPath(String path) {
    Stella.$FILE_LOAD_PATH$ = Stella.$FILE_LOAD_PATH$.concatenate(Stella.parseDirectoryPath(path), Stella.NIL);
    return (Stella.$FILE_LOAD_PATH$);
  }

  /** Remove the directories listed in the |-separated
   * <code>path</code> from the PowerLoom load path.
   * @param path
   * @return Cons
   */
  public static Cons dropLoadPath(String path) {
    { StringWrapper dir = null;
      Cons iter000 = Stella.parseDirectoryPath(path);

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        dir = ((StringWrapper)(iter000.value));
        Stella.$FILE_LOAD_PATH$ = Stella.$FILE_LOAD_PATH$.remove(dir);
      }
    }
    return (Stella.$FILE_LOAD_PATH$);
  }

  /** Try to find <code>file</code> in the current load path and, if found,
   * return its full name.  If <code>file</code> can't be found literally, try to find it
   * with any of the listed <code>extensions</code> added.  If <code>extensions</code> is NULL it defaults
   * to <code>$STELLA_FILE_EXTENSIONS$</code>, therefore, to not default to any extensions
   * the value has to be supplied as NIL.
   * @param file
   * @param extensions
   * @return String
   */
  public static String findFileInLoadPath(String file, Cons extensions) {
    { String expandedfile = file;

      if (extensions == null) {
        extensions = Stella.$STELLA_FILE_EXTENSIONS$;
      }
      { Stella_Object dir = null;
        Cons iter000 = Cons.cons(StringWrapper.wrapString(""), Stella.$FILE_LOAD_PATH$);

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          dir = iter000.value;
          try {
            expandedfile = StringWrapper.unwrapString(((StringWrapper)(dir))) + file;
            if (Stella.probeFileP(expandedfile)) {
              return (expandedfile);
            }
            { StringWrapper ext = null;
              Cons iter001 = extensions;

              for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                ext = ((StringWrapper)(iter001.value));
                expandedfile = StringWrapper.unwrapString(((StringWrapper)(dir))) + file + ext.wrapperValue;
                if (Stella.probeFileP(expandedfile)) {
                  return (expandedfile);
                }
              }
            }
          } catch (java.lang.Exception e) {
            e = e;
          }
        }
      }
      return (null);
    }
  }

  /** Read STELLA commands from <code>file</code> and evaluate them.
   * The file should begin with an <code>inModule</code> declaration that specifies
   * the module within which all remaining commands are to be evaluated
   * The remaining commands are evaluated one-by-one, applying the function
   * <code>evaluate</code> to each of them.
   * @param file
   */
  public static void loadFile(String file) {
    { String temp000 = Stella.findFileInLoadPath(file, null);

      file = ((temp000 != null) ? temp000 : file);
    }
    Stella.ensureFileExists(file, "load-file");
    { boolean toplevelinvocationP = ((String)(Stella.$CURRENTFILE$.get())) == null;
      boolean skipcommandP = false;
      boolean seeninmoduleP = false;
      Cons commands = Stella.NIL;
      InputFileStream inputstream = null;

      try {
        { Object old$Currentfile$000 = Stella.$CURRENTFILE$.get();

          try {
            Native.setSpecial(Stella.$CURRENTFILE$, Stella.fileBaseName(file));
            inputstream = InputFileStream.newInputFileStream(file);
            { Object old$Module$000 = Stella.$MODULE$.get();
              Object old$Context$000 = Stella.$CONTEXT$.get();

              try {
                Native.setSpecial(Stella.$MODULE$, ((Module)(Stella.$MODULE$.get())));
                Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
                { Stella_Object tree = null;
                  SExpressionIterator iter000 = InputStream.sExpressions(inputstream);

                  loop000 : while (iter000.nextP()) {
                    tree = iter000.value;
                    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
                      { Cons tree000 = ((Cons)(tree));

                        { Object [] caller_MV_returnarray = new Object[1];

                          skipcommandP = Cons.handleInModuleTree(tree000, seeninmoduleP, true, caller_MV_returnarray);
                          seeninmoduleP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[0])).wrapperValue));
                        }
                        if (skipcommandP) {
                          continue loop000;
                        }
                        { Stella_Object operator = tree000.value;

                          if (Surrogate.subtypeOfSymbolP(Stella_Object.safePrimaryType(operator))) {
                            { Symbol operator000 = ((Symbol)(operator));

                              if ((operator000 == Stella.SYM_STELLA_DEFMODULE) ||
                                  ((operator000 == Stella.SYM_STELLA_DEFSYSTEM) ||
                                   ((operator000 == Stella.SYM_STELLA_DEFCLASS) ||
                                    ((operator000 == Stella.SYM_STELLA_DEFSLOT) ||
                                     ((operator000 == Stella.SYM_STELLA_DEFUN) ||
                                      (operator000 == Stella.SYM_STELLA_DEFMETHOD)))))) {
                                Stella_Object.evaluateCommand(tree000, false);
                              }
                              else {
                                if (Symbol.lookupCommand(operator000) != null) {
                                  commands = Cons.cons(tree000, commands);
                                }
                                else {
                                  Stella_Object.evaluateCommand(tree000, false);
                                }
                              }
                            }
                          }
                          else {
                            Stella_Object.evaluateCommand(tree000, false);
                          }
                        }
                      }
                    }
                    else {
                      Stella_Object.evaluateCommand(tree, false);
                    }
                  }
                }
                { Object old$Translationphase$000 = Stella.$TRANSLATIONPHASE$.get();

                  try {
                    Native.setSpecial(Stella.$TRANSLATIONPHASE$, Stella.KWD_FINALIZE);
                    SystemDefinition.runSystemFinalization(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())));

                  } finally {
                    Stella.$TRANSLATIONPHASE$.set(old$Translationphase$000);
                  }
                }
                { boolean finalizeP = ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null;

                  { Stella_Object tree = null;
                    Cons iter001 = commands.reverse();

                    for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                      tree = iter001.value;
                      Stella_Object.evaluateCommand(tree, finalizeP);
                    }
                  }
                }

              } finally {
                Stella.$CONTEXT$.set(old$Context$000);
                Stella.$MODULE$.set(old$Module$000);
              }
            }

          } finally {
            Stella.$CURRENTFILE$.set(old$Currentfile$000);
          }
        }

      } finally {
        if (toplevelinvocationP) {
          Stella.sweepTransients();
        }
        if (inputstream != null) {
          inputstream.free();
        }
      }
    }
  }

  public static String makeSystemDefinitionFileName(String name) {
    return (Stella.systemDefinitionsDirectory() + Stella.directorySeparatorString() + Native.stringDowncase(name) + "-system.ste");
  }

  public static SystemDefinition getSystemDefinition(String name) {
    { SystemDefinition value000 = null;

      { SystemDefinition s = null;
        Cons iter000 = Stella.$SYSTEMDEFINITIONS$.theConsList;

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          s = ((SystemDefinition)(iter000.value));
          if (Stella.stringEqualP(s.name, name)) {
            value000 = s;
            break loop000;
          }
        }
      }
      { SystemDefinition system = value000;

        if (system == null) {
          { String systemfilename = Stella.makeSystemDefinitionFileName(name);

            if (!Stella.probeFileP(systemfilename)) {
              {
                Stella.STANDARD_ERROR.nativeStream.println("ERROR>> File " + systemfilename + " does not exist.");
                Stella.STANDARD_ERROR.nativeStream.println("   Can't define system " + name);
              }
;
              return (null);
            }
            Stella.loadFile(systemfilename);
            { SystemDefinition value001 = null;

              { SystemDefinition s = null;
                Cons iter001 = Stella.$SYSTEMDEFINITIONS$.theConsList;

                loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                  s = ((SystemDefinition)(iter001.value));
                  if (Stella.stringEqualP(s.name, name)) {
                    value001 = s;
                    break loop001;
                  }
                }
              }
              system = value001;
            }
            if (system == null) {
              {
                Stella.STANDARD_ERROR.nativeStream.println("ERROR>>  Can't find a system definition for system " + name);
                Stella.STANDARD_ERROR.nativeStream.println("   within file " + systemfilename + ".");
              }
;
            }
          }
        }
        return (system);
      }
    }
  }

  public static void helpGetSystemFiles(String filename, List collection, boolean probefileP) {
    if ((!probefileP) ||
        Stella.probeFileP(filename)) {
      collection.push(StringWrapper.wrapString(filename));
    }
  }

  public static void cleanSystem(String systemname) {
    { SystemDefinition system = Stella.getSystemDefinition(systemname);

      if (system == null) {
        return;
      }
      { StringWrapper f = null;
        Cons iter000 = SystemDefinition.getSystemFiles(system, Stella.KWD_LISP, true).theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          f = ((StringWrapper)(iter000.value));
          Stella.deleteFile(f.wrapperValue);
        }
      }
      { StringWrapper f = null;
        Cons iter001 = SystemDefinition.getSystemFiles(system, Stella.KWD_JAVA, true).theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          f = ((StringWrapper)(iter001.value));
          Stella.deleteFile(f.wrapperValue);
        }
      }
      { StringWrapper f = null;
        Cons iter002 = SystemDefinition.getSystemFiles(system, Stella.KWD_CPP, true).theConsList;

        for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
          f = ((StringWrapper)(iter002.value));
          Stella.deleteFile(f.wrapperValue);
        }
      }
      { StringWrapper f = null;
        Cons iter003 = SystemDefinition.getSystemFiles(system, Stella.KWD_LISP_BINARY, true).theConsList;

        for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
          f = ((StringWrapper)(iter003.value));
          Stella.deleteFile(f.wrapperValue);
        }
      }
    }
  }

  /** Translate all out-of-date files of system <code>systemname</code>
   * into <code>language</code> (the first optional argument of <code>languageAoptions</code>) and
   * then compile and load them (the latter is only possible for Lisp right now).
   * The following keyword/value <code>options</code> are recognized:
   * <p>
   * <code>Clanguage</code>: can be used as an alternative to the optional language argument.
   * If not specified, the language of the running implementation is assumed.
   * <p>
   * <code>CtwoPassP</code>: if true, all files will be scanned twice, once to
   * load the signatures of objects defined in them, and once to actually
   * translate the definitions.  Otherwise, the translator will make one pass in
   * the case that the system is already loaded (and is being remade), and two
   * passes otherwise.
   * <p>
   * <code>CdevelopmentSettingsP</code> (default false): if true translation will favor
   * safe, readable and debuggable code over efficiency (according to the value
   * of <code>CdevelopmentSettings</code> on the system definition).  If false, efficiency
   * will be favored instead (according to the value of <code>CproductionSettings</code>
   * on the system definition).
   * <p>
   * <code>CproductionSettingsP</code> (default true): inverse to <code>CdevelopmentSettingsP</code>.
   * <p>
   * <code>CforceTranslationP</code> (default false): if true, files will be translated
   * whether or not their translations are up-to-date.
   * <p>
   * <code>CforceRecompilationP</code> (default false): if true, translated files will be
   * recompiled whether or not their compilations are up-to-date (only supported
   * in Lisp right now).
   * <p>
   * <code>CloadSystemP</code> (default true): if true, compiled files will be loaded into
   * the current STELLA image (only supported in Lisp and Java right now).
   * <p>
   * <code>CstartupP</code> (default true): if true, the system startup function will
   * be called once all files have been loaded.
   * @param systemname
   * @param languageAoptions
   * @return boolean
   */
  public static boolean makeSystem(String systemname, Cons languageAoptions) {
    { Cons options = languageAoptions;
      Keyword language = (Stella.getQuotedTree("((:COMMON-LISP :CPP :JAVA) \"/STELLA\")", "/STELLA").memberP(options.value) ? ((Keyword)(options.value)) : Stella.runningInLanguage());
      PropertyList plist = Stella_Object.vetOptions(((options.value == language) ? options.rest : options), Stella.getQuotedTree("((:TWO-PASS? :DEVELOPMENT-SETTINGS? :PRODUCTION-SETTINGS? :FORCE-TRANSLATION? :FORCE-RECOMPILATION? :LOAD-SYSTEM? :LANGUAGE :ACTION) \"/STELLA\")", "/STELLA"));
      boolean developmentsettingsP = false;
      boolean forcetranslationP = false;
      boolean forcerecompilationP = false;
      boolean twopassP = !Stella.systemLoadedOrStartedUpP(systemname);
      boolean loadsystemP = false;
      boolean startupsystemP = false;
      SystemDefinition system = null;
      boolean updatedsystemP = false;

      language = ((Keyword)(plist.lookupWithDefault(Stella.KWD_LANGUAGE, language)));
      plist.insertAt(Stella.KWD_LANGUAGE, language);
      loadsystemP = language == Stella.KWD_COMMON_LISP;
      startupsystemP = language == Stella.KWD_COMMON_LISP;
      plist.insertAt(Stella.KWD_ACTION, plist.lookupWithDefault(Stella.KWD_ACTION, Stella.KWD_MAKE_SYSTEM));
      { Stella_Object key = null;
        Stella_Object value = null;
        Cons iter000 = plist.thePlist;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
          key = iter000.value;
          value = iter000.rest.value;
          { boolean truevalueP = Stella_Object.eqlP(value, Stella.TRUE_WRAPPER);

            { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(key));

              if (testValue000 == Stella.KWD_DEVELOPMENT_SETTINGSp) {
                developmentsettingsP = truevalueP;
              }
              else if (testValue000 == Stella.KWD_PRODUCTION_SETTINGSp) {
                developmentsettingsP = !truevalueP;
              }
              else if (testValue000 == Stella.KWD_FORCE_TRANSLATIONp) {
                forcetranslationP = truevalueP;
              }
              else if (testValue000 == Stella.KWD_FORCE_RECOMPILATIONp) {
                forcerecompilationP = truevalueP;
              }
              else if (testValue000 == Stella.KWD_TWO_PASSp) {
                twopassP = truevalueP;
              }
              else if (testValue000 == Stella.KWD_LOAD_SYSTEMp) {
                loadsystemP = truevalueP;
              }
              else if (testValue000 == Stella.KWD_STARTUPp) {
                startupsystemP = truevalueP;
              }
              else {
              }
            }
          }
        }
      }
      { Object old$CurrentSystemAction$000 = Stella.$CURRENT_SYSTEM_ACTION$.get();

        try {
          Native.setSpecial(Stella.$CURRENT_SYSTEM_ACTION$, plist.copy());
          system = Stella.getSystemDefinition(systemname);
          if (system == null) {
            {
              Stella.STANDARD_OUTPUT.nativeStream.println("Can't find a declaration for system named " + systemname);
              Stella.STANDARD_OUTPUT.nativeStream.println("  Possibly a global path name needs to be set.");
            }
;
            return (false);
          }
          if (forcerecompilationP ||
              ((!Stella.systemLoadedOrStartedUpP(systemname)) &&
               (forcetranslationP ||
                Stella.systemNeedsTranslationP(systemname, language)))) {
            Stella.loadPreprocessedFiles(systemname);
          }
          updatedsystemP = Stella.translateSystem(systemname, Cons.cons(language, Cons.cons(Stella.KWD_TWO_PASSp, Cons.cons((twopassP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Cons.cons(Stella.KWD_FORCE_TRANSLATIONp, Cons.cons((forcetranslationP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Cons.cons(Stella.KWD_DEVELOPMENT_SETTINGSp, Cons.cons((developmentsettingsP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.NIL))))))));
          if (loadsystemP &&
              Stella.loadSystem(systemname, Cons.cons(language, Cons.cons(Stella.KWD_FORCE_RECOMPILATIONp, Cons.cons((forcerecompilationP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Cons.cons(Stella.KWD_STARTUPp, Cons.cons((startupsystemP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.NIL))))))) {
            updatedsystemP = true;
          }
          return (updatedsystemP);

        } finally {
          Stella.$CURRENT_SYSTEM_ACTION$.set(old$CurrentSystemAction$000);
        }
      }
    }
  }

  /** Return <code>true</code> if system <code>name</code> has been loaded.
   * @param name
   * @return boolean
   */
  public static boolean systemLoadedP(String name) {
    { boolean testValue000 = false;

      if (Stella.stringEqualP(name, "STELLA")) {
        testValue000 = true;
      }
      else {
        { boolean foundP000 = false;

          { SystemDefinition sys = null;
            Cons iter000 = Stella.$SYSTEMDEFINITIONS$.theConsList;

            loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              sys = ((SystemDefinition)(iter000.value));
              if (Stella.stringEqualP(sys.name, name) &&
                  sys.loadedP) {
                foundP000 = true;
                break loop000;
              }
            }
          }
          testValue000 = foundP000;
        }
      }
      { boolean value000 = testValue000;

        return (value000);
      }
    }
  }

  /** Return <code>true</code> if system <code>name</code> has either been loaded
   * or initialized with its startup function.
   * @param name
   * @return boolean
   */
  public static boolean systemLoadedOrStartedUpP(String name) {
    { boolean testValue000 = false;

      if (Stella.stringEqualP(name, "STELLA")) {
        testValue000 = true;
      }
      else {
        { boolean foundP000 = false;

          { SystemDefinition sys = null;
            Cons iter000 = Stella.$SYSTEMDEFINITIONS$.theConsList;

            loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              sys = ((SystemDefinition)(iter000.value));
              if (Stella.stringEqualP(sys.name, name) &&
                  (sys.loadedP ||
                   Stella.systemStartedUpP(sys.name, sys.cardinalModule))) {
                foundP000 = true;
                break loop000;
              }
            }
          }
          testValue000 = foundP000;
        }
      }
      { boolean value000 = testValue000;

        return (value000);
      }
    }
  }

  /** Clears out the system definition named <code>name</code>.  If
   * <code>name</code> is <code>null</code>, then clear out all system definitions.  This function
   * is useful when changes have been made to the system definition, and one
   * wants to have it reloaded from the standard location in the file system.
   * @param name
   */
  public static void clearSystem(String name) {
    if (name == null) {
      Stella.$SYSTEMDEFINITIONS$ = List.newList();
    }
    else {
      { SystemDefinition value000 = null;

        { SystemDefinition s = null;
          Cons iter000 = Stella.$SYSTEMDEFINITIONS$.theConsList;

          loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            s = ((SystemDefinition)(iter000.value));
            if (Stella.stringEqlP(s.name, name)) {
              value000 = s;
              break loop000;
            }
          }
        }
        { SystemDefinition sys = value000;

          if (sys != null) {
            Stella.$SYSTEMDEFINITIONS$.remove(sys);
          }
        }
      }
    }
  }

  public static void loadPreprocessedFiles(String systemname) {
    if ((!Stella.runningAsLispP()) ||
        (Stella.getSystemDefinition(systemname).preprocessedFiles == null)) {
      return;
    }
    { Object old$Translatoroutputlanguage$000 = Stella.$TRANSLATOROUTPUTLANGUAGE$.get();

      try {
        Native.setSpecial(Stella.$TRANSLATOROUTPUTLANGUAGE$, Stella.KWD_COMMON_LISP);
        { Object old$Currentsystemdefinition$000 = Stella.$CURRENTSYSTEMDEFINITION$.get();
          Object old$Currentsystemdefinitionsubdirectory$000 = Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.get();

          try {
            Native.setSpecial(Stella.$CURRENTSYSTEMDEFINITION$, Stella.getSystemDefinition(systemname));
            Native.setSpecial(Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$, ((((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null) ? ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).directory : null));
            if (((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null) {
              {
                { Cons preprocessedfiles = Stella.NIL;

                  { StringWrapper f = null;
                    Cons iter000 = ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).preprocessedFiles;
                    Cons collect000 = null;

                    for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                      f = ((StringWrapper)(iter000.value));
                      if (collect000 == null) {
                        {
                          collect000 = Cons.cons(StringWrapper.wrapString(Stella.makeFileName(f.wrapperValue, Stella.KWD_STELLA, true)), Stella.NIL);
                          if (preprocessedfiles == Stella.NIL) {
                            preprocessedfiles = collect000;
                          }
                          else {
                            Cons.addConsToEndOfConsList(preprocessedfiles, collect000);
                          }
                        }
                      }
                      else {
                        {
                          collect000.rest = Cons.cons(StringWrapper.wrapString(Stella.makeFileName(f.wrapperValue, Stella.KWD_STELLA, true)), Stella.NIL);
                          collect000 = collect000.rest;
                        }
                      }
                    }
                  }
                  { Object old$CurrentStellaFeatures$000 = Stella.$CURRENT_STELLA_FEATURES$.get();

                    try {
                      Native.setSpecial(Stella.$CURRENT_STELLA_FEATURES$, ((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).copy());
                      Stella.unsetStellaFeature(Cons.cons(Stella.KWD_WARN_ABOUT_UNDEFINED_METHODS, Stella.NIL));
                      { Stella_Object f = null;
                        Cons iter001 = preprocessedfiles;

                        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                          f = iter001.value;
                          Stella.translateFile(((StringWrapper)(f)).wrapperValue, ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())), false);
                        }
                      }

                    } finally {
                      Stella.$CURRENT_STELLA_FEATURES$.set(old$CurrentStellaFeatures$000);
                    }
                  }
                  Cons.compileAndLoadFiles(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).preprocessedFiles, ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())), false);
                  if (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_STRUCTS)) {
                    { StringWrapper f = null;
                      Cons iter002 = ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).preprocessedFiles;

                      for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                        f = ((StringWrapper)(iter002.value));
                        Stella.deleteFile(Stella.makeFileName(f.wrapperValue, Stella.KWD_LISP, true));
                      }
                    }
                  }
                  { Symbol startupfn = null;
                    Cons iter003 = Cons.startupNamesFromFiles(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).preprocessedFiles);

                    for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
                      startupfn = ((Symbol)(iter003.value));
                    }
                  }
                }
              }
            }
            else {
              {
                Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't find a system named `" + systemname + "'");
                Stella.STANDARD_WARNING.nativeStream.println();
              }
;
            }

          } finally {
            Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.set(old$Currentsystemdefinitionsubdirectory$000);
            Stella.$CURRENTSYSTEMDEFINITION$.set(old$Currentsystemdefinition$000);
          }
        }

      } finally {
        Stella.$TRANSLATOROUTPUTLANGUAGE$.set(old$Translatoroutputlanguage$000);
      }
    }
  }

  /** Natively <code>language</code>-compile out-of-date translated files of system
   * <code>systemname</code> (only supported for Lisp at the moment) and then load them
   * into the running system.  Return true if at least one file was compiled.
   * The following keyword/value <code>options</code> are recognized:
   * <p>
   * <code>Clanguage</code>: can be used as an alternative to the optional language argument.
   * If not specified, the language of the running implementation is assumed.
   * <p>
   * <code>CforceRecompilationP</code> (default false): if true, files will be compiled
   * whether or not their compilations are up-to-date.
   * <p>
   * <code>CstartupP</code> (default true): if true, the system startup function will
   * be called once all files have been loaded.
   * @param systemname
   * @param languageAoptions
   * @return boolean
   */
  public static boolean loadSystem(String systemname, Cons languageAoptions) {
    { Cons options = languageAoptions;
      Keyword language = (Stella.getQuotedTree("((:COMMON-LISP :CPP :JAVA) \"/STELLA\")", "/STELLA").memberP(options.value) ? ((Keyword)(options.value)) : Stella.runningInLanguage());
      PropertyList plist = Stella_Object.vetOptions(((options.value == language) ? options.rest : options), Stella.getQuotedTree("((:FORCE-RECOMPILATION? :STARTUP? :LANGUAGE :ACTION) \"/STELLA\")", "/STELLA"));
      boolean forcerecompilationP = false;
      boolean startupsystemP = true;
      boolean translatedfileP = false;

      language = ((Keyword)(plist.lookupWithDefault(Stella.KWD_LANGUAGE, language)));
      plist.insertAt(Stella.KWD_LANGUAGE, language);
      plist.insertAt(Stella.KWD_ACTION, plist.lookupWithDefault(Stella.KWD_ACTION, Stella.KWD_LOAD_SYSTEM));
      { Stella_Object key = null;
        Stella_Object value = null;
        Cons iter000 = plist.thePlist;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
          key = iter000.value;
          value = iter000.rest.value;
          { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(key));

            if (testValue000 == Stella.KWD_FORCE_RECOMPILATIONp) {
              forcerecompilationP = Stella_Object.eqlP(value, Stella.TRUE_WRAPPER);
            }
            else if (testValue000 == Stella.KWD_STARTUPp) {
              startupsystemP = Stella_Object.eqlP(value, Stella.TRUE_WRAPPER);
            }
            else {
            }
          }
        }
      }
      { Object old$CurrentSystemAction$000 = Stella.$CURRENT_SYSTEM_ACTION$.get();

        try {
          Native.setSpecial(Stella.$CURRENT_SYSTEM_ACTION$, plist.copy());
          { Object old$Currentsystemdefinition$000 = Stella.$CURRENTSYSTEMDEFINITION$.get();
            Object old$Currentsystemdefinitionsubdirectory$000 = Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.get();

            try {
              Native.setSpecial(Stella.$CURRENTSYSTEMDEFINITION$, Stella.getSystemDefinition(systemname));
              Native.setSpecial(Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$, ((((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null) ? ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).directory : null));
              if (((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null) {
                {
                  if (((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).loadedP) {
                    {
                      Stella.STANDARD_OUTPUT.nativeStream.println("Loading system `" + systemname + "' over top of itself.");
                      Stella.STANDARD_OUTPUT.nativeStream.println();
                    }
;
                  }
                  if (Stella.runningAsLispP()) {
                    translatedfileP = Cons.compileAndLoadFiles(Cons.filesPlusSystemStartup(SystemDefinition.systemDefinitionNativeFiles(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())))), language, forcerecompilationP);
                  }
                  ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).loadedP = true;
                  if (startupsystemP) {
                    SystemDefinition.runSystemStartupFunction(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())));
                  }
                }
              }
              else {
                {
                  Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't find a system named `" + systemname + "'");
                  Stella.STANDARD_WARNING.nativeStream.println();
                }
;
              }

            } finally {
              Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.set(old$Currentsystemdefinitionsubdirectory$000);
              Stella.$CURRENTSYSTEMDEFINITION$.set(old$Currentsystemdefinition$000);
            }
          }
          return (translatedfileP);

        } finally {
          Stella.$CURRENT_SYSTEM_ACTION$.set(old$CurrentSystemAction$000);
        }
      }
    }
  }

  public static String string_systemStartupFunctionName(String systemname) {
    return ("STARTUP-" + Native.stringUpcase(systemname) + "-SYSTEM");
  }

  public static Symbol startupNameFromFile(String file) {
    if (!Stella.probeFileP(Stella.makeFileName(file, Stella.KWD_STELLA, true))) {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("STELLA source file `" + Stella.makeFileName(file, Stella.KWD_STELLA, true) + "' does not exist");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    { String longname = Stella.makeFileName(file, Stella.KWD_STELLA, true);
      Module savedmodule = ((Module)(Stella.$MODULE$.get()));
      boolean seeninmoduleP = false;
      boolean unusedP = false;
      Symbol startupfnname = null;

      { InputFileStream inputstream = null;

        try {
          inputstream = Stella.openInputFile(longname, Stella.NIL);
          { Object old$TransientobjectsP$000 = Stella.$TRANSIENTOBJECTSp$.get();

            try {
              Native.setBooleanSpecial(Stella.$TRANSIENTOBJECTSp$, true);
              { Stella_Object tree = null;
                SExpressionIterator iter000 = InputStream.sExpressions(inputstream);

                while (iter000.nextP()) {
                  tree = iter000.value;
                  { Object old$TransientobjectsP$001 = Stella.$TRANSIENTOBJECTSp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$TRANSIENTOBJECTSp$, false);
                      if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
                        { Cons tree000 = ((Cons)(tree));

                          { Object [] caller_MV_returnarray = new Object[1];

                            unusedP = Cons.handleInModuleTree(tree000, seeninmoduleP, true, caller_MV_returnarray);
                            seeninmoduleP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[0])).wrapperValue));
                          }
                          unusedP = unusedP;
                          if (seeninmoduleP) {
                            startupfnname = Stella.yieldStartupFunctionName(file);
                            savedmodule.changeModule();
                            return (startupfnname);
                          }
                        }
                      }
                      else {
                      }

                    } finally {
                      Stella.$TRANSIENTOBJECTSp$.set(old$TransientobjectsP$001);
                    }
                  }
                }
              }

            } finally {
              Stella.$TRANSIENTOBJECTSp$.set(old$TransientobjectsP$000);
            }
          }

        } finally {
          if (inputstream != null) {
            inputstream.free();
          }
        }
      }
      {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Missing IN-MODULE declaration for file `" + file + "'");
        Stella.STANDARD_WARNING.nativeStream.println();
      }
;
    }
    return (null);
  }

  public static boolean systemStartupFileP(String file) {
    if (file == null) {
      file = ((String)(Stella.$CURRENTFILE$.get()));
    }
    return ((file != null) &&
        Stella.stringEqlP(Stella.fileBaseName(file), SystemDefinition.systemStartupFileName(null)));
  }

  public static boolean systemStartedUpP(String systemname, String systemmodulename) {
    if (Stella.$FUNCTION_LOOKUP_TABLE$ == null) {
      return (false);
    }
    if (Stella.stringEqualP(systemname, "STELLA")) {
      return (Stella.$FUNCTION_LOOKUP_TABLE$ != null);
    }
    if (Stella.getStellaModule(systemmodulename, false) == null) {
      return (false);
    }
    { Symbol startupfunctionsymbol = Symbol.lookupSymbolInModule(Stella.string_systemStartupFunctionName(systemname), Stella.getStellaModule(systemmodulename, false), true);
      MethodSlot startupfunction = ((startupfunctionsymbol != null) ? Symbol.lookupFunction(startupfunctionsymbol) : ((MethodSlot)(null)));

      return ((startupfunction != null) &&
          (startupfunction.functionCode != null));
    }
  }

  public static List helpAllRequiredSystems(String systemName, List found) {
    { SystemDefinition system = Stella.getSystemDefinition(systemName);

      if (system == null) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Couldn't find system `" + systemName + "'");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      { Cons requiredSystemNames = system.requiredSystems;

        if (requiredSystemNames != null) {
          { StringWrapper sys = null;
            Cons iter000 = requiredSystemNames;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              sys = ((StringWrapper)(iter000.value));
              if (!found.memberP(sys)) {
                Stella.helpAllRequiredSystems(sys.wrapperValue, found);
                found.push(sys);
              }
            }
          }
        }
        return (found);
      }
    }
  }

  /** Returns a CONS of all of the systems required by <code>systemName</code>
   * @param systemName
   * @return Cons
   */
  public static Cons allRequiredSystems(String systemName) {
    return (Stella.helpAllRequiredSystems(systemName, List.newList()).theConsList);
  }

  /** Autoload function <code>qualifiedname</code> from system <code>systemname</code>.
   * If it is already present in the system, simply return its code.  If <code>cache</code>
   * is defined, return its value if defined, otherwise, set its value to the
   * function found.  If the function failed to be defined by loading <code>systemname</code>
   * and <code>errorP</code> is true, raise an error.  Otherwise, simply return NULL.
   * @param qualifiedname
   * @param systemname
   * @param cache
   * @param errorP
   * @return java.lang.reflect.Method
   */
  public static java.lang.reflect.Method autoload(String qualifiedname, String systemname, Surrogate cache, boolean errorP) {
    { java.lang.reflect.Method function = null;

      if (cache != null) {
        { FunctionCodeWrapper functionwrapper = ((FunctionCodeWrapper)(cache.surrogateValue));

          if (functionwrapper != null) {
            return (functionwrapper.wrapperValue);
          }
        }
      }
      try {
        { String functionname = null;
          String functionmodulename = null;
          Keyword type = null;

          { Object [] caller_MV_returnarray = new Object[2];

            functionname = Stella.parseStellaName(qualifiedname, false, caller_MV_returnarray);
            functionmodulename = ((String)(((StringWrapper)(caller_MV_returnarray[0])).wrapperValue));
            type = ((Keyword)(caller_MV_returnarray[1]));
          }
          type = type;
          { Module functionmodule = null;
            Symbol functionnamesymbol = null;
            MethodSlot functionobject = null;

            if (functionmodulename != null) {
              functionmodule = Stella.getStellaModule(functionmodulename, errorP &&
                  (systemname == null));
            }
            if (functionmodule != null) {
              functionnamesymbol = Symbol.lookupSymbolInModule(functionname, functionmodule, false);
            }
            if (functionnamesymbol != null) {
              functionobject = Symbol.lookupFunction(functionnamesymbol);
            }
            if (functionobject != null) {
              function = functionobject.functionCode;
            }
            else if ((systemname != null) &&
                (!Stella.systemLoadedP(systemname))) {
              { Object old$Module$000 = Stella.$MODULE$.get();
                Object old$Context$000 = Stella.$CONTEXT$.get();

                try {
                  Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
                  Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
                  Stella.loadSystem(systemname, Stella.NIL);

                } finally {
                  Stella.$CONTEXT$.set(old$Context$000);
                  Stella.$MODULE$.set(old$Module$000);
                }
              }
              return (Stella.autoload(qualifiedname, null, cache, errorP));
            }
          }
        }
      } catch (StellaException e) {
        if (errorP) {
          if (systemname != null) {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("autoload: failed to define `" + qualifiedname + "': `" + Stella.exceptionMessage(e) + "'");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
          else {
            throw ((StellaException)(e.fillInStackTrace()));
          }
        }
      }
      if (function == null) {
        if (errorP) {
          { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

            stream001.nativeStream.print("autoload: failed to define `" + qualifiedname + "'");
            throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
          }
        }
        else {
          return (null);
        }
      }
      if (cache != null) {
        cache.surrogateValue = FunctionCodeWrapper.wrapFunctionCode(function);
      }
      return (function);
    }
  }

  public static void makeStella(boolean forcerecompilationP) {
    Stella.makeSystem("STELLA", Cons.cons(Stella.KWD_COMMON_LISP, Cons.cons(Stella.KWD_FORCE_TRANSLATIONp, Cons.cons((forcerecompilationP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Cons.cons(Stella.KWD_DEVELOPMENT_SETTINGSp, Cons.cons(Stella.FALSE_WRAPPER, Stella.NIL))))));
  }

  public static StringWrapper parseConfigurationFileLine(String line, Object [] MV_returnarray) {
    { int start = 0;
      int hashpos = Native.string_position(line, '#', 0);
      int equalpos = Native.string_position(line, '=', 0);
      int end = equalpos;
      int length = line.length();
      String property = null;
      String valuestring = null;
      Stella_Object value = null;
      Keyword operator = Stella.KWD_SET;

      { boolean alwaysP000 = true;

        { int i = Stella.NULL_INTEGER;
          int iter000 = 0;
          int upperBound000 = (((hashpos != Stella.NULL_INTEGER) ? hashpos : length)) - 1;

          loop000 : for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
            i = iter000;
            if (!(Stella.$CHARACTER_TYPE_TABLE$[(int) (line.charAt(i))] == Stella.KWD_WHITE_SPACE)) {
              alwaysP000 = false;
              break loop000;
            }
          }
        }
        if (alwaysP000) {
          { StringWrapper _return_temp = null;

            MV_returnarray[0] = null;
            MV_returnarray[1] = null;
            return (_return_temp);
          }
        }
      }
      if ((equalpos == Stella.NULL_INTEGER) ||
          (equalpos == 0)) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Illegal line in configuration file: `" + line + "'");
        { StringWrapper _return_temp = null;

          MV_returnarray[0] = null;
          MV_returnarray[1] = null;
          return (_return_temp);
        }
      }
      while (Stella.$CHARACTER_TYPE_TABLE$[(int) (line.charAt(start))] == Stella.KWD_WHITE_SPACE) {
        start = start + 1;
      }
      if (line.charAt((end - 1)) == '+') {
        operator = Stella.KWD_ADD;
        end = end - 1;
      }
      while (Stella.$CHARACTER_TYPE_TABLE$[(int) (line.charAt((end - 1)))] == Stella.KWD_WHITE_SPACE) {
        end = end - 1;
      }
      if (end <= start) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Illegal property in configuration file: `" + line + "'");
        { StringWrapper _return_temp = null;

          MV_returnarray[0] = null;
          MV_returnarray[1] = null;
          return (_return_temp);
        }
      }
      property = Native.string_subsequence(line, start, end);
      valuestring = Native.string_subsequence(line, equalpos + 1, length);
      if (Stella.stringEqualP(valuestring, "TRUE")) {
        value = Stella.TRUE_WRAPPER;
      }
      else if (Stella.stringEqualP(valuestring, "FALSE")) {
        value = Stella.FALSE_WRAPPER;
      }
      else {
        try {
          { Surrogate testValue000 = Stella_Object.safePrimaryType(value = Stella.readSExpressionFromString(valuestring));

            if (Surrogate.subtypeOfIntegerP(testValue000) ||
                (Surrogate.subtypeOfLongIntegerP(testValue000) ||
                 Surrogate.subtypeOfFloatP(testValue000))) {
            }
            else {
              value = StringWrapper.wrapString(valuestring);
            }
          }
        } catch (ReadException e000) {
          value = StringWrapper.wrapString(valuestring);
        }
      }
      { StringWrapper _return_temp = StringWrapper.wrapString(property);

        MV_returnarray[0] = ((Wrapper)(value));
        MV_returnarray[1] = operator;
        return (_return_temp);
      }
    }
  }

  /** Lookup <code>property</code> in <code>configuration</code> and return its value.
   * Use the global system configuration table if <code>configuration</code> is NULL.  Return
   * <code>defaultvalue</code> if <code>property</code> is not defined.
   * @param property
   * @param defaultvalue
   * @param configuration
   * @return Stella_Object
   */
  public static Stella_Object lookupConfigurationProperty(String property, Stella_Object defaultvalue, KeyValueList configuration) {
    if (configuration == null) {
      configuration = Stella.$SYSTEM_CONFIGURATION_TABLE$;
    }
    { Stella_Object value = configuration.lookup(StringWrapper.wrapString(property));

      if (value != null) {
        return (value);
      }
      else {
        return (defaultvalue);
      }
    }
  }

  /** Lookup <code>property</code> in <code>configuration</code>, assume it is a multi-valued
   * property and return its value(s) as a list.  Use the global system configuration table
   * if <code>configuration</code> is NULL.  Return <code>defaultvalue</code> if <code>property</code> is not defined or
   * NIL is no default value is specified.
   * @param property
   * @param defaultvalue
   * @param configuration
   * @return Cons
   */
  public static Cons lookupConfigurationPropertyValues(String property, Stella_Object defaultvalue, KeyValueList configuration) {
    if (configuration == null) {
      configuration = Stella.$SYSTEM_CONFIGURATION_TABLE$;
    }
    { Stella_Object value = configuration.lookup(StringWrapper.wrapString(property));

      if (value != null) {
        return (value.consify());
      }
      else if (defaultvalue != null) {
        return (defaultvalue.consify());
      }
      else {
        return (Stella.NIL);
      }
    }
  }

  /** Set <code>property</code> in <code>configuration</code> to <code>value</code> and return it.
   * Use the global system configuration table if <code>configuration</code> is NULL.
   * @param property
   * @param value
   * @param configuration
   * @return Stella_Object
   */
  public static Stella_Object setConfigurationProperty(String property, Stella_Object value, KeyValueList configuration) {
    if (configuration == null) {
      configuration = Stella.$SYSTEM_CONFIGURATION_TABLE$;
    }
    configuration.insertAt(StringWrapper.wrapString(property), value);
    Keyword.runConfigurationPropertyDemon(Stella.KWD_SET, property, value, configuration);
    return (value);
  }

  /** Add <code>value</code> to <code>property</code> in <code>configuration</code> and return it.
   * If a previous value exists add <code>value</code> to the end (listify the old value
   * if it is not yet a list).  Otherwise, create a new list containing <code>value</code>.
   * Use the global system configuration table if <code>configuration</code> is NULL.
   * @param property
   * @param value
   * @param configuration
   * @return Stella_Object
   */
  public static Stella_Object addConfigurationProperty(String property, Stella_Object value, KeyValueList configuration) {
    if (configuration == null) {
      configuration = Stella.$SYSTEM_CONFIGURATION_TABLE$;
    }
    { Stella_Object temp000 = configuration.lookup(StringWrapper.wrapString(property));

      configuration.insertAt(StringWrapper.wrapString(property), (((temp000 != null) ? temp000 : Stella.NIL)).consify().concatenate(Cons.cons(value, Stella.NIL), Stella.NIL));
    }
    Keyword.runConfigurationPropertyDemon(Stella.KWD_ADD, property, value, configuration);
    return (value);
  }

  /** Remove <code>property</code> in <code>configuration</code> and return the previous
   * value.
   * Use the global system configuration table if <code>configuration</code> is NULL.
   * @param property
   * @param configuration
   * @return Stella_Object
   */
  public static Stella_Object clearConfigurationProperty(String property, KeyValueList configuration) {
    if (configuration == null) {
      configuration = Stella.$SYSTEM_CONFIGURATION_TABLE$;
    }
    { Stella_Object currentValue = configuration.lookup(StringWrapper.wrapString(property));

      configuration.removeAt(StringWrapper.wrapString(property));
      Keyword.runConfigurationPropertyDemon(Stella.KWD_CLEAR, property, currentValue, configuration);
      return (currentValue);
    }
  }

  /** Remove <code>value</code> from <code>property</code> in <code>configuration</code> and return it.
   * Use the global system configuration table if <code>configuration</code> is NULL.
   * @param property
   * @param value
   * @param configuration
   * @return Stella_Object
   */
  public static Stella_Object removeConfigurationProperty(String property, Stella_Object value, KeyValueList configuration) {
    if (configuration == null) {
      configuration = Stella.$SYSTEM_CONFIGURATION_TABLE$;
    }
    { Cons currentValue = ((Cons)(configuration.lookup(StringWrapper.wrapString(property))));

      if (currentValue != null) {
        configuration.insertAt(StringWrapper.wrapString(property), currentValue.remove(value));
      }
      Keyword.runConfigurationPropertyDemon(Stella.KWD_REMOVE, property, value, configuration);
      return (value);
    }
  }

  public static String $PlRootDirectory$Setter(String value) {
    Stella.$PL_ROOT_DIRECTORY$ = value;
    Stella.defineLogicalHostProperty("PL", Stella.KWD_ROOT_DIRECTORY, StringWrapper.wrapString(value));
    return (value);
  }

  /** Perform STELLA run-time configuration.  If supplied, load the
   * configuration file <code>file</code> first which should be supplied with a physical pathname.
   * @param file
   */
  public static void configureStella(String file) {
    if ((file != null) &&
        (Stella.findFileInLoadPath(file, null) != null)) {
      KeyValueList.loadConfigurationFile(file);
    }
    Stella.defineLogicalHostProperty("PL", Stella.KWD_ROOT_DIRECTORY, ((Stella.$PL_ROOT_DIRECTORY$ != null) ? StringWrapper.wrapString(Stella.$PL_ROOT_DIRECTORY$) : Stella.lookupConfigurationProperty("PowerLoomRootDirectory", null, null)));
  }

  /** Print all current configuration property information to
   * standard output.
   */
  public static void printProperties() {
    {
      Stella.STANDARD_OUTPUT.nativeStream.println("------------------------------------------------------------");
      Stella.STANDARD_OUTPUT.nativeStream.println("# Loaded System Configuration");
    }
;
    KeyValueList.printConfigurationProperties(Stella.$SYSTEM_CONFIGURATION_TABLE$, Stella.STANDARD_OUTPUT);
    Stella.STANDARD_OUTPUT.nativeStream.println("------------------------------------------------------------");
  }

  /** Register the function named <code>demonname</code> as the demon for <code>property</code>.
   * Demons will be run as after demons on every configuration table update.  Set the
   * property <code>stellaDtestDpropertyDemon</code> to see a test demon in action.
   * @param property
   * @param demonname
   */
  public static void registerPropertyDemon(String property, Symbol demonname) {
    { MappableObject demon = Symbol.lookupFunction(demonname);

      if (demon == null) {
        demon = demonname.lookupGlobalVariable();
      }
      if (demon != null) {
        Stella.$REGISTERED_PROPERTY_DEMONS$.insertAt(StringWrapper.wrapString(property), demon);
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("register-property-demon: cannot find a function or variable with this name: `" + demonname + "'");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  /** Unregister any demon for <code>property</code>.
   * @param property
   */
  public static void unregisterPropertyDemon(String property) {
    Stella.$REGISTERED_PROPERTY_DEMONS$.removeAt(StringWrapper.wrapString(property));
  }

  /** Register a command line option.  :key identifies the name of the option which
   * will usually start with a dash such as <code>E</code> or <code>Eval</code>.  :key2 and :key3 can be used to supply
   * additional options (e.g., long option formats).  To supply even more keys, a list can be supplied
   * with the :keys option.  If a :property is supplied, this option simply sets or adds to the values
   * of the specified system configuration property.  If a :handler name is specified, its function
   * will be used to interpret the values of the option.  :documentation can be used to supply a
   * documentation string which will be printed by the <code>helpOptionHandler</code> (usually bound to <code>P</code>).
   * :value-type describes what type an option value should be coerced to before assigning it to the
   * specified configuration :property.  :n-arguments describes how many arguments this option
   * takes.  This will be 0 for simple switches and can be 1 or greater than one for option handlers
   * that need one or more arguments.  :default-value defines the value to use for zero-argument
   * :property options.  If :multi-valued? is true, values of multiple occurrences of the option will be
   * added to the specified configuration :property.  :error-action can be one of :ignore, :warn or
   * :error to specify what to do in case an error is encountered during option processing.
   * @param options
   */
  public static void registerCmdLineOption(Cons options) {
    { PropertyList theoptions = Stella_Object.parseOptions(options, Cons.list$(Cons.cons(Stella.KWD_DOCUMENTATION, Cons.cons(Stella.SGT_STELLA_STRING, Cons.cons(Stella.KWD_KEY, Cons.cons(Stella.SGT_STELLA_STRING, Cons.cons(Stella.KWD_KEY2, Cons.cons(Stella.SGT_STELLA_STRING, Cons.cons(Stella.KWD_KEY3, Cons.cons(Stella.SGT_STELLA_STRING, Cons.cons(Stella.KWD_KEYS, Cons.cons(Stella.SGT_STELLA_CONS, Cons.cons(Stella.KWD_VALUE_TYPE, Cons.cons(Stella.SGT_STELLA_TYPE, Cons.cons(Stella.KWD_MULTI_VALUEDp, Cons.cons(Stella.SGT_STELLA_BOOLEAN, Cons.cons(Stella.KWD_N_ARGUMENTS, Cons.cons(Stella.SGT_STELLA_INTEGER, Cons.cons(Stella.KWD_DEFAULT_VALUE, Cons.cons(Stella.SGT_STELLA_OBJECT, Cons.cons(Stella.KWD_PROPERTY, Cons.cons(Stella.SGT_STELLA_STRING, Cons.cons(Stella.KWD_HANDLER, Cons.cons(Stella.SGT_STELLA_SYMBOL, Cons.cons(Stella.KWD_ERROR_ACTION, Cons.cons(Stella.SGT_STELLA_KEYWORD, Cons.cons(Stella.NIL, Stella.NIL)))))))))))))))))))))))))), true, false);
      CmdLineOption cmdlineoption = CmdLineOption.newCmdLineOption();
      Stella_Object value = null;

      cmdlineoption.documentation = ((StringWrapper)(theoptions.lookupWithDefault(Stella.KWD_DOCUMENTATION, StringWrapper.wrapString("Not documented.")))).wrapperValue;
      value = theoptions.lookup(Stella.KWD_KEY);
      if (value != null) {
        cmdlineoption.keys = Cons.cons(value, cmdlineoption.keys);
      }
      value = theoptions.lookup(Stella.KWD_KEY2);
      if (value != null) {
        cmdlineoption.keys = Cons.cons(value, cmdlineoption.keys);
      }
      value = theoptions.lookup(Stella.KWD_KEY3);
      if (value != null) {
        cmdlineoption.keys = Cons.cons(value, cmdlineoption.keys);
      }
      { Stella_Object val = null;
        Cons iter000 = ((Cons)(theoptions.lookupWithDefault(Stella.KWD_KEYS, Stella.NIL)));

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          val = iter000.value;
          value = Stella_Object.coerceValueToType(val, Stella.SGT_STELLA_STRING, true);
          cmdlineoption.keys = Cons.cons(value, cmdlineoption.keys);
        }
      }
      cmdlineoption.keys = cmdlineoption.keys.reverse();
      cmdlineoption.valueType = ((Surrogate)(theoptions.lookupWithDefault(Stella.KWD_VALUE_TYPE, Stella.SGT_STELLA_STRING)));
      cmdlineoption.multiValuedP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(theoptions.lookupWithDefault(Stella.KWD_MULTI_VALUEDp, Stella.FALSE_WRAPPER))));
      cmdlineoption.nArguments = ((IntegerWrapper)(theoptions.lookupWithDefault(Stella.KWD_N_ARGUMENTS, IntegerWrapper.wrapInteger(0)))).wrapperValue;
      cmdlineoption.defaultValue = theoptions.lookup(Stella.KWD_DEFAULT_VALUE);
      cmdlineoption.configurationProperty = ((StringWrapper)(theoptions.lookupWithDefault(Stella.KWD_PROPERTY, Stella.NULL_STRING_WRAPPER))).wrapperValue;
      value = theoptions.lookup(Stella.KWD_HANDLER);
      if (value != null) {
        value = Symbol.lookupFunction(((Symbol)(value)));
        if (value == null) {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("register-cmd-line-option: cannot find handler function: `" + theoptions.lookup(Stella.KWD_HANDLER) + "'");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
        cmdlineoption.handler = ((MethodSlot)(value)).functionCode;
      }
      cmdlineoption.errorAction = ((Keyword)(theoptions.lookupWithDefault(Stella.KWD_ERROR_ACTION, Stella.KWD_ERROR)));
      { StringWrapper key = null;
        Cons iter001 = cmdlineoption.keys;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          key = ((StringWrapper)(iter001.value));
          Stella.$REGISTERED_COMMAND_LINE_OPTIONS$.insertAt(key, cmdlineoption);
        }
      }
    }
  }

  /** Unregister the command line option identified by <code>key</code> under all its keys.
   * @param key
   */
  public static void unregisterCmdLineOption(String key) {
    { CmdLineOption cmdlineoption = ((CmdLineOption)(Stella.$REGISTERED_COMMAND_LINE_OPTIONS$.lookup(StringWrapper.wrapString(key))));

      if (cmdlineoption != null) {
        { StringWrapper registeredkey = null;
          Cons iter000 = cmdlineoption.keys;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            registeredkey = ((StringWrapper)(iter000.value));
            Stella.$REGISTERED_COMMAND_LINE_OPTIONS$.removeAt(registeredkey);
          }
        }
        Stella.$REGISTERED_COMMAND_LINE_OPTIONS$.removeAt(StringWrapper.wrapString(key));
      }
    }
  }

  /** Unregister all currently registered command line options.
   */
  public static void unregisterAllCmdLineOptions() {
    Stella.$REGISTERED_COMMAND_LINE_OPTIONS$.clear();
  }

  /** Interpret any command line <code>arguments</code> for which handlers have been registered.
   * Leave any remaining unprocessed arguments in <code>$UNPROCESSED_COMMAND_LINE_ARGUMENTS$</code>.
   * If any unprocessed arguments use option syntax (that is they start with a <code>_</code>), proceed
   * according to <code>unhandledoptionaction</code> which can be one of :ignore, :warn or :error.
   * This ensures that at any point in the option processing, <code>$UNPROCESSED_COMMAND_LINE_ARGUMENTS$</code>
   * accurately reflects the arguments which have been either skipped or not handled yet.
   * @param count
   * @param arguments
   * @param unhandledoptionaction
   */
  public static void processCommandLineArguments(int count, String[] arguments, Keyword unhandledoptionaction) {
    if (Stella.$UNPROCESSED_COMMAND_LINE_ARGUMENTS$ == null) {
      Stella.$UNPROCESSED_COMMAND_LINE_ARGUMENTS$ = Stella.consifyCommandLineArguments(count, arguments);
    }
    { Cons cmdlineargs = Cons.copyConsList(Stella.$UNPROCESSED_COMMAND_LINE_ARGUMENTS$);
      String argument = null;
      int nargs = cmdlineargs.length();
      CmdLineOption option = null;
      Stella_Object value = null;
      Cons unprocessedargs = Cons.cons(null, Stella.$UNPROCESSED_COMMAND_LINE_ARGUMENTS$);
      Cons unprocessedtrailer = unprocessedargs;

      loop000 : while (!(cmdlineargs == Stella.NIL)) {
        { StringWrapper head000 = ((StringWrapper)(cmdlineargs.value));

          cmdlineargs = cmdlineargs.rest;
          argument = head000.wrapperValue;
        }
        nargs = nargs - 1;
        option = ((CmdLineOption)(Stella.$REGISTERED_COMMAND_LINE_OPTIONS$.lookup(StringWrapper.wrapString(argument))));
        value = null;
        if (option != null) {
          if (nargs < option.nArguments) {
            { Keyword testValue000 = option.errorAction;

              if (testValue000 == Stella.KWD_ERROR) {
                { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                  stream000.nativeStream.print("process-command-line-arguments: missing value for option: `" + argument + "'");
                  throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                }
              }
              else if (testValue000 == Stella.KWD_WARN) {
                Stella.STANDARD_WARNING.nativeStream.println("Warning: process-command-line-arguments: missing value for option: `" + argument + "'");
              }
              else if (testValue000 == Stella.KWD_IGNORE) {
              }
              else {
                { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                  stream001.nativeStream.print("`" + testValue000 + "' is not a valid case option");
                  throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
                }
              }
            }
            continue loop000;
          }
          switch (option.nArguments) {
            case 0: 
            break;
            case 1: 
              { StringWrapper head001 = ((StringWrapper)(cmdlineargs.value));

                cmdlineargs = cmdlineargs.rest;
                value = head001;
              }
              nargs = nargs - 1;
            break;
            default:
              { Cons value001 = Stella.NIL;

                { StringWrapper arg = null;
                  Cons iter000 = cmdlineargs;
                  int i = Stella.NULL_INTEGER;
                  int iter001 = 1;
                  int upperBound000 = option.nArguments;
                  boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;
                  Cons collect000 = null;

                  for (;(!(iter000 == Stella.NIL)) &&
                            (unboundedP000 ||
                             (iter001 <= upperBound000)); iter000 = iter000.rest, iter001 = iter001 + 1) {
                    arg = ((StringWrapper)(iter000.value));
                    i = iter001;
                    if (collect000 == null) {
                      {
                        collect000 = Cons.cons(arg, Stella.NIL);
                        if (value001 == Stella.NIL) {
                          value001 = collect000;
                        }
                        else {
                          Cons.addConsToEndOfConsList(value001, collect000);
                        }
                      }
                    }
                    else {
                      {
                        collect000.rest = Cons.cons(arg, Stella.NIL);
                        collect000 = collect000.rest;
                      }
                    }
                  }
                }
                value = value001;
              }
              cmdlineargs = cmdlineargs.nthRest(option.nArguments);
              nargs = nargs - option.nArguments;
            break;
          }
          unprocessedtrailer.rest = unprocessedtrailer.nthRest(option.nArguments + 2);
          Stella.$UNPROCESSED_COMMAND_LINE_ARGUMENTS$ = ((Cons)(unprocessedargs.rest));
          try {
            edu.isi.stella.javalib.Native.funcall(option.handler, null, new java.lang.Object [] {option, value});
          } catch (java.lang.Exception e) {
            { Keyword testValue001 = option.errorAction;

              if (testValue001 == Stella.KWD_ERROR) {
                { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                  stream002.nativeStream.print("Error during processing of `" + argument + "' option: `" + Stella.exceptionMessage(e) + "'");
                  throw ((StellaException)(StellaException.newStellaException(stream002.theStringReader()).fillInStackTrace()));
                }
              }
              else if (testValue001 == Stella.KWD_WARN) {
                Stella.STANDARD_WARNING.nativeStream.println("Warning: Error during processing of `" + argument + "' option: `" + Stella.exceptionMessage(e) + "'");
              }
              else if (testValue001 == Stella.KWD_IGNORE) {
              }
              else {
                { OutputStringStream stream003 = OutputStringStream.newOutputStringStream();

                  stream003.nativeStream.print("`" + testValue001 + "' is not a valid case option");
                  throw ((StellaException)(StellaException.newStellaException(stream003.theStringReader()).fillInStackTrace()));
                }
              }
            }
          }
        }
        else {
          unprocessedtrailer = unprocessedtrailer.rest;
        }
      }
      Stella.$UNPROCESSED_COMMAND_LINE_ARGUMENTS$ = ((Cons)(unprocessedargs.rest));
      { StringWrapper arg = null;
        Cons iter002 = Stella.$UNPROCESSED_COMMAND_LINE_ARGUMENTS$;

        loop002 : for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
          arg = ((StringWrapper)(iter002.value));
          if (Stella.startsWithP(StringWrapper.unwrapString(arg), "-", 0)) {
            if (unhandledoptionaction == Stella.KWD_WARN) {
              Stella.STANDARD_WARNING.nativeStream.println("Warning: Unhandled command line option: `" + StringWrapper.unwrapString(arg) + "'");
            }
            else if (unhandledoptionaction == Stella.KWD_ERROR) {
              { OutputStringStream stream004 = OutputStringStream.newOutputStringStream();

                stream004.nativeStream.print("Unhandled command line option: `" + StringWrapper.unwrapString(arg) + "'");
                throw ((StellaException)(StellaException.newStellaException(stream004.theStringReader()).fillInStackTrace()));
              }
            }
            else if (unhandledoptionaction == Stella.KWD_IGNORE) {
              break loop002;
            }
            else {
              { OutputStringStream stream005 = OutputStringStream.newOutputStringStream();

                stream005.nativeStream.print("`" + unhandledoptionaction + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream005.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
      }
    }
  }

  /** Return all command line arguments which have not yet been processed
   * by (or been ignored by) <code>processCommandLineArguments</code>.  If arguments have not yet
   * been processed, this will return NULL.
   * @return Cons
   */
  public static Cons unprocessedCommandLineArguments() {
    return (Stella.$UNPROCESSED_COMMAND_LINE_ARGUMENTS$);
  }

  public static Stella_Object string_getObject(String self, Stella_Object type) {
    { StringWrapper wrappedstring = StringWrapper.wrapString(self);
      Stella_Object renamed_Object = Stella_Object.searchForObject(wrappedstring, type);

      wrappedstring.free();
      return (renamed_Object);
    }
  }

  public static Stella_Object integer_getObject(int self, Stella_Object type) {
    { IntegerWrapper wrappedinteger = IntegerWrapper.wrapInteger(self);
      Stella_Object renamed_Object = Stella_Object.searchForObject(wrappedinteger, type);

      wrappedinteger.free();
      return (renamed_Object);
    }
  }

  public static Stella_Object stringSearchForObject(String string, Surrogate classtype) {
    { Stella_Object renamed_Object = null;

      { Surrogate type = null;
        CodeWrapper fn = null;
        KvCons iter000 = Stella.$STRING_TO_OBJECT_FUNCTIONS$.theKvList;

        for (;iter000 != null; iter000 = iter000.rest) {
          type = ((Surrogate)(iter000.key));
          fn = ((CodeWrapper)(iter000.value));
          if ((classtype == null) ||
              Surrogate.subtypeOfP(type, classtype)) {
            if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(fn), Stella.SGT_STELLA_FUNCTION_CODE_WRAPPER)) {
              { FunctionCodeWrapper fn000 = ((FunctionCodeWrapper)(fn));

                renamed_Object = ((Stella_Object)(edu.isi.stella.javalib.Native.funcall(fn000.wrapperValue, null, new java.lang.Object [] {string})));
              }
            }
            else {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("`" + Stella_Object.safePrimaryType(fn) + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
            if (renamed_Object != null) {
              return (renamed_Object);
            }
          }
        }
      }
      return (null);
    }
  }

  public static Iterator stringToClasses(String string, boolean exactP) {
    { AllPurposeIterator iterator = AllPurposeIterator.newAllPurposeIterator();

      iterator.iteratorNestedIterator = Module.allClasses(null, false);
      iterator.iteratorFilterCode = Native.find_java_method("edu.isi.stella.Stella_Class", "filterStringToClassP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
      iterator.iteratorNextCode = Native.find_java_method("edu.isi.stella.AllPurposeIterator", "filteredNestedIteratorNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
      iterator.iteratorObject = StringWrapper.wrapString(string);
      iterator.iteratorInteger = (exactP ? 1 : 0);
      return (iterator);
    }
  }

  public static Stella_Object stringToClass(String string) {
    return (Stella.string_getStellaClass(string, false));
  }

  public static Stella_Object stringToContext(String string) {
    try {
      return (Stella.string_getStellaContextSlowly(string));
    } catch (NoSuchContextException e000) {
      return (null);
    }
  }

  public static Stella_Object stringToFunction(String string) {
    return (Stella.lookupFunctionByName(string));
  }

  public static boolean dottedStringP(String string) {
    return (Native.string_position(string, '.', 0) != Stella.NULL_INTEGER);
  }

  public static String yieldExplodedMethodName(String dottedstring, Object [] MV_returnarray) {
    { int dotposition = Native.string_position(dottedstring, '.', 0);
      String firststring = null;
      String secondstring = null;

      if (dotposition != Stella.NULL_INTEGER) {
        firststring = Native.string_subsequence(dottedstring, 0, dotposition);
        secondstring = Native.string_subsequence(dottedstring, dotposition + 1, Stella.NULL_INTEGER);
      }
      { String _return_temp = firststring;

        MV_returnarray[0] = StringWrapper.wrapString(secondstring);
        return (_return_temp);
      }
    }
  }

  public static Stella_Object stringToSlot(String string) {
    if (Stella.dottedStringP(string)) {
      { String classstring = null;
        String slotstring = null;

        { Object [] caller_MV_returnarray = new Object[1];

          classstring = Stella.yieldExplodedMethodName(string, caller_MV_returnarray);
          slotstring = ((String)(((StringWrapper)(caller_MV_returnarray[0])).wrapperValue));
        }
        { Stella_Class renamed_Class = Stella.string_getStellaClass(classstring, false);
          Symbol slotname = null;

          if (renamed_Class != null) {
            slotname = Symbol.lookupSymbol(slotstring);
            if (slotname != null) {
              return (Stella_Class.lookupSlot(renamed_Class, slotname));
            }
          }
        }
      }
    }
    else {
      { Symbol symbol = Symbol.lookupSymbol(string);

        if (symbol != null) {
          return (Symbol.lookupFunction(symbol));
        }
      }
    }
    return (null);
  }

  public static Stella_Object stringToSurrogateValue(String string) {
    { Surrogate sgt = null;
      Iterator iter000 = Module.allSurrogates(null, false);

      while (iter000.nextP()) {
        sgt = ((Surrogate)(iter000.value));
        if (Stella.stringEqlP(sgt.symbolName, string)) {
          return (sgt.surrogateValue);
        }
      }
    }
    return (null);
  }

  public static Stella_Object stringToDemon(String string) {
    return (Stella.lookupDemon(string));
  }

  public static Stella_Object integerToContext(int integer) {
    return (Stella.integer_getStellaContextSlowly(integer));
  }

  public static Cons getClassOptions() {
    { Cons result = Stella.NIL;

      { StorageSlot slot = null;
        Iterator iter000 = Stella_Class.privateClassStorageSlots(((Stella_Class)(Stella.SGT_STELLA_CLASS.surrogateValue)));
        Cons collect000 = null;

        while (iter000.nextP()) {
          slot = ((StorageSlot)(iter000.value));
          if (((Keyword)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_OPTION_KEYWORD, null))) != null) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(slot, Stella.NIL);
                if (result == Stella.NIL) {
                  result = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(result, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(slot, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      { StorageSlot slot = null;
        Iterator iter001 = Stella_Class.publicClassStorageSlots(((Stella_Class)(Stella.SGT_STELLA_CLASS.surrogateValue)));
        Cons collect001 = null;

        while (iter001.nextP()) {
          slot = ((StorageSlot)(iter001.value));
          if (((Keyword)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_OPTION_KEYWORD, null))) != null) {
            if (collect001 == null) {
              {
                collect001 = Cons.cons(slot, Stella.NIL);
                if (result == Stella.NIL) {
                  result = collect001;
                }
                else {
                  Cons.addConsToEndOfConsList(result, collect001);
                }
              }
            }
            else {
              {
                collect001.rest = Cons.cons(slot, Stella.NIL);
                collect001 = collect001.rest;
              }
            }
          }
        }
      }
      { StorageSlot slot = null;
        Iterator iter002 = Stella_Class.privateClassStorageSlots(((Stella_Class)(Stella.SGT_STELLA_RELATION.surrogateValue)));
        Cons collect002 = null;

        while (iter002.nextP()) {
          slot = ((StorageSlot)(iter002.value));
          if (((Keyword)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_OPTION_KEYWORD, null))) != null) {
            if (collect002 == null) {
              {
                collect002 = Cons.cons(slot, Stella.NIL);
                if (result == Stella.NIL) {
                  result = collect002;
                }
                else {
                  Cons.addConsToEndOfConsList(result, collect002);
                }
              }
            }
            else {
              {
                collect002.rest = Cons.cons(slot, Stella.NIL);
                collect002 = collect002.rest;
              }
            }
          }
        }
      }
      { StorageSlot slot = null;
        Iterator iter003 = Stella_Class.publicClassStorageSlots(((Stella_Class)(Stella.SGT_STELLA_RELATION.surrogateValue)));
        Cons collect003 = null;

        while (iter003.nextP()) {
          slot = ((StorageSlot)(iter003.value));
          if (((Keyword)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_OPTION_KEYWORD, null))) != null) {
            if (collect003 == null) {
              {
                collect003 = Cons.cons(slot, Stella.NIL);
                if (result == Stella.NIL) {
                  result = collect003;
                }
                else {
                  Cons.addConsToEndOfConsList(result, collect003);
                }
              }
            }
            else {
              {
                collect003.rest = Cons.cons(slot, Stella.NIL);
                collect003 = collect003.rest;
              }
            }
          }
        }
      }
      return (result);
    }
  }

  public static Cons getSlotOptions() {
    { Cons result = Stella.NIL;

      { StorageSlot slot = null;
        Iterator iter000 = Stella_Class.privateClassStorageSlots(((Stella_Class)(Stella.SGT_STELLA_STORAGE_SLOT.surrogateValue)));
        Cons collect000 = null;

        while (iter000.nextP()) {
          slot = ((StorageSlot)(iter000.value));
          if (((Keyword)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_OPTION_KEYWORD, null))) != null) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(slot, Stella.NIL);
                if (result == Stella.NIL) {
                  result = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(result, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(slot, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      return (result);
    }
  }

  public static String shortDocumentation(String documentation) {
    { int lineend = Stella.NULL_INTEGER;
      int sentenceend = Stella.NULL_INTEGER;

      if (documentation == null) {
        documentation = "Not documented.";
      }
      lineend = Native.string_position(documentation, '\r', 0);
      if (lineend == Stella.NULL_INTEGER) {
        lineend = Native.string_position(documentation, '\n', 0);
      }
      if (lineend == Stella.NULL_INTEGER) {
        return (documentation);
      }
      if (Native.string_memberP(".!", documentation.charAt((lineend - 1)))) {
        return (Native.string_subsequence(documentation, 0, lineend));
      }
      sentenceend = Native.string_position(documentation, '.', 0);
      if ((sentenceend != Stella.NULL_INTEGER) &&
          (sentenceend <= 155)) {
        return (Native.string_subsequence(documentation, 0, sentenceend + 1));
      }
      else {
        return (Native.string_subsequence(documentation, 0, lineend));
      }
    }
  }

  public static void printDocumentationString(String string, int indent, OutputStream stream) {
    if (indent == Stella.NULL_INTEGER) {
      indent = 0;
    }
    { String line = null;
      LineIterator iter000 = InputStream.lines(Stella.makeTokenizerStringStream(string));

      while (iter000.nextP()) {
        line = iter000.value;
        { int i = Stella.NULL_INTEGER;
          int iter001 = 1;
          int upperBound000 = indent;
          boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

          for (;unboundedP000 ||
                    (iter001 <= upperBound000); iter001 = iter001 + 1) {
            i = iter001;
            i = i;
            stream.nativeStream.print(" ");
          }
        }
        stream.nativeStream.println(line);
      }
    }
  }

  public static String cppMakeCodeOutputFileName(String filename) {
    return (Stella.makeFileName(filename, Stella.KWD_CPP_CODE, false));
  }

  public static String cppMakeHeaderOutputFileName(String filename) {
    return (Stella.makeFileName(filename, Stella.KWD_CPP_HEADER, false));
  }

  public static void cppOutputIncludeDirective(String filename, boolean stripdirectoryP) {
    if (stripdirectoryP) {
      filename = Stella.fileNameWithoutDirectory(filename);
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("#include \"" + filename + "\"");
  }

  public static void cppStandaloneOutputImportDeclarations(String headerfilename) {
    Stella.cppOutputIncludeDirective(Stella.makeFileName("cpp-standalone", Stella.KWD_CPP_HEADER, true), true);
    Stella.cppOutputIncludeDirective(headerfilename, true);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
  }

  public static String cppRelativizeHeaderFile(String headerfile, String systemname) {
    systemname = systemname;
    { Object old$Currentsystemdefinition$000 = Stella.$CURRENTSYSTEMDEFINITION$.get();
      Object old$Currentsystemdefinitionsubdirectory$000 = Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.get();

      try {
        Native.setSpecial(Stella.$CURRENTSYSTEMDEFINITION$, Stella.getSystemDefinition("stella"));
        Native.setSpecial(Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$, ((((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null) ? ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).directory : null));
        if (((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null) {
          {
            { String directoryfile = Stella.makeFileName("dummy", Stella.KWD_CPP_HEADER, true);

              headerfile = Stella.relativizeFileName(headerfile, Stella.directoryParentDirectory(directoryfile, 2));
            }
          }
        }
        else {
          {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't find a system named stella");
            Stella.STANDARD_WARNING.nativeStream.println();
          }
;
        }

      } finally {
        Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.set(old$Currentsystemdefinitionsubdirectory$000);
        Stella.$CURRENTSYSTEMDEFINITION$.set(old$Currentsystemdefinition$000);
      }
    }
    return (headerfile);
  }

  public static void cppOutputImportDeclarations(String systemname) {
    if (systemname == null) {
      if (((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) == null) {
        return;
      }
      systemname = ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).name;
    }
    { Object old$Currentsystemdefinition$000 = Stella.$CURRENTSYSTEMDEFINITION$.get();
      Object old$Currentsystemdefinitionsubdirectory$000 = Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.get();

      try {
        Native.setSpecial(Stella.$CURRENTSYSTEMDEFINITION$, Stella.getSystemDefinition(systemname));
        Native.setSpecial(Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$, ((((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null) ? ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).directory : null));
        if (((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null) {
          {
            Stella.cppOutputIncludeDirective(Stella.cppRelativizeHeaderFile(Stella.makeFileName(Stella.cppYieldSystemHeaderFileName(systemname), Stella.KWD_CPP_HEADER, true), systemname), false);
            ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
          }
        }
        else {
          {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't find a system named `" + systemname + "'");
            Stella.STANDARD_WARNING.nativeStream.println();
          }
;
        }

      } finally {
        Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.set(old$Currentsystemdefinitionsubdirectory$000);
        Stella.$CURRENTSYSTEMDEFINITION$.set(old$Currentsystemdefinition$000);
      }
    }
  }

  public static String cppYieldMainFileName() {
    return (Stella.makeFileName("main", Stella.KWD_CPP_CODE, true));
  }

  public static void cppOutputAllUnitsToFile(String filename) {
    { String codeoutputfile = Stella.makeFileName(filename, Stella.KWD_CPP_CODE, false);
      String headeroutputfile = Stella.makeFileName(filename, Stella.KWD_CPP_HEADER, false);
      List headerunits = List.cppSortUnitsForHeaderFile(((List)(Stella.$TRANSLATIONUNITS$.get())));
      Cons auxiliaryglobals = ((Cons)(headerunits.fifth()));
      TranslationUnit main = ((TranslationUnit)(((Cons)(headerunits.nth(5))).value));
      Module currentnamespacemodule = null;
      Module currentunitmodule = null;

      { OutputFileStream codeoutputstream = null;

        try {
          codeoutputstream = Stella.openOutputFile(codeoutputfile, Stella.NIL);
          { OutputFileStream headeroutputstream = null;

            try {
              headeroutputstream = Stella.openOutputFile(headeroutputfile, Stella.NIL);
              { Object old$CurrentStream$000 = Stella.$CURRENT_STREAM$.get();

                try {
                  Native.setSpecial(Stella.$CURRENT_STREAM$, headeroutputstream);
                  Stella.STANDARD_OUTPUT.nativeStream.println("Writing `" + headeroutputfile + "'...");
                  OutputStream.cppOutputFileHeader(headeroutputstream, headeroutputfile);
                  { Cons bucket = null;
                    Cons iter000 = headerunits.theConsList;

                    for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                      bucket = ((Cons)(iter000.value));
                      { TranslationUnit unit = null;
                        Cons iter001 = bucket;
                        int i = Stella.NULL_INTEGER;
                        int iter002 = 1;

                        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest, iter002 = iter002 + 1) {
                          unit = ((TranslationUnit)(iter001.value));
                          i = iter002;
                          if ((unit.theObject != null) &&
                              (!(unit.category == Stella.SYM_STELLA_VERBATIM))) {
                            currentunitmodule = unit.theObject.homeModule();
                            Module.cppOutputNamespaceChange(currentnamespacemodule, currentunitmodule);
                            currentnamespacemodule = currentunitmodule;
                          }
                          { Symbol testValue000 = unit.category;

                            if (testValue000 == Stella.SYM_STELLA_VERBATIM) {
                              if (i == 1) {
                                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("// Header files and macros:");
                              }
                              Stella_Object.cppOutputStatement(unit.translation);
                              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
                            }
                            else if (testValue000 == Stella.SYM_STELLA_CLASS) {
                              if (i == 1) {
                                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("// Class definitions:");
                              }
                              Cons.cppOutputClass(((Cons)(unit.translation)).rest);
                            }
                            else if (testValue000 == Stella.SYM_STELLA_GLOBAL_VARIABLE) {
                              if (i == 1) {
                                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("// Global declarations:");
                              }
                              Cons.cppOutputGlobalDeclaration(((Cons)(unit.translation)));
                            }
                            else if ((testValue000 == Stella.SYM_STELLA_METHOD) ||
                                ((testValue000 == Stella.SYM_STELLA_PRINT_METHOD) ||
                                 (testValue000 == Stella.SYM_STELLA_MACRO))) {
                              if (i == 1) {
                                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("// Function signatures:");
                              }
                              { Cons translation = ((Cons)(unit.translation));

                                { GeneralizedSymbol testValue001 = ((GeneralizedSymbol)(translation.value));

                                  if (testValue001 == Stella.SYM_STELLA_CPP_FUNCTION) {
                                    Cons.cppOutputFunctionSignature(translation.rest);
                                    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
                                  }
                                  else if (testValue001 == Stella.SYM_STELLA_CPP_DEFPRINT) {
                                    Cons.cppOutputDefprintSignature(translation.rest);
                                    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
                                  }
                                  else {
                                  }
                                }
                              }
                            }
                            else if (testValue000 == Stella.SYM_STELLA_AUXILIARY_VARIABLE) {
                              if (i == 1) {
                                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("// Auxiliary global declarations:");
                              }
                              Cons.cppOutputGlobalDeclaration(((Cons)(unit.translation)));
                            }
                            else {
                              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                                stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
                                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                              }
                            }
                          }
                        }
                      }
                      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
                    }
                  }
                  Module.cppOutputNamespaceFooter(currentnamespacemodule);
                  Stella.STANDARD_OUTPUT.nativeStream.println("Writing `" + codeoutputfile + "'...");
                  Native.setSpecial(Stella.$CURRENT_STREAM$, codeoutputstream);
                  OutputStream.cppOutputFileHeader(codeoutputstream, codeoutputfile);
                  if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) {
                    Stella.cppOutputImportDeclarations(null);
                  }
                  else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE) {
                    Stella.cppStandaloneOutputImportDeclarations(headeroutputfile);
                  }
                  else {
                    { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                      stream001.nativeStream.print("`" + ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) + "' is not a valid case option");
                      throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
                    }
                  }
                  currentnamespacemodule = null;
                  { TranslationUnit unit = null;
                    Cons iter003 = ((List)(Stella.$TRANSLATIONUNITS$.get())).theConsList;

                    for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
                      unit = ((TranslationUnit)(iter003.value));
                      if ((unit.theObject != null) &&
                          ((!(unit.category == Stella.SYM_STELLA_VERBATIM)) &&
                           (!(unit.category == Stella.SYM_STELLA_AUXILIARY_VARIABLE)))) {
                        currentunitmodule = unit.theObject.homeModule();
                        Module.cppOutputNamespaceChange(currentnamespacemodule, currentunitmodule);
                        currentnamespacemodule = currentunitmodule;
                      }
                      { Symbol testValue002 = unit.category;

                        if ((testValue002 == Stella.SYM_STELLA_METHOD) ||
                            ((testValue002 == Stella.SYM_STELLA_PRINT_METHOD) ||
                             (testValue002 == Stella.SYM_STELLA_MACRO))) {
                          if (unit == main) {
                            Stella_Object.cppOutputStatement(Stella_Object.copyConsTree(unit.translation));
                          }
                          else {
                            Stella_Object.cppOutputStatement(unit.translation);
                          }
                        }
                        else if (testValue002 == Stella.SYM_STELLA_VERBATIM) {
                          StringWrapper.cppOutputVerbatim(((StringWrapper)(((Cons)(unit.translation)).rest.value)));
                        }
                        else if (testValue002 == Stella.SYM_STELLA_GLOBAL_VARIABLE) {
                          if (!(TranslationUnit.auxiliaryVariableUnitP(unit))) {
                            Cons.cppOutputVariableDefinition(((Cons)(unit.translation)));
                          }
                        }
                        else {
                        }
                      }
                    }
                  }
                  { TranslationUnit unit = null;
                    Cons iter004 = auxiliaryglobals;

                    for (;!(iter004 == Stella.NIL); iter004 = iter004.rest) {
                      unit = ((TranslationUnit)(iter004.value));
                      currentunitmodule = unit.theObject.homeModule();
                      Module.cppOutputNamespaceChange(currentnamespacemodule, currentunitmodule);
                      currentnamespacemodule = currentunitmodule;
                      Cons.cppOutputVariableDefinition(((Cons)(unit.translation)));
                    }
                  }
                  Module.cppOutputNamespaceFooter(currentnamespacemodule);
                  if (main != null) {
                    {
                      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("");
                      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
                    }
;
                    TranslationUnit.cppOutputMain(main);
                  }

                } finally {
                  Stella.$CURRENT_STREAM$.set(old$CurrentStream$000);
                }
              }

            } finally {
              if (headeroutputstream != null) {
                headeroutputstream.free();
              }
            }
          }

        } finally {
          if (codeoutputstream != null) {
            codeoutputstream.free();
          }
        }
      }
    }
  }

  public static void cppTranslateFile(String filename) {
    Stella.translateFile(filename, Stella.KWD_CPP, false);
  }

  public static void cppStandaloneTranslateFile(String filename) {
    Stella.translateFile(filename, Stella.KWD_CPP_STANDALONE, false);
  }

  /** Translate the system <code>systemname</code> to C++.
   * @param systemname
   */
  public static void cppTranslateSystem(String systemname) {
    Stella.translateSystem(systemname, Cons.cons(Stella.KWD_CPP, Cons.cons(Stella.KWD_TWO_PASSp, Cons.cons(Stella.TRUE_WRAPPER, Cons.cons(Stella.KWD_FORCE_TRANSLATIONp, Cons.cons(Stella.TRUE_WRAPPER, Cons.cons(Stella.KWD_PRODUCTION_SETTINGSp, Cons.cons(Stella.TRUE_WRAPPER, Stella.NIL))))))));
  }

  public static void cppOutputSystemSpecificFiles() {
    Stella.cppOutputSystemHeaderFile();
    Stella.cppOutputSystemMakefile();
  }

  public static String cppYieldSystemHeaderFileName(String systemname) {
    return (Native.stringDowncase(systemname) + "-system");
  }

  public static String cppYieldSystemHeaderFileGuard(String systemname) {
    return ("_STELLA_" + Stella.cppSubstituteForbiddenCharacters(Native.stringUpcase(systemname), Stella.KWD_UPPERCASE) + "_SYSTEM_HH");
  }

  public static void cppOutputSystemHeaderFile() {
    { SystemDefinition system = ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get()));
      String systemname = system.name;
      String headeroutputfile = Stella.makeFileName(Stella.cppYieldSystemHeaderFileName(systemname), Stella.KWD_CPP_HEADER, true);

      { OutputFileStream headeroutputstream = null;

        try {
          headeroutputstream = Stella.openOutputFile(headeroutputfile, Stella.NIL);
          { Object old$CurrentStream$000 = Stella.$CURRENT_STREAM$.get();
            Object old$Module$000 = Stella.$MODULE$.get();
            Object old$CppCurrentUnitModule$000 = Stella.$CPP_CURRENT_UNIT_MODULE$.get();

            try {
              Native.setSpecial(Stella.$CURRENT_STREAM$, headeroutputstream);
              Native.setSpecial(Stella.$MODULE$, SystemDefinition.getCardinalModule(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get()))));
              Native.setSpecial(Stella.$CPP_CURRENT_UNIT_MODULE$, null);
              {
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("// " + Stella.fileNameWithoutDirectory(headeroutputfile));
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
              }
;
              {
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("#ifndef " + Stella.cppYieldSystemHeaderFileGuard(systemname));
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("#define " + Stella.cppYieldSystemHeaderFileGuard(systemname));
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
              }
;
              if (system.requiredSystems != null) {
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("// Required systems:");
                { StringWrapper reqsys = null;
                  Cons iter000 = system.requiredSystems;

                  for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                    reqsys = ((StringWrapper)(iter000.value));
                    Stella.cppOutputImportDeclarations(reqsys.wrapperValue);
                  }
                }
              }
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("// System-wide forward declarations:");
              { Stella_Object module = null;
                Cons iter001 = Cons.cons(((Module)(Stella.$MODULE$.get())), SystemDefinition.collectDefinedModulesFromSystemFile(system).remove(((Module)(Stella.$MODULE$.get()))));

                for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                  module = iter001.value;
                  { Module currentnamespacemodule = null;

                    { Stella_Class renamed_Class = null;
                      Iterator iter002 = Module.allClasses(((Module)(module)), true);

                      while (iter002.nextP()) {
                        renamed_Class = ((Stella_Class)(iter002.value));
                        if (Stella_Class.createNativeClassP(renamed_Class)) {
                          Native.setSpecial(Stella.$CPP_CURRENT_UNIT_MODULE$, renamed_Class.homeModule());
                          if (currentnamespacemodule == null) {
                            ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
                          }
                          Module.cppOutputNamespaceChange(currentnamespacemodule, ((Module)(Stella.$CPP_CURRENT_UNIT_MODULE$.get())));
                          currentnamespacemodule = ((Module)(Stella.$CPP_CURRENT_UNIT_MODULE$.get()));
                          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("class " + GeneralizedSymbol.cppTranslateClassName(renamed_Class.classType).wrapperValue + ";");
                        }
                      }
                    }
                    if (currentnamespacemodule != null) {
                      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
                      Module.cppOutputNamespaceFooter(((Module)(Stella.$CPP_CURRENT_UNIT_MODULE$.get())));
                    }
                  }
                }
              }
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("// System components:");
              if (Stella.stringEqlP(systemname, "stella")) {
                Stella.cppOutputIncludeDirective(Stella.cppRelativizeHeaderFile(Stella_Object.makeFileNameFromRelativePath(Cons.list$(Cons.cons(StringWrapper.wrapString("cpp-lib"), Cons.cons(StringWrapper.wrapString("cpp-primal"), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.KWD_CPP_HEADER), systemname), false);
              }
              { StringWrapper file = null;
                Cons iter003 = Cons.filesPlusSystemStartup(SystemDefinition.systemDefinitionSourceFiles(system));

                for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
                  file = ((StringWrapper)(iter003.value));
                  Stella.cppOutputIncludeDirective(Stella.cppRelativizeHeaderFile(Stella.makeFileName(file.wrapperValue, Stella.KWD_CPP_HEADER, true), systemname), false);
                }
              }
              {
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("#endif");
              }
;

            } finally {
              Stella.$CPP_CURRENT_UNIT_MODULE$.set(old$CppCurrentUnitModule$000);
              Stella.$MODULE$.set(old$Module$000);
              Stella.$CURRENT_STREAM$.set(old$CurrentStream$000);
            }
          }

        } finally {
          if (headeroutputstream != null) {
            headeroutputstream.free();
          }
        }
      }
    }
  }

  public static String cppYieldSystemsRootDirectory() {
    { String directory = ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).directory;
      String root = "..";

      loop000 : for (;;) {
        directory = Stella.directoryParentDirectory(directory, 1);
        if (Stella.stringEqlP(directory, "")) {
          break loop000;
        }
        else {
          root = root + "/..";
        }
      }
      return (root);
    }
  }

  public static String cppYieldStellaRootDirectory() {
    { String systemsroot = Stella.cppYieldSystemsRootDirectory();

      { Object old$Currentsystemdefinition$000 = Stella.$CURRENTSYSTEMDEFINITION$.get();
        Object old$Currentsystemdefinitionsubdirectory$000 = Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.get();

        try {
          Native.setSpecial(Stella.$CURRENTSYSTEMDEFINITION$, Stella.getSystemDefinition("STELLA"));
          Native.setSpecial(Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$, ((((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null) ? ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).directory : null));
          if (((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null) {
            {
              return (systemsroot + "/" + Stella.fileBaseName(Stella.directoryFileName(Stella.directoryParentDirectory(Stella.makeFileName("dummy", Stella.KWD_CPP_CODE, true), 1))));
            }
          }
          else {
            {
              Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't find a system named STELLA");
              Stella.STANDARD_WARNING.nativeStream.println();
            }
;
          }

        } finally {
          Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.set(old$Currentsystemdefinitionsubdirectory$000);
          Stella.$CURRENTSYSTEMDEFINITION$.set(old$Currentsystemdefinition$000);
        }
      }
      return (null);
    }
  }

  public static void cppOutputSystemMakefile() {
    { String makefile = Stella.makeFileName("Makefile", Stella.KWD_STELLA, true);
      String templatefile = Stella.fileNameWithoutExtension(makefile) + ".in";
      SystemDefinition system = ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get()));

      if (!(Stella.probeFileP(templatefile))) {
        { Object old$Currentsystemdefinition$000 = Stella.$CURRENTSYSTEMDEFINITION$.get();
          Object old$Currentsystemdefinitionsubdirectory$000 = Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.get();

          try {
            Native.setSpecial(Stella.$CURRENTSYSTEMDEFINITION$, Stella.getSystemDefinition("STELLA"));
            Native.setSpecial(Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$, ((((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null) ? ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).directory : null));
            if (((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null) {
              {
                makefile = Stella.makeFileName("Makefile-default", Stella.KWD_STELLA, true);
                templatefile = Stella.fileNameWithoutExtension(makefile) + ".in";
              }
            }
            else {
              {
                Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't find a system named STELLA");
                Stella.STANDARD_WARNING.nativeStream.println();
              }
;
            }

          } finally {
            Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.set(old$Currentsystemdefinitionsubdirectory$000);
            Stella.$CURRENTSYSTEMDEFINITION$.set(old$Currentsystemdefinition$000);
          }
        }
      }
      { KeyValueList variables = KeyValueList.newKeyValueList();
        OutputStringStream systemfiles = OutputStringStream.newOutputStringStream();
        OutputStringStream requiredsystems = OutputStringStream.newOutputStringStream();
        OutputStringStream requiredsystemdirs = OutputStringStream.newOutputStringStream();
        OutputStringStream allrequiredsystems = OutputStringStream.newOutputStringStream();
        String nativesystemroot = Stella.fileNameDirectory(Stella.makeFileName("foo", Stella.KWD_CPP_CODE, true));

        variables.insertAt(StringWrapper.wrapString("SYSTEM-NAME"), StringWrapper.wrapString(system.name));
        variables.insertAt(StringWrapper.wrapString("PROGRAM-NAME"), StringWrapper.wrapString(system.name));
        variables.insertAt(StringWrapper.wrapString("MAIN-NAME"), StringWrapper.wrapString(Stella.fileNameWithoutDirectory(Stella.cppYieldMainFileName())));
        variables.insertAt(StringWrapper.wrapString("SYSTEMS-ROOT"), StringWrapper.wrapString(Stella.cppYieldSystemsRootDirectory()));
        variables.insertAt(StringWrapper.wrapString("STELLA-ROOT"), StringWrapper.wrapString(Stella.cppYieldStellaRootDirectory()));
        { StringWrapper file = null;
          Cons iter000 = Cons.filesPlusSystemStartup(SystemDefinition.systemDefinitionSourceFiles(system));

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            file = ((StringWrapper)(iter000.value));
            systemfiles.nativeStream.print(Stella.relativizeFileName(Stella.makeFileName(file.wrapperValue, Stella.KWD_CPP_CODE, true), nativesystemroot) + " ");
          }
        }
        variables.insertAt(StringWrapper.wrapString("SYSTEM-FILES"), StringWrapper.wrapString(systemfiles.theStringReader()));
        if (system.requiredSystems != null) {
          { StringWrapper reqsys = null;
            Cons iter001 = system.requiredSystems;

            for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              reqsys = ((StringWrapper)(iter001.value));
              requiredsystems.nativeStream.print(reqsys.wrapperValue + " ");
              requiredsystemdirs.nativeStream.print(Stella.getSystemDefinition(reqsys.wrapperValue).directory + " ");
            }
          }
          { StringWrapper reqsys = null;
            Cons iter002 = Stella.allRequiredSystems(system.name);

            for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
              reqsys = ((StringWrapper)(iter002.value));
              allrequiredsystems.nativeStream.print(reqsys.wrapperValue + " ");
            }
          }
        }
        variables.insertAt(StringWrapper.wrapString("REQUIRED-SYSTEMS"), StringWrapper.wrapString(requiredsystems.theStringReader()));
        variables.insertAt(StringWrapper.wrapString("REQUIRED-SYSTEM-DIRS"), StringWrapper.wrapString(requiredsystemdirs.theStringReader()));
        variables.insertAt(StringWrapper.wrapString("ALL-REQUIRED-SYSTEMS"), StringWrapper.wrapString(allrequiredsystems.theStringReader()));
        makefile = Stella.fileNameWithoutExtension(Stella.makeFileName("Makefile", Stella.KWD_CPP_CODE, true));
        Stella.substituteTemplateVariablesToMakefile(templatefile, makefile, variables);
      }
    }
  }

  public static String substituteTemplateVariablesInString(String string, KeyValueList variables) {
    { int index = 0;
      int length = string.length();
      String result = string;
      int variableend = 0;
      String variablename = null;
      StringWrapper variablevalue = null;

      loop000 : for (;;) {
        index = Native.stringSearch(result, Stella.$MAKEFILE_TEMPLATE_VARIABLE_PREFIX$, index);
        if (index == Stella.NULL_INTEGER) {
          break loop000;
        }
        index = index + 2;
        if (index >= length) {
          {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Illegal template variable syntax in");
            Stella.STANDARD_WARNING.nativeStream.println("    `" + string + "'");
          }
;
          break loop000;
        }
        if (!(result.charAt(index) == '(')) {
          {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Illegal template variable syntax in");
            Stella.STANDARD_WARNING.nativeStream.println("    `" + string + "'");
          }
;
          continue loop000;
        }
        variableend = Native.string_position(result, ')', index);
        if (variableend == Stella.NULL_INTEGER) {
          {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Illegal template variable syntax in");
            Stella.STANDARD_WARNING.nativeStream.println("    `" + string + "'");
          }
;
          continue loop000;
        }
        index = index + 1;
        variablename = Native.string_subsequence(result, index, variableend);
        variablevalue = ((StringWrapper)(variables.lookup(StringWrapper.wrapString(variablename))));
        if (variablevalue == null) {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: Undefined template variable: `" + variablename + "'");
          continue loop000;
        }
        result = Native.string_subsequence(result, 0, index - 3) + variablevalue.wrapperValue + Native.string_subsequence(result, variableend + 1, Stella.NULL_INTEGER);
        index = variableend + 1 + (result.length() - length);
        length = result.length();
      }
      return (result);
    }
  }

  public static void substituteTemplateVariablesToMakefile(String templatefile, String outputfile, KeyValueList variables) {
    { InputFileStream in = null;

      try {
        in = Stella.openInputFile(templatefile, Stella.NIL);
        { OutputFileStream out = null;

          try {
            out = Stella.openOutputFile(outputfile, Stella.NIL);
            {
              out.nativeStream.println("# This file has been generated automatically.  Modify at your own risk!");
              out.nativeStream.println();
            }
;
            InputStream.substituteTemplateVariablesToStream(in, out, variables);

          } finally {
            if (out != null) {
              out.free();
            }
          }
        }

      } finally {
        if (in != null) {
          in.free();
        }
      }
    }
  }

  public static boolean cppUseGarbageCollectorP() {
    return (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_CPP_GARBAGE_COLLECTOR));
  }

  public static StringHashTable cppCreateReservedWordTable() {
    { StringHashTable table = StringHashTable.newStringHashTable();

      { Stella_Object word = null;
        Cons iter000 = Cons.list$(Cons.cons(Stella.SYM_STELLA_ASM, Cons.cons(Stella.SYM_STELLA_ASSERT, Cons.cons(Stella.SYM_STELLA_AUTO, Cons.cons(Stella.SYM_STELLA_BREAK, Cons.cons(Stella.SYM_STELLA_CASE, Cons.cons(Stella.SYM_STELLA_CATCH, Cons.cons(Stella.SYM_STELLA_CHAR, Cons.cons(Stella.SYM_STELLA_CLASS, Cons.cons(Stella.SYM_STELLA_CONST, Cons.cons(Stella.SYM_STELLA_CONTINUE, Cons.cons(Stella.SYM_STELLA_DEFAULT, Cons.cons(Stella.SYM_STELLA_DELETE, Cons.cons(Stella.SYM_STELLA_DO, Cons.cons(Stella.SYM_STELLA_DOUBLE, Cons.cons(Stella.SYM_STELLA_ELSE, Cons.cons(Stella.SYM_STELLA_ENUM, Cons.cons(Stella.SYM_STELLA_EXTERN, Cons.cons(Stella.SYM_STELLA_FLOAT, Cons.cons(Stella.SYM_STELLA_FOR, Cons.cons(Stella.SYM_STELLA_FRIEND, Cons.cons(Stella.SYM_STELLA_GOTO, Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(Stella.SYM_STELLA_INLINE, Cons.cons(Stella.SYM_STELLA_INT, Cons.cons(Stella.SYM_STELLA_LONG, Cons.cons(Stella.SYM_STELLA_NAMESPACE, Cons.cons(Stella.SYM_STELLA_NEW, Cons.cons(Stella.SYM_STELLA_OPERATOR, Cons.cons(Stella.SYM_STELLA_PRIVATE, Cons.cons(Stella.SYM_STELLA_PROTECTED, Cons.cons(Stella.SYM_STELLA_PUBLIC, Cons.cons(Stella.SYM_STELLA_REGISTER, Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_SHORT, Cons.cons(Stella.SYM_STELLA_SIGNED, Cons.cons(Stella.SYM_STELLA_SIZEOF, Cons.cons(Stella.SYM_STELLA_STATIC, Cons.cons(Stella.SYM_STELLA_STRUCT, Cons.cons(Stella.SYM_STELLA_SWITCH, Cons.cons(Stella.SYM_STELLA_TEMPLATE, Cons.cons(Stella.SYM_STELLA_THROW, Cons.cons(Stella.SYM_STELLA_TRY, Cons.cons(Stella.SYM_STELLA_TYPEDEF, Cons.cons(Stella.SYM_STELLA_TYPEID, Cons.cons(Stella.SYM_STELLA_UNION, Cons.cons(Stella.SYM_STELLA_UNSIGNED, Cons.cons(Stella.SYM_STELLA_VIRTUAL, Cons.cons(Stella.SYM_STELLA_VOID, Cons.cons(Stella.SYM_STELLA_VOLATILE, Cons.cons(Stella.SYM_STELLA_WHILE, Cons.cons(Stella.SYM_STELLA_TYPENAME, Cons.cons(Stella.NIL, Stella.NIL)))))))))))))))))))))))))))))))))))))))))))))))))))));

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          word = iter000.value;
          table.insertAt(((Symbol)(word)).symbolName, Symbol.cppYieldRenamedReservedWord(((Symbol)(word))));
        }
      }
      table.insertAt("++", StringWrapper.wrapString("stella_Increment"));
      table.insertAt("--", StringWrapper.wrapString("stella_Decrement"));
      return (table);
    }
  }

  public static Cons cppYieldSymbolIdForm(int symbolid) {
    { Symbol symbol = Symbol.getSymFromOffset(symbolid);

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(Symbol.cppTranslateSymbolId(symbol), Cons.cons(Stella.NIL, Stella.NIL)))));
    }
  }

  public static Cons cppTranslateNull() {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(StringWrapper.wrapString("NULL"), Cons.cons(Stella.NIL, Stella.NIL)))));
  }

  public static String cppGenerateArrayTypedEntity(String entity, String translatedarraytype) {
    { boolean referencetypeP = Native.stringSearch(translatedarraytype, "(*&)", 0) != Stella.NULL_INTEGER;

      if (referencetypeP) {
        return (Stella.replaceSubstrings(translatedarraytype, "(*&" + entity + ")", "(*&)"));
      }
      else {
        return (Stella.replaceSubstrings(translatedarraytype, "(*" + entity + ")", "(*)"));
      }
    }
  }

  public static boolean cppNativePointerTypeP(String nativetype) {
    { int length = nativetype.length();

      { int i = Stella.NULL_INTEGER;
        int iter000 = 1;
        int upperBound000 = length;
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

        loop000 : for (;unboundedP000 ||
                  (iter000 <= upperBound000); iter000 = iter000 + 1) {
          i = iter000;
          switch (nativetype.charAt((length - i))) {
            case ' ': 
            case '\t': 
            case '\n': 
            case '\r': 
              continue loop000;
            case '*': 
              return (true);
            default:
              break loop000;
          }
        }
      }
      return (false);
    }
  }

  public static String cppUnpointerizeNativeType(String nativetype) {
    { int length = nativetype.length();

      { int i = Stella.NULL_INTEGER;
        int iter000 = 1;
        int upperBound000 = length;
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

        loop000 : for (;unboundedP000 ||
                  (iter000 <= upperBound000); iter000 = iter000 + 1) {
          i = iter000;
          switch (nativetype.charAt((length - i))) {
            case ' ': 
            case '\t': 
            case '\n': 
            case '\r': 
              continue loop000;
            case '*': 
              return (Native.string_subsequence(nativetype, 0, length - i));
            default:
              break loop000;
          }
        }
      }
      return (nativetype);
    }
  }

  public static String cppCreateCharacterSubstitutionTable() {
    { StringBuffer table = edu.isi.stella.javalib.Native.makeMutableString(256, '_');

      { int code = Stella.NULL_INTEGER;
        int iter000 = (int) '0';
        int upperBound000 = (int) '9';
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

        for (;unboundedP000 ||
                  (iter000 <= upperBound000); iter000 = iter000 + 1) {
          code = iter000;
          edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '=', code);
        }
      }
      { int code = Stella.NULL_INTEGER;
        int iter001 = (int) 'A';
        int upperBound001 = (int) 'Z';
        boolean unboundedP001 = upperBound001 == Stella.NULL_INTEGER;

        for (;unboundedP001 ||
                  (iter001 <= upperBound001); iter001 = iter001 + 1) {
          code = iter001;
          edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '=', code);
        }
      }
      { int code = Stella.NULL_INTEGER;
        int iter002 = (int) 'a';
        int upperBound002 = (int) 'z';
        boolean unboundedP002 = upperBound002 == Stella.NULL_INTEGER;

        for (;unboundedP002 ||
                  (iter002 <= upperBound002); iter002 = iter002 + 1) {
          code = iter002;
          edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '=', code);
        }
      }
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '=', ((int) '_'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) ' '));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'X', ((int) '!'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) '"'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'H', ((int) '#'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'B', ((int) '$'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'R', ((int) '%'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'A', ((int) '&'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'Q', ((int) '\''));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) '('));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) ')'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'O', ((int) '*'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'I', ((int) '+'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) ','));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) '-'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'D', ((int) '.'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'S', ((int) '/'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'C', ((int) ':'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) ';'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'L', ((int) '<'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'E', ((int) '='));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'G', ((int) '>'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'P', ((int) '?'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'M', ((int) '@'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'J', ((int) '['));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) '\\'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'K', ((int) ']'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'U', ((int) '^'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) '`'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'Y', ((int) '{'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'V', ((int) '|'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'Z', ((int) '}'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'T', ((int) '~'));
      return (table.toString());
    }
  }

  public static String replaceFirstCharacterWithString(String string, String newprefix) {
    return (Native.stringConcatenate(newprefix, Native.string_subsequence(string, 1, Stella.NULL_INTEGER)));
  }

  public static String cppSubstituteForbiddenCharacters(String name, Keyword caseconvention) {
    { StringBuffer result = null;
      char substitution = Stella.NULL_CHARACTER;

      switch (name.charAt(0)) {
        case '0': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "zero")));
        break;
        case '1': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "one")));
        break;
        case '2': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "two")));
        break;
        case '3': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "three")));
        break;
        case '4': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "four")));
        break;
        case '5': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "five")));
        break;
        case '6': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "six")));
        break;
        case '7': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "seven")));
        break;
        case '8': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "eight")));
        break;
        case '9': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "nine")));
        break;
        default:
          result = new StringBuffer(name);
        break;
      }
      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = result.length() - 1;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          substitution = Stella.$CPP_CHARACTER_SUBSTITUTION_TABLE$.charAt(((int) (result.charAt(i))));
          if (!(substitution == '=')) {
            if (caseconvention == Stella.KWD_UPPERCASE) {
              edu.isi.stella.javalib.Native.mutableString_nthSetter(result, (Stella.$CHARACTER_DOWNCASE_TABLE$.charAt(((int) substitution))), i);
            }
            else if (caseconvention == Stella.KWD_LOWERCASE) {
              edu.isi.stella.javalib.Native.mutableString_nthSetter(result, (Stella.$CHARACTER_UPCASE_TABLE$.charAt(((int) substitution))), i);
            }
            else if (caseconvention == Stella.KWD_CAPITALIZED) {
              edu.isi.stella.javalib.Native.mutableString_nthSetter(result, (Stella.$CHARACTER_UPCASE_TABLE$.charAt(((int) substitution))), i);
            }
            else {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("`" + caseconvention + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
      }
      return (result.toString());
    }
  }

  public static Keyword cppNameQualificationMode() {
    return (((Keyword)(Stella.$CPP_NAME_QUALIFICATION_MODE$.get())));
  }

  public static String cppYieldQualifiedName(String translatedname, GeneralizedSymbol sourcesymbol) {
    if (!(GeneralizedSymbol.cppQualifyNameP(sourcesymbol))) {
      return (translatedname);
    }
    { String prefix = GeneralizedSymbol.cppYieldNamespacePrefix(sourcesymbol);

      if (Stella.stringEqlP(prefix, "")) {
        return (translatedname);
      }
      else {
        return (prefix + Stella.$CPP_NAMESPACE_SEPARATOR$ + translatedname);
      }
    }
  }

  public static Cons cppTranslateReturnParameter(int parameternumber, StandardObject parametertype) {
    return (Cons.cons(StandardObject.cppTranslateAndReferencizeTypeSpec(parametertype), Cons.cons(Symbol.cppTranslateReturnParameterName(Stella.SYM_STELLA__RETURN, parameternumber), Stella.NIL)));
  }

  public static Cons cppYieldInitialNullValue() {
    return (((Cons)(Stella_Object.cppTranslateATree(null))));
  }

  public static void cppOutputBreak() {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("break;");
  }

  public static void cppOutputContinue() {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("continue;");
  }

  public static void cppBumpIndent() {
    Native.setIntSpecial(Stella.$CPP_INDENT_CHARS$, ((Integer)(Stella.$CPP_INDENT_CHARS$.get())).intValue() + 2);
  }

  public static void cppUnbumpIndent() {
    Native.setIntSpecial(Stella.$CPP_INDENT_CHARS$, ((Integer)(Stella.$CPP_INDENT_CHARS$.get())).intValue() - 2);
  }

  public static String replaceCharacterWithSubstring(String string, String renamed_New, char character) {
    return (Stella.replaceSubstrings(string, renamed_New, Native.makeString(1, character)));
  }

  public static void string_cppOutputLiteral(String string) {
    { int free = Stella.$CPP_MAX_STRING_LITERAL_LENGTH$;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("\"");
      { char ch = Stella.NULL_CHARACTER;
        String vector000 = string;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          ch = vector000.charAt(index000);
          if (free <= 1) {
            ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("\" \"");
            free = Stella.$CPP_MAX_STRING_LITERAL_LENGTH$;
          }
          switch (ch) {
            case '\\': 
            case '"': 
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("\\");
              free = free - 1;
            break;
            case '\n': 
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("\\");
              free = free - 1;
              ch = 'n';
            break;
            case '\r': 
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("\\");
              free = free - 1;
              ch = 'r';
            break;
            default:
            break;
          }
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(ch);
          free = free - 1;
        }
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("\"");
    }
  }

  public static void cppIndent() {
    { int i = Stella.NULL_INTEGER;
      int iter000 = 1;
      int upperBound000 = ((Integer)(Stella.$CPP_INDENT_CHARS$.get())).intValue();
      boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

      for (;unboundedP000 ||
                (iter000 <= upperBound000); iter000 = iter000 + 1) {
        i = iter000;
        i = i;
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
      }
    }
  }

  public static boolean cppOutputTemplateClassesP() {
    return (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE);
  }

  public static void clt() {
    Stella.string_changeModule("STELLA");
    Keyword.setTranslatorOutputLanguage(Stella.KWD_COMMON_LISP);
  }

  public static void jt() {
    Stella.string_changeModule("STELLA");
    Keyword.setTranslatorOutputLanguage(Stella.KWD_JAVA);
  }

  public static String string_javaMakeCodeOutputFileName(String barefile, boolean donttruncateP) {
    if (donttruncateP) {
      { Object old$DonttruncatefilenamesP$000 = Stella.$DONTTRUNCATEFILENAMESp$.get();

        try {
          Native.setBooleanSpecial(Stella.$DONTTRUNCATEFILENAMESp$, true);
          return (Stella_Object.makeFileNameFromRelativePath(StringWrapper.wrapString(barefile), Stella.KWD_JAVA));

        } finally {
          Stella.$DONTTRUNCATEFILENAMESp$.set(old$DonttruncatefilenamesP$000);
        }
      }
    }
    else {
      return (Stella_Object.makeFileNameFromRelativePath(StringWrapper.wrapString(barefile), Stella.KWD_JAVA));
    }
  }

  public static void javaOutputFlotsamUnitsToFileForModule(String classoutputfile, Module module, TranslationUnit classunit, Cons globals, Cons functions) {
    { Object old$CurrentJavaOutputClass$000 = Stella.$CURRENT_JAVA_OUTPUT_CLASS$.get();

      try {
        Native.setSpecial(Stella.$CURRENT_JAVA_OUTPUT_CLASS$, null);
        { Cons translation = Stella.NIL;
          Stella_Class renamed_Class = null;
          Cons classtranslation = Stella.NIL;

          { Object old$Module$000 = Stella.$MODULE$.get();
            Object old$Context$000 = Stella.$CONTEXT$.get();

            try {
              Native.setSpecial(Stella.$MODULE$, module);
              Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
              { OutputFileStream classoutputstream = null;

                try {
                  classoutputstream = Stella.openOutputFile(classoutputfile, Stella.NIL);
                  if (classunit != null) {
                    Native.setSpecial(Stella.$CURRENT_JAVA_OUTPUT_CLASS$, ((Stella_Class)(classunit.theObject)));
                    Stella.STANDARD_OUTPUT.nativeStream.println("Translating `" + renamed_Class + "'...");
                    classtranslation = Stella_Class.javaTranslateDefineNativeClass(((Stella_Class)(Stella.$CURRENT_JAVA_OUTPUT_CLASS$.get()))).rest;
                  }
                  { Object old$CurrentStream$000 = Stella.$CURRENT_STREAM$.get();

                    try {
                      Native.setSpecial(Stella.$CURRENT_STREAM$, classoutputstream);
                      if (((Integer)(Stella.$TRANSLATIONVERBOSITYLEVEL$.get())).intValue() >= 1) {
                        if (classunit != null) {
                          Stella.STANDARD_OUTPUT.nativeStream.println("    Writing `" + classoutputfile + "' ...");
                        }
                        else {
                          Stella.STANDARD_OUTPUT.nativeStream.println("Writing `" + classoutputfile + "'...");
                        }
                      }
                      OutputStream.javaOutputFileHeader(classoutputstream, Module.javaMakeGlobalOutputFileName(module, true));
                      if (classunit != null) {
                        Cons.javaOutputClassDeclaration(classtranslation);
                      }
                      else {
                        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("public class " + Module.javaYieldFlotsamClassName(module) + " ");
                      }
                      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("{");
                      Stella.javaBumpIndent();
                      if (classunit != null) {
                        Cons.javaOutputClassVariableDefinitions(((Cons)(classtranslation.nth(6))));
                      }
                      { TranslationUnit global = null;
                        Cons iter000 = globals;

                        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                          global = ((TranslationUnit)(iter000.value));
                          translation = TranslationUnit.javaTranslateUnit(global);
                          Cons.javaOutputGlobalDefinition(translation.rest);
                          global.translation = null;
                          global.codeRegister = null;
                        }
                      }
                      if (classunit != null) {
                        Cons.javaOutputClassConstructors(((Cons)(classtranslation.nth(7))), Module.javaYieldFlotsamClassName(module), (((Stella_Class)(Stella.$CURRENT_JAVA_OUTPUT_CLASS$.get())) != null) &&
                            Stella_Class.exceptionClassP(((Stella_Class)(Stella.$CURRENT_JAVA_OUTPUT_CLASS$.get()))));
                        { TranslationUnit statement = null;
                          Cons iter001 = ((Cons)(classtranslation.nth(8)));

                          for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                            statement = ((TranslationUnit)(iter001.value));
                            Stella_Object.javaOutputStatement(TranslationUnit.javaTranslateUnit(statement));
                            statement.translation = null;
                            statement.codeRegister = null;
                          }
                        }
                      }
                      { TranslationUnit function = null;
                        Cons iter002 = functions;

                        for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                          function = ((TranslationUnit)(iter002.value));
                          Cons.javaOutputMethod(TranslationUnit.javaTranslateUnit(function).rest);
                          function.translation = null;
                          function.codeRegister = null;
                        }
                      }
                      Stella.javaUnbumpIndent();
                      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");

                    } finally {
                      Stella.$CURRENT_STREAM$.set(old$CurrentStream$000);
                    }
                  }

                } finally {
                  if (classoutputstream != null) {
                    classoutputstream.free();
                  }
                }
              }

            } finally {
              Stella.$CONTEXT$.set(old$Context$000);
              Stella.$MODULE$.set(old$Module$000);
            }
          }
        }

      } finally {
        Stella.$CURRENT_JAVA_OUTPUT_CLASS$.set(old$CurrentJavaOutputClass$000);
      }
    }
  }

  public static void javaOutputAllUnitsToFile() {
    { StringWrapper startupclassname = null;
      StringHashTable startupht = StringHashTable.newStringHashTable();
      Cons startupclasslist = Stella.NIL;
      Cons methods = Stella.NIL;
      HashTable flotsamfunctionht = HashTable.newHashTable();
      HashTable globalsht = HashTable.newHashTable();
      List codemoduleslist = List.list(Stella.NIL);
      Cons verbatimstatements = Stella.NIL;
      Cons classes = Stella.NIL;
      Module codeoutputmodule = null;

      Stella.$JAVA_STELLA_PACKAGE_MAPPING$.insertAt(StringWrapper.wrapString("STELLAROOT"), StringWrapper.wrapString(Stella.javaStellaPackage()));
      Native.setSpecial(Stella.$TRANSLATIONUNITS$, ((List)(Stella.$TRANSLATIONUNITS$.get())).reverse());
      { TranslationUnit unit = null;
        Cons iter000 = ((List)(Stella.$TRANSLATIONUNITS$.get())).theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          unit = ((TranslationUnit)(iter000.value));
          { Symbol testValue000 = unit.category;

            if ((testValue000 == Stella.SYM_STELLA_METHOD) ||
                (testValue000 == Stella.SYM_STELLA_MACRO)) {
              if (MethodSlot.javaFlotsamFunctionP(((MethodSlot)(unit.theObject)))) {
                codeoutputmodule = unit.theObject.homeModule();
                HashTable.javaPushIntoHashTable(flotsamfunctionht, codeoutputmodule, unit);
                codemoduleslist.insertNew(codeoutputmodule);
              }
              else if (((MethodSlot)(unit.theObject)).methodStartupFunctionP()) {
                startupclassname = StringWrapper.javaTranslateClassNamestring(StringWrapper.wrapString(((StringWrapper)(KeyValueList.dynamicSlotValue(((MethodSlot)(unit.theObject)).dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, Stella.NULL_STRING_WRAPPER))).wrapperValue));
                StringHashTable.javaPushIntoStringHashTable(startupht, startupclassname.wrapperValue, unit);
                if (!(startupclasslist.memberP(startupclassname))) {
                  startupclasslist = Cons.cons(startupclassname, startupclasslist);
                }
              }
              else {
                methods = Cons.cons(unit, methods);
              }
            }
            else if (testValue000 == Stella.SYM_STELLA_PRINT_METHOD) {
              methods = Cons.cons(unit, methods);
            }
            else if (testValue000 == Stella.SYM_STELLA_TYPE) {
            }
            else if (testValue000 == Stella.SYM_STELLA_VERBATIM) {
              verbatimstatements = Cons.cons(unit, verbatimstatements);
            }
            else if (testValue000 == Stella.SYM_STELLA_CLASS) {
              classes = Cons.cons(unit, classes);
            }
            else if (testValue000 == Stella.SYM_STELLA_GLOBAL_VARIABLE) {
              codeoutputmodule = unit.theObject.homeModule();
              HashTable.javaPushIntoHashTable(globalsht, codeoutputmodule, unit);
              codemoduleslist.insertNew(codeoutputmodule);
            }
            else {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
      }
      { TranslationUnit classunit = null;
        Cons iter001 = classes;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          classunit = ((TranslationUnit)(iter001.value));
          if (TranslationUnit.javaClassUnitDefinesFlotsamClassP(classunit)) {
            { Module module = classunit.theObject.homeModule();
              Cons globals = Stella.NIL;
              Cons functions = Stella.NIL;

              { Object old$Module$000 = Stella.$MODULE$.get();
                Object old$Context$000 = Stella.$CONTEXT$.get();

                try {
                  Native.setSpecial(Stella.$MODULE$, module);
                  Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
                  globals = ((Cons)(globalsht.lookup(module)));
                  if (!(globals != null)) {
                    globals = Stella.NIL;
                  }
                  functions = ((Cons)(flotsamfunctionht.lookup(module)));
                  if (!(functions != null)) {
                    functions = Stella.NIL;
                  }
                  Stella.javaOutputFlotsamUnitsToFileForModule(Module.javaMakeGlobalOutputFileName(module, false), module, classunit, globals, functions);
                  codemoduleslist.remove(module);

                } finally {
                  Stella.$CONTEXT$.set(old$Context$000);
                  Stella.$MODULE$.set(old$Module$000);
                }
              }
            }
          }
          else {
            TranslationUnit.javaOutputClassUnitToFile(classunit);
          }
        }
      }
      HashTable.javaOutputFlotsamUnitsToFile(globalsht, flotsamfunctionht, codemoduleslist.theConsList);
      StringHashTable.javaOutputStartupUnitsToFile(startupht, startupclasslist);
    }
  }

  public static void javaInitializeFileTranslation() {
    Native.setIntSpecial(Stella.$JAVA_INDENT_CHARS$, 0);
  }

  public static void javaTranslateFile(String filename) {
    Stella.translateFile(filename, Stella.KWD_JAVA, false);
  }

  public static void javaTranslateFileAsPartOfSystem(String filename) {
    Stella.translateFile(filename, Stella.KWD_JAVA, true);
  }

  /** Translate the system <code>systemname</code> to Java.
   * @param systemname
   */
  public static void javaTranslateSystem(String systemname) {
    Stella.translateSystem(systemname, Cons.cons(Stella.KWD_JAVA, Cons.cons(Stella.KWD_TWO_PASSp, Cons.cons(Stella.TRUE_WRAPPER, Cons.cons(Stella.KWD_FORCE_TRANSLATIONp, Cons.cons(Stella.TRUE_WRAPPER, Cons.cons(Stella.KWD_PRODUCTION_SETTINGSp, Cons.cons(Stella.TRUE_WRAPPER, Stella.NIL))))))));
  }

  public static String javaYieldNativeClassName() {
    if ((Stella.string_getStellaClass("NATIVE", false) != null) ||
        Stella.inheritedClassNameConflictsP("NATIVE")) {
      return (Stella.javaYieldFullNativeClassName());
    }
    else {
      return ("Native");
    }
  }

  public static String javaYieldSpecialVariableClassName() {
    if ((Stella.string_getStellaClass("STELLA-SPECIAL-VARIABLE", false) != null) ||
        Stella.inheritedClassNameConflictsP("STELLA-SPECIAL-VARIABLE")) {
      return (Stella.javaStellaPackage() + ".javalib.StellaSpecialVariable");
    }
    else {
      return ("StellaSpecialVariable");
    }
  }

  public static String javaYieldFullNativeClassName() {
    return (Stella.javaStellaPackage() + ".javalib.Native");
  }

  public static String javaCreateCharacterSubstitutionTable() {
    { StringBuffer table = edu.isi.stella.javalib.Native.makeMutableString(256, '_');

      { int code = Stella.NULL_INTEGER;
        int iter000 = (int) '0';
        int upperBound000 = (int) '9';
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

        for (;unboundedP000 ||
                  (iter000 <= upperBound000); iter000 = iter000 + 1) {
          code = iter000;
          edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '=', code);
        }
      }
      { int code = Stella.NULL_INTEGER;
        int iter001 = (int) 'A';
        int upperBound001 = (int) 'Z';
        boolean unboundedP001 = upperBound001 == Stella.NULL_INTEGER;

        for (;unboundedP001 ||
                  (iter001 <= upperBound001); iter001 = iter001 + 1) {
          code = iter001;
          edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '=', code);
        }
      }
      { int code = Stella.NULL_INTEGER;
        int iter002 = (int) 'a';
        int upperBound002 = (int) 'z';
        boolean unboundedP002 = upperBound002 == Stella.NULL_INTEGER;

        for (;unboundedP002 ||
                  (iter002 <= upperBound002); iter002 = iter002 + 1) {
          code = iter002;
          edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '=', code);
        }
      }
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '=', ((int) '_'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) ' '));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'X', ((int) '!'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) '"'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'H', ((int) '#'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'B', ((int) '$'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'R', ((int) '%'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'A', ((int) '&'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'Q', ((int) '\''));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) '('));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) ')'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '$', ((int) '*'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'I', ((int) '+'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) ','));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) '-'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'D', ((int) '.'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'S', ((int) '/'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'C', ((int) ':'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) ';'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'L', ((int) '<'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'E', ((int) '='));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'G', ((int) '>'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'P', ((int) '?'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'M', ((int) '@'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'J', ((int) '['));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) '\\'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'K', ((int) ']'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'U', ((int) '^'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) '`'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'Y', ((int) '{'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'V', ((int) '|'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'Z', ((int) '}'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'T', ((int) '~'));
      return (table.toString());
    }
  }

  public static String javaSubstituteForbiddenCharacters(String name, Keyword caseconvention) {
    { StringBuffer result = null;
      char substitution = Stella.NULL_CHARACTER;

      switch (name.charAt(0)) {
        case '0': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "zero")));
        break;
        case '1': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "one")));
        break;
        case '2': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "two")));
        break;
        case '3': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "three")));
        break;
        case '4': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "four")));
        break;
        case '5': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "five")));
        break;
        case '6': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "six")));
        break;
        case '7': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "seven")));
        break;
        case '8': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "eight")));
        break;
        case '9': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "nine")));
        break;
        default:
          result = new StringBuffer(name);
        break;
      }
      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = result.length() - 1;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          substitution = Stella.$JAVA_CHARACTER_SUBSTITUTION_TABLE$.charAt(((int) (result.charAt(i))));
          if (!(substitution == '=')) {
            if (caseconvention == Stella.KWD_UPPERCASE) {
              edu.isi.stella.javalib.Native.mutableString_nthSetter(result, (Stella.$CHARACTER_DOWNCASE_TABLE$.charAt(((int) substitution))), i);
            }
            else if (caseconvention == Stella.KWD_LOWERCASE) {
              edu.isi.stella.javalib.Native.mutableString_nthSetter(result, (Stella.$CHARACTER_UPCASE_TABLE$.charAt(((int) substitution))), i);
            }
            else if (caseconvention == Stella.KWD_CAPITALIZED) {
              edu.isi.stella.javalib.Native.mutableString_nthSetter(result, (Stella.$CHARACTER_UPCASE_TABLE$.charAt(((int) substitution))), i);
            }
            else {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("`" + caseconvention + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
      }
      return (result.toString());
    }
  }

  public static String javaYieldFlotsamTypeName(String flotsamClassName) {
    { int lastPeriod = Stella.NULL_INTEGER;
      int nextPeriod = Native.string_position(flotsamClassName, '.', 0);
      String bareClassName = null;

      while (nextPeriod != Stella.NULL_INTEGER) {
        lastPeriod = nextPeriod;
        nextPeriod = Native.string_position(flotsamClassName, '.', nextPeriod);
      }
      if (lastPeriod != Stella.NULL_INTEGER) {
        bareClassName = Native.string_subsequence(flotsamClassName, lastPeriod, Stella.NULL_INTEGER);
      }
      else {
        bareClassName = flotsamClassName;
      }
      return (Stella.makeMatchingNameFull(bareClassName, Stella.KWD_YES, Stella.KWD_NO, "_", "", "", "", "", Stella.KWD_UPCASE, "-"));
    }
  }

  public static boolean inheritedClassNameConflictsP(String stellaClassName) {
    { Stella_Class stellaClass = Stella.string_getStellaClass(stellaClassName, false);
      Stella_Class testClass = null;
      String javaClassName = "";
      Module catchallModule = null;

      { Module module = null;
        Cons iter000 = ((Module)(Stella.$MODULE$.get())).uses.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          module = ((Module)(iter000.value));
          { Object old$Module$000 = Stella.$MODULE$.get();

            try {
              Native.setSpecial(Stella.$MODULE$, module);
              testClass = Stella.string_getStellaClass(stellaClassName, false);
              if (stellaClass == null) {
                stellaClass = testClass;
              }
              if ((testClass != null) &&
                  (!(testClass == stellaClass))) {
                return (true);
              }

            } finally {
              Stella.$MODULE$.set(old$Module$000);
            }
          }
        }
      }
      { Context module = null;
        Cons iter001 = ((Module)(Stella.$MODULE$.get())).allSuperContexts;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          module = ((Context)(iter001.value));
          if (Stella_Object.isaP(module, Stella.SGT_STELLA_MODULE)) {
            { Object old$Module$001 = Stella.$MODULE$.get();

              try {
                Native.setSpecial(Stella.$MODULE$, ((Module)(module)));
                testClass = Stella.string_getStellaClass(stellaClassName, false);
                if (stellaClass == null) {
                  stellaClass = testClass;
                }
                if ((testClass != null) &&
                    (!(testClass == stellaClass))) {
                  return (true);
                }

              } finally {
                Stella.$MODULE$.set(old$Module$001);
              }
            }
          }
        }
      }
      javaClassName = StringWrapper.javaTranslateClassNamestring(StringWrapper.wrapString(stellaClassName)).wrapperValue;
      { Module module = null;
        Cons iter002 = ((Module)(Stella.$MODULE$.get())).uses.theConsList;

        for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
          module = ((Module)(iter002.value));
          if (Stella.stringEqlP(javaClassName, Module.javaYieldFlotsamClassName(module))) {
            if ((stellaClass != null) ||
                (catchallModule != null)) {
              return (true);
            }
            catchallModule = module;
          }
        }
      }
      { Context module = null;
        Cons iter003 = ((Module)(Stella.$MODULE$.get())).allSuperContexts;

        for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
          module = ((Context)(iter003.value));
          if (Stella_Object.isaP(module, Stella.SGT_STELLA_MODULE) &&
              Stella.stringEqlP(javaClassName, Module.javaYieldFlotsamClassName(((Module)(module))))) {
            if ((stellaClass != null) ||
                (catchallModule != null)) {
              return (true);
            }
            catchallModule = ((Module)(module));
          }
        }
      }
      return (false);
    }
  }

  public static StringHashTable javaCreateReservedWordTable() {
    { StringHashTable table = StringHashTable.newStringHashTable();

      { Stella_Object word = null;
        Cons iter000 = Cons.list$(Cons.cons(Stella.SYM_STELLA_OBJECT, Cons.cons(Stella.SYM_STELLA_ABSTRACT, Cons.cons(Stella.SYM_STELLA_BOOLEAN, Cons.cons(Stella.SYM_STELLA_BREAK, Cons.cons(Stella.SYM_STELLA_BYTE, Cons.cons(Stella.SYM_STELLA_CASE, Cons.cons(Stella.SYM_STELLA_CATCH, Cons.cons(Stella.SYM_STELLA_CHAR, Cons.cons(Stella.SYM_STELLA_CLASS, Cons.cons(Stella.SYM_STELLA_CONST, Cons.cons(Stella.SYM_STELLA_CONTINUE, Cons.cons(Stella.SYM_STELLA_DEFAULT, Cons.cons(Stella.SYM_STELLA_DO, Cons.cons(Stella.SYM_STELLA_DOUBLE, Cons.cons(Stella.SYM_STELLA_ELSE, Cons.cons(Stella.SYM_STELLA_EXTENDS, Cons.cons(Stella.SYM_STELLA_FINAL, Cons.cons(Stella.SYM_STELLA_FINALLY, Cons.cons(Stella.SYM_STELLA_FLOAT, Cons.cons(Stella.SYM_STELLA_FOR, Cons.cons(Stella.SYM_STELLA_GOTO, Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(Stella.SYM_STELLA_IMPLEMENTS, Cons.cons(Stella.SYM_STELLA_IMPORT, Cons.cons(Stella.SYM_STELLA_INSTANCEOF, Cons.cons(Stella.SYM_STELLA_INT, Cons.cons(Stella.SYM_STELLA_INTERFACE, Cons.cons(Stella.SYM_STELLA_LONG, Cons.cons(Stella.SYM_STELLA_NATIVE, Cons.cons(Stella.SYM_STELLA_NEW, Cons.cons(Stella.SYM_STELLA_PACKAGE, Cons.cons(Stella.SYM_STELLA_PRIVATE, Cons.cons(Stella.SYM_STELLA_PROTECTED, Cons.cons(Stella.SYM_STELLA_PUBLIC, Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_SHORT, Cons.cons(Stella.SYM_STELLA_STATIC, Cons.cons(Stella.SYM_STELLA_SUPER, Cons.cons(Stella.SYM_STELLA_SWITCH, Cons.cons(Stella.SYM_STELLA_SYNCHRONIZED, Cons.cons(Stella.SYM_STELLA_THROW, Cons.cons(Stella.SYM_STELLA_THROWS, Cons.cons(Stella.SYM_STELLA_TRANSIENT, Cons.cons(Stella.SYM_STELLA_TRY, Cons.cons(Stella.SYM_STELLA_VOID, Cons.cons(Stella.SYM_STELLA_VOLATILE, Cons.cons(Stella.SYM_STELLA_WHILE, Cons.cons(Stella.SYM_STELLA_ASSERT, Cons.cons(Stella.SYM_STELLA_ENUM, Cons.cons(Stella.NIL, Stella.NIL)))))))))))))))))))))))))))))))))))))))))))))))))));

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          word = iter000.value;
          table.insertAt(Native.stringDowncase(((Symbol)(word)).symbolName), Symbol.javaYieldRenamedReservedWord(((Symbol)(word))));
          table.insertAt(Native.stringCapitalize(((Symbol)(word)).symbolName), Symbol.javaYieldRenamedReservedWord(((Symbol)(word))));
        }
      }
      table.insertAt("++", StringWrapper.wrapString("stella_Increment"));
      table.insertAt("--", StringWrapper.wrapString("stella_Decrement"));
      return (table);
    }
  }

  public static String javaLookupReservedWordTable(String word) {
    { StringWrapper entry = ((StringWrapper)(Stella.$JAVA_RESERVED_WORD_TABLE$.lookup(word)));

      if (entry != null) {
        return (entry.wrapperValue);
      }
      else {
        return (null);
      }
    }
  }

  public static String javaTranslateNamestring(String namestring) {
    { String reservedname = Stella.javaLookupReservedWordTable(namestring);

      if (namestring == null) {
        return ("NULL");
      }
      if (reservedname != null) {
        return (reservedname);
      }
      return (Stella.javaSubstituteForbiddenCharacters(namestring, Stella.KWD_LOWERCASE));
    }
  }

  public static Cons javaYieldSymbolIdForm(int symbolid) {
    { Symbol symbol = Symbol.getSym(symbolid);

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(Symbol.javaTranslateSymbolId(symbol), Cons.cons(Stella.NIL, Stella.NIL)))));
    }
  }

  public static Cons javaTranslateClassObjectLookup(String classname) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString(Stella.javaYieldNativeClassName()), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString("find_java_class"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_ACTUALS, Cons.cons(StringWrapper.wrapString(classname), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))));
  }

  public static String yieldClassObjectLookupNameForNativeType(String nativetype) {
    { String basetype = nativetype;
      String renamed_Package = "java.lang.";
      int arraydimensions = 0;
      int index = -1;
      int arraymarkerindex = Stella.NULL_INTEGER;

      { char ch = Stella.NULL_CHARACTER;
        String vector000 = nativetype;
        int index000 = 0;
        int length000 = vector000.length();
        int i = Stella.NULL_INTEGER;
        int iter000 = 0;

        for (;index000 < length000; index000 = index000 + 1, iter000 = iter000 + 1) {
          ch = vector000.charAt(index000);
          i = iter000;
          if (ch == '.') {
            index = i;
          }
          if (ch == '[') {
            if (arraymarkerindex == Stella.NULL_INTEGER) {
              arraymarkerindex = i;
            }
            arraydimensions = arraydimensions + 1;
          }
        }
      }
      if (index >= 0) {
        renamed_Package = Native.string_subsequence(nativetype, 0, index + 1);
      }
      basetype = Native.string_subsequence(nativetype, index + 1, arraymarkerindex);
      if (Stella.$JAVA_PRIMITIVE_ARRAY_TYPE_NAMES$.lookup(StringWrapper.wrapString(basetype)) != null) {
        basetype = ((StringWrapper)(Stella.$JAVA_PRIMITIVE_ARRAY_TYPE_NAMES$.lookup(StringWrapper.wrapString(basetype)))).wrapperValue;
      }
      else if (arraydimensions > 0) {
        basetype = "L" + renamed_Package + basetype + ";";
      }
      else {
        basetype = renamed_Package + basetype;
      }
      switch (arraydimensions) {
        case 0: 
          return (basetype);
        case 1: 
          return ("[" + basetype);
        case 2: 
          return ("[[" + basetype);
        default:
          return (Native.makeString(arraydimensions, '[') + basetype);
      }
    }
  }

  public static Cons javaTranslateNull() {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString("null"), Cons.cons(Stella.NIL, Stella.NIL)))));
  }

  public static Cons javaTranslateEol() {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_EOL, Cons.cons(Symbol.javaTranslateGlobalName(Stella.SYM_STELLA_EOL, false), Cons.cons(Stella.NIL, Stella.NIL)))));
  }

  public static String javaPrependGlobalClassName(String namestring, Module module) {
    return (Module.javaYieldFlotsamClassName(module) + "." + namestring);
  }

  public static Cons javaTranslateReturnParameter() {
    return (Cons.list$(Cons.cons(StringWrapper.wrapString("Object []"), Cons.cons(StringWrapper.wrapString("MV_returnarray"), Cons.cons(Stella.NIL, Stella.NIL)))));
  }

  public static String javaStellaPackage() {
    { String stellapackage = Stella.$STELLA_MODULE$.javaPackage();

      if (stellapackage != null) {
        return (stellapackage);
      }
      else {
        return ("edu.isi.stella");
      }
    }
  }

  public static void javaBumpIndent() {
    Native.setIntSpecial(Stella.$JAVA_INDENT_CHARS$, ((Integer)(Stella.$JAVA_INDENT_CHARS$.get())).intValue() + 2);
  }

  public static void javaUnbumpIndent() {
    Native.setIntSpecial(Stella.$JAVA_INDENT_CHARS$, ((Integer)(Stella.$JAVA_INDENT_CHARS$.get())).intValue() - 2);
  }

  public static void javaIndent() {
    { int i = Stella.NULL_INTEGER;
      int iter000 = 1;
      int upperBound000 = ((Integer)(Stella.$JAVA_INDENT_CHARS$.get())).intValue();
      boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

      for (;unboundedP000 ||
                (iter000 <= upperBound000); iter000 = iter000 + 1) {
        i = iter000;
        i = i;
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
      }
    }
  }

  public static void string_javaOutputLiteral(String string) {
    { int maxsize = 65535 - 1;
      int length = string.length();
      boolean toolongP = length > maxsize;
      int chunksize = 0;

      if (toolongP) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationWarning();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
              {
                Stella.STANDARD_WARNING.nativeStream.println();
                Stella.STANDARD_WARNING.nativeStream.println(" Encountered too long string constant (`" + Native.string_subsequence(string, 0, 80) + "'...), breaking it up which is INEFFICIENT.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("new String().concat(");
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("\"");
      { char ch = Stella.NULL_CHARACTER;
        String vector000 = string;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          ch = vector000.charAt(index000);
          chunksize = chunksize + 1;
          switch (ch) {
            case '\n': 
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("\\n");
              chunksize = chunksize + 1;
            break;
            case '\r': 
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("\\r");
              chunksize = chunksize + 1;
            break;
            case '"': 
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("\\\"");
              chunksize = chunksize + 1;
            break;
            case '\\': 
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("\\\\");
              chunksize = chunksize + 1;
            break;
            default:
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(ch);
            break;
          }
          if ((chunksize >= maxsize) &&
              toolongP) {
            ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("\").concat(\"");
            chunksize = 0;
          }
        }
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("\"");
      if (toolongP) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
      }
    }
  }

  public static void javaOutputExceptionConstructor(String exceptionname) {
    Stella.javaIndent();
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("public " + exceptionname + " (String message) {");
    Stella.javaBumpIndent();
    Stella.javaIndent();
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("super(message);");
    Stella.javaUnbumpIndent();
    Stella.javaIndent();
    {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
    }
;
  }

  public static String javaHeuristicallyTranslateName(String stellaName, Cons caseConvertedNameList) {
    { StringWrapper pname = null;
      Cons iter000 = caseConvertedNameList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        pname = ((StringWrapper)(iter000.value));
        if (Stella.stringEqualP(pname.wrapperValue, stellaName)) {
          return (pname.wrapperValue);
        }
      }
    }
    { boolean testValue000 = false;

      if (((Module)(Stella.$MODULE$.get())).caseSensitiveP) {
        testValue000 = true;
      }
      else {
        { boolean foundP000 = false;

          { char ch = Stella.NULL_CHARACTER;
            String vector000 = stellaName;
            int index000 = 0;
            int length000 = vector000.length();

            loop001 : for (;index000 < length000; index000 = index000 + 1) {
              ch = vector000.charAt(index000);
              if (Stella.upperCaseCharacterP(ch)) {
                foundP000 = true;
                break loop001;
              }
            }
          }
          testValue000 = foundP000;
        }
      }
      if (testValue000) {
        {
          return (Stella.javaTranslateNamestring(Stella.makeMatchingNameFull(stellaName, Stella.KWD_NO, Stella.KWD_NO, "- ", "", "", "", "", Stella.KWD_PRESERVE, "_")));
        }
      }
      else {
        if (Native.string_memberP(stellaName, '*')) {
          {
            return (Stella.javaTranslateNamestring(Stella.makeMatchingNameFull(stellaName, Stella.KWD_CLEVER, Stella.KWD_CLEVER, "- ", "", "", "", "", Stella.KWD_UPCASE, "_")));
          }
        }
        else {
          {
            return (Stella.javaTranslateNamestring(Stella.makeMatchingNameFull(stellaName, Stella.KWD_CLEVER, Stella.KWD_CLEVER, "- ", "", "", "", "", Stella.KWD_TITLECASEX, "")));
          }
        }
      }
    }
  }

  public static void javaOutputCommentString(String comment, String commentStart, String commentContinuation, String commentEnd, boolean javadocCommentP, Cons caseConvertedNameList) {
    { boolean returnP = false;
      boolean escapeP = false;
      boolean eolLastP = false;
      boolean insideQuoteP = false;
      OutputStream savedStream = ((OutputStream)(Stella.$CURRENT_STREAM$.get()));
      OutputStringStream stringStream = null;
      String stellaName = null;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(commentStart);
      { char renamed_Char = Stella.NULL_CHARACTER;
        String vector000 = comment;
        int index000 = 0;
        int length000 = vector000.length();

        loop000 : for (;index000 < length000; index000 = index000 + 1) {
          renamed_Char = vector000.charAt(index000);
          switch (renamed_Char) {
            case '\n': 
              if (!(returnP)) {
                if (eolLastP &&
                    javadocCommentP) {
                  ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("<p>");
                }
                else {
                  ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
                }
                eolLastP = true;
                Stella.javaIndent();
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(commentContinuation);
              }
              escapeP = false;
              returnP = false;
            break;
            case '\r': 
              if (eolLastP &&
                  javadocCommentP) {
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("<p>");
              }
              else {
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
              }
              Stella.javaIndent();
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(commentContinuation);
              eolLastP = true;
              returnP = true;
              escapeP = false;
              continue loop000;
            case '`': 
              if (escapeP) {
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(renamed_Char);
              }
              else if (insideQuoteP) {
                Stella.STANDARD_WARNING.nativeStream.println("Warning: Encountered unescaped ` inside ` form in comment `" + comment + "'");
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(renamed_Char);
              }
              else {
                stringStream = OutputStringStream.newOutputStringStream();
                Native.setSpecial(Stella.$CURRENT_STREAM$, stringStream);
                insideQuoteP = true;
              }
              escapeP = false;
              returnP = false;
              eolLastP = false;
            break;
            case '\'': 
              if (escapeP) {
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(renamed_Char);
              }
              else if (insideQuoteP) {
                Native.setSpecial(Stella.$CURRENT_STREAM$, savedStream);
                stellaName = stringStream.theStringReader();
                if (javadocCommentP) {
                  ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("<code>");
                }
                else {
                  ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("`");
                }
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(Stella.javaHeuristicallyTranslateName(stellaName, caseConvertedNameList));
                if (javadocCommentP) {
                  ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("</code>");
                }
                else {
                  ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("'");
                }
                insideQuoteP = false;
              }
              else {
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(renamed_Char);
              }
              escapeP = false;
              returnP = false;
              eolLastP = false;
            break;
            case '\\': 
              if (escapeP) {
                {
                  ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(renamed_Char);
                  escapeP = false;
                }
              }
              else {
                escapeP = true;
              }
              returnP = false;
              eolLastP = false;
            break;
            default:
              if (insideQuoteP ||
                  (!javadocCommentP)) {
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(renamed_Char);
              }
              else {
                Stella.writeHtmlCharacterQuotingSpecialCharacters(((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream, renamed_Char);
              }
              returnP = false;
              escapeP = false;
              eolLastP = false;
            break;
          }
        }
      }
      if (insideQuoteP) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Comment ended while inside a ` form in comment `" + comment + "'");
        Native.setSpecial(Stella.$CURRENT_STREAM$, savedStream);
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("`");
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(stringStream.theStringReader());
      }
      if ((commentEnd != null) &&
          (!Stella.stringEqlP(commentEnd, ""))) {
        {
          Stella.javaIndent();
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(commentEnd);
        }
      }
      else {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
      }
    }
  }

  public static String fixupDocumentationStringQuoting(String documentation) {
    if (documentation == null) {
      return (null);
    }
    { int closingquoteposition = Stella.NULL_INTEGER;
      char precedingcharacter = Stella.NULL_CHARACTER;
      String openparentheses = "([{";
      StringBuffer buffer = new StringBuffer(documentation);

      { char renamed_Char = Stella.NULL_CHARACTER;
        String vector000 = documentation;
        int index000 = 0;
        int length000 = vector000.length();
        int i = Stella.NULL_INTEGER;
        int iter000 = 0;

        loop000 : for (;index000 < length000; index000 = index000 + 1, iter000 = iter000 + 1) {
          renamed_Char = vector000.charAt(index000);
          i = iter000;
          switch (renamed_Char) {
            case '`': 
            case '\'': 
              if (i == closingquoteposition) {
                continue loop000;
              }
              if (i == 0) {
                precedingcharacter = ' ';
              }
              else {
                precedingcharacter = documentation.charAt((i - 1));
              }
              if ((Stella.$CHARACTER_TYPE_TABLE$[(int) precedingcharacter] == Stella.KWD_WHITE_SPACE) ||
                  Native.string_memberP(openparentheses, precedingcharacter)) {
                closingquoteposition = Native.string_position(documentation, '\'', i + 1);
                if (closingquoteposition != Stella.NULL_INTEGER) {
                  edu.isi.stella.javalib.Native.mutableString_nthSetter(buffer, '`', i);
                }
              }
            break;
            default:
            break;
          }
        }
      }
      return (buffer.toString());
    }
  }

  public static Cons idlTranslateNull() {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_IDL_IDENT, Cons.cons(StringWrapper.wrapString("NULL"), Cons.cons(Stella.NIL, Stella.NIL)))));
  }

  public static String idlCreateCharacterSubstitutionTable() {
    { StringBuffer table = edu.isi.stella.javalib.Native.makeMutableString(256, '_');

      { int code = Stella.NULL_INTEGER;
        int iter000 = (int) '0';
        int upperBound000 = (int) '9';
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

        for (;unboundedP000 ||
                  (iter000 <= upperBound000); iter000 = iter000 + 1) {
          code = iter000;
          edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '=', code);
        }
      }
      { int code = Stella.NULL_INTEGER;
        int iter001 = (int) 'A';
        int upperBound001 = (int) 'Z';
        boolean unboundedP001 = upperBound001 == Stella.NULL_INTEGER;

        for (;unboundedP001 ||
                  (iter001 <= upperBound001); iter001 = iter001 + 1) {
          code = iter001;
          edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '=', code);
        }
      }
      { int code = Stella.NULL_INTEGER;
        int iter002 = (int) 'a';
        int upperBound002 = (int) 'z';
        boolean unboundedP002 = upperBound002 == Stella.NULL_INTEGER;

        for (;unboundedP002 ||
                  (iter002 <= upperBound002); iter002 = iter002 + 1) {
          code = iter002;
          edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '=', code);
        }
      }
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '=', ((int) '_'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) ' '));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'X', ((int) '!'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) '"'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'H', ((int) '#'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'B', ((int) '$'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'R', ((int) '%'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'A', ((int) '&'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'Q', ((int) '\''));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) '('));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) ')'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'O', ((int) '*'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'I', ((int) '+'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) ','));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) '-'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'D', ((int) '.'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'S', ((int) '/'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'C', ((int) ':'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) ';'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'L', ((int) '<'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'E', ((int) '='));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'G', ((int) '>'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'P', ((int) '?'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'M', ((int) '@'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) '['));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) '\\'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) ']'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'U', ((int) '^'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) '`'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) '{'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'V', ((int) '|'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, '_', ((int) '}'));
      edu.isi.stella.javalib.Native.mutableString_nthSetter(table, 'T', ((int) '~'));
      return (table.toString());
    }
  }

  public static String idlSubstituteForbiddenCharacters(String name, Keyword caseconvention) {
    { StringBuffer result = null;
      char substitution = Stella.NULL_CHARACTER;

      switch (name.charAt(0)) {
        case '0': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "zero")));
        break;
        case '1': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "one")));
        break;
        case '2': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "two")));
        break;
        case '3': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "three")));
        break;
        case '4': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "four")));
        break;
        case '5': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "five")));
        break;
        case '6': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "six")));
        break;
        case '7': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "seven")));
        break;
        case '8': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "eight")));
        break;
        case '9': 
          result = new StringBuffer((Stella.replaceFirstCharacterWithString(name, "nine")));
        break;
        default:
          result = new StringBuffer(name);
        break;
      }
      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = result.length() - 1;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          substitution = Stella.$IDL_CHARACTER_SUBSTITUTION_TABLE$.charAt(((int) (result.charAt(i))));
          if (!(substitution == '=')) {
            if (caseconvention == Stella.KWD_UPPERCASE) {
              edu.isi.stella.javalib.Native.mutableString_nthSetter(result, (Stella.$CHARACTER_DOWNCASE_TABLE$.charAt(((int) substitution))), i);
            }
            else if (caseconvention == Stella.KWD_LOWERCASE) {
              edu.isi.stella.javalib.Native.mutableString_nthSetter(result, (Stella.$CHARACTER_UPCASE_TABLE$.charAt(((int) substitution))), i);
            }
            else if (caseconvention == Stella.KWD_CAPITALIZED) {
              edu.isi.stella.javalib.Native.mutableString_nthSetter(result, (Stella.$CHARACTER_UPCASE_TABLE$.charAt(((int) substitution))), i);
            }
            else {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("`" + caseconvention + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
      }
      return (result.toString());
    }
  }

  public static StringHashTable idlCreateReservedWordTable() {
    { StringHashTable table = StringHashTable.newStringHashTable();

      { Stella_Object word = null;
        Cons iter000 = Cons.list$(Cons.cons(Stella.SYM_STELLA_ASM, Cons.cons(Stella.SYM_STELLA_AUTO, Cons.cons(Stella.SYM_STELLA_BREAK, Cons.cons(Stella.SYM_STELLA_CASE, Cons.cons(Stella.SYM_STELLA_CATCH, Cons.cons(Stella.SYM_STELLA_CHAR, Cons.cons(Stella.SYM_STELLA_CLASS, Cons.cons(Stella.SYM_STELLA_CONST, Cons.cons(Stella.SYM_STELLA_CONTINUE, Cons.cons(Stella.SYM_STELLA_DEFAULT, Cons.cons(Stella.SYM_STELLA_DELETE, Cons.cons(Stella.SYM_STELLA_DO, Cons.cons(Stella.SYM_STELLA_DOUBLE, Cons.cons(Stella.SYM_STELLA_ELSE, Cons.cons(Stella.SYM_STELLA_ENUM, Cons.cons(Stella.SYM_STELLA_EXTERN, Cons.cons(Stella.SYM_STELLA_FLOAT, Cons.cons(Stella.SYM_STELLA_FOR, Cons.cons(Stella.SYM_STELLA_FRIEND, Cons.cons(Stella.SYM_STELLA_GOTO, Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(Stella.SYM_STELLA_INLINE, Cons.cons(Stella.SYM_STELLA_INT, Cons.cons(Stella.SYM_STELLA_LONG, Cons.cons(Stella.SYM_STELLA_NEW, Cons.cons(Stella.SYM_STELLA_OPERATOR, Cons.cons(Stella.SYM_STELLA_PRIVATE, Cons.cons(Stella.SYM_STELLA_PROTECTED, Cons.cons(Stella.SYM_STELLA_PUBLIC, Cons.cons(Stella.SYM_STELLA_REGISTER, Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_SHORT, Cons.cons(Stella.SYM_STELLA_SIGNED, Cons.cons(Stella.SYM_STELLA_SIZEOF, Cons.cons(Stella.SYM_STELLA_STATIC, Cons.cons(Stella.SYM_STELLA_STRUCT, Cons.cons(Stella.SYM_STELLA_SWITCH, Cons.cons(Stella.SYM_STELLA_TEMPLATE, Cons.cons(Stella.SYM_STELLA_THROW, Cons.cons(Stella.SYM_STELLA_TRY, Cons.cons(Stella.SYM_STELLA_TYPEDEF, Cons.cons(Stella.SYM_STELLA_UNION, Cons.cons(Stella.SYM_STELLA_UNSIGNED, Cons.cons(Stella.SYM_STELLA_VIRTUAL, Cons.cons(Stella.SYM_STELLA_VOID, Cons.cons(Stella.SYM_STELLA_VOLATILE, Cons.cons(Stella.SYM_STELLA_WHILE, Cons.cons(Stella.SYM_STELLA_TYPENAME, Cons.cons(Stella.NIL, Stella.NIL))))))))))))))))))))))))))))))))))))))))))))))))));

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          word = iter000.value;
          table.insertAt(((Symbol)(word)).symbolName, Symbol.idlYieldRenamedReservedWord(((Symbol)(word))));
        }
      }
      table.insertAt("++", StringWrapper.wrapString("stella_Increment"));
      table.insertAt("--", StringWrapper.wrapString("stella_Decrement"));
      return (table);
    }
  }

  public static Cons idlYieldInitialNullValue() {
    return (((Cons)(Stella_Object.idlTranslateATree(null))));
  }

  public static String idlMakeCodeOutputFileName(String sourcefile) {
    return (Stella.fileNameWithoutExtension(sourcefile) + Stella.$IDL_TRANSLATED_FILE_SUFFIX$ + ".sidl");
  }

  public static void idlOutputAllUnitsToFile(String sourcefile) {
    { String codeoutputfile = Stella.idlMakeCodeOutputFileName(sourcefile);
      OutputFileStream codeoutputstream = OutputFileStream.newOutputFileStream(codeoutputfile);
      Cons globals = Stella.NIL;
      Cons methods = Stella.NIL;
      Cons verbatimstatements = Stella.NIL;
      Cons forms = Stella.NIL;

      { Object old$CurrentStream$000 = Stella.$CURRENT_STREAM$.get();

        try {
          Native.setSpecial(Stella.$CURRENT_STREAM$, codeoutputstream);
          Native.setSpecial(Stella.$TRANSLATIONUNITS$, ((List)(Stella.$TRANSLATIONUNITS$.get())).reverse());
          { TranslationUnit unit = null;
            Cons iter000 = ((List)(Stella.$TRANSLATIONUNITS$.get())).theConsList;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              unit = ((TranslationUnit)(iter000.value));
              { Symbol testValue000 = unit.category;

                if ((testValue000 == Stella.SYM_STELLA_METHOD) ||
                    ((testValue000 == Stella.SYM_STELLA_PRINT_METHOD) ||
                     (testValue000 == Stella.SYM_STELLA_MACRO))) {
                  methods = Cons.cons(unit.translation, methods);
                }
                else if (testValue000 == Stella.SYM_STELLA_VERBATIM) {
                  verbatimstatements = Cons.cons(unit.translation, verbatimstatements);
                }
                else if (testValue000 == Stella.SYM_STELLA_GLOBAL_VARIABLE) {
                  globals = Cons.cons(unit.translation, globals);
                }
                else {
                  forms = Cons.cons(unit.translation, forms);
                }
              }
            }
          }
          Stella.STANDARD_OUTPUT.nativeStream.println("Writing `" + codeoutputfile + "'...");
          {
            ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("// " + codeoutputfile);
            ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
          }
;
          if (Stella.translateWithCopyrightHeaderP()) {
            OutputStream.outputCopyrightHeader(((OutputStream)(Stella.$CURRENT_STREAM$.get())));
          }
          { Stella_Object form = null;
            Cons iter001 = forms;

            for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              form = iter001.value;
              Stella_Object.idlOutputStatement(((Cons)(form)));
            }
          }
          codeoutputstream.free();

        } finally {
          Stella.$CURRENT_STREAM$.set(old$CurrentStream$000);
        }
      }
    }
  }

  public static void idlTranslateFile(String filename) {
    Stella.translateFile(filename, Stella.KWD_IDL, false);
  }

  public static void idlIndent() {
    { int i = Stella.NULL_INTEGER;
      int iter000 = 1;
      int upperBound000 = ((Integer)(Stella.$IDL_INDENT_CHARS$.get())).intValue();
      boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

      for (;unboundedP000 ||
                (iter000 <= upperBound000); iter000 = iter000 + 1) {
        i = iter000;
        i = i;
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
      }
    }
  }

  public static void idlBumpIndent() {
    Native.setIntSpecial(Stella.$IDL_INDENT_CHARS$, ((Integer)(Stella.$IDL_INDENT_CHARS$.get())).intValue() + 2);
  }

  public static void idlUnbumpIndent() {
    Native.setIntSpecial(Stella.$IDL_INDENT_CHARS$, ((Integer)(Stella.$IDL_INDENT_CHARS$.get())).intValue() - 2);
  }

  public static void string_idlOutputLiteral(String string) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("\"" + Stella.replaceSubstrings(Stella.replaceSubstrings(Stella.replaceSubstrings(Stella.replaceSubstrings(string, "\\\\", "\\"), "\\\"", Native.makeString(1, '"')), "\\n", Native.makeString(1, '\n')), "\\r", Native.makeString(1, '\r')) + "\"");
  }

  public static boolean idlOutputTemplateClassesP() {
    return (true);
  }

  /** Helper function that returns <code>true</code> if <code>currentDepth</code> exceeds <code>depthLimit</code>.
   * This functions uses the convention that a <code>null</code> or negative value of
   * <code>depthLimit</code> means the depth is unlimited.  In those cases it always
   * returns false.
   * @param currentDepth
   * @param depthLimit
   * @return boolean
   */
  public static boolean outlineDepthExceededP(int currentDepth, int depthLimit) {
    return ((depthLimit != Stella.NULL_INTEGER) &&
        ((depthLimit >= 0) &&
         (currentDepth >= depthLimit)));
  }

  /** Helper function that indents outline printings for level
   * <code>currentDepth</code> on <code>stream</code> using the value of the global
   * variable <code>$OUTLINE_INDENT_STRING$</code>
   * @param currentDepth
   * @param stream
   */
  public static void indentOutline(int currentDepth, OutputStream stream) {
    { int i = Stella.NULL_INTEGER;
      int iter000 = 1;
      int upperBound000 = currentDepth;
      boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

      for (;unboundedP000 ||
                (iter000 <= upperBound000); iter000 = iter000 + 1) {
        i = iter000;
        i = i;
        stream.nativeStream.print(Stella.$OUTLINE_INDENT_STRING$);
      }
    }
  }

  /** Return a string identifying the current version of STELLA.
   * @return String
   */
  public static String stellaVersionString() {
    return ("STELLA " + Native.integerToString(((long)(Stella.$STELLA_MAJOR_VERSION_NUMBER$))) + "." + Native.integerToString(((long)(Stella.$STELLA_MINOR_VERSION_NUMBER$))) + "." + Native.integerToString(((long)(Stella.$STELLA_PATCH_LEVEL$))) + Stella.$STELLA_RELEASE_STATE$);
  }

  /** Returns information about the current Stella implementation.
   * Useful when reporting problems.
   * @return String
   */
  public static String stellaInformation() {
    return (Stella.$STELLA_VERSION_STRING$ + " [" + Stella.runningInLanguage().symbolName + "]" + Stella.runningSystemInformation());
  }

  public static boolean currentStartupTimePhaseP(int phase) {
    return ((Stella.$STARTUP_TIME_PHASE$ == 999) ||
        (phase == Stella.$STARTUP_TIME_PHASE$));
  }

  public static void startupKernel(boolean verboseP) {
    { int phase = Stella.NULL_INTEGER;
      int iter000 = 0;
      int upperBound000 = 9;

      loop000 : for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
        phase = iter000;
        Stella.$STARTUP_TIME_PHASE$ = phase;
        if (verboseP) {
          if (phase == 0) {
          }
          else if (phase == 2) {
            Stella.STANDARD_OUTPUT.nativeStream.println("Running kernel startup code...");
            Stella.STANDARD_OUTPUT.nativeStream.println("Initializing symbol tables...");
          }
          else if (phase == 3) {
            Stella.STANDARD_OUTPUT.nativeStream.println("Initializing quoted constants...");
          }
          else if (phase == 4) {
            Stella.STANDARD_OUTPUT.nativeStream.println("Initializing global variables...");
          }
          else if (phase == 5) {
            Stella.STANDARD_OUTPUT.nativeStream.println("Creating class objects...");
          }
          else if (phase == 6) {
            Stella.STANDARD_OUTPUT.nativeStream.println("Finalizing classes...");
          }
          else if (phase == 7) {
            Stella.STANDARD_OUTPUT.nativeStream.println("Creating method objects...");
          }
          else if (phase == 8) {
            Stella.STANDARD_OUTPUT.nativeStream.println("Finalizing methods...");
          }
          else if (phase == 9) {
            Stella.STANDARD_OUTPUT.nativeStream.println("Running non-phased startup code...");
          }
        }
        if (phase == 6) {
          Stella.finalizeClasses();
          Stella.$CLASS_HIERARCHY_BOOTEDp$ = true;
          continue loop000;
        }
        if (phase == 8) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
          continue loop000;
        }
        _StartupStartup.startupStartup();
        Native.startupJavaNative();
        _StartupPrimal.startupPrimal();
        _StartupTypePredicates.startupTypePredicates();
        _StartupConses.startupConses();
        _StartupHierarchy.startupHierarchy();
        _StartupTaxonomies.startupTaxonomies();
        _StartupLists.startupLists();
        _StartupCollections.startupCollections();
        _StartupIterators.startupIterators();
        _StartupLiterals.startupLiterals();
        _StartupSymbols.startupSymbols();
        _StartupClasses.startupClasses();
        _StartupMethods.startupMethods();
        _StartupDefclass.startupDefclass();
        _StartupStellaIn.startupStellaIn();
        _StartupForeach.startupForeach();
        _StartupWalk.startupWalk();
        _StartupDynamicSlots.startupDynamicSlots();
        _StartupDynamicLiteralSlots.startupDynamicLiteralSlots();
        _StartupSystems.startupSystems();
        _StartupClTranslate.startupClTranslate();
        _StartupMacros.startupMacros();
        _StartupMemoize.startupMemoize();
        _StartupStreams.startupStreams();
        _StartupDescribe.startupDescribe();
        _StartupDemons.startupDemons();
        _StartupMoreDemons.startupMoreDemons();
        _StartupNameUtility.startupNameUtility();
        _StartupModules.startupModules();
        _StartupContexts.startupContexts();
        _StartupRead.startupRead();
        _StartupXml.startupXml();
        _StartupDateTime.startupDateTime();
        _StartupDateTimeParser.startupDateTimeParser();
      }
    }
  }

  public static void startupCppTranslator() {
    _StartupCppTranslate.startupCppTranslate();
    _StartupCppClassOut.startupCppClassOut();
    _StartupCppOutput.startupCppOutput();
    _StartupCppTranslateFile.startupCppTranslateFile();
  }

  public static void startupJavaTranslator() {
    _StartupJavaTranslate.startupJavaTranslate();
    _StartupJavaClassOut.startupJavaClassOut();
    _StartupJavaOutput.startupJavaOutput();
    _StartupJavaTranslateFile.startupJavaTranslateFile();
  }

  public static void startupIdlTranslator() {
    _StartupIdlTranslate.startupIdlTranslate();
    _StartupIdlClassOut.startupIdlClassOut();
    _StartupIdlOutput.startupIdlOutput();
    _StartupIdlTranslateFile.startupIdlTranslateFile();
  }

  public static void startup(boolean verboseP) {
    Stella.startupKernel(verboseP);
    if (verboseP) {
      Stella.STANDARD_OUTPUT.nativeStream.println("Starting up translators...");
    }
    { int phase = Stella.NULL_INTEGER;
      int iter000 = 0;
      int upperBound000 = 9;

      for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
        phase = iter000;
        Stella.$STARTUP_TIME_PHASE$ = phase;
        _StartupTranslateFile.startupTranslateFile();
        _StartupClTranslateFile.startupClTranslateFile();
        Stella.startupCppTranslator();
        Stella.startupJavaTranslator();
        Stella.startupIdlTranslator();
        _StartupTools.startupTools();
      }
    }
    Stella.$STARTUP_TIME_PHASE$ = 999;
    Stella.sweepTransients();
  }

  /** Old name for <code>processCommandLineArguments</code> (which see).
   * @param count
   * @param arguments
   */
  public static void interpretCommandLineArguments(int count, String[] arguments) {
    Stella.processCommandLineArguments(count, arguments, Stella.KWD_WARN);
  }

  /** Convert <code>count</code> command line <code>arguments</code> into a CONS list.
   * @param count
   * @param arguments
   * @return Cons
   */
  public static Cons consifyCommandLineArguments(int count, String[] arguments) {
    { Cons result = Stella.NIL;

      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = count - 1;
        Cons collect000 = null;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(StringWrapper.wrapString(arguments[i]), Stella.NIL);
              if (result == Stella.NIL) {
                result = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(result, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(StringWrapper.wrapString(arguments[i]), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (result);
    }
  }

  public static void main(String[] arguments) {
    { int count = arguments.length;

      { boolean testingP = count == 0;

        Stella.startup(testingP);
        StartupStellaSystem.startupStellaSystem();
        Stella.STANDARD_OUTPUT.nativeStream.println("Welcome to " + Stella.stellaVersionString());
        Stella.interpretCommandLineArguments(count, arguments);
        if (testingP) {
          Stella.STANDARD_OUTPUT.nativeStream.println("Bye!");
        }
      }
    }
  }

}
