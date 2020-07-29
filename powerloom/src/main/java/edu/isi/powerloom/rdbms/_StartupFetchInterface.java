//  -*- Mode: Java -*-
//
// _StartupFetchInterface.java

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

package edu.isi.powerloom.rdbms;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.powerloom.logic.*;
import edu.isi.stella.*;

public class _StartupFetchInterface {
  public static void startupFetchInterface() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/RDBMS", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          RDBMS.SGT_RDBMS_RUN_FETCH_QUERY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("RUN-FETCH-QUERY", null, 1)));
          RDBMS.SGT_STELLA_XML_ELEMENT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("XML-ELEMENT", Stella.getStellaModule("/STELLA", true), 1)));
          RDBMS.SGT_RDBMS_TASK_ID = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TASK-ID", null, 1)));
          RDBMS.SGT_RDBMS_SUBTASK_ID = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SUBTASK-ID", null, 1)));
          RDBMS.SGT_RDBMS_F_FETCH_EDB_QUERY_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-FETCH-EDB-QUERY-MEMO-TABLE-000", null, 1)));
          RDBMS.SGT_LOGIC_QUERY_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY-ITERATOR", Stella.getStellaModule("/LOGIC", true), 1)));
          RDBMS.SYM_RDBMS_STARTUP_FETCH_INTERFACE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-FETCH-INTERFACE", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("RUN-FETCH-QUERY", "(DEFUN (RUN-FETCH-QUERY OBJECT) ((HOST STRING) (PORT INTEGER) (QUERY-ID STRING) (TASK-ID STRING) (SUBTASK-ID STRING) (DATABASE STRING) (PARAMETERS STRING)) :DOCUMENTATION \"Runs a Fetch query specifying the parameters given.\nReturns an object representing the returned XML-encoded answer from\nthe server.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "runFetchQuery", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Integer.TYPE, Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
          Stella.defineFunctionObject("NORMALIZE-FETCH-QUERY-ARGUMENTS", "(DEFUN (NORMALIZE-FETCH-QUERY-ARGUMENTS STRING (CONS OF STRING-WRAPPER) PROPERTY-LIST) ((PROPOSITION PROPOSITION) (ARGUMENTS OBJECT)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "normalizeFetchQueryArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("[Ljava.lang.Object;")}), null);
          Stella.defineFunctionObject("HELP-MEMOIZE-FETCH-EDB-QUERY", "(DEFUN (HELP-MEMOIZE-FETCH-EDB-QUERY (ITERATOR OF CONS)) ((PROPOSITION PROPOSITION) (DATABASE LOGIC-OBJECT) (ARGUMENTS OBJECT)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "helpMemoizeFetchEdbQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("FETCH-EDB-QUERY", "(DEFUN (FETCH-EDB-QUERY (ITERATOR OF CONS)) ((PROPOSITION PROPOSITION) (DATABASE LOGIC-OBJECT) (ARGUMENTS OBJECT)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "fetchEdbQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("PARSE-FETCH-XML-ANSWER", "(DEFUN (PARSE-FETCH-XML-ANSWER (CONS OF CONS)) ((XMLANSWER CONS) (RELATION NAMED-DESCRIPTION) (OUTPUTCOLUMNS (CONS OF STRING-WRAPPER))))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "parseFetchXmlAnswer", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("PARSE-ONE-FETCH-XML-OBJECT", "(DEFUN (PARSE-ONE-FETCH-XML-OBJECT CONS) ((OBJECT CONS) (RELATION NAMED-DESCRIPTION) (OUTPUTCOLUMNS (CONS OF STRING-WRAPPER))))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "parseOneFetchXmlObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("START-FETCH-EDB-GATEWAY", "(DEFUN START-FETCH-EDB-GATEWAY ((PORT INTEGER)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "startFetchEdbGateway", new java.lang.Class [] {java.lang.Integer.TYPE}), null);
          Stella.defineFunctionObject("EVALUATE-FETCH-QUERY", "(DEFUN EVALUATE-FETCH-QUERY ((KEYS KEY-VALUE-LIST) (OUT NATIVE-OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "evaluateFetchQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.KeyValueList"), Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), null);
          Stella.defineFunctionObject("BUILD-ONE-TABLE-ASSERTION", "(DEFUN (BUILD-ONE-TABLE-ASSERTION CONS) ((TABLE-RELATION NAMED-DESCRIPTION) (TUPLE CONS) (DB-MODULE MODULE)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "buildOneTableAssertion", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Module")}), null);
          Stella.defineFunctionObject("GENERATE-TABLE-ASSERTIONS", "(DEFUN (GENERATE-TABLE-ASSERTIONS (CONS OF CONS)) ((TABLE-NAME STRING) (XML-ANSWER CONS) (MODULE MODULE) (DB-MODULE MODULE)) :DOCUMENTATION \"Takes a Stella-parsed, XML-encoded `xml-answer' from Fetch based on\nthe database table `table-name' and uses it to generate an assertion\nfor an appropriate relation for inclusion in `module'.  The database\nmeta information is found in `db-module'.\")", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "generateTableAssertions", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.stella.Module")}), null);
          Stella.defineFunctionObject("LOOKUP-STRING-VALUE", "(DEFUN (LOOKUP-STRING-VALUE STRING) ((RELATION NAMED-DESCRIPTION) (INSTANCE LOGIC-OBJECT) (MOD MODULE)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "lookupStringValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Module")}), null);
          Stella.defineFunctionObject("FETCH-QUERY-ASSERTIONS", "(DEFUN (FETCH-QUERY-ASSERTIONS (CONS OF CONS)) ((HOST STRING) (PORT INTEGER) (FETCH-QUERY LOGIC-OBJECT) (TASK-ID STRING) (SUBTASK-ID STRING) (DATABASE STRING) (PARAMETER-VALUE STRING) (TARGET-MODULE MODULE) (DB-MODULE MODULE)) :PUBLIC? TRUE :DOCUMENTATION \"Runs a `fetch-query' using `task-id'; `subtask-id',`database'\nand specifying a single additional `parameter-value'.  The connection\nis made to a remote http query server running on `host' port number `port'.\nReturns a set of assertions for `target-module' using the information in `db-module'\nto find the appropriate relations.\")", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "fetchQueryAssertions", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.stella.Module")}), null);
          Stella.defineFunctionObject("STARTUP-FETCH-INTERFACE", "(DEFUN STARTUP-FETCH-INTERFACE () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.rdbms._StartupFetchInterface", "startupFetchInterface", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(RDBMS.SYM_RDBMS_STARTUP_FETCH_INTERFACE);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, RDBMS.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupFetchInterface"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("RDBMS")))));
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
