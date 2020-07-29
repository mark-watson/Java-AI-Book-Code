//  -*- Mode: Java -*-
//
// Timepoint.java

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
 | The Original Code is the PowerLoom KR&R System.                            |
 |                                                                            |
 | The Initial Developer of the Original Code is                              |
 | UNIVERSITY OF SOUTHERN CALIFORNIA, INFORMATION SCIENCES INSTITUTE          |
 | 4676 Admiralty Way, Marina Del Rey, California 90292, U.S.A.               |
 |                                                                            |
 | Portions created by the Initial Developer are Copyright (C) 1997-2017      |
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
 +----------------------------- END LICENSE BLOCK ----------------------------+
*/

package edu.isi.powerloom.extensions.timepoint;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.powerloom.logic.*;
import edu.isi.stella.*;
import edu.isi.stella.utilities.*;

public class Timepoint {
  /** Table for interning date-time logic wrappers
   */
  public static StellaHashTable $DATE_TIME_HASH_TABLE$ = null;

  public static Surrogate SGT_TIMEPOINT_KB_TIMEPOINT_OF = null;

  public static Surrogate SGT_TIMEPOINT_KB_DURATION_OF = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_TIMEPOINT_OF$_COMPUTATION = null;

  public static Keyword KWD_MONDAY = null;

  public static Surrogate SGT_TIMEPOINT_KB_MONDAY = null;

  public static Keyword KWD_TUESDAY = null;

  public static Surrogate SGT_TIMEPOINT_KB_TUESDAY = null;

  public static Keyword KWD_WEDNESDAY = null;

  public static Surrogate SGT_TIMEPOINT_KB_WEDNESDAY = null;

  public static Keyword KWD_THURSDAY = null;

  public static Surrogate SGT_TIMEPOINT_KB_THURSDAY = null;

  public static Keyword KWD_FRIDAY = null;

  public static Surrogate SGT_TIMEPOINT_KB_FRIDAY = null;

  public static Keyword KWD_SATURDAY = null;

  public static Surrogate SGT_TIMEPOINT_KB_SATURDAY = null;

  public static Keyword KWD_SUNDAY = null;

  public static Surrogate SGT_TIMEPOINT_KB_SUNDAY = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_STARTUP_TIMEPOINT_SUPPORT = null;

  public static Symbol SYM_TIMEPOINT_KB_TIMEPOINT = null;

  public static Symbol SYM_TIMEPOINT_KB_DAY_OF_WEEK = null;

  public static Keyword KWD_CLOSED = null;

  public static Symbol SYM_STELLA_TRUE = null;

  public static Symbol SYM_TIMEPOINT_KB_TIMEPOINT_OF = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_pTP = null;

  public static Keyword KWD_COMPUTED = null;

  public static Keyword KWD_RELATION_CONSTRAINT = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_TIMEPOINT_OF_CONSTRAINT = null;

  public static Keyword KWD_RELATION_SPECIALIST = null;

  public static Symbol SYM_PL_KERNEL_KB_CONSTRAINT_SPECIALIST = null;

  public static Symbol SYM_TIMEPOINT_KB_DURATION_OF = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_DURATION_OF_CONSTRAINT = null;

  public static Symbol SYM_TIMEPOINT_KB_TIME_ = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_TIME_MINUS_CONSTRAINT = null;

  public static Symbol SYM_TIMEPOINT_KB_TIMEi = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_TIME_PLUS_CONSTRAINT = null;

  public static Symbol SYM_TIMEPOINT_KB_TIMEPOINT_OF$ = null;

  public static Keyword KWD_RELATION_EVALUATOR = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_TIMEPOINT_OF$_EVALUATOR = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_TIMEPOINT_OF$_SPECIALIST = null;

  public static Symbol SYM_TIMEPOINT_KB_TIMEPOINT_YEAR = null;

  public static Keyword KWD_RELATION_COMPUTATION = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_TIMEPOINT_YEAR_COMPUTATION = null;

  public static Symbol SYM_PL_KERNEL_KB_COMPUTATION_SPECIALIST = null;

  public static Symbol SYM_TIMEPOINT_KB_TIMEPOINT_MONTH = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_TIMEPOINT_MONTH_COMPUTATION = null;

  public static Symbol SYM_TIMEPOINT_KB_TIMEPOINT_DAY = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_TIMEPOINT_DAY_COMPUTATION = null;

