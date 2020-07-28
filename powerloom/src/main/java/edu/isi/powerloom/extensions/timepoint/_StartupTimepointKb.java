//  -*- Mode: Java -*-
//
// _StartupTimepointKb.java

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

public class _StartupTimepointKb {
  public static void startupTimepointKb() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/TIMEPOINT-SUPPORT", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT", Stella.getStellaModule("/TIMEPOINT-KB", true), 0)));
          Timepoint.SYM_TIMEPOINT_KB_DAY_OF_WEEK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DAY-OF-WEEK", Stella.getStellaModule("/TIMEPOINT-KB", true), 0)));
          Timepoint.KWD_CLOSED = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CLOSED", null, 2)));
          Timepoint.SYM_STELLA_TRUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TRUE", Stella.getStellaModule("/STELLA", true), 0)));
          Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_OF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-OF", Stella.getStellaModule("/TIMEPOINT-KB", true), 0)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_pTP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?TP", null, 0)));
          Timepoint.KWD_COMPUTED = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("COMPUTED", null, 2)));
          Timepoint.KWD_RELATION_CONSTRAINT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION-CONSTRAINT", null, 2)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_OF_CONSTRAINT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-OF-CONSTRAINT", null, 0)));
          Timepoint.KWD_RELATION_SPECIALIST = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION-SPECIALIST", null, 2)));
          Timepoint.SYM_PL_KERNEL_KB_CONSTRAINT_SPECIALIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CONSTRAINT-SPECIALIST", Stella.getStellaModule("/PL-KERNEL-KB", true), 0)));
          Timepoint.SYM_TIMEPOINT_KB_DURATION_OF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DURATION-OF", Stella.getStellaModule("/TIMEPOINT-KB", true), 0)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_DURATION_OF_CONSTRAINT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DURATION-OF-CONSTRAINT", null, 0)));
          Timepoint.SYM_TIMEPOINT_KB_TIME_ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIME-", Stella.getStellaModule("/TIMEPOINT-KB", true), 0)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_TIME_MINUS_CONSTRAINT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIME-MINUS-CONSTRAINT", null, 0)));
          Timepoint.SYM_TIMEPOINT_KB_TIMEi = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIME+", Stella.getStellaModule("/TIMEPOINT-KB", true), 0)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_TIME_PLUS_CONSTRAINT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIME-PLUS-CONSTRAINT", null, 0)));
          Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_OF$ = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-OF*", Stella.getStellaModule("/TIMEPOINT-KB", true), 0)));
          Timepoint.KWD_RELATION_EVALUATOR = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION-EVALUATOR", null, 2)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_OF$_EVALUATOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-OF*-EVALUATOR", null, 0)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_OF$_SPECIALIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-OF*-SPECIALIST", null, 0)));
          Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_YEAR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-YEAR", Stella.getStellaModule("/TIMEPOINT-KB", true), 0)));
          Timepoint.KWD_RELATION_COMPUTATION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION-COMPUTATION", null, 2)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_YEAR_COMPUTATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-YEAR-COMPUTATION", null, 0)));
          Timepoint.SYM_PL_KERNEL_KB_COMPUTATION_SPECIALIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COMPUTATION-SPECIALIST", Stella.getStellaModule("/PL-KERNEL-KB", true), 0)));
          Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_MONTH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-MONTH", Stella.getStellaModule("/TIMEPOINT-KB", true), 0)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_MONTH_COMPUTATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-MONTH-COMPUTATION", null, 0)));
          Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_DAY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-DAY", Stella.getStellaModule("/TIMEPOINT-KB", true), 0)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_DAY_COMPUTATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-DAY-COMPUTATION", null, 0)));
          Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_DAY_OF_WEEK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-DAY-OF-WEEK", Stella.getStellaModule("/TIMEPOINT-KB", true), 0)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_DAY_OF_WEEK_COMPUTATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-DAY-OF-WEEK-COMPUTATION", null, 0)));
          Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_HOUR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-HOUR", Stella.getStellaModule("/TIMEPOINT-KB", true), 0)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_HOUR_COMPUTATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-HOUR-COMPUTATION", null, 0)));
          Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_MINUTE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-MINUTE", Stella.getStellaModule("/TIMEPOINT-KB", true), 0)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_MINUTE_COMPUTATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-MINUTE-COMPUTATION", null, 0)));
          Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_SECOND = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-SECOND", Stella.getStellaModule("/TIMEPOINT-KB", true), 0)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_SECOND_COMPUTATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-SECOND-COMPUTATION", null, 0)));
          Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_DATE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-DATE", Stella.getStellaModule("/TIMEPOINT-KB", true), 0)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_DATE_COMPUTATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-DATE-COMPUTATION", null, 0)));
          Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_TIME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-TIME", Stella.getStellaModule("/TIMEPOINT-KB", true), 0)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_TIME_COMPUTATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TIMEPOINT-TIME-COMPUTATION", null, 0)));
          Timepoint.SYM_TIMEPOINT_KB_FORMAT_TIMEPOINT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FORMAT-TIMEPOINT", Stella.getStellaModule("/TIMEPOINT-KB", true), 0)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_FORMAT_TIMEPOINT_COMPUTATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FORMAT-TIMEPOINT-COMPUTATION", null, 0)));
          Timepoint.SYM_TIMEPOINT_KB_CURRENT_TIME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CURRENT-TIME", Stella.getStellaModule("/TIMEPOINT-KB", true), 0)));
          Timepoint.KWD_lle = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("<<=", null, 2)));
          Timepoint.SYM_TIMEPOINT_SUPPORT_STARTUP_TIMEPOINT_KB = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-TIMEPOINT-KB", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("STARTUP-TIMEPOINT-KB", "(DEFUN STARTUP-TIMEPOINT-KB () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.extensions.timepoint._StartupTimepointKb", "startupTimepointKb", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Timepoint.SYM_TIMEPOINT_SUPPORT_STARTUP_TIMEPOINT_KB);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, edu.isi.powerloom.extensions.Extensions.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupTimepointKb"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("TIMEPOINT-SUPPORT")))));
          { Object old$Module$001 = Stella.$MODULE$.get();
            Object old$Context$001 = Stella.$CONTEXT$.get();

            try {
              Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("PL-KERNEL-KB", true));
              Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
              Logic.defconcept(Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT))), Stella.NIL));
              Logic.defconcept(Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_KB_DAY_OF_WEEK))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.NIL))), Cons.cons(Timepoint.KWD_CLOSED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_STELLA_TRUE))), Cons.cons(edu.isi.powerloom.extensions.units.Units.KWD_AXIOMS, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((AND (/TIMEPOINT-KB/DAY-OF-WEEK /TIMEPOINT-KB/SUNDAY) (/TIMEPOINT-KB/DAY-OF-WEEK /TIMEPOINT-KB/SATURDAY) (/TIMEPOINT-KB/DAY-OF-WEEK /TIMEPOINT-KB/FRIDAY) (/TIMEPOINT-KB/DAY-OF-WEEK /TIMEPOINT-KB/THURSDAY) (/TIMEPOINT-KB/DAY-OF-WEEK /TIMEPOINT-KB/WEDNESDAY) (/TIMEPOINT-KB/DAY-OF-WEEK /TIMEPOINT-KB/TUESDAY) (/TIMEPOINT-KB/DAY-OF-WEEK /TIMEPOINT-KB/MONDAY)) \"/TIMEPOINT-SUPPORT\")", "/TIMEPOINT-SUPPORT")))), Stella.NIL)))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_OF))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?X STRING)) \"/TIMEPOINT-SUPPORT\")", "/TIMEPOINT-SUPPORT")))), Cons.cons(edu.isi.powerloom.extensions.units.Units.KWD__g, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_SUPPORT_pTP))), Cons.cons(edu.isi.powerloom.extensions.Extensions.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("Connects a STRING representation ?x of a time point to the actual\ninternal representation which is a date/time quantity wrapper representing a time\npoint.  Dates and times can be specified in a large number of different formats\nspecified by the STELLA variable `*date-time-patterns*' (defined in\nstella/date-time.ste) which see.  Examples can also be found in the demo file\ntimepoints.ste.")))), Cons.cons(Timepoint.KWD_COMPUTED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_STELLA_TRUE))), Cons.cons(Timepoint.KWD_RELATION_CONSTRAINT, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_OF_CONSTRAINT))), Cons.cons(Timepoint.KWD_RELATION_SPECIALIST, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_PL_KERNEL_KB_CONSTRAINT_SPECIALIST))), Stella.NIL)))))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_KB_DURATION_OF))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?X STRING)) \"/TIMEPOINT-SUPPORT\")", "/TIMEPOINT-SUPPORT")))), Cons.cons(edu.isi.powerloom.extensions.units.Units.KWD__g, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_SUPPORT_pTP))), Cons.cons(edu.isi.powerloom.extensions.Extensions.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("Connects a STRING representation ?x of a time duration to the\nactual internal representation which is a date/time quantity wrapper representing\na duration or relative date.  The syntax for time duration strings is\n`{plus|minus} N days[; M ms]' where N and M are integer values for days and\nmilliseconds.")))), Cons.cons(Timepoint.KWD_COMPUTED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_STELLA_TRUE))), Cons.cons(Timepoint.KWD_RELATION_CONSTRAINT, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_SUPPORT_DURATION_OF_CONSTRAINT))), Cons.cons(Timepoint.KWD_RELATION_SPECIALIST, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_PL_KERNEL_KB_CONSTRAINT_SPECIALIST))), Stella.NIL)))))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_KB_TIME_))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?T1 ?T2 ?T3) \"/TIMEPOINT-SUPPORT\")", "/TIMEPOINT-SUPPORT")))), Cons.cons(edu.isi.powerloom.extensions.Extensions.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("Subtract ?t2 from ?t1 resulting in ?t3.  If both ?t1 and\n?t2 are time points, ?t3 will be a duration.  If both are durations, ?t3\nwill be a duration.  If ?t1 is a time point and ?t2 a duration, ?t3 will be\na time point.  All other combinations will lead to failure.  Note that this\nis a computed constraint which can generate any argument from the other two,\nwhich means it can also do addition.")))), Cons.cons(Timepoint.KWD_COMPUTED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_STELLA_TRUE))), Cons.cons(Timepoint.KWD_RELATION_CONSTRAINT, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_SUPPORT_TIME_MINUS_CONSTRAINT))), Cons.cons(Timepoint.KWD_RELATION_SPECIALIST, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_PL_KERNEL_KB_CONSTRAINT_SPECIALIST))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_KB_TIMEi))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?T1 ?T2 ?T3) \"/TIMEPOINT-SUPPORT\")", "/TIMEPOINT-SUPPORT")))), Cons.cons(edu.isi.powerloom.extensions.Extensions.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("Add ?t2 to ?t1 resulting in ?t3.  If both ?t1 and ?t2\nare durations, ?t3 will be a duration.  If one of them is a duration and\nthe other is a time point, ?t3 will be a time point.  All other combinations\nwill lead to failure.  Note that this is a computed constraint which can\ngenerate any argument from the other two, which means it can also do subtraction.")))), Cons.cons(Timepoint.KWD_COMPUTED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_STELLA_TRUE))), Cons.cons(Timepoint.KWD_RELATION_CONSTRAINT, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_SUPPORT_TIME_PLUS_CONSTRAINT))), Cons.cons(Timepoint.KWD_RELATION_SPECIALIST, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_PL_KERNEL_KB_CONSTRAINT_SPECIALIST))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_OF$))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?YEAR INTEGER) (?MONTH INTEGER) (?DAY INTEGER) (?HOUR INTEGER) (?MINUTE INTEGER) (?SECOND NUMBER) ?ZONE ?TIMEPOINT) \"/TIMEPOINT-SUPPORT\")", "/TIMEPOINT-SUPPORT")))), Cons.cons(edu.isi.powerloom.extensions.Extensions.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("Maps time components into a timepoint or vice versa.\nVariables ?year, ?month, ?day, ?hour and ?minute are integers.\nVariable ?second is a number, either integer or float with resolution 0.001.\nVariable ?zone is the time zone.  It is represented as a floating point offset\nfrom UTC in hours.  As an input value common strings (used in the United States)\nare also recognized, for example `PST, `EDT', `UTC', `GMT', `local' etc.\nVariable ?timepoint is the internal timepoint representation.  Either all\nof ?year to ?zone must be given to define a ?timepoint, or a ?timepoint\nmust be given to generate all its individual components.  If a ?timepoint\nand a ?zone are given, the individual components are generated relative to\nthat time zone.")))), Cons.cons(Timepoint.KWD_RELATION_EVALUATOR, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_OF$_EVALUATOR))), Cons.cons(Timepoint.KWD_RELATION_SPECIALIST, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_OF$_SPECIALIST))), Stella.NIL)))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_YEAR))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?TP ?ZONE (?YEAR INTEGER)) \"/TIMEPOINT-SUPPORT\")", "/TIMEPOINT-SUPPORT")))), Cons.cons(edu.isi.powerloom.extensions.Extensions.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The year component of ?tp evaluated in time zone ?zone.\nVariable ?zone is represented as a floating point offset from UTC in hours.\nAs a ?zone input value common strings are also recognized (see timepoint-of*).")))), Cons.cons(Timepoint.KWD_COMPUTED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_STELLA_TRUE))), Cons.cons(Timepoint.KWD_RELATION_COMPUTATION, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_YEAR_COMPUTATION))), Cons.cons(Timepoint.KWD_RELATION_SPECIALIST, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_PL_KERNEL_KB_COMPUTATION_SPECIALIST))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_MONTH))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?TP ?ZONE (?MONTH INTEGER)) \"/TIMEPOINT-SUPPORT\")", "/TIMEPOINT-SUPPORT")))), Cons.cons(edu.isi.powerloom.extensions.Extensions.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The month component of ?tp evaluated in time zone ?zone.\nVariable ?zone is represented as a floating point offset from UTC in hours.\nAs a ?zone input value common strings are also recognized (see timepoint-of*).")))), Cons.cons(Timepoint.KWD_COMPUTED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_STELLA_TRUE))), Cons.cons(Timepoint.KWD_RELATION_COMPUTATION, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_MONTH_COMPUTATION))), Cons.cons(Timepoint.KWD_RELATION_SPECIALIST, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_PL_KERNEL_KB_COMPUTATION_SPECIALIST))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_DAY))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?TP ?ZONE (?DAY INTEGER)) \"/TIMEPOINT-SUPPORT\")", "/TIMEPOINT-SUPPORT")))), Cons.cons(edu.isi.powerloom.extensions.Extensions.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The day component of ?tp evaluated in time zone ?zone.\nVariable ?zone is represented as a floating point offset from UTC in hours.\nAs a ?zone input value common strings are also recognized (see timepoint-of*).")))), Cons.cons(Timepoint.KWD_COMPUTED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_STELLA_TRUE))), Cons.cons(Timepoint.KWD_RELATION_COMPUTATION, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_DAY_COMPUTATION))), Cons.cons(Timepoint.KWD_RELATION_SPECIALIST, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_PL_KERNEL_KB_COMPUTATION_SPECIALIST))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_DAY_OF_WEEK))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?TP ?ZONE (?DOW /TIMEPOINT-KB/DAY-OF-WEEK)) \"/TIMEPOINT-SUPPORT\")", "/TIMEPOINT-SUPPORT")))), Cons.cons(edu.isi.powerloom.extensions.Extensions.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The day-of-week component of ?tp evaluated in time zone ?zone.\nVariable ?zone is represented as a floating point offset from UTC in hours.\nAs a ?zone input value common strings are also recognized (see timepoint-of*).")))), Cons.cons(Timepoint.KWD_COMPUTED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_STELLA_TRUE))), Cons.cons(Timepoint.KWD_RELATION_COMPUTATION, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_DAY_OF_WEEK_COMPUTATION))), Cons.cons(Timepoint.KWD_RELATION_SPECIALIST, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_PL_KERNEL_KB_COMPUTATION_SPECIALIST))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_HOUR))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?TP ?ZONE (?HOUR INTEGER)) \"/TIMEPOINT-SUPPORT\")", "/TIMEPOINT-SUPPORT")))), Cons.cons(edu.isi.powerloom.extensions.Extensions.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The hour component of ?tp evaluated in time zone ?zone.\nVariable ?zone is represented as a floating point offset from UTC in hours.\nAs a ?zone input value common strings are also recognized (see timepoint-of*).")))), Cons.cons(Timepoint.KWD_COMPUTED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_STELLA_TRUE))), Cons.cons(Timepoint.KWD_RELATION_COMPUTATION, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_HOUR_COMPUTATION))), Cons.cons(Timepoint.KWD_RELATION_SPECIALIST, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_PL_KERNEL_KB_COMPUTATION_SPECIALIST))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_MINUTE))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?TP ?ZONE (?MINUTE INTEGER)) \"/TIMEPOINT-SUPPORT\")", "/TIMEPOINT-SUPPORT")))), Cons.cons(edu.isi.powerloom.extensions.Extensions.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The minute component of ?tp evaluated in time zone ?zone.\nVariable ?zone is represented as a floating point offset from UTC in hours.\nAs a ?zone input value common strings are also recognized (see timepoint-of*).")))), Cons.cons(Timepoint.KWD_COMPUTED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_STELLA_TRUE))), Cons.cons(Timepoint.KWD_RELATION_COMPUTATION, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_MINUTE_COMPUTATION))), Cons.cons(Timepoint.KWD_RELATION_SPECIALIST, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_PL_KERNEL_KB_COMPUTATION_SPECIALIST))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_SECOND))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?TP ?ZONE (?SECOND NUMBER)) \"/TIMEPOINT-SUPPORT\")", "/TIMEPOINT-SUPPORT")))), Cons.cons(edu.isi.powerloom.extensions.Extensions.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The second component of ?tp evaluated in time zone ?zone.\nVariable ?zone is represented as a floating point offset from UTC in hours.\nAs a ?zone input value common strings are also recognized (see timepoint-of*).")))), Cons.cons(Timepoint.KWD_COMPUTED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_STELLA_TRUE))), Cons.cons(Timepoint.KWD_RELATION_COMPUTATION, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_SECOND_COMPUTATION))), Cons.cons(Timepoint.KWD_RELATION_SPECIALIST, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_PL_KERNEL_KB_COMPUTATION_SPECIALIST))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_DATE))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?TP ?ZONE (?DATE STRING)) \"/TIMEPOINT-SUPPORT\")", "/TIMEPOINT-SUPPORT")))), Cons.cons(edu.isi.powerloom.extensions.Extensions.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The date component of ?tp evaluated in time zone ?zone.\nVariable ?zone is represented as a floating point offset from UTC in hours.\nAs a ?zone input value common strings are also recognized (see timepoint-of*).")))), Cons.cons(Timepoint.KWD_COMPUTED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_STELLA_TRUE))), Cons.cons(Timepoint.KWD_RELATION_COMPUTATION, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_DATE_COMPUTATION))), Cons.cons(Timepoint.KWD_RELATION_SPECIALIST, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_PL_KERNEL_KB_COMPUTATION_SPECIALIST))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_KB_TIMEPOINT_TIME))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?TP ?ZONE (?TIME STRING)) \"/TIMEPOINT-SUPPORT\")", "/TIMEPOINT-SUPPORT")))), Cons.cons(edu.isi.powerloom.extensions.Extensions.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The time component of ?tp evaluated in time zone ?zone.\nVariable ?zone is represented as a floating point offset from UTC in hours.\nAs a ?zone input value common strings are also recognized (see timepoint-of*).")))), Cons.cons(Timepoint.KWD_COMPUTED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_STELLA_TRUE))), Cons.cons(Timepoint.KWD_RELATION_COMPUTATION, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_SUPPORT_TIMEPOINT_TIME_COMPUTATION))), Cons.cons(Timepoint.KWD_RELATION_SPECIALIST, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_PL_KERNEL_KB_COMPUTATION_SPECIALIST))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_KB_FORMAT_TIMEPOINT))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?TP ?ZONE (?CONTROL STRING) (?FORMATTED STRING)) \"/TIMEPOINT-SUPPORT\")", "/TIMEPOINT-SUPPORT")))), Cons.cons(edu.isi.powerloom.extensions.Extensions.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("Format ?tp relative to ?zone according to the format ?control string whose\nsyntax supports most directives of the Unix `date' command (see also the STELLA function\n`format-date').  Variable ?zone is represented as a floating point offset from UTC in hours.\nAs a ?zone input value common strings are also recognized (see timepoint-of*).")))), Cons.cons(Timepoint.KWD_COMPUTED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_STELLA_TRUE))), Cons.cons(Timepoint.KWD_RELATION_COMPUTATION, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_SUPPORT_FORMAT_TIMEPOINT_COMPUTATION))), Cons.cons(Timepoint.KWD_RELATION_SPECIALIST, Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_PL_KERNEL_KB_COMPUTATION_SPECIALIST))), Stella.NIL)))))))))));
              Logic.defrelation(Cons.cons(((Symbol)(Stella_Object.copyConsTree(Timepoint.SYM_TIMEPOINT_KB_CURRENT_TIME))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?TP) \"/TIMEPOINT-SUPPORT\")", "/TIMEPOINT-SUPPORT")))), Cons.cons(edu.isi.powerloom.extensions.Extensions.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("Convenience relation to access the current time ?tp.  Every time this is evaluated\nin a query with an unbound ?tp variable, this will bind ?tp to the newly measured current time.  This\nrelation shields some of the idiosyncrasies of a changing time value in a logic system where the same\nfunction should never evaluate to different values based on the same input arguments.  Do never use this\nfunction in an assertion!  Instead, retrieve the current time via a query and pipe the resulting value\ninto an assertion via `assert-from-query'.  For example:\n    (assert-from-query (retrieve (current-time ?now)) :pattern (kappa (?now) (mytimeof t1 ?now)))")))), Cons.cons(Timepoint.KWD_lle, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((EXISTS ?SPEC (AND (MEMBER-OF ?SPEC (LISTOF \"now\")) (/TIMEPOINT-KB/TIMEPOINT-OF ?SPEC ?TP))) \"/TIMEPOINT-SUPPORT\")", "/TIMEPOINT-SUPPORT")))), Stella.NIL)))))));
              Logic.processDefinitions();

            } finally {
              Stella.$CONTEXT$.set(old$Context$001);
              Stella.$MODULE$.set(old$Module$001);
            }
          }
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
