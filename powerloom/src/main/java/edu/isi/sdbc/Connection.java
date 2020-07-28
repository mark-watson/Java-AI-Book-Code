//  -*- Mode: Java -*-
//
// Connection.java

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

public class Connection extends StandardObject {
    public edu.isi.sdbc.NativeConnection nativeConnection;
    public String connectionString;
    public String protocol;
    /** Indicates to what kind of DBMS we are connected.
     */
    public Keyword dbmsName;
    /** Prepared statement associated with this connection.
     */
    public PreparedStatement statement;
    /** State of connection's auto-commit feature.
     */
    public boolean autoCommitP;
    /** Time at which connection was created.
     */
    public CalendarDate creationTime;
    /** Time at which connection was last accessed.
     */
    public CalendarDate lastAccessTime;
    /** Time at or after which connection should be renewed.
     */
    public CalendarDate renewalTime;

  public static Connection newConnection() {
    { Connection self = null;

      self = new Connection();
      self.renewalTime = null;
      self.lastAccessTime = null;
      self.creationTime = null;
      self.autoCommitP = true;
      self.statement = null;
      self.dbmsName = null;
      self.protocol = null;
      self.connectionString = null;
      self.nativeConnection = null;
      return (self);
    }
  }

  public static Keyword getDbmsName(Connection connection) {
    { Keyword cacheddbmsname = connection.dbmsName;
      StringWrapper dbmsname = null;

      if (cacheddbmsname != null) {
        return (cacheddbmsname);
      }
      try {
        dbmsname = ((StringWrapper)(Connection.getServerInfo(connection, "DBMS-NAME")));
      } catch (StellaException e000) {
      }
      if (dbmsname != null) {
        cacheddbmsname = Stella.internKeyword(Native.stringUpcase(dbmsname.wrapperValue));
      }
      else {
        cacheddbmsname = Stella.internKeyword("UNKNOWN");
      }
      connection.dbmsName = cacheddbmsname;
      return (cacheddbmsname);
    }
  }

  public static String guessDbmsName(Connection connection) {
    { String dbmsname = null;
      edu.isi.sdbc.NativeConnection ncon = connection.nativeConnection;

      try {
        Connection.executeSql(connection, StringWrapper.wrapString("select @@myisam_max_sort_file_size"), Stella.NIL);
        dbmsname = "MySQL";
      } catch (DatabaseException e000) {
      }
      if (dbmsname == null) {
        try {
          Connection.executeSql(connection, StringWrapper.wrapString("select 1 from dual"), Stella.NIL);
          dbmsname = "Oracle";
        } catch (DatabaseException e001) {
        }
      }
      return (dbmsname);
    }
  }

