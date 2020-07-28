//  -*- Mode: Java -*-
//
// Demon.java

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

public class Demon extends StandardObject {
    public String demonName;
    public Keyword demonAction;
    public List demonClassRefs;
    public List demonSlotRefs;
    public java.lang.reflect.Method demonCode;
    public MethodSlot demonMethod;
    public String demonDocumentation;
    public boolean demonGuardP;
    public boolean demonAllP;
    public boolean demonInheritP;

  public static Demon newDemon() {
    { Demon self = null;

      self = new Demon();
      self.demonInheritP = false;
      self.demonAllP = false;
      self.demonGuardP = false;
      self.demonDocumentation = null;
      self.demonMethod = null;
      self.demonCode = null;
      self.demonSlotRefs = List.newList();
      self.demonClassRefs = List.newList();
      self.demonAction = null;
      self.demonName = null;
      return (self);
    }
  }

  /** Detach <code>demon</code> from the location(s) specified by its internal
   * structure.
   * @param demon
   */
  public static void deactivateDemon(Demon demon) {
    if (demon == null) {
      return;
    }
    { Keyword testValue000 = demon.demonAction;

      if (testValue000 == Stella.KWD_MODIFY) {
        if (demon.demonAllP) {
          if (demon.demonGuardP) {
            Stella.$ALL_SLOTS_GUARD_DEMONS$ = List.ejectDemon(Stella.$ALL_SLOTS_GUARD_DEMONS$, demon);
          }
          else {
            Stella.$ALL_SLOTS_DEMONS$ = List.ejectDemon(Stella.$ALL_SLOTS_DEMONS$, demon);
          }
        }
        else {
          { Surrogate type = null;
            Cons iter000 = demon.demonClassRefs.theConsList;
            Symbol slotname = null;
            Cons iter001 = demon.demonSlotRefs.theConsList;

            loop000 : for (;(!(iter000 == Stella.NIL)) &&
                      (!(iter001 == Stella.NIL)); iter000 = iter000.rest, iter001 = iter001.rest) {
              type = ((Surrogate)(iter000.value));
              slotname = ((Symbol)(iter001.value));
              { StorageSlot slot = ((StorageSlot)(Stella_Class.lookupSlot(((Stella_Class)(type.surrogateValue)), slotname)));

                if (slot == null) {
                  Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't remove demon from non-existant slot `" + ((Stella_Class)(type.surrogateValue)) + "'.`" + slotname + "'");
                  continue loop000;
                }
                if (demon.demonGuardP) {
                  KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_GUARD_DEMONS, List.ejectDemon(slot.slotGuardDemons(), demon), null);
                }
                else {
                  KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_DEMONS, List.ejectDemon(slot.slotDemons(), demon), null);
                }
              }
            }
          }
        }
      }
      else if (testValue000 == Stella.KWD_CREATE) {
        if (demon.demonAllP) {
          Stella.$CONSTRUCTOR_DEMONS$ = List.ejectDemon(Stella.$CONSTRUCTOR_DEMONS$, demon);
        }
        else {
          { Surrogate classref = null;
            Cons iter002 = demon.demonClassRefs.theConsList;

            loop001 : for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
              classref = ((Surrogate)(iter002.value));
              { Stella_Class renamed_Class = ((Stella_Class)(classref.surrogateValue));

                if (renamed_Class == null) {
                  Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't install demon on non-existant class `" + classref + "'");
                  continue loop001;
                }
                if (demon.demonGuardP) {
                  KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_GUARD_CONSTRUCTOR_DEMONS, List.ejectDemon(renamed_Class.classGuardConstructorDemons(), demon), null);
                }
                else {
                  KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_CONSTRUCTOR_DEMONS, List.ejectDemon(renamed_Class.classConstructorDemons(), demon), null);
                }
              }
            }
          }
        }
      }
      else if (testValue000 == Stella.KWD_DESTROY) {
        if (demon.demonAllP) {
          Stella.$DESTRUCTOR_DEMONS$ = List.ejectDemon(Stella.$DESTRUCTOR_DEMONS$, demon);
        }
        else {
          { Surrogate classref = null;
            Cons iter003 = demon.demonClassRefs.theConsList;

            loop002 : for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
              classref = ((Surrogate)(iter003.value));
              { Stella_Class renamed_Class = ((Stella_Class)(classref.surrogateValue));

                if (renamed_Class == null) {
                  Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't install demon on non-existant class `" + classref + "'");
                  continue loop002;
                }
                if (demon.demonGuardP) {
                  KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_GUARD_DESTRUCTOR_DEMONS, List.ejectDemon(renamed_Class.classGuardDestructorDemons(), demon), null);
                }
                else {
                  KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_DESTRUCTOR_DEMONS, List.ejectDemon(renamed_Class.classDestructorDemons(), demon), null);
                }
              }
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
  }

