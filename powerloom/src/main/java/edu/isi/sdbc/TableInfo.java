//  -*- Mode: Java -*-
//
// TableInfo.java

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

public class TableInfo extends StandardObject {
    public String database;
    public String schema;
    public String name;
    public String type;
    public String remarks;
    public List columns;

  public static TableInfo newTableInfo() {
    { TableInfo self = null;

      self = new TableInfo();
      self.columns = null;
      self.remarks = null;
      self.type = null;
      self.name = null;
      self.schema = null;
      self.database = null;
      return (self);
    }
  }

  public static Stella_Object accessTableInfoSlotValue(TableInfo self, Symbol slotname, Stella_Object value, boolean setvalueP) {
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
    else if (slotname == Sdbc.SYM_STELLA_NAME) {
      if (setvalueP) {
        self.name = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.name);
      }
    }
    else if (slotname == Sdbc.SYM_STELLA_TYPE) {
      if (setvalueP) {
        self.type = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.type);
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_REMARKS) {
      if (setvalueP) {
        self.remarks = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.remarks);
      }
    }
    else if (slotname == Sdbc.SYM_SDBC_COLUMNS) {
      if (setvalueP) {
        self.columns = ((List)(value));
      }
      else {
        value = self.columns;
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
    { TableInfo self = this;

      return (Sdbc.SGT_SDBC_TABLE_INFO);
    }
  }

}

