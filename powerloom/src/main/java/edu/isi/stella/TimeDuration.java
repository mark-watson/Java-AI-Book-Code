//  -*- Mode: Java -*-
//
// TimeDuration.java

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

/** Representation of Relative Days and Time with the date represented
 * as a number of days and the time in milliseconds.
 * @author Stella Java Translator
 */
public class TimeDuration extends DateTimeObject {
    public int days;
    public int millis;

  public static TimeDuration makeTimeDuration(int days, int millis) {
    while (millis < (0 - Stella.MILLIS_PER_DAY)) {
      millis = millis + Stella.MILLIS_PER_DAY;
      days = days - 1;
    }
    while (millis > Stella.MILLIS_PER_DAY) {
      millis = millis - Stella.MILLIS_PER_DAY;
      days = days + 1;
    }
    if (days < 0) {
      if (!(millis <= 0)) {
        days = days + 1;
        millis = millis - Stella.MILLIS_PER_DAY;
      }
    }
    else if (days > 0) {
      if (!(millis >= 0)) {
        days = days - 1;
        millis = millis + Stella.MILLIS_PER_DAY;
      }
    }
    else {
    }
    { TimeDuration self000 = TimeDuration.newTimeDuration();

      self000.days = days;
      self000.millis = millis;
      { TimeDuration value000 = self000;

        return (value000);
      }
    }
  }

  /** Parses and returns an time-duration object corresponding to <code>duration</code>.
   * The syntax for time duration strings is &quot;{plus|minus} N days[; M ms]&quot; where N and M are
   * integer values for days and milliseconds.  If no valid parse is found, <code>null</code> is returned.
   * @param duration
   * @return TimeDuration
   */
  public static TimeDuration stringToTimeDuration(String duration) {
    { int nDays = 0;
      int nMillis = 0;
      boolean negativeP = Native.stringSearch(duration, "minus", 0) != Stella.NULL_INTEGER;
      int dayStartPosition = 0;
      int dayEndPosition = 0;
      int msStartPosition = 0;
      int msEndPosition = 0;

      if (negativeP) {
        dayStartPosition = 6;
      }
      else if (Native.stringSearch(duration, "plus", 0) != Stella.NULL_INTEGER) {
        dayStartPosition = 5;
      }
      else {
        dayStartPosition = 0;
      }
      dayEndPosition = Native.stringSearch(duration, "days", dayStartPosition);
      if (dayEndPosition == Stella.NULL_INTEGER) {
        return (null);
      }
      else {
        nDays = ((int)(Native.stringToInteger(Native.string_subsequence(duration, dayStartPosition, dayEndPosition - 1))));
      }
      msStartPosition = Native.string_position(duration, ' ', dayEndPosition);
      if (msStartPosition != Stella.NULL_INTEGER) {
        msEndPosition = Native.stringSearch(duration, "ms", msStartPosition);
        if (msEndPosition != Stella.NULL_INTEGER) {
          nMillis = ((int)(Native.stringToInteger(Native.string_subsequence(duration, msStartPosition + 1, msEndPosition - 1))));
        }
      }
      if (negativeP) {
        return (TimeDuration.makeTimeDuration(0 - nDays, 0 - nMillis));
      }
      else {
        return (TimeDuration.makeTimeDuration(nDays, nMillis));
      }
    }
  }

  public static TimeDuration newTimeDuration() {
    { TimeDuration self = null;

      self = new TimeDuration();
      self.millis = Stella.NULL_INTEGER;
      self.days = Stella.NULL_INTEGER;
      return (self);
    }
  }

