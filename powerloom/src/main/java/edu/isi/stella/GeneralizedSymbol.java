//  -*- Mode: Java -*-
//
// GeneralizedSymbol.java

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

public abstract class GeneralizedSymbol extends ContextSensitiveObject {
    public String symbolName;
    public int symbolId;

  public static GeneralizedSymbol internRigidSymbolCaseSensitively(String name, int kindofsym, boolean tryupcasingP) {
    { GeneralizedSymbol symbol = null;

      symbol = GeneralizedSymbol.lookupRigidSymbol(name, kindofsym);
      if (symbol != null) {
        return (symbol);
      }
      if (((Boolean)(Stella.$TRANSIENTOBJECTSp$.get())).booleanValue() &&
          (kindofsym == Stella.SYMBOL_SYM)) {
        symbol = Stella.lookupTransientSymbol(name);
        if (symbol != null) {
          return (symbol);
        }
      }
      if (tryupcasingP) {
        symbol = GeneralizedSymbol.lookupRigidSymbol(Native.stringUpcase(name), kindofsym);
        if (symbol != null) {
          return (symbol);
        }
      }
      switch (kindofsym) {
        case 0: 
          if (((Boolean)(Stella.$TRANSIENTOBJECTSp$.get())).booleanValue()) {
            return (Stella.internTransientSymbol(name));
          }
          else {
            return (Symbol.internPermanentSymbol(name));
          }
        case 1: 
          return (GeneralizedSymbol.internRigidSymbolWrtModule(name, ((Module)(Stella.$MODULE$.get())), Stella.SURROGATE_SYM));
        default:
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + kindofsym + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
      }
    }
  }

  /** Return a newly-created or existing rigid symbol
   * interned into the module <code>module</code> with name <code>name</code>.
   * @param name
   * @param module
   * @param kindofsym
   * @return GeneralizedSymbol
   */
  public static GeneralizedSymbol internRigidSymbolLocally(String name, Module module, int kindofsym) {
    if (module == null) {
      module = ((Module)(Stella.$MODULE$.get()));
    }
    { GeneralizedSymbol symbol = GeneralizedSymbol.lookupRigidSymbolLocally(name, module, kindofsym);

      if (symbol != null) {
        return (symbol);
      }
      { ExtensibleSymbolArray array = Stella.selectSymbolArray(kindofsym);

        return (GeneralizedSymbol.helpInternGeneralizedSymbol(name, kindofsym, array, ExtensibleSymbolArray.nextFreeOffset(array), module));
      }
    }
  }

  /** Return a newly-created or existing rigid symbol with
   * name <code>name</code>.
   * @param name
   * @param module
   * @param kindofsym
   * @return GeneralizedSymbol
   */
  public static GeneralizedSymbol internRigidSymbolWrtModule(String name, Module module, int kindofsym) {
    if (module == null) {
      module = ((Module)(Stella.$MODULE$.get()));
    }
    { int offset = Stella.lookupRigidSymbolOffsetWrtModule(name, module, kindofsym);

      if (offset != Stella.NULL_INTEGER) {
        switch (kindofsym) {
          case 0: 
            return (Symbol.getSymFromOffset(offset));
          case 1: 
            return (Surrogate.getSgtFromOffset(offset));
          case 2: 
            return (Keyword.getKwdFromOffset(offset));
          default:
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + kindofsym + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
        }
      }
      { ExtensibleSymbolArray array = Stella.selectSymbolArray(kindofsym);

        offset = ExtensibleSymbolArray.nextFreeOffset(array);
        return (GeneralizedSymbol.helpInternGeneralizedSymbol(name, kindofsym, array, offset, module));
      }
    }
  }

  public static GeneralizedSymbol helpInternGeneralizedSymbol(String name, int kindofsym, ExtensibleSymbolArray array, int offset, Module module) {
    { GeneralizedSymbol symbol = null;
      StringToIntegerHashTable table = Module.selectSymbolOffsetTable(module, kindofsym);

      switch (kindofsym) {
        case 0: 
          symbol = Symbol.newSymbol(name);
          table.insertAt(name, offset);
          symbol.homeContext = module;
        break;
        case 1: 
          symbol = Surrogate.newSurrogate(name);
          table.insertAt(name, offset);
          symbol.homeContext = module;
        break;
        case 2: 
          symbol = Keyword.newKeyword(name);
          table.insertAt(name, offset);
          symbol.homeContext = null;
        break;
        default:
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + kindofsym + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
      }
      ExtensibleSymbolArray.addToSymbolArrayAt(array, offset, symbol);
      return (symbol);
    }
  }

