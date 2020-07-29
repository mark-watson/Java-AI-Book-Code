//  -*- Mode: Java -*-
//
// TranslationUnit.java

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

public class TranslationUnit extends StandardObject {
    public Module tuHomeModule;
    public Stella_Object theObject;
    public Symbol category;
    public String annotation;
    public boolean auxiliaryP;
    public Stella_Object codeRegister;
    public Stella_Object translation;
    public List referencedGlobals;

  public static TranslationUnit newTranslationUnit() {
    { TranslationUnit self = null;

      self = new TranslationUnit();
      self.referencedGlobals = List.newList();
      self.translation = null;
      self.codeRegister = null;
      self.auxiliaryP = false;
      self.annotation = null;
      self.category = null;
      self.theObject = null;
      self.tuHomeModule = null;
      return (self);
    }
  }

  public static Cons idlTranslateDefineNativeClassUnit(TranslationUnit unit) {
    { Stella_Class renamed_Class = ((Stella_Class)(unit.theObject));
      Cons derivedclasses = Stella.NIL;
      Cons parameterizedattributedefs = Stella.NIL;
      Cons attributedefs = Stella.NIL;
      Cons operationdefs = Stella.NIL;
      Cons constructordefs = Stella.NIL;
      Cons parameters = Stella.NIL;
      Cons staticattributedefs = Stella.NIL;

      { Surrogate renamed_Super = null;
        Cons iter000 = renamed_Class.classDirectSupers.theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          renamed_Super = ((Surrogate)(iter000.value));
          if (collect000 == null) {
            {
              collect000 = Cons.cons(GeneralizedSymbol.idlTranslateClassName(Symbol.internSymbolInModule(renamed_Super.symbolName, ((Module)(renamed_Super.homeContext)), false)), Stella.NIL);
              if (derivedclasses == Stella.NIL) {
                derivedclasses = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(derivedclasses, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(GeneralizedSymbol.idlTranslateClassName(Symbol.internSymbolInModule(renamed_Super.symbolName, ((Module)(renamed_Super.homeContext)), false)), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      { Symbol parameter = null;
        Cons iter001 = renamed_Class.classParameters().theConsList;
        Cons collect001 = null;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          parameter = ((Symbol)(iter001.value));
          if (collect001 == null) {
            {
              collect001 = Cons.cons(Symbol.idlTranslateClassParameterName(parameter), Stella.NIL);
              if (parameters == Stella.NIL) {
                parameters = collect001;
              }
              else {
                Cons.addConsToEndOfConsList(parameters, collect001);
              }
            }
          }
          else {
            {
              collect001.rest = Cons.cons(Symbol.idlTranslateClassParameterName(parameter), Stella.NIL);
              collect001 = collect001.rest;
            }
          }
        }
      }
      { Slot slot = null;
        Iterator iter002 = renamed_Class.classSlots();

        while (iter002.nextP()) {
          slot = ((Slot)(iter002.value));
          slot.slotMarkedP = false;
        }
      }
      { Slot slot = null;
        Iterator iter003 = renamed_Class.classSlots();

        while (iter003.nextP()) {
          slot = ((Slot)(iter003.value));
          if (!slot.slotMarkedP) {
            if ((slot.slotDirectEquivalent != null) &&
                (!slot.slotDirectEquivalent.slotRenamedP)) {
              Slot.markDirectEquivalentSlot(slot);
              slot.slotMarkedP = false;
            }
          }
        }
      }
      constructordefs = Stella_Class.idlGetConstructorDefinitions(renamed_Class);
      parameterizedattributedefs = Stella_Class.idlGetParameterizedAttributeDefinitions(renamed_Class);
      attributedefs = Stella_Class.idlGetAttributeDefinitions(renamed_Class);
      operationdefs = Stella_Class.idlGetOperationDefinitions(renamed_Class);
      staticattributedefs = Stella_Class.idlGetStaticVariableDefinitions(renamed_Class);
      return (Cons.cons(Stella_Class.idlClassCategory(renamed_Class), Cons.cons(GeneralizedSymbol.idlTranslateClassName(Symbol.internSymbolInModule(renamed_Class.classType.symbolName, ((Module)(renamed_Class.classType.homeContext)), false)), Cons.cons(parameters, Cons.cons(derivedclasses, Cons.cons(staticattributedefs, (((!(parameterizedattributedefs == Stella.NIL)) ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IDL_DECLARATIONS, Cons.cons(parameterizedattributedefs, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL) : Stella.NIL)).concatenate((((!(attributedefs == Stella.NIL)) ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IDL_DECLARATIONS, Cons.cons(attributedefs, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL) : Stella.NIL)).concatenate((((!(constructordefs == Stella.NIL)) ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IDL_SIGNATURES, Cons.cons(constructordefs, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL) : Stella.NIL)).concatenate((((!(operationdefs == Stella.NIL)) ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IDL_SIGNATURES, Cons.cons(operationdefs, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL), Stella.NIL), Stella.NIL), Stella.NIL)))))));
    }
  }

  public static Cons idlTranslateDeftypeUnit(TranslationUnit unit) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_IDL_TYPEDEF, Cons.cons(Symbol.idlTranslateName(((Symbol)(((Cons)(unit.codeRegister)).rest.value))), Cons.cons(Cons.cons(StandardObject.idlTranslateTypeSpec(((StandardObject)(((Surrogate)(unit.theObject)).surrogateValue))), Stella.NIL), Stella.NIL)))));
  }

  public static Cons idlTranslateUnit(TranslationUnit unit) {
    { Symbol testValue000 = unit.category;

      if (testValue000 == Stella.SYM_STELLA_GLOBAL_VARIABLE) {
        return (null);
      }
      else if (testValue000 == Stella.SYM_STELLA_TYPE) {
        return (TranslationUnit.idlTranslateDeftypeUnit(unit));
      }
      else if (testValue000 == Stella.SYM_STELLA_CLASS) {
        return (TranslationUnit.idlTranslateDefineNativeClassUnit(unit));
      }
      else if ((testValue000 == Stella.SYM_STELLA_METHOD) ||
          (testValue000 == Stella.SYM_STELLA_MACRO)) {
        return (null);
      }
      else if (testValue000 == Stella.SYM_STELLA_PRINT_METHOD) {
        return (null);
      }
      else if ((testValue000 == Stella.SYM_STELLA_STARTUP_TIME_PROGN) ||
          (testValue000 == Stella.SYM_STELLA_VERBATIM)) {
        return (null);
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static Cons javaTranslateDefineNativeClassUnit(TranslationUnit unit) {
    return (Stella_Class.javaTranslateDefineNativeClass(((Stella_Class)(unit.theObject))));
  }

  public static Cons javaTranslateDefprintUnit(TranslationUnit unit) {
    { Object old$Methodbeingwalked$000 = Stella.$METHODBEINGWALKED$.get();
      Object old$Localgensymtable$000 = Stella.$LOCALGENSYMTABLE$.get();
      Object old$Currentdummyindex$000 = Stella.$CURRENTDUMMYINDEX$.get();
      Object old$Dummydeclarations$000 = Stella.$DUMMYDECLARATIONS$.get();

      try {
        Native.setSpecial(Stella.$METHODBEINGWALKED$, MethodSlot.newMethodSlot());
        Native.setSpecial(Stella.$LOCALGENSYMTABLE$, KeyValueList.newKeyValueList());
        Native.setIntSpecial(Stella.$CURRENTDUMMYINDEX$, 0);
        Native.setSpecial(Stella.$DUMMYDECLARATIONS$, Stella.NIL);
        { Stella_Class renamed_Class = ((Stella_Class)(unit.theObject));
          Cons bodytree = ((Cons)(unit.codeRegister));
          Cons otree = Stella.NIL;
          Cons translatedmethodbody = null;

          { Object old$Context$000 = Stella.$CONTEXT$.get();
            Object old$Module$000 = Stella.$MODULE$.get();

            try {
              Native.setSpecial(Stella.$CONTEXT$, renamed_Class.homeModule());
              Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
              bodytree = Cons.deleteQuotedNullStatements(bodytree);
              Native.setSpecial(Stella.$DUMMYDECLARATIONS$, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Surrogate.canonicalType(renamed_Class.classType), Cons.cons(Cons.cons(Stella.SYM_STELLA_THIS, Stella.NIL), Stella.NIL)))), ((Cons)(Stella.$DUMMYDECLARATIONS$.get()))));
              translatedmethodbody = Cons.wrapMethodBodyWithJavaAuxiliaryDeclarations(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, Cons.cons(Stella_Object.javaTranslateATree(bodytree), Cons.cons(Stella.NIL, Stella.NIL)))), ((Cons)(Stella.$DUMMYDECLARATIONS$.get())));
              otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_METHOD, Cons.cons(Cons.cons(StringWrapper.wrapString("public"), Stella.NIL), Cons.cons(Cons.cons(StringWrapper.wrapString("String"), Stella.NIL), Cons.cons(StringWrapper.wrapString("toString"), Cons.cons(Cons.list$(Cons.cons(Stella.NIL, Cons.cons(translatedmethodbody, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL))))));
              unit.translation = Stella.NIL;
              return (otree);

            } finally {
              Stella.$MODULE$.set(old$Module$000);
              Stella.$CONTEXT$.set(old$Context$000);
            }
          }
        }

      } finally {
        Stella.$DUMMYDECLARATIONS$.set(old$Dummydeclarations$000);
        Stella.$CURRENTDUMMYINDEX$.set(old$Currentdummyindex$000);
        Stella.$LOCALGENSYMTABLE$.set(old$Localgensymtable$000);
        Stella.$METHODBEINGWALKED$.set(old$Methodbeingwalked$000);
      }
    }
  }

  public static Cons javaTranslateDefineMethodUnit(TranslationUnit unit) {
    { Object old$Localgensymtable$000 = Stella.$LOCALGENSYMTABLE$.get();
      Object old$Methodbeingwalked$000 = Stella.$METHODBEINGWALKED$.get();
      Object old$Currentdummyindex$000 = Stella.$CURRENTDUMMYINDEX$.get();
      Object old$Dummydeclarations$000 = Stella.$DUMMYDECLARATIONS$.get();

      try {
        Native.setSpecial(Stella.$LOCALGENSYMTABLE$, KeyValueList.newKeyValueList());
        Native.setSpecial(Stella.$METHODBEINGWALKED$, null);
        Native.setIntSpecial(Stella.$CURRENTDUMMYINDEX$, 0);
        Native.setSpecial(Stella.$DUMMYDECLARATIONS$, Stella.NIL);
        { MethodSlot method = ((MethodSlot)(unit.theObject));
          boolean unitisfunction = MethodSlot.javaMethodObjectIsFunctionP(method);
          Cons bodytree = ((Cons)(unit.codeRegister));
          Cons otree = Stella.NIL;
          Cons translatedmethodbody = null;

          if ((unit.translation != null) &&
              (!(unit.translation == null))) {
            otree = ((Cons)(unit.translation));
            unit.translation = Stella.NIL;
            return (otree);
          }
          Native.setSpecial(Stella.$METHODBEINGWALKED$, method);
          bodytree = Cons.deleteQuotedNullStatements(bodytree);
          if (!unitisfunction) {
            Native.setSpecial(Stella.$DUMMYDECLARATIONS$, Cons.cons(Cons.cons(((Symbol)(method.methodParameterNames().first())), Cons.cons(method.slotOwner, Cons.cons(Stella.SYM_STELLA_THIS, Stella.NIL))), ((Cons)(Stella.$DUMMYDECLARATIONS$.get()))));
          }
          if (method.abstractP) {
            translatedmethodbody = Stella.NIL;
          }
          else {
            {
              translatedmethodbody = Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, Cons.javaTranslateListOfTrees(bodytree).concatenate(Stella.NIL, Stella.NIL));
              if (!(((Cons)(Stella.$DUMMYDECLARATIONS$.get())) == Stella.NIL)) {
                translatedmethodbody = Cons.wrapMethodBodyWithJavaAuxiliaryDeclarations(translatedmethodbody, ((Cons)(Stella.$DUMMYDECLARATIONS$.get())));
              }
            }
          }
          if (((StringWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue != null) {
            if (translatedmethodbody == Stella.NIL) {
              translatedmethodbody = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_COMMENT, Cons.cons(StringWrapper.wrapString(((StringWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))));
            }
            else {
              translatedmethodbody.rest = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_COMMENT, Cons.cons(StringWrapper.wrapString(((StringWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue), Cons.cons(Stella.NIL, Stella.NIL)))), translatedmethodbody.rest.concatenate(Stella.NIL, Stella.NIL));
            }
          }
          otree = Cons.cons((unitisfunction ? Stella.SYM_STELLA_JAVA_FUNCTION : Stella.SYM_STELLA_JAVA_METHOD), MethodSlot.javaTranslateMethodSignature(method).concatenate(Cons.cons(translatedmethodbody, Stella.NIL), Stella.NIL));
          unit.translation = Stella.NIL;
          return (otree);
        }

      } finally {
        Stella.$DUMMYDECLARATIONS$.set(old$Dummydeclarations$000);
        Stella.$CURRENTDUMMYINDEX$.set(old$Currentdummyindex$000);
        Stella.$METHODBEINGWALKED$.set(old$Methodbeingwalked$000);
        Stella.$LOCALGENSYMTABLE$.set(old$Localgensymtable$000);
      }
    }
  }

  public static Cons javaTranslateDefineGlobalVariableUnit(TranslationUnit unit) {
    { GlobalVariable global = ((GlobalVariable)(unit.theObject));

      { Object old$Context$000 = Stella.$CONTEXT$.get();
        Object old$Module$000 = Stella.$MODULE$.get();

        try {
          Native.setSpecial(Stella.$CONTEXT$, global.homeModule());
          Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
          { StringWrapper variabletype = (global.variableSpecialP ? StringWrapper.wrapString(Stella.javaYieldSpecialVariableClassName()) : StandardObject.javaTranslateTypeSpec(GlobalVariable.globalVariableTypeSpec(global)));
            Cons typelist = Cons.cons(variabletype, Stella.NIL);
            Stella_Object initialvaluetree = Stella_Object.javaTranslateATree(unit.codeRegister);
            StringWrapper variablename = Symbol.javaTranslateGlobalName(global.variableName, true);

            typelist = Cons.cons(StringWrapper.wrapString("static"), typelist);
            if (global.variableConstantP ||
                global.variableSpecialP) {
              typelist = Cons.cons(StringWrapper.wrapString("final"), typelist);
            }
            if (global.variablePublicP) {
              typelist = Cons.cons(StringWrapper.wrapString("public"), typelist);
            }
            if ((unit.codeRegister == Stella.KWD_UNBOUND_SPECIAL_VARIABLE) ||
                global.variableSpecialP) {
              return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_GLOBAL, Cons.cons(StringWrapper.wrapString(global.documentation), Cons.cons(Cons.list$(Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_TYPE, typelist.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(variablename, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_MAKE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(variabletype, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_ACTUALS, Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Stella.NIL)))), Stella.NIL)))));
            }
            else {
              return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_GLOBAL, Cons.cons(StringWrapper.wrapString(global.documentation), Cons.cons(Cons.list$(Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_TYPE, typelist.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(variablename, Cons.cons(Cons.cons(initialvaluetree, Stella.NIL), Stella.NIL)))), Stella.NIL)))));
            }
          }

        } finally {
          Stella.$MODULE$.set(old$Module$000);
          Stella.$CONTEXT$.set(old$Context$000);
        }
      }
    }
  }

  public static Cons javaTranslateUnit(TranslationUnit unit) {
    { Symbol testValue000 = unit.category;

      if (testValue000 == Stella.SYM_STELLA_GLOBAL_VARIABLE) {
        return (TranslationUnit.javaTranslateDefineGlobalVariableUnit(unit));
      }
      else if (testValue000 == Stella.SYM_STELLA_CLASS) {
        return (TranslationUnit.javaTranslateDefineNativeClassUnit(unit));
      }
      else if (testValue000 == Stella.SYM_STELLA_TYPE) {
        return (Stella.NIL);
      }
      else if ((testValue000 == Stella.SYM_STELLA_METHOD) ||
          (testValue000 == Stella.SYM_STELLA_MACRO)) {
        return (TranslationUnit.javaTranslateDefineMethodUnit(unit));
      }
      else if (testValue000 == Stella.SYM_STELLA_PRINT_METHOD) {
        return (TranslationUnit.javaTranslateDefprintUnit(unit));
      }
      else if ((testValue000 == Stella.SYM_STELLA_STARTUP_TIME_PROGN) ||
          (testValue000 == Stella.SYM_STELLA_VERBATIM)) {
        return (((Cons)(Stella_Object.javaTranslateATree(unit.theObject))));
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static boolean javaClassUnitDefinesFlotsamClassP(TranslationUnit classunit) {
    { Stella_Class renamed_Class = ((Stella_Class)(classunit.theObject));
      Module module = classunit.homeModule();

      return (Stella.stringEqlP(StringWrapper.javaTranslateClassNamestring(StringWrapper.wrapString(Symbol.internSymbolInModule(renamed_Class.classType.symbolName, ((Module)(renamed_Class.classType.homeContext)), false).symbolName)).wrapperValue, Module.javaYieldFlotsamClassName(module)));
    }
  }

  public static void javaOutputClassUnitToFile(TranslationUnit classunit) {
    Stella_Class.javaOutputClassToFile(((Stella_Class)(classunit.theObject)));
  }

  public static Cons cppTranslateDefineNativeClassUnit(TranslationUnit unit) {
    { Stella_Class renamed_Class = ((Stella_Class)(unit.theObject));
      Cons baseclasses = Stella.NIL;
      Cons parameterizedmembervardefs = Stella.NIL;
      Cons publicmembervardefs = Stella.NIL;
      Cons protectedmembervardefs = Stella.NIL;
      Cons publicmemberfuncdefs = Stella.NIL;
      Cons protectedmemberfuncdefs = Stella.NIL;
      Cons constructordefs = Stella.NIL;
      Cons parameters = Stella.NIL;
      Cons staticmembervardefs = Stella.NIL;

      { Surrogate renamed_Super = null;
        Cons iter000 = Stella_Class.classNativeSupers(renamed_Class).theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          renamed_Super = ((Surrogate)(iter000.value));
          if ((!((Stella_Class)(renamed_Super.surrogateValue)).mixinP) ||
              (!Stella.translateToSingleInheritanceLanguageP())) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(GeneralizedSymbol.cppTranslateClassName(renamed_Super), Stella.NIL);
                if (baseclasses == Stella.NIL) {
                  baseclasses = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(baseclasses, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(GeneralizedSymbol.cppTranslateClassName(renamed_Super), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      if (((baseclasses == Stella.NIL) ||
          Stella_Class.cppClassHasOnlyNativeParentsP(renamed_Class)) &&
          ((!renamed_Class.mixinP) &&
           ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) &&
            Stella.cppUseGarbageCollectorP()))) {
        baseclasses = Cons.cons(Symbol.cppTranslateName(Stella.SYM_STELLA_GC), baseclasses);
      }
      { Symbol parameter = null;
        Cons iter001 = renamed_Class.classParameters().theConsList;
        Cons collect001 = null;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          parameter = ((Symbol)(iter001.value));
          if (collect001 == null) {
            {
              collect001 = Cons.cons(Symbol.cppTranslateClassParameterName(parameter), Stella.NIL);
              if (parameters == Stella.NIL) {
                parameters = collect001;
              }
              else {
                Cons.addConsToEndOfConsList(parameters, collect001);
              }
            }
          }
          else {
            {
              collect001.rest = Cons.cons(Symbol.cppTranslateClassParameterName(parameter), Stella.NIL);
              collect001 = collect001.rest;
            }
          }
        }
      }
      Stella_Class.markRenamingSlots(renamed_Class);
      if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE) {
        constructordefs = Stella_Class.cppGetConstructorDefinitions(renamed_Class);
      }
      if (Stella.cppOutputTemplateClassesP()) {
        parameterizedmembervardefs = Stella_Class.cppGetParameterizedMemberVariableDefinitions(renamed_Class);
      }
      { Object [] caller_MV_returnarray = new Object[1];

        publicmembervardefs = Stella_Class.cppGetMemberVariableDefinitions(renamed_Class, caller_MV_returnarray);
        protectedmembervardefs = ((Cons)(caller_MV_returnarray[0]));
      }
      { Object [] caller_MV_returnarray = new Object[1];

        publicmemberfuncdefs = Stella_Class.cppGetMethodDefinitions(renamed_Class, caller_MV_returnarray);
        protectedmemberfuncdefs = ((Cons)(caller_MV_returnarray[0]));
      }
      staticmembervardefs = Stella_Class.cppGetStaticVariableDefinitions(renamed_Class);
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_CLASS, Cons.cons(GeneralizedSymbol.cppTranslateClassName(Symbol.internSymbolInModule(renamed_Class.classType.symbolName, ((Module)(renamed_Class.classType.homeContext)), false)), Cons.cons(Cons.cons(parameters, Cons.cons(baseclasses, Cons.cons(staticmembervardefs, (((((StringWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue != null) ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_COMMENT, Cons.cons(StringWrapper.wrapString(((StringWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL) : Stella.NIL)).concatenate((((!(parameterizedmembervardefs == Stella.NIL)) ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_DECLARATIONS, Cons.cons(Stella.KWD_PUBLIC, Cons.cons(parameterizedmembervardefs, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL) : Stella.NIL)).concatenate((((!(publicmembervardefs == Stella.NIL)) ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_DECLARATIONS, Cons.cons(Stella.KWD_PUBLIC, Cons.cons(publicmembervardefs, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL) : Stella.NIL)).concatenate((((!(protectedmembervardefs == Stella.NIL)) ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_DECLARATIONS, Cons.cons(Stella.KWD_PUBLIC, Cons.cons(protectedmembervardefs, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL) : Stella.NIL)).concatenate((((!(constructordefs == Stella.NIL)) ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_SIGNATURES, Cons.cons(Stella.KWD_PUBLIC, Cons.cons(constructordefs, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL) : Stella.NIL)).concatenate(((Stella_Class.exceptionClassP(renamed_Class) ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_DEFINITIONS, Cons.cons(Stella.KWD_PUBLIC, Cons.cons(Cons.cons(Stella_Class.cppYieldExceptionConstructorDefinition(renamed_Class), Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL) : Stella.NIL)).concatenate((((!(publicmemberfuncdefs == Stella.NIL)) ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_SIGNATURES, Cons.cons(Stella.KWD_PUBLIC, Cons.cons(publicmemberfuncdefs, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL) : Stella.NIL)).concatenate((((!(protectedmemberfuncdefs == Stella.NIL)) ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_SIGNATURES, Cons.cons(Stella.KWD_PUBLIC, Cons.cons(protectedmemberfuncdefs, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL), Stella.NIL), Stella.NIL), Stella.NIL), Stella.NIL), Stella.NIL), Stella.NIL), Stella.NIL)))), Stella.NIL)))));
    }
  }

  public static Cons cppTranslateDefineMethodUnit(TranslationUnit unit) {
    { Object old$Methodbeingwalked$000 = Stella.$METHODBEINGWALKED$.get();
      Object old$Currentdummyindex$000 = Stella.$CURRENTDUMMYINDEX$.get();
      Object old$Dummydeclarations$000 = Stella.$DUMMYDECLARATIONS$.get();

      try {
        Native.setSpecial(Stella.$METHODBEINGWALKED$, null);
        Native.setIntSpecial(Stella.$CURRENTDUMMYINDEX$, 0);
        Native.setSpecial(Stella.$DUMMYDECLARATIONS$, Stella.NIL);
        { MethodSlot method = ((MethodSlot)(unit.theObject));
          boolean unitisfunction = MethodSlot.cppMethodObjectIsFunctionP(method);
          Cons bodytree = ((Cons)(unit.codeRegister));
          Cons returntype = null;
          Cons otree = Stella.NIL;
          Cons translatedmethodbody = null;

          Native.setSpecial(Stella.$METHODBEINGWALKED$, method);
          bodytree = Cons.deleteQuotedNullStatements(bodytree);
          if (!unitisfunction) {
            Native.setSpecial(Stella.$DUMMYDECLARATIONS$, Cons.cons(Cons.cons(((Symbol)(method.methodParameterNames().first())), Cons.cons(method.slotOwner, Cons.cons(Stella.SYM_STELLA_THIS, Stella.NIL))), ((Cons)(Stella.$DUMMYDECLARATIONS$.get()))));
          }
          translatedmethodbody = Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, Cons.cppTranslateListOfTrees(bodytree).concatenate(Stella.NIL, Stella.NIL));
          if (!(((Cons)(Stella.$DUMMYDECLARATIONS$.get())) == Stella.NIL)) {
            translatedmethodbody = Cons.wrapMethodBodyWithCppAuxiliaryDeclarations(translatedmethodbody, ((Cons)(Stella.$DUMMYDECLARATIONS$.get())));
          }
          if (((StringWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue != null) {
            translatedmethodbody.rest = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_COMMENT, Cons.cons(StringWrapper.wrapString(((StringWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue), Cons.cons(Stella.NIL, Stella.NIL)))), translatedmethodbody.rest.concatenate(Stella.NIL, Stella.NIL));
          }
          returntype = (MethodSlot.cppConstructorP(method) ? Stella.NIL : Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(MethodSlot.computeMostGeneralReturnType(method, method.computeReturnTypeSpec(method.slotOwner))), Stella.NIL));
          otree = Cons.cons((unitisfunction ? Stella.SYM_STELLA_CPP_FUNCTION : Stella.SYM_STELLA_CPP_METHOD), Cons.cons(returntype, Cons.cons(MethodSlot.cppTranslateMethodName(method, false), Cons.cons(MethodSlot.cppTranslateFunctionParameters(method), Cons.cons(translatedmethodbody, Stella.NIL)))));
          if (MethodSlot.cCallableWrapperMethodP(method)) {
            otree = Cons.cons(Stella.SYM_STELLA_CPP_EXTERN_C, otree);
            otree.thirdSetter(Stella_Object.substituteConsTree(otree.rest.rest.value, StringWrapper.wrapString("int"), StringWrapper.wrapString("boolean")));
            { Stella_Object vardecl = null;
              Cons iter000 = ((Cons)(otree.fifth()));

              for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                vardecl = iter000.value;
                if (Stella_Object.consP(vardecl) &&
                    Stella_Object.eqlToStringP(((Cons)(vardecl)).value, "boolean")) {
                  ((Cons)(vardecl)).firstSetter(StringWrapper.wrapString("int"));
                }
              }
            }
          }
          return (otree);
        }

      } finally {
        Stella.$DUMMYDECLARATIONS$.set(old$Dummydeclarations$000);
        Stella.$CURRENTDUMMYINDEX$.set(old$Currentdummyindex$000);
        Stella.$METHODBEINGWALKED$.set(old$Methodbeingwalked$000);
      }
    }
  }

  public static Cons cppTranslateDefineGlobalVariableUnit(TranslationUnit unit) {
    { GlobalVariable global = ((GlobalVariable)(unit.theObject));
      StandardObject type = GlobalVariable.globalVariableTypeSpec(global);
      Stella_Object initialvaluetree = ((unit.codeRegister == Stella.KWD_UNBOUND_SPECIAL_VARIABLE) ? ((Stella_Object)(null)) : Stella_Object.cppTranslateATree(unit.codeRegister));
      StringWrapper variablename = Symbol.cppTranslateGlobalName(Symbol.cppFixupNameSymbol(global.variableName, global.homeModule()));

      if (global.variableSpecialP) {
        if ((initialvaluetree == null) &&
            (Stella.specialImplementationStyle() == Stella.KWD_UNBIND_WITH_DESTRUCTORS)) {
          initialvaluetree = Stella_Object.cppTranslateATree(StandardObject.typeToWalkedNullValueTree(type, StandardObject.typeSpecToBaseType(type)));
        }
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_SPECIAL, Cons.cons(StringWrapper.wrapString(global.documentation), Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_TYPE, Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(type), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(variablename, Cons.cons((((initialvaluetree != null) ? Cons.cons(initialvaluetree, Stella.NIL) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Stella.NIL)))));
      }
      else {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_GLOBAL, Cons.cons(StringWrapper.wrapString(global.documentation), Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_TYPE, Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(type), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(variablename, Cons.cons(Cons.cons(initialvaluetree, Stella.NIL), Stella.NIL)))), Stella.NIL)))));
      }
    }
  }

  public static Cons cppTranslateDefprintUnit(TranslationUnit unit) {
    { Stella_Object printform = unit.codeRegister;
      Stella_Class renamed_Class = ((Stella_Class)(unit.theObject));
      StringWrapper classname = null;

      classname = StandardObject.cppTranslateAndPointerizeTypeSpec(renamed_Class.classType);
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_DEFPRINT, Cons.cons(classname, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, Cons.cons(Stella_Object.cppTranslateATree(printform), Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_RETURN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(Symbol.cppTranslateName(Stella.SYM_STELLA_STREAM), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons cppTranslateUnit(TranslationUnit unit) {
    { Object old$CppCurrentUnitModule$000 = Stella.$CPP_CURRENT_UNIT_MODULE$.get();

      try {
        Native.setSpecial(Stella.$CPP_CURRENT_UNIT_MODULE$, ((Module)(Stella.$MODULE$.get())));
        if (unit.theObject != null) {
          Native.setSpecial(Stella.$CPP_CURRENT_UNIT_MODULE$, unit.theObject.homeModule());
        }
        { Symbol testValue000 = unit.category;

          if (testValue000 == Stella.SYM_STELLA_GLOBAL_VARIABLE) {
            return (TranslationUnit.cppTranslateDefineGlobalVariableUnit(unit));
          }
          else if (testValue000 == Stella.SYM_STELLA_CLASS) {
            return (TranslationUnit.cppTranslateDefineNativeClassUnit(unit));
          }
          else if (testValue000 == Stella.SYM_STELLA_TYPE) {
            return (Stella.NIL);
          }
          else if ((testValue000 == Stella.SYM_STELLA_METHOD) ||
              (testValue000 == Stella.SYM_STELLA_MACRO)) {
            return (TranslationUnit.cppTranslateDefineMethodUnit(unit));
          }
          else if (testValue000 == Stella.SYM_STELLA_PRINT_METHOD) {
            return (TranslationUnit.cppTranslateDefprintUnit(unit));
          }
          else if ((testValue000 == Stella.SYM_STELLA_STARTUP_TIME_PROGN) ||
              (testValue000 == Stella.SYM_STELLA_VERBATIM)) {
            return (((Cons)(Stella_Object.cppTranslateATree(unit.theObject))));
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }

      } finally {
        Stella.$CPP_CURRENT_UNIT_MODULE$.set(old$CppCurrentUnitModule$000);
      }
    }
  }

  public static void cppOutputMain(TranslationUnit unit) {
    { OutputFileStream out = null;

      try {
        out = Stella.openOutputFile(Stella.cppYieldMainFileName(), Stella.NIL);
        { Object old$CurrentStream$000 = Stella.$CURRENT_STREAM$.get();

          try {
            Native.setSpecial(Stella.$CURRENT_STREAM$, out);
            if (((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null) {
              {
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("// main entry point for " + ((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).name + " system");
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
              }
;
            }
            Stella.cppOutputImportDeclarations(null);
            { Module usee = null;
              Cons iter000 = ((Cons)(Stella_Object.copyConsTree(Module.visibleModules(((Module)(Stella.$MODULE$.get()))).consify()))).reverse();

              for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                usee = ((Module)(iter000.value));
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("using namespace " + Module.cppYieldNamespacePrefixFromModule(usee) + ";");
              }
            }
            ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
            Stella_Object.cppOutputStatement(unit.translation);

          } finally {
            Stella.$CURRENT_STREAM$.set(old$CurrentStream$000);
          }
        }

      } finally {
        if (out != null) {
          out.free();
        }
      }
    }
  }

  public static boolean cppUnitDefinesMainP(TranslationUnit unit) {
    return ((unit.category == Stella.SYM_STELLA_METHOD) &&
        (((MethodSlot)(unit.theObject)).slotName == Symbol.lookupSymbol("MAIN")));
  }

  public static void clOutputOneUnit(TranslationUnit unit, edu.isi.stella.javalib.NativeOutputStream stream) {
    { Stella_Object translation = unit.translation;

      if (translation == null) {
        Stella.STANDARD_OUTPUT.nativeStream.println("`" + unit + "' has a NULL translation.");
        return;
      }
      if (unit.category != null) {
        if (!(TranslationUnit.auxiliaryVariableUnitP(unit))) {
          stream.println();
        }
        if (unit.annotation != null) {
          {
            stream.println(";;; " + unit.annotation);
            stream.println();
          }
;
        }
        if (Stella_Object.isaP(translation, Stella.SGT_STELLA_CONS) &&
            (((Cons)(translation)).value == Stella.internCommonLispSymbol("PROGN"))) {
          { Stella_Object form = null;
            Cons iter000 = ((Cons)(translation)).rest;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              form = iter000.value;
              Stella_Object.printStellaDefinition(form, stream);
            }
          }
        }
        else {
          Stella_Object.printStellaDefinition(translation, stream);
        }
        unit.category = null;
      }
    }
  }

  public static boolean auxiliaryVariableUnitP(TranslationUnit unit) {
    return (unit.auxiliaryP &&
        (unit.category == Stella.SYM_STELLA_GLOBAL_VARIABLE));
  }

  public static Cons clTranslateDefprintUnit(TranslationUnit unit) {
    { Stella_Class renamed_Class = ((Stella_Class)(unit.theObject));
      Stella_Object body = unit.codeRegister;
      Cons extratrees = Stella.NIL;

      if (Symbol.methodCallTypeForVectorStructs(Stella.SYM_STELLA_PRINT_OBJECT, renamed_Class.classType, false) == Stella.SYM_STELLA_PRINT_OBJECT) {
        extratrees = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_$CLSYS_SELF$), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL);
      }
      else {
      }
      return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("DEFMETHOD"), Cons.cons(Stella.internCommonLispSymbol("PRINT-OBJECT"), Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella_Class.classSymbol(renamed_Class), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_STREAM, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(extratrees.concatenate(Cons.cons(Stella_Object.clTranslateATree(body), Stella.NIL), Stella.NIL), Stella.NIL))))));
    }
  }

  public static Cons clTranslateDefineGlobalVariableUnit(TranslationUnit unit) {
    { GlobalVariable global = ((GlobalVariable)(unit.theObject));
      Stella_Object name = Symbol.clTranslateGlobalSymbol(global.variableName);
      String documentation = global.documentation;
      boolean unboundspecialP = global.variableSpecialP &&
          (unit.codeRegister == Stella.KWD_UNBOUND_SPECIAL_VARIABLE);
      Stella_Object initialvaluetree = Stella_Object.clTranslateATree(unit.codeRegister);
      Cons typedeclarationtree = (Stella.generateClTypeDeclarationsP() ? GlobalVariable.clYieldGlobalVariableTypeDeclarationTree(global) : ((Cons)(null)));
      Symbol operator = Stella.internCommonLispSymbol("DEFVAR");
      Cons otree = Stella.NIL;

      otree = (unboundspecialP ? Cons.list$(Cons.cons(Stella.internCommonLispSymbol("DEFVAR"), Cons.cons(name, Cons.cons(Stella.NIL, Stella.NIL)))) : Cons.cons(operator, Cons.cons(name, Cons.cons(initialvaluetree, (((documentation != null) ? Cons.cons(StringWrapper.wrapString(documentation), Stella.NIL) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL)))));
      if (typedeclarationtree != null) {
        otree = Cons.list$(Cons.cons(Stella.internCommonLispSymbol("PROGN"), Cons.cons(otree, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("DECLAIM"), Cons.cons(typedeclarationtree, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL))));
      }
      return (otree);
    }
  }

  public static Cons clTranslateDefineNativeClassUnit(TranslationUnit unit) {
    { Stella_Class renamed_Class = ((Stella_Class)(unit.theObject));

      if (Stella_Class.exceptionClassP(renamed_Class)) {
        return (Stella_Class.yieldConditionTree(renamed_Class));
      }
      else if ((!((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_STRUCTS)) ||
          Stella_Class.clAlwaysTranslateToClosClassP(renamed_Class)) {
        return (Stella_Class.yieldClosClassTree(renamed_Class));
      }
      else if (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_VECTOR_STRUCTS)) {
        return (Stella_Class.yieldVectorStructTree(renamed_Class));
      }
      else {
        return (Stella_Class.yieldStructTree(renamed_Class));
      }
    }
  }

  public static Cons clTranslateDefineMethodUnit(TranslationUnit unit) {
    { MethodSlot method = ((MethodSlot)(unit.theObject));
      Symbol methodname = method.slotName;
      String documentation = ((StringWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue;
      boolean functionP = method.methodFunctionP;
      Cons bodytree = ((Cons)(unit.codeRegister));
      Cons declarations = Stella.NIL;
      Cons methoddeclaration = null;
      Cons otree = Stella.NIL;

      if ((methodname == Stella.SYM_STELLA_PRINT_OBJECT) &&
          ((method.slotOwner == Stella.SGT_STELLA_CONS) &&
           ((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_CONSES))) {
        return (null);
      }
      { Symbol testValue000 = Symbol.methodCallTypeForVectorStructs(methodname, method.slotOwner, functionP);

        if (testValue000 == Stella.SYM_STELLA_PRINT_OBJECT) {
          bodytree = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_$CLSYS_SELF$), Cons.cons(Stella.NIL, Stella.NIL))))), bodytree);
        }
        else if (testValue000 == Stella.SYM_STELLA_NON_OBJECT_METHOD) {
          declarations = Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("IGNORE"), Cons.cons(Stella.SYM_STELLA_CLSYS_DUMMY, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL);
        }
        else {
        }
      }
      if (Stella.generateClTypeDeclarationsP()) {
        declarations = declarations.concatenate(MethodSlot.clYieldMethodParameterTypeDeclarationTrees(method), Stella.NIL);
        methoddeclaration = MethodSlot.clYieldMethodTypeDeclarationTree(method);
      }
      if ((!functionP) &&
          method.abstractP) {
        otree = Cons.cons(MethodSlot.clMethodDefinitionOperator(method), Cons.cons(Symbol.clTranslateGlobalSymbol(Symbol.yieldRenamedNameIfNative(methodname, Stella.KWD_COMMON_LISP, Stella.KWD_FUNCTION)), Cons.cons(MethodSlot.clTranslateMethodParameters(method), Stella.NIL)));
      }
      else {
        otree = Cons.cons(MethodSlot.clMethodDefinitionOperator(method), Cons.cons(Symbol.clTranslateGlobalSymbol(Symbol.yieldRenamedNameIfNative(methodname, Stella.KWD_COMMON_LISP, Stella.KWD_FUNCTION)), Cons.cons(MethodSlot.clTranslateMethodParameters(method), (((documentation != null) ? Cons.cons(StringWrapper.wrapString(documentation), Stella.NIL) : Stella.NIL)).concatenate(Cons.clYieldDeclareTree(declarations, true).concatenate(Cons.clTranslateListOfTrees(bodytree).concatenate((((StandardObject.voidP(method.type()) &&
            (!Stella.preserveTailMergeOptimizabilityP())) ? Cons.cons(Stella.KWD_VOID, Stella.NIL) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL), Stella.NIL), Stella.NIL), Stella.NIL))));
      }
      if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_SLOT_AUXILIARYp, Stella.FALSE_WRAPPER))).wrapperValue) {
        method.free();
      }
      if (methoddeclaration != null) {
        otree = Cons.list$(Cons.cons(Stella.internCommonLispSymbol("PROGN"), Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("DECLAIM"), Cons.cons(methoddeclaration, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(otree, Cons.cons(Stella.NIL, Stella.NIL)))));
      }
      return (otree);
    }
  }

  public static Stella_Object clTranslateUnit(TranslationUnit unit) {
    { Symbol testValue000 = unit.category;

      if (testValue000 == Stella.SYM_STELLA_GLOBAL_VARIABLE) {
        return (TranslationUnit.clTranslateDefineGlobalVariableUnit(unit));
      }
      else if (testValue000 == Stella.SYM_STELLA_CLASS) {
        return (TranslationUnit.clTranslateDefineNativeClassUnit(unit));
      }
      else if ((testValue000 == Stella.SYM_STELLA_METHOD) ||
          (testValue000 == Stella.SYM_STELLA_MACRO)) {
        return (TranslationUnit.clTranslateDefineMethodUnit(unit));
      }
      else if (testValue000 == Stella.SYM_STELLA_PRINT_METHOD) {
        return (TranslationUnit.clTranslateDefprintUnit(unit));
      }
      else if ((testValue000 == Stella.SYM_STELLA_STARTUP_TIME_PROGN) ||
          (testValue000 == Stella.SYM_STELLA_VERBATIM)) {
        return (Stella_Object.clTranslateATree(unit.theObject));
      }
      else if (testValue000 == Stella.SYM_STELLA_TYPE) {
        unit.category = null;
        return (Stella.NIL);
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static void walkModuleUnit(TranslationUnit unit) {
    { Module module = ((Module)(unit.theObject));

      Cons.walkAuxiliaryTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_STARTUP_TIME_PROGN, Cons.cons(Stella.KWD_MODULES, Cons.cons(Module.yieldDefineModule(module), Cons.cons(Stella.NIL, Stella.NIL))))));
    }
  }

  public static void walkVerbatimUnit(TranslationUnit unit) {
    unit.theObject = Stella_Object.walkATree(unit.codeRegister, new Object[1]);
    if (unit.theObject != null) {
      ((List)(Stella.$TRANSLATIONUNITS$.get())).push(unit);
      unit.codeRegister = null;
    }
    else {
      unit.codeRegister = null;
      TranslationUnit.clearTranslationUnit(unit);
    }
  }

  public static boolean earlierStartupUnitP(TranslationUnit unit1, TranslationUnit unit2) {
    return (Keyword.encodeStartupTimePhase(((Keyword)(unit1.codeRegister))) < Keyword.encodeStartupTimePhase(((Keyword)(unit2.codeRegister))));
  }

  public static void walkStartupTimePrognUnit(TranslationUnit unit) {
    { Cons tree = ((Cons)(unit.codeRegister));
      Keyword phase = Cons.extractStartupTimePhase(tree);

      ((List)(Stella.$TRANSLATIONUNITS$.get())).push(unit);
      unit.theObject = Cons.walkListOfStatements(tree.rest);
      unit.codeRegister = phase;
    }
  }

  public static void walkTypeUnit(TranslationUnit unit) {
    { String stringifieddefinition = Native.stringify(unit.codeRegister);

      ((List)(Stella.$TRANSLATIONUNITS$.get())).push(unit);
      Cons.walkAuxiliaryTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_STARTUP_TIME_PROGN, Cons.cons(Stella.KWD_CLASSES, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINE_STELLA_TYPE_FROM_STRINGIFIED_SOURCE, Cons.cons(StringWrapper.wrapString(stringifieddefinition), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))));
      GeneralizedSymbol.registerSymbol(Symbol.internSymbolInModule(((Surrogate)(unit.theObject)).symbolName, ((Module)(((Surrogate)(unit.theObject)).homeContext)), true));
    }
  }

  public static void walkGlobalUnit(TranslationUnit unit) {
    { GlobalVariable global = ((GlobalVariable)(unit.theObject));
      Stella_Object initialvaluetree = unit.codeRegister;
      String stringifiedsource = global.variableStringifiedSource;

      ((List)(Stella.$TRANSLATIONUNITS$.get())).push(unit);
      if (!(initialvaluetree == Stella.KWD_UNBOUND_SPECIAL_VARIABLE)) {
        if (global.variableSpecialP &&
            (Stella.translateToJavaP() ||
             Stella.supportUnexecP())) {
          global.variableConstantP = false;
          Cons.walkAuxiliaryTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_STARTUP_TIME_PROGN, Cons.cons(Stella.KWD_GLOBALS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_SET_DEFAULT, Cons.cons(global.variableName, Cons.cons(Cons.cons(initialvaluetree, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))));
          initialvaluetree = Stella.KWD_UNBOUND_SPECIAL_VARIABLE;
        }
        else if (Stella_Object.wrapperP(initialvaluetree) ||
            ((Stella_Object.symbolP(initialvaluetree) &&
            (Symbol.constantSymbolP(((Symbol)(initialvaluetree))) &&
             ((!(initialvaluetree == Stella.SYM_STELLA_NULL)) ||
              (Surrogate.typeToNullValueTree(global.variableType) == Stella.SYM_STELLA_NULL)))) ||
             (Stella_Object.consP(initialvaluetree) &&
              (((Cons)(initialvaluetree)).value == Stella.SYM_STELLA_VERBATIM)))) {
          initialvaluetree = Stella_Object.walkExpressionTree(initialvaluetree, GlobalVariable.globalVariableTypeSpec(global), global.variableName, true, new Object[1]);
        }
        else {
          global.variableConstantP = false;
          Cons.walkAuxiliaryTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_STARTUP_TIME_PROGN, Cons.cons(Stella.KWD_GLOBALS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(global.variableName, Cons.cons(Cons.cons(initialvaluetree, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))));
          if (Stella.supportUnexecP()) {
            initialvaluetree = Stella.KWD_UNBOUND_SPECIAL_VARIABLE;
          }
          else {
            initialvaluetree = StandardObject.typeToWalkedNullValueTree(GlobalVariable.globalVariableTypeSpec(global), StandardObject.typeSpecToBaseType(global.variableType));
          }
        }
      }
      unit.codeRegister = initialvaluetree;
      if (!(unit.auxiliaryP)) {
        Cons.walkAuxiliaryTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_STARTUP_TIME_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINE_STELLA_GLOBAL_VARIABLE_FROM_STRINGIFIED_SOURCE, Cons.cons(StringWrapper.wrapString(stringifiedsource), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))));
      }
    }
  }

  public static void walkSlotUnit(TranslationUnit unit) {
    { StorageSlot slot = ((StorageSlot)(unit.theObject));
      Stella_Class ownerclass = ((Stella_Class)(slot.slotOwner.surrogateValue));
      String stringifieddefinition = Native.stringify(unit.codeRegister);

      StorageSlot.createAccessorUnitsForSlot(slot, ownerclass, false, false);
      TranslationUnit.clearTranslationUnit(unit);
      Cons.walkAuxiliaryTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_STARTUP_TIME_PROGN, Cons.cons(Stella.KWD_METHODS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINE_EXTERNAL_SLOT_FROM_STRINGIFIED_SOURCE, Cons.cons(StringWrapper.wrapString(stringifieddefinition), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))));
    }
  }

  public static void walkClassUnit(TranslationUnit unit) {
    { Stella_Class renamed_Class = ((Stella_Class)(unit.theObject));
      Cons startuptimecode = null;

      if (!renamed_Class.classFinalizedP) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Cannot translate class `" + Stella_Class.classSymbol(renamed_Class) + "', since it could not be finalized.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        TranslationUnit.clearTranslationUnit(unit);
        return;
      }
      if (Stella_Class.createNativeClassP(renamed_Class)) {
        Stella_Class.warnAboutMultipleParents(renamed_Class);
        Stella_Class.warnAboutNonDirectSupers(renamed_Class);
        Stella_Class.cleanupAuxiliaryMethods(renamed_Class);
        if (!(renamed_Class.mixinP &&
            Stella.translateToSingleInheritanceLanguageP())) {
          ((List)(Stella.$TRANSLATIONUNITS$.get())).push(unit);
          Stella_Class.createConstructorAndDestructorUnits(renamed_Class);
          Stella_Class.createInlineMethodUnits(renamed_Class);
        }
        Stella_Class.createSlotAccessorUnits(renamed_Class);
        if (Stella.translateToSingleInheritanceLanguageP()) {
          Stella_Class.createMixinMethodUnits(renamed_Class);
        }
        { Slot slot = null;
          Cons iter000 = renamed_Class.classLocalSlots.theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            slot = ((Slot)(iter000.value));
            if (Stella_Object.storageSlotP(slot) &&
                (StorageSlot.nativeSlotP(((StorageSlot)(slot))) &&
                 ((Slot.nativeSlotHome(slot, renamed_Class) == renamed_Class) &&
                  ((!(renamed_Class.homeModule() == slot.homeModule())) &&
                   Slot.slotNameConflictP(slot, renamed_Class))))) {
              if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
                { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationWarning();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
                      {
                        Stella.STANDARD_WARNING.nativeStream.println();
                        Stella.STANDARD_WARNING.nativeStream.println(" Defining slot `" + Stella_Object.deUglifyParseTree(slot) + "' outside the home module of");
                        Stella.STANDARD_WARNING.nativeStream.println("   its owner class will be illegal in C++ and Java.");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                  }
                }
              }
              else {
                { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationError();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                      {
                        Stella.STANDARD_ERROR.nativeStream.println();
                        Stella.STANDARD_ERROR.nativeStream.println(" Slot `" + Stella_Object.deUglifyParseTree(slot) + "' is defined outside the home module of ");
                        Stella.STANDARD_ERROR.nativeStream.println("   its owner class `" + Stella_Object.deUglifyParseTree(renamed_Class) + "', and the name of");
                        Stella.STANDARD_ERROR.nativeStream.println("   the slot conflicts with another slot..");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
                  }
                }
                while (!(((TranslationUnit)(((List)(Stella.$TRANSLATIONUNITS$.get())).pop())) == unit)) {
                }
                TranslationUnit.clearTranslationUnit(unit);
                return;
              }
            }
          }
        }
      }
      Stella_Class.createDefprintUnit(renamed_Class);
      startuptimecode = Stella_Class.yieldInitializeHardwiredSlots(renamed_Class).concatenate(Stella_Class.yieldConstructorAttachment(renamed_Class, Stella.SYM_STELLA_CLASS).concatenate(Stella_Class.yieldGenericSlotAccessorAttachment(renamed_Class, Stella.SYM_STELLA_CLASS).concatenate(Stella.NIL, Stella.NIL), Stella.NIL), Stella.NIL);
      Cons.walkAuxiliaryTree(((startuptimecode == Stella.NIL) ? Cons.list$(Cons.cons(Stella.SYM_STELLA_STARTUP_TIME_PROGN, Cons.cons(Stella.KWD_CLASSES, Cons.cons(Stella_Class.yieldDefineStellaClass(renamed_Class), Cons.cons(Stella.NIL, Stella.NIL))))) : Cons.list$(Cons.cons(Stella.SYM_STELLA_STARTUP_TIME_PROGN, Cons.cons(Stella.KWD_CLASSES, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CLASS, Cons.cons(Stella_Class.yieldDefineStellaClass(renamed_Class), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(startuptimecode.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))));
      { Surrogate synonym = null;
        Cons iter001 = renamed_Class.classSynonyms().theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          synonym = ((Surrogate)(iter001.value));
          GeneralizedSymbol.registerSymbol(Symbol.internSymbolInModule(synonym.symbolName, ((Module)(synonym.homeContext)), true));
        }
      }
    }
  }

  public static void walkMethodUnit(TranslationUnit unit) {
    { Object old$Currenttranslationunit$000 = Stella.$CURRENTTRANSLATIONUNIT$.get();

      try {
        Native.setSpecial(Stella.$CURRENTTRANSLATIONUNIT$, unit);
        { MethodSlot method = ((MethodSlot)(unit.theObject));
          Symbol name = method.slotName;
          Cons body = ((Cons)(unit.codeRegister));
          boolean createmethodobjectP = true;
          boolean storecodepointerP = true;
          MethodSlot evaluatorwrappermethod = null;

          if (Slot.mixinMethodP(method) &&
              Stella.translateToSingleInheritanceLanguageP()) {
            TranslationUnit.clearTranslationUnit(unit);
            Cons.walkAuxiliaryTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_STARTUP_TIME_PROGN, Cons.cons(Stella.KWD_METHODS, Cons.cons(MethodSlot.yieldDefineStellaMethodObject(method, null, null), Cons.cons(Stella.NIL, Stella.NIL))))));
            return;
          }
          if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_FORWARD_DECLARATIONp, Stella.FALSE_WRAPPER))).wrapperValue) {
            KeyValueList.setDynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_FORWARD_DECLARATIONp, Stella.FALSE_WRAPPER, Stella.FALSE_WRAPPER);
          }
          if ((!method.methodFunctionP) &&
              ((!((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_METHOD_NATIVEp, Stella.FALSE_WRAPPER))).wrapperValue) &&
               (!(method.homeModule() == ((Stella_Class)(method.owner().surrogateValue)).homeModule())))) {
            if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
              { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationWarning();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
                    {
                      Stella.STANDARD_WARNING.nativeStream.println();
                      Stella.STANDARD_WARNING.nativeStream.println(" Defining method `" + Stella_Object.deUglifyParseTree(method) + "' outside the home module of");
                      Stella.STANDARD_WARNING.nativeStream.println("   its owner class will be illegal in C++ and Java.");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                }
              }
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
                      Stella.STANDARD_ERROR.nativeStream.println(" Defining method `" + Stella_Object.deUglifyParseTree(method) + "' outside the home module of");
                      Stella.STANDARD_ERROR.nativeStream.println("   its owner class is illegal in `" + Stella.translatorOutputLanguageName() + "'.");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                }
              }
              TranslationUnit.clearTranslationUnit(unit);
              return;
            }
          }
          if ((body == Stella.NIL) &&
              (((Symbol)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_METHOD_INHERITS_THROUGH, null))) == null)) {
            TranslationUnit.walkMethodObject(unit);
            if (!(((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_METHOD_NATIVEp, Stella.FALSE_WRAPPER))).wrapperValue ||
                method.abstractP)) {
              createmethodobjectP = false;
              KeyValueList.setDynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_FORWARD_DECLARATIONp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
              if (((Integer)(Stella.$TRANSLATIONVERBOSITYLEVEL$.get())).intValue() >= 3) {
                Stella.STANDARD_OUTPUT.nativeStream.println("Forward declaration of `" + method + "'");
              }
            }
            TranslationUnit.clearTranslationUnit(unit);
          }
          else if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_SLOT_AUXILIARYp, Stella.FALSE_WRAPPER))).wrapperValue ||
              unit.auxiliaryP) {
            createmethodobjectP = false;
            ((List)(Stella.$TRANSLATIONUNITS$.get())).push(unit);
            TranslationUnit.walkMethodObject(unit);
          }
          else {
            ((List)(Stella.$TRANSLATIONUNITS$.get())).push(unit);
            TranslationUnit.walkMethodObject(unit);
          }
          if (createmethodobjectP) {
            if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_METHOD_COMMANDp, Stella.FALSE_WRAPPER))).wrapperValue &&
                (!MethodSlot.commandP(method))) {
              { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationWarning();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
                    {
                      Stella.STANDARD_WARNING.nativeStream.println();
                      Stella.STANDARD_WARNING.nativeStream.println(" Ignored :command? declaration.  Currently, only functions can be commands..");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
                }
              }
            }
            if (MethodSlot.methodNeedsEvaluatorWrapperP(method)) {
              evaluatorwrappermethod = MethodSlot.createEvaluatorWrapperUnit(method);
            }
            if (MethodSlot.methodNeedsLispMacroP(method)) {
              Symbol.createLispMacroUnits(name, method);
            }
            if (MethodSlot.methodNeedsCCallableWrapperP(method)) {
              MethodSlot.createCCallableWrapperUnit(method);
            }
            if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_METHOD_NATIVEp, Stella.FALSE_WRAPPER))).wrapperValue ||
                (method.abstractP ||
                 (name == Stella.SYM_STELLA_MAIN))) {
              storecodepointerP = false;
            }
            Cons.walkAuxiliaryTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_STARTUP_TIME_PROGN, Cons.cons(Stella.KWD_METHODS, Cons.cons(MethodSlot.yieldDefineStellaMethodObject(method, (storecodepointerP ? method : null), (storecodepointerP ? evaluatorwrappermethod : null)), Cons.cons(Stella.NIL, Stella.NIL))))));
          }
        }

      } finally {
        Stella.$CURRENTTRANSLATIONUNIT$.set(old$Currenttranslationunit$000);
      }
    }
  }

  public static Cons walkMethodObject(TranslationUnit unit) {
    { MethodSlot method = ((MethodSlot)(unit.theObject));
      Cons body = ((Cons)(unit.codeRegister));

      { Object old$Localvariabletypetable$000 = Stella.$LOCALVARIABLETYPETABLE$.get();
        Object old$Localgensymtable$000 = Stella.$LOCALGENSYMTABLE$.get();
        Object old$Specialvariablestack$000 = Stella.$SPECIALVARIABLESTACK$.get();
        Object old$Methodbeingwalked$000 = Stella.$METHODBEINGWALKED$.get();
        Object old$FoundreturnP$000 = Stella.$FOUNDRETURNp$.get();

        try {
          Native.setSpecial(Stella.$LOCALVARIABLETYPETABLE$, KeyValueList.newKeyValueList());
          Native.setSpecial(Stella.$LOCALGENSYMTABLE$, KeyValueList.newKeyValueList());
          Native.setSpecial(Stella.$SPECIALVARIABLESTACK$, KeyValueList.newKeyValueList());
          Native.setSpecial(Stella.$METHODBEINGWALKED$, method);
          Native.setBooleanSpecial(Stella.$FOUNDRETURNp$, false);
          if (((Symbol)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_METHOD_INHERITS_THROUGH, null))) != null) {
            body = TranslationUnit.yieldSynthesizedMethodBody(unit);
          }
          { Symbol name = null;
            Cons iter000 = method.methodParameterNames().theConsList;
            StandardObject typespec = null;
            Cons iter001 = method.methodParameterTypeSpecifiers().theConsList;

            for (;(!(iter000 == Stella.NIL)) &&
                      (!(iter001 == Stella.NIL)); iter000 = iter000.rest, iter001 = iter001.rest) {
              name = ((Symbol)(iter000.value));
              typespec = ((StandardObject)(iter001.value));
              Symbol.walkADeclaration(name, typespec, null, true);
            }
          }
          if (!(body == Stella.NIL)) {
            { boolean testValue000 = false;

              testValue000 = Stella.checkForIllegalReturnP();
              if (testValue000) {
                testValue000 = !StandardObject.voidP(method.type());
                if (testValue000) {
                  testValue000 = !unit.auxiliaryP;
                  if (testValue000) {
                    testValue000 = !((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_SLOT_AUXILIARYp, Stella.FALSE_WRAPPER))).wrapperValue;
                    if (testValue000) {
                      { boolean foundP000 = false;

                        { Stella_Object form = null;
                          Cons iter002 = body;

                          loop001 : for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                            form = iter002.value;
                            if (Stella_Object.consP(form) &&
                                (((Cons)(form)).value == Stella.SYM_STELLA_RETURN)) {
                              foundP000 = true;
                              break loop001;
                            }
                          }
                        }
                        testValue000 = foundP000;
                      }
                      testValue000 = !testValue000;
                    }
                  }
                }
              }
              if (testValue000) {
                body = body.concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ERROR, Cons.cons(StringWrapper.wrapString("Returned from `"), Cons.cons(StringWrapper.wrapString(Native.stringify(method)), Cons.cons(Cons.cons(StringWrapper.wrapString("' without a `return'."), Stella.NIL), Stella.NIL))))), Stella.NIL), Stella.NIL);
              }
            }
            if (MethodSlot.logFunctionCallP(method) &&
                (!unit.auxiliaryP)) {
              body = MethodSlot.wrapBodyWithLogFunctionCallTree(method, body);
            }
            body = Cons.walkListOfStatements(body);
            if ((!StandardObject.voidP(method.type())) &&
                ((!method.abstractP) &&
                 (!((Boolean)(Stella.$FOUNDRETURNp$.get())).booleanValue()))) {
              { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationError();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                    {
                      Stella.STANDARD_ERROR.nativeStream.println();
                      Stella.STANDARD_ERROR.nativeStream.println(" Missing return statement.");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                }
              }
            }
          }
          ((KeyValueList)(Stella.$LOCALVARIABLETYPETABLE$.get())).free();
          ((KeyValueList)(Stella.$LOCALGENSYMTABLE$.get())).free();
          ((KeyValueList)(Stella.$SPECIALVARIABLESTACK$.get())).free();
          unit.codeRegister = body;
          return (body);

        } finally {
          Stella.$FOUNDRETURNp$.set(old$FoundreturnP$000);
          Stella.$METHODBEINGWALKED$.set(old$Methodbeingwalked$000);
          Stella.$SPECIALVARIABLESTACK$.set(old$Specialvariablestack$000);
          Stella.$LOCALGENSYMTABLE$.set(old$Localgensymtable$000);
          Stella.$LOCALVARIABLETYPETABLE$.set(old$Localvariabletypetable$000);
        }
      }
    }
  }

  public static Cons yieldSynthesizedMethodBody(TranslationUnit unit) {
    { MethodSlot method = ((MethodSlot)(unit.theObject));
      Cons body = ((Cons)(unit.codeRegister));

      if (method.methodParameterNames() == null) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Missing parameters for :inherits-through method.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
      }
      if (!(body == Stella.NIL)) {
        { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Over-specified definition of :inherits-through method.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
          }
        }
        return (body);
      }
      else {
        return (MethodSlot.synthesizeMethodBody(method));
      }
    }
  }

  public static boolean unitIncludedInOtherUnitsP(TranslationUnit unit) {
    { MethodSlot method = null;

      if (!(unit.category == Stella.SYM_STELLA_METHOD)) {
        return (false);
      }
      else {
        {
          method = ((MethodSlot)(unit.theObject));
          if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_METHOD_CONSTRUCTORp, Stella.FALSE_WRAPPER))).wrapperValue) {
            { TranslationUnit otherUnit = null;
              Cons iter000 = ((List)(Stella.$TRANSLATIONUNITS$.get())).theConsList;

              for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                otherUnit = ((TranslationUnit)(iter000.value));
                if ((otherUnit.category == Stella.SYM_STELLA_CLASS) &&
                    (Surrogate.canonicalType(method.slotBaseType) == ((Stella_Class)(otherUnit.theObject)).classType)) {
                  return (true);
                }
              }
            }
            return (false);
          }
          else {
            { TranslationUnit otherUnit = null;
              Cons iter001 = ((List)(Stella.$TRANSLATIONUNITS$.get())).theConsList;

              for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                otherUnit = ((TranslationUnit)(iter001.value));
                if ((otherUnit.category == Stella.SYM_STELLA_CLASS) &&
                    (Surrogate.canonicalType(method.slotOwner) == ((Stella_Class)(otherUnit.theObject)).classType)) {
                  return (true);
                }
              }
            }
            return (false);
          }
        }
      }
    }
  }

  public static void walkPhaseOneUnit(TranslationUnit unit) {
    { Object old$Localvariabletypetable$000 = Stella.$LOCALVARIABLETYPETABLE$.get();
      Object old$Currenttranslationunit$000 = Stella.$CURRENTTRANSLATIONUNIT$.get();

      try {
        Native.setSpecial(Stella.$LOCALVARIABLETYPETABLE$, KeyValueList.newKeyValueList());
        Native.setSpecial(Stella.$CURRENTTRANSLATIONUNIT$, unit);
        { Symbol testValue000 = unit.category;

          if (testValue000 == Stella.SYM_STELLA_GLOBAL_VARIABLE) {
            TranslationUnit.walkGlobalUnit(unit);
          }
          else if (testValue000 == Stella.SYM_STELLA_MODULE) {
            TranslationUnit.walkModuleUnit(unit);
          }
          else if (testValue000 == Stella.SYM_STELLA_TYPE) {
            TranslationUnit.walkTypeUnit(unit);
          }
          else if ((testValue000 == Stella.SYM_STELLA_METHOD) ||
              (testValue000 == Stella.SYM_STELLA_PRINT_METHOD)) {
            TranslationUnit.walkMethodUnit(unit);
          }
          else if (testValue000 == Stella.SYM_STELLA_CLASS) {
            TranslationUnit.walkClassUnit(unit);
          }
          else if (testValue000 == Stella.SYM_STELLA_SLOT) {
            TranslationUnit.walkSlotUnit(unit);
          }
          else if (testValue000 == Stella.SYM_STELLA_STARTUP_TIME_PROGN) {
            TranslationUnit.walkStartupTimePrognUnit(unit);
          }
          else if (testValue000 == Stella.SYM_STELLA_VERBATIM) {
            TranslationUnit.walkVerbatimUnit(unit);
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }

      } finally {
        Stella.$CURRENTTRANSLATIONUNIT$.set(old$Currenttranslationunit$000);
        Stella.$LOCALVARIABLETYPETABLE$.set(old$Localvariabletypetable$000);
      }
    }
  }

  public static void printTranslationUnit(TranslationUnit self, edu.isi.stella.javalib.NativeOutputStream stream) {
    stream.print("|TU|[" + self.category);
    { Symbol testValue000 = self.category;

      if ((testValue000 == Stella.SYM_STELLA_CLASS) ||
          ((testValue000 == Stella.SYM_STELLA_METHOD) ||
           (testValue000 == Stella.SYM_STELLA_GLOBAL_VARIABLE))) {
        stream.print(" " + self.theObject);
      }
      else {
      }
    }
    stream.print("]");
  }

  public static void clearTranslationUnit(TranslationUnit self) {
    self.tuHomeModule = null;
    self.theObject = null;
    self.category = null;
    self.codeRegister = null;
    self.translation = null;
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { TranslationUnit self = this;

      TranslationUnit.printTranslationUnit(self, stream);
    }
  }

  public static Stella_Object accessTranslationUnitSlotValue(TranslationUnit self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_TU_HOME_MODULE) {
      if (setvalueP) {
        self.tuHomeModule = ((Module)(value));
      }
      else {
        value = self.tuHomeModule;
      }
    }
    else if (slotname == Stella.SYM_STELLA_THE_OBJECT) {
      if (setvalueP) {
        self.theObject = value;
      }
      else {
        value = self.theObject;
      }
    }
    else if (slotname == Stella.SYM_STELLA_CATEGORY) {
      if (setvalueP) {
        self.category = ((Symbol)(value));
      }
      else {
        value = self.category;
      }
    }
    else if (slotname == Stella.SYM_STELLA_ANNOTATION) {
      if (setvalueP) {
        self.annotation = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.annotation);
      }
    }
    else if (slotname == Stella.SYM_STELLA_AUXILIARYp) {
      if (setvalueP) {
        self.auxiliaryP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.auxiliaryP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_CODE_REGISTER) {
      if (setvalueP) {
        self.codeRegister = value;
      }
      else {
        value = self.codeRegister;
      }
    }
    else if (slotname == Stella.SYM_STELLA_TRANSLATION) {
      if (setvalueP) {
        self.translation = value;
      }
      else {
        value = self.translation;
      }
    }
    else if (slotname == Stella.SYM_STELLA_REFERENCED_GLOBALS) {
      if (setvalueP) {
        self.referencedGlobals = ((List)(value));
      }
      else {
        value = self.referencedGlobals;
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

  public Module homeModule() {
    { TranslationUnit self = this;

      return (self.tuHomeModule);
    }
  }

  public Surrogate primaryType() {
    { TranslationUnit self = this;

      return (Stella.SGT_STELLA_TRANSLATION_UNIT);
    }
  }

}