  public boolean greaterEqualP(Stella_Object t2) {
    { TimeDuration t1 = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(t2), Stella.SGT_STELLA_TIME_DURATION)) {
        { TimeDuration t2000 = ((TimeDuration)(t2));

          if (t1.days == t2000.days) {
            return (t1.millis >= t2000.millis);
          }
          else {
            return (t1.days >= t2000.days);
          }
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Can't compare calendar date `" + t1 + "' with object `" + t2 + "'");
          throw ((IncompatibleQuantityException)(IncompatibleQuantityException.newIncompatibleQuantityException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public boolean lessEqualP(Stella_Object t2) {
    { TimeDuration t1 = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(t2), Stella.SGT_STELLA_TIME_DURATION)) {
        { TimeDuration t2000 = ((TimeDuration)(t2));

          if (t1.days == t2000.days) {
            return (t1.millis <= t2000.millis);
          }
          else {
            return (t1.days <= t2000.days);
          }
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Can't compare calendar date `" + t1 + "' with object `" + t2 + "'");
          throw ((IncompatibleQuantityException)(IncompatibleQuantityException.newIncompatibleQuantityException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public boolean greaterP(Stella_Object t2) {
    { TimeDuration t1 = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(t2), Stella.SGT_STELLA_TIME_DURATION)) {
        { TimeDuration t2000 = ((TimeDuration)(t2));

          if (t1.days == t2000.days) {
            return (t1.millis > t2000.millis);
          }
          else {
            return (t1.days > t2000.days);
          }
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Can't compare calendar date `" + t1 + "' with object `" + t2 + "'");
          throw ((IncompatibleQuantityException)(IncompatibleQuantityException.newIncompatibleQuantityException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public boolean lessP(Stella_Object t2) {
    { TimeDuration t1 = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(t2), Stella.SGT_STELLA_TIME_DURATION)) {
        { TimeDuration t2000 = ((TimeDuration)(t2));

          if (t1.days == t2000.days) {
            return (t1.millis < t2000.millis);
          }
          else {
            return (t1.days < t2000.days);
          }
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Can't compare calendar date `" + t1 + "' with object `" + t2 + "'");
          throw ((IncompatibleQuantityException)(IncompatibleQuantityException.newIncompatibleQuantityException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public boolean objectEqlP(Stella_Object t2) {
    { TimeDuration t1 = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(t2), Stella.SGT_STELLA_TIME_DURATION)) {
        { TimeDuration t2000 = ((TimeDuration)(t2));

          if (t1.days == t2000.days) {
            return (t1.millis == t2000.millis);
          }
          else {
            return (t1.days == t2000.days);
          }
        }
      }
      else {
        return (false);
      }
    }
  }

  /** Divides the relative date <code>t1</code> by <code>t2</code>.  <code>t2</code> must be
   * either a relative date or a wrapped number.  If <code>t2</code> is a relative date,
   * then the return value will be a wrapped float.  If <code>t2</code> is a wrapped number,
   * then the reutrn value will be a relative date.
   * @param t1
   * @param t2
   * @return Stella_Object
   */
  public static Stella_Object timeDivide(TimeDuration t1, Stella_Object t2) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(t2);

      if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_CALENDAR_DATE)) {
        { CalendarDate t2000 = ((CalendarDate)(t2));

          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("Calendar dates cannot be involved in division:  `" + t1 + "'  `" + t2000 + "'");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_TIME_DURATION)) {
        { TimeDuration t2000 = ((TimeDuration)(t2));

          return (FloatWrapper.wrapFloat((t1.days + (((double)(t1.millis)) / Stella.MILLIS_PER_DAY)) / (t2000.days + (((double)(t2000.millis)) / Stella.MILLIS_PER_DAY))));
        }
      }
      else if (Surrogate.subtypeOfIntegerP(testValue000)) {
        { IntegerWrapper t2000 = ((IntegerWrapper)(t2));

          return (TimeDuration.makeTimeDuration(Native.round(((double)(t1.days)) / t2000.wrapperValue), Native.round(((double)(t1.millis)) / t2000.wrapperValue)));
        }
      }
      else if (Surrogate.subtypeOfFloatP(testValue000)) {
        { FloatWrapper t2000 = ((FloatWrapper)(t2));

          return (TimeDuration.makeTimeDuration(Native.round(t1.days / t2000.wrapperValue), Native.round(t1.millis / t2000.wrapperValue)));
        }
      }
      else {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("`" + testValue000 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public DecodedTimeDuration decodeTimeDuration() {
    { TimeDuration duration = this;

      if (duration.millis > 0) {
        { DecodedTimeDuration self000 = DecodedTimeDuration.newDecodedTimeDuration();

          self000.durationDays = duration.days;
          self000.durationHours = ((duration.millis) / Stella.MILLIS_PER_HOUR);
          self000.durationMinutes = ((((duration.millis) % Stella.MILLIS_PER_HOUR)) / 60000);
          self000.durationSeconds = ((((duration.millis) % 60000)) / 1000);
          self000.durationMillis = ((double)(((duration.millis) % 1000)));
          { DecodedTimeDuration value000 = self000;

            return (value000);
          }
        }
      }
      else {
        { DecodedTimeDuration self001 = DecodedTimeDuration.newDecodedTimeDuration();

          self001.durationDays = duration.days;
          self001.durationHours = 0 - ((0 - duration.millis) / Stella.MILLIS_PER_HOUR);
          self001.durationMinutes = 0 - ((((0 - duration.millis) % Stella.MILLIS_PER_HOUR)) / 60000);
          self001.durationSeconds = 0 - ((((0 - duration.millis) % 60000)) / 1000);
          self001.durationMillis = ((double)(0 - ((0 - duration.millis) % 1000)));
          { DecodedTimeDuration value001 = self001;

            return (value001);
          }
        }
      }
    }
  }

  public void printTimeDuration(edu.isi.stella.javalib.NativeOutputStream stream) {
    { TimeDuration date = this;

      stream.print("<" + date.timeDurationToString() + ">");
    }
  }

  /** Returns a string representation of <code>date</code>
   * @return String
   */
  public String timeDurationToString() {
    { TimeDuration date = this;

      { int nDays = date.days;
        int nMillis = date.millis;

        if (nDays < 0) {
          if (nMillis <= 0) {
            return ("minus " + Native.integerToString(((long)(0 - nDays))) + " days; " + Native.integerToString(((long)(0 - nMillis))) + " ms");
          }
          else {
            return ("minus " + Native.integerToString(((long)(0 - (nDays + 1)))) + " days; " + Native.integerToString(((long)(Stella.MILLIS_PER_DAY - nMillis))) + " ms");
          }
        }
        else {
          if (nMillis < 0) {
            if (nDays > 0) {
              return ("plus " + Native.integerToString(((long)(nDays - 1))) + " days; " + Native.integerToString(((long)(Stella.MILLIS_PER_DAY + nMillis))) + " ms");
            }
            else {
              return ("minus 0 days; " + Native.integerToString(((long)(0 - nMillis))) + " ms");
            }
          }
          else {
            return ("plus " + Native.integerToString(((long)(nDays))) + " days; " + Native.integerToString(((long)(nMillis))) + " ms");
          }
        }
      }
    }
  }

  public int hashCode_() {
    { TimeDuration self = this;

      return (((self.days) ^ (self.millis)));
    }
  }

  public Quantity coerceTo(Stella_Object y) {
    { TimeDuration x = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(y), Stella.SGT_STELLA_TIME_DURATION)) {
        { TimeDuration y000 = ((TimeDuration)(y));

          return (y000);
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Can't coerce `" + y + "' to a TIME-DURATION");
          throw ((IncompatibleQuantityException)(IncompatibleQuantityException.newIncompatibleQuantityException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { TimeDuration self = this;

      self.printTimeDuration(stream);
    }
  }

  public static Stella_Object accessTimeDurationSlotValue(TimeDuration self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_DAYS) {
      if (setvalueP) {
        self.days = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.days);
      }
    }
    else if (slotname == Stella.SYM_STELLA_MILLIS) {
      if (setvalueP) {
        self.millis = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.millis);
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
    { TimeDuration self = this;

      return (Stella.SGT_STELLA_TIME_DURATION);
    }
  }

}

