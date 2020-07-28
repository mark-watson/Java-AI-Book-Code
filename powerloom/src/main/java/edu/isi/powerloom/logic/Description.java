//  -*- Mode: Java -*-
//
// Description.java

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

public class Description extends LogicObject {
    public Proposition proposition;
    public Vector ioVariables;
    /** The set of internally quantified variables besides the
     * descriptions's IO variables.  This set includes any top-level implicit
     * existential variables plus any variables introduced by some nested quantifier.
     * IMPORTANT: therefore, a description's internal variables are not necessarily
     * equivalent to its top-level implicit existential variables.
     */
    public Vector internalVariables;
    public KeyValueList queryPatterns;

  public static Description newDescription() {
    { Description self = null;

      self = new Description();
      self.dependentPropositionsIndex = null;
      self.dynamicSlots = KeyValueList.newKeyValueList();
      self.surrogateValueInverse = null;
      self.variableValueInverse = null;
      self.homeContext = ((Module)(Stella.$MODULE$.get()));
      self.queryPatterns = null;
      self.internalVariables = Logic.ZERO_VARIABLES_VECTOR;
      self.ioVariables = null;
      self.proposition = null;
      LogicObject.logLogicObject(self);
      return (self);
    }
  }

  /** Helper function for <code>printConceptOutline</code>
   * @param stream
   * @param currentDepth
   * @param depth
   * @param namedP
   */
  public void helpPrintOutline(OutputStream stream, int currentDepth, int depth, boolean namedP) {
    { Description top = this;

      if (!(namedP)) {
        Stella.indentOutline(currentDepth, stream);
        stream.nativeStream.println(top.toString());
      }
      if (!((depth != Stella.NULL_INTEGER) &&
          ((depth >= 0) &&
           (currentDepth >= depth)))) {
        currentDepth = currentDepth + 1;
        { LogicObject c = null;
          Iterator iter000 = LogicObject.allDirectSubcollections(top, true);

          while (iter000.nextP()) {
            c = ((LogicObject)(iter000.value));
            c.helpPrintOutline(stream, currentDepth, depth, namedP);
          }
        }
      }
    }
  }

