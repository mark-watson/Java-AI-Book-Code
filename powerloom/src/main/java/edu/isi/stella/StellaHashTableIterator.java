//  -*- Mode: Java -*-
//
// StellaHashTableIterator.java

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

/** Iterator class for STELLA-HASH-TABLE's.  The only modifying
 * operations allowed during iteration are removal of the current element or
 * changing its value.  All other removal or insertion operations might lead
 * to corruption or undefined results.
 * @author Stella Java Translator
 */
public class StellaHashTableIterator extends DictionaryIterator {
    public int size;
    public KvCons[] bucketTable;
    public int bucketIndex;
    public KvCons bucketCursor;

  public static StellaHashTableIterator newStellaHashTableIterator() {
    { StellaHashTableIterator self = null;

      self = new StellaHashTableIterator();
      self.firstIterationP = true;
      self.value = null;
      self.key = null;
      self.bucketCursor = null;
      self.bucketIndex = 0;
      self.bucketTable = null;
      self.size = Stella.NULL_INTEGER;
      return (self);
    }
  }

  public Stella_Object keySetter(Stella_Object key) {
    { StellaHashTableIterator self = this;

      throw ((StellaException)(StellaException.newStellaException("Cannot change the key of a STELLA-HASH-TABLE item").fillInStackTrace()));
    }
  }

  public Stella_Object valueSetter(Stella_Object value) {
    { StellaHashTableIterator self = this;

      { KvCons cursor = self.bucketCursor;

        if (cursor != null) {
          cursor.value = value;
        }
        self.value = value;
        return (value);
      }
    }
  }

  public boolean nextP() {
    { StellaHashTableIterator self = this;

      { KvCons cursor = self.bucketCursor;

        if (self.firstIterationP) {
          self.firstIterationP = false;
        }
        else if (cursor != null) {
          cursor = cursor.rest;
        }
        if (cursor == null) {
          { KvCons[] table = self.bucketTable;
            int index = self.bucketIndex;
            int size = self.size;

            if (table == null) {
              return (false);
            }
            while ((cursor == null) &&
                (index < size)) {
              cursor = table[index];
              index = index + 1;
            }
            self.bucketIndex = index;
            self.bucketCursor = cursor;
          }
        }
        if (cursor != null) {
          self.key = cursor.key;
          self.value = cursor.value;
          self.bucketCursor = cursor;
          return (true);
        }
        else {
          return (false);
        }
      }
    }
  }

  public static Stella_Object accessStellaHashTableIteratorSlotValue(StellaHashTableIterator self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_SIZE) {
      if (setvalueP) {
        self.size = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.size);
      }
    }
    else if (slotname == Stella.SYM_STELLA_BUCKET_INDEX) {
      if (setvalueP) {
        self.bucketIndex = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.bucketIndex);
      }
    }
    else if (slotname == Stella.SYM_STELLA_BUCKET_CURSOR) {
      if (setvalueP) {
        self.bucketCursor = ((KvCons)(value));
      }
      else {
        value = self.bucketCursor;
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
    { StellaHashTableIterator self = this;

      return (Stella.SGT_STELLA_STELLA_HASH_TABLE_ITERATOR);
    }
  }

}