  /** Return the permanent symbol with name 'name' and type
   * <code>kindofsym</code> visible from the current module (case-sensitive).
   * @param name
   * @param kindofsym
   * @return GeneralizedSymbol
   */
  public static GeneralizedSymbol lookupRigidSymbol(String name, int kindofsym) {
    return (Stella.lookupRigidSymbolWrtModule(name, ((Module)(Stella.$MODULE$.get())), kindofsym));
  }

  public static GeneralizedSymbol lookupRigidSymbolLocally(String name, Module module, int kindofsym) {
    { StringToIntegerHashTable offsettable = Module.selectSymbolOffsetTable(module, kindofsym);
      int offset = offsettable.lookup(name);

      if (offset != Stella.NULL_INTEGER) {
        switch (kindofsym) {
          case 0: 
            return (Symbol.getSymFromOffset(offset));
          case 1: 
            return (Surrogate.getSgtFromOffset(offset));
          case 2: 
            return (Keyword.getKwdFromOffset(offset));
          default:
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + kindofsym + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
        }
      }
      return (null);
    }
  }

  public static GeneralizedSymbol getGeneralizedSymbolFromOffset(ExtensibleSymbolArray symbolarray, int offset) {
    return (((GeneralizedSymbol)((symbolarray.theArray)[offset])));
  }

  public static StringWrapper idlTranslateSymbolConstantId(GeneralizedSymbol symbol) {
    { StringWrapper translatedsymbol = GeneralizedSymbol.idlTranslateSymbolConstantName(symbol);

      translatedsymbol.wrapperValue = translatedsymbol.wrapperValue + "_id";
      return (translatedsymbol);
    }
  }

