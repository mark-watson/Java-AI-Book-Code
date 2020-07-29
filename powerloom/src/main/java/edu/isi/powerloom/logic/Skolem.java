//  -*- Mode: Java -*-
//
// Skolem.java

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

/** Object whose identity and type are not fixed at creation time.
 * Potentially unifiable with any other object.
 * @author Stella Java Translator
 */
public class Skolem extends LogicObject {
    public Surrogate skolemType;
    public Symbol skolemName;
    public Stella_Object variableValue;
    public Proposition definingProposition;

  public static Skolem newSkolem() {
    { Skolem self = null;

      self = new Skolem();
      self.dependentPropositionsIndex = null;
      self.dynamicSlots = KeyValueList.newKeyValueList();
      self.surrogateValueInverse = null;
      self.variableValueInverse = null;
      self.homeContext = ((Module)(Stella.$MODULE$.get()));
      self.definingProposition = null;
      self.variableValue = null;
      self.skolemName = null;
      self.skolemType = null;
      LogicObject.logLogicObject(self);
      return (self);
    }
  }

  public static Proposition inheritEquivalentProposition(Skolem skolem, Stella_Object value) {
    { Proposition value000 = null;

      { Proposition p = null;
        Iterator iter000 = Logic.unfilteredDependentPropositions(skolem, Logic.SGT_PL_KERNEL_KB_EQUIVALENT).allocateIterator();

        loop000 : while (iter000.nextP()) {
          p = ((Proposition)(iter000.value));
          if ((((Surrogate)(p.operator)) == Logic.SGT_PL_KERNEL_KB_EQUIVALENT) &&
              (Stella_Object.eqlP((p.arguments.theArray)[0], value) ||
               Stella_Object.eqlP((p.arguments.theArray)[1], value))) {
            value000 = p;
            break loop000;
          }
        }
      }
      { Proposition equivalentprop = value000;

        if (equivalentprop == null) {
          equivalentprop = Logic.createProposition(Logic.SYM_LOGIC_EQUIVALENT, 2);
          (equivalentprop.arguments.theArray)[0] = skolem;
          (equivalentprop.arguments.theArray)[1] = value;
        }
        return (equivalentprop);
      }
    }
  }