  public static void helpAllSubtypes(Description renamed_Super, Stella_Object self, List types) {
    { LogicObject c = null;
      Iterator iter000 = LogicObject.allDirectSubcollections(renamed_Super, true);

      while (iter000.nextP()) {
        c = ((LogicObject)(iter000.value));
        if (Stella_Object.isaP(c, Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
          if ((!types.memberP(c)) &&
              Logic.testTypeOnInstanceP(self, ((NamedDescription)(c)).surrogateValueInverse)) {
            types.insertNew(c);
            Description.helpAllSubtypes(((Description)(c)), self, types);
          }
        }
        else {
          Description.helpAllSubtypes(((Description)(c)), self, types);
        }
      }
    }
  }

  /** Classify 'self' and return three values, its direct
   * supers, direct subs, and a list of equivalent descriptions.
   * Setting 'supersOnly?' may speed up the computation (perhaps by a lot).
   * If 'description' is nameless and has no dependent propositions, then
   * it is automatically removed from the hierarchy after classification.
   * @param self
   * @param onlysupersP
   * @param MV_returnarray
   * @return Cons
   */
  public static Cons findDirectSupersAndSubs(Description self, boolean onlysupersP, Object [] MV_returnarray) {
    Logic.finalizeObjects();
    if (self == null) {
      { Cons _return_temp = Stella.NIL;

        MV_returnarray[0] = Stella.NIL;
        MV_returnarray[1] = Stella.NIL;
        return (_return_temp);
      }
    }
    { Object old$Findsupersandsubsdescription$000 = Logic.$FINDSUPERSANDSUBSDESCRIPTION$.get();

      try {
        Native.setSpecial(Logic.$FINDSUPERSANDSUBSDESCRIPTION$, self);
        { Object old$Classificationsession$000 = Logic.$CLASSIFICATIONSESSION$.get();
          Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Logic.$CLASSIFICATIONSESSION$, Logic.getClassificationSession(Logic.KWD_DESCRIPTION));
            Native.setSpecial(Stella.$CONTEXT$, ((ClassificationSession)(Logic.$CLASSIFICATIONSESSION$.get())).classificationWorld);
            { boolean virginP = self.virginP();
              int oldcurrenttime = Logic.currentClassificationTime();
              Cons supers = Stella.NIL;
              Cons subs = Stella.NIL;
              Cons equivalents = Stella.NIL;

              if (virginP) {
                Description.introduceIntoClassificationSession(self);
              }
              LogicObject.upclassifyOneDescription(self);
              { NamedDescription renamed_Super = null;
                Cons iter000 = Description.allNamedDirectSuperdescriptions(self, false);

                for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  renamed_Super = ((NamedDescription)(iter000.value));
                  LogicObject.upclassifyOneDescription(renamed_Super);
                }
              }
              supers = Description.allNamedDirectSuperdescriptions(self, true);
              if (!onlysupersP) {
                LogicObject.downclassifyOneDescription(self);
                subs = LogicObject.allDirectSubcollections(self, true).consify();
              }
              { LogicObject e = null;
                Cons iter001 = LogicObject.allEquivalentCollections(self, false);
                Cons collect000 = null;

                for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                  e = ((LogicObject)(iter001.value));
                  if (Description.namedDescriptionP(((Description)(e)))) {
                    if (collect000 == null) {
                      {
                        collect000 = Cons.cons(e, Stella.NIL);
                        if (equivalents == Stella.NIL) {
                          equivalents = collect000;
                        }
                        else {
                          Cons.addConsToEndOfConsList(equivalents, collect000);
                        }
                      }
                    }
                    else {
                      {
                        collect000.rest = Cons.cons(e, Stella.NIL);
                        collect000 = collect000.rest;
                      }
                    }
                  }
                }
              }
              if (virginP) {
                Description.evaporateVirgin(self);
                ((ClassificationSession)(Logic.$CLASSIFICATIONSESSION$.get())).introductionTimestampStack.pop();
              }
              { Cons _return_temp = supers;

                MV_returnarray[0] = subs;
                MV_returnarray[1] = equivalents;
                return (_return_temp);
              }
            }

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
            Logic.$CLASSIFICATIONSESSION$.set(old$Classificationsession$000);
          }
        }

      } finally {
        Logic.$FINDSUPERSANDSUBSDESCRIPTION$.set(old$Findsupersandsubsdescription$000);
      }
    }
  }

  public static void evaporateVirgin(Description self) {
    { List parentimplies = List.newList();
      List childimplies = List.newList();
      Description parent = null;
      Description child = null;
      Proposition bridgeprop = null;

      { Proposition p = null;
        Iterator iter000 = Logic.unfilteredDependentPropositions(self, null).allocateIterator();

        while (iter000.nextP()) {
          p = ((Proposition)(iter000.value));
          if ((p.arguments.theArray)[0] == self) {
            parentimplies.push(p);
          }
          else {
            childimplies.push(p);
          }
        }
      }
      { Proposition cp = null;
        Cons iter001 = childimplies.theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          cp = ((Proposition)(iter001.value));
          child = ((Description)((cp.arguments.theArray)[0]));
          { Proposition pp = null;
            Cons iter002 = parentimplies.theConsList;

            for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
              pp = ((Proposition)(iter002.value));
              parent = ((Description)((pp.arguments.theArray)[1]));
              bridgeprop = Description.assertDescriptionImpliesDescription(child, parent, true);
              if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(cp.dynamicSlots, Logic.SYM_LOGIC_SUBRELATION_LINKp, Stella.FALSE_WRAPPER))).wrapperValue &&
                  ((BooleanWrapper)(KeyValueList.dynamicSlotValue(pp.dynamicSlots, Logic.SYM_LOGIC_SUBRELATION_LINKp, Stella.FALSE_WRAPPER))).wrapperValue) {
                KeyValueList.setDynamicSlotValue(bridgeprop.dynamicSlots, Logic.SYM_LOGIC_SUBRELATION_LINKp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
              }
              Proposition.updatePropositionTruthValue(bridgeprop, Logic.KWD_ASSERT_TRUE);
            }
          }
        }
      }
      { Proposition p = null;
        Iterator iter003 = Logic.unfilteredDependentPropositions(self, null).allocateIterator();

        while (iter003.nextP()) {
          p = ((Proposition)(iter003.value));
          Proposition.destroyProposition(p);
        }
      }
    }
  }

  public boolean virginP() {
    { Description self = this;

      return (Logic.unfilteredDependentPropositions(self, null).emptyP() &&
          (!LogicObject.namedCollectionP(self)));
    }
  }

  public static void markUnmarkedSuperrelations(Description description, MarkerTable selfisbelowtable) {
    selfisbelowtable.setMarker(description);
    { NamedDescription renamed_Super = null;
      Cons iter000 = Description.allNamedDirectSuperdescriptions(description, true);

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        renamed_Super = ((NamedDescription)(iter000.value));
        if (!selfisbelowtable.testMarkerP(description)) {
          Description.markUnmarkedSuperrelations(renamed_Super, selfisbelowtable);
        }
      }
    }
  }

  public static void introduceIntoClassificationSession(Description self) {
    { World world = ((World)(KeyValueList.dynamicSlotValue(((Module)(Stella.$MODULE$.get())).dynamicSlots, Logic.SYM_LOGIC_META_INFERENCE_CACHE, null)));

      if ((world == null) ||
          (((ClassificationSession)(KeyValueList.dynamicSlotValue(world.dynamicSlots, Logic.SYM_LOGIC_CLASSIFICATION_SESSION, null))) == null)) {
        return;
      }
      { int newtimestamp = Logic.bumpClassificationTimeclock();

        Logic.getClassificationCache(self).introductionTimestamp = newtimestamp;
        ((ClassificationSession)(Logic.$CLASSIFICATIONSESSION$.get())).introductionTimestampStack.push(IntegerWrapper.wrapInteger(newtimestamp));
      }
    }
  }

  public static void addSubsumptionLink(Description subdescription, Description superdescription) {
    { Proposition impliesprop = Description.assertDescriptionImpliesDescription(subdescription, superdescription, false);

      KeyValueList.setDynamicSlotValue(impliesprop.dynamicSlots, Logic.SYM_LOGIC_SUBSUMPTION_LINKp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
      if (Stella_Object.traceKeywordP(Logic.KWD_CLASSIFIER_INFERENCES)) {
        { Object old$Indentcounter$000 = Logic.$INDENTCOUNTER$.get();
          Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setIntSpecial(Logic.$INDENTCOUNTER$, 4);
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            if (Logic.$EMIT_THINKING_DOTSp$) {
              Stella.STANDARD_OUTPUT.nativeStream.println();
            }
            {
              Stella.STANDARD_OUTPUT.nativeStream.println("Recognized subsumption link:");
              Stella.STANDARD_OUTPUT.nativeStream.println("    " + impliesprop);
            }
;

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            Logic.$INDENTCOUNTER$.set(old$Indentcounter$000);
          }
        }
      }
    }
    LogicObject.allInferableDirectSubcollections(superdescription).push(subdescription);
    { NamedDescription p = null;
      Cons iter000 = Description.allNamedDirectSuperdescriptions(superdescription, false);

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        p = ((NamedDescription)(iter000.value));
        { List subcollections = LogicObject.allInferableDirectSubcollections(p);

          subcollections.theConsList = ((Cons)(Logic.mostGeneralCollections(subcollections.theConsList)));
        }
      }
    }
  }

  public static Cons allNamedDirectSubdescriptions(Description self) {
    { Cons result = Stella.NIL;

      { LogicObject d = null;
        Iterator iter000 = LogicObject.allDirectSubcollections(self, false);

        while (iter000.nextP()) {
          d = ((LogicObject)(iter000.value));
          if (Stella_Object.isaP(d, Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
            result = Cons.cons(d, result);
          }
        }
      }
      return (result);
    }
  }

  public static Cons allNamedDirectSuperdescriptions(Description self, boolean removeequivalentsP) {
    { Cons result = Stella.NIL;

      { LogicObject d = null;
        Iterator iter000 = LogicObject.allDirectSupercollections(self, removeequivalentsP);

        while (iter000.nextP()) {
          d = ((LogicObject)(iter000.value));
          if (Stella_Object.isaP(d, Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
            result = Cons.cons(d, result);
          }
        }
      }
      return (result);
    }
  }

  public static boolean nonInferableP(Description self) {
    return (!Description.inferableP(self));
  }

  public static boolean inferableP(Description self) {
    { Object old$Context$000 = Stella.$CONTEXT$.get();
      Object old$Module$000 = Stella.$MODULE$.get();

      try {
        Native.setSpecial(Stella.$CONTEXT$, Logic.getInferableTestContext());
        Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
        return (Description.inferableWithCycleCheckP(self, Stella.NIL));

      } finally {
        Stella.$MODULE$.set(old$Module$000);
        Stella.$CONTEXT$.set(old$Context$000);
      }
    }
  }

  public static boolean inferableWithCycleCheckP(Description self, Cons alreadyvisitedlist) {
    if (alreadyvisitedlist.membP(self)) {
      return (false);
    }
    { boolean inferableP = false;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(self), Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
        { NamedDescription self000 = ((NamedDescription)(self));

          { MemoizationTable memoTable000 = null;
            Cons memoizedEntry000 = null;
            Stella_Object memoizedValue000 = null;

            if (Stella.$MEMOIZATION_ENABLEDp$) {
              memoTable000 = ((MemoizationTable)(Logic.SGT_LOGIC_F_INFERABLE_WITH_CYCLE_CHECKp_MEMO_TABLE_000.surrogateValue));
              if (memoTable000 == null) {
                Surrogate.initializeMemoizationTable(Logic.SGT_LOGIC_F_INFERABLE_WITH_CYCLE_CHECKp_MEMO_TABLE_000, "(:MAX-VALUES 500 :TIMESTAMPS (:IMPLIES-PROPOSITION-UPDATE))");
                memoTable000 = ((MemoizationTable)(Logic.SGT_LOGIC_F_INFERABLE_WITH_CYCLE_CHECKp_MEMO_TABLE_000.surrogateValue));
              }
              memoizedEntry000 = MruMemoizationTable.lookupMruMemoizedValue(((MruMemoizationTable)(memoTable000)), self000, ((Context)(Stella.$CONTEXT$.get())), Stella.MEMOIZED_NULL_VALUE, null, -1);
              memoizedValue000 = memoizedEntry000.value;
            }
            if (memoizedValue000 != null) {
              if (memoizedValue000 == Stella.MEMOIZED_NULL_VALUE) {
                memoizedValue000 = null;
              }
            }
            else {
              { boolean testValue001 = false;

                testValue001 = !(self000.surrogateValueInverse == Logic.SGT_STELLA_THING);
                if (testValue001) {
                  testValue001 = (alreadyvisitedlist = Cons.cons(self000, alreadyvisitedlist)) != null;
                  if (testValue001) {
                    { boolean foundP001 = false;

                      { Proposition p = null;
                        Cons iter001 = LogicObject.applicableRulesOfDescription(self000, Logic.KWD_BACKWARD, false);

                        loop000 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                          p = ((Proposition)(iter001.value));
                          if ((!((BooleanWrapper)(KeyValueList.dynamicSlotValue(p.dynamicSlots, Logic.SYM_LOGIC_FORWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue) &&
                              (Proposition.trueP(p) &&
                               NamedDescription.inferableThroughBySomeDescendantP(self000, ((LogicObject)((p.arguments.theArray)[0])), alreadyvisitedlist))) {
                            foundP001 = true;
                            break loop000;
                          }
                        }
                      }
                      testValue001 = foundP001;
                    }
                  }
                }
                memoizedValue000 = (testValue001 ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
              }
              if (Stella.$MEMOIZATION_ENABLEDp$) {
                memoizedEntry000.value = ((memoizedValue000 == null) ? Stella.MEMOIZED_NULL_VALUE : memoizedValue000);
              }
            }
            inferableP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(memoizedValue000)));
          }
        }
      }
      else {
        inferableP = true;
      }
      return (inferableP);
    }
  }

  public static List allIntensionalParents(Description self) {
    { List collection = List.newList();

      Description.helpCollectIntensionalParents(self, self.proposition, collection);
      return (collection);
    }
  }

  public static void helpCollectIntensionalParents(Description description, Proposition proposition, List collection) {
    { Keyword testValue000 = proposition.kind;

      if ((testValue000 == Logic.KWD_PREDICATE) ||
          ((testValue000 == Logic.KWD_FUNCTION) ||
           (testValue000 == Logic.KWD_ISA))) {
        { boolean testValue001 = false;

          { boolean alwaysP000 = true;

            { Stella_Object arg1 = null;
              Vector vector000 = proposition.arguments;
              int index000 = 0;
              int length000 = vector000.length();
              PatternVariable arg2 = null;
              Vector vector001 = description.ioVariables;
              int index001 = 0;
              int length001 = vector001.length();

              loop000 : for (;(index000 < length000) &&
                        (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
                arg1 = (vector000.theArray)[index000];
                arg2 = ((PatternVariable)((vector001.theArray)[index001]));
                if (!(arg1 == arg2)) {
                  alwaysP000 = false;
                  break loop000;
                }
              }
            }
            testValue001 = alwaysP000;
          }
          if (testValue001) {
            testValue001 = proposition.arguments.length() == description.ioVariables.length();
          }
          if (testValue001) {
            collection.push(Logic.getDescription(((Surrogate)(proposition.operator))));
          }
        }
      }
      else if (testValue000 == Logic.KWD_AND) {
        { Stella_Object arg = null;
          Vector vector002 = proposition.arguments;
          int index002 = 0;
          int length002 = vector002.length();

          for (;index002 < length002; index002 = index002 + 1) {
            arg = (vector002.theArray)[index002];
            Description.helpCollectIntensionalParents(description, ((Proposition)(arg)), collection);
          }
        }
      }
      else if (testValue000 == Logic.KWD_EXISTS) {
        Description.helpCollectIntensionalParents(description, ((Proposition)((proposition.arguments.theArray)[0])), collection);
      }
      else {
      }
    }
  }

  public static List getStructuralFunctionEvaluationOrder(Description self) {
    { List evaluationorder = self.structuralFunctionEvaluationOrder();

      if (List.nullListP(evaluationorder)) {
        evaluationorder = Description.computeStructuralFunctionEvaluationOrder(self);
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_STRUCTURAL_FUNCTION_EVALUATION_ORDER, evaluationorder, null);
      }
      return (evaluationorder);
    }
  }

  public List structuralFunctionEvaluationOrder() {
    { Description self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_STRUCTURAL_FUNCTION_EVALUATION_ORDER, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public static List computeStructuralFunctionEvaluationOrder(Description self) {
    { List structuralfunctions = List.newList();
      Vector iovariables = self.ioVariables;
      Vector internalvariables = self.internalVariables;
      HashSet candidates = HashSet.newHashSet();
      HashSet unboundinternals = HashSet.newHashSet();
      List sortedfunctions = List.newList();
      boolean progressP = true;

      Proposition.collectStructuralFunctions(self.proposition, structuralfunctions);
      { Proposition function = null;
        Cons iter000 = structuralfunctions.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          function = ((Proposition)(iter000.value));
          if (iovariables.memberP((function.arguments.theArray)[(function.arguments.length() - 1)]) ||
              internalvariables.memberP((function.arguments.theArray)[(function.arguments.length() - 1)])) {
            candidates.insert(function);
          }
        }
      }
      { PatternVariable var = null;
        Vector vector000 = internalvariables;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          var = ((PatternVariable)((vector000.theArray)[index000]));
          unboundinternals.insert(var);
        }
      }
      while (progressP) {
        progressP = false;
        { Proposition candidate = null;
          DictionaryIterator iter001 = ((DictionaryIterator)(candidates.allocateIterator()));

          while (iter001.nextP()) {
            candidate = ((Proposition)(iter001.value));
            { boolean testValue000 = false;

              testValue000 = !unboundinternals.memberP((candidate.arguments.theArray)[(candidate.arguments.length() - 1)]);
              if (testValue000) {
                { boolean alwaysP000 = true;

                  { Stella_Object arg = null;
                    Vector vector001 = candidate.arguments;
                    int index001 = 0;
                    int length001 = vector001.length();
                    int i = Stella.NULL_INTEGER;
                    int iter002 = 2;
                    int upperBound000 = candidate.arguments.length();

                    loop004 : for (;(index001 < length001) &&
                              (iter002 <= upperBound000); index001 = index001 + 1, iter002 = iter002 + 1) {
                      arg = (vector001.theArray)[index001];
                      i = iter002;
                      if (!(!unboundinternals.memberP(arg))) {
                        alwaysP000 = false;
                        break loop004;
                      }
                    }
                  }
                  testValue000 = alwaysP000;
                }
              }
              if (testValue000) {
                sortedfunctions.push(candidate);
                candidates.remove(candidate);
                progressP = true;
              }
            }
          }
        }
        { Proposition candidate = null;
          DictionaryIterator iter003 = ((DictionaryIterator)(candidates.allocateIterator()));

          while (iter003.nextP()) {
            candidate = ((Proposition)(iter003.value));
            { boolean alwaysP001 = true;

              { Stella_Object arg = null;
                Vector vector002 = candidate.arguments;
                int index002 = 0;
                int length002 = vector002.length();
                int i = Stella.NULL_INTEGER;
                int iter004 = 2;
                int upperBound001 = candidate.arguments.length();

                loop006 : for (;(index002 < length002) &&
                          (iter004 <= upperBound001); index002 = index002 + 1, iter004 = iter004 + 1) {
                  arg = (vector002.theArray)[index002];
                  i = iter004;
                  if (!(!unboundinternals.memberP(arg))) {
                    alwaysP001 = false;
                    break loop006;
                  }
                }
              }
              if (alwaysP001) {
                sortedfunctions.push(candidate);
                candidates.remove(candidate);
                unboundinternals.remove(((PatternVariable)((candidate.arguments.theArray)[(candidate.arguments.length() - 1)])));
                progressP = true;
              }
            }
          }
        }
      }
      return (sortedfunctions.reverse());
    }
  }

  public static Description copyDescription(Description self, KeyValueMap parentmapping, boolean addbacklinksP) {
    { Object old$Context$000 = Stella.$CONTEXT$.get();
      Object old$Module$000 = Stella.$MODULE$.get();

      try {
        Native.setSpecial(Stella.$CONTEXT$, self.homeContext);
        Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
        { Description copy = Logic.createDescription(Stella.NULL_INTEGER, false);
          KeyValueMap mapping = KeyValueMap.newKeyValueMap();

          if (parentmapping != null) {
            { Stella_Object k = null;
              Stella_Object v = null;
              DictionaryIterator iter000 = ((DictionaryIterator)(parentmapping.allocateIterator()));

              while (iter000.nextP()) {
                k = iter000.key;
                v = iter000.value;
                if (Stella_Object.isaP(k, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
                  mapping.insertAt(k, v);
                }
              }
            }
          }
          copy.ioVariables = Logic.copyVariablesVector(self.ioVariables, mapping);
          copy.internalVariables = Logic.copyVariablesVector(self.internalVariables, mapping);
          if (((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null))) != null) {
            { Cons value000 = Stella.NIL;

              { PatternVariable var = null;
                Vector vector000 = ((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null)));
                int index000 = 0;
                int length000 = vector000.length();
                Cons collect000 = null;

                for (;index000 < length000; index000 = index000 + 1) {
                  var = ((PatternVariable)((vector000.theArray)[index000]));
                  if ((mapping.lookup(var) == null) ||
                      Logic.variableP(mapping.lookup(var))) {
                    if (collect000 == null) {
                      {
                        collect000 = Cons.cons(var, Stella.NIL);
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
                        collect000.rest = Cons.cons(var, Stella.NIL);
                        collect000 = collect000.rest;
                      }
                    }
                  }
                }
              }
              { Cons realexternalvars = value000;
                Vector externalvarscopy = null;

                if (((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null))).length() == realexternalvars.length()) {
                  externalvarscopy = Logic.copyVariablesVector(((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null))), mapping);
                }
                else {
                  if (!(realexternalvars == Stella.NIL)) {
                    externalvarscopy = Logic.copyVariablesVector(Logic.copyConsListToVariablesVector(realexternalvars), mapping);
                  }
                }
                KeyValueList.setDynamicSlotValue(copy.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, externalvarscopy, null);
              }
            }
          }
          if (self.proposition != null) {
            { Object old$Boundtooffsetcounter$000 = Logic.$BOUNDTOOFFSETCOUNTER$.get();
              Object old$Evaluationmode$000 = Logic.$EVALUATIONMODE$.get();

              try {
                Native.setIntSpecial(Logic.$BOUNDTOOFFSETCOUNTER$, Stella.NULL_INTEGER);
                Native.setSpecial(Logic.$EVALUATIONMODE$, Logic.KWD_DESCRIPTION);
                copy.proposition = (addbacklinksP ? Proposition.recursivelyFastenDownPropositions(Proposition.copyProposition(self.proposition, mapping), false) : Proposition.copyProposition(self.proposition, mapping));

              } finally {
                Logic.$EVALUATIONMODE$.set(old$Evaluationmode$000);
                Logic.$BOUNDTOOFFSETCOUNTER$.set(old$Boundtooffsetcounter$000);
              }
            }
          }
          if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DONT_OPTIMIZEp, Stella.FALSE_WRAPPER))).wrapperValue) {
            KeyValueList.setDynamicSlotValue(copy.dynamicSlots, Logic.SYM_LOGIC_DONT_OPTIMIZEp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
          }
          mapping.free();
          return (copy);
        }

      } finally {
        Stella.$MODULE$.set(old$Module$000);
        Stella.$CONTEXT$.set(old$Context$000);
      }
    }
  }

  public static void simplifyDescription(Description description, boolean postoptimizationP) {
    if (description.proposition == null) {
      return;
    }
    { Object old$PostoptimizationP$000 = Logic.$POSTOPTIMIZATIONp$.get();

      try {
        Native.setBooleanSpecial(Logic.$POSTOPTIMIZATIONp$, postoptimizationP);
        Proposition.simplifyProposition(description.proposition);

      } finally {
        Logic.$POSTOPTIMIZATIONp$.set(old$PostoptimizationP$000);
      }
    }
  }

  public static Description selectOptimalQueryPattern(Description description, BooleanVector booleanvector, ControlFrame parentframe) {
    { Description pattern = null;
      KeyValueList querypatterns = description.queryPatterns;

      if (querypatterns != null) {
        pattern = ((Description)(querypatterns.lookup(booleanvector)));
      }
      if (Stella_Object.traceKeywordP(Logic.KWD_OPTIMIZER)) {
        pattern = null;
      }
      if (pattern != null) {
        return (pattern);
      }
      if (querypatterns == null) {
        description.queryPatterns = KeyValueList.newKeyValueList();
      }
      { Object old$Boundtooffsetcounter$000 = Logic.$BOUNDTOOFFSETCOUNTER$.get();

        try {
          Native.setIntSpecial(Logic.$BOUNDTOOFFSETCOUNTER$, 0);
          pattern = Description.copyDescription(description, null, true);

        } finally {
          Logic.$BOUNDTOOFFSETCOUNTER$.set(old$Boundtooffsetcounter$000);
        }
      }
      description.queryPatterns.insertAt(booleanvector, pattern);
      if (!((!((!(Logic.$QUERY_OPTIMIZATION_STRATEGY$ == Logic.KWD_NONE)) &&
          (!((Logic.$QUERY_OPTIMIZATION_STRATEGY$ == Logic.KWD_DYNAMIC) ||
          (Logic.$QUERY_OPTIMIZATION_STRATEGY$ == Logic.KWD_DYNAMIC_WITH_CLUSTERING))))) ||
          (((BooleanWrapper)(KeyValueList.dynamicSlotValue(description.dynamicSlots, Logic.SYM_LOGIC_DONT_OPTIMIZEp, Stella.FALSE_WRAPPER))).wrapperValue ||
           (Proposition.containsOperatorP(description.proposition, Logic.SGT_PL_KERNEL_KB_CUT) ||
            Proposition.containsOperatorP(description.proposition, Logic.SGT_PL_KERNEL_KB_BOUND_VARIABLES))))) {
        Description.optimizeQuery(pattern, booleanvector, parentframe);
      }
      Description.simplifyDescription(pattern, true);
      return (pattern);
    }
  }

  public static void optimizeQuery(Description description, BooleanVector booleanvector, ControlFrame parentframe) {
    { ControlFrame frame = ControlFrame.createDownFrame(parentframe, null);
      int variablescount = description.ioVariables.length() + description.internalVariables.length() + (((((Vector)(KeyValueList.dynamicSlotValue(description.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null))) != null) ? ((Vector)(KeyValueList.dynamicSlotValue(description.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null))).length() : 0));

      Logic.initializeOptimizerMemory(variablescount);
      ControlFrame.createPatternRecord(frame, null, null);
      PatternRecord.activatePatternRecord(frame.patternRecord, variablescount);
      { PatternVariable iovar = null;
        Vector vector000 = description.ioVariables;
        int index000 = 0;
        int length000 = vector000.length();
        BooleanWrapper initiallyboundP = null;
        BooleanVector vector001 = booleanvector;
        int index001 = 0;
        int length001 = vector001.length();

        for (;(index000 < length000) &&
                  (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
          iovar = ((PatternVariable)((vector000.theArray)[index000]));
          initiallyboundP = ((BooleanWrapper)((vector001.theArray)[index001]));
          if (BooleanWrapper.coerceWrappedBooleanToBoolean(initiallyboundP)) {
            Logic.simulateBindVariableToValue(iovar);
          }
        }
      }
      { Object old$Queryoptimizercontrolframe$000 = Logic.$QUERYOPTIMIZERCONTROLFRAME$.get();

        try {
          Native.setSpecial(Logic.$QUERYOPTIMIZERCONTROLFRAME$, frame);
          Proposition.simulateAndOptimizeQuery(description.proposition);

        } finally {
          Logic.$QUERYOPTIMIZERCONTROLFRAME$.set(old$Queryoptimizercontrolframe$000);
        }
      }
      frame.state = Logic.KWD_PATTERN;
      ControlFrame.popDownFrame(parentframe);
    }
  }

  public static int accessObservedCardinality(Description self) {
    { Object old$Context$000 = Stella.$CONTEXT$.get();
      Object old$Module$000 = Stella.$MODULE$.get();

      try {
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
        { Stella_Object value = Logic.accessBinaryValue(self, Logic.SGT_PL_KERNEL_KB_OBSERVED_CARDINALITY_OF);

          if ((value != null) &&
              Stella_Object.isaP(value, Logic.SGT_STELLA_INTEGER_WRAPPER)) {
            return (((IntegerWrapper)(value)).wrapperValue);
          }
          else {
            return (Stella.NULL_INTEGER);
          }
        }

      } finally {
        Stella.$MODULE$.set(old$Module$000);
        Stella.$CONTEXT$.set(old$Context$000);
      }
    }
  }

  public static boolean computedConstraintP(Description self) {
    return (Logic.testPropertyP(self, Logic.SGT_PL_KERNEL_KB_COMPUTED) &&
        (Logic.accessBinaryValue(self, Logic.SGT_PL_KERNEL_KB_RELATION_CONSTRAINT) != null));
  }

  public static boolean computedTermP(Description self) {
    return (Logic.testPropertyP(self, Logic.SGT_PL_KERNEL_KB_COMPUTED));
  }

  public static void dropTaxonomyImpliesSubsumesLink(Description taildescription, Description headdescription) {
    {
      headdescription = headdescription;
      taildescription = taildescription;
    }
    return;
  }

  public static void addTaxonomyImpliesSubsumesLink(Description taildescription, Description headdescription) {
    return;
  }

  public static TaxonomyNode findOrCreateDescriptionImplicationSubsumptionNode(Description description) {
    { TaxonomyNode result = Description.findDescriptionImplicationSubsumptionNode(description);

      if (result != null) {
        return (result);
      }
      return (Description.createDescriptionImplicationSubsumptionNode(description, null));
    }
  }

  public static TaxonomyNode createDescriptionImplicationSubsumptionNode(Description description, TaxonomyNode parentnode) {
    { TaxonomyNode node = TaxonomyGraph.createTaxonomyNode(Logic.$IMPLICATION_SUBSUMPTION_GRAPH$, parentnode, description, parentnode == null);

      TaxonomyGraph.linkTaxonomyNodes(Logic.$IMPLICATION_SUBSUMPTION_GRAPH$, parentnode, node);
      KeyValueList.setDynamicSlotValue(description.dynamicSlots, Logic.SYM_STELLA_TAXONOMY_NODE, node, null);
      return (node);
    }
  }

  public static TaxonomyNode findDescriptionImplicationSubsumptionNode(Description description) {
    return (((TaxonomyNode)(KeyValueList.dynamicSlotValue(description.dynamicSlots, Logic.SYM_STELLA_TAXONOMY_NODE, null))));
  }

  public static Cons generateDescriptionsAsRule(Description head, Description tail, Proposition rule, boolean reversepolarityP) {
    { boolean forwardarrowP = ((BooleanWrapper)(KeyValueList.dynamicSlotValue(rule.dynamicSlots, Logic.SYM_LOGIC_FORWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue &&
          (!reversepolarityP);
      boolean reverseargumentsP = forwardarrowP ||
          reversepolarityP;
      Symbol arrow = Surrogate.symbolize(Proposition.chooseImplicationOperator(rule, forwardarrowP));
      boolean mapheadvariablesP = Description.namedDescriptionP(head);
      Stella_Object headprop = null;
      Stella_Object tailprop = null;
      Cons universals = Stella.NIL;

      if (reverseargumentsP) {
        { Description temp = head;

          head = tail;
          tail = temp;
        }
        mapheadvariablesP = !mapheadvariablesP;
      }
      { PatternVariable var = null;
        Vector vector000 = (mapheadvariablesP ? tail.ioVariables : head.ioVariables);
        int index000 = 0;
        int length000 = vector000.length();
        Cons collect000 = null;

        for (;index000 < length000; index000 = index000 + 1) {
          var = ((PatternVariable)((vector000.theArray)[index000]));
          if (collect000 == null) {
            {
              collect000 = Cons.cons(PatternVariable.generateOneVariable(var, true), Stella.NIL);
              if (universals == Stella.NIL) {
                universals = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(universals, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(PatternVariable.generateOneVariable(var, true), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      { Object old$Skolemnamemappingtable$000 = Logic.$SKOLEMNAMEMAPPINGTABLE$.get();

        try {
          Native.setSpecial(Logic.$SKOLEMNAMEMAPPINGTABLE$, (mapheadvariablesP ? ((KeyValueMap)(Logic.createSkolemMappingTable(head.ioVariables, tail.ioVariables))) : null));
          Logic.pushQuantifiedObject(head);
          headprop = Description.generateDescriptionProposition(head, reversepolarityP);
          Logic.popQuantifiedObject();

        } finally {
          Logic.$SKOLEMNAMEMAPPINGTABLE$.set(old$Skolemnamemappingtable$000);
        }
      }
      { Object old$Skolemnamemappingtable$001 = Logic.$SKOLEMNAMEMAPPINGTABLE$.get();

        try {
          Native.setSpecial(Logic.$SKOLEMNAMEMAPPINGTABLE$, ((!mapheadvariablesP) ? ((KeyValueMap)(Logic.createSkolemMappingTable(tail.ioVariables, head.ioVariables))) : null));
          Logic.pushQuantifiedObject(tail);
          tailprop = Description.generateDescriptionProposition(tail, reversepolarityP);
          Logic.popQuantifiedObject();

        } finally {
          Logic.$SKOLEMNAMEMAPPINGTABLE$.set(old$Skolemnamemappingtable$001);
        }
      }
      return (Cons.list$(Cons.cons(Logic.SYM_STELLA_FORALL, Cons.cons(universals, Cons.cons(Cons.cons(Cons.cons(arrow, Cons.cons(headprop, Cons.cons(tailprop, Stella.NIL))), Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons generateDescriptionProposition(Description self, boolean invertP) {
    { Stella_Object prop = Proposition.generateProposition(self.proposition);
      Cons existentals = (self.internalVariables.nonEmptyP() ? Description.topLevelExistentialVariables(self) : Stella.NIL);

      { Stella_Object var = null;
        Cons iter000 = existentals;
        int i = Stella.NULL_INTEGER;
        int iter001 = 0;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
          var = iter000.value;
          i = iter001;
          existentals.nthSetter(PatternVariable.generateOneVariable(((PatternVariable)(var)), true), i);
        }
      }
      if (!(existentals == Stella.NIL)) {
        prop = Cons.list$(Cons.cons(Logic.SYM_STELLA_EXISTS, Cons.cons(existentals, Cons.cons(Cons.cons(prop, Stella.NIL), Stella.NIL))));
      }
      if (invertP) {
        return (Cons.list$(Cons.cons(Logic.SYM_STELLA_NOT, Cons.cons(prop, Cons.cons(Stella.NIL, Stella.NIL)))));
      }
      else {
        return (((Cons)(prop)));
      }
    }
  }

  public static Stella_Object generateDescription(Description self) {
    if (Description.namedDescriptionP(self)) {
      return (Logic.internalStellaOperatorToKif(self.descriptionName()));
    }
    else if (((Description)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_COMPLEMENT_DESCRIPTION, null))) != null) {
      return (Cons.list$(Cons.cons(Logic.SYM_STELLA_NOT, Cons.cons(Logic.internalStellaOperatorToKif(((Description)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_COMPLEMENT_DESCRIPTION, null))).descriptionName()), Cons.cons(Stella.NIL, Stella.NIL)))));
    }
    else {
      Logic.pushQuantifiedObject(self);
      { Cons result = Cons.list$(Cons.cons(Logic.SYM_LOGIC_KAPPA, Cons.cons(Logic.generateQuantifiedVariables(self.ioVariables, true), Cons.cons(Cons.cons(Description.generateDescriptionProposition(self, false), Stella.NIL), Stella.NIL))));

        Logic.popQuantifiedObject();
        return (result);
      }
    }
  }

  public static void printDescription(Description self, OutputStream stream, boolean toplevelP) {
    if (self.deletedP()) {
      stream.nativeStream.print("|dElEtEd-description|");
      if (self.surrogateValueInverse != null) {
        stream.nativeStream.print(self.surrogateValueInverse);
      }
      return;
    }
    if (((Boolean)(Logic.$LOADINGREGENERABLEOBJECTSp$.get())).booleanValue() ||
        (BooleanWrapper.coerceWrappedBooleanToBoolean(self.badP()) ||
         Logic.$DEBUG_PRINT_MODEp$)) {
      stream.nativeStream.print("|d|");
    }
    else if (toplevelP &&
        (!((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue())) {
      if (Logic.classP(self)) {
        stream.nativeStream.print("|c|");
      }
      else if (Logic.functionP(self)) {
        stream.nativeStream.print("|f|");
      }
      else if (Logic.relationP(self)) {
        stream.nativeStream.print("|r|");
      }
      else {
        stream.nativeStream.print("|d|");
      }
    }
    Logic.printLogicalForm(self, stream);
  }

  public static void printDescriptionsAsKifRule(Description head, Description tail, Proposition rule, boolean reversepolarityP) {
    { OutputStream stream = ((OutputStream)(Logic.$PRINTLOGICALFORMSTREAM$.get()));
      boolean forwardarrowP = ((BooleanWrapper)(KeyValueList.dynamicSlotValue(rule.dynamicSlots, Logic.SYM_LOGIC_FORWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue &&
          (!reversepolarityP);
      boolean reverseargumentsP = forwardarrowP ||
          reversepolarityP;
      int currentindentcounter = ((Integer)(Logic.$INDENTCOUNTER$.get())).intValue();
      Surrogate operatorprefix = Proposition.chooseImplicationOperator(rule, forwardarrowP);
      int operatorprefixindent = 2 + (operatorprefix.symbolName).length();
      boolean mapheadvariablesP = Description.namedDescriptionP(head);
      Vector ruleVariables = ((Vector)(KeyValueList.dynamicSlotValue(rule.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
      KeyValueMap headvariablemapping = null;
      KeyValueMap tailvariablemapping = null;

      if (head.deletedP() ||
          tail.deletedP()) {
        stream.nativeStream.print("(=> <DeLeTeD ArGuMeNt(S)>)");
        return;
      }
      if (reverseargumentsP) {
        { Description temp = head;

          head = tail;
          tail = temp;
        }
        mapheadvariablesP = !mapheadvariablesP;
      }
      if (ruleVariables != null) {
        headvariablemapping = ((KeyValueMap)(Logic.createSkolemMappingTable(head.ioVariables, ruleVariables)));
        tailvariablemapping = ((KeyValueMap)(Logic.createSkolemMappingTable(tail.ioVariables, ruleVariables)));
      }
      else if (mapheadvariablesP) {
        ruleVariables = tail.ioVariables;
        headvariablemapping = ((KeyValueMap)(Logic.createSkolemMappingTable(head.ioVariables, ruleVariables)));
      }
      else {
        ruleVariables = head.ioVariables;
        tailvariablemapping = ((KeyValueMap)(Logic.createSkolemMappingTable(tail.ioVariables, ruleVariables)));
      }
      { Object old$Indentcounter$000 = Logic.$INDENTCOUNTER$.get();

        try {
          Native.setIntSpecial(Logic.$INDENTCOUNTER$, currentindentcounter);
          stream.nativeStream.print("(" + Logic.stringifiedSurrogate(Logic.SGT_PL_KERNEL_KB_FORALL) + " ");
          Logic.printKifQuantifiedVariables(ruleVariables, false);
          stream.nativeStream.println();
          Logic.increaseIndent(Stella.NULL_INTEGER);
          Logic.printIndent(stream, Stella.NULL_INTEGER);
          stream.nativeStream.print("(" + Logic.stringifiedSurrogate(operatorprefix) + " ");
          Logic.increaseIndent(operatorprefixindent);
          Logic.pushQuantifiedObject(head);
          { Object old$Skolemnamemappingtable$000 = Logic.$SKOLEMNAMEMAPPINGTABLE$.get();

            try {
              Native.setSpecial(Logic.$SKOLEMNAMEMAPPINGTABLE$, headvariablemapping);
              Description.printKifDescriptionProposition(head, reversepolarityP);

            } finally {
              Logic.$SKOLEMNAMEMAPPINGTABLE$.set(old$Skolemnamemappingtable$000);
            }
          }
          Logic.popQuantifiedObject();
          stream.nativeStream.println();
          Logic.printIndent(stream, Stella.NULL_INTEGER);
          Logic.pushQuantifiedObject(tail);
          { Object old$Skolemnamemappingtable$001 = Logic.$SKOLEMNAMEMAPPINGTABLE$.get();

            try {
              Native.setSpecial(Logic.$SKOLEMNAMEMAPPINGTABLE$, tailvariablemapping);
              Description.printKifDescriptionProposition(tail, reversepolarityP);

            } finally {
              Logic.$SKOLEMNAMEMAPPINGTABLE$.set(old$Skolemnamemappingtable$001);
            }
          }
          Logic.popQuantifiedObject();
          stream.nativeStream.print("))");
          Logic.decreaseIndent(operatorprefixindent);
          Logic.decreaseIndent(Stella.NULL_INTEGER);

        } finally {
          Logic.$INDENTCOUNTER$.set(old$Indentcounter$000);
        }
      }
    }
  }

  public static void printKifDescriptionProposition(Description self, boolean invertP) {
    { OutputStream stream = ((OutputStream)(Logic.$PRINTLOGICALFORMSTREAM$.get()));
      Vector existentials = (self.internalVariables.nonEmptyP() ? Logic.copyConsListToVariablesVector(Description.topLevelExistentialVariables(self)) : Logic.ZERO_VARIABLES_VECTOR);

      if (invertP) {
        stream.nativeStream.print("(" + Logic.stringifiedSurrogate(Logic.SGT_PL_KERNEL_KB_NOT) + " ");
        Logic.increaseIndent(4);
      }
      if (existentials.nonEmptyP()) {
        stream.nativeStream.print("(" + Logic.stringifiedSurrogate(Logic.SGT_PL_KERNEL_KB_EXISTS) + " ");
        Logic.printKifQuantifiedVariables(existentials, false);
        stream.nativeStream.println();
        Logic.increaseIndent(Stella.NULL_INTEGER);
        Logic.printIndent(stream, Stella.NULL_INTEGER);
      }
      Logic.printAsKifInternal(self.proposition);
      if (existentials.nonEmptyP()) {
        stream.nativeStream.print(")");
        Logic.decreaseIndent(Stella.NULL_INTEGER);
      }
      if (invertP) {
        stream.nativeStream.print(")");
        Logic.decreaseIndent(4);
      }
    }
  }

  public static void printKifDescription(Description self) {
    { Object old$Queryiterator$000 = Logic.$QUERYITERATOR$.get();

      try {
        Native.setSpecial(Logic.$QUERYITERATOR$, null);
        Logic.pushQuantifiedObject(self);
        { OutputStream stream = ((OutputStream)(Logic.$PRINTLOGICALFORMSTREAM$.get()));
          Description complement = ((Description)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_COMPLEMENT_DESCRIPTION, null)));

          if (self.surrogateValueInverse != null) {
            stream.nativeStream.print(Logic.stringifiedSurrogate(self.surrogateValueInverse));
          }
          else if ((complement != null) &&
              ((complement.surrogateValueInverse != null) &&
               (!((((Keyword)(Logic.$PRINTMODE$.get())) == Logic.KWD_REALISTIC) ||
              (((Keyword)(Logic.$PRINTMODE$.get())) == Logic.KWD_ORIGINAL))))) {
            stream.nativeStream.print("not-" + Logic.stringifiedSurrogate(complement.surrogateValueInverse));
          }
          else {
            stream.nativeStream.print("(" + Logic.stringifiedSurrogate(Logic.SGT_PL_KERNEL_KB_KAPPA) + " ");
            Logic.printKifQuantifiedVariables(self.ioVariables, true);
            stream.nativeStream.print(" ");
            Description.printKifDescriptionProposition(self, false);
            stream.nativeStream.print(")");
          }
          Logic.popQuantifiedObject();
        }

      } finally {
        Logic.$QUERYITERATOR$.set(old$Queryiterator$000);
      }
    }
  }

  public static Iterator allocateAntecedentsIterator(Description goaldescription, Vector externalarguments, boolean reversepolarityP) {
    { Cons antecedents = Stella.NIL;
      LogicObject antecedent = null;
      boolean incompatibleargumentsP = false;

      { Proposition prop = null;
        Cons iter000 = LogicObject.applicableRulesOfDescription(goaldescription, (reversepolarityP ? Logic.KWD_FORWARD : Logic.KWD_BACKWARD), false);

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          prop = ((Proposition)(iter000.value));
          if (((reversepolarityP ? (!((BooleanWrapper)(KeyValueList.dynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_BACKWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue) : (!((BooleanWrapper)(KeyValueList.dynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_FORWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue))) &&
              ((!reversepolarityP) ||
               (Description.atomicGoalDescriptionP(((Description)((prop.arguments.theArray)[1]))) ||
                Logic.closedTermP((prop.arguments.theArray)[1])))) {
            antecedent = (reversepolarityP ? ((LogicObject)((prop.arguments.theArray)[1])) : ((LogicObject)((prop.arguments.theArray)[0])));
            if ((!Stella_Object.isaP(antecedent, Logic.SGT_LOGIC_DESCRIPTION)) ||
                (!(externalarguments.length() == ((Description)(antecedent)).ioVariables.length()))) {
              continue loop000;
            }
            incompatibleargumentsP = false;
            { PatternVariable v = null;
              Vector vector000 = ((Description)(antecedent)).ioVariables;
              int index000 = 0;
              int length000 = vector000.length();
              Stella_Object arg = null;
              Vector vector001 = externalarguments;
              int index001 = 0;
              int length001 = vector001.length();

              loop001 : for (;(index000 < length000) &&
                        (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
                v = ((PatternVariable)((vector000.theArray)[index000]));
                arg = (vector001.theArray)[index001];
                { Stella_Object argvalue = Logic.argumentBoundTo(arg);
                  Stella_Object varvalue = Logic.groundValueOf(v);

                  if ((argvalue != null) &&
                      (((varvalue != null) &&
                      (!Stella_Object.eqlP(argvalue, varvalue))) ||
                       ((varvalue == null) &&
                        PatternVariable.failsAntecedentTypeCheckP(v, argvalue)))) {
                    incompatibleargumentsP = true;
                    break loop001;
                  }
                }
              }
            }
            if (!incompatibleargumentsP) {
              antecedents = Cons.cons(prop, antecedents);
            }
          }
        }
      }
      if (antecedents == Stella.NIL) {
        return (null);
      }
      else {
        return (Logic.optimizeOrderOfApplicableRules(antecedents, !reversepolarityP).allocateIterator());
      }
    }
  }

  /** Apply (inherit) the description 'description'
   * to members of the vector 'vector'.  Return TRUE if no clash was detected.
   * Constraint propagation happens only if it is enabled prior to calling
   * 'apply-kappa?'.
   * @param description
   * @param vector
   * @return boolean
   */
  public static boolean applyKappaP(Description description, Vector vector) {
    try {
      Logic.inheritUnnamedDescription(vector, description, false);
    } catch (Clash e) {
      Stella.STANDARD_ERROR.nativeStream.println(Stella.exceptionMessage(e));
      return (false);
    }
    return (true);
  }

  public static TruthValue descriptionSpecializesDescriptionP(Description sub, Description renamed_Super) {
    if (!(sub.arity() == renamed_Super.arity())) {
      if (((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue()) {
        return (Logic.TRUE_TRUTH_VALUE);
      }
      else {
        return (Logic.FALSE_TRUTH_VALUE);
      }
    }
    if (((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue()) {
      return (Logic.UNKNOWN_TRUTH_VALUE);
    }
    if (LogicObject.collectionImpliesCollectionP(sub, renamed_Super)) {
      return (Logic.TRUE_TRUTH_VALUE);
    }
    if (renamed_Super.arity() == 1) {
      return (Description.unaryDescriptionSpecializesDescriptionP(sub, renamed_Super));
    }
    { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

      try {
        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
        if ((Stella.$TRACED_KEYWORDS$ != null) &&
            Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_TREE)) {
          {
            Stella.STANDARD_OUTPUT.nativeStream.println();
            Stella.STANDARD_OUTPUT.nativeStream.println("Subsumption Test:");
            Stella.STANDARD_OUTPUT.nativeStream.println("   sub=" + sub);
            Stella.STANDARD_OUTPUT.nativeStream.println("   super=" + renamed_Super);
          }
;
        }

      } finally {
        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
      }
    }
    { Vector skolemsvector = Vector.newVector(sub.ioVariables.length());
      TruthValue result = Logic.UNKNOWN_TRUTH_VALUE;

      Logic.pushMonotonicWorld();
      Logic.initializeInferenceWorld(((World)(((Context)(Stella.$CONTEXT$.get())))));
      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = skolemsvector.length() - 1;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          (skolemsvector.theArray)[i] = (Logic.createHypothesizedInstance("anonymous"));
        }
      }
      try {
        Logic.inheritDescription(skolemsvector, sub, false);
        result = Logic.callAsk(Description.createQueryIterator(renamed_Super, skolemsvector));
      } catch (LogicException e) {
        Stella.STANDARD_ERROR.nativeStream.print(Stella.exceptionMessage(e));
      }
      Stella.popWorld();
      if ((Stella.$TRACED_KEYWORDS$ != null) &&
          Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_TREE)) {
        Stella.STANDARD_OUTPUT.nativeStream.println();
      }
      return (result);
    }
  }

  public static TruthValue unaryDescriptionSpecializesDescriptionP(Description sub, Description renamed_Super) {
    if (((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue()) {
      return (Logic.UNKNOWN_TRUTH_VALUE);
    }
    if (LogicObject.collectionImpliesCollectionP(sub, renamed_Super)) {
      return (Logic.TRUE_TRUTH_VALUE);
    }
    { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

      try {
        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
        if ((Stella.$TRACED_KEYWORDS$ != null) &&
            Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_TREE)) {
          {
            Stella.STANDARD_OUTPUT.nativeStream.println();
            Stella.STANDARD_OUTPUT.nativeStream.println("Prototype Subsumption Test:");
            Stella.STANDARD_OUTPUT.nativeStream.println("   sub=" + sub);
            Stella.STANDARD_OUTPUT.nativeStream.println("   super=" + renamed_Super);
          }
;
        }

      } finally {
        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
      }
    }
    { TruthValue result = Logic.UNKNOWN_TRUTH_VALUE;

      try {
        { Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Stella.$CONTEXT$, Logic.getInferenceCache(((Module)(Stella.$MODULE$.get())), Logic.KWD_META));
            result = Logic.callAsk(Description.createQueryIterator(renamed_Super, Stella.vector(Cons.cons(Description.getPrototype(sub), Stella.NIL))));

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
          }
        }
      } catch (LogicException e) {
        Stella.STANDARD_ERROR.nativeStream.print(Stella.exceptionMessage(e));
      }
      if ((Stella.$TRACED_KEYWORDS$ != null) &&
          Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_TREE)) {
        Stella.STANDARD_OUTPUT.nativeStream.println();
      }
      return (result);
    }
  }

  public static LogicObject getPrototype(Description description) {
    if (description == null) {
      return (null);
    }
    { Stella_Object prototype = Logic.accessBinaryValue(description, Logic.SGT_PL_KERNEL_KB_CONCEPT_PROTOTYPE);

      if (prototype == null) {
        prototype = Logic.applyCachedRetrieve(Cons.list$(Cons.cons(Logic.SYM_LOGIC_pC, Cons.cons(Logic.SYM_LOGIC_pP, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.list$(Cons.cons(Logic.SYM_PL_KERNEL_KB_CONCEPT_PROTOTYPE, Cons.cons(Logic.SYM_LOGIC_pC, Cons.cons(Logic.SYM_LOGIC_pP, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.consList(Cons.cons(description, Cons.cons(null, Stella.NIL))), Cons.consList(Stella.NIL), Logic.SYM_LOGIC_F_GET_PROTOTYPE_QUERY_000, new Object[2]).value;
      }
      { Object old$Evaluationmode$000 = Logic.$EVALUATIONMODE$.get();
        Object old$Queryiterator$000 = Logic.$QUERYITERATOR$.get();

        try {
          Native.setSpecial(Logic.$EVALUATIONMODE$, Logic.KWD_EXTENSIONAL_ASSERTION);
          Native.setSpecial(Logic.$QUERYITERATOR$, null);
          Logic.elaborateMetaInstance(prototype);
          return (((LogicObject)(prototype)));

        } finally {
          Logic.$QUERYITERATOR$.set(old$Queryiterator$000);
          Logic.$EVALUATIONMODE$.set(old$Evaluationmode$000);
        }
      }
    }
  }

  public static QueryIterator createQueryIterator(Description description, Vector outsidebindings) {
    return (QueryIterator.initializeQueryIterator(Logic.allocateQueryIterator(), description, outsidebindings));
  }

  public static boolean expensiveDisjointTermsP(Description d1, Description d2) {
    return (Logic.applyCachedAsk(Cons.list$(Cons.cons(Logic.SYM_LOGIC_pD1, Cons.cons(Logic.SYM_LOGIC_pD2, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.list$(Cons.cons(Logic.SYM_STELLA_OR, Cons.cons(Cons.list$(Cons.cons(Logic.SYM_LOGIC_DISJOINT, Cons.cons(Logic.SYM_LOGIC_pD1, Cons.cons(Logic.SYM_LOGIC_pD2, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_STELLA_AND, Cons.cons(Cons.list$(Cons.cons(Logic.SYM_PL_KERNEL_KB_CLASS, Cons.cons(Logic.SYM_LOGIC_pD1, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_PL_KERNEL_KB_CLASS, Cons.cons(Logic.SYM_LOGIC_pD2, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_LOGIC_REFUTATION_DISJOINT, Cons.cons(Logic.SYM_LOGIC_pD1, Cons.cons(Logic.SYM_LOGIC_pD2, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.consList(Cons.cons(d1, Cons.cons(d2, Stella.NIL))), Cons.consList(Stella.NIL), Logic.SYM_LOGIC_F_EXPENSIVE_DISJOINT_TERMSp_QUERY_000, new Object[1]));
  }

  /** Return TRUE if 'd1' and 'd2' belong to disjoint partitions.
   * @param d1
   * @param d2
   * @return boolean
   */
  public static boolean disjointTermsP(Description d1, Description d2) {
    if (Logic.SGT_PL_KERNEL_KB_PARTITION_MEMBERSHIP.surrogateValue == null) {
      return (false);
    }
    if (Logic.$CYC_KLUDGES_ENABLEDp$) {
      if (Stella_Object.isaP(d1, Logic.SGT_LOGIC_NAMED_DESCRIPTION) &&
          Stella_Object.isaP(d2, Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
        return (TruthValue.trueTruthValueP(Logic.evaluateSelectionPattern(Logic.makeRelationPattern2(Logic.SGT_PL_KERNEL_KB_DISJOINT, d1, d2))));
      }
    }
    { List tracedkeywords = Stella.$TRACED_KEYWORDS$;
      boolean disjointP = false;

      if (!(Logic.$TRACE_DISJOINTNESS_SUBGOALSp$)) {
        Stella.$TRACED_KEYWORDS$ = null;
      }
      { Object old$Evaluationmode$000 = Logic.$EVALUATIONMODE$.get();

        try {
          Native.setSpecial(Logic.$EVALUATIONMODE$, Logic.KWD_EXTENSIONAL_ASSERTION);
          { MemoizationTable memoTable000 = null;
            Cons memoizedEntry000 = null;
            Stella_Object memoizedValue000 = null;

            if (Stella.$MEMOIZATION_ENABLEDp$) {
              memoTable000 = ((MemoizationTable)(Logic.SGT_LOGIC_F_DISJOINT_TERMSp_MEMO_TABLE_000.surrogateValue));
              if (memoTable000 == null) {
                Surrogate.initializeMemoizationTable(Logic.SGT_LOGIC_F_DISJOINT_TERMSp_MEMO_TABLE_000, "(:MAX-VALUES 10000 :TIMESTAMPS (:META-KB-UPDATE))");
                memoTable000 = ((MemoizationTable)(Logic.SGT_LOGIC_F_DISJOINT_TERMSp_MEMO_TABLE_000.surrogateValue));
              }
              memoizedEntry000 = MruMemoizationTable.lookupMruMemoizedValue(((MruMemoizationTable)(memoTable000)), d1, d2, ((Context)(Stella.$CONTEXT$.get())), Stella.MEMOIZED_NULL_VALUE, -1);
              memoizedValue000 = memoizedEntry000.value;
            }
            if (memoizedValue000 != null) {
              if (memoizedValue000 == Stella.MEMOIZED_NULL_VALUE) {
                memoizedValue000 = null;
              }
            }
            else {
              memoizedValue000 = (Logic.applyCachedAsk(Cons.list$(Cons.cons(Logic.SYM_LOGIC_pD1, Cons.cons(Logic.SYM_LOGIC_pD2, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.list$(Cons.cons(Logic.SYM_LOGIC_DISJOINT, Cons.cons(Logic.SYM_LOGIC_pD1, Cons.cons(Logic.SYM_LOGIC_pD2, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.consList(Cons.cons(d1, Cons.cons(d2, Stella.NIL))), Cons.consList(Stella.NIL), Logic.SYM_LOGIC_F_DISJOINT_TERMSp_QUERY_001, new Object[1]) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
              if (Stella.$MEMOIZATION_ENABLEDp$) {
                memoizedEntry000.value = ((memoizedValue000 == null) ? Stella.MEMOIZED_NULL_VALUE : memoizedValue000);
              }
            }
            disjointP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(memoizedValue000)));
          }

        } finally {
          Logic.$EVALUATIONMODE$.set(old$Evaluationmode$000);
        }
      }
      Stella.$TRACED_KEYWORDS$ = tracedkeywords;
      return (disjointP);
    }
  }

  public static boolean checkForSingleValuedGoalP(Description pattern, Cons iobindings) {
    { Cons iovariables = Stella.NIL;
      Cons boundvariables = Stella.NIL;

      { PatternVariable vbl = null;
        Vector vector000 = pattern.ioVariables;
        int index000 = 0;
        int length000 = vector000.length();
        Cons collect000 = null;

        for (;index000 < length000; index000 = index000 + 1) {
          vbl = ((PatternVariable)((vector000.theArray)[index000]));
          if (collect000 == null) {
            {
              collect000 = Cons.cons(vbl, Stella.NIL);
              if (iovariables == Stella.NIL) {
                iovariables = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(iovariables, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(vbl, Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      { Stella_Object v1 = null;
        Cons iter000 = iovariables;
        Stella_Object v2 = null;
        Cons iter001 = iobindings;

        for (;(!(iter000 == Stella.NIL)) &&
                  (!(iter001 == Stella.NIL)); iter000 = iter000.rest, iter001 = iter001.rest) {
          v1 = iter000.value;
          v2 = iter001.value;
          if (v2 != null) {
            boundvariables = Cons.cons(v1, boundvariables);
          }
        }
      }
      return (Proposition.singleValuedGoalP(pattern.proposition, iovariables, boundvariables));
    }
  }

  public static Description instantiateExternalVariables(Description self, KeyValueMap bindings) {
    if (!(bindings.emptyP())) {
      { Object old$Evaluationmode$000 = Logic.$EVALUATIONMODE$.get();
        Object old$Queryiterator$000 = Logic.$QUERYITERATOR$.get();

        try {
          Native.setSpecial(Logic.$EVALUATIONMODE$, Logic.KWD_DESCRIPTION);
          Native.setSpecial(Logic.$QUERYITERATOR$, null);
          { Description description = Description.newDescription();

            { Stella_Object var = null;
              Stella_Object binding = null;
              DictionaryIterator iter000 = ((DictionaryIterator)(bindings.allocateIterator()));

              while (iter000.nextP()) {
                var = iter000.key;
                binding = iter000.value;
                bindings.insertAt(var, Logic.evaluateTerm(binding));
              }
            }
            description.ioVariables = self.ioVariables.copy();
            { PatternVariable var = null;
              Vector vector000 = self.ioVariables;
              int index000 = 0;
              int length000 = vector000.length();

              for (;index000 < length000; index000 = index000 + 1) {
                var = ((PatternVariable)((vector000.theArray)[index000]));
                bindings.insertAt(var, var);
              }
            }
            { PatternVariable var = null;
              Vector vector001 = ((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null)));
              int index001 = 0;
              int length001 = vector001.length();

              for (;index001 < length001; index001 = index001 + 1) {
                var = ((PatternVariable)((vector001.theArray)[index001]));
                if (bindings.lookup(var) == null) {
                  bindings.insertAt(var, var);
                }
              }
            }
            { PatternVariable var = null;
              Vector vector002 = self.internalVariables;
              int index002 = 0;
              int length002 = vector002.length();

              for (;index002 < length002; index002 = index002 + 1) {
                var = ((PatternVariable)((vector002.theArray)[index002]));
                bindings.insertAt(var, var);
              }
            }
            description.proposition = Proposition.inheritProposition(self.proposition, bindings);
            return (Description.finishBuildingDescription(description, true, Logic.KWD_TOP_LEVEL));
          }

        } finally {
          Logic.$QUERYITERATOR$.set(old$Queryiterator$000);
          Logic.$EVALUATIONMODE$.set(old$Evaluationmode$000);
        }
      }
    }
    return (self);
  }

  public static PatternVariable variableFromUnbindingOffset(Description description, int uboffset) {
    { PatternRecord patternrecord = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord;
      int offset = ((IntegerWrapper)((patternrecord.unbindingStack.theArray)[uboffset])).wrapperValue;

      { PatternVariable vbl = null;
        Vector vector000 = description.ioVariables;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          vbl = ((PatternVariable)((vector000.theArray)[index000]));
          if (vbl.boundToOffset == offset) {
            return (vbl);
          }
        }
      }
      { PatternVariable vbl = null;
        Vector vector001 = description.internalVariables;
        int index001 = 0;
        int length001 = vector001.length();

        for (;index001 < length001; index001 = index001 + 1) {
          vbl = ((PatternVariable)((vector001.theArray)[index001]));
          if (vbl.boundToOffset == offset) {
            return (vbl);
          }
        }
      }
      return (null);
    }
  }

  public static Cons helpGetForwardChainingRules(Description description) {
    { Cons rules = Stella.NIL;

      { ForwardChainingIndex idx = null;
        Cons iter000 = description.forwardChainingIndices().theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          idx = ((ForwardChainingIndex)(iter000.value));
          if (!idx.masterRule.deletedP()) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(idx.masterRule, Stella.NIL);
                if (rules == Stella.NIL) {
                  rules = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(rules, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(idx.masterRule, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      return (rules);
    }
  }

  public static Description getInferableComplementDescription(Description self) {
    { Description complement = ((Description)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_COMPLEMENT_DESCRIPTION, null)));

      if (Logic.$LAZY_SATELLITE_RULESp$) {
        if ((complement == null) &&
            BooleanWrapper.coerceWrappedBooleanToBoolean(self.deferredContrapositivesP())) {
          complement = NamedDescription.getComplementOfGoalDescription(((NamedDescription)(self)));
        }
        if (BooleanWrapper.coerceWrappedBooleanToBoolean(self.deferredContrapositivesP())) {
          Description.deriveDeferredSatelliteRules(self);
          KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DEFERRED_CONTRAPOSITIVESp, null, null);
        }
      }
      return (complement);
    }
  }

  public static void deriveDeferredContrapositiveSatelliteRules(Description self) {
    if (Logic.$LAZY_SATELLITE_RULESp$) {
      if (BooleanWrapper.coerceWrappedBooleanToBoolean(self.deferredContrapositivesP())) {
        { Proposition masterproposition = null;
          List queuedrules = List.newList();

          { Proposition prop = null;
            Iterator iter000 = Logic.unfilteredDependentImpliesPropositions(self).allocateIterator();

            while (iter000.nextP()) {
              prop = ((Proposition)(iter000.value));
              if (prop.kind == Logic.KWD_IMPLIES) {
                masterproposition = ((Proposition)(KeyValueList.dynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_MASTER_PROPOSITION, null)));
                if ((masterproposition != null) &&
                    (!masterproposition.deletedP())) {
                  queuedrules.insertNew(masterproposition);
                }
              }
            }
          }
          { Proposition forallprop = null;
            Cons iter001 = queuedrules.theConsList;

            for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              forallprop = ((Proposition)(iter001.value));
              Proposition.deriveSatelliteRulesForGoalP(forallprop, self, Logic.KWD_CONTRAPOSITIVE, false);
            }
          }
        }
      }
    }
  }

  public static void deriveDeferredSatelliteRules(Description self) {
    if (Logic.$LAZY_SATELLITE_RULESp$) {
      { Object old$DeriveDeferredSatelliteRulesInvocations$000 = Logic.$DERIVE_DEFERRED_SATELLITE_RULES_INVOCATIONS$.get();

        try {
          Native.setSpecial(Logic.$DERIVE_DEFERRED_SATELLITE_RULES_INVOCATIONS$, ((List)(((((List)(Logic.$DERIVE_DEFERRED_SATELLITE_RULES_INVOCATIONS$.get())) == null) ? List.newList() : ((List)(Logic.$DERIVE_DEFERRED_SATELLITE_RULES_INVOCATIONS$.get()))))));
          if (((List)(Logic.$DERIVE_DEFERRED_SATELLITE_RULES_INVOCATIONS$.get())).membP(self)) {
            return;
          }
          ((List)(Logic.$DERIVE_DEFERRED_SATELLITE_RULES_INVOCATIONS$.get())).insert(self);
          if ((((SequenceIndex)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_RULES_WITH_DEFERRED_SATELLITES, null))) == null) &&
              (((Description)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_COMPLEMENT_DESCRIPTION, null))) == null)) {
            return;
          }
          { SequenceIndex queuedrules = ((SequenceIndex)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_RULES_WITH_DEFERRED_SATELLITES, null)));
            Description complement = ((Description)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_COMPLEMENT_DESCRIPTION, null)));

            if (queuedrules != null) {
              { Proposition forallprop = null;
                Iterator iter000 = queuedrules.allocateIterator();

                while (iter000.nextP()) {
                  forallprop = ((Proposition)(iter000.value));
                  Proposition.deriveSatelliteRulesForGoalP(forallprop, self, ((complement == null) ? Logic.KWD_POSITIVE : Logic.KWD_POSITIVE_AND_CONTRAPOSITIVE), false);
                }
              }
              if (complement != null) {
                KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DEFERRED_CONTRAPOSITIVESp, null, null);
              }
              KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_RULES_WITH_DEFERRED_SATELLITES, null, null);
            }
            if ((complement != null) &&
                (((SequenceIndex)(KeyValueList.dynamicSlotValue(complement.dynamicSlots, Logic.SYM_LOGIC_RULES_WITH_DEFERRED_SATELLITES, null))) != null)) {
              Description.deriveDeferredSatelliteRules(complement);
            }
          }

        } finally {
          Logic.$DERIVE_DEFERRED_SATELLITE_RULES_INVOCATIONS$.set(old$DeriveDeferredSatelliteRulesInvocations$000);
        }
      }
    }
  }

  public static boolean atomicGoalDescriptionP(Description description) {
    if (Description.namedDescriptionP(description)) {
      return (true);
    }
    { Description complement = ((Description)(KeyValueList.dynamicSlotValue(description.dynamicSlots, Logic.SYM_LOGIC_COMPLEMENT_DESCRIPTION, null)));

      if ((complement != null) &&
          Description.namedDescriptionP(complement)) {
        return (true);
      }
      else {
        return (Proposition.atomicGoalPropositionP(description.proposition));
      }
    }
  }

  public static Proposition extractProposition(Description self, KeyValueMap mapping) {
    { Proposition proposition = self.proposition;
      Cons existentials = (self.internalVariables.nonEmptyP() ? Description.topLevelExistentialVariables(self) : Stella.NIL);
      Proposition existsproposition = ((!(existentials == Stella.NIL)) ? Logic.createProposition(Logic.SYM_STELLA_EXISTS, 1) : ((Proposition)(null)));

      if (existsproposition != null) {
        KeyValueList.setDynamicSlotValue(existsproposition.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, Logic.copyVariablesVector(Logic.copyConsListToVariablesVector(existentials), mapping), null);
      }
      proposition = Proposition.copyProposition(proposition, mapping);
      mapping.removeAt(self.proposition);
      if (existsproposition != null) {
        (existsproposition.arguments.theArray)[0] = proposition;
        proposition = existsproposition;
      }
      return (proposition);
    }
  }

  public static KeyValueList inferVariableTypesInDescription(Description description) {
    { Cons visiblevariables = Stella.NIL;

      { PatternVariable v = null;
        Vector vector000 = description.ioVariables;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          v = ((PatternVariable)((vector000.theArray)[index000]));
          visiblevariables = Cons.cons(v, visiblevariables);
        }
      }
      { PatternVariable v = null;
        Cons iter000 = Description.topLevelExistentialVariables(description);

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          v = ((PatternVariable)(iter000.value));
          visiblevariables = Cons.cons(v, visiblevariables);
        }
      }
      return (Proposition.inferVariableTypesInProposition(description.proposition, visiblevariables));
    }
  }

  public static Cons topLevelExistentialVariables(Description self) {
    { List quantifiedvariables = List.newList();
      List beenthere = List.newList();
      List collection = List.newList();

      { PatternVariable v = null;
        Vector vector000 = self.ioVariables;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          v = ((PatternVariable)((vector000.theArray)[index000]));
          quantifiedvariables.insert(v);
        }
      }
      if (((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null))) != null) {
        { PatternVariable v = null;
          Vector vector001 = ((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null)));
          int index001 = 0;
          int length001 = vector001.length();

          for (;index001 < length001; index001 = index001 + 1) {
            v = ((PatternVariable)((vector001.theArray)[index001]));
            quantifiedvariables.insert(v);
          }
        }
      }
      if (self.proposition == null) {
        return (quantifiedvariables.theConsList);
      }
      Logic.collectFreeVariables(self.proposition, collection, quantifiedvariables, beenthere);
      quantifiedvariables.free();
      beenthere.free();
      return (collection.theConsList);
    }
  }

  public static Description finishBuildingDescription(Description description, boolean checkforduplicateP, Keyword kind) {
    { Proposition proposition = description.proposition;

      Proposition.normalizeProposition(proposition);
      if (proposition.kind == Logic.KWD_EXISTS) {
        proposition = ((Proposition)((proposition.arguments.theArray)[0]));
        description.proposition = proposition;
      }
      Logic.resolveUnresolvedSlotReferences(description);
      Proposition.updateSkolemTypeFromIsaAssertions(proposition);
      Proposition.normalizeDescriptiveProposition(proposition, description.ioVariables, kind);
      Proposition.recursivelyFastenDownPropositions(proposition, true);
      Description.computeInternalVariables(description);
      if (checkforduplicateP) {
        { Description duplicatedescription = Description.findDuplicateDescription(description);

          if (duplicatedescription != null) {
            description = duplicatedescription;
          }
        }
      }
      return (description);
    }
  }

  public static void computeInternalVariables(Description self) {
    { List collection = List.newList();
      List beenthere = List.newList();

      Proposition.collectAllVariables(self.proposition, collection, beenthere);
      { PatternVariable vbl = null;
        Vector vector000 = self.ioVariables;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          vbl = ((PatternVariable)((vector000.theArray)[index000]));
          collection.remove(vbl);
        }
      }
      if (((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null))) != null) {
        { PatternVariable vbl = null;
          Vector vector001 = ((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null)));
          int index001 = 0;
          int length001 = vector001.length();

          for (;index001 < length001; index001 = index001 + 1) {
            vbl = ((PatternVariable)((vector001.theArray)[index001]));
            collection.remove(vbl);
          }
        }
      }
      self.internalVariables = Logic.copyConsListToVariablesVector(collection.theConsList);
      collection.free();
      beenthere.free();
    }
  }

  public static Description findDuplicateDescription(Description self) {
    if (Description.namedDescriptionP(self)) {
      return (null);
    }
    else {
      { LogicObject temp000 = self.findDuplicateNamedDescription();

        { LogicObject value000 = ((temp000 != null) ? temp000 : Description.findDuplicateComplexDescription(self));

          return (((Description)(value000)));
        }
      }
    }
  }

  public static Description findDuplicateComplexDescription(Description self) {
    { IntegerWrapper index = IntegerWrapper.wrapInteger(Proposition.propositionHashIndex(self.proposition, null, false));
      List bucket = ((List)(Logic.$STRUCTURED_OBJECTS_INDEX$.lookup(index)));
      Module homemodule = self.homeContext.baseModule;
      KeyValueMap mapping = KeyValueMap.newKeyValueMap();

      if (bucket == null) {
        Logic.$STRUCTURED_OBJECTS_INDEX$.insertAt(index, List.list(Cons.cons(self, Stella.NIL)));
        return (null);
      }
      bucket.removeDeletedMembers();
      if ((((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null))) != null) &&
          (((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null)) {
        mapping = KeyValueMap.newKeyValueMap();
        { PatternVariable v = null;
          Vector vector000 = ((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_EXTERNAL_VARIABLES, null)));
          int index000 = 0;
          int length000 = vector000.length();

          for (;index000 < length000; index000 = index000 + 1) {
            v = ((PatternVariable)((vector000.theArray)[index000]));
            { Stella_Object temp000 = Logic.argumentBoundTo(v);

              mapping.insertAt(v, ((temp000 != null) ? temp000 : v));
            }
          }
        }
      }
      { ContextSensitiveObject d = null;
        Cons iter000 = bucket.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          d = ((ContextSensitiveObject)(iter000.value));
          if (Stella_Object.isaP(d, Logic.SGT_LOGIC_DESCRIPTION) &&
              (Description.equivalentDescriptionsP(self, ((Description)(d)), mapping) &&
               Context.subcontextP(homemodule, d.homeContext.baseModule))) {
            return (((Description)(d)));
          }
        }
      }
      bucket.push(self);
      return (null);
    }
  }

  public LogicObject findDuplicateNamedDescription() {
    { Description self = this;

      if (Description.namedDescriptionP(self)) {
        return (self);
      }
      { Proposition proposition = self.proposition;

        { Keyword testValue000 = proposition.kind;

          if (testValue000 == Logic.KWD_AND) {
            { Proposition onlygoal = null;

              { Stella_Object arg = null;
                Vector vector000 = proposition.arguments;
                int index000 = 0;
                int length000 = vector000.length();

                for (;index000 < length000; index000 = index000 + 1) {
                  arg = (vector000.theArray)[index000];
                  if (BooleanWrapper.coerceWrappedBooleanToBoolean(((Proposition)(arg)).variableTypeP())) {
                  }
                  else if (onlygoal != null) {
                    return (null);
                  }
                  else {
                    onlygoal = ((Proposition)(arg));
                  }
                }
              }
              if ((onlygoal != null) &&
                  Logic.sameAndUniqueArgumentsP(self.ioVariables, ((onlygoal.kind == Logic.KWD_NOT) ? ((Proposition)((onlygoal.arguments.theArray)[0])).arguments : onlygoal.arguments))) {
                return (Proposition.extractGoalDescription(onlygoal, null));
              }
            }
          }
          else if (testValue000 == Logic.KWD_NOT) {
            if (Logic.sameAndUniqueArgumentsP(self.ioVariables, ((Proposition)((proposition.arguments.theArray)[0])).arguments)) {
              return (Proposition.extractGoalDescription(proposition, null));
            }
          }
          else {
            if (Logic.sameAndUniqueArgumentsP(self.ioVariables, proposition.arguments)) {
              { Description nameddescription = Proposition.extractGoalDescription(proposition, null);

                if ((nameddescription != null) &&
                    (self.ioVariables.length() == nameddescription.ioVariables.length())) {
                  return (nameddescription);
                }
              }
            }
          }
        }
        return (null);
      }
    }
  }

  /** Return TRUE if 'self' is the description of a named class or relation.
   * @param self
   * @return boolean
   */
  public static boolean namedDescriptionP(Description self) {
    return (self.surrogateValueInverse != null);
  }

  public static boolean equivalentDescriptionsP(Description self, Description other, KeyValueMap mapping) {
    if (self == other) {
      return (true);
    }
    if ((self.descriptionName() != null) &&
        (other.descriptionName() != null)) {
      return (false);
    }
    if (!(self.arity() == other.arity())) {
      return (false);
    }
    if (Description.namedDescriptionP(self)) {
      return (false);
    }
    else {
      if (mapping == null) {
        mapping = KeyValueMap.newKeyValueMap();
      }
      { PatternVariable v1 = null;
        Vector vector000 = self.ioVariables;
        int index000 = 0;
        int length000 = vector000.length();
        PatternVariable v2 = null;
        Vector vector001 = other.ioVariables;
        int index001 = 0;
        int length001 = vector001.length();

        for (;(index000 < length000) &&
                  (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
          v1 = ((PatternVariable)((vector000.theArray)[index000]));
          v2 = ((PatternVariable)((vector001.theArray)[index001]));
          mapping.insertAt(v1, v2);
          mapping.insertAt(v2, v1);
        }
      }
      { PatternVariable v1 = null;
        Vector vector002 = self.ioVariables;
        int index002 = 0;
        int length002 = vector002.length();
        PatternVariable v2 = null;
        Vector vector003 = other.ioVariables;
        int index003 = 0;
        int length003 = vector003.length();

        for (;(index002 < length002) &&
                  (index003 < length003); index002 = index002 + 1, index003 = index003 + 1) {
          v1 = ((PatternVariable)((vector002.theArray)[index002]));
          v2 = ((PatternVariable)((vector003.theArray)[index003]));
          if (!((mapping.lookup(v1) == v2) &&
              (mapping.lookup(v2) == v1))) {
            return (false);
          }
        }
      }
      { PatternVariable v1 = null;
        Vector vector004 = self.internalVariables;
        int index004 = 0;
        int length004 = vector004.length();
        PatternVariable v2 = null;
        Vector vector005 = other.internalVariables;
        int index005 = 0;
        int length005 = vector005.length();

        for (;(index004 < length004) &&
                  (index005 < length005); index004 = index004 + 1, index005 = index005 + 1) {
          v1 = ((PatternVariable)((vector004.theArray)[index004]));
          v2 = ((PatternVariable)((vector005.theArray)[index005]));
          mapping.insertAt(v1, v2);
        }
      }
      return (Logic.equivalentFormulaeP(self.proposition, other.proposition, mapping));
    }
  }

  public static void ensureDescriptionBody(Description description) {
    if (((description.proposition == null) ||
        (description.proposition == Logic.TRUE_PROPOSITION)) &&
        Stella_Object.isaP(description, Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
      NamedDescription.materializePrimitiveDescriptionBody(((NamedDescription)(description)));
    }
  }

  public static void createBaseRelationForPolymorphicDescription(Description description) {
    { Surrogate surrogate = Surrogate.internSurrogateInModule(description.descriptionName().symbolName, ((Module)(description.homeContext)), true);
      Stella_Object relation = surrogate.surrogateValue;

      if (relation == null) {
        { Object old$Evaluationmode$000 = Logic.$EVALUATIONMODE$.get();
          Object old$FillingconstraintpropagationqueuesP$000 = Logic.$FILLINGCONSTRAINTPROPAGATIONQUEUESp$.get();

          try {
            Native.setSpecial(Logic.$EVALUATIONMODE$, Logic.KWD_EXTENSIONAL_ASSERTION);
            Native.setBooleanSpecial(Logic.$FILLINGCONSTRAINTPROPAGATIONQUEUESp$, false);
            Logic.assertIsaProposition(Logic.createLogicInstance(surrogate, Logic.SGT_PL_KERNEL_KB_RELATION), Logic.SGT_PL_KERNEL_KB_POLYMORPHIC);

          } finally {
            Logic.$FILLINGCONSTRAINTPROPAGATIONQUEUESp$.set(old$FillingconstraintpropagationqueuesP$000);
            Logic.$EVALUATIONMODE$.set(old$Evaluationmode$000);
          }
        }
      }
    }
  }

  /** Return the name of the description <code>self</code>, if it has one.
   * @return Symbol
   */
  public Symbol descriptionName() {
    { Description self = this;

      return (null);
    }
  }

  public static void applyForwardRulesToVector(Description triggerdescription, Vector arguments, Proposition triggerproposition) {
    { Vector evaluatedargs = arguments;

      { Stella_Object arg = null;
        Vector vector000 = arguments;
        int index000 = 0;
        int length000 = vector000.length();
        int i = Stella.NULL_INTEGER;
        int iter000 = 0;

        for (;index000 < length000; index000 = index000 + 1, iter000 = iter000 + 1) {
          arg = (vector000.theArray)[index000];
          i = iter000;
          if (arg.deletedP()) {
            return;
          }
          else if (!Stella_Object.eqlP(arg, Logic.valueOf(arg))) {
            if (arguments == evaluatedargs) {
              evaluatedargs = arguments.copy();
            }
            (evaluatedargs.theArray)[i] = (Logic.valueOf(arg));
          }
        }
      }
      arguments = evaluatedargs;
    }
    { KeyValueList rules = null;
      KeyValueList indices = null;

      { Object [] caller_MV_returnarray = new Object[1];

        rules = Description.collectForwardChainingRules(triggerdescription, caller_MV_returnarray);
        indices = ((KeyValueList)(caller_MV_returnarray[0]));
      }
      { Proposition r = null;
        BooleanWrapper toucheddefaultP = null;
        KvCons iter001 = rules.theKvList;

        for (;iter001 != null; iter001 = iter001.rest) {
          r = ((Proposition)(iter001.key));
          toucheddefaultP = ((BooleanWrapper)(iter001.value));
          if (Proposition.applicableForwardRuleP(r, arguments)) {
            Description.applyRuleConsequentToVector(((Description)((r.arguments.theArray)[1])), arguments, r, triggerdescription, triggerproposition, BooleanWrapper.coerceWrappedBooleanToBoolean(toucheddefaultP), null);
          }
        }
      }
      { ForwardChainingIndex fwdindex = null;
        BooleanWrapper toucheddefaultP = null;
        KvCons iter002 = indices.theKvList;

        loop002 : for (;iter002 != null; iter002 = iter002.rest) {
          fwdindex = ((ForwardChainingIndex)(iter002.key));
          toucheddefaultP = ((BooleanWrapper)(iter002.value));
          { Cons inputargs = Stella.NIL;

            if (!(arguments.length() == fwdindex.forwardGoal.arguments.length())) {
              continue loop002;
            }
            { Stella_Object arg = null;
              Vector vector001 = arguments;
              int index001 = 0;
              int length001 = vector001.length();
              Stella_Object goalarg = null;
              Vector vector002 = fwdindex.forwardGoal.arguments;
              int index002 = 0;
              int length002 = vector002.length();

              loop003 : for (;(index001 < length001) &&
                        (index002 < length002); index001 = index001 + 1, index002 = index002 + 1) {
                arg = (vector001.theArray)[index001];
                goalarg = (vector002.theArray)[index002];
                if (Logic.variableP(goalarg)) {
                  inputargs = Cons.cons(arg, inputargs);
                }
                else if (!Stella_Object.eqlP(arg, Logic.valueOf(goalarg))) {
                  inputargs = null;
                  break loop003;
                }
              }
            }
            if (inputargs == null) {
              continue loop002;
            }
            { ConsIterator it = fwdindex.inputBindings.allocateIterator();
              Stella_Object arg = null;
              Cons iter003 = inputargs.reverse();

              for (;it.nextP() &&
                        (!(iter003 == Stella.NIL)); iter003 = iter003.rest) {
                arg = iter003.value;
                {
                }
                it.valueSetter(arg);
              }
            }
          }
          { Cons outputbindings = null;
            Cons truthvalues = null;
            Cons justifications = null;
            boolean traceforwardinferenceP = Stella_Object.traceKeywordP(Logic.KWD_PROPAGATE);
            boolean tracegoaltreeP = traceforwardinferenceP &&
                Stella_Object.traceKeywordP(Logic.KWD_GOAL_TREE);
            List oldtracekeywords = Stella.$TRACED_KEYWORDS$;

            if (traceforwardinferenceP) {
              if (tracegoaltreeP) {
                Stella.STANDARD_OUTPUT.nativeStream.println("Proving forward goal: " + fwdindex.queryBody);
              }
            }
            else if (Stella_Object.traceKeywordP(Logic.KWD_GOAL_TREE)) {
              Stella.$TRACED_KEYWORDS$ = ((List)(Stella.$TRACED_KEYWORDS$.copy().remove(Logic.KWD_GOAL_TREE)));
            }
            { Object old$FillingconstraintpropagationqueuesP$000 = Logic.$FILLINGCONSTRAINTPROPAGATIONQUEUESp$.get();

              try {
                Native.setBooleanSpecial(Logic.$FILLINGCONSTRAINTPROPAGATIONQUEUESp$, true);
                { Object [] caller_MV_returnarray = new Object[2];

                  outputbindings = Logic.applyCachedRetrieve(fwdindex.ioVariables, fwdindex.queryBody, fwdindex.inputBindings, Cons.consList(Cons.cons(Logic.KWD_SINGLETONSp, Cons.cons(Stella.FALSE_WRAPPER, Cons.cons(Logic.KWD_INFERENCE_LEVEL, Cons.cons(Logic.KWD_SHALLOW, Stella.NIL))))), fwdindex.cacheId, caller_MV_returnarray);
                  truthvalues = ((Cons)(caller_MV_returnarray[0]));
                  justifications = ((Cons)(caller_MV_returnarray[1]));
                }

              } finally {
                Logic.$FILLINGCONSTRAINTPROPAGATIONQUEUESp$.set(old$FillingconstraintpropagationqueuesP$000);
              }
            }
            if (tracegoaltreeP) {
              {
                Stella.STANDARD_OUTPUT.nativeStream.println("Done proving forward goal: " + fwdindex.queryBody);
                Stella.STANDARD_OUTPUT.nativeStream.println();
              }
;
            }
            Stella.$TRACED_KEYWORDS$ = oldtracekeywords;
            { Stella_Object ob = null;
              Cons iter004 = outputbindings;
              Stella_Object tv = null;
              Cons iter005 = truthvalues;

              for (;(!(iter004 == Stella.NIL)) &&
                        (!(iter005 == Stella.NIL)); iter004 = iter004.rest, iter005 = iter005.rest) {
                ob = iter004.value;
                tv = iter005.value;
                { Stella_Object head000 = justifications.value;

                  justifications = justifications.rest;
                  { Stella_Object justification = head000;

                    Description.applyRuleConsequentToVector(fwdindex.consequent, Logic.copyListToArgumentsVector(((Cons)(ob)).listify()), fwdindex.masterRule, triggerdescription, triggerproposition, BooleanWrapper.coerceWrappedBooleanToBoolean(toucheddefaultP) ||
                        (tv == Logic.DEFAULT_TRUE_TRUTH_VALUE), ((Justification)(justification)));
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  public static void applyRuleConsequentToVector(Description consequent, Vector arguments, Proposition rule, Description triggerdescription, Proposition triggerproposition, boolean toucheddefaultP, Justification bcJustification) {
    triggerdescription = triggerdescription;
    { Object old$Collectforwardpropositions$000 = Logic.$COLLECTFORWARDPROPOSITIONS$.get();

      try {
        Native.setSpecial(Logic.$COLLECTFORWARDPROPOSITIONS$, Stella.NIL);
        { boolean toucheddefaultknowledgeP = Proposition.defaultTrueP(triggerproposition) ||
              (Proposition.defaultTrueP(rule) ||
               toucheddefaultP);
          Skolem skolem = null;
          int skolemgenerationcount = 0;

          { Stella_Object arg = null;
            Vector vector000 = arguments;
            int index000 = 0;
            int length000 = vector000.length();

            for (;index000 < length000; index000 = index000 + 1) {
              arg = (vector000.theArray)[index000];
              if (Logic.skolemP(arg) &&
                  (((Skolem)(arg)).skolemGenerationCount() > skolemgenerationcount)) {
                skolemgenerationcount = ((Skolem)(arg)).skolemGenerationCount();
                if (skolemgenerationcount >= Logic.$MAX_SKOLEM_GENERATION_COUNT$) {
                  if ((Stella.$TRACED_KEYWORDS$ != null) &&
                      Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_PROPAGATE)) {
                    Stella.STANDARD_OUTPUT.nativeStream.println("*** cutting off forward skolemization on: " + triggerproposition);
                  }
                  return;
                }
              }
            }
          }
          { Object old$Queryiterator$000 = Logic.$QUERYITERATOR$.get();
            Object old$DontCheckForDuplicatePropositionsP$000 = Logic.$DONT_CHECK_FOR_DUPLICATE_PROPOSITIONSp$.get();

            try {
              Native.setSpecial(Logic.$QUERYITERATOR$, null);
              Native.setBooleanSpecial(Logic.$DONT_CHECK_FOR_DUPLICATE_PROPOSITIONSp$, false);
              Logic.inheritDescription(arguments, consequent, toucheddefaultknowledgeP);

            } finally {
              Logic.$DONT_CHECK_FOR_DUPLICATE_PROPOSITIONSp$.set(old$DontCheckForDuplicatePropositionsP$000);
              Logic.$QUERYITERATOR$.set(old$Queryiterator$000);
            }
          }
          if (Stella_Object.traceKeywordP(Logic.KWD_PROPAGATE)) {
            Proposition.traceForwardRule(rule, triggerproposition, ((Cons)(Logic.$COLLECTFORWARDPROPOSITIONS$.get())));
          }
          { Proposition p = null;
            Cons iter000 = ((Cons)(Logic.$COLLECTFORWARDPROPOSITIONS$.get()));

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              p = ((Proposition)(iter000.value));
              { Stella_Object value000 = null;

                { Stella_Object arg = null;
                  Vector vector001 = p.arguments;
                  int index001 = 0;
                  int length001 = vector001.length();

                  loop002 : for (;index001 < length001; index001 = index001 + 1) {
                    arg = (vector001.theArray)[index001];
                    if (Logic.skolemP(arg)) {
                      value000 = arg;
                      break loop002;
                    }
                  }
                }
                skolem = ((Skolem)(value000));
              }
              if ((skolem != null) &&
                  ((skolem.definingProposition == null) &&
                   (!((BooleanWrapper)(KeyValueList.dynamicSlotValue(skolem.dynamicSlots, Logic.SYM_LOGIC_HYPOTHESIZED_INSTANCEp, Stella.FALSE_WRAPPER))).wrapperValue))) {
                KeyValueList.setDynamicSlotValue(skolem.dynamicSlots, Logic.SYM_LOGIC_SKOLEM_GENERATION_COUNT, IntegerWrapper.wrapInteger(Stella.integer_max(skolemgenerationcount + 1, skolem.skolemGenerationCount())), Stella.NULL_INTEGER_WRAPPER);
              }
              Proposition.recordForwardGoal(rule, arguments, p);
              Logic.recordForwardJustification(Cons.consList(Cons.cons(triggerproposition, Stella.NIL)), rule, arguments, p, bcJustification);
            }
          }
        }

      } finally {
        Logic.$COLLECTFORWARDPROPOSITIONS$.set(old$Collectforwardpropositions$000);
      }
    }
  }

  public static boolean hasForwardChainingRulesP(Description description, Proposition proposition) {
    if (Proposition.falseP(proposition)) {
      description = Description.getInferableComplementDescription(description);
      if (description == null) {
        return (false);
      }
    }
    { KeyValueList rules = null;
      KeyValueList indices = null;

      { Object [] caller_MV_returnarray = new Object[1];

        rules = Description.collectForwardChainingRules(description, caller_MV_returnarray);
        indices = ((KeyValueList)(caller_MV_returnarray[0]));
      }
      return (rules.nonEmptyP() ||
          indices.nonEmptyP());
    }
  }

  public static KeyValueList collectForwardChainingRules(Description description, Object [] MV_returnarray) {
    { MemoizationTable memoTable000 = null;
      Cons memoizedEntry000 = null;
      Stella_Object memoizedValue000 = null;

      if (Stella.$MEMOIZATION_ENABLEDp$) {
        memoTable000 = ((MemoizationTable)(Logic.SGT_LOGIC_F_COLLECT_FORWARD_CHAINING_RULES_MEMO_TABLE_000.surrogateValue));
        if (memoTable000 == null) {
          Surrogate.initializeMemoizationTable(Logic.SGT_LOGIC_F_COLLECT_FORWARD_CHAINING_RULES_MEMO_TABLE_000, "(:MAX-VALUES 500 :TIMESTAMPS (:META-KB-UPDATE))");
          memoTable000 = ((MemoizationTable)(Logic.SGT_LOGIC_F_COLLECT_FORWARD_CHAINING_RULES_MEMO_TABLE_000.surrogateValue));
        }
        memoizedEntry000 = MruMemoizationTable.lookupMruMemoizedValue(((MruMemoizationTable)(memoTable000)), description, ((Context)(Stella.$CONTEXT$.get())), Stella.MEMOIZED_NULL_VALUE, null, -1);
        memoizedValue000 = memoizedEntry000.value;
      }
      if (memoizedValue000 != null) {
        if (memoizedValue000 == Stella.MEMOIZED_NULL_VALUE) {
          memoizedValue000 = null;
        }
      }
      else {
        memoizedValue000 = Description.helpCollectForwardRules(description, null, null, false, null);
        if (Stella.$MEMOIZATION_ENABLEDp$) {
          memoizedEntry000.value = ((memoizedValue000 == null) ? Stella.MEMOIZED_NULL_VALUE : memoizedValue000);
        }
      }
      { Cons rules = ((Cons)(memoizedValue000));

        { KeyValueList _return_temp = ((KeyValueList)(rules.value));

          MV_returnarray[0] = ((KeyValueList)(rules.rest.value));
          return (_return_temp);
        }
      }
    }
  }

  public static Cons helpCollectForwardRules(Description description, KeyValueList rules, KeyValueList indices, boolean toucheddefaultP, List beenthere) {
    if (rules == null) {
      rules = KeyValueList.newKeyValueList();
    }
    if (indices == null) {
      indices = KeyValueList.newKeyValueList();
    }
    if (beenthere == null) {
      beenthere = List.newList();
    }
    beenthere.insert(description);
    { ForwardChainingIndex index = null;
      Cons iter000 = description.forwardChainingIndices().theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        index = ((ForwardChainingIndex)(iter000.value));
        if ((!index.masterRule.deletedP()) &&
            Proposition.trueP(index.masterRule)) {
          indices.insertAt(index, (toucheddefaultP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
        }
      }
    }
    { Proposition p = null;
      Cons iter001 = LogicObject.applicableRulesOfDescription(description, Logic.KWD_FORWARD, true);

      for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
        p = ((Proposition)(iter001.value));
        if (!((BooleanWrapper)(KeyValueList.dynamicSlotValue(p.dynamicSlots, Logic.SYM_LOGIC_BACKWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue) {
          { Stella_Object consequent = (p.arguments.theArray)[1];

            { Surrogate testValue000 = Stella_Object.safePrimaryType(consequent);

              if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
                { NamedDescription consequent000 = ((NamedDescription)(consequent));

                  { Stella_Object renamed_Super = Logic.valueOf(consequent000);

                    if (Proposition.defaultTrueP(p)) {
                      toucheddefaultP = true;
                    }
                    if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(p.dynamicSlots, Logic.SYM_LOGIC_FORWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue ||
                        (!(Logic.classP(description) == Logic.classP(renamed_Super)))) {
                      rules.insertAt(p, (toucheddefaultP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
                    }
                    if (!beenthere.memberP(renamed_Super)) {
                      Description.helpCollectForwardRules(((Description)(renamed_Super)), rules, indices, toucheddefaultP, beenthere);
                    }
                  }
                }
              }
              else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_DESCRIPTION)) {
                { Description consequent000 = ((Description)(consequent));

                  rules.insertAt(p, (toucheddefaultP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
                }
              }
              else {
              }
            }
          }
        }
      }
    }
    return (Cons.cons(rules, Cons.cons(indices, Stella.NIL)));
  }

  public static boolean descriptionImpliesDescriptionP(Description subdesc, Description superdesc) {
    return (LogicObject.collectionImpliesCollectionP(subdesc, superdesc));
  }

  public Surrogate descriptionSurrogate() {
    { Description self = this;

      { Relation nativerelation = self.nativeRelation();

        if (nativerelation != null) {
          { Surrogate testValue000 = Stella_Object.safePrimaryType(nativerelation);

            if (Surrogate.subtypeOfClassP(testValue000)) {
              { Stella_Class nativerelation000 = ((Stella_Class)(nativerelation));

                return (Logic.classLogicalType(nativerelation000));
              }
            }
            else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_STELLA_SLOT)) {
              { Slot nativerelation000 = ((Slot)(nativerelation));

                return (nativerelation000.slotSlotref);
              }
            }
            else {
            }
          }
        }
        return (null);
      }
    }
  }

  public static Proposition assertDescriptionImpliesDescription(Description sub, Description renamed_Super, boolean dontupdateP) {
    { Proposition impliesprop = Logic.createImpliesProposition(sub, renamed_Super);

      impliesprop = Proposition.fastenDownOneProposition(impliesprop, false);
      if (!(dontupdateP)) {
        Proposition.updatePropositionTruthValue(impliesprop, Logic.KWD_ASSERT_TRUE);
      }
      return (impliesprop);
    }
  }

  public static boolean descriptionExtensionL(Description desc1, Description desc2) {
    return (NamedDescription.getDescriptionExtension(((NamedDescription)(desc1)), true).estimatedLength() < NamedDescription.getDescriptionExtension(((NamedDescription)(desc2)), true).estimatedLength());
  }

  public int arity() {
    { Description self = this;

      return (self.ioVariables.length());
    }
  }

  public static boolean variableArityP(Description self) {
    return (Logic.testPropertyP(self, Logic.SGT_PL_KERNEL_KB_VARIABLE_ARITY));
  }

  public static Stella_Object accessDescriptionSlotValue(Description self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_PROPOSITION) {
      if (setvalueP) {
        self.proposition = ((Proposition)(value));
      }
      else {
        value = self.proposition;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_IO_VARIABLES) {
      if (setvalueP) {
        self.ioVariables = ((Vector)(value));
      }
      else {
        value = self.ioVariables;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_INTERNAL_VARIABLES) {
      if (setvalueP) {
        self.internalVariables = ((Vector)(value));
      }
      else {
        value = self.internalVariables;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_QUERY_PATTERNS) {
      if (setvalueP) {
        self.queryPatterns = ((KeyValueList)(value));
      }
      else {
        value = self.queryPatterns;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_FORWARD_CHAINING_INDICES) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_FORWARD_CHAINING_INDICES, ((List)(value)), null);
      }
      else {
        value = self.forwardChainingIndices();
      }
    }
    else if (slotname == Logic.SYM_LOGIC_DEFERRED_CONTRAPOSITIVESp) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DEFERRED_CONTRAPOSITIVESp, ((BooleanWrapper)(value)), null);
      }
      else {
        value = self.deferredContrapositivesP();
      }
    }
    else {
      if (slotname == Logic.SYM_LOGIC_RELATIVE_COMPLEMENT) {
        slotname = Logic.SYM_LOGIC_COMPLEMENT_DESCRIPTION;
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

  public BooleanWrapper deferredContrapositivesP() {
    { Description self = this;

      { BooleanWrapper answer = ((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DEFERRED_CONTRAPOSITIVESp, null)));

        if (answer == null) {
          return (Stella.FALSE_WRAPPER);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public List forwardChainingIndices() {
    { Description self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_FORWARD_CHAINING_INDICES, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public Relation nativeRelation() {
    { Description self = this;

      return (null);
    }
  }

  public Surrogate primaryType() {
    { Description self = this;

      return (Logic.SGT_LOGIC_DESCRIPTION);
    }
  }

}

