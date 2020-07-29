//  -*- Mode: Java -*-
//
// Sdbc.java

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

public class Sdbc {
  public static Keyword KWD_LOG_LEVELS = null;

  public static Keyword KWD_LEVEL = null;

  public static Keyword KWD_NONE = null;

  public static Keyword KWD_MAX_WIDTH = null;

  public static Surrogate SGT_SDBC_CONNECTION = null;

  public static Symbol SYM_SDBC_CONNECTION_STRING = null;

  public static Symbol SYM_SDBC_PROTOCOL = null;

  public static Symbol SYM_SDBC_DBMS_NAME = null;

  public static Symbol SYM_SDBC_STATEMENT = null;

  public static Symbol SYM_SDBC_AUTO_COMMITp = null;

  public static Symbol SYM_SDBC_CREATION_TIME = null;

  public static Symbol SYM_SDBC_LAST_ACCESS_TIME = null;

  public static Symbol SYM_SDBC_RENEWAL_TIME = null;

  public static Surrogate SGT_SDBC_PREPARED_STATEMENT = null;

  public static Symbol SYM_SDBC_CONNECTION = null;

  public static Symbol SYM_SDBC_SQL = null;

  public static Symbol SYM_STELLA_PARAMETERS = null;

  public static Symbol SYM_SDBC_RDBMS_ROW = null;

  public static Surrogate SGT_SDBC_RESULT_SET_ITERATOR = null;

  public static Symbol SYM_SDBC_TYPES = null;

  public static Keyword KWD_PROTOCOL = null;

  public static Keyword KWD_SERVER_TYPE = null;

  public static Keyword KWD_LOW = null;

  /** The maximum lifetime of a database connection (in seconds) after which
   * it gets automatically renewed.  Auto-renewals avoid connection timeout errors which are
   * otherwise tricky to catch, e.g., we might just see a <code>badHandlePassed</code> error.
   */
  public static int $DB_CONNECTION_RENEWAL_INTERVAL$ = 60;

  public static Keyword KWD_CONNECTION_STRING = null;

  public static Keyword KWD_HOST = null;

  public static Keyword KWD_PORT = null;

  public static Keyword KWD_DB_NAME = null;

  public static Keyword KWD_DSN = null;

  public static Keyword KWD_USER = null;

  public static Keyword KWD_PASSWORD = null;

  public static Keyword KWD_WHITE_SPACE = null;

  public static Keyword KWD_LETTER = null;

  public static Symbol SYM_STELLA_NULL = null;

  public static Surrogate SGT_STELLA_CALENDAR_DATE = null;

  public static Surrogate SGT_STELLA_STRING = null;

  public static Surrogate SGT_STELLA_INTEGER = null;

  public static Surrogate SGT_STELLA_LONG_INTEGER = null;

  public static Surrogate SGT_STELLA_DOUBLE_FLOAT = null;

  public static Keyword KWD_TYPES = null;

  public static Keyword KWD_HIGH = null;

  public static Keyword KWD_STRING_CONSTANT = null;

  public static Keyword KWD_IDENTIFIER = null;

  public static Keyword KWD_MYSQL = null;

  public static Keyword KWD_NULL = null;

  public static Symbol SYM_STELLA_DEFAULT = null;

  public static Keyword KWD_DEFAULT = null;

  public static Keyword KWD_ORACLE = null;

  public static Surrogate SGT_STELLA_WRAPPER = null;

  public static Surrogate SGT_SDBC_TABLE_INFO = null;

  public static Symbol SYM_SDBC_DATABASE = null;

  public static Symbol SYM_SDBC_CATALOG = null;

  public static Symbol SYM_SDBC_SCHEMA = null;

  public static Symbol SYM_STELLA_NAME = null;

  public static Symbol SYM_STELLA_TYPE = null;

  public static Symbol SYM_SDBC_REMARKS = null;

  public static Symbol SYM_SDBC_COLUMNS = null;

  public static Surrogate SGT_SDBC_COLUMN_INFO = null;

  public static Symbol SYM_STELLA_TABLE_NAME = null;

  public static Symbol SYM_SDBC_DATA_TYPE = null;

  public static Symbol SYM_SDBC_DATA_TYPE_NAME = null;

  public static Symbol SYM_SDBC_COLUMN_SIZE = null;

  public static Symbol SYM_SDBC_BUFFER_LENGTH = null;

  public static Symbol SYM_SDBC_DECIMAL_DIGITS = null;

  public static Symbol SYM_SDBC_RADIX = null;

  public static Symbol SYM_SDBC_NULLABLEp = null;

  public static Symbol SYM_SDBC_IS_NULLABLEp = null;

  public static Symbol SYM_STELLA_DOCUMENTATION = null;

  public static Symbol SYM_STELLA_DEFAULT_VALUE = null;

  public static Symbol SYM_SDBC_SQL_DATA_TYPE = null;

  public static Symbol SYM_SDBC_SQL_DATETIME_SUB = null;

  public static Symbol SYM_SDBC_CHAR_OCTET_LENGTH = null;

  public static Symbol SYM_SDBC_ORDINAL_POSITION = null;

  public final static StellaSpecialVariable $SQL_COMMAND_TEMPLATES$ = new StellaSpecialVariable();

  public static Keyword KWD_COMMAND = null;

  public static Keyword KWD_DATA_SOURCE = null;

  public static Keyword KWD_SQL = null;

  public static Keyword KWD_OTHERWISE = null;

  public static String $SQL_CMD_TEMPLATE_VARIABLE_PREFIX$ = "#$";

  public static Surrogate SGT_STELLA_CONS = null;

  public static Keyword KWD_DIGIT = null;

  public static Keyword KWD_CONNECTIONSTRING = null;

  public static Symbol SYM_SDBC_STARTUP_SDBC = null;

  public static Symbol SYM_STELLA_METHOD_STARTUP_CLASSNAME = null;

  public static Symbol SYM_SDBC_STARTUP_SDBC_SYSTEM = null;

  /** Create a connection to a database.  Currently-supported parameters
   * are (values need to be strings):
   *   :PROTOCOL          - &quot;ODBC&quot;, &quot;JDBC&quot;, &quot;CLSQL&quot; or &quot;MYSQL&quot; (defaults to &quot;ODBC&quot;)
   *   :SERVER-TYPE       - Type of database server (for JDBC strings)
   *   :DSN               - Name of ODBC Datasource
   *   :DB-NAME           - Name of physical database
   *   :USER              - Database user id.
   *   :PASSWORD          - Database password
   *   :HOST              - Host database server runs on
   *   :PORT              - Port to use to connect to the server
   *   :CONNECTION-STRING - Connection string to be used by ODBC or JDBC drivers
   *                        instead of DSN, USER, PASSWORD, etc.
   * A DATABASE-EXCEPTION is thrown if the connection is unsuccessful.
   * @param keysAndValues
   * @return Connection
   */
  public static Connection connect(Cons keysAndValues) {
    return (Sdbc.callConnect(keysAndValues));
  }

  public static Connection connectEvaluatorWrapper(Cons arguments) {
    return (Sdbc.connect(arguments));
  }