  /** Install <code>demon</code> in the location(s) specified by its internal
   * structure.
   * @param demon
   */
  public static void activateDemon(Demon demon) {
    if (demon == null) {
      return;
    }
    { Keyword testValue000 = demon.demonAction;

      if (testValue000 == Stella.KWD_MODIFY) {
        if (demon.demonAllP) {
          if (demon.demonGuardP) {
            Stella.$ALL_SLOTS_GUARD_DEMONS$ = List.injectDemon(Stella.$ALL_SLOTS_GUARD_DEMONS$, demon);
          }
          else {
            Stella.$ALL_SLOTS_DEMONS$ = List.injectDemon(Stella.$ALL_SLOTS_DEMONS$, demon);
          }
        }
        else {
          { Surrogate type = null;
            Cons iter000 = demon.demonClassRefs.theConsList;
            Symbol slotname = null;
            Cons iter001 = demon.demonSlotRefs.theConsList;

            loop000 : for (;(!(iter000 == Stella.NIL)) &&
                      (!(iter001 == Stella.NIL)); iter000 = iter000.rest, iter001 = iter001.rest) {
              type = ((Surrogate)(iter000.value));
              slotname = ((Symbol)(iter001.value));
              { StorageSlot slot = ((StorageSlot)(Stella_Class.lookupSlot(((Stella_Class)(type.surrogateValue)), slotname)));

                if (slot == null) {
                  Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't install demon on non-existant slot `" + ((Stella_Class)(type.surrogateValue)) + "'.`" + slotname + "'");
                  continue loop000;
                }
                if (demon.demonGuardP) {
                  KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_GUARD_DEMONS, List.injectDemon(slot.slotGuardDemons(), demon), null);
                }
                else {
                  KeyValueList.setDynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_DEMONS, List.injectDemon(slot.slotDemons(), demon), null);
                }
              }
            }
          }
        }
      }
      else if (testValue000 == Stella.KWD_CREATE) {
        if (demon.demonAllP) {
          Stella.$CONSTRUCTOR_DEMONS$ = List.injectDemon(Stella.$CONSTRUCTOR_DEMONS$, demon);
        }
        else {
          { Surrogate classref = null;
            Cons iter002 = demon.demonClassRefs.theConsList;

            loop001 : for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
              classref = ((Surrogate)(iter002.value));
              { Stella_Class renamed_Class = ((Stella_Class)(classref.surrogateValue));

                if (renamed_Class == null) {
                  Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't install demon on non-existant class `" + classref + "'");
                  continue loop001;
                }
                if (demon.demonGuardP) {
                  KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_GUARD_CONSTRUCTOR_DEMONS, List.injectDemon(renamed_Class.classGuardConstructorDemons(), demon), null);
                }
                else {
                  KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_CONSTRUCTOR_DEMONS, List.injectDemon(renamed_Class.classConstructorDemons(), demon), null);
                }
              }
            }
          }
        }
      }
      else if (testValue000 == Stella.KWD_DESTROY) {
        if (demon.demonAllP) {
          Stella.$DESTRUCTOR_DEMONS$ = List.injectDemon(Stella.$DESTRUCTOR_DEMONS$, demon);
        }
        else {
          { Surrogate classref = null;
            Cons iter003 = demon.demonClassRefs.theConsList;

            loop002 : for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
              classref = ((Surrogate)(iter003.value));
              { Stella_Class renamed_Class = ((Stella_Class)(classref.surrogateValue));

                if (renamed_Class == null) {
                  Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't install demon on non-existant class `" + classref + "'");
                  continue loop002;
                }
                if (demon.demonGuardP) {
                  KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_GUARD_DESTRUCTOR_DEMONS, List.injectDemon(renamed_Class.classGuardDestructorDemons(), demon), null);
                }
                else {
                  KeyValueList.setDynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_DESTRUCTOR_DEMONS, List.injectDemon(renamed_Class.classDestructorDemons(), demon), null);
                }
              }
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
  }

