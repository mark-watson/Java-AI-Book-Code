//  -*- Mode: Java -*-
//
// Ratio.java

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

public class Ratio extends Quantity {
    public int numerator;
    public int denominator;

  public static Ratio makeRatio(int num, int denom) {
    { long thegcd = Stella.gcd(((long)(num)), ((long)(denom)));
      int n = 0;
      int d = 0;
      boolean negativeP = false;

      if (num < 0) {
        {
          n = ((int)(((double)(0 - num)) / thegcd));
          negativeP = true;
        }
      }
      else {
        n = ((int)(((double)(num)) / thegcd));
      }
      if (denom < 0) {
        {
          d = ((int)(((double)(0 - denom)) / thegcd));
          negativeP = !negativeP;
        }
      }
      else {
        d = ((int)(((double)(denom)) / thegcd));
      }
      if (negativeP) {
        n = 0 - n;
      }
      return (Ratio.newRatio(n, d));
    }
  }

  public static Ratio newRatio(int numerator, int denominator) {
    { Ratio self = null;

      self = new Ratio();
      self.numerator = numerator;
      self.denominator = denominator;
      return (self);
    }
  }

  public static String computeUnitsForPrimeId(Ratio pid) {
    { String numeratorString = Utilities.computeUnitsForInteger(pid.numerator, false);
      String denominatorString = Utilities.computeUnitsForInteger(pid.denominator, false);

      if (Stella.stringEqlP(denominatorString, "")) {
        return (numeratorString);
      }
      else {
        return (numeratorString + "/" + denominatorString);
      }
    }
  }

  /** Returns two CONSes of Measure objects for the prime ID <code>pid</code>
   * @param pid
   * @param MV_returnarray
   * @return Cons
   */
  public static Cons computeMeasuresForPrimeId(Ratio pid, Object [] MV_returnarray) {
    { Cons _return_temp = Utilities.computeMeasuresForInteger(pid.numerator);

      MV_returnarray[0] = Utilities.computeMeasuresForInteger(pid.denominator);
      return (_return_temp);
    }
  }

  public Ratio exponentiate(int y) {
    { Ratio x = this;

      if (y < 0) {
        return (Ratio.newRatio(Utilities.ipower(x.denominator, 0 - y), Utilities.ipower(x.numerator, 0 - y)));
      }
      else {
        return (Ratio.newRatio(Utilities.ipower(x.numerator, y), Utilities.ipower(x.denominator, y)));
      }
    }
  }

  public Ratio invert() {
    { Ratio x = this;

      return (Ratio.newRatio(x.denominator, x.numerator));
    }
  }

  public Ratio negate() {
    { Ratio x = this;

      return (Ratio.newRatio(0 - x.numerator, x.denominator));
    }
  }

  public Ratio divide(Ratio y) {
    { Ratio x = this;

      return (Ratio.makeRatio(x.numerator * y.denominator, x.denominator * y.numerator));
    }
  }

  public Ratio multiply(Ratio y) {
    { Ratio x = this;

      return (Ratio.makeRatio(x.numerator * y.numerator, x.denominator * y.denominator));
    }
  }

  public Ratio subtract(Ratio y) {
    { Ratio x = this;

      return (Ratio.makeRatio((x.numerator * y.denominator) - (y.numerator * x.denominator), x.denominator * y.denominator));
    }
  }

  public Ratio add(Ratio y) {
    { Ratio x = this;

      return (Ratio.makeRatio((x.numerator * y.denominator) + (y.numerator * x.denominator), x.denominator * y.denominator));
    }
  }

  /** Computes <code>x</code> &gt; <code>y</code>
   * @param y
   * @return boolean
   */
  public boolean greaterP(Stella_Object y) {
    { Ratio x = this;

      { Ratio yRatio = ((Ratio)(x.coerceTo(y)));

        return ((x.numerator * yRatio.denominator) > (yRatio.numerator * x.denominator));
      }
    }
  }

  /** Computes <code>x</code> &gt;= <code>y</code>
   * @param y
   * @return boolean
   */
  public boolean greaterEqualP(Stella_Object y) {
    { Ratio x = this;

      { Ratio yRatio = ((Ratio)(x.coerceTo(y)));

        return ((x.numerator * yRatio.denominator) >= (yRatio.numerator * x.denominator));
      }
    }
  }

  /** Computes <code>x</code> &lt;= <code>y</code>
   * @param y
   * @return boolean
   */
  public boolean lessEqualP(Stella_Object y) {
    { Ratio x = this;

      { Ratio yRatio = ((Ratio)(x.coerceTo(y)));

        return ((x.numerator * yRatio.denominator) <= (yRatio.numerator * x.denominator));
      }
    }
  }

  /** Computes <code>x</code> &lt; <code>y</code>
   * @param y
   * @return boolean
   */
  public boolean lessP(Stella_Object y) {
    { Ratio x = this;

      { Ratio yRatio = ((Ratio)(x.coerceTo(y)));

        return ((x.numerator * yRatio.denominator) < (yRatio.numerator * x.denominator));
      }
    }
  }

  public boolean objectEqlP(Stella_Object y) {
    { Ratio x = this;

      return ((y != null) &&
          ((y.primaryType() == Utilities.SGT_UTILITIES_RATIO) &&
           ((x.numerator == ((Ratio)(y)).numerator) &&
            (x.denominator == ((Ratio)(y)).denominator))));
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
    { Ratio x = this;

      { Surrogate testValue000 = Stella_Object.safePrimaryType(y);

        if (Surrogate.subtypeOfP(testValue000, Utilities.SGT_UTILITIES_RATIO)) {
          { Ratio y000 = ((Ratio)(y));

            return (y000);
          }
        }
        else if (Surrogate.subtypeOfIntegerP(testValue000)) {
          { IntegerWrapper y000 = ((IntegerWrapper)(y));

            return (Ratio.makeRatio(y000.wrapperValue, 1));
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("Can't convert `" + y + "' to a RATIO");
            throw ((IncompatibleQuantityException)(IncompatibleQuantityException.newIncompatibleQuantityException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  public int hashCode_() {
    { Ratio self = this;

      return (((self.numerator) | (((self.denominator) << 10))));
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { Ratio self = this;

      stream.print(self.numerator + "/" + self.denominator);
    }
  }

  public static Stella_Object accessRatioSlotValue(Ratio self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Utilities.SYM_UTILITIES_NUMERATOR) {
      if (setvalueP) {
        self.numerator = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.numerator);
      }
    }
    else if (slotname == Utilities.SYM_UTILITIES_DENOMINATOR) {
      if (setvalueP) {
        self.denominator = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.denominator);
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
    { Ratio self = this;

      return (Utilities.SGT_UTILITIES_RATIO);
    }
  }

}

