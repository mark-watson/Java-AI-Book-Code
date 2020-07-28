//  -*- Mode: Java -*-
//
// RDBMS.java

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

public class RDBMS {
  public static Symbol SYM_RDBMS_DATABASE = null;

  public static Keyword KWD_DOCUMENTATION = null;

  public static Symbol SYM_RDBMS_SQL_DATABASE = null;

  public static Symbol SYM_RDBMS_PROTOCOL = null;

  public static Keyword KWD__g = null;

  public static Keyword KWD_GOES_TRUE_DEMON = null;

  public static Symbol SYM_RDBMS_DB_UPDATE_DEMON = null;

  public static Keyword KWD_GOES_UNKNOWN_DEMON = null;

  public static Symbol SYM_RDBMS_SERVER_TYPE = null;

  public static Symbol SYM_RDBMS_DSN = null;

  public static Symbol SYM_RDBMS_CONNECTION_STRING = null;

  public static Symbol SYM_RDBMS_ODBC_CONNECTION_STRING = null;

  public static Symbol SYM_RDBMS_JDBC_CONNECTION_STRING = null;

  public static Symbol SYM_RDBMS_HOST = null;

  public static Symbol SYM_RDBMS_PORT = null;

  public static Symbol SYM_RDBMS_USER = null;

  public static Symbol SYM_RDBMS_PASSWORD = null;

  public static Symbol SYM_RDBMS_DB_NAME = null;

  public static Symbol SYM_RDBMS_DB_CONNECTION = null;

  public static Keyword KWD_AXIOMS = null;

  public static Symbol SYM_RDBMS_RELATION_TABLE = null;

  public static Symbol SYM_RDBMS_RELATION_DATABASE = null;

  public static Symbol SYM_RDBMS_RELATION_COLUMN_NAME = null;

  public static Symbol SYM_RDBMS_RELATION_COLUMN_MODULE_NAME = null;

  public static Symbol SYM_RDBMS_RELATION_COLUMN_MODULE_REFERENCE = null;

  public static Symbol SYM_RDBMS_QUERY_EVALUATOR = null;

  public static Symbol SYM_RDBMS_SUPPORTS_DB_TYPE = null;

  public static Keyword KWD_CLOSED = null;

  public static Symbol SYM_STELLA_TRUE = null;

  public static Symbol SYM_RDBMS_QUERY_PATTERN = null;

  public static Symbol SYM_RDBMS_QUERY_SQL_DATABASE = null;

  public static Keyword KWD_VARIABLE_ARITY = null;

  public static Keyword KWD_RELATION_SPECIALIST = null;

  public static Symbol SYM_RDBMS_QUERY_SQL_DATABASE_SPECIALIST = null;

  public static Symbol SYM_RDBMS_QUERY_DATABASE = null;

  public static Symbol SYM_RDBMS_QUERY_DATABASE_SPECIALIST = null;

  public static Symbol SYM_RDBMS_FETCH_EDB_DATABASE = null;

  public static Symbol SYM_RDBMS_TASK_ID = null;

  public static Symbol SYM_RDBMS_SUBTASK_ID = null;

  public static Symbol SYM_RDBMS_FETCH_QUERY = null;

  public static Symbol SYM_RDBMS_FETCH_QUERY_TYPE_1 = null;

  public static Symbol SYM_RDBMS_FETCH_QUERY_TYPE_2 = null;

  public static Symbol SYM_RDBMS_QUERY_TABLE_NAME = null;

  public static Symbol SYM_RDBMS_QUERY_PARAMETER_NAME = null;

  public static Symbol SYM_RDBMS_STARTUP_ONTOLOGY = null;

  public static Symbol SYM_STELLA_METHOD_STARTUP_CLASSNAME = null;

  public static Symbol SYM_RDBMS_DEFUNTABLE = null;

  public static Symbol SYM_PL_KERNEL_KB_RELATION_SPECIALIST = null;

  public static Symbol SYM_RDBMS_DBTABLE_SPECIALIST = null;

  public static Symbol SYM_RDBMS_DEFTABLE = null;

  public static Surrogate SGT_STELLA_CONS = null;

  public static Keyword KWD_ERROR = null;

  public static Keyword KWD_NAME = null;

  public static Keyword KWD_VARIABLE = null;

  public static Keyword KWD_TYPE = null;

  public static Keyword KWD_MODULE_NAME = null;

  public static Keyword KWD_MODULE_REFERENCE = null;

  public static Symbol SYM_RDBMS_DEFDB = null;

  public static Keyword KWD_CONNECTION_STRING = null;

  public static Surrogate SGT_STELLA_STRING = null;

  public static Keyword KWD_JDBC_CONNECTION_STRING = null;

  public static Keyword KWD_ODBC_CONNECTION_STRING = null;

  public static Keyword KWD_DSN = null;

  public static Keyword KWD_DB = null;

  public static Keyword KWD_HOST = null;

  public static Keyword KWD_PORT = null;

  public static Surrogate SGT_STELLA_INTEGER = null;

  public static Keyword KWD_USER = null;

  public static Keyword KWD_PASSWORD = null;

  public static Keyword KWD_MODULE = null;

  public static Surrogate SGT_STELLA_MODULE = null;

  public static Keyword KWD_CONFIGURATION = null;

  public static Surrogate SGT_STELLA_CONFIGURATION_TABLE = null;

  public static Keyword KWD_DB_NAME = null;

  public static Symbol SYM_RDBMS_DEFQUERY = null;

  public static Symbol SYM_RDBMS_QUERY_SPECIALIST = null;

  public static Surrogate SGT_RDBMS_CONNECTION_WRAPPER = null;

  public static Symbol SYM_STELLA_WRAPPER_VALUE = null;

  public static Surrogate SGT_LOGIC_LOGIC_OBJECT = null;

  public static Surrogate SGT_RDBMS_PROTOCOL = null;

  public static Surrogate SGT_RDBMS_SERVER_TYPE = null;

  public static Surrogate SGT_RDBMS_HOST = null;

  public static Surrogate SGT_RDBMS_PORT = null;

  public static Surrogate SGT_RDBMS_USER = null;

  public static Surrogate SGT_RDBMS_PASSWORD = null;

  public static Surrogate SGT_RDBMS_DB_NAME = null;

  public static Surrogate SGT_RDBMS_JDBC_CONNECTION_STRING = null;

  public static Surrogate SGT_RDBMS_CONNECTION_STRING = null;

  public static Surrogate SGT_RDBMS_DSN = null;

  public static Keyword KWD_PROTOCOL = null;

  public static Keyword KWD_SERVER_TYPE = null;

  public static Surrogate SGT_RDBMS_DB_CONNECTION = null;

  public static Surrogate SGT_RDBMS_RELATION_DATABASE = null;

  public static Symbol SYM_LOGIC_pX = null;

  public static Surrogate SGT_RDBMS_RELATION_TABLE_INFO = null;

  public static Symbol SYM_STELLA_RELATION = null;

  public static Symbol SYM_RDBMS_DBMS_NAME = null;

  public static Symbol SYM_STELLA_TABLE_NAME = null;

  public static Symbol SYM_RDBMS_TABLE_ALIAS = null;

  public static Symbol SYM_RDBMS_COLUMN_LIST = null;

  public static Symbol SYM_RDBMS_COLUMN_VECTOR = null;

  public static Symbol SYM_RDBMS_COLUMN_INDEX = null;

  public static Symbol SYM_RDBMS_ADJUNCT = null;

  public static Surrogate SGT_RDBMS_RELATION_COLUMN_INFO = null;

  public static Symbol SYM_RDBMS_TABLE_INFO = null;

  public static Symbol SYM_RDBMS_COLUMN_NAME = null;

  public static Symbol SYM_RDBMS_COLUMN_VARIABLE = null;

  public static Symbol SYM_RDBMS_COLUMN_TYPE = null;

  public static Symbol SYM_RDBMS_COLUMN_DB_TYPE = null;

  public static Symbol SYM_STELLA_MODULE_NAME = null;

  public static Symbol SYM_RDBMS_MODULE_REFERENCE = null;

  public static Symbol SYM_STELLA_MODULE = null;

  public static Symbol SYM_RDBMS_MODULE_LOCALp = null;

  public static Symbol SYM_RDBMS_MODULE_REFERENCE_COLUMN = null;

  public static Symbol SYM_RDBMS_COERCION_FUNCTION = null;

  public static Keyword KWD_UNKNOWN = null;

  public static Surrogate SGT_RDBMS_RELATION_TABLE = null;

  public static Surrogate SGT_RDBMS_F_GET_RELATION_TABLE_INFO_MEMO_TABLE_000 = null;

  public static Keyword KWD_STRING_CONSTANT = null;

  public static Surrogate SGT_STELLA_NUMBER = null;

  public static Surrogate SGT_STELLA_BOOLEAN = null;

  public static Keyword KWD_MYSQL = null;

  public static Surrogate SGT_STELLA_STRING_WRAPPER = null;

  public static Symbol SYM_STELLA_ITERATOR = null;

  public static Surrogate SGT_RDBMS_DATABASE = null;

  public static Surrogate SGT_RDBMS_F_ALLOCATE_DBTABLE_SPECIALIST_ITERATOR_MEMO_TABLE_000 = null;

  public static Keyword KWD_FAILURE = null;

  public static Keyword KWD_DB_LOOKUP = null;

  public static Keyword KWD_CONTINUING_SUCCESS = null;

  public static Keyword KWD_FINAL_SUCCESS = null;

  public static Keyword KWD_TECHNICAL = null;

  public static Keyword KWD_LAY = null;

  public static Symbol SYM_RDBMS_pREL = null;

  public static Symbol SYM_RDBMS_pEV = null;

  public static Symbol SYM_RDBMS_pDB = null;

  public static Symbol SYM_RDBMS_pARGS = null;

  public static Symbol SYM_STELLA_AND = null;

  public static Symbol SYM_STELLA_EXISTS = null;

  public static Symbol SYM_RDBMS_pDB_TYPE = null;

  public static Symbol SYM_RDBMS_INSTANCE_OF = null;

  public static Keyword KWD_DONT_OPTIMIZEp = null;

  public static Keyword KWD_HOW_MANY = null;

  public static Keyword KWD_ALL = null;

  public static Keyword KWD_INFERENCE_LEVEL = null;

  public static Keyword KWD_ASSERTION = null;

  public static Symbol SYM_RDBMS_F_GET_QUERY_PATTERN_EVALUATORS_QUERY_000 = null;

  public static Surrogate SGT_RDBMS_F_GET_QUERY_PATTERN_EVALUATORS_MEMO_TABLE_000 = null;

  public static Symbol SYM_RDBMS_F_GET_QUERY_PATTERN_EVALUATORS_QUERY_001 = null;

  public static Surrogate SGT_RDBMS_F_SQL_JOIN_MEMO_TABLE_000 = null;

  public static Keyword KWD_VALUE = null;

  public static Keyword KWD_WHITE_SPACE = null;

  public static Keyword KWD_SET = null;

  public static Keyword KWD_NONE = null;

  public static Surrogate SGT_RDBMS_F_SQL_QUERY_MEMO_TABLE_000 = null;

  public static Keyword KWD_TERMINAL_FAILURE = null;

  public static Surrogate SGT_RDBMS_SQL_DATABASE = null;

  public static Keyword KWD_EXTERNAL_DB_UPDATE = null;

  public static Surrogate SGT_LOGIC_NAMED_DESCRIPTION = null;

  public static Surrogate SGT_STELLA_TRUE = null;

  public static Surrogate SGT_STELLA_FALSE = null;

  public static Surrogate SGT_STELLA_THING = null;

  public static Keyword KWD_CLIP = null;

  public static Keyword KWD_ASSERT = null;

  public static Keyword KWD_RETRACT = null;

  public static Keyword KWD_ASSERT_TRUE = null;

  public static Keyword KWD_PRESUME_TRUE = null;

  public static Keyword KWD_RETRACT_TRUE = null;

  public static Keyword KWD_RETRACT_FALSE = null;

  public static Keyword KWD_ASSERT_FALSE = null;

  public static Keyword KWD_PRESUME_FALSE = null;

  public static Keyword KWD_CONCEIVE = null;

  public static Symbol SYM_RDBMS_STARTUP_RDBMS = null;

  public static Surrogate SGT_RDBMS_RUN_FETCH_QUERY = null;

  public static Surrogate SGT_STELLA_XML_ELEMENT = null;

  public static Surrogate SGT_RDBMS_TASK_ID = null;

  public static Surrogate SGT_RDBMS_SUBTASK_ID = null;

  public static Surrogate SGT_RDBMS_F_FETCH_EDB_QUERY_MEMO_TABLE_000 = null;

  public static Surrogate SGT_LOGIC_QUERY_ITERATOR = null;

  public static Symbol SYM_RDBMS_STARTUP_FETCH_INTERFACE = null;

  public static Symbol SYM_RDBMS_STARTUP_RDBMS_SYSTEM = null;

  /** Define (or redefine) a database table and map it to a function
   * The accepted syntax is:
   * 	 
   *  (defuntable &lt;relconst&gt; &lt;dbconst&gt; &lt;tablename&gt; (&lt;columndecl&gt;+)
   *     [&lt;keyword-option&gt;*]).
   * <p>
   * &lt;columndecl&gt;'s specify the names (and optionally types) of the columns
   * of the database table.  They have the same form as a PowerLoom &lt;vardecl&gt;, but
   * column names can be specified with or without question marks.  If there
   * is a question mark it will be stripped to determine the column name, otherwise
   * a question mark will be added to generate the relation variable.  The optional
   * type specifies the domain of that argument and controls any necessary coercion.
   * The name of each column HAS TO MATCH one of the columns of &lt;tablename&gt;, however,
   * the order is irrelevant and arbitrary projections can be defined by only
   * specifying some subset of &lt;tablename&gt;'s columns.
   * <p>
   * See <code>deffunction</code> for legal keyword options.
   * 
   * @param args
   * @return LogicObject
   */
  public static LogicObject defuntable(Cons args) {
    try {
      return (RDBMS.callDefuntable(args));
    } catch (LogicException e) {
      Stella.STANDARD_ERROR.nativeStream.print(Stella.exceptionMessage(e));
      return (null);
    }
  }

  public static LogicObject defuntableEvaluatorWrapper(Cons arguments) {
    return (RDBMS.defuntable(arguments));
  }

