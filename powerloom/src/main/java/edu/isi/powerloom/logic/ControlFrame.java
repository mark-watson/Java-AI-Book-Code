//  -*- Mode: Java -*-
//
// ControlFrame.java

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

public class ControlFrame extends StandardObject {
    public Keyword state;
    public Proposition proposition;
    public TruthValue truthValue;
    public boolean reversePolarityP;
    /** Clock ticks at last :DOWN move.
     */
    public int startingClockTicks;
    /** Total clock ticks allotted to prove this goal.
     */
    public int allottedClockTicks;
    public ControlFrame up;
    public ControlFrame down;
    public ControlFrame result;
    public int argumentCursor;
    public PatternRecord patternRecord;
    public PatternRecord inheritedPatternRecord;
    public int choicePointUnbindingOffset;
    public Keyword currentStrategy;
    public Cons nextStrategies;
    public PartialMatchFrame partialMatchFrame;
    public List justifications;
    public Cons goalBindings;
    public boolean cachedGoalResultP;
    public boolean dontCacheGoalFailureP;
    public KeyValueList dynamicSlots;

  public static ControlFrame newControlFrame() {
    { ControlFrame self = null;

      self = new ControlFrame();
      self.dynamicSlots = KeyValueList.newKeyValueList();
      self.dontCacheGoalFailureP = false;
      self.cachedGoalResultP = false;
      self.goalBindings = null;
      self.justifications = List.newList();
      self.partialMatchFrame = null;
      self.nextStrategies = Stella.NIL;
      self.currentStrategy = null;
      self.choicePointUnbindingOffset = Stella.NULL_INTEGER;
      self.inheritedPatternRecord = null;
      self.patternRecord = null;
      self.argumentCursor = 0;
      self.result = null;
      self.down = null;
      self.up = null;
      self.allottedClockTicks = Stella.NULL_INTEGER;
      self.startingClockTicks = Stella.NULL_INTEGER;
      self.reversePolarityP = false;
      self.truthValue = null;
      self.proposition = null;
      self.state = null;
      return (self);
    }
  }

