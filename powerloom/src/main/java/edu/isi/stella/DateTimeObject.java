//  -*- Mode: Java -*-
//
// DateTimeObject.java

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

public abstract class DateTimeObject extends Quantity {
  /** Subtract <code>t2</code> from <code>t1</code>.  If <code>t1</code> is a calendar date, then <code>t2</code> can
   * be either a calendar date (in which case the return value is a relative date) or it
   * can be a relative date (in which case the return value is a calendar date).  If <code>t1</code>
   * is a relative date, then <code>t2</code> must also be a relative date and a relative date is returned.
   * @param t1
   * @param t2
   * @return DateTimeObject
   */
  public static DateTimeObject timeSubtract(DateTimeObject t1, DateTimeObject t2) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(t1);

      if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_CALENDAR_DATE)) {
        { CalendarDate t1000 = ((CalendarDate)(t1));

          { Surrogate testValue001 = Stella_Object.safePrimaryType(t2);

            if (Surrogate.subtypeOfP(testValue001, Stella.SGT_STELLA_CALENDAR_DATE)) {
              { CalendarDate t2000 = ((CalendarDate)(t2));

                return (TimeDuration.makeTimeDuration(t1000.modifiedJulianDay - t2000.modifiedJulianDay, t1000.timeMillis - t2000.timeMillis));
              }
            }
            else if (Surrogate.subtypeOfP(testValue001, Stella.SGT_STELLA_TIME_DURATION)) {
              { TimeDuration t2000 = ((TimeDuration)(t2));

                return (CalendarDate.makeCalendarDate(t1000.modifiedJulianDay - t2000.days, t1000.timeMillis - t2000.millis));
              }
            }
            else {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("`" + testValue001 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_TIME_DURATION)) {
        { TimeDuration t1000 = ((TimeDuration)(t1));

          { Surrogate testValue002 = Stella_Object.safePrimaryType(t2);

            if (Surrogate.subtypeOfP(testValue002, Stella.SGT_STELLA_CALENDAR_DATE)) {
              { CalendarDate t2000 = ((CalendarDate)(t2));

                { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                  stream001.nativeStream.print("You can't subtract a calendar date from a relative date: `" + t1000 + "'  `" + t2000 + "'");
                  throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
                }
              }
            }
            else if (Surrogate.subtypeOfP(testValue002, Stella.SGT_STELLA_TIME_DURATION)) {
              { TimeDuration t2000 = ((TimeDuration)(t2));

                return (TimeDuration.makeTimeDuration(t1000.days - t2000.days, t1000.millis - t2000.millis));
              }
            }
            else {
              { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                stream002.nativeStream.print("`" + testValue002 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream002.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
      }
      else {
        { OutputStringStream stream003 = OutputStringStream.newOutputStringStream();

          stream003.nativeStream.print("`" + testValue000 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream003.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  /** Add <code>t1</code> to <code>t2</code>.
   * If one of <code>t1</code> or <code>t2</code> is a calendar date, then the result is a calendar date.
   * If both <code>t1</code> and <code>t2</code> are relative dates, then the result is a relative date.
   * <code>t1</code> and <code>t2</code> cannot both be calendar dates.
   * @param t1
   * @param t2
   * @return DateTimeObject
   */
  public static DateTimeObject timeAdd(DateTimeObject t1, DateTimeObject t2) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(t1);

      if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_CALENDAR_DATE)) {
        { CalendarDate t1000 = ((CalendarDate)(t1));

          { Surrogate testValue001 = Stella_Object.safePrimaryType(t2);

            if (Surrogate.subtypeOfP(testValue001, Stella.SGT_STELLA_CALENDAR_DATE)) {
              { CalendarDate t2000 = ((CalendarDate)(t2));

                { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                  stream000.nativeStream.print("You can't add two calendar dates: `" + t1000 + "'  `" + t2000 + "'");
                  throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                }
              }
            }
            else if (Surrogate.subtypeOfP(testValue001, Stella.SGT_STELLA_TIME_DURATION)) {
              { TimeDuration t2000 = ((TimeDuration)(t2));

                return (CalendarDate.makeCalendarDate(t1000.modifiedJulianDay + t2000.days, t1000.timeMillis + t2000.millis));
              }
            }
            else {
              { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                stream001.nativeStream.print("`" + testValue001 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_TIME_DURATION)) {
        { TimeDuration t1000 = ((TimeDuration)(t1));

          { Surrogate testValue002 = Stella_Object.safePrimaryType(t2);

            if (Surrogate.subtypeOfP(testValue002, Stella.SGT_STELLA_CALENDAR_DATE)) {
              { CalendarDate t2000 = ((CalendarDate)(t2));

                return (CalendarDate.makeCalendarDate(t1000.days + t2000.modifiedJulianDay, t1000.millis + t2000.timeMillis));
              }
            }
            else if (Surrogate.subtypeOfP(testValue002, Stella.SGT_STELLA_TIME_DURATION)) {
              { TimeDuration t2000 = ((TimeDuration)(t2));

                return (TimeDuration.makeTimeDuration(t1000.days + t2000.days, t1000.millis + t2000.millis));
              }
            }
            else {
              { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                stream002.nativeStream.print("`" + testValue002 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream002.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
      }
      else {
        { OutputStringStream stream003 = OutputStringStream.newOutputStringStream();

          stream003.nativeStream.print("`" + testValue000 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream003.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

}

