//  -*- Mode: Java -*-
//
// _StartupArithmetic.java

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

package edu.isi.powerloom.pl_kernel_kb;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.powerloom.logic.*;
import edu.isi.stella.*;

public class _StartupArithmetic {
  static void helpStartupArithmetic1() {
    {
      PlKernelKb.SGT_PL_KERNEL_KB_INTEGER_INTERVAL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INTEGER-INTERVAL", null, 1)));
      PlKernelKb.SYM_PL_KERNEL_KB_INTERVAL_LOWER_BOUND = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INTERVAL-LOWER-BOUND", null, 0)));
      PlKernelKb.SYM_PL_KERNEL_KB_INTERVAL_UPPER_BOUND = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INTERVAL-UPPER-BOUND", null, 0)));
      PlKernelKb.SYM_LOGIC_INTERVAL_MEMBER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INTERVAL-MEMBER", Stella.getStellaModule("/LOGIC", true), 0)));
      PlKernelKb.SYM_STELLA_LOWER_BOUND = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LOWER-BOUND", Stella.getStellaModule("/STELLA", true), 0)));
      PlKernelKb.SYM_STELLA_UPPER_BOUND = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UPPER-BOUND", Stella.getStellaModule("/STELLA", true), 0)));
      PlKernelKb.SYM_LOGIC_STRICT_LOWER_BOUNDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STRICT-LOWER-BOUND?", Stella.getStellaModule("/LOGIC", true), 0)));
      PlKernelKb.SYM_LOGIC_STRICT_UPPER_BOUNDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STRICT-UPPER-BOUND?", Stella.getStellaModule("/LOGIC", true), 0)));
      PlKernelKb.SGT_PL_KERNEL_KB_INTERVAL_CACHE_OF = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INTERVAL-CACHE-OF", null, 1)));
      PlKernelKb.SGT_PL_KERNEL_KB_g = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule(">", null, 1)));
      PlKernelKb.SGT_PL_KERNEL_KB_l = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("<", null, 1)));
      PlKernelKb.SGT_PL_KERNEL_KB_el = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("=<", null, 1)));
      PlKernelKb.KWD_LOWER_BOUND = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LOWER-BOUND", null, 2)));
      PlKernelKb.KWD_UPPER_BOUND = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("UPPER-BOUND", null, 2)));
      PlKernelKb.SGT_PL_KERNEL_KB_e = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("=", null, 1)));
      PlKernelKb.SYM_PL_KERNEL_KB_STARTUP_ARITHMETIC = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-ARITHMETIC", null, 0)));
    }
  }

  static void helpStartupArithmetic2() {
    {
      Stella.defineFunctionObject("ARITHMETIC-EQUAL-TEST", "(DEFUN (ARITHMETIC-EQUAL-TEST BOOLEAN) ((X NUMBER-WRAPPER) (Y NUMBER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "arithmeticEqualTest", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("ARITHMETIC-LESS-TEST", "(DEFUN (ARITHMETIC-LESS-TEST BOOLEAN) ((X NUMBER-WRAPPER) (Y NUMBER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "arithmeticLessTest", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("ARITHMETIC-GREATER-TEST", "(DEFUN (ARITHMETIC-GREATER-TEST BOOLEAN) ((X NUMBER-WRAPPER) (Y NUMBER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "arithmeticGreaterTest", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("PLUS-COMPUTATION", "(DEFUN (PLUS-COMPUTATION NUMBER-WRAPPER) ((X NUMBER-WRAPPER) (Y NUMBER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "plusComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("MINUS-COMPUTATION", "(DEFUN (MINUS-COMPUTATION NUMBER-WRAPPER) ((X NUMBER-WRAPPER) (Y NUMBER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "minusComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("TIMES-COMPUTATION", "(DEFUN (TIMES-COMPUTATION NUMBER-WRAPPER) ((X NUMBER-WRAPPER) (Y NUMBER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "timesComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("DIVIDE-COMPUTATION", "(DEFUN (DIVIDE-COMPUTATION NUMBER-WRAPPER) ((X NUMBER-WRAPPER) (Y NUMBER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "divideComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("SQRT-COMPUTATION", "(DEFUN (SQRT-COMPUTATION NUMBER-WRAPPER) ((X NUMBER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "sqrtComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("NEGATE-COMPUTATION", "(DEFUN (NEGATE-COMPUTATION NUMBER-WRAPPER) ((X NUMBER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "negateComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("ABS-COMPUTATION", "(DEFUN (ABS-COMPUTATION NUMBER-WRAPPER) ((X NUMBER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "absComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("FLOOR-COMPUTATION", "(DEFUN (FLOOR-COMPUTATION INTEGER-WRAPPER) ((X NUMBER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "floorComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("CEILING-COMPUTATION", "(DEFUN (CEILING-COMPUTATION INTEGER-WRAPPER) ((X NUMBER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "ceilingComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("PLUS-CONSTRAINT", "(DEFUN (PLUS-CONSTRAINT OBJECT) ((MISSING-ARGUMENT INTEGER-WRAPPER) (X1 NUMBER-WRAPPER) (X2 NUMBER-WRAPPER) (X3 NUMBER-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "plusConstraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("MINUS-CONSTRAINT", "(DEFUN (MINUS-CONSTRAINT OBJECT) ((MISSING-ARGUMENT INTEGER-WRAPPER) (X1 NUMBER-WRAPPER) (X2 NUMBER-WRAPPER) (X3 NUMBER-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "minusConstraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("TIMES-CONSTRAINT", "(DEFUN (TIMES-CONSTRAINT OBJECT) ((MISSING-ARGUMENT INTEGER-WRAPPER) (X1 NUMBER-WRAPPER) (X2 NUMBER-WRAPPER) (X3 NUMBER-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "timesConstraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("DIVIDE-CONSTRAINT", "(DEFUN (DIVIDE-CONSTRAINT OBJECT) ((MISSING-ARGUMENT INTEGER-WRAPPER) (X1 NUMBER-WRAPPER) (X2 NUMBER-WRAPPER) (X3 NUMBER-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "divideConstraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("NEGATE-CONSTRAINT", "(DEFUN (NEGATE-CONSTRAINT OBJECT) ((MISSING-ARGUMENT INTEGER-WRAPPER) (X1 NUMBER-WRAPPER) (X2 NUMBER-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "negateConstraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("SQRT-CONSTRAINT", "(DEFUN (SQRT-CONSTRAINT OBJECT) ((MISSING-ARGUMENT INTEGER-WRAPPER) (X1 NUMBER-WRAPPER) (X2 NUMBER-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "sqrtConstraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("LOG-COMPUTATION", "(DEFUN (LOG-COMPUTATION FLOAT-WRAPPER) ((X NUMBER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "logComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("LOG10-COMPUTATION", "(DEFUN (LOG10-COMPUTATION FLOAT-WRAPPER) ((X NUMBER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "log10Computation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("EXP-COMPUTATION", "(DEFUN (EXP-COMPUTATION FLOAT-WRAPPER) ((X NUMBER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "expComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("EXPT-COMPUTATION", "(DEFUN (EXPT-COMPUTATION FLOAT-WRAPPER) ((X NUMBER-WRAPPER) (N NUMBER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "exptComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("LOG-CONSTRAINT", "(DEFUN (LOG-CONSTRAINT OBJECT) ((MISSING-ARGUMENT INTEGER-WRAPPER) (X NUMBER-WRAPPER) (LOG NUMBER-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "logConstraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("LOG10-CONSTRAINT", "(DEFUN (LOG10-CONSTRAINT OBJECT) ((MISSING-ARGUMENT INTEGER-WRAPPER) (X NUMBER-WRAPPER) (LOG NUMBER-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "log10Constraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("EXP-CONSTRAINT", "(DEFUN (EXP-CONSTRAINT OBJECT) ((MISSING-ARGUMENT INTEGER-WRAPPER) (X NUMBER-WRAPPER) (Y NUMBER-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "expConstraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper"), Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("PRINT-INTERVAL", "(DEFUN PRINT-INTERVAL ((STREAM NATIVE-OUTPUT-STREAM) (LOWER OBJECT) (STRICT-LOWER? BOOLEAN) (UPPER OBJECT) (STRICT-UPPER? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "printInterval", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE, Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CREATE-INTERVAL-CACHE", "(DEFUN (CREATE-INTERVAL-CACHE INTERVAL-CACHE) ((INTERVALMEMBER LOGIC-OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "createIntervalCache", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("GET-INTERVAL-CACHE", "(DEFUN (GET-INTERVAL-CACHE INTERVAL-CACHE) ((SELF LOGIC-OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "getIntervalCache", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("SIGNAL-INTERVAL-CLASH", "(DEFUN SIGNAL-INTERVAL-CLASH ((INTERVAL INTERVAL-CACHE)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.IntervalCache", "signalIntervalClash", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.pl_kernel_kb.IntervalCache")}), null);
      Stella.defineFunctionObject("EVALUATE-ADJACENT-INEQUALITIES", "(DEFUN EVALUATE-ADJACENT-INEQUALITIES ((SELF LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "evaluateAdjacentInequalities", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineMethodObject("(DEFMETHOD (INTEGER-VALUED-MEMBER? BOOLEAN) ((INTERVAL INTERVAL-CACHE)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.IntervalCache", "integerValuedMemberP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (INTEGER-LOWER-BOUND INTEGER-WRAPPER) ((INTERVAL INTERVAL-CACHE)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.IntervalCache", "integerLowerBound", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (INTEGER-UPPER-BOUND INTEGER-WRAPPER) ((INTERVAL INTERVAL-CACHE)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.IntervalCache", "integerUpperBound", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD EVALUATE-TIGHTER-INTEGER-INTERVAL ((INTERVAL INTERVAL-CACHE)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.IntervalCache", "evaluateTighterIntegerInterval", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD EVALUATE-TIGHTER-INTERVAL ((INTERVAL INTERVAL-CACHE)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.IntervalCache", "evaluateTighterInterval", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD PROPAGATE-INEQUALITY-TO-INTERVAL-CACHE ((SELF INTERVAL-CACHE) (VALUE OBJECT) (OPERATOR SURROGATE)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.IntervalCache", "propagateInequalityToIntervalCache", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Surrogate")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("INVERSE-INEQUALITY-OPERATOR", "(DEFUN (INVERSE-INEQUALITY-OPERATOR SURROGATE) ((OPERATOR SURROGATE)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "inverseInequalityOperator", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("UNIFY-INTERVAL-CACHES", "(DEFUN UNIFY-INTERVAL-CACHES ((CACHE1 INTERVAL-CACHE) (CACHE2 INTERVAL-CACHE) (OPERATOR SURROGATE)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.IntervalCache", "unifyIntervalCaches", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.pl_kernel_kb.IntervalCache"), Native.find_java_class("edu.isi.powerloom.pl_kernel_kb.IntervalCache"), Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("ACCESS-INTERVAL-BOUNDS", "(DEFUN (ACCESS-INTERVAL-BOUNDS OBJECT BOOLEAN) ((X OBJECT) (LOWERORUPPER KEYWORD)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "accessIntervalBounds", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("ACCESS-INTERVAL-CACHE-BOUNDS", "(DEFUN (ACCESS-INTERVAL-CACHE-BOUNDS OBJECT BOOLEAN) ((INTERVALCACHE INTERVAL-CACHE) (LOWERORUPPER KEYWORD)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.IntervalCache", "accessIntervalCacheBounds", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.pl_kernel_kb.IntervalCache"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("COMPARE-INTERVAL-BOUNDS?", "(DEFUN (COMPARE-INTERVAL-BOUNDS? BOOLEAN) ((RELATION SURROGATE) (X OBJECT) (Y OBJECT)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "compareIntervalBoundsP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("NULL-NUMBER?", "(DEFUN (NULL-NUMBER? BOOLEAN) ((SELF NUMBER-WRAPPER)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "nullNumberP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.NumberWrapper")}), null);
      Stella.defineFunctionObject("NULL-LITERAL-WRAPPER?", "(DEFUN (NULL-LITERAL-WRAPPER? BOOLEAN) ((SELF OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "nullLiteralWrapperP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SATISFIES-INTERVAL-BOUNDS?", "(DEFUN (SATISFIES-INTERVAL-BOUNDS? BOOLEAN) ((OBJECT OBJECT) (VALUE OBJECT)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "satisfiesIntervalBoundsP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("LESS-SPECIALIST-HELPER", "(DEFUN (LESS-SPECIALIST-HELPER KEYWORD) ((FRAME CONTROL-FRAME) (RELATION SURROGATE) (XARG OBJECT) (YARG OBJECT)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "lessSpecialistHelper", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("INEQUALITY-SPECIALIST", "(DEFUN (INEQUALITY-SPECIALIST KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "inequalitySpecialist", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("INEQUALITY-EVALUATOR", "(DEFUN INEQUALITY-EVALUATOR ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "inequalityEvaluator", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("STRING-CONCATENATE-COMPUTATION", "(DEFUN (STRING-CONCATENATE-COMPUTATION STRING-WRAPPER) ((X OBJECT) (YARGS CONS)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "stringConcatenateComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("SUBSEQUENCE-SPECIALIST", "(DEFUN (SUBSEQUENCE-SPECIALIST KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "subsequenceSpecialist", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("NORMALIZE-STRING-COMPUTATION-ARGS", "(DEFUN (NORMALIZE-STRING-COMPUTATION-ARGS STRING INTEGER INTEGER) ((X OBJECT) (START OBJECT) (END OBJECT) (COERCE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "normalizeStringComputationArgs", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE, Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("STRING-MATCH-COMPUTATION-HELPER", "(DEFUN (STRING-MATCH-COMPUTATION-HELPER INTEGER-WRAPPER) ((PATTERN OBJECT) (X OBJECT) (START OBJECT) (END OBJECT) (IGNORE-CASE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "stringMatchComputationHelper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("STRING-MATCH-COMPUTATION", "(DEFUN (STRING-MATCH-COMPUTATION INTEGER-WRAPPER) ((PATTERN OBJECT) (X OBJECT) (START OBJECT) (END OBJECT)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "stringMatchComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("STRING-MATCH-IGNORE-CASE-COMPUTATION", "(DEFUN (STRING-MATCH-IGNORE-CASE-COMPUTATION INTEGER-WRAPPER) ((PATTERN OBJECT) (X OBJECT) (START OBJECT) (END OBJECT)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "stringMatchIgnoreCaseComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("STRING-UPCASE-COMPUTATION", "(DEFUN (STRING-UPCASE-COMPUTATION STRING-WRAPPER) ((X OBJECT) (START OBJECT) (END OBJECT)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "stringUpcaseComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("STRING-DOWNCASE-COMPUTATION", "(DEFUN (STRING-DOWNCASE-COMPUTATION STRING-WRAPPER) ((X OBJECT) (START OBJECT) (END OBJECT)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "stringDowncaseComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("STRING-CAPITALIZE-COMPUTATION", "(DEFUN (STRING-CAPITALIZE-COMPUTATION STRING-WRAPPER) ((X OBJECT) (START OBJECT) (END OBJECT)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "stringCapitalizeComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("STRING-REPLACE-COMPUTATION", "(DEFUN (STRING-REPLACE-COMPUTATION STRING-WRAPPER) ((X OBJECT) (FROM OBJECT) (TO OBJECT) (START OBJECT) (END OBJECT)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "stringReplaceComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("STRING-COMPARE-COMPUTATION-HELPER", "(DEFUN (STRING-COMPARE-COMPUTATION-HELPER INTEGER-WRAPPER) ((O1 OBJECT) (O2 OBJECT) (START1 OBJECT) (END1 OBJECT) (START2 OBJECT) (END2 OBJECT) (IGNORECASE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "stringCompareComputationHelper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("STRING-COMPARE-COMPUTATION", "(DEFUN (STRING-COMPARE-COMPUTATION INTEGER-WRAPPER) ((O1 OBJECT) (O2 OBJECT) (START1 OBJECT) (END1 OBJECT) (START2 OBJECT) (END2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "stringCompareComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("STRING-COMPARE-IGNORE-CASE-COMPUTATION", "(DEFUN (STRING-COMPARE-IGNORE-CASE-COMPUTATION INTEGER-WRAPPER) ((O1 OBJECT) (O2 OBJECT) (START1 OBJECT) (END1 OBJECT) (START2 OBJECT) (END2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "stringCompareIgnoreCaseComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
    }
  }

  public static void startupArithmetic() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/PL-KERNEL-KB", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupArithmetic.helpStartupArithmetic1();
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("INTEGER-INTERVAL", "(DEFCLASS INTEGER-INTERVAL (THING) :DOCUMENTATION \"An interval of integers\" :SLOTS ((INTERVAL-LOWER-BOUND :TYPE INTEGER) (INTERVAL-UPPER-BOUND :TYPE INTEGER)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.IntegerInterval", "newIntegerInterval", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.IntegerInterval", "accessIntegerIntervalSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.pl_kernel_kb.IntegerInterval"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("INTERVAL-CACHE", "(DEFCLASS INTERVAL-CACHE (THING) :PUBLIC? TRUE :PUBLIC-SLOTS ((HOME-CONTEXT :TYPE CONTEXT) (INTERVAL-MEMBER :TYPE LOGIC-OBJECT) (LOWER-BOUND :TYPE OBJECT) (UPPER-BOUND :TYPE OBJECT) (STRICT-LOWER-BOUND? :TYPE BOOLEAN) (STRICT-UPPER-BOUND? :TYPE BOOLEAN)) :PRINT-FORM (PROGN (PRINT-STREAM STREAM \"|cache-of: \" (INTERVAL-MEMBER SELF) \" \") (PRINT-INTERVAL STREAM (LOWER-BOUND SELF) (STRICT-LOWER-BOUND? SELF) (UPPER-BOUND SELF) (STRICT-UPPER-BOUND? SELF)) (PRINT-STREAM STREAM \"|\")))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.IntervalCache", "newIntervalCache", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.IntervalCache", "accessIntervalCacheSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.pl_kernel_kb.IntervalCache"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupArithmetic.helpStartupArithmetic2();
          Stella.defineFunctionObject("STRING-TO-NUMBER-COMPUTATION", "(DEFUN (STRING-TO-NUMBER-COMPUTATION NUMBER-WRAPPER) ((X OBJECT) (START OBJECT) (END OBJECT)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "stringToNumberComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("LENGTH-COMPUTATION", "(DEFUN (LENGTH-COMPUTATION INTEGER-WRAPPER) ((X OBJECT)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.PlKernelKb", "lengthComputation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("STARTUP-ARITHMETIC", "(DEFUN STARTUP-ARITHMETIC () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb._StartupArithmetic", "startupArithmetic", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(PlKernelKb.SYM_PL_KERNEL_KB_STARTUP_ARITHMETIC);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupArithmetic"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("PL-KERNEL")))));
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
