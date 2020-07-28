//  -*- Mode: Java -*-
//
// ParametricTypeSpecifier.java

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

public class ParametricTypeSpecifier extends CompoundTypeSpecifier {
    public Surrogate specifierBaseType;
    public List specifierParameterTypes;
    public List specifierDimensions;

  public static ParametricTypeSpecifier newParametricTypeSpecifier() {
    { ParametricTypeSpecifier self = null;

      self = new ParametricTypeSpecifier();
      self.specifierDimensions = null;
      self.specifierParameterTypes = List.newList();
      self.specifierBaseType = null;
      return (self);
    }
  }

  public static StringWrapper javaTranslateArrayType(ParametricTypeSpecifier arraytype) {
    { List dimensions = ParametricTypeSpecifier.arrayTypeDimensions(arraytype);
      StandardObject elementtype = StandardObject.extractParameterType(arraytype, Stella.SYM_STELLA_ANY_VALUE, new Object[1]);
      String translatedtype = StandardObject.javaTranslateTypeSpec(elementtype).wrapperValue;

      switch (dimensions.length()) {
        case 1: 
          return (StringWrapper.wrapString(translatedtype + "[]"));
        case 2: 
          return (StringWrapper.wrapString(translatedtype + "[][]"));
        case 3: 
          return (StringWrapper.wrapString(translatedtype + "[][][]"));
        default:
          { IntegerWrapper unusedDim = null;
            Cons iter000 = dimensions.theConsList;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              unusedDim = ((IntegerWrapper)(iter000.value));
              unusedDim = unusedDim;
              translatedtype = translatedtype + "[]";
            }
          }
          return (StringWrapper.wrapString(translatedtype));
      }
    }
  }

  public static StringWrapper cppTranslateArrayType(ParametricTypeSpecifier arraytype) {
    { List dimensions = ParametricTypeSpecifier.arrayTypeDimensions(arraytype);
      StandardObject elementtype = StandardObject.extractParameterType(arraytype, Stella.SYM_STELLA_ANY_VALUE, new Object[1]);
      String translatedtype = "";
      String temp = null;

      if (dimensions.length() == 1) {
        return (StringWrapper.wrapString(StandardObject.cppTranslateAndPointerizeTypeSpec(elementtype).wrapperValue + "*"));
      }
      { IntegerWrapper dim = null;
        Cons iter000 = dimensions.theConsList;
        int i = Stella.NULL_INTEGER;
        int iter001 = 0;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
          dim = ((IntegerWrapper)(iter000.value));
          i = iter001;
          if (i == 0) {
            temp = "(*)";
          }
          else if (dim == null) {
            temp = "[]";
          }
          else {
            temp = "[" + Native.stringify(dim) + "]";
          }
          translatedtype = translatedtype + temp;
        }
      }
      if (StandardObject.arrayTypeSpecifierP(elementtype)) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Can't yet handle nested arrays in C++: `" + Stella_Object.deUglifyParseTree(arraytype) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        elementtype = Stella.SGT_STELLA_UNKNOWN;
      }
      temp = StandardObject.cppTranslateAndPointerizeTypeSpec(elementtype).wrapperValue;
      translatedtype = temp + " " + translatedtype;
      return (StringWrapper.wrapString(translatedtype));
    }
  }

  public static void evaluateArrayArgumentValue(ParametricTypeSpecifier arraytype, List requiredvalues, Slot slot, Stella_Object valueref) {
    if (slot.slotName == Stella.SYM_STELLA_SIZE) {
      { Stella_Object dim = null;
        Cons iter000 = ((Cons)(valueref));
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          dim = iter000.value;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Stella_Object.walkExpressionTree(dim, Stella.SGT_STELLA_INTEGER, Stella.SYM_STELLA_NEW, false, new Object[1]), Stella.NIL);
              if (requiredvalues.theConsList == Stella.NIL) {
                requiredvalues.theConsList = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(requiredvalues.theConsList, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Stella_Object.walkExpressionTree(dim, Stella.SGT_STELLA_INTEGER, Stella.SYM_STELLA_NEW, false, new Object[1]), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
    }
    else {
      requiredvalues.insertLast(Stella_Object.walkExpressionTree(valueref, slot.computeReturnTypeSpec(arraytype), Stella.SYM_STELLA_NEW, false, new Object[1]));
    }
  }

  public static void preprocessArrayArguments(ParametricTypeSpecifier arraytype, PropertyList slotsandvalues) {
    { Stella_Class arrayclass = ((Stella_Class)(arraytype.specifierBaseType.surrogateValue));
      List arraydimensions = ParametricTypeSpecifier.arrayTypeDimensions(arraytype);
      int arrayrank = arraydimensions.length();
      Slot initialelementslot = Stella_Class.lookupSlot(arrayclass, Stella.SYM_STELLA_INITIAL_ELEMENT);
      Stella_Object initialelementref = slotsandvalues.lookup(initialelementslot);
      Slot arraysizeslot = Stella_Class.lookupSlot(arrayclass, Stella.SYM_STELLA_SIZE);
      Stella_Object sizeref = slotsandvalues.lookup(arraysizeslot);
      boolean nonlistsizeP = false;

      if (sizeref == null) {
        if (!ParametricTypeSpecifier.indefiniteArrayTypeP(arraytype)) {
          sizeref = ParametricTypeSpecifier.arrayTypeDimensions(arraytype).theConsList;
        }
      }
      if (sizeref == null) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Missing array :size argument in NEW expression.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
      }
      else {
        if (Stella_Object.safePrimaryType(sizeref) == Stella.SGT_STELLA_CONS) {
          { Cons sizeref000 = ((Cons)(sizeref));

            if ((arrayrank == 1) &&
                ((!(sizeref000.length() == 1)) ||
                 (Stella_Object.symbolP(sizeref000.value) &&
                  ((Symbol.lookupFunction(((Symbol)(sizeref000.value))) != null) ||
                   (Symbol.lookupMacro(((Symbol)(sizeref000.value))) != null))))) {
              nonlistsizeP = true;
            }
          }
        }
        else {
          nonlistsizeP = true;
        }
        if (nonlistsizeP) {
          sizeref = Cons.cons(sizeref, Stella.NIL);
        }
        if (!(((Cons)(sizeref)).length() == arrayrank)) {
          { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              Stella.signalTranslationError();
              if (!(Stella.suppressWarningsP())) {
                Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                {
                  Stella.STANDARD_ERROR.nativeStream.println();
                  Stella.STANDARD_ERROR.nativeStream.println(" Array :size initializer `" + Stella_Object.deUglifyParseTree(sizeref) + "'");
                  Stella.STANDARD_ERROR.nativeStream.println("   doesn't match the rank of");
                  Stella.STANDARD_ERROR.nativeStream.println("   `" + Stella_Object.deUglifyParseTree(arraytype) + "'.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
            }
          }
          sizeref = null;
        }
        else {
          { ConsIterator sizeit = ((Cons)(sizeref)).allocateIterator();
            ListIterator dimit = ((ListIterator)(arraydimensions.allocateIterator()));
            int dim = Stella.NULL_INTEGER;
            int iter000 = 0;

            for (;sizeit.nextP() &&
                      dimit.nextP(); iter000 = iter000 + 1) {
              dim = iter000;
              if (((IntegerWrapper)(dimit.value)) == null) {
                if (Stella_Object.integerP(sizeit.value)) {
                  dimit.valueSetter(((IntegerWrapper)(sizeit.value)));
                }
              }
              else if (!Stella_Object.eqlP(((IntegerWrapper)(dimit.value)), sizeit.value)) {
                { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationError();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                      {
                        Stella.STANDARD_ERROR.nativeStream.println();
                        Stella.STANDARD_ERROR.nativeStream.println(" Array :size initializer `" + sizeit.value + "' doesn't match array dimension `" + Stella_Object.deUglifyParseTree(IntegerWrapper.wrapInteger(dim)) + "' of");
                        Stella.STANDARD_ERROR.nativeStream.println("   `" + Stella_Object.deUglifyParseTree(arraytype) + "'.");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
                  }
                }
                sizeit.valueSetter(((IntegerWrapper)(dimit.value)));
              }
            }
          }
        }
      }
      slotsandvalues.insertAt(initialelementslot, initialelementref);
      if (sizeref != null) {
        slotsandvalues.insertAt(arraysizeslot, sizeref);
      }
      else {
        slotsandvalues.removeAt(arraysizeslot);
      }
    }
  }

  public static void warnOfParameterMismatch(ParametricTypeSpecifier self, String message) {
    { Cons inheritedtypes = Stella_Class.yieldClassParameterTypes(((Stella_Class)(self.specifierBaseType.surrogateValue)));

      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: `" + message + "'");
            Stella.STANDARD_WARNING.nativeStream.println("Type `" + self.specifierBaseType + "' takes parameters of type ");
            Stella.STANDARD_WARNING.nativeStream.println("`" + inheritedtypes + "' but was modified by a list of types `" + self.specifierParameterTypes.theConsList + "'");
          }
;

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
    }
  }

  public static boolean indefiniteArrayTypeP(ParametricTypeSpecifier arraytype) {
    { List dimensions = arraytype.specifierDimensions;

      if (dimensions == null) {
        return (true);
      }
      else {
        { Stella_Object dim = null;
          Cons iter000 = dimensions.theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            dim = iter000.value;
            if (dim == null) {
              return (true);
            }
          }
        }
      }
      return (false);
    }
  }

  public static List arrayTypeDimensions(ParametricTypeSpecifier arraytype) {
    return (((List)(arraytype.specifierDimensions)));
  }

  public static int arrayTypeRank(ParametricTypeSpecifier arraytype) {
    { List dimensions = arraytype.specifierDimensions;

      if (dimensions == null) {
        return (Stella.NULL_INTEGER);
      }
      else {
        return (dimensions.length());
      }
    }
  }

  public static Cons yieldArrayDimensionsTree(ParametricTypeSpecifier arraytype) {
    { List dimensions = arraytype.specifierDimensions;
      Cons result = Stella.NIL;

      if (dimensions == null) {
        return (null);
      }
      { Stella_Object dim = null;
        Cons iter000 = dimensions.theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          dim = iter000.value;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(((dim == null) ? Stella.NIL : Cons.cons(dim, Stella.NIL)), Stella.NIL);
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
              collect000.rest = Cons.cons(((dim == null) ? Stella.NIL : Cons.cons(dim, Stella.NIL)), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      if (result.length() == 1) {
        return (((Cons)(result.value)));
      }
      else {
        return (result);
      }
    }
  }

  public StandardObject yieldTypeSpecifier() {
    { ParametricTypeSpecifier typespectree = this;

      return (typespectree);
    }
  }

  public static Stella_Object accessParametricTypeSpecifierSlotValue(ParametricTypeSpecifier self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_SPECIFIER_BASE_TYPE) {
      if (setvalueP) {
        self.specifierBaseType = ((Surrogate)(value));
      }
      else {
        value = self.specifierBaseType;
      }
    }
    else if (slotname == Stella.SYM_STELLA_SPECIFIER_PARAMETER_TYPES) {
      if (setvalueP) {
        self.specifierParameterTypes = ((List)(value));
      }
      else {
        value = self.specifierParameterTypes;
      }
    }
    else if (slotname == Stella.SYM_STELLA_SPECIFIER_DIMENSIONS) {
      if (setvalueP) {
        self.specifierDimensions = ((List)(value));
      }
      else {
        value = self.specifierDimensions;
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
    { ParametricTypeSpecifier self = this;

      return (Stella.SGT_STELLA_PARAMETRIC_TYPE_SPECIFIER);
    }
  }

}