  public static Wrapper getServerInfo(Connection connection, String property) {
    { edu.isi.sdbc.NativeConnection ncon = connection.nativeConnection;

      { String testValue000 = connection.protocol;

        if (Stella.stringEqlP(testValue000, "ODBC")) {
        }
        else if (Stella.stringEqlP(testValue000, "JDBC")) {
          return(SDBCSupport.doGetServerInfo(ncon, property));
        }
        else {
        }
      }
      { String testValue001 = Native.stringUpcase(property);

        if (Stella.stringEqlP(testValue001, "DBMS-NAME")) {
          return (StringWrapper.wrapString(Connection.guessDbmsName(connection)));
        }
        else if (Stella.stringEqlP(testValue001, "DBMS-VERSION")) {
          { Keyword testValue002 = Connection.getDbmsName(connection);

            if (testValue002 == Sdbc.KWD_MYSQL) {
              return (((Wrapper)(Cons.consTreeNth(((Cons)(Connection.executeSql(connection, StringWrapper.wrapString("select version()"), Stella.NIL))), Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(IntegerWrapper.wrapInteger(0), Stella.NIL))))));
            }
            else if (testValue002 == Sdbc.KWD_ORACLE) {
              return (((Wrapper)(Cons.consTreeNth(((Cons)(Connection.executeSql(connection, StringWrapper.wrapString("select * from v$version where banner like 'Oracle%'"), Stella.NIL))), Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(IntegerWrapper.wrapInteger(0), Stella.NIL))))));
            }
            else {
            }
          }
        }
        else {
        }
      }
      return (null);
    }
  }

  public static Cons getColumns(Connection connection, String catalogname, String schemaname, String tablename, String columnname) {
    Stella.STANDARD_OUTPUT.nativeStream.print("FINISH ME");
    return (null);
  }

  /** Get the tables of the database identified by <code>connection</code>
   * and return the result as a list of objects containing all the relevant
   * meta information.  If any of the remaining arguments is supplied as
   * non-NULL, only tables whose corresponding field matches will be returned.
   * This is less general than what is supported by JDBC and ODBC, but Allegro
   * ODBC does not support filtering based on patterns, so we only do simple
   * manual filtering here.
   * @param connection
   * @param catalogName
   * @param schemaName
   * @param tableName
   * @param tableType
   * @return Cons
   */
  public static Cons getTables(Connection connection, String catalogName, String schemaName, String tableName, String tableType) {
    Connection.maybeRenewConnection(connection);
    { edu.isi.sdbc.NativeConnection ncon = connection.nativeConnection;
      edu.isi.sdbc.ResultSet resultSet = null;
      Iterator resultIterator = null;
      boolean filtertablesP = false &&
          ((catalogName != null) ||
           ((schemaName != null) ||
            ((tableName != null) ||
             (tableType != null))));
      TableInfo tableInfo = null;
      Cons tables = Stella.NIL;

      resultSet = SDBCSupport.getTables(ncon, catalogName, schemaName, tableName, tableType);
      if (resultIterator == null) {
        { ResultSetIterator self000 = ResultSetIterator.newResultSetIterator();

          self000.resultSet = resultSet;
          resultIterator = self000;
        }
      }
      { Cons tableRow = null;
        Iterator iter000 = resultIterator;

        loop000 : while (iter000.nextP()) {
          tableRow = ((Cons)(iter000.value));
          if (filtertablesP &&
              (((catalogName != null) &&
              (!Stella_Object.eqlToStringP(tableRow.value, catalogName))) ||
               (((schemaName != null) &&
              (!Stella_Object.eqlToStringP(tableRow.rest.value, schemaName))) ||
                (((tableName != null) &&
              (!Stella_Object.eqlToStringP(tableRow.rest.rest.value, tableName))) ||
                 ((tableType != null) &&
                  (!Stella_Object.eqlToStringP(tableRow.fourth(), tableType))))))) {
            continue loop000;
          }
          { TableInfo self001 = TableInfo.newTableInfo();

            self001.database = ((StringWrapper)(tableRow.value)).wrapperValue;
            self001.schema = ((StringWrapper)(tableRow.rest.value)).wrapperValue;
            self001.name = ((StringWrapper)(tableRow.rest.rest.value)).wrapperValue;
            self001.type = ((StringWrapper)(tableRow.fourth())).wrapperValue;
            self001.remarks = ((StringWrapper)(tableRow.fifth())).wrapperValue;
            tableInfo = self001;
          }
          if (Stella.stringEqlP(tableInfo.database, "")) {
            tableInfo.database = null;
          }
          if (Stella.stringEqlP(tableInfo.schema, "")) {
            tableInfo.schema = null;
          }
          tables = Cons.cons(tableInfo, tables);
        }
      }
      return (tables.reverse());
    }
  }

  /** Rollback the current transaction.  Undoes all changes made in
   * the current transaction and releases any database locks currently held by this
   * <code>connection</code> object.  This function is a no-op if auto-commit mode is enabled
   *  (see <code>setAutoCommit</code>).
   * @param connection
   */
  public static void rollback(Connection connection) {
    if (!(connection.autoCommitP)) {
      { edu.isi.sdbc.NativeConnection nativeConnection = connection.nativeConnection;

        SDBCSupport.doRollback(nativeConnection);
      }
    }
  }

  /** Commit the current transaction.  Makes all changes made since the
   * previous commit/rollback permanent and releases any database locks currently held
   * by this <code>connection</code> object.  This function is a no-op if auto-commit mode is
   * enabled (see <code>setAutoCommit</code>).
   * @param connection
   */
  public static void commit(Connection connection) {
    if (!(connection.autoCommitP)) {
      { edu.isi.sdbc.NativeConnection nativeConnection = connection.nativeConnection;

        SDBCSupport.doCommit(nativeConnection);
      }
    }
  }

  /** Set the auto-commit feature of <code>connection</code> to TRUE or FALSE.
   * If a connection is in auto-commit mode, then all its SQL statements will be executed
   * and committed as individual transactions.  Otherwise, its SQL statements are grouped
   * into transactions that are terminated by a call to either <code>commit</code> or <code>rollback</code>.
   * By default, new connections are in auto-commit mode.
   * @param connection
   * @param flag
   */
  public static void setAutoCommit(Connection connection, boolean flag) {
    Connection.maybeRenewConnection(connection);
    { edu.isi.sdbc.NativeConnection nativeConnection = connection.nativeConnection;

      SDBCSupport.setAutocommitFlag(nativeConnection, flag);
      connection.autoCommitP = flag;
    }
  }

  /** Prepare the <code>sql</code> statement for execution at the server and return
   * a prepared statement object.  After binding all its paramters via <code>bindParameter</code>
   * the statement can be executed via <code>executeSql</code>.
   * IMPORTANT: Only one prepared statement can be associated with a connection at a time.
   * @param connection
   * @param sql
   * @return PreparedStatement
   */
  public static PreparedStatement prepareStatement(Connection connection, String sql) {
    Connection.maybeRenewConnection(connection);
    { PreparedStatement result = PreparedStatement.newPreparedStatement();
      edu.isi.sdbc.NativeConnection nativeconnection = connection.nativeConnection;

      result.connection = connection;
      connection.statement = result;
      result.sql = sql;
      SDBCSupport.doPrepareStatement(nativeconnection, result, sql);
      return (result);
    }
  }

  /** Insert a set of <code>rows</code> into <code>table</code>.  <code>columns</code>
   * can be NULL or NIL in which case values must be suppied for all
   * columns.  If <code>columns</code> are given <code>values</code> will be only inserted in
   * the specified columns.  Table and column names will be quoted which
   * means their casing must match exactly their definition (no case
   * conversion will be performed).  See <code>insertRow</code> for a description
   * of supported value formats.  DEFAULT values are currently not supported
   * for Oracle!  This function performs a fairly efficient multi-row
   * insert which is significantly faster than inserting rows one by one.
   * @param connection
   * @param table
   * @param columns
   * @param rows
   */
  public static void insertRows(Connection connection, String table, Cons columns, Cons rows) {
    if ((rows == null) ||
        (rows == Stella.NIL)) {
      return;
    }
    { OutputStringStream sql = null;
      char idquote = Sdbc.sqlQuoteCharacter(Connection.getDbmsName(connection), Sdbc.KWD_IDENTIFIER);
      char valuequote = Sdbc.sqlQuoteCharacter(Connection.getDbmsName(connection), Sdbc.KWD_STRING_CONSTANT);
      int blocklength = 1000;
      int oracleblocklength = 100;

      loop000 : for (;;) {
        sql = OutputStringStream.newOutputStringStream();
        sql.nativeStream.print("INSERT INTO " + idquote + Sdbc.sqlEscapeString(table, idquote) + idquote);
        if ((columns != null) &&
            (!(columns == Stella.NIL))) {
          sql.nativeStream.print("(");
          Sdbc.printValueList(sql, columns, idquote);
          sql.nativeStream.print(")");
        }
        if ((Connection.getDbmsName(connection) == Sdbc.KWD_ORACLE) &&
            (!(rows.rest == Stella.NIL))) {
          { Cons values = null;
            Cons iter000 = rows;
            int i = Stella.NULL_INTEGER;
            int iter001 = 1;
            int upperBound000 = oracleblocklength;
            boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

            for (;(!(iter000 == Stella.NIL)) &&
                      (unboundedP000 ||
                       (iter001 <= upperBound000)); iter000 = iter000.rest, iter001 = iter001 + 1) {
              values = ((Cons)(iter000.value));
              i = iter001;
              if (i > 1) {
                sql.nativeStream.print(" UNION");
              }
              sql.nativeStream.print(" SELECT ");
              Sdbc.printValueList(sql, values, valuequote);
              sql.nativeStream.print(" FROM DUAL");
              rows = rows.rest;
            }
          }
        }
        else {
          sql.nativeStream.print(" VALUES");
          { Cons values = null;
            Cons iter002 = rows;
            int i = Stella.NULL_INTEGER;
            int iter003 = 1;
            int upperBound001 = blocklength;
            boolean unboundedP001 = upperBound001 == Stella.NULL_INTEGER;

            for (;(!(iter002 == Stella.NIL)) &&
                      (unboundedP001 ||
                       (iter003 <= upperBound001)); iter002 = iter002.rest, iter003 = iter003 + 1) {
              values = ((Cons)(iter002.value));
              i = iter003;
              if (i > 1) {
                sql.nativeStream.print(",");
              }
              sql.nativeStream.print("(");
              Sdbc.printValueList(sql, values, valuequote);
              sql.nativeStream.print(")");
              rows = rows.rest;
            }
          }
        }
        Connection.executeSql(connection, StringWrapper.wrapString(sql.theStringReader()), Stella.NIL);
        if (rows == Stella.NIL) {
          break loop000;
        }
      }
    }
  }

  /** Insert a row of <code>values</code> into <code>table</code>.  <code>columns</code>
   * can be NULL or NIL in which case <code>values</code> must be suppied for all
   * columns.  If <code>columns</code> are given <code>values</code> will be only inserted in
   * the specified columns.  Table and column names will be quoted which
   * means their casing must match exactly their definition (no case
   * conversion will be performed).  Supplied <code>values</code> can be strings,
   * integers or floats.  Strings will be quoted and escaped appropriately.
   * The values NULL, :NULL or (quote NULL) translate into NULL.  The
   * values :DEFAULT or (quote DEFAULT) translate into DEFAULT.  Arbitrary
   * unquoted strings can be generated via VERBATIM-STRING-WRAPPERs as
   * values (e.g., for something like <code>seqDnextval</code> in Oracle).
   * @param connection
   * @param table
   * @param columns
   * @param values
   */
  public static void insertRow(Connection connection, String table, Cons columns, Cons values) {
    if ((values == null) ||
        (values == Stella.NIL)) {
      return;
    }
    Connection.insertRows(connection, table, columns, Cons.cons(values, Stella.NIL));
  }

  /** Execute a SQL query, and return a ResultSet object.
   *                   Options include: 
   *                      :types &lt;typelist&gt;, where &lt;typelist&gt; is a cons list of surrogates
   *                   specifying the expected Stella types.  Legal surrogate values are
   *                   @INTEGER, @LONG-INTEGER, @DOUBLE-FLOAT, @CALENDAR-DATE, @STRING, and
   *                   NULL.  If NULL is specified, values are returned as strings.
   *                   A DATABASE-EXCEPTION is thrown if execution is unsuccessful.
   * @param connection
   * @param sql
   * @param options
   * @return ResultSetIterator
   */
  public static ResultSetIterator getResultSet(Connection connection, String sql, Cons options) {
    Connection.maybeRenewConnection(connection);
    { edu.isi.sdbc.ResultSet nativeresultset = null;
      edu.isi.sdbc.NativeConnection nativeconnection = connection.nativeConnection;
      ResultSetIterator resultsetiterator = ResultSetIterator.newResultSetIterator();
      PropertyList proplist = Stella_Object.vetOptions(options, Stella.getQuotedTree("((:TYPES) \"/SDBC\")", "/SDBC"));
      Cons types = ((Cons)(proplist.lookup(Sdbc.KWD_TYPES)));

      resultsetiterator.types = types;
      Stella.logmsg("SDBC", Sdbc.KWD_HIGH, Cons.cons(StringWrapper.wrapString("get-result-set: sql="), Cons.cons(StringWrapper.wrapString(sql), Stella.NIL)));
      nativeresultset = SDBCSupport.getNativeResultSet(nativeconnection, sql, types);
      resultsetiterator.resultSet = nativeresultset;
      return (resultsetiterator);
    }
  }

  /** Execute a SQL statement, and return a table as the reuslt
   *                   of a SQL query (represented as a (CONS OF (CONS OF OBJECT))),
   *                   or NULL as the result of a successfull SQL insert, update,
   *                   delete or other command.
   *                   <code>sql</code> can either be a string representing a SQL command or
   *                   a PREPARED-STATEMENT.
   *                   Options include: 
   *                      :types &lt;typelist&gt;, where &lt;typelist&gt; is a cons list of surrogates
   *                   specifying the expected Stella types.  Legal surrogate values are
   *                   @INTEGER, @LONG-INTEGER, @DOUBLE-FLOAT, @CALENDAR-DATE, @STRING, and
   *                   NULL.  If NULL is specified, values are returned as strings.
   *                   A DATABASE-EXCEPTION is thrown if execution is unsuccessful.
   * @param connection
   * @param sql
   * @param options
   * @return Stella_Object
   */
  public static Stella_Object executeSql(Connection connection, Stella_Object sql, Cons options) {
    Connection.maybeRenewConnection(connection);
    { Stella_Object result = null;
      edu.isi.sdbc.NativeConnection ncon = connection.nativeConnection;
      PropertyList proplist = Stella_Object.vetOptions(options, Stella.getQuotedTree("((:TYPES) \"/SDBC\")", "/SDBC"));
      Cons types = ((Cons)(proplist.lookup(Sdbc.KWD_TYPES)));

      { Surrogate testValue000 = Stella_Object.safePrimaryType(sql);

        if (Surrogate.subtypeOfStringP(testValue000)) {
          { StringWrapper sql000 = ((StringWrapper)(sql));

            Stella.logmsg("SDBC", Sdbc.KWD_HIGH, Cons.cons(StringWrapper.wrapString("execute-sql: sql="), Cons.cons(sql000, Stella.NIL)));
            result = SDBCSupport.executeSQL(ncon, StringWrapper.unwrapString((StringWrapper)sql), types);
          }
        }
        else if (Surrogate.subtypeOfP(testValue000, Sdbc.SGT_SDBC_PREPARED_STATEMENT)) {
          { PreparedStatement sql000 = ((PreparedStatement)(sql));

            Stella.logmsg("SDBC", Sdbc.KWD_HIGH, Cons.cons(StringWrapper.wrapString("execute-sql: prepared sql="), Cons.cons(StringWrapper.wrapString(sql000.sql), Cons.cons(StringWrapper.wrapString(", parameters="), Cons.cons(sql000.parameters, Stella.NIL)))));
            result = SDBCSupport.doExecutePreparedStatement((PreparedStatement)sql);
          }
        }
        else {
          throw ((StellaException)(StellaException.newStellaException("`sql' argument must be of type STRING-WRAPPER or PREPARED-STATEMENT").fillInStackTrace()));
        }
      }
      return (Sdbc.coerceUncoercedValuesInTable(((Cons)(result)), types));
    }
  }

  /** Disconnect <code>connection</code> from a database.  A DATABASE-EXCEPTION is thrown if
   * the disconnect is unsuccessful.
   * @param connection
   */
  public static void disconnect(Connection connection) {
    { edu.isi.sdbc.NativeConnection nativeconnection = connection.nativeConnection;

      if (!(nativeconnection == null)) {
        SDBCSupport.nativeDisconnect(nativeconnection);
        Stella.logmsg("SDBC", Sdbc.KWD_LOW, Cons.cons(StringWrapper.wrapString("Disconnecting "), Cons.cons(StringWrapper.wrapString(connection.protocol), Cons.cons(StringWrapper.wrapString(" connection: "), Cons.cons(StringWrapper.wrapString(connection.connectionString), Stella.NIL)))));
        connection.nativeConnection = null;
      }
    }
  }

  public static void maybeRenewConnection(Connection con) {
    if (!(con.autoCommitP)) {
      return;
    }
    { CalendarDate currenttime = CalendarDate.makeCurrentDateTime();
      PreparedStatement statement = con.statement;
      Connection newcon = null;

      con.lastAccessTime = currenttime;
      if (currenttime.greaterEqualP(con.renewalTime)) {
        Stella.logmsg("SDBC", Sdbc.KWD_LOW, Cons.cons(StringWrapper.wrapString("Renewing "), Cons.cons(StringWrapper.wrapString(con.protocol), Cons.cons(StringWrapper.wrapString(" connection: "), Cons.cons(StringWrapper.wrapString(con.connectionString), Stella.NIL)))));
        newcon = Sdbc.connect(Cons.cons(Sdbc.KWD_PROTOCOL, Cons.cons(StringWrapper.wrapString(con.protocol), Cons.cons(Sdbc.KWD_CONNECTION_STRING, Cons.cons(StringWrapper.wrapString(con.connectionString), Stella.NIL)))));
        Connection.disconnect(con);
        con.nativeConnection = newcon.nativeConnection;
        con.connectionString = newcon.connectionString;
        con.protocol = newcon.protocol;
        con.creationTime = newcon.creationTime;
        con.lastAccessTime = newcon.lastAccessTime;
        con.renewalTime = newcon.renewalTime;
        if (statement != null) {
          Connection.prepareStatement(con, statement.sql);
          statement.statement = con.statement.statement;
          con.statement = statement;
          { IntegerWrapper pos = null;
            Cons entry = null;
            KvCons iter000 = statement.parameters.theKvList;

            for (;iter000 != null; iter000 = iter000.rest) {
              pos = ((IntegerWrapper)(iter000.key));
              entry = ((Cons)(iter000.value));
              PreparedStatement.bindParameter(statement, pos.wrapperValue, ((Surrogate)(entry.value)), entry.rest.value);
            }
          }
        }
      }
    }
  }

  public static int getMaxConnectionLifetime(Connection con) {
    con = con;
    return (Sdbc.$DB_CONNECTION_RENEWAL_INTERVAL$);
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { Connection self = this;

      stream.print("|CON|\"" + self.connectionString + "\"");
    }
  }

  public static Stella_Object accessConnectionSlotValue(Connection self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Sdbc.SYM_SDBC_CONNECTION_STRING) {
      if (setvalueP) {
        self.connectionString = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.connectionString);
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_PROTOCOL) {
      if (setvalueP) {
        self.protocol = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.protocol);
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_DBMS_NAME) {
      if (setvalueP) {
        self.dbmsName = ((Keyword)(value));
      }
      else {
        value = self.dbmsName;
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_STATEMENT) {
      if (setvalueP) {
        self.statement = ((PreparedStatement)(value));
      }
      else {
        value = self.statement;
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_AUTO_COMMITp) {
      if (setvalueP) {
        self.autoCommitP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.autoCommitP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_CREATION_TIME) {
      if (setvalueP) {
        self.creationTime = ((CalendarDate)(value));
      }
      else {
        value = self.creationTime;
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_LAST_ACCESS_TIME) {
      if (setvalueP) {
        self.lastAccessTime = ((CalendarDate)(value));
      }
      else {
        value = self.lastAccessTime;
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_RENEWAL_TIME) {
      if (setvalueP) {
        self.renewalTime = ((CalendarDate)(value));
      }
      else {
        value = self.renewalTime;
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
    { Connection self = this;

      return (Sdbc.SGT_SDBC_CONNECTION);
    }
  }

}

