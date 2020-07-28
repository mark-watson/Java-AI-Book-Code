//  -*- Mode: Java -*-
//
// IncrementalPartialMatch.java

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

public class IncrementalPartialMatch extends PartialMatchFrame {
    public double accumulatedScore;
    public double accumulatedWeight;
    public double totalWeight;
    public double maximumScore;

  public static IncrementalPartialMatch newIncrementalPartialMatch(Keyword kind, ControlFrame controlFrame) {
    { IncrementalPartialMatch self = null;

      self = new IncrementalPartialMatch();
      self.kind = kind;
      self.controlFrame = controlFrame;
      self.successP = false;
      self.unboundVars = Stella.NIL;
      self.argumentWeights = Stella.NIL;
      self.argumentScores = Stella.NIL;
      self.dynamicCutoff = Stella.NULL_FLOAT;
      self.negativeScore = Stella.NULL_FLOAT;
      self.positiveScore = Stella.NULL_FLOAT;
      self.maximumScore = 0.0;
      self.totalWeight = Stella.NULL_FLOAT;
      self.accumulatedWeight = 0.0;
      self.accumulatedScore = 0.0;
      self.child = null;
      self.parent = null;
      IncrementalPartialMatch.initializeIncrementalPartialMatch(self);
      return (self);
    }
  }

  public double computePartialTruth(QueryIterator query) {
    { IncrementalPartialMatch self = this;

      { ControlFrame baseframe = query.baseControlFrame;
        PartialMatchFrame partialmatchframe = query.partialMatchStrategy;
        FloatWrapper minimumscore = ((FloatWrapper)(query.options.lookup(Logic.KWD_MINIMUM_SCORE)));
        boolean maximizescoreP = !Stella_Object.eqlP(query.options.lookup(Logic.KWD_MAXIMIZE_SCOREp), Stella.FALSE_WRAPPER);
        double epsilon = 0.001;
        double latestscore = 0.0;
        double highestscore = 0.0;
        Justification bestjustification = null;

        if (partialmatchframe == null) {
          partialmatchframe = self;
          query.partialMatchStrategy = self;
        }
        partialmatchframe.dynamicCutoff = ((minimumscore != null) ? minimumscore.wrapperValue : epsilon);
        { Object old$Queryiterator$000 = Logic.$QUERYITERATOR$.get();
          Object old$GenerateAllProofsP$000 = Logic.$GENERATE_ALL_PROOFSp$.get();
          Object old$Inferencelevel$000 = Logic.$INFERENCELEVEL$.get();
          Object old$ReversepolarityP$000 = Logic.$REVERSEPOLARITYp$.get();

          try {
            Native.setSpecial(Logic.$QUERYITERATOR$, query);
            Native.setBooleanSpecial(Logic.$GENERATE_ALL_PROOFSp$, true);
            Native.setSpecial(Logic.$INFERENCELEVEL$, Logic.currentInferenceLevel());
            Native.setBooleanSpecial(Logic.$REVERSEPOLARITYp$, false);
            loop000 : for (;;) {
              if (!(query.nextP())) {
                break loop000;
              }
              latestscore = partialmatchframe.positiveScore;
              if (latestscore <= highestscore) {
                break loop000;
              }
              bestjustification = ((Justification)(KeyValueList.dynamicSlotValue(baseframe.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null)));
              highestscore = latestscore;
              partialmatchframe.dynamicCutoff = highestscore + epsilon;
              if ((!maximizescoreP) ||
                  TruthValue.knownTruthValueP(baseframe.truthValue)) {
                break loop000;
              }
            }

          } finally {
            Logic.$REVERSEPOLARITYp$.set(old$ReversepolarityP$000);
            Logic.$INFERENCELEVEL$.set(old$Inferencelevel$000);
            Logic.$GENERATE_ALL_PROOFSp$.set(old$GenerateAllProofsP$000);
            Logic.$QUERYITERATOR$.set(old$Queryiterator$000);
          }
        }
        KeyValueList.setDynamicSlotValue(baseframe.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, bestjustification, null);
        return (highestscore);
      }
    }
  }

