//  -*- Mode: Java -*-
//
// StorageSlot.java

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

public class StorageSlot extends Slot {
    public boolean slotRequiredP;
    public boolean slotComponentP;
    public boolean slotReadOnlyP;
    public boolean slotHardwiredP;
    public boolean slotContextSensitiveP;

  public static StorageSlot newStorageSlot() {
    { StorageSlot self = null;

      self = new StorageSlot();
      self.dynamicSlots = KeyValueList.newKeyValueList();
      self.abstractP = false;
      self.slotDirectEquivalent = null;
      self.slotMarkedP = false;
      self.slotExternalP = false;
      self.slotRenamedP = false;
      self.slotPublicP = true;
      self.slotSlotref = null;
      self.slotBaseType = null;
      self.slotOwner = null;
      self.slotName = null;
      self.slotContextSensitiveP = false;
      self.slotHardwiredP = false;
      self.slotReadOnlyP = false;
      self.slotComponentP = false;
      self.slotRequiredP = false;
      return (self);
    }
  }

  public static Cons idlYieldStaticMemberAllocationTree(StorageSlot slot, Stella_Class renamed_Class) {
    { Symbol slotname = slot.slotName;
      Stella_Object initialvalueform = slot.initially();
      Cons allocationform = Stella.NIL;
      Slot mostgeneralslot = null;

      if (!(initialvalueform != null)) {
        initialvalueform = Stella.idlYieldInitialNullValue();
      }
      mostgeneralslot = slot;
      loop000 : for (;;) {
        if (mostgeneralslot.slotDirectEquivalent != null) {
          mostgeneralslot = mostgeneralslot.slotDirectEquivalent;
        }
        else {
          break loop000;
        }
      }
      return (Cons.list$(Cons.cons(allocationform.concatenate(Cons.cons(StandardObject.idlTranslateTypeSpec(mostgeneralslot.computeReturnTypeSpec(renamed_Class.classType)), Stella.NIL), Stella.NIL), Cons.cons(Symbol.idlTranslateName(slotname), Cons.cons(Cons.cons(initialvalueform, Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons idlYieldParameterizedAttributeTree(StorageSlot slot, Stella_Class renamed_Class) {
    { Symbol slotname = Symbol.trueSlotName(slot.slotName, renamed_Class.classType);
      Stella_Object initialvalueform = slot.initially();
      Keyword allocation = slot.allocation();
      Cons allocationform = Stella.NIL;

      if (!(initialvalueform != null)) {
        initialvalueform = Stella.idlYieldInitialNullValue();
      }
      if (allocation == Stella.KWD_EMBEDDED) {
        allocationform = Stella.NIL;
      }
      else if (allocation == Stella.KWD_INSTANCE) {
        allocationform = Stella.NIL;
      }
      else if (allocation == Stella.KWD_CLASS) {
        allocationform = Cons.consList(Cons.cons(StringWrapper.wrapString("static"), Stella.NIL));
      }
      else {
        allocationform = Stella.NIL;
      }
      return (Cons.list$(Cons.cons(allocationform.concatenate(Cons.cons(Symbol.idlTranslateClassParameterName(StorageSlot.getSlotClassParameterName(slot)), Stella.NIL), Stella.NIL), Cons.cons(Symbol.idlTranslateName(slotname), Cons.cons(Cons.cons(initialvalueform, Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons idlYieldAttributeTree(StorageSlot slot, Stella_Class renamed_Class) {
    { Symbol slotname = Symbol.trueSlotName(slot.slotName, renamed_Class.classType);
      Stella_Object initialvalueform = slot.initially();
      Cons facetform = Stella.NIL;
      Slot mostgeneralslot = null;

      if (Stella_Class.idlClassCategory(renamed_Class) == Stella.SYM_STELLA_IDL_INTERFACE) {
        if (slot.slotReadOnlyP) {
          facetform = Cons.list$(Cons.cons(StringWrapper.wrapString("readonly"), Cons.cons(StringWrapper.wrapString("attribute"), Cons.cons(Stella.NIL, Stella.NIL))));
        }
        else {
          facetform = Cons.cons(StringWrapper.wrapString("attribute"), Stella.NIL);
        }
      }
      if (!(initialvalueform != null)) {
        initialvalueform = Stella.idlYieldInitialNullValue();
      }
      mostgeneralslot = slot;
      return (Cons.list$(Cons.cons(facetform.concatenate(Cons.cons(StandardObject.idlTranslateTypeSpec(mostgeneralslot.computeReturnTypeSpec(renamed_Class.classType)), Stella.NIL), Stella.NIL), Cons.cons(Symbol.idlTranslateName(slotname), Cons.cons(Cons.cons(initialvalueform, Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons javaYieldInstanceVarTree(StorageSlot slot, Stella_Class renamed_Class) {
    { Symbol slotname = Symbol.trueSlotName(slot.slotName, renamed_Class.classType);
      StandardObject slottype = (slot.slotContextSensitiveP ? Stella.SGT_STELLA_OBJECT : ((StandardObject)(slot.computeReturnTypeSpec(renamed_Class.classType))));
      Keyword allocation = slot.allocation();
      Cons allocationform = null;
      Cons accessform = null;
      String documentation = ((StringWrapper)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue;
      Cons documentationform = Stella.NIL;

      if (slot.slotPublicP) {
        accessform = Cons.cons(StringWrapper.wrapString("public"), Stella.NIL);
      }
      else {
        accessform = Cons.cons(StringWrapper.wrapString("protected"), Stella.NIL);
      }
      if (allocation == Stella.KWD_EMBEDDED) {
        allocationform = Stella.NIL;
      }
      else if (allocation == Stella.KWD_INSTANCE) {
        allocationform = Stella.NIL;
      }
      else if (allocation == Stella.KWD_CLASS) {
        allocationform = Cons.cons(StringWrapper.wrapString("static"), Stella.NIL);
      }
      else {
        allocationform = Stella.NIL;
      }
      if (documentation != null) {
        documentationform = Cons.cons(StringWrapper.wrapString(documentation), Stella.NIL);
      }
      return (Cons.list$(Cons.cons(accessform.concatenate(allocationform.concatenate(Cons.cons(StandardObject.javaTranslateTypeSpec(slottype), Stella.NIL), Stella.NIL), Stella.NIL), Cons.cons(Symbol.javaTranslateName(slotname), Cons.cons(documentationform.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))));
    }
  }

  public static Symbol getSlotClassParameterName(StorageSlot slot) {
    return (((AnchoredTypeSpecifier)(((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null))))).specifierParameterName);
  }

  public static boolean slotHasClassParameterTypeP(StorageSlot slot, Stella_Class renamed_Class) {
    return ((((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null))) != null) &&
        (Stella_Object.isaP(((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null))), Stella.SGT_STELLA_ANCHORED_TYPE_SPECIFIER) &&
         (slot.computeReturnTypeSpec(renamed_Class.classType) == Stella.SGT_STELLA_UNKNOWN)));
  }

  public static Cons cppYieldStaticMemberAllocationTree(StorageSlot slot, Stella_Class renamed_Class) {
    { Symbol slotname = slot.slotName;
      Cons allocationform = Stella.NIL;
      Slot mostgeneralslot = null;

      mostgeneralslot = slot;
      loop000 : for (;;) {
        if (mostgeneralslot.slotDirectEquivalent != null) {
          mostgeneralslot = mostgeneralslot.slotDirectEquivalent;
        }
        else {
          break loop000;
        }
      }
      return (Cons.list$(Cons.cons(allocationform.concatenate(Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(mostgeneralslot.computeReturnTypeSpec(renamed_Class.classType)), Stella.NIL), Stella.NIL), Cons.cons(Symbol.cppTranslateName(slotname), Cons.cons(Cons.cons(Stella.SYM_STELLA_NULL, Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons cppYieldParameterizedMemberVarTree(StorageSlot slot, Stella_Class renamed_Class) {
    { Symbol slotname = Symbol.trueSlotName(slot.slotName, renamed_Class.classType);
      Keyword allocation = slot.allocation();
      Cons allocationform = Stella.NIL;

      if (allocation == Stella.KWD_EMBEDDED) {
        allocationform = Stella.NIL;
      }
      else if (allocation == Stella.KWD_INSTANCE) {
        allocationform = Stella.NIL;
      }
      else if (allocation == Stella.KWD_CLASS) {
        allocationform = Cons.consList(Cons.cons(StringWrapper.wrapString("static"), Stella.NIL));
      }
      else {
        allocationform = Stella.NIL;
      }
      return (Cons.list$(Cons.cons(allocationform.concatenate(Cons.cons(Symbol.cppTranslateClassParameterName(StorageSlot.getSlotClassParameterName(slot)), Stella.NIL), Stella.NIL), Cons.cons(Symbol.cppTranslateName(slotname), Cons.cons(Cons.cons(Stella.SYM_STELLA_NULL, Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons cppYieldMemberVarTree(StorageSlot slot, Stella_Class renamed_Class) {
    { Symbol slotname = Symbol.trueSlotName(slot.slotName, renamed_Class.classType);
      StandardObject slottype = (slot.slotContextSensitiveP ? Stella.SGT_STELLA_OBJECT : ((StandardObject)(slot.computeReturnTypeSpec(renamed_Class.classType))));
      Keyword allocation = slot.allocation();
      Cons allocationform = Stella.NIL;
      String documentation = ((StringWrapper)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue;
      Cons documentationform = Stella.NIL;

      if (allocation == Stella.KWD_EMBEDDED) {
        allocationform = Stella.NIL;
      }
      else if (allocation == Stella.KWD_INSTANCE) {
        allocationform = Stella.NIL;
      }
      else if (allocation == Stella.KWD_CLASS) {
        allocationform = Cons.consList(Cons.cons(StringWrapper.wrapString("static"), Stella.NIL));
      }
      else {
        allocationform = Stella.NIL;
      }
      if (documentation != null) {
        documentationform = Cons.cons(StringWrapper.wrapString(documentation), Stella.NIL);
      }
      return (Cons.list$(Cons.cons(allocationform.concatenate(Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(slottype), Stella.NIL), Stella.NIL), Cons.cons(Symbol.cppTranslateName(slotname), Cons.cons(documentationform.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))));
    }
  }

  public void describeObject(OutputStream stream, Keyword mode) {
    { StorageSlot self = this;

      if (mode == Stella.KWD_SOURCE) {
        stream.nativeStream.println("TERSE mode:");
        self.describeObject(stream, Stella.KWD_TERSE);
      }
      else if (mode == Stella.KWD_TERSE) {
        Stella_Object.describeTersely(self, stream);
      }
      else if (mode == Stella.KWD_VERBOSE) {
        Cons.prettyPrintDefinitionTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT, Cons.cons(self.slotName, Cons.cons(Cons.list$(Cons.cons(Stella.KWD_OWNER, Cons.cons(StringWrapper.wrapString(self.slotOwner.symbolName), Cons.cons(Cons.list$(Cons.cons(Stella.KWD_TYPE, Cons.cons(self.slotBaseType, Cons.cons(Cons.list$(Cons.cons(Stella.KWD_INITIALLY, Cons.cons(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_INITIAL_VALUE, null), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Stella.NIL)))), Stella.NIL)))), stream);
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
    { StorageSlot self = this;

      stream.nativeStream.print("(" + Native.stringDowncase(self.slotName.symbolName) + " :type ");
      stream.nativeStream.print((((((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null))) != null) ? Native.stringify(StandardObject.yieldTypeSpecTree(((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null))))) : Native.stringify(StandardObject.yieldTypeSpecTree(self.slotBaseType)))));
      StorageSlot.prettyPrintSlotOptions(self, stream);
      stream.nativeStream.print(")");
    }
  }

  public static void prettyPrintSlotOptions(StorageSlot slot, OutputStream stream) {
    { Stella_Object slotvalue = null;

      { StorageSlot optionslot = null;
        Cons iter000 = ((Cons)(Stella.$SLOTOPTIONSLOTS$.get()));

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          optionslot = ((StorageSlot)(iter000.value));
          slotvalue = StandardObject.readSlotValue(slot, optionslot);
          if (slotvalue == null) {
            continue loop000;
          }
          if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(slotvalue), Stella.SGT_STELLA_LITERAL_WRAPPER)) {
            { LiteralWrapper slotvalue000 = ((LiteralWrapper)(slotvalue));

              if (!Stella_Object.literalEqlP(KeyValueList.dynamicSlotValue(optionslot.dynamicSlots, Stella.SYM_STELLA_SLOT_INITIAL_VALUE, null), slotvalue000)) {
                stream.nativeStream.print(" :" + Native.stringDowncase(((Keyword)(KeyValueList.dynamicSlotValue(optionslot.dynamicSlots, Stella.SYM_STELLA_SLOT_OPTION_KEYWORD, null))).symbolName) + " ");
                Stella_Object.prettyPrintLiteral(slotvalue000, stream);
              }
            }
          }
          else {
          }
        }
      }
    }
  }

  public static Cons yieldActiveSlotWriterBody(StorageSlot slot) {
    { Symbol slotname = slot.slotName;
      Symbol wrappingfunction = ((slot.slotBaseType == Stella.SGT_STELLA_BOOLEAN) ? Stella.SYM_STELLA_WRAP_BOOLEAN : Stella.SYM_STELLA_WRAP_LITERAL);

      if (slot.collectionValuedP()) {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CANT_OVERWRITE_ACTIVE_COLLECTION_SLOT, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_BQUOTE, Cons.cons(slotname, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(slot.slotName, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))));
      }
      else if (Surrogate.subtypeOfP(slot.type(), Stella.SGT_STELLA_LITERAL)) {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_GET_SLOT, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_BQUOTE, Cons.cons(slotname, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OLDVALUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(slotname, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NOT, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_EQLp, Cons.cons(Stella.SYM_STELLA_OLDVALUE, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CHECK_FOR_SLOT_DEMONSp, Cons.cons(Stella.SYM_STELLA_SLOT, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WRAPPEDOLDVALUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CHOOSE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(Stella.SYM_STELLA_OLDVALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.cons(wrappingfunction, Cons.cons(Stella.SYM_STELLA_OLDVALUE, Stella.NIL)), Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WRAPPEDNEWVALUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CHOOSE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.cons(wrappingfunction, Cons.cons(Stella.SYM_STELLA_VALUE, Stella.NIL)), Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RUN_SLOT_GUARD_DEMONSp, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.SYM_STELLA_SLOT, Cons.cons(Stella.SYM_STELLA_WRAPPEDOLDVALUE, Cons.cons(Stella.SYM_STELLA_WRAPPEDNEWVALUE, Cons.cons(Stella.NIL, Stella.NIL))))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(slotname, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RUN_SLOT_DEMONS, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.SYM_STELLA_SLOT, Cons.cons(Stella.SYM_STELLA_WRAPPEDOLDVALUE, Cons.cons(Stella.SYM_STELLA_WRAPPEDNEWVALUE, Cons.cons(Stella.NIL, Stella.NIL))))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(Stella.SYM_STELLA_WRAPPEDOLDVALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_FREE, Cons.cons(Stella.SYM_STELLA_WRAPPEDOLDVALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(Stella.SYM_STELLA_WRAPPEDNEWVALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_FREE, Cons.cons(Stella.SYM_STELLA_WRAPPEDNEWVALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_OLDVALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(slotname, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))));
      }
      else {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_GET_SLOT, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_BQUOTE, Cons.cons(slotname, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OLDVALUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(slotname, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_AND, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NOT, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_EQp, Cons.cons(Stella.SYM_STELLA_OLDVALUE, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RUN_SLOT_GUARD_DEMONSp, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.SYM_STELLA_SLOT, Cons.cons(Stella.SYM_STELLA_OLDVALUE, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL))))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(slotname, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RUN_SLOT_DEMONS, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.SYM_STELLA_SLOT, Cons.cons(Stella.SYM_STELLA_OLDVALUE, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL))))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_OLDVALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))));
      }
    }
  }

  public static Cons yieldActiveSlotReaderBody(StorageSlot slot, Stella_Object defaultexpression) {
    { Symbol slotname = slot.slotName;

      if (!slot.collectionValuedP()) {
        return (StorageSlot.wrapWithDefaultValueAndReturnCode(slot, defaultexpression));
      }
      else {
        {
          if (defaultexpression != null) {
            { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" Can't define a default value for the active collection-valued slot named.`" + slot.slotName + "'Ignoring the default value..");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
              }
            }
          }
          return (Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(slotname, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NEW, Cons.cons(Surrogate.typeToSymbol(slot.type()), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OWNER_INSTANCE, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ACTIVE_SLOT, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_GET_SLOT, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_BQUOTE, Cons.cons(slot.slotName, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(slotname, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))))))));
        }
      }
    }
  }

  public static boolean checkForSlotDemonsP(StorageSlot slot) {
    return ((Stella.$ALL_SLOTS_DEMONS$ != null) ||
        ((Stella.$ALL_SLOTS_GUARD_DEMONS$ != null) ||
         ((slot.slotGuardDemons() != null) ||
          (slot.slotDemons() != null))));
  }

  public static Cons yieldStandardDynamicSlotValueSetterTree(StorageSlot slot, Stella_Object objectref, Stella_Object valueref, StandardObject returntype) {
    { Symbol slotname = StorageSlot.canonicalSlot(slot).slotName;
      boolean literalslotP = Slot.slotValueIsBareLiteralP(slot);
      Cons settertree = null;

      if (literalslotP) {
        settertree = Cons.list$(Cons.cons(Stella.SYM_STELLA_SET_DYNAMIC_SLOT_VALUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DYNAMIC_SLOTS, Cons.cons(objectref, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_BQUOTE, Cons.cons(slotname, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(valueref, Cons.cons(Cons.cons(Surrogate.lookupLiteralTypeInfo(slot.type(), Stella.KWD_NULL_WRAPPER), Stella.NIL), Stella.NIL))))));
      }
      else {
        settertree = Cons.list$(Cons.cons(Stella.SYM_STELLA_SET_DYNAMIC_SLOT_VALUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DYNAMIC_SLOTS, Cons.cons(objectref, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_BQUOTE, Cons.cons(slotname, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(valueref, Cons.cons(Cons.cons(Stella.SYM_STELLA_NULL, Stella.NIL), Stella.NIL))))));
      }
      if (Stella.walkingExpressionP()) {
        if (literalslotP) {
          settertree = Cons.list$(Cons.cons(Stella.SYM_STELLA_WRAPPER_VALUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SAFE_CAST, Cons.cons(settertree, Cons.cons(Cons.cons(Surrogate.typeToSymbol(slot.type().typeToWrappedType()), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))));
        }
        else {
          settertree = Cons.yieldDownCastTree(Cons.walkAConsTree(settertree, new Object[1]), returntype);
        }
      }
      return (settertree);
    }
  }

  public static Cons yieldStandardDynamicSlotValueTree(StorageSlot slot, Stella_Object objectref, StandardObject returntype) {
    { Symbol slotname = StorageSlot.canonicalSlot(slot).slotName;

      if (Slot.slotValueIsBareLiteralP(slot)) {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_WRAPPER_VALUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SAFE_CAST, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DYNAMIC_SLOT_VALUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DYNAMIC_SLOTS, Cons.cons(objectref, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_QUOTE, Cons.cons(slotname, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Surrogate.lookupLiteralTypeInfo(slot.type(), Stella.KWD_NULL_WRAPPER), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Surrogate.typeToSymbol(slot.type().typeToWrappedType()), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))));
      }
      else {
        return (Cons.yieldDownCastTree(Cons.walkAConsTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_DYNAMIC_SLOT_VALUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DYNAMIC_SLOTS, Cons.cons(objectref, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_QUOTE, Cons.cons(slotname, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL)))))), new Object[1]), returntype));
      }
    }
  }

  public static boolean standardDynamicSlotAccessP(StorageSlot slot) {
    return ((!slot.activeP()) &&
        ((slot.allocation() == Stella.KWD_DYNAMIC) &&
         ((!Slot.slotValueIsBareLiteralP(slot)) ||
          (Surrogate.lookupLiteralTypeInfo(slot.slotBaseType, Stella.KWD_NULL_WRAPPER) != null))));
  }

  public static Cons yieldStructSlotTree(StorageSlot slot) {
    { Stella_Object cltype = StandardObject.lookupClTypeFromStellaType(slot.slotBaseType);

      if (cltype != null) {
        return (Cons.cons(Symbol.clTranslateLocalSymbol(slot.slotName), Cons.cons(Stella_Object.clTranslateATree(StandardObject.typeToWalkedNullValueTree(slot.typeSpecifier(), slot.slotBaseType)), Cons.cons(Stella_Object.clConditionalizeTypeDeclarationTree(Stella.KWD_TYPE), Cons.cons(Stella_Object.clConditionalizeTypeDeclarationTree(cltype), Stella.NIL)))));
      }
      else {
        return (Cons.cons(Symbol.clTranslateLocalSymbol(slot.slotName), Cons.cons(Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_NULL), Stella.NIL)));
      }
    }
  }

  public static Cons yieldClosSlotTree(StorageSlot slot) {
    { Symbol slotname = Symbol.trueSlotName(slot.slotName, slot.slotOwner);
      Keyword allocation = slot.allocation();
      Cons allocationform = Stella.NIL;
      String documentation = ((StringWrapper)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_DOCUMENTATION, Stella.NULL_STRING_WRAPPER))).wrapperValue;
      Cons documentationform = Stella.NIL;

      if (allocation == Stella.KWD_EMBEDDED) {
        allocation = Stella.KWD_INSTANCE;
      }
      else {
      }
      if (allocation != null) {
        allocationform = Cons.list$(Cons.cons(Stella.KWD_ALLOCATION, Cons.cons(allocation, Cons.cons(Stella.NIL, Stella.NIL))));
      }
      if (documentation != null) {
        documentationform = Cons.list$(Cons.cons(Stella.KWD_DOCUMENTATION, Cons.cons(StringWrapper.wrapString(documentation), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      return (Cons.cons(Symbol.clTranslateGlobalSymbol(slotname), StorageSlot.yieldClosSlotTypeTree(slot).concatenate(documentationform.concatenate(allocationform.concatenate(Cons.list$(Cons.cons(Stella.KWD_ACCESSOR, Cons.cons(Symbol.yieldClosSlotAccessorName(slotname), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL), Stella.NIL)));
    }
  }

  public static Cons yieldClosSlotTypeTree(StorageSlot slot) {
    { Stella_Object cltype = StandardObject.lookupClTypeFromStellaType(slot.slotBaseType);

      if (cltype != null) {
        return (Cons.cons(Stella_Object.clConditionalizeTypeDeclarationTree(Stella.KWD_TYPE), Cons.cons(Stella_Object.clConditionalizeTypeDeclarationTree(cltype), Cons.list$(Cons.cons(Stella.KWD_INITFORM, Cons.cons(Stella_Object.clTranslateATree(StandardObject.typeToWalkedNullValueTree(slot.typeSpecifier(), slot.slotBaseType)), Cons.cons(Stella.NIL, Stella.NIL)))))));
      }
      else {
        return (Stella.NIL);
      }
    }
  }

  public static void createAccessorUnitsForMixinSlot(StorageSlot slot, Stella_Class renamed_Class) {
    if (StorageSlot.nativeSlotP(slot) &&
        (Slot.nativeSlotHome(slot, renamed_Class) == renamed_Class)) {
      if (Stella.$MIXIN_IMPLEMENTATION_STYLE$ == Stella.KWD_FIRST_CLASS_WITH_TYPECASE) {
        Cons.walkAuxiliaryTree(StorageSlot.yieldMixinSlotReaderTree(slot));
        Cons.walkAuxiliaryTree(StorageSlot.yieldMixinSlotWriterTree(slot));
      }
      else {
        StorageSlot.createAccessorUnitsForSlot(slot, ((Stella_Class)(Stella.SGT_STELLA_OBJECT.surrogateValue)), true, false);
      }
    }
    if (slot.slotHardwiredP) {
      { Cons readcode = null;
        Cons auxiliarycode = null;

        { Object [] caller_MV_returnarray = new Object[1];

          readcode = StorageSlot.yieldHardwiredSlotReaderBody(slot, caller_MV_returnarray);
          auxiliarycode = ((Cons)(caller_MV_returnarray[0]));
        }
        readcode = readcode;
        Cons.walkAuxiliaryTree(auxiliarycode);
      }
      StorageSlot.createAccessorUnitsForSlot(slot, ((Stella_Class)(Stella.SGT_STELLA_OBJECT.surrogateValue)), false, false);
    }
  }

  public static void createAccessorUnitsForSlot(StorageSlot slot, Stella_Class renamed_Class, boolean mixinaccessorsP, boolean signaturesonlyP) {
    { Cons methodtree = null;
      MethodSlot method = null;

      if (StorageSlot.systemDefinedSlotReaderP(slot)) {
        methodtree = StorageSlot.yieldSlotReaderTree(slot, renamed_Class);
        if (signaturesonlyP) {
          { Object old$Module$000 = Stella.$MODULE$.get();
            Object old$Context$000 = Stella.$CONTEXT$.get();

            try {
              Native.setSpecial(Stella.$MODULE$, slot.homeModule());
              Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
              method = Cons.defineMethodFromParseTree(methodtree);

            } finally {
              Stella.$CONTEXT$.set(old$Context$000);
              Stella.$MODULE$.set(old$Module$000);
            }
          }
        }
        else {
          method = ((MethodSlot)(Cons.helpWalkAuxiliaryTree(methodtree, true).theObject));
        }
        MethodSlot.registerAuxiliaryMethod(method, slot);
      }
      if (StorageSlot.systemDefinedSlotWriterP(slot)) {
        methodtree = StorageSlot.yieldSlotWriterTree(slot, renamed_Class);
        if (signaturesonlyP) {
          { Object old$Module$001 = Stella.$MODULE$.get();
            Object old$Context$001 = Stella.$CONTEXT$.get();

            try {
              Native.setSpecial(Stella.$MODULE$, slot.homeModule());
              Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
              method = Cons.defineMethodFromParseTree(methodtree);

            } finally {
              Stella.$CONTEXT$.set(old$Context$001);
              Stella.$MODULE$.set(old$Module$001);
            }
          }
        }
        else {
          method = ((MethodSlot)(Cons.helpWalkAuxiliaryTree(methodtree, true).theObject));
        }
        MethodSlot.registerAuxiliaryMethod(method, slot);
      }
      if (mixinaccessorsP &&
          (!slot.abstractP)) {
        methodtree = StorageSlot.yieldNativeSlotReaderTree(slot, renamed_Class);
        if (signaturesonlyP) {
          { Object old$Module$002 = Stella.$MODULE$.get();
            Object old$Context$002 = Stella.$CONTEXT$.get();

            try {
              Native.setSpecial(Stella.$MODULE$, slot.homeModule());
              Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
              method = Cons.defineMethodFromParseTree(methodtree);

            } finally {
              Stella.$CONTEXT$.set(old$Context$002);
              Stella.$MODULE$.set(old$Module$002);
            }
          }
        }
        else {
          method = ((MethodSlot)(Cons.helpWalkAuxiliaryTree(methodtree, true).theObject));
        }
        MethodSlot.registerAuxiliaryMethod(method, slot);
        if (!(slot.slotHardwiredP)) {
          methodtree = StorageSlot.yieldNativeSlotWriterTree(slot, renamed_Class);
          if (signaturesonlyP) {
            { Object old$Module$003 = Stella.$MODULE$.get();
              Object old$Context$003 = Stella.$CONTEXT$.get();

              try {
                Native.setSpecial(Stella.$MODULE$, slot.homeModule());
                Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
                method = Cons.defineMethodFromParseTree(methodtree);

              } finally {
                Stella.$CONTEXT$.set(old$Context$003);
                Stella.$MODULE$.set(old$Module$003);
              }
            }
          }
          else {
            method = ((MethodSlot)(Cons.helpWalkAuxiliaryTree(methodtree, true).theObject));
          }
          MethodSlot.registerAuxiliaryMethod(method, slot);
        }
      }
    }
  }

  public static Stella_Object yieldInitialValueExpression(StorageSlot slot) {
    if (slot.abstractP ||
        (slot.dynamicStorageP() ||
         (slot.slotHardwiredP ||
          (slot.allocation() == Stella.KWD_CLASS)))) {
      return (null);
    }
    { Stella_Object initialvalueexpression = slot.initially();

      if (initialvalueexpression != null) {
        return (Stella_Object.copyConsTree(initialvalueexpression));
      }
      if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
        if (slot.allocation() == Stella.KWD_EMBEDDED) {
          return (Cons.list$(Cons.cons(Stella.SYM_STELLA_ALLOCATE, Cons.cons(Surrogate.typeToSymbol(slot.type()), Cons.cons(Stella.NIL, Stella.NIL)))));
        }
      }
      else if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) ||
          ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ||
           ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE) ||
            (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_IDL)))) {
        if (slot.allocation() == Stella.KWD_EMBEDDED) {
          return (Cons.list$(Cons.cons(Stella.SYM_STELLA_ALLOCATE, Cons.cons(Surrogate.typeToSymbol(slot.type()), Cons.cons(Stella.NIL, Stella.NIL)))));
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      return (StandardObject.typeToWalkedNullValueTree(slot.typeSpecifier(), slot.type()));
    }
  }

  public Stella_Object finishWalkingCallSlotTree(Cons tree, StandardObject firstargtype, Object [] MV_returnarray) {
    { StorageSlot self = this;

      { Stella_Object objectref = tree.rest.value;
        StandardObject otype = self.computeReturnTypeSpec(firstargtype);

        if (self.reader() != null) {
          tree.firstSetter(self.reader());
          return (Cons.walkAConsTree(tree, MV_returnarray));
        }
        if (StorageSlot.systemDefinedSlotReaderP(self)) {
          { Stella_Object _return_temp = Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_CALL_METHOD, Cons.cons(self.slotOwner, Cons.cons(Cons.cons(self.slotName, Cons.cons(objectref, Stella.NIL)), Stella.NIL))));

            MV_returnarray[0] = otype;
            return (_return_temp);
          }
        }
        else {
          { Stella_Object _return_temp = StorageSlot.yieldSlotValueTree(self, objectref, firstargtype, otype, null, new Object[1]);

            MV_returnarray[0] = otype;
            return (_return_temp);
          }
        }
      }
    }
  }

  public static Cons yieldSlotValueSetterTree(StorageSlot slot, Stella_Object objectref, StandardObject objecttype, Stella_Object valueref, StandardObject returntype, Cons csoptions, Object [] MV_returnarray) {
    if (slot.slotContextSensitiveP) {
      return (StorageSlot.yieldContextSensitiveSlotValueSetterTree(slot, objectref, valueref, returntype, csoptions, MV_returnarray));
    }
    else {
      if (slot.dynamicStorageP()) {
        { Cons _return_temp = ((Cons)(Stella_Object.walkWithoutTypeTree(StorageSlot.yieldDynamicSlotValueSetterTree(slot, objectref, valueref, returntype))));

          MV_returnarray[0] = returntype;
          return (_return_temp);
        }
      }
      else {
        { Cons _return_temp = StorageSlot.yieldNativeSlotValueSetterTree(slot, objectref, objecttype, valueref);

          MV_returnarray[0] = returntype;
          return (_return_temp);
        }
      }
    }
  }

  public static Cons yieldContextSensitiveSlotValueSetterTree(StorageSlot slot, Stella_Object objectref, Stella_Object valueref, StandardObject returntype, Cons csoptions, Object [] MV_returnarray) {
    { boolean contextsensitiveP = !((csoptions != null) &&
          (Cons.searchPlist(csoptions, Stella.KWD_CONTEXT_SENSITIVEp) == Stella.SYM_STELLA_FALSE));
      Symbol copytochildren = (((csoptions != null) &&
          (Cons.searchPlist(csoptions, Stella.KWD_COPY_TO_CHILDRENp) == Stella.SYM_STELLA_TRUE)) ? Stella.SYM_STELLA_TRUE : Stella.SYM_STELLA_FALSE);
      Surrogate realbasetype = slot.slotBaseType;
      CompoundTypeSpecifier realtypespec = ((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null)));
      Symbol objectvar = null;
      Symbol valuevar = null;
      Symbol oldvaluevar = null;
      Symbol newvaluevar = null;
      Cons oldvaluetree = null;
      Cons setnewvaluetree = null;

      slot.slotBaseType = Stella.SGT_STELLA_OBJECT;
      if (realtypespec != null) {
        KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null, null);
      }
      slot.slotContextSensitiveP = false;
      if (contextsensitiveP) {
        objectvar = Stella.localGensym("OBJECT");
        valuevar = Stella.localGensym("VALUE");
        oldvaluevar = Stella.localGensym("OLD-VALUE");
        newvaluevar = Stella.localGensym("NEW-VALUE");
        Symbol.pushVariableBinding(objectvar, slot.slotOwner);
        Symbol.pushVariableBinding(newvaluevar, Stella.SGT_STELLA_OBJECT);
        oldvaluetree = Stella_Object.sysTree(Stella_Object.walkWithoutTypeTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons(objectvar, Cons.cons(Cons.cons(slot.slotName, Stella.NIL), Stella.NIL))))), Stella.SGT_STELLA_OBJECT, new Object[1]);
        setnewvaluetree = Stella_Object.sysTree(Stella_Object.walkWithoutTypeTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons(objectvar, Cons.cons(Cons.cons(slot.slotName, Stella.NIL), Stella.NIL)))), Cons.cons(newvaluevar, Cons.cons(Stella.NIL, Stella.NIL)))))), Stella.SGT_STELLA_OBJECT, new Object[1]);
      }
      else {
        setnewvaluetree = Stella_Object.sysTree(Stella_Object.walkWithoutTypeTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons(objectref, Cons.cons(Cons.cons(slot.slotName, Stella.NIL), Stella.NIL)))), Cons.cons(valueref, Cons.cons(Stella.NIL, Stella.NIL)))))), Stella.SGT_STELLA_OBJECT, new Object[1]);
      }
      slot.slotBaseType = realbasetype;
      if (realtypespec != null) {
        KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, realtypespec, null);
      }
      slot.slotContextSensitiveP = true;
      if (!contextsensitiveP) {
        { Cons _return_temp = setnewvaluetree;

          MV_returnarray[0] = Stella.SGT_STELLA_OBJECT;
          return (_return_temp);
        }
      }
      Stella.popVariableBinding();
      Stella.popVariableBinding();
      { Cons _return_temp = Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Cons.list$(Cons.cons(Cons.cons(objectvar, Cons.cons(objectref, Stella.NIL)), Cons.cons(Cons.cons(valuevar, Cons.cons(realbasetype, Cons.cons(valueref, Stella.NIL))), Cons.cons(Cons.cons(oldvaluevar, Cons.cons(oldvaluetree, Stella.NIL)), Cons.cons(Cons.cons(newvaluevar, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UPDATE_IN_CONTEXT, Cons.cons(oldvaluevar, Cons.cons(Cons.cons(valuevar, Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_HOME_CONTEXT, Cons.cons(objectvar, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(copytochildren, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL)))), Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NOT, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CS_VALUEp, Cons.cons(oldvaluevar, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(setnewvaluetree, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(valuevar, Cons.cons(Stella.NIL, Stella.NIL))))));

        MV_returnarray[0] = returntype;
        return (_return_temp);
      }
    }
  }

  public static Cons yieldNativeSlotValueSetterTree(StorageSlot slot, Stella_Object objectref, StandardObject objecttype, Stella_Object valueref) {
    slot = StorageSlot.canonicalSlot(slot);
    { boolean mixinslotP = ((Stella_Class)(slot.slotOwner.surrogateValue)).mixinP;
      Stella_Class objectclass = StandardObject.typeSpecToClass(objecttype);

      if (mixinslotP &&
          Stella.translateToSingleInheritanceLanguageP()) {
        if (objectclass.mixinP) {
          return (Stella_Object.sysTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_CALL_METHOD, Cons.cons(Stella.SGT_STELLA_OBJECT, Cons.cons(StorageSlot.yieldNativeSlotReaderName(slot), Cons.cons(Cons.cons(objectref, Cons.cons(valueref, Stella.NIL)), Stella.NIL))))), ((((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null))) != null) ? ((StandardObject)(((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null))))) : ((StandardObject)(slot.slotBaseType))), new Object[1]));
        }
      }
      if (slot.slotHardwiredP) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Can't set the value of the hardwired slot `" + slot.slotOwner + "'.`" + slot.slotName + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        return (Stella_Object.walkDontCallMeTree(null, slot.slotBaseType, new Object[1]));
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_SLOT_VALUE_SETTER, Cons.cons(objectclass.classType, Cons.cons(Cons.cons(slot.slotName, Cons.cons(objectref, Cons.cons(valueref, Stella.NIL))), Stella.NIL)))));
    }
  }

  public static Cons yieldSlotValueTree(StorageSlot slot, Stella_Object objectref, StandardObject objecttype, StandardObject returntype, Cons csoptions, Object [] MV_returnarray) {
    if (slot.slotContextSensitiveP) {
      return (StorageSlot.yieldContextSensitiveSlotValueTree(slot, objectref, returntype, csoptions, MV_returnarray));
    }
    else {
      if (slot.dynamicStorageP()) {
        { Cons _return_temp = ((Cons)(Stella_Object.walkWithoutTypeTree(StorageSlot.yieldDynamicSlotValueTree(slot, objectref, returntype))));

          MV_returnarray[0] = returntype;
          return (_return_temp);
        }
      }
      else {
        { Cons _return_temp = StorageSlot.yieldNativeSlotValueTree(slot, objectref, objecttype);

          MV_returnarray[0] = returntype;
          return (_return_temp);
        }
      }
    }
  }

  public static Cons yieldContextSensitiveSlotValueTree(StorageSlot slot, Stella_Object objectref, StandardObject returntype, Cons csoptions, Object [] MV_returnarray) {
    { boolean contextsensitiveP = !((csoptions != null) &&
          (Cons.searchPlist(csoptions, Stella.KWD_CONTEXT_SENSITIVEp) == Stella.SYM_STELLA_FALSE));
      Symbol dontinheritP = (((csoptions != null) &&
          (Cons.searchPlist(csoptions, Stella.KWD_DONT_INHERITp) == Stella.SYM_STELLA_TRUE)) ? Stella.SYM_STELLA_TRUE : Stella.SYM_STELLA_FALSE);
      Stella_Object objectrefcopy = objectref;
      boolean onceonlywrapperP = contextsensitiveP &&
          (!Stella_Object.sideEffectFreeExpressionP(objectref));
      boolean literalslotP = Slot.slotValueIsBareLiteralP(slot);
      Surrogate realbasetype = slot.slotBaseType;
      CompoundTypeSpecifier realtypespec = ((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null)));
      Stella_Object oldvaluetree = null;
      Symbol oldvalueref = Stella.localGensym("OLD-VALUE");
      Cons accesstree = null;

      if (onceonlywrapperP) {
        objectref = Stella.localGensym("OBJECT");
        Symbol.pushVariableBinding(((Symbol)(objectref)), slot.slotOwner);
      }
      else {
        objectref = Stella_Object.sysTree(Stella_Object.walkWithoutTypeTree(objectref), slot.slotOwner, new Object[1]);
      }
      slot.slotBaseType = Stella.SGT_STELLA_OBJECT;
      if (realtypespec != null) {
        KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null, null);
      }
      slot.slotContextSensitiveP = false;
      oldvaluetree = Stella_Object.sysTree(Stella_Object.walkWithoutTypeTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons((contextsensitiveP ? Stella_Object.copyConsTree(objectref) : objectref), Cons.cons(Cons.cons(slot.slotName, Stella.NIL), Stella.NIL))))), Stella.SGT_STELLA_OBJECT, new Object[1]);
      slot.slotBaseType = realbasetype;
      if (realtypespec != null) {
        KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, realtypespec, null);
      }
      slot.slotContextSensitiveP = true;
      if (!contextsensitiveP) {
        { Cons _return_temp = ((Cons)(oldvaluetree));

          MV_returnarray[0] = Stella.SGT_STELLA_OBJECT;
          return (_return_temp);
        }
      }
      if (onceonlywrapperP) {
        Stella.popVariableBinding();
      }
      accesstree = Cons.list$(Cons.cons(Stella.SYM_STELLA_SAFE_CAST, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ACCESS_IN_CONTEXT, Cons.cons((onceonlywrapperP ? oldvalueref : oldvaluetree), Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_HOME_CONTEXT, Cons.cons(objectref, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(dontinheritP, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Cons.cons(StandardObject.yieldTypeSpecTree((literalslotP ? slot.type().typeToWrappedType() : ((StandardObject)(returntype)))), Cons.cons(Stella.NIL, Stella.NIL)))));
      if (literalslotP) {
        accesstree = Cons.list$(Cons.cons(Stella.SYM_STELLA_WRAPPER_VALUE, Cons.cons(accesstree, Cons.cons(Stella.NIL, Stella.NIL))));
      }
      if (onceonlywrapperP) {
        { Cons _return_temp = Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Cons.list$(Cons.cons(Cons.cons(objectref, Cons.cons(objectrefcopy, Stella.NIL)), Cons.cons(Cons.cons(oldvalueref, Cons.cons(oldvaluetree, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(accesstree, Cons.cons(Stella.NIL, Stella.NIL)))));

          MV_returnarray[0] = returntype;
          return (_return_temp);
        }
      }
      else {
        { Cons _return_temp = ((Cons)(Stella_Object.walkWithoutTypeTree(accesstree)));

          MV_returnarray[0] = returntype;
          return (_return_temp);
        }
      }
    }
  }

  public static Cons yieldNativeSlotValueTree(StorageSlot slot, Stella_Object objectref, StandardObject objecttype) {
    slot = StorageSlot.canonicalSlot(slot);
    { boolean mixinslotP = ((Stella_Class)(slot.slotOwner.surrogateValue)).mixinP;
      Stella_Class objectclass = StandardObject.typeSpecToClass(objecttype);

      if (mixinslotP &&
          Stella.translateToSingleInheritanceLanguageP()) {
        if (objectclass.mixinP) {
          return (Stella_Object.sysTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_CALL_METHOD, Cons.cons(Stella.SGT_STELLA_OBJECT, Cons.cons(StorageSlot.yieldNativeSlotReaderName(slot), Cons.cons(Cons.cons(objectref, Stella.NIL), Stella.NIL))))), ((((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null))) != null) ? ((StandardObject)(((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null))))) : ((StandardObject)(slot.slotBaseType))), new Object[1]));
        }
      }
      if (slot.slotHardwiredP) {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_CALL_METHOD, Cons.cons(objectclass.classType, Cons.cons(Cons.cons(slot.slotName, Cons.cons(objectref, Stella.NIL)), Stella.NIL)))));
      }
      else {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_SLOT_VALUE, Cons.cons(objectclass.classType, Cons.cons(Cons.cons(slot.slotName, Cons.cons(objectref, Stella.NIL)), Stella.NIL)))));
      }
    }
  }

  public static Cons yieldDynamicSlotValueSetterTree(StorageSlot slot, Stella_Object objectref, Stella_Object valueref, StandardObject returntype) {
    { Symbol slotname = slot.slotName;

      if (StorageSlot.standardDynamicSlotAccessP(slot)) {
        return (StorageSlot.yieldStandardDynamicSlotValueSetterTree(slot, objectref, valueref, returntype));
      }
      { Keyword testValue000 = slot.allocation();

        if (testValue000 == Stella.KWD_DYNAMIC) {
          return (Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DYNAMICSLOTS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DYNAMIC_SLOTS, Cons.cons(objectref, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NEWVALUE, Cons.cons(valueref, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_FOUNDMATCHINGENTRYp, Cons.cons(Stella.SYM_STELLA_FALSE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_FOREACH, Cons.cons(Stella.SYM_STELLA_IT, Cons.cons(Stella.SYM_STELLA_ON, Cons.cons(Stella.SYM_STELLA_DYNAMICSLOTS, Cons.cons(Stella.SYM_STELLA_WHERE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_EQp, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_KEY, Cons.cons(Stella.SYM_STELLA_IT, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_BQUOTE, Cons.cons(slotname, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.SYM_STELLA_DO, Cons.cons((Slot.slotValueIsBareLiteralP(slot) ? Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OLDVALUE, Cons.cons(Surrogate.typeToSymbol(slot.type().typeToWrappedType()), Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.SYM_STELLA_IT, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WRAPPER_VALUE, Cons.cons(Stella.SYM_STELLA_OLDVALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_NEWVALUE, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))) : Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.SYM_STELLA_IT, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_NEWVALUE, Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_FOUNDMATCHINGENTRYp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Stella.NIL)))))))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_AND, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NOT, Cons.cons(Stella.SYM_STELLA_FOUNDMATCHINGENTRYp, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(Stella.SYM_STELLA_NEWVALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_KV_LIST, Cons.cons(Stella.SYM_STELLA_DYNAMICSLOTS, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_KV_CONS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_BQUOTE, Cons.cons(slotname, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons((Slot.slotValueIsBareLiteralP(slot) ? Cons.list$(Cons.cons(Stella.SYM_STELLA_WRAP_LITERAL, Cons.cons(Stella.SYM_STELLA_NEWVALUE, Cons.cons(Stella.NIL, Stella.NIL)))) : ((Stella_Object)(Stella.SYM_STELLA_NEWVALUE))), Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_KV_LIST, Cons.cons(Stella.SYM_STELLA_DYNAMICSLOTS, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.SYM_STELLA_NEWVALUE, Cons.cons(Stella.NIL, Stella.NIL))))))));
        }
        else if (testValue000 == Stella.KWD_BIT) {
          throw ((StellaException)(StellaException.newStellaException("Allocation :bit IS NOT YET IMPLEMENTED").fillInStackTrace()));
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

  public static Cons yieldDynamicSlotValueTree(StorageSlot slot, Stella_Object objectref, StandardObject returntype) {
    if (StorageSlot.standardDynamicSlotAccessP(slot)) {
      return (StorageSlot.yieldStandardDynamicSlotValueTree(slot, objectref, returntype));
    }
    { Keyword testValue000 = slot.allocation();

      if (testValue000 == Stella.KWD_DYNAMIC) {
        { Symbol answervar = Stella.localGensym("ANSWER");

          return (Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Cons.cons(Cons.cons(answervar, Cons.cons(returntype, Cons.cons(StandardObject.typeToWalkedNullValueTree(slot.typeSpecifier(), slot.type()), Stella.NIL))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_FOREACH, Cons.cons(Stella.SYM_STELLA_IT, Cons.cons(Stella.SYM_STELLA_ON, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DYNAMIC_SLOTS, Cons.cons(objectref, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_WHERE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_EQp, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_KEY, Cons.cons(Stella.SYM_STELLA_IT, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_BQUOTE, Cons.cons(slot.slotName, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.SYM_STELLA_DO, Cons.cons((Slot.slotValueIsBareLiteralP(slot) ? Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WRAPPEDVALUE, Cons.cons(slot.type().typeToWrappedType(), Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.SYM_STELLA_IT, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(answervar, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WRAPPER_VALUE, Cons.cons(Stella.SYM_STELLA_WRAPPEDVALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))) : Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(answervar, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.SYM_STELLA_IT, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL))))), Cons.cons(Cons.cons(Cons.cons(Stella.SYM_STELLA_BREAK, Stella.NIL), Stella.NIL), Stella.NIL)))))))))), Cons.cons(answervar, Cons.cons(Stella.NIL, Stella.NIL)))))));
        }
      }
      else if (testValue000 == Stella.KWD_BIT) {
        throw ((StellaException)(StellaException.newStellaException("Allocation :bit IS NOT YET IMPLEMENTED").fillInStackTrace()));
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static StandardObject computeRealSlotType(StorageSlot slot, StandardObject firstargtype, StandardObject returntype) {
    { StandardObject slottype = returntype;
      StorageSlot canonicalslot = StorageSlot.canonicalSlot(slot);
      Stella_Class nativeslothome = null;

      if (StorageSlot.nativeSlotP(canonicalslot)) {
        nativeslothome = Slot.nativeSlotHome(slot, StandardObject.typeSpecToClass(firstargtype));
      }
      if (nativeslothome != null) {
        slottype = StandardObject.typeSpecToBaseType(Stella_Class.lookupSlot(nativeslothome, canonicalslot.slotName).computeReturnTypeSpec(nativeslothome.classType));
      }
      else {
        slottype = StandardObject.typeSpecToBaseType(slot.computeReturnTypeSpec(StandardObject.typeSpecToBaseType(firstargtype)));
      }
      if (slottype == StandardObject.typeSpecToBaseType(returntype)) {
        slottype = returntype;
      }
      return (slottype);
    }
  }

  public static MethodSlot lookupOptionHandler(StorageSlot slot) {
    { Symbol handlername = ((Symbol)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_OPTION_HANDLER, null)));
      MethodSlot handler = null;

      if (handlername == null) {
        if (Stella.$DEFAULT_OPTION_HANDLER$ != null) {
          return (Stella.$DEFAULT_OPTION_HANDLER$);
        }
        else {
          return (Symbol.lookupFunction(Stella.SYM_STELLA_DEFAULT_OPTION_HANDLER));
        }
      }
      handler = Symbol.lookupFunction(handlername);
      if ((((Integer)(Stella.$SAFETY$.get())).intValue() >= 2) &&
          ((handler != null) &&
           ((!(handlername == Stella.SYM_STELLA_DEFAULT_OPTION_HANDLER)) &&
            (!handler.conformingSignaturesP(Stella.$DEFAULT_OPTION_HANDLER$))))) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("The signature of slot option handler `" + handlername + "' does not conform to that of 'default-option-handler'.");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      return (handler);
    }
  }

  public static Cons yieldNativeSlotWriterTree(StorageSlot slot, Stella_Class renamed_Class) {
    { Symbol writername = StorageSlot.yieldNativeSlotWriterName(slot);
      Stella_Object typetree = StorageSlot.yieldSlotTypeTree(slot);
      boolean slotvisibleP = Surrogate.subtypeOfP(renamed_Class.classType, slot.slotOwner);

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFMETHOD, Cons.cons(Cons.cons(writername, Cons.cons(typetree, Stella.NIL)), Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella_Class.classSymbol(renamed_Class), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella_Object.copyConsTree(typetree), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.KWD_AUXILIARYp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(((slotvisibleP ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(slot.slotName, Cons.cons(Cons.list$(Cons.cons(Stella.KWD_CONTEXT_SENSITIVEp, Cons.cons(Stella.SYM_STELLA_FALSE, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL))))), Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL) : Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IGNORE, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ERROR, Cons.cons(StringWrapper.wrapString("Slot '"), Cons.cons(StringWrapper.wrapString(slot.slotName.symbolName), Cons.cons(Cons.list$(Cons.cons(StringWrapper.wrapString("' does not exist on "), Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))))).concatenate(Stella.NIL, Stella.NIL), Stella.NIL))))))));
    }
  }

  public static Cons yieldNativeSlotReaderTree(StorageSlot slot, Stella_Class renamed_Class) {
    { Symbol readername = StorageSlot.yieldNativeSlotReaderName(slot);
      Stella_Object typetree = StorageSlot.yieldSlotTypeTree(slot);
      boolean slotvisibleP = Surrogate.subtypeOfP(renamed_Class.classType, slot.slotOwner);

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFMETHOD, Cons.cons(Cons.cons(readername, Cons.cons(typetree, Stella.NIL)), Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella_Class.classSymbol(renamed_Class), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Stella.KWD_AUXILIARYp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(((slotvisibleP ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(slot.slotName, Cons.cons(Cons.list$(Cons.cons(Stella.KWD_CONTEXT_SENSITIVEp, Cons.cons(Stella.SYM_STELLA_FALSE, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL) : Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ERROR, Cons.cons(StringWrapper.wrapString("Slot '"), Cons.cons(StringWrapper.wrapString(slot.slotName.symbolName), Cons.cons(Cons.list$(Cons.cons(StringWrapper.wrapString("' does not exist on "), Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))).concatenate(Stella.NIL, Stella.NIL), Stella.NIL))))))));
    }
  }

  public static Symbol yieldNativeSlotWriterName(StorageSlot slot) {
    return (Symbol.yieldSetterMethodName(StorageSlot.yieldNativeSlotReaderName(slot)));
  }

  public static Symbol yieldNativeSlotReaderName(StorageSlot slot) {
    { String baseName = slot.slotName.symbolName;
      String suffix = (Stella.allUpperCaseStringP(baseName) ? "-NATIVE-VALUE" : "-Native-Value");

      return (Symbol.internDerivedSymbol(slot.slotName, baseName + suffix));
    }
  }

  public static Cons yieldMixinSlotWriterTree(StorageSlot slot) {
    { Symbol writername = StorageSlot.yieldMixinSlotWriterName(slot);
      Stella_Object typetree = StorageSlot.yieldSlotTypeTree(slot);

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFUN, Cons.cons(Cons.cons(writername, Cons.cons(typetree, Stella.NIL)), Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.SYM_STELLA_OBJECT, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella_Object.copyConsTree(typetree), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.KWD_AUXILIARYp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TYPECASE, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Cons.cons(Stella_Class.yieldMixinClassUsersTree(((Stella_Class)(slot.slotOwner.surrogateValue))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.cons(slot.slotName, Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL)), Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OTHERWISE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))))))));
    }
  }

  public static Cons yieldMixinSlotReaderTree(StorageSlot slot) {
    { Symbol readername = StorageSlot.yieldMixinSlotReaderName(slot);
      Stella_Object typetree = StorageSlot.yieldSlotTypeTree(slot);

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFUN, Cons.cons(Cons.cons(readername, Cons.cons(typetree, Stella.NIL)), Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.SYM_STELLA_OBJECT, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Stella.KWD_AUXILIARYp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TYPECASE, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Cons.cons(Stella_Class.yieldMixinClassUsersTree(((Stella_Class)(slot.slotOwner.surrogateValue))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Cons.cons(slot.slotName, Cons.cons(Stella.SYM_STELLA_SELF, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OTHERWISE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))))))));
    }
  }

  public static Symbol yieldMixinSlotWriterName(StorageSlot slot) {
    return (Symbol.yieldSetterMethodName(StorageSlot.yieldMixinSlotReaderName(slot)));
  }

  public static Symbol yieldMixinSlotReaderName(StorageSlot slot) {
    { String preName = slot.slotName.symbolName;
      String postName = slot.slotOwner.symbolName;
      String infix = ((Stella.allUpperCaseStringP(preName) &&
          Stella.allUpperCaseStringP(postName)) ? "-ON-" : "-On-");

      return (Symbol.internDerivedSymbol(slot.slotName, preName + infix + postName));
    }
  }

  public static boolean slotAccessMethodP(StorageSlot slot) {
    return ((slot.reader() != null) ||
        (StorageSlot.systemDefinedSlotReaderP(slot) ||
         ((slot.writer() != null) ||
          StorageSlot.systemDefinedSlotWriterP(slot))));
  }

  public static boolean genericSlotWriterP(StorageSlot slot) {
    return ((!slot.slotHardwiredP) &&
        StorageSlot.genericSlotReaderP(slot));
  }

  public static boolean genericSlotReaderP(StorageSlot slot) {
    { Surrogate type = Surrogate.canonicalType(slot.type());

      return ((!slot.abstractP) &&
          (Surrogate.subtypeOfP(slot.slotOwner, Stella.SGT_STELLA_OBJECT) &&
           ((((Stella_Class)(type.surrogateValue)) != null) &&
            Surrogate.genericallyAccessibleTypeP(type))));
    }
  }

  public static Cons yieldSlotWriterTree(StorageSlot slot, Stella_Class renamed_Class) {
    { Stella_Object typetree = StorageSlot.yieldSlotTypeTree(slot);
      Cons parameters = Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Symbol.internSymbolInModule(renamed_Class.classType.symbolName, ((Module)(renamed_Class.classType.homeContext)), true), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(typetree, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))));
      boolean slotvisibleP = Surrogate.subtypeOfP(renamed_Class.classType, slot.slotOwner);
      Cons writecode = null;

      if (!slotvisibleP) {
        writecode = Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ERROR, Cons.cons(StringWrapper.wrapString("Slot '"), Cons.cons(StringWrapper.wrapString(slot.slotName.symbolName), Cons.cons(Cons.list$(Cons.cons(StringWrapper.wrapString("' does not exist on "), Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))));
      }
      else if (slot.activeP()) {
        writecode = StorageSlot.yieldActiveSlotWriterBody(slot);
      }
      else {
        writecode = Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(slot.slotName, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFMETHOD, Cons.cons(Cons.cons(Symbol.yieldSetterMethodName(slot.slotName), Cons.cons(Stella_Object.copyConsTree(typetree), Stella.NIL)), Cons.cons(parameters, Cons.cons(Cons.list$(Cons.cons(Stella.KWD_AUXILIARYp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(((slotvisibleP ? Stella.NIL : Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IGNORE, Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL))).concatenate(Cons.cons(writecode, Stella.NIL), Stella.NIL), Stella.NIL)))), Stella.NIL))))));
    }
  }

  public static Cons yieldSlotReaderTree(StorageSlot slot, Stella_Class renamed_Class) {
    { Cons parameters = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Symbol.internSymbolInModule(renamed_Class.classType.symbolName, ((Module)(renamed_Class.classType.homeContext)), true), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL);
      Stella_Object typetree = StorageSlot.yieldSlotTypeTree(slot);
      Stella_Object defaultexpression = (StorageSlot.hasNonNullDefaultValueP(slot) ? slot.systemDefaultValue() : ((Stella_Object)(null)));
      boolean slotvisibleP = Surrogate.subtypeOfP(renamed_Class.classType, slot.slotOwner);
      Cons readcode = null;
      Cons auxiliarycode = null;

      if (!slotvisibleP) {
        readcode = Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ERROR, Cons.cons(StringWrapper.wrapString("Slot '"), Cons.cons(StringWrapper.wrapString(slot.slotName.symbolName), Cons.cons(Cons.list$(Cons.cons(StringWrapper.wrapString("' does not exist on "), Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))));
      }
      else if (slot.activeP()) {
        readcode = StorageSlot.yieldActiveSlotReaderBody(slot, defaultexpression);
      }
      else if (slot.slotHardwiredP) {
        { Object [] caller_MV_returnarray = new Object[1];

          readcode = StorageSlot.yieldHardwiredSlotReaderBody(slot, caller_MV_returnarray);
          auxiliarycode = ((Cons)(caller_MV_returnarray[0]));
        }
        if (renamed_Class.classType == slot.slotOwner) {
          Cons.walkAuxiliaryTree(auxiliarycode);
        }
      }
      else {
        readcode = StorageSlot.wrapWithDefaultValueAndReturnCode(slot, defaultexpression);
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFMETHOD, Cons.cons(Cons.cons(slot.slotName, Cons.cons(typetree, Stella.NIL)), Cons.cons(parameters, Cons.cons(Cons.list$(Cons.cons(Stella.KWD_AUXILIARYp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(readcode, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL))))));
    }
  }

  public static Cons wrapWithDefaultValueAndReturnCode(StorageSlot slot, Stella_Object defaultexpression) {
    { Cons readcode = Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(slot.slotName, Cons.cons(Stella.NIL, Stella.NIL)))));

      if (defaultexpression != null) {
        if (slot.type() == Stella.SGT_STELLA_BOOLEAN) {
          if (!(slot.allocation() == Stella.KWD_DYNAMIC)) {
            { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationWarning();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
                  {
                    Stella.STANDARD_WARNING.nativeStream.println();
                    Stella.STANDARD_WARNING.nativeStream.println(" Ignoring :default annotation on non-dynamic BOOLEAN slot `" + Stella_Object.deUglifyParseTree(slot) + "'.");
                    Stella.STANDARD_WARNING.nativeStream.println(" Limited :default support is available for dynamic BOOLEAN slots,");
                    Stella.STANDARD_WARNING.nativeStream.println(" and full support for THREE-VALUED-BOOLEAN slots.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
              }
            }
          }
          else {
            {
              Surrogate.setLiteralTypeInfo(Stella.SGT_STELLA_BOOLEAN, Stella.KWD_NULL_WRAPPER, Cons.list$(Cons.cons(Stella.SYM_STELLA_INLINE_WRAP_BOOLEAN, Cons.cons(defaultexpression, Cons.cons(Stella.NIL, Stella.NIL)))));
              Symbol.pushVariableBinding(Stella.SYM_STELLA_SELF, slot.slotOwner);
              readcode = Stella_Object.sysTree(Stella_Object.walkExpressionTree(readcode, Stella.SGT_STELLA_BOOLEAN, slot.slotName, false, new Object[1]), Stella.SGT_STELLA_BOOLEAN, new Object[1]);
              Stella.popVariableBinding();
              Surrogate.setLiteralTypeInfo(Stella.SGT_STELLA_BOOLEAN, Stella.KWD_NULL_WRAPPER, Stella.SYM_STELLA_FALSE_WRAPPER);
            }
          }
          return (Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(readcode, Cons.cons(Stella.NIL, Stella.NIL)))));
        }
        else {
          return (Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ANSWER, Cons.cons(readcode, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NULLp, Cons.cons(Stella.SYM_STELLA_ANSWER, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella_Object.copyConsTree(defaultexpression), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(Stella.SYM_STELLA_ANSWER, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))));
        }
      }
      else {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(readcode, Cons.cons(Stella.NIL, Stella.NIL)))));
      }
    }
  }

  public static Cons yieldHardwiredSlotReaderBody(StorageSlot slot, Object [] MV_returnarray) {
    { Symbol slotvariable = StorageSlot.yieldHardwiredSlotVariable(slot);
      Stella_Object slottypedesc = StandardObject.yieldTypeSpecTree(slot.computeReturnTypeSpec(slot.slotOwner));

      { Cons _return_temp = Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(slotvariable, Cons.cons(Stella.NIL, Stella.NIL))));

        MV_returnarray[0] = Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFGLOBAL, Cons.cons(slotvariable, Cons.cons(Cons.cons(slottypedesc, Cons.cons(Stella.SYM_STELLA_NULL, Stella.NIL)), Stella.NIL))));
        return (_return_temp);
      }
    }
  }

  public static Symbol yieldHardwiredSlotVariable(StorageSlot slot) {
    return (Symbol.internDerivedSymbol(slot.slotName, "*HARDWIRED-" + slot.slotName.symbolName + "-ON-" + slot.slotOwner.symbolName + "*"));
  }

  public static Stella_Object yieldSlotTypeTree(StorageSlot slot) {
    return (StandardObject.yieldTypeSpecTree(((((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null))) != null) ? ((StandardObject)(((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null))))) : ((StandardObject)(slot.slotBaseType)))));
  }

  public static boolean systemDefinedSlotWriterP(StorageSlot slot) {
    return ((slot.writer() == null) &&
        slot.activeP());
  }

  public static boolean systemDefinedSlotReaderP(StorageSlot slot) {
    return ((slot.reader() == null) &&
        (StorageSlot.hasNonNullDefaultValueP(slot) ||
         (slot.activeP() ||
          slot.slotHardwiredP)));
  }

  public static boolean hasNonNullDefaultValueP(StorageSlot slot) {
    { Stella_Object defaultform = slot.systemDefaultValue();

      return ((defaultform != null) &&
          (!Stella_Object.equalConsTreesP(StandardObject.typeToWalkedNullValueTree(slot.typeSpecifier(), slot.type()), defaultform)));
    }
  }

  public static Cons yieldInitialValueAssignment(StorageSlot slot, Keyword mode) {
    { Stella_Object initialvalueexpression = StorageSlot.yieldInitialValueExpression(slot);
      boolean requiredslotP = slot.requiredP();

      if ((initialvalueexpression != null) &&
          (!(slot.slotName == Stella.SYM_STELLA_NEXT_SWEEP_LIST_OBJECT))) {
        if (mode == Stella.KWD_NULL_VALUE_ONLY) {
          if (requiredslotP ||
              (!Stella_Object.equalConsTreesP(StandardObject.typeToWalkedNullValueTree(slot.typeSpecifier(), slot.type()), initialvalueexpression))) {
            initialvalueexpression = null;
          }
        }
        else if (mode == Stella.KWD_INITIAL_VALUE_ONLY) {
          if (requiredslotP ||
              Stella_Object.equalConsTreesP(StandardObject.typeToWalkedNullValueTree(slot.typeSpecifier(), slot.type()), initialvalueexpression)) {
            initialvalueexpression = null;
          }
        }
        else if (mode == Stella.KWD_FORCE_NULL_VALUE) {
          initialvalueexpression = StandardObject.typeToWalkedNullValueTree(slot.typeSpecifier(), slot.type());
        }
        else if (mode == Stella.KWD_ANY_INITIAL_VALUE) {
          if (requiredslotP) {
            initialvalueexpression = null;
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + mode + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
        if (initialvalueexpression != null) {
          return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE, Cons.cons(Stella.SYM_STELLA_SELF, Cons.cons(StorageSlot.canonicalSlot(slot).slotName, Cons.cons(((StorageSlot.isContextSensitiveSlotP(slot) ? Cons.list$(Cons.cons(Stella.KWD_CONTEXT_SENSITIVEp, Cons.cons(Stella.SYM_STELLA_FALSE, Cons.cons(Stella.NIL, Stella.NIL)))) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL), Stella.NIL))))), Cons.cons(initialvalueexpression, Cons.cons(Stella.NIL, Stella.NIL))))));
        }
      }
      return (null);
    }
  }

  public static boolean isContextSensitiveSlotP(StorageSlot slot) {
    return (slot.slotContextSensitiveP ||
        ((slot.slotDirectEquivalent != null) &&
         StorageSlot.isContextSensitiveSlotP(((StorageSlot)(slot.slotDirectEquivalent)))));
  }

  public static Stella_Class nativeStorageSlotHome(StorageSlot slot, Stella_Class renamed_Class) {
    { StorageSlot slotwithknowntype = null;

      loop000 : for (;;) {
        if (Surrogate.unknownTypeP(slot.type())) {
          break loop000;
        }
        slotwithknowntype = slot;
        renamed_Class = Surrogate.typeToClass(slot.slotOwner);
        if ((slot.slotDirectEquivalent != null) &&
            StorageSlot.nativeSlotP(((StorageSlot)(slot.slotDirectEquivalent)))) {
          slot = ((StorageSlot)(slot.slotDirectEquivalent));
        }
        else {
          break loop000;
        }
      }
      if (slotwithknowntype != null) {
        return (renamed_Class);
      }
      if (StorageSlot.slotHasUnknownTypeP(slot, renamed_Class)) {
        return (null);
      }
      { Stella_Class renamed_Super = null;
        Cons iter000 = renamed_Class.classAllSuperClasses;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          renamed_Super = ((Stella_Class)(iter000.value));
          if (StorageSlot.slotHasUnknownTypeP(slot, renamed_Super)) {
            return (renamed_Class);
          }
          else {
            renamed_Class = renamed_Super;
          }
        }
      }
      return (renamed_Class);
    }
  }

  public static boolean slotHasUnknownTypeP(StorageSlot slot, Stella_Class renamed_Class) {
    return (Surrogate.unknownTypeP(StandardObject.typeSpecToBaseType(slot.computeReturnTypeSpec(renamed_Class.classType))));
  }

  public static StorageSlot canonicalSlot(StorageSlot slot) {
    { StorageSlot canonicalslot = slot;

      while ((canonicalslot.slotDirectEquivalent != null) &&
          (canonicalslot.slotDirectEquivalent.slotName == ((Symbol)(KeyValueList.dynamicSlotValue(canonicalslot.dynamicSlots, Stella.SYM_STELLA_SLOT_RENAMES, null))))) {
        canonicalslot = ((StorageSlot)(canonicalslot.slotDirectEquivalent));
      }
      return (canonicalslot);
    }
  }

  public static boolean parameterSlotP(StorageSlot slot) {
    { Surrogate owner = slot.slotOwner;

      return (slot.abstractP &&
          ((owner != null) &&
           ((((Stella_Class)(owner.surrogateValue)) != null) &&
            ((Stella_Class)(owner.surrogateValue)).parameters().memberP(slot.slotName))));
    }
  }

  public static boolean nativeSlotP(StorageSlot slot) {
    return ((!slot.abstractP) &&
        ((!slot.slotHardwiredP) &&
         ((!StorageSlot.spaceSaverSlotAllocationP(slot)) &&
          (!StorageSlot.redundantSlotP(slot)))));
  }

  public static boolean redundantSlotP(StorageSlot slot) {
    { Slot equivslot = slot.slotDirectEquivalent;

      return ((equivslot != null) &&
          (((Symbol)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_RENAMES, null))) == equivslot.slotName));
    }
  }

  public static boolean classSlotP(StorageSlot slot) {
    return (slot.allocation() == Stella.KWD_CLASS);
  }

  public static boolean dynamicSlotP(StorageSlot slot) {
    return (slot.allocation() == Stella.KWD_DYNAMIC);
  }

  public static boolean spaceSaverSlotAllocationP(StorageSlot slot) {
    if (slot.allocation() == Stella.KWD_DYNAMIC) {
      if (KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_INITIAL_VALUE, null) != null) {
        {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: Dynamic slot `" + slot.slotName + "' should not have an");
          Stella.STANDARD_WARNING.nativeStream.println("   initial value (or it shouldn't be dynamic).");
        }
;
      }
      return (true);
    }
    else if ((slot.allocation() == Stella.KWD_BIT) ||
        ((slot.type() == Stella.SGT_STELLA_BOOLEAN) &&
         (slot.slotAllocation() == null))) {
      return (true);
    }
    else {
      return (false);
    }
  }

  public StandardObject computeReturnTypeSpec(StandardObject firstargtype) {
    { StorageSlot self = this;

      if (((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null))) == null) {
        return (self.type());
      }
      else {
        return (StandardObject.computeRelativeTypeSpec(((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null))), firstargtype));
      }
    }
  }

  public int arity() {
    { StorageSlot self = this;

      return (2);
    }
  }

  public boolean methodBodyArgumentP() {
    { StorageSlot self = this;

      return (false);
    }
  }

  public boolean methodVariableArgumentsP() {
    { StorageSlot self = this;

      return (false);
    }
  }

  public int methodArgumentCount() {
    { StorageSlot self = this;

      return (1);
    }
  }

  /** Defines the value of a slot before it has been assigned
   * a value.
   * @return Stella_Object
   */
  public Stella_Object initially() {
    { StorageSlot self = this;

      { Stella_Object value = KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_INITIAL_VALUE, null);

        if (value != null) {
          return (value);
        }
        else if (self.slotDirectEquivalent != null) {
          return (((StorageSlot)(self.slotDirectEquivalent)).initially());
        }
        else if (self.slotBaseType == Stella.SGT_STELLA_BOOLEAN) {
          return (Stella.SYM_STELLA_FALSE);
        }
        else {
          return (null);
        }
      }
    }
  }

  /** Return a default value expression, or if <code>self</code>
   * has dynamic storage, an initial value expression.
   * @return Stella_Object
   */
  public Stella_Object systemDefaultValue() {
    { StorageSlot self = this;

      { Stella_Object value = self.defaultForm();

        if (value != null) {
          return (value);
        }
        else if (self.dynamicStorageP() &&
            (((Stella_Class)(self.type().surrogateValue)) != null)) {
          return (KeyValueList.dynamicSlotValue(((Stella_Class)(self.type().surrogateValue)).dynamicSlots, Stella.SYM_STELLA_CLASS_INITIAL_VALUE, null));
        }
        else {
          return (null);
        }
      }
    }
  }

  /** Return an initial value for <code>self</code>, or <code>null</code>.  The
   * initial value can be defined by the slot itself, inherited from an
   * equivalent slot, or inherit from the :initial-value option for the 
   * class representing the type of <code>self</code>.
   * @return Stella_Object
   */
  public Stella_Object initialValue() {
    { StorageSlot self = this;

      { StorageSlot slot = self;
        Stella_Object value = KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_INITIAL_VALUE, null);

        loop000 : for (;;) {
          if (value != null) {
            return (value);
          }
          slot = ((StorageSlot)(slot.slotDirectEquivalent));
          if (slot != null) {
            value = KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_INITIAL_VALUE, null);
          }
          else {
            break loop000;
          }
        }
        return (KeyValueList.dynamicSlotValue(((Stella_Class)(self.type().surrogateValue)).dynamicSlots, Stella.SYM_STELLA_CLASS_INITIAL_VALUE, null));
      }
    }
  }

  public boolean dynamicStorageP() {
    { StorageSlot self = this;

      { Keyword allocation = self.allocation();

        return ((allocation == Stella.KWD_DYNAMIC) ||
            (allocation == Stella.KWD_BIT));
      }
    }
  }

  public boolean conformingSignaturesP(Slot superslot) {
    { StorageSlot self = this;

      return (StandardObject.conformingTypeSpecP(self.slotBaseType, superslot.type()) &&
          (StandardObject.conformingTypeSpecP(((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null))), ((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(superslot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null)))) &&
           (superslot.methodArgumentCount() == 1)));
    }
  }

  public void unfinalizeLocalSlot() {
    { StorageSlot self = this;

    }
  }

  public void helpFinalizeLocalSlot() {
    { StorageSlot self = this;

      { Stella_Class owner = ((Stella_Class)(self.slotOwner.surrogateValue));

        if ((self.allocation() == Stella.KWD_DYNAMIC) &&
            ((!Surrogate.subtypeOfP(owner.classType, Stella.SGT_STELLA_DYNAMIC_SLOTS_MIXIN)) &&
             (!owner.abstractP))) {
          {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Slot `" + self.slotName + "' on the class `" + Stella_Class.classSymbol(owner) + "'");
            Stella.STANDARD_WARNING.nativeStream.println("   can't have :dynamic slot allocation because the class doesn't");
            Stella.STANDARD_WARNING.nativeStream.println("   inherit the class `DYNAMIC-SLOTS-MIXIN'.  Resetting the");
            Stella.STANDARD_WARNING.nativeStream.println("   allocation to ':instance'.");
          }
;
          KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_ALLOCATION, Stella.KWD_INSTANCE, null);
        }
        if (((Symbol)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_RENAMES, null))) != null) {
          { StorageSlot renamesslot = ((StorageSlot)(Stella_Class.lookupSlot(owner, ((Symbol)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_RENAMES, null))))));

            if (!(self.primaryType() == renamesslot.primaryType())) {
              {
                Stella.STANDARD_WARNING.nativeStream.println("Warning: Slot `" + self.slotName + "' renames a slot of a different kind");
                Stella.STANDARD_WARNING.nativeStream.println("   (e.g., a storage slot renaming a method slot, or vice-versa).");
                Stella.STANDARD_WARNING.nativeStream.println("  Cancelling the renames option.");
              }
;
              KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_RENAMES, null, null);
            }
            else if (!(self.allocation() == renamesslot.allocation())) {
              {
                Stella.STANDARD_WARNING.nativeStream.println("Warning: Slot `" + self.slotName + "' renames a slot with a different");
                Stella.STANDARD_WARNING.nativeStream.println("   allocation.  Changing its allocation to `" + renamesslot.allocation() + "'.");
              }
;
              KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_ALLOCATION, renamesslot.allocation(), null);
            }
          }
        }
        if (self.slotContextSensitiveP &&
            ((!Surrogate.subtypeOfP(self.slotOwner, Stella.SGT_STELLA_CONTEXT_SENSITIVE_OBJECT)) &&
             (!Surrogate.subtypeOfP(owner.classType, Stella.SGT_STELLA_CONTEXT_SENSITIVE_MIXIN)))) {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            {
              stream000.nativeStream.println("Class `" + self.slotOwner.symbolName + "' must inherit either the class CONTEXT-SENSITIVE-OBJECT");
              stream000.nativeStream.println("   or the class CONTEXT-SENSITIVE-MIXIN because it contains the");
              stream000.nativeStream.println("   context sensitive slot `" + self.slotName + "' ");
            }
;
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  public void finalizeSlotTypeComputations() {
    { StorageSlot self = this;

      if (((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null))) != null) {
        self.slotBaseType = StandardObject.validateTypeSpecifier(((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null))), ((Stella_Class)(self.slotOwner.surrogateValue)), false);
      }
      if (self.slotBaseType == null) {
        self.slotBaseType = self.type();
      }
      if (self.slotBaseType == null) {
        if (!self.abstractP) {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: Missing type specification for the slot `" + self + "'");
        }
        self.slotBaseType = Stella.SGT_STELLA_UNKNOWN;
        return;
      }
      if (self.activeP()) {
        StorageSlot.activateSlot(self);
      }
    }
  }

  public static void activateSlot(StorageSlot self) {
    if (self.collectionValuedP()) {
      { Surrogate activecollection = Surrogate.collectionToActiveCollection(self.slotBaseType);

        if (activecollection == null) {
          {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: No active collection defined for `" + self.slotBaseType + "'.");
            Stella.STANDARD_WARNING.nativeStream.println("   Cannot activate slot `" + self + "'.");
          }
;
          KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_STORED_ACTIVEp, Stella.FALSE_WRAPPER, null);
          return;
        }
        self.slotBaseType = Surrogate.collectionToActiveCollection(self.slotBaseType);
      }
    }
    KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_STORED_ACTIVEp, Stella.TRUE_WRAPPER, null);
  }

  public static Stella_Object accessStorageSlotSlotValue(StorageSlot self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_SLOT_ALLOCATION) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_ALLOCATION, ((Keyword)(value)), null);
      }
      else {
        value = self.slotAllocation();
      }
    }
    else if (slotname == Stella.SYM_STELLA_SLOT_GUARD_DEMONS) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_GUARD_DEMONS, ((List)(value)), null);
      }
      else {
        value = self.slotGuardDemons();
      }
    }
    else if (slotname == Stella.SYM_STELLA_SLOT_DEMONS) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_DEMONS, ((List)(value)), null);
      }
      else {
        value = self.slotDemons();
      }
    }
    else if (slotname == Stella.SYM_STELLA_SLOT_REQUIREDp) {
      if (setvalueP) {
        self.slotRequiredP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.slotRequiredP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_SLOT_COMPONENTp) {
      if (setvalueP) {
        self.slotComponentP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.slotComponentP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_SLOT_READ_ONLYp) {
      if (setvalueP) {
        self.slotReadOnlyP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.slotReadOnlyP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_SLOT_HARDWIREDp) {
      if (setvalueP) {
        self.slotHardwiredP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.slotHardwiredP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_SLOT_CONTEXT_SENSITIVEp) {
      if (setvalueP) {
        self.slotContextSensitiveP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.slotContextSensitiveP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
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

  public List slotDemons() {
    { StorageSlot self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_DEMONS, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public List slotGuardDemons() {
    { StorageSlot self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_GUARD_DEMONS, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public Keyword slotAllocation() {
    { StorageSlot self = this;

      { Keyword answer = ((Keyword)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_ALLOCATION, null)));

        if (answer == null) {
          return (Stella.KWD_INSTANCE);
        }
        else {
          return (answer);
        }
      }
    }
  }

  /** Name of a method called to write the value of the slot
   * <code>self</code>.
   * @return Symbol
   */
  public Symbol writer() {
    { StorageSlot self = this;

      { StorageSlot cursor = self;
        Symbol value = ((Symbol)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_SLOT_WRITER, null)));

        for (;;) {
          if (value != null) {
            return (value);
          }
          cursor = ((StorageSlot)(cursor.slotDirectEquivalent));
          if (cursor != null) {
            value = ((Symbol)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_SLOT_WRITER, null)));
          }
          else {
            return (null);
          }
        }
      }
    }
  }

  /** Name of a method called to read the value of the slot
   * <code>self</code>.
   * @return Symbol
   */
  public Symbol reader() {
    { StorageSlot self = this;

      { StorageSlot cursor = self;
        Symbol value = ((Symbol)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_SLOT_READER, null)));

        for (;;) {
          if (value != null) {
            return (value);
          }
          cursor = ((StorageSlot)(cursor.slotDirectEquivalent));
          if (cursor != null) {
            value = ((Symbol)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_SLOT_READER, null)));
          }
          else {
            return (null);
          }
        }
      }
    }
  }

  /** True if fillers of this slot are components of the
   * owner slot, and therefore should be deleted if the owner is deleted.
   * @return boolean
   */
  public boolean componentP() {
    { StorageSlot self = this;

      { StorageSlot cursor = self;
        boolean value = cursor.slotComponentP;

        for (;;) {
          if (value) {
            return (value);
          }
          cursor = ((StorageSlot)(cursor.slotDirectEquivalent));
          if (cursor != null) {
            value = cursor.slotComponentP;
          }
          else {
            return (false);
          }
        }
      }
    }
  }

  /** True if a value must be assigned to this slot at
   * creation time.
   * @return boolean
   */
  public boolean requiredP() {
    { StorageSlot self = this;

      { StorageSlot cursor = self;
        boolean value = cursor.slotRequiredP;

        for (;;) {
          if (value) {
            return (value);
          }
          cursor = ((StorageSlot)(cursor.slotDirectEquivalent));
          if (cursor != null) {
            value = cursor.slotRequiredP;
          }
          else {
            return (false);
          }
        }
      }
    }
  }

  /** Returns the current value of default expression when the
   * slot has not been assigned a value.
   * @return Stella_Object
   */
  public Stella_Object defaultForm() {
    { StorageSlot self = this;

      { StorageSlot cursor = self;
        Stella_Object value = KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_SLOT_DEFAULT_EXPRESSION, null);

        for (;;) {
          if (value != null) {
            return (value);
          }
          cursor = ((StorageSlot)(cursor.slotDirectEquivalent));
          if (cursor != null) {
            value = KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_SLOT_DEFAULT_EXPRESSION, null);
          }
          else {
            return (null);
          }
        }
      }
    }
  }

  /** Return the most specific :allocation facet, or
   * :instance if all inherited values are NULL.
   * @return Keyword
   */
  public Keyword allocation() {
    { StorageSlot self = this;

      { StorageSlot cursor = self;
        Keyword value = ((Keyword)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_SLOT_ALLOCATION, null)));

        for (;;) {
          if (value != null) {
            return (value);
          }
          cursor = ((StorageSlot)(cursor.slotDirectEquivalent));
          if (cursor != null) {
            value = ((Keyword)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_SLOT_ALLOCATION, null)));
          }
          else {
            return (Stella.KWD_INSTANCE);
          }
        }
      }
    }
  }

  public Surrogate primaryType() {
    { StorageSlot self = this;

      return (Stella.SGT_STELLA_STORAGE_SLOT);
    }
  }

}

