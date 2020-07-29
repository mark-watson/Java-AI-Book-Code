//  -*- Mode: Java -*-
//
// IntegerIntervalIterator.java

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

package edu.isi.stella;

import edu.isi.stella.javalib.*;

public class IntegerIntervalIterator extends IntervalIterator {
    public int intervalCursor;
    public int lowerBound;
    public int upperBound;
    /** The current value of this iterator
     */
    public int value;

  public static IntegerIntervalIterator newIntegerIntervalIterator(int lowerBound, int upperBound) {
    { IntegerIntervalIterator self = null;

      self = new IntegerIntervalIterator();
      self.lowerBound = lowerBound;
      self.upperBound = upperBound;
      self.firstIterationP = true;
      self.value = Stella.NULL_INTEGER;
      self.intervalCursor = Stella.NULL_INTEGER;
      self.initializeIntegerIntervalIterator();
      return (self);
    }
  }

  public ReverseIntegerIntervalIterator reverse() {
    { IntegerIntervalIterator self = this;

      return (Stella.reverseInterval(self.lowerBound, self.upperBound));
    }
  }

  public boolean nextP() {
    { IntegerIntervalIterator self = this;

      if (self.firstIterationP) {
        self.firstIterationP = false;
      }
      else {
        self.intervalCursor = self.intervalCursor + 1;
      }
      { int upperbound = self.upperBound;

        self.value = self.intervalCursor;
        return ((upperbound == Stella.NULL_INTEGER) ||
            (self.intervalCursor <= upperbound));
      }
    }
  }

  public void initializeIntegerIntervalIterator() {
    { IntegerIntervalIterator self = this;

      self.intervalCursor = self.lowerBound;
      self.firstIterationP = true;
    }
  }

  public static Stella_Object accessIntegerIntervalIteratorSlotValue(IntegerIntervalIterator self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_INTERVAL_CURSOR) {
      if (setvalueP) {
        self.intervalCursor = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.intervalCursor);
      }
    }
    else if (slotname == Stella.SYM_STELLA_LOWER_BOUND) {
      if (setvalueP) {
        self.lowerBound = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.lowerBound);
      }
    }
    else if (slotname == Stella.SYM_STELLA_UPPER_BOUND) {
      if (setvalueP) {
        self.upperBound = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.upperBound);
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
    { IntegerIntervalIterator self = this;

      return (Stella.SGT_STELLA_INTEGER_INTERVAL_ITERATOR);
    }
  }

}

