//  -*- Mode: Java -*-
//
// CmdLineOption.java

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

public class CmdLineOption extends StandardObject {
    public String documentation;
    public Cons keys;
    public Surrogate valueType;
    public boolean multiValuedP;
    /** The number of args expected by this option.
     * Common values are 0 or 1, but certain options might take more than one argument.
     */
    public int nArguments;
    /** The value to use for 0-arg options.
     * Defaults to TRUE for 0-arg options with boolean value type.
     */
    public Stella_Object defaultValue;
    public String configurationProperty;
    public java.lang.reflect.Method handler;
    /** One of :ignore, :warn, :error.
     */
    public Keyword errorAction;

  public static CmdLineOption newCmdLineOption() {
    { CmdLineOption self = null;

      self = new CmdLineOption();
      self.errorAction = Stella.KWD_ERROR;
      self.handler = Native.find_java_method("edu.isi.stella.CmdLineOption", "defaultCmdLineOptionHandler", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.CmdLineOption"), Native.find_java_class("edu.isi.stella.Stella_Object")});
      self.configurationProperty = null;
      self.defaultValue = null;
      self.nArguments = 0;
      self.multiValuedP = false;
      self.valueType = Stella.SGT_STELLA_STRING;
      self.keys = Stella.NIL;
      self.documentation = "Not documented.";
      return (self);
    }
  }

  /** Print documentation about all currently registered option handlers.
   * @param option
   * @param value
   */
  public static void helpOptionHandler(CmdLineOption option, Stella_Object value) {
    value = value;
    { Cons sortedoptions = Stella.NIL;

      { StringWrapper key = null;
        CmdLineOption option000 = null;
        DictionaryIterator iter000 = ((DictionaryIterator)(Stella.$REGISTERED_COMMAND_LINE_OPTIONS$.allocateIterator()));
        Cons collect000 = null;

        while (iter000.nextP()) {
          key = ((StringWrapper)(iter000.key));
          option000 = ((CmdLineOption)(iter000.value));
          if (Stella_Object.eqlP(key, ((StringWrapper)(option000.keys.value)))) {
            while (Stella.startsWithP(key.wrapperValue, "-", 0)) {
              key = StringWrapper.wrapString(Native.string_subsequence(StringWrapper.unwrapString(key), 1, Stella.NULL_INTEGER));
            }
            key = StringWrapper.wrapString(Native.stringDowncase(key.wrapperValue));
            if (collect000 == null) {
              {
                collect000 = Cons.cons(Cons.consList(Cons.cons(key, Cons.cons(option000, Stella.NIL))), Stella.NIL);
                if (sortedoptions == Stella.NIL) {
                  sortedoptions = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(sortedoptions, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(Cons.consList(Cons.cons(key, Cons.cons(option000, Stella.NIL))), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      sortedoptions = sortedoptions.removeDuplicates().sortTuples(0, null);
      if (!(Stella.blankStringP(Stella.$COMMAND_LINE_HELP_HEADER$))) {
        Stella.STANDARD_OUTPUT.nativeStream.println(Stella.$COMMAND_LINE_HELP_HEADER$);
      }
      Stella.STANDARD_OUTPUT.nativeStream.println("The following command line options are supported:");
      { Cons tuple = null;
        Cons iter001 = sortedoptions;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          tuple = ((Cons)(iter001.value));
          option = ((CmdLineOption)(tuple.rest.value));
          { StringWrapper key = null;
            Cons iter002 = option.keys;
            int i = Stella.NULL_INTEGER;
            int iter003 = 1;

            for (;!(iter002 == Stella.NIL); iter002 = iter002.rest, iter003 = iter003 + 1) {
              key = ((StringWrapper)(iter002.value));
              i = iter003;
              if (i > 1) {
                Stella.STANDARD_OUTPUT.nativeStream.print(", ");
              }
              Stella.STANDARD_OUTPUT.nativeStream.print(StringWrapper.unwrapString(key));
            }
          }
          Stella.STANDARD_OUTPUT.nativeStream.print(" ");
          Stella.STANDARD_OUTPUT.nativeStream.println(option.documentation);
        }
      }
      if (!(Stella.blankStringP(Stella.$COMMAND_LINE_HELP_TRAILER$))) {
        Stella.STANDARD_OUTPUT.nativeStream.println(Stella.$COMMAND_LINE_HELP_TRAILER$);
      }
      Stella.setConfigurationProperty("stella.showInfoOnly", Stella.TRUE_WRAPPER, null);
    }
  }

  public static void definePropertyOptionHandler(CmdLineOption option, Stella_Object value) {
    option = option;
    { StringWrapper prop = null;
      Wrapper val = null;
      Keyword op = null;

      { Object [] caller_MV_returnarray = new Object[2];

        prop = Stella.parseConfigurationFileLine(((StringWrapper)(value)).wrapperValue, caller_MV_returnarray);
        val = ((Wrapper)(caller_MV_returnarray[0]));
        op = ((Keyword)(caller_MV_returnarray[1]));
      }
      if (op == Stella.KWD_ADD) {
        Stella.addConfigurationProperty(prop.wrapperValue, val, null);
      }
      else {
        Stella.setConfigurationProperty(prop.wrapperValue, val, null);
      }
    }
  }

  /** Load the file <code>value</code> using the STELLA <code>loadFile</code> command.
   * @param option
   * @param value
   */
  public static void loadFileOptionHandler(CmdLineOption option, Stella_Object value) {
    option = option;
    Stella.loadFile(((StringWrapper)(value)).wrapperValue);
  }

  /** Load the configuration file <code>value</code>.  This will
   * modify currently set system properties defined in <code>value</code> with new
   * values but leave all other currently set properties as they are.
   * @param option
   * @param value
   */
  public static void configFileOptionHandler(CmdLineOption option, Stella_Object value) {
    option = option;
    { KeyValueList currentconfig = Stella.$SYSTEM_CONFIGURATION_TABLE$;

      try {
        Stella.$SYSTEM_CONFIGURATION_TABLE$ = currentconfig.copy();
        KeyValueList.loadConfigurationFile(((StringWrapper)(value)).wrapperValue);
      } catch (java.lang.Exception e000) {
        Stella.$SYSTEM_CONFIGURATION_TABLE$ = currentconfig;
      }
    }
  }

  /** Modify the current file load path according to <code>option</code> and <code>value</code>.
   * @param option
   * @param value
   */
  public static void loadPathOptionHandler(CmdLineOption option, Stella_Object value) {
    if (option.keys.memberP(StringWrapper.wrapString("--path="))) {
      Stella.setLoadPath(((StringWrapper)(value)).wrapperValue);
    }
    else if (option.keys.memberP(StringWrapper.wrapString("--path=+"))) {
      Stella.addLoadPath(((StringWrapper)(value)).wrapperValue);
    }
    else {
      Stella.pushLoadPath(((StringWrapper)(value)).wrapperValue);
    }
  }

  /** Interpret an --eval-in-module option.  <code>value</code> is expected
   * to be of the form <code>_LmoduleNameGLsExpressionG_</code>.
   * @param option
   * @param value
   */
  public static void evalInModuleOptionHandler(CmdLineOption option, Stella_Object value) {
    if (Stella_Object.safePrimaryType(value) == Stella.SGT_STELLA_CONS) {
      { Cons value000 = ((Cons)(value));

        { Object old$Module$000 = Stella.$MODULE$.get();
          Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Stella.$MODULE$, Stella_Object.coerceToModule(value000.value, true));
            Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
            CmdLineOption.evalOptionHandler(option, value000.rest.value);

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
            Stella.$MODULE$.set(old$Module$000);
          }
        }
      }
    }
    else {
    }
  }

  /** Interpret an --eval option by evaluating <code>value</code>.
   * @param option
   * @param value
   */
  public static void evalOptionHandler(CmdLineOption option, Stella_Object value) {
    option = option;
    Stella_Object.evaluate((Stella_Object.stringP(value) ? Stella.readSExpressionFromString(((StringWrapper)(value)).wrapperValue) : value));
  }

  /** Default handler that tries to set a system property based on <code>option</code> and <code>value</code>.
   * @param option
   * @param value
   */
  public static void defaultCmdLineOptionHandler(CmdLineOption option, Stella_Object value) {
    { String property = option.configurationProperty;
      Stella_Object defaultvalue = option.defaultValue;

      if (property == null) {
        property = "";
        { StringWrapper key = null;
          Cons iter000 = option.keys;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            key = ((StringWrapper)(iter000.value));
            if ((StringWrapper.unwrapString(key)).length() > property.length()) {
              property = key.wrapperValue;
            }
          }
        }
      }
      if ((defaultvalue == null) &&
          (option.valueType == Stella.SGT_STELLA_BOOLEAN)) {
        defaultvalue = Stella.TRUE_WRAPPER;
      }
      if (value == null) {
        value = defaultvalue;
      }
      if (option.multiValuedP) {
        if (Stella_Object.safePrimaryType(value) == Stella.SGT_STELLA_CONS) {
          { Cons value000 = ((Cons)(value));

            { Stella_Object val = null;
              Cons iter001 = value000;

              for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                val = iter001.value;
                Stella.addConfigurationProperty(property, val, null);
              }
            }
          }
        }
        else {
          Stella.addConfigurationProperty(property, value, null);
        }
      }
      else {
        Stella.setConfigurationProperty(property, value, null);
      }
    }
  }

  public static Stella_Object accessCmdLineOptionSlotValue(CmdLineOption self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_DOCUMENTATION) {
      if (setvalueP) {
        self.documentation = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.documentation);
      }
    }
    else if (slotname == Stella.SYM_STELLA_KEYS) {
      if (setvalueP) {
        self.keys = ((Cons)(value));
      }
      else {
        value = self.keys;
      }
    }
    else if (slotname == Stella.SYM_STELLA_VALUE_TYPE) {
      if (setvalueP) {
        self.valueType = ((Surrogate)(value));
      }
      else {
        value = self.valueType;
      }
    }
    else if (slotname == Stella.SYM_STELLA_MULTI_VALUEDp) {
      if (setvalueP) {
        self.multiValuedP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.multiValuedP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_N_ARGUMENTS) {
      if (setvalueP) {
        self.nArguments = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.nArguments);
      }
    }
    else if (slotname == Stella.SYM_STELLA_DEFAULT_VALUE) {
      if (setvalueP) {
        self.defaultValue = value;
      }
      else {
        value = self.defaultValue;
      }
    }
    else if (slotname == Stella.SYM_STELLA_CONFIGURATION_PROPERTY) {
      if (setvalueP) {
        self.configurationProperty = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.configurationProperty);
      }
    }
    else if (slotname == Stella.SYM_STELLA_HANDLER) {
      if (setvalueP) {
        self.handler = ((FunctionCodeWrapper)(value)).wrapperValue;
      }
      else {
        value = FunctionCodeWrapper.wrapFunctionCode(self.handler);
      }
    }
    else if (slotname == Stella.SYM_STELLA_ERROR_ACTION) {
      if (setvalueP) {
        self.errorAction = ((Keyword)(value));
      }
      else {
        value = self.errorAction;
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
    { CmdLineOption self = this;

      return (Stella.SGT_STELLA_CMD_LINE_OPTION);
    }
  }

}

