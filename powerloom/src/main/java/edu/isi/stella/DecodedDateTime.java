//  -*- Mode: Java -*-
//
// DecodedDateTime.java

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

/** A data structure for holding decoded time values with fields
 * for easy access of the components.
 * @author Stella Java Translator
 */
public class DecodedDateTime extends StandardObject {
    public double dateTimeMillis;
    public int dateTimeSecond;
    public int dateTimeMinute;
    public int dateTimeHour;
    public int dateTimeDay;
    public int dateTimeMonth;
    public int dateTimeYear;
    public double dateTimeZone;
    public Keyword dateTimeDow;

  /** Returns a decoded date-time object representing the date
   * and time parsed from the <code>input</code> string.  If no valid parse is found,
   * <code>null</code> is returned.
   * @param input
   * @return DecodedDateTime
   */
  public static DecodedDateTime stringToDecodedDateTime(String input) {
    return (DecodedDateTime.parseDateTimeInTimeZone(input, Stella.NULL_FLOAT, 0, Stella.NULL_INTEGER, false));
  }

  /** Tries very hard to make sense out of the argument <code>dateTimeString</code> and
   * returns a time structure if successful.  If not, it returns <code>null</code>.
   * If <code>errorOnMismatchP</code> is true, parse-date-time will signal an error instead of
   * returning <code>null</code>.  
   * Default values are 00:00:00 local time on the current date
   * @param dateTimeString
   * @param start
   * @param end
   * @param errorOnMismatchP
   * @return DecodedDateTime
   */
  public static DecodedDateTime parseDateTime(String dateTimeString, int start, int end, boolean errorOnMismatchP) {
    return (DecodedDateTime.parseDateTimeInTimeZone(dateTimeString, Stella.NULL_FLOAT, start, end, errorOnMismatchP));
  }

  /** Tries very hard to make sense out of the argument <code>dateTimeString</code> and
   * returns a time structure if successful.  If not, it returns <code>null</code>.
   * If <code>errorOnMismatchP</code> is true, parse-date-time will signal an error instead of
   * returning <code>null</code>.  
   * Default values are 00:00:00 in the given timezone on the current date.  If the
   * given <code>timeZone</code> value is <code>null</code>, then the local time zone for the given date
   * and time will be used as determined by the operating system.
   * @param dateTimeString
   * @param timeZone
   * @param start
   * @param end
   * @param errorOnMismatchP
   * @return DecodedDateTime
   */
  public static DecodedDateTime parseDateTimeInTimeZone(String dateTimeString, double timeZone, int start, int end, boolean errorOnMismatchP) {
    { DecodedDateTime defaultValues = CalendarDate.makeCurrentDateTime().decodeCalendarDate(((timeZone == Stella.NULL_FLOAT) ? Stella.getLocalTimeZone() : timeZone));

      defaultValues.dateTimeMillis = 0.0;
      defaultValues.dateTimeSecond = 0;
      defaultValues.dateTimeMinute = 0;
      defaultValues.dateTimeHour = 0;
      defaultValues.dateTimeZone = timeZone;
      return (DecodedDateTime.helpParseDateTimeRelativeToBase(dateTimeString, defaultValues, start, end, errorOnMismatchP, true));
    }
  }

  /** Tries very hard to make sense out of the argument <code>dateTimeString</code> and
   * returns a time structure if successful.  If not, it returns <code>null</code>.
   * If <code>errorOnMismatchP</code> is true, parse-date-time will signal an error instead of
   * returning <code>null</code>.
   * Default values are passed in via <code>baseDateTime</code>.  If the timezone field that
   * is passed in is NULL, then the local time zone for the parsed date/time will
   * be used.
   * If <code>mergeNullFieldsP</code> is <code>true</code>, then default values from <code>baseTimeDate</code>
   * will be merged into missing components.  If <code>false</code>, then they won't be merged
   * in for null components but can still be used as a basis for interpreatation of
   * relative time strings like &quot;now&quot; or &quot;yesterday&quot;
   * @param dateTimeString
   * @param baseDateTime
   * @param start
   * @param end
   * @param errorOnMismatchP
   * @param mergeNullFieldsP
   * @return DecodedDateTime
   */
  public static DecodedDateTime parseDateTimeRelativeToBase(String dateTimeString, DecodedDateTime baseDateTime, int start, int end, boolean errorOnMismatchP, boolean mergeNullFieldsP) {
    return (DecodedDateTime.helpParseDateTimeRelativeToBase(dateTimeString, baseDateTime, start, end, errorOnMismatchP, mergeNullFieldsP));
  }

