//  -*- Mode: Java -*-
//
// OutputStream.java

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

public class OutputStream extends Stream {
    public edu.isi.stella.javalib.NativeOutputStream nativeStream;

  public static OutputStream newOutputStream() {
    { OutputStream self = null;

      self = new OutputStream();
      self.state = null;
      self.nativeStream = null;
      return (self);
    }
  }

  public static void javaOutputFileHeader(OutputStream stream, String filename) {
    {
      stream.nativeStream.println("//  -*- Mode: Java -*-");
      stream.nativeStream.println("//");
    }
;
    if (filename != null) {
      {
        stream.nativeStream.println("// " + Stella.fileNameWithoutDirectory(filename));
        stream.nativeStream.println();
      }
;
    }
    { String packageName = Module.javaPackagePrefix(((Module)(Stella.$MODULE$.get())), ".");
      Cons importedPackages = Stella.NIL;
      String name = null;

      OutputStream.outputCopyrightHeader(stream);
      if (!((packageName == null) ||
          Stella.stringEqlP(packageName, ""))) {
        packageName = Native.string_subsequence(packageName, 0, packageName.length() - 1);
        {
          stream.nativeStream.println("package " + packageName + ";");
          stream.nativeStream.println();
        }
;
      }
      if (((Module)(Stella.$MODULE$.get())) == Stella.$STELLA_MODULE$) {
        stream.nativeStream.println("import " + Stella.javaStellaPackage() + ".javalib.*;");
      }
      else {
        {
          if ((Stella.string_getStellaClass("NATIVE", false) == null) &&
              (!Stella.inheritedClassNameConflictsP("NATIVE"))) {
            stream.nativeStream.println("import " + Stella.javaStellaPackage() + ".javalib.Native;");
          }
          if ((Stella.string_getStellaClass("STELLA-SPECIAL-VARIABLE", false) == null) &&
              (!Stella.inheritedClassNameConflictsP("STELLA-SPECIAL-VARIABLE"))) {
            stream.nativeStream.println("import " + Stella.javaStellaPackage() + ".javalib.StellaSpecialVariable;");
          }
        }
      }
      if (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_MINIMIZE_JAVA_PREFIXES)) {
        { Module module = null;
          Cons iter000 = ((Module)(Stella.$MODULE$.get())).uses.theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            module = ((Module)(iter000.value));
            name = Module.javaPackagePrefix(module, ".");
            if (!(Stella.stringEqlP(name, packageName) ||
                importedPackages.memberP(StringWrapper.wrapString(name)))) {
              stream.nativeStream.println("import " + name + "*;");
              importedPackages = Cons.cons(StringWrapper.wrapString(name), importedPackages);
            }
          }
        }
        { Context module = null;
          Cons iter001 = ((Module)(Stella.$MODULE$.get())).allSuperContexts;

          for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
            module = ((Context)(iter001.value));
            name = Module.javaPackagePrefix(((Module)(module)), ".");
            if (!(Stella.stringEqlP(name, packageName) ||
                importedPackages.memberP(StringWrapper.wrapString(name)))) {
              stream.nativeStream.println("import " + name + "*;");
              importedPackages = Cons.cons(StringWrapper.wrapString(name), importedPackages);
            }
          }
        }
      }
      stream.nativeStream.println();
    }
  }

  public static void cppOutputFileHeader(OutputStream stream, String file) {
    {
      stream.nativeStream.println("//  -*- Mode: C++ -*-");
      stream.nativeStream.println();
    }
;
    if (file != null) {
      {
        stream.nativeStream.println("// " + Stella.fileNameWithoutDirectory(file));
        stream.nativeStream.println();
      }
;
    }
    OutputStream.outputCopyrightHeader(stream);
  }

  public static void prettyPrintSlotBlock(OutputStream stream, Iterator iterator, String slotgroup) {
    if (iterator.nextP()) {
      { Slot slot = ((Slot)(iterator.value));

        {
          stream.nativeStream.println();
          stream.nativeStream.println("  " + slotgroup);
          stream.nativeStream.print("  (");
        }
;
        slot.prettyPrintObject(stream);
      }
    }
    else {
      return;
    }
    { Slot slot = null;
      Iterator iter000 = iterator;

      while (iter000.nextP()) {
        slot = ((Slot)(iter000.value));
        {
          stream.nativeStream.println();
          stream.nativeStream.print("   ");
        }
;
        slot.prettyPrintObject(stream);
      }
    }
    stream.nativeStream.print(")");
  }

  public static void prettyPrintMethodParameters(OutputStream stream, MethodSlot method) {
    { int lastargindex = (((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_METHOD_VARIABLE_ARGUMENTSp, Stella.FALSE_WRAPPER))).wrapperValue ? method.methodParameterNames().length() : -1);

      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          stream.nativeStream.print("(");
          { Symbol parameter = null;
            Cons iter000 = method.methodParameterNames().theConsList;
            StandardObject tspec = null;
            Cons iter001 = method.methodParameterTypeSpecifiers().theConsList;
            int i = Stella.NULL_INTEGER;
            int iter002 = 1;

            for (;(!(iter000 == Stella.NIL)) &&
                      (!(iter001 == Stella.NIL)); 
                  iter000 = iter000.rest,
                  iter001 = iter001.rest,
                  iter002 = iter002 + 1) {
              parameter = ((Symbol)(iter000.value));
              tspec = ((StandardObject)(iter001.value));
              i = iter002;
              if (i > 1) {
                stream.nativeStream.print(" ");
              }
              if (i == lastargindex) {
                stream.nativeStream.print("&rest ");
                tspec = MethodSlot.variableArgumentsType(method);
              }
              stream.nativeStream.print("(" + Native.stringDowncase(parameter.symbolName) + " " + StandardObject.yieldTypeSpecTree(tspec) + ")");
            }
          }
          stream.nativeStream.print(")");

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
    }
  }

  /** Save <code>value</code> to <code>stream</code> as a properly formatted configuration
   * value.
   * @param stream
   * @param value
   */
  public static void saveConfigurationValue(OutputStream stream, Stella_Object value) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(value);

      if (Surrogate.subtypeOfStringP(testValue000)) {
        { StringWrapper value000 = ((StringWrapper)(value));

          stream.nativeStream.print(value000.wrapperValue);
        }
      }
      else if (Surrogate.subtypeOfBooleanP(testValue000)) {
        { BooleanWrapper value000 = ((BooleanWrapper)(value));

          if (value000 == Stella.TRUE_WRAPPER) {
            stream.nativeStream.print("true");
          }
          else {
            stream.nativeStream.print("false");
          }
        }
      }
      else if (Surrogate.subtypeOfIntegerP(testValue000)) {
        { IntegerWrapper value000 = ((IntegerWrapper)(value));

          stream.nativeStream.print(Native.integerToString(((long)(value000.wrapperValue))));
        }
      }
      else if (Surrogate.subtypeOfLongIntegerP(testValue000)) {
        { LongIntegerWrapper value000 = ((LongIntegerWrapper)(value));

          stream.nativeStream.print(Native.integerToString(value000.wrapperValue));
        }
      }
      else if (Surrogate.subtypeOfFloatP(testValue000)) {
        { FloatWrapper value000 = ((FloatWrapper)(value));

          stream.nativeStream.print(Native.floatToString(value000.wrapperValue));
        }
      }
      else {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            stream.nativeStream.print(value);

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
      }
    }
  }

  public static void outputFileHeader(OutputStream stream, String file) {
    if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
      OutputStream.clOutputFileHeader(stream, file, true);
    }
    else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) {
      OutputStream.javaOutputFileHeader(stream, file);
    }
    else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) {
      OutputStream.cppOutputFileHeader(stream, file);
    }
    else {
      OutputStream.clOutputFileHeader(stream, file, false);
    }
  }

  public static void outputCopyrightHeader(OutputStream stream) {
    if ((!Stella.translateWithCopyrightHeaderP()) ||
        ((((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) == null) ||
         (((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).banner == null))) {
      return;
    }
    if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
      stream.nativeStream.println("#|");
    }
    else if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) ||
        ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ||
         (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE))) {
      stream.nativeStream.println("/*");
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    { KeyValueList substitutionList = KeyValueList.newKeyValueList();
      InputStringStream bstream = Stella.makeTokenizerStringStream(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).banner);

      KeyValueList.fillInDateSubstitution(substitutionList);
      InputStream.substituteTemplateVariablesToStream(bstream, stream, substitutionList);
    }
    if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
      stream.nativeStream.print("|#");
    }
    else if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) ||
        ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ||
         (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE))) {
      stream.nativeStream.print("*/");
    }
    else {
      { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

        stream001.nativeStream.print("`" + ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
      }
    }
    {
      stream.nativeStream.println("");
      stream.nativeStream.println();
    }
;
  }

  /** Prints <code>xmlExpression</code> on <code>stream</code>.  Indentation begins with the
   * value of <code>indent</code>.  If this is the <code>null</code> integer, no indentation is
   * performed.  Otherwise it should normally be specified as 0 (zero) for
   * top-level calls.
   * <p>
   * It is assumed that the <code>xmlExpression</code> is a well-formed CONS-list
   * representation of an XML  form.  It expects a form like that form
   * returned by <code>read_XML_expression</code>.
   * <p>
   * Also handles a list of xml forms such as that returned by <code>XML_expressions</code>.
   * In that case, each of the forms is indented by <code>indent</code> spaces.
   * @param stream
   * @param xmlExpression
   * @param indent
   */
  public static void printXmlExpression(OutputStream stream, Cons xmlExpression, int indent) {
    if (Stella_Object.isaP(xmlExpression.value, Stella.SGT_STELLA_CONS)) {
      { Stella_Object exp = null;
        Cons iter000 = xmlExpression;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          exp = iter000.value;
          OutputStream.printXmlExpression(stream, ((Cons)(exp)), indent);
        }
      }
      return;
    }
    { XmlObject tag = ((XmlObject)(xmlExpression.value));
      Cons attributes = ((Cons)(xmlExpression.rest.value));
      String tagname = tag.surfaceForm;
      boolean previousItemWasStringP = false;
      boolean inContentFieldP = false;

      if (indent != Stella.NULL_INTEGER) {
        { int i = Stella.NULL_INTEGER;
          int iter001 = 1;
          int upperBound000 = indent;
          boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

          for (;unboundedP000 ||
                    (iter001 <= upperBound000); iter001 = iter001 + 1) {
            i = iter001;
            i = i;
            stream.nativeStream.print(" ");
          }
        }
      }
      { Surrogate testValue000 = Stella_Object.safePrimaryType(tag);

        if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_XML_PROCESSING_INSTRUCTION)) {
          { XmlProcessingInstruction tag000 = ((XmlProcessingInstruction)(tag));

            stream.nativeStream.print("<?" + tagname);
            OutputStream.printXmlNonElementAttributes(stream, attributes);
            stream.nativeStream.println("?>");
          }
        }
        else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_XML_DECLARATION)) {
          { XmlDeclaration tag000 = ((XmlDeclaration)(tag));

            stream.nativeStream.print("<!" + tagname);
            OutputStream.printXmlNonElementAttributes(stream, attributes);
            stream.nativeStream.println(">");
          }
        }
        else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_XML_SPECIAL)) {
          { XmlSpecial tag000 = ((XmlSpecial)(tag));

            stream.nativeStream.print("<![" + tagname + "[");
            if (Stella.stringEqlP(tagname, "CDATA")) {
              stream.nativeStream.print(StringWrapper.unwrapString(((StringWrapper)(attributes.value))));
            }
            else {
              OutputStream.printXmlNonElementAttributes(stream, attributes);
            }
            stream.nativeStream.print("]]>");
          }
        }
        else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_XML_ELEMENT)) {
          { XmlElement tag000 = ((XmlElement)(tag));

            if (xmlExpression.rest == Stella.NIL) {
              stream.nativeStream.println("<" + tagname + "/>");
            }
            else {
              stream.nativeStream.print("<" + tagname);
              OutputStream.printXmlElementAttributes(stream, ((Cons)(xmlExpression.rest.value)));
              previousItemWasStringP = false;
              if (indent != Stella.NULL_INTEGER) {
                indent = indent + 2;
              }
              { Stella_Object item = null;
                Cons iter002 = xmlExpression.rest.rest;

                for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                  item = iter002.value;
                  { Surrogate testValue001 = Stella_Object.safePrimaryType(item);

                    if (testValue001 == Stella.SGT_STELLA_CONS) {
                      { Cons item000 = ((Cons)(item));

                        if (Stella_Object.xmlCdataP(item000.value)) {
                          {
                            if (!(inContentFieldP)) {
                              stream.nativeStream.print(">");
                              inContentFieldP = true;
                            }
                            OutputStream.printXmlExpression(stream, item000, 0);
                            previousItemWasStringP = true;
                          }
                        }
                        else {
                          {
                            if (!(inContentFieldP)) {
                              stream.nativeStream.println(">");
                              inContentFieldP = true;
                            }
                            OutputStream.printXmlExpression(stream, item000, indent);
                            previousItemWasStringP = false;
                          }
                        }
                      }
                    }
                    else if (Surrogate.subtypeOfStringP(testValue001)) {
                      { StringWrapper item000 = ((StringWrapper)(item));

                        if (!(inContentFieldP)) {
                          stream.nativeStream.print(">");
                          inContentFieldP = true;
                        }
                        if (previousItemWasStringP) {
                          stream.nativeStream.print(" ");
                        }
                        { boolean foundP000 = false;

                          { char ch = Stella.NULL_CHARACTER;
                            String vector000 = item000.wrapperValue;
                            int index000 = 0;
                            int length000 = vector000.length();

                            loop003 : for (;index000 < length000; index000 = index000 + 1) {
                              ch = vector000.charAt(index000);
                              if (Stella.htmlCharacterNeedsQuotingP(ch)) {
                                foundP000 = true;
                                break loop003;
                              }
                            }
                          }
                          if (foundP000) {
                            Stella.writeHtmlQuotingSpecialCharacters(stream.nativeStream, item000.wrapperValue);
                          }
                          else {
                            stream.nativeStream.print(item000.wrapperValue);
                          }
                        }
                        previousItemWasStringP = true;
                      }
                    }
                    else {
                      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                        stream000.nativeStream.print("`" + testValue001 + "' is not a valid case option");
                        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                      }
                    }
                  }
                }
              }
              if (inContentFieldP) {
                {
                  if (indent != Stella.NULL_INTEGER) {
                    indent = indent - 2;
                    if (!(previousItemWasStringP)) {
                      { int i = Stella.NULL_INTEGER;
                        int iter003 = 1;
                        int upperBound001 = indent;
                        boolean unboundedP001 = upperBound001 == Stella.NULL_INTEGER;

                        for (;unboundedP001 ||
                                  (iter003 <= upperBound001); iter003 = iter003 + 1) {
                          i = iter003;
                          i = i;
                          stream.nativeStream.print(" ");
                        }
                      }
                    }
                  }
                  stream.nativeStream.print("</" + tagname + ">");
                  if ((indent != Stella.NULL_INTEGER) &&
                      (indent > 0)) {
                    stream.nativeStream.println();
                  }
                }
              }
              else {
                stream.nativeStream.println("/>");
              }
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
  }

  public static void printXmlElementAttributes(OutputStream stream, Cons attributes) {
    { Stella_Object item = null;
      Cons iter000 = attributes;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        item = iter000.value;
        { Surrogate testValue000 = Stella_Object.safePrimaryType(item);

          if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_XML_ATTRIBUTE)) {
            { XmlAttribute item000 = ((XmlAttribute)(item));

              stream.nativeStream.print(" " + item000.surfaceForm + "=");
            }
          }
          else if (Surrogate.subtypeOfStringP(testValue000)) {
            { StringWrapper item000 = ((StringWrapper)(item));

              stream.nativeStream.print("\"");
              { boolean foundP000 = false;

                { char ch = Stella.NULL_CHARACTER;
                  String vector000 = item000.wrapperValue;
                  int index000 = 0;
                  int length000 = vector000.length();

                  loop001 : for (;index000 < length000; index000 = index000 + 1) {
                    ch = vector000.charAt(index000);
                    if (Stella.htmlCharacterNeedsQuotingP(ch)) {
                      foundP000 = true;
                      break loop001;
                    }
                  }
                }
                if (foundP000) {
                  Stella.writeHtmlQuotingSpecialCharacters(stream.nativeStream, item000.wrapperValue);
                }
                else {
                  stream.nativeStream.print(item000.wrapperValue);
                }
              }
              stream.nativeStream.print("\"");
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
  }

  public static void printXmlNonElementAttributes(OutputStream stream, Cons attributes) {
    { boolean lastWasAttributeP = false;

      { Stella_Object item = null;
        Cons iter000 = attributes;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          item = iter000.value;
          { Surrogate testValue000 = Stella_Object.safePrimaryType(item);

            if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_XML_ATTRIBUTE)) {
              { XmlAttribute item000 = ((XmlAttribute)(item));

                stream.nativeStream.print(" " + item000.surfaceForm);
                lastWasAttributeP = true;
              }
            }
            else if (Surrogate.subtypeOfStringP(testValue000)) {
              { StringWrapper item000 = ((StringWrapper)(item));

                if (lastWasAttributeP) {
                  stream.nativeStream.print("=");
                }
                else {
                  stream.nativeStream.print(" ");
                }
                stream.nativeStream.print(item000.wrapperValue);
                lastWasAttributeP = false;
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
    }
  }

  public static void clOutputInPackageDeclaration(OutputStream stream, String renamed_Package) {
    stream.nativeStream.println("(CL:IN-PACKAGE \"" + renamed_Package + "\")");
  }

  public static void clOutputEnsurePackageDefinition(OutputStream stream, String renamed_Package) {
    {
      stream.nativeStream.println("(CL:EVAL-WHEN (:COMPILE-TOPLEVEL :LOAD-TOPLEVEL :EXECUTE)");
      stream.nativeStream.println("  (CL:UNLESS (CL:FIND-PACKAGE \"" + renamed_Package + "\")");
      stream.nativeStream.println("     (CL:DEFPACKAGE \"" + renamed_Package + "\" (:USE))))");
    }
;
  }

  public static void clOutputFileHeader(OutputStream stream, String file, boolean ensurepackageP) {
    { String renamed_Package = ((Module)(Stella.$MODULE$.get())).lispPackage();

      {
        stream.nativeStream.println(";;; -*- Mode: Lisp; Package: " + renamed_Package + "; Syntax: COMMON-LISP; Base: 10 -*-");
        stream.nativeStream.println();
      }
;
      if (file != null) {
        {
          stream.nativeStream.println(";;; " + Stella.fileNameWithoutDirectory(file));
          stream.nativeStream.println();
        }
;
      }
      { Object old$Translatoroutputlanguage$000 = Stella.$TRANSLATOROUTPUTLANGUAGE$.get();

        try {
          Native.setSpecial(Stella.$TRANSLATOROUTPUTLANGUAGE$, Stella.KWD_COMMON_LISP);
          OutputStream.outputCopyrightHeader(stream);

        } finally {
          Stella.$TRANSLATOROUTPUTLANGUAGE$.set(old$Translatoroutputlanguage$000);
        }
      }
      if (!(Stella.stringEqlP(renamed_Package, "STELLA") ||
          (!ensurepackageP))) {
        OutputStream.clOutputEnsurePackageDefinition(stream, renamed_Package);
        stream.nativeStream.println();
      }
      OutputStream.clOutputInPackageDeclaration(stream, renamed_Package);
      stream.nativeStream.println();
    }
  }

  /** Flush all buffered output of <code>self</code>.
   * @param self
   */
  public static void flushOutput(OutputStream self) {
    { edu.isi.stella.javalib.NativeOutputStream nativeStream = self.nativeStream;

      nativeStream.flush();
    }
  }

  public static boolean terminateOutputStreamP(OutputStream self) {
    { edu.isi.stella.javalib.NativeOutputStream nativeStream = self.nativeStream;

      if (!(nativeStream == null)) {
        nativeStream.close();
      }
      self.nativeStream = null;
      self.state = Stella.KWD_CLOSED;
      return (true);
    }
  }

  public Surrogate primaryType() {
    { OutputStream self = this;

      return (Stella.SGT_STELLA_OUTPUT_STREAM);
    }
  }

  public void free() {
    { OutputStream self = this;

      if (OutputStream.terminateOutputStreamP(self)) {
        Stella_Object.unmake(self);
      }
    }
  }

}

