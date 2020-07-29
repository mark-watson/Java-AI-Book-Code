//  -*- Mode: Java -*-
//
// Symbol.java

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

public class Symbol extends GeneralizedSymbol {
    public int symbolSlotOffset;
    public Cons symbolValueAndPlist;

  /** Return a newly-created or existing symbol with name
   * <code>newname</code> which is interned in the same module as <code>basesymbol</code>.
   * @param basesymbol
   * @param newname
   * @return Symbol
   */
  public static Symbol internDerivedSymbol(GeneralizedSymbol basesymbol, String newname) {
    { Module currentmodule = ((Module)(Stella.$MODULE$.get()));

      { Object old$Module$000 = Stella.$MODULE$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, ((Module)(basesymbol.homeContext)));
          if (((Module)(Stella.$MODULE$.get())) != null) {
            return (((Symbol)(GeneralizedSymbol.internRigidSymbolLocally(newname, ((Module)(Stella.$MODULE$.get())), Stella.SYMBOL_SYM))));
          }
          Native.setSpecial(Stella.$MODULE$, currentmodule);
          return (((Symbol)(GeneralizedSymbol.internRigidSymbolCaseSensitively(newname, Stella.SYMBOL_SYM, false))));

        } finally {
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Look for a symbol named <code>name</code> in <code>module</code> (if <code>localP</code> do
   * not consider inherited modules).  If none exists, intern it locally in
   * <code>module</code>.  Return the existing or newly-created symbol.
   * @param name
   * @param module
   * @param localP
   * @return Symbol
   */
  public static Symbol internSymbolInModule(String name, Module module, boolean localP) {
    if (module == null) {
      module = ((Module)(Stella.$MODULE$.get()));
    }
    if (localP) {
      return (((Symbol)(GeneralizedSymbol.internRigidSymbolLocally(name, module, Stella.SYMBOL_SYM))));
    }
    else {
      return (((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule(name, module, Stella.SYMBOL_SYM))));
    }
  }

  /** Return a newly-created or existing symbol with name <code>name</code>.
   * @param name
   * @return Symbol
   */
  public static Symbol internSymbol(String name) {
    if (((Module)(Stella.$MODULE$.get())).caseSensitiveP) {
      return (((Symbol)(GeneralizedSymbol.internRigidSymbolCaseSensitively(name, Stella.SYMBOL_SYM, false))));
    }
    else {
      if (((Boolean)(Stella.$TRANSIENTOBJECTSp$.get())).booleanValue()) {
        return (Stella.internTransientSymbol(Native.stringUpcase(name)));
      }
      else {
        return (Symbol.internPermanentSymbol(Native.stringUpcase(name)));
      }
    }
  }

  /** Return a newly-created or existing permanent symbol with
   * name <code>name</code>.
   * @param name
   * @return Symbol
   */
  public static Symbol internPermanentSymbol(String name) {
    return (((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule(name, ((Module)(Stella.$MODULE$.get())), Stella.SYMBOL_SYM))));
  }

  /** Return the first symbol with <code>name</code> visible from <code>module</code>.
   * If <code>localP</code> only consider symbols directly interned in <code>module</code>.
   * If <code>module</code> is <code>null</code>, use <code>$MODULE$</code> instead.
   * @param name
   * @param module
   * @param localP
   * @return Symbol
   */
  public static Symbol lookupSymbolInModule(String name, Module module, boolean localP) {
    if (module == null) {
      module = ((Module)(Stella.$MODULE$.get()));
    }
    if (localP) {
      return (((Symbol)(GeneralizedSymbol.lookupRigidSymbolLocally(name, module, Stella.SYMBOL_SYM))));
    }
    else {
      return (((Symbol)(Stella.lookupRigidSymbolWrtModule(name, module, Stella.SYMBOL_SYM))));
    }
  }

  /** Return the first symbol with <code>name</code> visible from the current module.
   * @param name
   * @return Symbol
   */
  public static Symbol lookupSymbol(String name) {
    return (((Symbol)(Stella.lookupRigidSymbolWrtModule(name, ((Module)(Stella.$MODULE$.get())), Stella.SYMBOL_SYM))));
  }

  public static Symbol getSymFromOffset(int offset) {
    return (((Symbol)(GeneralizedSymbol.getGeneralizedSymbolFromOffset(Stella.$SYMBOL_ARRAY$, offset))));
  }

  public static Symbol getSym(int offset) {
    return (((Symbol)((Stella.$FIXED_SYMBOL_ARRAY$.theArray)[offset])));
  }

  public static Symbol newSymbol(String symbolName) {
    { Symbol self = null;

      self = new Symbol();
      self.symbolName = symbolName;
      self.homeContext = ((Context)(Stella.$CONTEXT$.get()));
      self.symbolId = Stella.NULL_INTEGER;
      self.symbolValueAndPlist = Stella.NIL;
      self.symbolSlotOffset = Stella.NULL_INTEGER;
      return (self);
    }
  }

  public void idlOutputLiteral() {
    { Symbol symbol = this;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(Symbol.idlTranslateSymbolName(symbol).wrapperValue);
    }
  }

  public static Stella_Object idlTranslateMethodParameter(Symbol name, StandardObject type, Symbol direction) {
    return (Cons.cons(Symbol.idlTranslateName(direction), Cons.cons(StandardObject.idlTranslateTypeSpec(type), Cons.cons(Symbol.idlTranslateName(name), Stella.NIL))));
  }

  public static Symbol idlCreateOverloadedFunctionName(Symbol functionname, Surrogate classtype) {
    return (Symbol.internSymbol(classtype.symbolName + "-" + functionname.symbolName));
  }

  public static StringWrapper idlTranslateClassParameterName(Symbol namesymbol) {
    return (StringWrapper.wrapString(Stella.idlSubstituteForbiddenCharacters(GeneralizedSymbol.idlChangeCase(namesymbol, Stella.KWD_UPPERCASE), Stella.KWD_UPPERCASE)));
  }

  public static StringWrapper idlTranslateSymbolId(Symbol symbol) {
    return (GeneralizedSymbol.idlTranslateSymbolConstantId(symbol));
  }

  public static StringWrapper idlTranslateSymbolName(Symbol symbol) {
    return (GeneralizedSymbol.idlTranslateSymbolConstantName(symbol));
  }

  public static StringWrapper idlTranslateName(Symbol namesymbol) {
    { StringWrapper reservedname = Symbol.idlLookupReservedWordTable(namesymbol);

      if (namesymbol == null) {
        return (StringWrapper.wrapString("NULL"));
      }
      if (reservedname != null) {
        return (reservedname);
      }
      return (StringWrapper.wrapString(Stella.idlSubstituteForbiddenCharacters(GeneralizedSymbol.idlChangeCase(namesymbol, Stella.KWD_LOWERCASE), Stella.KWD_LOWERCASE)));
    }
  }

  public static StringWrapper idlLookupReservedWordTable(Symbol word) {
    { StringWrapper entry = ((StringWrapper)(Stella.$IDL_RESERVED_WORD_TABLE$.lookup(word.symbolName)));

      if (entry != null) {
        return (StringWrapper.wrapString(entry.wrapperValue));
      }
      else {
        return (null);
      }
    }
  }

  public static StringWrapper idlYieldRenamedReservedWord(Symbol word) {
    return (StringWrapper.wrapString("renamed_" + Native.stringCapitalize(word.symbolName)));
  }

  public Cons idlTranslateAtomicTree() {
    { Symbol tree = this;

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_IDL_IDENT, Cons.cons(Symbol.idlTranslateName(tree), Cons.cons(Stella.NIL, Stella.NIL)))));
    }
  }

  public void javaOutputLiteral() {
    { Symbol symbol = this;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(Symbol.javaTranslateSymbolName(symbol).wrapperValue);
    }
  }

  public static Cons javaTranslateNthMethodCall(Symbol operator, Surrogate owner, Cons arguments) {
    { boolean setterP = operator == Stella.SYM_STELLA_NTH_SETTER;
      Stella_Object collection = arguments.value;
      Stella_Object position = arguments.last();
      Stella_Object value = (setterP ? arguments.rest.value : ((Stella_Object)(null)));
      Cons tree = null;

      if (owner == Stella.SGT_STELLA_NATIVE_VECTOR) {
        tree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_AREF, Cons.cons(Stella_Object.javaTranslateATree(collection), Cons.cons(Cons.cons(Stella_Object.javaTranslateATree(position), Stella.NIL), Stella.NIL))));
        if (setterP) {
          tree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_ASSIGN, Cons.cons(tree, Cons.cons(Cons.cons(Stella_Object.javaTranslateATree(value), Stella.NIL), Stella.NIL))));
        }
        return (tree);
      }
      else {
      }
      return (Symbol.javaTranslateNormalMethodCall(operator, owner, arguments));
    }
  }

  public static Cons javaTranslateArefMethodCall(Symbol operator, Surrogate owner, Cons arguments) {
    if (owner == Stella.SGT_STELLA_ARRAY) {
      { boolean setterP = operator == Stella.SYM_STELLA_AREF_SETTER;
        Cons otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_AREF, Cons.cons(Stella_Object.javaTranslateATree(arguments.value), Cons.cons(Cons.javaTranslateListOfTrees((setterP ? arguments.rest.rest : arguments.rest)).concatenate(Stella.NIL, Stella.NIL), Stella.NIL))));

        if (setterP) {
          otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_ASSIGN, Cons.cons(otree, Cons.cons(Cons.cons(Stella_Object.javaTranslateATree(arguments.rest.value), Stella.NIL), Stella.NIL))));
        }
        return (otree);
      }
    }
    else {
      return (Symbol.javaTranslateNormalMethodCall(operator, owner, arguments));
    }
  }

  public static Cons javaTranslateNormalMethodCall(Symbol methodname, Surrogate classtype, Cons allargs) {
    { Slot slot = Stella_Class.lookupSlot(((Stella_Class)(classtype.surrogateValue)), methodname);
      MethodSlot methodslot = (((slot != null) &&
          Stella_Object.isaP(slot, Stella.SGT_STELLA_METHOD_SLOT)) ? ((MethodSlot)(slot)) : null);
      Stella_Object renamed_Object = allargs.value;
      Cons operator = Symbol.javaLookupOperatorTable(methodname.softPermanentify());

      if ((methodslot != null) &&
          MethodSlot.javaMethodObjectIsOverloadedFunctionP(methodslot)) {
        return (Cons.javaTranslateFunctionCall(Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_CALL_FUNCTION, Cons.cons(Symbol.javaCreateOverloadedFunctionName(methodname, classtype), Cons.cons(allargs.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), methodslot));
      }
      if (operator != null) {
        return (Cons.javaTranslateOperatorCall(operator, allargs, allargs.length()));
      }
      else {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_METHOD_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(GeneralizedSymbol.javaTranslateClassName(Symbol.internSymbolInModule(classtype.symbolName, ((Module)(classtype.homeContext)), false)), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(((methodslot != null) ? methodslot.javaTranslateMethodName() : Symbol.javaTranslateName(methodname)), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella_Object.javaTranslateATree(renamed_Object), Cons.cons(Cons.cons((((methodslot != null) &&
            ((!(methodslot.methodReturnTypeSpecifiers().rest() == Stella.NIL)) &&
             (allargs.length() <= methodslot.methodParameterNames().length()))) ? Cons.javaTranslateActualParameters(allargs.rest).concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_MAKE_ARRAY, Cons.cons(StandardObject.javaTranslateTypeSpec(Stella.SGT_STELLA_NATIVE_OBJECT_POINTER), Cons.cons(Cons.cons(IntegerWrapper.wrapInteger(methodslot.methodReturnTypeSpecifiers().length() - 1), Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL) : Cons.javaTranslateActualParameters(allargs.rest)), Stella.NIL), Stella.NIL)))))));
      }
    }
  }

  public static StringWrapper javaTranslateVariableLengthArgName(Symbol namesymbol, int parameternumber) {
    { Symbol returnsymbol = Symbol.internSymbol(namesymbol.symbolName + Native.integerToString(((long)(parameternumber))));
      StringWrapper translatedname = Symbol.javaTranslateName(returnsymbol);

      return (translatedname);
    }
  }

  public static Symbol javaCreateOverloadedFunctionName(Symbol functionname, Surrogate classtype) {
    return (Symbol.internSymbolInModule(classtype.symbolName + "_" + functionname.symbolName, Symbol.overloadedFunctionNameModule(functionname, classtype), true));
  }

  public static Stella_Object javaTranslateMethodParameter(Symbol name, StandardObject type, MethodSlot method) {
    type = StandardObject.computeRelativeTypeSpec(type, method.slotOwner);
    if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_METHOD_VARIABLE_ARGUMENTSp, Stella.FALSE_WRAPPER))).wrapperValue &&
        ((MethodSlot.variableArgumentsName(method) == name) &&
         (MethodSlot.passVariableArgumentsAsListP(method) ||
          MethodSlot.stringConcatenateMethodP(method)))) {
      type = MethodSlot.yieldListifiedVariableArgumentsType(method);
    }
    return (Cons.cons(StandardObject.javaTranslateTypeSpec(type), Cons.cons(Symbol.javaTranslateName(name), Stella.NIL)));
  }

  public Cons javaTranslateAtomicTree() {
    { Symbol tree = this;

      if (tree == Stella.SYM_STELLA_NULL) {
        return (Stella.javaTranslateNull());
      }
      else if (tree == Stella.SYM_STELLA_EOL) {
        return (Stella.javaTranslateEol());
      }
      else {
        return (Symbol.javaTranslateGeneralSymbol(tree));
      }
    }
  }

  public static Cons javaTranslateGeneralSymbol(Symbol tree) {
    { GlobalVariable globalvar = tree.softPermanentify().lookupGlobalVariable();

      if (globalvar == null) {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(Symbol.javaTranslateName(tree), Cons.cons(Stella.NIL, Stella.NIL)))));
      }
      else if (globalvar.variableSpecialP) {
        return (Cons.javaTranslateObjectToReturnType(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_METHOD_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString(""), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString("get"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(Symbol.javaTranslateGlobalName(tree, false), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_ACTUALS, Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL))))))), GlobalVariable.globalVariableTypeSpec(globalvar)));
      }
      else {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(Symbol.javaTranslateGlobalName(tree, false), Cons.cons(Stella.NIL, Stella.NIL)))));
      }
    }
  }

  public static StringWrapper javaTranslateGlobalName(Symbol namesymbol, boolean definitionP) {
    if (namesymbol == null) {
      return (StringWrapper.wrapString("NULL"));
    }
    if (!(definitionP)) {
      if (namesymbol == Stella.SYM_STELLA_TRUE) {
        return (Stella.$JAVA_TRUE_STRING_WRAPPER$);
      }
      if (namesymbol == Stella.SYM_STELLA_FALSE) {
        return (Stella.$JAVA_FALSE_STRING_WRAPPER$);
      }
    }
    { String rawname = Stella.javaSubstituteForbiddenCharacters(GeneralizedSymbol.javaChangeCase(namesymbol, Stella.KWD_UPPERCASE), Stella.KWD_UPPERCASE);
      Module module = namesymbol.homeModule();

      if (definitionP) {
        return (StringWrapper.wrapString(rawname));
      }
      else if (Module.omitJavaPackagePrefixP(module, Stella.javaYieldFlotsamTypeName(Module.javaYieldFlotsamClassName(module)))) {
        return (StringWrapper.wrapString(Stella.javaPrependGlobalClassName(rawname, module)));
      }
      else {
        return (StringWrapper.wrapString(Module.javaPackagePrefix(module, ".") + Stella.javaPrependGlobalClassName(rawname, module)));
      }
    }
  }

  public static StringWrapper javaTranslateName(Symbol namesymbol) {
    return (StringWrapper.wrapString(Stella.javaTranslateNamestring(GeneralizedSymbol.javaChangeCase(namesymbol, Stella.KWD_LOWERCASE))));
  }

  public static StringWrapper javaYieldRenamedReservedWord(Symbol word) {
    return (StringWrapper.wrapString("renamed_" + Native.stringCapitalize(word.symbolName)));
  }

  public static StringWrapper javaTranslateSymbolId(Symbol symbol) {
    return (GeneralizedSymbol.javaTranslateSymbolConstantId(symbol));
  }

  public static StringWrapper javaTranslateSymbolName(Symbol symbol) {
    return (GeneralizedSymbol.javaTranslateSymbolConstantName(symbol));
  }

  public static Cons javaLookupOperatorTable(Symbol operator) {
    { Cons entry = ((Cons)(Stella.$JAVA_OPERATOR_TABLE$.lookup(operator)));
      Cons copiedentry = Stella.NIL;

      if (entry != null) {
        { StringWrapper wrapper = null;
          Cons iter000 = entry;
          Cons collect000 = null;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            wrapper = ((StringWrapper)(iter000.value));
            if (collect000 == null) {
              {
                collect000 = Cons.cons(StringWrapper.wrapString(wrapper.wrapperValue), Stella.NIL);
                if (copiedentry == Stella.NIL) {
                  copiedentry = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(copiedentry, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(StringWrapper.wrapString(wrapper.wrapperValue), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        return (copiedentry);
      }
      return (null);
    }
  }

  public void cppOutputLiteral() {
    { Symbol symbol = this;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(Symbol.cppTranslateSymbolName(symbol).wrapperValue);
    }
  }

  public static Cons cppTranslateHardcodedSymbolReference(Symbol operator, int offset) {
    { GeneralizedSymbol symbol = null;

      if (operator == Stella.SYM_STELLA_GET_SYM) {
        symbol = Symbol.getSymFromOffset(offset);
      }
      else if (operator == Stella.SYM_STELLA_GET_KWD) {
        symbol = Keyword.getKwdFromOffset(offset);
      }
      else if (operator == Stella.SYM_STELLA_GET_SGT) {
        symbol = Surrogate.getSgtFromOffset(offset);
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + operator + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_SYMBOL, Cons.cons(symbol, Cons.cons(Stella.NIL, Stella.NIL)))));
    }
  }

  public static Cons cppTranslateArefMethodCall(Symbol operator, Surrogate owner, Cons arguments) {
    if (owner == Stella.SGT_STELLA_ARRAY) {
      { boolean setterP = operator == Stella.SYM_STELLA_AREF_SETTER;
        Cons otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ARRAY_REFERENCE, Cons.cons(Stella_Object.cppTranslateATree(arguments.value), Cons.cons(Cons.cppTranslateListOfTrees((setterP ? arguments.rest.rest : arguments.rest)).concatenate(Stella.NIL, Stella.NIL), Stella.NIL))));

        if (setterP) {
          otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ASSIGN, Cons.cons(otree, Cons.cons(Cons.cons(Stella_Object.cppTranslateATree(arguments.rest.value), Stella.NIL), Stella.NIL))));
        }
        return (otree);
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + owner + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static Cons cppTranslateNthMethodCall(Symbol operator, Surrogate owner, Cons arguments) {
    { boolean setterP = operator == Stella.SYM_STELLA_NTH_SETTER;
      Stella_Object collection = arguments.value;
      Stella_Object position = arguments.last();
      Stella_Object value = (setterP ? arguments.rest.value : ((Stella_Object)(null)));
      Cons tree = null;

      if ((owner == Stella.SGT_STELLA_STRING) ||
          ((owner == Stella.SGT_STELLA_MUTABLE_STRING) ||
           (owner == Stella.SGT_STELLA_NATIVE_VECTOR))) {
        if ((owner == Stella.SGT_STELLA_NATIVE_VECTOR) ||
            Stella.methodCallInliningEnabledP()) {
          collection = Stella_Object.cppTranslateATree(collection);
          tree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ARRAY_REFERENCE, Cons.cons(collection, Cons.cons(Cons.cons(Stella_Object.cppTranslateATree(position), Stella.NIL), Stella.NIL))));
          if (setterP) {
            tree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ASSIGN, Cons.cons(tree, Cons.cons(Cons.cons(Stella_Object.cppTranslateATree(value), Stella.NIL), Stella.NIL))));
          }
          return (tree);
        }
      }
      else {
      }
      return (Symbol.cppTranslateNormalMethodCall(operator, owner, arguments, false));
    }
  }

  public static Cons cppTranslateNormalMethodCall(Symbol methodname, Surrogate owner, Cons arguments, boolean referencedP) {
    { Slot slot = Stella_Class.lookupSlot(((Stella_Class)(owner.surrogateValue)), methodname);
      MethodSlot method = (Stella_Object.methodSlotP(slot) ? ((MethodSlot)(slot)) : null);
      Stella_Object firstarg = arguments.value;
      Cons otherargs = arguments.rest;

      { Cons operator = Symbol.cppLookupOperatorTable(methodname.softPermanentify());

        if (operator != null) {
          return (Cons.cppTranslateOperatorCall(operator, arguments, arguments.length()));
        }
      }
      if ((method != null) &&
          MethodSlot.cppMethodObjectIsOverloadedFunctionP(method)) {
        return (Cons.cppTranslateFunctionCall(Cons.cons(Symbol.cppCreateOverloadedFunctionName(methodname, owner), arguments.concatenate(Stella.NIL, Stella.NIL)), method));
      }
      { StringWrapper translatedname = Symbol.cppTranslateName(Symbol.yieldRenamedNameIfNative(methodname, Stella.KWD_CPP, Stella.KWD_FUNCTION));

        if ((method == null) &&
            Symbol.slotReaderFromNameP(methodname, owner)) {
          translatedname.wrapperValue = translatedname.wrapperValue + "_reader";
        }
        otherargs = otherargs.concatenate(MethodSlot.cppYieldUnusedDummyArgs(method, arguments), Stella.NIL);
        return (Cons.cons((referencedP ? Stella.SYM_STELLA_CPP_REFERENCED_METHOD_CALL : Stella.SYM_STELLA_CPP_METHOD_CALL), Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(GeneralizedSymbol.cppTranslateClassName(Symbol.internSymbolInModule(owner.symbolName, ((Module)(owner.homeContext)), false)), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(translatedname, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella_Object.cppTranslateATree(firstarg), Cons.cons(Cons.cons((((method != null) &&
            (((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_METHOD_VARIABLE_ARGUMENTSp, Stella.FALSE_WRAPPER))).wrapperValue &&
             (!MethodSlot.passVariableArgumentsAsListP(method)))) ? Cons.cppTranslateVariableLengthActuals(otherargs, method) : Cons.cppTranslateActualParameters(otherargs)), Stella.NIL), Stella.NIL)))))));
      }
    }
  }

  public static Symbol cppCreateOverloadedFunctionName(Symbol functionname, Surrogate classtype) {
    return (Symbol.internSymbolInModule(classtype.symbolName + "-" + functionname.symbolName, Symbol.overloadedFunctionNameModule(functionname, classtype), true));
  }

  public static StringWrapper cppTranslateMethodNameFromName(Symbol methodname, StandardObject methodowner) {
    { String translatedname = Symbol.cppTranslateName(Symbol.yieldRenamedNameIfNative(methodname, Stella.KWD_CPP, Stella.KWD_FUNCTION)).wrapperValue;

      if (Symbol.slotReaderFromNameP(methodname, methodowner)) {
        translatedname = translatedname + "_reader";
      }
      return (StringWrapper.wrapString(GeneralizedSymbol.cppTranslateClassName(((GeneralizedSymbol)(methodowner))).wrapperValue + "::" + translatedname));
    }
  }

  public static StringWrapper cppTranslateFunctionNameFromName(Symbol functionname) {
    { MethodSlot function = Symbol.lookupFunction(functionname);

      if (function != null) {
        return (MethodSlot.cppTranslateFunctionName(function, true));
      }
      else {
        return (Symbol.cppTranslateName(functionname));
      }
    }
  }

  public static boolean slotReaderFromNameP(Symbol methodname, StandardObject methodowner) {
    { Stella_Class ownerclass = ((Stella_Class)(((Surrogate)(methodowner)).surrogateValue));
      Slot slot = Stella_Class.lookupSlot(ownerclass, methodname);

      return ((slot != null) &&
          Stella_Object.isaP(slot, Stella.SGT_STELLA_STORAGE_SLOT));
    }
  }

  public static Stella_Object cppTranslateFunctionParameter(Symbol name, StandardObject type, MethodSlot method) {
    type = StandardObject.computeRelativeTypeSpec(type, method.slotOwner);
    if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_METHOD_VARIABLE_ARGUMENTSp, Stella.FALSE_WRAPPER))).wrapperValue &&
        ((MethodSlot.variableArgumentsName(method) == name) &&
         MethodSlot.passVariableArgumentsAsListP(method))) {
      type = MethodSlot.yieldListifiedVariableArgumentsType(method);
    }
    return (Cons.cons((StandardObject.cppReferenceTypeP(type) ? StandardObject.cppReferencizeType(type) : StandardObject.cppTranslateAndPointerizeTypeSpec(type)), Cons.cons(Symbol.cppTranslateName(name), Stella.NIL)));
  }

  public static StringWrapper cppTranslateSymbolId(Symbol symbol) {
    return (GeneralizedSymbol.cppTranslateSymbolConstantId(symbol));
  }

  public static StringWrapper cppTranslateSymbolName(Symbol symbol) {
    return (GeneralizedSymbol.cppTranslateSymbolConstantName(symbol));
  }

  public static StringWrapper cppTranslateReturnParameterName(Symbol namesymbol, int parameternumber) {
    { Symbol returnsymbol = Symbol.internSymbol(namesymbol.symbolName + Native.integerToString(((long)(parameternumber))));
      StringWrapper translatedname = Symbol.cppTranslateName(returnsymbol);

      return (translatedname);
    }
  }

  public static StringWrapper cppTranslateClassParameterName(Symbol namesymbol) {
    return (StringWrapper.wrapString(Stella.cppSubstituteForbiddenCharacters(GeneralizedSymbol.cppChangeCase(namesymbol, Stella.KWD_UPPERCASE), Stella.KWD_UPPERCASE)));
  }

  public static StringWrapper cppTranslateGlobalName(Symbol namesymbol) {
    if (namesymbol == null) {
      return (StringWrapper.wrapString("NULL"));
    }
    if (namesymbol == Stella.SYM_STELLA_TRUE) {
      return (Stella.$CPP_TRUE_STRING_WRAPPER$);
    }
    if (namesymbol == Stella.SYM_STELLA_FALSE) {
      return (Stella.$CPP_FALSE_STRING_WRAPPER$);
    }
    return (StringWrapper.wrapString(Stella.cppYieldQualifiedName(Stella.cppSubstituteForbiddenCharacters(GeneralizedSymbol.cppChangeCase(namesymbol, Stella.KWD_UPPERCASE), Stella.KWD_UPPERCASE), namesymbol)));
  }

  public static StringWrapper cppTranslateName(Symbol namesymbol) {
    { StringWrapper reservedname = Symbol.cppLookupReservedWordTable(namesymbol);

      if (namesymbol == null) {
        return (StringWrapper.wrapString("NULL"));
      }
      if (reservedname != null) {
        return (reservedname);
      }
      return (StringWrapper.wrapString(Stella.cppSubstituteForbiddenCharacters(GeneralizedSymbol.cppChangeCase(namesymbol, Stella.KWD_LOWERCASE), Stella.KWD_LOWERCASE)));
    }
  }

  public static Symbol cppFixupNameSymbol(Symbol namesymbol, Module homemodule) {
    if (((Module)(namesymbol.homeContext)) == homemodule) {
      return (namesymbol);
    }
    else {
      { Symbol self000 = Symbol.newSymbol(namesymbol.symbolName);

        self000.homeContext = homemodule;
        { Symbol value000 = self000;

          return (value000);
        }
      }
    }
  }

  public Cons cppTranslateAtomicTree() {
    { Symbol tree = this;

      { GlobalVariable globalvar = tree.softPermanentify().lookupGlobalVariable();

        if (globalvar != null) {
          return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(Symbol.cppTranslateGlobalName(tree), Cons.cons(Stella.NIL, Stella.NIL)))));
        }
        else {
          return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(Symbol.cppTranslateName(tree), Cons.cons(Stella.NIL, Stella.NIL)))));
        }
      }
    }
  }

  public static Cons cppTranslateArgumentListTree(Symbol operator, Surrogate owner, Stella_Object argument) {
    owner = owner;
    if (operator == Stella.SYM_STELLA_ALLOCATE_ITERATOR) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Cannot handle explicit calls to `ARGUMENT-LIST.ALLOCATE-ITERATOR' in C++.");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      return (((Cons)(Stella_Object.cppTranslateATree(argument))));
    }
    else if (operator == Stella.SYM_STELLA_LENGTH) {
      return (((Cons)(Stella_Object.cppTranslateATree(MethodSlot.variableArgumentsName(((MethodSlot)(Stella.$METHODBEINGWALKED$.get())))))));
    }
    else if (operator == Stella.SYM_STELLA_NEXTp) {
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_BINARY_OP, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_UNARY_OP, Cons.cons(Stella_Object.cppTranslateATree(Symbol.cppYieldVaIteratorHelperVariable(((Symbol)(argument)))), Cons.cons(Symbol.cppLookupOperatorTable(Stella.SYM_STELLA___).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Symbol.cppLookupOperatorTable(Stella.SYM_STELLA_g).concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_LITERAL, Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL), Stella.NIL)))));
    }
    else if (operator == Stella.SYM_STELLA_ARGUMENT) {
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(Symbol.cppTranslateName(Stella.SYM_STELLA_VA_ARG), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ACTUALS, Cons.cons(Stella_Object.cppTranslateATree(argument), Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(MethodSlot.variableArgumentsType(((MethodSlot)(Stella.$METHODBEINGWALKED$.get())))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))));
    }
    else {
      { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Cannot translate call to `" + Stella_Object.deUglifyParseTree(operator) + "' on an `ARGUMENT-LIST'.");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
        }
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(Symbol.cppTranslateName(operator), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ACTUALS, Cons.cons(Stella_Object.cppTranslateATree(argument), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))));
    }
  }

  public static Cons cppYieldVaIteratorDeclarations(Symbol iteratorvar) {
    return (Cons.list$(Cons.cons(Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(Stella.SGT_STELLA_ARGUMENT_LIST_ITERATOR), Cons.cons(Stella_Object.cppTranslateATree(iteratorvar), Stella.NIL)), Cons.cons(Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(Stella.SGT_STELLA_INTEGER), Cons.cons(Stella_Object.cppTranslateATree(Symbol.cppYieldVaIteratorHelperVariable(iteratorvar)), Cons.cons(Stella_Object.cppTranslateATree(MethodSlot.variableArgumentsName(((MethodSlot)(Stella.$METHODBEINGWALKED$.get())))), Stella.NIL))), Cons.cons(Stella.NIL, Stella.NIL)))));
  }

  public static Symbol cppYieldVaIteratorHelperVariable(Symbol iteratorvar) {
    return (Symbol.internSymbol(iteratorvar.symbolName + "-COUNT"));
  }

  public static Cons cppYieldVaEndTree(Symbol iteratorvar) {
    return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(Symbol.cppTranslateName(Stella.SYM_STELLA_VA_END), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ACTUALS, Cons.cons(Stella_Object.cppTranslateATree(iteratorvar), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL));
  }

  public static Cons cppYieldVaStartTree(Symbol iteratorvar) {
    return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(Symbol.cppTranslateName(Stella.SYM_STELLA_VA_START), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ACTUALS, Cons.cons(Stella_Object.cppTranslateATree(iteratorvar), Cons.cons(Cons.cons(Stella_Object.cppTranslateATree(MethodSlot.variableArgumentsName(((MethodSlot)(Stella.$METHODBEINGWALKED$.get())))), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL));
  }

  public static StringWrapper cppLookupReservedWordTable(Symbol word) {
    { StringWrapper entry = ((StringWrapper)(Stella.$CPP_RESERVED_WORD_TABLE$.lookup(word.symbolName)));

      if (entry != null) {
        return (StringWrapper.wrapString(entry.wrapperValue));
      }
      else {
        return (null);
      }
    }
  }

  public static StringWrapper cppYieldRenamedReservedWord(Symbol word) {
    { String name = word.symbolName;
      int length = name.length();

      return (StringWrapper.wrapString(Native.stringDowncase(Native.string_subsequence(name, 0, length - 1)) + Native.makeString(1, Stella.$CHARACTER_UPCASE_TABLE$.charAt(((int) (name.charAt((length - 1))))))));
    }
  }

  public static Cons cppLookupOperatorTable(Symbol operator) {
    { Cons entry = ((Cons)(Stella.$OPERATOR_TABLE$.lookup(operator)));
      Cons copiedentry = Stella.NIL;

      if (entry != null) {
        { StringWrapper wrapper = null;
          Cons iter000 = entry;
          Cons collect000 = null;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            wrapper = ((StringWrapper)(iter000.value));
            if (collect000 == null) {
              {
                collect000 = Cons.cons(StringWrapper.wrapString(wrapper.wrapperValue), Stella.NIL);
                if (copiedentry == Stella.NIL) {
                  copiedentry = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(copiedentry, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(StringWrapper.wrapString(wrapper.wrapperValue), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        return (copiedentry);
      }
      return (null);
    }
  }

  public static Module overloadedFunctionNameModule(Symbol functionName, Surrogate classType) {
    { Module symbolModule = functionName.homeModule();
      Module classModule = classType.homeModule();

      if (symbolModule == classModule) {
        return (symbolModule);
      }
      else if (classModule.parentModules.memberP(symbolModule)) {
        return (classModule);
      }
      else if (symbolModule.parentModules.memberP(classModule)) {
        return (symbolModule);
      }
      else {
        return (classModule);
      }
    }
  }

  /** Define a system of files that collectively define
   * a Stella application.
   *    Required options are:
   *    :directory -- the relative path from the respective source/native/binary root directory
   *                  to the directory containing the system files.  Can be a string or a list
   *                  of strings (do not include directory separators).
   *    :files -- a list of files in the system, containing strings and lists
   *              of strings; the latter defines exploded paths to files
   *              in subdirectories.
   *    Optional options are:
   *    :data-files       -- a list of files like the :files keyword, which contain
   *                         data or other content that should not be processed, but
   *                         instead copied verbatim to the native directory
   *    :required-systems -- a list of systems (strings) that should be loaded
   *                         prior to loading this system.
   *    :cardinal-module -- the name (a string) of the principal module for this
   *                        system.
   *    :copyright-header -- string with a header for inclusion into all translated
   *                         files produced by Stella.
   *    :lisp-only-files  -- Like the :files keyword, but these are only included
   *    :cpp-only-files      in the translation for the specific language, namely
   *    :java-only-files     Common Lisp, C++ or Java
   * @param name
   * @param options
   * @return SystemDefinition
   */
  public static SystemDefinition defsystem(Symbol name, Cons options) {
    return (Stella_Object.defineSystem(name, options));
  }

  public static Surrogate makeMemoizationTableSurrogate(Symbol memoname) {
    if (memoname == null) {
      memoname = Stella.methodGensym("MEMO-TABLE");
    }
    return (memoname.surrogatify());
  }

  /** Coerce the argument list variable <code>restvariable</code> into a CONS
   * list containing all its elements (uses argument list iteration to do so).  If
   * <code>restvariable</code> already is a CONS due to argument listification, this is a no-op.
   * @param restvariable
   * @return Stella_Object
   */
  public static Stella_Object coerceARestToCons(Symbol restvariable) {
    if (MethodSlot.passVariableArgumentsAsListP(((MethodSlot)(Stella.$METHODBEINGWALKED$.get())))) {
      return (Stella_Object.sysTree(Stella_Object.walkWithoutTypeTree(restvariable), MethodSlot.yieldListifiedVariableArgumentsType(((MethodSlot)(Stella.$METHODBEINGWALKED$.get()))), new Object[1]));
    }
    else {
      { Symbol argvar = Stella.localGensym("ARG");
        Symbol listvar = Stella.localGensym("ARGLIST");

        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Cons.cons(Cons.cons(listvar, Cons.cons(MethodSlot.yieldListifiedVariableArgumentsType(((MethodSlot)(Stella.$METHODBEINGWALKED$.get()))), Cons.cons(Stella.SYM_STELLA_NIL, Stella.NIL))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_FOREACH, Cons.cons(argvar, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IN, Cons.cons(restvariable, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_COLLECT, Cons.cons(argvar, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_INTO, Cons.cons(listvar, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Stella.NIL)))), Stella.NIL)))), Cons.cons(listvar, Cons.cons(Stella.NIL, Stella.NIL)))))));
      }
    }
  }

  /** Assign 'variable' the result of evaluating 'expression', 
   * and return TRUE if 'expression' is not NULL else return FALSE.
   * @param variable
   * @param expression
   * @return Stella_Object
   */
  public static Stella_Object setqP(Symbol variable, Cons expression) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Stella.NIL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(variable, Cons.cons(Cons.cons(expression, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(variable, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))));
  }

  /** Push <code>value</code> onto the cons list <code>variable</code>, unless <code>value</code>
   * is already a member of the list.
   * @param variable
   * @param value
   * @return Stella_Object
   */
  public static Stella_Object pushqNew(Symbol variable, Stella_Object value) {
    if (Stella_Object.consP(value)) {
      { Symbol valuevar = Stella.localGensym("VALUE");

        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Cons.cons(Cons.cons(valuevar, Cons.cons(value, Stella.NIL)), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(variable, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CHOOSE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_MEMBERp, Cons.cons(variable, Cons.cons(Cons.cons(valuevar, Stella.NIL), Stella.NIL)))), Cons.cons(variable, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CONS, Cons.cons(valuevar, Cons.cons(Cons.cons(variable, Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL))))), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))));
      }
    }
    else {
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(variable, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CHOOSE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_MEMBERp, Cons.cons(variable, Cons.cons(Cons.cons(value, Stella.NIL), Stella.NIL)))), Cons.cons(variable, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CONS, Cons.cons(value, Cons.cons(Cons.cons(variable, Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL))))), Stella.NIL), Stella.NIL)))));
    }
  }

  /** Pops a value from the cons list 'variable'.
   * @param variable
   * @return Stella_Object
   */
  public static Stella_Object popq(Symbol variable) {
    { Symbol valuevar = Stella.localGensym("HEAD");

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Cons.cons(Cons.cons(valuevar, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(variable, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(variable, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_REST, Cons.cons(variable, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))), Cons.cons(valuevar, Cons.cons(Stella.NIL, Stella.NIL)))))));
    }
  }

  /** Push 'value' onto the cons list 'variable'.
   * @param variable
   * @param value
   * @return Stella_Object
   */
  public static Stella_Object pushq(Symbol variable, Stella_Object value) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(variable, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CONS, Cons.cons(value, Cons.cons(Cons.cons(variable, Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL)))));
  }

  public static Cons expandXmlTagCase(Symbol item, Cons clauses) {
    { Cons outputClauses = Stella.NIL;
      Stella_Object key = null;

      { Cons clause = null;
        Cons iter000 = clauses;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          clause = ((Cons)(iter000.value));
          key = clause.value;
          { Surrogate testValue000 = Stella_Object.safePrimaryType(key);

            if (testValue000 == Stella.SGT_STELLA_CONS) {
              { Cons key000 = ((Cons)(key));

                if (key000.rest == Stella.NIL) {
                  outputClauses = Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_XML_ELEMENT_MATCHp, Cons.cons(item, Cons.cons(Cons.cons(key000.value, Cons.cons(Stella.SYM_STELLA_NULL, Stella.NIL)), Stella.NIL)))), clause.rest.concatenate(Stella.NIL, Stella.NIL)), outputClauses);
                }
                else if (key000.rest.value == Stella.KWD_ANY) {
                  outputClauses = Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_STRING_EQLp, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NAME, Cons.cons(item, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(key000.value, Cons.cons(Stella.NIL, Stella.NIL))))), clause.rest.concatenate(Stella.NIL, Stella.NIL)), outputClauses);
                }
                else {
                  outputClauses = Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_XML_ELEMENT_MATCHp, Cons.cons(item, Cons.cons(Cons.cons(key000.value, Cons.cons(key000.rest.value, Stella.NIL)), Stella.NIL)))), clause.rest.concatenate(Stella.NIL, Stella.NIL)), outputClauses);
                }
              }
            }
            else if (Surrogate.subtypeOfSymbolP(testValue000)) {
              { Symbol key000 = ((Symbol)(key));

                if (key000 == Stella.SYM_STELLA_OTHERWISE) {
                  outputClauses = Cons.cons(clause, outputClauses);
                }
                else {
                  outputClauses = Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_XML_ELEMENT_MATCHp, Cons.cons(item, Cons.cons(Cons.cons(StringWrapper.wrapString(key000.symbolName), Cons.cons(Stella.SYM_STELLA_NULL, Stella.NIL)), Stella.NIL)))), clause.rest.concatenate(Stella.NIL, Stella.NIL)), outputClauses);
                }
              }
            }
            else if (Surrogate.subtypeOfStringP(testValue000)) {
              { StringWrapper key000 = ((StringWrapper)(key));

                outputClauses = Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_XML_ELEMENT_MATCHp, Cons.cons(item, Cons.cons(Cons.cons(key000, Cons.cons(Stella.SYM_STELLA_NULL, Stella.NIL)), Stella.NIL)))), clause.rest.concatenate(Stella.NIL, Stella.NIL)), outputClauses);
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
      return (Cons.cons(Stella.SYM_STELLA_COND, outputClauses.reverse().concatenate(Stella.NIL, Stella.NIL)));
    }
  }

  public Context getStellaContextSlowly() {
    { Symbol self = this;

      return (Stella.string_getStellaContextSlowly(self.relativeName(false)));
    }
  }

  public static int clStructSlotOffset(Symbol slotname, Surrogate classtype) {
    { List slots = Stella_Class.clStructSlots(((Stella_Class)(classtype.surrogateValue)));
      int offset = 1;

      { StorageSlot slot = null;
        Cons iter000 = slots.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          slot = ((StorageSlot)(iter000.value));
          if (slot.slotName == slotname) {
            return (offset);
          }
          else {
            offset = offset + 1;
          }
        }
      }
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Can't find slot `" + Stella_Object.deUglifyParseTree(slotname) + "' on CL-struct class `" + Stella_Object.deUglifyParseTree(classtype) + "'.");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      return (Stella.NULL_INTEGER);
    }
  }

  public static boolean duplicateCursorVariableP(Symbol variable, Cons iteratorbindings) {
    { boolean foundP000 = false;

      { Cons ib = null;
        Cons iter000 = ((Cons)(iteratorbindings));

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          ib = ((Cons)(iter000.value));
          if (ib.value == variable) {
            foundP000 = true;
            break loop000;
          }
        }
      }
      { boolean value000 = foundP000;

        return (value000);
      }
    }
  }

  public static Cons clTranslateNormalCallMethodTree(Symbol operator, Surrogate owner, Cons arguments) {
    { Stella_Object translatedoperator = Symbol.clTranslateGlobalSymbol(Symbol.yieldRenamedNameIfNative(operator, Stella.KWD_COMMON_LISP, Stella.KWD_FUNCTION));

      { Symbol testValue000 = Symbol.methodCallTypeForVectorStructs(operator, owner, owner == null);

        if ((testValue000 == Stella.SYM_STELLA_OBJECT_METHOD) ||
            (testValue000 == Stella.SYM_STELLA_PRINT_OBJECT)) {
          return (Cons.cons(Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_CLSYS_CALL), Cons.cons(translatedoperator, Cons.clTranslateListOfTrees(arguments).concatenate(Stella.NIL, Stella.NIL))));
        }
        else if (testValue000 == Stella.SYM_STELLA_NON_OBJECT_METHOD) {
          return (Cons.cons(translatedoperator, Cons.cons(Stella_Object.clTranslateATree(arguments.value), Cons.cons(Stella.SYM_STELLA_NULL, Cons.clTranslateListOfTrees(arguments.rest).concatenate(Stella.NIL, Stella.NIL)))));
        }
        else {
          return (Cons.cons(translatedoperator, Cons.clTranslateListOfTrees(arguments).concatenate(Stella.NIL, Stella.NIL)));
        }
      }
    }
  }

  public static Symbol methodCallTypeForVectorStructs(Symbol slotname, Surrogate owner, boolean functionP) {
    if (functionP ||
        ((owner == null) ||
         ((slotname == Stella.SYM_STELLA_NULLp) ||
          ((slotname == Stella.SYM_STELLA_DEFINEDp) ||
           (Symbol.symbolCommonLispP(slotname) ||
            ((!((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_STRUCTS)) ||
             (!((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_VECTOR_STRUCTS)))))))) {
      return (Stella.SYM_STELLA_NORMAL_CALL);
    }
    if (((!Surrogate.subtypeOfP(owner, Stella.SGT_STELLA_OBJECT)) &&
        (!((Stella_Class)(owner.surrogateValue)).mixinP)) ||
        ((owner == Stella.SGT_STELLA_CONS) &&
         ((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_CONSES))) {
      return (Stella.SYM_STELLA_NON_OBJECT_METHOD);
    }
    else {
      if (slotname == Stella.SYM_STELLA_PRINT_OBJECT) {
        return (Stella.SYM_STELLA_PRINT_OBJECT);
      }
      else {
        return (Stella.SYM_STELLA_OBJECT_METHOD);
      }
    }
  }

  public static Symbol trueSlotName(Symbol slotname, Surrogate type) {
    return (StorageSlot.canonicalSlot(((StorageSlot)(Stella_Class.lookupSlot(((Stella_Class)(type.surrogateValue)), slotname)))).slotName);
  }

  public static Cons yieldSlotValueWriterTree(Symbol slotname, Stella_Object objectref, Surrogate objecttype, Stella_Object valueref) {
    return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("SETF"), Cons.cons(Symbol.yieldSlotValueReaderTree(slotname, objectref, objecttype), Cons.cons(Cons.cons(valueref, Stella.NIL), Stella.NIL)))));
  }

  public static Cons yieldSlotValueReaderTree(Symbol slotname, Stella_Object objectref, Surrogate objecttype) {
    if ((objecttype == Stella.SGT_STELLA_CONS) &&
        ((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_CONSES)) {
      if (slotname == Stella.SYM_STELLA_VALUE) {
        return (Cons.cons(Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_rrVALUE), Cons.cons(objectref, Stella.NIL)));
      }
      else if (slotname == Stella.SYM_STELLA_REST) {
        return (Cons.cons(Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_rrREST), Cons.cons(objectref, Stella.NIL)));
      }
      else {
      }
    }
    { Stella_Class renamed_Class = ((Stella_Class)(objecttype.surrogateValue));

      if ((!((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_STRUCTS)) ||
          (Stella_Class.exceptionClassP(renamed_Class) ||
           Stella_Class.clAlwaysTranslateToClosClassP(renamed_Class))) {
        return (Cons.cons(Symbol.yieldClosSlotAccessorName(slotname), Cons.cons(objectref, Stella.NIL)));
      }
      else if (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_VECTOR_STRUCTS)) {
        return (Cons.cons(Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_CLSYS_SVAL), Cons.cons(IntegerWrapper.wrapInteger(Symbol.clStructSlotOffset(slotname, objecttype)), Cons.cons(Symbol.clTranslateGlobalSymbol(Symbol.internSymbolInModule(objecttype.symbolName, ((Module)(objecttype.homeContext)), true)), Cons.cons(Symbol.clTranslateGlobalSymbol(slotname), Cons.cons(objectref, Stella.NIL))))));
      }
      else {
        return (Cons.cons(Surrogate.yieldStructSlotAccessorName(objecttype, slotname), Cons.cons(objectref, Stella.NIL)));
      }
    }
  }

  public static Stella_Object yieldClosSlotAccessorName(Symbol slotname) {
    return (Module.yieldGlobalLispSymbol(((Module)(slotname.homeContext)), "%" + slotname.symbolName));
  }

  public static Stella_Object clTranslateLocalSymbol(Symbol symbol) {
    return (VerbatimStringWrapper.newVerbatimStringWrapper(Module.yieldReadableSymbolName(((Module)(symbol.homeContext)), symbol.symbolName, true)));
  }

  public static Stella_Object clTranslateGlobalSymbol(Symbol symbol) {
    { Module symbolmodule = ((Module)(symbol.homeContext));

      if (symbolmodule == Stella.$COMMON_LISP_MODULE$) {
        return (symbol);
      }
      if (symbolmodule == null) {
        symbolmodule = ((Module)(Stella.$MODULE$.get()));
      }
      return (Module.yieldGlobalLispSymbol(symbolmodule, symbol.symbolName));
    }
  }

  public Stella_Object clTranslateAtomicTree() {
    { Symbol tree = this;

      if (tree == Stella.SYM_STELLA_TRUE) {
        return (Stella.$CL_TRUE_STRING_WRAPPER$);
      }
      else if (tree == Stella.SYM_STELLA_FALSE) {
        return (Stella.$CL_FALSE_STRING_WRAPPER$);
      }
      else if (tree.lookupGlobalVariable() != null) {
        return (Symbol.clTranslateGlobalSymbol(tree));
      }
      else {
        return (Symbol.clTranslateLocalSymbol(tree));
      }
    }
  }

  public static Stella_Object yieldArgumentAccessTree(Symbol argumentsvariable, int index, boolean restargumentP) {
    { int limit = 5;
      Stella_Object accesstree = argumentsvariable;

      if (index <= limit) {
        { int i = Stella.NULL_INTEGER;
          int iter000 = 2;
          int upperBound000 = index;
          boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

          for (;unboundedP000 ||
                    (iter000 <= upperBound000); iter000 = iter000 + 1) {
            i = iter000;
            i = i;
            accesstree = Cons.list$(Cons.cons(Stella.SYM_STELLA_REST, Cons.cons(accesstree, Cons.cons(Stella.NIL, Stella.NIL))));
          }
        }
      }
      else {
        accesstree = Cons.list$(Cons.cons(Stella.SYM_STELLA_NTH_REST, Cons.cons(accesstree, Cons.cons(Cons.cons(IntegerWrapper.wrapInteger(index - 1), Stella.NIL), Stella.NIL))));
      }
      if (!restargumentP) {
        if (index <= limit) {
          accesstree = Cons.list$(Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(accesstree, Cons.cons(Stella.NIL, Stella.NIL))));
        }
        else {
          ((Cons)(accesstree)).value = Stella.SYM_STELLA_NTH;
        }
      }
      return (accesstree);
    }
  }

  public static Symbol yieldEvaluatorWrapperName(Symbol methodname) {
    { String baseName = methodname.symbolName;
      String suffix = (Stella.allUpperCaseStringP(baseName) ? "-EVALUATOR-WRAPPER" : "-Evaluator-Wrapper");

      return (Symbol.internDerivedSymbol(methodname, baseName + suffix));
    }
  }

  /** Look up a function with <code>name</code> that can be evaluated via <code>apply</code>
   * just like a command, regardless of whether it was marked as such.
   * @param name
   * @return MethodSlot
   */
  public static MethodSlot lookupCommandLikeFunction(Symbol name) {
    { MethodSlot function = Symbol.lookupFunction(name);

      if ((function != null) &&
          MethodSlot.methodCallableViaApplyP(function)) {
        return (function);
      }
      else {
        return (null);
      }
    }
  }

  /** If <code>name</code> names an evaluable command return its associated
   * command object;  otherwise, return <code>null</code>.  Currently, commands are not
   * polymorphic, i.e., they can only be implemented by functions.
   * @param name
   * @return MethodSlot
   */
  public static MethodSlot lookupCommand(Symbol name) {
    { MethodSlot function = Symbol.lookupFunction(name);

      if ((function != null) &&
          MethodSlot.commandP(function)) {
        return (function);
      }
      else {
        return (null);
      }
    }
  }

  public static void createLispMacroUnits(Symbol name, MethodSlot method) {
    if (name == method.slotName) {
      Symbol.registerNativeName(name, Stella.KWD_COMMON_LISP, Stella.KWD_FUNCTION);
    }
    { Cons macrotree = null;
      Cons aliasdefinitiontree = null;

      { Object [] caller_MV_returnarray = new Object[1];

        macrotree = Symbol.yieldLispMacroTrees(name, method, caller_MV_returnarray);
        aliasdefinitiontree = ((Cons)(caller_MV_returnarray[0]));
      }
      Cons.walkAuxiliaryTree(macrotree);
      Cons.walkAuxiliaryTree(aliasdefinitiontree);
    }
    if (name == method.slotName) {
      Cons.walkAuxiliaryTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_STARTUP_TIME_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_REGISTER_NATIVE_NAME, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_QUOTE, Cons.cons(name, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.KWD_COMMON_LISP, Cons.cons(Stella.KWD_FUNCTION, Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))));
    }
  }

  public static Cons yieldLispMacroTrees(Symbol name, MethodSlot method, Object [] MV_returnarray) {
    { Module module = ((((Module)(name.homeContext)) != null) ? ((Module)(name.homeContext)) : ((Module)(Stella.$MODULE$.get())));
      Stella_Object translatedname = Module.yieldGlobalLispSymbol(module, name.symbolName);
      Stella_Object translatedfullname = Module.yieldGlobalLispSymbol(module, Stella.computeFullName(name.symbolName, module));
      String documentation = ((StringWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue;

      { Cons _return_temp = Cons.list$(Cons.cons(Stella.SYM_STELLA_VERBATIM, Cons.cons(Stella.KWD_COMMON_LISP, Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("DEFMACRO"), Cons.cons(translatedname, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("&WHOLE"), Cons.cons(Stella.SYM_STELLA_EXPRESSION, Cons.cons(Stella.internCommonLispSymbol("&REST"), Cons.cons(Stella.SYM_STELLA_IGNORE, Cons.cons(Stella.NIL, Stella.NIL)))))), (((documentation != null) ? Cons.cons(StringWrapper.wrapString(documentation), Stella.NIL) : Stella.NIL)).concatenate(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("DECLARE"), Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("IGNORE"), Cons.cons(Stella.SYM_STELLA_IGNORE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("LET"), Cons.cons(Cons.cons(Cons.cons(Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_$IGNORETRANSLATIONERRORSp$), Cons.cons((MethodSlot.commandP(method) ? Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_FALSE) : Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_TRUE)), Stella.NIL)), Stella.NIL), Cons.cons(Cons.cons(Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_CL_INCREMENTALLY_TRANSLATE), Cons.cons(Stella.SYM_STELLA_EXPRESSION, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)), Stella.NIL)))), Cons.cons(Stella.KWD_OTHERWISE, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL)))))));

        MV_returnarray[0] = Cons.list$(Cons.cons(Stella.SYM_STELLA_VERBATIM, Cons.cons(Stella.KWD_COMMON_LISP, Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("SETF"), Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("MACRO-FUNCTION"), Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("QUOTE"), Cons.cons(translatedfullname, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("MACRO-FUNCTION"), Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("QUOTE"), Cons.cons(translatedname, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.KWD_OTHERWISE, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL)))))));
        return (_return_temp);
      }
    }
  }

  public static Symbol yieldRenamedNameIfNative(Symbol name, Keyword language, Keyword category) {
    if (Symbol.nativeNameP(name, language, category)) {
      { Symbol newname = null;

        if (language == Stella.KWD_COMMON_LISP) {
          newname = Symbol.internDerivedSymbol(name, "%" + name.symbolName);
        }
        else if (language == Stella.KWD_CPP) {
          return (name);
        }
        else {
          newname = Symbol.internDerivedSymbol(name, name.symbolName + "_");
        }
        return (Symbol.yieldRenamedNameIfNative(newname, language, category));
      }
    }
    else {
      return (name);
    }
  }

  public static boolean nativeNameP(Symbol name, Keyword language, Keyword category) {
    { KeyValueList tableentry = ((KeyValueList)(Stella.$NATIVE_NAME_TABLE$.lookup(name)));
      List categories = null;

      if (tableentry == null) {
        return (false);
      }
      categories = ((List)(tableentry.lookup(language)));
      if (categories == null) {
        return (false);
      }
      else {
        return ((category == null) ||
            categories.memberP(category));
      }
    }
  }

  public static void registerNativeName(Symbol name, Keyword language, Keyword category) {
    { KeyValueList tableentry = ((KeyValueList)(Stella.$NATIVE_NAME_TABLE$.lookup(name)));
      List categories = null;

      if (tableentry == null) {
        tableentry = KeyValueList.newKeyValueList();
      }
      categories = ((List)(tableentry.lookup(language)));
      if (categories == null) {
        categories = List.newList();
      }
      categories.insertNew(category);
      tableentry.insertAt(language, categories);
      Stella.$NATIVE_NAME_TABLE$.insertAt(name, tableentry);
    }
  }

  public static String yieldStartupFunctionClassname(Symbol functionName) {
    { StringWrapper baseName = StringWrapper.javaTranslateClassNamestring(StringWrapper.wrapString(functionName.symbolName));

      if (Stella.systemStartupFileP(((String)(Stella.$CURRENTFILE$.get())))) {
        return (baseName.wrapperValue);
      }
      else {
        return ("_" + baseName.wrapperValue);
      }
    }
  }

  public static Cons combineStartupFunctionUnits(Symbol startupfnname) {
    { Cons earlystartuptrees = Stella.NIL;
      Cons startuptrees = Stella.NIL;
      Cons startupphasetrees = Stella.NIL;
      List startupunits = List.newList();

      { ListIterator it = ((ListIterator)(((List)(Stella.$TRANSLATIONUNITS$.get())).allocateIterator()));

        while (it.nextP()) {
          if (((TranslationUnit)(it.value)).category == Stella.SYM_STELLA_STARTUP_TIME_PROGN) {
            startupunits.push(((TranslationUnit)(it.value)));
            it.valueSetter(null);
          }
        }
      }
      ((List)(Stella.$TRANSLATIONUNITS$.get())).remove(null);
      startupunits.sort(Native.find_java_method("edu.isi.stella.TranslationUnit", "earlierStartupUnitP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TranslationUnit"), Native.find_java_class("edu.isi.stella.TranslationUnit")}));
      if ((startupfnname != null) &&
          (startupunits.length() > Stella.$MAX_NUMBER_OF_STARTUP_UNITS$)) {
        List.extractStartupFunctionUnits(startupunits, startupfnname);
      }
      { Keyword phase = null;
        Cons iter000 = Stella.$STARTUP_TIME_PHASES$.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          phase = ((Keyword)(iter000.value));
          while (startupunits.nonEmptyP() &&
              (((TranslationUnit)(startupunits.first())).codeRegister == phase)) {
            startupphasetrees = startupphasetrees.concatenate(((Cons)(((TranslationUnit)(startupunits.first())).theObject)), Stella.NIL);
            TranslationUnit.clearTranslationUnit(((TranslationUnit)(startupunits.pop())));
          }
          if (!(startupphasetrees == Stella.NIL)) {
            startupphasetrees = Cons.list$(Cons.cons(Stella.SYM_STELLA_VOID_SYS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_CALL_FUNCTION, Cons.cons(Stella.SYM_STELLA_CURRENT_STARTUP_TIME_PHASEp, Cons.cons(IntegerWrapper.wrapInteger(Keyword.encodeStartupTimePhase(phase)), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(startupphasetrees.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))));
            if (Keyword.encodeStartupTimePhase(phase) <= Keyword.encodeStartupTimePhase(Stella.KWD_MODULES)) {
              earlystartuptrees = Cons.cons(startupphasetrees, earlystartuptrees);
            }
            else {
              startuptrees = Cons.cons(startupphasetrees, startuptrees);
            }
            startupphasetrees = Stella.NIL;
          }
        }
      }
      if (!(startuptrees == Stella.NIL)) {
        startuptrees = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WITHIN_MODULE, Cons.cons(((((Module)(Stella.$MODULE$.get())) == Stella.$STELLA_MODULE$) ? ((StandardObject)(Stella.SYM_STELLA_$STELLA_MODULE$)) : ((StandardObject)(Cons.list$(Cons.cons(Stella.SYM_STELLA_GET_STELLA_MODULE, Cons.cons(StringWrapper.wrapString(((Module)(Stella.$MODULE$.get())).moduleFullName), Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_g, Cons.cons(Stella.SYM_STELLA_$STARTUP_TIME_PHASE$, Cons.cons(IntegerWrapper.wrapInteger(Keyword.encodeStartupTimePhase(Stella.KWD_MODULES)), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Stella.NIL))))))), Cons.cons(startuptrees.reverse().concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Stella.NIL);
      }
      if ((!(earlystartuptrees == Stella.NIL)) ||
          (!(startuptrees == Stella.NIL))) {
        startuptrees = earlystartuptrees.reverse().concatenate(startuptrees, Stella.NIL);
      }
      return (startuptrees);
    }
  }

  /** If <code>name</code> has a macro definition, return the method object
   * holding its expander function.
   * @param name
   * @return MethodSlot
   */
  public static MethodSlot lookupMacro(Symbol name) {
    { MethodSlot function = Symbol.lookupFunction(name);

      if ((function != null) &&
          ((BooleanWrapper)(KeyValueList.dynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_MACROp, Stella.FALSE_WRAPPER))).wrapperValue) {
        return (function);
      }
      return (null);
    }
  }

  public static Cons walkInlineVariableReference(Symbol self, Object [] MV_returnarray) {
    Symbol.setLocalVariableInfo(self, Stella.KWD_INLINE_REFERENCES, IntegerWrapper.wrapInteger(((IntegerWrapper)(Symbol.getLocalVariableInfo(self, Stella.KWD_INLINE_REFERENCES))).wrapperValue + 1));
    return (Stella_Object.sysTree(Stella_Object.copyConsTree(Symbol.getLocalVariableInfo(self, Stella.KWD_INLINE_ARGUMENT)), Symbol.lookupVariableType(self), MV_returnarray));
  }

  public static boolean inlineVariableReferenceP(Symbol self) {
    return (((Boolean)(Stella.$INLININGMETHODCALLp$.get())).booleanValue() &&
        (Symbol.getLocalVariableInfo(self, Stella.KWD_INLINE_ARGUMENT) != null));
  }

  public static MethodSlot findPrototypeMethod(Symbol methodname, Surrogate abstracttype) {
    { Slot method = null;

      { Surrogate sub = null;
        Cons iter000 = ((Stella_Class)(abstracttype.surrogateValue)).classDirectSubs.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          sub = ((Surrogate)(iter000.value));
          if (((Stella_Class)(sub.surrogateValue)) != null) {
            if (((Stella_Class)(sub.surrogateValue)).abstractP) {
              method = Symbol.findPrototypeMethod(methodname, sub);
            }
            else {
              method = Stella_Class.lookupSlot(((Stella_Class)(sub.surrogateValue)), methodname);
            }
            if ((method != null) &&
                (!Stella_Object.storageSlotP(method))) {
              return (((MethodSlot)(method)));
            }
          }
        }
      }
      return (null);
    }
  }

  public static Cons yieldNestedArithmeticOperatorCallTree(Symbol operator, Cons operands) {
    { int nofoperands = operands.length();
      Cons parenthesizedtree = Symbol.yieldArithmeticOperatorCallTree(operator, Cons.consList(Cons.cons(operands.value, Cons.cons(operands.rest.value, Stella.NIL))));

      { int i = Stella.NULL_INTEGER;
        int iter000 = 2;
        int upperBound000 = nofoperands - 1;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          parenthesizedtree = Symbol.yieldArithmeticOperatorCallTree(operator, Cons.consList(Cons.cons(parenthesizedtree, Cons.cons(operands.nth(i), Stella.NIL))));
        }
      }
      return (parenthesizedtree);
    }
  }

  public static Cons yieldArithmeticOperatorCallTree(Symbol operator, Cons operands) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_CALL_METHOD, Cons.cons(Stella.SGT_STELLA_NUMBER, Cons.cons(operator, Cons.cons(operands.concatenate(Stella.NIL, Stella.NIL), Stella.NIL))))));
  }

  public static Cons yieldCastedTypecaseClauseTrees(Symbol testvariable, StandardObject clausetype, Cons clausetrees) {
    { StandardObject testvariabletype = Symbol.lookupVariableType(testvariable);
      boolean needrealcastP = !(((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP);
      Symbol auxvariable = (((!(((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA)) &&
          needrealcastP) ? Stella.localGensym(testvariable.symbolName) : ((Symbol)(null)));
      Cons castedclausetrees = null;

      if (!needrealcastP) {
        Symbol.pushVariableBinding(testvariable, clausetype);
        castedclausetrees = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VOID_SYS, Cons.cons(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.walkListOfStatements(clausetrees).concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL);
        Stella.popVariableBinding();
      }
      else {
        if (auxvariable != null) {
          Symbol.pushVariableBinding(auxvariable, testvariabletype);
        }
        castedclausetrees = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(((auxvariable != null) ? Cons.list$(Cons.cons(Cons.cons(auxvariable, Cons.cons(testvariable, Stella.NIL)), Cons.cons(Cons.cons(testvariable, Cons.cons(clausetype, Cons.cons(auxvariable, Stella.NIL))), Cons.cons(Stella.NIL, Stella.NIL)))) : Cons.cons(Cons.cons(testvariable, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SAFE_CAST, Cons.cons(Stella_Object.sysTree(Stella_Object.walkWithoutTypeTree(testvariable), clausetype, new Object[1]), Cons.cons(Cons.cons(clausetype, Stella.NIL), Stella.NIL)))), Stella.NIL)), Stella.NIL)), Cons.cons(clausetrees.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Stella.NIL);
        if (auxvariable != null) {
          Stella.popVariableBinding();
        }
      }
      return (castedclausetrees);
    }
  }

  public static Symbol lookupOldValueVariable(Symbol variable) {
    return (((Symbol)(KeyValueList.lookupVariableTable(((KeyValueList)(Stella.$SPECIALVARIABLESTACK$.get())), variable))));
  }

  public static void pushSpecial(Symbol variable, Symbol oldvaluevariable) {
    ((KeyValueList)(Stella.$SPECIALVARIABLESTACK$.get())).theKvList = KvCons.kvCons(variable, oldvaluevariable, ((KeyValueList)(Stella.$SPECIALVARIABLESTACK$.get())).theKvList);
  }

  public static Cons walkADeclaration(Symbol variable, Stella_Object typetree, Stella_Object value, boolean inputparameterP) {
    { StandardObject sourcetype = null;
      StandardObject targettype = Stella_Object.safeYieldTypeSpecifier(typetree);
      Surrogate methodownertype = ((((MethodSlot)(Stella.$METHODBEINGWALKED$.get())) != null) ? ((MethodSlot)(Stella.$METHODBEINGWALKED$.get())).slotOwner : ((Surrogate)(null)));
      Stella_Object ovalue = null;

      if ((targettype != null) &&
          ((methodownertype != null) &&
           (!StandardObject.voidP(methodownertype)))) {
        targettype = StandardObject.computeRelativeTypeSpec(targettype, methodownertype);
      }
      if (!(inputparameterP)) {
        Symbol.pushVariableBinding(variable, Stella.SGT_STELLA_UNINITIALIZED);
        { Object [] caller_MV_returnarray = new Object[1];

          ovalue = Stella_Object.walkExpressionTree(value, targettype, Stella.SYM_STELLA_VARIABLE_DECLARATION, true, caller_MV_returnarray);
          sourcetype = ((StandardObject)(caller_MV_returnarray[0]));
        }
        if (targettype == null) {
          targettype = sourcetype;
        }
        Stella.popVariableBinding();
      }
      Symbol.pushVariableBinding(variable, targettype);
      if (inputparameterP) {
        return (Cons.cons(variable, Cons.cons(targettype, Stella.NIL)));
      }
      else {
        return (Cons.cons(Symbol.trueVariableName(variable), Cons.cons(targettype, Cons.cons(ovalue, Stella.NIL))));
      }
    }
  }

  public Stella_Object walkAtomicTree(Object [] MV_returnarray) {
    { Symbol self = this;

      if (Symbol.constantSymbolP(self)) {
        { Symbol value000 = null;
          Surrogate value001 = null;

          { Object [] caller_MV_returnarray = new Object[1];

            value000 = Symbol.walkConstantSymbol(self, caller_MV_returnarray);
            value001 = ((Surrogate)(caller_MV_returnarray[0]));
          }
          { Stella_Object _return_temp = value000;

            MV_returnarray[0] = value001;
            return (_return_temp);
          }
        }
      }
      if (((Boolean)(Stella.$INLININGMETHODCALLp$.get())).booleanValue() &&
          (Symbol.getLocalVariableInfo(self, Stella.KWD_INLINE_ARGUMENT) != null)) {
        return (Symbol.walkInlineVariableReference(self, MV_returnarray));
      }
      { Symbol truename = Symbol.trueVariableName(self);
        StandardObject type = Symbol.lookupVariableType(self);

        if (truename == self) {
          { Stella_Object _return_temp = self;

            MV_returnarray[0] = type;
            return (_return_temp);
          }
        }
        else {
          { Stella_Object _return_temp = Stella_Object.sysTree(truename, type, new Object[1]);

            MV_returnarray[0] = type;
            return (_return_temp);
          }
        }
      }
    }
  }

  public static Symbol walkConstantSymbol(Symbol self, Object [] MV_returnarray) {
    { Symbol _return_temp = self;

      MV_returnarray[0] = Symbol.lookupConstantSymbol(self);
      return (_return_temp);
    }
  }

  public static boolean constantSymbolP(Symbol symbol) {
    return (Symbol.lookupConstantSymbol(symbol) != null);
  }

  public static Surrogate lookupConstantSymbol(Symbol self) {
    if (self == Stella.SYM_STELLA_NULL) {
      return (Stella.SGT_STELLA_UNKNOWN);
    }
    else if (self == Stella.SYM_STELLA_TRUE) {
      return (Stella.SGT_STELLA_BOOLEAN);
    }
    else if (self == Stella.SYM_STELLA_FALSE) {
      return (Stella.SGT_STELLA_BOOLEAN);
    }
    else {
      return (null);
    }
  }

  public static Symbol trueVariableName(Symbol variable) {
    if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) {
      { Stella_Object alias = Symbol.getLocalVariableInfo(variable, Stella.KWD_ALIAS);

        if (alias != null) {
          return (((Symbol)(alias)));
        }
      }
    }
    return (variable);
  }

  public static void maybeRenameLocalVariable(Symbol variable) {
    if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) {
      { KvCons cursor = ((KeyValueList)(Stella.$LOCALVARIABLETYPETABLE$.get())).theKvList;
        int level = -1;

        while (cursor != null) {
          if (Symbol.variableEqlP(((Symbol)(cursor.key)), variable)) {
            level = level + 1;
          }
          cursor = cursor.rest;
        }
        if (level >= 1) {
          Symbol.setLocalVariableInfo(variable, Stella.KWD_ALIAS, Symbol.yieldLocalVariableAlias(variable, level));
        }
      }
    }
  }

  public static Symbol yieldLocalVariableAlias(Symbol variable, int level) {
    if (!(level >= 1)) {
      System.err.print("Safety violation: INTERNAL ERROR: Variable level must be >= 1");
    }
    if (((KeyValueList)(Stella.$LOCALGENSYMTABLE$.get())) == null) {
      return (Stella.localGensym(variable.symbolName));
    }
    { Cons aliases = ((Cons)(((KeyValueList)(Stella.$LOCALGENSYMTABLE$.get())).lookup(variable)));
      Symbol alias = null;

      if (aliases == null) {
        aliases = Stella.NIL;
      }
      if (aliases.length() < level) {
        alias = Stella.localGensym(variable.symbolName);
        ((KeyValueList)(Stella.$LOCALGENSYMTABLE$.get())).insertAt(variable, aliases.concatenate(Cons.cons(alias, Stella.NIL), Stella.NIL));
        return (alias);
      }
      else {
        return (((Symbol)(aliases.nth(level - 1))));
      }
    }
  }

  public static void registerReferenceToGlobalVariable(Symbol variablename) {
    if (((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())) != null) {
      { GlobalVariable global = variablename.lookupGlobalVariable();
        List referencedglobals = ((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())).referencedGlobals;

        if ((global != null) &&
            (!referencedglobals.memberP(global))) {
          referencedglobals.insert(global);
        }
      }
    }
  }

  public static Stella_Object getLocalVariableInfo(Symbol variable, Keyword key) {
    { StandardObject entry = ((((KeyValueList)(Stella.$LOCALVARIABLETYPETABLE$.get())) != null) ? ((StandardObject)(KeyValueList.lookupVariableTable(((KeyValueList)(Stella.$LOCALVARIABLETYPETABLE$.get())), variable))) : ((StandardObject)(null)));

      if (entry != null) {
        if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(entry), Stella.SGT_STELLA_KEY_VALUE_LIST)) {
          { KeyValueList entry000 = ((KeyValueList)(entry));

            return (entry000.lookup(key));
          }
        }
        else {
          if (key == Stella.KWD_TYPE) {
            return (entry);
          }
        }
      }
      return (null);
    }
  }

  public static void setLocalVariableInfo(Symbol variable, Keyword key, Stella_Object info) {
    { StandardObject entry = ((StandardObject)(KeyValueList.lookupVariableTable(((KeyValueList)(Stella.$LOCALVARIABLETYPETABLE$.get())), variable)));

      if (entry != null) {
        if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(entry), Stella.SGT_STELLA_KEY_VALUE_LIST)) {
          { KeyValueList entry000 = ((KeyValueList)(entry));

            entry000.insertAt(key, info);
          }
        }
        else {
          { KeyValueList variableinfo = KeyValueList.newKeyValueList();

            variableinfo.insertAt(key, info);
            variableinfo.insertAt(Stella.KWD_TYPE, entry);
            KeyValueList.insertAtVariableTable(((KeyValueList)(Stella.$LOCALVARIABLETYPETABLE$.get())), variable, variableinfo);
          }
        }
      }
    }
  }

  public static StandardObject lookupVariableType(Symbol variablename) {
    { StandardObject entry = ((((KeyValueList)(Stella.$LOCALVARIABLETYPETABLE$.get())) != null) ? ((StandardObject)(KeyValueList.lookupVariableTable(((KeyValueList)(Stella.$LOCALVARIABLETYPETABLE$.get())), variablename))) : ((StandardObject)(null)));
      StandardObject type = null;

      if (entry == null) {
        if (variablename == Stella.SYM_STELLA_NULL) {
          return (Stella.SGT_STELLA_UNKNOWN);
        }
        type = Symbol.lookupGlobalVariableType(variablename);
        Symbol.registerReferenceToGlobalVariable(variablename);
      }
      else {
        if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(entry), Stella.SGT_STELLA_KEY_VALUE_LIST)) {
          { KeyValueList entry000 = ((KeyValueList)(entry));

            type = ((StandardObject)(entry000.lookup(Stella.KWD_TYPE)));
          }
        }
        else {
          type = entry;
        }
      }
      if (type == null) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Undeclared variable `" + Stella_Object.deUglifyParseTree(variablename) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        return (Stella.SGT_STELLA_UNKNOWN);
      }
      if (type == Stella.SGT_STELLA_UNINITIALIZED) {
        { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Reference to defined but uninitialized variable `" + Stella_Object.deUglifyParseTree(variablename) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
          }
        }
        return (Stella.SGT_STELLA_UNKNOWN);
      }
      return (type);
    }
  }

  public static void pushVariableBinding(Symbol variable, StandardObject type) {
    { Stella_Class renamed_Class = StandardObject.typeSpecToClass(type);

      if (variable == null) {
        return;
      }
      if ((renamed_Class == null) &&
          (!(type == Stella.SGT_STELLA_UNINITIALIZED))) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" No class defined for type: `" + StandardObject.typeSpecToBaseType(type) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        type = Stella.SGT_STELLA_UNKNOWN;
      }
      if ((!((!Stella.translateToSingleInheritanceLanguageP()) ||
          (!(Stella.$MIXIN_IMPLEMENTATION_STYLE$ == Stella.KWD_SECOND_CLASS)))) &&
          ((renamed_Class != null) &&
           (renamed_Class.mixinP &&
            ((((MethodSlot)(Stella.$METHODBEINGWALKED$.get())) == null) ||
             ((!Slot.mixinMethodP(((MethodSlot)(Stella.$METHODBEINGWALKED$.get())))) ||
              ((KeyValueList)(Stella.$LOCALVARIABLETYPETABLE$.get())).nonEmptyP()))))) {
        { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Variable `" + Stella_Object.deUglifyParseTree(variable) + "' is typed with a mixin class which is");
                Stella.STANDARD_ERROR.nativeStream.println(" illegal when translating to a single-inheritance language.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
          }
        }
      }
      ((KeyValueList)(Stella.$LOCALVARIABLETYPETABLE$.get())).theKvList = KvCons.kvCons(variable, type, ((KeyValueList)(Stella.$LOCALVARIABLETYPETABLE$.get())).theKvList);
      Symbol.maybeRenameLocalVariable(variable);
    }
  }

  public static boolean variableEqlP(Symbol var1, Symbol var2) {
    return ((var1 == var2) ||
        Stella.stringEqlP(var1.symbolName, var2.symbolName));
  }

  public static boolean declarationOperatorP(Symbol operator) {
    return (Stella.getQuotedTree("((DEFCLASS DEFSLOT DEFMETHOD DEFUN DEFTYPE DEFGLOBAL DEFSPECIAL DEFCONSTANT DEFMACRO DEFMODULE STARTUP-TIME-PROGN) \"/STELLA\")", "/STELLA").memberP(operator));
  }

  public static Cons yieldCollectCode(Symbol collectvariable, Stella_Object intovariable, Stella_Object collecttree) {
    { Surrogate intovariabletype = StandardObject.typeSpecToBaseType(Symbol.lookupVariableType(((Symbol)(intovariable))));

      if (Surrogate.subtypeOfP(intovariabletype, Stella.SGT_STELLA_LIST)) {
        return (Symbol.yieldCollectIntoListCode(collectvariable, intovariable, collecttree));
      }
      else if (Surrogate.subtypeOfP(intovariabletype, Stella.SGT_STELLA_CONS)) {
        return (Symbol.yieldCollectIntoConsCode(collectvariable, intovariable, collecttree));
      }
      else if (intovariabletype == Stella.SGT_STELLA_UNKNOWN) {
        return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NULLp, Cons.cons(collectvariable, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(collectvariable, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CONS, Cons.cons(collecttree, Cons.cons(Cons.cons(Stella.SYM_STELLA_NIL, Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_COND, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NILp, Cons.cons(intovariable, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(intovariable, Cons.cons(Cons.cons(collectvariable, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CONSp, Cons.cons(intovariable, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ADD_CONS_TO_END_OF_CONS_LIST, Cons.cons(intovariable, Cons.cons(Cons.cons(collectvariable, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OTHERWISE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_EMPTYp, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_CONS_LIST, Cons.cons(intovariable, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_CONS_LIST, Cons.cons(intovariable, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(collectvariable, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ADD_CONS_TO_END_OF_CONS_LIST, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_CONS_LIST, Cons.cons(intovariable, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(collectvariable, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_REST, Cons.cons(collectvariable, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CONS, Cons.cons(Stella_Object.copyConsTree(collecttree), Cons.cons(Cons.cons(Stella.SYM_STELLA_NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(collectvariable, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_REST, Cons.cons(collectvariable, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Stella.NIL));
      }
      else {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Can't collect into a datatype other than LIST or CONS..");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        return (Stella_Object.walkDontCallMeTree(collecttree, Stella.SGT_STELLA_VOID, new Object[1]));
      }
    }
  }

  public static Cons yieldCollectIntoConsCode(Symbol collectvariable, Stella_Object intovariable, Stella_Object collecttree) {
    return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NULLp, Cons.cons(collectvariable, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(collectvariable, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CONS, Cons.cons(collecttree, Cons.cons(Cons.cons(Stella.SYM_STELLA_NIL, Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NILp, Cons.cons(intovariable, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(intovariable, Cons.cons(Cons.cons(collectvariable, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ADD_CONS_TO_END_OF_CONS_LIST, Cons.cons(intovariable, Cons.cons(Cons.cons(collectvariable, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_REST, Cons.cons(collectvariable, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CONS, Cons.cons(Stella_Object.copyConsTree(collecttree), Cons.cons(Cons.cons(Stella.SYM_STELLA_NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(collectvariable, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_REST, Cons.cons(collectvariable, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Stella.NIL));
  }

  public static Cons yieldCollectIntoListCode(Symbol collectvariable, Stella_Object intovariable, Stella_Object collecttree) {
    return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NULLp, Cons.cons(collectvariable, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(collectvariable, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CONS, Cons.cons(collecttree, Cons.cons(Cons.cons(Stella.SYM_STELLA_NIL, Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_EMPTYp, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_CONS_LIST, Cons.cons(intovariable, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_CONS_LIST, Cons.cons(intovariable, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(collectvariable, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ADD_CONS_TO_END_OF_CONS_LIST, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_CONS_LIST, Cons.cons(intovariable, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(collectvariable, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_REST, Cons.cons(collectvariable, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CONS, Cons.cons(Stella_Object.copyConsTree(collecttree), Cons.cons(Cons.cons(Stella.SYM_STELLA_NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(collectvariable, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_REST, Cons.cons(collectvariable, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Stella.NIL));
  }

  public static Stella_Object extractOptionAndResidue(Symbol option, Cons tail, Object [] MV_returnarray) {
    if (!(tail.value == option)) {
      { Stella_Object _return_temp = null;

        MV_returnarray[0] = tail;
        return (_return_temp);
      }
    }
    { Stella_Object argument = null;
      Cons residue = null;

      argument = tail.rest.value;
      residue = tail.rest.rest;
      { Stella_Object _return_temp = argument;

        MV_returnarray[0] = residue;
        return (_return_temp);
      }
    }
  }

  public static MethodSlot getMethodWithIdenticalSignature(Symbol name, Cons parameterstree, String stringifiedsource) {
    { Slot existingslot = null;

      if (Stella_Object.consP(parameterstree.value)) {
        parameterstree = ((Cons)(parameterstree.value));
        if (Stella_Object.symbolP(parameterstree.last())) {
          existingslot = Stella_Class.lookupSlot(StandardObject.typeSpecToClass(parameterstree.last().yieldTypeSpecifier()), name);
          if (existingslot != null) {
            if (Surrogate.subtypeOfMethodSlotP(Stella_Object.safePrimaryType(existingslot))) {
              { MethodSlot existingslot000 = ((MethodSlot)(existingslot));

                if (Stella.stringEqlP(existingslot000.methodStringifiedSource, stringifiedsource)) {
                  return (existingslot000);
                }
              }
            }
            else {
            }
          }
        }
      }
      return (null);
    }
  }

  public static MethodSlot getFunctionWithIdenticalSignature(Symbol name, String stringifiedsource) {
    { MethodSlot oldmethod = Symbol.lookupFunction(name);

      if ((oldmethod != null) &&
          Stella.stringEqlP(oldmethod.methodStringifiedSource, stringifiedsource)) {
        return (oldmethod);
      }
      return (null);
    }
  }

  public static Symbol yieldSetterMethodName(Symbol methodname) {
    { String baseName = methodname.symbolName;
      String suffix = (Stella.allUpperCaseStringP(baseName) ? "-SETTER" : "-Setter");

      return (Symbol.internDerivedSymbol(methodname, baseName + suffix));
    }
  }

  public static MethodSlot defineInlineMethod(Symbol name, Cons parametersandbody) {
    { Cons parsetree = null;
      MethodSlot method = null;

      parsetree = Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFMETHOD, Cons.cons(name, Cons.cons(parametersandbody.concatenate(Stella.NIL, Stella.NIL), Stella.NIL))));
      method = Cons.helpDefineMethodFromParseTree(parsetree, Native.stringify(parsetree), new Object[1]);
      return (method);
    }
  }

  public static Cons matchPatternElement(Symbol patternElement, Stella_Object datumElement) {
    if (Stella_Object.isaP(datumElement, Stella.SGT_STELLA_CONS)) {
      { Stella_Object datumType = ((((Cons)(datumElement)).value == Stella.SYM_STELLA_SPECIAL) ? ((Cons)(datumElement)).rest.value : ((Cons)(datumElement)).value);

        if (datumType == patternElement) {
          return (((Cons)(datumElement)));
        }
        else {
          return (Stella.NIL);
        }
      }
    }
    else if (((Cons)(Stella.$SPECIAL_SYMBOLS$.get())).memberP(patternElement)) {
      return (Stella.NIL);
    }
    else {
      { java.lang.reflect.Method function = Symbol.lookupFunction(patternElement).functionCode;
        Stella_Object match = ((Stella_Object)(edu.isi.stella.javalib.Native.funcall(function, null, new java.lang.Object [] {datumElement})));

        if (Surrogate.subtypeOfBooleanP(Stella_Object.safePrimaryType(match))) {
          { BooleanWrapper match000 = ((BooleanWrapper)(match));

            if (BooleanWrapper.coerceWrappedBooleanToBoolean(match000)) {
              return (Cons.consList(Cons.cons(patternElement, Cons.cons(datumElement, Stella.NIL))));
            }
            else {
              return (Stella.NIL);
            }
          }
        }
        else {
          if (match != null) {
            return (Cons.consList(Cons.cons(patternElement, Cons.cons(match, Stella.NIL))));
          }
          else {
            return (Stella.NIL);
          }
        }
      }
    }
  }

  static Stella_Object defineTimeComparison(Symbol name, Symbol operator, Symbol errorP) {
    { Cons otherwiseClause = ((errorP == Stella.SYM_STELLA_TRUE) ? Cons.list$(Cons.cons(Stella.SYM_STELLA_SIGNAL, Cons.cons(Stella.SYM_STELLA_INCOMPATIBLE_QUANTITY_EXCEPTION, Cons.cons(StringWrapper.wrapString("Can't compare calendar date "), Cons.cons(Stella.SYM_STELLA_T1, Cons.cons(StringWrapper.wrapString(" with object "), Cons.cons(Stella.SYM_STELLA_T2, Cons.cons(Stella.NIL, Stella.NIL)))))))) : Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_FALSE, Cons.cons(Stella.NIL, Stella.NIL)))));

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFMETHOD, Cons.cons(Cons.cons(name, Cons.cons(Stella.SYM_STELLA_BOOLEAN, Stella.NIL)), Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_T1, Cons.cons(Stella.SYM_STELLA_CALENDAR_DATE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_T2, Cons.cons(Stella.SYM_STELLA_OBJECT, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TYPECASE, Cons.cons(Stella.SYM_STELLA_T2, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CALENDAR_DATE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_e, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_MODIFIED_JULIAN_DAY, Cons.cons(Stella.SYM_STELLA_T1, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_MODIFIED_JULIAN_DAY, Cons.cons(Stella.SYM_STELLA_T2, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Cons.cons(operator, Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TIME_MILLIS, Cons.cons(Stella.SYM_STELLA_T1, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TIME_MILLIS, Cons.cons(Stella.SYM_STELLA_T2, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Cons.cons(operator, Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_MODIFIED_JULIAN_DAY, Cons.cons(Stella.SYM_STELLA_T1, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_MODIFIED_JULIAN_DAY, Cons.cons(Stella.SYM_STELLA_T2, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OTHERWISE, Cons.cons(Cons.copyConsList(otherwiseClause), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFMETHOD, Cons.cons(Cons.cons(name, Cons.cons(Stella.SYM_STELLA_BOOLEAN, Stella.NIL)), Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_T1, Cons.cons(Stella.SYM_STELLA_TIME_DURATION, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_T2, Cons.cons(Stella.SYM_STELLA_OBJECT, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TYPECASE, Cons.cons(Stella.SYM_STELLA_T2, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TIME_DURATION, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_e, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DAYS, Cons.cons(Stella.SYM_STELLA_T1, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DAYS, Cons.cons(Stella.SYM_STELLA_T2, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Cons.cons(operator, Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_MILLIS, Cons.cons(Stella.SYM_STELLA_T1, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_MILLIS, Cons.cons(Stella.SYM_STELLA_T2, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Cons.cons(operator, Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DAYS, Cons.cons(Stella.SYM_STELLA_T1, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DAYS, Cons.cons(Stella.SYM_STELLA_T2, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OTHERWISE, Cons.cons(Cons.copyConsList(otherwiseClause), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))));
    }
  }

  public static StandardObject lookupGlobalVariableType(Symbol name) {
    { GlobalVariable global = name.lookupGlobalVariable();

      if (global != null) {
        return (GlobalVariable.globalVariableTypeSpec(global));
      }
      else {
        return (null);
      }
    }
  }

  public static void undefineFunction(Symbol name) {
    { MethodSlot function = Symbol.lookupFunction(name);

      if (function != null) {
        MethodSlot.destroyFunction(function);
      }
    }
  }

  public static Module lookupFunctionHomeModule(Symbol functionsymbol) {
    functionsymbol = functionsymbol.softPermanentify();
    { StandardObject function = ((StandardObject)(Stella.$FUNCTION_LOOKUP_TABLE$.lookup(functionsymbol)));

      if (function == null) {
        return (null);
      }
      { Surrogate testValue000 = function.primaryType();

        if (testValue000 == Stella.SGT_STELLA_VECTOR) {
          return (Stella.getStellaModule(((StringWrapper)((((Vector)(function)).theArray)[2])).wrapperValue, true));
        }
        else if (testValue000 == Stella.SGT_STELLA_METHOD_SLOT) {
          return (function.homeModule());
        }
        else {
          return (null);
        }
      }
    }
  }

  public static MethodSlot lookupFunctionOrStellaFunction(Symbol functionsymbol) {
    return (Symbol.lookupFunction(functionsymbol));
  }

  /** Return the function defined for 'functionSymbol', if it exists.
   * @param functionsymbol
   * @return MethodSlot
   */
  public static MethodSlot lookupFunction(Symbol functionsymbol) {
    functionsymbol = functionsymbol.softPermanentify();
    { StandardObject function = ((StandardObject)(Stella.$FUNCTION_LOOKUP_TABLE$.lookup(functionsymbol)));

      if ((function != null) &&
          (function.primaryType() == Stella.SGT_STELLA_VECTOR)) {
        { Vector record = ((Vector)(function));
          String definition = ((StringWrapper)((record.theArray)[0])).wrapperValue;
          MethodSlot oldfunction = ((MethodSlot)((record.theArray)[1]));
          String modulename = ((StringWrapper)((record.theArray)[2])).wrapperValue;
          java.lang.reflect.Method code = (((record.theArray)[3] != null) ? ((FunctionCodeWrapper)((record.theArray)[3])).wrapperValue : null);
          java.lang.reflect.Method wrappercode = ((record.length() >= 5) ? ((FunctionCodeWrapper)((record.theArray)[4])).wrapperValue : null);

          Stella.$FUNCTION_LOOKUP_TABLE$.insertAt(functionsymbol, oldfunction);
          { Object old$Module$000 = Stella.$MODULE$.get();
            Object old$Context$000 = Stella.$CONTEXT$.get();

            try {
              Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule(modulename, true));
              Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
              function = Stella.defineMethodFromStringifiedSource(functionsymbol.symbolName, null, definition);

            } finally {
              Stella.$CONTEXT$.set(old$Context$000);
              Stella.$MODULE$.set(old$Module$000);
            }
          }
          if (function != null) {
            if (code != null) {
              ((MethodSlot)(function)).functionCode = code;
            }
            if (wrappercode != null) {
              KeyValueList.setDynamicSlotValue(((MethodSlot)(function)).dynamicSlots, Stella.SYM_STELLA_EVALUATOR_WRAPPER_CODE, FunctionCodeWrapper.wrapFunctionCode(wrappercode), Stella.NULL_FUNCTION_CODE_WRAPPER);
            }
          }
        }
      }
      return (((MethodSlot)(function)));
    }
  }

  public static void undefineExternalSlots(Symbol name) {
    { Cons slots = Stella.NIL;

      { Module module = null;
        Iterator iter000 = Stella.allModules();

        while (iter000.nextP()) {
          module = ((Module)(iter000.value));
          { Slot slot = null;
            Iterator iter001 = Module.allSlots(module, true);
            Cons collect000 = null;

            while (iter001.nextP()) {
              slot = ((Slot)(iter001.value));
              if ((slot.slotName == name) &&
                  slot.slotExternalP) {
                if (collect000 == null) {
                  {
                    collect000 = Cons.cons(slot, Stella.NIL);
                    if (slots == Stella.NIL) {
                      slots = collect000;
                    }
                    else {
                      Cons.addConsToEndOfConsList(slots, collect000);
                    }
                  }
                }
                else {
                  {
                    collect000.rest = Cons.cons(slot, Stella.NIL);
                    collect000 = collect000.rest;
                  }
                }
              }
            }
          }
        }
      }
      { Stella_Object slot = null;
        Cons iter002 = slots;

        for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
          slot = iter002.value;
          Slot.destroyExternalSlot(((Slot)(slot)));
        }
      }
    }
  }

  /** Define a new Stella method object (a slot), and attach it
   * to the class identified by the first parameter in 'inputParameters'.
   * @param inputname
   * @param returntypes
   * @param functionP
   * @param inputparameters
   * @param options
   * @return MethodSlot
   */
  public static MethodSlot defineStellaMethodSlot(Symbol inputname, Cons returntypes, boolean functionP, Cons inputparameters, KeywordKeyValueList options) {
    { MethodSlot newmethod = MethodSlot.newMethodSlot();
      Symbol name = ((Symbol)(inputname.permanentify()));

      newmethod.slotName = name;
      newmethod.methodFunctionP = functionP;
      MethodSlot.incorporateInputParameters(newmethod, inputparameters);
      MethodSlot.incorporateFirstInputParameter(newmethod);
      if (returntypes == Stella.NIL) {
        if (options.lookup(Stella.KWD_TYPE) != null) {
          returntypes = Cons.cons(options.lookup(Stella.KWD_TYPE), Stella.NIL);
        }
        else if (options.lookup(Stella.KWD_RETURN_TYPES) != null) {
          returntypes = Cons.cons(options.lookup(Stella.KWD_RETURN_TYPES), Stella.NIL);
        }
      }
      { StandardObject typespec = ((returntypes == Stella.NIL) ? Stella.SGT_STELLA_VOID : ((StandardObject)(returntypes.value.yieldTypeSpecifier())));

        if (Stella_Object.typeP(typespec)) {
          newmethod.slotBaseType = ((Surrogate)(typespec));
        }
        else {
          KeyValueList.setDynamicSlotValue(newmethod.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, ((CompoundTypeSpecifier)(typespec)), null);
        }
      }
      if (!(returntypes == Stella.NIL)) {
        newmethod.methodReturnTypeSpecifiers = List.newList();
      }
      { Stella_Object ts = null;
        Cons iter000 = returntypes;
        List into000 = newmethod.methodReturnTypeSpecifiers();
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          ts = iter000.value;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(ts.yieldTypeSpecifier(), Stella.NIL);
              if (into000.theConsList == Stella.NIL) {
                into000.theConsList = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(into000.theConsList, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(ts.yieldTypeSpecifier(), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      { Keyword key = null;
        Stella_Object value = null;
        KvListIterator iter001 = ((KvListIterator)(options.allocateIterator()));

        while (iter001.nextP()) {
          key = ((Keyword)(iter001.key));
          value = iter001.value;
          { Keyword testValue000 = ((Keyword)(key));

            if (testValue000 == Stella.KWD_PUBLICp) {
              newmethod.slotPublicP = ((BooleanWrapper)(value)).wrapperValue;
            }
            else if (testValue000 == Stella.KWD_ABSTRACTp) {
              newmethod.abstractP = ((BooleanWrapper)(value)).wrapperValue;
            }
            else if (testValue000 == Stella.KWD_NATIVEp) {
              KeyValueList.setDynamicSlotValue(newmethod.dynamicSlots, Stella.SYM_STELLA_METHOD_NATIVEp, (((BooleanWrapper)(value)).wrapperValue ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.FALSE_WRAPPER);
            }
            else if (testValue000 == Stella.KWD_CONSTRUCTORp) {
              KeyValueList.setDynamicSlotValue(newmethod.dynamicSlots, Stella.SYM_STELLA_METHOD_CONSTRUCTORp, (((BooleanWrapper)(value)).wrapperValue ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.FALSE_WRAPPER);
            }
            else if (testValue000 == Stella.KWD_GLOBALLY_INLINEp) {
              KeyValueList.setDynamicSlotValue(newmethod.dynamicSlots, Stella.SYM_STELLA_METHOD_GLOBALLY_INLINEp, (((BooleanWrapper)(value)).wrapperValue ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.FALSE_WRAPPER);
            }
            else if (testValue000 == Stella.KWD_INLINE) {
              if (newmethod.methodInlinedFunctions().emptyP()) {
                KeyValueList.setDynamicSlotValue(newmethod.dynamicSlots, Stella.SYM_STELLA_METHOD_INLINED_FUNCTIONS, List.newList(), null);
              }
              { Surrogate testValue001 = Stella_Object.safePrimaryType(value);

                if (testValue001 == Stella.SGT_STELLA_CONS) {
                  { Cons value000 = ((Cons)(value));

                    { Stella_Object fnname = null;
                      Cons iter002 = value000;

                      for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                        fnname = iter002.value;
                        newmethod.methodInlinedFunctions().insert(((Symbol)(fnname)));
                      }
                    }
                  }
                }
                else if (Surrogate.subtypeOfSymbolP(testValue001)) {
                  { Symbol value000 = ((Symbol)(value));

                    newmethod.methodInlinedFunctions().insert(value000);
                  }
                }
                else {
                  Stella.STANDARD_WARNING.nativeStream.println("Warning: Illegal :inline argument: `" + value + "'");
                }
              }
            }
            else if (testValue000 == Stella.KWD_AUXILIARYp) {
              KeyValueList.setDynamicSlotValue(newmethod.dynamicSlots, Stella.SYM_STELLA_SLOT_AUXILIARYp, (((BooleanWrapper)(value)).wrapperValue ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.FALSE_WRAPPER);
            }
            else if (testValue000 == Stella.KWD_DOCUMENTATION) {
              KeyValueList.setDynamicSlotValue(newmethod.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, StringWrapper.wrapString(((StringWrapper)(value)).wrapperValue), Stella.NULL_STRING_WRAPPER);
            }
            else if ((testValue000 == Stella.KWD_TYPE) ||
                (testValue000 == Stella.KWD_RETURNS)) {
            }
            else if (testValue000 == Stella.KWD_STORAGE_SLOT) {
              KeyValueList.setDynamicSlotValue(newmethod.dynamicSlots, Stella.SYM_STELLA_STORAGE_SLOT, ((Symbol)(((Symbol)(value)).permanentify())), null);
            }
            else if (testValue000 == Stella.KWD_INHERITS_THROUGH) {
              KeyValueList.setDynamicSlotValue(newmethod.dynamicSlots, Stella.SYM_STELLA_METHOD_INHERITS_THROUGH, ((Symbol)(((Symbol)(value)).permanentify())), null);
            }
            else if (testValue000 == Stella.KWD_PROPERTIES) {
              KeyValueList.setDynamicSlotValue(newmethod.dynamicSlots, Stella.SYM_STELLA_PROPERTIES, ((List)(value)), null);
            }
            else if (testValue000 == Stella.KWD_META_ATTRIBUTES) {
              KeyValueList.setDynamicSlotValue(newmethod.dynamicSlots, Stella.SYM_STELLA_META_ATTRIBUTES, ((KeyValueList)(value)), null);
            }
            else if (testValue000 == Stella.KWD_COMMANDp) {
              KeyValueList.setDynamicSlotValue(newmethod.dynamicSlots, Stella.SYM_STELLA_METHOD_COMMANDp, (((BooleanWrapper)(value)).wrapperValue ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.FALSE_WRAPPER);
            }
            else if (testValue000 == Stella.KWD_LISP_MACROp) {
              KeyValueList.setDynamicSlotValue(newmethod.dynamicSlots, Stella.SYM_STELLA_METHOD_LISP_MACROp, (((BooleanWrapper)(value)).wrapperValue ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), null);
            }
            else if (testValue000 == Stella.KWD_EVALUATE_ARGUMENTSp) {
              KeyValueList.setDynamicSlotValue(newmethod.dynamicSlots, Stella.SYM_STELLA_METHOD_EVALUATE_ARGUMENTSp, (((BooleanWrapper)(value)).wrapperValue ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.FALSE_WRAPPER);
            }
            else {
              if (!(Stella_Object.runOptionHandlerP(newmethod, key, value))) {
                { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationWarning();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
                      {
                        Stella.STANDARD_WARNING.nativeStream.println();
                        Stella.STANDARD_WARNING.nativeStream.println(" Skipping invalid method option `" + Stella_Object.deUglifyParseTree(key) + "'");
                        Stella.STANDARD_WARNING.nativeStream.println("in the definition of method `" + newmethod.slotOwner + "'.`" + Stella_Object.deUglifyParseTree(name) + "'.");
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
        }
      }
      return (newmethod);
    }
  }

  public StandardObject yieldTypeSpecifier() {
    { Symbol typespectree = this;

      return (Surrogate.realTypeSpecifier(Stella_Object.typify(typespectree)));
    }
  }

  /** Return <code>true</code> if <code>slotName</code> is the name of some registered;
   * slot in the system.
   * @param slotName
   * @return boolean
   */
  public static boolean registeredSlotNameP(Symbol slotName) {
    return (slotName.symbolSlotOffset != Stella.NULL_INTEGER);
  }

  public static Slot defineStellaSlot(Symbol name, Surrogate owner, Surrogate basetype, Cons typespecifier, KeywordKeyValueList options) {
    { StorageSlot slot = StorageSlot.newStorageSlot();

      slot.slotName = name;
      slot.slotOwner = owner;
      slot.slotBaseType = basetype;
      if (!(typespecifier == Stella.NIL)) {
        KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, ((CompoundTypeSpecifier)(typespecifier.yieldTypeSpecifier())), null);
      }
      { Keyword key = null;
        Stella_Object value = null;
        KvListIterator iter000 = ((KvListIterator)(options.allocateIterator()));

        while (iter000.nextP()) {
          key = ((Keyword)(iter000.key));
          value = iter000.value;
          if (key == Stella.KWD_PUBLICp) {
            slot.slotPublicP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
          }
          else if (key == Stella.KWD_REQUIREDp) {
            slot.slotRequiredP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
          }
          else if (key == Stella.KWD_COMPONENTp) {
            slot.slotComponentP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
          }
          else if (key == Stella.KWD_READ_ONLYp) {
            slot.slotReadOnlyP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
          }
          else if (key == Stella.KWD_ACTIVEp) {
            KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_STORED_ACTIVEp, ((BooleanWrapper)(value)), null);
          }
          else if (key == Stella.KWD_CONTEXT_SENSITIVEp) {
            slot.slotContextSensitiveP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
          }
          else if (key == Stella.KWD_HARDWIREDp) {
            slot.slotHardwiredP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
          }
          else if (key == Stella.KWD_ABSTRACTp) {
            slot.abstractP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
          }
          else if (key == Stella.KWD_ALLOCATION) {
            if (value == Stella.KWD_CLASS) {
              {
                Stella.STANDARD_WARNING.nativeStream.println("Warning: In definition of slot `" + slot + "': ':class' allocation is unsupported right now.");
                Stella.STANDARD_WARNING.nativeStream.println(" Maybe use ':hardwired? TRUE' for read-only slots.");
              }
;
            }
            else {
              KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_ALLOCATION, ((Keyword)(value)), null);
            }
          }
          else if (key == Stella.KWD_INITIALLY) {
            KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_INITIAL_VALUE, value, null);
          }
          else if (key == Stella.KWD_DEFAULT) {
            KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_DEFAULT_EXPRESSION, value, null);
          }
          else if (key == Stella.KWD_READER) {
            KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_READER, ((Symbol)(value)), null);
          }
          else if (key == Stella.KWD_WRITER) {
            KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_WRITER, ((Symbol)(value)), null);
          }
          else if (key == Stella.KWD_INVERSE) {
            KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_INVERSE, ((Symbol)(value)), null);
          }
          else if (key == Stella.KWD_RENAMES) {
            KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_RENAMES, ((Symbol)(value)), null);
          }
          else if (key == Stella.KWD_DOCUMENTATION) {
            KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, StringWrapper.wrapString(((StringWrapper)(value)).wrapperValue), Stella.NULL_STRING_WRAPPER);
          }
          else if (key == Stella.KWD_PROPERTIES) {
            KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_PROPERTIES, ((List)(value)), null);
          }
          else if (key == Stella.KWD_META_ATTRIBUTES) {
            KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_META_ATTRIBUTES, ((KeyValueList)(value)), null);
          }
          else if (key == Stella.KWD_OPTION_KEYWORD) {
            KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_OPTION_KEYWORD, ((Keyword)(value)), null);
          }
          else if (key == Stella.KWD_OPTION_HANDLER) {
            KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_OPTION_HANDLER, ((Symbol)(value)), null);
          }
          else {
            if (!(Stella_Object.runOptionHandlerP(slot, key, value))) {
              { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationWarning();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
                    {
                      Stella.STANDARD_WARNING.nativeStream.println();
                      Stella.STANDARD_WARNING.nativeStream.println(" Skipping invalid slot option `" + Stella_Object.deUglifyParseTree(key) + "'");
                      Stella.STANDARD_WARNING.nativeStream.println("in the definition of slot `" + Symbol.internSymbolInModule(owner.symbolName, ((Module)(owner.homeContext)), true) + "'.`" + Stella_Object.deUglifyParseTree(name) + "'.");
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
      }
      if ((slot.slotAllocation() == null) &&
          (basetype == Stella.SGT_STELLA_BOOLEAN)) {
        KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_ALLOCATION, Stella.KWD_BIT, null);
      }
      return (slot);
    }
  }

  /** Return a class with name <code>className</code>.  If non exists, break
   * if <code>errorP</code>, else return <code>null</code>.
   * @param errorP
   * @return Stella_Class
   */
  public Stella_Class getStellaClass(boolean errorP) {
    { Symbol className = this;

      return (Stella.string_getStellaClass(className.symbolName, errorP));
    }
  }

  /** Return a class with name <code>name</code>.  Scan all
   * visible surrogates looking for one that has a class defined for it.
   * @return Stella_Class
   */
  public Stella_Class lookupClass() {
    { Symbol name = this;

      { Object old$Module$000 = Stella.$MODULE$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, ((Module)(name.homeContext)));
          return (Stella.string_lookupClass(name.symbolName));

        } finally {
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  public Symbol softPermanentify() {
    { Symbol symbol = this;

      return (symbol);
    }
  }

  public Stella_Object permanentify() {
    { Symbol self = this;

      return (self);
    }
  }

  public static void printSymbol(Symbol self, edu.isi.stella.javalib.NativeOutputStream stream) {
    { boolean visibleP = self == Symbol.lookupSymbolInModule(self.symbolName, ((Module)(Stella.$MODULE$.get())), false);
      Module module = ((Module)(self.homeContext));

      if (!visibleP) {
        if (self.symbolId == -1) {
          stream.print("<<UNINTERNED>>/");
        }
        else {
          if (module != null) {
            if (((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue() &&
                (module == Stella.$COMMON_LISP_MODULE$)) {
              {
                stream.print("CL:" + self.symbolName);
                return;
              }
            }
            else {
              stream.print(module.moduleFullName + "/");
            }
          }
        }
      }
      if (((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue()) {
        Stella.printSymbolNameReadably(self.symbolName, stream, ((Module)(Stella.$MODULE$.get())).caseSensitiveP);
      }
      else {
        stream.print(self.symbolName);
      }
    }
  }

  public static Stella_Object symbolPropertySetter(Symbol symbol, Stella_Object value, StandardObject key) {
    { Cons vplist = symbol.symbolValueAndPlist;
      Cons plist = vplist.rest;

      while (!(plist == Stella.NIL)) {
        if (plist.value == key) {
          if (value != null) {
            plist.rest.value = value;
          }
          else if (!(plist.rest.rest == Stella.NIL)) {
            { Cons restplist = plist.rest;

              plist.value = restplist.rest.value;
              plist.rest = restplist.rest.rest;
            }
          }
          else if (plist == vplist.rest) {
            vplist.rest = Stella.NIL;
          }
          else {
            plist.rest.value = value;
          }
          return (value);
        }
        plist = plist.rest.rest;
      }
      if (value != null) {
        if (vplist == Stella.NIL) {
          vplist = Cons.cons(null, Stella.NIL);
          symbol.symbolValueAndPlist = vplist;
        }
        vplist.rest = Cons.cons(key, Cons.cons(value, vplist.rest));
      }
      return (value);
    }
  }

  /** Return the property of <code>symbol</code> whose key is <code>eqP</code> to <code>key</code>.
   * Symbol properties can be set with <code>setf</code>.
   * @param symbol
   * @param key
   * @return Stella_Object
   */
  public static Stella_Object symbolProperty(Symbol symbol, StandardObject key) {
    { Cons plist = symbol.symbolValueAndPlist.rest;

      while (!(plist == Stella.NIL)) {
        if (plist.value == key) {
          return (plist.rest.value);
        }
        plist = plist.rest.rest;
      }
      return (null);
    }
  }

  public static Cons symbolPlistSetter(Symbol symbol, Cons plist) {
    { Cons vplist = symbol.symbolValueAndPlist;

      if (vplist == Stella.NIL) {
        vplist = Cons.cons(null, Stella.NIL);
        symbol.symbolValueAndPlist = vplist;
      }
      return (vplist.rest = plist);
    }
  }

  /** Return the property list of <code>symbol</code>.  The <code>symbolPlist</code>
   * of a symbol can be set with <code>setf</code>.  IMPORTANT: Property list are modified 
   * destructively, hence, if you supply it as a whole make sure to always supply
   * a modfiable copy, e.g., by using <code>bquote</code>.
   * @param symbol
   * @return Cons
   */
  public static Cons symbolPlist(Symbol symbol) {
    return (symbol.symbolValueAndPlist.rest);
  }

  public static Stella_Object symbolValueSetter(Symbol symbol, Stella_Object value) {
    { Cons vplist = symbol.symbolValueAndPlist;

      if (vplist == Stella.NIL) {
        vplist = Cons.cons(null, Stella.NIL);
        symbol.symbolValueAndPlist = vplist;
      }
      return (vplist.value = value);
    }
  }

  /** Return the value of <code>symbol</code>.  Note, that this value is not
   * visible to code that references a variable with the same name as <code>symbol</code>.
   * The <code>symbolValue</code> is simply a special property that can always be accessed
   * in constant time.  The <code>symbolValue</code> of a symbol can be changed with <code>setf</code>.
   * @param symbol
   * @return Stella_Object
   */
  public static Stella_Object symbolValue(Symbol symbol) {
    return (symbol.symbolValueAndPlist.value);
  }

  /** Return <code>true</code> if <code>self</code> is visible from the current module.
   * @param self
   * @return boolean
   */
  public static boolean visibleSymbolP(Symbol self) {
    return (self == Symbol.lookupSymbolInModule(self.symbolName, ((Module)(Stella.$MODULE$.get())), false));
  }

  /** Converts 'self' into a surrogate (same semantics
   * as <code>symbolToSurrogate</code> which see).
   * @return Surrogate
   */
  public Surrogate surrogatify() {
    { Symbol self = this;

      return (Symbol.symbolToSurrogate(self));
    }
  }

  /** Return a surrogate with the same name as 'self'.
   * Very tricky: The logic is designed to avoid returning an inherited surrogate
   * that has no value.  In that case, a new local surrogate is created that shadows
   * the inherited surrogate.  Unlike 'string-to-surrogate', the search starts first
   * from the home context of 'self', and if that fails, then it restarts in
   * *module*.
   * @param self
   * @return Surrogate
   */
  public static Surrogate symbolToSurrogate(Symbol self) {
    { Surrogate surrogate = Surrogate.lookupSurrogateInModule(self.symbolName, ((Module)(self.homeContext)), false);

      if ((surrogate != null) &&
          (surrogate.surrogateValue != null)) {
        return (surrogate);
      }
      return (Stella.stringToSurrogate(self.symbolName));
    }
  }

  /** Convert <code>self</code> into a surrogate with the same name and module.
   * @param self
   * @return Surrogate
   */
  public static Surrogate symbolToType(Symbol self) {
    return (Surrogate.internSurrogateInModule(self.symbolName, ((Module)(self.homeContext)), true));
  }

  public static boolean symbolCommonLispP(Symbol self) {
    return (((Module)(self.homeContext)) == Stella.$COMMON_LISP_MODULE$);
  }

  /** Remove <code>self</code> from its home module and the symbol table.
   * @param self
   */
  public static void uninternSymbol(Symbol self) {
    { ExtensibleSymbolArray symbolarray = Stella.selectSymbolArray(Stella.SYMBOL_SYM);
      StringToIntegerHashTable offsettable = ((((Module)(self.homeContext)) != null) ? Module.selectSymbolOffsetTable(((Module)(self.homeContext)), Stella.SYMBOL_SYM) : ((StringToIntegerHashTable)(null)));
      int symbolid = self.symbolId;
      Symbol realsymbol = Symbol.getSymFromOffset(symbolid);

      if (self == realsymbol) {
        ExtensibleSymbolArray.freeSymbolOffset(symbolarray, symbolid);
      }
      if ((offsettable != null) &&
          (symbolid == offsettable.lookup(self.symbolName))) {
        offsettable.removeAt(self.symbolName);
      }
      self.symbolId = -1;
      self.symbolValueAndPlist = null;
    }
  }

  /** Safe version of <code>importSymbol</code> (which see).  Only imports <code>symbol</code> if
   * no symbol with that name is currently interned or visible in <code>module</code>.
   * Returns <code>symbol</code> if it was imported or the conflicting symbol in <code>module</code>
   * otherwise.
   * @param symbol
   * @param module
   * @return Symbol
   */
  public static Symbol safeImportSymbol(Symbol symbol, Module module) {
    { String name = symbol.symbolName;
      Symbol modulesymbol = Symbol.lookupSymbolInModule(name, module, false);

      if ((modulesymbol != null) ||
          (((Module)(symbol.homeContext)) == null)) {
        return (modulesymbol);
      }
      else {
        return (Symbol.importSymbol(symbol, module));
      }
    }
  }

  /** Import <code>symbol</code> into <code>module</code> and return the imported <code>symbol</code>.
   * Signal an error if a different symbol with the same name already exists
   * locally in <code>module</code>.  Any symbol with the same name visible in <code>module</code> by
   * inheritance will be shadowed by the newly imported <code>symbol</code>.
   * @param symbol
   * @param module
   * @return Symbol
   */
  public static Symbol importSymbol(Symbol symbol, Module module) {
    { String name = symbol.symbolName;
      Symbol modulesymbol = Symbol.lookupSymbolInModule(name, module, true);

      if (((Module)(symbol.homeContext)) == null) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Can't import the TRANSIENT symbol `" + name + "' into `" + module + "'");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      if (!(modulesymbol == symbol)) {
        if (modulesymbol != null) {
          { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

            stream001.nativeStream.print("Can't import, a symbol with name `" + name + "' already exists in `" + module + "'");
            throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
          }
        }
        if (symbol != null) {
          Module.selectSymbolOffsetTable(module, Stella.SYMBOL_SYM).insertAt(name, symbol.symbolId);
        }
      }
      return (symbol);
    }
  }

  /** Signal error message, placing non-string arguments in quotes.
   * @param type
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object signal(Symbol type, Cons body) {
    if (type == Stella.SYM_STELLA_NULL) {
      type = Stella.SYM_STELLA_STELLA_EXCEPTION;
    }
    if ((body.length() == 1) &&
        Stella_Object.isaP(body.value, Stella.SGT_STELLA_STRING_WRAPPER)) {
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SIGNAL_EXCEPTION, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NEW, Cons.cons(type, Cons.cons(Cons.list$(Cons.cons(Stella.KWD_MESSAGE, Cons.cons(body.value, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))));
    }
    else {
      { Symbol streamvar = Stella.localGensym("STREAM");

        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.cons(streamvar, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NEW, Cons.cons(Stella.SYM_STELLA_OUTPUT_STRING_STREAM, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(streamvar, Cons.cons(Cons.formatMessageArguments(body, false).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SIGNAL_EXCEPTION, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NEW, Cons.cons(type, Cons.cons(Cons.list$(Cons.cons(Stella.KWD_MESSAGE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_STRING, Cons.cons(streamvar, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))));
      }
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { Symbol self = this;

      Symbol.printSymbol(self, stream);
    }
  }

  public static Stella_Object accessSymbolSlotValue(Symbol self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_SYMBOL_SLOT_OFFSET) {
      if (setvalueP) {
        self.symbolSlotOffset = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.symbolSlotOffset);
      }
    }
    else if (slotname == Stella.SYM_STELLA_SYMBOL_VALUE_AND_PLIST) {
      if (setvalueP) {
        self.symbolValueAndPlist = ((Cons)(value));
      }
      else {
        value = self.symbolValueAndPlist;
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
    { Symbol self = this;

      return (Stella.SGT_STELLA_SYMBOL);
    }
  }

}

