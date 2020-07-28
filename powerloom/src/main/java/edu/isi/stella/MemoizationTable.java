//  -*- Mode: Java -*-
//
// MemoizationTable.java

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

/** Table that maps argument values onto computed results for
 * one individual memoization site.
 * @author Stella Java Translator
 */
public class MemoizationTable extends StandardObject {
    /** The table holding the memoized values.
     * We use an integer table, since we explicitly compute a hash code by combining
     * hash codes of argument values.
     */
    public IntegerHashTable hashTable;
    /** The surrogate used to point to this table.
     * Used at the memoization site for quick memo table lookup.
     */
    public Surrogate tableName;
    /** Marker value used to indicate valid memoized entries.
     * This marker changes everytime one of the <code>timestamps</code> gets bumped.
     */
    public Cons currentTimestamp;
    /** Names of timestamps that trigger invalidation of
     * memoized entries when they get bumped.
     */
    public Cons timestamps;

  public static MemoizationTable newMemoizationTable() {
    { MemoizationTable self = null;

      self = new MemoizationTable();
      self.timestamps = Stella.NIL;
      self.currentTimestamp = null;
      self.tableName = null;
      self.hashTable = null;
      return (self);
    }
  }

  public static Cons lookupMemoizedValuen(MemoizationTable memotable, Cons args, int eqvector) {
    { IntegerHashTable hashtable = memotable.hashTable;
      Cons timestamp = null;
      int hashcode = 0;
      Cons entry = Stella.NIL;
      Cons bucket = Stella.NIL;

      if (hashtable == null) {
        hashtable = IntegerHashTable.newIntegerHashTable();
        memotable.hashTable = hashtable;
        memotable.currentTimestamp = Cons.cons(null, Stella.NIL);
      }
      timestamp = memotable.currentTimestamp;
      hashcode = Cons.hashMemoizedArgumentsn(args, eqvector);
      bucket = ((Cons)(hashtable.lookup(hashcode)));
      if (bucket != null) {
        if (((Cons)(bucket.value)) == timestamp) {
          entry = Cons.findMemoizedValueEntryn(bucket, args, eqvector, false);
          if (entry != null) {
            return (entry);
          }
        }
        else {
          bucket.value = timestamp;
          bucket.rest = Stella.NIL;
        }
      }
      entry = Cons.cons(null, args);
      if (bucket != null) {
        bucket.rest = Cons.cons(entry, bucket.rest);
      }
      else {
        hashtable.insertAt(hashcode, Cons.cons(timestamp, Cons.cons(entry, Stella.NIL)));
      }
      return (entry);
    }
  }

  public static Cons lookupMemoizedValue(MemoizationTable memotable, Stella_Object arg1, Stella_Object arg2, Stella_Object arg3, Stella_Object arg4, int eqvector) {
    { IntegerHashTable hashtable = memotable.hashTable;
      Cons timestamp = null;
      int hashcode = 0;
      Cons entry = Stella.NIL;
      Cons bucket = Stella.NIL;

      if (hashtable == null) {
        hashtable = IntegerHashTable.newIntegerHashTable();
        memotable.hashTable = hashtable;
        memotable.currentTimestamp = Cons.cons(null, Stella.NIL);
      }
      timestamp = memotable.currentTimestamp;
      hashcode = Stella_Object.hashMemoizedArguments(arg1, arg2, arg3, arg4, eqvector);
      bucket = ((Cons)(hashtable.lookup(hashcode)));
      if (bucket != null) {
        if (((Cons)(bucket.value)) == timestamp) {
          entry = Cons.findMemoizedValueEntry(bucket, arg1, arg2, arg3, arg4, eqvector, false);
          if (entry != null) {
            return (entry);
          }
        }
        else {
          bucket.value = timestamp;
          bucket.rest = Stella.NIL;
        }
      }
      entry = Stella_Object.makeMemoizedValueEntry(null, arg1, arg2, arg3, arg4);
      if (bucket != null) {
        bucket.rest = Cons.cons(entry, bucket.rest);
      }
      else {
        hashtable.insertAt(hashcode, Cons.cons(timestamp, Cons.cons(entry, Stella.NIL)));
      }
      return (entry);
    }
  }

  public static Stella_Object accessMemoizationTableSlotValue(MemoizationTable self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_HASH_TABLE) {
      if (setvalueP) {
        self.hashTable = ((IntegerHashTable)(value));
      }
      else {
        value = self.hashTable;
      }
    }
    else if (slotname == Stella.SYM_STELLA_TABLE_NAME) {
      if (setvalueP) {
        self.tableName = ((Surrogate)(value));
      }
      else {
        value = self.tableName;
      }
    }
    else if (slotname == Stella.SYM_STELLA_CURRENT_TIMESTAMP) {
      if (setvalueP) {
        self.currentTimestamp = ((Cons)(value));
      }
      else {
        value = self.currentTimestamp;
      }
    }
    else if (slotname == Stella.SYM_STELLA_TIMESTAMPS) {
      if (setvalueP) {
        self.timestamps = ((Cons)(value));
      }
      else {
        value = self.timestamps;
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
    { MemoizationTable self = this;

      return (Stella.SGT_STELLA_MEMOIZATION_TABLE);
    }
  }

}

