//  -*- Mode: Java -*-
//
// Keyword.java

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

public class Keyword extends GeneralizedSymbol {
  /** Return the keyword with <code>name</code> if it exists.
   * @param name
   * @return Keyword
   */
  public static Keyword lookupKeyword(String name) {
    return (((Keyword)(GeneralizedSymbol.lookupRigidSymbol(name, Stella.KEYWORD_SYM))));
  }

  public static Keyword getKwdFromOffset(int offset) {
    return (((Keyword)(GeneralizedSymbol.getGeneralizedSymbolFromOffset(Stella.$KEYWORD_ARRAY$, offset))));
  }

  public static Keyword getKwd(int offset) {
    return (((Keyword)((Stella.$FIXED_KEYWORD_ARRAY$.theArray)[offset])));
  }

  public static Keyword newKeyword(String symbolName) {
    { Keyword self = null;

      self = new Keyword();
      self.symbolName = symbolName;
      self.homeContext = ((Context)(Stella.$CONTEXT$.get()));
      self.symbolId = Stella.NULL_INTEGER;
      return (self);
    }
  }

  public static int encodeStartupTimePhase(Keyword phase) {
    { int startuptimephaseasnumber = 0;

      if (!(Stella.$STARTUP_TIME_PHASES$.memberP(phase))) {
        phase = Stella.KWD_FINAL;
      }
      { Keyword ph = null;
        Cons iter000 = Stella.$STARTUP_TIME_PHASES$.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          ph = ((Keyword)(iter000.value));
          if (ph == phase) {
            return (startuptimephaseasnumber);
          }
          else {
            startuptimephaseasnumber = startuptimephaseasnumber + 1;
          }
        }
      }
      throw ((StellaException)(StellaException.newStellaException("`encode-startup-time-phase' should never get this far!").fillInStackTrace()));
    }
  }

  public void idlOutputLiteral() {
    { Keyword keyword = this;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(Keyword.idlTranslateKeywordName(keyword).wrapperValue);
    }
  }

  public static StringWrapper idlTranslateKeywordId(Keyword keyword) {
    return (GeneralizedSymbol.idlTranslateSymbolConstantId(keyword));
  }

  public static StringWrapper idlTranslateKeywordName(Keyword keyword) {
    return (GeneralizedSymbol.idlTranslateSymbolConstantName(keyword));
  }

  public void javaOutputLiteral() {
    { Keyword keyword = this;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(Keyword.javaTranslateKeywordName(keyword).wrapperValue);
    }
  }

  public static StringWrapper javaTranslateKeywordId(Keyword keyword) {
    return (GeneralizedSymbol.javaTranslateSymbolConstantId(keyword));
  }

  public static StringWrapper javaTranslateKeywordName(Keyword keyword) {
    return (GeneralizedSymbol.javaTranslateSymbolConstantName(keyword));
  }

  public static void cppOutputDefinitions(Keyword accesscontrolmode, Cons definitions) {
    Stella.cppIndent();
    if (accesscontrolmode == Stella.KWD_PUBLIC) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("public:");
    }
    else if (accesscontrolmode == Stella.KWD_PRIVATE) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("private:");
    }
    else if (accesscontrolmode == Stella.KWD_PROTECTED) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("protected:");
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + accesscontrolmode + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    if (accesscontrolmode != null) {
      Stella.cppBumpIndent();
    }
    { Stella_Object definition = null;
      Cons iter000 = definitions;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        definition = iter000.value;
        Stella.cppIndent();
        Stella_Object.cppOutputStatement(definition);
      }
    }
    if (accesscontrolmode != null) {
      Stella.cppUnbumpIndent();
    }
  }

  public static void cppOutputSignatures(Keyword accesscontrolmode, Cons signatures) {
    Stella.cppIndent();
    if (accesscontrolmode == Stella.KWD_PUBLIC) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("public:");
    }
    else if (accesscontrolmode == Stella.KWD_PRIVATE) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("private:");
    }
    else if (accesscontrolmode == Stella.KWD_PROTECTED) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("protected:");
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + accesscontrolmode + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    if (accesscontrolmode != null) {
      Stella.cppBumpIndent();
    }
    { Stella_Object signature = null;
      Cons iter000 = signatures;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        signature = iter000.value;
        Stella.cppIndent();
        Cons.cppOutputSignature(((Cons)(signature)), false);
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
      }
    }
    if (accesscontrolmode != null) {
      Stella.cppUnbumpIndent();
    }
  }

  public static void cppOutputDeclarations(Keyword accesscontrolmode, Cons declarations) {
    Stella.cppIndent();
    if (accesscontrolmode == Stella.KWD_PUBLIC) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("public:");
    }
    else if (accesscontrolmode == Stella.KWD_PRIVATE) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("private:");
    }
    else if (accesscontrolmode == Stella.KWD_PROTECTED) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("protected:");
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + accesscontrolmode + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    if (accesscontrolmode != null) {
      Stella.cppBumpIndent();
    }
    { Cons declaration = null;
      Cons iter000 = declarations;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        declaration = ((Cons)(iter000.value));
        if (declaration.rest.rest.value != null) {
          Stella.cppIndent();
          StringWrapper.cppOutputComment(((StringWrapper)(declaration.rest.rest.value)));
        }
        Stella.cppIndent();
        Stella_Object.cppOutputTypedEntity(declaration.value, declaration.rest.value, null);
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
      }
    }
    if (accesscontrolmode != null) {
      Stella.cppUnbumpIndent();
    }
  }

  public void cppOutputLiteral() {
    { Keyword keyword = this;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(Keyword.cppTranslateKeywordName(keyword).wrapperValue);
    }
  }

  public static StringWrapper cppTranslateKeywordId(Keyword keyword) {
    return (GeneralizedSymbol.cppTranslateSymbolConstantId(keyword));
  }

  public static StringWrapper cppTranslateKeywordName(Keyword keyword) {
    return (GeneralizedSymbol.cppTranslateSymbolConstantName(keyword));
  }

  public Cons cppTranslateAtomicTree() {
    { Keyword tree = this;

      if (Stella.useHardcodedSymbolsP()) {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_SYMBOL, Cons.cons(tree, Cons.cons(Stella.NIL, Stella.NIL)))));
      }
      else {
        return (GeneralizedSymbol.yieldSymbolConstantName(tree).cppTranslateAtomicTree());
      }
    }
  }

  /** A test demon for the property demon machinery which simply prints arguments.
   * @param action
   * @param property
   * @param value
   * @param table
   */
  public static void testPropertyDemon(Keyword action, String property, Stella_Object value, KeyValueList table) {
    table = table;
    Stella.STANDARD_OUTPUT.nativeStream.println("test-property-demon: action=" + action + ", property=" + property + ", value-arg=" + value + ", prop-value=" + Stella.lookupConfigurationProperty(property, null, table));
  }

  public static void runConfigurationPropertyDemon(Keyword action, String property, Stella_Object value, KeyValueList table) {
    { MappableObject demon = ((MappableObject)(Stella.$REGISTERED_PROPERTY_DEMONS$.lookup(StringWrapper.wrapString(property))));

      { Surrogate testValue000 = Stella_Object.safePrimaryType(demon);

        if (Surrogate.subtypeOfMethodSlotP(testValue000)) {
          { MethodSlot demon000 = ((MethodSlot)(demon));

            edu.isi.stella.javalib.Native.funcall(demon000.functionCode, null, new java.lang.Object [] {action, property, value, table});
          }
        }
        else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_GLOBAL_VARIABLE)) {
          { GlobalVariable demon000 = ((GlobalVariable)(demon));

            { MethodSlot setter = GlobalVariable.lookupVariableDemonSetter(demon000);

              if (setter != null) {
                value = Stella.lookupConfigurationProperty(property, null, table);
                { Surrogate variabletype = StandardObject.typeSpecToBaseType(GlobalVariable.globalVariableTypeSpec(demon000));
                  Stella_Object coercedvalue = ((value != null) ? Stella_Object.coerceValueToType(value, variabletype, false) : ((Stella_Object)(null)));

                  if ((value != null) &&
                      (coercedvalue == null)) {
                    Stella.STANDARD_WARNING.nativeStream.println("Warning: run-configuration-property-demon: cannot coerce `" + value + "' to type `" + variabletype + "'");
                    return;
                  }
                  if (variabletype == Stella.SGT_STELLA_INTEGER) {
                    edu.isi.stella.javalib.Native.funcall(setter.functionCode, null, new java.lang.Object [] {new Integer(IntegerWrapper.unwrapInteger(((IntegerWrapper)(coercedvalue))))});
                  }
                  else if (variabletype == Stella.SGT_STELLA_LONG_INTEGER) {
                    edu.isi.stella.javalib.Native.funcall(setter.functionCode, null, new java.lang.Object [] {new Long(LongIntegerWrapper.unwrapLongInteger(((LongIntegerWrapper)(coercedvalue))))});
                  }
                  else if (variabletype == Stella.SGT_STELLA_FLOAT) {
                    edu.isi.stella.javalib.Native.funcall(setter.functionCode, null, new java.lang.Object [] {new Double(FloatWrapper.unwrapFloat(((FloatWrapper)(coercedvalue))))});
                  }
                  else if (variabletype == Stella.SGT_STELLA_STRING) {
                    edu.isi.stella.javalib.Native.funcall(setter.functionCode, null, new java.lang.Object [] {StringWrapper.unwrapString(((StringWrapper)(coercedvalue)))});
                  }
                  else if (variabletype == Stella.SGT_STELLA_BOOLEAN) {
                    edu.isi.stella.javalib.Native.funcall(setter.functionCode, null, new java.lang.Object [] {new Boolean(((BooleanWrapper)(coercedvalue)) == Stella.TRUE_WRAPPER)});
                  }
                  else {
                    edu.isi.stella.javalib.Native.funcall(setter.functionCode, null, new java.lang.Object [] {coercedvalue});
                  }
                }
              }
              else {
                Stella.STANDARD_WARNING.nativeStream.println("Warning: run-configuration-property-demon: cannot find setter function for `" + demon000.variableName + "'");
              }
            }
          }
        }
        else {
        }
      }
    }
  }

  public static void transferDataFiles(Keyword outputLanguage) {
    { Cons dataFiles = ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).dataFiles;

      if (dataFiles != null) {
        Cons.transferFiles(dataFiles, outputLanguage);
      }
    }
  }

  public static void transferNativeSystemFiles(Keyword outputLanguage) {
    { Cons nativeFiles = null;

      if (outputLanguage == Stella.KWD_COMMON_LISP) {
        nativeFiles = ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).lispOnlyFiles;
      }
      else if (outputLanguage == Stella.KWD_JAVA) {
        nativeFiles = ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).javaOnlyFiles;
      }
      else if (outputLanguage == Stella.KWD_CPP) {
        nativeFiles = ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).cppOnlyFiles;
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + outputLanguage + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      if (nativeFiles != null) {
        nativeFiles = nativeFiles.difference(SystemDefinition.systemDefinitionSourceFiles(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get()))));
        Cons.transferFiles(nativeFiles, outputLanguage);
      }
    }
  }

  public static Keyword languageToFileType(Keyword language) {
    if (language == Stella.KWD_COMMON_LISP) {
      return (Stella.KWD_LISP);
    }
    else if (language == Stella.KWD_CPP) {
      return (Stella.KWD_CPP_CODE);
    }
    else {
      return (language);
    }
  }

  public static String selectSplitterPath(Keyword type) {
    { String splitterpath = "";

      if ((type == Stella.KWD_LISP) ||
          (type == Stella.KWD_COMMON_LISP)) {
        splitterpath = Stella.$LISP_SPLITTER_PATH$;
      }
      else if (type == Stella.KWD_JAVA) {
        splitterpath = Stella.$JAVA_SPLITTER_PATH$;
      }
      else if ((type == Stella.KWD_CPP) ||
          ((type == Stella.KWD_CPP_HEADER) ||
           ((type == Stella.KWD_CPP_CODE) ||
            ((type == Stella.KWD_C_HEADER) ||
             (type == Stella.KWD_C_CODE))))) {
        splitterpath = Stella.$CPP_SPLITTER_PATH$;
      }
      else if ((type == Stella.KWD_NONE) ||
          (type == Stella.KWD_OTHER)) {
        return (Keyword.selectSplitterPath(((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get()))));
      }
      else {
      }
      if (!Stella.stringEqlP(splitterpath, "")) {
        splitterpath = splitterpath + Stella.directorySeparatorString();
      }
      return (splitterpath);
    }
  }

  public static String selectRootDirectory(Keyword type) {
    { String root = null;

      if ((type == Stella.KWD_STELLA) ||
          (type == Stella.KWD_KB)) {
        root = Stella.rootSourceDirectory();
      }
      else if ((type == Stella.KWD_LISP_BINARY) ||
          (type == Stella.KWD_DIRECTORY)) {
        root = Stella.rootBinaryDirectory();
      }
      else {
        root = Stella.rootNativeDirectory();
      }
      return (root);
    }
  }

  public static String selectFileExtension(Keyword type) {
    { String extension = null;

      { Cons entry = null;
        Cons iter000 = Stella.$TYPE_TO_FILE_EXTENSION_TABLE$;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          entry = ((Cons)(iter000.value));
          if (entry.value == type) {
            extension = ((StringWrapper)(entry.rest.value)).wrapperValue;
          }
        }
      }
      if (type == Stella.KWD_DIRECTORY) {
        return (Stella.directorySeparatorString());
      }
      else if ((type == Stella.KWD_LISP) ||
          (type == Stella.KWD_LISP_BINARY)) {
        if (Stella.runningAsLispP()) {
          return (Keyword.computeCommonLispFileExtension(type));
        }
        else {
          return (Keyword.defaultCommonLispFileExtension(type));
        }
      }
      else {
      }
      return (extension);
    }
  }

  public static String defaultCommonLispFileExtension(Keyword type) {
    if (type == Stella.KWD_LISP) {
      if (Stella.$OS$ == Stella.KWD_WINDOWS) {
        return (".lsp");
      }
      else {
        return (".lisp");
      }
    }
    else if (type == Stella.KWD_LISP_BINARY) {
      if (Stella.$OS$ == Stella.KWD_MAC) {
        return (".cfsl");
      }
      else if (Stella.$OS$ == Stella.KWD_WINDOWS) {
        return (".fas");
      }
      else {
        return (".fasl");
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + type + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static String computeCommonLispFileExtension(Keyword type) {
    if (!(Stella.runningAsLispP())) {
      throw ((StellaException)(StellaException.newStellaException("Shouldn't call COMPUTE-COMMON-LISP-FILE-EXTENSION unless running in Lisp").fillInStackTrace()));
    }
    { String suffix = null;

      if (type == Stella.KWD_LISP_BINARY) {
        suffix = null;
        if (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_STRUCTS)) {
          suffix = "s" + suffix;
        }
        else if (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_VECTOR_STRUCTS)) {
          suffix = "vs" + suffix;
        }
        else {
        }
      }
      else if (type == Stella.KWD_LISP) {
        if (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_STRUCTS)) {
          suffix = ".slisp";
        }
        else if (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_VECTOR_STRUCTS)) {
          suffix = ".vslisp";
        }
        else {
          suffix = ".lisp";
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + type + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      return ("." + suffix);
    }
  }

  public static void bumpMemoizationTimestamp(Keyword timestampname) {
    { MemoizationTable table = null;
      Cons iter000 = Stella.$ALL_MEMOIZATION_TABLES$.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        table = ((MemoizationTable)(iter000.value));
        { boolean foundP000 = false;

          { Keyword ts = null;
            Cons iter001 = table.timestamps;

            loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              ts = ((Keyword)(iter001.value));
              if (ts == timestampname) {
                foundP000 = true;
                break loop001;
              }
            }
          }
          if (foundP000) {
            table.currentTimestamp = Cons.cons(null, Stella.NIL);
          }
        }
      }
    }
  }

  public static void clearMemoizationTables(Keyword timestampname) {
    { MemoizationTable table = null;
      Cons iter000 = Stella.$ALL_MEMOIZATION_TABLES$.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        table = ((MemoizationTable)(iter000.value));
        { boolean foundP000 = false;

          { Keyword ts = null;
            Cons iter001 = table.timestamps;

            loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              ts = ((Keyword)(iter001.value));
              if (ts == timestampname) {
                foundP000 = true;
                break loop001;
              }
            }
          }
          if (foundP000) {
            if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(table), Stella.SGT_STELLA_MRU_MEMOIZATION_TABLE)) {
              { MruMemoizationTable table000 = ((MruMemoizationTable)(table));

                if (table000.mruBucketsVector != null) {
                  table000.mruBucketsVector.clear();
                }
                if (table000.lruBucketsVector != null) {
                  table000.lruBucketsVector.clear();
                }
                table000.freeEntries = table000.maxEntries;
              }
            }
            else {
              table.hashTable = null;
            }
          }
        }
      }
    }
  }

  /** Expand to 'thenForm' if 'feature' is a currently enabled
   * STELLA environment feature.  Otherwise, expand to 'elseForm'.  This can
   * be used to conditionally translate Stella code.
   * @param feature
   * @param thenform
   * @param elseform
   * @return Stella_Object
   */
  public static Stella_Object ifStellaFeature(Keyword feature, Stella_Object thenform, Stella_Object elseform) {
    if (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(feature)) {
      return (((thenform == Stella.SYM_STELLA_NULL) ? null : thenform));
    }
    else {
      return (((elseform == Stella.SYM_STELLA_NULL) ? null : elseform));
    }
  }

  /** Expand to 'thenForm' if the current translator output
   * language equals 'language'.  Otherwise, expand to 'elseForm'.  This can
   * be used to conditionally translate Stella code.
   * @param language
   * @param thenform
   * @param elseform
   * @return Stella_Object
   */
  public static Stella_Object ifOutputLanguage(Keyword language, Stella_Object thenform, Stella_Object elseform) {
    if (language == ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get()))) {
      return (((thenform == Stella.SYM_STELLA_NULL) ? null : thenform));
    }
    else {
      return (((elseform == Stella.SYM_STELLA_NULL) ? null : elseform));
    }
  }

  /** Expands into the integer representing 'startupTimePhase'.
   * @param startuptimephase
   * @return Stella_Object
   */
  public static Stella_Object phaseToInteger(Keyword startuptimephase) {
    return (IntegerWrapper.wrapInteger(Keyword.encodeStartupTimePhase(startuptimephase)));
  }

  public Stella_Object clTranslateAtomicTree() {
    { Keyword tree = this;

      if (Stella.useHardcodedSymbolsP()) {
        { IntegerWrapper offset = IntegerWrapper.wrapInteger(tree.keywordify().symbolId);

          return (Cons.list$(Cons.cons(Stella.SYM_STELLA_GET_KWD, Cons.cons(offset, Cons.cons(Stella.NIL, Stella.NIL)))));
        }
      }
      else {
        return (Symbol.clTranslateGlobalSymbol(GeneralizedSymbol.yieldSymbolConstantName(tree)));
      }
    }
  }

  public Stella_Object walkAtomicTree(Object [] MV_returnarray) {
    { Keyword self = this;

      GeneralizedSymbol.registerSymbol(self);
      { Stella_Object _return_temp = self;

        MV_returnarray[0] = Stella.SGT_STELLA_KEYWORD;
        return (_return_temp);
      }
    }
  }

  /** Set output language to <code>newLanguage</code>.  Return previous language.
   * @param newLanguage
   * @return Keyword
   */
  public static Keyword setTranslatorOutputLanguage(Keyword newLanguage) {
    { Keyword oldlanguage = ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get()));

      if (!(Cons.list$(Cons.cons(Stella.KWD_CPP, Cons.cons(Stella.KWD_CPP_STANDALONE, Cons.cons(Stella.KWD_COMMON_LISP, Cons.cons(Stella.KWD_JAVA, Cons.cons(Stella.KWD_IDL, Cons.cons(Stella.NIL, Stella.NIL))))))).memberP(newLanguage))) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: `" + newLanguage + "' is not a legal translation language");
      }
      Native.setSpecial(Stella.$TRANSLATOROUTPUTLANGUAGE$, newLanguage);
      return (oldlanguage);
    }
  }

  /** Return true if the STELLA <code>feature</code> is currently disabled.
   * @param feature
   * @return boolean
   */
  public static boolean disabledStellaFeatureP(Keyword feature) {
    return (!((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(feature));
  }

  /** Return true if the STELLA <code>feature</code> is currently enabled.
   * @param feature
   * @return boolean
   */
  public static boolean enabledStellaFeatureP(Keyword feature) {
    return (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(feature));
  }

  public static void printKeyword(Keyword self, edu.isi.stella.javalib.NativeOutputStream stream) {
    stream.print(":");
    if (((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue()) {
      Stella.printSymbolNameReadably(self.symbolName, stream, false);
    }
    else {
      stream.print(self.symbolName);
    }
  }

  public Keyword keywordify() {
    { Keyword self = this;

      return (self);
    }
  }

  /** Generates a UUID of the specified type.  Legal types are
   * a subset of the IETF RFC 4122 (see http://www.ietf.org/rfc/rfc4122.txt )
   * UUID types.  Currently supported are:
   *     :TYPE-4  :RANDOM       A type-4 (random) UUID.  These are synonyms.
   * @param uuidType
   * @return String
   */
  public static String generateUuid(Keyword uuidType) {
    if ((uuidType == Stella.KWD_TYPE_4) ||
        (uuidType == Stella.KWD_RANDOM)) {
      return (Stella.generateRandomUuid());
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("UUIDs of type `" + uuidType + "' are not supported.");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { Keyword self = this;

      Keyword.printKeyword(self, stream);
    }
  }

  public static Stella_Object accessKeywordSlotValue(Keyword self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_KEYWORD_NAME) {
      if (setvalueP) {
        self.symbolName = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.symbolName);
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + slotname + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    return (value);
  }

  public Surrogate primaryType() {
    { Keyword self = this;

      return (Stella.SGT_STELLA_KEYWORD);
    }
  }

}

