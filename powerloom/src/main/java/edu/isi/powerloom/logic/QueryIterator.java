//  -*- Mode: Java -*-
//
// QueryIterator.java

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

/** A query iterator points to a query environment
 * representing the initial or intermediate state of a query.  The iterator's
 * 'value' is a vector representing a satisfying set bindings of the query's
 * output variables.  Each call to the iterator writes a new set of bindings
 * into the vector.
 * @author Stella Java Translator
 */
public class QueryIterator extends Iterator {
    public Vector externalVariables;
    public boolean exhaustedP;
    public PropertyList options;
    /** Each element holds a solution record with a
     * vector of bindings of the free external variables of the query plus all
     * the appropriate truth-value and justification support.
     */
    public QuerySolutionTable solutions;
    public Context queryContext;
    public ControlFrame baseControlFrame;
    public ControlFrame currentControlFrame;
    public PatternRecord currentPatternRecord;
    public ParallelThread currentParallelThread;
    public ControlFramePriorityQueue controlFramePriorityQueue;
    public boolean augmentedGoalCacheP;
    public List activeGoalCaches;
    public boolean triggeredDepthCutoffP;
    public boolean failedToFindDuplicateSubgoalP;
    public boolean foundAtLeastOneSolutionP;
    public int timestamp;
    public PartialMatchFrame partialMatchStrategy;
    public InferenceLevel inferenceLevel;
    public int currentDepthCutoff;
    public int maximumDepth;
    /** If defined, timeout after that many seconds.
     */
    public double allottedTime;
    /** If defined, timeout after that many :DOWN moves.
     */
    public int allottedClockTicks;
    public int currentClockTicks;
    /** Set to TRUE if query times out.
     */
    public boolean timeoutP;
    /** Set to TRUE if one or more depth cutoffs occurred.
     */
    public boolean depthCutoffsP;
    public KeyValueList dynamicSlots;

  public static QueryIterator newQueryIterator() {
    { QueryIterator self = null;

      self = new QueryIterator();
      self.dynamicSlots = KeyValueList.newKeyValueList();
      self.firstIterationP = true;
      self.value = null;
      self.depthCutoffsP = false;
      self.timeoutP = false;
      self.currentClockTicks = 0;
      self.allottedClockTicks = Stella.NULL_INTEGER;
      self.allottedTime = Stella.NULL_FLOAT;
      self.maximumDepth = Stella.NULL_INTEGER;
      self.currentDepthCutoff = Stella.NULL_INTEGER;
      self.inferenceLevel = null;
      self.partialMatchStrategy = null;
      self.timestamp = Stella.NULL_INTEGER;
      self.foundAtLeastOneSolutionP = false;
      self.failedToFindDuplicateSubgoalP = false;
      self.triggeredDepthCutoffP = false;
      self.activeGoalCaches = List.newList();
      self.augmentedGoalCacheP = false;
      self.controlFramePriorityQueue = null;
      self.currentParallelThread = null;
      self.currentPatternRecord = null;
      self.currentControlFrame = null;
      self.baseControlFrame = null;
      self.queryContext = null;
      self.solutions = QuerySolutionTable.newQuerySolutionTable();
      self.options = PropertyList.newPropertyList();
      self.exhaustedP = false;
      self.externalVariables = null;
      return (self);
    }
  }

