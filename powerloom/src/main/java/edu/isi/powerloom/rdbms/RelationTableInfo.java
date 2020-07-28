//  -*- Mode: Java -*-
//
// RelationTableInfo.java

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

/** Data structure that associates a PowerLoom relation representing
 * a database table or query with various information about its columns, value coercion, etc.
 * @author Stella Java Translator
 */
public class RelationTableInfo extends StandardObject {
    public NamedDescription relation;
    public Stella_Object database;
    public Keyword dbmsName;
    public String tableName;
    public String tableAlias;
    public Cons columnList;
    public Vector columnVector;
    public KeyValueMap columnIndex;
    public Stella_Object adjunct;

  public static RelationTableInfo newRelationTableInfo() {
    { RelationTableInfo self = null;

      self = new RelationTableInfo();
      self.adjunct = null;
      self.columnIndex = null;
      self.columnVector = null;
      self.columnList = null;
      self.tableAlias = "_T";
      self.tableName = null;
      self.dbmsName = null;
      self.database = null;
      self.relation = null;
      return (self);
    }
  }

  public static Cons normalizeSqlJoinArguments(RelationTableInfo tableinfo, Stella_Object arguments, Object [] MV_returnarray) {
    if (tableinfo.adjunct != null) {
      { Cons _return_temp = ((Cons)(((Cons)(tableinfo.adjunct)).value));

        MV_returnarray[0] = ((Cons)(((Cons)(tableinfo.adjunct)).rest.value));
        return (_return_temp);
      }
    }
    if (!(Stella_Object.stringP(arguments))) {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            stream000.nativeStream.println("PARSING ERROR: SQL-join: illegal pattern arguments: `" + arguments + "'.");
            Logic.helpSignalPropositionError(stream000, RDBMS.KWD_ERROR);

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        throw ((ParsingError)(ParsingError.newParsingError(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    { Stella_Object args = Stella.readSExpressionFromString(((StringWrapper)(arguments)).wrapperValue);
      Cons tables = Stella.NIL;
      Cons joinargs = Stella.NIL;

      if (Stella_Object.safePrimaryType(args) == RDBMS.SGT_STELLA_CONS) {
        { Cons args000 = ((Cons)(args));

          { boolean testValue000 = false;

            testValue000 = args000.length() >= 2;
            if (testValue000) {
              testValue000 = args000.length() <= 3;
              if (testValue000) {
                { boolean alwaysP000 = true;

                  { Stella_Object arg = null;
                    Cons iter000 = args000;

                    loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                      arg = iter000.value;
                      if (!Stella_Object.consP(arg)) {
                        alwaysP000 = false;
                        break loop000;
                      }
                    }
                  }
                  testValue000 = alwaysP000;
                }
              }
            }
            if (!(testValue000)) {
              { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    stream001.nativeStream.println("PARSING ERROR: SQL-join: illegal pattern arguments: `" + arguments + "'.");
                    Logic.helpSignalPropositionError(stream001, RDBMS.KWD_ERROR);

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                  }
                }
                throw ((ParsingError)(ParsingError.newParsingError(stream001.theStringReader()).fillInStackTrace()));
              }
            }
          }
          if (args000.length() == 3) {
            { Stella_Object outarg = null;
              Cons iter001 = ((Cons)(args000.value));
              RelationColumnInfo column = null;
              Cons iter002 = tableinfo.columnList;

              for (;(!(iter001 == Stella.NIL)) &&
                        (!(iter002 == Stella.NIL)); iter001 = iter001.rest, iter002 = iter002.rest) {
                outarg = iter001.value;
                column = ((RelationColumnInfo)(iter002.value));
                column.columnName = Stella_Object.coerceToString(outarg);
                tableinfo.columnIndex.insertAt(StringWrapper.wrapString(column.columnName), column);
              }
            }
            args000 = args000.rest;
          }
          else {
            { RelationColumnInfo column = null;
              Cons iter003 = tableinfo.columnList;

              for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
                column = ((RelationColumnInfo)(iter003.value));
                if (column.columnName == null) {
                  { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                    { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

                      try {
                        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                        stream002.nativeStream.println("PARSING ERROR: SQL-join: missing output argument/column specifications for: `" + column.tableInfo.relation + "'.");
                        Logic.helpSignalPropositionError(stream002, RDBMS.KWD_ERROR);

                      } finally {
                        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
                      }
                    }
                    throw ((ParsingError)(ParsingError.newParsingError(stream002.theStringReader()).fillInStackTrace()));
                  }
                }
              }
            }
          }
          { Stella_Object table = null;
            Cons iter004 = ((Cons)(args000.value));
            Cons collect000 = null;

            for (;!(iter004 == Stella.NIL); iter004 = iter004.rest) {
              table = iter004.value;
              if (collect000 == null) {
                {
                  collect000 = Cons.cons((Stella_Object.consP(table) ? ((Stella_Object)(Cons.cons(StringWrapper.wrapString(Stella_Object.coerceToString(((Cons)(table)).value)), Cons.cons(StringWrapper.wrapString(Stella_Object.coerceToString(((Cons)(table)).rest.value)), Stella.NIL)))) : ((Stella_Object)(StringWrapper.wrapString(Stella_Object.coerceToString(table))))), Stella.NIL);
                  if (tables == Stella.NIL) {
                    tables = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(tables, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons((Stella_Object.consP(table) ? ((Stella_Object)(Cons.cons(StringWrapper.wrapString(Stella_Object.coerceToString(((Cons)(table)).value)), Cons.cons(StringWrapper.wrapString(Stella_Object.coerceToString(((Cons)(table)).rest.value)), Stella.NIL)))) : ((Stella_Object)(StringWrapper.wrapString(Stella_Object.coerceToString(table))))), Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
          { Stella_Object pair = null;
            Cons iter005 = ((Cons)(args000.rest.value));
            Cons collect001 = null;

            for (;!(iter005 == Stella.NIL); iter005 = iter005.rest) {
              pair = iter005.value;
              if (!(Stella_Object.consP(pair))) {
                { OutputStringStream stream003 = OutputStringStream.newOutputStringStream();

                  { Object old$PrintreadablyP$003 = Stella.$PRINTREADABLYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      stream003.nativeStream.println("PARSING ERROR: SQL-join: illegal pattern arguments: `" + arguments + "'.");
                      Logic.helpSignalPropositionError(stream003, RDBMS.KWD_ERROR);

                    } finally {
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$003);
                    }
                  }
                  throw ((ParsingError)(ParsingError.newParsingError(stream003.theStringReader()).fillInStackTrace()));
                }
              }
              pair = Cons.consList(Cons.cons(StringWrapper.wrapString(Stella_Object.coerceToString(((Cons)(pair)).value)), Cons.cons(StringWrapper.wrapString(Stella_Object.coerceToString(((Cons)(pair)).rest.value)), Stella.NIL)));
              if (collect001 == null) {
                {
                  collect001 = Cons.cons(pair, Stella.NIL);
                  if (joinargs == Stella.NIL) {
                    joinargs = collect001;
                  }
                  else {
                    Cons.addConsToEndOfConsList(joinargs, collect001);
                  }
                }
              }
              else {
                {
                  collect001.rest = Cons.cons(pair, Stella.NIL);
                  collect001 = collect001.rest;
                }
              }
            }
          }
        }
      }
      else {
        { OutputStringStream stream004 = OutputStringStream.newOutputStringStream();

          { Object old$PrintreadablyP$004 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              stream004.nativeStream.println("PARSING ERROR: SQL-join: illegal pattern arguments: `" + arguments + "'.");
              Logic.helpSignalPropositionError(stream004, RDBMS.KWD_ERROR);

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$004);
            }
          }
          throw ((ParsingError)(ParsingError.newParsingError(stream004.theStringReader()).fillInStackTrace()));
        }
      }
      tableinfo.adjunct = Cons.consList(Cons.cons(tables, Cons.cons(joinargs, Stella.NIL)));
      { Cons _return_temp = tables;

        MV_returnarray[0] = joinargs;
        return (_return_temp);
      }
    }
  }

  public static Stella_Object accessRelationTableInfoSlotValue(RelationTableInfo self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == RDBMS.SYM_STELLA_RELATION) {
      if (setvalueP) {
        self.relation = ((NamedDescription)(value));
      }
      else {
        value = self.relation;
      }
    }
    else if (slotname == RDBMS.SYM_RDBMS_DATABASE) {
      if (setvalueP) {
        self.database = value;
      }
      else {
        value = self.database;
      }
    }
    else if (slotname == RDBMS.SYM_RDBMS_DBMS_NAME) {
      if (setvalueP) {
        self.dbmsName = ((Keyword)(value));
      }
      else {
        value = self.dbmsName;
      }
    }
    else if (slotname == RDBMS.SYM_STELLA_TABLE_NAME) {
      if (setvalueP) {
        self.tableName = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.tableName);
      }
    }
    else if (slotname == RDBMS.SYM_RDBMS_TABLE_ALIAS) {
      if (setvalueP) {
        self.tableAlias = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.tableAlias);
      }
    }
    else if (slotname == RDBMS.SYM_RDBMS_COLUMN_LIST) {
      if (setvalueP) {
        self.columnList = ((Cons)(value));
      }
      else {
        value = self.columnList;
      }
    }
    else if (slotname == RDBMS.SYM_RDBMS_COLUMN_VECTOR) {
      if (setvalueP) {
        self.columnVector = ((Vector)(value));
      }
      else {
        value = self.columnVector;
      }
    }
    else if (slotname == RDBMS.SYM_RDBMS_COLUMN_INDEX) {
      if (setvalueP) {
        self.columnIndex = ((KeyValueMap)(value));
      }
      else {
        value = self.columnIndex;
      }
    }
    else if (slotname == RDBMS.SYM_RDBMS_ADJUNCT) {
      if (setvalueP) {
        self.adjunct = value;
      }
      else {
        value = self.adjunct;
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
    { RelationTableInfo self = this;

      return (RDBMS.SGT_RDBMS_RELATION_TABLE_INFO);
    }
  }

}

