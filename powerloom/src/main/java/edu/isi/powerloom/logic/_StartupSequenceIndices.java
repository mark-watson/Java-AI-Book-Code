//  -*- Mode: Java -*-
//
// _StartupSequenceIndices.java

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

public class _StartupSequenceIndices {
  static void helpStartupSequenceIndices1() {
    {
      Logic.SYM_LOGIC_SELECTION_PATTERN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SELECTION-PATTERN", null, 0)));
      Logic.SYM_LOGIC_THE_SEQUENCE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("THE-SEQUENCE", null, 0)));
      Logic.SYM_LOGIC_THE_SEQUENCE_LENGTH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("THE-SEQUENCE-LENGTH", null, 0)));
      Logic.SGT_LOGIC_NON_PAGING_INDEX = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("NON-PAGING-INDEX", null, 1)));
      Logic.SGT_LOGIC_PAGING_INDEX = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PAGING-INDEX", null, 1)));
      Logic.SYM_LOGIC_STORE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STORE", null, 0)));
      Logic.SGT_LOGIC_SEQUENCE_INDEX_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SEQUENCE-INDEX-ITERATOR", null, 1)));
      Logic.SYM_STELLA_LIST_ITERATOR_CURSOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LIST-ITERATOR-CURSOR", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SGT_LOGIC_PAGING_INDEX_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PAGING-INDEX-ITERATOR", null, 1)));
      Logic.SYM_LOGIC_OBJECT_STORE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OBJECT-STORE", null, 0)));
      Logic.SGT_STELLA_MODULE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SGT_LOGIC_OBJECT_STORE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("OBJECT-STORE", null, 1)));
      Logic.KWD_PAGING = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PAGING", null, 2)));
      Logic.KWD_NON_PAGING = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NON-PAGING", null, 2)));
      Logic.SYM_LOGIC_STARTUP_SEQUENCE_INDICES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-SEQUENCE-INDICES", null, 0)));
    }
  }

  public static void startupSequenceIndices() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupSequenceIndices.helpStartupSequenceIndices1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Logic.NIL_NON_PAGING_INDEX = NonPagingIndex.newNonPagingIndex();
          { PagingIndex self002 = PagingIndex.newPagingIndex();

            self002.selectionPattern = Stella.getQuotedTree("((:NIL-SEQUENCE) \"/LOGIC\")", "/LOGIC");
            Logic.NIL_PAGING_INDEX = self002;
          }
          Logic.$ALL_OBJECT_STORES$ = Stella.NIL_LIST;
          Logic.$LOADINGREGENERABLEOBJECTSp$.setDefaultValue(new Boolean(false));
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE SELECTION-PATTERN CONS)");
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("SEQUENCE-INDEX", "(DEFCLASS SEQUENCE-INDEX (STANDARD-OBJECT) :DOCUMENTATION \"Abstract class for managing a sequence of objects.\" :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :ABSTRACT? TRUE :SLOTS ((THE-SEQUENCE :TYPE CONS :INITIALLY NIL) (THE-SEQUENCE-LENGTH :TYPE INTEGER :INITIALLY NULL)) :PRINT-FORM (PRINT-SEQUENCE-INDEX SELF STREAM))");

            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.SequenceIndex", "accessSequenceIndexSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.SequenceIndex"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("NON-PAGING-INDEX", "(DEFCLASS NON-PAGING-INDEX (SEQUENCE-INDEX) :DOCUMENTATION \"Index that manages an always-in-memory data\nstrucure containing a sequence of objects.\")");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.NonPagingIndex", "newNonPagingIndex", new java.lang.Class [] {});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("PAGING-INDEX", "(DEFCLASS PAGING-INDEX (SEQUENCE-INDEX) :DOCUMENTATION \"Index that manages a sequence of objects retrievable from\npersistent storage.  Needs to be appropriately subclassed by actual store\nimplementations and facilitated with a proper iterator class.\" :SLOTS ((SELECTION-PATTERN :TYPE SELECTION-PATTERN) (STORE :TYPE OBJECT-STORE)) :PRINT-FORM (PRINT-PAGING-INDEX SELF STREAM))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.PagingIndex", "newPagingIndex", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.PagingIndex", "accessPagingIndexSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PagingIndex"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("SEQUENCE-INDEX-ITERATOR", "(DEFCLASS SEQUENCE-INDEX-ITERATOR (ITERATOR) :DOCUMENTATION \"Iterator that generates successive members of a sequence index.\" :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :SLOTS ((LIST-ITERATOR-CURSOR :TYPE CONS)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.SequenceIndexIterator", "newSequenceIndexIterator", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.SequenceIndexIterator", "accessSequenceIndexIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.SequenceIndexIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("PAGING-INDEX-ITERATOR", "(DEFCLASS PAGING-INDEX-ITERATOR (SEQUENCE-INDEX-ITERATOR) :DOCUMENTATION \"Iterator that generates successive members of a paging index.\" :PARAMETERS ((ANY-VALUE :TYPE OBJECT)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.PagingIndexIterator", "newPagingIndexIterator", new java.lang.Class [] {});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("OBJECT-STORE", "(DEFCLASS OBJECT-STORE (STANDARD-OBJECT) :ABSTRACT? TRUE :SLOTS ((MODULE :TYPE MODULE)))");

            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.ObjectStore", "accessObjectStoreSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ObjectStore"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineMethodObject("(DEFMETHOD INSERT ((SELF SEQUENCE-INDEX) (VALUE (LIKE (ANY-VALUE SELF)))) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.SequenceIndex", "insert", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD PUSH ((SELF SEQUENCE-INDEX) (VALUE (LIKE (ANY-VALUE SELF)))) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.SequenceIndex", "push", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (FIRST OBJECT) ((SELF SEQUENCE-INDEX)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.SequenceIndex", "first", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (EMPTY? BOOLEAN) ((SELF SEQUENCE-INDEX)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.SequenceIndex", "emptyP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (ESTIMATED-LENGTH INTEGER) ((SELF SEQUENCE-INDEX)))", Native.find_java_method("edu.isi.powerloom.logic.SequenceIndex", "estimatedLength", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("SEQUENCE-INDEX.ESTIMATED-LENGTH", "(DEFUN (SEQUENCE-INDEX.ESTIMATED-LENGTH INTEGER) ((SELF SEQUENCE-INDEX)))", Native.find_java_method("edu.isi.powerloom.logic.SequenceIndex", "sequenceIndexDestimatedLength", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.SequenceIndex")}), null);
          Stella.defineMethodObject("(DEFMETHOD (REMOVE-DELETED-MEMBERS (LIKE SELF)) ((SELF SEQUENCE-INDEX)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.SequenceIndex", "removeDeletedMembers", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (REMOVE (LIKE SELF)) ((SELF SEQUENCE-INDEX) (VALUE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.SequenceIndex", "remove", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (CONSIFY (CONS OF (LIKE (ANY-VALUE SELF)))) ((SELF SEQUENCE-INDEX)))", Native.find_java_method("edu.isi.powerloom.logic.SequenceIndex", "consify", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("PRINT-SEQUENCE-INDEX", "(DEFUN PRINT-SEQUENCE-INDEX ((SELF SEQUENCE-INDEX) (STREAM NATIVE-OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.SequenceIndex", "printSequenceIndex", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.SequenceIndex"), Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), null);
          Stella.defineMethodObject("(DEFMETHOD (ALLOCATE-ITERATOR (ITERATOR OF (LIKE (ANY-VALUE SELF)))) ((SELF SEQUENCE-INDEX)))", Native.find_java_method("edu.isi.powerloom.logic.SequenceIndex", "allocateIterator", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (NEXT? BOOLEAN) ((SELF SEQUENCE-INDEX-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.SequenceIndexIterator", "nextP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (EMPTY? BOOLEAN) ((SELF SEQUENCE-INDEX-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.SequenceIndexIterator", "emptyP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (COPY NON-PAGING-INDEX) ((SELF NON-PAGING-INDEX)))", Native.find_java_method("edu.isi.powerloom.logic.NonPagingIndex", "copy", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD CLEAR ((SELF NON-PAGING-INDEX)))", Native.find_java_method("edu.isi.powerloom.logic.NonPagingIndex", "clear", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD INSERT ((SELF PAGING-INDEX) (VALUE (LIKE (ANY-VALUE SELF)))) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.PagingIndex", "insert", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD PUSH ((SELF PAGING-INDEX) (VALUE (LIKE (ANY-VALUE SELF)))) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.PagingIndex", "push", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (ESTIMATED-LENGTH INTEGER) ((SELF PAGING-INDEX)) :DOCUMENTATION \"Return the estimated length of the sequences in 'self',\nwhich could be too large if some of the members have been deleted.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.PagingIndex", "estimatedLength", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (REMOVE-DELETED-MEMBERS (LIKE SELF)) ((SELF PAGING-INDEX)) :DOCUMENTATION \"Destructively remove all deleted members of `self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.PagingIndex", "removeDeletedMembers", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (REMOVE (LIKE SELF)) ((SELF PAGING-INDEX) (VALUE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.PagingIndex", "remove", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("PRINT-PAGING-INDEX", "(DEFUN PRINT-PAGING-INDEX ((SELF PAGING-INDEX) (STREAM NATIVE-OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.PagingIndex", "printPagingIndex", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PagingIndex"), Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), null);
          Stella.defineMethodObject("(DEFMETHOD (ALLOCATE-ITERATOR (ITERATOR OF (LIKE (ANY-VALUE SELF)))) ((SELF PAGING-INDEX)))", Native.find_java_method("edu.isi.powerloom.logic.PagingIndex", "allocateIterator", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT MODULE OBJECT-STORE :TYPE OBJECT-STORE :ALLOCATION :DYNAMIC)");
          Stella.defineFunctionObject("REGISTER-OBJECT-STORE", "(DEFUN REGISTER-OBJECT-STORE ((STORE OBJECT-STORE)) :DOCUMENTATION \"Register `store' as an active object store.\")", Native.find_java_method("edu.isi.powerloom.logic.ObjectStore", "registerObjectStore", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ObjectStore")}), null);
          Stella.defineFunctionObject("UNREGISTER-OBJECT-STORE", "(DEFUN UNREGISTER-OBJECT-STORE ((STORE OBJECT-STORE)) :DOCUMENTATION \"Remove `store' from the list of active object stores.\")", Native.find_java_method("edu.isi.powerloom.logic.ObjectStore", "unregisterObjectStore", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ObjectStore")}), null);
          Stella.defineFunctionObject("HAVE-ACTIVE-OBJECT-STORES?", "(DEFUN (HAVE-ACTIVE-OBJECT-STORES? BOOLEAN) () :DOCUMENTATION \"Return TRUE if we have at least one object store opened/linked into\nPowerLoom, which changes some index access routines to be considerate of that.\" :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (NOT (EQL? *ALL-OBJECT-STORES* NIL-LIST))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "haveActiveObjectStoresP", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("HOME-OBJECT-STORE", "(DEFUN (HOME-OBJECT-STORE OBJECT-STORE) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "homeObjectStore", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CREATE-SEQUENCE-INDEX", "(DEFUN (CREATE-SEQUENCE-INDEX SEQUENCE-INDEX) ((SELF OBJECT) (PATTERN SELECTION-PATTERN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createSequenceIndex", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("KEYWORD.CREATE-SEQUENCE-INDEX", "(DEFUN (KEYWORD.CREATE-SEQUENCE-INDEX SEQUENCE-INDEX) ((KIND KEYWORD) (PATTERN SELECTION-PATTERN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "keywordDcreateSequenceIndex", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("MODULE.CREATE-SEQUENCE-INDEX", "(DEFUN (MODULE.CREATE-SEQUENCE-INDEX SEQUENCE-INDEX) ((MODULE MODULE) (PATTERN SELECTION-PATTERN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "moduleDcreateSequenceIndex", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineMethodObject("(DEFMETHOD (OBJECT-STORE.CREATE-SEQUENCE-INDEX SEQUENCE-INDEX) ((STORE OBJECT-STORE) (PATTERN SELECTION-PATTERN)))", Native.find_java_method("edu.isi.powerloom.logic.ObjectStore", "objectStoreDcreateSequenceIndex", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("MAYBE-WRAP-SEQUENCE-INDEX", "(DEFUN (MAYBE-WRAP-SEQUENCE-INDEX SEQUENCE-INDEX) ((INDEX SEQUENCE-INDEX) (PATTERN SELECTION-PATTERN) (KIND KEYWORD) (ARG1 OBJECT) (ARG2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.SequenceIndex", "maybeWrapSequenceIndex", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.SequenceIndex"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineMethodObject("(DEFMETHOD (FETCH-RELATION NAMED-DESCRIPTION) ((STORE OBJECT-STORE) (NAME OBJECT)) :DOCUMENTATION \"Fetch the relation identified by `name' (a string or symbol) from `store'\nand return it as a named description.  This needs to be appropriately \nspecialized on actual OBJECT-STORE implementations.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.ObjectStore", "fetchRelation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (FETCH-INSTANCE OBJECT) ((STORE OBJECT-STORE) (NAME OBJECT)) :DOCUMENTATION \"Fetch the instance identified by `name' (a string or symbol) from `store'\nand return it as an appropriate logic object.  This needs to be appropriately\nspecialized on actual OBJECT-STORE implementations.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.ObjectStore", "fetchInstance", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (FETCH-DUPLICATE-PROPOSITION PROPOSITION) ((STORE OBJECT-STORE) (PROP PROPOSITION)) :DOCUMENTATION \"Fetch a duplicate of `prop' if defined by `store'.  EXPERIMENTAL!\nThe exact semantics of this still needs to be worked out.  This needs to be appropriately\nspecialized on actual OBJECT-STORE implementations.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.ObjectStore", "fetchDuplicateProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD UPDATE-PROPOSITION-IN-STORE ((STORE OBJECT-STORE) (PROPOSITION PROPOSITION) (UPDATE-MODE KEYWORD)) :DOCUMENTATION \"A module with `store' has had the truth value of `proposition'\nchange according to `update-mode'.  The default method does nothing.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.ObjectStore", "updatePropositionInStore", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("STARTUP-SEQUENCE-INDICES", "(DEFUN STARTUP-SEQUENCE-INDICES () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupSequenceIndices", "startupSequenceIndices", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_SEQUENCE_INDICES);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupSequenceIndices"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT NIL-NON-PAGING-INDEX NON-PAGING-INDEX (NEW NON-PAGING-INDEX) :DOCUMENTATION \"Returns a non-writable empty sequence.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT NIL-PAGING-INDEX PAGING-INDEX (NEW PAGING-INDEX :SELECTION-PATTERN (QUOTE (:NIL-SEQUENCE))) :DOCUMENTATION \"Returns a non-writable empty sequence.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *ALL-OBJECT-STORES* (LIST OF OBJECT-STORE) NIL-LIST :DOCUMENTATION \"The list of all currently active object stores.  To signal\nthat no object stores are active, this has to be NIL-LIST as opposed to the\nempty list.\" :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *LOADINGREGENERABLEOBJECTS?* BOOLEAN FALSE :DOCUMENTATION \"If TRUE, objects being created are regenerable,\nand should not be indexed using the backlinks procedures.\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