  public static Keyword computeVarianceOrStandardDeviation(ControlFrame frame, Keyword lastmove, boolean standardDeviationP) {
    { Proposition proposition = frame.proposition;
      Stella_Object listarg = (proposition.arguments.theArray)[0];
      Stella_Object listskolem = Logic.argumentBoundTo(listarg);
      Stella_Object resultargg = (proposition.arguments.theArray)[1];
      double sum = 0.0;
      double sum2 = 0.0;
      double x = 0.0;
      int numbercount = 0;

      lastmove = lastmove;
      if ((listskolem != null) &&
          (!Logic.logicalCollectionP(listskolem))) {
        {
          Stella.STANDARD_OUTPUT.nativeStream.println();
          Stella.STANDARD_OUTPUT.nativeStream.println("Non list appears in second argument to 'VARIANCE or STANDARD-DEVIATION'");
          Stella.STANDARD_OUTPUT.nativeStream.println();
        }
;
        return (Logic.KWD_TERMINAL_FAILURE);
      }
      { List listvalue = Logic.assertedCollectionMembers(listskolem, true);

        if (listvalue.emptyP()) {
          return (Logic.KWD_TERMINAL_FAILURE);
        }
        { Stella_Object v = null;
          Cons iter000 = listvalue.theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            v = iter000.value;
            { Surrogate testValue000 = Stella_Object.safePrimaryType(v);

              if (Surrogate.subtypeOfIntegerP(testValue000)) {
                { IntegerWrapper v000 = ((IntegerWrapper)(v));

                  x = ((double)(v000.wrapperValue));
                }
              }
              else if (Surrogate.subtypeOfFloatP(testValue000)) {
                { FloatWrapper v000 = ((FloatWrapper)(v));

                  x = v000.wrapperValue;
                }
              }
              else {
                ControlFrame.setFrameTruthValue(frame, Logic.UNKNOWN_TRUTH_VALUE);
                return (Logic.KWD_FAILURE);
              }
            }
            sum = sum + x;
            sum2 = sum2 + (x * x);
            numbercount = numbercount + 1;
          }
        }
        switch (numbercount) {
          case 0: 
            return (Logic.KWD_TERMINAL_FAILURE);
          case 1: 
            return (Logic.selectTestResult(Logic.bindArgumentToValueP(resultargg, FloatWrapper.wrapFloat(0.0), true), true, frame));
          default:
            x = (sum2 - ((sum * sum) / numbercount)) / (numbercount - 1);
            if (standardDeviationP) {
              x = Math.sqrt(x);
            }
            return (Logic.selectTestResult(Logic.bindArgumentToValueP(resultargg, FloatWrapper.wrapFloat(x), true), true, frame));
        }
      }
    }
  }

  public static boolean collectDescriptionExtensionFrameP(ControlFrame frame) {
    return ((frame.patternRecord != null) &&
        (frame.patternRecord.collectionList != null));
  }

  public static void createCollectDescriptionExtensionFrame(ControlFrame frame, Description description) {
    { ControlFrame downframe = ControlFrame.createDownFrame(frame, null);

      ControlFrame.overlayWithPatternFrameP(downframe, description, null);
      downframe.patternRecord.collectionList = List.newList();
    }
  }

  public static QueryIterator createQuerySpecialistIterator(ControlFrame frame, Object [] MV_returnarray) {
    { Proposition proposition = null;
      PropertyList subqueryoptions = null;

      { Object [] caller_MV_returnarray = new Object[1];

        proposition = ControlFrame.computeSubqueryOptions(frame, caller_MV_returnarray);
        subqueryoptions = ((PropertyList)(caller_MV_returnarray[0]));
      }
      { QueryIterator subqueryiterator = Logic.allocateQueryIterator();
        Description subquerydescription = null;
        Stella_Object matchmode = null;
        boolean truefalsequeryP = false;
        boolean partialqueryP = false;
        List iovariables = List.newList();
        Vector iovariablebindings = null;

        if (proposition == null) {
          { QueryIterator _return_temp = null;

            MV_returnarray[0] = BooleanWrapper.wrapBoolean(false);
            MV_returnarray[1] = BooleanWrapper.wrapBoolean(false);
            return (_return_temp);
          }
        }
        else {
          QueryIterator.processQueryOptions(subqueryiterator, subqueryoptions);
        }
        matchmode = Logic.lookupQueryOption(subqueryiterator, Logic.KWD_MATCH_MODE);
        if ((matchmode != null) &&
            (!Stella.stringEqualP(Stella_Object.coerceToString(matchmode), "STRICT"))) {
          partialqueryP = true;
        }
        Logic.collectFreeVariables(proposition, iovariables, List.list(Stella.NIL), List.list(Stella.NIL));
        KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_QUERY_SPECIALIST_IO_VARIABLES, iovariables, null);
        { Object old$Evaluationmode$000 = Logic.$EVALUATIONMODE$.get();

          try {
            Native.setSpecial(Logic.$EVALUATIONMODE$, Logic.KWD_DESCRIPTION);
            { Description self001 = Description.newDescription();

              self001.ioVariables = ((Vector)(Logic.copyListToArgumentsVector(iovariables)));
              self001.proposition = proposition;
              subquerydescription = self001;
            }
            Description.computeInternalVariables(subquerydescription);
            { Description temp000 = Description.findDuplicateDescription(subquerydescription);

              subquerydescription = ((temp000 != null) ? temp000 : subquerydescription);
            }

          } finally {
            Logic.$EVALUATIONMODE$.set(old$Evaluationmode$000);
          }
        }
        iovariablebindings = Vector.newVector(iovariables.length());
        truefalsequeryP = true;
        { Stella_Object var = null;
          Cons iter000 = iovariables.theConsList;
          int i = Stella.NULL_INTEGER;
          int iter001 = 0;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
            var = iter000.value;
            i = iter001;
            (iovariablebindings.theArray)[i] = (Logic.argumentBoundTo(var));
            if ((iovariablebindings.theArray)[i] == null) {
              truefalsequeryP = false;
            }
          }
        }
        QueryIterator.initializeQueryIterator(subqueryiterator, subquerydescription, iovariablebindings);
        { QueryIterator _return_temp = subqueryiterator;

          MV_returnarray[0] = BooleanWrapper.wrapBoolean(truefalsequeryP);
          MV_returnarray[1] = BooleanWrapper.wrapBoolean(partialqueryP);
          return (_return_temp);
        }
      }
    }
  }

  public List querySpecialistIoVariables() {
    { ControlFrame self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_QUERY_SPECIALIST_IO_VARIABLES, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public static Proposition computeSubqueryOptions(ControlFrame frame, Object [] MV_returnarray) {
    { Vector arguments = frame.proposition.arguments;
      Stella_Object arg = null;
      Proposition proparg = null;
      int lastoptionargindex = arguments.length() - 1;
      int cursor = 1;
      Stella_Object key = null;
      Stella_Object value = null;
      PropertyList subqueryoptions = PropertyList.newPropertyList();
      PropertyList parentoptions = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).options;

      if (lastoptionargindex < 0) {
        { Proposition _return_temp = null;

          MV_returnarray[0] = null;
          return (_return_temp);
        }
      }
      arg = Logic.argumentBoundTo((arguments.theArray)[0]);
      if ((arg != null) &&
          Stella_Object.isaP(arg, Logic.SGT_LOGIC_PROPOSITION)) {
        proparg = ((Proposition)(arg));
      }
      else if (lastoptionargindex >= 1) {
        cursor = 0;
        key = Logic.KWD_HOW_MANY;
        value = arg;
        arg = Logic.argumentBoundTo((arguments.theArray)[1]);
        if ((arg != null) &&
            Stella_Object.isaP(arg, Logic.SGT_LOGIC_PROPOSITION)) {
          proparg = ((Proposition)(arg));
        }
        else {
          { Proposition _return_temp = null;

            MV_returnarray[0] = null;
            return (_return_temp);
          }
        }
      }
      else {
        { Proposition _return_temp = null;

          MV_returnarray[0] = null;
          return (_return_temp);
        }
      }
      if ((((lastoptionargindex - cursor) % 2) == 0)) {
        lastoptionargindex = lastoptionargindex - 1;
      }
      while (cursor < lastoptionargindex) {
        if (cursor == 0) {
        }
        else {
          key = Logic.generateTerm(Logic.argumentBoundTo((arguments.theArray)[cursor]));
          value = Logic.generateTerm(Logic.argumentBoundTo((arguments.theArray)[(cursor + 1)]));
        }
        cursor = cursor + 2;
        if ((key == null) ||
            (value == null)) {
          { Proposition _return_temp = null;

            MV_returnarray[0] = null;
            return (_return_temp);
          }
        }
        if (key == Logic.KWD_INHERIT) {
          if ((value == Logic.KWD_ALL) ||
              (value == Logic.KWD_CURRENT)) {
            { Stella_Object pkey = null;
              Stella_Object pvalue = null;
              Cons iter000 = parentoptions.thePlist;

              for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
                pkey = iter000.value;
                pvalue = iter000.rest.value;
                subqueryoptions.insertAt(pkey, pvalue);
              }
            }
          }
        }
        else if ((value == Logic.KWD_INHERIT) ||
            (value == Logic.KWD_CURRENT)) {
          if (Logic.lookupQueryOption(parentoptions, ((Keyword)(key))) != null) {
            subqueryoptions.insertAt(key, Logic.lookupQueryOption(parentoptions, ((Keyword)(key))));
          }
        }
        else {
          subqueryoptions.insertAt(key, value);
        }
      }
      { Proposition _return_temp = proparg;

        MV_returnarray[0] = subqueryoptions;
        return (_return_temp);
      }
    }
  }

  public static Keyword nativeSlotReaderSpecialist(ControlFrame frame, Keyword lastmove) {
    { Proposition proposition = frame.proposition;
      NamedDescription description = Logic.getDescription(((Surrogate)(proposition.operator)));
      Stella_Object argumentvalue = Logic.argumentBoundTo((proposition.arguments.theArray)[0]);
      Slot slot = ((!NamedDescription.classDescriptionP(description)) ? ((Slot)(description.nativeRelation())) : null);
      boolean successP = false;

      lastmove = lastmove;
      if ((argumentvalue != null) &&
          ((slot != null) &&
           (Stella_Object.isaP(argumentvalue, Logic.SGT_STELLA_THING) &&
            (!slot.abstractP)))) {
        { Stella_Object value = StandardObject.readSlotValue(((StandardObject)(argumentvalue)), ((StorageSlot)(slot)));

          if (value == null) {
            return (Logic.KWD_FAILURE);
          }
          if (!Logic.nullWrapperP(value)) {
            if (NamedDescription.functionDescriptionP(description)) {
              successP = PatternVariable.bindVariableToValueP(((PatternVariable)((proposition.arguments.theArray)[(proposition.arguments.length() - 1)])), value, true);
            }
            else {
              successP = Stella_Object.eqlP(value, Stella.TRUE_WRAPPER);
            }
            return (Logic.selectTestResult(successP, true, frame));
          }
        }
      }
      return (Logic.KWD_FAILURE);
    }
  }

  public List allJustifications() {
    { ControlFrame self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_ALL_JUSTIFICATIONS, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public static void recordExistentialIntroductionJustification(ControlFrame frame, Keyword lastmove) {
    { ControlFrame argument = frame.result;

      if (lastmove == Logic.KWD_UP_TRUE) {
        { Justification self000 = Justification.newJustification();

          self000.inferenceRule = Logic.KWD_EXISTENTIAL_INTRODUCTION;
          self000.antecedents = ((((Justification)(KeyValueList.dynamicSlotValue(argument.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null))) != null) ? Cons.cons(((Justification)(KeyValueList.dynamicSlotValue(argument.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null))), Stella.NIL) : Stella.NIL);
          ControlFrame.recordGoalJustification(frame, self000);
        }
      }
      else {
      }
    }
  }

  public static void recordClosedNotJustification(ControlFrame frame, Keyword lastmove) {
    if (lastmove == Logic.KWD_UP_FAIL) {
      { Justification self000 = Justification.newJustification();

        self000.inferenceRule = Logic.KWD_CLOSED_NOT_INTRODUCTION;
        self000.proposition = ((frame.proposition.kind == Logic.KWD_FAIL) ? frame.up.proposition : frame.proposition);
        ControlFrame.recordGoalJustification(frame, self000);
      }
    }
    else {
    }
  }

  public static void recordNegatedFailJustification(ControlFrame frame, Keyword lastmove) {
    if (lastmove == Logic.KWD_UP_TRUE) {
      { Justification antecedent = null;

        if (frame.result != null) {
          antecedent = ((Justification)(KeyValueList.dynamicSlotValue(frame.result.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null)));
        }
        { Justification self000 = Justification.newJustification();

          self000.inferenceRule = Logic.KWD_NEGATED_FAIL;
          self000.antecedents = Cons.cons(antecedent, Stella.NIL);
          ControlFrame.recordGoalJustification(frame, self000);
        }
      }
    }
    else {
    }
  }

  public static void recordFailJustification(ControlFrame frame, Keyword lastmove) {
    if (lastmove == Logic.KWD_UP_FAIL) {
      { Justification self000 = Justification.newJustification();

        self000.inferenceRule = Logic.KWD_FAIL_INTRODUCTION;
        ControlFrame.recordGoalJustification(frame, self000);
      }
    }
    else {
    }
  }

  public static void recordDisproofJustification(ControlFrame frame, Keyword lastmove) {
    { ControlFrame argument = frame.result;

      if ((lastmove == Logic.KWD_UP_TRUE) ||
          (lastmove == Logic.KWD_UP_FAIL)) {
        { Justification self000 = Justification.newJustification();

          self000.inferenceRule = Logic.KWD_DISPROOF;
          self000.antecedents = Cons.cons(((Justification)(KeyValueList.dynamicSlotValue(argument.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null))), Stella.NIL);
          ControlFrame.recordGoalJustification(frame, self000);
        }
      }
      else {
      }
    }
  }

  public static void recordOrIntroductionJustification(ControlFrame frame, Keyword lastmove) {
    { ControlFrame disjunct = frame.result;

      if (lastmove == Logic.KWD_UP_TRUE) {
        { Justification self000 = Justification.newJustification();

          self000.inferenceRule = Logic.KWD_OR_INTRODUCTION;
          self000.antecedents = Cons.cons(((Justification)(KeyValueList.dynamicSlotValue(disjunct.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null))), Stella.NIL);
          ControlFrame.recordGoalJustification(frame, self000);
        }
      }
      else {
      }
    }
  }

  public static void recordAndIntroductionJustification(ControlFrame frame, Keyword lastmove) {
    { Vector conjuncts = ((Vector)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ARGUMENTS, null)));
      Cons antecedents = Stella.NIL;

      if (lastmove == Logic.KWD_UP_TRUE) {
        { ControlFrame conjunct = null;
          Vector vector000 = conjuncts;
          int index000 = 0;
          int length000 = vector000.length();
          Cons collect000 = null;

          for (;index000 < length000; index000 = index000 + 1) {
            conjunct = ((ControlFrame)((vector000.theArray)[index000]));
            {
            }
            if (collect000 == null) {
              {
                collect000 = Cons.cons(((Justification)(KeyValueList.dynamicSlotValue(conjunct.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null))), Stella.NIL);
                if (antecedents == Stella.NIL) {
                  antecedents = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(antecedents, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(((Justification)(KeyValueList.dynamicSlotValue(conjunct.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null))), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        { Justification self000 = Justification.newJustification();

          self000.inferenceRule = Logic.KWD_AND_INTRODUCTION;
          self000.antecedents = antecedents;
          ControlFrame.recordGoalJustification(frame, self000);
        }
      }
      else {
      }
    }
  }

  public static void recordModusPonensJustification(ControlFrame frame, Keyword lastmove) {
    { ControlFrame antecedent = frame.result;

      if (lastmove == Logic.KWD_UP_TRUE) {
        { Proposition goal = ControlFrame.extractSubgoalOfFrame(frame);
          boolean reversepolarityP = frame.reversePolarityP;
          Keyword inferencerule = (reversepolarityP ? Logic.KWD_MODUS_TOLLENS : Logic.KWD_MODUS_PONENS);
          Proposition rule = ((Proposition)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_ANTECEDENTS_RULE, null)));
          Proposition ruleconsequent = ((Description)(((inferencerule == Logic.KWD_MODUS_PONENS) ? (rule.arguments.theArray)[1] : (rule.arguments.theArray)[0]))).proposition;
          boolean invertedP = ruleconsequent.kind == Logic.KWD_NOT;

          { Justification self001 = Justification.newJustification();

            self001.inferenceRule = inferencerule;
            self001.proposition = goal;
            { PrimitiveStrategy self002 = PrimitiveStrategy.newPrimitiveStrategy();

              self002.strategy = Logic.KWD_SCAN_PROPOSITIONS;
              self002.proposition = rule;
              self002.truthValue = ((TruthValue)(Stella_Object.accessInContext(rule.truthValue, rule.homeContext, false)));
              self002.positiveScore = ((TruthValue)(Stella_Object.accessInContext(rule.truthValue, rule.homeContext, false))).positiveScore;
              self001.antecedents = Cons.cons(self002, Cons.cons(((Justification)(KeyValueList.dynamicSlotValue(antecedent.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null))), Stella.NIL));
            }
            { Justification justification = self001;

              ControlFrame.recordGoalJustification(frame, justification);
              justification.reversePolarityP = (reversepolarityP ? (!invertedP) : invertedP);
            }
          }
        }
      }
      else {
      }
    }
  }

  public static void recordPatternJustification(ControlFrame frame, Keyword lastmove) {
    { ControlFrame argument = frame.result;
      Justification justification = ((Justification)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null)));

      if ((lastmove == Logic.KWD_UP_TRUE) ||
          (lastmove == Logic.KWD_UP_FAIL)) {
        if (((Justification)(KeyValueList.dynamicSlotValue(argument.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null))) == null) {
          return;
        }
        if (justification == null) {
          { Justification self000 = Justification.newJustification();

            self000.inferenceRule = Logic.KWD_PATTERN;
            ControlFrame.recordGoalJustification(frame, self000);
          }
          justification = ((Justification)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null)));
        }
        { KeyValueMap substitution = KeyValueMap.newKeyValueMap();
          PatternRecord patternrecord = frame.patternRecord;
          Description description = null;
          boolean collectionframeP = false;

          if (patternrecord != null) {
            collectionframeP = patternrecord.collectionList != null;
            description = patternrecord.optimalPattern;
            if (description != null) {
              { PatternVariable vbl = null;
                Vector vector000 = description.ioVariables;
                int index000 = 0;
                int length000 = vector000.length();

                for (;index000 < length000; index000 = index000 + 1) {
                  vbl = ((PatternVariable)((vector000.theArray)[index000]));
                  substitution.insertAt(vbl, (((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord.variableBindings.theArray)[(vbl.boundToOffset)]);
                }
              }
              { PatternVariable vbl = null;
                Vector vector001 = description.internalVariables;
                int index001 = 0;
                int length001 = vector001.length();

                for (;index001 < length001; index001 = index001 + 1) {
                  vbl = ((PatternVariable)((vector001.theArray)[index001]));
                  substitution.insertAt(vbl, (((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord.variableBindings.theArray)[(vbl.boundToOffset)]);
                }
              }
            }
          }
          if (Stella_Object.isaP(substitution, Logic.SGT_STELLA_KEY_VALUE_LIST)) {
            { KeyValueMap oldsubstitution = substitution;

              substitution = KeyValueMap.newKeyValueMap();
              { Stella_Object key = null;
                Stella_Object val = null;
                DictionaryIterator iter000 = ((DictionaryIterator)(oldsubstitution.allocateIterator()));

                while (iter000.nextP()) {
                  key = iter000.key;
                  val = iter000.value;
                  substitution.insertAt(key, val);
                }
              }
            }
          }
          justification.substitution = ((KeyValueMap)(substitution));
          { Justification antecedent = ((Justification)(KeyValueList.dynamicSlotValue(argument.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null)));

            if (collectionframeP) {
              justification.inferenceRule = Logic.KWD_AND_INTRODUCTION;
              { Justification patterncopy = null;

                { Justification self004 = Justification.newJustification();

                  self004.inferenceRule = Logic.KWD_PATTERN;
                  self004.antecedents = Cons.cons(antecedent, Stella.NIL);
                  ControlFrame.recordGoalJustification(frame, self004);
                }
                patterncopy = ((Justification)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null)));
                KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, justification, null);
                Justification.backlinkToPatternJustification(antecedent, patterncopy);
                Justification.backlinkToPatternJustification(patterncopy, justification);
                patterncopy.substitution = ((KeyValueMap)(substitution));
                justification.substitution = null;
                antecedent = patterncopy;
              }
            }
            justification.antecedents = Cons.cons(antecedent, justification.antecedents);
            if (!(collectionframeP)) {
              Justification.backlinkToPatternJustification(antecedent, justification);
            }
          }
        }
      }
      else {
      }
    }
  }

  public static void recordPrimitiveJustification(ControlFrame frame, Keyword lastmove) {
    if ((lastmove == Logic.KWD_UP_TRUE) ||
        (lastmove == Logic.KWD_UP_FAIL)) {
      { Keyword strategy = ((lastmove == Logic.KWD_UP_FAIL) ? Logic.KWD_FAILURE : frame.currentStrategy);
        Justification justification = null;

        if ((frame.justifications != null) &&
            (!frame.justifications.emptyP())) {
          justification = ((Justification)(frame.justifications.first()));
        }
        else if (frame.result != null) {
          if (((Justification)(KeyValueList.dynamicSlotValue(frame.result.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null))) != null) {
            { PrimitiveStrategy self000 = PrimitiveStrategy.newPrimitiveStrategy();

              self000.strategy = strategy;
              self000.antecedents = Cons.cons(((Justification)(KeyValueList.dynamicSlotValue(frame.result.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null))), Stella.NIL);
              justification = self000;
            }
          }
          else if ((frame.result.proposition != null) &&
              frame.result.proposition.forwardJustifications().nonEmptyP()) {
            justification = ((Justification)(frame.result.proposition.forwardJustifications().first()));
          }
        }
        else if ((frame.proposition != null) &&
            frame.proposition.forwardJustifications().nonEmptyP()) {
          Stella.STANDARD_OUTPUT.nativeStream.println("RECORD-PRIMITIVE-JUSTIFICATION:  Test to see if clause needed.");
          justification = ((Justification)(frame.proposition.forwardJustifications().first()));
        }
        else {
        }
        if (justification == null) {
          { PrimitiveStrategy self001 = PrimitiveStrategy.newPrimitiveStrategy();

            self001.strategy = strategy;
            justification = self001;
          }
        }
        ControlFrame.recordGoalJustification(frame, justification);
      }
    }
    else {
    }
  }

  public static void recordGoalJustification(ControlFrame goal, Justification justification) {
    if (justification.proposition == null) {
      justification.proposition = goal.proposition;
    }
    justification.reversePolarityP = goal.reversePolarityP;
    justification.truthValue = goal.truthValue;
    if ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
        (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) {
      goal.setJustificationPartialTruth(justification);
    }
    KeyValueList.setDynamicSlotValue(goal.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, justification, null);
  }

  public Keyword continuePartialFailProof(Keyword lastmove) {
    { ControlFrame self = this;

      { PartialMatchFrame pmf = self.partialMatchFrame;

        if (pmf == null) {
          ControlFrame.createAndLinkPartialMatchFrame(self, Logic.KWD_FAIL);
        }
        return (self.partialMatchFrame.continuePartialFailProof(lastmove));
      }
    }
  }

  public static Keyword continueFailProof(ControlFrame frame, Keyword lastmove) {
    if (lastmove == Logic.KWD_DOWN) {
      ControlFrame.createChoicePoint(frame);
      KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_INFERENCE_CUTOFF_REASON, null, null);
      return (Logic.KWD_MOVE_DOWN);
    }
    else if (lastmove == Logic.KWD_UP_TRUE) {
      { Keyword result = (frame.reversePolarityP ? Logic.KWD_FINAL_SUCCESS : Logic.KWD_FAILURE);

        if (frame.reversePolarityP) {
          ControlFrame.setFrameTruthValue(frame, Logic.TRUE_TRUTH_VALUE);
          if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue()) {
            ControlFrame.recordNegatedFailJustification(frame, lastmove);
          }
        }
        else {
          ControlFrame.setFrameTruthValue(frame, Logic.FALSE_TRUTH_VALUE);
        }
        PatternRecord.unbindVariablesBeginningAt(((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord, frame.choicePointUnbindingOffset);
        if (frame.down != null) {
          ControlFrame.popFramesUpTo(frame.down);
        }
        return (result);
      }
    }
    else if (lastmove == Logic.KWD_UP_FAIL) {
      { Keyword result = (frame.reversePolarityP ? Logic.KWD_FAILURE : Logic.KWD_FINAL_SUCCESS);

        if (((Keyword)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_INFERENCE_CUTOFF_REASON, null))) != null) {
          ControlFrame.setFrameTruthValue(frame, Logic.UNKNOWN_TRUTH_VALUE);
          result = Logic.KWD_FAILURE;
        }
        else if (frame.result.truthValue == Logic.INCONSISTENT_TRUTH_VALUE) {
          ControlFrame.setFrameTruthValue(frame, Logic.INCONSISTENT_TRUTH_VALUE);
          result = Logic.KWD_TERMINAL_FAILURE;
        }
        else if (frame.reversePolarityP) {
          ControlFrame.setFrameTruthValue(frame, Logic.FALSE_TRUTH_VALUE);
        }
        else {
          ControlFrame.setFrameTruthValue(frame, Logic.TRUE_TRUTH_VALUE);
          if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue()) {
            if (frame.up.proposition.kind == Logic.KWD_NOT) {
              ControlFrame.recordClosedNotJustification(frame, lastmove);
            }
            else {
              ControlFrame.recordFailJustification(frame, lastmove);
            }
          }
        }
        PatternRecord.unbindVariablesBeginningAt(((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord, frame.choicePointUnbindingOffset);
        return (result);
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + lastmove + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static void registerInferenceCutoff(ControlFrame frame, Keyword reason) {
    while (frame != null) {
      if ((frame.state == Logic.KWD_FAIL) ||
          ControlFrame.collectDescriptionExtensionFrameP(frame)) {
        KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_INFERENCE_CUTOFF_REASON, reason, null);
      }
      frame = frame.up;
    }
  }

  public static Keyword continueConstantProof(ControlFrame frame, Keyword lastmove) {
    lastmove = lastmove;
    { Proposition proposition = frame.proposition;

      frame.truthValue = ((TruthValue)(Stella_Object.accessInContext(proposition.truthValue, proposition.homeContext, false)));
      if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue() &&
          (((Justification)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null))) == null)) {
        { PrimitiveStrategy self000 = PrimitiveStrategy.newPrimitiveStrategy();

          self000.strategy = Logic.KWD_CONSTANT_PROPOSITION;
          ControlFrame.recordGoalJustification(frame, self000);
        }
      }
      if (frame.reversePolarityP) {
        if (Proposition.falseP(proposition)) {
          return (Logic.KWD_FINAL_SUCCESS);
        }
        else {
          return (Logic.KWD_FAILURE);
        }
      }
      else {
        if (Proposition.trueP(proposition)) {
          return (Logic.KWD_FINAL_SUCCESS);
        }
        else {
          return (Logic.KWD_FAILURE);
        }
      }
    }
  }

  public static Keyword continueExistsProof(ControlFrame frame, Keyword lastmove) {
    if (lastmove == Logic.KWD_DOWN) {
      return (Logic.KWD_MOVE_DOWN);
    }
    else if (lastmove == Logic.KWD_UP_TRUE) {
      { ControlFrame result = frame.result;

        if (result.partialMatchFrame != null) {
          result.partialMatchFrame.propagateFramePartialTruth(frame);
        }
        ControlFrame.propagateFrameTruthValue(result, frame);
        if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue()) {
          ControlFrame.recordExistentialIntroductionJustification(frame, lastmove);
        }
        if (frame.down == null) {
          return (Logic.KWD_FINAL_SUCCESS);
        }
        else {
          return (Logic.KWD_CONTINUING_SUCCESS);
        }
      }
    }
    else if (lastmove == Logic.KWD_UP_FAIL) {
      { ControlFrame result = frame.result;

        if (result.partialMatchFrame != null) {
          result.partialMatchFrame.propagateFramePartialTruth(frame);
        }
        ControlFrame.propagateFrameTruthValue(result, frame);
        if (frame.down == null) {
          return (Logic.KWD_FAILURE);
        }
        else {
          throw ((StellaException)(StellaException.newStellaException("Failed subgoal of 'exists' didn't remove itself from stack.").fillInStackTrace()));
        }
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + lastmove + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static Keyword continueForallProof(ControlFrame frame, Keyword lastmove) {
    lastmove = lastmove;
    { boolean testValue000 = false;

      if (frame.reversePolarityP) {
        testValue000 = true;
      }
      else {
        {
          { boolean alwaysP000 = true;

            { PatternVariable var = null;
              Vector vector000 = ((Vector)(KeyValueList.dynamicSlotValue(frame.proposition.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
              int index000 = 0;
              int length000 = vector000.length();

              loop000 : for (;index000 < length000; index000 = index000 + 1) {
                var = ((PatternVariable)((vector000.theArray)[index000]));
                if (!Logic.closedTermP(Logic.getDescription(Logic.logicalType(var)))) {
                  alwaysP000 = false;
                  break loop000;
                }
              }
            }
            testValue000 = alwaysP000;
          }
          if (!testValue000) {
            testValue000 = Proposition.closedPropositionP(((Proposition)((frame.proposition.arguments.theArray)[0])));
          }
        }
      }
      if (testValue000) {
        {
          frame.state = Logic.KWD_ITERATIVE_FORALL;
          return (Logic.KWD_MOVE_IN_PLACE);
        }
      }
      else {
        {
          { Keyword testValue001 = Logic.currentInferenceLevel().keyword;

            if ((testValue001 == Logic.KWD_NORMAL) ||
                (testValue001 == Logic.KWD_REFUTATION)) {
              ControlFrame.overlayWithStrategyFrame(frame, Logic.KWD_UNIVERSAL_INTRODUCTION);
              return (Logic.KWD_MOVE_IN_PLACE);
            }
            else {
              return (Logic.KWD_FAILURE);
            }
          }
        }
      }
    }
  }

  public static Keyword tryRefutationProof(ControlFrame frame) {
    { ParallelThread parallelthread = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentParallelThread;
      ParallelControlFrame parallelframe = ((ParallelControlFrame)(parallelthread.topControlFrame.up));

      if (parallelframe.unboundVariablesP) {
        return (Logic.KWD_FAILURE);
      }
      ParallelControlFrame.enterHypotheticalWorld(parallelframe);
      try {
        { boolean negatedtruthvalueP = frame.reversePolarityP;

          { Proposition prop = null;
            Cons iter000 = Proposition.inheritAsTopLevelProposition(frame.proposition, null);

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              prop = ((Proposition)(iter000.value));
              if ((Stella.$TRACED_KEYWORDS$ != null) &&
                  Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_TREE)) {
                {
                  Stella.STANDARD_OUTPUT.nativeStream.println();
                  Stella.STANDARD_OUTPUT.nativeStream.println("  Assume that " + prop + " is " + ((negatedtruthvalueP ? "true" : "false")) + ".");
                }
;
              }
              Proposition.recursivelyFastenDownPropositions(prop, false);
              Proposition.assignTruthValue(prop, (negatedtruthvalueP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
            }
          }
        }
      } catch (Clash e000) {
        return (Logic.KWD_FINAL_SUCCESS);
      }
      return (Logic.KWD_FAILURE);
    }
  }

  public static Keyword tryUniversalIntroductionProof(ControlFrame frame) {
    { ParallelThread parallelthread = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentParallelThread;
      ParallelControlFrame parallelframe = ((ParallelControlFrame)(parallelthread.topControlFrame.up));

      ParallelControlFrame.enterHypotheticalWorld(parallelframe);
      { Proposition forallprop = frame.proposition;
        Stella_Object antecedent = (forallprop.arguments.theArray)[0];
        Stella_Object consequent = (forallprop.arguments.theArray)[1];

        { PatternVariable v = null;
          Vector vector000 = ((Vector)(KeyValueList.dynamicSlotValue(forallprop.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
          int index000 = 0;
          int length000 = vector000.length();

          for (;index000 < length000; index000 = index000 + 1) {
            v = ((PatternVariable)((vector000.theArray)[index000]));
            { LogicObject skolem = Logic.createHypothesizedInstance("anonymous");

              if (v.skolemType != null) {
                Logic.assertMemberOfProposition(skolem, Logic.getDescription(v.skolemType));
              }
              PatternVariable.bindVariableToValueP(v, skolem, false);
            }
          }
        }
        try {
          { Proposition prop = null;
            Cons iter000 = Proposition.inheritAsTopLevelProposition(((Proposition)(antecedent)), null);

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              prop = ((Proposition)(iter000.value));
              Proposition.recursivelyFastenDownPropositions(prop, false);
              Proposition.assignTruthValue(prop, Stella.TRUE_WRAPPER);
            }
          }
        } catch (Clash e000) {
          return (Logic.KWD_FINAL_SUCCESS);
        }
        ControlFrame.createDownFrame(frame, ((Proposition)(consequent)));
        return (Logic.KWD_MOVE_DOWN);
      }
    }
  }

  public static Keyword resumeDisjunctiveImplicationProof(ControlFrame frame, Keyword lastmove) {
    if (lastmove == Logic.KWD_UP_TRUE) {
      ControlFrame.propagateFrameTruthValue(frame.result, frame);
      if (frame.result.partialMatchFrame != null) {
        frame.result.partialMatchFrame.propagateFramePartialTruth(frame);
      }
      if (frame.down != null) {
        return (Logic.KWD_CONTINUING_SUCCESS);
      }
      else {
        return (Logic.KWD_FINAL_SUCCESS);
      }
    }
    else if (lastmove == Logic.KWD_UP_FAIL) {
      return (Logic.KWD_FAILURE);
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + lastmove + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static Keyword tryDisjunctiveImplicationProof(ControlFrame frame) {
    { ParallelThread parallelthread = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentParallelThread;
      ParallelControlFrame parallelframe = ((ParallelControlFrame)(parallelthread.topControlFrame.up));

      { Proposition disjunctiveprop = frame.proposition;
        Vector disjuncts = disjunctiveprop.arguments;
        Proposition subgoaldisjunct = ((Proposition)((disjuncts.theArray)[0]));

        if (parallelframe.unboundVariablesP) {
          {
            subgoaldisjunct = null;
            { Proposition d = null;
              Vector vector000 = disjuncts;
              int index000 = 0;
              int length000 = vector000.length();

              for (;index000 < length000; index000 = index000 + 1) {
                d = ((Proposition)((vector000.theArray)[index000]));
                if (!Proposition.allArgumentsBoundP(d)) {
                  if (subgoaldisjunct != null) {
                    return (Logic.KWD_FAILURE);
                  }
                  subgoaldisjunct = d;
                }
              }
            }
          }
        }
        else {
          { Proposition d = null;
            Vector vector001 = disjuncts;
            int index001 = 0;
            int length001 = vector001.length();

            loop001 : for (;index001 < length001; index001 = index001 + 1) {
              d = ((Proposition)((vector001.theArray)[index001]));
              if (!(d.kind == Logic.KWD_NOT)) {
                subgoaldisjunct = d;
                break loop001;
              }
            }
          }
        }
        ParallelControlFrame.enterHypotheticalWorld(parallelframe);
        try {
          { boolean negatedtruthvalueP = frame.reversePolarityP;
            Proposition assumption = null;

            { Proposition disj = null;
              Vector vector002 = disjuncts;
              int index002 = 0;
              int length002 = vector002.length();

              for (;index002 < length002; index002 = index002 + 1) {
                disj = ((Proposition)((vector002.theArray)[index002]));
                if (!(disj == subgoaldisjunct)) {
                  assumption = Proposition.recursivelyFastenDownPropositions((negatedtruthvalueP ? Logic.conjoinPropositions(Proposition.inheritAsTopLevelProposition(disj, KeyValueMap.newKeyValueMap())) : Proposition.inheritProposition(disj, KeyValueMap.newKeyValueMap())), false);
                  if ((Stella.$TRACED_KEYWORDS$ != null) &&
                      Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_TREE)) {
                    {
                      Stella.STANDARD_OUTPUT.nativeStream.println();
                      Stella.STANDARD_OUTPUT.nativeStream.println("  Assume that " + assumption + " is " + ((negatedtruthvalueP ? "true" : "false")) + ".");
                      Stella.STANDARD_OUTPUT.nativeStream.println();
                    }
;
                  }
                  Proposition.assignTruthValue(assumption, (negatedtruthvalueP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
                }
              }
            }
          }
        } catch (Clash e000) {
          return (Logic.KWD_FINAL_SUCCESS);
        }
        { Proposition d = null;
          Vector vector003 = disjuncts;
          int index003 = 0;
          int length003 = vector003.length();
          int i = Stella.NULL_INTEGER;
          int iter000 = 0;

          loop003 : for (;index003 < length003; index003 = index003 + 1, iter000 = iter000 + 1) {
            d = ((Proposition)((vector003.theArray)[index003]));
            i = iter000;
            if (d == subgoaldisjunct) {
              frame.argumentCursor = i;
              break loop003;
            }
          }
        }
        return (Logic.KWD_MOVE_DOWN);
      }
    }
  }

  public static Keyword continueClusteredConjunctionProof(ControlFrame andframe, Keyword lastmove) {
    { Keyword state = andframe.state;
      ClusteredConjunctionProofAdjunct adjunct = ((ClusteredConjunctionProofAdjunct)(((ProofAdjunct)(KeyValueList.dynamicSlotValue(andframe.dynamicSlots, Logic.SYM_LOGIC_PROOF_ADJUNCT, null)))));
      Proposition proposition = andframe.proposition;
      Vector arguments = proposition.arguments;
      int nofarguments = arguments.length();
      ControlFrame downframe = null;

      if ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
          (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) {
        andframe.state = Logic.KWD_AND;
        lastmove = ControlFrame.oldInterpretAndScores(andframe, lastmove);
        andframe.state = state;
      }
      if (lastmove == Logic.KWD_DOWN) {
        if (adjunct == null) {
          { ClusteredConjunctionProofAdjunct self000 = ClusteredConjunctionProofAdjunct.newClusteredConjunctionProofAdjunct();

            self000.clusterFrames = Vector.newVector(nofarguments);
            adjunct = self000;
          }
          KeyValueList.setDynamicSlotValue(andframe.dynamicSlots, Logic.SYM_LOGIC_PROOF_ADJUNCT, adjunct, null);
        }
        downframe = ((ControlFrame)((adjunct.clusterFrames.theArray)[(andframe.argumentCursor)]));
        if (downframe == null) {
          ControlFrame.createSubgoalFrame(andframe, ((Proposition)((arguments.theArray)[(andframe.argumentCursor)])), null);
        }
        else {
          andframe.down = downframe;
        }
        return (Logic.KWD_MOVE_DOWN);
      }
      else if (lastmove == Logic.KWD_UP_TRUE) {
        andframe.truthValue = ((andframe.truthValue == null) ? andframe.result.truthValue : TruthValue.conjoinTruthValues(andframe.truthValue, andframe.result.truthValue));
        if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue()) {
          ControlFrame.recordAndIntroductionJustification(andframe, lastmove);
        }
        (adjunct.clusterFrames.theArray)[(andframe.argumentCursor)] = (andframe.down);
        if ((andframe.argumentCursor + 1) == nofarguments) {
          { int i = Stella.NULL_INTEGER;
            int iter000 = 1;
            int upperBound000 = nofarguments;
            boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

            for (;unboundedP000 ||
                      (iter000 <= upperBound000); iter000 = iter000 + 1) {
              i = iter000;
              if (((ControlFrame)((adjunct.clusterFrames.theArray)[(nofarguments - i)])) != null) {
                andframe.argumentCursor = nofarguments - i;
                andframe.down = ((ControlFrame)((adjunct.clusterFrames.theArray)[(andframe.argumentCursor)]));
                return (Logic.KWD_CONTINUING_SUCCESS);
              }
            }
          }
          andframe.down = null;
          return (Logic.KWD_FINAL_SUCCESS);
        }
        else {
          andframe.argumentCursor = andframe.argumentCursor + 1;
          downframe = ((ControlFrame)((adjunct.clusterFrames.theArray)[(andframe.argumentCursor)]));
          if (downframe == null) {
            ControlFrame.createSubgoalFrame(andframe, ((Proposition)((arguments.theArray)[(andframe.argumentCursor)])), null);
          }
          else {
            andframe.down = downframe;
          }
          return (Logic.KWD_MOVE_DOWN);
        }
      }
      else if (lastmove == Logic.KWD_UP_FAIL) {
        if ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
            (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) {
          andframe.down = null;
          ControlFrame.setFrameTruthValue(andframe, null);
          return (Logic.KWD_TERMINAL_FAILURE);
        }
        if (((ControlFrame)((adjunct.clusterFrames.theArray)[(andframe.argumentCursor)])) == null) {
          { Keyword testValue000 = ((Proposition)((arguments.theArray)[(andframe.argumentCursor)])).kind;

            if ((testValue000 == Logic.KWD_AND) ||
                ((testValue000 == Logic.KWD_FUNCTION) ||
                 ((testValue000 == Logic.KWD_PREDICATE) ||
                  (testValue000 == Logic.KWD_IMPLIES)))) {
              andframe.down = null;
              ControlFrame.setFrameTruthValue(andframe, null);
              return (Logic.KWD_TERMINAL_FAILURE);
            }
            else {
            }
          }
        }
        (adjunct.clusterFrames.theArray)[(andframe.argumentCursor)] = null;
        { int i = Stella.NULL_INTEGER;
          int iter001 = 1;
          int upperBound001 = andframe.argumentCursor;
          boolean unboundedP001 = upperBound001 == Stella.NULL_INTEGER;

          for (;unboundedP001 ||
                    (iter001 <= upperBound001); iter001 = iter001 + 1) {
            i = iter001;
            if (((ControlFrame)((adjunct.clusterFrames.theArray)[(andframe.argumentCursor - i)])) != null) {
              andframe.argumentCursor = andframe.argumentCursor - i;
              andframe.down = ((ControlFrame)((adjunct.clusterFrames.theArray)[(andframe.argumentCursor)]));
              return (Logic.KWD_MOVE_DOWN);
            }
          }
        }
        andframe.down = null;
        ControlFrame.setFrameTruthValue(andframe, null);
        return (Logic.KWD_TERMINAL_FAILURE);
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + lastmove + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static Keyword tryEquivalenceProof(ControlFrame frame) {
    { Vector arguments = frame.proposition.arguments;
      Stella_Object firstarg = (arguments.theArray)[0];
      Stella_Object firstvalue = Logic.argumentBoundTo(firstarg);
      Stella_Object secondarg = (arguments.theArray)[1];
      Stella_Object secondvalue = Logic.argumentBoundTo(secondarg);
      boolean successP = false;

      if (frame.reversePolarityP) {
        if ((firstvalue == null) ||
            (secondvalue == null)) {
          return (Logic.KWD_FAILURE);
        }
        else if (Logic.skolemP(firstvalue) ||
            Logic.skolemP(secondvalue)) {
          return (Logic.KWD_FAILURE);
        }
        else if (Stella_Object.eqlP(firstvalue, secondvalue)) {
          ControlFrame.setFrameTruthValue(frame, Logic.FALSE_TRUTH_VALUE);
          return (Logic.KWD_TERMINAL_FAILURE);
        }
        else {
          ControlFrame.setFrameTruthValue(frame, Logic.TRUE_TRUTH_VALUE);
          return (Logic.KWD_FINAL_SUCCESS);
        }
      }
      if (firstvalue != null) {
        if (secondvalue != null) {
          successP = Stella_Object.eqlP(firstvalue, secondvalue);
        }
        else {
          successP = PatternVariable.bindVariableToValueP(((PatternVariable)(secondarg)), firstvalue, true);
        }
      }
      else {
        if (secondvalue != null) {
          successP = PatternVariable.bindVariableToValueP(((PatternVariable)(firstarg)), secondvalue, true);
        }
        else {
          successP = false;
        }
      }
      return ((successP ? Logic.KWD_FINAL_SUCCESS : Logic.KWD_FAILURE));
    }
  }

  public static Keyword trySubsumptionTest(ControlFrame frame) {
    { Proposition proposition = frame.proposition;
      Stella_Object subcollectionarg = (proposition.arguments.theArray)[0];
      Stella_Object supercollectionarg = (proposition.arguments.theArray)[1];
      Description subcollection = ((Description)(Logic.argumentBoundTo(subcollectionarg)));
      Description supercollection = ((Description)(Logic.argumentBoundTo(supercollectionarg)));

      if (frame.reversePolarityP) {
        return (Logic.KWD_FAILURE);
      }
      if ((subcollection != null) &&
          (((Vector)(KeyValueList.dynamicSlotValue(subcollection.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null))) != null)) {
        { boolean foundP000 = false;

          { PatternVariable var = null;
            Vector vector000 = ((Vector)(KeyValueList.dynamicSlotValue(subcollection.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null)));
            int index000 = 0;
            int length000 = vector000.length();

            loop000 : for (;index000 < length000; index000 = index000 + 1) {
              var = ((PatternVariable)((vector000.theArray)[index000]));
              if (!Logic.argumentBoundP(var)) {
                foundP000 = true;
                break loop000;
              }
            }
          }
          if (foundP000) {
            return (Logic.KWD_FAILURE);
          }
          else {
            subcollection = ((Description)(Logic.instantiateExternalBindings(subcollection)));
          }
        }
      }
      if ((supercollection != null) &&
          (((Vector)(KeyValueList.dynamicSlotValue(supercollection.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null))) != null)) {
        { boolean foundP001 = false;

          { PatternVariable var = null;
            Vector vector001 = ((Vector)(KeyValueList.dynamicSlotValue(supercollection.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null)));
            int index001 = 0;
            int length001 = vector001.length();

            loop001 : for (;index001 < length001; index001 = index001 + 1) {
              var = ((PatternVariable)((vector001.theArray)[index001]));
              if (!Logic.argumentBoundP(var)) {
                foundP001 = true;
                break loop001;
              }
            }
          }
          if (foundP001) {
            return (Logic.KWD_FAILURE);
          }
          else {
            supercollection = ((Description)(Logic.instantiateExternalBindings(supercollection)));
          }
        }
      }
      { TruthValue truthvalue = Description.descriptionSpecializesDescriptionP(subcollection, supercollection);

        ControlFrame.setFrameTruthValue(frame, truthvalue);
        if ((truthvalue == Logic.TRUE_TRUTH_VALUE) ||
            (truthvalue == Logic.DEFAULT_TRUE_TRUTH_VALUE)) {
          return (Logic.KWD_FINAL_SUCCESS);
        }
        else {
          return (Logic.KWD_FAILURE);
        }
      }
    }
  }

  public static Keyword continueContainedByProof(ControlFrame frame, Keyword lastmove) {
    if (lastmove == Logic.KWD_DOWN) {
      if (frame.state == Logic.KWD_CONTAINED_BY) {
        ControlFrame.resetCurrentPatternRecord(frame, Logic.KWD_LOCAL);
      }
      ControlFrame.createDownFrame(frame, ((Proposition)((frame.proposition.arguments.theArray)[0])));
      KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_BACK, frame.down, null);
      return (Logic.KWD_MOVE_DOWN);
    }
    else if (lastmove == Logic.KWD_UP_TRUE) {
      switch (frame.argumentCursor) {
        case 0: 
          frame.down = null;
          frame.argumentCursor = 1;
          return (Logic.KWD_MOVE_DOWN);
        case 1: 
          if (frame.down != null) {
            ControlFrame.popFramesUpTo(frame.down);
          }
          if (((ControlFrame)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_BACK, null))).state == Logic.KWD_POPPED) {
            {
              ControlFrame.setFrameTruthValue(frame, Logic.TRUE_TRUTH_VALUE);
              return (Logic.KWD_FINAL_SUCCESS);
            }
          }
          else {
            {
              frame.down = ((ControlFrame)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_BACK, null)));
              frame.argumentCursor = 0;
              return (Logic.KWD_MOVE_DOWN);
            }
          }
        default:
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + frame.argumentCursor + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
      }
    }
    else if (lastmove == Logic.KWD_UP_FAIL) {
      switch (frame.argumentCursor) {
        case 0: 
          ControlFrame.setFrameTruthValue(frame, Logic.TRUE_TRUTH_VALUE);
          return (Logic.KWD_FINAL_SUCCESS);
        case 1: 
          { ControlFrame parent = frame.up;
            Proposition parentgoal = parent.proposition;

            if ((parentgoal.kind == Logic.KWD_IMPLIES) &&
                Logic.closedTermP((parentgoal.arguments.theArray)[1])) {
              ControlFrame.setFrameTruthValue(frame, Logic.FALSE_TRUTH_VALUE);
              parent.nextStrategies = Stella.NIL;
            }
            if (!(((ControlFrame)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_BACK, null))).state == Logic.KWD_POPPED)) {
              ControlFrame.popFramesUpTo(((ControlFrame)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_BACK, null))));
            }
            return (Logic.KWD_FAILURE);
          }
        default:
          { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

            stream001.nativeStream.print("`" + frame.argumentCursor + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
          }
      }
    }
    else {
      { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

        stream002.nativeStream.print("`" + lastmove + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream002.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static Keyword tryContainedByProof(ControlFrame upframe) {
    { Proposition upproposition = upframe.proposition;
      Stella_Object subcollection = Logic.argumentBoundTo((upproposition.arguments.theArray)[0]);
      Stella_Object supercollection = Logic.argumentBoundTo((upproposition.arguments.theArray)[1]);
      Proposition containedbyprop = Logic.createProposition(Logic.SYM_LOGIC_CONTAINED_BY, 2);
      Description description = (Stella_Object.isaP(subcollection, Logic.SGT_LOGIC_DESCRIPTION) ? ((Description)(subcollection)) : ((Description)(supercollection)));
      int arity = description.arity();
      List bridgearguments = List.newList();
      ControlFrame containedbyframe = ControlFrame.createDownFrame(upframe, containedbyprop);

      if (upframe.reversePolarityP) {
        return (Logic.KWD_FAILURE);
      }
      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        PatternVariable vbl = null;
        Vector vector000 = description.ioVariables;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; iter000 = iter000 + 1, index000 = index000 + 1) {
          i = iter000;
          vbl = ((PatternVariable)((vector000.theArray)[index000]));
          { PatternVariable bridgevbl = PatternVariable.newPatternVariable();

            bridgevbl.boundToOffset = i;
            bridgevbl.skolemName = vbl.skolemName;
            bridgevbl.skolemType = vbl.skolemType;
            bridgearguments.insertLast(bridgevbl);
          }
        }
      }
      containedbyframe.state = Logic.KWD_CONTAINED_BY;
      containedbyframe.proposition = containedbyprop;
      (containedbyprop.arguments.theArray)[0] = (Logic.createContainedByArgument(subcollection, bridgearguments));
      (containedbyprop.arguments.theArray)[1] = (Logic.createContainedByArgument(supercollection, bridgearguments));
      ControlFrame.createPatternRecord(containedbyframe, null, null);
      PatternRecord.activatePatternRecord(containedbyframe.patternRecord, arity);
      return (Logic.KWD_MOVE_DOWN);
    }
  }

  public static Keyword tryImpliesProof(ControlFrame frame) {
    { Proposition proposition = frame.proposition;
      Stella_Object subcollectionarg = (proposition.arguments.theArray)[0];
      Stella_Object supercollectionarg = (proposition.arguments.theArray)[1];
      Stella_Object subcollection = Logic.argumentBoundTo(subcollectionarg);
      Stella_Object supercollection = Logic.argumentBoundTo(supercollectionarg);

      if ((subcollection == null) ||
          (supercollection == null)) {
        return (Logic.KWD_FAILURE);
      }
      if ((!Logic.inferableDescriptionP(subcollection)) &&
          ((!Logic.inferableDescriptionP(supercollection)) &&
           (Logic.closedTermP(subcollection) ||
            frame.reversePolarityP))) {
        { Keyword testValue000 = Logic.trySimpleContainedByProof(subcollection, supercollection, frame.reversePolarityP);

          if (testValue000 == Logic.KWD_FINAL_SUCCESS) {
            ControlFrame.setFrameTruthValue(frame, Logic.TRUE_TRUTH_VALUE);
            return (Logic.KWD_FINAL_SUCCESS);
          }
          else if (testValue000 == Logic.KWD_TERMINAL_FAILURE) {
            ControlFrame.setFrameTruthValue(frame, Logic.FALSE_TRUTH_VALUE);
            return (Logic.KWD_TERMINAL_FAILURE);
          }
          else {
          }
        }
      }
      if (Stella_Object.isaP(subcollection, Logic.SGT_LOGIC_DESCRIPTION) &&
          Stella_Object.isaP(supercollection, Logic.SGT_LOGIC_DESCRIPTION)) {
        ControlFrame.pushNextStrategy(frame, Logic.KWD_SUBSUMPTION_TEST);
      }
      if (Logic.closedTermP(subcollection)) {
        ControlFrame.pushNextStrategy(frame, Logic.KWD_CONTAINED_BY);
      }
      return (Logic.KWD_FAILURE);
    }
  }

  public static Keyword tryScanCollectionProof(ControlFrame frame) {
    { Proposition proposition = frame.proposition;
      Vector arguments = proposition.arguments;
      Stella_Object memberarg = (arguments.theArray)[0];
      Iterator iterator = ((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, null)));

      if (iterator == null) {
        { Description collection = Proposition.extractCollectionArgument(proposition);
          List members = null;

          { boolean collectdirectmembersonlyP = Description.inferableP(collection);

            members = Logic.assertedCollectionMembers(collection, collectdirectmembersonlyP);
            if (!collectdirectmembersonlyP) {
              NamedDescription.updateObservedCardinality(((NamedDescription)(collection)), members.length());
            }
          }
          if (members == null) {
            return (Logic.KWD_FAILURE);
          }
          iterator = ((ListIterator)(members.allocateIterator()));
          KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, iterator, null);
        }
      }
      while (iterator.nextP()) {
        if (PatternVariable.bindVariableToValueP(((PatternVariable)(memberarg)), Logic.valueOf(iterator.value), true)) {
          return (Logic.KWD_CONTINUING_SUCCESS);
        }
      }
      return (Logic.KWD_FAILURE);
    }
  }

  public static Keyword tryIsaPropositionProof(ControlFrame frame) {
    { Proposition proposition = frame.proposition;
      Surrogate surrogate = ((Surrogate)(proposition.operator));
      Vector arguments = proposition.arguments;
      Stella_Object memberarg = (arguments.theArray)[0];
      Stella_Object member = Logic.argumentBoundTo(memberarg);
      boolean scanisapropositionsP = ((Boolean)(Logic.$GENERATE_ALL_PROOFSp$.get())).booleanValue() ||
          ((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue();

      if (Logic.$CYC_KLUDGES_ENABLEDp$) {
        if (!(((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue())) {
          scanisapropositionsP = false;
        }
      }
      if (member == null) {
        return (ControlFrame.tryScanCollectionProof(frame));
      }
      if (Stella_Object.isaP(member, Logic.SGT_STELLA_LITERAL_WRAPPER) ||
          ((surrogate == Logic.SGT_LOGIC_PROPOSITION) ||
           Logic.descriptionP(member))) {
        { boolean successP = Logic.logicalSubtypeOfP(Logic.logicalType(member), surrogate);

          if (((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue()) {
            successP = !successP;
          }
          if (successP) {
            return (Logic.KWD_FINAL_SUCCESS);
          }
          if (!(Logic.instanceHasBacklinksP(member))) {
            return (Logic.KWD_FAILURE);
          }
        }
      }
      if (scanisapropositionsP) {
        return (ControlFrame.tryScanPropositionsProof(frame));
      }
      { Description collection = Proposition.extractCollectionArgument(proposition);

        if (Logic.testIsaP(member, collection.surrogateValueInverse)) {
          return (Logic.KWD_FINAL_SUCCESS);
        }
        else {
          return (Logic.KWD_FAILURE);
        }
      }
    }
  }

  public static Keyword tryFullSubqueryProof(ControlFrame frame) {
    { Description description = ((Description)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTION, null)));
      Vector externalarguments = ControlFrame.findExternalArgumentsForSubgoal(frame);

      if (ControlFrame.overlayWithPatternFrameP(frame, description, externalarguments)) {
        return (Logic.KWD_MOVE_IN_PLACE);
      }
      if ((frame.partialMatchFrame == null) &&
          ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
           (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null))) {
        ControlFrame.createAndLinkPartialMatchFrame(frame, Logic.KWD_ATOMIC_GOAL);
      }
      return (Logic.KWD_FAILURE);
    }
  }

  public static Keyword continueConditionalAntecedentProof(ControlFrame frame, Keyword lastmove) {
    { ConditionalAntecedentProofAdjunct proofadjunct = ((ConditionalAntecedentProofAdjunct)(((ProofAdjunct)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_PROOF_ADJUNCT, null)))));
      Proposition provablerule = proofadjunct.provableRule;

      if (lastmove == Logic.KWD_DOWN) {
        ControlFrame.createSubgoalFrame(frame, provablerule, Logic.KWD_FORWARD_GOALS);
        return (Logic.KWD_MOVE_DOWN);
      }
      else if (lastmove == Logic.KWD_UP_TRUE) {
        if (proofadjunct.phase == Logic.KWD_ORIGINAL_GOAL) {
          frame.truthValue = TruthValue.weakenTruthValue(ControlFrame.propagateFrameTruthValue(frame.result, frame), ((TruthValue)(Stella_Object.accessInContext(provablerule.truthValue, provablerule.homeContext, false))));
          return (Logic.selectProofResult(true, frame.down != null, false));
        }
        Proposition.assignTruthValue(provablerule, frame.result.truthValue);
        { ControlFrame downframe = ControlFrame.createSubgoalFrame(frame, frame.proposition, Logic.KWD_ANTECEDENTS);

          KeyValueList.setDynamicSlotValue(downframe.dynamicSlots, Logic.SYM_STELLA_ITERATOR, Cons.consList(Cons.cons(provablerule, Stella.NIL)).allocateIterator(), null);
          proofadjunct.phase = Logic.KWD_ORIGINAL_GOAL;
          return (Logic.KWD_MOVE_DOWN);
        }
      }
      else if (lastmove == Logic.KWD_UP_FAIL) {
        ControlFrame.propagateFrameTruthValue(frame.result, frame);
        return (Logic.KWD_FAILURE);
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + lastmove + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static ControlFrame createConditionalAntecedentSubframe(ControlFrame frame, Proposition goal, Proposition provablerule) {
    { ControlFrame downframe = ControlFrame.createSubgoalFrame(frame, goal, Logic.KWD_CONDITIONAL_ANTECEDENT);
      ConditionalAntecedentProofAdjunct proofadjunct = ConditionalAntecedentProofAdjunct.newConditionalAntecedentProofAdjunct();

      KeyValueList.setDynamicSlotValue(downframe.dynamicSlots, Logic.SYM_LOGIC_PROOF_ADJUNCT, proofadjunct, null);
      proofadjunct.provableRule = provablerule;
      proofadjunct.goal = goal;
      return (downframe);
    }
  }

  public static Keyword tryForwardGoalsProof(ControlFrame frame) {
    { Iterator iterator = ((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, null)));

      if (iterator == null) {
        { Proposition baseproposition = Proposition.findMatchingConceivedProposition(frame.proposition);
          List forwardgoals = null;

          if (baseproposition == null) {
            return (Logic.KWD_FAILURE);
          }
          forwardgoals = Proposition.getForwardGoals(baseproposition);
          if (forwardgoals.emptyP()) {
            return (Logic.KWD_FAILURE);
          }
          else if ((forwardgoals.rest() == Stella.NIL) &&
              Proposition.trueP(((ForwardGoalRecord)(forwardgoals.first())).forwardRule)) {
            ControlFrame.createSubgoalFrame(frame, ((ForwardGoalRecord)(forwardgoals.first())).forwardGoal, null);
            return (Logic.KWD_MOVE_DOWN);
          }
          else {
            iterator = ((ListIterator)(forwardgoals.allocateIterator()));
            KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, iterator, null);
          }
        }
      }
      else {
        iterator = ((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, null)));
      }
      if (iterator.nextP()) {
        { ForwardGoalRecord fwdgoalrec = ((ForwardGoalRecord)(iterator.value));

          if (Proposition.trueP(fwdgoalrec.forwardRule)) {
            ControlFrame.createSubgoalFrame(frame, fwdgoalrec.forwardGoal, null);
          }
          else {
            ControlFrame.createConditionalAntecedentSubframe(frame, fwdgoalrec.forwardGoal, fwdgoalrec.forwardRule);
          }
          return (Logic.KWD_MOVE_DOWN);
        }
      }
      return (Logic.KWD_FAILURE);
    }
  }

  public static Keyword tryGoalComplementProof(ControlFrame frame) {
    { Description description = ControlFrame.extractSubgoalDescriptionOfFrame(frame);
      Description complement = Description.getInferableComplementDescription(description);
      ControlFrame downframe = ControlFrame.createSubgoalFrame(frame, null, Logic.KWD_ALL_SUBGOAL_STRATEGIES);

      KeyValueList.setDynamicSlotValue(downframe.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTION, complement, null);
      downframe.reversePolarityP = false;
      return (Logic.KWD_MOVE_DOWN);
    }
  }

  public static Keyword continueAntecedentsProof(ControlFrame frame, Keyword lastmove) {
    { Iterator iterator = ((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, null)));
      boolean firsttimeP = iterator == null;
      boolean reversepolarityP = frame.reversePolarityP;

      if (lastmove == Logic.KWD_UP_TRUE) {
        { Proposition object000 = ((Proposition)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_ANTECEDENTS_RULE, null)));
          Stella_Object oldValue000 = object000.truthValue;

          frame.truthValue = TruthValue.weakenTruthValue(ControlFrame.propagateFrameTruthValue(frame.result, frame), ((TruthValue)(Stella_Object.accessInContext(oldValue000, object000.homeContext, false))));
        }
        if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue()) {
          ControlFrame.recordModusPonensJustification(frame, lastmove);
        }
        return (Logic.KWD_CONTINUING_SUCCESS);
      }
      else {
      }
      if (firsttimeP) {
        iterator = Description.allocateAntecedentsIterator(ControlFrame.extractSubgoalDescriptionOfFrame(frame), ControlFrame.findExternalArgumentsForSubgoal(frame), reversepolarityP);
        if (iterator == null) {
          return (Logic.KWD_FAILURE);
        }
        KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, iterator, null);
      }
      loop000 : while (iterator.nextP()) {
        { Proposition impliesproposition = ((Proposition)(iterator.value));
          Description antecedentdescription = (reversepolarityP ? ((Description)((impliesproposition.arguments.theArray)[1])) : ((Description)((impliesproposition.arguments.theArray)[0])));

          if (ControlFrame.checkForDuplicateRuleP(frame, impliesproposition)) {
            continue loop000;
          }
          KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_ANTECEDENTS_RULE, impliesproposition, null);
          if (!Proposition.trueP(impliesproposition)) {
            if (Proposition.getForwardGoals(impliesproposition).emptyP()) {
              continue loop000;
            }
            else {
              {
                ControlFrame.createConditionalAntecedentSubframe(frame, frame.proposition, impliesproposition);
                return (Logic.KWD_MOVE_DOWN);
              }
            }
          }
          { ControlFrame downframe = ControlFrame.createSubgoalFrame(frame, null, Logic.KWD_FULL_SUBQUERY);

            KeyValueList.setDynamicSlotValue(downframe.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTION, antecedentdescription, null);
            return (Logic.KWD_MOVE_DOWN);
          }
        }
      }
      return (Logic.KWD_FAILURE);
    }
  }

  public static boolean checkForDuplicateRuleP(ControlFrame frame, Proposition impliesproposition) {
    if (!(Logic.$DUPLICATE_SUBGOAL_STRATEGY$ == Logic.KWD_DUPLICATE_)) {
      return (false);
    }
    { ControlFrame previousframe = frame.up;
      Cons goalbindings = Proposition.yieldGoalBindings(frame.proposition);

      { int i = Stella.NULL_INTEGER;
        int iter000 = 1;
        int upperBound000 = Logic.$DUPLICATE_RULE_SEARCH_DEPTH$;
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

        for (;unboundedP000 ||
                  (iter000 <= upperBound000); iter000 = iter000 + 1) {
          i = iter000;
          i = i;
          if (previousframe == null) {
            return (false);
          }
          { boolean testValue000 = false;

            testValue000 = ((Proposition)(KeyValueList.dynamicSlotValue(previousframe.dynamicSlots, Logic.SYM_LOGIC_ANTECEDENTS_RULE, null))) == impliesproposition;
            if (testValue000) {
              { boolean alwaysP000 = true;

                { Stella_Object b1 = null;
                  Cons iter001 = goalbindings;
                  Stella_Object b2 = null;
                  Cons iter002 = Proposition.yieldGoalBindings(previousframe.proposition);

                  loop001 : for (;(!(iter001 == Stella.NIL)) &&
                            (!(iter002 == Stella.NIL)); iter001 = iter001.rest, iter002 = iter002.rest) {
                    b1 = iter001.value;
                    b2 = iter002.value;
                    if (!Stella_Object.eqlP(b1, b2)) {
                      alwaysP000 = false;
                      break loop001;
                    }
                  }
                }
                testValue000 = alwaysP000;
              }
              if (testValue000) {
                testValue000 = frame.reversePolarityP == previousframe.reversePolarityP;
              }
            }
            if (testValue000) {
              if ((Stella.$TRACED_KEYWORDS$ != null) &&
                  Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_CACHES)) {
                Stella.STANDARD_OUTPUT.nativeStream.println("DUPLICATE RULE.  BINDINGS: " + goalbindings);
              }
              if (false) {
                ControlFrame.establishGoalCache(frame);
              }
              return (true);
            }
          }
          previousframe = previousframe.up;
        }
      }
    }
    return (false);
  }

  public static void establishGoalCache(ControlFrame frame) {
    { ControlFrame goalframe = null;
      ControlFrame restartframe = null;
      int restartdepth = Stella.NULL_INTEGER;

      { Object [] caller_MV_returnarray = new Object[2];

        goalframe = ControlFrame.findDuplicatedGoal(frame, caller_MV_returnarray);
        restartframe = ((ControlFrame)(caller_MV_returnarray[0]));
        restartdepth = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
      }
      {
        restartframe = restartframe;
        restartdepth = restartdepth;
      }
      if ((goalframe != null) &&
          (ControlFrame.findGoalCache(goalframe) == null)) {
        ControlFrame.createGoalCacheP(goalframe);
      }
    }
  }

  public static Keyword trySubgoalStrategiesProof(ControlFrame frame) {
    { Description description = ControlFrame.extractSubgoalDescriptionOfFrame(frame);
      boolean reversepolarityP = frame.reversePolarityP;
      Cons strategies = Stella.NIL;

      { boolean chooseValue000 = false;

        if (reversepolarityP) {
          { boolean foundP000 = false;

            { ConsIterator p = LogicObject.applicableRulesOfDescription(description, Logic.KWD_FORWARD, true).allocateIterator();

              loop000 : while (p.nextP()) {
                foundP000 = true;
                break loop000;
              }
            }
            chooseValue000 = foundP000;
          }
        }
        else {
          chooseValue000 = Description.inferableP(description);
        }
        if (chooseValue000) {
          strategies = Cons.cons(Logic.KWD_ANTECEDENTS, strategies);
        }
      }
      if (reversepolarityP &&
          (Description.getInferableComplementDescription(description) != null)) {
        strategies = Cons.cons(Logic.KWD_GOAL_COMPLEMENT, strategies);
      }
      { Proposition proposition = frame.proposition;

        if ((proposition != null) &&
            (Proposition.allArgumentsBoundP(proposition) &&
             (Proposition.findMatchingConceivedProposition(proposition) != null))) {
          strategies = Cons.cons(Logic.KWD_FORWARD_GOALS, strategies);
        }
      }
      { Stella_Object s = null;
        Cons iter000 = strategies.reverse();

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          s = iter000.value;
          ControlFrame.pushNextStrategy(frame, ((Keyword)(s)));
        }
      }
      return (Logic.KWD_FAILURE);
    }
  }

  public static Vector findExternalArgumentsForSubgoal(ControlFrame frame) {
    while (!(frame.state == Logic.KWD_ATOMIC_GOAL)) {
      frame = frame.up;
    }
    { Proposition proposition = frame.proposition;
      Vector externalarguments = frame.proposition.arguments;

      if ((proposition.operator == Logic.SGT_PL_KERNEL_KB_MEMBER_OF) &&
          ((((Description)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTION, null))) != null) &&
           ((((Description)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTION, null))).arity() > 1) &&
            Stella_Object.isaP((proposition.arguments.theArray)[0], Logic.SGT_STELLA_LIST)))) {
        externalarguments = Logic.copyListToArgumentsVector(((List)((proposition.arguments.theArray)[0])));
      }
      return (externalarguments);
    }
  }

  public static Description extractSubgoalDescriptionOfFrame(ControlFrame frame) {
    if (((Description)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTION, null))) != null) {
      return (((Description)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTION, null))));
    }
    while (!(frame.state == Logic.KWD_ATOMIC_GOAL)) {
      frame = frame.up;
    }
    return (Logic.getDescription(((Surrogate)(frame.proposition.operator))));
  }

  public static Proposition extractSubgoalOfFrame(ControlFrame frame) {
    while (!(frame.state == Logic.KWD_ATOMIC_GOAL)) {
      frame = frame.up;
    }
    return (frame.proposition);
  }

  public static Keyword tryManufactureSkolemProof(ControlFrame frame) {
    { Proposition proposition = frame.proposition;
      NamedDescription description = Logic.getDescription(((Surrogate)(proposition.operator)));
      Cons argumentvalues = Stella.NIL;

      if ((!Logic.testPropertyP(description, Logic.SGT_PL_KERNEL_KB_TOTAL)) ||
          frame.reversePolarityP) {
        return (Logic.KWD_FAILURE);
      }
      { Stella_Object arg = null;
        Vector vector000 = proposition.arguments;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          argumentvalues = Cons.cons(Logic.argumentBoundTo(arg), argumentvalues);
        }
      }
      { boolean testValue000 = false;

        if (argumentvalues.value != null) {
          testValue000 = true;
        }
        else {
          { boolean foundP000 = false;

            { Stella_Object value = null;
              Cons iter000 = argumentvalues.rest;

              loop001 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                value = iter000.value;
                if (value == null) {
                  foundP000 = true;
                  break loop001;
                }
              }
            }
            testValue000 = foundP000;
          }
        }
        if (testValue000) {
          return (Logic.KWD_FAILURE);
        }
      }
      { Cons inputvalues = argumentvalues.rest.reverse();
        Proposition definingproposition = Logic.findOrCreateFunctionProposition(((Surrogate)(proposition.operator)), inputvalues);

        PatternVariable.bindVariableToValueP(((PatternVariable)((proposition.arguments.theArray)[(proposition.arguments.length() - 1)])), (definingproposition.arguments.theArray)[(definingproposition.arguments.length() - 1)], true);
        return (Logic.KWD_FINAL_SUCCESS);
      }
    }
  }

  public static Keyword tryScanForValueClashProof(ControlFrame frame) {
    { Object old$ReversepolarityP$000 = Logic.$REVERSEPOLARITYp$.get();
      Object old$DontusedefaultknowledgeP$000 = Logic.$DONTUSEDEFAULTKNOWLEDGEp$.get();

      try {
        Native.setBooleanSpecial(Logic.$REVERSEPOLARITYp$, false);
        Native.setBooleanSpecial(Logic.$DONTUSEDEFAULTKNOWLEDGEp$, ((Boolean)(Logic.$DONTUSEDEFAULTKNOWLEDGEp$.get())).booleanValue());
        { Proposition proposition = frame.proposition;
          Iterator clashiterator = Proposition.allClashingPropositions(proposition);
          TruthValue truthvalue = (clashiterator.nextP() ? Logic.propositionsIteratorTruthValue(clashiterator) : ((TruthValue)(null)));

          if ((truthvalue == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
              (truthvalue == Logic.DEFAULT_FALSE_TRUTH_VALUE)) {
            Native.setBooleanSpecial(Logic.$DONTUSEDEFAULTKNOWLEDGEp$, true);
            clashiterator = Proposition.allClashingPropositions(proposition);
            if (clashiterator.nextP()) {
              truthvalue = Logic.propositionsIteratorTruthValue(clashiterator);
            }
          }
          frame.truthValue = TruthValue.invertTruthValue(truthvalue);
          return (((truthvalue != null) ? Logic.KWD_FINAL_SUCCESS : Logic.KWD_FAILURE));
        }

      } finally {
        Logic.$DONTUSEDEFAULTKNOWLEDGEp$.set(old$DontusedefaultknowledgeP$000);
        Logic.$REVERSEPOLARITYp$.set(old$ReversepolarityP$000);
      }
    }
  }

  public static Keyword tryShallowDisproof(ControlFrame frame) {
    { Proposition proposition = frame.proposition;

      if (!Proposition.allArgumentsBoundP(proposition)) {
        return (Logic.KWD_FAILURE);
      }
      else if (ControlFrame.hasShallowDisproofP(frame)) {
        { boolean hasdefaultdisproofP = (frame.truthValue == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
              (frame.truthValue == Logic.DEFAULT_FALSE_TRUTH_VALUE);

          if (hasdefaultdisproofP) {
            ControlFrame.setFrameTruthValue(frame, null);
          }
          return ((hasdefaultdisproofP ? Logic.KWD_FAILURE : Logic.KWD_TERMINAL_FAILURE));
        }
      }
      return (Logic.KWD_FAILURE);
    }
  }

  public static boolean hasShallowDisproofP(ControlFrame frame) {
    { Iterator iterator = ((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, null)));
      Proposition proposition = frame.proposition;
      TruthValue truthvalue = frame.truthValue;
      boolean hasdisproofP = false;

      KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, null, null);
      { Object old$ReversepolarityP$000 = Logic.$REVERSEPOLARITYp$.get();

        try {
          Native.setBooleanSpecial(Logic.$REVERSEPOLARITYp$, !frame.reversePolarityP);
          frame.reversePolarityP = ((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue();
          ControlFrame.setFrameTruthValue(frame, null);
          if ((((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
              (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) &&
              Stella_Object.isaP(((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy, Logic.SGT_LOGIC_WHYNOT_PARTIAL_MATCH)) &&
              (proposition.kind == Logic.KWD_ISA)) {
            if (!((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue()) {
              hasdisproofP = ControlFrame.tryIsaPropositionProof(frame) == Logic.KWD_FINAL_SUCCESS;
            }
            else {
              { NamedDescription queriedtype = Logic.getDescription(proposition.operator);
                Stella_Object instance = Logic.argumentBoundTo((proposition.arguments.theArray)[0]);
                Cons assertedtypes = Stella.NIL;

                if (instance != null) {
                  { Object old$ReversepolarityP$001 = Logic.$REVERSEPOLARITYp$.get();

                    try {
                      Native.setBooleanSpecial(Logic.$REVERSEPOLARITYp$, false);
                      assertedtypes = Logic.allAssertedTypes(instance);

                    } finally {
                      Logic.$REVERSEPOLARITYp$.set(old$ReversepolarityP$001);
                    }
                  }
                  { Stella_Object type = null;
                    Cons iter000 = assertedtypes;

                    loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                      type = iter000.value;
                      if (Description.disjointTermsP(((Description)(type)), queriedtype)) {
                        hasdisproofP = true;
                        ControlFrame.setFrameTruthValue(frame, Logic.TRUE_TRUTH_VALUE);
                        break loop000;
                      }
                    }
                  }
                }
              }
            }
          }
          if (!(hasdisproofP)) {
            hasdisproofP = ControlFrame.tryScanPropositionsProof(frame) == Logic.KWD_FINAL_SUCCESS;
          }
          if ((!hasdisproofP) &&
              (((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue() &&
               ((frame.proposition.kind == Logic.KWD_FUNCTION) ||
                Proposition.singleValuedPredicateP(frame.proposition)))) {
            hasdisproofP = ControlFrame.tryScanForValueClashProof(frame) == Logic.KWD_FINAL_SUCCESS;
          }
          frame.reversePolarityP = !frame.reversePolarityP;

        } finally {
          Logic.$REVERSEPOLARITYp$.set(old$ReversepolarityP$000);
        }
      }
      if (!(hasdisproofP)) {
        frame.truthValue = truthvalue;
      }
      KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, iterator, null);
      return (hasdisproofP);
    }
  }

  public static Keyword tryScanPropositionsProof(ControlFrame frame) {
    { Proposition proposition = frame.proposition;
      boolean allkeyargumentsboundP = false;
      Iterator iterator = ((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, null)));
      Keyword result = Logic.KWD_FAILURE;

      if (iterator == null) {
        allkeyargumentsboundP = Proposition.allArgumentsBoundP(proposition) ||
            Proposition.allKeyArgumentsBoundP(proposition);
        iterator = Proposition.allMatchingPropositions(proposition);
        if (iterator == Logic.EMPTY_PROPOSITIONS_ITERATOR) {
          iterator = null;
        }
        else {
          KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, iterator, null);
        }
        if (((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
            (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) &&
            ((frame.currentStrategy == Logic.KWD_LOOKUP_ASSERTIONS) &&
             ((proposition.arguments.length() > 1) &&
              Logic.nullInstancePropositionsExistP()))) {
          ControlFrame.pushNextStrategy(frame, Logic.KWD_SCAN_PARTIAL_PROPOSITIONS);
        }
      }
      if (iterator != null) {
        loop000 : while (iterator.nextP()) {
          if (Proposition.argumentsUnifyWithArgumentsP(((Proposition)(iterator.value)), proposition)) {
            if (allkeyargumentsboundP &&
                ((!((Boolean)(Logic.$GENERATE_ALL_PROOFSp$.get())).booleanValue()) ||
                 (((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
                (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) &&
                  Stella_Object.isaP(((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy, Logic.SGT_LOGIC_WHYNOT_PARTIAL_MATCH)))) {
              result = Logic.KWD_FINAL_SUCCESS;
              break loop000;
            }
            else {
              result = Logic.KWD_CONTINUING_SUCCESS;
              break loop000;
            }
          }
        }
      }
      if ((result == Logic.KWD_FAILURE) &&
          (frame.reversePolarityP &&
           ((!(frame.currentStrategy == Logic.KWD_SHALLOW_DISPROOF)) &&
            (((proposition.kind == Logic.KWD_FUNCTION) ||
          Proposition.singleValuedPredicateP(proposition)) &&
             Proposition.allArgumentsBoundP(proposition))))) {
        ControlFrame.pushNextStrategy(frame, Logic.KWD_SCAN_FOR_VALUE_CLASH);
      }
      if (!(result == Logic.KWD_FAILURE)) {
        { TruthValue truthvalue = Logic.propositionsIteratorTruthValue(iterator);
          Proposition matchingProposition = ((Proposition)(iterator.value));
          double weight = ((FloatWrapper)(KeyValueList.dynamicSlotValue(matchingProposition.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, Stella.NULL_FLOAT_WRAPPER))).wrapperValue;

          if ((truthvalue == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
              (truthvalue == Logic.DEFAULT_FALSE_TRUTH_VALUE)) {
            { Object old$DontusedefaultknowledgeP$000 = Logic.$DONTUSEDEFAULTKNOWLEDGEp$.get();

              try {
                Native.setBooleanSpecial(Logic.$DONTUSEDEFAULTKNOWLEDGEp$, true);
                iterator = Proposition.allMatchingPropositions(proposition);
                if (iterator.nextP()) {
                  truthvalue = Logic.propositionsIteratorTruthValue(iterator);
                  matchingProposition = ((Proposition)(iterator.value));
                  weight = ((FloatWrapper)(KeyValueList.dynamicSlotValue(matchingProposition.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, Stella.NULL_FLOAT_WRAPPER))).wrapperValue;
                }

              } finally {
                Logic.$DONTUSEDEFAULTKNOWLEDGEp$.set(old$DontusedefaultknowledgeP$000);
              }
            }
          }
          frame.truthValue = truthvalue;
          if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue()) {
            { Justification fj = null;
              Cons iter000 = matchingProposition.forwardJustifications().theConsList;

              loop001 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                fj = ((Justification)(iter000.value));
                frame.justifications.push(fj);
                break loop001;
              }
            }
            { Justification subsetJustification = Proposition.createSubsetJustification(proposition, matchingProposition);

              if (subsetJustification != null) {
                frame.justifications.push(subsetJustification);
              }
            }
          }
          if (frame.partialMatchFrame != null) {
            if (weight == Stella.NULL_FLOAT) {
              weight = 1.0;
            }
            frame.partialMatchFrame.setFramePartialTruth(truthvalue, truthvalue.positiveScore * weight, Stella.NULL_FLOAT, true);
          }
        }
      }
      return (result);
    }
  }

  public static Keyword tryLookupGroundAssertionsProof(ControlFrame frame) {
    if (frame.proposition.kind == Logic.KWD_ISA) {
      if (((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue()) {
        return (ControlFrame.tryScanPropositionsProof(frame));
      }
      return (ControlFrame.tryIsaPropositionProof(frame));
    }
    else {
      return (ControlFrame.tryScanPropositionsProof(frame));
    }
  }

  public static Keyword tryGoalCachesProof(ControlFrame frame) {
    if (((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, null))) == null) {
      { Proposition proposition = frame.proposition;
        Keyword cachedresult = ControlFrame.lookupCachedProof(frame);

        if (!(cachedresult == Logic.KWD_FAILURE)) {
          return (cachedresult);
        }
        if (Proposition.allArgumentsBoundP(proposition) ||
            ((!((Logic.$CACHE_SUCCEEDED_GOALSp$ ||
            Logic.$CACHE_FAILED_GOALSp$) &&
            ((Logic.$DUPLICATE_SUBGOAL_STRATEGY$ == Logic.KWD_DUPLICATE_GOALS) &&
             (!((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
            (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)))))) ||
             (Proposition.getGoalCacheList(proposition) == null))) {
          return (Logic.KWD_FAILURE);
        }
      }
    }
    if (Proposition.allKeyArgumentsBoundP(frame.proposition)) {
      if (ControlFrame.scanCachedGoals(frame) == Logic.KWD_FAILURE) {
        return (Logic.KWD_FAILURE);
      }
      else {
        return (Logic.KWD_FINAL_SUCCESS);
      }
    }
    return (Logic.KWD_FAILURE);
  }

  public static Keyword scanCachedGoals(ControlFrame frame) {
    { Proposition proposition = frame.proposition;
      Iterator iterator = ((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, null)));
      AtomicGoalCache cachedgoal = null;
      PatternRecord patternrecord = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord;
      int ubstackoffset = patternrecord.topUnbindingStackOffset;

      if (!((BooleanWrapper)(KeyValueList.dynamicSlotValue(Logic.surrogateToDescription(((Surrogate)(proposition.operator))).dynamicSlots, Logic.SYM_LOGIC_CHECK_FOR_CACHED_GOALSp, Stella.FALSE_WRAPPER))).wrapperValue) {
        return (Logic.KWD_FAILURE);
      }
      if (iterator == null) {
        iterator = ((Iterator)(KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, ControlFrame.allCachedPropositions(frame), null)));
      }
      while (iterator.nextP()) {
        cachedgoal = ((AtomicGoalCache)(iterator.value));
        { boolean alwaysP000 = true;

          { Stella_Object arg = null;
            Vector vector000 = proposition.arguments;
            int index000 = 0;
            int length000 = vector000.length();
            Stella_Object cachedbinding = null;
            Cons iter000 = cachedgoal.bindings;

            loop001 : for (;(index000 < length000) &&
                      (!(iter000 == Stella.NIL)); index000 = index000 + 1, iter000 = iter000.rest) {
              arg = (vector000.theArray)[index000];
              cachedbinding = iter000.value;
              if (!Logic.bindArgumentToValueP(arg, cachedbinding, true)) {
                alwaysP000 = false;
                break loop001;
              }
            }
          }
          if (alwaysP000) {
            return (AtomicGoalCache.finishCachedGoalProcessing(cachedgoal, frame, Logic.KWD_SUCCESS, true));
          }
        }
        PatternRecord.unbindVariablesBeginningAt(patternrecord, ubstackoffset + 1);
      }
      return (Logic.KWD_FAILURE);
    }
  }

  public static Keyword lookupCachedProof(ControlFrame frame) {
    if ((!((BooleanWrapper)(KeyValueList.dynamicSlotValue(Logic.surrogateToDescription(((Surrogate)(frame.proposition.operator))).dynamicSlots, Logic.SYM_LOGIC_CHECK_FOR_CACHED_GOALSp, Stella.FALSE_WRAPPER))).wrapperValue) ||
        (!((Logic.$CACHE_SUCCEEDED_GOALSp$ ||
        Logic.$CACHE_FAILED_GOALSp$) &&
        ((Logic.$DUPLICATE_SUBGOAL_STRATEGY$ == Logic.KWD_DUPLICATE_GOALS) &&
         (!((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
        (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null))))))) {
      return (Logic.KWD_FAILURE);
    }
    { Keyword successorfailure = Logic.KWD_FAILURE;
      AtomicGoalCache cachedgoal = ControlFrame.findCachedGoal(frame, successorfailure);

      if (cachedgoal == null) {
        successorfailure = Logic.KWD_SUCCESS;
        cachedgoal = ControlFrame.findCachedGoal(frame, successorfailure);
      }
      if ((cachedgoal != null) &&
          ((!((Boolean)(Logic.$DONTUSEDEFAULTKNOWLEDGEp$.get())).booleanValue()) ||
           ((cachedgoal.truthValue == Logic.TRUE_TRUTH_VALUE) ||
            (cachedgoal.truthValue == Logic.FALSE_TRUTH_VALUE)))) {
        return (AtomicGoalCache.finishCachedGoalProcessing(cachedgoal, frame, successorfailure, false));
      }
      else {
        return (Logic.KWD_FAILURE);
      }
    }
  }

  public static Keyword continueSpecialistProof(ControlFrame frame, Keyword lastmove) {
    { Proposition proposition = frame.proposition;
      NamedDescription description = Logic.getDescription(((Surrogate)(proposition.operator)));
      java.lang.reflect.Method specialistcode = NamedDescription.lookupSpecialist(description);
      Keyword result = Logic.KWD_FAILURE;

      if ((specialistcode != null) &&
          NamedDescription.specialistApplicableP(description, proposition)) {
        if (Logic.$POWERLOOM_EXECUTION_MODE$ == Logic.KWD_DEBUG) {
          result = ((Keyword)(edu.isi.stella.javalib.Native.funcall(specialistcode, null, new java.lang.Object [] {frame, lastmove})));
        }
        else {
          try {
            result = ((Keyword)(edu.isi.stella.javalib.Native.funcall(specialistcode, null, new java.lang.Object [] {frame, lastmove})));
          } catch (java.lang.Exception ne) {
            {
              Stella.STANDARD_WARNING.nativeStream.println("Warning: Exception executing specialist for `" + description + "': ");
              Stella.STANDARD_WARNING.nativeStream.println("`" + ne + "'");
            }
;
          }
        }
        if (frame.truthValue == null) {
          if ((result == Logic.KWD_FINAL_SUCCESS) ||
              (result == Logic.KWD_CONTINUING_SUCCESS)) {
            ControlFrame.setFrameTruthValue(frame, Logic.TRUE_TRUTH_VALUE);
          }
          else {
          }
        }
      }
      return (result);
    }
  }

  public static ControlFrame createSubgoalFrame(ControlFrame upframe, Proposition goal, Keyword strategy) {
    { ControlFrame downframe = ControlFrame.createDownFrame(upframe, goal);

      if (strategy != null) {
        if ((goal != null) &&
            (!(goal == upframe.proposition))) {
          downframe.state = Logic.KWD_ATOMIC_GOAL;
        }
        else {
          downframe.state = Logic.KWD_STRATEGY;
        }
        downframe.currentStrategy = strategy;
      }
      downframe.reversePolarityP = upframe.reversePolarityP;
      return (downframe);
    }
  }

  public static void pushNextStrategy(ControlFrame frame, Keyword strategy) {
    frame.nextStrategies = Cons.cons(strategy, frame.nextStrategies);
  }

  public static Keyword tryParallelThreadProof(ControlFrame frame) {
    { ParallelThread childthread = ParallelControlFrame.createChildThread(((ParallelControlFrame)(frame)));

      ParallelControlFrame.enterParallelThread(((ParallelControlFrame)(frame)), childthread);
      return (Logic.KWD_MOVE_DOWN);
    }
  }

  public static Keyword executeProofStrategy(ControlFrame frame) {
    { Keyword testValue000 = frame.currentStrategy;

      if (testValue000 == Logic.KWD_SPECIALIST) {
        return (ControlFrame.continueSpecialistProof(frame, Logic.KWD_DOWN));
      }
      else if (testValue000 == Logic.KWD_LOOKUP_GOAL_CACHES) {
        return (ControlFrame.tryGoalCachesProof(frame));
      }
      else if (testValue000 == Logic.KWD_LOOKUP_ASSERTIONS) {
        return (ControlFrame.tryLookupGroundAssertionsProof(frame));
      }
      else if (testValue000 == Logic.KWD_SCAN_PROPOSITIONS) {
        return (ControlFrame.tryScanPropositionsProof(frame));
      }
      else if (testValue000 == Logic.KWD_SCAN_PARTIAL_PROPOSITIONS) {
        return (ControlFrame.tryScanPartialPropositionsProof(frame));
      }
      else if (testValue000 == Logic.KWD_SCAN_COLLECTION) {
        return (ControlFrame.tryScanCollectionProof(frame));
      }
      else if (testValue000 == Logic.KWD_SHALLOW_DISPROOF) {
        return (ControlFrame.tryShallowDisproof(frame));
      }
      else if (testValue000 == Logic.KWD_SCAN_FOR_VALUE_CLASH) {
        return (ControlFrame.tryScanForValueClashProof(frame));
      }
      else if (testValue000 == Logic.KWD_MANUFACTURE_SKOLEM) {
        return (ControlFrame.tryManufactureSkolemProof(frame));
      }
      else if (testValue000 == Logic.KWD_ALL_SUBGOAL_STRATEGIES) {
        return (ControlFrame.trySubgoalStrategiesProof(frame));
      }
      else if (testValue000 == Logic.KWD_ANTECEDENTS) {
        if (frame.partialMatchFrame != null) {
          return (frame.partialMatchFrame.continuePartialAntecedentsProof(Logic.KWD_DOWN));
        }
        else {
          return (ControlFrame.continueAntecedentsProof(frame, Logic.KWD_DOWN));
        }
      }
      else if (testValue000 == Logic.KWD_FULL_SUBQUERY) {
        return (ControlFrame.tryFullSubqueryProof(frame));
      }
      else if (testValue000 == Logic.KWD_GOAL_COMPLEMENT) {
        return (ControlFrame.tryGoalComplementProof(frame));
      }
      else if (testValue000 == Logic.KWD_CONDITIONAL_ANTECEDENT) {
        return (ControlFrame.continueConditionalAntecedentProof(frame, Logic.KWD_DOWN));
      }
      else if (testValue000 == Logic.KWD_FORWARD_GOALS) {
        return (ControlFrame.tryForwardGoalsProof(frame));
      }
      else if (testValue000 == Logic.KWD_IMPLIES) {
        return (ControlFrame.tryImpliesProof(frame));
      }
      else if (testValue000 == Logic.KWD_CONTAINED_BY) {
        return (ControlFrame.tryContainedByProof(frame));
      }
      else if (testValue000 == Logic.KWD_EQUIVALENCE) {
        return (ControlFrame.tryEquivalenceProof(frame));
      }
      else if (testValue000 == Logic.KWD_CLUSTERED_CONJUNCTION) {
        return (ControlFrame.continueClusteredConjunctionProof(frame, Logic.KWD_DOWN));
      }
      else if (testValue000 == Logic.KWD_DISJUNCTIVE_IMPLICATION_INTRODUCTION) {
        return (ControlFrame.tryDisjunctiveImplicationProof(frame));
      }
      else if (testValue000 == Logic.KWD_UNIVERSAL_INTRODUCTION) {
        return (ControlFrame.tryUniversalIntroductionProof(frame));
      }
      else if (testValue000 == Logic.KWD_SUBSUMPTION_TEST) {
        return (ControlFrame.trySubsumptionTest(frame));
      }
      else if (testValue000 == Logic.KWD_REFUTATION) {
        return (ControlFrame.tryRefutationProof(frame));
      }
      else if (testValue000 == Logic.KWD_SELECT_PARALLEL_THREAD) {
        return (ControlFrame.tryParallelThreadProof(frame));
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static Keyword resumeProofStrategyAfterSubgoal(ControlFrame frame, Keyword lastmove) {
    { Keyword result = null;

      { Keyword testValue000 = frame.currentStrategy;

        if (testValue000 == Logic.KWD_SPECIALIST) {
          result = ControlFrame.continueSpecialistProof(frame, lastmove);
        }
        else if (testValue000 == Logic.KWD_ANTECEDENTS) {
          if (frame.partialMatchFrame != null) {
            result = frame.partialMatchFrame.continuePartialAntecedentsProof(lastmove);
          }
          else {
            result = ControlFrame.continueAntecedentsProof(frame, lastmove);
          }
        }
        else if (testValue000 == Logic.KWD_CLUSTERED_CONJUNCTION) {
          result = ControlFrame.continueClusteredConjunctionProof(frame, lastmove);
        }
        else if (testValue000 == Logic.KWD_CONDITIONAL_ANTECEDENT) {
          result = ControlFrame.continueConditionalAntecedentProof(frame, lastmove);
        }
        else if (testValue000 == Logic.KWD_DISJUNCTIVE_IMPLICATION_INTRODUCTION) {
          result = ControlFrame.resumeDisjunctiveImplicationProof(frame, lastmove);
        }
        else {
          ControlFrame.propagateFrameTruthValue(frame.result, frame);
          if (frame.result.partialMatchFrame != null) {
            frame.result.partialMatchFrame.propagateFramePartialTruth(frame);
          }
          if (lastmove == Logic.KWD_UP_TRUE) {
            if (frame.down != null) {
              result = Logic.KWD_CONTINUING_SUCCESS;
            }
            else {
              result = Logic.KWD_FINAL_SUCCESS;
            }
          }
          else if (lastmove == Logic.KWD_UP_FAIL) {
            if ((frame.truthValue == Logic.FALSE_TRUTH_VALUE) ||
                (frame.truthValue == Logic.DEFAULT_FALSE_TRUTH_VALUE)) {
              result = Logic.KWD_TERMINAL_FAILURE;
            }
            else {
              result = Logic.KWD_FAILURE;
            }
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + lastmove + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }
      }
      if (result == Logic.KWD_CONTINUING_SUCCESS) {
        if (((Boolean)(Logic.$GENERATE_ALL_PROOFSp$.get())).booleanValue() &&
            ((frame.state == Logic.KWD_ATOMIC_GOAL) &&
             ((!((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
            (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null))) &&
              (!ControlFrame.newBindingsSinceLastChoicePointP(frame))))) {
          frame.justifications.push(Logic.KWD_DUMMY_JUSTIFICATION);
          result = Logic.KWD_MOVE_DOWN;
        }
      }
      else if ((result == Logic.KWD_FINAL_SUCCESS) ||
          (result == Logic.KWD_TERMINAL_FAILURE)) {
        frame.nextStrategies = Stella.NIL;
        frame.currentStrategy = null;
        if (result == Logic.KWD_TERMINAL_FAILURE) {
          result = Logic.KWD_FAILURE;
        }
      }
      else if (result == Logic.KWD_FAILURE) {
        frame.currentStrategy = null;
      }
      else if ((result == Logic.KWD_MOVE_DOWN) ||
          (result == Logic.KWD_MOVE_IN_PLACE)) {
      }
      else {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("`" + result + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
      return (result);
    }
  }

  public static Keyword continueCurrentOrNextStrategy(ControlFrame frame) {
    { Keyword result = null;

      for (;;) {
        frame = ControlFrame.selectNextStrategy(frame);
        if (frame.currentStrategy == null) {
          if ((Stella.$TRACED_KEYWORDS$ != null) &&
              Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_STRATEGIES)) {
            Stella.STANDARD_OUTPUT.nativeStream.println();
          }
          if (frame.justifications.nonEmptyP()) {
            return (Logic.KWD_FINAL_SUCCESS);
          }
          else {
            return (Logic.KWD_FAILURE);
          }
        }
        if ((Stella.$TRACED_KEYWORDS$ != null) &&
            Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_STRATEGIES)) {
          Stella.STANDARD_OUTPUT.nativeStream.print(" " + frame.currentStrategy);
          OutputStream.flushOutput(Stella.STANDARD_OUTPUT);
        }
        if (Stella_Object.traceKeywordP(Logic.KWD_STRATEGIES)) {
          { Description description = ((Description)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTION, null)));

            if ((description != null) &&
                Description.namedDescriptionP(description)) {
              Stella.STANDARD_OUTPUT.nativeStream.print("(" + description.surrogateValueInverse.symbolName + ")");
            }
          }
        }
        if (frame.reversePolarityP) {
          { Object old$ReversepolarityP$000 = Logic.$REVERSEPOLARITYp$.get();

            try {
              Native.setBooleanSpecial(Logic.$REVERSEPOLARITYp$, true);
              result = ControlFrame.executeProofStrategy(frame);

            } finally {
              Logic.$REVERSEPOLARITYp$.set(old$ReversepolarityP$000);
            }
          }
        }
        else {
          result = ControlFrame.executeProofStrategy(frame);
        }
        if (result == Logic.KWD_TERMINAL_FAILURE) {
          frame.nextStrategies = Stella.NIL;
          result = Logic.KWD_FAILURE;
        }
        else if ((result == Logic.KWD_MOVE_DOWN) ||
            ((result == Logic.KWD_MOVE_IN_PLACE) ||
             (result == Logic.KWD_TIME_OUT))) {
          if ((Stella.$TRACED_KEYWORDS$ != null) &&
              Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_STRATEGIES)) {
            Stella.STANDARD_OUTPUT.nativeStream.println();
          }
          return (result);
        }
        else {
        }
        ControlFrame.recordBasePartialMatchTruth(frame, result);
        if (Stella_Object.traceKeywordP(Logic.KWD_STRATEGIES)) {
          if (result == Logic.KWD_FAILURE) {
            Stella.STANDARD_OUTPUT.nativeStream.print(" ");
          }
          else {
            Stella.STANDARD_OUTPUT.nativeStream.println();
          }
        }
        if (result == Logic.KWD_FAILURE) {
          frame.currentStrategy = null;
        }
        else {
          return (result);
        }
      }
    }
  }

  public static void recordBasePartialMatchTruth(ControlFrame frame, Keyword result) {
    { Keyword pmresult = (((result == Logic.KWD_FAILURE) ||
          frame.reversePolarityP) ? Logic.KWD_FAIL : Logic.KWD_TRUE);

      if ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
          (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) {
        ((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy.setBasePartialMatchTruth(frame.proposition, pmresult);
      }
    }
  }

  public static ControlFrame selectNextStrategy(ControlFrame frame) {
    { Keyword strategy = null;

      if (frame.currentStrategy != null) {
        strategy = frame.currentStrategy;
      }
      else if (frame.state == Logic.KWD_PARALLEL_STRATEGIES) {
        strategy = Logic.KWD_SELECT_PARALLEL_THREAD;
      }
      else {
        loop000 : for (;;) {
          strategy = ((Keyword)(frame.nextStrategies.value));
          if (strategy == null) {
            return (frame);
          }
          frame.nextStrategies = frame.nextStrategies.rest;
          if (Logic.filterOutStrategyP(strategy, frame)) {
            continue loop000;
          }
          if (Logic.parallelStrategyP(strategy)) {
            frame = ControlFrame.parallelizeControlFrame(frame);
            frame.nextStrategies = Cons.cons(strategy, frame.nextStrategies);
            strategy = Logic.KWD_SELECT_PARALLEL_THREAD;
          }
          ControlFrame.clearStrategySlots(frame);
          break loop000;
        }
      }
      frame.currentStrategy = strategy;
      return (frame);
    }
  }

  public static void clearStrategySlots(ControlFrame frame) {
    if (((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, null))) != null) {
      KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, null, null);
    }
    if (((Proposition)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_ANTECEDENTS_RULE, null))) != null) {
      KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_ANTECEDENTS_RULE, null, null);
    }
    if (((ProofAdjunct)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_PROOF_ADJUNCT, null))) != null) {
      KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_PROOF_ADJUNCT, null, null);
    }
  }

  public static Keyword continueStrategiesProofs(ControlFrame frame, Keyword lastmove) {
    { Keyword result = null;

      if (lastmove == Logic.KWD_DOWN) {
        ControlFrame.unwindToChoicePoint(frame);
        frame.justifications.clear();
        if (frame.down != null) {
          return (Logic.KWD_MOVE_DOWN);
        }
      }
      else if ((lastmove == Logic.KWD_UP_TRUE) ||
          (lastmove == Logic.KWD_UP_FAIL)) {
        result = ControlFrame.resumeProofStrategyAfterSubgoal(frame, lastmove);
        if (result == Logic.KWD_FAILURE) {
          result = null;
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + lastmove + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      loop000 : for (;;) {
        if (result == null) {
          result = ControlFrame.continueCurrentOrNextStrategy(frame);
        }
        if ((result == Logic.KWD_FINAL_SUCCESS) ||
            (result == Logic.KWD_CONTINUING_SUCCESS)) {
          if ((frame.proposition != null) &&
              (((frame.truthValue == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
              (frame.truthValue == Logic.DEFAULT_FALSE_TRUTH_VALUE)) &&
               ControlFrame.hasShallowDisproofP(frame))) {
            if (Stella_Object.traceKeywordP(Logic.KWD_GOAL_TREE)) {
              { TruthValue truthvalue = frame.truthValue;
                boolean defaultP = (truthvalue == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
                    (truthvalue == Logic.DEFAULT_FALSE_TRUTH_VALUE);

                Logic.printVerticalBars(ControlFrame.computeFrameDepth(frame) + 1);
                Stella.STANDARD_OUTPUT.nativeStream.println("CLSH: truth=" + TruthValue.truthValueToString(truthvalue, true));
              }
            }
            ControlFrame.unwindToChoicePoint(frame);
            if ((!((frame.truthValue == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
                (frame.truthValue == Logic.DEFAULT_FALSE_TRUTH_VALUE))) &&
                Proposition.allArgumentsBoundP(frame.proposition)) {
              result = Logic.KWD_FAILURE;
            }
            else {
              ControlFrame.setFrameTruthValue(frame, null);
              frame.justifications.clear();
              if (frame.partialMatchFrame != null) {
                frame.partialMatchFrame.clearFramePartialTruth();
              }
              if (frame.down != null) {
                result = Logic.KWD_MOVE_DOWN;
              }
              else {
                result = null;
                continue loop000;
              }
            }
          }
        }
        else {
        }
        if ((result == Logic.KWD_CONTINUING_SUCCESS) ||
            (result == Logic.KWD_FINAL_SUCCESS)) {
          if (frame.truthValue == null) {
            ControlFrame.setFrameTruthValue(frame, Logic.TRUE_TRUTH_VALUE);
          }
          if (((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
              (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) &&
              (!((frame.partialMatchFrame != null) &&
              ((frame.partialMatchFrame.positiveScore != Stella.NULL_FLOAT) ||
               (frame.partialMatchFrame.negativeScore != Stella.NULL_FLOAT))))) {
            frame.partialMatchFrame.setFramePartialTruth(Logic.TRUE_TRUTH_VALUE, Stella.NULL_FLOAT, Stella.NULL_FLOAT, false);
          }
          if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue() &&
              (((Justification)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null))) == null)) {
            ControlFrame.recordPrimitiveJustification(frame, Logic.KWD_UP_TRUE);
          }
        }
        else if ((result == Logic.KWD_FAILURE) ||
            (result == Logic.KWD_TERMINAL_FAILURE)) {
          if ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
              (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) {
            {
              if (!((frame.partialMatchFrame != null) &&
                  ((frame.partialMatchFrame.positiveScore != Stella.NULL_FLOAT) ||
                   (frame.partialMatchFrame.negativeScore != Stella.NULL_FLOAT)))) {
                frame.partialMatchFrame.setFramePartialTruth(frame.truthValue, ((frame.truthValue != null) ? Stella.NULL_FLOAT : 0.0), Stella.NULL_FLOAT, frame.truthValue != null);
              }
              if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue() &&
                  (((Justification)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null))) == null)) {
                ControlFrame.recordPrimitiveJustification(frame, Logic.KWD_UP_FAIL);
              }
            }
          }
          else {
            if (((frame.truthValue == Logic.UNKNOWN_TRUTH_VALUE) ||
                (frame.truthValue == null)) &&
                ((((Keyword)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_INFERENCE_CUTOFF_REASON, null))) == null) &&
                 ((frame.proposition != null) &&
                  Proposition.closedPropositionP(frame.proposition)))) {
              ControlFrame.setFrameTruthValue(frame, Logic.FALSE_TRUTH_VALUE);
              if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue() &&
                  (((Justification)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null))) == null)) {
                ControlFrame.recordClosedNotJustification(frame, Logic.KWD_UP_FAIL);
              }
            }
          }
        }
        else {
        }
        return (result);
      }
    }
  }

  public static AtomicGoalCacheIterator allCachedPropositions(ControlFrame goal) {
    { Proposition proposition = goal.proposition;
      GeneralizedSymbol operator = proposition.operator;
      AtomicGoalCache cachelist = Proposition.getGoalCacheList(proposition);

      while ((cachelist != null) &&
          (!(cachelist.proposition.operator == operator))) {
        cachelist = cachelist.next;
      }
      Proposition.setGoalCacheList(proposition, cachelist);
      { AtomicGoalCacheIterator self000 = AtomicGoalCacheIterator.newAtomicGoalCacheIterator();

        self000.goal = goal;
        self000.cacheList = cachelist;
        { AtomicGoalCacheIterator value000 = self000;

          return (value000);
        }
      }
    }
  }

  public static AtomicGoalCache findCachedGoal(ControlFrame frame, Keyword successorfailure) {
    if (frame.state == Logic.KWD_ATOMIC_GOAL) {
      { Keyword testValue000 = frame.proposition.kind;

        if ((testValue000 == Logic.KWD_ISA) ||
            ((testValue000 == Logic.KWD_PREDICATE) ||
             (testValue000 == Logic.KWD_FUNCTION))) {
          { AtomicGoalCache cachedgoal = null;

            if (successorfailure == Logic.KWD_SUCCESS) {
              if (!Logic.$CACHE_SUCCEEDED_GOALSp$) {
                return (null);
              }
              cachedgoal = ((AtomicGoalCache)((Logic.$SUCCEEDED_GOALS_CACHE$.theArray)[((((ControlFrame.goalHashCode(frame)) & 0x7FFFFFFF) % 1541))]));
              if ((cachedgoal != null) &&
                  (AtomicGoalCache.cacheMatchesGoalP(cachedgoal, frame, true, Logic.KWD_GOAL_INSTANTIATES_CACHE) &&
                   ((!((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue()) ||
                    (cachedgoal.justification != null)))) {
                return (cachedgoal);
              }
            }
            else if (successorfailure == Logic.KWD_FAILURE) {
              if ((!Logic.$CACHE_FAILED_GOALSp$) ||
                  frame.dontCacheGoalFailureP) {
                return (null);
              }
              cachedgoal = ((AtomicGoalCache)((Logic.$FAILED_GOALS_CACHE$.theArray)[((((ControlFrame.goalHashCode(frame)) & 0x7FFFFFFF) % 1541))]));
              if ((cachedgoal != null) &&
                  AtomicGoalCache.cacheMatchesGoalP(cachedgoal, frame, false, Logic.KWD_GOAL_INSTANTIATES_CACHE)) {
                return (cachedgoal);
              }
            }
            else {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("`" + successorfailure + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
        else {
        }
      }
    }
    return (null);
  }

  public static void cacheGoal(ControlFrame frame, boolean successP, boolean keepframeP, int clockticks) {
    keepframeP = keepframeP;
    if (frame.state == Logic.KWD_ATOMIC_GOAL) {
      if (frame.goalBindings == null) {
        return;
      }
      { Stella_Object binding = null;
        Cons iter000 = frame.goalBindings;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          binding = iter000.value;
          if (binding != null) {
            if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(binding), Logic.SGT_LOGIC_DESCRIPTION)) {
              { Description binding000 = ((Description)(binding));

                if (((Vector)(KeyValueList.dynamicSlotValue(binding000.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null))) != null) {
                  return;
                }
              }
            }
            else {
            }
          }
        }
      }
      if (successP) {
        frame.dontCacheGoalFailureP = true;
      }
      if (frame.cachedGoalResultP) {
        return;
      }
      if (((clockticks - frame.startingClockTicks) >= Logic.$CACHE_GOAL_QUANTUM$) ||
          (false &&
           Logic.testPropertyP(Logic.surrogateToDescription(((Surrogate)(frame.proposition.operator))), Logic.SGT_PL_KERNEL_KB_FRAME_PREDICATE))) {
        { Keyword testValue000 = frame.proposition.kind;

          if ((testValue000 == Logic.KWD_ISA) ||
              ((testValue000 == Logic.KWD_PREDICATE) ||
               (testValue000 == Logic.KWD_FUNCTION))) {
            if (Stella.getQuotedTree("((/PL-KERNEL-KB/@FORK /PL-KERNEL-KB/@COLLECT-INTO-SET) \"/LOGIC\")", "/LOGIC").memberP(frame.proposition.operator)) {
              return;
            }
            if (Stella_Object.traceKeywordP(Logic.KWD_GOAL_CACHES)) {
              Stella.STANDARD_OUTPUT.nativeStream.println("=========> CACHED " + ((successP ? "SUCCESS" : "FAILURE")) + " AT " + (((ControlFrame.goalHashCode(frame)) & 0x7FFFFFFF) % 1541) + ": " + frame.proposition);
            }
            Logic.updateNowTimestamp(Logic.KWD_EXECUTE_QUERY);
            KeyValueList.setDynamicSlotValue(Logic.surrogateToDescription(((Surrogate)(frame.proposition.operator))).dynamicSlots, Logic.SYM_LOGIC_CHECK_FOR_CACHED_GOALSp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
            { int index = Stella.NULL_INTEGER;
              AtomicGoalCache cachedgoal = null;

              if (successP) {
                if (!Logic.$CACHE_SUCCEEDED_GOALSp$) {
                  return;
                }
                index = (((ControlFrame.goalHashCode(frame)) & 0x7FFFFFFF) % 1541);
                cachedgoal = ((AtomicGoalCache)((Logic.$SUCCEEDED_GOALS_CACHE$.theArray)[index]));
                if ((cachedgoal == null) ||
                    ((!AtomicGoalCache.cacheMatchesGoalP(cachedgoal, frame, true, Logic.KWD_GOAL_INSTANTIATES_CACHE)) ||
                     (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue() &&
                      (cachedgoal.justification == null)))) {
                  (Logic.$SUCCEEDED_GOALS_CACHE$.theArray)[index] = (ControlFrame.createAtomicGoalCache(frame, cachedgoal, true));
                }
                else if (cachedgoal != null) {
                  cachedgoal.truthValue = TruthValue.strengthenTruthValue(cachedgoal.truthValue, frame.truthValue);
                }
              }
              else {
                if ((!Logic.$CACHE_FAILED_GOALSp$) ||
                    frame.dontCacheGoalFailureP) {
                  return;
                }
                index = (((ControlFrame.goalHashCode(frame)) & 0x7FFFFFFF) % 1541);
                cachedgoal = ((AtomicGoalCache)((Logic.$FAILED_GOALS_CACHE$.theArray)[index]));
                if ((cachedgoal == null) ||
                    (!AtomicGoalCache.cacheMatchesGoalP(cachedgoal, frame, false, Logic.KWD_GOAL_INSTANTIATES_CACHE))) {
                  (Logic.$FAILED_GOALS_CACHE$.theArray)[index] = (ControlFrame.createAtomicGoalCache(frame, cachedgoal, false));
                }
              }
            }
          }
          else {
          }
        }
      }
    }
  }

  public static void dontCacheGoalFailureBetweenFrames(ControlFrame topframe, ControlFrame bottomframe) {
    for (;;) {
      topframe.dontCacheGoalFailureP = true;
      if (topframe == bottomframe) {
        return;
      }
      topframe = topframe.up;
    }
  }

  public static boolean goalInstantiatesCacheP(ControlFrame goal, AtomicGoalCache cache, boolean successP) {
    return (AtomicGoalCache.cacheMatchesGoalP(cache, goal, successP, Logic.KWD_GOAL_INSTANTIATES_CACHE));
  }

  public static AtomicGoalCache createAtomicGoalCache(ControlFrame frame, AtomicGoalCache cache, boolean successP) {
    { boolean collisionP = cache != null;
      Proposition proposition = frame.proposition;

      if (!collisionP) {
        cache = AtomicGoalCache.newAtomicGoalCache();
      }
      if (successP) {
        if (collisionP) {
          if (cache.next != null) {
            cache.next.previous = cache.previous;
          }
          if (cache.previous == null) {
            Proposition.setGoalCacheList(cache.proposition, cache.next);
          }
          else {
            cache.previous.next = cache.next;
          }
          cache.previous = null;
          cache.next = null;
        }
        { AtomicGoalCache previousstart = Proposition.getGoalCacheList(proposition);

          if (!(cache == previousstart)) {
            if (previousstart != null) {
              previousstart.previous = cache;
              cache.next = previousstart;
            }
          }
        }
        Proposition.setGoalCacheList(proposition, cache);
      }
      cache.goalContext = ((Context)(Stella.$CONTEXT$.get()));
      cache.timestamp = Logic.getNowTimestamp();
      cache.reversePolarityP = frame.reversePolarityP;
      cache.proposition = proposition;
      cache.bindings = Proposition.yieldGoalBindings(proposition);
      cache.justification = (successP ? ((Justification)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null))) : null);
      cache.truthValue = frame.truthValue;
      if ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
          (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) {
        frame.setCachePartialTruth(cache);
      }
      frame.cachedGoalResultP = true;
      return (cache);
    }
  }

  public static int goalHashCode(ControlFrame frame) {
    { Proposition proposition = frame.proposition;
      Surrogate operator = Proposition.cachedGoalOperator(proposition);
      Vector arguments = proposition.arguments;
      int code = 0;

      code = ((Context)(Stella.$CONTEXT$.get())).hashCode_();
      if (frame.reversePolarityP) {
        code = (((((code & 1) == 0) ? (code >>> 1) : (((code >> 1)) | Stella.$INTEGER_MSB_MASK$))) ^ 8312004);
      }
      code = (((((code & 1) == 0) ? (code >>> 1) : (((code >> 1)) | Stella.$INTEGER_MSB_MASK$))) ^ (Stella_Object.safeHashCode(operator)));
      { Stella_Object arg = null;
        Vector vector000 = arguments;
        int index000 = 0;
        int length000 = vector000.length();
        Stella_Object argvalue = null;
        Cons iter000 = frame.goalBindings;

        loop000 : for (;(index000 < length000) &&
                  (!(iter000 == Stella.NIL)); index000 = index000 + 1, iter000 = iter000.rest) {
          arg = (vector000.theArray)[index000];
          argvalue = iter000.value;
          if (argvalue == null) {
            argvalue = (((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord.variableBindings.theArray)[(((PatternVariable)(arg)).boundToOffset)];
            if (argvalue == null) {
              code = PatternVariable.hashUnboundGoalVariable(((PatternVariable)(arg)), arguments, code);
              continue loop000;
            }
          }
          code = Logic.hashGoalArgument(argvalue, code);
        }
      }
      return (code);
    }
  }

  public static int failedGoalIndex(ControlFrame frame) {
    return ((((ControlFrame.goalHashCode(frame)) & 0x7FFFFFFF) % 1541));
  }

  public static int succeededGoalIndex(ControlFrame frame) {
    return ((((ControlFrame.goalHashCode(frame)) & 0x7FFFFFFF) % 1541));
  }

  public static Keyword continueCachedBindingsProof(ControlFrame frame, Keyword lastmove) {
    lastmove = lastmove;
    { Proposition goal = frame.proposition;
      Iterator iterator = ((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_CACHED_BINDINGS_ITERATOR, null)));

      if (iterator == null) {
        { GoalCache goalcache = ControlFrame.findGoalCache(frame);
          List cachedbindings = null;

          if (goalcache == null) {
            ControlFrame.createGoalCacheP(frame);
            return (Logic.KWD_FAILURE);
          }
          cachedbindings = goalcache.cachedBindings;
          switch (cachedbindings.length()) {
            case 0: 
              Logic.traceGoalCache("EMPTY CACHE: ", frame);
              return (Logic.KWD_FAILURE);
            case 1: 
              Logic.traceGoalCache("USED CACHED BINDING: ", frame);
              if (Logic.bindVectorOfArgumentsToValuesP(goal.arguments, ((Cons)(cachedbindings.first())))) {
                return (Logic.KWD_FINAL_SUCCESS);
              }
              else {
                return (Logic.KWD_FAILURE);
              }
            default:
              Logic.traceGoalCache("USED MANY CACHED BINDINGS: ", frame);
              iterator = ((ListIterator)(goalcache.cachedBindings.allocateIterator()));
              KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_CACHED_BINDINGS_ITERATOR, iterator, null);
            break;
          }
        }
      }
      ControlFrame.createChoicePoint(frame);
      while (iterator.nextP()) {
        if (Logic.bindVectorOfArgumentsToValuesP(frame.proposition.arguments, ((Cons)(iterator.value)))) {
          if (iterator.emptyP()) {
            return (Logic.KWD_FINAL_SUCCESS);
          }
          else {
            return (Logic.KWD_CONTINUING_SUCCESS);
          }
        }
      }
      return (Logic.KWD_FAILURE);
    }
  }

  public static Cons yieldRelativeGoalBindings(ControlFrame frame) {
    { Proposition goal = frame.proposition;
      Cons result = Stella.NIL;
      PatternRecord savecurrentpr = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord;

      ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord = ControlFrame.operativePatternRecord(frame);
      { Stella_Object arg = null;
        Vector vector000 = goal.arguments;
        int index000 = 0;
        int length000 = vector000.length();
        Cons collect000 = null;

        for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Logic.argumentBoundTo(arg), Stella.NIL);
              if (result == Stella.NIL) {
                result = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(result, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Logic.argumentBoundTo(arg), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord = savecurrentpr;
      return (result);
    }
  }

  public static void updateGoalCache(ControlFrame frame, boolean successP) {
    if ((!(Logic.$DUPLICATE_SUBGOAL_STRATEGY$ == Logic.KWD_DUPLICATE_GOALS_WITH_CACHING)) ||
        (!successP)) {
      return;
    }
    { GoalCache goalcache = ControlFrame.findGoalCache(frame);

      if (goalcache != null) {
        { List cachedbindings = goalcache.cachedBindings;
          Cons bindings = ControlFrame.yieldRelativeGoalBindings(frame);

          { boolean foundP000 = false;

            { Cons oldbindings = null;
              Cons iter000 = cachedbindings.theConsList;

              loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                oldbindings = ((Cons)(iter000.value));
                { boolean alwaysP000 = true;

                  { Stella_Object v1 = null;
                    Cons iter001 = bindings;
                    Stella_Object v2 = null;
                    Cons iter002 = oldbindings;

                    loop001 : for (;(!(iter001 == Stella.NIL)) &&
                              (!(iter002 == Stella.NIL)); iter001 = iter001.rest, iter002 = iter002.rest) {
                      v1 = iter001.value;
                      v2 = iter002.value;
                      if (!Stella_Object.eqlP(v1, v2)) {
                        alwaysP000 = false;
                        break loop001;
                      }
                    }
                  }
                  if (alwaysP000) {
                    foundP000 = true;
                    break loop000;
                  }
                }
              }
            }
            if (foundP000) {
              return;
            }
          }
          if ((Stella.$TRACED_KEYWORDS$ != null) &&
              Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_CACHES)) {
            Stella.STANDARD_OUTPUT.nativeStream.println("AUGMENT CACHE: " + bindings + "  " + frame);
          }
          cachedbindings.push(bindings);
          ((QueryIterator)(Logic.$QUERYITERATOR$.get())).augmentedGoalCacheP = true;
        }
      }
    }
  }

  public static GoalCache findGoalCache(ControlFrame frame) {
    { Proposition goal = frame.proposition;
      KeyValueList table = Proposition.findGoalCacheTable(goal);
      GoalCache goalcache = null;

      if (table == null) {
        return (null);
      }
      goalcache = Logic.lookupGoalCache(table);
      if ((goalcache != null) &&
          (goalcache.timestamp < Logic.getNowTimestamp())) {
        goalcache.cachedBindings.clear();
        goalcache.timestamp = Logic.getNowTimestamp();
      }
      return (goalcache);
    }
  }

  public static boolean createGoalCacheP(ControlFrame frame) {
    { Proposition goal = frame.proposition;
      KeyValueList table = Proposition.findGoalCacheTable(goal);

      if (table == null) {
        table = KeyValueList.newKeyValueList();
        { Keyword testValue000 = goal.kind;

          if ((testValue000 == Logic.KWD_ISA) ||
              ((testValue000 == Logic.KWD_PREDICATE) ||
               (testValue000 == Logic.KWD_FUNCTION))) {
            if (goal.operator.primaryType() == Logic.SGT_STELLA_SURROGATE) {
              { NamedDescription goaldescription = Logic.getDescription(((Surrogate)(goal.operator)));

                if (((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue()) {
                  KeyValueList.setDynamicSlotValue(goaldescription.dynamicSlots, Logic.SYM_LOGIC_NEGATED_GOAL_CACHE_TABLE, table, null);
                }
                else {
                  KeyValueList.setDynamicSlotValue(goaldescription.dynamicSlots, Logic.SYM_LOGIC_GOAL_CACHE_TABLE, table, null);
                }
              }
            }
            else {
              return (false);
            }
          }
          else {
            return (false);
          }
        }
      }
      { GoalCache goalcache = Logic.lookupGoalCache(table);

        if (goalcache == null) {
          Logic.traceGoalCache("CREATING GOAL CACHE: ", frame);
          goalcache = GoalCache.newGoalCache();
          Logic.removeObsoleteGoalCaches(table);
          table.insertAt(((Context)(Stella.$CONTEXT$.get())), goalcache);
          KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_GOAL_CACHE, goalcache, null);
          goalcache.timestamp = Logic.getNowTimestamp();
          goalcache.proposition = goal;
          goalcache.reversePolarityP = ((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue();
          goalcache.cacheContext = ((Context)(Stella.$CONTEXT$.get()));
          ((QueryIterator)(Logic.$QUERYITERATOR$.get())).activeGoalCaches.insert(goalcache);
          if (Logic.topLevelQueryContextP(((Context)(Stella.$CONTEXT$.get())))) {
            ((QueryIterator)(Logic.$QUERYITERATOR$.get())).augmentedGoalCacheP = true;
          }
        }
        return (true);
      }
    }
  }

  public static Keyword tryScanPartialPropositionsProof(ControlFrame frame) {
    { Proposition proposition = frame.proposition;
      Iterator iterator = ((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, null)));
      Keyword result = Logic.KWD_FAILURE;

      if (iterator == null) {
        iterator = Proposition.allMatchingPartialPropositions(proposition);
        KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, iterator, null);
      }
      if (iterator != null) {
        loop000 : while (iterator.nextP()) {
          if (Proposition.partialArgumentsUnifyWithArgumentsP(((Proposition)(iterator.value)), proposition)) {
            result = Logic.KWD_CONTINUING_SUCCESS;
            break loop000;
          }
        }
      }
      if (!(result == Logic.KWD_FAILURE)) {
        { TruthValue truthvalue = Logic.propositionsIteratorTruthValue(iterator);
          double weight = ((FloatWrapper)(KeyValueList.dynamicSlotValue(((Proposition)(iterator.value)).dynamicSlots, Logic.SYM_LOGIC_WEIGHT, Stella.NULL_FLOAT_WRAPPER))).wrapperValue;

          frame.truthValue = Logic.UNKNOWN_TRUTH_VALUE;
          if (weight == Stella.NULL_FLOAT) {
            weight = 1.0;
          }
          frame.partialMatchFrame.setFramePartialTruth(Logic.UNKNOWN_TRUTH_VALUE, truthvalue.positiveScore * weight, Stella.NULL_FLOAT, true);
        }
      }
      return (result);
    }
  }

  public static boolean computePartialMatchScoreP(ControlFrame frame) {
    { PartialMatchFrame partialmatchframe = frame.partialMatchFrame;
      double score = Stella.NULL_FLOAT;

      { Keyword testValue000 = partialmatchframe.kind;

        if (testValue000 == Logic.KWD_AND) {
          score = partialmatchframe.computeAndScore();
        }
        else if (testValue000 == Logic.KWD_OR) {
          score = partialmatchframe.computeOrScore();
        }
        else if (testValue000 == Logic.KWD_ATOMIC_GOAL) {
          score = partialmatchframe.computeGoalScore();
        }
        else {
        }
      }
      KeyValueList.setDynamicSlotValue(((QueryIterator)(Logic.$QUERYITERATOR$.get())).dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, FloatWrapper.wrapFloat(score), Stella.NULL_FLOAT_WRAPPER);
      partialmatchframe.positiveScore = score;
      KeyValueList.setDynamicSlotValue(frame.proposition.dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, FloatWrapper.wrapFloat(score), Stella.NULL_FLOAT_WRAPPER);
      if (ControlFrame.unboundVariablesInFrameP(frame)) {
        return (false);
      }
      else {
        return (score > Logic.$MINIMUM_SCORE_CUTOFF$);
      }
    }
  }

  public static boolean computePartialMatchOrSuccessP(ControlFrame frame) {
    return (frame.partialMatchFrame.earlyPartialMatchOrSuccessP());
  }

  public static boolean computePartialMatchAndFailureP(ControlFrame frame) {
    return (frame.partialMatchFrame.earlyPartialMatchAndFailureP());
  }

  public static void recordLatestPartialMatchScore(ControlFrame frame) {
    { Proposition prop = null;
      double score = ((FloatWrapper)(KeyValueList.dynamicSlotValue(((QueryIterator)(Logic.$QUERYITERATOR$.get())).dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue;
      PartialMatchFrame pframe = frame.partialMatchFrame;

      { Keyword testValue000 = frame.state;

        if ((testValue000 == Logic.KWD_AND) ||
            (testValue000 == Logic.KWD_OR)) {
          prop = ((Proposition)((frame.proposition.arguments.theArray)[(frame.argumentCursor)]));
        }
        else {
          prop = frame.proposition;
        }
      }
      if ((pframe.kind == Logic.KWD_AND) &&
          (BooleanWrapper.coerceWrappedBooleanToBoolean(prop.variableTypeP()) &&
           (!pframe.successP))) {
        Logic.$AND_MISSED_A_BINDING$ = true;
      }
      if ((pframe.kind == Logic.KWD_AND) &&
          ((score == 0.0) &&
           ((prop.kind == Logic.KWD_FUNCTION) &&
            (Stella_Object.isaP(prop.arguments.last(), Logic.SGT_LOGIC_PATTERN_VARIABLE) &&
             (Logic.argumentBoundTo(prop.arguments.last()) == null))))) {
        pframe.unboundVars = Cons.cons(((PatternVariable)(prop.arguments.last())), pframe.unboundVars);
      }
      pframe.recordPartialMatchScore(((FloatWrapper)(KeyValueList.dynamicSlotValue(((QueryIterator)(Logic.$QUERYITERATOR$.get())).dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue, pframe.propositionWeight(prop));
    }
  }

  public static boolean unboundVariablesInFrameP(ControlFrame frame) {
    return (!(Proposition.getUnboundVariables(frame.proposition) == Stella.NIL));
  }

  public static void createAndLinkPartialMatchFrame(ControlFrame frame, Keyword kind) {
    { PartialMatchFrame strategy = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy;
      PartialMatchFrame partialmatchframe = strategy.createPartialMatchFrame(frame, kind);

      partialmatchframe.kind = kind;
      frame.partialMatchFrame = partialmatchframe;
      partialmatchframe.controlFrame = frame;
    }
  }

  public void setJustificationPartialTruth(Justification justification) {
    { ControlFrame self = this;

      { PartialMatchFrame pmf = self.partialMatchFrame;

        if (pmf != null) {
          pmf.setJustificationPartialTruth(justification);
        }
      }
    }
  }

  public void setCachePartialTruth(AtomicGoalCache cache) {
    { ControlFrame self = this;

      { PartialMatchFrame pmf = self.partialMatchFrame;

        if (pmf != null) {
          pmf.setCachePartialTruth(cache);
        }
      }
    }
  }

  public boolean definedFramePartialTruthP() {
    { ControlFrame self = this;

      return ((self.partialMatchFrame != null) &&
          ((self.partialMatchFrame.positiveScore != Stella.NULL_FLOAT) ||
           (self.partialMatchFrame.negativeScore != Stella.NULL_FLOAT)));
    }
  }

  public static Vector allocateCollectionVariables(ControlFrame frame, Description description) {
    { int variablescount = description.ioVariables.length();
      Vector externalvariables = Vector.newVector(variablescount);

      { PatternVariable iovar = null;
        Vector vector000 = description.ioVariables;
        int index000 = 0;
        int length000 = vector000.length();
        int i = Stella.NULL_INTEGER;
        int iter000 = 0;

        for (;index000 < length000; index000 = index000 + 1, iter000 = iter000 + 1) {
          iovar = ((PatternVariable)((vector000.theArray)[index000]));
          i = iter000;
          (externalvariables.theArray)[i] = (Logic.createVariable(iovar.skolemType, iovar.skolemName, false));
          ((PatternVariable)((externalvariables.theArray)[i])).boundToOffset = i;
        }
      }
      if (frame.patternRecord == null) {
        ControlFrame.createPatternRecord(frame, null, null);
      }
      PatternRecord.activatePatternRecord(frame.patternRecord, variablescount);
      return (externalvariables);
    }
  }

  /** Print stack of goals.  Assumes that query has been interrupted
   * with a full stack of control frames.
   * @param frame
   * @param verboseP
   */
  public static void printGoalStack(ControlFrame frame, boolean verboseP) {
    if (frame.proposition != null) {
      { Object old$Printinframe$000 = Logic.$PRINTINFRAME$.get();

        try {
          Native.setSpecial(Logic.$PRINTINFRAME$, frame);
          if (verboseP) {
            {
              ControlFrame.printControlFrame(frame, Stella.STANDARD_OUTPUT.nativeStream);
              Stella.STANDARD_OUTPUT.nativeStream.println();
            }
          }
          else {
            Stella.STANDARD_OUTPUT.nativeStream.println(frame.proposition.toString());
          }

        } finally {
          Logic.$PRINTINFRAME$.set(old$Printinframe$000);
        }
      }
    }
    if (frame.down != null) {
      ControlFrame.printGoalStack(frame.down, verboseP);
    }
  }

  public static void printControlFrame(ControlFrame self, edu.isi.stella.javalib.NativeOutputStream stream) {
    if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(self), Logic.SGT_LOGIC_PARALLEL_CONTROL_FRAME)) {
      { ParallelControlFrame self000 = ((ParallelControlFrame)(self));

        stream.print("|PLL-CF|" + ControlFrame.debugFrameId(self000) + "[");
      }
    }
    else {
      stream.print("|CF|" + ControlFrame.debugFrameId(self) + "[");
    }
    if (self.choicePointUnbindingOffset != Stella.NULL_INTEGER) {
      stream.print(self.choicePointUnbindingOffset);
    }
    else {
      stream.print("_");
    }
    { Object old$Printinframe$000 = Logic.$PRINTINFRAME$.get();

      try {
        Native.setSpecial(Logic.$PRINTINFRAME$, self);
        { boolean printtimesP = self.allottedClockTicks != Stella.NULL_INTEGER;

          stream.print(" " + self.state + " " + self.currentStrategy);
          if (self.up != null) {
            stream.print("  UP: " + ControlFrame.debugFrameId(self.up));
          }
          else {
            stream.print("  UP: -");
          }
          if (self.down != null) {
            stream.print("  DOWN: " + ControlFrame.debugFrameId(self.down));
          }
          else {
            stream.print("  DOWN: -");
          }
          stream.print("  DEPTH: " + ControlFrame.computeFrameDepth(self));
          if (((Description)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTION, null))) != null) {
            stream.print(" DESC: " + ((Description)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTION, null))));
          }
          if (printtimesP) {
            stream.print(" CLOCK: " + ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentClockTicks + " START: " + self.startingClockTicks + " TICKS: " + self.allottedClockTicks);
          }
          stream.print(((self.reversePolarityP ? " ~" : " ")) + self.proposition + "]");
        }

      } finally {
        Logic.$PRINTINFRAME$.set(old$Printinframe$000);
      }
    }
  }

  public static ControlFrame handleTimeout(ControlFrame frame, int depth, Object [] MV_returnarray) {
    if ((Stella.$TRACED_KEYWORDS$ != null) &&
        Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_TREE)) {
      Stella.STANDARD_OUTPUT.nativeStream.println("*** Timeout: start=" + frame.startingClockTicks + " depth=" + depth);
    }
    if ((Logic.$CACHE_SUCCEEDED_GOALSp$ ||
        Logic.$CACHE_FAILED_GOALSp$) &&
        ((Logic.$DUPLICATE_SUBGOAL_STRATEGY$ == Logic.KWD_DUPLICATE_GOALS) &&
         (!((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
        (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null))))) {
      ControlFrame.dontCacheGoalFailureBetweenFrames(frame, ((QueryIterator)(Logic.$QUERYITERATOR$.get())).baseControlFrame);
    }
    ControlFrame.registerInferenceCutoff(frame, Logic.KWD_TIMEOUT);
    ControlFrame.setFrameTruthValue(frame, Logic.UNKNOWN_TRUTH_VALUE);
    if ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
        (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) {
      if (frame.partialMatchFrame == null) {
        ControlFrame.createAndLinkPartialMatchFrame(frame, null);
      }
      frame.partialMatchFrame.setFramePartialTruth(null, 0.0, Stella.NULL_FLOAT, true);
    }
    if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue()) {
      { PrimitiveStrategy self000 = PrimitiveStrategy.newPrimitiveStrategy();

        self000.inferenceRule = Logic.KWD_TIMEOUT;
        self000.strategy = Logic.KWD_FAILURE;
        ControlFrame.recordGoalJustification(frame, self000);
      }
    }
    frame.state = Logic.KWD_POPPED;
    frame.up.result = frame;
    frame = frame.up;
    depth = depth - 1;
    { ControlFrame _return_temp = frame;

      MV_returnarray[0] = IntegerWrapper.wrapInteger(depth);
      return (_return_temp);
    }
  }

  public static ControlFrame handleDepthViolation(ControlFrame frame, int depth, Object [] MV_returnarray) {
    if ((Stella.$TRACED_KEYWORDS$ != null) &&
        (Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_TREE) ||
         Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_CACHES))) {
      Stella.STANDARD_OUTPUT.nativeStream.println("*** Inference depth cutoff: depth=" + depth);
    }
    if (Stella_Object.traceKeywordP(Logic.KWD_GOAL_CUTOFFS) &&
        (!Stella_Object.traceKeywordP(Logic.KWD_GOAL_TREE))) {
      ControlFrame.traceGoalStack(frame);
      if (!(Stella.yesOrNoP("**** Continue tracing? "))) {
        Stella.dropTrace(Cons.cons(Logic.KWD_GOAL_CUTOFFS, Stella.NIL));
      }
    }
    ((QueryIterator)(Logic.$QUERYITERATOR$.get())).triggeredDepthCutoffP = true;
    if ((Logic.$CACHE_SUCCEEDED_GOALSp$ ||
        Logic.$CACHE_FAILED_GOALSp$) &&
        ((Logic.$DUPLICATE_SUBGOAL_STRATEGY$ == Logic.KWD_DUPLICATE_GOALS) &&
         (!((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
        (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null))))) {
      ControlFrame.dontCacheGoalFailureBetweenFrames(frame, ((QueryIterator)(Logic.$QUERYITERATOR$.get())).baseControlFrame);
    }
    ControlFrame.registerInferenceCutoff(frame, Logic.KWD_DEPTH_VIOLATION);
    ((QueryIterator)(Logic.$QUERYITERATOR$.get())).depthCutoffsP = true;
    if ((Logic.$DUPLICATE_SUBGOAL_STRATEGY$ == Logic.KWD_DUPLICATE_GOALS) ||
        (Logic.$DUPLICATE_SUBGOAL_STRATEGY$ == Logic.KWD_DUPLICATE_GOALS_WITH_CACHING)) {
      ControlFrame.setFrameTruthValue(frame, Logic.UNKNOWN_TRUTH_VALUE);
      if (((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
          (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) &&
          (frame.partialMatchFrame == null)) {
        ControlFrame.createAndLinkPartialMatchFrame(frame, null);
        frame.partialMatchFrame.setFramePartialTruth(null, 0.0, Stella.NULL_FLOAT, true);
      }
      if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue()) {
        { PrimitiveStrategy self000 = PrimitiveStrategy.newPrimitiveStrategy();

          self000.inferenceRule = Logic.KWD_DEPTH_CUTOFF;
          self000.strategy = Logic.KWD_FAILURE;
          ControlFrame.recordGoalJustification(frame, self000);
        }
      }
      frame.state = Logic.KWD_POPPED;
      frame.up.result = frame;
      frame = frame.up;
      depth = depth - 1;
    }
    else {
      { ControlFrame goalframe = null;
        ControlFrame restartframe = null;
        int restartdepth = Stella.NULL_INTEGER;

        { Object [] caller_MV_returnarray = new Object[2];

          goalframe = ControlFrame.findDuplicatedGoal(frame, caller_MV_returnarray);
          restartframe = ((ControlFrame)(caller_MV_returnarray[0]));
          restartdepth = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
        }
        if ((goalframe != null) &&
            ((ControlFrame.findGoalCache(goalframe) == null) &&
             ControlFrame.createGoalCacheP(goalframe))) {
          if ((Stella.$TRACED_KEYWORDS$ != null) &&
              Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_CACHES)) {
            Stella.STANDARD_OUTPUT.nativeStream.println("*** Inference restart: restartDepth=" + restartdepth);
          }
          if (restartframe.down != null) {
            ControlFrame.popFramesUpTo(restartframe.down);
            restartframe.down = null;
          }
          frame = restartframe;
          depth = restartdepth;
        }
      }
    }
    { ControlFrame _return_temp = frame;

      MV_returnarray[0] = IntegerWrapper.wrapInteger(depth);
      return (_return_temp);
    }
  }

  public static ControlFrame findDuplicatedGoal(ControlFrame frame, Object [] MV_returnarray) {
    { ControlFrame trialframe = frame;
      Proposition trialgoal = null;
      ControlFrame firstrealcontrolframe = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).baseControlFrame.down;

      while (!(trialframe == firstrealcontrolframe)) {
        trialgoal = trialframe.proposition;
        if (trialgoal != null) {
          { Keyword testValue000 = trialgoal.kind;

            if ((testValue000 == Logic.KWD_ISA) ||
                ((testValue000 == Logic.KWD_PREDICATE) ||
                 (testValue000 == Logic.KWD_FUNCTION))) {
              { ControlFrame goalframe = null;
                ControlFrame restartframe = null;
                int restartdepth = Stella.NULL_INTEGER;

                { Object [] caller_MV_returnarray = new Object[2];

                  goalframe = ControlFrame.helpFindDuplicatedGoal(trialframe, caller_MV_returnarray);
                  restartframe = ((ControlFrame)(caller_MV_returnarray[0]));
                  restartdepth = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
                }
                if (goalframe != null) {
                  Logic.traceGoalCache("DUPLICATED GOAL: ", trialframe);
                  if ((Stella.$TRACED_KEYWORDS$ != null) &&
                      Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_CACHES)) {
                    Stella.STANDARD_OUTPUT.nativeStream.println("   RESTART DEPTH " + restartdepth);
                  }
                  { ControlFrame _return_temp = goalframe;

                    MV_returnarray[0] = restartframe;
                    MV_returnarray[1] = IntegerWrapper.wrapInteger(restartdepth);
                    return (_return_temp);
                  }
                }
              }
            }
            else {
            }
          }
        }
        trialframe = trialframe.up;
      }
      if ((Stella.$TRACED_KEYWORDS$ != null) &&
          Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_CACHES)) {
        Stella.STANDARD_OUTPUT.nativeStream.println("FAILED TO FIND DUPLICATE GOAL");
      }
      ((QueryIterator)(Logic.$QUERYITERATOR$.get())).failedToFindDuplicateSubgoalP = true;
      { ControlFrame _return_temp = null;

        MV_returnarray[0] = null;
        MV_returnarray[1] = IntegerWrapper.wrapInteger(Stella.NULL_INTEGER);
        return (_return_temp);
      }
    }
  }

  public static ControlFrame helpFindDuplicatedGoal(ControlFrame goalframe, Object [] MV_returnarray) {
    { Proposition atomicgoal = goalframe.proposition;
      Cons bindings = goalframe.goalBindings;
      int depth = 1;
      ControlFrame firstgoalframe = null;
      Proposition testgoal = null;
      ControlFrame testframe = null;
      ControlFrame restartframe = null;
      int restartdepth = Stella.NULL_INTEGER;

      testframe = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).baseControlFrame.down;
      for (;;) {
        testgoal = testframe.proposition;
        { boolean testValue000 = false;

          testValue000 = testgoal != null;
          if (testValue000) {
            testValue000 = testgoal.operator == atomicgoal.operator;
            if (testValue000) {
              testValue000 = testframe.reversePolarityP == goalframe.reversePolarityP;
              if (testValue000) {
                if ((bindings == null) &&
                    (testframe.goalBindings == null)) {
                  testValue000 = true;
                }
                else {
                  {
                    testValue000 = bindings != null;
                    if (testValue000) {
                      testValue000 = testframe.goalBindings != null;
                      if (testValue000) {
                        { boolean alwaysP000 = true;

                          { Stella_Object b1 = null;
                            Cons iter000 = bindings;
                            Stella_Object b2 = null;
                            Cons iter001 = testframe.goalBindings;

                            loop001 : for (;(!(iter000 == Stella.NIL)) &&
                                      (!(iter001 == Stella.NIL)); iter000 = iter000.rest, iter001 = iter001.rest) {
                              b1 = iter000.value;
                              b2 = iter001.value;
                              if (!Stella_Object.eqlP(b1, b2)) {
                                alwaysP000 = false;
                                break loop001;
                              }
                            }
                          }
                          testValue000 = alwaysP000;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          if (testValue000) {
            if (firstgoalframe == null) {
              firstgoalframe = testframe;
            }
            else {
              { ControlFrame _return_temp = firstgoalframe;

                MV_returnarray[0] = restartframe;
                MV_returnarray[1] = IntegerWrapper.wrapInteger(restartdepth);
                return (_return_temp);
              }
            }
          }
        }
        restartframe = testframe;
        restartdepth = depth;
        testframe = testframe.down;
        depth = depth + 1;
        if (testframe == null) {
          { ControlFrame _return_temp = null;

            MV_returnarray[0] = null;
            MV_returnarray[1] = IntegerWrapper.wrapInteger(Stella.NULL_INTEGER);
            return (_return_temp);
          }
        }
      }
    }
  }

  public static Keyword continuePatternProof(ControlFrame frame, Keyword lastmove) {
    if (lastmove == Logic.KWD_DOWN) {
      ControlFrame.resetCurrentPatternRecord(frame, Logic.KWD_LOCAL);
      return (Logic.KWD_MOVE_DOWN);
    }
    else if (lastmove == Logic.KWD_UP_TRUE) {
      { boolean futurebindingsP = frame.down != null;
        ControlFrame result = frame.result;
        Proposition rule = ControlFrame.getRuleOfAntecedentFrame(frame);

        frame.truthValue = TruthValue.weakenTruthValue(ControlFrame.propagateFrameTruthValue(result, frame), ((rule != null) ? ((TruthValue)(Stella_Object.accessInContext(rule.truthValue, rule.homeContext, false))) : Logic.TRUE_TRUTH_VALUE));
        if (result.partialMatchFrame != null) {
          result.partialMatchFrame.propagateFramePartialTruth(frame);
        }
        if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue()) {
          ControlFrame.recordPatternJustification(frame, lastmove);
        }
        if (frame.patternRecord.collectionList != null) {
          ControlFrame.collectPatternQueryBindings(frame);
          if (futurebindingsP) {
            return (Logic.KWD_MOVE_DOWN);
          }
          else {
            {
              ControlFrame.resetCurrentPatternRecord(frame, Logic.KWD_PARENT);
              return (Logic.KWD_CONTINUING_SUCCESS);
            }
          }
        }
        else if (ControlFrame.transferPatternQueryBindingsP(frame, futurebindingsP)) {
          if (futurebindingsP) {
            {
              if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_CACHED_SINGLE_VALUEDp, Stella.FALSE_WRAPPER))).wrapperValue &&
                  (!((Boolean)(Logic.$GENERATE_ALL_PROOFSp$.get())).booleanValue())) {
                ControlFrame.popFramesUpTo(frame.down);
                return (Logic.KWD_FINAL_SUCCESS);
              }
              return (Logic.KWD_CONTINUING_SUCCESS);
            }
          }
          else {
            return (Logic.KWD_FINAL_SUCCESS);
          }
        }
        else if (futurebindingsP) {
          return (Logic.KWD_MOVE_DOWN);
        }
        else {
          return (Logic.KWD_FAILURE);
        }
      }
    }
    else if ((lastmove == Logic.KWD_UP_FAIL) ||
        (lastmove == Logic.KWD_FAILED_OVERLAY)) {
      { ControlFrame result = frame.result;

        ControlFrame.propagateFrameTruthValue(result, frame);
        if (result.partialMatchFrame != null) {
          result.partialMatchFrame.propagateFramePartialTruth(frame);
        }
        if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue()) {
          ControlFrame.recordPatternJustification(frame, lastmove);
        }
        if (frame.patternRecord.collectionList != null) {
          {
            ControlFrame.resetCurrentPatternRecord(frame, Logic.KWD_PARENT);
            return (Logic.KWD_CONTINUING_SUCCESS);
          }
        }
        else {
          return (Logic.KWD_FAILURE);
        }
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + lastmove + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static Proposition getRuleOfAntecedentFrame(ControlFrame frame) {
    if (frame.state == Logic.KWD_PATTERN) {
      { ControlFrame parent = frame.up;

        if (parent != null) {
          return (((Proposition)(KeyValueList.dynamicSlotValue(parent.dynamicSlots, Logic.SYM_LOGIC_ANTECEDENTS_RULE, null))));
        }
      }
    }
    return (null);
  }

  public static void collectPatternQueryBindings(ControlFrame frame) {
    { PatternRecord patternrecord = frame.patternRecord;
      Vector iovariables = patternrecord.optimalPattern.ioVariables;
      Cons iovariablevalues = Stella.NIL;

      { PatternVariable v = null;
        Vector vector000 = iovariables;
        int index000 = 0;
        int length000 = vector000.length();
        Cons collect000 = null;

        for (;index000 < length000; index000 = index000 + 1) {
          v = ((PatternVariable)((vector000.theArray)[index000]));
          if (collect000 == null) {
            {
              collect000 = Cons.cons((((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord.variableBindings.theArray)[(v.boundToOffset)], Stella.NIL);
              if (iovariablevalues == Stella.NIL) {
                iovariablevalues = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(iovariablevalues, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons((((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord.variableBindings.theArray)[(v.boundToOffset)], Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      switch (iovariablevalues.length()) {
        case 1: 
          if (iovariablevalues.value == null) {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Pushing NULL binding onto collection.  Variable= `" + ((PatternVariable)((iovariables.theArray)[0])) + "'");
            return;
          }
          patternrecord.collectionList.push(iovariablevalues.value);
        break;
        default:
          patternrecord.collectionList.push(iovariablevalues);
        break;
      }
    }
  }

  public static boolean transferPatternQueryBindingsP(ControlFrame frame, boolean futurebindingsP) {
    if ((Stella.$TRACED_KEYWORDS$ != null) &&
        Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_QUERY_STACKS)) {
      Stella.STANDARD_OUTPUT.nativeStream.println("TRANSFER-pattern-query-bindings?: ");
    }
    { PatternRecord childpatternrecord = frame.patternRecord;
      BooleanVector booleanvector = childpatternrecord.booleanVector;
      Vector externalarguments = childpatternrecord.externalArguments;
      Vector iovariables = childpatternrecord.optimalPattern.ioVariables;
      int lastindex = booleanvector.length() - 1;
      Cons iovariablevalues = Stella.NIL;
      int topunbindingoffset = Stella.NULL_INTEGER;

      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = lastindex;
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;
        Cons collect000 = null;

        for (;unboundedP000 ||
                  (iter000 <= upperBound000); iter000 = iter000 + 1) {
          i = iter000;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(((!BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)((booleanvector.theArray)[i])))) ? (((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord.variableBindings.theArray)[(((PatternVariable)((iovariables.theArray)[i])).boundToOffset)] : null), Stella.NIL);
              if (iovariablevalues == Stella.NIL) {
                iovariablevalues = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(iovariablevalues, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(((!BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)((booleanvector.theArray)[i])))) ? (((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord.variableBindings.theArray)[(((PatternVariable)((iovariables.theArray)[i])).boundToOffset)] : null), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      ControlFrame.resetCurrentPatternRecord(frame, Logic.KWD_PARENT);
      { PatternRecord parentpatternrecord = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord;

        topunbindingoffset = parentpatternrecord.topUnbindingStackOffset;
        { Stella_Object value = null;
          Cons iter001 = iovariablevalues;
          Stella_Object externalarg = null;
          Vector vector000 = externalarguments;
          int index000 = 0;
          int length000 = vector000.length();
          BooleanWrapper initiallyboundP = null;
          BooleanVector vector001 = booleanvector;
          int index001 = 0;
          int length001 = vector001.length();

          for (;(!(iter001 == Stella.NIL)) &&
                    ((index000 < length000) &&
                     (index001 < length001)); 
                iter001 = iter001.rest,
                index000 = index000 + 1,
                index001 = index001 + 1) {
            value = iter001.value;
            externalarg = (vector000.theArray)[index000];
            initiallyboundP = ((BooleanWrapper)((vector001.theArray)[index001]));
            if (!BooleanWrapper.coerceWrappedBooleanToBoolean(initiallyboundP)) {
              if (!Logic.bindArgumentToValueP(externalarg, value, false)) {
                if ((Stella.$TRACED_KEYWORDS$ != null) &&
                    Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_QUERY_STACKS)) {
                  Stella.STANDARD_OUTPUT.nativeStream.println("TRANSFER FAILS! ");
                }
                PatternRecord.unbindVariablesBeginningAt(parentpatternrecord, topunbindingoffset + 1);
                if (futurebindingsP) {
                  ControlFrame.resetCurrentPatternRecord(frame, Logic.KWD_LOCAL);
                }
                return (false);
              }
            }
          }
        }
      }
      return (true);
    }
  }

  public static boolean overlayWithPatternFrameP(ControlFrame frame, Description description, Vector ioarguments) {
    { Cons iobindings = Logic.computeExternalBindings(ioarguments);
      Cons externalbindings = ((((Vector)(KeyValueList.dynamicSlotValue(description.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null))) != null) ? Logic.computeExternalBindings(((Vector)(KeyValueList.dynamicSlotValue(description.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null)))) : Stella.NIL);
      PatternRecord patternrecord = ControlFrame.createPatternRecord(frame, description, ioarguments);
      Description optimalpattern = null;

      if (ioarguments == null) {
        { Iterator v = ((Iterator)(description.ioVariables.allocateIterator()));
          Cons collect000 = null;

          while (v.nextP()) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(null, Stella.NIL);
                if (iobindings == Stella.NIL) {
                  iobindings = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(iobindings, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(null, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      frame.state = Logic.KWD_PATTERN;
      optimalpattern = Description.selectOptimalQueryPattern(description, patternrecord.booleanVector, frame);
      patternrecord.optimalPattern = optimalpattern;
      if (Description.checkForSingleValuedGoalP(optimalpattern, iobindings)) {
        KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_CACHED_SINGLE_VALUEDp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
      }
      frame.proposition = optimalpattern.proposition;
      { int variablescount = iobindings.length() + optimalpattern.internalVariables.length() + externalbindings.length();

        PatternRecord.activatePatternRecord(patternrecord, variablescount);
      }
      { PatternVariable iovar = null;
        Vector vector000 = optimalpattern.ioVariables;
        int index000 = 0;
        int length000 = vector000.length();
        Stella_Object binding = null;
        Cons iter000 = iobindings;

        for (;(index000 < length000) &&
                  (!(iter000 == Stella.NIL)); index000 = index000 + 1, iter000 = iter000.rest) {
          iovar = ((PatternVariable)((vector000.theArray)[index000]));
          binding = iter000.value;
          if ((binding != null) &&
              (!PatternVariable.bindVariableToValueP(iovar, binding, false))) {
            return (false);
          }
        }
      }
      if (!(externalbindings == Stella.NIL)) {
        { PatternVariable externalvar = null;
          Vector vector001 = ((Vector)(KeyValueList.dynamicSlotValue(optimalpattern.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null)));
          int index001 = 0;
          int length001 = vector001.length();
          Stella_Object binding = null;
          Cons iter001 = externalbindings;

          for (;(index001 < length001) &&
                    (!(iter001 == Stella.NIL)); index001 = index001 + 1, iter001 = iter001.rest) {
            externalvar = ((PatternVariable)((vector001.theArray)[index001]));
            binding = iter001.value;
            if ((binding != null) &&
                (!PatternVariable.bindVariableToValueP(externalvar, binding, false))) {
              return (false);
            }
          }
        }
      }
      if (frame.down == null) {
        ControlFrame.createDownFrame(frame, optimalpattern.proposition);
      }
      Proposition.elaborateSurrogatesInProposition(optimalpattern.proposition);
      return (true);
    }
  }

  public static PatternRecord createPatternRecord(ControlFrame frame, Description description, Vector externalarguments) {
    { PatternRecord patternrecord = PatternRecord.newPatternRecord();

      if (description != null) {
        patternrecord.description = description;
        if (externalarguments != null) {
          { Vector externalargumentscopy = Logic.copyPatternArguments(externalarguments, description);

            patternrecord.externalArguments = externalargumentscopy;
            patternrecord.booleanVector = Logic.argumentsVectorToBooleanVector(externalargumentscopy);
          }
        }
        else {
          { List oneslist = List.newList();

            { Iterator v = ((Iterator)(description.ioVariables.allocateIterator()));
              Cons collect000 = null;

              while (v.nextP()) {
                if (collect000 == null) {
                  {
                    collect000 = Cons.cons(Stella.ZERO_WRAPPER, Stella.NIL);
                    if (oneslist.theConsList == Stella.NIL) {
                      oneslist.theConsList = collect000;
                    }
                    else {
                      Cons.addConsToEndOfConsList(oneslist.theConsList, collect000);
                    }
                  }
                }
                else {
                  {
                    collect000.rest = Cons.cons(Stella.ZERO_WRAPPER, Stella.NIL);
                    collect000 = collect000.rest;
                  }
                }
              }
            }
            patternrecord.booleanVector = Logic.zeroOneListToBooleanVector(oneslist);
            oneslist.free();
          }
        }
      }
      patternrecord.collectionList = null;
      frame.patternRecord = patternrecord;
      patternrecord.controlFrame = frame;
      return (patternrecord);
    }
  }

  public static Keyword initiateAtomicGoalProofs(ControlFrame frame) {
    { Object old$ReversepolarityP$000 = Logic.$REVERSEPOLARITYp$.get();

      try {
        Native.setBooleanSpecial(Logic.$REVERSEPOLARITYp$, frame.reversePolarityP);
        { Proposition proposition = frame.proposition;
          Keyword inferencelevel = Logic.currentInferenceLevel().keyword;
          Cons strategies = null;

          { Keyword testValue000 = proposition.kind;

            if ((testValue000 == Logic.KWD_PREDICATE) ||
                ((testValue000 == Logic.KWD_ISA) ||
                 (testValue000 == Logic.KWD_FUNCTION))) {
              frame.goalBindings = Proposition.yieldGoalBindings(proposition);
              if (ControlFrame.checkForDuplicateGoalP(frame)) {
                if (Logic.$DUPLICATE_SUBGOAL_STRATEGY$ == Logic.KWD_DUPLICATE_GOALS) {
                  inferencelevel = Logic.KWD_SHALLOW;
                }
                else if (Logic.$DUPLICATE_SUBGOAL_STRATEGY$ == Logic.KWD_DUPLICATE_GOALS_WITH_CACHING) {
                  frame.state = Logic.KWD_SCAN_CACHED_BINDINGS;
                  ControlFrame.createChoicePoint(frame);
                  return (Logic.KWD_MOVE_IN_PLACE);
                }
                else {
                  { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                    stream000.nativeStream.print("`" + Logic.$DUPLICATE_SUBGOAL_STRATEGY$ + "' is not a valid case option");
                    throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                  }
                }
              }
              if ((inferencelevel == Logic.KWD_NORMAL) ||
                  (inferencelevel == Logic.KWD_BACKTRACKING)) {
                strategies = Stella.getQuotedTree("((:SPECIALIST :LOOKUP-GOAL-CACHES :LOOKUP-ASSERTIONS :SHALLOW-DISPROOF :ALL-SUBGOAL-STRATEGIES) \"/LOGIC\")", "/LOGIC");
              }
              else if (inferencelevel == Logic.KWD_REFUTATION) {
                strategies = Stella.getQuotedTree("((:SPECIALIST :LOOKUP-GOAL-CACHES :LOOKUP-ASSERTIONS :SHALLOW-DISPROOF :ALL-SUBGOAL-STRATEGIES :REFUTATION) \"/LOGIC\")", "/LOGIC");
              }
              else {
                strategies = Stella.getQuotedTree("((:SPECIALIST :LOOKUP-GOAL-CACHES :LOOKUP-ASSERTIONS :SHALLOW-DISPROOF) \"/LOGIC\")", "/LOGIC");
              }
              if ((proposition.kind == Logic.KWD_FUNCTION) &&
                  (!((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue())) {
                strategies = Cons.copyConsList(strategies).concatenate(Cons.consList(Cons.cons(Logic.KWD_MANUFACTURE_SKOLEM, Stella.NIL)), Stella.NIL);
              }
            }
            else if (testValue000 == Logic.KWD_EQUIVALENT) {
              strategies = Stella.getQuotedTree("((:EQUIVALENCE) \"/LOGIC\")", "/LOGIC");
            }
            else if (testValue000 == Logic.KWD_IMPLIES) {
              strategies = Stella.getQuotedTree("((:SPECIALIST :ALL-SUBGOAL-STRATEGIES :IMPLIES) \"/LOGIC\")", "/LOGIC");
            }
            else {
              { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                stream001.nativeStream.print("`" + testValue000 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
              }
            }
          }
          frame.nextStrategies = strategies;
          frame.state = Logic.KWD_ATOMIC_GOAL;
          ControlFrame.createChoicePoint(frame);
          return (Logic.KWD_MOVE_IN_PLACE);
        }

      } finally {
        Logic.$REVERSEPOLARITYp$.set(old$ReversepolarityP$000);
      }
    }
  }

  public static boolean checkForDuplicateGoalP(ControlFrame frame) {
    if (!((Logic.$DUPLICATE_SUBGOAL_STRATEGY$ == Logic.KWD_DUPLICATE_GOALS) ||
        (Logic.$DUPLICATE_SUBGOAL_STRATEGY$ == Logic.KWD_DUPLICATE_GOALS_WITH_CACHING))) {
      return (false);
    }
    { GeneralizedSymbol operator = frame.proposition.operator;
      Cons goalbindings = frame.goalBindings;
      ControlFrame previousframe = frame.up;
      ControlFrame duplicateframe = null;

      { int i = Stella.NULL_INTEGER;
        int iter000 = 1;
        int upperBound000 = Logic.$DUPLICATE_GOAL_SEARCH_DEPTH$;
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

        loop000 : for (;unboundedP000 ||
                  (iter000 <= upperBound000); iter000 = iter000 + 1) {
          i = iter000;
          i = i;
          if (previousframe == null) {
            break loop000;
          }
          { boolean testValue000 = false;

            testValue000 = previousframe.goalBindings != null;
            if (testValue000) {
              testValue000 = operator == previousframe.proposition.operator;
              if (testValue000) {
                { boolean alwaysP000 = true;

                  { Stella_Object b1 = null;
                    Cons iter001 = goalbindings;
                    Stella_Object b2 = null;
                    Cons iter002 = previousframe.goalBindings;

                    loop001 : for (;(!(iter001 == Stella.NIL)) &&
                              (!(iter002 == Stella.NIL)); iter001 = iter001.rest, iter002 = iter002.rest) {
                      b1 = iter001.value;
                      b2 = iter002.value;
                      if (!Stella_Object.eqlP(b1, b2)) {
                        alwaysP000 = false;
                        break loop001;
                      }
                    }
                  }
                  testValue000 = alwaysP000;
                }
                if (testValue000) {
                  testValue000 = frame.reversePolarityP == previousframe.reversePolarityP;
                }
              }
            }
            if (testValue000) {
              duplicateframe = previousframe;
              break loop000;
            }
          }
          previousframe = previousframe.up;
        }
      }
      if (duplicateframe != null) {
        Logic.traceGoalCache("DUPLICATE GOAL:", frame);
        if ((Logic.$CACHE_SUCCEEDED_GOALSp$ ||
            Logic.$CACHE_FAILED_GOALSp$) &&
            ((Logic.$DUPLICATE_SUBGOAL_STRATEGY$ == Logic.KWD_DUPLICATE_GOALS) &&
             (!((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
            (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null))))) {
          ControlFrame.dontCacheGoalFailureBetweenFrames(frame, duplicateframe.down);
        }
        return (true);
      }
      else {
        return (false);
      }
    }
  }

  public static Keyword overlayWithStrategyFrame(ControlFrame frame, Keyword strategy) {
    frame.nextStrategies = Cons.consList(Cons.cons(strategy, Stella.NIL));
    frame.state = Logic.KWD_STRATEGY;
    return (Logic.KWD_MOVE_IN_PLACE);
  }

  public static Keyword overlayWithFailFrame(ControlFrame frame, Proposition proposition) {
    { Proposition failproposition = Logic.createProposition(Logic.SYM_LOGIC_FAIL, 1);

      (failproposition.arguments.theArray)[0] = proposition;
      frame.proposition = failproposition;
      frame.state = Logic.KWD_FAIL;
      frame.reversePolarityP = false;
      return (Logic.KWD_MOVE_IN_PLACE);
    }
  }

  public static Keyword continueNotProof(ControlFrame frame, Keyword lastmove) {
    if (lastmove == Logic.KWD_DOWN) {
      if (frame.down != null) {
        return (Logic.KWD_MOVE_DOWN);
      }
      { Proposition argument = ((Proposition)((frame.proposition.arguments.theArray)[0]));

        if ((!frame.reversePolarityP) &&
            Proposition.closedPropositionP(argument)) {
          return (ControlFrame.overlayWithFailFrame(frame, argument));
        }
        ControlFrame.createDownFrame(frame, argument);
        frame.down.reversePolarityP = !frame.reversePolarityP;
        return (Logic.KWD_MOVE_DOWN);
      }
    }
    else if (lastmove == Logic.KWD_UP_TRUE) {
      frame.truthValue = TruthValue.invertTruthValue(frame.result.truthValue);
      if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue()) {
        ControlFrame.recordDisproofJustification(frame, lastmove);
      }
      if (frame.down == null) {
        return (Logic.KWD_FINAL_SUCCESS);
      }
      else {
        return (Logic.KWD_CONTINUING_SUCCESS);
      }
    }
    else if (lastmove == Logic.KWD_UP_FAIL) {
      frame.truthValue = TruthValue.invertTruthValue(frame.result.truthValue);
      if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue() &&
          (((Justification)(KeyValueList.dynamicSlotValue(frame.result.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null))) != null)) {
        ControlFrame.recordDisproofJustification(frame, lastmove);
      }
      return (Logic.KWD_FAILURE);
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + lastmove + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static Keyword continueOrProof(ControlFrame frame, Keyword lastmove) {
    { Proposition proposition = frame.proposition;

      if (lastmove == Logic.KWD_DOWN) {
        if (frame.reversePolarityP &&
            Proposition.closedPropositionP(proposition)) {
          return (ControlFrame.overlayWithFailFrame(frame, proposition));
        }
        if (!(frame.down != null)) {
          ControlFrame.createChoicePoint(frame);
        }
        return (Logic.KWD_MOVE_DOWN);
      }
      else if (lastmove == Logic.KWD_UP_TRUE) {
        frame.truthValue = frame.result.truthValue;
        if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue()) {
          ControlFrame.recordOrIntroductionJustification(frame, lastmove);
        }
        if (frame.down == null) {
          frame.argumentCursor = frame.argumentCursor + 1;
        }
        if ((frame.argumentCursor >= proposition.arguments.length()) ||
            ((!ControlFrame.newBindingsSinceLastChoicePointP(frame)) &&
             (!((Boolean)(Logic.$GENERATE_ALL_PROOFSp$.get())).booleanValue()))) {
          if (frame.down != null) {
            ControlFrame.popFramesUpTo(frame.down);
          }
          return (Logic.KWD_FINAL_SUCCESS);
        }
        else {
          return (Logic.KWD_CONTINUING_SUCCESS);
        }
      }
      else if (lastmove == Logic.KWD_UP_FAIL) {
        { TruthValue chooseValue000 = null;

          if (frame.truthValue == null) {
            { TruthValue temp000 = frame.result.truthValue;

              chooseValue000 = ((temp000 != null) ? temp000 : Logic.UNKNOWN_TRUTH_VALUE);
            }
          }
          else {
            chooseValue000 = TruthValue.disjoinTruthValues(frame.truthValue, frame.result.truthValue);
          }
          frame.truthValue = chooseValue000;
        }
        frame.argumentCursor = frame.argumentCursor + 1;
        if (frame.argumentCursor < proposition.arguments.length()) {
          {
            ControlFrame.createChoicePoint(frame);
            return (Logic.KWD_MOVE_DOWN);
          }
        }
        else {
          if (Logic.currentInferenceLevel().keyword == Logic.KWD_REFUTATION) {
            ControlFrame.overlayWithStrategyFrame(frame, Logic.KWD_DISJUNCTIVE_IMPLICATION_INTRODUCTION);
            return (Logic.KWD_MOVE_IN_PLACE);
          }
          else {
            return (Logic.KWD_FAILURE);
          }
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + lastmove + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static Keyword continueAndProof(ControlFrame frame, Keyword lastmove) {
    { Proposition proposition = frame.proposition;
      Vector conjuncts = null;

      if (lastmove == Logic.KWD_DOWN) {
        if (proposition.clusteredConjunctionP()) {
          ControlFrame.overlayWithStrategyFrame(frame, Logic.KWD_CLUSTERED_CONJUNCTION);
          return (Logic.KWD_MOVE_IN_PLACE);
        }
        else if (frame.reversePolarityP &&
            Proposition.closedPropositionP(proposition)) {
          return (ControlFrame.overlayWithFailFrame(frame, proposition));
        }
        else {
          conjuncts = ((Vector)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ARGUMENTS, null)));
          if (conjuncts == null) {
            conjuncts = Vector.newVector(proposition.arguments.length());
            KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ARGUMENTS, conjuncts, null);
            if (Proposition.dynamicallyOptimizePropositionP(proposition)) {
              proposition = Proposition.shallowCopyProposition(proposition);
              frame.proposition = proposition;
            }
          }
          if (Proposition.dynamicallyOptimizePropositionP(proposition) &&
              (frame.down == null)) {
            Logic.dynamicallyReoptimizeArguments(proposition.arguments, frame.argumentCursor);
          }
          return (Logic.KWD_MOVE_DOWN);
        }
      }
      else if (lastmove == Logic.KWD_UP_TRUE) {
        conjuncts = ((Vector)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ARGUMENTS, null)));
        (conjuncts.theArray)[(frame.argumentCursor)] = (frame.result);
        if (frame.argumentCursor == (conjuncts.length() - 1)) {
          frame.down = null;
          { ControlFrame conjunct = null;
            Vector vector000 = conjuncts;
            int index000 = 0;
            int length000 = vector000.length();
            int i = Stella.NULL_INTEGER;
            int iter000 = 0;

            for (;index000 < length000; index000 = index000 + 1, iter000 = iter000 + 1) {
              conjunct = ((ControlFrame)((vector000.theArray)[index000]));
              i = iter000;
              frame.truthValue = ((i == 0) ? conjunct.truthValue : TruthValue.conjoinTruthValues(frame.truthValue, conjunct.truthValue));
              if (!(conjunct.state == Logic.KWD_POPPED)) {
                frame.argumentCursor = i;
                frame.down = conjunct;
              }
            }
          }
          if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue()) {
            ControlFrame.recordAndIntroductionJustification(frame, lastmove);
          }
          if (frame.down != null) {
            return (Logic.KWD_CONTINUING_SUCCESS);
          }
          else {
            return (Logic.KWD_FINAL_SUCCESS);
          }
        }
        else {
          frame.down = null;
          frame.argumentCursor = frame.argumentCursor + 1;
          if (Proposition.dynamicallyOptimizePropositionP(proposition)) {
            Logic.dynamicallyReoptimizeArguments(proposition.arguments, frame.argumentCursor);
          }
          return (Logic.KWD_MOVE_DOWN);
        }
      }
      else if (lastmove == Logic.KWD_UP_FAIL) {
        conjuncts = ((Vector)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ARGUMENTS, null)));
        if (conjuncts == null) {
          frame.truthValue = TruthValue.conjoinTruthValues(Logic.UNKNOWN_TRUTH_VALUE, frame.result.truthValue);
          return (Logic.KWD_FAILURE);
        }
        frame.down = null;
        { ControlFrame conjunct = null;
          Vector vector001 = conjuncts;
          int index001 = 0;
          int length001 = vector001.length();
          int i = Stella.NULL_INTEGER;
          int iter001 = 0;

          loop001 : for (;index001 < length001; index001 = index001 + 1, iter001 = iter001 + 1) {
            conjunct = ((ControlFrame)((vector001.theArray)[index001]));
            i = iter001;
            if (conjunct == null) {
              break loop001;
            }
            if (!(conjunct.state == Logic.KWD_POPPED)) {
              frame.argumentCursor = i;
              frame.down = conjunct;
            }
          }
        }
        if (frame.down != null) {
          return (Logic.KWD_MOVE_DOWN);
        }
        else {
          ControlFrame.propagateFrameTruthValue(frame.result, frame);
          (conjuncts.theArray)[(frame.argumentCursor)] = (frame.result);
          { ControlFrame conjunct = null;
            Vector vector002 = conjuncts;
            int index002 = 0;
            int length002 = vector002.length();
            int i = Stella.NULL_INTEGER;
            int iter002 = 0;
            int upperBound000 = frame.argumentCursor;
            boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

            loop002 : for (;(index002 < length002) &&
                      (unboundedP000 ||
                       (iter002 <= upperBound000)); index002 = index002 + 1, iter002 = iter002 + 1) {
              conjunct = ((ControlFrame)((vector002.theArray)[index002]));
              i = iter002;
              i = i;
              if (conjunct == null) {
                break loop002;
              }
              frame.truthValue = TruthValue.conjoinTruthValues(frame.truthValue, conjunct.truthValue);
            }
          }
          return (Logic.KWD_FAILURE);
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + lastmove + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static Keyword evaluateNextMove(ControlFrame frame, Keyword lastmove, int clockticks) {
    { Keyword testValue000 = frame.state;

      if (testValue000 == Logic.KWD_AND) {
        if ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
            (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) {
          return (frame.continuePartialAndProof(frame, lastmove));
        }
        else {
          return (ControlFrame.continueAndProof(frame, lastmove));
        }
      }
      else if (testValue000 == Logic.KWD_OR) {
        if ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
            (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) {
          return (frame.continuePartialOrProof(lastmove));
        }
        else {
          return (ControlFrame.continueOrProof(frame, lastmove));
        }
      }
      else if (testValue000 == Logic.KWD_NOT) {
        if ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
            (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) {
          return (frame.continuePartialNotProof(lastmove));
        }
        else {
          return (ControlFrame.continueNotProof(frame, lastmove));
        }
      }
      else if ((testValue000 == Logic.KWD_ISA) ||
          ((testValue000 == Logic.KWD_FUNCTION) ||
           ((testValue000 == Logic.KWD_PREDICATE) ||
            ((testValue000 == Logic.KWD_EQUIVALENT) ||
             (testValue000 == Logic.KWD_IMPLIES))))) {
        return (ControlFrame.initiateAtomicGoalProofs(frame));
      }
      else if ((testValue000 == Logic.KWD_ATOMIC_GOAL) ||
          (testValue000 == Logic.KWD_STRATEGY)) {
        if ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
            (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) {
          return (frame.continuePartialStrategiesProofs(lastmove));
        }
        else {
          return (ControlFrame.continueStrategiesProofs(frame, lastmove));
        }
      }
      else if (testValue000 == Logic.KWD_SCAN_CACHED_BINDINGS) {
        return (ControlFrame.continueCachedBindingsProof(frame, lastmove));
      }
      else if (testValue000 == Logic.KWD_PATTERN) {
        return (ControlFrame.continuePatternProof(frame, lastmove));
      }
      else if (testValue000 == Logic.KWD_FORALL) {
        return (ControlFrame.continueForallProof(frame, lastmove));
      }
      else if ((testValue000 == Logic.KWD_CONTAINED_BY) ||
          (testValue000 == Logic.KWD_ITERATIVE_FORALL)) {
        if ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
            (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) {
          lastmove = ControlFrame.interpretIterativeForallScores(frame, lastmove);
        }
        return (ControlFrame.continueContainedByProof(frame, lastmove));
      }
      else if (testValue000 == Logic.KWD_EXISTS) {
        return (ControlFrame.continueExistsProof(frame, lastmove));
      }
      else if (testValue000 == Logic.KWD_CONSTANT) {
        return (ControlFrame.continueConstantProof(frame, lastmove));
      }
      else if (testValue000 == Logic.KWD_FAIL) {
        if ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
            (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) {
          return (frame.continuePartialFailProof(lastmove));
        }
        else {
          return (ControlFrame.continueFailProof(frame, lastmove));
        }
      }
      else if (testValue000 == Logic.KWD_PARALLEL_STRATEGIES) {
        return (ParallelControlFrame.continueParallelStrategiesProofs(((ParallelControlFrame)(frame)), lastmove));
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.println("Error.  No query state implemented for operator `" + frame.state + "'");
          throw ((FailException)(FailException.newFailException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static ParallelControlFrame parallelizeControlFrame(ControlFrame frame) {
    if (frame.state == Logic.KWD_PARALLEL_STRATEGIES) {
      return (((ParallelControlFrame)(frame)));
    }
    { ParallelControlFrame parallelparent = ParallelControlFrame.newParallelControlFrame();

      parallelparent.state = Logic.KWD_PARALLEL_STRATEGIES;
      ControlFrame.copyFrameState(frame, parallelparent);
      frame.up.down = parallelparent;
      frame.nextStrategies = Stella.NIL;
      KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_CACHED_BINDINGS_ITERATOR, null, null);
      KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_GOAL_CACHE, null, null);
      parallelparent.unboundVariablesP = !Proposition.allArgumentsBoundP(parallelparent.proposition);
      if ((frame.down != null) ||
          (((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, null))) != null)) {
        { ParallelThread childthread = ParallelThread.newParallelThread();

          frame.up = parallelparent;
          childthread.topControlFrame = frame;
          parallelparent.childThreads.insert(childthread);
          if (parallelparent.unboundVariablesP) {
            { PatternRecord patternrecord = frame.inheritedPatternRecord;

              childthread.variableBindings = patternrecord.variableBindings.copy();
              childthread.unbindingStack = ((IntegerVector)(patternrecord.unbindingStack.copy()));
              childthread.topUnbindingStackOffset = patternrecord.topUnbindingStackOffset;
            }
          }
        }
      }
      if (((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentControlFrame == frame) {
        ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentControlFrame = parallelparent;
      }
      return (parallelparent);
    }
  }

  public static void copyFrameState(ControlFrame fromframe, ControlFrame toframe) {
    toframe.proposition = fromframe.proposition;
    KeyValueList.setDynamicSlotValue(toframe.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTION, ((Description)(KeyValueList.dynamicSlotValue(fromframe.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTION, null))), null);
    toframe.reversePolarityP = fromframe.reversePolarityP;
    toframe.up = fromframe.up;
    toframe.partialMatchFrame = fromframe.partialMatchFrame;
    toframe.inheritedPatternRecord = fromframe.inheritedPatternRecord;
    toframe.choicePointUnbindingOffset = fromframe.choicePointUnbindingOffset;
    toframe.nextStrategies = fromframe.nextStrategies;
    KeyValueList.setDynamicSlotValue(toframe.dynamicSlots, Logic.SYM_LOGIC_CACHED_BINDINGS_ITERATOR, ((Iterator)(KeyValueList.dynamicSlotValue(fromframe.dynamicSlots, Logic.SYM_LOGIC_CACHED_BINDINGS_ITERATOR, null))), null);
    toframe.goalBindings = fromframe.goalBindings;
    KeyValueList.setDynamicSlotValue(toframe.dynamicSlots, Logic.SYM_LOGIC_GOAL_CACHE, ((GoalCache)(KeyValueList.dynamicSlotValue(fromframe.dynamicSlots, Logic.SYM_LOGIC_GOAL_CACHE, null))), null);
  }

  public static int debugFrameId(ControlFrame frame) {
    { int id = ((IntegerWrapper)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_DEBUG_FRAME_ID_INTERNAL, Stella.NULL_INTEGER_WRAPPER))).wrapperValue;

      if (id == Stella.NULL_INTEGER) {
        Logic.$CONTROL_FRAME_ID_COUNTER$ = Logic.$CONTROL_FRAME_ID_COUNTER$ + 1;
        id = Logic.$CONTROL_FRAME_ID_COUNTER$;
        KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_DEBUG_FRAME_ID_INTERNAL, IntegerWrapper.wrapInteger(id), Stella.NULL_INTEGER_WRAPPER);
      }
      return (id);
    }
  }

  public static TruthValue propagateFrameTruthValue(ControlFrame source, ControlFrame target) {
    return (target.truthValue = ((!(source.reversePolarityP == target.reversePolarityP)) ? TruthValue.invertTruthValue(source.truthValue) : source.truthValue));
  }

  public static TruthValue setFrameTruthValue(ControlFrame frame, TruthValue truthvalue) {
    return (frame.truthValue = (frame.reversePolarityP ? TruthValue.invertTruthValue(truthvalue) : truthvalue));
  }

  public static ControlFrame createDownFrame(ControlFrame upframe, Proposition downproposition) {
    { ControlFrame downframe = ControlFrame.newControlFrame();

      upframe.down = downframe;
      downframe.up = upframe;
      downframe.reversePolarityP = upframe.reversePolarityP;
      downframe.proposition = downproposition;
      downframe.down = null;
      KeyValueList.setDynamicSlotValue(downframe.dynamicSlots, Logic.SYM_LOGIC_BACK, null, null);
      downframe.patternRecord = null;
      downframe.truthValue = null;
      downframe.justifications.clear();
      KeyValueList.setDynamicSlotValue(downframe.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null, null);
      KeyValueList.setDynamicSlotValue(downframe.dynamicSlots, Logic.SYM_LOGIC_GOAL_CACHE, null, null);
      downframe.goalBindings = null;
      KeyValueList.setDynamicSlotValue(downframe.dynamicSlots, Logic.SYM_LOGIC_CACHED_BINDINGS_ITERATOR, null, null);
      if (downproposition != null) {
        downframe.state = downproposition.kind;
        if (downframe.reversePolarityP) {
          { Keyword testValue000 = downframe.state;

            if (testValue000 == Logic.KWD_AND) {
              downframe.state = Logic.KWD_OR;
            }
            else if (testValue000 == Logic.KWD_OR) {
              downframe.state = Logic.KWD_AND;
            }
            else {
            }
          }
        }
        downframe.argumentCursor = 0;
      }
      downframe.inheritedPatternRecord = ControlFrame.operativePatternRecord(upframe);
      return (downframe);
    }
  }

  public static PatternRecord operativePatternRecord(ControlFrame frame) {
    return (((frame.patternRecord != null) ? frame.patternRecord : frame.inheritedPatternRecord));
  }

  public Keyword continuePartialStrategiesProofs(Keyword lastmove) {
    { ControlFrame self = this;

      if (self.currentStrategy == Logic.KWD_FULL_SUBQUERY) {
        return (ControlFrame.continueStrategiesProofs(self, lastmove));
      }
      { PartialMatchFrame pmf = self.partialMatchFrame;

        if (pmf == null) {
          ControlFrame.createAndLinkPartialMatchFrame(self, Logic.KWD_ATOMIC_GOAL);
        }
        return (self.partialMatchFrame.continuePartialStrategiesProofs(lastmove));
      }
    }
  }

  public static void attachSupport(ControlFrame frame, Keyword lastmove) {
    if ((!(lastmove == Logic.KWD_DOWN)) &&
        ((frame.currentStrategy == Logic.KWD_ANTECEDENTS) &&
         (Stella_Object.isaP(frame.partialMatchFrame, Logic.SGT_LOGIC_NN_PARTIAL_MATCH) &&
          (!(frame.partialMatchFrame.child == null))))) {
      { NnPartialMatch pmf = ((NnPartialMatch)(frame.partialMatchFrame));
        PartialSupport support = PartialSupport.newPartialSupport();

        support.id = Logic.$PARTIAL_SUPPORT_COUNTER$ = Logic.$PARTIAL_SUPPORT_COUNTER$ + 1;
        support.axiom = ((Proposition)(pmf.rules.value));
        support.fact = ((NnPartialMatch)(pmf.child)).controlFrame.proposition;
        support.argumentScores = Cons.copyConsList(((NnPartialMatch)(pmf.child)).argumentScores).reverse();
        support.score = ((FloatWrapper)(KeyValueList.dynamicSlotValue(support.fact.dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue;
        if (frame.proposition.support() != null) {
          KeyValueList.setDynamicSlotValue(frame.proposition.dynamicSlots, Logic.SYM_LOGIC_SUPPORT, Cons.cons(support, frame.proposition.support()), null);
        }
        else {
          KeyValueList.setDynamicSlotValue(frame.proposition.dynamicSlots, Logic.SYM_LOGIC_SUPPORT, Cons.consList(Cons.cons(support, Stella.NIL)), null);
        }
      }
    }
    else {
      KeyValueList.setDynamicSlotValue(frame.proposition.dynamicSlots, Logic.SYM_LOGIC_SUPPORT, null, null);
    }
  }

  public static Keyword oldInterpretGoalScores(ControlFrame frame, Keyword lastmove) {
    if (lastmove == Logic.KWD_DOWN) {
      { PartialMatchFrame pmf = frame.partialMatchFrame;

        if (pmf == null) {
          ControlFrame.createAndLinkPartialMatchFrame(frame, Logic.KWD_ATOMIC_GOAL);
        }
        else {
          pmf.setDynamicCutoff();
        }
      }
    }
    else if ((lastmove == Logic.KWD_UP_TRUE) ||
        (lastmove == Logic.KWD_UP_FAIL)) {
      if (Stella_Object.traceKeywordP(Logic.KWD_GOAL_TREE)) {
        Stella.STANDARD_OUTPUT.nativeStream.println("" + ((FloatWrapper)(KeyValueList.dynamicSlotValue(((QueryIterator)(Logic.$QUERYITERATOR$.get())).dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue);
      }
      if ((frame.currentStrategy == Logic.KWD_FULL_SUBQUERY) ||
          (frame.currentStrategy == Logic.KWD_ANTECEDENTS)) {
        ControlFrame.recordLatestPartialMatchScore(frame);
        if (ControlFrame.computePartialMatchOrSuccessP(frame) &&
            (!ControlFrame.unboundVariablesInFrameP(frame))) {
          lastmove = Logic.KWD_UP_TRUE;
        }
        else if (((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, null))).emptyP() &&
            ((!ControlFrame.unboundVariablesInFrameP(frame)) &&
             ControlFrame.computePartialMatchScoreP(frame))) {
          lastmove = Logic.KWD_UP_TRUE;
        }
        else {
          lastmove = Logic.KWD_UP_FAIL;
        }
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + lastmove + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    ControlFrame.attachSupport(frame, lastmove);
    if ((lastmove == Logic.KWD_UP_FAIL) &&
        (frame.down != null)) {
      frame.down = null;
    }
    { Keyword result = ControlFrame.continueStrategiesProofs(frame, lastmove);

      if ((result == Logic.KWD_FAILURE) &&
          ControlFrame.computePartialMatchScoreP(frame)) {
        lastmove = Logic.KWD_UP_TRUE;
        return (Logic.KWD_FINAL_SUCCESS);
      }
      else {
        return (result);
      }
    }
  }

  public Keyword continuePartialNotProof(Keyword lastmove) {
    { ControlFrame self = this;

      { PartialMatchFrame pmf = self.partialMatchFrame;

        if (pmf == null) {
          ControlFrame.createAndLinkPartialMatchFrame(self, Logic.KWD_NOT);
        }
        return (self.partialMatchFrame.continuePartialNotProof(lastmove));
      }
    }
  }

  public static Keyword oldInterpretFailScore(ControlFrame frame, Keyword lastmove) {
    if (lastmove == Logic.KWD_DOWN) {
      KeyValueList.setDynamicSlotValue(((QueryIterator)(Logic.$QUERYITERATOR$.get())).dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, FloatWrapper.wrapFloat(0.0), Stella.NULL_FLOAT_WRAPPER);
      if (frame.partialMatchFrame == null) {
        ControlFrame.createAndLinkPartialMatchFrame(frame, Logic.KWD_NOT);
      }
    }
    else if ((lastmove == Logic.KWD_UP_TRUE) ||
        (lastmove == Logic.KWD_UP_FAIL)) {
      ControlFrame.recordLatestPartialMatchScore(frame);
      if (ControlFrame.computePartialMatchScoreP(frame)) {
        lastmove = Logic.KWD_UP_TRUE;
      }
      else {
        lastmove = Logic.KWD_UP_FAIL;
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + lastmove + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    return (lastmove);
  }

  public Keyword continuePartialOrProof(Keyword lastmove) {
    { ControlFrame self = this;

      { PartialMatchFrame pmf = self.partialMatchFrame;

        if (pmf == null) {
          ControlFrame.createAndLinkPartialMatchFrame(self, Logic.KWD_OR);
        }
        return (self.partialMatchFrame.continuePartialOrProof(lastmove));
      }
    }
  }

  public static Keyword oldInterpretOrScores(ControlFrame frame, Keyword lastmove) {
    if (lastmove == Logic.KWD_DOWN) {
      { PartialMatchFrame pmf = frame.partialMatchFrame;

        if (pmf == null) {
          ControlFrame.createAndLinkPartialMatchFrame(frame, Logic.KWD_OR);
        }
        else {
          {
            while (frame.partialMatchFrame.argumentScores.length() > frame.argumentCursor) {
              frame.partialMatchFrame.popPartialMatchScore();
            }
            pmf.setDynamicCutoff();
          }
        }
      }
    }
    else if ((lastmove == Logic.KWD_UP_TRUE) ||
        (lastmove == Logic.KWD_UP_FAIL)) {
      ControlFrame.recordLatestPartialMatchScore(frame);
      if (Stella_Object.traceKeywordP(Logic.KWD_GOAL_TREE)) {
        Stella.STANDARD_OUTPUT.nativeStream.println(((FloatWrapper)(KeyValueList.dynamicSlotValue(((QueryIterator)(Logic.$QUERYITERATOR$.get())).dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue + ", " + frame.partialMatchFrame.computeOrScore());
      }
      if (ControlFrame.computePartialMatchOrSuccessP(frame)) {
        lastmove = Logic.KWD_UP_TRUE;
      }
      else if (((frame.argumentCursor + 1) == frame.proposition.arguments.length()) &&
          ControlFrame.computePartialMatchScoreP(frame)) {
        lastmove = Logic.KWD_UP_TRUE;
      }
      else {
        lastmove = Logic.KWD_UP_FAIL;
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + lastmove + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    return (lastmove);
  }

  public static Keyword interpretIterativeForallScores(ControlFrame frame, Keyword lastmove) {
    if (lastmove == Logic.KWD_DOWN) {
      if (frame.partialMatchFrame == null) {
        ControlFrame.createAndLinkPartialMatchFrame(frame, Logic.KWD_ITERATIVE_FORALL);
      }
      else {
        while (frame.partialMatchFrame.argumentScores.length() > frame.argumentCursor) {
          frame.partialMatchFrame.popPartialMatchScore();
        }
      }
    }
    else if ((lastmove == Logic.KWD_UP_TRUE) ||
        (lastmove == Logic.KWD_UP_FAIL)) {
      ControlFrame.recordLatestPartialMatchScore(frame);
      if (Stella_Object.traceKeywordP(Logic.KWD_GOAL_TREE)) {
        Stella.STANDARD_OUTPUT.nativeStream.println("ITERATIVE-FORALL " + ((FloatWrapper)(KeyValueList.dynamicSlotValue(((QueryIterator)(Logic.$QUERYITERATOR$.get())).dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue);
      }
      if (((FloatWrapper)(KeyValueList.dynamicSlotValue(((QueryIterator)(Logic.$QUERYITERATOR$.get())).dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue < 0.9) {
        lastmove = Logic.KWD_UP_FAIL;
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + lastmove + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    return (lastmove);
  }

  public Keyword continuePartialAndProof(ControlFrame frame, Keyword lastmove) {
    { ControlFrame self = this;

      { PartialMatchFrame pmf = self.partialMatchFrame;

        if (pmf == null) {
          ControlFrame.createAndLinkPartialMatchFrame(self, Logic.KWD_AND);
        }
        return (self.partialMatchFrame.continuePartialAndProof(frame, lastmove));
      }
    }
  }

  public static Keyword oldInterpretAndScores(ControlFrame frame, Keyword lastmove) {
    if (lastmove == Logic.KWD_DOWN) {
      { PartialMatchFrame pmf = frame.partialMatchFrame;

        if (pmf == null) {
          ControlFrame.createAndLinkPartialMatchFrame(frame, Logic.KWD_AND);
        }
        else {
          {
            while (frame.partialMatchFrame.argumentScores.length() > frame.argumentCursor) {
              frame.partialMatchFrame.popPartialMatchScore();
            }
            pmf.setDynamicCutoff();
          }
        }
      }
    }
    else if ((lastmove == Logic.KWD_UP_TRUE) ||
        (lastmove == Logic.KWD_UP_FAIL)) {
      { PartialMatchFrame pmf = frame.partialMatchFrame;
        int arity = frame.proposition.arguments.length();
        int i = 0;

        pmf.successP = lastmove == Logic.KWD_UP_TRUE;
        ControlFrame.recordLatestPartialMatchScore(frame);
        if (Stella_Object.traceKeywordP(Logic.KWD_GOAL_TREE)) {
          Stella.STANDARD_OUTPUT.nativeStream.println(((FloatWrapper)(KeyValueList.dynamicSlotValue(((QueryIterator)(Logic.$QUERYITERATOR$.get())).dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue + ", " + frame.partialMatchFrame.computeAndScore());
        }
        if (!(pmf.unboundVars == Stella.NIL)) {
          KeyValueList.setDynamicSlotValue(((QueryIterator)(Logic.$QUERYITERATOR$.get())).dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, FloatWrapper.wrapFloat(0.0), Stella.NULL_FLOAT_WRAPPER);
          loop001 : for (;;) {
            { boolean testValue000 = false;

              testValue000 = (frame.argumentCursor + 1) < arity;
              if (testValue000) {
                { boolean foundP000 = false;

                  { Stella_Object var = null;
                    Cons iter000 = Proposition.getUnboundVariables(((Proposition)((frame.proposition.arguments.theArray)[(frame.argumentCursor + 1)])));

                    loop002 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                      var = iter000.value;
                      if (Stella_Object.searchConsTreeP(pmf.unboundVars, var)) {
                        foundP000 = true;
                        break loop002;
                      }
                    }
                  }
                  testValue000 = foundP000;
                }
              }
              if (!(testValue000)) {
                break loop001;
              }
            }
            i = i + 1;
            frame.argumentCursor = frame.argumentCursor + 1;
            ControlFrame.recordLatestPartialMatchScore(frame);
          }
          pmf.unboundVars = Stella.NIL;
          if (Stella_Object.traceKeywordP(Logic.KWD_GOAL_TREE)) {
            Stella.STANDARD_OUTPUT.nativeStream.println("   *** Skipping " + i + " propositions . . .");
          }
        }
        if (Logic.$FAIL_UNBOUND_CLAUSESp$) {
          while (((frame.argumentCursor + 1) < arity) &&
              Proposition.allVariablesUnboundP(((Proposition)((frame.proposition.arguments.theArray)[(frame.argumentCursor + 1)])))) {
            i = i + 1;
            frame.argumentCursor = frame.argumentCursor + 1;
            KeyValueList.setDynamicSlotValue(((QueryIterator)(Logic.$QUERYITERATOR$.get())).dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, FloatWrapper.wrapFloat(0.0), Stella.NULL_FLOAT_WRAPPER);
            ControlFrame.recordLatestPartialMatchScore(frame);
          }
          if ((i > 0) &&
              Stella_Object.traceKeywordP(Logic.KWD_GOAL_TREE)) {
            Stella.STANDARD_OUTPUT.nativeStream.println("   *** Skipping " + i + " propositions . . .");
          }
        }
        if (ControlFrame.computePartialMatchAndFailureP(frame)) {
          lastmove = Logic.KWD_UP_FAIL;
        }
        else if (((frame.argumentCursor + 1) == arity) &&
            (!ControlFrame.computePartialMatchScoreP(frame))) {
          lastmove = Logic.KWD_UP_FAIL;
        }
        else {
          lastmove = Logic.KWD_UP_TRUE;
        }
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + lastmove + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    if ((lastmove == Logic.KWD_UP_FAIL) &&
        (frame.down != null)) {
      frame.down = null;
    }
    return (lastmove);
  }

  public static void traceGoalStack(ControlFrame frame) {
    if (frame == null) {
      frame = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentControlFrame;
    }
    { Cons frames = Cons.cons(frame, Stella.NIL);

      loop000 : for (;;) {
        frame = frame.up;
        if (frame == null) {
          break loop000;
        }
        else {
          frames = Cons.cons(frame, frames);
        }
      }
      { ControlFrame frm = null;
        Cons iter000 = frames;
        int i = Stella.NULL_INTEGER;
        int iter001 = 1;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
          frm = ((ControlFrame)(iter000.value));
          i = iter001;
          { Object old$Printinframe$000 = Logic.$PRINTINFRAME$.get();

            try {
              Native.setSpecial(Logic.$PRINTINFRAME$, frm);
              ControlFrame.traceGoalTree(frm, i, Logic.KWD_DOWN);

            } finally {
              Logic.$PRINTINFRAME$.set(old$Printinframe$000);
            }
          }
        }
      }
    }
  }

  public static void traceGoalTree(ControlFrame frame, int depth, Keyword lastmove) {
    if (lastmove == Logic.KWD_DOWN) {
      ControlFrame.unwindToChoicePointsBelowFrame(frame);
    }
    if (Logic.restrictedGoalTracingP() &&
        (!ControlFrame.traceThisGoalP(frame, lastmove))) {
      return;
    }
    if ((frame.state == Logic.KWD_ITERATIVE_FORALL) &&
        (lastmove == Logic.KWD_DOWN)) {
      return;
    }
    if (Stella_Object.traceKeywordP(Logic.KWD_STATE_MACHINE)) {
      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(frame), Logic.SGT_LOGIC_PARALLEL_CONTROL_FRAME)) {
        { ParallelControlFrame frame000 = ((ParallelControlFrame)(frame));

          Stella.STANDARD_OUTPUT.nativeStream.print("P" + ControlFrame.debugFrameId(frame000));
        }
      }
      else {
        Stella.STANDARD_OUTPUT.nativeStream.print("F" + ControlFrame.debugFrameId(frame));
      }
      if (frame.choicePointUnbindingOffset != Stella.NULL_INTEGER) {
        Stella.STANDARD_OUTPUT.nativeStream.print("," + frame.choicePointUnbindingOffset + " ");
      }
      else {
        Stella.STANDARD_OUTPUT.nativeStream.print("   ");
      }
      Stella.STANDARD_OUTPUT.nativeStream.print(((((frame.truthValue == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
          (frame.truthValue == Logic.DEFAULT_FALSE_TRUTH_VALUE)) ? "D " : "S ")));
    }
    if ((frame.state == Logic.KWD_PARALLEL_STRATEGIES) ||
        ((frame.state == Logic.KWD_STRATEGY) &&
         (frame.currentStrategy == null))) {
      return;
    }
    if (!((lastmove == Logic.KWD_DOWN) &&
        (Stella.getQuotedTree("((:ATOMIC-GOAL :STRATEGY) \"/LOGIC\")", "/LOGIC").memberP(frame.state) &&
         ((((Keyword)(frame.nextStrategies.value)) == Logic.KWD_SPECIALIST) &&
          (!Stella_Object.traceKeywordP(Logic.KWD_STRATEGIES)))))) {
      Logic.printVerticalBars(depth);
    }
    if (lastmove == Logic.KWD_DOWN) {
      { Keyword testValue000 = frame.state;

        if ((testValue000 == Logic.KWD_ATOMIC_GOAL) ||
            (testValue000 == Logic.KWD_STRATEGY)) {
          if (((Keyword)(frame.nextStrategies.value)) == Logic.KWD_SPECIALIST) {
            {
              if (Stella_Object.traceKeywordP(Logic.KWD_STRATEGIES)) {
                Stella.STANDARD_OUTPUT.nativeStream.print("TRY STRATEGIES: ");
              }
              return;
            }
          }
          else {
            {
              ControlFrame.printGoalInGoalTree(frame, depth);
              if (Stella_Object.traceKeywordP(Logic.KWD_STRATEGIES)) {
                Stella.STANDARD_OUTPUT.nativeStream.println();
                Logic.printVerticalBars(depth);
                Stella.STANDARD_OUTPUT.nativeStream.print("STRATEGY: ");
                return;
              }
            }
          }
        }
        else if (testValue000 == Logic.KWD_PATTERN) {
          if ((Stella.$TRACED_KEYWORDS$ != null) &&
              Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_STRATEGIES)) {
            Stella.STANDARD_OUTPUT.nativeStream.println();
          }
          { ControlFrame upframe = frame.up;

            if ((upframe != null) &&
                (((Proposition)(KeyValueList.dynamicSlotValue(upframe.dynamicSlots, Logic.SYM_LOGIC_ANTECEDENTS_RULE, null))) != null)) {
              ControlFrame.printRuleInGoalTree(frame, ((Proposition)(KeyValueList.dynamicSlotValue(upframe.dynamicSlots, Logic.SYM_LOGIC_ANTECEDENTS_RULE, null))), depth);
            }
            else {
              {
                if ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
                    (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) {
                  Stella.STANDARD_OUTPUT.nativeStream.println();
                }
                if (frame.patternRecord.collectionList != null) {
                  Stella.STANDARD_OUTPUT.nativeStream.print("COLLECTION: [");
                }
                else {
                  Stella.STANDARD_OUTPUT.nativeStream.print("PATTERN: [");
                }
                { boolean firsttimeP = true;

                  { BooleanWrapper tv = null;
                    BooleanVector vector000 = frame.patternRecord.booleanVector;
                    int index000 = 0;
                    int length000 = vector000.length();

                    for (;index000 < length000; index000 = index000 + 1) {
                      tv = ((BooleanWrapper)((vector000.theArray)[index000]));
                      if (firsttimeP) {
                        firsttimeP = false;
                      }
                      else {
                        Stella.STANDARD_OUTPUT.nativeStream.print(",");
                      }
                      if (BooleanWrapper.coerceWrappedBooleanToBoolean(tv)) {
                        Stella.STANDARD_OUTPUT.nativeStream.print("T");
                      }
                      else {
                        Stella.STANDARD_OUTPUT.nativeStream.print("F");
                      }
                    }
                  }
                }
                Stella.STANDARD_OUTPUT.nativeStream.print("]");
              }
            }
          }
        }
        else {
          ControlFrame.printGoalInGoalTree(frame, depth);
        }
      }
    }
    else if (lastmove == Logic.KWD_UP_TRUE) {
      if (true) {
        Stella.STANDARD_OUTPUT.nativeStream.print("| SUCC: ");
        { Object old$Printinframe$000 = Logic.$PRINTINFRAME$.get();

          try {
            Native.setSpecial(Logic.$PRINTINFRAME$, frame);
            ControlFrame.printVariableBindings(frame);

          } finally {
            Logic.$PRINTINFRAME$.set(old$Printinframe$000);
          }
        }
        { TruthValue truthvalue = frame.truthValue;

          if (truthvalue != null) {
            Stella.STANDARD_OUTPUT.nativeStream.print("truth=" + TruthValue.truthValueToString(truthvalue, true));
          }
        }
      }
    }
    else if (lastmove == Logic.KWD_UP_FAIL) {
      Stella.STANDARD_OUTPUT.nativeStream.print("| FAIL");
      { Keyword testValue001 = frame.state;

        if ((testValue001 == Logic.KWD_ATOMIC_GOAL) ||
            (testValue001 == Logic.KWD_STRATEGY)) {
          if (Stella_Object.traceKeywordP(Logic.KWD_STRATEGIES) &&
              (!(frame.nextStrategies == Stella.NIL))) {
            Stella.STANDARD_OUTPUT.nativeStream.println();
            Logic.printVerticalBars(depth);
            Stella.STANDARD_OUTPUT.nativeStream.print("TRY STRATEGIES: ");
            return;
          }
        }
        else {
        }
      }
      { TruthValue truthvalue = frame.truthValue;

        if ((truthvalue != null) ||
            (frame.partialMatchFrame != null)) {
          Stella.STANDARD_OUTPUT.nativeStream.print(":");
        }
        if (truthvalue != null) {
          Stella.STANDARD_OUTPUT.nativeStream.print(" truth=" + TruthValue.truthValueToString(truthvalue, true));
        }
      }
    }
    else {
      Stella.STANDARD_OUTPUT.nativeStream.print("????: ");
    }
    if (Stella_Object.traceKeywordP(Logic.KWD_STATE_MACHINE)) {
      Stella.STANDARD_OUTPUT.nativeStream.print(" state= " + frame.state + "  lastMove= " + lastmove + " depth= " + depth + " revPty?= " + frame.reversePolarityP);
    }
    if (!(frame.partialMatchFrame != null)) {
      Stella.STANDARD_OUTPUT.nativeStream.println();
    }
    else {
      Stella.STANDARD_OUTPUT.nativeStream.print(" ");
      if ((lastmove == Logic.KWD_DOWN) ||
          ((lastmove == Logic.KWD_UP_TRUE) ||
           (lastmove == Logic.KWD_UP_FAIL))) {
        frame.partialMatchFrame.traceFramePartialTruth(lastmove, Stella.STANDARD_OUTPUT);
        Stella.STANDARD_OUTPUT.nativeStream.println();
      }
      else {
      }
    }
  }

  public static boolean traceThisGoalP(ControlFrame frame, Keyword lastmove) {
    lastmove = lastmove;
    if (frame.state == Logic.KWD_ATOMIC_GOAL) {
      return (Logic.$TRACED_GOALS$.memberP(Logic.getDescription(frame.proposition.operator)));
    }
    else {
      return (false);
    }
  }

  public static void unwindToChoicePointsBelowFrame(ControlFrame frame) {
    while (frame.down != null) {
      frame = frame.down;
    }
    ControlFrame.unwindToChoicePoint(frame);
  }

  public static int computeFrameDepth(ControlFrame frame) {
    { int depth = 0;
      ControlFrame cursor = ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) ? ((QueryIterator)(Logic.$QUERYITERATOR$.get())).baseControlFrame : ((ControlFrame)(null)));

      loop000 : while (cursor != null) {
        if (cursor == frame) {
          break loop000;
        }
        cursor = cursor.down;
        depth = depth + 1;
      }
      if (cursor == frame) {
        return (depth);
      }
      else {
        return (Stella.NULL_INTEGER);
      }
    }
  }

  public static void printGoalInGoalTree(ControlFrame frame, int depth) {
    if (frame.proposition != null) {
      { boolean invertP = frame.reversePolarityP;

        Stella.STANDARD_OUTPUT.nativeStream.print("GOAL: ");
        if (invertP) {
          Stella.STANDARD_OUTPUT.nativeStream.print("~");
        }
        { Object old$Printmode$000 = Logic.$PRINTMODE$.get();
          Object old$Printlogicalformstream$000 = Logic.$PRINTLOGICALFORMSTREAM$.get();
          Object old$Indentcounter$000 = Logic.$INDENTCOUNTER$.get();

          try {
            Native.setSpecial(Logic.$PRINTMODE$, Logic.KWD_REALISTIC);
            Native.setSpecial(Logic.$PRINTLOGICALFORMSTREAM$, Stella.STANDARD_OUTPUT);
            Native.setIntSpecial(Logic.$INDENTCOUNTER$, (2 * depth) + 7);
            Logic.printUnformattedLogicalForm(frame.proposition, Stella.STANDARD_OUTPUT);
            if (frame.allottedClockTicks != Stella.NULL_INTEGER) {
              Stella.STANDARD_OUTPUT.nativeStream.print(" ticks=" + frame.allottedClockTicks);
            }

          } finally {
            Logic.$INDENTCOUNTER$.set(old$Indentcounter$000);
            Logic.$PRINTLOGICALFORMSTREAM$.set(old$Printlogicalformstream$000);
            Logic.$PRINTMODE$.set(old$Printmode$000);
          }
        }
      }
    }
    else {
      Stella.STANDARD_OUTPUT.nativeStream.print("STRATEGY: " + frame.up.currentStrategy);
    }
  }

  public static void printRuleInGoalTree(ControlFrame frame, Proposition impliesprop, int depth) {
    { PatternRecord patternrecord = frame.patternRecord;
      boolean reversepolarityP = frame.reversePolarityP;

      Stella.STANDARD_OUTPUT.nativeStream.print("RULE: ");
      { Surrogate rulename = ((Surrogate)(KeyValueList.dynamicSlotValue(impliesprop.dynamicSlots, Logic.SYM_STELLA_SURROGATE_VALUE_INVERSE, null)));

        if ((rulename == null) &&
            (((Proposition)(KeyValueList.dynamicSlotValue(impliesprop.dynamicSlots, Logic.SYM_LOGIC_MASTER_PROPOSITION, null))) != null)) {
          rulename = ((Surrogate)(KeyValueList.dynamicSlotValue(((Proposition)(KeyValueList.dynamicSlotValue(impliesprop.dynamicSlots, Logic.SYM_LOGIC_MASTER_PROPOSITION, null))).dynamicSlots, Logic.SYM_STELLA_SURROGATE_VALUE_INVERSE, null)));
        }
        if (rulename != null) {
          Stella.STANDARD_OUTPUT.nativeStream.println(rulename.symbolName);
          Logic.printIndent(Stella.STANDARD_OUTPUT, (2 * depth) + 6);
        }
      }
      { Object old$Printmode$000 = Logic.$PRINTMODE$.get();
        Object old$Printlogicalformstream$000 = Logic.$PRINTLOGICALFORMSTREAM$.get();
        Object old$Indentcounter$000 = Logic.$INDENTCOUNTER$.get();
        Object old$Queryiterator$000 = Logic.$QUERYITERATOR$.get();

        try {
          Native.setSpecial(Logic.$PRINTMODE$, Logic.KWD_FLAT);
          Native.setSpecial(Logic.$PRINTLOGICALFORMSTREAM$, Stella.STANDARD_OUTPUT);
          Native.setIntSpecial(Logic.$INDENTCOUNTER$, (2 * depth) + 7);
          Native.setSpecial(Logic.$QUERYITERATOR$, null);
          { Description chooseValue000 = null;

            if (reversepolarityP) {
              { Description temp000 = patternrecord.optimalPattern;

                chooseValue000 = ((temp000 != null) ? temp000 : patternrecord.description);
              }
            }
            else {
              chooseValue000 = ((Description)((impliesprop.arguments.theArray)[1]));
            }
            { Description chooseValue001 = null;

              if (reversepolarityP) {
                chooseValue001 = ((Description)((impliesprop.arguments.theArray)[0]));
              }
              else {
                { Description temp001 = patternrecord.optimalPattern;

                  chooseValue001 = ((temp001 != null) ? temp001 : patternrecord.description);
                }
              }
              Description.printDescriptionsAsKifRule(chooseValue000, chooseValue001, impliesprop, reversepolarityP);
            }
          }

        } finally {
          Logic.$QUERYITERATOR$.set(old$Queryiterator$000);
          Logic.$INDENTCOUNTER$.set(old$Indentcounter$000);
          Logic.$PRINTLOGICALFORMSTREAM$.set(old$Printlogicalformstream$000);
          Logic.$PRINTMODE$.set(old$Printmode$000);
        }
      }
    }
  }

  public static void printVariableBindings(ControlFrame frame) {
    { PatternRecord patternrecord = ControlFrame.operativePatternRecord(frame);
      Description description = null;

      if (patternrecord != null) {
        if (frame.state == Logic.KWD_CONTAINED_BY) {
          { Proposition memberproposition = ((Proposition)((frame.proposition.arguments.theArray)[0]));
            Stella_Object member = (memberproposition.arguments.theArray)[0];

            { Surrogate testValue000 = Stella_Object.safePrimaryType(member);

              if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
                { PatternVariable member000 = ((PatternVariable)(member));

                  PatternVariable.printOneVariableBinding(member000);
                }
              }
              else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_STELLA_LIST)) {
                { List member000 = ((List)(member));

                  { Stella_Object m = null;
                    Cons iter000 = member000.theConsList;

                    for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                      m = iter000.value;
                      PatternVariable.printOneVariableBinding(((PatternVariable)(m)));
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
          return;
        }
        description = patternrecord.optimalPattern;
        if (description != null) {
          { PatternVariable vbl = null;
            Vector vector000 = description.ioVariables;
            int index000 = 0;
            int length000 = vector000.length();

            for (;index000 < length000; index000 = index000 + 1) {
              vbl = ((PatternVariable)((vector000.theArray)[index000]));
              if ((patternrecord.variableBindings.theArray)[(vbl.boundToOffset)] != null) {
                PatternVariable.printOneVariableBinding(vbl);
              }
            }
          }
          { PatternVariable vbl = null;
            Vector vector001 = description.internalVariables;
            int index001 = 0;
            int length001 = vector001.length();

            for (;index001 < length001; index001 = index001 + 1) {
              vbl = ((PatternVariable)((vector001.theArray)[index001]));
              if ((patternrecord.variableBindings.theArray)[(vbl.boundToOffset)] != null) {
                PatternVariable.printOneVariableBinding(vbl);
              }
            }
          }
        }
      }
    }
  }

  public static void printControlFrameStack(ControlFrame frame) {
    Stella.STANDARD_OUTPUT.nativeStream.println(frame.toString());
    if (frame.down != null) {
      ControlFrame.printControlFrameStack(frame.down);
    }
  }

  public static boolean newBindingsSinceLastChoicePointP(ControlFrame frame) {
    return (frame.choicePointUnbindingOffset <= frame.inheritedPatternRecord.topUnbindingStackOffset);
  }

  public static void unwindToChoicePoint(ControlFrame frame) {
    { int choicepoint = frame.choicePointUnbindingOffset;

      if (choicepoint != Stella.NULL_INTEGER) {
        PatternRecord.unbindVariablesBeginningAt(frame.inheritedPatternRecord, choicepoint);
      }
    }
  }

  public static void createChoicePoint(ControlFrame frame) {
    { PatternRecord patternrecord = frame.inheritedPatternRecord;

      if ((Stella.$TRACED_KEYWORDS$ != null) &&
          Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_QUERY_STACKS)) {
        Stella.STANDARD_OUTPUT.nativeStream.println("create-choice-point: F " + ControlFrame.debugFrameId(frame) + " CP= " + frame.choicePointUnbindingOffset + " NEWCP= " + (patternrecord.topUnbindingStackOffset + 1));
      }
      if (frame.choicePointUnbindingOffset == Stella.NULL_INTEGER) {
        frame.choicePointUnbindingOffset = patternrecord.topUnbindingStackOffset + 1;
      }
      else {
        PatternRecord.unbindVariablesBeginningAt(patternrecord, frame.choicePointUnbindingOffset);
      }
    }
  }

  public static void resetCurrentPatternRecord(ControlFrame frame, Keyword localorparent) {
    if (localorparent == Logic.KWD_LOCAL) {
      ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord = frame.patternRecord;
    }
    else if (localorparent == Logic.KWD_PARENT) {
      if (frame.inheritedPatternRecord != null) {
        ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord = frame.inheritedPatternRecord;
      }
      else {
        ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).baseControlFrame.patternRecord;
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + localorparent + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static void popDownFrame(ControlFrame frame) {
    ControlFrame.popControlFrame(frame.down);
    frame.down = null;
  }

  public static void popFramesUpTo(ControlFrame frame) {
    if (frame.down != null) {
      ControlFrame.popFramesUpTo(frame.down);
    }
    if (frame.up != null) {
      frame.up.down = null;
    }
    ControlFrame.popControlFrame(frame);
  }

  public static void popControlFrame(ControlFrame frame) {
    if ((frame.state == Logic.KWD_PATTERN) ||
        (frame.state == Logic.KWD_CONTAINED_BY)) {
      ControlFrame.resetCurrentPatternRecord(frame, Logic.KWD_PARENT);
    }
    if (((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_CACHED_BINDINGS_ITERATOR, null))) != null) {
      ((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_CACHED_BINDINGS_ITERATOR, null))).free();
      KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_CACHED_BINDINGS_ITERATOR, null, null);
    }
    frame.choicePointUnbindingOffset = Stella.NULL_INTEGER;
    frame.free();
    frame.state = Logic.KWD_POPPED;
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { ControlFrame self = this;

      ControlFrame.printControlFrame(self, stream);
    }
  }

  public boolean deletedPSetter(boolean value) {
    { ControlFrame self = this;

      KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_STELLA_DELETED_OBJECTp, (value ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), null);
      return (value);
    }
  }

  public boolean deletedP() {
    { ControlFrame self = this;

      { BooleanWrapper deletedP = ((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_STELLA_DELETED_OBJECTp, null)));

        if (deletedP != null) {
          return (BooleanWrapper.coerceWrappedBooleanToBoolean(deletedP));
        }
        else {
          return (false);
        }
      }
    }
  }

  public static Stella_Object accessControlFrameSlotValue(ControlFrame self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_STELLA_STATE) {
      if (setvalueP) {
        self.state = ((Keyword)(value));
      }
      else {
        value = self.state;
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
    else if (slotname == Logic.SYM_LOGIC_STARTING_CLOCK_TICKS) {
      if (setvalueP) {
        self.startingClockTicks = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.startingClockTicks);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_ALLOTTED_CLOCK_TICKS) {
      if (setvalueP) {
        self.allottedClockTicks = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.allottedClockTicks);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_UP) {
      if (setvalueP) {
        self.up = ((ControlFrame)(value));
      }
      else {
        value = self.up;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_DOWN) {
      if (setvalueP) {
        self.down = ((ControlFrame)(value));
      }
      else {
        value = self.down;
      }
    }
    else if (slotname == Logic.SYM_STELLA_RESULT) {
      if (setvalueP) {
        self.result = ((ControlFrame)(value));
      }
      else {
        value = self.result;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_ARGUMENT_CURSOR) {
      if (setvalueP) {
        self.argumentCursor = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.argumentCursor);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_PATTERN_RECORD) {
      if (setvalueP) {
        self.patternRecord = ((PatternRecord)(value));
      }
      else {
        value = self.patternRecord;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_INHERITED_PATTERN_RECORD) {
      if (setvalueP) {
        self.inheritedPatternRecord = ((PatternRecord)(value));
      }
      else {
        value = self.inheritedPatternRecord;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_CHOICE_POINT_UNBINDING_OFFSET) {
      if (setvalueP) {
        self.choicePointUnbindingOffset = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.choicePointUnbindingOffset);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_CURRENT_STRATEGY) {
      if (setvalueP) {
        self.currentStrategy = ((Keyword)(value));
      }
      else {
        value = self.currentStrategy;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_NEXT_STRATEGIES) {
      if (setvalueP) {
        self.nextStrategies = ((Cons)(value));
      }
      else {
        value = self.nextStrategies;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_PARTIAL_MATCH_FRAME) {
      if (setvalueP) {
        self.partialMatchFrame = ((PartialMatchFrame)(value));
      }
      else {
        value = self.partialMatchFrame;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_JUSTIFICATIONS) {
      if (setvalueP) {
        self.justifications = ((List)(value));
      }
      else {
        value = self.justifications;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_GOAL_BINDINGS) {
      if (setvalueP) {
        self.goalBindings = ((Cons)(value));
      }
      else {
        value = self.goalBindings;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_CACHED_GOAL_RESULTp) {
      if (setvalueP) {
        self.cachedGoalResultP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.cachedGoalResultP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_DONT_CACHE_GOAL_FAILUREp) {
      if (setvalueP) {
        self.dontCacheGoalFailureP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.dontCacheGoalFailureP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, slotname, value, null);
      }
      else {
        value = self.dynamicSlots.lookup(slotname);
      }
    }
    return (value);
  }

  public BooleanWrapper badP() {
    { ControlFrame self = this;

      { BooleanWrapper answer = ((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_STELLA_BADp, null)));

        if (answer == null) {
          return (Stella.FALSE_WRAPPER);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public boolean holdsByDefaultP() {
    { ControlFrame self = this;

      return ((self.truthValue == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
          (self.truthValue == Logic.DEFAULT_FALSE_TRUTH_VALUE));
    }
  }

  public Surrogate primaryType() {
    { ControlFrame self = this;

      return (Logic.SGT_LOGIC_CONTROL_FRAME);
    }
  }

}