  public static StringWrapper idlTranslateSymbolConstantName(GeneralizedSymbol symbol) {
    { String prefix = null;

      { Surrogate testValue000 = Stella_Object.safePrimaryType(symbol);

        if (Surrogate.subtypeOfSymbolP(testValue000)) {
          { Symbol symbol000 = ((Symbol)(symbol));

            prefix = "SYM_" + ((Module)(symbol000.homeContext)).contextName();
          }
        }
        else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
          { Surrogate symbol000 = ((Surrogate)(symbol));

            prefix = "SGT_" + ((Module)(symbol000.homeContext)).contextName();
          }
        }
        else if (Surrogate.subtypeOfKeywordP(testValue000)) {
          { Keyword symbol000 = ((Keyword)(symbol));

            prefix = "KWD";
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      return (StringWrapper.wrapString(Stella.idlSubstituteForbiddenCharacters(prefix + "_" + symbol.symbolName, Stella.KWD_UPPERCASE)));
    }
  }

  public static String idlChangeCase(GeneralizedSymbol symbol, Keyword caseconvention) {
    { Module module = ((Module)(symbol.homeContext));
      String name = symbol.symbolName;

      if (module == null) {
        module = ((Module)(Stella.$MODULE$.get()));
      }
      if (module.caseSensitiveP) {
        return (Native.string_copy(name));
      }
      if (caseconvention == Stella.KWD_UPPERCASE) {
        return (Native.stringUpcase(name));
      }
      else if (caseconvention == Stella.KWD_LOWERCASE) {
        return (Native.stringDowncase(name));
      }
      else if (caseconvention == Stella.KWD_CAPITALIZED) {
        return (Native.stringCapitalize(name));
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + caseconvention + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static StringWrapper idlTranslateClassName(GeneralizedSymbol namesymbol) {
    return (StringWrapper.wrapString(Stella.idlSubstituteForbiddenCharacters(GeneralizedSymbol.idlChangeCase(((Stella_Class)(namesymbol.surrogatify().surrogateValue)).classType, Stella.KWD_CAPITALIZED), Stella.KWD_CAPITALIZED)));
  }

  public static StringWrapper javaTranslateClassName(GeneralizedSymbol namesymbol) {
    return (StandardObject.javaTranslateTypeSpec(namesymbol.surrogatify()));
  }

  public static StringWrapper javaTranslateSymbolConstantId(GeneralizedSymbol symbol) {
    { StringWrapper translatedsymbol = GeneralizedSymbol.javaTranslateSymbolConstantName(symbol);

      translatedsymbol.wrapperValue = translatedsymbol.wrapperValue + "_id";
      return (translatedsymbol);
    }
  }

  public static StringWrapper javaTranslateSymbolConstantName(GeneralizedSymbol symbol) {
    { GeneralizedSymbol globalsymbol = ((GeneralizedSymbol)(Stella.$SYMBOL_REGISTRY$.lookup(symbol)));
      String translatedname = "";
      String flotsamClassName = "";

      if (!(globalsymbol != null)) {
        {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: Couldn't lookup symbol name for `" + symbol + "'");
          Stella.STANDARD_WARNING.nativeStream.println("     in java-translate-symbol-constant-name");
        }
;
      }
      flotsamClassName = Module.javaYieldFlotsamClassName(globalsymbol.homeModule());
      translatedname = flotsamClassName + "." + Stella.javaSubstituteForbiddenCharacters(globalsymbol.symbolName, Stella.KWD_UPPERCASE);
      if (!(Module.omitJavaPackagePrefixP(globalsymbol.homeModule(), Stella.javaYieldFlotsamTypeName(flotsamClassName)))) {
        translatedname = Module.javaPackagePrefix(globalsymbol.homeModule(), ".") + translatedname;
      }
      return (StringWrapper.wrapString(translatedname));
    }
  }

  public static String javaChangeCase(GeneralizedSymbol symbol, Keyword caseconvention) {
    { Module module = ((Module)(symbol.homeContext));
      String name = symbol.symbolName;
      boolean allUpperP = Stella.allUpperCaseStringP(name);
      Keyword capsBreakKeyword = (allUpperP ? Stella.KWD_CLEVER : Stella.KWD_YES);

      if (module == null) {
        module = ((Module)(Stella.$MODULE$.get()));
      }
      if (module.caseSensitiveP ||
          (!allUpperP)) {
        return (Stella.makeMatchingNameFull(name, Stella.KWD_NO, Stella.KWD_NO, "- ", "", "", "", "", Stella.KWD_PRESERVE, "_"));
      }
      if (caseconvention == Stella.KWD_UPPERCASE) {
        return (Stella.makeMatchingNameFull(name, Stella.KWD_NO, Stella.KWD_NO, "- ", "", "", "", "", Stella.KWD_UPCASE, "_"));
      }
      else if (caseconvention == Stella.KWD_LOWERCASE) {
        return (Stella.makeMatchingNameFull(name, capsBreakKeyword, Stella.KWD_CLEVER, "- ", "", "", "", "", Stella.KWD_TITLECASEX, ""));
      }
      else if (caseconvention == Stella.KWD_CAPITALIZED) {
        return (Stella.makeMatchingNameFull(name, capsBreakKeyword, Stella.KWD_CLEVER, "- ", "", "", "", "", Stella.KWD_TITLECASE, ""));
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + caseconvention + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static StringWrapper cppTranslateClassName(GeneralizedSymbol namesymbol) {
    return (StandardObject.cppTranslateTypeSpec(namesymbol.surrogatify()));
  }

  public static StringWrapper cppTranslateClassTypename(GeneralizedSymbol namesymbol) {
    { Surrogate realnamesymbol = ((Stella_Class)(namesymbol.surrogatify().surrogateValue)).classType;

      return (StringWrapper.wrapString(Stella.cppYieldQualifiedName(Stella.cppSubstituteForbiddenCharacters(GeneralizedSymbol.cppChangeCase(realnamesymbol, Stella.KWD_CAPITALIZED), Stella.KWD_CAPITALIZED), realnamesymbol)));
    }
  }

  public static StringWrapper cppTranslateSymbolConstantId(GeneralizedSymbol symbol) {
    { StringWrapper translatedsymbol = GeneralizedSymbol.cppTranslateSymbolConstantName(symbol);

      translatedsymbol.wrapperValue = translatedsymbol.wrapperValue + "_id";
      return (translatedsymbol);
    }
  }

  public static StringWrapper cppTranslateSymbolConstantName(GeneralizedSymbol symbol) {
    { String prefix = null;

      { Surrogate testValue000 = Stella_Object.safePrimaryType(symbol);

        if (Surrogate.subtypeOfSymbolP(testValue000)) {
          { Symbol symbol000 = ((Symbol)(symbol));

            prefix = "SYM_" + ((Module)(symbol000.homeContext)).contextName();
          }
        }
        else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
          { Surrogate symbol000 = ((Surrogate)(symbol));

            prefix = "SGT_" + ((Module)(symbol000.homeContext)).contextName();
          }
        }
        else if (Surrogate.subtypeOfKeywordP(testValue000)) {
          { Keyword symbol000 = ((Keyword)(symbol));

            prefix = "KWD";
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      return (StringWrapper.wrapString(Stella.cppSubstituteForbiddenCharacters(prefix + "_" + symbol.symbolName, Stella.KWD_UPPERCASE)));
    }
  }

  public static boolean cppQualifyNameP(GeneralizedSymbol namesymbol) {
    { Module symbolmodule = ((Module)(namesymbol.homeContext));
      Module namespacemodule = ((((Module)(Stella.$CPP_CURRENT_UNIT_MODULE$.get())) != null) ? ((Module)(Stella.$CPP_CURRENT_UNIT_MODULE$.get())) : ((Module)(Stella.$MODULE$.get())));

      if ((symbolmodule == null) ||
          (namesymbol == Stella.SYM_STELLA_NULL)) {
        return (false);
      }
      if (Stella_Object.symbolP(namesymbol) &&
          Symbol.nativeNameP(((Symbol)(namesymbol)), Stella.KWD_CPP, null)) {
        return (true);
      }
      if (((Keyword)(Stella.$CPP_NAME_QUALIFICATION_MODE$.get())) == Stella.KWD_FULL) {
        return (true);
      }
      else if (((Keyword)(Stella.$CPP_NAME_QUALIFICATION_MODE$.get())) == Stella.KWD_NEVER) {
        return (false);
      }
      else if (((Keyword)(Stella.$CPP_NAME_QUALIFICATION_MODE$.get())) == Stella.KWD_CLEVER) {
        if (symbolmodule == namespacemodule) {
          return (false);
        }
        else if (!Context.visibleFromP(symbolmodule, namespacemodule)) {
          return (true);
        }
        else {
          { Surrogate testValue000 = Stella_Object.safePrimaryType(namesymbol);

            if (Surrogate.subtypeOfSymbolP(testValue000)) {
              { Symbol namesymbol000 = ((Symbol)(namesymbol));

                return (!(Stella.lookupVisibleSymbolsInModule(namesymbol000.symbolName, namespacemodule, false).rest == Stella.NIL));
              }
            }
            else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
              { Surrogate namesymbol000 = ((Surrogate)(namesymbol));

                return (!(Stella.lookupVisibleSurrogatesInModule(namesymbol000.symbolName, namespacemodule, false).rest == Stella.NIL));
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
      else {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("`" + ((Keyword)(Stella.$CPP_NAME_QUALIFICATION_MODE$.get())) + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static String cppYieldNamespacePrefix(GeneralizedSymbol symbol) {
    return (Module.cppYieldNamespacePrefixFromModule(((Module)(symbol.homeContext))));
  }

  public static String helpCppChangeCase(GeneralizedSymbol symbol, Keyword caseconvention) {
    { Module module = ((Module)(symbol.homeContext));
      String name = symbol.symbolName;
      boolean allUpperP = Stella.allUpperCaseStringP(name);
      Keyword capsBreakKeyword = (allUpperP ? Stella.KWD_CLEVER : Stella.KWD_YES);

      if (module == null) {
        module = ((Module)(Stella.$MODULE$.get()));
      }
      if (module.caseSensitiveP ||
          (!allUpperP)) {
        return (Stella.makeMatchingNameFull(name, Stella.KWD_NO, Stella.KWD_NO, "- ", "", "", "", "", Stella.KWD_PRESERVE, "_"));
      }
      if (caseconvention == Stella.KWD_UPPERCASE) {
        return (Stella.makeMatchingNameFull(name, Stella.KWD_NO, Stella.KWD_NO, "- ", "", "", "", "", Stella.KWD_UPCASE, "_"));
      }
      else if (caseconvention == Stella.KWD_LOWERCASE) {
        return (Stella.makeMatchingNameFull(name, capsBreakKeyword, Stella.KWD_CLEVER, "- ", "", "", "", "", Stella.KWD_TITLECASEX, ""));
      }
      else if (caseconvention == Stella.KWD_CAPITALIZED) {
        return (Stella.makeMatchingNameFull(name, capsBreakKeyword, Stella.KWD_CLEVER, "- ", "", "", "", "", Stella.KWD_TITLECASE, ""));
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + caseconvention + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static String cppChangeCase(GeneralizedSymbol symbol, Keyword caseconvention) {
    { MemoizationTable memoTable000 = null;
      Cons memoizedEntry000 = null;
      Stella_Object memoizedValue000 = null;

      if (Stella.$MEMOIZATION_ENABLEDp$) {
        memoTable000 = ((MemoizationTable)(Stella.SGT_STELLA_F_CPP_CHANGE_CASE_MEMO_TABLE_000.surrogateValue));
        if (memoTable000 == null) {
          Surrogate.initializeMemoizationTable(Stella.SGT_STELLA_F_CPP_CHANGE_CASE_MEMO_TABLE_000, "(:MAX-VALUES 2000)");
          memoTable000 = ((MemoizationTable)(Stella.SGT_STELLA_F_CPP_CHANGE_CASE_MEMO_TABLE_000.surrogateValue));
        }
        memoizedEntry000 = MruMemoizationTable.lookupMruMemoizedValue(((MruMemoizationTable)(memoTable000)), symbol, caseconvention, ((Module)(Stella.$MODULE$.get())), Stella.MEMOIZED_NULL_VALUE, -1);
        memoizedValue000 = memoizedEntry000.value;
      }
      if (memoizedValue000 != null) {
        if (memoizedValue000 == Stella.MEMOIZED_NULL_VALUE) {
          memoizedValue000 = null;
        }
      }
      else {
        memoizedValue000 = StringWrapper.wrapString(GeneralizedSymbol.helpCppChangeCase(symbol, caseconvention));
        if (Stella.$MEMOIZATION_ENABLEDp$) {
          memoizedEntry000.value = ((memoizedValue000 == null) ? Stella.MEMOIZED_NULL_VALUE : memoizedValue000);
        }
      }
      { StringWrapper value000 = ((StringWrapper)(memoizedValue000));

        return (value000.wrapperValue);
      }
    }
  }

  public static GeneralizedSymbol registerSymbol(GeneralizedSymbol symbol) {
    symbol = ((GeneralizedSymbol)(symbol.permanentify()));
    { GeneralizedSymbol registeredsymbol = ((GeneralizedSymbol)(Stella.$SYMBOL_REGISTRY$.lookup(symbol)));

      if (!(registeredsymbol != null)) {
        Stella.$SYMBOL_SET$.insert(symbol);
        if (Stella.useHardcodedSymbolsP()) {
          registeredsymbol = symbol;
        }
        else {
          registeredsymbol = GeneralizedSymbol.createStartupSymbol(symbol);
        }
        Stella.$SYMBOL_REGISTRY$.insertAt(symbol, registeredsymbol);
      }
      return (registeredsymbol);
    }
  }

  public static Symbol createStartupSymbol(GeneralizedSymbol symbol) {
    { Module symbolmodule = ((Module)(Stella.$MODULE$.get()));
      Symbol symbolconstant = GeneralizedSymbol.yieldSymbolConstantName(symbol);
      String symbolconstantname = symbolconstant.symbolName;
      Stella_Object symbolconstanttypetree = StandardObject.yieldTypeSpecTree(symbol.primaryType());
      String lisppackage = symbolmodule.lispPackage();
      Cons tree = null;

      if (Stella.incrementalTranslationP()) {
      }
      tree = Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFGLOBAL, Cons.cons(symbolconstant, Cons.cons(Cons.cons(symbolconstanttypetree, Cons.list$(Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.KWD_PUBLICp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Stella.NIL, Stella.NIL)))))), Stella.NIL))));
      Cons.walkAuxiliaryTree(tree);
      tree = Cons.list$(Cons.cons(Stella.SYM_STELLA_STARTUP_TIME_PROGN, Cons.cons(Stella.KWD_SYMBOLS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(symbolconstant, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SAFE_CAST, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_INTERN_RIGID_SYMBOL_WRT_MODULE, Cons.cons(StringWrapper.wrapString(symbol.symbolName), Cons.cons(Cons.cons((((((Module)(symbol.homeContext)) == ((Module)(Stella.$MODULE$.get()))) ||
          Stella_Object.keywordP(symbol)) ? ((StandardObject)(Stella.SYM_STELLA_NULL)) : ((StandardObject)(Cons.list$(Cons.cons(Stella.SYM_STELLA_GET_STELLA_MODULE, Cons.cons(StringWrapper.wrapString(((Module)(symbol.homeContext)).moduleFullName), Cons.cons(Cons.cons(Stella.SYM_STELLA_TRUE, Stella.NIL), Stella.NIL))))))), Cons.cons(IntegerWrapper.wrapInteger((Stella_Object.keywordP(symbol) ? Stella.KEYWORD_SYM : ((Stella_Object.surrogateP(symbol) ? Stella.SURROGATE_SYM : Stella.SYMBOL_SYM)))), Stella.NIL)), Stella.NIL)))), Cons.cons(symbolconstanttypetree, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))));
      Cons.walkAuxiliaryTree(tree);
      return (symbolconstant);
    }
  }

  public static Symbol yieldSymbolConstantName(GeneralizedSymbol symbol) {
    return (Symbol.internSymbolInModule(GeneralizedSymbol.constructSymbolConstantName(((GeneralizedSymbol)(symbol.permanentify()))), ((Module)(Stella.$MODULE$.get())), true));
  }

  public static String constructSymbolConstantName(GeneralizedSymbol symbol) {
    { String prefix = null;
      String environmentname = "";

      if (((Module)(symbol.homeContext)) != null) {
        environmentname = ((Module)(symbol.homeContext)).moduleName + "-";
      }
      if (!(Stella.incrementalTranslationP() ||
          (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA))) {
        environmentname = Native.stringUpcase(((String)(Stella.$CURRENTFILE$.get()))) + "-" + environmentname;
      }
      { Surrogate testValue000 = Stella_Object.safePrimaryType(symbol);

        if (Surrogate.subtypeOfSymbolP(testValue000)) {
          { Symbol symbol000 = ((Symbol)(symbol));

            prefix = "SYM-";
          }
        }
        else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
          { Surrogate symbol000 = ((Surrogate)(symbol));

            prefix = "SGT-";
          }
        }
        else if (Surrogate.subtypeOfKeywordP(testValue000)) {
          { Keyword symbol000 = ((Keyword)(symbol));

            prefix = "KWD-";
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      return (prefix + environmentname + symbol.symbolName);
    }
  }

  public static boolean explicitlyQualifiedNameP(GeneralizedSymbol name, Module definitionmodule) {
    { Module namemodule = ((Module)(name.homeContext));
      GeneralizedSymbol shadow = null;

      if (namemodule == definitionmodule) {
        {
          return (false);
        }
      }
      else {
        if (!Context.visibleFromP(namemodule, definitionmodule)) {
          {
            return (true);
          }
        }
        else {
          { boolean testValue000 = false;

            { 
              shadow = Symbol.lookupSymbolInModule(name.symbolName, definitionmodule, true);
              testValue000 = shadow != null;
            }
            if (testValue000) {
              testValue000 = !(shadow == name);
            }
            if (testValue000) {
              {
                return (true);
              }
            }
            else {
              {
                return (false);
              }
            }
          }
        }
      }
    }
  }

  /** Return a global variable with name 'self'.
   * @return GlobalVariable
   */
  public GlobalVariable lookupGlobalVariable() {
    { GeneralizedSymbol self = this;

      return (((GlobalVariable)(Stella.$GLOBAL_VARIABLE_LOOKUP_TABLE$.lookup(((Symbol)(self))))));
    }
  }

  /** Return <code>true</code> if <code>symbol</code> is shadowed in its home module.
   * @param symbol
   * @return boolean
   */
  public static boolean shadowedSymbolP(GeneralizedSymbol symbol) {
    { String symbolname = symbol.symbolName;
      Module module = ((Module)(symbol.homeContext));

      { boolean testValue000 = false;

        testValue000 = module != null;
        if (testValue000) {
          { boolean foundP000 = false;

            { Surrogate shadow = null;
              Cons iter000 = module.shadowedSurrogates().theConsList;

              loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                shadow = ((Surrogate)(iter000.value));
                if (Stella.stringEqlP(shadow.symbolName, symbolname)) {
                  foundP000 = true;
                  break loop000;
                }
              }
            }
            testValue000 = foundP000;
          }
        }
        { boolean value000 = testValue000;

          return (value000);
        }
      }
    }
  }

  public String visibleName(boolean readableP) {
    { GeneralizedSymbol self = this;

      { boolean visibleP = false;

        { Surrogate testValue000 = Stella_Object.safePrimaryType(self);

          if (Surrogate.subtypeOfSymbolP(testValue000)) {
            { Symbol self000 = ((Symbol)(self));

              visibleP = self000 == Symbol.lookupSymbolInModule(self000.symbolName, ((Module)(Stella.$MODULE$.get())), false);
            }
          }
          else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
            { Surrogate self000 = ((Surrogate)(self));

              visibleP = self000 == Surrogate.lookupSurrogateInModule(self000.symbolName, ((Module)(Stella.$MODULE$.get())), false);
            }
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }
        if (visibleP) {
          return (self.localPrintName(readableP));
        }
        else {
          return (Stella.computeFullName(self.localPrintName(readableP), ((Module)(self.homeContext))));
        }
      }
    }
  }

  public String relativeName(boolean readableP) {
    { GeneralizedSymbol self = this;

      { String string = null;

        if (((Module)(self.homeContext)) == ((Module)(Stella.$MODULE$.get()))) {
          string = self.localPrintName(readableP);
        }
        else {
          string = Stella.computeFullName(self.localPrintName(readableP), ((Module)(self.homeContext)));
        }
        if (self.symbolId == -1) {
          string = "<<UNINTERNED>>/" + string;
        }
        return (string);
      }
    }
  }

  public String localPrintName(boolean readableP) {
    { GeneralizedSymbol self = this;

      if (readableP) {
        return (Stella.readableSymbolName(self.symbolName, ((Module)(Stella.$MODULE$.get())).caseSensitiveP));
      }
      else {
        return (self.symbolName);
      }
    }
  }

  public Keyword keywordify() {
    { GeneralizedSymbol self = this;

      return (Stella.internKeyword(self.symbolName));
    }
  }

  public boolean deletedP() {
    { GeneralizedSymbol self = this;

      return (self.symbolId == -1);
    }
  }

  /** Return a newly-created or existing surrogate with name
   * <code>newname</code> which is interned in the same module as <code>basesymbol</code>.
   * @param basesymbol
   * @param newname
   * @return Surrogate
   */
  public static Surrogate internDerivedSurrogate(GeneralizedSymbol basesymbol, String newname) {
    { Module currentmodule = ((Module)(Stella.$MODULE$.get()));

      { Object old$Module$000 = Stella.$MODULE$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, ((Module)(basesymbol.homeContext)));
          if (((Module)(Stella.$MODULE$.get())) != null) {
            return (((Surrogate)(GeneralizedSymbol.internRigidSymbolLocally((((Module)(Stella.$MODULE$.get())).caseSensitiveP ? newname : Native.stringUpcase(newname)), ((Module)(Stella.$MODULE$.get())), Stella.SURROGATE_SYM))));
          }
          Native.setSpecial(Stella.$MODULE$, currentmodule);
          return (Surrogate.internSurrogate(newname));

        } finally {
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  public static boolean generalizedSymbolLessThanP(GeneralizedSymbol x, GeneralizedSymbol y) {
    return (Stella.stringL(x.symbolName, y.symbolName));
  }

  public static Stella_Object accessGeneralizedSymbolSlotValue(GeneralizedSymbol self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_SYMBOL_NAME) {
      if (setvalueP) {
        self.symbolName = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.symbolName);
      }
    }
    else if (slotname == Stella.SYM_STELLA_SYMBOL_ID) {
      if (setvalueP) {
        self.symbolId = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.symbolId);
      }
    }
    else if (slotname == Stella.SYM_STELLA_INTERNED_IN) {
      if (setvalueP) {
        self.homeContext = ((Module)(value));
      }
      else {
        value = ((Module)(self.homeContext));
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

}

