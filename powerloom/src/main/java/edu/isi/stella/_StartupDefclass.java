//  -*- Mode: Java -*-
//
// _StartupDefclass.java

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

public class _StartupDefclass {
  static void helpStartupDefclass1() {
    {
      Stella.SGT_STELLA_LITERAL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("LITERAL", null, 1)));
      Stella.SGT_STELLA_SECOND_CLASS_OBJECT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SECOND-CLASS-OBJECT", null, 1)));
      Stella.SYM_STELLA_DEFINE_CLASS_FROM_STRINGIFIED_SOURCE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFINE-CLASS-FROM-STRINGIFIED-SOURCE", null, 0)));
      Stella.KWD_IDL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("IDL", null, 2)));
      Stella.KWD_CPP_STANDALONE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP-STANDALONE", null, 2)));
      Stella.SGT_STELLA_NON_OBJECT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("NON-OBJECT", null, 1)));
      Stella.SGT_STELLA_NATIVE_EXCEPTION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("NATIVE-EXCEPTION", null, 1)));
      Stella.SYM_STELLA_NEXT_SWEEP_LIST_OBJECT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NEXT-SWEEP-LIST-OBJECT", null, 0)));
      Stella.KWD_FREE_LIST = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FREE-LIST", null, 2)));
      Stella.KWD_FREE_AND_SWEEP_LIST = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FREE-AND-SWEEP-LIST", null, 2)));
      Stella.KWD_SWEEP_LIST = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SWEEP-LIST", null, 2)));
      Stella.KWD_USE_COMMON_LISP_STRUCTS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("USE-COMMON-LISP-STRUCTS", null, 2)));
      Stella.KWD_USE_COMMON_LISP_VECTOR_STRUCTS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("USE-COMMON-LISP-VECTOR-STRUCTS", null, 2)));
      Stella.SYM_STELLA_DEFGLOBAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFGLOBAL", null, 0)));
      Stella.SYM_STELLA_RECYCLE_LIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RECYCLE-LIST", null, 0)));
      Stella.SYM_STELLA_CREATE_RECYCLE_LIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CREATE-RECYCLE-LIST", null, 0)));
      Stella.SYM_STELLA_MAKE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MAKE", null, 0)));
      Stella.SYM_STELLA_DYNAMIC_SLOTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DYNAMIC-SLOTS", null, 0)));
      Stella.SYM_STELLA_CLEAR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLEAR", null, 0)));
      Stella.KWD_FORCE_NULL_VALUE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FORCE-NULL-VALUE", null, 2)));
      Stella.KWD_NULL_VALUE_ONLY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL-VALUE-ONLY", null, 2)));
      Stella.SYM_STELLA_AND = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("AND", null, 0)));
      Stella.SYM_STELLA_$RECYCLING_ENABLEDp$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("*RECYCLING-ENABLED?*", null, 0)));
      Stella.SYM_STELLA_COND = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COND", null, 0)));
      Stella.SYM_STELLA___ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("--", null, 0)));
      Stella.SYM_STELLA_OTHERWISE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OTHERWISE", null, 0)));
      Stella.SYM_STELLA_POP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("POP", null, 0)));
      Stella.SYM_STELLA_SETF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SETF", null, 0)));
      Stella.SYM_STELLA_ii = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("++", null, 0)));
      Stella.SYM_STELLA_e = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("=", null, 0)));
      Stella.SYM_STELLA_$RECYCLE_LISTS_MAINTENANCE_TIMER$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("*RECYCLE-LISTS-MAINTENANCE-TIMER*", null, 0)));
      Stella.SYM_STELLA_MAINTAIN_RECYCLE_LISTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MAINTAIN-RECYCLE-LISTS", null, 0)));
      Stella.KWD_INITIAL_VALUE_ONLY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INITIAL-VALUE-ONLY", null, 2)));
      Stella.KWD_ANY_INITIAL_VALUE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ANY-INITIAL-VALUE", null, 2)));
      Stella.SYM_STELLA_RUN_CONSTRUCTOR_DEMONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RUN-CONSTRUCTOR-DEMONS", null, 0)));
      Stella.SYM_STELLA_DEFUN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFUN", null, 0)));
      Stella.SYM_STELLA_MESSAGE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MESSAGE", null, 0)));
      Stella.SYM_STELLA_DEFMETHOD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFMETHOD", null, 0)));
      Stella.SYM_STELLA_PUSH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PUSH", null, 0)));
      Stella.SYM_STELLA_SWEEP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SWEEP", null, 0)));
      Stella.SYM_STELLA_UNUSED = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UNUSED", null, 0)));
      Stella.SYM_STELLA_WHILE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WHILE", null, 0)));
      Stella.SYM_STELLA_EQLp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EQL?", null, 0)));
      Stella.SYM_STELLA_UNMAKE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UNMAKE", null, 0)));
      Stella.SGT_STELLA_TRANSIENT_MIXIN = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TRANSIENT-MIXIN", null, 1)));
      Stella.SYM_STELLA_RECYCLE_LIST_DEBUGGING_ENABLEDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RECYCLE-LIST-DEBUGGING-ENABLED?", null, 0)));
      Stella.SYM_STELLA_REGISTER_RECYCLED_ITEM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("REGISTER-RECYCLED-ITEM", null, 0)));
      Stella.SYM_STELLA_UNREGISTER_RECYCLED_ITEM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UNREGISTER-RECYCLED-ITEM", null, 0)));
      Stella.SYM_STELLA_INLINE_WRAP_BOOLEAN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INLINE-WRAP-BOOLEAN", null, 0)));
      Stella.SYM_STELLA_ANSWER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ANSWER", null, 0)));
      Stella.SYM_STELLA_NULLp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL?", null, 0)));
      Stella.SYM_STELLA_ERROR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ERROR", null, 0)));
      Stella.SYM_STELLA_CAST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CAST", null, 0)));
      Stella.SYM_STELLA_SETVALUEp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SETVALUE?", null, 0)));
      Stella.SYM_STELLA_SLOTNAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOTNAME", null, 0)));
      Stella.SYM_STELLA_QUOTE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("QUOTE", null, 0)));
      Stella.SYM_STELLA_CASE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CASE", null, 0)));
      Stella.SYM_STELLA_SET_DYNAMIC_SLOT_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SET-DYNAMIC-SLOT-VALUE", null, 0)));
      Stella.SYM_STELLA_LOOKUP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LOOKUP", null, 0)));
      Stella.SYM_STELLA_OBJECT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OBJECT", null, 0)));
    }
  }

  static void helpStartupDefclass2() {
    {
      Stella.SYM_STELLA_SYMBOL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SYMBOL", null, 0)));
      Stella.SYM_STELLA_BOOLEAN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BOOLEAN", null, 0)));
      Stella.SYM_STELLA_TYPECASE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TYPECASE", null, 0)));
      Stella.SYM_STELLA_EQp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EQ?", null, 0)));
      Stella.SYM_STELLA_OTHER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OTHER", null, 0)));
      Stella.SYM_STELLA_EQUAL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EQUAL", null, 0)));
      Stella.SYM_STELLA_STARTUP_DEFCLASS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-DEFCLASS", null, 0)));
    }
  }

  static void helpStartupDefclass3() {
    {
      Stella.defineFunctionObject("TYPE-TO-NULL-VALUE-TREE", "(DEFUN (TYPE-TO-NULL-VALUE-TREE OBJECT) ((TYPE TYPE)))", Native.find_java_method("edu.isi.stella.Surrogate", "typeToNullValueTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("TYPE-TO-WALKED-NULL-VALUE-TREE", "(DEFUN (TYPE-TO-WALKED-NULL-VALUE-TREE OBJECT) ((TYPESPEC TYPE-SPEC) (TYPE TYPE)))", Native.find_java_method("edu.isi.stella.StandardObject", "typeToWalkedNullValueTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("YIELD-CONS-LIST-FROM-SEQUENCE", "(DEFUN (YIELD-CONS-LIST-FROM-SEQUENCE CONS) ((SEQUENCE SEQUENCE)))", Native.find_java_method("edu.isi.stella.Sequence", "yieldConsListFromSequence", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Sequence")}), null);
      Stella.defineFunctionObject("YIELD-DEFINE-STELLA-CLASS", "(DEFUN (YIELD-DEFINE-STELLA-CLASS CONS) ((CLASS CLASS)) :DOCUMENTATION \"Return a cons tree that (when evaluated) constructs\na Stella class object.\")", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldDefineStellaClass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("CREATE-NATIVE-CLASS?", "(DEFUN (CREATE-NATIVE-CLASS? BOOLEAN) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "createNativeClassP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("EXCEPTION-CLASS?", "(DEFUN (EXCEPTION-CLASS? BOOLEAN) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "exceptionClassP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("WARN-ABOUT-MULTIPLE-PARENTS", "(DEFUN WARN-ABOUT-MULTIPLE-PARENTS ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "warnAboutMultipleParents", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("WARN-ABOUT-NON-DIRECT-SUPERS", "(DEFUN WARN-ABOUT-NON-DIRECT-SUPERS ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "warnAboutNonDirectSupers", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("SPACE-SAVER-SLOT-ALLOCATION?", "(DEFUN (SPACE-SAVER-SLOT-ALLOCATION? BOOLEAN) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "spaceSaverSlotAllocationP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("DYNAMIC-SLOT?", "(DEFUN (DYNAMIC-SLOT? BOOLEAN) ((SLOT STORAGE-SLOT)) :GLOBALLY-INLINE? TRUE (RETURN (EQL? (ALLOCATION SLOT) :DYNAMIC)))", Native.find_java_method("edu.isi.stella.StorageSlot", "dynamicSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("CLASS-SLOT?", "(DEFUN (CLASS-SLOT? BOOLEAN) ((SLOT STORAGE-SLOT)) :GLOBALLY-INLINE? TRUE (RETURN (EQL? (ALLOCATION SLOT) :CLASS)))", Native.find_java_method("edu.isi.stella.StorageSlot", "classSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("REDUNDANT-SLOT?", "(DEFUN (REDUNDANT-SLOT? BOOLEAN) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "redundantSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("NATIVE-SLOT?", "(DEFUN (NATIVE-SLOT? BOOLEAN) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "nativeSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("PARAMETER-SLOT?", "(DEFUN (PARAMETER-SLOT? BOOLEAN) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "parameterSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("NATIVE-METHOD?", "(DEFUN (NATIVE-METHOD? BOOLEAN) ((SLOT METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "nativeMethodP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("MIXIN-SLOT?", "(DEFUN (MIXIN-SLOT? BOOLEAN) ((SELF SLOT)))", Native.find_java_method("edu.isi.stella.Slot", "mixinSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), null);
      Stella.defineFunctionObject("MIXIN-METHOD?", "(DEFUN (MIXIN-METHOD? BOOLEAN) ((SELF SLOT)))", Native.find_java_method("edu.isi.stella.Slot", "mixinMethodP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), null);
      Stella.defineFunctionObject("CANONICAL-SLOT", "(DEFUN (CANONICAL-SLOT STORAGE-SLOT) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "canonicalSlot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("UNKNOWN-TYPE?", "(DEFUN (UNKNOWN-TYPE? BOOLEAN) ((TYPE TYPE)))", Native.find_java_method("edu.isi.stella.Surrogate", "unknownTypeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("SLOT-HAS-UNKNOWN-TYPE?", "(DEFUN (SLOT-HAS-UNKNOWN-TYPE? BOOLEAN) ((SLOT STORAGE-SLOT) (CLASS CLASS)))", Native.find_java_method("edu.isi.stella.StorageSlot", "slotHasUnknownTypeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("NATIVE-STORAGE-SLOT-HOME", "(DEFUN (NATIVE-STORAGE-SLOT-HOME CLASS) ((SLOT STORAGE-SLOT) (CLASS CLASS)))", Native.find_java_method("edu.isi.stella.StorageSlot", "nativeStorageSlotHome", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("NATIVE-SLOT-HOME", "(DEFUN (NATIVE-SLOT-HOME CLASS) ((SLOT SLOT) (CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Slot", "nativeSlotHome", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("SLOT-NAME-CONFLICT?", "(DEFUN (SLOT-NAME-CONFLICT? BOOLEAN) ((SLOT SLOT) (CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Slot", "slotNameConflictP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("METHOD-CONTAINS-UNKNOWN-TYPE?", "(DEFUN (METHOD-CONTAINS-UNKNOWN-TYPE? BOOLEAN) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "methodContainsUnknownTypeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("METHOD-CONTAINS-ANCHORED-TYPE?", "(DEFUN (METHOD-CONTAINS-ANCHORED-TYPE? BOOLEAN) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "methodContainsAnchoredTypeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("YIELD-RECYCLE-LIST-NAME", "(DEFUN (YIELD-RECYCLE-LIST-NAME SYMBOL) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldRecycleListName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("RECYCLE-SLOT", "(DEFUN (RECYCLE-SLOT STORAGE-SLOT) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "recycleSlot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("USE-FREE-LIST?", "(DEFUN (USE-FREE-LIST? BOOLEAN) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "useFreeListP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("USE-SWEEP-LIST?", "(DEFUN (USE-SWEEP-LIST? BOOLEAN) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "useSweepListP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("DECIDED-TO-RECYCLE?", "(DEFUN (DECIDED-TO-RECYCLE? BOOLEAN) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "decidedToRecycleP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("COMPUTE-RECYCLED-ITEM-SIZE", "(DEFUN (COMPUTE-RECYCLED-ITEM-SIZE INTEGER) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "computeRecycledItemSize", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-RECYCLE-LIST-DEFINITIONS", "(DEFUN (YIELD-RECYCLE-LIST-DEFINITIONS CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldRecycleListDefinitions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-MAKE-TREES", "(DEFUN (YIELD-MAKE-TREES CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldMakeTrees", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-CONSTRUCTOR-NAME", "(DEFUN (YIELD-CONSTRUCTOR-NAME SYMBOL) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldConstructorName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-CREATION-TREES", "(DEFUN (YIELD-CREATION-TREES CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldCreationTrees", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-TERMINATE-OBJECT-TREES", "(DEFUN (YIELD-TERMINATE-OBJECT-TREES CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldTerminateObjectTrees", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-CREATION-OR-REUSE-TREES", "(DEFUN (YIELD-CREATION-OR-REUSE-TREES CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldCreationOrReuseTrees", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-CREATION-OR-REUSE-TREES-FROM-FREE-LIST", "(DEFUN (YIELD-CREATION-OR-REUSE-TREES-FROM-FREE-LIST CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldCreationOrReuseTreesFromFreeList", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-CREATION-OR-REUSE-TREES-FROM-SWEEP-LIST", "(DEFUN (YIELD-CREATION-OR-REUSE-TREES-FROM-SWEEP-LIST CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldCreationOrReuseTreesFromSweepList", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-CREATION-OR-REUSE-TREES-FROM-FREE-OR-SWEEP-LIST", "(DEFUN (YIELD-CREATION-OR-REUSE-TREES-FROM-FREE-OR-SWEEP-LIST CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldCreationOrReuseTreesFromFreeOrSweepList", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("MARK-DIRECT-EQUIVALENT-SLOT", "(DEFUN MARK-DIRECT-EQUIVALENT-SLOT ((SLOT SLOT)))", Native.find_java_method("edu.isi.stella.Slot", "markDirectEquivalentSlot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), null);
      Stella.defineFunctionObject("IS-CONTEXT-SENSITIVE-SLOT?", "(DEFUN (IS-CONTEXT-SENSITIVE-SLOT? BOOLEAN) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "isContextSensitiveSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("YIELD-INITIAL-VALUE-ASSIGNMENT", "(DEFUN (YIELD-INITIAL-VALUE-ASSIGNMENT CONS) ((SLOT STORAGE-SLOT) (MODE KEYWORD)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldInitialValueAssignment", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("YIELD-INITIAL-VALUE-ASSIGNMENTS", "(DEFUN (YIELD-INITIAL-VALUE-ASSIGNMENTS CONS) ((CLASS CLASS) (MODE KEYWORD)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldInitialValueAssignments", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("YIELD-LOCAL-INITIAL-VALUE-ASSIGNMENTS", "(DEFUN (YIELD-LOCAL-INITIAL-VALUE-ASSIGNMENTS CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldLocalInitialValueAssignments", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-INITIALIZER-TREES", "(DEFUN (YIELD-INITIALIZER-TREES CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldInitializerTrees", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-CONSTRUCTOR-BODY", "(DEFUN (YIELD-CONSTRUCTOR-BODY CONS) ((CLASS CLASS) (REQUIREDASSIGNMENTS CONS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldConstructorBody", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("YIELD-CONSTRUCTOR-DEFINITION", "(DEFUN (YIELD-CONSTRUCTOR-DEFINITION CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldConstructorDefinition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-EXCEPTION-CONSTRUCTOR-BODY", "(DEFUN (YIELD-EXCEPTION-CONSTRUCTOR-BODY CONS) ((CLASS CLASS) (MESSAGEPARAMETER SYMBOL) (REQUIREDASSIGNMENTS CONS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldExceptionConstructorBody", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("YIELD-EXCEPTION-CONSTRUCTOR-DEFINITION", "(DEFUN (YIELD-EXCEPTION-CONSTRUCTOR-DEFINITION CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldExceptionConstructorDefinition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-DESTRUCTOR-DEFINITIONS", "(DEFUN (YIELD-DESTRUCTOR-DEFINITIONS CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldDestructorDefinitions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("CREATE-CONSTRUCTOR-AND-DESTRUCTOR-UNITS", "(DEFUN CREATE-CONSTRUCTOR-AND-DESTRUCTOR-UNITS ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "createConstructorAndDestructorUnits", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("PARAMETERIZED-CLASS?", "(DEFUN (PARAMETERIZED-CLASS? BOOLEAN) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "parameterizedClassP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("CLASS-WITH-INITIALIZER?", "(DEFUN (CLASS-WITH-INITIALIZER? BOOLEAN) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "classWithInitializerP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-INITIALIZER-NAME", "(DEFUN (YIELD-INITIALIZER-NAME SYMBOL) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldInitializerName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-INITIALIZER-DEFINITION", "(DEFUN (YIELD-INITIALIZER-DEFINITION CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldInitializerDefinition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("CREATE-CPP-CONSTRUCTOR-UNIT", "(DEFUN CREATE-CPP-CONSTRUCTOR-UNIT ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "createCppConstructorUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("CPP-CONSTRUCTOR?", "(DEFUN (CPP-CONSTRUCTOR? BOOLEAN) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "cppConstructorP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("CREATE-RECYCLE-LIST", "(DEFUN (CREATE-RECYCLE-LIST RECYCLE-LIST) ((CLASSTYPE TYPE) (ITEMSIZE INTEGER)))", Native.find_java_method("edu.isi.stella.Surrogate", "createRecycleList", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("CLEAR-RECYCLE-LIST", "(DEFUN CLEAR-RECYCLE-LIST ((LIST RECYCLE-LIST)) :DOCUMENTATION \"Reset `list' to its empty state.\")", Native.find_java_method("edu.isi.stella.RecycleList", "clearRecycleList", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.RecycleList")}), null);
    }
  }

  static void helpStartupDefclass4() {
    {
      Stella.defineFunctionObject("CLEAR-RECYCLE-LISTS", "(DEFUN CLEAR-RECYCLE-LISTS () :DOCUMENTATION \"Reset all currently active recycle lists to their empty state.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "clearRecycleLists", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("PRINT-RECYCLE-LISTS", "(DEFUN PRINT-RECYCLE-LISTS () :DOCUMENTATION \"Print the current state of all recycle lists.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "printRecycleLists", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("MAINTAIN-RECYCLE-LISTS", "(DEFUN MAINTAIN-RECYCLE-LISTS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "maintainRecycleLists", new java.lang.Class [] {}), null);
      Stella.defineMethodObject("(DEFMETHOD (DELETED? BOOLEAN) ((SELF RECYCLE-LIST)))", Native.find_java_method("edu.isi.stella.RecycleList", "deletedP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (DELETED?-SETTER BOOLEAN) ((SELF RECYCLE-LIST) (VALUE BOOLEAN)))", Native.find_java_method("edu.isi.stella.RecycleList", "deletedPSetter", new java.lang.Class [] {java.lang.Boolean.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("RECYCLE-LIST-SIZE", "(DEFUN (RECYCLE-LIST-SIZE INTEGER) ((LIST RECYCLE-LIST)) :GLOBALLY-INLINE? TRUE (RETURN (* (ITEM-SIZE LIST) (CURRENT-LENGTH LIST))))", Native.find_java_method("edu.isi.stella.RecycleList", "recycleListSize", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.RecycleList")}), null);
      Stella.defineFunctionObject("TOTAL-RECYCLE-LISTS-SIZE", "(DEFUN (TOTAL-RECYCLE-LISTS-SIZE INTEGER) ())", Native.find_java_method("edu.isi.stella.Stella", "totalRecycleListsSize", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("RECYCLE-LIST-SIZE<", "(DEFUN (RECYCLE-LIST-SIZE< BOOLEAN) ((LIST1 RECYCLE-LIST) (LIST2 RECYCLE-LIST)))", Native.find_java_method("edu.isi.stella.RecycleList", "recycleListSizeL", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.RecycleList"), Native.find_java_class("edu.isi.stella.RecycleList")}), null);
      Stella.defineFunctionObject("REDUCE-RECYCLE-LIST-SIZE", "(DEFUN REDUCE-RECYCLE-LIST-SIZE ((LIST RECYCLE-LIST) (FRACTION FLOAT)))", Native.find_java_method("edu.isi.stella.RecycleList", "reduceRecycleListSize", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.RecycleList"), java.lang.Double.TYPE}), null);
      Stella.defineMethodObject("(DEFMETHOD SWEEP ((SELF OBJECT)) :DOCUMENTATION \"Default method.  Sweep up all `self'-type objects.\")", Native.find_java_method("edu.isi.stella.Stella_Object", "sweep", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("SWEEP-TRANSIENTS", "(DEFUN SWEEP-TRANSIENTS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "sweepTransients", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("MAKE-NON-RECYCLED-LIST", "(DEFUN (MAKE-NON-RECYCLED-LIST LIST) ())", Native.find_java_method("edu.isi.stella.Stella", "makeNonRecycledList", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("REGISTER-RECYCLED-ITEM", "(DEFUN REGISTER-RECYCLED-ITEM ((ITEM OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "registerRecycledItem", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("UNREGISTER-RECYCLED-ITEM", "(DEFUN UNREGISTER-RECYCLED-ITEM ((ITEM OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "unregisterRecycledItem", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("START-RECYCLE-LIST-DEBUGGING", "(DEFUN START-RECYCLE-LIST-DEBUGGING ())", Native.find_java_method("edu.isi.stella.Stella", "startRecycleListDebugging", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("STOP-RECYCLE-LIST-DEBUGGING", "(DEFUN STOP-RECYCLE-LIST-DEBUGGING ())", Native.find_java_method("edu.isi.stella.Stella", "stopRecycleListDebugging", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("RECYCLE-LIST-DEBUGGING-ENABLED?", "(DEFUN (RECYCLE-LIST-DEBUGGING-ENABLED? BOOLEAN) () :GLOBALLY-INLINE? TRUE (RETURN (DEFINED? *CURRENTLY-RECYCLED-ITEMS*)))", Native.find_java_method("edu.isi.stella.Stella", "recycleListDebuggingEnabledP", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("TRANSLATE-WITH-RECYCLE-LIST-DEBUGGING?", "(DEFUN (TRANSLATE-WITH-RECYCLE-LIST-DEBUGGING? BOOLEAN) () :GLOBALLY-INLINE? TRUE (RETURN *TRANSLATE-WITH-RECYCLE-LIST-DEBUGGING?*))", Native.find_java_method("edu.isi.stella.Stella", "translateWithRecycleListDebuggingP", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("YIELD-REGISTER-RECYCLED-ITEM-TREES", "(DEFUN (YIELD-REGISTER-RECYCLED-ITEM-TREES CONS) ())", Native.find_java_method("edu.isi.stella.Stella", "yieldRegisterRecycledItemTrees", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("YIELD-UNREGISTER-RECYCLED-ITEM-TREES", "(DEFUN (YIELD-UNREGISTER-RECYCLED-ITEM-TREES CONS) ())", Native.find_java_method("edu.isi.stella.Stella", "yieldUnregisterRecycledItemTrees", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("HAS-NON-NULL-DEFAULT-VALUE?", "(DEFUN (HAS-NON-NULL-DEFAULT-VALUE? BOOLEAN) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "hasNonNullDefaultValueP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("SYSTEM-DEFINED-SLOT-READER?", "(DEFUN (SYSTEM-DEFINED-SLOT-READER? BOOLEAN) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "systemDefinedSlotReaderP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("SYSTEM-DEFINED-SLOT-WRITER?", "(DEFUN (SYSTEM-DEFINED-SLOT-WRITER? BOOLEAN) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "systemDefinedSlotWriterP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("YIELD-SLOT-TYPE-TREE", "(DEFUN (YIELD-SLOT-TYPE-TREE OBJECT) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldSlotTypeTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("YIELD-HARDWIRED-SLOT-VARIABLE", "(DEFUN (YIELD-HARDWIRED-SLOT-VARIABLE SYMBOL) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldHardwiredSlotVariable", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("YIELD-HARDWIRED-SLOT-READER-BODY", "(DEFUN (YIELD-HARDWIRED-SLOT-READER-BODY CONS CONS) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldHardwiredSlotReaderBody", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("FINALIZE-AUXILIARY-METHOD", "(DEFUN FINALIZE-AUXILIARY-METHOD ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "finalizeAuxiliaryMethod", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("WRAP-WITH-DEFAULT-VALUE-AND-RETURN-CODE", "(DEFUN (WRAP-WITH-DEFAULT-VALUE-AND-RETURN-CODE CONS) ((SLOT STORAGE-SLOT) (DEFAULTEXPRESSION OBJECT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "wrapWithDefaultValueAndReturnCode", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("YIELD-SLOT-READER-TREE", "(DEFUN (YIELD-SLOT-READER-TREE CONS) ((SLOT STORAGE-SLOT) (CLASS CLASS)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldSlotReaderTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-SLOT-WRITER-TREE", "(DEFUN (YIELD-SLOT-WRITER-TREE CONS) ((SLOT STORAGE-SLOT) (CLASS CLASS)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldSlotWriterTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("SLOT-VALUE-IS-BARE-LITERAL?", "(DEFUN (SLOT-VALUE-IS-BARE-LITERAL? BOOLEAN) ((SLOT SLOT)))", Native.find_java_method("edu.isi.stella.Slot", "slotValueIsBareLiteralP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), null);
      Stella.defineFunctionObject("GENERICALLY-ACCESSIBLE-TYPE?", "(DEFUN (GENERICALLY-ACCESSIBLE-TYPE? BOOLEAN) ((TYPE TYPE)))", Native.find_java_method("edu.isi.stella.Surrogate", "genericallyAccessibleTypeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("GENERIC-SLOT-READER?", "(DEFUN (GENERIC-SLOT-READER? BOOLEAN) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "genericSlotReaderP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("GENERIC-SLOT-WRITER?", "(DEFUN (GENERIC-SLOT-WRITER? BOOLEAN) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "genericSlotWriterP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("SLOT-ACCESS-METHOD?", "(DEFUN (SLOT-ACCESS-METHOD? BOOLEAN) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "slotAccessMethodP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("YIELD-GENERIC-SLOT-ACCESSOR-NAME", "(DEFUN (YIELD-GENERIC-SLOT-ACCESSOR-NAME SYMBOL) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldGenericSlotAccessorName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-GENERIC-SLOT-ACCESSOR-DEFINITION", "(DEFUN (YIELD-GENERIC-SLOT-ACCESSOR-DEFINITION CONS) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldGenericSlotAccessorDefinition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("CREATE-GENERIC-SLOT-ACCESSOR-UNIT", "(DEFUN CREATE-GENERIC-SLOT-ACCESSOR-UNIT ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "createGenericSlotAccessorUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-GENERIC-SLOT-ACCESSOR-ATTACHMENT", "(DEFUN (YIELD-GENERIC-SLOT-ACCESSOR-ATTACHMENT CONS) ((CLASS CLASS) (CLASSREF SYMBOL)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldGenericSlotAccessorAttachment", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("YIELD-MIXIN-CLASS-USERS-TREE", "(DEFUN (YIELD-MIXIN-CLASS-USERS-TREE (CONS OF SYMBOL)) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "yieldMixinClassUsersTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-MIXIN-SLOT-READER-NAME", "(DEFUN (YIELD-MIXIN-SLOT-READER-NAME SYMBOL) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldMixinSlotReaderName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("YIELD-MIXIN-SLOT-WRITER-NAME", "(DEFUN (YIELD-MIXIN-SLOT-WRITER-NAME SYMBOL) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldMixinSlotWriterName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("YIELD-MIXIN-SLOT-READER-TREE", "(DEFUN (YIELD-MIXIN-SLOT-READER-TREE CONS) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldMixinSlotReaderTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("YIELD-MIXIN-SLOT-WRITER-TREE", "(DEFUN (YIELD-MIXIN-SLOT-WRITER-TREE CONS) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldMixinSlotWriterTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("YIELD-NATIVE-SLOT-READER-NAME", "(DEFUN (YIELD-NATIVE-SLOT-READER-NAME SYMBOL) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldNativeSlotReaderName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("YIELD-NATIVE-SLOT-WRITER-NAME", "(DEFUN (YIELD-NATIVE-SLOT-WRITER-NAME SYMBOL) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldNativeSlotWriterName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineFunctionObject("YIELD-NATIVE-SLOT-READER-TREE", "(DEFUN (YIELD-NATIVE-SLOT-READER-TREE CONS) ((SLOT STORAGE-SLOT) (CLASS CLASS)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldNativeSlotReaderTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("YIELD-NATIVE-SLOT-WRITER-TREE", "(DEFUN (YIELD-NATIVE-SLOT-WRITER-TREE CONS) ((SLOT STORAGE-SLOT) (CLASS CLASS)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldNativeSlotWriterTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("CREATE-KEYED-EQUALITY-METHOD-UNIT", "(DEFUN CREATE-KEYED-EQUALITY-METHOD-UNIT ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "createKeyedEqualityMethodUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("TRANSIENT-OBJECT?", "(DEFUN (TRANSIENT-OBJECT? BOOLEAN) ((OBJECT OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "transientObjectP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("STARTUP-DEFCLASS", "(DEFUN STARTUP-DEFCLASS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupDefclass", "startupDefclass", new java.lang.Class [] {}), null);
      { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_DEFCLASS);

        KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupDefclass"), Stella.NULL_STRING_WRAPPER);
      }
    }
  }

  public static void startupDefclass() {
    if (Stella.currentStartupTimePhaseP(0)) {
      Stella.$ALL_RECYCLE_LISTS$ = Stella.makeNonRecycledList();
    }
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupDefclass.helpStartupDefclass1();
          _StartupDefclass.helpStartupDefclass2();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Stella.$RECYCLING_ENABLEDp$.setDefaultValue(new Boolean(true));
          Stella.$RECYCLE_LISTS_MAINTENANCE_TIMER$ = Stella.$RECYCLE_LISTS_MAINTENANCE_INTERVAL$;
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupDefclass.helpStartupDefclass3();
          _StartupDefclass.helpStartupDefclass4();
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *RECYCLING-ENABLED?* BOOLEAN TRUE :DOCUMENTATION \"If `TRUE' calls to `new' or `free' on classes with :recycle-method;\nspecifications will actually operate on recycle lists.  Otherwise, all\nrecycle list operations will be no-ops.\" :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *ALL-RECYCLE-LISTS* (LIST OF RECYCLE-LIST) NULL)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *MAX-RECYCLE-LIST-BYTES* INTEGER 3000000 :DOCUMENTATION \"Maximum number of bytes to be occupied by recycle lists.\" :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *RECYCLE-LISTS-MAINTENANCE-INTERVAL* INTEGER 5000 :DOCUMENTATION \"Total number of recycle list extensions after which a\nsize maintenance operation is performed to ensure that\nthe `*MAX-RECYCLE-LIST-BYTES*' limit is still met.\" :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *RECYCLE-LISTS-MAINTENANCE-TIMER* INTEGER *RECYCLE-LISTS-MAINTENANCE-INTERVAL* :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CURRENTLY-RECYCLED-ITEMS* (HASH-TABLE OF OBJECT OBJECT) NULL :DOCUMENTATION \"During recycle list debugging holds all items that live in\nsome free list.  Depending on program behavior, this table can get quite large!\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *TRANSLATE-WITH-RECYCLE-LIST-DEBUGGING?* BOOLEAN FALSE)");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
