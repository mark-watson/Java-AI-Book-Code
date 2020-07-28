//  -*- Mode: Java -*-
//
// QuerySolutionTable.java

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

package edu.isi.powerloom.logic;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.stella.*;

/** Special key/value map for query solutions indexed by output
 * variable binding vectors that also preserves the order of solution generation.
 * @author Stella Java Translator
 */
public class QuerySolutionTable extends Dictionary {
    public KeyValueMap theMap;
    public QueryIterator query;
    public QuerySolution first;
    public QuerySolution last;

  public static QuerySolutionTable newQuerySolutionTable() {
    { QuerySolutionTable self = null;

      self = new QuerySolutionTable();
      self.last = null;
      self.first = null;
      self.query = null;
      { KeyValueMap self000 = KeyValueMap.newKeyValueMap();

        self000.equalTestP = true;
        self.theMap = self000;
      }
      return (self);
    }
  }

  public AbstractIterator allocateIterator() {
    { QuerySolutionTable self = this;

      { QuerySolutionTableIterator self000 = QuerySolutionTableIterator.newQuerySolutionTableIterator();

        self000.theTable = self;
        { QuerySolutionTableIterator value000 = self000;

          return (value000);
        }
      }
    }
  }

  /** Perform a stable, destructive sort of <code>self</code> according to
   * <code>predicate</code>, and return the result.  If <code>predicate</code> has a '&lt;' semantics, the
   * result will be in ascending order.
   * @param predicate
   * @return QuerySolutionTable
   */
  public QuerySolutionTable sort(java.lang.reflect.Method predicate) {
    { QuerySolutionTable self = this;

      { java.lang.reflect.Method thepredicate = ((predicate != null) ? predicate : Native.find_java_method("edu.isi.powerloom.logic.QuerySolution", "querySolutionLessThanP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.QuerySolution"), Native.find_java_class("edu.isi.powerloom.logic.QuerySolution")}));
        Cons solutions = self.consify().sort(thepredicate);
        QuerySolution current = null;
        QuerySolution next = null;

        self.first = ((QuerySolution)(solutions.value));
        self.last = ((QuerySolution)(solutions.value));
        loop000 : for (;;) {
          current = ((QuerySolution)(solutions.value));
          if (current != null) {
            next = ((QuerySolution)(solutions.rest.value));
            current.next = next;
            if (next == null) {
              self.last = current;
            }
            solutions = solutions.rest;
          }
          else {
            break loop000;
          }
        }
        return (self);
      }
    }
  }

  /** Collect all solutions of <code>self</code> into a cons list and return the result.
   * @return Cons
   */
  public Cons consify() {
    { QuerySolutionTable self = this;

      { Cons result = Stella.NIL;

        { QuerySolution solution = null;
          DictionaryIterator iter000 = ((DictionaryIterator)(self.allocateIterator()));
          Cons collect000 = null;

          while (iter000.nextP()) {
            solution = ((QuerySolution)(iter000.value));
            if (collect000 == null) {
              {
                collect000 = Cons.cons(solution, Stella.NIL);
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
                collect000.rest = Cons.cons(solution, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        return (result);
      }
    }
  }

  public void clear() {
    { QuerySolutionTable self = this;

      self.theMap.clear();
      self.first = null;
      self.last = null;
    }
  }

  /** Return the nth solution in <code>self</code>, or NULL if it is empty.
   * @param position
   * @return QuerySolution
   */
  public QuerySolution nth(int position) {
    { QuerySolutionTable self = this;

      { QuerySolution solution = null;
        DictionaryIterator iter000 = ((DictionaryIterator)(self.allocateIterator()));

        while (iter000.nextP()) {
          solution = ((QuerySolution)(iter000.value));
          if (position == 0) {
            return (solution);
          }
          else {
            position = position - 1;
          }
        }
      }
      return (null);
    }
  }

  /** Return TRUE if <code>self</code> has at least 1 entry.
   * @return boolean
   */
  public boolean nonEmptyP() {
    { QuerySolutionTable self = this;

      return (self.theMap.nonEmptyP());
    }
  }

  /** Return TRUE if <code>self</code> has zero entries.
   * @return boolean
   */
  public boolean emptyP() {
    { QuerySolutionTable self = this;

      return (self.theMap.emptyP());
    }
  }

  /** Return the number of entries in <code>self</code>.
   * @return int
   */
  public int length() {
    { QuerySolutionTable self = this;

      return (self.theMap.length());
    }
  }

  /** Remove and return the first solution of <code>self</code> or NULL
   * if the table is empty.
   * @return QuerySolution
   */
  public QuerySolution pop() {
    { QuerySolutionTable self = this;

      { QuerySolution first = self.first;

        if (first != null) {
          self.first = first.next;
          if (first == self.last) {
            self.last = null;
          }
          self.theMap.removeAt(first.bindings);
        }
        return (first);
      }
    }
  }

  /** Remove the solution identified by <code>key</code> from <code>self</code>.
   * To preserve the solution ordering chain, the solution is marked as deleted
   * and will be completely removed upon the next iteration through <code>self</code>.
   * @param key
   */
  public void removeAt(Vector key) {
    { QuerySolutionTable self = this;

      { KeyValueMap map = self.theMap;
        QuerySolution solution = ((QuerySolution)(map.lookup(key)));

        if (solution != null) {
          map.removeAt(key);
          solution.deletedPSetter(true);
        }
      }
    }
  }

  /** Insert <code>value</code> identified by <code>key</code> into <code>self</code>.  If a solution
   * with that key already exists, destructively modify it with the slot values of
   * <code>value</code>.  This is necessary to preserve the order of solutions in <code>self</code>.
   * @param key
   * @param value
   */
  public void insertAt(Vector key, QuerySolution value) {
    { QuerySolutionTable self = this;

      { KeyValueMap map = self.theMap;
        QuerySolution duplicate = ((QuerySolution)(map.lookup(key)));

        if (duplicate != null) {
          duplicate.truthValue = value.truthValue;
          duplicate.matchScore = value.matchScore;
          duplicate.justification = value.justification;
          duplicate.allJustifications = value.allJustifications;
        }
        else {
          map.insertAt(key, value);
          if (self.first == null) {
            self.first = value;
            self.last = value;
          }
          else {
            self.last.next = value;
            self.last = value;
          }
        }
      }
    }
  }

  /** Lookup the solution identified by <code>key</code> in <code>self</code> and
   * return its value, or NULL if no such solution exists.
   * @param key
   * @return Stella_Object
   */
  public Stella_Object lookup(Vector key) {
    { QuerySolutionTable self = this;

      return (((QuerySolution)(self.theMap.lookup(key))));
    }
  }

  public static Stella_Object accessQuerySolutionTableSlotValue(QuerySolutionTable self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_STELLA_THE_MAP) {
      if (setvalueP) {
        self.theMap = ((KeyValueMap)(value));
      }
      else {
        value = self.theMap;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_QUERY) {
      if (setvalueP) {
        self.query = ((QueryIterator)(value));
      }
      else {
        value = self.query;
      }
    }
    else if (slotname == Logic.SYM_STELLA_FIRST) {
      if (setvalueP) {
        self.first = ((QuerySolution)(value));
      }
      else {
        value = self.first;
      }
    }
    else if (slotname == Logic.SYM_STELLA_LAST) {
      if (setvalueP) {
        self.last = ((QuerySolution)(value));
      }
      else {
        value = self.last;
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
    { QuerySolutionTable self = this;

      return (Logic.SGT_LOGIC_QUERY_SOLUTION_TABLE);
    }
  }

}

