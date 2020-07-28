//  -*- Mode: Java -*-
//
// _StartupApiSupport.java

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

public class _StartupApiSupport {
  public static void startupApiSupport() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Logic.SYM_LOGIC_STARTUP_API_SUPPORT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-API-SUPPORT", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("CLASS-NAMES-NEXT?", "(DEFUN (CLASS-NAMES-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "classNamesNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
          Stella.defineFunctionObject("ALL-PROPOSITIONS-NEXT?", "(DEFUN (ALL-PROPOSITIONS-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allPropositionsNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
          Stella.defineFunctionObject("ALL-PROPOSITIONS", "(DEFUN (ALL-PROPOSITIONS (ITERATOR OF PROPOSITION)) ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Iterate over all conceived propositions visible from `module'.\nOnly propositions that haven't been deleted will be considered.\nIf `local?', only return propositions conceived locally in `module'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("FILTER-INCONSISTENT-PROPOSITION?", "(DEFUN (FILTER-INCONSISTENT-PROPOSITION? BOOLEAN) ((SELF OBJECT) (ITERATOR ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "filterInconsistentPropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
          Stella.defineFunctionObject("ALL-INCONSISTENT-PROPOSITIONS", "(DEFUN (ALL-INCONSISTENT-PROPOSITIONS (ITERATOR OF PROPOSITION)) ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Iterate over all conceived propositions visible from `module'\nthat have an inconsistent truth value.  If `local?', only return\ninconsistent propositions conceived locally in `module'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allInconsistentPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("LOCALLY-MODIFIED-PROPOSITION?", "(DEFUN (LOCALLY-MODIFIED-PROPOSITION? BOOLEAN) ((PROPOSITION PROPOSITION) (MODULE MODULE)) :DOCUMENTATION \"Return true if proposition's truth-value has been locally modified in\n`module' (initialized, asserted, retracted).  This will always succeed for locally conceived\npropositions regardless of whether their truth value is defined or not.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "locallyModifiedPropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Module")}), null);
          Stella.defineFunctionObject("FILTER-LOCALLY-MODIFIED-PROPOSITION?", "(DEFUN (FILTER-LOCALLY-MODIFIED-PROPOSITION? BOOLEAN) ((SELF OBJECT) (ITERATOR ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "filterLocallyModifiedPropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
          Stella.defineFunctionObject("ALL-LOCALLY-MODIFIED-PROPOSITIONS", "(DEFUN (ALL-LOCALLY-MODIFIED-PROPOSITIONS (ITERATOR OF PROPOSITION)) ((MODULE MODULE)) :DOCUMENTATION \"Iterate over all conceived propositions visible from `module' that had their\ntruth value locally modified (initialized, asserted, retracted).  Note, that this\nwill always include all locally conceived propositions.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allLocallyModifiedPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
          Stella.defineFunctionObject("VISIBLE-TERM?", "(DEFUN (VISIBLE-TERM? BOOLEAN) ((TERM LOGIC-OBJECT) (CONTEXT CONTEXT) (LOCAL? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "visibleTermP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Context"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("ALL-UNNAMED-TERMS", "(DEFUN (ALL-UNNAMED-TERMS ITERATOR) ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Iterate over all unnamed terms visible from `module'.  A term can be\nan instance (or individual) as well as a description.  Only terms that\nhaven't been deleted will be considered.  If `local?', only return\nterms created locally in `module'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allUnnamedTerms", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("NAMED-TERM?", "(DEFUN (NAMED-TERM? BOOLEAN) ((TERM OBJECT) (ITER ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "namedTermP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
          Stella.defineFunctionObject("ALL-NAMED-TERMS", "(DEFUN (ALL-NAMED-TERMS (ITERATOR OF OBJECT)) ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Iterate over all named terms visible from `module'.  A term can be an\ninstance (or individual) as well as a description.  Only terms that\nhaven't been deleted will be considered.  If `local?', only return \nterms created locally in `module'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allNamedTerms", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("ALL-TERMS", "(DEFUN (ALL-TERMS (ITERATOR OF OBJECT)) ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Return a list of all terms visible from `module'.  A term can be an\ninstance (or individual) as well as a description.  Only terms that\nhaven't been deleted will be considered.  If `local?', only return \nterms created locally in `module'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allTerms", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("FILTER-INSTANCE?", "(DEFUN (FILTER-INSTANCE? BOOLEAN) ((SELF LOGIC-OBJECT) (ITERATOR ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "filterInstanceP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
          Stella.defineFunctionObject("ALL-NAMED-INSTANCES", "(DEFUN (ALL-NAMED-INSTANCES (ITERATOR OF LOGIC-OBJECT)) ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Iterate over all named instances (or individuals) visible from `module'.\nOnly instances that haven't been deleted will be considered.  If `local?',\nonly return instances created locally in `module'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allNamedInstances", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("ALL-INSTANCES", "(DEFUN (ALL-INSTANCES (ITERATOR OF LOGIC-OBJECT)) ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Iterate over all instances (or individuals) visible from `module'.\nOnly instances that haven't been deleted will be considered.  If `local?',\nonly return instances created locally in `module'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allInstances", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("STRING-TO-LOGIC-OBJECT", "(DEFUN (STRING-TO-LOGIC-OBJECT LOGIC-OBJECT) ((STRING STRING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "stringToLogicObject", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("STARTUP-API-SUPPORT", "(DEFUN STARTUP-API-SUPPORT () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupApiSupport", "startupApiSupport", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_API_SUPPORT);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupApiSupport"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.$STRING_TO_OBJECT_FUNCTIONS$.insertAt(Logic.SGT_LOGIC_LOGIC_OBJECT, FunctionCodeWrapper.wrapFunctionCode(Native.find_java_method("edu.isi.powerloom.logic.Logic", "stringToLogicObject", new java.lang.Class [] {Native.find_java_class("java.lang.String")})));
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
