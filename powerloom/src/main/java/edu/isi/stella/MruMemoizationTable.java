//  -*- Mode: Java -*-
//
// MruMemoizationTable.java

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

public class MruMemoizationTable extends MemoizationTable {
    public Vector mruBucketsVector;
    public Vector lruBucketsVector;
    public edu.isi.stella.Stella_Object[] mruBuckets;
    public edu.isi.stella.Stella_Object[] lruBuckets;
    public Cons mruTimestamp;
    public Cons lruTimestamp;
    public int nofBuckets;
    public int freeEntries;
    public int maxEntries;

  public static MruMemoizationTable newMruMemoizationTable() {
    { MruMemoizationTable self = null;

      self = new MruMemoizationTable();
      self.timestamps = Stella.NIL;
      self.currentTimestamp = null;
      self.tableName = null;
      self.hashTable = null;
      self.maxEntries = Stella.NULL_INTEGER;
      self.freeEntries = Stella.NULL_INTEGER;
      self.nofBuckets = Stella.NULL_INTEGER;
      self.lruTimestamp = null;
      self.mruTimestamp = null;
      self.lruBuckets = null;
      self.mruBuckets = null;
      self.lruBucketsVector = null;
      self.mruBucketsVector = null;
      return (self);
    }
  }

  public static Cons lookupMruMemoizedValuen(MruMemoizationTable memotable, Cons args, int eqvector) {
    { edu.isi.stella.Stella_Object[] mrubuckets = memotable.mruBuckets;
      edu.isi.stella.Stella_Object[] lrubuckets = null;
      Cons mrubucket = Stella.NIL;
      Cons lrubucket = Stella.NIL;
      Cons mrutimestamp = null;
      int hashcode = 0;
      int bucketindex = 0;
      Cons entry = null;

      if (mrubuckets == null) {
        MruMemoizationTable.initializeMruBucketTables(memotable);
        mrubuckets = memotable.mruBuckets;
      }
      mrutimestamp = memotable.mruTimestamp;
      if (!(memotable.currentTimestamp == mrutimestamp)) {
        mrutimestamp = memotable.currentTimestamp;
        memotable.mruTimestamp = mrutimestamp;
        memotable.lruTimestamp = mrutimestamp;
        memotable.freeEntries = memotable.maxEntries;
      }
      hashcode = Cons.hashMemoizedArgumentsn(args, eqvector);
      bucketindex = ((hashcode & 0x7FFFFFFF) % (memotable.nofBuckets));
      mrubucket = ((Cons)(mrubuckets[bucketindex]));
      if (mrubucket != null) {
        if (((Cons)(mrubucket.value)) == mrutimestamp) {
          entry = Cons.findMemoizedValueEntryn(mrubucket, args, eqvector, false);
          if (entry != null) {
            return (entry);
          }
        }
        else {
          mrubucket.value = mrutimestamp;
          mrubucket.rest = Stella.NIL;
        }
      }
      lrubuckets = memotable.lruBuckets;
      lrubucket = ((Cons)(lrubuckets[bucketindex]));
      if (lrubucket != null) {
        if (((Cons)(lrubucket.value)) == memotable.lruTimestamp) {
          entry = Cons.findMemoizedValueEntryn(lrubucket, args, eqvector, true);
        }
        else {
          lrubucket.rest = Stella.NIL;
        }
      }
      if (entry == null) {
        entry = Cons.cons(null, args);
      }
      if (mrubucket != null) {
        mrubucket.rest = Cons.cons(entry, mrubucket.rest);
      }
      else {
        mrubuckets[bucketindex] = (Cons.cons(mrutimestamp, Cons.cons(entry, Stella.NIL)));
      }
      if ((memotable.freeEntries = memotable.freeEntries - 1) == 0) {
        memotable.mruBuckets = lrubuckets;
        memotable.lruBuckets = mrubuckets;
        memotable.mruTimestamp = Cons.cons(null, Stella.NIL);
        memotable.currentTimestamp = memotable.mruTimestamp;
        memotable.lruTimestamp = mrutimestamp;
        memotable.freeEntries = memotable.maxEntries;
      }
      return (entry);
    }
  }

