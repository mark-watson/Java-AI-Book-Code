//  -*- Mode: Java -*-
//
// _StartupRdbms.java

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

public class _StartupRdbms {
  static void helpStartupRdbms1() {
    {
      RDBMS.SYM_RDBMS_DEFUNTABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFUNTABLE", null, 0)));
      RDBMS.SYM_PL_KERNEL_KB_RELATION_SPECIALIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION-SPECIALIST", Stella.getStellaModule("/PL-KERNEL-KB", true), 0)));
      RDBMS.SYM_RDBMS_DBTABLE_SPECIALIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DBTABLE-SPECIALIST", null, 0)));
      RDBMS.SYM_RDBMS_DEFTABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFTABLE", null, 0)));
      RDBMS.SGT_STELLA_CONS = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONS", Stella.getStellaModule("/STELLA", true), 1)));
      RDBMS.KWD_ERROR = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ERROR", null, 2)));
      RDBMS.KWD_NAME = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NAME", null, 2)));
      RDBMS.KWD_VARIABLE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE", null, 2)));
      RDBMS.KWD_TYPE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TYPE", null, 2)));
      RDBMS.KWD_MODULE_NAME = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE-NAME", null, 2)));
      RDBMS.KWD_MODULE_REFERENCE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE-REFERENCE", null, 2)));
      RDBMS.SYM_RDBMS_DEFDB = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFDB", null, 0)));
      RDBMS.KWD_CONNECTION_STRING = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONNECTION-STRING", null, 2)));
      RDBMS.SGT_STELLA_STRING = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("STRING", Stella.getStellaModule("/STELLA", true), 1)));
      RDBMS.KWD_JDBC_CONNECTION_STRING = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("JDBC-CONNECTION-STRING", null, 2)));
      RDBMS.KWD_ODBC_CONNECTION_STRING = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ODBC-CONNECTION-STRING", null, 2)));
      RDBMS.KWD_DSN = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DSN", null, 2)));
      RDBMS.KWD_DB = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DB", null, 2)));
      RDBMS.KWD_HOST = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("HOST", null, 2)));
      RDBMS.KWD_PORT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PORT", null, 2)));
      RDBMS.SGT_STELLA_INTEGER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INTEGER", Stella.getStellaModule("/STELLA", true), 1)));
      RDBMS.KWD_USER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("USER", null, 2)));
      RDBMS.KWD_PASSWORD = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PASSWORD", null, 2)));
      RDBMS.KWD_MODULE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE", null, 2)));
      RDBMS.SGT_STELLA_MODULE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE", Stella.getStellaModule("/STELLA", true), 1)));
      RDBMS.KWD_CONFIGURATION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONFIGURATION", null, 2)));
      RDBMS.SGT_STELLA_CONFIGURATION_TABLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONFIGURATION-TABLE", Stella.getStellaModule("/STELLA", true), 1)));
      RDBMS.KWD_DB_NAME = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DB-NAME", null, 2)));
      RDBMS.SYM_RDBMS_DEFQUERY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFQUERY", null, 0)));
      RDBMS.SYM_RDBMS_QUERY_SPECIALIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("QUERY-SPECIALIST", null, 0)));
      RDBMS.SGT_RDBMS_CONNECTION_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONNECTION-WRAPPER", null, 1)));
      RDBMS.SYM_STELLA_WRAPPER_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WRAPPER-VALUE", Stella.getStellaModule("/STELLA", true), 0)));
      RDBMS.SGT_LOGIC_LOGIC_OBJECT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("LOGIC-OBJECT", Stella.getStellaModule("/LOGIC", true), 1)));
      RDBMS.SGT_RDBMS_PROTOCOL = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PROTOCOL", null, 1)));
      RDBMS.SGT_RDBMS_SERVER_TYPE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SERVER-TYPE", null, 1)));
      RDBMS.SGT_RDBMS_HOST = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("HOST", null, 1)));
      RDBMS.SGT_RDBMS_PORT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PORT", null, 1)));
      RDBMS.SGT_RDBMS_USER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("USER", null, 1)));
      RDBMS.SGT_RDBMS_PASSWORD = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PASSWORD", null, 1)));
      RDBMS.SGT_RDBMS_DB_NAME = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DB-NAME", null, 1)));
      RDBMS.SGT_RDBMS_JDBC_CONNECTION_STRING = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("JDBC-CONNECTION-STRING", null, 1)));
      RDBMS.SGT_RDBMS_CONNECTION_STRING = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONNECTION-STRING", null, 1)));
      RDBMS.SGT_RDBMS_DSN = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DSN", null, 1)));
      RDBMS.KWD_PROTOCOL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PROTOCOL", null, 2)));
      RDBMS.KWD_SERVER_TYPE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SERVER-TYPE", null, 2)));
      RDBMS.SGT_RDBMS_DB_CONNECTION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DB-CONNECTION", null, 1)));
      RDBMS.SGT_RDBMS_RELATION_DATABASE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION-DATABASE", null, 1)));
      RDBMS.SYM_LOGIC_pX = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X", Stella.getStellaModule("/LOGIC", true), 0)));
      RDBMS.SGT_RDBMS_RELATION_TABLE_INFO = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION-TABLE-INFO", null, 1)));
      RDBMS.SYM_STELLA_RELATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION", Stella.getStellaModule("/STELLA", true), 0)));
      RDBMS.SYM_RDBMS_DBMS_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DBMS-NAME", null, 0)));
      RDBMS.SYM_STELLA_TABLE_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TABLE-NAME", Stella.getStellaModule("/STELLA", true), 0)));
      RDBMS.SYM_RDBMS_TABLE_ALIAS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TABLE-ALIAS", null, 0)));
      RDBMS.SYM_RDBMS_COLUMN_LIST = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COLUMN-LIST", null, 0)));
      RDBMS.SYM_RDBMS_COLUMN_VECTOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COLUMN-VECTOR", null, 0)));
      RDBMS.SYM_RDBMS_COLUMN_INDEX = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COLUMN-INDEX", null, 0)));
      RDBMS.SYM_RDBMS_ADJUNCT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ADJUNCT", null, 0)));
      RDBMS.SGT_RDBMS_RELATION_COLUMN_INFO = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION-COLUMN-INFO", null, 1)));
      RDBMS.SYM_RDBMS_TABLE_INFO = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TABLE-INFO", null, 0)));
      RDBMS.SYM_RDBMS_COLUMN_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COLUMN-NAME", null, 0)));
    }
  }

  static void helpStartupRdbms2() {
    {
      RDBMS.SYM_RDBMS_COLUMN_VARIABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COLUMN-VARIABLE", null, 0)));
      RDBMS.SYM_RDBMS_COLUMN_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COLUMN-TYPE", null, 0)));
      RDBMS.SYM_RDBMS_COLUMN_DB_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COLUMN-DB-TYPE", null, 0)));
      RDBMS.SYM_STELLA_MODULE_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE-NAME", Stella.getStellaModule("/STELLA", true), 0)));
      RDBMS.SYM_RDBMS_MODULE_REFERENCE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE-REFERENCE", null, 0)));
      RDBMS.SYM_STELLA_MODULE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE", Stella.getStellaModule("/STELLA", true), 0)));
      RDBMS.SYM_RDBMS_MODULE_LOCALp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE-LOCAL?", null, 0)));
      RDBMS.SYM_RDBMS_MODULE_REFERENCE_COLUMN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE-REFERENCE-COLUMN", null, 0)));
      RDBMS.SYM_RDBMS_COERCION_FUNCTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COERCION-FUNCTION", null, 0)));
      RDBMS.KWD_UNKNOWN = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("UNKNOWN", null, 2)));
      RDBMS.SGT_RDBMS_RELATION_TABLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION-TABLE", null, 1)));
      RDBMS.SGT_RDBMS_F_GET_RELATION_TABLE_INFO_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-GET-RELATION-TABLE-INFO-MEMO-TABLE-000", null, 1)));
      RDBMS.KWD_STRING_CONSTANT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("STRING-CONSTANT", null, 2)));
      RDBMS.SGT_STELLA_NUMBER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("NUMBER", Stella.getStellaModule("/STELLA", true), 1)));
      RDBMS.SGT_STELLA_BOOLEAN = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("BOOLEAN", Stella.getStellaModule("/STELLA", true), 1)));
      RDBMS.KWD_MYSQL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MYSQL", null, 2)));
      RDBMS.SGT_STELLA_STRING_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("STRING-WRAPPER", Stella.getStellaModule("/STELLA", true), 1)));
      RDBMS.SYM_STELLA_ITERATOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ITERATOR", Stella.getStellaModule("/STELLA", true), 0)));
      RDBMS.SGT_RDBMS_DATABASE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DATABASE", null, 1)));
      RDBMS.SGT_RDBMS_F_ALLOCATE_DBTABLE_SPECIALIST_ITERATOR_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-ALLOCATE-DBTABLE-SPECIALIST-ITERATOR-MEMO-TABLE-000", null, 1)));
      RDBMS.KWD_FAILURE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FAILURE", null, 2)));
      RDBMS.KWD_DB_LOOKUP = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DB-LOOKUP", null, 2)));
      RDBMS.KWD_CONTINUING_SUCCESS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONTINUING-SUCCESS", null, 2)));
      RDBMS.KWD_FINAL_SUCCESS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FINAL-SUCCESS", null, 2)));
      RDBMS.KWD_TECHNICAL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TECHNICAL", null, 2)));
      RDBMS.KWD_LAY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LAY", null, 2)));
      RDBMS.SYM_RDBMS_pREL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?REL", null, 0)));
      RDBMS.SYM_RDBMS_pEV = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?EV", null, 0)));
      RDBMS.SYM_RDBMS_pDB = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?DB", null, 0)));
      RDBMS.SYM_RDBMS_pARGS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?ARGS", null, 0)));
      RDBMS.SYM_STELLA_AND = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("AND", Stella.getStellaModule("/STELLA", true), 0)));
      RDBMS.SYM_STELLA_EXISTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EXISTS", Stella.getStellaModule("/STELLA", true), 0)));
      RDBMS.SYM_RDBMS_pDB_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?DB-TYPE", null, 0)));
      RDBMS.SYM_RDBMS_INSTANCE_OF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INSTANCE-OF", null, 0)));
      RDBMS.KWD_DONT_OPTIMIZEp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DONT-OPTIMIZE?", null, 2)));
      RDBMS.KWD_HOW_MANY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("HOW-MANY", null, 2)));
      RDBMS.KWD_ALL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ALL", null, 2)));
      RDBMS.KWD_INFERENCE_LEVEL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INFERENCE-LEVEL", null, 2)));
      RDBMS.KWD_ASSERTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ASSERTION", null, 2)));
      RDBMS.SYM_RDBMS_F_GET_QUERY_PATTERN_EVALUATORS_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("F-GET-QUERY-PATTERN-EVALUATORS-QUERY-000", null, 0)));
      RDBMS.SGT_RDBMS_F_GET_QUERY_PATTERN_EVALUATORS_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-GET-QUERY-PATTERN-EVALUATORS-MEMO-TABLE-000", null, 1)));
      RDBMS.SYM_RDBMS_F_GET_QUERY_PATTERN_EVALUATORS_QUERY_001 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("F-GET-QUERY-PATTERN-EVALUATORS-QUERY-001", null, 0)));
      RDBMS.SGT_RDBMS_F_SQL_JOIN_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-SQL-JOIN-MEMO-TABLE-000", null, 1)));
      RDBMS.KWD_VALUE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("VALUE", null, 2)));
      RDBMS.KWD_WHITE_SPACE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("WHITE-SPACE", null, 2)));
      RDBMS.KWD_SET = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SET", null, 2)));
      RDBMS.KWD_NONE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NONE", null, 2)));
      RDBMS.SGT_RDBMS_F_SQL_QUERY_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-SQL-QUERY-MEMO-TABLE-000", null, 1)));
      RDBMS.KWD_TERMINAL_FAILURE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TERMINAL-FAILURE", null, 2)));
      RDBMS.SGT_RDBMS_SQL_DATABASE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("SQL-DATABASE", null, 1)));
      RDBMS.KWD_EXTERNAL_DB_UPDATE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("EXTERNAL-DB-UPDATE", null, 2)));
      RDBMS.SGT_LOGIC_NAMED_DESCRIPTION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("NAMED-DESCRIPTION", Stella.getStellaModule("/LOGIC", true), 1)));
      RDBMS.SGT_STELLA_TRUE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TRUE", Stella.getStellaModule("/STELLA", true), 1)));
      RDBMS.SGT_STELLA_FALSE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FALSE", Stella.getStellaModule("/STELLA", true), 1)));
      RDBMS.SGT_STELLA_THING = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("THING", Stella.getStellaModule("/STELLA", true), 1)));
      RDBMS.KWD_CLIP = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CLIP", null, 2)));
      RDBMS.KWD_ASSERT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ASSERT", null, 2)));
      RDBMS.KWD_RETRACT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("RETRACT", null, 2)));
      RDBMS.KWD_ASSERT_TRUE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ASSERT-TRUE", null, 2)));
      RDBMS.KWD_PRESUME_TRUE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PRESUME-TRUE", null, 2)));
    }
  }

  static void helpStartupRdbms3() {
    {
      Stella.defineFunctionObject("DEFUNTABLE", "(DEFUN (DEFUNTABLE LOGIC-OBJECT) (|&REST| (ARGS PARSE-TREE)) :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Define (or redefine) a database table and map it to a function\nThe accepted syntax is:\n	 \n (defuntable <relconst> <dbconst> <tablename> (<columndecl>+)\n    [<keyword-option>*]).\n\n<columndecl>'s specify the names (and optionally types) of the columns\nof the database table.  They have the same form as a PowerLoom <vardecl>, but\ncolumn names can be specified with or without question marks.  If there\nis a question mark it will be stripped to determine the column name, otherwise\na question mark will be added to generate the relation variable.  The optional\ntype specifies the domain of that argument and controls any necessary coercion.\nThe name of each column HAS TO MATCH one of the columns of <tablename>, however,\nthe order is irrelevant and arbitrary projections can be defined by only\nspecifying some subset of <tablename>'s columns.\n\nSee `deffunction' for legal keyword options.\n\")", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "defuntable", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "defuntableEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("CALL-DEFUNTABLE", "(DEFUN (CALL-DEFUNTABLE NAMED-DESCRIPTION) ((ARGUMENTS CONS)) :DOCUMENTATION \"Callable version of the `deftable' command (which see).\nExpects the same arguments as `deftable' but supplied as a list.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "callDefuntable", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("DEFTABLE", "(DEFUN (DEFTABLE LOGIC-OBJECT) (|&REST| (ARGS PARSE-TREE)) :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Define (or redefine) a database table and map it to a relation.\nThe accepted syntax is:\n	 \n (deftable <relconst> <dbconst> <tablename> (<columndecl>+)\n    [<keyword-option>*]).\n	\n<columndecl>'s specify the names (and optionally types) of the columns\nof the database table.  They have the same form as a PowerLoom <vardecl>, but\ncolumn names can be specified with or without question marks.  If there\nis a question mark it will be stripped to determine the column name, otherwise\na question mark will be added to generate the relation variable.  The optional\ntype specifies the domain of that argument and controls any necessary coercion.\nThe name of each column HAS TO MATCH one of the columns of <tablename>, however,\nthe order is irrelevant and arbitrary projections can be defined by only\nspecifying some subset of <tablename>'s columns.\n\nSee `defrelation' for legal keyword options.\n\")", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "deftable", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "deftableEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("CALL-DEFTABLE", "(DEFUN (CALL-DEFTABLE NAMED-DESCRIPTION) ((ARGUMENTS CONS)) :DOCUMENTATION \"Callable version of the `deftable' command (which see).\nExpects the same arguments as `deftable' but supplied as a list.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "callDeftable", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("PARSE-ONE-COLUMN-SPEC", "(DEFUN (PARSE-ONE-COLUMN-SPEC PROPERTY-LIST) ((COLUMNSPEC OBJECT)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "parseOneColumnSpec", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("PARSE-COLUMN-SPECS", "(DEFUN (PARSE-COLUMN-SPECS CONS CONS) ((RELCONST OBJECT) (COLUMNSPECS OBJECT)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "parseColumnSpecs", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("DEFDB", "(DEFUN (DEFDB LOGIC-OBJECT) (|&REST| (ARGS PARSE-TREE)) :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Define (or redefine) a database instance.  The accepted syntax is:\n	 \n (defdb <dbconst>\n    [:protocol <protocol string>]\n    [:server-type <server type string>]\n    [:dsn <ODBC data-source name string>]\n    [:odbc-connection-string <ODBC connection string>]\n    [:jdbc-connection-string <JDBC connection string>]\n    [:connection-string <connection string>] ;; deprecated\n    [:host <server host string>]\n    [:port <server host port>]\n    [:user <user name string>]\n    [:password <password string>]\n    [:db-name <database name string>]\n    [<keyword-option>*])\n	\nConnection information can be asserted explicitly later or be done\nprogrammatically, as long as it is done before the first time a\nconnection attempt is made (e.g., during a query).  This information\nis passed to `SDBC/connect' (which see for more documentation on\nways to specify a connection).  For example, for ODBC a :DSN, an\n:ODBC-CONNECTION-STRING or an appropriate combination of :HOST,\n:PORT, :USER, :PASSWORD AND :DB-NAME can be used.  For JDBC a\n:JDBC-CONNECTION-STRING or combination of :HOST, :PORT, etc. can\nbe used.  See `defobject' for additional legal keyword options.\n\")", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "defdb", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "defdbEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("CALL-DEFDB", "(DEFUN (CALL-DEFDB LOGIC-OBJECT) ((ARGUMENTS CONS)) :DOCUMENTATION \"Callable version of of the `defdb' command (which see).\nExpects the same arguments as `defdb' but supplied as a list.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "callDefdb", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("EXTRACT-RDBMS-OPTIONS", "(DEFUN (EXTRACT-RDBMS-OPTIONS CONS CONS) ((SELFNAME SYMBOL) (OPTIONS CONS)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "extractRdbmsOptions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("ASSERT-RDBMS-CONNECTION-INFO", "(DEFUN ASSERT-RDBMS-CONNECTION-INFO ((DB-INSTANCE-NAME STRING) |&REST| (OPTIONS OBJECT)) :DOCUMENTATION \"Assert DB connectivity information about the DB instance `db-instance-name' (for\nexample, \\\"edb\\\") according to `options'.  Looks up `db-instance-name' in the module\nspecified by the :module option (defaults to current module) and retracts any\npreexisting connection information.  New assertions are also made in that module.\nDefault values are taken from the configuration table specified by :configuration.\n\nUnderstands the following options, with default values specified by the configuration\nkey in parentheses:\n   :connection-string (\\\"DBConnection\\\"),\n   :jdbc-connection-string (\\\"JDBCString\\\"),\n   :odbc-connection-string (\\\"ODBCString\\\"),\n   :dsn (\\\"DSN\\\"),\n   :db (\\\"DBName\\\"),\n   :host (\\\"DBHost\\\"),\n   :port (\\\"DBPort\\\"),\n   :user (\\\"DBUser\\\"),\n   :password (\\\"DBPassword\\\"),\n   :module,\n   :configuration.\" :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "assertRdbmsConnectionInfo", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "assertRdbmsConnectionInfoEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("DEFQUERY", "(DEFUN (DEFQUERY LOGIC-OBJECT) (|&REST| (ARGS PARSE-TREE)) :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Define (or redefine) an (external) query and map it to a relation.\nThe accepted syntax is:\n	 \n (defquery <relconst> (<vardecl>+)\n    {:query-pattern (<query-evaluator> <dbconst> <arguments-string>)}*\n    [<keyword-option>*]).\n	\n<query-evaluator> has to be a `Computed-Procedure' that takes the following\nthree arguments: the <relconst> query proposition, the database object <dbconst>\nand the arguments string.  It needs to return an iterator that generates CONS\ntuples whose elements will be bound in sequence to <relconst>'s arguments.\n\nSee `defrelation' for other legal keyword options.\n\")", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "defquery", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "defqueryEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("CALL-DEFQUERY", "(DEFUN (CALL-DEFQUERY NAMED-DESCRIPTION) ((ARGUMENTS CONS)) :DOCUMENTATION \"Callable version of the `defquery' command (which see).\nExpects the same arguments as `deftable' but supplied as a list.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "callDefquery", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("NORMALIZE-CONNECTION-ARGUMENT", "(DEFUN (NORMALIZE-CONNECTION-ARGUMENT STRING-WRAPPER) ((ARG OBJECT)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "normalizeConnectionArgument", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CONNECT-TO-DATABASE", "(DEFUN (CONNECT-TO-DATABASE /SDBC/CONNECTION) ((DATABASE LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "connectToDatabase", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("DISCONNECT-FROM-DATABASE", "(DEFUN DISCONNECT-FROM-DATABASE ((DATABASE LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "disconnectFromDatabase", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("GET-CONNECTION-FROM-DATABASE", "(DEFUN (GET-CONNECTION-FROM-DATABASE /SDBC/CONNECTION) ((DATABASE LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "getConnectionFromDatabase", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("GET-CONNECTION-FROM-PREDICATE", "(DEFUN (GET-CONNECTION-FROM-PREDICATE /SDBC/CONNECTION) ((RELATIONREF SURROGATE)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "getConnectionFromPredicate", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("ALLOCATE-RESULT-SET-ITERATOR", "(DEFUN (ALLOCATE-RESULT-SET-ITERATOR (ITERATOR OF CONS)) ((CONNECTION /SDBC/CONNECTION) (RELATION LOGIC-OBJECT) (SQLSTATEMENT STRING)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "allocateResultSetIterator", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.Connection"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("RESULT-SET-ITERATOR-NEXT?", "(DEFUN (RESULT-SET-ITERATOR-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "resultSetIteratorNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("GET-TABLE-RELATION", "(DEFUN (GET-TABLE-RELATION NAMED-DESCRIPTION) ((TABLE-NAME STRING) (MODULE MODULE)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "getTableRelation", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("GET-TABLE-COLUMN-INDEX", "(DEFUN (GET-TABLE-COLUMN-INDEX INTEGER) ((TABLE-RELATION NAMED-DESCRIPTION) (COLUMN-NAME STRING) (MODULE MODULE)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "getTableColumnIndex", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("GET-TABLE-COLUMN-MODULE-NAME", "(DEFUN (GET-TABLE-COLUMN-MODULE-NAME STRING-WRAPPER) ((TABLERELATION NAMED-DESCRIPTION) (COLUMNINDEX INTEGER)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "getTableColumnModuleName", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("GET-TABLE-COLUMN-MODULE-REFERENCE", "(DEFUN (GET-TABLE-COLUMN-MODULE-REFERENCE STRING-WRAPPER) ((TABLERELATION NAMED-DESCRIPTION) (COLUMNINDEX INTEGER)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "getTableColumnModuleReference", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("GET-TABLE-COLUMN-NAME", "(DEFUN (GET-TABLE-COLUMN-NAME STRING-WRAPPER) ((TABLERELATION NAMED-DESCRIPTION) (COLUMNINDEX INTEGER)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "getTableColumnName", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("GET-TABLE-COLUMN-NAMES", "(DEFUN (GET-TABLE-COLUMN-NAMES (CONS OF STRING-WRAPPER)) ((TABLERELATION NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "getTableColumnNames", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("CREATE-RELATION-TABLE-INFO", "(DEFUN (CREATE-RELATION-TABLE-INFO RELATION-TABLE-INFO) ((RELATION NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "createRelationTableInfo", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("GET-MODULE-USING-REFERENCE", "(DEFUN (GET-MODULE-USING-REFERENCE MODULE) ((COLUMN RELATION-COLUMN-INFO) (VALUES CONS)))", Native.find_java_method("edu.isi.powerloom.rdbms.RelationColumnInfo", "getModuleUsingReference", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.rdbms.RelationColumnInfo"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("GET-RELATION-TABLE-INFO", "(DEFUN (GET-RELATION-TABLE-INFO RELATION-TABLE-INFO) ((TABLERELATION NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "getRelationTableInfo", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("COLLECTION-VALUED-CONSTRAINT?", "(DEFUN (COLLECTION-VALUED-CONSTRAINT? BOOLEAN) ((ARGUMENT OBJECT)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "collectionValuedConstraintP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("COLLECTION-VALUED-CONSTRAINT-ELEMENTS", "(DEFUN (COLLECTION-VALUED-CONSTRAINT-ELEMENTS CONS) ((ARGUMENT OBJECT)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "collectionValuedConstraintElements", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("PRINT-SQL-VALUE", "(DEFUN PRINT-SQL-VALUE ((STREAM OUTPUT-STREAM) (VALUE OBJECT) (COLUMN RELATION-COLUMN-INFO)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "printSqlValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.powerloom.rdbms.RelationColumnInfo")}), null);
      Stella.defineFunctionObject("PRINT-COLUMN-CONSTRAINT", "(DEFUN PRINT-COLUMN-CONSTRAINT ((SQL OUTPUT-STREAM) (COLUMN RELATION-COLUMN-INFO) (VALUE STRING) (CASESENSITIVE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "printColumnConstraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.powerloom.rdbms.RelationColumnInfo"), Native.find_java_class("java.lang.String"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("PRINT-ARGUMENT-CONSTRAINT", "(DEFUN PRINT-ARGUMENT-CONSTRAINT ((SQL OUTPUT-STREAM) (ARGUMENT OBJECT) (COLUMN RELATION-COLUMN-INFO)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "printArgumentConstraint", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.powerloom.rdbms.RelationColumnInfo")}), null);
      Stella.defineFunctionObject("PRINT-SQL-COLUMN-LIST", "(DEFUN PRINT-SQL-COLUMN-LIST ((STREAM OUTPUT-STREAM) (TABLE-INFO RELATION-TABLE-INFO)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "printSqlColumnList", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.powerloom.rdbms.RelationTableInfo")}), null);
      Stella.defineFunctionObject("PRINT-SQL-CONSTRAINT-LIST", "(DEFUN PRINT-SQL-CONSTRAINT-LIST ((STREAM OUTPUT-STREAM) (TABLE-INFO RELATION-TABLE-INFO) (ARGUMENTS VECTOR)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "printSqlConstraintList", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.powerloom.rdbms.RelationTableInfo"), Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("CREATE-SQL-FROM-PROPOSITION", "(DEFUN (CREATE-SQL-FROM-PROPOSITION STRING) ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "createSqlFromProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("ALLOCATE-DBTABLE-SPECIALIST-ITERATOR", "(DEFUN (ALLOCATE-DBTABLE-SPECIALIST-ITERATOR (ITERATOR OF CONS)) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "allocateDbtableSpecialistIterator", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("RETRIEVE-NEXT-DB-QUERY-SOLUTION", "(DEFUN (RETRIEVE-NEXT-DB-QUERY-SOLUTION KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "retrieveNextDbQuerySolution", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("DBTABLE-SPECIALIST", "(DEFUN (DBTABLE-SPECIALIST KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "dbtableSpecialist", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("GET-QUERY-PATTERN-EVALUATORS", "(DEFUN (GET-QUERY-PATTERN-EVALUATORS (CONS OF CONS)) ((RELATIONREF SURROGATE)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "getQueryPatternEvaluators", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("NORMALIZE-SQL-JOIN-ARGUMENTS", "(DEFUN (NORMALIZE-SQL-JOIN-ARGUMENTS CONS CONS) ((TABLEINFO RELATION-TABLE-INFO) (ARGUMENTS OBJECT)))", Native.find_java_method("edu.isi.powerloom.rdbms.RelationTableInfo", "normalizeSqlJoinArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.rdbms.RelationTableInfo"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("HELP-MEMOIZE-SQL-JOIN", "(DEFUN (HELP-MEMOIZE-SQL-JOIN (ITERATOR OF CONS)) ((PROPOSITION PROPOSITION) (DATABASE LOGIC-OBJECT) (ARGUMENTS OBJECT)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "helpMemoizeSqlJoin", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SQL-JOIN", "(DEFUN (SQL-JOIN (ITERATOR OF CONS)) ((PROPOSITION PROPOSITION) (DATABASE LOGIC-OBJECT) (ARGUMENTS OBJECT)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "sqlJoin", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("COLLECT-VARIABLE-BINDING", "(DEFUN COLLECT-VARIABLE-BINDING ((NAME STRING) (TYPE OBJECT) (BINDING OBJECT) (BINDINGS (KEY-VALUE-LIST OF STRING-WRAPPER OBJECT))))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "collectVariableBinding", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
      Stella.defineFunctionObject("CREATE-SQL-QUERY-FROM-PROPOSITION", "(DEFUN (CREATE-SQL-QUERY-FROM-PROPOSITION STRING) ((PROPOSITION PROPOSITION) (DATABASE LOGIC-OBJECT) (ARGUMENTS OBJECT)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "createSqlQueryFromProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("HELP-MEMOIZE-SQL-QUERY", "(DEFUN (HELP-MEMOIZE-SQL-QUERY (ITERATOR OF CONS)) ((PROPOSITION PROPOSITION) (DATABASE LOGIC-OBJECT) (ARGUMENTS OBJECT)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "helpMemoizeSqlQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SQL-QUERY-INSTANTIATE-CONSTRAINTS", "(DEFUN (SQL-QUERY-INSTANTIATE-CONSTRAINTS STRING) ((SQL STRING) (BINDINGS (KEY-VALUE-LIST OF STRING-WRAPPER OBJECT))))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "sqlQueryInstantiateConstraints", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
      Stella.defineFunctionObject("SQL-QUERY", "(DEFUN (SQL-QUERY (ITERATOR OF CONS)) ((PROPOSITION PROPOSITION) (DATABASE LOGIC-OBJECT) (ARGUMENTS OBJECT)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "sqlQuery", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("ALLOCATE-QUERY-SPECIALIST-ITERATOR", "(DEFUN (ALLOCATE-QUERY-SPECIALIST-ITERATOR (ITERATOR OF CONS)) ((FRAME CONTROL-FRAME)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "allocateQuerySpecialistIterator", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame")}), null);
      Stella.defineFunctionObject("QUERY-SPECIALIST", "(DEFUN (QUERY-SPECIALIST KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "querySpecialist", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("COLLECT-QUERY-DATABASE-SPECIALIST-BINDINGS", "(DEFUN (COLLECT-QUERY-DATABASE-SPECIALIST-BINDINGS (KEY-VALUE-LIST OF STRING-WRAPPER OBJECT)) ((FRAME CONTROL-FRAME) (FIRSTARGINDEX INTEGER)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "collectQueryDatabaseSpecialistBindings", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("BIND-NEXT-DATABASE-TUPLE-TO-ARGUMENTS", "(DEFUN (BIND-NEXT-DATABASE-TUPLE-TO-ARGUMENTS KEYWORD) ((FRAME CONTROL-FRAME) (FIRSTARGINDEX INTEGER)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "bindNextDatabaseTupleToArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("QUERY-SQL-DATABASE-SPECIALIST", "(DEFUN (QUERY-SQL-DATABASE-SPECIALIST KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "querySqlDatabaseSpecialist", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("QUERY-DATABASE-SPECIALIST", "(DEFUN (QUERY-DATABASE-SPECIALIST KEYWORD) ((FRAME CONTROL-FRAME) (LASTMOVE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "queryDatabaseSpecialist", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.ControlFrame"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("DB-UPDATE-DEMON", "(DEFUN DB-UPDATE-DEMON ((DBPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "dbUpdateDemon", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("CHECK-FOR-EXTERNAL-DB-UPDATES", "(DEFUN CHECK-FOR-EXTERNAL-DB-UPDATES ((PROPOSITION PROPOSITION) (DATABASE LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "checkForExternalDbUpdates", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("GET-QUERY-PATTERN-MEMOIZATION-KEY", "(DEFUN (GET-QUERY-PATTERN-MEMOIZATION-KEY OBJECT) ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "getQueryPatternMemoizationKey", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("COERCE-VALUES", "(DEFUN (COERCE-VALUES (CONS OF OBJECT)) ((VALUES (CONS OF STRING-WRAPPER)) (TABLE RELATION-TABLE-INFO)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "coerceValues", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.powerloom.rdbms.RelationTableInfo")}), null);
      Stella.defineFunctionObject("COERCE-STRING-TO-POWERLOOM-OBJECT", "(DEFUN (COERCE-STRING-TO-POWERLOOM-OBJECT OBJECT) ((VALUE STRING) (TYPE NAMED-DESCRIPTION) (MODULE MODULE) (LOCAL? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "coerceStringToPowerloomObject", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("NUMBER-STRING-TO-INTEGER", "(DEFUN (NUMBER-STRING-TO-INTEGER INTEGER) ((X STRING)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "numberStringToInteger", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
    }
  }

  public static void startupRdbms() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/RDBMS", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupRdbms.helpStartupRdbms1();
          _StartupRdbms.helpStartupRdbms2();
          RDBMS.KWD_RETRACT_TRUE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("RETRACT-TRUE", null, 2)));
          RDBMS.KWD_RETRACT_FALSE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("RETRACT-FALSE", null, 2)));
          RDBMS.KWD_ASSERT_FALSE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ASSERT-FALSE", null, 2)));
          RDBMS.KWD_PRESUME_FALSE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PRESUME-FALSE", null, 2)));
          RDBMS.KWD_CONCEIVE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONCEIVE", null, 2)));
          RDBMS.SYM_RDBMS_STARTUP_RDBMS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-RDBMS", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CONNECTION-WRAPPER", "(DEFCLASS CONNECTION-WRAPPER (LOGIC-THING) :PUBLIC-SLOTS ((WRAPPER-VALUE :TYPE /SDBC/CONNECTION)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.rdbms.ConnectionWrapper", "newConnectionWrapper", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.rdbms.ConnectionWrapper", "accessConnectionWrapperSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.rdbms.ConnectionWrapper"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("RELATION-TABLE-INFO", "(DEFCLASS RELATION-TABLE-INFO (STANDARD-OBJECT) :DOCUMENTATION \"Data structure that associates a PowerLoom relation representing\na database table or query with various information about its columns, value coercion, etc.\" :PUBLIC-SLOTS ((RELATION :TYPE NAMED-DESCRIPTION) (DATABASE :TYPE OBJECT) (DBMS-NAME :TYPE KEYWORD) (TABLE-NAME :TYPE STRING) (TABLE-ALIAS :TYPE STRING :INITIALLY \"_T\") (COLUMN-LIST :TYPE (CONS OF RELATION-COLUMN-INFO)) (COLUMN-VECTOR :TYPE (VECTOR OF RELATION-COLUMN-INFO)) (COLUMN-INDEX :TYPE (KEY-VALUE-MAP OF OBJECT RELATION-COLUMN-INFO)) (ADJUNCT :TYPE OBJECT)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.rdbms.RelationTableInfo", "newRelationTableInfo", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.rdbms.RelationTableInfo", "accessRelationTableInfoSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.rdbms.RelationTableInfo"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("RELATION-COLUMN-INFO", "(DEFCLASS RELATION-COLUMN-INFO (STANDARD-OBJECT) :PUBLIC-SLOTS ((TABLE-INFO :TYPE RELATION-TABLE-INFO) (COLUMN-NAME :TYPE STRING) (COLUMN-VARIABLE :TYPE SYMBOL) (COLUMN-INDEX :TYPE INTEGER) (COLUMN-TYPE :TYPE NAMED-DESCRIPTION) (COLUMN-DB-TYPE :TYPE STRING) (MODULE-NAME :TYPE STRING) (MODULE-REFERENCE :TYPE STRING) (MODULE :TYPE MODULE) (MODULE-LOCAL? :TYPE BOOLEAN) (MODULE-REFERENCE-COLUMN :TYPE RELATION-COLUMN-INFO) (COERCION-FUNCTION :TYPE FUNCTION-CODE)))");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.rdbms.RelationColumnInfo", "newRelationColumnInfo", new java.lang.Class [] {});
            renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.rdbms.RelationColumnInfo", "accessRelationColumnInfoSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.rdbms.RelationColumnInfo"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
          }
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupRdbms.helpStartupRdbms3();
          Stella.defineFunctionObject("COERCE-POWERLOOM-OBJECT-TO-STRING", "(DEFUN (COERCE-POWERLOOM-OBJECT-TO-STRING STRING) ((OBJECT OBJECT) (TYPE NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "coercePowerloomObjectToString", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
          Stella.defineFunctionObject("FIND-OR-CREATE-INSTANCE", "(DEFUN (FIND-OR-CREATE-INSTANCE OBJECT) ((NAME STRING) (TYPE NAMED-DESCRIPTION) (MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Find an existing instance with `name' in `module' or create one with `type'\nif it does not yet exist.  If `local?' do not look into any inherited modules.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "findOrCreateInstance", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("CREATE-SQL-ASSERTION-FROM-PROPOSITION", "(DEFUN (CREATE-SQL-ASSERTION-FROM-PROPOSITION STRING) ((PROPOSITION PROPOSITION) (MODE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "createSqlAssertionFromProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("DB-RELATION-GOES-TRUE", "(DEFUN DB-RELATION-GOES-TRUE ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "dbRelationGoesTrue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("DB-RELATION-GOES-UNKNOWN", "(DEFUN DB-RELATION-GOES-UNKNOWN ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "dbRelationGoesUnknown", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("DB-RELATION-GOES-FALSE", "(DEFUN DB-RELATION-GOES-FALSE ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "dbRelationGoesFalse", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("DB-RELATION-UPDATE-DEMON", "(DEFUN DB-RELATION-UPDATE-DEMON ((PROPOSITION PROPOSITION) (UPDATE-MODE KEYWORD)))", Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "dbRelationUpdateDemon", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("STARTUP-RDBMS", "(DEFUN STARTUP-RDBMS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.rdbms._StartupRdbms", "startupRdbms", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(RDBMS.SYM_RDBMS_STARTUP_RDBMS);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, RDBMS.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupRdbms"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("RDBMS")))));
          Symbol.safeImportSymbol(RDBMS.SYM_RDBMS_DEFUNTABLE, Stella.getStellaModule("PL-KERNEL", true));
          Symbol.safeImportSymbol(RDBMS.SYM_RDBMS_DEFTABLE, Stella.getStellaModule("PL-KERNEL", true));
          Symbol.safeImportSymbol(RDBMS.SYM_RDBMS_DEFDB, Stella.getStellaModule("PL-KERNEL", true));
          Symbol.safeImportSymbol(RDBMS.SYM_RDBMS_DEFQUERY, Stella.getStellaModule("PL-KERNEL", true));
          Logic.defineExplanationPhrase(RDBMS.KWD_DB_LOOKUP, RDBMS.KWD_TECHNICAL, "by database lookup", Stella.NIL);
          Logic.defineExplanationPhrase(RDBMS.KWD_DB_LOOKUP, RDBMS.KWD_LAY, "because it is stored in database", Stella.NIL);
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
