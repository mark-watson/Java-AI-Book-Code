//  -*- Mode: Java -*-
//
// _StartupTranslateFile.java

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

public class _StartupTranslateFile {
  static void helpStartupTranslateFile1() {
    {
      Stella.KWD_ROOT_DIRECTORY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ROOT-DIRECTORY", null, 2)));
      Stella.KWD_LISP_TRANSLATIONS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LISP-TRANSLATIONS", null, 2)));
      Stella.KWD_KB = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("KB", null, 2)));
      Stella.KWD_CPP_CODE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP-CODE", null, 2)));
      Stella.KWD_CPP_HEADER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP-HEADER", null, 2)));
      Stella.KWD_C_CODE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("C-CODE", null, 2)));
      Stella.KWD_C_HEADER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("C-HEADER", null, 2)));
      Stella.KWD_DIRECTORY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DIRECTORY", null, 2)));
      Stella.SYM_STELLA_SYSTEM_UNITS_ALIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SYSTEM-UNITS-ALIST", null, 0)));
      Stella.KWD_LANGUAGE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LANGUAGE", null, 2)));
      Stella.KWD_ACTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ACTION", null, 2)));
      Stella.KWD_TRANSLATE_SYSTEM = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TRANSLATE-SYSTEM", null, 2)));
      Stella.KWD_DEVELOPMENT_SETTINGSp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DEVELOPMENT-SETTINGS?", null, 2)));
      Stella.SYM_STELLA_STARTUP_TRANSLATE_FILE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-TRANSLATE-FILE", null, 0)));
    }
  }

  static void helpStartupTranslateFile2() {
    {
      Stella.$USERECORDEDSIGNATURESp$.setDefaultValue(new Boolean(false));
      Stella.$ROOTSOURCEDIRECTORY$.setDefaultValue("PL:sources;");
      Stella.$ROOTNATIVEDIRECTORY$.setDefaultValue("PL:native;");
      Stella.$ROOTBINARYDIRECTORY$.setDefaultValue("PL:bin;");
      Stella.$SYSTEMDEFINITIONSDIRECTORY$.setDefaultValue(null);
      Stella.$CURRENTSYSTEMDEFINITION$.setDefaultValue(null);
      Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.setDefaultValue("");
      Stella.$OS$ = Stella.operatingSystem();
      Stella.$TYPE_TO_FILE_EXTENSION_TABLE$ = Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.KWD_STELLA, Cons.cons(StringWrapper.wrapString(".ste"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.KWD_KB, Cons.cons(StringWrapper.wrapString(".kb"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.KWD_CPP, Cons.cons(StringWrapper.wrapString(".cc"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.KWD_CPP_CODE, Cons.cons(StringWrapper.wrapString(".cc"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.KWD_CPP_HEADER, Cons.cons(StringWrapper.wrapString(".hh"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.KWD_C_CODE, Cons.cons(StringWrapper.wrapString(".c"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.KWD_C_HEADER, Cons.cons(StringWrapper.wrapString(".h"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.KWD_JAVA, Cons.cons(StringWrapper.wrapString(".java"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.KWD_IDL, Cons.cons(StringWrapper.wrapString(".idl"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.KWD_OTHER, Cons.cons(StringWrapper.wrapString(""), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.KWD_NONE, Cons.cons(StringWrapper.wrapString(""), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))))))))));
      Stella.$DONTTRUNCATEFILENAMESp$.setDefaultValue(new Boolean(false));
    }
  }

  static void helpStartupTranslateFile3() {
    {
      Stella.defineFunctionObject("ROOT-SOURCE-DIRECTORY", "(DEFUN (ROOT-SOURCE-DIRECTORY FILE-NAME) ())", Native.find_java_method("edu.isi.stella.Stella", "rootSourceDirectory", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("ROOT-NATIVE-DIRECTORY", "(DEFUN (ROOT-NATIVE-DIRECTORY FILE-NAME) ())", Native.find_java_method("edu.isi.stella.Stella", "rootNativeDirectory", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("ROOT-BINARY-DIRECTORY", "(DEFUN (ROOT-BINARY-DIRECTORY FILE-NAME) ())", Native.find_java_method("edu.isi.stella.Stella", "rootBinaryDirectory", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("SYSTEM-DEFINITIONS-DIRECTORY", "(DEFUN (SYSTEM-DEFINITIONS-DIRECTORY FILE-NAME) ())", Native.find_java_method("edu.isi.stella.Stella", "systemDefinitionsDirectory", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("HANDLE-IN-MODULE-TREE", "(DEFUN (HANDLE-IN-MODULE-TREE BOOLEAN BOOLEAN) ((TREE CONS) (SEENINMODULE? BOOLEAN) (ERRORONINMODULE? BOOLEAN)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Cons", "handleInModuleTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE, java.lang.Boolean.TYPE, Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("TRANSLATE-AND-OUTPUT-UNITS-TO-FILE", "(DEFUN TRANSLATE-AND-OUTPUT-UNITS-TO-FILE ((FILE FILE-NAME) (TARGETLANGUAGE STRING)))", Native.find_java_method("edu.isi.stella.Stella", "translateAndOutputUnitsToFile", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("OPERATE-ON-FILE", "(DEFUN OPERATE-ON-FILE ((FILE FILE-NAME) (OPERATION KEYWORD)))", Native.find_java_method("edu.isi.stella.Stella", "operateOnFile", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("CLEAN-UP-TRANSLATION-UNITS-SPECIAL", "(DEFUN CLEAN-UP-TRANSLATION-UNITS-SPECIAL ())", Native.find_java_method("edu.isi.stella.Stella", "cleanUpTranslationUnitsSpecial", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("TRANSLATE-FILE", "(DEFUN TRANSLATE-FILE ((FILE FILE-NAME) (OUTPUTLANGUAGE KEYWORD) (ASPARTOFSYSTEM? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Stella", "translateFile", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Keyword"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("OUTPUT-ALL-UNITS-TO-FILE", "(DEFUN OUTPUT-ALL-UNITS-TO-FILE ((SOURCEFILE FILE-NAME)))", Native.find_java_method("edu.isi.stella.Stella", "outputAllUnitsToFile", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("RECORD-SIGNATURES-OF-ALL-UNITS", "(DEFUN RECORD-SIGNATURES-OF-ALL-UNITS ((SOURCEFILE FILE-NAME)))", Native.find_java_method("edu.isi.stella.Stella", "recordSignaturesOfAllUnits", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("TRANSLATE-WITH-COPYRIGHT-HEADER?", "(DEFUN (TRANSLATE-WITH-COPYRIGHT-HEADER? BOOLEAN) ())", Native.find_java_method("edu.isi.stella.Stella", "translateWithCopyrightHeaderP", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("OUTPUT-COPYRIGHT-HEADER", "(DEFUN OUTPUT-COPYRIGHT-HEADER ((STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.OutputStream", "outputCopyrightHeader", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineFunctionObject("OUTPUT-FILE-HEADER", "(DEFUN OUTPUT-FILE-HEADER ((STREAM OUTPUT-STREAM) (FILE FILE-NAME)))", Native.find_java_method("edu.isi.stella.OutputStream", "outputFileHeader", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("OPERATING-SYSTEM", "(DEFUN (OPERATING-SYSTEM KEYWORD) ())", Native.find_java_method("edu.isi.stella.Stella", "operatingSystem", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("DIRECTORY-SEPARATOR", "(DEFUN (DIRECTORY-SEPARATOR CHARACTER) ())", Native.find_java_method("edu.isi.stella.Stella", "directorySeparator", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("DIRECTORY-SEPARATOR-STRING", "(DEFUN (DIRECTORY-SEPARATOR-STRING STRING) ())", Native.find_java_method("edu.isi.stella.Stella", "directorySeparatorString", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("DIRECTORY-SEPARATOR-FOR-FILE", "(DEFUN (DIRECTORY-SEPARATOR-FOR-FILE CHARACTER) ((FILE FILE-NAME)))", Native.find_java_method("edu.isi.stella.Stella", "directorySeparatorForFile", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("FILE-NAME-DIRECTORY", "(DEFUN (FILE-NAME-DIRECTORY FILE-NAME) ((FILE FILE-NAME)) :DOCUMENTATION \"Return the directory component of `file' including the final\ndirectory separator or the empty string if `file' does not include a directory.\nNote that for purposes of this function, a logical host is considered part of\nthe directory portion of `file'\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "fileNameDirectory", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("DIRECTORY-FILE-NAME", "(DEFUN (DIRECTORY-FILE-NAME FILE-NAME) ((DIRECTORY FILE-NAME)) :DOCUMENTATION \"Return `directory' as a file name, i.e., without a terminating\ndirectory separator.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "directoryFileName", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("FILE-NAME-AS-DIRECTORY", "(DEFUN (FILE-NAME-AS-DIRECTORY FILE-NAME) ((FILE FILE-NAME)) :DOCUMENTATION \"Return `file' interpreted as a directory, i.e., with a\nterminating directory separator.  If `file' is the empty string simply\nreturn the empty string, i.e., interpret it as the current directory instead\nof the root directory.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "fileNameAsDirectory", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("DIRECTORY-PARENT-DIRECTORY", "(DEFUN (DIRECTORY-PARENT-DIRECTORY FILE-NAME) ((DIRECTORY FILE-NAME) (LEVEL INTEGER)) :DOCUMENTATION \"Return the `level'-th parent directory component of `directory'\nincluding the final directory separator, or the empty string if `directory' does\nnot have that many parents.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "directoryParentDirectory", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("FILE-NAME-WITHOUT-DEVICE", "(DEFUN (FILE-NAME-WITHOUT-DEVICE FILE-NAME) ((FILE FILE-NAME)) :DOCUMENTATION \"Return the file name portion of `file' by removing any\nphysical device components.  This is just like `logical-pathname-without-host'\nbut only looks for one-character device strings as used in Windows.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "fileNameWithoutDevice", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("FILE-NAME-WITHOUT-DIRECTORY", "(DEFUN (FILE-NAME-WITHOUT-DIRECTORY FILE-NAME) ((FILE FILE-NAME)) :DOCUMENTATION \"Return the file name portion of `file' by removing any\ndirectory and logical host components.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "fileNameWithoutDirectory", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("FILE-NAME-WITHOUT-EXTENSION", "(DEFUN (FILE-NAME-WITHOUT-EXTENSION FILE-NAME) ((FILE FILE-NAME)) :DOCUMENTATION \"Remove `file's extension (or type) if there is any and\nreturn the result.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "fileNameWithoutExtension", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("FILE-EXTENSION", "(DEFUN (FILE-EXTENSION STRING) ((FILE FILE-NAME)) :DOCUMENTATION \"Return `file's extension (or type) if it has any including\nthe separator character.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "fileExtension", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("FILE-BASE-NAME", "(DEFUN (FILE-BASE-NAME FILE-NAME) ((FILE FILE-NAME)) :DOCUMENTATION \"Remove `file's directory (including logical host) and\nextension components and return the result.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "fileBaseName", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("DEFINE-LOGICAL-HOST-PROPERTY", "(DEFUN DEFINE-LOGICAL-HOST-PROPERTY ((HOST STRING) (PROPERTY KEYWORD) (VALUE OBJECT)) :DOCUMENTATION \"Define `property' with `value' for the logical host `host'.\nAs a side-effect, this also defines `host' as a logical host (both\n`property' and `value' can be supplied as NULL).  If :ROOT-DIRECTORY\nis specified, all pathnames with `host' are assumed to be relative to\nthat directory (even if they are absolute) and will be rerooted upon\ntranslation.  :ROOT-DIRECTORY can be a logical or physical pathname.\nIf :LISP-TRANSLATIONS is specified, those will be used verbatimely as\nthe value of `(CL:logical-pathname-translations host)' if we are\nrunning in Lisp, which allows us to depend on the native\n`CL:translate-logical-pathname' for more complex translation operations.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "defineLogicalHostProperty", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("LOOKUP-LOGICAL-HOST-PROPERTY", "(DEFUN (LOOKUP-LOGICAL-HOST-PROPERTY OBJECT) ((HOST STRING) (PROPERTY KEYWORD)))", Native.find_java_method("edu.isi.stella.Stella", "lookupLogicalHostProperty", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("LOGICAL-HOST?", "(DEFUN (LOGICAL-HOST? BOOLEAN) ((HOST STRING)))", Native.find_java_method("edu.isi.stella.Stella", "logicalHostP", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("LOGICAL-PATHNAME?", "(DEFUN (LOGICAL-PATHNAME? BOOLEAN) ((PATHNAME STRING)))", Native.find_java_method("edu.isi.stella.Stella", "logicalPathnameP", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("ABSOLUTE-PATHNAME?", "(DEFUN (ABSOLUTE-PATHNAME? BOOLEAN) ((PATHNAME STRING)))", Native.find_java_method("edu.isi.stella.Stella", "absolutePathnameP", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("GET-LOGICAL-HOST-NAME", "(DEFUN (GET-LOGICAL-HOST-NAME STRING) ((PATHNAME STRING)))", Native.find_java_method("edu.isi.stella.Stella", "getLogicalHostName", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("LOGICAL-PATHNAME-WITHOUT-HOST", "(DEFUN (LOGICAL-PATHNAME-WITHOUT-HOST STRING) ((PATHNAME STRING)))", Native.find_java_method("edu.isi.stella.Stella", "logicalPathnameWithoutHost", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("TRANSLATE-LOGICAL-PATHNAME", "(DEFUN (TRANSLATE-LOGICAL-PATHNAME STRING) ((PATHNAME STRING)))", Native.find_java_method("edu.isi.stella.Stella", "translateLogicalPathname", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("UNLOGICALIZE-PATHNAME", "(DEFUN (UNLOGICALIZE-PATHNAME STRING) ((PATHNAME STRING)) :GLOBALLY-INLINE? TRUE (RETURN (TRANSLATE-LOGICAL-PATHNAME PATHNAME)))", Native.find_java_method("edu.isi.stella.Stella", "unlogicalizePathname", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("MERGE-FILE-NAMES", "(DEFUN (MERGE-FILE-NAMES FILE-NAME) ((BASEFILE FILE-NAME) (DEFAULTS FILE-NAME)) :DOCUMENTATION \"Parse `baseFile', supply any missing components from\n`defaults' if supplied and return the result.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "mergeFileNames", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("COMPUTE-COMMON-LISP-FILE-EXTENSION", "(DEFUN (COMPUTE-COMMON-LISP-FILE-EXTENSION STRING) ((TYPE KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "computeCommonLispFileExtension", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("DEFAULT-COMMON-LISP-FILE-EXTENSION", "(DEFUN (DEFAULT-COMMON-LISP-FILE-EXTENSION STRING) ((TYPE KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "defaultCommonLispFileExtension", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("SELECT-FILE-EXTENSION", "(DEFUN (SELECT-FILE-EXTENSION STRING) ((TYPE KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "selectFileExtension", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("CLASSIFY-FILE-EXTENSION", "(DEFUN (CLASSIFY-FILE-EXTENSION KEYWORD) ((FILE FILE-NAME)))", Native.find_java_method("edu.isi.stella.Stella", "classifyFileExtension", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("SELECT-ROOT-DIRECTORY", "(DEFUN (SELECT-ROOT-DIRECTORY STRING) ((TYPE KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "selectRootDirectory", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("SELECT-SPLITTER-PATH", "(DEFUN (SELECT-SPLITTER-PATH STRING) ((TYPE KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "selectSplitterPath", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("MAKE-FILE-NAME-FROM-RELATIVE-PATH", "(DEFUN (MAKE-FILE-NAME-FROM-RELATIVE-PATH FILE-NAME) ((FILEPATH OBJECT) (TYPE KEYWORD)))", Native.find_java_method("edu.isi.stella.Stella_Object", "makeFileNameFromRelativePath", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("ROOT-DIRECTORY-PREFIX", "(DEFUN (ROOT-DIRECTORY-PREFIX FILE-NAME) ((FILE FILE-NAME)))", Native.find_java_method("edu.isi.stella.Stella", "rootDirectoryPrefix", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("MAKE-FILE-NAME", "(DEFUN (MAKE-FILE-NAME FILE-NAME) ((FILEPATH STRING) (TYPE KEYWORD) (RELATIVE? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Stella", "makeFileName", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Keyword"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("RELATIVIZE-FILE-NAME", "(DEFUN (RELATIVIZE-FILE-NAME FILE-NAME) ((FILE FILE-NAME) (ROOTPATH FILE-NAME)))", Native.find_java_method("edu.isi.stella.Stella", "relativizeFileName", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("HELP-IMPLODE-PATHNAME", "(DEFUN (HELP-IMPLODE-PATHNAME FILE-NAME) ((FILENAME FILE-NAME)))", Native.find_java_method("edu.isi.stella.Stella", "helpImplodePathname", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("IMPLODE-PATHNAME", "(DEFUN (IMPLODE-PATHNAME FILE-NAME) ((FILEPATH OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "implodePathname", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("MAYBE-TRUNCATE-FILENAME", "(DEFUN (MAYBE-TRUNCATE-FILENAME FILE-NAME) ((BAREFILENAME FILE-NAME)))", Native.find_java_method("edu.isi.stella.Stella", "maybeTruncateFilename", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("LANGUAGE-TO-FILE-TYPE", "(DEFUN (LANGUAGE-TO-FILE-TYPE KEYWORD) ((LANGUAGE KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "languageToFileType", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("REROOT-FILE-NAME", "(DEFUN (REROOT-FILE-NAME FILE-NAME) ((FILE FILE-NAME) (FROMROOT FILE-NAME) (TOROOT FILE-NAME)))", Native.find_java_method("edu.isi.stella.Stella", "rerootFileName", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("FILE-YOUNGER-THAN?", "(DEFUN (FILE-YOUNGER-THAN? THREE-VALUED-BOOLEAN) ((FILE1 STRING) (FILE2 STRING)))", Native.find_java_method("edu.isi.stella.Stella", "fileYoungerThanP", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("STELLA-NEED-TO-TRANSLATE?", "(DEFUN (STELLA-NEED-TO-TRANSLATE? BOOLEAN) ((FILE OBJECT) (LANGUAGE KEYWORD)))", Native.find_java_method("edu.isi.stella.Stella_Object", "stellaNeedToTranslateP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("STELLA-NEED-TO-COMPILE?", "(DEFUN (STELLA-NEED-TO-COMPILE? BOOLEAN) ((FILE OBJECT)))", Native.find_java_method("edu.isi.stella.Stella_Object", "stellaNeedToCompileP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SYSTEM-NEEDS-TRANSLATION?", "(DEFUN (SYSTEM-NEEDS-TRANSLATION? BOOLEAN) ((SYSTEMNAME STRING) (LANGUAGE KEYWORD)))", Native.find_java_method("edu.isi.stella.Stella", "systemNeedsTranslationP", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("COMPUTE-FILE-UNITS-MODULE", "(DEFUN (COMPUTE-FILE-UNITS-MODULE MODULE) ((FILEUNITS (LIST OF TRANSLATION-UNIT))))", Native.find_java_method("edu.isi.stella.List", "computeFileUnitsModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("CONCATENATE-SYSTEM-UNITS", "(DEFUN (CONCATENATE-SYSTEM-UNITS (LIST OF TRANSLATION-UNIT)) ((SYSTEMUNITS SYSTEM-UNITS-ALIST)))", Native.find_java_method("edu.isi.stella.KeyValueList", "concatenateSystemUnits", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
      Stella.defineFunctionObject("TRANSLATE-SYSTEM", "(DEFUN (TRANSLATE-SYSTEM BOOLEAN) ((SYSTEMNAME STRING) |&REST| (|LANGUAGE&OPTIONS| OBJECT)) :DOCUMENTATION \"Translate all of the STELLA source files in system `systemName' into\n`language' (the optional first argument).  The following keyword/value\n`options' are recognized:\n\n`:language': can be used as an alternative to the optional language argument.\nIf not specified, the language of the running implementation is assumed.\n\n`:two-pass?' (default false): if true, all files will be scanned twice, once\nto load the signatures of objects defined in them, and once to actually\ntranslate the definitions.\n\n`:force-translation?' (default false): if true, files will be translated\nwhether or not their translations are up-to-date.\n\n`:development-settings?' (default false): if true translation will favor\nsafe, readable and debuggable code over efficiency (according to the value\nof `:development-settings' on the system definition).  If false, efficiency\nwill be favored instead (according to the value of `:production-settings'\non the system definition).\n\n`:production-settings?' (default true): inverse to `:development-settings?'.\" :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "translateSystem", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.stella.Cons", "translateSystemEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("HELP-TRANSLATE-SYSTEM", "(DEFUN (HELP-TRANSLATE-SYSTEM BOOLEAN) ((FILES (CONS OF STRING-WRAPPER)) (TWOPASS? BOOLEAN) (FORCETRANSLATION? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Cons", "helpTranslateSystem", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE, java.lang.Boolean.TYPE}), null);
    }
  }

  public static void startupTranslateFile() {
    if (Stella.currentStartupTimePhaseP(0)) {
      Stella.$LOGICAL_HOST_TABLE$ = StringHashTable.newStringHashTable();
      Stella.defineLogicalHostProperty("PL", null, null);
    }
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupTranslateFile.helpStartupTranslateFile1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          _StartupTranslateFile.helpStartupTranslateFile2();
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE SYSTEM-UNITS-ALIST (KEY-VALUE-LIST OF STRING-WRAPPER (LIST OF TRANSLATION-UNIT)))");
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupTranslateFile.helpStartupTranslateFile3();
          Stella.defineFunctionObject("TRANSFER-NATIVE-SYSTEM-FILES", "(DEFUN TRANSFER-NATIVE-SYSTEM-FILES ((OUTPUT-LANGUAGE KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "transferNativeSystemFiles", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("TRANSFER-DATA-FILES", "(DEFUN TRANSFER-DATA-FILES ((OUTPUT-LANGUAGE KEYWORD)))", Native.find_java_method("edu.isi.stella.Keyword", "transferDataFiles", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("TRANSFER-FILES", "(DEFUN TRANSFER-FILES ((FILES (CONS OF STRING-WRAPPER)) (OUTPUT-LANGUAGE KEYWORD)))", Native.find_java_method("edu.isi.stella.Cons", "transferFiles", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("STARTUP-TRANSLATE-FILE", "(DEFUN STARTUP-TRANSLATE-FILE () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupTranslateFile", "startupTranslateFile", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_TRANSLATE_FILE);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupTranslateFile"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *RECORD-SIGNATURES?* BOOLEAN FALSE :DOCUMENTATION \"If `true', record object signatures into a persistent table.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *WALK-WITH-RECORDED-SIGNATURES?* BOOLEAN FALSE :DOCUMENTATION \"If `true', the walker will try to find previously recorded\nsignatures for referenced but undefined functions, methods, etc.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *USERECORDEDSIGNATURES?* BOOLEAN FALSE :DOCUMENTATION \"If `true', `safe-lookup-slot' and `lookup-function' will\ntry to retrieve a previously recorded signature if normal lookup fails.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *ROOTSOURCEDIRECTORY* STRING \"PL:sources;\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *ROOTNATIVEDIRECTORY* STRING \"PL:native;\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *ROOTBINARYDIRECTORY* STRING \"PL:bin;\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *SYSTEMDEFINITIONSDIRECTORY* STRING NULL :DOCUMENTATION \"Points to the directory containing the SYSTEMS file.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *CURRENTSYSTEMDEFINITION* SYSTEM-DEFINITION NULL :DOCUMENTATION \"Points to the current system.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *CURRENTSYSTEMDEFINITIONSUBDIRECTORY* STRING \"\" :DOCUMENTATION \"Points to a path from the root directory down\nto a local directory containing sources, natives, or binaries.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *OS* KEYWORD (OPERATING-SYSTEM) :DOCUMENTATION \"The operating system we are running on.  Currently,\neither :UNIX, :WINDOWS, or :MAC.  Note that on the Mac OS X, the\nOS can be either :UNIX or :MAC, depending on which file naming \nconventions are being observed by the software.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT TYPE-SEPARATOR CHARACTER #\\.)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT LOGICAL-DIRECTORY-SEPARATOR CHARACTER #\\;)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT LOGICAL-HOST-SEPARATOR CHARACTER #\\:)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *LOGICAL-HOST-TABLE* (STRING-HASH-TABLE OF STRING KEY-VALUE-LIST) NULL)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *TYPE-TO-FILE-EXTENSION-TABLE* (CONS OF CONS) (BQUOTE ((:STELLA \".ste\") (:KB \".kb\") (:CPP \".cc\") (:CPP-CODE \".cc\") (:CPP-HEADER \".hh\") (:C-CODE \".c\") (:C-HEADER \".h\") (:JAVA \".java\") (:IDL \".idl\") (:OTHER \"\") (:NONE \"\"))) :DOCUMENTATION \"Used by `select-file-extension'.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *LISP-SPLITTER-PATH* STRING \"lisp\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *JAVA-SPLITTER-PATH* STRING \"java\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CPP-SPLITTER-PATH* STRING \"cpp\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *DONTTRUNCATEFILENAMES?* BOOLEAN FALSE :DOCUMENTATION \"When TRUE, overrides normal truncation of file names.\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
