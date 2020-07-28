//  -*- Mode: Java -*-
//
// RelationColumnInfo.java

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

public class RelationColumnInfo extends StandardObject {
    public RelationTableInfo tableInfo;
    public String columnName;
    public Symbol columnVariable;
    public int columnIndex;
    public NamedDescription columnType;
    public String columnDbType;
    public String moduleName;
    public String moduleReference;
    public Module module;
    public boolean moduleLocalP;
    public RelationColumnInfo moduleReferenceColumn;
    public java.lang.reflect.Method coercionFunction;

  public static RelationColumnInfo newRelationColumnInfo() {
    { RelationColumnInfo self = null;

      self = new RelationColumnInfo();
      self.coercionFunction = null;
      self.moduleReferenceColumn = null;
      self.moduleLocalP = false;
      self.module = null;
      self.moduleReference = null;
      self.moduleName = null;
      self.columnDbType = null;
      self.columnType = null;
      self.columnIndex = Stella.NULL_INTEGER;
      self.columnVariable = null;
      self.columnName = null;
      self.tableInfo = null;
      return (self);
    }
  }

  public static Module getModuleUsingReference(RelationColumnInfo column, Cons values) {
    { int refcolumindex = column.moduleReferenceColumn.columnIndex;
      Stella_Object modulename = values.nth(refcolumindex);
      Module module = ((modulename != null) ? Stella.getStellaModule(((StringWrapper)(modulename)).wrapperValue, false) : ((Module)(null)));

      if (!(module != null)) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: RDBMS: Column module `" + modulename + "' defined by reference for column `" + column.columnName + "' on relation `" + column.tableInfo.relation + "' is not defined; ignoring it...");
        module = ((Context)(Stella.$CONTEXT$.get())).baseModule;
      }
      return (module);
    }
  }

  public static Stella_Object accessRelationColumnInfoSlotValue(RelationColumnInfo self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == RDBMS.SYM_RDBMS_TABLE_INFO) {
      if (setvalueP) {
        self.tableInfo = ((RelationTableInfo)(value));
      }
      else {
        value = self.tableInfo;
      }
    }
    else if (slotname == RDBMS.SYM_RDBMS_COLUMN_NAME) {
      if (setvalueP) {
        self.columnName = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.columnName);
      }
    }
    else if (slotname == RDBMS.SYM_RDBMS_COLUMN_VARIABLE) {
      if (setvalueP) {
        self.columnVariable = ((Symbol)(value));
      }
      else {
        value = self.columnVariable;
      }
    }
    else if (slotname == RDBMS.SYM_RDBMS_COLUMN_INDEX) {
      if (setvalueP) {
        self.columnIndex = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.columnIndex);
      }
    }
    else if (slotname == RDBMS.SYM_RDBMS_COLUMN_TYPE) {
      if (setvalueP) {
        self.columnType = ((NamedDescription)(value));
      }
      else {
        value = self.columnType;
      }
    }
    else if (slotname == RDBMS.SYM_RDBMS_COLUMN_DB_TYPE) {
      if (setvalueP) {
        self.columnDbType = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.columnDbType);
      }
    }
    else if (slotname == RDBMS.SYM_STELLA_MODULE_NAME) {
      if (setvalueP) {
        self.moduleName = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.moduleName);
      }
    }
    else if (slotname == RDBMS.SYM_RDBMS_MODULE_REFERENCE) {
      if (setvalueP) {
        self.moduleReference = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.moduleReference);
      }
    }
    else if (slotname == RDBMS.SYM_STELLA_MODULE) {
      if (setvalueP) {
        self.module = ((Module)(value));
      }
      else {
        value = self.module;
      }
    }
    else if (slotname == RDBMS.SYM_RDBMS_MODULE_LOCALp) {
      if (setvalueP) {
        self.moduleLocalP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.moduleLocalP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == RDBMS.SYM_RDBMS_MODULE_REFERENCE_COLUMN) {
      if (setvalueP) {
        self.moduleReferenceColumn = ((RelationColumnInfo)(value));
      }
      else {
        value = self.moduleReferenceColumn;
      }
    }
    else if (slotname == RDBMS.SYM_RDBMS_COERCION_FUNCTION) {
      if (setvalueP) {
        self.coercionFunction = ((FunctionCodeWrapper)(value)).wrapperValue;
      }
      else {
        value = FunctionCodeWrapper.wrapFunctionCode(self.coercionFunction);
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
    { RelationColumnInfo self = this;

      return (RDBMS.SGT_RDBMS_RELATION_COLUMN_INFO);
    }
  }

}