  public static Symbol SYM_TIMEPOINT_KB_TIMEPOINT_DAY_OF_WEEK = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_TIMEPOINT_DAY_OF_WEEK_COMPUTATION = null;

  public static Symbol SYM_TIMEPOINT_KB_TIMEPOINT_HOUR = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_TIMEPOINT_HOUR_COMPUTATION = null;

  public static Symbol SYM_TIMEPOINT_KB_TIMEPOINT_MINUTE = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_TIMEPOINT_MINUTE_COMPUTATION = null;

  public static Symbol SYM_TIMEPOINT_KB_TIMEPOINT_SECOND = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_TIMEPOINT_SECOND_COMPUTATION = null;

  public static Symbol SYM_TIMEPOINT_KB_TIMEPOINT_DATE = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_TIMEPOINT_DATE_COMPUTATION = null;

  public static Symbol SYM_TIMEPOINT_KB_TIMEPOINT_TIME = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_TIMEPOINT_TIME_COMPUTATION = null;

  public static Symbol SYM_TIMEPOINT_KB_FORMAT_TIMEPOINT = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_FORMAT_TIMEPOINT_COMPUTATION = null;

  public static Symbol SYM_TIMEPOINT_KB_CURRENT_TIME = null;

  public static Keyword KWD_lle = null;

  public static Symbol SYM_TIMEPOINT_SUPPORT_STARTUP_TIMEPOINT_KB = null;

  /** Return an interned LOGIC-WRAPPER for <code>value</code>.  This assures us
   * that all logic-wrapped DATE-TIME-OBJECTs are the same object.
   * @param value
   * @return DateTimeLogicWrapper
   */
  public static DateTimeLogicWrapper wrapDateTime(DateTimeObject value) {
    { DateTimeLogicWrapper wrapper = ((DateTimeLogicWrapper)(Timepoint.$DATE_TIME_HASH_TABLE$.lookup(value)));

      if (wrapper == null) {
        wrapper = DateTimeLogicWrapper.newDateTimeLogicWrapper(value);
        Timepoint.$DATE_TIME_HASH_TABLE$.insertAt(value, wrapper);
      }
      return (wrapper);
    }
  }

  public static DateTimeLogicWrapper helpGetCalendarTime(Stella_Object item) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(item);

      if (Surrogate.subtypeOfStringP(testValue000)) {
        { StringWrapper item000 = ((StringWrapper)(item));

          { CalendarDate value = CalendarDate.stringToCalendarDate(item000.wrapperValue);

            if (value != null) {
              return (Timepoint.wrapDateTime(value));
            }
            else {
              return (null);
            }
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, edu.isi.powerloom.extensions.units.Units.SGT_LOGIC_PATTERN_VARIABLE)) {
        { PatternVariable item000 = ((PatternVariable)(item));

          { Stella_Object value = PatternVariable.safeBoundTo(item000);

            if (value != null) {
              return (Timepoint.helpGetCalendarTime(value));
            }
            else {
              return (null);
            }
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, edu.isi.powerloom.extensions.units.Units.SGT_TIMEPOINT_SUPPORT_DATE_TIME_LOGIC_WRAPPER)) {
        { DateTimeLogicWrapper item000 = ((DateTimeLogicWrapper)(item));

          return (item000);
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, edu.isi.powerloom.extensions.units.Units.SGT_LOGIC_SKOLEM)) {
        { Skolem item000 = ((Skolem)(item));

          { Stella_Object value = ((Stella_Object)(Stella_Object.accessInContext(item000.variableValue, item000.homeContext, false)));

            if (value == null) {
              return (null);
            }
            { Surrogate testValue001 = Stella_Object.safePrimaryType(value);

              if (Surrogate.subtypeOfP(testValue001, edu.isi.powerloom.extensions.units.Units.SGT_TIMEPOINT_SUPPORT_DATE_TIME_LOGIC_WRAPPER)) {
                { DateTimeLogicWrapper value000 = ((DateTimeLogicWrapper)(value));

                  return (value000);
                }
              }
              else if (Surrogate.subtypeOfP(testValue001, edu.isi.powerloom.extensions.units.Units.SGT_LOGIC_SKOLEM)) {
                { Skolem value000 = ((Skolem)(value));

                  if (Stella_Object.isaP(((Stella_Object)(Stella_Object.accessInContext(value000.variableValue, value000.homeContext, false))), edu.isi.powerloom.extensions.units.Units.SGT_LOGIC_SKOLEM)) {
                    return (null);
                  }
                  else {
                    return (Timepoint.helpGetCalendarTime(((Stella_Object)(Stella_Object.accessInContext(value000.variableValue, value000.homeContext, false)))));
                  }
                }
              }
              else {
                if (Stella_Object.isaP(((Stella_Object)(Stella_Object.accessInContext(item000.variableValue, item000.homeContext, false))), edu.isi.powerloom.extensions.units.Units.SGT_LOGIC_SKOLEM)) {
                  return (null);
                }
                else {
                  return (Timepoint.helpGetCalendarTime(((Stella_Object)(Stella_Object.accessInContext(item000.variableValue, item000.homeContext, false)))));
                }
              }
            }
          }
        }
      }
      else {
        return (null);
      }
    }
  }

