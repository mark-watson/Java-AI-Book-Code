//  -*- Mode: Java -*-
//
// MarkerTable.java

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

/** Used to record (mark) a set of objects.
 * Can be optimized for testing only, or also for recall.
 * @author Stella Java Translator
 */
public class MarkerTable extends StandardObject {
    public HashTable testTable;
    public List recallTable;
    public boolean supportsRecallP;

  public static MarkerTable newMarkerTable() {
    { MarkerTable self = null;

      self = new MarkerTable();
      self.supportsRecallP = false;
      self.recallTable = null;
      self.testTable = null;
      return (self);
    }
  }

  /** Return an iterator that generates all marked objects
   * recorded in 'self'.
   * @return ListIterator
   */
  public ListIterator recallMarkedObjects() {
    { MarkerTable self = this;

      return (((ListIterator)(self.recallTable.allocateIterator())));
    }
  }

  /** Return TRUE if 'object' is stored (marked) in 'self'.
   * @param renamed_Object
   * @return boolean
   */
  public boolean testMarkerP(Stella_Object renamed_Object) {
    { MarkerTable self = this;

      return (self.testTable.lookup(renamed_Object) != null);
    }
  }

  /** Record membership of 'object' in the marker
   * storage object 'self'.
   * @param renamed_Object
   */
  public void setMarker(Stella_Object renamed_Object) {
    { MarkerTable self = this;

      if (self.supportsRecallP) {
        if (self.testTable.lookup(renamed_Object) == null) {
          self.testTable.insertAt(renamed_Object, Stella.TRUE_WRAPPER);
          self.recallTable.push(renamed_Object);
        }
      }
      else {
        self.testTable.insertAt(renamed_Object, Stella.TRUE_WRAPPER);
      }
    }
  }

  public static Stella_Object accessMarkerTableSlotValue(MarkerTable self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_TEST_TABLE) {
      if (setvalueP) {
        self.testTable = ((HashTable)(value));
      }
      else {
        value = self.testTable;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_RECALL_TABLE) {
      if (setvalueP) {
        self.recallTable = ((List)(value));
      }
      else {
        value = self.recallTable;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_SUPPORTS_RECALLp) {
      if (setvalueP) {
        self.supportsRecallP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.supportsRecallP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
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
    { MarkerTable self = this;

      return (Logic.SGT_LOGIC_MARKER_TABLE);
    }
  }

}