  public static boolean incorporateDemonOptionsP(Demon demon, PropertyList options) {
    if (options.lookup(Stella.KWD_CREATE) != null) {
      demon.demonAction = Stella.KWD_CREATE;
    }
    else if (options.lookup(Stella.KWD_DESTROY) != null) {
      demon.demonAction = Stella.KWD_DESTROY;
    }
    else {
      demon.demonAction = Stella.KWD_MODIFY;
    }
    { Stella_Object k = null;
      Stella_Object v = null;
      Cons iter000 = options.thePlist;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
        k = iter000.value;
        v = iter000.rest.value;
        { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(k));

          if ((testValue000 == Stella.KWD_CREATE) ||
              (testValue000 == Stella.KWD_DESTROY)) {
            demon.demonAction = ((Keyword)(k));
            if (v == Stella.KWD_ALL) {
              demon.demonAllP = true;
            }
            else {
              demon.demonClassRefs.insert(v.surrogatify());
            }
          }
          else if (testValue000 == Stella.KWD_CLASS) {
            demon.demonClassRefs.insert(v.surrogatify());
          }
          else if (testValue000 == Stella.KWD_SLOT) {
            if (v == Stella.KWD_ALL) {
              demon.demonAllP = true;
            }
            else {
              demon.demonSlotRefs.insert(((Symbol)(v.permanentify())));
            }
          }
          else if (testValue000 == Stella.KWD_CODE) {
            demon.demonCode = ((FunctionCodeWrapper)(v)).wrapperValue;
          }
          else if (testValue000 == Stella.KWD_METHOD) {
            demon.demonMethod = ((MethodSlot)(v));
          }
          else if (testValue000 == Stella.KWD_GUARDp) {
            demon.demonGuardP = true;
          }
          else if (testValue000 == Stella.KWD_INHERITEDp) {
            demon.demonInheritP = true;
            Stella.STANDARD_OUTPUT.nativeStream.println("Inherit? not yet implemented for demons");
          }
          else if (testValue000 == Stella.KWD_DOCUMENTATION) {
            demon.demonDocumentation = ((StringWrapper)(v)).wrapperValue;
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
    if (demon.demonMethod != null) {
      demon.demonCode = demon.demonMethod.functionCode;
    }
    options.free();
    return (Demon.validateDemonReferencesP(demon));
  }

  public static boolean validateDemonReferencesP(Demon demon) {
    { Surrogate classref = ((demon.demonClassRefs != null) ? ((Surrogate)(demon.demonClassRefs.first())) : ((Surrogate)(null)));
      Symbol slotref = ((demon.demonSlotRefs != null) ? ((Symbol)(demon.demonSlotRefs.first())) : ((Symbol)(null)));
      Slot slot = null;

      if ((classref == null) &&
          (slotref == null)) {
        return (true);
      }
      if (classref == null) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Missing :class option in demon `" + demon + "'");
        return (false);
      }
      if (((Stella_Class)(classref.surrogateValue)) == null) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Class `" + classref + "' not yet defined.");
        return (false);
      }
      if (demon.demonAction == Stella.KWD_MODIFY) {
        if (slotref == null) {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: Missing :slot option in demon `" + demon + "'");
          return (false);
        }
        { boolean testValue000 = false;

          { 
            slot = Stella_Class.lookupSlot(((Stella_Class)(classref.surrogateValue)), slotref);
            testValue000 = slot != null;
          }
          testValue000 = !testValue000;
          if (testValue000) {
            {
              Stella.STANDARD_WARNING.nativeStream.println("Warning: No slot named `" + slotref + "' exists on class `" + ((Stella_Class)(classref.surrogateValue)) + "'.");
              Stella.STANDARD_WARNING.nativeStream.println("Can't create demon `" + demon + "'");
            }
;
            return (false);
          }
        }
        if (!Stella_Object.storageSlotP(slot)) {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't install a demon on the method.`" + slot + "'");
          return (false);
        }
      }
      return (true);
    }
  }

  public static Stella_Object accessDemonSlotValue(Demon self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_DEMON_NAME) {
      if (setvalueP) {
        self.demonName = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.demonName);
      }
    }
    else if (slotname == Stella.SYM_STELLA_DEMON_ACTION) {
      if (setvalueP) {
        self.demonAction = ((Keyword)(value));
      }
      else {
        value = self.demonAction;
      }
    }
    else if (slotname == Stella.SYM_STELLA_DEMON_CLASS_REFS) {
      if (setvalueP) {
        self.demonClassRefs = ((List)(value));
      }
      else {
        value = self.demonClassRefs;
      }
    }
    else if (slotname == Stella.SYM_STELLA_DEMON_SLOT_REFS) {
      if (setvalueP) {
        self.demonSlotRefs = ((List)(value));
      }
      else {
        value = self.demonSlotRefs;
      }
    }
    else if (slotname == Stella.SYM_STELLA_DEMON_CODE) {
      if (setvalueP) {
        self.demonCode = ((FunctionCodeWrapper)(value)).wrapperValue;
      }
      else {
        value = FunctionCodeWrapper.wrapFunctionCode(self.demonCode);
      }
    }
    else if (slotname == Stella.SYM_STELLA_DEMON_METHOD) {
      if (setvalueP) {
        self.demonMethod = ((MethodSlot)(value));
      }
      else {
        value = self.demonMethod;
      }
    }
    else if (slotname == Stella.SYM_STELLA_DEMON_DOCUMENTATION) {
      if (setvalueP) {
        self.demonDocumentation = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.demonDocumentation);
      }
    }
    else if (slotname == Stella.SYM_STELLA_DEMON_GUARDp) {
      if (setvalueP) {
        self.demonGuardP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.demonGuardP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_DEMON_ALLp) {
      if (setvalueP) {
        self.demonAllP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.demonAllP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_DEMON_INHERITp) {
      if (setvalueP) {
        self.demonInheritP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.demonInheritP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
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
    { Demon self = this;

      return (Stella.SGT_STELLA_DEMON);
    }
  }

}