  public QueryIterator retrievePartialSolutions(QueryIterator query) {
    { IncrementalPartialMatch self = this;

      { BooleanWrapper maximizescoreP = ((BooleanWrapper)(Logic.lookupQueryOption(query, Logic.KWD_MAXIMIZE_SCOREp)));

        if (maximizescoreP == Stella.TRUE_WRAPPER) {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: :MAXIMIZE-SCORE? option not yet implemented for partial retrieval in incremental partial match mode - ignoring it.");
        }
        { Object old$Queryiterator$000 = Logic.$QUERYITERATOR$.get();
          Object old$ReversepolarityP$000 = Logic.$REVERSEPOLARITYp$.get();
          Object old$GenerateAllProofsP$000 = Logic.$GENERATE_ALL_PROOFSp$.get();
          Object old$Inferencelevel$000 = Logic.$INFERENCELEVEL$.get();

          try {
            Native.setSpecial(Logic.$QUERYITERATOR$, query);
            Native.setBooleanSpecial(Logic.$REVERSEPOLARITYp$, false);
            Native.setBooleanSpecial(Logic.$GENERATE_ALL_PROOFSp$, false);
            Native.setSpecial(Logic.$INFERENCELEVEL$, Logic.currentInferenceLevel());
            { int i = Stella.NULL_INTEGER;
              int iter000 = 1;
              int upperBound000 = Logic.lookupHowManySolutions(query);
              boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;
              QuerySolution solution = null;
              QueryIterator iter001 = query;

              for (;(unboundedP000 ||
                        (iter000 <= upperBound000)) &&
                        iter001.nextP(); iter000 = iter000 + 1) {
                i = iter000;
                solution = ((QuerySolution)(iter001.value));
                {
                  solution = solution;
                  i = i;
                }
              }
            }
            return (query);

          } finally {
            Logic.$INFERENCELEVEL$.set(old$Inferencelevel$000);
            Logic.$GENERATE_ALL_PROOFSp$.set(old$GenerateAllProofsP$000);
            Logic.$REVERSEPOLARITYp$.set(old$ReversepolarityP$000);
            Logic.$QUERYITERATOR$.set(old$Queryiterator$000);
          }
        }
      }
    }
  }

  public Keyword continuePartialFailProof(Keyword lastmove) {
    { IncrementalPartialMatch self = this;

      { ControlFrame frame = self.controlFrame;

        if (lastmove == Logic.KWD_DOWN) {
          self.setDynamicCutoff();
        }
        else if (lastmove == Logic.KWD_UP_TRUE) {
          { ControlFrame result = frame.result;
            PartialMatchFrame resultpmf = result.partialMatchFrame;

            resultpmf.positiveScore = resultpmf.positiveScore * resultpmf.propositionWeight(result.proposition) * -1.0;
            resultpmf.propagateFramePartialTruth(frame);
          }
        }
        else if (lastmove == Logic.KWD_UP_FAIL) {
          { ControlFrame result = frame.result;
            PartialMatchFrame resultpmf = result.partialMatchFrame;

            resultpmf.positiveScore = ((((Keyword)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_INFERENCE_CUTOFF_REASON, null))) != null) ? 0.0 : (resultpmf.positiveScore * resultpmf.propositionWeight(result.proposition) * -1.0));
            resultpmf.propagateFramePartialTruth(frame);
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + lastmove + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
        return (ControlFrame.continueFailProof(self.controlFrame, lastmove));
      }
    }
  }

