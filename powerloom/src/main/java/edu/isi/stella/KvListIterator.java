//  -*- Mode: Java -*-
//
// KvListIterator.java

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

public class KvListIterator extends DictionaryIterator {
    public KeyValueList theKvList;
    public KvCons kvListIteratorCursor;

  public static KvListIterator newKvListIterator() {
    { KvListIterator self = null;

      self = new KvListIterator();
      self.firstIterationP = true;
      self.value = null;
      self.key = null;
      self.kvListIteratorCursor = null;
      self.theKvList = null;
      return (self);
    }
  }

  public Stella_Object keySetter(Stella_Object key) {
    { KvListIterator self = this;

      self.kvListIteratorCursor.key = key;
      self.key = key;
      return (key);
    }
  }

  public Stella_Object valueSetter(Stella_Object value) {
    { KvListIterator self = this;

      self.kvListIteratorCursor.value = value;
      self.value = value;
      return (value);
    }
  }

  public boolean nextP() {
    { KvListIterator self = this;

      if (self.firstIterationP) {
        self.firstIterationP = false;
      }
      else {
        self.kvListIteratorCursor = self.kvListIteratorCursor.rest;
      }
      if (self.kvListIteratorCursor == null) {
        return (false);
      }
      self.key = self.kvListIteratorCursor.key;
      self.value = self.kvListIteratorCursor.value;
      return (true);
    }
  }

  public static Stella_Object accessKvListIteratorSlotValue(KvListIterator self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_THE_KV_LIST) {
      if (setvalueP) {
        self.theKvList = ((KeyValueList)(value));
      }
      else {
        value = self.theKvList;
      }
    }
    else if (slotname == Stella.SYM_STELLA_KV_LIST_ITERATOR_CURSOR) {
      if (setvalueP) {
        self.kvListIteratorCursor = ((KvCons)(value));
      }
      else {
        value = self.kvListIteratorCursor;
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
    { KvListIterator self = this;

      return (Stella.SGT_STELLA_KV_LIST_ITERATOR);
    }
  }

}

