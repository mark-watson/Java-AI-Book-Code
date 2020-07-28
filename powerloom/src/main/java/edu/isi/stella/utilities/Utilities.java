//  -*- Mode: Java -*-
//
// Utilities.java

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

public class Utilities {
  /** A list of features that can modulate some aspects of
   * how certain objects are described.  Currently understood features:
   * :INFIX-PARAMETER-LISTS.
   */
  public static List $TEXINFO_STYLE_FEATURES$ = null;

  public static Surrogate SGT_STELLA_CONS = null;

  public static Surrogate SGT_STELLA_TYPE_SPEC = null;

  public static String $TEXINFO_WORD_DELIMITERS$ = null;

  public static Symbol SYM_STELLA_VARIABLE_TYPE_SPECIFIER = null;

  public static Symbol SYM_STELLA_DOCUMENTATION = null;

  public static Symbol SYM_STELLA_SLOT_TYPE_SPECIFIER = null;

  public static Symbol SYM_STELLA_aREST = null;

  public static Symbol SYM_STELLA_aBODY = null;

  public static Symbol SYM_STELLA_METHOD_MACROp = null;

  public static Symbol SYM_STELLA_METHOD_COMMANDp = null;

  public static Symbol SYM_STELLA_METHOD_VARIABLE_ARGUMENTSp = null;

  public static Symbol SYM_STELLA_METHOD_BODY_ARGUMENTp = null;

  public static Keyword KWD_INFIX_PARAMETER_LISTS = null;

  public final static StellaSpecialVariable $MANUAL_OUTPUT_LANGUAGE$ = new StellaSpecialVariable();

  public static Keyword KWD_TEXINFO = null;

  public static HashTable $DOCUMENTED_OBJECTS_REGISTRY$ = null;

  public static Surrogate SGT_STELLA_SLOT = null;

  public static Surrogate SGT_STELLA_GLOBAL_VARIABLE = null;

  public static Surrogate SGT_STELLA_MODULE = null;

  public static Symbol SYM_UTILITIES_MANUAL_DESCRIBE_OBJECT = null;

  public final static StellaSpecialVariable $MANUAL_OUTPUT_STREAM$ = new StellaSpecialVariable();

  public static String $MANUAL_TEMPLATE_COMMAND_PREFIX$ = "#$";

  public static Symbol SYM_UTILITIES_STARTUP_MANUALS = null;

  public static Symbol SYM_STELLA_METHOD_STARTUP_CLASSNAME = null;

  static Cons $PRIME_NUMBERS$ = null;

  static int $CURRENT_PRIME_INDEX$ = -1;

  static StellaHashTable $PRIME_TO_MEASURE_TABLE$ = null;

  static IntegerHashTable $PRIME_TO_BASE_MEASURE_TABLE$ = null;

  static StringHashTable $NAME_TO_MEASURE_TABLE$ = null;

  static StringHashTable $UNIT_TO_MEASURE_TABLE$ = null;

  public static Cons $ALL_MEASURES$ = null;

  public static Cons $BASE_MEASURES$ = null;

  public static Ratio $RATIO_ONE$ = null;

  public static Surrogate SGT_UTILITIES_RATIO = null;

  public static Symbol SYM_UTILITIES_NUMERATOR = null;

  public static Symbol SYM_UTILITIES_DENOMINATOR = null;

  public static Cons $UNIT_TOKENIZER_TABLE_DEFINITION$ = null;

  public static Keyword KWD_START = null;

  public static Symbol SYM_STELLA_$ = null;

  public static Keyword KWD_INTEGER = null;

  public static Keyword KWD_DELIMITER = null;

  public static Keyword KWD_FRACTION = null;

  public static Keyword KWD_UNIT = null;

  public static Keyword KWD_EOF = null;

  public static Keyword KWD_OTHERWISE = null;

  public static Keyword KWD_ERROR = null;

  public static Keyword KWD_INCLUDE = null;

  public static TokenizerTable $UNIT_TOKENIZER_TABLE$ = null;

  public static Surrogate SGT_UTILITIES_MEASURE = null;

  public static Symbol SYM_UTILITIES_BASE_UNIT = null;

  public static Symbol SYM_UTILITIES_SCALE = null;

  public static Symbol SYM_UTILITIES_PRIME_ID = null;

  public static Symbol SYM_STELLA_NAME = null;

  public static Keyword KWD_PRESERVE = null;

  public static Surrogate SGT_UTILITIES_DIM_NUMBER = null;

  public static Symbol SYM_UTILITIES_PID = null;

  public static Symbol SYM_UTILITIES_MAGNITUDE = null;

  public static Symbol SYM_UTILITIES_PREFERRED_UNITS = null;

  public static Keyword KWD_DIGIT = null;

  public static Surrogate SGT_STELLA_TIME_DURATION = null;

  public static Symbol SYM_UTILITIES_STARTUP_UNITS = null;

  public static Symbol SYM_UTILITIES_STARTUP_UNIT_DEFS = null;

  public static Symbol SYM_UTILITIES_STARTUP_UTILITIES_SYSTEM = null;

  public static boolean texinfoSpecialCharacterP(char ch) {
    return (Native.string_memberP("@{}", ch));
  }

