//  -*- Mode: Java -*-
//
// AtomicGoalCache.java

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

package edu.isi.powerloom.logic;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.stella.*;

/** Cache data structure to store the result of proving an atomic
 * and possibly open <code>proposition</code> relative to a set of variable <code>bindings</code>.
 * @author Stella Java Translator
 */
public class AtomicGoalCache extends StandardObject {
    public Context goalContext;
    public int timestamp;
    public TruthValue truthValue;
    public boolean reversePolarityP;
    public Proposition proposition;
    public Cons bindings;
    public Justification justification;
    public double positiveScore;
    public double negativeScore;
    public AtomicGoalCache previous;
    public AtomicGoalCache next;

  public static AtomicGoalCache newAtomicGoalCache() {
    { AtomicGoalCache self = null;

      self = new AtomicGoalCache();
      self.next = null;
      self.previous = null;
      self.negativeScore = Stella.NULL_FLOAT;
      self.positiveScore = Stella.NULL_FLOAT;
      self.justification = null;
      self.bindings = null;
      self.proposition = null;
      self.reversePolarityP = false;
      self.truthValue = null;
      self.timestamp = Stella.NULL_INTEGER;
      self.goalContext = null;
      return (self);
    }
  }

  public static Keyword finishCachedGoalProcessing(AtomicGoalCache cachedgoal, ControlFrame frame, Keyword successorfailure, boolean continuingP) {
    KeyValueList.setDynamicSlotValue(((QueryIterator)(Logic.$QUERYITERATOR$.get())).dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, FloatWrapper.wrapFloat(cachedgoal.positiveScore), Stella.NULL_FLOAT_WRAPPER);
    frame.truthValue = cachedgoal.truthValue;
    if (frame.partialMatchFrame != null) {
      frame.partialMatchFrame.setFramePartialTruth(cachedgoal.truthValue, cachedgoal.positiveScore, Stella.NULL_FLOAT, true);
    }
    if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue() &&
        (cachedgoal.justification != null)) {
      KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, cachedgoal.justification.copy(), null);
    }
    if (Stella_Object.traceKeywordP(Logic.KWD_GOAL_CACHES) &&
        true) {
      { Object old$Printinframe$000 = Logic.$PRINTINFRAME$.get();
        Object old$PrettyprintlogicalformsP$000 = Logic.$PRETTYPRINTLOGICALFORMSp$.get();

        try {
          Native.setSpecial(Logic.$PRINTINFRAME$, frame);
          Native.setBooleanSpecial(Logic.$PRETTYPRINTLOGICALFORMSp$, false);
          if (successorfailure == Logic.KWD_SUCCESS) {
            Stella.STANDARD_OUTPUT.nativeStream.print("USED CACHED SUCCESS+: ");
          }
          else if (successorfailure == Logic.KWD_FAILURE) {
            Stella.STANDARD_OUTPUT.nativeStream.print("USED CACHED FAILURE-: ");
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + successorfailure + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
          if ((frame.truthValue == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
              (frame.truthValue == Logic.DEFAULT_FALSE_TRUTH_VALUE)) {
            Stella.STANDARD_OUTPUT.nativeStream.print("dflt");
          }
          Stella.STANDARD_OUTPUT.nativeStream.println(((cachedgoal.reversePolarityP ? "~" : " ")) + frame.proposition);

        } finally {
          Logic.$PRETTYPRINTLOGICALFORMSp$.set(old$PrettyprintlogicalformsP$000);
          Logic.$PRINTINFRAME$.set(old$Printinframe$000);
        }
      }
    }
    if (successorfailure == Logic.KWD_SUCCESS) {
      Logic.$SUCCEEDED_GOAL_CUTOFFS$ = Logic.$SUCCEEDED_GOAL_CUTOFFS$ + 1;
      return ((continuingP ? Logic.KWD_CONTINUING_SUCCESS : Logic.KWD_FINAL_SUCCESS));
    }
    else if (successorfailure == Logic.KWD_FAILURE) {
      Logic.$FAILED_GOAL_CUTOFFS$ = Logic.$FAILED_GOAL_CUTOFFS$ + 1;
      if (frame.down != null) {
        ControlFrame.popFramesUpTo(frame.down);
      }
      return (Logic.KWD_TERMINAL_FAILURE);
    }
    else {
      { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

        stream001.nativeStream.print("`" + successorfailure + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static boolean cacheInstantiatesGoalP(AtomicGoalCache cache, ControlFrame goal, boolean successP) {
    return (AtomicGoalCache.cacheMatchesGoalP(cache, goal, successP, Logic.KWD_CACHE_INSTANTIATES_GOAL));
  }

  public static boolean cacheMatchesGoalP(AtomicGoalCache cache, ControlFrame goal, boolean successP, Keyword mode) {
    successP = successP;
    if ((Logic.getNowTimestamp() == cache.timestamp) &&
        ((((Context)(Stella.$CONTEXT$.get())) == cache.goalContext) &&
         (goal.reversePolarityP == cache.reversePolarityP))) {
      { Proposition goalproposition = goal.proposition;
        Vector goalarguments = goalproposition.arguments;
        Proposition cacheproposition = cache.proposition;
        Vector cachearguments = cacheproposition.arguments;
        int nofgoalarguments = goalarguments.length();
        edu.isi.stella.Stella_Object[] uvector1 = ((Vector)(Logic.$UNIFICATION_VECTOR_1$.get())).theArray;
        edu.isi.stella.Stella_Object[] uvector2 = ((Vector)(Logic.$UNIFICATION_VECTOR_2$.get())).theArray;

        if ((goalproposition.operator == cacheproposition.operator) &&
            (nofgoalarguments == cachearguments.length())) {
          if (nofgoalarguments > ((Vector)(Logic.$UNIFICATION_VECTOR_1$.get())).arraySize) {
            Vector.resizeVector(((Vector)(Logic.$UNIFICATION_VECTOR_1$.get())), 2 * nofgoalarguments);
            Vector.resizeVector(((Vector)(Logic.$UNIFICATION_VECTOR_2$.get())), 2 * nofgoalarguments);
            uvector1 = ((Vector)(Logic.$UNIFICATION_VECTOR_1$.get())).theArray;
            uvector2 = ((Vector)(Logic.$UNIFICATION_VECTOR_2$.get())).theArray;
          }
          { Stella_Object goalarg = null;
            Vector vector000 = goalarguments;
            int index000 = 0;
            int length000 = vector000.length();
            Stella_Object goalbinding = null;
            Cons iter000 = goal.goalBindings;
            Stella_Object cachebinding = null;
            Cons iter001 = cache.bindings;
            int i = Stella.NULL_INTEGER;
            int iter002 = 0;

            for (;(index000 < length000) &&
                      ((!(iter000 == Stella.NIL)) &&
                       (!(iter001 == Stella.NIL))); 
                  index000 = index000 + 1,
                  iter000 = iter000.rest,
                  iter001 = iter001.rest,
                  iter002 = iter002 + 1) {
              goalarg = (vector000.theArray)[index000];
              goalbinding = iter000.value;
              cachebinding = iter001.value;
              i = iter002;
              if (goalbinding == null) {
                goalbinding = (((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord.variableBindings.theArray)[(((PatternVariable)(goalarg)).boundToOffset)];
              }
              uvector1[i] = goalbinding;
              uvector2[i] = cachebinding;
            }
          }
          { Vector subarguments = goalarguments;
            edu.isi.stella.Stella_Object[] subbindings = uvector1;
            Stella_Object subargbinding = null;
            Vector superarguments = cachearguments;
            edu.isi.stella.Stella_Object[] superbindings = uvector2;
            Stella_Object unifiedarg = null;

            if (mode == Logic.KWD_GOAL_INSTANTIATES_CACHE) {
            }
            else if (mode == Logic.KWD_CACHE_INSTANTIATES_GOAL) {
              subarguments = cachearguments;
              subbindings = uvector2;
              superarguments = goalarguments;
              superbindings = uvector1;
            }
            else {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("`" + mode + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
            { Stella_Object subarg = null;
              Vector vector001 = subarguments;
              int index001 = 0;
              int length001 = vector001.length();
              Stella_Object superarg = null;
              Vector vector002 = superarguments;
              int index002 = 0;
              int length002 = vector002.length();
              int i = Stella.NULL_INTEGER;
              int iter003 = 0;

              loop001 : for (;(index001 < length001) &&
                        (index002 < length002); 
                    index001 = index001 + 1,
                    index002 = index002 + 1,
                    iter003 = iter003 + 1) {
                subarg = (vector001.theArray)[index001];
                superarg = (vector002.theArray)[index002];
                i = iter003;
                subargbinding = subbindings[i];
                unifiedarg = superbindings[i];
                if (unifiedarg != null) {
                  if (!Stella_Object.eqlP(subargbinding, unifiedarg)) {
                    return (false);
                  }
                  else {
                    continue loop001;
                  }
                }
                if (subargbinding == null) {
                  subargbinding = subarg;
                }
                { Stella_Object suparg = null;
                  Vector vector003 = superarguments;
                  int index003 = 0;
                  int length003 = vector003.length();
                  int i000 = Stella.NULL_INTEGER;
                  int iter004 = 0;

                  for (;index003 < length003; index003 = index003 + 1, iter004 = iter004 + 1) {
                    suparg = (vector003.theArray)[index003];
                    i000 = iter004;
                    if (Stella_Object.eqlP(suparg, superarg)) {
                      superbindings[i000] = subargbinding;
                    }
                  }
                }
              }
            }
            return (true);
          }
        }
      }
    }
    return (false);
  }

  public static void printAtomicGoalCache(AtomicGoalCache self, edu.isi.stella.javalib.NativeOutputStream stream) {
    if (self.proposition == null) {
      stream.print("|GC|[NULL]");
      return;
    }
    stream.print("|GC|[" + ((self.reversePolarityP ? "~" : "")) + "(" + Proposition.stringifiedKifOperator(self.proposition));
    { Object old$Printmode$000 = Logic.$PRINTMODE$.get();
      Object old$Printlogicalformstream$000 = Logic.$PRINTLOGICALFORMSTREAM$.get();

      try {
        Native.setSpecial(Logic.$PRINTMODE$, Logic.KWD_REALISTIC);
        Native.setSpecial(Logic.$PRINTLOGICALFORMSTREAM$, Logic.wrapNativeOutputStream(stream));
        { Stella_Object arg = null;
          Vector vector000 = self.proposition.arguments;
          int index000 = 0;
          int length000 = vector000.length();
          Stella_Object argvalue = null;
          Cons iter000 = self.bindings;

          for (;(index000 < length000) &&
                    (!(iter000 == Stella.NIL)); index000 = index000 + 1, iter000 = iter000.rest) {
            arg = (vector000.theArray)[index000];
            argvalue = iter000.value;
            stream.print(" ");
            Logic.printAsKifInternal(((argvalue == null) ? arg : argvalue));
          }
        }

      } finally {
        Logic.$PRINTLOGICALFORMSTREAM$.set(old$Printlogicalformstream$000);
        Logic.$PRINTMODE$.set(old$Printmode$000);
      }
    }
    stream.print(") time: " + self.timestamp + " ctxt: " + self.goalContext.contextNumber + "]");
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { AtomicGoalCache self = this;

      AtomicGoalCache.printAtomicGoalCache(self, stream);
    }
  }

  public static Stella_Object accessAtomicGoalCacheSlotValue(AtomicGoalCache self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_GOAL_CONTEXT) {
      if (setvalueP) {
        self.goalContext = ((Context)(value));
      }
      else {
        value = self.goalContext;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_TIMESTAMP) {
      if (setvalueP) {
        self.timestamp = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.timestamp);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_TRUTH_VALUE) {
      if (setvalueP) {
        self.truthValue = ((TruthValue)(value));
      }
      else {
        value = self.truthValue;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_REVERSE_POLARITYp) {
      if (setvalueP) {
        self.reversePolarityP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.reversePolarityP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_PROPOSITION) {
      if (setvalueP) {
        self.proposition = ((Proposition)(value));
      }
      else {
        value = self.proposition;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_BINDINGS) {
      if (setvalueP) {
        self.bindings = ((Cons)(value));
      }
      else {
        value = self.bindings;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_JUSTIFICATION) {
      if (setvalueP) {
        self.justification = ((Justification)(value));
      }
      else {
        value = self.justification;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_POSITIVE_SCORE) {
      if (setvalueP) {
        self.positiveScore = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.positiveScore);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_NEGATIVE_SCORE) {
      if (setvalueP) {
        self.negativeScore = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.negativeScore);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_PREVIOUS) {
      if (setvalueP) {
        self.previous = ((AtomicGoalCache)(value));
      }
      else {
        value = self.previous;
      }
    }
    else if (slotname == Logic.SYM_STELLA_NEXT) {
      if (setvalueP) {
        self.next = ((AtomicGoalCache)(value));
      }
      else {
        value = self.next;
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
    { AtomicGoalCache self = this;

      return (Logic.SGT_LOGIC_ATOMIC_GOAL_CACHE);
    }
  }

}