  static DecodedDateTime helpParseDateTimeRelativeToBase(String dateTimeString, DecodedDateTime baseDateTime, int start, int end, boolean errorOnMismatchP, boolean mergeNullFieldsP) {
    { Object old$ErrorOnMismatch$000 = Stella.$ERROR_ON_MISMATCH$.get();

      try {
        Native.setBooleanSpecial(Stella.$ERROR_ON_MISMATCH$, errorOnMismatchP);
        { Cons stringForm = Stella.matchDateTimePatterns(dateTimeString, start, end, errorOnMismatchP);

          { DecodedDateTime self000 = DecodedDateTime.newDecodedDateTime();

            self000.dateTimeMillis = Stella.NULL_FLOAT;
            self000.dateTimeSecond = Stella.NULL_INTEGER;
            self000.dateTimeMinute = Stella.NULL_INTEGER;
            self000.dateTimeHour = Stella.NULL_INTEGER;
            self000.dateTimeDay = Stella.NULL_INTEGER;
            self000.dateTimeMonth = Stella.NULL_INTEGER;
            self000.dateTimeYear = Stella.NULL_INTEGER;
            self000.dateTimeZone = Stella.NULL_FLOAT;
            self000.dateTimeDow = null;
            { DecodedDateTime parsedValues = self000;

              if (stringForm == null) {
                return (null);
              }
              Cons.setTimeValues(stringForm, parsedValues, baseDateTime);
              if (parsedValues.dateTimeZone == Stella.NULL_FLOAT) {
                parsedValues.dateTimeZone = baseDateTime.dateTimeZone;
                if (parsedValues.dateTimeZone == Stella.NULL_FLOAT) {
                  parsedValues.dateTimeZone = Stella.getLocalTimeZoneForDate(baseDateTime.dateTimeYear, baseDateTime.dateTimeMonth, baseDateTime.dateTimeDay, baseDateTime.dateTimeHour, baseDateTime.dateTimeMinute, baseDateTime.dateTimeSecond);
                }
              }
              if (mergeNullFieldsP) {
                parsedValues.mergeNullFields(baseDateTime);
              }
              return (parsedValues);
            }
          }
        }

      } finally {
        Stella.$ERROR_ON_MISMATCH$.set(old$ErrorOnMismatch$000);
      }
    }
  }

  public static DecodedDateTime newDecodedDateTime() {
    { DecodedDateTime self = null;

      self = new DecodedDateTime();
      self.dateTimeDow = Stella.KWD_SUNDAY;
      self.dateTimeZone = 0.0;
      self.dateTimeYear = 1900;
      self.dateTimeMonth = 1;
      self.dateTimeDay = 1;
      self.dateTimeHour = 0;
      self.dateTimeMinute = 0;
      self.dateTimeSecond = 0;
      self.dateTimeMillis = 0.0;
      return (self);
    }
  }

  public static void now(DecodedDateTime parsedValues, DecodedDateTime defaultValues) {
    { double timeZone = parsedValues.dateTimeZone;

      if (timeZone == Stella.NULL_FLOAT) {
        timeZone = defaultValues.dateTimeZone;
        if (timeZone == Stella.NULL_FLOAT) {
          timeZone = Stella.getLocalTimeZone();
        }
      }
      { int hour = Stella.NULL_INTEGER;
        int minute = Stella.NULL_INTEGER;
        int second = Stella.NULL_INTEGER;
        int millis = Stella.NULL_INTEGER;

        { Object [] caller_MV_returnarray = new Object[3];

          hour = CalendarDate.makeCurrentDateTime().getTime(timeZone, caller_MV_returnarray);
          minute = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
          second = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
          millis = ((int)(((IntegerWrapper)(caller_MV_returnarray[2])).wrapperValue));
        }
        parsedValues.dateTimeMillis = ((double)(millis));
        parsedValues.dateTimeSecond = second;
        parsedValues.dateTimeMinute = minute;
        parsedValues.dateTimeHour = hour;
      }
    }
  }