  public static DateTimeLogicWrapper helpGetTimeDuration(Stella_Object item) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(item);

      if (Surrogate.subtypeOfStringP(testValue000)) {
        { StringWrapper item000 = ((StringWrapper)(item));

          { TimeDuration value = TimeDuration.stringToTimeDuration(item000.wrapperValue);

            if (value != null) {
              return (Timepoint.wrapDateTime(value));
            }
            else {
              return (null);
            }
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, edu.isi.powerloom.extensions.units.Units.SGT_LOGIC_PATTERN_VARIABLE)) {
        { PatternVariable item000 = ((PatternVariable)(item));

          { Stella_Object value = PatternVariable.safeBoundTo(item000);

            if (value != null) {
              return (Timepoint.helpGetTimeDuration(value));
            }
            else {
              return (null);
            }
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, edu.isi.powerloom.extensions.units.Units.SGT_TIMEPOINT_SUPPORT_DATE_TIME_LOGIC_WRAPPER)) {
        { DateTimeLogicWrapper item000 = ((DateTimeLogicWrapper)(item));

          return (item000);
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, edu.isi.powerloom.extensions.units.Units.SGT_UNIT_SUPPORT_DIM_NUMBER_LOGIC_WRAPPER)) {
        { edu.isi.powerloom.extensions.units.DimNumberLogicWrapper item000 = ((edu.isi.powerloom.extensions.units.DimNumberLogicWrapper)(item));

          try {
            return (Timepoint.wrapDateTime(DimNumber.dimToTimeDuration(((DimNumber)(item000.wrapperValue)))));
          } catch (IncompatibleUnitsException e000) {
            return (null);
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, edu.isi.powerloom.extensions.units.Units.SGT_LOGIC_SKOLEM)) {
        { Skolem item000 = ((Skolem)(item));

          { Stella_Object value = ((Stella_Object)(Stella_Object.accessInContext(item000.variableValue, item000.homeContext, false)));

            if (value == null) {
              return (null);
            }
            { Surrogate testValue001 = Stella_Object.safePrimaryType(value);

              if (Surrogate.subtypeOfP(testValue001, edu.isi.powerloom.extensions.units.Units.SGT_TIMEPOINT_SUPPORT_DATE_TIME_LOGIC_WRAPPER)) {
                { DateTimeLogicWrapper value000 = ((DateTimeLogicWrapper)(value));

                  return (value000);
                }
              }
              else if (Surrogate.subtypeOfP(testValue001, edu.isi.powerloom.extensions.units.Units.SGT_LOGIC_SKOLEM)) {
                { Skolem value000 = ((Skolem)(value));

                  if (Stella_Object.isaP(((Stella_Object)(Stella_Object.accessInContext(value000.variableValue, value000.homeContext, false))), edu.isi.powerloom.extensions.units.Units.SGT_LOGIC_SKOLEM)) {
                    return (null);
                  }
                  else {
                    return (Timepoint.helpGetTimeDuration(((Stella_Object)(Stella_Object.accessInContext(value000.variableValue, value000.homeContext, false)))));
                  }
                }
              }
              else {
                if (Stella_Object.isaP(((Stella_Object)(Stella_Object.accessInContext(item000.variableValue, item000.homeContext, false))), edu.isi.powerloom.extensions.units.Units.SGT_LOGIC_SKOLEM)) {
                  return (null);
                }
                else {
                  return (Timepoint.helpGetTimeDuration(((Stella_Object)(Stella_Object.accessInContext(item000.variableValue, item000.homeContext, false)))));
                }
              }
            }
          }
        }
      }
      else {
        return (null);
      }
    }
  }

  public static DateTimeLogicWrapper helpGetTimeObject(Stella_Object item) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(item);

      if (Surrogate.subtypeOfStringP(testValue000)) {
        { StringWrapper item000 = ((StringWrapper)(item));

          { DateTimeObject value = CalendarDate.stringToCalendarDate(item000.wrapperValue);

            if (value == null) {
              value = TimeDuration.stringToTimeDuration(item000.wrapperValue);
            }
            if (value != null) {
              return (Timepoint.wrapDateTime(value));
            }
            else {
              return (null);
            }
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, edu.isi.powerloom.extensions.units.Units.SGT_LOGIC_PATTERN_VARIABLE)) {
        { PatternVariable item000 = ((PatternVariable)(item));

          { Stella_Object value = PatternVariable.safeBoundTo(item000);

            if (value != null) {
              return (Timepoint.helpGetTimeObject(value));
            }
            else {
              return (null);
            }
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, edu.isi.powerloom.extensions.units.Units.SGT_TIMEPOINT_SUPPORT_DATE_TIME_LOGIC_WRAPPER)) {
        { DateTimeLogicWrapper item000 = ((DateTimeLogicWrapper)(item));

          return (item000);
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, edu.isi.powerloom.extensions.units.Units.SGT_UNIT_SUPPORT_DIM_NUMBER_LOGIC_WRAPPER)) {
        { edu.isi.powerloom.extensions.units.DimNumberLogicWrapper item000 = ((edu.isi.powerloom.extensions.units.DimNumberLogicWrapper)(item));

          try {
            return (Timepoint.wrapDateTime(DimNumber.dimToTimeDuration(((DimNumber)(item000.wrapperValue)))));
          } catch (IncompatibleUnitsException e000) {
            return (null);
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, edu.isi.powerloom.extensions.units.Units.SGT_LOGIC_SKOLEM)) {
        { Skolem item000 = ((Skolem)(item));

          { Stella_Object value = ((Stella_Object)(Stella_Object.accessInContext(item000.variableValue, item000.homeContext, false)));

            { Surrogate testValue001 = Stella_Object.safePrimaryType(value);

              if (Surrogate.subtypeOfP(testValue001, edu.isi.powerloom.extensions.units.Units.SGT_TIMEPOINT_SUPPORT_DATE_TIME_LOGIC_WRAPPER)) {
                { DateTimeLogicWrapper value000 = ((DateTimeLogicWrapper)(value));

                  return (value000);
                }
              }
              else if (Surrogate.subtypeOfP(testValue001, edu.isi.powerloom.extensions.units.Units.SGT_LOGIC_SKOLEM)) {
                { Skolem value000 = ((Skolem)(value));

                  if (Stella_Object.isaP(((Stella_Object)(Stella_Object.accessInContext(value000.variableValue, value000.homeContext, false))), edu.isi.powerloom.extensions.units.Units.SGT_LOGIC_SKOLEM)) {
                    return (null);
                  }
                  else {
                    return (Timepoint.helpGetTimeObject(((Stella_Object)(Stella_Object.accessInContext(value000.variableValue, value000.homeContext, false)))));
                  }
                }
              }
              else {
                if (Stella_Object.isaP(((Stella_Object)(Stella_Object.accessInContext(item000.variableValue, item000.homeContext, false))), edu.isi.powerloom.extensions.units.Units.SGT_LOGIC_SKOLEM)) {
                  return (null);
                }
                else {
                  return (Timepoint.helpGetTimeObject(((Stella_Object)(Stella_Object.accessInContext(item000.variableValue, item000.homeContext, false)))));
                }
              }
            }
          }
        }
      }
      else {
        return (null);
      }
    }
  }

  public static int helpGetInteger(Stella_Object obj) {
    if (obj == null) {
      return (Stella.NULL_INTEGER);
    }
    else {
      { Surrogate testValue000 = Stella_Object.safePrimaryType(obj);

        if (Surrogate.subtypeOfFloatP(testValue000)) {
          { FloatWrapper obj000 = ((FloatWrapper)(obj));

            if (Stella.integerValuedP(obj000.wrapperValue)) {
              return (Native.floor(obj000.wrapperValue));
            }
            else {
              return (Stella.NULL_INTEGER);
            }
          }
        }
        else if (Surrogate.subtypeOfIntegerP(testValue000)) {
          { IntegerWrapper obj000 = ((IntegerWrapper)(obj));

            return (obj000.wrapperValue);
          }
        }
        else {
          return (Stella.NULL_INTEGER);
        }
      }
    }
  }

  public static double helpGetFloat(Stella_Object obj) {
    if (obj == null) {
      return (Stella.NULL_FLOAT);
    }
    else {
      { Surrogate testValue000 = Stella_Object.safePrimaryType(obj);

        if (Surrogate.subtypeOfFloatP(testValue000)) {
          { FloatWrapper obj000 = ((FloatWrapper)(obj));

            return (obj000.wrapperValue);
          }
        }
        else if (Surrogate.subtypeOfIntegerP(testValue000)) {
          { IntegerWrapper obj000 = ((IntegerWrapper)(obj));

            return (((double)(obj000.wrapperValue)));
          }
        }
        else {
          return (Stella.NULL_FLOAT);
        }
      }
    }
  }

  public static double helpGetTimezone(Stella_Object obj) {
    if (obj == null) {
      return (Stella.NULL_FLOAT);
    }
    else {
      { Surrogate testValue000 = Stella_Object.safePrimaryType(obj);

        if (Surrogate.subtypeOfFloatP(testValue000)) {
          { FloatWrapper obj000 = ((FloatWrapper)(obj));

            return (obj000.wrapperValue);
          }
        }
        else if (Surrogate.subtypeOfIntegerP(testValue000)) {
          { IntegerWrapper obj000 = ((IntegerWrapper)(obj));

            return (((double)(obj000.wrapperValue)));
          }
        }
        else if (Surrogate.subtypeOfStringP(testValue000)) {
          { StringWrapper obj000 = ((StringWrapper)(obj));

            { FloatWrapper decodedZone = Stella_Object.zone(StringWrapper.wrapString(Native.stringDowncase(obj000.wrapperValue)));

              if ((decodedZone != null) &&
                  (!Logic.nullWrapperP(decodedZone))) {
                return (decodedZone.wrapperValue);
              }
              else if (decodedZone != null) {
                return (Stella.getLocalTimeZone());
              }
              else {
                return (Stella.NULL_FLOAT);
              }
            }
          }
        }
        else {
          return (Stella.NULL_FLOAT);
        }
      }
    }
  }

  public static boolean isCurrentTimeSpecP(Stella_Object spec) {
    if (Surrogate.subtypeOfStringP(Stella_Object.safePrimaryType(spec))) {
      { StringWrapper spec000 = ((StringWrapper)(spec));

        return (Stella.stringEqualP(spec000.wrapperValue, "now"));
      }
    }
    else {
      return (false);
    }
  }

  public static boolean canBindAllP(Cons plObjects, Cons values) {
    { Stella_Object obj = null;
      Cons iter000 = plObjects;
      Stella_Object value = null;
      Cons iter001 = values;

      for (;(!(iter000 == Stella.NIL)) &&
                (!(iter001 == Stella.NIL)); iter000 = iter000.rest, iter001 = iter001.rest) {
        obj = iter000.value;
        value = iter001.value;
        { Surrogate testValue000 = Stella_Object.safePrimaryType(obj);

          if (Surrogate.subtypeOfP(testValue000, edu.isi.powerloom.extensions.units.Units.SGT_LOGIC_PATTERN_VARIABLE)) {
            { PatternVariable obj000 = ((PatternVariable)(obj));

              if (!(PatternVariable.bindVariableToValueP(obj000, value, true))) {
                return (false);
              }
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, edu.isi.powerloom.extensions.units.Units.SGT_LOGIC_SKOLEM)) {
            { Skolem obj000 = ((Skolem)(obj));

              { Skolem object000 = obj000;
                Stella_Object value000 = value;
                Stella_Object oldValue000 = object000.variableValue;
                Stella_Object newValue000 = Stella_Object.updateInContext(oldValue000, value000, object000.homeContext, false);

                if (!((oldValue000 != null) &&
                    (oldValue000.primaryType() == edu.isi.powerloom.extensions.units.Units.SGT_STELLA_CS_VALUE))) {
                  object000.variableValue = newValue000;
                }
              }
            }
          }
          else {
            if (!(obj.objectEqlP(value))) {
              return (false);
            }
          }
        }
      }
    }
    return (true);
  }

  public static Stella_Object timepointOfConstraint(IntegerWrapper missingArgument, StringWrapper x1, DateTimeLogicWrapper x2) {
    { Stella_Object value = null;

      switch (missingArgument.wrapperValue) {
        case -1: 
          value = ((((DateTimeObject)(Timepoint.helpGetCalendarTime(x1).wrapperValue)).objectEqlP(((DateTimeObject)(x2.wrapperValue))) ||
              Timepoint.isCurrentTimeSpecP(x1)) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
        break;
        case 0: 
          { DateTimeLogicWrapper timepointwrapper = Timepoint.helpGetCalendarTime(x2);

            value = StringWrapper.wrapString(((CalendarDate)(((DateTimeObject)(timepointwrapper.wrapperValue)))).calendarDateToString(0.0, false, true));
          }
        break;
        case 1: 
          { Stella_Object timepointspecvalue = Logic.valueOf(x1);

            if (timepointspecvalue == null) {
              value = null;
            }
            else {
              value = Timepoint.helpGetCalendarTime(timepointspecvalue);
            }
          }
        break;
        default:
        break;
      }
      return (value);
    }
  }

  public static DateTimeLogicWrapper timepointOf$Computation(IntegerWrapper yy, IntegerWrapper mm, IntegerWrapper dd, IntegerWrapper hr, IntegerWrapper min, NumberWrapper sec, Stella_Object tz) {
    { Stella_Object yyValue = Logic.valueOf(yy);
      Stella_Object mmValue = Logic.valueOf(mm);
      Stella_Object ddValue = Logic.valueOf(dd);
      Stella_Object hrValue = Logic.valueOf(hr);
      Stella_Object minValue = Logic.valueOf(min);
      Stella_Object secValue = Logic.valueOf(sec);
      Stella_Object tzValue = Logic.valueOf(tz);
      int year = Timepoint.helpGetInteger(yyValue);
      int month = Timepoint.helpGetInteger(mmValue);
      int day = Timepoint.helpGetInteger(ddValue);
      int hour = Timepoint.helpGetInteger(hrValue);
      int minute = Timepoint.helpGetInteger(minValue);
      double secondFloat = Timepoint.helpGetFloat(secValue);
      double zone = Timepoint.helpGetTimezone(tzValue);
      int second = 0;
      DateTimeLogicWrapper tp = null;

      if ((year != Stella.NULL_INTEGER) &&
          ((month != Stella.NULL_INTEGER) &&
           ((day != Stella.NULL_INTEGER) &&
            ((hour != Stella.NULL_INTEGER) &&
             ((minute != Stella.NULL_INTEGER) &&
              ((secondFloat != Stella.NULL_FLOAT) &&
               (zone != Stella.NULL_FLOAT))))))) {
        second = Native.floor(secondFloat);
        tp = Timepoint.wrapDateTime(CalendarDate.makeDateTime(year, month, day, hour, minute, second, Native.floor(1000 * (secondFloat - second)), zone));
      }
      return (tp);
    }
  }

  public static void timepointOf$Evaluator(Proposition self) {
    Proposition.equateEquivalentFunctionPropositions(self);
    { Stella_Object storedvalue = Logic.valueOf((self.arguments.theArray)[7]);
      MethodSlot computation = Symbol.lookupFunction(Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_OF$_COMPUTATION);
      Stella_Object computedvalue = Proposition.computeRelationValue(self, computation, false);

      if ((computedvalue != null) &&
          (!Stella_Object.eqlP(computedvalue, storedvalue))) {
        Proposition.equateValues(self, computedvalue, storedvalue);
      }
    }
  }

  public static Keyword timepointOf$Specialist(ControlFrame frame, Keyword lastmove) {
    { Proposition proposition = frame.proposition;
      Vector args = proposition.arguments;
      int year = Timepoint.helpGetInteger(Logic.argumentBoundTo((args.theArray)[0]));
      int month = Timepoint.helpGetInteger(Logic.argumentBoundTo((args.theArray)[1]));
      int day = Timepoint.helpGetInteger(Logic.argumentBoundTo((args.theArray)[2]));
      int hour = Timepoint.helpGetInteger(Logic.argumentBoundTo((args.theArray)[3]));
      int minute = Timepoint.helpGetInteger(Logic.argumentBoundTo((args.theArray)[4]));
      double secondFloat = Timepoint.helpGetFloat(Logic.argumentBoundTo((args.theArray)[5]));
      int second = 0;
      double zone = Timepoint.helpGetTimezone(Logic.argumentBoundTo((args.theArray)[6]));
      Stella_Object tp = Logic.argumentBoundTo((args.theArray)[7]);
      DateTimeLogicWrapper theTime = null;
      CalendarDate calendarDate = null;

      lastmove = lastmove;
      if ((year != Stella.NULL_INTEGER) &&
          ((month != Stella.NULL_INTEGER) &&
           ((day != Stella.NULL_INTEGER) &&
            ((hour != Stella.NULL_INTEGER) &&
             ((minute != Stella.NULL_INTEGER) &&
              ((secondFloat != Stella.NULL_FLOAT) &&
               (zone != Stella.NULL_FLOAT))))))) {
        second = Native.floor(secondFloat);
        theTime = Timepoint.wrapDateTime(CalendarDate.makeDateTime(year, month, day, hour, minute, second, Native.floor(1000 * (secondFloat - second)), zone));
        return (Logic.selectProofResult(Logic.bindArgumentToValueP((args.theArray)[7], theTime, true), false, true));
      }
      else if (tp != null) {
        theTime = Timepoint.helpGetCalendarTime(tp);
        calendarDate = ((CalendarDate)(((DateTimeObject)(theTime.wrapperValue))));
        if (zone == Stella.NULL_FLOAT) {
          zone = 0.0;
          if (!(Logic.bindArgumentToValueP((args.theArray)[6], FloatWrapper.wrapFloat(zone), true))) {
            return (edu.isi.powerloom.extensions.units.Units.KWD_FAILURE);
          }
        }
        if (theTime != null) {
          { int yy = Stella.NULL_INTEGER;
            int mm = Stella.NULL_INTEGER;
            int dd = Stella.NULL_INTEGER;
            Keyword dow = null;

            { Object [] caller_MV_returnarray = new Object[3];

              yy = calendarDate.getCalendarDate(zone, caller_MV_returnarray);
              mm = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
              dd = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
              dow = ((Keyword)(caller_MV_returnarray[2]));
            }
            dow = dow;
            { int h = Stella.NULL_INTEGER;
              int m = Stella.NULL_INTEGER;
              int s = Stella.NULL_INTEGER;
              int milli = Stella.NULL_INTEGER;

              { Object [] caller_MV_returnarray = new Object[3];

                h = calendarDate.getTime(zone, caller_MV_returnarray);
                m = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
                s = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
                milli = ((int)(((IntegerWrapper)(caller_MV_returnarray[2])).wrapperValue));
              }
              return (Logic.selectProofResult(Timepoint.canBindAllP(Cons.consList(Cons.cons((args.theArray)[0], Cons.cons((args.theArray)[1], Cons.cons((args.theArray)[2], Cons.cons((args.theArray)[3], Cons.cons((args.theArray)[4], Cons.cons((args.theArray)[5], Stella.NIL))))))), Cons.consList(Cons.cons(IntegerWrapper.wrapInteger(yy), Cons.cons(IntegerWrapper.wrapInteger(mm), Cons.cons(IntegerWrapper.wrapInteger(dd), Cons.cons(IntegerWrapper.wrapInteger(h), Cons.cons(IntegerWrapper.wrapInteger(m), Cons.cons(FloatWrapper.wrapFloat(((double)(s + (milli * 0.001)))), Stella.NIL)))))))), false, true));
            }
          }
        }
        else {
          return (edu.isi.powerloom.extensions.units.Units.KWD_TERMINAL_FAILURE);
        }
      }
      else {
        return (edu.isi.powerloom.extensions.units.Units.KWD_FAILURE);
      }
    }
  }

  public static Stella_Object durationOfConstraint(IntegerWrapper missingArgument, StringWrapper x1, DateTimeLogicWrapper x2) {
    { Stella_Object value = null;

      switch (missingArgument.wrapperValue) {
        case -1: 
          value = (((DateTimeObject)(Timepoint.helpGetTimeDuration(x1).wrapperValue)).objectEqlP(((DateTimeObject)(x2.wrapperValue))) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
        break;
        case 0: 
          { DateTimeLogicWrapper durationwrapper = Timepoint.helpGetTimeDuration(x2);

            value = StringWrapper.wrapString(((TimeDuration)(((DateTimeObject)(durationwrapper.wrapperValue)))).timeDurationToString());
          }
        break;
        case 1: 
          { Stella_Object durationspecvalue = Logic.valueOf(x1);

            if (durationspecvalue == null) {
              value = null;
            }
            else {
              value = Timepoint.helpGetTimeDuration(durationspecvalue);
            }
          }
        break;
        default:
        break;
      }
      return (value);
    }
  }

  public static Stella_Object timeMinusConstraint(IntegerWrapper missingArgument, DateTimeLogicWrapper x1, DateTimeLogicWrapper x2, DateTimeLogicWrapper x3) {
    { Stella_Object value = null;

      switch (missingArgument.wrapperValue) {
        case -1: 
          value = (DateTimeObject.timeSubtract(((DateTimeObject)(x1.wrapperValue)), ((DateTimeObject)(x2.wrapperValue))).objectEqlP(((DateTimeObject)(x3.wrapperValue))) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
        break;
        case 0: 
          value = Timepoint.wrapDateTime(DateTimeObject.timeAdd(((DateTimeObject)(x2.wrapperValue)), ((DateTimeObject)(x3.wrapperValue))));
        break;
        case 1: 
          value = Timepoint.wrapDateTime(DateTimeObject.timeSubtract(((DateTimeObject)(x1.wrapperValue)), ((DateTimeObject)(x3.wrapperValue))));
        break;
        case 2: 
          value = Timepoint.wrapDateTime(DateTimeObject.timeSubtract(((DateTimeObject)(x1.wrapperValue)), ((DateTimeObject)(x2.wrapperValue))));
        break;
        default:
        break;
      }
      return (value);
    }
  }

  public static Stella_Object timePlusConstraint(IntegerWrapper missingArgument, DateTimeLogicWrapper x1, DateTimeLogicWrapper x2, DateTimeLogicWrapper x3) {
    { Stella_Object value = null;

      switch (missingArgument.wrapperValue) {
        case -1: 
          value = (DateTimeObject.timeAdd(((DateTimeObject)(x1.wrapperValue)), ((DateTimeObject)(x2.wrapperValue))).objectEqlP(((DateTimeObject)(x3.wrapperValue))) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
        break;
        case 0: 
          value = Timepoint.wrapDateTime(DateTimeObject.timeSubtract(((DateTimeObject)(x3.wrapperValue)), ((DateTimeObject)(x2.wrapperValue))));
        break;
        case 1: 
          value = Timepoint.wrapDateTime(DateTimeObject.timeSubtract(((DateTimeObject)(x3.wrapperValue)), ((DateTimeObject)(x1.wrapperValue))));
        break;
        case 2: 
          value = Timepoint.wrapDateTime(DateTimeObject.timeAdd(((DateTimeObject)(x1.wrapperValue)), ((DateTimeObject)(x2.wrapperValue))));
        break;
        default:
        break;
      }
      return (value);
    }
  }

  public static LogicObject dowKeywordToInstance(Keyword dow) {
    if (dow == Timepoint.KWD_MONDAY) {
      return (((LogicObject)(Timepoint.SGT_TIMEPOINT_KB_MONDAY.surrogateValue)));
    }
    else if (dow == Timepoint.KWD_TUESDAY) {
      return (((LogicObject)(Timepoint.SGT_TIMEPOINT_KB_TUESDAY.surrogateValue)));
    }
    else if (dow == Timepoint.KWD_WEDNESDAY) {
      return (((LogicObject)(Timepoint.SGT_TIMEPOINT_KB_WEDNESDAY.surrogateValue)));
    }
    else if (dow == Timepoint.KWD_THURSDAY) {
      return (((LogicObject)(Timepoint.SGT_TIMEPOINT_KB_THURSDAY.surrogateValue)));
    }
    else if (dow == Timepoint.KWD_FRIDAY) {
      return (((LogicObject)(Timepoint.SGT_TIMEPOINT_KB_FRIDAY.surrogateValue)));
    }
    else if (dow == Timepoint.KWD_SATURDAY) {
      return (((LogicObject)(Timepoint.SGT_TIMEPOINT_KB_SATURDAY.surrogateValue)));
    }
    else if (dow == Timepoint.KWD_SUNDAY) {
      return (((LogicObject)(Timepoint.SGT_TIMEPOINT_KB_SUNDAY.surrogateValue)));
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + dow + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

}
