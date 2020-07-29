//  -*- Mode: Java -*-
//
// DimNumber.java

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

public class DimNumber extends Quantity {
    public Ratio pid;
    public double magnitude;
    public String preferredUnits;

  public static DimNumber parseDimNumber(String input) {
    { char currentCharacter = Stella.NULL_CHARACTER;
      char lastCharacter = ' ';
      boolean signAllowedP = true;
      boolean decimalSeenP = false;
      int len = input.length();
      int index = 0;
      double magnitude = Stella.NULL_FLOAT;

      loop000 : while (index < len) {
        currentCharacter = input.charAt(index);
        if ((currentCharacter == '+') ||
            (currentCharacter == '-')) {
          if (!signAllowedP) {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("Bad number format (sign in bad place): `" + input + "'");
              throw ((BadArgumentException)(BadArgumentException.newBadArgumentException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
          signAllowedP = false;
        }
        else if (currentCharacter == '.') {
          if (decimalSeenP) {
            { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

              stream001.nativeStream.print("Bad number format (too many decimals): `" + input + "'");
              throw ((BadArgumentException)(BadArgumentException.newBadArgumentException(stream001.theStringReader()).fillInStackTrace()));
            }
          }
          decimalSeenP = true;
          signAllowedP = false;
        }
        else if (Stella.$CHARACTER_TYPE_TABLE$[(int) currentCharacter] == Utilities.KWD_DIGIT) {
          signAllowedP = false;
        }
        else if ((currentCharacter == 'e') ||
            (currentCharacter == 'E')) {
          if (Stella.$CHARACTER_TYPE_TABLE$[(int) lastCharacter] == Utilities.KWD_DIGIT) {
            signAllowedP = true;
          }
          else {
            break loop000;
          }
        }
        else {
          if ((lastCharacter == 'e') ||
              (lastCharacter == 'E')) {
            index = index - 1;
          }
          break loop000;
        }
        lastCharacter = currentCharacter;
        index = index + 1;
      }
      try {
        magnitude = Native.stringToFloat(Native.string_subsequence(input, 0, index));
      } catch (java.lang.Exception e000) {
        try {
          magnitude = ((double)(Native.stringToInteger(Native.string_subsequence(input, 0, index))));
        } catch (java.lang.Exception e001) {
          { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

            stream002.nativeStream.print("Bad number format: `" + input + "'");
            throw ((BadArgumentException)(BadArgumentException.newBadArgumentException(stream002.theStringReader()).fillInStackTrace()));
          }
        }
      }
      return (DimNumber.makeDimNumber(magnitude, Native.string_subsequence(input, index, len)));
    }
  }

  public static DimNumber makeDimNumber(double magnitude, String units) {
    { double scaleFactor = Stella.NULL_FLOAT;
      Ratio id = null;

      { Object [] caller_MV_returnarray = new Object[1];

        scaleFactor = Utilities.unitToScaleFactorAndId(units, caller_MV_returnarray);
        id = ((Ratio)(caller_MV_returnarray[0]));
      }
      { DimNumber self000 = DimNumber.newDimNumber(id, magnitude * scaleFactor);

        self000.preferredUnits = units;
        { DimNumber value000 = self000;

          return (value000);
        }
      }
    }
  }

  public static DimNumber newDimNumber(Ratio pid, double magnitude) {
    { DimNumber self = null;

      self = new DimNumber();
      self.pid = pid;
      self.magnitude = magnitude;
      self.preferredUnits = null;
      return (self);
    }
  }

  /** Convert decimal hours to a list of (Hour Minute Second)
   * where Hour and Minute are integer-valued.
   * @param d
   * @return Cons
   */
  public static Cons hoursToHms(DimNumber d) {
    { int hourMagnitude = Native.truncate(d.getMagnitude("hr"));
      DimNumber hourValue = DimNumber.makeDimNumber(((double)(hourMagnitude)), "hr");
      int minuteMagnitude = Native.truncate(d.subtract(hourValue).getMagnitude("min"));
      DimNumber minuteValue = DimNumber.makeDimNumber(((double)(minuteMagnitude)), "min");
      int secondMagnitude = Native.truncate(d.subtract(hourValue).subtract(minuteValue).getMagnitude("s"));

      return (Cons.consList(Cons.cons(hourValue, Cons.cons(minuteValue, Cons.cons(DimNumber.makeDimNumber(((double)(secondMagnitude)), "s"), Stella.NIL)))));
    }
  }

  /** Convert decimal degrees to a list of (Degree Minute Second)
   * where Degree and Minute are integer-valued.
   * @param d
   * @return Cons
   */
  public static Cons degreesToDms(DimNumber d) {
    { int degreeMagnitude = Native.truncate(d.getMagnitude("deg"));
      DimNumber degreeValue = DimNumber.makeDimNumber(((double)(degreeMagnitude)), "deg");
      int minuteMagnitude = Native.truncate(d.subtract(degreeValue).getMagnitude("arcmin"));
      DimNumber minuteValue = DimNumber.makeDimNumber(((double)(minuteMagnitude)), "arcmin");
      int secondMagnitude = Native.truncate(d.subtract(degreeValue).subtract(minuteValue).getMagnitude("arcsec"));

      return (Cons.consList(Cons.cons(degreeValue, Cons.cons(minuteValue, Cons.cons(DimNumber.makeDimNumber(((double)(secondMagnitude)), "arcsec"), Stella.NIL)))));
    }
  }

  /** Converts the dimensioned number <code>timeValue</code> to its
   * equivalent value as a <code>timeDuration</code> object.  If <code>timeValue</code> is not
   * of the appropriate units, an <code>incompatibleUnitsException</code> is thrown.
   * @param timeValue
   * @return TimeDuration
   */
  public static TimeDuration dimToTimeDuration(DimNumber timeValue) {
    if (timeValue.signum() == -1) {
      {
        timeValue = timeValue.negate();
        { int days = Native.floor(timeValue.getMagnitude("days"));

          return (TimeDuration.makeTimeDuration(0 - days, 0 - Native.floor(timeValue.subtract(DimNumber.makeDimNumber(((double)(days)), "days")).getMagnitude("ms"))));
        }
      }
    }
    else {
      { int days = Native.floor(timeValue.getMagnitude("days"));

        return (TimeDuration.makeTimeDuration(days, Native.floor(timeValue.subtract(DimNumber.makeDimNumber(((double)(days)), "days")).getMagnitude("ms"))));
      }
    }
  }

  /** Computes <code>x</code> &gt; <code>y</code>
   * @param y
   * @return boolean
   */
  public boolean greaterP(Stella_Object y) {
    { DimNumber x = this;

      { DimNumber yDim = ((DimNumber)(x.coerceTo(y)));

        if (x.pid.objectEqlP(yDim.pid)) {
          return (x.magnitude > yDim.magnitude);
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("Can't compare `" + x + "' and `" + yDim + "' because of incompatible units");
            throw ((IncompatibleUnitsException)(IncompatibleUnitsException.newIncompatibleUnitsException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  /** Computes <code>x</code> &gt;= <code>y</code>
   * @param y
   * @return boolean
   */
  public boolean greaterEqualP(Stella_Object y) {
    { DimNumber x = this;

      { DimNumber yDim = ((DimNumber)(x.coerceTo(y)));

        if (x.pid.objectEqlP(yDim.pid)) {
          return (x.magnitude >= yDim.magnitude);
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("Can't compare `" + x + "' and `" + yDim + "' because of incompatible units");
            throw ((IncompatibleUnitsException)(IncompatibleUnitsException.newIncompatibleUnitsException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  /** Computes <code>x</code> &lt;= <code>y</code>
   * @param y
   * @return boolean
   */
  public boolean lessEqualP(Stella_Object y) {
    { DimNumber x = this;

      { DimNumber yDim = ((DimNumber)(x.coerceTo(y)));

        if (x.pid.objectEqlP(yDim.pid)) {
          return (x.magnitude <= yDim.magnitude);
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("Can't compare `" + x + "' and `" + yDim + "' because of incompatible units");
            throw ((IncompatibleUnitsException)(IncompatibleUnitsException.newIncompatibleUnitsException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  /** Computes <code>x</code> &lt; <code>y</code>
   * @param y
   * @return boolean
   */
  public boolean lessP(Stella_Object y) {
    { DimNumber x = this;

      { DimNumber yDim = ((DimNumber)(x.coerceTo(y)));

        if (x.pid.objectEqlP(yDim.pid)) {
          return (x.magnitude < yDim.magnitude);
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("Can't compare `" + x + "' and `" + yDim + "' because of incompatible units");
            throw ((IncompatibleUnitsException)(IncompatibleUnitsException.newIncompatibleUnitsException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  /** Computes <code>x</code> ^ <code>y</code>
   * @param y
   * @return DimNumber
   */
  public DimNumber exponentiate(int y) {
    { DimNumber x = this;

      return (DimNumber.newDimNumber(x.pid.exponentiate(y), Math.pow((x.magnitude),(((double)(y))))));
    }
  }

  /** Computes the positive square root of x, assuming the units are perfect squares
   * @return DimNumber
   */
  public DimNumber squareRoot() {
    { DimNumber x = this;

      { double numeratorRoot = Math.sqrt((((double)(x.pid.numerator))));
        int integerNumeratorRoot = Native.floor(numeratorRoot);
        double denominatorRoot = Math.sqrt((((double)(x.pid.denominator))));
        int integerDenominatorRoot = Native.floor(denominatorRoot);

        if ((numeratorRoot == ((double)(integerNumeratorRoot))) &&
            (denominatorRoot == ((double)(integerDenominatorRoot)))) {
          return (DimNumber.newDimNumber(Ratio.makeRatio(integerNumeratorRoot, integerDenominatorRoot), Math.sqrt((x.magnitude))));
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("Attempt to take square root of `" + x + "'  when the units are not a perfect square");
            throw ((BadArgumentException)(BadArgumentException.newBadArgumentException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  /** Computes  abs(<code>x</code>)
   * @return DimNumber
   */
  public DimNumber absoluteValue() {
    { DimNumber x = this;

      if (x.magnitude < 0.0) {
        return (x.negate());
      }
      else {
        return (x);
      }
    }
  }

  /** Computes  1 / <code>x</code>
   * @return DimNumber
   */
  public DimNumber invert() {
    { DimNumber x = this;

      return (DimNumber.newDimNumber(x.pid.invert(), 1 / x.magnitude));
    }
  }

  /** Computes - <code>x</code>
   * @return DimNumber
   */
  public DimNumber negate() {
    { DimNumber x = this;

      { DimNumber self000 = DimNumber.newDimNumber(x.pid, 0 - x.magnitude);

        self000.preferredUnits = x.preferredUnits;
        { DimNumber value000 = self000;

          return (value000);
        }
      }
    }
  }

  /** Computes the modulus of <code>x</code> and <code>y</code>.  <code>x</code> and <code>y</code> must be compatible
   * units, and the result has the preferred units of <code>x</code>.
   * @param y
   * @return DimNumber
   */
  public DimNumber modulus(DimNumber y) {
    { DimNumber x = this;

      if (x.pid.objectEqlP(y.pid)) {
        { double quotient = x.magnitude / y.magnitude;

          { DimNumber self000 = DimNumber.newDimNumber(x.pid, (quotient - Native.floor(quotient)) * y.magnitude);

            self000.preferredUnits = x.preferredUnits;
            { DimNumber value000 = self000;

              return (value000);
            }
          }
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Can't perform modulus on `" + x + "' and `" + y + "' because of incompatible units");
          throw ((IncompatibleUnitsException)(IncompatibleUnitsException.newIncompatibleUnitsException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  /** Computes <code>x</code> / <code>y</code>
   * @param y
   * @return DimNumber
   */
  public DimNumber divide(DimNumber y) {
    { DimNumber x = this;

      return (DimNumber.newDimNumber(x.pid.divide(y.pid), x.magnitude / y.magnitude));
    }
  }

  /** Computes <code>x</code> * <code>y</code>
   * @param y
   * @return DimNumber
   */
  public DimNumber multiply(DimNumber y) {
    { DimNumber x = this;

      return (DimNumber.newDimNumber(x.pid.multiply(y.pid), x.magnitude * y.magnitude));
    }
  }

  /** Computes <code>x</code> - <code>y</code>
   * @param y
   * @return DimNumber
   */
  public DimNumber subtract(DimNumber y) {
    { DimNumber x = this;

      if (x.pid.objectEqlP(y.pid)) {
        return (DimNumber.newDimNumber(x.pid, x.magnitude - y.magnitude));
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Can't subtract `" + y + "' from `" + x + "' because of incompatible units");
          throw ((IncompatibleUnitsException)(IncompatibleUnitsException.newIncompatibleUnitsException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  /** Computes <code>x</code> + <code>y</code>
   * @param y
   * @return DimNumber
   */
  public DimNumber add(DimNumber y) {
    { DimNumber x = this;

      if (x.pid.objectEqlP(y.pid)) {
        return (DimNumber.newDimNumber(x.pid, x.magnitude + y.magnitude));
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Can't add `" + x + "' and `" + y + "' because of incompatible units");
          throw ((IncompatibleUnitsException)(IncompatibleUnitsException.newIncompatibleUnitsException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  /** Computes the signum of <code>x</code>:  -1 if negative, 0 if zero, 1 if positive
   * @return int
   */
  public int signum() {
    { DimNumber x = this;

      if (x.magnitude > 0.0) {
        return (1);
      }
      else if (x.magnitude == 0.0) {
        return (0);
      }
      else {
        return (-1);
      }
    }
  }

  public int hashCode_() {
    { DimNumber self = this;

      return ((((int)(Double.doubleToLongBits((self.magnitude))^(Double.doubleToLongBits((self.magnitude))>>>32))) ^ (self.pid.hashCode_())));
    }
  }

  public boolean objectEqlP(Stella_Object y) {
    { DimNumber x = this;

      return ((y != null) &&
          ((y.primaryType() == Utilities.SGT_UTILITIES_DIM_NUMBER) &&
           (x.pid.objectEqlP(((DimNumber)(y)).pid) &&
            (x.magnitude == ((DimNumber)(y)).magnitude))));
    }
  }

  /** Returns TRUE if the units of <code>x</code> and <code>y</code> are compatible.
   * @param x
   * @param y
   * @return boolean
   */
  public static boolean compatibleUnitsP(DimNumber x, DimNumber y) {
    return (x.pid.objectEqlP(y.pid));
  }

  /** Returns a string representation of <code>x</code> in <code>units</code> with <code>decimals</code> digits.
   * @param units
   * @param decimals
   * @return String
   */
  public String formatDimNumber(String units, int decimals) {
    { DimNumber x = this;

      if (units == null) {
        units = x.getUnit();
      }
      if (decimals != Stella.NULL_INTEGER) {
        return (Native.formatFloat(x.getMagnitude(units), decimals) + units);
      }
      else {
        return (Native.floatToString(x.getMagnitude(units)) + units);
      }
    }
  }

  /** Returns cons of the base measures for the numerator and denominator
   * of <code>self</code>.
   * @param MV_returnarray
   * @return Cons
   */
  public Cons getBaseMeasures(Object [] MV_returnarray) {
    { DimNumber self = this;

      return (Ratio.computeMeasuresForPrimeId(self.pid, MV_returnarray));
    }
  }

  /** Returns the measure for the dim number, if one is defined.
   * @return Measure
   */
  public Measure getMeasure() {
    { DimNumber self = this;

      return (((Measure)(Utilities.$PRIME_TO_MEASURE_TABLE$.lookup(self.pid))));
    }
  }

  /** Returns the base units for the dim number.
   * @return String
   */
  public String getBaseUnit() {
    { DimNumber self = this;

      { Measure measure = ((Measure)(Utilities.$PRIME_TO_MEASURE_TABLE$.lookup(self.pid)));

        if (measure != null) {
          return (measure.baseUnit);
        }
        else {
          return (Ratio.computeUnitsForPrimeId(self.pid));
        }
      }
    }
  }

  /** Returns the units for the dim number.  This will return the
   * preferred output units if they exist, otherwise the base units. (see <code>getBaseUnit</code>)
   * @return String
   */
  public String getUnit() {
    { DimNumber self = this;

      { String units = self.preferredUnits;

        if (units != null) {
          return (units);
        }
        else {
          return (self.getBaseUnit());
        }
      }
    }
  }

  /** Returns the magnitude of the dim number in the given units.
   * @param units
   * @return double
   */
  public double getMagnitude(String units) {
    { DimNumber self = this;

      { double scaleFactor = Stella.NULL_FLOAT;
        Ratio id = null;

        { Object [] caller_MV_returnarray = new Object[1];

          scaleFactor = Utilities.unitToScaleFactorAndId(units, caller_MV_returnarray);
          id = ((Ratio)(caller_MV_returnarray[0]));
        }
        if (Stella_Object.eqlP(id, self.pid)) {
          return (self.magnitude / scaleFactor);
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("Unit `" + units + "' is not compatible with `" + self.getUnit() + "'");
            throw ((IncompatibleUnitsException)(IncompatibleUnitsException.newIncompatibleUnitsException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  /** Coerces <code>y</code> to be a compatible type with <code>x</code>.
   * If this isn't possible, an exception is thrown.  The exception
   * will be either INCOMPATIBLE-QUANTITY-EXCEPTION or 
   * INCOMPATIBLE-UNITS-EXCEPTION.
   * @param y
   * @return Quantity
   */
  public Quantity coerceTo(Stella_Object y) {
    { DimNumber x = this;

      { Surrogate testValue000 = Stella_Object.safePrimaryType(y);

        if (Surrogate.subtypeOfP(testValue000, Utilities.SGT_UTILITIES_DIM_NUMBER)) {
          { DimNumber y000 = ((DimNumber)(y));

            return (y000);
          }
        }
        else if (Surrogate.subtypeOfP(testValue000, Utilities.SGT_STELLA_TIME_DURATION)) {
          { TimeDuration y000 = ((TimeDuration)(y));

            return (Utilities.timeDurationToDim(y000));
          }
        }
        else if (Surrogate.subtypeOfIntegerP(testValue000)) {
          { IntegerWrapper y000 = ((IntegerWrapper)(y));

            return (DimNumber.makeDimNumber(((double)(y000.wrapperValue)), ""));
          }
        }
        else if (Surrogate.subtypeOfFloatP(testValue000)) {
          { FloatWrapper y000 = ((FloatWrapper)(y));

            return (DimNumber.makeDimNumber(y000.wrapperValue, ""));
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("Can't convert `" + y + "' to a DIM-NUMBER");
            throw ((IncompatibleQuantityException)(IncompatibleQuantityException.newIncompatibleQuantityException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { DimNumber self = this;

      stream.print("<" + self.getMagnitude(self.getUnit()) + self.getUnit() + ">");
    }
  }

  public static Stella_Object accessDimNumberSlotValue(DimNumber self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Utilities.SYM_UTILITIES_PID) {
      if (setvalueP) {
        self.pid = ((Ratio)(value));
      }
      else {
        value = self.pid;
      }
    }
    else if (slotname == Utilities.SYM_UTILITIES_MAGNITUDE) {
      if (setvalueP) {
        self.magnitude = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.magnitude);
      }
    }
    else if (slotname == Utilities.SYM_UTILITIES_PREFERRED_UNITS) {
      if (setvalueP) {
        self.preferredUnits = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.preferredUnits);
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
    { DimNumber self = this;

      return (Utilities.SGT_UTILITIES_DIM_NUMBER);
    }
  }

}

