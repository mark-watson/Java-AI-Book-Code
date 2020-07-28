//  -*- Mode: Java -*-
//
// _StartupJavaTranslateFile.java

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

public class _StartupJavaTranslateFile {
  public static void startupJavaTranslateFile() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Stella.SYM_STELLA_STARTUP_JAVA_TRANSLATE_FILE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-JAVA-TRANSLATE-FILE", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Stella.$CURRENT_JAVA_OUTPUT_CLASS$.setDefaultValue(null);
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("CLT", "(DEFUN CLT ())", Native.find_java_method("edu.isi.stella.Stella", "clt", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("JT", "(DEFUN JT ())", Native.find_java_method("edu.isi.stella.Stella", "jt", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("JPTRANS", "(DEFUN JPTRANS ((STATEMENT OBJECT)) :COMMAND? TRUE :PUBLIC? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Translate `statement' to C++ and print the result.\")", Native.find_java_method("edu.isi.stella.Stella_Object", "jptrans", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineMethodObject("(DEFMETHOD (JAVA-MAKE-CODE-OUTPUT-FILE-NAME FILE-NAME) ((BAREFILE FILE-NAME) (DONTTRUNCATE? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Stella", "string_javaMakeCodeOutputFileName", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Boolean.TYPE}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (JAVA-MAKE-CODE-OUTPUT-FILE-NAME FILE-NAME) ((SOURCE CLASS) (DONTTRUNCATE? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Stella_Class", "javaMakeCodeOutputFileName", new java.lang.Class [] {java.lang.Boolean.TYPE}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("JAVA-MAKE-GLOBAL-OUTPUT-FILE-NAME", "(DEFUN (JAVA-MAKE-GLOBAL-OUTPUT-FILE-NAME FILE-NAME) ((MODULE MODULE) (DONTTRUNCATE? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Module", "javaMakeGlobalOutputFileName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-FLOTSAM-UNITS-TO-FILE", "(DEFUN JAVA-OUTPUT-FLOTSAM-UNITS-TO-FILE ((GLOBALSHT HASH-TABLE) (FUNCTIONHT HASH-TABLE) (CODEMODULELIST (CONS OF MODULE))))", Native.find_java_method("edu.isi.stella.HashTable", "javaOutputFlotsamUnitsToFile", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.HashTable"), Native.find_java_class("edu.isi.stella.HashTable"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-FLOTSAM-UNITS-TO-FILE-FOR-MODULE", "(DEFUN JAVA-OUTPUT-FLOTSAM-UNITS-TO-FILE-FOR-MODULE ((CLASSOUTPUTFILE FILE-NAME) (MODULE MODULE) (CLASSUNIT TRANSLATION-UNIT) (GLOBALS (CONS OF TRANSLATION-UNIT)) (FUNCTIONS (CONS OF TRANSLATION-UNIT))))", Native.find_java_method("edu.isi.stella.Stella", "javaOutputFlotsamUnitsToFileForModule", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.stella.TranslationUnit"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-FILE-HEADER", "(DEFUN JAVA-OUTPUT-FILE-HEADER ((STREAM OUTPUT-STREAM) (FILENAME FILE-NAME)))", Native.find_java_method("edu.isi.stella.OutputStream", "javaOutputFileHeader", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-CLASS-TO-FILE", "(DEFUN JAVA-OUTPUT-CLASS-TO-FILE ((CLASS CLASS)))", Native.find_java_method("edu.isi.stella.Stella_Class", "javaOutputClassToFile", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-CLASS-UNIT-TO-FILE", "(DEFUN JAVA-OUTPUT-CLASS-UNIT-TO-FILE ((CLASSUNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "javaOutputClassUnitToFile", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
          Stella.defineFunctionObject("JAVA-FLOTSAM-FUNCTION?", "(DEFUN (JAVA-FLOTSAM-FUNCTION? BOOLEAN) ((METHOD METHOD-SLOT)))", Native.find_java_method("edu.isi.stella.MethodSlot", "javaFlotsamFunctionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MethodSlot")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-STARTUP-UNITS-TO-FILE", "(DEFUN JAVA-OUTPUT-STARTUP-UNITS-TO-FILE ((STARTUPHT STRING-HASH-TABLE) (KEYLIST (CONS OF STRING-WRAPPER))))", Native.find_java_method("edu.isi.stella.StringHashTable", "javaOutputStartupUnitsToFile", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringHashTable"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("JAVA-PUSH-INTO-HASH-TABLE", "(DEFUN JAVA-PUSH-INTO-HASH-TABLE ((HT HASH-TABLE) (KEY OBJECT) (OBJECT OBJECT)))", Native.find_java_method("edu.isi.stella.HashTable", "javaPushIntoHashTable", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.HashTable"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("JAVA-PUSH-INTO-STRING-HASH-TABLE", "(DEFUN JAVA-PUSH-INTO-STRING-HASH-TABLE ((HT STRING-HASH-TABLE) (KEY STRING) (OBJECT OBJECT)))", Native.find_java_method("edu.isi.stella.StringHashTable", "javaPushIntoStringHashTable", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringHashTable"), Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("JAVA-CLASS-UNIT-DEFINES-FLOTSAM-CLASS?", "(DEFUN (JAVA-CLASS-UNIT-DEFINES-FLOTSAM-CLASS? BOOLEAN) ((CLASSUNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "javaClassUnitDefinesFlotsamClassP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
          Stella.defineFunctionObject("JAVA-OUTPUT-ALL-UNITS-TO-FILE", "(DEFUN JAVA-OUTPUT-ALL-UNITS-TO-FILE ())", Native.find_java_method("edu.isi.stella.Stella", "javaOutputAllUnitsToFile", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("JAVA-INITIALIZE-FILE-TRANSLATION", "(DEFUN JAVA-INITIALIZE-FILE-TRANSLATION ())", Native.find_java_method("edu.isi.stella.Stella", "javaInitializeFileTranslation", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("JAVA-TRANSLATE-FILE", "(DEFUN JAVA-TRANSLATE-FILE ((FILENAME FILE-NAME)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "javaTranslateFile", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("JAVA-TRANSLATE-FILE-AS-PART-OF-SYSTEM", "(DEFUN JAVA-TRANSLATE-FILE-AS-PART-OF-SYSTEM ((FILENAME FILE-NAME)))", Native.find_java_method("edu.isi.stella.Stella", "javaTranslateFileAsPartOfSystem", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("JAVA-TRANSLATE-WALKED-SYSTEM-UNITS", "(DEFUN JAVA-TRANSLATE-WALKED-SYSTEM-UNITS ((SYSTEMUNITS SYSTEM-UNITS-ALIST)))", Native.find_java_method("edu.isi.stella.KeyValueList", "javaTranslateWalkedSystemUnits", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
          Stella.defineFunctionObject("JAVA-TRANSLATE-SYSTEM", "(DEFUN JAVA-TRANSLATE-SYSTEM ((SYSTEMNAME STRING)) :DOCUMENTATION \"Translate the system `systemName' to Java.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "javaTranslateSystem", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("STARTUP-JAVA-TRANSLATE-FILE", "(DEFUN STARTUP-JAVA-TRANSLATE-FILE () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupJavaTranslateFile", "startupJavaTranslateFile", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_JAVA_TRANSLATE_FILE);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupJavaTranslateFile"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *CURRENT-JAVA-OUTPUT-CLASS* CLASS NULL :PUBLIC? FALSE :DOCUMENTATION \"Holds the current Stella class being output in Java\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
