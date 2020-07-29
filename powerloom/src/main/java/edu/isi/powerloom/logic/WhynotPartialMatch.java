//  -*- Mode: Java -*-
//
// WhynotPartialMatch.java

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

/** Variant of :BASIC partial match strategy to support WHYNOT queries.
 * @author Stella Java Translator
 */
public class WhynotPartialMatch extends IncrementalPartialMatch {
    public int unknownGoalCutoff;

  public static WhynotPartialMatch newWhynotPartialMatch(Keyword kind, ControlFrame controlFrame) {
    { WhynotPartialMatch self = null;

      self = new WhynotPartialMatch();
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
      self.unknownGoalCutoff = Stella.NULL_INTEGER;
      IncrementalPartialMatch.initializeIncrementalPartialMatch(self);
      return (self);
    }
  }

  public QueryIterator retrievePartialSolutions(QueryIterator query) {
    { WhynotPartialMatch self = this;

      { ControlFrame baseframe = query.baseControlFrame;
        PartialMatchFrame partialmatchframe = query.partialMatchStrategy;
        FloatWrapper minimumscore = ((FloatWrapper)(Logic.lookupQueryOption(query, Logic.KWD_MINIMUM_SCORE)));
        boolean maximizescoreP = !Stella_Object.eqlP(Logic.lookupQueryOption(query, Logic.KWD_MAXIMIZE_SCOREp), Stella.FALSE_WRAPPER);
        int howmany = Logic.lookupHowManySolutions(query);
        int topn = 10;
        int topnpartialproofs = topn;
        boolean haveenoughpartialproofsP = false;
        Cons currentsolution = Stella.NIL;
        Justification currentproof = null;
        List strictproofs = List.newList();
        List partialproofclasses = List.newList();
        NormalInferenceLevel initialinferencelevel = Logic.currentInferenceLevel();

        if (partialmatchframe == null) {
          partialmatchframe = self;
          query.partialMatchStrategy = self;
        }
        partialmatchframe.dynamicCutoff = ((minimumscore != null) ? minimumscore.wrapperValue : 0.3);
        { Object old$Queryiterator$000 = Logic.$QUERYITERATOR$.get();
          Object old$GenerateAllProofsP$000 = Logic.$GENERATE_ALL_PROOFSp$.get();
          Object old$RecordJustificationsP$000 = Logic.$RECORD_JUSTIFICATIONSp$.get();
          Object old$Inferencelevel$000 = Logic.$INFERENCELEVEL$.get();
          Object old$ReversepolarityP$000 = Logic.$REVERSEPOLARITYp$.get();

          try {
            Native.setSpecial(Logic.$QUERYITERATOR$, query);
            Native.setBooleanSpecial(Logic.$GENERATE_ALL_PROOFSp$, true);
            Native.setBooleanSpecial(Logic.$RECORD_JUSTIFICATIONSp$, true);
            Native.setSpecial(Logic.$INFERENCELEVEL$, initialinferencelevel);
            Native.setBooleanSpecial(Logic.$REVERSEPOLARITYp$, false);
            loop000 : for (;;) {
              query.solutions.clear();
              if ((strictproofs.length() == howmany) ||
                  (!query.nextP())) {
                break loop000;
              }
              Native.setSpecial(Logic.$INFERENCELEVEL$, initialinferencelevel);
              if (partialmatchframe.cutoffPartialMatchP(false)) {
                break loop000;
              }
              currentsolution = ((QuerySolution)(query.value)).consify();
              currentproof = ((Justification)(KeyValueList.dynamicSlotValue(baseframe.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null)));
              { boolean testValue000 = false;

                { boolean foundP000 = false;

                  { Justification proof = null;
                    Cons iter000 = strictproofs.theConsList;

                    loop001 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                      proof = ((Justification)(iter000.value));
                      if (Stella_Object.equalP(Justification.retrievalProofSolution(proof, query), currentsolution)) {
                        foundP000 = true;
                        break loop001;
                      }
                    }
                  }
                  testValue000 = foundP000;
                }
                testValue000 = !testValue000;
                if (testValue000) {
                  {
                    if (TruthValue.knownTruthValueP(baseframe.truthValue)) {
                      strictproofs.push(currentproof);
                      continue loop000;
                    }
                  }
                }
                else {
                  {
                    continue loop000;
                  }
                }
              }
              if (Logic.insertWhynotProof(partialproofclasses, currentproof).length() == Logic.$SIMILAR_WHYNOT_PROOF_CUTOFF$) {
                QueryIterator.cutoffSimilarWhynotProofs(query);
              }
              topnpartialproofs = ((howmany == Stella.NULL_INTEGER) ? topn : Stella.integer_max(topn, howmany - strictproofs.length()));
              if (haveenoughpartialproofsP ||
                  (partialproofclasses.length() >= topnpartialproofs)) {
                haveenoughpartialproofsP = true;
                partialproofclasses.sort(Native.find_java_method("edu.isi.powerloom.logic.WhynotProofClass", "betterWhynotProofClassP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.WhynotProofClass"), Native.find_java_class("edu.isi.powerloom.logic.WhynotProofClass")}));
                partialmatchframe.dynamicCutoff = ((WhynotProofClass)(partialproofclasses.nth(topnpartialproofs - 1))).representative.positiveScore + 0.01;
              }
              if (!maximizescoreP) {
                break loop000;
              }
            }

          } finally {
            Logic.$REVERSEPOLARITYp$.set(old$ReversepolarityP$000);
            Logic.$INFERENCELEVEL$.set(old$Inferencelevel$000);
            Logic.$RECORD_JUSTIFICATIONSp$.set(old$RecordJustificationsP$000);
            Logic.$GENERATE_ALL_PROOFSp$.set(old$GenerateAllProofsP$000);
            Logic.$QUERYITERATOR$.set(old$Queryiterator$000);
          }
        }
        KeyValueList.setDynamicSlotValue(baseframe.dynamicSlots, Logic.SYM_LOGIC_ALL_JUSTIFICATIONS, strictproofs.reverse(), null);
        if (!(strictproofs.length() == howmany)) {
          Logic.postProcessWhynotProofClasses(partialproofclasses);
          { WhynotProofClass renamed_Class = null;
            Cons iter001 = partialproofclasses.theConsList;
            int i = Stella.NULL_INTEGER;
            int iter002 = 1;
            int upperBound000 = topnpartialproofs;
            boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;
            List into000 = baseframe.allJustifications();
            Cons collect000 = null;

            for (;(!(iter001 == Stella.NIL)) &&
                      (unboundedP000 ||
                       (iter002 <= upperBound000)); iter001 = iter001.rest, iter002 = iter002 + 1) {
              renamed_Class = ((WhynotProofClass)(iter001.value));
              i = iter002;
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(renamed_Class.representative, Stella.NIL);
                  if (into000.theConsList == Stella.NIL) {
                    into000.theConsList = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(into000.theConsList, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(renamed_Class.representative, Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
        }
        KeyValueList.setDynamicSlotValue(baseframe.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, ((Justification)(baseframe.allJustifications().first())), null);
        query.solutions.clear();
        { Justification proof = null;
          Cons iter003 = baseframe.allJustifications().theConsList;

          for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
            proof = ((Justification)(iter003.value));
            { QuerySolution self003 = QuerySolution.newQuerySolution();

              self003.bindings = Logic.coerceToVector(Justification.retrievalProofSolution(proof, query));
              self003.matchScore = proof.positiveScore;
              self003.justification = proof;
              { QuerySolution solution = self003;

                query.solutions.insertAt(solution.bindings, solution);
              }
            }
          }
        }
        return (query);
      }
    }
  }

  public double computePartialTruth(QueryIterator query) {
    { WhynotPartialMatch self = this;

      { ControlFrame baseframe = query.baseControlFrame;
        PartialMatchFrame partialmatchframe = query.partialMatchStrategy;
        FloatWrapper minimumscore = ((FloatWrapper)(query.options.lookup(Logic.KWD_MINIMUM_SCORE)));
        boolean maximizescoreP = !Stella_Object.eqlP(query.options.lookup(Logic.KWD_MAXIMIZE_SCOREp), Stella.FALSE_WRAPPER);
        int topnproofs = 10;
        List proofclasses = List.newList();
        NormalInferenceLevel initialinferencelevel = Logic.currentInferenceLevel();

        if (partialmatchframe == null) {
          partialmatchframe = self;
          query.partialMatchStrategy = self;
        }
        partialmatchframe.dynamicCutoff = ((minimumscore != null) ? minimumscore.wrapperValue : 0.3);
        { Object old$Queryiterator$000 = Logic.$QUERYITERATOR$.get();
          Object old$GenerateAllProofsP$000 = Logic.$GENERATE_ALL_PROOFSp$.get();
          Object old$RecordJustificationsP$000 = Logic.$RECORD_JUSTIFICATIONSp$.get();
          Object old$Inferencelevel$000 = Logic.$INFERENCELEVEL$.get();
          Object old$ReversepolarityP$000 = Logic.$REVERSEPOLARITYp$.get();

          try {
            Native.setSpecial(Logic.$QUERYITERATOR$, query);
            Native.setBooleanSpecial(Logic.$GENERATE_ALL_PROOFSp$, true);
            Native.setBooleanSpecial(Logic.$RECORD_JUSTIFICATIONSp$, true);
            Native.setSpecial(Logic.$INFERENCELEVEL$, initialinferencelevel);
            Native.setBooleanSpecial(Logic.$REVERSEPOLARITYp$, false);
            loop000 : for (;;) {
              if (!(query.nextP())) {
                break loop000;
              }
              Native.setSpecial(Logic.$INFERENCELEVEL$, initialinferencelevel);
              if (partialmatchframe.cutoffPartialMatchP(false)) {
                break loop000;
              }
              if (Logic.insertWhynotProof(proofclasses, ((Justification)(KeyValueList.dynamicSlotValue(baseframe.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null)))).length() == Logic.$SIMILAR_WHYNOT_PROOF_CUTOFF$) {
                QueryIterator.cutoffSimilarWhynotProofs(query);
              }
              if (proofclasses.length() >= topnproofs) {
                proofclasses.sort(Native.find_java_method("edu.isi.powerloom.logic.WhynotProofClass", "betterWhynotProofClassP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.WhynotProofClass"), Native.find_java_class("edu.isi.powerloom.logic.WhynotProofClass")}));
                partialmatchframe.dynamicCutoff = ((WhynotProofClass)(proofclasses.nth(topnproofs - 1))).representative.positiveScore + 0.01;
              }
              if ((!maximizescoreP) ||
                  TruthValue.knownTruthValueP(baseframe.truthValue)) {
                break loop000;
              }
            }

          } finally {
            Logic.$REVERSEPOLARITYp$.set(old$ReversepolarityP$000);
            Logic.$INFERENCELEVEL$.set(old$Inferencelevel$000);
            Logic.$RECORD_JUSTIFICATIONSp$.set(old$RecordJustificationsP$000);
            Logic.$GENERATE_ALL_PROOFSp$.set(old$GenerateAllProofsP$000);
            Logic.$QUERYITERATOR$.set(old$Queryiterator$000);
          }
        }
        Logic.postProcessWhynotProofClasses(proofclasses);
        KeyValueList.setDynamicSlotValue(baseframe.dynamicSlots, Logic.SYM_LOGIC_ALL_JUSTIFICATIONS, List.newList(), null);
        { WhynotProofClass renamed_Class = null;
          Cons iter000 = proofclasses.theConsList;
          List into000 = baseframe.allJustifications();
          Cons collect000 = null;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            renamed_Class = ((WhynotProofClass)(iter000.value));
            if (collect000 == null) {
              {
                collect000 = Cons.cons(renamed_Class.representative, Stella.NIL);
                if (into000.theConsList == Stella.NIL) {
                  into000.theConsList = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(into000.theConsList, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(renamed_Class.representative, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        KeyValueList.setDynamicSlotValue(baseframe.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, ((Justification)(baseframe.allJustifications().first())), null);
        return (((((Justification)(KeyValueList.dynamicSlotValue(baseframe.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null))) != null) ? ((Justification)(KeyValueList.dynamicSlotValue(baseframe.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null))).positiveScore : 0.0));
      }
    }
  }

  public void initializePartialMatchStrategy(QueryIterator query) {
    { WhynotPartialMatch self = this;

      { FloatWrapper minimumscore = ((FloatWrapper)(query.options.lookup(Logic.KWD_MINIMUM_SCORE)));
        IntegerWrapper maxunknowns = ((IntegerWrapper)(query.options.lookup(Logic.KWD_MAXIMUM_UNKNOWNS)));
        double epsilon = 0.001;

        query.partialMatchStrategy = self;
        self.dynamicCutoff = ((minimumscore != null) ? minimumscore.wrapperValue : epsilon);
        KeyValueList.setDynamicSlotValue(query.dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, FloatWrapper.wrapFloat(0.0), Stella.NULL_FLOAT_WRAPPER);
        if (maxunknowns != null) {
          self.unknownGoalCutoff = maxunknowns.wrapperValue;
        }
      }
    }
  }

  public boolean skipAndClauseP(ControlFrame frame, Cons forbiddenvars) {
    { WhynotPartialMatch self = this;

      { boolean forbiddenvarsP = !(forbiddenvars == Stella.NIL);
        Proposition conjunct = ((Proposition)((frame.proposition.arguments.theArray)[(frame.argumentCursor)]));

        { boolean testValue000 = false;

          testValue000 = forbiddenvarsP;
          if (testValue000) {
            { boolean foundP000 = false;

              { Stella_Object var = null;
                Cons iter000 = Proposition.getUnboundVariables(conjunct);

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
            testValue000 = Proposition.dynamicallyEstimateGoalFanout(conjunct) > self.maxUnconstrainedFanout();
          }
          if (testValue000) {
            { ControlFrame result = ControlFrame.createDownFrame(frame, conjunct);

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

  public double maxUnconstrainedFanout() {
    { WhynotPartialMatch self = this;

      return (25.0);
    }
  }

  public Keyword continuePartialAntecedentsProof(Keyword lastmove) {
    { WhynotPartialMatch self = this;

      { ControlFrame frame = self.controlFrame;
        Iterator iterator = ((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, null)));
        Proposition goal = ControlFrame.extractSubgoalOfFrame(frame);
        double score = Stella.NULL_FLOAT;
        Keyword result = null;
        int allottedclockticks = frame.allottedClockTicks;
        int currentclockticks = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentClockTicks;

        if (lastmove == Logic.KWD_DOWN) {
          self.setDynamicCutoff();
          if (iterator == null) {
            iterator = Description.allocateAntecedentsIterator(ControlFrame.extractSubgoalDescriptionOfFrame(frame), ControlFrame.findExternalArgumentsForSubgoal(frame), frame.reversePolarityP);
            if (iterator == null) {
              iterator = Stella.NIL.allocateIterator();
            }
            KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, iterator, null);
          }
          if (allottedclockticks != Stella.NULL_INTEGER) {
            KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_REAL_ALLOTTED_CLOCK_TICKS, IntegerWrapper.wrapInteger(allottedclockticks), Stella.NULL_INTEGER_WRAPPER);
          }
        }
        else if ((lastmove == Logic.KWD_UP_TRUE) ||
            (lastmove == Logic.KWD_UP_FAIL)) {
          score = frame.result.partialMatchFrame.positiveScore;
          if ((frame.reversePolarityP &&
              (score > 0.0)) ||
              ((!frame.reversePolarityP) &&
               (score < 0.0))) {
            score = 0.0;
            lastmove = Logic.KWD_UP_FAIL;
          }
          if ((((score < 0.0) ? (0.0 - score) : score)) < 1.0) {
            score = score * self.chainingDepthDegradation();
          }
          score = score * self.propositionWeight(((Proposition)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_ANTECEDENTS_RULE, null))));
          self.setFramePartialTruth(null, score, Stella.NULL_FLOAT, false);
          if ((lastmove == Logic.KWD_UP_FAIL) ||
              (((!Proposition.allArgumentsBoundP(goal)) &&
              (!self.allowUnboundVariablesP())) ||
               self.cutoffPartialMatchP(Stella_Object.traceKeywordP(Logic.KWD_GOAL_TREE)))) {
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
        if (!((lastmove == Logic.KWD_UP_TRUE) ||
            (allottedclockticks == Stella.NULL_INTEGER))) {
          frame.allottedClockTicks = ((int)(((double)(((IntegerWrapper)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_REAL_ALLOTTED_CLOCK_TICKS, Stella.NULL_INTEGER_WRAPPER))).wrapperValue - (currentclockticks - frame.startingClockTicks))) / Stella.integer_max(Logic.numberOfRemainingAntecedents(iterator), 1)));
          if ((frame.allottedClockTicks < Logic.$MIN_CLOCK_TICKS_PER_WHYNOT_ANTECEDENT$) &&
              (Logic.numberOfRemainingAntecedents(iterator) > 0)) {
            if ((Stella.$TRACED_KEYWORDS$ != null) &&
                Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_TREE)) {
              Stella.STANDARD_OUTPUT.nativeStream.println("*** Timeout - not enough time to subgoal");
            }
            KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ITERATOR, Stella.NIL.allocateIterator(), null);
          }
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

  public double chainingDepthDegradation() {
    { WhynotPartialMatch self = this;

      { ControlFrame frame = self.controlFrame;
        double degradationfactor = 0.75;
        double degradation = 1.0;

        frame = frame.up;
        while (frame != null) {
          if (((Proposition)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_ANTECEDENTS_RULE, null))) != null) {
            degradation = degradation * degradationfactor;
          }
          frame = frame.up;
        }
        return (degradation);
      }
    }
  }

  public Keyword continuePartialAndProof(ControlFrame frame, Keyword lastmove) {
    { WhynotPartialMatch self = this;

      { Cons forbiddenvars = Stella.NIL;

        if (lastmove == Logic.KWD_DOWN) {
          self.setDynamicCutoff();
          if (frame.allottedClockTicks != Stella.NULL_INTEGER) {
            KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_REAL_ALLOTTED_CLOCK_TICKS, IntegerWrapper.wrapInteger(frame.allottedClockTicks), Stella.NULL_INTEGER_WRAPPER);
          }
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
            if ((frame.allottedClockTicks != Stella.NULL_INTEGER) &&
                (result == Logic.KWD_MOVE_DOWN)) {
              frame.allottedClockTicks = ((int)(((double)(((IntegerWrapper)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_REAL_ALLOTTED_CLOCK_TICKS, Stella.NULL_INTEGER_WRAPPER))).wrapperValue - (((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentClockTicks - frame.startingClockTicks))) / ((Vector)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, Logic.SYM_STELLA_ARGUMENTS, null))).length()));
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

  public double propositionWeight(Proposition proposition) {
    { WhynotPartialMatch self = this;

      if (proposition == null) {
        return (1.0);
      }
      else if (proposition.kind == Logic.KWD_ISA) {
        return (0.25);
      }
      else if ((proposition.kind == Logic.KWD_NOT) &&
          (((Proposition)((proposition.arguments.theArray)[0])).kind == Logic.KWD_EQUIVALENT)) {
        return (0.1);
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

  public boolean cutoffPartialMatchP(boolean traceP) {
    { WhynotPartialMatch self = this;

      { double score = self.positiveScore;
        double scorecutoff = self.dynamicCutoff;
        int unknowngoalcutoff = self.unknownGoalCutoff;
        boolean cutoffP = false;

        if ((score == Stella.NULL_FLOAT) ||
            ((scorecutoff == Stella.NULL_FLOAT) ||
             (scorecutoff == 0.0))) {
          cutoffP = false;
        }
        else if (scorecutoff < 0.0) {
          cutoffP = score > scorecutoff;
        }
        else {
          cutoffP = score < scorecutoff;
        }
        if ((!cutoffP) &&
            (unknowngoalcutoff != Stella.NULL_INTEGER)) {
          cutoffP = self.numberOfFailedSubgoals() > unknowngoalcutoff;
          if (cutoffP &&
              traceP) {
            Stella.STANDARD_OUTPUT.nativeStream.println("*** Cutting off search, more than " + unknowngoalcutoff + " failed subgoal(s)");
          }
        }
        return (cutoffP);
      }
    }
  }

  public int numberOfFailedSubgoals() {
    { WhynotPartialMatch self = this;

      { Justification proof = ((Justification)(KeyValueList.dynamicSlotValue(self.controlFrame.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null)));

        { MemoizationTable memoTable000 = null;
          Cons memoizedEntry000 = null;
          Stella_Object memoizedValue000 = null;

          if (Stella.$MEMOIZATION_ENABLEDp$) {
            memoTable000 = ((MemoizationTable)(Logic.SGT_LOGIC_M_WHYNOT_PARTIAL_MATCHdNUMBER_OF_FAILED_SUBGOALS_MEMO_TABLE_000.surrogateValue));
            if (memoTable000 == null) {
              Surrogate.initializeMemoizationTable(Logic.SGT_LOGIC_M_WHYNOT_PARTIAL_MATCHdNUMBER_OF_FAILED_SUBGOALS_MEMO_TABLE_000, "(:MAX-VALUES 500)");
              memoTable000 = ((MemoizationTable)(Logic.SGT_LOGIC_M_WHYNOT_PARTIAL_MATCHdNUMBER_OF_FAILED_SUBGOALS_MEMO_TABLE_000.surrogateValue));
            }
            memoizedEntry000 = MruMemoizationTable.lookupMruMemoizedValue(((MruMemoizationTable)(memoTable000)), proof, Stella.MEMOIZED_NULL_VALUE, null, null, -1);
            memoizedValue000 = memoizedEntry000.value;
          }
          if (memoizedValue000 != null) {
            if (memoizedValue000 == Stella.MEMOIZED_NULL_VALUE) {
              memoizedValue000 = null;
            }
          }
          else {
            memoizedValue000 = IntegerWrapper.wrapInteger(Justification.computeNumberOfFailedSubgoals(proof));
            if (Stella.$MEMOIZATION_ENABLEDp$) {
              memoizedEntry000.value = ((memoizedValue000 == null) ? Stella.MEMOIZED_NULL_VALUE : memoizedValue000);
            }
          }
          { IntegerWrapper value000 = ((IntegerWrapper)(memoizedValue000));

            return (value000.wrapperValue);
          }
        }
      }
    }
  }

  public int computeUnknownGoalCutoff() {
    { WhynotPartialMatch self = this;

      { WhynotPartialMatch parent = ((WhynotPartialMatch)(((IncrementalPartialMatch)(self.parent))));
        int parentcutoff = Stella.NULL_INTEGER;
        int cutoff = Stella.NULL_INTEGER;

        if (parent != null) {
          parentcutoff = parent.unknownGoalCutoff;
          if (parentcutoff == Stella.NULL_INTEGER) {
            return (Stella.NULL_INTEGER);
          }
          if (parent.kind == Logic.KWD_AND) {
            { ControlFrame parentframe = parent.controlFrame;
              int siblingunknowns = 0;

              { int i = Stella.NULL_INTEGER;
                int iter000 = 0;
                int upperBound000 = parentframe.argumentCursor - 1;

                for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
                  i = iter000;
                  siblingunknowns = siblingunknowns + ((WhynotPartialMatch)(((ControlFrame)((((Vector)(KeyValueList.dynamicSlotValue(parentframe.dynamicSlots, Logic.SYM_STELLA_ARGUMENTS, null))).theArray)[i])).partialMatchFrame)).numberOfFailedSubgoals();
                }
              }
              cutoff = Stella.integer_max(parentcutoff - siblingunknowns, 0);
            }
          }
          else {
            cutoff = parentcutoff;
          }
        }
        return (cutoff);
      }
    }
  }

  public void setDynamicCutoff() {
    { WhynotPartialMatch self = this;

      { double cutoff = self.computeDynamicCutoff();

        if (cutoff != Stella.NULL_FLOAT) {
          if ((cutoff < -100) ||
              (cutoff > 100)) {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: *** fishy dynamic cutoff=`" + cutoff + "' computed, resetting to 0.0");
            cutoff = 0.0;
          }
          self.dynamicCutoff = cutoff;
        }
        self.unknownGoalCutoff = self.computeUnknownGoalCutoff();
      }
    }
  }

  public PartialMatchFrame createPartialMatchFrame(ControlFrame frame, Keyword kind) {
    { WhynotPartialMatch self = this;

      return (WhynotPartialMatch.newWhynotPartialMatch(kind, frame));
    }
  }

  public static Stella_Object accessWhynotPartialMatchSlotValue(WhynotPartialMatch self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_UNKNOWN_GOAL_CUTOFF) {
      if (setvalueP) {
        self.unknownGoalCutoff = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.unknownGoalCutoff);
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
    { WhynotPartialMatch self = this;

      return (Logic.SGT_LOGIC_WHYNOT_PARTIAL_MATCH);
    }
  }

}

