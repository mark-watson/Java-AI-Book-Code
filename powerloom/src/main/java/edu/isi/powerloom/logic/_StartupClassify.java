//  -*- Mode: Java -*-
//
// _StartupClassify.java

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

public class _StartupClassify {
  static void helpStartupClassify1() {
    {
      Logic.KWD_IMPLIES_PROPOSITION_UPDATE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("IMPLIES-PROPOSITION-UPDATE", null, 2)));
      Logic.SGT_LOGIC_F_INFERABLE_WITH_CYCLE_CHECKp_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-INFERABLE-WITH-CYCLE-CHECK?-MEMO-TABLE-000", null, 1)));
      Logic.SGT_LOGIC_MARKER_TABLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("MARKER-TABLE", null, 1)));
      Logic.SYM_LOGIC_TEST_TABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TEST-TABLE", null, 0)));
      Logic.SYM_LOGIC_RECALL_TABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RECALL-TABLE", null, 0)));
      Logic.SYM_LOGIC_SUPPORTS_RECALLp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SUPPORTS-RECALL?", null, 0)));
      Logic.KWD_CLASSIFIER_INFERENCES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASSIFIER-INFERENCES", null, 2)));
      Logic.SGT_LOGIC_CLASSIFICATION_CACHE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASSIFICATION-CACHE", null, 1)));
      Logic.SYM_LOGIC_INFERABLE_DIRECT_SUBDESCRIPTIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INFERABLE-DIRECT-SUBDESCRIPTIONS", null, 0)));
      Logic.SYM_LOGIC_CACHE_UPCLASSIFICATION_TIMESTAMP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CACHE-UPCLASSIFICATION-TIMESTAMP", null, 0)));
      Logic.SYM_LOGIC_CACHE_DOWNCLASSIFICATION_TIMESTAMP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CACHE-DOWNCLASSIFICATION-TIMESTAMP", null, 0)));
      Logic.SYM_LOGIC_INTRODUCTION_TIMESTAMP = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INTRODUCTION-TIMESTAMP", null, 0)));
      Logic.SGT_LOGIC_CLASSIFICATION_SESSION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASSIFICATION-SESSION", null, 1)));
      Logic.SYM_LOGIC_CLASSIFICATION_CACHE_TABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASSIFICATION-CACHE-TABLE", null, 0)));
      Logic.SYM_LOGIC_CLASSIFICATION_TIMECLOCK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASSIFICATION-TIMECLOCK", null, 0)));
      Logic.SYM_LOGIC_INTRODUCTION_TIMESTAMP_STACK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INTRODUCTION-TIMESTAMP-STACK", null, 0)));
      Logic.SYM_LOGIC_EVERYTHING_CLASSIFIEDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EVERYTHING-CLASSIFIED?", null, 0)));
      Logic.SYM_LOGIC_LAST_CACHE_TABLE_KEY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LAST-CACHE-TABLE-KEY", null, 0)));
      Logic.SYM_LOGIC_LAST_CACHE_TABLE_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LAST-CACHE-TABLE-VALUE", null, 0)));
      Logic.KWD_INSTANCE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INSTANCE", null, 2)));
      Logic.SYM_LOGIC_CLASSIFICATION_SESSION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASSIFICATION-SESSION", null, 0)));
      Logic.KWD_CLASSIFIER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASSIFIER", null, 2)));
      Logic.KWD_CLASSIFIER_PROFILE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CLASSIFIER-PROFILE", null, 2)));
      Logic.SYM_LOGIC_STARTUP_CLASSIFY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-CLASSIFY", null, 0)));
    }
  }

  static void helpStartupClassify2() {
    {
      Stella.defineFunctionObject("BUMP-INFERABLE-TIMESTAMP", "(DEFUN BUMP-INFERABLE-TIMESTAMP () :GLOBALLY-INLINE? TRUE (BUMP-MEMOIZATION-TIMESTAMP :IMPLIES-PROPOSITION-UPDATE))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "bumpInferableTimestamp", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("HELP-COLLECT-INTENSIONAL-PARENTS", "(DEFUN HELP-COLLECT-INTENSIONAL-PARENTS ((DESCRIPTION DESCRIPTION) (PROPOSITION PROPOSITION) (COLLECTION LIST)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "helpCollectIntensionalParents", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("ALL-INTENSIONAL-PARENTS", "(DEFUN (ALL-INTENSIONAL-PARENTS (LIST OF DESCRIPTION)) ((SELF DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "allIntensionalParents", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("INFERABLE-THROUGH-BY-SOME-DESCENDANT?", "(DEFUN (INFERABLE-THROUGH-BY-SOME-DESCENDANT? BOOLEAN) ((SELF NAMED-DESCRIPTION) (THROUGHCHILD LOGIC-OBJECT) (ALREADYVISITEDLIST CONS)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "inferableThroughBySomeDescendantP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("INFERABLE-WITH-CYCLE-CHECK?", "(DEFUN (INFERABLE-WITH-CYCLE-CHECK? BOOLEAN) ((SELF DESCRIPTION) (ALREADYVISITEDLIST CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "inferableWithCycleCheckP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("INFERABLE?", "(DEFUN (INFERABLE? BOOLEAN) ((SELF DESCRIPTION)) :INLINE INFERABLE-WITH-CYCLE-CHECK?)", Native.find_java_method("edu.isi.powerloom.logic.Description", "inferableP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("NON-INFERABLE?", "(DEFUN (NON-INFERABLE? BOOLEAN) ((SELF DESCRIPTION)) :INLINE INFERABLE?)", Native.find_java_method("edu.isi.powerloom.logic.Description", "nonInferableP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("CREATE-MARKER-STORAGE", "(DEFUN (CREATE-MARKER-STORAGE MARKER-TABLE) ((SUPPORTRECALL? BOOLEAN)) :DOCUMENTATION \"Return a new marker storage object, used to\nremember with objects have been 'marked'.  If 'supportRecall?'\nis set, then the iterator 'recall-marked-objects' can be invoked\non the new marker storage object.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createMarkerStorage", new java.lang.Class [] {java.lang.Boolean.TYPE}), null);
      Stella.defineMethodObject("(DEFMETHOD SET-MARKER ((SELF MARKER-TABLE) (OBJECT OBJECT)) :DOCUMENTATION \"Record membership of 'object' in the marker\nstorage object 'self'.\")", Native.find_java_method("edu.isi.powerloom.logic.MarkerTable", "setMarker", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (TEST-MARKER? BOOLEAN) ((SELF MARKER-TABLE) (OBJECT OBJECT)) :DOCUMENTATION \"Return TRUE if 'object' is stored (marked) in 'self'.\")", Native.find_java_method("edu.isi.powerloom.logic.MarkerTable", "testMarkerP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("TEST-SPECIAL-MARKER-TABLE?", "(DEFUN (TEST-SPECIAL-MARKER-TABLE? BOOLEAN) ((SELF OBJECT)) :DOCUMENTATION \"Return TRUE if the object 'self' is stored (marked)\nin the table pointed at by the special variable *specialMarkerTable*.\nDesigned for use by 'remove-if'.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "testSpecialMarkerTableP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineMethodObject("(DEFMETHOD (RECALL-MARKED-OBJECTS LIST-ITERATOR) ((SELF MARKER-TABLE)) :DOCUMENTATION \"Return an iterator that generates all marked objects\nrecorded in 'self'.\")", Native.find_java_method("edu.isi.powerloom.logic.MarkerTable", "recallMarkedObjects", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("ALL-NAMED-DIRECT-SUPERDESCRIPTIONS", "(DEFUN (ALL-NAMED-DIRECT-SUPERDESCRIPTIONS (CONS OF NAMED-DESCRIPTION)) ((SELF DESCRIPTION) (REMOVEEQUIVALENTS? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "allNamedDirectSuperdescriptions", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("ALL-NAMED-DIRECT-SUBDESCRIPTIONS", "(DEFUN (ALL-NAMED-DIRECT-SUBDESCRIPTIONS (CONS OF NAMED-DESCRIPTION)) ((SELF DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "allNamedDirectSubdescriptions", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("ADD-ISA-LINK", "(DEFUN ADD-ISA-LINK ((INSTANCE LOGIC-OBJECT) (SUPERDESCRIPTION DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "addIsaLink", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("ADD-SUBSUMPTION-LINK", "(DEFUN ADD-SUBSUMPTION-LINK ((SUBDESCRIPTION DESCRIPTION) (SUPERDESCRIPTION DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "addSubsumptionLink", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("MOST-SPECIFIC-COLLECTIONS", "(DEFUN (MOST-SPECIFIC-COLLECTIONS (CONS OF LOGIC-OBJECT)) ((DESCRIPTIONS (CONS OF LOGIC-OBJECT))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "mostSpecificCollections", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("MOST-GENERAL-COLLECTIONS", "(DEFUN (MOST-GENERAL-COLLECTIONS (CONS OF LOGIC-OBJECT)) ((DESCRIPTIONS (CONS OF LOGIC-OBJECT))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "mostGeneralCollections", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("NAMED-COLLECTION?", "(DEFUN (NAMED-COLLECTION? BOOLEAN) ((SELF LOGIC-OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "namedCollectionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("MOST-SPECIFIC-NAMED-COLLECTIONS", "(DEFUN (MOST-SPECIFIC-NAMED-COLLECTIONS (CONS OF LOGIC-OBJECT)) ((DESCRIPTIONS (CONS OF LOGIC-OBJECT))) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "mostSpecificNamedCollections", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("MOST-SPECIFIC-NAMED-DESCRIPTIONS", "(DEFUN (MOST-SPECIFIC-NAMED-DESCRIPTIONS (CONS OF NAMED-DESCRIPTION)) ((DESCRIPTIONS (CONS OF LOGIC-OBJECT))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "mostSpecificNamedDescriptions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT WORLD CLASSIFICATION-SESSION :PUBLIC? TRUE :DOCUMENTATION \"Points to a record that caches the distributed\nstate of descriptions participating in a classification session.\" :TYPE CLASSIFICATION-SESSION :ALLOCATION :DYNAMIC)");
      Stella.defineFunctionObject("GET-CLASSIFICATION-WORLD", "(DEFUN (GET-CLASSIFICATION-WORLD WORLD) () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getClassificationWorld", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("GET-CLASSIFICATION-SESSION", "(DEFUN (GET-CLASSIFICATION-SESSION CLASSIFICATION-SESSION) ((INSTANCEORDESCRIPTION KEYWORD)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getClassificationSession", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("GET-CLASSIFICATION-CACHE", "(DEFUN (GET-CLASSIFICATION-CACHE CLASSIFICATION-CACHE) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getClassificationCache", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("TOGGLE-INFERABLE-DIRECT-SUBCOLLECTIONS-CACHING", "(DEFUN (TOGGLE-INFERABLE-DIRECT-SUBCOLLECTIONS-CACHING STRING) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "toggleInferableDirectSubcollectionsCaching", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("ALL-INFERABLE-DIRECT-SUBCOLLECTIONS", "(DEFUN (ALL-INFERABLE-DIRECT-SUBCOLLECTIONS (LIST OF DESCRIPTION)) ((SELF LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "allInferableDirectSubcollections", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("FLUSH-INFERABLE-DIRECT-SUBDESCRIPTIONS-CACHE", "(DEFUN FLUSH-INFERABLE-DIRECT-SUBDESCRIPTIONS-CACHE ((IMPLIESPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "flushInferableDirectSubdescriptionsCache", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("CURRENT-CLASSIFICATION-TIME", "(DEFUN (CURRENT-CLASSIFICATION-TIME TIMESTAMP) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "currentClassificationTime", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("BUMP-CLASSIFICATION-TIMECLOCK", "(DEFUN (BUMP-CLASSIFICATION-TIMECLOCK TIMESTAMP) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "bumpClassificationTimeclock", new java.lang.Class [] {}), null);
      Stella.defineMethodObject("(DEFMETHOD (INTRODUCTION-TIMESTAMP TIMESTAMP) ((SELF LOGIC-OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "introductionTimestamp", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("INTRODUCE-INTO-CLASSIFICATION-SESSION", "(DEFUN INTRODUCE-INTO-CLASSIFICATION-SESSION ((SELF DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "introduceIntoClassificationSession", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("YOUNGEST-INTRODUCTION-TIMESTAMP", "(DEFUN (YOUNGEST-INTRODUCTION-TIMESTAMP INTEGER) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "youngestIntroductionTimestamp", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("UPCLASSIFICATION-TIMESTAMP", "(DEFUN (UPCLASSIFICATION-TIMESTAMP INTEGER) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "upclassificationTimestamp", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("DOWNCLASSIFICATION-TIMESTAMP", "(DEFUN (DOWNCLASSIFICATION-TIMESTAMP INTEGER) ((SELF LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "downclassificationTimestamp", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("REFRESH-UPCLASSIFICATION-TIMESTAMP", "(DEFUN REFRESH-UPCLASSIFICATION-TIMESTAMP ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "refreshUpclassificationTimestamp", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("REFRESH-DOWNCLASSIFICATION-TIMESTAMP", "(DEFUN REFRESH-DOWNCLASSIFICATION-TIMESTAMP ((SELF LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "refreshDownclassificationTimestamp", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("FLUSH-CLASSIFICATION-SESSIONS", "(DEFUN FLUSH-CLASSIFICATION-SESSIONS ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "flushClassificationSessions", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("UPCLASSIFIED?", "(DEFUN (UPCLASSIFIED? BOOLEAN) ((SELF OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "upclassifiedP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("UPCLASSIFIED-LATER-THAN?", "(DEFUN (UPCLASSIFIED-LATER-THAN? BOOLEAN) ((SELF LOGIC-OBJECT) (OTHER LOGIC-OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "upclassifiedLaterThanP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("DOWNCLASSIFIED?", "(DEFUN (DOWNCLASSIFIED? BOOLEAN) ((SELF LOGIC-OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "downclassifiedP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("MARK-UNMARKED-SUPERRELATIONS", "(DEFUN MARK-UNMARKED-SUPERRELATIONS ((DESCRIPTION DESCRIPTION) (SELFISBELOWTABLE MARKER-TABLE)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "markUnmarkedSuperrelations", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.powerloom.logic.MarkerTable")}), null);
      Stella.defineFunctionObject("APPLY-SUBSUMPTION-TEST?", "(DEFUN (APPLY-SUBSUMPTION-TEST? BOOLEAN) ((SUBSUMPTIONTEST FUNCTION-CODE) (SELF LOGIC-OBJECT) (SUPER LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "applySubsumptionTestP", new java.lang.Class [] {Native.find_java_class("java.lang.reflect.Method"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("HELP-COLLECT-PARENTS-BELOW?", "(DEFUN (HELP-COLLECT-PARENTS-BELOW? BOOLEAN) ((SELF LOGIC-OBJECT) (SUPER DESCRIPTION) (NEWPARENTDESCRIPTIONS (LIST OF DESCRIPTION)) (ALREADYVISITEDTABLE MARKER-TABLE) (SELFISBELOWTABLE MARKER-TABLE) (SUBSUMPTIONTEST FUNCTION-CODE)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "helpCollectParentsBelowP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.powerloom.logic.MarkerTable"), Native.find_java_class("edu.isi.powerloom.logic.MarkerTable"), Native.find_java_class("java.lang.reflect.Method")}), null);
      Stella.defineFunctionObject("COLLECT-SUBSUMING-PARENTS-BELOW", "(DEFUN COLLECT-SUBSUMING-PARENTS-BELOW ((SELF LOGIC-OBJECT) (SUPER DESCRIPTION) (NEWPARENTDESCRIPTIONS (LIST OF DESCRIPTION)) (ALREADYVISITEDTABLE MARKER-TABLE) (SELFISBELOWTABLE MARKER-TABLE) (SUBSUMPTIONTEST FUNCTION-CODE)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "collectSubsumingParentsBelow", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.powerloom.logic.MarkerTable"), Native.find_java_class("edu.isi.powerloom.logic.MarkerTable"), Native.find_java_class("java.lang.reflect.Method")}), null);
      Stella.defineFunctionObject("ALL-ANCESTORS-OF-PARENTS", "(DEFUN (ALL-ANCESTORS-OF-PARENTS (ITERATOR OF LOGIC-OBJECT)) ((SUPERS (CONS OF LOGIC-OBJECT))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allAncestorsOfParents", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("ALL-ANCESTOR-COLLECTIONS", "(DEFUN (ALL-ANCESTOR-COLLECTIONS (ITERATOR OF LOGIC-OBJECT)) ((SELF OBJECT) (INSTANCEORDESCRIPTION KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allAncestorCollections", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("HELP-UPCLASSIFY-ONE-ENTITY", "(DEFUN HELP-UPCLASSIFY-ONE-ENTITY ((SELF LOGIC-OBJECT) (INSTANCEORDESCRIPTION KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "helpUpclassifyOneEntity", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("UPCLASSIFY-ONE-INSTANCE", "(DEFUN UPCLASSIFY-ONE-INSTANCE ((SELF LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "upclassifyOneInstance", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("UPCLASSIFY-ONE-DESCRIPTION", "(DEFUN UPCLASSIFY-ONE-DESCRIPTION ((SELF LOGIC-OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "upclassifyOneDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("HELP-DOWNCLASSIFY-ONE-DESCRIPTION", "(DEFUN HELP-DOWNCLASSIFY-ONE-DESCRIPTION ((NODE LOGIC-OBJECT) (SELF LOGIC-OBJECT) (NECESSARYANCESTORS (CONS OF LOGIC-OBJECT)) (ALREADYVISITEDTABLE MARKER-TABLE)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "helpDownclassifyOneDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.powerloom.logic.MarkerTable")}), null);
      Stella.defineFunctionObject("COLLECTION-WITH-FEWEST-CHILDREN", "(DEFUN (COLLECTION-WITH-FEWEST-CHILDREN LOGIC-OBJECT) ((COLLECTIONS (CONS OF LOGIC-OBJECT))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "collectionWithFewestChildren", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CHOOSE-BEST-DOWNCLASSIFIED-PARENT", "(DEFUN (CHOOSE-BEST-DOWNCLASSIFIED-PARENT LOGIC-OBJECT) ((PARENTS (CONS OF LOGIC-OBJECT))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "chooseBestDownclassifiedParent", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("DOWNCLASSIFY-ONE-DESCRIPTION", "(DEFUN DOWNCLASSIFY-ONE-DESCRIPTION ((SELF LOGIC-OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "downclassifyOneDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineMethodObject("(DEFMETHOD (VIRGIN? BOOLEAN) ((SELF DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "virginP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("EVAPORATE-VIRGIN", "(DEFUN EVAPORATE-VIRGIN ((SELF DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "evaporateVirgin", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("FIND-DIRECT-SUPERS-AND-SUBS", "(DEFUN (FIND-DIRECT-SUPERS-AND-SUBS (CONS OF DESCRIPTION) (CONS OF DESCRIPTION) (CONS OF DESCRIPTION)) ((SELF DESCRIPTION) (ONLYSUPERS? BOOLEAN)) :DOCUMENTATION \"Classify 'self' and return three values, its direct\nsupers, direct subs, and a list of equivalent descriptions.\nSetting 'supersOnly?' may speed up the computation (perhaps by a lot).\nIf 'description' is nameless and has no dependent propositions, then\nit is automatically removed from the hierarchy after classification.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Description", "findDirectSupersAndSubs", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), java.lang.Boolean.TYPE, Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("FIND-DIRECT-SUPERS-OF-INSTANCE", "(DEFUN (FIND-DIRECT-SUPERS-OF-INSTANCE (CONS OF LOGIC-OBJECT)) ((SELF OBJECT)) :DOCUMENTATION \"Classify 'self' and return a list of most specific \nnamed descriptions among all descriptions that it satisfies.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "findDirectSupersOfInstance", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("UPCLASSIFY-NAMED-DESCRIPTIONS", "(DEFUN UPCLASSIFY-NAMED-DESCRIPTIONS ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Classify named descriptions local to 'module' and inherited\nby 'module'.  If 'local?', don't classify inherited descriptions.  If\n'module' is NULL, classify descriptions in all modules.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "upclassifyNamedDescriptions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CLASSIFY-RELATIONS", "(DEFUN CLASSIFY-RELATIONS (|&REST| (OPTIONS OBJECT)) :DOCUMENTATION \"Classify relations visible in the module defined by the :module option (which\ndefaults to the current module).  If :module was explicitly specified as NULL,\nclassify relations in all modules.  If `:local?' is specified as TRUE only classify\nrelations that belong to the specified module but not any modules it inherits.  For\nbackwards compatibility, this command also supports the old <module> <local?>\narguments specified without keywords.\n\nConceptually, the classifier operates by comparing each concept or relation\nwith all other concepts/relations, searching for a proof that a\nsubsumption relation exists between each pair. Whenever a new subsumption\nrelation is discovered, the classifier adds an `implication' link between\nmembers of the pair, thereby augmenting the structure of the\nconcept or relation hierarchy. The implemented classification algorithm is\nrelatively efficient -- it works hard at limiting the number of concepts\nor relations that need to be checked for possible subsumption\nrelationships.\n\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "classifyRelations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "classifyRelationsEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
    }
  }

  public static void startupClassify() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupClassify.helpStartupClassify1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Logic.$FINDSUPERSANDSUBSDESCRIPTION$.setDefaultValue(null);
          Logic.$CLASSIFICATIONSESSION$.setDefaultValue(null);
          Logic.$CLASSIFY_FROM_NON_INFERABLE_PARENTS_ONLYp$.setDefaultValue(new Boolean(true));
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("MARKER-TABLE", "(DEFCLASS MARKER-TABLE (STANDARD-OBJECT) :DOCUMENTATION \"Used to record (mark) a set of objects.\nCan be optimized for testing only, or also for recall.\" :SLOTS ((TEST-TABLE :TYPE HASH-TABLE) (RECALL-TABLE :TYPE LIST) (SUPPORTS-RECALL? :TYPE BOOLEAN)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.MarkerTable", "newMarkerTable", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.MarkerTable", "accessMarkerTableSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.MarkerTable"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CLASSIFICATION-CACHE", "(DEFCLASS CLASSIFICATION-CACHE (STANDARD-OBJECT) :DOCUMENTATION \"Records various kinds of data about a description\nduring a classification session.\" :SLOTS ((INFERABLE-DIRECT-SUBDESCRIPTIONS :TYPE (LIST OF DESCRIPTION)) (CACHE-UPCLASSIFICATION-TIMESTAMP :TYPE INTEGER :INITIALLY -1) (CACHE-DOWNCLASSIFICATION-TIMESTAMP :TYPE INTEGER :INITIALLY -1) (INTRODUCTION-TIMESTAMP :TYPE INTEGER :INITIALLY 0)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ClassificationCache", "newClassificationCache", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.ClassificationCache", "accessClassificationCacheSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ClassificationCache"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CLASSIFICATION-SESSION", "(DEFCLASS CLASSIFICATION-SESSION (STANDARD-OBJECT) :SLOTS ((CLASSIFICATION-WORLD :TYPE WORLD) (CLASSIFICATION-CACHE-TABLE :TYPE (HASH-TABLE OF OBJECT CLASSIFICATION-CACHE) :ALLOCATION :EMBEDDED) (CLASSIFICATION-TIMECLOCK :TYPE INTEGER :INITIALLY 0) (INTRODUCTION-TIMESTAMP-STACK :TYPE (LIST OF INTEGER-WRAPPER) :INITIALLY (LIST 0)) (EVERYTHING-CLASSIFIED? :TYPE BOOLEAN) (LAST-CACHE-TABLE-KEY :TYPE LOGIC-OBJECT) (LAST-CACHE-TABLE-VALUE :TYPE CLASSIFICATION-CACHE)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.ClassificationSession", "newClassificationSession", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.ClassificationSession", "accessClassificationSessionSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ClassificationSession"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupClassify.helpStartupClassify2();
          Stella.defineFunctionObject("LIST-UNCLASSIFIED-RELATIONS", "(DEFUN (LIST-UNCLASSIFIED-RELATIONS (CONS OF NAMED-DESCRIPTION)) (|&REST| (OPTIONS OBJECT)) :DOCUMENTATION \"Collect all named description in the module defined by the :module option (which defaults\nto the current module) that were not (or will not be) classified due to their lack of\nnon-inferable/primitive ancestor relations.  If :module was explicitly specified as NULL,\nlook in all currently defined modules.  If `:local?' is specified as TRUE only look\nin the specified module but not any modules it inherits.  For backwards compatibility,\nthis command also supports the old <module> <local?> arguments specified without keywords.\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "listUnclassifiedRelations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "listUnclassifiedRelationsEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("UPCLASSIFY-INSTANCES", "(DEFUN UPCLASSIFY-INSTANCES ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Classify instances local to 'module' and inherited\nby 'module'.  If 'local?', don't classify inherited descriptions.  If\n'module' is NULL, classify descriptions in all modules.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "upclassifyInstances", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("CLASSIFY-INSTANCES", "(DEFUN CLASSIFY-INSTANCES (|&REST| (OPTIONS OBJECT)) :DOCUMENTATION \"Classify instances visible in the module defined by the :module option (which\ndefaults to the current module).  If :module was explicitly specified as NULL,\nclassify instances in all modules.  If `:local?' is specified as TRUE only classify\ninstances that belong to the specified module but not any modules it inherits.  For\nbackwards compatibility, this command also supports the old <module> <local?>\narguments specified without keywords.\n\nConceptually, the classifier operates by comparing each instance with all\nconcepts in the hierarchy, searching for a proof for each pairing indicating\nthat the instance belongs to the concept.  Whenever a new `is-a' relation is\ndiscovered, the classifier adds an `is-a' link between the instance and the\nconcept, thereby recording an additional fact about the instance.  The\nimplemented classification algorithm is relatively efficient -- it works hard at\nlimiting the number of concepts or relations that need to be checked for\npossible is-a relationships.\n\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "classifyInstances", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "classifyInstancesEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("LIST-UNCLASSIFIED-INSTANCES", "(DEFUN (LIST-UNCLASSIFIED-INSTANCES (CONS OF LOGIC-OBJECT)) (|&REST| (OPTIONS OBJECT)) :DOCUMENTATION \"Collect all instances in the module defined by the :module option (which defaults\nto the current module) that were not (or will not be) classified due to their lack of\nnon-inferable/primitive type assertions.  If :module was explicitly specified as NULL,\nlook in all currently defined modules.  If `:local?' is specified as TRUE only look\nin the specified module but not any modules it inherits.  For backwards compatibility,\nthis command also supports the old <module> <local?> arguments specified without keywords.\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "listUnclassifiedInstances", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "listUnclassifiedInstancesEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("UPCLASSIFY-ALL-DESCRIPTIONS", "(DEFUN UPCLASSIFY-ALL-DESCRIPTIONS () :DOCUMENTATION \"Classify all named descriptions.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "upclassifyAllDescriptions", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("UPCLASSIFY-ALL-INSTANCES", "(DEFUN UPCLASSIFY-ALL-INSTANCES () :DOCUMENTATION \"Classify all named instances.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "upclassifyAllInstances", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("ALL-EQUIVALENT-COLLECTIONS", "(DEFUN (ALL-EQUIVALENT-COLLECTIONS (CONS OF LOGIC-OBJECT)) ((SELF LOGIC-OBJECT) (REFLEXIVE? BOOLEAN)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "allEquivalentCollections", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("ALL-CYCLES", "(DEFUN (ALL-CYCLES (CONS OF CONS)) ((MODULE MODULE) (LOCAL? BOOLEAN)) :PUBLIC? TRUE :DOCUMENTATION \"Return a list of lists of descriptions that are\nprovably co-extensional.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allCycles", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("STARTUP-CLASSIFY", "(DEFUN STARTUP-CLASSIFY () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupClassify", "startupClassify", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_CLASSIFY);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupClassify"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *SPECIALMARKERTABLE* MARKER-TABLE :DOCUMENTATION \"Special variable that points to the marker table \nreferenced by the function 'test-special-marker-table?'.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *FINDSUPERSANDSUBSDESCRIPTION* DESCRIPTION NULL :DOCUMENTATION \"Points to a possibly unnamed description being\ntemporarily classified.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *CLASSIFICATIONSESSION* CLASSIFICATION-SESSION NULL :PUBLIC? TRUE :DOCUMENTATION \"Points to state of on-going classification session.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *CACHE-INFERABLE-SUBCOLLECTIONS?* BOOLEAN TRUE :DOCUMENTATION \"If TRUE, prevents caching of computations of\nall inferable subcollections of a collection.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *CLASSIFY-FROM-NON-INFERABLE-PARENTS-ONLY?* BOOLEAN TRUE :DOCUMENTATION \"If true (the default) only consider those relations (or instances) for\nclassification that have at least one non-inferable parent (or type).  This\ncan greatly reduce the classification effort.  To find entities that were\nleft unclassified due to this optimization use `list-unclassified-relations'\nor `list-unclassified-instances'.\" :PUBLIC? TRUE)");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
