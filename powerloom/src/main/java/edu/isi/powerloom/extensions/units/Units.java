//  -*- Mode: Java -*-
//
// Units.java

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

package edu.isi.powerloom.extensions.units;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.powerloom.logic.*;
import edu.isi.stella.*;
import edu.isi.stella.utilities.*;

public class Units {
  /** Table for interning dim number logic wrappers
   */
  public static StellaHashTable $DIM_NUMBER_HASH_TABLE$ = null;

  public static Surrogate SGT_UNIT_SUPPORT_DIM_NUMBER_LOGIC_WRAPPER = null;

  public static Symbol SYM_STELLA_WRAPPER_VALUE = null;

  public static Surrogate SGT_UNIT_KB_UNITS = null;

  public static Surrogate SGT_TIMEPOINT_SUPPORT_DATE_TIME_LOGIC_WRAPPER = null;

  public static Surrogate SGT_STELLA_CALENDAR_DATE = null;

  public static Surrogate SGT_STELLA_TIME_DURATION = null;

  public static Surrogate SGT_LOGIC_PATTERN_VARIABLE = null;

  public static Surrogate SGT_LOGIC_SKOLEM = null;

  public static Surrogate SGT_STELLA_CS_VALUE = null;

  public static Keyword KWD_FINAL_SUCCESS = null;

  public static Keyword KWD_TERMINAL_FAILURE = null;

  public static Keyword KWD_FAILURE = null;

  public static Symbol SYM_STELLA_ITERATOR = null;

  public static Keyword KWD_CONTINUING_SUCCESS = null;

  public static Surrogate SGT_STELLA_INTEGER_WRAPPER = null;

  public static Surrogate SGT_UNIT_KB_NUMERATOR_MEASURES = null;

  public static Surrogate SGT_UNIT_KB_DENOMINATOR_MEASURES = null;

  public static Surrogate SGT_LOGIC_LOGIC_OBJECT = null;

  public static Surrogate SGT_STELLA_NUMBER_WRAPPER = null;

  /** Mapping table from measure objects to their PowerLoom representation.
   */
  public static HashTable $MEASURE_INSTANCE_TABLE$ = null;

  /** Mapping table from PowerLoom representations of measures to measure objects
   */
  public static HashTable $INSTANCE_MEASURE_TABLE$ = null;

  public static Symbol SYM_UNIT_SUPPORT_STARTUP_UNIT_SUPPORT = null;

  public static Symbol SYM_UNIT_KB_MEASURE = null;

  public static Symbol SYM_UNIT_KB_BASE_MEASURE = null;

  public static Keyword KWD_AXIOMS = null;

  public static Symbol SYM_UNIT_KB_MEASURE_UNIT = null;

  public static Symbol SYM_UNIT_KB_VALUE_MEASURE = null;

  public static Symbol SYM_UNIT_KB_NUMERATOR_MEASURES = null;

  public static Symbol SYM_UNIT_KB_DENOMINATOR_MEASURES = null;

  public static Symbol SYM_UNIT_KB_COMENSURATE_UNITS = null;

  public static Symbol SYM_UNIT_KB_UNITS = null;

  public static Keyword KWD__g = null;

  public static Symbol SYM_UNIT_SUPPORT_pDIM = null;

  public static Symbol SYM_UNIT_KB_Ui = null;

  public static Symbol SYM_LOGIC_pZ = null;

  public static Symbol SYM_UNIT_KB_U_ = null;

  public static Symbol SYM_UNIT_KB_U$ = null;

  public static Symbol SYM_UNIT_KB_U_DIV = null;

  public static Symbol SYM_UNIT_KB_U_ABS = null;

  public static Symbol SYM_UNIT_KB_U_SIGNUM = null;

  public static Symbol SYM_UNIT_KB_U_WITHIN_DELTA = null;

  public static Keyword KWD_eg = null;

  public static Keyword KWD_le = null;

  public static Symbol SYM_UNIT_KB_U_WITHIN_FACTOR = null;

  public static Symbol SYM_UNIT_KB_U_MINIMUM_VALUE = null;

  public static Symbol SYM_UNIT_KB_U_MAXIMUM_VALUE = null;

  public static Symbol SYM_UNIT_KB_U_SUM = null;

  public static Symbol SYM_UNIT_SUPPORT_STARTUP_UNIT_KB = null;

  /** Return an interned LOGIC-WRAPPER for <code>value</code>.  This assures us
   * that all logic-wrapped DIM-NUMBERs are the same object.
   * @param value
   * @return DimNumberLogicWrapper
   */
  public static DimNumberLogicWrapper wrapDimNumber(DimNumber value) {
    { DimNumberLogicWrapper wrapper = ((DimNumberLogicWrapper)(Units.$DIM_NUMBER_HASH_TABLE$.lookup(value)));

      if (wrapper == null) {
        value.preferredUnits = null;
        wrapper = DimNumberLogicWrapper.newDimNumberLogicWrapper(value);
        Units.$DIM_NUMBER_HASH_TABLE$.insertAt(value, wrapper);
      }
      return (wrapper);
    }
  }

  public static DimNumberLogicWrapper helpGetDimNumber(Stella_Object item) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(item);