  /** Callable version of the <code>deftable</code> command (which see).
   * Expects the same arguments as <code>deftable</code> but supplied as a list.
   * @param arguments
   * @return NamedDescription
   */
  public static NamedDescription callDefuntable(Cons arguments) {
    { Stella_Object relconst = arguments.value;
      Stella_Object dbconst = arguments.rest.value;
      Stella_Object tablename = arguments.rest.rest.value;
      Stella_Object columnspecs = arguments.fourth();
      Cons dbaxioms = Cons.list$(Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_RDBMS_RELATION_TABLE, Cons.cons(relconst, Cons.cons(Cons.cons(tablename, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_RDBMS_RELATION_DATABASE, Cons.cons(relconst, Cons.cons(Cons.cons(dbconst, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_PL_KERNEL_KB_RELATION_SPECIALIST, Cons.cons(relconst, Cons.cons(Cons.cons(RDBMS.SYM_RDBMS_DBTABLE_SPECIALIST, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))));

      { Cons relationargs = null;
        Cons columnaxioms = null;

        { Object [] caller_MV_returnarray = new Object[1];

          relationargs = RDBMS.parseColumnSpecs(relconst, columnspecs, caller_MV_returnarray);
          columnaxioms = ((Cons)(caller_MV_returnarray[0]));
        }
        arguments.fourthSetter(relationargs);
        dbaxioms.concatenate(columnaxioms, Stella.NIL);
      }
      return (Logic.callDeffunction(Cons.cons(relconst, arguments.rest.rest.rest.concatenate(Cons.list$(Cons.cons(RDBMS.KWD_AXIOMS, Cons.cons(dbaxioms, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL))));
    }
  }

  /** Define (or redefine) a database table and map it to a relation.
   * The accepted syntax is:
   * 	 
   *  (deftable &lt;relconst&gt; &lt;dbconst&gt; &lt;tablename&gt; (&lt;columndecl&gt;+)
   *     [&lt;keyword-option&gt;*]).
   * 	
   * &lt;columndecl&gt;'s specify the names (and optionally types) of the columns
   * of the database table.  They have the same form as a PowerLoom &lt;vardecl&gt;, but
   * column names can be specified with or without question marks.  If there
   * is a question mark it will be stripped to determine the column name, otherwise
   * a question mark will be added to generate the relation variable.  The optional
   * type specifies the domain of that argument and controls any necessary coercion.
   * The name of each column HAS TO MATCH one of the columns of &lt;tablename&gt;, however,
   * the order is irrelevant and arbitrary projections can be defined by only
   * specifying some subset of &lt;tablename&gt;'s columns.
   * <p>
   * See <code>defrelation</code> for legal keyword options.
   * 
   * @param args
   * @return LogicObject
   */
  public static LogicObject deftable(Cons args) {
    try {
      return (RDBMS.callDeftable(args));
    } catch (LogicException e) {
      Stella.STANDARD_ERROR.nativeStream.print(Stella.exceptionMessage(e));
      return (null);
    }
  }

  public static LogicObject deftableEvaluatorWrapper(Cons arguments) {
    return (RDBMS.deftable(arguments));
  }

  /** Callable version of the <code>deftable</code> command (which see).
   * Expects the same arguments as <code>deftable</code> but supplied as a list.
   * @param arguments
   * @return NamedDescription
   */
  public static NamedDescription callDeftable(Cons arguments) {
    { Stella_Object relconst = arguments.value;
      Stella_Object dbconst = arguments.rest.value;
      Stella_Object tablename = arguments.rest.rest.value;
      Stella_Object columnspecs = arguments.fourth();
      Cons dbaxioms = Cons.list$(Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_RDBMS_RELATION_TABLE, Cons.cons(relconst, Cons.cons(Cons.cons(tablename, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_RDBMS_RELATION_DATABASE, Cons.cons(relconst, Cons.cons(Cons.cons(dbconst, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_PL_KERNEL_KB_RELATION_SPECIALIST, Cons.cons(relconst, Cons.cons(Cons.cons(RDBMS.SYM_RDBMS_DBTABLE_SPECIALIST, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))));

      { Cons relationargs = null;
        Cons columnaxioms = null;

        { Object [] caller_MV_returnarray = new Object[1];

          relationargs = RDBMS.parseColumnSpecs(relconst, columnspecs, caller_MV_returnarray);
          columnaxioms = ((Cons)(caller_MV_returnarray[0]));
        }
        arguments.fourthSetter(relationargs);
        dbaxioms.concatenate(columnaxioms, Stella.NIL);
      }
      return (Logic.callDefrelation(Cons.cons(relconst, arguments.rest.rest.rest.concatenate(Cons.list$(Cons.cons(RDBMS.KWD_AXIOMS, Cons.cons(dbaxioms, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL))));
    }
  }

  public static PropertyList parseOneColumnSpec(Stella_Object columnspec) {
    { PropertyList parsedcolumn = PropertyList.newPropertyList();
      Symbol var = null;
      Stella_Object name = null;
      Cons options = Stella.NIL;
      PropertyList optionsplist = null;
      Stella_Object type = null;

      { Surrogate testValue000 = Stella_Object.safePrimaryType(columnspec);

        if (testValue000 == RDBMS.SGT_STELLA_CONS) {
          { Cons columnspec000 = ((Cons)(columnspec));

            name = columnspec000.value;
            if ((columnspec000.rest.value != null) &&
                (!Stella_Object.keywordP(columnspec000.rest.value))) {
              {
                type = columnspec000.rest.value;
                options = columnspec000.rest.rest;
              }
            }
            else {
              options = columnspec000.rest;
            }
          }
        }
        else if (Surrogate.subtypeOfSymbolP(testValue000)) {
          { Symbol columnspec000 = ((Symbol)(columnspec));

            name = columnspec000;
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                stream000.nativeStream.println("PARSING ERROR: Illegal table column specification: `" + columnspec + "'.");
                Logic.helpSignalPropositionError(stream000, RDBMS.KWD_ERROR);

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
              }
            }
            throw ((ParsingError)(ParsingError.newParsingError(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      if (!((name != null) &&
          Stella_Object.symbolP(name))) {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              stream001.nativeStream.println("PARSING ERROR: Illegal table column name: `" + name + "'.");
              Logic.helpSignalPropositionError(stream001, RDBMS.KWD_ERROR);

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
            }
          }
          throw ((ParsingError)(ParsingError.newParsingError(stream001.theStringReader()).fillInStackTrace()));
        }
      }
      if (!((type == null) ||
          Stella_Object.symbolP(type))) {
        { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

          { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              stream002.nativeStream.println("PARSING ERROR: Illegal table column type: `" + type + "'.");
              Logic.helpSignalPropositionError(stream002, RDBMS.KWD_ERROR);

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
            }
          }
          throw ((ParsingError)(ParsingError.newParsingError(stream002.theStringReader()).fillInStackTrace()));
        }
      }
      optionsplist = Stella_Object.vetOptions(options, Stella.getQuotedTree("((:MODULE-NAME :MODULE-REFERENCE) \"/RDBMS\")", "/RDBMS"));
      var = ((Symbol)(name));
      if (Logic.questionMarkSymbolP(name)) {
        name = StringWrapper.wrapString(Native.string_subsequence(var.symbolName, 1, Stella.NULL_INTEGER));
      }
      else {
        name = StringWrapper.wrapString(var.symbolName);
        var = Symbol.internDerivedSymbol(var, "?" + ((StringWrapper)(name)).wrapperValue);
      }
      parsedcolumn.insertAt(RDBMS.KWD_NAME, name);
      parsedcolumn.insertAt(RDBMS.KWD_VARIABLE, var);
      if (type != null) {
        parsedcolumn.insertAt(RDBMS.KWD_TYPE, type);
      }
      { Stella_Object key = null;
        Stella_Object val = null;
        Cons iter000 = optionsplist.thePlist;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
          key = iter000.value;
          val = iter000.rest.value;
          parsedcolumn.insertAt(key, val);
        }
      }
      return (parsedcolumn);
    }
  }

  public static Cons parseColumnSpecs(Stella_Object relconst, Stella_Object columnspecs, Object [] MV_returnarray) {
    if (!(Stella_Object.consP(columnspecs))) {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            stream000.nativeStream.println("PARSING ERROR: Illegal variable/column specifications: `" + columnspecs + "'.");
            Logic.helpSignalPropositionError(stream000, RDBMS.KWD_ERROR);

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        throw ((ParsingError)(ParsingError.newParsingError(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    { Cons relationargs = Stella.NIL;
      Cons axioms = Stella.NIL;

      { Stella_Object columnspec = null;
        Cons iter000 = ((Cons)(columnspecs));
        int i = Stella.NULL_INTEGER;
        int iter001 = 1;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
          columnspec = iter000.value;
          i = iter001;
          { PropertyList columninfo = RDBMS.parseOneColumnSpec(columnspec);
            Stella_Object type = columninfo.lookup(RDBMS.KWD_TYPE);
            Stella_Object name = columninfo.lookup(RDBMS.KWD_NAME);
            Stella_Object var = columninfo.lookup(RDBMS.KWD_VARIABLE);
            Stella_Object modulename = columninfo.lookup(RDBMS.KWD_MODULE_NAME);
            Stella_Object modulereference = columninfo.lookup(RDBMS.KWD_MODULE_REFERENCE);

            if (type != null) {
              relationargs = Cons.cons(Cons.consList(Cons.cons(var, Cons.cons(type, Stella.NIL))), relationargs);
            }
            else {
              relationargs = Cons.cons(var, relationargs);
            }
            if (name != null) {
              axioms = Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_RDBMS_RELATION_COLUMN_NAME, Cons.cons(relconst, Cons.cons(Cons.cons(IntegerWrapper.wrapInteger(i), Cons.cons(name, Stella.NIL)), Stella.NIL)))), axioms);
            }
            if (modulename != null) {
              axioms = Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_RDBMS_RELATION_COLUMN_MODULE_NAME, Cons.cons(relconst, Cons.cons(Cons.cons(IntegerWrapper.wrapInteger(i), Cons.cons(modulename, Stella.NIL)), Stella.NIL)))), axioms);
            }
            if (modulereference != null) {
              axioms = Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_RDBMS_RELATION_COLUMN_MODULE_REFERENCE, Cons.cons(relconst, Cons.cons(Cons.cons(IntegerWrapper.wrapInteger(i), Cons.cons(modulereference, Stella.NIL)), Stella.NIL)))), axioms);
            }
          }
        }
      }
      { Cons _return_temp = relationargs.reverse();

        MV_returnarray[0] = axioms.reverse();
        return (_return_temp);
      }
    }
  }

  /** Define (or redefine) a database instance.  The accepted syntax is:
   * 	 
   *  (defdb &lt;dbconst&gt;
   *     [:protocol &lt;protocol string&gt;]
   *     [:server-type &lt;server type string&gt;]
   *     [:dsn &lt;ODBC data-source name string&gt;]
   *     [:odbc-connection-string &lt;ODBC connection string&gt;]
   *     [:jdbc-connection-string &lt;JDBC connection string&gt;]
   *     [:connection-string &lt;connection string&gt;] ;; deprecated
   *     [:host &lt;server host string&gt;]
   *     [:port &lt;server host port&gt;]
   *     [:user &lt;user name string&gt;]
   *     [:password &lt;password string&gt;]
   *     [:db-name &lt;database name string&gt;]
   *     [&lt;keyword-option&gt;*])
   * 	
   * Connection information can be asserted explicitly later or be done
   * programmatically, as long as it is done before the first time a
   * connection attempt is made (e.g., during a query).  This information
   * is passed to <code>SDBCSconnect</code> (which see for more documentation on
   * ways to specify a connection).  For example, for ODBC a :DSN, an
   * :ODBC-CONNECTION-STRING or an appropriate combination of :HOST,
   * :PORT, :USER, :PASSWORD AND :DB-NAME can be used.  For JDBC a
   * :JDBC-CONNECTION-STRING or combination of :HOST, :PORT, etc. can
   * be used.  See <code>defobject</code> for additional legal keyword options.
   * 
   * @param args
   * @return LogicObject
   */
  public static LogicObject defdb(Cons args) {
    try {
      return (RDBMS.callDefdb(args));
    } catch (LogicException e) {
      Stella.STANDARD_ERROR.nativeStream.print(Stella.exceptionMessage(e));
      return (null);
    }
  }

  public static LogicObject defdbEvaluatorWrapper(Cons arguments) {
    return (RDBMS.defdb(arguments));
  }

  /** Callable version of of the <code>defdb</code> command (which see).
   * Expects the same arguments as <code>defdb</code> but supplied as a list.
   * @param arguments
   * @return LogicObject
   */
  public static LogicObject callDefdb(Cons arguments) {
    { Cons definition = Cons.cons(RDBMS.SYM_RDBMS_DEFDB, arguments.concatenate(Stella.NIL, Stella.NIL));
      Symbol dbname = null;
      Cons dbaxioms = Stella.NIL;
      Cons relationoptions = Stella.NIL;

      { Object old$Termsourcebeingparsed$000 = Logic.$TERMSOURCEBEINGPARSED$.get();

        try {
          Native.setSpecial(Logic.$TERMSOURCEBEINGPARSED$, Native.stringify(definition));
          arguments = Logic.normalizeDefobjectArguments(arguments);
          dbname = ((Symbol)(arguments.value));
          { Object [] caller_MV_returnarray = new Object[1];

            dbaxioms = RDBMS.extractRdbmsOptions(dbname, arguments.rest, caller_MV_returnarray);
            relationoptions = ((Cons)(caller_MV_returnarray[0]));
          }
          dbaxioms = Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_RDBMS_DATABASE, Cons.cons(dbname, Cons.cons(Stella.NIL, Stella.NIL)))), dbaxioms);
          arguments.rest = relationoptions.concatenate(Cons.list$(Cons.cons(RDBMS.KWD_AXIOMS, Cons.cons(dbaxioms, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL);
          return (Logic.callDefobject(arguments));

        } finally {
          Logic.$TERMSOURCEBEINGPARSED$.set(old$Termsourcebeingparsed$000);
        }
      }
    }
  }

  public static Cons extractRdbmsOptions(Symbol selfname, Cons options, Object [] MV_returnarray) {
    { PropertyList self000 = PropertyList.newPropertyList();

      self000.thePlist = options;
      { PropertyList sourceoptions = self000;
        Module rdbmsmodule = Stella.getStellaModule("RDBMS", true);
        Surrogate relationref = null;
        NamedDescription relation = null;
        Cons axioms = Stella.NIL;
        Cons otheroptions = Stella.NIL;

        { Stella_Object key = null;
          Stella_Object value = null;
          Cons iter000 = sourceoptions.thePlist;

          loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
            key = iter000.value;
            value = iter000.rest.value;
            if (Stella_Object.keywordP(key)) {
              relationref = Surrogate.lookupSurrogateInModule(((Keyword)(key)).symbolName, rdbmsmodule, true);
              if (relationref != null) {
                relation = Logic.getDescription(relationref);
                if (relation != null) {
                  if (Stella_Object.consP(value)) {
                    axioms = Cons.cons(Cons.cons(relation.descriptionName(), Cons.cons(selfname, ((Cons)(value)))), axioms);
                  }
                  else {
                    { Object old$Module$000 = Stella.$MODULE$.get();
                      Object old$Context$000 = Stella.$CONTEXT$.get();

                      try {
                        Native.setSpecial(Stella.$MODULE$, rdbmsmodule);
                        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
                        axioms = Cons.cons(Logic.helpDefineKeywordAxioms(selfname, ((Keyword)(key)), value), axioms);

                      } finally {
                        Stella.$CONTEXT$.set(old$Context$000);
                        Stella.$MODULE$.set(old$Module$000);
                      }
                    }
                  }
                  continue loop000;
                }
              }
            }
            otheroptions = Cons.cons(key, otheroptions);
            otheroptions = Cons.cons(value, otheroptions);
          }
        }
        { Cons _return_temp = axioms.reverse();

          MV_returnarray[0] = otheroptions.reverse();
          return (_return_temp);
        }
      }
    }
  }

  /** Assert DB connectivity information about the DB instance <code>dbInstanceName</code> (for
   * example, &quot;edb&quot;) according to <code>options</code>.  Looks up <code>dbInstanceName</code> in the module
   * specified by the :module option (defaults to current module) and retracts any
   * preexisting connection information.  New assertions are also made in that module.
   * Default values are taken from the configuration table specified by :configuration.
   * <p>
   * Understands the following options, with default values specified by the configuration
   * key in parentheses:
   *    :connection-string (&quot;DBConnection&quot;),
   *    :jdbc-connection-string (&quot;JDBCString&quot;),
   *    :odbc-connection-string (&quot;ODBCString&quot;),
   *    :dsn (&quot;DSN&quot;),
   *    :db (&quot;DBName&quot;),
   *    :host (&quot;DBHost&quot;),
   *    :port (&quot;DBPort&quot;),
   *    :user (&quot;DBUser&quot;),
   *    :password (&quot;DBPassword&quot;),
   *    :module,
   *    :configuration.
   * @param dbInstanceName
   * @param options
   */
  public static void assertRdbmsConnectionInfo(String dbInstanceName, Cons options) {
    { PropertyList theoptions = Logic.parseLogicCommandOptions(options, Cons.list$(Cons.cons(RDBMS.KWD_CONNECTION_STRING, Cons.cons(RDBMS.SGT_STELLA_STRING, Cons.cons(RDBMS.KWD_JDBC_CONNECTION_STRING, Cons.cons(RDBMS.SGT_STELLA_STRING, Cons.cons(RDBMS.KWD_ODBC_CONNECTION_STRING, Cons.cons(RDBMS.SGT_STELLA_STRING, Cons.cons(RDBMS.KWD_DSN, Cons.cons(RDBMS.SGT_STELLA_STRING, Cons.cons(RDBMS.KWD_DB, Cons.cons(RDBMS.SGT_STELLA_STRING, Cons.cons(RDBMS.KWD_HOST, Cons.cons(RDBMS.SGT_STELLA_STRING, Cons.cons(RDBMS.KWD_PORT, Cons.cons(RDBMS.SGT_STELLA_INTEGER, Cons.cons(RDBMS.KWD_USER, Cons.cons(RDBMS.SGT_STELLA_STRING, Cons.cons(RDBMS.KWD_PASSWORD, Cons.cons(RDBMS.SGT_STELLA_STRING, Cons.cons(RDBMS.KWD_MODULE, Cons.cons(RDBMS.SGT_STELLA_MODULE, Cons.cons(RDBMS.KWD_CONFIGURATION, Cons.cons(RDBMS.SGT_STELLA_CONFIGURATION_TABLE, Cons.cons(Stella.NIL, Stella.NIL)))))))))))))))))))))))), true, false);
      Stella_Object config = theoptions.lookup(RDBMS.KWD_CONFIGURATION);
      StringWrapper conString = ((StringWrapper)(theoptions.lookupWithDefault(RDBMS.KWD_CONNECTION_STRING, Stella.lookupConfigurationProperty("DBConnection", null, ((KeyValueList)(config))))));
      StringWrapper jdbcConString = ((StringWrapper)(theoptions.lookupWithDefault(RDBMS.KWD_CONNECTION_STRING, Stella.lookupConfigurationProperty("JDBCString", null, ((KeyValueList)(config))))));
      StringWrapper odbcConString = ((StringWrapper)(theoptions.lookupWithDefault(RDBMS.KWD_CONNECTION_STRING, Stella.lookupConfigurationProperty("ODBCString", null, ((KeyValueList)(config))))));
      StringWrapper dsn = ((StringWrapper)(theoptions.lookupWithDefault(RDBMS.KWD_DSN, Stella.lookupConfigurationProperty("DSN", null, ((KeyValueList)(config))))));
      StringWrapper dbName = ((StringWrapper)(theoptions.lookupWithDefault(RDBMS.KWD_DB_NAME, Stella.lookupConfigurationProperty("DBName", null, ((KeyValueList)(config))))));
      StringWrapper host = ((StringWrapper)(theoptions.lookupWithDefault(RDBMS.KWD_HOST, Stella.lookupConfigurationProperty("DBHost", null, ((KeyValueList)(config))))));
      IntegerWrapper port = ((IntegerWrapper)(theoptions.lookupWithDefault(RDBMS.KWD_PORT, Stella.lookupConfigurationProperty("DBPort", null, ((KeyValueList)(config))))));
      StringWrapper user = ((StringWrapper)(theoptions.lookupWithDefault(RDBMS.KWD_USER, Stella.lookupConfigurationProperty("DBUser", null, ((KeyValueList)(config))))));
      StringWrapper password = ((StringWrapper)(theoptions.lookupWithDefault(RDBMS.KWD_PASSWORD, Stella.lookupConfigurationProperty("DBPassword", null, ((KeyValueList)(config))))));
      Module module = ((Module)(theoptions.lookupWithDefault(RDBMS.KWD_MODULE, ((Module)(Stella.$MODULE$.get())))));
      String moduleName = module.moduleFullName;
      Stella_Object dbObject = edu.isi.powerloom.PLI.sGetObject(dbInstanceName, moduleName, null);
      String assertionTemplate = Stella.instantiateStringTemplate("(AND" + ((((jdbcConString != null) &&
          (!Stella.stringEqlP(jdbcConString.wrapperValue, ""))) ? "(RDBMS/JDBC-CONNECTION-STRING #$DB \"#$JDBCCON\")" : "")) + ((((odbcConString != null) &&
          (!Stella.stringEqlP(odbcConString.wrapperValue, ""))) ? "(RDBMS/ODBC-CONNECTION-STRING #$DB \"#$ODBCCON\")" : "")) + ((((dsn != null) &&
          (!Stella.stringEqlP(dsn.wrapperValue, ""))) ? "(RDBMS/DSN #$DB \"#$DSN\")" : "")) + ((((dbName != null) &&
          (!Stella.stringEqlP(dbName.wrapperValue, ""))) ? "(RDBMS/DB-NAME #$DB \"#$NAME\")" : "")) + ((((host != null) &&
          (!Stella.stringEqlP(host.wrapperValue, ""))) ? "(RDBMS/HOST #$DB \"#$HOST\")" : "")) + (((port != null) ? "(RDBMS/PORT #$DB #$PORT)" : "")) + ((((user != null) &&
          (!Stella.stringEqlP(user.wrapperValue, ""))) ? "(RDBMS/USER #$DB \"#$USER\")" : "")) + ((((password != null) &&
          (!Stella.stringEqlP(password.wrapperValue, ""))) ? "(RDBMS/PASSWORD #$DB \"#$PWD\")" : "")) + ")", Cons.cons(StringWrapper.wrapString("#$DB"), Cons.cons(StringWrapper.wrapString(dbInstanceName), Cons.cons(StringWrapper.wrapString("#$DSN"), Cons.cons(StringWrapper.wrapString(dsn.wrapperValue), Cons.cons(StringWrapper.wrapString("#$NAME"), Cons.cons(StringWrapper.wrapString(((dbName != null) ? dbName.wrapperValue : "")), Cons.cons(StringWrapper.wrapString("#$HOST"), Cons.cons(StringWrapper.wrapString(((host != null) ? host.wrapperValue : "")), Cons.cons(StringWrapper.wrapString("#$PORT"), Cons.cons(StringWrapper.wrapString(((port != null) ? Native.integerToString(((long)(port.wrapperValue))) : "")), Cons.cons(StringWrapper.wrapString("#$USER"), Cons.cons(StringWrapper.wrapString(((user != null) ? user.wrapperValue : "")), Cons.cons(StringWrapper.wrapString("#$PWD"), Cons.cons(StringWrapper.wrapString(((password != null) ? password.wrapperValue : "")), Cons.cons(StringWrapper.wrapString("#$JDBCCON"), Cons.cons(StringWrapper.wrapString(((jdbcConString != null) ? jdbcConString.wrapperValue : "")), Cons.cons(StringWrapper.wrapString("#$ODBCCON"), Cons.cons(StringWrapper.wrapString(((odbcConString != null) ? odbcConString.wrapperValue : "")), Stella.NIL)))))))))))))))))));

      if (dbObject != null) {
        edu.isi.powerloom.PLI.sEvaluate(Stella.instantiateStringTemplate("(PROGN (RETRACT-FROM-QUERY (RETRIEVE ALL (RDBMS/DSN #$DB ?dsn)))\n                  (RETRACT-FROM-QUERY (RETRIEVE ALL (RDBMS/DB-NAME #$DB ?db)))\n                  (RETRACT-FROM-QUERY (RETRIEVE ALL (RDBMS/HOST #$DB ?host)))\n                  (RETRACT-FROM-QUERY (RETRIEVE ALL (RDBMS/PORT #$DB ?port)))\n                  (RETRACT-FROM-QUERY (RETRIEVE ALL (RDBMS/USER #$DB ?user)))\n                  (RETRACT-FROM-QUERY (RETRIEVE ALL (RDBMS/PASSWORD #$DB ?pwd)))\n                  (RETRACT-FROM-QUERY (RETRIEVE ALL (RDBMS/CONNECTION-STRING #$DB ?con)))\n                  (RETRACT-FROM-QUERY (RETRIEVE ALL (RDBMS/ODBC-CONNECTION-STRING #$DB ?con)))\n                  (RETRACT-FROM-QUERY (RETRIEVE ALL (RDBMS/JDBC-CONNECTION-STRING #$DB ?con))))", Cons.cons(StringWrapper.wrapString("#$DB"), Cons.cons(StringWrapper.wrapString(dbInstanceName), Stella.NIL))), moduleName, null);
      }
      if (conString != null) {
        edu.isi.powerloom.PLI.sAssertProposition(Stella.instantiateStringTemplate("(RDBMS/#$PROTOCOL-CONNECTION-STRING #$DB \"#$CON\")", Cons.cons(StringWrapper.wrapString("#$PROTOCOL"), Cons.cons(StringWrapper.wrapString((edu.isi.sdbc.Sdbc.odbcConnectionStringP(conString.wrapperValue) ? "ODBC" : "JDBC")), Cons.cons(StringWrapper.wrapString("#$DB"), Cons.cons(StringWrapper.wrapString(dbInstanceName), Cons.cons(StringWrapper.wrapString("#$CON"), Cons.cons(StringWrapper.wrapString(conString.wrapperValue), Stella.NIL))))))), moduleName, null);
      }
      if (!(Stella.stringEqlP(assertionTemplate, "(AND)"))) {
        edu.isi.powerloom.PLI.sAssertProposition(assertionTemplate, moduleName, null);
      }
    }
  }

  public static void assertRdbmsConnectionInfoEvaluatorWrapper(Cons arguments) {
    RDBMS.assertRdbmsConnectionInfo(((StringWrapper)(arguments.value)).wrapperValue, arguments.rest);
  }

  /** Define (or redefine) an (external) query and map it to a relation.
   * The accepted syntax is:
   * 	 
   *  (defquery &lt;relconst&gt; (&lt;vardecl&gt;+)
   *     {:query-pattern (&lt;query-evaluator&gt; &lt;dbconst&gt; &lt;arguments-string&gt;)}*
   *     [&lt;keyword-option&gt;*]).
   * 	
   * &lt;query-evaluator&gt; has to be a <code>Computed_Procedure</code> that takes the following
   * three arguments: the &lt;relconst&gt; query proposition, the database object &lt;dbconst&gt;
   * and the arguments string.  It needs to return an iterator that generates CONS
   * tuples whose elements will be bound in sequence to &lt;relconst&gt;'s arguments.
   * <p>
   * See <code>defrelation</code> for other legal keyword options.
   * 
   * @param args
   * @return LogicObject
   */
  public static LogicObject defquery(Cons args) {
    try {
      return (RDBMS.callDefquery(args));
    } catch (LogicException e) {
      Stella.STANDARD_ERROR.nativeStream.print(Stella.exceptionMessage(e));
      return (null);
    }
  }

  public static LogicObject defqueryEvaluatorWrapper(Cons arguments) {
    return (RDBMS.defquery(arguments));
  }

  /** Callable version of the <code>defquery</code> command (which see).
   * Expects the same arguments as <code>deftable</code> but supplied as a list.
   * @param arguments
   * @return NamedDescription
   */
  public static NamedDescription callDefquery(Cons arguments) {
    { Cons definition = Cons.cons(RDBMS.SYM_RDBMS_DEFQUERY, arguments.concatenate(Stella.NIL, Stella.NIL));
      Symbol relationname = null;
      Cons queryaxioms = Stella.NIL;
      Cons relationoptions = Stella.NIL;

      { Object old$Termsourcebeingparsed$000 = Logic.$TERMSOURCEBEINGPARSED$.get();

        try {
          Native.setSpecial(Logic.$TERMSOURCEBEINGPARSED$, Native.stringify(definition));
          arguments = Logic.normalizeDefrelationArguments(arguments);
          relationname = ((Symbol)(arguments.value));
          { Object [] caller_MV_returnarray = new Object[1];

            queryaxioms = RDBMS.extractRdbmsOptions(relationname, arguments.rest.rest, caller_MV_returnarray);
            relationoptions = ((Cons)(caller_MV_returnarray[0]));
          }
          queryaxioms = Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_PL_KERNEL_KB_RELATION_SPECIALIST, Cons.cons(relationname, Cons.cons(Cons.cons(RDBMS.SYM_RDBMS_QUERY_SPECIALIST, Stella.NIL), Stella.NIL)))), queryaxioms);
          { Cons relationargs = null;
            Cons columnaxioms = null;

            { Object [] caller_MV_returnarray = new Object[1];

              relationargs = RDBMS.parseColumnSpecs(relationname, arguments.rest.value, caller_MV_returnarray);
              columnaxioms = ((Cons)(caller_MV_returnarray[0]));
            }
            arguments.secondSetter(relationargs);
            queryaxioms.concatenate(columnaxioms, Stella.NIL);
          }
          arguments.rest.rest = relationoptions.concatenate(Cons.list$(Cons.cons(RDBMS.KWD_AXIOMS, Cons.cons(queryaxioms, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL);
          return (Logic.callDefrelation(arguments));

        } finally {
          Logic.$TERMSOURCEBEINGPARSED$.set(old$Termsourcebeingparsed$000);
        }
      }
    }
  }

  public static StringWrapper normalizeConnectionArgument(Stella_Object arg) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(arg);

      if (Surrogate.subtypeOfStringP(testValue000)) {
        { StringWrapper arg000 = ((StringWrapper)(arg));

          if (Logic.nullWrapperP(arg000)) {
            return (null);
          }
          else {
            return (arg000);
          }
        }
      }
      else if (Surrogate.subtypeOfIntegerP(testValue000)) {
        { IntegerWrapper arg000 = ((IntegerWrapper)(arg));

          if (Logic.nullWrapperP(arg000)) {
            return (null);
          }
          else {
            return (StringWrapper.wrapString(Native.integerToString(((long)(arg000.wrapperValue)))));
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, RDBMS.SGT_LOGIC_LOGIC_OBJECT)) {
        { LogicObject arg000 = ((LogicObject)(arg));

          return (StringWrapper.wrapString(edu.isi.powerloom.PLI.getName(arg000)));
        }
      }
      else {
        return (null);
      }
    }
  }

  public static edu.isi.sdbc.Connection connectToDatabase(LogicObject database) {
    { Stella_Object protocol = Logic.accessBinaryValue(database, RDBMS.SGT_RDBMS_PROTOCOL);
      Stella_Object servertype = Logic.accessBinaryValue(database, RDBMS.SGT_RDBMS_SERVER_TYPE);
      Stella_Object host = Logic.accessBinaryValue(database, RDBMS.SGT_RDBMS_HOST);
      Stella_Object port = Logic.accessBinaryValue(database, RDBMS.SGT_RDBMS_PORT);
      Stella_Object user = Logic.accessBinaryValue(database, RDBMS.SGT_RDBMS_USER);
      Stella_Object password = Logic.accessBinaryValue(database, RDBMS.SGT_RDBMS_PASSWORD);
      Stella_Object dbname = Logic.accessBinaryValue(database, RDBMS.SGT_RDBMS_DB_NAME);

      { Stella_Object temp000 = Logic.accessBinaryValue(database, RDBMS.SGT_RDBMS_JDBC_CONNECTION_STRING);

        { Stella_Object connectionstring = ((temp000 != null) ? temp000 : Logic.accessBinaryValue(database, RDBMS.SGT_RDBMS_CONNECTION_STRING));
          Stella_Object dsn = Logic.accessBinaryValue(database, RDBMS.SGT_RDBMS_DSN);
          edu.isi.sdbc.Connection connection = null;
          ConnectionWrapper connectionwrapper = ConnectionWrapper.newConnectionWrapper();

          connection = edu.isi.sdbc.Sdbc.connect(Cons.cons(RDBMS.KWD_PROTOCOL, Cons.cons(RDBMS.normalizeConnectionArgument(protocol), Cons.cons(RDBMS.KWD_SERVER_TYPE, Cons.cons(RDBMS.normalizeConnectionArgument(servertype), Cons.cons(RDBMS.KWD_DSN, Cons.cons(RDBMS.normalizeConnectionArgument(dsn), Cons.cons(RDBMS.KWD_DB_NAME, Cons.cons(RDBMS.normalizeConnectionArgument(dbname), Cons.cons(RDBMS.KWD_USER, Cons.cons(RDBMS.normalizeConnectionArgument(user), Cons.cons(RDBMS.KWD_PASSWORD, Cons.cons(RDBMS.normalizeConnectionArgument(password), Cons.cons(RDBMS.KWD_HOST, Cons.cons(RDBMS.normalizeConnectionArgument(host), Cons.cons(RDBMS.KWD_PORT, Cons.cons(RDBMS.normalizeConnectionArgument(port), Cons.cons(RDBMS.KWD_CONNECTION_STRING, Cons.cons(RDBMS.normalizeConnectionArgument(connectionstring), Stella.NIL)))))))))))))))))));
          connectionwrapper.wrapperValue = connection;
          { Object old$Module$000 = Stella.$MODULE$.get();
            Object old$Context$000 = Stella.$CONTEXT$.get();

            try {
              Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
              Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
              { Object old$InvisibleassertionP$000 = Logic.$INVISIBLEASSERTIONp$.get();

                try {
                  Native.setBooleanSpecial(Logic.$INVISIBLEASSERTIONp$, true);
                  edu.isi.powerloom.PLI.assertNaryProposition(Cons.cons(Logic.getRelation(RDBMS.SGT_RDBMS_DB_CONNECTION), Cons.cons(database, Cons.cons(connectionwrapper, Stella.NIL))), null, null);

                } finally {
                  Logic.$INVISIBLEASSERTIONp$.set(old$InvisibleassertionP$000);
                }
              }

            } finally {
              Stella.$CONTEXT$.set(old$Context$000);
              Stella.$MODULE$.set(old$Module$000);
            }
          }
          return (connection);
        }
      }
    }
  }

  public static void disconnectFromDatabase(LogicObject database) {
    { Stella_Object connection = Logic.accessBinaryValue(database, RDBMS.SGT_RDBMS_DB_CONNECTION);

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(connection), RDBMS.SGT_RDBMS_CONNECTION_WRAPPER)) {
        { ConnectionWrapper connection000 = ((ConnectionWrapper)(connection));

          if (connection000.wrapperValue != null) {
            edu.isi.sdbc.Connection.disconnect(connection000.wrapperValue);
          }
          { Object old$Module$000 = Stella.$MODULE$.get();
            Object old$Context$000 = Stella.$CONTEXT$.get();

            try {
              Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
              Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
              edu.isi.powerloom.PLI.retractNaryProposition(Cons.cons(Logic.getRelation(RDBMS.SGT_RDBMS_DB_CONNECTION), Cons.cons(database, Cons.cons(connection000, Stella.NIL))), null, null);

            } finally {
              Stella.$CONTEXT$.set(old$Context$000);
              Stella.$MODULE$.set(old$Module$000);
            }
          }
        }
      }
      else {
      }
    }
  }

  public static edu.isi.sdbc.Connection getConnectionFromDatabase(LogicObject database) {
    { Stella_Object connection = Logic.accessBinaryValue(database, RDBMS.SGT_RDBMS_DB_CONNECTION);

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(connection), RDBMS.SGT_RDBMS_CONNECTION_WRAPPER)) {
        { ConnectionWrapper connection000 = ((ConnectionWrapper)(connection));

          return (connection000.wrapperValue);
        }
      }
      else {
        return (RDBMS.connectToDatabase(database));
      }
    }
  }

  public static edu.isi.sdbc.Connection getConnectionFromPredicate(Surrogate relationref) {
    { Stella_Object database = Logic.accessBinaryValue(Logic.getDescription(relationref), RDBMS.SGT_RDBMS_RELATION_DATABASE);
      edu.isi.sdbc.Connection connection = RDBMS.getConnectionFromDatabase(((LogicObject)(database)));

      return (connection);
    }
  }

  public static Iterator allocateResultSetIterator(edu.isi.sdbc.Connection connection, LogicObject relation, String sqlstatement) {
    { AllPurposeIterator self000 = AllPurposeIterator.newAllPurposeIterator();

      self000.iteratorNestedIterator = edu.isi.sdbc.Connection.getResultSet(connection, sqlstatement, Stella.NIL);
      self000.iteratorObject = relation;
      self000.iteratorSecondObject = RDBMS.getRelationTableInfo(((NamedDescription)(relation)));
      self000.iteratorNextCode = Native.find_java_method("edu.isi.powerloom.rdbms.RDBMS", "resultSetIteratorNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
      { AllPurposeIterator value000 = self000;

        return (value000);
      }
    }
  }

  public static boolean resultSetIteratorNextP(AllPurposeIterator self) {
    { Iterator resultset = self.iteratorNestedIterator;
      Stella_Object tableinfo = self.iteratorSecondObject;

      if (resultset.nextP()) {
        self.value = RDBMS.coerceValues(((Cons)(resultset.value)), ((RelationTableInfo)(tableinfo)));
        return (true);
      }
      else {
        return (false);
      }
    }
  }

  public static NamedDescription getTableRelation(String tableName, Module module) {
    { edu.isi.powerloom.PlIterator iter = edu.isi.powerloom.PLI.retrieve(Cons.list$(Cons.cons(IntegerWrapper.wrapInteger(1), Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_RDBMS_RELATION_TABLE, Cons.cons(RDBMS.SYM_LOGIC_pX, Cons.cons(StringWrapper.wrapString(tableName), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), module, null);

      if (iter.nextP()) {
        return (((NamedDescription)(iter.value)));
      }
      else {
        return (null);
      }
    }
  }

  public static int getTableColumnIndex(NamedDescription tableRelation, String columnName, Module module) {
    { edu.isi.powerloom.PlIterator iter = edu.isi.powerloom.PLI.retrieve(Cons.list$(Cons.cons(IntegerWrapper.wrapInteger(1), Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_RDBMS_RELATION_COLUMN_NAME, Cons.cons(tableRelation, Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_LOGIC_pX, Cons.cons(StringWrapper.wrapString(columnName), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), module, null);

      if (iter.nextP()) {
        return (((IntegerWrapper)(iter.value)).wrapperValue);
      }
      else {
        return (-1);
      }
    }
  }

  public static StringWrapper getTableColumnModuleName(NamedDescription tablerelation, int columnindex) {
    return (((StringWrapper)(edu.isi.powerloom.PLI.retrieve(Cons.list$(Cons.cons(IntegerWrapper.wrapInteger(1), Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_RDBMS_RELATION_COLUMN_MODULE_NAME, Cons.cons(tablerelation, Cons.cons(Cons.cons(IntegerWrapper.wrapInteger(columnindex), Cons.cons(RDBMS.SYM_LOGIC_pX, Stella.NIL)), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), null, null).pop())));
  }

  public static StringWrapper getTableColumnModuleReference(NamedDescription tablerelation, int columnindex) {
    return (((StringWrapper)(edu.isi.powerloom.PLI.retrieve(Cons.list$(Cons.cons(IntegerWrapper.wrapInteger(1), Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_RDBMS_RELATION_COLUMN_MODULE_REFERENCE, Cons.cons(tablerelation, Cons.cons(Cons.cons(IntegerWrapper.wrapInteger(columnindex), Cons.cons(RDBMS.SYM_LOGIC_pX, Stella.NIL)), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), null, null).pop())));
  }

  public static StringWrapper getTableColumnName(NamedDescription tablerelation, int columnindex) {
    return (((StringWrapper)(edu.isi.powerloom.PLI.retrieve(Cons.list$(Cons.cons(IntegerWrapper.wrapInteger(1), Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_RDBMS_RELATION_COLUMN_NAME, Cons.cons(tablerelation, Cons.cons(Cons.cons(IntegerWrapper.wrapInteger(columnindex), Cons.cons(RDBMS.SYM_LOGIC_pX, Stella.NIL)), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), null, null).pop())));
  }

  public static Cons getTableColumnNames(NamedDescription tablerelation) {
    { Cons value000 = Stella.NIL;

      { RelationColumnInfo column = null;
        Cons iter000 = RDBMS.getRelationTableInfo(tablerelation).columnList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          column = ((RelationColumnInfo)(iter000.value));
          if (collect000 == null) {
            {
              collect000 = Cons.cons(StringWrapper.wrapString(column.columnName), Stella.NIL);
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
              collect000.rest = Cons.cons(StringWrapper.wrapString(column.columnName), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      { Cons names = value000;

        if (names.memberP(null)) {
          return (null);
        }
        else {
          return (names);
        }
      }
    }
  }

  public static RelationTableInfo createRelationTableInfo(NamedDescription relation) {
    { RelationTableInfo self000 = RelationTableInfo.newRelationTableInfo();

      self000.relation = relation;
      { RelationTableInfo tableinfo = self000;
        RelationColumnInfo columninfo = null;
        int arity = relation.ioVariables.length();
        Cons columns = Stella.NIL;
        Module defaultmodule = ((Context)(Stella.$CONTEXT$.get())).baseModule;

        tableinfo.database = Logic.accessBinaryValue(relation, RDBMS.SGT_RDBMS_RELATION_DATABASE);
        tableinfo.dbmsName = ((tableinfo.database != null) ? edu.isi.sdbc.Connection.getDbmsName(RDBMS.getConnectionFromDatabase(((LogicObject)(tableinfo.database)))) : RDBMS.KWD_UNKNOWN);
        tableinfo.tableName = StringWrapper.unwrapString(((StringWrapper)(Logic.accessBinaryValue(relation, RDBMS.SGT_RDBMS_RELATION_TABLE))));
        tableinfo.columnIndex = KeyValueMap.newKeyValueMap();
        { int i = Stella.NULL_INTEGER;
          int iter000 = 1;
          int upperBound000 = arity;
          boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;
          Symbol var = null;
          Cons iter001 = relation.ioVariableNames.theConsList;
          Cons collect000 = null;

          for (;(unboundedP000 ||
                    (iter000 <= upperBound000)) &&
                    (!(iter001 == Stella.NIL)); iter000 = iter000 + 1, iter001 = iter001.rest) {
            i = iter000;
            var = ((Symbol)(iter001.value));
            { RelationColumnInfo self002 = RelationColumnInfo.newRelationColumnInfo();

              self002.tableInfo = tableinfo;
              columninfo = self002;
            }
            columninfo.columnName = StringWrapper.unwrapString(RDBMS.getTableColumnName(relation, i));
            columninfo.columnVariable = var;
            columninfo.columnIndex = i - 1;
            columninfo.columnType = ((NamedDescription)(edu.isi.powerloom.PLI.getNthDomain(relation, i - 1)));
            columninfo.moduleName = StringWrapper.unwrapString(RDBMS.getTableColumnModuleName(relation, i));
            columninfo.moduleReference = StringWrapper.unwrapString(RDBMS.getTableColumnModuleReference(relation, i));
            tableinfo.columnIndex.insertAt(StringWrapper.wrapString(columninfo.columnName), columninfo);
            tableinfo.columnIndex.insertAt(var, columninfo);
            tableinfo.columnIndex.insertAt(StringWrapper.wrapString(var.symbolName), columninfo);
            if (collect000 == null) {
              {
                collect000 = Cons.cons(columninfo, Stella.NIL);
                if (columns == Stella.NIL) {
                  columns = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(columns, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(columninfo, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        tableinfo.columnList = columns;
        tableinfo.columnVector = Logic.consToVector(columns);
        { RelationColumnInfo column = null;
          Cons iter002 = tableinfo.columnList;

          for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
            column = ((RelationColumnInfo)(iter002.value));
            if (column.moduleName != null) {
              column.moduleLocalP = true;
              column.module = Stella.getStellaModule(column.moduleName, false);
              if (column.module == null) {
                Stella.STANDARD_WARNING.nativeStream.println("Warning: RDBMS: Column module `" + column.moduleName + "' for column `" + column.columnName + "' on relation `" + relation + "' is not defined; ignoring it...");
                column.module = defaultmodule;
              }
            }
            else if (column.moduleReference != null) {
              column.moduleLocalP = true;
              column.moduleReferenceColumn = ((RelationColumnInfo)(tableinfo.columnIndex.lookup(StringWrapper.wrapString(column.moduleReference))));
            }
            else {
              column.module = defaultmodule;
            }
          }
        }
        return (tableinfo);
      }
    }
  }

  public static RelationTableInfo getRelationTableInfo(NamedDescription tablerelation) {
    { MemoizationTable memoTable000 = null;
      Cons memoizedEntry000 = null;
      Stella_Object memoizedValue000 = null;

      if (Stella.$MEMOIZATION_ENABLEDp$) {
        memoTable000 = ((MemoizationTable)(RDBMS.SGT_RDBMS_F_GET_RELATION_TABLE_INFO_MEMO_TABLE_000.surrogateValue));
        if (memoTable000 == null) {
          Surrogate.initializeMemoizationTable(RDBMS.SGT_RDBMS_F_GET_RELATION_TABLE_INFO_MEMO_TABLE_000, "(:MAX-VALUES 100 :TIMESTAMPS (:META-KB-UPDATE))");
          memoTable000 = ((MemoizationTable)(RDBMS.SGT_RDBMS_F_GET_RELATION_TABLE_INFO_MEMO_TABLE_000.surrogateValue));
        }
        memoizedEntry000 = MruMemoizationTable.lookupMruMemoizedValue(((MruMemoizationTable)(memoTable000)), tablerelation, ((Context)(Stella.$CONTEXT$.get())), Stella.MEMOIZED_NULL_VALUE, null, -1);
        memoizedValue000 = memoizedEntry000.value;
      }
      if (memoizedValue000 != null) {
        if (memoizedValue000 == Stella.MEMOIZED_NULL_VALUE) {
          memoizedValue000 = null;
        }
      }
      else {
        memoizedValue000 = RDBMS.createRelationTableInfo(tablerelation);
        if (Stella.$MEMOIZATION_ENABLEDp$) {
          memoizedEntry000.value = ((memoizedValue000 == null) ? Stella.MEMOIZED_NULL_VALUE : memoizedValue000);
        }
      }
      { RelationTableInfo value000 = ((RelationTableInfo)(memoizedValue000));

        return (value000);
      }
    }
  }

  public static boolean collectionValuedConstraintP(Stella_Object argument) {
    return ((argument != null) &&
        (Logic.enumeratedListP(argument) ||
         Logic.enumeratedSetP(argument)));
  }

  public static Cons collectionValuedConstraintElements(Stella_Object argument) {
    return (Logic.assertedCollectionMembers(argument, true).consify());
  }

  public static void printSqlValue(OutputStream stream, Stella_Object value, RelationColumnInfo column) {
    { NamedDescription targetType = column.columnType;
      String baseString = RDBMS.coercePowerloomObjectToString(value, targetType);
      char quoteChar = edu.isi.sdbc.Sdbc.sqlQuoteCharacter(column.tableInfo.dbmsName, RDBMS.KWD_STRING_CONSTANT);

      if (targetType == Logic.getDescription(RDBMS.SGT_STELLA_STRING)) {
        stream.nativeStream.print(quoteChar + edu.isi.sdbc.Sdbc.sqlEscapeString(baseString, quoteChar) + quoteChar);
      }
      else if (NamedDescription.subrelationOfP(targetType, Logic.getDescription(RDBMS.SGT_STELLA_NUMBER)) ||
          NamedDescription.subrelationOfP(targetType, Logic.getDescription(RDBMS.SGT_STELLA_BOOLEAN))) {
        stream.nativeStream.print(baseString);
      }
      else {
        stream.nativeStream.print(quoteChar + edu.isi.sdbc.Sdbc.sqlEscapeString(baseString, quoteChar) + quoteChar);
      }
    }
  }

  public static void printColumnConstraint(OutputStream sql, RelationColumnInfo column, String value, boolean casesensitiveP) {
    { RelationTableInfo tableinfo = column.tableInfo;
      String tablealias = tableinfo.tableAlias;
      String columnname = column.columnName;

      if (tablealias != null) {
        columnname = tablealias + "." + columnname;
      }
      sql.nativeStream.print(columnname + "=");
      RDBMS.printSqlValue(sql, StringWrapper.wrapString(value), column);
      if (casesensitiveP) {
        if (tableinfo.dbmsName == RDBMS.KWD_MYSQL) {
          sql.nativeStream.print(" AND " + columnname + " LIKE BINARY ");
          RDBMS.printSqlValue(sql, StringWrapper.wrapString(value), column);
        }
        else {
        }
      }
    }
  }

  public static void printArgumentConstraint(OutputStream sql, Stella_Object argument, RelationColumnInfo column) {
    { NamedDescription columntype = column.columnType;
      Surrogate argname = Logic.objectSurrogate(argument);
      Module argmodule = ((argname != null) ? ((Module)(argname.homeContext)) : ((Module)(null)));
      RelationColumnInfo modulerefcolumn = column.moduleReferenceColumn;
      boolean casesensitiveP = ((argmodule != null) &&
          argmodule.caseSensitiveP) ||
          Stella_Object.isaP(argument, RDBMS.SGT_STELLA_STRING_WRAPPER);

      if (RDBMS.collectionValuedConstraintP(argument)) {
        sql.nativeStream.print("(");
        { Stella_Object subarg = null;
          Cons iter000 = RDBMS.collectionValuedConstraintElements(argument);
          int si = Stella.NULL_INTEGER;
          int iter001 = 1;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
            subarg = iter000.value;
            si = iter001;
            if (si > 1) {
              sql.nativeStream.print(" OR ");
            }
            RDBMS.printColumnConstraint(sql, column, RDBMS.coercePowerloomObjectToString(subarg, columntype), casesensitiveP);
          }
        }
        sql.nativeStream.print(")");
      }
      else {
        RDBMS.printColumnConstraint(sql, column, RDBMS.coercePowerloomObjectToString(argument, columntype), casesensitiveP);
      }
      if ((modulerefcolumn != null) &&
          (argmodule != null)) {
        sql.nativeStream.print(" AND ");
        RDBMS.printColumnConstraint(sql, modulerefcolumn, argmodule.moduleName, false);
      }
    }
  }

  public static void printSqlColumnList(OutputStream stream, RelationTableInfo tableInfo) {
    { boolean firstP = true;
      String alias = tableInfo.tableAlias;

      { RelationColumnInfo column = null;
        Cons iter000 = tableInfo.columnList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          column = ((RelationColumnInfo)(iter000.value));
          if (firstP) {
            firstP = false;
          }
          else {
            stream.nativeStream.print(", ");
          }
          if (alias != null) {
            stream.nativeStream.print(alias + "." + column.columnName);
          }
          else {
            stream.nativeStream.print(column.columnName);
          }
        }
      }
    }
  }

  public static void printSqlConstraintList(OutputStream stream, RelationTableInfo tableInfo, Vector arguments) {
    { boolean firstP = true;

      { RelationColumnInfo column = null;
        Cons iter000 = tableInfo.columnList;
        Stella_Object arg = null;
        Vector vector000 = arguments;
        int index000 = 0;
        int length000 = vector000.length();

        for (;(!(iter000 == Stella.NIL)) &&
                  (index000 < length000); iter000 = iter000.rest, index000 = index000 + 1) {
          column = ((RelationColumnInfo)(iter000.value));
          arg = (vector000.theArray)[index000];
          arg = Logic.safeArgumentBoundTo(arg);
          if ((arg != null) &&
              (!Logic.skolemP(arg))) {
            if (firstP) {
              {
                firstP = false;
                stream.nativeStream.print(" WHERE ");
              }
            }
            else {
              stream.nativeStream.print(" AND ");
            }
            RDBMS.printArgumentConstraint(stream, arg, column);
          }
        }
      }
    }
  }

  public static String createSqlFromProposition(Proposition proposition) {
    { NamedDescription relation = Logic.getDescription(((Surrogate)(proposition.operator)));
      RelationTableInfo tableinfo = RDBMS.getRelationTableInfo(relation);
      String tablealias = tableinfo.tableAlias;
      Vector arguments = proposition.arguments;
      OutputStringStream sql = OutputStringStream.newOutputStringStream();

      sql.nativeStream.print("SELECT DISTINCT ");
      RDBMS.printSqlColumnList(sql, tableinfo);
      sql.nativeStream.print(" FROM " + tableinfo.tableName);
      if (tablealias != null) {
        sql.nativeStream.print(" " + tablealias);
      }
      RDBMS.printSqlConstraintList(sql, tableinfo, arguments);
      return (sql.theStringReader());
    }
  }

  public static Iterator allocateDbtableSpecialistIterator(ControlFrame frame) {
    if (((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, RDBMS.SYM_STELLA_ITERATOR, null))) == null) {
      { Proposition proposition = frame.proposition;
        Surrogate relationref = ((Surrogate)(proposition.operator));
        NamedDescription relation = Logic.getDescription(relationref);

        RDBMS.checkForExternalDbUpdates(proposition, ((LogicObject)(Logic.accessBinaryValue(relation, RDBMS.SGT_RDBMS_DATABASE))));
        { MemoizationTable memoTable000 = null;
          Cons memoizedEntry000 = null;
          Stella_Object memoizedValue000 = null;

          if (Stella.$MEMOIZATION_ENABLEDp$) {
            memoTable000 = ((MemoizationTable)(RDBMS.SGT_RDBMS_F_ALLOCATE_DBTABLE_SPECIALIST_ITERATOR_MEMO_TABLE_000.surrogateValue));
            if (memoTable000 == null) {
              Surrogate.initializeMemoizationTable(RDBMS.SGT_RDBMS_F_ALLOCATE_DBTABLE_SPECIALIST_ITERATOR_MEMO_TABLE_000, "(:MAX-VALUES 1000 :TIMESTAMPS (:META-KB-UPDATE :EXTERNAL-DB-UPDATE))");
              memoTable000 = ((MemoizationTable)(RDBMS.SGT_RDBMS_F_ALLOCATE_DBTABLE_SPECIALIST_ITERATOR_MEMO_TABLE_000.surrogateValue));
            }
            memoizedEntry000 = MruMemoizationTable.lookupMruMemoizedValue(((MruMemoizationTable)(memoTable000)), RDBMS.getQueryPatternMemoizationKey(proposition), ((Context)(Stella.$CONTEXT$.get())), (((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue() ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.MEMOIZED_NULL_VALUE, 6);
            memoizedValue000 = memoizedEntry000.value;
          }
          if (memoizedValue000 != null) {
            if (memoizedValue000 == Stella.MEMOIZED_NULL_VALUE) {
              memoizedValue000 = null;
            }
          }
          else {
            memoizedValue000 = MemoizableIterator.newMemoizableIterator(RDBMS.allocateResultSetIterator(RDBMS.getConnectionFromPredicate(relationref), relation, RDBMS.createSqlFromProposition(proposition)));
            if (Stella.$MEMOIZATION_ENABLEDp$) {
              memoizedEntry000.value = ((memoizedValue000 == null) ? Stella.MEMOIZED_NULL_VALUE : memoizedValue000);
            }
          }
          KeyValueList.setDynamicSlotValue(frame.dynamicSlots, RDBMS.SYM_STELLA_ITERATOR, MemoizableIterator.cloneMemoizedIterator(((MemoizableIterator)(memoizedValue000))), null);
        }
      }
    }
    return (((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, RDBMS.SYM_STELLA_ITERATOR, null))));
  }

  public static Keyword retrieveNextDbQuerySolution(ControlFrame frame, Keyword lastmove) {
    { Vector arguments = frame.proposition.arguments;
      Iterator iterator = ((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, RDBMS.SYM_STELLA_ITERATOR, null)));

      lastmove = lastmove;
      if (!(iterator != null)) {
        return (RDBMS.KWD_FAILURE);
      }
      if (iterator.firstIterationP) {
        if (!(iterator.nextP())) {
          return (RDBMS.KWD_FAILURE);
        }
        iterator.firstIterationP = false;
      }
      loop000 : for (;;) {
        { boolean nonullsP = true;
          Cons result = Stella.NIL;
          Stella_Object binding = null;

          { Stella_Object col = null;
            Cons iter000 = ((Cons)(iterator.value));
            Stella_Object arg = null;
            Vector vector000 = arguments;
            int index000 = 0;
            int length000 = vector000.length();
            Cons collect000 = null;

            for (;(!(iter000 == Stella.NIL)) &&
                      (index000 < length000); iter000 = iter000.rest, index000 = index000 + 1) {
              col = iter000.value;
              arg = (vector000.theArray)[index000];
              binding = Logic.argumentBoundTo(arg);
              if (col == null) {
                nonullsP = false;
              }
              else if ((binding != null) &&
                  (!Logic.skolemP(binding))) {
                col = binding;
              }
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(col, Stella.NIL);
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
                  collect000.rest = Cons.cons(col, Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
          if (((((QueryIterator)(Logic.$QUERYITERATOR$.get())) != null) &&
              (((QueryIterator)(Logic.$QUERYITERATOR$.get())).partialMatchStrategy != null)) ||
              nonullsP) {
            if (Logic.bindVectorOfArgumentsToValuesP(arguments, result)) {
              break loop000;
            }
          }
          if (!(iterator.nextP())) {
            return (RDBMS.KWD_FAILURE);
          }
        }
      }
      if (((Boolean)(Logic.$RECORD_JUSTIFICATIONSp$.get())).booleanValue()) {
        { PrimitiveStrategy self000 = PrimitiveStrategy.newPrimitiveStrategy();

          self000.strategy = RDBMS.KWD_DB_LOOKUP;
          self000.antecedents = Stella.NIL;
          ControlFrame.recordGoalJustification(frame, self000);
        }
      }
      if (iterator.nextP()) {
        return (RDBMS.KWD_CONTINUING_SUCCESS);
      }
      else {
        {
          ControlFrame.setFrameTruthValue(frame, Logic.TRUE_TRUTH_VALUE);
          return (RDBMS.KWD_FINAL_SUCCESS);
        }
      }
    }
  }

  public static Keyword dbtableSpecialist(ControlFrame frame, Keyword lastmove) {
    if (((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, RDBMS.SYM_STELLA_ITERATOR, null))) == null) {
      KeyValueList.setDynamicSlotValue(frame.dynamicSlots, RDBMS.SYM_STELLA_ITERATOR, RDBMS.allocateDbtableSpecialistIterator(frame), null);
    }
    return (RDBMS.retrieveNextDbQuerySolution(frame, lastmove));
  }

  public static Cons getQueryPatternEvaluators(Surrogate relationref) {
    { Cons evaluatorforms = Stella.NIL;

      { MemoizationTable memoTable000 = null;
        Cons memoizedEntry000 = null;
        Stella_Object memoizedValue000 = null;

        if (Stella.$MEMOIZATION_ENABLEDp$) {
          memoTable000 = ((MemoizationTable)(RDBMS.SGT_RDBMS_F_GET_QUERY_PATTERN_EVALUATORS_MEMO_TABLE_000.surrogateValue));
          if (memoTable000 == null) {
            Surrogate.initializeMemoizationTable(RDBMS.SGT_RDBMS_F_GET_QUERY_PATTERN_EVALUATORS_MEMO_TABLE_000, "(:MAX-VALUES 100 :TIMESTAMPS (:META-KB-UPDATE))");
            memoTable000 = ((MemoizationTable)(RDBMS.SGT_RDBMS_F_GET_QUERY_PATTERN_EVALUATORS_MEMO_TABLE_000.surrogateValue));
          }
          memoizedEntry000 = MruMemoizationTable.lookupMruMemoizedValue(((MruMemoizationTable)(memoTable000)), relationref, ((Context)(Stella.$CONTEXT$.get())), Stella.MEMOIZED_NULL_VALUE, null, -1);
          memoizedValue000 = memoizedEntry000.value;
        }
        if (memoizedValue000 != null) {
          if (memoizedValue000 == Stella.MEMOIZED_NULL_VALUE) {
            memoizedValue000 = null;
          }
        }
        else {
          memoizedValue000 = Logic.applyCachedRetrieve(Cons.list$(Cons.cons(RDBMS.SYM_RDBMS_pREL, Cons.cons(RDBMS.SYM_RDBMS_pEV, Cons.cons(RDBMS.SYM_RDBMS_pDB, Cons.cons(RDBMS.SYM_RDBMS_pARGS, Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.list$(Cons.cons(RDBMS.SYM_STELLA_AND, Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_RDBMS_QUERY_PATTERN, Cons.cons(RDBMS.SYM_RDBMS_pREL, Cons.cons(RDBMS.SYM_RDBMS_pEV, Cons.cons(RDBMS.SYM_RDBMS_pDB, Cons.cons(RDBMS.SYM_RDBMS_pARGS, Cons.cons(Stella.NIL, Stella.NIL))))))), Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_STELLA_EXISTS, Cons.cons(Cons.cons(RDBMS.SYM_RDBMS_pDB_TYPE, Stella.NIL), Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_RDBMS_SUPPORTS_DB_TYPE, Cons.cons(RDBMS.SYM_RDBMS_pEV, Cons.cons(RDBMS.SYM_RDBMS_pDB_TYPE, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(RDBMS.SYM_RDBMS_INSTANCE_OF, Cons.cons(RDBMS.SYM_RDBMS_pDB, Cons.cons(RDBMS.SYM_RDBMS_pDB_TYPE, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.consList(Cons.cons(relationref, Cons.cons(null, Cons.cons(null, Cons.cons(null, Stella.NIL))))), Cons.consList(Cons.cons(RDBMS.KWD_DONT_OPTIMIZEp, Cons.cons(Stella.TRUE_WRAPPER, Cons.cons(RDBMS.KWD_HOW_MANY, Cons.cons(RDBMS.KWD_ALL, Cons.cons(RDBMS.KWD_INFERENCE_LEVEL, Cons.cons(RDBMS.KWD_ASSERTION, Stella.NIL))))))), RDBMS.SYM_RDBMS_F_GET_QUERY_PATTERN_EVALUATORS_QUERY_001, new Object[2]);
          if (Stella.$MEMOIZATION_ENABLEDp$) {
            memoizedEntry000.value = ((memoizedValue000 == null) ? Stella.MEMOIZED_NULL_VALUE : memoizedValue000);
          }
        }
        { Cons patterns = ((Cons)(memoizedValue000));

          { Cons triple = null;
            Cons iter000 = patterns;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              triple = ((Cons)(iter000.value));
              { java.lang.reflect.Method code = ComputedProcedure.functionCodeFromProcedure(((ComputedProcedure)(triple.value)));

                if (code != null) {
                  evaluatorforms = Cons.cons(Cons.consList(Cons.cons(FunctionCodeWrapper.wrapFunctionCode(code), Cons.cons(triple.rest.value, Cons.cons(triple.rest.rest.value, Stella.NIL)))), evaluatorforms);
                }
              }
            }
          }
          return (evaluatorforms.reverse());
        }
      }
    }
  }

  public static Iterator helpMemoizeSqlJoin(Proposition proposition, LogicObject database, Stella_Object arguments) {
    { NamedDescription relation = Logic.getDescription(((Surrogate)(proposition.operator)));
      RelationTableInfo tableinfo = RDBMS.getRelationTableInfo(relation);
      Cons tables = Stella.NIL;
      Cons joinargs = Stella.NIL;
      OutputStringStream sql = OutputStringStream.newOutputStringStream();

      { Object [] caller_MV_returnarray = new Object[1];

        tables = RelationTableInfo.normalizeSqlJoinArguments(tableinfo, arguments, caller_MV_returnarray);
        joinargs = ((Cons)(caller_MV_returnarray[0]));
      }
      sql.nativeStream.print("SELECT DISTINCT ");
      { RelationColumnInfo column = null;
        Cons iter000 = tableinfo.columnList;
        int i = Stella.NULL_INTEGER;
        int iter001 = 1;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
          column = ((RelationColumnInfo)(iter000.value));
          i = iter001;
          if (i > 1) {
            sql.nativeStream.print(", ");
          }
          sql.nativeStream.print(column.columnName);
        }
      }
      sql.nativeStream.print(" FROM ");
      { Stella_Object table = null;
        Cons iter002 = tables;
        int i = Stella.NULL_INTEGER;
        int iter003 = 1;

        for (;!(iter002 == Stella.NIL); iter002 = iter002.rest, iter003 = iter003 + 1) {
          table = iter002.value;
          i = iter003;
          if (i > 1) {
            sql.nativeStream.print(", ");
          }
          if (Stella_Object.consP(table)) {
            sql.nativeStream.print(StringWrapper.unwrapString(((StringWrapper)(((Cons)(table)).value))) + " " + StringWrapper.unwrapString(((StringWrapper)(((Cons)(table)).rest.value))));
          }
          else {
            sql.nativeStream.print(StringWrapper.unwrapString(((StringWrapper)(table))));
          }
        }
      }
      sql.nativeStream.print(" WHERE ");
      { Cons pair = null;
        Cons iter004 = joinargs;
        int i = Stella.NULL_INTEGER;
        int iter005 = 1;

        for (;!(iter004 == Stella.NIL); iter004 = iter004.rest, iter005 = iter005 + 1) {
          pair = ((Cons)(iter004.value));
          i = iter005;
          if (i > 1) {
            sql.nativeStream.print(" AND ");
          }
          sql.nativeStream.print(StringWrapper.unwrapString(((StringWrapper)(pair.value))) + "=" + StringWrapper.unwrapString(((StringWrapper)(pair.rest.value))));
        }
      }
      { Stella_Object arg = null;
        Vector vector000 = proposition.arguments;
        int index000 = 0;
        int length000 = vector000.length();
        RelationColumnInfo column = null;
        Cons iter006 = tableinfo.columnList;

        for (;(index000 < length000) &&
                  (!(iter006 == Stella.NIL)); index000 = index000 + 1, iter006 = iter006.rest) {
          arg = (vector000.theArray)[index000];
          column = ((RelationColumnInfo)(iter006.value));
          arg = Logic.safeArgumentBoundTo(arg);
          if (arg != null) {
            sql.nativeStream.print(" AND ");
            RDBMS.printArgumentConstraint(sql, arg, column);
          }
        }
      }
      return (RDBMS.allocateResultSetIterator(RDBMS.getConnectionFromDatabase(database), relation, sql.theStringReader()));
    }
  }

  public static Iterator sqlJoin(Proposition proposition, LogicObject database, Stella_Object arguments) {
    RDBMS.checkForExternalDbUpdates(proposition, database);
    { MemoizationTable memoTable000 = null;
      Cons memoizedEntry000 = null;
      Stella_Object memoizedValue000 = null;

      if (Stella.$MEMOIZATION_ENABLEDp$) {
        memoTable000 = ((MemoizationTable)(RDBMS.SGT_RDBMS_F_SQL_JOIN_MEMO_TABLE_000.surrogateValue));
        if (memoTable000 == null) {
          Surrogate.initializeMemoizationTable(RDBMS.SGT_RDBMS_F_SQL_JOIN_MEMO_TABLE_000, "(:MAX-VALUES 100 :TIMESTAMPS (:META-KB-UPDATE :EXTERNAL-DB-UPDATE))");
          memoTable000 = ((MemoizationTable)(RDBMS.SGT_RDBMS_F_SQL_JOIN_MEMO_TABLE_000.surrogateValue));
        }
        memoizedEntry000 = MruMemoizationTable.lookupMruMemoizedValue(((MruMemoizationTable)(memoTable000)), RDBMS.getQueryPatternMemoizationKey(proposition), ((Context)(Stella.$CONTEXT$.get())), (((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue() ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.MEMOIZED_NULL_VALUE, 6);
        memoizedValue000 = memoizedEntry000.value;
      }
      if (memoizedValue000 != null) {
        if (memoizedValue000 == Stella.MEMOIZED_NULL_VALUE) {
          memoizedValue000 = null;
        }
      }
      else {
        memoizedValue000 = MemoizableIterator.newMemoizableIterator(RDBMS.helpMemoizeSqlJoin(proposition, database, arguments));
        if (Stella.$MEMOIZATION_ENABLEDp$) {
          memoizedEntry000.value = ((memoizedValue000 == null) ? Stella.MEMOIZED_NULL_VALUE : memoizedValue000);
        }
      }
      { Iterator value000 = MemoizableIterator.cloneMemoizedIterator(((MemoizableIterator)(memoizedValue000)));

        return (((Iterator)(value000)));
      }
    }
  }

  public static void collectVariableBinding(String name, Stella_Object type, Stella_Object binding, KeyValueList bindings) {
    if (binding != null) {
      if (type != null) {
        type = Logic.getDescription(type);
      }
      if (RDBMS.collectionValuedConstraintP(binding)) {
        { Cons args = Stella.NIL;

          { Stella_Object elt = null;
            Cons iter000 = RDBMS.collectionValuedConstraintElements(binding);
            Cons collect000 = null;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              elt = iter000.value;
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(StringWrapper.wrapString(RDBMS.coercePowerloomObjectToString(elt, ((NamedDescription)(type)))), Stella.NIL);
                  if (args == Stella.NIL) {
                    args = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(args, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(StringWrapper.wrapString(RDBMS.coercePowerloomObjectToString(elt, ((NamedDescription)(type)))), Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
          binding = args;
        }
      }
      else {
        binding = StringWrapper.wrapString(RDBMS.coercePowerloomObjectToString(binding, ((NamedDescription)(type))));
      }
    }
    bindings.insertAt(StringWrapper.wrapString(name), binding);
  }

  public static String createSqlQueryFromProposition(Proposition proposition, LogicObject database, Stella_Object arguments) {
    database = database;
    { NamedDescription relation = Logic.getDescription(((Surrogate)(proposition.operator)));
      String template = ((StringWrapper)(arguments)).wrapperValue;
      KeyValueList bindings = KeyValueList.newKeyValueList();
      String sql = null;

      { Symbol var = null;
        Cons iter000 = relation.ioVariableNames.theConsList;
        Stella_Object arg = null;
        Vector vector000 = proposition.arguments;
        int index000 = 0;
        int length000 = vector000.length();
        int i = Stella.NULL_INTEGER;
        int iter001 = 1;

        for (;(!(iter000 == Stella.NIL)) &&
                  (index000 < length000); 
              iter000 = iter000.rest,
              index000 = index000 + 1,
              iter001 = iter001 + 1) {
          var = ((Symbol)(iter000.value));
          arg = (vector000.theArray)[index000];
          i = iter001;
          RDBMS.collectVariableBinding(var.symbolName, edu.isi.powerloom.PLI.getNthDomain(relation, i), Logic.safeArgumentBoundTo(arg), bindings);
        }
      }
      sql = edu.isi.sdbc.Sdbc.instantiateSqlCmdTemplate(template, bindings);
      sql = RDBMS.sqlQueryInstantiateConstraints(sql, bindings);
      return (sql);
    }
  }

  public static Iterator helpMemoizeSqlQuery(Proposition proposition, LogicObject database, Stella_Object arguments) {
    return (RDBMS.allocateResultSetIterator(RDBMS.getConnectionFromDatabase(database), Logic.getDescription(((Surrogate)(proposition.operator))), RDBMS.createSqlQueryFromProposition(proposition, database, arguments)));
  }

  public static String sqlQueryInstantiateConstraints(String sql, KeyValueList bindings) {
    { int start = 0;
      int end = sql.length();
      String variable = null;
      Stella_Object value = null;
      int varstart = 0;
      int varend = 0;
      int colstart = 0;
      Keyword constraint = RDBMS.KWD_VALUE;
      String quotes = "'`\"";
      char quote = Stella.NULL_CHARACTER;
      Cons result = Stella.NIL;
      String truecondition = "1=1";
      String falsecondition = "0=1";

      loop000 : for (;;) {
        varstart = Native.string_position(sql, '?', varend);
        if (varstart == Stella.NULL_INTEGER) {
          if (result == Stella.NIL) {
            return (sql);
          }
          else {
            result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(sql, start, Stella.NULL_INTEGER)), result);
            break loop000;
          }
        }
        variable = null;
        { StringWrapper var = null;
          Stella_Object val = null;
          KvCons iter000 = bindings.theKvList;

          loop001 : for (;iter000 != null; iter000 = iter000.rest) {
            var = ((StringWrapper)(iter000.key));
            val = iter000.value;
            if (Stella.startsWithP(sql, var.wrapperValue, varstart)) {
              variable = var.wrapperValue;
              value = val;
              varend = varstart + variable.length();
              if ((varend == end) ||
                  ((Stella.$CHARACTER_TYPE_TABLE$[(int) (sql.charAt(varend))] == RDBMS.KWD_WHITE_SPACE) ||
                   Native.string_memberP(quotes, sql.charAt(varend)))) {
                break loop001;
              }
            }
          }
        }
        if (variable == null) {
          varend = varstart + 1;
          continue loop000;
        }
        quote = Stella.NULL_CHARACTER;
        if (sql.charAt((Stella.integer_max(varstart - 1, 0))) == '=') {
          colstart = varstart - 2;
          constraint = RDBMS.KWD_VALUE;
        }
        else if ((sql.charAt((Stella.integer_max(varstart - 2, 0))) == '=') &&
            Native.string_memberP(quotes, sql.charAt((varstart - 1)))) {
          colstart = varstart - 3;
          constraint = RDBMS.KWD_VALUE;
          quote = sql.charAt((varstart - 1));
        }
        else if (Stella.startsWithP(sql, " IN ", Stella.integer_max(varstart - 4, 0)) ||
            Stella.startsWithP(sql, " in ", Stella.integer_max(varstart - 4, 0))) {
          colstart = varstart - 5;
          constraint = RDBMS.KWD_SET;
        }
        else if ((Stella.startsWithP(sql, " IN ", Stella.integer_max(varstart - 5, 0)) ||
            Stella.startsWithP(sql, " in ", Stella.integer_max(varstart - 5, 0))) &&
            Native.string_memberP(quotes, sql.charAt((varstart - 1)))) {
          colstart = varstart - 6;
          constraint = RDBMS.KWD_SET;
          quote = sql.charAt((varstart - 1));
        }
        else {
          constraint = RDBMS.KWD_NONE;
          continue loop000;
        }
        if ((constraint == RDBMS.KWD_VALUE) &&
            (Stella_Object.consP(value) &&
             (!(value == Stella.NIL)))) {
          constraint = RDBMS.KWD_SET;
          result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(sql, start, colstart + 1)), result);
          result = Cons.cons(StringWrapper.wrapString(" IN "), result);
          start = ((quote != Stella.NULL_CHARACTER) ? (varstart - 1) : varstart);
        }
        if ((value == null) ||
            (value == Stella.NIL)) {
          loop002 : for (;;) {
            if (colstart <= 0) {
              colstart = 0;
              break loop002;
            }
            else if (Stella.$CHARACTER_TYPE_TABLE$[(int) (sql.charAt(colstart))] == RDBMS.KWD_WHITE_SPACE) {
              colstart = colstart + 1;
              break loop002;
            }
            else {
              colstart = colstart - 1;
            }
          }
          if (quote != Stella.NULL_CHARACTER) {
            varend = varend + 1;
          }
          result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(sql, start, colstart)), result);
          result = Cons.cons(((value == Stella.NIL) ? StringWrapper.wrapString(falsecondition) : StringWrapper.wrapString(truecondition)), result);
        }
        else if (constraint == RDBMS.KWD_SET) {
          if (quote != Stella.NULL_CHARACTER) {
            varstart = varstart - 1;
            varend = varend + 1;
          }
          { OutputStringStream set = OutputStringStream.newOutputStringStream();

            set.nativeStream.print("(");
            { Stella_Object elt = null;
              Cons iter001 = value.consify();
              int i = Stella.NULL_INTEGER;
              int iter002 = 1;

              for (;!(iter001 == Stella.NIL); iter001 = iter001.rest, iter002 = iter002 + 1) {
                elt = iter001.value;
                i = iter002;
                set.nativeStream.print((((i > 1) ? "," : "")));
                if (quote != Stella.NULL_CHARACTER) {
                  set.nativeStream.print(quote + edu.isi.sdbc.Sdbc.sqlEscapeString(((StringWrapper)(elt)).wrapperValue, quote) + quote);
                }
                else {
                  set.nativeStream.print(StringWrapper.unwrapString(((StringWrapper)(elt))));
                }
              }
            }
            set.nativeStream.print(")");
            result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(sql, start, varstart)), result);
            result = Cons.cons(StringWrapper.wrapString(set.theStringReader()), result);
          }
        }
        else {
          result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(sql, start, varstart)), result);
          result = Cons.cons(((quote != Stella.NULL_CHARACTER) ? StringWrapper.wrapString(edu.isi.sdbc.Sdbc.sqlEscapeString(((StringWrapper)(value)).wrapperValue, quote)) : value), result);
        }
        start = varend;
      }
      { OutputStringStream res = OutputStringStream.newOutputStringStream();

        { StringWrapper piece = null;
          Cons iter003 = result.reverse();

          for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
            piece = ((StringWrapper)(iter003.value));
            res.nativeStream.print(StringWrapper.unwrapString(piece));
          }
        }
        return (res.theStringReader());
      }
    }
  }

  public static Iterator sqlQuery(Proposition proposition, LogicObject database, Stella_Object arguments) {
    RDBMS.checkForExternalDbUpdates(proposition, database);
    { MemoizationTable memoTable000 = null;
      Cons memoizedEntry000 = null;
      Stella_Object memoizedValue000 = null;

      if (Stella.$MEMOIZATION_ENABLEDp$) {
        memoTable000 = ((MemoizationTable)(RDBMS.SGT_RDBMS_F_SQL_QUERY_MEMO_TABLE_000.surrogateValue));
        if (memoTable000 == null) {
          Surrogate.initializeMemoizationTable(RDBMS.SGT_RDBMS_F_SQL_QUERY_MEMO_TABLE_000, "(:MAX-VALUES 100 :TIMESTAMPS (:META-KB-UPDATE :EXTERNAL-DB-UPDATE))");
          memoTable000 = ((MemoizationTable)(RDBMS.SGT_RDBMS_F_SQL_QUERY_MEMO_TABLE_000.surrogateValue));
        }
        memoizedEntry000 = MruMemoizationTable.lookupMruMemoizedValue(((MruMemoizationTable)(memoTable000)), RDBMS.getQueryPatternMemoizationKey(proposition), ((Context)(Stella.$CONTEXT$.get())), (((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue() ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.MEMOIZED_NULL_VALUE, 6);
        memoizedValue000 = memoizedEntry000.value;
      }
      if (memoizedValue000 != null) {
        if (memoizedValue000 == Stella.MEMOIZED_NULL_VALUE) {
          memoizedValue000 = null;
        }
      }
      else {
        memoizedValue000 = MemoizableIterator.newMemoizableIterator(RDBMS.helpMemoizeSqlQuery(proposition, database, arguments));
        if (Stella.$MEMOIZATION_ENABLEDp$) {
          memoizedEntry000.value = ((memoizedValue000 == null) ? Stella.MEMOIZED_NULL_VALUE : memoizedValue000);
        }
      }
      { Iterator value000 = MemoizableIterator.cloneMemoizedIterator(((MemoizableIterator)(memoizedValue000)));

        return (((Iterator)(value000)));
      }
    }
  }

  public static Iterator allocateQuerySpecialistIterator(ControlFrame frame) {
    if (((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, RDBMS.SYM_STELLA_ITERATOR, null))) == null) {
      { Iterator iterator = null;
        Iterator iterator2 = null;
        Proposition proposition = frame.proposition;
        Surrogate relationref = ((Surrogate)(proposition.operator));

        { Cons triple = null;
          Cons iter000 = RDBMS.getQueryPatternEvaluators(relationref);

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            triple = ((Cons)(iter000.value));
            if (iterator == null) {
              iterator = ((Iterator)(edu.isi.stella.javalib.Native.funcall(((FunctionCodeWrapper)(triple.value)).wrapperValue, null, new java.lang.Object [] {proposition, triple.rest.value, triple.rest.rest.value})));
            }
            else {
              iterator2 = ((Iterator)(edu.isi.stella.javalib.Native.funcall(((FunctionCodeWrapper)(triple.value)).wrapperValue, null, new java.lang.Object [] {proposition, triple.rest.value, triple.rest.rest.value})));
              if (iterator2 != null) {
                iterator = iterator.concatenate(iterator2, Stella.NIL);
              }
            }
          }
        }
        KeyValueList.setDynamicSlotValue(frame.dynamicSlots, RDBMS.SYM_STELLA_ITERATOR, iterator, null);
      }
    }
    return (((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, RDBMS.SYM_STELLA_ITERATOR, null))));
  }

  public static Keyword querySpecialist(ControlFrame frame, Keyword lastmove) {
    if (((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, RDBMS.SYM_STELLA_ITERATOR, null))) == null) {
      KeyValueList.setDynamicSlotValue(frame.dynamicSlots, RDBMS.SYM_STELLA_ITERATOR, RDBMS.allocateQuerySpecialistIterator(frame), null);
    }
    return (RDBMS.retrieveNextDbQuerySolution(frame, lastmove));
  }

  public static KeyValueList collectQueryDatabaseSpecialistBindings(ControlFrame frame, int firstargindex) {
    { Vector arguments = frame.proposition.arguments;
      KeyValueList bindings = KeyValueList.newKeyValueList();

      { Stella_Object arg = null;
        Vector vector000 = arguments;
        int index000 = 0;
        int length000 = vector000.length();
        int i = Stella.NULL_INTEGER;
        int iter000 = 0;

        for (;index000 < length000; index000 = index000 + 1, iter000 = iter000 + 1) {
          arg = (vector000.theArray)[index000];
          i = iter000;
          if ((i >= firstargindex) &&
              Logic.variableP(arg)) {
            RDBMS.collectVariableBinding(((PatternVariable)(arg)).skolemName.symbolName, Logic.logicalType(arg), Logic.argumentBoundTo(arg), bindings);
          }
        }
      }
      return (bindings);
    }
  }

  public static Keyword bindNextDatabaseTupleToArguments(ControlFrame frame, int firstargindex) {
    { Vector arguments = frame.proposition.arguments;
      int nofoutputs = arguments.length() - firstargindex;
      Iterator iterator = ((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, RDBMS.SYM_STELLA_ITERATOR, null)));
      PatternRecord patternrecord = ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord;
      int ubstackoffset = patternrecord.topUnbindingStackOffset;
      boolean checkedunboundoutputsP = false;

      while (iterator.nextP()) {
        { boolean alwaysP000 = true;

          { StringWrapper output = null;
            Cons iter000 = ((Cons)(iterator.value));
            int i = Stella.NULL_INTEGER;
            int iter001 = firstargindex;
            int upperBound000 = arguments.length() - 1;

            loop001 : for (;(!(iter000 == Stella.NIL)) &&
                      (iter001 <= upperBound000); iter000 = iter000.rest, iter001 = iter001 + 1) {
              output = ((StringWrapper)(iter000.value));
              i = iter001;
              if (!RDBMS.collectionValuedConstraintP(Logic.argumentBoundTo((arguments.theArray)[i]))) {
                if (!Logic.bindArgumentToValueP((arguments.theArray)[i], RDBMS.coerceStringToPowerloomObject(StringWrapper.unwrapString(output), Logic.getDescription(Logic.logicalType((arguments.theArray)[i])), ((Module)(Stella.$MODULE$.get())), false), true)) {
                  alwaysP000 = false;
                  break loop001;
                }
              }
            }
          }
          if (alwaysP000) {
            if ((!checkedunboundoutputsP) &&
                (((Cons)(iterator.value)).length() < nofoutputs)) {
              { int i = Stella.NULL_INTEGER;
                int iter002 = ((Cons)(iterator.value)).length() + firstargindex;
                int upperBound001 = arguments.length() - 1;

                for (;iter002 <= upperBound001; iter002 = iter002 + 1) {
                  i = iter002;
                  if (Logic.argumentBoundTo((arguments.theArray)[i]) == null) {
                    return (RDBMS.KWD_TERMINAL_FAILURE);
                  }
                }
              }
            }
            checkedunboundoutputsP = true;
            return (RDBMS.KWD_CONTINUING_SUCCESS);
          }
        }
        PatternRecord.unbindVariablesBeginningAt(patternrecord, ubstackoffset + 1);
      }
      return (RDBMS.KWD_TERMINAL_FAILURE);
    }
  }

  public static Keyword querySqlDatabaseSpecialist(ControlFrame frame, Keyword lastmove) {
    lastmove = lastmove;
    { Vector arguments = frame.proposition.arguments;
      Stella_Object database = Logic.argumentBoundTo((arguments.theArray)[0]);
      Stella_Object query = Logic.argumentBoundTo((arguments.theArray)[1]);

      if ((database == null) ||
          ((!Stella_Object.stringP(query)) ||
           (!Logic.testIsaP(database, RDBMS.SGT_RDBMS_SQL_DATABASE)))) {
        return (RDBMS.KWD_TERMINAL_FAILURE);
      }
      if (((Iterator)(KeyValueList.dynamicSlotValue(frame.dynamicSlots, RDBMS.SYM_STELLA_ITERATOR, null))) == null) {
        { KeyValueList bindings = RDBMS.collectQueryDatabaseSpecialistBindings(frame, 2);

          query = StringWrapper.wrapString(edu.isi.sdbc.Sdbc.instantiateSqlCmdTemplate(((StringWrapper)(query)).wrapperValue, bindings));
          query = StringWrapper.wrapString(RDBMS.sqlQueryInstantiateConstraints(((StringWrapper)(query)).wrapperValue, bindings));
          KeyValueList.setDynamicSlotValue(frame.dynamicSlots, RDBMS.SYM_STELLA_ITERATOR, edu.isi.sdbc.Connection.getResultSet(RDBMS.getConnectionFromDatabase(((LogicObject)(database))), ((StringWrapper)(query)).wrapperValue, Stella.NIL), null);
        }
      }
      return (RDBMS.bindNextDatabaseTupleToArguments(frame, 2));
    }
  }

  public static Keyword queryDatabaseSpecialist(ControlFrame frame, Keyword lastmove) {
    { Proposition proposition = frame.proposition;
      Vector arguments = proposition.arguments;
      Stella_Object database = Logic.argumentBoundTo((arguments.theArray)[0]);
      Stella_Object query = Logic.argumentBoundTo((arguments.theArray)[1]);

      if ((database == null) ||
          (!Stella_Object.stringP(query))) {
        return (RDBMS.KWD_TERMINAL_FAILURE);
      }
      if (Logic.testIsaP(database, RDBMS.SGT_RDBMS_SQL_DATABASE)) {
        return (RDBMS.querySqlDatabaseSpecialist(frame, lastmove));
      }
      else {
        return (RDBMS.KWD_FAILURE);
      }
    }
  }

  public static void dbUpdateDemon(Proposition dbproposition) {
    { Stella_Object db = (dbproposition.arguments.theArray)[0];

      RDBMS.disconnectFromDatabase(((LogicObject)(db)));
      Keyword.bumpMemoizationTimestamp(RDBMS.KWD_EXTERNAL_DB_UPDATE);
    }
  }

  public static void checkForExternalDbUpdates(Proposition proposition, LogicObject database) {
    {
      proposition = proposition;
      database = database;
    }
  }

  public static Stella_Object getQueryPatternMemoizationKey(Proposition proposition) {
    { Surrogate relationref = ((Surrogate)(proposition.operator));
      Vector iovars = Logic.getDescription(relationref).ioVariables;
      List unboundvars = List.list(Stella.NIL);
      OutputStringStream key = OutputStringStream.newOutputStringStream();

      Logic.printLogicalForm(relationref, key);
      { Stella_Object arg = null;
        Vector vector000 = proposition.arguments;
        int index000 = 0;
        int length000 = vector000.length();

        for (;index000 < length000; index000 = index000 + 1) {
          arg = (vector000.theArray)[index000];
          key.nativeStream.print(" ");
          if (Logic.variableP(arg) &&
              (Logic.safeArgumentBoundTo(arg) == null)) {
            if (!(unboundvars.memberP(arg))) {
              unboundvars.insertLast(arg);
            }
            Logic.printLogicalForm(((PatternVariable)((iovars.theArray)[(unboundvars.position(arg, 0))])), key);
          }
          else {
            Logic.printLogicalForm(Logic.safeArgumentBoundTo(arg), key);
          }
        }
      }
      return (StringWrapper.wrapString(key.theStringReader()));
    }
  }

  public static Cons coerceValues(Cons values, RelationTableInfo table) {
    { Cons result = Stella.NIL;
      Module module = null;
      boolean localP = false;

      { StringWrapper value = null;
        Cons iter000 = values;
        RelationColumnInfo column = null;
        Cons iter001 = table.columnList;
        Cons collect000 = null;

        for (;(!(iter000 == Stella.NIL)) &&
                  (!(iter001 == Stella.NIL)); iter000 = iter000.rest, iter001 = iter001.rest) {
          value = ((StringWrapper)(iter000.value));
          column = ((RelationColumnInfo)(iter001.value));
          module = column.module;
          localP = column.moduleLocalP;
          if (module == null) {
            module = RelationColumnInfo.getModuleUsingReference(column, values);
          }
          if (collect000 == null) {
            {
              collect000 = Cons.cons(RDBMS.coerceStringToPowerloomObject(StringWrapper.unwrapString(value), column.columnType, module, localP), Stella.NIL);
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
              collect000.rest = Cons.cons(RDBMS.coerceStringToPowerloomObject(StringWrapper.unwrapString(value), column.columnType, module, localP), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (result);
    }
  }

  public static Stella_Object coerceStringToPowerloomObject(String value, NamedDescription type, Module module, boolean localP) {
    if (value == null) {
      return (null);
    }
    { Surrogate typesurrogate = Logic.objectSurrogate(type);
      String typename = typesurrogate.symbolName;
      Stella_Object result = null;

      if (typesurrogate == RDBMS.SGT_STELLA_STRING) {
        result = StringWrapper.wrapString(value);
      }
      else if (Stella.stringEqlP(typename, "KEYWORD")) {
        result = Stella.internKeyword(value);
      }
      else if (Stella.stringEqlP(typename, "SEXP")) {
        result = Stella.readSExpressionFromString(value);
      }
      else if (Stella_Object.isaP(typesurrogate.surrogateValue, RDBMS.SGT_LOGIC_NAMED_DESCRIPTION)) {
        result = RDBMS.findOrCreateInstance(value, type, module, localP);
        { Object old$Module$000 = Stella.$MODULE$.get();
          Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Stella.$MODULE$, module);
            Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
            Logic.assertIsaProposition(result, typesurrogate);

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
            Stella.$MODULE$.set(old$Module$000);
          }
        }
      }
      else if (Surrogate.subtypeOfP(typesurrogate, RDBMS.SGT_STELLA_BOOLEAN)) {
        result = (Stella.stringEqlP(value, "1") ? RDBMS.SGT_STELLA_TRUE.surrogateValue : RDBMS.SGT_STELLA_FALSE.surrogateValue);
      }
      else if (Surrogate.subtypeOfP(typesurrogate, RDBMS.SGT_STELLA_INTEGER)) {
        result = IntegerWrapper.wrapInteger(RDBMS.numberStringToInteger(value));
      }
      else if (Surrogate.subtypeOfP(typesurrogate, RDBMS.SGT_STELLA_NUMBER)) {
        result = FloatWrapper.wrapFloat(Native.stringToFloat(value));
      }
      else if (Surrogate.subtypeOfP(typesurrogate, RDBMS.SGT_STELLA_THING)) {
        result = RDBMS.findOrCreateInstance(value, type, module, localP);
      }
      else {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: RDBMS: Don't yet know how to coerce string \"`" + value + "'\" to type `" + typename + "'");
      }
      return (result);
    }
  }

  public static int numberStringToInteger(String x) {
    try {
      return (((int)(Native.stringToInteger(x))));
    } catch (java.lang.Exception e000) {
      return (((int)(Native.stringToFloat(x))));
    }
  }

  public static String coercePowerloomObjectToString(Stella_Object renamed_Object, NamedDescription type) {
    type = type;
    { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

      try {
        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
        { Surrogate testValue000 = Stella_Object.safePrimaryType(renamed_Object);

          if (Surrogate.subtypeOfStringP(testValue000)) {
            { StringWrapper object000 = ((StringWrapper)(renamed_Object));

              return (object000.wrapperValue);
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, RDBMS.SGT_LOGIC_LOGIC_OBJECT)) {
            { LogicObject object000 = ((LogicObject)(renamed_Object));

              return (object000.surrogateValueInverse.symbolName);
            }
          }
          else {
            return (Native.stringify(renamed_Object));
          }
        }

      } finally {
        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
      }
    }
  }

  /** Find an existing instance with <code>name</code> in <code>module</code> or create one with <code>type</code>
   * if it does not yet exist.  If <code>localP</code> do not look into any inherited modules.
   * @param name
   * @param type
   * @param module
   * @param localP
   * @return Stella_Object
   */
  public static Stella_Object findOrCreateInstance(String name, NamedDescription type, Module module, boolean localP) {
    { Surrogate instanceref = Surrogate.lookupSurrogateInModule(name, module, localP);
      Stella_Object value = ((instanceref != null) ? instanceref.surrogateValue : ((Stella_Object)(null)));
      Surrogate typeref = null;

      if (value != null) {
        if (Stella_Object.stellaClassP(value)) {
          return (Logic.classDgetDescription(((Stella_Class)(value))));
        }
        else {
          return (value);
        }
      }
      else if (instanceref == null) {
        if (!(name.charAt(0) == '(')) {
          instanceref = Surrogate.internSurrogateInModule(name, module, localP);
        }
      }
      typeref = Logic.objectSurrogate(type);
      if (typeref == RDBMS.SGT_STELLA_THING) {
        typeref = null;
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, module);
          Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
          if (instanceref != null) {
            return (Logic.createLogicInstance(instanceref, typeref));
          }
          else {
            { Stella_Object skolem = Logic.evaluateTerm(Stella.readSExpressionFromString(name));

              Logic.assertIsaProposition(skolem, typeref);
              return (skolem);
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  public static String createSqlAssertionFromProposition(Proposition proposition, Keyword mode) {
    { Surrogate relationRef = Proposition.getPropositionBaseOperator(proposition);
      NamedDescription relation = Logic.getDescription(relationRef);
      boolean isfunctionP = Logic.functionP(relationRef);
      RelationTableInfo tableInfo = RDBMS.getRelationTableInfo(relation);
      String tableAlias = tableInfo.tableAlias;
      Skolem skolemTerm = null;
      Stella_Object functionValue = null;
      Vector arguments = null;
      OutputStringStream sql = OutputStringStream.newOutputStringStream();
      boolean firstP = true;

      tableInfo.tableAlias = null;
      if (isfunctionP) {
        {
          { Object [] caller_MV_returnarray = new Object[1];

            skolemTerm = Proposition.getSkolemAndValueTerms(proposition, caller_MV_returnarray);
            functionValue = ((Stella_Object)(caller_MV_returnarray[0]));
          }
          { Vector args = skolemTerm.definingProposition.arguments;
            int argsLength = args.length();

            arguments = Vector.newVector(((mode == RDBMS.KWD_CLIP) ? (argsLength - 1) : argsLength));
            { int i = Stella.NULL_INTEGER;
              int iter000 = 0;
              int upperBound000 = argsLength - 2;

              for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
                i = iter000;
                (arguments.theArray)[i] = ((args.theArray)[i]);
              }
            }
            if (!(mode == RDBMS.KWD_CLIP)) {
              (arguments.theArray)[(argsLength - 1)] = functionValue;
            }
          }
        }
      }
      else {
        arguments = proposition.arguments;
      }
      if (mode == RDBMS.KWD_ASSERT) {
        sql.nativeStream.print("INSERT INTO " + tableInfo.tableName);
        sql.nativeStream.print(" (");
        RDBMS.printSqlColumnList(sql, tableInfo);
        sql.nativeStream.print(") VALUES (");
        { RelationColumnInfo column = null;
          Cons iter001 = tableInfo.columnList;
          Stella_Object arg = null;
          Vector vector000 = arguments;
          int index000 = 0;
          int length000 = vector000.length();

          for (;(!(iter001 == Stella.NIL)) &&
                    (index000 < length000); iter001 = iter001.rest, index000 = index000 + 1) {
            column = ((RelationColumnInfo)(iter001.value));
            arg = (vector000.theArray)[index000];
            if ((arg == null) ||
                Logic.skolemP(arg)) {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("Can't assert non-ground items to table from `" + proposition + "'");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
            else if (firstP) {
              firstP = false;
            }
            else {
              sql.nativeStream.print(", ");
            }
            RDBMS.printSqlValue(sql, arg, column);
          }
        }
        sql.nativeStream.print(")");
      }
      else if ((mode == RDBMS.KWD_RETRACT) ||
          (mode == RDBMS.KWD_CLIP)) {
        sql.nativeStream.print("DELETE FROM " + tableInfo.tableName + " ");
        RDBMS.printSqlConstraintList(sql, tableInfo, arguments);
      }
      else {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("`" + mode + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
      tableInfo.tableAlias = tableAlias;
      Keyword.bumpMemoizationTimestamp(RDBMS.KWD_EXTERNAL_DB_UPDATE);
      return (sql.theStringReader());
    }
  }

  public static void dbRelationGoesTrue(Proposition proposition) {
    { Surrogate baseRelation = Proposition.getPropositionBaseOperator(proposition);
      edu.isi.sdbc.Connection connection = RDBMS.getConnectionFromPredicate(baseRelation);

      if (((Boolean)(Logic.$CLIPPINGENABLEDp$.get())).booleanValue() &&
          Logic.functionP(Logic.getDescription(baseRelation))) {
        edu.isi.sdbc.Connection.executeSql(connection, StringWrapper.wrapString(RDBMS.createSqlAssertionFromProposition(proposition, RDBMS.KWD_CLIP)), Stella.NIL);
      }
      else {
        edu.isi.sdbc.Connection.executeSql(connection, StringWrapper.wrapString(RDBMS.createSqlAssertionFromProposition(proposition, RDBMS.KWD_RETRACT)), Stella.NIL);
      }
      edu.isi.sdbc.Connection.executeSql(connection, StringWrapper.wrapString(RDBMS.createSqlAssertionFromProposition(proposition, RDBMS.KWD_ASSERT)), Stella.NIL);
    }
  }

  public static void dbRelationGoesUnknown(Proposition proposition) {
    { edu.isi.sdbc.Connection connection = RDBMS.getConnectionFromPredicate(Proposition.getPropositionBaseOperator(proposition));

      edu.isi.sdbc.Connection.executeSql(connection, StringWrapper.wrapString(RDBMS.createSqlAssertionFromProposition(proposition, RDBMS.KWD_RETRACT)), Stella.NIL);
    }
  }

  public static void dbRelationGoesFalse(Proposition proposition) {
    Stella.STANDARD_WARNING.nativeStream.println("Warning: RDBMS: DB relations can't be made false.  Making `" + proposition + "' unknown instead.");
    RDBMS.dbRelationGoesUnknown(proposition);
  }

  public static void dbRelationUpdateDemon(Proposition proposition, Keyword updateMode) {
    if ((updateMode == RDBMS.KWD_ASSERT_TRUE) ||
        (updateMode == RDBMS.KWD_PRESUME_TRUE)) {
      RDBMS.dbRelationGoesTrue(proposition);
      Proposition.destroyRedundantProposition(proposition);
    }
    else if (updateMode == RDBMS.KWD_RETRACT_TRUE) {
      RDBMS.dbRelationGoesUnknown(proposition);
      Proposition.destroyRedundantProposition(proposition);
    }
    else if (updateMode == RDBMS.KWD_RETRACT_FALSE) {
      Stella.STANDARD_WARNING.nativeStream.println("Warning: RDBMS: DB relations can't be false.");
      RDBMS.dbRelationGoesUnknown(proposition);
      Proposition.destroyRedundantProposition(proposition);
    }
    else if ((updateMode == RDBMS.KWD_ASSERT_FALSE) ||
        (updateMode == RDBMS.KWD_PRESUME_FALSE)) {
      RDBMS.dbRelationGoesFalse(proposition);
      Proposition.destroyRedundantProposition(proposition);
    }
    else if (updateMode == RDBMS.KWD_CONCEIVE) {
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + updateMode + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  /** Runs a Fetch query specifying the parameters given.
   * Returns an object representing the returned XML-encoded answer from
   * the server.
   * @param host
   * @param port
   * @param queryId
   * @param taskId
   * @param subtaskId
   * @param database
   * @param parameters
   * @return Stella_Object
   */
  public static Stella_Object runFetchQuery(String host, int port, String queryId, String taskId, String subtaskId, String database, String parameters) {
    { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

      try {
        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, false);
        { OutputStringStream url = OutputStringStream.newOutputStringStream();
          InputStream reply = null;

          url.nativeStream.print("/agent/runner?plan=");
          Stella.writeHtmlEscapingUrlSpecialCharacters(url.nativeStream, queryId);
          url.nativeStream.print("&TaskID=");
          Stella.writeHtmlEscapingUrlSpecialCharacters(url.nativeStream, taskId);
          url.nativeStream.print("-");
          Stella.writeHtmlEscapingUrlSpecialCharacters(url.nativeStream, subtaskId);
          url.nativeStream.print("&Database=");
          Stella.writeHtmlEscapingUrlSpecialCharacters(url.nativeStream, database);
          url.nativeStream.print("&");
          url.nativeStream.print(parameters);
          reply = ((InputStream)(edu.isi.stella.javalib.Native.funcall(Stella.autoload("HTTP/HTTP-GET-DATA", "webtools", RDBMS.SGT_RDBMS_RUN_FETCH_QUERY, true), null, new java.lang.Object [] {host, new Integer(port), url.theStringReader(), ((Stella_Object)(null))})));
          { Stella_Object exp = null;
            XmlExpressionIterator iter000 = InputStream.xmlExpressions(reply, null);

            while (iter000.nextP()) {
              exp = iter000.value;
              if (Stella_Object.isaP(exp, RDBMS.SGT_STELLA_CONS) &&
                  Stella_Object.isaP(((Cons)(exp)).value, RDBMS.SGT_STELLA_XML_ELEMENT)) {
                { XmlElement item000 = ((XmlElement)(((Cons)(exp)).value));

                  if (Stella.stringEqlP(item000.name, "PlanExecution") &&
                      Stella.stringEqlP(item000.namespaceUri, null)) {
                    return (exp);
                  }
                  else if (Stella.stringEqlP(item000.name, "Error") &&
                      Stella.stringEqlP(item000.namespaceUri, null)) {
                    { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                      stream000.nativeStream.print("`" + ((StringWrapper)(((Cons)(exp)).rest.rest.value)).wrapperValue + "'");
                      throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                    }
                  }
                  else {
                  }
                }
              }
            }
          }
          throw ((StellaException)(StellaException.newStellaException("Fetch Query Error: No answer element found.").fillInStackTrace()));
        }

      } finally {
        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
      }
    }
  }

  public static String normalizeFetchQueryArguments(Proposition proposition, Stella_Object arguments, Object [] MV_returnarray) {
    if (!(Stella_Object.stringP(arguments))) {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            stream000.nativeStream.println("PARSING ERROR: Fetch-EDB-query: illegal pattern arguments: `" + arguments + "'.");
            Logic.helpSignalPropositionError(stream000, RDBMS.KWD_ERROR);

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        throw ((ParsingError)(ParsingError.newParsingError(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    { Stella_Object args = Stella.readSExpressionFromString(((StringWrapper)(arguments)).wrapperValue);
      Cons cursor = null;
      String queryid = null;
      Cons outputargs = Stella.NIL;
      Cons parameters = Stella.NIL;
      Stella_Object parametervalue = null;

      if (Stella_Object.safePrimaryType(args) == RDBMS.SGT_STELLA_CONS) {
        { Cons args000 = ((Cons)(args));

          { boolean testValue000 = false;

            testValue000 = (Stella_Object.consP(args000.value) &&
                (((args000.length()) % 2) == 0)) ||
                ((!Stella_Object.consP(args000.value)) &&
                 (((args000.length()) % 2) == 1));
            if (testValue000) {
              { boolean alwaysP000 = true;

                { Stella_Object arg = null;
                  Cons iter000 = args000.rest;

                  loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                    arg = iter000.value;
                    if (!(!Stella_Object.consP(arg))) {
                      alwaysP000 = false;
                      break loop000;
                    }
                  }
                }
                testValue000 = alwaysP000;
              }
            }
            if (!(testValue000)) {
              { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    stream001.nativeStream.println("PARSING ERROR: Fetch-EDB-query: illegal pattern arguments: `" + arguments + "'.");
                    Logic.helpSignalPropositionError(stream001, RDBMS.KWD_ERROR);

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                  }
                }
                throw ((ParsingError)(ParsingError.newParsingError(stream001.theStringReader()).fillInStackTrace()));
              }
            }
          }
          cursor = args000;
          if (Stella_Object.consP(cursor.value)) {
            { Stella_Object outarg = null;
              Cons iter001 = ((Cons)(cursor.value));
              Cons collect000 = null;

              for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                outarg = iter001.value;
                if (collect000 == null) {
                  {
                    collect000 = Cons.cons(StringWrapper.wrapString(Stella_Object.coerceToString(outarg)), Stella.NIL);
                    if (outputargs == Stella.NIL) {
                      outputargs = collect000;
                    }
                    else {
                      Cons.addConsToEndOfConsList(outputargs, collect000);
                    }
                  }
                }
                else {
                  {
                    collect000.rest = Cons.cons(StringWrapper.wrapString(Stella_Object.coerceToString(outarg)), Stella.NIL);
                    collect000 = collect000.rest;
                  }
                }
              }
            }
            cursor = cursor.rest;
          }
          else {
            outputargs = RDBMS.getTableColumnNames(Logic.getDescription(((Surrogate)(proposition.operator))));
            if (outputargs == null) {
              { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    stream002.nativeStream.println("PARSING ERROR: Fetch-EDB-query: missing output arg/column specifications for: `" + Logic.getDescription(((Surrogate)(proposition.operator))) + "'.");
                    Logic.helpSignalPropositionError(stream002, RDBMS.KWD_ERROR);

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
                  }
                }
                throw ((ParsingError)(ParsingError.newParsingError(stream002.theStringReader()).fillInStackTrace()));
              }
            }
          }
          queryid = Stella_Object.coerceToString(cursor.value);
          cursor = cursor.rest;
          parameters = cursor;
          while (!(cursor == Stella.NIL)) {
            cursor.firstSetter(StringWrapper.wrapString(Stella_Object.coerceToString(cursor.value)));
            parametervalue = cursor.rest.value;
            if (Logic.questionMarkSymbolP(parametervalue)) {
              { Stella_Object value000 = null;

                { Stella_Object arg = null;
                  Vector vector000 = proposition.arguments;
                  int index000 = 0;
                  int length000 = vector000.length();
                  Symbol var = null;
                  Cons iter002 = Logic.getDescription(((Surrogate)(proposition.operator))).ioVariableNames.theConsList;

                  loop003 : for (;(index000 < length000) &&
                            (!(iter002 == Stella.NIL)); index000 = index000 + 1, iter002 = iter002.rest) {
                    arg = (vector000.theArray)[index000];
                    var = ((Symbol)(iter002.value));
                    if (var == parametervalue) {
                      value000 = arg;
                      break loop003;
                    }
                  }
                }
                parametervalue = value000;
              }
              if (parametervalue == null) {
                { OutputStringStream stream003 = OutputStringStream.newOutputStringStream();

                  { Object old$PrintreadablyP$003 = Stella.$PRINTREADABLYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      stream003.nativeStream.println("PARSING ERROR: Fetch-EDB-query: non-existent input variable: `" + cursor.rest.value + "'.");
                      Logic.helpSignalPropositionError(stream003, RDBMS.KWD_ERROR);

                    } finally {
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$003);
                    }
                  }
                  throw ((ParsingError)(ParsingError.newParsingError(stream003.theStringReader()).fillInStackTrace()));
                }
              }
              cursor.rest.firstSetter(parametervalue);
            }
            else {
              cursor.rest.firstSetter(StringWrapper.wrapString(Stella_Object.coerceToString(parametervalue)));
            }
            cursor = cursor.rest.rest;
          }
        }
      }
      else {
        { OutputStringStream stream004 = OutputStringStream.newOutputStringStream();

          { Object old$PrintreadablyP$004 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              stream004.nativeStream.println("PARSING ERROR: Fetch-EDB-query: illegal pattern arguments: `" + arguments + "'.");
              Logic.helpSignalPropositionError(stream004, RDBMS.KWD_ERROR);

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$004);
            }
          }
          throw ((ParsingError)(ParsingError.newParsingError(stream004.theStringReader()).fillInStackTrace()));
        }
      }
      { PropertyList self010 = PropertyList.newPropertyList();

        self010.thePlist = parameters;
        { PropertyList value001 = self010;

          { String _return_temp = queryid;

            MV_returnarray[0] = outputargs;
            MV_returnarray[1] = value001;
            return (_return_temp);
          }
        }
      }
    }
  }

  public static Iterator helpMemoizeFetchEdbQuery(Proposition proposition, LogicObject database, Stella_Object arguments) {
    { String queryid = null;
      Cons outputargs = Stella.NIL;
      PropertyList parameters = null;
      NamedDescription relation = Logic.getDescription(((Surrogate)(proposition.operator)));
      OutputStringStream params = OutputStringStream.newOutputStringStream();

      { Object [] caller_MV_returnarray = new Object[2];

        queryid = RDBMS.normalizeFetchQueryArguments(proposition, arguments, caller_MV_returnarray);
        outputargs = ((Cons)(caller_MV_returnarray[0]));
        parameters = ((PropertyList)(caller_MV_returnarray[1]));
      }
      { Stella_Object key = null;
        Stella_Object value = null;
        Cons iter000 = parameters.thePlist;
        int i = Stella.NULL_INTEGER;
        int iter001 = 1;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest, iter001 = iter001 + 1) {
          key = iter000.value;
          value = iter000.rest.value;
          i = iter001;
          if ((key == null) ||
              (value == null)) {
            return (null);
          }
          if (i > 1) {
            params.nativeStream.print("&");
          }
          params.nativeStream.print(StringWrapper.unwrapString(((StringWrapper)(key))));
          value = Logic.argumentBoundTo(value);
          if (value == null) {
            return (null);
          }
          params.nativeStream.print("=" + RDBMS.coercePowerloomObjectToString(value, null));
        }
      }
      { String temp000 = StringWrapper.unwrapString(((StringWrapper)(Logic.accessBinaryValue(database, RDBMS.SGT_RDBMS_HOST))));

        { int temp001 = IntegerWrapper.unwrapInteger(((IntegerWrapper)(Logic.accessBinaryValue(database, RDBMS.SGT_RDBMS_PORT))));

          { String temp002 = StringWrapper.unwrapString(((StringWrapper)(Logic.accessBinaryValue(database, RDBMS.SGT_RDBMS_TASK_ID))));

            { String temp003 = StringWrapper.unwrapString(((StringWrapper)(Logic.accessBinaryValue(database, RDBMS.SGT_RDBMS_SUBTASK_ID))));

              { String temp004 = StringWrapper.unwrapString(((StringWrapper)(Logic.accessBinaryValue(database, RDBMS.SGT_RDBMS_DB_NAME))));

                { ConsIterator value000 = RDBMS.parseFetchXmlAnswer(((Cons)(RDBMS.runFetchQuery(((temp000 != null) ? temp000 : "pegasus2.isi.edu"), ((temp001 != Stella.NULL_INTEGER) ? temp001 : 8080), queryid, ((temp002 != null) ? temp002 : "TASK"), ((temp003 != null) ? temp003 : "SUBTASK"), ((temp004 != null) ? temp004 : "EELD-DATABASE"), params.theStringReader()))), relation, outputargs).allocateIterator();

                  return (value000);
                }
              }
            }
          }
        }
      }
    }
  }

  public static Iterator fetchEdbQuery(Proposition proposition, LogicObject database, Stella_Object arguments) {
    RDBMS.checkForExternalDbUpdates(proposition, database);
    { MemoizationTable memoTable000 = null;
      Cons memoizedEntry000 = null;
      Stella_Object memoizedValue000 = null;

      if (Stella.$MEMOIZATION_ENABLEDp$) {
        memoTable000 = ((MemoizationTable)(RDBMS.SGT_RDBMS_F_FETCH_EDB_QUERY_MEMO_TABLE_000.surrogateValue));
        if (memoTable000 == null) {
          Surrogate.initializeMemoizationTable(RDBMS.SGT_RDBMS_F_FETCH_EDB_QUERY_MEMO_TABLE_000, "(:MAX-VALUES 10000 :TIMESTAMPS (:META-KB-UPDATE :EXTERNAL-DB-UPDATE))");
          memoTable000 = ((MemoizationTable)(RDBMS.SGT_RDBMS_F_FETCH_EDB_QUERY_MEMO_TABLE_000.surrogateValue));
        }
        memoizedEntry000 = MruMemoizationTable.lookupMruMemoizedValue(((MruMemoizationTable)(memoTable000)), RDBMS.getQueryPatternMemoizationKey(proposition), ((Context)(Stella.$CONTEXT$.get())), (((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue() ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.MEMOIZED_NULL_VALUE, 6);
        memoizedValue000 = memoizedEntry000.value;
      }
      if (memoizedValue000 != null) {
        if (memoizedValue000 == Stella.MEMOIZED_NULL_VALUE) {
          memoizedValue000 = null;
        }
      }
      else {
        memoizedValue000 = MemoizableIterator.newMemoizableIterator(RDBMS.helpMemoizeFetchEdbQuery(proposition, database, arguments));
        if (Stella.$MEMOIZATION_ENABLEDp$) {
          memoizedEntry000.value = ((memoizedValue000 == null) ? Stella.MEMOIZED_NULL_VALUE : memoizedValue000);
        }
      }
      { Iterator value000 = MemoizableIterator.cloneMemoizedIterator(((MemoizableIterator)(memoizedValue000)));

        return (((Iterator)(value000)));
      }
    }
  }

  public static Cons parseFetchXmlAnswer(Cons xmlanswer, NamedDescription relation, Cons outputcolumns) {
    { Cons tuples = Stella.NIL;

      if (!(Stella_Object.isaP(xmlanswer.value, RDBMS.SGT_STELLA_XML_ELEMENT) &&
          (Stella.stringEqlP(((XmlElement)(xmlanswer.value)).name, "PlanExecution") &&
           Stella.stringEqlP(((XmlElement)(xmlanswer.value)).namespaceUri, null)))) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Fetch-EDB-query Error: Didn't find a Fetch Answer in `" + xmlanswer + "'");
        return (Stella.NIL);
      }
      { Stella_Object answer = null;
        Cons iter000 = xmlanswer.rest.rest;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          answer = iter000.value;
          if (Stella_Object.isaP(answer, RDBMS.SGT_STELLA_CONS) &&
              Stella_Object.isaP(((Cons)(answer)).value, RDBMS.SGT_STELLA_XML_ELEMENT)) {
            { XmlElement item000 = ((XmlElement)(((Cons)(answer)).value));

              if (Stella.stringEqlP(item000.name, "OBJECT") &&
                  Stella.stringEqlP(item000.namespaceUri, null)) {
                tuples = Cons.cons(RDBMS.parseOneFetchXmlObject(((Cons)(answer)).rest.rest, relation, outputcolumns), tuples);
              }
              else if (Stella.stringEqlP(item000.name, "Error") &&
                  Stella.stringEqlP(item000.namespaceUri, null)) {
                { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                  stream000.nativeStream.print("`" + StringWrapper.unwrapString(((StringWrapper)(((Cons)(answer)).rest.rest.value))) + "'");
                  throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                }
              }
              else if (Stella.stringEqlP(item000.name, "ERROR") &&
                  Stella.stringEqlP(item000.namespaceUri, null)) {
                { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                  stream001.nativeStream.print("`" + StringWrapper.unwrapString(((StringWrapper)(((Cons)(answer)).rest.rest.value))) + "'");
                  throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
                }
              }
            }
          }
        }
      }
      return (tuples.reverse());
    }
  }

  public static Cons parseOneFetchXmlObject(Cons renamed_Object, NamedDescription relation, Cons outputcolumns) {
    { Cons tuple = Stella.NIL;

      { StringWrapper column = null;
        Cons iter000 = outputcolumns;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          column = ((StringWrapper)(iter000.value));
          { Stella_Object item = null;
            Cons iter001 = renamed_Object;

            for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              item = iter001.value;
              if (Stella_Object.eqlToStringP(column, ((XmlElement)(((Cons)(item)).value)).name)) {
                tuple = Cons.cons(((Cons)(item)).rest.rest.value, tuple);
                if (!(((Cons)(item)).rest.rest.rest == Stella.NIL)) {
                  Stella.STANDARD_WARNING.nativeStream.println("Warning: Extra elements found in `" + item + "'");
                }
              }
            }
          }
        }
      }
      tuple = tuple.reverse();
      return (RDBMS.coerceValues(tuple, RDBMS.getRelationTableInfo(relation)));
    }
  }

  public static void startFetchEdbGateway(int port) {
    { String lispforms = "#+:aserve\n    (CL:progn\n      (CL:defun handle-fetch-query (request entity)\n        (net.aserve:with-http-response (request entity)\n          (net.aserve:with-http-body (request entity)\n            (CL:case (net.aserve:request-method request)\n              (:get\n               (CL:let ((query (net.aserve:request-query request\n                                                         :uri CL:t\n                                                         :post CL:nil))\n                        (keys (stella::new-key-value-list)))\n                 (CL:loop for (key . value) in query\n                     do (stella::insert-at\n                         keys\n                         (stella::wrap-string (CL:string key))\n                         (stella::wrap-string value)))\n                 (evaluate-fetch-query\n                  keys (net.aserve:request-reply-stream request))))\n              (CL:t\n               (CL:format (net.aserve:request-reply-stream request) \n                          \"Error occurred:<BR>~%Unhandled request method ~S\"\n                          (net.aserve:request-method request)))))))\n      (CL:defun start-fetch-EDB-servlet (port)\n        (CL:compile 'handle-fetch-query)\n        (net.aserve:publish :path \"/ploom/fetch-EDB-query\"\n                            :content-type \"text/html\"\n                            :function 'handle-fetch-query)\n        (net.aserve:start :port port)))\n    #-:aserve ()";

    }
  }

  public static void evaluateFetchQuery(KeyValueList keys, edu.isi.stella.javalib.NativeOutputStream out) {
    try {
      { Module temp000 = Stella.getStellaModule("EELD-EDB", false);

        { Module mdl000 = ((temp000 != null) ? temp000 : ((Module)(Stella.$MODULE$.get())));
          Context cxt000 = mdl000;

          if (mdl000 == null) {
            mdl000 = ((Module)(Stella.$MODULE$.get()));
            cxt000 = ((Context)(Stella.$CONTEXT$.get()));
          }
          { Object old$Module$000 = Stella.$MODULE$.get();
            Object old$Context$000 = Stella.$CONTEXT$.get();

            try {
              Native.setSpecial(Stella.$MODULE$, mdl000);
              Native.setSpecial(Stella.$CONTEXT$, cxt000);
              synchronized (Logic.$POWERLOOM_LOCK$) {
                { Stella_Object secondarydbname = keys.lookup(StringWrapper.wrapString("sdatabase"));
                  Stella_Object fetchdb = Stella_Object.get(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("fetch-edb")))), Stella.NIL);
                  Stella_Object taskid = keys.lookup(StringWrapper.wrapString("task"));
                  Stella_Object subtaskid = keys.lookup(StringWrapper.wrapString("subtask"));
                  Stella_Object command = keys.lookup(StringWrapper.wrapString("command"));
                  Stella_Object result = null;

                  { OutputStream self000 = OutputStream.newOutputStream();

                    self000.nativeStream = out;
                    { OutputStream wrappedout = self000;

                      if (fetchdb != null) {
                        if (secondarydbname != null) {
                          edu.isi.powerloom.PLI.assertNaryProposition(Cons.cons(Logic.getRelation(RDBMS.SGT_RDBMS_DB_NAME), Cons.cons(fetchdb, Cons.cons(secondarydbname, Stella.NIL))), null, null);
                        }
                        if (taskid != null) {
                          edu.isi.powerloom.PLI.assertNaryProposition(Cons.cons(Logic.getRelation(RDBMS.SGT_RDBMS_TASK_ID), Cons.cons(fetchdb, Cons.cons(taskid, Stella.NIL))), null, null);
                        }
                        if (subtaskid != null) {
                          edu.isi.powerloom.PLI.assertNaryProposition(Cons.cons(Logic.getRelation(RDBMS.SGT_RDBMS_SUBTASK_ID), Cons.cons(fetchdb, Cons.cons(subtaskid, Stella.NIL))), null, null);
                        }
                      }
                      result = Logic.evaluateLogicCommand(Stella.readSExpressionFromString(((StringWrapper)(command)).wrapperValue), true);
                      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(result), RDBMS.SGT_LOGIC_QUERY_ITERATOR)) {
                        { QueryIterator result000 = ((QueryIterator)(result));

                          { QuerySolution solution = null;
                            DictionaryIterator iter000 = ((DictionaryIterator)(result000.solutions.allocateIterator()));

                            while (iter000.nextP()) {
                              solution = ((QuerySolution)(iter000.value));
                              { Stella_Object elt = null;
                                Vector vector000 = solution.bindings;
                                int index000 = 0;
                                int length000 = vector000.length();
                                int i = Stella.NULL_INTEGER;
                                int iter001 = 0;

                                for (;index000 < length000; index000 = index000 + 1, iter001 = iter001 + 1) {
                                  elt = (vector000.theArray)[index000];
                                  i = iter001;
                                  if (i > 0) {
                                    out.print(" ");
                                  }
                                  Logic.printLogicalForm(elt, wrappedout);
                                }
                              }
                              out.print("<br>");
                            }
                          }
                        }
                      }
                      else {
                        Stella.writeHtmlQuotingSpecialCharacters(out, Native.stringify(result));
                      }
                    }
                  }
                }
              }

            } finally {
              Stella.$CONTEXT$.set(old$Context$000);
              Stella.$MODULE$.set(old$Module$000);
            }
          }
        }
      }
    } catch (java.lang.Exception e) {
      out.print("ERROR: " + Stella.exceptionMessage(e));
    }
  }

  public static Cons buildOneTableAssertion(NamedDescription tableRelation, Cons tuple, Module dbModule) {
    { Cons assertion = Stella.NIL;
      int colno = -1;

      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = tableRelation.arity();
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;
        Cons collect000 = null;

        for (;unboundedP000 ||
                  (iter000 <= upperBound000); iter000 = iter000 + 1) {
          i = iter000;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Stella.NULL_STRING_WRAPPER, Stella.NIL);
              if (assertion == Stella.NIL) {
                assertion = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(assertion, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Stella.NULL_STRING_WRAPPER, Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      { Stella_Object item = null;
        Cons iter001 = tuple;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          item = iter001.value;
          colno = RDBMS.getTableColumnIndex(tableRelation, ((XmlElement)(((Cons)(item)).value)).name, dbModule);
          if (colno < 0) {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Couldn't find column number for `" + item + "' on relation `" + tableRelation + "'");
          }
          else {
            assertion.nthSetter(((Cons)(item)).rest.rest.value, colno);
          }
          if (!(((Cons)(item)).rest.rest.rest == Stella.NIL)) {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Extra elements found in `" + item + "'");
          }
        }
      }
      { Stella_Object item = null;
        Cons iter002 = assertion.rest;

        loop002 : for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
          item = iter002.value;
          if (StringWrapper.unwrapString(((StringWrapper)(item))) == null) {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Some table relation values not set: `" + assertion + "'");
            break loop002;
          }
        }
      }
      assertion.rest = RDBMS.coerceValues(((Cons)(assertion.rest)), RDBMS.getRelationTableInfo(tableRelation));
      assertion.nthSetter(tableRelation, 0);
      return (assertion);
    }
  }

  /** Takes a Stella-parsed, XML-encoded <code>xmlAnswer</code> from Fetch based on
   * the database table <code>tableName</code> and uses it to generate an assertion
   * for an appropriate relation for inclusion in <code>module</code>.  The database
   * meta information is found in <code>dbModule</code>.
   * @param tableName
   * @param xmlAnswer
   * @param module
   * @param dbModule
   * @return Cons
   */
  public static Cons generateTableAssertions(String tableName, Cons xmlAnswer, Module module, Module dbModule) {
    { NamedDescription tableRelation = RDBMS.getTableRelation(tableName, dbModule);
      Cons assertions = Stella.NIL;

      if (!(Stella_Object.isaP(xmlAnswer.value, RDBMS.SGT_STELLA_XML_ELEMENT) &&
          (Stella.stringEqlP(((XmlElement)(xmlAnswer.value)).name, "PlanExecution") &&
           Stella.stringEqlP(((XmlElement)(xmlAnswer.value)).namespaceUri, null)))) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Didn't find a Fetch Answer in `" + xmlAnswer + "'");
        return (Stella.NIL);
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, module);
          Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
          { Stella_Object answer = null;
            Cons iter000 = xmlAnswer.rest.rest;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              answer = iter000.value;
              if (Stella_Object.isaP(answer, RDBMS.SGT_STELLA_CONS) &&
                  Stella_Object.isaP(((Cons)(answer)).value, RDBMS.SGT_STELLA_XML_ELEMENT)) {
                { XmlElement item000 = ((XmlElement)(((Cons)(answer)).value));

                  if (Stella.stringEqlP(item000.name, "OBJECT") &&
                      Stella.stringEqlP(item000.namespaceUri, null)) {
                    assertions = Cons.cons(RDBMS.buildOneTableAssertion(tableRelation, ((Cons)(answer)).rest.rest, dbModule), assertions);
                  }
                  else if (Stella.stringEqlP(item000.name, "Error") &&
                      Stella.stringEqlP(item000.namespaceUri, null)) {
                    { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                      stream000.nativeStream.print("`" + ((StringWrapper)(((Cons)(answer)).rest.rest.value)).wrapperValue + "'");
                      throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                    }
                  }
                  else if (Stella.stringEqlP(item000.name, "ERROR") &&
                      Stella.stringEqlP(item000.namespaceUri, null)) {
                    { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                      stream001.nativeStream.print("`" + ((StringWrapper)(((Cons)(answer)).rest.rest.value)).wrapperValue + "'");
                      throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
                    }
                  }
                }
              }
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
      return (assertions);
    }
  }

  public static String lookupStringValue(NamedDescription relation, LogicObject instance, Module mod) {
    { edu.isi.powerloom.PlIterator iter = edu.isi.powerloom.PLI.retrieve(Cons.list$(Cons.cons(IntegerWrapper.wrapInteger(1), Cons.cons(Cons.cons(Logic.objectName(relation), Cons.cons(instance, Cons.cons(RDBMS.SYM_LOGIC_pX, Stella.NIL))), Cons.cons(Stella.NIL, Stella.NIL)))), mod, null);

      if (iter.nextP()) {
        return (((StringWrapper)(iter.value)).wrapperValue);
      }
      else {
        return (null);
      }
    }
  }

  /** Runs a <code>fetchQuery</code> using <code>taskId</code>; <code>subtaskId</code>,<code>database</code>
   * and specifying a single additional <code>parameterValue</code>.  The connection
   * is made to a remote http query server running on <code>host</code> port number <code>port</code>.
   * Returns a set of assertions for <code>targetModule</code> using the information in <code>dbModule</code>
   * to find the appropriate relations.
   * @param host
   * @param port
   * @param fetchQuery
   * @param taskId
   * @param subtaskId
   * @param database
   * @param parameterValue
   * @param targetModule
   * @param dbModule
   * @return Cons
   */
  public static Cons fetchQueryAssertions(String host, int port, LogicObject fetchQuery, String taskId, String subtaskId, String database, String parameterValue, Module targetModule, Module dbModule) {
    { String dbTable = RDBMS.lookupStringValue(((NamedDescription)(edu.isi.powerloom.PLI.getRelation("QUERY-TABLE-NAME", dbModule, null))), fetchQuery, dbModule);
      String parameterName = RDBMS.lookupStringValue(((NamedDescription)(edu.isi.powerloom.PLI.getRelation("QUERY-PARAMETER-NAME", dbModule, null))), fetchQuery, dbModule);
      Stella_Object fetchAnswer = RDBMS.runFetchQuery(host, port, Logic.objectName(fetchQuery).symbolName, taskId, subtaskId, database, parameterName + "=" + parameterValue);

      return (RDBMS.generateTableAssertions(dbTable, ((Cons)(fetchAnswer)), targetModule, dbModule));
    }
  }

}
