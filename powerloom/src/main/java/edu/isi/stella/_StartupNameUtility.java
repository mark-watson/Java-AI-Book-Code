//  -*- Mode: Java -*-
//
// _StartupNameUtility.java

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

public class _StartupNameUtility {
  public static void startupNameUtility() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Stella.KWD_CLEVER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CLEVER", null, 2)));
          Stella.KWD_TITLECASE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TITLECASE", null, 2)));
          Stella.KWD_BREAK_ON_CAP = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("BREAK-ON-CAP", null, 2)));
          Stella.KWD_BREAK_ON_NUMBER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("BREAK-ON-NUMBER", null, 2)));
          Stella.KWD_BREAK_ON_SEPARATORS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("BREAK-ON-SEPARATORS", null, 2)));
          Stella.KWD_REMOVE_PREFIX = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("REMOVE-PREFIX", null, 2)));
          Stella.KWD_REMOVE_SUFFIX = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("REMOVE-SUFFIX", null, 2)));
          Stella.KWD_ADD_PREFIX = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ADD-PREFIX", null, 2)));
          Stella.KWD_ADD_SUFFIX = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ADD-SUFFIX", null, 2)));
          Stella.KWD_CASE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CASE", null, 2)));
          Stella.KWD_SEPARATOR = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SEPARATOR", null, 2)));
          Stella.KWD_SUFFIX = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SUFFIX", null, 2)));
          Stella.KWD_TRANSLATION_TABLE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TRANSLATION-TABLE", null, 2)));
          Stella.KWD_USE_ACRONYM_HEURISTICSp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("USE-ACRONYM-HEURISTICS?", null, 2)));
          Stella.KWD_ALLCAPS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ALLCAPS", null, 2)));
          Stella.KWD_TITLECASEX = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TITLECASEX", null, 2)));
          Stella.SYM_STELLA_STARTUP_NAME_UTILITY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-NAME-UTILITY", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("MAKE-MATCHING-NAME", "(DEFUN (MAKE-MATCHING-NAME STRING) ((ORIGINAL STRING) |&REST| (OPTIONS OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"Keyword options:\n  :break-on-cap    one of  :YES :NO :CLEVER         default is :CLEVER\n  :break-on-number one of  :YES :NO :CLEVER         default is :CLEVER\n  :break-on-separators string                       default is \\\"-_ \\\"\n  :remove-prefix   string\n  :remove-suffix   string\n  \n  :case            one of  :UPCASE :TitleCase :titleCaseX :downcase :Capitalize :preserve\n                                                     default is :TitleCase\n  :separator       string                            default is \\\"\\\"\n  :add-prefix      string\n  :add-suffix      string\n\n  MAKE-MATCHING-NAME returns a matching name (a string) for the input name (a string).\nA matching name is constructed by breaking the input into 'words' and then applying\nappropriate transforms.  The arguments are used as follows:\n  `original'         is the input name.  It is a string.\n  :break-on-cap    is a keyword controlling whether changes in capitalization is used\n                   to indicate word boundaries.  If :YES, then all capitalization\n                   changes delineate words.  If :CLEVER, then unbroken runs of\n                   capitalized letters are treated as acronyms and remain grouped.\n                   If :NO or NULL, there is no breaking of words based on capitalization.\n  :break-on-number is a flag controlling whether encountering a number indicates\n                   a word boundary.  If :YES, then each run of numbers is treated as\n		   a word separate from surrounding words.  If :CLEVER, then an \n		   attempt is made to recognize ordinal numbers (ie, 101st) and\n		   treat them as separate words.  If :NO or NULL, there is no breaking\n                   of words when numbers are encountered.\n  :break-on-separators   A string of characters which constitute word delimiters in\n                         the input word.  This is used to determine how to break\n                   the name into individual words.  Defaults are space, '-' and '_'.\n  :remove-prefix   Specifies a prefix or suffix that is stripped from the input\n  :remove-suffix   name before any other processing.  This allows the removal of\n                   any naming convention dictated prefixes or suffixes.\n  :add-prefix      Specifies a prefix or suffix that is added to the output name\n  :add-suffix      after all other processing.  This allows the addition of any\n                   naming convention dictated prefixes or suffixes.\n  :case            The case of the resulting name.  This is applied to the name \n                   before adding prefixes or suffixes.  The two title case options \n                   differ only in how the first word of the name is treated.\n                   :TitleCase capitalizes the first letter of the first word and\n                       also the first letter of all other words.\n                   :TitleCaseX does not capitalizes the first letter of the first\n		       word but capitalizes the first letter of all subsequent words.\n		   :preserve results in no change in case.\n  :separator       This is a string specifying the word separator to use in the\n                   returned name.  An empty string (the default) means that the\n                   resulting words are concatenated without any separation.  This\n                   normally only makes sense when using one of the title case values\n                   for the case keyword.\")", Native.find_java_method("edu.isi.stella.Stella", "makeMatchingName", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("DECOMPOSE-NAMESTRING", "(DEFUN (DECOMPOSE-NAMESTRING (CONS OF STRING-WRAPPER)) ((NAMESTRING STRING) |&REST| (OPTIONS OBJECT)) :DOCUMENTATION \"Keyword options:\n  :break-on-cap    one of  :YES :NO :CLEVER         default is :CLEVER\n  :break-on-number one of  :YES :NO :CLEVER         default is :CLEVER\n  :break-on-separators string                       default is \\\"-_ \\\"\n\n  DECOMPOSE-NAMESTRING returns a cons of STRING-WRAPPERS that are the decomposition of the\ninput STRING.  The arguments are used as follows:\n  `namestring'       is the input string.\n  :break-on-cap    is a keyword controlling whether changes in capitalization is used\n                   to indicate word boundaries.  If :YES, then all capitalization\n                   changes delineate words.  If :CLEVER, then unbroken runs of\n                   capitalized letters are treated as acronyms and remain grouped.\n                   If :NO or NULL, there is no breaking of words based on capitalization.\n  :break-on-number is a flag controlling whether encountering a number indicates\n                   a word boundary.  If :YES, then each run of numbers is treated as\n		   a word separate from surrounding words.  If :CLEVER, then an \n		   attempt is made to recognize ordinal numbers (ie, 101st) and\n		   treat them as separate words.  If :NO or NULL, there is no breaking\n                   of words when numbers are encountered.\n  :break-on-separators   A string of characters which constitute word delimiters in\n                         the input word.  This is used to determine how to break\n                   the name into individual words.  Defaults are space, '-' and '_'.\")", Native.find_java_method("edu.isi.stella.Stella", "decomposeNamestring", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("COMPOSE-NAMESTRING", "(DEFUN (COMPOSE-NAMESTRING STRING) ((NAME-COMPONENTS (CONS OF STRING-WRAPPER)) |&REST| (OPTIONS OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"`name-components' is a cons to be processed into a namestring.\n':prefix' and ':suffix' are strings that will NOT be case-converted.\n':case' is one of :UPCASE :TitleCase :titleCaseX :downcase :Capitalize\n        default is :TitleCase\n':separator' is a string that should separate word elements.  It does not\n       separate the prefix or suffix.  Default is \\\"\\\"\n':translation-table' should be a STRING-HASH-TABLE hash table that strings into their\n       desired printed representation as a string.  In general the argument\n       will be strings, but that is not strictly necessary.\n\")", Native.find_java_method("edu.isi.stella.Cons", "composeNamestring", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("MAKE-MATCHING-NAME-FULL", "(DEFUN (MAKE-MATCHING-NAME-FULL STRING) ((ORIGINALNAME STRING) (BREAKONCAP KEYWORD) (BREAKONNUMBER KEYWORD) (BREAKONSEPARATORS STRING) (REMOVEPREFIX STRING) (REMOVESUFFIX STRING) (ADDPREFIX STRING) (ADDSUFFIX STRING) (OUTPUTCASE KEYWORD) (OUTPUTSEPARATOR STRING)) :PUBLIC? TRUE :DOCUMENTATION \"Non-keyword version of `make-matching-name', which will probably be\neasier to use when called from non-Lisp languages.\")", Native.find_java_method("edu.isi.stella.Stella", "makeMatchingNameFull", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("DECOMPOSE-NAMESTRING-FULL", "(DEFUN (DECOMPOSE-NAMESTRING-FULL (CONS OF STRING-WRAPPER)) ((NAMESTRING STRING) (BREAK-ON-CAP KEYWORD) (BREAK-ON-NUMBER KEYWORD) (BREAK-ON-SEPARATORS STRING)) :PUBLIC? TRUE :DOCUMENTATION \"Non-keyword version of `decompose-namestring', which will probably be\neasier to use when called from non-Lisp languages.\")", Native.find_java_method("edu.isi.stella.Stella", "decomposeNamestringFull", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("SUFFIX-MATCHES?", "(DEFUN (SUFFIX-MATCHES? BOOLEAN) ((TESTSTRING STRING) (SUFFIX STRING)))", Native.find_java_method("edu.isi.stella.Stella", "suffixMatchesP", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("ORDINAL-NUMBER-STRING?", "(DEFUN (ORDINAL-NUMBER-STRING? BOOLEAN) ((TESTSTRING STRING)))", Native.find_java_method("edu.isi.stella.Stella", "ordinalNumberStringP", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("HEURISTIC-ACRONYM?", "(DEFUN (HEURISTIC-ACRONYM? BOOLEAN) ((ITEMSTRING STRING)))", Native.find_java_method("edu.isi.stella.Stella", "heuristicAcronymP", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("COMPOSE-NAMESTRING-FULL", "(DEFUN (COMPOSE-NAMESTRING-FULL STRING) ((STRINGS (CONS OF STRING-WRAPPER)) (PREFIX STRING) (SUFFIX STRING) (OUTPUTCASE KEYWORD) (OUTPUTSEPARATOR STRING) (TRANSLATIONTABLE STRING-HASH-TABLE) (USEACRONYMHEURISTICS? BOOLEAN)) :PUBLIC? TRUE :DOCUMENTATION \"Non-keyword version of `compose-namestring', which will probably be\neasier to use when called from non-Lisp languages.\")", Native.find_java_method("edu.isi.stella.Cons", "composeNamestringFull", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.StringHashTable"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("STARTUP-NAME-UTILITY", "(DEFUN STARTUP-NAME-UTILITY () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupNameUtility", "startupNameUtility", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_NAME_UTILITY);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupNameUtility"), Stella.NULL_STRING_WRAPPER);
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
