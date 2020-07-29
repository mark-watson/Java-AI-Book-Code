//  -*- Mode: Java -*-
//
// NnPartialMatch.java

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

public class NnPartialMatch extends PartialMatchFrame {
    public double accumulatedScore;
    public double maximumScore;
    public Cons rules;
    public int arity;

  public static NnPartialMatch newNnPartialMatch(Keyword kind, ControlFrame controlFrame) {
    { NnPartialMatch self = null;

      self = new NnPartialMatch();
      self.kind = kind;
      self.controlFrame = controlFrame;
      self.successP = false;
      self.unboundVars = Stella.NIL;
      self.argumentWeights = Stella.NIL;
      self.argumentScores = Stella.NIL;
      self.dynamicCutoff = Stella.NULL_FLOAT;
      self.negativeScore = Stella.NULL_FLOAT;
      self.positiveScore = Stella.NULL_FLOAT;
      self.arity = Stella.NULL_INTEGER;
      self.rules = Stella.NIL;
      self.maximumScore = 0.0;
      self.accumulatedScore = 0.0;
      self.child = null;
      self.parent = null;
      self.initializeNnPartialMatch();
      return (self);
    }
  }

  public double computePartialTruth(QueryIterator query) {
    { NnPartialMatch self = this;

      { Proposition proposition = query.baseControlFrame.proposition;
        PartialMatchFrame partialmatchframe = query.partialMatchStrategy;
        FloatWrapper minimumscore = ((FloatWrapper)(query.options.lookup(Logic.KWD_MINIMUM_SCORE)));
        boolean maximizescoreP = !Stella_Object.eqlP(query.options.lookup(Logic.KWD_MAXIMIZE_SCOREp), Stella.FALSE_WRAPPER);
        double epsilon = 0.001;
        double latestscore = 0.0;
        double highestscore = 0.0;
        List scorelist = List.newList();
        double weight = 0.0;
        List netlist = null;
        List activationlist = null;
        Cons support = null;

        if (partialmatchframe == null) {
          partialmatchframe = self;
          query.partialMatchStrategy = self;
        }
        partialmatchframe.dynamicCutoff = ((minimumscore != null) ? minimumscore.wrapperValue : epsilon);
        Logic.$ACTIVATED_NETWORKS$ = List.newList();
        { Object old$Queryiterator$000 = Logic.$QUERYITERATOR$.get();

          try {
            Native.setSpecial(Logic.$QUERYITERATOR$, query);
            loop000 : for (;;) {
              KeyValueList.setDynamicSlotValue(query.dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, FloatWrapper.wrapFloat(0.0), Stella.NULL_FLOAT_WRAPPER);
              if (!(query.nextP())) {
                break loop000;
              }
              latestscore = ((FloatWrapper)(KeyValueList.dynamicSlotValue(query.dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue;
              if (scorelist.memberP(FloatWrapper.wrapFloat(latestscore))) {
                break loop000;
              }
              if (latestscore > highestscore) {
                support = proposition.support();
                activationlist = List.newList();
                netlist = Logic.$ACTIVATED_NETWORKS$;
                { PropositionNeuralNetwork net = null;
                  Cons iter000 = Logic.$ACTIVATED_NETWORKS$.theConsList;

                  for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                    net = ((PropositionNeuralNetwork)(iter000.value));
                    { List propscores = List.newList();

                      { Stella_Object prop = null;
                        Vector vector000 = net.proposition.arguments;
                        int index000 = 0;
                        int length000 = vector000.length();
                        Cons collect000 = null;

                        for (;index000 < length000; index000 = index000 + 1) {
                          prop = (vector000.theArray)[index000];
                          if (collect000 == null) {
                            {
                              collect000 = Cons.cons(FloatWrapper.wrapFloat(((FloatWrapper)(KeyValueList.dynamicSlotValue(((Proposition)(prop)).dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue), Stella.NIL);
                              if (propscores.theConsList == Stella.NIL) {
                                propscores.theConsList = collect000;
                              }
                              else {
                                Cons.addConsToEndOfConsList(propscores.theConsList, collect000);
                              }
                            }
                          }
                          else {
                            {
                              collect000.rest = Cons.cons(FloatWrapper.wrapFloat(((FloatWrapper)(KeyValueList.dynamicSlotValue(((Proposition)(prop)).dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue), Stella.NIL);
                              collect000 = collect000.rest;
                            }
                          }
                        }
                      }
                      activationlist.push(propscores);
                    }
                  }
                }
                activationlist = activationlist.reverse();
              }
              weight = ((FloatWrapper)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, Stella.NULL_FLOAT_WRAPPER))).wrapperValue;
              if (weight != Stella.NULL_FLOAT) {
                latestscore = latestscore * weight;
              }
              if (latestscore > highestscore) {
                highestscore = latestscore;
              }
              partialmatchframe.dynamicCutoff = highestscore + epsilon;
              if ((!maximizescoreP) ||
                  (highestscore == 1.0)) {
                break loop000;
              }
              scorelist.push(FloatWrapper.wrapFloat(latestscore));
            }

          } finally {
            Logic.$QUERYITERATOR$.set(old$Queryiterator$000);
          }
        }
        if (support != null) {
          KeyValueList.setDynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_SUPPORT, support, null);
          { PropositionNeuralNetwork net = null;
            Cons iter001 = netlist.reverse().theConsList;
            List scorelist000 = null;
            Cons iter002 = activationlist.reverse().theConsList;

            for (;(!(iter001 == Stella.NIL)) &&
                      (!(iter002 == Stella.NIL)); iter001 = iter001.rest, iter002 = iter002.rest) {
              net = ((PropositionNeuralNetwork)(iter001.value));
              scorelist000 = ((List)(iter002.value));
              { Stella_Object prop = null;
                Vector vector001 = net.proposition.arguments;
                int index001 = 0;
                int length001 = vector001.length();
                FloatWrapper k = null;
                Cons iter003 = scorelist000.theConsList;

                for (;(index001 < length001) &&
                          (!(iter003 == Stella.NIL)); index001 = index001 + 1, iter003 = iter003.rest) {
                  prop = (vector001.theArray)[index001];
                  k = ((FloatWrapper)(iter003.value));
                  KeyValueList.setDynamicSlotValue(((Proposition)(prop)).dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, FloatWrapper.wrapFloat(k.wrapperValue), Stella.NULL_FLOAT_WRAPPER);
                }
              }
            }
          }
        }
        return (highestscore);
      }
    }
  }

  public static boolean pruneNnSearchP(NnPartialMatch self) {
    { double maxPossibleActive = self.accumulatedScore + (self.arity - self.argumentScores.length());

      if (Logic.$GREEDY_NETWORK_PRUNING$ &&
          ((!(Logic.$RULE_COMBINATION$ == Logic.KWD_NOISY_OR)) &&
           (maxPossibleActive < self.dynamicCutoff))) {
        {
          if (Stella_Object.traceKeywordP(Logic.KWD_GOAL_TREE)) {
            Stella.STANDARD_OUTPUT.nativeStream.println("*** Cutting off search, cutoff: " + self.dynamicCutoff + "+, Max possible score: " + maxPossibleActive);
          }
          return (true);
        }
      }
      else {
        return (false);
      }
    }
  }

  public boolean earlyPartialMatchOrSuccessP() {
    { NnPartialMatch self = this;

      return (NnPartialMatch.pruneNnSearchP(self));
    }
  }

  public boolean earlyPartialMatchAndFailureP() {
    { NnPartialMatch self = this;

      return (NnPartialMatch.pruneNnSearchP(self));
    }
  }

  public double computeGoalScore() {
    { NnPartialMatch self = this;

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

  public double computeNotScore() {
    { NnPartialMatch self = this;

      return (0.0);
    }
  }

  public double computeOrScore() {
    { NnPartialMatch self = this;

      { PropositionNeuralNetwork net = ((PropositionNeuralNetwork)(KeyValueList.dynamicSlotValue(self.controlFrame.proposition.dynamicSlots, Logic.SYM_LOGIC_NEURAL_NETWORK, null)));

        { FloatWrapper score = null;
          Cons iter000 = Cons.copyConsList(self.argumentScores).reverse();
          Stella_Object arg = null;
          Vector vector000 = self.controlFrame.proposition.arguments;
          int index000 = 0;
          int length000 = vector000.length();

          for (;(!(iter000 == Stella.NIL)) &&
                    (index000 < length000); iter000 = iter000.rest, index000 = index000 + 1) {
            score = ((FloatWrapper)(iter000.value));
            arg = (vector000.theArray)[index000];
            KeyValueList.setDynamicSlotValue(((Proposition)(arg)).dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, FloatWrapper.wrapFloat(score.wrapperValue), Stella.NULL_FLOAT_WRAPPER);
          }
        }
        if (net != null) {
          return (PropositionNeuralNetwork.activatePropositionalNeuralNetwork(net));
        }
        return (0.0);
      }
    }
  }

  public double computeAndScore() {
    { NnPartialMatch self = this;

      { PropositionNeuralNetwork net = ((PropositionNeuralNetwork)(KeyValueList.dynamicSlotValue(self.controlFrame.proposition.dynamicSlots, Logic.SYM_LOGIC_NEURAL_NETWORK, null)));

        { FloatWrapper score = null;
          Cons iter000 = Cons.copyConsList(self.argumentScores).reverse();
          Stella_Object arg = null;
          Vector vector000 = self.controlFrame.proposition.arguments;
          int index000 = 0;
          int length000 = vector000.length();

          for (;(!(iter000 == Stella.NIL)) &&
                    (index000 < length000); iter000 = iter000.rest, index000 = index000 + 1) {
            score = ((FloatWrapper)(iter000.value));
            arg = (vector000.theArray)[index000];
            KeyValueList.setDynamicSlotValue(((Proposition)(arg)).dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, FloatWrapper.wrapFloat(score.wrapperValue), Stella.NULL_FLOAT_WRAPPER);
          }
        }
        if (net != null) {
          return (PropositionNeuralNetwork.activatePropositionalNeuralNetwork(net));
        }
        return (0.0);
      }
    }
  }

  public void popPartialMatchScore() {
    { NnPartialMatch self = this;

      self.accumulatedScore = self.accumulatedScore - (((FloatWrapper)(self.argumentScores.value)).wrapperValue * ((FloatWrapper)(self.argumentWeights.value)).wrapperValue);
      self.argumentScores = self.argumentScores.rest;
      self.argumentWeights = self.argumentWeights.rest;
    }
  }

  public void recordPartialMatchScore(double score, double weight) {
    { NnPartialMatch self = this;

      if (weight == Stella.NULL_FLOAT) {
        weight = 1.0;
      }
      self.argumentScores = Cons.cons(FloatWrapper.wrapFloat(score), self.argumentScores);
      self.argumentWeights = Cons.cons(FloatWrapper.wrapFloat(weight), self.argumentWeights);
      self.accumulatedScore = self.accumulatedScore + (score * weight);
      if (score > self.maximumScore) {
        self.maximumScore = score;
      }
      { ControlFrame frame = self.controlFrame;

        if ((self.kind == Logic.KWD_ATOMIC_GOAL) &&
            (frame.currentStrategy == Logic.KWD_FULL_SUBQUERY)) {
          { Proposition r = ((Proposition)(((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, null))).value));
            Proposition ante = ((Description)((r.arguments.theArray)[0])).proposition;

            self.rules = Cons.cons(r, self.rules);
            KeyValueList.setDynamicSlotValue(ante.dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, FloatWrapper.wrapFloat(score), Stella.NULL_FLOAT_WRAPPER);
          }
        }
      }
    }
  }

  public void setJustificationPartialTruth(Justification justification) {
    { NnPartialMatch self = this;

      justification.positiveScore = ((FloatWrapper)(KeyValueList.dynamicSlotValue(((QueryIterator)(Logic.$QUERYITERATOR$.get())).dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue;
    }
  }

  public void setCachePartialTruth(AtomicGoalCache cache) {
    { NnPartialMatch self = this;

      cache.positiveScore = ((FloatWrapper)(KeyValueList.dynamicSlotValue(((QueryIterator)(Logic.$QUERYITERATOR$.get())).dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue;
    }
  }

  public void setBasePartialMatchTruth(Proposition prop, Keyword truth) {
    { NnPartialMatch self = this;

      if (truth == Logic.KWD_TRUE) {
        if (prop != null) {
          {
            if (((FloatWrapper)(KeyValueList.dynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, Stella.NULL_FLOAT_WRAPPER))).wrapperValue != Stella.NULL_FLOAT) {
              KeyValueList.setDynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, FloatWrapper.wrapFloat(((FloatWrapper)(KeyValueList.dynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, Stella.NULL_FLOAT_WRAPPER))).wrapperValue), Stella.NULL_FLOAT_WRAPPER);
            }
            else {
              KeyValueList.setDynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, FloatWrapper.wrapFloat(1.0), Stella.NULL_FLOAT_WRAPPER);
            }
            KeyValueList.setDynamicSlotValue(((QueryIterator)(Logic.$QUERYITERATOR$.get())).dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, FloatWrapper.wrapFloat(((FloatWrapper)(KeyValueList.dynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue), Stella.NULL_FLOAT_WRAPPER);
          }
        }
        else {
          KeyValueList.setDynamicSlotValue(((QueryIterator)(Logic.$QUERYITERATOR$.get())).dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, FloatWrapper.wrapFloat(1.0), Stella.NULL_FLOAT_WRAPPER);
        }
      }
      else if (truth == Logic.KWD_FAIL) {
        if (prop != null) {
          KeyValueList.setDynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, FloatWrapper.wrapFloat(0.0), Stella.NULL_FLOAT_WRAPPER);
        }
        KeyValueList.setDynamicSlotValue(((QueryIterator)(Logic.$QUERYITERATOR$.get())).dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, FloatWrapper.wrapFloat(0.0), Stella.NULL_FLOAT_WRAPPER);
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + truth + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public double propositionWeight(Proposition proposition) {
    { NnPartialMatch self = this;

      if (proposition == null) {
        return (1.0);
      }
      if (BooleanWrapper.coerceWrappedBooleanToBoolean(proposition.variableTypeP())) {
        KeyValueList.setDynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, FloatWrapper.wrapFloat(0.0), Stella.NULL_FLOAT_WRAPPER);
      }
      if (((TruthValue)(Stella_Object.accessInContext(proposition.truthValue, proposition.homeContext, false))) != null) {
        KeyValueList.setDynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, FloatWrapper.wrapFloat(((TruthValue)(Stella_Object.accessInContext(proposition.truthValue, proposition.homeContext, false))).positiveScore), Stella.NULL_FLOAT_WRAPPER);
      }
      if (((FloatWrapper)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, Stella.NULL_FLOAT_WRAPPER))).wrapperValue == Stella.NULL_FLOAT) {
        KeyValueList.setDynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, FloatWrapper.wrapFloat(1.0), Stella.NULL_FLOAT_WRAPPER);
      }
      return (((FloatWrapper)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, Stella.NULL_FLOAT_WRAPPER))).wrapperValue);
    }
  }

  public double computeDynamicCutoff() {
    { NnPartialMatch self = this;

      if (((NnPartialMatch)(self.parent)) != null) {
        { Keyword testValue000 = self.kind;

          if (testValue000 == Logic.KWD_ATOMIC_GOAL) {
            return (((NnPartialMatch)(self.parent)).dynamicCutoff);
          }
          else if ((testValue000 == Logic.KWD_AND) ||
              (testValue000 == Logic.KWD_OR)) {
            { NnPartialMatch parent = ((NnPartialMatch)(self.parent));
              PropositionNeuralNetwork net = ((PropositionNeuralNetwork)(KeyValueList.dynamicSlotValue(self.controlFrame.proposition.dynamicSlots, Logic.SYM_LOGIC_NEURAL_NETWORK, null)));
              double active = -1.0;

              if (parent.dynamicCutoff > 0.1) {
                { FloatWrapper input = null;
                  Vector vector000 = net.input;
                  int index000 = 0;
                  int length000 = vector000.length();

                  for (;index000 < length000; index000 = index000 + 1) {
                    input = ((FloatWrapper)((vector000.theArray)[index000]));
                    active = active + input.wrapperValue;
                  }
                }
                return (active);
              }
            }
          }
          else {
          }
        }
      }
      return (0.0);
    }
  }

  public PartialMatchFrame createPartialMatchFrame(ControlFrame frame, Keyword kind) {
    { NnPartialMatch self = this;

      return (NnPartialMatch.newNnPartialMatch(kind, frame));
    }
  }

  public void initializeNnPartialMatch() {
    { NnPartialMatch self = this;

      { Proposition prop = self.controlFrame.proposition;

        self.arity = prop.arguments.length();
        { Keyword testValue000 = self.kind;

          if ((testValue000 == Logic.KWD_AND) ||
              (testValue000 == Logic.KWD_OR)) {
            if (((PropositionNeuralNetwork)(KeyValueList.dynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_NEURAL_NETWORK, null))) == null) {
              KeyValueList.setDynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_NEURAL_NETWORK, Proposition.createNeuralNetwork(prop), null);
            }
          }
          else {
          }
        }
        PartialMatchFrame.linkToParentPartialMatchFrame(self);
        self.setDynamicCutoff();
      }
    }
  }

  public static Stella_Object accessNnPartialMatchSlotValue(NnPartialMatch self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_PARENT) {
      if (setvalueP) {
        self.parent = ((NnPartialMatch)(value));
      }
      else {
        value = ((NnPartialMatch)(self.parent));
      }
    }
    else if (slotname == Logic.SYM_LOGIC_CHILD) {
      if (setvalueP) {
        self.child = ((NnPartialMatch)(value));
      }
      else {
        value = ((NnPartialMatch)(self.child));
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
    else if (slotname == Logic.SYM_LOGIC_MAXIMUM_SCORE) {
      if (setvalueP) {
        self.maximumScore = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.maximumScore);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_RULES) {
      if (setvalueP) {
        self.rules = ((Cons)(value));
      }
      else {
        value = self.rules;
      }
    }
    else if (slotname == Logic.SYM_STELLA_ARITY) {
      if (setvalueP) {
        self.arity = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.arity);
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
    { NnPartialMatch self = this;

      return (Logic.SGT_LOGIC_NN_PARTIAL_MATCH);
    }
  }

}

