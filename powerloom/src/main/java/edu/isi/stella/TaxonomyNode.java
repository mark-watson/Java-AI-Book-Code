//  -*- Mode: Java -*-
//
// TaxonomyNode.java

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
| The Original Code is the STELLA Programming Language.                      |
|                                                                            |
| The Initial Developer of the Original Code is                              |
| UNIVERSITY OF SOUTHERN CALIFORNIA, INFORMATION SCIENCES INSTITUTE          |
| 4676 Admiralty Way, Marina Del Rey, California 90292, U.S.A.               |
|                                                                            |
| Portions created by the Initial Developer are Copyright (C) 1996-2017      |
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
+---------------------------- END LICENSE BLOCK -----------------------------+
*/

package edu.isi.stella;

import edu.isi.stella.javalib.*;

public class TaxonomyNode extends StandardObject {
    public Stella_Object nativeObject;
    public int label;
    public Cons intervals;
    public Interval initialInterval;
    public int firstIntervalLowerBound;
    public int firstIntervalUpperBound;
    public Cons parents;
    public Cons children;
    public int totalAncestors;
    public Cons treeChildren;
    public Stella_Object marker;

  public static TaxonomyNode newTaxonomyNode() {
    { TaxonomyNode self = null;

      self = new TaxonomyNode();
      self.marker = null;
      self.treeChildren = Stella.NIL;
      self.totalAncestors = 1;
      self.children = Stella.NIL;
      self.parents = Stella.NIL;
      self.firstIntervalUpperBound = -1;
      self.firstIntervalLowerBound = -1;
      self.initialInterval = null;
      self.intervals = Stella.NIL;
      self.label = Stella.NULL_INTEGER;
      self.nativeObject = null;
      return (self);
    }
  }

