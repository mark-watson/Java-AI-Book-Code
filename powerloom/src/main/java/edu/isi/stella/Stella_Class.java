//  -*- Mode: Java -*-
//
// Stella_Class.java

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

public class Stella_Class extends Relation {
    public boolean clStructP;
    public boolean mixinP;
    public Surrogate classType;
    public List classDirectSupers;
    public List classDirectSubs;
    public Cons classAllSuperClasses;
    public Cons classAllSlots;
    public List classLocalSlots;
    public Vector classSlotAndMethodCache;
    public boolean classCollectionP;
    public boolean classPublicP;
    public boolean classFinalizedP;
    public boolean classSlotsFinalizedP;
    public String classStringifiedSource;
    public java.lang.reflect.Method classConstructorCode;
    public java.lang.reflect.Method classSlotAccessorCode;
    public boolean classMarkedP;
    public TaxonomyNode classTaxonomyNode;

  public static Stella_Class newClass() {
    { Stella_Class self = null;

      self = new Stella_Class();
      self.dynamicSlots = KeyValueList.newKeyValueList();
      self.classTaxonomyNode = null;
      self.classMarkedP = false;
      self.classSlotAccessorCode = null;
      self.classConstructorCode = null;
      self.classStringifiedSource = null;
      self.classSlotsFinalizedP = false;
      self.classFinalizedP = false;
      self.classPublicP = true;
      self.clStructP = false;
      self.classCollectionP = false;
      self.mixinP = false;
      self.abstractP = false;
      self.classSlotAndMethodCache = null;
      self.classLocalSlots = null;
      self.classAllSlots = null;
      self.classAllSuperClasses = Stella.NIL;
      self.classDirectSubs = List.newList();
      self.classDirectSupers = List.newList();
      self.classType = null;
      return (self);
    }
  }

