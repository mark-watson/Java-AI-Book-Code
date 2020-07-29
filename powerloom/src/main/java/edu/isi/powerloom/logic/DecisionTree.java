//  -*- Mode: Java -*-
//
// DecisionTree.java

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

public class DecisionTree extends StandardObject {
    public Symbol feature;
    public int featureIndex;
    public Proposition proposition;
    public boolean truthValue;
    public Symbol concept;
    public DecisionTree trueBranch;
    public DecisionTree falseBranch;

  public static DecisionTree newDecisionTree() {
    { DecisionTree self = null;

      self = new DecisionTree();
      self.falseBranch = null;
      self.trueBranch = null;
      self.concept = null;
      self.truthValue = false;
      self.proposition = null;
      self.featureIndex = Stella.NULL_INTEGER;
      self.feature = null;
      return (self);
    }
  }

  public static List getPropositionsFromDecisionTree(DecisionTree tree) {
    if (tree.feature == null) {
      return (List.newList());
    }
    { List theList = DecisionTree.getPropositionsFromDecisionTree(tree.trueBranch).concatenate(DecisionTree.getPropositionsFromDecisionTree(tree.falseBranch), Stella.NIL);

      theList.push(tree.proposition);
      return (theList);
    }
  }

  public static void sortExamplesByTree(DecisionTree tree, List examples, List sortedExamples) {
    if (tree.feature == null) {
      sortedExamples.push(examples);
      return;
    }
    { List trueExamples = List.newList();
      List falseExamples = List.newList();

      { TrainingExample example = null;
        Cons iter000 = examples.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          example = ((TrainingExample)(iter000.value));
          if (Stella_Object.eqlP((example.input.theArray)[(tree.featureIndex)], Stella.ONE_WRAPPER)) {
            trueExamples.push(example);
          }
          else {
            falseExamples.push(example);
          }
        }
      }
      DecisionTree.sortExamplesByTree(tree.trueBranch, trueExamples, sortedExamples);
      DecisionTree.sortExamplesByTree(tree.falseBranch, falseExamples, sortedExamples);
    }
  }

  public static void extractPathsFromTree(DecisionTree tree, Cons antecedentStack, List antecedent) {
    if (tree.feature == null) {
      antecedent.push(Cons.cons((tree.truthValue ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), antecedentStack));
      return;
    }
    { Cons prop = Proposition.propositionToCons(tree.proposition);

      DecisionTree.extractPathsFromTree(tree.trueBranch, Cons.cons(prop, antecedentStack), antecedent);
      DecisionTree.extractPathsFromTree(tree.falseBranch, Cons.cons(Cons.list$(Cons.cons(Logic.SYM_LOGIC_FAIL, Cons.cons(prop, Cons.cons(Stella.NIL, Stella.NIL)))), antecedentStack), antecedent);
    }
  }

  public static List buildRulesFromTree(DecisionTree tree, List props) {
    { List rules = List.newList();
      Cons consProps = Stella.NIL;

      { Proposition prop = null;
        Cons iter000 = props.theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          prop = ((Proposition)(iter000.value));
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Proposition.propositionToCons(prop), Stella.NIL);
              if (consProps == Stella.NIL) {
                consProps = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(consProps, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Proposition.propositionToCons(prop), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      Logic.$INDUCED_DECISION_RULES$ = List.newList();
      DecisionTree.extractPathsFromTree(tree, Stella.NIL, rules);
      return (rules);
    }
  }

  public static void helpPrintDecisionTree(DecisionTree tree, int level, edu.isi.stella.javalib.NativeOutputStream stream) {
    if (tree.feature == null) {
      if (tree.truthValue) {
        stream.println("True");
      }
      else {
        stream.println("False");
      }
      return;
    }
    stream.println();
    { int i = Stella.NULL_INTEGER;
      int iter000 = 1;
      int upperBound000 = level;
      boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

      for (;unboundedP000 ||
                (iter000 <= upperBound000); iter000 = iter000 + 1) {
        i = iter000;
        i = i;
        stream.print("|   ");
      }
    }
    stream.print(tree.proposition + " = 1: ");
    DecisionTree.helpPrintDecisionTree(tree.trueBranch, level + 1, stream);
    { int i = Stella.NULL_INTEGER;
      int iter001 = 1;
      int upperBound001 = level;
      boolean unboundedP001 = upperBound001 == Stella.NULL_INTEGER;

      for (;unboundedP001 ||
                (iter001 <= upperBound001); iter001 = iter001 + 1) {
        i = iter001;
        i = i;
        stream.print("|   ");
      }
    }
    stream.print(tree.proposition + " = 0: ");
    DecisionTree.helpPrintDecisionTree(tree.falseBranch, level + 1, stream);
  }

  public static void printDecisionTree(DecisionTree tree, edu.isi.stella.javalib.NativeOutputStream stream) {
    DecisionTree.helpPrintDecisionTree(tree, 0, stream);
  }

  public static void addPropositionsToDecisionTree(DecisionTree tree, HashTable table) {
    if (tree.feature == null) {
      return;
    }
    tree.proposition = ((Proposition)(table.lookup(tree.feature)));
    DecisionTree.addPropositionsToDecisionTree(tree.trueBranch, table);
    DecisionTree.addPropositionsToDecisionTree(tree.falseBranch, table);
  }

  public static boolean traverseDecisionTree(DecisionTree tree, Vector features) {
    if (tree.feature == null) {
      return (tree.truthValue);
    }
    if (Stella_Object.eqlP(((IntegerWrapper)((features.theArray)[(tree.featureIndex)])), Stella.ONE_WRAPPER)) {
      return (DecisionTree.traverseDecisionTree(tree.trueBranch, features));
    }
    else {
      return (DecisionTree.traverseDecisionTree(tree.falseBranch, features));
    }
  }

  public static boolean askDecisionTree(DecisionTree tree, Cons query) {
    { Vector signature = Logic.createInputSignature(query);

      return (DecisionTree.traverseDecisionTree(tree, signature));
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { DecisionTree self = this;

      DecisionTree.printDecisionTree(self, stream);
    }
  }

  public static Stella_Object accessDecisionTreeSlotValue(DecisionTree self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_FEATURE) {
      if (setvalueP) {
        self.feature = ((Symbol)(value));
      }
      else {
        value = self.feature;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_FEATURE_INDEX) {
      if (setvalueP) {
        self.featureIndex = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.featureIndex);
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
        self.truthValue = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.truthValue ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_CONCEPT) {
      if (setvalueP) {
        self.concept = ((Symbol)(value));
      }
      else {
        value = self.concept;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_TRUE_BRANCH) {
      if (setvalueP) {
        self.trueBranch = ((DecisionTree)(value));
      }
      else {
        value = self.trueBranch;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_FALSE_BRANCH) {
      if (setvalueP) {
        self.falseBranch = ((DecisionTree)(value));
      }
      else {
        value = self.falseBranch;
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
    { DecisionTree self = this;

      return (Logic.SGT_LOGIC_DECISION_TREE);
    }
  }

}

