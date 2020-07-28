//  -*- Mode: Java -*-

/*--------------------------- BEGIN LICENSE BLOCK ---------------------------+
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
| Portions created by the Initial Developer are Copyright (C) 1996-2010      |
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
+---------------------------- END LICENSE BLOCK ----------------------------*/

// Version: SDBCSupport.java,v 1.9 2010/10/11 22:35:13 hans Exp


package edu.isi.sdbc;

import edu.isi.stella.*;

class SDBCSupport {

    // static initialization code that registers any of the listed
    // drivers that are available at run time (we do this via
    // reflection so none of the drivers need to be available at
    // compile time and only at least one of them at run time).
    // Maybe we should have a sdbc/register-jdbc-driver command.
    static {
        String[] drivers = {"com.mysql.jdbc.Driver",
                            "oracle.jdbc.driver.OracleDriver"};

        for (int i = 0; i < drivers.length; i++)
            try {
                java.sql.DriverManager.registerDriver
                    ((java.sql.Driver)Class.forName(drivers[i]).newInstance());
            } catch (Exception e){};
    }

    static boolean debug = false;

    // use `unstringify' here, since it's easiest to include module information:
    static Surrogate SGT_INTEGER = (Surrogate)Stella.unstringify("SDBC/@INTEGER");
    static Surrogate SGT_CALENDAR_DATE = (Surrogate)Stella.unstringify("SDBC/@CALENDAR-DATE");
    static Surrogate SGT_LONG_INTEGER = (Surrogate)Stella.unstringify("SDBC/@LONG-INTEGER");
    static Surrogate SGT_DOUBLE_FLOAT = (Surrogate)Stella.unstringify("SDBC/@DOUBLE-FLOAT");
    static Surrogate SGT_STRING = (Surrogate)Stella.unstringify("SDBC/@STRING");
    static Symbol SYM_NULL = (Symbol)Stella.unstringify("SDBC/NULL");

    static NativeConnection getConnection(String connectionString) {
	NativeConnection result = new NativeConnection();
        if (debug)
            System.out.println("JDBC-support: getting connection, connectionString = " + connectionString);
	try {
	    //java.sql.Connection con
            //    = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306", "scott", "tiger");
	    java.sql.Connection con = java.sql.DriverManager.getConnection(connectionString);
	    result.connection = con;
	    result.connected = true;
	} catch (Exception e){
	    throw DatabaseException.newDatabaseException(e.getMessage());
	}
	return result;
    }

