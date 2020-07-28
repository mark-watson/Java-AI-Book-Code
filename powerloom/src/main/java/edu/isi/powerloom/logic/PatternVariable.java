//  -*- Mode: Java -*-
//
// PatternVariable.java

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

/** A variable in a logical expression.
 * @author Stella Java Translator
 */
public class PatternVariable extends Skolem {
    public int boundToOffset;

  public static PatternVariable newPatternVariable() {
    { PatternVariable self = null;

      self = new PatternVariable();
      self.dependentPropositionsIndex = null;
      self.dynamicSlots = KeyValueList.newKeyValueList();
      self.surrogateValueInverse = null;
      self.variableValueInverse = null;
      self.homeContext = ((Module)(Stella.$MODULE$.get()));
      self.definingProposition = null;
      self.variableValue = null;
      self.skolemType = null;
      self.skolemName = null;
      self.boundToOffset = Stella.NULL_INTEGER;
      LogicObject.logLogicObject(self);
      return (self);
    }
  }

  public static Skolem createSkolemForUnmappedVariable(PatternVariable variable, KeyValueMap mapping) {
    { Stella_Object skolem = mapping.lookup(variable);
      List createdskolems = ((List)(mapping.lookup(Logic.KWD_CREATED_SKOLEMS)));

      if (skolem != null) {
        return (((Skolem)(skolem)));
      }
      skolem = Logic.createVariableOrSkolem(variable.skolemType, null);
      mapping.insertAt(variable, skolem);
      if (createdskolems == null) {
        createdskolems = List.list(Stella.NIL);
        mapping.insertAt(Logic.KWD_CREATED_SKOLEMS, createdskolems);
      }
      createdskolems.insert(skolem);
      return (((Skolem)(skolem)));
    }
  }

  public static PatternVariable copyVariable(PatternVariable self, KeyValueMap mapping) {
    { PatternVariable copy = ((PatternVariable)(mapping.lookup(self)));

      if (copy != null) {
        return (copy);
      }
      copy = Logic.createVariable(self.skolemType, self.skolemName, false);
      if ((((Keyword)(Logic.$PRINTMODE$.get())) == Logic.KWD_REALISTIC) ||
          (((Keyword)(Logic.$PRINTMODE$.get())) == Logic.KWD_FLAT)) {
        copy.skolemName = self.skolemName;
      }
      else {
        { String copyname = "?CP_" + Native.string_subsequence(self.skolemName.symbolName, 1, Stella.NULL_INTEGER);

          copy.skolemName = Symbol.internSymbol(copyname);
        }
      }
      copy.skolemType = self.skolemType;
      if (((Stella_Object)(Stella_Object.accessInContext(self.variableValue, self.homeContext, false))) != null) {
        { PatternVariable object000 = copy;
          Stella_Object value000 = ((Stella_Object)(Stella_Object.accessInContext(self.variableValue, self.homeContext, false)));
          Stella_Object oldValue002 = object000.variableValue;
          Stella_Object newValue000 = Stella_Object.updateInContext(oldValue002, value000, object000.homeContext, false);

          if (!((oldValue002 != null) &&
              (oldValue002.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
            object000.variableValue = newValue000;
          }
        }
      }
      mapping.insertAt(self, copy);
      return (copy);
    }
  }

  public static void simulateBindVariableAndPropagateConstraints(PatternVariable variable, List goalsequence) {
    { GoalRecord goalrecord = PatternVariable.goalRecord(variable);

      Logic.simulateBindVariableToValue(variable);
      Logic.collectClosedGoals(goalrecord.generatorGoals, goalsequence);
      Logic.collectClosedGoals(goalrecord.otherGoals, goalsequence);
      { Proposition g = null;
        Cons iter000 = goalrecord.generatorGoals.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          g = ((Proposition)(iter000.value));
          Proposition.propagateSingleValuedConstraints(g, goalsequence);
        }
      }
      { Proposition g = null;
        Cons iter001 = goalrecord.otherGoals.theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          g = ((Proposition)(iter001.value));
          Proposition.propagateSingleValuedConstraints(g, goalsequence);
        }
      }
    }
  }