  public static void printTaxonomySpanningTree(TaxonomyNode node, int indent, OutputStream stream) {
    { int i = Stella.NULL_INTEGER;
      int iter000 = 1;
      int upperBound000 = indent;
      boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

      for (;unboundedP000 ||
                (iter000 <= upperBound000); iter000 = iter000 + 1) {
        i = iter000;
        i = i;
        stream.nativeStream.print(" ");
      }
    }
    stream.nativeStream.println(node.toString());
    { TaxonomyNode child = null;
      Cons iter001 = node.treeChildren;

      for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
        child = ((TaxonomyNode)(iter001.value));
        TaxonomyNode.printTaxonomySpanningTree(child, indent + 2, stream);
      }
    }
  }

  public static void printTaxonomyTree(TaxonomyNode node, int indent, OutputStream stream) {
    { int i = Stella.NULL_INTEGER;
      int iter000 = 1;
      int upperBound000 = indent;
      boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

      for (;unboundedP000 ||
                (iter000 <= upperBound000); iter000 = iter000 + 1) {
        i = iter000;
        i = i;
        stream.nativeStream.print(" ");
      }
    }
    stream.nativeStream.println(node.toString());
    { TaxonomyNode child = null;
      Cons iter001 = node.children;

      for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
        child = ((TaxonomyNode)(iter001.value));
        TaxonomyNode.printTaxonomyTree(child, indent + 2, stream);
      }
    }
  }

  public static boolean slowTaxonomySubnodeOfP(TaxonomyNode subnode, TaxonomyNode supernode) {
    if (subnode == supernode) {
      return (true);
    }
    { TaxonomyNode parent = null;
      Cons iter000 = subnode.parents;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        parent = ((TaxonomyNode)(iter000.value));
        if (TaxonomyNode.slowTaxonomySubnodeOfP(parent, supernode)) {
          return (true);
        }
      }
    }
    return (false);
  }

  /** Return TRUE if <code>subNode</code> is a descendant of <code>superNode</code>.
   * @param subNode
   * @param superNode
   * @return boolean
   */
  public static boolean taxonomySubnodeOfP(TaxonomyNode subNode, TaxonomyNode superNode) {
    { int subNodeLabel = subNode.label;

      { Interval interval = null;
        Cons iter000 = superNode.intervals;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          interval = ((Interval)(iter000.value));
          if ((subNodeLabel >= interval.lowerBound) &&
              (subNodeLabel <= interval.upperBound)) {
            return (true);
          }
        }
      }
      return (false);
    }
  }

  public static void computeTotalAncestors(TaxonomyNode node) {
    TaxonomyNode.uncomputeTotalAncestors(node);
    TaxonomyNode.helpComputeTotalAncestors(node);
  }

  public static void helpComputeTotalAncestors(TaxonomyNode node) {
    if (node.totalAncestors >= 0) {
      return;
    }
    { int totalancestors = 0;
      int parentancestors = 0;

      { TaxonomyNode parent = null;
        Cons iter000 = node.parents;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          parent = ((TaxonomyNode)(iter000.value));
          parentancestors = parent.totalAncestors;
          if (parentancestors < 0) {
            return;
          }
          totalancestors = totalancestors + parentancestors;
        }
      }
      node.totalAncestors = totalancestors + 1;
      { TaxonomyNode child = null;
        Cons iter001 = node.children;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          child = ((TaxonomyNode)(iter001.value));
          TaxonomyNode.helpComputeTotalAncestors(child);
        }
      }
    }
  }

  public static void uncomputeTotalAncestors(TaxonomyNode node) {
    if (node.totalAncestors < 0) {
      return;
    }
    node.totalAncestors = -1;
    { TaxonomyNode child = null;
      Cons iter000 = node.children;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        child = ((TaxonomyNode)(iter000.value));
        TaxonomyNode.uncomputeTotalAncestors(child);
      }
    }
  }

  public static void propagateForeignInterval(TaxonomyNode node, Interval interval) {
    if (node.marker == interval) {
      return;
    }
    node.marker = interval;
    if (TaxonomyNode.adjoinTaxonomyNodeIntervalP(node, interval)) {
      { TaxonomyNode parent = null;
        Cons iter000 = node.parents;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          parent = ((TaxonomyNode)(iter000.value));
          TaxonomyNode.propagateForeignInterval(parent, interval);
        }
      }
    }
  }

  public static boolean adjoinTaxonomyNodeIntervalP(TaxonomyNode node, Interval interval) {
    { Cons intervalstoremove = Stella.NIL;

      { Interval renamed_Int = null;
        Cons iter000 = node.intervals;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          renamed_Int = ((Interval)(iter000.value));
          if (renamed_Int.lowerBound < interval.lowerBound) {
            if (renamed_Int.upperBound >= interval.upperBound) {
              return (false);
            }
            else {
              if (interval.lowerBound <= (renamed_Int.upperBound + 1)) {
                TaxonomyNode.removeTaxonomyNodeInterval(node, renamed_Int);
                TaxonomyNode.adjoinTaxonomyNodeIntervalP(node, Interval.mergeIntervals(renamed_Int, interval));
                return (true);
              }
            }
          }
          else {
            if (interval.upperBound >= renamed_Int.upperBound) {
              intervalstoremove = Cons.cons(renamed_Int, intervalstoremove);
            }
            else {
              if (renamed_Int.lowerBound <= (interval.upperBound + 1)) {
                TaxonomyNode.removeTaxonomyNodeInterval(node, renamed_Int);
                TaxonomyNode.adjoinTaxonomyNodeIntervalP(node, Interval.mergeIntervals(interval, renamed_Int));
                return (true);
              }
            }
          }
        }
      }
      { Stella_Object renamed_Int = null;
        Cons iter001 = intervalstoremove;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          renamed_Int = iter001.value;
          TaxonomyNode.removeTaxonomyNodeInterval(node, ((Interval)(renamed_Int)));
        }
      }
      TaxonomyNode.addTaxonomyNodeInterval(node, interval);
      return (true);
    }
  }

  public static void removeTaxonomyNodeInterval(TaxonomyNode node, Interval interval) {
    { Cons intervals = node.intervals;

      intervals = node.intervals = intervals.remove(interval);
      if (intervals == Stella.NIL) {
        node.firstIntervalLowerBound = -1;
        node.firstIntervalUpperBound = -1;
      }
      else {
        node.firstIntervalLowerBound = ((Interval)(intervals.value)).lowerBound;
        node.firstIntervalUpperBound = ((Interval)(intervals.value)).upperBound;
      }
    }
  }

  public static void addTaxonomyNodeInterval(TaxonomyNode node, Interval interval) {
    node.intervals = Cons.cons(interval, node.intervals);
    node.firstIntervalLowerBound = interval.lowerBound;
    node.firstIntervalUpperBound = interval.upperBound;
  }

  public static Interval internTaxonomyNodeInterval(TaxonomyNode node, int lowerbound, int upperbound) {
    { Interval self000 = Interval.newInterval();

      self000.lowerBound = lowerbound;
      self000.upperBound = upperbound;
      { Interval interval = self000;

        TaxonomyNode.addTaxonomyNodeInterval(node, interval);
        return (interval);
      }
    }
  }

  public static Cons allTaxonomyNodeIntervals(TaxonomyNode node) {
    return (node.intervals);
  }

  public static int helpCreateTaxonomyTreeIntervals(TaxonomyNode self) {
    { int minchildlabel = Stella.NULL_INTEGER;
      int mylabel = Stella.NULL_INTEGER;
      int prevpostnumber = ((Integer)(Stella.$TAXONOMY_POSTORDER_NUMBER$.get())).intValue();

      if (!(self.treeChildren == Stella.NIL)) {
        minchildlabel = TaxonomyNode.helpCreateTaxonomyTreeIntervals(((TaxonomyNode)(self.treeChildren.value)));
      }
      { TaxonomyNode child = null;
        Cons iter000 = self.treeChildren.rest;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          child = ((TaxonomyNode)(iter000.value));
          TaxonomyNode.helpCreateTaxonomyTreeIntervals(child);
        }
      }
      Native.setIntSpecial(Stella.$TAXONOMY_POSTORDER_NUMBER$, ((Integer)(Stella.$TAXONOMY_POSTORDER_NUMBER$.get())).intValue() + Stella.$NUMBERING_INTERVAL$);
      mylabel = ((Integer)(Stella.$TAXONOMY_POSTORDER_NUMBER$.get())).intValue();
      if (self.treeChildren == Stella.NIL) {
        minchildlabel = prevpostnumber + 1;
      }
      self.initialInterval = TaxonomyNode.internTaxonomyNodeInterval(self, minchildlabel, mylabel);
      self.label = mylabel;
      return (minchildlabel);
    }
  }

  public static void helpClearTaxonomyGraph(TaxonomyNode node) {
    if (node.label != Stella.NULL_INTEGER) {
      TaxonomyNode.clearTaxonomyNode(node);
      { TaxonomyNode child = null;
        Cons iter000 = node.children;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          child = ((TaxonomyNode)(iter000.value));
          TaxonomyNode.helpClearTaxonomyGraph(child);
        }
      }
    }
  }

  /** Completely clear and initialize <code>node</code>.
   * @param node
   */
  public static void initializeTaxonomyNode(TaxonomyNode node) {
    TaxonomyNode.clearTaxonomyNode(node);
    node.parents = Stella.NIL;
    node.children = Stella.NIL;
    node.nativeObject = null;
  }

  /** Clear all taxonomy-graph-specific information of <code>node</code>,
   * but retain information about the native object and associated links.
   * @param node
   */
  public static void clearTaxonomyNode(TaxonomyNode node) {
    node.label = Stella.NULL_INTEGER;
    node.intervals = Stella.NIL;
    node.initialInterval = null;
    node.firstIntervalLowerBound = -1;
    node.firstIntervalUpperBound = -1;
    node.treeChildren = Stella.NIL;
    node.totalAncestors = 1;
  }

  public boolean deletedPSetter(boolean value) {
    { TaxonomyNode self = this;

      if (value) {
        self.label = Stella.DELETED_LABEL;
      }
      else {
        self.label = Stella.NULL_INTEGER;
      }
      return (value);
    }
  }

  public boolean deletedP() {
    { TaxonomyNode self = this;

      return (self.label == Stella.DELETED_LABEL);
    }
  }

  public static boolean labeledTaxonomyNodeP(TaxonomyNode node) {
    return (node.label != Stella.NULL_INTEGER);
  }

  public static Interval allocateIntervalForNewLeafNode(TaxonomyNode parent) {
    { Interval parentinterval = parent.initialInterval;

      if (parent.treeChildren == Stella.NIL) {
        if (parentinterval.lowerBound == parentinterval.upperBound) {
          return (null);
        }
        { Interval self000 = Interval.newInterval();

          self000.lowerBound = parentinterval.lowerBound;
          self000.upperBound = Native.floor((parentinterval.lowerBound + parentinterval.upperBound) / 2.0);
          { Interval value000 = self000;

            return (value000);
          }
        }
      }
      { TaxonomyNode rightchild = ((TaxonomyNode)(parent.treeChildren.last()));
        Interval rightchildinterval = rightchild.initialInterval;

        if (rightchildinterval.upperBound >= (parentinterval.upperBound - 1)) {
          return (null);
        }
        { Interval self001 = Interval.newInterval();

          self001.lowerBound = rightchildinterval.upperBound + 1;
          self001.upperBound = Native.ceiling((parentinterval.upperBound + rightchildinterval.upperBound) / 2.0);
          { Interval value001 = self001;

            return (value001);
          }
        }
      }
    }
  }

  /** Return <code>true</code> if <code>node</code> is a taxonomy root node.
   * @param node
   * @return boolean
   */
  public static boolean taxonomyRootP(TaxonomyNode node) {
    return (node.parents == Stella.NIL);
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { TaxonomyNode self = this;

      stream.print("|TN|" + self.label + " " + self.intervals + " " + self.nativeObject);
    }
  }

  public static Stella_Object accessTaxonomyNodeSlotValue(TaxonomyNode self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_NATIVE_OBJECT) {
      if (setvalueP) {
        self.nativeObject = value;
      }
      else {
        value = self.nativeObject;
      }
    }
    else if (slotname == Stella.SYM_STELLA_LABEL) {
      if (setvalueP) {
        self.label = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.label);
      }
    }
    else if (slotname == Stella.SYM_STELLA_INTERVALS) {
      if (setvalueP) {
        self.intervals = ((Cons)(value));
      }
      else {
        value = self.intervals;
      }
    }
    else if (slotname == Stella.SYM_STELLA_INITIAL_INTERVAL) {
      if (setvalueP) {
        self.initialInterval = ((Interval)(value));
      }
      else {
        value = self.initialInterval;
      }
    }
    else if (slotname == Stella.SYM_STELLA_FIRST_INTERVAL_LOWER_BOUND) {
      if (setvalueP) {
        self.firstIntervalLowerBound = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.firstIntervalLowerBound);
      }
    }
    else if (slotname == Stella.SYM_STELLA_FIRST_INTERVAL_UPPER_BOUND) {
      if (setvalueP) {
        self.firstIntervalUpperBound = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.firstIntervalUpperBound);
      }
    }
    else if (slotname == Stella.SYM_STELLA_PARENTS) {
      if (setvalueP) {
        self.parents = ((Cons)(value));
      }
      else {
        value = self.parents;
      }
    }
    else if (slotname == Stella.SYM_STELLA_CHILDREN) {
      if (setvalueP) {
        self.children = ((Cons)(value));
      }
      else {
        value = self.children;
      }
    }
    else if (slotname == Stella.SYM_STELLA_TOTAL_ANCESTORS) {
      if (setvalueP) {
        self.totalAncestors = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.totalAncestors);
      }
    }
    else if (slotname == Stella.SYM_STELLA_TREE_CHILDREN) {
      if (setvalueP) {
        self.treeChildren = ((Cons)(value));
      }
      else {
        value = self.treeChildren;
      }
    }
    else if (slotname == Stella.SYM_STELLA_MARKER) {
      if (setvalueP) {
        self.marker = value;
      }
      else {
        value = self.marker;
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
    { TaxonomyNode self = this;

      return (Stella.SGT_STELLA_TAXONOMY_NODE);
    }
  }

}

