//  -*- Mode: Java -*-
//
// GlobalVariable.java

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

public class GlobalVariable extends MappableObject {
    public String documentation;
    public Symbol variableName;
    public Surrogate variableType;
    public boolean variableSpecialP;
    public boolean variableConstantP;
    public boolean variablePublicP;
    public boolean variableAuxiliaryP;
    public java.lang.reflect.Method variableGetValueCode;
    public java.lang.reflect.Method variableSetValueCode;
    public List variableValueStack;
    public String variableStringifiedSource;

  public static GlobalVariable newGlobalVariable() {
    { GlobalVariable self = null;

      self = new GlobalVariable();
      self.dynamicSlots = KeyValueList.newKeyValueList();
      self.variableStringifiedSource = null;
      self.documentation = null;
      self.variableValueStack = null;
      self.variableSetValueCode = null;
      self.variableGetValueCode = null;
      self.variableAuxiliaryP = false;
      self.variablePublicP = true;
      self.variableConstantP = false;
      self.variableSpecialP = false;
      self.variableType = null;
      self.variableName = null;
      return (self);
    }
  }

  public static MethodSlot lookupVariableDemonSetter(GlobalVariable demon) {
    { Symbol variablename = demon.variableName;
      String postfix = (demon.homeModule().caseSensitiveP ? "-setter" : "-SETTER");
      Symbol settername = Symbol.internDerivedSymbol(variablename, variablename.symbolName + postfix);

      return (Symbol.lookupFunction(settername));
    }
  }

  public static Cons clYieldGlobalVariableTypeDeclarationTree(GlobalVariable global) {
    { Stella_Object cltype = StandardObject.lookupClTypeFromStellaType(GlobalVariable.globalVariableTypeSpec(global));

      if (cltype != null) {
        return (((Cons)(Stella_Object.clConditionalizeTypeDeclarationTree(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("TYPE"), Cons.cons(cltype, Cons.cons(Cons.cons(Symbol.clTranslateGlobalSymbol(global.variableName), Stella.NIL), Stella.NIL))))))));
      }
      else {
        return (null);
      }
    }
  }

  public static void destroyVariable(GlobalVariable variable) {
    { Symbol variablename = variable.variableName;
      GlobalVariable realvariable = variablename.lookupGlobalVariable();

      if (variable == realvariable) {
        Stella.$GLOBAL_VARIABLE_LOOKUP_TABLE$.removeAt(variablename);
      }
      variable.deletedPSetter(true);
      variable.free();
    }
  }

  public static Module recordVariableHomeModule(GlobalVariable self) {
    { Symbol name = self.variableName;
      Module namemodule = ((Module)(name.homeContext));
      Module definitionmodule = ((Module)(Stella.$MODULE$.get()));
      Module homemodule = namemodule;

      if (GeneralizedSymbol.explicitlyQualifiedNameP(name, definitionmodule)) {
        homemodule = namemodule;
      }
      else {
        homemodule = definitionmodule;
      }
      if (!(homemodule == namemodule)) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_VARIABLE_HOME_MODULE, homemodule, null);
      }
      return (homemodule);
    }
  }

  /** Return the type spec for the global variable <code>global</code>.
   * @param global
   * @return StandardObject
   */
  public static StandardObject globalVariableTypeSpec(GlobalVariable global) {
    { StandardObject type = ((StandardObject)(KeyValueList.dynamicSlotValue(global.dynamicSlots, Stella.SYM_STELLA_VARIABLE_TYPE_SPECIFIER, null)));

      if (type != null) {
        return (type);
      }
      else {
        return (global.variableType);
      }
    }
  }

  public static GlobalVariable internGlobalVariable(GlobalVariable global) {
    { Symbol name = global.variableName;
      GlobalVariable oldglobal = name.lookupGlobalVariable();

      if (oldglobal != null) {
        if (Stella.stringEqlP(global.variableStringifiedSource, oldglobal.variableStringifiedSource)) {
          global.free();
          return (oldglobal);
        }
        else {
          Stella.STANDARD_OUTPUT.nativeStream.println("Redefining the global variable `" + global.variableName + "'");
          oldglobal.free();
        }
      }
      Stella.$GLOBAL_VARIABLE_LOOKUP_TABLE$.insertAt(name, global);
      return (global);
    }
  }

  public static Stella_Object accessGlobalVariableSlotValue(GlobalVariable self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_DOCUMENTATION) {
      if (setvalueP) {
        self.documentation = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.documentation);
      }
    }
    else if (slotname == Stella.SYM_STELLA_VARIABLE_NAME) {
      if (setvalueP) {
        self.variableName = ((Symbol)(value));
      }
      else {
        value = self.variableName;
      }
    }
    else if (slotname == Stella.SYM_STELLA_VARIABLE_TYPE) {
      if (setvalueP) {
        self.variableType = ((Surrogate)(value));
      }
      else {
        value = self.variableType;
      }
    }
    else if (slotname == Stella.SYM_STELLA_VARIABLE_SPECIALp) {
      if (setvalueP) {
        self.variableSpecialP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.variableSpecialP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_VARIABLE_CONSTANTp) {
      if (setvalueP) {
        self.variableConstantP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.variableConstantP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_VARIABLE_PUBLICp) {
      if (setvalueP) {
        self.variablePublicP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.variablePublicP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_VARIABLE_AUXILIARYp) {
      if (setvalueP) {
        self.variableAuxiliaryP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.variableAuxiliaryP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_VARIABLE_GET_VALUE_CODE) {
      if (setvalueP) {
        self.variableGetValueCode = ((FunctionCodeWrapper)(value)).wrapperValue;
      }
      else {
        value = FunctionCodeWrapper.wrapFunctionCode(self.variableGetValueCode);
      }
    }
    else if (slotname == Stella.SYM_STELLA_VARIABLE_SET_VALUE_CODE) {
      if (setvalueP) {
        self.variableSetValueCode = ((FunctionCodeWrapper)(value)).wrapperValue;
      }
      else {
        value = FunctionCodeWrapper.wrapFunctionCode(self.variableSetValueCode);
      }
    }
    else if (slotname == Stella.SYM_STELLA_VARIABLE_VALUE_STACK) {
      if (setvalueP) {
        self.variableValueStack = ((List)(value));
      }
      else {
        value = self.variableValueStack;
      }
    }
    else if (slotname == Stella.SYM_STELLA_VARIABLE_DOCUMENTATION) {
      if (setvalueP) {
        self.documentation = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.documentation);
      }
    }
    else if (slotname == Stella.SYM_STELLA_VARIABLE_STRINGIFIED_SOURCE) {
      if (setvalueP) {
        self.variableStringifiedSource = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.variableStringifiedSource);
      }
    }
    else {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, slotname, value, null);
      }
      else {
        value = self.dynamicSlots.lookup(slotname);
      }
    }
    return (value);
  }

  public Module homeModule() {
    { GlobalVariable self = this;

      { Module module = ((Module)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_VARIABLE_HOME_MODULE, null)));

        if (module != null) {
          return (module);
        }
        else {
          return (((Module)(self.variableName.homeContext)));
        }
      }
    }
  }

  public Surrogate type() {
    { GlobalVariable self = this;

      return (self.variableType);
    }
  }

  public String name() {
    { GlobalVariable self = this;

      return (self.variableName.symbolName);
    }
  }

  public Surrogate primaryType() {
    { GlobalVariable self = this;

      return (Stella.SGT_STELLA_GLOBAL_VARIABLE);
    }
  }

}

