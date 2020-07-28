//  -*- Mode: Java -*-
//
// _StartupClTranslateFile.java

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

public class _StartupClTranslateFile {
  public static void startupClTranslateFile() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Stella.KWD_LISP = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LISP", null, 2)));
          Stella.KWD_STELLA = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("STELLA", null, 2)));
          Stella.KWD_TWO_PASSp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TWO-PASS?", null, 2)));
          Stella.KWD_FORCE_TRANSLATIONp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FORCE-TRANSLATION?", null, 2)));
          Stella.KWD_PRODUCTION_SETTINGSp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PRODUCTION-SETTINGS?", null, 2)));
          Stella.KWD_LISP_BINARY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LISP-BINARY", null, 2)));
          Stella.SYM_STELLA_STARTUP_CL_TRANSLATE_FILE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-CL-TRANSLATE-FILE", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("LPTRANS", "(DEFUN LPTRANS ((STATEMENT OBJECT)) :COMMAND? TRUE :PUBLIC? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Translate `statement' to Common-Lisp and print the result.\")", Native.find_java_method("edu.isi.stella.Stella_Object", "lptrans", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("PTRANS", "(DEFUN PTRANS ((STATEMENT OBJECT)) :COMMAND? TRUE :PUBLIC? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Translate `statement' to Common-Lisp and print the result.\")", Native.find_java_method("edu.isi.stella.Stella_Object", "ptrans", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("HELP-LPTRANS", "(DEFUN HELP-LPTRANS ((STATEMENT OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "helpLptrans", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("AUXILIARY-VARIABLE-UNIT?", "(DEFUN (AUXILIARY-VARIABLE-UNIT? BOOLEAN) ((UNIT TRANSLATION-UNIT)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "auxiliaryVariableUnitP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit")}), null);
          Stella.defineFunctionObject("CL-OUTPUT-ONE-UNIT", "(DEFUN CL-OUTPUT-ONE-UNIT ((UNIT TRANSLATION-UNIT) (STREAM NATIVE-OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.TranslationUnit", "clOutputOneUnit", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit"), Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), null);
          Stella.defineFunctionObject("CL-OUTPUT-ALL-UNITS-TO-FILE", "(DEFUN CL-OUTPUT-ALL-UNITS-TO-FILE ((SOURCEFILE FILE-NAME)))", Native.find_java_method("edu.isi.stella.Stella", "clOutputAllUnitsToFile", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("CL-OUTPUT-FILE-HEADER", "(DEFUN CL-OUTPUT-FILE-HEADER ((STREAM OUTPUT-STREAM) (FILE FILE-NAME) (ENSUREPACKAGE? BOOLEAN)))", Native.find_java_method("edu.isi.stella.OutputStream", "clOutputFileHeader", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("java.lang.String"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("CL-OUTPUT-ENSURE-PACKAGE-DEFINITION", "(DEFUN CL-OUTPUT-ENSURE-PACKAGE-DEFINITION ((STREAM OUTPUT-STREAM) (PACKAGE STRING)))", Native.find_java_method("edu.isi.stella.OutputStream", "clOutputEnsurePackageDefinition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("CL-OUTPUT-IN-PACKAGE-DECLARATION", "(DEFUN CL-OUTPUT-IN-PACKAGE-DECLARATION ((STREAM OUTPUT-STREAM) (PACKAGE STRING)))", Native.find_java_method("edu.isi.stella.OutputStream", "clOutputInPackageDeclaration", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("CL-OUTPUT-FORWARD-DECLARATIONS", "(DEFUN CL-OUTPUT-FORWARD-DECLARATIONS ((STREAM NATIVE-OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.Stella", "clOutputForwardDeclarations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), null);
          Stella.defineFunctionObject("CL-TRANSLATE-FILE", "(DEFUN CL-TRANSLATE-FILE ((FILE FILE-NAME) (RELATIVE? BOOLEAN)) :DOCUMENTATION \"Translate a Stella `file' to Common-Lisp.  If\n`relative?', concatenate root directory to `file'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "clTranslateFile", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("CL-TRANSLATE-WALKED-SYSTEM-UNITS", "(DEFUN CL-TRANSLATE-WALKED-SYSTEM-UNITS ((SYSTEMUNITS SYSTEM-UNITS-ALIST)))", Native.find_java_method("edu.isi.stella.KeyValueList", "clTranslateWalkedSystemUnits", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
          Stella.defineFunctionObject("SORT-CL-STRUCT-CLASSES", "(DEFUN (SORT-CL-STRUCT-CLASSES (LIST OF CLASS)) ((UNSORTEDCLASSES (LIST OF CLASS))))", Native.find_java_method("edu.isi.stella.List", "sortClStructClasses", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("CL-YIELD-STRUCT-CLASS-FILE-NAME", "(DEFUN (CL-YIELD-STRUCT-CLASS-FILE-NAME FILE-NAME) ((SYSTEMNAME STRING)))", Native.find_java_method("edu.isi.stella.Stella", "clYieldStructClassFileName", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("CL-OUTPUT-SYSTEM-CL-STRUCTS-FILE", "(DEFUN CL-OUTPUT-SYSTEM-CL-STRUCTS-FILE ((CLASSUNITS (LIST OF TRANSLATION-UNIT))))", Native.find_java_method("edu.isi.stella.List", "clOutputSystemClStructsFile", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("CL-TRANSLATE-SYSTEM", "(DEFUN CL-TRANSLATE-SYSTEM ((SYSTEM-NAME STRING)) :DOCUMENTATION \"Translate a Stella system named `system-name' to Common Lisp.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "clTranslateSystem", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("CL-COMPILE-AND-LOAD-FILES", "(DEFUN (CL-COMPILE-AND-LOAD-FILES BOOLEAN) ((FILES (CONS OF STRING-WRAPPER)) (RELATIVE? BOOLEAN) (FORCERECOMPILATION? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Cons", "clCompileAndLoadFiles", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE, java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("CL-TRANSLATE-STELLA", "(DEFUN CL-TRANSLATE-STELLA ((PRODUCTIONSETTINGS? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Stella", "clTranslateStella", new java.lang.Class [] {java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("CL-RETRANSLATE-STELLA", "(DEFUN CL-RETRANSLATE-STELLA ((PRODUCTIONSETTINGS? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Stella", "clRetranslateStella", new java.lang.Class [] {java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("STARTUP-CL-TRANSLATE-FILE", "(DEFUN STARTUP-CL-TRANSLATE-FILE () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupClTranslateFile", "startupClTranslateFile", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_CL_TRANSLATE_FILE);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupClTranslateFile"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("STELLA")))));
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
