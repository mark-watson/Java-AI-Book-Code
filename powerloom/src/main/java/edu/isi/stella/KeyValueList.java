//  -*- Mode: Java -*-
//
// KeyValueList.java

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

public class KeyValueList extends Dictionary {
    public KvCons theKvList;

  /** Read a configuration <code>file</code> and return its content as a configuration table.
   * Also enter each property read into the global system configuration table.
   * Assumes Java-style property file syntax.  Each property name is represented
   * as a wrapped string and each value as a wrapped string/integer/float or boolean.
   * @param file
   * @return KeyValueList
   */
  public static KeyValueList loadConfigurationFile(String file) {
    { String temp000 = Stella.findFileInLoadPath(file, null);

      file = ((temp000 != null) ? temp000 : file);
    }
    Stella.ensureFileExists(file, "load-configuration-file");
    { KeyValueList configuration = KeyValueList.newKeyValueList();

      { InputFileStream in = null;

        try {
          in = Stella.openInputFile(file, Stella.NIL);
          { String line = null;
            LineIterator iter000 = InputStream.lines(in);

            while (iter000.nextP()) {
              line = iter000.value;
              { StringWrapper key = null;
                Wrapper value = null;
                Keyword operator = null;

                { Object [] caller_MV_returnarray = new Object[2];

                  key = Stella.parseConfigurationFileLine(line, caller_MV_returnarray);
                  value = ((Wrapper)(caller_MV_returnarray[0]));
                  operator = ((Keyword)(caller_MV_returnarray[1]));
                }
                if (key != null) {
                  if (operator == Stella.KWD_SET) {
                    Stella.setConfigurationProperty(key.wrapperValue, value, configuration);
                    Stella.setConfigurationProperty(key.wrapperValue, value, null);
                  }
                  else if (operator == Stella.KWD_ADD) {
                    Stella.addConfigurationProperty(key.wrapperValue, value, configuration);
                    Stella.addConfigurationProperty(key.wrapperValue, value, null);
                  }
                  else {
                    { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                      stream000.nativeStream.print("`" + operator + "' is not a valid case option");
                      throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                    }
                  }
                }
              }
            }
          }

        } finally {
          if (in != null) {
            in.free();
          }
        }
      }
      return (configuration);
    }
  }

  public static KeyValueList newKeyValueList() {
    { KeyValueList self = null;

      self = new KeyValueList();
      self.theKvList = null;
      return (self);
    }
  }

  public static void javaTranslateWalkedSystemUnits(KeyValueList systemunits) {
    { Object old$Translationunits$000 = Stella.$TRANSLATIONUNITS$.get();

      try {
        Native.setSpecial(Stella.$TRANSLATIONUNITS$, KeyValueList.concatenateSystemUnits(systemunits));
        if (((Integer)(Stella.$TRANSLATIONVERBOSITYLEVEL$.get())).intValue() >= 1) {
          Stella.STANDARD_OUTPUT.nativeStream.println("Generating Java translations...");
        }
        Stella.javaOutputAllUnitsToFile();
        Stella.cleanUpTranslationUnitsSpecial();

      } finally {
        Stella.$TRANSLATIONUNITS$.set(old$Translationunits$000);
      }
    }
  }

  public static void cppTranslateWalkedSystemUnits(KeyValueList systemunits) {
    { Object old$Currentfile$000 = Stella.$CURRENTFILE$.get();
      Object old$Translationunits$000 = Stella.$TRANSLATIONUNITS$.get();

      try {
        Native.setSpecial(Stella.$CURRENTFILE$, null);
        Native.setSpecial(Stella.$TRANSLATIONUNITS$, null);
        { StringWrapper file = null;
          List units = null;
          KvCons iter000 = systemunits.theKvList;

          for (;iter000 != null; iter000 = iter000.rest) {
            file = ((StringWrapper)(iter000.key));
            units = ((List)(iter000.value));
            Native.setSpecial(Stella.$CURRENTFILE$, Stella.fileBaseName(file.wrapperValue));
            Native.setSpecial(Stella.$TRANSLATIONUNITS$, units);
            { Object old$Module$000 = Stella.$MODULE$.get();
              Object old$Context$000 = Stella.$CONTEXT$.get();

              try {
                Native.setSpecial(Stella.$MODULE$, List.computeFileUnitsModule(units));
                Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
                Stella.translateAndOutputUnitsToFile(file.wrapperValue, "C++");

              } finally {
                Stella.$CONTEXT$.set(old$Context$000);
                Stella.$MODULE$.set(old$Module$000);
              }
            }
            Stella.cleanUpTranslationUnitsSpecial();
          }
        }
        Stella.cppOutputSystemSpecificFiles();

      } finally {
        Stella.$TRANSLATIONUNITS$.set(old$Translationunits$000);
        Stella.$CURRENTFILE$.set(old$Currentfile$000);
      }
    }
  }