      if (Surrogate.subtypeOfP(testValue000, Units.SGT_UNIT_SUPPORT_DIM_NUMBER_LOGIC_WRAPPER)) {
        { DimNumberLogicWrapper item000 = ((DimNumberLogicWrapper)(item));

          return (item000);
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Units.SGT_TIMEPOINT_SUPPORT_DATE_TIME_LOGIC_WRAPPER)) {
        { edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper item000 = ((edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper)(item));

          { DateTimeObject value = ((DateTimeObject)(item000.wrapperValue));

            { Surrogate testValue001 = Stella_Object.safePrimaryType(value);

              if (Surrogate.subtypeOfP(testValue001, Units.SGT_STELLA_CALENDAR_DATE)) {
                { CalendarDate value000 = ((CalendarDate)(value));

                  return (null);
                }
              }
              else if (Surrogate.subtypeOfP(testValue001, Units.SGT_STELLA_TIME_DURATION)) {
                { TimeDuration value000 = ((TimeDuration)(value));

                  return (DimNumberLogicWrapper.newDimNumberLogicWrapper(Utilities.timeDurationToDim(value000)));
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
      }
      else if (Surrogate.subtypeOfP(testValue000, Units.SGT_LOGIC_PATTERN_VARIABLE)) {
        { PatternVariable item000 = ((PatternVariable)(item));

          { Stella_Object value = PatternVariable.safeBoundTo(item000);

            if (value != null) {
              return (Units.helpGetDimNumber(value));
            }
            else {
              return (null);
            }
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Units.SGT_LOGIC_SKOLEM)) {
        { Skolem item000 = ((Skolem)(item));

          { Stella_Object value = ((Stella_Object)(Stella_Object.accessInContext(item000.variableValue, item000.homeContext, false)));

            if (value == null) {
              return (null);
            }
            { Surrogate testValue002 = Stella_Object.safePrimaryType(value);

              if (Surrogate.subtypeOfP(testValue002, Units.SGT_UNIT_SUPPORT_DIM_NUMBER_LOGIC_WRAPPER)) {
                { DimNumberLogicWrapper value000 = ((DimNumberLogicWrapper)(value));

                  return (value000);
                }
              }
              else if (Surrogate.subtypeOfP(testValue002, Units.SGT_LOGIC_SKOLEM)) {
                { Skolem value000 = ((Skolem)(value));

                  if (((Stella_Object)(Stella_Object.accessInContext(value000.variableValue, value000.homeContext, false))) == null) {
                    return (null);
                  }
                  if (Stella_Object.isaP(((Stella_Object)(Stella_Object.accessInContext(value000.variableValue, value000.homeContext, false))), Units.SGT_LOGIC_SKOLEM)) {
                    return (null);
                  }
                  else {
                    return (Units.helpGetDimNumber(((Stella_Object)(Stella_Object.accessInContext(value000.variableValue, value000.homeContext, false)))));
                  }
                }
              }
              else {
                if (Stella_Object.isaP(((Stella_Object)(Stella_Object.accessInContext(item000.variableValue, item000.homeContext, false))), Units.SGT_LOGIC_SKOLEM)) {
                  return (null);
                }
                else {
                  return (Units.helpGetDimNumber(((Stella_Object)(Stella_Object.accessInContext(item000.variableValue, item000.homeContext, false)))));
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

  public static DimNumberLogicWrapper helpGetUnitValue(Stella_Object magnitude, Stella_Object units) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(magnitude);

      if (Surrogate.subtypeOfFloatP(testValue000)) {
        { FloatWrapper magnitude000 = ((FloatWrapper)(magnitude));

          { Surrogate testValue001 = Stella_Object.safePrimaryType(units);

            if (Surrogate.subtypeOfStringP(testValue001)) {
              { StringWrapper units000 = ((StringWrapper)(units));

                { double value = magnitude000.wrapperValue;
                  DimNumberLogicWrapper returnValue = null;

                  try {
                    if (value != Stella.NULL_FLOAT) {
                      returnValue = Units.wrapDimNumber(DimNumber.makeDimNumber(value, units000.wrapperValue));
                    }
                  } catch (StellaException e000) {
                  }
                  return (returnValue);
                }
              }
            }
            else if (Surrogate.subtypeOfP(testValue001, Units.SGT_LOGIC_PATTERN_VARIABLE)) {
              { PatternVariable units000 = ((PatternVariable)(units));

                { Stella_Object unitValue = PatternVariable.safeBoundTo(units000);

                  if (unitValue != null) {
                    return (Units.helpGetUnitValue(magnitude000, unitValue));
                  }
                  else {
                    return (null);
                  }
                }
              }
            }
            else if (Surrogate.subtypeOfP(testValue001, Units.SGT_LOGIC_SKOLEM)) {
              { Skolem units000 = ((Skolem)(units));

                { Stella_Object unitValue = ((Stella_Object)(Stella_Object.accessInContext(units000.variableValue, units000.homeContext, false)));

                  { Surrogate testValue002 = Stella_Object.safePrimaryType(unitValue);

                    if (Surrogate.subtypeOfStringP(testValue002)) {
                      { StringWrapper unitValue000 = ((StringWrapper)(unitValue));

                        return (Units.helpGetUnitValue(magnitude000, unitValue000));
                      }
                    }
                    else if (Surrogate.subtypeOfP(testValue002, Units.SGT_LOGIC_SKOLEM)) {
                      { Skolem unitValue000 = ((Skolem)(unitValue));

                        if (Stella_Object.isaP(((Stella_Object)(Stella_Object.accessInContext(unitValue000.variableValue, unitValue000.homeContext, false))), Units.SGT_LOGIC_SKOLEM)) {
                          return (null);
                        }
                        else {
                          return (Units.helpGetUnitValue(magnitude000, ((Stella_Object)(Stella_Object.accessInContext(unitValue000.variableValue, unitValue000.homeContext, false)))));
                        }
                      }
                    }
                    else {
                      if (Stella_Object.isaP(((Stella_Object)(Stella_Object.accessInContext(units000.variableValue, units000.homeContext, false))), Units.SGT_LOGIC_SKOLEM)) {
                        return (null);
                      }
                      else {
                        return (Units.helpGetUnitValue(magnitude000, ((Stella_Object)(Stella_Object.accessInContext(units000.variableValue, units000.homeContext, false)))));
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
      }
      else if (Surrogate.subtypeOfIntegerP(testValue000)) {
        { IntegerWrapper magnitude000 = ((IntegerWrapper)(magnitude));

          { Surrogate testValue003 = Stella_Object.safePrimaryType(units);

            if (Surrogate.subtypeOfStringP(testValue003)) {
              { StringWrapper units000 = ((StringWrapper)(units));

                { int value = magnitude000.wrapperValue;
                  DimNumberLogicWrapper returnValue = null;

                  try {
                    if (value != Stella.NULL_INTEGER) {
                      returnValue = Units.wrapDimNumber(DimNumber.makeDimNumber(((double)(value)), units000.wrapperValue));
                    }
                  } catch (StellaException e001) {
                  }
                  return (returnValue);
                }
              }
            }
            else if (Surrogate.subtypeOfP(testValue003, Units.SGT_LOGIC_PATTERN_VARIABLE)) {
              { PatternVariable units000 = ((PatternVariable)(units));

                { Stella_Object unitValue = PatternVariable.safeBoundTo(units000);

                  if (unitValue != null) {
                    return (Units.helpGetUnitValue(magnitude000, unitValue));
                  }
                  else {
                    return (null);
                  }
                }
              }
            }
            else if (Surrogate.subtypeOfP(testValue003, Units.SGT_LOGIC_SKOLEM)) {
              { Skolem units000 = ((Skolem)(units));

                { Stella_Object unitValue = ((Stella_Object)(Stella_Object.accessInContext(units000.variableValue, units000.homeContext, false)));

                  { Surrogate testValue004 = Stella_Object.safePrimaryType(unitValue);

                    if (Surrogate.subtypeOfStringP(testValue004)) {
                      { StringWrapper unitValue000 = ((StringWrapper)(unitValue));

                        return (Units.helpGetUnitValue(magnitude000, unitValue000));
                      }
                    }
                    else if (Surrogate.subtypeOfP(testValue004, Units.SGT_LOGIC_SKOLEM)) {
                      { Skolem unitValue000 = ((Skolem)(unitValue));

                        if (Stella_Object.isaP(((Stella_Object)(Stella_Object.accessInContext(unitValue000.variableValue, unitValue000.homeContext, false))), Units.SGT_LOGIC_SKOLEM)) {
                          return (null);
                        }
                        else {
                          return (Units.helpGetUnitValue(magnitude000, ((Stella_Object)(Stella_Object.accessInContext(unitValue000.variableValue, unitValue000.homeContext, false)))));
                        }
                      }
                    }
                    else {
                      if (Stella_Object.isaP(((Stella_Object)(Stella_Object.accessInContext(units000.variableValue, units000.homeContext, false))), Units.SGT_LOGIC_SKOLEM)) {
                        return (null);
                      }
                      else {
                        return (Units.helpGetUnitValue(magnitude000, ((Stella_Object)(Stella_Object.accessInContext(units000.variableValue, units000.homeContext, false)))));
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
      }
      else if (Surrogate.subtypeOfP(testValue000, Units.SGT_LOGIC_PATTERN_VARIABLE)) {
        { PatternVariable magnitude000 = ((PatternVariable)(magnitude));

          { Stella_Object value = PatternVariable.safeBoundTo(magnitude000);

            if (value != null) {
              return (Units.helpGetUnitValue(value, units));
            }
            else {
              return (null);
            }
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Units.SGT_LOGIC_SKOLEM)) {
        { Skolem magnitude000 = ((Skolem)(magnitude));

          { Stella_Object value = ((Stella_Object)(Stella_Object.accessInContext(magnitude000.variableValue, magnitude000.homeContext, false)));

            if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(value), Units.SGT_LOGIC_SKOLEM)) {
              { Skolem value000 = ((Skolem)(value));

                if (Stella_Object.isaP(((Stella_Object)(Stella_Object.accessInContext(value000.variableValue, value000.homeContext, false))), Units.SGT_LOGIC_SKOLEM)) {
                  return (null);
                }
                else {
                  return (Units.helpGetUnitValue(((Stella_Object)(Stella_Object.accessInContext(value000.variableValue, value000.homeContext, false))), units));
                }
              }
            }
            else {
              if (Stella_Object.isaP(((Stella_Object)(Stella_Object.accessInContext(magnitude000.variableValue, magnitude000.homeContext, false))), Units.SGT_LOGIC_SKOLEM)) {
                return (null);
              }
              else {
                return (Units.helpGetUnitValue(((Stella_Object)(Stella_Object.accessInContext(magnitude000.variableValue, magnitude000.homeContext, false))), units));
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

  public static void unitsEvaluator(Proposition self) {
    { Stella_Object magnitude = Logic.valueOf((self.arguments.theArray)[0]);
      Stella_Object units = Logic.valueOf((self.arguments.theArray)[1]);
      Stella_Object dimNumber = Logic.valueOf((self.arguments.theArray)[2]);
      DimNumberLogicWrapper value1 = Units.helpGetUnitValue(magnitude, units);

      if (value1 != null) {
        { Surrogate testValue000 = Stella_Object.safePrimaryType(dimNumber);

          if (Surrogate.subtypeOfP(testValue000, Units.SGT_LOGIC_SKOLEM)) {
            { Skolem dimNumber000 = ((Skolem)(dimNumber));

              Skolem.bindSkolemToValue(dimNumber000, value1, false);
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Units.SGT_UNIT_SUPPORT_DIM_NUMBER_LOGIC_WRAPPER)) {
            { DimNumberLogicWrapper dimNumber000 = ((DimNumberLogicWrapper)(dimNumber));

              if (!(Stella_Object.eqlP(((DimNumber)(value1.wrapperValue)), ((DimNumber)(dimNumber000.wrapperValue))))) {
                Proposition.signalUnificationClash(self, value1, dimNumber000);
              }
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Units.SGT_TIMEPOINT_SUPPORT_DATE_TIME_LOGIC_WRAPPER)) {
            { edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper dimNumber000 = ((edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper)(dimNumber));

              { DimNumberLogicWrapper theDim = Units.helpGetDimNumber(dimNumber000);

                if (!((theDim != null) &&
                    Stella_Object.eqlP(((DimNumber)(value1.wrapperValue)), ((DimNumber)(theDim.wrapperValue))))) {
                  Proposition.signalUnificationClash(self, value1, dimNumber000);
                }
              }
            }
          }
          else {
            Proposition.signalUnificationClash(self, value1, dimNumber);
          }
        }
      }
    }
  }

  public static Keyword unitsSpecialist(ControlFrame frame, Keyword lastmove) {
    { Proposition proposition = frame.proposition;
      Stella_Object magnitude = Logic.valueOf((proposition.arguments.theArray)[0]);
      Stella_Object units = Logic.valueOf((proposition.arguments.theArray)[1]);
      Stella_Object dim = Logic.valueOf((proposition.arguments.theArray)[2]);
      DimNumberLogicWrapper theValue = Units.helpGetUnitValue(magnitude, units);
      String unitString = null;

      lastmove = lastmove;
      if (theValue != null) {
        { Surrogate testValue000 = Stella_Object.safePrimaryType(dim);

          if (Surrogate.subtypeOfP(testValue000, Units.SGT_LOGIC_PATTERN_VARIABLE)) {
            { PatternVariable dim000 = ((PatternVariable)(dim));

              return (Logic.selectProofResult(PatternVariable.bindVariableToValueP(dim000, theValue, true), false, true));
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Units.SGT_LOGIC_SKOLEM)) {
            { Skolem dim000 = ((Skolem)(dim));

              { Skolem object000 = dim000;
                Stella_Object value000 = theValue;
                Stella_Object oldValue000 = object000.variableValue;
                Stella_Object newValue000 = Stella_Object.updateInContext(oldValue000, value000, object000.homeContext, false);

                if (!((oldValue000 != null) &&
                    (oldValue000.primaryType() == Units.SGT_STELLA_CS_VALUE))) {
                  object000.variableValue = newValue000;
                }
              }
              return (Units.KWD_FINAL_SUCCESS);
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Units.SGT_UNIT_SUPPORT_DIM_NUMBER_LOGIC_WRAPPER)) {
            { DimNumberLogicWrapper dim000 = ((DimNumberLogicWrapper)(dim));

              return (Logic.selectProofResult(((DimNumber)(theValue.wrapperValue)).objectEqlP(((DimNumber)(dim000.wrapperValue))), false, true));
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Units.SGT_TIMEPOINT_SUPPORT_DATE_TIME_LOGIC_WRAPPER)) {
            { edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper dim000 = ((edu.isi.powerloom.extensions.timepoint.DateTimeLogicWrapper)(dim));

              { DimNumberLogicWrapper theDim = Units.helpGetDimNumber(dim000);

                if (theDim == null) {
                  return (Units.KWD_TERMINAL_FAILURE);
                }
                else {
                  return (Logic.selectProofResult(((DimNumber)(theValue.wrapperValue)).objectEqlP(((DimNumber)(theDim.wrapperValue))), false, true));
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
      else if (dim != null) {
        theValue = Units.helpGetDimNumber(dim);
        if (!(theValue != null)) {
          return (Units.KWD_FAILURE);
        }
        unitString = ((DimNumber)(theValue.wrapperValue)).getUnit();
        { Surrogate testValue001 = Stella_Object.safePrimaryType(magnitude);

          if (Surrogate.subtypeOfP(testValue001, Units.SGT_LOGIC_PATTERN_VARIABLE)) {
            { PatternVariable magnitude000 = ((PatternVariable)(magnitude));

              { Surrogate testValue002 = Stella_Object.safePrimaryType(units);

                if (Surrogate.subtypeOfP(testValue002, Units.SGT_LOGIC_PATTERN_VARIABLE)) {
                  { PatternVariable units000 = ((PatternVariable)(units));

                    return (Logic.selectProofResult(PatternVariable.bindVariableToValueP(units000, StringWrapper.wrapString(unitString), true) &&
                        PatternVariable.bindVariableToValueP(magnitude000, FloatWrapper.wrapFloat(((DimNumber)(theValue.wrapperValue)).getMagnitude(unitString)), true), false, true));
                  }
                }
                else if (Surrogate.subtypeOfStringP(testValue002)) {
                  { StringWrapper units000 = ((StringWrapper)(units));

                    { Keyword returnValue = Units.KWD_FAILURE;

                      try {
                        returnValue = Logic.selectProofResult(PatternVariable.bindVariableToValueP(magnitude000, FloatWrapper.wrapFloat(((DimNumber)(theValue.wrapperValue)).getMagnitude(units000.wrapperValue)), true), false, true);
                      } catch (IncompatibleUnitsException e000) {
                        returnValue = Units.KWD_TERMINAL_FAILURE;
                      } catch (StellaException e001) {
                      }
                      return (returnValue);
                    }
                  }
                }
                else if (Surrogate.subtypeOfP(testValue002, Units.SGT_LOGIC_SKOLEM)) {
                  { Skolem units000 = ((Skolem)(units));

                    { Skolem object001 = units000;
                      Stella_Object value001 = StringWrapper.wrapString(unitString);
                      Stella_Object oldValue001 = object001.variableValue;
                      Stella_Object newValue001 = Stella_Object.updateInContext(oldValue001, value001, object001.homeContext, false);

                      if (!((oldValue001 != null) &&
                          (oldValue001.primaryType() == Units.SGT_STELLA_CS_VALUE))) {
                        object001.variableValue = newValue001;
                      }
                    }
                    return (Logic.selectProofResult(PatternVariable.bindVariableToValueP(magnitude000, FloatWrapper.wrapFloat(((DimNumber)(theValue.wrapperValue)).getMagnitude(unitString)), true), false, true));
                  }
                }
                else {
                  return (Units.KWD_FAILURE);
                }
              }
            }
          }
          else if (Surrogate.subtypeOfP(testValue001, Units.SGT_LOGIC_SKOLEM)) {
            { Skolem magnitude000 = ((Skolem)(magnitude));

              { Surrogate testValue003 = Stella_Object.safePrimaryType(units);

                if (Surrogate.subtypeOfP(testValue003, Units.SGT_LOGIC_PATTERN_VARIABLE)) {
                  { PatternVariable units000 = ((PatternVariable)(units));

                    { Skolem object002 = magnitude000;
                      Stella_Object value002 = FloatWrapper.wrapFloat(((DimNumber)(theValue.wrapperValue)).getMagnitude(unitString));
                      Stella_Object oldValue002 = object002.variableValue;
                      Stella_Object newValue002 = Stella_Object.updateInContext(oldValue002, value002, object002.homeContext, false);

                      if (!((oldValue002 != null) &&
                          (oldValue002.primaryType() == Units.SGT_STELLA_CS_VALUE))) {
                        object002.variableValue = newValue002;
                      }
                    }
                    return (Logic.selectProofResult(PatternVariable.bindVariableToValueP(units000, StringWrapper.wrapString(unitString), true), false, true));
                  }
                }
                else if (Surrogate.subtypeOfStringP(testValue003)) {
                  { StringWrapper units000 = ((StringWrapper)(units));

                    { Keyword returnValue = Units.KWD_FINAL_SUCCESS;

                      try {
                        { Skolem object003 = magnitude000;
                          Stella_Object value003 = FloatWrapper.wrapFloat(((DimNumber)(theValue.wrapperValue)).getMagnitude(units000.wrapperValue));
                          Stella_Object oldValue003 = object003.variableValue;
                          Stella_Object newValue003 = Stella_Object.updateInContext(oldValue003, value003, object003.homeContext, false);

                          if (!((oldValue003 != null) &&
                              (oldValue003.primaryType() == Units.SGT_STELLA_CS_VALUE))) {
                            object003.variableValue = newValue003;
                          }
                        }
                      } catch (IncompatibleUnitsException e002) {
                        returnValue = Units.KWD_TERMINAL_FAILURE;
                      } catch (StellaException e003) {
                        returnValue = Units.KWD_FAILURE;
                      }
                      return (returnValue);
                    }
                  }
                }
                else if (Surrogate.subtypeOfP(testValue003, Units.SGT_LOGIC_SKOLEM)) {
                  { Skolem units000 = ((Skolem)(units));

                    { Skolem object004 = units000;
                      Stella_Object value004 = StringWrapper.wrapString(unitString);
                      Stella_Object oldValue004 = object004.variableValue;
                      Stella_Object newValue004 = Stella_Object.updateInContext(oldValue004, value004, object004.homeContext, false);

                      if (!((oldValue004 != null) &&
                          (oldValue004.primaryType() == Units.SGT_STELLA_CS_VALUE))) {
                        object004.variableValue = newValue004;
                      }
                    }
                    { Skolem object005 = magnitude000;
                      Stella_Object value005 = FloatWrapper.wrapFloat(((DimNumber)(theValue.wrapperValue)).getMagnitude(unitString));
                      Stella_Object oldValue005 = object005.variableValue;
                      Stella_Object newValue005 = Stella_Object.updateInContext(oldValue005, value005, object005.homeContext, false);

                      if (!((oldValue005 != null) &&
                          (oldValue005.primaryType() == Units.SGT_STELLA_CS_VALUE))) {
                        object005.variableValue = newValue005;
                      }
                    }
                    return (Units.KWD_FINAL_SUCCESS);
                  }
                }
                else {
                  return (Units.KWD_FAILURE);
                }
              }
            }
          }
          else if (Surrogate.subtypeOfFloatP(testValue001)) {
            { FloatWrapper magnitude000 = ((FloatWrapper)(magnitude));

              if ((magnitude000.wrapperValue != Stella.NULL_FLOAT) &&
                  (magnitude000.wrapperValue == ((DimNumber)(theValue.wrapperValue)).getMagnitude(unitString))) {
                { Surrogate testValue004 = Stella_Object.safePrimaryType(units);

                  if (Surrogate.subtypeOfP(testValue004, Units.SGT_LOGIC_PATTERN_VARIABLE)) {
                    { PatternVariable units000 = ((PatternVariable)(units));

                      return (Logic.selectProofResult(PatternVariable.bindVariableToValueP(units000, StringWrapper.wrapString(unitString), true), false, true));
                    }
                  }
                  else if (Surrogate.subtypeOfP(testValue004, Units.SGT_LOGIC_SKOLEM)) {
                    { Skolem units000 = ((Skolem)(units));

                      { Skolem object006 = units000;
                        Stella_Object value006 = StringWrapper.wrapString(unitString);
                        Stella_Object oldValue006 = object006.variableValue;
                        Stella_Object newValue006 = Stella_Object.updateInContext(oldValue006, value006, object006.homeContext, false);

                        if (!((oldValue006 != null) &&
                            (oldValue006.primaryType() == Units.SGT_STELLA_CS_VALUE))) {
                          object006.variableValue = newValue006;
                        }
                      }
                      return (Units.KWD_FINAL_SUCCESS);
                    }
                  }
                  else {
                    return (Units.KWD_FAILURE);
                  }
                }
              }
              else {
                return (Units.KWD_FAILURE);
              }
            }
          }
          else if (Surrogate.subtypeOfIntegerP(testValue001)) {
            { IntegerWrapper magnitude000 = ((IntegerWrapper)(magnitude));

              if ((magnitude000.wrapperValue != Stella.NULL_INTEGER) &&
                  (((double)(magnitude000.wrapperValue)) == ((DimNumber)(theValue.wrapperValue)).getMagnitude(unitString))) {
                { Surrogate testValue005 = Stella_Object.safePrimaryType(units);

                  if (Surrogate.subtypeOfP(testValue005, Units.SGT_LOGIC_PATTERN_VARIABLE)) {
                    { PatternVariable units000 = ((PatternVariable)(units));

                      return (Logic.selectProofResult(PatternVariable.bindVariableToValueP(units000, StringWrapper.wrapString(unitString), true), false, true));
                    }
                  }
                  else if (Surrogate.subtypeOfP(testValue005, Units.SGT_LOGIC_SKOLEM)) {
                    { Skolem units000 = ((Skolem)(units));

                      { Skolem object007 = units000;
                        Stella_Object value007 = StringWrapper.wrapString(unitString);
                        Stella_Object oldValue007 = object007.variableValue;
                        Stella_Object newValue007 = Stella_Object.updateInContext(oldValue007, value007, object007.homeContext, false);

                        if (!((oldValue007 != null) &&
                            (oldValue007.primaryType() == Units.SGT_STELLA_CS_VALUE))) {
                          object007.variableValue = newValue007;
                        }
                      }
                      return (Units.KWD_FINAL_SUCCESS);
                    }
                  }
                  else {
                    return (Units.KWD_FAILURE);
                  }
                }
              }
              else {
                return (Units.KWD_FAILURE);
              }
            }
          }
          else {
            return (Units.KWD_TERMINAL_FAILURE);
          }
        }
      }
      else {
        return (Units.KWD_FAILURE);
      }
    }
  }

  public static Stella_Object uPlusConstraint(IntegerWrapper missingArgument, DimNumberLogicWrapper x1, DimNumberLogicWrapper x2, DimNumberLogicWrapper x3) {
    { Stella_Object value = null;

      switch (missingArgument.wrapperValue) {
        case -1: 
          value = (Stella_Object.eqlP(((DimNumber)(x1.wrapperValue)).add(((DimNumber)(x2.wrapperValue))), ((DimNumber)(x3.wrapperValue))) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
        break;
        case 0: 
          value = (((DimNumber)(x3.wrapperValue)).pid.objectEqlP(((DimNumber)(x2.wrapperValue)).pid) ? Units.wrapDimNumber(((DimNumber)(x3.wrapperValue)).subtract(((DimNumber)(x2.wrapperValue)))) : null);
        break;
        case 1: 
          value = (((DimNumber)(x3.wrapperValue)).pid.objectEqlP(((DimNumber)(x1.wrapperValue)).pid) ? Units.wrapDimNumber(((DimNumber)(x3.wrapperValue)).subtract(((DimNumber)(x1.wrapperValue)))) : null);
        break;
        case 2: 
          value = (((DimNumber)(x1.wrapperValue)).pid.objectEqlP(((DimNumber)(x2.wrapperValue)).pid) ? Units.wrapDimNumber(((DimNumber)(x1.wrapperValue)).add(((DimNumber)(x2.wrapperValue)))) : null);
        break;
        default:
        break;
      }
      return (value);
    }
  }

  public static Stella_Object uMinusConstraint(IntegerWrapper missingArgument, DimNumberLogicWrapper x1, DimNumberLogicWrapper x2, DimNumberLogicWrapper x3) {
    { Stella_Object value = null;

      switch (missingArgument.wrapperValue) {
        case -1: 
          value = (Stella_Object.eqlP(((DimNumber)(x1.wrapperValue)).subtract(((DimNumber)(x2.wrapperValue))), ((DimNumber)(x3.wrapperValue))) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
        break;
        case 0: 
          value = (((DimNumber)(x3.wrapperValue)).pid.objectEqlP(((DimNumber)(x2.wrapperValue)).pid) ? Units.wrapDimNumber(((DimNumber)(x3.wrapperValue)).add(((DimNumber)(x2.wrapperValue)))) : null);
        break;
        case 1: 
          value = (((DimNumber)(x3.wrapperValue)).pid.objectEqlP(((DimNumber)(x1.wrapperValue)).pid) ? Units.wrapDimNumber(((DimNumber)(x1.wrapperValue)).subtract(((DimNumber)(x3.wrapperValue)))) : null);
        break;
        case 2: 
          value = (((DimNumber)(x1.wrapperValue)).pid.objectEqlP(((DimNumber)(x2.wrapperValue)).pid) ? Units.wrapDimNumber(((DimNumber)(x1.wrapperValue)).subtract(((DimNumber)(x2.wrapperValue)))) : null);
        break;
        default:
        break;
      }
      return (value);
    }
  }

  public static Stella_Object uTimesConstraint(IntegerWrapper missingArgument, DimNumberLogicWrapper x1, DimNumberLogicWrapper x2, DimNumberLogicWrapper x3) {
    { Stella_Object value = null;

      switch (missingArgument.wrapperValue) {
        case -1: 
          value = (Stella_Object.eqlP(((DimNumber)(x1.wrapperValue)).multiply(((DimNumber)(x2.wrapperValue))), ((DimNumber)(x3.wrapperValue))) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
        break;
        case 0: 
          value = ((((DimNumber)(x2.wrapperValue)).magnitude == 0.0) ? null : Units.wrapDimNumber(((DimNumber)(x3.wrapperValue)).divide(((DimNumber)(x2.wrapperValue)))));
        break;
        case 1: 
          value = ((((DimNumber)(x1.wrapperValue)).magnitude == 0.0) ? null : Units.wrapDimNumber(((DimNumber)(x3.wrapperValue)).divide(((DimNumber)(x1.wrapperValue)))));
        break;
        case 2: 
          value = Units.wrapDimNumber(((DimNumber)(x1.wrapperValue)).multiply(((DimNumber)(x2.wrapperValue))));
        break;
        default:
        break;
      }
      return (value);
    }
  }

  public static Stella_Object uDivideConstraint(IntegerWrapper missingArgument, DimNumberLogicWrapper x1, DimNumberLogicWrapper x2, DimNumberLogicWrapper x3) {
    { Stella_Object value = null;

      switch (missingArgument.wrapperValue) {
        case -1: 
          value = ((((DimNumber)(x2.wrapperValue)).magnitude == 0.0) ? ((Stella_Object.eqlP(((DimNumber)(x1.wrapperValue)), ((DimNumber)(x2.wrapperValue)).multiply(((DimNumber)(x3.wrapperValue)))) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER)) : ((Stella_Object.eqlP(((DimNumber)(x3.wrapperValue)), ((DimNumber)(x1.wrapperValue)).divide(((DimNumber)(x2.wrapperValue)))) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER)));
        break;
        case 0: 
          value = Units.wrapDimNumber(((DimNumber)(x2.wrapperValue)).multiply(((DimNumber)(x3.wrapperValue))));
        break;
        case 1: 
          value = ((((DimNumber)(x3.wrapperValue)).magnitude == 0.0) ? null : Units.wrapDimNumber(((DimNumber)(x1.wrapperValue)).divide(((DimNumber)(x3.wrapperValue)))));
        break;
        case 2: 
          value = ((((DimNumber)(x2.wrapperValue)).magnitude == 0.0) ? null : Units.wrapDimNumber(((DimNumber)(x1.wrapperValue)).divide(((DimNumber)(x2.wrapperValue)))));
        break;
        default:
        break;
      }
      return (value);
    }
  }

  public static Keyword uAbsSpecialist(ControlFrame frame, Keyword lastmove) {
    { Proposition proposition = frame.proposition;
      Stella_Object mainarg = (proposition.arguments.theArray)[0];
      Stella_Object mainargvalue = Logic.argumentBoundTo(mainarg);
      DimNumberLogicWrapper mainargdim = ((mainargvalue == null) ? ((DimNumberLogicWrapper)(null)) : Units.helpGetDimNumber(mainargvalue));
      Stella_Object absarg = (proposition.arguments.theArray)[1];
      Stella_Object absargvalue = Logic.argumentBoundTo(absarg);
      DimNumberLogicWrapper absargdim = ((absargvalue == null) ? ((DimNumberLogicWrapper)(null)) : Units.helpGetDimNumber(absargvalue));
      Iterator iterator = ((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Units.SYM_STELLA_ITERATOR, null)));
      Cons collection = Stella.NIL;

      lastmove = lastmove;
      if (iterator == null) {
        if (absargvalue == null) {
          if (mainargvalue == null) {
            return (Units.KWD_TERMINAL_FAILURE);
          }
          else {
            if (mainargdim != null) {
              return (Logic.selectProofResult(Logic.bindArgumentToValueP(absarg, Units.wrapDimNumber(((DimNumber)(mainargdim.wrapperValue)).absoluteValue()), true), false, true));
            }
            else {
              return (Units.KWD_TERMINAL_FAILURE);
            }
          }
        }
        else {
          if (absargdim != null) {
            if (((DimNumber)(absargdim.wrapperValue)).magnitude < 0.0) {
              return (Units.KWD_TERMINAL_FAILURE);
            }
            else {
              collection = Cons.consList(Cons.cons(absargdim, Cons.cons(Units.wrapDimNumber(((DimNumber)(absargdim.wrapperValue)).negate()), Stella.NIL)));
            }
          }
          else {
            return (Units.KWD_TERMINAL_FAILURE);
          }
        }
      }
      if (mainargdim != null) {
        if (collection.memberP(mainargdim)) {
          {
            ControlFrame.setFrameTruthValue(frame, Logic.TRUE_TRUTH_VALUE);
            return (Units.KWD_FINAL_SUCCESS);
          }
        }
        else {
          {
            ControlFrame.setFrameTruthValue(frame, Logic.FALSE_TRUTH_VALUE);
            return (Units.KWD_TERMINAL_FAILURE);
          }
        }
      }
      if (iterator == null) {
        iterator = collection.allocateIterator();
        KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Units.SYM_STELLA_ITERATOR, iterator, null);
      }
      if (iterator.nextP() &&
          Logic.bindArgumentToValueP(mainarg, iterator.value, true)) {
        return (Units.KWD_CONTINUING_SUCCESS);
      }
      else {
        return (Units.KWD_TERMINAL_FAILURE);
      }
    }
  }

  public static Keyword uSignumSpecialist(ControlFrame frame, Keyword lastmove) {
    { Proposition proposition = frame.proposition;
      Stella_Object mainarg = (proposition.arguments.theArray)[0];
      Stella_Object mainargvalue = Logic.argumentBoundTo(mainarg);
      DimNumberLogicWrapper mainargdim = ((mainargvalue == null) ? ((DimNumberLogicWrapper)(null)) : Units.helpGetDimNumber(mainargvalue));
      Stella_Object signumarg = (proposition.arguments.theArray)[1];
      Stella_Object signumargvalue = Logic.argumentBoundTo(signumarg);

      lastmove = lastmove;
      if (mainargvalue == null) {
        return (Units.KWD_FAILURE);
      }
      else {
        if (signumargvalue == null) {
          if (mainargdim != null) {
            return (Logic.selectProofResult(Logic.bindArgumentToValueP(signumarg, IntegerWrapper.wrapInteger(((DimNumber)(mainargdim.wrapperValue)).signum()), true), false, true));
          }
          else {
            return (Units.KWD_TERMINAL_FAILURE);
          }
        }
        else {
          if (Stella_Object.isaP(signumargvalue, Units.SGT_STELLA_INTEGER_WRAPPER) &&
              (mainargdim != null)) {
            if (((DimNumber)(mainargdim.wrapperValue)).signum() == ((IntegerWrapper)(signumargvalue)).wrapperValue) {
              {
                ControlFrame.setFrameTruthValue(frame, Logic.TRUE_TRUTH_VALUE);
                return (Units.KWD_FINAL_SUCCESS);
              }
            }
            else {
              {
                ControlFrame.setFrameTruthValue(frame, Logic.FALSE_TRUTH_VALUE);
                return (Units.KWD_TERMINAL_FAILURE);
              }
            }
          }
          else {
            return (Units.KWD_TERMINAL_FAILURE);
          }
        }
      }
    }
  }

  public static Keyword minimumOfUnitsSpecialist(ControlFrame frame, Keyword lastmove) {
    { Proposition proposition = frame.proposition;
      Stella_Object listarg = (proposition.arguments.theArray)[0];
      Stella_Object listskolem = Logic.argumentBoundTo(listarg);
      Stella_Object minarg = (proposition.arguments.theArray)[1];
      Stella_Object minvalue = Logic.argumentBoundTo(minarg);
      DimNumber minimum = null;
      boolean missingunitsP = false;

      lastmove = lastmove;
      if ((listskolem != null) &&
          (!Logic.logicalCollectionP(listskolem))) {
        {
          Stella.STANDARD_OUTPUT.nativeStream.println();
          Stella.STANDARD_OUTPUT.nativeStream.println("Non list appears in second argument to 'MINIMUM-OF-UNITS'");
          Stella.STANDARD_OUTPUT.nativeStream.println();
        }
;
        return (Units.KWD_TERMINAL_FAILURE);
      }
      { List listvalue = Logic.assertedCollectionMembers(listskolem, true);
        DimNumberLogicWrapper dimvalue = null;

        if (listvalue.emptyP()) {
          return (Units.KWD_TERMINAL_FAILURE);
        }
        { Stella_Object v = null;
          Cons iter000 = listvalue.theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            v = iter000.value;
            dimvalue = Units.helpGetDimNumber(v);
            if (dimvalue != null) {
              if ((minimum == null) ||
                  ((DimNumber)(dimvalue.wrapperValue)).lessP(minimum)) {
                minimum = ((DimNumber)(dimvalue.wrapperValue));
              }
            }
            else {
              missingunitsP = true;
            }
          }
        }
        if (minimum == null) {
          return (Units.KWD_TERMINAL_FAILURE);
        }
        if (missingunitsP) {
          if ((minvalue != null) &&
              ((Units.helpGetDimNumber(minvalue) != null) &&
               ((DimNumber)(Units.helpGetDimNumber(minvalue).wrapperValue)).greaterP(minimum))) {
            {
              ControlFrame.setFrameTruthValue(frame, Logic.FALSE_TRUTH_VALUE);
              return (Units.KWD_TERMINAL_FAILURE);
            }
          }
          else {
            {
              ControlFrame.setFrameTruthValue(frame, Logic.UNKNOWN_TRUTH_VALUE);
              return (Units.KWD_FAILURE);
            }
          }
        }
        if (Logic.bindArgumentToValueP(minarg, Units.wrapDimNumber(minimum), true)) {
          {
            ControlFrame.setFrameTruthValue(frame, Logic.TRUE_TRUTH_VALUE);
            return (Units.KWD_FINAL_SUCCESS);
          }
        }
        else {
          {
            ControlFrame.setFrameTruthValue(frame, Logic.FALSE_TRUTH_VALUE);
            return (Units.KWD_TERMINAL_FAILURE);
          }
        }
      }
    }
  }

  public static Keyword maximumOfUnitsSpecialist(ControlFrame frame, Keyword lastmove) {
    { Proposition proposition = frame.proposition;
      Stella_Object listarg = (proposition.arguments.theArray)[0];
      Stella_Object listskolem = Logic.argumentBoundTo(listarg);
      Stella_Object maxarg = (proposition.arguments.theArray)[1];
      Stella_Object maxvalue = Logic.argumentBoundTo(maxarg);
      DimNumber maximum = null;
      boolean missingunitsP = false;

      lastmove = lastmove;
      if ((listskolem != null) &&
          (!Logic.logicalCollectionP(listskolem))) {
        {
          Stella.STANDARD_OUTPUT.nativeStream.println();
          Stella.STANDARD_OUTPUT.nativeStream.println("Non list appears in second argument to 'MAXIMUM-OF-UNITS'");
          Stella.STANDARD_OUTPUT.nativeStream.println();
        }
;
        return (Units.KWD_TERMINAL_FAILURE);
      }
      { List listvalue = Logic.assertedCollectionMembers(listskolem, true);
        DimNumberLogicWrapper dimvalue = null;

        if (listvalue.emptyP()) {
          return (Units.KWD_TERMINAL_FAILURE);
        }
        { Stella_Object v = null;
          Cons iter000 = listvalue.theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            v = iter000.value;
            dimvalue = Units.helpGetDimNumber(v);
            if (Stella_Object.isaP(v, Units.SGT_UNIT_SUPPORT_DIM_NUMBER_LOGIC_WRAPPER)) {
              if ((maximum == null) ||
                  ((DimNumber)(dimvalue.wrapperValue)).greaterP(maximum)) {
                maximum = ((DimNumber)(dimvalue.wrapperValue));
              }
            }
            else {
              missingunitsP = true;
            }
          }
        }
        if (maximum == null) {
          return (Units.KWD_TERMINAL_FAILURE);
        }
        if (missingunitsP) {
          if ((maxvalue != null) &&
              ((Units.helpGetDimNumber(maxvalue) != null) &&
               ((DimNumber)(Units.helpGetDimNumber(maxvalue).wrapperValue)).lessP(maximum))) {
            {
              ControlFrame.setFrameTruthValue(frame, Logic.FALSE_TRUTH_VALUE);
              return (Units.KWD_TERMINAL_FAILURE);
            }
          }
          else {
            {
              ControlFrame.setFrameTruthValue(frame, Logic.UNKNOWN_TRUTH_VALUE);
              return (Units.KWD_FAILURE);
            }
          }
        }
        if (Logic.bindArgumentToValueP(maxarg, Units.wrapDimNumber(maximum), true)) {
          {
            ControlFrame.setFrameTruthValue(frame, Logic.TRUE_TRUTH_VALUE);
            return (Units.KWD_FINAL_SUCCESS);
          }
        }
        else {
          {
            ControlFrame.setFrameTruthValue(frame, Logic.FALSE_TRUTH_VALUE);
            return (Units.KWD_TERMINAL_FAILURE);
          }
        }
      }
    }
  }

  public static Keyword sumOfUnitsSpecialist(ControlFrame frame, Keyword lastmove) {
    { Proposition proposition = frame.proposition;
      Stella_Object listarg = (proposition.arguments.theArray)[0];
      Stella_Object listskolem = Logic.argumentBoundTo(listarg);
      Stella_Object sumarg = (proposition.arguments.theArray)[1];
      DimNumber sum = null;

      lastmove = lastmove;
      if ((listskolem != null) &&
          (!Logic.logicalCollectionP(listskolem))) {
        {
          Stella.STANDARD_OUTPUT.nativeStream.println();
          Stella.STANDARD_OUTPUT.nativeStream.println("Non list appears in second argument to 'SUM-OF-NUMBERS'");
          Stella.STANDARD_OUTPUT.nativeStream.println();
        }
;
        return (Units.KWD_TERMINAL_FAILURE);
      }
      { List listvalue = Logic.assertedCollectionMembers(listskolem, true);
        DimNumberLogicWrapper dimvalue = null;

        if (listvalue.emptyP()) {
          return (Units.KWD_TERMINAL_FAILURE);
        }
        try {
          { Stella_Object v = null;
            Cons iter000 = listvalue.theConsList;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              v = iter000.value;
              dimvalue = Units.helpGetDimNumber(v);
              if (dimvalue != null) {
                if (sum == null) {
                  sum = ((DimNumber)(dimvalue.wrapperValue));
                }
                else {
                  sum = sum.add(((DimNumber)(dimvalue.wrapperValue)));
                }
              }
              else {
                return (Units.KWD_FAILURE);
              }
            }
          }
        } catch (IncompatibleUnitsException e000) {
          return (Units.KWD_TERMINAL_FAILURE);
        }
        if (sum == null) {
          return (Units.KWD_TERMINAL_FAILURE);
        }
        if (Logic.bindArgumentToValueP(sumarg, Units.wrapDimNumber(sum), true)) {
          {
            ControlFrame.setFrameTruthValue(frame, Logic.TRUE_TRUTH_VALUE);
            return (Units.KWD_FINAL_SUCCESS);
          }
        }
        else {
          {
            ControlFrame.setFrameTruthValue(frame, Logic.FALSE_TRUTH_VALUE);
            return (Units.KWD_TERMINAL_FAILURE);
          }
        }
      }
    }
  }

  public static Keyword uValueMeasureSpecialist(ControlFrame frame, Keyword lastmove) {
    { Proposition proposition = frame.proposition;
      Stella_Object mainarg = (proposition.arguments.theArray)[0];
      Stella_Object mainargvalue = Logic.argumentBoundTo(mainarg);
      Stella_Object measurearg = (proposition.arguments.theArray)[1];
      Stella_Object measureargvalue = Logic.argumentBoundTo(measurearg);

      lastmove = lastmove;
      if (mainargvalue == null) {
        return (Units.KWD_FAILURE);
      }
      else {
        if (measureargvalue == null) {
          if (Stella_Object.isaP(mainargvalue, Units.SGT_UNIT_SUPPORT_DIM_NUMBER_LOGIC_WRAPPER)) {
            { Measure measure = ((DimNumber)(((DimNumberLogicWrapper)(mainargvalue)).wrapperValue)).getMeasure();
              LogicObject measureInstance = ((measure != null) ? ((LogicObject)(Units.$MEASURE_INSTANCE_TABLE$.lookup(measure))) : ((LogicObject)(null)));

              if (measureInstance != null) {
                return (Logic.selectProofResult(Logic.bindArgumentToValueP(measurearg, measureInstance, true), false, true));
              }
              else {
                return (Units.KWD_FAILURE);
              }
            }
          }
          else {
            return (Units.KWD_TERMINAL_FAILURE);
          }
        }
        else {
          if (Stella_Object.isaP(mainargvalue, Units.SGT_UNIT_SUPPORT_DIM_NUMBER_LOGIC_WRAPPER)) {
            { Measure measure = ((DimNumber)(((DimNumberLogicWrapper)(mainargvalue)).wrapperValue)).getMeasure();
              LogicObject measureInstance = ((measure != null) ? ((LogicObject)(Units.$MEASURE_INSTANCE_TABLE$.lookup(measure))) : ((LogicObject)(null)));

              if (measureInstance != null) {
                if (measureargvalue == measureInstance) {
                  {
                    ControlFrame.setFrameTruthValue(frame, Logic.TRUE_TRUTH_VALUE);
                    return (Units.KWD_FINAL_SUCCESS);
                  }
                }
                else {
                  {
                    ControlFrame.setFrameTruthValue(frame, Logic.FALSE_TRUTH_VALUE);
                    return (Units.KWD_TERMINAL_FAILURE);
                  }
                }
              }
              else {
                return (Units.KWD_TERMINAL_FAILURE);
              }
            }
          }
          else {
            return (Units.KWD_TERMINAL_FAILURE);
          }
        }
      }
    }
  }

  public static boolean argumentMatchesListHelperP(Stella_Object argument, List theList) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(argument);

      if (Surrogate.subtypeOfP(testValue000, Units.SGT_LOGIC_PATTERN_VARIABLE)) {
        { PatternVariable argument000 = ((PatternVariable)(argument));

          { Stella_Object value = (((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord.variableBindings.theArray)[(argument000.boundToOffset)];

            if (value != null) {
              return (Units.argumentMatchesListHelperP(value, theList));
            }
            else {
              return (true);
            }
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Units.SGT_LOGIC_SKOLEM)) {
        { Skolem argument000 = ((Skolem)(argument));

          { Proposition prop = argument000.definingProposition;
            Vector args = ((prop != null) ? prop.arguments : ((Vector)(null)));
            int listLength = theList.length();

            if (args == null) {
              return (false);
            }
            else if (args.length() == (listLength + 1)) {
              { Stella_Object item = null;
                Cons iter000 = theList.theConsList;
                int i = Stella.NULL_INTEGER;
                int iter001 = 0;

                for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
                  item = iter000.value;
                  i = iter001;
                  if (!(Stella_Object.eqlP(item, (args.theArray)[i]))) {
                    return (false);
                  }
                }
              }
              return (true);
            }
            else {
              return (false);
            }
          }
        }
      }
      else {
        return (false);
      }
    }
  }

  public static Keyword integerToMeasuresHelper(ControlFrame frame, Keyword lastmove, int code) {
    lastmove = lastmove;
    { Proposition proposition = frame.proposition;
      Stella_Object listarg = (proposition.arguments.theArray)[1];
      Stella_Object listargvalue = Logic.argumentBoundTo(listarg);
      List measureslist = List.newList();

      { Measure m = null;
        Cons iter000 = Utilities.computeMeasuresForInteger(code);
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          m = ((Measure)(iter000.value));
          if (collect000 == null) {
            {
              collect000 = Cons.cons(((LogicObject)(Units.$MEASURE_INSTANCE_TABLE$.lookup(m))), Stella.NIL);
              if (measureslist.theConsList == Stella.NIL) {
                measureslist.theConsList = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(measureslist.theConsList, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(((LogicObject)(Units.$MEASURE_INSTANCE_TABLE$.lookup(m))), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      if (listargvalue == null) {
        return (Logic.selectProofResult(Logic.bindArgumentToValueP(listarg, Logic.createLogicalList(measureslist), true), false, true));
      }
      else if (Units.argumentMatchesListHelperP(listarg, measureslist)) {
        ControlFrame.setFrameTruthValue(frame, Logic.TRUE_TRUTH_VALUE);
        return (Units.KWD_FINAL_SUCCESS);
      }
      else {
        ControlFrame.setFrameTruthValue(frame, Logic.FALSE_TRUTH_VALUE);
        return (Units.KWD_TERMINAL_FAILURE);
      }
    }
  }

  public static Keyword uBaseMeasuresSpecialist(ControlFrame frame, Keyword lastmove) {
    { Proposition proposition = frame.proposition;
      Stella_Object mainarg = (proposition.arguments.theArray)[0];
      Stella_Object mainargvalue = Logic.argumentBoundTo(mainarg);
      int value = Stella.NULL_INTEGER;

      if (mainargvalue == null) {
        return (Units.KWD_FAILURE);
      }
      else {
        { Surrogate testValue000 = Stella_Object.safePrimaryType(mainargvalue);

          if (Surrogate.subtypeOfP(testValue000, Units.SGT_UNIT_SUPPORT_DIM_NUMBER_LOGIC_WRAPPER)) {
            { DimNumberLogicWrapper mainargvalue000 = ((DimNumberLogicWrapper)(mainargvalue));

              { GeneralizedSymbol testValue001 = proposition.operator;

                if (testValue001 == Units.SGT_UNIT_KB_NUMERATOR_MEASURES) {
                  value = ((DimNumber)(mainargvalue000.wrapperValue)).pid.numerator;
                }
                else if (testValue001 == Units.SGT_UNIT_KB_DENOMINATOR_MEASURES) {
                  value = ((DimNumber)(mainargvalue000.wrapperValue)).pid.denominator;
                }
                else {
                  { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                    stream000.nativeStream.print("`" + testValue001 + "' is not a valid case option");
                    throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                  }
                }
              }
              return (Units.integerToMeasuresHelper(frame, lastmove, value));
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Units.SGT_LOGIC_LOGIC_OBJECT)) {
            { LogicObject mainargvalue000 = ((LogicObject)(mainargvalue));

              { Measure measure = ((Measure)(Units.$INSTANCE_MEASURE_TABLE$.lookup(mainargvalue000)));

                if (measure != null) {
                  { GeneralizedSymbol testValue002 = proposition.operator;

                    if (testValue002 == Units.SGT_UNIT_KB_NUMERATOR_MEASURES) {
                      value = measure.primeId.numerator;
                    }
                    else if (testValue002 == Units.SGT_UNIT_KB_DENOMINATOR_MEASURES) {
                      value = measure.primeId.denominator;
                    }
                    else {
                      { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                        stream001.nativeStream.print("`" + testValue002 + "' is not a valid case option");
                        throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
                      }
                    }
                  }
                  return (Units.integerToMeasuresHelper(frame, lastmove, value));
                }
              }
              return (Units.KWD_FAILURE);
            }
          }
          else {
            return (Units.KWD_FAILURE);
          }
        }
      }
    }
  }

  public static Ratio getObjectPid(Stella_Object obj) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(obj);

      if (Surrogate.subtypeOfP(testValue000, Units.SGT_UNIT_SUPPORT_DIM_NUMBER_LOGIC_WRAPPER)) {
        { DimNumberLogicWrapper obj000 = ((DimNumberLogicWrapper)(obj));

          return (((DimNumber)(obj000.wrapperValue)).pid);
        }
      }
      else if (Surrogate.subtypeOfStringP(testValue000)) {
        { StringWrapper obj000 = ((StringWrapper)(obj));

          { String stringValue = obj000.wrapperValue;

            if (stringValue == null) {
              return (null);
            }
            else {
              { double dummy = Stella.NULL_FLOAT;
                Ratio pid = null;

                { Object [] caller_MV_returnarray = new Object[1];

                  dummy = Utilities.unitToScaleFactorAndId(stringValue, caller_MV_returnarray);
                  pid = ((Ratio)(caller_MV_returnarray[0]));
                }
                dummy = dummy;
                return (pid);
              }
            }
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Units.SGT_STELLA_NUMBER_WRAPPER)) {
        { NumberWrapper obj000 = ((NumberWrapper)(obj));

          return (Utilities.$RATIO_ONE$);
        }
      }
      else {
        return (null);
      }
    }
  }

  public static Keyword comensurateUnitsSpecialist(ControlFrame frame, Keyword lastmove) {
    { Proposition proposition = frame.proposition;
      Stella_Object arg1 = (proposition.arguments.theArray)[0];
      Stella_Object arg1Value = Logic.argumentBoundTo(arg1);
      Stella_Object arg2 = (proposition.arguments.theArray)[1];
      Stella_Object arg2Value = Logic.argumentBoundTo(arg2);

      lastmove = lastmove;
      if ((arg1Value == null) ||
          (arg2Value == null)) {
        return (Units.KWD_FAILURE);
      }
      else {
        try {
          { Ratio arg1Pid = Units.getObjectPid(arg1Value);
            Ratio arg2Pid = Units.getObjectPid(arg2Value);

            if ((arg1Pid != null) &&
                (arg2Pid != null)) {
              return (Logic.selectTestResult(arg1Pid.objectEqlP(arg2Pid), true, frame));
            }
            else {
              return (Units.KWD_FAILURE);
            }
          }
        } catch (BadArgumentException e000) {
          return (Logic.selectTestResult(false, true, frame));
        }
      }
    }
  }

  public static void initializeMeasureConcepts() {
    { Object old$Context$000 = Stella.$CONTEXT$.get();
      Object old$Module$000 = Stella.$MODULE$.get();

      try {
        Native.setSpecial(Stella.$CONTEXT$, Stella.getStellaContext("PL-KERNEL-KB", true));
        Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
        { LogicObject i = null;
          LogicObject measure = edu.isi.powerloom.PLI.getConcept("/UNIT-KB/MEASURE", null, null);
          LogicObject baseMeasure = edu.isi.powerloom.PLI.getConcept("/UNIT-KB/BASE-MEASURE", null, null);
          LogicObject unitRelation = edu.isi.powerloom.PLI.getRelation("/UNIT-KB/MEASURE-UNIT", null, null);
          String measureName = null;

          { Measure m = null;
            Cons iter000 = Utilities.$ALL_MEASURES$;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              m = ((Measure)(iter000.value));
              measureName = "/UNIT-KB/" + Native.stringUpcase(m.name) + "-MEASURE";
              i = edu.isi.powerloom.PLI.getConcept(measureName, null, null);
              if (!(i != null)) {
                i = edu.isi.powerloom.PLI.createConcept(measureName, measure, null, null);
              }
              edu.isi.powerloom.PLI.assertUnaryProposition(measure, i, null, null);
              if (Utilities.$BASE_MEASURES$.memberP(m)) {
                edu.isi.powerloom.PLI.assertUnaryProposition(baseMeasure, i, null, null);
              }
              Units.$MEASURE_INSTANCE_TABLE$.insertAt(m, i);
              Units.$INSTANCE_MEASURE_TABLE$.insertAt(i, m);
              { StringWrapper u = null;
                Cons iter001 = m.getUnits().theConsList;

                for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                  u = ((StringWrapper)(iter001.value));
                  edu.isi.powerloom.PLI.assertBinaryProposition(unitRelation, i, u, null, null);
                }
              }
            }
          }
        }

      } finally {
        Stella.$MODULE$.set(old$Module$000);
        Stella.$CONTEXT$.set(old$Context$000);
      }
    }
  }

}
