//  -*- Mode: Java -*-
//
// TaxonomyGraph.java

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

public class TaxonomyGraph extends StandardObject {
    /** If TRUE, relabel the entire graph when a new interval
     * for an incrementally inserted node can't be allocated due to lack of
     * splittable interval space.  Otherwise, create a <code>foreign</code> interval and
     * propagate it.
     */
    public boolean renumberIfOutOfNumbersP;
    /** Whenever the ratio between foreign intervals and
     * non-foreign intervals becomes greater than <code>renumberRatio</code>, relabel
     * the whole graph non-incrementally.
     */
    public double renumberRatio;
    public boolean incrementalModeP;
    public int largestPostorderNumber;
    public int numberOfNodes;
    public int numberOfForeignIntervalNodes;
    public List roots;
    public List brokenLinks;
    public List addedLinks;
    public List removedLinks;

  public static TaxonomyGraph newTaxonomyGraph() {
    { TaxonomyGraph self = null;

      self = new TaxonomyGraph();
      self.removedLinks = null;
      self.addedLinks = null;
      self.brokenLinks = null;
      self.roots = null;
      self.numberOfForeignIntervalNodes = Stella.NULL_INTEGER;
      self.numberOfNodes = Stella.NULL_INTEGER;
      self.largestPostorderNumber = Stella.NULL_INTEGER;
      self.incrementalModeP = false;
      self.renumberRatio = 0.1;
      self.renumberIfOutOfNumbersP = false;
      TaxonomyGraph.initializeTaxonomyGraph(self);
      return (self);
    }
  }

