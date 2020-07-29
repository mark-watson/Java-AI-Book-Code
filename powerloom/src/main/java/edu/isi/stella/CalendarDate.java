//  -*- Mode: Java -*-
//
// CalendarDate.java

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

/** Representation of Date and Time with the date represented
 * as a modified Julian day (starting at midnight instead of noon) and the
 * time as the offset in milliseconds from midnight, UTC
 * @author Stella Java Translator
 */
public class CalendarDate extends DateTimeObject {
    public int modifiedJulianDay;
    public int timeMillis;

  /** Returns a calendar date object representing the date and time
   * parsed from the <code>inputDate</code> string.  Default values for missing fields and
   * the interpretation of relative references come from <code>defaultDate</code>.  If the
   * <code>defaultDate</code> is <code>null</code>, the current date will be used.  If a null set of
   * defaults is desired, use <code>$NULL_DECODED_DATE_TIME$</code>.
   * If no valid parse is found, <code>null</code> is returned.
   * @param inputDate
   * @param defaultDate
   * @return CalendarDate
   */
  public static CalendarDate stringToCalendarDateWithDefault(String inputDate, DecodedDateTime defaultDate) {
    if (defaultDate == null) {
      return (CalendarDate.stringToCalendarDate(inputDate));
    }
    else {
      { DecodedDateTime dateTime = DecodedDateTime.parseDateTimeRelativeToBase(inputDate, defaultDate, 0, Stella.NULL_INTEGER, false, true);

        if (dateTime == null) {
          return (null);
        }
        else {
          return (dateTime.encodeCalendarDate());
        }
      }
    }
  }

  /** Returns a calendar date object representing the date and time
   * parsed from the <code>input</code> string.  If no valid parse is found,
   * <code>null</code> is returned.
   * @param input
   * @return CalendarDate
   */
  public static CalendarDate stringToCalendarDate(String input) {
    { DecodedDateTime dateTime = DecodedDateTime.parseDateTimeInTimeZone(input, Stella.NULL_FLOAT, 0, Stella.NULL_INTEGER, false);

      if (dateTime == null) {
        return (null);
      }
      else {
        return (dateTime.encodeCalendarDate());
      }
    }
  }

  public static CalendarDate makeCalendarDate(int day, int time) {
    while (time < 0) {
      time = time + Stella.MILLIS_PER_DAY;
      day = day - 1;
    }
    while (time > Stella.MILLIS_PER_DAY) {
      time = time - Stella.MILLIS_PER_DAY;
      day = day + 1;
    }
    { CalendarDate self000 = CalendarDate.newCalendarDate();

      self000.modifiedJulianDay = day;
      self000.timeMillis = time;
      { CalendarDate value000 = self000;

        return (value000);
      }
    }
  }

  /** Create a calendar date with current time and date.
   * @return CalendarDate
   */
  public static CalendarDate makeCurrentDateTime() {
    { int year = Stella.NULL_INTEGER;
      int month = Stella.NULL_INTEGER;
      int day = Stella.NULL_INTEGER;
      Keyword dow = null;
      int hour = Stella.NULL_INTEGER;
      int minute = Stella.NULL_INTEGER;
      int second = Stella.NULL_INTEGER;
      int millisecond = Stella.NULL_INTEGER;

      { Object [] caller_MV_returnarray = new Object[7];

        year = Stella.getCurrentDateTime(caller_MV_returnarray);
        month = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
        day = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
        dow = ((Keyword)(caller_MV_returnarray[2]));
        hour = ((int)(((IntegerWrapper)(caller_MV_returnarray[3])).wrapperValue));
        minute = ((int)(((IntegerWrapper)(caller_MV_returnarray[4])).wrapperValue));
        second = ((int)(((IntegerWrapper)(caller_MV_returnarray[5])).wrapperValue));
        millisecond = ((int)(((IntegerWrapper)(caller_MV_returnarray[6])).wrapperValue));
      }
      dow = dow;
      return (CalendarDate.makeDateTime(year, month, day, hour, minute, second, millisecond, 0.0));
    }
  }

