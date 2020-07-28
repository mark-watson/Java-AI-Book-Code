//  -*- Mode: Java -*-
//
// StringWrapper.java

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

public class StringWrapper extends LiteralWrapper {
    public String wrapperValue;

  /** Return a literal object whose value is the STRING 'value'.
   * @param value
   * @return StringWrapper
   */
  public static StringWrapper wrapString(String value) {
    if (value == null) {
      return (Stella.NULL_STRING_WRAPPER);
    }
    else {
      return (StringWrapper.newStringWrapper(value));
    }
  }

  public static StringWrapper newStringWrapper(String wrapperValue) {
    { StringWrapper self = null;

      self = new StringWrapper();
      self.wrapperValue = wrapperValue;
      return (self);
    }
  }

  public static void idlOutputIdentifier(StringWrapper identifier) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(identifier.wrapperValue);
  }

  public static void idlOutputComment(StringWrapper tree) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("// " + tree.wrapperValue);
  }

  public void idlOutputLiteral() {
    { StringWrapper string = this;

      Stella.string_idlOutputLiteral(string.wrapperValue);
    }
  }

  public static boolean javaNestedOperatorNeedsParenthesesP(StringWrapper op, Stella_Object nested) {
    return (Stella_Object.javaOperatorP(nested) &&
        (!(StringWrapper.javaCommutativeBinaryOperatorP(op) &&
        Stella.stringEqlP(op.wrapperValue, ((StringWrapper)(((Cons)(nested)).rest.rest.value)).wrapperValue))));
  }

  public static boolean javaCommutativeBinaryOperatorP(StringWrapper operator) {
    return (Stella.getQuotedTree("((\"+\" \"*\") \"/STELLA\")", "/STELLA").memberP(operator));
  }

  public static boolean javaIndentableBinaryOperatorP(StringWrapper operator) {
    return (Stella.getQuotedTree("((\"||\" \"&&\") \"/STELLA\")", "/STELLA").memberP(operator));
  }

  public static void javaOutputVerbatim(StringWrapper verbatimstatement) {
    { String vstring = verbatimstatement.wrapperValue;

      if (Native.string_memberP(vstring, '\n') ||
          Native.string_memberP(vstring, '\r')) {
        InputStream.substituteTemplateVariablesToStream(Stella.makeTokenizerStringStream(vstring), ((OutputStream)(Stella.$CURRENT_STREAM$.get())), Stella.$JAVA_STELLA_PACKAGE_MAPPING$);
      }
      else {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(Stella.substituteTemplateVariablesInString(vstring, Stella.$JAVA_STELLA_PACKAGE_MAPPING$));
      }
    }
  }

  public static void javaOutputJavadocComment(StringWrapper tree, Cons parameterNamesAndTypes, StringWrapper returnValue, String author, String version) {
    { Cons parameterNames = Stella.NIL;

      if (parameterNamesAndTypes != null) {
        { Cons n = null;
          Cons iter000 = parameterNamesAndTypes;
          Cons collect000 = null;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            n = ((Cons)(iter000.value));
            if (collect000 == null) {
              {
                collect000 = Cons.cons(((StringWrapper)(n.rest.value)), Stella.NIL);
                if (parameterNames == Stella.NIL) {
                  parameterNames = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(parameterNames, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(((StringWrapper)(n.rest.value)), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      Stella.javaOutputCommentString(tree.wrapperValue, "/** ", " * ", null, true, parameterNames);
      { StringWrapper n = null;
        Cons iter001 = parameterNames;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          n = ((StringWrapper)(iter001.value));
          Stella.javaIndent();
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(" * @param " + n.wrapperValue);
        }
      }
      if ((returnValue != null) &&
          (!Stella.stringEqlP(returnValue.wrapperValue, "void"))) {
        Stella.javaIndent();
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(" * @return " + returnValue.wrapperValue);
      }
      if ((author != null) &&
          (!(author == ""))) {
        Stella.javaIndent();
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(" * @author " + author);
      }
      if ((version != null) &&
          (!(version == ""))) {
        Stella.javaIndent();
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(" * @version " + version);
      }
      Stella.javaIndent();
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(" */");
    }
  }

  public static void javaOutputComment(StringWrapper tree) {
    Stella.javaOutputCommentString(tree.wrapperValue, "// ", "// ", null, false, Stella.NIL);
  }

  public void javaOutputLiteral() {
    { StringWrapper string = this;

      Stella.string_javaOutputLiteral(string.wrapperValue);
    }
  }

  public static void javaOutputIdentifier(StringWrapper identifier) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(identifier.wrapperValue);
  }

  public static StringWrapper javaTranslateClassNamestring(StringWrapper namestring) {
    { String translatedname = null;

      if (Stella.allUpperCaseStringP(namestring.wrapperValue)) {
        translatedname = Stella.makeMatchingNameFull(namestring.wrapperValue, Stella.KWD_CLEVER, Stella.KWD_CLEVER, "- ", "", "", "", "", Stella.KWD_TITLECASE, "");
      }
      else {
        translatedname = Stella.makeMatchingNameFull(namestring.wrapperValue, Stella.KWD_CLEVER, Stella.KWD_CLEVER, "- ", "", "", "", "", Stella.KWD_PRESERVE, "");
      }
      translatedname = Stella.javaSubstituteForbiddenCharacters(translatedname, Stella.KWD_CAPITALIZE);
      if (Stella.javaLookupReservedWordTable(translatedname) != null) {
        return (StringWrapper.wrapString("Stella_" + translatedname));
      }
      else {
        return (StringWrapper.wrapString(translatedname));
      }
    }
  }

  public static void cppOutputStaticMemberVars(StringWrapper renamed_Class, Cons declarations) {
    { Cons declaration = null;
      Cons iter000 = declarations;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        declaration = ((Cons)(iter000.value));
        Stella.cppIndent();
        Stella_Object.cppOutputTypedEntity(declaration.value, StringWrapper.wrapString(renamed_Class.wrapperValue + "::" + ((StringWrapper)(declaration.rest.value)).wrapperValue), declaration.rest.rest.value);
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
      }
    }
    if (!(declarations == Stella.NIL)) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
    }
  }

  public static boolean cppNestedOperatorNeedsParenthesesP(StringWrapper op, Stella_Object nested) {
    return (Stella_Object.cppOperatorP(nested) &&
        (!(StringWrapper.cppCommutativeBinaryOperatorP(op) &&
        Stella.stringEqlP(op.wrapperValue, ((StringWrapper)(((Cons)(nested)).rest.rest.value)).wrapperValue))));
  }

  public static boolean cppCommutativeBinaryOperatorP(StringWrapper operator) {
    return (Stella.getQuotedTree("((\"+\" \"*\") \"/STELLA\")", "/STELLA").memberP(operator));
  }

  public static boolean cppIndentableBinaryOperatorP(StringWrapper operator) {
    return (Stella.getQuotedTree("((\"||\" \"&&\") \"/STELLA\")", "/STELLA").memberP(operator));
  }

  public static void cppOutputIdentifier(StringWrapper identifier) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(identifier.wrapperValue);
  }

  public void cppOutputLiteral() {
    { StringWrapper string = this;

      Stella.string_cppOutputLiteral(string.wrapperValue);
    }
  }

  public static void cppOutputMethodPointer(StringWrapper methodname) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("&" + methodname.wrapperValue);
  }

  public static void cppOutputFunctionPointer(StringWrapper functionname) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("&" + functionname.wrapperValue);
  }

  public static void cppOutputComment(StringWrapper tree) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("// ");
    { boolean returnp = false;

      { char renamed_Char = Stella.NULL_CHARACTER;
        String vector000 = tree.wrapperValue;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          renamed_Char = vector000.charAt(index000);
          switch (renamed_Char) {
            case '\n': 
              if (!(returnp)) {
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
                Stella.cppIndent();
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("// ");
              }
              returnp = false;
            break;
            case '\r': 
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
              Stella.cppIndent();
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("// ");
              returnp = true;
            break;
            default:
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(renamed_Char);
              returnp = false;
            break;
          }
        }
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
    }
  }

  public static void cppOutputVerbatim(StringWrapper verbatimstatement) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(verbatimstatement.wrapperValue);
  }

  /** Define a demon <code>name</code> and attach it to a class or slot.
   * @param name
   * @param parameterstree
   * @param optionsandbody
   * @return Stella_Object
   */
  public static Stella_Object defdemon(StringWrapper name, Cons parameterstree, Cons optionsandbody) {
    { Stella_Object firstparameter = parameterstree.value;
      Surrogate type = null;
      Symbol demonfunctionname = Symbol.internSymbol(name.wrapperValue);

      if (!Stella_Object.consP(firstparameter)) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Illegal first parameter in demon `" + Stella_Object.deUglifyParseTree(name) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        return (Stella.NIL);
      }
      type = StandardObject.typeSpecToBaseType(Stella_Object.safeYieldTypeSpecifier(((Cons)(firstparameter)).rest.value));
      if (((Stella_Class)(type.surrogateValue)) == null) {
        { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Demon defined on the non-existent class `" + Stella_Object.deUglifyParseTree(type) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
          }
        }
        return (Stella.NIL);
      }
      { Cons optionstree = null;
        Cons bodytree = null;

        { Object [] caller_MV_returnarray = new Object[1];

          optionstree = Cons.destructureDefdemonBody(optionsandbody, caller_MV_returnarray);
          bodytree = ((Cons)(caller_MV_returnarray[0]));
        }
        Cons.inPlaceNormalizeDemonOptions(optionstree);
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFUN, Cons.cons(demonfunctionname, Cons.cons(Cons.cons(parameterstree, bodytree.concatenate(Stella.NIL, Stella.NIL)), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_STARTUP_TIME_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINE_DEMON, Cons.cons(name, Cons.cons(optionstree.concatenate(Cons.list$(Cons.cons(Stella.KWD_CODE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WRAP_LITERAL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_CODE, Cons.cons(Stella.KWD_FUNCTION, Cons.cons(demonfunctionname, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))));
      }
    }
  }

  public boolean objectEqlP(Stella_Object y) {
    { StringWrapper x = this;

      if (y != null) {
        { Surrogate ytype = y.primaryType();

          if ((ytype == Stella.SGT_STELLA_STRING_WRAPPER) ||
              ((ytype == Stella.SGT_STELLA_VERBATIM_STRING_WRAPPER) ||
               (((!Stella.$CLASS_HIERARCHY_BOOTEDp$) &&
              ((ytype == null) ||
               ((Stella.SGT_STELLA_STRING_WRAPPER == null) ||
                (Stella.SGT_STELLA_VERBATIM_STRING_WRAPPER == null)))) ||
                Stella_Object.isaP(y, Stella.SGT_STELLA_STRING_WRAPPER)))) {
            return (Stella.stringEqlP(x.wrapperValue, ((StringWrapper)(y)).wrapperValue));
          }
        }
      }
      return (false);
    }
  }

  public Stella_Object copyWrappedLiteral() {
    { StringWrapper self = this;

      return (StringWrapper.wrapString(self.wrapperValue));
    }
  }

  /** Unwrap <code>wrapper</code> and return the result.
   * Return NULL if <code>wrapper</code> is NULL.
   * @param wrapper
   * @return String
   */
  public static String unwrapString(StringWrapper wrapper) {
    if (wrapper == null) {
      return (null);
    }
    else {
      return (wrapper.wrapperValue);
    }
  }

  public Keyword keywordify() {
    { StringWrapper self = this;

      return (Stella.internKeyword(self.wrapperValue));
    }
  }

  public static boolean wrappedStringLessThanP(StringWrapper x, StringWrapper y) {
    return (Stella.stringL(x.wrapperValue, y.wrapperValue));
  }

  public int hashCode_() {
    { StringWrapper self = this;

      return ((self.wrapperValue).hashCode());
    }
  }

  /** Return true if <code>x</code> is not the wrapped empty string &quot;&quot;
   * @return boolean
   */
  public boolean nonEmptyP() {
    { StringWrapper x = this;

      return (!Stella.stringEqlP(x.wrapperValue, ""));
    }
  }

  /** Return true if <code>x</code> is the wrapped empty string &quot;&quot;
   * @return boolean
   */
  public boolean emptyP() {
    { StringWrapper x = this;

      return (Stella.stringEqlP(x.wrapperValue, ""));
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { StringWrapper self = this;

      { String value = self.wrapperValue;

        if (value == null) {
          if (((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue()) {
            stream.print(Stella.SYM_STELLA_NULL_STRING);
          }
          else {
            stream.print("|L|NULL-STRING");
          }
        }
        else {
          if (((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue()) {
            Stella.printStringReadably(value, stream);
          }
          else {
            stream.print("|L|\"" + value + "\"");
          }
        }
      }
    }
  }

  public static Stella_Object accessStringWrapperSlotValue(StringWrapper self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_WRAPPER_VALUE) {
      if (setvalueP) {
        self.wrapperValue = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.wrapperValue);
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
    { StringWrapper self = this;

      return (Stella.SGT_STELLA_STRING_WRAPPER);
    }
  }

}

