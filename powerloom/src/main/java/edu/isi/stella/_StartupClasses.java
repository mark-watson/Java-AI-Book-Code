//  -*- Mode: Java -*-
//
// _StartupClasses.java

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

public class _StartupClasses {
  static void helpStartupClasses1() {
    {
      Stella.KWD_PUBLICp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PUBLIC?", null, 2)));
      Stella.KWD_PARAMETERS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PARAMETERS", null, 2)));
      Stella.KWD_REQUIREDp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("REQUIRED?", null, 2)));
      Stella.KWD_COMPONENTp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("COMPONENT?", null, 2)));
      Stella.KWD_READ_ONLYp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("READ-ONLY?", null, 2)));
      Stella.KWD_ACTIVEp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ACTIVE?", null, 2)));
      Stella.KWD_CONTEXT_SENSITIVEp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTEXT-SENSITIVE?", null, 2)));
      Stella.KWD_HARDWIREDp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("HARDWIRED?", null, 2)));
      Stella.KWD_ABSTRACTp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ABSTRACT?", null, 2)));
      Stella.KWD_ALLOCATION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ALLOCATION", null, 2)));
      Stella.KWD_CLASS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS", null, 2)));
      Stella.KWD_INITIALLY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INITIALLY", null, 2)));
      Stella.SYM_STELLA_SLOT_INITIAL_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-INITIAL-VALUE", null, 0)));
      Stella.KWD_DEFAULT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFAULT", null, 2)));
      Stella.KWD_READER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("READER", null, 2)));
      Stella.KWD_WRITER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("WRITER", null, 2)));
      Stella.KWD_INVERSE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INVERSE", null, 2)));
      Stella.SYM_STELLA_SLOT_INVERSE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-INVERSE", null, 0)));
      Stella.KWD_RENAMES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("RENAMES", null, 2)));
      Stella.KWD_DOCUMENTATION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DOCUMENTATION", null, 2)));
      Stella.KWD_PROPERTIES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PROPERTIES", null, 2)));
      Stella.KWD_META_ATTRIBUTES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("META-ATTRIBUTES", null, 2)));
      Stella.SYM_STELLA_META_ATTRIBUTES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("META-ATTRIBUTES", null, 0)));
      Stella.KWD_OPTION_KEYWORD = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("OPTION-KEYWORD", null, 2)));
      Stella.SYM_STELLA_SLOT_OPTION_KEYWORD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-OPTION-KEYWORD", null, 0)));
      Stella.KWD_OPTION_HANDLER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("OPTION-HANDLER", null, 2)));
      Stella.SYM_STELLA_SLOT_OPTION_HANDLER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-OPTION-HANDLER", null, 0)));
      Stella.KWD_BIT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("BIT", null, 2)));
      Stella.KWD_CL_NATIVE_TYPE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CL-NATIVE-TYPE", null, 2)));
      Stella.KWD_CPP_NATIVE_TYPE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP-NATIVE-TYPE", null, 2)));
      Stella.KWD_IDL_NATIVE_TYPE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("IDL-NATIVE-TYPE", null, 2)));
      Stella.SYM_STELLA_CLASS_IDL_NATIVE_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-IDL-NATIVE-TYPE", null, 0)));
      Stella.KWD_JAVA_NATIVE_TYPE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA-NATIVE-TYPE", null, 2)));
      Stella.KWD_CL_STRUCTp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CL-STRUCT?", null, 2)));
      Stella.KWD_MIXINp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MIXIN?", null, 2)));
      Stella.KWD_RECYCLE_METHOD = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("RECYCLE-METHOD", null, 2)));
      Stella.KWD_EXTENSION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("EXTENSION", null, 2)));
      Stella.SYM_STELLA_CLASS_EXTENSION_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASS-EXTENSION-NAME", null, 0)));
      Stella.KWD_CREATOR = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CREATOR", null, 2)));
      Stella.KWD_INITIALIZER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INITIALIZER", null, 2)));
      Stella.KWD_TERMINATOR = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TERMINATOR", null, 2)));
      Stella.KWD_DESTRUCTOR = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DESTRUCTOR", null, 2)));
      Stella.KWD_INITIAL_VALUE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INITIAL-VALUE", null, 2)));
      Stella.KWD_PRINT_FORM = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PRINT-FORM", null, 2)));
      Stella.KWD_EQUALITY_TEST = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("EQUALITY-TEST", null, 2)));
      Stella.KWD_KEY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("KEY", null, 2)));
      Stella.KWD_SYNONYMS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SYNONYMS", null, 2)));
      Stella.KWD_CHILDREN = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CHILDREN", null, 2)));
      Stella.SGT_STELLA_STANDARD_OBJECT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("STANDARD-OBJECT", null, 1)));
      Stella.SYM_STELLA_PRIMARY_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PRIMARY-TYPE", null, 0)));
      Stella.SYM_STELLA_SELF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SELF", null, 0)));
      Stella.KWD_TYPE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TYPE", null, 2)));
      Stella.KWD_AUXILIARYp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("AUXILIARY?", null, 2)));
      Stella.SYM_STELLA_RETURN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RETURN", null, 0)));
      Stella.SGT_STELLA_SET_MIXIN = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SET-MIXIN", null, 1)));
      Stella.SYM_STELLA_INVERSE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INVERSE", null, 0)));
      Stella.KWD_DYNAMIC = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DYNAMIC", null, 2)));
      Stella.SGT_STELLA_DYNAMIC_SLOTS_MIXIN = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DYNAMIC-SLOTS-MIXIN", null, 1)));
      Stella.SGT_STELLA_CONTEXT_SENSITIVE_OBJECT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTEXT-SENSITIVE-OBJECT", null, 1)));
      Stella.SGT_STELLA_CONTEXT_SENSITIVE_MIXIN = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTEXT-SENSITIVE-MIXIN", null, 1)));
    }
  }

  static void helpStartupClasses2() {
    {
      Stella.SGT_STELLA_VOID = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("VOID", null, 1)));
      Stella.SYM_STELLA_METHOD_MACROp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-MACRO?", null, 0)));
      Stella.SGT_STELLA_ALL_CLASS_SLOTS_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("ALL-CLASS-SLOTS-ITERATOR", null, 1)));
      Stella.SYM_STELLA_ANY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ANY", null, 0)));
      Stella.SGT_STELLA_ANY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("ANY", null, 1)));
      Stella.SGT_STELLA_SLOT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT", null, 1)));
      Stella.SYM_STELLA_STARTUP_CLASSES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-CLASSES", null, 0)));
    }
  }

  static void helpStartupClasses3() {
    {
      Stella.defineFunctionObject("CLASS-NAME", "(DEFUN (CLASS-NAME STRING) ((CLASS CLASS)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Class", "className", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("CLASS-SYMBOL", "(DEFUN (CLASS-SYMBOL SYMBOL) ((CLASS CLASS)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Class", "classSymbol", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineMethodObject("(DEFMETHOD (PRIMARY-CLASS CLASS) ((SELF OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "primaryClass", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (LOOKUP-CLASS CLASS) ((NAME STRING)) :DOCUMENTATION \"Return a class with name `name'.  Scan all\nvisible surrogates looking for one that has a class defined for it.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "string_lookupClass", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (LOOKUP-CLASS CLASS) ((NAME SYMBOL)) :DOCUMENTATION \"Return a class with name `name'.  Scan all\nvisible surrogates looking for one that has a class defined for it.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Symbol", "lookupClass", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("TYPE-TO-CLASS", "(DEFUN (TYPE-TO-CLASS CLASS) ((TYPE TYPE)))", Native.find_java_method("edu.isi.stella.Surrogate", "typeToClass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineMethodObject("(DEFMETHOD (GET-STELLA-CLASS CLASS) ((CLASS-NAME TYPE) (ERROR? BOOLEAN)) :DOCUMENTATION \"Return a class with name `class-name'.  If none exists, break\nif `error?', else return `null'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "getStellaClass", new java.lang.Class [] {java.lang.Boolean.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (GET-STELLA-CLASS CLASS) ((CLASS-NAME STRING) (ERROR? BOOLEAN)) :DOCUMENTATION \"Return a class with name `class-name'.  If none exists, break\nif `error?', else return `null'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "string_getStellaClass", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Boolean.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (GET-STELLA-CLASS CLASS) ((CLASS-NAME SYMBOL) (ERROR? BOOLEAN)) :DOCUMENTATION \"Return a class with name `class-name'.  If non exists, break\nif `error?', else return `null'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Symbol", "getStellaClass", new java.lang.Class [] {java.lang.Boolean.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("BIND-TO-SURROGATE?", "(DEFUN (BIND-TO-SURROGATE? BOOLEAN OBJECT SURROGATE) ((SELF OBJECT) (NAME STRING) (CLIPOLDVALUE? BOOLEAN) (ASKFORPERMISSION? BOOLEAN)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "bindToSurrogateP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("java.lang.String"), java.lang.Boolean.TYPE, java.lang.Boolean.TYPE, Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineMethodObject("(DEFMETHOD UNBIND-FROM-SURROGATE ((SELF CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "unbindFromSurrogate", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("SHADOW-SYMBOL", "(DEFUN (SHADOW-SYMBOL SYMBOL) ((NAME STRING)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "shadowSymbol", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("SHADOW-SURROGATE", "(DEFUN (SHADOW-SURROGATE SURROGATE) ((NAME STRING)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "shadowSurrogate", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("SHADOWED-SYMBOL?", "(DEFUN (SHADOWED-SYMBOL? BOOLEAN) ((SYMBOL GENERALIZED-SYMBOL)) :DOCUMENTATION \"Return `true' if `symbol' is shadowed in its home module.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "shadowedSymbolP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol")}), null);
      Stella.defineFunctionObject("GET-CONSTRUCTOR", "(DEFUN (GET-CONSTRUCTOR FUNCTION-CODE) ((CLASS CLASS) (WARN? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Stella_Class", "getConstructor", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CREATE-OBJECT", "(DEFUN (CREATE-OBJECT OBJECT) ((TYPE TYPE) |&REST| (INITIAL-VALUE-PAIRS OBJECT)) :DOCUMENTATION \"Funcallable version of the `new' operator.\nReturn an instance of the class named by `type'.  If `initial-value-pairs'\nis supplied, it has to be a key/value list similar to what's accepted by `new'\nand the named slots will be initialized with the supplied values.  Similar to\n`new', all required arguments for `type' must be included.  Since all the\nslot initialization, etc. is handled dynamically at run time, `create-object'\nis much slower than `new'; therefore, it should only be used if `type' cannot\nbe known at translation time.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "createObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineMethodObject("(DEFMETHOD FREE ((SELF OBJECT)) :DOCUMENTATION \"Default method.  Deallocate storage for `self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "free", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD FREE ((SELF ACTIVE-OBJECT)) :DOCUMENTATION \"Remove all pointers between `self' and other objects,\nand then deallocate the storage for self.\")", Native.find_java_method("edu.isi.stella.ActiveObject", "free", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("DEFINE-STELLA-CLASS", "(DEFUN (DEFINE-STELLA-CLASS CLASS) ((NAME TYPE) (SUPERS (LIST OF TYPE)) (SLOTS (LIST OF SLOT)) (OPTIONS KEYWORD-KEY-VALUE-LIST)) :DOCUMENTATION \"Return a Stella class with name `name'.\nCaution:  If the class already exists, the Stella class object gets\nredefined, but the native C++ class is not redefined.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "defineStellaClass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.KeywordKeyValueList")}), null);
      Stella.defineFunctionObject("DEFINE-STELLA-SLOT", "(DEFUN (DEFINE-STELLA-SLOT SLOT) ((NAME SYMBOL) (OWNER TYPE) (BASETYPE TYPE) (TYPESPECIFIER CONS) (OPTIONS KEYWORD-KEY-VALUE-LIST)))", Native.find_java_method("edu.isi.stella.Symbol", "defineStellaSlot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.KeywordKeyValueList")}), null);
      Stella.defineFunctionObject("INCORPORATE-CLASS-OPTIONS", "(DEFUN INCORPORATE-CLASS-OPTIONS ((CLASS CLASS) (OPTIONS KEYWORD-KEY-VALUE-LIST)))", Native.find_java_method("edu.isi.stella.Stella_Class", "incorporateClassOptions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.KeywordKeyValueList")}), null);
      Stella.defineFunctionObject("INLINE-METHOD?", "(DEFUN (INLINE-METHOD? BOOLEAN) ((SLOT SLOT)))", Native.find_java_method("edu.isi.stella.Slot", "inlineMethodP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), null);
      Stella.defineFunctionObject("TRANSFER-EXTERNAL-SLOT-TO-NEW-CLASS", "(DEFUN TRANSFER-EXTERNAL-SLOT-TO-NEW-CLASS ((EXTERNALSLOT SLOT) (NEWCLASS CLASS)))", Native.find_java_method("edu.isi.stella.Slot", "transferExternalSlotToNewClass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("TRANSFER-DEMONS-FROM-OLDCLASS", "(DEFUN TRANSFER-DEMONS-FROM-OLDCLASS ((OLDCLASS CLASS) (NEWCLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "transferDemonsFromOldclass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("UNDEFINE-OLD-CLASS", "(DEFUN UNDEFINE-OLD-CLASS ((OLDCLASS CLASS) (NEWCLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "undefineOldClass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineMethodObject("(DEFMETHOD DESTROY-CLASS ((SELF CLASS)) :DOCUMENTATION \"Destroy the Stella class `self'.  \nUnfinalize its subclasses (if it has any).\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Class", "destroyClass", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD DESTROY-CLASS ((SELF TYPE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "destroyClass", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("DESTROY-CLASS-AND-SUBCLASSES", "(DEFUN DESTROY-CLASS-AND-SUBCLASSES ((SELF CLASS)) :DOCUMENTATION \"Destroy the Stella class `self' and all its subclasses.\")", Native.find_java_method("edu.isi.stella.Stella_Class", "destroyClassAndSubclasses", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineMethodObject("(DEFMETHOD (PRIMITIVE? BOOLEAN) ((SELF RELATION)) :DOCUMENTATION \"Return `true' if `self' is not a defined relation.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Relation", "primitiveP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("INSERT-PRIMITIVE-SUPER", "(DEFUN INSERT-PRIMITIVE-SUPER ((NEWSUPER TYPE) (SUPERS (LIST OF TYPE))))", Native.find_java_method("edu.isi.stella.Surrogate", "insertPrimitiveSuper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("COLLECT-MOST-SPECIFIC-PRIMITIVE-SUPERS", "(DEFUN COLLECT-MOST-SPECIFIC-PRIMITIVE-SUPERS ((CLASS CLASS) (SUPERS (LIST OF TYPE))))", Native.find_java_method("edu.isi.stella.Stella_Class", "collectMostSpecificPrimitiveSupers", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("MOST-SPECIFIC-PRIMITIVE-SUPERS", "(DEFUN (MOST-SPECIFIC-PRIMITIVE-SUPERS (LIST OF TYPE)) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "mostSpecificPrimitiveSupers", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("CLASS-NATIVE-SUPERS", "(DEFUN (CLASS-NATIVE-SUPERS (LIST OF TYPE)) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "classNativeSupers", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("REMEMBER-UNFINALIZED-CLASS", "(DEFUN REMEMBER-UNFINALIZED-CLASS ((CLASS CLASS) (FORCE? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Stella_Class", "rememberUnfinalizedClass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("FORGET-UNFINALIZED-CLASS", "(DEFUN FORGET-UNFINALIZED-CLASS ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "forgetUnfinalizedClass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("FINALIZE-CLASSES", "(DEFUN FINALIZE-CLASSES () :DOCUMENTATION \"Finalize all currently unfinalized classes.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "finalizeClasses", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("RESOLVE-CHILDREN-REFERENCES", "(DEFUN RESOLVE-CHILDREN-REFERENCES ())", Native.find_java_method("edu.isi.stella.Stella", "resolveChildrenReferences", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("FINALIZE-SLOTS", "(DEFUN FINALIZE-SLOTS () :PUBLIC? TRUE :DOCUMENTATION \"Finalize all currently unfinalized slots.\")", Native.find_java_method("edu.isi.stella.Stella", "finalizeSlots", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("CLEANUP-UNFINALIZED-CLASSES", "(DEFUN CLEANUP-UNFINALIZED-CLASSES () :PUBLIC? TRUE :DOCUMENTATION \"Remove all finalized classes from `*UNFINALIZED-CLASSES*',\nand set `*NEWLY-UNFINALIZED-CLASSES?*' to `false'.\")", Native.find_java_method("edu.isi.stella.Stella", "cleanupUnfinalizedClasses", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("FINALIZE-CLASSES-AND-SLOTS", "(DEFUN FINALIZE-CLASSES-AND-SLOTS () :PUBLIC? TRUE :DOCUMENTATION \"Finalize all currently unfinalized classes and slots.\")", Native.find_java_method("edu.isi.stella.Stella", "finalizeClassesAndSlots", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("ACTIVATE-CLASS", "(DEFUN ACTIVATE-CLASS ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "activateClass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("ADD-PRIMARY-TYPE", "(DEFUN ADD-PRIMARY-TYPE ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "addPrimaryType", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("FINALIZE-ONE-CLASS", "(DEFUN FINALIZE-ONE-CLASS ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "finalizeOneClass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("FINALIZE-CLASS", "(DEFUN (FINALIZE-CLASS BOOLEAN) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "finalizeClass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("HELP-FINALIZE-CLASS", "(DEFUN (HELP-FINALIZE-CLASS BOOLEAN) ((CLASS CLASS) (FINALIZEDPARENT TYPE)))", Native.find_java_method("edu.isi.stella.Stella_Class", "helpFinalizeClass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("UNFINALIZE-CLASS-AND-SUBCLASSES", "(DEFUN UNFINALIZE-CLASS-AND-SUBCLASSES ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "unfinalizeClassAndSubclasses", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("ATTACH-SLOT-TO-OWNER", "(DEFUN (ATTACH-SLOT-TO-OWNER SLOT) ((NEWSLOT SLOT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Slot", "attachSlotToOwner", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), null);
      Stella.defineFunctionObject("COMPUTE-SLOT-DIRECT-EQUIVALENT", "(DEFUN COMPUTE-SLOT-DIRECT-EQUIVALENT ((SELF SLOT)))", Native.find_java_method("edu.isi.stella.Slot", "computeSlotDirectEquivalent", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), null);
      Stella.defineFunctionObject("CHECK-CONFORMANCE-OF-SLOT-SIGNATURE", "(DEFUN CHECK-CONFORMANCE-OF-SLOT-SIGNATURE ((SELF SLOT)))", Native.find_java_method("edu.isi.stella.Slot", "checkConformanceOfSlotSignature", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), null);
      Stella.defineFunctionObject("COLLECTION-TO-ACTIVE-COLLECTION", "(DEFUN (COLLECTION-TO-ACTIVE-COLLECTION TYPE) ((TYPE TYPE)))", Native.find_java_method("edu.isi.stella.Surrogate", "collectionToActiveCollection", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("ACTIVATE-SLOT", "(DEFUN ACTIVATE-SLOT ((SELF STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "activateSlot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
      Stella.defineMethodObject("(DEFMETHOD FINALIZE-SLOT-TYPE-COMPUTATIONS ((SELF SLOT)))", Native.find_java_method("edu.isi.stella.Slot", "finalizeSlotTypeComputations", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD FINALIZE-SLOT-TYPE-COMPUTATIONS ((SELF STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "finalizeSlotTypeComputations", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("MULTI-VALUED-SLOT-WITH-DUPLICATES?", "(DEFUN (MULTI-VALUED-SLOT-WITH-DUPLICATES? BOOLEAN) ((SELF SLOT)))", Native.find_java_method("edu.isi.stella.Slot", "multiValuedSlotWithDuplicatesP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), null);
      Stella.defineFunctionObject("COMPUTE-SLOT-INVERSES", "(DEFUN COMPUTE-SLOT-INVERSES ((SELF SLOT)))", Native.find_java_method("edu.isi.stella.Slot", "computeSlotInverses", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), null);
      Stella.defineMethodObject("(DEFMETHOD HELP-FINALIZE-LOCAL-SLOT ((SELF SLOT)))", Native.find_java_method("edu.isi.stella.Slot", "helpFinalizeLocalSlot", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD HELP-FINALIZE-LOCAL-SLOT ((SELF STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "helpFinalizeLocalSlot", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("FINALIZE-LOCAL-SLOT", "(DEFUN FINALIZE-LOCAL-SLOT ((SELF SLOT)))", Native.find_java_method("edu.isi.stella.Slot", "finalizeLocalSlot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), null);
      Stella.defineMethodObject("(DEFMETHOD UNFINALIZE-LOCAL-SLOT ((SELF SLOT)))", Native.find_java_method("edu.isi.stella.Slot", "unfinalizeLocalSlot", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD UNFINALIZE-LOCAL-SLOT ((SELF STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "unfinalizeLocalSlot", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
    }
  }

  static void helpStartupClasses4() {
    {
      Stella.defineFunctionObject("FINALIZE-CLASS-SLOTS", "(DEFUN FINALIZE-CLASS-SLOTS ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "finalizeClassSlots", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("UNFINALIZE-CLASS-SLOTS", "(DEFUN UNFINALIZE-CLASS-SLOTS ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "unfinalizeClassSlots", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("HELP-UNFINALIZE-CLASS-SLOTS", "(DEFUN HELP-UNFINALIZE-CLASS-SLOTS ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "helpUnfinalizeClassSlots", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineMethodObject("(DEFMETHOD (MULTIPLE-PARENTS? BOOLEAN) ((CLASS CLASS)) :DOCUMENTATION \"Return `true' if `class' has more than one direct superclass.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Class", "multipleParentsP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("ADD-DIRECT-SUPERS-BACK-LINKS", "(DEFUN ADD-DIRECT-SUPERS-BACK-LINKS ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "addDirectSupersBackLinks", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("ADD-DIRECT-SUBS-BACK-LINKS", "(DEFUN ADD-DIRECT-SUBS-BACK-LINKS ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "addDirectSubsBackLinks", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("REMOVE-DIRECT-SUPERS-BACK-LINKS", "(DEFUN REMOVE-DIRECT-SUPERS-BACK-LINKS ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "removeDirectSupersBackLinks", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("COLLECT-DIRECT-SUPER-CLASSES", "(DEFUN COLLECT-DIRECT-SUPER-CLASSES ((CLASS CLASS) (PARENTS (LIST OF CLASS))))", Native.find_java_method("edu.isi.stella.Stella_Class", "collectDirectSuperClasses", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("INHERIT-SUPERCLASSES", "(DEFUN INHERIT-SUPERCLASSES ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "inheritSuperclasses", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("UNINHERIT-SUPERCLASSES", "(DEFUN UNINHERIT-SUPERCLASSES ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "uninheritSuperclasses", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("TWO-ARGUMENT-LEAST-COMMON-SUPERCLASS", "(DEFUN (TWO-ARGUMENT-LEAST-COMMON-SUPERCLASS CLASS) ((CLASS1 CLASS) (CLASS2 CLASS)) :DOCUMENTATION \"Return the most specific class that is a superclass of\nboth `class1' and `class2'.  If there is more than one, arbitrarily pick one.\nIf there is none, return `null'.\")", Native.find_java_method("edu.isi.stella.Stella_Class", "twoArgumentLeastCommonSuperclass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("TWO-ARGUMENT-LEAST-COMMON-SUPERTYPE", "(DEFUN (TWO-ARGUMENT-LEAST-COMMON-SUPERTYPE TYPE-SPEC) ((TYPE1 TYPE-SPEC) (TYPE2 TYPE-SPEC)) :DOCUMENTATION \"Return the most specific type that is a supertype of\nboth `type1' and `type2'.  If there is more than one, arbitrarily pick one.\nIf there is none, return @VOID.  If one or both types are parametric,\nalso try to generalize parameter types if necessary.\")", Native.find_java_method("edu.isi.stella.StandardObject", "twoArgumentLeastCommonSupertype", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineFunctionObject("INHERIT-SLOTS", "(DEFUN INHERIT-SLOTS ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "inheritSlots", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("LOCAL-SLOT?", "(DEFUN (LOCAL-SLOT? BOOLEAN) ((SLOT SLOT) (CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Slot", "localSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("UNINHERIT-SLOTS", "(DEFUN UNINHERIT-SLOTS ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "uninheritSlots", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("INITIALIZE-SLOT-AND-METHOD-CACHE", "(DEFUN INITIALIZE-SLOT-AND-METHOD-CACHE ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "initializeSlotAndMethodCache", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("REGISTER-SLOT-NAME", "(DEFUN REGISTER-SLOT-NAME ((SLOT SLOT)) :PUBLIC? TRUE :DOCUMENTATION \"Register the name symbol of `slot' as a slot name, and\ninitialize its `symbol-slot-offset' so that it can be used by `lookup-slot'.\")", Native.find_java_method("edu.isi.stella.Slot", "registerSlotName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), null);
      Stella.defineFunctionObject("UNREGISTER-SLOT-NAME", "(DEFUN UNREGISTER-SLOT-NAME ((SLOT SLOT)) :PUBLIC? TRUE :DOCUMENTATION \"Unregister the name symbol of `slot' as a slot name,\nso that it can no longer be used by `lookup-slot'.\")", Native.find_java_method("edu.isi.stella.Slot", "unregisterSlotName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), null);
      Stella.defineFunctionObject("REGISTERED-SLOT-NAME?", "(DEFUN (REGISTERED-SLOT-NAME? BOOLEAN) ((SLOT-NAME SYMBOL)) :GLOBALLY-INLINE? TRUE :PUBLIC? TRUE :DOCUMENTATION \"Return `true' if `slot-name' is the name of some registered;\nslot in the system.\" (RETURN (DEFINED? (SYMBOL-SLOT-OFFSET SLOT-NAME))))", Native.find_java_method("edu.isi.stella.Symbol", "registeredSlotNameP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("WARN-ABOUT-SLOT-SHADOWED-BY-A-FUNCTION?", "(DEFUN (WARN-ABOUT-SLOT-SHADOWED-BY-A-FUNCTION? BOOLEAN) ((SLOT SLOT)))", Native.find_java_method("edu.isi.stella.Slot", "warnAboutSlotShadowedByAFunctionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), null);
      Stella.defineFunctionObject("WARN-ABOUT-FUNCTION-SHADOWING-SLOTS?", "(DEFUN (WARN-ABOUT-FUNCTION-SHADOWING-SLOTS? BOOLEAN) ((FUNCTION METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "warnAboutFunctionShadowingSlotsP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("LOOKUP-SLOT", "(DEFUN (LOOKUP-SLOT SLOT) ((CLASS CLASS) (SLOT-NAME SYMBOL)) :DOCUMENTATION \"Return a slot owned by the class `class' with name `slot-name'.\nMultiply inherited slots are disambiguated by a left-to-right class\nprecedence order for classes with multiple parents (similar to CLOS).\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Class", "lookupSlot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("SAFE-LOOKUP-SLOT", "(DEFUN (SAFE-LOOKUP-SLOT SLOT) ((CLASS CLASS) (SLOT-NAME SYMBOL)) :DOCUMENTATION \"Alias for `lookup-slot'.  Kept for backwards compatibility.\" :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE (RETURN (LOOKUP-SLOT CLASS SLOT-NAME)))", Native.find_java_method("edu.isi.stella.Stella_Class", "safeLookupSlot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("LOOKUP-VISIBLE-SLOT", "(DEFUN (LOOKUP-VISIBLE-SLOT SLOT) ((CLASS CLASS) (SLOT-NAME OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Class", "lookupVisibleSlot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("LOOKUP-LOCAL-SLOT", "(DEFUN (LOOKUP-LOCAL-SLOT SLOT) ((CLASS CLASS) (SLOT-NAME SYMBOL)) :DOCUMENTATION \"Lookup a local slot with `slot-name' on `class'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Class", "lookupLocalSlot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("CLEAR-SLOT-AND-METHOD-CACHE", "(DEFUN CLEAR-SLOT-AND-METHOD-CACHE ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "clearSlotAndMethodCache", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("RESIZE-SLOT-CACHES", "(DEFUN RESIZE-SLOT-CACHES ((SIZE INTEGER)) :DOCUMENTATION \"Reset all slot caches to have size `size'.\")", Native.find_java_method("edu.isi.stella.Stella", "resizeSlotCaches", new java.lang.Class [] {java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("GET-SLOT", "(DEFUN (GET-SLOT SLOT) ((SELF STANDARD-OBJECT) (SLOT-NAME SYMBOL)) :DOCUMENTATION \"Return the slot named `slot-name' on the class\nrepresenting the type of `self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.StandardObject", "getSlot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("CONFORMING-TYPE-SPEC?", "(DEFUN (CONFORMING-TYPE-SPEC? BOOLEAN) ((SUB-TYPE-SPEC TYPE-SPEC) (SUPER-TYPE-SPEC TYPE-SPEC)))", Native.find_java_method("edu.isi.stella.StandardObject", "conformingTypeSpecP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("edu.isi.stella.StandardObject")}), null);
      Stella.defineMethodObject("(DEFMETHOD (CONFORMING-SIGNATURES? BOOLEAN) ((SELF SLOT) (SUPERSLOT SLOT)))", Native.find_java_method("edu.isi.stella.Slot", "conformingSignaturesP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CONFORMING-SIGNATURES? BOOLEAN) ((SELF STORAGE-SLOT) (SUPERSLOT SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "conformingSignaturesP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CONFORMING-SIGNATURES? BOOLEAN) ((SELF METHOD-SLOT) (SUPERSLOT SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "conformingSignaturesP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CONFORMING-SIGNATURES? BOOLEAN) ((SELF TABLE) (SUPERSLOT SLOT)))", Native.find_java_method("edu.isi.stella.Table", "conformingSignaturesP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("IDENTICAL-SIGNATURES?", "(DEFUN (IDENTICAL-SIGNATURES? BOOLEAN) ((METHOD1 METHOD-SLOT) (METHOD2 METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "identicalSignaturesP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot"), Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
      Stella.defineFunctionObject("COMPUTE-REQUIRED-SLOT-NAMES", "(DEFUN COMPUTE-REQUIRED-SLOT-NAMES ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "computeRequiredSlotNames", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("FREE-REQUIRED-SLOT-NAMES", "(DEFUN FREE-REQUIRED-SLOT-NAMES ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "freeRequiredSlotNames", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineMethodObject("(DEFMETHOD (DYNAMIC-STORAGE? BOOLEAN) ((SELF STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "dynamicStorageP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (PRIVATE? BOOLEAN) ((SELF RELATION)) :DOCUMENTATION \"Return `true' if `self' is not public.\" :PUBLIC? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Relation", "privateP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (PUBLIC? BOOLEAN) ((SELF SLOT)) :DOCUMENTATION \"True if `self' or one it its ancestors is marked public.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Slot", "publicP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (PUBLIC-SLOTS (ITERATOR OF SLOT)) ((SELF CLASS)) :DOCUMENTATION \"Return an iterator over public slots of `self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Class", "publicSlots", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (PUBLIC-SLOTS (ITERATOR OF SLOT)) ((SELF OBJECT)) :DOCUMENTATION \"Return an iterator over public slots of `self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "publicSlots", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (ALL-CLASS-SLOTS (ITERATOR OF SLOT)) ((SELF CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "allClassSlots", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (NEXT? BOOLEAN) ((SELF ALL-CLASS-SLOTS-ITERATOR)))", Native.find_java_method("edu.isi.stella.AllClassSlotsIterator", "nextP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CLASS-SLOTS (ITERATOR OF SLOT)) ((SELF CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "classSlots", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (LOCAL-SLOTS (LIST OF SLOT)) ((SELF CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "localSlots", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (DIRECT-SUPER-CLASSES (ITERATOR OF CLASS)) ((SELF CLASS)) :PUBLIC? TRUE :DOCUMENTATION \"Returns an iterator that generates all direct\nsuper classes of `self'.\")", Native.find_java_method("edu.isi.stella.Stella_Class", "directSuperClasses", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (SUPER-CLASSES (ITERATOR OF CLASS)) ((SELF CLASS)) :PUBLIC? TRUE :DOCUMENTATION \"Returns an iterator that generates all super classes\nof `self'.  Non-reflexive.\")", Native.find_java_method("edu.isi.stella.Stella_Class", "superClasses", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (ACTIVE? BOOLEAN) ((SLOT SLOT)))", Native.find_java_method("edu.isi.stella.Slot", "activeP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (INITIAL-VALUE OBJECT) ((SELF STORAGE-SLOT)) :DOCUMENTATION \"Return an initial value for `self', or `null'.  The\ninitial value can be defined by the slot itself, inherited from an\nequivalent slot, or inherit from the :initial-value option for the \nclass representing the type of `self'.\")", Native.find_java_method("edu.isi.stella.StorageSlot", "initialValue", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (SYSTEM-DEFAULT-VALUE OBJECT) ((SELF SLOT)) :DOCUMENTATION \"Return a default value expression, or if `self'\nhas dynamic storage, an initial value expression.\")", Native.find_java_method("edu.isi.stella.Slot", "systemDefaultValue", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (SYSTEM-DEFAULT-VALUE OBJECT) ((SELF STORAGE-SLOT)) :DOCUMENTATION \"Return a default value expression, or if `self'\nhas dynamic storage, an initial value expression.\")", Native.find_java_method("edu.isi.stella.StorageSlot", "systemDefaultValue", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (INITIALLY OBJECT) ((SELF STORAGE-SLOT)) :DOCUMENTATION \"Defines the value of a slot before it has been assigned\na value.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.StorageSlot", "initially", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("REPAIR-SLOTS", "(DEFUN REPAIR-SLOTS ())", Native.find_java_method("edu.isi.stella.Stella", "repairSlots", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("DISCONNECT-CLASSES", "(DEFUN DISCONNECT-CLASSES ())", Native.find_java_method("edu.isi.stella.Stella", "disconnectClasses", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("FILTER-UNBOUND-SURROGATE?", "(DEFUN (FILTER-UNBOUND-SURROGATE? BOOLEAN) ((SELF SURROGATE) (ITERATOR ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.Surrogate", "filterUnboundSurrogateP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("UNBOUND-SURROGATES", "(DEFUN (UNBOUND-SURROGATES (ITERATOR OF SURROGATE)) ((MODULE MODULE) (LOCAL? BOOLEAN)) :PUBLIC? TRUE :DOCUMENTATION \"Iterate over all unbound surrogates visible from `module'.\nLook at all modules if `module' is `null'.  If `local?', only consider\nsurrogates interned in `module'.\")", Native.find_java_method("edu.isi.stella.Module", "unboundSurrogates", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("NAME-TO-STRING", "(DEFUN (NAME-TO-STRING STRING) ((NAME OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"Return the string represented by `name'.  Return `null'\nif `name' is undefined or does not represent a string.\")", Native.find_java_method("edu.isi.stella.Stella_Object", "nameToString", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("PRINT-UNBOUND-SURROGATES", "(DEFUN PRINT-UNBOUND-SURROGATES (|&REST| (ARGS OBJECT)) :COMMAND? TRUE :PUBLIC? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Print all unbound surrogates visible from the module named by the first\nargument (a symbol or string).  Look at all modules if no module name or\n`null' was supplied.  If the second argument is `true', only consider\nsurrogates interned in the specified module.\")", Native.find_java_method("edu.isi.stella.Stella", "printUnboundSurrogates", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.stella.Cons", "printUnboundSurrogatesEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("COERCE-TO-SYMBOL", "(DEFUN (COERCE-TO-SYMBOL GENERALIZED-SYMBOL) ((NAME NAME)) :PUBLIC? TRUE :DOCUMENTATION \"Return the (generalized) symbol represented by `name'.\nReturn `null' if `name' is undefined or does not represent a string.\")", Native.find_java_method("edu.isi.stella.Stella_Object", "coerceToSymbol", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("PRINT-UNDEFINED-SUPER-CLASSES", "(DEFUN PRINT-UNDEFINED-SUPER-CLASSES ((CLASS NAME)) :COMMAND? TRUE :PUBLIC? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Print all undefined or bad (indirect) super classes of `class'.\")", Native.find_java_method("edu.isi.stella.Stella_Object", "printUndefinedSuperClasses", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
    }
  }

  public static void startupClasses() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupClasses.helpStartupClasses1();
          _StartupClasses.helpStartupClasses2();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Stella.$WARNIFREDEFINEp$.setDefaultValue(new Boolean(true));
          Stella.$UNFINALIZED_CLASSES$ = List.newList();
          Stella.$CLASSES_WITH_UNRESOLVED_CHILDREN_REFERENCES$ = List.newList();
          Stella.$CLASS_TAXONOMY_GRAPH$ = TaxonomyGraph.newTaxonomyGraph();
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("ALL-CLASS-SLOTS-ITERATOR", "(DEFCLASS ALL-CLASS-SLOTS-ITERATOR (ITERATOR) :PARAMETERS ((ANY-VALUE :TYPE SLOT)) :SLOTS ((ITERATOR-CONS-LIST :TYPE CONS) (ITERATOR-OBJECT :TYPE OBJECT)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.AllClassSlotsIterator", "newAllClassSlotsIterator", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.AllClassSlotsIterator", "accessAllClassSlotsIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllClassSlotsIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE ANY UNKNOWN)");
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupClasses.helpStartupClasses3();
          _StartupClasses.helpStartupClasses4();
          Stella.defineFunctionObject("COLLECT-BAD-SUPER-CLASSES", "(DEFUN (COLLECT-BAD-SUPER-CLASSES (LIST OF TYPE)) ((TYPE TYPE) (BADONES (LIST OF TYPE))) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "collectBadSuperClasses", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("ROOT-CLASS?", "(DEFUN (ROOT-CLASS? BOOLEAN) ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "rootClassP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("CREATE-CLASS-TAXONOMY", "(DEFUN CREATE-CLASS-TAXONOMY ())", Native.find_java_method("edu.isi.stella.Stella", "createClassTaxonomy", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("SUBCLASS-OF?", "(DEFUN (SUBCLASS-OF? BOOLEAN) ((SUBCLASS CLASS) (SUPERCLASS CLASS)) :DOCUMENTATION \"Return `true' if `subClass' is a subclass of `superClass'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Class", "subclassOfP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("FAST-SUBCLASS-OF?", "(DEFUN (FAST-SUBCLASS-OF? BOOLEAN) ((SUBCLASS CLASS) (SUPERCLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "fastSubclassOfP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("SUBTYPE-OF?", "(DEFUN (SUBTYPE-OF? BOOLEAN) ((SUB-TYPE TYPE) (SUPER-TYPE TYPE)) :DOCUMENTATION \"Return `true' iff the class named `sub-type' is a subclass \nof the class named `super-type'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "subtypeOfP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("ISA?", "(DEFUN (ISA? BOOLEAN) ((OBJECT OBJECT) (TYPE TYPE)) :DOCUMENTATION \"Return `true' iff `object' is an instance of the class named `type'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "isaP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("TAXONOMY-SUBCLASS-OF?", "(DEFUN (TAXONOMY-SUBCLASS-OF? BOOLEAN) ((SUBCLASS CLASS) (SUPERCLASS CLASS)) :GLOBALLY-INLINE? TRUE (RETURN (SUBCLASS-OF? SUBCLASS SUPERCLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "taxonomySubclassOfP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("TAXONOMY-ISA?", "(DEFUN (TAXONOMY-ISA? BOOLEAN) ((OBJECT OBJECT) (TYPE TYPE)) :GLOBALLY-INLINE? TRUE (RETURN (ISA? OBJECT TYPE)))", Native.find_java_method("edu.isi.stella.Stella_Object", "taxonomyIsaP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("INTERN-SLOTREF", "(DEFUN (INTERN-SLOTREF SLOTREF) ((CLASSNAME STRING) (SLOTNAME STRING)))", Native.find_java_method("edu.isi.stella.Stella", "internSlotref", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("LOOKUP-SLOTREF", "(DEFUN (LOOKUP-SLOTREF SLOTREF) ((SELF TYPE) (SLOTNAME SYMBOL)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Surrogate", "lookupSlotref", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("SLOTREF?", "(DEFUN (SLOTREF? BOOLEAN) ((SELF SURROGATE)))", Native.find_java_method("edu.isi.stella.Surrogate", "slotrefP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("LOOKUP-SLOT-FROM-SLOTREF", "(DEFUN (LOOKUP-SLOT-FROM-SLOTREF SLOT) ((SLOTREF SLOTREF)))", Native.find_java_method("edu.isi.stella.Surrogate", "lookupSlotFromSlotref", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("SLOTREF-TYPE", "(DEFUN (SLOTREF-TYPE TYPE) ((SLOTREF SLOTREF)))", Native.find_java_method("edu.isi.stella.Surrogate", "slotrefType", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
          Stella.defineFunctionObject("STARTUP-CLASSES", "(DEFUN STARTUP-CLASSES () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupClasses", "startupClasses", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_CLASSES);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupClasses"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *WARNIFREDEFINE?* BOOLEAN TRUE :DOCUMENTATION \"If set, warn about each redefinition.\" :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *UNFINALIZED-CLASSES* (LIST OF CLASS) (NEW LIST) :DOCUMENTATION \"List of classes whose class or slot inheritance is\ncurrently unfinalized.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *NEWLY-UNFINALIZED-CLASSES?* BOOLEAN FALSE :DOCUMENTATION \"Set to `true' by `remember-unfinalized-class'; set\nto `false' by `cleanup-unfinalized-classes'.  Minimizes the time that\n`finalize-classes' spends searching for classes to finalize.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CLASSES-WITH-UNRESOLVED-CHILDREN-REFERENCES* (LIST OF CLASS) (NEW LIST) :DOCUMENTATION \"List of classes defined with a :children option\nwhich still have some of their children references unresolved.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *SYMBOL-SLOT-OFFSET-COUNTER* INTEGER 0)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *SLOT-CACHE-SIZE* INTEGER 20)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CLASS-TAXONOMY-GRAPH* TAXONOMY-GRAPH (NEW TAXONOMY-GRAPH))");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
