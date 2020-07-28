//  -*- Mode: Java -*-
//
// _StartupCppTranslateFile.java

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

public class _StartupCppTranslateFile {
  public static void startupCppTranslateFile() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Stella.SYM_STELLA_AUXILIARY_VARIABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("AUXILIARY-VARIABLE", null, 0)));
          Stella.SYM_STELLA_CPP_FUNCTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_FUNCTION", null, 0)));
          Stella.SYM_STELLA_CPP_DEFPRINT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP_DEFPRINT", null, 0)));
          Stella.KWD_UPPERCASE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("UPPERCASE", null, 2)));
          Stella.SYM_STELLA_STARTUP_CPP_TRANSLATE_FILE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-CPP-TRANSLATE-FILE", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Stella.$CURRENT_STREAM$.setDefaultValue(Stella.STANDARD_OUTPUT);
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("CPPTRANS", "(DEFUN CPPTRANS ((STATEMENT OBJECT)) :COMMAND? TRUE :PUBLIC? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Translate `statement' to C++ and print the result.\")", Native.find_java_method("edu.isi.stella.Stella_Object", "cpptrans", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CPP-MAKE-CODE-OUTPUT-FILE-NAME", "(DEFUN (CPP-MAKE-CODE-OUTPUT-FILE-NAME FILE-NAME) ((FILENAME FILE-NAME)))", Native.find_java_method("edu.isi.stella.Stella", "cppMakeCodeOutputFileName", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("CPP-MAKE-HEADER-OUTPUT-FILE-NAME", "(DEFUN (CPP-MAKE-HEADER-OUTPUT-FILE-NAME FILE-NAME) ((FILENAME FILE-NAME)))", Native.find_java_method("edu.isi.stella.Stella", "cppMakeHeaderOutputFileName", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-FILE-HEADER", "(DEFUN CPP-OUTPUT-FILE-HEADER ((STREAM OUTPUT-STREAM) (FILE FILE-NAME)))", Native.find_java_method("edu.isi.stella.OutputStream", "cppOutputFileHeader", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-INCLUDE-DIRECTIVE", "(DEFUN CPP-OUTPUT-INCLUDE-DIRECTIVE ((FILENAME FILE-NAME) (STRIPDIRECTORY? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Stella", "cppOutputIncludeDirective", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("CPP-STANDALONE-OUTPUT-IMPORT-DECLARATIONS", "(DEFUN CPP-STANDALONE-OUTPUT-IMPORT-DECLARATIONS ((HEADERFILENAME FILE-NAME)))", Native.find_java_method("edu.isi.stella.Stella", "cppStandaloneOutputImportDeclarations", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("CPP-RELATIVIZE-HEADER-FILE", "(DEFUN (CPP-RELATIVIZE-HEADER-FILE FILE-NAME) ((HEADERFILE FILE-NAME) (SYSTEMNAME STRING)))", Native.find_java_method("edu.isi.stella.Stella", "cppRelativizeHeaderFile", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-IMPORT-DECLARATIONS", "(DEFUN CPP-OUTPUT-IMPORT-DECLARATIONS ((SYSTEMNAME STRING)))", Native.find_java_method("edu.isi.stella.Stella", "cppOutputImportDeclarations", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-CLASS-HEAD-DECLARATIONS", "(DEFUN CPP-OUTPUT-CLASS-HEAD-DECLARATIONS ((CLASSES CONS)))", Native.find_java_method("edu.isi.stella.Cons", "cppOutputClassHeadDeclarations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-NAMESPACE-HEADER", "(DEFUN CPP-OUTPUT-NAMESPACE-HEADER ((MODULE MODULE)))", Native.find_java_method("edu.isi.stella.Module", "cppOutputNamespaceHeader", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-NAMESPACE-FOOTER", "(DEFUN CPP-OUTPUT-NAMESPACE-FOOTER ((MODULE MODULE)))", Native.find_java_method("edu.isi.stella.Module", "cppOutputNamespaceFooter", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
          Stella.defineFunctionObject("CPP-UNIT-DEFINES-MAIN?", "(DEFUN (CPP-UNIT-DEFINES-MAIN? BOOLEAN) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "cppUnitDefinesMainP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
          Stella.defineFunctionObject("CPP-YIELD-MAIN-FILE-NAME", "(DEFUN (CPP-YIELD-MAIN-FILE-NAME FILE-NAME) ())", Native.find_java_method("edu.isi.stella.Stella", "cppYieldMainFileName", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-MAIN", "(DEFUN CPP-OUTPUT-MAIN ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "cppOutputMain", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
          Stella.defineFunctionObject("CPP-SORT-UNITS-FOR-HEADER-FILE", "(DEFUN (CPP-SORT-UNITS-FOR-HEADER-FILE (LIST OF (CONS OF TRANSLATION-UNIT))) ((FILEUNITS (LIST OF TRANSLATION-UNIT))))", Native.find_java_method("edu.isi.stella.List", "cppSortUnitsForHeaderFile", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-NAMESPACE-CHANGE", "(DEFUN CPP-OUTPUT-NAMESPACE-CHANGE ((FROMNAMESPACE MODULE) (TONAMESPACE MODULE)))", Native.find_java_method("edu.isi.stella.Module", "cppOutputNamespaceChange", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.stella.Module")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-ALL-UNITS-TO-FILE", "(DEFUN CPP-OUTPUT-ALL-UNITS-TO-FILE ((FILENAME FILE-NAME)))", Native.find_java_method("edu.isi.stella.Stella", "cppOutputAllUnitsToFile", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-FILE", "(DEFUN CPP-TRANSLATE-FILE ((FILENAME FILE-NAME)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "cppTranslateFile", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("CPP-STANDALONE-TRANSLATE-FILE", "(DEFUN CPP-STANDALONE-TRANSLATE-FILE ((FILENAME FILE-NAME)))", Native.find_java_method("edu.isi.stella.Stella", "cppStandaloneTranslateFile", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-SYSTEM", "(DEFUN CPP-TRANSLATE-SYSTEM ((SYSTEMNAME STRING)) :DOCUMENTATION \"Translate the system `systemName' to C++.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "cppTranslateSystem", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("CPP-TRANSLATE-WALKED-SYSTEM-UNITS", "(DEFUN CPP-TRANSLATE-WALKED-SYSTEM-UNITS ((SYSTEMUNITS SYSTEM-UNITS-ALIST)))", Native.find_java_method("edu.isi.stella.KeyValueList", "cppTranslateWalkedSystemUnits", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-SYSTEM-SPECIFIC-FILES", "(DEFUN CPP-OUTPUT-SYSTEM-SPECIFIC-FILES ())", Native.find_java_method("edu.isi.stella.Stella", "cppOutputSystemSpecificFiles", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("CPP-YIELD-SYSTEM-HEADER-FILE-NAME", "(DEFUN (CPP-YIELD-SYSTEM-HEADER-FILE-NAME STRING) ((SYSTEMNAME STRING)))", Native.find_java_method("edu.isi.stella.Stella", "cppYieldSystemHeaderFileName", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("CPP-YIELD-SYSTEM-HEADER-FILE-GUARD", "(DEFUN (CPP-YIELD-SYSTEM-HEADER-FILE-GUARD STRING) ((SYSTEMNAME STRING)))", Native.find_java_method("edu.isi.stella.Stella", "cppYieldSystemHeaderFileGuard", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-SYSTEM-HEADER-FILE", "(DEFUN CPP-OUTPUT-SYSTEM-HEADER-FILE ())", Native.find_java_method("edu.isi.stella.Stella", "cppOutputSystemHeaderFile", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("CPP-YIELD-SYSTEMS-ROOT-DIRECTORY", "(DEFUN (CPP-YIELD-SYSTEMS-ROOT-DIRECTORY STRING) ())", Native.find_java_method("edu.isi.stella.Stella", "cppYieldSystemsRootDirectory", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("CPP-YIELD-STELLA-ROOT-DIRECTORY", "(DEFUN (CPP-YIELD-STELLA-ROOT-DIRECTORY STRING) ())", Native.find_java_method("edu.isi.stella.Stella", "cppYieldStellaRootDirectory", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("CPP-OUTPUT-SYSTEM-MAKEFILE", "(DEFUN CPP-OUTPUT-SYSTEM-MAKEFILE ())", Native.find_java_method("edu.isi.stella.Stella", "cppOutputSystemMakefile", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("SUBSTITUTE-TEMPLATE-VARIABLES-IN-STRING", "(DEFUN (SUBSTITUTE-TEMPLATE-VARIABLES-IN-STRING STRING) ((STRING STRING) (VARIABLES (KEY-VALUE-LIST OF STRING-WRAPPER STRING-WRAPPER))))", Native.find_java_method("edu.isi.stella.Stella", "substituteTemplateVariablesInString", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
          Stella.defineFunctionObject("SUBSTITUTE-TEMPLATE-VARIABLES-TO-STREAM", "(DEFUN SUBSTITUTE-TEMPLATE-VARIABLES-TO-STREAM ((TEMPLATESTREAM INPUT-STREAM) (OUTPUTSTREAM OUTPUT-STREAM) (VARIABLES (KEY-VALUE-LIST OF STRING-WRAPPER STRING-WRAPPER))))", Native.find_java_method("edu.isi.stella.InputStream", "substituteTemplateVariablesToStream", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.InputStream"), Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
          Stella.defineFunctionObject("SUBSTITUTE-TEMPLATE-VARIABLES-TO-MAKEFILE", "(DEFUN SUBSTITUTE-TEMPLATE-VARIABLES-TO-MAKEFILE ((TEMPLATEFILE STRING) (OUTPUTFILE STRING) (VARIABLES (KEY-VALUE-LIST OF STRING-WRAPPER STRING-WRAPPER))))", Native.find_java_method("edu.isi.stella.Stella", "substituteTemplateVariablesToMakefile", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
          Stella.defineFunctionObject("STARTUP-CPP-TRANSLATE-FILE", "(DEFUN STARTUP-CPP-TRANSLATE-FILE () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupCppTranslateFile", "startupCppTranslateFile", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_CPP_TRANSLATE_FILE);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupCppTranslateFile"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *CURRENT-STREAM* OUTPUT-STREAM STANDARD-OUTPUT)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CPP-TRANSLATED-FILE-SUFFIX* STRING \"\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *MAKEFILE-TEMPLATE-VARIABLE-PREFIX* STRING \"#$\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