  public static void tomorrow(DecodedDateTime parsedValues, DecodedDateTime defaultValues) {
    DecodedDateTime.today(parsedValues, defaultValues);
    if ((parsedValues.dateTimeYear != Stella.NULL_INTEGER) &&
        ((parsedValues.dateTimeMonth != Stella.NULL_INTEGER) &&
         (parsedValues.dateTimeDay != Stella.NULL_INTEGER))) {
      { int jd = Stella.computeJulianDay(parsedValues.dateTimeYear, parsedValues.dateTimeMonth, parsedValues.dateTimeDay);

        { int year = Stella.NULL_INTEGER;
          int month = Stella.NULL_INTEGER;
          int day = Stella.NULL_INTEGER;
          Keyword dow = null;

          { Object [] caller_MV_returnarray = new Object[3];

            year = Stella.computeCalendarDate(jd + 1, caller_MV_returnarray);
            month = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
            day = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
            dow = ((Keyword)(caller_MV_returnarray[2]));
          }
          parsedValues.dateTimeDay = day;
          parsedValues.dateTimeMonth = month;
          parsedValues.dateTimeYear = year;
          parsedValues.dateTimeDow = dow;
        }
      }
    }
  }

  public static void today(DecodedDateTime parsedValues, DecodedDateTime defaultValues) {
    parsedValues.dateTimeDay = defaultValues.dateTimeDay;
    if (parsedValues.dateTimeMonth == Stella.NULL_INTEGER) {
      parsedValues.dateTimeMonth = defaultValues.dateTimeMonth;
    }
    if (parsedValues.dateTimeYear == Stella.NULL_INTEGER) {
      parsedValues.dateTimeYear = defaultValues.dateTimeYear;
    }
    parsedValues.setConsistentDow();
    return;
  }

  public static void yesterday(DecodedDateTime parsedValues, DecodedDateTime defaultValues) {
    DecodedDateTime.today(parsedValues, defaultValues);
    if ((parsedValues.dateTimeYear != Stella.NULL_INTEGER) &&
        ((parsedValues.dateTimeMonth != Stella.NULL_INTEGER) &&
         (parsedValues.dateTimeDay != Stella.NULL_INTEGER))) {
      { int jd = Stella.computeJulianDay(parsedValues.dateTimeYear, parsedValues.dateTimeMonth, parsedValues.dateTimeDay);

        { int year = Stella.NULL_INTEGER;
          int month = Stella.NULL_INTEGER;
          int day = Stella.NULL_INTEGER;
          Keyword dow = null;

          { Object [] caller_MV_returnarray = new Object[3];

            year = Stella.computeCalendarDate(jd - 1, caller_MV_returnarray);
            month = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
            day = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
            dow = ((Keyword)(caller_MV_returnarray[2]));
          }
          parsedValues.dateTimeDay = day;
          parsedValues.dateTimeMonth = month;
          parsedValues.dateTimeYear = year;
          parsedValues.dateTimeDow = dow;
        }
      }
    }
  }

