//  -*- Mode: Java -*-
//
// _StartupDescribe.java

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

public class _StartupDescribe {
  static void helpStartupDescribe1() {
    {
      Stella.SGT_STELLA_CONTEXT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTEXT", null, 1)));
      Stella.KWD_VERBOSE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("VERBOSE", null, 2)));
      Stella.SGT_STELLA_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("ITERATOR", null, 1)));
      Stella.SGT_STELLA_RELATION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION", null, 1)));
      Stella.KWD_SOURCE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SOURCE", null, 2)));
      Stella.KWD_TERSE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TERSE", null, 2)));
      Stella.KWD_OWNER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("OWNER", null, 2)));
      Stella.KWD_SHADOWS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SHADOWS", null, 2)));
      Stella.SYM_STELLA_gg_INFERRED_SLOTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule(">>_INFERRED_SLOTS", null, 0)));
      Stella.KWD_USED_BY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("USED-BY", null, 2)));
      Stella.SYM_STELLA_STARTUP_DESCRIBE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-DESCRIBE", null, 0)));
    }
  }

  static void helpStartupDescribe2() {
    {
      Stella.defineFunctionObject("GET", "(DEFUN (GET OBJECT) ((NAME NAME) |&REST| (TYPE NAME)) :COMMAND? TRUE :PUBLIC? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.stella.Stella_Object", "get", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.stella.Cons", "getEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineMethodObject("(DEFMETHOD (GET-OBJECT OBJECT) ((SELF OBJECT) (TYPE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "getObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (GET-OBJECT OBJECT) ((SELF STRING) (TYPE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella", "string_getObject", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (GET-OBJECT OBJECT) ((SELF INTEGER) (TYPE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella", "integer_getObject", new java.lang.Class [] {java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("STRING-SEARCH-FOR-OBJECT", "(DEFUN (STRING-SEARCH-FOR-OBJECT OBJECT) ((STRING STRING) (CLASSTYPE TYPE)))", Native.find_java_method("edu.isi.stella.Stella", "stringSearchForObject", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("SEARCH-FOR-OBJECT", "(DEFUN (SEARCH-FOR-OBJECT OBJECT) ((SELF OBJECT) (TYPEREF OBJECT)) :DOCUMENTATION \"If `self' is a string or a symbol, search for an object named\n`self' of type `type'.  Otherwise, if `self' is an object, return it.\")", Native.find_java_method("edu.isi.stella.Stella_Object", "searchForObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("FILTER-STRING-TO-CLASS?", "(DEFUN (FILTER-STRING-TO-CLASS? BOOLEAN) ((SELF CLASS) (ITERATOR ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.Stella_Class", "filterStringToClassP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("STRING-TO-CLASSES", "(DEFUN (STRING-TO-CLASSES (ITERATOR OF CLASS)) ((STRING STRING) (EXACT? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Stella", "stringToClasses", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("STRING-TO-CLASS", "(DEFUN (STRING-TO-CLASS OBJECT) ((STRING STRING)))", Native.find_java_method("edu.isi.stella.Stella", "stringToClass", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("STRING-TO-CONTEXT", "(DEFUN (STRING-TO-CONTEXT OBJECT) ((STRING STRING)))", Native.find_java_method("edu.isi.stella.Stella", "stringToContext", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("STRING-TO-FUNCTION", "(DEFUN (STRING-TO-FUNCTION OBJECT) ((STRING STRING)))", Native.find_java_method("edu.isi.stella.Stella", "stringToFunction", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("DOTTED-STRING?", "(DEFUN (DOTTED-STRING? BOOLEAN) ((STRING STRING)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "dottedStringP", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("YIELD-EXPLODED-METHOD-NAME", "(DEFUN (YIELD-EXPLODED-METHOD-NAME STRING STRING) ((DOTTEDSTRING STRING)))", Native.find_java_method("edu.isi.stella.Stella", "yieldExplodedMethodName", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("STRING-TO-SLOT", "(DEFUN (STRING-TO-SLOT OBJECT) ((STRING STRING)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "stringToSlot", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("STRING-TO-SURROGATE-VALUE", "(DEFUN (STRING-TO-SURROGATE-VALUE OBJECT) ((STRING STRING)))", Native.find_java_method("edu.isi.stella.Stella", "stringToSurrogateValue", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("STRING-TO-DEMON", "(DEFUN (STRING-TO-DEMON OBJECT) ((STRING STRING)))", Native.find_java_method("edu.isi.stella.Stella", "stringToDemon", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("INTEGER-TO-CONTEXT", "(DEFUN (INTEGER-TO-CONTEXT OBJECT) ((INTEGER INTEGER)))", Native.find_java_method("edu.isi.stella.Stella", "integerToContext", new java.lang.Class [] {java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("DESCRIBE", "(DEFUN DESCRIBE ((NAME OBJECT) |&REST| (MODE OBJECT)) :DOCUMENTATION \"Print a description of an object in :verbose, :terse,\nor :source modes.\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.stella.Stella_Object", "describe", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.stella.Cons", "describeEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("DESCRIBE-TERSELY", "(DEFUN DESCRIBE-TERSELY ((SELF OBJECT) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.Stella_Object", "describeTersely", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineFunctionObject("PRETTY-PRINT-STELLA-TREE", "(DEFUN PRETTY-PRINT-STELLA-TREE ((TREE CONS) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.Cons", "prettyPrintStellaTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineFunctionObject("PRETTY-PRINT-DEFINITION-TREE", "(DEFUN PRETTY-PRINT-DEFINITION-TREE ((TREE CONS) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.Cons", "prettyPrintDefinitionTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineFunctionObject("CONSIFY-LISTS-AND-ITERATORS", "(DEFUN (CONSIFY-LISTS-AND-ITERATORS OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "consifyListsAndIterators", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineMethodObject("(DEFMETHOD PRINT-DEFINITION ((SELF MODULE) (STREAM OUTPUT-STREAM)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Module", "printDefinition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("PRINT-CLASS-LIST", "(DEFUN PRINT-CLASS-LIST ((SELF (ITERATOR OF CLASS)) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.Iterator", "printClassList", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Iterator"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineMethodObject("(DEFMETHOD PRETTY-PRINT-OBJECT ((SELF SLOT) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.Slot", "prettyPrintObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("GET-CLASS-OPTIONS", "(DEFUN (GET-CLASS-OPTIONS (CONS OF STORAGE-SLOT)) ())", Native.find_java_method("edu.isi.stella.Stella", "getClassOptions", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("GET-UNSTRINGIFIED-CLASS-OPTIONS", "(DEFUN (GET-UNSTRINGIFIED-CLASS-OPTIONS PROPERTY-LIST) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "getUnstringifiedClassOptions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("GET-SLOT-OPTIONS", "(DEFUN (GET-SLOT-OPTIONS (CONS OF STORAGE-SLOT)) ())", Native.find_java_method("edu.isi.stella.Stella", "getSlotOptions", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("PRETTY-PRINT-LITERAL", "(DEFUN PRETTY-PRINT-LITERAL ((LITERAL OBJECT) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.Stella_Object", "prettyPrintLiteral", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineFunctionObject("LITERAL-EQL?", "(DEFUN (LITERAL-EQL? BOOLEAN) ((X OBJECT) (Y OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "literalEqlP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CONVERT-TO-LITERAL", "(DEFUN (CONVERT-TO-LITERAL OBJECT) ((OBJECT OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "convertToLiteral", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("PRETTY-PRINT-CLASS-OPTIONS", "(DEFUN PRETTY-PRINT-CLASS-OPTIONS ((CLASS CLASS) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.Stella_Class", "prettyPrintClassOptions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineFunctionObject("PRETTY-PRINT-SLOT-OPTIONS", "(DEFUN PRETTY-PRINT-SLOT-OPTIONS ((SLOT STORAGE-SLOT) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.StorageSlot", "prettyPrintSlotOptions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineMethodObject("(DEFMETHOD PRETTY-PRINT-OBJECT ((SELF STORAGE-SLOT) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.StorageSlot", "prettyPrintObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("PRETTY-PRINT-METHOD-PARAMETERS", "(DEFUN PRETTY-PRINT-METHOD-PARAMETERS ((STREAM OUTPUT-STREAM) (METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.OutputStream", "prettyPrintMethodParameters", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineMethodObject("(DEFMETHOD PRETTY-PRINT-OBJECT ((SELF METHOD-SLOT) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.MethodSlot", "prettyPrintObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("PRETTY-PRINT-SLOT-BLOCK", "(DEFUN PRETTY-PRINT-SLOT-BLOCK ((STREAM OUTPUT-STREAM) (ITERATOR (ITERATOR OF SLOT)) (SLOTGROUP STRING)))", Native.find_java_method("edu.isi.stella.OutputStream", "prettyPrintSlotBlock", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.Iterator"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("PRETTY-PRINT-SLOTS", "(DEFUN PRETTY-PRINT-SLOTS ((SELF CLASS) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.Stella_Class", "prettyPrintSlots", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineMethodObject("(DEFMETHOD PRETTY-PRINT-OBJECT ((SELF CLASS) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.Stella_Class", "prettyPrintObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD DESCRIBE-OBJECT ((SELF OBJECT) (STREAM OUTPUT-STREAM) (MODE KEYWORD)) :PUBLIC? TRUE :DOCUMENTATION \"Prints a description of 'self' to stream 'stream'.  'mode'\ncan be :terse, :verbose, or :source.  The :terse mode is often equivalent\nto the standard print function.\")", Native.find_java_method("edu.isi.stella.Stella_Object", "describeObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD DESCRIBE-OBJECT ((SELF CLASS) (STREAM OUTPUT-STREAM) (MODE KEYWORD)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Class", "describeObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD DESCRIBE-OBJECT ((SELF STORAGE-SLOT) (STREAM OUTPUT-STREAM) (MODE KEYWORD)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.StorageSlot", "describeObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD DESCRIBE-OBJECT ((SELF MODULE) (STREAM OUTPUT-STREAM) (MODE KEYWORD)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Module", "describeObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("XMODULE-STRINGIFIED-SOURCE", "(DEFUN (XMODULE-STRINGIFIED-SOURCE STRING) ((SELF MODULE)))", Native.find_java_method("edu.isi.stella.Module", "xmoduleStringifiedSource", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("SHORT-DOCUMENTATION", "(DEFUN (SHORT-DOCUMENTATION STRING) ((DOCUMENTATION STRING)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "shortDocumentation", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("PRINT-DOCUMENTATION-STRING", "(DEFUN PRINT-DOCUMENTATION-STRING ((STRING STRING) (INDENT INTEGER) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.Stella", "printDocumentationString", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineMethodObject("(DEFMETHOD PRINT-DOCUMENTATION ((SELF METHOD-SLOT) (STREAM OUTPUT-STREAM) (SHORT? BOOLEAN)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.MethodSlot", "printDocumentation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), java.lang.Boolean.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("STARTUP-DESCRIBE", "(DEFUN STARTUP-DESCRIBE () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupDescribe", "startupDescribe", new java.lang.Class [] {}), null);
      { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_DESCRIBE);

        KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupDescribe"), Stella.NULL_STRING_WRAPPER);
      }
    }
  }

  public static void startupDescribe() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupDescribe.helpStartupDescribe1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Stella.$STRING_TO_OBJECT_FUNCTIONS$ = KeyValueList.newKeyValueList();
          Stella.$INTEGER_TO_OBJECT_FUNCTIONS$ = List.list(Stella.NIL);
          Stella.$DEFAULT_DESCRIBE_MODE$ = Stella.KWD_VERBOSE;
          Stella.$SLOTOPTIONSLOTS$.setDefaultValue(null);
          Stella.$CLASSOPTIONSLOTS$.setDefaultValue(null);
          Stella.$CLASSUNSTRINGIFIEDOPTIONS$.setDefaultValue(null);
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupDescribe.helpStartupDescribe2();
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *STRING-TO-OBJECT-FUNCTIONS* (KEY-VALUE-LIST OF TYPE CODE-WRAPPER) (NEW KEY-VALUE-LIST) :DOCUMENTATION \"Table of functions (keyed by type of object returned) that can\nbe called to search for an object identified by a string.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *INTEGER-TO-OBJECT-FUNCTIONS* (LIST OF CODE-WRAPPER) (LIST) :DOCUMENTATION \"List of functions that can be called to search for\nan object identified by an integer.\")");
          Stella.$STRING_TO_OBJECT_FUNCTIONS$.clear();
          Stella.$STRING_TO_OBJECT_FUNCTIONS$.insertAt(Stella.SGT_STELLA_CLASS, FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Stella", "stringToClass", new java.lang.Class [] {Native.find_java_class("java.lang.String")})));
          Stella.$STRING_TO_OBJECT_FUNCTIONS$.insertAt(Stella.SGT_STELLA_CONTEXT, FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Stella", "stringToContext", new java.lang.Class [] {Native.find_java_class("java.lang.String")})));
          Stella.$STRING_TO_OBJECT_FUNCTIONS$.insertAt(Stella.SGT_STELLA_METHOD_SLOT, FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Stella", "stringToFunction", new java.lang.Class [] {Native.find_java_class("java.lang.String")})));
          Stella.$STRING_TO_OBJECT_FUNCTIONS$.insertAt(Stella.SGT_STELLA_SLOT, FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Stella", "stringToSlot", new java.lang.Class [] {Native.find_java_class("java.lang.String")})));
          Stella.$STRING_TO_OBJECT_FUNCTIONS$.insertAt(Stella.SGT_STELLA_OBJECT, FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Stella", "stringToSurrogateValue", new java.lang.Class [] {Native.find_java_class("java.lang.String")})));
          Stella.$STRING_TO_OBJECT_FUNCTIONS$.insertAt(Stella.SGT_STELLA_DEMON, FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Stella", "stringToDemon", new java.lang.Class [] {Native.find_java_class("java.lang.String")})));
          Stella.$INTEGER_TO_OBJECT_FUNCTIONS$.insert(FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Stella", "integerToContext", new java.lang.Class [] {java.lang.Integer.TYPE})));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *DEFAULT-DESCRIBE-MODE* KEYWORD :VERBOSE :PUBLIC? TRUE :DOCUMENTATION \"Specifies the print mode for `describe' when no second\nargument is given.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *PRETTY-PRINT-LIST-CUTOFF* INTEGER 5 :PUBLIC? TRUE :DOCUMENTATION \"Lists longer than the cutoff are truncated during\npretty printing.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *SLOTOPTIONSLOTS* (CONS OF STORAGE-SLOT) NULL :DOCUMENTATION \"List of slots containing storage-slot options\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *CLASSOPTIONSLOTS* (CONS OF STORAGE-SLOT) NULL :DOCUMENTATION \"List of slots containing class options\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *CLASSUNSTRINGIFIEDOPTIONS* PROPERTY-LIST NULL :DOCUMENTATION \"Plist of unstringifed class options\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
