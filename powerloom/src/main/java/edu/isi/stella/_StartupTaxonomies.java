//  -*- Mode: Java -*-
//
// _StartupTaxonomies.java

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

public class _StartupTaxonomies {
  public static void startupTaxonomies() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Stella.SYM_STELLA_STARTUP_TAXONOMIES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-TAXONOMIES", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Stella.$TAXONOMY_POSTORDER_NUMBER$.setDefaultValue(new Integer(Stella.NULL_INTEGER));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("TAXONOMY-ROOT?", "(DEFUN (TAXONOMY-ROOT? BOOLEAN) ((NODE TAXONOMY-NODE)) :DOCUMENTATION \"Return `true' if `node' is a taxonomy root node.\" :GLOBALLY-INLINE? TRUE (RETURN (EMPTY? (PARENTS NODE))))", Native.find_java_method("edu.isi.stella.TaxonomyNode", "taxonomyRootP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("ADD-TAXONOMY-ROOT", "(DEFUN ADD-TAXONOMY-ROOT ((GRAPH TAXONOMY-GRAPH) (ROOT TAXONOMY-NODE)) :DOCUMENTATION \"Add `root' as a root node to `graph'.  Only do this if\n`root' does not have any parents and is not a `graph' root already.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "addTaxonomyRoot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph"), Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("REMOVE-TAXONOMY-ROOT", "(DEFUN REMOVE-TAXONOMY-ROOT ((GRAPH TAXONOMY-GRAPH) (ROOT TAXONOMY-NODE)) :DOCUMENTATION \"Remove `root' from `graph's root nodes.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "removeTaxonomyRoot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph"), Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("UPDATE-TAXONOMY-ROOTS", "(DEFUN UPDATE-TAXONOMY-ROOTS ((GRAPH TAXONOMY-GRAPH) (NODE TAXONOMY-NODE)) :DOCUMENTATION \"Update `graph's roots according to `node's current state.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "updateTaxonomyRoots", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph"), Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("CREATE-TAXONOMY-NODE", "(DEFUN (CREATE-TAXONOMY-NODE TAXONOMY-NODE) ((GRAPH TAXONOMY-GRAPH) (NODE TAXONOMY-NODE) (NATIVEOBJECT OBJECT) (ROOT? BOOLEAN)) :DOCUMENTATION \"Link the taxonomy node `node' to `nativeObject' and add it\nto `graph'.  If it is `null', a new node will be created.  Mark it as a root\nnode if `root?' is `true'.  Return the node.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "createTaxonomyNode", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph"), Native.find_java_class("edu.isi.stella.TaxonomyNode"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("ADD-TAXONOMY-NODE", "(DEFUN ADD-TAXONOMY-NODE ((GRAPH TAXONOMY-GRAPH) (NODE TAXONOMY-NODE) (ROOT? BOOLEAN)) :DOCUMENTATION \"Add `node' to `graph'.  Mark it as a root node if `root?'\nis `true'.  Even though this is part of the API, it should rarely be needed,\nsince `create-taxonomy-node' does everything that's necessary.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "addTaxonomyNode", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph"), Native.find_java_class("edu.isi.stella.TaxonomyNode"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("REMOVE-TAXONOMY-NODE", "(DEFUN REMOVE-TAXONOMY-NODE ((GRAPH TAXONOMY-GRAPH) (NODE TAXONOMY-NODE)) :PUBLIC? TRUE :DOCUMENTATION \"Remove `node' from `graph' and disconnect incident links.\")", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "removeTaxonomyNode", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph"), Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("CREATE-TAXONOMY-LINK", "(DEFUN CREATE-TAXONOMY-LINK ((GRAPH TAXONOMY-GRAPH) (PARENT TAXONOMY-NODE) (CHILD TAXONOMY-NODE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "createTaxonomyLink", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph"), Native.find_java_class("edu.isi.stella.TaxonomyNode"), Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("LINK-TAXONOMY-NODES", "(DEFUN LINK-TAXONOMY-NODES ((GRAPH TAXONOMY-GRAPH) (PARENT TAXONOMY-NODE) (CHILD TAXONOMY-NODE)) :DOCUMENTATION \"Cross-link `parent' and `child' in `graph'.\nIMPORTANT: This will automatically insert a backlink from `child' to\n`parent', so, for maximum efficiency it should not be called a second time\nwith the arguments reversed.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "linkTaxonomyNodes", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph"), Native.find_java_class("edu.isi.stella.TaxonomyNode"), Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("INCREMENTALLY-LINK-TAXONOMY-NODES", "(DEFUN INCREMENTALLY-LINK-TAXONOMY-NODES ((GRAPH TAXONOMY-GRAPH) (PARENT TAXONOMY-NODE) (CHILD TAXONOMY-NODE)))", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "incrementallyLinkTaxonomyNodes", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph"), Native.find_java_class("edu.isi.stella.TaxonomyNode"), Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("CREATE-NEXT-POSTORDER-INTERVAL", "(DEFUN (CREATE-NEXT-POSTORDER-INTERVAL INTERVAL) ((GRAPH TAXONOMY-GRAPH)))", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "createNextPostorderInterval", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph")}), null);
          Stella.defineFunctionObject("ALLOCATE-INTERVAL-FOR-NEW-LEAF-NODE", "(DEFUN (ALLOCATE-INTERVAL-FOR-NEW-LEAF-NODE INTERVAL) ((PARENT TAXONOMY-NODE)))", Native.find_java_method("edu.isi.stella.TaxonomyNode", "allocateIntervalForNewLeafNode", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("UNLINK-TAXONOMY-NODES", "(DEFUN UNLINK-TAXONOMY-NODES ((GRAPH TAXONOMY-GRAPH) (PARENT TAXONOMY-NODE) (CHILD TAXONOMY-NODE)) :DOCUMENTATION \"Remove link between `parent' and `child'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "unlinkTaxonomyNodes", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph"), Native.find_java_class("edu.isi.stella.TaxonomyNode"), Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("INCREMENTALLY-UNLINK-TAXONOMY-NODES", "(DEFUN INCREMENTALLY-UNLINK-TAXONOMY-NODES ((GRAPH TAXONOMY-GRAPH) (PARENT TAXONOMY-NODE) (CHILD TAXONOMY-NODE)))", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "incrementallyUnlinkTaxonomyNodes", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph"), Native.find_java_class("edu.isi.stella.TaxonomyNode"), Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("ALL-TAXONOMY-NODES", "(DEFUN (ALL-TAXONOMY-NODES (ITERATOR OF TAXONOMY-NODE)) ((GRAPH TAXONOMY-GRAPH)) :DOCUMENTATION \"Given a taxonomy `graph' that has been finalized,\nreturn an iterator that generates all the graph's nodes.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "allTaxonomyNodes", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph")}), null);
          Stella.defineFunctionObject("ALL-TAXONOMY-NODES-NEXT?", "(DEFUN (ALL-TAXONOMY-NODES-NEXT? BOOLEAN) ((SELF (ALL-PURPOSE-ITERATOR OF TAXONOMY-NODE))))", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "allTaxonomyNodesNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
          Stella.defineFunctionObject("FIND-TAXONOMY-NODE", "(DEFUN (FIND-TAXONOMY-NODE TAXONOMY-NODE) ((GRAPH TAXONOMY-GRAPH) (LABEL INTEGER)) :DOCUMENTATION \"Return some node in `graph' with label `label'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "findTaxonomyNode", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph"), java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("LABELED-TAXONOMY-NODE?", "(DEFUN (LABELED-TAXONOMY-NODE? BOOLEAN) ((NODE TAXONOMY-NODE)) :GLOBALLY-INLINE? TRUE (RETURN (DEFINED? (LABEL NODE))))", Native.find_java_method("edu.isi.stella.TaxonomyNode", "labeledTaxonomyNodeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineMethodObject("(DEFMETHOD (DELETED? BOOLEAN) ((SELF TAXONOMY-NODE)) :GLOBALLY-INLINE? TRUE (RETURN (EQL? (LABEL SELF) DELETED-LABEL)))", Native.find_java_method("edu.isi.stella.TaxonomyNode", "deletedP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (DELETED?-SETTER BOOLEAN) ((SELF TAXONOMY-NODE) (VALUE BOOLEAN)))", Native.find_java_method("edu.isi.stella.TaxonomyNode", "deletedPSetter", new java.lang.Class [] {java.lang.Boolean.TYPE}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("CLEAR-TAXONOMY-NODE", "(DEFUN CLEAR-TAXONOMY-NODE ((NODE TAXONOMY-NODE)) :DOCUMENTATION \"Clear all taxonomy-graph-specific information of `node',\nbut retain information about the native object and associated links.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.TaxonomyNode", "clearTaxonomyNode", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("INITIALIZE-TAXONOMY-NODE", "(DEFUN INITIALIZE-TAXONOMY-NODE ((NODE TAXONOMY-NODE)) :DOCUMENTATION \"Completely clear and initialize `node'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.TaxonomyNode", "initializeTaxonomyNode", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("HELP-CLEAR-TAXONOMY-GRAPH", "(DEFUN HELP-CLEAR-TAXONOMY-GRAPH ((NODE TAXONOMY-NODE)))", Native.find_java_method("edu.isi.stella.TaxonomyNode", "helpClearTaxonomyGraph", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("CLEAR-TAXONOMY-GRAPH", "(DEFUN CLEAR-TAXONOMY-GRAPH ((GRAPH TAXONOMY-GRAPH)) :DOCUMENTATION \"Clear all taxonomy-graph-specific information of `graph',\nbut retain information about the native network and associated links.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "clearTaxonomyGraph", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph")}), null);
          Stella.defineFunctionObject("INITIALIZE-TAXONOMY-GRAPH", "(DEFUN INITIALIZE-TAXONOMY-GRAPH ((GRAPH TAXONOMY-GRAPH)) :DOCUMENTATION \"Completely clear the taxonomy graph `graph'.\nNOTE: Any nodes associated with `graph' will not be cleared.  If they are\nto be reused, they have to be cleared with `initialize-taxonomy-node'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "initializeTaxonomyGraph", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph")}), null);
          Stella.defineFunctionObject("HELP-CREATE-TAXONOMY-TREE-INTERVALS", "(DEFUN (HELP-CREATE-TAXONOMY-TREE-INTERVALS INTEGER) ((SELF TAXONOMY-NODE)))", Native.find_java_method("edu.isi.stella.TaxonomyNode", "helpCreateTaxonomyTreeIntervals", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("CREATE-TAXONOMY-TREE-INTERVALS", "(DEFUN CREATE-TAXONOMY-TREE-INTERVALS ((GRAPH TAXONOMY-GRAPH)))", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "createTaxonomyTreeIntervals", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph")}), null);
          Stella.defineMethodObject("(DEFMETHOD (MEMBER? BOOLEAN) ((INTERVAL INTERVAL) (N INTEGER)) :GLOBALLY-INLINE? TRUE (RETURN (AND (>= N (LOWER-BOUND INTERVAL)) (<= N (UPPER-BOUND INTERVAL)))))", Native.find_java_method("edu.isi.stella.Interval", "memberP", new java.lang.Class [] {java.lang.Integer.TYPE}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("SUBINTERVAL-OF?", "(DEFUN (SUBINTERVAL-OF? BOOLEAN) ((SUBINTERVAL INTERVAL) (SUPERINTERVAL INTERVAL)) :GLOBALLY-INLINE? TRUE (RETURN (AND (<= (UPPER-BOUND SUBINTERVAL) (UPPER-BOUND SUPERINTERVAL)) (>= (LOWER-BOUND SUBINTERVAL) (LOWER-BOUND SUPERINTERVAL)))))", Native.find_java_method("edu.isi.stella.Interval", "subintervalOfP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Interval"), Native.find_java_class("edu.isi.stella.Interval")}), null);
          Stella.defineFunctionObject("MERGE-INTERVALS", "(DEFUN (MERGE-INTERVALS INTERVAL) ((LEFTINTERVAL INTERVAL) (RIGHTINTERVAL INTERVAL)) :GLOBALLY-INLINE? TRUE (RETURN (NEW INTERVAL :LOWER-BOUND (LOWER-BOUND LEFTINTERVAL) :UPPER-BOUND (UPPER-BOUND RIGHTINTERVAL))))", Native.find_java_method("edu.isi.stella.Interval", "mergeIntervals", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Interval"), Native.find_java_class("edu.isi.stella.Interval")}), null);
          Stella.defineFunctionObject("ALL-TAXONOMY-NODE-INTERVALS", "(DEFUN (ALL-TAXONOMY-NODE-INTERVALS (CONS OF INTERVAL)) ((NODE TAXONOMY-NODE)) :GLOBALLY-INLINE? TRUE (RETURN (INTERVALS NODE)))", Native.find_java_method("edu.isi.stella.TaxonomyNode", "allTaxonomyNodeIntervals", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("INTERN-TAXONOMY-NODE-INTERVAL", "(DEFUN (INTERN-TAXONOMY-NODE-INTERVAL INTERVAL) ((NODE TAXONOMY-NODE) (LOWERBOUND INTEGER) (UPPERBOUND INTEGER)))", Native.find_java_method("edu.isi.stella.TaxonomyNode", "internTaxonomyNodeInterval", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode"), java.lang.Integer.TYPE, java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("ADD-TAXONOMY-NODE-INTERVAL", "(DEFUN ADD-TAXONOMY-NODE-INTERVAL ((NODE TAXONOMY-NODE) (INTERVAL INTERVAL)))", Native.find_java_method("edu.isi.stella.TaxonomyNode", "addTaxonomyNodeInterval", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode"), Native.find_java_class("edu.isi.stella.Interval")}), null);
          Stella.defineFunctionObject("REMOVE-TAXONOMY-NODE-INTERVAL", "(DEFUN REMOVE-TAXONOMY-NODE-INTERVAL ((NODE TAXONOMY-NODE) (INTERVAL INTERVAL)))", Native.find_java_method("edu.isi.stella.TaxonomyNode", "removeTaxonomyNodeInterval", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode"), Native.find_java_class("edu.isi.stella.Interval")}), null);
          Stella.defineFunctionObject("ADJOIN-TAXONOMY-NODE-INTERVAL?", "(DEFUN (ADJOIN-TAXONOMY-NODE-INTERVAL? BOOLEAN) ((NODE TAXONOMY-NODE) (INTERVAL INTERVAL)))", Native.find_java_method("edu.isi.stella.TaxonomyNode", "adjoinTaxonomyNodeIntervalP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode"), Native.find_java_class("edu.isi.stella.Interval")}), null);
          Stella.defineFunctionObject("PROPAGATE-FOREIGN-INTERVAL", "(DEFUN PROPAGATE-FOREIGN-INTERVAL ((NODE TAXONOMY-NODE) (INTERVAL INTERVAL)))", Native.find_java_method("edu.isi.stella.TaxonomyNode", "propagateForeignInterval", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode"), Native.find_java_class("edu.isi.stella.Interval")}), null);
          Stella.defineFunctionObject("UNCOMPUTE-TOTAL-ANCESTORS", "(DEFUN UNCOMPUTE-TOTAL-ANCESTORS ((NODE TAXONOMY-NODE)))", Native.find_java_method("edu.isi.stella.TaxonomyNode", "uncomputeTotalAncestors", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("HELP-COMPUTE-TOTAL-ANCESTORS", "(DEFUN HELP-COMPUTE-TOTAL-ANCESTORS ((NODE TAXONOMY-NODE)))", Native.find_java_method("edu.isi.stella.TaxonomyNode", "helpComputeTotalAncestors", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("COMPUTE-TOTAL-ANCESTORS", "(DEFUN COMPUTE-TOTAL-ANCESTORS ((NODE TAXONOMY-NODE)))", Native.find_java_method("edu.isi.stella.TaxonomyNode", "computeTotalAncestors", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("CREATE-TAXONOMY-SPANNING-TREE", "(DEFUN CREATE-TAXONOMY-SPANNING-TREE ((GRAPH TAXONOMY-GRAPH) (NODE TAXONOMY-NODE)))", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "createTaxonomySpanningTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph"), Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("CREATE-TAXONOMY-SPANNING-FOREST", "(DEFUN CREATE-TAXONOMY-SPANNING-FOREST ((GRAPH TAXONOMY-GRAPH)))", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "createTaxonomySpanningForest", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph")}), null);
          Stella.defineFunctionObject("FINALIZE-TAXONOMY-GRAPH", "(DEFUN FINALIZE-TAXONOMY-GRAPH ((GRAPH TAXONOMY-GRAPH)) :DOCUMENTATION \"Finalize the taxonomy graph `graph'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "finalizeTaxonomyGraph", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph")}), null);
          Stella.defineFunctionObject("FINALIZE-TAXONOMY-GRAPH-NONINCREMENTALLY", "(DEFUN FINALIZE-TAXONOMY-GRAPH-NONINCREMENTALLY ((GRAPH TAXONOMY-GRAPH)))", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "finalizeTaxonomyGraphNonincrementally", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph")}), null);
          Stella.defineFunctionObject("TAXONOMY-SUBNODE-OF?", "(DEFUN (TAXONOMY-SUBNODE-OF? BOOLEAN) ((SUB-NODE TAXONOMY-NODE) (SUPER-NODE TAXONOMY-NODE)) :DOCUMENTATION \"Return TRUE if `sub-node' is a descendant of `super-node'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.TaxonomyNode", "taxonomySubnodeOfP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode"), Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("SLOW-TAXONOMY-SUBNODE-OF?", "(DEFUN (SLOW-TAXONOMY-SUBNODE-OF? BOOLEAN) ((SUBNODE TAXONOMY-NODE) (SUPERNODE TAXONOMY-NODE)))", Native.find_java_method("edu.isi.stella.TaxonomyNode", "slowTaxonomySubnodeOfP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode"), Native.find_java_class("edu.isi.stella.TaxonomyNode")}), null);
          Stella.defineFunctionObject("PRINT-TAXONOMY-TREE", "(DEFUN PRINT-TAXONOMY-TREE ((NODE TAXONOMY-NODE) (INDENT INTEGER) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.TaxonomyNode", "printTaxonomyTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("PRINT-TAXONOMY-GRAPH", "(DEFUN PRINT-TAXONOMY-GRAPH ((GRAPH TAXONOMY-GRAPH) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "printTaxonomyGraph", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("PRINT-TAXONOMY-SPANNING-TREE", "(DEFUN PRINT-TAXONOMY-SPANNING-TREE ((NODE TAXONOMY-NODE) (INDENT INTEGER) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.TaxonomyNode", "printTaxonomySpanningTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyNode"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("PRINT-TAXONOMY-SPANNING-FOREST", "(DEFUN PRINT-TAXONOMY-SPANNING-FOREST ((GRAPH TAXONOMY-GRAPH) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.stella.TaxonomyGraph", "printTaxonomySpanningForest", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.TaxonomyGraph"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("STARTUP-TAXONOMIES", "(DEFUN STARTUP-TAXONOMIES () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupTaxonomies", "startupTaxonomies", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_TAXONOMIES);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupTaxonomies"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *NUMBERING-INTERVAL* INTEGER 100 :PUBLIC? TRUE :DOCUMENTATION \"Spacing between postorder numbers for nodes.  Allows limited\nincremental insertions without having to renumber the whole graph.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT MARKER-LABEL INTEGER -99 :DOCUMENTATION \"Dummy label used for marking a node\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT DELETED-LABEL INTEGER -99 :DOCUMENTATION \"Label used for marking deleted nodes\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *TAXONOMY-POSTORDER-NUMBER* INTEGER NULL)");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