  public static void formatDateErrorHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    {
      stream = stream;
      flag = flag;
      date = date;
    }
    { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

      stream000.nativeStream.print("format-date: illegal control character: `" + cont + "'");
      throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
    }
  }

  public static void formatDateTimeAlphabeticZoneHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    {
      stream = stream;
      flag = flag;
      date = date;
    }
    { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

      stream000.nativeStream.print("format-date: control not yet implemented: `" + cont + "'");
      throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
    }
  }

  public static void formatDateNumericTimeZoneHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    cont = cont;
    stream.nativeStream.print(Stella.timeZoneFormat60(date.dateTimeZone, flag == ':'));
  }

  public static void formatDateYearHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    cont = cont;
    if (date.dateTimeYear < 1000) {
      switch (flag) {
        case '_': 
          stream.nativeStream.print(Stella.formatWithPadding(Native.integerToString(((long)(date.dateTimeYear))), 4, ' ', Stella.KWD_RIGHT, false));
          return;
        case '0': 
        case ' ': 
          stream.nativeStream.print(Stella.formatWithPadding(Native.integerToString(((long)(date.dateTimeYear))), 4, '0', Stella.KWD_RIGHT, false));
          return;
        default:
        break;
      }
    }
    stream.nativeStream.print(date.dateTimeYear);
  }

  public static void formatDateTwoDigitYearHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    {
      cont = cont;
      flag = flag;
    }
    { int year = Stella.integer_mod(date.dateTimeYear, 100);

      Stella.formatDatePrintTwoDigitNumber(year, '0', stream);
    }
  }

  public static void formatDateFullTimeHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    {
      cont = cont;
      flag = flag;
    }
    DecodedDateTime.formatDate24HourHandler(date, 'H', '0', stream);
    stream.nativeStream.print(":");
    DecodedDateTime.formatDateMinuteHandler(date, 'M', '0', stream);
    stream.nativeStream.print(":");
    DecodedDateTime.formatDateSecondHandler(date, 'S', '0', stream);
  }

  public static void formatDateSecondHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    cont = cont;
    Stella.formatDatePrintTwoDigitNumber(date.dateTimeSecond, flag, stream);
  }

  public static void formatDate24HourAndMinuteTimeHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    {
      cont = cont;
      flag = flag;
    }
    DecodedDateTime.formatDate24HourHandler(date, 'H', '0', stream);
    stream.nativeStream.print(":");
    DecodedDateTime.formatDateMinuteHandler(date, 'M', '0', stream);
  }

  public static void formatDate12HourClockTimeHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    {
      cont = cont;
      flag = flag;
    }
    DecodedDateTime.formatDate12HourHandler(date, 'I', '0', stream);
    stream.nativeStream.print(":");
    DecodedDateTime.formatDateMinuteHandler(date, 'M', '0', stream);
    stream.nativeStream.print(":");
    DecodedDateTime.formatDateSecondHandler(date, 'S', '0', stream);
    stream.nativeStream.print(" ");
    DecodedDateTime.formatDateAmPmHandler(date, 'p', '^', stream);
  }

  public static void formatDateAmPmHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    cont = cont;
    { String ampm = ((date.dateTimeHour < 12) ? "AM" : "PM");

      if (flag == Stella.NULL_CHARACTER) {
        flag = '^';
      }
      Stella.formatDatePrintString(ampm, flag, 0, 2, stream);
    }
  }

  public static void formatDateMinuteHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    cont = cont;
    Stella.formatDatePrintTwoDigitNumber(date.dateTimeMinute, flag, stream);
  }

  public static void formatDateMonthHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    cont = cont;
    Stella.formatDatePrintTwoDigitNumber(date.dateTimeMonth, flag, stream);
  }

  public static void formatDate12HourHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    cont = cont;
    { int hour = Stella.integer_mod(date.dateTimeHour - 1, 12) + 1;

      Stella.formatDatePrintTwoDigitNumber(hour, flag, stream);
    }
  }

  public static void formatDate24HourHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    cont = cont;
    Stella.formatDatePrintTwoDigitNumber(date.dateTimeHour, flag, stream);
  }

  public static void formatDateFullDateHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    {
      cont = cont;
      flag = flag;
    }
    DecodedDateTime.formatDateMonthHandler(date, 'm', '0', stream);
    stream.nativeStream.print("/");
    DecodedDateTime.formatDateDayOfMonthHandler(date, 'd', '0', stream);
    stream.nativeStream.print("/");
    DecodedDateTime.formatDateTwoDigitYearHandler(date, 'y', '0', stream);
  }

  public static void formatDateDayOfMonthHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    cont = cont;
    Stella.formatDatePrintTwoDigitNumber(date.dateTimeDay, flag, stream);
  }

  public static void formatDateFullMonthHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    cont = cont;
    Stella.formatDatePrintString(((StringWrapper)((Stella.$MONTH_NAME_VECTOR$.theArray)[(date.dateTimeMonth)])).wrapperValue, flag, 0, -1, stream);
  }

  public static void formatDateAbbreviatedMonthHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    cont = cont;
    Stella.formatDatePrintString(((StringWrapper)((Stella.$MONTH_ABBREVIATION_VECTOR$.theArray)[(date.dateTimeMonth)])).wrapperValue, flag, 0, -1, stream);
  }

  public static void formatDateFullWeekdayHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    cont = cont;
    Stella.formatDatePrintString(date.dateTimeDow.symbolName, flag, 0, -1, stream);
  }

  public static void formatDateAbbreviatedWeekdayHandler(DecodedDateTime date, char cont, char flag, OutputStream stream) {
    cont = cont;
    Stella.formatDatePrintString(date.dateTimeDow.symbolName, flag, 0, 3, stream);
  }

  /** Returns a calendar date object for <code>timeStructure</code>.
   * @return CalendarDate
   */
  public CalendarDate encodeCalendarDate() {
    { DecodedDateTime timeStructure = this;

      return (CalendarDate.makeDateTime(((timeStructure.dateTimeYear != Stella.NULL_INTEGER) ? timeStructure.dateTimeYear : Stella.$DEFAULT_DECODED_DATE_TIME$.dateTimeYear), ((timeStructure.dateTimeMonth != Stella.NULL_INTEGER) ? timeStructure.dateTimeMonth : Stella.$DEFAULT_DECODED_DATE_TIME$.dateTimeMonth), ((timeStructure.dateTimeDay != Stella.NULL_INTEGER) ? timeStructure.dateTimeDay : Stella.$DEFAULT_DECODED_DATE_TIME$.dateTimeDay), ((timeStructure.dateTimeHour != Stella.NULL_INTEGER) ? timeStructure.dateTimeHour : Stella.$DEFAULT_DECODED_DATE_TIME$.dateTimeHour), ((timeStructure.dateTimeMinute != Stella.NULL_INTEGER) ? timeStructure.dateTimeMinute : Stella.$DEFAULT_DECODED_DATE_TIME$.dateTimeMinute), ((timeStructure.dateTimeSecond != Stella.NULL_INTEGER) ? timeStructure.dateTimeSecond : Stella.$DEFAULT_DECODED_DATE_TIME$.dateTimeSecond), ((timeStructure.dateTimeMillis != Stella.NULL_FLOAT) ? Native.round(timeStructure.dateTimeMillis) : Native.round(Stella.$DEFAULT_DECODED_DATE_TIME$.dateTimeMillis)), ((timeStructure.dateTimeZone != Stella.NULL_FLOAT) ? timeStructure.dateTimeZone : Stella.$DEFAULT_DECODED_DATE_TIME$.dateTimeZone)));
    }
  }

  /** Replace only null valued fields in <code>self</code> that represent larger
   * time units than the smallest non-null in <code>self</code> with values from <code>renamed_Default</code>.
   * The day of the week will be set consistently, if possible.
   * Example: if <code>self</code> just has the month being non-null, then only the year
   * will be filled in from <code>renamed_Default</code>.  If the day and minute were non-null,
   * then hour, month and year will be filled.
   * <p>
   * This can be useful when one doesn't want to extend the precision
   * of the answer.
   * @param renamed_Default
   */
  public void mergeSuperiorNullFields(DecodedDateTime renamed_Default) {
    { DecodedDateTime self = this;

      if (self.dateTimeMillis != Stella.NULL_FLOAT) {
        self.helpMergeNullFields(renamed_Default, 6);
      }
      else if (self.dateTimeSecond != Stella.NULL_INTEGER) {
        self.helpMergeNullFields(renamed_Default, 5);
      }
      else if (self.dateTimeMinute != Stella.NULL_INTEGER) {
        self.helpMergeNullFields(renamed_Default, 4);
      }
      else if (self.dateTimeHour != Stella.NULL_INTEGER) {
        self.helpMergeNullFields(renamed_Default, 3);
      }
      else if (self.dateTimeDay != Stella.NULL_INTEGER) {
        self.helpMergeNullFields(renamed_Default, 2);
      }
      else if (self.dateTimeMonth != Stella.NULL_INTEGER) {
        self.helpMergeNullFields(renamed_Default, 1);
      }
      else {
        self.helpMergeNullFields(renamed_Default, 0);
      }
    }
  }

  /** Replace any null valued fields in <code>self</code> with values from <code>renamed_Default</code>.
   * The day of the week will be set consistently, if possible.
   * @param renamed_Default
   */
  public void mergeNullFields(DecodedDateTime renamed_Default) {
    { DecodedDateTime self = this;

      self.helpMergeNullFields(renamed_Default, 6);
    }
  }

  void helpMergeNullFields(DecodedDateTime renamed_Default, int index) {
    { DecodedDateTime self = this;

      if ((self.dateTimeYear == Stella.NULL_INTEGER) &&
          (index >= 0)) {
        self.dateTimeYear = renamed_Default.dateTimeYear;
      }
      if ((self.dateTimeMonth == Stella.NULL_INTEGER) &&
          (index >= 1)) {
        self.dateTimeMonth = renamed_Default.dateTimeMonth;
      }
      if ((self.dateTimeDay == Stella.NULL_INTEGER) &&
          (index >= 2)) {
        self.dateTimeDay = renamed_Default.dateTimeDay;
      }
      if ((self.dateTimeHour == Stella.NULL_INTEGER) &&
          (index >= 3)) {
        self.dateTimeHour = renamed_Default.dateTimeHour;
      }
      if ((self.dateTimeMinute == Stella.NULL_INTEGER) &&
          (index >= 4)) {
        self.dateTimeMinute = renamed_Default.dateTimeMinute;
      }
      if ((self.dateTimeSecond == Stella.NULL_INTEGER) &&
          (index >= 5)) {
        self.dateTimeSecond = renamed_Default.dateTimeSecond;
      }
      if ((self.dateTimeMillis == Stella.NULL_FLOAT) &&
          (index >= 6)) {
        self.dateTimeMillis = renamed_Default.dateTimeMillis;
      }
      if (self.dateTimeZone == Stella.NULL_FLOAT) {
        self.dateTimeZone = renamed_Default.dateTimeZone;
      }
      self.setConsistentDow();
    }
  }

  void setConsistentDow() {
    { DecodedDateTime self = this;

      if ((self.dateTimeYear != Stella.NULL_INTEGER) &&
          ((self.dateTimeMonth != Stella.NULL_INTEGER) &&
           (self.dateTimeDay != Stella.NULL_INTEGER))) {
        self.dateTimeDow = Stella.computeDayOfWeek(self.dateTimeYear, self.dateTimeMonth, self.dateTimeDay);
      }
    }
  }

  /** Returns an ISO-8601 string representation of <code>date</code>
   * The Format is YYYY-MM-DDThh:mm:ss+zz:zz, with the string stopping at
   * when a null value is first encountered.  The time zone will only
   * be included (if present) if a time value is given.
   * @return String
   */
  public String decodedDateTimeToIso8601String() {
    { DecodedDateTime date = this;

      { StringBuffer buffer = Stella.makeRawMutableString(25);
        int index = 0;

        if (date.dateTimeYear != Stella.NULL_INTEGER) {
          index = Stella.insertString(Native.integerToString(((long)(date.dateTimeYear))), 0, Stella.NULL_INTEGER, buffer, index, Stella.KWD_PRESERVE);
          if (date.dateTimeMonth != Stella.NULL_INTEGER) {
            index = Stella.insertString("-", 0, Stella.NULL_INTEGER, buffer, index, Stella.KWD_PRESERVE);
            index = Stella.insertString(Stella.formatWithPadding(Native.integerToString(((long)(date.dateTimeMonth))), 2, '0', Stella.KWD_RIGHT, false), 0, Stella.NULL_INTEGER, buffer, index, Stella.KWD_PRESERVE);
            if (date.dateTimeDay != Stella.NULL_INTEGER) {
              index = Stella.insertString("-", 0, Stella.NULL_INTEGER, buffer, index, Stella.KWD_PRESERVE);
              index = Stella.insertString(Stella.formatWithPadding(Native.integerToString(((long)(date.dateTimeDay))), 2, '0', Stella.KWD_RIGHT, false), 0, Stella.NULL_INTEGER, buffer, index, Stella.KWD_PRESERVE);
              if (date.dateTimeHour != Stella.NULL_INTEGER) {
                index = Stella.insertString("T", 0, Stella.NULL_INTEGER, buffer, index, Stella.KWD_PRESERVE);
                index = Stella.insertString(Stella.formatWithPadding(Native.integerToString(((long)(date.dateTimeHour))), 2, '0', Stella.KWD_RIGHT, false), 0, Stella.NULL_INTEGER, buffer, index, Stella.KWD_PRESERVE);
                if (date.dateTimeMinute != Stella.NULL_INTEGER) {
                  index = Stella.insertString(":", 0, Stella.NULL_INTEGER, buffer, index, Stella.KWD_PRESERVE);
                  index = Stella.insertString(Stella.formatWithPadding(Native.integerToString(((long)(date.dateTimeMinute))), 2, '0', Stella.KWD_RIGHT, false), 0, Stella.NULL_INTEGER, buffer, index, Stella.KWD_PRESERVE);
                  if (date.dateTimeSecond != Stella.NULL_INTEGER) {
                    index = Stella.insertString(":", 0, Stella.NULL_INTEGER, buffer, index, Stella.KWD_PRESERVE);
                    index = Stella.insertString(Stella.formatWithPadding(Native.integerToString(((long)(date.dateTimeSecond))), 2, '0', Stella.KWD_RIGHT, false), 0, Stella.NULL_INTEGER, buffer, index, Stella.KWD_PRESERVE);
                  }
                }
                if (date.dateTimeZone != Stella.NULL_FLOAT) {
                  if (date.dateTimeZone == 0.0) {
                    index = Stella.insertString("Z", 0, Stella.NULL_INTEGER, buffer, index, Stella.KWD_PRESERVE);
                  }
                  else {
                    index = Stella.insertString(Stella.timeZoneFormat60(date.dateTimeZone, true), 0, Stella.NULL_INTEGER, buffer, index, Stella.KWD_PRESERVE);
                  }
                }
              }
            }
          }
        }
        return (Native.mutableString_subsequence(buffer, 0, index));
      }
    }
  }

  /** Sets the current date and time into <code>valuesStructure</code>
   */
  public void setCurrentDateTime() {
    { DecodedDateTime valuesStructure = this;

      { int year = Stella.NULL_INTEGER;
        int mon = Stella.NULL_INTEGER;
        int day = Stella.NULL_INTEGER;
        Keyword dow = null;
        int hour = Stella.NULL_INTEGER;
        int min = Stella.NULL_INTEGER;
        int sec = Stella.NULL_INTEGER;
        int millis = Stella.NULL_INTEGER;

        { Object [] caller_MV_returnarray = new Object[7];

          year = Stella.getCurrentDateTime(caller_MV_returnarray);
          mon = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
          day = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
          dow = ((Keyword)(caller_MV_returnarray[2]));
          hour = ((int)(((IntegerWrapper)(caller_MV_returnarray[3])).wrapperValue));
          min = ((int)(((IntegerWrapper)(caller_MV_returnarray[4])).wrapperValue));
          sec = ((int)(((IntegerWrapper)(caller_MV_returnarray[5])).wrapperValue));
          millis = ((int)(((IntegerWrapper)(caller_MV_returnarray[6])).wrapperValue));
        }
        valuesStructure.dateTimeMillis = ((double)(millis));
        valuesStructure.dateTimeSecond = sec;
        valuesStructure.dateTimeMinute = min;
        valuesStructure.dateTimeHour = hour;
        valuesStructure.dateTimeDow = dow;
        valuesStructure.dateTimeDay = day;
        valuesStructure.dateTimeMonth = mon;
        valuesStructure.dateTimeYear = year;
      }
    }
  }

  /** Sets the current date into <code>valuesStructure</code>
   */
  public void setCurrentDate() {
    { DecodedDateTime valuesStructure = this;

      { int year = Stella.NULL_INTEGER;
        int mon = Stella.NULL_INTEGER;
        int day = Stella.NULL_INTEGER;
        Keyword dow = null;
        int hour = Stella.NULL_INTEGER;
        int min = Stella.NULL_INTEGER;
        int sec = Stella.NULL_INTEGER;
        int millis = Stella.NULL_INTEGER;

        { Object [] caller_MV_returnarray = new Object[7];

          year = Stella.getCurrentDateTime(caller_MV_returnarray);
          mon = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
          day = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
          dow = ((Keyword)(caller_MV_returnarray[2]));
          hour = ((int)(((IntegerWrapper)(caller_MV_returnarray[3])).wrapperValue));
          min = ((int)(((IntegerWrapper)(caller_MV_returnarray[4])).wrapperValue));
          sec = ((int)(((IntegerWrapper)(caller_MV_returnarray[5])).wrapperValue));
          millis = ((int)(((IntegerWrapper)(caller_MV_returnarray[6])).wrapperValue));
        }
        {
          hour = hour;
          min = min;
          sec = sec;
          millis = millis;
        }
        valuesStructure.dateTimeDow = dow;
        valuesStructure.dateTimeDay = day;
        valuesStructure.dateTimeMonth = mon;
        valuesStructure.dateTimeYear = year;
      }
    }
  }

  /** Sets the current time into <code>valuesStructure</code>
   */
  public void setCurrentTime() {
    { DecodedDateTime valuesStructure = this;

      { int year = Stella.NULL_INTEGER;
        int mon = Stella.NULL_INTEGER;
        int day = Stella.NULL_INTEGER;
        Keyword dow = null;
        int hour = Stella.NULL_INTEGER;
        int min = Stella.NULL_INTEGER;
        int sec = Stella.NULL_INTEGER;
        int millis = Stella.NULL_INTEGER;

        { Object [] caller_MV_returnarray = new Object[7];

          year = Stella.getCurrentDateTime(caller_MV_returnarray);
          mon = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
          day = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
          dow = ((Keyword)(caller_MV_returnarray[2]));
          hour = ((int)(((IntegerWrapper)(caller_MV_returnarray[3])).wrapperValue));
          min = ((int)(((IntegerWrapper)(caller_MV_returnarray[4])).wrapperValue));
          sec = ((int)(((IntegerWrapper)(caller_MV_returnarray[5])).wrapperValue));
          millis = ((int)(((IntegerWrapper)(caller_MV_returnarray[6])).wrapperValue));
        }
        {
          year = year;
          mon = mon;
          day = day;
          dow = dow;
        }
        valuesStructure.dateTimeMillis = ((double)(millis));
        valuesStructure.dateTimeSecond = sec;
        valuesStructure.dateTimeMinute = min;
        valuesStructure.dateTimeHour = hour;
      }
    }
  }

  public int hashCode_() {
    { DecodedDateTime self = this;

      return (((((((((self.dateTimeYear) << 9)) | (((self.dateTimeMonth) << 5)))) | (self.dateTimeDay))) ^ (((((((self.dateTimeHour) << 12)) | (((self.dateTimeMinute) << 6)))) | (self.dateTimeSecond)))));
    }
  }

  public static Stella_Object accessDecodedDateTimeSlotValue(DecodedDateTime self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_DATE_TIME_MILLIS) {
      if (setvalueP) {
        self.dateTimeMillis = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.dateTimeMillis);
      }
    }
    else if (slotname == Stella.SYM_STELLA_DATE_TIME_SECOND) {
      if (setvalueP) {
        self.dateTimeSecond = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.dateTimeSecond);
      }
    }
    else if (slotname == Stella.SYM_STELLA_DATE_TIME_MINUTE) {
      if (setvalueP) {
        self.dateTimeMinute = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.dateTimeMinute);
      }
    }
    else if (slotname == Stella.SYM_STELLA_DATE_TIME_HOUR) {
      if (setvalueP) {
        self.dateTimeHour = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.dateTimeHour);
      }
    }
    else if (slotname == Stella.SYM_STELLA_DATE_TIME_DAY) {
      if (setvalueP) {
        self.dateTimeDay = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.dateTimeDay);
      }
    }
    else if (slotname == Stella.SYM_STELLA_DATE_TIME_MONTH) {
      if (setvalueP) {
        self.dateTimeMonth = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.dateTimeMonth);
      }
    }
    else if (slotname == Stella.SYM_STELLA_DATE_TIME_YEAR) {
      if (setvalueP) {
        self.dateTimeYear = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.dateTimeYear);
      }
    }
    else if (slotname == Stella.SYM_STELLA_DATE_TIME_ZONE) {
      if (setvalueP) {
        self.dateTimeZone = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.dateTimeZone);
      }
    }
    else if (slotname == Stella.SYM_STELLA_DATE_TIME_DOW) {
      if (setvalueP) {
        self.dateTimeDow = ((Keyword)(value));
      }
      else {
        value = self.dateTimeDow;
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
    { DecodedDateTime self = this;

      return (Stella.SGT_STELLA_DECODED_DATE_TIME);
    }
  }

}

