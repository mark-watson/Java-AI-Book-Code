//  -*- Mode: Java -*-
//
// QuerySolution.java

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

public class QuerySolution extends StandardObject {
    public Vector bindings;
    public TruthValue truthValue;
    public double matchScore;
    public Justification justification;
    /** All recorded justifications for
     * this solution in case we have multiple ones from a partial match operation.
     */
    public List allJustifications;
    public QuerySolution next;

  public static QuerySolution newQuerySolution() {
    { QuerySolution self = null;

      self = new QuerySolution();
      self.next = null;
      self.allJustifications = null;
      self.justification = null;
      self.matchScore = Stella.NULL_FLOAT;
      self.truthValue = null;
      self.bindings = null;
      return (self);
    }
  }

  public static boolean solutionScoreGreaterThanP(QuerySolution s1, QuerySolution s2) {
    return (s1.matchScore > s2.matchScore);
  }

  public static boolean querySolutionGreaterThanP(QuerySolution x, QuerySolution y) {
    return (QuerySolution.querySolutionLessThanP(y, x));
  }

  public static boolean querySolutionLessThanP(QuerySolution x, QuerySolution y) {
    { Stella_Object xbinding = null;
      Vector vector000 = x.bindings;
      int index000 = 0;
      int length000 = vector000.length();
      Stella_Object ybinding = null;
      Vector vector001 = y.bindings;
      int index001 = 0;
      int length001 = vector001.length();

      loop000 : for (;(index000 < length000) &&
                (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
        xbinding = (vector000.theArray)[index000];
        ybinding = (vector001.theArray)[index001];
        if (Stella_Object.eqlP(xbinding, ybinding)) {
          continue loop000;
        }
        else if (Logic.logicFormLessP(xbinding, ybinding)) {
          return (true);
        }
        else {
          return (false);
        }
      }
    }
    return (false);
  }

  public boolean deletedPSetter(boolean value) {
    { QuerySolution self = this;

      if (value) {
        self.bindings = null;
      }
      else {
        self.bindings = Stella.vector(Stella.NIL);
      }
      return (value);
    }
  }

  public boolean deletedP() {
    { QuerySolution self = this;

      return (self.bindings == null);
    }
  }

  public static Stella_Object accessQuerySolutionSlotValue(QuerySolution self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_BINDINGS) {
      if (setvalueP) {
        self.bindings = ((Vector)(value));
      }
      else {
        value = self.bindings;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_TRUTH_VALUE) {
      if (setvalueP) {
        self.truthValue = ((TruthValue)(value));
      }
      else {
        value = self.truthValue;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_MATCH_SCORE) {
      if (setvalueP) {
        self.matchScore = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.matchScore);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_JUSTIFICATION) {
      if (setvalueP) {
        self.justification = ((Justification)(value));
      }
      else {
        value = self.justification;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_BEST_JUSTIFICATION) {
      if (setvalueP) {
        self.justification = ((Justification)(value));
      }
      else {
        value = self.justification;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_ALL_JUSTIFICATIONS) {
      if (setvalueP) {
        self.allJustifications = ((List)(value));
      }
      else {
        value = self.allJustifications;
      }
    }
    else if (slotname == Logic.SYM_STELLA_NEXT) {
      if (setvalueP) {
        self.next = ((QuerySolution)(value));
      }
      else {
        value = self.next;
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
    { QuerySolution self = this;

      return (Logic.SGT_LOGIC_QUERY_SOLUTION);
    }
  }

}

