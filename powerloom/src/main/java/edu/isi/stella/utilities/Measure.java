//  -*- Mode: Java -*-
//
// Measure.java

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
| Portions created by the Initial Developer are Copyright (C) 2001-2017      |
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

package edu.isi.stella.utilities;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.stella.*;

public class Measure extends StandardObject {
    public String baseUnit;
    public KeyValueList scale;
    public Ratio primeId;
    public String name;

  public static Measure lookupMeasureForUnit(String unit) {
    return (((Measure)(Utilities.$UNIT_TO_MEASURE_TABLE$.lookup(unit))));
  }

  public static Measure lookupMeasure(String name) {
    return (((Measure)(Utilities.$NAME_TO_MEASURE_TABLE$.lookup(name))));
  }

  public static Measure defineDimensionlessMeasure() {
    { Measure self000 = Measure.newMeasure();

      self000.name = "Dimensionless";
      self000.baseUnit = "";
      self000.primeId = Utilities.$RATIO_ONE$;
      { Measure m = self000;

        m.scale.insertAt(StringWrapper.wrapString(""), FloatWrapper.wrapFloat(1.0));
        Utilities.$BASE_MEASURES$ = ((Cons)((Utilities.$BASE_MEASURES$.memberP(m) ? Utilities.$BASE_MEASURES$ : Cons.cons(m, Utilities.$BASE_MEASURES$))));
        m.setupIndices();
        return (m);
      }
    }
  }

  public static Measure defineDerivedMeasure(String measureName, String measureBaseUnit, String definition) {
    { double scaleFactor = Stella.NULL_FLOAT;
      Ratio id = null;

      { Object [] caller_MV_returnarray = new Object[1];

        scaleFactor = Utilities.unitToScaleFactorAndId(definition, caller_MV_returnarray);
        id = ((Ratio)(caller_MV_returnarray[0]));
      }
      { Measure self000 = Measure.newMeasure();

        self000.name = measureName;
        self000.baseUnit = measureBaseUnit;
        self000.primeId = id;
        { Measure m = self000;

          m.scale.insertAt(StringWrapper.wrapString(measureBaseUnit), FloatWrapper.wrapFloat(scaleFactor));
          m.setupIndices();
          return (m);
        }
      }
    }
  }

  public static Measure defineBaseMeasure(String measureName, String measureBaseUnit) {
    { int prime = Utilities.nextPrimeId();

      { Measure self000 = Measure.newMeasure();

        self000.name = measureName;
        self000.baseUnit = measureBaseUnit;
        self000.primeId = Ratio.makeRatio(prime, 1);
        { Measure m = self000;

          m.scale.insertAt(StringWrapper.wrapString(measureBaseUnit), FloatWrapper.wrapFloat(1.0));
          Utilities.$PRIME_TO_BASE_MEASURE_TABLE$.insertAt(prime, m);
          Utilities.$BASE_MEASURES$ = ((Cons)((Utilities.$BASE_MEASURES$.memberP(m) ? Utilities.$BASE_MEASURES$ : Cons.cons(m, Utilities.$BASE_MEASURES$))));
          m.setupIndices();
          return (m);
        }
      }
    }
  }

  public static Measure newMeasure() {
    { Measure self = null;

      self = new Measure();
      self.name = null;
      self.primeId = null;
      self.scale = KeyValueList.newKeyValueList();
      self.baseUnit = null;
      return (self);
    }
  }

  public List getUnits() {
    { Measure self = this;

      { List result = List.newList();

        { StringWrapper key = null;
          FloatWrapper unused = null;
          KvListIterator iter000 = ((KvListIterator)(self.scale.allocateIterator()));
          Cons collect000 = null;

          while (iter000.nextP()) {
            key = ((StringWrapper)(iter000.key));
            unused = ((FloatWrapper)(iter000.value));
            unused = unused;
            if (collect000 == null) {
              {
                collect000 = Cons.cons(key, Stella.NIL);
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
                collect000.rest = Cons.cons(key, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        return (result);
      }
    }
  }

  public void addUnit(String unitName, double scaleFactor, String definition) {
    { Measure self = this;

      { double definitionFactor = Stella.NULL_FLOAT;
        Ratio id = null;

        { Object [] caller_MV_returnarray = new Object[1];

          definitionFactor = Utilities.unitToScaleFactorAndId(definition, caller_MV_returnarray);
          id = ((Ratio)(caller_MV_returnarray[0]));
        }
        if (Stella_Object.eqlP(id, self.primeId)) {
          {
            self.scale.insertAt(StringWrapper.wrapString(unitName), FloatWrapper.wrapFloat(scaleFactor * definitionFactor));
            Utilities.$UNIT_TO_MEASURE_TABLE$.insertAt(unitName, self);
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("Unit `" + unitName + "' has a definition `" + definition + "' that is not compatible with Measure `" + self.name + "'");
            throw ((IncompatibleUnitsException)(IncompatibleUnitsException.newIncompatibleUnitsException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  /** Returns <code>true</code> if <code>m</code> is a base measure.
   * @return boolean
   */
  public boolean baseMeasureP() {
    { Measure m = this;

      return (Utilities.$BASE_MEASURES$.memberP(m));
    }
  }

  public void setupIndices() {
    { Measure m = this;

      Utilities.$ALL_MEASURES$ = ((Cons)((Utilities.$ALL_MEASURES$.memberP(m) ? Utilities.$ALL_MEASURES$ : Cons.cons(m, Utilities.$ALL_MEASURES$))));
      Utilities.$PRIME_TO_MEASURE_TABLE$.insertAt(m.primeId, m);
      Utilities.$NAME_TO_MEASURE_TABLE$.insertAt(m.name, m);
      Utilities.$UNIT_TO_MEASURE_TABLE$.insertAt(m.baseUnit, m);
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { Measure self = this;

      stream.print("<Measure " + self.name + "(" + self.baseUnit + ")>");
    }
  }

  public static Stella_Object accessMeasureSlotValue(Measure self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Utilities.SYM_UTILITIES_BASE_UNIT) {
      if (setvalueP) {
        self.baseUnit = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.baseUnit);
      }
    }
    else if (slotname == Utilities.SYM_UTILITIES_SCALE) {
      if (setvalueP) {
        self.scale = ((KeyValueList)(value));
      }
      else {
        value = self.scale;
      }
    }
    else if (slotname == Utilities.SYM_UTILITIES_PRIME_ID) {
      if (setvalueP) {
        self.primeId = ((Ratio)(value));
      }
      else {
        value = self.primeId;
      }
    }
    else if (slotname == Utilities.SYM_STELLA_NAME) {
      if (setvalueP) {
        self.name = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.name);
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
    { Measure self = this;

      return (Utilities.SGT_UTILITIES_MEASURE);
    }
  }

}

