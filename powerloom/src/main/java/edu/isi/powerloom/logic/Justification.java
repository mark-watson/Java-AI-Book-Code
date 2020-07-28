//  -*- Mode: Java -*-
//
// Justification.java

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

public class Justification extends StandardObject {
    /** Keyword describing the inference rule used to conclude the
     * proposition of this justification.
     */
    public Keyword inferenceRule;
    /** The proposition supported by this justification.
     */
    public Proposition proposition;
    /** Antecedents justifications of this justification.
     */
    public Cons antecedents;
    /** List of variable bindings recorded for this justification.
     */
    public KeyValueMap substitution;
    /** True if proposition was derived in reverse polarity.
     */
    public boolean reversePolarityP;
    /** Truth value of the derived proposition.
     */
    public TruthValue truthValue;
    /** Positive partial match score of the derived proposition.
     */
    public double positiveScore;
    /** Negative partial match score of the derived proposition.
     */
    public double negativeScore;

  public static Justification newJustification() {
    { Justification self = null;

      self = new Justification();
      self.negativeScore = Stella.NULL_FLOAT;
      self.positiveScore = Stella.NULL_FLOAT;
      self.truthValue = null;
      self.reversePolarityP = false;
      self.substitution = null;
      self.antecedents = Stella.NIL;
      self.proposition = null;
      self.inferenceRule = null;
      return (self);
    }
  }