  /** Create a calendar date with the specified components.  <code>year</code> must be
   * the complete year (i.e., a year of 98 is 98 A.D in the 1st century).
   * <code>timezone</code> is a real number in the range -12.0 to +14.0 where UTC is zone 0.0;  The number
   * is the number of hours to add to UTC to arrive at local time.
   * @param year
   * @param month
   * @param day
   * @param hour
   * @param minute
   * @param second
   * @param millis
   * @param timezone
   * @return CalendarDate
   */
  public static CalendarDate makeDateTime(int year, int month, int day, int hour, int minute, int second, int millis, double timezone) {
    { int time = (hour * Stella.MILLIS_PER_HOUR) + (minute * 60000) + (second * 1000) + millis;

      time = ((int)(time - (timezone * Stella.MILLIS_PER_HOUR)));
      return (CalendarDate.makeCalendarDate(Stella.julianDayToModifiedJulianDay(Stella.computeJulianDay(year, month, day)), time));
    }
  }

  public static CalendarDate nativeDateTimeToCalendarDate(long date) {
    { int mjd = 0;
      int millis = 0;

      mjd = (int) ((date / 86400000) + 40588);
      millis = (int) (date % 86400000)
;
      return (CalendarDate.makeCalendarDate(mjd, millis));
    }
  }

  public static CalendarDate newCalendarDate() {
    { CalendarDate self = null;

      self = new CalendarDate();
      self.timeMillis = Stella.NULL_INTEGER;
      self.modifiedJulianDay = Stella.NULL_INTEGER;
      return (self);
    }
  }

  /** Fill in <code>substitutionList</code> with template variable substitions
   * for the names YEAR, MONTH, MON, DAY, HOUR, MINUTE, SECOND, TIMEZONE,
   * DAY-OF-WEEK, DOW with their values for <code>date</code>.  Also, pre-formatted
   * DATE, TIME and ISO8601 variables are set.
   * <p>
   * TIMEZONE is in the format &quot;{+|-}hhmm&quot;.  MONTH is the full English
   * month name and MON is the numeric month.  DAY-OF-WEEK is an English
   * string and DOW is the first three letters.  Minutes and seconds are
   * zero-padded.
   * <p>
   * These substitutions can be used with <code>substituteTemplateVariablesInString</code>
   * @param date
   * @param substitutionList
   */
  public static void addDateSubstitution(CalendarDate date, KeyValueList substitutionList) {
    { double tz = Stella.getLocalTimeZone();

      { int year = Stella.NULL_INTEGER;
        int month = Stella.NULL_INTEGER;
        int day = Stella.NULL_INTEGER;
        Keyword dow = null;

        { Object [] caller_MV_returnarray = new Object[3];

          year = date.getCalendarDate(tz, caller_MV_returnarray);
          month = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
          day = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
          dow = ((Keyword)(caller_MV_returnarray[2]));
        }
        substitutionList.insertAt(StringWrapper.wrapString("YEAR"), StringWrapper.wrapString(Native.integerToString(((long)(year)))));
        substitutionList.insertAt(StringWrapper.wrapString("MONTH"), ((StringWrapper)((Stella.$MONTH_NAME_VECTOR$.theArray)[month])));
        substitutionList.insertAt(StringWrapper.wrapString("MON"), StringWrapper.wrapString(Native.integerToString(((long)(month)))));
        substitutionList.insertAt(StringWrapper.wrapString("DAY"), StringWrapper.wrapString(Native.integerToString(((long)(day)))));
        substitutionList.insertAt(StringWrapper.wrapString("DAY-OF-WEEK"), StringWrapper.wrapString(Native.stringCapitalize(dow.symbolName)));
        substitutionList.insertAt(StringWrapper.wrapString("DOW"), StringWrapper.wrapString(Native.stringCapitalize(Native.string_subsequence(dow.symbolName, 0, 3))));
        substitutionList.insertAt(StringWrapper.wrapString("DATE"), StringWrapper.wrapString(Stella.formatWithPadding(Native.integerToString(((long)(day))), 2, '0', Stella.KWD_RIGHT, false) + "-" + ((StringWrapper)((Stella.$MONTH_ABBREVIATION_VECTOR$.theArray)[month])).wrapperValue + "-" + Native.integerToString(((long)(year)))));
      }
      { int hour = Stella.NULL_INTEGER;
        int min = Stella.NULL_INTEGER;
        int sec = Stella.NULL_INTEGER;
        int millis = Stella.NULL_INTEGER;

        { Object [] caller_MV_returnarray = new Object[3];

          hour = date.getTime(tz, caller_MV_returnarray);
          min = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
          sec = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
          millis = ((int)(((IntegerWrapper)(caller_MV_returnarray[2])).wrapperValue));
        }
        millis = millis;
        substitutionList.insertAt(StringWrapper.wrapString("HOUR"), StringWrapper.wrapString(Native.integerToString(((long)(hour)))));
        substitutionList.insertAt(StringWrapper.wrapString("MINUTE"), StringWrapper.wrapString(Stella.formatWithPadding(Native.integerToString(((long)(min))), 2, '0', Stella.KWD_RIGHT, false)));
        substitutionList.insertAt(StringWrapper.wrapString("SECOND"), StringWrapper.wrapString(Stella.formatWithPadding(Native.integerToString(((long)(sec))), 2, '0', Stella.KWD_RIGHT, false)));
        substitutionList.insertAt(StringWrapper.wrapString("TIME"), StringWrapper.wrapString(Native.integerToString(((long)(hour))) + ":" + Stella.formatWithPadding(Native.integerToString(((long)(min))), 2, '0', Stella.KWD_RIGHT, false) + ":" + Stella.formatWithPadding(Native.integerToString(((long)(sec))), 2, '0', Stella.KWD_RIGHT, false)));
      }
      substitutionList.insertAt(StringWrapper.wrapString("TIMEZONE"), StringWrapper.wrapString(Stella.timeZoneFormat60(tz, false)));
      substitutionList.insertAt(StringWrapper.wrapString("IOS8601"), StringWrapper.wrapString(date.calendarDateToIso8601String(tz, true)));
    }
  }

