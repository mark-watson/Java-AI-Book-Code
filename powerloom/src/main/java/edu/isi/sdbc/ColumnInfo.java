//  -*- Mode: Java -*-
//
// ColumnInfo.java

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

public class ColumnInfo extends StandardObject {
    public String database;
    public String schema;
    public String tableName;
    public String name;
    /** SQL type from java.sql.Types.
     */
    public int dataType;
    /** Data source dependent type name, for a UDT the type name is fully qualified.
     */
    public String dataTypeName;
    /** Column size. For char or date types this is the maximum number of characters,
     * for numeric or decimal types this is precision.
     */
    public int columnSize;
    /** Not used.
     */
    public int bufferLength;
    /** The number of fractional digits.
     */
    public int decimalDigits;
    /** Radix (typically either 10 or 2).
     */
    public int radix;
    /** TRUE means definitely allows NULL values, FALSE means might not allow
     * NULL values, NULL means nullability unknown.
     */
    public BooleanWrapper nullableP;
    /** TRUE means might allow NULL values, FALSE means definitely does not
     * allow NULL values, NULL means nullability unknown.
     */
    public BooleanWrapper isNullableP;
    /** Comment describing column (may be null).
     */
    public String documentation;
    public String defaultValue;
    /** Not used.
     */
    public int sqlDataType;
    /** Not used.
     */
    public int sqlDatetimeSub;
    /** For char types the maximum number of bytes in the column.
     */
    public int charOctetLength;
    /** Index of column in table (starting at 1).
     */
    public int ordinalPosition;

  public static ColumnInfo newColumnInfo() {
    { ColumnInfo self = null;

      self = new ColumnInfo();
      self.ordinalPosition = Stella.NULL_INTEGER;
      self.charOctetLength = Stella.NULL_INTEGER;
      self.sqlDatetimeSub = Stella.NULL_INTEGER;
      self.sqlDataType = Stella.NULL_INTEGER;
      self.defaultValue = null;
      self.documentation = null;
      self.isNullableP = null;
      self.nullableP = null;
      self.radix = Stella.NULL_INTEGER;
      self.decimalDigits = Stella.NULL_INTEGER;
      self.bufferLength = Stella.NULL_INTEGER;
      self.columnSize = Stella.NULL_INTEGER;
      self.dataTypeName = null;
      self.dataType = Stella.NULL_INTEGER;
      self.name = null;
      self.tableName = null;
      self.schema = null;
      self.database = null;
      return (self);
    }
  }

  public static Stella_Object accessColumnInfoSlotValue(ColumnInfo self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Sdbc.SYM_SDBC_DATABASE) {
      if (setvalueP) {
        self.database = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.database);
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_CATALOG) {
      if (setvalueP) {
        self.database = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.database);
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_SCHEMA) {
      if (setvalueP) {
        self.schema = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.schema);
      }
    }
    else if (slotname == Sdbc.SYM_STELLA_TABLE_NAME) {
      if (setvalueP) {
        self.tableName = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.tableName);
      }
    }
    else if (slotname == Sdbc.SYM_STELLA_NAME) {
      if (setvalueP) {
        self.name = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.name);
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_DATA_TYPE) {
      if (setvalueP) {
        self.dataType = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.dataType);
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_DATA_TYPE_NAME) {
      if (setvalueP) {
        self.dataTypeName = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.dataTypeName);
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_COLUMN_SIZE) {
      if (setvalueP) {
        self.columnSize = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.columnSize);
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_BUFFER_LENGTH) {
      if (setvalueP) {
        self.bufferLength = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.bufferLength);
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_DECIMAL_DIGITS) {
      if (setvalueP) {
        self.decimalDigits = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.decimalDigits);
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_RADIX) {
      if (setvalueP) {
        self.radix = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.radix);
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_NULLABLEp) {
      if (setvalueP) {
        self.nullableP = ((BooleanWrapper)(value));
      }
      else {
        value = self.nullableP;
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_IS_NULLABLEp) {
      if (setvalueP) {
        self.isNullableP = ((BooleanWrapper)(value));
      }
      else {
        value = self.isNullableP;
      }
    }
    else if (slotname == Sdbc.SYM_STELLA_DOCUMENTATION) {
      if (setvalueP) {
        self.documentation = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.documentation);
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_REMARKS) {
      if (setvalueP) {
        self.documentation = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.documentation);
      }
    }
    else if (slotname == Sdbc.SYM_STELLA_DEFAULT_VALUE) {
      if (setvalueP) {
        self.defaultValue = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.defaultValue);
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_SQL_DATA_TYPE) {
      if (setvalueP) {
        self.sqlDataType = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.sqlDataType);
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_SQL_DATETIME_SUB) {
      if (setvalueP) {
        self.sqlDatetimeSub = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.sqlDatetimeSub);
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_CHAR_OCTET_LENGTH) {
      if (setvalueP) {
        self.charOctetLength = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.charOctetLength);
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_ORDINAL_POSITION) {
      if (setvalueP) {
        self.ordinalPosition = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.ordinalPosition);
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
    { ColumnInfo self = this;

      return (Sdbc.SGT_SDBC_COLUMN_INFO);
    }
  }

}