  public Keyword continuePartialAntecedentsProof(Keyword lastmove) {
    { IncrementalPartialMatch self = this;

      { ControlFrame frame = self.controlFrame;
        Proposition goal = ControlFrame.extractSubgoalOfFrame(frame);
        double score = Stella.NULL_FLOAT;
        Keyword result = null;

        if (lastmove == Logic.KWD_DOWN) {
          self.setDynamicCutoff();
        }
        else if ((lastmove == Logic.KWD_UP_TRUE) ||
            (lastmove == Logic.KWD_UP_FAIL)) {
          score = frame.result.partialMatchFrame.positiveScore;
          self.pushOrPartialMatchScore(score, self.propositionWeight(((Proposition)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_ANTECEDENTS_RULE, null)))));
          score = self.computeGoalScore();
          self.setFramePartialTruth(null, score, Stella.NULL_FLOAT, false);
          if (((!Proposition.allArgumentsBoundP(goal)) &&
              (!self.allowUnboundVariablesP())) ||
              self.cutoffPartialMatchP(Stella_Object.traceKeywordP(Logic.KWD_GOAL_TREE))) {
            self.setFramePartialTruth(Logic.UNKNOWN_TRUTH_VALUE, 0.0, Stella.NULL_FLOAT, true);
            lastmove = Logic.KWD_UP_FAIL;
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
        result = ControlFrame.continueAntecedentsProof(frame, lastmove);
        if ((lastmove == Logic.KWD_UP_TRUE) &&
            (frame.truthValue == null)) {
          frame.truthValue = Logic.UNKNOWN_TRUTH_VALUE;
        }
        return (result);
      }
    }
  }

  public Keyword continuePartialStrategiesProofs(Keyword lastmove) {
    { IncrementalPartialMatch self = this;

      { ControlFrame frame = self.controlFrame;
        Keyword result = null;

        if (lastmove == Logic.KWD_DOWN) {
          self.setDynamicCutoff();
        }
        else if (lastmove == Logic.KWD_UP_FAIL) {
          if (frame.down != null) {
            frame.down = null;
          }
        }
        else {
        }
        loop000 : for (;;) {
          result = ControlFrame.continueStrategiesProofs(frame, lastmove);
          if (result == Logic.KWD_CONTINUING_SUCCESS) {
            if (self.cutoffPartialMatchP(Stella_Object.traceKeywordP(Logic.KWD_GOAL_TREE))) {
              lastmove = Logic.KWD_DOWN;
            }
            else {
              break loop000;
            }
          }
          else {
            break loop000;
          }
        }
        return (result);
      }
    }
  }

  public double computeGoalScore() {
    { IncrementalPartialMatch self = this;

      { double score = 0.0;

        if (Logic.$RULE_COMBINATION$ == Logic.KWD_MAX) {
          score = self.maximumScore;
        }
        else if (Logic.$RULE_COMBINATION$ == Logic.KWD_NOISY_OR) {
          score = Logic.probabilisticSumN(self.argumentScores);
        }
        else {
        }
        return (score);
      }
    }
  }