  public static Cons lookupMruMemoizedValue(MruMemoizationTable memotable, Stella_Object arg1, Stella_Object arg2, Stella_Object arg3, Stella_Object arg4, int eqvector) {
    { edu.isi.stella.Stella_Object[] mrubuckets = memotable.mruBuckets;
      edu.isi.stella.Stella_Object[] lrubuckets = null;
      Cons mrubucket = Stella.NIL;
      Cons lrubucket = Stella.NIL;
      Cons mrutimestamp = null;
      int hashcode = 0;
      int bucketindex = 0;
      Cons entry = null;

      if (mrubuckets == null) {
        MruMemoizationTable.initializeMruBucketTables(memotable);
        mrubuckets = memotable.mruBuckets;
      }
      mrutimestamp = memotable.mruTimestamp;
      if (!(memotable.currentTimestamp == mrutimestamp)) {
        mrutimestamp = memotable.currentTimestamp;
        memotable.mruTimestamp = mrutimestamp;
        memotable.lruTimestamp = mrutimestamp;
        memotable.freeEntries = memotable.maxEntries;
      }
      hashcode = Stella_Object.hashMemoizedArguments(arg1, arg2, arg3, arg4, eqvector);
      bucketindex = ((hashcode & 0x7FFFFFFF) % (memotable.nofBuckets));
      mrubucket = ((Cons)(mrubuckets[bucketindex]));
      if (mrubucket != null) {
        if (((Cons)(mrubucket.value)) == mrutimestamp) {
          entry = Cons.findMemoizedValueEntry(mrubucket, arg1, arg2, arg3, arg4, eqvector, false);
          if (entry != null) {
            return (entry);
          }
        }
        else {
          mrubucket.value = mrutimestamp;
          mrubucket.rest = Stella.NIL;
        }
      }
      lrubuckets = memotable.lruBuckets;
      lrubucket = ((Cons)(lrubuckets[bucketindex]));
      if (lrubucket != null) {
        if (((Cons)(lrubucket.value)) == memotable.lruTimestamp) {
          entry = Cons.findMemoizedValueEntry(lrubucket, arg1, arg2, arg3, arg4, eqvector, true);
        }
        else {
          lrubucket.rest = Stella.NIL;
        }
      }
      if (entry == null) {
        entry = Stella_Object.makeMemoizedValueEntry(null, arg1, arg2, arg3, arg4);
      }
      if (mrubucket != null) {
        mrubucket.rest = Cons.cons(entry, mrubucket.rest);
      }
      else {
        mrubuckets[bucketindex] = (Cons.cons(mrutimestamp, Cons.cons(entry, Stella.NIL)));
      }
      if ((memotable.freeEntries = memotable.freeEntries - 1) == 0) {
        memotable.mruBuckets = lrubuckets;
        memotable.lruBuckets = mrubuckets;
        memotable.mruTimestamp = Cons.cons(null, Stella.NIL);
        memotable.currentTimestamp = memotable.mruTimestamp;
        memotable.lruTimestamp = mrutimestamp;
        memotable.freeEntries = memotable.maxEntries;
      }
      return (entry);
    }
  }

  public static void initializeMruBucketTables(MruMemoizationTable memotable) {
    memotable.nofBuckets = Stella.pickHashTableSizePrime(memotable.maxEntries);
    memotable.mruBucketsVector = Vector.newVector(memotable.nofBuckets);
    memotable.lruBucketsVector = Vector.newVector(memotable.nofBuckets);
    memotable.mruBuckets = memotable.mruBucketsVector.theArray;
    memotable.lruBuckets = memotable.lruBucketsVector.theArray;
    memotable.freeEntries = memotable.maxEntries;
    memotable.currentTimestamp = Cons.cons(null, Stella.NIL);
    memotable.mruTimestamp = memotable.currentTimestamp;
    memotable.lruTimestamp = memotable.currentTimestamp;
  }

  public static Stella_Object accessMruMemoizationTableSlotValue(MruMemoizationTable self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_MRU_BUCKETS_VECTOR) {
      if (setvalueP) {
        self.mruBucketsVector = ((Vector)(value));
      }
      else {
        value = self.mruBucketsVector;
      }
    }
    else if (slotname == Stella.SYM_STELLA_LRU_BUCKETS_VECTOR) {
      if (setvalueP) {
        self.lruBucketsVector = ((Vector)(value));
      }
      else {
        value = self.lruBucketsVector;
      }
    }
    else if (slotname == Stella.SYM_STELLA_MRU_TIMESTAMP) {
      if (setvalueP) {
        self.mruTimestamp = ((Cons)(value));
      }
      else {
        value = self.mruTimestamp;
      }
    }
    else if (slotname == Stella.SYM_STELLA_LRU_TIMESTAMP) {
      if (setvalueP) {
        self.lruTimestamp = ((Cons)(value));
      }
      else {
        value = self.lruTimestamp;
      }
    }
    else if (slotname == Stella.SYM_STELLA_NOF_BUCKETS) {
      if (setvalueP) {
        self.nofBuckets = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.nofBuckets);
      }
    }
    else if (slotname == Stella.SYM_STELLA_FREE_ENTRIES) {
      if (setvalueP) {
        self.freeEntries = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.freeEntries);
      }
    }
    else if (slotname == Stella.SYM_STELLA_MAX_ENTRIES) {
      if (setvalueP) {
        self.maxEntries = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.maxEntries);
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
    { MruMemoizationTable self = this;

      return (Stella.SGT_STELLA_MRU_MEMOIZATION_TABLE);
    }
  }

}

