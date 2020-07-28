//  -*- Mode: Java -*-
//
// PreparedStatement.java

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

public class PreparedStatement extends StandardObject {
    public Connection connection;
    public java.sql.PreparedStatement statement;
    public String sql;
    /** Stores parameters bound so far to support connection renewal.
     */
    public KeyValueList parameters;

  public static PreparedStatement newPreparedStatement() {
    { PreparedStatement self = null;

      self = new PreparedStatement();
      self.parameters = KeyValueList.newKeyValueList();
      self.sql = null;
      self.statement = null;
      self.connection = null;
      return (self);
    }
  }

  public static void clDoBindParameter(PreparedStatement statement, int position, Surrogate typespec, Stella_Object value) {
    { edu.isi.sdbc.NativeConnection nativeconnection = statement.connection.nativeConnection;
      boolean nullP = value == null;
      boolean wrapperP = Stella_Object.isaP(value, Sdbc.SGT_STELLA_WRAPPER);

    }
  }

  /** Bind the parameter at <code>position</code> (1-based) in the prepared
   * statement <code>statement</code> to <code>value</code>.  <code>typespec</code> characterizes the type of
   * <code>value</code> for proper translation and coercion.
   * @param statement
   * @param position
   * @param typespec
   * @param value
   */
  public static void bindParameter(PreparedStatement statement, int position, Surrogate typespec, Stella_Object value) {
    { Connection connection = statement.connection;
      edu.isi.sdbc.NativeConnection ncon = null;

      Connection.maybeRenewConnection(connection);
      ncon = connection.nativeConnection;
      statement.parameters.insertAt(IntegerWrapper.wrapInteger(position), Cons.consList(Cons.cons(typespec, Cons.cons(value, Stella.NIL))));
      if (typespec == Sdbc.SGT_STELLA_CALENDAR_DATE) {
        typespec = Sdbc.SGT_STELLA_STRING;
        if (value != null) {
          value = StringWrapper.wrapString(Sdbc.calendarDateToSqlString(((CalendarDate)(value))));
        }
      }
      SDBCSupport.doBindParameter(statement, position, typespec, value);
    }
  }

  public static Stella_Object accessPreparedStatementSlotValue(PreparedStatement self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Sdbc.SYM_SDBC_CONNECTION) {
      if (setvalueP) {
        self.connection = ((Connection)(value));
      }
      else {
        value = self.connection;
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_SQL) {
      if (setvalueP) {
        self.sql = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.sql);
      }
    }
    else if (slotname == Sdbc.SYM_STELLA_PARAMETERS) {
      if (setvalueP) {
        self.parameters = ((KeyValueList)(value));
      }
      else {
        value = self.parameters;
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
    { PreparedStatement self = this;

      return (Sdbc.SGT_SDBC_PREPARED_STATEMENT);
    }
  }

}