  public Keyword continuePartialNotProof(Keyword lastmove) {
    { IncrementalPartialMatch self = this;

      { ControlFrame frame = self.controlFrame;

        if (lastmove == Logic.KWD_DOWN) {
          self.setDynamicCutoff();
        }
        else if ((lastmove == Logic.KWD_UP_TRUE) ||
            (lastmove == Logic.KWD_UP_FAIL)) {
          { ControlFrame result = frame.result;
            PartialMatchFrame resultpmf = result.partialMatchFrame;

            resultpmf.positiveScore = resultpmf.positiveScore * resultpmf.propositionWeight(result.proposition);
            resultpmf.propagateFramePartialTruth(frame);
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + lastmove + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
        return (ControlFrame.continueNotProof(self.controlFrame, lastmove));
      }
    }
  }

  public double computeNotScore() {
    { IncrementalPartialMatch self = this;

      return (0.0 - (self.accumulatedScore / self.totalWeight));
    }
  }

  public Keyword continuePartialOrProof(Keyword lastmove) {
    { IncrementalPartialMatch self = this;

      { ControlFrame frame = self.controlFrame;
        Proposition orproposition = frame.proposition;
        Keyword result = null;

        if (lastmove == Logic.KWD_DOWN) {
          self.setDynamicCutoff();
        }
        else if ((lastmove == Logic.KWD_UP_TRUE) ||
            (lastmove == Logic.KWD_UP_FAIL)) {
          { boolean sucessP = lastmove == Logic.KWD_UP_TRUE;
            ControlFrame result000 = frame.result;
            Vector disjuncts = orproposition.arguments;
            Proposition disjunct = ((Proposition)((disjuncts.theArray)[(frame.argumentCursor)]));
            double score = Stella.NULL_FLOAT;

            score = result000.partialMatchFrame.positiveScore;
            self.pushOrPartialMatchScore(score, self.propositionWeight(disjunct));
            score = self.computeOrScore();
            self.setFramePartialTruth(null, score, Stella.NULL_FLOAT, false);
            if (((!Proposition.allArgumentsBoundP(disjunct)) &&
                (!self.allowUnboundVariablesP())) ||
                (self.cutoffPartialMatchP(Stella_Object.traceKeywordP(Logic.KWD_GOAL_TREE)) ||
                 ((!sucessP) &&
                  (frame.argumentCursor == (disjuncts.length() - 1))))) {
              self.setFramePartialTruth(Logic.UNKNOWN_TRUTH_VALUE, 0.0, Stella.NULL_FLOAT, true);
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
        result = ControlFrame.continueOrProof(frame, lastmove);
        if (result == Logic.KWD_MOVE_DOWN) {
          { int i = Stella.NULL_INTEGER;
            int iter000 = frame.argumentCursor;
            int upperBound000 = self.argumentScores.length() - 1;

            for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
              i = iter000;
              i = i;
              self.popOrPartialMatchScore();
            }
          }
        }
        else if (result == Logic.KWD_FAILURE) {
          self.setFramePartialTruth(null, self.computeOrScore(), Stella.NULL_FLOAT, false);
        }
        else {
        }
        return (result);
      }
    }
  }

  public double computeOrScore() {
    { IncrementalPartialMatch self = this;

      return (self.maximumScore);
    }
  }

  public void popOrPartialMatchScore() {
    { IncrementalPartialMatch self = this;

      { double latestscore = ((FloatWrapper)(self.argumentScores.value)).wrapperValue * ((FloatWrapper)(self.argumentWeights.value)).wrapperValue;
        double maximumscore = self.maximumScore;

        self.popAndPartialMatchScore();
        if (latestscore == maximumscore) {
          maximumscore = 0.0;
          { FloatWrapper score = null;
            Cons iter000 = self.argumentScores;
            FloatWrapper weight = null;
            Cons iter001 = self.argumentWeights;

            for (;(!(iter000 == Stella.NIL)) &&
                      (!(iter001 == Stella.NIL)); iter000 = iter000.rest, iter001 = iter001.rest) {
              score = ((FloatWrapper)(iter000.value));
              weight = ((FloatWrapper)(iter001.value));
              if ((score.wrapperValue * weight.wrapperValue) > maximumscore) {
                maximumscore = score.wrapperValue * weight.wrapperValue;
              }
            }
          }
          self.maximumScore = maximumscore;
        }
      }
    }
  }

  public void pushOrPartialMatchScore(double score, double weight) {
    { IncrementalPartialMatch self = this;

      if (weight == Stella.NULL_FLOAT) {
        weight = 1.0;
      }
      self.pushAndPartialMatchScore(score, weight);
      score = score * weight;
      if (score > self.maximumScore) {
        self.maximumScore = score;
      }
    }
  }

  public Keyword continuePartialAndProof(ControlFrame frame, Keyword lastmove) {
    { IncrementalPartialMatch self = this;

      { Cons forbiddenvars = Stella.NIL;

        if (lastmove == Logic.KWD_DOWN) {
          self.setDynamicCutoff();
        }
        else if ((lastmove == Logic.KWD_UP_TRUE) ||
            (lastmove == Logic.KWD_UP_FAIL)) {
          { boolean successP = lastmove == Logic.KWD_UP_TRUE;
            Proposition andproposition = frame.proposition;
            ControlFrame conjunctframe = frame.result;
            Proposition conjunct = conjunctframe.proposition;
            double score = conjunctframe.partialMatchFrame.positiveScore;
            double weight = self.propositionWeight(conjunct);

            lastmove = Logic.KWD_UP_TRUE;
            self.pushAndPartialMatchScore(score, weight);
            if (conjunctframe.partialMatchFrame.cutoffPartialMatchP(Stella_Object.traceKeywordP(Logic.KWD_GOAL_TREE))) {
              lastmove = Logic.KWD_UP_FAIL;
            }
            else if (((conjunctframe.truthValue == Logic.FALSE_TRUTH_VALUE) ||
                (conjunctframe.truthValue == Logic.DEFAULT_FALSE_TRUTH_VALUE)) &&
                ((conjunctframe.truthValue == Logic.TRUE_TRUTH_VALUE) ||
                 (conjunctframe.truthValue == Logic.FALSE_TRUTH_VALUE))) {
              lastmove = Logic.KWD_UP_FAIL;
            }
            else if (BooleanWrapper.coerceWrappedBooleanToBoolean(conjunct.variableTypeP()) &&
                (!successP)) {
              lastmove = Logic.KWD_UP_FAIL;
            }
            else {
              if (frame.argumentCursor == (andproposition.arguments.length() - 1)) {
                score = self.computeAndScore();
                if ((score <= Logic.$MINIMUM_SCORE_CUTOFF$) ||
                    ((!Proposition.allArgumentsBoundP(andproposition)) &&
                     (!self.allowUnboundVariablesP()))) {
                  lastmove = Logic.KWD_UP_FAIL;
                }
                else {
                  self.setFramePartialTruth(null, score, Stella.NULL_FLOAT, false);
                }
              }
            }
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + lastmove + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
        if (lastmove == Logic.KWD_UP_FAIL) {
          frame.down = null;
        }
        { Keyword result = ControlFrame.continueAndProof(frame, lastmove);

          if (result == Logic.KWD_MOVE_DOWN) {
            { int i = Stella.NULL_INTEGER;
              int iter000 = frame.argumentCursor;
              int upperBound000 = self.argumentScores.length() - 1;

              for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
                i = iter000;
                i = i;
                self.popAndPartialMatchScore();
              }
            }
            if (self.skipAndClauseP(frame, forbiddenvars)) {
              result = self.continuePartialAndProof(frame, Logic.KWD_UP_FAIL);
            }
          }
          else if (result == Logic.KWD_FAILURE) {
            self.setFramePartialTruth(frame.truthValue, Stella.NULL_FLOAT, Stella.NULL_FLOAT, false);
          }
          else {
          }
          return (result);
        }
      }
    }
  }

  public boolean skipAndClauseP(ControlFrame frame, Cons forbiddenvars) {
    { IncrementalPartialMatch self = this;

      { boolean forbiddenvarsP = !(forbiddenvars == Stella.NIL);
        boolean failunconstrainedclausesP = Logic.$FAIL_UNBOUND_CLAUSESp$;
        Stella_Object conjunct = (frame.proposition.arguments.theArray)[(frame.argumentCursor)];

        { boolean testValue000 = false;

          testValue000 = forbiddenvarsP;
          if (testValue000) {
            { boolean foundP000 = false;

              { Stella_Object var = null;
                Cons iter000 = Proposition.getUnboundVariables(((Proposition)(conjunct)));

                loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  var = iter000.value;
                  if (forbiddenvars.memberP(var)) {
                    foundP000 = true;
                    break loop000;
                  }
                }
              }
              testValue000 = foundP000;
            }
          }
          if (!testValue000) {
            testValue000 = failunconstrainedclausesP &&
                Proposition.allVariablesUnboundP(((Proposition)(conjunct)));
          }
          if (testValue000) {
            { ControlFrame result = ControlFrame.createDownFrame(frame, ((Proposition)(conjunct)));

              ControlFrame.setFrameTruthValue(result, Logic.UNKNOWN_TRUTH_VALUE);
              if (result.partialMatchFrame == null) {
                ControlFrame.createAndLinkPartialMatchFrame(result, null);
              }
              result.partialMatchFrame.setFramePartialTruth(Logic.UNKNOWN_TRUTH_VALUE, 0.0, Stella.NULL_FLOAT, true);
              { PrimitiveStrategy self001 = PrimitiveStrategy.newPrimitiveStrategy();

                self001.inferenceRule = Logic.KWD_SKIPPED_CONJUNCT;
                self001.strategy = Logic.KWD_FAILURE;
                ControlFrame.recordGoalJustification(result, self001);
              }
              result.state = Logic.KWD_POPPED;
              (((Vector)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ARGUMENTS, null))).theArray)[(frame.argumentCursor)] = result;
              frame.result = result;
              if (Stella_Object.traceKeywordP(Logic.KWD_GOAL_TREE)) {
                Stella.STANDARD_OUTPUT.nativeStream.println("*** Skipping clause " + conjunct);
              }
              return (true);
            }
          }
        }
        return (false);
      }
    }
  }

  public double computeAndScore() {
    { IncrementalPartialMatch self = this;

      return (self.accumulatedScore / self.totalWeight);
    }
  }

  public void popAndPartialMatchScore() {
    { IncrementalPartialMatch self = this;

      self.accumulatedScore = self.accumulatedScore - (((FloatWrapper)(self.argumentScores.value)).wrapperValue * ((FloatWrapper)(self.argumentWeights.value)).wrapperValue);
      self.accumulatedWeight = self.accumulatedWeight - ((FloatWrapper)(self.argumentWeights.value)).wrapperValue;
      self.argumentScores = self.argumentScores.rest;
      self.argumentWeights = self.argumentWeights.rest;
    }
  }

  public void pushAndPartialMatchScore(double score, double weight) {
    { IncrementalPartialMatch self = this;

      if (weight == Stella.NULL_FLOAT) {
        weight = 1.0;
      }
      self.argumentScores = Cons.cons(FloatWrapper.wrapFloat(score), self.argumentScores);
      self.argumentWeights = Cons.cons(FloatWrapper.wrapFloat(weight), self.argumentWeights);
      self.accumulatedScore = self.accumulatedScore + (score * weight);
      self.accumulatedWeight = self.accumulatedWeight + weight;
    }
  }

  public double propositionWeight(Proposition proposition) {
    { IncrementalPartialMatch self = this;

      if (proposition == null) {
        return (1.0);
      }
      else if (BooleanWrapper.coerceWrappedBooleanToBoolean(proposition.variableTypeP())) {
        return (0.0);
      }
      else if (Proposition.auxiliaryEquivalencePropositionP(proposition)) {
        return (0.0);
      }
      else if (((FloatWrapper)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, Stella.NULL_FLOAT_WRAPPER))).wrapperValue != Stella.NULL_FLOAT) {
        return (((FloatWrapper)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, Stella.NULL_FLOAT_WRAPPER))).wrapperValue);
      }
      else if (((TruthValue)(Stella_Object.accessInContext(proposition.truthValue, proposition.homeContext, false))) != null) {
        return (((TruthValue)(Stella_Object.accessInContext(proposition.truthValue, proposition.homeContext, false))).positiveScore);
      }
      else {
        return (1.0);
      }
    }
  }

  public void clearFramePartialTruth() {
    { IncrementalPartialMatch self = this;

      self.positiveScore = Stella.NULL_FLOAT;
      self.negativeScore = Stella.NULL_FLOAT;
      self.maximumScore = 0.0;
    }
  }

  public double computeDynamicCutoff() {
    { IncrementalPartialMatch self = this;

      { IncrementalPartialMatch parent = ((IncrementalPartialMatch)(self.parent));
        double cutoff = 0.0;

        if (parent != null) {
          if (parent.kind == Logic.KWD_AND) {
            { double pcutoff = parent.dynamicCutoff;
              double totweight = parent.totalWeight;
              double propweight = self.propositionWeight(self.controlFrame.proposition);
              double weight = ((propweight == Stella.NULL_FLOAT) ? 1.0 : (((propweight < 0.1) ? 0.1 : propweight)));
              double maxother = (totweight - parent.accumulatedWeight) - weight;
              double unscaledcutoff = ((pcutoff * totweight) - parent.accumulatedScore) - maxother;

              cutoff = unscaledcutoff / weight;
            }
          }
          else {
            cutoff = parent.dynamicCutoff;
          }
          if ((cutoff < 0.0) &&
              (!self.controlFrame.reversePolarityP)) {
            cutoff = 0.0;
          }
          else if ((cutoff > 0.0) &&
              self.controlFrame.reversePolarityP) {
            cutoff = 0.0;
          }
          else if (!(self.controlFrame.reversePolarityP == parent.controlFrame.reversePolarityP)) {
            cutoff = 0 - cutoff;
          }
        }
        return (cutoff);
      }
    }
  }

  public PartialMatchFrame createPartialMatchFrame(ControlFrame frame, Keyword kind) {
    { IncrementalPartialMatch self = this;

      return (IncrementalPartialMatch.newIncrementalPartialMatch(kind, frame));
    }
  }

  public static void initializeIncrementalPartialMatch(IncrementalPartialMatch self) {
    { ControlFrame frame = self.controlFrame;
      Keyword kind = self.kind;

      if (kind == Logic.KWD_AND) {
        { double argumentweight = Stella.NULL_FLOAT;
          double totalweight = 0.0;
          int nofweightedargs = 0;

          { Proposition arg = null;
            Vector vector000 = ((Vector)(frame.proposition.arguments));
            int index000 = 0;
            int length000 = vector000.length();

            for (;index000 < length000; index000 = index000 + 1) {
              arg = ((Proposition)((vector000.theArray)[index000]));
              if ((arg.kind == Logic.KWD_AND) &&
                  (((FloatWrapper)(KeyValueList.dynamicSlotValue(arg.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, Stella.NULL_FLOAT_WRAPPER))).wrapperValue == Stella.NULL_FLOAT)) {
                nofweightedargs = 0;
                { Proposition subarg = null;
                  Vector vector001 = ((Vector)(arg.arguments));
                  int index001 = 0;
                  int length001 = vector001.length();

                  for (;index001 < length001; index001 = index001 + 1) {
                    subarg = ((Proposition)((vector001.theArray)[index001]));
                    if ((self.propositionWeight(subarg) == Stella.NULL_FLOAT) ||
                        (self.propositionWeight(subarg) > 0.0)) {
                      nofweightedargs = nofweightedargs + 1;
                    }
                  }
                }
                argumentweight = 1.0 * nofweightedargs;
                KeyValueList.setDynamicSlotValue(arg.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, FloatWrapper.wrapFloat(argumentweight), Stella.NULL_FLOAT_WRAPPER);
              }
              else {
                argumentweight = self.propositionWeight(arg);
              }
              totalweight = totalweight + argumentweight;
            }
          }
          if (totalweight > 0.0) {
            self.totalWeight = totalweight;
          }
          else {
            self.totalWeight = ((double)(frame.proposition.arguments.length()));
          }
        }
      }
      else {
      }
      PartialMatchFrame.linkToParentPartialMatchFrame(self);
    }
  }

  public static Stella_Object accessIncrementalPartialMatchSlotValue(IncrementalPartialMatch self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_PARENT) {
      if (setvalueP) {
        self.parent = ((IncrementalPartialMatch)(value));
      }
      else {
        value = ((IncrementalPartialMatch)(self.parent));
      }
    }
    else if (slotname == Logic.SYM_LOGIC_CHILD) {
      if (setvalueP) {
        self.child = ((IncrementalPartialMatch)(value));
      }
      else {
        value = ((IncrementalPartialMatch)(self.child));
      }
    }
    else if (slotname == Logic.SYM_LOGIC_ACCUMULATED_SCORE) {
      if (setvalueP) {
        self.accumulatedScore = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.accumulatedScore);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_ACCUMULATED_WEIGHT) {
      if (setvalueP) {
        self.accumulatedWeight = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.accumulatedWeight);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_TOTAL_WEIGHT) {
      if (setvalueP) {
        self.totalWeight = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.totalWeight);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_MAXIMUM_SCORE) {
      if (setvalueP) {
        self.maximumScore = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.maximumScore);
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
    { IncrementalPartialMatch self = this;

      return (Logic.SGT_LOGIC_INCREMENTAL_PARTIAL_MATCH);
    }
  }

}