  public static Proposition cheapestGeneratorGoal(PatternVariable variable, Object [] MV_returnarray) {
    if ((Stella.$TRACED_KEYWORDS$ != null) &&
        Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_OPTIMIZER)) {
      {
        Stella.STANDARD_OUTPUT.nativeStream.println();
        Stella.STANDARD_OUTPUT.nativeStream.println("CHEAPEST: " + variable + " GENERATORS: " + PatternVariable.goalRecord(variable).generatorGoals);
      }
;
    }
    { Proposition bestgoal = null;
      double bestcost = Stella.NULL_FLOAT;
      double bestfanout = Stella.NULL_FLOAT;
      double generatorcost = Stella.NULL_FLOAT;
      double generatorfanout = Stella.NULL_FLOAT;

      { Proposition goal = null;
        Cons iter000 = PatternVariable.goalRecord(variable).generatorGoals.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          goal = ((Proposition)(iter000.value));
          generatorcost = Proposition.estimateGoalCost(goal);
          generatorfanout = Proposition.estimateGoalFanout(goal);
          if ((generatorfanout != Stella.NULL_FLOAT) &&
              ((bestfanout == Stella.NULL_FLOAT) ||
               ((generatorfanout < bestfanout) ||
                ((generatorfanout == bestfanout) &&
                 (generatorcost < bestcost))))) {
            if ((generatorfanout == 1.0) &&
                (generatorcost == 1.0)) {
              { Proposition _return_temp = goal;

                MV_returnarray[0] = FloatWrapper.wrapFloat(1.0);
                MV_returnarray[1] = FloatWrapper.wrapFloat(1.0);
                return (_return_temp);
              }
            }
            bestgoal = goal;
            bestfanout = generatorfanout;
            bestcost = generatorcost;
          }
        }
      }
      if (bestfanout != Stella.NULL_FLOAT) {
        {
          if ((Stella.$TRACED_KEYWORDS$ != null) &&
              Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_OPTIMIZER)) {
            Stella.STANDARD_OUTPUT.nativeStream.println("  SELECTED: " + bestgoal + "  " + bestcost + "  " + bestfanout);
          }
          { Proposition _return_temp = bestgoal;

            MV_returnarray[0] = FloatWrapper.wrapFloat(bestcost);
            MV_returnarray[1] = FloatWrapper.wrapFloat(bestfanout);
            return (_return_temp);
          }
        }
      }
      else {
        { Proposition _return_temp = null;

          MV_returnarray[0] = FloatWrapper.wrapFloat(0.0);
          MV_returnarray[1] = FloatWrapper.wrapFloat(0.0);
          return (_return_temp);
        }
      }
    }
  }

  public static GoalRecord goalRecord(PatternVariable variable) {
    return (((GoalRecord)((((ExtensibleVector)(KeyValueList.dynamicSlotValue(((QueryIterator)(Logic.$QUERYITERATOR$.get())).dynamicSlots, Logic.SYM_LOGIC_OPTIMIZER_GOAL_RECORDS, null))).theArray)[(variable.boundToOffset)])));
  }

  public static boolean variableBoundP(PatternVariable variable) {
    return ((PatternVariable.safeBoundTo(variable) != null) ||
        (((Stella_Object)(Stella_Object.accessInContext(variable.variableValue, variable.homeContext, false))) != null));
  }

  public static Stella_Object generateOneQuantifiedVariable(PatternVariable self, boolean typedP) {
    { Symbol name = PatternVariable.generateNameOfVariable(self);

      if (typedP &&
          (!(Logic.logicalType(self) == Logic.SGT_STELLA_THING))) {
        return (Cons.cons(name, Cons.cons(Surrogate.symbolize(Logic.logicalType(self)), Stella.NIL)));
      }
      else {
        return (name);
      }
    }
  }

  public static Stella_Object generateOneVariable(PatternVariable self, boolean typedP) {
    { Stella_Object value = null;

      if (((Justification)(Logic.$CURRENTJUSTIFICATION$.get())) != null) {
        value = Logic.justificationArgumentBoundTo(self, null);
      }
      if (value == null) {
        value = Logic.safeArgumentBoundTo(self);
      }
      if ((value != null) &&
          ((!(value == self)) &&
           (!Skolem.quantifiedObjectVariableP(self)))) {
        return (Logic.generateTerm(value));
      }
      else {
        { Symbol name = PatternVariable.generateNameOfVariable(self);

          if (typedP &&
              (!(Logic.logicalType(self) == Logic.SGT_STELLA_THING))) {
            return (Cons.cons(name, Cons.cons(Surrogate.symbolize(Logic.logicalType(self)), Stella.NIL)));
          }
          else {
            return (name);
          }
        }
      }
    }
  }

  public static Symbol generateNameOfVariable(PatternVariable self) {
    if (((KeyValueMap)(Logic.$SKOLEMNAMEMAPPINGTABLE$.get())) != null) {
      { Skolem temp000 = ((Skolem)(((KeyValueMap)(Logic.$SKOLEMNAMEMAPPINGTABLE$.get())).lookup(self)));

        self = ((temp000 != null) ? ((PatternVariable)(temp000)) : self);
      }
    }
    if (((KeyValueList)(Logic.$CANONICALVARIABLENAMEMAPPING$.get())) == null) {
      return (self.skolemName);
    }
    { Stella_Object canonicalname = ((KeyValueList)(Logic.$CANONICALVARIABLENAMEMAPPING$.get())).lookup(self);

      if (canonicalname == null) {
        canonicalname = ((Symbol)(Logic.SYSTEM_DEFINED_ARGUMENT_NAMES.nth(Native.setIntSpecial(Logic.$CANONICALVARIABLECOUNTER$, ((Integer)(Logic.$CANONICALVARIABLECOUNTER$.get())).intValue() + 1))));
        ((KeyValueList)(Logic.$CANONICALVARIABLENAMEMAPPING$.get())).insertAt(self, canonicalname);
      }
      return (((Symbol)(canonicalname)));
    }
  }

  public static void printQuantifiedVariable(PatternVariable self, OutputStream stream) {
    if (((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue()) {
      PatternVariable.printVariableName(self, stream);
    }
    else {
      PatternVariable.printVariable(self, stream);
    }
  }

  public static void printVariable(PatternVariable self, OutputStream stream) {
    if ((((Justification)(Logic.$CURRENTJUSTIFICATION$.get())) != null) &&
        (Logic.justificationArgumentBoundTo(self, null) != null)) {
      Logic.prettyPrintLogicalForm(Logic.justificationArgumentBoundTo(self, null), stream);
      return;
    }
    { Stella_Object value = ((((ControlFrame)(Logic.$PRINTINFRAME$.get())) != null) ? PatternVariable.boundToInFrame(self, ((ControlFrame)(Logic.$PRINTINFRAME$.get()))) : PatternVariable.safeBoundTo(self));

      if (value != null) {
        PatternVariable.printVariableName(self, stream);
        stream.nativeStream.print(Logic.VARIABLE_BINDING_SEPARATOR);
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Logic.printVariableValue(value, stream);
            return;

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
      }
    }
    Skolem.printValueOfChain(self, stream, Logic.innermostOf(self));
  }

  public static void printVariableName(PatternVariable self, OutputStream stream) {
    Skolem.printSkolemName(self, stream);
  }

  public static void printKifVariable(PatternVariable self) {
    { OutputStream stream = ((OutputStream)(Logic.$PRINTLOGICALFORMSTREAM$.get()));

      if (Skolem.quantifiedObjectVariableP(self)) {
        PatternVariable.printQuantifiedVariable(self, stream);
      }
      else {
        PatternVariable.printVariable(self, stream);
      }
    }
  }

  public static int hashUnboundGoalVariable(PatternVariable var, Vector arguments, int code) {
    { int varindex = 1;

      { Stella_Object arg = null;
        Vector vector000 = arguments;
        int index000 = 0;
        int length000 = vector000.length();
        int i = Stella.NULL_INTEGER;
        int iter000 = 0;

        for (;index000 < length000; index000 = index000 + 1, iter000 = iter000 + 1) {
          arg = (vector000.theArray)[index000];
          i = iter000;
          if (var == arg) {
            return (Stella.hashString("#v", code + varindex));
          }
          else if (Stella_Object.isaP(arg, Logic.SGT_LOGIC_PATTERN_VARIABLE) &&
              (arguments.position(arg, 0) == i)) {
            varindex = varindex + 1;
          }
        }
      }
      throw ((StellaException)(StellaException.newStellaException("Shouldn't get here!").fillInStackTrace()));
    }
  }

  public static void printOneVariableBinding(PatternVariable variable) {
    Stella.STANDARD_OUTPUT.nativeStream.print(variable.skolemName + "=");
    if (variable.boundToOffset != Stella.NULL_INTEGER) {
      { Stella_Object value = ((((ControlFrame)(Logic.$PRINTINFRAME$.get())) != null) ? PatternVariable.boundToInFrame(variable, ((ControlFrame)(Logic.$PRINTINFRAME$.get()))) : PatternVariable.safeBoundTo(variable));

        Logic.printUnformattedLogicalForm(value, Stella.STANDARD_OUTPUT);
      }
    }
    else {
      Stella.STANDARD_OUTPUT.nativeStream.print(Logic.SYM_STELLA_NULL);
    }
    Stella.STANDARD_OUTPUT.nativeStream.print(" ");
  }

  public static boolean bindVariableToValueP(PatternVariable variable, Stella_Object value, boolean autocleanupP) {
    if ((value == null) ||
        (!Logic.argumentBoundP(value))) {
      if (((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
          (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) &&
          ((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy.allowUnboundVariablesP()) {
        return (true);
      }
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.STANDARD_WARNING.nativeStream.println("WARNING: Tried to bind " + variable + " to NULL value.  Potentially a PowerLoom bug");
          Logic.helpSignalPropositionError(Stella.STANDARD_WARNING, Logic.KWD_WARNING);

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      return (false);
    }
    value = Logic.instantiateExternalBindings(value);
    if (autocleanupP) {
      { PatternRecord patternrecord = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord;
        int ubstackoffset = patternrecord.topUnbindingStackOffset;
        boolean successP = false;

        successP = PatternVariable.helpBindVariableToValueP(variable, value);
        if (!successP) {
          PatternRecord.unbindVariablesBeginningAt(patternrecord, ubstackoffset + 1);
        }
        return (successP);
      }
    }
    else {
      return (PatternVariable.helpBindVariableToValueP(variable, value));
    }
  }

  public static boolean helpBindVariableToValueP(PatternVariable variable, Stella_Object value) {
    if (((Keyword)(Logic.$TYPE_CHECK_STRATEGY$.get())) == Logic.KWD_LOOKUP) {
      { boolean typeisokP = false;

        { Object [] caller_MV_returnarray = new Object[1];

          typeisokP = Logic.checkCoercedTypeP(value, variable.skolemType, true, caller_MV_returnarray);
          value = ((Stella_Object)(caller_MV_returnarray[0]));
        }
        if ((!typeisokP) &&
            Description.nonInferableP(Logic.surrogateToDescription(variable.skolemType))) {
          if ((Stella.$TRACED_KEYWORDS$ != null) &&
              Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_GOAL_TREE)) {
            Stella.STANDARD_OUTPUT.nativeStream.println("*** type violation: var=" + variable.skolemName + " type=" + variable.skolemType + " value=" + value);
          }
          return (false);
        }
      }
    }
    else if (((Keyword)(Logic.$TYPE_CHECK_STRATEGY$.get())) == Logic.KWD_NONE) {
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + ((Keyword)(Logic.$TYPE_CHECK_STRATEGY$.get())) + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    { Stella_Object boundtovalue = (((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord.variableBindings.theArray)[(variable.boundToOffset)];
      Stella_Object variablevalue = ((Stella_Object)(Stella_Object.accessInContext(variable.variableValue, variable.homeContext, false)));

      Logic.elaborateInstance(value);
      if ((variablevalue != null) &&
          (boundtovalue == null)) {
        variablevalue = Logic.valueOf(variablevalue);
        PatternVariable.setPatternVariableBinding(variable, variablevalue);
        return (Stella_Object.eqlP(variablevalue, value));
      }
      else if (boundtovalue == null) {
        PatternVariable.setPatternVariableBinding(variable, value);
      }
      else if (Stella_Object.equalP(Logic.valueOf(boundtovalue), Logic.valueOf(value))) {
        return (true);
      }
      else {
        return (false);
      }
      return (true);
    }
  }

  public static boolean failsAntecedentTypeCheckP(PatternVariable v1, Stella_Object i2) {
    if (((Keyword)(Logic.$TYPE_CHECK_STRATEGY$.get())) == Logic.KWD_LOOKUP) {
      { Surrogate type = v1.skolemType;
        boolean typeisokP = ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
            (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) ||
            Logic.checkStrictTypeP(i2, type, true);

        if ((!typeisokP) &&
            Description.nonInferableP(Logic.surrogateToDescription(type))) {
          return (true);
        }
        else {
          return (false);
        }
      }
    }
    else if (((Keyword)(Logic.$TYPE_CHECK_STRATEGY$.get())) == Logic.KWD_NONE) {
      return (false);
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + ((Keyword)(Logic.$TYPE_CHECK_STRATEGY$.get())) + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static boolean failsUnificationTypeCheckP(PatternVariable v1, Stella_Object i2) {
    if (((Keyword)(Logic.$TYPE_CHECK_STRATEGY$.get())) == Logic.KWD_NONE) {
      return (false);
    }
    else if (((Keyword)(Logic.$TYPE_CHECK_STRATEGY$.get())) == Logic.KWD_LOOKUP) {
      { Surrogate type = v1.skolemType;
        boolean typeisokP = ((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
            (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) ||
            Logic.checkStrictTypeP(i2, type, true);

        if ((!typeisokP) &&
            Description.nonInferableP(Logic.surrogateToDescription(type))) {
          return (true);
        }
        else {
          return (false);
        }
      }
    }
    else if (((Keyword)(Logic.$TYPE_CHECK_STRATEGY$.get())) == Logic.KWD_SHALLOW_DISJOINT) {
      if ((v1.skolemType != null) &&
          NamedDescription.disjointClassesP(Logic.getDescription(v1.skolemType), Logic.getDescription(Logic.logicalType(i2)))) {
        return (true);
      }
      return (false);
    }
    else if (((Keyword)(Logic.$TYPE_CHECK_STRATEGY$.get())) == Logic.KWD_DISJOINT) {
      { Surrogate type1 = null;
        Surrogate type2 = null;

        { Proposition p = null;
          Iterator iter000 = Logic.unfilteredDependentIsaPropositions(v1).allocateIterator();

          loop000 : while (iter000.nextP()) {
            p = ((Proposition)(iter000.value));
            if (p.kind == Logic.KWD_ISA) {
              type1 = ((Surrogate)((p.arguments.theArray)[1]));
              break loop000;
            }
          }
        }
        if (type1 == null) {
          return (false);
        }
        if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(i2), Logic.SGT_LOGIC_LOGIC_OBJECT)) {
          { LogicObject i2000 = ((LogicObject)(i2));

            { Proposition p = null;
              Iterator iter001 = Logic.unfilteredDependentIsaPropositions(i2000).allocateIterator();

              loop001 : while (iter001.nextP()) {
                p = ((Proposition)(iter001.value));
                if (p.kind == Logic.KWD_ISA) {
                  type2 = ((Surrogate)((p.arguments.theArray)[1]));
                  break loop001;
                }
              }
            }
          }
        }
        else {
          type2 = Logic.logicalType(i2);
        }
        if (type2 == null) {
          return (false);
        }
        return (NamedDescription.disjointClassesP(Logic.getDescription(type1), Logic.getDescription(type2)));
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + ((Keyword)(Logic.$TYPE_CHECK_STRATEGY$.get())) + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static Stella_Object boundToInRecord(PatternVariable self, PatternRecord record) {
    return ((record.variableBindings.theArray)[(self.boundToOffset)]);
  }

  public static Stella_Object boundToInFrame(PatternVariable self, ControlFrame frame) {
    { Vector bindings = ControlFrame.operativePatternRecord(frame).variableBindings;
      int offset = self.boundToOffset;

      if ((bindings != null) &&
          ((offset != Stella.NULL_INTEGER) &&
           (offset < bindings.length()))) {
        return ((bindings.theArray)[offset]);
      }
      else {
        return (null);
      }
    }
  }

  public static Stella_Object safeBoundTo(PatternVariable self) {
    if (((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) {
      { Vector bindings = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord.variableBindings;
        int offset = self.boundToOffset;

        if ((bindings != null) &&
            ((offset != Stella.NULL_INTEGER) &&
             (offset < bindings.length()))) {
          return ((bindings.theArray)[offset]);
        }
      }
    }
    return (null);
  }

  public static Stella_Object boundTo(PatternVariable self) {
    return ((((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord.variableBindings.theArray)[(self.boundToOffset)]);
  }

  public static void changePatternVariableBinding(PatternVariable variable, Stella_Object newvalue) {
    { PatternRecord patternrecord = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord;
      int vboffset = variable.boundToOffset;

      (patternrecord.variableBindings.theArray)[vboffset] = newvalue;
    }
  }

  public static void setPatternVariableBinding(PatternVariable variable, Stella_Object value) {
    if ((Stella.$TRACED_KEYWORDS$ != null) &&
        Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_QUERY_STACKS)) {
      Stella.STANDARD_OUTPUT.nativeStream.println("set-pattern-variable-binding: " + variable + " " + value + "  F" + ControlFrame.debugFrameId(((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord.controlFrame));
    }
    { PatternRecord patternrecord = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord;
      int vboffset = variable.boundToOffset;
      int ubstackoffset = patternrecord.topUnbindingStackOffset + 1;

      (patternrecord.variableBindings.theArray)[vboffset] = value;
      patternrecord.topUnbindingStackOffset = ubstackoffset;
      (patternrecord.unbindingStack.theArray)[ubstackoffset] = (IntegerWrapper.wrapInteger(vboffset));
    }
  }

  public static PatternVariable renameLogicVariableApart(PatternVariable variable, boolean destructiveP) {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, variable.homeModule());
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        { Symbol newname = Stella.localGensym(variable.skolemName.symbolName);

          if (!(destructiveP)) {
            variable = PatternVariable.copyVariable(variable, KeyValueMap.newKeyValueMap());
          }
          variable.skolemName = newname;
          return (variable);
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

  public static void addVariableType(PatternVariable variable, Surrogate newtype, KeyValueList table, Cons visiblevariables) {
    if (!visiblevariables.memberP(variable)) {
      return;
    }
    { List types = ((List)(table.lookup(variable)));

      if (types == null) {
        table.insertAt(variable, List.list(Cons.cons(newtype, Stella.NIL)));
      }
      else {
        {
          { Surrogate t = null;
            Cons iter000 = types.theConsList;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              t = ((Surrogate)(iter000.value));
              if (Logic.logicalSubtypeOfP(t, newtype)) {
                return;
              }
              if (Logic.logicalSubtypeOfP(newtype, t)) {
                types.remove(t);
                PatternVariable.addVariableType(variable, newtype, table, visiblevariables);
                return;
              }
            }
          }
          types.insert(newtype);
        }
      }
      Native.setBooleanSpecial(Logic.$ADDEDNEWTYPEp$, true);
    }
  }

  public static boolean freeVariableP(PatternVariable variable, Proposition proposition) {
    { Keyword testValue000 = proposition.kind;

      if ((testValue000 == Logic.KWD_FORALL) ||
          (testValue000 == Logic.KWD_EXISTS)) {
        if (((Vector)(KeyValueList.dynamicSlotValue(proposition.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null))).memberP(variable)) {
          return (false);
        }
      }
      else {
      }
    }
    { boolean alwaysP000 = true;

      { Stella_Object arg = null;
        Vector vector000 = proposition.arguments;
        int index000 = 0;
        int length000 = vector000.length();

        loop000 : for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          if (Stella_Object.isaP(arg, Logic.SGT_LOGIC_PROPOSITION)) {
            if (!PatternVariable.freeVariableP(variable, ((Proposition)(arg)))) {
              alwaysP000 = false;
              break loop000;
            }
          }
        }
      }
      { boolean value000 = alwaysP000;

        return (value000);
      }
    }
  }

  public static boolean topLevelExistentialVariableP(PatternVariable variable, Description description) {
    return ((!description.ioVariables.memberP(variable)) &&
        (description.internalVariables.memberP(variable) &&
         PatternVariable.freeVariableP(variable, description.proposition)));
  }

  public static PatternVariable innermostVariableOf(PatternVariable self) {
    for (;;) {
      { PatternVariable tightestvariable = self;
        Stella_Object value = null;

        for (;;) {
          value = ((Stella_Object)(Stella_Object.accessInContext(tightestvariable.variableValue, tightestvariable.homeContext, false)));
          if ((value != null) &&
              Logic.variableP(value)) {
            tightestvariable = ((PatternVariable)(value));
          }
          else {
            return (tightestvariable);
          }
        }
      }
    }
  }

  public static Stella_Object accessPatternVariableSlotValue(PatternVariable self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_BOUND_TO_OFFSET) {
      if (setvalueP) {
        self.boundToOffset = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.boundToOffset);
      }
    }
    else if (slotname == Logic.SYM_STELLA_VARIABLE_NAME) {
      if (setvalueP) {
        self.skolemName = ((Symbol)(value));
      }
      else {
        value = self.skolemName;
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

  public Surrogate primaryType() {
    { PatternVariable self = this;

      return (Logic.SGT_LOGIC_PATTERN_VARIABLE);
    }
  }

}