  /** Print a WHYNOT <code>justification</code> to <code>stream</code> according to
   * <code>maxdepth</code> and <code>style</code>.  Print a summary only if <code>summaryP</code> is TRUE.
   * @param justification
   * @param stream
   * @param maxdepth
   * @param style
   * @param summaryP
   */
  public static void printWhynotJustification(Justification justification, OutputStream stream, int maxdepth, Keyword style, boolean summaryP) {
    { Object old$ExplanationStyle$000 = Logic.$EXPLANATION_STYLE$.get();

      try {
        Native.setSpecial(Logic.$EXPLANATION_STYLE$, ((style != null) ? style : Logic.KWD_BRIEF));
        if (justification == null) {
          if (Logic.$MOST_RECENT_QUERY$ != null) {
            Logic.prettyPrintLogicalForm(Logic.$MOST_RECENT_QUERY$.currentPatternRecord.description.proposition, stream);
            {
              stream.nativeStream.println();
              stream.nativeStream.println("  " + Logic.lookupExplanationPhrase(Logic.KWD_NOT_ASSERTED, Stella.NIL, null) + " and ");
              stream.nativeStream.println("  " + Logic.lookupExplanationPhrase(Logic.KWD_NO_RULES, Stella.NIL, null) + ".");
            }
;
          }
        }
        else if (summaryP) {
          { List failures = List.newList();

            Justification.collectFailedGoals(justification, failures);
            stream.nativeStream.println("The query failed, because");
            { Justification failure = null;
              Cons iter000 = failures.theConsList;
              int i = Stella.NULL_INTEGER;
              int iter001 = 1;

              for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
                failure = ((Justification)(iter000.value));
                i = iter001;
                if (i == 1) {
                  stream.nativeStream.print("    ");
                }
                else {
                  stream.nativeStream.print("and ");
                }
                Justification.printJustificationProposition(failure, stream, 4);
                stream.nativeStream.println();
              }
            }
            {
              stream.nativeStream.println("failed.");
              stream.nativeStream.println();
            }
;
          }
        }
        else {
          Justification.printExplanation(justification, stream, ((KeyValueList)(Logic.$MOST_RECENT_EXPLANATION_MAPPING$.get())), maxdepth, ((Keyword)(Logic.$EXPLANATION_AUDIENCE$.get())));
        }

      } finally {
        Logic.$EXPLANATION_STYLE$.set(old$ExplanationStyle$000);
      }
    }
  }

  public static void collectFailedGoals(Justification proof, List failures) {
    if (proof.inferenceRule == Logic.KWD_AND_INTRODUCTION) {
      { List variables = List.newList();

        { Justification antecedent = null;
          Cons iter000 = proof.antecedents;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            antecedent = ((Justification)(iter000.value));
            if (Justification.failedGoalJustificationP(antecedent)) {
              { Stella_Object arg = null;
                Vector vector000 = antecedent.proposition.arguments;
                int index000 = 0;
                int length000 = vector000.length();

                for (;index000 < length000; index000 = index000 + 1) {
                  arg = (vector000.theArray)[index000];
                  if (Logic.alternativeBindingsSetP(Logic.justificationArgumentBoundTo(arg, antecedent))) {
                    variables.insertNew(((PatternVariable)(arg)));
                  }
                }
              }
            }
          }
        }
        if (variables.nonEmptyP()) {
          { Justification antecedent = null;
            Cons iter001 = proof.antecedents;

            for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              antecedent = ((Justification)(iter001.value));
              { boolean testValue000 = false;

                if (Justification.failedGoalJustificationP(antecedent)) {
                  testValue000 = true;
                }
                else {
                  { boolean foundP000 = false;

                    { Stella_Object arg = null;
                      Vector vector001 = antecedent.proposition.arguments;
                      int index001 = 0;
                      int length001 = vector001.length();

                      loop003 : for (;index001 < length001; index001 = index001 + 1) {
                        arg = (vector001.theArray)[index001];
                        if (variables.memberP(arg)) {
                          foundP000 = true;
                          break loop003;
                        }
                      }
                    }
                    testValue000 = foundP000;
                  }
                }
                if (testValue000) {
                  failures.insert(antecedent);
                }
                else {
                  Justification.collectFailedGoals(antecedent, failures);
                }
              }
            }
          }
          return;
        }
      }
    }
    if (Justification.failedGoalJustificationP(proof)) {
      failures.insertNew(proof);
    }
    else {
      { Justification antecedent = null;
        Cons iter002 = proof.antecedents;

        for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
          antecedent = ((Justification)(iter002.value));
          Justification.collectFailedGoals(antecedent, failures);
        }
      }
    }
  }

  public static Cons retrievalProofSolution(Justification proof, QueryIterator query) {
    { Cons solution = Stella.NIL;
      KeyValueMap substitution = proof.substitution;

      { PatternVariable extvar = null;
        Vector vector000 = query.externalVariables;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          extvar = ((PatternVariable)((vector000.theArray)[index000]));
          { PatternVariable var = null;
            Stella_Object value = null;
            DictionaryIterator iter000 = ((DictionaryIterator)(substitution.allocateIterator()));

            loop001 : while (iter000.nextP()) {
              var = ((PatternVariable)(iter000.key));
              value = iter000.value;
              if (var.skolemName == extvar.skolemName) {
                solution = Cons.cons(value, solution);
                break loop001;
              }
            }
          }
        }
      }
      return (solution.reverse());
    }
  }

  public static int computeProofDeviation(Justification proof1, Justification proof2, int maxdeviations, KeyValueList deviations) {
    if (deviations == null) {
      deviations = KeyValueList.newKeyValueList();
    }
    { int founddeviations = 0;
      int subdeviations = 0;

      if ((proof1.inferenceRule == proof2.inferenceRule) &&
          ((proof1.inferenceStrategy() == proof2.inferenceStrategy()) &&
           ((proof1.truthValue == proof2.truthValue) &&
            ((proof1.reversePolarityP == proof2.reversePolarityP) &&
             ((proof1.positiveScore == proof2.positiveScore) &&
              ((proof1.negativeScore == proof2.negativeScore) &&
               Proposition.equivalentPropositionsP(proof1.proposition, proof2.proposition, null))))))) {
        if (proof1.inferenceRule == Logic.KWD_PATTERN) {
          { PatternVariable var1 = null;
            Stella_Object value1 = null;
            DictionaryIterator iter000 = ((DictionaryIterator)(proof1.substitution.allocateIterator()));
            PatternVariable var2 = null;
            Stella_Object value2 = null;
            DictionaryIterator iter001 = ((DictionaryIterator)(proof2.substitution.allocateIterator()));

            while (iter000.nextP() &&
                iter001.nextP()) {
              var1 = ((PatternVariable)(iter000.key));
              value1 = iter000.value;
              var2 = ((PatternVariable)(iter001.key));
              value2 = iter001.value;
              if (!(var1 == var2)) {
                deviations.clear();
                return (Stella.NULL_INTEGER);
              }
              if (!(Stella_Object.eqlP(value1, value2))) {
                founddeviations = founddeviations + 1;
              }
              if (founddeviations > maxdeviations) {
                deviations.clear();
                return (Stella.NULL_INTEGER);
              }
            }
          }
          if (founddeviations > 0) {
            deviations.insertAt(proof1, proof2);
          }
        }
        { Justification ant1 = null;
          Cons iter002 = proof1.antecedents;
          Justification ant2 = null;
          Cons iter003 = proof2.antecedents;

          for (;(!(iter002 == Stella.NIL)) &&
                    (!(iter003 == Stella.NIL)); iter002 = iter002.rest, iter003 = iter003.rest) {
            ant1 = ((Justification)(iter002.value));
            ant2 = ((Justification)(iter003.value));
            subdeviations = Justification.computeProofDeviation(ant1, ant2, maxdeviations - founddeviations, deviations);
            if (subdeviations == Stella.NULL_INTEGER) {
              deviations.clear();
              return (Stella.NULL_INTEGER);
            }
            founddeviations = founddeviations + subdeviations;
          }
        }
        return (founddeviations);
      }
      return (Stella.NULL_INTEGER);
    }
  }

  public static boolean betterWhynotProofP(Justification proof1, Justification proof2) {
    return (proof1.positiveScore > proof2.positiveScore);
  }

  public static int computeNumberOfFailedSubgoals(Justification proof) {
    { List list = null;

      if (proof != null) {
        list = List.newList();
        Justification.collectFailedGoals(proof, list);
        return (list.length());
      }
      return (0);
    }
  }

  public static void collectVisibleAntecedents(Justification self, List visibleantecedents) {
    { Cons antecedents = self.antecedents;

      { Justification antecedent = null;
        Cons iter000 = antecedents;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          antecedent = ((Justification)(iter000.value));
          antecedent = Justification.visibleJustification(antecedent);
          { Keyword testValue000 = antecedent.inferenceRule;

            if (testValue000 == Logic.KWD_AND_INTRODUCTION) {
              if (((Keyword)(Logic.$EXPLANATION_STYLE$.get())) == Logic.KWD_BRIEF) {
                { Justification subantecedent = null;
                  Cons iter001 = Justification.visibleAntecedents(antecedent).theConsList;

                  for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                    subantecedent = ((Justification)(iter001.value));
                    visibleantecedents.push(subantecedent);
                  }
                }
              }
              else {
                visibleantecedents.push(antecedent);
              }
            }
            else if (testValue000 == Logic.KWD_PRIMITIVE_STRATEGY) {
              if (((PrimitiveStrategy)(antecedent)).strategy == Logic.KWD_EQUIVALENCE) {
                if (!(Proposition.auxiliaryEquivalencePropositionP(antecedent.proposition))) {
                  visibleantecedents.push(antecedent);
                }
              }
              else {
                visibleantecedents.push(antecedent);
              }
            }
            else {
              visibleantecedents.push(antecedent);
            }
          }
        }
      }
    }
  }

  public static List visibleAntecedents(Justification self) {
    { List visibleantecedents = List.newList();

      Justification.collectVisibleAntecedents(self, visibleantecedents);
      return (visibleantecedents.reverse());
    }
  }

  public static Justification visibleJustification(Justification self) {
    if (((self.inferenceRule == Logic.KWD_DISPROOF) &&
        (!self.reversePolarityP)) ||
        ((self.inferenceRule == Logic.KWD_PRIMITIVE_STRATEGY) &&
         (self.inferenceStrategy() == Logic.KWD_GOAL_COMPLEMENT))) {
      return (Justification.visibleJustification(((Justification)(self.antecedents.value))));
    }
    else if (self.inferenceRule == Logic.KWD_PATTERN) {
      return (Justification.visibleJustification(((Justification)(self.antecedents.value))));
    }
    else {
      return (self);
    }
  }

  public static void printExplanationAntecedents(Justification self, OutputStream stream, KeyValueList mapping, int maxdepth, List unexplained) {
    { ExplanationInfo info = Justification.explanationInfo(self, mapping);
      String label = info.label;
      int depth = info.depth;
      List antecedents = Justification.visibleAntecedents(self);
      Cons newantecedents = Stella.NIL;
      int newantecedentsindex = 0;
      int maxlabellength = 0;
      boolean havemarkedantecedentP = false;
      int labelstartposition = Logic.$EXPLANATION_TAB_STRING$.length() + 6;
      int propositionstartposition = 0;
      int indent = 0;

      { Justification antecedent = null;
        Cons iter000 = antecedents.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          antecedent = ((Justification)(iter000.value));
          info = Justification.explanationInfo(antecedent, mapping);
          if (info == null) {
            info = Justification.registerJustification(antecedent, mapping);
            info.label = label + "." + Native.integerToString(((long)(newantecedentsindex = newantecedentsindex + 1)));
            info.depth = depth + 1;
          }
          maxlabellength = Stella.integer_max(maxlabellength, (info.label).length());
          if (!havemarkedantecedentP) {
            havemarkedantecedentP = Justification.markAsExplicitAssertionP(antecedent) ||
                Justification.markAsFailedGoalP(antecedent);
          }
        }
      }
      if (maxlabellength > Logic.$MAX_INLINE_LABEL_LENGTH$) {
        propositionstartposition = labelstartposition;
      }
      else {
        propositionstartposition = labelstartposition + maxlabellength + 1;
      }
      if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_HTML) {
        stream.nativeStream.println("<TABLE>");
      }
      else {
      }
      { Justification antecedent = null;
        Cons iter001 = antecedents.theConsList;
        int i = Stella.NULL_INTEGER;
        int iter002 = 1;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest, iter002 = iter002 + 1) {
          antecedent = ((Justification)(iter001.value));
          i = iter002;
          info = Justification.explanationInfo(antecedent, mapping);
          label = info.label;
          if (!(info.explainedP ||
              (Justification.markAsExplicitAssertionP(antecedent) ||
               (Justification.markAsFailedGoalP(antecedent) ||
                ((maxdepth != Stella.NULL_INTEGER) &&
                 (info.depth > maxdepth)))))) {
            newantecedents = Cons.cons(antecedent, newantecedents);
          }
          if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_ASCII) {
            stream.nativeStream.print(Logic.$EXPLANATION_TAB_STRING$ + (((i == 1) ? "since " : "and   ")));
            Logic.printExplanationLabel(stream, label, false);
            stream.nativeStream.print(" ");
            if (maxlabellength > Logic.$MAX_INLINE_LABEL_LENGTH$) {
              stream.nativeStream.println();
              indent = propositionstartposition;
            }
            else {
              indent = (propositionstartposition - (labelstartposition + label.length())) - 1;
            }
            { int i000 = Stella.NULL_INTEGER;
              int iter003 = 1;
              int upperBound000 = indent;
              boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

              for (;unboundedP000 ||
                        (iter003 <= upperBound000); iter003 = iter003 + 1) {
                i000 = iter003;
                i000 = i000;
                stream.nativeStream.print(" ");
              }
            }
            if (havemarkedantecedentP) {
              stream.nativeStream.print(Justification.explanationTruthMarker(antecedent) + " ");
            }
          }
          else if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_HTML) {
            stream.nativeStream.println("<TR>");
            {
              stream.nativeStream.print("<TD align=right valign=top>");
              stream.nativeStream.print((((i == 1) ? "since&nbsp;" : "and&nbsp;")));
              Logic.printExplanationLabel(stream, label, false);
              {
                stream.nativeStream.print("<TD align=left valign=top>");
                if (havemarkedantecedentP) {
                  stream.nativeStream.print(Justification.explanationTruthMarker(antecedent));
                }
                stream.nativeStream.print("</TD>");
              }
              stream.nativeStream.println("</TD>");
            }
          }
          else if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_XML) {
            Logic.printExplanationLabel(stream, label, false);
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + ((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
          if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_HTML) {
            stream.nativeStream.println("<TD>");
          }
          else {
          }
          Justification.printJustificationPropositionForFormat(antecedent, stream, (havemarkedantecedentP ? (propositionstartposition + (Justification.explanationTruthMarker(antecedent)).length() + 1) : propositionstartposition));
          stream.nativeStream.println();
          if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_HTML) {
            stream.nativeStream.println("</TD></TR>");
          }
          else {
          }
        }
      }
      if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_HTML) {
        stream.nativeStream.println("</TABLE>");
      }
      else {
      }
      { Stella_Object antecedent = null;
        Cons iter004 = newantecedents;

        for (;!(iter004 == Stella.NIL); iter004 = iter004.rest) {
          antecedent = iter004.value;
          unexplained.push(((Justification)(antecedent)));
        }
      }
    }
  }

  public static void printExplanationSubstitution(Justification self, OutputStream stream, KeyValueList mapping) {
    mapping = mapping;
    if ((self.inferenceRule == Logic.KWD_MODUS_PONENS) ||
        (self.inferenceRule == Logic.KWD_MODUS_TOLLENS)) {
      { KeyValueMap substitution = Justification.getExplanationSubstitution(self);
        int nofvars = Stella.NULL_INTEGER;

        if (substitution != null) {
          nofvars = substitution.length();
          if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_ASCII) {
            stream.nativeStream.print(Logic.$EXPLANATION_TAB_STRING$ + "with substitution {");
          }
          else if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_HTML) {
            stream.nativeStream.println("<BR><TABLE><TR>");
            {
              stream.nativeStream.print("<TD align=left valign=top>");
              stream.nativeStream.println("with&nbsp;substitution");
              stream.nativeStream.println("</TD>");
            }
            stream.nativeStream.print("<TD>{");
          }
          else if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_XML) {
            stream.nativeStream.print("<variables>");
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + ((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
          { Stella_Object var = null;
            Stella_Object value = null;
            DictionaryIterator iter000 = ((DictionaryIterator)(substitution.allocateIterator()));
            int i = Stella.NULL_INTEGER;
            int iter001 = 1;
            int upperBound000 = nofvars;
            boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

            for (;iter000.nextP() &&
                      (unboundedP000 ||
                       (iter001 <= upperBound000)); iter001 = iter001 + 1) {
              var = iter000.key;
              value = iter000.value;
              i = iter001;
              Logic.printOneVariableSubstitution(stream, var, value);
              if ((i < nofvars) &&
                  ((((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_ASCII) ||
                   (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_HTML))) {
                stream.nativeStream.print(", ");
                if (Logic.$CYC_KLUDGES_ENABLEDp$) {
                  if ((((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_ASCII) ||
                      (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_HTML)) {
                    {
                      stream.nativeStream.println();
                      stream.nativeStream.print(Logic.$EXPLANATION_TAB_STRING$ + "                   ");
                    }
;
                  }
                }
              }
            }
          }
          if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_ASCII) {
            stream.nativeStream.println("}");
          }
          else if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_HTML) {
            stream.nativeStream.println("}</TD></TR></TABLE>");
          }
          else if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_XML) {
            stream.nativeStream.println("</variables>");
          }
          else {
            { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

              stream001.nativeStream.print("`" + ((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
            }
          }
        }
      }
    }
  }

  public static KeyValueMap getExplanationSubstitution(Justification self) {
    { Justification ruleJustification = ((Justification)(self.antecedents.value));
      Proposition rule = ruleJustification.proposition;
      Justification antecedentJustification = ((Justification)(self.antecedents.rest.value));
      KeyValueMap antecedentSubstitution = antecedentJustification.substitution;

      if (Stella_Object.isaP(self, Logic.SGT_LOGIC_FORWARD_JUSTIFICATION)) {
        antecedentSubstitution = self.substitution;
      }
      return (antecedentSubstitution);
    }
  }

  public static String makeRuleOriginExplanationPhrase(Justification self) {
    { Proposition satellite = self.proposition;
      Proposition master = ((Proposition)(KeyValueList.dynamicSlotValue(satellite.dynamicSlots, Logic.SYM_LOGIC_MASTER_PROPOSITION, null)));
      Description head = ((Description)((satellite.arguments.theArray)[1]));
      Description tail = ((Description)((satellite.arguments.theArray)[0]));
      NamedDescription namedsource = null;
      Description source = null;

      { int i = Stella.NULL_INTEGER;
        int iter000 = 1;
        int upperBound000 = 4;

        loop000 : for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          switch (i) {
            case 1: 
              source = head;
            break;
            case 2: 
              source = ((Description)(KeyValueList.dynamicSlotValue(head.dynamicSlots, Logic.SYM_LOGIC_COMPLEMENT_DESCRIPTION, null)));
            break;
            case 3: 
              source = tail;
            break;
            case 4: 
              source = ((Description)(KeyValueList.dynamicSlotValue(tail.dynamicSlots, Logic.SYM_LOGIC_COMPLEMENT_DESCRIPTION, null)));
            break;
            default:
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("`" + i + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
          }
          if ((source != null) &&
              Stella_Object.isaP(source, Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
            if (Logic.originatedPropositions(source).memberP(master)) {
              namedsource = ((NamedDescription)(source));
              break loop000;
            }
          }
        }
      }
      if (namedsource != null) {
        return (Logic.lookupExplanationPhrase(Logic.KWD_DEFINITION, Stella.NIL, null) + " " + Logic.nameObjectMetaclass(namedsource) + " " + namedsource.descriptionName().symbolName);
      }
      else {
        return (Logic.lookupExplanationPhrase(Logic.KWD_LOOKUP_ASSERTIONS, Stella.NIL, null));
      }
    }
  }

  public static boolean partiallyFollowsP(Justification self) {
    return ((self.truthValue == Logic.UNKNOWN_TRUTH_VALUE) ||
        (self.truthValue == null));
  }

  public static boolean markAsCutoffGoalP(Justification self) {
    return (Justification.cutoffGoalJustificationP(self));
  }

  public static boolean markAsFailedGoalP(Justification self) {
    return ((((Keyword)(Logic.$EXPLANATION_STYLE$.get())) == Logic.KWD_BRIEF) &&
        ((self.inferenceRule == Logic.KWD_PRIMITIVE_STRATEGY) &&
         Justification.failedGoalJustificationP(self)));
  }

  public static boolean markAsExplicitAssertionP(Justification self) {
    if (((Keyword)(Logic.$EXPLANATION_STYLE$.get())) == Logic.KWD_BRIEF) {
      if (self.inferenceRule == Logic.KWD_PRIMITIVE_STRATEGY) {
        { Keyword testValue000 = ((PrimitiveStrategy)(self)).strategy;

          if ((testValue000 == Logic.KWD_SCAN_COLLECTION) ||
              ((testValue000 == Logic.KWD_SCAN_PROPOSITIONS) ||
               ((testValue000 == Logic.KWD_LOOKUP_ASSERTIONS) ||
                (testValue000 == Logic.KWD_EQUIVALENCE)))) {
            return (true);
          }
          else {
          }
        }
      }
      else {
      }
    }
    return (false);
  }

  public static void printExplanationText(Justification self, OutputStream stream, KeyValueList mapping) {
    { String introduction = "";
      String inference = null;
      String amplification = "";
      Cons modifiers = Stella.NIL;
      Cons modifiersI = Cons.cons(Logic.KWD_AMPLIFICATION, Stella.NIL);

      if (self.reversePolarityP) {
        modifiers = Cons.cons(Logic.KWD_REVERSE, modifiers);
        modifiersI = Cons.cons(Logic.KWD_REVERSE, modifiersI);
      }
      if (Justification.partiallyFollowsP(self)) {
        modifiers = Cons.cons(Logic.KWD_PARTIAL, modifiers);
        modifiersI = Cons.cons(Logic.KWD_PARTIAL, modifiersI);
      }
      if (Justification.failedGoalJustificationP(self)) {
        introduction = Logic.lookupExplanationPhrase(Logic.KWD_FAILED, modifiers, null);
      }
      else if (Stella_Object.isaP(self, Logic.SGT_LOGIC_CLASH_JUSTIFICATION)) {
        introduction = Logic.lookupExplanationPhrase(Logic.KWD_INCONSISTENT, modifiers, null);
      }
      else {
        introduction = Logic.lookupExplanationPhrase(Logic.KWD_FOLLOWS, modifiers, null);
      }
      if (self.inferenceRule == Logic.KWD_PRIMITIVE_STRATEGY) {
        if (self.inferenceStrategy() == Logic.KWD_SCAN_PROPOSITIONS) {
          if (((Proposition)(KeyValueList.dynamicSlotValue(self.proposition.dynamicSlots, Logic.SYM_LOGIC_MASTER_PROPOSITION, null))) != null) {
            introduction = Logic.lookupExplanationPhrase(Logic.KWD_HOLDS, Stella.NIL, null);
            inference = Justification.makeRuleOriginExplanationPhrase(self);
          }
        }
        else {
        }
        if (inference == null) {
          inference = Logic.lookupExplanationPhrase(self.inferenceStrategy(), modifiers, null);
        }
      }
      else {
        inference = Logic.lookupExplanationPhrase(self.inferenceRule, modifiers, null);
        amplification = Logic.lookupExplanationPhrase(self.inferenceRule, modifiersI, null);
      }
      if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_ASCII) {
        stream.nativeStream.print(Logic.$EXPLANATION_TAB_STRING$);
        stream.nativeStream.print(introduction + " " + inference);
        if ((amplification.length() > 0) &&
            (!Stella.stringEqlP(amplification, inference))) {
          stream.nativeStream.print(" " + amplification);
        }
        if (self.inferenceDirection() == Logic.KWD_FORWARD) {
          stream.nativeStream.print(" [Forward]");
        }
        stream.nativeStream.println();
      }
      else if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_HTML) {
        stream.nativeStream.println("<BR>");
        stream.nativeStream.print(introduction + " " + inference);
        if ((amplification.length() > 0) &&
            (!Stella.stringEqlP(amplification, inference))) {
          stream.nativeStream.print(" " + amplification);
        }
        if (self.inferenceDirection() == Logic.KWD_FORWARD) {
          stream.nativeStream.print(" [Forward]");
        }
        stream.nativeStream.println();
      }
      else if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_XML) {
        stream.nativeStream.print("<method");
        if (self.inferenceDirection() == Logic.KWD_FORWARD) {
          stream.nativeStream.print(" direction='forward'");
        }
        stream.nativeStream.println(">" + inference + "</method>");
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + ((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static void printExplanationHeader(Justification self, OutputStream stream, KeyValueList mapping) {
    { ExplanationInfo info = Justification.explanationInfo(self, mapping);
      String label = info.label;
      int indent = label.length() + 1;

      if ((((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_XML) ||
          (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_ASCII)) {
        Logic.printExplanationLabel(stream, label, true);
      }
      else if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_HTML) {
        {
          stream.nativeStream.print("<TD align=left valign=top>");
          Logic.printExplanationLabel(stream, label, true);
          stream.nativeStream.println("</TD>");
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + ((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      if (label.length() > Logic.$MAX_INLINE_LABEL_LENGTH$) {
        {
          stream.nativeStream.println();
          stream.nativeStream.print(Logic.$EXPLANATION_TAB_STRING$);
        }
;
        indent = Logic.$EXPLANATION_TAB_STRING$.length();
      }
      else {
        stream.nativeStream.print(" ");
      }
      if ((((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_XML) ||
          (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_ASCII)) {
      }
      else if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_HTML) {
        stream.nativeStream.print("<TD align=left valign=top>");
      }
      else {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("`" + ((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
      Justification.printJustificationPropositionForFormat(self, stream, indent);
      stream.nativeStream.println();
      info.explainedP = true;
    }
  }

  public static void printJustificationProposition(Justification self, OutputStream stream, int indent) {
    { Object old$Indentcounter$000 = Logic.$INDENTCOUNTER$.get();
      Object old$Printmode$000 = Logic.$PRINTMODE$.get();

      try {
        Native.setIntSpecial(Logic.$INDENTCOUNTER$, indent);
        Native.setSpecial(Logic.$PRINTMODE$, Logic.KWD_REALISTIC);
        { Proposition proposition = self.proposition;

          if (self.reversePolarityP) {
            proposition = Logic.createProposition(Logic.SYM_STELLA_NOT, 1);
            (proposition.arguments.theArray)[0] = (self.proposition);
          }
          { Object old$Currentjustification$000 = Logic.$CURRENTJUSTIFICATION$.get();

            try {
              Native.setSpecial(Logic.$CURRENTJUSTIFICATION$, self);
              Logic.prettyPrintLogicalForm(proposition, stream);

            } finally {
              Logic.$CURRENTJUSTIFICATION$.set(old$Currentjustification$000);
            }
          }
        }

      } finally {
        Logic.$PRINTMODE$.set(old$Printmode$000);
        Logic.$INDENTCOUNTER$.set(old$Indentcounter$000);
      }
    }
  }

  public static void printJustificationPropositionForFormat(Justification self, OutputStream stream, int indent) {
    if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_ASCII) {
      Justification.printJustificationProposition(self, stream, indent);
    }
    else if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_HTML) {
      { OutputStringStream stringStream = OutputStringStream.newOutputStringStream();
        boolean quotehtmlP = true;

        Justification.printJustificationProposition(self, stringStream, indent);
        if (Logic.$CYC_KLUDGES_ENABLEDp$) {
          if (((Keyword)(Logic.$LOGIC_DIALECT$.get())) == Logic.KWD_CYC_NL) {
            quotehtmlP = false;
          }
        }
        if ((((Keyword)(Logic.$LOGIC_DIALECT$.get())) == Logic.KWD_KIF_ONTOSAURUS) ||
            (((Keyword)(Logic.$LOGIC_DIALECT$.get())) == Logic.KWD_JAVA_GUI_HTML)) {
          quotehtmlP = false;
        }
        if (quotehtmlP) {
          Stella.writeHtmlQuotingSpecialCharacters(stream.nativeStream, stringStream.theStringReader());
        }
        else {
          stream.nativeStream.print(stringStream.theStringReader());
        }
      }
    }
    else if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_XML) {
      { Proposition proposition = self.proposition;
        OutputStringStream stringStream = OutputStringStream.newOutputStringStream();

        Justification.printJustificationProposition(self, stringStream, 0);
        stream.nativeStream.print("<proposition type=\"");
        if (proposition.kind == Logic.KWD_IMPLIES) {
          stream.nativeStream.print("RULE");
        }
        else {
          stream.nativeStream.print("FACT");
        }
        stream.nativeStream.print("\" truthvalue=\"" + (((self.truthValue == null) ? Logic.UNKNOWN_TRUTH_VALUE : self.truthValue)));
        stream.nativeStream.println("\">");
        Stella.writeHtmlQuotingSpecialCharacters(stream.nativeStream, stringStream.theStringReader());
        {
          stream.nativeStream.println();
          stream.nativeStream.print("</proposition>");
        }
;
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + ((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static void printOneExplanation(Justification self, OutputStream stream, KeyValueList mapping, int maxdepth, List unexplained) {
    if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_ASCII) {
      Justification.printExplanationHeader(self, stream, mapping);
      Justification.printExplanationSupport(self, stream, mapping, maxdepth, unexplained);
      stream.nativeStream.println();
    }
    else if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_XML) {
      {
        stream.nativeStream.print("<inference>");
        stream.nativeStream.println();
        Justification.printExplanationHeader(self, stream, mapping);
        {
          stream.nativeStream.print("<support>");
          stream.nativeStream.println();
          Justification.printExplanationSupport(self, stream, mapping, maxdepth, unexplained);
          stream.nativeStream.println("</support>");
        }
        stream.nativeStream.println("</inference>");
      }
    }
    else if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_HTML) {
      {
        stream.nativeStream.print("<TABLE>");
        {
          stream.nativeStream.print("<TR>");
          stream.nativeStream.println();
          Justification.printExplanationHeader(self, stream, mapping);
          Justification.printExplanationSupport(self, stream, mapping, maxdepth, unexplained);
          stream.nativeStream.print("</TD>");
          stream.nativeStream.println("</TR>");
        }
        stream.nativeStream.println("</TABLE>");
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + ((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static void printExplanationSupport(Justification self, OutputStream stream, KeyValueList mapping, int maxdepth, List unexplained) {
    Justification.printExplanationText(self, stream, mapping);
    Justification.printExplanationSubstitution(self, stream, mapping);
    Justification.printExplanationAntecedents(self, stream, mapping, maxdepth, unexplained);
  }

  public static KeyValueList printExplanation(Justification self, OutputStream stream, KeyValueList mapping, int maxdepth, Keyword audience) {
    { List unexplained = List.newList();
      ExplanationInfo info = null;

      self = Justification.visibleJustification(self);
      if (mapping == null) {
        mapping = KeyValueList.newKeyValueList();
        info = Justification.registerJustification(self, mapping);
        info.label = "1";
        info.depth = 1;
      }
      else {
        info = Justification.explanationInfo(self, mapping);
        if (info == null) {
          throw ((StellaException)(StellaException.newStellaException("Justification not found in supplied explanation mapping.").fillInStackTrace()));
        }
        Logic.resetMappingForSubexplanation(mapping);
        maxdepth = (info.depth + maxdepth) - 1;
      }
      unexplained.push(self);
      { Object old$ExplanationAudience$000 = Logic.$EXPLANATION_AUDIENCE$.get();

        try {
          Native.setSpecial(Logic.$EXPLANATION_AUDIENCE$, audience);
          while (unexplained.nonEmptyP()) {
            self = ((Justification)(unexplained.pop()));
            Justification.printOneExplanation(self, stream, mapping, maxdepth, unexplained);
          }

        } finally {
          Logic.$EXPLANATION_AUDIENCE$.set(old$ExplanationAudience$000);
        }
      }
      Native.setSpecial(Logic.$MOST_RECENT_EXPLANATION_MAPPING$, mapping);
      return (mapping);
    }
  }

  public static ExplanationInfo explanationInfo(Justification self, KeyValueList mapping) {
    return (Justification.getExplanationInfo(self, mapping, false));
  }

  public static ExplanationInfo getExplanationInfo(Justification self, KeyValueList mapping, boolean createP) {
    { ExplanationInfo info = ((ExplanationInfo)(mapping.lookup(self)));

      if (!(info != null)) {
        { Justification just = null;
          ExplanationInfo info000 = null;
          KvCons iter000 = mapping.theKvList;

          for (;iter000 != null; iter000 = iter000.rest) {
            just = ((Justification)(iter000.key));
            info000 = ((ExplanationInfo)(iter000.value));
            if (Justification.justificationEqlP(just, self)) {
              mapping.insertAt(self, info000);
              return (info000);
            }
          }
        }
        if (createP) {
          info = ExplanationInfo.newExplanationInfo();
          mapping.insertAt(self, info);
        }
      }
      return (info);
    }
  }

  public static ExplanationInfo registerJustification(Justification self, KeyValueList mapping) {
    return (Justification.getExplanationInfo(self, mapping, true));
  }

  public static String explanationTruthMarker(Justification justification) {
    { Keyword holdsby = null;

      if (Justification.markAsExplicitAssertionP(justification)) {
        holdsby = Logic.KWD_ASSERTION;
      }
      else if (Justification.markAsFailedGoalP(justification)) {
        holdsby = Logic.KWD_FAILURE;
      }
      else if (Justification.markAsCutoffGoalP(justification)) {
        holdsby = Logic.KWD_CUTOFF;
      }
      else {
        holdsby = Logic.KWD_INFERENCE;
      }
      if (((Keyword)(Logic.$EXPLANATION_FORMAT$.get())) == Logic.KWD_HTML) {
        { String label = "Fact:";
          String green = "#00ff00";
          String yellow = "#ffd70";
          String red = "#ff0000";
          String color = null;

          if (holdsby == Logic.KWD_ASSERTION) {
            if (justification.proposition.kind == Logic.KWD_IMPLIES) {
              label = "Rule:";
            }
            color = green;
          }
          else if (holdsby == Logic.KWD_FAILURE) {
            color = red;
            label = "Unknown:";
          }
          else if (holdsby == Logic.KWD_CUTOFF) {
            color = red;
            label = "Cutoff:";
          }
          else if (holdsby == Logic.KWD_INFERENCE) {
            label = "Inferred:";
            if (Justification.partiallyFollowsP(justification)) {
              color = yellow;
            }
            else {
              color = green;
            }
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + holdsby + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
          if (color != null) {
            label = "<font color=\"" + color + "\">" + "<strong>" + label + "</strong>" + "</font>";
          }
          return (label);
        }
      }
      else {
        if (holdsby == Logic.KWD_ASSERTION) {
          return (Logic.$EXPLANATION_ASSERTION_MARKER$);
        }
        else if (holdsby == Logic.KWD_FAILURE) {
          return (Logic.$EXPLANATION_FAILURE_MARKER$);
        }
        else if (holdsby == Logic.KWD_CUTOFF) {
          return (Logic.$EXPLANATION_CUTOFF_MARKER$);
        }
        else if (holdsby == Logic.KWD_INFERENCE) {
          return (Logic.$EXPLANATION_INFERENCE_MARKER$);
        }
        else {
          { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

            stream001.nativeStream.print("`" + holdsby + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  /** Return a CONS tree representation of the proof <code>self</code>.
   * Each proof step is represented as a CONS tree of the form
   *   (&lt;proposition&gt; (&lt;key&gt; &lt;value&gt;...) &lt;antecedent&gt;...)
   * where each &lt;antecedent&gt; is a CONS tree representing a subproof.
   * <code>style</code> indicates what nodes in the proof tree should be suppressed.
   * :RAW preserves the original structure literally, :VERBOSE keeps AND-
   * introductions but suppresses all auxiliary (non-logical) nodes such as
   * pattern nodes, and :BRIEF additionally suppresses AND-introduction nodes.
   * @param self
   * @param style
   * @return Cons
   */
  public static Cons consifyJustification(Justification self, Keyword style) {
    { Object old$ExplanationStyle$000 = Logic.$EXPLANATION_STYLE$.get();

      try {
        Native.setSpecial(Logic.$EXPLANATION_STYLE$, style);
        if (!(style == Logic.KWD_RAW)) {
          self = Justification.visibleJustification(self);
        }
        { Cons antecedents = ((style == Logic.KWD_RAW) ? self.antecedents : Justification.visibleAntecedents(self).theConsList);
          Stella_Object proposition = null;
          PropertyList keys = PropertyList.newPropertyList();
          Cons substitution = Stella.NIL;
          Cons consifiedself = Stella.NIL;

          if (self.inferenceRule != null) {
            keys.insertAt(Logic.KWD_INFERENCE_RULE, self.inferenceRule);
            if (Stella_Object.isaP(self, Logic.SGT_LOGIC_PRIMITIVE_STRATEGY)) {
              keys.insertAt(Logic.KWD_STRATEGY, ((PrimitiveStrategy)(self)).strategy);
            }
          }
          if (self.truthValue != null) {
            keys.insertAt(Logic.KWD_TRUTH_VALUE, self.truthValue);
          }
          else {
            keys.insertAt(Logic.KWD_TRUTH_VALUE, Logic.UNKNOWN_TRUTH_VALUE);
          }
          if (self.positiveScore != Stella.NULL_FLOAT) {
            keys.insertAt(Logic.KWD_POSITIVE_SCORE, FloatWrapper.wrapFloat(self.positiveScore));
          }
          { KeyValueMap thesubstitution = self.substitution;

            if (thesubstitution == null) {
              { Justification ant = null;
                Cons iter000 = self.antecedents;

                loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  ant = ((Justification)(iter000.value));
                  if (ant.inferenceRule == Logic.KWD_PATTERN) {
                    thesubstitution = ant.substitution;
                    break loop000;
                  }
                }
              }
            }
            if (thesubstitution != null) {
              { PatternVariable var = null;
                Stella_Object binding = null;
                DictionaryIterator iter001 = ((DictionaryIterator)(thesubstitution.allocateIterator()));

                while (iter001.nextP()) {
                  var = ((PatternVariable)(iter001.key));
                  binding = iter001.value;
                  substitution = Cons.cons(Logic.generateTerm(var), substitution);
                  substitution = Cons.cons(Logic.generateTerm(binding), substitution);
                }
              }
              keys.insertAt(Logic.KWD_SUBSTITUTION, substitution.reverse());
            }
          }
          { Object old$Currentjustification$000 = Logic.$CURRENTJUSTIFICATION$.get();

            try {
              Native.setSpecial(Logic.$CURRENTJUSTIFICATION$, self);
              proposition = Proposition.generateProposition(self.proposition);
              if (self.reversePolarityP) {
                proposition = Cons.list$(Cons.cons(Logic.SYM_STELLA_NOT, Cons.cons(proposition, Cons.cons(Stella.NIL, Stella.NIL))));
              }

            } finally {
              Logic.$CURRENTJUSTIFICATION$.set(old$Currentjustification$000);
            }
          }
          consifiedself = Cons.consList(Cons.cons(proposition, Cons.cons(keys.thePlist, Stella.NIL)));
          { Justification antecedent = null;
            Cons iter002 = antecedents;
            Cons collect000 = null;

            for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
              antecedent = ((Justification)(iter002.value));
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(Justification.consifyJustification(antecedent, style), Stella.NIL);
                  if (consifiedself == Stella.NIL) {
                    consifiedself = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(consifiedself, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(Justification.consifyJustification(antecedent, style), Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
          return (consifiedself);
        }

      } finally {
        Logic.$EXPLANATION_STYLE$.set(old$ExplanationStyle$000);
      }
    }
  }

  /** Return a CONS tree representation of the proof <code>self</code>.
   * Each proof step is represented as a CONS tree of the form
   *   (&lt;proposition&gt; (&lt;key&gt; &lt;value&gt;...) &lt;antecedent&gt;...)
   * where each &lt;antecedent&gt; is a CONS tree representing a subproof.  The
   * consification follows the original proof structure literally, i.e., no
   * uninteresting nodes such as patterns or AND-introductions are suppressed.
   * @return Cons
   */
  public Cons consify() {
    { Justification self = this;

      return (Justification.consifyJustification(self, Logic.KWD_RAW));
    }
  }

  public static boolean cutoffGoalJustificationP(Justification self) {
    { Keyword testValue000 = self.inferenceRule;

      if ((testValue000 == Logic.KWD_TIMEOUT) ||
          (testValue000 == Logic.KWD_DEPTH_CUTOFF)) {
        return (true);
      }
      else {
      }
    }
    return (false);
  }

  public static boolean failedGoalJustificationP(Justification self) {
    { Keyword testValue000 = self.inferenceRule;

      if ((testValue000 == Logic.KWD_PRIMITIVE_STRATEGY) ||
          ((testValue000 == Logic.KWD_TIMEOUT) ||
           (testValue000 == Logic.KWD_DEPTH_CUTOFF))) {
        if (((PrimitiveStrategy)(self)).strategy == Logic.KWD_FAILURE) {
          return (true);
        }
        else {
        }
      }
      else {
      }
    }
    return (false);
  }

  public static void backlinkToPatternJustification(Justification justification, Justification pattern) {
    if (justification.substitution == null) {
      justification.substitution = pattern.substitution;
      { Justification antecedent = null;
        Cons iter000 = justification.antecedents;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          antecedent = ((Justification)(iter000.value));
          Justification.backlinkToPatternJustification(antecedent, pattern);
        }
      }
    }
  }

  /** Similar to <code>copy</code> but does not copy antecedent justifications.
   * @return Justification
   */
  public Justification shallowCopy() {
    { Justification self = this;

      { Justification copy = null;
        Cons antecedents = Stella.NIL;

        if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(self), Logic.SGT_LOGIC_PRIMITIVE_STRATEGY)) {
          { PrimitiveStrategy self000 = ((PrimitiveStrategy)(self));

            { PrimitiveStrategy self001 = PrimitiveStrategy.newPrimitiveStrategy();

              self001.strategy = self000.strategy;
              copy = self001;
            }
          }
        }
        else {
          copy = Justification.newJustification();
        }
        copy.inferenceRule = self.inferenceRule;
        copy.proposition = self.proposition;
        copy.substitution = self.substitution;
        copy.reversePolarityP = self.reversePolarityP;
        copy.truthValue = self.truthValue;
        copy.positiveScore = self.positiveScore;
        copy.negativeScore = self.negativeScore;
        { Justification antecedent = null;
          Cons iter000 = self.antecedents;
          Cons collect000 = null;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            antecedent = ((Justification)(iter000.value));
            if (collect000 == null) {
              {
                collect000 = Cons.cons(antecedent, Stella.NIL);
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
                collect000.rest = Cons.cons(antecedent, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        copy.antecedents = antecedents;
        return (copy);
      }
    }
  }

  /** Return a copy of the proof starting at <code>self</code>.  Allocates
   * all new justification objects, but structure-shares other information such
   * as propositions and substitutions.
   * @return Justification
   */
  public Justification copy() {
    { Justification self = this;

      { Justification copy = null;
        Cons antecedents = Stella.NIL;

        if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(self), Logic.SGT_LOGIC_PRIMITIVE_STRATEGY)) {
          { PrimitiveStrategy self000 = ((PrimitiveStrategy)(self));

            { PrimitiveStrategy self001 = PrimitiveStrategy.newPrimitiveStrategy();

              self001.strategy = self000.strategy;
              copy = self001;
            }
          }
        }
        else {
          copy = Justification.newJustification();
        }
        copy.inferenceRule = self.inferenceRule;
        copy.proposition = self.proposition;
        copy.substitution = self.substitution;
        copy.reversePolarityP = self.reversePolarityP;
        copy.truthValue = self.truthValue;
        copy.positiveScore = self.positiveScore;
        copy.negativeScore = self.negativeScore;
        { Justification antecedent = null;
          Cons iter000 = self.antecedents;
          Cons collect000 = null;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            antecedent = ((Justification)(iter000.value));
            if (collect000 == null) {
              {
                collect000 = Cons.cons(antecedent.copy(), Stella.NIL);
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
                collect000.rest = Cons.cons(antecedent.copy(), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        copy.antecedents = antecedents;
        return (copy);
      }
    }
  }

  public static boolean justificationEqlP(Justification just1, Justification just2) {
    return ((just1 == just2) ||
        ((just1.inferenceRule == just2.inferenceRule) &&
         ((just1.reversePolarityP == just2.reversePolarityP) &&
          ((((!(just1.inferenceRule == Logic.KWD_PRIMITIVE_STRATEGY)) &&
        (!(just2.inferenceRule == Logic.KWD_PRIMITIVE_STRATEGY))) ||
        (((PrimitiveStrategy)(just1)).strategy == ((PrimitiveStrategy)(just2)).strategy)) &&
           Proposition.justificationPropositionsEqlP(just1.proposition, just1, just2.proposition, just2)))));
  }

  public static Stella_Object accessJustificationSlotValue(Justification self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_INFERENCE_RULE) {
      if (setvalueP) {
        self.inferenceRule = ((Keyword)(value));
      }
      else {
        value = self.inferenceRule;
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
    else if (slotname == Logic.SYM_LOGIC_ANTECEDENTS) {
      if (setvalueP) {
        self.antecedents = ((Cons)(value));
      }
      else {
        value = self.antecedents;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_SUBSTITUTION) {
      if (setvalueP) {
        self.substitution = ((KeyValueMap)(value));
      }
      else {
        value = self.substitution;
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
    else if (slotname == Logic.SYM_LOGIC_TRUTH_VALUE) {
      if (setvalueP) {
        self.truthValue = ((TruthValue)(value));
      }
      else {
        value = self.truthValue;
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
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + slotname + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    return (value);
  }

  public Keyword inferenceDirection() {
    { Justification self = this;

      return (Logic.KWD_BACKWARD);
    }
  }

  public Keyword inferenceStrategy() {
    { Justification self = this;

      return (null);
    }
  }

  public Surrogate primaryType() {
    { Justification self = this;

      return (Logic.SGT_LOGIC_JUSTIFICATION);
    }
  }

}

