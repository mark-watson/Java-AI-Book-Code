//  -*- Mode: Java -*-
//
// SequenceIndexIterator.java

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

/** Iterator that generates successive members of a sequence index.
 * @author Stella Java Translator
 */
public class SequenceIndexIterator extends Iterator {
    public Cons listIteratorCursor;

  public static SequenceIndexIterator newSequenceIndexIterator() {
    { SequenceIndexIterator self = null;

      self = new SequenceIndexIterator();
      self.firstIterationP = true;
      self.value = null;
      self.listIteratorCursor = null;
      return (self);
    }
  }

  public boolean emptyP() {
    { SequenceIndexIterator self = this;

      return (self.listIteratorCursor == Stella.NIL);
    }
  }

  public boolean nextP() {
    { SequenceIndexIterator self = this;

      { Cons cursor = self.listIteratorCursor;
        Stella_Object value = null;

        for (;;) {
          if (cursor == Stella.NIL) {
            return (false);
          }
          value = cursor.value;
          if (!value.deletedP()) {
            self.value = value;
            self.listIteratorCursor = cursor.rest;
            return (true);
          }
          cursor = cursor.rest;
        }
      }
    }
  }

  public static Stella_Object accessSequenceIndexIteratorSlotValue(SequenceIndexIterator self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_STELLA_LIST_ITERATOR_CURSOR) {
      if (setvalueP) {
        self.listIteratorCursor = ((Cons)(value));
      }
      else {
        value = self.listIteratorCursor;
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
    { SequenceIndexIterator self = this;

      return (Logic.SGT_LOGIC_SEQUENCE_INDEX_ITERATOR);
    }
  }

}