  /** Helper method for <code>printOutline</code>
   * @param stream
   * @param currentDepth
   * @param depth
   * @param namedP
   */
  public void helpPrintOutline(OutputStream stream, int currentDepth, int depth, boolean namedP) {
    { Stella_Class top = this;

      Stella.indentOutline(currentDepth, stream);
      stream.nativeStream.println(top.name());
      if (!((depth != Stella.NULL_INTEGER) &&
          ((depth >= 0) &&
           (currentDepth >= depth)))) {
        currentDepth = currentDepth + 1;
        { Surrogate c = null;
          Cons iter000 = top.classDirectSubs.theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            c = ((Surrogate)(iter000.value));
            Surrogate.typeToClass(c).helpPrintOutline(stream, currentDepth, depth, namedP);
          }
        }
      }
    }
  }

  public static void idlTranslateClassToStream(Stella_Class renamed_Class, edu.isi.stella.javalib.NativeOutputStream nativeStream) {
    { TranslationUnit self000 = TranslationUnit.newTranslationUnit();

      self000.theObject = renamed_Class;
      { TranslationUnit tempunit = self000;

        { Object old$CurrentStream$000 = Stella.$CURRENT_STREAM$.get();

          try {
            Native.setSpecial(Stella.$CURRENT_STREAM$, null);
            { OutputStream self001 = OutputStream.newOutputStream();

              self001.nativeStream = nativeStream;
              Native.setSpecial(Stella.$CURRENT_STREAM$, self001);
            }
            Stella_Object.idlOutputStatement(TranslationUnit.idlTranslateDefineNativeClassUnit(tempunit));

          } finally {
            Stella.$CURRENT_STREAM$.set(old$CurrentStream$000);
          }
        }
      }
    }
  }

  public static Symbol idlClassCategory(Stella_Class renamed_Class) {
    if (!(renamed_Class.properties() != null)) {
      return (Stella.SYM_STELLA_IDL_INTERFACE);
    }
    { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(renamed_Class.properties().first()));

      if (testValue000 == Stella.SYM_STELLA_sIDL_THEORYsinterface) {
        return (Stella.SYM_STELLA_IDL_INTERFACE);
      }
      else if (testValue000 == Stella.SYM_STELLA_sIDL_THEORYsstruct) {
        return (Stella.SYM_STELLA_IDL_STRUCT);
      }
      else if (testValue000 == Stella.SYM_STELLA_sIDL_THEORYsenum) {
        return (Stella.SYM_STELLA_IDL_ENUM);
      }
      else if (testValue000 == Stella.SYM_STELLA_sIDL_THEORYstypedef) {
        return (Stella.SYM_STELLA_IDL_TYPEDEF);
      }
      else {
        return (Stella.SYM_STELLA_IDL_INTERFACE);
      }
    }
  }

  public static Cons idlGetOperationDefinitions(Stella_Class renamed_Class) {
    { Cons operationdefs = Stella.NIL;

      { Slot slot = null;
        Iterator iter000 = renamed_Class.classSlots();
        Cons collect000 = null;

        while (iter000.nextP()) {
          slot = ((Slot)(iter000.value));
          if ((!slot.slotMarkedP) &&
              ((slot.primaryType() == Stella.SGT_STELLA_METHOD_SLOT) &&
               (Slot.localSlotP(slot, renamed_Class) &&
                ((!MethodSlot.idlConstructorP(((MethodSlot)(slot)))) &&
                 ((!((MethodSlot)(slot)).methodFunctionP) &&
                  ((!MethodSlot.illegalIdlMethodP(((MethodSlot)(slot)))) &&
                   (!MethodSlot.methodContainsUnknownTypeP(((MethodSlot)(slot)))))))))) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(MethodSlot.idlYieldOperationSignatureTree(((MethodSlot)(slot))), Stella.NIL);
                if (operationdefs == Stella.NIL) {
                  operationdefs = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(operationdefs, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(MethodSlot.idlYieldOperationSignatureTree(((MethodSlot)(slot))), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      { MethodSlot auxiliary = null;
        Cons iter001 = renamed_Class.classAuxiliaryMethods().theConsList;
        Cons collect001 = null;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          auxiliary = ((MethodSlot)(iter001.value));
          if (collect001 == null) {
            {
              collect001 = Cons.cons(MethodSlot.idlYieldOperationSignatureTree(auxiliary), Stella.NIL);
              if (operationdefs == Stella.NIL) {
                operationdefs = collect001;
              }
              else {
                Cons.addConsToEndOfConsList(operationdefs, collect001);
              }
            }
          }
          else {
            {
              collect001.rest = Cons.cons(MethodSlot.idlYieldOperationSignatureTree(auxiliary), Stella.NIL);
              collect001 = collect001.rest;
            }
          }
        }
      }
      return (operationdefs);
    }
  }

  public static Cons idlGetConstructorDefinitions(Stella_Class renamed_Class) {
    { Cons constructordefs = Stella.NIL;

      { Slot slot = null;
        Iterator iter000 = renamed_Class.classSlots();
        Cons collect000 = null;

        while (iter000.nextP()) {
          slot = ((Slot)(iter000.value));
          if ((!slot.slotMarkedP) &&
              ((slot.primaryType() == Stella.SGT_STELLA_METHOD_SLOT) &&
               (Slot.localSlotP(slot, renamed_Class) &&
                MethodSlot.idlConstructorP(((MethodSlot)(slot)))))) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(MethodSlot.idlYieldConstructorSignatureTree(((MethodSlot)(slot))), Stella.NIL);
                if (constructordefs == Stella.NIL) {
                  constructordefs = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(constructordefs, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(MethodSlot.idlYieldConstructorSignatureTree(((MethodSlot)(slot))), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      return (constructordefs);
    }
  }

  public static Cons idlGetStaticVariableDefinitions(Stella_Class renamed_Class) {
    { Cons staticattributedefs = Stella.NIL;

      { Slot slot = null;
        Iterator iter000 = renamed_Class.classSlots();

        while (iter000.nextP()) {
          slot = ((Slot)(iter000.value));
          if (Stella_Object.storageSlotP(slot) &&
              (StorageSlot.nativeSlotP(((StorageSlot)(slot))) &&
               ((((StorageSlot)(slot)).slotAllocation() == Stella.KWD_CLASS) &&
                ((!StorageSlot.slotHasUnknownTypeP(((StorageSlot)(slot)), renamed_Class)) &&
                 ((!((StorageSlot)(slot)).slotHardwiredP) &&
                  (!slot.slotMarkedP)))))) {
            staticattributedefs = Cons.cons(StorageSlot.idlYieldStaticMemberAllocationTree(((StorageSlot)(slot)), renamed_Class), staticattributedefs);
          }
        }
      }
      return (staticattributedefs);
    }
  }

  public static Cons idlGetAttributeDefinitions(Stella_Class renamed_Class) {
    { Cons attributedefs = Stella.NIL;

      { Slot slot = null;
        Iterator iter000 = renamed_Class.classSlots();

        while (iter000.nextP()) {
          slot = ((Slot)(iter000.value));
          if (Stella_Object.storageSlotP(slot) &&
              (StorageSlot.nativeSlotP(((StorageSlot)(slot))) &&
               (Slot.nativeSlotHome(slot, renamed_Class) == renamed_Class))) {
            attributedefs = Cons.cons(StorageSlot.idlYieldAttributeTree(((StorageSlot)(slot)), renamed_Class), attributedefs);
          }
        }
      }
      return (attributedefs.reverse());
    }
  }

  public static Cons idlGetParameterizedAttributeDefinitions(Stella_Class renamed_Class) {
    { Cons attributedefs = Stella.NIL;

      { Slot slot = null;
        Cons iter000 = renamed_Class.classLocalSlots.theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          slot = ((Slot)(iter000.value));
          if (Stella_Object.storageSlotP(slot) &&
              (StorageSlot.nativeSlotP(((StorageSlot)(slot))) &&
               StorageSlot.slotHasClassParameterTypeP(((StorageSlot)(slot)), renamed_Class))) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(StorageSlot.idlYieldParameterizedAttributeTree(((StorageSlot)(slot)), renamed_Class), Stella.NIL);
                if (attributedefs == Stella.NIL) {
                  attributedefs = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(attributedefs, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(StorageSlot.idlYieldParameterizedAttributeTree(((StorageSlot)(slot)), renamed_Class), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      return (attributedefs);
    }
  }

  public static Cons javaTranslateDefineNativeClass(Stella_Class renamed_Class) {
    { Stella_Object parentclass = null;
      Cons interfaceclasses = Stella.NIL;
      Cons instancevardefs = Stella.NIL;
      Cons constructordefs = Stella.NIL;
      Cons modifiers = Stella.NIL;
      Cons methoddefs = Stella.NIL;

      { Object old$Context$000 = Stella.$CONTEXT$.get();
        Object old$Module$000 = Stella.$MODULE$.get();

        try {
          Native.setSpecial(Stella.$CONTEXT$, renamed_Class.homeModule());
          Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
          if (renamed_Class.mixinP) {
            return (Stella.NIL);
          }
          if (renamed_Class.abstractP) {
            modifiers = Cons.cons(StringWrapper.wrapString("abstract"), modifiers);
          }
          if (renamed_Class.publicP()) {
            modifiers = Cons.cons(StringWrapper.wrapString("public"), modifiers);
          }
          if (((Surrogate)(renamed_Class.classDirectSupers.first())) != null) {
            parentclass = GeneralizedSymbol.javaTranslateClassName(Surrogate.symbolize(((Surrogate)(renamed_Class.classDirectSupers.first()))));
          }
          instancevardefs = Stella_Class.javaGetInstanceVariableDefinitions(renamed_Class);
          { Object [] caller_MV_returnarray = new Object[1];

            constructordefs = Stella_Class.javaGetConstructorAndMethodDefinitions(renamed_Class, caller_MV_returnarray);
            methoddefs = ((Cons)(caller_MV_returnarray[0]));
          }
          return (Cons.cons((Stella_Class.exceptionClassP(renamed_Class) ? Stella.SYM_STELLA_JAVA_EXCEPTION_CLASS : Stella.SYM_STELLA_JAVA_CLASS), Cons.cons(((((StringWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue != null) ? StringWrapper.wrapString(((StringWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue) : null), Cons.cons(modifiers, Cons.cons((renamed_Class.mixinP ? StringWrapper.wrapString("interface") : StringWrapper.wrapString("class")), Cons.cons(GeneralizedSymbol.javaTranslateClassName(Symbol.internSymbolInModule(renamed_Class.classType.symbolName, ((Module)(renamed_Class.classType.homeContext)), false)), Cons.cons(parentclass, Cons.cons(interfaceclasses, Cons.cons(((!(instancevardefs == Stella.NIL)) ? Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_DECLARATIONS, instancevardefs.concatenate(Stella.NIL, Stella.NIL)), Stella.NIL) : Stella.NIL), Cons.cons(constructordefs, Cons.cons(methoddefs, Stella.NIL)))))))))));

        } finally {
          Stella.$MODULE$.set(old$Module$000);
          Stella.$CONTEXT$.set(old$Context$000);
        }
      }
    }
  }

  public static Cons javaGetConstructorAndMethodDefinitions(Stella_Class renamed_Class, Object [] MV_returnarray) {
    { Cons constructordefinitions = Stella.NIL;
      Cons methoddefinitions = Stella.NIL;
      MethodSlot method = null;

      { TranslationUnit tu = null;
        Cons iter000 = ((List)(Stella.$TRANSLATIONUNITS$.get())).theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          tu = ((TranslationUnit)(iter000.value));
          if ((tu.category == Stella.SYM_STELLA_METHOD) ||
              ((tu.category == Stella.SYM_STELLA_MACRO) ||
               (tu.category == Stella.SYM_STELLA_PRINT_METHOD))) {
            if (tu.category == Stella.SYM_STELLA_PRINT_METHOD) {
              if (Surrogate.canonicalType(((Stella_Class)(tu.theObject)).classType) == renamed_Class.classType) {
                methoddefinitions = Cons.cons(tu, methoddefinitions);
              }
            }
            else {
              {
                method = ((MethodSlot)(tu.theObject));
                if (MethodSlot.javaFlotsamFunctionP(method) ||
                    method.methodStartupFunctionP()) {
                }
                else if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_METHOD_CONSTRUCTORp, Stella.FALSE_WRAPPER))).wrapperValue) {
                  if (Surrogate.canonicalType(method.slotBaseType) == renamed_Class.classType) {
                    constructordefinitions = Cons.cons(tu, constructordefinitions);
                  }
                }
                else if (Surrogate.canonicalType(method.slotOwner) == renamed_Class.classType) {
                  methoddefinitions = Cons.cons(tu, methoddefinitions);
                }
              }
            }
          }
        }
      }
      { Cons _return_temp = constructordefinitions.reverse();

        MV_returnarray[0] = methoddefinitions.reverse();
        return (_return_temp);
      }
    }
  }

  public static Cons javaGetInstanceVariableDefinitions(Stella_Class renamed_Class) {
    if (renamed_Class.mixinP) {
      return (Stella.NIL);
    }
    { Cons instancevardefs = Stella.NIL;
      Stella_Class superclass = null;

      { Slot slot = null;
        Iterator iter000 = renamed_Class.classSlots();
        Cons collect000 = null;

        while (iter000.nextP()) {
          slot = ((Slot)(iter000.value));
          if (Stella_Object.storageSlotP(slot) &&
              (StorageSlot.nativeSlotP(((StorageSlot)(slot))) &&
               (Slot.nativeSlotHome(slot, renamed_Class) == renamed_Class))) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(StorageSlot.javaYieldInstanceVarTree(((StorageSlot)(slot)), renamed_Class), Stella.NIL);
                if (instancevardefs == Stella.NIL) {
                  instancevardefs = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(instancevardefs, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(StorageSlot.javaYieldInstanceVarTree(((StorageSlot)(slot)), renamed_Class), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      { Surrogate renamed_Super = null;
        Cons iter001 = renamed_Class.classDirectSupers.theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          renamed_Super = ((Surrogate)(iter001.value));
          superclass = renamed_Super.getStellaClass(true);
          if (superclass.mixinP) {
            { Slot slot = null;
              Iterator iter002 = superclass.classSlots();
              Cons collect001 = null;

              while (iter002.nextP()) {
                slot = ((Slot)(iter002.value));
                if (Stella_Object.storageSlotP(slot) &&
                    (StorageSlot.nativeSlotP(((StorageSlot)(slot))) &&
                     (Slot.nativeSlotHome(slot, superclass) == superclass))) {
                  if (collect001 == null) {
                    {
                      collect001 = Cons.cons(StorageSlot.javaYieldInstanceVarTree(((StorageSlot)(slot)), superclass), Stella.NIL);
                      if (instancevardefs == Stella.NIL) {
                        instancevardefs = collect001;
                      }
                      else {
                        Cons.addConsToEndOfConsList(instancevardefs, collect001);
                      }
                    }
                  }
                  else {
                    {
                      collect001.rest = Cons.cons(StorageSlot.javaYieldInstanceVarTree(((StorageSlot)(slot)), superclass), Stella.NIL);
                      collect001 = collect001.rest;
                    }
                  }
                }
              }
            }
          }
        }
      }
      return (instancevardefs);
    }
  }

  public static boolean classNameConflictsWithSlotNameP(Stella_Class definingClass, String javaClassName) {
    if (definingClass != null) {
      { Slot slot = null;
        Iterator iter000 = definingClass.classSlots();

        while (iter000.nextP()) {
          slot = ((Slot)(iter000.value));
          if (Stella_Object.storageSlotP(slot) &&
              Stella_Object.equalP(StringWrapper.wrapString(javaClassName), Symbol.javaTranslateName(slot.slotName))) {
            return (true);
          }
        }
      }
    }
    return (false);
  }

  public static void javaOutputClassToFile(Stella_Class renamed_Class) {
    { Object old$CurrentJavaOutputClass$000 = Stella.$CURRENT_JAVA_OUTPUT_CLASS$.get();

      try {
        Native.setSpecial(Stella.$CURRENT_JAVA_OUTPUT_CLASS$, renamed_Class);
        { Object old$Context$000 = Stella.$CONTEXT$.get();
          Object old$Module$000 = Stella.$MODULE$.get();

          try {
            Native.setSpecial(Stella.$CONTEXT$, renamed_Class.homeModule());
            Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
            { String classoutputfile = renamed_Class.javaMakeCodeOutputFileName(false);
              Cons translation = Stella.NIL;

              { OutputFileStream classoutputstream = null;

                try {
                  classoutputstream = Stella.openOutputFile(classoutputfile, Stella.NIL);
                  { Object old$CurrentStream$000 = Stella.$CURRENT_STREAM$.get();

                    try {
                      Native.setSpecial(Stella.$CURRENT_STREAM$, classoutputstream);
                      Stella.STANDARD_OUTPUT.nativeStream.println("Translating `" + renamed_Class + "'...");
                      translation = Stella_Class.javaTranslateDefineNativeClass(renamed_Class);
                      if (((Integer)(Stella.$TRANSLATIONVERBOSITYLEVEL$.get())).intValue() >= 1) {
                        Stella.STANDARD_OUTPUT.nativeStream.println("    Writing `" + classoutputfile + "'...");
                      }
                      OutputStream.javaOutputFileHeader(classoutputstream, renamed_Class.javaMakeCodeOutputFileName(true));
                      Cons.javaOutputClass(translation.rest, Stella_Class.exceptionClassP(renamed_Class));

                    } finally {
                      Stella.$CURRENT_STREAM$.set(old$CurrentStream$000);
                    }
                  }

                } finally {
                  if (classoutputstream != null) {
                    classoutputstream.free();
                  }
                }
              }
            }

          } finally {
            Stella.$MODULE$.set(old$Module$000);
            Stella.$CONTEXT$.set(old$Context$000);
          }
        }

      } finally {
        Stella.$CURRENT_JAVA_OUTPUT_CLASS$.set(old$CurrentJavaOutputClass$000);
      }
    }
  }

  public String javaMakeCodeOutputFileName(boolean donttruncateP) {
    { Stella_Class source = this;

      { StringWrapper barefile = StringWrapper.javaTranslateClassNamestring(StringWrapper.wrapString(Stella_Class.className(source)));

        return (Stella.string_javaMakeCodeOutputFileName(barefile.wrapperValue, donttruncateP));
      }
    }
  }

  public static boolean cppClassHasOnlyNativeParentsP(Stella_Class renamed_Class) {
    { Stella_Class renamed_Super = null;
      Cons iter000 = renamed_Class.classAllSuperClasses;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        renamed_Super = ((Stella_Class)(iter000.value));
        if (!(renamed_Super.mixinP)) {
          if (Stella_Class.createNativeClassP(renamed_Super) &&
              (((StringWrapper)(KeyValueList.dynamicSlotValue(renamed_Super.dynamicSlots, Stella.SYM_STELLA_CLASS_CPP_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue == null)) {
            return (false);
          }
        }
      }
    }
    return (true);
  }

  public static void markRenamingSlots(Stella_Class renamed_Class) {
    { Slot slot = null;
      Iterator iter000 = renamed_Class.classSlots();

      while (iter000.nextP()) {
        slot = ((Slot)(iter000.value));
        slot.slotMarkedP = false;
      }
    }
    { Slot slot = null;
      Iterator iter001 = renamed_Class.classSlots();

      while (iter001.nextP()) {
        slot = ((Slot)(iter001.value));
        if (!slot.slotMarkedP) {
          if ((slot.slotDirectEquivalent != null) &&
              (!slot.slotDirectEquivalent.slotRenamedP)) {
            Slot.markDirectEquivalentSlot(slot);
            slot.slotMarkedP = false;
          }
        }
      }
    }
  }

  public static Cons cppGetMethodDefinitions(Stella_Class renamed_Class, Object [] MV_returnarray) {
    { Cons publicmemberfuncdefs = Stella.NIL;
      Cons protectedmemberfuncdefs = Stella.NIL;

      { Slot slot = null;
        Cons iter000 = renamed_Class.classLocalSlots.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          slot = ((Slot)(iter000.value));
          if (Surrogate.subtypeOfMethodSlotP(Stella_Object.safePrimaryType(slot))) {
            { MethodSlot slot000 = ((MethodSlot)(slot));

              if ((!slot000.slotMarkedP) &&
                  (MethodSlot.nativeMethodP(slot000) &&
                   ((!MethodSlot.cppConstructorP(slot000)) &&
                    (!MethodSlot.cppNativeMethodP(slot000))))) {
                if (slot000.slotPublicP) {
                  publicmemberfuncdefs = Cons.cons(MethodSlot.cppYieldMemberFuncSignatureTree(slot000), publicmemberfuncdefs);
                }
                else {
                  protectedmemberfuncdefs = Cons.cons(MethodSlot.cppYieldMemberFuncSignatureTree(slot000), protectedmemberfuncdefs);
                }
              }
            }
          }
          else {
          }
        }
      }
      { MethodSlot method = null;
        Cons iter001 = renamed_Class.classAuxiliaryMethods().theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          method = ((MethodSlot)(iter001.value));
          if (method.slotPublicP) {
            publicmemberfuncdefs = Cons.cons(MethodSlot.cppYieldMemberFuncSignatureTree(method), publicmemberfuncdefs);
          }
          else {
            protectedmemberfuncdefs = Cons.cons(MethodSlot.cppYieldMemberFuncSignatureTree(method), protectedmemberfuncdefs);
          }
        }
      }
      { Cons _return_temp = publicmemberfuncdefs.reverse();

        MV_returnarray[0] = protectedmemberfuncdefs.reverse();
        return (_return_temp);
      }
    }
  }

  public static Cons cppGetConstructorDefinitions(Stella_Class renamed_Class) {
    { Cons constructordefs = Stella.NIL;

      { Slot slot = null;
        Iterator iter000 = renamed_Class.classSlots();
        Cons collect000 = null;

        while (iter000.nextP()) {
          slot = ((Slot)(iter000.value));
          if ((!slot.slotMarkedP) &&
              ((slot.primaryType() == Stella.SGT_STELLA_METHOD_SLOT) &&
               (Slot.localSlotP(slot, renamed_Class) &&
                MethodSlot.cppConstructorP(((MethodSlot)(slot)))))) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(MethodSlot.cppYieldConstructorSignatureTree(((MethodSlot)(slot))), Stella.NIL);
                if (constructordefs == Stella.NIL) {
                  constructordefs = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(constructordefs, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(MethodSlot.cppYieldConstructorSignatureTree(((MethodSlot)(slot))), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      return (constructordefs);
    }
  }

  public static Cons cppGetStaticVariableDefinitions(Stella_Class renamed_Class) {
    { Cons staticmembervardefs = Stella.NIL;

      { Slot slot = null;
        Iterator iter000 = renamed_Class.classSlots();

        while (iter000.nextP()) {
          slot = ((Slot)(iter000.value));
          if (Stella_Object.storageSlotP(slot) &&
              (StorageSlot.nativeSlotP(((StorageSlot)(slot))) &&
               ((((StorageSlot)(slot)).allocation() == Stella.KWD_CLASS) &&
                ((!((StorageSlot)(slot)).slotHardwiredP) &&
                 ((!slot.slotMarkedP) &&
                  (Slot.nativeSlotHome(slot, renamed_Class) == renamed_Class)))))) {
            staticmembervardefs = Cons.cons(StorageSlot.cppYieldStaticMemberAllocationTree(((StorageSlot)(slot)), renamed_Class), staticmembervardefs);
          }
        }
      }
      return (staticmembervardefs);
    }
  }

  public static Cons cppGetMemberVariableDefinitions(Stella_Class renamed_Class, Object [] MV_returnarray) {
    { Cons publicmembervardefs = Stella.NIL;
      Cons protectedmembervardefs = Stella.NIL;

      { Slot slot = null;
        Iterator iter000 = renamed_Class.classSlots();

        while (iter000.nextP()) {
          slot = ((Slot)(iter000.value));
          if (Stella_Object.storageSlotP(slot) &&
              (StorageSlot.nativeSlotP(((StorageSlot)(slot))) &&
               (Slot.nativeSlotHome(slot, renamed_Class) == renamed_Class))) {
            if (slot.slotPublicP) {
              publicmembervardefs = Cons.cons(StorageSlot.cppYieldMemberVarTree(((StorageSlot)(slot)), renamed_Class), publicmembervardefs);
            }
            else {
              protectedmembervardefs = Cons.cons(StorageSlot.cppYieldMemberVarTree(((StorageSlot)(slot)), renamed_Class), protectedmembervardefs);
            }
          }
        }
      }
      { Cons _return_temp = publicmembervardefs.reverse();

        MV_returnarray[0] = protectedmembervardefs.reverse();
        return (_return_temp);
      }
    }
  }

  public static Cons cppGetParameterizedMemberVariableDefinitions(Stella_Class renamed_Class) {
    { Cons membervardefs = Stella.NIL;

      { Slot slot = null;
        Cons iter000 = renamed_Class.classLocalSlots.theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          slot = ((Slot)(iter000.value));
          if (Stella_Object.storageSlotP(slot) &&
              (StorageSlot.nativeSlotP(((StorageSlot)(slot))) &&
               StorageSlot.slotHasClassParameterTypeP(((StorageSlot)(slot)), renamed_Class))) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(StorageSlot.cppYieldParameterizedMemberVarTree(((StorageSlot)(slot)), renamed_Class), Stella.NIL);
                if (membervardefs == Stella.NIL) {
                  membervardefs = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(membervardefs, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(StorageSlot.cppYieldParameterizedMemberVarTree(((StorageSlot)(slot)), renamed_Class), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      return (membervardefs);
    }
  }

  public static Cons cppYieldExceptionConstructorDefinition(Stella_Class renamed_Class) {
    { Surrogate value000 = null;

      { Surrogate renamed_Super = null;
        Cons iter000 = Stella_Class.classNativeSupers(renamed_Class).theConsList;

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          renamed_Super = ((Surrogate)(iter000.value));
          if (!((Stella_Class)(renamed_Super.surrogateValue)).mixinP) {
            value000 = renamed_Super;
            break loop000;
          }
        }
      }
      { Surrogate renamed_Super = value000;

        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCTION, Cons.cons(Stella.NIL, Cons.cons(GeneralizedSymbol.cppTranslateClassName(renamed_Class.classType), Cons.cons(Cons.list$(Cons.cons(Cons.cons(Cons.list$(Cons.cons(StringWrapper.wrapString("const std::string&"), Cons.cons(StringWrapper.wrapString("msg"), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Stella.NIL, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(GeneralizedSymbol.cppTranslateClassName(renamed_Super), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ACTUALS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(StringWrapper.wrapString("msg"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL))))));
      }
    }
  }

  public void describeObject(OutputStream stream, Keyword mode) {
    { Stella_Class self = this;

      if (mode == Stella.KWD_SOURCE) {
        Cons.prettyPrintDefinitionTree(((Cons)(Stella.readSExpressionFromString(self.classStringifiedSource))), stream);
      }
      else if (mode == Stella.KWD_TERSE) {
        Stella_Object.describeTersely(self, stream);
      }
      else if (mode == Stella.KWD_VERBOSE) {
        stream.nativeStream.println("SOURCE mode:");
        self.describeObject(stream, Stella.KWD_SOURCE);
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + mode + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public void prettyPrintObject(OutputStream stream) {
    { Stella_Class self = this;

      { Object old$Slotoptionslots$000 = Stella.$SLOTOPTIONSLOTS$.get();
        Object old$Classoptionslots$000 = Stella.$CLASSOPTIONSLOTS$.get();
        Object old$Classunstringifiedoptions$000 = Stella.$CLASSUNSTRINGIFIEDOPTIONS$.get();

        try {
          Native.setSpecial(Stella.$SLOTOPTIONSLOTS$, Stella.getSlotOptions());
          Native.setSpecial(Stella.$CLASSOPTIONSLOTS$, Stella.getClassOptions());
          Native.setSpecial(Stella.$CLASSUNSTRINGIFIEDOPTIONS$, Stella_Class.getUnstringifiedClassOptions(self));
          stream.nativeStream.print("(defclass " + self.classType.symbolName + " ");
          Iterator.printClassList(TypesToClassesIterator.newTypesToClassesIterator(self.classDirectSupers.theConsList), stream);
          Stella_Class.prettyPrintClassOptions(self, stream);
          Stella_Class.prettyPrintSlots(self, stream);
          stream.nativeStream.println(")");
          if (Stella_Class.classTables(self, Stella.NIL).nextP()) {
            stream.nativeStream.println();
            { Table table = null;
              Iterator iter000 = Stella_Class.classTables(self, Stella.NIL);

              while (iter000.nextP()) {
                table = ((Table)(iter000.value));
                table.prettyPrintObject(stream);
                stream.nativeStream.println();
              }
            }
            stream.nativeStream.println();
          }

        } finally {
          Stella.$CLASSUNSTRINGIFIEDOPTIONS$.set(old$Classunstringifiedoptions$000);
          Stella.$CLASSOPTIONSLOTS$.set(old$Classoptionslots$000);
          Stella.$SLOTOPTIONSLOTS$.set(old$Slotoptionslots$000);
        }
      }
    }
  }

  public static void prettyPrintSlots(Stella_Class self, OutputStream stream) {
    OutputStream.prettyPrintSlotBlock(stream, Stella_Class.publicClassStorageSlots(self), ":public-slots");
    OutputStream.prettyPrintSlotBlock(stream, Stella_Class.privateClassStorageSlots(self), ":slots");
    OutputStream.prettyPrintSlotBlock(stream, Stella_Class.publicClassMethods(self), ":public-methods");
    OutputStream.prettyPrintSlotBlock(stream, Stella_Class.privateClassMethods(self), ":methods");
  }

  public static void prettyPrintClassOptions(Stella_Class renamed_Class, OutputStream stream) {
    { Stella_Object optionvalue = null;

      { StorageSlot optionslot = null;
        Cons iter000 = ((Cons)(Stella.$CLASSOPTIONSLOTS$.get()));

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          optionslot = ((StorageSlot)(iter000.value));
          optionvalue = StandardObject.readSlotValue(renamed_Class, optionslot);
          if (optionvalue == null) {
            continue loop000;
          }
          { Surrogate testValue000 = Stella_Object.safePrimaryType(optionvalue);

            if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_LITERAL_WRAPPER)) {
              { LiteralWrapper optionvalue000 = ((LiteralWrapper)(optionvalue));

                if (!(Stella_Object.literalEqlP(Stella_Object.convertToLiteral(KeyValueList.dynamicSlotValue(optionslot.dynamicSlots, Stella.SYM_STELLA_SLOT_INITIAL_VALUE, null)), optionvalue000) ||
                    Stella_Object.literalEqlP(Stella_Object.convertToLiteral(optionslot.defaultForm()), optionvalue000))) {
                  {
                    stream.nativeStream.println();
                    stream.nativeStream.print("  :" + Native.stringDowncase(((Keyword)(KeyValueList.dynamicSlotValue(optionslot.dynamicSlots, Stella.SYM_STELLA_SLOT_OPTION_KEYWORD, null))).symbolName) + " ");
                  }
;
                  Stella_Object.prettyPrintLiteral(optionvalue000, stream);
                }
              }
            }
            else if (Surrogate.subtypeOfSymbolP(testValue000)) {
              { Symbol optionvalue000 = ((Symbol)(optionvalue));

                if (!(Stella_Object.literalEqlP(Stella_Object.convertToLiteral(KeyValueList.dynamicSlotValue(optionslot.dynamicSlots, Stella.SYM_STELLA_SLOT_INITIAL_VALUE, null)), optionvalue000) ||
                    Stella_Object.literalEqlP(Stella_Object.convertToLiteral(optionslot.defaultForm()), optionvalue000))) {
                  {
                    stream.nativeStream.println();
                    stream.nativeStream.print("  :" + Native.stringDowncase(((Keyword)(KeyValueList.dynamicSlotValue(optionslot.dynamicSlots, Stella.SYM_STELLA_SLOT_OPTION_KEYWORD, null))).symbolName) + " ");
                  }
;
                  Stella_Object.prettyPrintLiteral(optionvalue000, stream);
                }
              }
            }
            else if (Surrogate.subtypeOfKeywordP(testValue000)) {
              { Keyword optionvalue000 = ((Keyword)(optionvalue));

                if (!(Stella_Object.literalEqlP(Stella_Object.convertToLiteral(KeyValueList.dynamicSlotValue(optionslot.dynamicSlots, Stella.SYM_STELLA_SLOT_INITIAL_VALUE, null)), optionvalue000) ||
                    Stella_Object.literalEqlP(Stella_Object.convertToLiteral(optionslot.defaultForm()), optionvalue000))) {
                  {
                    stream.nativeStream.println();
                    stream.nativeStream.print("  :" + Native.stringDowncase(((Keyword)(KeyValueList.dynamicSlotValue(optionslot.dynamicSlots, Stella.SYM_STELLA_SLOT_OPTION_KEYWORD, null))).symbolName) + " ");
                  }
;
                  Stella_Object.prettyPrintLiteral(optionvalue000, stream);
                }
              }
            }
            else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
              { Surrogate optionvalue000 = ((Surrogate)(optionvalue));

                if (!(Stella_Object.literalEqlP(Stella_Object.convertToLiteral(KeyValueList.dynamicSlotValue(optionslot.dynamicSlots, Stella.SYM_STELLA_SLOT_INITIAL_VALUE, null)), optionvalue000) ||
                    Stella_Object.literalEqlP(Stella_Object.convertToLiteral(optionslot.defaultForm()), optionvalue000))) {
                  {
                    stream.nativeStream.println();
                    stream.nativeStream.print("  :" + Native.stringDowncase(((Keyword)(KeyValueList.dynamicSlotValue(optionslot.dynamicSlots, Stella.SYM_STELLA_SLOT_OPTION_KEYWORD, null))).symbolName) + " ");
                  }
;
                  Stella_Object.prettyPrintLiteral(optionvalue000, stream);
                }
              }
            }
            else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_LIST)) {
              { List optionvalue000 = ((List)(optionvalue));

                if (!(optionvalue000.emptyP() ||
                    ((KeyValueList.dynamicSlotValue(optionslot.dynamicSlots, Stella.SYM_STELLA_SLOT_INITIAL_VALUE, null) == optionvalue000) ||
                     (optionslot.defaultForm() == optionvalue000)))) {
                  { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();
                    Object old$PrintprettyP$000 = Stella.$PRINTPRETTYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      Native.setBooleanSpecial(Stella.$PRINTPRETTYp$, true);
                      {
                        stream.nativeStream.println();
                        stream.nativeStream.print("  :" + Native.stringDowncase(((Keyword)(KeyValueList.dynamicSlotValue(optionslot.dynamicSlots, Stella.SYM_STELLA_SLOT_OPTION_KEYWORD, null))).symbolName) + " ");
                      }
;
                      stream.nativeStream.print(((PropertyList)(Stella.$CLASSUNSTRINGIFIEDOPTIONS$.get())).lookup(((Keyword)(KeyValueList.dynamicSlotValue(optionslot.dynamicSlots, Stella.SYM_STELLA_SLOT_OPTION_KEYWORD, null)))));

                    } finally {
                      Stella.$PRINTPRETTYp$.set(old$PrintprettyP$000);
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                    }
                  }
                }
              }
            }
            else if (testValue000 == Stella.SGT_STELLA_CONS) {
              { Cons optionvalue000 = ((Cons)(optionvalue));

                if (!((optionvalue000 == Stella.NIL) ||
                    ((KeyValueList.dynamicSlotValue(optionslot.dynamicSlots, Stella.SYM_STELLA_SLOT_INITIAL_VALUE, null) == optionvalue000) ||
                     (optionslot.defaultForm() == optionvalue000)))) {
                  { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();
                    Object old$PrintprettyP$001 = Stella.$PRINTPRETTYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      Native.setBooleanSpecial(Stella.$PRINTPRETTYp$, true);
                      {
                        stream.nativeStream.println();
                        stream.nativeStream.print("  :" + Native.stringDowncase(((Keyword)(KeyValueList.dynamicSlotValue(optionslot.dynamicSlots, Stella.SYM_STELLA_SLOT_OPTION_KEYWORD, null))).symbolName) + " ");
                      }
;
                      stream.nativeStream.print(optionvalue000);

                    } finally {
                      Stella.$PRINTPRETTYp$.set(old$PrintprettyP$001);
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                    }
                  }
                }
              }
            }
            else {
            }
          }
        }
      }
    }
  }

  public static PropertyList getUnstringifiedClassOptions(Stella_Class renamed_Class) {
    { PropertyList theoptions = PropertyList.newPropertyList();

      theoptions.thePlist = ((Cons)(Stella.readSExpressionFromString(renamed_Class.classStringifiedSource))).rest.rest.rest;
      return (theoptions);
    }
  }

  public static boolean filterStringToClassP(Stella_Class self, AllPurposeIterator iterator) {
    if (iterator.iteratorInteger == 1) {
      return (Stella.stringEqlP(Stella_Class.className(self), ((StringWrapper)(iterator.iteratorObject)).wrapperValue));
    }
    else {
      return (Native.stringSearch(Stella_Class.className(self), ((StringWrapper)(iterator.iteratorObject)).wrapperValue, 0) != Stella.NULL_INTEGER);
    }
  }

  public static boolean clAlwaysTranslateToClosClassP(Stella_Class renamed_Class) {
    { boolean testValue000 = false;

      testValue000 = !Surrogate.subtypeOfP(renamed_Class.classType, Stella.SGT_STELLA_OBJECT);
      if (testValue000) {
        testValue000 = Stella_Class.createNativeClassP(renamed_Class);
        if (testValue000) {
          { boolean foundP000 = false;

            { Stella_Class renamed_Super = null;
              Cons iter000 = renamed_Class.classAllSuperClasses;

              loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                renamed_Super = ((Stella_Class)(iter000.value));
                if (!Stella_Class.createNativeClassP(renamed_Super)) {
                  foundP000 = true;
                  break loop000;
                }
              }
            }
            testValue000 = foundP000;
          }
        }
      }
      { boolean value000 = testValue000;

        return (value000);
      }
    }
  }

  public static Cons yieldConditionTree(Stella_Class renamed_Class) {
    { Cons defn = Stella_Class.yieldClosClassTree(renamed_Class);

      defn.firstSetter(Stella.internCommonLispSymbol("DEFINE-CONDITION"));
      if (defn.rest.rest.rest.rest != null) {
        defn.rest.rest.rest.rest = Stella.NIL;
      }
      return (defn);
    }
  }

  public static Cons yieldVectorStructTree(Stella_Class renamed_Class) {
    { Surrogate value000 = null;

      { Surrogate renamed_Super = null;
        Cons iter000 = Stella_Class.classNativeSupers(renamed_Class).theConsList;

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          renamed_Super = ((Surrogate)(iter000.value));
          if (!((Stella_Class)(renamed_Super.surrogateValue)).mixinP) {
            value000 = renamed_Super;
            break loop000;
          }
        }
      }
      { Surrogate renamed_Super = value000;
        String documentation = ((StringWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue;

        return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("DEFCLASS"), Cons.cons(Symbol.clTranslateGlobalSymbol(Stella_Class.classSymbol(renamed_Class)), Cons.cons(Cons.cons(((renamed_Super != null) ? Cons.cons(Symbol.clTranslateGlobalSymbol(Symbol.internSymbolInModule(renamed_Super.symbolName, ((Module)(renamed_Super.homeContext)), true)), Stella.NIL) : Stella.NIL), Cons.cons(Stella.NIL, (((documentation != null) ? Cons.cons(Cons.list$(Cons.cons(Stella.KWD_DOCUMENTATION, Cons.cons(StringWrapper.wrapString(documentation), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL))), Stella.NIL)))));
      }
    }
  }

  public static Stella_Object yieldVectorStructName(Stella_Class renamed_Class) {
    return (Module.yieldGlobalLispSymbol(((Module)(renamed_Class.classType.homeContext)), "%" + Stella_Class.className(renamed_Class)));
  }

  public static Cons yieldStructTree(Stella_Class renamed_Class) {
    { Surrogate value000 = null;

      { Surrogate renamed_Super = null;
        Cons iter000 = Stella_Class.classNativeSupers(renamed_Class).theConsList;

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          renamed_Super = ((Surrogate)(iter000.value));
          if (!((Stella_Class)(renamed_Super.surrogateValue)).mixinP) {
            value000 = renamed_Super;
            break loop000;
          }
        }
      }
      { Surrogate renamed_Super = value000;
        Stella_Object translatedsuper = null;
        String documentation = ((StringWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue;

        if (renamed_Super != null) {
          translatedsuper = Symbol.clTranslateGlobalSymbol(Symbol.internSymbolInModule(renamed_Super.symbolName, ((Module)(renamed_Super.homeContext)), true));
        }
        else {
          translatedsuper = Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_CLSYS_ROOT_STRUCT);
        }
        return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("DEFSTRUCT"), Cons.cons(Cons.cons(Symbol.clTranslateGlobalSymbol(Stella_Class.classSymbol(renamed_Class)), Cons.cons(Cons.list$(Cons.cons(Stella.KWD_CONC_NAME, Cons.cons(Surrogate.yieldStructSlotAccessorName(renamed_Class.classType, Stella.SYM_STELLA_), Cons.cons(Stella.NIL, Stella.NIL)))), (((translatedsuper != null) ? Cons.cons(Cons.list$(Cons.cons(Stella.KWD_INCLUDE, Cons.cons(translatedsuper, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL) : Stella.NIL)).concatenate(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.KWD_CONSTRUCTOR, Cons.cons(Stella_Class.yieldStructConstructorName(renamed_Class), Cons.cons(Cons.cons(Stella.NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.KWD_COPIER, Cons.cons(Stella.NIL, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.KWD_PREDICATE, Cons.cons(Stella.NIL, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL))), Cons.cons((((documentation != null) ? Cons.cons(StringWrapper.wrapString(documentation), Stella.NIL) : Stella.NIL)).concatenate(Stella_Class.yieldStructSlotTrees(renamed_Class).concatenate(Stella.NIL, Stella.NIL), Stella.NIL), Stella.NIL)))));
      }
    }
  }

  public static Cons yieldStructSlotTrees(Stella_Class renamed_Class) {
    { Cons structslotdefs = Stella.NIL;

      { StorageSlot slot = null;
        Cons iter000 = Stella_Class.clStructSlots(renamed_Class).theConsList;
        Cons collect000 = null;

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          slot = ((StorageSlot)(iter000.value));
          if (!(Slot.nativeSlotHome(slot, renamed_Class) == renamed_Class)) {
            if ((slot.slotBaseType != null) &&
                (!(((Stella_Class)(slot.slotBaseType.surrogateValue)) != null))) {
              {
                Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't generate a native slot named `" + slot.slotName + "' for the class `" + Stella_Class.className(renamed_Class) + "'");
                Stella.STANDARD_WARNING.nativeStream.println(" because the slot's :type `" + slot.slotBaseType + "' is undefined.");
              }
;
            }
            continue loop000;
          }
          if (collect000 == null) {
            {
              collect000 = Cons.cons(StorageSlot.yieldStructSlotTree(slot), Stella.NIL);
              if (structslotdefs == Stella.NIL) {
                structslotdefs = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(structslotdefs, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(StorageSlot.yieldStructSlotTree(slot), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (structslotdefs);
    }
  }

  public static List clStructSlots(Stella_Class renamed_Class) {
    { List slots = renamed_Class.classClStructSlots();

      if (List.definedListP(slots)) {
        return (slots);
      }
      else {
        return (((List)(KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_CL_STRUCT_SLOTS, Stella_Class.computeClStructSlots(renamed_Class), null))));
      }
    }
  }

  public static List computeClStructSlots(Stella_Class renamed_Class) {
    { Surrogate value000 = null;

      { Surrogate renamed_Super = null;
        Cons iter000 = Stella_Class.classNativeSupers(renamed_Class).theConsList;

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          renamed_Super = ((Surrogate)(iter000.value));
          if (!((Stella_Class)(renamed_Super.surrogateValue)).mixinP) {
            value000 = renamed_Super;
            break loop000;
          }
        }
      }
      { Surrogate realsuper = value000;
        List result = ((realsuper != null) ? Stella_Class.computeClStructSlots(((Stella_Class)(realsuper.surrogateValue))) : ((List)(null)));

        if (!(result != null)) {
          result = List.newList();
        }
        { Surrogate renamed_Super = null;
          Cons iter001 = Stella_Class.classNativeSupers(renamed_Class).theConsList;

          for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
            renamed_Super = ((Surrogate)(iter001.value));
            if (!(renamed_Super == realsuper)) {
              { Slot slot = null;
                Iterator iter002 = ((Stella_Class)(renamed_Super.surrogateValue)).classSlots();
                Cons collect000 = null;

                while (iter002.nextP()) {
                  slot = ((Slot)(iter002.value));
                  if (Stella_Object.storageSlotP(slot) &&
                      StorageSlot.nativeSlotP(((StorageSlot)(slot)))) {
                    if (collect000 == null) {
                      {
                        collect000 = Cons.cons(slot, Stella.NIL);
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
                        collect000.rest = Cons.cons(slot, Stella.NIL);
                        collect000 = collect000.rest;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        { Slot slot = null;
          Cons iter003 = renamed_Class.classLocalSlots.theConsList;
          Cons collect001 = null;

          for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
            slot = ((Slot)(iter003.value));
            if (Stella_Object.storageSlotP(slot) &&
                StorageSlot.nativeSlotP(((StorageSlot)(slot)))) {
              if (collect001 == null) {
                {
                  collect001 = Cons.cons(slot, Stella.NIL);
                  if (result.theConsList == Stella.NIL) {
                    result.theConsList = collect001;
                  }
                  else {
                    Cons.addConsToEndOfConsList(result.theConsList, collect001);
                  }
                }
              }
              else {
                {
                  collect001.rest = Cons.cons(slot, Stella.NIL);
                  collect001 = collect001.rest;
                }
              }
            }
          }
        }
        return (result);
      }
    }
  }

  public static Cons yieldClosClassTree(Stella_Class renamed_Class) {
    { Cons directsupers = Stella.NIL;
      Cons closslotdefs = Stella.NIL;
      String documentation = ((StringWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue;

      { Surrogate renamed_Super = null;
        Cons iter000 = Stella_Class.classNativeSupers(renamed_Class).theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          renamed_Super = ((Surrogate)(iter000.value));
          if ((!((Stella_Class)(renamed_Super.surrogateValue)).mixinP) ||
              (!Stella.translateToSingleInheritanceLanguageP())) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(Stella_Class.clTranslateClassName(Surrogate.typeToClass(renamed_Super)), Stella.NIL);
                if (directsupers == Stella.NIL) {
                  directsupers = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(directsupers, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(Stella_Class.clTranslateClassName(Surrogate.typeToClass(renamed_Super)), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      if (directsupers == Stella.NIL) {
        directsupers = Cons.cons(Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_CLSYS_ROOT_OBJECT), directsupers);
      }
      { Slot slot = null;
        Iterator iter001 = renamed_Class.classSlots();
        Cons collect001 = null;

        loop001 : while (iter001.nextP()) {
          slot = ((Slot)(iter001.value));
          if (Stella_Object.storageSlotP(slot) &&
              StorageSlot.nativeSlotP(((StorageSlot)(slot)))) {
            if (!(Slot.nativeSlotHome(slot, renamed_Class) == renamed_Class)) {
              if ((slot.slotBaseType != null) &&
                  (!(((Stella_Class)(slot.slotBaseType.surrogateValue)) != null))) {
                {
                  Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't generate a native slot named `" + slot.slotName + "' for the class `" + Stella_Class.className(renamed_Class) + "'");
                  Stella.STANDARD_WARNING.nativeStream.println(" because the slot's :type `" + slot.slotBaseType + "' is undefined.");
                }
;
              }
              continue loop001;
            }
            if (collect001 == null) {
              {
                collect001 = Cons.cons(StorageSlot.yieldClosSlotTree(((StorageSlot)(slot))), Stella.NIL);
                if (closslotdefs == Stella.NIL) {
                  closslotdefs = collect001;
                }
                else {
                  Cons.addConsToEndOfConsList(closslotdefs, collect001);
                }
              }
            }
            else {
              {
                collect001.rest = Cons.cons(StorageSlot.yieldClosSlotTree(((StorageSlot)(slot))), Stella.NIL);
                collect001 = collect001.rest;
              }
            }
          }
        }
      }
      return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("DEFCLASS"), Cons.cons(Symbol.clTranslateGlobalSymbol(Stella_Class.classSymbol(renamed_Class)), Cons.cons(Cons.cons(directsupers, Cons.cons(closslotdefs, (((documentation != null) ? Cons.cons(Cons.list$(Cons.cons(Stella.KWD_DOCUMENTATION, Cons.cons(StringWrapper.wrapString(documentation), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL))), Stella.NIL)))));
    }
  }

  public static Stella_Object yieldStructConstructorName(Stella_Class renamed_Class) {
    return (Module.yieldGlobalLispSymbol(((Module)(renamed_Class.classType.homeContext)), "%MAKE-" + renamed_Class.classType.symbolName));
  }

  public static Stella_Object clTranslateClassName(Stella_Class renamed_Class) {
    if (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_CONSES)) {
      if (renamed_Class.classType == Stella.SGT_STELLA_CONS) {
        return (Stella.internCommonLispSymbol("CONS"));
      }
      else {
      }
    }
    if (((StringWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_CL_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue != null) {
      { String nativetype = ((StringWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_CL_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue;

        if (!(Native.string_position(nativetype, ':', 0) != Stella.NULL_INTEGER)) {
          nativetype = "CL:" + nativetype;
        }
        return (VerbatimStringWrapper.newVerbatimStringWrapper(nativetype));
      }
    }
    else {
      return (Symbol.clTranslateGlobalSymbol(Stella_Class.classSymbol(renamed_Class)));
    }
  }

  public static void createDefprintUnit(Stella_Class renamed_Class) {
    if (!(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_PRINT_FORM, null) == null)) {
      Cons.walkAuxiliaryTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFMETHOD, Cons.cons(Stella.SYM_STELLA_PRINT_OBJECT, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(renamed_Class.classType, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_STREAM, Cons.cons(Stella.SYM_STELLA_NATIVE_OUTPUT_STREAM, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.KWD_PUBLICp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Stella_Object.copyConsTree(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_PRINT_FORM, null)), Cons.cons(Stella.NIL, Stella.NIL)))))))));
      { boolean testValue000 = false;

        testValue000 = ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP;
        if (testValue000) {
          { boolean foundP000 = false;

            { Stella_Class renamed_Super = null;
              Cons iter000 = renamed_Class.classAllSuperClasses;

              loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                renamed_Super = ((Stella_Class)(iter000.value));
                if (KeyValueList.dynamicSlotValue(renamed_Super.dynamicSlots, Stella.SYM_STELLA_PRINT_FORM, null) != null) {
                  foundP000 = true;
                  break loop000;
                }
              }
            }
            testValue000 = foundP000;
          }
          testValue000 = !testValue000;
        }
        if (testValue000) {
          Symbol.pushVariableBinding(Stella.SYM_STELLA_SELF, renamed_Class.classType);
          Symbol.pushVariableBinding(Stella.SYM_STELLA_STREAM, Stella.SGT_STELLA_NATIVE_OUTPUT_STREAM);
          { TranslationUnit self000 = TranslationUnit.newTranslationUnit();

            self000.theObject = renamed_Class;
            self000.category = Stella.SYM_STELLA_PRINT_METHOD;
            self000.tuHomeModule = ((Module)(Stella.$MODULE$.get()));
            self000.codeRegister = Stella_Object.walkATree(Cons.list$(Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NULLp, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_NATIVE_STREAM, Cons.cons(Stella.SYM_STELLA_STREAM, Cons.cons(StringWrapper.wrapString("!NULL!"), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_OBJECT, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.SYM_STELLA_STREAM, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))), new Object[1]);
            self000.auxiliaryP = true;
            ((List)(Stella.$TRANSLATIONUNITS$.get())).push(self000);
          }
          Stella.popVariableBinding();
          Stella.popVariableBinding();
        }
      }
      { boolean testValue001 = false;

        testValue001 = ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA;
        if (testValue001) {
          { boolean foundP001 = false;

            { Stella_Class renamed_Super = null;
              Cons iter001 = renamed_Class.classAllSuperClasses;

              loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                renamed_Super = ((Stella_Class)(iter001.value));
                if (KeyValueList.dynamicSlotValue(renamed_Super.dynamicSlots, Stella.SYM_STELLA_PRINT_FORM, null) != null) {
                  foundP001 = true;
                  break loop001;
                }
              }
            }
            testValue001 = foundP001;
          }
          testValue001 = !testValue001;
        }
        if (testValue001) {
          { Object old$Methodbeingwalked$000 = Stella.$METHODBEINGWALKED$.get();

            try {
              Native.setSpecial(Stella.$METHODBEINGWALKED$, MethodSlot.newMethodSlot());
              ((MethodSlot)(Stella.$METHODBEINGWALKED$.get())).methodReturnTypeSpecifiers = List.list(Cons.cons(Stella.SGT_STELLA_STRING, Stella.NIL));
              Symbol.pushVariableBinding(Stella.SYM_STELLA_SELF, renamed_Class.classType);
              { TranslationUnit self002 = TranslationUnit.newTranslationUnit();

                self002.theObject = renamed_Class;
                self002.category = Stella.SYM_STELLA_PRINT_METHOD;
                self002.tuHomeModule = ((Module)(Stella.$MODULE$.get()));
                self002.codeRegister = Stella_Object.walkATree(Cons.list$(Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NULLp, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(StringWrapper.wrapString("!NULL!"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VERBATIM, Cons.cons(Stella.KWD_JAVA, Cons.cons(StringWrapper.wrapString("#$(STELLAROOT).javalib.Native.stringify_via_print(self)"), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), new Object[1]);
                self002.auxiliaryP = true;
                ((List)(Stella.$TRANSLATIONUNITS$.get())).push(self002);
              }
              Stella.popVariableBinding();

            } finally {
              Stella.$METHODBEINGWALKED$.set(old$Methodbeingwalked$000);
            }
          }
        }
      }
    }
  }

  public static void createMixinMethodUnits(Stella_Class renamed_Class) {
    if (renamed_Class.mixinP &&
        ((!Stella.translateToSingleInheritanceLanguageP()) ||
         (!(Stella.$MIXIN_IMPLEMENTATION_STYLE$ == Stella.KWD_SECOND_CLASS)))) {
      { Slot slot = null;
        Cons iter000 = renamed_Class.classLocalSlots.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          slot = ((Slot)(iter000.value));
          if (Stella_Object.methodSlotP(slot)) {
            MethodSlot.registerAuxiliaryMethod(((MethodSlot)(Cons.helpWalkAuxiliaryTree(MethodSlot.yieldMixinMethodTree(((MethodSlot)(slot)), ((Stella_Class)(Stella.SGT_STELLA_OBJECT.surrogateValue))), true).theObject)), slot);
          }
        }
      }
    }
    else {
      { List mixinmethods = List.newList();
        List supermethods = List.newList();

        { Surrogate renamed_Super = null;
          Cons iter001 = renamed_Class.classDirectSupers.theConsList;

          for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
            renamed_Super = ((Surrogate)(iter001.value));
            if (((Stella_Class)(renamed_Super.surrogateValue)).mixinP) {
              { Slot slot = null;
                Iterator iter002 = ((Stella_Class)(renamed_Super.surrogateValue)).classSlots();

                while (iter002.nextP()) {
                  slot = ((Slot)(iter002.value));
                  if (Stella_Object.methodSlotP(slot) &&
                      (Slot.nativeSlotHome(slot, renamed_Class) == renamed_Class)) {
                    if (slot.slotDirectEquivalent != null) {
                      supermethods.insertNew(((MethodSlot)(slot.slotDirectEquivalent)));
                    }
                    if (!(supermethods.memberP(slot))) {
                      mixinmethods.insertNew(((MethodSlot)(slot)));
                    }
                  }
                }
              }
            }
          }
        }
        { MethodSlot method = null;
          Cons iter003 = mixinmethods.reverse().theConsList;

          for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
            method = ((MethodSlot)(iter003.value));
            MethodSlot.registerAuxiliaryMethod(((MethodSlot)(Cons.helpWalkAuxiliaryTree(MethodSlot.yieldMixinMethodTree(method, renamed_Class), true).theObject)), method);
          }
        }
      }
    }
  }

  public static void createInlineMethodUnits(Stella_Class renamed_Class) {
    { Slot slot = null;
      Cons iter000 = renamed_Class.localSlots().theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        slot = ((Slot)(iter000.value));
        if (Slot.inlineMethodP(slot)) {
          { Stella_Object name = null;
            Cons parameters = null;
            Cons body = null;

            { Object [] caller_MV_returnarray = new Object[2];

              name = Cons.destructureDefmethodTree(((Cons)(Stella.unstringifyStellaSource(((MethodSlot)(slot)).methodStringifiedSource, slot.homeModule()))), null, caller_MV_returnarray);
              parameters = ((Cons)(caller_MV_returnarray[0]));
              body = ((Cons)(caller_MV_returnarray[1]));
            }
            {
              name = name;
              parameters = parameters;
            }
            { TranslationUnit self000 = TranslationUnit.newTranslationUnit();

              self000.theObject = slot;
              self000.category = Stella.SYM_STELLA_METHOD;
              self000.codeRegister = body;
              self000.auxiliaryP = true;
              self000.tuHomeModule = ((Module)(Stella.$MODULE$.get()));
              TranslationUnit.walkMethodUnit(self000);
            }
          }
        }
      }
    }
  }

  public static void createSlotAccessorUnits(Stella_Class renamed_Class) {
    { Slot slot = null;
      Cons iter000 = renamed_Class.localSlots().theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        slot = ((Slot)(iter000.value));
        if (Surrogate.subtypeOfStorageSlotP(Stella_Object.safePrimaryType(slot))) {
          { StorageSlot slot000 = ((StorageSlot)(slot));

            if ((Stella.translateToSingleInheritanceLanguageP() &&
                ((!Stella.translateToSingleInheritanceLanguageP()) ||
                 (!(Stella.$MIXIN_IMPLEMENTATION_STYLE$ == Stella.KWD_SECOND_CLASS)))) &&
                renamed_Class.mixinP) {
              StorageSlot.createAccessorUnitsForMixinSlot(slot000, renamed_Class);
            }
            else {
              StorageSlot.createAccessorUnitsForSlot(slot000, renamed_Class, false, slot000.slotExternalP);
            }
          }
        }
        else {
        }
      }
    }
    { boolean testValue000 = false;

      testValue000 = Stella.translateToSingleInheritanceLanguageP();
      if (testValue000) {
        { boolean foundP000 = false;

          { Surrogate renamed_Super = null;
            Cons iter001 = renamed_Class.classDirectSupers.theConsList;

            loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              renamed_Super = ((Surrogate)(iter001.value));
              if (((Stella_Class)(renamed_Super.surrogateValue)).mixinP) {
                foundP000 = true;
                break loop001;
              }
            }
          }
          testValue000 = foundP000;
        }
      }
      if (testValue000) {
        { Slot slot = null;
          Iterator iter002 = renamed_Class.classSlots();

          while (iter002.nextP()) {
            slot = ((Slot)(iter002.value));
            if (Slot.mixinSlotP(slot) &&
                (Slot.nativeSlotHome(slot, renamed_Class) == renamed_Class)) {
              StorageSlot.createAccessorUnitsForSlot(((StorageSlot)(slot)), renamed_Class, Stella.translateToSingleInheritanceLanguageP() &&
                  ((!Stella.translateToSingleInheritanceLanguageP()) ||
                   (!(Stella.$MIXIN_IMPLEMENTATION_STYLE$ == Stella.KWD_SECOND_CLASS))), slot.slotExternalP);
            }
          }
        }
      }
    }
    Stella_Class.createGenericSlotAccessorUnit(renamed_Class);
  }

  public static void cleanupAuxiliaryMethods(Stella_Class renamed_Class) {
    { List auxiliarymethods = renamed_Class.classAuxiliaryMethods();
      Slot reason = null;

      { MethodSlot method = null;
        Cons iter000 = auxiliarymethods.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          method = ((MethodSlot)(iter000.value));
          if (!method.deletedP()) {
            if (BooleanWrapper.coerceWrappedBooleanToBoolean(method.badP())) {
              method.deletedPSetter(true);
            }
            else {
              reason = ((Slot)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_AUXILIARY_METHOD_REASON, null)));
              if ((reason == null) ||
                  (reason.deletedP() ||
                   (BooleanWrapper.coerceWrappedBooleanToBoolean(reason.badP()) ||
                    ((reason.slotOwner == null) ||
                     ((reason.slotOwner.symbolId == -1) ||
                      ((((Stella_Class)(reason.slotOwner.surrogateValue)) == null) ||
                       (((Stella_Class)(reason.slotOwner.surrogateValue)).deletedP() ||
                        (BooleanWrapper.coerceWrappedBooleanToBoolean(((Stella_Class)(reason.slotOwner.surrogateValue)).badP()) ||
                         (!(Stella_Class.lookupSlot(((Stella_Class)(reason.slotOwner.surrogateValue)), reason.slotName) == reason)))))))))) {
                KeyValueList.setDynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_AUXILIARY_METHOD_REASON, null, null);
                method.deletedPSetter(true);
              }
            }
          }
        }
      }
      auxiliarymethods.removeDeletedMembers();
    }
  }

  public List classAuxiliaryMethods() {
    { Stella_Class self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_AUXILIARY_METHODS, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public static Cons yieldConstructorAttachment(Stella_Class renamed_Class, Symbol classref) {
    if ((!renamed_Class.abstractP) &&
        Stella_Class.createNativeClassP(renamed_Class)) {
      { Cons constructorfncode = Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_CODE, Cons.cons(Stella.KWD_FUNCTION, Cons.cons(Stella_Class.yieldConstructorName(renamed_Class), Cons.cons(Stella.NIL, Stella.NIL)))));

        return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CLASS_CONSTRUCTOR_CODE, Cons.cons(classref, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(constructorfncode, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL));
      }
    }
    else {
      return (Stella.NIL);
    }
  }

  public static Cons yieldInitializeHardwiredSlots(Stella_Class renamed_Class) {
    { Cons hardwiredslotinitializers = Stella.NIL;

      if (Stella_Class.createNativeClassP(renamed_Class)) {
        { Slot slot = null;
          Iterator iter000 = renamed_Class.classSlots();

          while (iter000.nextP()) {
            slot = ((Slot)(iter000.value));
            if (Surrogate.subtypeOfStorageSlotP(Stella_Object.safePrimaryType(slot))) {
              { StorageSlot slot000 = ((StorageSlot)(slot));

                if (slot000.slotHardwiredP &&
                    (slot000.initialValue() != null)) {
                  hardwiredslotinitializers = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(StorageSlot.yieldHardwiredSlotVariable(slot000), Cons.cons(Cons.cons(slot000.initialValue(), Stella.NIL), Stella.NIL)))), hardwiredslotinitializers);
                }
              }
            }
            else {
            }
          }
        }
      }
      return (hardwiredslotinitializers);
    }
  }

  public static boolean helpMostSpecificMethodP(Stella_Class renamed_Class, MethodSlot method) {
    if (renamed_Class == null) {
      return (true);
    }
    { boolean testValue000 = false;

      { boolean foundP000 = false;

        { Slot slot = null;
          Cons iter000 = renamed_Class.classLocalSlots.theConsList;

          loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            slot = ((Slot)(iter000.value));
            if (slot.slotDirectEquivalent == method) {
              foundP000 = true;
              break loop000;
            }
          }
        }
        testValue000 = foundP000;
      }
      testValue000 = !testValue000;
      if (testValue000) {
        { boolean alwaysP000 = true;

          { Surrogate sub = null;
            Cons iter001 = renamed_Class.classDirectSubs.theConsList;

            loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              sub = ((Surrogate)(iter001.value));
              if (!Stella_Class.helpMostSpecificMethodP(((Stella_Class)(sub.surrogateValue)), method)) {
                alwaysP000 = false;
                break loop001;
              }
            }
          }
          testValue000 = alwaysP000;
        }
      }
      { boolean value000 = testValue000;

        return (value000);
      }
    }
  }

  public static void createKeyedEqualityMethodUnit(Stella_Class renamed_Class) {
    { Cons testtrees = Stella.NIL;

      { Slot slotname = null;
        Cons iter000 = renamed_Class.classKey().theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          slotname = ((Slot)(iter000.value));
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_EQp, Cons.cons(Cons.cons(slotname, Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL)), Cons.cons(Cons.cons(slotname, Cons.cons(Stella.SYM_STELLA_OTHER, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL);
              if (testtrees == Stella.NIL) {
                testtrees = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(testtrees, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_EQp, Cons.cons(Cons.cons(slotname, Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL)), Cons.cons(Cons.cons(slotname, Cons.cons(Stella.SYM_STELLA_OTHER, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      Cons.walkAuxiliaryTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFMETHOD, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_EQUAL, Cons.cons(Stella.SYM_STELLA_BOOLEAN, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella_Class.classSymbol(renamed_Class), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_OTHER, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Cons.cons(Stella.SYM_STELLA_AND, testtrees.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))));
    }
  }

  public static Cons yieldMixinClassUsersTree(Stella_Class renamed_Class) {
    { Cons result = Stella.NIL;

      { Surrogate sub = null;
        Cons iter000 = renamed_Class.classDirectSubs.theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          sub = ((Surrogate)(iter000.value));
          if (!Surrogate.typeToClass(sub).mixinP) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(Symbol.internSymbolInModule(sub.symbolName, ((Module)(sub.homeContext)), true), Stella.NIL);
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
                collect000.rest = Cons.cons(Symbol.internSymbolInModule(sub.symbolName, ((Module)(sub.homeContext)), true), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      return (result);
    }
  }

  public static Cons yieldGenericSlotAccessorAttachment(Stella_Class renamed_Class, Symbol classref) {
    { boolean foundP000 = false;

      { Slot slot = null;
        Cons iter000 = renamed_Class.classLocalSlots.theConsList;

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          slot = ((Slot)(iter000.value));
          if (Stella_Object.storageSlotP(slot) &&
              StorageSlot.genericSlotReaderP(((StorageSlot)(slot)))) {
            foundP000 = true;
            break loop000;
          }
        }
      }
      if (foundP000) {
        return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CLASS_SLOT_ACCESSOR_CODE, Cons.cons(classref, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_CODE, Cons.cons(Stella.KWD_FUNCTION, Cons.cons(Stella_Class.yieldGenericSlotAccessorName(renamed_Class), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL));
      }
      else {
        return (Stella.NIL);
      }
    }
  }

  public static void createGenericSlotAccessorUnit(Stella_Class renamed_Class) {
    { Cons tree = Stella_Class.yieldGenericSlotAccessorDefinition(renamed_Class);

      if (tree != null) {
        Cons.walkAuxiliaryTree(tree);
      }
    }
  }

  public static Cons yieldGenericSlotAccessorDefinition(Stella_Class renamed_Class) {
    { Cons clauses = Stella.NIL;
      Cons accesstree = Stella.NIL;
      Stella_Object valuetree = null;
      Surrogate slottype = null;

      if (!Stella_Class.subclassOfP(renamed_Class, ((Stella_Class)(Stella.SGT_STELLA_OBJECT.surrogateValue)))) {
        return (null);
      }
      { Slot slot = null;
        Cons iter000 = renamed_Class.classLocalSlots.theConsList;

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          slot = ((Slot)(iter000.value));
          if (Stella_Object.storageSlotP(slot) &&
              StorageSlot.genericSlotReaderP(((StorageSlot)(slot)))) {
            if (slot.slotExternalP ||
                (StorageSlot.spaceSaverSlotAllocationP(((StorageSlot)(slot))) &&
                 (!StorageSlot.slotAccessMethodP(((StorageSlot)(slot)))))) {
              continue loop000;
            }
            accesstree = Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Cons.cons(slot.slotName, Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))));
            if (!((StorageSlot)(slot)).slotHardwiredP) {
              slottype = Surrogate.canonicalType(slot.type());
              valuetree = Stella.SYM_STELLA_VALUE;
              if (Surrogate.subtypeOfP(slottype, Stella.SGT_STELLA_LITERAL) &&
                  (Surrogate.lookupLiteralTypeInfo(slottype, Stella.KWD_WRAP_FUNCTION) != null)) {
                valuetree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CAST, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(slottype.typeToWrappedType(), Cons.cons(Stella.NIL, Stella.NIL)))));
              }
              accesstree = Cons.list$(Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(Stella.SYM_STELLA_SETVALUEp, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.cons(slot.slotName, Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL)), Cons.cons(valuetree, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(accesstree, Cons.cons(Stella.NIL, Stella.NIL))))));
            }
            clauses = Cons.cons(Cons.cons(slot.slotName, Cons.cons(accesstree, Stella.NIL)), clauses);
          }
        }
      }
      if (Stella_Class.subclassOfP(renamed_Class, ((Stella_Class)(Stella.SGT_STELLA_DYNAMIC_SLOTS_MIXIN.surrogateValue)))) {
        { Cons renameclauses = Stella.NIL;

          { Slot slot = null;
            Cons iter001 = renamed_Class.classLocalSlots.theConsList;
            Cons collect000 = null;

            for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              slot = ((Slot)(iter001.value));
              if (Stella_Object.storageSlotP(slot) &&
                  ((!slot.slotExternalP) &&
                   (StorageSlot.spaceSaverSlotAllocationP(((StorageSlot)(slot))) &&
                    ((!StorageSlot.slotAccessMethodP(((StorageSlot)(slot)))) &&
                     (!(slot == StorageSlot.canonicalSlot(((StorageSlot)(slot))))))))) {
                if (collect000 == null) {
                  {
                    collect000 = Cons.cons(Cons.cons(slot.slotName, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_SLOTNAME, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_QUOTE, Cons.cons(StorageSlot.canonicalSlot(((StorageSlot)(slot))).slotName, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL)), Stella.NIL);
                    if (renameclauses == Stella.NIL) {
                      renameclauses = collect000;
                    }
                    else {
                      Cons.addConsToEndOfConsList(renameclauses, collect000);
                    }
                  }
                }
                else {
                  {
                    collect000.rest = Cons.cons(Cons.cons(slot.slotName, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_SLOTNAME, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_QUOTE, Cons.cons(StorageSlot.canonicalSlot(((StorageSlot)(slot))).slotName, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL)), Stella.NIL);
                    collect000 = collect000.rest;
                  }
                }
              }
            }
          }
          if (!(renameclauses == Stella.NIL)) {
            renameclauses = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CASE, Cons.cons(Stella.SYM_STELLA_SLOTNAME, Cons.cons(renameclauses.concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OTHERWISE, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL), Stella.NIL)))), Stella.NIL);
          }
          clauses = Cons.cons(Cons.cons(Stella.SYM_STELLA_OTHERWISE, renameclauses.concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(Stella.SYM_STELLA_SETVALUEp, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SET_DYNAMIC_SLOT_VALUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DYNAMIC_SLOTS, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_SLOTNAME, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL))))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LOOKUP, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DYNAMIC_SLOTS, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_SLOTNAME, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Stella.NIL), Stella.NIL)), clauses);
        }
      }
      if (clauses == Stella.NIL) {
        return (null);
      }
      else {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFUN, Cons.cons(Cons.cons(Stella_Class.yieldGenericSlotAccessorName(renamed_Class), Cons.cons(Stella.SYM_STELLA_OBJECT, Stella.NIL)), Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(renamed_Class.classType, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOTNAME, Cons.cons(Stella.SYM_STELLA_SYMBOL, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.SYM_STELLA_OBJECT, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETVALUEp, Cons.cons(Stella.SYM_STELLA_BOOLEAN, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CASE, Cons.cons(Stella.SYM_STELLA_SLOTNAME, Cons.cons(clauses.reverse().concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))))));
      }
    }
  }

  public static Symbol yieldGenericSlotAccessorName(Stella_Class renamed_Class) {
    { String baseName = renamed_Class.classType.symbolName;
      String prefix = (Stella.allUpperCaseStringP(baseName) ? "ACCESS-" : "access-");
      String suffix = (Stella.allUpperCaseStringP(baseName) ? "-SLOT-VALUE" : "-Slot-Value");

      return (Symbol.internDerivedSymbol(renamed_Class.classType, prefix + baseName + suffix));
    }
  }

  public static void createCppConstructorUnit(Stella_Class renamed_Class) {
    if (!(Stella_Class.parameterizedClassP(renamed_Class))) {
      { Stella_Object classname = StandardObject.yieldTypeSpecTree(renamed_Class.classType);
        boolean hasinitializerP = Stella_Class.classWithInitializerP(renamed_Class);

        if (hasinitializerP) {
          Cons.walkAuxiliaryTree(Stella_Class.yieldInitializerDefinition(renamed_Class));
        }
        Cons.helpWalkAuxiliaryTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFMETHOD, Cons.cons(classname, Cons.cons(Cons.list$(Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(classname, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Stella.KWD_PUBLICp, Cons.cons((renamed_Class.publicP() ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Cons.cons(((hasinitializerP ? Cons.cons(Cons.cons(Stella_Class.yieldInitializerName(renamed_Class), Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL)), Stella.NIL) : Cons.cons(Stella.SYM_STELLA_NULL, Stella.NIL))).concatenate(Stella.NIL, Stella.NIL), Stella.NIL))))), Stella.NIL)))), false);
      }
    }
  }

  public static Cons yieldInitializerDefinition(Stella_Class renamed_Class) {
    { Cons parentinitforms = Stella.NIL;

      { Surrogate renamed_Super = null;
        Cons iter000 = renamed_Class.classDirectSupers.theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          renamed_Super = ((Surrogate)(iter000.value));
          if (Stella_Class.classWithInitializerP(((Stella_Class)(renamed_Super.surrogateValue)))) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(Cons.cons(Stella_Class.yieldInitializerName(((Stella_Class)(renamed_Super.surrogateValue))), Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL)), Stella.NIL);
                if (parentinitforms == Stella.NIL) {
                  parentinitforms = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(parentinitforms, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(Cons.cons(Stella_Class.yieldInitializerName(((Stella_Class)(renamed_Super.surrogateValue))), Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL)), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFUN, Cons.cons(Stella_Class.yieldInitializerName(renamed_Class), Cons.cons(Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(StandardObject.yieldTypeSpecTree(renamed_Class.classType), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), parentinitforms.concatenate(Stella_Class.yieldLocalInitialValueAssignments(renamed_Class).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)), Stella.NIL)))));
    }
  }

  public static Symbol yieldInitializerName(Stella_Class renamed_Class) {
    { String baseName = Stella_Class.className(renamed_Class);
      String prefix = (Stella.allUpperCaseStringP(baseName) ? "INITIALIZE-" : "initialize-");

      return (Symbol.internDerivedSymbol(renamed_Class.classType, prefix + baseName));
    }
  }

  public static boolean classWithInitializerP(Stella_Class renamed_Class) {
    { boolean foundP000 = false;

      { Slot slot = null;
        Iterator iter000 = renamed_Class.classSlots();

        loop000 : while (iter000.nextP()) {
          slot = ((Slot)(iter000.value));
          if (Stella_Object.storageSlotP(slot)) {
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

  public static boolean parameterizedClassP(Stella_Class renamed_Class) {
    return (renamed_Class.parameters().nonEmptyP());
  }

  public static void createConstructorAndDestructorUnits(Stella_Class renamed_Class) {
    if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE) {
      Stella_Class.createCppConstructorUnit(renamed_Class);
      return;
    }
    if (!(renamed_Class.abstractP ||
        Surrogate.subtypeOfP(renamed_Class.classType, Stella.SGT_STELLA_LITERAL))) {
      { Stella_Object definition = null;
        Cons iter000 = Stella_Class.yieldRecycleListDefinitions(renamed_Class);

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          definition = iter000.value;
          Cons.walkAuxiliaryTree(((Cons)(definition)));
        }
      }
      Cons.walkAuxiliaryTree(Stella_Class.yieldConstructorDefinition(renamed_Class));
      { Stella_Object destructor = null;
        Cons iter001 = Stella_Class.yieldDestructorDefinitions(renamed_Class);

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          destructor = iter001.value;
          Cons.walkAuxiliaryTree(((Cons)(destructor)));
        }
      }
    }
  }

  public static Cons yieldDestructorDefinitions(Stella_Class renamed_Class) {
    { Symbol classname = Stella_Class.classSymbol(renamed_Class);
      Symbol destructor = ((Symbol)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_DESTRUCTOR, null)));
      Symbol terminator = renamed_Class.terminator();
      Cons definitions = Stella.NIL;

      if (Stella_Class.decidedToRecycleP(renamed_Class)) {
        { StorageSlot recycleslot = Stella_Class.recycleSlot(renamed_Class);
          Symbol recyclelist = Stella_Class.yieldRecycleListName(renamed_Class);

          if (Stella_Class.useFreeListP(renamed_Class)) {
            definitions = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFMETHOD, Cons.cons(Stella.SYM_STELLA_FREE, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(classname, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_AND, Cons.cons(Stella.SYM_STELLA_$RECYCLING_ENABLEDp$, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons((((Stella_Class.useSweepListP(renamed_Class) &&
                (!Surrogate.subtypeOfP(renamed_Class.classType, Stella.SGT_STELLA_STANDARD_OBJECT))) ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ALL_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL), Stella.NIL))))), Cons.cons(Stella_Class.yieldTerminateObjectTrees(renamed_Class).concatenate(Stella.yieldRegisterRecycledItemTrees().concatenate((((recycleslot != null) ? Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(recycleslot.slotName, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RECYCLED_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RECYCLED_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))) : Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PUSH, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LIST_OF_RECYCLED_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL))).concatenate((((!Stella_Class.useSweepListP(renamed_Class)) ? Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ii, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CURRENT_LENGTH, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_e, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA___, Cons.cons(Stella.SYM_STELLA_$RECYCLE_LISTS_MAINTENANCE_TIMER$, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.cons(Stella.SYM_STELLA_MAINTAIN_RECYCLE_LISTS, Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL), Stella.NIL), Stella.NIL), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), definitions);
          }
          if (Stella_Class.useSweepListP(renamed_Class)) {
            if (!Stella_Class.useFreeListP(renamed_Class)) {
              definitions = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFMETHOD, Cons.cons(Stella.SYM_STELLA_FREE, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(classname, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL)))))), definitions);
            }
            definitions = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFMETHOD, Cons.cons(Stella.SYM_STELLA_SWEEP, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(classname, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_AND, Cons.cons(Stella.SYM_STELLA_$RECYCLING_ENABLEDp$, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(((Stella_Class.useFreeListP(renamed_Class) ? (((Stella_Class.recycleSlot(renamed_Class) != null) ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RECYCLED_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL) : Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CLEAR, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LIST_OF_RECYCLED_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL))) : Stella.NIL)).concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNUSED, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNUSED_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ALL_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHILE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NOT, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_EQLp, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.SYM_STELLA_UNUSED, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella_Class.yieldTerminateObjectTrees(renamed_Class).concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NEXT_SWEEP_LIST_OBJECT, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNUSED_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ALL_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))))), Stella.NIL), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), definitions);
          }
        }
      }
      else if ((terminator != null) ||
          (destructor != null)) {
        if (!(destructor != null)) {
          destructor = Stella.SYM_STELLA_UNMAKE;
        }
        if (!(destructor == Stella.SYM_STELLA_FREE)) {
          definitions = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFMETHOD, Cons.cons(Stella.SYM_STELLA_FREE, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(classname, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(((terminator != null) ? Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.cons(terminator, Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL)), Cons.cons(Cons.cons(destructor, Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL))))) : Cons.cons(destructor, Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL))), Cons.cons(Stella.NIL, Stella.NIL)))))), definitions);
        }
      }
      return (definitions.reverse());
    }
  }

  public static Cons yieldExceptionConstructorDefinition(Stella_Class renamed_Class) {
    { Cons requiredparameters = Stella.NIL;
      Cons assignments = Stella.NIL;
      Slot slot = null;
      Symbol messageparameter = Stella.SYM_STELLA_MESSAGE;

      { Symbol slotname = null;
        Cons iter000 = renamed_Class.classRequiredSlotNames().theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          slotname = ((Symbol)(iter000.value));
          if (!(slotname == messageparameter)) {
            assignments = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.cons(slotname, Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL)), Cons.cons(slotname, Cons.cons(Stella.NIL, Stella.NIL))))), assignments);
          }
          slot = Stella_Class.lookupSlot(renamed_Class, slotname);
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Cons.cons(slotname, Cons.cons(Surrogate.typeToSymbol(slot.type()), Stella.NIL)), Stella.NIL);
              if (requiredparameters == Stella.NIL) {
                requiredparameters = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(requiredparameters, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Cons.cons(slotname, Cons.cons(Surrogate.typeToSymbol(slot.type()), Stella.NIL)), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFUN, Cons.cons(Cons.cons(Stella_Class.yieldConstructorName(renamed_Class), Cons.cons(Stella_Class.classSymbol(renamed_Class), Stella.NIL)), Cons.cons(requiredparameters.concatenate(Stella.NIL, Stella.NIL), Cons.cons(Stella.KWD_CONSTRUCTORp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Stella.KWD_PUBLICp, Cons.cons((renamed_Class.publicP() ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella_Class.classSymbol(renamed_Class), Cons.cons(Cons.cons(Stella.SYM_STELLA_NULL, Stella.NIL), Stella.NIL)))), Stella.NIL), Cons.cons(Stella_Class.yieldExceptionConstructorBody(renamed_Class, messageparameter, assignments.reverse()).concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL))))))))));
    }
  }

  public static Cons yieldExceptionConstructorBody(Stella_Class renamed_Class, Symbol messageparameter, Cons requiredassignments) {
    { Cons initialvalueassignments = Stella_Class.yieldInitialValueAssignments(renamed_Class, (Stella_Class.decidedToRecycleP(renamed_Class) ? Stella.KWD_INITIAL_VALUE_ONLY : Stella.KWD_ANY_INITIAL_VALUE));

      if ((initialvalueassignments == Stella.NIL) &&
          ((requiredassignments == Stella.NIL) &&
           ((!(renamed_Class.initializer() != null)) &&
            ((!renamed_Class.activeP()) &&
             (!Stella_Class.decidedToRecycleP(renamed_Class)))))) {
        return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_MAKE, Cons.cons(Stella_Class.classSymbol(renamed_Class), Cons.cons(Cons.cons(messageparameter, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL));
      }
      return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_MAKE, Cons.cons(Stella_Class.classSymbol(renamed_Class), Cons.cons(Cons.cons(messageparameter, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), requiredassignments.concatenate(initialvalueassignments.concatenate(Stella_Class.yieldInitializerTrees(renamed_Class).concatenate(((renamed_Class.activeP() ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RUN_CONSTRUCTOR_DEMONS, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL), Stella.NIL), Stella.NIL), Stella.NIL)));
    }
  }

  public static Cons yieldConstructorDefinition(Stella_Class renamed_Class) {
    if (Stella_Class.exceptionClassP(renamed_Class)) {
      return (Stella_Class.yieldExceptionConstructorDefinition(renamed_Class));
    }
    { Cons requiredparameters = Stella.NIL;
      Cons assignments = Stella.NIL;
      Slot slot = null;

      { Symbol slotname = null;
        Cons iter000 = renamed_Class.classRequiredSlotNames().theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          slotname = ((Symbol)(iter000.value));
          assignments = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.cons(slotname, Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL)), Cons.cons(slotname, Cons.cons(Stella.NIL, Stella.NIL))))), assignments);
          slot = Stella_Class.lookupSlot(renamed_Class, slotname);
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Cons.cons(slotname, Cons.cons(Surrogate.typeToSymbol(slot.type()), Stella.NIL)), Stella.NIL);
              if (requiredparameters == Stella.NIL) {
                requiredparameters = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(requiredparameters, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Cons.cons(slotname, Cons.cons(Surrogate.typeToSymbol(slot.type()), Stella.NIL)), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFUN, Cons.cons(Cons.cons(Stella_Class.yieldConstructorName(renamed_Class), Cons.cons(Stella_Class.classSymbol(renamed_Class), Stella.NIL)), Cons.cons(requiredparameters.concatenate(Stella.NIL, Stella.NIL), Cons.cons(Stella.KWD_CONSTRUCTORp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Stella.KWD_PUBLICp, Cons.cons((renamed_Class.publicP() ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella_Class.classSymbol(renamed_Class), Cons.cons(Cons.cons(Stella.SYM_STELLA_NULL, Stella.NIL), Stella.NIL)))), Stella.NIL), Cons.cons(Stella_Class.yieldConstructorBody(renamed_Class, assignments.reverse()).concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL))))))))));
    }
  }

  public static Cons yieldConstructorBody(Stella_Class renamed_Class, Cons requiredassignments) {
    { Cons initialvalueassignments = Stella_Class.yieldInitialValueAssignments(renamed_Class, (Stella_Class.decidedToRecycleP(renamed_Class) ? Stella.KWD_INITIAL_VALUE_ONLY : Stella.KWD_ANY_INITIAL_VALUE));

      if ((initialvalueassignments == Stella.NIL) &&
          ((requiredassignments == Stella.NIL) &&
           ((!(renamed_Class.initializer() != null)) &&
            ((!renamed_Class.activeP()) &&
             (!Stella_Class.decidedToRecycleP(renamed_Class)))))) {
        return (Stella_Class.yieldCreationTrees(renamed_Class));
      }
      return (Stella_Class.yieldCreationTrees(renamed_Class).concatenate(requiredassignments.concatenate(initialvalueassignments.concatenate(Stella_Class.yieldInitializerTrees(renamed_Class).concatenate(((renamed_Class.activeP() ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RUN_CONSTRUCTOR_DEMONS, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL), Stella.NIL), Stella.NIL), Stella.NIL), Stella.NIL));
    }
  }

  public static Cons yieldInitializerTrees(Stella_Class renamed_Class) {
    { Cons initializers = Stella.NIL;
      Cons cursor = Stella.NIL;

      if (((Symbol)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_INITIALIZER, null))) != null) {
        initializers = Cons.cons(((Symbol)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_INITIALIZER, null))), initializers);
      }
      { Stella_Class renamed_Super = null;
        Cons iter000 = renamed_Class.classAllSuperClasses;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          renamed_Super = ((Stella_Class)(iter000.value));
          if ((((Symbol)(KeyValueList.dynamicSlotValue(renamed_Super.dynamicSlots, Stella.SYM_STELLA_CLASS_INITIALIZER, null))) != null) &&
              (!initializers.membP(((Symbol)(KeyValueList.dynamicSlotValue(renamed_Super.dynamicSlots, Stella.SYM_STELLA_CLASS_INITIALIZER, null)))))) {
            initializers = Cons.cons(((Symbol)(KeyValueList.dynamicSlotValue(renamed_Super.dynamicSlots, Stella.SYM_STELLA_CLASS_INITIALIZER, null))), initializers);
          }
        }
      }
      cursor = initializers;
      while (!(cursor == Stella.NIL)) {
        cursor.firstSetter(Cons.cons(cursor.value, Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL)));
        cursor = cursor.rest;
      }
      return (initializers);
    }
  }

  public static Cons yieldLocalInitialValueAssignments(Stella_Class renamed_Class) {
    { Cons assignments = Stella.NIL;
      Stella_Object initialvalueassignment = null;

      { Slot slot = null;
        Cons iter000 = renamed_Class.classLocalSlots.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          slot = ((Slot)(iter000.value));
          slot.slotMarkedP = false;
        }
      }
      { Slot slot = null;
        Cons iter001 = renamed_Class.classLocalSlots.theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          slot = ((Slot)(iter001.value));
          Slot.markDirectEquivalentSlot(slot);
        }
      }
      { Slot slot = null;
        Cons iter002 = renamed_Class.classLocalSlots.theConsList;

        for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
          slot = ((Slot)(iter002.value));
          if ((!slot.slotMarkedP) &&
              Stella_Object.storageSlotP(slot)) {
            initialvalueassignment = StorageSlot.yieldInitialValueAssignment(((StorageSlot)(slot)), Stella.KWD_ANY_INITIAL_VALUE);
            if (initialvalueassignment != null) {
              assignments = Cons.cons(initialvalueassignment, assignments);
            }
          }
        }
      }
      return (assignments.reverse());
    }
  }

  public static Cons yieldInitialValueAssignments(Stella_Class renamed_Class, Keyword mode) {
    { Cons assignments = Stella.NIL;
      Stella_Object initialvalueassignment = null;

      { Slot slot = null;
        Iterator iter000 = renamed_Class.classSlots();

        while (iter000.nextP()) {
          slot = ((Slot)(iter000.value));
          slot.slotMarkedP = false;
        }
      }
      { Slot slot = null;
        Iterator iter001 = renamed_Class.classSlots();

        while (iter001.nextP()) {
          slot = ((Slot)(iter001.value));
          Slot.markDirectEquivalentSlot(slot);
        }
      }
      { Slot slot = null;
        Iterator iter002 = renamed_Class.classSlots();

        while (iter002.nextP()) {
          slot = ((Slot)(iter002.value));
          if ((!slot.slotMarkedP) &&
              Stella_Object.storageSlotP(slot)) {
            initialvalueassignment = StorageSlot.yieldInitialValueAssignment(((StorageSlot)(slot)), mode);
            if (initialvalueassignment != null) {
              assignments = Cons.cons(initialvalueassignment, assignments);
            }
          }
        }
      }
      return (assignments);
    }
  }

  public static Cons yieldCreationOrReuseTreesFromFreeOrSweepList(Stella_Class renamed_Class) {
    { StorageSlot recycleslot = Stella_Class.recycleSlot(renamed_Class);
      Cons recycleslotresettree = ((recycleslot != null) ? StorageSlot.yieldInitialValueAssignment(recycleslot, Stella.KWD_NULL_VALUE_ONLY) : ((Cons)(null)));
      Symbol recyclelist = Stella_Class.yieldRecycleListName(renamed_Class);

      recyclelist = Stella_Class.yieldRecycleListName(renamed_Class);
      return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_COND, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_AND, Cons.cons(Stella.SYM_STELLA_$RECYCLING_ENABLEDp$, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(((recycleslot != null) ? Cons.list$(Cons.cons(Stella.SYM_STELLA_RECYCLED_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))) : Cons.list$(Cons.cons(Stella.SYM_STELLA_POP, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LIST_OF_RECYCLED_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_COND, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), (((recycleslot != null) ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RECYCLED_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(recycleslot.slotName, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL) : Stella.NIL)).concatenate((((recycleslotresettree != null) ? Cons.cons(recycleslotresettree, Stella.NIL) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OTHERWISE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNUSED_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_COND, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNUSED_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NEXT_SWEEP_LIST_OBJECT, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNUSED_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.cons(Stella.SYM_STELLA_OTHERWISE, Stella_Class.yieldMakeTrees(renamed_Class).concatenate(Stella_Class.yieldInitialValueAssignments(renamed_Class, Stella.KWD_NULL_VALUE_ONLY).concatenate(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NEXT_SWEEP_LIST_OBJECT, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ALL_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ALL_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ii, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CURRENT_LENGTH, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_e, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA___, Cons.cons(Stella.SYM_STELLA_$RECYCLE_LISTS_MAINTENANCE_TIMER$, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.cons(Stella.SYM_STELLA_MAINTAIN_RECYCLE_LISTS, Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Stella.NIL), Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.cons(Stella.SYM_STELLA_OTHERWISE, Stella_Class.yieldMakeTrees(renamed_Class).concatenate(Stella_Class.yieldInitialValueAssignments(renamed_Class, Stella.KWD_NULL_VALUE_ONLY).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL));
    }
  }

  public static Cons yieldCreationOrReuseTreesFromSweepList(Stella_Class renamed_Class) {
    { Symbol recyclelist = Stella_Class.yieldRecycleListName(renamed_Class);

      recyclelist = Stella_Class.yieldRecycleListName(renamed_Class);
      return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_COND, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_AND, Cons.cons(Stella.SYM_STELLA_$RECYCLING_ENABLEDp$, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNUSED_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_COND, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNUSED_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NEXT_SWEEP_LIST_OBJECT, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNUSED_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.cons(Stella.SYM_STELLA_OTHERWISE, Stella_Class.yieldMakeTrees(renamed_Class).concatenate(Stella_Class.yieldInitialValueAssignments(renamed_Class, Stella.KWD_NULL_VALUE_ONLY).concatenate(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NEXT_SWEEP_LIST_OBJECT, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ALL_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ALL_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ii, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CURRENT_LENGTH, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_e, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA___, Cons.cons(Stella.SYM_STELLA_$RECYCLE_LISTS_MAINTENANCE_TIMER$, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.cons(Stella.SYM_STELLA_MAINTAIN_RECYCLE_LISTS, Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Stella.NIL), Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.cons(Stella.SYM_STELLA_OTHERWISE, Stella_Class.yieldMakeTrees(renamed_Class).concatenate(Stella_Class.yieldInitialValueAssignments(renamed_Class, Stella.KWD_NULL_VALUE_ONLY).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL));
    }
  }

  public static Cons yieldCreationOrReuseTreesFromFreeList(Stella_Class renamed_Class) {
    { StorageSlot recycleslot = Stella_Class.recycleSlot(renamed_Class);
      Cons recycleslotresettree = ((recycleslot != null) ? StorageSlot.yieldInitialValueAssignment(recycleslot, Stella.KWD_NULL_VALUE_ONLY) : ((Cons)(null)));
      Symbol recyclelist = Stella_Class.yieldRecycleListName(renamed_Class);

      recyclelist = Stella_Class.yieldRecycleListName(renamed_Class);
      return (Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_AND, Cons.cons(Stella.SYM_STELLA_$RECYCLING_ENABLEDp$, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(((recycleslot != null) ? Cons.list$(Cons.cons(Stella.SYM_STELLA_RECYCLED_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))) : Cons.list$(Cons.cons(Stella.SYM_STELLA_POP, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LIST_OF_RECYCLED_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_COND, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), (((recycleslot != null) ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RECYCLED_ITEMS, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(recycleslot.slotName, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL) : Stella.NIL)).concatenate((((recycleslotresettree != null) ? Cons.cons(recycleslotresettree, Stella.NIL) : Stella.NIL)).concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA___, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CURRENT_LENGTH, Cons.cons(recyclelist, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.yieldUnregisterRecycledItemTrees().concatenate(Stella.NIL, Stella.NIL)), Stella.NIL), Stella.NIL)), Cons.cons(Cons.cons(Stella.SYM_STELLA_OTHERWISE, Stella_Class.yieldMakeTrees(renamed_Class).concatenate(Stella_Class.yieldInitialValueAssignments(renamed_Class, Stella.KWD_NULL_VALUE_ONLY).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))));
    }
  }

  public static Cons yieldCreationOrReuseTrees(Stella_Class renamed_Class) {
    { boolean usefreelistP = Stella_Class.useFreeListP(renamed_Class);
      boolean usesweeplistP = Stella_Class.useSweepListP(renamed_Class);

      if (usefreelistP &&
          usesweeplistP) {
        return (Stella_Class.yieldCreationOrReuseTreesFromFreeOrSweepList(renamed_Class));
      }
      else if (usefreelistP) {
        return (Stella_Class.yieldCreationOrReuseTreesFromFreeList(renamed_Class));
      }
      else if (usesweeplistP) {
        return (Stella_Class.yieldCreationOrReuseTreesFromSweepList(renamed_Class));
      }
      else {
        throw ((StellaException)(StellaException.newStellaException("Assuming CLASS uses at least one of Free-list or sweep-list").fillInStackTrace()));
      }
    }
  }

  public static Cons yieldTerminateObjectTrees(Stella_Class renamed_Class) {
    { Cons trees = Stella.NIL;
      Symbol terminator = renamed_Class.terminator();

      { Slot slot = null;
        Iterator iter000 = renamed_Class.classSlots();

        while (iter000.nextP()) {
          slot = ((Slot)(iter000.value));
          if (Surrogate.subtypeOfStorageSlotP(Stella_Object.safePrimaryType(slot))) {
            { StorageSlot slot000 = ((StorageSlot)(slot));

              if (slot000.componentP()) {
                trees = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(Cons.cons(slot000.slotName, Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_FREE, Cons.cons(Cons.cons(slot000.slotName, Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), trees);
              }
            }
          }
          else {
          }
        }
      }
      if (Stella_Class.lookupSlot(renamed_Class, Stella.SYM_STELLA_DYNAMIC_SLOTS) != null) {
        trees = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CLEAR, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DYNAMIC_SLOTS, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), trees);
      }
      if (terminator != null) {
        if (Stella_Class.useSweepListP(renamed_Class)) {
          trees = Cons.cons(Cons.cons(terminator, Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL)), trees);
        }
        else {
          trees = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNLESS, Cons.cons(Cons.cons(terminator, Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL)), Cons.cons(Cons.cons(Stella.SYM_STELLA_RETURN, Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL))))), trees);
        }
      }
      return (trees.reverse().concatenate(Stella_Class.yieldInitialValueAssignments(renamed_Class, Stella.KWD_FORCE_NULL_VALUE), Stella.NIL));
    }
  }

  public static Cons yieldCreationTrees(Stella_Class renamed_Class) {
    if (((Symbol)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_CREATOR, null))) != null) {
      if (((Symbol)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_CREATOR, null))) == Stella_Class.yieldConstructorName(renamed_Class)) {
        {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: Illegal creator name `" + ((Symbol)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_CREATOR, null))) + "' for the class ");
          Stella.STANDARD_WARNING.nativeStream.println("`" + Stella_Class.className(renamed_Class) + "'.  Using the default creator.");
        }
;
        return (Stella_Class.yieldMakeTrees(renamed_Class));
      }
      return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Cons.cons(((Symbol)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_CREATOR, null))), Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL));
    }
    else if (Stella_Class.decidedToRecycleP(renamed_Class)) {
      return (Stella_Class.yieldCreationOrReuseTrees(renamed_Class));
    }
    else {
      return (Stella_Class.yieldMakeTrees(renamed_Class));
    }
  }

  public static Symbol yieldConstructorName(Stella_Class renamed_Class) {
    { String baseName = Stella_Class.className(renamed_Class);
      String prefix = (Stella.allUpperCaseStringP(baseName) ? "NEW-" : "new-");

      return (Symbol.internDerivedSymbol(renamed_Class.classType, prefix + baseName));
    }
  }

  public static Cons yieldMakeTrees(Stella_Class renamed_Class) {
    return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_MAKE, Cons.cons(Stella_Class.classSymbol(renamed_Class), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL));
  }

  public static Cons yieldRecycleListDefinitions(Stella_Class renamed_Class) {
    if (Stella_Class.decidedToRecycleP(renamed_Class)) {
      return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFGLOBAL, Cons.cons(Stella_Class.yieldRecycleListName(renamed_Class), Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RECYCLE_LIST, Cons.cons(Stella.SYM_STELLA_OF, Cons.cons(Stella_Class.classSymbol(renamed_Class), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CREATE_RECYCLE_LIST, Cons.cons(renamed_Class.classType, Cons.cons(Cons.cons(IntegerWrapper.wrapInteger(Stella_Class.computeRecycledItemSize(renamed_Class)), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Stella.NIL));
    }
    else {
      return (Stella.NIL);
    }
  }

  public static int computeRecycledItemSize(Stella_Class renamed_Class) {
    { int size = Stella.NULL_INTEGER;

      if (renamed_Class != null) {
        if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
          if (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_STRUCTS) ||
              ((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_VECTOR_STRUCTS)) {
            size = 4;
          }
          else {
            size = 10;
          }
        }
        else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) {
          size = 1;
        }
        else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) {
          size = 2;
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
        { Slot slot = null;
          Iterator iter000 = renamed_Class.classSlots();

          while (iter000.nextP()) {
            slot = ((Slot)(iter000.value));
            if (Stella_Object.storageSlotP(slot) &&
                (StorageSlot.nativeSlotP(((StorageSlot)(slot))) &&
                 (!((slot.slotDirectEquivalent != null) &&
                StorageSlot.nativeSlotP(((StorageSlot)(slot.slotDirectEquivalent))))))) {
              size = size + 1;
            }
          }
        }
        if (Stella_Class.useFreeListP(renamed_Class) &&
            (Stella_Class.recycleSlot(renamed_Class) == null)) {
          size = size + 2;
        }
      }
      return (size);
    }
  }

  public static boolean decidedToRecycleP(Stella_Class renamed_Class) {
    return ((!(renamed_Class.abstractP ||
        (((Symbol)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_CREATOR, null))) != null))) &&
        (Stella_Class.useFreeListP(renamed_Class) ||
         Stella_Class.useSweepListP(renamed_Class)));
  }

  public static boolean useSweepListP(Stella_Class renamed_Class) {
    return ((renamed_Class.classRecycleMethod() == Stella.KWD_SWEEP_LIST) ||
        ((renamed_Class.classRecycleMethod() == Stella.KWD_FREE_AND_SWEEP_LIST) &&
         (!(Stella.$TRANSLATE_WITH_RECYCLE_LIST_DEBUGGINGp$ ||
        (Stella.$CURRENTLY_RECYCLED_ITEMS$ != null)))));
  }

  public static boolean useFreeListP(Stella_Class renamed_Class) {
    return ((renamed_Class.classRecycleMethod() == Stella.KWD_FREE_LIST) ||
        (renamed_Class.classRecycleMethod() == Stella.KWD_FREE_AND_SWEEP_LIST));
  }

  public static StorageSlot recycleSlot(Stella_Class renamed_Class) {
    { Surrogate instancetype = renamed_Class.classType;
      StorageSlot recycleslot = null;

      { Slot slot = null;
        Iterator iter000 = renamed_Class.classSlots();

        while (iter000.nextP()) {
          slot = ((Slot)(iter000.value));
          if (Surrogate.subtypeOfStorageSlotP(Stella_Object.safePrimaryType(slot))) {
            { StorageSlot slot000 = ((StorageSlot)(slot));

              if ((!(slot000.slotName == Stella.SYM_STELLA_NEXT_SWEEP_LIST_OBJECT)) &&
                  StorageSlot.nativeSlotP(slot000)) {
                if (instancetype == slot000.slotBaseType) {
                  return (slot000);
                }
                if ((((Stella_Class)(slot000.slotBaseType.surrogateValue)) != null) &&
                    Surrogate.subtypeOfP(instancetype, slot000.slotBaseType)) {
                  recycleslot = slot000;
                }
              }
            }
          }
          else {
          }
        }
      }
      return (recycleslot);
    }
  }

  public static Symbol yieldRecycleListName(Stella_Class renamed_Class) {
    return (Symbol.internDerivedSymbol(renamed_Class.classType, "*RECYCLE-LIST-FOR-" + Stella_Class.className(renamed_Class) + "-S*"));
  }

  public static void warnAboutNonDirectSupers(Stella_Class renamed_Class) {
    if (renamed_Class.multipleParentsP() &&
        Stella_Class.createNativeClassP(renamed_Class)) {
      { List directsupers = renamed_Class.classDirectSupers;

        { Surrogate renamed_Super = null;
          Cons iter000 = directsupers.theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            renamed_Super = ((Surrogate)(iter000.value));
            { boolean foundP000 = false;

              { Surrogate othersuper = null;
                Cons iter001 = directsupers.theConsList;

                loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                  othersuper = ((Surrogate)(iter001.value));
                  if ((!(renamed_Super == othersuper)) &&
                      Surrogate.subtypeOfP(othersuper, renamed_Super)) {
                    foundP000 = true;
                    break loop001;
                  }
                }
              }
              if (foundP000) {
                { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationError();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                      {
                        Stella.STANDARD_ERROR.nativeStream.println();
                        Stella.STANDARD_ERROR.nativeStream.println(" Bad list of supers defined for class `" + Stella_Class.className(renamed_Class) + "'.");
                        Stella.STANDARD_ERROR.nativeStream.println(" The class `" + renamed_Super.symbolName + "' is not a direct superclass.");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                  }
                }
                return;
              }
            }
          }
        }
      }
    }
  }

  public static void warnAboutMultipleParents(Stella_Class renamed_Class) {
    if (renamed_Class.multipleParentsP() &&
        Stella_Class.createNativeClassP(renamed_Class)) {
      if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE) ||
          (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_IDL)) {
      }
      else if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) ||
          ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ||
           (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA))) {
        { int nofsupers = 0;
          int nofmixinsupers = 0;

          { Surrogate renamed_Super = null;
            Cons iter000 = Stella_Class.classNativeSupers(renamed_Class).theConsList;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              renamed_Super = ((Surrogate)(iter000.value));
              nofsupers = nofsupers + 1;
              if (((Stella_Class)(renamed_Super.surrogateValue)).mixinP) {
                nofmixinsupers = nofmixinsupers + 1;
              }
            }
          }
          if ((nofsupers - nofmixinsupers) > 1) {
            { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" Class `" + Stella_Class.className(renamed_Class) + "' illegally inherits `" + (nofsupers - nofmixinsupers) + "' native non-mixin classes.");
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
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static boolean exceptionClassP(Stella_Class renamed_Class) {
    return (Surrogate.subtypeOfP(renamed_Class.classType, Stella.SGT_STELLA_NATIVE_EXCEPTION));
  }

  public static boolean createNativeClassP(Stella_Class renamed_Class) {
    { String classnativetype = null;

      if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
        classnativetype = ((StringWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_CL_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue;
      }
      else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_IDL) {
        classnativetype = ((StringWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_IDL_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue;
      }
      else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) {
        classnativetype = ((StringWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_JAVA_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue;
      }
      else if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ||
          (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE)) {
        classnativetype = ((StringWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_CPP_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue;
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      return (!(Surrogate.subtypeOfP(renamed_Class.classType, Stella.SGT_STELLA_SECOND_CLASS_OBJECT) ||
          (Surrogate.subtypeOfP(renamed_Class.classType, Stella.SGT_STELLA_NON_OBJECT) ||
           ((classnativetype != null) ||
            (!renamed_Class.primitiveP())))));
    }
  }

  /** Return a cons tree that (when evaluated) constructs
   * a Stella class object.
   * @param renamed_Class
   * @return Cons
   */
  public static Cons yieldDefineStellaClass(Stella_Class renamed_Class) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINE_CLASS_FROM_STRINGIFIED_SOURCE, Cons.cons(StringWrapper.wrapString(renamed_Class.name()), Cons.cons(Cons.cons(Stella.yieldStringConstantTree(renamed_Class.classStringifiedSource), Stella.NIL), Stella.NIL)))));
  }

  public static Cons yieldClassParameterTypes(Stella_Class renamed_Class) {
    { Cons types = Stella.NIL;

      { Symbol pname = null;
        Cons iter000 = renamed_Class.parameters().theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          pname = ((Symbol)(iter000.value));
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Stella_Class.lookupSlot(renamed_Class, pname).slotBaseType, Stella.NIL);
              if (types == Stella.NIL) {
                types = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(types, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Stella_Class.lookupSlot(renamed_Class, pname).slotBaseType, Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (types);
    }
  }

  public static boolean taxonomySubclassOfP(Stella_Class subclass, Stella_Class superclass) {
    return (Stella_Class.subclassOfP(subclass, superclass));
  }

  public static boolean fastSubclassOfP(Stella_Class subclass, Stella_Class superclass) {
    { int sublabel = subclass.classTaxonomyNode.label;

      { Interval interval = null;
        Cons iter000 = superclass.classTaxonomyNode.intervals;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          interval = ((Interval)(iter000.value));
          if ((sublabel >= interval.lowerBound) &&
              (sublabel <= interval.upperBound)) {
            return (true);
          }
        }
      }
      return (false);
    }
  }

  /** Return <code>true</code> if <code>subclass</code> is a subclass of <code>superclass</code>.
   * @param subclass
   * @param superclass
   * @return boolean
   */
  public static boolean subclassOfP(Stella_Class subclass, Stella_Class superclass) {
    if (subclass == superclass) {
      return (true);
    }
    { TaxonomyNode subnode = subclass.classTaxonomyNode;
      TaxonomyNode supernode = superclass.classTaxonomyNode;
      int sublabel = Stella.NULL_INTEGER;

      if ((subnode == null) ||
          ((supernode == null) ||
           ((sublabel = subnode.label) == Stella.NULL_INTEGER))) {
        return (subclass.classAllSuperClasses.membP(superclass));
      }
      { Interval interval = null;
        Cons iter000 = supernode.intervals;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          interval = ((Interval)(iter000.value));
          if ((sublabel >= interval.lowerBound) &&
              (sublabel <= interval.upperBound)) {
            return (true);
          }
        }
      }
      return (false);
    }
  }

  public static boolean rootClassP(Stella_Class renamed_Class) {
    return (renamed_Class.classDirectSupers.emptyP() &&
        (!renamed_Class.mixinP));
  }

  /** Returns an iterator that generates all super classes
   * of <code>self</code>.  Non-reflexive.
   * @return Iterator
   */
  public Iterator superClasses() {
    { Stella_Class self = this;

      { ListIterator iterator = ListIterator.newListIterator();

        iterator.listIteratorCursor = self.classAllSuperClasses;
        return (iterator);
      }
    }
  }

  /** Returns an iterator that generates all direct
   * super classes of <code>self</code>.
   * @return Iterator
   */
  public Iterator directSuperClasses() {
    { Stella_Class self = this;

      return (TypesToClassesIterator.newTypesToClassesIterator(self.classDirectSupers.theConsList));
    }
  }

  public List localSlots() {
    { Stella_Class self = this;

      return (self.classLocalSlots);
    }
  }

  public Iterator classSlots() {
    { Stella_Class self = this;

      return (self.allClassSlots());
    }
  }

  public Iterator allClassSlots() {
    { Stella_Class self = this;

      { AllClassSlotsIterator iterator = AllClassSlotsIterator.newAllClassSlotsIterator();

        iterator.iteratorConsList = self.classLocalSlots.theConsList;
        iterator.iteratorObject = self.classAllSuperClasses;
        iterator.firstIterationP = true;
        return (iterator);
      }
    }
  }

  /** Return an iterator over public slots of <code>self</code>.
   * @return Iterator
   */
  public Iterator publicSlots() {
    { Stella_Class self = this;

      { Cons publicslots = ((Cons)(Stella.NIL));
        AllPurposeIterator iterator = AllPurposeIterator.newAllPurposeIterator();

        { Slot slot = null;
          Iterator iter000 = self.classSlots();

          while (iter000.nextP()) {
            slot = ((Slot)(iter000.value));
            { boolean testValue000 = false;

              testValue000 = slot.slotPublicP;
              if (testValue000) {
                { boolean foundP000 = false;

                  { Slot ps = null;
                    Cons iter001 = publicslots;

                    loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                      ps = ((Slot)(iter001.value));
                      if (ps.slotName == slot.slotName) {
                        foundP000 = true;
                        break loop001;
                      }
                    }
                  }
                  testValue000 = foundP000;
                }
                testValue000 = !testValue000;
              }
              if (testValue000) {
                publicslots = ((Cons)(Cons.cons(slot, publicslots)));
              }
            }
          }
        }
        iterator.iteratorNextCode = Native.find_java_method("edu.isi.stella.AllPurposeIterator", "iteratorConsListNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
        iterator.iteratorConsList = publicslots;
        iterator.firstIterationP = true;
        return (iterator);
      }
    }
  }

  public static void freeRequiredSlotNames(Stella_Class renamed_Class) {
    if (renamed_Class.classRequiredSlotNames().nonEmptyP()) {
      renamed_Class.classRequiredSlotNames().free();
      KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_REQUIRED_SLOT_NAMES, null, null);
    }
  }

  public static void computeRequiredSlotNames(Stella_Class renamed_Class) {
    { List slotnames = List.newList();

      { Slot slot = null;
        Iterator iter000 = renamed_Class.classSlots();

        while (iter000.nextP()) {
          slot = ((Slot)(iter000.value));
          if (Stella_Object.storageSlotP(slot) &&
              (((StorageSlot)(slot)).slotRequiredP &&
               (!slotnames.memberP(slot.slotName)))) {
            slotnames.push(slot.slotName);
          }
        }
      }
      if (slotnames.emptyP()) {
        slotnames.free();
      }
      else {
        KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_REQUIRED_SLOT_NAMES, slotnames.reverse(), null);
      }
    }
  }

  public static void clearSlotAndMethodCache(Stella_Class renamed_Class) {
    if (((Slot)((renamed_Class.classSlotAndMethodCache.theArray)[Stella.$SLOT_CACHE_SIZE$])) != null) {
      renamed_Class.classSlotAndMethodCache.clear();
    }
  }

  /** Lookup a local slot with <code>slotName</code> on <code>renamed_Class</code>.
   * @param renamed_Class
   * @param slotName
   * @return Slot
   */
  public static Slot lookupLocalSlot(Stella_Class renamed_Class, Symbol slotName) {
    { Slot slot = null;
      Cons iter000 = renamed_Class.classLocalSlots.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        slot = ((Slot)(iter000.value));
        if (slot.slotName == slotName) {
          return (slot);
        }
      }
    }
    return (null);
  }

  public static Slot lookupVisibleSlot(Stella_Class renamed_Class, Stella_Object slotName) {
    { Slot slot = null;
      String slotnamestring = null;
      Module module = ((Module)(Stella.$MODULE$.get()));

      { Surrogate testValue000 = Stella_Object.safePrimaryType(slotName);

        if (Surrogate.subtypeOfSymbolP(testValue000)) {
          { Symbol slotName000 = ((Symbol)(slotName));

            slot = Stella_Class.lookupSlot(renamed_Class, slotName000);
            if (slot != null) {
              return (slot);
            }
            slotnamestring = slotName000.symbolName;
            module = ((Module)(slotName000.homeContext));
          }
        }
        else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
          { Surrogate slotName000 = ((Surrogate)(slotName));

            slotnamestring = slotName000.symbolName;
            module = ((Module)(slotName000.homeContext));
          }
        }
        else if (Surrogate.subtypeOfKeywordP(testValue000)) {
          { Keyword slotName000 = ((Keyword)(slotName));

            slotnamestring = slotName000.symbolName;
          }
        }
        else if (Surrogate.subtypeOfStringP(testValue000)) {
          { StringWrapper slotName000 = ((StringWrapper)(slotName));

            slotnamestring = slotName000.wrapperValue;
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("Illegal slot name: `" + slotName + "'");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      { Symbol symbol = null;
        Cons iter000 = Stella.lookupVisibleSymbolsInModule(slotnamestring, module, true);

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          symbol = ((Symbol)(iter000.value));
          slot = Stella_Class.lookupSlot(renamed_Class, symbol);
          if (slot != null) {
            return (slot);
          }
        }
      }
      return (null);
    }
  }

  /** Alias for <code>lookupSlot</code>.  Kept for backwards compatibility.
   * @param renamed_Class
   * @param slotName
   * @return Slot
   */
  public static Slot safeLookupSlot(Stella_Class renamed_Class, Symbol slotName) {
    return (Stella_Class.lookupSlot(renamed_Class, slotName));
  }

  /** Return a slot owned by the class <code>renamed_Class</code> with name <code>slotName</code>.
   * Multiply inherited slots are disambiguated by a left-to-right class
   * precedence order for classes with multiple parents (similar to CLOS).
   * @param renamed_Class
   * @param slotName
   * @return Slot
   */
  public static Slot lookupSlot(Stella_Class renamed_Class, Symbol slotName) {
    if (renamed_Class == null) {
      return (null);
    }
    { int offset = slotName.symbolSlotOffset;
      Slot cachedslot = null;

      if (offset != Stella.NULL_INTEGER) {
        cachedslot = ((Slot)((renamed_Class.classSlotAndMethodCache.theArray)[(slotName.symbolSlotOffset)]));
        if ((cachedslot != null) &&
            (cachedslot.slotName == slotName)) {
          return (cachedslot);
        }
      }
      cachedslot = null;
      { Slot slot = null;
        Iterator iter000 = renamed_Class.classSlots();

        loop000 : while (iter000.nextP()) {
          slot = ((Slot)(iter000.value));
          if (slot.slotName == slotName) {
            cachedslot = slot;
            break loop000;
          }
        }
      }
      if (cachedslot == null) {
        return (null);
      }
      { int newoffset = ((Stella.$SYMBOL_SLOT_OFFSET_COUNTER$ + 1) % Stella.$SLOT_CACHE_SIZE$);

        Stella.$SYMBOL_SLOT_OFFSET_COUNTER$ = newoffset;
        slotName.symbolSlotOffset = newoffset;
        renamed_Class.classSlotAndMethodCache.insertAt(newoffset, cachedslot);
        renamed_Class.classSlotAndMethodCache.insertAt(Stella.$SLOT_CACHE_SIZE$, cachedslot);
        return (cachedslot);
      }
    }
  }

  public static void initializeSlotAndMethodCache(Stella_Class renamed_Class) {
    renamed_Class.classSlotAndMethodCache = Vector.newVector(Stella.$SLOT_CACHE_SIZE$ + 1);
  }

  public static void uninheritSlots(Stella_Class renamed_Class) {
    { Cons slotscursor = renamed_Class.classAllSlots;

      if (slotscursor != null) {
        if (!(renamed_Class.multipleParentsP())) {
          { Slot slot = null;
            Cons iter000 = renamed_Class.classAllSlots;

            loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              slot = ((Slot)(iter000.value));
              if ((!(slotscursor.rest == Stella.NIL)) &&
                  Slot.localSlotP(((Slot)(slotscursor.rest.value)), renamed_Class)) {
                slotscursor = slotscursor.rest;
              }
              else {
                break loop000;
              }
            }
          }
          slotscursor.rest = Stella.NIL;
        }
        renamed_Class.classAllSlots = null;
      }
    }
  }

  public static void inheritSlots(Stella_Class renamed_Class) {
    { Cons slots = Cons.copyConsList(renamed_Class.classLocalSlots.theConsList);

      if (renamed_Class.classDirectSupers.emptyP()) {
      }
      else if (renamed_Class.multipleParentsP()) {
        { Surrogate supertype = null;
          Cons iter000 = renamed_Class.classDirectSupers.theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            supertype = ((Surrogate)(iter000.value));
            slots = slots.concatenate(Cons.copyConsList(((Stella_Class)(supertype.surrogateValue)).classAllSlots), Stella.NIL);
          }
        }
        slots = slots.reverse();
        slots.removeDuplicates();
        slots = slots.reverse();
      }
      else {
        { Cons parentslots = ((Stella_Class)(((Surrogate)(renamed_Class.classDirectSupers.first())).surrogateValue)).classAllSlots;

          slots = slots.concatenate(parentslots, Stella.NIL);
        }
      }
      renamed_Class.classAllSlots = slots;
    }
  }

  /** Return the most specific class that is a superclass of
   * both <code>class1</code> and <code>class2</code>.  If there is more than one, arbitrarily pick one.
   * If there is none, return <code>null</code>.
   * @param class1
   * @param class2
   * @return Stella_Class
   */
  public static Stella_Class twoArgumentLeastCommonSuperclass(Stella_Class class1, Stella_Class class2) {
    if (Stella_Class.subclassOfP(class1, class2)) {
      return (class2);
    }
    if (Stella_Class.subclassOfP(class2, class1)) {
      return (class1);
    }
    { Stella_Class c = null;
      Cons iter000 = class1.classAllSuperClasses;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        c = ((Stella_Class)(iter000.value));
        c.classMarkedP = false;
      }
    }
    { Stella_Class c = null;
      Cons iter001 = class2.classAllSuperClasses;

      for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
        c = ((Stella_Class)(iter001.value));
        c.classMarkedP = true;
      }
    }
    { Stella_Class c = null;
      Cons iter002 = class1.classAllSuperClasses;

      for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
        c = ((Stella_Class)(iter002.value));
        if (c.classMarkedP) {
          return (c);
        }
      }
    }
    return (null);
  }

  public static void uninheritSuperclasses(Stella_Class renamed_Class) {
    renamed_Class.classAllSuperClasses = Stella.NIL;
  }

  public static void inheritSuperclasses(Stella_Class renamed_Class) {
    { List parentclasses = List.newList();

      Stella_Class.collectDirectSuperClasses(renamed_Class, parentclasses);
      if (!renamed_Class.multipleParentsP()) {
        { Stella_Class onlyparent = ((Stella_Class)(parentclasses.first()));

          if (onlyparent == null) {
            return;
          }
          renamed_Class.classAllSuperClasses = Cons.cons(onlyparent, onlyparent.classAllSuperClasses);
          return;
        }
      }
      parentclasses = parentclasses.reverse();
      { Cons allsuperclasses = Stella.NIL;
        Cons sublist = null;

        { Stella_Class parent = null;
          Cons iter000 = parentclasses.theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            parent = ((Stella_Class)(iter000.value));
            sublist = Stella.NIL;
            { Stella_Class ancestor = null;
              Cons iter001 = parent.classAllSuperClasses;
              Cons collect000 = null;

              for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                ancestor = ((Stella_Class)(iter001.value));
                if (!allsuperclasses.memberP(ancestor)) {
                  if (collect000 == null) {
                    {
                      collect000 = Cons.cons(ancestor, Stella.NIL);
                      if (sublist == Stella.NIL) {
                        sublist = collect000;
                      }
                      else {
                        Cons.addConsToEndOfConsList(sublist, collect000);
                      }
                    }
                  }
                  else {
                    {
                      collect000.rest = Cons.cons(ancestor, Stella.NIL);
                      collect000 = collect000.rest;
                    }
                  }
                }
              }
            }
            sublist = Cons.cons(parent, sublist);
            allsuperclasses = sublist.concatenate(allsuperclasses, Stella.NIL);
          }
        }
        renamed_Class.classAllSuperClasses = allsuperclasses;
      }
    }
  }

  public static void collectDirectSuperClasses(Stella_Class renamed_Class, List parents) {
    { List directsupertypes = renamed_Class.classDirectSupers;
      List nondirectparents = List.newList();

      { Surrogate supertype = null;
        Cons iter000 = directsupertypes.theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          supertype = ((Surrogate)(iter000.value));
          if (((Stella_Class)(supertype.surrogateValue)) != null) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(((Stella_Class)(supertype.surrogateValue)), Stella.NIL);
                if (parents.theConsList == Stella.NIL) {
                  parents.theConsList = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(parents.theConsList, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(((Stella_Class)(supertype.surrogateValue)), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      { Stella_Class superclass = null;
        Cons iter001 = parents.theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          superclass = ((Stella_Class)(iter001.value));
          { Stella_Class othersuperclass = null;
            Cons iter002 = parents.theConsList;

            for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
              othersuperclass = ((Stella_Class)(iter002.value));
              if (!(othersuperclass == superclass)) {
                if (superclass.classAllSuperClasses.memberP(othersuperclass)) {
                  nondirectparents.insert(othersuperclass);
                }
              }
            }
          }
        }
      }
      { Stella_Class p = null;
        Cons iter003 = nondirectparents.theConsList;

        for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
          p = ((Stella_Class)(iter003.value));
          parents.remove(p);
        }
      }
      nondirectparents.free();
    }
  }

  public static void removeDirectSupersBackLinks(Stella_Class renamed_Class) {
    { Surrogate classtype = renamed_Class.classType;

      { Surrogate supertype = null;
        Cons iter000 = renamed_Class.classDirectSupers.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          supertype = ((Surrogate)(iter000.value));
          if (((Stella_Class)(supertype.surrogateValue)) != null) {
            ((Stella_Class)(supertype.surrogateValue)).classDirectSubs.remove(classtype);
          }
        }
      }
    }
  }

  public static void addDirectSubsBackLinks(Stella_Class renamed_Class) {
    { List directsubs = renamed_Class.classDirectSubs;
      Surrogate classtype = renamed_Class.classType;

      directsubs.removeDuplicates();
      { Surrogate subtype = null;
        Cons iter000 = directsubs.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          subtype = ((Surrogate)(iter000.value));
          if (((Stella_Class)(subtype.surrogateValue)) != null) {
            { Stella_Class subclass = ((Stella_Class)(subtype.surrogateValue));

              if (subclass.classFinalizedP) {
                if (!(subclass.classAllSuperClasses.memberP(renamed_Class))) {
                  subclass.classDirectSupers.insert(classtype);
                  Stella_Class.unfinalizeClassAndSubclasses(renamed_Class);
                }
              }
              else {
                subclass.classDirectSupers.insertNew(classtype);
              }
            }
          }
        }
      }
    }
  }

  public static void addDirectSupersBackLinks(Stella_Class renamed_Class) {
    { List directsupers = renamed_Class.classDirectSupers;
      Surrogate classtype = renamed_Class.classType;

      directsupers.removeDuplicates();
      { Surrogate supertype = null;
        Cons iter000 = directsupers.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          supertype = ((Surrogate)(iter000.value));
          if (((Stella_Class)(supertype.surrogateValue)) != null) {
            { Stella_Class superclass = ((Stella_Class)(supertype.surrogateValue));

              superclass.classDirectSubs.insertNew(classtype);
              TaxonomyGraph.linkTaxonomyNodes(Stella.$CLASS_TAXONOMY_GRAPH$, ((Stella_Class)(supertype.surrogateValue)).classTaxonomyNode, renamed_Class.classTaxonomyNode);
            }
          }
        }
      }
    }
  }

  /** Return <code>true</code> if <code>renamed_Class</code> has more than one direct superclass.
   * @return boolean
   */
  public boolean multipleParentsP() {
    { Stella_Class renamed_Class = this;

      return (!(renamed_Class.classDirectSupers.rest() == Stella.NIL));
    }
  }

  public static void helpUnfinalizeClassSlots(Stella_Class renamed_Class) {
    Stella_Class.clearSlotAndMethodCache(renamed_Class);
    if (!renamed_Class.classSlotsFinalizedP) {
      return;
    }
    Stella_Class.freeRequiredSlotNames(renamed_Class);
    { Slot slot = null;
      Cons iter000 = renamed_Class.localSlots().theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        slot = ((Slot)(iter000.value));
        slot.unfinalizeLocalSlot();
      }
    }
    Stella_Class.rememberUnfinalizedClass(renamed_Class, false);
    renamed_Class.classSlotsFinalizedP = false;
  }

  public static void unfinalizeClassSlots(Stella_Class renamed_Class) {
    if (!renamed_Class.classSlotsFinalizedP) {
      Stella_Class.clearSlotAndMethodCache(renamed_Class);
      return;
    }
    { Surrogate subtype = null;
      Cons iter000 = renamed_Class.classDirectSubs.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        subtype = ((Surrogate)(iter000.value));
        if (((Stella_Class)(subtype.surrogateValue)) != null) {
          Stella_Class.unfinalizeClassSlots(((Stella_Class)(subtype.surrogateValue)));
        }
      }
    }
    Stella_Class.helpUnfinalizeClassSlots(renamed_Class);
  }

  public static void finalizeClassSlots(Stella_Class renamed_Class) {
    KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_BADp, Stella.TRUE_WRAPPER, null);
    { Surrogate renamed_Super = null;
      Cons iter000 = renamed_Class.classDirectSupers.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        renamed_Super = ((Surrogate)(iter000.value));
        if (!((Stella_Class)(renamed_Super.surrogateValue)).classSlotsFinalizedP) {
          Stella_Class.finalizeClassSlots(((Stella_Class)(renamed_Super.surrogateValue)));
        }
      }
    }
    Stella_Class.computeRequiredSlotNames(renamed_Class);
    { Surrogate classtype = renamed_Class.classType;

      { Slot slot = null;
        Cons iter001 = renamed_Class.classLocalSlots.theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          slot = ((Slot)(iter001.value));
          Slot.registerSlotName(slot);
          slot.slotOwner = classtype;
        }
      }
    }
    { Slot slot = null;
      Cons iter002 = renamed_Class.classLocalSlots.theConsList;

      for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
        slot = ((Slot)(iter002.value));
        Slot.finalizeLocalSlot(slot);
      }
    }
    renamed_Class.classSlotsFinalizedP = true;
    KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_BADp, null, null);
  }

  public static void unfinalizeClassAndSubclasses(Stella_Class renamed_Class) {
    if (!renamed_Class.classFinalizedP) {
      return;
    }
    Stella_Class.removeDirectSupersBackLinks(renamed_Class);
    { List subs = renamed_Class.classDirectSubs.copy();

      { Surrogate subtype = null;
        Cons iter000 = subs.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          subtype = ((Surrogate)(iter000.value));
          if (((Stella_Class)(subtype.surrogateValue)) != null) {
            Stella_Class.unfinalizeClassAndSubclasses(((Stella_Class)(subtype.surrogateValue)));
          }
        }
      }
      subs.free();
    }
    { Surrogate alias = null;
      Cons iter001 = renamed_Class.classSynonyms().theConsList;

      for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
        alias = ((Surrogate)(iter001.value));
        if (((Stella_Class)(alias.surrogateValue)) == renamed_Class) {
          alias.surrogateValue = null;
        }
      }
    }
    Stella_Class.uninheritSuperclasses(renamed_Class);
    Stella_Class.unfinalizeClassSlots(renamed_Class);
    Stella_Class.rememberUnfinalizedClass(renamed_Class, false);
    renamed_Class.classFinalizedP = false;
  }

  public static boolean helpFinalizeClass(Stella_Class renamed_Class, Surrogate finalizedparent) {
    if (renamed_Class.classFinalizedP) {
      return (true);
    }
    KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_BADp, Stella.TRUE_WRAPPER, null);
    { Surrogate renamed_Super = null;
      Cons iter000 = renamed_Class.classDirectSupers.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        renamed_Super = ((Surrogate)(iter000.value));
        if (!(renamed_Super == finalizedparent)) {
          { Stella_Class superclass = Surrogate.typeToClass(renamed_Super);

            if (superclass != null) {
              if (!(Stella_Class.helpFinalizeClass(superclass, null))) {
                return (false);
              }
            }
            else {
              return (false);
            }
          }
        }
      }
    }
    if (renamed_Class.classFinalizedP) {
      KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_BADp, null, null);
      return (true);
    }
    Stella_Class.finalizeOneClass(renamed_Class);
    { Surrogate sub = null;
      Cons iter001 = renamed_Class.classDirectSubs.theConsList;

      for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
        sub = ((Surrogate)(iter001.value));
        { Stella_Class subclass = Surrogate.typeToClass(sub);

          if (subclass != null) {
            Stella_Class.helpFinalizeClass(subclass, renamed_Class.classType);
          }
        }
      }
    }
    KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_BADp, null, null);
    return (true);
  }

  public static boolean finalizeClass(Stella_Class renamed_Class) {
    return (Stella_Class.helpFinalizeClass(renamed_Class, null));
  }

  public static void finalizeOneClass(Stella_Class renamed_Class) {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, renamed_Class.homeModule());
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (((Symbol)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_EXTENSION_NAME, null))) != null) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_STORED_ACTIVEp, Stella.TRUE_WRAPPER, null);
        }
        Stella_Class.addDirectSupersBackLinks(renamed_Class);
        Stella_Class.inheritSuperclasses(renamed_Class);
        if ((((BooleanWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_STORED_ACTIVEp, null))) != null) &&
            BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_STORED_ACTIVEp, null))))) {
          Stella_Class.activateClass(renamed_Class);
        }
        Stella_Class.addPrimaryType(renamed_Class);
        { Surrogate alias = null;
          Cons iter000 = renamed_Class.classSynonyms().theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            alias = ((Surrogate)(iter000.value));
            if ((((Stella_Class)(alias.surrogateValue)) != null) &&
                ((!(((Stella_Class)(alias.surrogateValue)) == renamed_Class)) &&
                 (!Stella.stringEqlP(Stella_Class.className(((Stella_Class)(alias.surrogateValue))), Stella_Class.className(renamed_Class))))) {
              {
                Stella.STANDARD_WARNING.nativeStream.println("Warning: Alias `" + Symbol.internSymbolInModule(alias.symbolName, ((Module)(alias.homeContext)), true) + "' can't point to `" + Stella_Class.classSymbol(renamed_Class) + "' because it already points to ");
                Stella.STANDARD_WARNING.nativeStream.println("the class `" + Stella_Class.classSymbol(((Stella_Class)(alias.surrogateValue))) + "'.");
              }
;
            }
            else {
              alias.surrogateValue = renamed_Class;
            }
          }
        }
        if ((((Symbol)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_EXTENSION_NAME, null))) != null) &&
            (((ClassExtension)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_EXTENSION, null))) == null)) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_EXTENSION, ClassExtension.newClassExtension(), null);
        }
        HookList.runHooks(Stella.$FINALIZE_RELATION_HOOKS$, renamed_Class);
        renamed_Class.classFinalizedP = true;

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

  public static void addPrimaryType(Stella_Class renamed_Class) {
    { Surrogate classtype = renamed_Class.classType;
      Cons slottree = null;

      { boolean testValue000 = false;

        testValue000 = !renamed_Class.abstractP;
        if (testValue000) {
          testValue000 = Surrogate.subtypeOfP(classtype, Stella.SGT_STELLA_OBJECT);
          if (testValue000) {
            { boolean foundP000 = false;

              { Slot slot = null;
                Cons iter000 = renamed_Class.classLocalSlots.theConsList;

                loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  slot = ((Slot)(iter000.value));
                  if (slot.slotName == Stella.SYM_STELLA_PRIMARY_TYPE) {
                    foundP000 = true;
                    break loop000;
                  }
                }
              }
              testValue000 = foundP000;
            }
            testValue000 = !testValue000;
          }
        }
        if (testValue000) {
          slottree = Cons.list$(Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Symbol.internSymbolInModule(classtype.symbolName, ((Module)(classtype.homeContext)), true), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Stella.KWD_TYPE, Cons.cons(Stella.SYM_STELLA_TYPE, Cons.cons(Stella.KWD_AUXILIARYp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(classtype, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))))));
          renamed_Class.classLocalSlots.push(Symbol.defineInlineMethod(Stella.SYM_STELLA_PRIMARY_TYPE, slottree));
        }
      }
    }
  }

  public static void activateClass(Stella_Class renamed_Class) {
    { Stella_Class activeobjectclass = Surrogate.typeToClass(Stella.SGT_STELLA_ACTIVE_OBJECT);
      List supers = renamed_Class.classDirectSupers;

      if ((activeobjectclass != null) &&
          Stella_Class.subclassOfP(renamed_Class, activeobjectclass)) {
        return;
      }
      if (supers.length() == 0) {
        supers.insert(Stella.SGT_STELLA_ACTIVE_OBJECT);
      }
      else if ((supers.length() == 1) &&
          ((((Surrogate)(supers.first())) == Stella.SGT_STELLA_OBJECT) ||
           (((Surrogate)(supers.first())) == Stella.SGT_STELLA_STANDARD_OBJECT))) {
        Stella_Class.removeDirectSupersBackLinks(renamed_Class);
        supers.clear();
        supers.insert(Stella.SGT_STELLA_ACTIVE_OBJECT);
      }
      else {
        KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_STORED_ACTIVEp, Stella.FALSE_WRAPPER, null);
        if (((Symbol)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_EXTENSION_NAME, null))) != null) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_EXTENSION_NAME, null, null);
        }
        {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: Cannot convert `" + renamed_Class + "' into an ACTIVE-OBJECT.");
          Stella.STANDARD_WARNING.nativeStream.println("You have to modify its superclasses by hand.");
        }
;
        return;
      }
      Stella_Class.addDirectSupersBackLinks(renamed_Class);
      Stella_Class.inheritSuperclasses(renamed_Class);
    }
  }

  public static void forgetUnfinalizedClass(Stella_Class renamed_Class) {
    if (!(renamed_Class.classFinalizedP &&
        renamed_Class.classSlotsFinalizedP)) {
      Stella.$UNFINALIZED_CLASSES$.remove(renamed_Class);
    }
  }

  public static void rememberUnfinalizedClass(Stella_Class renamed_Class, boolean forceP) {
    if (forceP ||
        (renamed_Class.classFinalizedP &&
         renamed_Class.classSlotsFinalizedP)) {
      Stella.$UNFINALIZED_CLASSES$.push(renamed_Class);
      Stella.$NEWLY_UNFINALIZED_CLASSESp$ = true;
    }
  }

  public static List classNativeSupers(Stella_Class renamed_Class) {
    { boolean alwaysP000 = true;

      { Surrogate renamed_Super = null;
        Cons iter000 = renamed_Class.classDirectSupers.theConsList;

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          renamed_Super = ((Surrogate)(iter000.value));
          if (!Surrogate.typeToClass(renamed_Super).primitiveP()) {
            alwaysP000 = false;
            break loop000;
          }
        }
      }
      if (alwaysP000) {
        return (renamed_Class.classDirectSupers);
      }
      else {
        return (Stella_Class.mostSpecificPrimitiveSupers(renamed_Class));
      }
    }
  }

  public static List mostSpecificPrimitiveSupers(Stella_Class renamed_Class) {
    { List supers = List.newList();

      Stella_Class.collectMostSpecificPrimitiveSupers(renamed_Class, supers);
      return (supers.reverse());
    }
  }

  public static void collectMostSpecificPrimitiveSupers(Stella_Class renamed_Class, List supers) {
    { Surrogate renamed_Super = null;
      Cons iter000 = renamed_Class.classDirectSupers.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        renamed_Super = ((Surrogate)(iter000.value));
        if (Surrogate.typeToClass(renamed_Super).primitiveP()) {
          Surrogate.insertPrimitiveSuper(renamed_Super, supers);
        }
        else {
          Stella_Class.collectMostSpecificPrimitiveSupers(Surrogate.typeToClass(renamed_Super), supers);
        }
      }
    }
  }

  /** Destroy the Stella class <code>self</code> and all its subclasses.
   * @param self
   */
  public static void destroyClassAndSubclasses(Stella_Class self) {
    { Surrogate subtype = null;
      Cons iter000 = self.classDirectSubs.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        subtype = ((Surrogate)(iter000.value));
        if (((Stella_Class)(subtype.surrogateValue)) != null) {
          Stella_Class.destroyClassAndSubclasses(((Stella_Class)(subtype.surrogateValue)));
        }
      }
    }
    self.destroyClass();
  }

  /** Destroy the Stella class <code>self</code>.  
   * Unfinalize its subclasses (if it has any).
   */
  public void destroyClass() {
    { Stella_Class self = this;

      if (self.deletedP()) {
        return;
      }
      if (self.classType.homeContext == Stella.$STELLA_MODULE$) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't delete STELLA class `" + Stella_Class.className(self) + "'.");
        return;
      }
      Stella_Class.unfinalizeClassAndSubclasses(self);
      self.unbindFromSurrogate();
      if (self.classTaxonomyNode != null) {
        TaxonomyGraph.removeTaxonomyNode(Stella.$CLASS_TAXONOMY_GRAPH$, self.classTaxonomyNode);
      }
      self.deletedPSetter(true);
      self.free();
    }
  }

  public static void undefineOldClass(Stella_Class oldclass, Stella_Class newclass) {
    { Cons newsubs = Cons.copyConsList(newclass.classDirectSubs.theConsList);

      Stella_Class.unfinalizeClassAndSubclasses(oldclass);
      Stella_Class.forgetUnfinalizedClass(oldclass);
      { Surrogate oldsub = null;
        Cons iter000 = oldclass.classDirectSubs.theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          oldsub = ((Surrogate)(iter000.value));
          if (collect000 == null) {
            {
              collect000 = Cons.cons(oldsub, Stella.NIL);
              if (newsubs == Stella.NIL) {
                newsubs = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(newsubs, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(oldsub, Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      newclass.classDirectSubs.clear();
      newclass.classDirectSubs.theConsList = newsubs.removeDuplicates();
      oldclass.classDirectSubs.clear();
    }
    { TaxonomyNode taxonomynode = oldclass.classTaxonomyNode;

      { Surrogate renamed_Super = null;
        Cons iter001 = oldclass.classDirectSupers.theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          renamed_Super = ((Surrogate)(iter001.value));
          if ((((Stella_Class)(renamed_Super.surrogateValue)) != null) &&
              (!newclass.classDirectSupers.memberP(renamed_Super))) {
            TaxonomyGraph.unlinkTaxonomyNodes(Stella.$CLASS_TAXONOMY_GRAPH$, ((Stella_Class)(renamed_Super.surrogateValue)).classTaxonomyNode, taxonomynode);
          }
        }
      }
      newclass.classTaxonomyNode = taxonomynode;
      oldclass.classTaxonomyNode = null;
    }
    { Slot oldslot = null;
      Cons iter002 = oldclass.classLocalSlots.theConsList;

      for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
        oldslot = ((Slot)(iter002.value));
        if (oldslot.slotExternalP) {
          Slot.transferExternalSlotToNewClass(oldslot, newclass);
        }
      }
    }
    newclass.classConstructorCode = oldclass.classConstructorCode;
    Stella_Class.transferDemonsFromOldclass(oldclass, newclass);
    HookList.runHooks(Stella.$REDEFINE_RELATION_HOOKS$, List.list(Cons.cons(oldclass, Cons.cons(newclass, Stella.NIL))));
    oldclass.free();
  }

  public static void transferDemonsFromOldclass(Stella_Class oldclass, Stella_Class newclass) {
    { Slot newslot = null;

      { Slot oldslot = null;
        Cons iter000 = oldclass.classLocalSlots.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          oldslot = ((Slot)(iter000.value));
          { 
            newslot = Stella_Class.lookupLocalSlot(newclass, oldslot.slotName);
            if (newslot != null) {
              if (Surrogate.subtypeOfStorageSlotP(Stella_Object.safePrimaryType(oldslot))) {
                { StorageSlot oldslot000 = ((StorageSlot)(oldslot));

                  if (Surrogate.subtypeOfStorageSlotP(Stella_Object.safePrimaryType(newslot))) {
                    { StorageSlot newslot000 = ((StorageSlot)(newslot));

                      KeyValueList.setDynamicSlotValue(newslot000.dynamicSlots, Stella.SYM_STELLA_SLOT_GUARD_DEMONS, oldslot000.slotGuardDemons(), null);
                      KeyValueList.setDynamicSlotValue(oldslot000.dynamicSlots, Stella.SYM_STELLA_SLOT_GUARD_DEMONS, null, null);
                      KeyValueList.setDynamicSlotValue(newslot000.dynamicSlots, Stella.SYM_STELLA_SLOT_DEMONS, oldslot000.slotDemons(), null);
                      KeyValueList.setDynamicSlotValue(oldslot000.dynamicSlots, Stella.SYM_STELLA_SLOT_DEMONS, null, null);
                    }
                  }
                  else {
                  }
                }
              }
              else {
              }
            }
          }
        }
      }
    }
    KeyValueList.setDynamicSlotValue(newclass.dynamicSlots, Stella.SYM_STELLA_CLASS_CONSTRUCTOR_DEMONS, oldclass.classConstructorDemons(), null);
    KeyValueList.setDynamicSlotValue(oldclass.dynamicSlots, Stella.SYM_STELLA_CLASS_CONSTRUCTOR_DEMONS, null, null);
    KeyValueList.setDynamicSlotValue(newclass.dynamicSlots, Stella.SYM_STELLA_CLASS_GUARD_CONSTRUCTOR_DEMONS, oldclass.classGuardConstructorDemons(), null);
    KeyValueList.setDynamicSlotValue(oldclass.dynamicSlots, Stella.SYM_STELLA_CLASS_GUARD_CONSTRUCTOR_DEMONS, null, null);
    KeyValueList.setDynamicSlotValue(newclass.dynamicSlots, Stella.SYM_STELLA_CLASS_DESTRUCTOR_DEMONS, oldclass.classDestructorDemons(), null);
    KeyValueList.setDynamicSlotValue(oldclass.dynamicSlots, Stella.SYM_STELLA_CLASS_DESTRUCTOR_DEMONS, null, null);
    KeyValueList.setDynamicSlotValue(newclass.dynamicSlots, Stella.SYM_STELLA_CLASS_GUARD_DESTRUCTOR_DEMONS, oldclass.classGuardDestructorDemons(), null);
    KeyValueList.setDynamicSlotValue(oldclass.dynamicSlots, Stella.SYM_STELLA_CLASS_GUARD_DESTRUCTOR_DEMONS, null, null);
  }

  public static void incorporateClassOptions(Stella_Class renamed_Class, KeywordKeyValueList options) {
    { Keyword key = null;
      Stella_Object value = null;
      KvListIterator iter000 = ((KvListIterator)(options.allocateIterator()));

      while (iter000.nextP()) {
        key = ((Keyword)(iter000.key));
        value = iter000.value;
        if (key == Stella.KWD_DOCUMENTATION) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, StringWrapper.wrapString(((StringWrapper)(value)).wrapperValue), Stella.NULL_STRING_WRAPPER);
        }
        else if (key == Stella.KWD_CL_NATIVE_TYPE) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_CL_NATIVE_TYPE, StringWrapper.wrapString(((StringWrapper)(value)).wrapperValue), Stella.NULL_STRING_WRAPPER);
        }
        else if (key == Stella.KWD_CPP_NATIVE_TYPE) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_CPP_NATIVE_TYPE, StringWrapper.wrapString(((StringWrapper)(value)).wrapperValue), Stella.NULL_STRING_WRAPPER);
        }
        else if (key == Stella.KWD_IDL_NATIVE_TYPE) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_IDL_NATIVE_TYPE, StringWrapper.wrapString(((StringWrapper)(value)).wrapperValue), Stella.NULL_STRING_WRAPPER);
        }
        else if (key == Stella.KWD_JAVA_NATIVE_TYPE) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_JAVA_NATIVE_TYPE, StringWrapper.wrapString(((StringWrapper)(value)).wrapperValue), Stella.NULL_STRING_WRAPPER);
        }
        else if (key == Stella.KWD_PUBLICp) {
          renamed_Class.classPublicP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
        }
        else if (key == Stella.KWD_ABSTRACTp) {
          renamed_Class.abstractP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
        }
        else if (key == Stella.KWD_ACTIVEp) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_STORED_ACTIVEp, ((BooleanWrapper)(value)), null);
        }
        else if (key == Stella.KWD_CL_STRUCTp) {
          renamed_Class.clStructP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
        }
        else if (key == Stella.KWD_MIXINp) {
          renamed_Class.mixinP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
          if (renamed_Class.mixinP) {
            renamed_Class.abstractP = true;
          }
        }
        else if (key == Stella.KWD_RECYCLE_METHOD) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_RECYCLE_METHOD, ((Keyword)(value)), null);
        }
        else if (key == Stella.KWD_EXTENSION) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_EXTENSION_NAME, ((Symbol)(value)), null);
        }
        else if (key == Stella.KWD_CREATOR) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_CREATOR, ((Symbol)(value)), null);
        }
        else if (key == Stella.KWD_INITIALIZER) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_INITIALIZER, ((Symbol)(value)), null);
        }
        else if (key == Stella.KWD_TERMINATOR) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_TERMINATOR, ((Symbol)(value)), null);
        }
        else if (key == Stella.KWD_DESTRUCTOR) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_DESTRUCTOR, ((Symbol)(value)), null);
        }
        else if (key == Stella.KWD_INITIAL_VALUE) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_INITIAL_VALUE, value, null);
        }
        else if (key == Stella.KWD_PRINT_FORM) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_PRINT_FORM, value, null);
        }
        else if (key == Stella.KWD_EQUALITY_TEST) {
        }
        else if (key == Stella.KWD_KEY) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_KEY, List.newList(), null);
          { Stella_Object slotname = null;
            Cons iter001 = ((Cons)(value));
            List into000 = renamed_Class.classKey();
            Cons collect000 = null;

            for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              slotname = iter001.value;
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(slotname, Stella.NIL);
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
                  collect000.rest = Cons.cons(slotname, Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
        }
        else if (key == Stella.KWD_PARAMETERS) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_PARAMETERS, List.newList(), null);
          { Slot slot = null;
            Cons iter002 = ((List)(value)).theConsList;
            List into001 = renamed_Class.classParameters();
            Cons collect001 = null;

            for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
              slot = ((Slot)(iter002.value));
              if (collect001 == null) {
                {
                  collect001 = Cons.cons(slot.slotName, Stella.NIL);
                  if (into001.theConsList == Stella.NIL) {
                    into001.theConsList = collect001;
                  }
                  else {
                    Cons.addConsToEndOfConsList(into001.theConsList, collect001);
                  }
                }
              }
              else {
                {
                  collect001.rest = Cons.cons(slot.slotName, Stella.NIL);
                  collect001 = collect001.rest;
                }
              }
            }
          }
        }
        else if (key == Stella.KWD_SYNONYMS) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_SYNONYMS, List.newList(), null);
          { Surrogate type = null;
            Cons iter003 = ((Cons)(value));
            List into002 = renamed_Class.classSynonyms();
            Cons collect002 = null;

            for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
              type = ((Surrogate)(iter003.value));
              if (collect002 == null) {
                {
                  collect002 = Cons.cons(type, Stella.NIL);
                  if (into002.theConsList == Stella.NIL) {
                    into002.theConsList = collect002;
                  }
                  else {
                    Cons.addConsToEndOfConsList(into002.theConsList, collect002);
                  }
                }
              }
              else {
                {
                  collect002.rest = Cons.cons(type, Stella.NIL);
                  collect002 = collect002.rest;
                }
              }
            }
          }
        }
        else if (key == Stella.KWD_PROPERTIES) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_PROPERTIES, ((List)(value)), null);
        }
        else if (key == Stella.KWD_META_ATTRIBUTES) {
          KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_META_ATTRIBUTES, ((KeyValueList)(value)), null);
        }
        else if (key == Stella.KWD_CHILDREN) {
          renamed_Class.classDirectSubs = ((List)(value));
          Stella.$CLASSES_WITH_UNRESOLVED_CHILDREN_REFERENCES$.push(renamed_Class);
        }
        else {
          if (!(Stella_Object.runOptionHandlerP(renamed_Class, key, value))) {
            { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationWarning();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
                  {
                    Stella.STANDARD_WARNING.nativeStream.println();
                    Stella.STANDARD_WARNING.nativeStream.println(" Skipping invalid class option `" + Stella_Object.deUglifyParseTree(key) + "'");
                    Stella.STANDARD_WARNING.nativeStream.println("in the definition of class `" + Stella_Class.classSymbol(renamed_Class) + "'.");
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

  public static java.lang.reflect.Method getConstructor(Stella_Class renamed_Class, boolean warnP) {
    { java.lang.reflect.Method constructor = renamed_Class.classConstructorCode;

      if (constructor != null) {
        return (constructor);
      }
      if (warnP) {
        if (renamed_Class.abstractP) {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: The abstract class `" + Stella_Class.classSymbol(renamed_Class) + "' cannot have a constructor.");
          return (null);
        }
        Stella.STANDARD_WARNING.nativeStream.println("Warning: The `" + ((renamed_Class.privateP() ? "private " : "")) + "'class `" + Stella_Class.classSymbol(renamed_Class) + "' does not have a callable constructor.");
      }
      return (null);
    }
  }

  public void unbindFromSurrogate() {
    { Stella_Class self = this;

      { Surrogate surrogate = self.classType;

        if (surrogate != null) {
          surrogate.surrogateValue = null;
          self.classType = null;
        }
      }
    }
  }

  public static Symbol classSymbol(Stella_Class renamed_Class) {
    return (Symbol.internSymbolInModule(renamed_Class.classType.symbolName, ((Module)(renamed_Class.classType.homeContext)), true));
  }

  public static String className(Stella_Class renamed_Class) {
    return (renamed_Class.classType.symbolName);
  }

  /** Iterate over all private storage-slots attached to 'class'.
   * @param renamed_Class
   * @return Iterator
   */
  public static Iterator privateClassStorageSlots(Stella_Class renamed_Class) {
    return (Stella_Class.classStorageSlots(renamed_Class, Cons.cons(FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Slot", "filterPrivateSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")})), Cons.cons(FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Slot", "filterNonParameterSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")})), Cons.cons(FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Slot", "filterNonExternalSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")})), Cons.cons(FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Slot", "filterNonAuxiliarySlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")})), Stella.NIL))))));
  }

  /** Iterate over all public storage-slots attached to 'class'.
   * @param renamed_Class
   * @return Iterator
   */
  public static Iterator publicClassStorageSlots(Stella_Class renamed_Class) {
    return (Stella_Class.classStorageSlots(renamed_Class, Cons.cons(FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Slot", "filterPublicSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")})), Cons.cons(FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Slot", "filterNonParameterSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")})), Cons.cons(FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Slot", "filterNonExternalSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")})), Cons.cons(FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Slot", "filterNonAuxiliarySlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")})), Stella.NIL))))));
  }

  public static Iterator classTables(Stella_Class renamed_Class, Cons filters) {
    { AllPurposeIterator iterator = AllPurposeIterator.newAllPurposeIterator();

      iterator.iteratorNextCode = Native.find_java_method("edu.isi.stella.AllPurposeIterator", "classTablesNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
      iterator.iteratorConsList = renamed_Class.classLocalSlots.theConsList;
      iterator.iteratorObject = filters;
      iterator.iteratorFilterCode = Native.find_java_method("edu.isi.stella.Slot", "filterSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
      return (iterator);
    }
  }

  public static Iterator classStorageSlots(Stella_Class renamed_Class, Cons filters) {
    { AllPurposeIterator iterator = AllPurposeIterator.newAllPurposeIterator();

      iterator.iteratorNextCode = Native.find_java_method("edu.isi.stella.AllPurposeIterator", "classStorageSlotsNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
      iterator.iteratorConsList = renamed_Class.classLocalSlots.theConsList;
      iterator.iteratorObject = filters;
      iterator.iteratorFilterCode = Native.find_java_method("edu.isi.stella.Slot", "filterSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
      return (iterator);
    }
  }

  /** Iterate over all private methods attached to 'class'.
   * @param renamed_Class
   * @return Iterator
   */
  public static Iterator privateClassMethods(Stella_Class renamed_Class) {
    return (Stella_Class.classMethods(renamed_Class, Cons.cons(FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Slot", "filterPrivateSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")})), Cons.cons(FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Slot", "filterNonExternalSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")})), Cons.cons(FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Slot", "filterNonAuxiliarySlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")})), Stella.NIL)))));
  }

  /** Iterate over all private methods attached to 'class'.
   * @param renamed_Class
   * @return Iterator
   */
  public static Iterator publicClassMethods(Stella_Class renamed_Class) {
    return (Stella_Class.classMethods(renamed_Class, Cons.cons(FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Slot", "filterPublicSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")})), Cons.cons(FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Slot", "filterNonExternalSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")})), Cons.cons(FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.stella.Slot", "filterNonAuxiliarySlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")})), Stella.NIL)))));
  }

  public static Iterator classMethods(Stella_Class renamed_Class, Cons filters) {
    { AllPurposeIterator iterator = AllPurposeIterator.newAllPurposeIterator();

      iterator.iteratorNextCode = Native.find_java_method("edu.isi.stella.AllPurposeIterator", "classMethodsNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
      iterator.iteratorConsList = renamed_Class.classLocalSlots.theConsList;
      iterator.iteratorObject = filters;
      iterator.iteratorFilterCode = Native.find_java_method("edu.isi.stella.Slot", "filterSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
      return (iterator);
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { Stella_Class self = this;

      stream.print("|C|" + (((self.classType != null) ? Stella_Class.classSymbol(self).relativeName(false) : "??")));
    }
  }

  public static Stella_Object accessClassSlotValue(Stella_Class self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_CL_STRUCTp) {
      if (setvalueP) {
        self.clStructP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.clStructP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_MIXINp) {
      if (setvalueP) {
        self.mixinP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.mixinP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_TYPE) {
      if (setvalueP) {
        self.classType = ((Surrogate)(value));
      }
      else {
        value = self.classType;
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_ARITY) {
      value = IntegerWrapper.wrapInteger(self.classArity());
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_DIRECT_SUPERS) {
      if (setvalueP) {
        self.classDirectSupers = ((List)(value));
      }
      else {
        value = self.classDirectSupers;
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_DIRECT_SUBS) {
      if (setvalueP) {
        self.classDirectSubs = ((List)(value));
      }
      else {
        value = self.classDirectSubs;
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_ALL_SUPER_CLASSES) {
      if (setvalueP) {
        self.classAllSuperClasses = ((Cons)(value));
      }
      else {
        value = self.classAllSuperClasses;
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_ALL_SLOTS) {
      if (setvalueP) {
        self.classAllSlots = ((Cons)(value));
      }
      else {
        value = self.classAllSlots;
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_LOCAL_SLOTS) {
      if (setvalueP) {
        self.classLocalSlots = ((List)(value));
      }
      else {
        value = self.classLocalSlots;
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_SLOT_AND_METHOD_CACHE) {
      if (setvalueP) {
        self.classSlotAndMethodCache = ((Vector)(value));
      }
      else {
        value = self.classSlotAndMethodCache;
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_ABSTRACTp) {
      if (setvalueP) {
        self.abstractP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.abstractP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_MIXINp) {
      if (setvalueP) {
        self.mixinP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.mixinP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_COLLECTIONp) {
      if (setvalueP) {
        self.classCollectionP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.classCollectionP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_CL_STRUCTp) {
      if (setvalueP) {
        self.clStructP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.clStructP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_CL_STRUCT_SLOTS) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_CL_STRUCT_SLOTS, ((List)(value)), null);
      }
      else {
        value = self.classClStructSlots();
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_PUBLICp) {
      if (setvalueP) {
        self.classPublicP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.classPublicP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_RECYCLE_METHOD) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_RECYCLE_METHOD, ((Keyword)(value)), null);
      }
      else {
        value = self.classRecycleMethod();
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_FINALIZEDp) {
      if (setvalueP) {
        self.classFinalizedP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.classFinalizedP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_SLOTS_FINALIZEDp) {
      if (setvalueP) {
        self.classSlotsFinalizedP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.classSlotsFinalizedP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_STRINGIFIED_SOURCE) {
      if (setvalueP) {
        self.classStringifiedSource = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.classStringifiedSource);
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_PARAMETERS) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_PARAMETERS, ((List)(value)), null);
      }
      else {
        value = self.classParameters();
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_CONSTRUCTOR_CODE) {
      if (setvalueP) {
        self.classConstructorCode = ((FunctionCodeWrapper)(value)).wrapperValue;
      }
      else {
        value = FunctionCodeWrapper.wrapFunctionCode(self.classConstructorCode);
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_SLOT_ACCESSOR_CODE) {
      if (setvalueP) {
        self.classSlotAccessorCode = ((FunctionCodeWrapper)(value)).wrapperValue;
      }
      else {
        value = FunctionCodeWrapper.wrapFunctionCode(self.classSlotAccessorCode);
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_REQUIRED_SLOT_NAMES) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_REQUIRED_SLOT_NAMES, ((List)(value)), null);
      }
      else {
        value = self.classRequiredSlotNames();
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_GUARD_CONSTRUCTOR_DEMONS) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_GUARD_CONSTRUCTOR_DEMONS, ((List)(value)), null);
      }
      else {
        value = self.classGuardConstructorDemons();
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_CONSTRUCTOR_DEMONS) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_CONSTRUCTOR_DEMONS, ((List)(value)), null);
      }
      else {
        value = self.classConstructorDemons();
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_GUARD_DESTRUCTOR_DEMONS) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_GUARD_DESTRUCTOR_DEMONS, ((List)(value)), null);
      }
      else {
        value = self.classGuardDestructorDemons();
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_DESTRUCTOR_DEMONS) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_DESTRUCTOR_DEMONS, ((List)(value)), null);
      }
      else {
        value = self.classDestructorDemons();
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_KEY) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_KEY, ((List)(value)), null);
      }
      else {
        value = self.classKey();
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_SYNONYMS) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_SYNONYMS, ((List)(value)), null);
      }
      else {
        value = self.classSynonyms();
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_MARKEDp) {
      if (setvalueP) {
        self.classMarkedP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.classMarkedP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLASS_TAXONOMY_NODE) {
      if (setvalueP) {
        self.classTaxonomyNode = ((TaxonomyNode)(value));
      }
      else {
        value = self.classTaxonomyNode;
      }
    }
    else {
      if (slotname == Stella.SYM_STELLA_CLASS_DOCUMENTATION) {
        slotname = Stella.SYM_STELLA_DOCUMENTATION;
      }
      else if (slotname == Stella.SYM_STELLA_CLASS_PRINT_FORM) {
        slotname = Stella.SYM_STELLA_PRINT_FORM;
      }
      else {
      }
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, slotname, value, null);
      }
      else {
        value = self.dynamicSlots.lookup(slotname);
      }
    }
    return (value);
  }

  public List classSynonyms() {
    { Stella_Class self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_SYNONYMS, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public List classKey() {
    { Stella_Class self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_KEY, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public List classDestructorDemons() {
    { Stella_Class self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_DESTRUCTOR_DEMONS, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public List classGuardDestructorDemons() {
    { Stella_Class self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_GUARD_DESTRUCTOR_DEMONS, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public List classConstructorDemons() {
    { Stella_Class self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_CONSTRUCTOR_DEMONS, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public List classGuardConstructorDemons() {
    { Stella_Class self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_GUARD_CONSTRUCTOR_DEMONS, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public List classRequiredSlotNames() {
    { Stella_Class self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_REQUIRED_SLOT_NAMES, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public List classParameters() {
    { Stella_Class self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_PARAMETERS, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public Keyword classRecycleMethod() {
    { Stella_Class self = this;

      { Keyword answer = ((Keyword)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_RECYCLE_METHOD, null)));

        if (answer == null) {
          return (Stella.KWD_NONE);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public List classClStructSlots() {
    { Stella_Class self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_CL_STRUCT_SLOTS, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public int classArity() {
    { Stella_Class self = this;

      return (Stella.$HARDWIRED_CLASS_ARITY_ON_CLASS$);
    }
  }

  public String javaNativeType() {
    { Stella_Class self = this;

      { String nativetype = ((StringWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_JAVA_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue;

        if (nativetype != null) {
          return (Stella.substituteTemplateVariablesInString(nativetype, Stella.$JAVA_STELLA_PACKAGE_MAPPING$));
        }
        else {
          return (null);
        }
      }
    }
  }

  public String idlNativeType() {
    { Stella_Class self = this;

      return (((StringWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_CPP_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue);
    }
  }

  public String cppNativeType() {
    { Stella_Class self = this;

      return (((StringWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_CPP_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue);
    }
  }

  public String clNativeType() {
    { Stella_Class self = this;

      return (((StringWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_CL_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue);
    }
  }

  /** Return the nearest class extension that records instances
   * of the class <code>self</code>.
   * @return ClassExtension
   */
  public ClassExtension extension() {
    { Stella_Class self = this;

      { Stella_Class cursor = self;
        ClassExtension value = ((ClassExtension)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_CLASS_EXTENSION, null)));

        for (;;) {
          if (value != null) {
            return (value);
          }
          cursor = ((Stella_Class)(cursor.classAllSuperClasses.value));
          if (cursor != null) {
            value = ((ClassExtension)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_CLASS_EXTENSION, null)));
          }
          else {
            return (null);
          }
        }
      }
    }
  }

  /** Return an initial value for the class <code>self</code>.
   * @return Stella_Object
   */
  public Stella_Object initialValue() {
    { Stella_Class self = this;

      { Stella_Class cursor = self;
        Stella_Object value = KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_CLASS_INITIAL_VALUE, null);

        for (;;) {
          if (value != null) {
            return (value);
          }
          cursor = ((Stella_Class)(cursor.classAllSuperClasses.value));
          if (cursor != null) {
            value = KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_CLASS_INITIAL_VALUE, null);
          }
          else {
            return (null);
          }
        }
      }
    }
  }

  /** Returns the list of parameters names of <code>self</code>.
   * @return List
   */
  public List parameters() {
    { Stella_Class self = this;

      { Stella_Class cursor = self;
        List value = ((List)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_CLASS_PARAMETERS, null)));

        for (;;) {
          if (value != null) {
            return (value);
          }
          cursor = ((Stella_Class)(cursor.classAllSuperClasses.value));
          if (cursor != null) {
            value = ((List)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_CLASS_PARAMETERS, null)));
          }
          else {
            return (Stella.NIL_LIST);
          }
        }
      }
    }
  }

  /** Returns a list of names of required slots for <code>self</code>.
   * @return List
   */
  public List requiredSlots() {
    { Stella_Class self = this;

      return (self.classRequiredSlotNames());
    }
  }

  public Symbol destructor() {
    { Stella_Class self = this;

      return (((Symbol)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_DESTRUCTOR, null))));
    }
  }

  public Symbol terminator() {
    { Stella_Class self = this;

      { Stella_Class cursor = self;
        Symbol value = ((Symbol)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_CLASS_TERMINATOR, null)));

        for (;;) {
          if (value != null) {
            return (value);
          }
          cursor = ((Stella_Class)(cursor.classAllSuperClasses.value));
          if (cursor != null) {
            value = ((Symbol)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_CLASS_TERMINATOR, null)));
          }
          else {
            return (null);
          }
        }
      }
    }
  }

  public Symbol initializer() {
    { Stella_Class self = this;

      { Stella_Class cursor = self;
        Symbol value = ((Symbol)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_CLASS_INITIALIZER, null)));

        for (;;) {
          if (value != null) {
            return (value);
          }
          cursor = ((Stella_Class)(cursor.classAllSuperClasses.value));
          if (cursor != null) {
            value = ((Symbol)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_CLASS_INITIALIZER, null)));
          }
          else {
            return (null);
          }
        }
      }
    }
  }

  public Symbol creator() {
    { Stella_Class self = this;

      return (((Symbol)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLASS_CREATOR, null))));
    }
  }

  public boolean activeP() {
    { Stella_Class self = this;

      return (((((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_STORED_ACTIVEp, null))) != null) &&
          BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_STORED_ACTIVEp, null))))) ||
          Surrogate.subtypeOfP(self.classType, Stella.SGT_STELLA_ACTIVE_OBJECT));
    }
  }

  public boolean publicP() {
    { Stella_Class self = this;

      return (self.classPublicP);
    }
  }

  public int arity() {
    { Stella_Class self = this;

      return (1);
    }
  }

  public Module homeModule() {
    { Stella_Class self = this;

      return (((Module)(self.classType.homeContext)));
    }
  }

  public String name() {
    { Stella_Class self = this;

      return (self.classType.symbolName);
    }
  }

  public Surrogate primaryType() {
    { Stella_Class self = this;

      return (Stella.SGT_STELLA_CLASS);
    }
  }

}