  public static boolean valueClashesWithSkolemP(Skolem skolem, Stella_Object value) {
    { Surrogate type = skolem.skolemType;

      if (type == null) {
        return (false);
      }
      else if (!(((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
          (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) ||
          Logic.checkStrictTypeP(value, type, true))) {
        return (true);
      }
      else if (Logic.literalTypeP(type) &&
          Logic.logicalSubtypeOfP(type, Logic.SGT_STELLA_NUMBER)) {
        return (!edu.isi.powerloom.pl_kernel_kb.PlKernelKb.satisfiesIntervalBoundsP(skolem, ((NumberWrapper)(value))));
      }
      else {
        return (false);
      }
    }
  }

  public static boolean boundComputationInputSkolemP(Skolem skolem) {
    if (Logic.logicalCollectionP(skolem)) {
      return (true);
    }
    else {
      { Proposition prop = skolem.definingProposition;

        return ((prop != null) &&
            Logic.testPropertyP(Logic.getDescription(((Surrogate)(prop.operator))), Logic.SGT_PL_KERNEL_KB_TOTAL));
      }
    }
  }

  public static Stella_Object generateSkolem(Skolem self) {
    if (Logic.nativeValueOf(self) != null) {
      return (Logic.generateTerm(Logic.nativeValueOf(self)));
    }
    else if (self.definingProposition != null) {
      return (Proposition.generateFunctionAsTerm(self.definingProposition));
    }
    else if ((Logic.innermostOf(self) != null) &&
        (!(self == Logic.innermostOf(self)))) {
      return (Logic.generateTerm(Logic.innermostOf(self)));
    }
    else if (LogicObject.conceptPrototypeP(self)) {
      return (Cons.list$(Cons.cons(Logic.SYM_PL_KERNEL_KB_CONCEPT_PROTOTYPE, Cons.cons(Logic.generateTerm(LogicObject.conceptPrototypeOf(self)), Cons.cons(Stella.NIL, Stella.NIL)))));
    }
    else {
      {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Don't know how to generate skolem: `" + self + "'");
        Stella.STANDARD_WARNING.nativeStream.println();
      }
;
      return (Logic.SYM_LOGIC_UNIDENTIFIED_SKOLEM);
    }
  }

  public static void printSkolem(Skolem self, OutputStream stream, boolean toplevelP) {
    toplevelP = toplevelP;
    { String prefix = "|SK|";

      if ((((Keyword)(Logic.$PRINTMODE$.get())) == Logic.KWD_ORIGINAL) ||
          (((Keyword)(Logic.$PRINTMODE$.get())) == Logic.KWD_REALISTIC)) {
        prefix = "";
        if (Logic.nativeValueOf(self) != null) {
          Logic.printVariableValue(Logic.nativeValueOf(self), stream);
          return;
        }
      }
      else {
      }
      if ((self.definingProposition != null) &&
          (((Stella_Object)(Stella_Object.accessInContext(self.variableValue, self.homeContext, false))) == null)) {
        stream.nativeStream.print(prefix);
        { Object old$Printlogicalformstream$000 = Logic.$PRINTLOGICALFORMSTREAM$.get();
          Object old$Indentcounter$000 = Logic.$INDENTCOUNTER$.get();

          try {
            Native.setSpecial(Logic.$PRINTLOGICALFORMSTREAM$, stream);
            Native.setIntSpecial(Logic.$INDENTCOUNTER$, 20);
            Proposition.printKifFunctionExpression(self.definingProposition);

          } finally {
            Logic.$INDENTCOUNTER$.set(old$Indentcounter$000);
            Logic.$PRINTLOGICALFORMSTREAM$.set(old$Printlogicalformstream$000);
          }
        }
        return;
      }
      Skolem.printValueOfChain(self, stream, Logic.innermostOf(self));
    }
  }

  public static void printSkolemName(Skolem self, OutputStream stream) {
    stream.nativeStream.print(Native.stringDowncase(Skolem.getSkolemPrintName(self)));
  }

  public static void printValueOfChain(Skolem self, OutputStream stream, Stella_Object chainend) {
    if (chainend == null) {
      chainend = self;
    }
    if ((((Keyword)(Logic.$PRINTMODE$.get())) == Logic.KWD_REALISTIC) ||
        (((Keyword)(Logic.$PRINTMODE$.get())) == Logic.KWD_ORIGINAL)) {
      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(self), Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
        { PatternVariable self000 = ((PatternVariable)(self));

          { Object old$Printmode$000 = Logic.$PRINTMODE$.get();

            try {
              Native.setSpecial(Logic.$PRINTMODE$, Logic.KWD_FLAT);
              Skolem.printValueOfChain(self000, stream, chainend);

            } finally {
              Logic.$PRINTMODE$.set(old$Printmode$000);
            }
          }
        }
      }
      else {
        Logic.printVariableValue(chainend, stream);
      }
    }
    else if ((((Keyword)(Logic.$PRINTMODE$.get())) == Logic.KWD_FLAT) ||
        (((Keyword)(Logic.$PRINTMODE$.get())) == Logic.KWD_DEBUG_LOW)) {
      Skolem.printSkolemName(self, stream);
      if (self == chainend) {
        return;
      }
      stream.nativeStream.print(Logic.VALUE_OF_SEPARATOR);
      Logic.printVariableValue(chainend, stream);
    }
    else if (((Keyword)(Logic.$PRINTMODE$.get())) == Logic.KWD_DEBUG_HIGH) {
      Skolem.printSkolemName(self, stream);
      if (self == chainend) {
        return;
      }
      { Stella_Object cursor = self;
        Stella_Object nextvalue = null;

        loop000 : for (;;) {
          { Surrogate testValue000 = Stella_Object.safePrimaryType(cursor);

            if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_SKOLEM)) {
              { Skolem cursor000 = ((Skolem)(cursor));

                nextvalue = ((Stella_Object)(Stella_Object.accessInContext(cursor000.variableValue, cursor000.homeContext, false)));
              }
            }
            else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_LOGIC_OBJECT)) {
              { LogicObject cursor000 = ((LogicObject)(cursor));

                nextvalue = cursor000;
              }
            }
            else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
              { Surrogate cursor000 = ((Surrogate)(cursor));

                nextvalue = cursor000.surrogateValue;
              }
            }
            else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_STELLA_RELATION)) {
              { Relation cursor000 = ((Relation)(cursor));

                nextvalue = ((NamedDescription)(KeyValueList.dynamicSlotValue(cursor000.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTION, null)));
              }
            }
            else {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
          }
          stream.nativeStream.print(Logic.VALUE_OF_SEPARATOR);
          Logic.printVariableValue(nextvalue, stream);
          if (Stella_Object.eqlP(nextvalue, chainend)) {
            break loop000;
          }
          cursor = nextvalue;
        }
      }
    }
    else {
      { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

        stream001.nativeStream.print("`" + ((Keyword)(Logic.$PRINTMODE$.get())) + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static String getSkolemPrintName(Skolem self) {
    if (((KeyValueMap)(Logic.$SKOLEMNAMEMAPPINGTABLE$.get())) != null) {
      { Skolem substituteskolem = ((Skolem)(((KeyValueMap)(Logic.$SKOLEMNAMEMAPPINGTABLE$.get())).lookup(self)));

        return (((substituteskolem != null) ? substituteskolem.skolemName.symbolName : self.skolemName.symbolName));
      }
    }
    else {
      return (self.skolemName.symbolName);
    }
  }

  public static void printKifSkolem(Skolem self, boolean suppressdefiningpropositionP) {
    { OutputStream stream = ((OutputStream)(Logic.$PRINTLOGICALFORMSTREAM$.get()));

      if (Skolem.quantifiedObjectVariableP(self)) {
        Skolem.printSkolemName(self, stream);
      }
      else if (suppressdefiningpropositionP) {
        Skolem.printSkolem(self, stream, false);
      }
      else if (self.definingProposition != null) {
        Proposition.printKifFunctionExpression(self.definingProposition);
      }
      else {
        Skolem.printSkolem(self, stream, false);
      }
    }
  }

  public static boolean quantifiedObjectVariableP(Skolem var) {
    if (((Cons)(Logic.$PRINTQUANTIFIEDOBJECTSSTACK$.get())) != null) {
      { Stella_Object obj = null;
        Cons iter000 = ((Cons)(Logic.$PRINTQUANTIFIEDOBJECTSSTACK$.get()));

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          obj = iter000.value;
          { Surrogate testValue000 = Stella_Object.safePrimaryType(obj);

            if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PROPOSITION)) {
              { Proposition obj000 = ((Proposition)(obj));

                if (((Vector)(KeyValueList.dynamicSlotValue(obj000.dynamicSlots, Logic.SYM_LOGIC_IO_VARIABLES, null))).memberP(var)) {
                  return (true);
                }
              }
            }
            else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_DESCRIPTION)) {
              { Description obj000 = ((Description)(obj));

                if (obj000.ioVariables.memberP(var) ||
                    obj000.internalVariables.memberP(var)) {
                  return (true);
                }
              }
            }
            else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_STELLA_VECTOR)) {
              { Vector obj000 = ((Vector)(obj));

                if (obj000.memberP(var)) {
                  return (true);
                }
              }
            }
            else if (testValue000 == Logic.SGT_STELLA_CONS) {
              { Cons obj000 = ((Cons)(obj));

                if (obj000.memberP(var)) {
                  return (true);
                }
              }
            }
            else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_STELLA_LIST)) {
              { List obj000 = ((List)(obj));

                if (obj000.memberP(var)) {
                  return (true);
                }
              }
            }
            else {
            }
          }
        }
      }
    }
    return (false);
  }

  public static Surrogate computeRelationTermSurrogate(Skolem skolem, Proposition proposition) {
    { Proposition functionprop = skolem.definingProposition;
      String string = Native.stringify(Proposition.generateFunctionAsTerm(functionprop));
      Surrogate surrogate = null;
      int arity = 0;
      List argumentnames = null;
      List argumenttypes = null;
      NamedDescription description = null;

      surrogate = GeneralizedSymbol.internDerivedSurrogate(((Surrogate)(functionprop.operator)), string);
      if (surrogate.surrogateValue != null) {
        return (surrogate);
      }
      if (Logic.testPropertyP(skolem, Logic.SGT_PL_KERNEL_KB_VARIABLE_ARITY)) {
        arity = -1;
      }
      else if (Logic.accessBinaryValue(skolem, Logic.SGT_PL_KERNEL_KB_ARITY) != null) {
        arity = ((IntegerWrapper)(Logic.accessBinaryValue(skolem, Logic.SGT_PL_KERNEL_KB_ARITY))).wrapperValue;
      }
      else {
        arity = proposition.arguments.length() - 1;
      }
      if (arity == -1) {
        argumentnames = List.list(Cons.cons(Logic.yieldSystemDefinedParameterName(1, skolem), Stella.NIL));
        argumenttypes = List.list(Cons.cons(Logic.SGT_STELLA_THING, Stella.NIL));
      }
      else {
        argumentnames = List.newList();
        argumenttypes = List.newList();
        { int i = Stella.NULL_INTEGER;
          int iter000 = 0;
          int upperBound000 = arity - 1;

          for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
            i = iter000;
            argumentnames.insert(Logic.yieldSystemDefinedParameterName(i, skolem));
            argumenttypes.insert(Logic.SGT_STELLA_THING);
          }
        }
        argumentnames.reverse();
        argumenttypes.reverse();
      }
      description = Logic.createPrimitiveDescription(argumentnames, argumenttypes, arity < 0, (Logic.logicalType(skolem) == Logic.SGT_PL_KERNEL_KB_CLASS) ||
          Logic.classP(skolem), (Logic.logicalType(skolem) == Logic.SGT_PL_KERNEL_KB_FUNCTION) ||
          ((proposition.operator == Logic.SGT_PL_KERNEL_KB_VALUE) ||
           Logic.functionP(skolem)), ((Module)(surrogate.homeContext)));
      surrogate.surrogateValue = description;
      description.surrogateValueInverse = surrogate;
      Description.ensureDescriptionBody(description);
      return (surrogate);
    }
  }

  public static void pushLogicVariableBinding(Skolem variable) {
    if (Skolem.anonymousVariableP(variable)) {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            {
              stream000.nativeStream.println("ERROR: Illegal nameless variable '?' found in list of\nquantified variables.");
              stream000.nativeStream.println("   Quantified variables must have names..");
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
    Native.setSpecial(Logic.$LOGICVARIABLETABLE$, Cons.cons(variable, ((Cons)(Logic.$LOGICVARIABLETABLE$.get()))));
  }

  public static void inheritVariableValueUpdate(Skolem skolem, World toworld) {
  }

  public void markAsIncoherent() {
    { Skolem self = this;

      if (self.definingProposition != null) {
        { Stella_Object firstarg = (self.definingProposition.arguments.theArray)[0];

          if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(firstarg), Logic.SGT_LOGIC_LOGIC_OBJECT)) {
            { LogicObject firstarg000 = ((LogicObject)(firstarg));

              firstarg000.markAsIncoherent();
              return;
            }
          }
          else {
          }
        }
      }
    }
  }

  public void reactToInferenceUpdate() {
    { Skolem self = this;

      { Stella_Object derivedvalue = Logic.valueOf(self);
        Stella_Object assertedvalue = null;

        { Object old$Module$000 = Stella.$MODULE$.get();
          Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
            Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
            assertedvalue = Logic.valueOf(self);

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
            Stella.$MODULE$.set(old$Module$000);
          }
        }
        if ((assertedvalue != null) &&
            (!Stella_Object.eqlP(assertedvalue, derivedvalue))) {
          Proposition.equateValues(null, Logic.valueOf(assertedvalue), derivedvalue);
        }
        { Proposition prop = null;
          Iterator iter000 = Logic.unfilteredDependentPropositions(self, null).allocateIterator();

          while (iter000.nextP()) {
            prop = ((Proposition)(iter000.value));
            Proposition.postForEvaluation(prop, ((Context)(Stella.$CONTEXT$.get())));
          }
        }
        if (((Boolean)(Logic.$FILLINGCONSTRAINTPROPAGATIONQUEUESp$.get())).booleanValue()) {
          { Proposition definingproposition = self.definingProposition;

            if (definingproposition != null) {
              Proposition.postToForwardChainingQueue(definingproposition, ((World)(((Context)(Stella.$CONTEXT$.get())))));
            }
          }
        }
      }
    }
  }

  public int skolemGenerationCount() {
    { Skolem self = this;

      { int answer = ((IntegerWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_SKOLEM_GENERATION_COUNT, Stella.NULL_INTEGER_WRAPPER))).wrapperValue;

        if (answer == Stella.NULL_INTEGER) {
          return (0);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public static void updateSkolemType(Skolem self, Surrogate type) {
    { Surrogate oldtype = self.skolemType;

      if ((oldtype == null) ||
          Logic.logicalSubtypeOfP(type, oldtype)) {
        self.skolemType = type;
      }
    }
  }

  public static boolean anonymousVariableP(Skolem self) {
    return ((self.skolemName == Logic.ANONYMOUS_VARIABLE_NAME) &&
        Logic.variableP(self));
  }

  public Cons conflictingDefaultValues() {
    { Skolem self = this;

      { Cons answer = ((Cons)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_CONFLICTING_DEFAULT_VALUES, null)));

        if (answer == null) {
          return (Stella.NIL);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public static void unbindSkolemValue(Skolem skolem, boolean toplevelupdateP) {
    { Stella_Object oldvalue = Logic.valueOf(skolem);
      Proposition definingprop = skolem.definingProposition;
      Proposition equatingprop = null;

      LogicObject.unlinkEquivalentValue(skolem);
      equatingprop = Logic.findEquatingProposition(oldvalue, skolem);
      if (equatingprop != null) {
        Proposition.updatePropositionTruthValue(equatingprop, Logic.KWD_RETRACT_TRUE);
        Logic.handleOutOfDateInferenceCache(Logic.KWD_RETRACT, equatingprop);
      }
      else {
        Logic.handleOutOfDateInferenceCache(Logic.KWD_RETRACT, definingprop);
      }
      if (definingprop != null) {
        Skolem.reactToSkolemValueUpdate(skolem, oldvalue, null, toplevelupdateP);
      }
    }
  }

  public static void bindSkolemToValue(Skolem fromskolem, Stella_Object tovalue, boolean toplevelupdateP) {
    { boolean typeisokP = false;
      Surrogate type = fromskolem.skolemType;
      Proposition equatingproposition = null;

      if (Logic.skolemP(tovalue)) {
        equatingproposition = Logic.findEquatingProposition(tovalue, fromskolem);
        if ((equatingproposition != null) &&
            Proposition.defaultTrueP(equatingproposition)) {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                {
                  stream000.nativeStream.println("ERROR: Equating two skolems `" + fromskolem + "' and `" + tovalue + "' by default is not yet supported.");
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
      }
      { Object [] caller_MV_returnarray = new Object[1];

        typeisokP = Logic.checkCoercedTypeP(tovalue, type, true, caller_MV_returnarray);
        tovalue = ((Stella_Object)(caller_MV_returnarray[0]));
      }
      if (!typeisokP) {
        equatingproposition = Logic.findEquatingProposition(tovalue, fromskolem);
        if (equatingproposition == null) {
          { Object old$Termunderconstruction$000 = Logic.$TERMUNDERCONSTRUCTION$.get();

            try {
              Native.setSpecial(Logic.$TERMUNDERCONSTRUCTION$, ((Stella_Object)(Logic.$TERMUNDERCONSTRUCTION$.get())));
              if (((Stella_Object)(Logic.$TERMUNDERCONSTRUCTION$.get())) == null) {
                Native.setSpecial(Logic.$TERMUNDERCONSTRUCTION$, fromskolem.definingProposition);
              }
              { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  {
                    Stella.STANDARD_WARNING.nativeStream.println("WARNING: Type check violation: Assigned value `" + tovalue + "'");
                    Stella.STANDARD_WARNING.nativeStream.println("   to skolem with type `" + type + "'.");
                  }
;
                  Logic.helpSignalPropositionError(Stella.STANDARD_WARNING, Logic.KWD_WARNING);

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                }
              }

            } finally {
              Logic.$TERMUNDERCONSTRUCTION$.set(old$Termunderconstruction$000);
            }
          }
        }
        else {
          Proposition.verifyArgumentTypesAndCount(equatingproposition);
        }
      }
    }
    { Skolem object000 = fromskolem;
      Stella_Object value000 = tovalue;
      Stella_Object oldValue000 = object000.variableValue;
      Stella_Object newValue000 = Stella_Object.updateInContext(oldValue000, value000, object000.homeContext, false);

      if (!((oldValue000 != null) &&
          (oldValue000.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
        object000.variableValue = newValue000;
      }
    }
    { Surrogate testValue000 = Stella_Object.safePrimaryType(tovalue);

      if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_SKOLEM)) {
        { Skolem tovalue000 = ((Skolem)(tovalue));

          { Stella_Object equivalentskolem = ((Stella_Object)(Stella_Object.accessInContext(tovalue000.variableValue, tovalue000.homeContext, false)));

            loop000 : for (;;) {
              if (equivalentskolem == null) {
                break loop000;
              }
              if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(equivalentskolem), Logic.SGT_LOGIC_SKOLEM)) {
                { Skolem equivalentskolem000 = ((Skolem)(equivalentskolem));

                  if (equivalentskolem000 == tovalue000) {
                    { Skolem object001 = fromskolem;
                      Stella_Object value001 = null;
                      Stella_Object oldValue002 = object001.variableValue;
                      Stella_Object newValue001 = Stella_Object.updateInContext(oldValue002, value001, object001.homeContext, false);

                      if (!((oldValue002 != null) &&
                          (oldValue002.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
                        object001.variableValue = newValue001;
                      }
                    }
                    return;
                  }
                  equivalentskolem000 = ((Skolem)(((Stella_Object)(Stella_Object.accessInContext(equivalentskolem000.variableValue, equivalentskolem000.homeContext, false)))));
                }
              }
              else {
                break loop000;
              }
            }
          }
          { Skolem object002 = tovalue000;
            Cons value002 = Cons.cons(fromskolem, tovalue000.variableValueInverse());
            Stella_Object oldValue004 = object002.variableValueInverse;
            Stella_Object newValue002 = Stella_Object.updateInContext(oldValue004, value002, object002.homeContext, false);

            if (!((oldValue004 != null) &&
                (oldValue004.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
              object002.variableValueInverse = newValue002;
            }
          }
          if (tovalue000.skolemType == null) {
            tovalue000.skolemType = fromskolem.skolemType;
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_LOGIC_OBJECT)) {
        { LogicObject tovalue000 = ((LogicObject)(tovalue));

          { LogicObject object003 = tovalue000;
            Cons value003 = Cons.cons(fromskolem, tovalue000.variableValueInverse());
            Stella_Object oldValue005 = object003.variableValueInverse;
            Stella_Object newValue003 = Stella_Object.updateInContext(oldValue005, value003, object003.homeContext, false);

            if (!((oldValue005 != null) &&
                (oldValue005.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
              object003.variableValueInverse = newValue003;
            }
          }
        }
      }
      else {
        { Proposition proposition = fromskolem.definingProposition;

          if ((proposition != null) &&
              Logic.rewrapIthArgumentP(tovalue, proposition, proposition.arguments.length())) {
            { Skolem object004 = fromskolem;
              Stella_Object value004 = Logic.rewrapArgument(tovalue);
              Stella_Object oldValue006 = object004.variableValue;
              Stella_Object newValue004 = Stella_Object.updateInContext(oldValue006, value004, object004.homeContext, false);

              if (!((oldValue006 != null) &&
                  (oldValue006.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
                object004.variableValue = newValue004;
              }
            }
          }
        }
      }
    }
    Logic.handleOutOfDateInferenceCache(Logic.KWD_ASSERT, fromskolem.definingProposition);
    Logic.reactToKbUpdate(((Context)(Stella.$CONTEXT$.get())), fromskolem);
    if (!Logic.skolemP(tovalue)) {
      if (fromskolem.definingProposition != null) {
        Skolem.reactToSkolemValueUpdate(fromskolem, null, tovalue, toplevelupdateP);
      }
    }
  }

  public static void unifySkolemAndValue(Skolem skolem, Stella_Object value) {
    { Proposition prop = null;
      Iterator iter000 = Logic.unfilteredDependentPropositions(skolem, null).allocateIterator();

      while (iter000.nextP()) {
        prop = ((Proposition)(iter000.value));
        Proposition.evaluateProposition(prop);
      }
    }
  }

  public boolean objectEqualP(Stella_Object other) {
    { Skolem self = this;

      if (self == other) {
        return (true);
      }
      else {
        if (Logic.skolemP(other)) {
          { Proposition propself = self.definingProposition;
            Proposition propother = ((Skolem)(other)).definingProposition;

            return ((propself != null) &&
                ((propother != null) &&
                 Proposition.equivalentFunctionPropositionsP(propself, propother, null)));
          }
        }
      }
      return (false);
    }
  }

  public static Skolem helpCreateSkolem(Skolem self, Surrogate type, Symbol name, boolean assertisaP) {
    type = Logic.unwrapWrappedType(type);
    if (!(name != null)) {
      name = Logic.yieldAnonymousSkolemName(Logic.variableP(self));
    }
    self.skolemName = name;
    if (assertisaP &&
        (type != null)) {
      Logic.assertIsaProposition(self, type);
    }
    return (self);
  }

  public static boolean unboundP(Skolem skolem) {
    return (((Stella_Object)(Stella_Object.accessInContext(skolem.variableValue, skolem.homeContext, false))) == null);
  }

  public static void reactToSkolemValueUpdate(Skolem skolem, Stella_Object oldvalue, Stella_Object newvalue, boolean toplevelupdateP) {
    { Proposition proposition = skolem.definingProposition;

      if (toplevelupdateP &&
          Proposition.nativeSlotPropositionP(proposition)) {
        { Relation slot = Logic.getDescription(((Surrogate)(proposition.operator))).nativeRelation();
          Stella_Object nativefirstargvalue = Logic.valueOf((proposition.arguments.theArray)[0]);

          if (newvalue != null) {
            Proposition.assignNativeSlotValue(proposition, ((Thing)(nativefirstargvalue)), ((StorageSlot)(slot)), newvalue);
          }
          else {
            Logic.dropNativeSlotValue(((Thing)(nativefirstargvalue)), ((StorageSlot)(slot)), oldvalue);
          }
        }
      }
      if (!Stella_Object.eqlP(oldvalue, newvalue)) {
        Keyword.bumpMemoizationTimestamp(Logic.KWD_KB_UPDATE);
        if (((newvalue != null) &&
            Stella_Object.isaP(newvalue, Logic.SGT_LOGIC_DESCRIPTION)) ||
            Proposition.metaPropositionP(proposition)) {
          Keyword.bumpMemoizationTimestamp(Logic.KWD_META_KB_UPDATE);
        }
        if (oldvalue != null) {
          Proposition.updateLinksAndTimestamps(proposition, Logic.KWD_RETRACT_TRUE);
        }
        if (newvalue != null) {
          Proposition.updateLinksAndTimestamps(proposition, Logic.KWD_ASSERT_TRUE);
        }
      }
    }
  }

  public static Stella_Object accessSkolemSlotValue(Skolem self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_SKOLEM_TYPE) {
      if (setvalueP) {
        self.skolemType = ((Surrogate)(value));
      }
      else {
        value = self.skolemType;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_SKOLEM_NAME) {
      if (setvalueP) {
        self.skolemName = ((Symbol)(value));
      }
      else {
        value = self.skolemName;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_VARIABLE_VALUE) {
      if (setvalueP) {
        { Skolem object000 = self;
          Stella_Object value000 = value;
          Stella_Object oldValue000 = object000.variableValue;
          Stella_Object newValue000 = Stella_Object.updateInContext(oldValue000, value000, object000.homeContext, false);

          if (!((oldValue000 != null) &&
              (oldValue000.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
            object000.variableValue = newValue000;
          }
        }
      }
      else {
        value = ((Stella_Object)(Stella_Object.accessInContext(self.variableValue, self.homeContext, false)));
      }
    }
    else if (slotname == Logic.SYM_LOGIC_DEFINING_PROPOSITION) {
      if (setvalueP) {
        self.definingProposition = ((Proposition)(value));
      }
      else {
        value = self.definingProposition;
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
    { Skolem self = this;

      return (Logic.SGT_LOGIC_SKOLEM);
    }
  }

}

