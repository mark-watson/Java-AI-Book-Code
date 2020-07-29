//  -*- Mode: Java -*-
//
// _StartupUnits.java

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

public class _StartupUnits {
  static void helpStartupUnits1() {
    {
      Utilities.SGT_UTILITIES_RATIO = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("RATIO", null, 1)));
      Utilities.SYM_UTILITIES_NUMERATOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NUMERATOR", null, 0)));
      Utilities.SYM_UTILITIES_DENOMINATOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DENOMINATOR", null, 0)));
      Utilities.KWD_START = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("START", null, 2)));
      Utilities.SYM_STELLA_$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("*", Stella.getStellaModule("/STELLA", true), 0)));
      Utilities.KWD_INTEGER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INTEGER", null, 2)));
      Utilities.KWD_DELIMITER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DELIMITER", null, 2)));
      Utilities.KWD_FRACTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FRACTION", null, 2)));
      Utilities.KWD_UNIT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("UNIT", null, 2)));
      Utilities.KWD_EOF = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("EOF", null, 2)));
      Utilities.KWD_OTHERWISE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("OTHERWISE", null, 2)));
      Utilities.KWD_ERROR = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ERROR", null, 2)));
      Utilities.KWD_INCLUDE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INCLUDE", null, 2)));
      Utilities.SGT_UTILITIES_MEASURE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("MEASURE", null, 1)));
      Utilities.SYM_UTILITIES_BASE_UNIT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BASE-UNIT", null, 0)));
      Utilities.SYM_UTILITIES_SCALE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SCALE", null, 0)));
      Utilities.SYM_UTILITIES_PRIME_ID = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PRIME-ID", null, 0)));
      Utilities.SYM_STELLA_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NAME", Stella.getStellaModule("/STELLA", true), 0)));
      Utilities.KWD_PRESERVE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PRESERVE", null, 2)));
      Utilities.SGT_UTILITIES_DIM_NUMBER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DIM-NUMBER", null, 1)));
      Utilities.SYM_UTILITIES_PID = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PID", null, 0)));
      Utilities.SYM_UTILITIES_MAGNITUDE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MAGNITUDE", null, 0)));
      Utilities.SYM_UTILITIES_PREFERRED_UNITS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PREFERRED-UNITS", null, 0)));
      Utilities.KWD_DIGIT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DIGIT", null, 2)));
      Utilities.SGT_STELLA_TIME_DURATION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TIME-DURATION", Stella.getStellaModule("/STELLA", true), 1)));
      Utilities.SYM_UTILITIES_STARTUP_UNITS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-UNITS", null, 0)));
    }
  }

  static void helpStartupUnits2() {
    {
      Utilities.$PRIME_NUMBERS$ = Stella.getQuotedTree("((2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97) \"/UTILITIES\")", "/UTILITIES");
      Utilities.$PRIME_TO_MEASURE_TABLE$ = StellaHashTable.newStellaHashTable();
      Utilities.$PRIME_TO_BASE_MEASURE_TABLE$ = IntegerHashTable.newIntegerHashTable();
      Utilities.$NAME_TO_MEASURE_TABLE$ = StringHashTable.newStringHashTable();
      Utilities.$UNIT_TO_MEASURE_TABLE$ = StringHashTable.newStringHashTable();
      Utilities.$ALL_MEASURES$ = Stella.NIL;
      Utilities.$BASE_MEASURES$ = Stella.NIL;
      Utilities.$RATIO_ONE$ = Ratio.newRatio(1, 1);
      Utilities.$UNIT_TOKENIZER_TABLE_DEFINITION$ = Cons.list$(Cons.cons(Cons.list$(Cons.cons(Utilities.KWD_START, Cons.cons(Utilities.SYM_STELLA_$, Cons.cons(StringWrapper.wrapString("-+0123456789"), Cons.cons(Utilities.KWD_INTEGER, Cons.cons(Utilities.SYM_STELLA_$, Cons.cons(StringWrapper.wrapString("."), Cons.cons(Utilities.KWD_DELIMITER, Cons.cons(Utilities.SYM_STELLA_$, Cons.cons(StringWrapper.wrapString("/"), Cons.cons(Utilities.KWD_FRACTION, Cons.cons(Utilities.SYM_STELLA_$, Cons.cons(StringWrapper.wrapString("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ%"), Cons.cons(Utilities.KWD_UNIT, Cons.cons(Utilities.KWD_EOF, Cons.cons(Utilities.KWD_EOF, Cons.cons(Utilities.KWD_OTHERWISE, Cons.cons(Utilities.KWD_ERROR, Cons.cons(Stella.NIL, Stella.NIL))))))))))))))))))), Cons.cons(Cons.list$(Cons.cons(Utilities.KWD_UNIT, Cons.cons(Utilities.SYM_STELLA_$, Cons.cons(StringWrapper.wrapString("-+0123456789"), Cons.cons(Utilities.KWD_INTEGER, Cons.cons(Utilities.SYM_STELLA_$, Cons.cons(StringWrapper.wrapString("."), Cons.cons(Utilities.KWD_DELIMITER, Cons.cons(Utilities.SYM_STELLA_$, Cons.cons(StringWrapper.wrapString("/"), Cons.cons(Utilities.KWD_FRACTION, Cons.cons(StringWrapper.wrapString("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ%"), Cons.cons(Utilities.KWD_UNIT, Cons.cons(Utilities.KWD_EOF, Cons.cons(Utilities.KWD_EOF, Cons.cons(Utilities.KWD_OTHERWISE, Cons.cons(Utilities.KWD_ERROR, Cons.cons(Stella.NIL, Stella.NIL)))))))))))))))))), Cons.cons(Cons.list$(Cons.cons(Utilities.KWD_INTEGER, Cons.cons(StringWrapper.wrapString("-+0123456789"), Cons.cons(Utilities.KWD_INTEGER, Cons.cons(Utilities.SYM_STELLA_$, Cons.cons(StringWrapper.wrapString("."), Cons.cons(Utilities.KWD_DELIMITER, Cons.cons(Utilities.SYM_STELLA_$, Cons.cons(StringWrapper.wrapString("/"), Cons.cons(Utilities.KWD_FRACTION, Cons.cons(Utilities.SYM_STELLA_$, Cons.cons(StringWrapper.wrapString("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ%"), Cons.cons(Utilities.KWD_UNIT, Cons.cons(Utilities.KWD_EOF, Cons.cons(Utilities.KWD_EOF, Cons.cons(Utilities.KWD_OTHERWISE, Cons.cons(Utilities.KWD_ERROR, Cons.cons(Stella.NIL, Stella.NIL)))))))))))))))))), Cons.cons(Cons.list$(Cons.cons(Utilities.KWD_FRACTION, Cons.cons(Utilities.KWD_INCLUDE, Cons.cons(Utilities.KWD_START, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Utilities.KWD_DELIMITER, Cons.cons(Utilities.KWD_INCLUDE, Cons.cons(Utilities.KWD_START, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Utilities.KWD_ERROR, Cons.cons(Utilities.KWD_INCLUDE, Cons.cons(Utilities.KWD_START, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))))));
    }
  }

  static void helpStartupUnits3() {
    {
      Stella.defineFunctionObject("NEXT-PRIME-ID", "(DEFUN (NEXT-PRIME-ID INTEGER) () :PUBLIC? FALSE)", Native.find_java_method("edu.isi.stella.utilities.Utilities", "nextPrimeId", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("MAKE-RATIO", "(DEFUN (MAKE-RATIO RATIO) ((NUM INTEGER) (DENOM INTEGER)) :PUBLIC? TRUE :CONSTRUCTOR? TRUE)", Native.find_java_method("edu.isi.stella.utilities.Ratio", "makeRatio", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE}), null);
      Stella.defineMethodObject("(DEFMETHOD (HASH-CODE INTEGER) ((SELF RATIO)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.utilities.Ratio", "hashCode_", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (COERCE-TO RATIO) ((X RATIO) (Y OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"Coerces `y' to be a compatible type with `x'.\nIf this isn't possible, an exception is thrown.  The exception\nwill be either INCOMPATIBLE-QUANTITY-EXCEPTION or \nINCOMPATIBLE-UNITS-EXCEPTION.\")", Native.find_java_method("edu.isi.stella.utilities.Ratio", "coerceTo", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (OBJECT-EQL? BOOLEAN) ((X RATIO) (Y OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.utilities.Ratio", "objectEqlP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (LESS? BOOLEAN) ((X RATIO) (Y OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"Computes `x' < `y'\")", Native.find_java_method("edu.isi.stella.utilities.Ratio", "lessP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (LESS-EQUAL? BOOLEAN) ((X RATIO) (Y OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"Computes `x' <= `y'\")", Native.find_java_method("edu.isi.stella.utilities.Ratio", "lessEqualP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (GREATER-EQUAL? BOOLEAN) ((X RATIO) (Y OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"Computes `x' >= `y'\")", Native.find_java_method("edu.isi.stella.utilities.Ratio", "greaterEqualP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (GREATER? BOOLEAN) ((X RATIO) (Y OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"Computes `x' > `y'\")", Native.find_java_method("edu.isi.stella.utilities.Ratio", "greaterP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (ADD RATIO) ((X RATIO) (Y RATIO)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.utilities.Ratio", "add", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.Ratio")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (SUBTRACT RATIO) ((X RATIO) (Y RATIO)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.utilities.Ratio", "subtract", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.Ratio")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (MULTIPLY RATIO) ((X RATIO) (Y RATIO)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.utilities.Ratio", "multiply", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.Ratio")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (DIVIDE RATIO) ((X RATIO) (Y RATIO)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.utilities.Ratio", "divide", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.Ratio")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (NEGATE RATIO) ((X RATIO)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.utilities.Ratio", "negate", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (INVERT RATIO) ((X RATIO)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.utilities.Ratio", "invert", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("IPOWER", "(DEFUN (IPOWER INTEGER) ((X INTEGER) (EXP INTEGER)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "ipower", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE}), null);
      Stella.defineMethodObject("(DEFMETHOD (EXPONENTIATE RATIO) ((X RATIO) (Y INTEGER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.utilities.Ratio", "exponentiate", new java.lang.Class [] {java.lang.Integer.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("RESET-MEASURES", "(DEFUN RESET-MEASURES () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.utilities.Utilities", "resetMeasures", new java.lang.Class [] {}), null);
      Stella.defineMethodObject("(DEFMETHOD SETUP-INDICES ((M MEASURE)))", Native.find_java_method("edu.isi.stella.utilities.Measure", "setupIndices", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (BASE-MEASURE? BOOLEAN) ((M MEASURE)) :PUBLIC? TRUE :DOCUMENTATION \"Returns `true' if `m' is a base measure.\")", Native.find_java_method("edu.isi.stella.utilities.Measure", "baseMeasureP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("DEFINE-BASE-MEASURE", "(DEFUN (DEFINE-BASE-MEASURE MEASURE) ((MEASURE-NAME STRING) (MEASURE-BASE-UNIT STRING)) :CONSTRUCTOR? TRUE)", Native.find_java_method("edu.isi.stella.utilities.Measure", "defineBaseMeasure", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("DEFINE-DERIVED-MEASURE", "(DEFUN (DEFINE-DERIVED-MEASURE MEASURE) ((MEASURE-NAME STRING) (MEASURE-BASE-UNIT STRING) (DEFINITION STRING)) :CONSTRUCTOR? TRUE)", Native.find_java_method("edu.isi.stella.utilities.Measure", "defineDerivedMeasure", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("DEFINE-DIMENSIONLESS-MEASURE", "(DEFUN (DEFINE-DIMENSIONLESS-MEASURE MEASURE) () :CONSTRUCTOR? TRUE)", Native.find_java_method("edu.isi.stella.utilities.Measure", "defineDimensionlessMeasure", new java.lang.Class [] {}), null);
      Stella.defineMethodObject("(DEFMETHOD ADD-UNIT ((SELF MEASURE) (UNIT-NAME STRING) (SCALE-FACTOR FLOAT) (DEFINITION STRING)))", Native.find_java_method("edu.isi.stella.utilities.Measure", "addUnit", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Double.TYPE, Native.find_java_class("java.lang.String")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("LOOKUP-MEASURE", "(DEFUN (LOOKUP-MEASURE MEASURE) ((NAME STRING)) :PUBLIC? TRUE :CONSTRUCTOR? TRUE)", Native.find_java_method("edu.isi.stella.utilities.Measure", "lookupMeasure", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("LOOKUP-MEASURE-FOR-UNIT", "(DEFUN (LOOKUP-MEASURE-FOR-UNIT MEASURE) ((UNIT STRING)) :PUBLIC? TRUE :CONSTRUCTOR? TRUE)", Native.find_java_method("edu.isi.stella.utilities.Measure", "lookupMeasureForUnit", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineMethodObject("(DEFMETHOD (GET-UNITS (LIST OF STRING-WRAPPER)) ((SELF MEASURE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.utilities.Measure", "getUnits", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("UNIT-TO-SCALE-FACTOR-AND-ID", "(DEFUN (UNIT-TO-SCALE-FACTOR-AND-ID FLOAT RATIO) ((DEFINITION STRING)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "unitToScaleFactorAndId", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("COMPUTE-MEASURES-FOR-INTEGER", "(DEFUN (COMPUTE-MEASURES-FOR-INTEGER (CONS OF MEASURE)) ((VALUE INTEGER)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "computeMeasuresForInteger", new java.lang.Class [] {java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("COMPUTE-MEASURES-FOR-PRIME-ID", "(DEFUN (COMPUTE-MEASURES-FOR-PRIME-ID (CONS OF MEASURE) (CONS OF MEASURE)) ((PID RATIO)) :PUBLIC? TRUE :DOCUMENTATION \"Returns two CONSes of Measure objects for the prime ID `pid'\")", Native.find_java_method("edu.isi.stella.utilities.Ratio", "computeMeasuresForPrimeId", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.Ratio"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("COMPUTE-UNITS-FOR-INTEGER", "(DEFUN (COMPUTE-UNITS-FOR-INTEGER STRING) ((VALUE INTEGER) (NEGATE-EXPONENT? BOOLEAN)))", Native.find_java_method("edu.isi.stella.utilities.Utilities", "computeUnitsForInteger", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("COMPUTE-UNITS-FOR-PRIME-ID", "(DEFUN (COMPUTE-UNITS-FOR-PRIME-ID STRING) ((PID RATIO)))", Native.find_java_method("edu.isi.stella.utilities.Ratio", "computeUnitsForPrimeId", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.Ratio")}), null);
      Stella.defineFunctionObject("MAKE-DIM-NUMBER", "(DEFUN (MAKE-DIM-NUMBER DIM-NUMBER) ((MAGNITUDE FLOAT) (UNITS STRING)) :PUBLIC? TRUE :CONSTRUCTOR? TRUE)", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "makeDimNumber", new java.lang.Class [] {java.lang.Double.TYPE, Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("PARSE-DIM-NUMBER", "(DEFUN (PARSE-DIM-NUMBER DIM-NUMBER) ((INPUT STRING)) :PUBLIC? TRUE :CONSTRUCTOR? TRUE)", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "parseDimNumber", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineMethodObject("(DEFMETHOD (COERCE-TO DIM-NUMBER) ((X DIM-NUMBER) (Y OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"Coerces `y' to be a compatible type with `x'.\nIf this isn't possible, an exception is thrown.  The exception\nwill be either INCOMPATIBLE-QUANTITY-EXCEPTION or \nINCOMPATIBLE-UNITS-EXCEPTION.\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "coerceTo", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (GET-MAGNITUDE FLOAT) ((SELF DIM-NUMBER) (UNITS STRING)) :PUBLIC? TRUE :DOCUMENTATION \"Returns the magnitude of the dim number in the given units.\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "getMagnitude", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (GET-UNIT STRING) ((SELF DIM-NUMBER)) :PUBLIC? TRUE :DOCUMENTATION \"Returns the units for the dim number.  This will return the\npreferred output units if they exist, otherwise the base units. (see `get-base-unit')\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "getUnit", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (GET-BASE-UNIT STRING) ((SELF DIM-NUMBER)) :PUBLIC? TRUE :DOCUMENTATION \"Returns the base units for the dim number.\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "getBaseUnit", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (GET-MEASURE MEASURE) ((SELF DIM-NUMBER)) :PUBLIC? TRUE :DOCUMENTATION \"Returns the measure for the dim number, if one is defined.\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "getMeasure", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (GET-BASE-MEASURES (CONS OF MEASURE) (CONS OF MEASURE)) ((SELF DIM-NUMBER)) :PUBLIC? TRUE :DOCUMENTATION \"Returns cons of the base measures for the numerator and denominator\nof `self'.\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "getBaseMeasures", new java.lang.Class [] {Native.find_java_class("[Ljava.lang.Object;")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (FORMAT-DIM-NUMBER STRING) ((X DIM-NUMBER) (UNITS STRING) (DECIMALS INTEGER)) :PUBLIC? TRUE :DOCUMENTATION \"Returns a string representation of `x' in `units' with `decimals' digits.\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "formatDimNumber", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Integer.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("COMPATIBLE-UNITS?", "(DEFUN (COMPATIBLE-UNITS? BOOLEAN) ((X DIM-NUMBER) (Y DIM-NUMBER)) :PUBLIC? TRUE :GLOBALLY-INLINE? TRUE :DOCUMENTATION \"Returns TRUE if the units of `x' and `y' are compatible.\" (RETURN (OBJECT-EQL? (PID X) (PID Y))))", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "compatibleUnitsP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.DimNumber"), Native.find_java_class("edu.isi.stella.utilities.DimNumber")}), null);
      Stella.defineMethodObject("(DEFMETHOD (OBJECT-EQL? BOOLEAN) ((X DIM-NUMBER) (Y OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "objectEqlP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (HASH-CODE INTEGER) ((SELF DIM-NUMBER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "hashCode_", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (SIGNUM INTEGER) ((X DIM-NUMBER)) :PUBLIC? TRUE :DOCUMENTATION \"Computes the signum of `x':  -1 if negative, 0 if zero, 1 if positive\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "signum", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (ADD DIM-NUMBER) ((X DIM-NUMBER) (Y DIM-NUMBER)) :PUBLIC? TRUE :DOCUMENTATION \"Computes `x' + `y'\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "add", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.DimNumber")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (SUBTRACT DIM-NUMBER) ((X DIM-NUMBER) (Y DIM-NUMBER)) :PUBLIC? TRUE :DOCUMENTATION \"Computes `x' - `y'\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "subtract", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.DimNumber")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (MULTIPLY DIM-NUMBER) ((X DIM-NUMBER) (Y DIM-NUMBER)) :PUBLIC? TRUE :DOCUMENTATION \"Computes `x' * `y'\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "multiply", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.DimNumber")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (DIVIDE DIM-NUMBER) ((X DIM-NUMBER) (Y DIM-NUMBER)) :PUBLIC? TRUE :DOCUMENTATION \"Computes `x' / `y'\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "divide", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.DimNumber")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (MODULUS DIM-NUMBER) ((X DIM-NUMBER) (Y DIM-NUMBER)) :PUBLIC? TRUE :DOCUMENTATION \"Computes the modulus of `x' and `y'.  `x' and `y' must be compatible\nunits, and the result has the preferred units of `x'.\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "modulus", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.DimNumber")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (NEGATE DIM-NUMBER) ((X DIM-NUMBER)) :PUBLIC? TRUE :DOCUMENTATION \"Computes - `x'\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "negate", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (INVERT DIM-NUMBER) ((X DIM-NUMBER)) :PUBLIC? TRUE :DOCUMENTATION \"Computes  1 / `x'\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "invert", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (ABSOLUTE-VALUE DIM-NUMBER) ((X DIM-NUMBER)) :PUBLIC? TRUE :DOCUMENTATION \"Computes  abs(`x')\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "absoluteValue", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (SQUARE-ROOT DIM-NUMBER) ((X DIM-NUMBER)) :PUBLIC? TRUE :DOCUMENTATION \"Computes the positive square root of x, assuming the units are perfect squares\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "squareRoot", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (EXPONENTIATE DIM-NUMBER) ((X DIM-NUMBER) (Y INTEGER)) :PUBLIC? TRUE :DOCUMENTATION \"Computes `x' ^ `y'\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "exponentiate", new java.lang.Class [] {java.lang.Integer.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (LESS? BOOLEAN) ((X DIM-NUMBER) (Y OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"Computes `x' < `y'\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "lessP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (LESS-EQUAL? BOOLEAN) ((X DIM-NUMBER) (Y OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"Computes `x' <= `y'\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "lessEqualP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (GREATER-EQUAL? BOOLEAN) ((X DIM-NUMBER) (Y OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"Computes `x' >= `y'\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "greaterEqualP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (GREATER? BOOLEAN) ((X DIM-NUMBER) (Y OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"Computes `x' > `y'\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "greaterP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("DIM-TO-TIME-DURATION", "(DEFUN (DIM-TO-TIME-DURATION TIME-DURATION) ((TIME-VALUE DIM-NUMBER)) :PUBLIC? TRUE :DOCUMENTATION \"Converts the dimensioned number `time-value' to its\nequivalent value as a `time-duration' object.  If `time-value' is not\nof the appropriate units, an `incompatible-units-exception' is thrown.\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "dimToTimeDuration", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.DimNumber")}), null);
    }
  }

  public static void startupUnits() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/UTILITIES", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupUnits.helpStartupUnits1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          _StartupUnits.helpStartupUnits2();
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("INCOMPATIBLE-UNITS-EXCEPTION", "(DEFCLASS INCOMPATIBLE-UNITS-EXCEPTION (INCOMPATIBLE-QUANTITY-EXCEPTION) :PUBLIC? TRUE)");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.utilities.IncompatibleUnitsException", "newIncompatibleUnitsException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("RATIO", "(DEFCLASS RATIO (QUANTITY) :PUBLIC? TRUE :PUBLIC-SLOTS ((NUMERATOR :TYPE INTEGER :REQUIRED? TRUE) (DENOMINATOR :TYPE INTEGER :REQUIRED? TRUE)) :PRINT-FORM (PRINT-STREAM STREAM (NUMERATOR SELF) \"/\" (DENOMINATOR SELF)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.utilities.Ratio", "newRatio", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.utilities.Ratio", "accessRatioSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.Ratio"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("MEASURE", "(DEFCLASS MEASURE (STANDARD-OBJECT) :PUBLIC? TRUE :PUBLIC-SLOTS ((BASE-UNIT :TYPE STRING) (SCALE :TYPE (KEY-VALUE-LIST OF STRING-WRAPPER FLOAT-WRAPPER) :INITIALLY (NEW KEY-VALUE-LIST)) (PRIME-ID :TYPE RATIO) (NAME :TYPE STRING)) :PRINT-FORM (PRINT-NATIVE-STREAM STREAM \"<Measure \" (NAME SELF) \"(\" (BASE-UNIT SELF) \")>\"))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.utilities.Measure", "newMeasure", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.utilities.Measure", "accessMeasureSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.Measure"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("DIM-NUMBER", "(DEFCLASS DIM-NUMBER (QUANTITY) :PUBLIC? TRUE :PUBLIC-SLOTS ((PID :TYPE RATIO :REQUIRED? TRUE) (MAGNITUDE :TYPE FLOAT :REQUIRED? TRUE) (PREFERRED-UNITS :TYPE STRING :INITIALLY NULL)) :PRINT-FORM (PRINT-STREAM STREAM \"<\" (GET-MAGNITUDE SELF (GET-UNIT SELF)) (GET-UNIT SELF) \">\"))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.stella.utilities.DimNumber", "newDimNumber", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.Ratio"), java.lang.Double.TYPE});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.stella.utilities.DimNumber", "accessDimNumberSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.DimNumber"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupUnits.helpStartupUnits3();
          Stella.defineFunctionObject("TIME-DURATION-TO-DIM", "(DEFUN (TIME-DURATION-TO-DIM DIM-NUMBER) ((DURATION TIME-DURATION)) :PUBLIC? TRUE :DOCUMENTATION \"Converts the time duration `duration' to its\nequivalent value as dimensioned number.  The default time unit\nwill be used.\")", Native.find_java_method("edu.isi.stella.utilities.Utilities", "timeDurationToDim", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TimeDuration")}), null);
          Stella.defineFunctionObject("DMS-TO-DEGREES", "(DEFUN (DMS-TO-DEGREES DIM-NUMBER) ((L (CONS OF DIM-NUMBER))) :PUBLIC? TRUE :DOCUMENTATION \"Converts a (Degree Minute Second) to decimal degrees.\")", Native.find_java_method("edu.isi.stella.utilities.Utilities", "dmsToDegrees", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("DEGREES-TO-DMS", "(DEFUN (DEGREES-TO-DMS (CONS OF DIM-NUMBER)) ((D DIM-NUMBER)) :PUBLIC? TRUE :DOCUMENTATION \"Convert decimal degrees to a list of (Degree Minute Second)\nwhere Degree and Minute are integer-valued.\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "degreesToDms", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.DimNumber")}), null);
          Stella.defineFunctionObject("HMS-TO-HOURS", "(DEFUN (HMS-TO-HOURS DIM-NUMBER) ((L (CONS OF DIM-NUMBER))) :PUBLIC? TRUE :DOCUMENTATION \"Converts a (Hour Minute Second) to decimal hours\")", Native.find_java_method("edu.isi.stella.utilities.Utilities", "hmsToHours", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("HOURS-TO-HMS", "(DEFUN (HOURS-TO-HMS (CONS OF DIM-NUMBER)) ((D DIM-NUMBER)) :PUBLIC? TRUE :DOCUMENTATION \"Convert decimal hours to a list of (Hour Minute Second)\nwhere Hour and Minute are integer-valued.\")", Native.find_java_method("edu.isi.stella.utilities.DimNumber", "hoursToHms", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.utilities.DimNumber")}), null);
          Stella.defineFunctionObject("SHOW-MEASURES", "(DEFUN SHOW-MEASURES () :PUBLIC? TRUE :COMMAND? TRUE :DOCUMENTATION \"Print all defined measures.\")", Native.find_java_method("edu.isi.stella.utilities.Utilities", "showMeasures", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("SHOW-MEASURE", "(DEFUN SHOW-MEASURE ((MEASURE-NAME STRING)) :PUBLIC? TRUE :COMMAND? TRUE :DOCUMENTATION \"Print all units and scale factors for measure `measure-name'.\")", Native.find_java_method("edu.isi.stella.utilities.Utilities", "showMeasure", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), Native.find_java_method("edu.isi.stella.utilities.Utilities", "showMeasureEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("STARTUP-UNITS", "(DEFUN STARTUP-UNITS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.utilities._StartupUnits", "startupUnits", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Utilities.SYM_UTILITIES_STARTUP_UNITS);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Utilities.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupUnits"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("UTILITIES")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *PRIME-NUMBERS* (CONS OF INTEGER-WRAPPER) (QUOTE (2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97)) :PUBLIC? FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CURRENT-PRIME-INDEX* INTEGER -1 :PUBLIC? FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *PRIME-TO-MEASURE-TABLE* (STELLA-HASH-TABLE OF RATIO MEASURE) (NEW STELLA-HASH-TABLE) :PUBLIC? FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *PRIME-TO-BASE-MEASURE-TABLE* (INTEGER-HASH-TABLE OF INTEGER MEASURE) (NEW INTEGER-HASH-TABLE) :PUBLIC? FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *NAME-TO-MEASURE-TABLE* (STRING-HASH-TABLE OF STRING MEASURE) (NEW STRING-HASH-TABLE) :PUBLIC? FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *UNIT-TO-MEASURE-TABLE* (STRING-HASH-TABLE OF STRING MEASURE) (NEW STRING-HASH-TABLE) :PUBLIC? FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *ALL-MEASURES* (CONS OF MEASURE) NIL :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *BASE-MEASURES* (CONS OF MEASURE) NIL :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *RATIO-ONE* RATIO (NEW RATIO :NUMERATOR 1 :DENOMINATOR 1) :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *UNIT-TOKENIZER-TABLE-DEFINITION* CONS (BQUOTE ((:START * \"-+0123456789\" :INTEGER * \".\" :DELIMITER * \"/\" :FRACTION * \"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ%\" :UNIT :EOF :EOF :OTHERWISE :ERROR) (:UNIT * \"-+0123456789\" :INTEGER * \".\" :DELIMITER * \"/\" :FRACTION \"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ%\" :UNIT :EOF :EOF :OTHERWISE :ERROR) (:INTEGER \"-+0123456789\" :INTEGER * \".\" :DELIMITER * \"/\" :FRACTION * \"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ%\" :UNIT :EOF :EOF :OTHERWISE :ERROR) (:FRACTION :INCLUDE :START) (:DELIMITER :INCLUDE :START) (:ERROR :INCLUDE :START))))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *UNIT-TOKENIZER-TABLE* TOKENIZER-TABLE NULL)");
          Utilities.$UNIT_TOKENIZER_TABLE$ = Cons.parseTokenizerDefinition(Utilities.$UNIT_TOKENIZER_TABLE_DEFINITION$);
          Utilities.resetMeasures();
          Utilities.initializeUnitDefinitions();
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
