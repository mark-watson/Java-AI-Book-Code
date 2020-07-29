//  -*- Mode: Java -*-
//
// Slot.java

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

public abstract class Slot extends PolymorphicRelation {
    public Symbol slotName;
    public Surrogate slotOwner;
    public Surrogate slotBaseType;
    public Surrogate slotSlotref;
    public boolean slotPublicP;
    public boolean slotRenamedP;
    public boolean slotExternalP;
    public boolean slotMarkedP;

  /** Helper method for <code>printOutline</code>
   * @param stream
   * @param currentDepth
   * @param depth
   * @param namedP
   */
  public void helpPrintOutline(OutputStream stream, int currentDepth, int depth, boolean namedP) {
    { Slot top = this;

      Stella.indentOutline(currentDepth, stream);
      stream.nativeStream.println(top.name());
      if (!((depth != Stella.NULL_INTEGER) &&
          ((depth >= 0) &&
           (currentDepth >= depth)))) {
        currentDepth = currentDepth + 1;
        { Slot c = null;
          Cons iter000 = top.slotDirectSubs().theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            c = ((Slot)(iter000.value));
            c.helpPrintOutline(stream, currentDepth, depth, namedP);
          }
        }
      }
    }
  }

  public void prettyPrintObject(OutputStream stream) {
    { Slot self = this;

      stream = stream;
    }
  }

  public static void attachInverseSlotDemon(Slot slot) {
    if (Surrogate.subtypeOfStorageSlotP(Stella_Object.safePrimaryType(slot))) {
      { StorageSlot slot000 = ((StorageSlot)(slot));

        { Demon inversedemon = Stella.lookupDemon("inverse-slot-demon");

          inversedemon.demonClassRefs.push(slot000.slotOwner);
          inversedemon.demonSlotRefs.push(slot000.slotName);
          KeyValueList.setDynamicSlotValue(slot000.dynamicSlots, Stella.SYM_STELLA_SLOT_DEMONS, List.injectDemon(slot000.slotDemons(), inversedemon), null);
        }
      }
    }
    else {
      return;
    }
  }

  public static Stella_Object finishWalkingArgumentListTree(Slot self, Cons tree, StandardObject firstargtype, Object [] MV_returnarray) {
    if (self.slotName == Stella.SYM_STELLA_ALLOCATE_ITERATOR) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Cannot invoke `" + Stella_Object.deUglifyParseTree(self) + "' directly, use `foreach' instead.");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_ARGUMENT_LIST_ITERATOR, MV_returnarray));
    }
    if (self.slotOwner == Stella.SGT_STELLA_CONS) {
      { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationNote();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> NOTE: ", Stella.STANDARD_OUTPUT);
            {
              Stella.STANDARD_OUTPUT.nativeStream.println();
              Stella.STANDARD_OUTPUT.nativeStream.println(" Applying CONS-methods to &rest-arguments is deprecated.");
              Stella.STANDARD_OUTPUT.nativeStream.println("   `" + Stella_Object.deUglifyParseTree(tree) + "'");
              Stella.STANDARD_OUTPUT.nativeStream.println(" Use `foreach' or explicitly coerce with `coerce-&rest-to-cons'.");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
        }
      }
      firstargtype = MethodSlot.yieldListifiedVariableArgumentsType(((MethodSlot)(Stella.$METHODBEINGWALKED$.get())));
    }
    if (MethodSlot.passVariableArgumentsAsListP(((MethodSlot)(Stella.$METHODBEINGWALKED$.get())))) {
      if (self.slotName == Stella.SYM_STELLA_LENGTH) {
        return (Stella_Object.sysTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_CALL_METHOD, Cons.cons(StandardObject.typeSpecToBaseType(MethodSlot.yieldListifiedVariableArgumentsType(((MethodSlot)(Stella.$METHODBEINGWALKED$.get())))), Cons.cons(tree.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Stella.SGT_STELLA_INTEGER, MV_returnarray));
      }
      else {
        return (self.finishWalkingCallSlotTree(tree, firstargtype, MV_returnarray));
      }
    }
    else {
      return (self.finishWalkingCallSlotTree(tree, firstargtype, MV_returnarray));
    }
  }

  public Stella_Object finishWalkingCallSlotTree(Cons tree, StandardObject firstargtype, Object [] MV_returnarray) {
    { Slot self = this;

      {
        tree = tree;
        firstargtype = firstargtype;
      }
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("finish-walking-call-slot-tree: Not defined on `" + self + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static Cons yieldFixedSlotValueSetterTree(Slot slot, Stella_Object objectref, Stella_Object valuetree) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_SLOT_VALUE_SETTER, Cons.cons(slot.slotOwner, Cons.cons(Cons.cons(slot.slotName, Cons.cons(objectref, Cons.cons(Stella_Object.walkExpressionTree(valuetree, slot.type(), Stella.SYM_STELLA_SLOT_VALUE_SETTER, false, new Object[1]), Stella.NIL))), Stella.NIL)))));
  }

  public static Stella_Object sysTreeIfNeeded(Slot slot, Stella_Object tree, StandardObject firstargtype, StandardObject returntype, Object [] MV_returnarray) {
    if ((slot != null) &&
        (!Stella_Object.proceduralExpressionP(tree))) {
      { Surrogate testValue000 = Stella_Object.safePrimaryType(slot);

        if (Surrogate.subtypeOfMethodSlotP(testValue000)) {
          { MethodSlot slot000 = ((MethodSlot)(slot));

            if ((!slot000.methodFunctionP) &&
                Stella.needIdenticalMethodSignaturesP()) {
              { StandardObject mostgeneralreturntype = MethodSlot.computeMostGeneralReturnType(slot000, returntype);

                if (!(returntype == mostgeneralreturntype)) {
                  return (Cons.setTargetLanguageType(Stella_Object.sysTree(tree, returntype, new Object[1]), ((Surrogate)(mostgeneralreturntype)), MV_returnarray));
                }
              }
            }
          }
        }
        else if (Surrogate.subtypeOfStorageSlotP(testValue000)) {
          { StorageSlot slot000 = ((StorageSlot)(slot));

            { StandardObject realslottype = StorageSlot.computeRealSlotType(slot000, firstargtype, returntype);
              Slot realslot = null;

              if (!(returntype == realslottype)) {
                if ((realslottype == Stella.SGT_STELLA_UNKNOWN) &&
                    ((!(slot000 == (realslot = Cons.slotFromExpressionTree(((Cons)(tree)))))) &&
                     Stella_Object.methodSlotP(realslot))) {
                  return (Slot.sysTreeIfNeeded(realslot, tree, firstargtype, returntype, MV_returnarray));
                }
                return (Cons.setTargetLanguageType(Stella_Object.sysTree(tree, returntype, new Object[1]), ((Surrogate)(realslottype)), MV_returnarray));
              }
            }
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      { CompoundTypeSpecifier slottype = ((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null)));

        { boolean testValue001 = false;

          testValue001 = slottype != null;
          if (testValue001) {
            if (Stella_Object.anchoredTypeSpecifierP(slottype)) {
              testValue001 = true;
            }
            else {
              { boolean foundP000 = false;

                { StandardObject ts = null;
                  Cons iter000 = ((ParametricTypeSpecifier)(slottype)).specifierParameterTypes.theConsList;

                  loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                    ts = ((StandardObject)(iter000.value));
                    if (Stella_Object.anchoredTypeSpecifierP(ts)) {
                      foundP000 = true;
                      break loop000;
                    }
                  }
                }
                testValue001 = foundP000;
              }
            }
          }
          if (testValue001) {
            if (Stella_Object.anchoredTypeSpecifierP(slottype) &&
                (!(((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP))) {
              return (Cons.setTargetLanguageType(Stella_Object.sysTree(tree, returntype, new Object[1]), ((slot.slotBaseType == Stella.SGT_STELLA_UNKNOWN) ? StandardObject.typeSpecToBaseType(returntype) : slot.slotBaseType), MV_returnarray));
            }
            else {
              return (Stella_Object.sysTree(tree, returntype, MV_returnarray));
            }
          }
        }
      }
    }
    { Stella_Object _return_temp = tree;

      MV_returnarray[0] = returntype;
      return (_return_temp);
    }
  }

  public static Module recordSlotHomeModule(Slot self) {
    { Symbol name = self.slotName;
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
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_HOME_MODULE, homemodule, null);
      }
      return (homemodule);
    }
  }

  public static boolean slotValueIsBareLiteralP(Slot slot) {
    { Surrogate type = slot.type();

      return ((type != null) &&
          ((((Stella_Class)(type.surrogateValue)) != null) &&
           Surrogate.subtypeOfP(slot.type(), Stella.SGT_STELLA_LITERAL)));
    }
  }

  public static void markDirectEquivalentSlot(Slot slot) {
    { Slot directequivalent = slot.slotDirectEquivalent;

      if (directequivalent != null) {
        if (directequivalent.slotMarkedP) {
          slot.slotMarkedP = true;
        }
        else {
          directequivalent.slotMarkedP = true;
        }
      }
    }
  }

  public static boolean slotNameConflictP(Slot slot, Stella_Class renamed_Class) {
    { Symbol name = slot.slotName;
      String nameString = name.symbolName;

      { Slot siblingslot = null;
        Cons iter000 = renamed_Class.classLocalSlots.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          siblingslot = ((Slot)(iter000.value));
          if ((!(siblingslot.slotName == name)) &&
              Stella.stringEqlP(siblingslot.slotName.symbolName, nameString)) {
            return (true);
          }
        }
      }
      { Stella_Class superclass = null;
        Cons iter001 = renamed_Class.classAllSuperClasses;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          superclass = ((Stella_Class)(iter001.value));
          { Slot superslot = null;
            Cons iter002 = superclass.classLocalSlots.theConsList;

            for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
              superslot = ((Slot)(iter002.value));
              if ((!(superslot.slotName == name)) &&
                  Stella.stringEqlP(superslot.slotName.symbolName, nameString)) {
                return (true);
              }
            }
          }
        }
      }
      return (false);
    }
  }

  public static Stella_Class nativeSlotHome(Slot slot, Stella_Class renamed_Class) {
    { Stella_Class nativeslothome = (Stella_Object.storageSlotP(slot) ? StorageSlot.nativeStorageSlotHome(((StorageSlot)(slot)), renamed_Class) : ((Stella_Class)(slot.slotOwner.surrogateValue)));
      Stella_Class candidate = renamed_Class;
      Slot visibleslot = null;

      if (!((nativeslothome != null) &&
          (nativeslothome.mixinP &&
           Stella.translateToSingleInheritanceLanguageP()))) {
        return (nativeslothome);
      }
      if (candidate.mixinP) {
        return (null);
      }
      visibleslot = Stella_Class.lookupSlot(renamed_Class, slot.slotName);
      if ((!(slot == visibleslot)) &&
          Surrogate.subtypeOfP(visibleslot.slotOwner, slot.slotOwner)) {
        return (null);
      }
      { Stella_Class superclass = null;
        Cons iter000 = renamed_Class.classAllSuperClasses;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          superclass = ((Stella_Class)(iter000.value));
          if ((!superclass.mixinP) &&
              superclass.classAllSuperClasses.memberP(nativeslothome)) {
            candidate = superclass;
          }
        }
      }
      return (candidate);
    }
  }

  public static boolean mixinMethodP(Slot self) {
    { Surrogate owner = self.slotOwner;

      return (Stella_Object.methodSlotP(self) &&
          ((!((MethodSlot)(self)).methodFunctionP) &&
           ((owner != null) &&
            ((((Stella_Class)(owner.surrogateValue)) != null) &&
             ((Stella_Class)(owner.surrogateValue)).mixinP))));
    }
  }

  public static boolean mixinSlotP(Slot self) {
    { Surrogate owner = self.slotOwner;

      return (Stella_Object.storageSlotP(self) &&
          ((owner != null) &&
           ((((Stella_Class)(owner.surrogateValue)) != null) &&
            ((Stella_Class)(owner.surrogateValue)).mixinP)));
    }
  }

  public StandardObject computeReturnTypeSpec(StandardObject firstargtype) {
    { Slot self = this;

      firstargtype = firstargtype;
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("compute-return-type-spec: Not defined on `" + self + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public int methodArgumentCount() {
    { Slot self = this;

      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("method-argument-count: Not defined on `" + self + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static void destroyExternalSlot(Slot self) {
    if (!(self.deletedP() ||
        (BooleanWrapper.coerceWrappedBooleanToBoolean(self.badP()) ||
         (!self.slotExternalP)))) {
      { Stella_Class ownerclass = ((Stella_Class)(self.slotOwner.surrogateValue));

        if (ownerclass != null) {
          ownerclass.classLocalSlots.remove(self);
          Stella_Class.unfinalizeClassSlots(ownerclass);
          self.deletedPSetter(true);
        }
      }
    }
  }

  /** Return a default value expression, or if <code>self</code>
   * has dynamic storage, an initial value expression.
   * @return Stella_Object
   */
  public Stella_Object systemDefaultValue() {
    { Slot self = this;

      return (KeyValueList.dynamicSlotValue(((Stella_Class)(self.type().surrogateValue)).dynamicSlots, Stella.SYM_STELLA_CLASS_INITIAL_VALUE, null));
    }
  }

  public boolean activeP() {
    { Slot slot = this;

      return (((((BooleanWrapper)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_STORED_ACTIVEp, null))) != null) ? BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_STORED_ACTIVEp, null)))) : ((((Stella_Class)(Stella.SGT_STELLA_COLLECTION.surrogateValue)) != null) &&
          ((((Stella_Class)(slot.slotBaseType.surrogateValue)) != null) &&
           ((((Stella_Class)(slot.slotOwner.surrogateValue)) != null) &&
            (slot.primitiveP() &&
             ((((Symbol)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_INVERSE, null))) != null) ||
              ((slot.slotDirectEquivalent != null) &&
               slot.slotDirectEquivalent.activeP()))))))));
    }
  }

  /** True if <code>self</code> or one it its ancestors is marked public.
   * @return boolean
   */
  public boolean publicP() {
    { Slot self = this;

      return (self.slotPublicP ||
          ((self.slotDirectEquivalent != null) &&
           self.slotDirectEquivalent.publicP()));
    }
  }

  public boolean conformingSignaturesP(Slot superslot) {
    { Slot self = this;

      superslot = superslot;
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("conforming-signatures?: Not defined on `" + self + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static boolean warnAboutSlotShadowedByAFunctionP(Slot slot) {
    { Symbol name = slot.slotName;

      if (!(name.symbolSlotOffset != Stella.NULL_INTEGER)) {
        if (Symbol.lookupMacro(name) != null) {
          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              Stella.signalTranslationWarning();
              if (!(Stella.suppressWarningsP())) {
                Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
                {
                  Stella.STANDARD_WARNING.nativeStream.println();
                  Stella.STANDARD_WARNING.nativeStream.println(" Slot `" + Stella_Object.deUglifyParseTree(slot) + "' is shadowed by the macro `" + Stella_Object.deUglifyParseTree(name) + "'.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
          return (true);
        }
        if (Symbol.lookupFunction(name) != null) {
          { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              Stella.signalTranslationWarning();
              if (!(Stella.suppressWarningsP())) {
                Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
                {
                  Stella.STANDARD_WARNING.nativeStream.println();
                  Stella.STANDARD_WARNING.nativeStream.println(" Slot `" + Stella_Object.deUglifyParseTree(slot) + "' is shadowed by the function `" + Stella_Object.deUglifyParseTree(name) + "'.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
            }
          }
          return (true);
        }
      }
      return (false);
    }
  }

  /** Unregister the name symbol of <code>slot</code> as a slot name,
   * so that it can no longer be used by <code>lookupSlot</code>.
   * @param slot
   */
  public static void unregisterSlotName(Slot slot) {
    slot.slotName.symbolSlotOffset = Stella.NULL_INTEGER;
  }

  /** Register the name symbol of <code>slot</code> as a slot name, and
   * initialize its <code>symbolSlotOffset</code> so that it can be used by <code>lookupSlot</code>.
   * @param slot
   */
  public static void registerSlotName(Slot slot) {
    Slot.warnAboutSlotShadowedByAFunctionP(slot);
    slot.slotName.symbolSlotOffset = 0;
  }

  public static boolean localSlotP(Slot slot, Stella_Class renamed_Class) {
    return (slot.slotOwner.surrogateValue == renamed_Class);
  }

  public void unfinalizeLocalSlot() {
    { Slot self = this;

    }
  }

  public static void finalizeLocalSlot(Slot self) {
    Slot.computeSlotDirectEquivalent(self);
    self.finalizeSlotTypeComputations();
    Slot.checkConformanceOfSlotSignature(self);
    Slot.computeSlotInverses(self);
    self.helpFinalizeLocalSlot();
    HookList.runHooks(Stella.$FINALIZE_RELATION_HOOKS$, self);
  }

  public void helpFinalizeLocalSlot() {
    { Slot self = this;

    }
  }

  public static void computeSlotInverses(Slot self) {
    if (((Symbol)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_INVERSE, null))) == null) {
      return;
    }
    if (Slot.multiValuedSlotWithDuplicatesP(self)) {
      Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't define an inverse on slot `" + self + "' because it allows duplicate values.");
      KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_INVERSE, null, null);
      return;
    }
    { Stella_Class inverseclass = ((Stella_Class)(self.type().surrogateValue));
      Slot inverseslot = Stella_Class.lookupSlot(inverseclass, ((Symbol)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_INVERSE, null))));

      if (inverseslot != null) {
        if (Slot.multiValuedSlotWithDuplicatesP(inverseslot)) {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't define an inverse on slot `" + inverseslot + "' because it allows duplicate values.");
          KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_INVERSE, null, null);
          KeyValueList.setDynamicSlotValue(inverseslot.dynamicSlots, Stella.SYM_STELLA_SLOT_INVERSE, null, null);
          return;
        }
        if (!inverseslot.activeP()) {
          KeyValueList.setDynamicSlotValue(inverseslot.dynamicSlots, Stella.SYM_STELLA_SLOT_INVERSE, self.slotName, null);
          inverseslot.finalizeSlotTypeComputations();
        }
        KeyValueList.setDynamicSlotValue(inverseslot.dynamicSlots, Stella.SYM_STELLA_INVERSE, self, null);
        Slot.attachInverseSlotDemon(self);
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_INVERSE, inverseslot, null);
        Slot.attachInverseSlotDemon(inverseslot);
        return;
      }
      if (inverseclass == null) {
        {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't finalize inverse slot computation for slot `" + self + "'");
          Stella.STANDARD_WARNING.nativeStream.println(" because the class `" + self.type() + "' is not defined.");
        }
;
      }
      else {
        {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't finalize inverse slot computation for slot `" + self + "'");
          Stella.STANDARD_WARNING.nativeStream.println(" because the inverse slot `" + ((Symbol)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_INVERSE, null))) + "' does not exist.");
        }
;
      }
    }
  }

  public static boolean multiValuedSlotWithDuplicatesP(Slot self) {
    return (Surrogate.subtypeOfP(self.type(), Stella.SGT_STELLA_COLLECTION) &&
        (!Surrogate.subtypeOfP(self.type(), Stella.SGT_STELLA_SET_MIXIN)));
  }

  public void finalizeSlotTypeComputations() {
    { Slot self = this;

    }
  }

  public static void checkConformanceOfSlotSignature(Slot self) {
    { Slot equivalentslot = self.slotDirectEquivalent;

      if ((equivalentslot != null) &&
          (!self.conformingSignaturesP(equivalentslot))) {
        {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: The signature of slot `" + self + "' does not conform to the");
          Stella.STANDARD_WARNING.nativeStream.println("   signature of the inherited slot `" + equivalentslot + "'");
        }
;
      }
    }
  }

  public static void computeSlotDirectEquivalent(Slot self) {
    { Stella_Class renamed_Class = ((Stella_Class)(self.slotOwner.surrogateValue));
      Symbol slotname = self.slotName;
      Symbol slotrenames = ((Symbol)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_RENAMES, null)));
      Slot renamesslot = null;

      if (slotrenames != null) {
        { Slot value000 = null;

          { Slot s = null;
            Iterator iter000 = renamed_Class.classSlots();

            loop000 : while (iter000.nextP()) {
              s = ((Slot)(iter000.value));
              if (s.slotName == slotrenames) {
                value000 = s;
                break loop000;
              }
            }
          }
          renamesslot = value000;
        }
        if (renamesslot != null) {
          self.slotDirectEquivalent = renamesslot;
          renamesslot.slotRenamedP = true;
        }
        else {
          {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Slot `" + slotname + "' renames a non-existent self: `" + slotrenames + "'.");
            Stella.STANDARD_WARNING.nativeStream.println("Cancelling the renames option.");
          }
;
          KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_RENAMES, null, null);
        }
      }
      else {
        { Slot value001 = null;

          { Slot s = null;
            Iterator iter001 = renamed_Class.classSlots();

            loop001 : while (iter001.nextP()) {
              s = ((Slot)(iter001.value));
              if ((!(s == self)) &&
                  (s.slotName == slotname)) {
                value001 = s;
                break loop001;
              }
            }
          }
          self.slotDirectEquivalent = value001;
        }
      }
    }
  }

  public static Slot attachSlotToOwner(Slot newslot) {
    { Symbol name = newslot.slotName;
      Stella_Class ownerclass = ((Stella_Class)(newslot.slotOwner.surrogateValue));
      Slot oldslot = Stella_Class.lookupLocalSlot(ownerclass, name);

      newslot.slotExternalP = true;
      Slot.registerSlotName(newslot);
      if (oldslot == null) {
        ownerclass.classLocalSlots.insert(newslot);
        Stella_Class.unfinalizeClassSlots(ownerclass);
        return (newslot);
      }
      else if (!Slot.localSlotP(oldslot, ownerclass)) {
        ownerclass.classLocalSlots.insert(newslot);
        Stella_Class.unfinalizeClassSlots(ownerclass);
        return (newslot);
      }
      else if (!(newslot.primaryType() == oldslot.primaryType())) {
        {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't define a `" + newslot.primaryType() + "' named `" + name + "' on the class `" + Stella_Class.className(ownerclass) + "'");
          Stella.STANDARD_WARNING.nativeStream.println("because it already has a `" + oldslot.primaryType() + "' with the same name.");
        }
;
        return (null);
      }
      else {
        ownerclass.classLocalSlots.substitute(newslot, oldslot);
        HookList.runHooks(Stella.$REDEFINE_RELATION_HOOKS$, List.list(Cons.cons(oldslot, Cons.cons(newslot, Stella.NIL))));
        oldslot.free();
        Stella_Class.helpUnfinalizeClassSlots(ownerclass);
        return (newslot);
      }
    }
  }

  public static void transferExternalSlotToNewClass(Slot externalslot, Stella_Class newclass) {
    { Slot newclassslot = Stella_Class.lookupLocalSlot(newclass, externalslot.slotName);

      if (newclassslot == null) {
        newclass.classLocalSlots.insert(externalslot);
      }
      else if (Slot.inlineMethodP(newclassslot) ||
          ((!(newclassslot.primaryType() == externalslot.primaryType())) ||
           false)) {
      }
      else {
        newclass.classLocalSlots.substitute(externalslot, newclassslot);
        newclassslot.free();
      }
    }
  }

  public static boolean inlineMethodP(Slot slot) {
    return ((!slot.slotExternalP) &&
        (Stella_Object.isaP(slot, Stella.SGT_STELLA_METHOD_SLOT) &&
         (!((MethodSlot)(slot)).methodFunctionP)));
  }

  public static boolean filterSlotP(Slot self, AllPurposeIterator iterator) {
    { boolean alwaysP000 = true;

      { FunctionCodeWrapper filter = null;
        Cons iter000 = ((Cons)(iterator.iteratorObject));

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          filter = ((FunctionCodeWrapper)(iter000.value));
          if (!((Boolean)(edu.isi.stella.javalib.Native.funcall(filter.wrapperValue, null, new java.lang.Object [] {self, iterator}))).booleanValue()) {
            alwaysP000 = false;
            break loop000;
          }
        }
      }
      { boolean value000 = alwaysP000;

        return (value000);
      }
    }
  }

  public static boolean filterNonAuxiliarySlotP(Slot self, AllPurposeIterator iterator) {
    iterator = iterator;
    return (!((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_AUXILIARYp, Stella.FALSE_WRAPPER))).wrapperValue);
  }

  public static boolean filterNonParameterSlotP(Slot self, AllPurposeIterator iterator) {
    iterator = iterator;
    return (!((Stella_Class)(self.slotOwner.surrogateValue)).classParameters().memberP(self.slotName));
  }

  public static boolean filterNonExternalSlotP(Slot self, AllPurposeIterator iterator) {
    iterator = iterator;
    return (!self.slotExternalP);
  }

  public static boolean filterPublicMethodSlotP(Slot self, AllPurposeIterator iterator) {
    iterator = iterator;
    return (self.slotPublicP &&
        Stella_Object.methodSlotP(self));
  }

  public static boolean filterMethodSlotP(Slot self, AllPurposeIterator iterator) {
    iterator = iterator;
    return (Stella_Object.methodSlotP(self));
  }

  public static boolean filterPrivateSlotP(Slot self, AllPurposeIterator iterator) {
    iterator = iterator;
    return (!self.slotPublicP);
  }

  public static boolean filterPublicSlotP(Slot self, AllPurposeIterator iterator) {
    iterator = iterator;
    return (self.slotPublicP);
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { Slot self = this;

      stream.print("|S|" + self.slotOwner.symbolName + "." + self.slotName.symbolName);
    }
  }

  public static Stella_Object accessSlotSlotValue(Slot self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_SLOT_NAME) {
      if (setvalueP) {
        self.slotName = ((Symbol)(value));
      }
      else {
        value = self.slotName;
      }
    }
    else if (slotname == Stella.SYM_STELLA_SLOT_OWNER) {
      if (setvalueP) {
        self.slotOwner = ((Surrogate)(value));
      }
      else {
        value = self.slotOwner;
      }
    }
    else if (slotname == Stella.SYM_STELLA_SLOT_BASE_TYPE) {
      if (setvalueP) {
        self.slotBaseType = ((Surrogate)(value));
      }
      else {
        value = self.slotBaseType;
      }
    }
    else if (slotname == Stella.SYM_STELLA_SLOT_SLOTREF) {
      if (setvalueP) {
        self.slotSlotref = ((Surrogate)(value));
      }
      else {
        value = self.slotSlotref;
      }
    }
    else if (slotname == Stella.SYM_STELLA_SLOT_DIRECT_SUPERS) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_DIRECT_SUPERS, ((List)(value)), null);
      }
      else {
        value = self.slotDirectSupers();
      }
    }
    else if (slotname == Stella.SYM_STELLA_SLOT_DIRECT_SUBS) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_DIRECT_SUBS, ((List)(value)), null);
      }
      else {
        value = self.slotDirectSubs();
      }
    }
    else if (slotname == Stella.SYM_STELLA_SLOT_PUBLICp) {
      if (setvalueP) {
        self.slotPublicP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.slotPublicP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_SLOT_RENAMEDp) {
      if (setvalueP) {
        self.slotRenamedP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.slotRenamedP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_SLOT_EXTERNALp) {
      if (setvalueP) {
        self.slotExternalP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.slotExternalP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_SLOT_MARKEDp) {
      if (setvalueP) {
        self.slotMarkedP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.slotMarkedP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else {
      if (slotname == Stella.SYM_STELLA_SLOT_DOCUMENTATION) {
        slotname = Stella.SYM_STELLA_DOCUMENTATION;
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

  public List slotDirectSubs() {
    { Slot self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_DIRECT_SUBS, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public List slotDirectSupers() {
    { Slot self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_DIRECT_SUPERS, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public Keyword closureAssumption() {
    { Slot self = this;

      { Slot cursor = self;
        Keyword value = ((Keyword)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_SLOT_CLOSURE_ASSUMPTION, null)));

        for (;;) {
          if (value != null) {
            return (value);
          }
          cursor = cursor.slotDirectEquivalent;
          if (cursor != null) {
            value = ((Keyword)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_SLOT_CLOSURE_ASSUMPTION, null)));
          }
          else {
            return (null);
          }
        }
      }
    }
  }

  /** True if slot values are collections.
   * @return boolean
   */
  public boolean collectionValuedP() {
    { Slot self = this;

      return (Surrogate.subtypeOfP(self.slotBaseType, Stella.SGT_STELLA_COLLECTION));
    }
  }

  public Symbol renames() {
    { Slot self = this;

      return (((Symbol)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_RENAMES, null))));
    }
  }

  public Module homeModule() {
    { Slot self = this;

      { Module module = ((Module)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_HOME_MODULE, null)));

        if (module != null) {
          return (module);
        }
        else {
          return (((Module)(self.slotName.homeContext)));
        }
      }
    }
  }

  public Surrogate owner() {
    { Slot self = this;

      return (self.slotOwner);
    }
  }

  /** If <code>self</code> has a complex type return its
   * type specifier, otherwise, return <code>type</code> of <code>self</code>.
   * @return StandardObject
   */
  public StandardObject typeSpecifier() {
    { Slot self = this;

      { CompoundTypeSpecifier tspec = ((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null)));

        return (((tspec != null) ? ((StandardObject)(tspec)) : ((StandardObject)(self.type()))));
      }
    }
  }

  /** The type of a storage slot is its base type.
   * @return Surrogate
   */
  public Surrogate type() {
    { Slot self = this;

      { Slot cursor = self;
        Surrogate value = cursor.slotBaseType;

        for (;;) {
          if (value != null) {
            return (value);
          }
          cursor = cursor.slotDirectEquivalent;
          if (cursor != null) {
            value = cursor.slotBaseType;
          }
          else {
            return (null);
          }
        }
      }
    }
  }

  public String name() {
    { Slot self = this;

      return (self.slotName.symbolName);
    }
  }

}