  /** Print all properties defined in <code>configuration</code> to <code>stream</code>.
   * @param configuration
   * @param stream
   */
  public static void printConfigurationProperties(KeyValueList configuration, OutputStream stream) {
    { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

      try {
        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
        { Cons entry = null;
          Cons iter000 = ((Cons)(configuration.consify().sortTuples(0, null)));

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            entry = ((Cons)(iter000.value));
            stream.nativeStream.print(StringWrapper.unwrapString(((StringWrapper)(entry.value))) + " = ");
            if (Stella_Object.stringP(entry.rest.value)) {
              stream.nativeStream.println(StringWrapper.unwrapString(((StringWrapper)(entry.rest.value))));
            }
            else {
              stream.nativeStream.println(entry.rest.value.toString());
            }
          }
        }

      } finally {
        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
      }
    }
  }

  /** Save <code>table</code> as a configuration file.  Uses a Java-style property file syntax.
   * @param table
   * @param file
   * @param title
   */
  public static void saveConfigurationFile(KeyValueList table, String file, String title) {
    { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

      try {
        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, false);
        { OutputFileStream out = null;

          try {
            out = Stella.openOutputFile(file, Stella.NIL);
            if (title != null) {
              out.nativeStream.println("# " + title);
            }
            { StringWrapper key = null;
              Stella_Object value = null;
              KvCons iter000 = table.theKvList;

              for (;iter000 != null; iter000 = iter000.rest) {
                key = ((StringWrapper)(iter000.key));
                value = iter000.value;
                if (Stella_Object.safePrimaryType(value) == Stella.SGT_STELLA_CONS) {
                  { Cons value000 = ((Cons)(value));

                    { Stella_Object v = null;
                      Cons iter001 = value000;

                      for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                        v = iter001.value;
                        out.nativeStream.print(StringWrapper.unwrapString(key) + " +=");
                        OutputStream.saveConfigurationValue(out, v);
                        out.nativeStream.println();
                      }
                    }
                  }
                }
                else {
                  out.nativeStream.print(StringWrapper.unwrapString(key) + " =");
                  OutputStream.saveConfigurationValue(out, value);
                  out.nativeStream.println();
                }
              }
            }

          } finally {
            if (out != null) {
              out.free();
            }
          }
        }

      } finally {
        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
      }
    }
  }

  public static List concatenateSystemUnits(KeyValueList systemunits) {
    { Cons head = Cons.cons(null, Stella.NIL);
      Cons cursor = head;

      { StringWrapper file = null;
        List units = null;
        KvCons iter000 = systemunits.theKvList;

        for (;iter000 != null; iter000 = iter000.rest) {
          file = ((StringWrapper)(iter000.key));
          units = ((List)(iter000.value));
          file = file;
          if (units.nonEmptyP()) {
            cursor.concatenate(units.theConsList, Stella.NIL);
            cursor = units.theConsList;
          }
        }
      }
      { List self000 = List.newList();

        self000.theConsList = head.rest;
        { List value000 = self000;

          return (value000);
        }
      }
    }
  }

  public static Stella_Object setDynamicSlotValue(KeyValueList dynamicslots, Symbol slotname, Stella_Object value, Wrapper nullwrapper) {
    { boolean deletevalueP = (value == nullwrapper) &&
          (!(nullwrapper == Stella.FALSE_WRAPPER));
      KvCons cursor = dynamicslots.theKvList;

      while (cursor != null) {
        if (cursor.key == slotname) {
          if (deletevalueP) {
            dynamicslots.removeAt(slotname);
          }
          else {
            cursor.value = value;
          }
          return (value);
        }
        cursor = cursor.rest;
      }
      if (!deletevalueP) {
        dynamicslots.theKvList = KvCons.kvCons(slotname, value, dynamicslots.theKvList);
      }
      return (value);
    }
  }

  public static Stella_Object dynamicSlotValue(KeyValueList dynamicslots, Symbol slotname, Stella_Object nullvalue) {
    { Stella_Object key = null;
      Stella_Object value = null;
      KvCons iter000 = dynamicslots.theKvList;

      for (;iter000 != null; iter000 = iter000.rest) {
        key = iter000.key;
        value = iter000.value;
        if (key == slotname) {
          if (value == null) {
            return (nullvalue);
          }
          else {
            return (value);
          }
        }
      }
    }
    return (nullvalue);
  }

  public static void clTranslateWalkedSystemUnits(KeyValueList systemunits) {
    { Object old$Currentfile$000 = Stella.$CURRENTFILE$.get();
      Object old$Translationunits$000 = Stella.$TRANSLATIONUNITS$.get();

      try {
        Native.setSpecial(Stella.$CURRENTFILE$, null);
        Native.setSpecial(Stella.$TRANSLATIONUNITS$, null);
        { List classunits = List.newList();
          boolean useclstructsP = ((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_STRUCTS);
          String filename = null;

          { StringWrapper file = null;
            List units = null;
            KvCons iter000 = systemunits.theKvList;

            for (;iter000 != null; iter000 = iter000.rest) {
              file = ((StringWrapper)(iter000.key));
              units = ((List)(iter000.value));
              Native.setSpecial(Stella.$CURRENTFILE$, Stella.fileBaseName(file.wrapperValue));
              if (useclstructsP) {
                Native.setSpecial(Stella.$TRANSLATIONUNITS$, List.newList());
                { TranslationUnit unit = null;
                  Cons iter001 = units.theConsList;

                  for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                    unit = ((TranslationUnit)(iter001.value));
                    if (unit.category == Stella.SYM_STELLA_CLASS) {
                      classunits.push(unit);
                    }
                    else {
                      ((List)(Stella.$TRANSLATIONUNITS$.get())).push(unit);
                    }
                  }
                }
                ((List)(Stella.$TRANSLATIONUNITS$.get())).reverse();
              }
              else {
                Native.setSpecial(Stella.$TRANSLATIONUNITS$, units);
              }
              { Object old$Module$000 = Stella.$MODULE$.get();
                Object old$Context$000 = Stella.$CONTEXT$.get();

                try {
                  Native.setSpecial(Stella.$MODULE$, List.computeFileUnitsModule(units));
                  Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
                  Stella.translateAndOutputUnitsToFile(file.wrapperValue, "Common Lisp");

                } finally {
                  Stella.$CONTEXT$.set(old$Context$000);
                  Stella.$MODULE$.set(old$Module$000);
                }
              }
              Stella.cleanUpTranslationUnitsSpecial();
            }
          }
          if (useclstructsP) {
            if (((Integer)(Stella.$TRANSLATIONVERBOSITYLEVEL$.get())).intValue() >= 1) {
              Stella.STANDARD_OUTPUT.nativeStream.println("Collecting CL structure class definitions...");
            }
            { StringWrapper file = null;
              Cons iter002 = Cons.filesPlusSystemStartup(SystemDefinition.systemDefinitionSourceFiles(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get()))));

              for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                file = ((StringWrapper)(iter002.value));
                if (((List)(systemunits.lookup(StringWrapper.wrapString(filename = Stella.makeFileName(file.wrapperValue, Stella.KWD_STELLA, true))))) == null) {
                  Native.setSpecial(Stella.$TRANSLATIONUNITS$, List.newList());
                  Native.setSpecial(Stella.$CURRENTFILE$, Stella.fileBaseName(filename));
                  Native.setSpecial(Stella.$TRANSLATIONUNITS$, List.newList());
                  Stella.operateOnFile(filename, Stella.KWD_FINALIZE);
                  { TranslationUnit unit = null;
                    Cons iter003 = ((List)(Stella.$TRANSLATIONUNITS$.get())).theConsList;
                    Cons collect000 = null;

                    for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
                      unit = ((TranslationUnit)(iter003.value));
                      if ((unit.category == Stella.SYM_STELLA_CLASS) &&
                          (Stella_Class.createNativeClassP(((Stella_Class)(unit.theObject))) &&
                           (!((Stella_Class)(unit.theObject)).mixinP))) {
                        if (collect000 == null) {
                          {
                            collect000 = Cons.cons(unit, Stella.NIL);
                            if (classunits.theConsList == Stella.NIL) {
                              classunits.theConsList = collect000;
                            }
                            else {
                              Cons.addConsToEndOfConsList(classunits.theConsList, collect000);
                            }
                          }
                        }
                        else {
                          {
                            collect000.rest = Cons.cons(unit, Stella.NIL);
                            collect000 = collect000.rest;
                          }
                        }
                      }
                    }
                  }
                  Stella.cleanUpTranslationUnitsSpecial();
                }
              }
            }
            List.clOutputSystemClStructsFile(classunits);
          }
        }

      } finally {
        Stella.$TRANSLATIONUNITS$.set(old$Translationunits$000);
        Stella.$CURRENTFILE$.set(old$Currentfile$000);
      }
    }
  }

  public static void insertAtVariableTable(KeyValueList self, Symbol variable, Stella_Object value) {
    { KvCons cursor = self.theKvList;

      while (cursor != null) {
        if (Symbol.variableEqlP(((Symbol)(cursor.key)), variable)) {
          cursor.value = value;
          return;
        }
        cursor = cursor.rest;
      }
      self.theKvList = KvCons.kvCons(variable, value, self.theKvList);
    }
  }

  public static Stella_Object lookupVariableTable(KeyValueList self, Symbol variable) {
    { Symbol key = null;
      Stella_Object value = null;
      KvCons iter000 = self.theKvList;

      for (;iter000 != null; iter000 = iter000.rest) {
        key = ((Symbol)(iter000.key));
        value = iter000.value;
        if (Symbol.variableEqlP(key, variable)) {
          return (value);
        }
      }
    }
    return (null);
  }

  /** Fill in <code>substitutionList</code> with date information for the current
   * date and time.  See <code>addDateSubstitution</code> for details.
   * @param substitutionList
   */
  public static void addCurrentDateSubstitution(KeyValueList substitutionList) {
    CalendarDate.addDateSubstitution(CalendarDate.makeCurrentDateTime(), substitutionList);
  }

  /** Fill in <code>substitutionList</code> with template variable substitions
   * for the names YEAR and DATE which correspond to the current year and date.
   * These substitutions can then be used with <code>substituteTemplateVariablesInString</code>
   * DEPRECATED.  Use <code>addDateSubsitution</code> or <code>addCurrentDateSubstitution</code> instead.
   * @param substitutionList
   */
  public static void fillInDateSubstitution(KeyValueList substitutionList) {
    { int year = Stella.NULL_INTEGER;
      int month = Stella.NULL_INTEGER;
      int day = Stella.NULL_INTEGER;
      Keyword dow = null;

      { Object [] caller_MV_returnarray = new Object[3];

        year = CalendarDate.makeCurrentDateTime().getCalendarDate(Stella.getLocalTimeZone(), caller_MV_returnarray);
        month = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
        day = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
        dow = ((Keyword)(caller_MV_returnarray[2]));
      }
      dow = dow;
      substitutionList.insertAt(StringWrapper.wrapString("YEAR"), StringWrapper.wrapString(Native.integerToString(((long)(year)))));
      substitutionList.insertAt(StringWrapper.wrapString("DATE"), StringWrapper.wrapString(Stella.formatWithPadding(Native.integerToString(((long)(day))), 2, '0', Stella.KWD_RIGHT, false) + "-" + ((StringWrapper)((Stella.$MONTH_ABBREVIATION_VECTOR$.theArray)[month])).wrapperValue + "-" + Native.integerToString(((long)(year)))));
    }
  }

  public static void printKeyValueList(KeyValueList self, edu.isi.stella.javalib.NativeOutputStream stream) {
    stream.print("|kv|(");
    { KvCons cursor = self.theKvList;
      int position = 1;

      loop000 : while (cursor != null) {
        if ((((Integer)(Stella.$PRINTLENGTH$.get())).intValue() != Stella.NULL_INTEGER) &&
            (position > ((Integer)(Stella.$PRINTLENGTH$.get())).intValue())) {
          stream.print(" ...");
          break loop000;
        }
        if (!(position == 1)) {
          stream.print(" ");
        }
        stream.print(cursor);
        cursor = cursor.rest;
        position = position + 1;
      }
      stream.print(")");
    }
  }

  /** Return a list of key-value pairs in <code>self</code>.
   * @return List
   */
  public List listify() {
    { KeyValueList self = this;

      { List result = List.newList();

        { Stella_Object k = null;
          Stella_Object v = null;
          KvCons iter000 = self.theKvList;
          Cons collect000 = null;

          for (;iter000 != null; iter000 = iter000.rest) {
            k = iter000.key;
            v = iter000.value;
            if (collect000 == null) {
              {
                collect000 = Cons.cons(Cons.cons(k, Cons.cons(v, Stella.NIL)), Stella.NIL);
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
                collect000.rest = Cons.cons(Cons.cons(k, Cons.cons(v, Stella.NIL)), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        return (result);
      }
    }
  }

  /** Convert <code>self</code> into a property list with identical and identically
   * ordered keys and values.
   * @param self
   * @return PropertyList
   */
  public static PropertyList kvlistToPlist(KeyValueList self) {
    { Cons plist = Stella.NIL;

      { Stella_Object key = null;
        Stella_Object value = null;
        KvCons iter000 = self.theKvList;

        for (;iter000 != null; iter000 = iter000.rest) {
          key = iter000.key;
          value = iter000.value;
          plist = Cons.cons(value, Cons.cons(key, plist));
        }
      }
      { PropertyList self000 = PropertyList.newPropertyList();

        self000.thePlist = plist.reverse();
        { PropertyList value000 = self000;

          return (value000);
        }
      }
    }
  }

  public AbstractIterator allocateIterator() {
    { KeyValueList self = this;

      { KvListIterator iterator = KvListIterator.newKvListIterator();

        iterator.theKvList = self;
        iterator.kvListIteratorCursor = self.theKvList;
        iterator.firstIterationP = true;
        return (iterator);
      }
    }
  }

  /** Return an <code>equalP</code> hash code for <code>self</code>.  Note that this
   * is O(N) in the number of entries of <code>self</code>.
   * @return int
   */
  public int equalHashCode() {
    { KeyValueList self = this;

      { int code = 94797224;

        { Stella_Object key = null;
          Stella_Object value = null;
          KvCons iter000 = self.theKvList;

          for (;iter000 != null; iter000 = iter000.rest) {
            key = iter000.key;
            value = iter000.value;
            code = (code ^ (Stella_Object.safeEqualHashCode(key)));
            code = (code ^ (Stella_Object.safeEqualHashCode(value)));
          }
        }
        return (code);
      }
    }
  }

  /** Return TRUE if <code>x</code> and <code>y</code> represent the same set of key/value pairs.
   * @param y
   * @return boolean
   */
  public boolean objectEqualP(Stella_Object y) {
    { KeyValueList x = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(y), Stella.SGT_STELLA_KEY_VALUE_LIST)) {
        { KeyValueList y000 = ((KeyValueList)(y));

          if (x.length() == y000.length()) {
            { Stella_Object key = null;
              Stella_Object value = null;
              KvCons iter000 = x.theKvList;

              for (;iter000 != null; iter000 = iter000.rest) {
                key = iter000.key;
                value = iter000.value;
                if (!Stella_Object.equalP(value, y000.lookup(key))) {
                  return (false);
                }
              }
            }
            return (true);
          }
        }
      }
      else {
      }
      return (false);
    }
  }

  /** Make <code>self</code> an empty dictionary.
   */
  public void clear() {
    { KeyValueList self = this;

      { KvCons next = self.theKvList;
        KvCons current = null;

        while (next != null) {
          current = next;
          next = next.rest;
          KvCons.freeKvCons(current);
        }
        self.theKvList = null;
      }
    }
  }

  /** Return a copy of the kv-list <code>self</code>.  The kv-conses in
   * the copy are freshly allocated.
   * @return KeyValueList
   */
  public KeyValueList copy() {
    { KeyValueList self = this;

      { KeyValueList copy = KeyValueList.newKeyValueList();

        copy.theKvList = KvCons.copyKvConsList(self.theKvList);
        return (copy);
      }
    }
  }

  public boolean nonEmptyP() {
    { KeyValueList self = this;

      return (self.theKvList != null);
    }
  }

  public boolean emptyP() {
    { KeyValueList self = this;

      return (self.theKvList == null);
    }
  }

  /** Destructively reverse the members of the list <code>self</code>.
   * @return KeyValueList
   */
  public KeyValueList reverse() {
    { KeyValueList self = this;

      { KvCons reversedlist = self.theKvList;
        KvCons remaininglist = null;
        KvCons temp = null;

        if (reversedlist == null) {
          return (self);
        }
        remaininglist = reversedlist.rest;
        if (remaininglist == null) {
          return (self);
        }
        reversedlist.rest = null;
        while (remaininglist != null) {
          temp = remaininglist;
          remaininglist = remaininglist.rest;
          temp.rest = reversedlist;
          reversedlist = temp;
        }
        self.theKvList = reversedlist;
        return (self);
      }
    }
  }

  /** Remove and return the value of the first element of the
   * kv-list <code>self</code>.  It does NOT return the KV-CONS object.  Return <code>null</code> if
   * the list is empty.
   * @return Stella_Object
   */
  public Stella_Object pop() {
    { KeyValueList self = this;

      if (self.emptyP()) {
        return (null);
      }
      { KvCons cons = self.theKvList;
        Stella_Object value = null;

        value = cons.value;
        self.theKvList = cons.rest;
        KvCons.freeKvCons(cons);
        return (value);
      }
    }
  }

  /** Add a new entry &lt;<code>key</code>, <code>value</code>&gt; to the front of the association
   * <code>self</code>. This might duplicate an existing entry. If a previous entry existed with key
   * <code>key</code>, that entry is retained, but shadowed by this new entry.
   * @param key
   * @param value
   */
  public void kvPush(Stella_Object key, Stella_Object value) {
    { KeyValueList self = this;

      self.theKvList = KvCons.kvCons(key, value, self.theKvList);
    }
  }

  /** Make <code>value</code> be the new first element of <code>self</code>.  Note that
   * the <code>rest</code> slot of <code>value</code> should be <code>null</code>, since it will be overwritten.
   * This might duplicate an existing entry. If a previous entry existed with the
   * same key as <code>value</code>, that entry is retained, but shadowed by this new entry.
   * @param value
   */
  public void push(KvCons value) {
    { KeyValueList self = this;

      if (!(value.rest == null)) {
        System.err.print("Safety violation: Push only supports single entry KV-CONSes");
      }
      value.rest = self.theKvList;
      self.theKvList = value;
    }
  }

  /** Remove the entry that matches &lt;<code>key</code>,<code>value</code>&gt;.
   * Assumes that more than one entry can match <code>key</code>.
   * @param key
   * @param value
   */
  public void removeEntry(Stella_Object key, Stella_Object value) {
    { KeyValueList self = this;

      { KvCons cursor = self.theKvList;
        KvCons previouscursor = null;

        if (cursor != null) {
          if (Stella_Object.eqlP(cursor.key, key) &&
              Stella_Object.eqlP(cursor.value, value)) {
            self.theKvList = cursor.rest;
            KvCons.freeKvCons(cursor);
            return;
          }
          while (cursor.rest != null) {
            previouscursor = cursor;
            cursor = cursor.rest;
            if (Stella_Object.eqlP(cursor.key, key) &&
                Stella_Object.eqlP(cursor.value, value)) {
              previouscursor.rest = cursor.rest;
              KvCons.freeKvCons(cursor);
              return;
            }
          }
        }
      }
    }
  }

  /** Insert an entry &lt;<code>key</code>,<code>value</code>&gt; to <code>self</code> unless an identical
   * entry already exists.  This can generate duplicate entries for <code>key</code>.
   * @param key
   * @param value
   */
  public void insertEntry(Stella_Object key, Stella_Object value) {
    { KeyValueList self = this;

      { boolean foundP000 = false;

        { Stella_Object k = null;
          Stella_Object v = null;
          KvCons iter000 = self.theKvList;

          loop000 : for (;iter000 != null; iter000 = iter000.rest) {
            k = iter000.key;
            v = iter000.value;
            if ((k == key) &&
                (v == value)) {
              foundP000 = true;
              break loop000;
            }
          }
        }
        if (!(foundP000)) {
          self.theKvList = KvCons.kvCons(key, value, self.theKvList);
        }
      }
    }
  }

  /** Remove the entry that matches the key <code>key</code>.
   * Return the value of the matching entry, or NULL if there is no matching entry.
   * Assumes that at most one entry matches <code>key</code>.
   * @param key
   * @return Stella_Object
   */
  public Stella_Object removeAt(Stella_Object key) {
    { KeyValueList self = this;

      { KvCons cursor = self.theKvList;
        KvCons previouscursor = null;
        Stella_Object value = null;

        if (cursor != null) {
          if (Stella_Object.eqlP(cursor.key, key)) {
            self.theKvList = cursor.rest;
            value = cursor.value;
            KvCons.freeKvCons(cursor);
            return (value);
          }
          while (cursor.rest != null) {
            previouscursor = cursor;
            cursor = cursor.rest;
            if (Stella_Object.eqlP(cursor.key, key)) {
              previouscursor.rest = cursor.rest;
              value = cursor.value;
              KvCons.freeKvCons(cursor);
              return (value);
            }
          }
        }
        return (null);
      }
    }
  }

  /** Insert the entry &lt;<code>key</code>, <code>value</code>&gt; into the association
   * <code>self</code>. If a previous entry existed with key <code>key</code>, that entry is replaced.
   * @param key
   * @param value
   */
  public void insertAt(Stella_Object key, Stella_Object value) {
    { KeyValueList self = this;

      { KvCons cursor = self.theKvList;

        while (cursor != null) {
          if (Stella_Object.eqlP(cursor.key, key)) {
            cursor.value = value;
            return;
          }
          cursor = cursor.rest;
        }
        self.theKvList = KvCons.kvCons(key, value, self.theKvList);
      }
    }
  }

  public int length() {
    { KeyValueList self = this;

      { int length = 0;
        KvCons cursor = self.theKvList;

        while (cursor != null) {
          length = length + 1;
          cursor = cursor.rest;
        }
        return (length);
      }
    }
  }

  /** Lookup <code>key</code> in <code>self</code> and return the result.
   * Return <code>renamed_Default</code> if no value was found.
   * @param key
   * @param renamed_Default
   * @return Stella_Object
   */
  public Stella_Object lookupWithDefault(Stella_Object key, Stella_Object renamed_Default) {
    { KeyValueList self = this;

      { KvCons cursor = self.theKvList;

        while (cursor != null) {
          if (Stella_Object.eqlP(cursor.key, key)) {
            return (cursor.value);
          }
          cursor = cursor.rest;
        }
        return (renamed_Default);
      }
    }
  }

  public Stella_Object lookup(Stella_Object key) {
    { KeyValueList self = this;

      { KvCons cursor = self.theKvList;

        while (cursor != null) {
          if (Stella_Object.eqlP(cursor.key, key)) {
            return (cursor.value);
          }
          cursor = cursor.rest;
        }
        return (null);
      }
    }
  }

  /** Return a list of key-value pairs in <code>self</code>.
   * @return Cons
   */
  public Cons consify() {
    { KeyValueList self = this;

      { Cons result = Stella.NIL;

        { Stella_Object k = null;
          Stella_Object v = null;
          KvCons iter000 = self.theKvList;
          Cons collect000 = null;

          for (;iter000 != null; iter000 = iter000.rest) {
            k = iter000.key;
            v = iter000.value;
            if (collect000 == null) {
              {
                collect000 = Cons.cons(Cons.cons(k, Cons.cons(v, Stella.NIL)), Stella.NIL);
                if (result == Stella.NIL) {
                  result = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(result, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(Cons.cons(k, Cons.cons(v, Stella.NIL)), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        return (result);
      }
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { KeyValueList self = this;

      KeyValueList.printKeyValueList(self, stream);
    }
  }

  public static Stella_Object accessKeyValueListSlotValue(KeyValueList self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_THE_KV_LIST) {
      if (setvalueP) {
        self.theKvList = ((KvCons)(value));
      }
      else {
        value = self.theKvList;
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
    { KeyValueList self = this;

      return (Stella.SGT_STELLA_KEY_VALUE_LIST);
    }
  }

}