  /** Functional interface to <code>connect</code>.  See its documentation
   * @param keysAndValues
   * @return Connection
   */
  public static Connection callConnect(Cons keysAndValues) {
    { Connection result = Connection.newConnection();
      edu.isi.sdbc.NativeConnection nativeconnection = null;
      PropertyList options = Stella_Object.vetOptions(keysAndValues, Stella.getQuotedTree("((:PROTOCOL :SERVER-TYPE :DSN :DB-NAME :USER :PASSWORD :HOST :PORT :CONNECTION-STRING) \"/SDBC\")", "/SDBC"));

      { Stella_Object temp000 = options.lookup(Sdbc.KWD_PROTOCOL);

        { String protocol = Native.stringUpcase(((temp000 != null) ? ((StringWrapper)(temp000)).wrapperValue : "JDBC"));
          String serverType = StringWrapper.unwrapString(((StringWrapper)(options.lookup(Sdbc.KWD_SERVER_TYPE))));
          String connectionstring = null;

          if (Stella.stringEqlP(protocol, "CLSQL")) {
            nativeconnection = null;
          }
          else if (Stella.stringEqlP(protocol, "ODBC")) {
            connectionstring = Sdbc.makeOdbcConnectionString(options);
            nativeconnection = null;
          }
          else if (Stella.stringEqlP(protocol, "JDBC")) {
            connectionstring = Sdbc.makeJdbcConnectionString(options);
            nativeconnection = SDBCSupport.getConnection(connectionstring);
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("Database Error: unsupported protocol `" + protocol + "'");
              throw ((DatabaseException)(DatabaseException.newDatabaseException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
          if (nativeconnection == null) {
            { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

              stream001.nativeStream.print("Database Error: `" + protocol + "' not supported in `" + "Java" + "'");
              throw ((DatabaseException)(DatabaseException.newDatabaseException(stream001.theStringReader()).fillInStackTrace()));
            }
          }
          result.nativeConnection = nativeconnection;
          result.connectionString = connectionstring;
          result.protocol = protocol;
          result.creationTime = CalendarDate.makeCurrentDateTime();
          result.lastAccessTime = result.creationTime;
          result.renewalTime = ((CalendarDate)(DateTimeObject.timeAdd(result.creationTime, TimeDuration.makeTimeDuration(0, Connection.getMaxConnectionLifetime(result) * 1000))));
          Stella.logmsg("SDBC", Sdbc.KWD_LOW, Cons.cons(StringWrapper.wrapString("Connect via "), Cons.cons(StringWrapper.wrapString(protocol), Cons.cons(StringWrapper.wrapString(": "), Cons.cons(StringWrapper.wrapString(connectionstring), Stella.NIL)))));
          return (result);
        }
      }
    }
  }

  public static int $DbConnectionRenewalInterval$Setter(int value) {
    return (Sdbc.$DB_CONNECTION_RENEWAL_INTERVAL$ = value);
  }

  public static boolean jdbcConnectionStringP(String string) {
    return (Native.stringSearch(string, "jdbc:", 0) == 0);
  }

  public static String makeJdbcConnectionString(PropertyList options) {
    if (options.lookup(Sdbc.KWD_CONNECTION_STRING) != null) {
      return (((StringWrapper)(options.lookup(Sdbc.KWD_CONNECTION_STRING))).wrapperValue);
    }
    { OutputStringStream con = OutputStringStream.newOutputStringStream();
      String value = null;

      con.nativeStream.print("jdbc:");
      { String temp000 = StringWrapper.unwrapString(((StringWrapper)(options.lookup(Sdbc.KWD_SERVER_TYPE))));

        value = Native.stringDowncase(((temp000 != null) ? temp000 : "mysql"));
      }
      con.nativeStream.print(value + ":");
      if (Stella.stringEqlP(value, "mysql")) {
        con.nativeStream.print("//");
        value = StringWrapper.unwrapString(((StringWrapper)(options.lookup(Sdbc.KWD_HOST))));
        if (value != null) {
          con.nativeStream.print(value);
        }
        { Stella_Object port = options.lookup(Sdbc.KWD_PORT);

          { Surrogate testValue000 = Stella_Object.safePrimaryType(port);

            if (Surrogate.subtypeOfStringP(testValue000)) {
              { StringWrapper port000 = ((StringWrapper)(port));

                con.nativeStream.print(":" + StringWrapper.unwrapString(port000));
              }
            }
            else if (Surrogate.subtypeOfIntegerP(testValue000)) {
              { IntegerWrapper port000 = ((IntegerWrapper)(port));

                con.nativeStream.print(":" + IntegerWrapper.unwrapInteger(port000));
              }
            }
            else {
            }
          }
        }
        con.nativeStream.print("/");
        value = StringWrapper.unwrapString(((StringWrapper)(options.lookup(Sdbc.KWD_DB_NAME))));
        if (value != null) {
          con.nativeStream.print(value);
        }
        { char separator = '?';

          { Keyword option = null;
            Stella_Object val = null;
            Cons iter000 = options.thePlist;

            loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
              option = ((Keyword)(iter000.value));
              val = iter000.rest.value;
              if (val != null) {
                if ((option == Sdbc.KWD_SERVER_TYPE) ||
                    ((option == Sdbc.KWD_DSN) ||
                     ((option == Sdbc.KWD_HOST) ||
                      ((option == Sdbc.KWD_PORT) ||
                       ((option == Sdbc.KWD_DB_NAME) ||
                        (option == Sdbc.KWD_PROTOCOL)))))) {
                  continue loop000;
                }
                else if ((option == Sdbc.KWD_USER) ||
                    (option == Sdbc.KWD_PASSWORD)) {
                  con.nativeStream.print(separator + Native.stringDowncase(option.symbolName));
                }
                else {
                  con.nativeStream.print(separator + option.symbolName + "=" + StringWrapper.unwrapString(((StringWrapper)(val))));
                }
                con.nativeStream.print("=" + StringWrapper.unwrapString(((StringWrapper)(val))));
                separator = '&';
              }
            }
          }
        }
      }
      else if (Stella.stringEqlP(value, "oracle")) {
        con.nativeStream.print("thin:");
        value = StringWrapper.unwrapString(((StringWrapper)(options.lookup(Sdbc.KWD_USER))));
        if (value != null) {
          con.nativeStream.print(value);
        }
        { String temp001 = StringWrapper.unwrapString(((StringWrapper)(options.lookup(Sdbc.KWD_PASSWORD))));

          value = ((temp001 != null) ? temp001 : "");
        }
        con.nativeStream.print("/" + value);
        { String temp002 = StringWrapper.unwrapString(((StringWrapper)(options.lookup(Sdbc.KWD_HOST))));

          value = ((temp002 != null) ? temp002 : "localhost");
        }
        con.nativeStream.print("@//" + value);
        { Stella_Object temp003 = options.lookup(Sdbc.KWD_PORT);

          { Stella_Object port = ((temp003 != null) ? temp003 : StringWrapper.wrapString("1521"));

            { Surrogate testValue001 = Stella_Object.safePrimaryType(port);

              if (Surrogate.subtypeOfStringP(testValue001)) {
                { StringWrapper port000 = ((StringWrapper)(port));

                  con.nativeStream.print(":" + StringWrapper.unwrapString(port000));
                }
              }
              else if (Surrogate.subtypeOfIntegerP(testValue001)) {
                { IntegerWrapper port000 = ((IntegerWrapper)(port));

                  con.nativeStream.print(":" + IntegerWrapper.unwrapInteger(port000));
                }
              }
              else {
                { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                  stream000.nativeStream.print("`" + testValue001 + "' is not a valid case option");
                  throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                }
              }
            }
          }
        }
        value = StringWrapper.unwrapString(((StringWrapper)(options.lookup(Sdbc.KWD_DB_NAME))));
        if (value != null) {
          con.nativeStream.print("/" + value);
        }
      }
      else {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("Don't know how to generate JDBC connection string for servers of :SERVER-TYPE `" + options.lookup(Sdbc.KWD_SERVER_TYPE) + "'");
          throw ((DatabaseException)(DatabaseException.newDatabaseException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
      return (con.theStringReader());
    }
  }

  public static boolean odbcConnectionStringP(String string) {
    return ((string.length() > 0) &&
        ((!Sdbc.jdbcConnectionStringP(string)) &&
         (Native.string_position(string, '=', 1) != Stella.NULL_INTEGER)));
  }

  public static String makeOdbcConnectionString(PropertyList options) {
    if (((StringWrapper)(options.lookup(Sdbc.KWD_CONNECTION_STRING))) != null) {
      return (((StringWrapper)(options.lookup(Sdbc.KWD_CONNECTION_STRING))).wrapperValue);
    }
    { OutputStringStream con = OutputStringStream.newOutputStringStream();

      { Keyword option = null;
        StringWrapper value = null;
        Cons iter000 = options.thePlist;

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
          option = ((Keyword)(iter000.value));
          value = ((StringWrapper)(iter000.rest.value));
          if (value != null) {
            if (option == Sdbc.KWD_USER) {
              con.nativeStream.print("UID");
            }
            else if (option == Sdbc.KWD_PASSWORD) {
              con.nativeStream.print("PWD");
            }
            else if (option == Sdbc.KWD_DB_NAME) {
              con.nativeStream.print("DATABASE");
            }
            else if (option == Sdbc.KWD_HOST) {
              con.nativeStream.print("SERVER");
            }
            else if ((option == Sdbc.KWD_PROTOCOL) ||
                (option == Sdbc.KWD_SERVER_TYPE)) {
              continue loop000;
            }
            else {
              con.nativeStream.print(option.symbolName);
            }
            con.nativeStream.print("=" + StringWrapper.unwrapString(value) + ";");
          }
        }
      }
      return (con.theStringReader());
    }
  }

  public static edu.isi.sdbc.NativeConnection clNativeOdbcConnect(String connectionstring, Object [] MV_returnarray) {
    { String errormsg = null;
      edu.isi.sdbc.NativeConnection nativeconnection = null;

      nativeconnection = nativeconnection;
      if (errormsg != null) {
        throw ((DatabaseException)(DatabaseException.newDatabaseException(errormsg).fillInStackTrace()));
      }
      { edu.isi.sdbc.NativeConnection _return_temp = nativeconnection;

        MV_returnarray[0] = StringWrapper.wrapString(connectionstring);
        return (_return_temp);
      }
    }
  }

  public static edu.isi.sdbc.NativeConnection clNativeClsqlConnect(PropertyList options, String serverType, Object [] MV_returnarray) {
    { String connectionString = StringWrapper.unwrapString(((StringWrapper)(options.lookup(Sdbc.KWD_CONNECTION_STRING))));
      String user = StringWrapper.unwrapString(((StringWrapper)(options.lookup(Sdbc.KWD_USER))));
      String password = StringWrapper.unwrapString(((StringWrapper)(options.lookup(Sdbc.KWD_PASSWORD))));
      String dbName = StringWrapper.unwrapString(((StringWrapper)(options.lookup(Sdbc.KWD_DB_NAME))));
      String host = StringWrapper.unwrapString(((StringWrapper)(options.lookup(Sdbc.KWD_HOST))));
      String errorMessage = null;
      edu.isi.sdbc.NativeConnection nativeConnection = null;

      nativeConnection = nativeConnection;
      if (errorMessage != null) {
        throw ((DatabaseException)(DatabaseException.newDatabaseException(errorMessage).fillInStackTrace()));
      }
      { edu.isi.sdbc.NativeConnection _return_temp = nativeConnection;

        MV_returnarray[0] = StringWrapper.wrapString(connectionString);
        return (_return_temp);
      }
    }
  }

  public static void clNativeDisconnect(edu.isi.sdbc.NativeConnection nativeConnection) {
  }

  public static void clNativeOdbcDisconnect(edu.isi.sdbc.NativeConnection nativeconnection) {
    { String errormsg = null;

      nativeconnection = nativeconnection;
      if (errormsg != null) {
        throw ((DatabaseException)(DatabaseException.newDatabaseException(errormsg).fillInStackTrace()));
      }
    }
  }

  public static void clNativeClsqlDisconnect(edu.isi.sdbc.NativeConnection nativeConnection) {
    { String errorMsg = null;

      nativeConnection = nativeConnection;
      if (errorMsg != null) {
        throw ((DatabaseException)(DatabaseException.newDatabaseException(errorMsg).fillInStackTrace()));
      }
    }
  }

  /** Return <code>true</code> if <code>sqlExpression</code> is a SQL command string which returns
   * values.
   * @param sqlExpression
   * @return boolean
   */
  static boolean sqlQueryP(String sqlExpression) {
    { int start = 0;
      int end = 0;
      String operator = "";

      while (Stella.$CHARACTER_TYPE_TABLE$[(int) (sqlExpression.charAt(start))] == Sdbc.KWD_WHITE_SPACE) {
        start = start + 1;
      }
      end = start;
      while (Stella.$CHARACTER_TYPE_TABLE$[(int) (sqlExpression.charAt(end))] == Sdbc.KWD_LETTER) {
        end = end + 1;
      }
      operator = Native.string_subsequence(sqlExpression, start, end);
      return (Stella.stringEqualP(operator, "SELECT") ||
          (Stella.stringEqualP(operator, "SHOW") ||
           (Stella.stringEqualP(operator, "DESCRIBE") ||
            (Stella.stringEqualP(operator, "EXPLAIN") ||
             Stella.stringEqualP(operator, "ANALYZE")))));
    }
  }

  /** Convert a Lisp object into a STELLA object.
   * @param self
   * @return Stella_Object
   */
  public static Stella_Object stellifyWithNilToNull(Stella_Object self) {
    { Stella_Object result = self;

      return (result);
    }
  }

  public static Stella_Object clTranslateSqlParameterTypeSpecifier(Stella_Object stellatype) {
    { Stella_Object result = null;

      if ((stellatype == null) ||
          (stellatype == Sdbc.SYM_STELLA_NULL)) {
      }
      else {
        { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(stellatype));

          if (testValue000 == Sdbc.SGT_STELLA_CALENDAR_DATE) {
          }
          else if (testValue000 == Sdbc.SGT_STELLA_STRING) {
          }
          else if (testValue000 == Sdbc.SGT_STELLA_INTEGER) {
          }
          else if (testValue000 == Sdbc.SGT_STELLA_LONG_INTEGER) {
          }
          else if (testValue000 == Sdbc.SGT_STELLA_DOUBLE_FLOAT) {
          }
          else {
          }
        }
      }
      return (result);
    }
  }

  public static Stella_Object clTranslateSqlTypeSpecifier(Stella_Object stellatype) {
    { Stella_Object result = null;

      if ((stellatype == null) ||
          (stellatype == Sdbc.SYM_STELLA_NULL)) {
      }
      else {
        { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(stellatype));

          if (testValue000 == Sdbc.SGT_STELLA_CALENDAR_DATE) {
          }
          else if (testValue000 == Sdbc.SGT_STELLA_STRING) {
          }
          else if (testValue000 == Sdbc.SGT_STELLA_INTEGER) {
          }
          else if (testValue000 == Sdbc.SGT_STELLA_LONG_INTEGER) {
          }
          else if (testValue000 == Sdbc.SGT_STELLA_DOUBLE_FLOAT) {
          }
          else {
          }
        }
      }
      return (result);
    }
  }

  public static Cons clTranslateSqlTypeSpecifiers(Cons stellatypes) {
    { Cons value000 = Stella.NIL;

      { Stella_Object type = null;
        Cons iter000 = stellatypes;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          type = iter000.value;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Sdbc.clTranslateSqlTypeSpecifier(type), Stella.NIL);
              if (value000 == Stella.NIL) {
                value000 = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(value000, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Sdbc.clTranslateSqlTypeSpecifier(type), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      { Cons value001 = value000;

        return (value001);
      }
    }
  }

  public static Stella_Object executeSqlEvaluatorWrapper(Cons arguments) {
    return (Connection.executeSql(((Connection)(arguments.value)), arguments.rest.value, arguments.rest.rest));
  }

  public static Stella_Object clExecuteSql(edu.isi.sdbc.NativeConnection connection, String sql, Cons types) {
    return (null);
  }

  public static Stella_Object clDoExecutePreparedStatement(edu.isi.sdbc.NativeConnection connection, PreparedStatement sql) {
    sql = sql;
    return (null);
  }

  public static edu.isi.sdbc.ResultSet clGetNativeResultSet(edu.isi.sdbc.NativeConnection connection, String sql, Cons types) {
    return (null);
  }

  public static String sqlEscapeString(String value, char quotechar) {
    { int cursor = value.length() - 1;

      while (cursor >= 0) {
        if (value.charAt(cursor) == quotechar) {
          return (Stella.replaceSubstrings(value, Native.makeString(2, quotechar), Native.makeString(1, quotechar)));
        }
        cursor = cursor - 1;
      }
      return (value);
    }
  }

  public static char sqlQuoteCharacter(Keyword dbmsName, Keyword lexicaltype) {
    if (lexicaltype == Sdbc.KWD_STRING_CONSTANT) {
      return ('\'');
    }
    else if (lexicaltype == Sdbc.KWD_IDENTIFIER) {
      if (dbmsName == Sdbc.KWD_MYSQL) {
        return ('`');
      }
      else {
        return ('"');
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + lexicaltype + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static void printValueList(OutputStream stream, Cons values, char quotechar) {
    { Stella_Object value = null;
      Cons iter000 = values;
      int i = Stella.NULL_INTEGER;
      int iter001 = 1;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
        value = iter000.value;
        i = iter001;
        if (i > 1) {
          stream.nativeStream.print(",");
        }
        if ((value == null) ||
            ((value == Sdbc.SYM_STELLA_NULL) ||
             (value == Sdbc.KWD_NULL))) {
          stream.nativeStream.print("NULL");
        }
        else if ((value == Sdbc.SYM_STELLA_DEFAULT) ||
            (value == Sdbc.KWD_DEFAULT)) {
          stream.nativeStream.print("DEFAULT");
        }
        else {
          { Surrogate testValue000 = Stella_Object.safePrimaryType(value);

            if (Surrogate.subtypeOfIntegerP(testValue000)) {
              { IntegerWrapper value000 = ((IntegerWrapper)(value));

                stream.nativeStream.print(value000.wrapperValue);
              }
            }
            else if (Surrogate.subtypeOfFloatP(testValue000)) {
              { FloatWrapper value000 = ((FloatWrapper)(value));

                stream.nativeStream.print(value000.wrapperValue);
              }
            }
            else if (Surrogate.subtypeOfVerbatimStringP(testValue000)) {
              { VerbatimStringWrapper value000 = ((VerbatimStringWrapper)(value));

                stream.nativeStream.print(value000.wrapperValue);
              }
            }
            else if (Surrogate.subtypeOfStringP(testValue000)) {
              { StringWrapper value000 = ((StringWrapper)(value));

                stream.nativeStream.print(quotechar + Sdbc.sqlEscapeString(value000.wrapperValue, quotechar) + quotechar);
              }
            }
            else {
              stream.nativeStream.print(quotechar + Sdbc.sqlEscapeString(Native.stringify(value), quotechar) + quotechar);
            }
          }
        }
      }
    }
  }

  public static void insertRowEvaluatorWrapper(Cons arguments) {
    Connection.insertRow(((Connection)(arguments.value)), ((StringWrapper)(arguments.rest.value)).wrapperValue, ((Cons)(arguments.rest.rest.value)), ((Cons)(arguments.rest.rest.rest.value)));
  }

  public static void insertRowsEvaluatorWrapper(Cons arguments) {
    Connection.insertRows(((Connection)(arguments.value)), ((StringWrapper)(arguments.rest.value)).wrapperValue, ((Cons)(arguments.rest.rest.value)), ((Cons)(arguments.rest.rest.rest.value)));
  }

  public static Cons coerceUncoercedValuesInTable(Cons table, Cons types) {
    if (types == null) {
      return (table);
    }
    { Cons result = Stella.NIL;

      { Stella_Object row = null;
        Cons iter000 = table;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          row = iter000.value;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Sdbc.coerceUncoercedColumnValues(((Cons)(row)), types), Stella.NIL);
              if (result == Stella.NIL) {
                result = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(result, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Sdbc.coerceUncoercedColumnValues(((Cons)(row)), types), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (result);
    }
  }

  public static Cons coerceUncoercedColumnValues(Cons row, Cons types) {
    if (types == null) {
      return (row);
    }
    { Cons result = Stella.NIL;

      { Stella_Object value = null;
        Cons iter000 = row;
        Stella_Object type = null;
        Cons iter001 = types;
        Cons collect000 = null;

        for (;(!(iter000 == Stella.NIL)) &&
                  (!(iter001 == Stella.NIL)); iter000 = iter000.rest, iter001 = iter001.rest) {
          value = iter000.value;
          type = iter001.value;
          if (collect000 == null) {
            {
              collect000 = Cons.cons((Stella_Object.stringP(value) ? Sdbc.convertStringToTypedObject(((StringWrapper)(value)).wrapperValue, ((GeneralizedSymbol)(type))) : value), Stella.NIL);
              if (result == Stella.NIL) {
                result = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(result, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons((Stella_Object.stringP(value) ? Sdbc.convertStringToTypedObject(((StringWrapper)(value)).wrapperValue, ((GeneralizedSymbol)(type))) : value), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (result);
    }
  }

  public static Stella_Object convertStringToTypedObject(String valuestring, GeneralizedSymbol typespec) {
    if (typespec == Sdbc.SGT_STELLA_CALENDAR_DATE) {
      return (CalendarDate.stringToCalendarDate(valuestring));
    }
    else {
      return (StringWrapper.wrapString(valuestring));
    }
  }

  public static PreparedStatement prepareStatementEvaluatorWrapper(Cons arguments) {
    return (Connection.prepareStatement(((Connection)(arguments.value)), ((StringWrapper)(arguments.rest.value)).wrapperValue));
  }

  public static void bindParameterEvaluatorWrapper(Cons arguments) {
    PreparedStatement.bindParameter(((PreparedStatement)(arguments.value)), ((IntegerWrapper)(arguments.rest.value)).wrapperValue, ((Surrogate)(arguments.rest.rest.value)), arguments.rest.rest.rest.value);
  }

  public static void setAutoCommitEvaluatorWrapper(Cons arguments) {
    Connection.setAutoCommit(((Connection)(arguments.value)), ((BooleanWrapper)(arguments.rest.value)).wrapperValue);
  }

  public static Cons getTablesEvaluatorWrapper(Cons arguments) {
    return (Connection.getTables(((Connection)(arguments.value)), ((StringWrapper)(arguments.rest.value)).wrapperValue, ((StringWrapper)(arguments.rest.rest.value)).wrapperValue, ((StringWrapper)(arguments.rest.rest.rest.value)).wrapperValue, ((StringWrapper)(arguments.rest.rest.rest.rest.value)).wrapperValue));
  }

  public static Cons getColumnsEvaluatorWrapper(Cons arguments) {
    return (Connection.getColumns(((Connection)(arguments.value)), ((StringWrapper)(arguments.rest.value)).wrapperValue, ((StringWrapper)(arguments.rest.rest.value)).wrapperValue, ((StringWrapper)(arguments.rest.rest.rest.value)).wrapperValue, ((StringWrapper)(arguments.rest.rest.rest.rest.value)).wrapperValue));
  }

  public static Wrapper getServerInfoEvaluatorWrapper(Cons arguments) {
    return (Connection.getServerInfo(((Connection)(arguments.value)), ((StringWrapper)(arguments.rest.value)).wrapperValue));
  }

  public static void printTable(Stella_Object table) {
    if (table == null) {
      return;
    }
    { Cons constable = ((Cons)(table));

      { Cons row = null;
        Cons iter000 = constable;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          row = ((Cons)(iter000.value));
          Stella.STANDARD_OUTPUT.nativeStream.println("row = " + row);
        }
      }
    }
  }

  public static String calendarDateToSqlString(CalendarDate date) {
    return (date.calendarDateToString(0.0, true, false));
  }

  public static void loadSqlCmdTemplates(String file) {
    { InputFileStream in = null;

      try {
        in = Stella.openInputFile(file, Stella.NIL);
        { Stella_Object command = null;
          SExpressionIterator iter000 = InputStream.sExpressions(in);

          while (iter000.nextP()) {
            command = iter000.value;
            { PropertyList self000 = PropertyList.newPropertyList();

              self000.thePlist = ((Cons)(command));
              Sdbc.insertSqlCommandTemplate(self000);
            }
          }
        }

      } finally {
        if (in != null) {
          in.free();
        }
      }
    }
  }

  public static void insertSqlCommandTemplate(PropertyList template) {
    { Stella_Object commandname = template.lookup(Sdbc.KWD_COMMAND);

      { Stella_Object temp000 = template.lookup(Sdbc.KWD_DATA_SOURCE);

        { Cons datasources = (((temp000 != null) ? temp000 : Sdbc.KWD_DEFAULT)).consify();
          Stella_Object sql = template.lookup(Sdbc.KWD_SQL);
          KeyValueList templates = ((KeyValueList)(((KeyValueMap)(Sdbc.$SQL_COMMAND_TEMPLATES$.get())).lookup(commandname)));

          if (commandname == null) {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("Missing :command name in SQL template: `" + template + "'");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
          if (!(Stella_Object.stringP(sql))) {
            { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

              {
                stream001.nativeStream.println("Illegal or missing :sql specification in SQL template: `" + sql + "'");
                stream001.nativeStream.print("   String expected.");
              }
;
              throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
            }
          }
          if (templates == null) {
            templates = KeyValueList.newKeyValueList();
            ((KeyValueMap)(Sdbc.$SQL_COMMAND_TEMPLATES$.get())).insertAt(commandname, templates);
          }
          { Stella_Object datasource = null;
            Cons iter000 = datasources;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              datasource = iter000.value;
              if (datasource == Sdbc.KWD_OTHERWISE) {
                datasource = Sdbc.KWD_DEFAULT;
              }
              templates.insertAt(datasource, template);
            }
          }
        }
      }
    }
  }

  public static PropertyList lookupSqlCmdTemplate(Stella_Object commandname, Stella_Object datasource) {
    { KeyValueList templates = ((KeyValueList)(((KeyValueMap)(Sdbc.$SQL_COMMAND_TEMPLATES$.get())).lookup(commandname)));
      PropertyList template = null;

      if (templates == null) {
        return (null);
      }
      template = ((PropertyList)(templates.lookup(((datasource != null) ? datasource : Sdbc.KWD_DEFAULT))));
      if (template == null) {
        return (((PropertyList)(templates.lookup(Sdbc.KWD_DEFAULT))));
      }
      else {
        return (template);
      }
    }
  }

  public static String instantiateSqlCmd(Stella_Object cmdname, Stella_Object datasource, Cons varsAvalues) {
    { PropertyList template = Sdbc.lookupSqlCmdTemplate(cmdname, datasource);
      KeyValueList variables = KeyValueList.newKeyValueList();
      StringWrapper key = null;

      if (template == null) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Undefined SQL command template: `" + cmdname + "'");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      { String item = null;
        Cons iter000 = varsAvalues;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          item = ((StringWrapper)(iter000.value)).wrapperValue;
          if (key != null) {
            variables.insertAt(key, ((item == null) ? null : StringWrapper.wrapString(item)));
            key = null;
          }
          else {
            key = StringWrapper.wrapString(item);
          }
        }
      }
      return (Sdbc.instantiateSqlCmdTemplate(((StringWrapper)(template.lookup(Sdbc.KWD_SQL))).wrapperValue, variables));
    }
  }

  public static String instantiateSqlCmdTemplate(String template, KeyValueList variables) {
    { String prefix = Sdbc.$SQL_CMD_TEMPLATE_VARIABLE_PREFIX$;
      int prefixlength = prefix.length();
      int cursor = 0;
      int variablestart = 0;
      int length = template.length();
      OutputStringStream result = null;
      String variable = null;

      if (Native.stringSearch(template, prefix, Stella.NULL_INTEGER) == Stella.NULL_INTEGER) {
        return (template);
      }
      result = OutputStringStream.newOutputStringStream();
      loop000 : for (;;) {
        variablestart = Native.stringSearch(template, prefix, cursor);
        result.nativeStream.print(Native.string_subsequence(template, cursor, variablestart));
        if (variablestart == Stella.NULL_INTEGER) {
          break loop000;
        }
        { Object [] caller_MV_returnarray = new Object[1];

          variable = Sdbc.readSqlCmdTemplateVariable(template, variablestart + prefixlength, length, caller_MV_returnarray);
          cursor = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
        }
        result.nativeStream.print(Sdbc.instantiateSqlCmdTemplateVariable(variable, variables));
      }
      return (result.theStringReader());
    }
  }

  public static String readSqlCmdTemplateVariable(String template, int start, int end, Object [] MV_returnarray) {
    { int cursor = start;
      boolean escapedP = false;

      if ((cursor >= end) ||
          (!(template.charAt(cursor) == '{'))) {
      }
      else {
        loop000 : while (cursor < end) {
          { char c = template.charAt(cursor);

            if (c == '\\') {
              escapedP = true;
              cursor = cursor + 1;
            }
            else if (c == '}') {
              break loop000;
            }
            else {
            }
            cursor = cursor + 1;
          }
        }
        if (cursor < end) {
          if (escapedP) {
            { String _return_temp = Stella.unescapeTokenString(Native.string_subsequence(template, start + 1, cursor), '\\', false);

              MV_returnarray[0] = IntegerWrapper.wrapInteger(cursor + 1);
              return (_return_temp);
            }
          }
          else {
            { String _return_temp = Native.string_subsequence(template, start + 1, cursor);

              MV_returnarray[0] = IntegerWrapper.wrapInteger(cursor + 1);
              return (_return_temp);
            }
          }
        }
      }
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        {
          stream000.nativeStream.println("Illegal template variable syntax at position `" + cursor + "' in");
          stream000.nativeStream.println();
          stream000.nativeStream.print("    `" + template + "'");
        }
;
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static String instantiateSqlCmdTemplateVariable(String templatevariable, KeyValueList variables) {
    { int start = 0;
      String quotes = "'`\"";
      char quote = Stella.NULL_CHARACTER;

      { StringWrapper var = null;
        Stella_Object value = null;
        KvCons iter000 = variables.theKvList;

        for (;iter000 != null; iter000 = iter000.rest) {
          var = ((StringWrapper)(iter000.key));
          value = iter000.value;
          start = Native.stringSearch(templatevariable, var.wrapperValue, 0);
          if (start != Stella.NULL_INTEGER) {
            { String varspec = null;
              int from = Stella.NULL_INTEGER;
              int to = Stella.NULL_INTEGER;
              String renamed_Default = null;

              { Object [] caller_MV_returnarray = new Object[3];

                varspec = Sdbc.parseSqlCmdTemplateVariableRangeAndDefault(templatevariable, var.wrapperValue, start, caller_MV_returnarray);
                from = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
                to = ((int)(((IntegerWrapper)(caller_MV_returnarray[1])).wrapperValue));
                renamed_Default = ((String)(((StringWrapper)(caller_MV_returnarray[2])).wrapperValue));
              }
              if ((start > 0) &&
                  Native.string_memberP(quotes, templatevariable.charAt((start - 1)))) {
                quote = templatevariable.charAt((start - 1));
              }
              { Surrogate testValue000 = Stella_Object.safePrimaryType(value);

                if (Surrogate.subtypeOfStringP(testValue000)) {
                  { StringWrapper value000 = ((StringWrapper)(value));

                    if ((StringWrapper.unwrapString(value000) == null) ||
                        (from > 0)) {
                      return (renamed_Default);
                    }
                    if (quote != Stella.NULL_CHARACTER) {
                      value000 = StringWrapper.wrapString(Sdbc.sqlEscapeString(value000.wrapperValue, quote));
                    }
                    return (Stella.replaceSubstrings(templatevariable, value000.wrapperValue, varspec));
                  }
                }
                else if (testValue000 == Sdbc.SGT_STELLA_CONS) {
                  { Cons value000 = ((Cons)(value));

                    if ((value000 == Stella.NIL) ||
                        (from >= value000.length())) {
                      return (renamed_Default);
                    }
                    else {
                      { OutputStringStream result = OutputStringStream.newOutputStringStream();

                        { StringWrapper elt = null;
                          Cons iter001 = ((Cons)(value000));
                          int i = Stella.NULL_INTEGER;
                          int iter002 = 0;

                          for (;!(iter001 == Stella.NIL); iter001 = iter001.rest, iter002 = iter002 + 1) {
                            elt = ((StringWrapper)(iter001.value));
                            i = iter002;
                            if ((i >= from) &&
                                ((to == Stella.NULL_INTEGER) ||
                                 (i <= to))) {
                              if (quote != Stella.NULL_CHARACTER) {
                                elt = StringWrapper.wrapString(Sdbc.sqlEscapeString(elt.wrapperValue, quote));
                              }
                              result.nativeStream.print(Stella.replaceSubstrings(templatevariable, elt.wrapperValue, varspec));
                            }
                          }
                        }
                        return (result.theStringReader());
                      }
                    }
                  }
                }
                else {
                  return (renamed_Default);
                }
              }
            }
          }
        }
      }
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("Undefined template variable: `" + templatevariable + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static String parseSqlCmdTemplateVariableRangeAndDefault(String templatevariable, String variablename, int start, Object [] MV_returnarray) {
    { int variablestart = start;
      int end = templatevariable.length();
      int startidx = 0;
      int endidx = 0;
      String renamed_Default = "1=1";
      int cursor = 0;
      Cons range = Stella.NIL;
      String element = null;
      int nofelements = 0;

      start = start + variablename.length();
      if ((start >= end) ||
          (!(templatevariable.charAt(start) == '['))) {
        { String _return_temp = variablename;

          MV_returnarray[0] = IntegerWrapper.wrapInteger(startidx);
          MV_returnarray[1] = IntegerWrapper.wrapInteger(endidx);
          MV_returnarray[2] = StringWrapper.wrapString(renamed_Default);
          return (_return_temp);
        }
      }
      start = start + 1;
      end = Native.string_position(templatevariable, ']', start);
      if (end == Stella.NULL_INTEGER) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Missing right parenthesis in template variable range: `" + templatevariable + "'");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      cursor = start;
      while (cursor < end) {
        if ((templatevariable.charAt(cursor) == ',') &&
            (nofelements < 2)) {
          range = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(templatevariable, start, cursor)), range);
          nofelements = nofelements + 1;
          cursor = cursor + 1;
          start = cursor;
        }
        else {
          cursor = cursor + 1;
        }
      }
      nofelements = nofelements + 1;
      range = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(templatevariable, start, cursor)), range);
      { StringWrapper elt = null;
        Cons iter000 = range.reverse();
        int i = Stella.NULL_INTEGER;
        int iter001 = 1;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
          elt = ((StringWrapper)(iter000.value));
          i = iter001;
          element = elt.wrapperValue;
          switch (i) {
            case 1: 
              if (i == nofelements) {
                {
                  if (Stella.stringEqlP(element, "")) {
                    {
                      renamed_Default = element;
                    }
                  }
                  else {
                    { boolean alwaysP000 = true;

                      { char renamed_Char = Stella.NULL_CHARACTER;
                        String vector000 = element;
                        int index000 = 0;
                        int length000 = vector000.length();

                        loop002 : for (;index000 < length000; index000 = index000 + 1) {
                          renamed_Char = vector000.charAt(index000);
                          if (!(Stella.$CHARACTER_TYPE_TABLE$[(int) renamed_Char] == Sdbc.KWD_DIGIT)) {
                            alwaysP000 = false;
                            break loop002;
                          }
                        }
                      }
                      if (alwaysP000) {
                        {
                          startidx = ((int)(Native.stringToInteger(element)));
                          endidx = startidx;
                        }
                      }
                      else {
                        {
                          renamed_Default = element;
                        }
                      }
                    }
                  }
                }
              }
              else {
                { boolean alwaysP001 = true;

                  { char renamed_Char = Stella.NULL_CHARACTER;
                    String vector001 = element;
                    int index001 = 0;
                    int length001 = vector001.length();

                    loop003 : for (;index001 < length001; index001 = index001 + 1) {
                      renamed_Char = vector001.charAt(index001);
                      if (!(Stella.$CHARACTER_TYPE_TABLE$[(int) renamed_Char] == Sdbc.KWD_DIGIT)) {
                        alwaysP001 = false;
                        break loop003;
                      }
                    }
                  }
                  if (alwaysP001) {
                    {
                      startidx = ((int)(Native.stringToInteger(element)));
                      endidx = startidx;
                    }
                  }
                  else {
                    {
                      { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                        stream001.nativeStream.print("Illegal template variable range: `" + templatevariable + "'");
                        throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
                      }
                    }
                  }
                }
              }
            break;
            case 2: 
              if (i == nofelements) {
                {
                  if (Stella.stringEqlP(element, "")) {
                    {
                      renamed_Default = element;
                    }
                  }
                  else {
                    if (Stella.stringEqlP(element, ":")) {
                      {
                        endidx = Stella.NULL_INTEGER;
                      }
                    }
                    else {
                      { boolean alwaysP002 = true;

                        { char renamed_Char = Stella.NULL_CHARACTER;
                          String vector002 = element;
                          int index002 = 0;
                          int length002 = vector002.length();

                          loop004 : for (;index002 < length002; index002 = index002 + 1) {
                            renamed_Char = vector002.charAt(index002);
                            if (!(Stella.$CHARACTER_TYPE_TABLE$[(int) renamed_Char] == Sdbc.KWD_DIGIT)) {
                              alwaysP002 = false;
                              break loop004;
                            }
                          }
                        }
                        if (alwaysP002) {
                          {
                            endidx = ((int)(Native.stringToInteger(element)));
                          }
                        }
                        else {
                          {
                            renamed_Default = element;
                          }
                        }
                      }
                    }
                  }
                }
              }
              else {
                if (Stella.stringEqlP(element, "")) {
                  {
                    endidx = startidx;
                  }
                }
                else {
                  if (Stella.stringEqlP(element, ":")) {
                    {
                      endidx = Stella.NULL_INTEGER;
                    }
                  }
                  else {
                    { boolean alwaysP003 = true;

                      { char renamed_Char = Stella.NULL_CHARACTER;
                        String vector003 = element;
                        int index003 = 0;
                        int length003 = vector003.length();

                        loop005 : for (;index003 < length003; index003 = index003 + 1) {
                          renamed_Char = vector003.charAt(index003);
                          if (!(Stella.$CHARACTER_TYPE_TABLE$[(int) renamed_Char] == Sdbc.KWD_DIGIT)) {
                            alwaysP003 = false;
                            break loop005;
                          }
                        }
                      }
                      if (alwaysP003) {
                        {
                          endidx = ((int)(Native.stringToInteger(element)));
                        }
                      }
                      else {
                        {
                          { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                            stream002.nativeStream.print("Illegal template variable range: `" + templatevariable + "'");
                            throw ((StellaException)(StellaException.newStellaException(stream002.theStringReader()).fillInStackTrace()));
                          }
                        }
                      }
                    }
                  }
                }
              }
            break;
            case 3: 
              renamed_Default = element;
            break;
            default:
              { OutputStringStream stream003 = OutputStringStream.newOutputStringStream();

                stream003.nativeStream.print("`" + i + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream003.theStringReader()).fillInStackTrace()));
              }
          }
        }
      }
      { String _return_temp = Native.string_subsequence(templatevariable, variablestart, end + 1);

        MV_returnarray[0] = IntegerWrapper.wrapInteger(startidx);
        MV_returnarray[1] = IntegerWrapper.wrapInteger(endidx);
        MV_returnarray[2] = StringWrapper.wrapString(renamed_Default);
        return (_return_temp);
      }
    }
  }

  public static void testPreparedStatement() {
    try {
      { Connection con = Sdbc.connect(Cons.cons(Sdbc.KWD_DSN, Cons.cons(StringWrapper.wrapString("myodbc3"), Cons.cons(Sdbc.KWD_USER, Cons.cons(StringWrapper.wrapString("scott"), Cons.cons(Sdbc.KWD_PASSWORD, Cons.cons(StringWrapper.wrapString("tiger"), Cons.cons(Sdbc.KWD_CONNECTIONSTRING, Cons.cons(StringWrapper.wrapString("jdbc:mysql://localhost:3306/menagerie?user=scott&password=tiger"), Stella.NIL)))))))));
        String preparedsql = "insert into customer4 values (?, ?, ?, ?)";
        String selectsql = "select * from customer4";
        PreparedStatement preparedstatement = null;
        Cons result = null;

        Stella.STANDARD_OUTPUT.nativeStream.println("Table before executing prepared statement:");
        Sdbc.printTable(Connection.executeSql(con, StringWrapper.wrapString(selectsql), Stella.NIL));
        preparedstatement = Connection.prepareStatement(con, preparedsql);
        PreparedStatement.bindParameter(preparedstatement, 1, Sdbc.SGT_STELLA_INTEGER, IntegerWrapper.wrapInteger(23));
        PreparedStatement.bindParameter(preparedstatement, 2, Sdbc.SGT_STELLA_STRING, StringWrapper.wrapString("k"));
        PreparedStatement.bindParameter(preparedstatement, 3, Sdbc.SGT_STELLA_DOUBLE_FLOAT, FloatWrapper.wrapFloat(5.3));
        PreparedStatement.bindParameter(preparedstatement, 4, Sdbc.SGT_STELLA_CALENDAR_DATE, CalendarDate.stringToCalendarDate("1997-02-14"));
        result = ((Cons)(Connection.executeSql(con, preparedstatement, Stella.NIL)));
        PreparedStatement.bindParameter(preparedstatement, 1, Sdbc.SGT_STELLA_INTEGER, IntegerWrapper.wrapInteger(24));
        PreparedStatement.bindParameter(preparedstatement, 2, Sdbc.SGT_STELLA_STRING, null);
        PreparedStatement.bindParameter(preparedstatement, 3, Sdbc.SGT_STELLA_DOUBLE_FLOAT, null);
        PreparedStatement.bindParameter(preparedstatement, 4, Sdbc.SGT_STELLA_CALENDAR_DATE, null);
        result = ((Cons)(Connection.executeSql(con, preparedstatement, Stella.NIL)));
        Stella.STANDARD_OUTPUT.nativeStream.println("Table after executing prepared statements:");
        Sdbc.printTable(Connection.executeSql(con, StringWrapper.wrapString(selectsql), Stella.NIL));
      }
    } catch (DatabaseException e) {
      Stella.STANDARD_OUTPUT.nativeStream.println("Caught Database Exception: " + Stella.exceptionMessage(e));
    }
  }

  public static void testTransactions() {
    Stella.STANDARD_OUTPUT.nativeStream.println("testing transactions...");
    try {
      { Connection con = Sdbc.connect(Cons.cons(Sdbc.KWD_DSN, Cons.cons(StringWrapper.wrapString("myodbc3"), Cons.cons(Sdbc.KWD_USER, Cons.cons(StringWrapper.wrapString("scott"), Cons.cons(Sdbc.KWD_PASSWORD, Cons.cons(StringWrapper.wrapString("tiger"), Cons.cons(Sdbc.KWD_CONNECTIONSTRING, Cons.cons(StringWrapper.wrapString("jdbc:mysql://localhost:3306/menagerie?user=scott&password=tiger"), Stella.NIL)))))))));
        String selectsql = "select * from customer2";
        String insertsql1 = "insert into customer2 values (28, 'aa')";
        String insertsql2 = "insert into customer2 values (29, 'z')";

        Connection.setAutoCommit(con, false);
        Stella.STANDARD_OUTPUT.nativeStream.println("Table before insert:");
        Sdbc.printTable(Connection.executeSql(con, StringWrapper.wrapString(selectsql), Stella.NIL));
        Connection.executeSql(con, StringWrapper.wrapString(insertsql1), Stella.NIL);
        Stella.STANDARD_OUTPUT.nativeStream.println("Table after insert1:");
        Sdbc.printTable(Connection.executeSql(con, StringWrapper.wrapString(selectsql), Stella.NIL));
        Connection.commit(con);
        Stella.STANDARD_OUTPUT.nativeStream.println("Table after commit:");
        Sdbc.printTable(Connection.executeSql(con, StringWrapper.wrapString(selectsql), Stella.NIL));
        Connection.executeSql(con, StringWrapper.wrapString(insertsql2), Stella.NIL);
        Stella.STANDARD_OUTPUT.nativeStream.println("Table after insert2:");
        Sdbc.printTable(Connection.executeSql(con, StringWrapper.wrapString(selectsql), Stella.NIL));
        Connection.rollback(con);
        Stella.STANDARD_OUTPUT.nativeStream.println("Table after rollback:");
        Sdbc.printTable(Connection.executeSql(con, StringWrapper.wrapString(selectsql), Stella.NIL));
        Connection.disconnect(con);
      }
    } catch (DatabaseException e) {
      Stella.STANDARD_OUTPUT.nativeStream.println("Caught Database Exception: " + Stella.exceptionMessage(e));
    }
  }

  public static void testResultSet() {
    Stella.STANDARD_OUTPUT.nativeStream.println("Testing result set...");
    try {
      { Connection con = Sdbc.connect(Cons.cons(Sdbc.KWD_DSN, Cons.cons(StringWrapper.wrapString("myodbc3"), Cons.cons(Sdbc.KWD_USER, Cons.cons(StringWrapper.wrapString("scott"), Cons.cons(Sdbc.KWD_PASSWORD, Cons.cons(StringWrapper.wrapString("tiger"), Cons.cons(Sdbc.KWD_CONNECTIONSTRING, Cons.cons(StringWrapper.wrapString("jdbc:mysql://localhost:3306/menagerie?user=scott&password=tiger"), Stella.NIL)))))))));
        Cons types = Cons.list$(Cons.cons(Sdbc.SGT_STELLA_INTEGER, Cons.cons(Sdbc.SGT_STELLA_DOUBLE_FLOAT, Cons.cons(Sdbc.SGT_STELLA_LONG_INTEGER, Cons.cons(Sdbc.SYM_STELLA_NULL, Cons.cons(Sdbc.SGT_STELLA_STRING, Cons.cons(Sdbc.SGT_STELLA_CALENDAR_DATE, Cons.cons(Stella.NIL, Stella.NIL))))))));
        String sql = "select intcol, floatcol, bigintcol, blobcol, varcharcol, datecol from typetest";
        ResultSetIterator result = Connection.getResultSet(con, sql, Cons.cons(Sdbc.KWD_TYPES, Cons.cons(types, Stella.NIL)));

        { Cons row = null;
          ResultSetIterator iter000 = result;

          while (iter000.nextP()) {
            row = ((Cons)(iter000.value));
            Stella.STANDARD_OUTPUT.nativeStream.println("Retrieved row : " + ((Cons)(result.value)));
          }
        }
        Connection.disconnect(con);
      }
    } catch (DatabaseException e) {
      Stella.STANDARD_OUTPUT.nativeStream.println("Caught Database Exception: " + Stella.exceptionMessage(e));
    }
  }

  public static void testRetrieveAll() {
    Stella.STANDARD_OUTPUT.nativeStream.println("Testing retrieve all...");
    try {
      { Connection con = Sdbc.connect(Cons.cons(Sdbc.KWD_DSN, Cons.cons(StringWrapper.wrapString("myodbc3"), Cons.cons(Sdbc.KWD_USER, Cons.cons(StringWrapper.wrapString("scott"), Cons.cons(Sdbc.KWD_PASSWORD, Cons.cons(StringWrapper.wrapString("tiger"), Cons.cons(Sdbc.KWD_CONNECTIONSTRING, Cons.cons(StringWrapper.wrapString("jdbc:mysql://localhost:3306/menagerie?user=scott&password=tiger"), Stella.NIL)))))))));
        String sql = "select intcol, floatcol, bigintcol, blobcol, varcharcol, datecol from typetest";
        Cons types = Cons.list$(Cons.cons(Sdbc.SGT_STELLA_INTEGER, Cons.cons(Sdbc.SGT_STELLA_DOUBLE_FLOAT, Cons.cons(Sdbc.SGT_STELLA_LONG_INTEGER, Cons.cons(Sdbc.SYM_STELLA_NULL, Cons.cons(Sdbc.SGT_STELLA_STRING, Cons.cons(Sdbc.SGT_STELLA_CALENDAR_DATE, Cons.cons(Stella.NIL, Stella.NIL))))))));
        Stella_Object result = Connection.executeSql(con, StringWrapper.wrapString(sql), Cons.cons(Sdbc.KWD_TYPES, Cons.cons(types, Stella.NIL)));

        if (result != null) {
          Sdbc.printTable(result);
        }
        Connection.disconnect(con);
        Stella.STANDARD_OUTPUT.nativeStream.println("connection string: " + con);
      }
    } catch (DatabaseException e) {
      Stella.STANDARD_OUTPUT.nativeStream.println("Caught Database Exception: " + Stella.exceptionMessage(e));
    }
  }

  public static void main(String[] argv001) {
    StartupSdbcSystem.startupSdbcSystem();
    Stella.STANDARD_OUTPUT.nativeStream.println("Start...");
    Sdbc.testRetrieveAll();
    Sdbc.testResultSet();
    Sdbc.testTransactions();
    Sdbc.testPreparedStatement();
    Stella.STANDARD_OUTPUT.nativeStream.println("done!");
  }

}
