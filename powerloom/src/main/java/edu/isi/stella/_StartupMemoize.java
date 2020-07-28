//  -*- Mode: Java -*-
//
// _StartupMemoize.java

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

public class _StartupMemoize {
  static void helpStartupMemoize1() {
    {
      Stella.SGT_STELLA_MEMOIZATION_TABLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("MEMOIZATION-TABLE", null, 1)));
      Stella.SYM_STELLA_HASH_TABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("HASH-TABLE", null, 0)));
      Stella.SYM_STELLA_TABLE_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TABLE-NAME", null, 0)));
      Stella.SYM_STELLA_CURRENT_TIMESTAMP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CURRENT-TIMESTAMP", null, 0)));
      Stella.SYM_STELLA_TIMESTAMPS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMESTAMPS", null, 0)));
      Stella.SGT_STELLA_MRU_MEMOIZATION_TABLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("MRU-MEMOIZATION-TABLE", null, 1)));
      Stella.SYM_STELLA_MRU_BUCKETS_VECTOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MRU-BUCKETS-VECTOR", null, 0)));
      Stella.SYM_STELLA_LRU_BUCKETS_VECTOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LRU-BUCKETS-VECTOR", null, 0)));
      Stella.SYM_STELLA_MRU_TIMESTAMP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MRU-TIMESTAMP", null, 0)));
      Stella.SYM_STELLA_LRU_TIMESTAMP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LRU-TIMESTAMP", null, 0)));
      Stella.SYM_STELLA_NOF_BUCKETS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NOF-BUCKETS", null, 0)));
      Stella.SYM_STELLA_FREE_ENTRIES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FREE-ENTRIES", null, 0)));
      Stella.SYM_STELLA_MAX_ENTRIES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MAX-ENTRIES", null, 0)));
      Stella.KWD_MAX_VALUES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MAX-VALUES", null, 2)));
      Stella.KWD_TIMESTAMPS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMESTAMPS", null, 2)));
      Stella.KWD_NAME = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NAME", null, 2)));
      Stella.SYM_STELLA_LOOKUP_MEMOIZED_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LOOKUP-MEMOIZED-VALUE", null, 0)));
      Stella.SYM_STELLA_LOOKUP_MEMOIZED_VALUEN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LOOKUP-MEMOIZED-VALUEN", null, 0)));
      Stella.SYM_STELLA_LOOKUP_MRU_MEMOIZED_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LOOKUP-MRU-MEMOIZED-VALUE", null, 0)));
      Stella.SYM_STELLA_LOOKUP_MRU_MEMOIZED_VALUEN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LOOKUP-MRU-MEMOIZED-VALUEN", null, 0)));
      Stella.SYM_STELLA_MEMOIZED_NULL_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MEMOIZED-NULL-VALUE", null, 0)));
      Stella.SYM_STELLA_MEMOIZATION_TABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MEMOIZATION-TABLE", null, 0)));
      Stella.SYM_STELLA_$MEMOIZATION_ENABLEDp$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("*MEMOIZATION-ENABLED?*", null, 0)));
      Stella.SYM_STELLA_INITIALIZE_MEMOIZATION_TABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INITIALIZE-MEMOIZATION-TABLE", null, 0)));
      Stella.SGT_STELLA_MEMOIZABLE_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("MEMOIZABLE-ITERATOR", null, 1)));
      Stella.SYM_STELLA_BASE_ITERATOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BASE-ITERATOR", null, 0)));
      Stella.SYM_STELLA_ITERATOR_AND_VALUES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ITERATOR-AND-VALUES", null, 0)));
      Stella.SYM_STELLA_STARTUP_MEMOIZE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-MEMOIZE", null, 0)));
    }
  }

  public static void startupMemoize() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupMemoize.helpStartupMemoize1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Stella.$ALL_MEMOIZATION_TABLES$ = List.newList();
          { Symbol self073 = Symbol.newSymbol("MEMOIZED-NULL-VALUE");

            self073.homeContext = null;
            Stella.MEMOIZED_NULL_VALUE = self073;
          }
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("MEMOIZATION-TABLE", "(DEFCLASS MEMOIZATION-TABLE (STANDARD-OBJECT) :DOCUMENTATION \"Table that maps argument values onto computed results for\none individual memoization site.\" :SLOTS ((HASH-TABLE :TYPE (INTEGER-HASH-TABLE OF INTEGER (CONS OF CONS)) :DOCUMENTATION \"The table holding the memoized values.\nWe use an integer table, since we explicitly compute a hash code by combining\nhash codes of argument values.\") (TABLE-NAME :TYPE SURROGATE :DOCUMENTATION \"The surrogate used to point to this table.\nUsed at the memoization site for quick memo table lookup.\") (CURRENT-TIMESTAMP :TYPE CONS :DOCUMENTATION \"Marker value used to indicate valid memoized entries.\nThis marker changes everytime one of the `timestamps' gets bumped.\") (TIMESTAMPS :TYPE (CONS OF KEYWORD) :INITIALLY NIL :DOCUMENTATION \"Names of timestamps that trigger invalidation of\nmemoized entries when they get bumped.\")))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.MemoizationTable", "newMemoizationTable", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.MemoizationTable", "accessMemoizationTableSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MemoizationTable"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          Stella.$MEMOIZATION_ENABLEDp$ = true;
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("MRU-MEMOIZATION-TABLE", "(DEFCLASS MRU-MEMOIZATION-TABLE (MEMOIZATION-TABLE) :SLOTS ((MRU-BUCKETS-VECTOR :TYPE (VECTOR OF (CONS OF CONS))) (LRU-BUCKETS-VECTOR :TYPE (VECTOR OF (CONS OF CONS))) (MRU-BUCKETS :TYPE (NATIVE-VECTOR OF (CONS OF CONS))) (LRU-BUCKETS :TYPE (NATIVE-VECTOR OF (CONS OF CONS))) (MRU-TIMESTAMP :TYPE CONS) (LRU-TIMESTAMP :TYPE CONS) (NOF-BUCKETS :TYPE INTEGER) (FREE-ENTRIES :TYPE INTEGER) (MAX-ENTRIES :TYPE INTEGER)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.MruMemoizationTable", "newMruMemoizationTable", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.MruMemoizationTable", "accessMruMemoizationTableSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MruMemoizationTable"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("MEMOIZABLE-ITERATOR", "(DEFCLASS MEMOIZABLE-ITERATOR (ITERATOR) :DOCUMENTATION \"Iterator class with value buffering that can be used to memoize some\n`base-iterator' without having to generate all its values first.  The\nmemoized iterator needs to be cloned to allow multiple iterations over\nthe collection represented by the memoized iterator.  Use the following\nidiom to memoize some arbitrary iterator and return a properly cloned value:\n	 \n (clone-memoized-iterator\n   (memoize (...) <options>*\n            (new MEMOIZABLE-ITERATOR\n                 :base-iterator <base-iterator>)))\n	\nThis will ensure that <base-iterator> is exhausted exactly once even if\nthere are multiple clones for the same memoized value, and that each value\nis generated as late as absolutely possible.  THIS IS NOT YET THREAD SAFE!\" :PUBLIC? TRUE :SLOTS ((BASE-ITERATOR :TYPE ITERATOR :REQUIRED? TRUE :DOCUMENTATION \"This slot is only needed to pass the base iterator\nto the constructor.  Once `self' is initialized it will be cleared.\") (ITERATOR-AND-VALUES :TYPE CONS :INITIALLY NULL :DOCUMENTATION \"Holds the base iterator and the values generated\nso far.  This slot is structure shared between the memoized iterator and\nall its clones to make sure everybody sees any new values generated by\nany one of the clones, and that everybody can see when the base iterator\nis exhausted.\") (CURSOR :TYPE CONS :INITIALLY NULL :DOCUMENTATION \"Trailing cursor to the list of values generated\nso far.  Once the end of the list is reached this slot is used to add new\nvalues to the end of `iterator-and-values'.\")) :INITIALIZER INITIALIZE-MEMOIZABLE-ITERATOR)");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.MemoizableIterator", "newMemoizableIterator", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Iterator")});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.MemoizableIterator", "accessMemoizableIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MemoizableIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("ENABLE-MEMOIZATION", "(DEFUN ENABLE-MEMOIZATION () :COMMAND? TRUE :PUBLIC? TRUE :DOCUMENTATION \"Enable memoization and use of memoized expression results.\")", Native.find_java_method("edu.isi.stella.Stella", "enableMemoization", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("DISABLE-MEMOIZATION", "(DEFUN DISABLE-MEMOIZATION () :COMMAND? TRUE :PUBLIC? TRUE :DOCUMENTATION \"Enable memoization and use of memoized expression results.\")", Native.find_java_method("edu.isi.stella.Stella", "disableMemoization", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("HASH-MEMOIZED-ARGUMENTS", "(DEFUN (HASH-MEMOIZED-ARGUMENTS INTEGER) ((ARG1 OBJECT) (ARG2 OBJECT) (ARG3 OBJECT) (ARG4 OBJECT) (EQVECTOR INTEGER)))", Native.find_java_method("edu.isi.stella.Stella_Object", "hashMemoizedArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("HASH-MEMOIZED-ARGUMENTSN", "(DEFUN (HASH-MEMOIZED-ARGUMENTSN INTEGER) ((TUPLE CONS) (EQVECTOR INTEGER)))", Native.find_java_method("edu.isi.stella.Cons", "hashMemoizedArgumentsn", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("MAKE-MEMOIZED-VALUE-ENTRY", "(DEFUN (MAKE-MEMOIZED-VALUE-ENTRY (CONS OF CONS)) ((VALUE OBJECT) (ARG1 OBJECT) (ARG2 OBJECT) (ARG3 OBJECT) (ARG4 OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "makeMemoizedValueEntry", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("MAKE-MEMOIZED-VALUE-ENTRYN", "(DEFUN (MAKE-MEMOIZED-VALUE-ENTRYN (CONS OF CONS)) ((VALUE OBJECT) (ARGS CONS)) :GLOBALLY-INLINE? TRUE (RETURN (CONS VALUE ARGS)))", Native.find_java_method("edu.isi.stella.Stella_Object", "makeMemoizedValueEntryn", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("FIND-MEMOIZED-VALUE-ENTRY", "(DEFUN (FIND-MEMOIZED-VALUE-ENTRY CONS) ((BUCKET (CONS OF CONS)) (ARG1 OBJECT) (ARG2 OBJECT) (ARG3 OBJECT) (ARG4 OBJECT) (EQVECTOR INTEGER) (DELETEENTRY? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Cons", "findMemoizedValueEntry", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Integer.TYPE, java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("FIND-MEMOIZED-VALUE-ENTRYN", "(DEFUN (FIND-MEMOIZED-VALUE-ENTRYN CONS) ((BUCKET (CONS OF CONS)) (TUPLE CONS) (EQVECTOR INTEGER) (DELETEENTRY? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Cons", "findMemoizedValueEntryn", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons"), java.lang.Integer.TYPE, java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("LOOKUP-MEMOIZED-VALUE", "(DEFUN (LOOKUP-MEMOIZED-VALUE CONS) ((MEMOTABLE MEMOIZATION-TABLE) (ARG1 OBJECT) (ARG2 OBJECT) (ARG3 OBJECT) (ARG4 OBJECT) (EQVECTOR INTEGER)))", Native.find_java_method("edu.isi.stella.MemoizationTable", "lookupMemoizedValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MemoizationTable"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("LOOKUP-MEMOIZED-VALUEN", "(DEFUN (LOOKUP-MEMOIZED-VALUEN CONS) ((MEMOTABLE MEMOIZATION-TABLE) (ARGS CONS) (EQVECTOR INTEGER)))", Native.find_java_method("edu.isi.stella.MemoizationTable", "lookupMemoizedValuen", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MemoizationTable"), Native.find_java_class("edu.isi.stella.Cons"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("INITIALIZE-MRU-BUCKET-TABLES", "(DEFUN INITIALIZE-MRU-BUCKET-TABLES ((MEMOTABLE MRU-MEMOIZATION-TABLE)))", Native.find_java_method("edu.isi.stella.MruMemoizationTable", "initializeMruBucketTables", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MruMemoizationTable")}), null);
          Stella.defineFunctionObject("LOOKUP-MRU-MEMOIZED-VALUE", "(DEFUN (LOOKUP-MRU-MEMOIZED-VALUE CONS) ((MEMOTABLE MRU-MEMOIZATION-TABLE) (ARG1 OBJECT) (ARG2 OBJECT) (ARG3 OBJECT) (ARG4 OBJECT) (EQVECTOR INTEGER)))", Native.find_java_method("edu.isi.stella.MruMemoizationTable", "lookupMruMemoizedValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MruMemoizationTable"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("LOOKUP-MRU-MEMOIZED-VALUEN", "(DEFUN (LOOKUP-MRU-MEMOIZED-VALUEN CONS) ((MEMOTABLE MRU-MEMOIZATION-TABLE) (ARGS CONS) (EQVECTOR INTEGER)))", Native.find_java_method("edu.isi.stella.MruMemoizationTable", "lookupMruMemoizedValuen", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MruMemoizationTable"), Native.find_java_class("edu.isi.stella.Cons"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("INITIALIZE-MEMOIZATION-TABLE", "(DEFUN INITIALIZE-MEMOIZATION-TABLE ((MEMOTABLESURROGATE SURROGATE) (OPTIONS STRING)))", Native.find_java_method("edu.isi.stella.Surrogate", "initializeMemoizationTable", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("CLEAR-ALL-MEMOIZATION-TABLES", "(DEFUN CLEAR-ALL-MEMOIZATION-TABLES ())", Native.find_java_method("edu.isi.stella.Stella", "clearAllMemoizationTables", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("CLEAR-MEMOIZATION-TABLES", "(DEFUN CLEAR-MEMOIZATION-TABLES ((TIMESTAMPNAME KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "clearMemoizationTables", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("BUMP-MEMOIZATION-TIMESTAMP", "(DEFUN BUMP-MEMOIZATION-TIMESTAMP ((TIMESTAMPNAME KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "bumpMemoizationTimestamp", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("MAKE-MEMOIZATION-TABLE-SURROGATE", "(DEFUN (MAKE-MEMOIZATION-TABLE-SURROGATE SURROGATE) ((MEMONAME SYMBOL)))", Native.find_java_method("edu.isi.stella.Symbol", "makeMemoizationTableSurrogate", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("PARSE-MEMOIZE-OPTIONS", "(DEFUN (PARSE-MEMOIZE-OPTIONS PROPERTY-LIST) ((OPTIONS CONS)))", Native.find_java_method("edu.isi.stella.Cons", "parseMemoizeOptions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("MEMOIZE", "(DEFUN MEMOIZE ((INPUTARGS CONS) |&BODY| (BODY CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Compute the value of an expression and memoize it relative to\n   the values of `inputArgs'.\n`inputArgs' should characterize the complete set of values upon which\n   the computation of the result depended.\nCalls to `memoize' should be of the form\n\n      (memoize (<arg>+) {:<option> <value>}* <expression>)\n\n   and have the status of an expression.\n   The following options are supported:\n\n      :timestamps   A single or list of keywords specifying the names of\n                    timestamps which when bumped should invalidate all\n                    entries currently memoized in this table.\n      :name         Names the memoization table so it can be shared by other\n                    memoization sites.  By default, a gensymed name is used.\n                    CAUTION: IT IS ASSUMED THAT ALL ENTRIES IN A MEMOZATION\n                    TABLE DEPEND ON THE SAME NUMBER OF ARGUMENTS!!\n      :max-values   The maximum number of values to be memoized.  Only the\n                    `:max-values' most recently used values will be kept\n                    in the memoization table, older values will be discarded\n                    and recomputed if needed.  Without a `:max-values'\n                    specification, the memoization table will grow\n                    indefinitely.\n\nPERFORMANCE NOTES: For most efficient lookup, input arguments that vary the most\nshould be listed first.  Also, arguments of type STANDARD-OBJECT (and all its\nsubtypes) can be memoized more efficiently than arguments of type OBJECT or\nwrapped literals (with the exception of BOOLEANs).\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Cons", "memoize", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineMethodObject("(DEFMETHOD INITIALIZE-MEMOIZABLE-ITERATOR ((SELF MEMOIZABLE-ITERATOR)))", Native.find_java_method("edu.isi.stella.MemoizableIterator", "initializeMemoizableIterator", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("CLONE-MEMOIZED-ITERATOR", "(DEFUN (CLONE-MEMOIZED-ITERATOR (ITERATOR OF (LIKE (ANY-VALUE SELF)))) ((SELF MEMOIZABLE-ITERATOR)) :DOCUMENTATION \"Clone the memoized iterator `self' so it can be used to\niterate over the collection represented by `self', while allowing to iterate\nover it multiple times via multiple clones.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.MemoizableIterator", "cloneMemoizedIterator", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MemoizableIterator")}), null);
          Stella.defineMethodObject("(DEFMETHOD (ALLOCATE-ITERATOR (ITERATOR OF (LIKE (ANY-VALUE SELF)))) ((SELF MEMOIZABLE-ITERATOR)) :DOCUMENTATION \"Alias for `clone-memoized-iterator'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.MemoizableIterator", "allocateIterator", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (NEXT? BOOLEAN) ((SELF MEMOIZABLE-ITERATOR)) :DOCUMENTATION \"Generate the next value of the memoized iterator `self' (or\none of its clones) by either using one of the values generated so far or by\ngenerating and saving the next value of the `base-iterator'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.MemoizableIterator", "nextP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("STARTUP-MEMOIZE", "(DEFUN STARTUP-MEMOIZE () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupMemoize", "startupMemoize", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_MEMOIZE);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupMemoize"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *ALL-MEMOIZATION-TABLES* (LIST OF MEMOIZATION-TABLE) (NEW LIST) :DOCUMENTATION \"Holds all currently active memoization tables for timestamp\nmaintenance and clearance purposes.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *MEMOIZATION-ENABLED?* BOOLEAN FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT MEMOIZED-NULL-VALUE SYMBOL (NEW SYMBOL :SYMBOL-NAME \"MEMOIZED-NULL-VALUE\" :HOME-CONTEXT NULL) :DOCUMENTATION \"Used by memoization to indicate that a NULL value\nwas cached.  Needed to distinguish between an undefined value and a\ncached NULL.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *TOTAL-MEMOIZATION-LOOKUPS* INTEGER 0)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *FAILED-MEMOIZATION-LOOKUPS* INTEGER 0)");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
