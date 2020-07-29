//  -*- Mode: Java -*-
//
// _StartupSdbc.java

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

package edu.isi.sdbc;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.stella.*;

public class _StartupSdbc {
  static void helpStartupSdbc1() {
    {
      Sdbc.KWD_LOG_LEVELS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LOG-LEVELS", null, 2)));
      Sdbc.KWD_LEVEL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LEVEL", null, 2)));
      Sdbc.KWD_NONE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NONE", null, 2)));
      Sdbc.KWD_MAX_WIDTH = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MAX-WIDTH", null, 2)));
      Sdbc.SGT_SDBC_CONNECTION = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONNECTION", null, 1)));
      Sdbc.SYM_SDBC_CONNECTION_STRING = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CONNECTION-STRING", null, 0)));
      Sdbc.SYM_SDBC_PROTOCOL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PROTOCOL", null, 0)));
      Sdbc.SYM_SDBC_DBMS_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DBMS-NAME", null, 0)));
      Sdbc.SYM_SDBC_STATEMENT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STATEMENT", null, 0)));
      Sdbc.SYM_SDBC_AUTO_COMMITp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("AUTO-COMMIT?", null, 0)));
      Sdbc.SYM_SDBC_CREATION_TIME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CREATION-TIME", null, 0)));
      Sdbc.SYM_SDBC_LAST_ACCESS_TIME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LAST-ACCESS-TIME", null, 0)));
      Sdbc.SYM_SDBC_RENEWAL_TIME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RENEWAL-TIME", null, 0)));
      Sdbc.SGT_SDBC_PREPARED_STATEMENT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PREPARED-STATEMENT", null, 1)));
      Sdbc.SYM_SDBC_CONNECTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CONNECTION", null, 0)));
      Sdbc.SYM_SDBC_SQL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SQL", null, 0)));
      Sdbc.SYM_STELLA_PARAMETERS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PARAMETERS", Stella.getStellaModule("/STELLA", true), 0)));
      Sdbc.SYM_SDBC_RDBMS_ROW = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RDBMS-ROW", null, 0)));
      Sdbc.SGT_SDBC_RESULT_SET_ITERATOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("RESULT-SET-ITERATOR", null, 1)));
      Sdbc.SYM_SDBC_TYPES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TYPES", null, 0)));
      Sdbc.KWD_PROTOCOL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PROTOCOL", null, 2)));
      Sdbc.KWD_SERVER_TYPE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SERVER-TYPE", null, 2)));
      Sdbc.KWD_LOW = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LOW", null, 2)));
      Sdbc.KWD_CONNECTION_STRING = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONNECTION-STRING", null, 2)));
      Sdbc.KWD_HOST = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("HOST", null, 2)));
      Sdbc.KWD_PORT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PORT", null, 2)));
      Sdbc.KWD_DB_NAME = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DB-NAME", null, 2)));
      Sdbc.KWD_DSN = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DSN", null, 2)));
      Sdbc.KWD_USER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("USER", null, 2)));
      Sdbc.KWD_PASSWORD = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PASSWORD", null, 2)));
      Sdbc.KWD_WHITE_SPACE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("WHITE-SPACE", null, 2)));
      Sdbc.KWD_LETTER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LETTER", null, 2)));
      Sdbc.SYM_STELLA_NULL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL", Stella.getStellaModule("/STELLA", true), 0)));
      Sdbc.SGT_STELLA_CALENDAR_DATE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CALENDAR-DATE", Stella.getStellaModule("/STELLA", true), 1)));
      Sdbc.SGT_STELLA_STRING = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("STRING", Stella.getStellaModule("/STELLA", true), 1)));
      Sdbc.SGT_STELLA_INTEGER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("INTEGER", Stella.getStellaModule("/STELLA", true), 1)));
      Sdbc.SGT_STELLA_LONG_INTEGER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("LONG-INTEGER", Stella.getStellaModule("/STELLA", true), 1)));
      Sdbc.SGT_STELLA_DOUBLE_FLOAT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("DOUBLE-FLOAT", Stella.getStellaModule("/STELLA", true), 1)));
      Sdbc.KWD_TYPES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TYPES", null, 2)));
      Sdbc.KWD_HIGH = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("HIGH", null, 2)));
      Sdbc.KWD_STRING_CONSTANT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("STRING-CONSTANT", null, 2)));
      Sdbc.KWD_IDENTIFIER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("IDENTIFIER", null, 2)));
      Sdbc.KWD_MYSQL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MYSQL", null, 2)));
      Sdbc.KWD_NULL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NULL", null, 2)));
      Sdbc.SYM_STELLA_DEFAULT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFAULT", Stella.getStellaModule("/STELLA", true), 0)));
      Sdbc.KWD_DEFAULT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFAULT", null, 2)));
      Sdbc.KWD_ORACLE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ORACLE", null, 2)));
      Sdbc.SGT_STELLA_WRAPPER = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("WRAPPER", Stella.getStellaModule("/STELLA", true), 1)));
      Sdbc.SGT_SDBC_TABLE_INFO = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("TABLE-INFO", null, 1)));
      Sdbc.SYM_SDBC_DATABASE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DATABASE", null, 0)));
      Sdbc.SYM_SDBC_CATALOG = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CATALOG", null, 0)));
      Sdbc.SYM_SDBC_SCHEMA = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SCHEMA", null, 0)));
      Sdbc.SYM_STELLA_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NAME", Stella.getStellaModule("/STELLA", true), 0)));
      Sdbc.SYM_STELLA_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TYPE", Stella.getStellaModule("/STELLA", true), 0)));
      Sdbc.SYM_SDBC_REMARKS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("REMARKS", null, 0)));
      Sdbc.SYM_SDBC_COLUMNS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COLUMNS", null, 0)));
      Sdbc.SGT_SDBC_COLUMN_INFO = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("COLUMN-INFO", null, 1)));
      Sdbc.SYM_STELLA_TABLE_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TABLE-NAME", Stella.getStellaModule("/STELLA", true), 0)));
      Sdbc.SYM_SDBC_DATA_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DATA-TYPE", null, 0)));
      Sdbc.SYM_SDBC_DATA_TYPE_NAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DATA-TYPE-NAME", null, 0)));
    }
  }

  static void helpStartupSdbc2() {
    {
      Sdbc.SYM_SDBC_COLUMN_SIZE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COLUMN-SIZE", null, 0)));
      Sdbc.SYM_SDBC_BUFFER_LENGTH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("BUFFER-LENGTH", null, 0)));
      Sdbc.SYM_SDBC_DECIMAL_DIGITS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DECIMAL-DIGITS", null, 0)));
      Sdbc.SYM_SDBC_RADIX = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RADIX", null, 0)));
      Sdbc.SYM_SDBC_NULLABLEp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NULLABLE?", null, 0)));
      Sdbc.SYM_SDBC_IS_NULLABLEp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IS-NULLABLE?", null, 0)));
      Sdbc.SYM_STELLA_DOCUMENTATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DOCUMENTATION", Stella.getStellaModule("/STELLA", true), 0)));
      Sdbc.SYM_STELLA_DEFAULT_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFAULT-VALUE", Stella.getStellaModule("/STELLA", true), 0)));
      Sdbc.SYM_SDBC_SQL_DATA_TYPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SQL-DATA-TYPE", null, 0)));
      Sdbc.SYM_SDBC_SQL_DATETIME_SUB = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SQL-DATETIME-SUB", null, 0)));
      Sdbc.SYM_SDBC_CHAR_OCTET_LENGTH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("CHAR-OCTET-LENGTH", null, 0)));
      Sdbc.SYM_SDBC_ORDINAL_POSITION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ORDINAL-POSITION", null, 0)));
      Sdbc.KWD_COMMAND = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("COMMAND", null, 2)));
      Sdbc.KWD_DATA_SOURCE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DATA-SOURCE", null, 2)));
      Sdbc.KWD_SQL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SQL", null, 2)));
      Sdbc.KWD_OTHERWISE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("OTHERWISE", null, 2)));
      Sdbc.SGT_STELLA_CONS = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONS", Stella.getStellaModule("/STELLA", true), 1)));
      Sdbc.KWD_DIGIT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DIGIT", null, 2)));
      Sdbc.KWD_CONNECTIONSTRING = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONNECTIONSTRING", null, 2)));
      Sdbc.SYM_SDBC_STARTUP_SDBC = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-SDBC", null, 0)));
      Sdbc.SYM_STELLA_METHOD_STARTUP_CLASSNAME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-STARTUP-CLASSNAME", Stella.getStellaModule("/STELLA", true), 0)));
    }
  }

  static void helpStartupSdbc3() {
    {
      Stella.defineClassFromStringifiedSource("NATIVE-CONNECTION", "(DEFCLASS NATIVE-CONNECTION () :ABSTRACT? TRUE :CPP-NATIVE-TYPE \"sdbc::NativeConnection*\" :JAVA-NATIVE-TYPE \"edu.isi.sdbc.NativeConnection\" :CL-NATIVE-TYPE \"#+:EXCL DB-INTERFACE::ODBC-DB #+:CLSQL CLSQL:DATABASE  #-(OR :EXCL :CLSQL) CL:STANDARD-OBJECT\")");
      Stella.defineClassFromStringifiedSource("NATIVE-RESULT-SET", "(DEFCLASS NATIVE-RESULT-SET () :ABSTRACT? TRUE :CPP-NATIVE-TYPE \"NativeResultSet*\" :JAVA-NATIVE-TYPE \"edu.isi.sdbc.ResultSet\" :CL-NATIVE-TYPE \"#+:EXCL DB-INTERFACE::QUERY #+:CLSQL CL:LIST  #-(OR :EXCL :CLSQL) CL:STANDARD-OBJECT\")");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("CONNECTION", "(DEFCLASS CONNECTION (STANDARD-OBJECT) :PUBLIC-SLOTS ((NATIVE-CONNECTION :TYPE NATIVE-CONNECTION :PUBLIC? TRUE) (CONNECTION-STRING :TYPE STRING) (PROTOCOL :TYPE STRING) (DBMS-NAME :TYPE KEYWORD :DOCUMENTATION \"Indicates to what kind of DBMS we are connected.\") (STATEMENT :TYPE PREPARED-STATEMENT :DOCUMENTATION \"Prepared statement associated with this connection.\") (AUTO-COMMIT? :TYPE BOOLEAN :INITIALLY TRUE :DOCUMENTATION \"State of connection's auto-commit feature.\") (CREATION-TIME :TYPE CALENDAR-DATE :DOCUMENTATION \"Time at which connection was created.\") (LAST-ACCESS-TIME :TYPE CALENDAR-DATE :DOCUMENTATION \"Time at which connection was last accessed.\") (RENEWAL-TIME :TYPE CALENDAR-DATE :DOCUMENTATION \"Time at or after which connection should be renewed.\")) :PRINT-FORM (PRINT-NATIVE-STREAM STREAM \"|CON|\\\"\" (CONNECTION-STRING SELF) \"\\\"\"))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.sdbc.Connection", "newConnection", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.sdbc.Connection", "accessConnectionSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.Connection"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("PREPARED-STATEMENT", "(DEFCLASS PREPARED-STATEMENT (STANDARD-OBJECT) :SLOTS ((CONNECTION :TYPE CONNECTION) (STATEMENT :TYPE NATIVE-PREPARED-STATEMENT) (SQL :TYPE STRING) (PARAMETERS :TYPE (KEY-VALUE-LIST OF INTEGER-WRAPPER CONS) :INITIALLY (NEW KEY-VALUE-LIST) :DOCUMENTATION \"Stores parameters bound so far to support connection renewal.\")))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.sdbc.PreparedStatement", "newPreparedStatement", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.sdbc.PreparedStatement", "accessPreparedStatementSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.PreparedStatement"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      Stella.defineClassFromStringifiedSource("NATIVE-PREPARED-STATEMENT", "(DEFCLASS NATIVE-PREPARED-STATEMENT () :ABSTRACT? TRUE :JAVA-NATIVE-TYPE \"java.sql.PreparedStatement\")");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("DATABASE-EXCEPTION", "(DEFCLASS DATABASE-EXCEPTION (STELLA-EXCEPTION))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.sdbc.DatabaseException", "newDatabaseException", new java.lang.Class [] {Native.find_java_class("java.lang.String")});
      }
      Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE RDBMS-ROW (CONS OF STRING-WRAPPER))");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("RESULT-SET-ITERATOR", "(DEFCLASS RESULT-SET-ITERATOR (ITERATOR) :DOCUMENTATION \"Iterator class for a table returned by a SQL query.\" :PARAMETERS ((ANY-VALUE :TYPE RDBMS-ROW)) :PUBLIC-SLOTS ((RESULT-SET :TYPE NATIVE-RESULT-SET) (TYPES :TYPE CONS)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.sdbc.ResultSetIterator", "newResultSetIterator", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.sdbc.ResultSetIterator", "accessResultSetIteratorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.ResultSetIterator"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("TABLE-INFO", "(DEFCLASS TABLE-INFO (STANDARD-OBJECT) :PUBLIC-SLOTS ((DATABASE :TYPE STRING) (CATALOG :RENAMES DATABASE) (SCHEMA :TYPE STRING) (NAME :TYPE STRING) (TYPE :TYPE STRING) (REMARKS :TYPE STRING) (COLUMNS :TYPE (LIST OF COLUMN-INFO))))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.sdbc.TableInfo", "newTableInfo", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.sdbc.TableInfo", "accessTableInfoSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.TableInfo"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("COLUMN-INFO", "(DEFCLASS COLUMN-INFO (STANDARD-OBJECT) :PUBLIC-SLOTS ((DATABASE :TYPE STRING) (CATALOG :RENAMES DATABASE) (SCHEMA :TYPE STRING) (TABLE-NAME :TYPE STRING) (NAME :TYPE STRING) (DATA-TYPE :TYPE INTEGER :DOCUMENTATION \"SQL type from java.sql.Types.\") (DATA-TYPE-NAME :TYPE STRING :DOCUMENTATION \"Data source dependent type name, for a UDT the type name is fully qualified.\") (COLUMN-SIZE :TYPE INTEGER :DOCUMENTATION \"Column size. For char or date types this is the maximum number of characters,\nfor numeric or decimal types this is precision.\") (BUFFER-LENGTH :TYPE INTEGER :DOCUMENTATION \"Not used.\") (DECIMAL-DIGITS :TYPE INTEGER :DOCUMENTATION \"The number of fractional digits.\") (RADIX :TYPE INTEGER :DOCUMENTATION \"Radix (typically either 10 or 2).\") (NULLABLE? :TYPE THREE-VALUED-BOOLEAN :DOCUMENTATION \"TRUE means definitely allows NULL values, FALSE means might not allow\nNULL values, NULL means nullability unknown.\") (IS-NULLABLE? :TYPE THREE-VALUED-BOOLEAN :DOCUMENTATION \"TRUE means might allow NULL values, FALSE means definitely does not\nallow NULL values, NULL means nullability unknown.\") (DOCUMENTATION :TYPE STRING :DOCUMENTATION \"Comment describing column (may be null).\") (REMARKS :RENAMES DOCUMENTATION) (DEFAULT-VALUE :TYPE STRING) (SQL-DATA-TYPE :TYPE INTEGER :DOCUMENTATION \"Not used.\") (SQL-DATETIME-SUB :TYPE INTEGER :DOCUMENTATION \"Not used.\") (CHAR-OCTET-LENGTH :TYPE INTEGER :DOCUMENTATION \"For char types the maximum number of bytes in the column.\") (ORDINAL-POSITION :TYPE INTEGER :DOCUMENTATION \"Index of column in table (starting at 1).\")))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.sdbc.ColumnInfo", "newColumnInfo", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.sdbc.ColumnInfo", "accessColumnInfoSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.ColumnInfo"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
    }
  }

  static void helpStartupSdbc4() {
    {
      Stella.defineFunctionObject("CONNECT", "(DEFUN (CONNECT CONNECTION) (|&REST| (KEYS-AND-VALUES OBJECT)) :DOCUMENTATION \"Create a connection to a database.  Currently-supported parameters\nare (values need to be strings):\n  :PROTOCOL          - \\\"ODBC\\\", \\\"JDBC\\\", \\\"CLSQL\\\" or \\\"MYSQL\\\" (defaults to \\\"ODBC\\\")\n  :SERVER-TYPE       - Type of database server (for JDBC strings)\n  :DSN               - Name of ODBC Datasource\n  :DB-NAME           - Name of physical database\n  :USER              - Database user id.\n  :PASSWORD          - Database password\n  :HOST              - Host database server runs on\n  :PORT              - Port to use to connect to the server\n  :CONNECTION-STRING - Connection string to be used by ODBC or JDBC drivers\n                       instead of DSN, USER, PASSWORD, etc.\nA DATABASE-EXCEPTION is thrown if the connection is unsuccessful.\" :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.sdbc.Sdbc", "connect", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.sdbc.Sdbc", "connectEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("CALL-CONNECT", "(DEFUN (CALL-CONNECT CONNECTION) ((KEYS-AND-VALUES CONS)) :PUBLIC? TRUE :DOCUMENTATION \"Functional interface to `connect'.  See its documentation\")", Native.find_java_method("edu.isi.sdbc.Sdbc", "callConnect", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("*DB-CONNECTION-RENEWAL-INTERVAL*-SETTER", "(DEFUN (*DB-CONNECTION-RENEWAL-INTERVAL*-SETTER INTEGER) ((VALUE INTEGER)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "$DbConnectionRenewalInterval$Setter", new java.lang.Class [] {java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("GET-MAX-CONNECTION-LIFETIME", "(DEFUN (GET-MAX-CONNECTION-LIFETIME INTEGER) ((CON CONNECTION)))", Native.find_java_method("edu.isi.sdbc.Connection", "getMaxConnectionLifetime", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.Connection")}), null);
      Stella.defineFunctionObject("MAYBE-RENEW-CONNECTION", "(DEFUN MAYBE-RENEW-CONNECTION ((CON CONNECTION)))", Native.find_java_method("edu.isi.sdbc.Connection", "maybeRenewConnection", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.Connection")}), null);
      Stella.defineFunctionObject("JDBC-CONNECTION-STRING?", "(DEFUN (JDBC-CONNECTION-STRING? BOOLEAN) ((STRING STRING)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "jdbcConnectionStringP", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("MAKE-JDBC-CONNECTION-STRING", "(DEFUN (MAKE-JDBC-CONNECTION-STRING STRING) ((OPTIONS (PROPERTY-LIST OF KEYWORD OBJECT))))", Native.find_java_method("edu.isi.sdbc.Sdbc", "makeJdbcConnectionString", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.PropertyList")}), null);
      Stella.defineFunctionObject("ODBC-CONNECTION-STRING?", "(DEFUN (ODBC-CONNECTION-STRING? BOOLEAN) ((STRING STRING)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "odbcConnectionStringP", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("MAKE-ODBC-CONNECTION-STRING", "(DEFUN (MAKE-ODBC-CONNECTION-STRING STRING) ((OPTIONS (PROPERTY-LIST OF KEYWORD STRING-WRAPPER))))", Native.find_java_method("edu.isi.sdbc.Sdbc", "makeOdbcConnectionString", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.PropertyList")}), null);
      Stella.defineFunctionObject("CL-NATIVE-ODBC-CONNECT", "(DEFUN (CL-NATIVE-ODBC-CONNECT NATIVE-CONNECTION STRING) ((CONNECTIONSTRING STRING)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "clNativeOdbcConnect", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("CL-NATIVE-CLSQL-CONNECT", "(DEFUN (CL-NATIVE-CLSQL-CONNECT NATIVE-CONNECTION STRING) ((OPTIONS (PROPERTY-LIST OF KEYWORD STRING-WRAPPER)) (SERVER-TYPE STRING)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "clNativeClsqlConnect", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.PropertyList"), Native.find_java_class("java.lang.String"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("DISCONNECT", "(DEFUN DISCONNECT ((CONNECTION CONNECTION)) :DOCUMENTATION \"Disconnect `connection' from a database.  A DATABASE-EXCEPTION is thrown if\nthe disconnect is unsuccessful.\" :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.sdbc.Connection", "disconnect", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.Connection")}), null);
      Stella.defineFunctionObject("CL-NATIVE-DISCONNECT", "(DEFUN CL-NATIVE-DISCONNECT ((NATIVE-CONNECTION NATIVE-CONNECTION)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "clNativeDisconnect", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.NativeConnection")}), null);
      Stella.defineFunctionObject("CL-NATIVE-ODBC-DISCONNECT", "(DEFUN CL-NATIVE-ODBC-DISCONNECT ((NATIVECONNECTION NATIVE-CONNECTION)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "clNativeOdbcDisconnect", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.NativeConnection")}), null);
      Stella.defineFunctionObject("CL-NATIVE-CLSQL-DISCONNECT", "(DEFUN CL-NATIVE-CLSQL-DISCONNECT ((NATIVE-CONNECTION NATIVE-CONNECTION)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "clNativeClsqlDisconnect", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.NativeConnection")}), null);
      Stella.defineFunctionObject("SQL-QUERY?", "(DEFUN (SQL-QUERY? BOOLEAN) ((SQL-EXPRESSION STRING)) :DOCUMENTATION \"Return `true' if `sql-expression' is a SQL command string which returns\nvalues.\" :PUBLIC? FALSE)", Native.find_java_method("edu.isi.sdbc.Sdbc", "sqlQueryP", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("STELLIFY-WITH-NIL-TO-NULL", "(DEFUN (STELLIFY-WITH-NIL-TO-NULL OBJECT) ((SELF OBJECT)) :DOCUMENTATION \"Convert a Lisp object into a STELLA object.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.sdbc.Sdbc", "stellifyWithNilToNull", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-SQL-PARAMETER-TYPE-SPECIFIER", "(DEFUN (CL-TRANSLATE-SQL-PARAMETER-TYPE-SPECIFIER OBJECT) ((STELLATYPE OBJECT)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "clTranslateSqlParameterTypeSpecifier", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-SQL-TYPE-SPECIFIER", "(DEFUN (CL-TRANSLATE-SQL-TYPE-SPECIFIER OBJECT) ((STELLATYPE OBJECT)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "clTranslateSqlTypeSpecifier", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CL-TRANSLATE-SQL-TYPE-SPECIFIERS", "(DEFUN (CL-TRANSLATE-SQL-TYPE-SPECIFIERS CONS) ((STELLATYPES CONS)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "clTranslateSqlTypeSpecifiers", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("EXECUTE-SQL", "(DEFUN (EXECUTE-SQL OBJECT) ((CONNECTION CONNECTION) (SQL OBJECT) |&REST| (OPTIONS OBJECT)) :PUBLIC? TRUE :COMMAND? TRUE :DOCUMENTATION \"Execute a SQL statement, and return a table as the reuslt\n                  of a SQL query (represented as a (CONS OF (CONS OF OBJECT))),\n                  or NULL as the result of a successfull SQL insert, update,\n                  delete or other command.\n                  `sql' can either be a string representing a SQL command or\n                  a PREPARED-STATEMENT.\n                  Options include: \n                     :types <typelist>, where <typelist> is a cons list of surrogates\n                  specifying the expected Stella types.  Legal surrogate values are\n                  @INTEGER, @LONG-INTEGER, @DOUBLE-FLOAT, @CALENDAR-DATE, @STRING, and\n                  NULL.  If NULL is specified, values are returned as strings.\n                  A DATABASE-EXCEPTION is thrown if execution is unsuccessful.\")", Native.find_java_method("edu.isi.sdbc.Connection", "executeSql", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.Connection"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.sdbc.Sdbc", "executeSqlEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("CL-EXECUTE-SQL", "(DEFUN (CL-EXECUTE-SQL OBJECT) ((CONNECTION NATIVE-CONNECTION) (SQL STRING) (TYPES CONS)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "clExecuteSql", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.NativeConnection"), Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-DO-EXECUTE-PREPARED-STATEMENT", "(DEFUN (CL-DO-EXECUTE-PREPARED-STATEMENT OBJECT) ((CONNECTION NATIVE-CONNECTION) (SQL PREPARED-STATEMENT)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "clDoExecutePreparedStatement", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.NativeConnection"), Native.find_java_class("edu.isi.sdbc.PreparedStatement")}), null);
      Stella.defineFunctionObject("GET-RESULT-SET", "(DEFUN (GET-RESULT-SET RESULT-SET-ITERATOR) ((CONNECTION CONNECTION) (SQL STRING) |&REST| (OPTIONS OBJECT)) :PUBLIC? TRUE :DOCUMENTATION \"Execute a SQL query, and return a ResultSet object.\n                  Options include: \n                     :types <typelist>, where <typelist> is a cons list of surrogates\n                  specifying the expected Stella types.  Legal surrogate values are\n                  @INTEGER, @LONG-INTEGER, @DOUBLE-FLOAT, @CALENDAR-DATE, @STRING, and\n                  NULL.  If NULL is specified, values are returned as strings.\n                  A DATABASE-EXCEPTION is thrown if execution is unsuccessful.\")", Native.find_java_method("edu.isi.sdbc.Connection", "getResultSet", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.Connection"), Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CL-GET-NATIVE-RESULT-SET", "(DEFUN (CL-GET-NATIVE-RESULT-SET NATIVE-RESULT-SET) ((CONNECTION NATIVE-CONNECTION) (SQL STRING) (TYPES CONS)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "clGetNativeResultSet", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.NativeConnection"), Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineMethodObject("(DEFMETHOD (NEXT? BOOLEAN) ((SELF RESULT-SET-ITERATOR)))", Native.find_java_method("edu.isi.sdbc.ResultSetIterator", "nextP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("SQL-ESCAPE-STRING", "(DEFUN (SQL-ESCAPE-STRING STRING) ((VALUE STRING) (QUOTECHAR CHARACTER)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "sqlEscapeString", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Character.TYPE}), null);
      Stella.defineFunctionObject("SQL-QUOTE-CHARACTER", "(DEFUN (SQL-QUOTE-CHARACTER CHARACTER) ((DBMS-NAME KEYWORD) (LEXICALTYPE KEYWORD)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "sqlQuoteCharacter", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("PRINT-VALUE-LIST", "(DEFUN PRINT-VALUE-LIST ((STREAM OUTPUT-STREAM) (VALUES CONS) (QUOTECHAR CHARACTER)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "printValueList", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.Cons"), java.lang.Character.TYPE}), null);
      Stella.defineFunctionObject("INSERT-ROW", "(DEFUN INSERT-ROW ((CONNECTION CONNECTION) (TABLE STRING) (COLUMNS (CONS OF STRING-WRAPPER)) (VALUES CONS)) :DOCUMENTATION \"Insert a row of `values' into `table'.  `columns'\ncan be NULL or NIL in which case `values' must be suppied for all\ncolumns.  If `columns' are given `values' will be only inserted in\nthe specified columns.  Table and column names will be quoted which\nmeans their casing must match exactly their definition (no case\nconversion will be performed).  Supplied `values' can be strings,\nintegers or floats.  Strings will be quoted and escaped appropriately.\nThe values NULL, :NULL or (quote NULL) translate into NULL.  The\nvalues :DEFAULT or (quote DEFAULT) translate into DEFAULT.  Arbitrary\nunquoted strings can be generated via VERBATIM-STRING-WRAPPERs as\nvalues (e.g., for something like `seq.nextval' in Oracle).\" :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.sdbc.Connection", "insertRow", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.Connection"), Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.sdbc.Sdbc", "insertRowEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("INSERT-ROWS", "(DEFUN INSERT-ROWS ((CONNECTION CONNECTION) (TABLE STRING) (COLUMNS (CONS OF STRING-WRAPPER)) (ROWS (CONS OF RDBMS-ROW))) :DOCUMENTATION \"Insert a set of `rows' into `table'.  `columns'\ncan be NULL or NIL in which case values must be suppied for all\ncolumns.  If `columns' are given `values' will be only inserted in\nthe specified columns.  Table and column names will be quoted which\nmeans their casing must match exactly their definition (no case\nconversion will be performed).  See `insert-row' for a description\nof supported value formats.  DEFAULT values are currently not supported\nfor Oracle!  This function performs a fairly efficient multi-row\ninsert which is significantly faster than inserting rows one by one.\" :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.sdbc.Connection", "insertRows", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.Connection"), Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.sdbc.Sdbc", "insertRowsEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("COERCE-UNCOERCED-VALUES-IN-TABLE", "(DEFUN (COERCE-UNCOERCED-VALUES-IN-TABLE CONS) ((TABLE CONS) (TYPES CONS)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "coerceUncoercedValuesInTable", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("COERCE-UNCOERCED-COLUMN-VALUES", "(DEFUN (COERCE-UNCOERCED-COLUMN-VALUES CONS) ((ROW CONS) (TYPES CONS)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "coerceUncoercedColumnValues", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CONVERT-STRING-TO-TYPED-OBJECT", "(DEFUN (CONVERT-STRING-TO-TYPED-OBJECT OBJECT) ((VALUESTRING STRING) (TYPESPEC GENERALIZED-SYMBOL)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "convertStringToTypedObject", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.GeneralizedSymbol")}), null);
      Stella.defineFunctionObject("PREPARE-STATEMENT", "(DEFUN (PREPARE-STATEMENT PREPARED-STATEMENT) ((CONNECTION CONNECTION) (SQL STRING)) :DOCUMENTATION \"Prepare the `sql' statement for execution at the server and return\na prepared statement object.  After binding all its paramters via `bind-parameter'\nthe statement can be executed via `execute-sql'.\nIMPORTANT: Only one prepared statement can be associated with a connection at a time.\" :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.sdbc.Connection", "prepareStatement", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.Connection"), Native.find_java_class("java.lang.String")}), Native.find_java_method("edu.isi.sdbc.Sdbc", "prepareStatementEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("BIND-PARAMETER", "(DEFUN BIND-PARAMETER ((STATEMENT PREPARED-STATEMENT) (POSITION INTEGER) (TYPESPEC SURROGATE) (VALUE OBJECT)) :DOCUMENTATION \"Bind the parameter at `position' (1-based) in the prepared\nstatement `statement' to `value'.  `typeSpec' characterizes the type of\n`value' for proper translation and coercion.\" :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.sdbc.PreparedStatement", "bindParameter", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.PreparedStatement"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Stella_Object")}), Native.find_java_method("edu.isi.sdbc.Sdbc", "bindParameterEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("CL-DO-BIND-PARAMETER", "(DEFUN CL-DO-BIND-PARAMETER ((STATEMENT PREPARED-STATEMENT) (POSITION INTEGER) (TYPESPEC SURROGATE) (VALUE OBJECT)))", Native.find_java_method("edu.isi.sdbc.PreparedStatement", "clDoBindParameter", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.PreparedStatement"), java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SET-AUTO-COMMIT", "(DEFUN SET-AUTO-COMMIT ((CONNECTION CONNECTION) (FLAG BOOLEAN)) :DOCUMENTATION \"Set the auto-commit feature of `connection' to TRUE or FALSE.\nIf a connection is in auto-commit mode, then all its SQL statements will be executed\nand committed as individual transactions.  Otherwise, its SQL statements are grouped\ninto transactions that are terminated by a call to either `commit' or `rollback'.\nBy default, new connections are in auto-commit mode.\" :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.sdbc.Connection", "setAutoCommit", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.Connection"), java.lang.Boolean.TYPE}), Native.find_java_method("edu.isi.sdbc.Sdbc", "setAutoCommitEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("COMMIT", "(DEFUN COMMIT ((CONNECTION CONNECTION)) :DOCUMENTATION \"Commit the current transaction.  Makes all changes made since the\nprevious commit/rollback permanent and releases any database locks currently held\nby this `connection' object.  This function is a no-op if auto-commit mode is\nenabled (see `set-auto-commit').\" :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.sdbc.Connection", "commit", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.Connection")}), null);
      Stella.defineFunctionObject("ROLLBACK", "(DEFUN ROLLBACK ((CONNECTION CONNECTION)) :DOCUMENTATION \"Rollback the current transaction.  Undoes all changes made in\nthe current transaction and releases any database locks currently held by this\n`connection' object.  This function is a no-op if auto-commit mode is enabled\n (see `set-auto-commit').\" :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.sdbc.Connection", "rollback", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.Connection")}), null);
      Stella.defineFunctionObject("GET-TABLES", "(DEFUN (GET-TABLES (CONS OF TABLE-INFO)) ((CONNECTION CONNECTION) (CATALOG-NAME STRING) (SCHEMA-NAME STRING) (TABLE-NAME STRING) (TABLE-TYPE STRING)) :DOCUMENTATION \"Get the tables of the database identified by `connection'\nand return the result as a list of objects containing all the relevant\nmeta information.  If any of the remaining arguments is supplied as\nnon-NULL, only tables whose corresponding field matches will be returned.\nThis is less general than what is supported by JDBC and ODBC, but Allegro\nODBC does not support filtering based on patterns, so we only do simple\nmanual filtering here.\" :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.sdbc.Connection", "getTables", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.Connection"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), Native.find_java_method("edu.isi.sdbc.Sdbc", "getTablesEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("GET-COLUMNS", "(DEFUN (GET-COLUMNS (CONS OF COLUMN-INFO)) ((CONNECTION CONNECTION) (CATALOGNAME STRING) (SCHEMANAME STRING) (TABLENAME STRING) (COLUMNNAME STRING)) :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.sdbc.Connection", "getColumns", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.Connection"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), Native.find_java_method("edu.isi.sdbc.Sdbc", "getColumnsEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("GET-SERVER-INFO", "(DEFUN (GET-SERVER-INFO WRAPPER) ((CONNECTION CONNECTION) (PROPERTY STRING)) :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.sdbc.Connection", "getServerInfo", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.Connection"), Native.find_java_class("java.lang.String")}), Native.find_java_method("edu.isi.sdbc.Sdbc", "getServerInfoEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("GUESS-DBMS-NAME", "(DEFUN (GUESS-DBMS-NAME STRING) ((CONNECTION CONNECTION)))", Native.find_java_method("edu.isi.sdbc.Connection", "guessDbmsName", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.Connection")}), null);
      Stella.defineFunctionObject("GET-DBMS-NAME", "(DEFUN (GET-DBMS-NAME KEYWORD) ((CONNECTION CONNECTION)))", Native.find_java_method("edu.isi.sdbc.Connection", "getDbmsName", new java.lang.Class [] {Native.find_java_class("edu.isi.sdbc.Connection")}), null);
      Stella.defineFunctionObject("PRINT-TABLE", "(DEFUN PRINT-TABLE ((TABLE OBJECT)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "printTable", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CALENDAR-DATE-TO-SQL-STRING", "(DEFUN (CALENDAR-DATE-TO-SQL-STRING STRING) ((DATE CALENDAR-DATE)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "calendarDateToSqlString", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.CalendarDate")}), null);
      Stella.defineFunctionObject("LOAD-SQL-CMD-TEMPLATES", "(DEFUN LOAD-SQL-CMD-TEMPLATES ((FILE STRING)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "loadSqlCmdTemplates", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("INSERT-SQL-COMMAND-TEMPLATE", "(DEFUN INSERT-SQL-COMMAND-TEMPLATE ((TEMPLATE PROPERTY-LIST)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "insertSqlCommandTemplate", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.PropertyList")}), null);
      Stella.defineFunctionObject("LOOKUP-SQL-CMD-TEMPLATE", "(DEFUN (LOOKUP-SQL-CMD-TEMPLATE PROPERTY-LIST) ((COMMANDNAME OBJECT) (DATASOURCE OBJECT)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "lookupSqlCmdTemplate", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("INSTANTIATE-SQL-CMD", "(DEFUN (INSTANTIATE-SQL-CMD STRING) ((CMDNAME OBJECT) (DATASOURCE OBJECT) |&REST| (|VARS&VALUES| STRING)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "instantiateSqlCmd", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("INSTANTIATE-SQL-CMD-TEMPLATE", "(DEFUN (INSTANTIATE-SQL-CMD-TEMPLATE STRING) ((TEMPLATE STRING) (VARIABLES (KEY-VALUE-LIST OF STRING-WRAPPER OBJECT))))", Native.find_java_method("edu.isi.sdbc.Sdbc", "instantiateSqlCmdTemplate", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
      Stella.defineFunctionObject("READ-SQL-CMD-TEMPLATE-VARIABLE", "(DEFUN (READ-SQL-CMD-TEMPLATE-VARIABLE STRING INTEGER) ((TEMPLATE STRING) (START INTEGER) (END INTEGER)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "readSqlCmdTemplateVariable", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Integer.TYPE, java.lang.Integer.TYPE, Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("INSTANTIATE-SQL-CMD-TEMPLATE-VARIABLE", "(DEFUN (INSTANTIATE-SQL-CMD-TEMPLATE-VARIABLE STRING) ((TEMPLATEVARIABLE STRING) (VARIABLES (KEY-VALUE-LIST OF STRING-WRAPPER OBJECT))))", Native.find_java_method("edu.isi.sdbc.Sdbc", "instantiateSqlCmdTemplateVariable", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
      Stella.defineFunctionObject("PARSE-SQL-CMD-TEMPLATE-VARIABLE-RANGE-AND-DEFAULT", "(DEFUN (PARSE-SQL-CMD-TEMPLATE-VARIABLE-RANGE-AND-DEFAULT STRING INTEGER INTEGER STRING) ((TEMPLATEVARIABLE STRING) (VARIABLENAME STRING) (START INTEGER)))", Native.find_java_method("edu.isi.sdbc.Sdbc", "parseSqlCmdTemplateVariableRangeAndDefault", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), java.lang.Integer.TYPE, Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("TEST-PREPARED-STATEMENT", "(DEFUN TEST-PREPARED-STATEMENT ())", Native.find_java_method("edu.isi.sdbc.Sdbc", "testPreparedStatement", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("TEST-TRANSACTIONS", "(DEFUN TEST-TRANSACTIONS ())", Native.find_java_method("edu.isi.sdbc.Sdbc", "testTransactions", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("TEST-RESULT-SET", "(DEFUN TEST-RESULT-SET ())", Native.find_java_method("edu.isi.sdbc.Sdbc", "testResultSet", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("TEST-RETRIEVE-ALL", "(DEFUN TEST-RETRIEVE-ALL ())", Native.find_java_method("edu.isi.sdbc.Sdbc", "testRetrieveAll", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("MAIN", "(DEFUN MAIN ((ARGV-001 (ARRAY () OF STRING))) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.sdbc.Sdbc", "main", new java.lang.Class [] {Native.find_java_class("[Ljava.lang.String;")}), null);
    }
  }

  public static void startupSdbc() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/SDBC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupSdbc.helpStartupSdbc1();
          _StartupSdbc.helpStartupSdbc2();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Sdbc.$SQL_COMMAND_TEMPLATES$.setDefaultValue(KeyValueMap.newKeyValueMap());
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          _StartupSdbc.helpStartupSdbc3();
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupSdbc.helpStartupSdbc4();
          Stella.defineFunctionObject("STARTUP-SDBC", "(DEFUN STARTUP-SDBC () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.sdbc._StartupSdbc", "startupSdbc", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Sdbc.SYM_SDBC_STARTUP_SDBC);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Sdbc.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupSdbc"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/SDBC")))));
          Stella.setLoggingParameters("SDBC", Cons.cons(Sdbc.KWD_LOG_LEVELS, Cons.cons(Stella.getQuotedTree("((:NONE :LOW :MEDIUM :HIGH) \"/SDBC\")", "/SDBC"), Cons.cons(Sdbc.KWD_LEVEL, Cons.cons(Sdbc.KWD_NONE, Cons.cons(Sdbc.KWD_MAX_WIDTH, Cons.cons(IntegerWrapper.wrapInteger(250), Stella.NIL)))))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *DB-CONNECTION-RENEWAL-INTERVAL* INTEGER 60 :DOCUMENTATION \"The maximum lifetime of a database connection (in seconds) after which\nit gets automatically renewed.  Auto-renewals avoid connection timeout errors which are\notherwise tricky to catch, e.g., we might just see a `bad handle passed' error.\" :DEMON-PROPERTY \"sdbc.dbConnectionRenewalInterval\" :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *SQL-COMMAND-TEMPLATES* (KEY-VALUE-MAP OF OBJECT (KEY-VALUE-LIST OF OBJECT PROPERTY-LIST)) (NEW KEY-VALUE-MAP))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *SQL-CMD-TEMPLATE-VARIABLE-PREFIX* STRING \"#$\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