  /** Programmer's interface to WHYNOT function.  Derive
   * justifications why <code>query</code> failed, or, if <code>label</code> was supplied as non-NULL,
   * lookup its justification relative to <code>mapping</code> and return the result.
   * @param query
   * @param label
   * @param mapping
   * @return List
   */
  public static List getWhynotJustifications(QueryIterator query, String label, KeyValueList mapping) {
    { List justifications = null;

      if (query == null) {
        query = Logic.$MOST_RECENT_QUERY$;
      }
      if (mapping == null) {
        mapping = ((KeyValueList)(Logic.$MOST_RECENT_EXPLANATION_MAPPING$.get()));
      }
      if (query == null) {
        throw ((ExplainNoQueryException)(ExplainNoQueryException.newExplainNoQueryException("There is nothing to explain.").fillInStackTrace()));
      }
      if ((!(query.partialMatchStrategy != null)) &&
          (!query.exhaustedP)) {
        throw ((ExplainQueryTrueException)(ExplainQueryTrueException.newExplainQueryTrueException("The query did not fail.").fillInStackTrace()));
      }
      query = QueryIterator.deriveJustifiedPartialQuery(query);
      justifications = query.baseControlFrame.allJustifications();
      if (label != null) {
        if (mapping != null) {
          justifications = List.list(Cons.cons(Logic.lookupJustification(mapping, label), Stella.NIL));
        }
        if (justifications.first() == null) {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("Label `" + label + "' does not exists in the current explanation");
            throw ((ExplainNoSuchLabelException)(ExplainNoSuchLabelException.newExplainNoSuchLabelException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      return (justifications);
    }
  }

  public static QueryIterator deriveJustifiedPartialQuery(QueryIterator query) {
    if ((query.partialMatchStrategy != null) &&
        (((Justification)(KeyValueList.dynamicSlotValue(query.baseControlFrame.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null))) != null)) {
      return (query);
    }
    { QueryIterator partialquery = Description.createQueryIterator(query.baseControlFrame.patternRecord.description, ((QuerySolution)(query.value)).bindings);
      boolean recordjustificationsP = ((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue();

      partialquery.options.insertAt(Logic.KWD_MATCH_MODE, Logic.KWD_WHYNOT);
      Logic.setPowerloomFeature(Logic.KWD_JUSTIFICATIONS);
      Logic.callAskPartial(partialquery);
      if (!(recordjustificationsP)) {
        Logic.unsetPowerloomFeature(Logic.KWD_JUSTIFICATIONS);
      }
      return (partialquery);
    }
  }

  public static void cutoffSimilarWhynotProofs(QueryIterator query) {
    { ControlFrame continuationframe = query.baseControlFrame;

      while (continuationframe.down != null) {
        continuationframe = continuationframe.down;
      }
      if (((Iterator)(KeyValueList.dynamicSlotValue(continuationframe.dynamicSlots, Logic.SYM_STELLA_ITERATOR, null))) != null) {
        KeyValueList.setDynamicSlotValue(continuationframe.dynamicSlots, Logic.SYM_STELLA_ITERATOR, Stella.NIL.allocateIterator(), null);
        if (Stella_Object.traceKeywordP(Logic.KWD_GOAL_TREE)) {
          { Object old$Printinframe$000 = Logic.$PRINTINFRAME$.get();
            Object old$Printmode$000 = Logic.$PRINTMODE$.get();
            Object old$Printlogicalformstream$000 = Logic.$PRINTLOGICALFORMSTREAM$.get();
            Object old$Queryiterator$000 = Logic.$QUERYITERATOR$.get();

            try {
              Native.setSpecial(Logic.$PRINTINFRAME$, continuationframe);
              Native.setSpecial(Logic.$PRINTMODE$, Logic.KWD_REALISTIC);
              Native.setSpecial(Logic.$PRINTLOGICALFORMSTREAM$, Stella.STANDARD_OUTPUT);
              Native.setSpecial(Logic.$QUERYITERATOR$, query);
              Stella.STANDARD_OUTPUT.nativeStream.print("*** cutting off similar WhyNot proofs at goal=");
              Logic.printUnformattedLogicalForm(continuationframe.proposition, Stella.STANDARD_OUTPUT);
              Stella.STANDARD_OUTPUT.nativeStream.println();

            } finally {
              Logic.$QUERYITERATOR$.set(old$Queryiterator$000);
              Logic.$PRINTLOGICALFORMSTREAM$.set(old$Printlogicalformstream$000);
              Logic.$PRINTMODE$.set(old$Printmode$000);
              Logic.$PRINTINFRAME$.set(old$Printinframe$000);
            }
          }
        }
      }
    }
  }

  public static List deriveQueryJustifications(QueryIterator query, Stella_Object options, int solutionindex, int maxjustifications) {
    { Object old$Queryiterator$000 = Logic.$QUERYITERATOR$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();
      Object old$Inferencelevel$000 = Logic.$INFERENCELEVEL$.get();
      Object old$ReversepolarityP$000 = Logic.$REVERSEPOLARITYp$.get();
      Object old$GenerateAllProofsP$000 = Logic.$GENERATE_ALL_PROOFSp$.get();
      Object old$RecordJustificationsP$000 = Logic.$RECORD_JUSTIFICATIONSp$.get();

      try {
        Native.setSpecial(Logic.$QUERYITERATOR$, query);
        Native.setSpecial(Stella.$CONTEXT$, query.queryContext);
        Native.setSpecial(Logic.$INFERENCELEVEL$, Logic.currentInferenceLevel());
        Native.setBooleanSpecial(Logic.$REVERSEPOLARITYp$, false);
        Native.setBooleanSpecial(Logic.$GENERATE_ALL_PROOFSp$, false);
        Native.setBooleanSpecial(Logic.$RECORD_JUSTIFICATIONSp$, true);
        { QueryIterator askquery = Logic.allocateQueryIterator();
          PropertyList queryoptions = query.options;

          if (options == null) {
            queryoptions = queryoptions.copy();
            queryoptions.removeAt(Logic.KWD_HOW_MANY);
            options = queryoptions;
          }
          QueryIterator.processQueryOptions(askquery, options);
          { Object old$TypeCheckStrategy$000 = Logic.$TYPE_CHECK_STRATEGY$.get();

            try {
              Native.setSpecial(Logic.$TYPE_CHECK_STRATEGY$, Logic.KWD_NONE);
              QueryIterator.initializeQueryIterator(askquery, query.queryDescription(), query.solutions.nth(solutionindex).bindings);

            } finally {
              Logic.$TYPE_CHECK_STRATEGY$.set(old$TypeCheckStrategy$000);
            }
          }
          if (query.queryIsPartialP()) {
            Logic.callAskPartial(askquery);
          }
          else {
            Logic.callAsk(askquery);
          }
          return (QueryIterator.getQueryJustifications(askquery, Stella.NULL_INTEGER, maxjustifications, false));
        }

      } finally {
        Logic.$RECORD_JUSTIFICATIONSp$.set(old$RecordJustificationsP$000);
        Logic.$GENERATE_ALL_PROOFSp$.set(old$GenerateAllProofsP$000);
        Logic.$REVERSEPOLARITYp$.set(old$ReversepolarityP$000);
        Logic.$INFERENCELEVEL$.set(old$Inferencelevel$000);
        Stella.$CONTEXT$.set(old$Context$000);
        Logic.$QUERYITERATOR$.set(old$Queryiterator$000);
      }
    }
  }

  public static List getQueryJustifications(QueryIterator query, int solutionindex, int maxjustifications, boolean createP) {
    { boolean askqueryP = query.queryIsTrueFalseP();
      QuerySolutionTable solutions = query.solutions;
      QuerySolution solution = null;
      int nofsolutions = solutions.length();
      List justifications = null;

      if (solutions.emptyP()) {
        return (Stella.NIL_LIST);
      }
      if (askqueryP ||
          ((solutionindex == Stella.NULL_INTEGER) ||
           (solutionindex < 0))) {
        solutionindex = nofsolutions - 1;
      }
      if (solutionindex >= nofsolutions) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("There were only `" + nofsolutions + "' solutions");
          throw ((ExplainException)(ExplainException.newExplainException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      solution = solutions.nth(solutionindex);
      if (solution.justification == null) {
        if (createP) {
          justifications = QueryIterator.deriveQueryJustifications(query, null, solutionindex, maxjustifications);
          solution.justification = ((Justification)(justifications.first()));
          solution.allJustifications = justifications;
          return (justifications);
        }
        else {
          return (Stella.NIL_LIST);
        }
      }
      else {
        if ((solution.allJustifications != null) &&
            solution.allJustifications.nonEmptyP()) {
          justifications = List.list(Stella.NIL);
          { Justification just = null;
            Cons iter000 = solution.allJustifications.theConsList;
            int ignore = Stella.NULL_INTEGER;
            int iter001 = 1;
            int upperBound000 = maxjustifications;
            boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;
            Cons collect000 = null;

            for (;(!(iter000 == Stella.NIL)) &&
                      (unboundedP000 ||
                       (iter001 <= upperBound000)); iter000 = iter000.rest, iter001 = iter001 + 1) {
              just = ((Justification)(iter000.value));
              ignore = iter001;
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(just, Stella.NIL);
                  if (justifications.theConsList == Stella.NIL) {
                    justifications.theConsList = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(justifications.theConsList, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(just, Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
        }
        if (justifications != null) {
          return (justifications);
        }
        else {
          return (List.list(Cons.cons(solution.justification, Stella.NIL)));
        }
      }
    }
  }

  public static double returnPartialTruth(QueryIterator query, boolean topP) {
    if (!(topP)) {
      query.options.insertAt(Logic.KWD_MAXIMIZE_SCOREp, (topP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
    }
    return (Logic.callAskPartial(query));
  }

  public static void sortSolutionsByScore(QueryIterator query) {
    query.solutions.sort(Native.find_java_method("edu.isi.powerloom.logic.QuerySolution", "solutionScoreGreaterThanP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QuerySolution"), Native.find_java_class("edu.isi.powerloom.logic.QuerySolution")}));
  }

  public static void initializePartialQuery(QueryIterator query) {
    { PartialMatchFrame partialmatchframe = query.partialMatchStrategy;

      if (partialmatchframe == null) {
        partialmatchframe = QueryIterator.makePartialMatchFrame(query);
        query.partialMatchStrategy = partialmatchframe;
      }
      partialmatchframe.initializePartialMatchStrategy(query);
    }
  }

  public static PartialMatchFrame makePartialMatchFrame(QueryIterator query) {
    { GeneralizedSymbol matchmode = ((GeneralizedSymbol)(query.options.lookup(Logic.KWD_MATCH_MODE)));
      ControlFrame frame = query.baseControlFrame;
      Keyword kind = frame.state;

      if (matchmode == null) {
        matchmode = Logic.$PARTIAL_MATCH_MODE$;
      }
      if ((matchmode == Logic.KWD_BASIC) ||
          (matchmode == Logic.KWD_INCREMENTAL)) {
        return (IncrementalPartialMatch.newIncrementalPartialMatch(kind, frame));
      }
      else if ((matchmode == Logic.KWD_NN) ||
          (matchmode == Logic.KWD_NEURAL_NETWORK)) {
        return (NnPartialMatch.newNnPartialMatch(kind, frame));
      }
      else {
        { Stella_Object renamed_Class = null;
          String classname = matchmode.symbolName + "-PARTIAL-MATCH";

          { Module temp000 = matchmode.homeModule();

            { Module module = ((temp000 != null) ? temp000 : ((Module)(Stella.$MODULE$.get())));

              { Object old$Module$000 = Stella.$MODULE$.get();
                Object old$Context$000 = Stella.$CONTEXT$.get();

                try {
                  Native.setSpecial(Stella.$MODULE$, module);
                  Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
                  renamed_Class = Stella.string_lookupClass(classname);
                  if (renamed_Class == null) {
                    renamed_Class = Stella.string_getObject(classname, null);
                  }

                } finally {
                  Stella.$CONTEXT$.set(old$Context$000);
                  Stella.$MODULE$.set(old$Module$000);
                }
              }
              if ((renamed_Class != null) &&
                  Stella_Object.isaP(renamed_Class, Logic.SGT_STELLA_CLASS)) {
                return (((PartialMatchFrame)(Surrogate.createObject(((Stella_Class)(renamed_Class)).classType, Cons.cons(Logic.KWD_CONTROL_FRAME, Cons.cons(frame, Cons.cons(Logic.KWD_KIND, Cons.cons(kind, Stella.NIL))))))));
              }
              else {
                { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                  { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      stream000.nativeStream.println("PARSING ERROR: Unknown partial match mode: `" + matchmode + "'.");
                      Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

                    } finally {
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                    }
                  }
                  throw ((ParsingError)(ParsingError.newParsingError(stream000.theStringReader()).fillInStackTrace()));
                }
              }
            }
          }
        }
      }
    }
  }

  public static Cons updatePropositionsFromQuery(QueryIterator query, Description description, Module module, Keyword updatemode, boolean recordjustificationsP) {
    if (query.queryIsTrueFalseP()) {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            stream000.nativeStream.println("ERROR: Can't yet assert/retract the result of a true/false query.");
            Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        throw ((PropositionError)(PropositionError.newPropositionError(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    { Description querydescription = query.queryDescription();
      boolean partialP = query.queryIsPartialP();
      QuerySolutionTable solutions = query.solutions;
      KeyValueMap mapping = KeyValueMap.newKeyValueMap();
      boolean dontcheckduplicatesP = false;
      Proposition proposition = null;
      Cons propositions = Stella.NIL;
      int tenthousands = 0;
      boolean terminatelineP = false;

      if (description != null) {
        if ((!(description.arity() == querydescription.arity())) &&
            ((!Description.variableArityP(description)) ||
             (querydescription.arity() < description.ioVariables.length()))) {
          { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

            { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                stream001.nativeStream.println("ERROR: Arity mismatch between query proposition and `" + description + "'.");
                Logic.helpSignalPropositionError(stream001, Logic.KWD_ERROR);

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
              }
            }
            throw ((PropositionError)(PropositionError.newPropositionError(stream001.theStringReader()).fillInStackTrace()));
          }
        }
      }
      else {
        description = querydescription;
      }
      if (module == null) {
        module = ((Module)(Stella.$MODULE$.get()));
      }
      proposition = description.proposition;
      if (Description.variableArityP(description) &&
          (querydescription.arity() > description.ioVariables.length())) {
        if (!((proposition.kind == Logic.KWD_FUNCTION) ||
            (proposition.kind == Logic.KWD_PREDICATE))) {
          { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

            { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                stream002.nativeStream.println("ERROR: Illegal variable arity description..");
                Logic.helpSignalPropositionError(stream002, Logic.KWD_ERROR);

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
              }
            }
            throw ((PropositionError)(PropositionError.newPropositionError(stream002.theStringReader()).fillInStackTrace()));
          }
        }
        proposition = Proposition.shallowCopyProposition(proposition);
        proposition.arguments = querydescription.ioVariables.copy();
        description = querydescription;
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, module);
          Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
          dontcheckduplicatesP = false;
          { QuerySolution solution = null;
            DictionaryIterator iter000 = ((DictionaryIterator)(solutions.allocateIterator()));
            int i = Stella.NULL_INTEGER;
            int iter001 = 0;

            for (;iter000.nextP(); iter001 = iter001 + 1) {
              solution = ((QuerySolution)(iter000.value));
              i = iter001;
              mapping.clear();
              if (Stella.integer_mod(i, 10000) == 9999) {
                if ((Stella.$TRACED_KEYWORDS$ != null) &&
                    Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_UPDATE_FROM_QUERY)) {
                  Stella.STANDARD_OUTPUT.nativeStream.print((tenthousands = tenthousands + 1));
                  OutputStream.flushOutput(Stella.STANDARD_OUTPUT);
                }
                OutputStream.flushOutput(Stella.STANDARD_OUTPUT);
              }
              else if (Stella.integer_mod(i, 1000) == 999) {
                if ((Stella.$TRACED_KEYWORDS$ != null) &&
                    Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_UPDATE_FROM_QUERY)) {
                  Stella.STANDARD_OUTPUT.nativeStream.print(".");
                  OutputStream.flushOutput(Stella.STANDARD_OUTPUT);
                }
                OutputStream.flushOutput(Stella.STANDARD_OUTPUT);
                terminatelineP = true;
              }
              { PatternVariable var = null;
                Vector vector000 = description.ioVariables;
                int index000 = 0;
                int length000 = vector000.length();
                Stella_Object binding = null;
                Vector vector001 = solution.bindings;
                int index001 = 0;
                int length001 = vector001.length();

                for (;(index000 < length000) &&
                          (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
                  var = ((PatternVariable)((vector000.theArray)[index000]));
                  binding = (vector001.theArray)[index001];
                  mapping.insertAt(var, binding);
                }
              }
              { Proposition prop = null;
                Cons iter002 = Proposition.inheritAsTopLevelProposition(proposition, mapping);

                for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                  prop = ((Proposition)(iter002.value));
                  KeyValueList.setDynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.FALSE_WRAPPER, Stella.FALSE_WRAPPER);
                  prop = Proposition.recursivelyFastenDownPropositions(prop, dontcheckduplicatesP);
                  { Keyword thisupdatemode = updatemode;
                    TruthValue truthvalue = solution.truthValue;
                    Justification justification = solution.justification;
                    boolean equivalenceP = prop.kind == Logic.KWD_EQUIVALENT;

                    if ((truthvalue == Logic.FALSE_TRUTH_VALUE) ||
                        (truthvalue == Logic.DEFAULT_FALSE_TRUTH_VALUE)) {
                      thisupdatemode = Logic.invertUpdateMode(thisupdatemode);
                    }
                    if ((truthvalue == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
                        (truthvalue == Logic.DEFAULT_FALSE_TRUTH_VALUE)) {
                      thisupdatemode = Logic.defaultifyUpdateMode(thisupdatemode);
                    }
                    if (equivalenceP) {
                      Proposition.updateEquivalenceProposition(prop, thisupdatemode);
                    }
                    Proposition.updatePropositionTruthValue(prop, thisupdatemode);
                    if (partialP) {
                      KeyValueList.setDynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, FloatWrapper.wrapFloat(solution.matchScore), Stella.NULL_FLOAT_WRAPPER);
                    }
                    Proposition.verifyArgumentTypesAndCount(prop);
                    if (recordjustificationsP &&
                        (justification != null)) {
                      { Justification self007 = Justification.newJustification();

                        self007.inferenceRule = Logic.KWD_ASSERT_FROM_QUERY;
                        self007.proposition = prop;
                        self007.antecedents = Cons.cons(justification, Stella.NIL);
                        self007.substitution = ((KeyValueMap)(mapping.copy()));
                        self007.truthValue = truthvalue;
                        { Justification resultjustification = self007;

                          Proposition.addForwardJustifications(prop, resultjustification);
                        }
                      }
                    }
                    propositions = Cons.cons(prop, propositions);
                  }
                }
              }
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
      if (terminatelineP) {
        if ((Stella.$TRACED_KEYWORDS$ != null) &&
            Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_UPDATE_FROM_QUERY)) {
          Stella.STANDARD_OUTPUT.nativeStream.println();
        }
      }
      return (propositions.reverse());
    }
  }

  public static void freeCachedQuery(QueryIterator query, Symbol queryid) {
    { List queries = ((List)(Logic.$INLINE_QUERY_CACHE$.lookup(queryid)));

      if (queries == null) {
        queries = List.newList();
        Logic.$INLINE_QUERY_CACHE$.insertAt(queryid, queries);
      }
      if (queries.length() < Logic.$MAX_CACHED_QUERIES_PER_ID$) {
        queries.push(query);
      }
    }
  }

  /** Just like <code>QUERY_ITERATORDconsify</code> but return a LIST instead.
   * @return List
   */
  public List listify() {
    { QueryIterator self = this;

      { List self000 = List.newList();

        self000.theConsList = self.consify();
        { List value000 = self000;

          return (value000);
        }
      }
    }
  }

  public static Cons consifyQuery(QueryIterator self) {
    return (self.consify());
  }

  /** Generate all solutions for the query self, and collect them into a cons list
   * of result tuples.  If <code>CSINGLETONSP_TRUE</code>, collect a list of atoms rather than a
   * list of lists for tuples of arity=1.
   * @return Cons
   */
  public Cons consify() {
    { QueryIterator self = this;

      { Object old$Queryiterator$000 = Logic.$QUERYITERATOR$.get();
        Object old$ReversepolarityP$000 = Logic.$REVERSEPOLARITYp$.get();

        try {
          Native.setSpecial(Logic.$QUERYITERATOR$, self);
          Native.setBooleanSpecial(Logic.$REVERSEPOLARITYp$, false);
          while (self.nextP()) {
          }

        } finally {
          Logic.$REVERSEPOLARITYp$.set(old$ReversepolarityP$000);
          Logic.$QUERYITERATOR$.set(old$Queryiterator$000);
        }
      }
      return (self.consifyCurrentSolutions());
    }
  }

  /** Collect the current solutions of <code>self</code> into a cons list
   * of result tuples.  If <code>CSINGLETONSP_TRUE</code>, collect a list of atoms rather than a
   * list of lists for tuples of arity=1.
   * @return Cons
   */
  public Cons consifyCurrentSolutions() {
    { QueryIterator self = this;

      { QuerySolutionTable solutions = self.solutions;
        Cons listifiedsolutions = Stella.NIL;
        int arity = self.queryDescription().arity();
        boolean atomicsingletonsP = ((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_ATOMIC_SINGLETONSp, Stella.FALSE_WRAPPER))).wrapperValue;

        { QuerySolution solution = null;
          DictionaryIterator iter000 = ((DictionaryIterator)(solutions.allocateIterator()));
          Cons collect000 = null;

          while (iter000.nextP()) {
            solution = ((QuerySolution)(iter000.value));
            if (collect000 == null) {
              {
                collect000 = Cons.cons(((atomicsingletonsP &&
                    (arity == 1)) ? (solution.bindings.theArray)[0] : solution.bindings.consify()), Stella.NIL);
                if (listifiedsolutions == Stella.NIL) {
                  listifiedsolutions = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(listifiedsolutions, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(((atomicsingletonsP &&
                    (arity == 1)) ? (solution.bindings.theArray)[0] : solution.bindings.consify()), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        return (listifiedsolutions);
      }
    }
  }

  public static BooleanWrapper runYesOrNoQueryP(QueryIterator query) {
    { TruthValue truthvalue = Logic.callAsk(query);

      if ((truthvalue == Logic.TRUE_TRUTH_VALUE) ||
          (truthvalue == Logic.DEFAULT_TRUE_TRUTH_VALUE)) {
        return (Stella.TRUE_WRAPPER);
      }
      else if ((truthvalue == Logic.FALSE_TRUTH_VALUE) ||
          (truthvalue == Logic.DEFAULT_FALSE_TRUTH_VALUE)) {
        return (Stella.FALSE_WRAPPER);
      }
      else {
        return (null);
      }
    }
  }

  public static void processQueryOptions(QueryIterator query, Stella_Object options) {
    { PropertyList theoptions = Stella_Object.vetOptions(options, null);
      PropertyList deferredoptions = null;

      query.options = theoptions;
      { Stella_Object key = null;
        Stella_Object value = null;
        Cons iter000 = theoptions.thePlist;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
          key = iter000.value;
          value = iter000.rest.value;
          { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(key));

            if (testValue000 == Logic.KWD_TIMEOUT) {
              { Surrogate testValue001 = Stella_Object.safePrimaryType(value);

                if (Surrogate.subtypeOfIntegerP(testValue001)) {
                  { IntegerWrapper value000 = ((IntegerWrapper)(value));

                    query.allottedTime = value000.numberWrapperToFloat();
                    theoptions.insertAt(key, FloatWrapper.wrapFloat(query.allottedTime));
                  }
                }
                else if (Surrogate.subtypeOfFloatP(testValue001)) {
                  { FloatWrapper value000 = ((FloatWrapper)(value));

                    query.allottedTime = value000.wrapperValue;
                    theoptions.insertAt(key, FloatWrapper.wrapFloat(query.allottedTime));
                  }
                }
                else {
                  { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                    { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                      try {
                        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                        stream000.nativeStream.println("PARSING ERROR: Illegal :TIMEOUT value: `" + value + "'.");
                        Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

                      } finally {
                        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                      }
                    }
                    throw ((ParsingError)(ParsingError.newParsingError(stream000.theStringReader()).fillInStackTrace()));
                  }
                }
              }
              query.timeoutP = false;
            }
            else if (testValue000 == Logic.KWD_MOVEOUT) {
              { Surrogate testValue002 = Stella_Object.safePrimaryType(value);

                if (Surrogate.subtypeOfIntegerP(testValue002)) {
                  { IntegerWrapper value000 = ((IntegerWrapper)(value));

                    query.allottedClockTicks = Native.floor(value000.wrapperValue);
                    theoptions.insertAt(key, IntegerWrapper.wrapInteger(Native.floor(value000.wrapperValue)));
                  }
                }
                else if (Surrogate.subtypeOfFloatP(testValue002)) {
                  { FloatWrapper value000 = ((FloatWrapper)(value));

                    query.allottedClockTicks = Native.floor(value000.wrapperValue);
                    theoptions.insertAt(key, IntegerWrapper.wrapInteger(Native.floor(value000.wrapperValue)));
                  }
                }
                else {
                  { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                    { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                      try {
                        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                        stream001.nativeStream.println("PARSING ERROR: Illegal :MOVEOUT value: `" + value + "'.");
                        Logic.helpSignalPropositionError(stream001, Logic.KWD_ERROR);

                      } finally {
                        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                      }
                    }
                    throw ((ParsingError)(ParsingError.newParsingError(stream001.theStringReader()).fillInStackTrace()));
                  }
                }
              }
            }
            else if (testValue000 == Logic.KWD_MAXIMUM_DEPTH) {
              { Surrogate testValue003 = Stella_Object.safePrimaryType(value);

                if (Surrogate.subtypeOfIntegerP(testValue003)) {
                  { IntegerWrapper value000 = ((IntegerWrapper)(value));

                    theoptions.insertAt(key, IntegerWrapper.wrapInteger(Native.floor(value000.wrapperValue)));
                    query.maximumDepth = ((IntegerWrapper)(Logic.lookupQueryOption(query, Logic.KWD_MAXIMUM_DEPTH))).wrapperValue;
                  }
                }
                else if (Surrogate.subtypeOfFloatP(testValue003)) {
                  { FloatWrapper value000 = ((FloatWrapper)(value));

                    theoptions.insertAt(key, IntegerWrapper.wrapInteger(Native.floor(value000.wrapperValue)));
                    query.maximumDepth = ((IntegerWrapper)(Logic.lookupQueryOption(query, Logic.KWD_MAXIMUM_DEPTH))).wrapperValue;
                  }
                }
                else {
                  { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                    { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

                      try {
                        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                        stream002.nativeStream.println("PARSING ERROR: Illegal :MAXIMUM-DEPTH value: `" + value + "'.");
                        Logic.helpSignalPropositionError(stream002, Logic.KWD_ERROR);

                      } finally {
                        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
                      }
                    }
                    throw ((ParsingError)(ParsingError.newParsingError(stream002.theStringReader()).fillInStackTrace()));
                  }
                }
              }
            }
            else if (testValue000 == Logic.KWD_INFERENCE_LEVEL) {
              { Surrogate testValue004 = Stella_Object.safePrimaryType(value);

                if (Surrogate.subtypeOfP(testValue004, Logic.SGT_STELLA_GENERALIZED_SYMBOL)) {
                  { GeneralizedSymbol value000 = ((GeneralizedSymbol)(value));

                    theoptions.insertAt(key, Stella.string_keywordify(Stella_Object.coerceToString(value000)));
                    query.inferenceLevel = Logic.getInferenceLevel(((Keyword)(Logic.lookupQueryOption(query, Logic.KWD_INFERENCE_LEVEL))));
                  }
                }
                else if (Surrogate.subtypeOfStringP(testValue004)) {
                  { StringWrapper value000 = ((StringWrapper)(value));

                    theoptions.insertAt(key, Stella.string_keywordify(Stella_Object.coerceToString(value000)));
                    query.inferenceLevel = Logic.getInferenceLevel(((Keyword)(Logic.lookupQueryOption(query, Logic.KWD_INFERENCE_LEVEL))));
                  }
                }
                else {
                  { OutputStringStream stream003 = OutputStringStream.newOutputStringStream();

                    { Object old$PrintreadablyP$003 = Stella.$PRINTREADABLYp$.get();

                      try {
                        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                        stream003.nativeStream.println("PARSING ERROR: Illegal :INFERENCE-LEVEL value: `" + value + "'.");
                        Logic.helpSignalPropositionError(stream003, Logic.KWD_ERROR);

                      } finally {
                        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$003);
                      }
                    }
                    throw ((ParsingError)(ParsingError.newParsingError(stream003.theStringReader()).fillInStackTrace()));
                  }
                }
              }
            }
            else if (testValue000 == Logic.KWD_THREE_VALUEDp) {
              value = Stella_Object.coerceToBoolean(value);
              theoptions.insertAt(key, value);
            }
            else if (testValue000 == Logic.KWD_FOUR_VALUEDp) {
              value = Stella_Object.coerceToBoolean(value);
              theoptions.insertAt(key, value);
            }
            else if (testValue000 == Logic.KWD_ITERATIVE_DEEPENINGp) {
              value = Stella_Object.coerceToBoolean(value);
              theoptions.insertAt(key, value);
              if (Stella_Object.eqlP(value, Stella.TRUE_WRAPPER)) {
                KeyValueList.setDynamicSlotValue(query.dynamicSlots, Logic.SYM_LOGIC_ITERATIVE_DEEPENINGp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
              }
            }
            else if ((testValue000 == Logic.KWD_SINGLETONSp) ||
                (testValue000 == Logic.KWD_ATOMIC_SINGLETONSp)) {
              theoptions.insertAt(key, Stella_Object.coerceToBoolean(value));
              KeyValueList.setDynamicSlotValue(query.dynamicSlots, Logic.SYM_LOGIC_ATOMIC_SINGLETONSp, (Stella_Object.eqlP(value, Stella.TRUE_WRAPPER) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.FALSE_WRAPPER);
            }
            else if (testValue000 == Logic.KWD_DONT_OPTIMIZEp) {
              value = Stella_Object.coerceToBoolean(value);
              theoptions.insertAt(key, value);
            }
            else if (testValue000 == Logic.KWD_ALL_PROOFSp) {
              value = Stella_Object.coerceToBoolean(value);
              theoptions.insertAt(key, value);
            }
            else if (testValue000 == Logic.KWD_CHECK_VARIABLESp) {
              value = Stella_Object.coerceToBoolean(value);
              theoptions.insertAt(key, value);
            }
            else if (testValue000 == Logic.KWD_HOW_MANY) {
              { Surrogate testValue005 = Stella_Object.safePrimaryType(value);

                if (Surrogate.subtypeOfIntegerP(testValue005)) {
                  { IntegerWrapper value000 = ((IntegerWrapper)(value));

                  }
                }
                else if (Surrogate.subtypeOfP(testValue005, Logic.SGT_STELLA_GENERALIZED_SYMBOL)) {
                  { GeneralizedSymbol value000 = ((GeneralizedSymbol)(value));

                    if (Stella.stringEqlP(value000.symbolName, "ALL")) {
                      theoptions.insertAt(key, IntegerWrapper.wrapInteger(Stella.NULL_INTEGER));
                    }
                    else {
                      { OutputStringStream stream004 = OutputStringStream.newOutputStringStream();

                        { Object old$PrintreadablyP$004 = Stella.$PRINTREADABLYp$.get();

                          try {
                            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                            stream004.nativeStream.println("PARSING ERROR: Illegal :HOW-MANY value: `" + value000 + "'.");
                            Logic.helpSignalPropositionError(stream004, Logic.KWD_ERROR);

                          } finally {
                            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$004);
                          }
                        }
                        throw ((ParsingError)(ParsingError.newParsingError(stream004.theStringReader()).fillInStackTrace()));
                      }
                    }
                  }
                }
                else {
                  { OutputStringStream stream005 = OutputStringStream.newOutputStringStream();

                    { Object old$PrintreadablyP$005 = Stella.$PRINTREADABLYp$.get();

                      try {
                        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                        stream005.nativeStream.println("PARSING ERROR: Illegal :HOW-MANY value: `" + value + "'.");
                        Logic.helpSignalPropositionError(stream005, Logic.KWD_ERROR);

                      } finally {
                        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$005);
                      }
                    }
                    throw ((ParsingError)(ParsingError.newParsingError(stream005.theStringReader()).fillInStackTrace()));
                  }
                }
              }
            }
            else if (testValue000 == Logic.KWD_SORT_BY) {
              if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(value), Logic.SGT_STELLA_GENERALIZED_SYMBOL)) {
                { GeneralizedSymbol value000 = ((GeneralizedSymbol)(value));

                  if (Stella.stringEqlP(value000.symbolName, "SCORE")) {
                    theoptions.insertAt(key, Logic.KWD_SCORE);
                  }
                  else if (Stella.stringEqlP(value000.symbolName, "VALUES")) {
                    theoptions.insertAt(key, Logic.KWD_VALUES);
                  }
                  else if (Stella.stringEqlP(value000.symbolName, "VALUES-DESCENDING")) {
                    theoptions.insertAt(key, Logic.KWD_VALUES_DESCENDING);
                  }
                  else if (Stella.stringEqlP(value000.symbolName, "VALUES-ASCENDING")) {
                    theoptions.insertAt(key, Logic.KWD_VALUES_ASCENDING);
                  }
                  else {
                    { OutputStringStream stream006 = OutputStringStream.newOutputStringStream();

                      { Object old$PrintreadablyP$006 = Stella.$PRINTREADABLYp$.get();

                        try {
                          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                          stream006.nativeStream.println("PARSING ERROR: Illegal :SORT-BY value: `" + value000 + "'.");
                          Logic.helpSignalPropositionError(stream006, Logic.KWD_ERROR);

                        } finally {
                          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$006);
                        }
                      }
                      throw ((ParsingError)(ParsingError.newParsingError(stream006.theStringReader()).fillInStackTrace()));
                    }
                  }
                }
              }
              else {
                { OutputStringStream stream007 = OutputStringStream.newOutputStringStream();

                  { Object old$PrintreadablyP$007 = Stella.$PRINTREADABLYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      stream007.nativeStream.println("PARSING ERROR: Illegal :SORT-BY value: `" + value + "'.");
                      Logic.helpSignalPropositionError(stream007, Logic.KWD_ERROR);

                    } finally {
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$007);
                    }
                  }
                  throw ((ParsingError)(ParsingError.newParsingError(stream007.theStringReader()).fillInStackTrace()));
                }
              }
            }
            else if (testValue000 == Logic.KWD_FORMAT) {
              theoptions.removeAt(key);
              { Surrogate testValue006 = Stella_Object.safePrimaryType(value);

                if (Surrogate.subtypeOfP(testValue006, Logic.SGT_STELLA_GENERALIZED_SYMBOL)) {
                  { GeneralizedSymbol value000 = ((GeneralizedSymbol)(value));

                    if (Stella.stringEqlP(value000.symbolName, "HORIZONTAL")) {
                      theoptions.insertAt(key, Logic.KWD_HORIZONTAL);
                    }
                    else if (Stella.stringEqlP(value000.symbolName, "VERTICAL")) {
                      theoptions.insertAt(key, Logic.KWD_VERTICAL);
                    }
                    else if (Stella.stringEqlP(value000.symbolName, "TSV")) {
                      theoptions.insertAt(key, Logic.KWD_TSV);
                    }
                    else if (Stella.stringEqlP(value000.symbolName, "LIST") ||
                        Stella.stringEqlP(value000.symbolName, "CONS")) {
                      theoptions.insertAt(key, Logic.KWD_LIST);
                    }
                  }
                }
                else if (testValue006 == Logic.SGT_STELLA_CONS) {
                  { Cons value000 = ((Cons)(value));

                    theoptions.insertAt(key, value000);
                  }
                }
                else if (Surrogate.subtypeOfStringP(testValue006)) {
                  { StringWrapper value000 = ((StringWrapper)(value));

                    theoptions.insertAt(key, value000);
                  }
                }
                else {
                }
              }
              if (!(theoptions.lookup(key) != null)) {
                { OutputStringStream stream008 = OutputStringStream.newOutputStringStream();

                  { Object old$PrintreadablyP$008 = Stella.$PRINTREADABLYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      stream008.nativeStream.println("PARSING ERROR: Illegal :FORMAT value: `" + value + "'.");
                      Logic.helpSignalPropositionError(stream008, Logic.KWD_ERROR);

                    } finally {
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$008);
                    }
                  }
                  throw ((ParsingError)(ParsingError.newParsingError(stream008.theStringReader()).fillInStackTrace()));
                }
              }
            }
            else if (testValue000 == Logic.KWD_READABLE_VALUESp) {
              theoptions.insertAt(key, Stella_Object.coerceToBoolean(value));
            }
            else if (testValue000 == Logic.KWD_OUTPUT_FILE) {
              theoptions.insertAt(key, StringWrapper.wrapString(Stella_Object.coerceToString(value)));
            }
            else if (testValue000 == Logic.KWD_IF_EXISTS) {
              theoptions.removeAt(key);
              if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(value), Logic.SGT_STELLA_GENERALIZED_SYMBOL)) {
                { GeneralizedSymbol value000 = ((GeneralizedSymbol)(value));

                  if (Stella.stringEqlP(value000.symbolName, "APPEND")) {
                    theoptions.insertAt(key, Logic.KWD_APPEND);
                  }
                  else if (Stella.stringEqlP(value000.symbolName, "SUPERSEDE")) {
                    theoptions.insertAt(key, Logic.KWD_SUPERSEDE);
                  }
                }
              }
              else {
              }
              if (!(theoptions.lookup(key) != null)) {
                { OutputStringStream stream009 = OutputStringStream.newOutputStringStream();

                  { Object old$PrintreadablyP$009 = Stella.$PRINTREADABLYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      stream009.nativeStream.println("PARSING ERROR: Illegal :IF-EXISTS value: `" + value + "'.");
                      Logic.helpSignalPropositionError(stream009, Logic.KWD_ERROR);

                    } finally {
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$009);
                    }
                  }
                  throw ((ParsingError)(ParsingError.newParsingError(stream009.theStringReader()).fillInStackTrace()));
                }
              }
            }
            else if (testValue000 == Logic.KWD_MATCH_MODE) {
              { Surrogate testValue007 = Stella_Object.safePrimaryType(value);

                if (Surrogate.subtypeOfP(testValue007, Logic.SGT_STELLA_GENERALIZED_SYMBOL)) {
                  { GeneralizedSymbol value000 = ((GeneralizedSymbol)(value));

                    if (Stella_Object.stringP(value000)) {
                      theoptions.insertAt(key, value000.keywordify());
                    }
                    else {
                      theoptions.insertAt(key, value000);
                    }
                  }
                }
                else if (Surrogate.subtypeOfStringP(testValue007)) {
                  { StringWrapper value000 = ((StringWrapper)(value));

                    if (Stella_Object.stringP(value000)) {
                      theoptions.insertAt(key, value000.keywordify());
                    }
                    else {
                      theoptions.insertAt(key, value000);
                    }
                  }
                }
                else {
                  { OutputStringStream stream010 = OutputStringStream.newOutputStringStream();

                    { Object old$PrintreadablyP$010 = Stella.$PRINTREADABLYp$.get();

                      try {
                        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                        stream010.nativeStream.println("PARSING ERROR: Illegal :MATCH-MODE value: `" + value + "'.");
                        Logic.helpSignalPropositionError(stream010, Logic.KWD_ERROR);

                      } finally {
                        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$010);
                      }
                    }
                    throw ((ParsingError)(ParsingError.newParsingError(stream010.theStringReader()).fillInStackTrace()));
                  }
                }
              }
            }
            else if (testValue000 == Logic.KWD_MINIMUM_SCORE) {
              { Surrogate testValue008 = Stella_Object.safePrimaryType(value);

                if (Surrogate.subtypeOfIntegerP(testValue008)) {
                  { IntegerWrapper value000 = ((IntegerWrapper)(value));

                    theoptions.insertAt(key, FloatWrapper.wrapFloat(((double)(value000.wrapperValue))));
                  }
                }
                else if (Surrogate.subtypeOfFloatP(testValue008)) {
                  { FloatWrapper value000 = ((FloatWrapper)(value));

                  }
                }
                else {
                  { OutputStringStream stream011 = OutputStringStream.newOutputStringStream();

                    { Object old$PrintreadablyP$011 = Stella.$PRINTREADABLYp$.get();

                      try {
                        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                        stream011.nativeStream.println("PARSING ERROR: Illegal :MINIMUM-SCORE value: `" + value + "'.");
                        Logic.helpSignalPropositionError(stream011, Logic.KWD_ERROR);

                      } finally {
                        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$011);
                      }
                    }
                    throw ((ParsingError)(ParsingError.newParsingError(stream011.theStringReader()).fillInStackTrace()));
                  }
                }
              }
            }
            else if (testValue000 == Logic.KWD_MAXIMIZE_SCOREp) {
              theoptions.insertAt(key, Stella_Object.coerceToBoolean(value));
            }
            else if (testValue000 == Logic.KWD_MAXIMUM_UNKNOWNS) {
              { Surrogate testValue009 = Stella_Object.safePrimaryType(value);

                if (Surrogate.subtypeOfIntegerP(testValue009)) {
                  { IntegerWrapper value000 = ((IntegerWrapper)(value));

                  }
                }
                else if (Surrogate.subtypeOfFloatP(testValue009)) {
                  { FloatWrapper value000 = ((FloatWrapper)(value));

                    theoptions.insertAt(key, IntegerWrapper.wrapInteger(((int)(value000.wrapperValue))));
                  }
                }
                else {
                  { OutputStringStream stream012 = OutputStringStream.newOutputStringStream();

                    { Object old$PrintreadablyP$012 = Stella.$PRINTREADABLYp$.get();

                      try {
                        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                        stream012.nativeStream.println("PARSING ERROR: Illegal :MAXIMUM-UNKNOWNS value: `" + value + "'.");
                        Logic.helpSignalPropositionError(stream012, Logic.KWD_ERROR);

                      } finally {
                        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$012);
                      }
                    }
                    throw ((ParsingError)(ParsingError.newParsingError(stream012.theStringReader()).fillInStackTrace()));
                  }
                }
              }
            }
            else {
              if (deferredoptions == null) {
                deferredoptions = PropertyList.newPropertyList();
              }
              deferredoptions.insertAt(key, value);
            }
          }
        }
      }
      if (deferredoptions != null) {
        theoptions.insertAt(Logic.KWD_DEFERRED_OPTIONS, deferredoptions);
      }
    }
  }

  public void reset() {
    { QueryIterator self = this;

      if ((Stella.$TRACED_KEYWORDS$ != null) &&
          Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_CACHES)) {
        Stella.STANDARD_OUTPUT.nativeStream.println("------------- RESET -------------");
      }
      { ControlFrame initialframe = self.baseControlFrame;

        if (initialframe.down != null) {
          ControlFrame.popFramesUpTo(initialframe.down);
        }
        { PatternRecord patternrecord = initialframe.patternRecord;

          self.currentPatternRecord = patternrecord;
          { Object old$Context$000 = Stella.$CONTEXT$.get();
            Object old$Queryiterator$000 = Logic.$QUERYITERATOR$.get();

            try {
              Native.setSpecial(Stella.$CONTEXT$, Logic.getQueryContext());
              Native.setSpecial(Logic.$QUERYITERATOR$, self);
              PatternRecord.unbindVariablesBeginningAt(patternrecord, 0);
              if (((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_INITIAL_BINDINGS, null))) != null) {
                { PatternVariable arg = null;
                  Vector vector000 = self.externalVariables;
                  int index000 = 0;
                  int length000 = vector000.length();
                  Stella_Object value = null;
                  Vector vector001 = ((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_INITIAL_BINDINGS, null)));
                  int index001 = 0;
                  int length001 = vector001.length();

                  for (;(index000 < length000) &&
                            (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
                    arg = ((PatternVariable)((vector000.theArray)[index000]));
                    value = (vector001.theArray)[index001];
                    if (value != null) {
                      if (!(Logic.bindArgumentToValueP(arg, value, false))) {
                        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                          stream000.nativeStream.print("reset: binding of `" + arg + "' to `" + value + "' failed.");
                          throw ((FailException)(FailException.newFailException(stream000.theStringReader()).fillInStackTrace()));
                        }
                      }
                    }
                  }
                }
              }
              ControlFrame.overlayWithPatternFrameP(initialframe, patternrecord.description, patternrecord.externalArguments);

            } finally {
              Logic.$QUERYITERATOR$.set(old$Queryiterator$000);
              Stella.$CONTEXT$.set(old$Context$000);
            }
          }
        }
        self.exhaustedP = false;
        self.timeoutP = false;
        self.depthCutoffsP = false;
        self.solutions.clear();
        initialframe.truthValue = null;
        self.augmentedGoalCacheP = false;
        self.triggeredDepthCutoffP = false;
      }
    }
  }

  public static boolean tryToDefeatLastAnswerP(QueryIterator self, Object [] MV_returnarray) {
    { QueryIterator negatedquery = (self.queryIsTrueFalseP() ? self : ((QueryIterator)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_AUXILIARY_QUERY, null))));
      Context querycontext = self.queryContext;
      boolean strictpositiveanswerP = false;
      boolean strictnegativeanswerP = false;
      boolean defeatedP = false;
      Justification negativejustification = null;

      if (negatedquery == null) {
        negatedquery = Description.createQueryIterator(self.queryDescription(), ((QuerySolution)(self.value)).bindings);
        negatedquery.debugIdSetter("negatedQuery");
        negatedquery.queryContext = querycontext;
      }
      else {
        if (self == ((QueryIterator)(KeyValueList.dynamicSlotValue(negatedquery.dynamicSlots, Logic.SYM_LOGIC_AUXILIARY_QUERY, null)))) {
          { boolean _return_temp = false;

            MV_returnarray[0] = null;
            return (_return_temp);
          }
        }
        KeyValueList.setDynamicSlotValue(negatedquery.dynamicSlots, Logic.SYM_LOGIC_INITIAL_BINDINGS, ((QuerySolution)(self.value)).bindings, null);
      }
      KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_AUXILIARY_QUERY, negatedquery, null);
      KeyValueList.setDynamicSlotValue(negatedquery.dynamicSlots, Logic.SYM_LOGIC_AUXILIARY_QUERY, self, null);
      negatedquery.baseControlFrame.reversePolarityP = true;
      negatedquery.reset();
      if ((Stella.$TRACED_KEYWORDS$ != null) &&
          Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_TREE)) {
        Stella.STANDARD_OUTPUT.nativeStream.println("Looking for conflicting default conclusion:");
      }
      if (negatedquery.nextP()) {
        negatedquery.reset();
        { Object old$DontusedefaultknowledgeP$000 = Logic.$DONTUSEDEFAULTKNOWLEDGEp$.get();

          try {
            Native.setBooleanSpecial(Logic.$DONTUSEDEFAULTKNOWLEDGEp$, true);
            if ((Stella.$TRACED_KEYWORDS$ != null) &&
                Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_TREE)) {
              Stella.STANDARD_OUTPUT.nativeStream.println("Looking for conflicting strict conclusion:");
            }
            strictnegativeanswerP = negatedquery.nextP();
            negativejustification = ((Justification)(KeyValueList.dynamicSlotValue(negatedquery.baseControlFrame.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null)));

          } finally {
            Logic.$DONTUSEDEFAULTKNOWLEDGEp$.set(old$DontusedefaultknowledgeP$000);
          }
        }
        negatedquery.baseControlFrame.reversePolarityP = false;
        negatedquery.reset();
        { Object old$DontusedefaultknowledgeP$001 = Logic.$DONTUSEDEFAULTKNOWLEDGEp$.get();

          try {
            Native.setBooleanSpecial(Logic.$DONTUSEDEFAULTKNOWLEDGEp$, true);
            if ((Stella.$TRACED_KEYWORDS$ != null) &&
                Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_TREE)) {
              Stella.STANDARD_OUTPUT.nativeStream.println("Looking for strict conclusion:");
            }
            strictpositiveanswerP = negatedquery.nextP();

          } finally {
            Logic.$DONTUSEDEFAULTKNOWLEDGEp$.set(old$DontusedefaultknowledgeP$001);
          }
        }
        if (strictpositiveanswerP) {
          if (strictnegativeanswerP) {
            { Object old$Queryiterator$000 = Logic.$QUERYITERATOR$.get();

              try {
                Native.setSpecial(Logic.$QUERYITERATOR$, negatedquery);
                defeatedP = true;

              } finally {
                Logic.$QUERYITERATOR$.set(old$Queryiterator$000);
              }
            }
          }
          else {
            defeatedP = false;
          }
        }
        else {
          defeatedP = true;
        }
      }
      KeyValueList.setDynamicSlotValue(negatedquery.dynamicSlots, Logic.SYM_LOGIC_AUXILIARY_QUERY, null, null);
      { boolean _return_temp = defeatedP;

        MV_returnarray[0] = negativejustification;
        return (_return_temp);
      }
    }
  }

  public boolean nextP() {
    { QueryIterator self = this;

      if (self.exhaustedP) {
        return (false);
      }
      { ControlFrame baseframe = self.baseControlFrame;

        { QuerySolution self000 = QuerySolution.newQuerySolution();

          self000.bindings = Vector.newVector(self.externalVariables.length());
          self000.truthValue = Logic.UNKNOWN_TRUTH_VALUE;
          { QuerySolution solution = self000;
            QuerySolution duplicate = null;

            self.value = solution;
            if (self.firstIterationP) {
              self.firstIterationP = false;
              { PropertyList skippedoptions = ((PropertyList)(Logic.lookupQueryOption(self, Logic.KWD_DEFERRED_OPTIONS)));

                if ((skippedoptions != null) &&
                    skippedoptions.nonEmptyP()) {
                  { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                    { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                      try {
                        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                        stream000.nativeStream.println("PARSING ERROR: Illegal query option(s): `" + skippedoptions + "'.");
                        Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

                      } finally {
                        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                      }
                    }
                    throw ((ParsingError)(ParsingError.newParsingError(stream000.theStringReader()).fillInStackTrace()));
                  }
                }
              }
            }
            for (;;) {
              { Object old$Context$000 = Stella.$CONTEXT$.get();
                Object old$Module$000 = Stella.$MODULE$.get();

                try {
                  Native.setSpecial(Stella.$CONTEXT$, Logic.getQueryContext());
                  Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
                  loop001 : for (;;) {
                    solution.bindings.clear();
                    solution.truthValue = Logic.UNKNOWN_TRUTH_VALUE;
                    solution.justification = null;
                    solution.matchScore = Stella.NULL_FLOAT;
                    if (!QueryIterator.executeBackwardChainingProofP(self)) {
                      break loop001;
                    }
                    { PatternVariable ev = null;
                      Vector vector000 = self.externalVariables;
                      int index000 = 0;
                      int length000 = vector000.length();
                      int i = Stella.NULL_INTEGER;
                      int iter000 = 0;

                      for (;index000 < length000; index000 = index000 + 1, iter000 = iter000 + 1) {
                        ev = ((PatternVariable)((vector000.theArray)[index000]));
                        i = iter000;
                        (solution.bindings.theArray)[i] = (Logic.valueOf((((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord.variableBindings.theArray)[(ev.boundToOffset)]));
                      }
                    }
                    self.foundAtLeastOneSolutionP = true;
                    { TruthValue temp000 = baseframe.truthValue;

                      solution.truthValue = ((temp000 != null) ? temp000 : Logic.UNKNOWN_TRUTH_VALUE);
                    }
                    solution.justification = ((Justification)(KeyValueList.dynamicSlotValue(baseframe.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null)));
                    if ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
                        (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) {
                      solution.matchScore = (((baseframe.partialMatchFrame != null) &&
                          ((baseframe.partialMatchFrame.positiveScore != Stella.NULL_FLOAT) ||
                           (baseframe.partialMatchFrame.negativeScore != Stella.NULL_FLOAT))) ? baseframe.partialMatchFrame.positiveScore : ((FloatWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue);
                    }
                    duplicate = ((QuerySolution)(self.solutions.lookup(solution.bindings)));
                    if ((duplicate != null) &&
                        ((!((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
                        (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null))) ||
                         (solution.matchScore <= duplicate.matchScore))) {
                      continue loop001;
                    }
                    if (((baseframe.truthValue == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
                        (baseframe.truthValue == Logic.DEFAULT_FALSE_TRUTH_VALUE)) &&
                        QueryIterator.tryToDefeatLastAnswerP(self, new Object[1])) {
                      continue loop001;
                    }
                    if (Logic.testQueryOptionP(((QueryIterator)(Logic.$QUERYITERATOR$.get())), Logic.KWD_FOUR_VALUEDp)) {
                      { boolean answer = false;
                        Justification negativeJustification = null;

                        { Object [] caller_MV_returnarray = new Object[1];

                          answer = QueryIterator.tryToDefeatLastAnswerP(self, caller_MV_returnarray);
                          negativeJustification = ((Justification)(caller_MV_returnarray[0]));
                        }
                        if (answer) {
                          if (self.queryIsTrueFalseP()) {
                            {
                              solution.truthValue = Logic.INCONSISTENT_TRUTH_VALUE;
                              if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue()) {
                                solution.justification = Proposition.createClashJustification(baseframe.proposition, Cons.consList(Cons.cons(solution.justification, Cons.cons(negativeJustification, Stella.NIL))), Logic.KWD_BACKWARD);
                              }
                              baseframe.truthValue = Logic.INCONSISTENT_TRUTH_VALUE;
                              KeyValueList.setDynamicSlotValue(baseframe.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, solution.justification, null);
                              self.solutions.insertAt(solution.bindings, solution);
                              self.exhaustedP = false;
                              self.value = solution;
                              return (true);
                            }
                          }
                          else {
                            continue loop001;
                          }
                        }
                      }
                    }
                    KeyValueList.setDynamicSlotValue(baseframe.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, solution.justification, null);
                    self.solutions.insertAt(solution.bindings, solution);
                    self.value = solution;
                    self.exhaustedP = false;
                    return (true);
                  }

                } finally {
                  Stella.$MODULE$.set(old$Module$000);
                  Stella.$CONTEXT$.set(old$Context$000);
                }
              }
              if (self.timeoutP) {
                return (false);
              }
              else if (self.augmentedGoalCacheP) {
                self.reset();
              }
              else if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_ITERATIVE_DEEPENINGp, Stella.FALSE_WRAPPER))).wrapperValue &&
                  (self.triggeredDepthCutoffP &&
                   (self.currentDepthCutoff < self.maximumDepth))) {
                self.currentDepthCutoff = self.currentDepthCutoff + 1;
                self.reset();
              }
              else {
                if (self.failedToFindDuplicateSubgoalP &&
                    (!self.foundAtLeastOneSolutionP)) {
                  {
                    Stella.STANDARD_OUTPUT.nativeStream.println("Failed to find a duplicate subgoal on one or more occurrences when");
                    Stella.STANDARD_OUTPUT.nativeStream.println("   the depth cutoff " + self.currentDepthCutoff + " was exceeded.  Consider increasing the cutoff");
                    Stella.STANDARD_OUTPUT.nativeStream.println("   (by setting the variable *maximum-backtracking-depth*)");
                    Stella.STANDARD_OUTPUT.nativeStream.println("   and trying again.");
                  }
;
                }
                self.exhaustedP = true;
                return (false);
              }
            }
          }
        }
      }
    }
  }

  public boolean querySucceededP() {
    { QueryIterator self = this;

      return (self.solutions.nonEmptyP());
    }
  }

  public boolean queryIsPartialP() {
    { QueryIterator self = this;

      if (self.partialMatchStrategy != null) {
        return (true);
      }
      { Stella_Object matchmode = Logic.lookupQueryOption(self, Logic.KWD_MATCH_MODE);

        return ((matchmode != null) &&
            (!(matchmode == Logic.KWD_STRICT)));
      }
    }
  }

  public boolean queryIsTrueFalseP() {
    { QueryIterator self = this;

      if (self.externalVariables.emptyP()) {
        return (true);
      }
      { PatternRecord patternrecord = self.baseControlFrame.patternRecord;

        { boolean alwaysP000 = true;

          { Stella_Object ignoredArg = null;
            Vector vector000 = patternrecord.externalArguments;
            int index000 = 0;
            int length000 = vector000.length();
            BooleanWrapper boundP = null;
            BooleanVector vector001 = patternrecord.booleanVector;
            int index001 = 0;
            int length001 = vector001.length();

            loop000 : for (;(index000 < length000) &&
                      (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
              ignoredArg = (vector000.theArray)[index000];
              boundP = ((BooleanWrapper)((vector001.theArray)[index001]));
              if (!BooleanWrapper.coerceWrappedBooleanToBoolean(boundP)) {
                alwaysP000 = false;
                break loop000;
              }
            }
          }
          { boolean value000 = alwaysP000;

            return (value000);
          }
        }
      }
    }
  }

  public Description queryDescription() {
    { QueryIterator self = this;

      return (self.baseControlFrame.patternRecord.description);
    }
  }

  public Proposition queryProposition() {
    { QueryIterator self = this;

      return (self.baseControlFrame.proposition);
    }
  }

  public static QueryIterator initializeQueryIterator(QueryIterator queryiterator, Description description, Vector outsidebindings) {
    { ControlFrame basecontrolframe = ControlFrame.newControlFrame();
      Vector externalvariables = null;

      { Object old$Queryiterator$000 = Logic.$QUERYITERATOR$.get();
        Object old$Evaluationmode$000 = Logic.$EVALUATIONMODE$.get();

        try {
          Native.setSpecial(Logic.$QUERYITERATOR$, queryiterator);
          Native.setSpecial(Logic.$EVALUATIONMODE$, Logic.KWD_DESCRIPTION);
          if (Logic.testQueryOptionP(queryiterator, Logic.KWD_DONT_OPTIMIZEp)) {
            KeyValueList.setDynamicSlotValue(description.dynamicSlots, Logic.SYM_LOGIC_DONT_OPTIMIZEp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
            KeyValueList.setDynamicSlotValue(description.proposition.dynamicSlots, Logic.SYM_LOGIC_DONT_OPTIMIZEp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
          }
          queryiterator.queryContext = ((Context)(Stella.$CONTEXT$.get()));
          queryiterator.baseControlFrame = basecontrolframe;
          queryiterator.currentControlFrame = basecontrolframe;
          Logic.$CONTROL_FRAME_ID_COUNTER$ = 0;
          queryiterator.debugIdSetter(null);
          basecontrolframe.proposition = description.proposition;
          basecontrolframe.up = null;
          KeyValueList.setDynamicSlotValue(basecontrolframe.dynamicSlots, Logic.SYM_LOGIC_GOAL_CACHE, null, null);
          basecontrolframe.goalBindings = null;
          externalvariables = ControlFrame.allocateCollectionVariables(basecontrolframe, description);
          { Object old$Context$000 = Stella.$CONTEXT$.get();
            Object old$Module$000 = Stella.$MODULE$.get();

            try {
              Native.setSpecial(Stella.$CONTEXT$, Logic.getQueryContext());
              Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
              if (outsidebindings != null) {
                KeyValueList.setDynamicSlotValue(queryiterator.dynamicSlots, Logic.SYM_LOGIC_INITIAL_BINDINGS, outsidebindings, null);
                if (outsidebindings.length() > externalvariables.length()) {
                  { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                    stream000.nativeStream.print("Arity mismatch between bindings `" + outsidebindings + "' and external variables `" + externalvariables + "'.");
                    throw ((FailException)(FailException.newFailException(stream000.theStringReader()).fillInStackTrace()));
                  }
                }
                { PatternVariable arg = null;
                  Vector vector000 = externalvariables;
                  int index000 = 0;
                  int length000 = vector000.length();
                  Stella_Object value = null;
                  Vector vector001 = outsidebindings;
                  int index001 = 0;
                  int length001 = vector001.length();

                  for (;(index000 < length000) &&
                            (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
                    arg = ((PatternVariable)((vector000.theArray)[index000]));
                    value = (vector001.theArray)[index001];
                    if ((value != null) &&
                        (!Logic.bindArgumentToValueP(arg, value, false))) {
                      { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                        stream001.nativeStream.print("Binding of `" + arg + "' to `" + value + "' failed.");
                        throw ((FailException)(FailException.newFailException(stream001.theStringReader()).fillInStackTrace()));
                      }
                    }
                  }
                }
              }
              ControlFrame.overlayWithPatternFrameP(basecontrolframe, description, externalvariables);

            } finally {
              Stella.$MODULE$.set(old$Module$000);
              Stella.$CONTEXT$.set(old$Context$000);
            }
          }
          queryiterator.controlFramePriorityQueue = ControlFramePriorityQueue.newControlFramePriorityQueue();
          if (queryiterator.maximumDepth == Stella.NULL_INTEGER) {
            queryiterator.maximumDepth = Logic.$MAXIMUM_BACKTRACKING_DEPTH$;
          }
          queryiterator.augmentedGoalCacheP = false;
          queryiterator.activeGoalCaches.clear();
          if (Logic.$ITERATIVE_DEEPENING_MODEp$ &&
              (!Logic.testQueryOptionP(queryiterator, Logic.KWD_ITERATIVE_DEEPENINGp))) {
            KeyValueList.setDynamicSlotValue(queryiterator.dynamicSlots, Logic.SYM_LOGIC_ITERATIVE_DEEPENINGp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
          }
          queryiterator.currentDepthCutoff = (((BooleanWrapper)(KeyValueList.dynamicSlotValue(queryiterator.dynamicSlots, Logic.SYM_LOGIC_ITERATIVE_DEEPENINGp, Stella.FALSE_WRAPPER))).wrapperValue ? Stella.integer_min(Logic.$INITIAL_BACKTRACKING_DEPTH$, queryiterator.maximumDepth) : queryiterator.maximumDepth);
          queryiterator.triggeredDepthCutoffP = false;
          queryiterator.failedToFindDuplicateSubgoalP = false;
          queryiterator.foundAtLeastOneSolutionP = false;
          queryiterator.externalVariables = externalvariables;
          return (queryiterator);

        } finally {
          Logic.$EVALUATIONMODE$.set(old$Evaluationmode$000);
          Logic.$QUERYITERATOR$.set(old$Queryiterator$000);
        }
      }
    }
  }

  public static void freeQueryIterator(QueryIterator self) {
    if (self.baseControlFrame == null) {
      return;
    }
    ((QuerySolution)(self.value)).free();
    self.baseControlFrame = null;
  }

  public void free() {
    { QueryIterator self = this;

      QueryIterator.freeQueryIterator(self);
    }
  }

  public static void printQueryIteratorViaTemplate(QueryIterator self, edu.isi.stella.javalib.NativeOutputStream stream) {
    { Stella_Object template = Logic.lookupQueryOption(self, Logic.KWD_FORMAT);
      Cons parsedtemplate = null;
      Vector variables = self.externalVariables;
      QuerySolutionTable solutions = self.solutions;

      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          { QuerySolution solution = null;
            DictionaryIterator iter000 = ((DictionaryIterator)(solutions.allocateIterator()));
            int i = Stella.NULL_INTEGER;
            int iter001 = 1;
            int upperBound000 = ((Integer)(Stella.$PRINTLENGTH$.get())).intValue();
            boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

            for (;iter000.nextP() &&
                      (unboundedP000 ||
                       (iter001 <= upperBound000)); iter001 = iter001 + 1) {
              solution = ((QuerySolution)(iter000.value));
              i = iter001;
              { Surrogate testValue000 = Stella_Object.safePrimaryType(template);

                if (testValue000 == Logic.SGT_STELLA_CONS) {
                  { Cons template000 = ((Cons)(template));

                    parsedtemplate = ((Cons)(Stella_Object.copyConsTree(template000)));
                    { Stella_Object value = null;
                      Vector vector000 = solution.bindings;
                      int index000 = 0;
                      int length000 = vector000.length();
                      PatternVariable var = null;
                      Vector vector001 = variables;
                      int index001 = 0;
                      int length001 = vector001.length();

                      for (;(index000 < length000) &&
                                (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
                        value = (vector000.theArray)[index000];
                        var = ((PatternVariable)((vector001.theArray)[index001]));
                        Stella_Object.substituteConsTree(parsedtemplate, value, var.skolemName);
                      }
                    }
                    if (self.partialMatchStrategy != null) {
                      Stella_Object.substituteConsTree(parsedtemplate, FloatWrapper.wrapFloat(solution.matchScore), Logic.SYM_PL_KERNEL_KB_pMATCH_SCORE);
                    }
                    stream.println(parsedtemplate.toString());
                  }
                }
                else if (Surrogate.subtypeOfStringP(testValue000)) {
                  { StringWrapper template000 = ((StringWrapper)(template));

                    if (parsedtemplate == null) {
                      parsedtemplate = QueryIterator.parseQueryIteratorStringTemplate(self, template000.wrapperValue);
                    }
                    { Stella_Object elt = null;
                      Cons iter002 = parsedtemplate;

                      for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                        elt = iter002.value;
                        { Surrogate testValue001 = Stella_Object.safePrimaryType(elt);

                          if (Surrogate.subtypeOfStringP(testValue001)) {
                            { StringWrapper elt000 = ((StringWrapper)(elt));

                              stream.print(elt000.wrapperValue);
                            }
                          }
                          else if (Surrogate.subtypeOfIntegerP(testValue001)) {
                            { IntegerWrapper elt000 = ((IntegerWrapper)(elt));

                              stream.print((solution.bindings.theArray)[(elt000.wrapperValue)]);
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
                    stream.println();
                  }
                }
                else {
                  { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                    stream001.nativeStream.print("`" + testValue000 + "' is not a valid case option");
                    throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
                  }
                }
              }
              if ((i == ((Integer)(Stella.$PRINTLENGTH$.get())).intValue()) &&
                  (i < solutions.length())) {
                stream.print(";;; ...");
              }
            }
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
    }
  }

  public static Cons parseQueryIteratorStringTemplate(QueryIterator self, String template) {
    { String normalizedtemplate = Native.stringUpcase(template);
      Vector variables = self.externalVariables;

      { Cons value000 = Stella.NIL;

        { PatternVariable var = null;
          Vector vector000 = variables;
          int index000 = 0;
          int length000 = vector000.length();
          Cons collect000 = null;

          for (;index000 < length000; index000 = index000 + 1) {
            var = ((PatternVariable)((vector000.theArray)[index000]));
            if (collect000 == null) {
              {
                collect000 = Cons.cons(StringWrapper.wrapString(Native.stringUpcase(var.skolemName.symbolName)), Stella.NIL);
                if (value000 == Stella.NIL) {
                  value000 = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(value000, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(StringWrapper.wrapString(Native.stringUpcase(var.skolemName.symbolName)), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        { Cons variablenames = value000;
          int start = 0;
          int varstart = 0;
          Cons result = Stella.NIL;

          loop001 : for (;;) {
            varstart = Native.string_position(normalizedtemplate, '?', start);
            if (varstart == Stella.NULL_INTEGER) {
              result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(template, start, Stella.NULL_INTEGER)), result);
              break loop001;
            }
            else {
              { Stella_Object name = null;
                Cons iter000 = variablenames;
                int i = Stella.NULL_INTEGER;
                int iter001 = 0;

                loop002 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
                  name = iter000.value;
                  i = iter001;
                  if (Stella.startsWithP(normalizedtemplate, ((StringWrapper)(name)).wrapperValue, varstart)) {
                    result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(template, start, varstart)), result);
                    result = Cons.cons(IntegerWrapper.wrapInteger(i), result);
                    start = varstart + (StringWrapper.unwrapString(((StringWrapper)(name)))).length();
                    break loop002;
                  }
                }
              }
              if (start <= varstart) {
                result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(template, start, varstart + 1)), result);
                start = varstart + 1;
              }
            }
          }
          return (result.reverse());
        }
      }
    }
  }

  public static void printQueryIteratorTabSeparated(QueryIterator self, edu.isi.stella.javalib.NativeOutputStream stream) {
    { QuerySolutionTable solutions = self.solutions;
      char separator = '\t';

      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          { QuerySolution solution = null;
            DictionaryIterator iter000 = ((DictionaryIterator)(solutions.allocateIterator()));
            int i = Stella.NULL_INTEGER;
            int iter001 = 1;
            int upperBound000 = ((Integer)(Stella.$PRINTLENGTH$.get())).intValue();
            boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

            for (;iter000.nextP() &&
                      (unboundedP000 ||
                       (iter001 <= upperBound000)); iter001 = iter001 + 1) {
              solution = ((QuerySolution)(iter000.value));
              i = iter001;
              { Stella_Object value = null;
                Vector vector000 = solution.bindings;
                int index000 = 0;
                int length000 = vector000.length();
                int vi = Stella.NULL_INTEGER;
                int iter002 = 0;

                for (;index000 < length000; index000 = index000 + 1, iter002 = iter002 + 1) {
                  value = (vector000.theArray)[index000];
                  vi = iter002;
                  if (vi > 0) {
                    stream.print(separator);
                  }
                  stream.print(value);
                  if (self.partialMatchStrategy != null) {
                    stream.print("" + separator + solution.matchScore);
                  }
                }
              }
              stream.println();
              if ((i == ((Integer)(Stella.$PRINTLENGTH$.get())).intValue()) &&
                  (i < solutions.length())) {
                stream.println("...");
              }
            }
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
    }
  }

  public static void printQueryIteratorReadably(QueryIterator self, edu.isi.stella.javalib.NativeOutputStream stream) {
    { QuerySolutionTable solutions = self.solutions;
      boolean firstP = true;
      boolean atomicsingletonsP = ((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_ATOMIC_SINGLETONSp, Stella.FALSE_WRAPPER))).wrapperValue &&
          (self.partialMatchStrategy == null);

      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          stream.print("(");
          { QuerySolution solution = null;
            DictionaryIterator iter000 = ((DictionaryIterator)(solutions.allocateIterator()));
            int i = Stella.NULL_INTEGER;
            int iter001 = 1;
            int upperBound000 = ((Integer)(Stella.$PRINTLENGTH$.get())).intValue();
            boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

            for (;iter000.nextP() &&
                      (unboundedP000 ||
                       (iter001 <= upperBound000)); iter001 = iter001 + 1) {
              solution = ((QuerySolution)(iter000.value));
              i = iter001;
              if (!(firstP)) {
                if (atomicsingletonsP) {
                  stream.print(" ");
                }
                else {
                  {
                    stream.println();
                    stream.print(" ");
                  }
;
                }
              }
              firstP = false;
              if (!(atomicsingletonsP)) {
                stream.print("(");
              }
              { Stella_Object value = null;
                Vector vector000 = solution.bindings;
                int index000 = 0;
                int length000 = vector000.length();
                int vi = Stella.NULL_INTEGER;
                int iter002 = 0;

                for (;index000 < length000; index000 = index000 + 1, iter002 = iter002 + 1) {
                  value = (vector000.theArray)[index000];
                  vi = iter002;
                  stream.print((((vi == 0) ? "" : " ")) + value);
                  if (self.partialMatchStrategy != null) {
                    stream.print(" " + solution.matchScore);
                  }
                }
              }
              if (!(atomicsingletonsP)) {
                stream.print(")");
              }
              if ((i == ((Integer)(Stella.$PRINTLENGTH$.get())).intValue()) &&
                  (i < solutions.length())) {
                stream.print(" ...");
              }
            }
          }
          stream.println(")");

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
    }
  }

  public static void traceSolution(QueryIterator self, QuerySolution solution, int solutionnumber) {
    if (Stella_Object.traceKeywordP(Logic.KWD_TRACE_SOLUTIONS)) {
      Stella.STANDARD_OUTPUT.nativeStream.print("SOLUTION ");
      QueryIterator.printQueryIteratorSolutionOrnately(self, solution, solutionnumber, Stella.STANDARD_OUTPUT.nativeStream);
      Stella.STANDARD_OUTPUT.nativeStream.println();
    }
  }

  public static void printQueryIteratorSolutionOrnately(QueryIterator self, QuerySolution solution, int solutionnumber, edu.isi.stella.javalib.NativeOutputStream stream) {
    { int nsolutions = self.solutions.length();
      boolean verticalP = Logic.testQueryOptionValueP(self, Logic.KWD_FORMAT, Logic.KWD_VERTICAL);
      int maxdigits = Native.floor(Math.log((((double)(nsolutions)))) * Stella.RECIPROCAL_NL10) + 1;
      int solnumberdigits = 0;

      if (solutionnumber == Stella.NULL_INTEGER) {
        solutionnumber = 0;
        { QuerySolution solution000 = null;
          DictionaryIterator iter000 = ((DictionaryIterator)(self.solutions.allocateIterator()));

          while (iter000.nextP()) {
            solution000 = ((QuerySolution)(iter000.value));
            if (!Stella_Object.equalP(solution000.bindings, solution000)) {
              solutionnumber = solutionnumber + 1;
            }
          }
        }
      }
      solnumberdigits = Native.floor(Math.log((((double)(solutionnumber)))) * Stella.RECIPROCAL_NL10) + 1;
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          if (!(verticalP)) {
            { int i = Stella.NULL_INTEGER;
              int iter001 = solnumberdigits;
              int upperBound000 = maxdigits - 1;

              for (;iter001 <= upperBound000; iter001 = iter001 + 1) {
                i = iter001;
                i = i;
                stream.print(" ");
              }
            }
          }
          stream.print("#" + solutionnumber + ": ");
          { Stella_Object value = null;
            Vector vector000 = solution.bindings;
            int index000 = 0;
            int length000 = vector000.length();
            PatternVariable variable = null;
            Vector vector001 = self.externalVariables;
            int index001 = 0;
            int length001 = vector001.length();
            int vi = Stella.NULL_INTEGER;
            int iter002 = 0;

            for (;(index000 < length000) &&
                      (index001 < length001); 
                  index000 = index000 + 1,
                  index001 = index001 + 1,
                  iter002 = iter002 + 1) {
              value = (vector000.theArray)[index000];
              variable = ((PatternVariable)((vector001.theArray)[index001]));
              vi = iter002;
              if (verticalP) {
                {
                  stream.println();
                  stream.print("  ");
                }
;
              }
              else if (vi > 0) {
                stream.print(", ");
              }
              stream.print(variable.skolemName + "=" + value);
            }
          }
          if ((self.partialMatchStrategy != null) &&
              (solution.matchScore != Stella.NULL_FLOAT)) {
            if (verticalP) {
              {
                stream.println();
                stream.print(" ");
              }
;
            }
            stream.print(" " + solution.matchScore);
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
    }
  }

  public static void printQueryIteratorOrnately(QueryIterator self, edu.isi.stella.javalib.NativeOutputStream stream) {
    { QuerySolutionTable solutions = self.solutions;
      int nofsolutions = solutions.length();
      boolean exhaustedP = self.exhaustedP;

      switch (nofsolutions) {
        case 0: 
          stream.print("No solutions");
        break;
        case 1: 
          stream.print("There is 1 solution");
        break;
        default:
          stream.print("There are " + nofsolutions + " solutions");
        break;
      }
      if (!(exhaustedP)) {
        stream.print(" so far");
      }
      if (self.timeoutP ||
          self.depthCutoffsP) {
        stream.print(" (");
        if (self.timeoutP) {
          stream.print("timeout");
          if (self.depthCutoffsP) {
            stream.print(", ");
          }
        }
        if (self.depthCutoffsP) {
          stream.print("depth cutoffs");
        }
        stream.print(")");
      }
      if (nofsolutions == 0) {
        stream.println(".");
        return;
      }
      stream.println(":");
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          { QuerySolution solution = null;
            DictionaryIterator iter000 = ((DictionaryIterator)(solutions.allocateIterator()));
            int i = Stella.NULL_INTEGER;
            int iter001 = 1;
            int upperBound000 = ((Integer)(Stella.$PRINTLENGTH$.get())).intValue();
            boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

            for (;iter000.nextP() &&
                      (unboundedP000 ||
                       (iter001 <= upperBound000)); iter001 = iter001 + 1) {
              solution = ((QuerySolution)(iter000.value));
              i = iter001;
              QueryIterator.printQueryIteratorSolutionOrnately(self, solution, i, stream);
              stream.println();
              if ((i == ((Integer)(Stella.$PRINTLENGTH$.get())).intValue()) &&
                  (i < nofsolutions)) {
                stream.println("  ......");
              }
            }
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
    }
  }

  public static void printQueryIterator(QueryIterator self, edu.isi.stella.javalib.NativeOutputStream stream) {
    { Stella_Object format = Logic.lookupQueryOption(self, Logic.KWD_FORMAT);
      Stella_Object file = Logic.lookupQueryOption(self, Logic.KWD_OUTPUT_FILE);
      Stella_Object ifexists = Logic.lookupQueryOptionWithDefault(self, Logic.KWD_IF_EXISTS, Logic.KWD_SUPERSEDE);
      OutputFileStream filestream = null;

      try {
        if (file != null) {
          { boolean outputheaderP = Logic.$POWERLOOM_KB_FILE_EXTENSIONS$.memberP(StringWrapper.wrapString(Stella.fileExtension(((StringWrapper)(file)).wrapperValue))) &&
                ((!(ifexists == Logic.KWD_APPEND)) ||
                 (!Stella.probeFileP(((StringWrapper)(file)).wrapperValue)));

            filestream = Stella.openOutputFile(((StringWrapper)(file)).wrapperValue, Cons.cons(Logic.KWD_IF_EXISTS, Cons.cons(((Keyword)(ifexists)), Stella.NIL)));
            if (outputheaderP) {
              Logic.printModuleFileHeader(((Module)(Stella.$MODULE$.get())), filestream);
            }
            stream = filestream.nativeStream;
          }
        }
        if (Logic.$DEBUG_PRINT_MODEp$) {
          stream.print("[" + ((StringWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DEBUG_ID, Stella.NULL_STRING_WRAPPER))).wrapperValue + "] ");
        }
        if (format == Logic.KWD_VERTICAL) {
          QueryIterator.printQueryIteratorOrnately(self, stream);
        }
        else if (format == Logic.KWD_LIST) {
          QueryIterator.printQueryIteratorReadably(self, stream);
        }
        else if (format == Logic.KWD_TSV) {
          QueryIterator.printQueryIteratorTabSeparated(self, stream);
        }
        else if (Stella_Object.consP(format)) {
          QueryIterator.printQueryIteratorViaTemplate(self, stream);
        }
        else if (Stella_Object.stringP(format)) {
          QueryIterator.printQueryIteratorViaTemplate(self, stream);
        }
        else if ((format == null) ||
            (format == Logic.KWD_HORIZONTAL)) {
          if (((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue()) {
            QueryIterator.printQueryIteratorReadably(self, stream);
          }
          else {
            QueryIterator.printQueryIteratorOrnately(self, stream);
          }
        }
        else {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: Output format `" + format + "' is not yet supported");
          QueryIterator.printQueryIteratorOrnately(self, stream);
        }

      } finally {
        if (filestream != null) {
          Stream.closeStream(filestream);
        }
      }
    }
  }

  /** Set the debug ID of <code>self</code> to <code>id</code>.  If <code>id</code> is NULL, simply
   * use the current ID counter and increment it appropriately.
   * @param id
   */
  public void debugIdSetter(String id) {
    { QueryIterator self = this;

      if (Logic.$DEBUG_PRINT_MODEp$) {
        { String counter = Native.integerToString(((long)(Logic.$QUERY_ITERATOR_DEBUG_ID_COUNTER$ = Logic.$QUERY_ITERATOR_DEBUG_ID_COUNTER$ + 1)));

          KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DEBUG_ID, (Stella.blankStringP(id) ? StringWrapper.wrapString(counter) : StringWrapper.wrapString(id + ":" + counter)), Stella.NULL_STRING_WRAPPER);
        }
      }
    }
  }

  public static boolean executeBackwardChainingProofP(QueryIterator query) {
    if (query.baseControlFrame.down == null) {
      return (false);
    }
    { Object old$Queryiterator$000 = Logic.$QUERYITERATOR$.get();

      try {
        Native.setSpecial(Logic.$QUERYITERATOR$, query);
        { ControlFrame frame = query.baseControlFrame;
          int depth = 0;
          Keyword lastmove = Logic.KWD_DOWN;
          Keyword resultofnextmove = null;
          int clockticks = query.currentClockTicks;
          long starttime = Native.getTicktock();
          int startticks = clockticks;
          double allottedtime = query.allottedTime;
          int allottedticks = query.allottedClockTicks;
          boolean checkfortimeoutP = allottedtime != Stella.NULL_FLOAT;
          boolean checkformoveoutP = allottedticks != Stella.NULL_INTEGER;
          boolean tracesubgoalsP = Stella_Object.traceKeywordP(Logic.KWD_GOAL_TREE);
          boolean timeoutP = false;
          boolean successP = false;

          query.timeoutP = false;
          frame.startingClockTicks = clockticks;
          if (checkformoveoutP) {
            frame.allottedClockTicks = allottedticks;
          }
          frame.truthValue = null;
          KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null, null);
          if ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
              (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) {
            frame.partialMatchFrame = query.partialMatchStrategy;
            frame.partialMatchFrame.clearFramePartialTruth();
          }
          lastmove = Logic.KWD_DOWN;
          loop000 : for (;;) {
            query.currentControlFrame = frame;
            if (tracesubgoalsP) {
              if ((lastmove == Logic.KWD_UP_TRUE) ||
                  (lastmove == Logic.KWD_UP_FAIL)) {
                ControlFrame.traceGoalTree(frame.result, depth, lastmove);
              }
              else {
                ControlFrame.traceGoalTree(frame, depth, lastmove);
              }
            }
            if (checkfortimeoutP &&
                ((clockticks & 15) == 0)) {
              { long currenttime = Native.getTicktock();
                double difference = Native.ticktockDifference(starttime, currenttime);

                if (difference >= 0.02) {
                  allottedtime = allottedtime - difference;
                  starttime = currenttime;
                }
                if (allottedtime <= 0.0) {
                  timeoutP = true;
                }
              }
            }
            resultofnextmove = ControlFrame.evaluateNextMove(frame, lastmove, clockticks);
            frame = query.currentControlFrame;
            if (resultofnextmove == Logic.KWD_MOVE_DOWN) {
              { ControlFrame upframe = frame;
                ControlFrame downframe = frame.down;

                depth = depth + 1;
                query.currentClockTicks = clockticks = clockticks + 1;
                if (downframe != null) {
                  frame = downframe;
                  frame.startingClockTicks = clockticks;
                  if (checkformoveoutP &&
                      (frame.allottedClockTicks == Stella.NULL_INTEGER)) {
                    frame.allottedClockTicks = upframe.allottedClockTicks - 1;
                  }
                  frame.truthValue = null;
                  KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null, null);
                  if (frame.partialMatchFrame != null) {
                    frame.partialMatchFrame.clearFramePartialTruth();
                  }
                  lastmove = Logic.KWD_DOWN;
                }
                else {
                  { Stella_Object proposition = Logic.argumentBoundTo((upframe.proposition.arguments.theArray)[(upframe.argumentCursor)]);

                    downframe = ControlFrame.createDownFrame(upframe, ((Proposition)(proposition)));
                    frame = downframe;
                    frame.startingClockTicks = clockticks;
                    if (checkformoveoutP) {
                      frame.allottedClockTicks = upframe.allottedClockTicks - 1;
                    }
                    lastmove = Logic.KWD_DOWN;
                  }
                }
                if ((depth > query.currentDepthCutoff) &&
                    (upframe.state == Logic.KWD_PATTERN)) {
                  ControlFrame.popFramesUpTo(frame);
                  { Object [] caller_MV_returnarray = new Object[1];

                    frame = ControlFrame.handleDepthViolation(frame, depth, caller_MV_returnarray);
                    depth = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
                  }
                  lastmove = Logic.KWD_UP_FAIL;
                }
                if (checkformoveoutP) {
                  if ((frame.allottedClockTicks <= 0) &&
                      (!(lastmove == Logic.KWD_UP_FAIL))) {
                    ControlFrame.popFramesUpTo(frame);
                    { Object [] caller_MV_returnarray = new Object[1];

                      frame = ControlFrame.handleTimeout(frame, depth, caller_MV_returnarray);
                      depth = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
                    }
                    lastmove = Logic.KWD_UP_FAIL;
                  }
                  if (lastmove == Logic.KWD_UP_FAIL) {
                    frame.allottedClockTicks = frame.allottedClockTicks - ((clockticks - downframe.startingClockTicks) + 1);
                  }
                }
              }
              if (timeoutP &&
                  (lastmove == Logic.KWD_DOWN)) {
                successP = false;
                break loop000;
              }
            }
            else if (resultofnextmove == Logic.KWD_FINAL_SUCCESS) {
              { ControlFrame parent = frame.up;

                if (parent != null) {
                  parent.result = frame;
                  if ((Logic.$CACHE_SUCCEEDED_GOALSp$ ||
                      Logic.$CACHE_FAILED_GOALSp$) &&
                      ((Logic.$DUPLICATE_SUBGOAL_STRATEGY$ == Logic.KWD_DUPLICATE_GOALS) &&
                       (!((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
                      (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null))))) {
                    ControlFrame.cacheGoal(frame, true, false, clockticks);
                  }
                  else {
                    ControlFrame.updateGoalCache(frame, true);
                  }
                }
                depth = depth - 1;
                if (checkformoveoutP) {
                  frame.allottedClockTicks = Stella.NULL_INTEGER;
                  if (parent != null) {
                    parent.allottedClockTicks = (parent.allottedClockTicks - (clockticks - frame.startingClockTicks)) - 1;
                  }
                }
                frame = parent;
                if (frame == null) {
                  successP = true;
                  break loop000;
                }
                ControlFrame.popDownFrame(frame);
                lastmove = Logic.KWD_UP_TRUE;
              }
            }
            else if (resultofnextmove == Logic.KWD_CONTINUING_SUCCESS) {
              { ControlFrame parent = frame.up;

                if (parent != null) {
                  parent.result = frame;
                  if ((Logic.$CACHE_SUCCEEDED_GOALSp$ ||
                      Logic.$CACHE_FAILED_GOALSp$) &&
                      ((Logic.$DUPLICATE_SUBGOAL_STRATEGY$ == Logic.KWD_DUPLICATE_GOALS) &&
                       (!((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
                      (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null))))) {
                    ControlFrame.cacheGoal(frame, true, true, clockticks);
                  }
                  else {
                    ControlFrame.updateGoalCache(frame, true);
                  }
                }
                depth = depth - 1;
                if (checkformoveoutP) {
                  frame.allottedClockTicks = Stella.NULL_INTEGER;
                  if (parent != null) {
                    parent.allottedClockTicks = (parent.allottedClockTicks - (clockticks - frame.startingClockTicks)) - 1;
                  }
                }
                frame = parent;
                if (frame == null) {
                  successP = true;
                  break loop000;
                }
                lastmove = Logic.KWD_UP_TRUE;
              }
            }
            else if (resultofnextmove == Logic.KWD_FAILURE) {
              { ControlFrame parent = frame.up;

                if (parent != null) {
                  parent.result = frame;
                  if ((Logic.$CACHE_SUCCEEDED_GOALSp$ ||
                      Logic.$CACHE_FAILED_GOALSp$) &&
                      ((Logic.$DUPLICATE_SUBGOAL_STRATEGY$ == Logic.KWD_DUPLICATE_GOALS) &&
                       (!((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
                      (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null))))) {
                    ControlFrame.cacheGoal(frame, false, false, clockticks);
                  }
                  else {
                    ControlFrame.updateGoalCache(frame, false);
                  }
                }
                depth = depth - 1;
                if (checkformoveoutP) {
                  frame.allottedClockTicks = Stella.NULL_INTEGER;
                  if (parent != null) {
                    parent.allottedClockTicks = (parent.allottedClockTicks - (clockticks - frame.startingClockTicks)) - 1;
                  }
                }
                frame = parent;
                if (frame == null) {
                  successP = false;
                  break loop000;
                }
                ControlFrame.popDownFrame(frame);
                lastmove = Logic.KWD_UP_FAIL;
              }
            }
            else if (resultofnextmove == Logic.KWD_MOVE_IN_PLACE) {
              {
                frame.truthValue = null;
                KeyValueList.setDynamicSlotValue(frame.dynamicSlots, Logic.SYM_LOGIC_JUSTIFICATION, null, null);
                if (frame.partialMatchFrame != null) {
                  frame.partialMatchFrame.clearFramePartialTruth();
                }
                lastmove = Logic.KWD_DOWN;
                if (checkformoveoutP) {
                  { ControlFrame parent = frame.up;
                    int startticks000 = frame.startingClockTicks;
                    int availableticks = (parent.allottedClockTicks - (clockticks - startticks000)) - 1;

                    parent.allottedClockTicks = availableticks;
                    availableticks = availableticks - 1;
                    frame.allottedClockTicks = availableticks;
                    query.currentClockTicks = clockticks = clockticks + 1;
                    frame.startingClockTicks = clockticks;
                    if (availableticks <= 0) {
                      ControlFrame.popFramesUpTo(frame);
                      { Object [] caller_MV_returnarray = new Object[1];

                        frame = ControlFrame.handleTimeout(frame, depth, caller_MV_returnarray);
                        depth = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
                      }
                      lastmove = Logic.KWD_UP_FAIL;
                      frame.allottedClockTicks = frame.allottedClockTicks - ((clockticks - startticks000) + 1);
                    }
                  }
                }
                else {
                  query.currentClockTicks = clockticks = clockticks + 1;
                  frame.startingClockTicks = clockticks;
                }
              }
            }
            else if (resultofnextmove == Logic.KWD_TIMEOUT) {
              { ControlFrame parent = frame.up;

                if (parent != null) {
                  parent.result = frame;
                  if ((Logic.$CACHE_SUCCEEDED_GOALSp$ ||
                      Logic.$CACHE_FAILED_GOALSp$) &&
                      ((Logic.$DUPLICATE_SUBGOAL_STRATEGY$ == Logic.KWD_DUPLICATE_GOALS) &&
                       (!((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
                      (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null))))) {
                    ControlFrame.cacheGoal(frame, false, true, clockticks);
                  }
                  else {
                    ControlFrame.updateGoalCache(frame, false);
                  }
                }
                depth = depth - 1;
                if (checkformoveoutP) {
                  frame.allottedClockTicks = Stella.NULL_INTEGER;
                  if (parent != null) {
                    parent.allottedClockTicks = (parent.allottedClockTicks - (clockticks - frame.startingClockTicks)) - 1;
                  }
                }
                frame = parent;
                if (frame == null) {
                  successP = false;
                  break loop000;
                }
                lastmove = Logic.KWD_UP_FAIL;
              }
            }
            else {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("`" + resultofnextmove + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
          }
          query.allottedTime = allottedtime;
          query.timeoutP = timeoutP;
          if (checkformoveoutP) {
            query.allottedClockTicks = Stella.integer_max(allottedticks - (clockticks - startticks), 0);
            if (!(timeoutP)) {
              query.timeoutP = query.allottedClockTicks == 0;
            }
          }
          return (successP);
        }

      } finally {
        Logic.$QUERYITERATOR$.set(old$Queryiterator$000);
      }
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { QueryIterator self = this;

      QueryIterator.printQueryIterator(self, stream);
    }
  }

  public boolean deletedPSetter(boolean value) {
    { QueryIterator self = this;

      KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_STELLA_DELETED_OBJECTp, (value ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), null);
      return (value);
    }
  }

  public boolean deletedP() {
    { QueryIterator self = this;

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

  public static Stella_Object accessQueryIteratorSlotValue(QueryIterator self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_EXTERNAL_VARIABLES) {
      if (setvalueP) {
        self.externalVariables = ((Vector)(value));
      }
      else {
        value = self.externalVariables;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_EXHAUSTEDp) {
      if (setvalueP) {
        self.exhaustedP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.exhaustedP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Logic.SYM_STELLA_OPTIONS) {
      if (setvalueP) {
        self.options = ((PropertyList)(value));
      }
      else {
        value = self.options;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_SOLUTIONS) {
      if (setvalueP) {
        self.solutions = ((QuerySolutionTable)(value));
      }
      else {
        value = self.solutions;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_QUERY_CONTEXT) {
      if (setvalueP) {
        self.queryContext = ((Context)(value));
      }
      else {
        value = self.queryContext;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_BASE_CONTROL_FRAME) {
      if (setvalueP) {
        self.baseControlFrame = ((ControlFrame)(value));
      }
      else {
        value = self.baseControlFrame;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_CURRENT_CONTROL_FRAME) {
      if (setvalueP) {
        self.currentControlFrame = ((ControlFrame)(value));
      }
      else {
        value = self.currentControlFrame;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_CURRENT_PATTERN_RECORD) {
      if (setvalueP) {
        self.currentPatternRecord = ((PatternRecord)(value));
      }
      else {
        value = self.currentPatternRecord;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_CURRENT_PARALLEL_THREAD) {
      if (setvalueP) {
        self.currentParallelThread = ((ParallelThread)(value));
      }
      else {
        value = self.currentParallelThread;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_CONTROL_FRAME_PRIORITY_QUEUE) {
      if (setvalueP) {
        self.controlFramePriorityQueue = ((ControlFramePriorityQueue)(value));
      }
      else {
        value = self.controlFramePriorityQueue;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_AUGMENTED_GOAL_CACHEp) {
      if (setvalueP) {
        self.augmentedGoalCacheP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.augmentedGoalCacheP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_ACTIVE_GOAL_CACHES) {
      if (setvalueP) {
        self.activeGoalCaches = ((List)(value));
      }
      else {
        value = self.activeGoalCaches;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_TRIGGERED_DEPTH_CUTOFFp) {
      if (setvalueP) {
        self.triggeredDepthCutoffP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.triggeredDepthCutoffP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_FAILED_TO_FIND_DUPLICATE_SUBGOALp) {
      if (setvalueP) {
        self.failedToFindDuplicateSubgoalP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.failedToFindDuplicateSubgoalP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_FOUND_AT_LEAST_ONE_SOLUTIONp) {
      if (setvalueP) {
        self.foundAtLeastOneSolutionP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.foundAtLeastOneSolutionP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
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
    else if (slotname == Logic.SYM_LOGIC_PARTIAL_MATCH_STRATEGY) {
      if (setvalueP) {
        self.partialMatchStrategy = ((PartialMatchFrame)(value));
      }
      else {
        value = self.partialMatchStrategy;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_RESIDUE_GOALS) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_RESIDUE_GOALS, ((List)(value)), null);
      }
      else {
        value = self.residueGoals();
      }
    }
    else if (slotname == Logic.SYM_LOGIC_BEST_GOAL_SEQUENCE) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_BEST_GOAL_SEQUENCE, ((List)(value)), null);
      }
      else {
        value = self.bestGoalSequence();
      }
    }
    else if (slotname == Logic.SYM_LOGIC_INFERENCE_LEVEL) {
      if (setvalueP) {
        self.inferenceLevel = ((InferenceLevel)(value));
      }
      else {
        value = self.inferenceLevel;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_CURRENT_DEPTH_CUTOFF) {
      if (setvalueP) {
        self.currentDepthCutoff = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.currentDepthCutoff);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_MAXIMUM_DEPTH) {
      if (setvalueP) {
        self.maximumDepth = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.maximumDepth);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_ALLOTTED_TIME) {
      if (setvalueP) {
        self.allottedTime = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.allottedTime);
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
    else if (slotname == Logic.SYM_LOGIC_CURRENT_CLOCK_TICKS) {
      if (setvalueP) {
        self.currentClockTicks = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.currentClockTicks);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_TIMEOUTp) {
      if (setvalueP) {
        self.timeoutP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.timeoutP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_DEPTH_CUTOFFSp) {
      if (setvalueP) {
        self.depthCutoffsP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.depthCutoffsP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else {
      if (slotname == Logic.SYM_LOGIC_NEGATED_QUERY) {
        slotname = Logic.SYM_LOGIC_AUXILIARY_QUERY;
      }
      else if (slotname == Logic.SYM_LOGIC_LATEST_PARTIAL_SCORE) {
        slotname = Logic.SYM_LOGIC_LATEST_POSITIVE_SCORE;
      }
      else {
      }
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
    { QueryIterator self = this;

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

  public List bestGoalSequence() {
    { QueryIterator self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_BEST_GOAL_SEQUENCE, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public List residueGoals() {
    { QueryIterator self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_RESIDUE_GOALS, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public Surrogate primaryType() {
    { QueryIterator self = this;

      return (Logic.SGT_LOGIC_QUERY_ITERATOR);
    }
  }

}