  public boolean greaterEqualP(Stella_Object t2) {
    { CalendarDate t1 = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(t2), Stella.SGT_STELLA_CALENDAR_DATE)) {
        { CalendarDate t2000 = ((CalendarDate)(t2));

          if (t1.modifiedJulianDay == t2000.modifiedJulianDay) {
            return (t1.timeMillis >= t2000.timeMillis);
          }
          else {
            return (t1.modifiedJulianDay >= t2000.modifiedJulianDay);
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
    { CalendarDate t1 = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(t2), Stella.SGT_STELLA_CALENDAR_DATE)) {
        { CalendarDate t2000 = ((CalendarDate)(t2));

          if (t1.modifiedJulianDay == t2000.modifiedJulianDay) {
            return (t1.timeMillis <= t2000.timeMillis);
          }
          else {
            return (t1.modifiedJulianDay <= t2000.modifiedJulianDay);
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
    { CalendarDate t1 = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(t2), Stella.SGT_STELLA_CALENDAR_DATE)) {
        { CalendarDate t2000 = ((CalendarDate)(t2));

          if (t1.modifiedJulianDay == t2000.modifiedJulianDay) {
            return (t1.timeMillis > t2000.timeMillis);
          }
          else {
            return (t1.modifiedJulianDay > t2000.modifiedJulianDay);
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
    { CalendarDate t1 = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(t2), Stella.SGT_STELLA_CALENDAR_DATE)) {
        { CalendarDate t2000 = ((CalendarDate)(t2));

          if (t1.modifiedJulianDay == t2000.modifiedJulianDay) {
            return (t1.timeMillis < t2000.timeMillis);
          }
          else {
            return (t1.modifiedJulianDay < t2000.modifiedJulianDay);
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
    { CalendarDate t1 = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(t2), Stella.SGT_STELLA_CALENDAR_DATE)) {
        { CalendarDate t2000 = ((CalendarDate)(t2));

          if (t1.modifiedJulianDay == t2000.modifiedJulianDay) {
            return (t1.timeMillis == t2000.timeMillis);
          }
          else {
            return (t1.modifiedJulianDay == t2000.modifiedJulianDay);
          }
        }
      }
      else {
        return (false);
      }
    }
  }

  /** Returns a decoded time object for <code>date</code> interpreted in <code>timezone</code>
   * <code>timezone</code> is the number of hours added to UTC to get local time.  It is 
   * in the range -12.0 to +14.0 where UTC is zone 0.0
   * @param timezone
   * @return DecodedDateTime
   */
  public DecodedDateTime decodeCalendarDate(double timezone) {
    { CalendarDate date = this;

      { int hour = Stella.NULL_INTEGER;
        int min = Stella.NULL_INTEGER;
        int sec = Stella.NULL_INTEGER;
        int millis = Stella.NULL_INTEGER;

        { Object [] caller_MV_returnarray = new Object[3];

          hour = date.getTime(timezone, caller_MV_returnarray);
          min = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
          sec = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
          millis = ((int)(((IntegerWrapper)(caller_MV_returnarray[2])).wrapperValue));
        }
        { int year = Stella.NULL_INTEGER;
          int month = Stella.NULL_INTEGER;
          int day = Stella.NULL_INTEGER;
          Keyword dow = null;

          { Object [] caller_MV_returnarray = new Object[3];

            year = date.getCalendarDate(timezone, caller_MV_returnarray);
            month = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
            day = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
            dow = ((Keyword)(caller_MV_returnarray[2]));
          }
          { DecodedDateTime self000 = DecodedDateTime.newDecodedDateTime();

            self000.dateTimeMillis = ((double)(millis));
            self000.dateTimeSecond = sec;
            self000.dateTimeMinute = min;
            self000.dateTimeHour = hour;
            self000.dateTimeDay = day;
            self000.dateTimeMonth = month;
            self000.dateTimeYear = year;
            self000.dateTimeZone = timezone;
            self000.dateTimeDow = dow;
            { DecodedDateTime value000 = self000;

              return (value000);
            }
          }
        }
      }
    }
  }

  /** Returns multiple values of hours, minutes, seconds, milliseconds for
   * the calendar date <code>date</code> in <code>timezone</code>.  <code>timezone</code> is the number of hours added to UTC
   * to get local time.  It is in the range -12.0 to +14.0 where UTC is zone 0.0
   * @param timezone
   * @param MV_returnarray
   * @return int
   */
  public int getTime(double timezone, Object [] MV_returnarray) {
    { CalendarDate date = this;

      if (timezone == Stella.NULL_FLOAT) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Timezone not specified in GET-TIME.  Using local zone.");
        { int year = Stella.NULL_INTEGER;
          int month = Stella.NULL_INTEGER;
          int day = Stella.NULL_INTEGER;
          Keyword dow = null;

          { Object [] caller_MV_returnarray = new Object[3];

            year = Stella.computeCalendarDate(Stella.modifiedJulianDayToJulianDay(date.modifiedJulianDay), caller_MV_returnarray);
            month = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
            day = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
            dow = ((Keyword)(caller_MV_returnarray[2]));
          }
          dow = dow;
          timezone = Stella.getLocalTimeZoneForDate(year, month, day, 12, 0, 0);
        }
      }
      if (timezone == 0.0) {
        return (Stella.decodeTimeInMillis(date.timeMillis, MV_returnarray));
      }
      else if (timezone < 0.0) {
        return (Stella.decodeTimeInMillis(((((int)(date.timeMillis + Stella.MILLIS_PER_DAY + (timezone * Stella.MILLIS_PER_HOUR)))) % Stella.MILLIS_PER_DAY), MV_returnarray));
      }
      else {
        return (Stella.decodeTimeInMillis(((((int)(date.timeMillis + (timezone * Stella.MILLIS_PER_HOUR)))) % Stella.MILLIS_PER_DAY), MV_returnarray));
      }
    }
  }

  /** Returns multiple values of year, month, day and day of week for <code>date</code>
   * in <code>timezone</code>.  <code>timezone</code> is the number of hours added to UTC to get local time.  It
   * is in the range -12.0 to +14.0 where UTC is zone 0.0
   * @param timezone
   * @param MV_returnarray
   * @return int
   */
  public int getCalendarDate(double timezone, Object [] MV_returnarray) {
    { CalendarDate date = this;

      if (timezone == Stella.NULL_FLOAT) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Timezone not specified in GET-CALENDAR-DATE  Using local zone.");
        { int year = Stella.NULL_INTEGER;
          int month = Stella.NULL_INTEGER;
          int day = Stella.NULL_INTEGER;
          Keyword dow = null;

          { Object [] caller_MV_returnarray = new Object[3];

            year = Stella.computeCalendarDate(Stella.modifiedJulianDayToJulianDay(date.modifiedJulianDay), caller_MV_returnarray);
            month = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
            day = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
            dow = ((Keyword)(caller_MV_returnarray[2]));
          }
          dow = dow;
          timezone = Stella.getLocalTimeZoneForDate(year, month, day, 12, 0, 0);
        }
      }
      { int time = date.timeMillis;
        int timezoneAdjustedTime = ((int)(time + (timezone * Stella.MILLIS_PER_HOUR)));
        int dayOffset = 0;

        if (timezoneAdjustedTime < 0) {
          dayOffset = -1;
        }
        else if (timezoneAdjustedTime > Stella.MILLIS_PER_DAY) {
          dayOffset = 1;
        }
        else {
        }
        return (Stella.computeCalendarDate(Stella.modifiedJulianDayToJulianDay(date.modifiedJulianDay + dayOffset), MV_returnarray));
      }
    }
  }

  public void printCalendarDate(edu.isi.stella.javalib.NativeOutputStream stream) {
    { CalendarDate date = this;

      if (((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue()) {
        stream.print("\"");
      }
      else {
        stream.print("<" + date.modifiedJulianDay + " ");
      }
      stream.print(date.calendarDateToString(0.0, false, false));
      if (((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue()) {
        stream.print(" UTC\"");
      }
      else {
        stream.print(" UTC>");
      }
    }
  }

  public long calendarDateToNativeDateTime() {
    { CalendarDate date = this;

      { int mjd = date.modifiedJulianDay;
        int millis = date.timeMillis;

        return ((((long)mjd - 40588L) * 86400000L) + (long)millis);
      }
    }
  }

  /** Returns an ISO-8601 string representation of <code>date</code> adjusted for <code>timezone</code>.
   * The Format is YYYY-MM-DDThh:mm:ss z:zz.  The timezone as an offset
   * hh:mm is included if <code>includeTimezoneP</code> is <code>true</code>.
   * <p>
   * Recommended values for the flag is <code>true</code>.
   * @param timezone
   * @param includeTimezoneP
   * @return String
   */
  public String calendarDateToIso8601String(double timezone, boolean includeTimezoneP) {
    { CalendarDate date = this;

      { String tzString = "";

        if (includeTimezoneP) {
          if (timezone == 0.0) {
            tzString = "Z";
          }
          else {
            tzString = Stella.timeZoneFormat60(timezone, true);
          }
        }
        return (date.calendarDateToDateString(timezone, true) + "T" + date.calendarDateToTimeString(timezone, false, false, true) + tzString);
      }
    }
  }

  /** Returns a string representation of <code>date</code> adjusted for <code>timezone</code>.
   * The Format is YYYY-MMM-DD hh:mm:ss z.z, where MMM is a three letter
   * English abbreviation of the month if <code>numericMonthP</code> is <code>false</code> and a two
   * digit numeric value if <code>numericMonthP</code> is <code>true</code>.  The timezone as a
   * float offset z.z is included if <code>includeTimezoneP</code> is <code>true</code>.
   * <p>
   * Recommended values for the flags are <code>false</code> and <code>true</code> respectively.
   * @param timezone
   * @param numericMonthP
   * @param includeTimezoneP
   * @return String
   */
  public String calendarDateToString(double timezone, boolean numericMonthP, boolean includeTimezoneP) {
    { CalendarDate date = this;

      return (date.calendarDateToDateString(timezone, numericMonthP) + " " + date.calendarDateToTimeString(timezone, includeTimezoneP, true, false));
    }
  }

  /** Returns the time part of the string representation of <code>date</code>
   * adjusted for <code>timezone</code>.  The timezone is included in the string if
   * <code>includeTimezoneP</code> is <code>true</code>.  The value <code>true</code> is recommended.
   * Milliseconds will be included if <code>includeMillisP</code> is <code>true</code>.
   * Hours will be zero-padded to length 2 if <code>padHoursP</code> is <code>true</code>.
   * 
   * @param timezone
   * @param includeTimezoneP
   * @param includeMillisP
   * @param padHoursP
   * @return String
   */
  public String calendarDateToTimeString(double timezone, boolean includeTimezoneP, boolean includeMillisP, boolean padHoursP) {
    { CalendarDate date = this;

      { int hours = Stella.NULL_INTEGER;
        int minutes = Stella.NULL_INTEGER;
        int seconds = Stella.NULL_INTEGER;
        int milli = Stella.NULL_INTEGER;

        { Object [] caller_MV_returnarray = new Object[3];

          hours = date.getTime(timezone, caller_MV_returnarray);
          minutes = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
          seconds = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
          milli = ((int)(((IntegerWrapper)(caller_MV_returnarray[2])).wrapperValue));
        }
        { String timezoneString = (includeTimezoneP ? (((timezone == 0.0) ? " UTC" : (" " + Native.floatToString(timezone)))) : "");
          String milliString = (includeMillisP ? ("." + Stella.formatWithPadding(Native.integerToString(((long)(milli))), 3, '0', Stella.KWD_RIGHT, false)) : "");

          return (((padHoursP ? Stella.formatWithPadding(Native.integerToString(((long)(hours))), 2, '0', Stella.KWD_RIGHT, false) : Native.integerToString(((long)(hours))))) + ":" + Stella.formatWithPadding(Native.integerToString(((long)(minutes))), 2, '0', Stella.KWD_RIGHT, false) + ":" + Stella.formatWithPadding(Native.integerToString(((long)(seconds))), 2, '0', Stella.KWD_RIGHT, false) + milliString + timezoneString);
        }
      }
    }
  }

  /** Returns the date part of the string representation of <code>date</code> 
   * adjusted for <code>timezone</code>.  Format is YYYY-MMM-DD, where MMM is a three letter
   * English abbreviation of the month if <code>numericMonthP</code> is <code>false</code> and a two
   * digit numeric value if <code>numericMonthP</code> is <code>true</code>.  The value <code>false</code> is
   * recommended.
   * @param timezone
   * @param numericMonthP
   * @return String
   */
  public String calendarDateToDateString(double timezone, boolean numericMonthP) {
    { CalendarDate date = this;

      { int year = Stella.NULL_INTEGER;
        int month = Stella.NULL_INTEGER;
        int day = Stella.NULL_INTEGER;
        Keyword dow = null;

        { Object [] caller_MV_returnarray = new Object[3];

          year = date.getCalendarDate(timezone, caller_MV_returnarray);
          month = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
          day = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
          dow = ((Keyword)(caller_MV_returnarray[2]));
        }
        dow = dow;
        { String yearString = ((year < 0) ? (Native.integerToString(((long)(0 - year))) + "BC") : Native.integerToString(((long)(year))));
          String monthString = (numericMonthP ? Stella.formatWithPadding(Native.integerToString(((long)(month))), 2, '0', Stella.KWD_RIGHT, false) : StringWrapper.unwrapString(((StringWrapper)((Stella.$MONTH_ABBREVIATION_VECTOR$.theArray)[month]))));

          return (yearString + "-" + monthString + "-" + Stella.formatWithPadding(Native.integerToString(((long)(day))), 2, '0', Stella.KWD_RIGHT, false));
        }
      }
    }
  }

  public int hashCode_() {
    { CalendarDate self = this;

      return (((self.modifiedJulianDay) ^ (self.timeMillis)));
    }
  }

  public Quantity coerceTo(Stella_Object y) {
    { CalendarDate x = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(y), Stella.SGT_STELLA_CALENDAR_DATE)) {
        { CalendarDate y000 = ((CalendarDate)(y));

          return (y000);
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Can't coerce `" + y + "' to a CALENDAR-DATE");
          throw ((IncompatibleQuantityException)(IncompatibleQuantityException.newIncompatibleQuantityException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { CalendarDate self = this;

      self.printCalendarDate(stream);
    }
  }

  public static Stella_Object accessCalendarDateSlotValue(CalendarDate self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_MODIFIED_JULIAN_DAY) {
      if (setvalueP) {
        self.modifiedJulianDay = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.modifiedJulianDay);
      }
    }
    else if (slotname == Stella.SYM_STELLA_TIME_MILLIS) {
      if (setvalueP) {
        self.timeMillis = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.timeMillis);
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
    { CalendarDate self = this;

      return (Stella.SGT_STELLA_CALENDAR_DATE);
    }
  }

}