  public static void printTaxonomySpanningForest(TaxonomyGraph graph, OutputStream stream) {
    { TaxonomyNode root = null;
      Cons iter000 = graph.roots.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        root = ((TaxonomyNode)(iter000.value));
        TaxonomyNode.printTaxonomySpanningTree(root, 0, stream);
        stream.nativeStream.println();
      }
    }
  }

  public static void printTaxonomyGraph(TaxonomyGraph graph, OutputStream stream) {
    { TaxonomyNode root = null;
      Cons iter000 = graph.roots.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        root = ((TaxonomyNode)(iter000.value));
        TaxonomyNode.printTaxonomyTree(root, 0, stream);
        stream.nativeStream.println();
      }
    }
  }

  public static void finalizeTaxonomyGraphNonincrementally(TaxonomyGraph graph) {
    graph.incrementalModeP = false;
    TaxonomyGraph.finalizeTaxonomyGraph(graph);
  }

  /** Finalize the taxonomy graph <code>graph</code>.
   * @param graph
   */
  public static void finalizeTaxonomyGraph(TaxonomyGraph graph) {
    if (graph.incrementalModeP &&
        ((graph.numberOfNodes > 0) &&
         ((((double)(Stella.integer_max(graph.numberOfForeignIntervalNodes, graph.addedLinks.length()))) / graph.numberOfNodes) < graph.renumberRatio))) {
      { Cons link = null;
        Cons iter000 = graph.addedLinks.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          link = ((Cons)(iter000.value));
          TaxonomyGraph.incrementallyLinkTaxonomyNodes(graph, ((TaxonomyNode)(link.value)), ((TaxonomyNode)(link.rest.value)));
        }
      }
      graph.addedLinks.clear();
    }
    else {
      graph.incrementalModeP = false;
      { Cons link = null;
        Cons iter001 = graph.addedLinks.theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          link = ((Cons)(iter001.value));
          TaxonomyGraph.linkTaxonomyNodes(graph, ((TaxonomyNode)(link.value)), ((TaxonomyNode)(link.rest.value)));
        }
      }
      graph.addedLinks.clear();
      TaxonomyGraph.createTaxonomySpanningForest(graph);
    }
  }

  public static void createTaxonomySpanningForest(TaxonomyGraph graph) {
    TaxonomyGraph.clearTaxonomyGraph(graph);
    graph.incrementalModeP = false;
    { TaxonomyNode root = null;
      Cons iter000 = graph.roots.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        root = ((TaxonomyNode)(iter000.value));
        TaxonomyNode.computeTotalAncestors(root);
        TaxonomyGraph.createTaxonomySpanningTree(graph, root);
      }
    }
    TaxonomyGraph.createTaxonomyTreeIntervals(graph);
    { Cons link = null;
      Cons iter001 = graph.brokenLinks.theConsList;

      for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
        link = ((Cons)(iter001.value));
        TaxonomyNode.propagateForeignInterval(((TaxonomyNode)(link.value)), ((TaxonomyNode)(link.rest.value)).initialInterval);
      }
    }
    graph.brokenLinks.clear();
    graph.incrementalModeP = true;
  }

  public static void createTaxonomySpanningTree(TaxonomyGraph graph, TaxonomyNode node) {
    if (node.label != Stella.NULL_INTEGER) {
      return;
    }
    node.label = Stella.MARKER_LABEL;
    { TaxonomyNode maxparent = null;
      int maxparentvalue = Stella.NULL_INTEGER;

      { TaxonomyNode parent = null;
        Cons iter000 = node.parents;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          parent = ((TaxonomyNode)(iter000.value));
          if ((maxparentvalue == Stella.NULL_INTEGER) ||
              (parent.totalAncestors > maxparentvalue)) {
            maxparent = parent;
            maxparentvalue = parent.totalAncestors;
          }
        }
      }
      { TaxonomyNode parent = null;
        Cons iter001 = node.parents;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          parent = ((TaxonomyNode)(iter001.value));
          if (parent == maxparent) {
            parent.treeChildren = Cons.cons(node, parent.treeChildren);
          }
          else {
            graph.brokenLinks.push(Cons.cons(parent, Cons.cons(node, Stella.NIL)));
          }
        }
      }
      { TaxonomyNode child = null;
        Cons iter002 = node.children;

        for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
          child = ((TaxonomyNode)(iter002.value));
          TaxonomyGraph.createTaxonomySpanningTree(graph, child);
        }
      }
    }
  }

  public static void createTaxonomyTreeIntervals(TaxonomyGraph graph) {
    { Object old$TaxonomyPostorderNumber$000 = Stella.$TAXONOMY_POSTORDER_NUMBER$.get();

      try {
        Native.setIntSpecial(Stella.$TAXONOMY_POSTORDER_NUMBER$, 0);
        { TaxonomyNode root = null;
          Cons iter000 = graph.roots.theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            root = ((TaxonomyNode)(iter000.value));
            TaxonomyNode.helpCreateTaxonomyTreeIntervals(root);
          }
        }
        graph.largestPostorderNumber = ((Integer)(Stella.$TAXONOMY_POSTORDER_NUMBER$.get())).intValue();

      } finally {
        Stella.$TAXONOMY_POSTORDER_NUMBER$.set(old$TaxonomyPostorderNumber$000);
      }
    }
  }

  /** Completely clear the taxonomy graph <code>graph</code>.
   * NOTE: Any nodes associated with <code>graph</code> will not be cleared.  If they are
   * to be reused, they have to be cleared with <code>initializeTaxonomyNode</code>.
   * @param graph
   */
  public static void initializeTaxonomyGraph(TaxonomyGraph graph) {
    graph.incrementalModeP = false;
    graph.renumberIfOutOfNumbersP = false;
    graph.largestPostorderNumber = 0;
    graph.numberOfNodes = 0;
    graph.numberOfForeignIntervalNodes = 0;
    graph.renumberRatio = 0.1;
    graph.roots = List.newList();
    graph.brokenLinks = List.newList();
    graph.addedLinks = List.newList();
    graph.removedLinks = List.newList();
  }

  /** Clear all taxonomy-graph-specific information of <code>graph</code>,
   * but retain information about the native network and associated links.
   * @param graph
   */
  public static void clearTaxonomyGraph(TaxonomyGraph graph) {
    { TaxonomyNode root = null;
      Cons iter000 = graph.roots.removeDeletedMembers().theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        root = ((TaxonomyNode)(iter000.value));
        TaxonomyNode.helpClearTaxonomyGraph(root);
      }
    }
    graph.incrementalModeP = false;
    graph.numberOfForeignIntervalNodes = 0;
    graph.brokenLinks.clear();
  }

  /** Return some node in <code>graph</code> with label <code>label</code>.
   * @param graph
   * @param label
   * @return TaxonomyNode
   */
  public static TaxonomyNode findTaxonomyNode(TaxonomyGraph graph, int label) {
    { TaxonomyNode node = null;
      Iterator iter000 = TaxonomyGraph.allTaxonomyNodes(graph);

      while (iter000.nextP()) {
        node = ((TaxonomyNode)(iter000.value));
        if (node.label == label) {
          return (node);
        }
      }
    }
    return (null);
  }

  /** Given a taxonomy <code>graph</code> that has been finalized,
   * return an iterator that generates all the graph's nodes.
   * @param graph
   * @return Iterator
   */
  public static Iterator allTaxonomyNodes(TaxonomyGraph graph) {
    { AllPurposeIterator self000 = AllPurposeIterator.newAllPurposeIterator();

      self000.iteratorObject = graph.roots.copy();
      self000.iteratorNextCode = Native.find_java_method("edu.isi.stella.AllPurposeIterator", "allTaxonomyNodesNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
      { AllPurposeIterator value000 = self000;

        return (value000);
      }
    }
  }

  public static void incrementallyUnlinkTaxonomyNodes(TaxonomyGraph graph, TaxonomyNode parent, TaxonomyNode child) {
    {
      graph = graph;
      parent = parent;
      child = child;
    }
    throw ((StellaException)(StellaException.newStellaException("incrementally-unlink-taxonomy-nodes: Rewrite me!").fillInStackTrace()));
  }

  /** Remove link between <code>parent</code> and <code>child</code>.
   * @param graph
   * @param parent
   * @param child
   */
  public static void unlinkTaxonomyNodes(TaxonomyGraph graph, TaxonomyNode parent, TaxonomyNode child) {
    if (!parent.children.membP(child)) {
      return;
    }
    if (graph.incrementalModeP) {
      graph.incrementalModeP = false;
    }
    parent.children = parent.children.remove(child);
    parent.treeChildren = parent.treeChildren.remove(child);
    child.parents = child.parents.remove(parent);
    TaxonomyGraph.updateTaxonomyRoots(graph, child);
  }

  public static Interval createNextPostorderInterval(TaxonomyGraph graph) {
    graph.numberOfForeignIntervalNodes = graph.numberOfForeignIntervalNodes + 1;
    { Interval newinterval = Interval.newInterval();

      newinterval.lowerBound = graph.largestPostorderNumber + 1;
      newinterval.upperBound = graph.largestPostorderNumber + Stella.$NUMBERING_INTERVAL$;
      graph.largestPostorderNumber = newinterval.upperBound;
      return (newinterval);
    }
  }

  public static void incrementallyLinkTaxonomyNodes(TaxonomyGraph graph, TaxonomyNode parent, TaxonomyNode child) {
    if (parent.children.membP(child)) {
      return;
    }
    TaxonomyGraph.createTaxonomyLink(graph, parent, child);
    { Interval interval = null;
      boolean parentexistsP = parent.initialInterval != null;
      boolean childexistsP = child.initialInterval != null;

      if (childexistsP) {
        if (!parentexistsP) {
          interval = TaxonomyGraph.createNextPostorderInterval(graph);
          parent.initialInterval = interval;
          parent.label = interval.upperBound;
          TaxonomyNode.addTaxonomyNodeInterval(parent, interval);
        }
        { Interval interval000 = null;
          Cons iter000 = child.intervals;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            interval000 = ((Interval)(iter000.value));
            TaxonomyNode.propagateForeignInterval(parent, interval000);
          }
        }
      }
      else {
        if (!parentexistsP) {
          interval = TaxonomyGraph.createNextPostorderInterval(graph);
          parent.initialInterval = interval;
          parent.label = interval.upperBound;
          TaxonomyNode.addTaxonomyNodeInterval(parent, interval);
        }
        interval = TaxonomyNode.allocateIntervalForNewLeafNode(parent);
        if (interval == null) {
          if (graph.renumberIfOutOfNumbersP) {
            TaxonomyGraph.finalizeTaxonomyGraphNonincrementally(graph);
            return;
          }
          interval = TaxonomyGraph.createNextPostorderInterval(graph);
        }
        child.initialInterval = interval;
        child.label = interval.upperBound;
        TaxonomyNode.addTaxonomyNodeInterval(child, interval);
        parent.treeChildren = parent.treeChildren.concatenate(Cons.cons(child, Stella.NIL), Stella.NIL);
        TaxonomyNode.propagateForeignInterval(parent, interval);
      }
    }
  }

  /** Cross-link <code>parent</code> and <code>child</code> in <code>graph</code>.
   * IMPORTANT: This will automatically insert a backlink from <code>child</code> to
   * <code>parent</code>, so, for maximum efficiency it should not be called a second time
   * with the arguments reversed.
   * @param graph
   * @param parent
   * @param child
   */
  public static void linkTaxonomyNodes(TaxonomyGraph graph, TaxonomyNode parent, TaxonomyNode child) {
    if (parent.children.membP(child)) {
      return;
    }
    if (graph.incrementalModeP) {
      graph.addedLinks.push(Cons.cons(parent, Cons.cons(child, Stella.NIL)));
    }
    else {
      TaxonomyGraph.createTaxonomyLink(graph, parent, child);
    }
  }

  public static void createTaxonomyLink(TaxonomyGraph graph, TaxonomyNode parent, TaxonomyNode child) {
    TaxonomyGraph.removeTaxonomyRoot(graph, child);
    child.parents = Cons.cons(parent, child.parents);
    parent.children = Cons.cons(child, parent.children);
  }

  /** Remove <code>node</code> from <code>graph</code> and disconnect incident links.
   * @param graph
   * @param node
   */
  public static void removeTaxonomyNode(TaxonomyGraph graph, TaxonomyNode node) {
    { Cons parentscopy = Cons.copyConsList(node.parents);
      Cons childrencopy = Cons.copyConsList(node.children);

      { TaxonomyNode parent = null;
        Cons iter000 = parentscopy;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          parent = ((TaxonomyNode)(iter000.value));
          TaxonomyGraph.unlinkTaxonomyNodes(graph, parent, node);
        }
      }
      { TaxonomyNode child = null;
        Cons iter001 = childrencopy;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          child = ((TaxonomyNode)(iter001.value));
          TaxonomyGraph.unlinkTaxonomyNodes(graph, node, child);
        }
      }
      node.intervals = Stella.NIL;
      node.nativeObject = null;
      node.deletedPSetter(true);
      TaxonomyGraph.removeTaxonomyRoot(graph, node);
      graph.numberOfNodes = graph.numberOfNodes - 1;
    }
  }

  /** Add <code>node</code> to <code>graph</code>.  Mark it as a root node if <code>rootP</code>
   * is <code>true</code>.  Even though this is part of the API, it should rarely be needed,
   * since <code>createTaxonomyNode</code> does everything that's necessary.
   * @param graph
   * @param node
   * @param rootP
   */
  public static void addTaxonomyNode(TaxonomyGraph graph, TaxonomyNode node, boolean rootP) {
    if (rootP) {
      TaxonomyGraph.addTaxonomyRoot(graph, node);
    }
    graph.numberOfNodes = graph.numberOfNodes + 1;
  }

  /** Link the taxonomy node <code>node</code> to <code>nativeobject</code> and add it
   * to <code>graph</code>.  If it is <code>null</code>, a new node will be created.  Mark it as a root
   * node if <code>rootP</code> is <code>true</code>.  Return the node.
   * @param graph
   * @param node
   * @param nativeobject
   * @param rootP
   * @return TaxonomyNode
   */
  public static TaxonomyNode createTaxonomyNode(TaxonomyGraph graph, TaxonomyNode node, Stella_Object nativeobject, boolean rootP) {
    if (node == null) {
      { TaxonomyNode self000 = TaxonomyNode.newTaxonomyNode();

        self000.nativeObject = nativeobject;
        node = self000;
      }
    }
    else {
      TaxonomyNode.initializeTaxonomyNode(node);
      node.nativeObject = nativeobject;
    }
    TaxonomyGraph.addTaxonomyNode(graph, node, rootP);
    return (node);
  }

  /** Update <code>graph</code>s roots according to <code>node</code>s current state.
   * @param graph
   * @param node
   */
  public static void updateTaxonomyRoots(TaxonomyGraph graph, TaxonomyNode node) {
    if (node.parents == Stella.NIL) {
      TaxonomyGraph.addTaxonomyRoot(graph, node);
    }
    else {
      TaxonomyGraph.removeTaxonomyRoot(graph, node);
    }
  }

  /** Remove <code>root</code> from <code>graph</code>s root nodes.
   * @param graph
   * @param root
   */
  public static void removeTaxonomyRoot(TaxonomyGraph graph, TaxonomyNode root) {
    if (!(root.label == Stella.DELETED_LABEL)) {
      graph.roots.remove(root);
    }
  }

  /** Add <code>root</code> as a root node to <code>graph</code>.  Only do this if
   * <code>root</code> does not have any parents and is not a <code>graph</code> root already.
   * @param graph
   * @param root
   */
  public static void addTaxonomyRoot(TaxonomyGraph graph, TaxonomyNode root) {
    graph.roots.insertNew(root);
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { TaxonomyGraph self = this;

      stream.print("|TG|" + self.roots);
    }
  }

  public static Stella_Object accessTaxonomyGraphSlotValue(TaxonomyGraph self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_RENUMBER_IF_OUT_OF_NUMBERSp) {
      if (setvalueP) {
        self.renumberIfOutOfNumbersP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.renumberIfOutOfNumbersP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_RENUMBER_RATIO) {
      if (setvalueP) {
        self.renumberRatio = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.renumberRatio);
      }
    }
    else if (slotname == Stella.SYM_STELLA_INCREMENTAL_MODEp) {
      if (setvalueP) {
        self.incrementalModeP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.incrementalModeP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_LARGEST_POSTORDER_NUMBER) {
      if (setvalueP) {
        self.largestPostorderNumber = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.largestPostorderNumber);
      }
    }
    else if (slotname == Stella.SYM_STELLA_NUMBER_OF_NODES) {
      if (setvalueP) {
        self.numberOfNodes = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.numberOfNodes);
      }
    }
    else if (slotname == Stella.SYM_STELLA_NUMBER_OF_FOREIGN_INTERVAL_NODES) {
      if (setvalueP) {
        self.numberOfForeignIntervalNodes = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.numberOfForeignIntervalNodes);
      }
    }
    else if (slotname == Stella.SYM_STELLA_ROOTS) {
      if (setvalueP) {
        self.roots = ((List)(value));
      }
      else {
        value = self.roots;
      }
    }
    else if (slotname == Stella.SYM_STELLA_BROKEN_LINKS) {
      if (setvalueP) {
        self.brokenLinks = ((List)(value));
      }
      else {
        value = self.brokenLinks;
      }
    }
    else if (slotname == Stella.SYM_STELLA_ADDED_LINKS) {
      if (setvalueP) {
        self.addedLinks = ((List)(value));
      }
      else {
        value = self.addedLinks;
      }
    }
    else if (slotname == Stella.SYM_STELLA_REMOVED_LINKS) {
      if (setvalueP) {
        self.removedLinks = ((List)(value));
      }
      else {
        value = self.removedLinks;
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
    { TaxonomyGraph self = this;

      return (Stella.SGT_STELLA_TAXONOMY_GRAPH);
    }
  }

}