  public static String texinfoEscapeString(String string) {
    { int nOfSpecialChars = 0;
      StringBuffer escapedString = new StringBuffer(string);

      { char ch = Stella.NULL_CHARACTER;
        String vector000 = string;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          ch = vector000.charAt(index000);
          if (Utilities.texinfoSpecialCharacterP(ch)) {
            nOfSpecialChars = nOfSpecialChars + 1;
          }
        }
      }
      if (nOfSpecialChars > 0) {
        escapedString = new StringBuffer((Native.makeString(string.length() + nOfSpecialChars, Stella.NULL_CHARACTER)));
        { int i = 0;

          { char ch = Stella.NULL_CHARACTER;
            String vector001 = string;
            int index001 = 0;
            int length001 = vector001.length();

            for (;index001 < length001; index001 = index001 + 1) {
              ch = vector001.charAt(index001);
              if (Utilities.texinfoSpecialCharacterP(ch)) {
                edu.isi.stella.javalib.Native.mutableString_nthSetter(escapedString, '@', i);
                i = i + 1;
              }
              edu.isi.stella.javalib.Native.mutableString_nthSetter(escapedString, ch, i);
              i = i + 1;
            }
          }
        }
      }
      return (escapedString.toString());
    }
  }

  public static String yieldTexinfoTypeSpec(Stella_Object typeSpec) {
    { Stella_Object tree = typeSpec;

      { Surrogate testValue000 = Stella_Object.safePrimaryType(typeSpec);

        if (testValue000 == Utilities.SGT_STELLA_CONS) {
          { Cons typeSpec000 = ((Cons)(typeSpec));

            typeSpec000 = typeSpec000;
          }
        }
        else if (Surrogate.subtypeOfSymbolP(testValue000)) {
          { Symbol typeSpec000 = ((Symbol)(typeSpec));

            tree = StringWrapper.wrapString(typeSpec000.symbolName);
          }
        }
        else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
          { Surrogate typeSpec000 = ((Surrogate)(typeSpec));

            tree = StringWrapper.wrapString(typeSpec000.symbolName);
          }
        }
        else if (Surrogate.subtypeOfP(testValue000, Utilities.SGT_STELLA_TYPE_SPEC)) {
          { StandardObject typeSpec000 = ((StandardObject)(typeSpec));

            tree = StandardObject.yieldTypeSpecTree(typeSpec000);
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      return ("@sc{" + Utilities.texinfoEscapeString(Native.stringDowncase((Stella_Object.stringP(tree) ? ((StringWrapper)(tree)).wrapperValue : Native.stringify(tree)))) + "}");
    }
  }

  public static String yieldTexinfoBareName(Stella_Object name) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(name);

      if (Surrogate.subtypeOfStringP(testValue000)) {
        { StringWrapper name000 = ((StringWrapper)(name));

          return (name000.wrapperValue);
        }
      }
      else if (Surrogate.subtypeOfSymbolP(testValue000)) {
        { Symbol name000 = ((Symbol)(name));

          return (Utilities.texinfoEscapeString(Native.stringDowncase(name000.symbolName)));
        }
      }
      else if (testValue000 == Utilities.SGT_STELLA_CONS) {
        { Cons name000 = ((Cons)(name));

          return (Utilities.yieldTexinfoBareName(name000.value));
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static String yieldTexinfoParameterName(String name) {
    { boolean testValue000 = false;

      { boolean foundP000 = false;

        { char ch = Stella.NULL_CHARACTER;
          String vector000 = name;
          int index000 = 0;
          int length000 = vector000.length();

          loop000 : for (;index000 < length000; index000 = index000 + 1) {
            ch = vector000.charAt(index000);
            if (!(ch == Stella.$CHARACTER_UPCASE_TABLE$.charAt(((int) ch)))) {
              foundP000 = true;
              break loop000;
            }
          }
        }
        testValue000 = foundP000;
      }
      testValue000 = !testValue000;
      if (testValue000) {
        name = Native.stringDowncase(name);
      }
    }
    return (Utilities.texinfoEscapeString(name));
  }

  public static String yieldTexinfoConstant(Symbol name) {
    return ("@code{" + Utilities.texinfoEscapeString(Native.stringDowncase(name.symbolName)) + "}");
  }

  public static String texinfoGetParagraphCommand(String string, int start) {
    { int commandIndex = 0;

      loop000 : for (;;) {
        start = start + 1;
        switch (string.charAt(start)) {
          case ' ': 
            commandIndex = commandIndex + 1;
          break;
          case '\n': 
          case '\r': 
            break loop000;
          default:
            return (null);
        }
      }
      switch (commandIndex) {
        case 0: 
          return ("end");
        case 1: 
          return ("example");
        default:
          return ("unknown");
      }
    }
  }

  public static void texinfoDescribeDocumentationString(Stella_Object renamed_Object, String documentation, OutputStream stream, List parameters) {
    { String quotedName = null;
      int closingQuotePosition = Stella.NULL_INTEGER;
      boolean beginningOfLineP = true;
      boolean insideExampleP = false;
      String paragraphCommand = null;
      List pendingParagraphCommands = List.list(Stella.NIL);

      if (parameters == null) {
        parameters = Stella.NIL_LIST;
      }
      if (documentation == null) {
        documentation = "Not documented.";
      }
      if (documentation != null) {
        { char ch = Stella.NULL_CHARACTER;
          String vector000 = documentation;
          int index000 = 0;
          int length000 = vector000.length();
          int i = Stella.NULL_INTEGER;
          int iter000 = 0;

          loop000 : for (;index000 < length000; index000 = index000 + 1, iter000 = iter000 + 1) {
            ch = vector000.charAt(index000);
            i = iter000;
            switch (ch) {
              case '`': 
              case '\'': 
                if (!(insideExampleP)) {
                  if (i == closingQuotePosition) {
                    stream.nativeStream.print("}");
                    continue loop000;
                  }
                  else if ((i == 0) ||
                      Native.string_memberP(Utilities.$TEXINFO_WORD_DELIMITERS$, documentation.charAt((i - 1)))) {
                    closingQuotePosition = Native.string_position(documentation, '\'', i + 1);
                    if (closingQuotePosition != Stella.NULL_INTEGER) {
                      quotedName = Native.stringUpcase(Native.string_subsequence(documentation, i + 1, closingQuotePosition));
                      { boolean foundP000 = false;

                        { Symbol pname = null;
                          Cons iter001 = parameters.theConsList;

                          loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                            pname = ((Symbol)(iter001.value));
                            if (Stella.stringEqlP(pname.symbolName, quotedName)) {
                              foundP000 = true;
                              break loop001;
                            }
                          }
                        }
                        if (foundP000) {
                          stream.nativeStream.print("@var{");
                        }
                        else {
                          stream.nativeStream.print("@code{");
                        }
                      }
                      continue loop000;
                    }
                  }
                }
                stream.nativeStream.print(ch);
              break;
              case '\n': 
              case '\r': 
                beginningOfLineP = true;
                stream.nativeStream.print(ch);
                continue loop000;
              case '\t': 
                { boolean testValue000 = false;

                  testValue000 = beginningOfLineP;
                  if (testValue000) {
                    { 
                      paragraphCommand = Utilities.texinfoGetParagraphCommand(documentation, i);
                      testValue000 = paragraphCommand != null;
                    }
                  }
                  if (testValue000) {
                    {
                      if (Stella.stringEqlP(paragraphCommand, "end")) {
                        if (pendingParagraphCommands.emptyP()) {
                          {
                            Stella.STANDARD_WARNING.nativeStream.println("Warning: Mismatched @end command on `" + renamed_Object + "'");
                            paragraphCommand = "mismatched @end command";
                          }
                        }
                        else {
                          paragraphCommand = ((StringWrapper)(pendingParagraphCommands.pop())).wrapperValue;
                        }
                        stream.nativeStream.println("@end " + paragraphCommand);
                        if (Stella.stringEqlP(paragraphCommand, "example")) {
                          insideExampleP = false;
                        }
                      }
                      else {
                        pendingParagraphCommands.push(StringWrapper.wrapString(paragraphCommand));
                        if (Stella.stringEqlP(paragraphCommand, "example")) {
                          insideExampleP = true;
                        }
                        {
                          stream.nativeStream.println();
                          stream.nativeStream.print("@" + paragraphCommand);
                        }
;
                      }
                    }
                  }
                  else {
                    {
                      stream.nativeStream.print(ch);
                    }
                  }
                }
              break;
              default:
                if (Utilities.texinfoSpecialCharacterP(ch)) {
                  stream.nativeStream.print("@" + ch);
                }
                else {
                  stream.nativeStream.print(ch);
                }
              break;
            }
            beginningOfLineP = false;
          }
        }
      }
      stream.nativeStream.println();
    }
  }

  public static void texinfoDescribeVariable(GlobalVariable variable, OutputStream stream) {
    stream.nativeStream.print("@defvr ");
    if (variable.variableConstantP) {
      stream.nativeStream.print("Constant ");
    }
    else if (variable.variableSpecialP) {
      stream.nativeStream.print("@w{Special Variable} ");
    }
    else {
      stream.nativeStream.print("Variable ");
    }
    stream.nativeStream.println(Utilities.yieldTexinfoBareName(variable.variableName) + " : " + Utilities.yieldTexinfoTypeSpec(((((StandardObject)(KeyValueList.dynamicSlotValue(variable.dynamicSlots, Utilities.SYM_STELLA_VARIABLE_TYPE_SPECIFIER, null))) != null) ? ((StandardObject)(((StandardObject)(KeyValueList.dynamicSlotValue(variable.dynamicSlots, Utilities.SYM_STELLA_VARIABLE_TYPE_SPECIFIER, null))))) : variable.variableType)));
    Utilities.texinfoDescribeDocumentationString(variable, variable.documentation, stream, null);
    stream.nativeStream.println("@end defvr");
  }

  public static void texinfoDescribeClass(Stella_Class renamed_Class, OutputStream stream) {
    stream.nativeStream.print("@deftp Class " + Utilities.yieldTexinfoTypeSpec(Stella_Class.classSymbol(renamed_Class)));
    { Surrogate renamed_Super = null;
      Cons iter000 = renamed_Class.classDirectSupers.theConsList;
      int i = Stella.NULL_INTEGER;
      int iter001 = 1;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
        renamed_Super = ((Surrogate)(iter000.value));
        i = iter001;
        if (i == 1) {
          stream.nativeStream.print(" : ");
        }
        else {
          stream.nativeStream.print(", ");
        }
        stream.nativeStream.print(Utilities.yieldTexinfoTypeSpec(renamed_Super));
      }
    }
    stream.nativeStream.println();
    Utilities.texinfoDescribeDocumentationString(renamed_Class, ((StringWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Utilities.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue, stream, Stella.NIL_LIST);
    { Slot slot = null;
      Cons iter002 = renamed_Class.classLocalSlots.theConsList;

      for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
        slot = ((Slot)(iter002.value));
        if (Stella_Object.storageSlotP(slot) &&
            StorageSlot.parameterSlotP(((StorageSlot)(slot)))) {
          Utilities.texinfoDescribeSlot(((StorageSlot)(slot)), stream);
        }
      }
    }
    { Slot slot = null;
      Cons iter003 = renamed_Class.classLocalSlots.theConsList;

      for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
        slot = ((Slot)(iter003.value));
        if (Stella_Object.storageSlotP(slot) &&
            StorageSlot.nativeSlotP(((StorageSlot)(slot)))) {
          Utilities.texinfoDescribeSlot(((StorageSlot)(slot)), stream);
        }
      }
    }
    stream.nativeStream.println("@end deftp");
  }

  public static void texinfoDescribeSlot(StorageSlot slot, OutputStream stream) {
    { String category = "Slot";

      { CompoundTypeSpecifier temp000 = ((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Utilities.SYM_STELLA_SLOT_TYPE_SPECIFIER, null)));

        { StandardObject type = ((temp000 != null) ? ((StandardObject)(temp000)) : ((StandardObject)(slot.slotBaseType)));

          if (StorageSlot.parameterSlotP(slot)) {
            category = "@w{Class Parameter}";
          }
          else if (slot.abstractP) {
            category = "@w{Abstract Slot}";
          }
          stream.nativeStream.println("@defcv " + category + " {} " + Utilities.yieldTexinfoBareName(slot.slotName) + " : " + Utilities.yieldTexinfoTypeSpec(type));
          Utilities.texinfoDescribeDocumentationString(slot, ((StringWrapper)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Utilities.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue, stream, Stella.NIL_LIST);
          stream.nativeStream.println("@end defcv");
        }
      }
    }
  }

  public static List texinfoGetRealMethodParameterNames(MethodSlot method) {
    { List result = List.list(Stella.NIL);
      String documentation = ((StringWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Utilities.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue;
      String pName = null;
      int pNameLength = Stella.NULL_INTEGER;
      int start = Stella.NULL_INTEGER;
      int end = Stella.NULL_INTEGER;

      if (documentation == null) {
        documentation = "";
      }
      end = documentation.length() - 1;
      { Symbol parameter = null;
        Cons iter000 = method.methodParameterNames().theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          parameter = ((Symbol)(iter000.value));
          pName = parameter.symbolName;
          pNameLength = pName.length();
          { int value000 = Stella.NULL_INTEGER;

            { int i = Stella.NULL_INTEGER;
              IntegerIntervalIterator iter001 = Stella.interval(1, end - pNameLength);

              loop001 : while (iter001.nextP()) {
                i = iter001.value;
                { boolean testValue000 = false;

                  testValue000 = (documentation.charAt((i - 1)) == '`') ||
                      (documentation.charAt((i - 1)) == '\'');
                  if (testValue000) {
                    testValue000 = documentation.charAt((i + pNameLength)) == '\'';
                    if (testValue000) {
                      { boolean alwaysP000 = true;

                        { char ch = Stella.NULL_CHARACTER;
                          String vector000 = pName;
                          int index000 = 0;
                          int length000 = vector000.length();
                          int j = Stella.NULL_INTEGER;
                          int iter002 = 0;
                          int upperBound000 = pNameLength - 1;

                          loop002 : for (;(index000 < length000) &&
                                    (iter002 <= upperBound000); index000 = index000 + 1, iter002 = iter002 + 1) {
                            ch = vector000.charAt(index000);
                            j = iter002;
                            if (!(Stella.$CHARACTER_UPCASE_TABLE$.charAt(((int) ch)) == Stella.$CHARACTER_UPCASE_TABLE$.charAt(((int) (documentation.charAt((i + j))))))) {
                              alwaysP000 = false;
                              break loop002;
                            }
                          }
                        }
                        testValue000 = alwaysP000;
                      }
                    }
                  }
                  if (testValue000) {
                    value000 = i;
                    break loop001;
                  }
                }
              }
            }
            start = value000;
          }
          if (start != Stella.NULL_INTEGER) {
            pName = Native.string_subsequence(documentation, start, start + pNameLength);
          }
          if (collect000 == null) {
            {
              collect000 = Cons.cons(StringWrapper.wrapString(pName), Stella.NIL);
              if (result.theConsList == Stella.NIL) {
                result.theConsList = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(result.theConsList, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(StringWrapper.wrapString(pName), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (result);
    }
  }

  public static List texinfoGetRealMethodParametersAndTypes(MethodSlot method, Object [] MV_returnarray) {
    { String stringifiedSource = method.methodStringifiedSource;
      List realParameterNames = Utilities.texinfoGetRealMethodParameterNames(method);
      List realParameterTypes = List.list(Stella.NIL);
      List realReturnTypes = List.list(Stella.NIL);
      Cons definitionTree = null;
      Cons returnTypesTree = Stella.NIL;
      Cons parametersTree = Stella.NIL;

      { StandardObject pType = null;
        Cons iter000 = method.methodParameterTypeSpecifiers().theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          pType = ((StandardObject)(iter000.value));
          if (collect000 == null) {
            {
              collect000 = Cons.cons(StandardObject.yieldTypeSpecTree(pType), Stella.NIL);
              if (realParameterTypes.theConsList == Stella.NIL) {
                realParameterTypes.theConsList = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(realParameterTypes.theConsList, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(StandardObject.yieldTypeSpecTree(pType), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      { StandardObject rtype = null;
        Cons iter001 = method.methodReturnTypeSpecifiers().theConsList;
        Cons collect001 = null;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          rtype = ((StandardObject)(iter001.value));
          if (collect001 == null) {
            {
              collect001 = Cons.cons(StandardObject.yieldTypeSpecTree(rtype), Stella.NIL);
              if (realReturnTypes.theConsList == Stella.NIL) {
                realReturnTypes.theConsList = collect001;
              }
              else {
                Cons.addConsToEndOfConsList(realReturnTypes.theConsList, collect001);
              }
            }
          }
          else {
            {
              collect001.rest = Cons.cons(StandardObject.yieldTypeSpecTree(rtype), Stella.NIL);
              collect001 = collect001.rest;
            }
          }
        }
      }
      if (stringifiedSource != null) {
        definitionTree = ((Cons)(Stella.readSExpressionFromString(stringifiedSource)));
        if (Stella_Object.consP(definitionTree.rest.value)) {
          returnTypesTree = ((Cons)(definitionTree.rest.value)).rest;
        }
        parametersTree = ((Cons)(definitionTree.rest.rest.value));
        parametersTree = parametersTree.remove(Utilities.SYM_STELLA_aREST);
        parametersTree = parametersTree.remove(Utilities.SYM_STELLA_aBODY);
        { Cons ptree = null;
          Cons iter002 = parametersTree;
          ListIterator it = ((ListIterator)(realParameterTypes.allocateIterator()));

          for (;(!(iter002 == Stella.NIL)) &&
                    it.nextP(); iter002 = iter002.rest) {
            ptree = ((Cons)(iter002.value));
            it.valueSetter(ptree.last());
          }
        }
        { Stella_Object rtree = null;
          Cons iter003 = returnTypesTree;
          ListIterator it = ((ListIterator)(realReturnTypes.allocateIterator()));

          for (;(!(iter003 == Stella.NIL)) &&
                    it.nextP(); iter003 = iter003.rest) {
            rtree = iter003.value;
            it.valueSetter(rtree);
          }
        }
      }
      { List _return_temp = realParameterNames;

        MV_returnarray[0] = realParameterTypes;
        MV_returnarray[1] = realReturnTypes;
        return (_return_temp);
      }
    }
  }

  public static void texinfoDescribeMethod(MethodSlot method, OutputStream stream) {
    { String category = "Function";
      String endcmd = "@end deffn";

      if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Utilities.SYM_STELLA_METHOD_MACROp, Stella.FALSE_WRAPPER))).wrapperValue) {
        category = "Macro";
      }
      else if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Utilities.SYM_STELLA_METHOD_COMMANDp, Stella.FALSE_WRAPPER))).wrapperValue) {
        category = "Command";
      }
      else if (!method.methodFunctionP) {
        category = "Method";
      }
      if (!(method.methodEvaluateArgumentsP() ||
          ((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Utilities.SYM_STELLA_METHOD_MACROp, Stella.FALSE_WRAPPER))).wrapperValue)) {
        category = "N-" + category;
      }
      if (!method.methodFunctionP) {
        stream.nativeStream.print("@defmethod " + Utilities.yieldTexinfoTypeSpec(method.owner()) + " " + Utilities.yieldTexinfoBareName(method.slotName) + " ");
        endcmd = "@end defmethod";
      }
      else {
        stream.nativeStream.print("@deffn " + category + " " + Utilities.yieldTexinfoBareName(method.slotName) + " ");
        endcmd = "@end deffn";
      }
      stream.nativeStream.print("(");
      { List parameterNames = null;
        List parameterTypes = null;
        List returntypes = null;

        { Object [] caller_MV_returnarray = new Object[2];

          parameterNames = Utilities.texinfoGetRealMethodParametersAndTypes(method, caller_MV_returnarray);
          parameterTypes = ((List)(caller_MV_returnarray[0]));
          returntypes = ((List)(caller_MV_returnarray[1]));
        }
        { int nOfArguments = parameterNames.length();
          String modifier = null;

          { StringWrapper pName = null;
            Cons iter000 = parameterNames.theConsList;
            Stella_Object pType = null;
            Cons iter001 = parameterTypes.theConsList;
            int i = Stella.NULL_INTEGER;
            int iter002 = 1;

            for (;(!(iter000 == Stella.NIL)) &&
                      (!(iter001 == Stella.NIL)); 
                  iter000 = iter000.rest,
                  iter001 = iter001.rest,
                  iter002 = iter002 + 1) {
              pName = ((StringWrapper)(iter000.value));
              pType = iter001.value;
              i = iter002;
              modifier = null;
              if (i == nOfArguments) {
                if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Utilities.SYM_STELLA_METHOD_VARIABLE_ARGUMENTSp, Stella.FALSE_WRAPPER))).wrapperValue) {
                  modifier = "&rest";
                }
                if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Utilities.SYM_STELLA_METHOD_BODY_ARGUMENTp, Stella.FALSE_WRAPPER))).wrapperValue) {
                  modifier = "&body";
                }
              }
              if ((i == 1) &&
                  Stella.stringEqlP(category, "Method")) {
                stream.nativeStream.print(Utilities.yieldTexinfoParameterName(pName.wrapperValue));
              }
              else {
                Utilities.texinfoDescribeTypeDeclaration(pName.wrapperValue, ((StandardObject)(pType)), modifier, stream);
              }
              if (i < nOfArguments) {
                if (Utilities.$TEXINFO_STYLE_FEATURES$.memberP(Utilities.KWD_INFIX_PARAMETER_LISTS)) {
                  stream.nativeStream.print(", ");
                }
                else {
                  stream.nativeStream.print(" ");
                }
              }
            }
          }
          stream.nativeStream.print(")");
          stream.nativeStream.print(" : ");
          { Stella_Object rtype = null;
            Cons iter003 = returntypes.theConsList;

            for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
              rtype = iter003.value;
              stream.nativeStream.print(Utilities.yieldTexinfoTypeSpec(rtype) + " ");
            }
          }
          stream.nativeStream.println();
          Utilities.texinfoDescribeDocumentationString(method, ((StringWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Utilities.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue, stream, method.methodParameterNames());
          stream.nativeStream.println(endcmd);
        }
      }
    }
  }

  public static void texinfoDescribeTypeDeclaration(String parameter, StandardObject type, String modifier, OutputStream stream) {
    stream.nativeStream.print("@w{");
    if (modifier != null) {
      stream.nativeStream.print(modifier + " ");
    }
    { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

      try {
        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
        if (Utilities.$TEXINFO_STYLE_FEATURES$.memberP(Utilities.KWD_INFIX_PARAMETER_LISTS)) {
          stream.nativeStream.print(Utilities.yieldTexinfoParameterName(parameter) + " : " + Utilities.yieldTexinfoTypeSpec(type));
        }
        else {
          stream.nativeStream.print("(" + Utilities.yieldTexinfoParameterName(parameter) + " " + Utilities.yieldTexinfoTypeSpec(type) + ")");
        }
        stream.nativeStream.print("}");

      } finally {
        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
      }
    }
  }

  public static void texinfoDescribeUnimplementedObject(Stella_Object specification, OutputStream stream) {
    {
      stream.nativeStream.println("@deffn ??? " + Utilities.yieldTexinfoBareName(specification));
      stream.nativeStream.println("Not yet implemented.");
      stream.nativeStream.println("@end deffn");
    }
;
  }

  public static void registerDocumentedObject(Stella_Object renamed_Object) {
    Utilities.$DOCUMENTED_OBJECTS_REGISTRY$.insertAt(renamed_Object, renamed_Object);
  }

  public static boolean alreadyDocumentedObjectP(Stella_Object renamed_Object) {
    return (Utilities.$DOCUMENTED_OBJECTS_REGISTRY$.lookup(renamed_Object) != null);
  }

  public static void clearDocumentedObjectsRegistry() {
    Utilities.$DOCUMENTED_OBJECTS_REGISTRY$.initializeHashTable();
  }

  public static Stella_Object lookupObjectFromSpecification(Stella_Object specification) {
    { Stella_Object renamed_Object = null;

      { Surrogate testValue000 = Stella_Object.safePrimaryType(specification);

        if (Surrogate.subtypeOfSurrogateP(testValue000)) {
          { Surrogate specification000 = ((Surrogate)(specification));

            renamed_Object = ((Stella_Class)(specification000.surrogateValue));
          }
        }
        else if (Surrogate.subtypeOfSymbolP(testValue000)) {
          { Symbol specification000 = ((Symbol)(specification));

            renamed_Object = Symbol.lookupFunction(specification000);
            if (renamed_Object == null) {
              renamed_Object = specification000.lookupGlobalVariable();
            }
            if (renamed_Object == null) {
              renamed_Object = specification000.lookupClass();
            }
            if (renamed_Object == null) {
              renamed_Object = Stella.string_getObject(specification000.symbolName, null);
            }
          }
        }
        else if (testValue000 == Utilities.SGT_STELLA_CONS) {
          { Cons specification000 = ((Cons)(specification));

            { Symbol classsymbol = ((Symbol)(specification000.rest.value));
              Stella_Class renamed_Class = null;

              { Object old$Module$000 = Stella.$MODULE$.get();
                Object old$Context$000 = Stella.$CONTEXT$.get();

                try {
                  Native.setSpecial(Stella.$MODULE$, ((Module)(classsymbol.homeContext)));
                  Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
                  renamed_Class = ((Symbol)(specification000.rest.value)).getStellaClass(false);

                } finally {
                  Stella.$CONTEXT$.set(old$Context$000);
                  Stella.$MODULE$.set(old$Module$000);
                }
              }
              if (renamed_Class == null) {
                Stella.STANDARD_OUTPUT.nativeStream.print("Can't find a class named " + specification000.rest.value);
                return (null);
              }
              return (Stella_Class.lookupSlot(renamed_Class, ((Symbol)(specification000.value))));
            }
          }
        }
        else if (Surrogate.subtypeOfStringP(testValue000)) {
          { StringWrapper specification000 = ((StringWrapper)(specification));

            renamed_Object = Stella.getStellaModule(specification000.wrapperValue, false);
          }
        }
        else {
        }
      }
      return (renamed_Object);
    }
  }

  public static boolean texinfoObjectL(Stella_Object object1, Stella_Object object2) {
    { String name1 = null;
      String name2 = null;

      { Surrogate testValue000 = Stella_Object.safePrimaryType(object1);

        if (Surrogate.subtypeOfP(testValue000, Utilities.SGT_STELLA_SLOT)) {
          { Slot object1000 = ((Slot)(object1));

            name1 = object1000.slotName.visibleName(false);
          }
        }
        else if (Surrogate.subtypeOfP(testValue000, Utilities.SGT_STELLA_GLOBAL_VARIABLE)) {
          { GlobalVariable object1000 = ((GlobalVariable)(object1));

            name1 = object1000.variableName.visibleName(false);
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      { Surrogate testValue001 = Stella_Object.safePrimaryType(object2);

        if (Surrogate.subtypeOfP(testValue001, Utilities.SGT_STELLA_SLOT)) {
          { Slot object2000 = ((Slot)(object2));

            name2 = object2000.slotName.visibleName(false);
          }
        }
        else if (Surrogate.subtypeOfP(testValue001, Utilities.SGT_STELLA_GLOBAL_VARIABLE)) {
          { GlobalVariable object2000 = ((GlobalVariable)(object2));

            name2 = object2000.variableName.visibleName(false);
          }
        }
        else {
          { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

            stream001.nativeStream.print("`" + testValue001 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
          }
        }
      }
      return (Stella.stringL(name1, name2));
    }
  }

  public static void manualDescribeUncategorizedObjects(Module module, OutputStream stream) {
    { List methods = List.newList();

      { MethodSlot function = null;
        Iterator iter000 = Module.allFunctions(module, true);
        Cons collect000 = null;

        while (iter000.nextP()) {
          function = ((MethodSlot)(iter000.value));
          if ((((StringWrapper)(KeyValueList.dynamicSlotValue(function.dynamicSlots, Utilities.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue != null) &&
              (!Utilities.alreadyDocumentedObjectP(function))) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(function, Stella.NIL);
                if (methods.theConsList == Stella.NIL) {
                  methods.theConsList = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(methods.theConsList, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(function, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      { MethodSlot method = null;
        Iterator iter001 = Module.allMethods(module, true);
        Cons collect001 = null;

        while (iter001.nextP()) {
          method = ((MethodSlot)(iter001.value));
          if ((((StringWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Utilities.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue != null) &&
              (!Utilities.alreadyDocumentedObjectP(method))) {
            if (collect001 == null) {
              {
                collect001 = Cons.cons(method, Stella.NIL);
                if (methods.theConsList == Stella.NIL) {
                  methods.theConsList = collect001;
                }
                else {
                  Cons.addConsToEndOfConsList(methods.theConsList, collect001);
                }
              }
            }
            else {
              {
                collect001.rest = Cons.cons(method, Stella.NIL);
                collect001 = collect001.rest;
              }
            }
          }
        }
      }
      methods.sort(Native.find_java_method("edu.isi.stella.utilities.Utilities", "texinfoObjectL", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}));
      { MethodSlot method = null;
        Cons iter002 = methods.theConsList;

        for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
          method = ((MethodSlot)(iter002.value));
          Utilities.manualDescribeObject(method, null, stream);
          stream.nativeStream.println();
        }
      }
    }
  }

  public static void manualDescribeObject(Stella_Object renamed_Object, Stella_Object specification, OutputStream stream) {
    if (renamed_Object == null) {
      renamed_Object = Utilities.lookupObjectFromSpecification(specification);
    }
    if (((Keyword)(Utilities.$MANUAL_OUTPUT_LANGUAGE$.get())) == Utilities.KWD_TEXINFO) {
      if (renamed_Object == null) {
        if (specification != null) {
          Utilities.texinfoDescribeUnimplementedObject(specification, stream);
        }
      }
      else {
        { Surrogate testValue000 = Stella_Object.safePrimaryType(renamed_Object);

          if (Surrogate.subtypeOfP(testValue000, Utilities.SGT_STELLA_GLOBAL_VARIABLE)) {
            { GlobalVariable object000 = ((GlobalVariable)(renamed_Object));

              Utilities.texinfoDescribeVariable(object000, stream);
            }
          }
          else if (Surrogate.subtypeOfClassP(testValue000)) {
            { Stella_Class object000 = ((Stella_Class)(renamed_Object));

              Utilities.texinfoDescribeClass(object000, stream);
            }
          }
          else if (Surrogate.subtypeOfMethodSlotP(testValue000)) {
            { MethodSlot object000 = ((MethodSlot)(renamed_Object));

              Utilities.texinfoDescribeMethod(object000, stream);
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Utilities.SGT_STELLA_MODULE)) {
            { Module object000 = ((Module)(renamed_Object));

              Utilities.manualDescribeUncategorizedObjects(object000, stream);
            }
          }
          else {
            { Symbol handlername = Symbol.internSymbolInModule("TEXINFO-DESCRIBE-" + renamed_Object.primaryType().symbolName, ((Module)(Utilities.SYM_UTILITIES_MANUAL_DESCRIBE_OBJECT.homeContext)), true);
              MethodSlot handler = Symbol.lookupFunction(handlername);

              if (handler != null) {
                edu.isi.stella.javalib.Native.funcall(handler.functionCode, null, new java.lang.Object [] {renamed_Object, stream});
              }
            }
          }
        }
        Utilities.registerDocumentedObject(renamed_Object);
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + ((Keyword)(Utilities.$MANUAL_OUTPUT_LANGUAGE$.get())) + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  /** Generate a TEXINFO file containing a list of
   * documented commands.  'manual-spec' is a CONS list of entries, where each
   * entry is of the following form:
   * <p>
   *       (&lt;filename&gt; &lt;object-spec1&gt; &lt;object-spec2&gt; ... &lt;object-specN&gt;)
   * <p>
   * The objects specified by &lt;object-spec&gt;s will be documented in sequence onto
   * file &lt;filename&gt;.  An object spec can be a simple symbol to name a function,
   * macro or variable, a dotted symbol to name a method or slot, a surrogate
   * to name a class, or a string (pathname) to name a module.  If a module is
   * specified, all as yet undocumented objects in that module that have a
   * documentation string defined will be documented (this is a catch-all option).
   * @param manualSpec
   */
  public static void generateManual(Cons manualSpec) {
    { OutputFileStream stream = null;

      Utilities.clearDocumentedObjectsRegistry();
      { Cons filespec = null;
        Cons iter000 = manualSpec;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          filespec = ((Cons)(iter000.value));
          stream = OutputFileStream.newOutputFileStream(((StringWrapper)(filespec.value)).wrapperValue);
          { Stella_Object spec = null;
            Cons iter001 = filespec.rest;

            for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              spec = iter001.value;
              Utilities.manualDescribeObject(null, spec, stream);
              stream.nativeStream.println();
            }
          }
          stream.free();
        }
      }
    }
  }

  public static void generateManualFromTemplate(String templatefile, String outputfile) {
    { OutputFileStream outStream = null;

      try {
        outStream = Stella.openOutputFile(outputfile, Stella.NIL);
        { Object old$ManualOutputStream$000 = Utilities.$MANUAL_OUTPUT_STREAM$.get();

          try {
            Native.setSpecial(Utilities.$MANUAL_OUTPUT_STREAM$, outStream);
            { InputFileStream inStream = null;

              try {
                inStream = Stella.openInputFile(templatefile, Stella.NIL);
                { String line = null;
                  LineIterator iter000 = InputStream.lines(inStream);

                  while (iter000.nextP()) {
                    line = iter000.value;
                    ((OutputStream)(Utilities.$MANUAL_OUTPUT_STREAM$.get())).nativeStream.println(Utilities.manualExpandTemplateCommands(line));
                  }
                }

              } finally {
                if (inStream != null) {
                  inStream.free();
                }
              }
            }

          } finally {
            Utilities.$MANUAL_OUTPUT_STREAM$.set(old$ManualOutputStream$000);
          }
        }

      } finally {
        if (outStream != null) {
          outStream.free();
        }
      }
    }
  }

  public static String manualExpandTemplateCommands(String line) {
    { int commandstart = Native.stringSearch(line, Utilities.$MANUAL_TEMPLATE_COMMAND_PREFIX$, 0);

      if (commandstart == Stella.NULL_INTEGER) {
        return (line);
      }
      try {
        { String prefix = Native.string_subsequence(line, 0, commandstart);
          InputStringStream restline = InputStringStream.newInputStringStream(Native.string_subsequence(line, commandstart + Utilities.$MANUAL_TEMPLATE_COMMAND_PREFIX$.length(), Stella.NULL_INTEGER));
          Stella_Object expression = InputStream.readSExpression(restline, new Object[1]);

          { Object old$ManualOutputStream$000 = Utilities.$MANUAL_OUTPUT_STREAM$.get();

            try {
              Native.setSpecial(Utilities.$MANUAL_OUTPUT_STREAM$, OutputStringStream.newOutputStringStream());
              Stella_Object.evaluate(expression);
              line = InputStream.readLine(restline);
              if (line == null) {
                line = "";
              }
              return (prefix + ((OutputStringStream)(((OutputStream)(Utilities.$MANUAL_OUTPUT_STREAM$.get())))).theStringReader() + Utilities.manualExpandTemplateCommands(line));

            } finally {
              Utilities.$MANUAL_OUTPUT_STREAM$.set(old$ManualOutputStream$000);
            }
          }
        }
      } catch (java.lang.Exception e) {
        {
          Stella.STANDARD_OUTPUT.nativeStream.println("*** ERROR while expanding template command: " + Stella.exceptionMessage(e));
          Stella.STANDARD_OUTPUT.nativeStream.println("    Error occured in line: `" + line + "'");
        }
;
        return (line);
      }
    }
  }

  public static void texinfoInsertDoc(Stella_Object spec) {
    { Object old$ManualOutputLanguage$000 = Utilities.$MANUAL_OUTPUT_LANGUAGE$.get();

      try {
        Native.setSpecial(Utilities.$MANUAL_OUTPUT_LANGUAGE$, Utilities.KWD_TEXINFO);
        Utilities.manualDescribeObject(null, spec, ((OutputStream)(Utilities.$MANUAL_OUTPUT_STREAM$.get())));

      } finally {
        Utilities.$MANUAL_OUTPUT_LANGUAGE$.set(old$ManualOutputLanguage$000);
      }
    }
  }

  public static void texinfoInsertPreamble() {
    { Object old$ManualOutputLanguage$000 = Utilities.$MANUAL_OUTPUT_LANGUAGE$.get();

      try {
        Native.setSpecial(Utilities.$MANUAL_OUTPUT_LANGUAGE$, Utilities.KWD_TEXINFO);
        ((OutputStream)(Utilities.$MANUAL_OUTPUT_STREAM$.get())).nativeStream.print("@c DO NOT MODIFY THIS FILE, IT WAS GENERATED AUTOMATICALLY FROM A TEMPLATE!");

      } finally {
        Utilities.$MANUAL_OUTPUT_LANGUAGE$.set(old$ManualOutputLanguage$000);
      }
    }
  }

  static int nextPrimeId() {
    Utilities.$CURRENT_PRIME_INDEX$ = Utilities.$CURRENT_PRIME_INDEX$ + 1;
    return (((IntegerWrapper)(Utilities.$PRIME_NUMBERS$.nth(Utilities.$CURRENT_PRIME_INDEX$))).wrapperValue);
  }

  public static int ipower(int x, int exp) {
    if (exp < 0) {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("Illegal negative exponent: `" + exp + "'");
        throw ((BadArgumentException)(BadArgumentException.newBadArgumentException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    else {
      { int result = 1;

        while ((exp = exp - 1) >= 0) {
          result = result * x;
        }
        return (result);
      }
    }
  }

  public static void resetMeasures() {
    Utilities.$CURRENT_PRIME_INDEX$ = -1;
    Utilities.$PRIME_TO_MEASURE_TABLE$ = StellaHashTable.newStellaHashTable();
    Utilities.$PRIME_TO_BASE_MEASURE_TABLE$ = IntegerHashTable.newIntegerHashTable();
    Utilities.$NAME_TO_MEASURE_TABLE$ = StringHashTable.newStringHashTable();
    Utilities.$UNIT_TO_MEASURE_TABLE$ = StringHashTable.newStringHashTable();
    Utilities.$ALL_MEASURES$ = Stella.NIL;
    Utilities.$BASE_MEASURES$ = Stella.NIL;
  }

  public static double unitToScaleFactorAndId(String definition, Object [] MV_returnarray) {
    { double scaleFactor = 1.0;
      Ratio id = Utilities.$RATIO_ONE$;
      double factor = Stella.NULL_FLOAT;
      Ratio pid = null;
      boolean invertP = false;
      String oneUnit = null;
      int exponentValue = Stella.NULL_INTEGER;
      Measure m = null;
      boolean scaledP = true;

      { TokenizerTable tok_table_ = Utilities.$UNIT_TOKENIZER_TABLE$;
        String tok_transitions_ = tok_table_.transitions;
        edu.isi.stella.Stella_Object[] tok_statenames_ = tok_table_.stateNames.theArray;
        int tok_tokenstart_ = -1;
        boolean tok_endoftokensP_ = false;
        TokenizerStreamState tok_streamstate_ = null;
        char[] tok_buffer_ = definition.toCharArray();
        int tok_state_ = 1;
        int tok_nextstate_ = tok_state_;
        int tok_cursor_ = 0;
        int tok_size_ = definition.length();
        int tok_end_ = tok_size_;

        {
          tok_statenames_ = tok_statenames_;
          tok_endoftokensP_ = tok_endoftokensP_;
        }
        tok_streamstate_ = tok_streamstate_;
        loop000 : for (;;) {
          {
            tok_tokenstart_ = -1;
            loop001 : for (;;) {
              if (tok_cursor_ == tok_end_) {
                if (tok_nextstate_ == -1) {
                  tok_endoftokensP_ = true;
                }
                else if (BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)((tok_table_.legalEofStates.theArray)[tok_state_])))) {
                  tok_nextstate_ = -1;
                  if (tok_tokenstart_ == -1) {
                    tok_endoftokensP_ = true;
                  }
                }
                else {
                  tok_state_ = 0;
                  tok_nextstate_ = -1;
                }
                break loop001;
              }
              tok_nextstate_ = (int) (tok_buffer_[tok_cursor_]);
              tok_nextstate_ = (int) (tok_transitions_.charAt(((((tok_state_ << 8)) | tok_nextstate_))));
              if ((tok_nextstate_ & 128) == 0) {
                tok_state_ = tok_nextstate_;
                tok_cursor_ = tok_cursor_ + 1;
              }
              else if (tok_tokenstart_ == -1) {
                if ((tok_nextstate_ & 64) == 0) {
                  tok_tokenstart_ = tok_cursor_;
                }
                tok_state_ = (tok_nextstate_ & 63);
                tok_cursor_ = tok_cursor_ + 1;
              }
              else {
                break loop001;
              }
            }
          }
          if (tok_endoftokensP_) {
            break loop000;
          }
          { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tok_statenames_[tok_state_]));

            if (testValue000 == Utilities.KWD_UNIT) {
              oneUnit = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false);
              m = ((Measure)(Utilities.$UNIT_TO_MEASURE_TABLE$.lookup(oneUnit)));
              if (m == null) {
                { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                  stream000.nativeStream.print("Unrecognized unit: `" + definition + "'");
                  throw ((BadArgumentException)(BadArgumentException.newBadArgumentException(stream000.theStringReader()).fillInStackTrace()));
                }
              }
              factor = ((FloatWrapper)(m.scale.lookup(StringWrapper.wrapString(oneUnit)))).wrapperValue;
              pid = m.primeId;
              scaledP = false;
            }
            else if (testValue000 == Utilities.KWD_INTEGER) {
              exponentValue = ((int)(Native.stringToInteger(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false))));
              if (invertP) {
                exponentValue = 0 - exponentValue;
              }
              factor = Math.pow(factor,(((double)(exponentValue))));
              pid = pid.exponentiate(exponentValue);
              scaleFactor = scaleFactor * factor;
              id = id.multiply(pid);
              scaledP = true;
            }
            else if (testValue000 == Utilities.KWD_FRACTION) {
              if (!(scaledP)) {
                scaleFactor = scaleFactor * factor;
                id = id.multiply(pid);
                scaledP = true;
              }
              if (invertP) {
                { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                  stream001.nativeStream.print("Multiple / signs in units expression is not allowed: `" + definition + "'");
                  throw ((BadArgumentException)(BadArgumentException.newBadArgumentException(stream001.theStringReader()).fillInStackTrace()));
                }
              }
              else {
                invertP = true;
              }
            }
            else if (testValue000 == Utilities.KWD_ERROR) {
              { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                stream002.nativeStream.print("Error in units expression:  Not legal syntax: `" + definition + "'");
                throw ((BadArgumentException)(BadArgumentException.newBadArgumentException(stream002.theStringReader()).fillInStackTrace()));
              }
            }
            else if (testValue000 == Utilities.KWD_DELIMITER) {
              if (invertP) {
                {
                  scaleFactor = scaleFactor / factor;
                  id = id.divide(pid);
                }
              }
              else {
                {
                  scaleFactor = scaleFactor * factor;
                  id = id.multiply(pid);
                }
              }
              scaledP = true;
            }
            else {
              { OutputStringStream stream003 = OutputStringStream.newOutputStringStream();

                stream003.nativeStream.print("`" + testValue000 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream003.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
      }
      if (!(scaledP)) {
        if (invertP) {
          {
            scaleFactor = scaleFactor / factor;
            id = id.divide(pid);
          }
        }
        else {
          {
            scaleFactor = scaleFactor * factor;
            id = id.multiply(pid);
          }
        }
      }
      { double _return_temp = scaleFactor;

        MV_returnarray[0] = id;
        return (_return_temp);
      }
    }
  }

  public static Cons computeMeasuresForInteger(int value) {
    { Cons measures = Stella.NIL;
      int p = 1;

      { IntegerWrapper prime = null;
        Cons iter000 = Utilities.$PRIME_NUMBERS$;

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          prime = ((IntegerWrapper)(iter000.value));
          p = prime.wrapperValue;
          while ((value % p) == 0) {
            value = ((int)(((double)(value)) / p));
            measures = Cons.cons(((Measure)(Utilities.$PRIME_TO_BASE_MEASURE_TABLE$.lookup(p))), measures);
          }
          if (value < p) {
            break loop000;
          }
        }
      }
      return (measures.reverse());
    }
  }

  public static String computeUnitsForInteger(int value, boolean negateExponentP) {
    { StringBuffer buffer = Stella.makeRawMutableString(128);
      int i = 0;
      int p = 1;
      int e = 0;
      boolean previousNoExponentP = false;

      { IntegerWrapper prime = null;
        Cons iter000 = Utilities.$PRIME_NUMBERS$;

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          prime = ((IntegerWrapper)(iter000.value));
          e = 0;
          p = prime.wrapperValue;
          while ((value % p) == 0) {
            value = ((int)(((double)(value)) / p));
            e = e + 1;
          }
          if (e > 0) {
            if (previousNoExponentP) {
              edu.isi.stella.javalib.Native.mutableString_nthSetter(buffer, '.', i);
              i = i + 1;
            }
            i = Stella.insertString(((Measure)(Utilities.$PRIME_TO_BASE_MEASURE_TABLE$.lookup(p))).baseUnit, 0, Stella.NULL_INTEGER, buffer, i, Utilities.KWD_PRESERVE);
            if (negateExponentP) {
              i = Stella.insertString(Native.integerToString(((long)(0 - e))), 0, Stella.NULL_INTEGER, buffer, i, Utilities.KWD_PRESERVE);
              previousNoExponentP = false;
            }
            else if (e > 1) {
              i = Stella.insertString(Native.integerToString(((long)(e))), 0, Stella.NULL_INTEGER, buffer, i, Utilities.KWD_PRESERVE);
              previousNoExponentP = false;
            }
            else {
              previousNoExponentP = true;
            }
          }
          if (value < p) {
            break loop000;
          }
        }
      }
      return (Native.mutableString_subsequence(buffer, 0, i));
    }
  }

  /** Converts the time duration <code>duration</code> to its
   * equivalent value as dimensioned number.  The default time unit
   * will be used.
   * @param duration
   * @return DimNumber
   */
  public static DimNumber timeDurationToDim(TimeDuration duration) {
    return (DimNumber.makeDimNumber(((double)(duration.days)), "days").add(DimNumber.makeDimNumber(((double)(duration.millis)), "ms")));
  }

  /** Converts a (Degree Minute Second) to decimal degrees.
   * @param l
   * @return DimNumber
   */
  public static DimNumber dmsToDegrees(Cons l) {
    { DimNumber degrees = ((DimNumber)(l.value));

      { DimNumber value = null;
        Cons iter000 = l.rest;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          value = ((DimNumber)(iter000.value));
          degrees = degrees.add(value);
        }
      }
      return (degrees);
    }
  }

  /** Converts a (Hour Minute Second) to decimal hours
   * @param l
   * @return DimNumber
   */
  public static DimNumber hmsToHours(Cons l) {
    { DimNumber hours = ((DimNumber)(l.value));

      { DimNumber value = null;
        Cons iter000 = l.rest;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          value = ((DimNumber)(iter000.value));
          hours = hours.add(value);
        }
      }
      return (hours);
    }
  }

  /** Print all defined measures.
   */
  public static void showMeasures() {
    { Measure m = null;
      Cons iter000 = Utilities.$ALL_MEASURES$;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        m = ((Measure)(iter000.value));
        Stella.STANDARD_OUTPUT.nativeStream.println(m.name + "   base-unit=" + m.baseUnit + "   prime-id=" + m.primeId + ((m.baseMeasureP() ? "   BASE" : "   DERIVED")));
      }
    }
  }

  /** Print all units and scale factors for measure <code>measureName</code>.
   * @param measureName
   */
  public static void showMeasure(String measureName) {
    { Measure m = Measure.lookupMeasure(measureName);

      if (m != null) {
        { KeyValueList theScale = m.scale;

          Stella.STANDARD_OUTPUT.nativeStream.println(measureName + "   base-unit=" + m.baseUnit + "   prime-id=" + m.primeId + ((m.baseMeasureP() ? "   BASE" : "   DERIVED")));
          { StringWrapper u = null;
            Cons iter000 = m.getUnits().theConsList;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              u = ((StringWrapper)(iter000.value));
              Stella.STANDARD_OUTPUT.nativeStream.println("  " + StringWrapper.unwrapString(u) + "   factor=" + FloatWrapper.unwrapFloat(((FloatWrapper)(theScale.lookup(u)))));
            }
          }
        }
      }
      else {
        Stella.STANDARD_OUTPUT.nativeStream.println("No measure with name `" + measureName + "' found.");
      }
    }
  }

  public static void showMeasureEvaluatorWrapper(Cons arguments) {
    Utilities.showMeasure(((StringWrapper)(arguments.value)).wrapperValue);
  }

  /** Measure conversion factors.  The ultimate source for the
   * conversions are the following publications.  NIST was normally followed
   * unless a more precise value was found in MfM.
   * <p>
   * Sources:
   * [NIST]
   *   Guide for the Use of the International System of Units (SI)
   *   U.S. Department of Commerce
   *   National Institute of Standards and Technology (NIST)
   *   NIST Special Publication 811, 1995 Edition
   *   http://physics.nist.gov/Document/sp811.pdf
   * <p>
   * [MfM]
   *   Richard A. Young and Thomas J. Glover
   *   Measure for Measure
   *   1996.  ISBN 1-889796-00-X
   *   (Blue Willow, Inc.; Littleton, Colorado, USA)
   *   http://www.bluewillow.com/
   * 
   */
  public static void initializeUnitDefinitions() {
    { Measure m = null;

      m = Measure.defineBaseMeasure("Mass", "kg");
      m.addUnit("g", 0.001, "kg");
      m.addUnit("mg", 0.001, "g");
      m.addUnit("ug", 1.0e-6, "g");
      m.addUnit("ng", 1.0e-9, "g");
      m.addUnit("pg", 1.0e-12, "g");
      m.addUnit("d", 1.7e-24, "g");
      m.addUnit("dalton", 1.0, "d");
      m.addUnit("kd", 1000.0, "d");
      m.addUnit("lbs", 0.45359237, "kg");
      m.addUnit("oz", 0.0625, "lbs");
      m.addUnit("gr", 1.4285714285714287e-4, "lbs");
      m.addUnit("lb", 1.0, "lbs");
      m.addUnit("mton", 1000000.0, "g");
      m.addUnit("tonne", 1000000.0, "g");
      m.addUnit("ton", 2000.0, "lbs");
      m.addUnit("longton", 2240.0, "lbs");
      m.addUnit("stone", 14.0, "lbs");
      m.addUnit("hwt", 100.0, "lbs");
      m.addUnit("slug", 14594.14842519685, "g");
      m.addUnit("carat", 0.2, "g");
      m = Measure.defineBaseMeasure("Distance", "m");
      m.addUnit("nm", 1.0e-9, "m");
      m.addUnit("um", 1.0e-6, "m");
      m.addUnit("mm", 0.001, "m");
      m.addUnit("cm", 0.01, "m");
      m.addUnit("dm", 0.1, "m");
      m.addUnit("km", 1000.0, "m");
      m.addUnit("angstrom", 1.0e-10, "m");
      m.addUnit("ang", 1.0, "angstrom");
      m.addUnit("in", 0.0254, "m");
      m.addUnit("ft", 12.0, "in");
      m.addUnit("yd", 3.0, "ft");
      m.addUnit("mile", 5280.0, "ft");
      m.addUnit("miles", 1.0, "mile");
      m.addUnit("mi", 1.0, "mile");
      m.addUnit("NM", 1852.0, "m");
      m.addUnit("nautmi", 1852.0, "m");
      m.addUnit("fathom", 6.0, "ft");
      m.addUnit("furlong", 220.0, "yd");
      m.addUnit("hand", 4.0, "in");
      m.addUnit("hh", 1.0, "hand");
      m.addUnit("pica", 0.16666666666666666, "in");
      m.addUnit("point", 0.013888888888888888, "in");
      m.addUnit("pt", 1.0, "point");
      m.addUnit("AU", 1.4959787066000003e+11, "m");
      m.addUnit("lightyear", 9.460528177426822e+15, "m");
      m.addUnit("LY", 1.0, "lightyear");
      m.addUnit("parsec", 3.085678e+16, "m");
      m = Measure.defineDerivedMeasure("Area", "m2", "m2");
      m.addUnit("sqyd", 1.0, "yd2");
      m.addUnit("sqft", 1.0, "ft2");
      m.addUnit("sqin", 1.0, "in2");
      m.addUnit("sqkm", 1.0, "km2");
      m.addUnit("sqmile", 1.0, "mile2");
      m.addUnit("hectare", 10000.0, "m2");
      m.addUnit("ha", 1.0, "hectare");
      m.addUnit("are", 100.0, "m2");
      m.addUnit("a", 1.0, "are");
      m.addUnit("acre", 4840.0, "yd2");
      m = Measure.defineDerivedMeasure("Volume", "m3", "m3");
      m.addUnit("liter", 0.001, "m3");
      m.addUnit("l", 1.0, "liter");
      m.addUnit("L", 1.0, "liter");
      m.addUnit("ml", 0.001, "liter");
      m.addUnit("ul", 1.0e-6, "liter");
      m.addUnit("nl", 1.0e-9, "liter");
      m.addUnit("pl", 1.0e-12, "liter");
      m.addUnit("cc", 1.0, "ml");
      m.addUnit("cl", 0.01, "liter");
      m.addUnit("dl", 0.1, "liter");
      m.addUnit("Hl", 100.0, "liter");
      m.addUnit("cuft", 1.0, "ft3");
      m.addUnit("cuyd", 1.0, "yd3");
      m.addUnit("acrefeet", 1.0, "acre.ft");
      m.addUnit("gallon", 231.0, "in3");
      m.addUnit("pint", 0.125, "gallon");
      m.addUnit("quart", 0.25, "gallon");
      m.addUnit("gal", 1.0, "gallon");
      m.addUnit("qt", 1.0, "quart");
      m.addUnit("floz", 0.0625, "pint");
      m.addUnit("barrel", 42.0, "gal");
      m.addUnit("cup", 0.5, "pint");
      m.addUnit("tbl", 0.0625, "cup");
      m.addUnit("tsp", 0.3333333333333333, "tbl");
      m.addUnit("bbl", 1.0, "barrel");
      m.addUnit("Mbbl", 1000000.0, "barrel");
      m.addUnit("Bbbl", 1.0e+9, "barrel");
      m.addUnit("BRT", 100.0, "ft3");
      m = Measure.defineBaseMeasure("Time", "s");
      m.addUnit("fs", 1.0e-15, "s");
      m.addUnit("ps", 1.0e-12, "s");
      m.addUnit("ns", 1.0e-9, "s");
      m.addUnit("us", 1.0e-6, "s");
      m.addUnit("ms", 0.001, "s");
      m.addUnit("min", 60.0, "s");
      m.addUnit("h", 60.0, "min");
      m.addUnit("day", 24.0, "h");
      m.addUnit("hr", 1.0, "h");
      m.addUnit("week", 7.0, "day");
      m.addUnit("fortnight", 14.0, "day");
      m.addUnit("year", 365.24219, "day");
      m.addUnit("decade", 10.0, "year");
      m.addUnit("century", 100.0, "year");
      m.addUnit("yr", 1.0, "year");
      m.addUnit("years", 1.0, "year");
      m.addUnit("days", 1.0, "day");
      m.addUnit("weeks", 1.0, "week");
      m.addUnit("month", 0.08333333333333333, "year");
      m.addUnit("months", 1.0, "month");
      m = Measure.defineDerivedMeasure("Velocity", "m/s", "m/s");
      m.addUnit("mph", 1.0, "mi/h");
      m.addUnit("kts", 1.0, "NM/h");
      m.addUnit("knots", 1.0, "kts");
      m.addUnit("c", 2.99792458e+8, "m/s");
      m = Measure.defineDerivedMeasure("Acceleration", "m/s2", "m/s2");
      m.addUnit("G", 9.80665, "m/s2");
      m = Measure.defineBaseMeasure("Amount-Of-Substance", "mole");
      m.addUnit("mol", 1.0, "mole");
      m.addUnit("mmol", 0.001, "mole");
      m.addUnit("umol", 1.0e-6, "mole");
      m.addUnit("kmol", 1000.0, "mole");
      m.addUnit("kilomole", 1.0, "kmol");
      m.addUnit("millimole", 1.0, "mmol");
      m.addUnit("micromole", 1.0, "umol");
      m.addUnit("molecule", 1.660540186674939e-24, "mol");
      m.addUnit("particle", 1.0, "molecule");
      m.addUnit("atom", 1.0, "molecule");
      m.addUnit("ion", 1.0, "molecule");
      m = Measure.defineDerivedMeasure("Molality", "mol/kg", "mol/kg");
      m.addUnit("molal", 1.0, "mol/kg");
      m = Measure.defineDerivedMeasure("Concentration-Of-Substance", "mol/m3", "mol/m3");
      m.addUnit("M", 1.0, "mol/l");
      m.addUnit("molar", 1.0, "M");
      m.addUnit("mM", 0.001, "M");
      m.addUnit("uM", 0.001, "mM");
      m.addUnit("nM", 0.001, "uM");
      m = Measure.defineDerivedMeasure("Molar-Mass", "kg/mol", "kg/mol");
      m = Measure.defineDerivedMeasure("Force", "N", "kg.m/s2");
      m.addUnit("kN", 1000.0, "N");
      m.addUnit("kgf", 1.0, "kg.G");
      m.addUnit("lbf", 1.0, "lb.G");
      m.addUnit("dyne", 1.0e-5, "N");
      m = Measure.defineDerivedMeasure("Pressure", "Pa", "kg/s2m");
      m.addUnit("N/m2", 1.0, "Pa");
      m.addUnit("hPa", 100.0, "Pa");
      m.addUnit("kPa", 1000.0, "Pa");
      m.addUnit("atm", 101325.0, "Pa");
      m.addUnit("inHg", 0.03342, "atm");
      m.addUnit("torr", 133.32236842105263, "Pa");
      m.addUnit("mmHg", 1.0, "torr");
      m.addUnit("psi", 6895301.7, "g/s2m");
      m.addUnit("bar", 100000.0, "Pa");
      m.addUnit("mbar", 0.001, "bar");
      m = Measure.defineDerivedMeasure("Density", "kg/m3", "kg/m3");
      m.addUnit("ppm", 1.0, "mg/l");
      m.addUnit("ppb", 1.0, "ug/l");
      m.addUnit("ppt", 1.0, "ng/l");
      m.addUnit("ppq", 1.0, "pg/l");
      m = Measure.defineDerivedMeasure("Power", "W", "m2kg/s3");
      m.addUnit("hp", 550.0, "ft.lbf/s");
      m.addUnit("shp", 1.0, "hp");
      m.addUnit("mW", 0.001, "W");
      m.addUnit("kW", 1000.0, "W");
      m.addUnit("MW", 1000000.0, "W");
      m.addUnit("GW", 1.0e+9, "W");
      m = Measure.defineDerivedMeasure("Work-Or-Torque", "J", "m2kg/s2");
      m.addUnit("erg", 1.0, "dyne.cm");
      m.addUnit("kJ", 1000.0, "J");
      m.addUnit("MJ", 1000000.0, "J");
      m.addUnit("GJ", 1.0e+9, "J");
      m.addUnit("BTU", 1055.05585262, "J");
      m.addUnit("cal", 4.1868, "J");
      m.addUnit("kcal", 1000.0, "cal");
      m.addUnit("therm", 1.0550559e+8, "J");
      m.addUnit("kWh", 1.0, "kW.h");
      m.addUnit("kiloton", 4.184e+12, "J");
      m.addUnit("Megaton", 1000.0, "kiloton");
      m = Measure.defineBaseMeasure("Electric-Current", "A");
      m.addUnit("mA", 0.001, "A");
      m = Measure.defineDerivedMeasure("Electric-Charge", "C", "s.A");
      m.addUnit("pC", 1.0e-12, "C");
      m = Measure.defineDerivedMeasure("Electric-Potential", "V", "m2kg/s3A");
      m.addUnit("mV", 0.001, "V");
      m.addUnit("kV", 1000.0, "V");
      m.addUnit("MV", 1000.0, "kV");
      m = Measure.defineDerivedMeasure("Electric-Resistance", "ohm", "m2kg/s3A2");
      m.addUnit("kohm", 1000.0, "ohm");
      m.addUnit("Mohm", 1000000.0, "ohm");
      m = Measure.defineDerivedMeasure("Electric-Conductance", "mho", "ohm-1");
      m.addUnit("S", 1.0, "mho");
      m.addUnit("mmho", 1.0e-6, "mho");
      m.addUnit("umho", 1.0e-9, "mho");
      m = Measure.defineDerivedMeasure("Capacitance", "F", "A2s4/m2kg");
      m.addUnit("mF", 0.001, "F");
      m.addUnit("uF", 1.0e-6, "F");
      m.addUnit("pF", 1.0e-6, "uF");
      m = Measure.defineDerivedMeasure("Inductance", "H", "m2kg/A2s2");
      m = Measure.defineDerivedMeasure("Magnetic-Flux", "Wb", "m2kg/s2A");
      m = Measure.defineDerivedMeasure("Magnetic-Flux-Density", "T", "kg/s2A");
      m = Measure.defineBaseMeasure("Luminous-Intensity", "Cd");
      m.addUnit("lumen", 1.0, "Cd");
      m.addUnit("lm", 1.0, "Cd");
      m = Measure.defineDerivedMeasure("Illuminance", "lux", "Cd/m2");
      m.addUnit("lx", 1.0, "lux");
      m = Measure.defineBaseMeasure("Temperature", "K");
      m.addUnit("oK", 1.0, "K");
      m.addUnit("Kelvin", 1.0, "K");
      m.addUnit("oC", 1.0, "K");
      m.addUnit("oF", 0.5555555555555556, "K");
      m.addUnit("Rankine", 1.0, "oF");
      m = Measure.defineBaseMeasure("Data", "bit");
      m.addUnit("byte", 8.0, "bit");
      m.addUnit("B", 1.0, "byte");
      m.addUnit("Kibit", 1024.0, "bit");
      m.addUnit("kibit", 1.0, "Kibit");
      m.addUnit("Mibit", 1024.0, "kibit");
      m.addUnit("Gibit", 1024.0, "Mibit");
      m.addUnit("KiB", 1024.0, "byte");
      m.addUnit("kiB", 1.0, "KiB");
      m.addUnit("MiB", 1024.0, "KiB");
      m.addUnit("GiB", 1024.0, "MiB");
      m.addUnit("TiB", 1024.0, "GiB");
      m.addUnit("PiB", 1024.0, "TiB");
      m.addUnit("kbit", 1000.0, "bit");
      m.addUnit("Mbit", 1000.0, "kbit");
      m.addUnit("Gbit", 1000.0, "Mbit");
      m.addUnit("kB", 1000.0, "byte");
      m.addUnit("MB", 1000.0, "kB");
      m.addUnit("GB", 1000.0, "MB");
      m.addUnit("TB", 1000.0, "GB");
      m.addUnit("PB", 1000.0, "TB");
      m = Measure.defineDimensionlessMeasure();
      m.addUnit("%", 0.01, "");
      m.addUnit("%%", 0.001, "");
      m.addUnit("rad", 1.0, "");
      m.addUnit("radian", 1.0, "rad");
      m.addUnit("deg", 0.017453292519943295, "rad");
      m.addUnit("minute", 0.016666666666666666, "deg");
      m.addUnit("sec", 0.016666666666666666, "minute");
      m.addUnit("arcmin", 1.0, "minute");
      m.addUnit("arcsec", 1.0, "sec");
      m.addUnit("degree", 1.0, "deg");
      m.addUnit("mil", 0.05625, "deg");
      m.addUnit("sr", 1.0, "");
      m.addUnit("steradian", 1.0, "sr");
      m = Measure.defineDerivedMeasure("Frequency", "Hz", "s-1");
      m.addUnit("kHz", 1000.0, "Hz");
      m.addUnit("MHz", 1000000.0, "Hz");
      m.addUnit("GHz", 1.0e+9, "Hz");
      m.addUnit("Bq", 1.0, "Hz");
      m.addUnit("Ci", 3.7e+10, "Bq");
      m.addUnit("mCi", 0.001, "Ci");
      m.addUnit("pCi", 1.0e-9, "Ci");
      m.addUnit("rps", 360.0, "deg/s");
      m.addUnit("rpm", 0.016666666666666666, "rps");
    }
  }

}
