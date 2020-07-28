//  -*- Mode: Java -*-
//
// Proposition.java

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

/** 
 * @author Stella Java Translator
 */
public class Proposition extends ContextSensitiveObject {
    public Keyword kind;
    public Stella_Object truthValue;
    public Vector arguments;
    public GeneralizedSymbol operator;
    public NonPagingIndex dependentPropositions;
    public KeyValueList dynamicSlots;

  public static Proposition newProposition() {
    { Proposition self = null;

      self = new Proposition();
      self.dynamicSlots = KeyValueList.newKeyValueList();
      self.dependentPropositions = Logic.NIL_NON_PAGING_INDEX;
      self.operator = null;
      self.arguments = null;
      self.truthValue = null;
      self.kind = null;
      self.homeContext = ((Module)(Stella.$MODULE$.get()));
      return (self);
    }
  }

  /** Return true if proposition's truth-value has been locally modified in
   * <code>module</code> (initialized, asserted, retracted).  This will always succeed for locally conceived
   * propositions regardless of whether their truth value is defined or not.
   * @param proposition
   * @param module
   * @return boolean
   */
  public static boolean locallyModifiedPropositionP(Proposition proposition, Module module) {
    { Stella_Object truthvalue = proposition.truthValue;

      if ((truthvalue == null) ||
          Stella_Object.isaP(truthvalue, Logic.SGT_LOGIC_TRUTH_VALUE)) {
        return (proposition.homeModule() == module);
      }
      else {
        { Stella_Object ctxt = null;
          Stella_Object tv = null;
          KvCons iter000 = ((KeyValueList)(truthvalue)).theKvList;

          for (;iter000 != null; iter000 = iter000.rest) {
            ctxt = iter000.key;
            tv = iter000.value;
            tv = tv;
            if (ctxt == module) {
              return (true);
            }
          }
        }
      }
      return (false);
    }
  }

  public void processDefinitionOptions(Stella_Object options) {
    { Proposition self = this;

      Logic.axiomsSetter(self, null);
      { Stella_Object key = null;
        Stella_Object value = null;
        Cons iter000 = Stella_Object.vetOptions(options, null).thePlist;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
          key = iter000.value;
          value = iter000.rest.value;
          if (!Stella_Object.runOptionHandlerP(self, ((Keyword)(key)), value)) {
            Logic.definitionKeywordAxiomsHandler(self, Logic.objectName(self), ((Keyword)(key)), value);
          }
        }
      }
    }
  }

  public static void flushInferableDirectSubdescriptionsCache(Proposition impliesproposition) {
    if (((ClassificationSession)(Logic.$CLASSIFICATIONSESSION$.get())) == null) {
      return;
    }
    { ClassificationCache cache = Logic.getClassificationCache((impliesproposition.arguments.theArray)[1]);

      if (cache != null) {
        cache.inferableDirectSubdescriptions = null;
      }
    }
  }

  public static boolean mapFunctionalValueP(Proposition proposition, KeyValueMap mapping) {
    { Proposition copy = Proposition.findSimilarProposition(proposition, mapping);

      if ((copy == null) &&
          (proposition.kind == Logic.KWD_FUNCTION)) {
        copy = Proposition.inheritFunctionProposition(proposition, mapping, false);
      }
      if (copy != null) {
        { Stella_Object localfunctionalvalue = Logic.valueOf((copy.arguments.theArray)[(copy.arguments.length() - 1)]);

          return (Logic.mapAndEnqueueVariableP((proposition.arguments.theArray)[(proposition.arguments.length() - 1)], localfunctionalvalue, mapping));
        }
      }
      return (true);
    }
  }

  public static void collectStructuralFunctions(Proposition proposition, List structuralfunctions) {
    { Keyword testValue000 = proposition.kind;

      if (testValue000 == Logic.KWD_FUNCTION) {
        structuralfunctions.insert(proposition);
      }
      else if (testValue000 == Logic.KWD_PREDICATE) {
        if (Proposition.singleValuedPredicateP(proposition)) {
          structuralfunctions.insert(proposition);
        }
      }
      else if (testValue000 == Logic.KWD_AND) {
        { Stella_Object conjunct = null;
          Vector vector000 = proposition.arguments;
          int index000 = 0;
          int length000 = vector000.length();

          for (;index000 < length000; index000 = index000 + 1) {
            conjunct = (vector000.theArray)[index000];
            Proposition.collectStructuralFunctions(((Proposition)(conjunct)), structuralfunctions);
          }
        }
      }
      else if (testValue000 == Logic.KWD_EXISTS) {
        Proposition.collectStructuralFunctions(((Proposition)((proposition.arguments.theArray)[0])), structuralfunctions);
      }
      else {
      }
    }
  }

  public static boolean propositionReferencesTermsP(Proposition self, HashSet terms) {
    { Stella_Object arg = null;
      Vector vector000 = self.arguments;
      int index000 = 0;
      int length000 = vector000.length();

      for (;index000 < length000; index000 = index000 + 1) {
        arg = (vector000.theArray)[index000];
        if (terms.memberP(arg)) {
          return (true);
        }
        { Surrogate testValue000 = Stella_Object.safePrimaryType(arg);

          if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PROPOSITION)) {
            { Proposition arg000 = ((Proposition)(arg));

              if (Proposition.propositionReferencesTermsP(arg000, terms)) {
                return (true);
              }
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_SKOLEM)) {
            { Skolem arg000 = ((Skolem)(arg));

              { Proposition definingprop = arg000.definingProposition;

                if ((definingprop != null) &&
                    ((!(definingprop == self)) &&
                     Proposition.propositionReferencesTermsP(definingprop, terms))) {
                  return (true);
                }
              }
            }
          }
          else {
          }
        }
      }
    }
    return (false);
  }

  public static Cons inheritAsTopLevelProposition(Proposition proposition, KeyValueMap mapping) {
    { Cons resultlist = Stella.NIL;

      if (mapping == null) {
        mapping = KeyValueMap.newKeyValueMap();
      }
      { Keyword testValue000 = proposition.kind;

        if (testValue000 == Logic.KWD_AND) {
          { Stella_Object arg = null;
            Vector vector000 = proposition.arguments;
            int index000 = 0;
            int length000 = vector000.length();

            for (;index000 < length000; index000 = index000 + 1) {
              arg = (vector000.theArray)[index000];
              resultlist = Cons.cons(Proposition.inheritProposition(((Proposition)(arg)), mapping), resultlist);
            }
          }
        }
        else if (testValue000 == Logic.KWD_EXISTS) {
          { PatternVariable vbl = null;
            Vector vector001 = ((Vector)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
            int index001 = 0;
            int length001 = vector001.length();

            for (;index001 < length001; index001 = index001 + 1) {
              vbl = ((PatternVariable)((vector001.theArray)[index001]));
              PatternVariable.createSkolemForUnmappedVariable(vbl, mapping);
            }
          }
          resultlist = Cons.cons(Proposition.inheritProposition(((Proposition)((proposition.arguments.theArray)[0])), mapping), resultlist);
        }
        else {
          resultlist = Cons.cons(Proposition.inheritProposition(proposition, mapping), resultlist);
        }
      }
      { Stella_Object p = null;
        Cons iter000 = resultlist;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          p = iter000.value;
          Proposition.normalizeTopLevelProposition(((Proposition)(p)));
        }
      }
      return (resultlist.reverse());
    }
  }

  public static Proposition inheritProposition(Proposition self, KeyValueMap mapping) {
    { Keyword testValue000 = self.kind;

      if ((testValue000 == Logic.KWD_FORALL) ||
          (testValue000 == Logic.KWD_EXISTS)) {
        { Object old$Evaluationmode$000 = Logic.$EVALUATIONMODE$.get();

          try {
            Native.setSpecial(Logic.$EVALUATIONMODE$, Logic.KWD_DESCRIPTION);
            return (Proposition.copyProposition(self, mapping));

          } finally {
            Logic.$EVALUATIONMODE$.set(old$Evaluationmode$000);
          }
        }
      }
      else if (testValue000 == Logic.KWD_FUNCTION) {
        { Stella_Object value = Logic.inheritPropositionArgument((self.arguments.theArray)[(self.arguments.length() - 1)], self, mapping);
          Proposition copy = null;

          if (value == null) {
            return (null);
          }
          copy = Proposition.findSimilarProposition(self, mapping);
          if (copy == null) {
            copy = Proposition.inheritFunctionProposition(self, mapping, true);
            copy = Proposition.eradicateHoldsProposition(copy);
          }
          if (Stella_Object.eqlP((copy.arguments.theArray)[(copy.arguments.length() - 1)], value)) {
            copy = Logic.TRUE_PROPOSITION;
          }
          else {
            copy = Skolem.inheritEquivalentProposition(((Skolem)((copy.arguments.theArray)[(copy.arguments.length() - 1)])), value);
          }
          mapping.insertAt(self, copy);
          return (copy);
        }
      }
      else {
      }
    }
    { Proposition matchingproposition = ((Proposition)(mapping.lookup(self)));

      if (matchingproposition != null) {
        return (matchingproposition);
      }
      if (BooleanWrapper.coerceWrappedBooleanToBoolean(self.variableTypeP())) {
        { Stella_Object binding = mapping.lookup((self.arguments.theArray)[0]);

          if ((binding != null) &&
              (!Logic.skolemP(binding))) {
            return (Logic.TRUE_PROPOSITION);
          }
        }
      }
      if (matchingproposition != null) {
        mapping.insertAt(self, matchingproposition);
        return (matchingproposition);
      }
    }
    { GeneralizedSymbol operator = self.operator;
      List argumentsmapto = List.newList();
      Proposition copy = null;
      Stella_Object argmapsto = null;

      { Stella_Object arg = null;
        Vector vector000 = self.arguments;
        int index000 = 0;
        int length000 = vector000.length();
        Cons collect000 = null;

        for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          argmapsto = Logic.inheritPropositionArgument(arg, self, mapping);
          if (argmapsto == null) {
            return (null);
          }
          if (collect000 == null) {
            {
              collect000 = Cons.cons(argmapsto, Stella.NIL);
              if (argumentsmapto.theConsList == Stella.NIL) {
                argumentsmapto.theConsList = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(argumentsmapto.theConsList, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(argmapsto, Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      copy = Logic.createProposition(Logic.SYM_LOGIC_CONSTANT, 0);
      copy.kind = self.kind;
      copy.operator = operator;
      copy.arguments = Logic.copyListToArgumentsVector(argumentsmapto);
      if (BooleanWrapper.coerceWrappedBooleanToBoolean(self.variableTypeP())) {
        KeyValueList.setDynamicSlotValue(copy.dynamicSlots, Logic.SYM_LOGIC_VARIABLE_TYPEp, Stella.TRUE_WRAPPER, null);
      }
      copy = Proposition.eradicateHoldsProposition(copy);
      mapping.insertAt(self, copy);
      return (copy);
    }
  }

  public static Proposition eradicateHoldsProposition(Proposition self) {
    if ((self.operator == Logic.SGT_PL_KERNEL_KB_HOLDS) &&
        (!Stella_Object.isaP((self.arguments.theArray)[0], Logic.SGT_LOGIC_PATTERN_VARIABLE))) {
      Proposition.normalizePredicateProposition(self);
      { Proposition duplicate = Proposition.findSimilarProposition(self, null);

        if (duplicate != null) {
          { Stella_Object arg = null;
            Vector vector000 = self.arguments;
            int index000 = 0;
            int length000 = vector000.length();
            int i = Stella.NULL_INTEGER;
            int iter000 = 0;

            for (;index000 < length000; index000 = index000 + 1, iter000 = iter000 + 1) {
              arg = (vector000.theArray)[index000];
              i = iter000;
              (duplicate.arguments.theArray)[i] = arg;
            }
          }
          self.free();
          return (duplicate);
        }
      }
    }
    return (self);
  }

  public static Proposition findSimilarProposition(Proposition proposition, KeyValueMap mapping) {
    { Proposition result = Proposition.newFindSimilarProposition(proposition, mapping);

      return (result);
    }
  }

  public static Proposition newFindSimilarProposition(Proposition proposition, KeyValueMap mapping) {
    if (proposition.kind == Logic.KWD_CONSTANT) {
      return (null);
    }
    { IntegerWrapper index = IntegerWrapper.wrapInteger(Proposition.propositionHashIndex(proposition, mapping, false));
      List bucket = ((List)(Logic.$STRUCTURED_OBJECTS_INDEX$.lookup(index)));
      boolean functionP = proposition.kind == Logic.KWD_FUNCTION;

      if (bucket == null) {
        return (null);
      }
      { GeneralizedSymbol operator = proposition.operator;
        Vector arguments = proposition.arguments;
        int arity = arguments.length();

        { ContextSensitiveObject p = null;
          Cons iter000 = bucket.theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            p = ((ContextSensitiveObject)(iter000.value));
            if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(p), Logic.SGT_LOGIC_PROPOSITION)) {
              { Proposition p000 = ((Proposition)(p));

                { boolean testValue000 = false;

                  testValue000 = operator == p000.operator;
                  if (testValue000) {
                    testValue000 = arity == p000.arguments.length();
                    if (testValue000) {
                      testValue000 = functionP;
                      if (testValue000) {
                        { boolean alwaysP000 = true;

                          { Stella_Object arg1 = null;
                            Vector vector000 = arguments;
                            int index000 = 0;
                            int length000 = vector000.length();
                            Stella_Object arg2 = null;
                            Vector vector001 = p000.arguments;
                            int index001 = 0;
                            int length001 = vector001.length();
                            int i = Stella.NULL_INTEGER;
                            int iter001 = 2;
                            int upperBound000 = arity;
                            boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

                            loop001 : for (;(index000 < length000) &&
                                      ((index001 < length001) &&
                                       (unboundedP000 ||
                                        (iter001 <= upperBound000))); 
                                  index000 = index000 + 1,
                                  index001 = index001 + 1,
                                  iter001 = iter001 + 1) {
                              arg1 = (vector000.theArray)[index000];
                              arg2 = (vector001.theArray)[index001];
                              i = iter001;
                              if (!Stella_Object.eqlP(Logic.mappedValueOf(arg1, mapping, false), Logic.valueOf(arg2))) {
                                alwaysP000 = false;
                                break loop001;
                              }
                            }
                          }
                          testValue000 = alwaysP000;
                        }
                      }
                      if (!testValue000) {
                        testValue000 = (!functionP) &&
                            Proposition.equivalentPropositionsP(proposition, p000, mapping);
                      }
                      if (testValue000) {
                        testValue000 = Context.subcontextP(((Module)(Stella.$MODULE$.get())), p000.homeContext.baseModule);
                      }
                    }
                  }
                  if (testValue000) {
                    return (p000);
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
    }
  }

  public static Proposition oldFindSimilarProposition(Proposition proposition, KeyValueMap mapping) {
    if (proposition.kind == Logic.KWD_CONSTANT) {
      return (null);
    }
    { Keyword kind = proposition.kind;
      GeneralizedSymbol operator = proposition.operator;
      Stella_Object argmapsto = null;
      SequenceIndex dependentslist = null;
      boolean hasdiscouragedargumentP = false;

      { Stella_Object arg = null;
        Vector vector000 = proposition.arguments;
        int index000 = 0;
        int length000 = vector000.length();

        loop000 : for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          if (false) {
            hasdiscouragedargumentP = true;
            continue loop000;
          }
          { Stella_Object mapsto = Logic.mappedValueOf(arg, mapping, false);

            if ((mapsto != null) &&
                Logic.instanceHasBacklinksP(mapsto)) {
              argmapsto = mapsto;
              break loop000;
            }
          }
        }
      }
      if ((argmapsto == null) &&
          hasdiscouragedargumentP) {
        { Stella_Object arg = null;
          Vector vector001 = proposition.arguments;
          int index001 = 0;
          int length001 = vector001.length();

          loop001 : for (;index001 < length001; index001 = index001 + 1) {
            arg = (vector001.theArray)[index001];
            if (false) {
              { Stella_Object mapsto = Logic.mappedValueOf(arg, mapping, false);

                if ((mapsto != null) &&
                    Logic.instanceHasBacklinksP(mapsto)) {
                  argmapsto = mapsto;
                  break loop001;
                }
              }
            }
          }
        }
      }
      if (argmapsto == null) {
        return (null);
      }
      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(argmapsto), Logic.SGT_LOGIC_LOGIC_OBJECT)) {
        { LogicObject argmapsto000 = ((LogicObject)(argmapsto));

          dependentslist = Logic.unfilteredDependentPropositions(argmapsto000, ((Surrogate)(operator)));
          if (kind == Logic.KWD_FUNCTION) {
            { Proposition value000 = null;

              { Proposition p = null;
                Iterator iter000 = dependentslist.allocateIterator();

                loop002 : while (iter000.nextP()) {
                  p = ((Proposition)(iter000.value));
                  { boolean testValue000 = false;

                    testValue000 = p.kind == kind;
                    if (testValue000) {
                      testValue000 = p.operator == operator;
                      if (testValue000) {
                        { boolean alwaysP000 = true;

                          { Stella_Object arg1 = null;
                            Iterator iter001 = proposition.arguments.butLast();
                            Stella_Object arg2 = null;
                            Iterator iter002 = p.arguments.butLast();

                            loop003 : while (iter001.nextP() &&
                                iter002.nextP()) {
                              arg1 = iter001.value;
                              arg2 = iter002.value;
                              if (!Logic.equalUpToSkolemIdentityP(arg1, arg2, mapping)) {
                                alwaysP000 = false;
                                break loop003;
                              }
                            }
                          }
                          testValue000 = alwaysP000;
                        }
                      }
                    }
                    if (testValue000) {
                      value000 = p;
                      break loop002;
                    }
                  }
                }
              }
              { Proposition value001 = value000;

                return (value001);
              }
            }
          }
          else {
            { Proposition value002 = null;

              { Proposition p = null;
                Iterator iter003 = dependentslist.allocateIterator();

                loop004 : while (iter003.nextP()) {
                  p = ((Proposition)(iter003.value));
                  { boolean testValue001 = false;

                    testValue001 = p.kind == kind;
                    if (testValue001) {
                      testValue001 = p.operator == operator;
                      if (testValue001) {
                        { boolean alwaysP001 = true;

                          { Stella_Object arg1 = null;
                            Vector vector002 = proposition.arguments;
                            int index002 = 0;
                            int length002 = vector002.length();
                            Stella_Object arg2 = null;
                            Vector vector003 = p.arguments;
                            int index003 = 0;
                            int length003 = vector003.length();

                            loop005 : for (;(index002 < length002) &&
                                      (index003 < length003); index002 = index002 + 1, index003 = index003 + 1) {
                              arg1 = (vector002.theArray)[index002];
                              arg2 = (vector003.theArray)[index003];
                              if (!Logic.equalUpToSkolemIdentityP(arg1, arg2, mapping)) {
                                alwaysP001 = false;
                                break loop005;
                              }
                            }
                          }
                          testValue001 = alwaysP001;
                        }
                      }
                    }
                    if (testValue001) {
                      value002 = p;
                      break loop004;
                    }
                  }
                }
              }
              { Proposition value003 = value002;

                return (value003);
              }
            }
          }
        }
      }
      else {
      }
      return (null);
    }
  }

  public static Proposition inheritFunctionProposition(Proposition self, KeyValueMap mapping, boolean createskolemP) {
    { Proposition copy = null;
      Cons inputargs = Stella.NIL;
      int nofinputargs = self.arguments.length() - 1;
      Stella_Object argmapsto = null;

      { Stella_Object arg = null;
        Vector vector000 = self.arguments;
        int index000 = 0;
        int length000 = vector000.length();
        int i = Stella.NULL_INTEGER;
        int iter000 = 1;
        Cons collect000 = null;

        for (;index000 < length000; index000 = index000 + 1, iter000 = iter000 + 1) {
          arg = (vector000.theArray)[index000];
          i = iter000;
          if (i <= nofinputargs) {
            argmapsto = Logic.mappedValueOf(arg, mapping, createskolemP);
            if (argmapsto == null) {
              return (null);
            }
            if (collect000 == null) {
              {
                collect000 = Cons.cons(Logic.inheritPropositionArgument(argmapsto, self, mapping), Stella.NIL);
                if (inputargs == Stella.NIL) {
                  inputargs = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(inputargs, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(Logic.inheritPropositionArgument(argmapsto, self, mapping), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      copy = Logic.findOrCreateFunctionProposition(((Surrogate)(self.operator)), inputargs);
      return (copy);
    }
  }

  public static boolean binaryPropositionP(Proposition proposition) {
    return (proposition.arguments.length() == 2);
  }

  public static boolean singleValuedPredicateP(Proposition proposition) {
    return ((proposition.kind == Logic.KWD_PREDICATE) &&
        Logic.singleValuedTermP(Logic.getDescription(((Surrogate)(proposition.operator)))));
  }

  public static Proposition copyProposition(Proposition self, KeyValueMap mapping) {
    { Proposition copy = ((Proposition)(mapping.lookup(self)));

      if (copy != null) {
        return (copy);
      }
      else if (self.kind == Logic.KWD_CONSTANT) {
        return (self);
      }
      copy = Logic.createProposition(Logic.SYM_STELLA_PREDICATE, self.arguments.length());
      copy.homeContext = ((Module)(Stella.$MODULE$.get()));
      copy.kind = self.kind;
      copy.operator = ((GeneralizedSymbol)(Logic.copyPropositionArgument(self.operator, mapping)));
      { Proposition object000 = copy;
        TruthValue value000 = ((TruthValue)(Stella_Object.accessInContext(self.truthValue, self.homeContext, false)));
        Stella_Object oldValue001 = object000.truthValue;
        Stella_Object newValue000 = Stella_Object.updateInContext(oldValue001, value000, object000.homeContext, false);

        if (!((oldValue001 != null) &&
            (oldValue001.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
          object000.truthValue = newValue000;
        }
      }
      if (((FloatWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, Stella.NULL_FLOAT_WRAPPER))).wrapperValue != Stella.NULL_FLOAT) {
        KeyValueList.setDynamicSlotValue(copy.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, FloatWrapper.wrapFloat(((FloatWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, Stella.NULL_FLOAT_WRAPPER))).wrapperValue), Stella.NULL_FLOAT_WRAPPER);
      }
      if (BooleanWrapper.coerceWrappedBooleanToBoolean(self.variableTypeP())) {
        KeyValueList.setDynamicSlotValue(copy.dynamicSlots, Logic.SYM_LOGIC_VARIABLE_TYPEp, Stella.TRUE_WRAPPER, null);
      }
      if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.FALSE_WRAPPER))).wrapperValue) {
        KeyValueList.setDynamicSlotValue(copy.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
      }
      if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DONT_OPTIMIZEp, Stella.FALSE_WRAPPER))).wrapperValue) {
        KeyValueList.setDynamicSlotValue(copy.dynamicSlots, Logic.SYM_LOGIC_DONT_OPTIMIZEp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
      }
      if (((PropertyList)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_ANNOTATIONS, null))) != null) {
        KeyValueList.setDynamicSlotValue(copy.dynamicSlots, Logic.SYM_LOGIC_ANNOTATIONS, ((PropertyList)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_ANNOTATIONS, null))).copy(), null);
        Proposition.finalizePropositionAnnotations(copy);
      }
      mapping.insertAt(self, copy);
      { Keyword testValue000 = self.kind;

        if ((testValue000 == Logic.KWD_FORALL) ||
            (testValue000 == Logic.KWD_EXISTS)) {
          KeyValueList.setDynamicSlotValue(copy.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, Logic.copyVariablesVector(((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null))), mapping), null);
        }
        else {
        }
      }
      { Stella_Object arg = null;
        Vector vector000 = self.arguments;
        int index000 = 0;
        int length000 = vector000.length();
        int i = Stella.NULL_INTEGER;
        int iter000 = 0;

        for (;index000 < length000; index000 = index000 + 1, iter000 = iter000 + 1) {
          arg = (vector000.theArray)[index000];
          i = iter000;
          (copy.arguments.theArray)[i] = (Logic.copyPropositionArgument(arg, mapping));
        }
      }
      return (copy);
    }
  }

  public static void simplifyProposition(Proposition proposition) {
    { Keyword testValue000 = proposition.kind;

      if (testValue000 == Logic.KWD_FORALL) {
      }
      else if (testValue000 == Logic.KWD_AND) {
        Proposition.simplifyConjunction(proposition);
      }
      else {
        { Stella_Object arg = null;
          Vector vector000 = proposition.arguments;
          int index000 = 0;
          int length000 = vector000.length();

          for (;index000 < length000; index000 = index000 + 1) {
            arg = (vector000.theArray)[index000];
            { Surrogate testValue001 = Stella_Object.safePrimaryType(arg);

              if (Surrogate.subtypeOfP(testValue001, Logic.SGT_LOGIC_PROPOSITION)) {
                { Proposition arg000 = ((Proposition)(arg));

                  Proposition.simplifyProposition(arg000);
                }
              }
              else if (Surrogate.subtypeOfP(testValue001, Logic.SGT_LOGIC_DESCRIPTION)) {
                { Description arg000 = ((Description)(arg));

                  Description.simplifyDescription(arg000, ((Boolean)(Logic.$POSTOPTIMIZATIONp$.get())).booleanValue());
                }
              }
              else {
              }
            }
          }
        }
      }
    }
  }

  public static void simplifyConjunction(Proposition andproposition) {
    { List conjunctslist = List.newList();
      Cons cursor = null;
      int cursorpos = 0;

      { Stella_Object arg = null;
        Vector vector000 = andproposition.arguments;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          conjunctslist.push(((Proposition)(arg)));
        }
      }
      cursor = conjunctslist.theConsList;
      while (!(cursor == Stella.NIL)) {
        { Proposition conjunct = ((Proposition)(cursor.value));

          { Keyword testValue000 = conjunct.kind;

            if (testValue000 == Logic.KWD_EQUIVALENT) {
              if (Stella_Object.eqlP((conjunct.arguments.theArray)[0], (conjunct.arguments.theArray)[1]) ||
                  (Stella_Object.eqlP(Logic.valueOf((conjunct.arguments.theArray)[0]), Logic.valueOf((conjunct.arguments.theArray)[1])) &&
                   (Stella_Object.isaP((conjunct.arguments.theArray)[0], Logic.SGT_LOGIC_PATTERN_VARIABLE) &&
                    Stella_Object.isaP((conjunct.arguments.theArray)[1], Logic.SGT_LOGIC_PATTERN_VARIABLE)))) {
                { Stella_Object arg = null;
                  Vector vector001 = conjunct.arguments;
                  int index001 = 0;
                  int length001 = vector001.length();

                  for (;index001 < length001; index001 = index001 + 1) {
                    arg = (vector001.theArray)[index001];
                    Logic.removeDependentPropositionLink(arg, conjunct);
                  }
                }
                cursor.value = Logic.TRUE_PROPOSITION;
              }
            }
            else if (testValue000 == Logic.KWD_ISA) {
              { Proposition value000 = null;

                { Proposition otherconj = null;
                  Cons iter000 = conjunctslist.theConsList;
                  int i = Stella.NULL_INTEGER;
                  int iter001 = 0;

                  loop003 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
                    otherconj = ((Proposition)(iter000.value));
                    i = iter001;
                    if ((!(i == cursorpos)) &&
                        Proposition.conjunctCancelsIsaPropositionP(conjunct, otherconj)) {
                      value000 = otherconj;
                      break loop003;
                    }
                  }
                }
                { Proposition dominatingconjunct = value000;

                  if ((((Surrogate)(conjunct.operator)) == Logic.SGT_STELLA_THING) ||
                      (dominatingconjunct != null)) {
                    if (!(conjunct == dominatingconjunct)) {
                      { Stella_Object arg = null;
                        Vector vector002 = conjunct.arguments;
                        int index002 = 0;
                        int length002 = vector002.length();

                        for (;index002 < length002; index002 = index002 + 1) {
                          arg = (vector002.theArray)[index002];
                          Logic.removeDependentPropositionLink(arg, conjunct);
                        }
                      }
                    }
                    cursor.value = Logic.TRUE_PROPOSITION;
                  }
                }
              }
            }
            else if (testValue000 == Logic.KWD_AND) {
              Proposition.simplifyConjunction(((Proposition)(cursor.value)));
            }
            else {
            }
          }
        }
        cursor = cursor.rest;
        cursorpos = cursorpos + 1;
      }
      if (conjunctslist.memberP(Logic.TRUE_PROPOSITION)) {
        conjunctslist.remove(Logic.TRUE_PROPOSITION);
        conjunctslist.reverse();
        switch (conjunctslist.length()) {
          case 0: 
            Proposition.overlayWithConstantProposition(andproposition, Logic.TRUE_PROPOSITION);
          break;
          case 1: 
            Proposition.overlayProposition(andproposition, ((Proposition)(conjunctslist.first())));
            { Stella_Object arg = null;
              Vector vector003 = andproposition.arguments;
              int index003 = 0;
              int length003 = vector003.length();

              for (;index003 < length003; index003 = index003 + 1) {
                arg = (vector003.theArray)[index003];
                Logic.addDependentPropositionLink(arg, andproposition);
              }
            }
          break;
          default:
            andproposition.arguments = Logic.copyListToArgumentsVector(conjunctslist);
          break;
        }
        conjunctslist.free();
      }
    }
  }

  public static boolean conjunctCancelsIsaPropositionP(Proposition isaconjunct, Proposition otherconjunct) {
    { Keyword testValue000 = otherconjunct.kind;

      if (testValue000 == Logic.KWD_ISA) {
        return (Stella_Object.eqlP((otherconjunct.arguments.theArray)[0], (isaconjunct.arguments.theArray)[0]) &&
            ((((Boolean)(Logic.$POSTOPTIMIZATIONp$.get())).booleanValue() ? Logic.relationrefSpecializesRelationrefP(((Surrogate)(otherconjunct.operator)), ((Surrogate)(isaconjunct.operator))) : (((Surrogate)(otherconjunct.operator)) == ((Surrogate)(isaconjunct.operator))))));
      }
      else if ((testValue000 == Logic.KWD_FUNCTION) ||
          (testValue000 == Logic.KWD_PREDICATE)) {
        { Stella_Object inmember = (isaconjunct.arguments.theArray)[0];
          Surrogate intype = ((Surrogate)(isaconjunct.operator));

          { boolean testValue001 = false;

            testValue001 = ((Boolean)(Logic.$POSTOPTIMIZATIONp$.get())).booleanValue();
            if (testValue001) {
              testValue001 = Stella_Object.typeP(intype);
              if (testValue001) {
                testValue001 = Stella_Object.surrogateP(((Surrogate)(otherconjunct.operator)));
                if (testValue001) {
                  { boolean foundP000 = false;

                    { Stella_Object arg = null;
                      Vector vector000 = otherconjunct.arguments;
                      int index000 = 0;
                      int length000 = vector000.length();
                      Surrogate argtype = null;
                      Cons iter000 = Logic.getDescription(((Surrogate)(otherconjunct.operator))).ioVariableTypes.theConsList;

                      loop000 : for (;(index000 < length000) &&
                                (!(iter000 == Stella.NIL)); index000 = index000 + 1, iter000 = iter000.rest) {
                        arg = (vector000.theArray)[index000];
                        argtype = ((Surrogate)(iter000.value));
                        if (Stella_Object.eqlP(arg, inmember) &&
                            Logic.logicalSubtypeOfP(argtype, intype)) {
                          foundP000 = true;
                          break loop000;
                        }
                      }
                    }
                    testValue001 = foundP000;
                  }
                }
              }
            }
            { boolean value000 = testValue001;

              return (value000);
            }
          }
        }
      }
      else {
        return (false);
      }
    }
  }

  public static double dynamicallyEstimateUnboundVariablePenalty(Proposition goal) {
    { Keyword testValue000 = goal.kind;

      if ((testValue000 == Logic.KWD_NOT) ||
          (testValue000 == Logic.KWD_FAIL)) {
        return (Proposition.dynamicallyEstimateUnboundVariablePenalty(((Proposition)((goal.arguments.theArray)[0]))));
      }
      else if (testValue000 == Logic.KWD_AND) {
        { double penalty = Stella.NULL_FLOAT;
          double minpenalty = Stella.NULL_FLOAT;

          { Stella_Object arg = null;
            Vector vector000 = goal.arguments;
            int index000 = 0;
            int length000 = vector000.length();

            for (;index000 < length000; index000 = index000 + 1) {
              arg = (vector000.theArray)[index000];
              penalty = Proposition.dynamicallyEstimateUnboundVariablePenalty(((Proposition)(arg)));
              if ((minpenalty == Stella.NULL_FLOAT) ||
                  (penalty < minpenalty)) {
                minpenalty = penalty;
              }
            }
          }
          return (minpenalty);
        }
      }
      else if (testValue000 == Logic.KWD_OR) {
        { double totalpenalty = 0.0;

          { Stella_Object arg = null;
            Vector vector001 = goal.arguments;
            int index001 = 0;
            int length001 = vector001.length();

            for (;index001 < length001; index001 = index001 + 1) {
              arg = (vector001.theArray)[index001];
              totalpenalty = totalpenalty + Proposition.dynamicallyEstimateUnboundVariablePenalty(((Proposition)(arg)));
            }
          }
          return (totalpenalty);
        }
      }
      else if ((testValue000 == Logic.KWD_FUNCTION) ||
          ((testValue000 == Logic.KWD_PREDICATE) ||
           ((testValue000 == Logic.KWD_EQUIVALENT) ||
            (testValue000 == Logic.KWD_ISA)))) {
        { Vector arguments = goal.arguments;
          GeneralizedSymbol operator = goal.operator;
          boolean holdsP = operator == Logic.SGT_PL_KERNEL_KB_HOLDS;
          boolean isfunctionP = (goal.kind == Logic.KWD_FUNCTION) ||
              (holdsP &&
               ((!Logic.unboundVariableP((arguments.theArray)[0])) &&
                Logic.functionP(Logic.argumentBoundTo((arguments.theArray)[0]))));
          int firstkeyargindex = (holdsP ? 1 : 0);
          int lastkeyargindex = (isfunctionP ? (arguments.length() - 2) : (arguments.length() - 1));
          int nofunboundvars = ((holdsP &&
              Logic.unboundVariableP((arguments.theArray)[0])) ? 10 : 0);

          if (lastkeyargindex < firstkeyargindex) {
            return (0.0);
          }
          { int i = Stella.NULL_INTEGER;
            int iter000 = firstkeyargindex;
            int upperBound000 = lastkeyargindex;
            boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

            for (;unboundedP000 ||
                      (iter000 <= upperBound000); iter000 = iter000 + 1) {
              i = iter000;
              if (Logic.unboundVariableP((arguments.theArray)[i])) {
                nofunboundvars = nofunboundvars + 1;
              }
            }
          }
          if (Proposition.computedPredicateP(goal)) {
            switch (nofunboundvars) {
              case 0: 
                return (0.0);
              case 1: 
                if (Description.computedConstraintP(Logic.getDescription(operator)) &&
                    ((!isfunctionP) ||
                     (!Logic.unboundVariableP((arguments.theArray)[(lastkeyargindex + 1)])))) {
                  return (0.0);
                }
              break;
              default:
              break;
            }
            return (10000.0);
          }
          return (1.0 + (nofunboundvars * (((double)(nofunboundvars)) / ((lastkeyargindex - firstkeyargindex) - -1))));
        }
      }
      else {
        return (3.0);
      }
    }
  }

  public static int countBoundArguments(Proposition goal) {
    { int count = 0;

      { Keyword testValue000 = goal.kind;

        if ((testValue000 == Logic.KWD_NOT) ||
            (testValue000 == Logic.KWD_FAIL)) {
          return (Proposition.countBoundArguments(((Proposition)((goal.arguments.theArray)[0]))));
        }
        else if ((testValue000 == Logic.KWD_AND) ||
            (testValue000 == Logic.KWD_OR)) {
          { Stella_Object arg = null;
            Vector vector000 = goal.arguments;
            int index000 = 0;
            int length000 = vector000.length();

            for (;index000 < length000; index000 = index000 + 1) {
              arg = (vector000.theArray)[index000];
              count = count + Proposition.countBoundArguments(((Proposition)(arg)));
            }
          }
        }
        else if ((testValue000 == Logic.KWD_FUNCTION) ||
            ((testValue000 == Logic.KWD_PREDICATE) ||
             ((testValue000 == Logic.KWD_EQUIVALENT) ||
              (testValue000 == Logic.KWD_ISA)))) {
          { Stella_Object arg = null;
            Vector vector001 = goal.arguments;
            int index001 = 0;
            int length001 = vector001.length();
            int i = Stella.NULL_INTEGER;
            int iter000 = 0;

            loop001 : for (;index001 < length001; index001 = index001 + 1, iter000 = iter000 + 1) {
              arg = (vector001.theArray)[index001];
              i = iter000;
              if ((i == 0) &&
                  (goal.operator == Logic.SGT_PL_KERNEL_KB_HOLDS)) {
                continue loop001;
              }
              if (!(Logic.unboundVariableP(arg))) {
                count = count + 1;
              }
            }
          }
        }
        else {
          count = 1;
        }
      }
      return (count);
    }
  }

  public static double dynamicallyEstimateInstanceOfGoalFanout(Proposition goal) {
    { Stella_Object instancevalue = Logic.argumentBoundTo((goal.arguments.theArray)[0]);
      Stella_Object collectionvalue = Logic.argumentBoundTo((goal.arguments.theArray)[1]);

      if (instancevalue != null) {
        return (((double)(Logic.allTypes(instancevalue).length())));
      }
      else if (collectionvalue != null) {
        { Surrogate testValue000 = Stella_Object.safePrimaryType(collectionvalue);

          if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_DESCRIPTION)) {
            { Description collectionvalue000 = ((Description)(collectionvalue));

              return ((Stella_Object.isaP(collectionvalue000, Logic.SGT_LOGIC_NAMED_DESCRIPTION) ? NamedDescription.dynamicallyEstimateExtensionSize(((NamedDescription)(collectionvalue000))) : Logic.ESTIMATED_CARDINALITY_OF_DESCRIPTION));
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_STELLA_COLLECTION)) {
            { Collection collectionvalue000 = ((Collection)(collectionvalue));

              return (((double)(collectionvalue000.length())));
            }
          }
          else {
            return (Stella.NULL_FLOAT);
          }
        }
      }
      else {
        return (Stella.NULL_FLOAT);
      }
    }
  }

  public static double dynamicallyEstimatePredicateGoalFanout(Proposition goal) {
    { GeneralizedSymbol testValue000 = goal.operator;

      if (testValue000 == Logic.SGT_PL_KERNEL_KB_MEMBER_OF) {
        return (Proposition.estimateMemberOfGoalFanout(goal));
      }
      else if (testValue000 == Logic.SGT_PL_KERNEL_KB_INSTANCE_OF) {
        return (Proposition.dynamicallyEstimateInstanceOfGoalFanout(goal));
      }
      else {
        { Cons patternargs = Stella.NIL;
          GeneralizedSymbol relation = goal.operator;
          Vector arguments = goal.arguments;
          int firstargindex = 0;
          int nofunboundargs = 0;
          int unboundargindex = Stella.NULL_INTEGER;
          Stella_Object key = null;
          boolean relationextensionP = true;
          NamedDescription description = Logic.getDescription(relation);

          if (relation == Logic.SGT_PL_KERNEL_KB_HOLDS) {
            if (Stella_Object.isaP(Logic.argumentBoundTo((arguments.theArray)[0]), Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
              description = ((NamedDescription)(Logic.argumentBoundTo((arguments.theArray)[0])));
              firstargindex = 1;
            }
            else {
              description = null;
            }
          }
          if (description == null) {
            return (Stella.NULL_FLOAT);
          }
          { int i = Stella.NULL_INTEGER;
            int iter000 = firstargindex;
            int upperBound000 = arguments.length() - 1;
            Cons collect000 = null;

            for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
              i = iter000;
              key = Logic.argumentBoundTo((arguments.theArray)[i]);
              if (key != null) {
                if (Logic.instanceHasBacklinksP(key)) {
                  relationextensionP = false;
                }
              }
              else {
                nofunboundargs = nofunboundargs + 1;
                unboundargindex = i;
              }
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(key, Stella.NIL);
                  if (patternargs == Stella.NIL) {
                    patternargs = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(patternargs, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(key, Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
          if (Description.computedTermP(description)) {
            switch (nofunboundargs) {
              case 0: 
                return (((double)(1)));
              case 1: 
                if (unboundargindex == (arguments.length() - 1)) {
                  return (((double)(1)));
                }
                else if (Description.computedConstraintP(description)) {
                  return (((double)(1)));
                }
              break;
              default:
              break;
            }
            return (Stella.NULL_FLOAT);
          }
          if (Logic.testPropertyP(description, Logic.SGT_PL_KERNEL_KB_TOTAL) &&
              ((nofunboundargs > 1) &&
               (unboundargindex == (arguments.length() - 1)))) {
            return (Stella.NULL_FLOAT);
          }
          if (relationextensionP) {
            return (NamedDescription.dynamicallyEstimateExtensionSize(description));
          }
          else {
            return (((double)(Logic.selectPropositions(Cons.cons(Logic.KWD_RELATION, Cons.cons(((Stella.NIL == null) ? Stella.NIL : Stella.NIL), Cons.cons(relation, patternargs)))).estimatedLength())));
          }
        }
      }
    }
  }

  public static double dynamicallyEstimateGoalFanout(Proposition goal) {
    if (Proposition.allArgumentsBoundP(goal)) {
      return (1.0);
    }
    { Keyword testValue000 = goal.kind;

      if (testValue000 == Logic.KWD_ISA) {
        return (NamedDescription.dynamicallyEstimateExtensionSize(Logic.getDescription(((Surrogate)(goal.operator)))));
      }
      else if ((testValue000 == Logic.KWD_FUNCTION) ||
          (testValue000 == Logic.KWD_PREDICATE)) {
        if (goal.operator == Logic.SGT_PL_KERNEL_KB_HOLDS) {
          if (!Logic.argumentBoundP((goal.arguments.theArray)[0])) {
            return (Stella.NULL_FLOAT);
          }
          else {
            return (Proposition.dynamicallyEstimatePredicateGoalFanout(goal));
          }
        }
        if (Proposition.allKeyArgumentsBoundP(goal)) {
          return (1.0);
        }
        else {
          return (Proposition.dynamicallyEstimatePredicateGoalFanout(goal));
        }
      }
      else if (testValue000 == Logic.KWD_IMPLIES) {
        return (Logic.ESTIMATED_CARDINALITY_OF_SUBSET_OF);
      }
      else if (testValue000 == Logic.KWD_EQUIVALENT) {
        if (Logic.argumentBoundP((goal.arguments.theArray)[0]) ||
            Logic.argumentBoundP((goal.arguments.theArray)[1])) {
          return (1.0);
        }
        else {
          return (Stella.NULL_FLOAT);
        }
      }
      else if ((testValue000 == Logic.KWD_NOT) ||
          ((testValue000 == Logic.KWD_FAIL) ||
           (testValue000 == Logic.KWD_FORALL))) {
        return (Stella.NULL_FLOAT);
      }
      else if (testValue000 == Logic.KWD_AND) {
        { double fanout = Stella.NULL_FLOAT;
          double minfanout = Stella.NULL_FLOAT;

          { Stella_Object arg = null;
            Vector vector000 = goal.arguments;
            int index000 = 0;
            int length000 = vector000.length();

            for (;index000 < length000; index000 = index000 + 1) {
              arg = (vector000.theArray)[index000];
              fanout = Proposition.dynamicallyEstimateGoalFanout(((Proposition)(arg)));
              if ((minfanout == Stella.NULL_FLOAT) ||
                  (fanout < minfanout)) {
                minfanout = fanout;
              }
            }
          }
          return (minfanout);
        }
      }
      else if (testValue000 == Logic.KWD_OR) {
        { double fanout = Stella.NULL_FLOAT;
          double totalfanout = Stella.NULL_FLOAT;

          { Stella_Object arg = null;
            Vector vector001 = goal.arguments;
            int index001 = 0;
            int length001 = vector001.length();

            for (;index001 < length001; index001 = index001 + 1) {
              arg = (vector001.theArray)[index001];
              fanout = Proposition.dynamicallyEstimateGoalFanout(((Proposition)(arg)));
              if (fanout != Stella.NULL_FLOAT) {
                if (totalfanout == Stella.NULL_FLOAT) {
                  totalfanout = 0.0;
                }
                totalfanout = totalfanout + fanout;
              }
            }
          }
          return (totalfanout);
        }
      }
      else {
        return (Stella.NULL_FLOAT);
      }
    }
  }

  public static double dynamicallyEstimateGoalCost(Proposition goal) {
    { Keyword testValue000 = goal.kind;

      if ((testValue000 == Logic.KWD_ISA) ||
          ((testValue000 == Logic.KWD_FUNCTION) ||
           (testValue000 == Logic.KWD_PREDICATE))) {
        { GeneralizedSymbol operator = goal.operator;
          NamedDescription description = Logic.getDescription(operator);
          Stella_Object firstargvalue = null;

          if (operator == Logic.SGT_PL_KERNEL_KB_HOLDS) {
            firstargvalue = Logic.argumentBoundTo((goal.arguments.theArray)[0]);
            if (firstargvalue != null) {
              if (Stella_Object.isaP(firstargvalue, Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
                description = ((NamedDescription)(firstargvalue));
              }
              else {
                description = null;
              }
            }
            else {
              return (Logic.INFERABLE_PENALTY_COST);
            }
          }
          if ((description == null) ||
              (!Description.inferableP(description))) {
            return (1.0);
          }
          else {
            return (NamedDescription.dynamicallyEstimateInferenceCost(description));
          }
        }
      }
      else if (testValue000 == Logic.KWD_IMPLIES) {
        return (Logic.SUBSET_OF_PENALTY_COST);
      }
      else {
        return (1.0);
      }
    }
  }

  public static boolean staticallyOptimizePropositionP(Proposition self) {
    return (((!(Logic.$QUERY_OPTIMIZATION_STRATEGY$ == Logic.KWD_NONE)) &&
        (!((Logic.$QUERY_OPTIMIZATION_STRATEGY$ == Logic.KWD_DYNAMIC) ||
        (Logic.$QUERY_OPTIMIZATION_STRATEGY$ == Logic.KWD_DYNAMIC_WITH_CLUSTERING)))) &&
        (!((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DONT_OPTIMIZEp, Stella.FALSE_WRAPPER))).wrapperValue));
  }

  public static boolean dynamicallyOptimizePropositionP(Proposition self) {
    return (((Logic.$QUERY_OPTIMIZATION_STRATEGY$ == Logic.KWD_DYNAMIC) ||
        (Logic.$QUERY_OPTIMIZATION_STRATEGY$ == Logic.KWD_DYNAMIC_WITH_CLUSTERING)) &&
        (!((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DONT_OPTIMIZEp, Stella.FALSE_WRAPPER))).wrapperValue));
  }

  public static void simulateAndOptimizeQuery(Proposition proposition) {
    { Vector arguments = proposition.arguments;
      Keyword kind = proposition.kind;

      if (((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue()) {
        if (kind == Logic.KWD_AND) {
          kind = Logic.KWD_OR;
        }
        else if (kind == Logic.KWD_OR) {
          kind = Logic.KWD_AND;
        }
        else if (kind == Logic.KWD_IMPLIES) {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("REVERSE POLARITY NOT YET IMPLEMENTED FOR :IMPLIES WITHIN QUERY OPTIMIZER");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
        else {
        }
      }
      if ((kind == Logic.KWD_ISA) ||
          ((kind == Logic.KWD_PREDICATE) ||
           ((kind == Logic.KWD_FUNCTION) ||
            (kind == Logic.KWD_EQUIVALENT)))) {
        Proposition.simulateGoalEvaluation(proposition);
        { Stella_Object arg = null;
          Vector vector000 = arguments;
          int index000 = 0;
          int length000 = vector000.length();

          for (;index000 < length000; index000 = index000 + 1) {
            arg = (vector000.theArray)[index000];
            Logic.simulateAndOptimizeArgument(arg);
          }
        }
      }
      else if (kind == Logic.KWD_AND) {
        { int choicepointunbindingoffset = Logic.simulateCreateChoicePoint();

          Logic.initializeOptimizerMemory(-1);
          Proposition.optimizeOrderingOfConjuncts(proposition);
          PatternRecord.unbindVariablesBeginningAt(((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord, choicepointunbindingoffset);
        }
        { Stella_Object arg = null;
          Vector vector001 = proposition.arguments;
          int index001 = 0;
          int length001 = vector001.length();

          for (;index001 < length001; index001 = index001 + 1) {
            arg = (vector001.theArray)[index001];
            Proposition.simulateAndOptimizeQuery(((Proposition)(arg)));
          }
        }
      }
      else if (kind == Logic.KWD_OR) {
        { Stella_Object arg = null;
          Vector vector002 = arguments;
          int index002 = 0;
          int length002 = vector002.length();

          for (;index002 < length002; index002 = index002 + 1) {
            arg = (vector002.theArray)[index002];
            { int choicepointunbindingoffset = Logic.simulateCreateChoicePoint();

              Proposition.simulateAndOptimizeQuery(((Proposition)(arg)));
              PatternRecord.unbindVariablesBeginningAt(((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord, choicepointunbindingoffset);
            }
          }
        }
      }
      else if (kind == Logic.KWD_NOT) {
        { boolean oldreversepolarityP = ((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue();

          { Object old$ReversepolarityP$000 = Logic.$REVERSEPOLARITYp$.get();

            try {
              Native.setBooleanSpecial(Logic.$REVERSEPOLARITYp$, !oldreversepolarityP);
              if (((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue()) {
                Proposition.warnOfUnboundVariableArgument(proposition);
              }
              Proposition.simulateAndOptimizeQuery(((Proposition)((arguments.theArray)[0])));

            } finally {
              Logic.$REVERSEPOLARITYp$.set(old$ReversepolarityP$000);
            }
          }
        }
      }
      else if (kind == Logic.KWD_IMPLIES) {
        Proposition.warnOfUnboundVariableArgument(proposition);
        { Stella_Object arg = null;
          Vector vector003 = arguments;
          int index003 = 0;
          int length003 = vector003.length();

          for (;index003 < length003; index003 = index003 + 1) {
            arg = (vector003.theArray)[index003];
            Logic.simulateAndOptimizeArgument(arg);
          }
        }
      }
      else if (kind == Logic.KWD_EXISTS) {
        Proposition.simulateAndOptimizeQuery(((Proposition)((arguments.theArray)[0])));
      }
      else if (kind == Logic.KWD_FORALL) {
        { int choicepointunbindingoffset = Logic.simulateCreateChoicePoint();

          { Stella_Object arg = null;
            Vector vector004 = arguments;
            int index004 = 0;
            int length004 = vector004.length();

            for (;index004 < length004; index004 = index004 + 1) {
              arg = (vector004.theArray)[index004];
              Logic.simulateAndOptimizeArgument(arg);
            }
          }
          PatternRecord.unbindVariablesBeginningAt(((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord, choicepointunbindingoffset);
        }
      }
      else {
      }
    }
  }

  public static void simulateGoalEvaluation(Proposition goal) {
    { Vector arguments = goal.arguments;
      boolean okP = false;

      { Keyword testValue000 = goal.kind;

        if (testValue000 == Logic.KWD_FUNCTION) {
          { boolean chooseValue000 = false;

            if (Proposition.computedPredicateP(goal)) {
              { boolean alwaysP000 = true;

                { Stella_Object arg = null;
                  Iterator iter000 = arguments.butLast();

                  loop000 : while (iter000.nextP()) {
                    arg = iter000.value;
                    if (!Logic.argumentBoundP(arg)) {
                      alwaysP000 = false;
                      break loop000;
                    }
                  }
                }
                chooseValue000 = alwaysP000;
              }
            }
            else {
              { boolean foundP000 = false;

                { Stella_Object arg = null;
                  Vector vector000 = arguments;
                  int index000 = 0;
                  int length000 = vector000.length();

                  loop001 : for (;index000 < length000; index000 = index000 + 1) {
                    arg = (vector000.theArray)[index000];
                    if (Logic.argumentBoundP(arg) &&
                        Logic.typeHasBacklinksP(Logic.ensureDeferredDescription(Logic.logicalType(arg)))) {
                      foundP000 = true;
                      break loop001;
                    }
                  }
                }
                chooseValue000 = foundP000;
              }
            }
            okP = chooseValue000;
          }
        }
        else if (testValue000 == Logic.KWD_PREDICATE) {
          if (goal.operator == Logic.SGT_PL_KERNEL_KB_MEMBER_OF) {
            okP = Logic.argumentBoundP((arguments.theArray)[1]);
          }
          else {
            { boolean chooseValue001 = false;

              if (Proposition.computedPredicateP(goal)) {
                { boolean alwaysP001 = true;

                  { Stella_Object arg = null;
                    Vector vector001 = arguments;
                    int index001 = 0;
                    int length001 = vector001.length();

                    loop002 : for (;index001 < length001; index001 = index001 + 1) {
                      arg = (vector001.theArray)[index001];
                      if (!Logic.argumentBoundP(arg)) {
                        alwaysP001 = false;
                        break loop002;
                      }
                    }
                  }
                  chooseValue001 = alwaysP001;
                }
              }
              else {
                { boolean foundP001 = false;

                  { Stella_Object arg = null;
                    Vector vector002 = arguments;
                    int index002 = 0;
                    int length002 = vector002.length();

                    loop003 : for (;index002 < length002; index002 = index002 + 1) {
                      arg = (vector002.theArray)[index002];
                      if (Logic.argumentBoundP(arg) &&
                          Logic.typeHasBacklinksP(Logic.ensureDeferredDescription(Logic.logicalType(arg)))) {
                        foundP001 = true;
                        break loop003;
                      }
                    }
                  }
                  chooseValue001 = foundP001;
                }
              }
              okP = chooseValue001;
            }
          }
        }
        else if (testValue000 == Logic.KWD_ISA) {
          okP = true;
        }
        else if (testValue000 == Logic.KWD_EQUIVALENT) {
          okP = Logic.argumentBoundP((arguments.theArray)[0]) ||
              Logic.argumentBoundP((arguments.theArray)[1]);
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      if (!okP) {
        Proposition.warnOfUnboundVariableArgument(goal);
      }
      { Stella_Object arg = null;
        Vector vector003 = arguments;
        int index003 = 0;
        int length003 = vector003.length();

        for (;index003 < length003; index003 = index003 + 1) {
          arg = (vector003.theArray)[index003];
          Logic.simulateBindVariableToValue(arg);
        }
      }
    }
  }

  public static void warnOfUnboundVariableArgument(Proposition proposition) {
    return;
  }

  public static void reorderGoals(Proposition andproposition, List initiallyclosedgoals, List goalsequence, List residuegoals) {
    { Vector arguments = andproposition.arguments;
      int originalnumberofarguments = arguments.length();
      int index = 0;

      { Proposition g = null;
        Cons iter000 = initiallyclosedgoals.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          g = ((Proposition)(iter000.value));
          (arguments.theArray)[index] = g;
          index = index + 1;
        }
      }
      { Proposition g = null;
        Cons iter001 = goalsequence.theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          g = ((Proposition)(iter001.value));
          residuegoals.remove(g);
          (arguments.theArray)[index] = g;
          index = index + 1;
        }
      }
      { Proposition g = null;
        Cons iter002 = residuegoals.theConsList;

        for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
          g = ((Proposition)(iter002.value));
          (arguments.theArray)[index] = g;
          index = index + 1;
        }
      }
      if (index < originalnumberofarguments) {
        andproposition.arguments = Vector.newVector(index);
        { Stella_Object arg = null;
          Vector vector000 = arguments;
          int index000 = 0;
          int length000 = vector000.length();
          int i = Stella.NULL_INTEGER;
          int iter003 = 0;
          int upperBound000 = index - 1;

          for (;(index000 < length000) &&
                    (iter003 <= upperBound000); index000 = index000 + 1, iter003 = iter003 + 1) {
            arg = (vector000.theArray)[index000];
            i = iter003;
            (andproposition.arguments.theArray)[i] = arg;
          }
        }
      }
    }
  }

  public static void optimizeOrderingOfConjuncts(Proposition andproposition) {
    { List initiallyclosedgoals = List.newList();
      List opengoals = List.newList();
      List goalsequence = List.newList();

      { Stella_Object g = null;
        Vector vector000 = andproposition.arguments;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          g = (vector000.theArray)[index000];
          if (Proposition.allArgumentsBoundP(((Proposition)(g)))) {
            initiallyclosedgoals.insert(((Proposition)(g)));
          }
          else if (Proposition.hasDisjunctionP(((Proposition)(g))) ||
              (((Proposition)(g)).kind == Logic.KWD_FORALL)) {
            ((QueryIterator)(Logic.$QUERYITERATOR$.get())).residueGoals().insert(((Proposition)(g)));
          }
          else {
            opengoals.insert(((Proposition)(g)));
          }
        }
      }
      { Proposition goal = null;
        Cons iter000 = opengoals.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          goal = ((Proposition)(iter000.value));
          Proposition.distributeOpenGoal(goal);
        }
      }
      { Proposition g = null;
        Cons iter001 = opengoals.theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          g = ((Proposition)(iter001.value));
          { boolean foundP000 = false;

            { Stella_Object arg = null;
              Vector vector001 = g.arguments;
              int index001 = 0;
              int length001 = vector001.length();

              loop003 : for (;index001 < length001; index001 = index001 + 1) {
                arg = (vector001.theArray)[index001];
                if (Logic.argumentBoundP(arg)) {
                  foundP000 = true;
                  break loop003;
                }
              }
            }
            if (foundP000) {
              Proposition.propagateSingleValuedConstraints(g, goalsequence);
            }
          }
        }
      }
      Proposition.computeOpenGoalOrdering(andproposition, opengoals, goalsequence);
      Proposition.reorderGoals(andproposition, initiallyclosedgoals.reverse(), ((QueryIterator)(Logic.$QUERYITERATOR$.get())).bestGoalSequence().reverse(), ((QueryIterator)(Logic.$QUERYITERATOR$.get())).residueGoals());
      if ((Stella.$TRACED_KEYWORDS$ != null) &&
          Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_OPTIMIZER)) {
        Stella.STANDARD_OUTPUT.nativeStream.println("Optimized goal: " + andproposition);
      }
    }
  }

  public static void computeOpenGoalOrdering(Proposition andproposition, List opengoals, List goalsequence) {
    { List opengoalclusters = List.newList();
      List clusterpropositions = Stella.NIL_LIST;
      List optimizervariables = List.newList();
      Cons initialgoalsequence = null;
      Cons initialresiduegoals = null;

      if (Logic.$QUERY_OPTIMIZATION_STRATEGY$ == Logic.KWD_STATIC_WITH_CLUSTERING) {
        Logic.extractOpenGoalClusters(opengoals, opengoalclusters);
      }
      if (opengoalclusters.nonEmptyP()) {
        clusterpropositions = List.newList();
        { Object old$Evaluationmode$000 = Logic.$EVALUATIONMODE$.get();

          try {
            Native.setSpecial(Logic.$EVALUATIONMODE$, Logic.KWD_DESCRIPTION);
            { List cluster = null;
              Cons iter000 = opengoalclusters.theConsList;
              Cons collect000 = null;

              for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                cluster = ((List)(iter000.value));
                if (collect000 == null) {
                  {
                    collect000 = Cons.cons(((cluster.length() > 1) ? Proposition.fastenDownOneProposition(Logic.conjoinPropositions(cluster.theConsList), true) : ((Proposition)(cluster.first()))), Stella.NIL);
                    if (clusterpropositions.theConsList == Stella.NIL) {
                      clusterpropositions.theConsList = collect000;
                    }
                    else {
                      Cons.addConsToEndOfConsList(clusterpropositions.theConsList, collect000);
                    }
                  }
                }
                else {
                  {
                    collect000.rest = Cons.cons(((cluster.length() > 1) ? Proposition.fastenDownOneProposition(Logic.conjoinPropositions(cluster.theConsList), true) : ((Proposition)(cluster.first()))), Stella.NIL);
                    collect000 = collect000.rest;
                  }
                }
              }
            }

          } finally {
            Logic.$EVALUATIONMODE$.set(old$Evaluationmode$000);
          }
        }
        { Proposition prop = null;
          Cons iter001 = clusterpropositions.theConsList;
          Cons collect001 = null;

          for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
            prop = ((Proposition)(iter001.value));
            if (!(prop.kind == Logic.KWD_AND)) {
              if (collect001 == null) {
                {
                  collect001 = Cons.cons(prop, Stella.NIL);
                  if (opengoals.theConsList == Stella.NIL) {
                    opengoals.theConsList = collect001;
                  }
                  else {
                    Cons.addConsToEndOfConsList(opengoals.theConsList, collect001);
                  }
                }
              }
              else {
                {
                  collect001.rest = Cons.cons(prop, Stella.NIL);
                  collect001 = collect001.rest;
                }
              }
            }
          }
        }
        { ListIterator it = ((ListIterator)(goalsequence.allocateIterator()));

          while (it.nextP()) {
            if (!opengoals.memberP(((Proposition)(it.value)))) {
              it.valueSetter(null);
            }
          }
        }
        goalsequence.remove(null);
      }
      opengoalclusters.free();
      initialgoalsequence = goalsequence.theConsList;
      initialresiduegoals = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).residueGoals().theConsList;
      { Proposition goal = null;
        Cons iter002 = opengoals.theConsList;

        for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
          goal = ((Proposition)(iter002.value));
          Proposition.collectOptimizerVariables(goal, optimizervariables);
        }
      }
      { Object old$Optimalgoalorderingrecursions$000 = Logic.$OPTIMALGOALORDERINGRECURSIONS$.get();

        try {
          Native.setIntSpecial(Logic.$OPTIMALGOALORDERINGRECURSIONS$, 0);
          Logic.computeOptimalOpenGoalOrdering(optimizervariables, opengoals.length(), goalsequence, 1.0, 1.0);
          if (((Integer)(Logic.$OPTIMALGOALORDERINGRECURSIONS$.get())).intValue() >= Logic.$OPTIMAL_GOAL_ORDERING_CUTOFF$) {
            goalsequence.theConsList = initialgoalsequence;
            ((QueryIterator)(Logic.$QUERYITERATOR$.get())).residueGoals().theConsList = initialresiduegoals;
            ((QueryIterator)(Logic.$QUERYITERATOR$.get())).bestGoalSequence().clear();
            KeyValueList.setDynamicSlotValue(((QueryIterator)(Logic.$QUERYITERATOR$.get())).dynamicSlots, Logic.SYM_LOGIC_BEST_COST, FloatWrapper.wrapFloat(Stella.NULL_FLOAT), Stella.NULL_FLOAT_WRAPPER);
            Logic.computeGreedyOpenGoalOrdering(optimizervariables, opengoals.length(), goalsequence, 1.0, 1.0);
          }

        } finally {
          Logic.$OPTIMALGOALORDERINGRECURSIONS$.set(old$Optimalgoalorderingrecursions$000);
        }
      }
      if (((QueryIterator)(Logic.$QUERYITERATOR$.get())).bestGoalSequence().emptyP() &&
          (!opengoals.emptyP())) {
        Logic.computeBackupOpenGoalOrdering(opengoals.reverse());
        if ((Stella.$TRACED_KEYWORDS$ != null) &&
            Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_OPTIMIZER)) {
          {
            Stella.STANDARD_OUTPUT.nativeStream.println("Using backup goal ordering:");
            Stella.STANDARD_OUTPUT.nativeStream.println("Original Goal: " + andproposition);
          }
;
        }
      }
      { Proposition prop = null;
        Cons iter003 = clusterpropositions.sort(Native.find_java_method("edu.isi.powerloom.logic.Proposition", "biggerConjunctionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")})).theConsList;

        for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
          prop = ((Proposition)(iter003.value));
          if (prop.kind == Logic.KWD_AND) {
            ((QueryIterator)(Logic.$QUERYITERATOR$.get())).bestGoalSequence().push(prop);
          }
        }
      }
    }
  }

  public static boolean biggerConjunctionP(Proposition prop1, Proposition prop2) {
    return (prop1.arguments.length() > prop2.arguments.length());
  }

  public static void collectOptimizerVariables(Proposition proposition, List collection) {
    { Keyword testValue000 = proposition.kind;

      if ((testValue000 == Logic.KWD_ISA) ||
          ((testValue000 == Logic.KWD_FUNCTION) ||
           ((testValue000 == Logic.KWD_PREDICATE) ||
            ((testValue000 == Logic.KWD_EQUIVALENT) ||
             (testValue000 == Logic.KWD_IMPLIES))))) {
        { Stella_Object arg = null;
          Vector vector000 = proposition.arguments;
          int index000 = 0;
          int length000 = vector000.length();

          for (;index000 < length000; index000 = index000 + 1) {
            arg = (vector000.theArray)[index000];
            if (Logic.unboundVariableP(arg)) {
              { PatternVariable variable = ((PatternVariable)(arg));

                if (!(variable == Logic.innermostOf(variable))) {
                  Logic.simulateBindVariableToValue(variable);
                }
                else if ((variable.definingProposition == null) &&
                    (!Skolem.anonymousVariableP(variable))) {
                  collection.insertNew(variable);
                }
              }
            }
          }
        }
      }
      else {
      }
    }
  }

  public static void collectUnboundGoalVariables(Proposition goal, List unboundvariables) {
    { Stella_Object arg = null;
      Vector vector000 = goal.arguments;
      int index000 = 0;
      int length000 = vector000.length();

      for (;index000 < length000; index000 = index000 + 1) {
        arg = (vector000.theArray)[index000];
        { Surrogate testValue000 = Stella_Object.safePrimaryType(arg);

          if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
            { PatternVariable arg000 = ((PatternVariable)(arg));

              if (Logic.unboundVariableP(arg000)) {
                unboundvariables.insertNew(arg000);
              }
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PROPOSITION)) {
            { Proposition arg000 = ((Proposition)(arg));

              Proposition.collectUnboundGoalVariables(arg000, unboundvariables);
              { Keyword testValue001 = arg000.kind;

                if ((testValue001 == Logic.KWD_FORALL) ||
                    (testValue001 == Logic.KWD_EXISTS)) {
                  { PatternVariable var = null;
                    Vector vector001 = ((Vector)(KeyValueList.dynamicSlotValue(arg000.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
                    int index001 = 0;
                    int length001 = vector001.length();

                    for (;index001 < length001; index001 = index001 + 1) {
                      var = ((PatternVariable)((vector001.theArray)[index001]));
                      unboundvariables.remove(var);
                    }
                  }
                }
                else {
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

  public static void bindAllVariablesInGeneratorGoal(Proposition goal, List goalsequence) {
    { Stella_Object arg = null;
      Vector vector000 = goal.arguments;
      int index000 = 0;
      int length000 = vector000.length();

      for (;index000 < length000; index000 = index000 + 1) {
        arg = (vector000.theArray)[index000];
        if (Stella_Object.isaP(arg, Logic.SGT_LOGIC_PATTERN_VARIABLE) &&
            Logic.unboundVariableP(arg)) {
          PatternVariable.simulateBindVariableAndPropagateConstraints(((PatternVariable)(arg)), goalsequence);
        }
      }
    }
  }

  public static void propagateSingleValuedConstraints(Proposition goal, List goalsequence) {
    { Vector arguments = goal.arguments;

      { Keyword testValue000 = goal.kind;

        if ((testValue000 == Logic.KWD_FUNCTION) ||
            (testValue000 == Logic.KWD_PREDICATE)) {
          if (Logic.singleValuedTermP(Logic.getDescription(((Surrogate)(goal.operator))))) {
            { boolean testValue001 = false;

              { boolean alwaysP000 = true;

                { Stella_Object arg = null;
                  Iterator iter000 = arguments.butLast();

                  loop000 : while (iter000.nextP()) {
                    arg = iter000.value;
                    if (!Logic.argumentBoundP(arg)) {
                      alwaysP000 = false;
                      break loop000;
                    }
                  }
                }
                testValue001 = alwaysP000;
              }
              if (testValue001) {
                testValue001 = Logic.unboundVariableP(arguments.last());
              }
              if (testValue001) {
                {
                  if (!goalsequence.memberP(goal)) {
                    goalsequence.push(goal);
                  }
                  PatternVariable.simulateBindVariableAndPropagateConstraints(((PatternVariable)(arguments.last())), goalsequence);
                }
              }
              else {
                {
                }
              }
            }
          }
        }
        else if ((testValue000 == Logic.KWD_ISA) ||
            (testValue000 == Logic.KWD_IMPLIES)) {
        }
        else if (testValue000 == Logic.KWD_EQUIVALENT) {
          if (Logic.unboundVariableP((arguments.theArray)[0])) {
            goalsequence.push(goal);
            PatternVariable.simulateBindVariableAndPropagateConstraints(((PatternVariable)((arguments.theArray)[0])), goalsequence);
          }
          else if (Logic.unboundVariableP((arguments.theArray)[1])) {
            goalsequence.push(goal);
            PatternVariable.simulateBindVariableAndPropagateConstraints(((PatternVariable)((arguments.theArray)[1])), goalsequence);
          }
        }
        else if ((testValue000 == Logic.KWD_NOT) ||
            (testValue000 == Logic.KWD_FAIL)) {
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  public static double estimateGoalFanout(Proposition goal) {
    { Keyword testValue000 = goal.kind;

      if (testValue000 == Logic.KWD_ISA) {
        return (NamedDescription.estimateCardinalityOfExtension(Logic.getDescription(((Surrogate)(goal.operator)))));
      }
      else if ((testValue000 == Logic.KWD_FUNCTION) ||
          (testValue000 == Logic.KWD_PREDICATE)) {
        return (Proposition.estimatePredicateGoalFanout(goal));
      }
      else if (testValue000 == Logic.KWD_IMPLIES) {
        return (Logic.ESTIMATED_CARDINALITY_OF_SUBSET_OF);
      }
      else if (testValue000 == Logic.KWD_EQUIVALENT) {
        if (Logic.argumentBoundP((goal.arguments.theArray)[0]) ||
            Logic.argumentBoundP((goal.arguments.theArray)[1])) {
          return (1.0);
        }
        else {
          return (Stella.NULL_FLOAT);
        }
      }
      else if ((testValue000 == Logic.KWD_NOT) ||
          (testValue000 == Logic.KWD_FAIL)) {
        return (Stella.NULL_FLOAT);
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static double estimateGoalCost(Proposition goal) {
    { Keyword testValue000 = goal.kind;

      if ((testValue000 == Logic.KWD_ISA) ||
          ((testValue000 == Logic.KWD_FUNCTION) ||
           (testValue000 == Logic.KWD_PREDICATE))) {
        { NamedDescription description = Logic.getDescription(((Surrogate)(goal.operator)));

          if ((description == null) ||
              (!Description.inferableP(description))) {
            return (1.0);
          }
          else {
            return (Logic.INFERABLE_PENALTY_COST);
          }
        }
      }
      else if (testValue000 == Logic.KWD_IMPLIES) {
        return (Logic.SUBSET_OF_PENALTY_COST);
      }
      else {
        return (1.0);
      }
    }
  }

  public static double estimatePredicateGoalFanout(Proposition goal) {
    if (goal.operator == Logic.SGT_PL_KERNEL_KB_MEMBER_OF) {
      return (Proposition.estimateMemberOfGoalFanout(goal));
    }
    { NamedDescription description = Logic.getDescription(((Surrogate)(goal.operator)));
      BooleanVector goalvector = Logic.argumentsVectorToBooleanVector(goal.arguments);

      if (description == null) {
        return (Stella.NULL_FLOAT);
      }
      { boolean testValue000 = false;

        { boolean foundP000 = false;

          { BooleanWrapper gbit = null;
            BooleanVector vector000 = goalvector;
            int index000 = 0;
            int length000 = vector000.length();
            BooleanWrapper ibit = null;
            BooleanVector vector001 = NamedDescription.getIndexingVector(description);
            int index001 = 0;
            int length001 = vector001.length();

            loop000 : for (;(index000 < length000) &&
                      (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
              gbit = ((BooleanWrapper)((vector000.theArray)[index000]));
              ibit = ((BooleanWrapper)((vector001.theArray)[index001]));
              if ((ibit == Stella.TRUE_WRAPPER) &&
                  (gbit == Stella.TRUE_WRAPPER)) {
                foundP000 = true;
                break loop000;
              }
            }
          }
          testValue000 = foundP000;
        }
        testValue000 = !testValue000;
        if (testValue000) {
          return (NamedDescription.estimateCardinalityOfExtension(Logic.getDescription(((Surrogate)(goal.operator)))));
        }
      }
      { boolean allbitsmatchP = false;

        { BooleanVector uniquenesskey = null;
          Cons iter000 = NamedDescription.getUniquenessVectors(description).theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            uniquenesskey = ((BooleanVector)(iter000.value));
            allbitsmatchP = true;
            { BooleanWrapper ubit = null;
              BooleanVector vector002 = uniquenesskey;
              int index002 = 0;
              int length002 = vector002.length();
              BooleanWrapper gbit = null;
              BooleanVector vector003 = goalvector;
              int index003 = 0;
              int length003 = vector003.length();

              loop002 : for (;(index002 < length002) &&
                        (index003 < length003); index002 = index002 + 1, index003 = index003 + 1) {
                ubit = ((BooleanWrapper)((vector002.theArray)[index002]));
                gbit = ((BooleanWrapper)((vector003.theArray)[index003]));
                if ((ubit == Stella.TRUE_WRAPPER) &&
                    (gbit == Stella.FALSE_WRAPPER)) {
                  allbitsmatchP = false;
                  break loop002;
                }
              }
            }
            if (allbitsmatchP) {
              return (1.0);
            }
          }
        }
        return (Logic.ESTIMATED_NUMBER_OF_PREDICATE_BINDINGS);
      }
    }
  }

  public static double estimateMemberOfGoalFanout(Proposition goal) {
    { Stella_Object membervalue = Logic.argumentBoundTo((goal.arguments.theArray)[0]);
      Stella_Object collectionvalue = Logic.argumentBoundTo((goal.arguments.theArray)[1]);

      if (membervalue != null) {
        return (Logic.ESTIMATED_CARDINALITY_OF_MEMBER_OF);
      }
      else if (collectionvalue != null) {
        { Surrogate testValue000 = Stella_Object.safePrimaryType(collectionvalue);

          if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_DESCRIPTION)) {
            { Description collectionvalue000 = ((Description)(collectionvalue));

              return ((Stella_Object.isaP(collectionvalue000, Logic.SGT_LOGIC_NAMED_DESCRIPTION) ? NamedDescription.estimateCardinalityOfExtension(((NamedDescription)(collectionvalue000))) : Logic.ESTIMATED_CARDINALITY_OF_DESCRIPTION));
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_STELLA_COLLECTION)) {
            { Collection collectionvalue000 = ((Collection)(collectionvalue));

              return (((double)(collectionvalue000.length())));
            }
          }
          else {
            return (Logic.ESTIMATED_SLOT_VALUE_COLLECTION_SIZE);
          }
        }
      }
      else {
        return (Stella.NULL_FLOAT);
      }
    }
  }

  public static void distributeOpenGoal(Proposition goal) {
    { Object old$DistributedopengoalP$000 = Logic.$DISTRIBUTEDOPENGOALp$.get();

      try {
        Native.setBooleanSpecial(Logic.$DISTRIBUTEDOPENGOALp$, false);
        { Keyword testValue000 = goal.kind;

          if (testValue000 == Logic.KWD_FUNCTION) {
            { Stella_Object arg = null;
              Iterator iter000 = goal.arguments.butLast();

              while (iter000.nextP()) {
                arg = iter000.value;
                Logic.helpDistributeGoal(arg, goal, !Proposition.computedPredicateP(goal));
              }
            }
            Logic.helpDistributeGoal((goal.arguments.theArray)[(goal.arguments.length() - 1)], goal, false);
          }
          else if (testValue000 == Logic.KWD_EQUIVALENT) {
            { Stella_Object arg = null;
              Vector vector000 = goal.arguments;
              int index000 = 0;
              int length000 = vector000.length();

              for (;index000 < length000; index000 = index000 + 1) {
                arg = (vector000.theArray)[index000];
                Logic.helpDistributeGoal(arg, goal, false);
              }
            }
          }
          else if (testValue000 == Logic.KWD_ISA) {
            Logic.helpDistributeGoal((goal.arguments.theArray)[0], goal, Logic.generatorCollectionP(Logic.getDescription(((Surrogate)(goal.operator)))));
          }
          else if (testValue000 == Logic.KWD_PREDICATE) {
            { Stella_Object arg = null;
              Vector vector001 = goal.arguments;
              int index001 = 0;
              int length001 = vector001.length();

              for (;index001 < length001; index001 = index001 + 1) {
                arg = (vector001.theArray)[index001];
                Logic.helpDistributeGoal(arg, goal, !Proposition.computedPredicateP(goal));
              }
            }
          }
          else if ((testValue000 == Logic.KWD_NOT) ||
              (testValue000 == Logic.KWD_FAIL)) {
            Logic.helpDistributeGoal((goal.arguments.theArray)[0], goal, false);
          }
          else if (testValue000 == Logic.KWD_IMPLIES) {
            { Stella_Object arg = null;
              Vector vector002 = goal.arguments;
              int index002 = 0;
              int length002 = vector002.length();

              for (;index002 < length002; index002 = index002 + 1) {
                arg = (vector002.theArray)[index002];
                Logic.helpDistributeGoal(arg, goal, true);
              }
            }
          }
          else {
          }
        }
        if (!((Boolean)(Logic.$DISTRIBUTEDOPENGOALp$.get())).booleanValue()) {
          ((QueryIterator)(Logic.$QUERYITERATOR$.get())).residueGoals().insert(goal);
        }

      } finally {
        Logic.$DISTRIBUTEDOPENGOALp$.set(old$DistributedopengoalP$000);
      }
    }
  }

  public static boolean computedPredicateP(Proposition goal) {
    { GeneralizedSymbol operator = goal.operator;
      Description description = null;

      if (operator == Logic.SGT_PL_KERNEL_KB_HOLDS) {
        { Stella_Object relationarg = Logic.argumentBoundTo((goal.arguments.theArray)[0]);

          if ((relationarg != null) &&
              Stella_Object.isaP(relationarg, Logic.SGT_LOGIC_DESCRIPTION)) {
            description = ((Description)(relationarg));
            operator = description.surrogateValueInverse;
          }
          else {
            return (false);
          }
        }
      }
      if (description == null) {
        description = Logic.getDescription(operator);
      }
      return ((description != null) &&
          (Description.computedTermP(description) ||
           ((operator == Logic.SGT_PL_KERNEL_KB_SETOF) ||
            (operator == Logic.SGT_PL_KERNEL_KB_LISTOF))));
    }
  }

  public static boolean hasInversionsP(Proposition goal) {
    return (((KeyValueList)(KeyValueList.dynamicSlotValue(Logic.getDescription(((Surrogate)(goal.operator))).dynamicSlots, Logic.SYM_LOGIC_PERMUTATION_TABLE, null))) != null);
  }

  public static boolean modalGoalP(Proposition goal) {
    { boolean foundP000 = false;

      { Stella_Object arg = null;
        Vector vector000 = goal.arguments;
        int index000 = 0;
        int length000 = vector000.length();

        loop000 : for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          if (Stella_Object.isaP(arg, Logic.SGT_LOGIC_PROPOSITION)) {
            foundP000 = true;
            break loop000;
          }
        }
      }
      { boolean value000 = foundP000;

        return (value000);
      }
    }
  }

  public static boolean hasDisjunctionP(Proposition goal) {
    if (goal.kind == Logic.KWD_OR) {
      return (true);
    }
    { boolean foundP000 = false;

      { Stella_Object arg = null;
        Vector vector000 = goal.arguments;
        int index000 = 0;
        int length000 = vector000.length();

        loop000 : for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          if (Stella_Object.isaP(arg, Logic.SGT_LOGIC_PROPOSITION) &&
              Proposition.hasDisjunctionP(((Proposition)(arg)))) {
            foundP000 = true;
            break loop000;
          }
        }
      }
      { boolean value000 = foundP000;

        return (value000);
      }
    }
  }

  public static Iterator allClashingPropositions(Proposition self) {
    { Vector arguments = self.arguments;
      Stella_Object lastarg = arguments.last();
      Stella_Object backlinkedarg = null;

      arguments.lastSetter(null);
      backlinkedarg = Proposition.selectArgumentWithBacklinks(self, new Object[1]);
      arguments.lastSetter(lastarg);
      if (backlinkedarg == null) {
        return (Logic.EMPTY_PROPOSITIONS_ITERATOR);
      }
      { Cons pattern = Cons.cons(Logic.KWD_RELATION, Cons.cons(((Stella.NIL == null) ? Stella.NIL : Stella.NIL), Cons.cons(((Surrogate)(self.operator)), Cons.cons(Logic.valueOf(backlinkedarg), Stella.NIL))));
        SequenceIndex index = Logic.selectPropositions(pattern);

        if (SequenceIndex.emptyPropositionsIndexP(index, backlinkedarg, false)) {
          return (Logic.EMPTY_PROPOSITIONS_ITERATOR);
        }
        { ClashingPropositionsIterator self000 = ClashingPropositionsIterator.newClashingPropositionsIterator();

          self000.selectionPattern = pattern;
          self000.propositionCursor = index.allocateIterator();
          self000.referenceProposition = self;
          { ClashingPropositionsIterator value000 = self000;

            return (value000);
          }
        }
      }
    }
  }

  public static boolean clashesWithFunctionPropositionP(Proposition nextproposition, Proposition referenceproposition) {
    { boolean alwaysP000 = true;

      { Stella_Object superarg = null;
        Iterator iter000 = referenceproposition.arguments.butLast();
        Stella_Object subarg = null;
        Iterator iter001 = nextproposition.arguments.butLast();

        loop000 : while (iter000.nextP() &&
            iter001.nextP()) {
          superarg = iter000.value;
          subarg = iter001.value;
          if (!Stella_Object.eqlP(Logic.argumentBoundTo(superarg), Logic.valueOf(subarg))) {
            alwaysP000 = false;
            break loop000;
          }
        }
      }
      if (alwaysP000) {
        { Stella_Object lastsupervalue = Logic.argumentBoundTo(referenceproposition.arguments.last());
          Stella_Object lastsubvalue = Logic.valueOf(nextproposition.arguments.last());

          if ((lastsupervalue != null) &&
              (lastsubvalue != null)) {
            if (Stella_Object.isaP(lastsubvalue, Logic.SGT_LOGIC_SKOLEM)) {
              if (Stella_Object.isaP(lastsupervalue, Logic.SGT_LOGIC_SKOLEM)) {
                return (false);
              }
              else {
                return (Skolem.valueClashesWithSkolemP(((Skolem)(lastsubvalue)), lastsupervalue));
              }
            }
            else {
              if (Stella_Object.isaP(lastsupervalue, Logic.SGT_LOGIC_SKOLEM)) {
                return (Skolem.valueClashesWithSkolemP(((Skolem)(lastsupervalue)), lastsubvalue));
              }
              else {
                return (!Stella_Object.eqlP(lastsupervalue, lastsubvalue));
              }
            }
          }
        }
      }
    }
    return (false);
  }

  public static Iterator allMatchingPropositions(Proposition self) {
    { Stella_Object backlinkedargument = null;
      boolean nomatchingpropositionsP = false;

      { Object [] caller_MV_returnarray = new Object[1];

        backlinkedargument = Proposition.selectArgumentWithBacklinks(self, caller_MV_returnarray);
        nomatchingpropositionsP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[0])).wrapperValue));
      }
      if (nomatchingpropositionsP) {
        return (Logic.EMPTY_PROPOSITIONS_ITERATOR);
      }
      if (backlinkedargument == null) {
        if (((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue()) {
          return (Logic.EMPTY_PROPOSITIONS_ITERATOR);
        }
        if (Logic.$CYC_KLUDGES_ENABLEDp$) {
          { boolean testValue000 = false;

            { boolean foundP000 = false;

              { Stella_Object arg = null;
                Vector vector000 = self.arguments;
                int index000 = 0;
                int length000 = vector000.length();

                loop000 : for (;index000 < length000; index000 = index000 + 1) {
                  arg = (vector000.theArray)[index000];
                  if (Logic.argumentBoundTo(arg) != null) {
                    foundP000 = true;
                    break loop000;
                  }
                }
              }
              testValue000 = foundP000;
            }
            if (testValue000) {
              testValue000 = NamedDescription.dynamicallyEstimateExtensionSize(Logic.getDescription(self.operator)) > 500;
            }
            if (testValue000) {
              return (Logic.EMPTY_PROPOSITIONS_ITERATOR);
            }
          }
        }
        return (Proposition.allMatchingExtensionMembers(self, true));
      }
      { Cons patternargs = Stella.NIL;
        Stella_Object binding = null;

        { Stella_Object arg = null;
          Vector vector001 = self.arguments;
          int index001 = 0;
          int length001 = vector001.length();
          Cons collect000 = null;

          for (;index001 < length001; index001 = index001 + 1) {
            arg = (vector001.theArray)[index001];
            binding = Logic.argumentBoundTo(arg);
            if ((binding != null) &&
                (Stella_Object.isaP(binding, Logic.SGT_LOGIC_PROPOSITION) &&
                 (!Proposition.allArgumentsBoundP(((Proposition)(binding)))))) {
              binding = null;
            }
            if (collect000 == null) {
              {
                collect000 = Cons.cons(Logic.valueOf(binding), Stella.NIL);
                if (patternargs == Stella.NIL) {
                  patternargs = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(patternargs, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(Logic.valueOf(binding), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        if (patternargs.rest == Stella.NIL) {
          return (Logic.allTrueDependentPropositions(backlinkedargument, ((Surrogate)(self.operator)), true));
        }
        else {
          { Cons pattern = Cons.cons(Logic.KWD_RELATION, Cons.cons(((Stella.NIL == null) ? Stella.NIL : Stella.NIL), Cons.cons(self.operator, patternargs)));

            { SpecializingPropositionsIterator self001 = SpecializingPropositionsIterator.newSpecializingPropositionsIterator();

              self001.selectionPattern = pattern;
              self001.propositionCursor = Logic.selectPropositions(pattern).allocateIterator();
              { SpecializingPropositionsIterator value000 = self001;

                return (value000);
              }
            }
          }
        }
      }
    }
  }

  public static boolean prefixArgumentsEqualArgumentsP(Proposition subproposition, Proposition referenceproposition) {
    { boolean testValue000 = false;

      { boolean alwaysP000 = true;

        { Stella_Object superarg = null;
          Vector vector000 = referenceproposition.arguments;
          int index000 = 0;
          int length000 = vector000.length();
          Stella_Object subarg = null;
          Vector vector001 = subproposition.arguments;
          int index001 = 0;
          int length001 = vector001.length();

          loop000 : for (;(index000 < length000) &&
                    (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
            superarg = (vector000.theArray)[index000];
            subarg = (vector001.theArray)[index001];
            if (!Stella_Object.eqlP(Logic.valueOf(superarg), Logic.valueOf(subarg))) {
              alwaysP000 = false;
              break loop000;
            }
          }
        }
        testValue000 = alwaysP000;
      }
      { boolean value000 = testValue000;

        return (value000);
      }
    }
  }

  public static boolean argumentsMatchArgumentsP(Proposition subproposition, Proposition referenceproposition) {
    if (((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) {
      return (Proposition.argumentsUnifyWithArgumentsP(subproposition, referenceproposition));
    }
    else {
      return (Proposition.argumentsEqualArgumentsP(subproposition, referenceproposition));
    }
  }

  public static boolean argumentsEqualArgumentsP(Proposition subproposition, Proposition referenceproposition) {
    { boolean testValue000 = false;

      { boolean alwaysP000 = true;

        { Stella_Object superarg = null;
          Vector vector000 = referenceproposition.arguments;
          int index000 = 0;
          int length000 = vector000.length();
          Stella_Object subarg = null;
          Vector vector001 = subproposition.arguments;
          int index001 = 0;
          int length001 = vector001.length();

          loop000 : for (;(index000 < length000) &&
                    (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
            superarg = (vector000.theArray)[index000];
            subarg = (vector001.theArray)[index001];
            if (!Stella_Object.eqlP(Logic.valueOf(superarg), Logic.valueOf(subarg))) {
              alwaysP000 = false;
              break loop000;
            }
          }
        }
        testValue000 = alwaysP000;
      }
      if (testValue000) {
        testValue000 = referenceproposition.arguments.length() == subproposition.arguments.length();
      }
      { boolean value000 = testValue000;

        return (value000);
      }
    }
  }

  public static boolean argumentsUnifyWithArgumentsP(Proposition subproposition, Proposition referenceproposition) {
    { PatternRecord patternrecord = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord;
      int ubstackoffset = patternrecord.topUnbindingStackOffset;
      boolean successP = false;

      { boolean testValue000 = false;

        { boolean alwaysP000 = true;

          { Stella_Object superarg = null;
            Vector vector000 = referenceproposition.arguments;
            int index000 = 0;
            int length000 = vector000.length();
            Stella_Object subarg = null;
            Vector vector001 = subproposition.arguments;
            int index001 = 0;
            int length001 = vector001.length();

            loop000 : for (;(index000 < length000) &&
                      (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
              superarg = (vector000.theArray)[index000];
              subarg = (vector001.theArray)[index001];
              if (!((!Logic.nullInstanceP(subarg)) &&
                  Logic.bindArgumentToValueP(superarg, Logic.valueOf(subarg), false))) {
                alwaysP000 = false;
                break loop000;
              }
            }
          }
          testValue000 = alwaysP000;
        }
        if (testValue000) {
          testValue000 = referenceproposition.arguments.length() == subproposition.arguments.length();
        }
        successP = testValue000;
      }
      if (!successP) {
        PatternRecord.unbindVariablesBeginningAt(patternrecord, ubstackoffset + 1);
      }
      return (successP);
    }
  }

  public static boolean truePropositionP(Proposition proposition) {
    return ((!proposition.deletedP()) &&
        ((((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue() ? Proposition.falseP(proposition) : (Proposition.trueP(proposition) ||
        Proposition.functionWithDefinedValueP(proposition)))));
  }

  public static TruthValue propositionTruthValue(Proposition proposition) {
    { TruthValue truthvalue = ((TruthValue)(Stella_Object.accessInContext(proposition.truthValue, proposition.homeContext, false)));

      if (truthvalue != null) {
        return (truthvalue);
      }
      else {
        if ((!((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue()) &&
            Proposition.functionWithDefinedValueP(proposition)) {
          return (Logic.TRUE_TRUTH_VALUE);
        }
        else {
          return (null);
        }
      }
    }
  }

  public static void helpCollectSinglyBoundVariables(Proposition proposition, List boundvariables, boolean recursiveP) {
    { Keyword testValue000 = proposition.kind;

      if (testValue000 == Logic.KWD_AND) {
        { Stella_Object arg = null;
          Vector vector000 = proposition.arguments;
          int index000 = 0;
          int length000 = vector000.length();

          for (;index000 < length000; index000 = index000 + 1) {
            arg = (vector000.theArray)[index000];
            Proposition.helpCollectSinglyBoundVariables(((Proposition)(arg)), boundvariables, recursiveP);
          }
        }
      }
      else if ((testValue000 == Logic.KWD_FUNCTION) ||
          (testValue000 == Logic.KWD_PREDICATE)) {
        if (proposition.arguments.length() > 0) {
          { Stella_Object lastarg = (proposition.arguments.theArray)[(proposition.arguments.length() - 1)];

            { boolean testValue001 = false;

              testValue001 = Logic.variableP(lastarg);
              if (testValue001) {
                testValue001 = !boundvariables.memberP(lastarg);
                if (testValue001) {
                  testValue001 = (proposition.kind == Logic.KWD_FUNCTION) ||
                      ((recursiveP &&
                      Logic.singleValuedTermP(Logic.getDescription(((Surrogate)(proposition.operator))))) ||
                       ((!recursiveP) &&
                        Logic.nonRecursiveSingleValuedTermP(Logic.getDescription(((Surrogate)(proposition.operator))))));
                  if (testValue001) {
                    { boolean alwaysP000 = true;

                      { Stella_Object arg = null;
                        Iterator iter000 = proposition.arguments.butLast();

                        loop001 : while (iter000.nextP()) {
                          arg = iter000.value;
                          if (!((!Logic.variableP(arg)) ||
                              boundvariables.memberP(arg))) {
                            alwaysP000 = false;
                            break loop001;
                          }
                        }
                      }
                      testValue001 = alwaysP000;
                    }
                  }
                }
              }
              if (testValue001) {
                boundvariables.push(((PatternVariable)(lastarg)));
              }
            }
          }
        }
      }
      else if (testValue000 == Logic.KWD_EQUIVALENT) {
        { Cons unboundvariables = Stella.NIL;

          { Stella_Object arg = null;
            Vector vector001 = proposition.arguments;
            int index001 = 0;
            int length001 = vector001.length();

            for (;index001 < length001; index001 = index001 + 1) {
              arg = (vector001.theArray)[index001];
              if (Logic.variableP(arg) &&
                  (!boundvariables.memberP(arg))) {
                unboundvariables = Cons.cons(arg, unboundvariables);
              }
            }
          }
          if (unboundvariables.length() == 1) {
            boundvariables.push(((PatternVariable)(unboundvariables.value)));
          }
        }
      }
      else {
      }
    }
  }

  public static boolean helpSingleValuedGoalP(Proposition proposition, Cons iovariables, Cons boundvariables, boolean recursiveP) {
    { List boundvariableslist = boundvariables.listify();
      int oldcount = boundvariableslist.length();
      int newcount = Stella.NULL_INTEGER;

      loop000 : for (;;) {
        Proposition.helpCollectSinglyBoundVariables(proposition, boundvariableslist, recursiveP);
        newcount = boundvariableslist.length();
        if (oldcount == newcount) {
          break loop000;
        }
        oldcount = newcount;
      }
      { boolean alwaysP000 = true;

        { PatternVariable vbl = null;
          Cons iter000 = iovariables;

          loop001 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            vbl = ((PatternVariable)(iter000.value));
            if (!boundvariableslist.memberP(vbl)) {
              alwaysP000 = false;
              break loop001;
            }
          }
        }
        { boolean value000 = alwaysP000;

          return (value000);
        }
      }
    }
  }

  public static boolean singleValuedGoalP(Proposition proposition, Cons iovariables, Cons boundvariables) {
    return (Proposition.helpSingleValuedGoalP(proposition, iovariables, boundvariables, true));
  }

  public static boolean helpClosedPropositionP(Proposition self, Cons activeterms) {
    if (activeterms.membP(self)) {
      return (false);
    }
    else {
      activeterms = Cons.cons(self, activeterms);
    }
    { Keyword testValue000 = self.kind;

      if ((testValue000 == Logic.KWD_AND) ||
          ((testValue000 == Logic.KWD_OR) ||
           ((testValue000 == Logic.KWD_NOT) ||
            ((testValue000 == Logic.KWD_FORALL) ||
             (testValue000 == Logic.KWD_EXISTS))))) {
        { boolean alwaysP000 = true;

          { Stella_Object arg = null;
            Vector vector000 = self.arguments;
            int index000 = 0;
            int length000 = vector000.length();

            loop000 : for (;index000 < length000; index000 = index000 + 1) {
              arg = (vector000.theArray)[index000];
              if (!Proposition.helpClosedPropositionP(((Proposition)(arg)), activeterms)) {
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
      else if ((testValue000 == Logic.KWD_PREDICATE) ||
          ((testValue000 == Logic.KWD_FUNCTION) ||
           (testValue000 == Logic.KWD_ISA))) {
        if (((Surrogate)(self.operator)) == Logic.SGT_PL_KERNEL_KB_MEMBER_OF) {
          { Stella_Object collectionarg = (self.arguments.theArray)[1];
            Stella_Object collectionvalue = Logic.safeArgumentBoundTo(collectionarg);

            if (collectionvalue != null) {
              return (Logic.helpClosedTermP(collectionvalue, activeterms));
            }
            else {
              { boolean foundP000 = false;

                { Proposition prop = null;
                  Iterator iter000 = Logic.unfilteredDependentPropositions(collectionarg, null).allocateIterator();

                  loop001 : while (iter000.nextP()) {
                    prop = ((Proposition)(iter000.value));
                    if (Stella_Object.eqlP(collectionarg, prop.arguments.last()) &&
                        Proposition.collectionofPropositionP(prop)) {
                      foundP000 = true;
                      break loop001;
                    }
                  }
                }
                { boolean value001 = foundP000;

                  return (value001);
                }
              }
            }
          }
        }
        else {
          return (Logic.helpClosedTermP(Logic.getDescription(((Surrogate)(self.operator))), activeterms));
        }
      }
      else if (testValue000 == Logic.KWD_FAIL) {
        return (true);
      }
      else {
        return (false);
      }
    }
  }

  public static boolean closedPropositionP(Proposition self) {
    { MemoizationTable memoTable000 = null;
      Cons memoizedEntry000 = null;
      Stella_Object memoizedValue000 = null;

      if (Stella.$MEMOIZATION_ENABLEDp$) {
        memoTable000 = ((MemoizationTable)(Logic.SGT_LOGIC_F_CLOSED_PROPOSITIONp_MEMO_TABLE_000.surrogateValue));
        if (memoTable000 == null) {
          Surrogate.initializeMemoizationTable(Logic.SGT_LOGIC_F_CLOSED_PROPOSITIONp_MEMO_TABLE_000, "(:MAX-VALUES 500 :TIMESTAMPS (:META-KB-UPDATE))");
          memoTable000 = ((MemoizationTable)(Logic.SGT_LOGIC_F_CLOSED_PROPOSITIONp_MEMO_TABLE_000.surrogateValue));
        }
        memoizedEntry000 = MruMemoizationTable.lookupMruMemoizedValue(((MruMemoizationTable)(memoTable000)), self, ((Context)(Stella.$CONTEXT$.get())), Stella.MEMOIZED_NULL_VALUE, null, -1);
        memoizedValue000 = memoizedEntry000.value;
      }
      if (memoizedValue000 != null) {
        if (memoizedValue000 == Stella.MEMOIZED_NULL_VALUE) {
          memoizedValue000 = null;
        }
      }
      else {
        memoizedValue000 = (Proposition.helpClosedPropositionP(self, Stella.NIL) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
        if (Stella.$MEMOIZATION_ENABLEDp$) {
          memoizedEntry000.value = ((memoizedValue000 == null) ? Stella.MEMOIZED_NULL_VALUE : memoizedValue000);
        }
      }
      { BooleanWrapper value000 = ((BooleanWrapper)(memoizedValue000));

        return (BooleanWrapper.coerceWrappedBooleanToBoolean(value000));
      }
    }
  }

  public static Stella_Object computeSimpleRelationConstraint(Proposition proposition, MethodSlot computation, boolean errorP, Object [] MV_returnarray) {
    { Vector arguments = proposition.arguments;
      NamedDescription description = Logic.getDescription(((Surrogate)(proposition.operator)));
      List argtypes = description.ioVariableTypes;
      int ninputtypes = argtypes.length();
      List compargtypes = null;
      Stella_Object value = null;
      int nullcount = 0;
      int variableindex = -1;
      Cons boundarguments = Stella.NIL;

      if (computation == null) {
        computation = NamedDescription.lookupConstraintFunction(description);
      }
      compargtypes = computation.methodParameterTypeSpecifiers();
      { Stella_Object arg = null;
        Vector vector000 = arguments;
        int index000 = 0;
        int length000 = vector000.length();
        int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        Cons collect000 = null;

        for (;index000 < length000; index000 = index000 + 1, iter000 = iter000 + 1) {
          arg = (vector000.theArray)[index000];
          i = iter000;
          value = Logic.safeArgumentBoundTo(arg);
          if (value == null) {
            value = null;
            nullcount = nullcount + 1;
            variableindex = i;
          }
          else if (Logic.checkStrictTypeP(value, Logic.argumentTargetType(argtypes, ninputtypes, i), true) &&
              Surrogate.subtypeOfP(value.primaryType(), Logic.argumentTargetType(compargtypes, ninputtypes + 1, i + 1))) {
          }
          else if (Logic.skolemP(value) &&
              (!Skolem.boundComputationInputSkolemP(((Skolem)(value))))) {
            value = null;
            nullcount = nullcount + 1;
            variableindex = i;
          }
          else {
            if (errorP) {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    stream000.nativeStream.println("ERROR: compute-relation-constraint: incorrect argument type for `" + value + "' in `" + proposition + "'.");
                    Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                  }
                }
                throw ((PropositionError)(PropositionError.newPropositionError(stream000.theStringReader()).fillInStackTrace()));
              }
            }
            else {
              { Stella_Object _return_temp = null;

                MV_returnarray[0] = IntegerWrapper.wrapInteger(-1);
                return (_return_temp);
              }
            }
          }
          if (collect000 == null) {
            {
              collect000 = Cons.cons(value, Stella.NIL);
              if (boundarguments == Stella.NIL) {
                boundarguments = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(boundarguments, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(value, Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      switch (nullcount) {
        case 0: 
          value = Stella.apply(computation.functionCode, Cons.cons(IntegerWrapper.wrapInteger(variableindex), boundarguments));
        break;
        case 1: 
          if (((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue()) {
            { Stella_Object _return_temp = null;

              MV_returnarray[0] = IntegerWrapper.wrapInteger(-1);
              return (_return_temp);
            }
          }
          value = Stella.apply(computation.functionCode, Cons.cons(IntegerWrapper.wrapInteger(variableindex), boundarguments));
        break;
        default:
          { Stella_Object _return_temp = null;

            MV_returnarray[0] = IntegerWrapper.wrapInteger(-1);
            return (_return_temp);
          }
      }
      { Stella_Object _return_temp = value;

        MV_returnarray[0] = IntegerWrapper.wrapInteger(variableindex);
        return (_return_temp);
      }
    }
  }

  public static Stella_Object computeRelationValue(Proposition proposition, MethodSlot computation, boolean errorP) {
    { Vector arguments = proposition.arguments;
      NamedDescription description = Logic.getDescription(((Surrogate)(proposition.operator)));
      boolean functionP = NamedDescription.functionDescriptionP(description);
      List argtypes = description.ioVariableTypes;
      int ninputtypes = argtypes.length() - ((functionP ? 1 : 0));
      List compargtypes = null;
      Stella_Object value = null;
      Cons boundarguments = Stella.NIL;
      boolean variablearityP = Description.variableArityP(description);

      if (computation == null) {
        computation = NamedDescription.lookupComputationFunction(description);
      }
      compargtypes = computation.methodParameterTypeSpecifiers();
      { Stella_Object arg = null;
        Vector vector000 = arguments;
        int index000 = 0;
        int length000 = vector000.length();
        int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = arguments.length() - ((functionP ? 2 : 1));
        Cons collect000 = null;

        for (;(index000 < length000) &&
                  (iter000 <= upperBound000); index000 = index000 + 1, iter000 = iter000 + 1) {
          arg = (vector000.theArray)[index000];
          i = iter000;
          value = Logic.safeArgumentBoundTo(arg);
          if (value == null) {
            return (null);
          }
          else if (Logic.checkStrictTypeP(value, Logic.argumentTargetType(argtypes, ninputtypes, i), true) &&
              Surrogate.subtypeOfP(value.primaryType(), Logic.argumentTargetType(compargtypes, ninputtypes, i))) {
          }
          else if (Logic.skolemP(value) &&
              (!Skolem.boundComputationInputSkolemP(((Skolem)(value))))) {
            return (null);
          }
          else {
            if (errorP) {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    stream000.nativeStream.println("ERROR: compute-relation-value: incorrect argument type for `" + value + "' in `" + proposition + "'.");
                    Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                  }
                }
                throw ((PropositionError)(PropositionError.newPropositionError(stream000.theStringReader()).fillInStackTrace()));
              }
            }
            else {
              return (null);
            }
          }
          if (collect000 == null) {
            {
              collect000 = Cons.cons(value, Stella.NIL);
              if (boundarguments == Stella.NIL) {
                boundarguments = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(boundarguments, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(value, Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      if (variablearityP) {
        { int nfixed = argtypes.length() - ((functionP ? 2 : 1));

          if (nfixed == 0) {
            boundarguments = Cons.cons(boundarguments, Stella.NIL);
          }
          else if (boundarguments.length() >= nfixed) {
            boundarguments.nthRestSetter(Cons.cons(boundarguments.nthRest(nfixed), Stella.NIL), nfixed);
          }
          else {
            return (null);
          }
        }
      }
      value = Stella.apply(computation.functionCode, boundarguments);
      return (value);
    }
  }

  public static Cons generateImpliesProposition(Proposition self) {
    { Stella_Object tailarg = (self.arguments.theArray)[0];
      Stella_Object headarg = (self.arguments.theArray)[1];

      if (Stella_Object.isaP(headarg, Logic.SGT_LOGIC_DESCRIPTION) &&
          Stella_Object.isaP(tailarg, Logic.SGT_LOGIC_DESCRIPTION)) {
        return (Description.generateDescriptionsAsRule(((Description)(headarg)), ((Description)(tailarg)), self, false));
      }
      else {
        return (Cons.cons(Logic.SYM_PL_KERNEL_KB_SUBSET_OF, Logic.generateArguments(self.arguments).concatenate(Stella.NIL, Stella.NIL)));
      }
    }
  }

  public static Cons generateFunctionProposition(Proposition self) {
    { Cons result = Proposition.generateFunctionAsTerm(self);
      Stella_Object lastarg = self.arguments.last();
      Stella_Object lastargvalue = Logic.innermostOf(lastarg);

      if ((lastargvalue != null) &&
          (!Stella_Object.eqlP(lastargvalue, lastarg))) {
        lastarg = Logic.generateTerm(lastargvalue);
      }
      else {
        lastarg = Logic.generateTerm(lastarg);
      }
      if (((Boolean)(Logic.$PRINTFUNCTIONSASRELATIONSp$.get())).booleanValue()) {
        return (result.concatenate(Cons.cons(lastarg, Stella.NIL), Stella.NIL));
      }
      else {
        return (Cons.list$(Cons.cons(Logic.SYM_STELLA_e, Cons.cons(result, Cons.cons(Cons.cons(lastarg, Stella.NIL), Stella.NIL)))));
      }
    }
  }

  public static Cons generateFunctionAsTerm(Proposition self) {
    { Vector args = self.arguments;
      Cons arguments = Stella.NIL;

      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = args.length() - 2;
        Cons collect000 = null;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Logic.generateTerm((args.theArray)[i]), Stella.NIL);
              if (arguments == Stella.NIL) {
                arguments = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(arguments, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Logic.generateTerm((args.theArray)[i]), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (Cons.cons(Proposition.generateOperator(self), arguments.concatenate(Stella.NIL, Stella.NIL)));
    }
  }

  public static Stella_Object generateProposition(Proposition self) {
    { Keyword testValue000 = self.kind;

      if ((testValue000 == Logic.KWD_PREDICATE) ||
          ((testValue000 == Logic.KWD_ISA) ||
           ((testValue000 == Logic.KWD_EQUIVALENT) ||
            ((testValue000 == Logic.KWD_AND) ||
             ((testValue000 == Logic.KWD_OR) ||
              (testValue000 == Logic.KWD_NOT)))))) {
        { Symbol operator = Proposition.generateOperator(self);

          return (Cons.cons(operator, Logic.generateArguments(self.arguments).concatenate(Stella.NIL, Stella.NIL)));
        }
      }
      else if (testValue000 == Logic.KWD_FUNCTION) {
        return (Proposition.generateFunctionProposition(self));
      }
      else if (testValue000 == Logic.KWD_EXISTS) {
        Logic.pushQuantifiedObject(self);
        { Cons result = Cons.list$(Cons.cons(Logic.SYM_STELLA_EXISTS, Cons.cons(Logic.generateQuantifiedVariables(((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null))), false), Cons.cons(Cons.cons(Proposition.generateProposition(((Proposition)((self.arguments.theArray)[0]))), Stella.NIL), Stella.NIL))));

          Logic.popQuantifiedObject();
          return (result);
        }
      }
      else if (testValue000 == Logic.KWD_FORALL) {
        Logic.pushQuantifiedObject(self);
        { boolean forwardP = !((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_BACKWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue;
          Symbol arrow = Surrogate.symbolize(Proposition.chooseImplicationOperator(self, forwardP));
          Cons result = Cons.list$(Cons.cons(Logic.SYM_STELLA_FORALL, Cons.cons(Logic.generateQuantifiedVariables(((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null))), false), Cons.cons(Cons.cons(Cons.cons(arrow, Cons.cons(Proposition.generateProposition(((Proposition)((self.arguments.theArray)[((forwardP ? 0 : 1))]))), Cons.cons(Proposition.generateProposition(((Proposition)((self.arguments.theArray)[((forwardP ? 1 : 0))]))), Stella.NIL))), Stella.NIL), Stella.NIL))));

          Logic.popQuantifiedObject();
          return (result);
        }
      }
      else if (testValue000 == Logic.KWD_IMPLIES) {
        return (Proposition.generateImpliesProposition(self));
      }
      else if (testValue000 == Logic.KWD_FAIL) {
        return (Cons.cons(Logic.SYM_LOGIC_FAIL, Logic.generateArguments(self.arguments).concatenate(Stella.NIL, Stella.NIL)));
      }
      else if (testValue000 == Logic.KWD_CONSTANT) {
        return (Proposition.generateOperator(self));
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static Symbol generateOperator(Proposition self) {
    { GeneralizedSymbol operator = self.operator;

      if (operator == null) {
        return (Logic.SYM_STELLA_NULL);
      }
      { Surrogate testValue000 = Stella_Object.safePrimaryType(operator);

        if (Surrogate.subtypeOfSurrogateP(testValue000)) {
          { Surrogate operator000 = ((Surrogate)(operator));

            if (operator000 == Logic.SGT_PL_KERNEL_KB_EQUIVALENT) {
              return (Logic.SYM_STELLA_e);
            }
            else {
              return (Symbol.internSymbolInModule(operator000.symbolName, ((Module)(operator000.homeContext)), false));
            }
          }
        }
        else if (Surrogate.subtypeOfSymbolP(testValue000)) {
          { Symbol operator000 = ((Symbol)(operator));

            return (operator000);
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
  }

  public static void printProposition(Proposition self, OutputStream stream, boolean toplevelP) {
    { String prefix = null;

      if (self.deletedP()) {
        stream.nativeStream.print("|dElEtEd-proposition|");
        return;
      }
      if (toplevelP &&
          (!((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue())) {
        if (Proposition.defaultTrueP(self) ||
            Proposition.defaultFalseP(self)) {
          prefix = (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.FALSE_WRAPPER))).wrapperValue ? "|pd|" : "|p|");
        }
        else if (((!self.deletedP()) &&
            ((((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue() ? Proposition.falseP(self) : (Proposition.trueP(self) ||
            Proposition.functionWithDefinedValueP(self))))) ||
            Proposition.falseP(self)) {
          prefix = (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.FALSE_WRAPPER))).wrapperValue ? "|Pd|" : "|P|");
        }
        else if (Proposition.inconsistentP(self)) {
          prefix = (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.FALSE_WRAPPER))).wrapperValue ? "|Pd#|" : "|P#|");
        }
        else {
          prefix = (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.FALSE_WRAPPER))).wrapperValue ? "|Pd?|" : "|P?|");
        }
      }
      if (BooleanWrapper.coerceWrappedBooleanToBoolean(self.unfastenedP())) {
        prefix = (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.FALSE_WRAPPER))).wrapperValue ? "|uPd|" : "|uP|");
      }
      if ((((Surrogate)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_STELLA_SURROGATE_VALUE_INVERSE, null))) != null) &&
          (!(((Surrogate)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_STELLA_SURROGATE_VALUE_INVERSE, null))).surrogateValue == self))) {
        prefix = "|BAD surrogate|";
      }
      if (prefix != null) {
        stream.nativeStream.print(prefix);
      }
    }
    Logic.printLogicalForm(self, stream);
  }

  public static void prettyPrintAssertion(Proposition proposition, OutputStream stream) {
    { Symbol operator = Logic.SYM_STELLA_ASSERT;
      Surrogate name = ((Surrogate)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_STELLA_SURROGATE_VALUE_INVERSE, null)));
      TruthValue truthvalue = ((TruthValue)(Stella_Object.accessInContext(proposition.truthValue, proposition.homeContext, false)));

      if (name != null) {
        Logic.prettyPrintNamedRule(name, stream);
        return;
      }
      if ((truthvalue == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
          (truthvalue == Logic.DEFAULT_FALSE_TRUTH_VALUE)) {
        operator = Logic.SYM_LOGIC_PRESUME;
      }
      else if ((truthvalue == Logic.UNKNOWN_TRUTH_VALUE) ||
          (truthvalue == null)) {
        operator = Logic.SYM_STELLA_RETRACT;
      }
      { Object old$Printmode$000 = Logic.$PRINTMODE$.get();
        Object old$Printlogicalformstream$000 = Logic.$PRINTLOGICALFORMSTREAM$.get();
        Object old$Indentcounter$000 = Logic.$INDENTCOUNTER$.get();

        try {
          Native.setSpecial(Logic.$PRINTMODE$, Logic.KWD_ORIGINAL);
          Native.setSpecial(Logic.$PRINTLOGICALFORMSTREAM$, stream);
          Native.setIntSpecial(Logic.$INDENTCOUNTER$, 8);
          stream.nativeStream.print("(" + operator + " ");
          Logic.prettyPrintLogicalForm(proposition, stream);
          stream.nativeStream.println(")");

        } finally {
          Logic.$INDENTCOUNTER$.set(old$Indentcounter$000);
          Logic.$PRINTLOGICALFORMSTREAM$.set(old$Printlogicalformstream$000);
          Logic.$PRINTMODE$.set(old$Printmode$000);
        }
      }
    }
  }

  public static boolean excludedPropositionP(Proposition proposition, Module module) {
    if (Proposition.unknownP(proposition) &&
        (proposition.homeModule() == module)) {
      return (true);
    }
    if ((((BooleanWrapper)(((HashTable)(Logic.$EXCLUDEDPROPOSITIONS$.get())).lookup(proposition))) != null) ||
        (((Proposition)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_MASTER_PROPOSITION, null))) != null)) {
      return (true);
    }
    { Keyword testValue000 = proposition.kind;

      if (testValue000 == Logic.KWD_ISA) {
        if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_ASSERTED_BY_TYPE_CHECKERp, Stella.FALSE_WRAPPER))).wrapperValue ||
            Logic.hiddenRelationP(((Surrogate)(proposition.operator)))) {
          return (true);
        }
      }
      else if (testValue000 == Logic.KWD_FUNCTION) {
        { Stella_Object lastarg = proposition.arguments.last();

          if ((Logic.skolemP(lastarg) &&
              (Stella_Object.eqlP(Logic.valueOf(lastarg), lastarg) &&
               (!Proposition.topLevelExistsPropositionP(proposition)))) ||
              Logic.hiddenRelationP(((Surrogate)(proposition.operator)))) {
            return (true);
          }
        }
      }
      else if (testValue000 == Logic.KWD_PREDICATE) {
        if (Logic.hiddenRelationP(((Surrogate)(proposition.operator)))) {
          return (true);
        }
      }
      else {
      }
    }
    return (false);
  }

  public static Surrogate chooseImplicationOperator(Proposition rule, boolean forwardP) {
    { Surrogate operatorprefix = (forwardP ? Logic.SGT_PL_KERNEL_KB_eg : Logic.SGT_PL_KERNEL_KB_le);

      if (((Keyword)(Logic.$PRINTMODE$.get())) == Logic.KWD_REALISTIC) {
      }
      else if (forwardP &&
          ((BooleanWrapper)(KeyValueList.dynamicSlotValue(rule.dynamicSlots, Logic.SYM_LOGIC_FORWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue) {
        operatorprefix = Logic.SGT_PL_KERNEL_KB_egg;
      }
      else if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(rule.dynamicSlots, Logic.SYM_LOGIC_BACKWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue &&
          (!forwardP)) {
        operatorprefix = Logic.SGT_PL_KERNEL_KB_lle;
      }
      if (Proposition.defaultTrueP(rule) &&
          (!(((Keyword)(Logic.$PRINTMODE$.get())) == Logic.KWD_REALISTIC))) {
        if (operatorprefix == Logic.SGT_PL_KERNEL_KB_le) {
          operatorprefix = Logic.SGT_PL_KERNEL_KB_lt;
        }
        else if (operatorprefix == Logic.SGT_PL_KERNEL_KB_eg) {
          operatorprefix = Logic.SGT_PL_KERNEL_KB_tg;
        }
        else if (operatorprefix == Logic.SGT_PL_KERNEL_KB_lle) {
          operatorprefix = Logic.SGT_PL_KERNEL_KB_llt;
        }
        else if (operatorprefix == Logic.SGT_PL_KERNEL_KB_egg) {
          operatorprefix = Logic.SGT_PL_KERNEL_KB_tgg;
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + operatorprefix + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      return (operatorprefix);
    }
  }

  public static void printKifTopLevelExistsProposition(Proposition self) {
    { OutputStream stream = ((OutputStream)(Logic.$PRINTLOGICALFORMSTREAM$.get()));
      Vector variables = Proposition.collectSkolemizedExistsVariables(self);

      Logic.pushQuantifiedObject(variables);
      stream.nativeStream.print("(" + Logic.stringifiedSurrogate(Logic.SGT_PL_KERNEL_KB_EXISTS) + " ");
      Logic.printKifQuantifiedVariables(variables, false);
      stream.nativeStream.println();
      Logic.increaseIndent(Stella.NULL_INTEGER);
      Logic.printIndent(stream, Stella.NULL_INTEGER);
      Proposition.printKifProposition(self);
      Logic.decreaseIndent(Stella.NULL_INTEGER);
      stream.nativeStream.print(")");
      Logic.popQuantifiedObject();
    }
  }

  public static void printKifQuantification(Proposition self) {
    Logic.pushQuantifiedObject(self);
    { OutputStream stream = ((OutputStream)(Logic.$PRINTLOGICALFORMSTREAM$.get()));
      Proposition tail = ((Proposition)((self.arguments.theArray)[0]));
      Proposition head = ((self.arguments.length() == 2) ? ((Proposition)((self.arguments.theArray)[1])) : null);
      boolean implicationP = head != null;
      Surrogate implicationoperator = (implicationP ? Proposition.chooseImplicationOperator(self, ((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_FORWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue) : ((Surrogate)(null)));

      if ((implicationoperator != null) &&
          (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_FORWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue &&
           (!(implicationoperator == Logic.SGT_PL_KERNEL_KB_le)))) {
        { Proposition temp = tail;

          tail = head;
          head = temp;
        }
      }
      { Keyword testValue000 = self.kind;

        if (testValue000 == Logic.KWD_FORALL) {
          stream.nativeStream.print("(" + Logic.stringifiedSurrogate(Logic.SGT_PL_KERNEL_KB_FORALL) + " ");
        }
        else if (testValue000 == Logic.KWD_EXISTS) {
          stream.nativeStream.print("(" + Logic.stringifiedSurrogate(Logic.SGT_PL_KERNEL_KB_EXISTS) + " ");
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      Logic.printKifQuantifiedVariables(((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null))), false);
      stream.nativeStream.println();
      Logic.increaseIndent(Stella.NULL_INTEGER);
      Logic.printIndent(stream, Stella.NULL_INTEGER);
      if (implicationP) {
        stream.nativeStream.print("(" + Logic.stringifiedSurrogate(implicationoperator) + " ");
        Logic.increaseIndent((implicationoperator.symbolName).length() + 2);
        Proposition.printKifProposition(head);
        stream.nativeStream.println();
        Logic.printIndent(stream, Stella.NULL_INTEGER);
      }
      Proposition.printKifProposition(tail);
      if (implicationP) {
        stream.nativeStream.print(")");
        Logic.decreaseIndent((implicationoperator.symbolName).length() + 2);
      }
      Logic.decreaseIndent(Stella.NULL_INTEGER);
      stream.nativeStream.print(")");
      Logic.popQuantifiedObject();
    }
  }

  public static void printKifImpliesProposition(Proposition self) {
    { Stella_Object tailarg = (self.arguments.theArray)[0];
      Stella_Object headarg = (self.arguments.theArray)[1];

      if (Stella_Object.isaP(headarg, Logic.SGT_LOGIC_DESCRIPTION) &&
          Stella_Object.isaP(tailarg, Logic.SGT_LOGIC_DESCRIPTION)) {
        Description.printDescriptionsAsKifRule(((Description)(headarg)), ((Description)(tailarg)), self, false);
      }
      else {
        Logic.printKifOperatorWithArguments(Logic.stringifiedSurrogate(Logic.SGT_PL_KERNEL_KB_SUBSET_OF), self.arguments, true, false);
      }
    }
  }

  public static void printKifFunctionExpression(Proposition self) {
    { String downcasedname = Proposition.stringifiedKifOperator(self);

      Logic.printKifOperatorWithArguments(downcasedname, self.arguments, false, true);
    }
  }

  public static void printKifFunctionProposition(Proposition self) {
    { OutputStream stream = ((OutputStream)(Logic.$PRINTLOGICALFORMSTREAM$.get()));
      String downcasedname = Proposition.stringifiedKifOperator(self);
      Stella_Object lastargument = (self.arguments.theArray)[(self.arguments.length() - 1)];
      boolean printasrelationP = ((Boolean)(Logic.$PRINTFUNCTIONSASRELATIONSp$.get())).booleanValue();

      if (!(printasrelationP)) {
        stream.nativeStream.print("(= ");
      }
      stream.nativeStream.print("(" + downcasedname + " ");
      Logic.increaseIndent(downcasedname.length() + 2);
      Logic.printKifArguments(self.arguments, false, true);
      Logic.decreaseIndent(downcasedname.length() + 2);
      if (!(printasrelationP)) {
        stream.nativeStream.print(")");
      }
      stream.nativeStream.print(" ");
      if (lastargument != null) {
        { Surrogate testValue000 = Stella_Object.safePrimaryType(lastargument);

          if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
            { PatternVariable lastargument000 = ((PatternVariable)(lastargument));

              PatternVariable.printKifVariable(lastargument000);
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_SKOLEM)) {
            { Skolem lastargument000 = ((Skolem)(lastargument));

              Skolem.printKifSkolem(lastargument000, true);
            }
          }
          else {
            Logic.printAsKifInternal(lastargument);
          }
        }
      }
      stream.nativeStream.print(")");
    }
  }

  public static void helpPrintKifProposition(Proposition self) {
    { OutputStream stream = ((OutputStream)(Logic.$PRINTLOGICALFORMSTREAM$.get()));
      String operator = null;
      boolean separatelinesP = false;

      { Keyword testValue000 = self.kind;

        if ((testValue000 == Logic.KWD_AND) ||
            (testValue000 == Logic.KWD_OR)) {
          if (self.kind == Logic.KWD_AND) {
            operator = Logic.stringifiedSurrogate(Logic.SGT_PL_KERNEL_KB_AND);
          }
          else {
            operator = Logic.stringifiedSurrogate(Logic.SGT_PL_KERNEL_KB_OR);
          }
          separatelinesP = true;
          if (Logic.visibleArgumentsCount(self.arguments) == 1) {
            if ((((Keyword)(Logic.$PRINTMODE$.get())) == Logic.KWD_REALISTIC) ||
                (((Keyword)(Logic.$PRINTMODE$.get())) == Logic.KWD_ORIGINAL)) {
              Logic.printKifArguments(self.arguments, false, false);
              return;
            }
            else {
            }
          }
        }
        else if (testValue000 == Logic.KWD_NOT) {
          operator = Logic.stringifiedSurrogate(Logic.SGT_PL_KERNEL_KB_NOT);
        }
        else if (testValue000 == Logic.KWD_EQUIVALENT) {
          operator = "=";
        }
        else if ((testValue000 == Logic.KWD_ISA) ||
            (testValue000 == Logic.KWD_PREDICATE)) {
          operator = Proposition.stringifiedKifOperator(self);
          if (self.operator == Logic.SGT_PL_KERNEL_KB_FORK) {
            separatelinesP = true;
          }
        }
        else if (testValue000 == Logic.KWD_FUNCTION) {
          Proposition.printKifFunctionProposition(self);
          return;
        }
        else if (testValue000 == Logic.KWD_IMPLIES) {
          Proposition.printKifImpliesProposition(self);
          return;
        }
        else if ((testValue000 == Logic.KWD_FORALL) ||
            (testValue000 == Logic.KWD_EXISTS)) {
          Proposition.printKifQuantification(self);
          return;
        }
        else if (testValue000 == Logic.KWD_CONSTANT) {
          stream.nativeStream.print(((Surrogate)(self.operator)).symbolName);
          return;
        }
        else if (testValue000 == Logic.KWD_CONTAINED_BY) {
          operator = ":CONTAINED-BY";
        }
        else if (testValue000 == Logic.KWD_DELETED) {
          operator = ":DELETED";
        }
        else {
          operator = self.kind.symbolName;
        }
      }
      Logic.printKifOperatorWithArguments(operator, self.arguments, separatelinesP, false);
    }
  }

  public static void printKifProposition(Proposition self) {
    if (self == null) {
      return;
    }
    { boolean toplevelP = ((Boolean)(Logic.$TOPLEVELPRINTKIFPROPOSITIONp$.get())).booleanValue();
      OutputStream stream = ((OutputStream)(Logic.$PRINTLOGICALFORMSTREAM$.get()));
      boolean printexplicitnegationP = toplevelP &&
          ((Proposition.falseP(self) ||
          Proposition.defaultFalseP(self)) &&
           (!(self.operator == Logic.SGT_STELLA_FALSE)));

      { Object old$ToplevelprintkifpropositionP$000 = Logic.$TOPLEVELPRINTKIFPROPOSITIONp$.get();

        try {
          Native.setBooleanSpecial(Logic.$TOPLEVELPRINTKIFPROPOSITIONp$, false);
          if (printexplicitnegationP) {
            stream.nativeStream.print("(" + Logic.stringifiedSurrogate(Logic.SGT_PL_KERNEL_KB_NOT) + " ");
            Logic.increaseIndent(5);
          }
          if (((((Keyword)(Logic.$PRINTMODE$.get())) == Logic.KWD_REALISTIC) ||
              (((Keyword)(Logic.$PRINTMODE$.get())) == Logic.KWD_ORIGINAL)) &&
              (toplevelP &&
               Proposition.topLevelExistsPropositionP(self))) {
            Proposition.printKifTopLevelExistsProposition(self);
          }
          else {
            Proposition.helpPrintKifProposition(self);
          }
          if (printexplicitnegationP) {
            stream.nativeStream.print(")");
            Logic.decreaseIndent(5);
          }

        } finally {
          Logic.$TOPLEVELPRINTKIFPROPOSITIONp$.set(old$ToplevelprintkifpropositionP$000);
        }
      }
    }
  }

  public static String stringifiedKifOperator(Proposition self) {
    { GeneralizedSymbol operator = self.operator;

      if (operator == null) {
        return ("NULL");
      }
      { Surrogate testValue000 = Stella_Object.safePrimaryType(operator);

        if (Surrogate.subtypeOfSurrogateP(testValue000)) {
          { Surrogate operator000 = ((Surrogate)(operator));

            return (Logic.stringifiedSurrogate(operator000));
          }
        }
        else if (Surrogate.subtypeOfSymbolP(testValue000)) {
          { Symbol operator000 = ((Symbol)(operator));

            return (Logic.maybeDowncase(operator000.symbolName));
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
  }

  public static boolean auxiliaryEquivalencePropositionP(Proposition proposition) {
    { boolean testValue000 = false;

      testValue000 = proposition.kind == Logic.KWD_EQUIVALENT;
      if (testValue000) {
        { boolean foundP000 = false;

          { Stella_Object arg = null;
            Vector vector000 = proposition.arguments;
            int index000 = 0;
            int length000 = vector000.length();

            loop000 : for (;index000 < length000; index000 = index000 + 1) {
              arg = (vector000.theArray)[index000];
              if (Logic.variableP(arg) &&
                  (((Stella_Object)(Stella_Object.accessInContext(((PatternVariable)(arg)).variableValue, ((PatternVariable)(arg)).homeContext, false))) != null)) {
                foundP000 = true;
                break loop000;
              }
            }
          }
          testValue000 = foundP000;
        }
      }
      { boolean value000 = testValue000;

        return (value000);
      }
    }
  }

  /** Print an explanation for <code>prop</code> if there is one.  This will only happen
   * for forward-chained propositions.
   * @param prop
   * @param style
   * @param maxdepth
   * @param stream
   */
  public static void explainProposition(Proposition prop, Keyword style, int maxdepth, OutputStream stream) {
    try {
      { List justifications = prop.forwardJustifications();

        if (justifications != null) {
          { Object old$ExplanationStyle$000 = Logic.$EXPLANATION_STYLE$.get();
            Object old$MostRecentExplanationMapping$000 = Logic.$MOST_RECENT_EXPLANATION_MAPPING$.get();

            try {
              Native.setSpecial(Logic.$EXPLANATION_STYLE$, ((style != null) ? style : Logic.KWD_BRIEF));
              Native.setSpecial(Logic.$MOST_RECENT_EXPLANATION_MAPPING$, null);
              { Justification justification = null;
                Cons iter000 = justifications.theConsList;

                for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  justification = ((Justification)(iter000.value));
                  Native.setSpecial(Logic.$MOST_RECENT_EXPLANATION_MAPPING$, null);
                  Justification.printExplanation(justification, stream, ((KeyValueList)(Logic.$MOST_RECENT_EXPLANATION_MAPPING$.get())), maxdepth, ((Keyword)(Logic.$EXPLANATION_AUDIENCE$.get())));
                }
              }

            } finally {
              Logic.$MOST_RECENT_EXPLANATION_MAPPING$.set(old$MostRecentExplanationMapping$000);
              Logic.$EXPLANATION_STYLE$.set(old$ExplanationStyle$000);
            }
          }
        }
      }
    } catch (ExplainException ee) {
      Stella.STANDARD_OUTPUT.nativeStream.print(Stella.exceptionMessage(ee));
    }
  }

  public static ClashJustification createClashJustification(Proposition prop, Cons antecedents, Keyword direction) {
    { ClashJustification self000 = ClashJustification.newClashJustification();

      self000.inferenceRule = Logic.KWD_CLASH;
      self000.direction = direction;
      self000.proposition = prop;
      self000.truthValue = Logic.INCONSISTENT_TRUTH_VALUE;
      self000.antecedents = antecedents;
      { ClashJustification value000 = self000;

        return (value000);
      }
    }
  }

  public static Justification createSubsetJustification(Proposition mainProposition, Proposition matchingProposition) {
    { Surrogate mainOperator = ((Surrogate)(mainProposition.operator));
      Surrogate matchingOperator = ((Surrogate)(matchingProposition.operator));

      if (!((mainOperator == null) ||
          ((matchingOperator == null) ||
           (mainOperator == matchingOperator)))) {
        if (Logic.relationrefSpecializesRelationrefP(matchingOperator, mainOperator)) {
          { Proposition subsetProposition = null;
            Cons subsetJustifications = Stella.NIL;

            { Object old$Evaluationmode$000 = Logic.$EVALUATIONMODE$.get();

              try {
                Native.setSpecial(Logic.$EVALUATIONMODE$, Logic.KWD_DESCRIPTION);
                subsetProposition = ((Proposition)(Logic.conceiveFormula(Cons.consList(Cons.cons(Logic.SYM_PL_KERNEL_KB_SUBSET_OF, Cons.cons(matchingOperator, Cons.cons(mainOperator, Stella.NIL)))))));

              } finally {
                Logic.$EVALUATIONMODE$.set(old$Evaluationmode$000);
              }
            }
            { PrimitiveStrategy self000 = PrimitiveStrategy.newPrimitiveStrategy();

              self000.proposition = subsetProposition;
              self000.truthValue = Logic.TRUE_TRUTH_VALUE;
              self000.strategy = Logic.KWD_SPECIALIST;
              subsetJustifications = Cons.cons(self000, subsetJustifications);
            }
            { PrimitiveStrategy self001 = PrimitiveStrategy.newPrimitiveStrategy();

              self001.proposition = matchingProposition;
              self001.strategy = Logic.KWD_LOOKUP_ASSERTIONS;
              subsetJustifications = Cons.cons(self001, subsetJustifications);
            }
            { Justification self002 = Justification.newJustification();

              self002.inferenceRule = Logic.KWD_SUBSUMPTION_REASONING;
              self002.proposition = mainProposition;
              self002.antecedents = subsetJustifications;
              { Justification value000 = self002;

                return (value000);
              }
            }
          }
        }
      }
      return (null);
    }
  }

  public static Justification getForwardAntecedentJustification(Proposition antecedent) {
    if ((antecedent.forwardJustifications() != null) &&
        (!antecedent.forwardJustifications().emptyP())) {
      return (((Justification)(antecedent.forwardJustifications().first())));
    }
    else {
      { PrimitiveStrategy self000 = PrimitiveStrategy.newPrimitiveStrategy();

        self000.proposition = antecedent;
        self000.strategy = Logic.KWD_LOOKUP_ASSERTIONS;
        { PrimitiveStrategy value000 = self000;

          return (value000);
        }
      }
    }
  }

  public static Vector getRuleIoVariables(Proposition rule) {
    { Vector vars = ((Vector)(KeyValueList.dynamicSlotValue(rule.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
      Proposition master = null;

      if (vars != null) {
        return (vars);
      }
      master = ((Proposition)(KeyValueList.dynamicSlotValue(rule.dynamicSlots, Logic.SYM_LOGIC_MASTER_PROPOSITION, null)));
      if (master != null) {
        vars = ((Vector)(KeyValueList.dynamicSlotValue(master.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
        if (vars != null) {
          return (vars);
        }
      }
      if (rule.kind == Logic.KWD_IMPLIES) {
        { Vector arguments = rule.arguments;
          Description ant = ((Description)((arguments.theArray)[0]));
          Description cq = ((Description)((arguments.theArray)[1]));

          if (Description.namedDescriptionP(ant)) {
            return (cq.ioVariables);
          }
          else {
            return (ant.ioVariables);
          }
        }
      }
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("get-rule-io-variables: don't know how to access IO-vars of rule: `" + rule + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static void addForwardJustifications(Proposition proposition, Justification justification) {
    { List justifications = proposition.forwardJustifications();

      { boolean foundP000 = false;

        { Justification just = null;
          Cons iter000 = justifications.theConsList;

          loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            just = ((Justification)(iter000.value));
            if (Justification.justificationEqlP(just, justification)) {
              foundP000 = true;
              break loop000;
            }
          }
        }
        if (foundP000) {
          return;
        }
      }
      if (justifications == Stella.NIL_LIST) {
        justifications = List.list(Stella.NIL);
        KeyValueList.setDynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_FORWARD_JUSTIFICATIONS, justifications, null);
      }
      justifications.push(justification);
    }
  }

  /** Return <code>proposition</code>s forward justifications.
   * @param proposition
   * @return List
   */
  public static List getForwardJustifications(Proposition proposition) {
    return (proposition.forwardJustifications());
  }

  /** Return TRUE if <code>proposition</code> has any forward justifications.
   * @param proposition
   * @return boolean
   */
  public static boolean hasForwardJustificationsP(Proposition proposition) {
    return (proposition.forwardJustifications().nonEmptyP());
  }

  public List forwardJustifications() {
    { Proposition self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_FORWARD_JUSTIFICATIONS, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public static List getForwardGoals(Proposition proposition) {
    { List goals = proposition.forwardChainingGoals().removeDeletedMembers();

      if (goals.emptyP() &&
          (((Proposition)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_MASTER_PROPOSITION, null))) != null)) {
        goals = ((Proposition)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_MASTER_PROPOSITION, null))).forwardChainingGoals().removeDeletedMembers();
      }
      return (goals);
    }
  }

  public static boolean elaborationRuleP(Proposition consequentproposition, Proposition forwardrule, Vector arguments) {
    { boolean testValue000 = false;

      testValue000 = Proposition.predicationP(consequentproposition);
      if (testValue000) {
        testValue000 = Proposition.assertedAsTrueP(forwardrule);
        if (testValue000) {
          { boolean alwaysP000 = true;

            { Stella_Object arg = null;
              Vector vector000 = consequentproposition.arguments;
              int index000 = 0;
              int length000 = vector000.length();

              loop000 : for (;index000 < length000; index000 = index000 + 1) {
                arg = (vector000.theArray)[index000];
                if (!arguments.memberP(arg)) {
                  alwaysP000 = false;
                  break loop000;
                }
              }
            }
            testValue000 = alwaysP000;
          }
        }
      }
      { boolean value000 = testValue000;

        return (value000);
      }
    }
  }

  public static boolean assertedAsTrueP(Proposition proposition) {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        return ((!proposition.deletedP()) &&
            ((((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue() ? Proposition.falseP(proposition) : (Proposition.trueP(proposition) ||
            Proposition.functionWithDefinedValueP(proposition)))));

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

  public static boolean predicationP(Proposition proposition) {
    return (Stella.getQuotedTree("((:PREDICATE :FUNCTION :ISA :EQUIVALENT) \"/LOGIC\")", "/LOGIC").memberP(proposition.kind));
  }

  public static void recordForwardGoal(Proposition forwardrule, Vector arguments, Proposition consequentproposition) {
    { ForwardGoalRecord fwdgoalrec = null;
      Cons iter000 = consequentproposition.forwardChainingGoals().theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        fwdgoalrec = ((ForwardGoalRecord)(iter000.value));
        if (!fwdgoalrec.deletedP()) {
          { Proposition fwdgoal = fwdgoalrec.forwardGoal;

            { boolean testValue000 = false;

              testValue000 = fwdgoalrec.forwardRule == forwardrule;
              if (testValue000) {
                { boolean alwaysP000 = true;

                  { Stella_Object arg = null;
                    Vector vector000 = arguments;
                    int index000 = 0;
                    int length000 = vector000.length();
                    int i = Stella.NULL_INTEGER;
                    int iter001 = 1;

                    loop001 : for (;index000 < length000; index000 = index000 + 1, iter001 = iter001 + 1) {
                      arg = (vector000.theArray)[index000];
                      i = iter001;
                      if (!Stella_Object.eqlP((fwdgoal.arguments.theArray)[i], arg)) {
                        alwaysP000 = false;
                        break loop001;
                      }
                    }
                  }
                  testValue000 = alwaysP000;
                }
              }
              if (testValue000) {
                return;
              }
            }
          }
        }
      }
    }
    if (Proposition.elaborationRuleP(consequentproposition, forwardrule, arguments)) {
      return;
    }
    { Proposition forwardgoal = Logic.createProposition(Logic.SYM_STELLA_PREDICATE, arguments.length() + 1);

      { ForwardGoalRecord self000 = ForwardGoalRecord.newForwardGoalRecord();

        self000.forwardGoal = forwardgoal;
        self000.forwardRule = forwardrule;
        { ForwardGoalRecord fwdgoalrec = self000;

          forwardgoal.operator = Logic.SGT_PL_KERNEL_KB_HOLDS;
          (forwardgoal.arguments.theArray)[0] = ((forwardrule.arguments.theArray)[0]);
          { Stella_Object arg = null;
            Vector vector001 = arguments;
            int index001 = 0;
            int length001 = vector001.length();
            int i = Stella.NULL_INTEGER;
            int iter002 = 1;

            for (;index001 < length001; index001 = index001 + 1, iter002 = iter002 + 1) {
              arg = (vector001.theArray)[index001];
              i = iter002;
              (forwardgoal.arguments.theArray)[i] = arg;
            }
          }
          if (consequentproposition.forwardChainingGoals().emptyP()) {
            KeyValueList.setDynamicSlotValue(consequentproposition.dynamicSlots, Logic.SYM_LOGIC_FORWARD_CHAINING_GOALS, List.list(Cons.cons(fwdgoalrec, Stella.NIL)), null);
          }
          else {
            consequentproposition.forwardChainingGoals().insertNew(fwdgoalrec);
          }
        }
      }
    }
  }

  public List forwardChainingGoals() {
    { Proposition self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_FORWARD_CHAINING_GOALS, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public static boolean justificationPropositionsEqlP(Proposition proposition1, Justification just1, Proposition proposition2, Justification just2) {
    if ((proposition1.operator == proposition2.operator) &&
        (proposition1.arguments.length() == proposition2.arguments.length())) {
      { Stella_Object arg1 = null;
        Vector vector000 = proposition1.arguments;
        int index000 = 0;
        int length000 = vector000.length();
        Stella_Object arg2 = null;
        Vector vector001 = proposition2.arguments;
        int index001 = 0;
        int length001 = vector001.length();

        for (;(index000 < length000) &&
                  (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
          arg1 = (vector000.theArray)[index000];
          arg2 = (vector001.theArray)[index001];
          if ((!Stella_Object.eqlP(arg1, arg2)) ||
              Logic.variableP(arg1)) {
            { Surrogate testValue000 = Stella_Object.safePrimaryType(arg1);

              if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PROPOSITION)) {
                { Proposition arg1000 = ((Proposition)(arg1));

                  if (!(Stella_Object.isaP(arg2, Logic.SGT_LOGIC_PROPOSITION) &&
                      Proposition.justificationPropositionsEqlP(arg1000, just1, ((Proposition)(arg2)), just2))) {
                    return (false);
                  }
                }
              }
              else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
                { PatternVariable arg1000 = ((PatternVariable)(arg1));

                  if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(arg2), Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
                    { PatternVariable arg2000 = ((PatternVariable)(arg2));

                      { Stella_Object value1 = Logic.justificationArgumentBoundTo(arg1000, just1);
                        Stella_Object value2 = Logic.justificationArgumentBoundTo(arg2000, just2);

                        if ((value1 == null) ||
                            ((value2 == null) ||
                             (!Stella_Object.eqlP(value1, value2)))) {
                          return (false);
                        }
                      }
                    }
                  }
                  else {
                    if (!Stella_Object.eqlP(Logic.justificationArgumentBoundTo(arg1000, just1), arg2)) {
                      return (false);
                    }
                  }
                }
              }
              else {
                if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(arg2), Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
                  { PatternVariable arg2000 = ((PatternVariable)(arg2));

                    if (!Stella_Object.eqlP(Logic.justificationArgumentBoundTo(arg2000, just2), arg1)) {
                      return (false);
                    }
                  }
                }
                else {
                  return (false);
                }
              }
            }
          }
        }
      }
      return (true);
    }
    return (false);
  }

  public static Description extractCollectionArgument(Proposition proposition) {
    if (proposition.kind == Logic.KWD_ISA) {
      return (Logic.getDescription(((Surrogate)(proposition.operator))));
    }
    else {
      return (((Description)(Logic.argumentBoundTo((proposition.arguments.theArray)[1]))));
    }
  }

  public static AtomicGoalCache setGoalCacheList(Proposition goal, AtomicGoalCache firstcache) {
    { Surrogate operator = Proposition.cachedGoalOperator(goal);
      NamedDescription description = ((operator != null) ? Logic.getDescription(operator) : null);

      if ((description != null) &&
          (!description.deletedP())) {
        return (((AtomicGoalCache)(KeyValueList.setDynamicSlotValue(description.dynamicSlots, Logic.SYM_LOGIC_GOAL_CACHE_LIST, firstcache, null))));
      }
      else {
        return (null);
      }
    }
  }

  public static AtomicGoalCache getGoalCacheList(Proposition goal) {
    { Surrogate operator = Proposition.cachedGoalOperator(goal);
      NamedDescription description = ((operator != null) ? Logic.getDescription(operator) : null);

      if ((description != null) &&
          (!description.deletedP())) {
        return (((AtomicGoalCache)(KeyValueList.dynamicSlotValue(description.dynamicSlots, Logic.SYM_LOGIC_GOAL_CACHE_LIST, null))));
      }
      else {
        return (null);
      }
    }
  }

  public static Surrogate cachedGoalOperator(Proposition goal) {
    { Keyword testValue000 = goal.kind;

      if ((testValue000 == Logic.KWD_ISA) ||
          ((testValue000 == Logic.KWD_PREDICATE) ||
           (testValue000 == Logic.KWD_FUNCTION))) {
        { GeneralizedSymbol operator = goal.operator;

          if ((operator != null) &&
              (Stella_Object.isaP(operator, Logic.SGT_STELLA_SURROGATE) &&
               (!(operator.symbolId == -1)))) {
            return (((Surrogate)(operator)));
          }
        }
      }
      else {
      }
    }
    return (null);
  }

  public static KeyValueList findGoalCacheTable(Proposition goal) {
    { Keyword testValue000 = goal.kind;

      if ((testValue000 == Logic.KWD_ISA) ||
          ((testValue000 == Logic.KWD_PREDICATE) ||
           (testValue000 == Logic.KWD_FUNCTION))) {
        { NamedDescription description = Logic.getDescription(((Surrogate)(goal.operator)));

          if (((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue()) {
            return (((KeyValueList)(KeyValueList.dynamicSlotValue(description.dynamicSlots, Logic.SYM_LOGIC_NEGATED_GOAL_CACHE_TABLE, null))));
          }
          else {
            return (((KeyValueList)(KeyValueList.dynamicSlotValue(description.dynamicSlots, Logic.SYM_LOGIC_GOAL_CACHE_TABLE, null))));
          }
        }
      }
      else {
        return (null);
      }
    }
  }

  public static Cons yieldGoalBindings(Proposition goal) {
    { Cons result = Stella.NIL;

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
      return (result);
    }
  }

  public static Stella_Object buildNetworkTree(Proposition prop, Cons propList) {
    if (propList.memberP(prop)) {
      return (FloatWrapper.wrapFloat(((FloatWrapper)(KeyValueList.dynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue));
    }
    if (!(prop.support() == Stella.NIL)) {
      { Cons proofs = prop.support();
        Cons tree = Stella.NIL;

        { PartialSupport proof = null;
          Cons iter000 = proofs;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            proof = ((PartialSupport)(iter000.value));
            { Proposition fact = proof.fact;
              Cons proofTree = Stella.NIL;

              { Stella_Object arg = null;
                Vector vector000 = fact.arguments;
                int index000 = 0;
                int length000 = vector000.length();
                FloatWrapper score = null;
                Cons iter001 = proof.argumentScores;
                Cons collect000 = null;

                for (;(index000 < length000) &&
                          (!(iter001 == Stella.NIL)); index000 = index000 + 1, iter001 = iter001.rest) {
                  arg = (vector000.theArray)[index000];
                  score = ((FloatWrapper)(iter001.value));
                  if (Stella_Object.isaP(arg, Logic.SGT_LOGIC_PROPOSITION)) {
                    KeyValueList.setDynamicSlotValue(((Proposition)(arg)).dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, FloatWrapper.wrapFloat(score.wrapperValue), Stella.NULL_FLOAT_WRAPPER);
                    if (collect000 == null) {
                      {
                        collect000 = Cons.cons(Proposition.buildNetworkTree(((Proposition)(arg)), Cons.cons(prop, propList)), Stella.NIL);
                        if (proofTree == Stella.NIL) {
                          proofTree = collect000;
                        }
                        else {
                          Cons.addConsToEndOfConsList(proofTree, collect000);
                        }
                      }
                    }
                    else {
                      {
                        collect000.rest = Cons.cons(Proposition.buildNetworkTree(((Proposition)(arg)), Cons.cons(prop, propList)), Stella.NIL);
                        collect000 = collect000.rest;
                      }
                    }
                  }
                }
              }
              if (((PropositionNeuralNetwork)(KeyValueList.dynamicSlotValue(fact.dynamicSlots, Logic.SYM_LOGIC_NEURAL_NETWORK, null))) != null) {
                tree = Cons.cons(Cons.cons(((PropositionNeuralNetwork)(KeyValueList.dynamicSlotValue(fact.dynamicSlots, Logic.SYM_LOGIC_NEURAL_NETWORK, null))), proofTree), tree);
              }
              else {
                tree = Cons.cons(FloatWrapper.wrapFloat(((FloatWrapper)(KeyValueList.dynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue), tree);
              }
            }
          }
        }
        if ((tree.rest == Stella.NIL) &&
            (!Stella_Object.consP(tree.value))) {
          return (tree.value);
        }
        else {
          return (tree);
        }
      }
    }
    else if (((PropositionNeuralNetwork)(KeyValueList.dynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_NEURAL_NETWORK, null))) != null) {
      { Cons tree = Stella.NIL;

        { Stella_Object arg = null;
          Vector vector001 = prop.arguments;
          int index001 = 0;
          int length001 = vector001.length();
          int i = Stella.NULL_INTEGER;
          int iter002 = 1;
          Cons collect001 = null;

          for (;index001 < length001; index001 = index001 + 1, iter002 = iter002 + 1) {
            arg = (vector001.theArray)[index001];
            i = iter002;
            KeyValueList.setDynamicSlotValue(((Proposition)(arg)).dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, FloatWrapper.wrapFloat(((FloatWrapper)((((PropositionNeuralNetwork)(KeyValueList.dynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_NEURAL_NETWORK, null))).input.theArray)[i])).wrapperValue), Stella.NULL_FLOAT_WRAPPER);
            if (collect001 == null) {
              {
                collect001 = Cons.cons(Proposition.buildNetworkTree(((Proposition)(arg)), Cons.cons(prop, propList)), Stella.NIL);
                if (tree == Stella.NIL) {
                  tree = collect001;
                }
                else {
                  Cons.addConsToEndOfConsList(tree, collect001);
                }
              }
            }
            else {
              {
                collect001.rest = Cons.cons(Proposition.buildNetworkTree(((Proposition)(arg)), Cons.cons(prop, propList)), Stella.NIL);
                collect001 = collect001.rest;
              }
            }
          }
        }
        tree = Cons.cons(((PropositionNeuralNetwork)(KeyValueList.dynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_NEURAL_NETWORK, null))), tree);
        return (Cons.consList(Cons.cons(tree, Stella.NIL)));
      }
    }
    else {
      return (FloatWrapper.wrapFloat(((FloatWrapper)(KeyValueList.dynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue));
    }
  }

  public static void quickpropagateError(Proposition prop, double error) {
    { PropositionNeuralNetwork net = ((PropositionNeuralNetwork)(KeyValueList.dynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_NEURAL_NETWORK, null)));
      double output = ((FloatWrapper)(KeyValueList.dynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue;
      double fullError = error;
      double temp = 0.0;
      int numIn = 0;
      int numHidden = 0;
      Vector inputError = null;

      if (net != null) {
        numIn = net.input.length();
        numHidden = net.hidden.length();
        (net.input.theArray)[0] = (FloatWrapper.wrapFloat(1.0));
        { int i = Stella.NULL_INTEGER;
          int iter000 = 1;
          int upperBound000 = numIn - 1;

          for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
            i = iter000;
            (net.input.theArray)[i] = (FloatWrapper.wrapFloat(((FloatWrapper)(KeyValueList.dynamicSlotValue(((Proposition)((prop.arguments.theArray)[(i - 1)])).dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue));
          }
        }
        PropositionNeuralNetwork.activatePropositionalNeuralNetwork(net);
        error = error * (Logic.$SIGMOID_PRIME_OFFSET$ + (output * (1.0 - output)));
        inputError = Vector.newVector(numIn);
        Logic.zeroVector(inputError);
        { int h = Stella.NULL_INTEGER;
          int iter001 = 0;
          int upperBound001 = numHidden - 1;

          for (;iter001 <= upperBound001; iter001 = iter001 + 1) {
            h = iter001;
            (net.hoSlope.theArray)[h] = (FloatWrapper.wrapFloat(((FloatWrapper)((net.hoSlope.theArray)[h])).wrapperValue + (error * ((FloatWrapper)((net.hidden.theArray)[h])).wrapperValue)));
            temp = error * ((FloatWrapper)((net.ho.theArray)[h])).wrapperValue * (Logic.$SIGMOID_PRIME_OFFSET$ + (((FloatWrapper)((net.hidden.theArray)[h])).wrapperValue * (1.0 - ((FloatWrapper)((net.hidden.theArray)[h])).wrapperValue)));
            { int i = Stella.NULL_INTEGER;
              int iter002 = 0;
              int upperBound002 = numIn - 1;

              for (;iter002 <= upperBound002; iter002 = iter002 + 1) {
                i = iter002;
                (net.ihSlope.theArray)[((i * net.ihSlope.nofColumns) + h)] = (FloatWrapper.wrapFloat(((FloatWrapper)((net.ihSlope.theArray)[((i * net.ihSlope.nofColumns) + h)])).wrapperValue + (temp * ((FloatWrapper)((net.input.theArray)[i])).wrapperValue)));
                (inputError.theArray)[i] = (FloatWrapper.wrapFloat(((FloatWrapper)((inputError.theArray)[i])).wrapperValue + (temp * ((FloatWrapper)((net.ih.theArray)[((i * net.ih.nofColumns) + h)])).wrapperValue)));
              }
            }
          }
        }
      }
      { Keyword testValue000 = prop.kind;

        if ((testValue000 == Logic.KWD_AND) ||
            (testValue000 == Logic.KWD_OR)) {
          { Proposition child = null;
            Vector vector000 = ((Vector)(prop.arguments));
            int index000 = 0;
            int length000 = vector000.length();
            int i = Stella.NULL_INTEGER;
            int iter003 = 1;
            int upperBound003 = numIn - 1;

            for (;(index000 < length000) &&
                      (iter003 <= upperBound003); index000 = index000 + 1, iter003 = iter003 + 1) {
              child = ((Proposition)((vector000.theArray)[index000]));
              i = iter003;
              Proposition.quickpropagateError(child, ((FloatWrapper)((inputError.theArray)[i])).wrapperValue);
            }
          }
        }
        else {
          if (!(prop.support() == Stella.NIL)) {
            { Cons proofs = prop.support();
              Cons guilty = Stella.NIL;

              if (Logic.$RULE_COMBINATION$ == Logic.KWD_MAX) {
                guilty = Cons.consList(Cons.cons(((PartialSupport)(proofs.value)), Stella.NIL));
                { PartialSupport proof = null;
                  Cons iter004 = proofs.rest;

                  for (;!(iter004 == Stella.NIL); iter004 = iter004.rest) {
                    proof = ((PartialSupport)(iter004.value));
                    if (proof.score == output) {
                      guilty = Cons.consList(Cons.cons(proof, Stella.NIL));
                    }
                  }
                }
              }
              else if (Logic.$RULE_COMBINATION$ == Logic.KWD_NOISY_OR) {
                guilty = proofs;
              }
              else {
                { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                  stream000.nativeStream.print("`" + Logic.$RULE_COMBINATION$ + "' is not a valid case option");
                  throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                }
              }
              { PartialSupport proof = null;
                Cons iter005 = guilty;

                for (;!(iter005 == Stella.NIL); iter005 = iter005.rest) {
                  proof = ((PartialSupport)(iter005.value));
                  if (!Logic.$PARTIAL_SUPPORT_CACHE$.memberP(IntegerWrapper.wrapInteger(proof.id))) {
                    { Proposition fact = proof.fact;

                      if (proof.argumentScores.length() == 1) {
                        KeyValueList.setDynamicSlotValue(fact.dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, FloatWrapper.wrapFloat(((FloatWrapper)(proof.argumentScores.value)).wrapperValue), Stella.NULL_FLOAT_WRAPPER);
                      }
                      else {
                        { FloatWrapper score = null;
                          Cons iter006 = proof.argumentScores;
                          Stella_Object arg = null;
                          Vector vector001 = fact.arguments;
                          int index001 = 0;
                          int length001 = vector001.length();

                          for (;(!(iter006 == Stella.NIL)) &&
                                    (index001 < length001); iter006 = iter006.rest, index001 = index001 + 1) {
                            score = ((FloatWrapper)(iter006.value));
                            arg = (vector001.theArray)[index001];
                            KeyValueList.setDynamicSlotValue(((Proposition)(arg)).dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, FloatWrapper.wrapFloat(score.wrapperValue), Stella.NULL_FLOAT_WRAPPER);
                          }
                        }
                      }
                      Logic.$PARTIAL_SUPPORT_CACHE$.push(IntegerWrapper.wrapInteger(proof.id));
                      Proposition.quickpropagateError(proof.fact, fullError * proof.score);
                      Logic.$PARTIAL_SUPPORT_CACHE$.pop();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  public static void backpropagateError(Proposition prop, double error) {
    { PropositionNeuralNetwork net = ((PropositionNeuralNetwork)(KeyValueList.dynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_NEURAL_NETWORK, null)));
      double output = ((FloatWrapper)(KeyValueList.dynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue;
      int numHidden = 0;
      double delta = 0.0;
      Vector savedInput = null;
      Vector savedHidden = null;
      Vector hiddenError = null;
      Vector inputError = null;
      int numIn = 0;
      boolean recursiveConflict = false;
      double fullError = error;

      if (net != null) {
        numIn = net.input.length();
        numHidden = net.hidden.length();
        savedInput = net.input;
        savedHidden = net.hidden;
        (net.input.theArray)[0] = (FloatWrapper.wrapFloat(1.0));
        { int i = Stella.NULL_INTEGER;
          int iter000 = 1;
          int upperBound000 = numIn - 1;

          loop000 : for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
            i = iter000;
            { double value = ((FloatWrapper)((net.input.theArray)[i])).wrapperValue;

              if (!(value == ((FloatWrapper)(KeyValueList.dynamicSlotValue(((Proposition)((prop.arguments.theArray)[(i - 1)])).dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue)) {
                recursiveConflict = true;
                break loop000;
              }
            }
          }
        }
        if (recursiveConflict) {
          { int i = Stella.NULL_INTEGER;
            int iter001 = 1;
            int upperBound001 = numIn - 1;

            for (;iter001 <= upperBound001; iter001 = iter001 + 1) {
              i = iter001;
              (net.input.theArray)[i] = (FloatWrapper.wrapFloat(((FloatWrapper)(KeyValueList.dynamicSlotValue(((Proposition)((prop.arguments.theArray)[(i - 1)])).dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue));
            }
          }
          PropositionNeuralNetwork.activatePropositionalNeuralNetwork(net);
        }
        error = error * output * (1.0 - output);
        if (recursiveConflict) {
          savedInput = Vector.newVector(numIn);
          savedHidden = Vector.newVector(numHidden);
          { int i = Stella.NULL_INTEGER;
            int iter002 = 0;
            int upperBound002 = numIn - 1;

            for (;iter002 <= upperBound002; iter002 = iter002 + 1) {
              i = iter002;
              (savedInput.theArray)[i] = (((FloatWrapper)((net.input.theArray)[i])));
            }
          }
          { int i = Stella.NULL_INTEGER;
            int iter003 = 0;
            int upperBound003 = numHidden - 1;

            for (;iter003 <= upperBound003; iter003 = iter003 + 1) {
              i = iter003;
              (savedHidden.theArray)[i] = (((FloatWrapper)((net.hidden.theArray)[i])));
            }
          }
        }
        hiddenError = Vector.newVector(numHidden);
        inputError = Vector.newVector(numIn);
        { int h = Stella.NULL_INTEGER;
          int iter004 = 0;
          int upperBound004 = numHidden - 1;

          for (;iter004 <= upperBound004; iter004 = iter004 + 1) {
            h = iter004;
            (hiddenError.theArray)[h] = (FloatWrapper.wrapFloat(error * ((FloatWrapper)((net.ho.theArray)[h])).wrapperValue));
            (hiddenError.theArray)[h] = (FloatWrapper.wrapFloat(((FloatWrapper)((hiddenError.theArray)[h])).wrapperValue * ((FloatWrapper)((net.hidden.theArray)[h])).wrapperValue * (1.0 - ((FloatWrapper)((net.hidden.theArray)[h])).wrapperValue)));
          }
        }
        { int i = Stella.NULL_INTEGER;
          int iter005 = 0;
          int upperBound005 = numIn - 1;

          for (;iter005 <= upperBound005; iter005 = iter005 + 1) {
            i = iter005;
            (inputError.theArray)[i] = (FloatWrapper.wrapFloat(0.0));
            { int h = Stella.NULL_INTEGER;
              int iter006 = 0;
              int upperBound006 = numHidden - 1;

              for (;iter006 <= upperBound006; iter006 = iter006 + 1) {
                h = iter006;
                (inputError.theArray)[i] = (FloatWrapper.wrapFloat(((FloatWrapper)((inputError.theArray)[i])).wrapperValue + (((FloatWrapper)((hiddenError.theArray)[h])).wrapperValue * ((FloatWrapper)((net.ih.theArray)[((i * net.ih.nofColumns) + h)])).wrapperValue)));
              }
            }
          }
        }
      }
      { Keyword testValue000 = prop.kind;

        if ((testValue000 == Logic.KWD_AND) ||
            (testValue000 == Logic.KWD_OR)) {
          { Proposition child = null;
            Vector vector000 = ((Vector)(prop.arguments));
            int index000 = 0;
            int length000 = vector000.length();
            int i = Stella.NULL_INTEGER;
            int iter007 = 1;
            int upperBound007 = numIn - 1;

            for (;(index000 < length000) &&
                      (iter007 <= upperBound007); index000 = index000 + 1, iter007 = iter007 + 1) {
              child = ((Proposition)((vector000.theArray)[index000]));
              i = iter007;
              Proposition.backpropagateError(child, ((FloatWrapper)((inputError.theArray)[i])).wrapperValue);
            }
          }
          { int h = Stella.NULL_INTEGER;
            int iter008 = 0;
            int upperBound008 = numHidden - 1;

            for (;iter008 <= upperBound008; iter008 = iter008 + 1) {
              h = iter008;
              delta = (Logic.$MOMENTUM_TERM$ * ((FloatWrapper)((net.hoDelta.theArray)[h])).wrapperValue) + (Logic.$LEARNING_RATE$ * error * ((FloatWrapper)((savedHidden.theArray)[h])).wrapperValue);
              (net.ho.theArray)[h] = (FloatWrapper.wrapFloat(((FloatWrapper)((net.ho.theArray)[h])).wrapperValue + delta));
              (net.hoDelta.theArray)[h] = (FloatWrapper.wrapFloat(delta));
            }
          }
          { int i = Stella.NULL_INTEGER;
            int iter009 = 0;
            int upperBound009 = numIn - 1;

            for (;iter009 <= upperBound009; iter009 = iter009 + 1) {
              i = iter009;
              { int h = Stella.NULL_INTEGER;
                int iter010 = 0;
                int upperBound010 = numHidden - 1;

                for (;iter010 <= upperBound010; iter010 = iter010 + 1) {
                  h = iter010;
                  delta = (Logic.$MOMENTUM_TERM$ * ((FloatWrapper)((net.ihDelta.theArray)[((i * net.ihDelta.nofColumns) + h)])).wrapperValue) + (Logic.$LEARNING_RATE$ * ((FloatWrapper)((hiddenError.theArray)[h])).wrapperValue * ((FloatWrapper)((savedInput.theArray)[i])).wrapperValue);
                  (net.ih.theArray)[((i * net.ih.nofColumns) + h)] = (FloatWrapper.wrapFloat(((FloatWrapper)((net.ih.theArray)[((i * net.ih.nofColumns) + h)])).wrapperValue + delta));
                  (net.ihDelta.theArray)[((i * net.ihDelta.nofColumns) + h)] = (FloatWrapper.wrapFloat(delta));
                }
              }
            }
          }
        }
        else {
          if (!(prop.support() == Stella.NIL)) {
            { Cons proofs = prop.support();
              Cons guilty = Stella.NIL;

              if (Logic.$RULE_COMBINATION$ == Logic.KWD_MAX) {
                guilty = Cons.consList(Cons.cons(((PartialSupport)(proofs.value)), Stella.NIL));
                { PartialSupport proof = null;
                  Cons iter011 = proofs.rest;

                  for (;!(iter011 == Stella.NIL); iter011 = iter011.rest) {
                    proof = ((PartialSupport)(iter011.value));
                    if (proof.score == output) {
                      guilty = Cons.consList(Cons.cons(proof, Stella.NIL));
                    }
                  }
                }
              }
              else if (Logic.$RULE_COMBINATION$ == Logic.KWD_NOISY_OR) {
                guilty = proofs;
              }
              else {
                { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                  stream000.nativeStream.print("`" + Logic.$RULE_COMBINATION$ + "' is not a valid case option");
                  throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                }
              }
              { PartialSupport proof = null;
                Cons iter012 = guilty;

                for (;!(iter012 == Stella.NIL); iter012 = iter012.rest) {
                  proof = ((PartialSupport)(iter012.value));
                  if (!Logic.$PARTIAL_SUPPORT_CACHE$.memberP(IntegerWrapper.wrapInteger(proof.id))) {
                    { Proposition fact = proof.fact;

                      if (proof.argumentScores.length() == 1) {
                        KeyValueList.setDynamicSlotValue(fact.dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, FloatWrapper.wrapFloat(((FloatWrapper)(proof.argumentScores.value)).wrapperValue), Stella.NULL_FLOAT_WRAPPER);
                      }
                      else {
                        { FloatWrapper score = null;
                          Cons iter013 = proof.argumentScores;
                          Stella_Object arg = null;
                          Vector vector001 = fact.arguments;
                          int index001 = 0;
                          int length001 = vector001.length();

                          for (;(!(iter013 == Stella.NIL)) &&
                                    (index001 < length001); iter013 = iter013.rest, index001 = index001 + 1) {
                            score = ((FloatWrapper)(iter013.value));
                            arg = (vector001.theArray)[index001];
                            KeyValueList.setDynamicSlotValue(((Proposition)(arg)).dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, FloatWrapper.wrapFloat(score.wrapperValue), Stella.NULL_FLOAT_WRAPPER);
                          }
                        }
                      }
                      Logic.$PARTIAL_SUPPORT_CACHE$.push(IntegerWrapper.wrapInteger(proof.id));
                      Proposition.backpropagateError(proof.fact, fullError * proof.score);
                      Logic.$PARTIAL_SUPPORT_CACHE$.pop();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  public static PropositionNeuralNetwork createNeuralNetwork(Proposition prop) {
    { PropositionNeuralNetwork net = null;
      int numIn = prop.arguments.length() + 1;
      int numHidden = Stella.integer_min(numIn + 0, 20);

      if (numIn > 100) {
        numHidden = Native.floor(numIn / 10.0) + 10;
      }
      net = Logic.allocateNeuralNetwork(numIn, numHidden);
      Logic.$MASTER_NEURAL_NETWORK_LIST$.push(net);
      net.proposition = prop;
      { Keyword testValue000 = prop.kind;

        if ((testValue000 == Logic.KWD_AND) ||
            (testValue000 == Logic.KWD_OR)) {
          PropositionNeuralNetwork.randomizeNeuralNetwork(net);
        }
        else {
          PropositionNeuralNetwork.randomizeNeuralNetwork(net);
        }
      }
      return (net);
    }
  }

  public static Cons propositionToCons(Proposition prop) {
    { Cons result = Stella.NIL;

      { Stella_Object arg = null;
        Vector vector000 = prop.arguments;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          result = Cons.cons(Logic.consifyArgument(arg), result);
        }
      }
      { Keyword testValue000 = prop.kind;

        if (testValue000 == Logic.KWD_IN) {
          return (result);
        }
        else if ((testValue000 == Logic.KWD_PREDICATE) ||
            (testValue000 == Logic.KWD_FUNCTION)) {
          result = Cons.cons(Symbol.internSymbolInModule(((Surrogate)(prop.operator)).symbolName, ((Module)(((Surrogate)(prop.operator)).homeContext)), true), result.reverse());
        }
        else if (testValue000 == Logic.KWD_EQUIVALENT) {
          result = Cons.cons(Logic.SYM_STELLA_e, result.reverse());
        }
        else if ((testValue000 == Logic.KWD_FORALL) ||
            (testValue000 == Logic.KWD_EXISTS)) {
          if (!(result.rest == Stella.NIL)) {
            result = Cons.consList(Cons.cons(Logic.SYM_STELLA_OR, Cons.cons(Cons.consList(Cons.cons(Logic.SYM_STELLA_NOT, Cons.cons(result.rest.value, Stella.NIL))), Cons.cons(result.value, Stella.NIL))));
          }
          else {
            result = ((Cons)(result.value));
          }
          { Cons bindings = Stella.NIL;

            { PatternVariable io = null;
              Vector vector001 = ((Vector)(KeyValueList.dynamicSlotValue(prop.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
              int index001 = 0;
              int length001 = vector001.length();

              for (;index001 < length001; index001 = index001 + 1) {
                io = ((PatternVariable)((vector001.theArray)[index001]));
                if (Logic.argumentBoundTo(io) == null) {
                  bindings = Cons.cons(Cons.consList(Cons.cons(Symbol.internSymbol(Skolem.getSkolemPrintName(io)), Cons.cons(Symbol.internSymbol(Logic.logicalType(io).symbolName), Stella.NIL))), bindings);
                }
              }
            }
            if (!(bindings == Stella.NIL)) {
              result = Cons.consList(Cons.cons(Symbol.internSymbol(prop.kind.symbolName), Cons.cons(bindings, Cons.cons(result, Stella.NIL))));
            }
          }
        }
        else {
          result = Cons.cons(Symbol.internSymbol(((Surrogate)(prop.operator)).symbolName), result.reverse());
        }
      }
      if (Proposition.falseP(prop)) {
        return (Cons.list$(Cons.cons(Logic.SYM_STELLA_NOT, Cons.cons(result, Cons.cons(Stella.NIL, Stella.NIL)))));
      }
      else {
        return (result);
      }
    }
  }

  public static boolean partialArgumentsUnifyWithArgumentsP(Proposition subproposition, Proposition referenceproposition) {
    { PatternRecord patternrecord = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord;
      int ubstackoffset = patternrecord.topUnbindingStackOffset;
      boolean successP = false;

      { boolean testValue000 = false;

        { boolean alwaysP000 = true;

          { Stella_Object superarg = null;
            Vector vector000 = referenceproposition.arguments;
            int index000 = 0;
            int length000 = vector000.length();
            Stella_Object subarg = null;
            Vector vector001 = subproposition.arguments;
            int index001 = 0;
            int length001 = vector001.length();

            loop000 : for (;(index000 < length000) &&
                      (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
              superarg = (vector000.theArray)[index000];
              subarg = (vector001.theArray)[index001];
              if (!(Logic.nullInstanceP(subarg) ||
                  (Logic.nullInstanceP(superarg) ||
                   Logic.bindArgumentToValueP(superarg, Logic.valueOf(subarg), false)))) {
                alwaysP000 = false;
                break loop000;
              }
            }
          }
          testValue000 = alwaysP000;
        }
        if (testValue000) {
          testValue000 = referenceproposition.arguments.length() == subproposition.arguments.length();
        }
        successP = testValue000;
      }
      if (!successP) {
        PatternRecord.unbindVariablesBeginningAt(patternrecord, ubstackoffset + 1);
      }
      return (successP);
    }
  }

  public static Iterator allMatchingPartialPropositions(Proposition self) {
    { Cons pattern = Cons.cons(Logic.KWD_RELATION, Cons.cons(((Stella.NIL == null) ? Stella.NIL : Stella.NIL), Cons.cons(((Surrogate)(self.operator)), Cons.cons(Logic.getNullInstance(), Stella.NIL))));

      { SpecializingPropositionsIterator self000 = SpecializingPropositionsIterator.newSpecializingPropositionsIterator();

        self000.selectionPattern = pattern;
        self000.propositionCursor = Logic.selectPropositions(pattern).allocateIterator();
        { SpecializingPropositionsIterator value000 = self000;

          return (value000);
        }
      }
    }
  }

  public static boolean allVariablesUnboundP(Proposition prop) {
    { boolean foundP000 = false;

      { Stella_Object var = null;
        Vector vector000 = prop.arguments;
        int index000 = 0;
        int length000 = vector000.length();

        loop000 : for (;index000 < length000; index000 = index000 + 1) {
          var = (vector000.theArray)[index000];
          if (Logic.argumentBoundTo(var) != null) {
            foundP000 = true;
            break loop000;
          }
        }
      }
      if (foundP000) {
        return (false);
      }
      else {
        return (true);
      }
    }
  }

  public static Cons getUnboundVariables(Proposition prop) {
    { Cons result = Stella.NIL;

      { Stella_Object arg = null;
        Vector vector000 = prop.arguments;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          { Stella_Object bind = Logic.argumentBoundTo(arg);

            if (bind == null) {
              result = Cons.cons(arg, result);
            }
          }
        }
      }
      return (result);
    }
  }

  public static Iterator allMatchingExtensionMembers(Proposition self, boolean specializeP) {
    { DescriptionExtensionIterator iterator = NamedDescription.allTrueExtensionMembers(Logic.surrogateToDescription(((Surrogate)(self.operator))), specializeP);

      iterator.referenceProposition = self;
      return (iterator);
    }
  }

  public static boolean collectionofPropositionP(Proposition definingproposition) {
    return (Logic.logicalSubtypeOfP(((Surrogate)(definingproposition.operator)), Logic.SGT_PL_KERNEL_KB_COLLECTIONOF));
  }

  public static boolean allKeyArgumentsBoundP(Proposition goal) {
    if ((goal.kind == Logic.KWD_FUNCTION) ||
        Proposition.singleValuedPredicateP(goal)) {
      if (((Vector)(KeyValueList.dynamicSlotValue(goal.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null))) != null) {
        { boolean alwaysP000 = true;

          { int i = Stella.NULL_INTEGER;
            int iter000 = 0;
            int upperBound000 = goal.arguments.length() - 2;

            loop000 : for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
              i = iter000;
              if (!Logic.quantifiedArgumentBoundP((goal.arguments.theArray)[i], null)) {
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
      else {
        { boolean alwaysP001 = true;

          { int i = Stella.NULL_INTEGER;
            int iter001 = 0;
            int upperBound001 = goal.arguments.length() - 2;

            loop001 : for (;iter001 <= upperBound001; iter001 = iter001 + 1) {
              i = iter001;
              if (!Logic.argumentBoundP((goal.arguments.theArray)[i])) {
                alwaysP001 = false;
                break loop001;
              }
            }
          }
          { boolean value001 = alwaysP001;

            return (value001);
          }
        }
      }
    }
    else {
      return (false);
    }
  }

  public static boolean allArgumentsBoundP(Proposition goal) {
    if (((Vector)(KeyValueList.dynamicSlotValue(goal.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null))) != null) {
      return (Logic.quantifiedArgumentBoundP(goal, null));
    }
    else {
      return (Logic.argumentBoundP(goal));
    }
  }

  public boolean clusteredConjunctionP() {
    { Proposition self = this;

      { boolean foundP000 = false;

        { Stella_Object conjunct = null;
          Vector vector000 = self.arguments;
          int index000 = 0;
          int length000 = vector000.length();

          loop000 : for (;index000 < length000; index000 = index000 + 1) {
            conjunct = (vector000.theArray)[index000];
            if (((Proposition)(conjunct)).kind == Logic.KWD_AND) {
              foundP000 = true;
              break loop000;
            }
          }
        }
        { boolean value000 = foundP000;

          return (value000);
        }
      }
    }
  }

  public static boolean containsOperatorP(Proposition proposition, Surrogate operator) {
    { boolean testValue000 = false;

      if (proposition.operator == operator) {
        testValue000 = true;
      }
      else {
        { boolean foundP000 = false;

          { Stella_Object arg = null;
            Vector vector000 = proposition.arguments;
            int index000 = 0;
            int length000 = vector000.length();

            loop000 : for (;index000 < length000; index000 = index000 + 1) {
              arg = (vector000.theArray)[index000];
              if (Stella_Object.isaP(arg, Logic.SGT_LOGIC_PROPOSITION) &&
                  Proposition.containsOperatorP(((Proposition)(arg)), operator)) {
                foundP000 = true;
                break loop000;
              }
            }
          }
          testValue000 = foundP000;
        }
      }
      { boolean value000 = testValue000;

        return (value000);
      }
    }
  }

  public static void printSatellites(Proposition forallprop) {
    { Proposition rule = null;
      Cons iter000 = forallprop.satellitePropositions().theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        rule = ((Proposition)(iter000.value));
        Stella.STANDARD_OUTPUT.nativeStream.println(rule.toString());
      }
    }
  }

  public static void deriveComplexForwardRule(Proposition goal, Proposition masterforall) {
    { Description goaldescription = ((goal.kind == Logic.KWD_NOT) ? NamedDescription.getComplementOfGoalDescription(Logic.surrogateToDescription(((Surrogate)(((Proposition)((goal.arguments.theArray)[0])).operator)))) : Logic.surrogateToDescription(((Surrogate)(goal.operator))));
      ForwardChainingIndex duplicate = null;

      { ForwardChainingIndex idx = null;
        Cons iter000 = goaldescription.forwardChainingIndices().removeDeletedMembers().theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          idx = ((ForwardChainingIndex)(iter000.value));
          if (goal == idx.forwardGoal) {
            duplicate = idx;
          }
        }
      }
      if (duplicate != null) {
        goaldescription.forwardChainingIndices().remove(duplicate);
      }
      if (goaldescription.forwardChainingIndices() == Stella.NIL_LIST) {
        KeyValueList.setDynamicSlotValue(goaldescription.dynamicSlots, Logic.SYM_LOGIC_FORWARD_CHAINING_INDICES, List.list(Stella.NIL), null);
      }
      goaldescription.forwardChainingIndices().insert(Proposition.createForwardChainingIndex(goal, masterforall));
    }
  }

  public static ForwardChainingIndex createForwardChainingIndex(Proposition goal, Proposition masterforall) {
    { ForwardChainingIndex index = ForwardChainingIndex.newForwardChainingIndex();
      KeyValueMap mapping = KeyValueMap.newKeyValueMap();
      Proposition forallcopy = Proposition.copyProposition(masterforall, mapping);
      Stella_Object goalcopy = mapping.lookup(goal);

      forallcopy = Proposition.substituteProposition(forallcopy, ((Proposition)(goalcopy)), Logic.TRUE_PROPOSITION);
      { Vector iovariables = ((Vector)(KeyValueList.dynamicSlotValue(forallcopy.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
        Cons iovariablenames = null;
        List goalvariablelist = List.list(Stella.NIL);
        Cons goalvariablenames = Stella.NIL;
        Cons existvariablenames = Stella.NIL;
        Cons querybody = null;
        Cons consequenttree = null;

        { Cons value000 = null;
          Stella_Object value001 = null;
          Cons value002 = null;

          { Object [] caller_MV_returnarray = new Object[2];

            value000 = Logic.deconstructForallTree(((Cons)(Proposition.generateProposition(forallcopy))), caller_MV_returnarray);
            value001 = ((Stella_Object)(caller_MV_returnarray[0]));
            value002 = ((Cons)(caller_MV_returnarray[1]));
          }
          {
            iovariablenames = value000;
            querybody = ((Cons)(value001));
            consequenttree = value002;
          }
        }
        Logic.collectFreeVariables(goal, goalvariablelist, List.list(Stella.NIL), List.list(Stella.NIL));
        { Cons value003 = Stella.NIL;

          { Stella_Object arg = null;
            Cons iter000 = goalvariablelist.theConsList;
            Cons collect000 = null;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              arg = iter000.value;
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(((PatternVariable)(arg)).skolemName, Stella.NIL);
                  if (value003 == Stella.NIL) {
                    value003 = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(value003, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(((PatternVariable)(arg)).skolemName, Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
          goalvariablenames = value003;
        }
        { Stella_Object v = null;
          Cons iter001 = iovariablenames;
          int i = Stella.NULL_INTEGER;
          int iter002 = 0;
          Cons collect001 = null;

          for (;!(iter001 == Stella.NIL); iter001 = iter001.rest, iter002 = iter002 + 1) {
            v = iter001.value;
            i = iter002;
            if (!Stella_Object.searchConsTreeP(consequenttree, v)) {
              (iovariables.theArray)[i] = null;
              if (collect001 == null) {
                {
                  collect001 = Cons.cons(v, Stella.NIL);
                  if (existvariablenames == Stella.NIL) {
                    existvariablenames = collect001;
                  }
                  else {
                    Cons.addConsToEndOfConsList(existvariablenames, collect001);
                  }
                }
              }
              else {
                {
                  collect001.rest = Cons.cons(v, Stella.NIL);
                  collect001 = collect001.rest;
                }
              }
            }
          }
        }
        iovariablenames = iovariablenames.subtract(existvariablenames);
        iovariables = Logic.removeNullsInVariablesVector(iovariables);
        KeyValueList.setDynamicSlotValue(forallcopy.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, iovariables, null);
        index.consequent = Proposition.constructDescriptionFromForallProposition(forallcopy, Logic.KWD_HEAD);
        existvariablenames = existvariablenames.subtract(goalvariablenames);
        if (!(existvariablenames == Stella.NIL)) {
          querybody = Cons.list$(Cons.cons(Logic.SYM_STELLA_EXISTS, Cons.cons(existvariablenames, Cons.cons(Cons.cons(querybody, Stella.NIL), Stella.NIL))));
        }
        iovariablenames = goalvariablenames.concatenate(iovariablenames, Stella.NIL);
        index.ioVariables = iovariablenames;
        index.queryBody = querybody;
        { Cons value004 = Stella.NIL;

          { Stella_Object v = null;
            Cons iter003 = iovariablenames;
            Cons collect002 = null;

            for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
              v = iter003.value;
              if (v != null) {
                if (collect002 == null) {
                  {
                    collect002 = Cons.cons(null, Stella.NIL);
                    if (value004 == Stella.NIL) {
                      value004 = collect002;
                    }
                    else {
                      Cons.addConsToEndOfConsList(value004, collect002);
                    }
                  }
                }
                else {
                  {
                    collect002.rest = Cons.cons(null, Stella.NIL);
                    collect002 = collect002.rest;
                  }
                }
              }
            }
          }
          index.inputBindings = value004;
        }
      }
      index.forwardGoal = goal;
      index.masterRule = masterforall;
      index.cacheId = Stella.gensym("FWD-QUERY");
      return (index);
    }
  }

  public static Proposition deriveImpliesFromForall(Proposition forallprop) {
    { List heads = Proposition.findMatchableGoals(forallprop, Logic.KWD_HEAD);
      List tails = Proposition.findMatchableGoals(forallprop, Logic.KWD_TAIL);
      Proposition headgoal = ((Proposition)(heads.first()));
      Proposition tailgoal = ((Proposition)(tails.first()));
      Proposition headproposition = ((Proposition)((forallprop.arguments.theArray)[1]));
      Proposition tailproposition = ((Proposition)((forallprop.arguments.theArray)[0]));

      { boolean testValue000 = false;

        testValue000 = heads.length() == 1;
        if (testValue000) {
          testValue000 = tails.length() == 1;
          if (testValue000) {
            { boolean alwaysP000 = true;

              { Stella_Object hv = null;
                Vector vector000 = headgoal.arguments;
                int index000 = 0;
                int length000 = vector000.length();
                Stella_Object tv = null;
                Vector vector001 = tailgoal.arguments;
                int index001 = 0;
                int length001 = vector001.length();

                loop000 : for (;(index000 < length000) &&
                          (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
                  hv = (vector000.theArray)[index000];
                  tv = (vector001.theArray)[index001];
                  if (!(Stella_Object.eqlP(hv, tv) &&
                      Stella_Object.isaP(hv, Logic.SGT_LOGIC_PATTERN_VARIABLE))) {
                    alwaysP000 = false;
                    break loop000;
                  }
                }
              }
              testValue000 = alwaysP000;
            }
            if (testValue000) {
              testValue000 = headgoal.arguments.length() == tailgoal.arguments.length();
              if (testValue000) {
                testValue000 = ((Proposition)(heads.first())) == headproposition;
                if (testValue000) {
                  if (((Proposition)(tails.first())) == tailproposition) {
                    testValue000 = true;
                  }
                  else {
                    {
                      testValue000 = tailproposition.kind == Logic.KWD_AND;
                      if (testValue000) {
                        { boolean alwaysP001 = true;

                          { Stella_Object arg = null;
                            Vector vector002 = tailproposition.arguments;
                            int index002 = 0;
                            int length002 = vector002.length();

                            loop001 : for (;index002 < length002; index002 = index002 + 1) {
                              arg = (vector002.theArray)[index002];
                              if (!(arg == tailgoal)) {
                                alwaysP001 = false;
                                break loop001;
                              }
                            }
                          }
                          testValue000 = alwaysP001;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        if (testValue000) {
          return (Logic.createImpliesProposition(Proposition.extractGoalDescription(tailgoal, null), Proposition.extractGoalDescription(headgoal, null)));
        }
        else {
          return (null);
        }
      }
    }
  }

  public static void deriveSatelliteRules(Proposition forallprop) {
    if (!Proposition.deriveSatelliteRulesForGoalP(forallprop, null, (Logic.naturalDeductionModeP() ? Logic.KWD_POSITIVE : Logic.KWD_POSITIVE_AND_CONTRAPOSITIVE), Logic.$LAZY_SATELLITE_RULESp$)) {
      if (Logic.$CYC_KLUDGES_ENABLEDp$) {
        if (Stella_Object.isaP((forallprop.arguments.theArray)[1], Logic.SGT_LOGIC_PROPOSITION) &&
            (((Proposition)((forallprop.arguments.theArray)[1])).kind == Logic.KWD_EXISTS)) {
          return;
        }
      }
      {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: PowerLoom can't index the rule:");
        Stella.STANDARD_WARNING.nativeStream.println("   `" + forallprop + "'");
        Stella.STANDARD_WARNING.nativeStream.println();
      }
;
    }
  }

  public static boolean deriveSatelliteRulesForGoalP(Proposition forallprop, Description goaldescription, Keyword direction, boolean lazysatellitesP) {
    Logic.finalizeObjects();
    { boolean createdsatellitesP = false;
      Description goaldesc = null;
      boolean positiveonlyP = direction == Logic.KWD_POSITIVE;
      boolean contrapositiveonlyP = direction == Logic.KWD_CONTRAPOSITIVE;

      { Object old$Context$000 = Stella.$CONTEXT$.get();
        Object old$Module$000 = Stella.$MODULE$.get();

        try {
          Native.setSpecial(Stella.$CONTEXT$, forallprop.homeContext);
          Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
          { Proposition goal = null;
            Cons iter000 = Proposition.findMatchableGoals(forallprop, Logic.KWD_HEAD).theConsList;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              goal = ((Proposition)(iter000.value));
              if ((goaldescription == null) ||
                  (goaldescription == Proposition.extractGoalDescription(goal, Logic.KWD_HEAD))) {
                createdsatellitesP = true;
                if (lazysatellitesP) {
                  if (goaldescription == null) {
                    goaldesc = Proposition.extractGoalDescription(goal, Logic.KWD_HEAD);
                  }
                  else {
                    goaldesc = goaldescription;
                  }
                  if (((SequenceIndex)(KeyValueList.dynamicSlotValue(goaldesc.dynamicSlots, Logic.SYM_LOGIC_RULES_WITH_DEFERRED_SATELLITES, null))) == null) {
                    KeyValueList.setDynamicSlotValue(goaldesc.dynamicSlots, Logic.SYM_LOGIC_RULES_WITH_DEFERRED_SATELLITES, Logic.createSequenceIndex(Logic.KWD_NON_PAGING, Stella.NIL), null);
                  }
                  ((SequenceIndex)(KeyValueList.dynamicSlotValue(goaldesc.dynamicSlots, Logic.SYM_LOGIC_RULES_WITH_DEFERRED_SATELLITES, null))).insert(forallprop);
                }
                else if (!contrapositiveonlyP) {
                  Proposition.deriveOneSatelliteRule(forallprop, goal, Logic.KWD_HEAD, false);
                }
                if ((!positiveonlyP) &&
                    ((!((BooleanWrapper)(KeyValueList.dynamicSlotValue(forallprop.dynamicSlots, Logic.SYM_LOGIC_BACKWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue) &&
                     (!Proposition.atomicForallArgumentP(forallprop, Logic.KWD_TAIL)))) {
                  if (lazysatellitesP) {
                    KeyValueList.setDynamicSlotValue(goaldesc.dynamicSlots, Logic.SYM_LOGIC_DEFERRED_CONTRAPOSITIVESp, Stella.TRUE_WRAPPER, null);
                  }
                  else {
                    Proposition.deriveOneSatelliteRule(forallprop, goal, Logic.KWD_HEAD, true);
                  }
                }
              }
            }
          }
          if ((!((BooleanWrapper)(KeyValueList.dynamicSlotValue(forallprop.dynamicSlots, Logic.SYM_LOGIC_BACKWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue) &&
              (Proposition.atomicForallArgumentP(forallprop, Logic.KWD_TAIL) ||
               ((!Proposition.atomicForallArgumentP(forallprop, Logic.KWD_HEAD)) ||
                ((BooleanWrapper)(KeyValueList.dynamicSlotValue(forallprop.dynamicSlots, Logic.SYM_LOGIC_FORWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue))) {
            { Proposition goal = null;
              Cons iter001 = Proposition.findMatchableGoals(forallprop, Logic.KWD_TAIL).theConsList;

              for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                goal = ((Proposition)(iter001.value));
                if ((goaldescription == null) ||
                    (goaldescription == Proposition.extractGoalDescription(goal, Logic.KWD_TAIL))) {
                  createdsatellitesP = true;
                  if (lazysatellitesP) {
                    if (goaldescription == null) {
                      goaldesc = Proposition.extractGoalDescription(goal, Logic.KWD_TAIL);
                    }
                    else {
                      goaldesc = goaldescription;
                    }
                    if (((SequenceIndex)(KeyValueList.dynamicSlotValue(goaldesc.dynamicSlots, Logic.SYM_LOGIC_RULES_WITH_DEFERRED_SATELLITES, null))) == null) {
                      KeyValueList.setDynamicSlotValue(goaldesc.dynamicSlots, Logic.SYM_LOGIC_RULES_WITH_DEFERRED_SATELLITES, Logic.createSequenceIndex(Logic.KWD_NON_PAGING, Stella.NIL), null);
                    }
                    ((SequenceIndex)(KeyValueList.dynamicSlotValue(goaldesc.dynamicSlots, Logic.SYM_LOGIC_RULES_WITH_DEFERRED_SATELLITES, null))).insert(forallprop);
                  }
                  else if (!contrapositiveonlyP) {
                    Proposition.deriveOneSatelliteRule(forallprop, goal, Logic.KWD_TAIL, false);
                  }
                  if ((!positiveonlyP) &&
                      ((!((BooleanWrapper)(KeyValueList.dynamicSlotValue(forallprop.dynamicSlots, Logic.SYM_LOGIC_FORWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue) &&
                       (!Proposition.atomicForallArgumentP(forallprop, Logic.KWD_HEAD)))) {
                    if (lazysatellitesP) {
                      KeyValueList.setDynamicSlotValue(goaldesc.dynamicSlots, Logic.SYM_LOGIC_DEFERRED_CONTRAPOSITIVESp, Stella.TRUE_WRAPPER, null);
                    }
                    else {
                      Proposition.deriveOneSatelliteRule(forallprop, goal, Logic.KWD_TAIL, true);
                    }
                  }
                }
              }
            }
          }
          if (createdsatellitesP &&
              (((TruthValue)(Stella_Object.accessInContext(forallprop.truthValue, forallprop.homeContext, false))) != null)) {
            { Object old$Context$001 = Stella.$CONTEXT$.get();
              Object old$Module$001 = Stella.$MODULE$.get();

              try {
                Native.setSpecial(Stella.$CONTEXT$, forallprop.homeContext);
                Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
                { Object old$InvisibleassertionP$000 = Logic.$INVISIBLEASSERTIONp$.get();

                  try {
                    Native.setBooleanSpecial(Logic.$INVISIBLEASSERTIONp$, true);
                    { Proposition satellite = null;
                      Cons iter002 = forallprop.satellitePropositions().theConsList;

                      for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                        satellite = ((Proposition)(iter002.value));
                        Proposition.assignTruthValue(satellite, ((TruthValue)(Stella_Object.accessInContext(forallprop.truthValue, forallprop.homeContext, false))));
                      }
                    }

                  } finally {
                    Logic.$INVISIBLEASSERTIONp$.set(old$InvisibleassertionP$000);
                  }
                }

              } finally {
                Stella.$MODULE$.set(old$Module$001);
                Stella.$CONTEXT$.set(old$Context$001);
              }
            }
          }
          return (createdsatellitesP);

        } finally {
          Stella.$MODULE$.set(old$Module$000);
          Stella.$CONTEXT$.set(old$Context$000);
        }
      }
    }
  }

  public static void deriveOneSatelliteRule(Proposition masterforall, Proposition goal, Keyword headortail, boolean contrapositiveP) {
    { Proposition invertedforall = null;
      Description head = null;
      Description tail = null;
      boolean overrideforwardonlyP = false;

      if ((headortail == Logic.KWD_TAIL) &&
          (((!Proposition.atomicGoalPropositionP(((Proposition)((masterforall.arguments.theArray)[0])))) ||
          Proposition.variableArityGoalPropositionP(((Proposition)((masterforall.arguments.theArray)[0])))) &&
           (!contrapositiveP))) {
        Proposition.deriveComplexForwardRule(goal, masterforall);
        return;
      }
      { Object old$Evaluationmode$000 = Logic.$EVALUATIONMODE$.get();

        try {
          Native.setSpecial(Logic.$EVALUATIONMODE$, Logic.KWD_DESCRIPTION);
          invertedforall = Proposition.invertForallAroundGoal(masterforall, goal, headortail, contrapositiveP);

        } finally {
          Logic.$EVALUATIONMODE$.set(old$Evaluationmode$000);
        }
      }
      if (invertedforall == null) {
        return;
      }
      if (contrapositiveP) {
        if (headortail == Logic.KWD_HEAD) {
          headortail = Logic.KWD_TAIL;
        }
        else if (headortail == Logic.KWD_TAIL) {
          headortail = Logic.KWD_HEAD;
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + headortail + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      if (headortail == Logic.KWD_HEAD) {
        head = Proposition.extractGoalDescription(((Proposition)((invertedforall.arguments.theArray)[1])), null);
        tail = Proposition.constructDescriptionFromForallProposition(invertedforall, Logic.KWD_TAIL);
      }
      else if (headortail == Logic.KWD_TAIL) {
        tail = Proposition.extractGoalDescription(((Proposition)((invertedforall.arguments.theArray)[0])), null);
        head = Proposition.constructDescriptionFromForallProposition(invertedforall, Logic.KWD_HEAD);
      }
      else {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("`" + headortail + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
      if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(masterforall.dynamicSlots, Logic.SYM_LOGIC_FORWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue &&
          (headortail == Logic.KWD_HEAD)) {
        overrideforwardonlyP = Description.namedDescriptionP(head) &&
            (Description.namedDescriptionP(tail) &&
             (head.arity() == tail.arity()));
        if (!overrideforwardonlyP) {
          return;
        }
      }
      { Proposition impliesprop = Logic.createImpliesProposition(tail, head);

        { Object old$Evaluationmode$001 = Logic.$EVALUATIONMODE$.get();

          try {
            Native.setSpecial(Logic.$EVALUATIONMODE$, Logic.KWD_EXTENSIONAL_ASSERTION);
            { Proposition duplicate = Proposition.recursivelyFastenDownPropositions(impliesprop, false);

              if (!(duplicate == impliesprop)) {
                impliesprop = duplicate;
              }
              else if (headortail == Logic.KWD_TAIL) {
                Proposition.markAsForwardRule(impliesprop);
              }
            }

          } finally {
            Logic.$EVALUATIONMODE$.set(old$Evaluationmode$001);
          }
        }
        if (masterforall.satellitePropositions().emptyP()) {
          KeyValueList.setDynamicSlotValue(masterforall.dynamicSlots, Logic.SYM_LOGIC_SATELLITE_PROPOSITIONS, List.newList(), null);
        }
        masterforall.satellitePropositions().insertNew(impliesprop);
        KeyValueList.setDynamicSlotValue(impliesprop.dynamicSlots, Logic.SYM_LOGIC_MASTER_PROPOSITION, masterforall, null);
        if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(masterforall.dynamicSlots, Logic.SYM_LOGIC_FORWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue &&
            (!overrideforwardonlyP)) {
          if (contrapositiveP) {
            KeyValueList.setDynamicSlotValue(impliesprop.dynamicSlots, Logic.SYM_LOGIC_BACKWARD_ONLYp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
          }
          else {
            KeyValueList.setDynamicSlotValue(impliesprop.dynamicSlots, Logic.SYM_LOGIC_FORWARD_ONLYp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
          }
        }
        if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(masterforall.dynamicSlots, Logic.SYM_LOGIC_BACKWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue) {
          if (contrapositiveP) {
            KeyValueList.setDynamicSlotValue(impliesprop.dynamicSlots, Logic.SYM_LOGIC_FORWARD_ONLYp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
          }
          else {
            KeyValueList.setDynamicSlotValue(impliesprop.dynamicSlots, Logic.SYM_LOGIC_BACKWARD_ONLYp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
          }
        }
        if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(masterforall.dynamicSlots, Logic.SYM_LOGIC_DONT_OPTIMIZEp, Stella.FALSE_WRAPPER))).wrapperValue) {
          KeyValueList.setDynamicSlotValue(impliesprop.dynamicSlots, Logic.SYM_LOGIC_DONT_OPTIMIZEp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
          tail = ((Description)((impliesprop.arguments.theArray)[0]));
          if (tail.nativeRelation() == null) {
            KeyValueList.setDynamicSlotValue(tail.dynamicSlots, Logic.SYM_LOGIC_DONT_OPTIMIZEp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
          }
          head = ((Description)((impliesprop.arguments.theArray)[1]));
          if (head.nativeRelation() == null) {
            KeyValueList.setDynamicSlotValue(head.dynamicSlots, Logic.SYM_LOGIC_DONT_OPTIMIZEp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
          }
        }
      }
    }
  }

  public static void markAsForwardRule(Proposition impliesprop) {
    { Description head = ((Description)((impliesprop.arguments.theArray)[1]));

      if ((!Description.namedDescriptionP(head)) &&
          (((Description)(KeyValueList.dynamicSlotValue(head.dynamicSlots, Logic.SYM_LOGIC_COMPLEMENT_DESCRIPTION, null))) == null)) {
        KeyValueList.setDynamicSlotValue(impliesprop.dynamicSlots, Logic.SYM_LOGIC_FORWARD_ONLYp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
      }
    }
  }

  public static Description constructDescriptionFromForallProposition(Proposition forallprop, Keyword headortail) {
    { Description description = Description.newDescription();

      description.proposition = ((Proposition)((forallprop.arguments.theArray)[(((headortail == Logic.KWD_HEAD) ? 1 : 0))]));
      description.ioVariables = ((Vector)(KeyValueList.dynamicSlotValue(forallprop.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null))).copy();
      { Object old$Evaluationmode$000 = Logic.$EVALUATIONMODE$.get();

        try {
          Native.setSpecial(Logic.$EVALUATIONMODE$, Logic.KWD_DESCRIPTION);
          return (Description.finishBuildingDescription(description, true, headortail));

        } finally {
          Logic.$EVALUATIONMODE$.set(old$Evaluationmode$000);
        }
      }
    }
  }

  public static Proposition invertForallAroundGoal(Proposition forallprop, Proposition goal, Keyword headortail, boolean contrapositiveP) {
    { KeyValueMap mapping = KeyValueMap.newKeyValueMap();
      Proposition invertedforall = Proposition.copyProposition(forallprop, mapping);
      Stella_Object oldhead = (invertedforall.arguments.theArray)[1];
      Stella_Object oldtail = (invertedforall.arguments.theArray)[0];
      Proposition newgoal = ((Proposition)(mapping.lookup(goal)));
      Cons newgoalarguments = Proposition.extractGoalArguments(newgoal);
      Proposition headprime = null;
      Proposition tailprime = null;
      Proposition newhead = null;
      Proposition newtail = null;

      if (contrapositiveP) {
        oldhead = Proposition.invertProposition(((Proposition)(oldhead)));
        oldtail = Proposition.invertProposition(((Proposition)(oldtail)));
        newgoal = Proposition.extractInvertedGoal(((headortail == Logic.KWD_HEAD) ? ((Proposition)(oldhead)) : ((Proposition)(oldtail))), newgoal);
        if (newgoal == null) {
          {
            Stella.STANDARD_OUTPUT.nativeStream.println("Unable to generate contrapositive rule for goal `" + goal + "'");
            Stella.STANDARD_OUTPUT.nativeStream.println("in `" + forallprop + "'");
          }
;
          return (null);
        }
        (invertedforall.arguments.theArray)[0] = oldhead;
        (invertedforall.arguments.theArray)[1] = oldtail;
        oldhead = oldtail;
        oldtail = (invertedforall.arguments.theArray)[0];
        headortail = ((headortail == Logic.KWD_HEAD) ? Logic.KWD_TAIL : Logic.KWD_HEAD);
      }
      { boolean testValue000 = false;

        testValue000 = newgoal == (((headortail == Logic.KWD_HEAD) ? oldhead : oldtail));
        if (testValue000) {
          { boolean alwaysP000 = true;

            { Stella_Object arg = null;
              Cons iter000 = newgoalarguments;
              PatternVariable v = null;
              Vector vector000 = ((Vector)(KeyValueList.dynamicSlotValue(invertedforall.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
              int index000 = 0;
              int length000 = vector000.length();

              loop000 : for (;(!(iter000 == Stella.NIL)) &&
                        (index000 < length000); iter000 = iter000.rest, index000 = index000 + 1) {
                arg = iter000.value;
                v = ((PatternVariable)((vector000.theArray)[index000]));
                if (!(arg == v)) {
                  alwaysP000 = false;
                  break loop000;
                }
              }
            }
            testValue000 = alwaysP000;
          }
          if (testValue000) {
            testValue000 = newgoalarguments.length() == ((Vector)(KeyValueList.dynamicSlotValue(invertedforall.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null))).length();
          }
        }
        if (testValue000) {
          return (invertedforall);
        }
      }
      if (headortail == Logic.KWD_HEAD) {
        headprime = Proposition.substituteProposition(((Proposition)(oldhead)), newgoal, Logic.FALSE_PROPOSITION);
        Proposition.normalizeProposition(headprime);
        if (headprime.operator == Logic.SGT_STELLA_FALSE) {
          newtail = ((Proposition)(oldtail));
        }
        else {
          {
            oldtail = Proposition.invertProposition(((Proposition)(oldtail)));
            newtail = Logic.disjoinPropositions(Cons.consList(Cons.cons(oldtail, Cons.cons(headprime, Stella.NIL))));
            newtail = Proposition.invertProposition(newtail);
            Proposition.normalizeProposition(newtail);
          }
        }
        (invertedforall.arguments.theArray)[0] = newtail;
        (invertedforall.arguments.theArray)[1] = newgoal;
      }
      else if (headortail == Logic.KWD_TAIL) {
        tailprime = Proposition.substituteProposition(((Proposition)(oldtail)), newgoal, Logic.TRUE_PROPOSITION);
        Proposition.normalizeProposition(tailprime);
        if (tailprime.operator == Logic.SGT_STELLA_TRUE) {
          newhead = ((Proposition)(oldhead));
        }
        else {
          { Cons residuevariables = Stella.NIL;

            tailprime = Proposition.invertProposition(tailprime);
            newhead = Logic.disjoinPropositions(Cons.consList(Cons.cons(tailprime, Cons.cons(oldhead, Stella.NIL))));
            { PatternVariable vbl = null;
              Vector vector001 = ((Vector)(KeyValueList.dynamicSlotValue(invertedforall.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
              int index001 = 0;
              int length001 = vector001.length();
              Cons collect000 = null;

              for (;index001 < length001; index001 = index001 + 1) {
                vbl = ((PatternVariable)((vector001.theArray)[index001]));
                if (!newgoalarguments.memberP(vbl)) {
                  if (collect000 == null) {
                    {
                      collect000 = Cons.cons(vbl, Stella.NIL);
                      if (residuevariables == Stella.NIL) {
                        residuevariables = collect000;
                      }
                      else {
                        Cons.addConsToEndOfConsList(residuevariables, collect000);
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
            }
            if (!(residuevariables == Stella.NIL)) {
              { Proposition nestedforall = Logic.createProposition(Logic.SYM_STELLA_FORALL, 2);

                KeyValueList.setDynamicSlotValue(nestedforall.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, Logic.copyConsListToVariablesVector(residuevariables), null);
                (nestedforall.arguments.theArray)[0] = Logic.TRUE_PROPOSITION;
                (nestedforall.arguments.theArray)[1] = newhead;
                newhead = nestedforall;
              }
            }
            Proposition.normalizeProposition(newhead);
          }
        }
        (invertedforall.arguments.theArray)[0] = newgoal;
        (invertedforall.arguments.theArray)[1] = newhead;
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + headortail + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      { Cons newvariables = Proposition.extractGoalArguments(newgoal);

        { Stella_Object v = null;
          Cons iter001 = newvariables;
          int i = Stella.NULL_INTEGER;
          int iter002 = 0;

          for (;!(iter001 == Stella.NIL); iter001 = iter001.rest, iter002 = iter002 + 1) {
            v = iter001.value;
            i = iter002;
            if (!Stella_Object.isaP(v, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
              { PatternVariable constantvbl = Logic.createVariable(null, null, false);

                Skolem.updateSkolemType(constantvbl, Logic.logicalType(v));
                newvariables.nthSetter(constantvbl, i);
                if (headortail == Logic.KWD_HEAD) {
                  (invertedforall.arguments.theArray)[0] = (Proposition.conjoinTwoPropositions(Logic.createEquivalenceProposition(constantvbl, v), ((Proposition)((invertedforall.arguments.theArray)[0]))));
                }
                else if (headortail == Logic.KWD_TAIL) {
                  { Proposition negatedequivalence = Logic.createEquivalenceProposition(constantvbl, v);

                    Proposition.invertProposition(negatedequivalence);
                    (invertedforall.arguments.theArray)[1] = (Logic.disjoinPropositions(Cons.consList(Cons.cons(negatedequivalence, Cons.cons((invertedforall.arguments.theArray)[1], Stella.NIL)))));
                  }
                }
                else {
                  { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                    stream001.nativeStream.print("`" + headortail + "' is not a valid case option");
                    throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
                  }
                }
                Proposition.normalizeProposition(((Proposition)((invertedforall.arguments.theArray)[0])));
              }
            }
          }
        }
        KeyValueList.setDynamicSlotValue(invertedforall.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, Logic.copyConsListToVariablesVector(newvariables), null);
      }
      Proposition.recursivelyFastenDownPropositions(invertedforall, false);
      return (invertedforall);
    }
  }

  public static Proposition extractInvertedGoal(Proposition proposition, Proposition goal) {
    if (goal.kind == Logic.KWD_NOT) {
      return (Proposition.extractInvertedGoal(proposition, ((Proposition)((goal.arguments.theArray)[0]))));
    }
    { Keyword testValue000 = proposition.kind;

      if (testValue000 == Logic.KWD_NOT) {
        if (Proposition.equivalentPropositionsP(((Proposition)((proposition.arguments.theArray)[0])), goal, null)) {
          return (proposition);
        }
        else {
          return (Proposition.extractInvertedGoal(((Proposition)((proposition.arguments.theArray)[0])), goal));
        }
      }
      else if ((testValue000 == Logic.KWD_AND) ||
          (testValue000 == Logic.KWD_OR)) {
        { Proposition result = null;

          { Stella_Object arg = null;
            Vector vector000 = proposition.arguments;
            int index000 = 0;
            int length000 = vector000.length();

            for (;index000 < length000; index000 = index000 + 1) {
              arg = (vector000.theArray)[index000];
              result = Proposition.extractInvertedGoal(((Proposition)(arg)), goal);
              if (result != null) {
                return (result);
              }
            }
          }
        }
      }
      else {
        if (Proposition.equivalentPropositionsP(proposition, goal, null)) {
          return (proposition);
        }
      }
    }
    return (null);
  }

  public static Proposition substituteProposition(Proposition proposition, Proposition outprop, Proposition inprop) {
    if (proposition == outprop) {
      return (inprop);
    }
    { Stella_Object arg = null;
      Vector vector000 = proposition.arguments;
      int index000 = 0;
      int length000 = vector000.length();
      int i = Stella.NULL_INTEGER;
      int iter000 = 0;

      for (;index000 < length000; index000 = index000 + 1, iter000 = iter000 + 1) {
        arg = (vector000.theArray)[index000];
        i = iter000;
        if (arg == outprop) {
          (proposition.arguments.theArray)[i] = inprop;
        }
        else if (Stella_Object.isaP(arg, Logic.SGT_LOGIC_PROPOSITION)) {
          Proposition.substituteProposition(((Proposition)(arg)), outprop, inprop);
        }
      }
    }
    return (proposition);
  }

  public static Cons extractGoalArguments(Proposition goal) {
    { Vector arguments = goal.arguments;

      { Keyword testValue000 = goal.kind;

        if ((testValue000 == Logic.KWD_ISA) ||
            ((testValue000 == Logic.KWD_PREDICATE) ||
             ((testValue000 == Logic.KWD_FUNCTION) ||
              (testValue000 == Logic.KWD_IMPLIES)))) {
          { Cons result = Stella.NIL;

            { Stella_Object arg = null;
              Vector vector000 = arguments;
              int index000 = 0;
              int length000 = vector000.length();
              Cons collect000 = null;

              for (;index000 < length000; index000 = index000 + 1) {
                arg = (vector000.theArray)[index000];
                if (collect000 == null) {
                  {
                    collect000 = Cons.cons(arg, Stella.NIL);
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
                    collect000.rest = Cons.cons(arg, Stella.NIL);
                    collect000 = collect000.rest;
                  }
                }
              }
            }
            return (result);
          }
        }
        else if (testValue000 == Logic.KWD_NOT) {
          return (Proposition.extractGoalArguments(((Proposition)((arguments.theArray)[0]))));
        }
        else {
          return (Stella.NIL);
        }
      }
    }
  }

  public static Description extractGoalDescription(Proposition goal, Keyword headortail) {
    { Vector arguments = goal.arguments;

      { Keyword testValue000 = goal.kind;

        if ((testValue000 == Logic.KWD_ISA) ||
            ((testValue000 == Logic.KWD_PREDICATE) ||
             ((testValue000 == Logic.KWD_FUNCTION) ||
              (testValue000 == Logic.KWD_IMPLIES)))) {
          if (Stella_Object.isaP(goal.operator, Logic.SGT_STELLA_SURROGATE)) {
            { NamedDescription description = Logic.getDescription(((Surrogate)(goal.operator)));

              if (description == null) {
                { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                  { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      stream000.nativeStream.println("ERROR: Can't finalize relations because relation `" + ((Surrogate)(goal.operator)).symbolName + "' is undefined..");
                      Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

                    } finally {
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                    }
                  }
                  throw ((PropositionError)(PropositionError.newPropositionError(stream000.theStringReader()).fillInStackTrace()));
                }
              }
              if (NamedDescription.chainableRelationP(description, headortail)) {
                return (description);
              }
            }
          }
        }
        else if (testValue000 == Logic.KWD_NOT) {
          { Description argumentdescription = Proposition.extractGoalDescription(((Proposition)((arguments.theArray)[0])), headortail);

            if (argumentdescription != null) {
              return (NamedDescription.getComplementOfGoalDescription(((NamedDescription)(argumentdescription))));
            }
          }
        }
        else {
        }
      }
      return (null);
    }
  }

  public static boolean variableArityGoalPropositionP(Proposition proposition) {
    { Keyword testValue000 = proposition.kind;

      if ((testValue000 == Logic.KWD_PREDICATE) ||
          (testValue000 == Logic.KWD_FUNCTION)) {
        { Description description = Proposition.extractGoalDescription(proposition, null);

          return ((description != null) &&
              Description.variableArityP(description));
        }
      }
      else {
      }
    }
    return (false);
  }

  public static boolean atomicGoalPropositionP(Proposition proposition) {
    { Keyword testValue000 = proposition.kind;

      if ((testValue000 == Logic.KWD_ISA) ||
          ((testValue000 == Logic.KWD_PREDICATE) ||
           ((testValue000 == Logic.KWD_FUNCTION) ||
            (testValue000 == Logic.KWD_IMPLIES)))) {
        return (Proposition.extractGoalDescription(proposition, null) != null);
      }
      else if (testValue000 == Logic.KWD_NOT) {
        return (Proposition.extractGoalDescription(((Proposition)((proposition.arguments.theArray)[0])), null) != null);
      }
      else if (testValue000 == Logic.KWD_AND) {
        { int count = 0;

          { Proposition conjunct = null;
            Vector vector000 = ((Vector)(proposition.arguments));
            int index000 = 0;
            int length000 = vector000.length();

            for (;index000 < length000; index000 = index000 + 1) {
              conjunct = ((Proposition)((vector000.theArray)[index000]));
              if ((!(conjunct.kind == Logic.KWD_AND)) &&
                  Proposition.atomicGoalPropositionP(conjunct)) {
                count = count + 1;
              }
              else {
                return (false);
              }
            }
          }
          return (count == 1);
        }
      }
      else {
        return (false);
      }
    }
  }

  public static boolean atomicForallArgumentP(Proposition forallprop, Keyword headortail) {
    return (Proposition.atomicGoalPropositionP(((headortail == Logic.KWD_HEAD) ? ((Proposition)((forallprop.arguments.theArray)[1])) : ((Proposition)((forallprop.arguments.theArray)[0])))));
  }

  public static void collectMatchingRuleGoals(Proposition proposition, Cons toplevelvars, Keyword headortail, List collection) {
    { Keyword testValue000 = proposition.kind;

      if ((testValue000 == Logic.KWD_AND) ||
          (testValue000 == Logic.KWD_OR)) {
        if (headortail == Logic.KWD_HEAD) {
          { Stella_Object arg = null;
            Vector vector000 = proposition.arguments;
            int index000 = 0;
            int length000 = vector000.length();

            for (;index000 < length000; index000 = index000 + 1) {
              arg = (vector000.theArray)[index000];
              Proposition.collectMatchingRuleGoals(((Proposition)(arg)), toplevelvars, headortail, collection);
            }
          }
        }
        else if (headortail == Logic.KWD_TAIL) {
          { int goalcount = collection.length();

            { Stella_Object arg = null;
              Vector vector001 = proposition.arguments;
              int index001 = 0;
              int length001 = vector001.length();

              for (;index001 < length001; index001 = index001 + 1) {
                arg = (vector001.theArray)[index001];
                Proposition.collectMatchingRuleGoals(((Proposition)(arg)), toplevelvars, headortail, collection);
              }
            }
            if (goalcount == collection.length()) {
              { Stella_Object arg = null;
                Vector vector002 = proposition.arguments;
                int index002 = 0;
                int length002 = vector002.length();

                for (;index002 < length002; index002 = index002 + 1) {
                  arg = (vector002.theArray)[index002];
                  Proposition.collectMatchingRuleGoals(((Proposition)(arg)), toplevelvars, headortail, collection);
                }
              }
            }
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + headortail + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      else if (testValue000 == Logic.KWD_EXISTS) {
        if (headortail == Logic.KWD_HEAD) {
          Proposition.collectMatchingRuleGoals(((Proposition)((proposition.arguments.theArray)[0])), toplevelvars, headortail, collection);
        }
        else if (headortail == Logic.KWD_TAIL) {
          { PatternVariable v = null;
            Vector vector003 = ((Vector)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
            int index003 = 0;
            int length003 = vector003.length();

            for (;index003 < length003; index003 = index003 + 1) {
              v = ((PatternVariable)((vector003.theArray)[index003]));
              toplevelvars = Cons.cons(v, toplevelvars);
            }
          }
          Proposition.collectMatchingRuleGoals(((Proposition)((proposition.arguments.theArray)[0])), toplevelvars, headortail, collection);
        }
        else {
          { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

            stream001.nativeStream.print("`" + headortail + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
          }
        }
      }
      else if (testValue000 == Logic.KWD_FORALL) {
        if (headortail == Logic.KWD_HEAD) {
          { PatternVariable v = null;
            Vector vector004 = ((Vector)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
            int index004 = 0;
            int length004 = vector004.length();

            for (;index004 < length004; index004 = index004 + 1) {
              v = ((PatternVariable)((vector004.theArray)[index004]));
              toplevelvars = Cons.cons(v, toplevelvars);
            }
          }
          Proposition.collectMatchingRuleGoals(((Proposition)((proposition.arguments.theArray)[1])), toplevelvars, headortail, collection);
        }
        else if (headortail == Logic.KWD_TAIL) {
        }
        else {
          { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

            stream002.nativeStream.print("`" + headortail + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream002.theStringReader()).fillInStackTrace()));
          }
        }
      }
      else if ((testValue000 == Logic.KWD_ISA) ||
          ((testValue000 == Logic.KWD_PREDICATE) ||
           ((testValue000 == Logic.KWD_FUNCTION) ||
            ((testValue000 == Logic.KWD_NOT) ||
             (testValue000 == Logic.KWD_IMPLIES))))) {
        { boolean testValue001 = false;

          { boolean alwaysP000 = true;

            { Stella_Object a = null;
              Cons iter000 = Proposition.extractGoalArguments(proposition);

              loop005 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                a = iter000.value;
                if (!(toplevelvars.memberP(a) ||
                    (!Stella_Object.isaP(a, Logic.SGT_LOGIC_PATTERN_VARIABLE)))) {
                  alwaysP000 = false;
                  break loop005;
                }
              }
            }
            testValue001 = alwaysP000;
          }
          if (testValue001) {
            testValue001 = (Proposition.extractGoalDescription(proposition, headortail) != null) &&
                (!(proposition.operator == Logic.SGT_PL_KERNEL_KB_HOLDS));
          }
          if (testValue001) {
            collection.insert(proposition);
          }
        }
      }
      else {
      }
    }
  }

  public static List findMatchableGoals(Proposition forallprop, Keyword headortail) {
    { int index = ((headortail == Logic.KWD_HEAD) ? 1 : 0);
      Proposition proposition = ((Proposition)((forallprop.arguments.theArray)[index]));
      Cons variables = Stella.NIL;
      List resultlist = List.newList();

      { PatternVariable v = null;
        Vector vector000 = ((Vector)(KeyValueList.dynamicSlotValue(forallprop.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          v = ((PatternVariable)((vector000.theArray)[index000]));
          variables = Cons.cons(v, variables);
        }
      }
      if (variables.length() > 1) {
        if (headortail == Logic.KWD_TAIL) {
          { Keyword testValue000 = proposition.kind;

            if (testValue000 == Logic.KWD_AND) {
              { Stella_Object g = null;
                Vector vector001 = proposition.arguments;
                int index001 = 0;
                int length001 = vector001.length();

                for (;index001 < length001; index001 = index001 + 1) {
                  g = (vector001.theArray)[index001];
                  Proposition.collectMatchingRuleGoals(((Proposition)(g)), variables, Logic.KWD_TAIL, resultlist);
                }
              }
              return (resultlist);
            }
            else if (testValue000 == Logic.KWD_EXISTS) {
              { Proposition existsbody = ((Proposition)((proposition.arguments.theArray)[0]));

                if (existsbody.kind == Logic.KWD_AND) {
                  { Stella_Object g = null;
                    Vector vector002 = existsbody.arguments;
                    int index002 = 0;
                    int length002 = vector002.length();

                    for (;index002 < length002; index002 = index002 + 1) {
                      g = (vector002.theArray)[index002];
                      Proposition.collectMatchingRuleGoals(((Proposition)(g)), variables, Logic.KWD_TAIL, resultlist);
                    }
                  }
                }
              }
              return (resultlist);
            }
            else {
            }
          }
        }
        else {
        }
      }
      Proposition.collectMatchingRuleGoals(proposition, variables, headortail, resultlist);
      return (resultlist);
    }
  }

  public static Proposition safelyInvertProposition(Proposition self) {
    { Proposition copy = Proposition.shallowCopyProposition(self);

      Proposition.invertProposition(copy);
      return (copy);
    }
  }

  public static Proposition invertProposition(Proposition self) {
    { Keyword testValue000 = self.kind;

      if ((testValue000 == Logic.KWD_ISA) ||
          ((testValue000 == Logic.KWD_PREDICATE) ||
           ((testValue000 == Logic.KWD_FUNCTION) ||
            (testValue000 == Logic.KWD_EQUIVALENT)))) {
        Proposition.invertAtomicProposition(self);
      }
      else if (testValue000 == Logic.KWD_AND) {
        { int argumentcount = self.arguments.length();

          Proposition.simplifyProposition(self);
          if (self.arguments.length() < argumentcount) {
            return (Proposition.invertProposition(self));
          }
        }
        self.kind = Logic.KWD_OR;
        self.operator = Logic.SGT_LOGIC_OR;
        { int i = Stella.NULL_INTEGER;
          int iter000 = 0;
          int upperBound000 = self.arguments.length() - 1;

          for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
            i = iter000;
            (self.arguments.theArray)[i] = (Proposition.safelyInvertProposition(((Proposition)((self.arguments.theArray)[i]))));
          }
        }
      }
      else if (testValue000 == Logic.KWD_OR) {
        self.kind = Logic.KWD_AND;
        self.operator = Logic.SGT_LOGIC_AND;
        { int i = Stella.NULL_INTEGER;
          int iter001 = 0;
          int upperBound001 = self.arguments.length() - 1;

          for (;iter001 <= upperBound001; iter001 = iter001 + 1) {
            i = iter001;
            (self.arguments.theArray)[i] = (Proposition.safelyInvertProposition(((Proposition)((self.arguments.theArray)[i]))));
          }
        }
      }
      else if (testValue000 == Logic.KWD_NOT) {
        Proposition.overlayProposition(self, ((Proposition)((self.arguments.theArray)[0])));
        Proposition.normalizeProposition(self);
      }
      else if (testValue000 == Logic.KWD_EXISTS) {
        if (Proposition.functionInducedExistsP(self)) {
          Proposition.embedNegationWithinFunctionInducedExists(self);
        }
        else {
          Proposition.invertExistsProposition(self);
        }
      }
      else if (testValue000 == Logic.KWD_FORALL) {
        Proposition.invertForallProposition(self);
      }
      else if (testValue000 == Logic.KWD_IMPLIES) {
        Proposition.invertImpliesProposition(self);
      }
      else if (testValue000 == Logic.KWD_CONSTANT) {
        { GeneralizedSymbol testValue001 = self.operator;

          if (testValue001 == Logic.SGT_STELLA_TRUE) {
            return (Logic.FALSE_PROPOSITION);
          }
          else if (testValue001 == Logic.SGT_STELLA_FALSE) {
            return (Logic.TRUE_PROPOSITION);
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + testValue001 + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }
      }
      else if (testValue000 == Logic.KWD_FAIL) {
        Proposition.invertAtomicProposition(self);
      }
      else {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("`" + testValue000 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
    }
    return (self);
  }

  public static void invertImpliesProposition(Proposition self) {
    { Vector arguments = self.arguments;
      Stella_Object arg1Value = (Stella_Object.surrogateP((arguments.theArray)[0]) ? Logic.getDescription(((Surrogate)((arguments.theArray)[0]))) : (arguments.theArray)[0]);
      Stella_Object arg2Value = (Stella_Object.surrogateP((arguments.theArray)[1]) ? Logic.getDescription(((Surrogate)((arguments.theArray)[1]))) : (arguments.theArray)[1]);

      if (!(Stella_Object.isaP(arg1Value, Logic.SGT_LOGIC_DESCRIPTION) &&
          Stella_Object.isaP(arg2Value, Logic.SGT_LOGIC_DESCRIPTION))) {
        Proposition.invertAtomicProposition(self);
        return;
      }
      { Description subset = ((Description)(arg1Value));
        Description superset = ((Description)(arg2Value));
        Proposition subsetprop = null;
        Proposition supersetprop = null;
        KeyValueMap mapping = KeyValueMap.newKeyValueMap();
        Vector newarguments = Vector.newVector(1);

        self.kind = Logic.KWD_EXISTS;
        self.operator = Logic.SGT_LOGIC_EXISTS;
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, Logic.copyVariablesVector(subset.ioVariables, mapping), null);
        { PatternVariable iovar = null;
          Vector vector000 = ((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
          int index000 = 0;
          int length000 = vector000.length();
          PatternVariable supvar = null;
          Vector vector001 = superset.ioVariables;
          int index001 = 0;
          int length001 = vector001.length();

          for (;(index000 < length000) &&
                    (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
            iovar = ((PatternVariable)((vector000.theArray)[index000]));
            supvar = ((PatternVariable)((vector001.theArray)[index001]));
            mapping.insertAt(supvar, iovar);
          }
        }
        subsetprop = Description.extractProposition(subset, mapping);
        supersetprop = Description.extractProposition(superset, mapping);
        KeyValueList.setDynamicSlotValue(supersetprop.dynamicSlots, Logic.SYM_LOGIC_VARIABLE_TYPEp, null, null);
        Proposition.invertProposition(supersetprop);
        (newarguments.theArray)[0] = (Proposition.conjoinTwoPropositions(subsetprop, supersetprop));
        self.arguments = newarguments;
        Proposition.normalizeProposition(self);
      }
    }
  }

  public static void invertForallProposition(Proposition self) {
    { Proposition antecedent = ((Proposition)((self.arguments.theArray)[0]));
      Proposition consequent = ((Proposition)((self.arguments.theArray)[1]));
      Vector newarguments = Vector.newVector(1);

      self.arguments.free();
      Proposition.normalizeProposition(antecedent);
      Proposition.normalizeProposition(consequent);
      consequent = Proposition.safelyInvertProposition(consequent);
      self.kind = Logic.KWD_EXISTS;
      self.operator = Logic.SGT_LOGIC_EXISTS;
      (newarguments.theArray)[0] = (Proposition.conjoinTwoPropositions(antecedent, consequent));
      self.arguments = newarguments;
      Proposition.normalizeProposition(self);
    }
  }

  public static void invertExistsProposition(Proposition self) {
    { Proposition whereproposition = ((Proposition)((self.arguments.theArray)[0]));
      Vector newarguments = Vector.newVector(2);

      self.arguments.free();
      Proposition.normalizeProposition(whereproposition);
      whereproposition = Proposition.safelyInvertProposition(whereproposition);
      self.kind = Logic.KWD_FORALL;
      self.operator = Logic.SGT_LOGIC_FORALL;
      (newarguments.theArray)[0] = Logic.TRUE_PROPOSITION;
      (newarguments.theArray)[1] = whereproposition;
      self.arguments = newarguments;
      Proposition.normalizeProposition(self);
    }
  }

  public static void invertAtomicProposition(Proposition self) {
    { Proposition newatomicproposition = Logic.createProposition(Logic.SYM_STELLA_NOT, 1);
      Vector newnotarguments = newatomicproposition.arguments;
      Proposition newnotproposition = self;

      (newnotarguments.theArray)[0] = newatomicproposition;
      newatomicproposition.kind = self.kind;
      newatomicproposition.operator = self.operator;
      newatomicproposition.arguments = self.arguments;
      if (BooleanWrapper.coerceWrappedBooleanToBoolean(self.variableTypeP())) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_VARIABLE_TYPEp, null, null);
        KeyValueList.setDynamicSlotValue(newatomicproposition.dynamicSlots, Logic.SYM_LOGIC_VARIABLE_TYPEp, Stella.TRUE_WRAPPER, null);
      }
      if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.FALSE_WRAPPER))).wrapperValue) {
        KeyValueList.setDynamicSlotValue(newatomicproposition.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
      }
      newnotproposition.kind = Logic.KWD_NOT;
      newnotproposition.operator = Logic.SGT_LOGIC_NOT;
      newnotproposition.arguments = newnotarguments;
    }
  }

  public static void normalizeDescriptiveProposition(Proposition self, Vector iovariables, Keyword kind) {
    { Object old$Evaluationmode$000 = Logic.$EVALUATIONMODE$.get();

      try {
        Native.setSpecial(Logic.$EVALUATIONMODE$, Logic.KWD_DESCRIPTION);
        try {
          Proposition.equateTopLevelEquivalences(self, iovariables, kind);
        } catch (Clash e) {
          Stella.STANDARD_ERROR.nativeStream.println(Stella.exceptionMessage(e));
        }
        Proposition.tightenArgumentBindings(self, iovariables);
        Proposition.simplifyProposition(self);
        Logic.collapseValueOfChainsForIoVariables(iovariables);

      } finally {
        Logic.$EVALUATIONMODE$.set(old$Evaluationmode$000);
      }
    }
  }

  public static void normalizeTopLevelProposition(Proposition self) {
    Proposition.normalizeProposition(self);
    if (self.kind == Logic.KWD_FORALL) {
      { Vector iovars = ((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
        Vector args = self.arguments;

        Proposition.normalizeDescriptiveProposition(((Proposition)((args.theArray)[0])), iovars, Logic.KWD_TAIL);
        Proposition.normalizeDescriptiveProposition(((Proposition)((args.theArray)[1])), iovars, Logic.KWD_HEAD);
      }
    }
  }

  public static void normalizeProposition(Proposition self) {
    if (!BooleanWrapper.coerceWrappedBooleanToBoolean(self.unfastenedP())) {
      return;
    }
    if (Proposition.containsNestedArgumentP(self)) {
      { Proposition proposition = Proposition.shallowCopyProposition(self);

        proposition = Proposition.flattenNestedFunctionArguments(proposition);
        Proposition.overlayProposition(self, proposition);
      }
    }
    { Keyword testValue000 = self.kind;

      if (testValue000 == Logic.KWD_AND) {
        Proposition.normalizeAndProposition(self);
      }
      else if (testValue000 == Logic.KWD_OR) {
        Proposition.normalizeOrProposition(self);
      }
      else if (testValue000 == Logic.KWD_NOT) {
        Proposition.normalizeNotProposition(self);
      }
      else if ((testValue000 == Logic.KWD_ISA) ||
          (testValue000 == Logic.KWD_PREDICATE)) {
        Proposition.normalizePredicateProposition(self);
      }
      else if (testValue000 == Logic.KWD_FUNCTION) {
        Proposition.normalizeFunctionProposition(self);
      }
      else if (testValue000 == Logic.KWD_EXISTS) {
        Proposition.normalizeExistsProposition(self);
      }
      else if (testValue000 == Logic.KWD_FORALL) {
        Proposition.normalizeForallProposition(self);
      }
      else if (testValue000 == Logic.KWD_EQUIVALENT) {
        Proposition.normalizeEquivalentProposition(self);
      }
      else if ((testValue000 == Logic.KWD_IMPLIES) ||
          ((testValue000 == Logic.KWD_FAIL) ||
           ((testValue000 == Logic.KWD_COLLECT_INTO) ||
            (testValue000 == Logic.KWD_CONSTANT)))) {
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static Proposition shallowCopyProposition(Proposition self) {
    { Proposition copy = Logic.createProposition(Logic.SYM_STELLA_AND, 0);

      if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.FALSE_WRAPPER))).wrapperValue) {
        KeyValueList.setDynamicSlotValue(copy.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
      }
      if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DONT_OPTIMIZEp, Stella.FALSE_WRAPPER))).wrapperValue) {
        KeyValueList.setDynamicSlotValue(copy.dynamicSlots, Logic.SYM_LOGIC_DONT_OPTIMIZEp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
      }
      Proposition.overlayProposition(copy, self);
      return (copy);
    }
  }

  public static void normalizeEquivalentProposition(Proposition self) {
    { Stella_Object firstarg = (self.arguments.theArray)[0];
      Stella_Object secondarg = (self.arguments.theArray)[1];

      if (Stella_Object.eqlP(firstarg, secondarg)) {
        Proposition.overlayWithConstantProposition(self, Logic.TRUE_PROPOSITION);
      }
      else if (Logic.skolemP(firstarg) ||
          (Logic.skolemP(secondarg) ||
           (Logic.collectionP(firstarg) ||
            Logic.collectionP(secondarg)))) {
      }
      else {
        Proposition.overlayWithConstantProposition(self, Logic.FALSE_PROPOSITION);
      }
    }
  }

  public static Proposition normalizeValueFunction(Proposition self) {
    { Surrogate functionsurrogate = Logic.evaluateRelationTerm((self.arguments.theArray)[0], self);
      int newargumentcount = self.arguments.length() - 1;
      Proposition newproposition = null;
      Proposition duplicate = null;

      if (functionsurrogate == null) {
        return (self);
      }
      newproposition = Logic.createProposition(Logic.SYM_STELLA_FUNCTION, newargumentcount);
      newproposition.operator = functionsurrogate;
      { int i = Stella.NULL_INTEGER;
        int iter000 = 1;
        int upperBound000 = newargumentcount;
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

        for (;unboundedP000 ||
                  (iter000 <= upperBound000); iter000 = iter000 + 1) {
          i = iter000;
          (newproposition.arguments.theArray)[(i - 1)] = ((self.arguments.theArray)[i]);
        }
      }
      if (Logic.skolemP((self.arguments.theArray)[(self.arguments.length() - 1)])) {
        ((Skolem)((self.arguments.theArray)[(self.arguments.length() - 1)])).definingProposition = newproposition;
      }
      if (!(Logic.descriptionModeP())) {
        duplicate = Proposition.findDuplicateFunctionProposition(newproposition);
        if (duplicate != null) {
          newproposition = duplicate;
        }
      }
      return (newproposition);
    }
  }

  public static void normalizeFunctionProposition(Proposition self) {
    { Stella_Object clause = null;
      Vector vector000 = self.arguments;
      int index000 = 0;
      int length000 = vector000.length();

      for (;index000 < length000; index000 = index000 + 1) {
        clause = (vector000.theArray)[index000];
        if (Stella_Object.isaP(clause, Logic.SGT_LOGIC_PROPOSITION)) {
          Proposition.normalizeProposition(((Proposition)(clause)));
        }
      }
    }
  }

  public static void normalizePredicateProposition(Proposition self) {
    if (self.operator == Logic.SGT_PL_KERNEL_KB_HOLDS) {
      Proposition.normalizeHoldsProposition(self);
      if (!(self.operator == Logic.SGT_PL_KERNEL_KB_HOLDS)) {
        return;
      }
    }
    if (self.operator == Logic.SGT_STELLA_THING) {
      Proposition.overlayProposition(self, Logic.TRUE_PROPOSITION);
      return;
    }
    { Stella_Object clause = null;
      Vector vector000 = self.arguments;
      int index000 = 0;
      int length000 = vector000.length();

      for (;index000 < length000; index000 = index000 + 1) {
        clause = (vector000.theArray)[index000];
        if (Stella_Object.isaP(clause, Logic.SGT_LOGIC_PROPOSITION)) {
          Proposition.normalizeProposition(((Proposition)(clause)));
        }
      }
    }
  }

  public static void normalizeHoldsProposition(Proposition self) {
    { Vector holdsarguments = self.arguments;
      Stella_Object relationterm = (holdsarguments.theArray)[0];
      int nofarguments = holdsarguments.length() - 1;
      Surrogate surrogate = Logic.evaluateRelationTerm(relationterm, self);
      Vector predicatearguments = Vector.newVector(nofarguments);
      Description description = null;

      if ((surrogate == null) &&
          ((!Stella_Object.isaP(relationterm, Logic.SGT_LOGIC_DESCRIPTION)) ||
           (!Logic.argumentBoundP(relationterm)))) {
        return;
      }
      { int i = Stella.NULL_INTEGER;
        int iter000 = 1;
        int upperBound000 = nofarguments;
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

        for (;unboundedP000 ||
                  (iter000 <= upperBound000); iter000 = iter000 + 1) {
          i = iter000;
          (predicatearguments.theArray)[(i - 1)] = ((holdsarguments.theArray)[i]);
        }
      }
      if (surrogate != null) {
        description = ((Description)(Logic.evaluatePredicate(surrogate, (holdsarguments.theArray)[1])));
        if (description == null) {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                stream000.nativeStream.println("ERROR: Relation argument `" + surrogate.symbolName + "' in HOLDS proposition is not defined as a relation: `" + self + "'.");
                Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
              }
            }
            throw ((PropositionError)(PropositionError.newPropositionError(stream000.theStringReader()).fillInStackTrace()));
          }
        }
        if (Logic.classP(description)) {
          self.kind = Logic.KWD_ISA;
        }
        else if (Logic.functionP(description)) {
          Proposition.helpNormalizePredicateProposition(self, description.surrogateValueInverse, predicatearguments);
          return;
        }
        self.operator = description.surrogateValueInverse;
        self.arguments = predicatearguments;
        Proposition.normalizeProposition(self);
        return;
      }
      else {
        description = ((Description)(relationterm));
        if (!(description.arity() == nofarguments)) {
          { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

            { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                stream001.nativeStream.println("ERROR: Arity violation in HOLDS proposition: `" + self + "'.");
                Logic.helpSignalPropositionError(stream001, Logic.KWD_ERROR);

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
              }
            }
            throw ((PropositionError)(PropositionError.newPropositionError(stream001.theStringReader()).fillInStackTrace()));
          }
        }
        Proposition.overlayProposition(self, Logic.conjoinPropositions(Logic.inheritDescriptionPropositions(predicatearguments, description, new Object[1])));
        Proposition.normalizeProposition(self);
      }
    }
  }

  public static void helpNormalizePredicateProposition(Proposition self, Surrogate relationref, Vector predicatearguments) {
    { Stella_Object outputargument = predicatearguments.last();
      Cons inputarguments = Stella.NIL;
      Proposition functionprop = null;
      Proposition equivalenceprop = null;

      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = predicatearguments.length() - 2;
        Cons collect000 = null;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          if (collect000 == null) {
            {
              collect000 = Cons.cons((predicatearguments.theArray)[i], Stella.NIL);
              if (inputarguments == Stella.NIL) {
                inputarguments = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(inputarguments, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons((predicatearguments.theArray)[i], Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      functionprop = Logic.findOrCreateFunctionProposition(relationref, inputarguments);
      equivalenceprop = Logic.createEquivalenceProposition(functionprop.arguments.last(), outputargument);
      Proposition.overlayProposition(self, equivalenceprop);
      Proposition.normalizeProposition(self);
    }
  }

  public static void normalizeOrProposition(Proposition self) {
    { Cons propositions = Stella.NIL;
      boolean disjoinP = false;

      { Stella_Object arg = null;
        Vector vector000 = self.arguments;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          if (Logic.variableP(arg)) {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  stream000.nativeStream.println("ERROR: Can't yet handle propositional variables within disjunctions.");
                  Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                }
              }
              throw ((PropositionError)(PropositionError.newPropositionError(stream000.theStringReader()).fillInStackTrace()));
            }
          }
          { Proposition disjunct = ((Proposition)(arg));

            Proposition.normalizeProposition(disjunct);
            { Keyword testValue000 = disjunct.kind;

              if (testValue000 == Logic.KWD_OR) {
                propositions = Cons.cons(disjunct, propositions);
                disjoinP = true;
              }
              else if (testValue000 == Logic.KWD_CONSTANT) {
                if (disjunct.operator == Logic.SGT_STELLA_FALSE) {
                  disjoinP = true;
                }
                else if (disjunct.operator == Logic.SGT_STELLA_TRUE) {
                  Proposition.overlayWithConstantProposition(self, Logic.TRUE_PROPOSITION);
                  return;
                }
                else {
                  if (propositions.memberP(disjunct)) {
                    disjoinP = true;
                  }
                  else {
                    propositions = Cons.cons(disjunct, propositions);
                  }
                }
              }
              else {
                { boolean testValue001 = false;

                  testValue001 = !disjoinP;
                  if (testValue001) {
                    { boolean foundP000 = false;

                      { Stella_Object prop = null;
                        Cons iter000 = propositions;

                        loop001 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                          prop = iter000.value;
                          if (Proposition.duplicateAndOrArgumentsP(((Proposition)(prop)), disjunct)) {
                            foundP000 = true;
                            break loop001;
                          }
                        }
                      }
                      testValue001 = foundP000;
                    }
                  }
                  if (testValue001) {
                    disjoinP = true;
                  }
                  else {
                    propositions = Cons.cons(disjunct, propositions);
                  }
                }
              }
            }
          }
        }
      }
      if (disjoinP ||
          (propositions.length() <= 1)) {
        Proposition.overlayProposition(self, Logic.disjoinPropositions(propositions));
      }
    }
  }

  public static void normalizeAndProposition(Proposition self) {
    { Cons otherprops = Stella.NIL;
      boolean conjoinP = false;
      Cons existsvariables = Stella.NIL;

      { Stella_Object arg = null;
        Vector vector000 = self.arguments;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          if (Logic.variableP(arg)) {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  stream000.nativeStream.println("ERROR: Can't yet handle propositional variables within conjunctions.");
                  Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                }
              }
              throw ((PropositionError)(PropositionError.newPropositionError(stream000.theStringReader()).fillInStackTrace()));
            }
          }
          { Proposition conjunct = ((Proposition)(arg));

            Proposition.normalizeProposition(conjunct);
            { Keyword testValue000 = conjunct.kind;

              if (testValue000 == Logic.KWD_EXISTS) {
                { PatternVariable v = null;
                  Vector vector001 = ((Vector)(KeyValueList.dynamicSlotValue(conjunct.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
                  int index001 = 0;
                  int length001 = vector001.length();
                  Cons collect000 = null;

                  for (;index001 < length001; index001 = index001 + 1) {
                    v = ((PatternVariable)((vector001.theArray)[index001]));
                    { boolean foundP000 = false;

                      { PatternVariable var = null;
                        Cons iter000 = existsvariables;

                        loop002 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                          var = ((PatternVariable)(iter000.value));
                          if (Symbol.variableEqlP(var.skolemName, v.skolemName)) {
                            foundP000 = true;
                            break loop002;
                          }
                        }
                      }
                      if (foundP000) {
                        PatternVariable.renameLogicVariableApart(v, true);
                      }
                    }
                    if (collect000 == null) {
                      {
                        collect000 = Cons.cons(v, Stella.NIL);
                        if (existsvariables == Stella.NIL) {
                          existsvariables = collect000;
                        }
                        else {
                          Cons.addConsToEndOfConsList(existsvariables, collect000);
                        }
                      }
                    }
                    else {
                      {
                        collect000.rest = Cons.cons(v, Stella.NIL);
                        collect000 = collect000.rest;
                      }
                    }
                  }
                }
                otherprops = Cons.cons((conjunct.arguments.theArray)[0], otherprops);
                conjoinP = true;
              }
              else if (testValue000 == Logic.KWD_AND) {
                otherprops = Cons.cons(conjunct, otherprops);
                conjoinP = true;
              }
              else if (testValue000 == Logic.KWD_CONSTANT) {
                if (conjunct.operator == Logic.SGT_STELLA_TRUE) {
                  conjoinP = true;
                  otherprops = Cons.cons(conjunct, otherprops);
                }
                else if (conjunct.operator == Logic.SGT_STELLA_FALSE) {
                  Proposition.overlayWithConstantProposition(self, Logic.FALSE_PROPOSITION);
                  return;
                }
              }
              else {
                { boolean testValue001 = false;

                  testValue001 = !conjoinP;
                  if (testValue001) {
                    { boolean foundP001 = false;

                      { Stella_Object prop = null;
                        Cons iter001 = otherprops;

                        loop003 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                          prop = iter001.value;
                          if (Proposition.duplicateAndOrArgumentsP(((Proposition)(prop)), conjunct)) {
                            foundP001 = true;
                            break loop003;
                          }
                        }
                      }
                      testValue001 = foundP001;
                    }
                  }
                  if (testValue001) {
                    conjoinP = true;
                  }
                  else {
                    otherprops = Cons.cons(conjunct, otherprops);
                  }
                }
              }
            }
          }
        }
      }
      otherprops = otherprops.reverse();
      if (!(existsvariables == Stella.NIL)) {
        { Proposition existsproposition = Logic.createProposition(Logic.SYM_STELLA_EXISTS, 1);

          KeyValueList.setDynamicSlotValue(existsproposition.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, Logic.copyConsListToVariablesVector(existsvariables), null);
          (existsproposition.arguments.theArray)[0] = (Logic.conjoinPropositions(otherprops));
          Proposition.overlayProposition(self, existsproposition);
        }
        return;
      }
      if (conjoinP ||
          (otherprops.length() <= 1)) {
        Proposition.overlayProposition(self, Logic.conjoinPropositions(otherprops));
      }
    }
  }

  public static void normalizeNotProposition(Proposition self) {
    { Stella_Object argument = (self.arguments.theArray)[0];
      Proposition proposition = null;

      if (Logic.variableP(argument)) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              stream000.nativeStream.println("ERROR: Can't yet handle propositional variables within negations.");
              Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
          throw ((PropositionError)(PropositionError.newPropositionError(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      proposition = ((Proposition)(argument));
      if (proposition.kind == Logic.KWD_EQUIVALENT) {
        Proposition.normalizeProposition(proposition);
      }
      { Keyword testValue000 = proposition.kind;

        if ((testValue000 == Logic.KWD_ISA) ||
            ((testValue000 == Logic.KWD_PREDICATE) ||
             (testValue000 == Logic.KWD_FUNCTION))) {
          if (BooleanWrapper.coerceWrappedBooleanToBoolean(proposition.variableTypeP())) {
            Proposition.overlayWithConstantProposition(self, Logic.FALSE_PROPOSITION);
          }
          else {
            Proposition.normalizeProposition(proposition);
          }
        }
        else if (testValue000 == Logic.KWD_CONSTANT) {
          { GeneralizedSymbol testValue001 = proposition.operator;

            if (testValue001 == Logic.SGT_STELLA_TRUE) {
              Proposition.overlayWithConstantProposition(self, Logic.FALSE_PROPOSITION);
            }
            else if (testValue001 == Logic.SGT_STELLA_FALSE) {
              Proposition.overlayWithConstantProposition(self, Logic.TRUE_PROPOSITION);
            }
            else {
            }
          }
        }
        else {
          Proposition.invertProposition(proposition);
          Proposition.overlayProposition(self, proposition);
        }
      }
    }
  }

  public static void normalizeForallProposition(Proposition self) {
    { Stella_Object antarg = (self.arguments.theArray)[0];
      Stella_Object cqarg = (self.arguments.theArray)[1];
      Proposition antecedent = null;
      Proposition consequent = null;

      if (Logic.variableP(antarg) ||
          Logic.variableP(cqarg)) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              stream000.nativeStream.println("ERROR: Can't yet handle propositional variables within FORALL.");
              Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
          throw ((PropositionError)(PropositionError.newPropositionError(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      antecedent = ((Proposition)(antarg));
      consequent = ((Proposition)(cqarg));
      { Object old$Evaluationmode$000 = Logic.$EVALUATIONMODE$.get();

        try {
          Native.setSpecial(Logic.$EVALUATIONMODE$, Logic.KWD_DESCRIPTION);
          Proposition.normalizeProposition(antecedent);
          Proposition.normalizeProposition(consequent);

        } finally {
          Logic.$EVALUATIONMODE$.set(old$Evaluationmode$000);
        }
      }
      if (antecedent.kind == Logic.KWD_CONSTANT) {
        { GeneralizedSymbol testValue000 = antecedent.operator;

          if (testValue000 == Logic.SGT_STELLA_TRUE) {
            if (Proposition.migrateConsequentGoalsToAntecedentP(self)) {
              return;
            }
          }
          else if (testValue000 == Logic.SGT_STELLA_FALSE) {
            Proposition.overlayWithConstantProposition(self, Logic.TRUE_PROPOSITION);
            return;
          }
          else {
            { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

              stream001.nativeStream.print("`" + testValue000 + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
            }
          }
        }
      }
      { Keyword testValue001 = consequent.kind;

        if (testValue001 == Logic.KWD_FORALL) {
          if (!Logic.naturalDeductionModeP()) {
            Proposition.flattenNestedForallProposition(self);
          }
        }
        else if (testValue001 == Logic.KWD_CONSTANT) {
          { GeneralizedSymbol testValue002 = consequent.operator;

            if (testValue002 == Logic.SGT_STELLA_FALSE) {
              Proposition.overlayProposition(self, antecedent);
              Proposition.invertProposition(self);
              return;
            }
            else if (testValue002 == Logic.SGT_STELLA_TRUE) {
              Proposition.overlayWithConstantProposition(self, Logic.TRUE_PROPOSITION);
              return;
            }
            else {
              { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                stream002.nativeStream.print("`" + testValue002 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream002.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
        else {
        }
      }
      if (((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null))).emptyP()) {
        antecedent = Proposition.invertProposition(antecedent);
        Proposition.overlayProposition(self, Logic.disjoinPropositions(Cons.consList(Cons.cons(antecedent, Cons.cons(consequent, Stella.NIL)))));
        Proposition.normalizeProposition(self);
        return;
      }
      { Proposition impliesproposition = Proposition.deriveImpliesFromForall(self);

        if (impliesproposition != null) {
          Proposition.overlayProposition(self, impliesproposition);
        }
      }
    }
  }

  public static void flattenNestedForallProposition(Proposition self) {
    { Cons iovariables = Stella.NIL;
      Stella_Object outerantecedent = (self.arguments.theArray)[0];
      Proposition nestedforall = ((Proposition)((self.arguments.theArray)[1]));
      Stella_Object innerantecedent = (nestedforall.arguments.theArray)[0];
      Stella_Object innerconsequent = (nestedforall.arguments.theArray)[1];

      { PatternVariable v = null;
        Vector vector000 = ((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          v = ((PatternVariable)((vector000.theArray)[index000]));
          iovariables = Cons.cons(v, iovariables);
        }
      }
      { PatternVariable v = null;
        Vector vector001 = ((Vector)(KeyValueList.dynamicSlotValue(nestedforall.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
        int index001 = 0;
        int length001 = vector001.length();

        for (;index001 < length001; index001 = index001 + 1) {
          v = ((PatternVariable)((vector001.theArray)[index001]));
          iovariables = Cons.cons(v, iovariables);
        }
      }
      KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, Logic.copyConsListToVariablesVector(iovariables.reverse()), null);
      (self.arguments.theArray)[0] = (Proposition.conjoinTwoPropositions(((Proposition)(outerantecedent)), ((Proposition)(innerantecedent))));
      (self.arguments.theArray)[1] = innerconsequent;
      Proposition.normalizeProposition(((Proposition)((self.arguments.theArray)[0])));
    }
  }

  public static boolean migrateConsequentGoalsToAntecedentP(Proposition self) {
    { Proposition antecedent = null;
      Proposition consequent = ((Proposition)((self.arguments.theArray)[1]));
      Cons positivegoals = Stella.NIL;
      Cons negatedgoals = Stella.NIL;

      if (!(consequent.kind == Logic.KWD_OR)) {
        return (false);
      }
      { Stella_Object arg = null;
        Vector vector000 = consequent.arguments;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          { Proposition disjunct = ((Proposition)(arg));

            if (disjunct.kind == Logic.KWD_NOT) {
              negatedgoals = Cons.cons((disjunct.arguments.theArray)[0], negatedgoals);
            }
            else {
              positivegoals = Cons.cons(disjunct, positivegoals);
            }
          }
        }
      }
      if ((!(positivegoals == Stella.NIL)) &&
          (!(negatedgoals == Stella.NIL))) {
        antecedent = Logic.conjoinPropositions(negatedgoals.reverse());
        consequent = Logic.disjoinPropositions(positivegoals.reverse());
        Proposition.normalizeProposition(antecedent);
        Proposition.normalizeProposition(consequent);
        (self.arguments.theArray)[0] = antecedent;
        (self.arguments.theArray)[1] = consequent;
        return (true);
      }
      return (false);
    }
  }

  public static void normalizeExistsProposition(Proposition self) {
    { Proposition whereproposition = ((Proposition)((self.arguments.theArray)[0]));

      { Object old$Evaluationmode$000 = Logic.$EVALUATIONMODE$.get();

        try {
          Native.setSpecial(Logic.$EVALUATIONMODE$, Logic.KWD_DESCRIPTION);
          Proposition.normalizeProposition(whereproposition);

        } finally {
          Logic.$EVALUATIONMODE$.set(old$Evaluationmode$000);
        }
      }
      if (whereproposition.kind == Logic.KWD_EXISTS) {
        { Cons combinedargs = Stella.NIL;

          { PatternVariable vbl = null;
            Vector vector000 = ((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
            int index000 = 0;
            int length000 = vector000.length();
            Cons collect000 = null;

            for (;index000 < length000; index000 = index000 + 1) {
              vbl = ((PatternVariable)((vector000.theArray)[index000]));
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(vbl, Stella.NIL);
                  if (combinedargs == Stella.NIL) {
                    combinedargs = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(combinedargs, collect000);
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
          { PatternVariable vbl = null;
            Vector vector001 = ((Vector)(KeyValueList.dynamicSlotValue(whereproposition.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
            int index001 = 0;
            int length001 = vector001.length();
            Cons collect001 = null;

            for (;index001 < length001; index001 = index001 + 1) {
              vbl = ((PatternVariable)((vector001.theArray)[index001]));
              if (collect001 == null) {
                {
                  collect001 = Cons.cons(vbl, Stella.NIL);
                  if (combinedargs == Stella.NIL) {
                    combinedargs = collect001;
                  }
                  else {
                    Cons.addConsToEndOfConsList(combinedargs, collect001);
                  }
                }
              }
              else {
                {
                  collect001.rest = Cons.cons(vbl, Stella.NIL);
                  collect001 = collect001.rest;
                }
              }
            }
          }
          KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, Logic.copyConsListToVariablesVector(combinedargs), null);
          self.arguments = whereproposition.arguments;
          whereproposition.deletedPSetter(true);
        }
      }
      if (((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null))).emptyP() ||
          (whereproposition.kind == Logic.KWD_CONSTANT)) {
        Proposition.overlayProposition(self, whereproposition);
      }
    }
  }

  public static void overlayProposition(Proposition self, Proposition overlayingprop) {
    self.kind = overlayingprop.kind;
    self.operator = overlayingprop.operator;
    { Proposition object000 = self;
      TruthValue value000 = ((TruthValue)(Stella_Object.accessInContext(overlayingprop.truthValue, overlayingprop.homeContext, false)));
      Stella_Object oldValue001 = object000.truthValue;
      Stella_Object newValue000 = Stella_Object.updateInContext(oldValue001, value000, object000.homeContext, false);

      if (!((oldValue001 != null) &&
          (oldValue001.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
        object000.truthValue = newValue000;
      }
    }
    KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, FloatWrapper.wrapFloat(((FloatWrapper)(KeyValueList.dynamicSlotValue(overlayingprop.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, Stella.NULL_FLOAT_WRAPPER))).wrapperValue), Stella.NULL_FLOAT_WRAPPER);
    KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_NEURAL_NETWORK, ((PropositionNeuralNetwork)(KeyValueList.dynamicSlotValue(overlayingprop.dynamicSlots, Logic.SYM_LOGIC_NEURAL_NETWORK, null))), null);
    self.arguments = overlayingprop.arguments.copy();
    if (((Vector)(KeyValueList.dynamicSlotValue(overlayingprop.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null))) != null) {
      KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, ((Vector)(KeyValueList.dynamicSlotValue(overlayingprop.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null))).copy(), null);
    }
    if (BooleanWrapper.coerceWrappedBooleanToBoolean(overlayingprop.variableTypeP())) {
      KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_VARIABLE_TYPEp, Stella.TRUE_WRAPPER, null);
    }
    if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(overlayingprop.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.FALSE_WRAPPER))).wrapperValue) {
      KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
    }
  }

  public static void collectFlatDisjuncts(Proposition self, List flatdisjuncts) {
    if (self.kind == Logic.KWD_OR) {
      { Stella_Object arg = null;
        Vector vector000 = self.arguments;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          Proposition.collectFlatDisjuncts(((Proposition)(arg)), flatdisjuncts);
        }
      }
      self.free();
    }
    else {
      { boolean foundP000 = false;

        { Proposition prop = null;
          Cons iter000 = flatdisjuncts.theConsList;

          loop001 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            prop = ((Proposition)(iter000.value));
            if (Proposition.duplicateAndOrArgumentsP(prop, self)) {
              foundP000 = true;
              break loop001;
            }
          }
        }
        if (!(foundP000)) {
          flatdisjuncts.push(self);
          self.dependentPropositions.clear();
        }
      }
    }
  }

  public static Proposition conjoinTwoPropositions(Proposition prop1, Proposition prop2) {
    if (prop1 == null) {
      return (prop2);
    }
    else if (prop2 == null) {
      return (prop1);
    }
    else if (Proposition.duplicateAndOrArgumentsP(prop1, prop2)) {
      return (prop1);
    }
    else {
      { Proposition andproposition = Logic.createProposition(Logic.SYM_STELLA_AND, 2);

        (andproposition.arguments.theArray)[0] = prop1;
        (andproposition.arguments.theArray)[1] = prop2;
        if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(prop1.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.FALSE_WRAPPER))).wrapperValue) {
          KeyValueList.setDynamicSlotValue(andproposition.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
        }
        return (andproposition);
      }
    }
  }

  public static void overlayWithConstantProposition(Proposition self, Proposition constantproposition) {
    { Proposition overlay = Logic.createProposition(Logic.SYM_LOGIC_CONSTANT, 0);

      overlay.operator = constantproposition.operator;
      { Proposition object000 = overlay;
        TruthValue value000 = ((TruthValue)(Stella_Object.accessInContext(constantproposition.truthValue, constantproposition.homeContext, false)));
        Stella_Object oldValue001 = object000.truthValue;
        Stella_Object newValue000 = Stella_Object.updateInContext(oldValue001, value000, object000.homeContext, false);

        if (!((oldValue001 != null) &&
            (oldValue001.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
          object000.truthValue = newValue000;
        }
      }
      Proposition.overlayProposition(self, overlay);
    }
  }

  public static void collectFlatConjuncts(Proposition self, List flatconjuncts) {
    { Keyword testValue000 = self.kind;

      if (testValue000 == Logic.KWD_AND) {
        { Stella_Object arg = null;
          Vector vector000 = self.arguments;
          int index000 = 0;
          int length000 = vector000.length();

          for (;index000 < length000; index000 = index000 + 1) {
            arg = (vector000.theArray)[index000];
            Proposition.collectFlatConjuncts(((Proposition)(arg)), flatconjuncts);
          }
        }
        return;
      }
      else if (testValue000 == Logic.KWD_CONSTANT) {
        if (self.operator == Logic.SGT_STELLA_TRUE) {
          return;
        }
      }
      else {
        self.dependentPropositions.clear();
      }
    }
    { boolean foundP000 = false;

      { Proposition prop = null;
        Cons iter000 = flatconjuncts.theConsList;

        loop001 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          prop = ((Proposition)(iter000.value));
          if (Proposition.duplicateAndOrArgumentsP(prop, self)) {
            foundP000 = true;
            break loop001;
          }
        }
      }
      if (!(foundP000)) {
        flatconjuncts.push(self);
      }
    }
  }

  public static boolean duplicateAndOrArgumentsP(Proposition prop1, Proposition prop2) {
    return (Proposition.equivalentPropositionsP(prop1, prop2, null) &&
        (!(Proposition.searchControlPropositionP(prop1) ||
        Proposition.searchControlPropositionP(prop2))));
  }

  public static boolean searchControlPropositionP(Proposition self) {
    { GeneralizedSymbol testValue000 = self.operator;

      if ((testValue000 == Logic.SGT_PL_KERNEL_KB_CUT) ||
          ((testValue000 == Logic.SGT_PL_KERNEL_KB_BOUND_VARIABLES) ||
           ((testValue000 == Logic.SGT_PL_KERNEL_KB_FORK) ||
            (testValue000 == Logic.SGT_PL_KERNEL_KB_QUERY)))) {
        return (true);
      }
      else {
        return (false);
      }
    }
  }

  public static void complainAboutUndeclaredReference(Proposition waywardproposition) {
    if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(waywardproposition.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.FALSE_WRAPPER))).wrapperValue) {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            stream000.nativeStream.println("ERROR: Undeclared predicate or function reference: `" + waywardproposition.operator + "'.");
            Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        throw ((PropositionError)(PropositionError.newPropositionError(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    else {
      { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.STANDARD_WARNING.nativeStream.println("WARNING: Undeclared predicate or function reference: " + waywardproposition.operator);
          Logic.helpSignalPropositionError(Stella.STANDARD_WARNING, Logic.KWD_WARNING);

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
        }
      }
    }
  }

  public static void createDummyRelation(Proposition waywardproposition) {
    { List fakevariabletypes = List.newList();
      Symbol symbolref = ((Symbol)(waywardproposition.operator));
      Surrogate relationref = Symbol.symbolToSurrogate(symbolref);
      NamedDescription description = null;

      { IntegerIntervalIterator i = Stella.interval(1, waywardproposition.arguments.length());

        while (i.nextP()) {
          fakevariabletypes.push(Logic.SGT_STELLA_THING);
        }
      }
      description = Logic.createPrimitiveDescription(Stella.NIL_LIST, fakevariabletypes, false, waywardproposition.kind == Logic.KWD_ISA, waywardproposition.kind == Logic.KWD_FUNCTION, ((Module)(relationref.homeContext)));
      waywardproposition.operator = relationref;
      Logic.bindLogicObjectToSurrogate(symbolref, description);
      KeyValueList.setDynamicSlotValue(description.dynamicSlots, Logic.SYM_LOGIC_UNDECLAREDp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
    }
  }

  public static boolean resolveOneSlotReferenceP(Proposition proposition, KeyValueList variabletypestable) {
    { Stella_Object firstargument = (proposition.arguments.theArray)[0];
      Stella_Object predicate = null;

      { Surrogate testValue000 = Stella_Object.safePrimaryType(firstargument);

        if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
          { PatternVariable firstargument000 = ((PatternVariable)(firstargument));

            { List types = ((List)(variabletypestable.lookup(firstargument000)));

              if (types != null) {
                predicate = Logic.inferPredicateFromOperatorAndTypes(proposition.operator, ((List)(variabletypestable.lookup(firstargument000))));
              }
            }
          }
        }
        else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_LOGIC_OBJECT)) {
          { LogicObject firstargument000 = ((LogicObject)(firstargument));

            { Surrogate roottype = Logic.safeLogicalType(firstargument000);

              if (roottype != null) {
                predicate = Logic.inferPredicateFromOperatorAndTypes(proposition.operator, List.list(Cons.cons(roottype, Stella.NIL)));
              }
            }
          }
        }
        else {
        }
      }
      if (predicate != null) {
        if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(predicate), Logic.SGT_STELLA_SLOT)) {
          { Slot predicate000 = ((Slot)(predicate));

            { Surrogate returntype = Logic.unwrapWrappedType(predicate000.slotBaseType);

              if (!Logic.booleanTypeP(returntype)) {
                proposition.kind = Logic.KWD_FUNCTION;
                if (Logic.variableP((proposition.arguments.theArray)[(proposition.arguments.length() - 1)])) {
                  { PatternVariable lastargument = ((PatternVariable)((proposition.arguments.theArray)[(proposition.arguments.length() - 1)]));

                    Skolem.updateSkolemType(lastargument, returntype);
                  }
                }
              }
              proposition.operator = Logic.mostGeneralEquivalentSlotref(predicate000.slotSlotref);
              Proposition.evaluateNewProposition(proposition);
              return (true);
            }
          }
        }
        else {
        }
      }
      return (false);
    }
  }

  public static Cons collectUnresolvedSlotReferences(Proposition self) {
    { Cons unresolvedslotreferences = Stella.NIL;

      if (Stella.getQuotedTree("((:PREDICATE :FUNCTION) \"/LOGIC\")", "/LOGIC").memberP(self.kind) &&
          Stella_Object.isaP(self.operator, Logic.SGT_STELLA_SYMBOL)) {
        unresolvedslotreferences = Cons.cons(self, unresolvedslotreferences);
      }
      { Stella_Object arg = null;
        Vector vector000 = self.arguments;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          if (Stella_Object.isaP(arg, Logic.SGT_LOGIC_PROPOSITION)) {
            { Proposition u = null;
              Cons iter000 = Proposition.collectUnresolvedSlotReferences(((Proposition)(arg)));

              for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                u = ((Proposition)(iter000.value));
                unresolvedslotreferences = Cons.cons(u, unresolvedslotreferences);
              }
            }
          }
        }
      }
      return (unresolvedslotreferences);
    }
  }

  public static KeyValueList inferVariableTypesInProposition(Proposition proposition, Cons visiblevariables) {
    { KeyValueList variabletypestable = KeyValueList.newKeyValueList();

      { Object old$AddednewtypeP$000 = Logic.$ADDEDNEWTYPEp$.get();

        try {
          Native.setBooleanSpecial(Logic.$ADDEDNEWTYPEp$, false);
          for (;;) {
            Native.setBooleanSpecial(Logic.$ADDEDNEWTYPEp$, false);
            Proposition.inferTypesFromPropositions(proposition, variabletypestable, visiblevariables);
            if (!((Boolean)(Logic.$ADDEDNEWTYPEp$.get())).booleanValue()) {
              return (variabletypestable);
            }
          }

        } finally {
          Logic.$ADDEDNEWTYPEp$.set(old$AddednewtypeP$000);
        }
      }
    }
  }

  public static void inferTypesFromPropositions(Proposition proposition, KeyValueList table, Cons visiblevars) {
    { Vector arguments = proposition.arguments;

      { Keyword testValue000 = proposition.kind;

        if (testValue000 == Logic.KWD_AND) {
          { Stella_Object arg = null;
            Vector vector000 = arguments;
            int index000 = 0;
            int length000 = vector000.length();

            for (;index000 < length000; index000 = index000 + 1) {
              arg = (vector000.theArray)[index000];
              Proposition.inferTypesFromPropositions(((Proposition)(arg)), table, visiblevars);
            }
          }
        }
        else if (testValue000 == Logic.KWD_OR) {
          { Stella_Object arg = null;
            Vector vector001 = arguments;
            int index001 = 0;
            int length001 = vector001.length();

            for (;index001 < length001; index001 = index001 + 1) {
              arg = (vector001.theArray)[index001];
              Proposition.inferTypesFromPropositions(((Proposition)(arg)), table, Stella.NIL);
            }
          }
        }
        else if ((testValue000 == Logic.KWD_ISA) ||
            ((testValue000 == Logic.KWD_PREDICATE) ||
             ((testValue000 == Logic.KWD_FUNCTION) ||
              (testValue000 == Logic.KWD_EQUIVALENT)))) {
          Proposition.inferTypesFromOneProposition(proposition, table, visiblevars);
        }
        else if (testValue000 == Logic.KWD_FORALL) {
          visiblevars = Stella.NIL;
          { PatternVariable v = null;
            Vector vector002 = ((Vector)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
            int index002 = 0;
            int length002 = vector002.length();

            for (;index002 < length002; index002 = index002 + 1) {
              v = ((PatternVariable)((vector002.theArray)[index002]));
              visiblevars = Cons.cons(v, visiblevars);
            }
          }
          Proposition.inferTypesFromPropositions(((Proposition)((arguments.theArray)[0])), table, visiblevars);
          Proposition.inferTypesFromPropositions(((Proposition)((arguments.theArray)[1])), table, visiblevars);
        }
        else if (testValue000 == Logic.KWD_EXISTS) {
          { PatternVariable v = null;
            Vector vector003 = ((Vector)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
            int index003 = 0;
            int length003 = vector003.length();

            for (;index003 < length003; index003 = index003 + 1) {
              v = ((PatternVariable)((vector003.theArray)[index003]));
              visiblevars = Cons.cons(v, visiblevars);
            }
          }
          Proposition.inferTypesFromPropositions(((Proposition)((arguments.theArray)[0])), table, visiblevars);
        }
        else {
        }
      }
    }
  }

  public static void inferTypesFromOneProposition(Proposition proposition, KeyValueList table, Cons visiblevars) {
    if (proposition.arguments.length() == 0) {
      return;
    }
    { Vector arguments = proposition.arguments;
      Stella_Object firstarg = (arguments.theArray)[0];

      { Keyword testValue000 = proposition.kind;

        if (testValue000 == Logic.KWD_ISA) {
          if (Stella_Object.isaP(firstarg, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
            PatternVariable.addVariableType(((PatternVariable)(firstarg)), ((Surrogate)(proposition.operator)), table, visiblevars);
          }
        }
        else if ((testValue000 == Logic.KWD_PREDICATE) ||
            (testValue000 == Logic.KWD_FUNCTION)) {
          { Stella_Object predicate = null;

            { Surrogate testValue001 = Stella_Object.safePrimaryType(firstarg);

              if (Surrogate.subtypeOfP(testValue001, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
                { PatternVariable firstarg000 = ((PatternVariable)(firstarg));

                  { List types = ((List)(table.lookup(firstarg000)));

                    if (types != null) {
                      predicate = Logic.inferPredicateFromOperatorAndTypes(proposition.operator, types);
                    }
                  }
                }
              }
              else if (Surrogate.subtypeOfSurrogateP(testValue001)) {
                { Surrogate firstarg000 = ((Surrogate)(firstarg));

                  { Stella_Object value = firstarg000.surrogateValue;
                    List types = List.newList();

                    if ((value != null) &&
                        Stella_Object.isaP(value, Logic.SGT_LOGIC_LOGIC_OBJECT)) {
                      { NamedDescription d = null;
                        Cons iter000 = Logic.allAssertedTypes(value);
                        Cons collect000 = null;

                        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                          d = ((NamedDescription)(iter000.value));
                          if (collect000 == null) {
                            {
                              collect000 = Cons.cons(d.surrogateValueInverse, Stella.NIL);
                              if (types.theConsList == Stella.NIL) {
                                types.theConsList = collect000;
                              }
                              else {
                                Cons.addConsToEndOfConsList(types.theConsList, collect000);
                              }
                            }
                          }
                          else {
                            {
                              collect000.rest = Cons.cons(d.surrogateValueInverse, Stella.NIL);
                              collect000 = collect000.rest;
                            }
                          }
                        }
                      }
                      types = Logic.mostSpecificTypes(types);
                      predicate = Logic.inferPredicateFromOperatorAndTypes(proposition.operator, types);
                    }
                  }
                }
              }
              else {
                { GeneralizedSymbol operator = proposition.operator;

                  if (Stella_Object.isaP(operator, Logic.SGT_STELLA_SURROGATE) &&
                      Stella_Object.isaP(((Surrogate)(operator)).surrogateValue, Logic.SGT_STELLA_SLOT)) {
                    predicate = ((Slot)(((Surrogate)(operator)).surrogateValue));
                  }
                }
              }
            }
            if (predicate != null) {
              { Surrogate testValue002 = Stella_Object.safePrimaryType(predicate);

                if (Surrogate.subtypeOfP(testValue002, Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
                  { NamedDescription predicate000 = ((NamedDescription)(predicate));

                    if (predicate000.ioVariableTypes != null) {
                      { Stella_Object arg = null;
                        Vector vector000 = arguments;
                        int index000 = 0;
                        int length000 = vector000.length();
                        Surrogate type = null;
                        Cons iter001 = predicate000.ioVariableTypes.theConsList;

                        for (;(index000 < length000) &&
                                  (!(iter001 == Stella.NIL)); index000 = index000 + 1, iter001 = iter001.rest) {
                          arg = (vector000.theArray)[index000];
                          type = ((Surrogate)(iter001.value));
                          if (Stella_Object.isaP(arg, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
                            PatternVariable.addVariableType(((PatternVariable)(arg)), type, table, visiblevars);
                          }
                        }
                      }
                    }
                    else {
                    }
                  }
                }
                else if (Surrogate.subtypeOfP(testValue002, Logic.SGT_STELLA_SLOT)) {
                  { Slot predicate000 = ((Slot)(predicate));

                    { Stella_Object arg = null;
                      Vector vector001 = arguments;
                      int index001 = 0;
                      int length001 = vector001.length();
                      Surrogate columntype = null;
                      Cons iter002 = Logic.slotColumnTypes(predicate000, arguments.length());

                      for (;(index001 < length001) &&
                                (!(iter002 == Stella.NIL)); index001 = index001 + 1, iter002 = iter002.rest) {
                        arg = (vector001.theArray)[index001];
                        columntype = ((Surrogate)(iter002.value));
                        if (Stella_Object.isaP(arg, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
                          PatternVariable.addVariableType(((PatternVariable)(arg)), columntype, table, visiblevars);
                        }
                      }
                    }
                  }
                }
                else if (Surrogate.subtypeOfP(testValue002, Logic.SGT_LOGIC_LOGIC_OBJECT)) {
                  { LogicObject predicate000 = ((LogicObject)(predicate));

                  }
                }
                else {
                  { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                    stream000.nativeStream.print("`" + testValue002 + "' is not a valid case option");
                    throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                  }
                }
              }
            }
          }
        }
        else if (testValue000 == Logic.KWD_EQUIVALENT) {
          { Stella_Object secondarg = (arguments.theArray)[1];

            if (Stella_Object.isaP(firstarg, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
              if (Stella_Object.isaP(secondarg, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
                { Stella_Object t = null;
                  Cons iter003 = List.mapNullToNilList(((List)(table.lookup(((PatternVariable)(secondarg)))))).theConsList;

                  for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
                    t = iter003.value;
                    PatternVariable.addVariableType(((PatternVariable)(firstarg)), ((Surrogate)(t)), table, visiblevars);
                  }
                }
              }
              else {
                PatternVariable.addVariableType(((PatternVariable)(firstarg)), Logic.logicalType(secondarg), table, visiblevars);
              }
            }
            if (Stella_Object.isaP(secondarg, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
              if (Stella_Object.isaP(firstarg, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
                { Stella_Object t = null;
                  Cons iter004 = List.mapNullToNilList(((List)(table.lookup(((PatternVariable)(firstarg)))))).theConsList;

                  for (;!(iter004 == Stella.NIL); iter004 = iter004.rest) {
                    t = iter004.value;
                    PatternVariable.addVariableType(((PatternVariable)(secondarg)), ((Surrogate)(t)), table, visiblevars);
                  }
                }
              }
              else {
                PatternVariable.addVariableType(((PatternVariable)(secondarg)), Logic.logicalType(firstarg), table, visiblevars);
              }
            }
          }
        }
        else {
        }
      }
    }
  }

  public static Cons removeVariableTypePropositions(Proposition proposition) {
    { Keyword testValue000 = proposition.kind;

      if (testValue000 == Logic.KWD_AND) {
        { Cons typedeclarations = Stella.NIL;
          Proposition goalproposition = null;

          { Stella_Object arg = null;
            Vector vector000 = proposition.arguments;
            int index000 = 0;
            int length000 = vector000.length();

            for (;index000 < length000; index000 = index000 + 1) {
              arg = (vector000.theArray)[index000];
              if (BooleanWrapper.coerceWrappedBooleanToBoolean(((Proposition)(arg)).variableTypeP())) {
                typedeclarations = Cons.cons(arg, typedeclarations);
              }
              else if (goalproposition != null) {
              }
              else {
                goalproposition = ((Proposition)(arg));
              }
            }
          }
          Proposition.overlayProposition(proposition, goalproposition);
          return (typedeclarations);
        }
      }
      else if ((testValue000 == Logic.KWD_ISA) ||
          ((testValue000 == Logic.KWD_PREDICATE) ||
           ((testValue000 == Logic.KWD_FUNCTION) ||
            (testValue000 == Logic.KWD_NOT)))) {
        return (Stella.NIL);
      }
      else {
      }
    }
    return (Stella.NIL);
  }

  public static void collectExternalVariables(Proposition proposition) {
    { Stella_Object arg = null;
      Vector vector000 = proposition.arguments;
      int index000 = 0;
      int length000 = vector000.length();

      for (;index000 < length000; index000 = index000 + 1) {
        arg = (vector000.theArray)[index000];
        { Surrogate testValue000 = Stella_Object.safePrimaryType(arg);

          if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
            { PatternVariable arg000 = ((PatternVariable)(arg));

              if (((Cons)(Logic.$LOGICVARIABLETABLE$.get())).memberP(arg000) &&
                  (!((Cons)(Logic.$EXTERNALVARIABLES$.get())).memberP(arg000))) {
                Native.setSpecial(Logic.$EXTERNALVARIABLES$, Cons.cons(arg000, ((Cons)(Logic.$EXTERNALVARIABLES$.get()))));
              }
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PROPOSITION)) {
            { Proposition arg000 = ((Proposition)(arg));

              Proposition.collectExternalVariables(arg000);
            }
          }
          else {
          }
        }
      }
    }
  }

  public static void collectAllVariables(Proposition self, List collection, List beenthere) {
    beenthere.insert(self);
    { Stella_Object arg = null;
      Vector vector000 = self.arguments;
      int index000 = 0;
      int length000 = vector000.length();

      for (;index000 < length000; index000 = index000 + 1) {
        arg = (vector000.theArray)[index000];
        { Surrogate testValue000 = Stella_Object.safePrimaryType(arg);

          if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
            { PatternVariable arg000 = ((PatternVariable)(arg));

              collection.insertNew(arg000);
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PROPOSITION)) {
            { Proposition arg000 = ((Proposition)(arg));

              if (!(beenthere.memberP(arg000))) {
                Proposition.collectAllVariables(arg000, collection, beenthere);
              }
            }
          }
          else {
          }
        }
      }
    }
  }

  public static void equateTopLevelEquivalences(Proposition proposition, Vector iovariables, Keyword kind) {
    { Vector arguments = proposition.arguments;

      { Keyword testValue000 = proposition.kind;

        if (testValue000 == Logic.KWD_EQUIVALENT) {
          { Stella_Object arg1 = Logic.innermostOf((arguments.theArray)[0]);
            Stella_Object arg2 = Logic.innermostOf((arguments.theArray)[1]);

            if ((Logic.variableP(arg1) ||
                Logic.argumentBoundP(arg1)) &&
                (Logic.variableP(arg2) ||
                 Logic.argumentBoundP(arg2))) {
              if (iovariables.memberP(arg1)) {
                if (iovariables.memberP(arg2)) {
                  if (!(kind == Logic.KWD_HEAD)) {
                    Proposition.equateValues(proposition, arg1, arg2);
                  }
                }
                else {
                  Proposition.equateValues(proposition, arg2, arg1);
                }
              }
              else {
                Proposition.equateValues(proposition, arg1, arg2);
              }
            }
          }
        }
        else if (testValue000 == Logic.KWD_AND) {
          { Stella_Object arg = null;
            Vector vector000 = arguments;
            int index000 = 0;
            int length000 = vector000.length();

            for (;index000 < length000; index000 = index000 + 1) {
              arg = (vector000.theArray)[index000];
              Proposition.equateTopLevelEquivalences(((Proposition)(arg)), iovariables, kind);
            }
          }
        }
        else if (testValue000 == Logic.KWD_EXISTS) {
          Proposition.equateTopLevelEquivalences(((Proposition)((arguments.theArray)[0])), iovariables, kind);
        }
        else if (testValue000 == Logic.KWD_FUNCTION) {
          Proposition.evaluateFunctionProposition(proposition);
        }
        else {
        }
      }
    }
  }

  public static void tightenArgumentBindings(Proposition proposition, Vector iovariables) {
    { 
      { Stella_Object arg = null;
        Vector vector000 = proposition.arguments;
        int index000 = 0;
        int length000 = vector000.length();
        int i = Stella.NULL_INTEGER;
        int iter000 = 0;

        for (;index000 < length000; index000 = index000 + 1, iter000 = iter000 + 1) {
          arg = (vector000.theArray)[index000];
          i = iter000;
          { Surrogate testValue000 = Stella_Object.safePrimaryType(arg);

            if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
              { PatternVariable arg000 = ((PatternVariable)(arg));

                { Stella_Object value = (((iovariables != null) &&
                      iovariables.memberP(arg000)) ? PatternVariable.innermostVariableOf(arg000) : Logic.innermostOf(arg000));

                  if (!(value == arg000)) {
                    (proposition.arguments.theArray)[i] = value;
                  }
                }
              }
            }
            else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PROPOSITION)) {
              { Proposition arg000 = ((Proposition)(arg));

                Proposition.tightenArgumentBindings(arg000, iovariables);
              }
            }
            else {
            }
          }
        }
      }
      if (((Vector)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null))) != null) {
        { Vector quantifiedvariables = ((Vector)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));

          { PatternVariable vbl = null;
            Vector vector001 = quantifiedvariables;
            int index001 = 0;
            int length001 = vector001.length();
            int i = Stella.NULL_INTEGER;
            int iter001 = 0;

            for (;index001 < length001; index001 = index001 + 1, iter001 = iter001 + 1) {
              vbl = ((PatternVariable)((vector001.theArray)[index001]));
              i = iter001;
              if (!(vbl == PatternVariable.innermostVariableOf(vbl))) {
                (quantifiedvariables.theArray)[i] = null;
              }
            }
          }
          KeyValueList.setDynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, Logic.removeNullsInVariablesVector(quantifiedvariables), null);
          Proposition.normalizeProposition(proposition);
        }
      }
    }
  }

  public static Proposition flattenNestedFunctionArguments(Proposition proposition) {
    { Proposition existsproposition = Logic.createProposition(Logic.SYM_STELLA_EXISTS, 1);
      List existsvariables = List.newList();
      List flattenedpropositions = Proposition.yieldFlattenedArguments(proposition, existsvariables);
      Proposition andproposition = Logic.createProposition(Logic.SYM_STELLA_AND, flattenedpropositions.length());

      { Proposition prop = null;
        Cons iter000 = flattenedpropositions.theConsList;
        int i = Stella.NULL_INTEGER;
        int iter001 = 0;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
          prop = ((Proposition)(iter000.value));
          i = iter001;
          (andproposition.arguments.theArray)[i] = prop;
        }
      }
      { PatternVariable vbl = null;
        Cons iter002 = existsvariables.theConsList;

        for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
          vbl = ((PatternVariable)(iter002.value));
          vbl.definingProposition = null;
        }
      }
      KeyValueList.setDynamicSlotValue(existsproposition.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, Logic.copyConsListToVariablesVector(existsvariables.theConsList), null);
      existsvariables.free();
      (existsproposition.arguments.theArray)[0] = andproposition;
      return (existsproposition);
    }
  }

  public static List yieldFlattenedArguments(Proposition proposition, List existsvariables) {
    { List flattenedarguments = List.newList();

      Proposition.helpCollectFlattenedArguments(proposition, flattenedarguments, existsvariables);
      flattenedarguments.push(proposition);
      existsvariables.reverse();
      return (flattenedarguments.reverse());
    }
  }

  public static void helpCollectFlattenedArguments(Proposition self, List flattenedarguments, List existsvariables) {
    { Stella_Object term = null;
      Vector vector000 = self.arguments;
      int index000 = 0;
      int length000 = vector000.length();

      for (;index000 < length000; index000 = index000 + 1) {
        term = (vector000.theArray)[index000];
        if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(term), Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
          { PatternVariable term000 = ((PatternVariable)(term));

            { Proposition functionarg = term000.definingProposition;

              if ((functionarg != null) &&
                  (!existsvariables.memberP(term000))) {
                existsvariables.push(term000);
                Proposition.helpCollectFlattenedArguments(functionarg, flattenedarguments, existsvariables);
                if (functionarg.operator == Logic.SGT_STELLA_PROPOSITIONdIF) {
                  flattenedarguments.push(Proposition.expandIfProposition(functionarg));
                }
                else {
                  flattenedarguments.push(functionarg);
                }
              }
            }
          }
        }
        else {
        }
      }
    }
  }

  public static Proposition expandIfProposition(Proposition ifproposition) {
    { Vector arguments = ifproposition.arguments;
      Stella_Object testprop = (arguments.theArray)[0];
      Proposition negatedtestprop = Logic.createProposition(Logic.SYM_STELLA_NOT, 1);
      Stella_Object truevalue = (arguments.theArray)[1];
      Stella_Object falsevalue = (arguments.theArray)[2];
      PatternVariable valuevariable = ((PatternVariable)((ifproposition.arguments.theArray)[(ifproposition.arguments.length() - 1)]));
      Proposition trueequivalence = Logic.createEquivalenceProposition(valuevariable, truevalue);
      Proposition falseequivalence = ((falsevalue != null) ? Logic.createEquivalenceProposition(valuevariable, falsevalue) : ((Proposition)(null)));

      valuevariable.definingProposition = null;
      if (falsevalue != null) {
        {
          (negatedtestprop.arguments.theArray)[0] = ((Stella_Object.isaP(testprop, Logic.SGT_LOGIC_PATTERN_VARIABLE) ? testprop : Proposition.shallowCopyProposition(((Proposition)(testprop)))));
          return (Logic.disjoinPropositions(Cons.consList(Cons.cons(Proposition.conjoinTwoPropositions(((Proposition)(testprop)), trueequivalence), Cons.cons(Proposition.conjoinTwoPropositions(negatedtestprop, falseequivalence), Stella.NIL)))));
        }
      }
      else {
        return (Proposition.conjoinTwoPropositions(((Proposition)(testprop)), trueequivalence));
      }
    }
  }

  public static boolean containsNestedArgumentP(Proposition proposition) {
    { Keyword testValue000 = proposition.kind;

      if ((testValue000 == Logic.KWD_ISA) ||
          ((testValue000 == Logic.KWD_FUNCTION) ||
           ((testValue000 == Logic.KWD_PREDICATE) ||
            ((testValue000 == Logic.KWD_EQUIVALENT) ||
             (testValue000 == Logic.KWD_IMPLIES))))) {
        { Stella_Object term = null;
          Vector vector000 = proposition.arguments;
          int index000 = 0;
          int length000 = vector000.length();

          for (;index000 < length000; index000 = index000 + 1) {
            term = (vector000.theArray)[index000];
            if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(term), Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
              { PatternVariable term000 = ((PatternVariable)(term));

                if (term000.definingProposition != null) {
                  return (true);
                }
              }
            }
            else {
            }
          }
        }
      }
      else {
      }
    }
    return (false);
  }

  public static boolean unifyPropositionsP(Proposition self, Proposition other, KeyValueMap mapping) {
    { Object old$UnifyPropositionsP$000 = Logic.$UNIFY_PROPOSITIONSp$.get();

      try {
        Native.setBooleanSpecial(Logic.$UNIFY_PROPOSITIONSp$, true);
        return (Proposition.equivalentPropositionsP(self, other, mapping));

      } finally {
        Logic.$UNIFY_PROPOSITIONSp$.set(old$UnifyPropositionsP$000);
      }
    }
  }

  public static boolean equivalentFunctionPropositionsP(Proposition self, Proposition other, KeyValueMap mapping) {
    return ((self.kind == Logic.KWD_FUNCTION) &&
        ((other.kind == Logic.KWD_FUNCTION) &&
         Proposition.helpEquivalentPropositionsP(self, other, mapping, true)));
  }

  public static boolean equivalentPropositionsP(Proposition self, Proposition other, KeyValueMap mapping) {
    return (Proposition.helpEquivalentPropositionsP(self, other, mapping, false));
  }

  public static boolean helpEquivalentPropositionsP(Proposition self, Proposition other, KeyValueMap mapping, boolean ignorelastargP) {
    if (self == other) {
      return (true);
    }
    if (!(self.kind == other.kind)) {
      return (false);
    }
    { Keyword testValue000 = self.kind;

      if ((testValue000 == Logic.KWD_AND) ||
          ((testValue000 == Logic.KWD_OR) ||
           (testValue000 == Logic.KWD_EQUIVALENT))) {
        return (Proposition.equivalentCommutativePropositionsP(self, other, mapping));
      }
      else {
        { Keyword testValue001 = self.kind;

          if ((testValue001 == Logic.KWD_FORALL) ||
              (testValue001 == Logic.KWD_EXISTS)) {
            { Vector iovars1 = ((Vector)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
              Vector iovars2 = ((Vector)(KeyValueList.dynamicSlotValue(other.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));

              if (!(iovars1.length() == iovars2.length())) {
                return (false);
              }
              if (mapping == null) {
                mapping = KeyValueMap.newKeyValueMap();
              }
              { PatternVariable v1 = null;
                Vector vector000 = iovars1;
                int index000 = 0;
                int length000 = vector000.length();
                PatternVariable v2 = null;
                Vector vector001 = iovars2;
                int index001 = 0;
                int length001 = vector001.length();

                for (;(index000 < length000) &&
                          (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
                  v1 = ((PatternVariable)((vector000.theArray)[index000]));
                  v2 = ((PatternVariable)((vector001.theArray)[index001]));
                  mapping.insertAt(v1, v2);
                }
              }
            }
          }
          else {
          }
        }
        { Vector selfargs = self.arguments;
          Vector otherargs = other.arguments;

          { boolean testValue002 = false;

            testValue002 = self.operator == other.operator;
            if (testValue002) {
              { boolean alwaysP000 = true;

                { Stella_Object arg1 = null;
                  Vector vector002 = selfargs;
                  int index002 = 0;
                  int length002 = vector002.length();
                  Stella_Object arg2 = null;
                  Vector vector003 = otherargs;
                  int index003 = 0;
                  int length003 = vector003.length();
                  int i = Stella.NULL_INTEGER;
                  int iter000 = 2;
                  int upperBound000 = (ignorelastargP ? selfargs.length() : Stella.NULL_INTEGER);
                  boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

                  loop001 : for (;(index002 < length002) &&
                            ((index003 < length003) &&
                             (unboundedP000 ||
                              (iter000 <= upperBound000))); 
                        index002 = index002 + 1,
                        index003 = index003 + 1,
                        iter000 = iter000 + 1) {
                    arg1 = (vector002.theArray)[index002];
                    arg2 = (vector003.theArray)[index003];
                    i = iter000;
                    if (!Logic.equivalentFormulaeP(arg1, arg2, mapping)) {
                      alwaysP000 = false;
                      break loop001;
                    }
                  }
                }
                testValue002 = alwaysP000;
              }
              if (testValue002) {
                testValue002 = selfargs.length() == otherargs.length();
              }
            }
            if (!testValue002) {
              testValue002 = (mapping != null) &&
                  ((self.operator == Logic.SGT_PL_KERNEL_KB_HOLDS) &&
                   Proposition.equivalentHoldsPropositionP(self, other, mapping));
            }
            { boolean value000 = testValue002;

              return (value000);
            }
          }
        }
      }
    }
  }

  public static boolean equivalentCommutativePropositionsP(Proposition self, Proposition other, KeyValueMap mapping) {
    { boolean testValue000 = false;

      testValue000 = self.operator == other.operator;
      if (testValue000) {
        testValue000 = self.arguments.length() == other.arguments.length();
        if (testValue000) {
          { boolean alwaysP000 = true;

            { Stella_Object arg1 = null;
              Vector vector000 = self.arguments;
              int index000 = 0;
              int length000 = vector000.length();

              loop000 : for (;index000 < length000; index000 = index000 + 1) {
                arg1 = (vector000.theArray)[index000];
                { boolean testValue001 = false;

                  { boolean foundP000 = false;

                    { Stella_Object arg2 = null;
                      Vector vector001 = other.arguments;
                      int index001 = 0;
                      int length001 = vector001.length();

                      loop001 : for (;index001 < length001; index001 = index001 + 1) {
                        arg2 = (vector001.theArray)[index001];
                        if (Logic.equivalentFormulaeP(arg1, arg2, mapping)) {
                          foundP000 = true;
                          break loop001;
                        }
                      }
                    }
                    testValue001 = foundP000;
                  }
                  testValue001 = !testValue001;
                  if (testValue001) {
                    alwaysP000 = false;
                    break loop000;
                  }
                }
              }
            }
            testValue000 = alwaysP000;
          }
        }
      }
      { boolean value000 = testValue000;

        return (value000);
      }
    }
  }

  public static boolean equivalentHoldsPropositionP(Proposition self, Proposition other, KeyValueMap mapping) {
    { boolean testValue000 = false;

      testValue000 = Logic.equivalentFormulaeP((self.arguments.theArray)[0], other.operator, mapping);
      if (testValue000) {
        testValue000 = (self.arguments.length() - 1) == other.arguments.length();
        if (testValue000) {
          { boolean alwaysP000 = true;

            { int i1 = Stella.NULL_INTEGER;
              int iter000 = 1;
              Stella_Object arg2 = null;
              Vector vector000 = other.arguments;
              int index000 = 0;
              int length000 = vector000.length();

              loop000 : for (;index000 < length000; iter000 = iter000 + 1, index000 = index000 + 1) {
                i1 = iter000;
                arg2 = (vector000.theArray)[index000];
                if (!Logic.equivalentFormulaeP((self.arguments.theArray)[i1], arg2, mapping)) {
                  alwaysP000 = false;
                  break loop000;
                }
              }
            }
            testValue000 = alwaysP000;
          }
        }
      }
      { boolean value000 = testValue000;

        return (value000);
      }
    }
  }

  public static void inheritTruthValueUpdate(Proposition proposition, World toworld) {
  }

  /** Return TRUE if 'proposition' is tied only to at least one meta object
   * and no other objects except literals or function terms that are itself meta objects.
   * @param proposition
   * @return boolean
   */
  public static boolean metaPropositionP(Proposition proposition) {
    if (proposition == null) {
      return (false);
    }
    { Vector arguments = proposition.arguments;
      boolean pointstometaobjectP = false;

      { Stella_Object arg = null;
        Vector vector000 = arguments;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          { Surrogate testValue000 = Stella_Object.safePrimaryType(arg);

            if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_DESCRIPTION)) {
              { Description arg000 = ((Description)(arg));

                pointstometaobjectP = true;
              }
            }
            else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_STELLA_LITERAL_WRAPPER)) {
              { LiteralWrapper arg000 = ((LiteralWrapper)(arg));

              }
            }
            else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_SKOLEM)) {
              { Skolem arg000 = ((Skolem)(arg));

                if ((arg000 == arguments.last()) &&
                    (proposition.kind == Logic.KWD_FUNCTION)) {
                }
                else if ((arg000.definingProposition != null) &&
                    Proposition.metaPropositionP(arg000.definingProposition)) {
                  pointstometaobjectP = true;
                }
                else {
                  return (false);
                }
              }
            }
            else {
              return (false);
            }
          }
        }
      }
      return (pointstometaobjectP);
    }
  }

  public static String factToSentence(Proposition self, boolean periodP) {
    { Keyword testValue000 = self.kind;

      if ((testValue000 == Logic.KWD_PREDICATE) ||
          ((testValue000 == Logic.KWD_FUNCTION) ||
           (testValue000 == Logic.KWD_ISA))) {
        { NamedDescription relation = ((NamedDescription)(((Surrogate)(self.operator)).surrogateValue));
          Stella_Object phrase = Logic.accessBinaryValue(relation, Logic.SGT_PL_KERNEL_KB_PHRASE);
          List explodedstring = ((phrase != null) ? Logic.explodeVariablizedString(((StringWrapper)(phrase)).wrapperValue) : ((List)(null)));

          if (explodedstring != null) {
            { KeyValueList table = KeyValueList.newKeyValueList();
              String sentence = "";

              { Symbol vbl = null;
                Cons iter000 = relation.ioVariableNames.theConsList;
                Stella_Object arg = null;
                Vector vector000 = self.arguments;
                int index000 = 0;
                int length000 = vector000.length();

                for (;(!(iter000 == Stella.NIL)) &&
                          (index000 < length000); iter000 = iter000.rest, index000 = index000 + 1) {
                  vbl = ((Symbol)(iter000.value));
                  arg = (vector000.theArray)[index000];
                  table.insertAt(vbl, arg);
                }
              }
              { Stella_Object item = null;
                Cons iter001 = explodedstring.theConsList;

                for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                  item = iter001.value;
                  { Stella_Object value = null;
                    String stringvalue = null;

                    { Surrogate testValue001 = Stella_Object.safePrimaryType(item);

                      if (Surrogate.subtypeOfSymbolP(testValue001)) {
                        { Symbol item000 = ((Symbol)(item));

                          value = table.lookup(item000);
                          if (value != null) {
                            { Surrogate testValue002 = Stella_Object.safePrimaryType(value);

                              if (Surrogate.subtypeOfP(testValue002, Logic.SGT_LOGIC_SKOLEM)) {
                                { Skolem value000 = ((Skolem)(value));

                                  { Surrogate surrogate = ((LogicObject)(value000)).surrogateValueInverse;
                                    Proposition definingproposition = value000.definingProposition;

                                    if (definingproposition != null) {
                                      stringvalue = Proposition.factToSentence(definingproposition, false);
                                    }
                                    else if (surrogate != null) {
                                      stringvalue = surrogate.symbolName;
                                    }
                                    else {
                                      stringvalue = ((Skolem)(value000)).skolemName.symbolName;
                                    }
                                  }
                                }
                              }
                              else if (Surrogate.subtypeOfP(testValue002, Logic.SGT_LOGIC_LOGIC_OBJECT)) {
                                { LogicObject value000 = ((LogicObject)(value));

                                  { Surrogate surrogate = ((LogicObject)(value000)).surrogateValueInverse;

                                    if (surrogate != null) {
                                      stringvalue = surrogate.symbolName;
                                    }
                                  }
                                }
                              }
                              else if (Surrogate.subtypeOfStringP(testValue002)) {
                                { StringWrapper value000 = ((StringWrapper)(value));

                                  stringvalue = "'" + value000.wrapperValue + "'";
                                }
                              }
                              else if (Surrogate.subtypeOfIntegerP(testValue002)) {
                                { IntegerWrapper value000 = ((IntegerWrapper)(value));

                                  stringvalue = Native.integerToString(((long)(value000.wrapperValue)));
                                }
                              }
                              else if (Surrogate.subtypeOfFloatP(testValue002)) {
                                { FloatWrapper value000 = ((FloatWrapper)(value));

                                  stringvalue = Native.floatToString(value000.wrapperValue);
                                }
                              }
                              else {
                              }
                            }
                          }
                          if (stringvalue != null) {
                            sentence = sentence + stringvalue;
                          }
                          else {
                            sentence = sentence + item000.symbolName;
                          }
                        }
                      }
                      else if (Surrogate.subtypeOfStringP(testValue001)) {
                        { StringWrapper item000 = ((StringWrapper)(item));

                          sentence = sentence + item000.wrapperValue;
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
              }
              if (periodP) {
                sentence = sentence + ".";
              }
              return (sentence);
            }
          }
          return (null);
        }
      }
      else if (testValue000 == Logic.KWD_IMPLIES) {
        return ("rules not yet implemented");
      }
      else {
        return ("???");
      }
    }
  }

  public static boolean followDependentPropositionArgumentP(Proposition proposition, Stella_Object argument) {
    if (proposition.kind == Logic.KWD_EQUIVALENT) {
      return (true);
    }
    if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(argument), Logic.SGT_LOGIC_SKOLEM)) {
      { Skolem argument000 = ((Skolem)(argument));

        if (Logic.functionOutputSkolemP(argument000)) {
          return (true);
        }
        { NamedDescription relation = Logic.getDescription(proposition.operator);

          if (relation != null) {
            if (Description.computedTermP(relation)) {
              return (true);
            }
          }
        }
        return (!Logic.unfilteredDependentPropositions(argument000, Logic.SGT_PL_KERNEL_KB_EQUIVALENT).emptyP());
      }
    }
    else {
    }
    return (false);
  }

  public static void elaborateSurrogatesInProposition(Proposition proposition) {
    if (Logic.$JUST_IN_TIME_FORWARD_INFERENCEp$) {
      { Keyword testValue000 = proposition.kind;

        if ((testValue000 == Logic.KWD_PREDICATE) ||
            ((testValue000 == Logic.KWD_FUNCTION) ||
             (testValue000 == Logic.KWD_ISA))) {
          Logic.elaborateMetaInstance(Logic.getDescription(((Surrogate)(proposition.operator))));
          { Stella_Object arg = null;
            Vector vector000 = proposition.arguments;
            int index000 = 0;
            int length000 = vector000.length();

            for (;index000 < length000; index000 = index000 + 1) {
              arg = (vector000.theArray)[index000];
              if (Stella_Object.isaP(arg, Logic.SGT_STELLA_SURROGATE)) {
                { Stella_Object value = Logic.valueOf(arg);

                  if (value != null) {
                    Logic.elaborateInstance(value);
                  }
                }
              }
            }
          }
        }
        else if ((testValue000 == Logic.KWD_AND) ||
            ((testValue000 == Logic.KWD_OR) ||
             ((testValue000 == Logic.KWD_NOT) ||
              ((testValue000 == Logic.KWD_EXISTS) ||
               (testValue000 == Logic.KWD_FORALL))))) {
          { Stella_Object p = null;
            Vector vector001 = proposition.arguments;
            int index001 = 0;
            int length001 = vector001.length();

            for (;index001 < length001; index001 = index001 + 1) {
              p = (vector001.theArray)[index001];
              Proposition.elaborateSurrogatesInProposition(((Proposition)(p)));
            }
          }
        }
        else {
        }
      }
    }
  }

  public static void recursivelyReactToInferenceUpdate(Proposition self) {
    self.reactToInferenceUpdate();
    { Stella_Object arg = null;
      Vector vector000 = self.arguments;
      int index000 = 0;
      int length000 = vector000.length();

      for (;index000 < length000; index000 = index000 + 1) {
        arg = (vector000.theArray)[index000];
        if (Stella_Object.isaP(arg, Logic.SGT_LOGIC_PROPOSITION)) {
          Proposition.recursivelyReactToInferenceUpdate(((Proposition)(arg)));
        }
      }
    }
  }

  /** Evaluate 'self' against its arguments, possibly resulting in
   * the setting or changing of its truth value.
   * @param self
   */
  public static void evaluateProposition(Proposition self) {
    Proposition.evaluationStateSetter(self, Logic.KWD_EVALUATED);
    { Keyword testValue000 = self.kind;

      if (testValue000 == Logic.KWD_AND) {
        Proposition.evaluateAndProposition(self);
      }
      else if (testValue000 == Logic.KWD_OR) {
        Proposition.evaluateOrProposition(self);
      }
      else if (testValue000 == Logic.KWD_NOT) {
        Proposition.evaluateNotProposition(self);
      }
      else if (testValue000 == Logic.KWD_EQUIVALENT) {
        Proposition.evaluateEquivalentProposition(self);
      }
      else if (testValue000 == Logic.KWD_ISA) {
      }
      else if ((testValue000 == Logic.KWD_FUNCTION) ||
          (testValue000 == Logic.KWD_PREDICATE)) {
        { NamedDescription description = Logic.getDescription(((Surrogate)(self.operator)));
          java.lang.reflect.Method evaluator = NamedDescription.lookupEvaluator(description);

          if (evaluator != null) {
            edu.isi.stella.javalib.Native.funcall(evaluator, null, new java.lang.Object [] {self});
          }
          else if (self.kind == Logic.KWD_PREDICATE) {
            Proposition.evaluatePredicateProposition(self);
          }
          else {
            Proposition.evaluateFunctionProposition(self);
          }
        }
      }
      else {
      }
    }
  }

  public static void evaluatePredicateProposition(Proposition self) {
    { NamedDescription description = Logic.getDescription(((Surrogate)(self.operator)));
      MethodSlot computation = NamedDescription.lookupConstraintFunction(description);
      boolean successP = false;

      if (computation != null) {
        successP = Stella_Object.eqlP(Proposition.computeSimpleRelationConstraint(self, computation, false, new Object[1]), Stella.TRUE_WRAPPER);
        Proposition.assignTruthValue(self, (successP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
        return;
      }
      computation = NamedDescription.lookupComputationFunction(description);
      if (computation != null) {
        successP = Stella_Object.eqlP(Proposition.computeRelationValue(self, computation, false), Stella.TRUE_WRAPPER);
        Proposition.assignTruthValue(self, (successP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
      }
    }
  }

  public static void evaluateFunctionProposition(Proposition self) {
    if (Stella_Object.isaP(self.operator, Logic.SGT_STELLA_SYMBOL)) {
      return;
    }
    Proposition.equateEquivalentFunctionPropositions(self);
    { NamedDescription description = Logic.getDescription(((Surrogate)(self.operator)));
      MethodSlot computation = NamedDescription.lookupConstraintFunction(description);
      Stella_Object storedvalue = null;
      Stella_Object computedvalue = null;
      int missingvalueindex = -1;

      if (computation != null) {
        { Object [] caller_MV_returnarray = new Object[1];

          computedvalue = Proposition.computeSimpleRelationConstraint(self, computation, false, caller_MV_returnarray);
          missingvalueindex = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
        }
        if (computedvalue != null) {
          if (missingvalueindex == -1) {
            Proposition.assignTruthValue(self, computedvalue);
            return;
          }
          storedvalue = Logic.valueOf((self.arguments.theArray)[missingvalueindex]);
          if (!Stella_Object.eqlP(computedvalue, storedvalue)) {
            Proposition.equateValues(self, computedvalue, storedvalue);
          }
        }
        return;
      }
      computation = NamedDescription.lookupComputationFunction(description);
      if (computation != null) {
        computedvalue = Proposition.computeRelationValue(self, computation, false);
        if (computedvalue != null) {
          computedvalue = Logic.evaluateTerm(computedvalue);
        }
        storedvalue = Logic.valueOf((self.arguments.theArray)[(self.arguments.length() - 1)]);
        if ((!Stella_Object.eqlP(computedvalue, storedvalue)) &&
            (computedvalue != null)) {
          Proposition.equateValues(self, computedvalue, storedvalue);
        }
      }
    }
  }

  public static void equateEquivalentFunctionPropositions(Proposition self) {
    { Surrogate relationref = ((Surrogate)(self.operator));
      int nofargs = self.arguments.length();
      List candidatepropositions = List.newList();

      { Stella_Object arg = null;
        Vector vector000 = self.arguments;
        int index000 = 0;
        int length000 = vector000.length();
        int i = Stella.NULL_INTEGER;
        int iter000 = 1;

        for (;index000 < length000; index000 = index000 + 1, iter000 = iter000 + 1) {
          arg = (vector000.theArray)[index000];
          i = iter000;
          if (!(i == nofargs)) {
            { Surrogate testValue000 = Stella_Object.safePrimaryType(arg);

              if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_SKOLEM)) {
                { Skolem arg000 = ((Skolem)(arg));

                  if ((((Stella_Object)(Stella_Object.accessInContext(arg000.variableValue, arg000.homeContext, false))) != null) &&
                      Stella_Object.isaP(((Stella_Object)(Stella_Object.accessInContext(arg000.variableValue, arg000.homeContext, false))), Logic.SGT_LOGIC_LOGIC_OBJECT)) {
                    { Proposition prop = null;
                      Iterator iter001 = Logic.unfilteredDependentPropositions(((Stella_Object)(Stella_Object.accessInContext(arg000.variableValue, arg000.homeContext, false))), relationref).allocateIterator();

                      while (iter001.nextP()) {
                        prop = ((Proposition)(iter001.value));
                        if ((((Surrogate)(prop.operator)) == relationref) &&
                            (!(prop == self))) {
                          candidatepropositions.insertNew(prop);
                        }
                      }
                    }
                  }
                  { LogicObject invarg = null;
                    Cons iter002 = arg000.variableValueInverse();

                    for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                      invarg = ((LogicObject)(iter002.value));
                      { Proposition prop = null;
                        Iterator iter003 = Logic.unfilteredDependentPropositions(invarg, relationref).allocateIterator();

                        while (iter003.nextP()) {
                          prop = ((Proposition)(iter003.value));
                          if ((((Surrogate)(prop.operator)) == relationref) &&
                              (!(prop == self))) {
                            candidatepropositions.insertNew(prop);
                          }
                        }
                      }
                    }
                  }
                }
              }
              else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_LOGIC_OBJECT)) {
                { LogicObject arg000 = ((LogicObject)(arg));

                  { LogicObject invarg = null;
                    Cons iter004 = arg000.variableValueInverse();

                    for (;!(iter004 == Stella.NIL); iter004 = iter004.rest) {
                      invarg = ((LogicObject)(iter004.value));
                      { Proposition prop = null;
                        Iterator iter005 = Logic.unfilteredDependentPropositions(invarg, relationref).allocateIterator();

                        while (iter005.nextP()) {
                          prop = ((Proposition)(iter005.value));
                          if ((((Surrogate)(prop.operator)) == relationref) &&
                              (!(prop == self))) {
                            candidatepropositions.insertNew(prop);
                          }
                        }
                      }
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
      { Proposition prop = null;
        Cons iter006 = candidatepropositions.theConsList;

        for (;!(iter006 == Stella.NIL); iter006 = iter006.rest) {
          prop = ((Proposition)(iter006.value));
          { boolean alwaysP000 = true;

            { Stella_Object arg1 = null;
              Vector vector001 = self.arguments;
              int index001 = 0;
              int length001 = vector001.length();
              Stella_Object arg2 = null;
              Vector vector002 = prop.arguments;
              int index002 = 0;
              int length002 = vector002.length();
              int i = Stella.NULL_INTEGER;
              int iter007 = 1;

              loop007 : for (;(index001 < length001) &&
                        (index002 < length002); 
                    index001 = index001 + 1,
                    index002 = index002 + 1,
                    iter007 = iter007 + 1) {
                arg1 = (vector001.theArray)[index001];
                arg2 = (vector002.theArray)[index002];
                i = iter007;
                if (!(i == nofargs)) {
                  if (!Stella_Object.eqlP(Logic.innermostOf(arg1), Logic.innermostOf(arg2))) {
                    alwaysP000 = false;
                    break loop007;
                  }
                }
              }
            }
            if (alwaysP000) {
              Proposition.equateValues(self, Logic.innermostOf(self.arguments.last()), Logic.innermostOf(prop.arguments.last()));
            }
          }
        }
      }
      candidatepropositions.free();
    }
  }

  public static void evaluateEquivalentProposition(Proposition self) {
    { Vector arguments = self.arguments;
      Stella_Object firstarg = Logic.innermostOf((arguments.theArray)[0]);
      Stella_Object secondarg = Logic.innermostOf((arguments.theArray)[1]);

      if (Proposition.trueP(self)) {
        if (Proposition.defaultTrueP(self)) {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: INTERNAL ERROR: DON'T KNOW YET HOW TO EQUATE THINGS BY DEFAULT.");
        }
        { Cons firstargtypes = Logic.allAssertedTypes(firstarg);
          Cons secondargtypes = Logic.allAssertedTypes(secondarg);

          { NamedDescription type1 = null;
            Cons iter000 = firstargtypes;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              type1 = ((NamedDescription)(iter000.value));
              { boolean foundP000 = false;

                { NamedDescription type2 = null;
                  Cons iter001 = secondargtypes;

                  loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                    type2 = ((NamedDescription)(iter001.value));
                    if (Description.disjointTermsP(type1, type2)) {
                      foundP000 = true;
                      break loop001;
                    }
                  }
                }
                if (foundP000) {
                  Proposition.signalUnificationClash(self, firstarg, secondarg);
                }
              }
            }
          }
        }
        Proposition.equateValues(self, firstarg, secondarg);
      }
      else if (Stella_Object.eqlP(firstarg, secondarg)) {
        Proposition.assignTruthValue(self, Stella.TRUE_WRAPPER);
      }
      else if ((!Logic.skolemP(firstarg)) &&
          (!Logic.skolemP(secondarg))) {
        Proposition.assignTruthValue(self, Stella.FALSE_WRAPPER);
      }
    }
  }

  public static void evaluateNotProposition(Proposition self) {
    { Proposition argument = ((Proposition)((self.arguments.theArray)[0]));

      if (Proposition.trueP(argument) ||
          Proposition.falseP(argument)) {
        Proposition.assignTruthValue(self, TruthValue.invertTruthValue(((TruthValue)(Stella_Object.accessInContext(argument.truthValue, argument.homeContext, false)))));
      }
      if (Proposition.trueP(self) ||
          Proposition.falseP(self)) {
        Proposition.assignTruthValue(argument, TruthValue.invertTruthValue(((TruthValue)(Stella_Object.accessInContext(self.truthValue, self.homeContext, false)))));
      }
    }
  }

  public static void evaluateOrProposition(Proposition self) {
    { Vector arguments = self.arguments;

      if (Proposition.falseP(self)) {
        { Proposition arg = null;
          Vector vector000 = arguments;
          int index000 = 0;
          int length000 = vector000.length();

          for (;index000 < length000; index000 = index000 + 1) {
            arg = ((Proposition)((vector000.theArray)[index000]));
            Proposition.assignTruthValue(arg, ((TruthValue)(Stella_Object.accessInContext(self.truthValue, self.homeContext, false))));
          }
        }
      }
      else if (Proposition.trueP(self)) {
        { Proposition onlyunboundarg = null;
          boolean toucheddefaultP = Proposition.defaultTrueP(self);

          { Proposition arg = null;
            Vector vector001 = arguments;
            int index001 = 0;
            int length001 = vector001.length();

            for (;index001 < length001; index001 = index001 + 1) {
              arg = ((Proposition)((vector001.theArray)[index001]));
              if (Proposition.trueP(arg)) {
                return;
              }
              else if (Proposition.unknownP(arg)) {
                if (onlyunboundarg != null) {
                  return;
                }
                onlyunboundarg = arg;
              }
              else if (Proposition.defaultFalseP(arg)) {
                toucheddefaultP = true;
              }
            }
          }
          if (onlyunboundarg != null) {
            Proposition.assignTruthValue(onlyunboundarg, Logic.defaultifyTruthValue(true, toucheddefaultP));
          }
          else {
            Proposition.assignTruthValue(self, Logic.defaultifyTruthValue(false, toucheddefaultP));
          }
        }
      }
      else {
        { boolean unboundargP = false;
          boolean toucheddefaultP = false;

          { Proposition arg = null;
            Vector vector002 = arguments;
            int index002 = 0;
            int length002 = vector002.length();

            for (;index002 < length002; index002 = index002 + 1) {
              arg = ((Proposition)((vector002.theArray)[index002]));
              if (Proposition.trueP(arg)) {
                if (Proposition.defaultTrueP(arg)) {
                  Proposition.assignTruthValue(self, Logic.DEFAULT_TRUE_TRUTH_VALUE);
                }
                else {
                  {
                    Proposition.assignTruthValue(self, Stella.TRUE_WRAPPER);
                    return;
                  }
                }
              }
              else if (Proposition.unknownP(arg)) {
                unboundargP = true;
              }
              else if (Proposition.defaultFalseP(arg)) {
                toucheddefaultP = true;
              }
            }
          }
          if ((!unboundargP) &&
              (!Proposition.defaultTrueP(self))) {
            Proposition.assignTruthValue(self, Logic.defaultifyTruthValue(false, toucheddefaultP));
          }
        }
      }
    }
  }

  public static void evaluateAndProposition(Proposition self) {
    { Vector arguments = self.arguments;

      if (Proposition.trueP(self)) {
        { Proposition arg = null;
          Vector vector000 = arguments;
          int index000 = 0;
          int length000 = vector000.length();

          for (;index000 < length000; index000 = index000 + 1) {
            arg = ((Proposition)((vector000.theArray)[index000]));
            Proposition.assignTruthValue(arg, ((TruthValue)(Stella_Object.accessInContext(self.truthValue, self.homeContext, false))));
          }
        }
      }
      else if (Proposition.falseP(self)) {
        { Proposition onlyunboundarg = null;
          boolean toucheddefaultP = Proposition.defaultFalseP(self);

          { Proposition arg = null;
            Vector vector001 = arguments;
            int index001 = 0;
            int length001 = vector001.length();

            for (;index001 < length001; index001 = index001 + 1) {
              arg = ((Proposition)((vector001.theArray)[index001]));
              if (Proposition.falseP(arg)) {
                return;
              }
              else if (Proposition.unknownP(arg)) {
                if (onlyunboundarg != null) {
                  return;
                }
                onlyunboundarg = arg;
              }
              else if (Proposition.defaultTrueP(arg)) {
                toucheddefaultP = true;
              }
            }
          }
          if (onlyunboundarg != null) {
            Proposition.assignTruthValue(onlyunboundarg, Logic.defaultifyTruthValue(false, toucheddefaultP));
          }
          else {
            Proposition.assignTruthValue(self, Logic.defaultifyTruthValue(true, toucheddefaultP));
          }
        }
      }
      else {
        { boolean unboundargP = false;
          boolean toucheddefaultP = false;

          { Proposition arg = null;
            Vector vector002 = arguments;
            int index002 = 0;
            int length002 = vector002.length();

            for (;index002 < length002; index002 = index002 + 1) {
              arg = ((Proposition)((vector002.theArray)[index002]));
              if (Proposition.falseP(arg)) {
                if (Proposition.defaultFalseP(arg)) {
                  Proposition.assignTruthValue(self, Logic.DEFAULT_FALSE_TRUTH_VALUE);
                }
                else {
                  {
                    Proposition.assignTruthValue(self, Stella.FALSE_WRAPPER);
                    return;
                  }
                }
              }
              else if (Proposition.unknownP(arg)) {
                unboundargP = true;
              }
              else if (Proposition.defaultTrueP(arg)) {
                toucheddefaultP = true;
              }
            }
          }
          if ((!unboundargP) &&
              (!Proposition.defaultFalseP(self))) {
            Proposition.assignTruthValue(self, Logic.defaultifyTruthValue(true, toucheddefaultP));
          }
        }
      }
    }
  }

  public static void evaluateNewProposition(Proposition self) {
    if (Logic.descriptionModeP() ||
        ((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.FALSE_WRAPPER))).wrapperValue) {
      return;
    }
    { World world = Logic.lookupConstraintPropagationWorld(((Context)(Stella.$CONTEXT$.get())));

      if (world != null) {
        { Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Stella.$CONTEXT$, world);
            Proposition.evaluateProposition(self);
            if (!Proposition.unknownP(self)) {
              if ((Stella.$TRACED_KEYWORDS$ != null) &&
                  Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_PROPAGATE)) {
                Stella.STANDARD_OUTPUT.nativeStream.println("evaluate-new-proposition:  " + self);
              }
              { Proposition prop = null;
                Iterator iter000 = self.dependentPropositions.allocateIterator();

                while (iter000.nextP()) {
                  prop = ((Proposition)(iter000.value));
                  Proposition.evaluateProposition(prop);
                }
              }
            }

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
          }
        }
      }
    }
  }

  public void reactToInferenceUpdate() {
    { Proposition self = this;

      Proposition.postForEvaluation(self, ((Context)(Stella.$CONTEXT$.get())));
      { Proposition prop = null;
        Iterator iter000 = self.dependentPropositions.allocateIterator();

        while (iter000.nextP()) {
          prop = ((Proposition)(iter000.value));
          Proposition.postForEvaluation(prop, ((Context)(Stella.$CONTEXT$.get())));
        }
      }
      if (((Boolean)(Logic.$FILLINGCONSTRAINTPROPAGATIONQUEUESp$.get())).booleanValue()) {
        Proposition.postToForwardChainingQueue(self, ((World)(((Context)(Stella.$CONTEXT$.get())))));
      }
    }
  }

  public static boolean applicableForwardRuleP(Proposition rule, Vector arguments) {
    { Description antecedentdescription = ((Description)((rule.arguments.theArray)[0]));

      return (Proposition.trueP(rule) &&
          (arguments.length() == antecedentdescription.ioVariables.length()));
    }
  }

  public static void traceForwardRule(Proposition rule, Proposition trigger, Cons consequents) {
    if ((consequents != null) &&
        (!(consequents == Stella.NIL))) {
      { int indent = 11;

        {
          Stella.STANDARD_OUTPUT.nativeStream.println("RUNNING FORWARD RULE:");
          Stella.STANDARD_OUTPUT.nativeStream.print("  TRIGGER: ");
        }
;
        Logic.printFormula(trigger, indent);
        if (Proposition.falseP(trigger)) {
          Stella.STANDARD_OUTPUT.nativeStream.print(")");
        }
        {
          Stella.STANDARD_OUTPUT.nativeStream.println();
          Stella.STANDARD_OUTPUT.nativeStream.print("  RULE:    ");
        }
;
        Logic.printFormula(rule, indent);
        {
          Stella.STANDARD_OUTPUT.nativeStream.println();
          Stella.STANDARD_OUTPUT.nativeStream.print("  RESULT:  ");
        }
;
        if (!(consequents.rest == Stella.NIL)) {
          Stella.STANDARD_OUTPUT.nativeStream.print("(" + Logic.stringifiedSurrogate(Logic.SGT_PL_KERNEL_KB_AND) + " ");
          indent = indent + 5;
        }
        { Proposition c = null;
          Cons iter000 = consequents;
          int i = Stella.NULL_INTEGER;
          int iter001 = 1;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
            c = ((Proposition)(iter000.value));
            i = iter001;
            if (i > 1) {
              Stella.STANDARD_OUTPUT.nativeStream.println();
              { int i000 = Stella.NULL_INTEGER;
                int iter002 = 1;
                int upperBound000 = indent;
                boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

                for (;unboundedP000 ||
                          (iter002 <= upperBound000); iter002 = iter002 + 1) {
                  i000 = iter002;
                  i000 = i000;
                  Stella.STANDARD_OUTPUT.nativeStream.print(" ");
                }
              }
            }
            Logic.printFormula(c, indent);
          }
        }
        if (!(consequents.rest == Stella.NIL)) {
          Stella.STANDARD_OUTPUT.nativeStream.print(")");
          indent = indent - 5;
        }
        Stella.STANDARD_OUTPUT.nativeStream.println();
      }
    }
  }

  public static void postToForwardChainingQueue(Proposition self, World world) {
    if (Proposition.unknownP(self) &&
        (!(self.kind == Logic.KWD_FUNCTION))) {
      return;
    }
    if (world == null) {
      world = ((World)(((Context)(Stella.$CONTEXT$.get()))));
    }
    { PropagationEnvironment environment = Logic.getPropagationEnvironment(world);
      NamedDescription description = null;

      { Keyword testValue000 = self.kind;

        if ((testValue000 == Logic.KWD_ISA) ||
            ((testValue000 == Logic.KWD_PREDICATE) ||
             (testValue000 == Logic.KWD_FUNCTION))) {
          if (environment.forwardChainingSet.memberP(self)) {
            return;
          }
          description = Logic.getDescription(((Surrogate)(self.operator)));
          if ((description != null) &&
              Description.hasForwardChainingRulesP(description, self)) {
            environment.forwardChainingSet.insert(self);
            environment.forwardChainingQueue.insert(self);
          }
        }
        else {
        }
      }
    }
  }

  /** Push 'self' onto the evaluation queue (unless it's already there).
   * @param self
   * @param world
   */
  public static void postForEvaluation(Proposition self, Context world) {
    if (world == null) {
      world = ((Context)(Stella.$CONTEXT$.get()));
    }
    if (!((Boolean)(Logic.$FILLINGCONSTRAINTPROPAGATIONQUEUESp$.get())).booleanValue()) {
      { Object old$Context$000 = Stella.$CONTEXT$.get();
        Object old$Module$000 = Stella.$MODULE$.get();

        try {
          Native.setSpecial(Stella.$CONTEXT$, world);
          Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
          Proposition.evaluateProposition(self);
          return;

        } finally {
          Stella.$MODULE$.set(old$Module$000);
          Stella.$CONTEXT$.set(old$Context$000);
        }
      }
    }
    { PropagationEnvironment environment = Logic.getPropagationEnvironment(world);

      if (!(((Keyword)(environment.evaluationStates.lookup(self))) == Logic.KWD_POSTED)) {
        environment.evaluationQueue.insert(self);
        environment.evaluationStates.insertAt(self, Logic.KWD_POSTED);
      }
    }
  }

  /** Record the evaluation <code>state</code> of 'proposition'.
   * @param proposition
   * @param state
   */
  public static void evaluationStateSetter(Proposition proposition, Keyword state) {
    if (!(Logic.descriptionModeP())) {
      Logic.getPropagationEnvironment(((Context)(Stella.$CONTEXT$.get()))).evaluationStates.insertAt(proposition, state);
    }
  }

  /** Return :POSTED if <code>proposition</code> is on the evaluation queue
   * for *context*, :EVALUATED if has been evaluated, or NULL if it has never been evaluated.
   * @param proposition
   * @return Keyword
   */
  public static Keyword evaluationState(Proposition proposition) {
    if (Logic.descriptionModeP()) {
      return (null);
    }
    else {
      return (((Keyword)(Logic.getPropagationEnvironment(((Context)(Stella.$CONTEXT$.get()))).evaluationStates.lookup(proposition))));
    }
  }

  public static void updateDescriptionExtension(Proposition self) {
    if (Logic.descriptionModeP() ||
        ((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.FALSE_WRAPPER))).wrapperValue) {
      return;
    }
    { Keyword testValue000 = self.kind;

      if ((testValue000 == Logic.KWD_ISA) ||
          ((testValue000 == Logic.KWD_PREDICATE) ||
           (testValue000 == Logic.KWD_FUNCTION))) {
        { NamedDescription description = Logic.getDescription(((Surrogate)(self.operator)));

          { Stella_Object arg = null;
            Vector vector000 = self.arguments;
            int index000 = 0;
            int length000 = vector000.length();

            for (;index000 < length000; index000 = index000 + 1) {
              arg = (vector000.theArray)[index000];
              { Surrogate testValue001 = Stella_Object.safePrimaryType(arg);

                if (Surrogate.subtypeOfP(testValue001, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
                  { PatternVariable arg000 = ((PatternVariable)(arg));

                    return;
                  }
                }
                else if (Surrogate.subtypeOfP(testValue001, Logic.SGT_LOGIC_SKOLEM)) {
                  { Skolem arg000 = ((Skolem)(arg));

                    if ((NamedDescription.classDescriptionP(description) &&
                        Logic.literalTypeP(description.surrogateValueInverse)) ||
                        (((Boolean)(Logic.$SUPPRESSINSERTIONINTOCLASSEXTENSIONp$.get())).booleanValue() ||
                         ((BooleanWrapper)(KeyValueList.dynamicSlotValue(arg000.dynamicSlots, Logic.SYM_LOGIC_HYPOTHESIZED_INSTANCEp, Stella.FALSE_WRAPPER))).wrapperValue)) {
                      return;
                    }
                  }
                }
                else if (Surrogate.subtypeOfP(testValue001, Logic.SGT_LOGIC_LOGIC_OBJECT)) {
                  { LogicObject arg000 = ((LogicObject)(arg));

                    if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(arg000.dynamicSlots, Logic.SYM_LOGIC_HYPOTHESIZED_INSTANCEp, Stella.FALSE_WRAPPER))).wrapperValue) {
                      return;
                    }
                  }
                }
                else {
                }
              }
            }
          }
          NamedDescription.getDescriptionExtension(description, true);
          if (!((Boolean)(Logic.$LOADINGREGENERABLEOBJECTSp$.get())).booleanValue()) {
            description.extension.insert(self);
          }
        }
      }
      else {
      }
    }
  }

  public static Proposition findMatchingConceivedProposition(Proposition goal) {
    { Keyword testValue000 = goal.kind;

      if ((testValue000 == Logic.KWD_PREDICATE) ||
          ((testValue000 == Logic.KWD_FUNCTION) ||
           ((testValue000 == Logic.KWD_ISA) ||
            (testValue000 == Logic.KWD_EQUIVALENT)))) {
        { Stella_Object backlinkedargument = Proposition.selectArgumentWithBacklinks(goal, new Object[1]);

          if (backlinkedargument == null) {
            return (null);
          }
          { Proposition value000 = null;

            { Proposition p = null;
              Iterator iter000 = Logic.unfilteredDependentPropositions(backlinkedargument, ((Surrogate)(goal.operator))).allocateIterator();

              loop000 : while (iter000.nextP()) {
                p = ((Proposition)(iter000.value));
                if ((((Surrogate)(p.operator)) == goal.operator) &&
                    Proposition.argumentsMatchArgumentsP(p, goal)) {
                  value000 = p;
                  break loop000;
                }
              }
            }
            { Proposition value001 = value000;

              return (value001);
            }
          }
        }
      }
      else {
        return (goal);
      }
    }
  }

  public static SequenceIndex findSimilarPropositions(Proposition self) {
    if (self.kind == Logic.KWD_FUNCTION) {
      { Stella_Object arg = null;
        Iterator iter000 = self.arguments.butLast();

        while (iter000.nextP()) {
          arg = iter000.value;
          if (Logic.instanceHasBacklinksP(Logic.valueOf(arg))) {
            return (Logic.unfilteredDependentPropositions(Logic.valueOf(arg), ((Surrogate)(self.operator))));
          }
        }
      }
    }
    else {
      { Stella_Object arg = null;
        Vector vector000 = self.arguments;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          if (Logic.instanceHasBacklinksP(arg)) {
            return (Logic.unfilteredDependentPropositions(arg, ((Surrogate)(self.operator))));
          }
        }
      }
    }
    Proposition.rewrapPropositionArguments(self);
    { Stella_Object arg = null;
      Vector vector001 = self.arguments;
      int index001 = 0;
      int length001 = vector001.length();

      for (;index001 < length001; index001 = index001 + 1) {
        arg = (vector001.theArray)[index001];
        if ((arg != null) &&
            Logic.instanceHasBacklinksP(arg)) {
          return (Logic.unfilteredDependentPropositions(arg, ((Surrogate)(self.operator))));
        }
      }
    }
    return (Logic.NIL_NON_PAGING_INDEX);
  }

  public static Stella_Object selectArgumentWithBacklinks(Proposition proposition, Object [] MV_returnarray) {
    { Surrogate relation = ((Surrogate)(proposition.operator));
      Keyword kind = proposition.kind;
      Stella_Object value = null;
      int count = Stella.NULL_INTEGER;
      int lowestbacklinkcount = Stella.NULL_INTEGER;
      Stella_Object bestargument = null;
      boolean founddiscouragedargumentP = false;

      { Stella_Object arg = null;
        Vector vector000 = proposition.arguments;
        int index000 = 0;
        int length000 = vector000.length();

        loop000 : for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          value = Logic.argumentBoundTo(arg);
          if (value != null) {
            if (false) {
              founddiscouragedargumentP = true;
              continue loop000;
            }
            count = Logic.countBacklinksOnRelation(value, kind, relation);
            if ((count != Stella.NULL_INTEGER) &&
                ((lowestbacklinkcount == Stella.NULL_INTEGER) ||
                 (count < lowestbacklinkcount))) {
              lowestbacklinkcount = count;
              bestargument = value;
            }
          }
        }
      }
      if ((lowestbacklinkcount == Stella.NULL_INTEGER) &&
          founddiscouragedargumentP) {
        { Stella_Object arg = null;
          Vector vector001 = proposition.arguments;
          int index001 = 0;
          int length001 = vector001.length();

          loop001 : for (;index001 < length001; index001 = index001 + 1) {
            arg = (vector001.theArray)[index001];
            value = Logic.argumentBoundTo(arg);
            if (value != null) {
              if (!false) {
                continue loop001;
              }
              count = Logic.countBacklinksOnRelation(value, kind, relation);
              if ((count != Stella.NULL_INTEGER) &&
                  ((lowestbacklinkcount == Stella.NULL_INTEGER) ||
                   (count < lowestbacklinkcount))) {
                lowestbacklinkcount = count;
                bestargument = value;
              }
            }
          }
        }
      }
      if (lowestbacklinkcount == Stella.NULL_INTEGER) {
        { Stella_Object _return_temp = null;

          MV_returnarray[0] = BooleanWrapper.wrapBoolean(false);
          return (_return_temp);
        }
      }
      else {
        { Stella_Object _return_temp = bestargument;

          MV_returnarray[0] = BooleanWrapper.wrapBoolean(false);
          return (_return_temp);
        }
      }
    }
  }

  public static void surrogatifyDiscouragedArguments(Proposition self) {
  }

  public static boolean inheritsTruthFromMasterP(Proposition self) {
    { Proposition master = ((Proposition)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_MASTER_PROPOSITION, null)));

      if ((master != null) &&
          Proposition.trueP(master)) {
        Proposition.assignTruthValue(self, Stella.TRUE_WRAPPER);
        return (true);
      }
    }
    return (false);
  }

  public static void rewrapPropositionArguments(Proposition self) {
    { Stella_Object arg = null;
      Vector vector000 = self.arguments;
      int index000 = 0;
      int length000 = vector000.length();
      int i = Stella.NULL_INTEGER;
      int iter000 = 0;

      for (;index000 < length000; index000 = index000 + 1, iter000 = iter000 + 1) {
        arg = (vector000.theArray)[index000];
        i = iter000;
        if ((arg != null) &&
            Logic.rewrapIthArgumentP(arg, self, i)) {
          (self.arguments.theArray)[i] = (Logic.rewrapArgument(arg));
        }
      }
    }
  }

  public static String propositionHeadSortString(Proposition p) {
    if (p.kind == Logic.KWD_IMPLIES) {
      if (Stella_Object.isaP((p.arguments.theArray)[0], Logic.SGT_LOGIC_DESCRIPTION) &&
          Stella_Object.isaP((p.arguments.theArray)[1], Logic.SGT_LOGIC_DESCRIPTION)) {
        return ("FORALL");
      }
      else {
        return ("SUBSET-OF");
      }
    }
    else {
      return (p.operator.symbolName);
    }
  }

  public static boolean propositionLessThanP(Proposition p1, Proposition p2) {
    { String operator1 = p1.operator.symbolName;
      String operator2 = p2.operator.symbolName;
      Vector arguments1 = p1.arguments;
      Vector arguments2 = p2.arguments;
      int end1 = arguments1.length() - 1;
      int end2 = arguments2.length() - 1;
      Stella_Object a1 = null;
      Stella_Object a2 = null;

      if (Logic.stringTermLessP(operator1, operator2)) {
        return (true);
      }
      if (Logic.stringTermLessP(operator2, operator1)) {
        return (false);
      }
      { int i1 = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = end1;
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;
        int i2 = Stella.NULL_INTEGER;
        int iter001 = 0;
        int upperBound001 = end2;
        boolean unboundedP001 = upperBound001 == Stella.NULL_INTEGER;

        for (;(unboundedP000 ||
                  (iter000 <= upperBound000)) &&
                  (unboundedP001 ||
                   (iter001 <= upperBound001)); iter000 = iter000 + 1, iter001 = iter001 + 1) {
          i1 = iter000;
          i2 = iter001;
          a1 = (arguments1.theArray)[i1];
          a2 = (arguments2.theArray)[i2];
          if ((i1 == end1) &&
              ((i2 == end2) &&
               (Logic.functionOutputSkolemP(a1) &&
                (Logic.functionOutputSkolemP(a2) &&
                 ((((Skolem)(a1)).definingProposition == p1) &&
                  ((((Skolem)(a2)).definingProposition == p2) &&
                   (Stella_Object.eqlP(Logic.valueOf(a1), a1) &&
                    Stella_Object.eqlP(Logic.valueOf(a2), a2)))))))) {
            return (false);
          }
          if (Logic.logicFormLessP(a1, a2)) {
            return (true);
          }
          else {
            if (Logic.logicFormLessP(a2, a1)) {
              return (false);
            }
          }
        }
      }
      return (end1 < end2);
    }
  }

  public static void destroyRedundantProposition(Proposition proposition) {
    proposition.homeContext = null;
    Proposition.destroyProposition(proposition);
  }

  /** Retract and destroy the proposition 'proposition'.
   * Recursively destroy all propositions that reference 'proposition'.
   * Also, destroy all satellite propositions of 'proposition'.
   * @param proposition
   * @return Proposition
   */
  public static Proposition destroyProposition(Proposition proposition) {
    if (proposition.deletedP()) {
      return (proposition);
    }
    proposition.deletedPSetter(true);
    if (((Surrogate)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_STELLA_SURROGATE_VALUE_INVERSE, null))) != null) {
      ((Surrogate)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_STELLA_SURROGATE_VALUE_INVERSE, null))).surrogateValue = null;
    }
    { Stella_Object arg = null;
      Vector vector000 = proposition.arguments;
      int index000 = 0;
      int length000 = vector000.length();

      for (;index000 < length000; index000 = index000 + 1) {
        arg = (vector000.theArray)[index000];
        if ((arg != null) &&
            (!arg.deletedP())) {
          if (Logic.skolemP(arg) &&
              (((Skolem)(arg)).definingProposition == proposition)) {
            LogicObject.destroyTerm(((LogicObject)(arg)));
          }
          if (((HashSet)(Logic.$DEFERRED_TERMS_TO_UNLINK$.get())) != null) {
            ((HashSet)(Logic.$DEFERRED_TERMS_TO_UNLINK$.get())).insert(arg);
          }
          else {
            Logic.removeDependentPropositionLink(arg, proposition);
          }
        }
      }
    }
    { Stella_Object dep = null;
      Iterator iter000 = proposition.dependentPropositions.copy().allocateIterator();

      while (iter000.nextP()) {
        dep = iter000.value;
        Proposition.destroyProposition(((Proposition)(dep)));
      }
    }
    { Proposition satellite = null;
      Cons iter001 = proposition.satellitePropositions().copy().theConsList;

      for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
        satellite = ((Proposition)(iter001.value));
        Proposition.destroyProposition(satellite);
      }
    }
    if (((Proposition)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_MASTER_PROPOSITION, null))) != null) {
      ((Proposition)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_MASTER_PROPOSITION, null))).satellitePropositions().remove(proposition);
    }
    if (!(proposition.homeContext == null)) {
      Logic.handleOutOfDateInferenceCache(Logic.KWD_RETRACT, proposition);
    }
    proposition.dependentPropositions = null;
    proposition.operator = null;
    proposition.arguments = null;
    proposition.homeContext = null;
    proposition.truthValue = null;
    proposition.dynamicSlots = null;
    return (proposition);
  }

  public static boolean deletedPropositionP(Proposition self) {
    if (self.kind == Logic.KWD_DELETED) {
      return (true);
    }
    return (false);
  }

  public boolean deletedPSetter(boolean value) {
    { Proposition self = this;

      if (value) {
        self.kind = Logic.KWD_DELETED;
      }
      return (value);
    }
  }

  public boolean deletedP() {
    { Proposition self = this;

      return (Proposition.deletedPropositionP(self));
    }
  }

  /** Retract the truth, falsity or inconsistency of the proposition <code>self</code>.
   * @param self
   */
  public static void unassertProposition(Proposition self) {
    if (self != null) {
      { boolean equivalenceP = self.kind == Logic.KWD_EQUIVALENT;

        if (Proposition.trueP(self)) {
          if (equivalenceP) {
            Proposition.updateEquivalenceProposition(self, Logic.KWD_RETRACT_TRUE);
          }
          else {
            Proposition.updatePropositionTruthValue(self, Logic.KWD_RETRACT_TRUE);
          }
        }
        else if (Proposition.falseP(self)) {
          if (equivalenceP) {
            Proposition.updateEquivalenceProposition(self, Logic.KWD_RETRACT_FALSE);
          }
          else {
            Proposition.updatePropositionTruthValue(self, Logic.KWD_RETRACT_FALSE);
          }
        }
        else if (Proposition.inconsistentP(self)) {
          if (equivalenceP) {
            Proposition.deassignTruthValue(self, Logic.KWD_RETRACT_INCONSISTENT);
            Proposition.updateEquivalenceProposition(self, Logic.KWD_RETRACT_TRUE);
            Proposition.updateEquivalenceProposition(self, Logic.KWD_RETRACT_FALSE);
          }
          else {
            Proposition.deassignTruthValue(self, Logic.KWD_RETRACT_INCONSISTENT);
            Proposition.updatePropositionTruthValue(self, Logic.KWD_RETRACT_TRUE);
            Proposition.updatePropositionTruthValue(self, Logic.KWD_RETRACT_FALSE);
          }
        }
      }
    }
  }

  public static Cons helpUpdateTopLevelProposition(Proposition proposition, Keyword updatemode) {
    if (proposition == null) {
      return (null);
    }
    if (Proposition.lookupAnnotation(proposition, Logic.KWD_CONFIDENCE_LEVEL) == Logic.KWD_DEFAULT) {
      updatemode = Logic.defaultifyUpdateMode(updatemode);
      if ((updatemode == Logic.KWD_PRESUME_TRUE) ||
          (updatemode == Logic.KWD_PRESUME_FALSE)) {
        Proposition.removeAnnotation(proposition, Logic.KWD_CONFIDENCE_LEVEL);
      }
    }
    if (Proposition.nativeSlotPropositionP(proposition)) {
      return (Proposition.updateNativeSlotProposition(proposition, updatemode));
    }
    { Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$CONTEXT$, Logic.getTopLevelUpdateContext());
        { Keyword testValue000 = proposition.kind;

          if (testValue000 == Logic.KWD_AND) {
            { Cons propositions = Stella.NIL;

              { Stella_Object arg = null;
                Vector vector000 = proposition.arguments;
                int index000 = 0;
                int length000 = vector000.length();

                for (;index000 < length000; index000 = index000 + 1) {
                  arg = (vector000.theArray)[index000];
                  { Proposition p = null;
                    Cons iter000 = Proposition.helpUpdateTopLevelProposition(((Proposition)(arg)), updatemode);
                    Cons collect000 = null;

                    for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                      p = ((Proposition)(iter000.value));
                      if ((p != null) &&
                          (!p.deletedP())) {
                        if (collect000 == null) {
                          {
                            collect000 = Cons.cons(p, Stella.NIL);
                            if (propositions == Stella.NIL) {
                              propositions = collect000;
                            }
                            else {
                              Cons.addConsToEndOfConsList(propositions, collect000);
                            }
                          }
                        }
                        else {
                          {
                            collect000.rest = Cons.cons(p, Stella.NIL);
                            collect000 = collect000.rest;
                          }
                        }
                      }
                    }
                  }
                }
              }
              Proposition.destroyRedundantProposition(proposition);
              return (propositions);
            }
          }
          else if (testValue000 == Logic.KWD_EQUIVALENT) {
            proposition = Proposition.updateEquivalenceProposition(proposition, updatemode);
            if (proposition == null) {
              return (Stella.NIL);
            }
          }
          else if (testValue000 == Logic.KWD_NOT) {
            { Stella_Object argument = (proposition.arguments.theArray)[0];

              if ((updatemode == Logic.KWD_ASSERT_TRUE) ||
                  ((updatemode == Logic.KWD_ASSERT_FALSE) ||
                   ((updatemode == Logic.KWD_PRESUME_TRUE) ||
                    ((updatemode == Logic.KWD_PRESUME_FALSE) ||
                     ((updatemode == Logic.KWD_RETRACT_TRUE) ||
                      (updatemode == Logic.KWD_RETRACT_FALSE)))))) {
                Proposition.updatePropositionTruthValue(((Proposition)(argument)), Logic.invertUpdateMode(updatemode));
                Proposition.destroyRedundantProposition(proposition);
                if ((argument != null) &&
                    (!argument.deletedP())) {
                  return (Cons.consList(Cons.cons(argument, Stella.NIL)));
                }
                else {
                  return (Stella.NIL);
                }
              }
              else {
              }
            }
          }
          else if (testValue000 == Logic.KWD_EXISTS) {
            return (Proposition.helpUpdateTopLevelProposition(Proposition.skolemizeExistsProposition(proposition), updatemode));
          }
          else {
          }
        }
        if (!(proposition.kind == Logic.KWD_FUNCTION)) {
          Proposition.updatePropositionTruthValue(proposition, updatemode);
        }
        if (proposition.deletedP()) {
          return (Stella.NIL);
        }
        else {
          return (Cons.consList(Cons.cons(proposition, Stella.NIL)));
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
      }
    }
  }

  public static Proposition skolemizeExistsProposition(Proposition existsproposition) {
    { KeyValueMap mapping = KeyValueMap.newKeyValueMap();
      Proposition skolemizedproposition = null;

      { PatternVariable var = null;
        Vector vector000 = ((Vector)(KeyValueList.dynamicSlotValue(existsproposition.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          var = ((PatternVariable)((vector000.theArray)[index000]));
          PatternVariable.createSkolemForUnmappedVariable(var, mapping);
        }
      }
      skolemizedproposition = Proposition.recursivelyFastenDownPropositions(Proposition.inheritProposition(((Proposition)((existsproposition.arguments.theArray)[0])), mapping), false);
      Proposition.destroyRedundantProposition(existsproposition);
      return (skolemizedproposition);
    }
  }

  public static Proposition updateEquivalenceProposition(Proposition proposition, Keyword updatemode) {
    { Stella_Object term1 = (proposition.arguments.theArray)[0];
      Stella_Object term2 = (proposition.arguments.theArray)[1];

      if (Logic.skolemP(term1) &&
          Logic.skolemP(term2)) {
        if (updatemode == Logic.KWD_PRESUME_TRUE) {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                {
                  stream000.nativeStream.println("ERROR: Equating two skolems by default is not yet supported.");
                  stream000.nativeStream.println(".");
                }
;
                Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
              }
            }
            throw ((PropositionError)(PropositionError.newPropositionError(stream000.theStringReader()).fillInStackTrace()));
          }
        }
        return (proposition);
      }
      if ((updatemode == Logic.KWD_ASSERT_TRUE) ||
          (updatemode == Logic.KWD_PRESUME_TRUE)) {
        Proposition.updatePropositionTruthValue(proposition, updatemode);
        if (Logic.clipValueP(term1, term2)) {
        }
        else if (Logic.clipValueP(term2, term1)) {
        }
        else {
          Proposition.equateValues(proposition, Logic.valueOf(term1), Logic.valueOf(term2));
        }
      }
      else if (updatemode == Logic.KWD_RETRACT_TRUE) {
        if (Logic.unequateValuesP(term1, term2)) {
        }
        else if (Logic.unequateValuesP(term2, term1)) {
        }
      }
      else if (updatemode == Logic.KWD_CONCEIVE) {
        return (proposition);
      }
      else {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("`" + updatemode + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
      if (Logic.functionOutputSkolemP(term1) &&
          (!Logic.functionOutputSkolemP(term2))) {
        Proposition.runUpdatePropositionDemon(proposition, updatemode);
        return ((proposition.deletedP() ? null : ((Skolem)(term1)).definingProposition));
      }
      if (Logic.functionOutputSkolemP(term2) &&
          (!Logic.functionOutputSkolemP(term1))) {
        Proposition.runUpdatePropositionDemon(proposition, updatemode);
        return ((proposition.deletedP() ? null : ((Skolem)(term2)).definingProposition));
      }
      return (null);
    }
  }

  public static Skolem getSkolemAndValueTerms(Proposition proposition, Object [] MV_returnarray) {
    { Stella_Object term1 = (proposition.arguments.theArray)[0];
      Stella_Object term2 = (proposition.arguments.theArray)[1];

      if (Logic.functionOutputSkolemP(term1)) {
        { Skolem _return_temp = ((Skolem)(term1));

          MV_returnarray[0] = term2;
          return (_return_temp);
        }
      }
      else if (Logic.functionOutputSkolemP(term2)) {
        { Skolem _return_temp = ((Skolem)(term2));

          MV_returnarray[0] = term1;
          return (_return_temp);
        }
      }
      else {
        { Skolem _return_temp = null;

          MV_returnarray[0] = null;
          return (_return_temp);
        }
      }
    }
  }

  public static boolean functionWithDefinedValueP(Proposition proposition) {
    if (!(proposition.kind == Logic.KWD_FUNCTION)) {
      return (false);
    }
    { Stella_Object lastargument = proposition.arguments.last();
      boolean resultP = Logic.testPropertyP(Logic.getDescription(((Surrogate)(proposition.operator))), Logic.SGT_PL_KERNEL_KB_TOTAL) ||
          Logic.extensionalIndividualP(Logic.valueOf(lastargument));

      if (resultP &&
          (!Logic.worldStateP(((Context)(Stella.$CONTEXT$.get()))))) {
        Proposition.assignTruthValue(proposition, Stella.TRUE_WRAPPER);
        if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(lastargument), Logic.SGT_LOGIC_SKOLEM)) {
          { Skolem lastargument000 = ((Skolem)(lastargument));

            if ((lastargument000.skolemType != null) &&
                (!(lastargument000.skolemType == Logic.SGT_STELLA_THING))) {
              { Object old$Evaluationmode$000 = Logic.$EVALUATIONMODE$.get();
                Object old$InvisibleassertionP$000 = Logic.$INVISIBLEASSERTIONp$.get();

                try {
                  Native.setSpecial(Logic.$EVALUATIONMODE$, Logic.KWD_EXTENSIONAL_ASSERTION);
                  Native.setBooleanSpecial(Logic.$INVISIBLEASSERTIONp$, true);
                  Logic.assertIsaProposition(lastargument000, lastargument000.skolemType);

                } finally {
                  Logic.$INVISIBLEASSERTIONp$.set(old$InvisibleassertionP$000);
                  Logic.$EVALUATIONMODE$.set(old$Evaluationmode$000);
                }
              }
            }
          }
        }
        else {
        }
      }
      return (resultP);
    }
  }

  public static Proposition finishCreatingFunctionProposition(Proposition proposition) {
    { int argcount = proposition.arguments.length();
      NamedDescription description = Logic.getDescription(proposition.operator);
      Surrogate type = null;
      Skolem skolem = null;

      if (description != null) {
        type = Logic.unwrapWrappedType(((Surrogate)(description.ioVariableTypes.last())));
      }
      { Object old$Context$000 = Stella.$CONTEXT$.get();
        Object old$Module$000 = Stella.$MODULE$.get();

        try {
          Native.setSpecial(Stella.$CONTEXT$, proposition.homeContext);
          Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
          skolem = Logic.createVariableOrSkolem(type, null);

        } finally {
          Stella.$MODULE$.set(old$Module$000);
          Stella.$CONTEXT$.set(old$Context$000);
        }
      }
      (proposition.arguments.theArray)[(argcount - 1)] = skolem;
      skolem.definingProposition = proposition;
      if (type != null) {
        Skolem.updateSkolemType(skolem, type);
      }
      if (proposition.operator == Logic.SGT_PL_KERNEL_KB_VALUE) {
        proposition = Proposition.normalizeValueFunction(proposition);
      }
      else {
        Proposition.normalizeFunctionProposition(proposition);
      }
      Proposition.verifyArgumentTypesAndCount(proposition);
      if (Stella_Object.isaP(proposition.operator, Logic.SGT_STELLA_SURROGATE)) {
        Proposition.fastenDownOneProposition(proposition, true);
        Proposition.helpFastenDownPropositions(proposition, false);
      }
      return (proposition);
    }
  }

  public static Proposition findDuplicateFunctionProposition(Proposition proposition) {
    if (!Stella_Object.isaP(proposition.operator, Logic.SGT_STELLA_SURROGATE)) {
      return (null);
    }
    else {
      return (Proposition.findDuplicateProposition(proposition));
    }
  }

  public static void verifyForallPropositions(Proposition proposition) {
    { Keyword testValue000 = proposition.kind;

      if (testValue000 == Logic.KWD_FORALL) {
        { Proposition antecedent = ((Proposition)((proposition.arguments.theArray)[0]));
          Proposition consequent = ((Proposition)((proposition.arguments.theArray)[1]));
          List antvars = null;
          List cqvars = null;

          if (antecedent.kind == Logic.KWD_CONSTANT) {
            return;
          }
          antvars = List.list(Stella.NIL);
          cqvars = List.list(Stella.NIL);
          Logic.collectFreeVariables(antecedent, antvars, List.list(Stella.NIL), List.list(Stella.NIL));
          Logic.collectFreeVariables(consequent, cqvars, List.list(Stella.NIL), List.list(Stella.NIL));
          if (!(cqvars.nonEmptyP() &&
              cqvars.subsetP(antvars))) {
            { Object old$Termsourcebeingparsed$000 = Logic.$TERMSOURCEBEINGPARSED$.get();
              Object old$Termunderconstruction$000 = Logic.$TERMUNDERCONSTRUCTION$.get();
              Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();
              Object old$Printmode$000 = Logic.$PRINTMODE$.get();
              Object old$PrettyprintlogicalformsP$000 = Logic.$PRETTYPRINTLOGICALFORMSp$.get();
              Object old$PrettyprintkifP$000 = Logic.$PRETTYPRINTKIFp$.get();

              try {
                Native.setSpecial(Logic.$TERMSOURCEBEINGPARSED$, null);
                Native.setSpecial(Logic.$TERMUNDERCONSTRUCTION$, null);
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Native.setSpecial(Logic.$PRINTMODE$, Logic.KWD_REALISTIC);
                Native.setBooleanSpecial(Logic.$PRETTYPRINTLOGICALFORMSp$, true);
                Native.setBooleanSpecial(Logic.$PRETTYPRINTKIFp$, true);
                cqvars = cqvars.difference(antvars);
                { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    {
                      Stella.STANDARD_WARNING.nativeStream.println("WARNING: Potentially problematic implication rule, consequent variable(s) " + Stella.replaceSubstrings(Native.stringify(cqvars.theConsList), "?", "|V|?"));
                      Stella.STANDARD_WARNING.nativeStream.println("   are not restricted/used by the antecedent: ");
                      Stella.STANDARD_WARNING.nativeStream.println(proposition);
                    }
;
                    Logic.helpSignalPropositionError(Stella.STANDARD_WARNING, Logic.KWD_WARNING);

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                  }
                }

              } finally {
                Logic.$PRETTYPRINTKIFp$.set(old$PrettyprintkifP$000);
                Logic.$PRETTYPRINTLOGICALFORMSp$.set(old$PrettyprintlogicalformsP$000);
                Logic.$PRINTMODE$.set(old$Printmode$000);
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                Logic.$TERMUNDERCONSTRUCTION$.set(old$Termunderconstruction$000);
                Logic.$TERMSOURCEBEINGPARSED$.set(old$Termsourcebeingparsed$000);
              }
            }
          }
        }
      }
      else if (testValue000 == Logic.KWD_AND) {
        { Stella_Object arg = null;
          Vector vector000 = proposition.arguments;
          int index000 = 0;
          int length000 = vector000.length();

          for (;index000 < length000; index000 = index000 + 1) {
            arg = (vector000.theArray)[index000];
            Proposition.verifyForallPropositions(((Proposition)(arg)));
          }
        }
      }
      else {
      }
    }
  }

  public static boolean helpCollectSkolemizedExistsVariablesP(Proposition proposition, List result) {
    { Vector arguments = proposition.arguments;
      int argumentcount = arguments.length();

      if (proposition.kind == Logic.KWD_FUNCTION) {
        argumentcount = argumentcount - 1;
      }
      { Stella_Object arg = null;
        Vector vector000 = arguments;
        int index000 = 0;
        int length000 = vector000.length();
        int i = Stella.NULL_INTEGER;
        int iter000 = 1;
        int upperBound000 = argumentcount;
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

        for (;(index000 < length000) &&
                  (unboundedP000 ||
                   (iter000 <= upperBound000)); index000 = index000 + 1, iter000 = iter000 + 1) {
          arg = (vector000.theArray)[index000];
          i = iter000;
          i = i;
          { Surrogate testValue000 = Stella_Object.safePrimaryType(arg);

            if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PROPOSITION)) {
              { Proposition arg000 = ((Proposition)(arg));

                if (Proposition.helpCollectSkolemizedExistsVariablesP(arg000, result) &&
                    (result == null)) {
                  return (true);
                }
              }
            }
            else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
              { PatternVariable arg000 = ((PatternVariable)(arg));

              }
            }
            else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_SKOLEM)) {
              { Skolem arg000 = ((Skolem)(arg));

                { boolean foundP000 = false;

                  { Proposition prop = null;
                    Iterator iter001 = Logic.unfilteredDependentIsaPropositions(arg000).allocateIterator();

                    loop001 : while (iter001.nextP()) {
                      prop = ((Proposition)(iter001.value));
                      if ((prop.kind == Logic.KWD_ISA) &&
                          (Proposition.trueP(prop) &&
                           BooleanWrapper.coerceWrappedBooleanToBoolean(prop.variableTypeP()))) {
                        foundP000 = true;
                        break loop001;
                      }
                    }
                  }
                  if (foundP000) {
                    if (result != null) {
                      result.insertNew(arg000);
                    }
                    else {
                      return (true);
                    }
                  }
                }
              }
            }
            else {
            }
          }
        }
      }
      if (result != null) {
        return (result.nonEmptyP());
      }
      else {
        return (false);
      }
    }
  }

  public static Vector collectSkolemizedExistsVariables(Proposition proposition) {
    { List skolems = List.newList();
      Vector result = null;

      Proposition.helpCollectSkolemizedExistsVariablesP(proposition, skolems);
      if (skolems.emptyP()) {
        result = Logic.ZERO_VARIABLES_VECTOR;
      }
      else {
        result = Vector.newVector(skolems.length());
      }
      { Skolem skolem = null;
        Cons iter000 = skolems.theConsList;
        int i = Stella.NULL_INTEGER;
        int iter001 = 0;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
          skolem = ((Skolem)(iter000.value));
          i = iter001;
          (result.theArray)[i] = skolem;
        }
      }
      skolems.free();
      return (result);
    }
  }

  public static boolean topLevelExistsPropositionP(Proposition proposition) {
    return ((!Proposition.unknownP(proposition)) &&
        Proposition.helpCollectSkolemizedExistsVariablesP(proposition, null));
  }

  public static void postToCheckTypesAgenda(Proposition self) {
    { int length = Logic.$CHECK_TYPES_AGENDA$.sequenceLength;

      if ((length == 0) ||
          (!(self == ((CheckTypesRecord)((Logic.$CHECK_TYPES_AGENDA$.theArray)[(length - 1)])).proposition))) {
        { CheckTypesRecord self001 = CheckTypesRecord.newCheckTypesRecord();

          self001.proposition = self;
          self001.parentProposition = ((Stella_Object)(Logic.$TERMUNDERCONSTRUCTION$.get()));
          self001.parentDescription = ((Description)(((Stella_Object)(Logic.$DESCRIPTIONUNDERCONSTRUCTION$.get()))));
          self001.module = ((Module)(Stella.$MODULE$.get()));
          Logic.$CHECK_TYPES_AGENDA$.insert(self001);
        }
        length = length + 1;
      }
      if (Stella.integer_mod(length, 100000) == 0) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.STANDARD_WARNING.nativeStream.println("WARNING: Queued " + length + " type violations, consider running `(process-definitions)'");
            Logic.helpSignalPropositionError(Stella.STANDARD_WARNING, Logic.KWD_WARNING);

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
      }
    }
  }

  public static void handleArityViolation(Proposition proposition, int requiredarity) {
    if (((Keyword)(Logic.$TYPECHECKMODE$.get())) == Logic.KWD_POST_TYPE_VIOLATIONS) {
      Proposition.postToCheckTypesAgenda(proposition);
    }
    else if ((((Keyword)(Logic.$TYPECHECKMODE$.get())) == Logic.KWD_SIGNAL_TYPE_VIOLATIONS) ||
        ((((Keyword)(Logic.$TYPECHECKMODE$.get())) == Logic.KWD_REPORT_TYPE_VIOLATIONS) ||
         (((Keyword)(Logic.$TYPECHECKMODE$.get())) == Logic.KWD_AUTOMATICALLY_FIX_TYPE_VIOLATIONS))) {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            {
              stream000.nativeStream.println("ERROR: Too `" + (((proposition.arguments.length() > requiredarity) ? "many" : "few")) + "' arguments in the proposition");
              stream000.nativeStream.println("   `" + Logic.generateTerm(proposition) + "'");
              stream000.nativeStream.println("   Expected `" + requiredarity + "' argument(s)..");
            }
;
            Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        throw ((PropositionError)(PropositionError.newPropositionError(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    else {
      { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

        stream001.nativeStream.print("`" + ((Keyword)(Logic.$TYPECHECKMODE$.get())) + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static void handleArgumentTypeViolation(Proposition proposition, Stella_Object arg, Surrogate requiredtype) {
    if (((Keyword)(Logic.$TYPECHECKMODE$.get())) == Logic.KWD_POST_TYPE_VIOLATIONS) {
      Proposition.postToCheckTypesAgenda(proposition);
    }
    else if (((Keyword)(Logic.$TYPECHECKMODE$.get())) == Logic.KWD_REPORT_TYPE_VIOLATIONS) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          {
            Stella.STANDARD_WARNING.nativeStream.println("WARNING: Type check violation on argument `" + arg + "' in proposition");
            Stella.STANDARD_WARNING.nativeStream.println("   " + proposition + ".");
            Stella.STANDARD_WARNING.nativeStream.println("   Argument must have type `" + requiredtype.symbolName + "'.");
          }
;
          Logic.helpSignalPropositionError(Stella.STANDARD_WARNING, Logic.KWD_WARNING);

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
    }
    else if (((Keyword)(Logic.$TYPECHECKMODE$.get())) == Logic.KWD_SIGNAL_TYPE_VIOLATIONS) {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            {
              stream000.nativeStream.println("ERROR: Type check violation on argument ``" + arg + "'' in proposition");
              stream000.nativeStream.println("   `" + proposition + "'.");
              stream000.nativeStream.println("   Argument must have type ``" + requiredtype.symbolName + "''..");
            }
;
            Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
          }
        }
        throw ((PropositionError)(PropositionError.newPropositionError(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    else if (((Keyword)(Logic.$TYPECHECKMODE$.get())) == Logic.KWD_AUTOMATICALLY_FIX_TYPE_VIOLATIONS) {
      { Proposition isaproposition = Logic.assertIsaProposition(arg, requiredtype);

        KeyValueList.setDynamicSlotValue(isaproposition.dynamicSlots, Logic.SYM_LOGIC_ASSERTED_BY_TYPE_CHECKERp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
      }
    }
    else {
      { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

        stream001.nativeStream.print("`" + ((Keyword)(Logic.$TYPECHECKMODE$.get())) + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static void verifyArgumentTypesAndCount(Proposition proposition) {
    if ((((Keyword)(Logic.$TYPECHECKMODE$.get())) == Logic.KWD_IGNORE_TYPE_VIOLATIONS) ||
        ((!Logic.worldStateP(((Context)(Stella.$CONTEXT$.get())))) ||
         (!Stella_Object.isaP(proposition.operator, Logic.SGT_STELLA_SURROGATE)))) {
      return;
    }
    { NamedDescription description = Logic.getDescription(((Surrogate)(proposition.operator)));
      int argumentcount = proposition.arguments.length();

      { Keyword testValue000 = proposition.kind;

        if ((testValue000 == Logic.KWD_PREDICATE) ||
            ((testValue000 == Logic.KWD_FUNCTION) ||
             (testValue000 == Logic.KWD_ISA))) {
          if (description == null) {
            return;
          }
          { int arity = description.arity();
            boolean variablearityP = !(arity > 0);
            boolean functionP = proposition.kind == Logic.KWD_FUNCTION;

            if ((!variablearityP) &&
                (!(argumentcount == arity))) {
              Proposition.handleArityViolation(proposition, arity);
            }
            { Stella_Object arg = null;
              Vector vector000 = proposition.arguments;
              int index000 = 0;
              int length000 = vector000.length();
              IntegerIntervalIterator i = Stella.interval(1, ((variablearityP &&
                  functionP) ? (argumentcount - 1) : argumentcount));
              Stella_Object type = null;
              Iterator iter000 = NamedDescription.allDomainTypes(description);

              for (;(index000 < length000) &&
                        (i.nextP() &&
                         iter000.nextP()); index000 = index000 + 1) {
                arg = (vector000.theArray)[index000];
                type = iter000.value;
                if ((type != null) &&
                    ((!(type == Logic.SGT_STELLA_THING)) &&
                     (arg != null))) {
                  Logic.verifyOneArgumentType(arg, ((Surrogate)(type)), proposition, description);
                }
              }
            }
            if (functionP) {
              Logic.verifyOneArgumentType(proposition.arguments.last(), ((Surrogate)(description.ioVariableTypes.last())), proposition, description);
            }
          }
        }
        else if (testValue000 == Logic.KWD_EQUIVALENT) {
          { Stella_Object arg1 = (proposition.arguments.theArray)[0];
            Stella_Object arg2 = (proposition.arguments.theArray)[1];
            Surrogate requiredtype = null;
            Stella_Object constrainingarg = null;
            Stella_Object offendingarg = null;
            boolean typeisokP = false;
            Stella_Object substitutevalue = null;

            requiredtype = Logic.safeLogicalType(arg2);
            { Object [] caller_MV_returnarray = new Object[1];

              typeisokP = Logic.checkCoercedTypeP(arg1, requiredtype, false, caller_MV_returnarray);
              substitutevalue = ((Stella_Object)(caller_MV_returnarray[0]));
            }
            if (!Stella_Object.eqlP(arg1, substitutevalue)) {
              (proposition.arguments.theArray)[0] = substitutevalue;
              return;
            }
            else if (!typeisokP) {
              constrainingarg = arg2;
              offendingarg = arg1;
            }
            if (typeisokP) {
              requiredtype = Logic.safeLogicalType(arg1);
              { Object [] caller_MV_returnarray = new Object[1];

                typeisokP = Logic.checkCoercedTypeP(arg2, requiredtype, false, caller_MV_returnarray);
                substitutevalue = ((Stella_Object)(caller_MV_returnarray[0]));
              }
              if (!Stella_Object.eqlP(arg2, substitutevalue)) {
                (proposition.arguments.theArray)[1] = substitutevalue;
                return;
              }
              else if (!typeisokP) {
                constrainingarg = arg1;
                offendingarg = arg2;
              }
            }
            if (!(typeisokP)) {
              { Object old$Termunderconstruction$000 = Logic.$TERMUNDERCONSTRUCTION$.get();

                try {
                  Native.setSpecial(Logic.$TERMUNDERCONSTRUCTION$, ((Stella_Object)(Logic.$TERMUNDERCONSTRUCTION$.get())));
                  if ((((Stella_Object)(Logic.$TERMUNDERCONSTRUCTION$.get())) == null) &&
                      Logic.skolemP(constrainingarg)) {
                    Native.setSpecial(Logic.$TERMUNDERCONSTRUCTION$, ((Skolem)(constrainingarg)).definingProposition);
                  }
                  Proposition.handleArgumentTypeViolation(proposition, offendingarg, requiredtype);

                } finally {
                  Logic.$TERMUNDERCONSTRUCTION$.set(old$Termunderconstruction$000);
                }
              }
            }
          }
        }
        else {
        }
      }
    }
  }

  /** Return the simplest inversion of <code>prop</code>, trying to reuse existing
   * negations or negated arguments of <code>prop</code> if possible.
   * @param prop
   * @return Proposition
   */
  public static Proposition conceiveInvertedProposition(Proposition prop) {
    if (!(!(prop.kind == Logic.KWD_FUNCTION))) {
      System.err.print("Safety violation: INTERNAL ERROR: conceive-inverted-proposition: can't invert function terms: `" + prop + "'");
    }
    if (!BooleanWrapper.coerceWrappedBooleanToBoolean(prop.unfastenedP())) {
      if (prop.kind == Logic.KWD_NOT) {
        return (((Proposition)((prop.arguments.theArray)[0])));
      }
      { Proposition parent = null;
        Iterator iter000 = prop.dependentPropositions.allocateIterator();

        while (iter000.nextP()) {
          parent = ((Proposition)(iter000.value));
          if ((parent.kind == Logic.KWD_NOT) &&
              ((parent.arguments.theArray)[0] == prop)) {
            return (parent);
          }
        }
      }
    }
    prop = Proposition.safelyInvertProposition(prop);
    { Proposition object000 = prop;
      TruthValue value000 = null;
      Stella_Object oldValue000 = object000.truthValue;
      Stella_Object newValue000 = Stella_Object.updateInContext(oldValue000, value000, object000.homeContext, false);

      if (!((oldValue000 != null) &&
          (oldValue000.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
        object000.truthValue = newValue000;
      }
    }
    return (Proposition.recursivelyFastenDownPropositions(prop, false));
  }

  public static Proposition embedNegationWithinFunctionInducedExists(Proposition existsproposition) {
    Proposition.invertProposition(Proposition.predicateOfFunctionInducedExists(existsproposition));
    return (existsproposition);
  }

  public static Proposition predicateOfFunctionInducedExists(Proposition existsproposition) {
    { Proposition value000 = null;

      { Proposition arg = null;
        Vector vector000 = ((Vector)(((Proposition)((existsproposition.arguments.theArray)[0])).arguments));
        int index000 = 0;
        int length000 = vector000.length();

        loop000 : for (;index000 < length000; index000 = index000 + 1) {
          arg = ((Proposition)((vector000.theArray)[index000]));
          if ((!(arg.kind == Logic.KWD_FUNCTION)) &&
              (!BooleanWrapper.coerceWrappedBooleanToBoolean(arg.variableTypeP()))) {
            value000 = arg;
            break loop000;
          }
        }
      }
      { Proposition value001 = value000;

        return (value001);
      }
    }
  }

  public static boolean functionInducedExistsP(Proposition proposition) {
    if (proposition.kind == Logic.KWD_EXISTS) {
      { Stella_Object firstargument = (proposition.arguments.theArray)[0];

        if (Stella_Object.isaP(firstargument, Logic.SGT_LOGIC_PROPOSITION) &&
            (((Proposition)(firstargument)).kind == Logic.KWD_AND)) {
          { Vector existsvariables = ((Vector)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null)));
            Proposition andprop = ((Proposition)(firstargument));
            Vector andarguments = andprop.arguments;
            int nonfunctionscount = 0;

            { boolean alwaysP000 = true;

              { PatternVariable variable = null;
                Vector vector000 = existsvariables;
                int index000 = 0;
                int length000 = vector000.length();

                loop000 : for (;index000 < length000; index000 = index000 + 1) {
                  variable = ((PatternVariable)((vector000.theArray)[index000]));
                  { boolean testValue000 = false;

                    { boolean foundP000 = false;

                      { Proposition arg = null;
                        Vector vector001 = andarguments;
                        int index001 = 0;
                        int length001 = vector001.length();

                        loop001 : for (;index001 < length001; index001 = index001 + 1) {
                          arg = ((Proposition)((vector001.theArray)[index001]));
                          if ((arg.kind == Logic.KWD_FUNCTION) &&
                              (arg.arguments.last() == variable)) {
                            foundP000 = true;
                            break loop001;
                          }
                        }
                      }
                      testValue000 = foundP000;
                    }
                    testValue000 = !testValue000;
                    if (testValue000) {
                      alwaysP000 = false;
                      break loop000;
                    }
                  }
                }
              }
              if (alwaysP000) {
                { Proposition arg = null;
                  Vector vector002 = andarguments;
                  int index002 = 0;
                  int length002 = vector002.length();

                  for (;index002 < length002; index002 = index002 + 1) {
                    arg = ((Proposition)((vector002.theArray)[index002]));
                    if ((!(arg.kind == Logic.KWD_FUNCTION)) &&
                        (!BooleanWrapper.coerceWrappedBooleanToBoolean(arg.variableTypeP()))) {
                      nonfunctionscount = nonfunctionscount + 1;
                    }
                  }
                }
                return (nonfunctionscount == 1);
              }
            }
          }
        }
      }
    }
    return (false);
  }

  public static void forwardBackwardOptionHandler(Proposition self, StorageSlot slot, Stella_Object tree) {
    if (tree == Logic.SYM_STELLA_TRUE) {
      if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_FORWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_FORWARD_ONLYp, Stella.FALSE_WRAPPER, Stella.FALSE_WRAPPER);
      }
      if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_BACKWARD_ONLYp, Stella.FALSE_WRAPPER))).wrapperValue) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_BACKWARD_ONLYp, Stella.FALSE_WRAPPER, Stella.FALSE_WRAPPER);
      }
    }
    Stella_Object.defaultOptionHandler(self, slot, tree);
  }

  public static void clearPropositionAnnotations(Proposition proposition) {
    { PropertyList annotations = ((PropertyList)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_ANNOTATIONS, null)));

      if (annotations != null) {
        { Keyword option = null;
          Stella_Object value = null;
          Cons iter000 = annotations.thePlist;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
            option = ((Keyword)(iter000.value));
            value = iter000.rest.value;
            value = value;
            if (option == Logic.KWD_DIRECTION) {
              KeyValueList.setDynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_FORWARD_ONLYp, Stella.FALSE_WRAPPER, Stella.FALSE_WRAPPER);
              KeyValueList.setDynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_BACKWARD_ONLYp, Stella.FALSE_WRAPPER, Stella.FALSE_WRAPPER);
            }
            else if (option == Logic.KWD_WEIGHT) {
              KeyValueList.setDynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, FloatWrapper.wrapFloat(Stella.NULL_FLOAT), Stella.NULL_FLOAT_WRAPPER);
            }
            else {
              Stella_Object.runOptionHandlerP(proposition, option, null);
            }
          }
        }
      }
    }
  }

  public static void finalizePropositionAnnotations(Proposition proposition) {
    { PropertyList annotations = ((PropertyList)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_ANNOTATIONS, null)));

      if (annotations != null) {
        { Keyword option = null;
          Stella_Object value = null;
          Cons iter000 = annotations.thePlist;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
            option = ((Keyword)(iter000.value));
            value = iter000.rest.value;
            if (option == Logic.KWD_DIRECTION) {
              if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(value), Logic.SGT_STELLA_GENERALIZED_SYMBOL)) {
                { GeneralizedSymbol value000 = ((GeneralizedSymbol)(value));

                  { String testValue000 = Native.stringUpcase(value000.symbolName);

                    if (Stella.stringEqlP(testValue000, "FORWARD")) {
                      KeyValueList.setDynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_FORWARD_ONLYp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
                    }
                    else if (Stella.stringEqlP(testValue000, "BACKWARD")) {
                      KeyValueList.setDynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_BACKWARD_ONLYp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
                    }
                    else {
                      annotations.removeAt(option);
                      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                          try {
                            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                            stream000.nativeStream.println("PARSING ERROR: Illegal value for :direction option: `" + value000 + "'.");
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
              else {
                annotations.removeAt(option);
                { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                  { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      stream001.nativeStream.println("PARSING ERROR: Illegal value for :direction option: `" + value + "'.");
                      Logic.helpSignalPropositionError(stream001, Logic.KWD_ERROR);

                    } finally {
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                    }
                  }
                  throw ((ParsingError)(ParsingError.newParsingError(stream001.theStringReader()).fillInStackTrace()));
                }
              }
            }
            else if (option == Logic.KWD_WEIGHT) {
              { Surrogate testValue001 = Stella_Object.safePrimaryType(value);

                if (Surrogate.subtypeOfIntegerP(testValue001)) {
                  { IntegerWrapper value000 = ((IntegerWrapper)(value));

                    KeyValueList.setDynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, FloatWrapper.wrapFloat(value000.numberWrapperToFloat()), Stella.NULL_FLOAT_WRAPPER);
                  }
                }
                else if (Surrogate.subtypeOfFloatP(testValue001)) {
                  { FloatWrapper value000 = ((FloatWrapper)(value));

                    KeyValueList.setDynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_WEIGHT, FloatWrapper.wrapFloat(value000.wrapperValue), Stella.NULL_FLOAT_WRAPPER);
                  }
                }
                else {
                  annotations.removeAt(option);
                  { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                    { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

                      try {
                        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                        stream002.nativeStream.println("PARSING ERROR: Illegal value for :weight option: `" + value + "'.");
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
            else if (option == Logic.KWD_CONFIDENCE_LEVEL) {
            }
            else {
              if (!(Stella_Object.runOptionHandlerP(proposition, option, value))) {
                annotations.removeAt(option);
                { OutputStringStream stream003 = OutputStringStream.newOutputStringStream();

                  { Object old$PrintreadablyP$003 = Stella.$PRINTREADABLYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      stream003.nativeStream.println("PARSING ERROR: Unrecognized annotation option: `" + option + "'.");
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
        }
      }
    }
  }

  public static void removeAnnotation(Proposition proposition, Keyword key) {
    { PropertyList annotations = ((PropertyList)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_ANNOTATIONS, null)));

      if (annotations == null) {
        return;
      }
      annotations.removeAt(key);
      if (annotations.thePlist == Stella.NIL) {
        KeyValueList.setDynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_ANNOTATIONS, null, null);
      }
    }
  }

  public static void insertAnnotation(Proposition proposition, Keyword key, Stella_Object value) {
    { PropertyList annotations = ((PropertyList)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_ANNOTATIONS, null)));

      if (annotations == null) {
        annotations = PropertyList.newPropertyList();
        KeyValueList.setDynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_ANNOTATIONS, annotations, null);
      }
      annotations.insertAt(key, value);
    }
  }

  public static Stella_Object lookupAnnotation(Proposition proposition, Keyword key) {
    { PropertyList annotations = ((PropertyList)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_ANNOTATIONS, null)));

      if (annotations != null) {
        return (annotations.lookup(key));
      }
      else {
        return (null);
      }
    }
  }

  public static boolean simpleSubrelationPropositionP(Proposition proposition) {
    return ((proposition.operator == Logic.SGT_PL_KERNEL_KB_SUBSET_OF) &&
        (Stella_Object.isaP((proposition.arguments.theArray)[0], Logic.SGT_LOGIC_NAMED_DESCRIPTION) &&
         Stella_Object.isaP((proposition.arguments.theArray)[1], Logic.SGT_LOGIC_NAMED_DESCRIPTION)));
  }

  public static boolean subsetOfPropositionP(Proposition proposition) {
    return (proposition.operator == Logic.SGT_PL_KERNEL_KB_SUBSET_OF);
  }

  public static boolean memberOfPropositionP(Proposition proposition) {
    return (proposition.operator == Logic.SGT_PL_KERNEL_KB_MEMBER_OF);
  }

  public static void instantiateUndefinedSurrogates(Proposition self) {
    { Keyword testValue000 = self.kind;

      if ((testValue000 == Logic.KWD_AND) ||
          ((testValue000 == Logic.KWD_OR) ||
           ((testValue000 == Logic.KWD_NOT) ||
            (testValue000 == Logic.KWD_EXISTS)))) {
        { Stella_Object arg = null;
          Vector vector000 = self.arguments;
          int index000 = 0;
          int length000 = vector000.length();

          for (;index000 < length000; index000 = index000 + 1) {
            arg = (vector000.theArray)[index000];
            Proposition.instantiateUndefinedSurrogates(((Proposition)(arg)));
          }
        }
      }
      else if ((testValue000 == Logic.KWD_PREDICATE) ||
          ((testValue000 == Logic.KWD_FUNCTION) ||
           (testValue000 == Logic.KWD_ISA))) {
        { Stella_Object arg = null;
          Vector vector001 = self.arguments;
          int index001 = 0;
          int length001 = vector001.length();

          for (;index001 < length001; index001 = index001 + 1) {
            arg = (vector001.theArray)[index001];
            if (Surrogate.subtypeOfSurrogateP(Stella_Object.safePrimaryType(arg))) {
              { Surrogate arg000 = ((Surrogate)(arg));

                if (arg000.surrogateValue == null) {
                  Logic.createLogicInstance(arg000, null);
                }
              }
            }
            else {
            }
          }
        }
      }
      else {
      }
    }
  }

  public static void unfastenProposition(Proposition proposition) {
    { Stella_Object arg = null;
      Vector vector000 = proposition.arguments;
      int index000 = 0;
      int length000 = vector000.length();

      for (;index000 < length000; index000 = index000 + 1) {
        arg = (vector000.theArray)[index000];
        Logic.removeDependentPropositionLink(arg, proposition);
      }
    }
    KeyValueList.setDynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_UNFASTENEDp, Stella.TRUE_WRAPPER, null);
  }

  public static Proposition recursivelyFastenDownPropositions(Proposition self, boolean dontcheckforduplicatesP) {
    if (!BooleanWrapper.coerceWrappedBooleanToBoolean(self.unfastenedP())) {
      return (self);
    }
    { Object old$Visitedunfasteneddefiningpropositions$000 = Logic.$VISITEDUNFASTENEDDEFININGPROPOSITIONS$.get();

      try {
        Native.setSpecial(Logic.$VISITEDUNFASTENEDDEFININGPROPOSITIONS$, List.list(Stella.NIL));
        return (Proposition.helpFastenDownPropositions(self, dontcheckforduplicatesP));

      } finally {
        Logic.$VISITEDUNFASTENEDDEFININGPROPOSITIONS$.set(old$Visitedunfasteneddefiningpropositions$000);
      }
    }
  }

  public static Proposition helpFastenDownPropositions(Proposition self, boolean dontcheckforduplicatesP) {
    { boolean dontcheckargsforduplicatesP = dontcheckforduplicatesP;

      { Keyword testValue000 = self.kind;

        if ((testValue000 == Logic.KWD_FORALL) ||
            (testValue000 == Logic.KWD_EXISTS)) {
          dontcheckargsforduplicatesP = true;
        }
        else {
          if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.FALSE_WRAPPER))).wrapperValue) {
            dontcheckargsforduplicatesP = true;
          }
        }
      }
      { Stella_Object arg = null;
        Vector vector000 = self.arguments;
        int index000 = 0;
        int length000 = vector000.length();
        int i = Stella.NULL_INTEGER;
        int iter000 = 0;

        for (;index000 < length000; index000 = index000 + 1, iter000 = iter000 + 1) {
          arg = (vector000.theArray)[index000];
          i = iter000;
          { Surrogate testValue001 = Stella_Object.safePrimaryType(arg);

            if (Surrogate.subtypeOfP(testValue001, Logic.SGT_LOGIC_PROPOSITION)) {
              { Proposition arg000 = ((Proposition)(arg));

                if (BooleanWrapper.coerceWrappedBooleanToBoolean(arg000.unfastenedP())) {
                  (self.arguments.theArray)[i] = (Proposition.helpFastenDownPropositions(arg000, dontcheckargsforduplicatesP));
                }
              }
            }
            else if (Surrogate.subtypeOfP(testValue001, Logic.SGT_LOGIC_SKOLEM)) {
              { Skolem arg000 = ((Skolem)(arg));

                { Proposition definingprop = arg000.definingProposition;

                  if ((definingprop != null) &&
                      (BooleanWrapper.coerceWrappedBooleanToBoolean(definingprop.unfastenedP()) &&
                       (!((List)(Logic.$VISITEDUNFASTENEDDEFININGPROPOSITIONS$.get())).memberP(definingprop)))) {
                    ((List)(Logic.$VISITEDUNFASTENEDDEFININGPROPOSITIONS$.get())).insert(definingprop);
                    Proposition.helpFastenDownPropositions(definingprop, dontcheckargsforduplicatesP);
                  }
                }
              }
            }
            else {
            }
          }
        }
      }
      return (Proposition.fastenDownOneProposition(self, dontcheckforduplicatesP));
    }
  }

  public static Proposition fastenDownOneProposition(Proposition self, boolean dontcheckforduplicatesP) {
    if (Proposition.nativeSlotPropositionP(self)) {
      return (self);
    }
    if (!(((Boolean)(Logic.$LOADINGREGENERABLEOBJECTSp$.get())).booleanValue())) {
      Proposition.surrogatifyDiscouragedArguments(self);
    }
    { Proposition duplicate = null;

      if (!(dontcheckforduplicatesP ||
          (((Boolean)(Logic.$DONT_CHECK_FOR_DUPLICATE_PROPOSITIONSp$.get())).booleanValue() &&
           (!(self.kind == Logic.KWD_FUNCTION))))) {
        duplicate = Proposition.findDuplicateProposition(self);
      }
      if (duplicate != null) {
        {
          if (!Stella_Object.equalP(((PropertyList)(KeyValueList.dynamicSlotValue(duplicate.dynamicSlots, Logic.SYM_LOGIC_ANNOTATIONS, null))), ((PropertyList)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_ANNOTATIONS, null))))) {
            Proposition.clearPropositionAnnotations(duplicate);
            KeyValueList.setDynamicSlotValue(duplicate.dynamicSlots, Logic.SYM_LOGIC_ANNOTATIONS, ((PropertyList)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_ANNOTATIONS, null))), null);
            Proposition.finalizePropositionAnnotations(duplicate);
            Proposition.evaluateNewProposition(duplicate);
          }
          return (duplicate);
        }
      }
      else {
        {
          if (!(((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.FALSE_WRAPPER))).wrapperValue ||
              Logic.descriptionModeP())) {
            if (!((Boolean)(Logic.$LOADINGREGENERABLEOBJECTSp$.get())).booleanValue()) {
              Logic.logNewlyConceivedProposition(((Module)(Stella.$MODULE$.get())), self);
            }
          }
          if (!((Boolean)(Logic.$LOADINGREGENERABLEOBJECTSp$.get())).booleanValue()) {
            Proposition.rewrapPropositionArguments(self);
          }
          if (!((Boolean)(Logic.$LOADINGREGENERABLEOBJECTSp$.get())).booleanValue()) {
            { Stella_Object arg = null;
              Vector vector000 = self.arguments;
              int index000 = 0;
              int length000 = vector000.length();

              for (;index000 < length000; index000 = index000 + 1) {
                arg = (vector000.theArray)[index000];
                Logic.addDependentPropositionLink(arg, self);
              }
            }
          }
          Proposition.updateDescriptionExtension(self);
          KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_UNFASTENEDp, null, null);
          Proposition.finalizePropositionAnnotations(self);
          Proposition.evaluateNewProposition(self);
          return (self);
        }
      }
    }
  }

  public static Proposition findMatchingNonDescriptiveProposition(Proposition self, KeyValueMap mapping) {
    if (!((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.FALSE_WRAPPER))).wrapperValue) {
      return (self);
    }
    { IntegerWrapper index = IntegerWrapper.wrapInteger(Proposition.propositionHashIndex(self, mapping, true));
      List bucket = ((List)(Logic.$STRUCTURED_OBJECTS_INDEX$.lookup(index)));

      if (bucket != null) {
        return (Logic.lookupMatchingPropositionInBucket(bucket, self, mapping));
      }
      else {
        return (null);
      }
    }
  }

  public static Proposition findDuplicateProposition(Proposition self) {
    if (Logic.descriptionModeP() ||
        ((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTIVEp, Stella.FALSE_WRAPPER))).wrapperValue) {
      return (null);
    }
    if (self.kind == Logic.KWD_DISABLED) {
      { Proposition value000 = null;

        { Proposition p = null;
          Iterator iter000 = Proposition.findSimilarPropositions(self).allocateIterator();

          loop000 : while (iter000.nextP()) {
            p = ((Proposition)(iter000.value));
            if (Proposition.equivalentPropositionsP(self, p, null) &&
                Context.subcontextP(self.homeContext.baseModule, p.homeContext.baseModule)) {
              value000 = p;
              break loop000;
            }
          }
        }
        { Proposition value001 = value000;

          return (value001);
        }
      }
    }
    else {
      { ObjectStore store = Logic.homeObjectStore(self);

        if (store != null) {
          return (store.fetchDuplicateProposition(self));
        }
        else {
          return (Proposition.findDuplicateComplexProposition(self));
        }
      }
    }
  }

  public static Proposition findDuplicateComplexProposition(Proposition self) {
    { IntegerWrapper index = IntegerWrapper.wrapInteger(Proposition.propositionHashIndex(self, null, false));
      List bucket = ((List)(Logic.$STRUCTURED_OBJECTS_INDEX$.lookup(index)));
      Proposition duplicate = null;

      if (bucket == null) {
        Logic.$STRUCTURED_OBJECTS_INDEX$.insertAt(index, List.list(Cons.cons(self, Stella.NIL)));
        return (null);
      }
      duplicate = Logic.lookupMatchingPropositionInBucket(bucket, self, null);
      if (duplicate != null) {
        return (duplicate);
      }
      bucket.push(self);
      return (null);
    }
  }

  public static int propositionHashIndex(Proposition self, KeyValueMap mapping, boolean derefsurrogatesP) {
    { boolean mappedP = mapping != null;
      int code = (self.operator).hashCode();
      Vector arguments = self.arguments;
      Stella_Object functionoutput = ((mappedP &&
          (self.kind == Logic.KWD_FUNCTION)) ? arguments.last() : ((Stella_Object)(null)));
      Stella_Object priorarg = null;
      int argcode = 0;
      boolean commutativeP = false;

      { Keyword testValue000 = self.kind;

        if ((testValue000 == Logic.KWD_AND) ||
            ((testValue000 == Logic.KWD_OR) ||
             (testValue000 == Logic.KWD_EQUIVALENT))) {
          commutativeP = true;
        }
        else {
        }
      }
      { Stella_Object arg = null;
        Vector vector000 = arguments;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          if (mappedP) {
            if (Stella_Object.eqlP(arg, functionoutput)) {
              arg = null;
            }
            else {
              arg = Logic.mappedValueOf(arg, mapping, false);
            }
          }
          if ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
              Logic.variableP(arg)) {
            { Stella_Object temp000 = PatternVariable.safeBoundTo(((PatternVariable)(arg)));

              arg = ((temp000 != null) ? temp000 : arg);
            }
          }
          if (arg == null) {
            argcode = Logic.SGT_LOGIC_SKOLEM.hashCode();
          }
          else {
            { Surrogate testValue001 = Stella_Object.safePrimaryType(arg);

              if (Surrogate.subtypeOfP(testValue001, Logic.SGT_LOGIC_PROPOSITION)) {
                { Proposition arg000 = ((Proposition)(arg));

                  argcode = Proposition.propositionHashIndex(arg000, mapping, derefsurrogatesP);
                }
              }
              else if (Surrogate.subtypeOfP(testValue001, Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
                { NamedDescription arg000 = ((NamedDescription)(arg));

                  argcode = arg000.hashCode();
                }
              }
              else if (Surrogate.subtypeOfP(testValue001, Logic.SGT_LOGIC_DESCRIPTION)) {
                { Description arg000 = ((Description)(arg));

                  argcode = Proposition.propositionHashIndex(arg000.proposition, mapping, derefsurrogatesP);
                }
              }
              else if (Surrogate.subtypeOfP(testValue001, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
                { PatternVariable arg000 = ((PatternVariable)(arg));

                  argcode = Logic.SGT_LOGIC_PATTERN_VARIABLE.hashCode();
                }
              }
              else if (Surrogate.subtypeOfP(testValue001, Logic.SGT_LOGIC_SKOLEM)) {
                { Skolem arg000 = ((Skolem)(arg));

                  { Proposition definingprop = arg000.definingProposition;

                    if ((definingprop != null) &&
                        (!(definingprop == self))) {
                      argcode = Proposition.propositionHashIndex(definingprop, mapping, derefsurrogatesP);
                    }
                    else {
                      argcode = Logic.SGT_LOGIC_SKOLEM.hashCode();
                    }
                  }
                }
              }
              else if (Surrogate.subtypeOfSurrogateP(testValue001)) {
                { Surrogate arg000 = ((Surrogate)(arg));

                  if (derefsurrogatesP) {
                    arg000 = ((Surrogate)(arg000.surrogateValue));
                  }
                  argcode = arg000.hashCode_();
                }
              }
              else if (Surrogate.subtypeOfWrapperP(testValue001)) {
                { Wrapper arg000 = ((Wrapper)(arg));

                  argcode = arg000.hashCode_();
                }
              }
              else {
                argcode = arg.hashCode();
              }
            }
          }
          if ((priorarg == null) ||
              ((!commutativeP) ||
               Stella_Object.eqlP(arg, priorarg))) {
            code = (((code & 1) == 0) ? (code >>> 1) : (((code >> 1)) | Stella.$INTEGER_MSB_MASK$));
          }
          code = (code ^ argcode);
          priorarg = arg;
        }
      }
      return (code);
    }
  }

  public static void updateSkolemTypeFromIsaAssertions(Proposition self) {
    { Keyword testValue000 = self.kind;

      if (testValue000 == Logic.KWD_ISA) {
        { Stella_Object renamed_Object = (self.arguments.theArray)[0];

          if (Stella_Object.isaP(renamed_Object, Logic.SGT_LOGIC_SKOLEM)) {
            Skolem.updateSkolemType(((Skolem)(renamed_Object)), ((Surrogate)(self.operator)));
          }
        }
      }
      else if (testValue000 == Logic.KWD_AND) {
        { Stella_Object arg = null;
          Vector vector000 = self.arguments;
          int index000 = 0;
          int length000 = vector000.length();

          for (;index000 < length000; index000 = index000 + 1) {
            arg = (vector000.theArray)[index000];
            Proposition.updateSkolemTypeFromIsaAssertions(((Proposition)(arg)));
          }
        }
      }
      else {
      }
    }
  }

  /** Return true if <code>self</code> is a constant such as TRUE or FALSE.
   * @param self
   * @return boolean
   */
  public static boolean constantPropositionP(Proposition self) {
    return (self.kind == Logic.KWD_CONSTANT);
  }

  public static void reviseEquivalences(Proposition proposition, boolean goestrueP) {
    { LogicObject arg1 = ((LogicObject)((proposition.arguments.theArray)[0]));
      LogicObject arg2 = ((LogicObject)((proposition.arguments.theArray)[1]));

      if (!Logic.$EQUIVALENCE_COLLECTIONSp$) {
        return;
      }
      if (goestrueP) {
        if (LogicObject.collectionImpliesCollectionP(arg1, arg2) &&
            LogicObject.collectionImpliesCollectionP(arg2, arg1)) {
          LogicObject.equivalenceCollections(arg1, arg2);
        }
      }
      else if ((((Description)(Stella_Object.accessInContext(KeyValueList.dynamicSlotValue(arg1.dynamicSlots, Logic.SYM_LOGIC_EQUIVALENT_VALUE, null), arg1.homeContext, false))) != null) ||
          (((Description)(Stella_Object.accessInContext(KeyValueList.dynamicSlotValue(arg2.dynamicSlots, Logic.SYM_LOGIC_EQUIVALENT_VALUE, null), arg2.homeContext, false))) != null)) {
        {
          Stella.STANDARD_OUTPUT.nativeStream.println("DIDN'T FINISH 'revise-equivalences' YET. DON'T KNOW HOW");
          Stella.STANDARD_OUTPUT.nativeStream.println("   TO REMOVE AN 'equivalent-value' LINK");
        }
;
      }
      else if ((Stella_Object.isaP(arg1, Logic.SGT_LOGIC_SKOLEM) &&
          (((Stella_Object)(Stella_Object.accessInContext(((Skolem)(arg1)).variableValue, ((Skolem)(arg1)).homeContext, false))) != null)) ||
          (Stella_Object.isaP(arg2, Logic.SGT_LOGIC_SKOLEM) &&
           (((Stella_Object)(Stella_Object.accessInContext(((Skolem)(arg2)).variableValue, ((Skolem)(arg2)).homeContext, false))) != null))) {
        {
          Stella.STANDARD_OUTPUT.nativeStream.println("DIDN'T FINISH 'revise-equivalences' YET. DON'T KNOW HOW");
          Stella.STANDARD_OUTPUT.nativeStream.println("   TO REMOVE AN 'equivalent-value' LINK");
        }
;
      }
    }
  }

  public static boolean unequateConflictingDefaultValuesP(Proposition newequatingprop) {
    { Vector arguments = newequatingprop.arguments;
      Stella_Object firstarg = (arguments.theArray)[0];
      boolean firstargisskolemP = Logic.skolemP(firstarg);
      Stella_Object firstargvalue = Logic.innermostOf(firstarg);
      Stella_Object secondarg = (arguments.theArray)[1];
      boolean secondargisskolemP = Logic.skolemP(secondarg);
      Stella_Object secondargvalue = Logic.innermostOf(secondarg);
      boolean newisdefaultP = Proposition.defaultTrueP(newequatingprop);
      Stella_Object newtruthvalue = null;
      Proposition equatingprop = null;

      if (Stella_Object.eqlP(firstargvalue, secondargvalue)) {
        return (true);
      }
      else if (Logic.skolemP(firstargvalue)) {
        if ((((Skolem)(firstargvalue)).conflictingDefaultValues() == Stella.NIL) ||
            (!newisdefaultP)) {
          return (true);
        }
        else {
          return (false);
        }
      }
      else if (Logic.skolemP(secondargvalue)) {
        if ((((Skolem)(secondargvalue)).conflictingDefaultValues() == Stella.NIL) ||
            (!newisdefaultP)) {
          return (true);
        }
        else {
          return (false);
        }
      }
      if (firstargisskolemP &&
          (secondargisskolemP &&
           newisdefaultP)) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              {
                stream000.nativeStream.println("ERROR: Equating two skolems `" + firstarg + "' and `" + secondarg + "' by default is not yet supported.");
                stream000.nativeStream.println(".");
              }
;
              Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
          throw ((PropositionError)(PropositionError.newPropositionError(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      newtruthvalue = newequatingprop.truthValue;
      newequatingprop.truthValue = null;
      if (firstargisskolemP) {
        { Object old$DontusedefaultknowledgeP$000 = Logic.$DONTUSEDEFAULTKNOWLEDGEp$.get();

          try {
            Native.setBooleanSpecial(Logic.$DONTUSEDEFAULTKNOWLEDGEp$, true);
            equatingprop = Logic.findEquatingProposition(firstargvalue, ((LogicObject)(firstarg)));

          } finally {
            Logic.$DONTUSEDEFAULTKNOWLEDGEp$.set(old$DontusedefaultknowledgeP$000);
          }
        }
        if (equatingprop == null) {
          equatingprop = Logic.findEquatingProposition(firstargvalue, ((LogicObject)(firstarg)));
          while (!Stella_Object.eqlP(Logic.valueOf(firstarg), firstargvalue)) {
            firstarg = Logic.valueOf(firstarg);
          }
          { Skolem skolem = ((Skolem)(firstarg));

            { Skolem object000 = skolem;
              Stella_Object value000 = null;
              Stella_Object oldValue001 = object000.variableValue;
              Stella_Object newValue000 = Stella_Object.updateInContext(oldValue001, value000, object000.homeContext, false);

              if (!((oldValue001 != null) &&
                  (oldValue001.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
                object000.variableValue = newValue000;
              }
            }
            KeyValueList.setDynamicSlotValue(skolem.dynamicSlots, Logic.SYM_LOGIC_CONFLICTING_DEFAULT_VALUES, Cons.cons(equatingprop, skolem.conflictingDefaultValues()), null);
            if (newisdefaultP) {
              KeyValueList.setDynamicSlotValue(skolem.dynamicSlots, Logic.SYM_LOGIC_CONFLICTING_DEFAULT_VALUES, Cons.cons(newequatingprop, skolem.conflictingDefaultValues()), null);
            }
          }
        }
      }
      if (secondargisskolemP) {
        { Object old$DontusedefaultknowledgeP$001 = Logic.$DONTUSEDEFAULTKNOWLEDGEp$.get();

          try {
            Native.setBooleanSpecial(Logic.$DONTUSEDEFAULTKNOWLEDGEp$, true);
            equatingprop = Logic.findEquatingProposition(secondargvalue, ((LogicObject)(secondarg)));

          } finally {
            Logic.$DONTUSEDEFAULTKNOWLEDGEp$.set(old$DontusedefaultknowledgeP$001);
          }
        }
        if (equatingprop == null) {
          equatingprop = Logic.findEquatingProposition(firstargvalue, ((LogicObject)(firstarg)));
          while (!Stella_Object.eqlP(Logic.valueOf(secondarg), secondargvalue)) {
            secondarg = Logic.valueOf(secondarg);
          }
          { Skolem skolem = ((Skolem)(secondarg));

            { Skolem object001 = skolem;
              Stella_Object value001 = null;
              Stella_Object oldValue002 = object001.variableValue;
              Stella_Object newValue001 = Stella_Object.updateInContext(oldValue002, value001, object001.homeContext, false);

              if (!((oldValue002 != null) &&
                  (oldValue002.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
                object001.variableValue = newValue001;
              }
            }
            KeyValueList.setDynamicSlotValue(skolem.dynamicSlots, Logic.SYM_LOGIC_CONFLICTING_DEFAULT_VALUES, Cons.cons(equatingprop, skolem.conflictingDefaultValues()), null);
            if (newisdefaultP) {
              KeyValueList.setDynamicSlotValue(skolem.dynamicSlots, Logic.SYM_LOGIC_CONFLICTING_DEFAULT_VALUES, Cons.cons(newequatingprop, skolem.conflictingDefaultValues()), null);
            }
          }
        }
      }
      newequatingprop.truthValue = ((TruthValue)(newtruthvalue));
      return (((!firstargisskolemP) &&
          (!secondargisskolemP)) ||
          (!newisdefaultP));
    }
  }

  public static void equateValues(Proposition prop, Stella_Object term1, Stella_Object term2) {
    if (Stella_Object.eqlP(term1, term2)) {
    }
    else if (Logic.skolemP(term1)) {
      Skolem.bindSkolemToValue(((Skolem)(term1)), term2, false);
    }
    else if (Logic.skolemP(term2)) {
      Skolem.bindSkolemToValue(((Skolem)(term2)), term1, false);
    }
    else if (Stella_Object.stellaCollectionP(term1) &&
        Stella_Object.stellaCollectionP(term2)) {
      Proposition.equateCollections(prop, ((Collection)(term1)), ((Collection)(term2)));
    }
    else if (Stella_Object.isaP(term1, Logic.SGT_PL_KERNEL_KB_INTERVAL_CACHE) &&
        Stella_Object.isaP(term2, Logic.SGT_PL_KERNEL_KB_INTERVAL_CACHE)) {
      edu.isi.powerloom.pl_kernel_kb.IntervalCache.unifyIntervalCaches(((edu.isi.powerloom.pl_kernel_kb.IntervalCache)(term1)), ((edu.isi.powerloom.pl_kernel_kb.IntervalCache)(term2)), Logic.SGT_PL_KERNEL_KB_ge);
      edu.isi.powerloom.pl_kernel_kb.IntervalCache.unifyIntervalCaches(((edu.isi.powerloom.pl_kernel_kb.IntervalCache)(term2)), ((edu.isi.powerloom.pl_kernel_kb.IntervalCache)(term1)), Logic.SGT_PL_KERNEL_KB_ge);
    }
    else {
      Proposition.signalUnificationClash(prop, term1, term2);
    }
  }

  public static void equateCollections(Proposition prop, Collection col1, Collection col2) {
    if (col1.orderedP() &&
        col2.orderedP()) {
      { Stella_Object i1 = null;
        Iterator iter000 = ((Iterator)(col1.allocateIterator()));
        Stella_Object i2 = null;
        Iterator iter001 = ((Iterator)(col2.allocateIterator()));

        while (iter000.nextP() &&
            iter001.nextP()) {
          i1 = iter000.value;
          i2 = iter001.value;
          Proposition.equateValues(prop, i1, i2);
        }
      }
      return;
    }
    if (col1.noDuplicatesP() &&
        col2.noDuplicatesP()) {
      Proposition.constrainAsSubset(prop, col1, col2);
      Proposition.constrainAsSubset(prop, col2, col1);
    }
  }

  public static void constrainAsSubset(Proposition prop, Collection set1, Collection set2) {
    if (set1.length() > set2.length()) {
      Proposition.signalUnificationClash(prop, set1, set2);
    }
    { Cons copy1 = Stella.NIL;
      Cons copy2 = Stella.NIL;

      { Stella_Object i2 = null;
        Iterator iter000 = ((Iterator)(set2.allocateIterator()));

        while (iter000.nextP()) {
          i2 = iter000.value;
          copy2 = Cons.cons(i2, copy2);
        }
      }
      { Stella_Object i1 = null;
        Iterator iter001 = ((Iterator)(set1.allocateIterator()));

        while (iter001.nextP()) {
          i1 = iter001.value;
          if (copy2.memberP(i1)) {
            copy2 = copy2.remove(i1);
          }
          else {
            copy1 = Cons.cons(i1, copy1);
          }
        }
      }
      if (copy1 == Stella.NIL) {
        return;
      }
      if (copy2.length() == 1) {
        { Stella_Object item1 = copy1.value;
          Stella_Object item2 = copy2.value;

          Proposition.equateValues(prop, item1, item2);
          return;
        }
      }
      { int skolemcount1 = 0;
        int skolemcount2 = 0;

        { Stella_Object i1 = null;
          Cons iter002 = copy1;

          for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
            i1 = iter002.value;
            if (Logic.skolemP(i1)) {
              skolemcount1 = skolemcount1 + 1;
            }
          }
        }
        { Stella_Object i2 = null;
          Cons iter003 = copy2;

          for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
            i2 = iter003.value;
            if (Logic.skolemP(i2)) {
              skolemcount2 = skolemcount2 + 1;
            }
          }
        }
        if ((skolemcount1 + skolemcount2) == 0) {
          Proposition.signalUnificationClash(prop, set1, set2);
        }
      }
    }
  }

  public static void unifyTypes(Proposition prop, Skolem term1, Stella_Object term2) {
    { Surrogate type1 = Logic.logicalType(term1);
      Surrogate type2 = Logic.logicalType(term2);

      if ((type1 == type2) ||
          (Logic.logicalSubtypeOfP(type1, type2) ||
           Logic.logicalSubtypeOfP(type2, type1))) {
      }
      else if (type1 == Logic.SGT_STELLA_THING) {
        if (Stella_Object.isaP(term1, Logic.SGT_LOGIC_SKOLEM)) {
        }
        ((Skolem)(term1)).skolemType = type2;
      }
      else if (type2 == Logic.SGT_STELLA_THING) {
        if (Stella_Object.isaP(term2, Logic.SGT_LOGIC_SKOLEM)) {
          ((Skolem)(term2)).skolemType = type1;
        }
      }
      else {
        if (Logic.bottomP(term2)) {
          return;
        }
        Proposition.signalUnificationClash(prop, term1, term2);
      }
    }
  }

  /** Return the set of clash exceptions for 'incoherentProp' that are visible from the
   * current context.  These are recorded most-recent first in order of occurrance.
   * @param incoherentprop
   * @return Cons
   */
  public static Cons getVisibleClashExceptions(Proposition incoherentprop) {
    { Cons value000 = Stella.NIL;

      { ExceptionRecord record = null;
        Cons iter000 = incoherentprop.clashExceptions();
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          record = ((ExceptionRecord)(iter000.value));
          if ((((Context)(Stella.$CONTEXT$.get())) == record.context) ||
              ((Context)(Stella.$CONTEXT$.get())).allSuperContexts.membP(record.context)) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(record, Stella.NIL);
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
                collect000.rest = Cons.cons(record, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      { Cons value001 = value000;

        return (value001);
      }
    }
  }

  public Cons clashExceptions() {
    { Proposition self = this;

      { Cons answer = ((Cons)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_CLASH_EXCEPTIONS, null)));

        if (answer == null) {
          return (Stella.NIL);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public static void signalTruthValueClash(Proposition proposition) {
    if (!((proposition == Logic.TRUE_PROPOSITION) ||
        (proposition == Logic.FALSE_PROPOSITION))) {
      Proposition.assignTruthValue(proposition, Logic.INCONSISTENT_TRUTH_VALUE);
      if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue()) {
        { Proposition negatedProposition = Proposition.conceiveInvertedProposition(proposition);
          Cons antecedents = Stella.NIL;

          if ((negatedProposition.forwardJustifications() != null) &&
              (!negatedProposition.forwardJustifications().emptyP())) {
            antecedents = negatedProposition.forwardJustifications().theConsList;
          }
          else {
            { PrimitiveStrategy self000 = PrimitiveStrategy.newPrimitiveStrategy();

              self000.proposition = negatedProposition;
              self000.strategy = Logic.KWD_LOOKUP_ASSERTIONS;
              antecedents = Cons.cons(self000, antecedents);
            }
          }
          if ((proposition.forwardJustifications() != null) &&
              (!proposition.forwardJustifications().emptyP())) {
            antecedents = Cons.append(proposition.forwardJustifications().theConsList, antecedents);
          }
          else {
            { PrimitiveStrategy self001 = PrimitiveStrategy.newPrimitiveStrategy();

              self001.proposition = proposition;
              self001.strategy = Logic.KWD_LOOKUP_ASSERTIONS;
              antecedents = Cons.cons(self001, antecedents);
            }
          }
          Proposition.addForwardJustifications(proposition, Proposition.createClashJustification(proposition, antecedents, Logic.KWD_FORWARD));
          Proposition.addForwardJustifications(negatedProposition, Proposition.createClashJustification(negatedProposition, Cons.copyConsList(antecedents).reverse(), Logic.KWD_FORWARD));
        }
      }
    }
    { String message = null;
      Context exceptionContext = ((Context)(Stella.$CONTEXT$.get()));
      TruthValueClash exception = null;

      if (((Context)(Stella.$CONTEXT$.get())) == ((World)(KeyValueList.dynamicSlotValue(((Module)(Stella.$MODULE$.get())).dynamicSlots, Logic.SYM_LOGIC_META_INFERENCE_CACHE, null)))) {
        { String message000 = null;

          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              message000 = "Derived both TRUE and FALSE for the proposition " + "`" + Native.stringify(proposition) + "'" + "." + "\n" + "   Clash occurred in the meta inference cache for module " + "`" + Native.stringify(((Module)(Stella.$MODULE$.get()))) + "'" + ".";

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
          message = message000;
        }
      }
      else if (((Context)(Stella.$CONTEXT$.get())) == ((World)(KeyValueList.dynamicSlotValue(((Module)(Stella.$MODULE$.get())).dynamicSlots, Logic.SYM_LOGIC_TRUTH_MAINTAINED_INFERENCE_CACHE, null)))) {
        { String message001 = null;

          { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              message001 = "Derived both TRUE and FALSE for the proposition " + "`" + Native.stringify(proposition) + "'" + "." + "\n" + "   Clash occurred in the default inference cache for module " + "`" + Native.stringify(((Module)(Stella.$MODULE$.get()))) + "'" + ".";

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
            }
          }
          message = message001;
        }
      }
      else if (((Context)(Stella.$CONTEXT$.get())) == ((Module)(Stella.$MODULE$.get()))) {
        { String message002 = null;

          { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              message002 = "Derived both TRUE and FALSE for the proposition " + "`" + Native.stringify(proposition) + "'" + "." + "\n" + "   Clash occurred in module " + "`" + Native.stringify(((Module)(Stella.$MODULE$.get()))) + "'" + ".";

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
            }
          }
          message = message002;
        }
      }
      else {
        { String message003 = null;

          { Object old$PrintreadablyP$003 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              message003 = "Derived both TRUE and FALSE for the proposition " + "`" + Native.stringify(proposition) + "'" + "." + "\n" + "   Clash occurred in the world " + "`" + Native.stringify(((Context)(Stella.$CONTEXT$.get()))) + "'" + " in module " + "`" + Native.stringify(((Module)(Stella.$MODULE$.get()))) + "'" + ".";

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$003);
            }
          }
          message = message003;
        }
      }
      exception = TruthValueClash.newTruthValueClash(message);
      exception.proposition = proposition;
      exception.context = exceptionContext;
      Clash.handleClashException(exception);
    }
  }

  public static void signalVariableValueClash(Proposition prop, Skolem skolem, Stella_Object value1, Stella_Object value2) {
    Proposition.assignTruthValue(prop, Logic.INCONSISTENT_TRUTH_VALUE);
    { String message = "Variable value clash.";
      VariableValueClash exception = null;

      if ((value1 != null) &&
          (value2 != null)) {
        { String message000 = null;

          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              message000 = "Skolem " + "`" + Native.stringify(skolem) + "'" + " is equated with multiple values:" + "\n" + "   " + "`" + Native.stringify(value1) + "'" + " and " + "`" + Native.stringify(value2) + "'" + ".";

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
          message = message000;
        }
      }
      exception = VariableValueClash.newVariableValueClash(message);
      exception.proposition = prop;
      exception.context = ((Context)(Stella.$CONTEXT$.get()));
      exception.skolem = skolem;
      exception.value1 = value1;
      exception.value2 = value2;
      Clash.handleClashException(exception);
    }
  }

  public static void signalUnificationClash(Proposition prop, Stella_Object term1, Stella_Object term2) {
    { String message = "Unification clash.";
      UnificationClash clashObject = null;

      if (prop != null) {
        Proposition.assignTruthValue(prop, Logic.INCONSISTENT_TRUTH_VALUE);
      }
      else {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Internal: SIGNAL-UNIFICATION-CLASH doesn't have responsible proposition available.");
      }
      if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue()) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: SIGNAL-UNIFICATION-CLASH doesn't yet have justification support");
      }
      if ((term1 != null) &&
          (term2 != null)) {
        { String message000 = null;

          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              message000 = "`" + Native.stringify(term1) + "'" + " clashes with " + "`" + Native.stringify(term2) + "'";

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
          message = message000;
        }
      }
      clashObject = UnificationClash.newUnificationClash(message);
      clashObject.proposition = prop;
      clashObject.context = ((Context)(Stella.$CONTEXT$.get()));
      clashObject.value1 = term1;
      clashObject.value2 = term2;
      Clash.handleClashException(clashObject);
    }
  }

  /** Return true if <code>self</code> is default false.
   * @param self
   * @return boolean
   */
  public static boolean defaultFalseP(Proposition self) {
    return (((TruthValue)(Stella_Object.accessInContext(self.truthValue, self.homeContext, false))) == Logic.DEFAULT_FALSE_TRUTH_VALUE);
  }

  /** Return true if <code>self</code> is default true.
   * @param self
   * @return boolean
   */
  public static boolean defaultTrueP(Proposition self) {
    return (((TruthValue)(Stella_Object.accessInContext(self.truthValue, self.homeContext, false))) == Logic.DEFAULT_TRUE_TRUTH_VALUE);
  }

  /** Return true if <code>self</code> is inconsistent (true and false).
   * @param self
   * @return boolean
   */
  public static boolean inconsistentP(Proposition self) {
    return (((TruthValue)(Stella_Object.accessInContext(self.truthValue, self.homeContext, false))) == Logic.INCONSISTENT_TRUTH_VALUE);
  }

  /** Return true if the truth of <code>self</code> is unknown.
   * @param self
   * @return boolean
   */
  public static boolean unknownP(Proposition self) {
    { TruthValue tv = ((TruthValue)(Stella_Object.accessInContext(self.truthValue, self.homeContext, false)));

      return (((tv == Logic.UNKNOWN_TRUTH_VALUE) ||
          (tv == null)) ||
          (((!(!((Boolean)(Logic.$DONTUSEDEFAULTKNOWLEDGEp$.get())).booleanValue())) &&
          ((tv == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
           (tv == Logic.DEFAULT_FALSE_TRUTH_VALUE))) ||
           (tv == Logic.INCONSISTENT_TRUTH_VALUE)));
    }
  }

  /** Return true if <code>self</code> is false (or default-false if we are
   * considering default assertions).
   * @param self
   * @return boolean
   */
  public static boolean falseP(Proposition self) {
    { TruthValue truthvalue = ((TruthValue)(Stella_Object.accessInContext(self.truthValue, self.homeContext, false)));

      if (truthvalue == Logic.FALSE_TRUTH_VALUE) {
        return (true);
      }
      else if (truthvalue == Logic.DEFAULT_FALSE_TRUTH_VALUE) {
        if (!((Boolean)(Logic.$DONTUSEDEFAULTKNOWLEDGEp$.get())).booleanValue()) {
          return (true);
        }
      }
      else if ((truthvalue != null) &&
          ((truthvalue.polarity == Logic.KWD_FALSE) &&
           ((!((Boolean)(Logic.$DONTUSEDEFAULTKNOWLEDGEp$.get())).booleanValue()) ||
            (truthvalue.strength == Logic.KWD_STRICT)))) {
        return (true);
      }
      return (false);
    }
  }

  /** Return true if <code>self</code> is true (or default-true if we are
   * considering default assertions).
   * @param self
   * @return boolean
   */
  public static boolean trueP(Proposition self) {
    { TruthValue truthvalue = ((TruthValue)(Stella_Object.accessInContext(self.truthValue, self.homeContext, false)));

      if (truthvalue == Logic.TRUE_TRUTH_VALUE) {
        return (true);
      }
      else if (truthvalue == Logic.DEFAULT_TRUE_TRUTH_VALUE) {
        if (!((Boolean)(Logic.$DONTUSEDEFAULTKNOWLEDGEp$.get())).booleanValue()) {
          return (true);
        }
      }
      else if ((truthvalue != null) &&
          ((truthvalue.polarity == Logic.KWD_TRUE) &&
           ((!((Boolean)(Logic.$DONTUSEDEFAULTKNOWLEDGEp$.get())).booleanValue()) ||
            (truthvalue.strength == Logic.KWD_STRICT)))) {
        return (true);
      }
      return (false);
    }
  }

  public static void assignNativeSlotValue(Proposition prop, Thing self, StorageSlot slot, Stella_Object value) {
    if (Logic.skolemP(value)) {
      return;
    }
    { Stella_Object oldvalue = StandardObject.readSlotValue(self, slot);

      if (Stella_Object.eqlP(oldvalue, value)) {
        return;
      }
      if (oldvalue != null) {
        Proposition.signalUnificationClash(prop, oldvalue, value);
      }
      StandardObject.putSlotValue(self, slot, value);
    }
  }

  public static Cons updateNativeSlotProposition(Proposition proposition, Keyword updatemode) {
    { Relation slot = Logic.surrogateToDescription(((Surrogate)(proposition.operator))).nativeRelation();
      Stella_Object renamed_Object = Logic.valueOf((proposition.arguments.theArray)[0]);
      Stella_Object value = Logic.valueOf((proposition.arguments.theArray)[1]);

      if (updatemode == Logic.KWD_ASSERT_TRUE) {
        if (((Boolean)(Logic.$CLIPPINGENABLEDp$.get())).booleanValue()) {
          Logic.clearNativeSlotValue(((Thing)(renamed_Object)), ((StorageSlot)(slot)));
        }
        Proposition.assignNativeSlotValue(proposition, ((Thing)(renamed_Object)), ((StorageSlot)(slot)), value);
      }
      else if (updatemode == Logic.KWD_RETRACT_TRUE) {
        Logic.dropNativeSlotValue(((Thing)(renamed_Object)), ((StorageSlot)(slot)), value);
      }
      else {
        {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: Illegal update to native slot value.  Mode:  `" + updatemode + "'");
          Stella.STANDARD_WARNING.nativeStream.println("   Proposition:  `" + proposition + "'");
          Stella.STANDARD_WARNING.nativeStream.println();
        }
;
      }
      return (Stella.NIL);
    }
  }

  public static boolean nativeSlotPropositionP(Proposition self) {
    { Vector arguments = self.arguments;

      if (((arguments.length()) == 0)) {
        return (false);
      }
      { Stella_Object firstarg = (((arguments.theArray)[0] != null) ? Logic.valueOf((arguments.theArray)[0]) : ((Stella_Object)(null)));

        if ((firstarg != null) &&
            Stella_Object.isaP(firstarg, Logic.SGT_STELLA_THING)) {
          { NamedDescription description = Logic.getDescription(self.operator);

            if ((description != null) &&
                ((description.nativeRelation() != null) &&
                 Stella_Object.isaP(description.nativeRelation(), Logic.SGT_STELLA_STORAGE_SLOT))) {
              return (true);
            }
          }
        }
        return (false);
      }
    }
  }

  public static void assignPropositionWeight(Proposition self, double weight) {
    { TruthValue tv = ((TruthValue)(Stella_Object.accessInContext(self.truthValue, self.homeContext, false)));

      if (weight == 1.0) {
        Proposition.assignTruthValue(self, Stella.TRUE_WRAPPER);
      }
      else if (weight == 0.0) {
        Proposition.assignTruthValue(self, Stella.FALSE_WRAPPER);
      }
      else if ((tv == Logic.TRUE_TRUTH_VALUE) ||
          ((tv == Logic.FALSE_TRUTH_VALUE) ||
           (tv == null))) {
        { TruthValue self000 = TruthValue.newTruthValue();

          self000.positiveScore = weight;
          { Proposition object000 = self;
            TruthValue value000 = self000;
            Stella_Object oldValue001 = object000.truthValue;
            Stella_Object newValue000 = Stella_Object.updateInContext(oldValue001, value000, object000.homeContext, false);

            if (!((oldValue001 != null) &&
                (oldValue001.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
              object000.truthValue = newValue000;
            }
          }
        }
      }
      else {
        ((TruthValue)(Stella_Object.accessInContext(self.truthValue, self.homeContext, false))).positiveScore = weight;
      }
    }
  }

  public static void updatePropositionTruthValue(Proposition self, Keyword updatemode) {
    if (updatemode == Logic.KWD_ASSERT_TRUE) {
      Proposition.assignTruthValue(self, Stella.TRUE_WRAPPER);
    }
    else if (updatemode == Logic.KWD_ASSERT_FALSE) {
      Proposition.assignTruthValue(self, Stella.FALSE_WRAPPER);
    }
    else if (updatemode == Logic.KWD_PRESUME_TRUE) {
      Proposition.assignTruthValue(self, Logic.DEFAULT_TRUE_TRUTH_VALUE);
    }
    else if (updatemode == Logic.KWD_PRESUME_FALSE) {
      Proposition.assignTruthValue(self, Logic.DEFAULT_FALSE_TRUTH_VALUE);
    }
    else if (updatemode == Logic.KWD_RETRACT_TRUE) {
      if (Proposition.trueP(self) &&
          (!(self.kind == Logic.KWD_FUNCTION))) {
        Proposition.deassignTruthValue(self, updatemode);
      }
    }
    else if (updatemode == Logic.KWD_RETRACT_FALSE) {
      if (Proposition.falseP(self)) {
        Proposition.deassignTruthValue(self, updatemode);
      }
    }
    else if (updatemode == Logic.KWD_CONCEIVE) {
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + updatemode + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    Proposition.runUpdatePropositionDemon(self, updatemode);
  }

  public static void deassignTruthValue(Proposition self, Keyword updatemode) {
    { Proposition object000 = self;
      TruthValue value000 = null;
      Stella_Object oldValue000 = object000.truthValue;
      Stella_Object newValue000 = Stella_Object.updateInContext(oldValue000, value000, object000.homeContext, false);

      if (!((oldValue000 != null) &&
          (oldValue000.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
        object000.truthValue = newValue000;
      }
    }
    if (!(updatemode == Logic.KWD_RETRACT_INCONSISTENT)) {
      Logic.handleOutOfDateInferenceCache(Logic.KWD_RETRACT, self);
      Proposition.updateLinksAndTimestamps(self, updatemode);
    }
  }

  public static void assignTruthValue(Proposition self, Stella_Object truthvalue) {
    { TruthValue oldtruthvalue = ((TruthValue)(Stella_Object.accessInContext(self.truthValue, self.homeContext, false)));
      TruthValue newtruthvalue = null;

      if (truthvalue == Stella.TRUE_WRAPPER) {
        newtruthvalue = Logic.TRUE_TRUTH_VALUE;
      }
      else if (truthvalue == Stella.FALSE_WRAPPER) {
        newtruthvalue = Logic.FALSE_TRUTH_VALUE;
      }
      else {
        newtruthvalue = ((TruthValue)(truthvalue));
      }
      if (oldtruthvalue == newtruthvalue) {
      }
      else if (oldtruthvalue != null) {
        if ((self == Logic.TRUE_PROPOSITION) ||
            (self == Logic.FALSE_PROPOSITION)) {
          Proposition.signalTruthValueClash(self);
        }
        else if (oldtruthvalue == Logic.INCONSISTENT_TRUTH_VALUE) {
        }
        else if (newtruthvalue == Logic.TRUE_TRUTH_VALUE) {
          if (oldtruthvalue == Logic.DEFAULT_TRUE_TRUTH_VALUE) {
            { Proposition object000 = self;
              TruthValue value000 = null;
              Stella_Object oldValue001 = object000.truthValue;
              Stella_Object newValue000 = Stella_Object.updateInContext(oldValue001, value000, object000.homeContext, false);

              if (!((oldValue001 != null) &&
                  (oldValue001.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
                object000.truthValue = newValue000;
              }
            }
            Proposition.assignTruthValue(self, newtruthvalue);
          }
          else if (oldtruthvalue == Logic.DEFAULT_FALSE_TRUTH_VALUE) {
            Proposition.deassignTruthValue(self, Logic.KWD_RETRACT_FALSE);
            Proposition.assignTruthValue(self, newtruthvalue);
          }
          else if (oldtruthvalue == Logic.FALSE_TRUTH_VALUE) {
            Proposition.signalTruthValueClash(self);
          }
        }
        else if (newtruthvalue == Logic.FALSE_TRUTH_VALUE) {
          if (oldtruthvalue == Logic.DEFAULT_FALSE_TRUTH_VALUE) {
            { Proposition object001 = self;
              TruthValue value001 = null;
              Stella_Object oldValue002 = object001.truthValue;
              Stella_Object newValue001 = Stella_Object.updateInContext(oldValue002, value001, object001.homeContext, false);

              if (!((oldValue002 != null) &&
                  (oldValue002.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
                object001.truthValue = newValue001;
              }
            }
            Proposition.assignTruthValue(self, newtruthvalue);
          }
          else if (oldtruthvalue == Logic.DEFAULT_TRUE_TRUTH_VALUE) {
            Proposition.deassignTruthValue(self, Logic.KWD_RETRACT_TRUE);
            Proposition.assignTruthValue(self, newtruthvalue);
          }
          else if (oldtruthvalue == Logic.TRUE_TRUTH_VALUE) {
            Proposition.signalTruthValueClash(self);
          }
        }
        else if (newtruthvalue == Logic.DEFAULT_TRUE_TRUTH_VALUE) {
          if (((Boolean)(Logic.$DEFERINGDEFAULTFORWARDINFERENCESp$.get())).booleanValue()) {
            Logic.getPropagationEnvironment(((Context)(Stella.$CONTEXT$.get()))).deferDefaultProposition(self);
            return;
          }
          else if ((oldtruthvalue == Logic.TRUE_TRUTH_VALUE) ||
              (oldtruthvalue == Logic.FALSE_TRUTH_VALUE)) {
          }
          else if (oldtruthvalue == Logic.DEFAULT_FALSE_TRUTH_VALUE) {
            Proposition.deassignTruthValue(self, Logic.KWD_RETRACT_FALSE);
          }
        }
        else if (newtruthvalue == Logic.DEFAULT_FALSE_TRUTH_VALUE) {
          if (((Boolean)(Logic.$DEFERINGDEFAULTFORWARDINFERENCESp$.get())).booleanValue()) {
            Logic.getPropagationEnvironment(((Context)(Stella.$CONTEXT$.get()))).deferDefaultProposition(self);
            return;
          }
          else if ((oldtruthvalue == Logic.FALSE_TRUTH_VALUE) ||
              (oldtruthvalue == Logic.TRUE_TRUTH_VALUE)) {
          }
          else if (oldtruthvalue == Logic.DEFAULT_TRUE_TRUTH_VALUE) {
            Proposition.deassignTruthValue(self, Logic.KWD_RETRACT_TRUE);
          }
        }
        else if (newtruthvalue == Logic.INCONSISTENT_TRUTH_VALUE) {
          if ((oldtruthvalue == Logic.TRUE_TRUTH_VALUE) ||
              (oldtruthvalue == Logic.DEFAULT_TRUE_TRUTH_VALUE)) {
            Proposition.deassignTruthValue(self, Logic.KWD_RETRACT_TRUE);
          }
          else if ((oldtruthvalue == Logic.FALSE_TRUTH_VALUE) ||
              (oldtruthvalue == Logic.DEFAULT_FALSE_TRUTH_VALUE)) {
            Proposition.deassignTruthValue(self, Logic.KWD_RETRACT_FALSE);
          }
          Proposition.assignTruthValue(self, newtruthvalue);
        }
        else {
          Proposition.signalTruthValueClash(self);
        }
      }
      else if (self.kind == Logic.KWD_FUNCTION) {
        { Proposition object002 = self;
          TruthValue value002 = Logic.TRUE_TRUTH_VALUE;
          Stella_Object oldValue003 = object002.truthValue;
          Stella_Object newValue002 = Stella_Object.updateInContext(oldValue003, value002, object002.homeContext, false);

          if (!((oldValue003 != null) &&
              (oldValue003.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
            object002.truthValue = newValue002;
          }
        }
      }
      else if (newtruthvalue == Logic.INCONSISTENT_TRUTH_VALUE) {
        { Proposition object003 = self;
          TruthValue value003 = newtruthvalue;
          Stella_Object oldValue004 = object003.truthValue;
          Stella_Object newValue003 = Stella_Object.updateInContext(oldValue004, value003, object003.homeContext, false);

          if (!((oldValue004 != null) &&
              (oldValue004.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
            object003.truthValue = newValue003;
          }
        }
      }
      else {
        { Proposition object004 = self;
          TruthValue value004 = newtruthvalue;
          Stella_Object oldValue005 = object004.truthValue;
          Stella_Object newValue004 = Stella_Object.updateInContext(oldValue005, value004, object004.homeContext, false);

          if (!((oldValue005 != null) &&
              (oldValue005.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
            object004.truthValue = newValue004;
          }
        }
        Logic.handleOutOfDateInferenceCache(Logic.KWD_ASSERT, self);
        if (newtruthvalue == Logic.TRUE_TRUTH_VALUE) {
          Proposition.updateLinksAndTimestamps(self, Logic.KWD_ASSERT_TRUE);
        }
        else if (newtruthvalue == Logic.FALSE_TRUTH_VALUE) {
          Proposition.updateLinksAndTimestamps(self, Logic.KWD_ASSERT_FALSE);
        }
        else if (newtruthvalue == Logic.DEFAULT_TRUE_TRUTH_VALUE) {
          Proposition.updateLinksAndTimestamps(self, Logic.KWD_PRESUME_TRUE);
        }
        else if (newtruthvalue == Logic.DEFAULT_FALSE_TRUTH_VALUE) {
          Proposition.updateLinksAndTimestamps(self, Logic.KWD_PRESUME_FALSE);
        }
        Logic.reactToKbUpdate(((Context)(Stella.$CONTEXT$.get())), self);
      }
    }
  }

  public static void updateLinksAndTimestamps(Proposition proposition, Keyword updatemode) {
    if (proposition == null) {
      return;
    }
    Logic.updateNowTimestamp(Logic.KWD_UPDATE_PROPOSITION);
    if ((updatemode == Logic.KWD_ASSERT_TRUE) ||
        (updatemode == Logic.KWD_PRESUME_TRUE)) {
      Proposition.runGoesTrueDemons(proposition);
    }
    else if ((updatemode == Logic.KWD_ASSERT_FALSE) ||
        (updatemode == Logic.KWD_PRESUME_FALSE)) {
      Proposition.runGoesFalseDemons(proposition);
    }
    else if (updatemode == Logic.KWD_RETRACT_TRUE) {
      Proposition.runGoesUnknownDemons(proposition);
    }
    else if (updatemode == Logic.KWD_RETRACT_FALSE) {
      Proposition.runGoesUnknownDemons(proposition);
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + updatemode + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static void runGoesUnknownDemons(Proposition proposition) {
    { Keyword testValue000 = proposition.kind;

      if (testValue000 == Logic.KWD_ISA) {
        { Stella_Object argument = (proposition.arguments.theArray)[0];

          if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(argument), Logic.SGT_LOGIC_SKOLEM)) {
            { Skolem argument000 = ((Skolem)(argument));

              { Surrogate skolemtype = argument000.skolemType;

                if ((skolemtype == ((Surrogate)(proposition.operator))) &&
                    (!(skolemtype == Logic.SGT_STELLA_THING))) {
                  {
                    Stella.STANDARD_OUTPUT.nativeStream.println("Can't retract skolem type of `" + argument000 + "' equaling `" + skolemtype.symbolName + "'.");
                    Stella.STANDARD_OUTPUT.nativeStream.println();
                  }
;
                }
              }
            }
          }
          else {
          }
        }
        Proposition.runTruthChangeDemon(proposition, Logic.SGT_PL_KERNEL_KB_GOES_UNKNOWN_DEMON);
      }
      else if ((testValue000 == Logic.KWD_PREDICATE) ||
          (testValue000 == Logic.KWD_FUNCTION)) {
        Proposition.runTruthChangeDemon(proposition, Logic.SGT_PL_KERNEL_KB_GOES_UNKNOWN_DEMON);
      }
      else if (testValue000 == Logic.KWD_IMPLIES) {
        Description.dropTaxonomyImpliesSubsumesLink(((Description)((proposition.arguments.theArray)[0])), ((Description)((proposition.arguments.theArray)[1])));
        Proposition.reviseEquivalences(proposition, false);
        { Proposition p = ((Proposition)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_MASTER_PROPOSITION, null)));

          if ((p != null) &&
              Proposition.trueP(p)) {
            Proposition.deassignTruthValue(p, Logic.KWD_RETRACT_TRUE);
          }
        }
      }
      else if (testValue000 == Logic.KWD_FORALL) {
        { Proposition p = null;
          Cons iter000 = proposition.satellitePropositions().theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            p = ((Proposition)(iter000.value));
            Proposition.deassignTruthValue(p, Logic.KWD_RETRACT_TRUE);
          }
        }
      }
      else {
      }
    }
    return;
  }

  public static void runGoesFalseDemons(Proposition proposition) {
    { Keyword testValue000 = proposition.kind;

      if ((testValue000 == Logic.KWD_FUNCTION) ||
          ((testValue000 == Logic.KWD_ISA) ||
           (testValue000 == Logic.KWD_PREDICATE))) {
        Proposition.runTruthChangeDemon(proposition, Logic.SGT_PL_KERNEL_KB_GOES_FALSE_DEMON);
      }
      else {
      }
    }
    return;
  }

  public static void runGoesTrueDemons(Proposition proposition) {
    { Keyword testValue000 = proposition.kind;

      if ((testValue000 == Logic.KWD_FUNCTION) ||
          (testValue000 == Logic.KWD_ISA)) {
        Proposition.runTruthChangeDemon(proposition, Logic.SGT_PL_KERNEL_KB_GOES_TRUE_DEMON);
      }
      else if (testValue000 == Logic.KWD_PREDICATE) {
        { NamedDescription description = Logic.getDescription(((Surrogate)(proposition.operator)));

          if (Logic.singleValuedTermP(description)) {
            Proposition.clipOrClashWithOldPredicateValue(proposition);
          }
        }
        Proposition.runTruthChangeDemon(proposition, Logic.SGT_PL_KERNEL_KB_GOES_TRUE_DEMON);
      }
      else if (testValue000 == Logic.KWD_IMPLIES) {
        if ((!Stella_Object.isaP((proposition.arguments.theArray)[0], Logic.SGT_LOGIC_DESCRIPTION)) ||
            (!Stella_Object.isaP((proposition.arguments.theArray)[1], Logic.SGT_LOGIC_DESCRIPTION))) {
          return;
        }
        if (!Logic.descriptionModeP()) {
          Description.addTaxonomyImpliesSubsumesLink(((Description)((proposition.arguments.theArray)[0])), ((Description)((proposition.arguments.theArray)[1])));
        }
        Proposition.reviseEquivalences(proposition, true);
        if (((Module)(Stella.$MODULE$.get())) == ((Context)(Stella.$CONTEXT$.get()))) {
          Logic.bumpInferableTimestamp();
        }
        Proposition.flushInferableDirectSubdescriptionsCache(proposition);
      }
      else if (testValue000 == Logic.KWD_FORALL) {
        if (proposition.satellitePropositions() == Stella.NIL_LIST) {
          Proposition.deriveSatelliteRules(proposition);
        }
        Logic.bumpInferableTimestamp();
      }
      else {
      }
    }
    return;
  }

  public static void runTruthChangeDemon(Proposition proposition, Surrogate truthchangerelation) {
    { NamedDescription description = Logic.getDescription(((Surrogate)(proposition.operator)));
      Stella_Object demoncomputation = ((description != null) ? Logic.accessBinaryValue(description, truthchangerelation) : ((Stella_Object)(null)));

      if (demoncomputation != null) {
        { java.lang.reflect.Method functioncode = ComputedProcedure.functionCodeFromProcedure(((ComputedProcedure)(demoncomputation)));

          if (functioncode != null) {
            edu.isi.stella.javalib.Native.funcall(functioncode, null, new java.lang.Object [] {proposition});
          }
        }
      }
    }
  }

  public static void runUpdatePropositionDemon(Proposition proposition, Keyword updatemode) {
    if (((ObjectStore)(KeyValueList.dynamicSlotValue(((Module)(Stella.$MODULE$.get())).dynamicSlots, Logic.SYM_LOGIC_OBJECT_STORE, null))) != null) {
      ((ObjectStore)(KeyValueList.dynamicSlotValue(((Module)(Stella.$MODULE$.get())).dynamicSlots, Logic.SYM_LOGIC_OBJECT_STORE, null))).updatePropositionInStore(proposition, updatemode);
    }
    if (proposition.kind == Logic.KWD_EQUIVALENT) {
      Proposition.runUpdateEquivalencePropositionDemon(proposition, updatemode);
    }
    else {
      Proposition.helpRunUpdatePropositionDemon(proposition, updatemode);
    }
  }

  public static void helpRunUpdatePropositionDemon(Proposition proposition, Keyword updatemode) {
    { NamedDescription description = Logic.getDescription(((Surrogate)(proposition.operator)));
      Stella_Object demoncomputation = ((description != null) ? Logic.accessBinaryValue(description, Logic.SGT_PL_KERNEL_KB_UPDATE_PROPOSITION_DEMON) : ((Stella_Object)(null)));

      if (demoncomputation != null) {
        { java.lang.reflect.Method functioncode = ComputedProcedure.functionCodeFromProcedure(((ComputedProcedure)(demoncomputation)));

          if (functioncode != null) {
            edu.isi.stella.javalib.Native.funcall(functioncode, null, new java.lang.Object [] {proposition, updatemode});
          }
        }
      }
    }
  }

  public static void runUpdateEquivalencePropositionDemon(Proposition proposition, Keyword updatemode) {
    { Stella_Object term1 = (proposition.arguments.theArray)[0];
      Stella_Object term2 = (proposition.arguments.theArray)[1];
      NamedDescription description = (Logic.functionOutputSkolemP(term1) ? Logic.getDescription(((Surrogate)(((Skolem)(term1)).definingProposition.operator))) : ((Logic.functionOutputSkolemP(term2) ? Logic.getDescription(((Surrogate)(((Skolem)(term2)).definingProposition.operator))) : ((NamedDescription)(null)))));
      Stella_Object demoncomputation = ((description != null) ? Logic.accessBinaryValue(description, Logic.SGT_PL_KERNEL_KB_UPDATE_PROPOSITION_DEMON) : ((Stella_Object)(null)));

      if (demoncomputation != null) {
        { java.lang.reflect.Method functioncode = ComputedProcedure.functionCodeFromProcedure(((ComputedProcedure)(demoncomputation)));

          if (functioncode != null) {
            edu.isi.stella.javalib.Native.funcall(functioncode, null, new java.lang.Object [] {proposition, updatemode});
          }
        }
      }
    }
  }

  public static void clipOrClashWithOldPredicateValue(Proposition proposition) {
    { Vector arguments = proposition.arguments;
      int countminustwo = arguments.length() - 2;

      { Proposition p = null;
        Iterator iter000 = Logic.allTrueDependentPropositions((arguments.theArray)[0], ((Surrogate)(proposition.operator)), false);

        while (iter000.nextP()) {
          p = ((Proposition)(iter000.value));
          { boolean alwaysP000 = true;

            { int i = Stella.NULL_INTEGER;
              int iter001 = 1;
              int upperBound000 = countminustwo;
              boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

              loop001 : for (;unboundedP000 ||
                        (iter001 <= upperBound000); iter001 = iter001 + 1) {
                i = iter001;
                if (!Stella_Object.eqlP(Logic.valueOf((arguments.theArray)[i]), Logic.valueOf((p.arguments.theArray)[i]))) {
                  alwaysP000 = false;
                  break loop001;
                }
              }
            }
            if (alwaysP000) {
              if (Stella_Object.eqlP(Logic.valueOf((p.arguments.theArray)[(p.arguments.length() - 1)]), Logic.valueOf(arguments.last()))) {
              }
              else if (((Boolean)(Logic.$CLIPPINGENABLEDp$.get())).booleanValue() &&
                  Logic.worldStateP(((Context)(Stella.$CONTEXT$.get())))) {
                Proposition.deassignTruthValue(p, Logic.KWD_RETRACT_TRUE);
              }
              else {
                Proposition.equateValues(proposition, Logic.valueOf((p.arguments.theArray)[(p.arguments.length() - 1)]), Logic.valueOf(arguments.last()));
              }
            }
          }
        }
      }
    }
  }

  public static Stella_Object lastArgument(Proposition proposition) {
    return ((proposition.arguments.theArray)[(proposition.arguments.length() - 1)]);
  }

  public static Surrogate getPropositionBaseOperator(Proposition prop) {
    if (prop.kind == Logic.KWD_EQUIVALENT) {
      { Stella_Object term1 = (prop.arguments.theArray)[0];
        Stella_Object term2 = (prop.arguments.theArray)[1];

        if (Logic.functionOutputSkolemP(term1)) {
          return (((Surrogate)(((Skolem)(term1)).definingProposition.operator)));
        }
        else if (Logic.functionOutputSkolemP(term2)) {
          return (((Surrogate)(((Skolem)(term2)).definingProposition.operator)));
        }
        else {
          return (((Surrogate)(prop.operator)));
        }
      }
    }
    return (((Surrogate)(prop.operator)));
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { Proposition self = this;

      Logic.printTopLevelObject(self, stream);
    }
  }

  public static Stella_Object accessPropositionSlotValue(Proposition self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_STELLA_HOME_CONTEXT) {
      if (setvalueP) {
        self.homeContext = ((Context)(value));
      }
      else {
        value = self.homeContext;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_KIND) {
      if (setvalueP) {
        self.kind = ((Keyword)(value));
      }
      else {
        value = self.kind;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_TRUTH_VALUE) {
      if (setvalueP) {
        { Proposition object000 = self;
          TruthValue value000 = ((TruthValue)(value));
          Stella_Object oldValue000 = object000.truthValue;
          Stella_Object newValue000 = Stella_Object.updateInContext(oldValue000, value000, object000.homeContext, false);

          if (!((oldValue000 != null) &&
              (oldValue000.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
            object000.truthValue = newValue000;
          }
        }
      }
      else {
        value = ((TruthValue)(Stella_Object.accessInContext(self.truthValue, self.homeContext, false)));
      }
    }
    else if (slotname == Logic.SYM_STELLA_ARGUMENTS) {
      if (setvalueP) {
        self.arguments = ((Vector)(value));
      }
      else {
        value = self.arguments;
      }
    }
    else if (slotname == Logic.SYM_STELLA_OPERATOR) {
      if (setvalueP) {
        self.operator = ((GeneralizedSymbol)(value));
      }
      else {
        value = self.operator;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_RELATIONREF) {
      if (setvalueP) {
        self.operator = ((Surrogate)(value));
      }
      else {
        value = ((Surrogate)(self.operator));
      }
    }
    else if (slotname == Logic.SYM_LOGIC_DEPENDENT_PROPOSITIONS) {
      if (setvalueP) {
        self.dependentPropositions = ((NonPagingIndex)(value));
      }
      else {
        value = self.dependentPropositions;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_VARIABLE_TYPEp) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_VARIABLE_TYPEp, ((BooleanWrapper)(value)), null);
      }
      else {
        value = self.variableTypeP();
      }
    }
    else if (slotname == Logic.SYM_LOGIC_SATELLITE_PROPOSITIONS) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_SATELLITE_PROPOSITIONS, ((List)(value)), null);
      }
      else {
        value = self.satellitePropositions();
      }
    }
    else if (slotname == Logic.SYM_LOGIC_PROPOSITION_ORIGINATED_PROPOSITIONS) {
      if (setvalueP) {
        Logic.originatedPropositionsSetter(self, ((List)(value)));
      }
      else {
        value = Logic.originatedPropositions(self);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_PROPOSITION_STRINGIFIED_SOURCE) {
      if (setvalueP) {
        Logic.stringifiedSourceSetter(self, ((StringWrapper)(value)).wrapperValue);
      }
      else {
        value = StringWrapper.wrapString(Logic.stringifiedSource(self));
      }
    }
    else if (slotname == Logic.SYM_LOGIC_UNFASTENEDp) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_UNFASTENEDp, ((BooleanWrapper)(value)), null);
      }
      else {
        value = self.unfastenedP();
      }
    }
    else if (slotname == Logic.SYM_LOGIC_WEIGHT_DELTA) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_WEIGHT_DELTA, FloatWrapper.wrapFloat(((FloatWrapper)(value)).wrapperValue), Stella.NULL_FLOAT_WRAPPER);
      }
      else {
        value = FloatWrapper.wrapFloat(self.weightDelta());
      }
    }
    else if (slotname == Logic.SYM_LOGIC_SUPPORT) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_SUPPORT, ((Cons)(value)), null);
      }
      else {
        value = self.support();
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
    { Proposition self = this;

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

  public Cons support() {
    { Proposition self = this;

      { Cons answer = ((Cons)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_SUPPORT, null)));

        if (answer == null) {
          return (Stella.NIL);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public double weightDelta() {
    { Proposition self = this;

      { double answer = ((FloatWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_WEIGHT_DELTA, Stella.NULL_FLOAT_WRAPPER))).wrapperValue;

        if (answer == Stella.NULL_FLOAT) {
          return (0.0);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public BooleanWrapper unfastenedP() {
    { Proposition self = this;

      { BooleanWrapper answer = ((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_UNFASTENEDp, null)));

        if (answer == null) {
          return (Stella.FALSE_WRAPPER);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public List satellitePropositions() {
    { Proposition self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_SATELLITE_PROPOSITIONS, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public BooleanWrapper variableTypeP() {
    { Proposition self = this;

      { BooleanWrapper answer = ((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_VARIABLE_TYPEp, null)));

        if (answer == null) {
          return (Stella.FALSE_WRAPPER);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public Surrogate primaryType() {
    { Proposition self = this;

      return (Logic.SGT_LOGIC_PROPOSITION);
    }
  }

}