    static void nativeDisconnect(NativeConnection connection) {
	try {
	    if (connection.connected) {
		synchronized (connection.connection) {
		    connection.connection.close();
		}
		connection.connected = false;
	    } else {
		throw DatabaseException.newDatabaseException("Trying to disconnect a connection that is already disconnected");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw DatabaseException.newDatabaseException(e.getMessage());	    
	}
    }

    static ResultSet getNativeResultSet(NativeConnection connection, String sql, Cons types) {

	ResultSet result = new ResultSet();
	result.types = types;
	try {
	    java.sql.Statement stmt = connection.connection.createStatement();
	    boolean isResultSet = stmt.execute(sql);
	    if (!isResultSet) {
	      // The SQL statement was one which did not generate a result set,
	      // so return null from here.
	      return null;
	    }
	    result.statement = stmt;
	    result.resultSet = stmt.getResultSet();
	} catch (Exception e) {
	    throw DatabaseException.newDatabaseException(e.getMessage());
	}
	return result;
    }

    static Cons fetchRow(ResultSet nativeResultSet) {
	java.sql.ResultSet resultSet = nativeResultSet.resultSet;
	Cons types = nativeResultSet.types;
	Cons row = Stella.NIL;
	GeneralizedSymbol colType = null;
	try {
	    if (!resultSet.next()) {
		resultSet.close();
		nativeResultSet.statement.close();
		return null;
	    }
	} catch (Exception e) {
	    throw DatabaseException.newDatabaseException(e.getMessage());
	}
	return getRow(resultSet, types);
    }

    static Cons getRow(java.sql.ResultSet resultSet, Cons types) {
	GeneralizedSymbol colType = null;
	Cons row = Stella.NIL;
	try {
	    java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
	    for (int i = 0; i < metaData.getColumnCount(); i++) {
		if (types != null) {
		    colType = (GeneralizedSymbol)types.value;
		    types = types.rest;
		}
		Stella_Object value;
		if ((colType == null)
		    || (colType == SGT_STRING)
		    || (colType == SYM_NULL)
		    || (colType == SGT_CALENDAR_DATE)) {
		    String stringValue = resultSet.getString(i+1);
		    if (stringValue == null) {
		      value = null;
		    } else {
		      value = StringWrapper.wrapString(stringValue);
		    }
		} else if ((colType == SGT_DOUBLE_FLOAT)) {
		    double doubleValue = resultSet.getDouble(i+1);
		    value = FloatWrapper.wrapFloat(doubleValue);
		} else if ((colType == SGT_INTEGER)) {
		    int intValue = resultSet.getInt(i+1);
		    value = IntegerWrapper.wrapInteger(intValue);
		} else if ((colType == SGT_LONG_INTEGER)) {
		    long longValue = resultSet.getLong(i+1);
		    value = IntegerWrapper.wrapInteger((int)longValue);
		} else {
		    // shouldn't get here if typelist is validated
		    throw DatabaseException.newDatabaseException("Bad type list.");
		}
		row = Cons.cons(value, row);
	    }
	} catch (Exception e) {
	    throw DatabaseException.newDatabaseException(e.getMessage());
	}
	return row.reverse();
    }

    static Stella_Object executeSQL(NativeConnection connection, String sql, Cons types) {
	Cons result = Stella.NIL;
	GeneralizedSymbol colType = null;
	try {
	    java.sql.Statement stmt = connection.connection.createStatement();
	    boolean isResultSet = stmt.execute(sql);
	    if (!isResultSet) {
		stmt.close();
		return null;
	    }
	    java.sql.ResultSet rs = stmt.getResultSet();

	    while (rs.next()) {
		Cons row = getRow(rs, types);
		result = Cons.cons(row, result);
	    }
	    rs.close();
	    stmt.close();
	} catch (Exception e) {
	    throw DatabaseException.newDatabaseException(e.getMessage());
	}
        if (debug)
            System.out.println("JDBC-support: executing: " + sql);
	if (result.emptyP()) {
	    return null;
	} else {
	    return result.reverse();
	}
    }

    static void setAutocommitFlag(NativeConnection nativeConnection, boolean flag) {
	try {
	    nativeConnection.connection.setAutoCommit(flag);
	} catch (Exception e) {
	    throw DatabaseException.newDatabaseException(e.getMessage());
	}
    }

    static void doCommit(NativeConnection nativeConnection) {
	try {
	    synchronized (nativeConnection.connection) {
		nativeConnection.connection.commit();
	    }
	} catch (Exception e) {
	    throw DatabaseException.newDatabaseException(e.getMessage());
	}
    }

    static void doRollback(NativeConnection nativeConnection) {
	try {
	    synchronized (nativeConnection.connection) {
		nativeConnection.connection.rollback();
	    }
	} catch (Exception e) {
	    throw DatabaseException.newDatabaseException(e.getMessage());
	}
    }

    static void doPrepareStatement(NativeConnection nativeConnection, PreparedStatement preparedStatement, String sql) {
	try {
	    java.sql.PreparedStatement newStatement = nativeConnection.connection.prepareStatement(sql);
	    preparedStatement.statement = newStatement;
	} catch (Exception e) {
	    throw DatabaseException.newDatabaseException(e.getMessage());
	}
    }

    static void doBindParameter(PreparedStatement preparedStatement, int position, Surrogate typeSpec, Object wrappedValue) {
	try {
	    java.sql.PreparedStatement statement = preparedStatement.statement;
	    if (typeSpec == SGT_INTEGER) {
		int value = IntegerWrapper.unwrapInteger((IntegerWrapper)wrappedValue);
		statement.setInt(position, value);
	    } else if (typeSpec == SGT_DOUBLE_FLOAT) {
		double value = FloatWrapper.unwrapFloat((FloatWrapper)wrappedValue);
		statement.setDouble(position, value);
	    } else if (typeSpec == SGT_STRING) {
		String value = StringWrapper.unwrapString((StringWrapper)wrappedValue);
		statement.setString(position, value);
	    } else {
		throw DatabaseException.newDatabaseException("Unsupported type in bindParameter: " + typeSpec);
	    }
	} catch (Exception e) {
	    throw DatabaseException.newDatabaseException(e.getMessage());
	}
    }

    static Cons doExecutePreparedStatement(PreparedStatement preparedStatement) {
	Cons result = Stella.NIL;
	try {
	    java.sql.PreparedStatement statement = preparedStatement.statement;
	    boolean isResultSet = statement.execute();
	    if (!isResultSet) {
                // don't close the statement, otherwise we can't execute it multiple times:
		//statement.close();
		return null;
	    }
	    java.sql.ResultSet rs = statement.getResultSet();
	    while (rs.next()) {
		Cons row = getRow(rs, null);
		result = Cons.cons(row, result);
	    }
	    rs.close();
	    //statement.close();
	} catch (Exception e) {
	    throw DatabaseException.newDatabaseException(e.getMessage());
	}
	return result;
    }

    static ResultSet getTables(NativeConnection connection, String catalogName,
                               String schemaName, String tableName, String tableType) {

	ResultSet result = new ResultSet();
	// Do we need to set this? To what?
	// result.types = types;  
	try {
	    java.sql.DatabaseMetaData metadata = connection.connection.getMetaData();
	    // Do we need to set this? To what?
	    // result.statement = stmt;
	    result.resultSet = metadata.getTables(catalogName, schemaName, tableName, new String [] {tableType});
	} catch (Exception e) {
	    throw DatabaseException.newDatabaseException(e.getMessage());
	}
	return result;
    }

    static Wrapper doGetServerInfo(NativeConnection connection, String property) {
        // Retrieve information about `property' from `connection' and return
        // the result as a wrapped string, integer, boolean or float as appropriate.
        
        try {
            java.sql.DatabaseMetaData metadata = connection.connection.getMetaData();

            if (property.equalsIgnoreCase("DBMS-NAME"))
                return StringWrapper.wrapString(metadata.getDatabaseProductName());
            if (property.equalsIgnoreCase("DBMS-VERSION"))
                return StringWrapper.wrapString(metadata.getDatabaseProductVersion());
            return null;

	} catch (Exception e) {
	    throw DatabaseException.newDatabaseException(e.getMessage());
	}
    }
}
