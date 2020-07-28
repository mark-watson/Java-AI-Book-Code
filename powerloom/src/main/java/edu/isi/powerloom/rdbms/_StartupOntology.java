//  -*- Mode: Java -*-
//
// _StartupOntology.java

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

public class _StartupOntology {
  public static void startupOntology() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/RDBMS", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          RDBMS.SYM_RDBMS_DATABASE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DATABASE", null, 0)));
          RDBMS.KWD_DOCUMENTATION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DOCUMENTATION", null, 2)));
          RDBMS.SYM_RDBMS_SQL_DATABASE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SQL-DATABASE", null, 0)));
          RDBMS.SYM_RDBMS_PROTOCOL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PROTOCOL", null, 0)));
          RDBMS.KWD__g = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("->", null, 2)));
          RDBMS.KWD_GOES_TRUE_DEMON = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("GOES-TRUE-DEMON", null, 2)));
          RDBMS.SYM_RDBMS_DB_UPDATE_DEMON = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DB-UPDATE-DEMON", null, 0)));
          RDBMS.KWD_GOES_UNKNOWN_DEMON = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("GOES-UNKNOWN-DEMON", null, 2)));
          RDBMS.SYM_RDBMS_SERVER_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SERVER-TYPE", null, 0)));
          RDBMS.SYM_RDBMS_DSN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DSN", null, 0)));
          RDBMS.SYM_RDBMS_CONNECTION_STRING = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CONNECTION-STRING", null, 0)));
          RDBMS.SYM_RDBMS_ODBC_CONNECTION_STRING = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ODBC-CONNECTION-STRING", null, 0)));
          RDBMS.SYM_RDBMS_JDBC_CONNECTION_STRING = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JDBC-CONNECTION-STRING", null, 0)));
          RDBMS.SYM_RDBMS_HOST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("HOST", null, 0)));
          RDBMS.SYM_RDBMS_PORT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PORT", null, 0)));
          RDBMS.SYM_RDBMS_USER = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("USER", null, 0)));
          RDBMS.SYM_RDBMS_PASSWORD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PASSWORD", null, 0)));
          RDBMS.SYM_RDBMS_DB_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DB-NAME", null, 0)));
          RDBMS.SYM_RDBMS_DB_CONNECTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DB-CONNECTION", null, 0)));
          RDBMS.KWD_AXIOMS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("AXIOMS", null, 2)));
          RDBMS.SYM_RDBMS_RELATION_TABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION-TABLE", null, 0)));
          RDBMS.SYM_RDBMS_RELATION_DATABASE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION-DATABASE", null, 0)));
          RDBMS.SYM_RDBMS_RELATION_COLUMN_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION-COLUMN-NAME", null, 0)));
          RDBMS.SYM_RDBMS_RELATION_COLUMN_MODULE_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION-COLUMN-MODULE-NAME", null, 0)));
          RDBMS.SYM_RDBMS_RELATION_COLUMN_MODULE_REFERENCE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION-COLUMN-MODULE-REFERENCE", null, 0)));
          RDBMS.SYM_RDBMS_QUERY_EVALUATOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY-EVALUATOR", null, 0)));
          RDBMS.SYM_RDBMS_SUPPORTS_DB_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SUPPORTS-DB-TYPE", null, 0)));
          RDBMS.KWD_CLOSED = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CLOSED", null, 2)));
          RDBMS.SYM_STELLA_TRUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TRUE", Stella.getStellaModule("/STELLA", true), 0)));
          RDBMS.SYM_RDBMS_QUERY_PATTERN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY-PATTERN", null, 0)));
          RDBMS.SYM_RDBMS_QUERY_SQL_DATABASE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY-SQL-DATABASE", null, 0)));
          RDBMS.KWD_VARIABLE_ARITY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-ARITY", null, 2)));
          RDBMS.KWD_RELATION_SPECIALIST = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION-SPECIALIST", null, 2)));
          RDBMS.SYM_RDBMS_QUERY_SQL_DATABASE_SPECIALIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY-SQL-DATABASE-SPECIALIST", null, 0)));
          RDBMS.SYM_RDBMS_QUERY_DATABASE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY-DATABASE", null, 0)));
          RDBMS.SYM_RDBMS_QUERY_DATABASE_SPECIALIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY-DATABASE-SPECIALIST", null, 0)));
          RDBMS.SYM_RDBMS_FETCH_EDB_DATABASE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FETCH-EDB-DATABASE", null, 0)));
          RDBMS.SYM_RDBMS_TASK_ID = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TASK-ID", null, 0)));
          RDBMS.SYM_RDBMS_SUBTASK_ID = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SUBTASK-ID", null, 0)));
          RDBMS.SYM_RDBMS_FETCH_QUERY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FETCH-QUERY", null, 0)));
          RDBMS.SYM_RDBMS_FETCH_QUERY_TYPE_1 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FETCH-QUERY-TYPE-1", null, 0)));
          RDBMS.SYM_RDBMS_FETCH_QUERY_TYPE_2 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FETCH-QUERY-TYPE-2", null, 0)));
          RDBMS.SYM_RDBMS_QUERY_TABLE_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY-TABLE-NAME", null, 0)));
          RDBMS.SYM_RDBMS_QUERY_PARAMETER_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY-PARAMETER-NAME", null, 0)));
          RDBMS.SYM_RDBMS_STARTUP_ONTOLOGY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-ONTOLOGY", null, 0)));
          RDBMS.SYM_STELLA_METHOD_STARTUP_CLASSNAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-STARTUP-CLASSNAME", Stella.getStellaModule("/STELLA", true), 0)));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("STARTUP-ONTOLOGY", "(DEFUN STARTUP-ONTOLOGY () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.rdbms._StartupOntology", "startupOntology", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(RDBMS.SYM_RDBMS_STARTUP_ONTOLOGY);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, RDBMS.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupOntology"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("RDBMS")))));
          { Object old$Module$001 = Stella.$MODULE$.get();
            Object old$Context$001 = Stella.$CONTEXT$.get();

            try {
              Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("PL-KERNEL-KB", true));
              Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
              Logic.defconcept(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DATABASE))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("Information defining a database.  The connection relation is transient.")))), Stella.NIL))));
              Logic.defconcept(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_SQL_DATABASE))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((DATABASE) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("Information defining a database that supports SQL queries via JDBC or ODBC.")))), Stella.NIL)))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_PROTOCOL))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?DB DATABASE)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD__g, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?CS STRING) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The protocol that should be used to connect to the database\nin case there are multiple options for the current implementation language.\nFor example, in Lisp and C++ we could use either \"ODBC\" or the \"MySQL\" API\n(which is not yet supported), while in Java we only support `JDBC'.")))), Cons.cons(RDBMS.KWD_GOES_TRUE_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Cons.cons(RDBMS.KWD_GOES_UNKNOWN_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_SERVER_TYPE))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?DB DATABASE)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD__g, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?CS STRING) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The type of DBMS server used such as \"MySQL\" or \"Oracle\".\nThis information is needed if connection strings are not given directly but\nneed to be assembled from individual pieces.")))), Cons.cons(RDBMS.KWD_GOES_TRUE_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Cons.cons(RDBMS.KWD_GOES_UNKNOWN_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DSN))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?DB DATABASE)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD__g, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?DSN STRING) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The data source name used for a connection.  Currently, data\nsources are only supported for ODBC and not (yet) JDBC.  By specifying a data\nsource, all connection information can be kept in some external file such as\n`.odbc.ini'.")))), Cons.cons(RDBMS.KWD_GOES_TRUE_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Cons.cons(RDBMS.KWD_GOES_UNKNOWN_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_CONNECTION_STRING))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?DB DATABASE)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD__g, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?CS STRING) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The connection string used for an ODBC or JDBC connection.  Deprecated")))), Cons.cons(RDBMS.KWD_GOES_TRUE_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Cons.cons(RDBMS.KWD_GOES_UNKNOWN_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_ODBC_CONNECTION_STRING))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?DB DATABASE)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD__g, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?CS STRING) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The connection string used for a ODBC connection.")))), Cons.cons(RDBMS.KWD_GOES_TRUE_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Cons.cons(RDBMS.KWD_GOES_UNKNOWN_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_JDBC_CONNECTION_STRING))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?DB DATABASE)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD__g, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?CS STRING) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The connection string used for a JDBC connection.")))), Cons.cons(RDBMS.KWD_GOES_TRUE_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Cons.cons(RDBMS.KWD_GOES_UNKNOWN_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_HOST))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?DB DATABASE)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD__g, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?HOST STRING) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The host of a database server.")))), Cons.cons(RDBMS.KWD_GOES_TRUE_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Cons.cons(RDBMS.KWD_GOES_UNKNOWN_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_PORT))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?DB DATABASE)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD__g, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?PORT INTEGER) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The port of a database server.")))), Cons.cons(RDBMS.KWD_GOES_TRUE_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Cons.cons(RDBMS.KWD_GOES_UNKNOWN_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_USER))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?DB DATABASE)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD__g, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?USER STRING) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The user for a database server.")))), Cons.cons(RDBMS.KWD_GOES_TRUE_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Cons.cons(RDBMS.KWD_GOES_UNKNOWN_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_PASSWORD))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?DB DATABASE)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD__g, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?PASSWORD STRING) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The password associated with a user for a database server.")))), Cons.cons(RDBMS.KWD_GOES_TRUE_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Cons.cons(RDBMS.KWD_GOES_UNKNOWN_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_NAME))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?DB DATABASE)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD__g, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?DBNAME STRING) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The name of a database on a database server.")))), Cons.cons(RDBMS.KWD_GOES_TRUE_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Cons.cons(RDBMS.KWD_GOES_UNKNOWN_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_CONNECTION))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?DB DATABASE)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD__g, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?CONNECTION CONNECTION-WRAPPER) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("A connection id produced by using the rest of the information\nassociated with the database.  This relation is transient, i.e., it can be\nreset dynamically, whereas the other relations should not change.")))), Cons.cons(RDBMS.KWD_AXIOMS, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((HIDDEN-RELATION DB-CONNECTION) \"/RDBMS\")", "/RDBMS")))), Stella.NIL)))))))));
              Logic.defrelation(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_RELATION_TABLE))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?RELATION /PL-KERNEL-KB/RELATION) (?TABLE STRING)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("Associates a PowerLoom ?relation with a database ?table.")))), Stella.NIL)))));
              Logic.defrelation(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_RELATION_DATABASE))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?RELATION /PL-KERNEL-KB/RELATION) (?DATABASE DATABASE)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("Associates a PowerLoom ?relation with an RDBMS ?database.")))), Stella.NIL)))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_RELATION_COLUMN_NAME))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?DBRELATION /PL-KERNEL-KB/RELATION) (?COL INTEGER)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD__g, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?COLNAME STRING) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The name of the database table column at position ?col (1-based)\nassociated with the database relation ?dbrelation.")))), Stella.NIL)))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_RELATION_COLUMN_MODULE_NAME))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?DBRELATION /PL-KERNEL-KB/RELATION) (?COL INTEGER)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD__g, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?MODNAME STRING) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The name of the module to import the logic objects defined at table column at position ?col (1-based)\nassociated with the database relation ?dbrelation.")))), Stella.NIL)))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_RELATION_COLUMN_MODULE_REFERENCE))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?DBRELATION /PL-KERNEL-KB/RELATION) (?COL INTEGER)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD__g, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?MODREF STRING) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The name of the column from which to get the name of the module\nto import the logic objects defined at table column at position ?col (1-based)\nassociated with the database relation ?dbrelation.")))), Stella.NIL)))))));
              Logic.renamed_Assert(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((COMPUTED-PROCEDURE DBTABLE-SPECIALIST) \"/RDBMS\")", "/RDBMS")))));
              Logic.defconcept(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_QUERY_EVALUATOR))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((COMPUTED-PROCEDURE) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("A specialist procedure that can evaluate generic external queries.")))), Stella.NIL)))));
              Logic.defrelation(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_SUPPORTS_DB_TYPE))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?EVALUATOR QUERY-EVALUATOR) (?DBTYPE CONCEPT)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("Specifies that ?evaluator can handle external databases of\ntype ?dbType.")))), Cons.cons(RDBMS.KWD_CLOSED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_STELLA_TRUE))), Stella.NIL)))))));
              Logic.defrelation(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_QUERY_PATTERN))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?RELATION /PL-KERNEL-KB/RELATION) (?EVALUATOR QUERY-EVALUATOR) (?DATABASE DATABASE) (?ARGUMENTS STRING)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("Specifies a query evaluation pattern that can generate bindings\nfor ?relation from an external ?database.  ?evaluator is a query evaluator that\ntakes a query proposition, the ?database instance and an ?arguments specification\nand returns an iterator that generates CONS tuples whose elements will be matched\nto ?relation's arguments by position.  The format of ?arguments is specific to\neach evaluator (see for example the function `RDBMS/SQL-join').\n\nWhether a particular pattern is applicable depends on whether all the required\ninput arguments are bound and whether ?evaluator can handle the particular\n?database type.  If there are multiple applicable patterns they will be run/\nevaluated in sequence (similar to having multiple rules for ?relation).")))), Cons.cons(RDBMS.KWD_CLOSED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_STELLA_TRUE))), Stella.NIL)))))));
              Logic.renamed_Assert(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((COMPUTED-PROCEDURE SQL-QUERY) \"/RDBMS\")", "/RDBMS")))));
              Logic.renamed_Assert(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((AND (DOCUMENTATION SQL-QUERY \"Generic query evaluator that can handle arbitrary\nSQL queries on an RDBMS/SQL-Database.\") (QUERY-EVALUATOR SQL-QUERY) (SUPPORTS-DB-TYPE SQL-QUERY SQL-DATABASE)) \"/RDBMS\")", "/RDBMS")))));
              Logic.renamed_Assert(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((COMPUTED-PROCEDURE SQL-JOIN) \"/RDBMS\")", "/RDBMS")))));
              Logic.renamed_Assert(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((AND (DOCUMENTATION SQL-JOIN \"Generic query evaluator that can evaluate\nsimple joins on an RDBMS/SQL-Database.\") (QUERY-EVALUATOR SQL-JOIN) (SUPPORTS-DB-TYPE SQL-JOIN SQL-DATABASE)) \"/RDBMS\")", "/RDBMS")))));
              Logic.renamed_Assert(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((COMPUTED-PROCEDURE QUERY-SPECIALIST) \"/RDBMS\")", "/RDBMS")))));
              Logic.renamed_Assert(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((DOCUMENTATION QUERY-SPECIALIST \"Top-level specialist that can dispatch generic query\nevaluation specialists such as RDBMS/SQL-join.\") \"/RDBMS\")", "/RDBMS")))));
              Logic.renamed_Assert(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((COMPUTED-PROCEDURE QUERY-SQL-DATABASE-SPECIALIST) \"/RDBMS\")", "/RDBMS")))));
              Logic.defrelation(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_QUERY_SQL_DATABASE))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?DATABASE SQL-DATABASE) (?QUERY STRING) ?OUTPUT) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("Run the SQL ?query against ?database and bind\none or more ?output arguments to the columns in the resulting tuples.\nThis can be turned into a T/F query either by binding ?output's or by\nwrapping an EXISTS around this.  Result coercion is performed based on\nthe types of the ?output variables.")))), Cons.cons(RDBMS.KWD_VARIABLE_ARITY, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_STELLA_TRUE))), Cons.cons(RDBMS.KWD_RELATION_SPECIALIST, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_QUERY_SQL_DATABASE_SPECIALIST))), Stella.NIL)))))))));
              Logic.renamed_Assert(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((COMPUTED-PROCEDURE QUERY-DATABASE-SPECIALIST) \"/RDBMS\")", "/RDBMS")))));
              Logic.defrelation(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_QUERY_DATABASE))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?DATABASE DATABASE) (?QUERY STRING) ?OUTPUT) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("Run the relational ?query against ?database and bind\none or more ?output arguments to the columns in the resulting tuples.\nIf there are more result columns than ?output variables, they will be\nignored.  If there are fewer, that's ok as long as the remaining ?output's\nhad initial bindings.  Initial bindings can be used to instantiate\na parametric ?query template with them (e.g., for SQL queries).  Initial\nbindings have to match result columns except for collection-valued bindings.\nThis can be turned into a T/F query either by binding ?output's or by\nwrapping an EXISTS around this.  Result coercion is performed based on\nthe types of the ?output variables.  For known database types such\nas `RDBMS/SQL-Database' this dispatches to the appropriate specialist.\nOtherwise, this relation serves as a top-level interface that can be\nlinked to other database query interfaces via appropriate rules.")))), Cons.cons(RDBMS.KWD_VARIABLE_ARITY, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_STELLA_TRUE))), Cons.cons(RDBMS.KWD_RELATION_SPECIALIST, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_QUERY_DATABASE_SPECIALIST))), Stella.NIL)))))))));
              Logic.defconcept(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_FETCH_EDB_DATABASE))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((DATABASE) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("A database that supports EELD EDB database access via Fetch HTTP wrappers.")))), Stella.NIL)))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_TASK_ID))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?DB FETCH-EDB-DATABASE)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD__g, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?ID STRING) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The task-id used for each access to ?db.")))), Cons.cons(RDBMS.KWD_GOES_TRUE_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Cons.cons(RDBMS.KWD_GOES_UNKNOWN_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Stella.NIL)))))))))));
              Logic.deffunction(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_SUBTASK_ID))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?DB FETCH-EDB-DATABASE)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD__g, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?ID STRING) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("The subtask-id used for each access to ?db.")))), Cons.cons(RDBMS.KWD_GOES_TRUE_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Cons.cons(RDBMS.KWD_GOES_UNKNOWN_DEMON, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_DB_UPDATE_DEMON))), Stella.NIL)))))))))));
              Logic.renamed_Assert(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((COMPUTED-PROCEDURE FETCH-EDB-QUERY) \"/RDBMS\")", "/RDBMS")))));
              Logic.renamed_Assert(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((AND (DOCUMENTATION FETCH-EDB-QUERY \"Generic query evaluator that can handle EELD EDB\nqueries via the Fetch HTTP/XML interface.\") (QUERY-EVALUATOR FETCH-EDB-QUERY) (SUPPORTS-DB-TYPE FETCH-EDB-QUERY FETCH-EDB-DATABASE)) \"/RDBMS\")", "/RDBMS")))));
              Logic.defconcept(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_FETCH_QUERY))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?C) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_CLOSED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_STELLA_TRUE))), Stella.NIL)))));
              Logic.defconcept(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_FETCH_QUERY_TYPE_1))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?C FETCH-QUERY) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_CLOSED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_STELLA_TRUE))), Stella.NIL)))));
              Logic.defconcept(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_FETCH_QUERY_TYPE_2))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((?C FETCH-QUERY) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_CLOSED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_STELLA_TRUE))), Stella.NIL)))));
              Logic.defrelation(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_QUERY_TABLE_NAME))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?Q FETCH-QUERY) (?N STRING)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("Database table referenced by this query.  The current set\nof queries each reference only one DB table, but this is a relation\nto allow for future expansion.")))), Cons.cons(RDBMS.KWD_CLOSED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_STELLA_TRUE))), Stella.NIL)))))));
              Logic.defrelation(Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_RDBMS_QUERY_PARAMETER_NAME))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?Q FETCH-QUERY) (?N STRING)) \"/RDBMS\")", "/RDBMS")))), Cons.cons(RDBMS.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("Parameter name that needs to be set by this query.  The current set\nof queries each take only a single parameter, but this is a relation\nto allow for future expansion.  TO DO:  Figure out if this should be\na three-place relation that also has a type (concept) entry to identify\nwhat sort of value the parameter takes on.")))), Cons.cons(RDBMS.KWD_CLOSED, Cons.cons(((Symbol)(Stella_Object.copyConsTree(RDBMS.SYM_STELLA_TRUE))), Stella.NIL)))))));
              Logic.renamed_Assert(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((DISJOINT FETCH-QUERY-TYPE-1 FETCH-QUERY-TYPE-2) \"/RDBMS\")", "/RDBMS")))));

            } finally {
              Stella.$CONTEXT$.set(old$Context$001);
              Stella.$MODULE$.set(old$Module$001);
            }
          }
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
