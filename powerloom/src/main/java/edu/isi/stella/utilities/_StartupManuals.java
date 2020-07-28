//  -*- Mode: Java -*-
//
// _StartupManuals.java

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
| Portions created by the Initial Developer are Copyright (C) 2001-2017      |
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

package edu.isi.stella.utilities;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.stella.*;

public class _StartupManuals {
  static void helpStartupManuals1() {
    {
      Utilities.SGT_STELLA_CONS = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONS", Stella.getStellaModule("/STELLA", true), 1)));
      Utilities.SGT_STELLA_TYPE_SPEC = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TYPE-SPEC", Stella.getStellaModule("/STELLA", true), 1)));
      Utilities.SYM_STELLA_VARIABLE_TYPE_SPECIFIER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-TYPE-SPECIFIER", Stella.getStellaModule("/STELLA", true), 0)));
      Utilities.SYM_STELLA_DOCUMENTATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DOCUMENTATION", Stella.getStellaModule("/STELLA", true), 0)));
      Utilities.SYM_STELLA_SLOT_TYPE_SPECIFIER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT-TYPE-SPECIFIER", Stella.getStellaModule("/STELLA", true), 0)));
      Utilities.SYM_STELLA_aREST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("&REST", Stella.getStellaModule("/STELLA", true), 0)));
      Utilities.SYM_STELLA_aBODY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("&BODY", Stella.getStellaModule("/STELLA", true), 0)));
      Utilities.SYM_STELLA_METHOD_MACROp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-MACRO?", Stella.getStellaModule("/STELLA", true), 0)));
      Utilities.SYM_STELLA_METHOD_COMMANDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-COMMAND?", Stella.getStellaModule("/STELLA", true), 0)));
      Utilities.SYM_STELLA_METHOD_VARIABLE_ARGUMENTSp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-VARIABLE-ARGUMENTS?", Stella.getStellaModule("/STELLA", true), 0)));
      Utilities.SYM_STELLA_METHOD_BODY_ARGUMENTp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-BODY-ARGUMENT?", Stella.getStellaModule("/STELLA", true), 0)));
      Utilities.KWD_INFIX_PARAMETER_LISTS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INFIX-PARAMETER-LISTS", null, 2)));
      Utilities.KWD_TEXINFO = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TEXINFO", null, 2)));
      Utilities.SGT_STELLA_SLOT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOT", Stella.getStellaModule("/STELLA", true), 1)));
      Utilities.SGT_STELLA_GLOBAL_VARIABLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("GLOBAL-VARIABLE", Stella.getStellaModule("/STELLA", true), 1)));
      Utilities.SGT_STELLA_MODULE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE", Stella.getStellaModule("/STELLA", true), 1)));
      Utilities.SYM_UTILITIES_MANUAL_DESCRIBE_OBJECT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MANUAL-DESCRIBE-OBJECT", null, 0)));
      Utilities.SYM_UTILITIES_STARTUP_MANUALS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-MANUALS", null, 0)));
      Utilities.SYM_STELLA_METHOD_STARTUP_CLASSNAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-STARTUP-CLASSNAME", Stella.getStellaModule("/STELLA", true), 0)));
    }
  }

  public static void startupManuals() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/UTILITIES", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupManuals.helpStartupManuals1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Utilities.$TEXINFO_STYLE_FEATURES$ = List.list(Stella.NIL);
          Utilities.$TEXINFO_WORD_DELIMITERS$ = null;
          Utilities.$MANUAL_OUTPUT_LANGUAGE$.setDefaultValue(Utilities.KWD_TEXINFO);
          Utilities.$DOCUMENTED_OBJECTS_REGISTRY$ = HashTable.newHashTable();
          Utilities.$MANUAL_OUTPUT_STREAM$.setDefaultValue(null);
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("TEXINFO-SPECIAL-CHARACTER?", "(DEFUN (TEXINFO-SPECIAL-CHARACTER? BOOLEAN) ((CH CHARACTER)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "texinfoSpecialCharacterP", new java.lang.Class [] {java.lang.Character.TYPE}), null);
          Stella.defineFunctionObject("TEXINFO-ESCAPE-STRING", "(DEFUN (TEXINFO-ESCAPE-STRING STRING) ((STRING STRING)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "texinfoEscapeString", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("YIELD-TEXINFO-TYPE-SPEC", "(DEFUN (YIELD-TEXINFO-TYPE-SPEC STRING) ((TYPE-SPEC OBJECT)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "yieldTexinfoTypeSpec", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("YIELD-TEXINFO-BARE-NAME", "(DEFUN (YIELD-TEXINFO-BARE-NAME STRING) ((NAME OBJECT)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "yieldTexinfoBareName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("YIELD-TEXINFO-PARAMETER-NAME", "(DEFUN (YIELD-TEXINFO-PARAMETER-NAME STRING) ((NAME STRING)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "yieldTexinfoParameterName", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("YIELD-TEXINFO-CONSTANT", "(DEFUN (YIELD-TEXINFO-CONSTANT STRING) ((NAME SYMBOL)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "yieldTexinfoConstant", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("TEXINFO-GET-PARAGRAPH-COMMAND", "(DEFUN (TEXINFO-GET-PARAGRAPH-COMMAND STRING) ((STRING STRING) (START INTEGER)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "texinfoGetParagraphCommand", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("TEXINFO-DESCRIBE-DOCUMENTATION-STRING", "(DEFUN TEXINFO-DESCRIBE-DOCUMENTATION-STRING ((OBJECT OBJECT) (DOCUMENTATION STRING) (STREAM OUTPUT-STREAM) (PARAMETERS (LIST OF SYMBOL))))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "texinfoDescribeDocumentationString", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("TEXINFO-DESCRIBE-VARIABLE", "(DEFUN TEXINFO-DESCRIBE-VARIABLE ((VARIABLE GLOBAL-VARIABLE) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "texinfoDescribeVariable", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GlobalVariable"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("TEXINFO-DESCRIBE-CLASS", "(DEFUN TEXINFO-DESCRIBE-CLASS ((CLASS CLASS) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "texinfoDescribeClass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("TEXINFO-DESCRIBE-SLOT", "(DEFUN TEXINFO-DESCRIBE-SLOT ((SLOT STORAGE-SLOT) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "texinfoDescribeSlot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StorageSlot"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("TEXINFO-GET-REAL-METHOD-PARAMETER-NAMES", "(DEFUN (TEXINFO-GET-REAL-METHOD-PARAMETER-NAMES (LIST OF STRING-WRAPPER)) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "texinfoGetRealMethodParameterNames", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("TEXINFO-GET-REAL-METHOD-PARAMETERS-AND-TYPES", "(DEFUN (TEXINFO-GET-REAL-METHOD-PARAMETERS-AND-TYPES (LIST OF STRING-WRAPPER) LIST LIST) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "texinfoGetRealMethodParametersAndTypes", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot"), Native.find_java_class("[Ljava.lang.Object;")}), null);
          Stella.defineFunctionObject("TEXINFO-DESCRIBE-METHOD", "(DEFUN TEXINFO-DESCRIBE-METHOD ((METHOD METHOD-SLOT) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "texinfoDescribeMethod", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("TEXINFO-DESCRIBE-TYPE-DECLARATION", "(DEFUN TEXINFO-DESCRIBE-TYPE-DECLARATION ((PARAMETER STRING) (TYPE TYPE-SPEC) (MODIFIER STRING) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "texinfoDescribeTypeDeclaration", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.StandardObject"), Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("TEXINFO-DESCRIBE-UNIMPLEMENTED-OBJECT", "(DEFUN TEXINFO-DESCRIBE-UNIMPLEMENTED-OBJECT ((SPECIFICATION OBJECT) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "texinfoDescribeUnimplementedObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("REGISTER-DOCUMENTED-OBJECT", "(DEFUN REGISTER-DOCUMENTED-OBJECT ((OBJECT OBJECT)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "registerDocumentedObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("ALREADY-DOCUMENTED-OBJECT?", "(DEFUN (ALREADY-DOCUMENTED-OBJECT? BOOLEAN) ((OBJECT OBJECT)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "alreadyDocumentedObjectP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CLEAR-DOCUMENTED-OBJECTS-REGISTRY", "(DEFUN CLEAR-DOCUMENTED-OBJECTS-REGISTRY ())", Native.find_java_method("edu.isi.stella.utilities.Utilities", "clearDocumentedObjectsRegistry", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("LOOKUP-OBJECT-FROM-SPECIFICATION", "(DEFUN (LOOKUP-OBJECT-FROM-SPECIFICATION OBJECT) ((SPECIFICATION OBJECT)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "lookupObjectFromSpecification", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("TEXINFO-OBJECT<", "(DEFUN (TEXINFO-OBJECT< BOOLEAN) ((OBJECT1 OBJECT) (OBJECT2 OBJECT)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "texinfoObjectL", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("MANUAL-DESCRIBE-UNCATEGORIZED-OBJECTS", "(DEFUN MANUAL-DESCRIBE-UNCATEGORIZED-OBJECTS ((MODULE MODULE) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "manualDescribeUncategorizedObjects", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("MANUAL-DESCRIBE-OBJECT", "(DEFUN MANUAL-DESCRIBE-OBJECT ((OBJECT OBJECT) (SPECIFICATION OBJECT) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "manualDescribeObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("GENERATE-MANUAL", "(DEFUN GENERATE-MANUAL ((MANUAL-SPEC (CONS OF CONS))) :DOCUMENTATION \"Generate a TEXINFO file containing a list of\ndocumented commands.  'manual-spec' is a CONS list of entries, where each\nentry is of the following form:\n\n      (<filename> <object-spec1> <object-spec2> ... <object-specN>)\n\nThe objects specified by <object-spec>s will be documented in sequence onto\nfile <filename>.  An object spec can be a simple symbol to name a function,\nmacro or variable, a dotted symbol to name a method or slot, a surrogate\nto name a class, or a string (pathname) to name a module.  If a module is\nspecified, all as yet undocumented objects in that module that have a\ndocumentation string defined will be documented (this is a catch-all option).\")", Native.find_java_method("edu.isi.stella.utilities.Utilities", "generateManual", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("GENERATE-MANUAL-FROM-TEMPLATE", "(DEFUN GENERATE-MANUAL-FROM-TEMPLATE ((TEMPLATEFILE FILE-NAME) (OUTPUTFILE FILE-NAME)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "generateManualFromTemplate", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("MANUAL-EXPAND-TEMPLATE-COMMANDS", "(DEFUN (MANUAL-EXPAND-TEMPLATE-COMMANDS STRING) ((LINE STRING)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "manualExpandTemplateCommands", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("TEXINFO-INSERT-DOC", "(DEFUN TEXINFO-INSERT-DOC ((SPEC OBJECT)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.stella.utilities.Utilities", "texinfoInsertDoc", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("TEXINFO-INSERT-PREAMBLE", "(DEFUN TEXINFO-INSERT-PREAMBLE () :COMMAND? TRUE)", Native.find_java_method("edu.isi.stella.utilities.Utilities", "texinfoInsertPreamble", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("STARTUP-MANUALS", "(DEFUN STARTUP-MANUALS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.utilities._StartupManuals", "startupManuals", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Utilities.SYM_UTILITIES_STARTUP_MANUALS);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Utilities.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupManuals"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("UTILITIES")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *TEXINFO-STYLE-FEATURES* (LIST OF KEYWORD) (LIST) :DOCUMENTATION \"A list of features that can modulate some aspects of\nhow certain objects are described.  Currently understood features:\n:INFIX-PARAMETER-LISTS.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *TEXINFO-WORD-DELIMITERS* STRING NULL)");
          { StringBuffer delimiters = new StringBuffer("     .:;,!?()[]{}\"");

            edu.isi.stella.javalib.Native.mutableString_nthSetter(delimiters, ' ', 0);
            edu.isi.stella.javalib.Native.mutableString_nthSetter(delimiters, '\t', 1);
            edu.isi.stella.javalib.Native.mutableString_nthSetter(delimiters, '\n', 2);
            edu.isi.stella.javalib.Native.mutableString_nthSetter(delimiters, '\r', 3);
            edu.isi.stella.javalib.Native.mutableString_nthSetter(delimiters, '\f', 4);
            Utilities.$TEXINFO_WORD_DELIMITERS$ = delimiters.toString();
          }
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *MANUAL-OUTPUT-LANGUAGE* KEYWORD :TEXINFO)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *DOCUMENTED-OBJECTS-REGISTRY* HASH-TABLE (NEW HASH-TABLE))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *MANUAL-OUTPUT-STREAM* OUTPUT-STREAM NULL)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *MANUAL-TEMPLATE-COMMAND-PREFIX* STRING \"#$\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
