//  -*- Mode: Java -*-
//
// _StartupIterators.java

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

public class _StartupIterators {
  static void helpStartupIterators1() {
    {
      Stella.defineMethodObject("(DEFMETHOD (ALLOCATE-ITERATOR (LIKE SELF)) ((SELF ABSTRACT-ITERATOR)) :DOCUMENTATION \"Iterator objects return themselves when asked\nfor an iterator (they occupy the same position as a collection\nwithin a 'foreach' statement).\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.AbstractIterator", "allocateIterator", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (LENGTH INTEGER) ((SELF ABSTRACT-ITERATOR)) :DOCUMENTATION \"Iterate over 'self', and count how many\nitems there are.  Bad idea if 'self' iterates over an infinite\ncollection, since in that case it will run forever.'\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.AbstractIterator", "length", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (POP (LIKE (ANY-VALUE SELF))) ((SELF ITERATOR)) :PUBLIC? TRUE :DOCUMENTATION \"Return the first item of the sequence represented by 'self',\nor NULL if it is empty.  Destructively uses up the first iteration element.\")", Native.find_java_method("edu.isi.stella.Iterator", "pop", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (ADVANCE (LIKE SELF)) ((SELF ITERATOR) (N INTEGER)) :PUBLIC? TRUE :DOCUMENTATION \"Return 'self' after skipping over the first\n'n' elements in the (remainder of the) iteration.\")", Native.find_java_method("edu.isi.stella.Iterator", "advance", new java.lang.Class [] {java.lang.Integer.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (EMPTY? BOOLEAN) ((SELF ITERATOR)) :PUBLIC? TRUE :DOCUMENTATION \"Return TRUE if the sequence represented by 'self'\nhas no elements.  Side-effect free.\")", Native.find_java_method("edu.isi.stella.Iterator", "emptyP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (MEMBER? BOOLEAN) ((SELF ITERATOR) (VALUE OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"Iterate over values of 'self', returning TRUE\nif one of them is 'eql' to 'value.\")", Native.find_java_method("edu.isi.stella.Iterator", "memberP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (NEXT? BOOLEAN) ((SELF DESTRUCTIVE-LIST-ITERATOR)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.DestructiveListIterator", "nextP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (EMPTY? BOOLEAN) ((SELF DESTRUCTIVE-LIST-ITERATOR)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.DestructiveListIterator", "emptyP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("TERMINATE-DESTRUCTIVE-LIST-ITERATOR?", "(DEFUN (TERMINATE-DESTRUCTIVE-LIST-ITERATOR? BOOLEAN) ((SELF DESTRUCTIVE-LIST-ITERATOR)))", Native.find_java_method("edu.isi.stella.DestructiveListIterator", "terminateDestructiveListIteratorP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.DestructiveListIterator")}), null);
      Stella.defineMethodObject("(DEFMETHOD INSERT ((SELF DESTRUCTIVE-LIST-ITERATOR) (VALUE (LIKE (ANY-VALUE SELF)))) :DOCUMENTATION \"Add 'value' to the front of the list 'self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.DestructiveListIterator", "insert", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (ALLOCATE-DESTRUCTIVE-LIST-ITERATOR (ITERATOR OF (LIKE (ANY-VALUE SELF)))) ((SELF CONS)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Cons", "allocateDestructiveListIterator", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (ALLOCATE-DESTRUCTIVE-LIST-ITERATOR (ITERATOR OF (LIKE (ANY-VALUE SELF)))) ((SELF LIST)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.List", "allocateDestructiveListIterator", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)) :DOCUMENTATION \"Apply the stored 'next?' function to 'self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "nextP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (EMPTY? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "emptyP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (TERMINATE-ALL-PURPOSE-ITERATOR? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "terminateAllPurposeIteratorP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("FILTERED-NESTED-ITERATOR-NEXT?", "(DEFUN (FILTERED-NESTED-ITERATOR-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "filteredNestedIteratorNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("ITERATOR-CONS-LIST-NEXT?", "(DEFUN (ITERATOR-CONS-LIST-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "iteratorConsListNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("ITERATOR-CONS-LIST-EMPTY?", "(DEFUN (ITERATOR-CONS-LIST-EMPTY? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "iteratorConsListEmptyP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("FILTERED-CONCATENATED-ITERATOR-NEXT?", "(DEFUN (FILTERED-CONCATENATED-ITERATOR-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "filteredConcatenatedIteratorNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineMethodObject("(DEFMETHOD (CONCATENATE ALL-PURPOSE-ITERATOR) ((ITERATOR1 ITERATOR) (ITERATOR2 ITERATOR) |&REST| (OTHERITERATORS ITERATOR)) :DOCUMENTATION \"Return an iterator that first generates all values of\n`iterator1', then those of `iterator2', and then those of all `otherIterators'.\nThe generated values can be filtered by supplying a filter function to the\nresulting iterator.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Iterator", "concatenate", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Iterator"), Native.find_java_class("edu.isi.stella.Cons")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD INITIALIZE-INTEGER-INTERVAL-ITERATOR ((SELF INTEGER-INTERVAL-ITERATOR)))", Native.find_java_method("edu.isi.stella.IntegerIntervalIterator", "initializeIntegerIntervalIterator", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (NEXT? BOOLEAN) ((SELF INTEGER-INTERVAL-ITERATOR)))", Native.find_java_method("edu.isi.stella.IntegerIntervalIterator", "nextP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("INTERVAL", "(DEFUN (INTERVAL INTEGER-INTERVAL-ITERATOR) ((LOWERBOUND INTEGER) (UPPERBOUND INTEGER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "interval", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE}), null);
      Stella.defineMethodObject("(DEFMETHOD (REVERSE REVERSE-INTEGER-INTERVAL-ITERATOR) ((SELF INTEGER-INTERVAL-ITERATOR)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.IntegerIntervalIterator", "reverse", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("INITIALIZE-REVERSE-INTEGER-INTERVAL-ITERATOR", "(DEFUN INITIALIZE-REVERSE-INTEGER-INTERVAL-ITERATOR ((SELF REVERSE-INTEGER-INTERVAL-ITERATOR)))", Native.find_java_method("edu.isi.stella.ReverseIntegerIntervalIterator", "initializeReverseIntegerIntervalIterator", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.ReverseIntegerIntervalIterator")}), null);
      Stella.defineMethodObject("(DEFMETHOD (NEXT? BOOLEAN) ((SELF REVERSE-INTEGER-INTERVAL-ITERATOR)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.ReverseIntegerIntervalIterator", "nextP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("REVERSE-INTERVAL", "(DEFUN (REVERSE-INTERVAL REVERSE-INTEGER-INTERVAL-ITERATOR) ((LOWERBOUND INTEGER) (UPPERBOUND INTEGER)) :DOCUMENTATION \"Create a reverse interval object.\")", Native.find_java_method("edu.isi.stella.Stella", "reverseInterval", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE}), null);
      Stella.defineMethodObject("(DEFMETHOD (ALLOCATE-ITERATOR STRING-ITERATOR) ((SELF STRING)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "string_allocateIterator", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (NEXT? BOOLEAN) ((SELF STRING-ITERATOR)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.StringIterator", "nextP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("ALLOCATE-ALL-META-OBJECTS-ITERATOR", "(DEFUN (ALLOCATE-ALL-META-OBJECTS-ITERATOR ITERATOR) ((ARRAYSIZE INTEGER) (NEXTCODE FUNCTION-CODE) (MODULE MODULE) (LOCAL? BOOLEAN)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "allocateAllMetaObjectsIterator", new java.lang.Class [] {java.lang.Integer.TYPE, Native.find_java_class("java.lang.reflect.Method"), Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("SELECTED-META-OBJECT?", "(DEFUN (SELECTED-META-OBJECT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR) (OBJECTMODULE MODULE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "selectedMetaObjectP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator"), Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("ALL-SYMBOLS-NEXT?", "(DEFUN (ALL-SYMBOLS-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "allSymbolsNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("ALL-SYMBOLS", "(DEFUN (ALL-SYMBOLS (ITERATOR OF SYMBOL)) ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Iterate over all symbols visible from 'module'.\nIf 'local?', return only symbols interned in 'module'.\nIf 'module' is null, return all symbols interned everywhere.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Module", "allSymbols", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("FILTER-PUBLIC-SLOT?", "(DEFUN (FILTER-PUBLIC-SLOT? BOOLEAN) ((SELF SLOT) (ITERATOR ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.Slot", "filterPublicSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("FILTER-PRIVATE-SLOT?", "(DEFUN (FILTER-PRIVATE-SLOT? BOOLEAN) ((SELF SLOT) (ITERATOR ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.Slot", "filterPrivateSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("FILTER-METHOD-SLOT?", "(DEFUN (FILTER-METHOD-SLOT? BOOLEAN) ((SELF SLOT) (ITERATOR ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.Slot", "filterMethodSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("FILTER-PUBLIC-METHOD-SLOT?", "(DEFUN (FILTER-PUBLIC-METHOD-SLOT? BOOLEAN) ((SELF SLOT) (ITERATOR ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.Slot", "filterPublicMethodSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("FILTER-NON-EXTERNAL-SLOT?", "(DEFUN (FILTER-NON-EXTERNAL-SLOT? BOOLEAN) ((SELF SLOT) (ITERATOR ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.Slot", "filterNonExternalSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("FILTER-NON-PARAMETER-SLOT?", "(DEFUN (FILTER-NON-PARAMETER-SLOT? BOOLEAN) ((SELF SLOT) (ITERATOR ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.Slot", "filterNonParameterSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("FILTER-NON-AUXILIARY-SLOT?", "(DEFUN (FILTER-NON-AUXILIARY-SLOT? BOOLEAN) ((SELF SLOT) (ITERATOR ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.Slot", "filterNonAuxiliarySlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("FILTER-SLOT?", "(DEFUN (FILTER-SLOT? BOOLEAN) ((SELF SLOT) (ITERATOR ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.Slot", "filterSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("ALL-FUNCTIONS-NEXT?", "(DEFUN (ALL-FUNCTIONS-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "allFunctionsNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("ALL-FUNCTIONS", "(DEFUN (ALL-FUNCTIONS (ITERATOR OF FUNCTION)) ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Iterate over all functions visible from 'module'.\nIf 'local?', return only functions bound to symbols interned in 'module'.\nIf 'module' is null, return all functions defined everywhere.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Module", "allFunctions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ALL-PUBLIC-FUNCTIONS", "(DEFUN (ALL-PUBLIC-FUNCTIONS (ITERATOR OF FUNCTION)) ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Iterate over all functions visible from 'module'.\nIf 'local?', return only functions bound to symbols interned in 'module'.\nIf 'module' is null, return all functions defined everywhere.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Module", "allPublicFunctions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ALL-VARIABLES-NEXT?", "(DEFUN (ALL-VARIABLES-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "allVariablesNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("ALL-VARIABLES", "(DEFUN (ALL-VARIABLES (ITERATOR OF GLOBAL-VARIABLE)) ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Iterate over all variables visible from 'module'.\nIf 'local?', return only variables bound to symbols interned in 'module'.\nIf 'module' is null, return all variables defined everywhere.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Module", "allVariables", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ALL-SURROGATES-NEXT?", "(DEFUN (ALL-SURROGATES-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "allSurrogatesNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("ALL-SURROGATES", "(DEFUN (ALL-SURROGATES (ITERATOR OF SURROGATE)) ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Iterate over all surrogates visible from 'module'.\nIf 'local?', return only surrogates interned in 'module'.\nIf 'module' is null, return all surrogates interned everywhere.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Module", "allSurrogates", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ALL-CLASSES-NEXT?", "(DEFUN (ALL-CLASSES-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "allClassesNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("ALL-CLASSES", "(DEFUN (ALL-CLASSES (ITERATOR OF CLASS)) ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Iterate over all classes visible from 'module'.\nIf 'local?', return only classes interned in 'module'.\nIf 'module' is null, return all classes interned everywhere.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Module", "allClasses", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("SLOTS-NEXT?", "(DEFUN (SLOTS-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "slotsNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("ALL-SLOTS", "(DEFUN (ALL-SLOTS (ITERATOR OF SLOT)) ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Iterate over all slots visible from 'module'.\nIf 'local?', return only methods interned in 'module'.\nIf 'module' is null, return all methods interned everywhere.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Module", "allSlots", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ALL-METHODS", "(DEFUN (ALL-METHODS (ITERATOR OF METHOD-SLOT)) ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Iterate over all methods visible from 'module'.\nIf 'local?', return only methods interned in 'module'.\nIf 'module' is null, return all methods interned everywhere.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Module", "allMethods", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ALL-PUBLIC-METHODS", "(DEFUN (ALL-PUBLIC-METHODS (ITERATOR OF METHOD-SLOT)) ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Iterate over all public methods visible from 'module'.\nIf 'local?', return only methods interned in 'module'.\nIf 'module' is null, return all methods interned everywhere.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Module", "allPublicMethods", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CLASS-METHODS-NEXT?", "(DEFUN (CLASS-METHODS-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "classMethodsNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("CLASS-METHODS", "(DEFUN (CLASS-METHODS (ITERATOR OF METHOD-SLOT)) ((CLASS CLASS) (FILTERS (CONS OF FUNCTION-CODE-WRAPPER))))", Native.find_java_method("edu.isi.stella.Stella_Class", "classMethods", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("PUBLIC-CLASS-METHODS", "(DEFUN (PUBLIC-CLASS-METHODS (ITERATOR OF METHOD-SLOT)) ((CLASS CLASS)) :DOCUMENTATION \"Iterate over all private methods attached to 'class'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Class", "publicClassMethods", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("PRIVATE-CLASS-METHODS", "(DEFUN (PRIVATE-CLASS-METHODS (ITERATOR OF METHOD-SLOT)) ((CLASS CLASS)) :DOCUMENTATION \"Iterate over all private methods attached to 'class'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Class", "privateClassMethods", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("CLASS-STORAGE-SLOTS-NEXT?", "(DEFUN (CLASS-STORAGE-SLOTS-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "classStorageSlotsNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("CLASS-STORAGE-SLOTS", "(DEFUN (CLASS-STORAGE-SLOTS (ITERATOR OF STORAGE-SLOT)) ((CLASS CLASS) (FILTERS (CONS OF FUNCTION-CODE-WRAPPER))))", Native.find_java_method("edu.isi.stella.Stella_Class", "classStorageSlots", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.Cons")}), null);
    }
  }

  public static void startupIterators() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Stella.SGT_STELLA_CROSS_PRODUCT_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CROSS-PRODUCT-ITERATOR", null, 1)));
          Stella.SYM_STELLA_DOMAINS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DOMAINS", null, 0)));
          Stella.SYM_STELLA_CURSORS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CURSORS", null, 0)));
          Stella.SYM_STELLA_STARTUP_ITERATORS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-ITERATORS", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CROSS-PRODUCT-ITERATOR", "(DEFCLASS CROSS-PRODUCT-ITERATOR (ITERATOR) :DOCUMENTATION \"Iterator class that generates the cross product of a list of domains.\nEach value tuple is represented as a CONS.  CAUTION: the value tuple will be modified\ndestructively, hence, it needs to be copied in case it needs to persist beyond a single\niteration.\" :PUBLIC? TRUE :PARAMETERS ((ANY-VALUE :TYPE CONS)) :SLOTS ((DOMAINS :TYPE (CONS OF CONS) :INITIALLY NIL) (CURSORS :TYPE (CONS OF CONS) :INITIALLY NIL)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.CrossProductIterator", "newCrossProductIterator", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.CrossProductIterator", "accessCrossProductIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.CrossProductIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupIterators.helpStartupIterators1();
          Stella.defineFunctionObject("CLASS-TABLES-NEXT?", "(DEFUN (CLASS-TABLES-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "classTablesNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
          Stella.defineFunctionObject("CLASS-TABLES", "(DEFUN (CLASS-TABLES (ITERATOR OF TABLE)) ((CLASS CLASS) (FILTERS (CONS OF FUNCTION-CODE-WRAPPER))))", Native.find_java_method("edu.isi.stella.Stella_Class", "classTables", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("PUBLIC-CLASS-STORAGE-SLOTS", "(DEFUN (PUBLIC-CLASS-STORAGE-SLOTS (ITERATOR OF STORAGE-SLOT)) ((CLASS CLASS)) :DOCUMENTATION \"Iterate over all public storage-slots attached to 'class'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Class", "publicClassStorageSlots", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("PRIVATE-CLASS-STORAGE-SLOTS", "(DEFUN (PRIVATE-CLASS-STORAGE-SLOTS (ITERATOR OF STORAGE-SLOT)) ((CLASS CLASS)) :DOCUMENTATION \"Iterate over all private storage-slots attached to 'class'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Class", "privateClassStorageSlots", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("ALLOCATE-CROSS-PRODUCT-ITERATOR", "(DEFUN (ALLOCATE-CROSS-PRODUCT-ITERATOR CROSS-PRODUCT-ITERATOR) ((DOMAINS (CONS OF CONS))) :DOCUMENTATION \"Allocate a cross product iterator for a list of `domains'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Cons", "allocateCrossProductIterator", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineMethodObject("(DEFMETHOD RESET ((SELF CROSS-PRODUCT-ITERATOR)) :DOCUMENTATION \"Reset `self' to its initially allocated state.  Note, that\nthis is somewhat expensive, costing almost as much as allocating the iterator.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.CrossProductIterator", "reset", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (NEXT? BOOLEAN) ((SELF CROSS-PRODUCT-ITERATOR)))", Native.find_java_method("edu.isi.stella.CrossProductIterator", "nextP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("STARTUP-ITERATORS", "(DEFUN STARTUP-ITERATORS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupIterators", "startupIterators", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_ITERATORS);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupIterators"), Stella.NULL_STRING_WRAPPER);
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
