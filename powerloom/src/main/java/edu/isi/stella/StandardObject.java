//  -*- Mode: Java -*-
//
// StandardObject.java

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

/** Object that used to find its type stored in a :class slot.
 * By reimplementing <code>primaryType</code> as a method, the justification for this
 * class went away, but we'll keep it for now to keep things working.
 * @author Stella Java Translator
 */
public abstract class StandardObject extends Stella_Object {
  public static StringWrapper idlTranslateTypeSpec(StandardObject typespec) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(typespec);

      if (Surrogate.subtypeOfParametricTypeSpecifierP(testValue000)) {
        { ParametricTypeSpecifier typespec000 = ((ParametricTypeSpecifier)(typespec));

          return (StringWrapper.wrapString(StandardObject.idlTranslateTypeSpec(typespec000.specifierBaseType).wrapperValue + "<" + StandardObject.idlTranslateTypeSpec(((StandardObject)(typespec000.specifierParameterTypes.first()))).wrapperValue + ">"));
        }
      }
      else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
        { Surrogate typespec000 = ((Surrogate)(typespec));

          if (((StringWrapper)(KeyValueList.dynamicSlotValue(((Stella_Class)(typespec000.surrogateValue)).dynamicSlots, Stella.SYM_STELLA_CLASS_IDL_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue != null) {
            return (StringWrapper.wrapString(((StringWrapper)(KeyValueList.dynamicSlotValue(((Stella_Class)(typespec000.surrogateValue)).dynamicSlots, Stella.SYM_STELLA_CLASS_IDL_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue));
          }
          else {
            return (GeneralizedSymbol.idlTranslateClassName(Surrogate.symbolize(((Stella_Class)(typespec000.surrogateValue)).classType)));
          }
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

  public static Cons javaYieldClassObjectExpression(StandardObject typespec) {
    { Cons otree = null;
      Surrogate classtype = null;

      { Surrogate testValue000 = Stella_Object.safePrimaryType(typespec);

        if (Surrogate.subtypeOfParametricTypeSpecifierP(testValue000)) {
          { ParametricTypeSpecifier typespec000 = ((ParametricTypeSpecifier)(typespec));

            if (StandardObject.arrayTypeSpecifierP(typespec000)) {
              return (StandardObject.javaYieldClassObjectArrayExpression(StandardObject.extractParameterType(typespec000, Stella.SYM_STELLA_ANY_VALUE, new Object[1]), ParametricTypeSpecifier.arrayTypeDimensions(typespec000).length()));
            }
            else {
              classtype = typespec000.specifierBaseType;
            }
          }
        }
        else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
          { Surrogate typespec000 = ((Surrogate)(typespec));

            classtype = ((Stella_Class)(typespec000.surrogateValue)).classType;
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      if (classtype == Stella.SGT_STELLA_VOID) {
        otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_VERBATIM, Cons.cons(StringWrapper.wrapString("java.lang.Void.TYPE"), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      else if (classtype == Stella.SGT_STELLA_BOOLEAN) {
        otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_VERBATIM, Cons.cons(StringWrapper.wrapString("java.lang.Boolean.TYPE"), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      else if ((classtype == Stella.SGT_STELLA_INTEGER) ||
          (classtype == Stella.SGT_STELLA_THIRTY_TWO_BIT_VECTOR)) {
        otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_VERBATIM, Cons.cons(StringWrapper.wrapString("java.lang.Integer.TYPE"), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      else if (classtype == Stella.SGT_STELLA_CHARACTER) {
        otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_VERBATIM, Cons.cons(StringWrapper.wrapString("java.lang.Character.TYPE"), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      else if ((classtype == Stella.SGT_STELLA_BYTE) ||
          (classtype == Stella.SGT_STELLA_OCTET)) {
        otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_VERBATIM, Cons.cons(StringWrapper.wrapString("java.lang.Byte.TYPE"), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      else if ((classtype == Stella.SGT_STELLA_FLOAT) ||
          (classtype == Stella.SGT_STELLA_DOUBLE_FLOAT)) {
        otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_VERBATIM, Cons.cons(StringWrapper.wrapString("java.lang.Double.TYPE"), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      else if ((classtype == Stella.SGT_STELLA_SHORT_INTEGER) ||
          (classtype == Stella.SGT_STELLA_UNSIGNED_SHORT_INTEGER)) {
        otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_VERBATIM, Cons.cons(StringWrapper.wrapString("java.lang.Short.TYPE"), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      else if ((classtype == Stella.SGT_STELLA_LONG_INTEGER) ||
          ((classtype == Stella.SGT_STELLA_UNSIGNED_LONG_INTEGER) ||
           ((classtype == Stella.SGT_STELLA_TICKTOCK) ||
            (classtype == Stella.SGT_STELLA_NATIVE_DATE_TIME)))) {
        otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_VERBATIM, Cons.cons(StringWrapper.wrapString("java.lang.Long.TYPE"), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      else if (classtype == Stella.SGT_STELLA_SINGLE_FLOAT) {
        otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_VERBATIM, Cons.cons(StringWrapper.wrapString("java.lang.Float.TYPE"), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      else if (classtype == Stella.SGT_STELLA_STRING) {
        otree = Stella.javaTranslateClassObjectLookup("java.lang.String");
      }
      else if (classtype == Stella.SGT_STELLA_MUTABLE_STRING) {
        otree = Stella.javaTranslateClassObjectLookup("java.lang.StringBuffer");
      }
      else {
        if ((!(classtype == Stella.SGT_STELLA_ARGUMENT_LIST)) &&
            (((StringWrapper)(KeyValueList.dynamicSlotValue(((Stella_Class)(classtype.surrogateValue)).dynamicSlots, Stella.SYM_STELLA_CLASS_JAVA_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue != null)) {
          otree = Stella.javaTranslateClassObjectLookup(Stella.yieldClassObjectLookupNameForNativeType(((Stella_Class)(classtype.surrogateValue)).javaNativeType()));
        }
        else {
          otree = Stella.javaTranslateClassObjectLookup(StandardObject.javaYieldFullyQualifiedTypeName(typespec).wrapperValue);
        }
      }
      return (otree);
    }
  }

  public static Cons javaYieldClassObjectArrayExpression(StandardObject typespec, int ndimensions) {
    { String prefix = Native.makeString(ndimensions, '[');
      Surrogate classtype = null;
      String classid = null;

      { Surrogate testValue000 = Stella_Object.safePrimaryType(typespec);

        if (Surrogate.subtypeOfParametricTypeSpecifierP(testValue000)) {
          { ParametricTypeSpecifier typespec000 = ((ParametricTypeSpecifier)(typespec));

            classtype = typespec000.specifierBaseType;
          }
        }
        else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
          { Surrogate typespec000 = ((Surrogate)(typespec));

            classtype = ((Stella_Class)(typespec000.surrogateValue)).classType;
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      if (classtype == Stella.SGT_STELLA_VOID) {
        throw ((StellaException)(StellaException.newStellaException("VOID is an invalid array base type.").fillInStackTrace()));
      }
      else if (classtype == Stella.SGT_STELLA_BOOLEAN) {
        classid = "Z";
      }
      else if (classtype == Stella.SGT_STELLA_INTEGER) {
        classid = "I";
      }
      else if (classtype == Stella.SGT_STELLA_CHARACTER) {
        classid = "C";
      }
      else if ((classtype == Stella.SGT_STELLA_BYTE) ||
          (classtype == Stella.SGT_STELLA_OCTET)) {
        classid = "B";
      }
      else if ((classtype == Stella.SGT_STELLA_FLOAT) ||
          (classtype == Stella.SGT_STELLA_DOUBLE_FLOAT)) {
        classid = "D";
      }
      else if ((classtype == Stella.SGT_STELLA_SHORT_INTEGER) ||
          (classtype == Stella.SGT_STELLA_UNSIGNED_SHORT_INTEGER)) {
        classid = "S";
      }
      else if ((classtype == Stella.SGT_STELLA_LONG_INTEGER) ||
          (classtype == Stella.SGT_STELLA_UNSIGNED_LONG_INTEGER)) {
        classid = "J";
      }
      else if (classtype == Stella.SGT_STELLA_SINGLE_FLOAT) {
        classid = "F";
      }
      else if (classtype == Stella.SGT_STELLA_STRING) {
        classid = "Ljava.lang.String;";
      }
      else if (classtype == Stella.SGT_STELLA_MUTABLE_STRING) {
        classid = "Ljava.lang.StringBuffer;";
      }
      else {
        classid = "L" + StandardObject.javaYieldFullyQualifiedTypeName(typespec).wrapperValue + ";";
      }
      return (Stella.javaTranslateClassObjectLookup(prefix + classid));
    }
  }

  public static String javaYieldTranslatedClassAndMethodNames(StandardObject owner, MethodSlot f, Object [] MV_returnarray) {
    if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(f.dynamicSlots, Stella.SYM_STELLA_METHOD_NATIVEp, Stella.FALSE_WRAPPER))).wrapperValue) {
      { String _return_temp = Stella.javaYieldFullNativeClassName();

        MV_returnarray[0] = StringWrapper.wrapString(MethodSlot.javaTranslateFunctionName(f).wrapperValue);
        return (_return_temp);
      }
    }
    else if (MethodSlot.javaFlotsamFunctionP(f)) {
      { String _return_temp = Module.javaPackagePrefix(f.homeModule(), ".") + Module.javaYieldFlotsamClassName(f.homeModule());

        MV_returnarray[0] = StringWrapper.wrapString(MethodSlot.javaTranslateFunctionName(f).wrapperValue);
        return (_return_temp);
      }
    }
    else if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(f.dynamicSlots, Stella.SYM_STELLA_METHOD_CONSTRUCTORp, Stella.FALSE_WRAPPER))).wrapperValue) {
      { String _return_temp = StandardObject.javaYieldFullyQualifiedTypeName(((StandardObject)(f.methodReturnTypeSpecifiers().first()))).wrapperValue;

        MV_returnarray[0] = StringWrapper.wrapString(MethodSlot.javaTranslateFunctionName(f).wrapperValue);
        return (_return_temp);
      }
    }
    else {
      { String _return_temp = StandardObject.javaYieldFullyQualifiedTypeName(owner).wrapperValue;

        MV_returnarray[0] = StringWrapper.wrapString(MethodSlot.javaTranslateFunctionName(f).wrapperValue);
        return (_return_temp);
      }
    }
  }

  public static StringWrapper javaYieldFullyQualifiedTypeName(StandardObject typespec) {
    { Surrogate basetypespec = StandardObject.typeSpecToBaseType(typespec);
      StringWrapper translatedtype = null;
      String nativetype = ((Stella_Class)(basetypespec.surrogateValue)).javaNativeType();

      if (basetypespec == Stella.SGT_STELLA_ARGUMENT_LIST) {
        basetypespec = Stella.SGT_STELLA_CONS;
        nativetype = null;
      }
      if (nativetype != null) {
        if (Native.string_memberP(nativetype, '.') ||
            StandardObject.javaLiteralP(typespec)) {
          return (StringWrapper.wrapString(nativetype));
        }
        else {
          return (StringWrapper.wrapString("java.lang." + nativetype));
        }
      }
      translatedtype = StandardObject.javaTranslateTypeSpec(basetypespec);
      if (Native.string_memberP(translatedtype.wrapperValue, '.')) {
        return (translatedtype);
      }
      else {
        return (StringWrapper.wrapString(Module.javaPackagePrefix(basetypespec.homeModule(), ".") + translatedtype.wrapperValue));
      }
    }
  }

  public static StringWrapper javaTranslateArrayOfTypeSpec(StandardObject typespec, boolean fullyqualifiedP) {
    { String basetypestring = (fullyqualifiedP ? StandardObject.javaYieldFullyQualifiedTypeName(typespec).wrapperValue : StandardObject.javaTranslateTypeSpec(typespec).wrapperValue);

      return (StringWrapper.wrapString(basetypestring + " []"));
    }
  }

  public static StringWrapper javaTranslateTypeSpecHelper(StandardObject typeSpec, boolean functionP) {
    { Surrogate finalType = null;
      String typeName = "";

      { Surrogate testValue000 = Stella_Object.safePrimaryType(typeSpec);

        if (Surrogate.subtypeOfParametricTypeSpecifierP(testValue000)) {
          { ParametricTypeSpecifier typeSpec000 = ((ParametricTypeSpecifier)(typeSpec));

            if (StandardObject.arrayTypeSpecifierP(typeSpec000)) {
              return (ParametricTypeSpecifier.javaTranslateArrayType(typeSpec000));
            }
            else {
              return (StandardObject.javaTranslateTypeSpec(typeSpec000.specifierBaseType));
            }
          }
        }
        else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
          { Surrogate typeSpec000 = ((Surrogate)(typeSpec));

            if (((StringWrapper)(KeyValueList.dynamicSlotValue(((Stella_Class)(typeSpec000.surrogateValue)).dynamicSlots, Stella.SYM_STELLA_CLASS_JAVA_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue != null) {
              return (StringWrapper.wrapString(((Stella_Class)(typeSpec000.surrogateValue)).javaNativeType()));
            }
            else {
              finalType = ((Stella_Class)(typeSpec000.surrogateValue)).classType;
              typeName = StringWrapper.javaTranslateClassNamestring(StringWrapper.wrapString(finalType.symbolName)).wrapperValue;
              if (!Module.omitJavaPackagePrefixP(finalType.homeModule(), finalType.symbolName)) {
                return (StringWrapper.wrapString(Module.javaPackagePrefix(finalType.homeModule(), ".") + typeName));
              }
              else if (functionP &&
                  Stella_Class.classNameConflictsWithSlotNameP(((Stella_Class)(Stella.$CURRENT_JAVA_OUTPUT_CLASS$.get())), typeName)) {
                return (StringWrapper.wrapString(Module.javaPackagePrefix(finalType.homeModule(), ".") + typeName));
              }
              else {
                return (StringWrapper.wrapString(typeName));
              }
            }
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
  }

  public static StringWrapper javaTranslateTypeSpecForFunction(StandardObject typeSpec) {
    return (StandardObject.javaTranslateTypeSpecHelper(typeSpec, true));
  }

  public static StringWrapper javaTranslateTypeSpec(StandardObject typeSpec) {
    return (StandardObject.javaTranslateTypeSpecHelper(typeSpec, false));
  }

  public static StringWrapper javaSpecialSetterName(StandardObject typespec) {
    { Surrogate testValue000 = StandardObject.typeSpecToBaseType(typespec);

      if (testValue000 == Stella.SGT_STELLA_BOOLEAN) {
        return (StringWrapper.wrapString("setBooleanSpecial"));
      }
      else if ((testValue000 == Stella.SGT_STELLA_INTEGER) ||
          ((testValue000 == Stella.SGT_STELLA_SHORT_INTEGER) ||
           ((testValue000 == Stella.SGT_STELLA_UNSIGNED_SHORT_INTEGER) ||
            ((testValue000 == Stella.SGT_STELLA_BYTE) ||
             ((testValue000 == Stella.SGT_STELLA_OCTET) ||
              (testValue000 == Stella.SGT_STELLA_THIRY_TWO_BIT_VECTOR)))))) {
        return (StringWrapper.wrapString("setIntSpecial"));
      }
      else if ((testValue000 == Stella.SGT_STELLA_FLOAT) ||
          (testValue000 == Stella.SGT_STELLA_DOUBLE)) {
        return (StringWrapper.wrapString("setDoubleSpecial"));
      }
      else if (testValue000 == Stella.SGT_STELLA_CHARACTER) {
        return (StringWrapper.wrapString("setCharSpecial"));
      }
      else if (testValue000 == Stella.SGT_STELLA_LONG_INTEGER) {
        return (StringWrapper.wrapString("setLongSpecial"));
      }
      else if (testValue000 == Stella.SGT_STELLA_SINGLE_FLOAT) {
        return (StringWrapper.wrapString("setFloatSpecial"));
      }
      else {
        return (StringWrapper.wrapString("setSpecial"));
      }
    }
  }

  public static StringWrapper javaNativeLiteralWrapperNames(StandardObject typespec, Object [] MV_returnarray) {
    { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(typespec));

      if (testValue000 == Stella.SGT_STELLA_BOOLEAN) {
        { StringWrapper _return_temp = StringWrapper.wrapString("Boolean");

          MV_returnarray[0] = StringWrapper.wrapString("booleanValue");
          return (_return_temp);
        }
      }
      else if ((testValue000 == Stella.SGT_STELLA_INTEGER) ||
          ((testValue000 == Stella.SGT_STELLA_SHORT_INTEGER) ||
           ((testValue000 == Stella.SGT_STELLA_UNSIGNED_SHORT_INTEGER) ||
            ((testValue000 == Stella.SGT_STELLA_BYTE) ||
             ((testValue000 == Stella.SGT_STELLA_OCTET) ||
              (testValue000 == Stella.SGT_STELLA_THIRY_TWO_BIT_VECTOR)))))) {
        { StringWrapper _return_temp = StringWrapper.wrapString("Integer");

          MV_returnarray[0] = StringWrapper.wrapString("intValue");
          return (_return_temp);
        }
      }
      else if ((testValue000 == Stella.SGT_STELLA_FLOAT) ||
          (testValue000 == Stella.SGT_STELLA_DOUBLE)) {
        { StringWrapper _return_temp = StringWrapper.wrapString("Double");

          MV_returnarray[0] = StringWrapper.wrapString("doubleValue");
          return (_return_temp);
        }
      }
      else if (testValue000 == Stella.SGT_STELLA_CHARACTER) {
        { StringWrapper _return_temp = StringWrapper.wrapString("Character");

          MV_returnarray[0] = StringWrapper.wrapString("charValue");
          return (_return_temp);
        }
      }
      else if (testValue000 == Stella.SGT_STELLA_LONG_INTEGER) {
        { StringWrapper _return_temp = StringWrapper.wrapString("Long");

          MV_returnarray[0] = StringWrapper.wrapString("longValue");
          return (_return_temp);
        }
      }
      else if (testValue000 == Stella.SGT_STELLA_SINGLE_FLOAT) {
        { StringWrapper _return_temp = StringWrapper.wrapString("Float");

          MV_returnarray[0] = StringWrapper.wrapString("floatValue");
          return (_return_temp);
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

  public static boolean javaLiteralP(StandardObject typespec) {
    return (StandardObject.subTypeSpecOfP(typespec, Stella.SGT_STELLA_LITERAL) &&
        ((!StandardObject.subTypeSpecOfP(typespec, Stella.SGT_STELLA_STRING)) &&
         ((!StandardObject.subTypeSpecOfP(typespec, Stella.SGT_STELLA_MUTABLE_STRING)) &&
          (!StandardObject.subTypeSpecOfP(typespec, Stella.SGT_STELLA_CODE)))));
  }

  public static StringWrapper cppReferencizeType(StandardObject typespec) {
    return (StringWrapper.wrapString(Native.string_substitute(StandardObject.cppTranslateTypeSpec(typespec).wrapperValue, '&', '*')));
  }

  public static boolean cppReferenceTypeP(StandardObject typespec) {
    typespec = typespec;
    return (false);
  }

  public static StringWrapper cppTranslateAndReferencizeTypeSpec(StandardObject typespec) {
    { Surrogate basetype = StandardObject.typeSpecToBaseType(typespec);
      StringWrapper translatedtype = StandardObject.cppTranslateTypeSpec(typespec);

      translatedtype.wrapperValue = (Stella_Object.cppTranslatedArrayTypeP(translatedtype) ? Stella.cppGenerateArrayTypedEntity("&", translatedtype.wrapperValue) : (translatedtype.wrapperValue + ((Stella_Class.createNativeClassP(((Stella_Class)(basetype.surrogateValue))) ? "*&" : "&"))));
      return (translatedtype);
    }
  }

  public static StringWrapper cppTranslateAndPointerizeTypeSpec(StandardObject typespec) {
    { Surrogate basetype = StandardObject.typeSpecToBaseType(typespec);
      StringWrapper translatedtype = StandardObject.cppTranslateTypeSpec(typespec);

      if (Stella_Class.createNativeClassP(((Stella_Class)(basetype.surrogateValue))) ||
          Stella_Class.exceptionClassP(((Stella_Class)(basetype.surrogateValue)))) {
        translatedtype.wrapperValue = translatedtype.wrapperValue + "*";
      }
      return (translatedtype);
    }
  }

  public static StringWrapper cppTranslateTypeSpec(StandardObject typespec) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(typespec);

      if (Surrogate.subtypeOfParametricTypeSpecifierP(testValue000)) {
        { ParametricTypeSpecifier typespec000 = ((ParametricTypeSpecifier)(typespec));

          if (StandardObject.arrayTypeSpecifierP(typespec000)) {
            return (ParametricTypeSpecifier.cppTranslateArrayType(typespec000));
          }
          if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE) {
            return (StringWrapper.wrapString(StandardObject.cppTranslateTypeSpec(typespec000.specifierBaseType).wrapperValue + "<" + StandardObject.cppTranslateAndPointerizeTypeSpec(((StandardObject)(typespec000.specifierParameterTypes.first()))).wrapperValue + ">"));
          }
          else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) {
            return (StandardObject.cppTranslateTypeSpec(typespec000.specifierBaseType));
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }
      }
      else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
        { Surrogate typespec000 = ((Surrogate)(typespec));

          if (((StringWrapper)(KeyValueList.dynamicSlotValue(((Stella_Class)(typespec000.surrogateValue)).dynamicSlots, Stella.SYM_STELLA_CLASS_CPP_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue != null) {
            return (StringWrapper.wrapString(((StringWrapper)(KeyValueList.dynamicSlotValue(((Stella_Class)(typespec000.surrogateValue)).dynamicSlots, Stella.SYM_STELLA_CLASS_CPP_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue));
          }
          else {
            return (GeneralizedSymbol.cppTranslateClassTypename(Surrogate.symbolize(((Stella_Class)(typespec000.surrogateValue)).classType)));
          }
        }
      }
      else {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("`" + testValue000 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static boolean cppTypeWithoutInteriorPointersP(StandardObject typespec) {
    { Surrogate basetype = StandardObject.typeSpecToBaseType(typespec);
      Stella_Class renamed_Class = ((Stella_Class)(basetype.surrogateValue));

      if (StandardObject.arrayTypeSpecifierP(typespec)) {
        return (StandardObject.cppNonPointerTypeP(StandardObject.extractParameterType(typespec, Stella.SYM_STELLA_ANY_VALUE, new Object[1])));
      }
      if (Stella_Class.createNativeClassP(renamed_Class) &&
          (!Surrogate.subtypeOfP(basetype, Stella.SGT_STELLA_NATIVE_EXCEPTION))) {
        { boolean alwaysP000 = true;

          { Slot slot = null;
            Iterator iter000 = renamed_Class.classSlots();

            loop000 : while (iter000.nextP()) {
              slot = ((Slot)(iter000.value));
              if (Stella_Object.storageSlotP(slot) &&
                  (StorageSlot.nativeSlotP(((StorageSlot)(slot))) &&
                   (!StorageSlot.slotHasUnknownTypeP(((StorageSlot)(slot)), renamed_Class)))) {
                if (!StandardObject.cppNonPointerTypeP(slot.slotBaseType)) {
                  alwaysP000 = false;
                  break loop000;
                }
              }
            }
          }
          { boolean value000 = alwaysP000;

            return (value000);
          }
        }
      }
      return (false);
    }
  }

  public static boolean cppNonPointerTypeP(StandardObject typespec) {
    { Surrogate basetype = StandardObject.typeSpecToBaseType(typespec);

      if ((basetype == Stella.SGT_STELLA_INTEGER) ||
          ((basetype == Stella.SGT_STELLA_SHORT_INTEGER) ||
           ((basetype == Stella.SGT_STELLA_LONG_INTEGER) ||
            ((basetype == Stella.SGT_STELLA_UNSIGNED_LONG_INTEGER) ||
             ((basetype == Stella.SGT_STELLA_FLOAT) ||
              ((basetype == Stella.SGT_STELLA_SINGLE_FLOAT) ||
               ((basetype == Stella.SGT_STELLA_DOUBLE_FLOAT) ||
                ((basetype == Stella.SGT_STELLA_CHARACTER) ||
                 ((basetype == Stella.SGT_STELLA_BYTE) ||
                  (basetype == Stella.SGT_STELLA_OCTET)))))))))) {
        return (true);
      }
      else {
        return (false);
      }
    }
  }

  public static void inverseSlotDemon(StandardObject self, StorageSlot slot, StandardObject oldvalue, StandardObject newvalue) {
    { Slot inverseslot = ((Slot)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_INVERSE, null)));

      if (oldvalue != null) {
        StandardObject.dropSlotValue(oldvalue, ((StorageSlot)(inverseslot)), self);
      }
      if (newvalue != null) {
        StandardObject.putSlotValue(newvalue, ((StorageSlot)(inverseslot)), self);
      }
    }
  }

  public static void cantOverwriteActiveCollectionSlot(StandardObject self, Symbol slotname) {
    {
      Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't replace the value of the active slot `" + slotname + "' on the object ");
      Stella.STANDARD_WARNING.nativeStream.println("`" + self + "'.  Call `insert' or `remove' to add/remove slot values.");
    }
;
  }

  public static void runDestructorDemons(StandardObject self) {
    { Stella_Class renamed_Class = self.primaryClass();

      if (renamed_Class != null) {
        if (Stella.$DESTRUCTOR_DEMONS$ != null) {
          { Demon demon = null;
            Cons iter000 = Stella.$DESTRUCTOR_DEMONS$.theConsList;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              demon = ((Demon)(iter000.value));
              edu.isi.stella.javalib.Native.funcall(demon.demonCode, null, new java.lang.Object [] {self, renamed_Class});
            }
          }
        }
        if (renamed_Class.classDestructorDemons() != null) {
          { Demon demon = null;
            Cons iter001 = renamed_Class.classDestructorDemons().theConsList;

            for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              demon = ((Demon)(iter001.value));
              edu.isi.stella.javalib.Native.funcall(demon.demonCode, null, new java.lang.Object [] {self, renamed_Class});
            }
          }
        }
      }
    }
  }

  public static void runConstructorDemons(StandardObject self) {
    { Stella_Class renamed_Class = self.primaryClass();

      if (renamed_Class != null) {
        if (Stella.$CONSTRUCTOR_DEMONS$ != null) {
          { Demon demon = null;
            Cons iter000 = Stella.$CONSTRUCTOR_DEMONS$.theConsList;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              demon = ((Demon)(iter000.value));
              edu.isi.stella.javalib.Native.funcall(demon.demonCode, null, new java.lang.Object [] {self, renamed_Class});
            }
          }
        }
        if (renamed_Class.classConstructorDemons() != null) {
          { Demon demon = null;
            Cons iter001 = renamed_Class.classConstructorDemons().theConsList;

            for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              demon = ((Demon)(iter001.value));
              edu.isi.stella.javalib.Native.funcall(demon.demonCode, null, new java.lang.Object [] {self, renamed_Class});
            }
          }
        }
      }
    }
  }

  public static void runSlotDemons(StandardObject self, StorageSlot slot, Stella_Object oldvalue, Stella_Object newvalue) {
    if (Stella.$ALL_SLOTS_DEMONS$ != null) {
      { Demon demon = null;
        Cons iter000 = Stella.$ALL_SLOTS_DEMONS$.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          demon = ((Demon)(iter000.value));
          edu.isi.stella.javalib.Native.funcall(demon.demonCode, null, new java.lang.Object [] {self, slot, oldvalue, newvalue});
        }
      }
    }
    if (slot.slotDemons() != null) {
      { Demon demon = null;
        Cons iter001 = slot.slotDemons().theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          demon = ((Demon)(iter001.value));
          edu.isi.stella.javalib.Native.funcall(demon.demonCode, null, new java.lang.Object [] {self, slot, oldvalue, newvalue});
        }
      }
    }
  }

  public static boolean runSlotGuardDemonsP(StandardObject self, StorageSlot slot, Stella_Object oldvalue, Stella_Object newvalue) {
    if (Stella.$ALL_SLOTS_GUARD_DEMONS$ != null) {
      { Demon demon = null;
        Cons iter000 = Stella.$ALL_SLOTS_GUARD_DEMONS$.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          demon = ((Demon)(iter000.value));
          if (!((Boolean)(edu.isi.stella.javalib.Native.funcall(demon.demonCode, null, new java.lang.Object [] {self, slot, oldvalue, newvalue}))).booleanValue()) {
            return (false);
          }
        }
      }
    }
    if (slot.slotGuardDemons() != null) {
      { Demon demon = null;
        Cons iter001 = slot.slotGuardDemons().theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          demon = ((Demon)(iter001.value));
          if (!((Boolean)(edu.isi.stella.javalib.Native.funcall(demon.demonCode, null, new java.lang.Object [] {self, slot, oldvalue, newvalue}))).booleanValue()) {
            return (false);
          }
        }
      }
    }
    return (true);
  }

  public static void dropSlotValue(StandardObject self, StorageSlot slot, Stella_Object value) {
    if (slot.collectionValuedP()) {
      { List oldvalues = ((List)(StandardObject.readSlotValue(self, slot)));

        oldvalues.remove(value);
      }
    }
    else {
      { Stella_Object oldvalue = StandardObject.readSlotValue(self, slot);

        if (Stella_Object.eqlP(value, oldvalue)) {
          StandardObject.writeSlotValue(self, slot, null);
        }
      }
    }
  }

  public static Stella_Object putSlotValue(StandardObject self, StorageSlot slot, Stella_Object value) {
    if (slot.collectionValuedP()) {
      { List oldvalues = ((List)(StandardObject.readSlotValue(self, slot)));

        oldvalues.insert(value);
        return (value);
      }
    }
    else {
      return (StandardObject.writeSlotValue(self, slot, value));
    }
  }

  public static Stella_Object writeSlotValue(StandardObject self, StorageSlot slot, Stella_Object value) {
    { java.lang.reflect.Method code = ((Stella_Class)(slot.slotOwner.surrogateValue)).classSlotAccessorCode;

      if (code != null) {
        return (((Stella_Object)(edu.isi.stella.javalib.Native.funcall(code, null, new java.lang.Object [] {self, slot.slotName, value, new Boolean(true)}))));
      }
      if (Surrogate.subtypeOfP(self.primaryType(), slot.slotOwner)) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: write-slot-value: No generic slot writer available for `" + slot + "'.");
      }
      else {
        {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: write-slot-value: Slot `" + slot + "' does not exist on");
          Stella.STANDARD_WARNING.nativeStream.println(" object `" + self + "' of type `" + self.primaryType() + "'.");
        }
;
      }
      return (null);
    }
  }

  public static Stella_Object readSlotValue(StandardObject self, StorageSlot slot) {
    { java.lang.reflect.Method code = ((Stella_Class)(slot.slotOwner.surrogateValue)).classSlotAccessorCode;

      if (code != null) {
        return (((Stella_Object)(edu.isi.stella.javalib.Native.funcall(code, null, new java.lang.Object [] {self, slot.slotName, ((Stella_Object)(null)), new Boolean(false)}))));
      }
      if (Surrogate.subtypeOfP(self.primaryType(), slot.slotOwner)) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: read-slot-value: No generic slot reader available for `" + slot + "'.");
      }
      else {
        {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: read-slot-value: Slot `" + slot + "' does not exist on");
          Stella.STANDARD_WARNING.nativeStream.println(" object `" + self + "' of type `" + self.primaryType() + "'.");
        }
;
      }
      return (null);
    }
  }

  public static Stella_Object lookupClTypeFromStellaType(StandardObject type) {
    if ((type == null) ||
        Stella_Object.anchoredTypeSpecifierP(type)) {
      return (null);
    }
    { Surrogate basetype = StandardObject.typeSpecToBaseType(type);

      if (basetype == Stella.SGT_STELLA_INTEGER) {
        return (Stella.internCommonLispSymbol("FIXNUM"));
      }
      else if (basetype == Stella.SGT_STELLA_SHORT_INTEGER) {
        return (Stella.internCommonLispSymbol("FIXNUM"));
      }
      else if (basetype == Stella.SGT_STELLA_FLOAT) {
        return (Stella.internCommonLispSymbol("DOUBLE-FLOAT"));
      }
      else if (basetype == Stella.SGT_STELLA_STRING) {
        return (Stella.internCommonLispSymbol("SIMPLE-STRING"));
      }
      else if (basetype == Stella.SGT_STELLA_MUTABLE_STRING) {
        return (Stella.internCommonLispSymbol("SIMPLE-STRING"));
      }
      else if (basetype == Stella.SGT_STELLA_NATIVE_VECTOR) {
        return (Stella.internCommonLispSymbol("SIMPLE-VECTOR"));
      }
      else if (basetype == Stella.SGT_STELLA_ARRAY) {
        if (StandardObject.arrayTypeSpecifierP(type)) {
          switch (ParametricTypeSpecifier.arrayTypeRank(((ParametricTypeSpecifier)(type)))) {
            case 1: 
              return (Stella.internCommonLispSymbol("SIMPLE-VECTOR"));
            default:
              { int rank = ParametricTypeSpecifier.arrayTypeRank(((ParametricTypeSpecifier)(type)));
                Cons dimensions = Stella.NIL;

                if (rank <= 5) {
                  { IntegerWrapper dim = null;
                    Cons iter000 = ParametricTypeSpecifier.arrayTypeDimensions(((ParametricTypeSpecifier)(type))).theConsList;
                    Cons collect000 = null;

                    for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                      dim = ((IntegerWrapper)(iter000.value));
                      if (collect000 == null) {
                        {
                          collect000 = Cons.cons(((dim == null) ? ((Stella_Object)(Stella.internCommonLispSymbol("*"))) : ((Stella_Object)(dim))), Stella.NIL);
                          if (dimensions == Stella.NIL) {
                            dimensions = collect000;
                          }
                          else {
                            Cons.addConsToEndOfConsList(dimensions, collect000);
                          }
                        }
                      }
                      else {
                        {
                          collect000.rest = Cons.cons(((dim == null) ? ((Stella_Object)(Stella.internCommonLispSymbol("*"))) : ((Stella_Object)(dim))), Stella.NIL);
                          collect000 = collect000.rest;
                        }
                      }
                    }
                  }
                  return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("ARRAY"), Cons.cons(Stella.internCommonLispSymbol("T"), Cons.cons(dimensions, Cons.cons(Stella.NIL, Stella.NIL))))));
                }
              }
            break;
          }
        }
      }
      else {
      }
      return (null);
    }
  }

  public static Cons extractRequiredArgumentValues(StandardObject classtype, PropertyList slotsandvalues) {
    { boolean arraytypeP = StandardObject.arrayTypeSpecifierP(classtype);
      List requiredvalues = List.newList();
      boolean foundP = false;

      if (arraytypeP) {
        ParametricTypeSpecifier.preprocessArrayArguments(((ParametricTypeSpecifier)(classtype)), slotsandvalues);
      }
      { Symbol requiredslotname = null;
        Cons iter000 = StandardObject.typeSpecToClass(classtype).classRequiredSlotNames().theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          requiredslotname = ((Symbol)(iter000.value));
          foundP = false;
          { Slot slot = null;
            Stella_Object valueref = null;
            Cons iter001 = slotsandvalues.thePlist;

            loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest.rest) {
              slot = ((Slot)(iter001.value));
              valueref = iter001.rest.value;
              if (slot.slotName == requiredslotname) {
                foundP = true;
                if (arraytypeP) {
                  ParametricTypeSpecifier.evaluateArrayArgumentValue(((ParametricTypeSpecifier)(classtype)), requiredvalues, slot, valueref);
                }
                else {
                  requiredvalues.insertLast(Stella_Object.walkExpressionTree(valueref, slot.computeReturnTypeSpec(classtype), Stella.SYM_STELLA_NEW, false, new Object[1]));
                }
                slotsandvalues.removeAt(slot);
                break loop001;
              }
            }
          }
          if (!(foundP)) {
            { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" Missing required NEW argument: `" + Stella_Object.deUglifyParseTree(requiredslotname) + "'.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
              }
            }
          }
        }
      }
      return (requiredvalues.theConsList);
    }
  }

  public static boolean walkTypeSpecIsNativeTypeP(StandardObject thetype) {
    if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
      return (((StringWrapper)(KeyValueList.dynamicSlotValue(StandardObject.typeSpecToClass(thetype).dynamicSlots, Stella.SYM_STELLA_CLASS_CL_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue != null);
    }
    else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) {
      return (((StringWrapper)(KeyValueList.dynamicSlotValue(StandardObject.typeSpecToClass(thetype).dynamicSlots, Stella.SYM_STELLA_CLASS_CPP_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue != null);
    }
    else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) {
      return (((StringWrapper)(KeyValueList.dynamicSlotValue(StandardObject.typeSpecToClass(thetype).dynamicSlots, Stella.SYM_STELLA_CLASS_JAVA_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue != null);
    }
    else {
      return (false);
    }
  }

  public static List listifyTypeSpec(StandardObject typespec) {
    if (StandardObject.voidP(typespec)) {
      return (List.list(Stella.NIL));
    }
    else {
      return (List.list(Cons.cons(typespec, Stella.NIL)));
    }
  }

  public static Stella_Object typeToWalkedNullValueTree(StandardObject typespec, Surrogate type) {
    { Stella_Object nullvalue = Surrogate.typeToNullValueTree(type);

      if (!(nullvalue == Stella.SYM_STELLA_NULL)) {
        nullvalue = Stella_Object.walkExpressionTree(nullvalue, type, Stella.SYM_STELLA_NULL, false, new Object[1]);
      }
      if (StandardObject.arrayTypeSpecifierP(typespec) &&
          (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP)) {
        return (Stella_Object.walkExpressionTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_VERBATIM, Cons.cons(Stella.KWD_COMMON_LISP, Cons.cons(StringWrapper.wrapString(Stella.lispNullArraySymbolString(ParametricTypeSpecifier.arrayTypeRank(((ParametricTypeSpecifier)(typespec))))), Cons.cons(Stella.NIL, Stella.NIL))))), type, Stella.SYM_STELLA_NULL, false, new Object[1]));
      }
      else {
        return (nullvalue);
      }
    }
  }

  public static Stella_Object yieldTypeSpecTree(StandardObject self) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(self);

      if (Surrogate.subtypeOfSurrogateP(testValue000)) {
        { Surrogate self000 = ((Surrogate)(self));

          return (Symbol.internSymbolInModule(self000.symbolName, ((Module)(self000.homeContext)), true));
        }
      }
      else if (Surrogate.subtypeOfParametricTypeSpecifierP(testValue000)) {
        { ParametricTypeSpecifier self000 = ((ParametricTypeSpecifier)(self));

          { Cons listoftypes = Stella.NIL;

            { StandardObject ts = null;
              Cons iter000 = self000.specifierParameterTypes.theConsList;
              Cons collect000 = null;

              for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                ts = ((StandardObject)(iter000.value));
                if (collect000 == null) {
                  {
                    collect000 = Cons.cons(StandardObject.yieldTypeSpecTree(ts), Stella.NIL);
                    if (listoftypes == Stella.NIL) {
                      listoftypes = collect000;
                    }
                    else {
                      Cons.addConsToEndOfConsList(listoftypes, collect000);
                    }
                  }
                }
                else {
                  {
                    collect000.rest = Cons.cons(StandardObject.yieldTypeSpecTree(ts), Stella.NIL);
                    collect000 = collect000.rest;
                  }
                }
              }
            }
            return (Cons.cons(Symbol.internSymbolInModule(self000.specifierBaseType.symbolName, ((Module)(self000.specifierBaseType.homeContext)), true), ((StandardObject.arrayTypeSpecifierP(self000) ? Cons.list$(Cons.cons(Stella.SYM_STELLA_SIZE, Cons.cons(ParametricTypeSpecifier.yieldArrayDimensionsTree(self000), Cons.cons(Stella.NIL, Stella.NIL)))) : Stella.NIL)).concatenate(Cons.cons(Stella.SYM_STELLA_OF, listoftypes.concatenate(Stella.NIL, Stella.NIL)), Stella.NIL)));
          }
        }
      }
      else if (Surrogate.subtypeOfAnchoredTypeSpecifierP(testValue000)) {
        { AnchoredTypeSpecifier self000 = ((AnchoredTypeSpecifier)(self));

          if (self000.specifierParameterName != null) {
            return (Cons.list$(Cons.cons(Stella.SYM_STELLA_LIKE, Cons.cons(Cons.cons(self000.specifierParameterName, Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))));
          }
          else {
            return (Cons.list$(Cons.cons(Stella.SYM_STELLA_LIKE, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))));
          }
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("validate-type-specifier: Not defined on `" + self + "'");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static StandardObject computeRelativeTypeSpec(StandardObject relativetype, StandardObject ownertype) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(relativetype);

      if (Surrogate.subtypeOfParametricTypeSpecifierP(testValue000)) {
        { ParametricTypeSpecifier relativetype000 = ((ParametricTypeSpecifier)(relativetype));

          { boolean alwaysP000 = true;

            { StandardObject ts = null;
              Cons iter000 = relativetype000.specifierParameterTypes.theConsList;

              loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                ts = ((StandardObject)(iter000.value));
                if (!Stella_Object.typeP(ts)) {
                  alwaysP000 = false;
                  break loop000;
                }
              }
            }
            if (alwaysP000) {
              return (relativetype000);
            }
          }
          { List typeslist = List.newList();
            StandardObject relativets = null;
            boolean foundrelativistictypeP = false;

            { StandardObject ts = null;
              Cons iter001 = relativetype000.specifierParameterTypes.theConsList;
              Cons collect000 = null;

              for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                ts = ((StandardObject)(iter001.value));
                relativets = StandardObject.computeRelativeTypeSpec(ts, ownertype);
                if (!(relativets == ts)) {
                  foundrelativistictypeP = true;
                }
                if (collect000 == null) {
                  {
                    collect000 = Cons.cons(relativets, Stella.NIL);
                    if (typeslist.theConsList == Stella.NIL) {
                      typeslist.theConsList = collect000;
                    }
                    else {
                      Cons.addConsToEndOfConsList(typeslist.theConsList, collect000);
                    }
                  }
                }
                else {
                  {
                    collect000.rest = Cons.cons(relativets, Stella.NIL);
                    collect000 = collect000.rest;
                  }
                }
              }
            }
            if (foundrelativistictypeP) {
              { ParametricTypeSpecifier newts = ParametricTypeSpecifier.newParametricTypeSpecifier();

                newts.specifierBaseType = relativetype000.specifierBaseType;
                newts.specifierParameterTypes = typeslist;
                newts.specifierDimensions = relativetype000.specifierDimensions;
                return (newts);
              }
            }
            else {
              {
                typeslist.free();
                return (relativetype000);
              }
            }
          }
        }
      }
      else if (Surrogate.subtypeOfAnchoredTypeSpecifierP(testValue000)) {
        { AnchoredTypeSpecifier relativetype000 = ((AnchoredTypeSpecifier)(relativetype));

          return (StandardObject.computeAnchoredTypeSpec(ownertype, relativetype000));
        }
      }
      else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
        { Surrogate relativetype000 = ((Surrogate)(relativetype));

          return (relativetype000);
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("compute-relative-type-spec: Not defined on `" + relativetype + "'");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static StandardObject computeAnchoredTypeSpec(StandardObject ownertype, AnchoredTypeSpecifier reltype) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(ownertype);

      if (Surrogate.subtypeOfSurrogateP(testValue000)) {
        { Surrogate ownertype000 = ((Surrogate)(ownertype));

          if (reltype.specifierParameterName == null) {
            return (ownertype000);
          }
          { Slot slot = Stella_Class.lookupSlot(((Stella_Class)(ownertype000.surrogateValue)), reltype.specifierParameterName);

            if (slot == null) {
              { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationError();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                    {
                      Stella.STANDARD_ERROR.nativeStream.println();
                      Stella.STANDARD_ERROR.nativeStream.println(" Missing :parameter named `" + reltype.specifierParameterName + "'");
                      Stella.STANDARD_ERROR.nativeStream.println("   for the class `" + Stella_Object.deUglifyParseTree(ownertype000) + "'");
                      Stella.STANDARD_ERROR.nativeStream.println(".");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                }
              }
              return (Stella.SGT_STELLA_OBJECT);
            }
            return (((((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null))) != null) ? ((StandardObject)(StandardObject.computeRelativeTypeSpec(((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null))), ownertype000))) : slot.slotBaseType));
          }
        }
      }
      else if (Surrogate.subtypeOfParametricTypeSpecifierP(testValue000)) {
        { ParametricTypeSpecifier ownertype000 = ((ParametricTypeSpecifier)(ownertype));

          if (reltype.specifierParameterName == null) {
            return (ownertype000);
          }
          { Symbol pname = null;
            Cons iter000 = ((Stella_Class)(ownertype000.specifierBaseType.surrogateValue)).parameters().theConsList;
            StandardObject ptype = null;
            Cons iter001 = ownertype000.specifierParameterTypes.theConsList;

            for (;(!(iter000 == Stella.NIL)) &&
                      (!(iter001 == Stella.NIL)); iter000 = iter000.rest, iter001 = iter001.rest) {
              pname = ((Symbol)(iter000.value));
              ptype = ((StandardObject)(iter001.value));
              if (pname == reltype.specifierParameterName) {
                return (ptype);
              }
            }
          }
          return (StandardObject.computeAnchoredTypeSpec(ownertype000.specifierBaseType, reltype));
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("compute-anchored-type-spec: Not defined on `" + ownertype + "'");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static StandardObject extractParameterType(StandardObject self, Symbol parameter, Object [] MV_returnarray) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(self);

      if (Surrogate.subtypeOfSurrogateP(testValue000)) {
        { Surrogate self000 = ((Surrogate)(self));

          { Slot slot = Stella_Class.lookupSlot(((Stella_Class)(self000.surrogateValue)), parameter);

            if (slot != null) {
              { StandardObject _return_temp = slot.type();

                MV_returnarray[0] = BooleanWrapper.wrapBoolean(true);
                return (_return_temp);
              }
            }
            else {
              { StandardObject _return_temp = Stella.SGT_STELLA_OBJECT;

                MV_returnarray[0] = BooleanWrapper.wrapBoolean(false);
                return (_return_temp);
              }
            }
          }
        }
      }
      else if (Surrogate.subtypeOfParametricTypeSpecifierP(testValue000)) {
        { ParametricTypeSpecifier self000 = ((ParametricTypeSpecifier)(self));

          { Symbol pname = null;
            Cons iter000 = ((Stella_Class)(self000.specifierBaseType.surrogateValue)).parameters().theConsList;
            StandardObject ptype = null;
            Cons iter001 = self000.specifierParameterTypes.theConsList;

            for (;(!(iter000 == Stella.NIL)) &&
                      (!(iter001 == Stella.NIL)); iter000 = iter000.rest, iter001 = iter001.rest) {
              pname = ((Symbol)(iter000.value));
              ptype = ((StandardObject)(iter001.value));
              if (pname == parameter) {
                { StandardObject _return_temp = ptype;

                  MV_returnarray[0] = BooleanWrapper.wrapBoolean(true);
                  return (_return_temp);
                }
              }
            }
          }
          { StandardObject _return_temp = Stella.SGT_STELLA_OBJECT;

            MV_returnarray[0] = BooleanWrapper.wrapBoolean(false);
            return (_return_temp);
          }
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("extract-parameter-type: Not defined on `" + self + "'");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static boolean voidP(StandardObject type) {
    return (type == Stella.SGT_STELLA_VOID);
  }

  public static boolean subTypeSpecOfP(StandardObject subtype, StandardObject supertype) {
    if (subtype == supertype) {
      return (true);
    }
    { Surrogate testValue000 = Stella_Object.safePrimaryType(subtype);

      if (Surrogate.subtypeOfSurrogateP(testValue000)) {
        { Surrogate subtype000 = ((Surrogate)(subtype));

          { Surrogate testValue001 = Stella_Object.safePrimaryType(supertype);

            if (Surrogate.subtypeOfSurrogateP(testValue001)) {
              { Surrogate supertype000 = ((Surrogate)(supertype));

                return (Surrogate.subtypeOfP(subtype000, supertype000) &&
                    StandardObject.compatibleParameterTypesP(subtype000, supertype000));
              }
            }
            else if (Surrogate.subtypeOfParametricTypeSpecifierP(testValue001)) {
              { ParametricTypeSpecifier supertype000 = ((ParametricTypeSpecifier)(supertype));

                return (Surrogate.subtypeOfP(subtype000, supertype000.specifierBaseType) &&
                    StandardObject.compatibleParameterTypesP(subtype000, supertype000));
              }
            }
            else {
              return (false);
            }
          }
        }
      }
      else if (Surrogate.subtypeOfParametricTypeSpecifierP(testValue000)) {
        { ParametricTypeSpecifier subtype000 = ((ParametricTypeSpecifier)(subtype));

          { Surrogate testValue002 = Stella_Object.safePrimaryType(supertype);

            if (Surrogate.subtypeOfSurrogateP(testValue002)) {
              { Surrogate supertype000 = ((Surrogate)(supertype));

                return (Surrogate.subtypeOfP(subtype000.specifierBaseType, supertype000) &&
                    StandardObject.compatibleParameterTypesP(subtype000, supertype000));
              }
            }
            else if (Surrogate.subtypeOfParametricTypeSpecifierP(testValue002)) {
              { ParametricTypeSpecifier supertype000 = ((ParametricTypeSpecifier)(supertype));

                return (Surrogate.subtypeOfP(subtype000.specifierBaseType, supertype000.specifierBaseType) &&
                    StandardObject.compatibleParameterTypesP(subtype000, supertype000));
              }
            }
            else {
              return (false);
            }
          }
        }
      }
      else if (Surrogate.subtypeOfAnchoredTypeSpecifierP(testValue000)) {
        { AnchoredTypeSpecifier subtype000 = ((AnchoredTypeSpecifier)(subtype));

          return (Stella_Object.anchoredTypeSpecifierP(supertype) &&
              (subtype000.specifierParameterName == ((AnchoredTypeSpecifier)(supertype)).specifierParameterName));
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("sub-type-spec-of?: Not defined on `" + subtype + "'");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static boolean compatibleParameterTypesP(StandardObject subtype, StandardObject supertype) {
    if (Stella_Object.typeP(subtype) ||
        Stella_Object.typeP(supertype)) {
      return (true);
    }
    { Stella_Class subclass = null;
      Stella_Class superclass = null;

      { Surrogate testValue000 = Stella_Object.safePrimaryType(subtype);

        if (Surrogate.subtypeOfSurrogateP(testValue000)) {
          { Surrogate subtype000 = ((Surrogate)(subtype));

            subclass = ((Stella_Class)(subtype000.surrogateValue));
          }
        }
        else if (Surrogate.subtypeOfParametricTypeSpecifierP(testValue000)) {
          { ParametricTypeSpecifier subtype000 = ((ParametricTypeSpecifier)(subtype));

            subclass = ((Stella_Class)(subtype000.specifierBaseType.surrogateValue));
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      { Surrogate testValue001 = Stella_Object.safePrimaryType(supertype);

        if (Surrogate.subtypeOfSurrogateP(testValue001)) {
          { Surrogate supertype000 = ((Surrogate)(supertype));

            superclass = ((Stella_Class)(supertype000.surrogateValue));
          }
        }
        else if (Surrogate.subtypeOfParametricTypeSpecifierP(testValue001)) {
          { ParametricTypeSpecifier supertype000 = ((ParametricTypeSpecifier)(supertype));

            superclass = ((Stella_Class)(supertype000.specifierBaseType.surrogateValue));
          }
        }
        else {
          { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

            stream001.nativeStream.print("`" + testValue001 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
          }
        }
      }
      { Symbol suppar = null;
        Cons iter000 = superclass.parameters().theConsList;

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          suppar = ((Symbol)(iter000.value));
          { boolean foundP000 = false;

            { Symbol subpar = null;
              Cons iter001 = subclass.parameters().theConsList;

              loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                subpar = ((Symbol)(iter001.value));
                if (suppar == subpar) {
                  foundP000 = true;
                  break loop001;
                }
              }
            }
            if (!(foundP000)) {
              return (false);
            }
          }
          { StandardObject subpartype = StandardObject.extractParameterType(subtype, suppar, new Object[1]);
            StandardObject suppartype = StandardObject.extractParameterType(supertype, suppar, new Object[1]);

            if (subpartype == suppartype) {
              continue loop000;
            }
            if ((!Stella_Object.anchoredTypeSpecifierP(subpartype)) &&
                (((Stella_Class)(StandardObject.typeSpecToBaseType(subpartype).surrogateValue)) == null)) {
              { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationError();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                    {
                      Stella.STANDARD_ERROR.nativeStream.println();
                      Stella.STANDARD_ERROR.nativeStream.println(" Parameter type `" + StandardObject.typeSpecToBaseType(subpartype) + "' of `" + Stella_Object.deUglifyParseTree(subtype) + "' is not yet defined.");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                }
              }
              return (false);
            }
            if ((!Stella_Object.anchoredTypeSpecifierP(suppartype)) &&
                (((Stella_Class)(StandardObject.typeSpecToBaseType(suppartype).surrogateValue)) == null)) {
              { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationError();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                    {
                      Stella.STANDARD_ERROR.nativeStream.println();
                      Stella.STANDARD_ERROR.nativeStream.println(" Parameter type `" + StandardObject.typeSpecToBaseType(suppartype) + "' of `" + Stella_Object.deUglifyParseTree(supertype) + "' is not yet defined.");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                }
              }
              return (false);
            }
            if (!(StandardObject.subTypeSpecOfP(subpartype, suppartype))) {
              return (false);
            }
          }
        }
      }
      return (true);
    }
  }

  public static Stella_Class typeSpecToClass(StandardObject self) {
    return (((Stella_Class)(StandardObject.typeSpecToBaseType(self).surrogateValue)));
  }

  public static StandardObject baseTypeToTypeSpec(StandardObject self) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(self);

      if (Surrogate.subtypeOfSurrogateP(testValue000)) {
        { Surrogate self000 = ((Surrogate)(self));

          { Stella_Class renamed_Class = ((Stella_Class)(self000.surrogateValue));
            List parameters = renamed_Class.parameters();
            StandardObject parametertype = null;
            List parametertypes = null;

            if (parameters.nonEmptyP()) {
              parametertypes = List.newList();
              { Symbol parameter = null;
                Cons iter000 = parameters.theConsList;
                Cons collect000 = null;

                for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  parameter = ((Symbol)(iter000.value));
                  parametertype = Stella_Class.lookupSlot(renamed_Class, parameter).computeReturnTypeSpec(self000);
                  if (Surrogate.unknownTypeP(((Surrogate)(parametertype)))) {
                    return (self000);
                  }
                  if (collect000 == null) {
                    {
                      collect000 = Cons.cons(parametertype, Stella.NIL);
                      if (parametertypes.theConsList == Stella.NIL) {
                        parametertypes.theConsList = collect000;
                      }
                      else {
                        Cons.addConsToEndOfConsList(parametertypes.theConsList, collect000);
                      }
                    }
                  }
                  else {
                    {
                      collect000.rest = Cons.cons(parametertype, Stella.NIL);
                      collect000 = collect000.rest;
                    }
                  }
                }
              }
              { ParametricTypeSpecifier self003 = ParametricTypeSpecifier.newParametricTypeSpecifier();

                self003.specifierBaseType = self000;
                self003.specifierParameterTypes = parametertypes;
                { ParametricTypeSpecifier value000 = self003;

                  return (value000);
                }
              }
            }
            return (self000);
          }
        }
      }
      else if (Surrogate.subtypeOfParametricTypeSpecifierP(testValue000)) {
        { ParametricTypeSpecifier self000 = ((ParametricTypeSpecifier)(self));

          return (self000);
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("base-type-to-type-spec: Not defined on `" + self + "'");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static Surrogate typeSpecToBaseType(StandardObject self) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(self);

      if (Surrogate.subtypeOfSurrogateP(testValue000)) {
        { Surrogate self000 = ((Surrogate)(self));

          return (self000);
        }
      }
      else if (Surrogate.subtypeOfParametricTypeSpecifierP(testValue000)) {
        { ParametricTypeSpecifier self000 = ((ParametricTypeSpecifier)(self));

          return (self000.specifierBaseType);
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("type-spec-to-base-type: Not defined on `" + self + "'");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static Surrogate validateTypeSpecifier(StandardObject self, Stella_Class anchorclass, boolean skipanchoredtypeP) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(self);

      if (Surrogate.subtypeOfParametricTypeSpecifierP(testValue000)) {
        { ParametricTypeSpecifier self000 = ((ParametricTypeSpecifier)(self));

          if (((Stella_Class)(self000.specifierBaseType.surrogateValue)) == null) {
            return (Stella.SGT_STELLA_UNKNOWN);
          }
          { int parameterdifferential = self000.specifierParameterTypes.length() - ((Stella_Class)(self000.specifierBaseType.surrogateValue)).parameters().length();

            if (parameterdifferential > 0) {
              ParametricTypeSpecifier.warnOfParameterMismatch(self000, "Too many parameters in type specification.");
            }
            else if (parameterdifferential < 0) {
              ParametricTypeSpecifier.warnOfParameterMismatch(self000, "Not enough parameters in type specification.");
            }
            else {
              { Stella_Class baseclass = ((Stella_Class)(StandardObject.typeSpecToBaseType(self000).surrogateValue));

                if (baseclass.classSlotsFinalizedP) {
                  { Cons inheritedtypes = Stella_Class.yieldClassParameterTypes(baseclass);

                    { Surrogate supertype = null;
                      Cons iter000 = inheritedtypes;
                      StandardObject subtypespec = null;
                      Cons iter001 = self000.specifierParameterTypes.theConsList;

                      for (;(!(iter000 == Stella.NIL)) &&
                                (!(iter001 == Stella.NIL)); iter000 = iter000.rest, iter001 = iter001.rest) {
                        supertype = ((Surrogate)(iter000.value));
                        subtypespec = ((StandardObject)(iter001.value));
                        if ((!Stella_Object.anchoredTypeSpecifierP(subtypespec)) &&
                            ((!(supertype == Stella.SGT_STELLA_UNKNOWN)) &&
                             (!Surrogate.optimisticSubtypeOfP(StandardObject.typeSpecToBaseType(subtypespec), supertype)))) {
                          ParametricTypeSpecifier.warnOfParameterMismatch(self000, "Parametric subtype(s) don't specialize supertype(s)");
                        }
                      }
                    }
                  }
                }
              }
            }
            return (self000.specifierBaseType);
          }
        }
      }
      else if (Surrogate.subtypeOfAnchoredTypeSpecifierP(testValue000)) {
        { AnchoredTypeSpecifier self000 = ((AnchoredTypeSpecifier)(self));

          if (skipanchoredtypeP) {
            return (null);
          }
          if (anchorclass == null) {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Illegal use of anchored type for function that has no first\nargument (and hence nothing to anchor onto).");
            return (null);
          }
          { Symbol slotname = self000.specifierParameterName;
            Slot anchorslot = null;

            if (slotname == null) {
              return (anchorclass.classType);
            }
            { 
              anchorslot = Stella_Class.lookupSlot(anchorclass, slotname);
              if (!(anchorslot != null)) {
                { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                  stream000.nativeStream.print("Can't find a slot named ``" + slotname + "'' on the class ``" + Stella_Class.className(anchorclass) + "''");
                  { String error_message_ = stream000.theStringReader();

                    Native.continuableError(error_message_);
                  }
                }
              }
            }
            return (anchorslot.slotBaseType);
          }
        }
      }
      else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
        { Surrogate self000 = ((Surrogate)(self));

          return (self000);
        }
      }
      else {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("validate-type-specifier: Not defined on `" + self + "'");
          throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static boolean arrayTypeSpecifierP(StandardObject typespec) {
    if (Surrogate.subtypeOfParametricTypeSpecifierP(Stella_Object.safePrimaryType(typespec))) {
      { ParametricTypeSpecifier typespec000 = ((ParametricTypeSpecifier)(typespec));

        { Surrogate basetype = typespec000.specifierBaseType;

          if (basetype == Stella.SGT_STELLA_ARRAY) {
            return (true);
          }
        }
      }
    }
    else {
    }
    return (false);
  }

  public static boolean conformingTypeSpecP(StandardObject subTypeSpec, StandardObject superTypeSpec) {
    return ((subTypeSpec == null) ||
        ((subTypeSpec == Stella.SGT_STELLA_UNKNOWN) ||
         ((Stella_Object.typeP(subTypeSpec) &&
        (((Stella_Class)(((Surrogate)(subTypeSpec)).surrogateValue)) == null)) ||
          (Stella_Object.anchoredTypeSpecifierP(subTypeSpec) ||
           ((superTypeSpec == null) ||
            ((superTypeSpec == Stella.SGT_STELLA_UNKNOWN) ||
             ((Stella_Object.typeP(superTypeSpec) &&
        (((Stella_Class)(((Surrogate)(superTypeSpec)).surrogateValue)) == null)) ||
              (Stella_Object.anchoredTypeSpecifierP(superTypeSpec) ||
               StandardObject.subTypeSpecOfP(subTypeSpec, superTypeSpec)))))))));
  }

  /** Return the slot named <code>slotName</code> on the class
   * representing the type of <code>self</code>.
   * @param self
   * @param slotName
   * @return Slot
   */
  public static Slot getSlot(StandardObject self, Symbol slotName) {
    return (Stella_Class.lookupSlot(self.primaryClass(), slotName));
  }

  /** Return the most specific type that is a supertype of
   * both <code>type1</code> and <code>type2</code>.  If there is more than one, arbitrarily pick one.
   * If there is none, return @VOID.  If one or both types are parametric,
   * also try to generalize parameter types if necessary.
   * @param type1
   * @param type2
   * @return StandardObject
   */
  public static StandardObject twoArgumentLeastCommonSupertype(StandardObject type1, StandardObject type2) {
    if (type1 == type2) {
      return (type1);
    }
    { Surrogate basetype1 = StandardObject.typeSpecToBaseType(type1);
      Surrogate basetype2 = StandardObject.typeSpecToBaseType(type2);
      Stella_Class superclass = Stella_Class.twoArgumentLeastCommonSuperclass(((Stella_Class)(basetype1.surrogateValue)), ((Stella_Class)(basetype2.surrogateValue)));

      if (superclass == null) {
        return (Stella.SGT_STELLA_VOID);
      }
      if ((type1 == basetype1) &&
          (type2 == basetype2)) {
        return (superclass.classType);
      }
      { Surrogate supertype = superclass.classType;
        StandardObject supertypespec = StandardObject.baseTypeToTypeSpec(supertype);
        List parameters = superclass.parameters();
        List parametertypes = null;
        StandardObject sptype = null;
        StandardObject ptype1 = null;
        StandardObject ptype2 = null;
        boolean parameterexistsP = false;
        ParametricTypeSpecifier result = null;

        if (parameters.emptyP()) {
          return (supertype);
        }
        parametertypes = List.newList();
        { Symbol parameter = null;
          Cons iter000 = parameters.theConsList;
          Cons collect000 = null;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            parameter = ((Symbol)(iter000.value));
            { Object [] caller_MV_returnarray = new Object[1];

              ptype1 = StandardObject.extractParameterType(type1, parameter, caller_MV_returnarray);
              parameterexistsP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[0])).wrapperValue));
            }
            if ((!parameterexistsP) ||
                Surrogate.unknownTypeP(StandardObject.typeSpecToBaseType(ptype1))) {
              return (supertype);
            }
            { Object [] caller_MV_returnarray = new Object[1];

              ptype2 = StandardObject.extractParameterType(type2, parameter, caller_MV_returnarray);
              parameterexistsP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[0])).wrapperValue));
            }
            if ((!parameterexistsP) ||
                Surrogate.unknownTypeP(StandardObject.typeSpecToBaseType(ptype2))) {
              return (supertype);
            }
            sptype = StandardObject.twoArgumentLeastCommonSupertype(ptype1, ptype2);
            if ((!(supertype == supertypespec)) &&
                (!StandardObject.subTypeSpecOfP(sptype, StandardObject.extractParameterType(supertype, parameter, new Object[1])))) {
              return (supertype);
            }
            if (collect000 == null) {
              {
                collect000 = Cons.cons(sptype, Stella.NIL);
                if (parametertypes.theConsList == Stella.NIL) {
                  parametertypes.theConsList = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(parametertypes.theConsList, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(sptype, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        { ParametricTypeSpecifier self001 = ParametricTypeSpecifier.newParametricTypeSpecifier();

          self001.specifierBaseType = supertype;
          self001.specifierParameterTypes = parametertypes;
          result = self001;
        }
        if (StandardObject.arrayTypeSpecifierP(type1) &&
            StandardObject.arrayTypeSpecifierP(type2)) {
          if (!Stella_Object.equalConsTreesP(ParametricTypeSpecifier.arrayTypeDimensions(((ParametricTypeSpecifier)(type1))).theConsList, ParametricTypeSpecifier.arrayTypeDimensions(((ParametricTypeSpecifier)(type2))).theConsList)) {
            return (supertype);
          }
          result.specifierDimensions = ((ParametricTypeSpecifier)(type1)).specifierDimensions;
        }
        return (result);
      }
    }
  }

  public boolean objectEqlP(Stella_Object y) {
    { StandardObject x = this;

      return (x == y);
    }
  }

  public Stella_Object copyWrappedLiteral() {
    { StandardObject self = this;

      return (self);
    }
  }

  public boolean standardObjectP() {
    { StandardObject self = this;

      return (true);
    }
  }

  public int hashCode_() {
    { StandardObject self = this;

      return (self.hashCode());
    }
  }

}

