//  -*- Mode: Java -*-
//
// _StartupHierarchy.java

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

public class _StartupHierarchy {
  static void helpStartupHierarchy1() {
    {
      Stella.SYM_STELLA_TYPE_SPEC = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TYPE-SPEC", null, 0)));
      Stella.SYM_STELLA_REFERENCE_COUNT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("REFERENCE-COUNT", null, 0)));
      Stella.SYM_STELLA_BADp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BAD?", null, 0)));
      Stella.SYM_STELLA_DELETED_OBJECTp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DELETED-OBJECT?", null, 0)));
      Stella.SYM_STELLA_FIRST_ITERATIONp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FIRST-ITERATION?", null, 0)));
      Stella.SYM_STELLA_OBJECT_ITERATOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OBJECT-ITERATOR", null, 0)));
      Stella.SGT_STELLA_CONS_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONS-ITERATOR", null, 1)));
      Stella.SYM_STELLA_CONS_ITERATOR_CURSOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CONS-ITERATOR-CURSOR", null, 0)));
      Stella.SGT_STELLA_LIST_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("LIST-ITERATOR", null, 1)));
      Stella.SYM_STELLA_LIST_ITERATOR_CURSOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LIST-ITERATOR-CURSOR", null, 0)));
      Stella.SYM_STELLA_LIST_ITERATOR_COLLECTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LIST-ITERATOR-COLLECTION", null, 0)));
      Stella.SGT_STELLA_DESTRUCTIVE_LIST_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DESTRUCTIVE-LIST-ITERATOR", null, 1)));
      Stella.SYM_STELLA_THE_CONS_LIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("THE-CONS-LIST", null, 0)));
      Stella.SGT_STELLA_ALL_PURPOSE_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("ALL-PURPOSE-ITERATOR", null, 1)));
      Stella.SYM_STELLA_KEY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("KEY", null, 0)));
      Stella.SYM_STELLA_ITERATOR_NEXT_CODE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ITERATOR-NEXT-CODE", null, 0)));
      Stella.SYM_STELLA_ITERATOR_FILTER_CODE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ITERATOR-FILTER-CODE", null, 0)));
      Stella.SYM_STELLA_ITERATOR_EMPTY_CODE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ITERATOR-EMPTY-CODE", null, 0)));
      Stella.SYM_STELLA_ITERATOR_NESTED_ITERATOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ITERATOR-NESTED-ITERATOR", null, 0)));
      Stella.SYM_STELLA_ITERATOR_CONS_LIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ITERATOR-CONS-LIST", null, 0)));
      Stella.SYM_STELLA_ITERATOR_OBJECT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ITERATOR-OBJECT", null, 0)));
      Stella.SYM_STELLA_ITERATOR_SECOND_OBJECT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ITERATOR-SECOND-OBJECT", null, 0)));
      Stella.SYM_STELLA_ITERATOR_INTEGER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ITERATOR-INTEGER", null, 0)));
      Stella.SYM_STELLA_ITERATOR_SECOND_INTEGER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ITERATOR-SECOND-INTEGER", null, 0)));
      Stella.SGT_STELLA_TYPES_TO_CLASSES_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TYPES-TO-CLASSES-ITERATOR", null, 1)));
      Stella.SYM_STELLA_ITERATOR_CURSOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ITERATOR-CURSOR", null, 0)));
      Stella.SYM_STELLA_OBJECT_DICTIONARY_ITERATOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OBJECT-DICTIONARY-ITERATOR", null, 0)));
      Stella.SGT_STELLA_PROPERTY_LIST_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PROPERTY-LIST-ITERATOR", null, 1)));
      Stella.SYM_STELLA_PLIST_ITERATOR_CURSOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PLIST-ITERATOR-CURSOR", null, 0)));
      Stella.SYM_STELLA_PLIST_ITERATOR_COLLECTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PLIST-ITERATOR-COLLECTION", null, 0)));
      Stella.SGT_STELLA_KV_LIST_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("KV-LIST-ITERATOR", null, 1)));
      Stella.SYM_STELLA_THE_KV_LIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("THE-KV-LIST", null, 0)));
      Stella.SYM_STELLA_KV_LIST_ITERATOR_CURSOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("KV-LIST-ITERATOR-CURSOR", null, 0)));
      Stella.SGT_STELLA_INTEGER_INTERVAL_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INTEGER-INTERVAL-ITERATOR", null, 1)));
      Stella.SYM_STELLA_INTERVAL_CURSOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INTERVAL-CURSOR", null, 0)));
      Stella.SYM_STELLA_LOWER_BOUND = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LOWER-BOUND", null, 0)));
      Stella.SYM_STELLA_UPPER_BOUND = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UPPER-BOUND", null, 0)));
      Stella.SGT_STELLA_REVERSE_INTEGER_INTERVAL_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("REVERSE-INTEGER-INTERVAL-ITERATOR", null, 1)));
      Stella.SGT_STELLA_STRING_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("STRING-ITERATOR", null, 1)));
      Stella.SYM_STELLA_THE_STRING = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("THE-STRING", null, 0)));
      Stella.SYM_STELLA_CURSOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CURSOR", null, 0)));
      Stella.SYM_STELLA_END = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("END", null, 0)));
      Stella.SYM_STELLA_OBJECT_COLLECTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OBJECT-COLLECTION", null, 0)));
      Stella.SYM_STELLA_OBJECT_SEQUENCE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OBJECT-SEQUENCE", null, 0)));
      Stella.SGT_STELLA_LIST = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("LIST", null, 1)));
      Stella.SGT_STELLA_SET = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SET", null, 1)));
      Stella.SGT_STELLA_CLASS_EXTENSION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-EXTENSION", null, 1)));
      Stella.SGT_STELLA_CONS = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONS", null, 1)));
      Stella.SYM_STELLA_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VALUE", null, 0)));
      Stella.SYM_STELLA_REST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("REST", null, 0)));
      Stella.SYM_STELLA_OBJECT_TO_OBJECT_DICTIONARY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OBJECT-TO-OBJECT-DICTIONARY", null, 0)));
      Stella.SGT_STELLA_PROPERTY_LIST = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PROPERTY-LIST", null, 1)));
      Stella.SYM_STELLA_THE_PLIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("THE-PLIST", null, 0)));
      Stella.SGT_STELLA_KV_CONS = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("KV-CONS", null, 1)));
      Stella.SGT_STELLA_KEY_VALUE_LIST = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("KEY-VALUE-LIST", null, 1)));
      Stella.SGT_STELLA_RECYCLE_LIST = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("RECYCLE-LIST", null, 1)));
      Stella.SYM_STELLA_RECYCLE_LIST_OF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RECYCLE-LIST-OF", null, 0)));
      Stella.SYM_STELLA_RECYCLED_ITEMS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RECYCLED-ITEMS", null, 0)));
      Stella.SYM_STELLA_LIST_OF_RECYCLED_ITEMS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LIST-OF-RECYCLED-ITEMS", null, 0)));
      Stella.SYM_STELLA_ALL_ITEMS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ALL-ITEMS", null, 0)));
    }
  }

  static void helpStartupHierarchy2() {
    {
      Stella.SYM_STELLA_UNUSED_ITEMS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UNUSED-ITEMS", null, 0)));
      Stella.SYM_STELLA_CURRENT_LENGTH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CURRENT-LENGTH", null, 0)));
      Stella.SYM_STELLA_ITEM_SIZE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ITEM-SIZE", null, 0)));
      Stella.SYM_STELLA_THE_STELLA_HASH_TABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("THE-STELLA-HASH-TABLE", null, 0)));
      Stella.SGT_STELLA_HASH_TABLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("HASH-TABLE", null, 1)));
      Stella.SYM_STELLA_OBJECT_TO_OBJECT_HASH_TABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OBJECT-TO-OBJECT-HASH-TABLE", null, 0)));
      Stella.SGT_STELLA_INTEGER_HASH_TABLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INTEGER-HASH-TABLE", null, 1)));
      Stella.SGT_STELLA_FLOAT_HASH_TABLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FLOAT-HASH-TABLE", null, 1)));
      Stella.SGT_STELLA_STRING_HASH_TABLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("STRING-HASH-TABLE", null, 1)));
      Stella.SGT_STELLA_STRING_TO_INTEGER_HASH_TABLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("STRING-TO-INTEGER-HASH-TABLE", null, 1)));
      Stella.SGT_STELLA_VECTOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("VECTOR", null, 1)));
      Stella.SYM_STELLA_ARRAY_SIZE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ARRAY-SIZE", null, 0)));
      Stella.SGT_STELLA_EXTENSIBLE_VECTOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("EXTENSIBLE-VECTOR", null, 1)));
      Stella.SGT_STELLA_EXTENSIBLE_SYMBOL_ARRAY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("EXTENSIBLE-SYMBOL-ARRAY", null, 1)));
      Stella.SYM_STELLA_TOP_SYMBOL_OFFSET = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TOP-SYMBOL-OFFSET", null, 0)));
      Stella.SYM_STELLA_POTENTIAL_FREE_SYMBOL_OFFSET = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("POTENTIAL-FREE-SYMBOL-OFFSET", null, 0)));
      Stella.SGT_STELLA_VECTOR_SEQUENCE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("VECTOR-SEQUENCE", null, 1)));
      Stella.SYM_STELLA_SEQUENCE_LENGTH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SEQUENCE-LENGTH", null, 0)));
      Stella.SGT_STELLA_CUSTOM_VECTOR_SEQUENCE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CUSTOM-VECTOR-SEQUENCE", null, 1)));
      Stella.SYM_STELLA_RESIZE_FACTOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RESIZE-FACTOR", null, 0)));
      Stella.SGT_STELLA_BOOLEAN_VECTOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("BOOLEAN-VECTOR", null, 1)));
      Stella.SGT_STELLA_INTEGER_VECTOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INTEGER-VECTOR", null, 1)));
      Stella.SGT_STELLA_ACTIVE_LIST = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("ACTIVE-LIST", null, 1)));
      Stella.SGT_STELLA_ACTIVE_SET = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("ACTIVE-SET", null, 1)));
      Stella.SGT_STELLA_DEMON = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DEMON", null, 1)));
      Stella.SYM_STELLA_DEMON_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEMON-NAME", null, 0)));
      Stella.SYM_STELLA_DEMON_ACTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEMON-ACTION", null, 0)));
      Stella.SYM_STELLA_DEMON_CLASS_REFS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEMON-CLASS-REFS", null, 0)));
      Stella.SYM_STELLA_DEMON_SLOT_REFS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEMON-SLOT-REFS", null, 0)));
      Stella.SYM_STELLA_DEMON_CODE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEMON-CODE", null, 0)));
      Stella.SYM_STELLA_DEMON_METHOD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEMON-METHOD", null, 0)));
      Stella.SYM_STELLA_DEMON_DOCUMENTATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEMON-DOCUMENTATION", null, 0)));
      Stella.SYM_STELLA_DEMON_GUARDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEMON-GUARD?", null, 0)));
      Stella.SYM_STELLA_DEMON_ALLp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEMON-ALL?", null, 0)));
      Stella.SYM_STELLA_DEMON_INHERITp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEMON-INHERIT?", null, 0)));
      Stella.SGT_STELLA_KEYWORD_KEY_VALUE_LIST = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("KEYWORD-KEY-VALUE-LIST", null, 1)));
      Stella.SYM_STELLA_SYMBOL_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SYMBOL-NAME", null, 0)));
      Stella.SYM_STELLA_SYMBOL_ID = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SYMBOL-ID", null, 0)));
      Stella.SYM_STELLA_INTERNED_IN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INTERNED-IN", null, 0)));
      Stella.SGT_STELLA_SYMBOL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SYMBOL", null, 1)));
      Stella.SYM_STELLA_SYMBOL_SLOT_OFFSET = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SYMBOL-SLOT-OFFSET", null, 0)));
      Stella.SYM_STELLA_SYMBOL_VALUE_AND_PLIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SYMBOL-VALUE-AND-PLIST", null, 0)));
      Stella.SGT_STELLA_SURROGATE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SURROGATE", null, 1)));
      Stella.SYM_STELLA_SURROGATE_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SURROGATE-VALUE", null, 0)));
      Stella.SYM_STELLA_SURROGATE_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SURROGATE-NAME", null, 0)));
      Stella.SYM_STELLA_TYPE_CLASS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TYPE-CLASS", null, 0)));
      Stella.SYM_STELLA_TYPE_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TYPE-NAME", null, 0)));
      Stella.SYM_STELLA_SLOTREF_SLOT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOTREF-SLOT", null, 0)));
      Stella.SYM_STELLA_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TYPE", null, 0)));
      Stella.SYM_STELLA_SLOTREF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOTREF", null, 0)));
      Stella.SGT_STELLA_KEYWORD = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("KEYWORD", null, 1)));
      Stella.SYM_STELLA_KEYWORD_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("KEYWORD-NAME", null, 0)));
      Stella.SGT_STELLA_TRANSIENT_SYMBOL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TRANSIENT-SYMBOL", null, 1)));
      Stella.SYM_STELLA_PROJECTS_ONTO = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PROJECTS-ONTO", null, 0)));
      Stella.SYM_STELLA_PROJECTED_FROM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PROJECTED-FROM", null, 0)));
      Stella.SYM_STELLA_PROPERTIES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PROPERTIES", null, 0)));
      Stella.SYM_STELLA_ABSTRACTp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ABSTRACT?", null, 0)));
      Stella.SGT_STELLA_CLASS = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS", null, 1)));
      Stella.SYM_STELLA_STORED_ACTIVEp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STORED-ACTIVE?", null, 0)));
      Stella.SGT_STELLA_ACTIVE_OBJECT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("ACTIVE-OBJECT", null, 1)));
    }
  }

  static void helpStartupHierarchy3() {
    {
      Stella.SYM_STELLA_CLASS_CREATOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-CREATOR", null, 0)));
      Stella.SYM_STELLA_CLASS_INITIALIZER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-INITIALIZER", null, 0)));
      Stella.SYM_STELLA_CLASS_TERMINATOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-TERMINATOR", null, 0)));
      Stella.SYM_STELLA_CLASS_DESTRUCTOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-DESTRUCTOR", null, 0)));
      Stella.SYM_STELLA_CLASS_PARAMETERS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-PARAMETERS", null, 0)));
      Stella.SYM_STELLA_CLASS_INITIAL_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-INITIAL-VALUE", null, 0)));
      Stella.SYM_STELLA_CLASS_EXTENSION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-EXTENSION", null, 0)));
      Stella.SYM_STELLA_CLASS_CL_NATIVE_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-CL-NATIVE-TYPE", null, 0)));
      Stella.SYM_STELLA_CLASS_CPP_NATIVE_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-CPP-NATIVE-TYPE", null, 0)));
      Stella.SYM_STELLA_CLASS_JAVA_NATIVE_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-JAVA-NATIVE-TYPE", null, 0)));
      Stella.SYM_STELLA_CLASS_CL_STRUCT_SLOTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-CL-STRUCT-SLOTS", null, 0)));
      Stella.SYM_STELLA_CLASS_RECYCLE_METHOD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-RECYCLE-METHOD", null, 0)));
      Stella.KWD_NONE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NONE", null, 2)));
      Stella.SYM_STELLA_CLASS_REQUIRED_SLOT_NAMES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-REQUIRED-SLOT-NAMES", null, 0)));
      Stella.SYM_STELLA_CLASS_GUARD_CONSTRUCTOR_DEMONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-GUARD-CONSTRUCTOR-DEMONS", null, 0)));
      Stella.SYM_STELLA_CLASS_CONSTRUCTOR_DEMONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-CONSTRUCTOR-DEMONS", null, 0)));
      Stella.SYM_STELLA_CLASS_GUARD_DESTRUCTOR_DEMONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-GUARD-DESTRUCTOR-DEMONS", null, 0)));
      Stella.SYM_STELLA_CLASS_DESTRUCTOR_DEMONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-DESTRUCTOR-DEMONS", null, 0)));
      Stella.SYM_STELLA_CLASS_KEY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-KEY", null, 0)));
      Stella.SYM_STELLA_CLASS_SYNONYMS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-SYNONYMS", null, 0)));
      Stella.SYM_STELLA_CL_STRUCTp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CL-STRUCT?", null, 0)));
      Stella.SYM_STELLA_MIXINp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MIXIN?", null, 0)));
      Stella.SYM_STELLA_CLASS_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-TYPE", null, 0)));
      Stella.SYM_STELLA_CLASS_ARITY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-ARITY", null, 0)));
      Stella.SYM_STELLA_CLASS_DIRECT_SUPERS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-DIRECT-SUPERS", null, 0)));
      Stella.SYM_STELLA_CLASS_DIRECT_SUBS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-DIRECT-SUBS", null, 0)));
      Stella.SYM_STELLA_CLASS_ALL_SUPER_CLASSES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-ALL-SUPER-CLASSES", null, 0)));
      Stella.SYM_STELLA_CLASS_ALL_SLOTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-ALL-SLOTS", null, 0)));
      Stella.SYM_STELLA_CLASS_LOCAL_SLOTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-LOCAL-SLOTS", null, 0)));
      Stella.SYM_STELLA_CLASS_SLOT_AND_METHOD_CACHE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-SLOT-AND-METHOD-CACHE", null, 0)));
      Stella.SYM_STELLA_CLASS_ABSTRACTp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-ABSTRACT?", null, 0)));
      Stella.SYM_STELLA_CLASS_MIXINp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-MIXIN?", null, 0)));
      Stella.SYM_STELLA_CLASS_COLLECTIONp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-COLLECTION?", null, 0)));
      Stella.SYM_STELLA_CLASS_CL_STRUCTp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-CL-STRUCT?", null, 0)));
      Stella.SYM_STELLA_CLASS_PUBLICp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-PUBLIC?", null, 0)));
      Stella.SYM_STELLA_CLASS_FINALIZEDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-FINALIZED?", null, 0)));
      Stella.SYM_STELLA_CLASS_SLOTS_FINALIZEDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-SLOTS-FINALIZED?", null, 0)));
      Stella.SYM_STELLA_CLASS_STRINGIFIED_SOURCE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-STRINGIFIED-SOURCE", null, 0)));
      Stella.SYM_STELLA_CLASS_CONSTRUCTOR_CODE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-CONSTRUCTOR-CODE", null, 0)));
      Stella.SYM_STELLA_CLASS_SLOT_ACCESSOR_CODE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-SLOT-ACCESSOR-CODE", null, 0)));
      Stella.SYM_STELLA_CLASS_MARKEDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-MARKED?", null, 0)));
      Stella.SYM_STELLA_CLASS_TAXONOMY_NODE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-TAXONOMY-NODE", null, 0)));
      Stella.SYM_STELLA_CLASS_DOCUMENTATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-DOCUMENTATION", null, 0)));
      Stella.SYM_STELLA_CLASS_PRINT_FORM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-PRINT-FORM", null, 0)));
      Stella.SYM_STELLA_DOCUMENTATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DOCUMENTATION", null, 0)));
      Stella.SYM_STELLA_PRINT_FORM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PRINT-FORM", null, 0)));
      Stella.SYM_STELLA_SLOT_DIRECT_EQUIVALENT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-DIRECT-EQUIVALENT", null, 0)));
      Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-TYPE-SPECIFIER", null, 0)));
      Stella.SYM_STELLA_SLOT_HOME_MODULE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-HOME-MODULE", null, 0)));
      Stella.SYM_STELLA_SLOT_RENAMES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-RENAMES", null, 0)));
      Stella.SGT_STELLA_COLLECTION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("COLLECTION", null, 1)));
      Stella.SYM_STELLA_SLOT_CLOSURE_ASSUMPTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-CLOSURE-ASSUMPTION", null, 0)));
      Stella.SYM_STELLA_SLOT_DIRECT_SUPERS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-DIRECT-SUPERS", null, 0)));
      Stella.SYM_STELLA_SLOT_DIRECT_SUBS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-DIRECT-SUBS", null, 0)));
      Stella.SYM_STELLA_SLOT_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-NAME", null, 0)));
      Stella.SYM_STELLA_SLOT_OWNER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-OWNER", null, 0)));
      Stella.SYM_STELLA_SLOT_BASE_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-BASE-TYPE", null, 0)));
      Stella.SYM_STELLA_SLOT_SLOTREF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-SLOTREF", null, 0)));
      Stella.SYM_STELLA_SLOT_PUBLICp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-PUBLIC?", null, 0)));
      Stella.SYM_STELLA_SLOT_RENAMEDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-RENAMED?", null, 0)));
    }
  }

  static void helpStartupHierarchy4() {
    {
      Stella.SYM_STELLA_SLOT_EXTERNALp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-EXTERNAL?", null, 0)));
      Stella.SYM_STELLA_SLOT_MARKEDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-MARKED?", null, 0)));
      Stella.SYM_STELLA_SLOT_DOCUMENTATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-DOCUMENTATION", null, 0)));
      Stella.SGT_STELLA_STORAGE_SLOT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("STORAGE-SLOT", null, 1)));
      Stella.SYM_STELLA_SLOT_ALLOCATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-ALLOCATION", null, 0)));
      Stella.KWD_INSTANCE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INSTANCE", null, 2)));
      Stella.SYM_STELLA_SLOT_DEFAULT_EXPRESSION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-DEFAULT-EXPRESSION", null, 0)));
      Stella.SYM_STELLA_SLOT_READER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-READER", null, 0)));
      Stella.SYM_STELLA_SLOT_WRITER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-WRITER", null, 0)));
      Stella.SYM_STELLA_SLOT_GUARD_DEMONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-GUARD-DEMONS", null, 0)));
      Stella.SYM_STELLA_SLOT_DEMONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-DEMONS", null, 0)));
      Stella.SYM_STELLA_SLOT_REQUIREDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-REQUIRED?", null, 0)));
      Stella.SYM_STELLA_SLOT_COMPONENTp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-COMPONENT?", null, 0)));
      Stella.SYM_STELLA_SLOT_READ_ONLYp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-READ-ONLY?", null, 0)));
      Stella.SYM_STELLA_SLOT_HARDWIREDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-HARDWIRED?", null, 0)));
      Stella.SYM_STELLA_SLOT_CONTEXT_SENSITIVEp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-CONTEXT-SENSITIVE?", null, 0)));
      Stella.SGT_STELLA_METHOD_SLOT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-SLOT", null, 1)));
      Stella.SYM_STELLA_METHOD_PARAMETER_DIRECTIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-PARAMETER-DIRECTIONS", null, 0)));
      Stella.SYM_STELLA_METHOD_INLINED_FUNCTIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-INLINED-FUNCTIONS", null, 0)));
      Stella.SYM_STELLA_METHOD_EVALUATE_ARGUMENTSp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-EVALUATE-ARGUMENTS?", null, 0)));
      Stella.SYM_STELLA_METHOD_SETTERp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-SETTER?", null, 0)));
      Stella.SYM_STELLA_METHOD_PARAMETER_NAMES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-PARAMETER-NAMES", null, 0)));
      Stella.SYM_STELLA_METHOD_PARAMETER_TYPE_SPECIFIERS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-PARAMETER-TYPE-SPECIFIERS", null, 0)));
      Stella.SYM_STELLA_METHOD_RETURN_TYPE_SPECIFIERS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-RETURN-TYPE-SPECIFIERS", null, 0)));
      Stella.SYM_STELLA_METHOD_STRINGIFIED_SOURCE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-STRINGIFIED-SOURCE", null, 0)));
      Stella.SYM_STELLA_METHOD_CODE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-CODE", null, 0)));
      Stella.SYM_STELLA_FUNCTION_CODE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FUNCTION-CODE", null, 0)));
      Stella.SYM_STELLA_METHOD_FUNCTIONp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-FUNCTION?", null, 0)));
      Stella.SYM_STELLA_METHOD_DOCUMENTATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-DOCUMENTATION", null, 0)));
      Stella.SYM_STELLA_METHOD_AUXILIARYp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-AUXILIARY?", null, 0)));
      Stella.SYM_STELLA_METHOD_STORAGE_SLOT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-STORAGE-SLOT", null, 0)));
      Stella.SYM_STELLA_SLOT_AUXILIARYp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-AUXILIARY?", null, 0)));
      Stella.SYM_STELLA_STORAGE_SLOT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STORAGE-SLOT", null, 0)));
      Stella.SYM_STELLA_FUNCTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FUNCTION", null, 0)));
      Stella.SGT_STELLA_PARAMETRIC_TYPE_SPECIFIER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PARAMETRIC-TYPE-SPECIFIER", null, 1)));
      Stella.SYM_STELLA_SPECIFIER_BASE_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SPECIFIER-BASE-TYPE", null, 0)));
      Stella.SYM_STELLA_SPECIFIER_PARAMETER_TYPES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SPECIFIER-PARAMETER-TYPES", null, 0)));
      Stella.SYM_STELLA_SPECIFIER_DIMENSIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SPECIFIER-DIMENSIONS", null, 0)));
      Stella.SGT_STELLA_ANCHORED_TYPE_SPECIFIER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("ANCHORED-TYPE-SPECIFIER", null, 1)));
      Stella.SYM_STELLA_SPECIFIER_PARAMETER_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SPECIFIER-PARAMETER-NAME", null, 0)));
      Stella.SGT_STELLA_TABLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TABLE", null, 1)));
      Stella.SYM_STELLA_TUPLE_DOMAINS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TUPLE-DOMAINS", null, 0)));
      Stella.SGT_STELLA_GLOBAL_VARIABLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("GLOBAL-VARIABLE", null, 1)));
      Stella.SYM_STELLA_VARIABLE_HOME_MODULE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-HOME-MODULE", null, 0)));
      Stella.SYM_STELLA_VARIABLE_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-NAME", null, 0)));
      Stella.SYM_STELLA_VARIABLE_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-TYPE", null, 0)));
      Stella.SYM_STELLA_VARIABLE_SPECIALp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-SPECIAL?", null, 0)));
      Stella.SYM_STELLA_VARIABLE_CONSTANTp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-CONSTANT?", null, 0)));
      Stella.SYM_STELLA_VARIABLE_PUBLICp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-PUBLIC?", null, 0)));
      Stella.SYM_STELLA_VARIABLE_AUXILIARYp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-AUXILIARY?", null, 0)));
      Stella.SYM_STELLA_VARIABLE_GET_VALUE_CODE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-GET-VALUE-CODE", null, 0)));
      Stella.SYM_STELLA_VARIABLE_SET_VALUE_CODE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-SET-VALUE-CODE", null, 0)));
      Stella.SYM_STELLA_VARIABLE_VALUE_STACK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-VALUE-STACK", null, 0)));
      Stella.SYM_STELLA_VARIABLE_DOCUMENTATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-DOCUMENTATION", null, 0)));
      Stella.SYM_STELLA_VARIABLE_STRINGIFIED_SOURCE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-STRINGIFIED-SOURCE", null, 0)));
      Stella.SGT_STELLA_QUOTED_EXPRESSION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("QUOTED-EXPRESSION", null, 1)));
      Stella.SYM_STELLA_QUOTATION_TABLE_OFFSET = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("QUOTATION-TABLE-OFFSET", null, 0)));
      Stella.SYM_STELLA_SURROGATE_VALUE_INVERSE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SURROGATE-VALUE-INVERSE", null, 0)));
      Stella.SGT_STELLA_MODULE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE", null, 1)));
      Stella.SGT_STELLA_WORLD = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("WORLD", null, 1)));
    }
  }

  static void helpStartupHierarchy5() {
    {
      Stella.SYM_STELLA_WORLD_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WORLD-NAME", null, 0)));
      Stella.SYM_STELLA_CHILD_CONTEXTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CHILD-CONTEXTS", null, 0)));
      Stella.SYM_STELLA_BASE_MODULE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BASE-MODULE", null, 0)));
      Stella.SYM_STELLA_ALL_SUPER_CONTEXTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ALL-SUPER-CONTEXTS", null, 0)));
      Stella.SYM_STELLA_CONTEXT_NUMBER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTEXT-NUMBER", null, 0)));
      Stella.SYM_STELLA_MODULE_LISP_PACKAGE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE-LISP-PACKAGE", null, 0)));
      Stella.SYM_STELLA_MODULE_CPP_PACKAGE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE-CPP-PACKAGE", null, 0)));
      Stella.SYM_STELLA_SHADOWED_SURROGATES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SHADOWED-SURROGATES", null, 0)));
      Stella.SYM_STELLA_JAVA_PACKAGE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA-PACKAGE", null, 0)));
      Stella.SYM_STELLA_CLEARABLEp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLEARABLE?", null, 0)));
      Stella.SYM_STELLA_PROTECT_SURROGATESp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PROTECT-SURROGATES?", null, 0)));
      Stella.SYM_STELLA_PARENT_MODULES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PARENT-MODULES", null, 0)));
      Stella.SYM_STELLA_NICKNAMES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NICKNAMES", null, 0)));
      Stella.SYM_STELLA_USES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("USES", null, 0)));
      Stella.SYM_STELLA_USED_BY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("USED-BY", null, 0)));
      Stella.SYM_STELLA_REQUIRES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("REQUIRES", null, 0)));
      Stella.SYM_STELLA_CASE_SENSITIVEp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CASE-SENSITIVE?", null, 0)));
      Stella.SYM_STELLA_MODULE_FULL_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE-FULL-NAME", null, 0)));
      Stella.SYM_STELLA_MODULE_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE-NAME", null, 0)));
      Stella.SYM_STELLA_MODULE_STRINGIFIED_SOURCE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE-STRINGIFIED-SOURCE", null, 0)));
      Stella.SYM_STELLA_STRINGIFIED_OPTIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STRINGIFIED-OPTIONS", null, 0)));
      Stella.SYM_STELLA_CARDINAL_MODULE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CARDINAL-MODULE", null, 0)));
      Stella.SYM_STELLA_SYMBOL_OFFSET_TABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SYMBOL-OFFSET-TABLE", null, 0)));
      Stella.SYM_STELLA_SURROGATE_OFFSET_TABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SURROGATE-OFFSET-TABLE", null, 0)));
      Stella.SYM_STELLA_STRICT_INFERENCE_CACHE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STRICT-INFERENCE-CACHE", null, 0)));
      Stella.SYM_STELLA_DEFAULT_INFERENCE_CACHE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFAULT-INFERENCE-CACHE", null, 0)));
      Stella.SYM_STELLA_PROTOTYPE_INFERENCE_CACHE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PROTOTYPE-INFERENCE-CACHE", null, 0)));
      Stella.SYM_STELLA_PARENT_CONTEXT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PARENT-CONTEXT", null, 0)));
      Stella.SGT_STELLA_CS_VALUE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CS-VALUE", null, 1)));
      Stella.SGT_STELLA_INTERVAL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INTERVAL", null, 1)));
      Stella.SGT_STELLA_TAXONOMY_NODE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TAXONOMY-NODE", null, 1)));
      Stella.SYM_STELLA_NATIVE_OBJECT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NATIVE-OBJECT", null, 0)));
      Stella.SYM_STELLA_LABEL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LABEL", null, 0)));
      Stella.SYM_STELLA_INTERVALS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INTERVALS", null, 0)));
      Stella.SYM_STELLA_INITIAL_INTERVAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INITIAL-INTERVAL", null, 0)));
      Stella.SYM_STELLA_FIRST_INTERVAL_LOWER_BOUND = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FIRST-INTERVAL-LOWER-BOUND", null, 0)));
      Stella.SYM_STELLA_FIRST_INTERVAL_UPPER_BOUND = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FIRST-INTERVAL-UPPER-BOUND", null, 0)));
      Stella.SYM_STELLA_PARENTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PARENTS", null, 0)));
      Stella.SYM_STELLA_CHILDREN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CHILDREN", null, 0)));
      Stella.SYM_STELLA_TOTAL_ANCESTORS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TOTAL-ANCESTORS", null, 0)));
      Stella.SYM_STELLA_TREE_CHILDREN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TREE-CHILDREN", null, 0)));
      Stella.SYM_STELLA_MARKER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MARKER", null, 0)));
      Stella.SGT_STELLA_TAXONOMY_GRAPH = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TAXONOMY-GRAPH", null, 1)));
      Stella.SYM_STELLA_RENUMBER_IF_OUT_OF_NUMBERSp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RENUMBER-IF-OUT-OF-NUMBERS?", null, 0)));
      Stella.SYM_STELLA_RENUMBER_RATIO = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RENUMBER-RATIO", null, 0)));
      Stella.SYM_STELLA_INCREMENTAL_MODEp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INCREMENTAL-MODE?", null, 0)));
      Stella.SYM_STELLA_LARGEST_POSTORDER_NUMBER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LARGEST-POSTORDER-NUMBER", null, 0)));
      Stella.SYM_STELLA_NUMBER_OF_NODES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NUMBER-OF-NODES", null, 0)));
      Stella.SYM_STELLA_NUMBER_OF_FOREIGN_INTERVAL_NODES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NUMBER-OF-FOREIGN-INTERVAL-NODES", null, 0)));
      Stella.SYM_STELLA_ROOTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ROOTS", null, 0)));
      Stella.SYM_STELLA_BROKEN_LINKS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BROKEN-LINKS", null, 0)));
      Stella.SYM_STELLA_ADDED_LINKS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ADDED-LINKS", null, 0)));
      Stella.SYM_STELLA_REMOVED_LINKS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("REMOVED-LINKS", null, 0)));
      Stella.SYM_STELLA_FILE_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FILE-NAME", null, 0)));
      Stella.SGT_STELLA_INTEGER_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INTEGER-WRAPPER", null, 1)));
      Stella.SYM_STELLA_WRAPPER_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WRAPPER-VALUE", null, 0)));
      Stella.SYM_STELLA_NULL_INTEGER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL-INTEGER", null, 0)));
      Stella.SGT_STELLA_LONG_INTEGER_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("LONG-INTEGER-WRAPPER", null, 1)));
      Stella.SYM_STELLA_NULL_LONG_INTEGER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL-LONG-INTEGER", null, 0)));
      Stella.SGT_STELLA_FLOAT_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FLOAT-WRAPPER", null, 1)));
    }
  }

  static void helpStartupHierarchy6() {
    {
      Stella.SYM_STELLA_NULL_FLOAT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL-FLOAT", null, 0)));
      Stella.SGT_STELLA_STRING_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("STRING-WRAPPER", null, 1)));
      Stella.SYM_STELLA_NULL_STRING = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL-STRING", null, 0)));
      Stella.SGT_STELLA_MUTABLE_STRING_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("MUTABLE-STRING-WRAPPER", null, 1)));
      Stella.SYM_STELLA_NULL_MUTABLE_STRING = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL-MUTABLE-STRING", null, 0)));
      Stella.SGT_STELLA_CHARACTER_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CHARACTER-WRAPPER", null, 1)));
      Stella.SYM_STELLA_NULL_CHARACTER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL-CHARACTER", null, 0)));
      Stella.SGT_STELLA_BOOLEAN_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("BOOLEAN-WRAPPER", null, 1)));
      Stella.SYM_STELLA_TRUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TRUE", null, 0)));
      Stella.SYM_STELLA_FALSE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FALSE", null, 0)));
      Stella.SGT_STELLA_FUNCTION_CODE_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FUNCTION-CODE-WRAPPER", null, 1)));
      Stella.SGT_STELLA_METHOD_CODE_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-CODE-WRAPPER", null, 1)));
      Stella.SGT_STELLA_VERBATIM_STRING_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("VERBATIM-STRING-WRAPPER", null, 1)));
      Stella.SYM_STELLA_THREE_VALUED_BOOLEAN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("THREE-VALUED-BOOLEAN", null, 0)));
      Stella.SGT_STELLA_SYSTEM_DEFINITION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SYSTEM-DEFINITION", null, 1)));
      Stella.SYM_STELLA_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NAME", null, 0)));
      Stella.SYM_STELLA_DIRECTORY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DIRECTORY", null, 0)));
      Stella.SYM_STELLA_FILES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FILES", null, 0)));
      Stella.SYM_STELLA_LISP_ONLY_FILES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LISP-ONLY-FILES", null, 0)));
      Stella.SYM_STELLA_CPP_ONLY_FILES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP-ONLY-FILES", null, 0)));
      Stella.SYM_STELLA_JAVA_ONLY_FILES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA-ONLY-FILES", null, 0)));
      Stella.SYM_STELLA_DATA_FILES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DATA-FILES", null, 0)));
      Stella.SYM_STELLA_PREPROCESSED_FILES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PREPROCESSED-FILES", null, 0)));
      Stella.SYM_STELLA_REQUIRED_SYSTEMS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("REQUIRED-SYSTEMS", null, 0)));
      Stella.SYM_STELLA_LOADEDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LOADED?", null, 0)));
      Stella.SYM_STELLA_UP_TO_DATEp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UP-TO-DATE?", null, 0)));
      Stella.SYM_STELLA_SOURCE_ROOT_DIRECTORY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SOURCE-ROOT-DIRECTORY", null, 0)));
      Stella.SYM_STELLA_NATIVE_ROOT_DIRECTORY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NATIVE-ROOT-DIRECTORY", null, 0)));
      Stella.SYM_STELLA_BINARY_ROOT_DIRECTORY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BINARY-ROOT-DIRECTORY", null, 0)));
      Stella.SYM_STELLA_BANNER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BANNER", null, 0)));
      Stella.SYM_STELLA_COPYRIGHT_HEADER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COPYRIGHT-HEADER", null, 0)));
      Stella.SYM_STELLA_PRODUCTION_SETTINGS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PRODUCTION-SETTINGS", null, 0)));
      Stella.SYM_STELLA_DEVELOPMENT_SETTINGS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEVELOPMENT-SETTINGS", null, 0)));
      Stella.SYM_STELLA_FINALIZATION_FUNCTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FINALIZATION-FUNCTION", null, 0)));
      Stella.SYM_STELLA_STATE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STATE", null, 0)));
      Stella.SGT_STELLA_OUTPUT_STREAM = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("OUTPUT-STREAM", null, 1)));
      Stella.KWD_LINE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LINE", null, 2)));
      Stella.SGT_STELLA_INPUT_STREAM = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INPUT-STREAM", null, 1)));
      Stella.SYM_STELLA_ECHO_STREAM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ECHO-STREAM", null, 0)));
      Stella.SYM_STELLA_TOKENIZER_STATE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TOKENIZER-STATE", null, 0)));
      Stella.SYM_STELLA_BUFFERING_SCHEME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BUFFERING-SCHEME", null, 0)));
      Stella.KWD_CREATE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CREATE", null, 2)));
      Stella.KWD_SUPERSEDE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SUPERSEDE", null, 2)));
      Stella.SGT_STELLA_OUTPUT_FILE_STREAM = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("OUTPUT-FILE-STREAM", null, 1)));
      Stella.SYM_STELLA_FILENAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FILENAME", null, 0)));
      Stella.SYM_STELLA_IF_EXISTS_ACTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IF-EXISTS-ACTION", null, 0)));
      Stella.SYM_STELLA_IF_NOT_EXISTS_ACTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IF-NOT-EXISTS-ACTION", null, 0)));
      Stella.SYM_STELLA_FILE_OUTPUT_STREAM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FILE-OUTPUT-STREAM", null, 0)));
      Stella.KWD_BLOCK = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("BLOCK", null, 2)));
      Stella.KWD_ERROR = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ERROR", null, 2)));
      Stella.SGT_STELLA_INPUT_FILE_STREAM = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INPUT-FILE-STREAM", null, 1)));
      Stella.SYM_STELLA_FILE_INPUT_STREAM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FILE-INPUT-STREAM", null, 0)));
      Stella.SGT_STELLA_OUTPUT_STRING_STREAM = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("OUTPUT-STRING-STREAM", null, 1)));
      Stella.SYM_STELLA_STRING_OUTPUT_STREAM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STRING-OUTPUT-STREAM", null, 0)));
      Stella.SGT_STELLA_INPUT_STRING_STREAM = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INPUT-STRING-STREAM", null, 1)));
      Stella.SYM_STELLA_STRING_INPUT_STREAM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STRING-INPUT-STREAM", null, 0)));
      Stella.SYM_STELLA_STARTUP_HIERARCHY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-HIERARCHY", null, 0)));
      Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-STARTUP-CLASSNAME", null, 0)));
    }
  }

  static void helpStartupHierarchy7() {
    {
      Stella.defineClassFromStringifiedSource("OBJECT", "(DEFCLASS OBJECT () :DOCUMENTATION \"A reflective object that can participate in dynamically-typed\ncontexts.  Either a STANDARD-OBJECT or a WRAPPER or a GENERIC-OBJECT.\nAlso, either an OBJECT-WITH-INHERITED-TYPE or an OBJECT-WITH-OWN-TYPE.\" :PUBLIC-METHODS ((PRIMARY-TYPE ((SELF OBJECT)) :TYPE TYPE :DOCUMENTATION \"Returns the primary type of `self'.\nGets defined automatically for every non-abstract subclass of OBJECT.\" (RETURN NULL)) (HOME-MODULE ((SELF OBJECT)) :TYPE MODULE :DOCUMENTATION \"Return the home module of `self'.\" (RETURN NULL)) (DELETED? ((SELF OBJECT)) :TYPE BOOLEAN :DOCUMENTATION \"Default `deleted?' method which always returns FALSE.  Objects\nthat inherit DYNAMIC-SLOTS-MIXIN also inherit the dynamically-allocated slot\n`deleted-object?' which is read/writable with specializations of this method.\" (RETURN FALSE))) :PRINT-FORM (PRINT-NATIVE-STREAM STREAM \"|i|\" (PRIMARY-TYPE SELF)) :METHODS ((INCREMENT-REFERENCE-COUNT ((SELF OBJECT)) NULL) (DECREMENT-REFERENCE-COUNT ((SELF OBJECT)) NULL)) :ABSTRACT? TRUE)");
      Stella.defineClassFromStringifiedSource("SECOND-CLASS-OBJECT", "(DEFCLASS SECOND-CLASS-OBJECT () :DOCUMENTATION \"A native reference-type object pretending to be second class,\ni.e., it can't/won't participate in dynamically-typed contexts such as (real)\nmethod dispatch.  Since it is a reference-type object, it is always passed via\na pointer reference similar to a real object.\" :ABSTRACT? TRUE)");
      Stella.defineClassFromStringifiedSource("NON-OBJECT", "(DEFCLASS NON-OBJECT () :DOCUMENTATION \"A data structure that cannot be a dispatch argument to\na (real) method, because its type is not accessible at run-time.\" :ABSTRACT? TRUE)");
      Stella.defineClassFromStringifiedSource("STANDARD-OBJECT", "(DEFCLASS STANDARD-OBJECT (OBJECT) :DOCUMENTATION \"Object that used to find its type stored in a :class slot.\nBy reimplementing `primary-type' as a method, the justification for this\nclass went away, but we'll keep it for now to keep things working.\" :ABSTRACT? TRUE :SYNONYMS (TYPE-SPEC))");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("TRANSIENT-MIXIN", "(DEFCLASS TRANSIENT-MIXIN () :DOCUMENTATION \"Transient objects are periodically swept back into a pool\nof free objects.  A transient object should never be pointed at by a\npermanent object.\" :MIXIN? TRUE :PUBLIC-SLOTS ((TRANSIENT? :TYPE BOOLEAN :INITIALLY TRUE :HARDWIRED? TRUE)))");

        Stella.$HARDWIRED_TRANSIENTp_ON_TRANSIENT_MIXIN$ = true;
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("REFERENCE-COUNT-OBJECT", "(DEFCLASS REFERENCE-COUNT-OBJECT (OBJECT) :DOCUMENTATION \"A reference count objects contains a slot `reference-count' \nthat is incremented whenever the object is assigned to a slot, and decremented\nwhenever it is deassigned from a slot.\" :ABSTRACT? TRUE :PUBLIC-SLOTS ((REFERENCE-COUNT :TYPE INTEGER :INITIALLY 0)) :METHODS ((INCREMENT-REFERENCE-COUNT ((SELF REFERENCE-COUNT-OBJECT)) (SETF (REFERENCE-COUNT SELF) (+ (REFERENCE-COUNT SELF) 1))) (DECREMENT-REFERENCE-COUNT ((SELF REFERENCE-COUNT-OBJECT)) (SETF (REFERENCE-COUNT SELF) (- (REFERENCE-COUNT SELF) 1)))))");

        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.ReferenceCountObject", "accessReferenceCountObjectSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.ReferenceCountObject"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      Stella.defineClassFromStringifiedSource("DYNAMIC-SLOTS-MIXIN", "(DEFCLASS DYNAMIC-SLOTS-MIXIN () :DOCUMENTATION \"Enables objects to store slot values in non-preallocated storage.\" :MIXIN? TRUE :PUBLIC-SLOTS ((DYNAMIC-SLOTS :TYPE KEY-VALUE-LIST :ALLOCATION :EMBEDDED :PUBLIC? TRUE) (BAD? :TYPE BOOLEAN-WRAPPER :ALLOCATION :DYNAMIC :DEFAULT FALSE :DOCUMENTATION \"Indicates that an object is in need of repair.\") (DELETED-OBJECT? :TYPE BOOLEAN-WRAPPER :ALLOCATION :DYNAMIC :READER DELETED? :WRITER DELETED?-SETTER :DOCUMENTATION \"Indicates that an object has been \ndestroyed/deleted.  A deleted object is visible only if something broke\nbefore it was fully excised from the network).\")) :PUBLIC-METHODS ((DELETED? ((SELF DYNAMIC-SLOTS-MIXIN)) :TYPE BOOLEAN (LET ((DELETED? (SLOT-VALUE SELF DELETED-OBJECT?))) (IF (DEFINED? DELETED?) (RETURN DELETED?) (RETURN FALSE)))) (DELETED?-SETTER ((SELF DYNAMIC-SLOTS-MIXIN) (VALUE BOOLEAN)) :TYPE BOOLEAN (SETF (SLOT-VALUE SELF DELETED-OBJECT?) VALUE) (RETURN VALUE))))");
      Stella.defineClassFromStringifiedSource("CONTEXT-SENSITIVE-OBJECT", "(DEFCLASS CONTEXT-SENSITIVE-OBJECT (STANDARD-OBJECT CONTEXT-SENSITIVE-MIXIN) :DOCUMENTATION \"Context sensitive objects inherit a slot `home-context'\nthat enables context-dependent access machinery to determine the\nvisibility of objects from modules.\" :ABSTRACT? TRUE)");
      Stella.defineClassFromStringifiedSource("CONTEXT-SENSITIVE-MIXIN", "(DEFCLASS CONTEXT-SENSITIVE-MIXIN () :DOCUMENTATION \"Mixin class that enables the class to support \ncontext sensitive slots.  The mixin allocates and initializes the\nslot `home-context'.\" :MIXIN? TRUE :PUBLIC-SLOTS ((HOME-CONTEXT :TYPE CONTEXT :INITIALLY *CONTEXT*)) :PUBLIC-METHODS ((HOME-MODULE ((SELF CONTEXT-SENSITIVE-MIXIN)) :TYPE MODULE (LET ((CONTEXT (HOME-CONTEXT SELF))) (IF (DEFINED? CONTEXT) (RETURN (BASE-MODULE CONTEXT)) (RETURN NULL))))))");
      Stella.defineClassFromStringifiedSource("ACTIVE-OBJECT", "(DEFCLASS ACTIVE-OBJECT (CONTEXT-SENSITIVE-OBJECT DYNAMIC-SLOTS-MIXIN) :DOCUMENTATION \"Active objects call class and slot triggers in response\nto instance creation/destruction and slot updates.  They include internal\nstorage slots needed for class extensions, dynamic storage, and home context.\" :ABSTRACT? TRUE)");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("ABSTRACT-ITERATOR", "(DEFCLASS ABSTRACT-ITERATOR (STANDARD-OBJECT) :ABSTRACT? TRUE :DOCUMENTATION \"Instances of ABSTRACT-ITERATOR support iteration over collections.\" :PARAMETERS ((ANY-VALUE :TYPE UNKNOWN)) :PUBLIC-SLOTS ((VALUE :TYPE (LIKE (ANY-VALUE SELF)) :DOCUMENTATION \"The current value of this iterator\") (FIRST-ITERATION? :TYPE BOOLEAN :INITIALLY TRUE)) :PUBLIC-METHODS ((NEXT? ((SELF ABSTRACT-ITERATOR)) :TYPE BOOLEAN (RETURN NULL)) (LENGTH ((SELF ABSTRACT-ITERATOR)) :TYPE INTEGER)))");

        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.AbstractIterator", "accessAbstractIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AbstractIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      Stella.defineClassFromStringifiedSource("ITERATOR", "(DEFCLASS ITERATOR (ABSTRACT-ITERATOR) :ABSTRACT? TRUE :DOCUMENTATION \"Instances of ITERATOR support iteration over \ncollections of OBJECTs.\" :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :SYNONYMS (OBJECT-ITERATOR))");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CONS-ITERATOR", "(DEFCLASS CONS-ITERATOR (ITERATOR) :DOCUMENTATION \"Iterator class for the class CONS.\" :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :PUBLIC-SLOTS ((CONS-ITERATOR-CURSOR :TYPE CONS)) :TERMINATOR TERMINATE-CONS-ITERATOR?)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.ConsIterator", "newConsIterator", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.ConsIterator", "accessConsIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.ConsIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("LIST-ITERATOR", "(DEFCLASS LIST-ITERATOR (ITERATOR) :DOCUMENTATION \"Iterator class for the collection LIST.\" :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :PUBLIC-SLOTS ((LIST-ITERATOR-CURSOR :TYPE CONS) (LIST-ITERATOR-COLLECTION :TYPE LIST)) :TERMINATOR TERMINATE-LIST-ITERATOR?)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.ListIterator", "newListIterator", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.ListIterator", "accessListIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.ListIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("DESTRUCTIVE-LIST-ITERATOR", "(DEFCLASS DESTRUCTIVE-LIST-ITERATOR (ITERATOR) :DOCUMENTATION \"An iterator that contains a cons list.  Iterates over\nthe stored list, and destroys it when the iterator is free'd.\" :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :PUBLIC-SLOTS ((THE-CONS-LIST :TYPE CONS :INITIALLY NIL) (LIST-ITERATOR-CURSOR :TYPE CONS)) :TERMINATOR TERMINATE-DESTRUCTIVE-LIST-ITERATOR?)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.DestructiveListIterator", "newDestructiveListIterator", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.DestructiveListIterator", "accessDestructiveListIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.DestructiveListIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("ALL-PURPOSE-ITERATOR", "(DEFCLASS ALL-PURPOSE-ITERATOR (ITERATOR) :DOCUMENTATION \"The all-purpose iterator works by storing a `next?'\nfunction within itself during iterator allocation.  The method\n`ALL-PURPOSE-ITERAOR.next?' funcalls the stored `next?' function.\nAn assortment of storage slots are provided for constructing different\nkinds of iterators.\" :PUBLIC-SLOTS ((KEY :TYPE OBJECT) (ITERATOR-NEXT-CODE :TYPE FUNCTION-CODE) (ITERATOR-FILTER-CODE :TYPE FUNCTION-CODE) (ITERATOR-EMPTY-CODE :TYPE FUNCTION-CODE) (ITERATOR-NESTED-ITERATOR :TYPE ITERATOR) (ITERATOR-CONS-LIST :TYPE CONS) (ITERATOR-OBJECT :TYPE OBJECT) (ITERATOR-SECOND-OBJECT :TYPE OBJECT) (ITERATOR-INTEGER :TYPE INTEGER) (ITERATOR-SECOND-INTEGER :TYPE INTEGER)) :TERMINATOR TERMINATE-ALL-PURPOSE-ITERATOR?)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.AllPurposeIterator", "newAllPurposeIterator", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.AllPurposeIterator", "accessAllPurposeIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("TYPES-TO-CLASSES-ITERATOR", "(DEFCLASS TYPES-TO-CLASSES-ITERATOR (ITERATOR) :DOCUMENTATION \"Iterator that returns a class for each type\nin a cons list of types.\" :PARAMETERS ((ANY-VALUE :TYPE CLASS)) :PUBLIC-SLOTS ((ITERATOR-CURSOR :TYPE (CONS OF TYPE) :REQUIRED? TRUE)) :METHODS ((NEXT? ((SELF TYPES-TO-CLASSES-ITERATOR)) :TYPE BOOLEAN (IF (FIRST-ITERATION? SELF) (SETF (FIRST-ITERATION? SELF) FALSE) (SETF (ITERATOR-CURSOR SELF) (REST (ITERATOR-CURSOR SELF)))) (COND ((NON-EMPTY? (ITERATOR-CURSOR SELF)) (SETF (SLOT-VALUE SELF VALUE) (TYPE-CLASS (FIRST (ITERATOR-CURSOR SELF)))) (RETURN TRUE)) (OTHERWISE (RETURN FALSE))))))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.TypesToClassesIterator", "newTypesToClassesIterator", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.TypesToClassesIterator", "accessTypesToClassesIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TypesToClassesIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      Stella.defineClassFromStringifiedSource("ABSTRACT-DICTIONARY-ITERATOR", "(DEFCLASS ABSTRACT-DICTIONARY-ITERATOR (ABSTRACT-ITERATOR) :ABSTRACT? TRUE :DOCUMENTATION \"Instances of ABSTRACT-DICTIONARY-ITERATOR support iteration\nover dictionaries.\" :PARAMETERS ((ANY-KEY :TYPE UNKNOWN) (ANY-VALUE :TYPE UNKNOWN)) :PUBLIC-SLOTS ((KEY :TYPE (LIKE (ANY-KEY SELF)))) :PUBLIC-METHODS ((VALUE-SETTER ((SELF ABSTRACT-DICTIONARY-ITERATOR) (VALUE (LIKE (ANY-VALUE SELF)))) :TYPE (LIKE (ANY-VALUE SELF)) :DOCUMENTATION \"Abstract method needed to allow application of this\nmethod on abstract iterator classes that do not implement it.  By having\nthis here all `next?' methods of dictionary iterators MUST use the `slot-value'\nparadigm to set the iterator value.\") (KEY-SETTER ((SELF ABSTRACT-DICTIONARY-ITERATOR) (KEY (LIKE (ANY-KEY SELF)))) :TYPE (LIKE (ANY-KEY SELF)))))");
      Stella.defineClassFromStringifiedSource("DICTIONARY-ITERATOR", "(DEFCLASS DICTIONARY-ITERATOR (ABSTRACT-DICTIONARY-ITERATOR) :ABSTRACT? TRUE :DOCUMENTATION \"Instances of DICTIONARY-ITERATOR support iteration\nover dictionaries with keys and values of type OBJECT.\" :PARAMETERS ((ANY-KEY :TYPE OBJECT) (ANY-VALUE :TYPE OBJECT)) :SYNONYMS (OBJECT-DICTIONARY-ITERATOR) :PUBLIC-METHODS ((VALUE-SETTER ((SELF DICTIONARY-ITERATOR) (VALUE (LIKE (ANY-VALUE SELF)))) :TYPE (LIKE (ANY-VALUE SELF)) (ERROR \"DICTIONARY-ITERATOR.value-setter not implemented on \" SELF)) (KEY-SETTER ((SELF DICTIONARY-ITERATOR) (KEY (LIKE (ANY-KEY SELF)))) :TYPE (LIKE (ANY-KEY SELF)) (ERROR \"DICTIONARY-ITERATOR.key-setter not implemented on \" SELF))))");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("PROPERTY-LIST-ITERATOR", "(DEFCLASS PROPERTY-LIST-ITERATOR (DICTIONARY-ITERATOR) :DOCUMENTATION \"Iterator class for the collection PROPERTY-LIST.\" :PUBLIC-SLOTS ((PLIST-ITERATOR-CURSOR :TYPE CONS) (PLIST-ITERATOR-COLLECTION :TYPE PROPERTY-LIST)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.PropertyListIterator", "newPropertyListIterator", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.PropertyListIterator", "accessPropertyListIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.PropertyListIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("KV-LIST-ITERATOR", "(DEFCLASS KV-LIST-ITERATOR (DICTIONARY-ITERATOR) :PUBLIC-SLOTS ((THE-KV-LIST :TYPE KEY-VALUE-LIST :PUBLIC? TRUE) (KV-LIST-ITERATOR-CURSOR :TYPE KV-CONS)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.KvListIterator", "newKvListIterator", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.KvListIterator", "accessKvListIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.KvListIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      Stella.defineClassFromStringifiedSource("INTERVAL-ITERATOR", "(DEFCLASS INTERVAL-ITERATOR (ABSTRACT-ITERATOR) :ABSTRACT? TRUE :DOCUMENTATION \"An iterator that specifies a (possibly infinite) range of\nvalues.  Supports `member?' test as well as iteration methods.\" :PUBLIC-SLOTS ((LOWER-BOUND :TYPE UNKNOWN :REQUIRED? TRUE) (UPPER-BOUND :TYPE UNKNOWN :REQUIRED? TRUE)))");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("INTEGER-INTERVAL-ITERATOR", "(DEFCLASS INTEGER-INTERVAL-ITERATOR (INTERVAL-ITERATOR) :PARAMETERS ((ANY-VALUE :TYPE INTEGER)) :PUBLIC-SLOTS ((INTERVAL-CURSOR :TYPE INTEGER) (LOWER-BOUND :TYPE INTEGER :REQUIRED? TRUE) (UPPER-BOUND :TYPE INTEGER :REQUIRED? TRUE)) :INITIALIZER INITIALIZE-INTEGER-INTERVAL-ITERATOR)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.IntegerIntervalIterator", "newIntegerIntervalIterator", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.IntegerIntervalIterator", "accessIntegerIntervalIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerIntervalIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("REVERSE-INTEGER-INTERVAL-ITERATOR", "(DEFCLASS REVERSE-INTEGER-INTERVAL-ITERATOR (INTERVAL-ITERATOR) :PARAMETERS ((ANY-VALUE :TYPE INTEGER)) :PUBLIC-SLOTS ((INTERVAL-CURSOR :TYPE INTEGER) (LOWER-BOUND :TYPE INTEGER :REQUIRED? TRUE) (UPPER-BOUND :TYPE INTEGER :REQUIRED? TRUE)) :INITIALIZER INITIALIZE-REVERSE-INTEGER-INTERVAL-ITERATOR)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.ReverseIntegerIntervalIterator", "newReverseIntegerIntervalIterator", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.ReverseIntegerIntervalIterator", "accessReverseIntegerIntervalIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.ReverseIntegerIntervalIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("STRING-ITERATOR", "(DEFCLASS STRING-ITERATOR (ABSTRACT-ITERATOR) :DOCUMENTATION \"Iterator that yields characters from a string.\" :PARAMETERS ((ANY-VALUE :TYPE CHARACTER)) :PUBLIC-SLOTS ((THE-STRING :TYPE STRING) (CURSOR :TYPE INTEGER) (END :TYPE INTEGER)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.StringIterator", "newStringIterator", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.StringIterator", "accessStringIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      Stella.defineClassFromStringifiedSource("ABSTRACT-COLLECTION", "(DEFCLASS ABSTRACT-COLLECTION (STANDARD-OBJECT) :PARAMETERS ((ANY-VALUE :TYPE UNKNOWN)) :PUBLIC-METHODS ((ALLOCATE-ITERATOR ((SELF ABSTRACT-COLLECTION)) :TYPE (ABSTRACT-ITERATOR OF (LIKE (ANY-VALUE SELF))) (RETURN NULL)) (LENGTH ((SELF ABSTRACT-COLLECTION)) :TYPE INTEGER (RETURN NULL)) (INSERT ((SELF ABSTRACT-COLLECTION) (VALUE (LIKE (ANY-VALUE SELF))))) (REMOVE ((SELF ABSTRACT-COLLECTION) (VALUE (LIKE (ANY-VALUE SELF)))) :TYPE ABSTRACT-COLLECTION)) :ABSTRACT? TRUE)");
      Stella.defineClassFromStringifiedSource("COLLECTION", "(DEFCLASS COLLECTION (ABSTRACT-COLLECTION) :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :PUBLIC-METHODS ((ALLOCATE-ITERATOR ((SELF COLLECTION)) :TYPE (ITERATOR OF (LIKE (ANY-VALUE SELF))) (RETURN NULL)) (LENGTH ((SELF COLLECTION)) :TYPE INTEGER (RETURN NULL)) (INSERT ((SELF COLLECTION) (VALUE (LIKE (ANY-VALUE SELF)))) (IGNORE VALUE) (RETURN)) (REMOVE ((SELF COLLECTION) (VALUE (LIKE (ANY-VALUE SELF)))) :TYPE COLLECTION (IGNORE VALUE) (RETURN NULL))) :ABSTRACT? TRUE :SYNONYMS (OBJECT-COLLECTION))");
      Stella.defineClassFromStringifiedSource("SET-MIXIN", "(DEFCLASS SET-MIXIN () :DOCUMENTATION \"Users of this mixin check for duplicates inside of \nthe method `insert'.\" :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :MIXIN? TRUE)");
      Stella.defineClassFromStringifiedSource("SEQUENCE-MIXIN", "(DEFCLASS SEQUENCE-MIXIN () :PARAMETERS ((ANY-VALUE :TYPE UNKNOWN)) :PUBLIC-METHODS ((FIRST ((SEQUENCE SEQUENCE-MIXIN)) :TYPE (LIKE (ANY-VALUE SELF))) (NTH ((SEQUENCE SEQUENCE-MIXIN) (POSITION INTEGER)) :TYPE (LIKE (ANY-VALUE SELF)))) :MIXIN? TRUE)");
      Stella.defineClassFromStringifiedSource("SEQUENCE", "(DEFCLASS SEQUENCE (COLLECTION SEQUENCE-MIXIN) :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :PUBLIC-METHODS ((ALLOCATE-ITERATOR ((SELF SEQUENCE)) :TYPE (ITERATOR OF (LIKE (ANY-VALUE SELF))) (RETURN NULL)) (LENGTH ((SEQUENCE SEQUENCE)) :TYPE INTEGER (RETURN NULL))) :ABSTRACT? TRUE :SYNONYMS (OBJECT-SEQUENCE))");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("LIST", "(DEFCLASS LIST (SEQUENCE) :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :PUBLIC-SLOTS ((THE-CONS-LIST :TYPE (CONS OF (LIKE (ANY-VALUE SELF))) :INITIALLY NIL :PUBLIC? TRUE)) :INITIAL-VALUE NIL-LIST :PRINT-FORM (PROGN (PRINT-STREAM STREAM \"|l|\") (PRINT-CONS (THE-CONS-LIST SELF) STREAM \"(\" \")\")))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.List", "newList", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.List", "accessListSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("SET", "(DEFCLASS SET (LIST SET-MIXIN) :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :INITIAL-VALUE NULL :PRINT-FORM (PROGN (PRINT-STREAM STREAM \"|s|\") (PRINT-CONS (THE-CONS-LIST SELF) STREAM \"(\" \")\")))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.Set", "newSet", new java.lang.Class [] {});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CLASS-EXTENSION", "(DEFCLASS CLASS-EXTENSION (LIST) :PARAMETERS ((ANY-VALUE :TYPE ACTIVE-OBJECT)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.ClassExtension", "newClassExtension", new java.lang.Class [] {});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CONS", "(DEFCLASS CONS (STANDARD-OBJECT) :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :METHODS ((ALLOCATE-ITERATOR ((SELF CONS)) :TYPE (ITERATOR OF (LIKE (ANY-VALUE SELF))))) :PUBLIC-SLOTS ((VALUE :TYPE (LIKE (ANY-VALUE SELF)) :PUBLIC? TRUE) (REST :TYPE (CONS OF (LIKE (ANY-VALUE SELF))) :PUBLIC? TRUE :INITIALLY NIL)) :INITIAL-VALUE NIL :PRINT-FORM (PRINT-CONS SELF STREAM \"(\" \")\"))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.Cons", "newCons", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.Cons", "accessConsSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      Stella.defineClassFromStringifiedSource("ABSTRACT-DICTIONARY", "(DEFCLASS ABSTRACT-DICTIONARY (ABSTRACT-COLLECTION) :PARAMETERS ((ANY-KEY :TYPE UNKNOWN) (ANY-VALUE :TYPE UNKNOWN)) :PUBLIC-METHODS ((LOOKUP ((SELF ABSTRACT-DICTIONARY) (KEY (LIKE (ANY-KEY SELF)))) :TYPE (LIKE (ANY-VALUE SELF))) (INSERT-AT ((SELF ABSTRACT-DICTIONARY) (KEY (LIKE (ANY-KEY SELF))) (VALUE (LIKE (ANY-VALUE SELF)))))) :METHODS ((ALLOCATE-ITERATOR ((SELF ABSTRACT-DICTIONARY)) :TYPE (ABSTRACT-DICTIONARY-ITERATOR OF (LIKE (ANY-KEY SELF)) (LIKE (ANY-VALUE SELF))) (RETURN NULL))) :ABSTRACT? TRUE)");
      Stella.defineClassFromStringifiedSource("DICTIONARY", "(DEFCLASS DICTIONARY (ABSTRACT-DICTIONARY) :PARAMETERS ((ANY-KEY :TYPE OBJECT) (ANY-VALUE :TYPE OBJECT)) :METHODS ((ALLOCATE-ITERATOR ((SELF DICTIONARY)) :TYPE (DICTIONARY-ITERATOR OF (LIKE (ANY-KEY SELF)) (LIKE (ANY-VALUE SELF))) (RETURN NULL)) (LOOKUP ((SELF DICTIONARY) (KEY (LIKE (ANY-KEY SELF)))) :TYPE (LIKE (ANY-VALUE SELF)) (IGNORE KEY) (RETURN NULL)) (INSERT-AT ((SELF DICTIONARY) (KEY (LIKE (ANY-KEY SELF))) (VALUE (LIKE (ANY-VALUE SELF)))) (IGNORE KEY VALUE) (RETURN))) :ABSTRACT? TRUE :SYNONYMS (OBJECT-TO-OBJECT-DICTIONARY))");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("PROPERTY-LIST", "(DEFCLASS PROPERTY-LIST (DICTIONARY) :PARAMETERS ((ANY-KEY :TYPE OBJECT) (ANY-VALUE :TYPE OBJECT)) :PUBLIC-SLOTS ((THE-PLIST :TYPE CONS :INITIALLY NIL)) :PRINT-FORM (PROGN (PRINT-STREAM STREAM \"|pl|\") (PRINT-CONS (THE-PLIST SELF) STREAM \"(\" \")\")))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.PropertyList", "newPropertyList", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.PropertyList", "accessPropertyListSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.PropertyList"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("KV-CONS", "(DEFCLASS KV-CONS (STANDARD-OBJECT) :PARAMETERS ((ANY-KEY :TYPE OBJECT) (ANY-VALUE :TYPE OBJECT)) :PUBLIC-SLOTS ((KEY :TYPE OBJECT) (VALUE :TYPE OBJECT) (REST :TYPE KV-CONS)) :PRINT-FORM (PRINT-NATIVE-STREAM STREAM \"<\" (KEY SELF) \",\" (VALUE SELF) \">\"))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.KvCons", "newKvCons", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.KvCons", "accessKvConsSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.KvCons"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("KEY-VALUE-LIST", "(DEFCLASS KEY-VALUE-LIST (DICTIONARY) :PARAMETERS ((ANY-KEY :TYPE OBJECT) (ANY-VALUE :TYPE OBJECT)) :PUBLIC-SLOTS ((THE-KV-LIST :TYPE KV-CONS)) :PRINT-FORM (PRINT-KEY-VALUE-LIST SELF STREAM))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.KeyValueList", "newKeyValueList", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.KeyValueList", "accessKeyValueListSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.KeyValueList"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("RECYCLE-LIST", "(DEFCLASS RECYCLE-LIST (SEQUENCE) :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :PUBLIC-SLOTS ((RECYCLE-LIST-OF :TYPE TYPE) (RECYCLED-ITEMS :TYPE (LIKE (ANY-VALUE SELF))) (LIST-OF-RECYCLED-ITEMS :TYPE (LIST OF (LIKE (ANY-VALUE SELF))) :INITIALLY (MAKE-NON-RECYCLED-LIST)) (ALL-ITEMS :TYPE (LIKE (ANY-VALUE SELF))) (UNUSED-ITEMS :TYPE (LIKE (ANY-VALUE SELF))) (CURRENT-LENGTH :TYPE INTEGER :INITIALLY 0) (ITEM-SIZE :TYPE INTEGER)) :PRINT-FORM (IF (DEFINED? (RECYCLE-LIST-OF SELF)) (PRINT-NATIVE-STREAM STREAM \"|i|[RECYCLE-LIST OF \" (CURRENT-LENGTH SELF) \" \" (RECYCLE-LIST-OF SELF) \"'s]\") (PRINT-NATIVE-STREAM STREAM \"|i|@RECYCLE-LIST\")))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.RecycleList", "newRecycleList", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.RecycleList", "accessRecycleListSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.RecycleList"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("ABSTRACT-HASH-TABLE", "(DEFCLASS ABSTRACT-HASH-TABLE (ABSTRACT-DICTIONARY) :PARAMETERS ((ANY-KEY :TYPE UNKNOWN) (ANY-VALUE :TYPE UNKNOWN)) :PUBLIC-SLOTS ((THE-HASH-TABLE :TYPE NATIVE-HASH-TABLE) (THE-STELLA-HASH-TABLE :TYPE STELLA-HASH-TABLE)) :INITIALIZER INITIALIZE-HASH-TABLE :ABSTRACT? TRUE)");

        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.AbstractHashTable", "accessAbstractHashTableSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AbstractHashTable"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("HASH-TABLE", "(DEFCLASS HASH-TABLE (ABSTRACT-HASH-TABLE) :PARAMETERS ((ANY-KEY :TYPE OBJECT) (ANY-VALUE :TYPE OBJECT)) :INITIALIZER INITIALIZE-HASH-TABLE :SYNONYMS (OBJECT-TO-OBJECT-HASH-TABLE))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.HashTable", "newHashTable", new java.lang.Class [] {});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("INTEGER-HASH-TABLE", "(DEFCLASS INTEGER-HASH-TABLE (ABSTRACT-HASH-TABLE) :PARAMETERS ((ANY-KEY :TYPE INTEGER) (ANY-VALUE :TYPE OBJECT)) :INITIALIZER INITIALIZE-HASH-TABLE)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.IntegerHashTable", "newIntegerHashTable", new java.lang.Class [] {});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("FLOAT-HASH-TABLE", "(DEFCLASS FLOAT-HASH-TABLE (ABSTRACT-HASH-TABLE) :PARAMETERS ((ANY-KEY :TYPE FLOAT) (ANY-VALUE :TYPE OBJECT)) :INITIALIZER INITIALIZE-HASH-TABLE)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.FloatHashTable", "newFloatHashTable", new java.lang.Class [] {});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("STRING-HASH-TABLE", "(DEFCLASS STRING-HASH-TABLE (ABSTRACT-HASH-TABLE) :PARAMETERS ((ANY-KEY :TYPE STRING) (ANY-VALUE :TYPE OBJECT)) :INITIALIZER INITIALIZE-HASH-TABLE)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.StringHashTable", "newStringHashTable", new java.lang.Class [] {});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("STRING-TO-INTEGER-HASH-TABLE", "(DEFCLASS STRING-TO-INTEGER-HASH-TABLE (ABSTRACT-HASH-TABLE) :PARAMETERS ((ANY-KEY :TYPE STRING) (ANY-VALUE :TYPE INTEGER)) :INITIALIZER INITIALIZE-HASH-TABLE)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.StringToIntegerHashTable", "newStringToIntegerHashTable", new java.lang.Class [] {});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("VECTOR", "(DEFCLASS VECTOR (SEQUENCE) :PUBLIC-SLOTS ((ARRAY-SIZE :TYPE INTEGER :REQUIRED? TRUE) (THE-ARRAY :TYPE (NATIVE-VECTOR OF (LIKE (ANY-VALUE SELF))))) :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :PRINT-FORM (PRINT-VECTOR SELF STREAM) :INITIALIZER INITIALIZE-VECTOR)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.Vector", "newVector", new java.lang.Class [] {java.lang.Integer.TYPE});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.Vector", "accessVectorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("EXTENSIBLE-VECTOR", "(DEFCLASS EXTENSIBLE-VECTOR (VECTOR) :INITIALIZER INITIALIZE-VECTOR)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.ExtensibleVector", "newExtensibleVector", new java.lang.Class [] {java.lang.Integer.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("EXTENSIBLE-SYMBOL-ARRAY", "(DEFCLASS EXTENSIBLE-SYMBOL-ARRAY (EXTENSIBLE-VECTOR) :DOCUMENTATION \"Self-extending array with methods for storing and\naccessing symbols within it.\" :PUBLIC-SLOTS ((TOP-SYMBOL-OFFSET :TYPE INTEGER :INITIALLY -1) (POTENTIAL-FREE-SYMBOL-OFFSET :TYPE INTEGER :INITIALLY 0)) :INITIALIZER INITIALIZE-VECTOR)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.ExtensibleSymbolArray", "newExtensibleSymbolArray", new java.lang.Class [] {java.lang.Integer.TYPE});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.ExtensibleSymbolArray", "accessExtensibleSymbolArraySlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.ExtensibleSymbolArray"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("VECTOR-SEQUENCE", "(DEFCLASS VECTOR-SEQUENCE (VECTOR) :DOCUMENTATION \"Extensible sequence implemented by a vector.  Whenever we run\nout of room, we grow the sequence by a factor of two.  Note that this keeps the\naverage insertion cost per element constant.  This is generally preferable over\nlinked lists unless we need within-list insertions or removals, since it uses\nless space and has better cache locality.\" :PUBLIC-SLOTS ((SEQUENCE-LENGTH :TYPE INTEGER :INITIALLY 0)) :INITIALIZER INITIALIZE-VECTOR)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.VectorSequence", "newVectorSequence", new java.lang.Class [] {java.lang.Integer.TYPE});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.VectorSequence", "accessVectorSequenceSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.VectorSequence"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CUSTOM-VECTOR-SEQUENCE", "(DEFCLASS CUSTOM-VECTOR-SEQUENCE (VECTOR-SEQUENCE) :DOCUMENTATION \"VECTOR-SEQUENCE (which see) with a customizable resize factor.\nThe resize factor needs to be > 1.\" :PUBLIC-SLOTS ((RESIZE-FACTOR :TYPE FLOAT :INITIALLY 2.0)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.CustomVectorSequence", "newCustomVectorSequence", new java.lang.Class [] {java.lang.Integer.TYPE});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.CustomVectorSequence", "accessCustomVectorSequenceSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.CustomVectorSequence"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("BOOLEAN-VECTOR", "(DEFCLASS BOOLEAN-VECTOR (VECTOR) :PARAMETERS ((ANY-VALUE :TYPE BOOLEAN-WRAPPER)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.BooleanVector", "newBooleanVector", new java.lang.Class [] {java.lang.Integer.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("INTEGER-VECTOR", "(DEFCLASS INTEGER-VECTOR (VECTOR) :PARAMETERS ((ANY-VALUE :TYPE INTEGER-WRAPPER)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.IntegerVector", "newIntegerVector", new java.lang.Class [] {java.lang.Integer.TYPE});
      }
      Stella.defineClassFromStringifiedSource("ARRAY", "(DEFCLASS ARRAY (SECOND-CLASS-OBJECT) :PARAMETERS ((ANY-VALUE :TYPE UNKNOWN)) :SLOTS ((INITIAL-ELEMENT :TYPE (LIKE (ANY-VALUE SELF)) :REQUIRED? TRUE :ABSTRACT? TRUE :DOCUMENTATION \"Initializer pseudo-slot special-cased by the STELLA translator.\") (SIZE :TYPE (LIST OF INTEGER-WRAPPER) :REQUIRED? TRUE :ABSTRACT? TRUE :DOCUMENTATION \"Size pseudo-slot special-cased by the STELLA translator.\")) :METHODS ((AREF ((SELF ARRAY) (DIM0 INTEGER) |&REST| (DIMS INTEGER)) :TYPE (LIKE (ANY-VALUE SELF)) :PUBLIC? TRUE :NATIVE? TRUE) (AREF-SETTER ((SELF ARRAY) (VALUE (LIKE (ANY-VALUE SELF))) (DIM0 INTEGER) |&REST| (DIMS INTEGER)) :TYPE (LIKE (ANY-VALUE SELF)) :PUBLIC? TRUE :NATIVE? TRUE)) :CL-NATIVE-TYPE \"ARRAY\" :CPP-NATIVE-TYPE \"void*\" :JAVA-NATIVE-TYPE \"Object\")");
      Stella.defineClassFromStringifiedSource("NATIVE-HASH-TABLE", "(DEFCLASS NATIVE-HASH-TABLE (SECOND-CLASS-OBJECT) :CPP-NATIVE-TYPE \"cpp_hash_table*\" :CL-NATIVE-TYPE \"HASH-TABLE\" :JAVA-NATIVE-TYPE \"java.util.HashMap\")");
      Stella.defineClassFromStringifiedSource("NATIVE-VECTOR", "(DEFCLASS NATIVE-VECTOR (SECOND-CLASS-OBJECT) :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :CPP-NATIVE-TYPE \"Object**\" :CL-NATIVE-TYPE \"VECTOR\" :JAVA-NATIVE-TYPE \"#$(STELLAROOT).Stella_Object[]\" :INITIAL-VALUE (VERBATIM :COMMON-LISP \"STELLA::NULL-NATIVE-VECTOR\" :JAVA \"null\" :CPP \"NULL\"))");
      Stella.defineClassFromStringifiedSource("ACTIVE-COLLECTION-MIXIN", "(DEFCLASS ACTIVE-COLLECTION-MIXIN () :DOCUMENTATION \"Mixin class that provides collection instances with a\nbackpointer to the instance slot they belong to.\" :MIXIN? TRUE :PUBLIC-SLOTS ((ACTIVE-SLOT :TYPE STORAGE-SLOT) (OWNER-INSTANCE :TYPE STANDARD-OBJECT)))");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("ACTIVE-LIST", "(DEFCLASS ACTIVE-LIST (LIST ACTIVE-COLLECTION-MIXIN))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.ActiveList", "newActiveList", new java.lang.Class [] {});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("ACTIVE-SET", "(DEFCLASS ACTIVE-SET (LIST SET-MIXIN ACTIVE-COLLECTION-MIXIN))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.ActiveSet", "newActiveSet", new java.lang.Class [] {});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("DEMON", "(DEFCLASS DEMON (STANDARD-OBJECT) :PUBLIC-SLOTS ((DEMON-NAME :TYPE STRING) (DEMON-ACTION :TYPE KEYWORD) (DEMON-CLASS-REFS :TYPE (LIST OF TYPE) :ALLOCATION :EMBEDDED) (DEMON-SLOT-REFS :TYPE (LIST OF SYMBOL) :ALLOCATION :EMBEDDED) (DEMON-CODE :TYPE FUNCTION-CODE) (DEMON-METHOD :TYPE METHOD-SLOT) (DEMON-DOCUMENTATION :TYPE STRING) (DEMON-GUARD? :TYPE BOOLEAN) (DEMON-ALL? :TYPE BOOLEAN) (DEMON-INHERIT? :TYPE BOOLEAN)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.Demon", "newDemon", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.Demon", "accessDemonSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Demon"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
    }
  }

  static void helpStartupHierarchy8() {
    {
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("KEYWORD-KEY-VALUE-LIST", "(DEFCLASS KEYWORD-KEY-VALUE-LIST (KEY-VALUE-LIST) :PARAMETERS ((ANY-KEY :TYPE KEYWORD) (ANY-VALUE :TYPE OBJECT)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.KeywordKeyValueList", "newKeywordKeyValueList", new java.lang.Class [] {});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("GENERALIZED-SYMBOL", "(DEFCLASS GENERALIZED-SYMBOL (CONTEXT-SENSITIVE-OBJECT) :PUBLIC-SLOTS ((SYMBOL-NAME :TYPE STRING :REQUIRED? TRUE) (SYMBOL-ID :TYPE INTEGER) (INTERNED-IN :RENAMES HOME-CONTEXT :TYPE MODULE)) :ABSTRACT? TRUE)");

        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "accessGeneralizedSymbolSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("SYMBOL", "(DEFCLASS SYMBOL (GENERALIZED-SYMBOL) :PUBLIC-SLOTS ((SYMBOL-SLOT-OFFSET :TYPE INTEGER) (SYMBOL-VALUE-AND-PLIST :TYPE CONS :INITIALLY NIL)) :PRINT-FORM (PRINT-SYMBOL SELF STREAM))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.Symbol", "newSymbol", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.Symbol", "accessSymbolSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("SURROGATE", "(DEFCLASS SURROGATE (GENERALIZED-SYMBOL) :DOCUMENTATION \"Rigid surrogate.\" :PUBLIC-SLOTS ((SURROGATE-VALUE :TYPE OBJECT) (SURROGATE-NAME :RENAMES SYMBOL-NAME) (TYPE-CLASS :RENAMES SURROGATE-VALUE :TYPE CLASS) (TYPE-NAME :RENAMES SYMBOL-NAME)) :PUBLIC-SLOTS ((SLOTREF-SLOT :RENAMES SURROGATE-VALUE :TYPE SLOT)) :SYNONYMS (TYPE SLOTREF) :PRINT-FORM (PRINT-SURROGATE SELF STREAM))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.Surrogate", "newSurrogate", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.Surrogate", "accessSurrogateSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("KEYWORD", "(DEFCLASS KEYWORD (GENERALIZED-SYMBOL) :PUBLIC-SLOTS ((KEYWORD-NAME :RENAMES SYMBOL-NAME)) :PRINT-FORM (PRINT-KEYWORD SELF STREAM))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.Keyword", "newKeyword", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.Keyword", "accessKeywordSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("TRANSIENT-SYMBOL", "(DEFCLASS TRANSIENT-SYMBOL (SYMBOL TRANSIENT-MIXIN))");

        Stella.$HARDWIRED_TRANSIENTp_ON_TRANSIENT_MIXIN$ = true;
        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.TransientSymbol", "newTransientSymbol", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("MAPPABLE-OBJECT", "(DEFCLASS MAPPABLE-OBJECT (STANDARD-OBJECT DYNAMIC-SLOTS-MIXIN) :DOCUMENTATION \"The class MAPPABLE-OBJECT enables the definition of projections\nfrom a Stella class, slot, global variable, etc. onto a corresponding native\nentity.\" :ABSTRACT? TRUE :PUBLIC-SLOTS ((PROJECTS-ONTO :TYPE (LIST OF SYMBOL) :ALLOCATION :DYNAMIC) (PROJECTED-FROM :TYPE (LIST OF SYMBOL) :ALLOCATION :DYNAMIC) (PROJECTION-TRANSFORM :TYPE SYMBOL :ALLOCATION :DYNAMIC :DOCUMENTATION \"Names a coersion function that translates\nvalues retrieved from the `from' entity to the `projecting' entity.\")) :PUBLIC-SLOTS ((NATIVE-NAME :TYPE STRING :ALLOCATION :DYNAMIC :DOCUMENTATION \"Used in cases when the native name cannot be\ncast as a symbol (e.g., because it contains illegal characters).\")))");

        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.MappableObject", "accessMappableObjectSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MappableObject"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("RELATION", "(DEFCLASS RELATION (MAPPABLE-OBJECT) :ABSTRACT? TRUE :PUBLIC-SLOTS ((DOCUMENTATION :TYPE STRING :ALLOCATION :DYNAMIC) (ABSTRACT? :TYPE BOOLEAN :OPTION-KEYWORD :ABSTRACT?) (META-ATTRIBUTES :TYPE (KEY-VALUE-LIST OF GENERALIZED-SYMBOL OBJECT) :ALLOCATION :DYNAMIC :OPTION-KEYWORD :META-ATTRIBUTES) (PROPERTIES :TYPE (LIST OF GENERALIZED-SYMBOL) :ALLOCATION :DYNAMIC :OPTION-KEYWORD :PROPERTIES)) :PUBLIC-METHODS ((NAME ((SELF RELATION)) :TYPE STRING (RETURN NULL)) (HOME-MODULE ((SELF RELATION)) :TYPE MODULE (RETURN NULL)) (ARITY ((SELF RELATION)) :TYPE INTEGER (RETURN NULL)) (PUBLIC? ((SELF RELATION)) :TYPE BOOLEAN (RETURN NULL)) (DIRECT-SUPERS ((SELF RELATION)) :TYPE (LIST OF RELATION) (RETURN NULL)) (ALL-SUPERS ((SELF RELATION)) :TYPE (LIST OF RELATION) (RETURN NULL)) (SLOTS ((SELF RELATION)) :TYPE (ITERATOR OF SLOT) (RETURN NULL))) :SLOTS ((STORED-ACTIVE? :TYPE BOOLEAN-WRAPPER :ALLOCATION :DYNAMIC :OPTION-KEYWORD :ACTIVE?)))");

        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.Relation", "accessRelationSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Relation"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CLASS", "(DEFCLASS CLASS (RELATION) :PUBLIC-SLOTS ((CL-STRUCT? :TYPE BOOLEAN :INITIALLY FALSE) (MIXIN? :TYPE BOOLEAN :INITIALLY FALSE) (PRINT-FORM :TYPE OBJECT :ALLOCATION :DYNAMIC :OPTION-KEYWORD :PRINT-FORM) (CLASS-TYPE :TYPE TYPE :PUBLIC? TRUE) (CLASS-ARITY :TYPE INTEGER :INITIALLY 1 :HARDWIRED? TRUE) (CLASS-DIRECT-SUPERS :TYPE (LIST OF TYPE) :ALLOCATION :EMBEDDED) (CLASS-DIRECT-SUBS :TYPE (LIST OF TYPE) :ALLOCATION :EMBEDDED) (CLASS-ALL-SUPER-CLASSES :TYPE (CONS OF CLASS) :INITIALLY NIL :PUBLIC? TRUE) (CLASS-ALL-SLOTS :TYPE (CONS OF SLOT)) (CLASS-LOCAL-SLOTS :TYPE (LIST OF SLOT)) (CLASS-SLOT-AND-METHOD-CACHE :TYPE (VECTOR OF SLOT)) (CLASS-ABSTRACT? :TYPE BOOLEAN :INITIALLY FALSE :RENAMES ABSTRACT?) (CLASS-MIXIN? :TYPE BOOLEAN :INITIALLY FALSE :RENAMES MIXIN?) (CLASS-COLLECTION? :TYPE BOOLEAN :INITIALLY FALSE) (CLASS-CL-STRUCT? :TYPE BOOLEAN :INITIALLY FALSE :RENAMES CL-STRUCT?) (CLASS-CL-STRUCT-SLOTS :TYPE (LIST OF STORAGE-SLOT) :ALLOCATION :DYNAMIC) (CLASS-PUBLIC? :TYPE BOOLEAN :INITIALLY TRUE :OPTION-KEYWORD :PUBLIC?) (CLASS-RECYCLE-METHOD :TYPE KEYWORD :ALLOCATION :DYNAMIC :DEFAULT :NONE :OPTION-KEYWORD :RECYCLE-METHOD) (CLASS-FINALIZED? :TYPE BOOLEAN :INITIALLY FALSE :PUBLIC? TRUE) (CLASS-SLOTS-FINALIZED? :TYPE BOOLEAN :INITIALLY FALSE) (CLASS-STRINGIFIED-SOURCE :TYPE STRING) (CLASS-PARAMETERS :TYPE (LIST OF SYMBOL) :ALLOCATION :DYNAMIC :DEFAULT NIL-LIST :OPTION-KEYWORD :PARAMETERS) (CLASS-CONSTRUCTOR-CODE :TYPE FUNCTION-CODE) (CLASS-SLOT-ACCESSOR-CODE :TYPE FUNCTION-CODE) (CLASS-CREATOR :TYPE SYMBOL :ALLOCATION :DYNAMIC :OPTION-KEYWORD :CREATOR) (CLASS-INITIALIZER :TYPE SYMBOL :ALLOCATION :DYNAMIC :OPTION-KEYWORD :INITIALIZER) (CLASS-TERMINATOR :TYPE SYMBOL :ALLOCATION :DYNAMIC :OPTION-KEYWORD :TERMINATOR) (CLASS-DESTRUCTOR :TYPE SYMBOL :ALLOCATION :DYNAMIC :OPTION-KEYWORD :DESTRUCTOR) (CLASS-DOCUMENTATION :ALLOCATION :DYNAMIC :RENAMES DOCUMENTATION :OPTION-KEYWORD :DOCUMENTATION) (CLASS-EXTENSION-NAME :TYPE SYMBOL :ALLOCATION :DYNAMIC :OPTION-KEYWORD :EXTENSION) (CLASS-EXTENSION :TYPE CLASS-EXTENSION :ALLOCATION :DYNAMIC) (CLASS-REQUIRED-SLOT-NAMES :TYPE (LIST OF SYMBOL) :ALLOCATION :DYNAMIC :DEFAULT NIL-LIST) (CLASS-GUARD-CONSTRUCTOR-DEMONS :TYPE (LIST OF DEMON) :ALLOCATION :DYNAMIC) (CLASS-CONSTRUCTOR-DEMONS :TYPE (LIST OF DEMON) :ALLOCATION :DYNAMIC) (CLASS-GUARD-DESTRUCTOR-DEMONS :TYPE (LIST OF DEMON) :ALLOCATION :DYNAMIC) (CLASS-DESTRUCTOR-DEMONS :TYPE (LIST OF DEMON) :ALLOCATION :DYNAMIC) (CLASS-INITIAL-VALUE :TYPE OBJECT :ALLOCATION :DYNAMIC :OPTION-KEYWORD :INITIAL-VALUE) (CLASS-PRINT-FORM :TYPE OBJECT :RENAMES PRINT-FORM :OPTION-KEYWORD :PRINT-FORM) (CLASS-KEY :TYPE (LIST OF SLOT) :ALLOCATION :DYNAMIC :DEFAULT NIL-LIST) (CLASS-SYNONYMS :TYPE (LIST OF TYPE) :ALLOCATION :DYNAMIC :DEFAULT NIL-LIST :OPTION-KEYWORD :SYNONYMS) (CLASS-IS-LINK :TYPE TYPE :ALLOCATION :DYNAMIC) (CLASS-INVERSE-IS-LINK :TYPE CLASS :ALLOCATION :DYNAMIC) (CLASS-CL-NATIVE-TYPE :TYPE STRING :ALLOCATION :DYNAMIC :OPTION-KEYWORD :CL-NATIVE-TYPE) (CLASS-CPP-NATIVE-TYPE :TYPE STRING :ALLOCATION :DYNAMIC :OPTION-KEYWORD :CPP-NATIVE-TYPE) (CLASS-JAVA-NATIVE-TYPE :TYPE STRING :ALLOCATION :DYNAMIC :OPTION-KEYWORD :JAVA-NATIVE-TYPE) (CLASS-IDL-NATIVE-TYPE :TYPE STRING :ALLOCATION :DYNAMIC :OPTION-KEYWORD :IDL-NATIVE-TYPE) (CLASS-MARKED? :TYPE BOOLEAN) (CLASS-PROTOTYPE :TYPE OBJECT :ALLOCATION :DYNAMIC) (CLASS-TAXONOMY-NODE :TYPE TAXONOMY-NODE)) :PUBLIC-METHODS ((NAME ((SELF CLASS)) :TYPE STRING (RETURN (SYMBOL-NAME (CLASS-TYPE SELF)))) (HOME-MODULE ((SELF CLASS)) :TYPE MODULE (RETURN (INTERNED-IN (CLASS-TYPE SELF)))) (ARITY ((SELF CLASS)) :TYPE INTEGER (RETURN 1)) (PUBLIC? ((SELF CLASS)) :TYPE BOOLEAN :STORAGE-SLOT CLASS-PUBLIC? (RETURN (CLASS-PUBLIC? SELF))) (ACTIVE? ((SELF CLASS)) :TYPE BOOLEAN :STORAGE-SLOT STORED-ACTIVE? (RETURN (OR (AND (DEFINED? (STORED-ACTIVE? SELF)) (STORED-ACTIVE? SELF)) (SUBTYPE-OF? (CLASS-TYPE SELF) @ACTIVE-OBJECT)))) (CREATOR ((SELF CLASS)) :TYPE SYMBOL :STORAGE-SLOT CLASS-CREATOR (RETURN (CLASS-CREATOR SELF))) (INITIALIZER ((SEL" + "F CLASS)) :TYPE SYMBOL :STORAGE-SLOT CLASS-INITIALIZER :INHERITS-THROUGH SUPER-CLASSES) (TERMINATOR ((SELF CLASS)) :TYPE SYMBOL :STORAGE-SLOT CLASS-TERMINATOR :INHERITS-THROUGH SUPER-CLASSES) (DESTRUCTOR ((SELF CLASS)) :TYPE SYMBOL :STORAGE-SLOT CLASS-DESTRUCTOR (RETURN (CLASS-DESTRUCTOR SELF))) (REQUIRED-SLOTS ((SELF CLASS)) :TYPE (LIST OF SYMBOL) :DOCUMENTATION \"Returns a list of names of required slots for `self'.\" (RETURN (CLASS-REQUIRED-SLOT-NAMES SELF))) (PARAMETERS ((SELF CLASS)) :TYPE (LIST OF SYMBOL) :DOCUMENTATION \"Returns the list of parameters names of `self'.\" :STORAGE-SLOT CLASS-PARAMETERS :INHERITS-THROUGH SUPER-CLASSES) (INITIAL-VALUE ((SELF CLASS)) :TYPE OBJECT :DOCUMENTATION \"Return an initial value for the class `self'.\" :STORAGE-SLOT CLASS-INITIAL-VALUE :INHERITS-THROUGH SUPER-CLASSES) (EXTENSION ((SELF CLASS)) :TYPE CLASS-EXTENSION :DOCUMENTATION \"Return the nearest class extension that records instances\nof the class `self'.\" :STORAGE-SLOT CLASS-EXTENSION :INHERITS-THROUGH SUPER-CLASSES) (CL-NATIVE-TYPE ((SELF CLASS)) :TYPE STRING :STORAGE-SLOT CLASS-CL-NATIVE-TYPE (RETURN (CLASS-CL-NATIVE-TYPE SELF))) (CPP-NATIVE-TYPE ((SELF CLASS)) :TYPE STRING :STORAGE-SLOT CLASS-CPP-NATIVE-TYPE (RETURN (CLASS-CPP-NATIVE-TYPE SELF))) (IDL-NATIVE-TYPE ((SELF CLASS)) :TYPE STRING :STORAGE-SLOT CLASS-IDL-NATIVE-TYPE (RETURN (CLASS-CPP-NATIVE-TYPE SELF))) (JAVA-NATIVE-TYPE ((SELF CLASS)) :TYPE STRING :STORAGE-SLOT CLASS-JAVA-NATIVE-TYPE (LET ((NATIVETYPE (CLASS-JAVA-NATIVE-TYPE SELF))) (IF (DEFINED? NATIVETYPE) (RETURN (SUBSTITUTE-TEMPLATE-VARIABLES-IN-STRING NATIVETYPE *JAVA-STELLA-PACKAGE-MAPPING*)) (RETURN NULL))))) :PRINT-FORM (PRINT-NATIVE-STREAM STREAM \"|C|\" (CHOOSE (DEFINED? (CLASS-TYPE SELF)) (RELATIVE-NAME (CLASS-SYMBOL SELF) FALSE) \"??\")))");

        Stella.$HARDWIRED_CLASS_ARITY_ON_CLASS$ = 1;
        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.Stella_Class", "newClass", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.Stella_Class", "accessClassSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("POLYMORPHIC-RELATION", "(DEFCLASS POLYMORPHIC-RELATION (RELATION) :ABSTRACT? TRUE :PUBLIC-SLOTS ((SLOT-DIRECT-EQUIVALENT :TYPE SLOT)) :PUBLIC-METHODS ((OWNER ((SELF POLYMORPHIC-RELATION)) :TYPE TYPE (RETURN NULL)) (RENAMES ((SELF POLYMORPHIC-RELATION)) :TYPE SYMBOL (RETURN NULL)) (ACTIVE? ((SELF POLYMORPHIC-RELATION)) :TYPE BOOLEAN :STORAGE-SLOT STORED-ACTIVE? :INHERITS-THROUGH EQUIVALENT-SLOT :DOCUMENTATION \"True if `self' or a superslot of `self' is marked active.\")))");

        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.PolymorphicRelation", "accessPolymorphicRelationSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.PolymorphicRelation"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("SLOT", "(DEFCLASS SLOT (POLYMORPHIC-RELATION) :ABSTRACT? TRUE :PUBLIC-METHODS ((NAME ((SELF SLOT)) :TYPE STRING (RETURN (SYMBOL-NAME (SLOT-NAME SELF)))) (TYPE ((SELF SLOT)) :TYPE TYPE :STORAGE-SLOT SLOT-BASE-TYPE :INHERITS-THROUGH EQUIVALENT-SLOT :DOCUMENTATION \"The type of a storage slot is its base type.\") (TYPE-SPECIFIER ((SELF SLOT)) :TYPE TYPE-SPEC :DOCUMENTATION \"If `self' has a complex type return its\ntype specifier, otherwise, return `type' of `self'.\" (LET ((TSPEC (SLOT-TYPE-SPECIFIER SELF))) (RETURN (CHOOSE (DEFINED? TSPEC) TSPEC (TYPE SELF))))) (OWNER ((SELF SLOT)) :TYPE TYPE :STORAGE-SLOT SLOT-OWNER (RETURN (SLOT-OWNER SELF))) (HOME-MODULE ((SELF SLOT)) :TYPE MODULE (LET ((MODULE (SLOT-HOME-MODULE SELF))) (IF (DEFINED? MODULE) (RETURN MODULE) (RETURN (INTERNED-IN (SLOT-NAME SELF)))))) (RENAMES ((SELF SLOT)) :TYPE SYMBOL :STORAGE-SLOT SLOT-RENAMES (RETURN (SLOT-RENAMES SELF))) (COLLECTION-VALUED? ((SELF SLOT)) :TYPE BOOLEAN :DOCUMENTATION \"True if slot values are collections.\" (RETURN (SUBTYPE-OF? (SLOT-BASE-TYPE SELF) @COLLECTION))) (CLOSURE-ASSUMPTION ((SELF SLOT)) :TYPE KEYWORD :STORAGE-SLOT SLOT-CLOSURE-ASSUMPTION :INHERITS-THROUGH EQUIVALENT-SLOT)) :PUBLIC-SLOTS ((INVERSE :TYPE SLOT :ALLOCATION :DYNAMIC) (SLOT-NAME :TYPE SYMBOL) (SLOT-OWNER :TYPE TYPE) (SLOT-BASE-TYPE :TYPE TYPE) (SLOT-SLOTREF :TYPE SLOTREF) (SLOT-DIRECT-SUPERS :TYPE (LIST OF SLOT) :ALLOCATION :DYNAMIC) (SLOT-DIRECT-SUBS :TYPE (LIST OF SLOT) :ALLOCATION :DYNAMIC) (SLOT-HOME-MODULE :TYPE MODULE :ALLOCATION :DYNAMIC) (SLOT-TYPE-SPECIFIER :TYPE COMPOUND-TYPE-SPECIFIER :ALLOCATION :DYNAMIC) (SLOT-PUBLIC? :TYPE BOOLEAN :INITIALLY TRUE :OPTION-KEYWORD :PUBLIC?) (SLOT-INVERSE :TYPE SYMBOL :ALLOCATION :DYNAMIC :OPTION-KEYWORD :INVERSE) (SLOT-RENAMES :TYPE SYMBOL :ALLOCATION :DYNAMIC :OPTION-KEYWORD :RENAMES) (SLOT-RENAMED? :TYPE BOOLEAN :INITIALLY FALSE) (SLOT-DOCUMENTATION :TYPE STRING :ALLOCATION :DYNAMIC :RENAMES DOCUMENTATION :OPTION-KEYWORD :DOCUMENTATION) (SLOT-EXTERNAL? :TYPE BOOLEAN :INITIALLY FALSE) (SLOT-MARKED? :TYPE BOOLEAN) (SLOT-AUXILIARY? :TYPE BOOLEAN :ALLOCATION :DYNAMIC :OPTION-KEYWORD :AUXILIARY?) (SLOT-CLOSURE-ASSUMPTION :TYPE KEYWORD :ALLOCATION :DYNAMIC)) :PRINT-FORM (PRINT-NATIVE-STREAM STREAM \"|S|\" (SYMBOL-NAME (SLOT-OWNER SELF)) \".\" (SYMBOL-NAME (SLOT-NAME SELF))))");

        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.Slot", "accessSlotSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("STORAGE-SLOT", "(DEFCLASS STORAGE-SLOT (SLOT) :PUBLIC-METHODS ((INITIALLY ((SELF STORAGE-SLOT)) :TYPE OBJECT) (ALLOCATION ((SELF STORAGE-SLOT)) :TYPE KEYWORD :STORAGE-SLOT SLOT-ALLOCATION :INHERITS-THROUGH EQUIVALENT-SLOT :DOCUMENTATION \"Return the most specific :allocation facet, or\n:instance if all inherited values are NULL.\") (DEFAULT-FORM ((SELF STORAGE-SLOT)) :TYPE OBJECT :STORAGE-SLOT SLOT-DEFAULT-EXPRESSION :INHERITS-THROUGH EQUIVALENT-SLOT :DOCUMENTATION \"Returns the current value of default expression when the\nslot has not been assigned a value.\") (REQUIRED? ((SELF STORAGE-SLOT)) :TYPE BOOLEAN :STORAGE-SLOT SLOT-REQUIRED? :INHERITS-THROUGH EQUIVALENT-SLOT :DOCUMENTATION \"True if a value must be assigned to this slot at\ncreation time.\") (COMPONENT? ((SELF STORAGE-SLOT)) :TYPE BOOLEAN :STORAGE-SLOT SLOT-COMPONENT? :INHERITS-THROUGH EQUIVALENT-SLOT :DOCUMENTATION \"True if fillers of this slot are components of the\nowner slot, and therefore should be deleted if the owner is deleted.\") (READER ((SELF STORAGE-SLOT)) :TYPE SYMBOL :STORAGE-SLOT SLOT-READER :INHERITS-THROUGH EQUIVALENT-SLOT :DOCUMENTATION \"Name of a method called to read the value of the slot\n`self'.\") (WRITER ((SELF STORAGE-SLOT)) :TYPE SYMBOL :STORAGE-SLOT SLOT-WRITER :INHERITS-THROUGH EQUIVALENT-SLOT :DOCUMENTATION \"Name of a method called to write the value of the slot\n`self'.\")) :PUBLIC-SLOTS ((SLOT-INITIAL-VALUE :TYPE OBJECT :ALLOCATION :DYNAMIC :OPTION-KEYWORD :INITIALLY) (SLOT-ALLOCATION :TYPE KEYWORD :ALLOCATION :DYNAMIC :DEFAULT :INSTANCE :OPTION-KEYWORD :ALLOCATION) (SLOT-DEFAULT-EXPRESSION :TYPE OBJECT :ALLOCATION :DYNAMIC :OPTION-KEYWORD :DEFAULT) (SLOT-GUARD-DEMONS :TYPE (LIST OF DEMON) :ALLOCATION :DYNAMIC) (SLOT-DEMONS :TYPE (LIST OF DEMON) :ALLOCATION :DYNAMIC) (SLOT-REQUIRED? :TYPE BOOLEAN :OPTION-KEYWORD :REQUIRED?) (SLOT-COMPONENT? :TYPE BOOLEAN :OPTION-KEYWORD :COMPONENT?) (SLOT-READ-ONLY? :TYPE BOOLEAN :OPTION-KEYWORD :READ-ONLY?) (SLOT-HARDWIRED? :TYPE BOOLEAN :OPTION-KEYWORD :HARDWIRED?) (SLOT-CONTEXT-SENSITIVE? :TYPE BOOLEAN :OPTION-KEYWORD :CONTEXT-SENSITIVE?) (SLOT-READER :TYPE SYMBOL :ALLOCATION :DYNAMIC :OPTION-KEYWORD :READER) (SLOT-WRITER :TYPE SYMBOL :ALLOCATION :DYNAMIC :OPTION-KEYWORD :WRITER) (SLOT-OPTION-KEYWORD :TYPE KEYWORD :ALLOCATION :DYNAMIC :OPTION-KEYWORD :OPTION-KEYWORD) (SLOT-OPTION-HANDLER :TYPE SYMBOL :ALLOCATION :DYNAMIC :OPTION-KEYWORD :OPTION-HANDLER)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.StorageSlot", "newStorageSlot", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.StorageSlot", "accessStorageSlotSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("METHOD-SLOT", "(DEFCLASS METHOD-SLOT (SLOT) :SYNONYMS (FUNCTION) :PUBLIC-SLOTS ((STORAGE-SLOT :TYPE SYMBOL :ALLOCATION :DYNAMIC) (SLOT-REQUIRED? :TYPE BOOLEAN :ALLOCATION :DYNAMIC :DEFAULT FALSE) (METHOD-SETTER? :TYPE BOOLEAN) (METHOD-DOCUMENTATION :TYPE STRING :ALLOCATION :DYNAMIC :RENAMES DOCUMENTATION) (METHOD-PARAMETER-NAMES :TYPE (LIST OF SYMBOL) :DEFAULT NIL-LIST :COMPONENT? TRUE) (METHOD-PARAMETER-TYPE-SPECIFIERS :TYPE (LIST OF TYPE-SPEC) :DEFAULT NIL-LIST :COMPONENT? TRUE) (METHOD-PARAMETER-DIRECTIONS :TYPE (LIST OF SYMBOL) :DEFAULT NIL-LIST :COMPONENT? TRUE :ALLOCATION :DYNAMIC) (METHOD-RETURN-TYPE-SPECIFIERS :TYPE (LIST OF TYPE-SPEC) :DEFAULT NIL-LIST :COMPONENT? TRUE) (METHOD-STRINGIFIED-SOURCE :TYPE STRING) (METHOD-CODE :TYPE METHOD-CODE) (FUNCTION-CODE :TYPE FUNCTION-CODE) (METHOD-FUNCTION? :TYPE BOOLEAN) (METHOD-VARIABLE-ARGUMENTS? :TYPE BOOLEAN :ALLOCATION :DYNAMIC :DEFAULT FALSE) (METHOD-BODY-ARGUMENT? :TYPE BOOLEAN :ALLOCATION :DYNAMIC :DEFAULT FALSE) (METHOD-AUXILIARY? :RENAMES SLOT-AUXILIARY?) (METHOD-NATIVE? :TYPE BOOLEAN :ALLOCATION :DYNAMIC :DEFAULT FALSE) (METHOD-CONSTRUCTOR? :TYPE BOOLEAN :ALLOCATION :DYNAMIC :DEFAULT FALSE) (METHOD-GLOBALLY-INLINE? :TYPE BOOLEAN :ALLOCATION :DYNAMIC :DEFAULT FALSE) (METHOD-INLINED-FUNCTIONS :TYPE (LIST OF SYMBOL) :ALLOCATION :DYNAMIC :DEFAULT NIL-LIST) (METHOD-STORAGE-SLOT :TYPE SYMBOL :ALLOCATION :DYNAMIC :RENAMES STORAGE-SLOT) (METHOD-INHERITS-THROUGH :TYPE SYMBOL :ALLOCATION :DYNAMIC) (METHOD-COMMAND? :TYPE BOOLEAN :ALLOCATION :DYNAMIC :DEFAULT FALSE) (METHOD-EVALUATE-ARGUMENTS? :TYPE BOOLEAN :ALLOCATION :DYNAMIC :DEFAULT TRUE) (METHOD-LISP-MACRO? :TYPE BOOLEAN-WRAPPER :ALLOCATION :DYNAMIC) (EVALUATOR-WRAPPER-CODE :TYPE FUNCTION-CODE :ALLOCATION :DYNAMIC)) :PUBLIC-METHODS ((SETTER? ((SELF METHOD-SLOT)) :TYPE BOOLEAN :STORAGE-SLOT METHOD-SETTER? (RETURN (METHOD-SETTER? SELF)))) :PRINT-FORM (IF (METHOD-FUNCTION? SELF) (PRINT-NATIVE-STREAM STREAM \"|F|\" (SYMBOL-NAME (SLOT-NAME SELF))) (PRINT-NATIVE-STREAM STREAM \"|M|\" (SYMBOL-NAME (SLOT-OWNER SELF)) \".\" (SYMBOL-NAME (SLOT-NAME SELF)))))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.MethodSlot", "newMethodSlot", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.MethodSlot", "accessMethodSlotSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      Stella.defineClassFromStringifiedSource("COMPOUND-TYPE-SPECIFIER", "(DEFCLASS COMPOUND-TYPE-SPECIFIER (STANDARD-OBJECT) :ABSTRACT? TRUE :PRINT-FORM (PRINT-NATIVE-STREAM STREAM \"|TS|\" (YIELD-TYPE-SPEC-TREE SELF)))");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("PARAMETRIC-TYPE-SPECIFIER", "(DEFCLASS PARAMETRIC-TYPE-SPECIFIER (COMPOUND-TYPE-SPECIFIER) :PUBLIC-SLOTS ((SPECIFIER-BASE-TYPE :TYPE TYPE) (SPECIFIER-PARAMETER-TYPES :TYPE (LIST OF TYPE-SPEC) :ALLOCATION :EMBEDDED) (SPECIFIER-DIMENSIONS :TYPE (LIST OF OBJECT))))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.ParametricTypeSpecifier", "newParametricTypeSpecifier", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.ParametricTypeSpecifier", "accessParametricTypeSpecifierSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.ParametricTypeSpecifier"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("ANCHORED-TYPE-SPECIFIER", "(DEFCLASS ANCHORED-TYPE-SPECIFIER (COMPOUND-TYPE-SPECIFIER) :PUBLIC-SLOTS ((SPECIFIER-PARAMETER-NAME :TYPE SYMBOL)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.AnchoredTypeSpecifier", "newAnchoredTypeSpecifier", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.AnchoredTypeSpecifier", "accessAnchoredTypeSpecifierSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AnchoredTypeSpecifier"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("TABLE", "(DEFCLASS TABLE (SLOT) :PARAMETERS ((ANY-VALUE :TYPE BOOLEAN)) :PUBLIC-SLOTS ((TUPLE-DOMAINS :TYPE (LIST OF TYPE-SPEC)) (VARIABLE-ARITY-TABLE? :TYPE BOOLEAN :ALLOCATION :DYNAMIC)) :PRINT-FORM (PRINT-NATIVE-STREAM STREAM \"|T|\" (SYMBOL-NAME (SLOT-NAME SELF))))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.Table", "newTable", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.Table", "accessTableSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Table"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("GLOBAL-VARIABLE", "(DEFCLASS GLOBAL-VARIABLE (MAPPABLE-OBJECT) :PUBLIC-SLOTS ((DOCUMENTATION :TYPE STRING)) :PUBLIC-METHODS ((NAME ((SELF GLOBAL-VARIABLE)) :TYPE STRING (RETURN (SYMBOL-NAME (VARIABLE-NAME SELF)))) (TYPE ((SELF GLOBAL-VARIABLE)) :TYPE TYPE :STORAGE-SLOT VARIABLE-TYPE (RETURN (VARIABLE-TYPE SELF))) (HOME-MODULE ((SELF GLOBAL-VARIABLE)) :TYPE MODULE (LET ((MODULE (VARIABLE-HOME-MODULE SELF))) (IF (DEFINED? MODULE) (RETURN MODULE) (RETURN (INTERNED-IN (VARIABLE-NAME SELF))))))) :PUBLIC-SLOTS ((VARIABLE-NAME :TYPE SYMBOL) (VARIABLE-TYPE :TYPE TYPE) (VARIABLE-TYPE-SPECIFIER :TYPE TYPE-SPEC :ALLOCATION :DYNAMIC) (VARIABLE-HOME-MODULE :TYPE MODULE :ALLOCATION :DYNAMIC) (VARIABLE-SPECIAL? :TYPE BOOLEAN) (VARIABLE-CONSTANT? :TYPE BOOLEAN) (VARIABLE-PUBLIC? :TYPE BOOLEAN :INITIALLY TRUE) (VARIABLE-AUXILIARY? :TYPE BOOLEAN) (VARIABLE-THREAD-LOCAL? :TYPE BOOLEAN :OPTION-KEYWORD :THREAD-LOCAL? :ALLOCATION :DYNAMIC :DOCUMENTATION \"If true, the variable will be allocated on a per-thread\nbasis similar to specials for which this is always true.  CAUTION: this is\nonly a documentation place holder so far and not yet used by the translators.\") (VARIABLE-GET-VALUE-CODE :TYPE FUNCTION-CODE) (VARIABLE-SET-VALUE-CODE :TYPE FUNCTION-CODE) (VARIABLE-VALUE-STACK :TYPE LIST) (VARIABLE-DOCUMENTATION :TYPE STRING :RENAMES DOCUMENTATION) (VARIABLE-STRINGIFIED-SOURCE :TYPE STRING)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.GlobalVariable", "newGlobalVariable", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.GlobalVariable", "accessGlobalVariableSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GlobalVariable"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("QUOTED-EXPRESSION", "(DEFCLASS QUOTED-EXPRESSION (STANDARD-OBJECT) :PUBLIC-SLOTS ((QUOTATION-TABLE-OFFSET :TYPE INTEGER)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.QuotedExpression", "newQuotedExpression", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.QuotedExpression", "accessQuotedExpressionSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.QuotedExpression"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      Stella.defineClassFromStringifiedSource("VOID", "(DEFCLASS VOID () :ABSTRACT? TRUE :JAVA-NATIVE-TYPE \"void\" :IDL-NATIVE-TYPE \"void\" :CPP-NATIVE-TYPE \"void\")");
      Stella.defineClassFromStringifiedSource("UNKNOWN", "(DEFCLASS UNKNOWN () :ABSTRACT? TRUE :CPP-NATIVE-TYPE \"unknown\" :IDL-NATIVE-TYPE \"unknown\" :JAVA-NATIVE-TYPE \"unknown\" :SLOTS ((UNKNOWN-SLOT :TYPE UNKNOWN)))");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("THING", "(DEFCLASS THING (STANDARD-OBJECT DYNAMIC-SLOTS-MIXIN) :ABSTRACT? TRUE :DOCUMENTATION \"Defines a class that must be inherited by any\nclass that participates in the PowerLoom side of things.\" :PUBLIC-SLOTS ((SURROGATE-VALUE-INVERSE :TYPE SURROGATE)) :PRINT-FORM (IF (DEFINED? (SURROGATE-VALUE-INVERSE SELF)) (PRINT-NATIVE-STREAM STREAM \"|i|\" (SYMBOL-NAME (SURROGATE-VALUE-INVERSE SELF))) (PRINT-NATIVE-STREAM STREAM \"|i|\" (PRIMARY-TYPE SELF))))");

        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.Thing", "accessThingSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Thing"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CONTEXT", "(DEFCLASS CONTEXT (THING) :ABSTRACT? TRUE :PUBLIC-SLOTS ((CHILD-CONTEXTS :TYPE (LIST OF CONTEXT) :ALLOCATION :EMBEDDED) (BASE-MODULE :TYPE MODULE) (ALL-SUPER-CONTEXTS :TYPE (CONS OF CONTEXT)) (CONTEXT-NUMBER :TYPE INTEGER)) :METHODS ((CONTEXT-NAME ((SELF CONTEXT)) :TYPE STRING (LET ((AUX SELF)) (TYPECASE AUX (MODULE (RETURN (MODULE-NAME AUX))) (WORLD (RETURN (WORLD-NAME AUX)))))) (PARENT-CONTEXTS ((SELF CONTEXT)) :TYPE (ITERATOR OF CONTEXT)) (HOME-MODULE ((SELF CONTEXT)) :TYPE MODULE :PUBLIC? TRUE (RETURN (BASE-MODULE SELF)))) :PRINT-FORM (PRINT-CONTEXT SELF STREAM))");

        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.Context", "accessContextSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("MODULE", "(DEFCLASS MODULE (CONTEXT) :PUBLIC-SLOTS ((PARENT-MODULES :TYPE (LIST OF MODULE) :ALLOCATION :EMBEDDED) (DOCUMENTATION :TYPE STRING :OPTION-KEYWORD :DOCUMENTATION) (NICKNAMES :TYPE (LIST OF STRING-WRAPPER) :OPTION-KEYWORD :NICKNAMES) (USES :TYPE (LIST OF MODULE) :ALLOCATION :EMBEDDED :OPTION-KEYWORD :USES) (USED-BY :TYPE (LIST OF MODULE) :ALLOCATION :EMBEDDED) (SHADOWED-SURROGATES :TYPE (LIST OF SURROGATE) :ALLOCATION :DYNAMIC) (REQUIRES :TYPE (LIST OF MODULE) :OPTION-KEYWORD :REQUIRES) (MODULE-LISP-PACKAGE :TYPE STRING :DEFAULT \"STELLA\" :ALLOCATION :DYNAMIC :OPTION-KEYWORD :MODULE-LISP-PACKAGE) (MODULE-CPP-PACKAGE :TYPE STRING :DEFAULT \"stella\" :ALLOCATION :DYNAMIC :OPTION-KEYWORD :MODULE-CPP-PACKAGE) (JAVA-PACKAGE :TYPE STRING :DEFAULT NULL :ALLOCATION :DYNAMIC :OPTION-KEYWORD :JAVA-PACKAGE) (CASE-SENSITIVE? :TYPE BOOLEAN :INITIALLY FALSE :OPTION-KEYWORD :CASE-SENSITIVE?) (CLEARABLE? :TYPE BOOLEAN :ALLOCATION :DYNAMIC :DEFAULT TRUE :OPTION-KEYWORD :CLEARABLE?) (CODE-ONLY? :TYPE BOOLEAN :ALLOCATION :DYNAMIC :OPTION-KEYWORD :CODE-ONLY?) (NAMESPACE? :TYPE BOOLEAN :ALLOCATION :DYNAMIC :OPTION-KEYWORD :NAMESPACE?) (API? :TYPE BOOLEAN :ALLOCATION :DYNAMIC :OPTION-KEYWORD :API?) (PROTECT-SURROGATES? :TYPE BOOLEAN :ALLOCATION :DYNAMIC :OPTION-KEYWORD :PROTECT-SURROGATES? :DEFAULT TRUE) (JAVA-FLOTSAM-CLASS :TYPE STRING :ALLOCATION :DYNAMIC :OPTION-KEYWORD :JAVA-CATCHALL-CLASS) (MODULE-FULL-NAME :TYPE STRING) (MODULE-NAME :TYPE STRING :ALLOCATION :INSTANCE) (MODULE-STRINGIFIED-SOURCE :TYPE STRING) (STRINGIFIED-OPTIONS :TYPE STRING) (CARDINAL-MODULE :TYPE MODULE) (SYMBOL-OFFSET-TABLE :TYPE STRING-TO-INTEGER-HASH-TABLE) (SURROGATE-OFFSET-TABLE :TYPE STRING-TO-INTEGER-HASH-TABLE) (STRICT-INFERENCE-CACHE :TYPE WORLD) (DEFAULT-INFERENCE-CACHE :TYPE WORLD) (PROTOTYPE-INFERENCE-CACHE :TYPE WORLD)) :PUBLIC-METHODS ((NAME ((SELF MODULE)) :TYPE STRING (RETURN (MODULE-NAME SELF))) (PARENT-MODULE ((SELF MODULE)) :TYPE MODULE (RETURN (POP (PARENT-CONTEXTS SELF)))) (LISP-PACKAGE ((SELF MODULE)) :TYPE STRING :STORAGE-SLOT MODULE-LISP-PACKAGE :INHERITS-THROUGH PARENT-MODULES) (CPP-PACKAGE ((SELF MODULE)) :TYPE STRING :STORAGE-SLOT MODULE-CPP-PACKAGE :INHERITS-THROUGH PARENT-MODULES)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.Module", "newModule", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.Module", "accessModuleSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("WORLD", "(DEFCLASS WORLD (CONTEXT) :PUBLIC-SLOTS ((PARENT-CONTEXT :TYPE CONTEXT) (CHILD-CONTEXTS :TYPE (LIST OF WORLD) :ALLOCATION :EMBEDDED) (WORLD-NAME :TYPE STRING :ALLOCATION :DYNAMIC)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.World", "newWorld", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.World", "accessWorldSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.World"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CS-VALUE", "(DEFCLASS CS-VALUE (KEY-VALUE-LIST) :DOCUMENTATION \"Contextualized value.  Contains a sorted kv-cons list indexed\nby context. The kv-cons list is never null.  Newer (higher numbered) contexts\nappear first.\" :PARAMETERS ((ANY-KEY :TYPE CONTEXT) (ANY-VALUE :TYPE OBJECT)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.CsValue", "newCsValue", new java.lang.Class [] {});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("INTERVAL", "(DEFCLASS INTERVAL (STANDARD-OBJECT) :PUBLIC-SLOTS ((LOWER-BOUND :TYPE INTEGER) (UPPER-BOUND :TYPE INTEGER)) :PRINT-FORM (PRINT-NATIVE-STREAM STREAM \"[\" (LOWER-BOUND SELF) \",\" (UPPER-BOUND SELF) \"]\"))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.Interval", "newInterval", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.Interval", "accessIntervalSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Interval"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("TAXONOMY-NODE", "(DEFCLASS TAXONOMY-NODE (STANDARD-OBJECT) :PUBLIC-SLOTS ((NATIVE-OBJECT :TYPE OBJECT) (LABEL :TYPE INTEGER) (INTERVALS :TYPE (CONS OF INTERVAL) :INITIALLY NIL) (INITIAL-INTERVAL :TYPE INTERVAL) (FIRST-INTERVAL-LOWER-BOUND :TYPE INTEGER :INITIALLY -1) (FIRST-INTERVAL-UPPER-BOUND :TYPE INTEGER :INITIALLY -1) (PARENTS :TYPE (CONS OF TAXONOMY-NODE) :INITIALLY NIL) (CHILDREN :TYPE (CONS OF TAXONOMY-NODE) :INITIALLY NIL) (TOTAL-ANCESTORS :TYPE INTEGER :INITIALLY 1) (TREE-CHILDREN :TYPE (CONS OF TAXONOMY-NODE) :INITIALLY NIL) (MARKER :TYPE OBJECT)) :PRINT-FORM (PRINT-NATIVE-STREAM STREAM \"|TN|\" (LABEL SELF) \" \" (INTERVALS SELF) \" \" (NATIVE-OBJECT SELF)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.TaxonomyNode", "newTaxonomyNode", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.TaxonomyNode", "accessTaxonomyNodeSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("TAXONOMY-GRAPH", "(DEFCLASS TAXONOMY-GRAPH (STANDARD-OBJECT) :PUBLIC-SLOTS ((RENUMBER-IF-OUT-OF-NUMBERS? :DOCUMENTATION \"If TRUE, relabel the entire graph when a new interval\nfor an incrementally inserted node can't be allocated due to lack of\nsplittable interval space.  Otherwise, create a `foreign' interval and\npropagate it.\" :TYPE BOOLEAN :INITIALLY FALSE) (RENUMBER-RATIO :DOCUMENTATION \"Whenever the ratio between foreign intervals and\nnon-foreign intervals becomes greater than `renumber-ratio', relabel\nthe whole graph non-incrementally.\" :TYPE FLOAT :INITIALLY 0.1)) :SLOTS ((INCREMENTAL-MODE? :TYPE BOOLEAN) (LARGEST-POSTORDER-NUMBER :TYPE INTEGER) (NUMBER-OF-NODES :TYPE INTEGER) (NUMBER-OF-FOREIGN-INTERVAL-NODES :TYPE INTEGER) (ROOTS :TYPE (LIST OF TAXONOMY-NODE)) (BROKEN-LINKS :TYPE (LIST OF (CONS OF TAXONOMY-NODE))) (ADDED-LINKS :TYPE (LIST OF (CONS OF TAXONOMY-NODE))) (REMOVED-LINKS :TYPE (LIST OF (CONS OF TAXONOMY-NODE)))) :INITIALIZER INITIALIZE-TAXONOMY-GRAPH :PRINT-FORM (PRINT-NATIVE-STREAM STREAM \"|TG|\" (ROOTS SELF)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.TaxonomyGraph", "newTaxonomyGraph", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.TaxonomyGraph", "accessTaxonomyGraphSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      Stella.defineClassFromStringifiedSource("NATIVE-EXCEPTION", "(DEFCLASS NATIVE-EXCEPTION () :JAVA-NATIVE-TYPE \"java.lang.Exception\" :CL-NATIVE-TYPE \"CONDITION\" :CPP-NATIVE-TYPE \"std::exception\")");
      Stella.defineClassFromStringifiedSource("STELLA-ROOT-EXCEPTION", "(DEFCLASS STELLA-ROOT-EXCEPTION (NATIVE-EXCEPTION) :PUBLIC-SLOTS ((MESSAGE :TYPE STRING :READER EXCEPTION-MESSAGE :REQUIRED? TRUE :ABSTRACT? TRUE)) :ABSTRACT? TRUE :JAVA-NATIVE-TYPE \"java.lang.RuntimeException\" :CL-NATIVE-TYPE \"SIMPLE-ERROR\" :CPP-NATIVE-TYPE \"std::runtime_error\")");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("STELLA-EXCEPTION", "(DEFCLASS STELLA-EXCEPTION (STELLA-ROOT-EXCEPTION) :PUBLIC? TRUE)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.StellaException", "newStellaException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("INPUT-OUTPUT-EXCEPTION", "(DEFCLASS INPUT-OUTPUT-EXCEPTION (STELLA-EXCEPTION) :PUBLIC? TRUE)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.InputOutputException", "newInputOutputException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("READ-EXCEPTION", "(DEFCLASS READ-EXCEPTION (INPUT-OUTPUT-EXCEPTION) :PUBLIC? TRUE)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.ReadException", "newReadException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("END-OF-FILE-EXCEPTION", "(DEFCLASS END-OF-FILE-EXCEPTION (INPUT-OUTPUT-EXCEPTION) :PUBLIC? TRUE)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.EndOfFileException", "newEndOfFileException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("NO-SUCH-FILE-EXCEPTION", "(DEFCLASS NO-SUCH-FILE-EXCEPTION (INPUT-OUTPUT-EXCEPTION) :PUBLIC? TRUE :PUBLIC-SLOTS ((FILENAME :TYPE STRING)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.NoSuchFileException", "newNoSuchFileException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("FILE-ALREADY-EXISTS-EXCEPTION", "(DEFCLASS FILE-ALREADY-EXISTS-EXCEPTION (INPUT-OUTPUT-EXCEPTION) :PUBLIC? TRUE :PUBLIC-SLOTS ((FILENAME :TYPE STRING)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.FileAlreadyExistsException", "newFileAlreadyExistsException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("UNHANDLED-EXCEPTION", "(DEFCLASS UNHANDLED-EXCEPTION (STELLA-EXCEPTION) :PUBLIC? TRUE)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.UnhandledException", "newUnhandledException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("EVALUATION-EXCEPTION", "(DEFCLASS EVALUATION-EXCEPTION (STELLA-EXCEPTION) :PUBLIC? TRUE)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.EvaluationException", "newEvaluationException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("NO-SUCH-OBJECT-EXCEPTION", "(DEFCLASS NO-SUCH-OBJECT-EXCEPTION (STELLA-EXCEPTION) :PUBLIC? TRUE)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.NoSuchObjectException", "newNoSuchObjectException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("NO-SUCH-CONTEXT-EXCEPTION", "(DEFCLASS NO-SUCH-CONTEXT-EXCEPTION (NO-SUCH-OBJECT-EXCEPTION) :PUBLIC? TRUE)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.NoSuchContextException", "newNoSuchContextException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("UNDEFINED-CLASS-EXCEPTION", "(DEFCLASS UNDEFINED-CLASS-EXCEPTION (NO-SUCH-OBJECT-EXCEPTION) :PUBLIC? TRUE)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.UndefinedClassException", "newUndefinedClassException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("BAD-ARGUMENT-EXCEPTION", "(DEFCLASS BAD-ARGUMENT-EXCEPTION (STELLA-EXCEPTION) :PUBLIC? TRUE)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.BadArgumentException", "newBadArgumentException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("OBJECT-NOT-CLASS-EXCEPTION", "(DEFCLASS OBJECT-NOT-CLASS-EXCEPTION (BAD-ARGUMENT-EXCEPTION) :PUBLIC? TRUE)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.ObjectNotClassException", "newObjectNotClassException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("INCOMPATIBLE-QUANTITY-EXCEPTION", "(DEFCLASS INCOMPATIBLE-QUANTITY-EXCEPTION (STELLA-EXCEPTION) :PUBLIC? TRUE :DOCUMENTATION \"Exception thrown when an operation is attempted on quantities\nthat are not compatible with the requested operation.  For example,\ncomparing dates and time durations.\")");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.IncompatibleQuantityException", "newIncompatibleQuantityException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("TIMEOUT-EXCEPTION", "(DEFCLASS TIMEOUT-EXCEPTION (STELLA-EXCEPTION) :PUBLIC? TRUE)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.TimeoutException", "newTimeoutException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      Stella.defineClassFromStringifiedSource("QUANTITY", "(DEFCLASS QUANTITY (OBJECT) :PUBLIC? TRUE :ABSTRACT? TRUE :DOCUMENTATION \"General superclass for extensible quantity objects\" :PUBLIC-METHODS ((COERCE-TO ((SELF QUANTITY) (OTHER OBJECT)) :TYPE QUANTITY (IF (ISA? OTHER (PRIMARY-TYPE SELF)) (RETURN OTHER) (RETURN NULL))) (LESS? ((SELF QUANTITY) (OTHER OBJECT)) :TYPE BOOLEAN (IGNORE OTHER) (RETURN FALSE)) (LESS-EQUAL? ((SELF QUANTITY) (OTHER OBJECT)) :TYPE BOOLEAN (RETURN (OR (OBJECT-EQL? SELF OTHER) (LESS? SELF OTHER)))) (GREATER-EQUAL? ((SELF QUANTITY) (OTHER OBJECT)) :TYPE BOOLEAN (RETURN (OR (OBJECT-EQL? SELF OTHER) (GREATER? SELF OTHER)))) (GREATER? ((SELF QUANTITY) (OTHER OBJECT)) :TYPE BOOLEAN (IGNORE OTHER) (RETURN FALSE))))");
      Stella.defineClassFromStringifiedSource("LITERAL", "(DEFCLASS LITERAL (NON-OBJECT) :ABSTRACT? TRUE)");
      Stella.defineClassFromStringifiedSource("NUMBER", "(DEFCLASS NUMBER (LITERAL) :ABSTRACT? TRUE)");
      Stella.defineClassFromStringifiedSource("INTEGER", "(DEFCLASS INTEGER (NUMBER) :CL-NATIVE-TYPE \"FIXNUM\" :CPP-NATIVE-TYPE \"int\" :IDL-NATIVE-TYPE \"long\" :JAVA-NATIVE-TYPE \"int\" :INITIAL-VALUE NULL-INTEGER :EQUALITY-TEST EQL?)");
      Stella.defineClassFromStringifiedSource("FLOAT", "(DEFCLASS FLOAT (NUMBER) :CL-NATIVE-TYPE \"FLOAT\" :CPP-NATIVE-TYPE \"double\" :IDL-NATIVE-TYPE \"double\" :JAVA-NATIVE-TYPE \"double\" :INITIAL-VALUE NULL-FLOAT :EQUALITY-TEST EQL?)");
      Stella.defineClassFromStringifiedSource("MUTABLE-STRING", "(DEFCLASS MUTABLE-STRING (LITERAL) :CL-NATIVE-TYPE \"STRING\" :IDL-NATIVE-TYPE \"string\" :JAVA-NATIVE-TYPE \"StringBuffer\" :CPP-NATIVE-TYPE \"char*\" :EQUALITY-TEST STRING-EQL? :INITIAL-VALUE (VERBATIM :COMMON-LISP \"STELLA::NULL-STRING\" :JAVA \"null\" :CPP \"NULL\"))");
      Stella.defineClassFromStringifiedSource("STRING", "(DEFCLASS STRING (LITERAL) :SYNONYMS (FILE-NAME) :CL-NATIVE-TYPE \"STRING\" :IDL-NATIVE-TYPE \"string\" :JAVA-NATIVE-TYPE \"String\" :CPP-NATIVE-TYPE \"char*\" :EQUALITY-TEST STRING-EQL? :INITIAL-VALUE (VERBATIM :COMMON-LISP \"STELLA::NULL-STRING\" :JAVA \"null\" :CPP \"NULL\"))");
      Stella.defineClassFromStringifiedSource("CHARACTER", "(DEFCLASS CHARACTER (LITERAL) :CL-NATIVE-TYPE \"CHARACTER\" :CPP-NATIVE-TYPE \"char\" :IDL-NATIVE-TYPE \"char\" :JAVA-NATIVE-TYPE \"char\" :INITIAL-VALUE NULL-CHARACTER)");
      Stella.defineClassFromStringifiedSource("SHORT-INTEGER", "(DEFCLASS SHORT-INTEGER (NUMBER) :CL-NATIVE-TYPE \"FIXNUM\" :CPP-NATIVE-TYPE \"short int\" :IDL-NATIVE-TYPE \"short int\" :JAVA-NATIVE-TYPE \"short\" :INITIAL-VALUE NULL-SHORT-INTEGER :EQUALITY-TEST EQL?)");
      Stella.defineClassFromStringifiedSource("LONG-INTEGER", "(DEFCLASS LONG-INTEGER (NUMBER) :CL-NATIVE-TYPE \"INTEGER\" :CPP-NATIVE-TYPE \"long long int\" :IDL-NATIVE-TYPE \"long int\" :JAVA-NATIVE-TYPE \"long\" :INITIAL-VALUE NULL-LONG-INTEGER :EQUALITY-TEST EQL?)");
      Stella.defineClassFromStringifiedSource("UNSIGNED-SHORT-INTEGER", "(DEFCLASS UNSIGNED-SHORT-INTEGER (NUMBER) :CL-NATIVE-TYPE \"INTEGER\" :CPP-NATIVE-TYPE \"unsigned short int\" :IDL-NATIVE-TYPE \"unsigned short int\" :JAVA-NATIVE-TYPE \"short\" :INITIAL-VALUE NULL-UNSIGNED-SHORT-INTEGER :EQUALITY-TEST EQL?)");
      Stella.defineClassFromStringifiedSource("UNSIGNED-LONG-INTEGER", "(DEFCLASS UNSIGNED-LONG-INTEGER (NUMBER) :CL-NATIVE-TYPE \"INTEGER\" :IDL-NATIVE-TYPE \"unsigned long int\" :CPP-NATIVE-TYPE \"unsigned long int\" :JAVA-NATIVE-TYPE \"long\" :INITIAL-VALUE NULL-UNSIGNED-LONG-INTEGER :EQUALITY-TEST EQL?)");
      Stella.defineClassFromStringifiedSource("SINGLE-FLOAT", "(DEFCLASS SINGLE-FLOAT (NUMBER) :CL-NATIVE-TYPE \"FLOAT\" :JAVA-NATIVE-TYPE \"float\" :IDL-NATIVE-TYPE \"float\" :CPP-NATIVE-TYPE \"float\" :INITIAL-VALUE NULL-SINGLE-FLOAT :EQUALITY-TEST EQL?)");
      Stella.defineClassFromStringifiedSource("DOUBLE-FLOAT", "(DEFCLASS DOUBLE-FLOAT (NUMBER) :CL-NATIVE-TYPE \"FLOAT\" :CPP-NATIVE-TYPE \"double\" :JAVA-NATIVE-TYPE \"double\" :IDL-NATIVE-TYPE \"double\" :INITIAL-VALUE NULL-DOUBLE-FLOAT :EQUALITY-TEST EQL?)");
    }
  }

  public static void startupHierarchy() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupHierarchy.helpStartupHierarchy1();
          _StartupHierarchy.helpStartupHierarchy2();
          _StartupHierarchy.helpStartupHierarchy3();
          _StartupHierarchy.helpStartupHierarchy4();
          _StartupHierarchy.helpStartupHierarchy5();
          _StartupHierarchy.helpStartupHierarchy6();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Stella.$HARDWIRED_TRANSIENTp_ON_TRANSIENT_MIXIN$ = false;
          Stella.$HARDWIRED_CLASS_ARITY_ON_CLASS$ = Stella.NULL_INTEGER;
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          _StartupHierarchy.helpStartupHierarchy7();
          _StartupHierarchy.helpStartupHierarchy8();
          Stella.defineClassFromStringifiedSource("BYTE", "(DEFCLASS BYTE (LITERAL) :CL-NATIVE-TYPE \"FIXNUM\" :CPP-NATIVE-TYPE \"char\" :IDL-NATIVE-TYPE \"char\" :JAVA-NATIVE-TYPE \"byte\" :INITIAL-VALUE NULL-BYTE :EQUALITY-TEST EQL?)");
          Stella.defineClassFromStringifiedSource("OCTET", "(DEFCLASS OCTET (BYTE) :CL-NATIVE-TYPE \"FIXNUM\" :CPP-NATIVE-TYPE \"char\" :IDL-NATIVE-TYPE \"octet\" :JAVA-NATIVE-TYPE \"byte\" :INITIAL-VALUE NULL-OCTET :EQUALITY-TEST EQL?)");
          Stella.defineClassFromStringifiedSource("WRAPPER", "(DEFCLASS WRAPPER (OBJECT) :PUBLIC-SLOTS ((WRAPPER-VALUE :TYPE UNKNOWN :REQUIRED? TRUE)) :KEY (WRAPPER-VALUE) :PUBLIC? TRUE :ABSTRACT? TRUE)");
          Stella.defineClassFromStringifiedSource("LITERAL-WRAPPER", "(DEFCLASS LITERAL-WRAPPER (WRAPPER) :ABSTRACT? TRUE)");
          Stella.defineClassFromStringifiedSource("NUMBER-WRAPPER", "(DEFCLASS NUMBER-WRAPPER (LITERAL-WRAPPER) :ABSTRACT? TRUE)");
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("INTEGER-WRAPPER", "(DEFCLASS INTEGER-WRAPPER (NUMBER-WRAPPER) :PUBLIC-SLOTS ((WRAPPER-VALUE :TYPE INTEGER)) :PRINT-FORM (LET ((VALUE (WRAPPER-VALUE SELF))) (IF (NULL? VALUE) (IF *PRINTREADABLY?* (PRINT-NATIVE-STREAM STREAM (QUOTE NULL-INTEGER)) (PRINT-NATIVE-STREAM STREAM \"|L|NULL-INTEGER\")) (IF *PRINTREADABLY?* (PRINT-NATIVE-STREAM STREAM VALUE) (PRINT-NATIVE-STREAM STREAM \"|L|\" VALUE)))))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.IntegerWrapper", "newIntegerWrapper", new java.lang.Class [] {java.lang.Integer.TYPE});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.IntegerWrapper", "accessIntegerWrapperSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("LONG-INTEGER-WRAPPER", "(DEFCLASS LONG-INTEGER-WRAPPER (NUMBER-WRAPPER) :SLOTS ((WRAPPER-VALUE :TYPE LONG-INTEGER)) :PRINT-FORM (LET ((VALUE (WRAPPER-VALUE SELF))) (IF (NULL? VALUE) (IF *PRINTREADABLY?* (PRINT-NATIVE-STREAM STREAM (QUOTE NULL-LONG-INTEGER)) (PRINT-NATIVE-STREAM STREAM \"|L|NULL-LONG-INTEGER\")) (IF *PRINTREADABLY?* (PRINT-NATIVE-STREAM STREAM VALUE) (PRINT-NATIVE-STREAM STREAM \"|L|\" VALUE)))))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.LongIntegerWrapper", "newLongIntegerWrapper", new java.lang.Class [] {java.lang.Long.TYPE});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.LongIntegerWrapper", "accessLongIntegerWrapperSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.LongIntegerWrapper"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("FLOAT-WRAPPER", "(DEFCLASS FLOAT-WRAPPER (NUMBER-WRAPPER) :PUBLIC-SLOTS ((WRAPPER-VALUE :TYPE FLOAT)) :PRINT-FORM (LET ((VALUE (WRAPPER-VALUE SELF))) (IF (NULL? VALUE) (IF *PRINTREADABLY?* (PRINT-NATIVE-STREAM STREAM (QUOTE NULL-FLOAT)) (PRINT-NATIVE-STREAM STREAM \"|L|NULL-FLOAT\")) (IF *PRINTREADABLY?* (PRINT-NATIVE-STREAM STREAM VALUE) (PRINT-NATIVE-STREAM STREAM \"|L|\" VALUE)))))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.FloatWrapper", "newFloatWrapper", new java.lang.Class [] {java.lang.Double.TYPE});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.FloatWrapper", "accessFloatWrapperSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.FloatWrapper"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("STRING-WRAPPER", "(DEFCLASS STRING-WRAPPER (LITERAL-WRAPPER) :PUBLIC-SLOTS ((WRAPPER-VALUE :TYPE STRING)) :PRINT-FORM (LET ((VALUE (WRAPPER-VALUE SELF))) (IF (NULL? VALUE) (IF *PRINTREADABLY?* (PRINT-NATIVE-STREAM STREAM (QUOTE NULL-STRING)) (PRINT-NATIVE-STREAM STREAM \"|L|NULL-STRING\")) (IF *PRINTREADABLY?* (PRINT-STRING-READABLY VALUE STREAM) (PRINT-NATIVE-STREAM STREAM \"|L|\" #\\\" VALUE #\\\")))))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.StringWrapper", "newStringWrapper", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.StringWrapper", "accessStringWrapperSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("MUTABLE-STRING-WRAPPER", "(DEFCLASS MUTABLE-STRING-WRAPPER (LITERAL-WRAPPER) :PUBLIC-SLOTS ((WRAPPER-VALUE :TYPE MUTABLE-STRING)) :PRINT-FORM (LET ((VALUE (WRAPPER-VALUE SELF))) (IF (NULL? VALUE) (IF *PRINTREADABLY?* (PRINT-NATIVE-STREAM STREAM (QUOTE NULL-MUTABLE-STRING)) (PRINT-NATIVE-STREAM STREAM \"|L|NULL-MUTABLE-STRING\")) (IF *PRINTREADABLY?* (PRINT-STRING-READABLY VALUE STREAM) (PRINT-NATIVE-STREAM STREAM \"|L|\" #\\\" (MUTABLE-STRING-TO-STRING VALUE) #\\\")))))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.MutableStringWrapper", "newMutableStringWrapper", new java.lang.Class [] {Native.find_java_class("java.lang.StringBuffer")});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CHARACTER-WRAPPER", "(DEFCLASS CHARACTER-WRAPPER (LITERAL-WRAPPER) :PUBLIC-SLOTS ((WRAPPER-VALUE :TYPE CHARACTER)) :PRINT-FORM (LET ((VALUE (WRAPPER-VALUE SELF))) (IF (NULL? VALUE) (IF *PRINTREADABLY?* (PRINT-NATIVE-STREAM STREAM (QUOTE NULL-CHARACTER)) (PRINT-NATIVE-STREAM STREAM \"|L|NULL-CHARACTER\")) (PROGN (UNLESS *PRINTREADABLY?* (PRINT-NATIVE-STREAM STREAM \"|L|\")) (PRINT-CHARACTER VALUE STREAM)))))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.CharacterWrapper", "newCharacterWrapper", new java.lang.Class [] {java.lang.Character.TYPE});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.CharacterWrapper", "accessCharacterWrapperSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.CharacterWrapper"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("BOOLEAN-WRAPPER", "(DEFCLASS BOOLEAN-WRAPPER (LITERAL-WRAPPER) :DOCUMENTATION \"Objectified version of the BOOLEAN data type.  The NULL\nvalue can be used for a 3-valued semantics (see THREE-VALUED-BOOLEAN).\" :PUBLIC-SLOTS ((WRAPPER-VALUE :TYPE BOOLEAN :ALLOCATION :INSTANCE)) :PRINT-FORM (PROGN (UNLESS *PRINTREADABLY?* (PRINT-NATIVE-STREAM STREAM \"|L|\")) (IF (WRAPPER-VALUE SELF) (PRINT-NATIVE-STREAM STREAM (QUOTE TRUE)) (PRINT-NATIVE-STREAM STREAM (QUOTE FALSE)))))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.BooleanWrapper", "newBooleanWrapper", new java.lang.Class [] {java.lang.Boolean.TYPE});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.BooleanWrapper", "accessBooleanWrapperSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.BooleanWrapper"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          Stella.defineClassFromStringifiedSource("CODE-WRAPPER", "(DEFCLASS CODE-WRAPPER (WRAPPER) :ABSTRACT? TRUE)");
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("FUNCTION-CODE-WRAPPER", "(DEFCLASS FUNCTION-CODE-WRAPPER (CODE-WRAPPER) :PUBLIC-SLOTS ((WRAPPER-VALUE :TYPE FUNCTION-CODE)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.FunctionCodeWrapper", "newFunctionCodeWrapper", new java.lang.Class [] {Native.find_java_class("java.lang.reflect.Method")});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.FunctionCodeWrapper", "accessFunctionCodeWrapperSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.FunctionCodeWrapper"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("METHOD-CODE-WRAPPER", "(DEFCLASS METHOD-CODE-WRAPPER (CODE-WRAPPER) :PUBLIC-SLOTS ((WRAPPER-VALUE :TYPE METHOD-CODE)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.MethodCodeWrapper", "newMethodCodeWrapper", new java.lang.Class [] {Native.find_java_class("java.lang.reflect.Method")});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.MethodCodeWrapper", "accessMethodCodeWrapperSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodCodeWrapper"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("VERBATIM-STRING-WRAPPER", "(DEFCLASS VERBATIM-STRING-WRAPPER (STRING-WRAPPER) :DOCUMENTATION \"Wrapper class used to hold verbatim native code strings.\" :PRINT-FORM (PRINT-NATIVE-STREAM STREAM (CHOOSE *PRINTREADABLY?* \"\" \"|V|\") (WRAPPER-VALUE SELF)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.VerbatimStringWrapper", "newVerbatimStringWrapper", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
          }
          Stella.defineClassFromStringifiedSource("BOOLEAN", "(DEFCLASS BOOLEAN (LITERAL) :DOCUMENTATION \"Boolean type with values TRUE and FALSE.\" :INITIAL-VALUE FALSE :CL-NATIVE-TYPE \"FIXNUM\" :CPP-NATIVE-TYPE \"boolean\" :IDL-NATIVE-TYPE \"boolean\" :JAVA-NATIVE-TYPE \"boolean\")");
          Stella.defineClassFromStringifiedSource("ONE-BIT-BOOLEAN", "(DEFCLASS ONE-BIT-BOOLEAN (BOOLEAN) :DOCUMENTATION \"Space-saving representation of BOOLEAN which takes longer\nto read and write than BOOLEAN.  Not yet implemented.\" :CPP-NATIVE-TYPE \"one_bit_boolean\")");
          Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE THREE-VALUED-BOOLEAN BOOLEAN-WRAPPER)");
          Stella.defineClassFromStringifiedSource("CODE", "(DEFCLASS CODE (LITERAL) :ABSTRACT? TRUE)");
          Stella.defineClassFromStringifiedSource("FUNCTION-CODE", "(DEFCLASS FUNCTION-CODE (CODE) :CL-NATIVE-TYPE \"FUNCTION\" :JAVA-NATIVE-TYPE \"java.lang.reflect.Method\" :CPP-NATIVE-TYPE \"cpp_function_code\")");
          Stella.defineClassFromStringifiedSource("METHOD-CODE", "(DEFCLASS METHOD-CODE (CODE) :CL-NATIVE-TYPE \"STANDARD-GENERIC-FUNCTION\" :JAVA-NATIVE-TYPE \"java.lang.reflect.Method\" :CPP-NATIVE-TYPE \"cpp_method_code\" :INITIAL-VALUE (SAFE-CAST NULL @METHOD-CODE))");
          Stella.defineClassFromStringifiedSource("LISP-CODE", "(DEFCLASS LISP-CODE () :ABSTRACT? TRUE :DOCUMENTATION \"Used to indicate variables that input or output Common Lisp~\n      structures.\")");
          Stella.defineClassFromStringifiedSource("THIRTY-TWO-BIT-VECTOR", "(DEFCLASS THIRTY-TWO-BIT-VECTOR (INTEGER) :CL-NATIVE-TYPE \"FIXNUM\" :CPP-NATIVE-TYPE \"long\" :JAVA-NATIVE-TYPE \"int\" :DOCUMENTATION \"Bit vector used to implement BOOLEAN slots.\" :INITIAL-VALUE NULL-INTEGER)");
          Stella.defineClassFromStringifiedSource("TICKTOCK", "(DEFCLASS TICKTOCK () :DOCUMENTATION \"A data type that is used to hold information for computing\ntiming of code.  It is intentionally opaque to the user.\nIt should only be used as an argument to the TICKTOCK-DIFFERENCE\nfunction.  Values are obtained with the GET-TICKTOCK function.\" :CPP-NATIVE-TYPE \"clock_t\" :CL-NATIVE-TYPE \"FIXNUM\" :JAVA-NATIVE-TYPE \"long\")");
          Stella.defineClassFromStringifiedSource("NATIVE-OBJECT-POINTER", "(DEFCLASS NATIVE-OBJECT-POINTER (SECOND-CLASS-OBJECT) :DOCUMENTATION \"A pointer type that can point at an arbitrary native\nnon-literal object.  Usable to store native objects that fall outside the\nSTELLA OBJECT hierarchy (e.g., native arrays) without having to use their\nexact type.\" :CL-NATIVE-TYPE \"T\" :CPP-NATIVE-TYPE \"void*\" :JAVA-NATIVE-TYPE \"Object\")");
          Stella.defineClassFromStringifiedSource("PROCESS-LOCK-OBJECT", "(DEFCLASS PROCESS-LOCK-OBJECT () :DOCUMENTATION \"A process lock object for synchronizing in a multi-threaded environment.\nFully supported in Java; supported in some Common Lisp systems; not supported\nin C++.\" :CL-NATIVE-TYPE \"T\" :CPP-NATIVE-TYPE \"void*\" :JAVA-NATIVE-TYPE \"Object\")");
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("SYSTEM-DEFINITION", "(DEFCLASS SYSTEM-DEFINITION (STANDARD-OBJECT) :DOCUMENTATION \"The System-Definition class is used to define systems of files\nthat constitute Stella applications.\" :SLOTS ((NAME :TYPE STRING) (DIRECTORY :TYPE FILE-NAME) (FILES :TYPE (CONS OF STRING-WRAPPER)) (LISP-ONLY-FILES :TYPE (CONS OF STRING-WRAPPER)) (CPP-ONLY-FILES :TYPE (CONS OF STRING-WRAPPER)) (JAVA-ONLY-FILES :TYPE (CONS OF STRING-WRAPPER)) (DATA-FILES :TYPE (CONS OF STRING-WRAPPER)) (PREPROCESSED-FILES :TYPE (CONS OF STRING-WRAPPER)) (REQUIRED-SYSTEMS :TYPE (CONS OF STRING-WRAPPER)) (LOADED? :TYPE BOOLEAN) (UP-TO-DATE? :TYPE BOOLEAN) (CARDINAL-MODULE :TYPE STRING) (SOURCE-ROOT-DIRECTORY :TYPE FILE-NAME) (NATIVE-ROOT-DIRECTORY :TYPE FILE-NAME) (BINARY-ROOT-DIRECTORY :TYPE FILE-NAME) (BANNER :TYPE STRING) (COPYRIGHT-HEADER :RENAMES BANNER) (PRODUCTION-SETTINGS :TYPE (CONS OF INTEGER-WRAPPER)) (DEVELOPMENT-SETTINGS :TYPE (CONS OF INTEGER-WRAPPER)) (FINALIZATION-FUNCTION :TYPE SYMBOL)) :PRINT-FORM (PRINT-NATIVE-STREAM STREAM \"|SYSTEM|\" (NAME SELF)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.SystemDefinition", "newSystemDefinition", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.SystemDefinition", "accessSystemDefinitionSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.SystemDefinition"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          Stella.defineClassFromStringifiedSource("ARGUMENT-LIST", "(DEFCLASS ARGUMENT-LIST () :PARAMETERS ((ANY-VALUE :TYPE UNKNOWN)) :PUBLIC-METHODS ((LENGTH ((SELF ARGUMENT-LIST)) :TYPE INTEGER :NATIVE? TRUE)) :METHODS ((ALLOCATE-ITERATOR ((SELF ARGUMENT-LIST)) :TYPE (ARGUMENT-LIST-ITERATOR OF (LIKE (ANY-VALUE SELF))) :NATIVE? TRUE)) :CL-NATIVE-TYPE \"CONS\" :CPP-NATIVE-TYPE \"void\" :JAVA-NATIVE-TYPE \"void\")");
          Stella.defineClassFromStringifiedSource("ARGUMENT-LIST-ITERATOR", "(DEFCLASS ARGUMENT-LIST-ITERATOR (ABSTRACT-ITERATOR) :PUBLIC-SLOTS ((VALUE :READER ARGUMENT)) :METHODS ((ARGUMENT ((SELF ARGUMENT-LIST-ITERATOR)) :TYPE (LIKE (ANY-VALUE SELF)) :NATIVE? TRUE) (NEXT? ((SELF ARGUMENT-LIST-ITERATOR)) :TYPE BOOLEAN :NATIVE? TRUE)) :CL-NATIVE-TYPE \"CONS\" :CPP-NATIVE-TYPE \"va_list\" :JAVA-NATIVE-TYPE \"void\")");
          Stella.defineClassFromStringifiedSource("NATIVE-STREAM", "(DEFCLASS NATIVE-STREAM () :ABSTRACT? TRUE :CPP-NATIVE-TYPE \"std::ios*\" :JAVA-NATIVE-TYPE \"Object\" :CL-NATIVE-TYPE \"STREAM\")");
          Stella.defineClassFromStringifiedSource("NATIVE-OUTPUT-STREAM", "(DEFCLASS NATIVE-OUTPUT-STREAM (NATIVE-STREAM) :ABSTRACT? TRUE :CPP-NATIVE-TYPE \"std::ostream*\" :JAVA-NATIVE-TYPE \"edu.isi.stella.javalib.NativeOutputStream\" :CL-NATIVE-TYPE \"STREAM\")");
          Stella.defineClassFromStringifiedSource("NATIVE-INPUT-STREAM", "(DEFCLASS NATIVE-INPUT-STREAM (NATIVE-STREAM) :ABSTRACT? TRUE :CPP-NATIVE-TYPE \"std::istream*\" :JAVA-NATIVE-TYPE \"edu.isi.stella.javalib.NativeInputStream\" :CL-NATIVE-TYPE \"STREAM\")");
          Stella.defineClassFromStringifiedSource("NATIVE-CHARSET-ENCODING", "(DEFCLASS NATIVE-CHARSET-ENCODING () :DOCUMENTATION \"Specifies a native character set encoding for proper byte-to-char translation\nfor implementations where we need that.  See also STELLA-CHARSET in streams.ste.\" :CPP-NATIVE-TYPE \"void*\" :JAVA-NATIVE-TYPE \"java.nio.charset.Charset\" :CL-NATIVE-TYPE \"T\")");
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("STREAM", "(DEFCLASS STREAM (STANDARD-OBJECT) :ABSTRACT? TRUE :PUBLIC-SLOTS ((STATE :TYPE KEYWORD)))");

            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.Stream", "accessStreamSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stream"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("OUTPUT-STREAM", "(DEFCLASS OUTPUT-STREAM (STREAM) :PUBLIC-SLOTS ((NATIVE-STREAM :TYPE NATIVE-OUTPUT-STREAM :PUBLIC? TRUE) (NATIVE-OUTPUT-STREAM :RENAMES NATIVE-STREAM)) :TERMINATOR TERMINATE-OUTPUT-STREAM?)");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.OutputStream", "newOutputStream", new java.lang.Class [] {});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("INPUT-STREAM", "(DEFCLASS INPUT-STREAM (STREAM) :PUBLIC-SLOTS ((NATIVE-STREAM :TYPE NATIVE-INPUT-STREAM :PUBLIC? TRUE) (NATIVE-INPUT-STREAM :RENAMES NATIVE-STREAM) (ECHO-STREAM :TYPE OUTPUT-STREAM) (TOKENIZER-STATE :TYPE TOKENIZER-STREAM-STATE) (BUFFERING-SCHEME :TYPE KEYWORD :INITIALLY :LINE :DOCUMENTATION \"One of :CHARACTER, :LINE or :BLOCK indicating what kind of\ninput buffer we are reading from.  This determines what read function to use\nfor tokenization.\")) :TERMINATOR TERMINATE-INPUT-STREAM?)");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.InputStream", "newInputStream", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.InputStream", "accessInputStreamSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.InputStream"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("OUTPUT-FILE-STREAM", "(DEFCLASS OUTPUT-FILE-STREAM (OUTPUT-STREAM) :SYNONYMS (FILE-OUTPUT-STREAM) :PUBLIC-SLOTS ((FILENAME :TYPE STRING :REQUIRED? TRUE :PUBLIC? TRUE) (IF-EXISTS-ACTION :TYPE KEYWORD :INITIALLY :SUPERSEDE :PUBLIC? TRUE) (IF-NOT-EXISTS-ACTION :TYPE KEYWORD :INITIALLY :CREATE :PUBLIC? TRUE)) :INITIALIZER INITIALIZE-FILE-OUTPUT-STREAM :TERMINATOR TERMINATE-FILE-OUTPUT-STREAM? :PRINT-FORM (PRINT-NATIVE-STREAM STREAM \"|FOS|'\" (FILENAME SELF) \"'\"))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.OutputFileStream", "newOutputFileStream", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.OutputFileStream", "accessOutputFileStreamSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputFileStream"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("INPUT-FILE-STREAM", "(DEFCLASS INPUT-FILE-STREAM (INPUT-STREAM) :SYNONYMS (FILE-INPUT-STREAM) :PUBLIC-SLOTS ((FILENAME :TYPE STRING :REQUIRED? TRUE :PUBLIC? TRUE) (IF-NOT-EXISTS-ACTION :TYPE KEYWORD :INITIALLY :ERROR :PUBLIC? TRUE) (BUFFERING-SCHEME :INITIALLY :BLOCK)) :INITIALIZER INITIALIZE-FILE-INPUT-STREAM :TERMINATOR TERMINATE-FILE-INPUT-STREAM? :PRINT-FORM (PRINT-NATIVE-STREAM STREAM \"|FIS|'\" (FILENAME SELF) \"'\"))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.InputFileStream", "newInputFileStream", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.InputFileStream", "accessInputFileStreamSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.InputFileStream"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("OUTPUT-STRING-STREAM", "(DEFCLASS OUTPUT-STRING-STREAM (OUTPUT-STREAM) :SYNONYMS (STRING-OUTPUT-STREAM) :PUBLIC-SLOTS ((THE-STRING :TYPE STRING :PUBLIC? TRUE :READER THE-STRING-READER)) :TERMINATOR TERMINATE-STRING-OUTPUT-STREAM? :INITIALIZER INITIALIZE-STRING-OUTPUT-STREAM)");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.OutputStringStream", "newOutputStringStream", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.OutputStringStream", "accessOutputStringStreamSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStringStream"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("INPUT-STRING-STREAM", "(DEFCLASS INPUT-STRING-STREAM (INPUT-STREAM) :SYNONYMS (STRING-INPUT-STREAM) :PUBLIC-SLOTS ((THE-STRING :TYPE STRING :REQUIRED? TRUE :PUBLIC? TRUE) (BUFFERING-SCHEME :INITIALLY :BLOCK)) :TERMINATOR TERMINATE-STRING-INPUT-STREAM? :INITIALIZER INITIALIZE-STRING-INPUT-STREAM)");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.InputStringStream", "newInputStringStream", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.InputStringStream", "accessInputStringStreamSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.InputStringStream"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineMethodObject("(DEFMETHOD (TRANSIENT? BOOLEAN) ((SELF TRANSIENT-MIXIN)) :AUXILIARY? TRUE (RETURN *HARDWIRED-TRANSIENT?-ON-TRANSIENT-MIXIN*))", ((java.lang.reflect.Method)(null)), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (BAD? BOOLEAN-WRAPPER) ((SELF DYNAMIC-SLOTS-MIXIN)) :AUXILIARY? TRUE (LET ((ANSWER (SLOT-VALUE SELF BAD?))) (IF (NULL? ANSWER) (RETURN FALSE) (RETURN ANSWER))))", ((java.lang.reflect.Method)(null)), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("STARTUP-HIERARCHY", "(DEFUN STARTUP-HIERARCHY () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupHierarchy", "startupHierarchy", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_HIERARCHY);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupHierarchy"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
