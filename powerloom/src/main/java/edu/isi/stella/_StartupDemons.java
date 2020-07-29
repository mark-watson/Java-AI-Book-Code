//  -*- Mode: Java -*-
//
// _StartupDemons.java

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

public class _StartupDemons {
  static void helpStartupDemons1() {
    {
      Stella.KWD_MODIFY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MODIFY", null, 2)));
      Stella.KWD_ALL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ALL", null, 2)));
      Stella.KWD_SLOT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT", null, 2)));
      Stella.KWD_CODE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CODE", null, 2)));
      Stella.KWD_GUARDp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("GUARD?", null, 2)));
      Stella.KWD_INHERITEDp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INHERITED?", null, 2)));
      Stella.KWD_ACTIVATEp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ACTIVATE?", null, 2)));
      Stella.SYM_STELLA_DEFINE_DEMON = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFINE-DEMON", null, 0)));
      Stella.SYM_STELLA_OWNER_INSTANCE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OWNER-INSTANCE", null, 0)));
      Stella.SYM_STELLA_ACTIVE_SLOT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ACTIVE-SLOT", null, 0)));
      Stella.SYM_STELLA_GET_SLOT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("GET-SLOT", null, 0)));
      Stella.SYM_STELLA_CANT_OVERWRITE_ACTIVE_COLLECTION_SLOT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CANT-OVERWRITE-ACTIVE-COLLECTION-SLOT", null, 0)));
      Stella.SYM_STELLA_CHECK_FOR_SLOT_DEMONSp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CHECK-FOR-SLOT-DEMONS?", null, 0)));
      Stella.SYM_STELLA_WRAPPEDOLDVALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WRAPPEDOLDVALUE", null, 0)));
      Stella.SYM_STELLA_WRAPPEDNEWVALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WRAPPEDNEWVALUE", null, 0)));
      Stella.SYM_STELLA_RUN_SLOT_GUARD_DEMONSp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RUN-SLOT-GUARD-DEMONS?", null, 0)));
      Stella.SYM_STELLA_RUN_SLOT_DEMONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RUN-SLOT-DEMONS", null, 0)));
      Stella.SGT_STELLA_HOOK_LIST = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("HOOK-LIST", null, 1)));
      Stella.SYM_STELLA_SIGNATURE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SIGNATURE", null, 0)));
      Stella.SYM_STELLA_STARTUP_DEMONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-DEMONS", null, 0)));
    }
  }

  public static void startupDemons() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupDemons.helpStartupDemons1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Stella.$DEMONS_TABLE$ = StringHashTable.newStringHashTable();
          Stella.$CHANGE_MODULE_HOOKS$ = HookList.newHookList();
          Stella.$CLEAR_MODULE_HOOKS$ = HookList.newHookList();
          Stella.$DESTROY_CONTEXT_HOOKS$ = HookList.newHookList();
          Stella.$REDEFINE_RELATION_HOOKS$ = HookList.newHookList();
          Stella.$FINALIZE_RELATION_HOOKS$ = HookList.newHookList();
          Stella.$BLOCK_NATIVE_CLASS_CREATION_HOOKS$ = HookList.newHookList();
          Stella.$STELLA_EXIT_HOOKS$ = HookList.newHookList();
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("HOOK-LIST", "(DEFCLASS HOOK-LIST (KEY-VALUE-LIST) :DOCUMENTATION \"Each HOOK-LIST object contains a list of zero or\nmore function codes that get funcall'd some procedure.\" :PARAMETERS ((ANY-KEY :TYPE SYMBOL) (ANY-VALUE :TYPE FUNCTION-CODE-WRAPPER)) :SLOTS ((SIGNATURE :TYPE STRING) (DOCUMENTATION :TYPE STRING)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.HookList", "newHookList", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.HookList", "accessHookListSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.HookList"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("VALIDATE-DEMON-REFERENCES?", "(DEFUN (VALIDATE-DEMON-REFERENCES? BOOLEAN) ((DEMON DEMON)))", Native.find_java_method("edu.isi.stella.Demon", "validateDemonReferencesP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Demon")}), null);
          Stella.defineFunctionObject("INCORPORATE-DEMON-OPTIONS?", "(DEFUN (INCORPORATE-DEMON-OPTIONS? BOOLEAN) ((DEMON DEMON) (OPTIONS PROPERTY-LIST)))", Native.find_java_method("edu.isi.stella.Demon", "incorporateDemonOptionsP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Demon"), Native.find_java_class("edu.isi.stella.PropertyList")}), null);
          Stella.defineFunctionObject("LOOKUP-DEMON", "(DEFUN (LOOKUP-DEMON DEMON) ((NAME STRING)) :DOCUMENTATION \"Return the demon named `name'.\")", Native.find_java_method("edu.isi.stella.Stella", "lookupDemon", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("DEFINE-DEMON", "(DEFUN (DEFINE-DEMON DEMON) ((NAME STRING) |&REST| (OPTIONS OBJECT)) :DOCUMENTATION \"Define a class or slot demon.  Options are :create,\n:destroy, :class, :slot, :guard?, :code, :method, :inherit?, and :documentation.\")", Native.find_java_method("edu.isi.stella.Stella", "defineDemon", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("INJECT-DEMON", "(DEFUN (INJECT-DEMON (LIST OF DEMON)) ((DEMONLIST (LIST OF DEMON)) (DEMON DEMON)))", Native.find_java_method("edu.isi.stella.List", "injectDemon", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.Demon")}), null);
          Stella.defineFunctionObject("EJECT-DEMON", "(DEFUN (EJECT-DEMON (LIST OF DEMON)) ((DEMONLIST (LIST OF DEMON)) (DEMON DEMON)))", Native.find_java_method("edu.isi.stella.List", "ejectDemon", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.Demon")}), null);
          Stella.defineFunctionObject("ACTIVATE-DEMON", "(DEFUN ACTIVATE-DEMON ((DEMON DEMON)) :DOCUMENTATION \"Install `demon' in the location(s) specified by its internal\nstructure.\")", Native.find_java_method("edu.isi.stella.Demon", "activateDemon", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Demon")}), null);
          Stella.defineFunctionObject("DEACTIVATE-DEMON", "(DEFUN DEACTIVATE-DEMON ((DEMON DEMON)) :DOCUMENTATION \"Detach `demon' from the location(s) specified by its internal\nstructure.\")", Native.find_java_method("edu.isi.stella.Demon", "deactivateDemon", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Demon")}), null);
          Stella.defineFunctionObject("DESTRUCTURE-DEFDEMON-BODY", "(DEFUN (DESTRUCTURE-DEFDEMON-BODY CONS CONS) ((DEMONTREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "destructureDefdemonBody", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("[Ljava.lang.Object;")}), null);
          Stella.defineFunctionObject("IN-PLACE-NORMALIZE-DEMON-OPTIONS", "(DEFUN IN-PLACE-NORMALIZE-DEMON-OPTIONS ((OPTIONSTREE CONS)))", Native.find_java_method("edu.isi.stella.Cons", "inPlaceNormalizeDemonOptions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("DEFDEMON", "(DEFUN DEFDEMON ((NAME STRING-WRAPPER) (PARAMETERSTREE CONS) |&BODY| (OPTIONSANDBODY CONS)) :TYPE OBJECT :MACRO? TRUE :DOCUMENTATION \"Define a demon `name' and attach it to a class or slot.\" :PUBLIC? TRUE :LISP-MACRO? TRUE)", Native.find_java_method("edu.isi.stella.StringWrapper", "defdemon", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("READ-SLOT-VALUE", "(DEFUN (READ-SLOT-VALUE OBJECT) ((SELF STANDARD-OBJECT) (SLOT STORAGE-SLOT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.StandardObject", "readSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
          Stella.defineFunctionObject("WRITE-SLOT-VALUE", "(DEFUN (WRITE-SLOT-VALUE OBJECT) ((SELF STANDARD-OBJECT) (SLOT STORAGE-SLOT) (VALUE OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.StandardObject", "writeSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("PUT-SLOT-VALUE", "(DEFUN (PUT-SLOT-VALUE OBJECT) ((SELF STANDARD-OBJECT) (SLOT STORAGE-SLOT) (VALUE OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.StandardObject", "putSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("DROP-SLOT-VALUE", "(DEFUN DROP-SLOT-VALUE ((SELF STANDARD-OBJECT) (SLOT STORAGE-SLOT) (VALUE OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.StandardObject", "dropSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CHECK-FOR-SLOT-DEMONS?", "(DEFUN (CHECK-FOR-SLOT-DEMONS? BOOLEAN) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "checkForSlotDemonsP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
          Stella.defineFunctionObject("RUN-SLOT-GUARD-DEMONS?", "(DEFUN (RUN-SLOT-GUARD-DEMONS? BOOLEAN) ((SELF STANDARD-OBJECT) (SLOT STORAGE-SLOT) (OLDVALUE OBJECT) (NEWVALUE OBJECT)))", Native.find_java_method("edu.isi.stella.StandardObject", "runSlotGuardDemonsP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("RUN-SLOT-DEMONS", "(DEFUN RUN-SLOT-DEMONS ((SELF STANDARD-OBJECT) (SLOT STORAGE-SLOT) (OLDVALUE OBJECT) (NEWVALUE OBJECT)))", Native.find_java_method("edu.isi.stella.StandardObject", "runSlotDemons", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("RUN-CONSTRUCTOR-DEMONS", "(DEFUN RUN-CONSTRUCTOR-DEMONS ((SELF STANDARD-OBJECT)))", Native.find_java_method("edu.isi.stella.StandardObject", "runConstructorDemons", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject")}), null);
          Stella.defineFunctionObject("RUN-DESTRUCTOR-DEMONS", "(DEFUN RUN-DESTRUCTOR-DEMONS ((SELF STANDARD-OBJECT)))", Native.find_java_method("edu.isi.stella.StandardObject", "runDestructorDemons", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject")}), null);
          Stella.defineFunctionObject("YIELD-ACTIVE-SLOT-READER-BODY", "(DEFUN (YIELD-ACTIVE-SLOT-READER-BODY CONS) ((SLOT STORAGE-SLOT) (DEFAULTEXPRESSION OBJECT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldActiveSlotReaderBody", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CANT-OVERWRITE-ACTIVE-COLLECTION-SLOT", "(DEFUN CANT-OVERWRITE-ACTIVE-COLLECTION-SLOT ((SELF STANDARD-OBJECT) (SLOTNAME SYMBOL)))", Native.find_java_method("edu.isi.stella.StandardObject", "cantOverwriteActiveCollectionSlot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("YIELD-ACTIVE-SLOT-WRITER-BODY", "(DEFUN (YIELD-ACTIVE-SLOT-WRITER-BODY CONS) ((SLOT STORAGE-SLOT)))", Native.find_java_method("edu.isi.stella.StorageSlot", "yieldActiveSlotWriterBody", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot")}), null);
          Stella.defineMethodObject("(DEFMETHOD INSERT ((SELF ACTIVE-LIST) (VALUE (LIKE (ANY-VALUE SELF)))))", Native.find_java_method("edu.isi.stella.ActiveList", "insert", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD INSERT ((SELF ACTIVE-SET) (VALUE (LIKE (ANY-VALUE SELF)))))", Native.find_java_method("edu.isi.stella.ActiveSet", "insert", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (REMOVE ACTIVE-LIST) ((SELF ACTIVE-LIST) (VALUE (LIKE (ANY-VALUE SELF)))))", Native.find_java_method("edu.isi.stella.ActiveList", "remove", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (REMOVE ACTIVE-SET) ((SELF ACTIVE-SET) (VALUE (LIKE (ANY-VALUE SELF)))))", Native.find_java_method("edu.isi.stella.ActiveSet", "remove", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("ADD-HOOK", "(DEFUN ADD-HOOK ((HOOKLIST HOOK-LIST) (HOOKFUNCTION SYMBOL)) :PUBLIC? TRUE :DOCUMENTATION \"Insert the function named `hookFunction' into `hookList'.\")", Native.find_java_method("edu.isi.stella.HookList", "addHook", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.HookList"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("DROP-HOOK", "(DEFUN DROP-HOOK ((HOOKLIST HOOK-LIST) (HOOKFUNCTION SYMBOL)) :PUBLIC? TRUE :DOCUMENTATION \"Remove the function named `hookFunction' from `hookList'.\")", Native.find_java_method("edu.isi.stella.HookList", "dropHook", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.HookList"), Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("RUN-HOOKS", "(DEFUN RUN-HOOKS ((HOOKLIST HOOK-LIST) (ARGUMENT OBJECT)) :DOCUMENTATION \"Run all hook functions in `hooklist', applying\neach one to `argument'.\")", Native.find_java_method("edu.isi.stella.HookList", "runHooks", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.HookList"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("STARTUP-DEMONS", "(DEFUN STARTUP-DEMONS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupDemons", "startupDemons", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_DEMONS);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupDemons"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *DEMONS-TABLE* STRING-HASH-TABLE (NEW STRING-HASH-TABLE) :DOCUMENTATION \"Table containing all active and inactive demons, indexed\non their names.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CONSTRUCTOR-DEMONS* (LIST OF DEMON) NULL :DOCUMENTATION \"These demons trigger every time an active instance is created.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *DESTRUCTOR-DEMONS* (LIST OF DEMON) NULL :DOCUMENTATION \"These demons trigger every time an active instance is destroyed.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *ALL-SLOTS-DEMONS* (LIST OF DEMON) NULL :DOCUMENTATION \"These demons trigger every time a slot value is modified.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *ALL-SLOTS-GUARD-DEMONS* (LIST OF DEMON) NULL :DOCUMENTATION \"These demons trigger every time a slot value is modified, and\ncancel slot update when they return `false'.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CHANGE-MODULE-HOOKS* HOOK-LIST (NEW HOOK-LIST) :DOCUMENTATION \"HOOK-LIST called by `in-module', applied to a\n`module' argument.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CLEAR-MODULE-HOOKS* HOOK-LIST (NEW HOOK-LIST) :DOCUMENTATION \"HOOK-LIST called by `clear-module', applied to a\n`module' argument.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *DESTROY-CONTEXT-HOOKS* HOOK-LIST (NEW HOOK-LIST) :DOCUMENTATION \"HOOK-LIST called by `clear-module', applied to a\n`module' argument.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *REDEFINE-RELATION-HOOKS* HOOK-LIST (NEW HOOK-LIST) :DOCUMENTATION \"HOOK-LIST is called by `undefine-old-class'.  Each\nhook function is passed a LIST of two RELATION objects; the first is the\nold relation object and the second is the new (redefined) relation object.\nThe hook functions are expected to copy/transfer information from the\nold relation to the new relation so that it won't be lost.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *FINALIZE-RELATION-HOOKS* HOOK-LIST (NEW HOOK-LIST) :DOCUMENTATION \"HOOK-LIST is called by `finalize-one-class'\nand `finalize-local-slot', applied to a RELATION argument.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *BLOCK-NATIVE-CLASS-CREATION-HOOKS* HOOK-LIST (NEW HOOK-LIST) :DOCUMENTATION \"HOOK-LIST called by `create-native-class', applied to\na STELLA class.  Return value of TRUE blocks creation.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *STELLA-EXIT-HOOKS* HOOK-LIST (NEW HOOK-LIST) :DOCUMENTATION \"HOOK-LIST of cleanup functions to be called upon exit from\nthe STELLA application or any point where such cleanup is required.  The\nfunctions on this list should be highly tolerant of their invocation environment\nand not assume any special state; that is, they should be no-ops if no special\ncleanup is required.\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
